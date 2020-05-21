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
import cn.ibizlab.ehr.core.sal.domain.SALLOG;
import cn.ibizlab.ehr.core.sal.service.ISALLOGService;
import cn.ibizlab.ehr.core.sal.filter.SALLOGSearchContext;




@Slf4j
@Api(tags = {"SALLOG" })
@RestController("WebApi-sallog")
@RequestMapping("")
public class SALLOGResource {

    @Autowired
    private ISALLOGService sallogService;

    @Autowired
    @Lazy
    public SALLOGMapping sallogMapping;

    public SALLOGDTO permissionDTO=new SALLOGDTO();




    @PreAuthorize("hasPermission(#sallog_id,'Get',{'Sql',this.sallogMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"SALLOG" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/sallogs/{sallog_id}")
    public ResponseEntity<SALLOGDTO> get(@PathVariable("sallog_id") String sallog_id) {
        SALLOG domain = sallogService.get(sallog_id);
        SALLOGDTO dto = sallogMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#sallog_id,'Update',{'Sql',this.sallogMapping,#sallogdto})")
    @ApiOperation(value = "Update", tags = {"SALLOG" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/sallogs/{sallog_id}")
    @Transactional
    public ResponseEntity<SALLOGDTO> update(@PathVariable("sallog_id") String sallog_id, @RequestBody SALLOGDTO sallogdto) {
		SALLOG domain = sallogMapping.toDomain(sallogdto);
        domain.setSallogid(sallog_id);
		sallogService.update(domain);
		SALLOGDTO dto = sallogMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"SALLOG" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/sallogs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SALLOGDTO> sallogdtos) {
        sallogService.updateBatch(sallogMapping.toDomain(sallogdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#sallog_id,'Remove',{'Sql',this.sallogMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"SALLOG" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sallogs/{sallog_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("sallog_id") String sallog_id) {
         return ResponseEntity.status(HttpStatus.OK).body(sallogService.remove(sallog_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"SALLOG" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sallogs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        sallogService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.sallogMapping,#sallogdto})")
    @ApiOperation(value = "Create", tags = {"SALLOG" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/sallogs")
    @Transactional
    public ResponseEntity<SALLOGDTO> create(@RequestBody SALLOGDTO sallogdto) {
        SALLOG domain = sallogMapping.toDomain(sallogdto);
		sallogService.create(domain);
        SALLOGDTO dto = sallogMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"SALLOG" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/sallogs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SALLOGDTO> sallogdtos) {
        sallogService.createBatch(sallogMapping.toDomain(sallogdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALLOG-Save-all')")
    @ApiOperation(value = "Save", tags = {"SALLOG" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/sallogs/save")
    public ResponseEntity<Boolean> save(@RequestBody SALLOGDTO sallogdto) {
        return ResponseEntity.status(HttpStatus.OK).body(sallogService.save(sallogMapping.toDomain(sallogdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"SALLOG" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/sallogs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SALLOGDTO> sallogdtos) {
        sallogService.saveBatch(sallogMapping.toDomain(sallogdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALLOG-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"SALLOG" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/sallogs/getdraft")
    public ResponseEntity<SALLOGDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(sallogMapping.toDto(sallogService.getDraft(new SALLOG())));
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALLOG-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"SALLOG" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/sallogs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SALLOGDTO sallogdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(sallogService.checkKey(sallogMapping.toDomain(sallogdto)));
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALLOG-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SALLOG" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/sallogs/fetchdefault")
	public ResponseEntity<List<SALLOGDTO>> fetchDefault(SALLOGSearchContext context) {
        Page<SALLOG> domains = sallogService.searchDefault(context) ;
        List<SALLOGDTO> list = sallogMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALLOG-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SALLOG" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/sallogs/searchdefault")
	public ResponseEntity<Page<SALLOGDTO>> searchDefault(@RequestBody SALLOGSearchContext context) {
        Page<SALLOG> domains = sallogService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(sallogMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


