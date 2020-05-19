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
import cn.ibizlab.ehr.core.par.domain.PARFZSMX;
import cn.ibizlab.ehr.core.par.service.IPARFZSMXService;
import cn.ibizlab.ehr.core.par.filter.PARFZSMXSearchContext;




@Slf4j
@Api(tags = {"PARFZSMX" })
@RestController("WebApi-parfzsmx")
@RequestMapping("")
public class PARFZSMXResource {

    @Autowired
    private IPARFZSMXService parfzsmxService;

    @Autowired
    @Lazy
    private PARFZSMXMapping parfzsmxMapping;




    @ApiOperation(value = "GetDraft", tags = {"PARFZSMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parfzsmxes/getdraft")
    public ResponseEntity<PARFZSMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parfzsmxMapping.toDto(parfzsmxService.getDraft(new PARFZSMX())));
    }




    @PreAuthorize("hasPermission(#parfzsmx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PARFZSMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parfzsmxes/{parfzsmx_id}")
    @Transactional
    public ResponseEntity<PARFZSMXDTO> update(@PathVariable("parfzsmx_id") String parfzsmx_id, @RequestBody PARFZSMXDTO parfzsmxdto) {
		PARFZSMX domain = parfzsmxMapping.toDomain(parfzsmxdto);
        domain.setParfzsmxid(parfzsmx_id);
		parfzsmxService.update(domain);
		PARFZSMXDTO dto = parfzsmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#parfzsmx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PARFZSMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parfzsmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARFZSMXDTO> parfzsmxdtos) {
        parfzsmxService.updateBatch(parfzsmxMapping.toDomain(parfzsmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#parfzsmx_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PARFZSMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parfzsmxes/{parfzsmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parfzsmx_id") String parfzsmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parfzsmxService.remove(parfzsmx_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PARFZSMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parfzsmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parfzsmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PARFZSMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parfzsmxes")
    @Transactional
    public ResponseEntity<PARFZSMXDTO> create(@RequestBody PARFZSMXDTO parfzsmxdto) {
        PARFZSMX domain = parfzsmxMapping.toDomain(parfzsmxdto);
		parfzsmxService.create(domain);
        PARFZSMXDTO dto = parfzsmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PARFZSMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parfzsmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARFZSMXDTO> parfzsmxdtos) {
        parfzsmxService.createBatch(parfzsmxMapping.toDomain(parfzsmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"PARFZSMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parfzsmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARFZSMXDTO parfzsmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parfzsmxService.checkKey(parfzsmxMapping.toDomain(parfzsmxdto)));
    }




    @ApiOperation(value = "Save", tags = {"PARFZSMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parfzsmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PARFZSMXDTO parfzsmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parfzsmxService.save(parfzsmxMapping.toDomain(parfzsmxdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PARFZSMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parfzsmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARFZSMXDTO> parfzsmxdtos) {
        parfzsmxService.saveBatch(parfzsmxMapping.toDomain(parfzsmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#parfzsmx_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PARFZSMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parfzsmxes/{parfzsmx_id}")
    public ResponseEntity<PARFZSMXDTO> get(@PathVariable("parfzsmx_id") String parfzsmx_id) {
        PARFZSMX domain = parfzsmxService.get(parfzsmx_id);
        PARFZSMXDTO dto = parfzsmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PARFZSMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parfzsmxes/fetchdefault")
	public ResponseEntity<List<PARFZSMXDTO>> fetchDefault(PARFZSMXSearchContext context) {
        Page<PARFZSMX> domains = parfzsmxService.searchDefault(context) ;
        List<PARFZSMXDTO> list = parfzsmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"PARFZSMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parfzsmxes/searchdefault")
	public ResponseEntity<Page<PARFZSMXDTO>> searchDefault(PARFZSMXSearchContext context) {
        Page<PARFZSMX> domains = parfzsmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parfzsmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PARFZSMX getEntity(){
        return new PARFZSMX();
    }

}
