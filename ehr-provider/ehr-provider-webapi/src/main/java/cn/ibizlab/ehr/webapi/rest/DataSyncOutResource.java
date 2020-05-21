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
import cn.ibizlab.ehr.core.common.domain.DataSyncOut;
import cn.ibizlab.ehr.core.common.service.IDataSyncOutService;
import cn.ibizlab.ehr.core.common.filter.DataSyncOutSearchContext;




@Slf4j
@Api(tags = {"DataSyncOut" })
@RestController("WebApi-datasyncout")
@RequestMapping("")
public class DataSyncOutResource {

    @Autowired
    private IDataSyncOutService datasyncoutService;

    @Autowired
    @Lazy
    public DataSyncOutMapping datasyncoutMapping;

    public DataSyncOutDTO permissionDTO=new DataSyncOutDTO();




    @PreAuthorize("hasPermission(#datasyncout_id,'Remove',{'Sql',this.datasyncoutMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"DataSyncOut" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/datasyncouts/{datasyncout_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("datasyncout_id") String datasyncout_id) {
         return ResponseEntity.status(HttpStatus.OK).body(datasyncoutService.remove(datasyncout_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"DataSyncOut" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/datasyncouts/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        datasyncoutService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-DataSyncOut-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"DataSyncOut" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/datasyncouts/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody DataSyncOutDTO datasyncoutdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(datasyncoutService.checkKey(datasyncoutMapping.toDomain(datasyncoutdto)));
    }




    @PreAuthorize("hasPermission(#datasyncout_id,'Get',{'Sql',this.datasyncoutMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"DataSyncOut" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/datasyncouts/{datasyncout_id}")
    public ResponseEntity<DataSyncOutDTO> get(@PathVariable("datasyncout_id") String datasyncout_id) {
        DataSyncOut domain = datasyncoutService.get(datasyncout_id);
        DataSyncOutDTO dto = datasyncoutMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.datasyncoutMapping,#datasyncoutdto})")
    @ApiOperation(value = "Create", tags = {"DataSyncOut" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/datasyncouts")
    @Transactional
    public ResponseEntity<DataSyncOutDTO> create(@RequestBody DataSyncOutDTO datasyncoutdto) {
        DataSyncOut domain = datasyncoutMapping.toDomain(datasyncoutdto);
		datasyncoutService.create(domain);
        DataSyncOutDTO dto = datasyncoutMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"DataSyncOut" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/datasyncouts/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<DataSyncOutDTO> datasyncoutdtos) {
        datasyncoutService.createBatch(datasyncoutMapping.toDomain(datasyncoutdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#datasyncout_id,'Update',{'Sql',this.datasyncoutMapping,#datasyncoutdto})")
    @ApiOperation(value = "Update", tags = {"DataSyncOut" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/datasyncouts/{datasyncout_id}")
    @Transactional
    public ResponseEntity<DataSyncOutDTO> update(@PathVariable("datasyncout_id") String datasyncout_id, @RequestBody DataSyncOutDTO datasyncoutdto) {
		DataSyncOut domain = datasyncoutMapping.toDomain(datasyncoutdto);
        domain.setDatasyncoutid(datasyncout_id);
		datasyncoutService.update(domain);
		DataSyncOutDTO dto = datasyncoutMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"DataSyncOut" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/datasyncouts/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<DataSyncOutDTO> datasyncoutdtos) {
        datasyncoutService.updateBatch(datasyncoutMapping.toDomain(datasyncoutdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-DataSyncOut-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"DataSyncOut" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/datasyncouts/getdraft")
    public ResponseEntity<DataSyncOutDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(datasyncoutMapping.toDto(datasyncoutService.getDraft(new DataSyncOut())));
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-DataSyncOut-Save-all')")
    @ApiOperation(value = "Save", tags = {"DataSyncOut" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/datasyncouts/save")
    public ResponseEntity<Boolean> save(@RequestBody DataSyncOutDTO datasyncoutdto) {
        return ResponseEntity.status(HttpStatus.OK).body(datasyncoutService.save(datasyncoutMapping.toDomain(datasyncoutdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"DataSyncOut" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/datasyncouts/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<DataSyncOutDTO> datasyncoutdtos) {
        datasyncoutService.saveBatch(datasyncoutMapping.toDomain(datasyncoutdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-DataSyncOut-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"DataSyncOut" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/datasyncouts/fetchdefault")
	public ResponseEntity<List<DataSyncOutDTO>> fetchDefault(DataSyncOutSearchContext context) {
        Page<DataSyncOut> domains = datasyncoutService.searchDefault(context) ;
        List<DataSyncOutDTO> list = datasyncoutMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-DataSyncOut-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"DataSyncOut" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/datasyncouts/searchdefault")
	public ResponseEntity<Page<DataSyncOutDTO>> searchDefault(@RequestBody DataSyncOutSearchContext context) {
        Page<DataSyncOut> domains = datasyncoutService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(datasyncoutMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


