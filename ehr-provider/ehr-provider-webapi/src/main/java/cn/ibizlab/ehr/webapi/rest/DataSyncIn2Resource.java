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
import cn.ibizlab.ehr.core.common.domain.DataSyncIn2;
import cn.ibizlab.ehr.core.common.service.IDataSyncIn2Service;
import cn.ibizlab.ehr.core.common.filter.DataSyncIn2SearchContext;




@Slf4j
@Api(tags = {"DataSyncIn2" })
@RestController("WebApi-datasyncin2")
@RequestMapping("")
public class DataSyncIn2Resource {

    @Autowired
    private IDataSyncIn2Service datasyncin2Service;

    @Autowired
    @Lazy
    public DataSyncIn2Mapping datasyncin2Mapping;

    public DataSyncIn2DTO permissionDTO=new DataSyncIn2DTO();

    @PreAuthorize("hasPermission(#datasyncin2_id,'Remove',{'Sql',this.datasyncin2Mapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"DataSyncIn2" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/datasyncin2s/{datasyncin2_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("datasyncin2_id") String datasyncin2_id) {
         return ResponseEntity.status(HttpStatus.OK).body(datasyncin2Service.remove(datasyncin2_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"DataSyncIn2" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/datasyncin2s/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        datasyncin2Service.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-DataSyncIn2-Save-all')")
    @ApiOperation(value = "Save", tags = {"DataSyncIn2" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/datasyncin2s/save")
    public ResponseEntity<Boolean> save(@RequestBody DataSyncIn2DTO datasyncin2dto) {
        return ResponseEntity.status(HttpStatus.OK).body(datasyncin2Service.save(datasyncin2Mapping.toDomain(datasyncin2dto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"DataSyncIn2" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/datasyncin2s/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<DataSyncIn2DTO> datasyncin2dtos) {
        datasyncin2Service.saveBatch(datasyncin2Mapping.toDomain(datasyncin2dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-DataSyncIn2-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"DataSyncIn2" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/datasyncin2s/getdraft")
    public ResponseEntity<DataSyncIn2DTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(datasyncin2Mapping.toDto(datasyncin2Service.getDraft(new DataSyncIn2())));
    }

    @PreAuthorize("hasPermission(#datasyncin2_id,'Update',{'Sql',this.datasyncin2Mapping,#datasyncin2dto})")
    @ApiOperation(value = "Update", tags = {"DataSyncIn2" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/datasyncin2s/{datasyncin2_id}")
    @Transactional
    public ResponseEntity<DataSyncIn2DTO> update(@PathVariable("datasyncin2_id") String datasyncin2_id, @RequestBody DataSyncIn2DTO datasyncin2dto) {
		DataSyncIn2 domain = datasyncin2Mapping.toDomain(datasyncin2dto);
        domain.setDatasyncin2id(datasyncin2_id);
		datasyncin2Service.update(domain);
		DataSyncIn2DTO dto = datasyncin2Mapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"DataSyncIn2" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/datasyncin2s/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<DataSyncIn2DTO> datasyncin2dtos) {
        datasyncin2Service.updateBatch(datasyncin2Mapping.toDomain(datasyncin2dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#datasyncin2_id,'Get',{'Sql',this.datasyncin2Mapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"DataSyncIn2" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/datasyncin2s/{datasyncin2_id}")
    public ResponseEntity<DataSyncIn2DTO> get(@PathVariable("datasyncin2_id") String datasyncin2_id) {
        DataSyncIn2 domain = datasyncin2Service.get(datasyncin2_id);
        DataSyncIn2DTO dto = datasyncin2Mapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.datasyncin2Mapping,#datasyncin2dto})")
    @ApiOperation(value = "Create", tags = {"DataSyncIn2" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/datasyncin2s")
    @Transactional
    public ResponseEntity<DataSyncIn2DTO> create(@RequestBody DataSyncIn2DTO datasyncin2dto) {
        DataSyncIn2 domain = datasyncin2Mapping.toDomain(datasyncin2dto);
		datasyncin2Service.create(domain);
        DataSyncIn2DTO dto = datasyncin2Mapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"DataSyncIn2" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/datasyncin2s/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<DataSyncIn2DTO> datasyncin2dtos) {
        datasyncin2Service.createBatch(datasyncin2Mapping.toDomain(datasyncin2dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-DataSyncIn2-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"DataSyncIn2" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/datasyncin2s/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody DataSyncIn2DTO datasyncin2dto) {
        return  ResponseEntity.status(HttpStatus.OK).body(datasyncin2Service.checkKey(datasyncin2Mapping.toDomain(datasyncin2dto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-DataSyncIn2-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"DataSyncIn2" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/datasyncin2s/fetchdefault")
	public ResponseEntity<List<DataSyncIn2DTO>> fetchDefault(DataSyncIn2SearchContext context) {
        Page<DataSyncIn2> domains = datasyncin2Service.searchDefault(context) ;
        List<DataSyncIn2DTO> list = datasyncin2Mapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-DataSyncIn2-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"DataSyncIn2" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/datasyncin2s/searchdefault")
	public ResponseEntity<Page<DataSyncIn2DTO>> searchDefault(@RequestBody DataSyncIn2SearchContext context) {
        Page<DataSyncIn2> domains = datasyncin2Service.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(datasyncin2Mapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
