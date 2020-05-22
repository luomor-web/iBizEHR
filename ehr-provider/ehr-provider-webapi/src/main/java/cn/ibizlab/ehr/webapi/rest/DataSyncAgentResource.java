package cn.ibizlab.ehr.webapi.rest;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;

import lombok.extern.slf4j.Slf4j;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.access.prepost.PreAuthorize;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import cn.ibizlab.ehr.webapi.dto.*;
import cn.ibizlab.ehr.webapi.mapping.*;
import cn.ibizlab.ehr.core.common.domain.DataSyncAgent;
import cn.ibizlab.ehr.core.common.service.IDataSyncAgentService;
import cn.ibizlab.ehr.core.common.filter.DataSyncAgentSearchContext;




@Slf4j
@Api(tags = {"DataSyncAgent" })
@RestController("WebApi-datasyncagent")
@RequestMapping("")
public class DataSyncAgentResource {

    @Autowired
    private IDataSyncAgentService datasyncagentService;

    @Autowired
    @Lazy
    public DataSyncAgentMapping datasyncagentMapping;

    public DataSyncAgentDTO permissionDTO=new DataSyncAgentDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-DataSyncAgent-Save-all')")
    @ApiOperation(value = "Save", tags = {"DataSyncAgent" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/datasyncagents/save")
    public ResponseEntity<Boolean> save(@RequestBody DataSyncAgentDTO datasyncagentdto) {
        return ResponseEntity.status(HttpStatus.OK).body(datasyncagentService.save(datasyncagentMapping.toDomain(datasyncagentdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"DataSyncAgent" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/datasyncagents/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<DataSyncAgentDTO> datasyncagentdtos) {
        datasyncagentService.saveBatch(datasyncagentMapping.toDomain(datasyncagentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.datasyncagentMapping,#datasyncagentdto})")
    @ApiOperation(value = "Create", tags = {"DataSyncAgent" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/datasyncagents")
    @Transactional
    public ResponseEntity<DataSyncAgentDTO> create(@RequestBody DataSyncAgentDTO datasyncagentdto) {
        DataSyncAgent domain = datasyncagentMapping.toDomain(datasyncagentdto);
		datasyncagentService.create(domain);
        DataSyncAgentDTO dto = datasyncagentMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"DataSyncAgent" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/datasyncagents/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<DataSyncAgentDTO> datasyncagentdtos) {
        datasyncagentService.createBatch(datasyncagentMapping.toDomain(datasyncagentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-DataSyncAgent-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"DataSyncAgent" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/datasyncagents/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody DataSyncAgentDTO datasyncagentdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(datasyncagentService.checkKey(datasyncagentMapping.toDomain(datasyncagentdto)));
    }

    @PreAuthorize("hasPermission(#datasyncagent_id,'Update',{'Sql',this.datasyncagentMapping,#datasyncagentdto})")
    @ApiOperation(value = "Update", tags = {"DataSyncAgent" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/datasyncagents/{datasyncagent_id}")
    @Transactional
    public ResponseEntity<DataSyncAgentDTO> update(@PathVariable("datasyncagent_id") String datasyncagent_id, @RequestBody DataSyncAgentDTO datasyncagentdto) {
		DataSyncAgent domain = datasyncagentMapping.toDomain(datasyncagentdto);
        domain.setDatasyncagentid(datasyncagent_id);
		datasyncagentService.update(domain);
		DataSyncAgentDTO dto = datasyncagentMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"DataSyncAgent" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/datasyncagents/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<DataSyncAgentDTO> datasyncagentdtos) {
        datasyncagentService.updateBatch(datasyncagentMapping.toDomain(datasyncagentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#datasyncagent_id,'Remove',{'Sql',this.datasyncagentMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"DataSyncAgent" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/datasyncagents/{datasyncagent_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("datasyncagent_id") String datasyncagent_id) {
         return ResponseEntity.status(HttpStatus.OK).body(datasyncagentService.remove(datasyncagent_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"DataSyncAgent" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/datasyncagents/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        datasyncagentService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-DataSyncAgent-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"DataSyncAgent" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/datasyncagents/getdraft")
    public ResponseEntity<DataSyncAgentDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(datasyncagentMapping.toDto(datasyncagentService.getDraft(new DataSyncAgent())));
    }

    @PreAuthorize("hasPermission(#datasyncagent_id,'Get',{'Sql',this.datasyncagentMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"DataSyncAgent" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/datasyncagents/{datasyncagent_id}")
    public ResponseEntity<DataSyncAgentDTO> get(@PathVariable("datasyncagent_id") String datasyncagent_id) {
        DataSyncAgent domain = datasyncagentService.get(datasyncagent_id);
        DataSyncAgentDTO dto = datasyncagentMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-DataSyncAgent-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"DataSyncAgent" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/datasyncagents/fetchdefault")
	public ResponseEntity<List<DataSyncAgentDTO>> fetchDefault(DataSyncAgentSearchContext context) {
        Page<DataSyncAgent> domains = datasyncagentService.searchDefault(context) ;
        List<DataSyncAgentDTO> list = datasyncagentMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-DataSyncAgent-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"DataSyncAgent" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/datasyncagents/searchdefault")
	public ResponseEntity<Page<DataSyncAgentDTO>> searchDefault(@RequestBody DataSyncAgentSearchContext context) {
        Page<DataSyncAgent> domains = datasyncagentService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(datasyncagentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
