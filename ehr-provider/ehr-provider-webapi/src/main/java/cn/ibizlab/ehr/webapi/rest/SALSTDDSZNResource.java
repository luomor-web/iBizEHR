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
import cn.ibizlab.ehr.core.sal.domain.SALSTDDSZN;
import cn.ibizlab.ehr.core.sal.service.ISALSTDDSZNService;
import cn.ibizlab.ehr.core.sal.filter.SALSTDDSZNSearchContext;




@Slf4j
@Api(tags = {"SALSTDDSZN" })
@RestController("WebApi-salstddszn")
@RequestMapping("")
public class SALSTDDSZNResource {

    @Autowired
    private ISALSTDDSZNService salstddsznService;

    @Autowired
    @Lazy
    public SALSTDDSZNMapping salstddsznMapping;

    public SALSTDDSZNDTO permissionDTO=new SALSTDDSZNDTO();




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDDSZN-Save-all')")
    @ApiOperation(value = "Save", tags = {"SALSTDDSZN" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/salstddszns/save")
    public ResponseEntity<Boolean> save(@RequestBody SALSTDDSZNDTO salstddszndto) {
        return ResponseEntity.status(HttpStatus.OK).body(salstddsznService.save(salstddsznMapping.toDomain(salstddszndto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"SALSTDDSZN" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salstddszns/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SALSTDDSZNDTO> salstddszndtos) {
        salstddsznService.saveBatch(salstddsznMapping.toDomain(salstddszndtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#salstddszn_id,'Remove',{'Sql',this.salstddsznMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"SALSTDDSZN" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstddszns/{salstddszn_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salstddszn_id") String salstddszn_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salstddsznService.remove(salstddszn_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"SALSTDDSZN" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstddszns/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salstddsznService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#salstddszn_id,'Get',{'Sql',this.salstddsznMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"SALSTDDSZN" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/salstddszns/{salstddszn_id}")
    public ResponseEntity<SALSTDDSZNDTO> get(@PathVariable("salstddszn_id") String salstddszn_id) {
        SALSTDDSZN domain = salstddsznService.get(salstddszn_id);
        SALSTDDSZNDTO dto = salstddsznMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#salstddszn_id,'Update',{'Sql',this.salstddsznMapping,#salstddszndto})")
    @ApiOperation(value = "Update", tags = {"SALSTDDSZN" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstddszns/{salstddszn_id}")
    @Transactional
    public ResponseEntity<SALSTDDSZNDTO> update(@PathVariable("salstddszn_id") String salstddszn_id, @RequestBody SALSTDDSZNDTO salstddszndto) {
		SALSTDDSZN domain = salstddsznMapping.toDomain(salstddszndto);
        domain.setSalstddsznid(salstddszn_id);
		salstddsznService.update(domain);
		SALSTDDSZNDTO dto = salstddsznMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"SALSTDDSZN" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstddszns/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SALSTDDSZNDTO> salstddszndtos) {
        salstddsznService.updateBatch(salstddsznMapping.toDomain(salstddszndtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.salstddsznMapping,#salstddszndto})")
    @ApiOperation(value = "Create", tags = {"SALSTDDSZN" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/salstddszns")
    @Transactional
    public ResponseEntity<SALSTDDSZNDTO> create(@RequestBody SALSTDDSZNDTO salstddszndto) {
        SALSTDDSZN domain = salstddsznMapping.toDomain(salstddszndto);
		salstddsznService.create(domain);
        SALSTDDSZNDTO dto = salstddsznMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"SALSTDDSZN" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salstddszns/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SALSTDDSZNDTO> salstddszndtos) {
        salstddsznService.createBatch(salstddsznMapping.toDomain(salstddszndtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDDSZN-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"SALSTDDSZN" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/salstddszns/getdraft")
    public ResponseEntity<SALSTDDSZNDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salstddsznMapping.toDto(salstddsznService.getDraft(new SALSTDDSZN())));
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDDSZN-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"SALSTDDSZN" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/salstddszns/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SALSTDDSZNDTO salstddszndto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salstddsznService.checkKey(salstddsznMapping.toDomain(salstddszndto)));
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDDSZN-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SALSTDDSZN" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salstddszns/fetchdefault")
	public ResponseEntity<List<SALSTDDSZNDTO>> fetchDefault(SALSTDDSZNSearchContext context) {
        Page<SALSTDDSZN> domains = salstddsznService.searchDefault(context) ;
        List<SALSTDDSZNDTO> list = salstddsznMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDDSZN-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SALSTDDSZN" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salstddszns/searchdefault")
	public ResponseEntity<Page<SALSTDDSZNDTO>> searchDefault(@RequestBody SALSTDDSZNSearchContext context) {
        Page<SALSTDDSZN> domains = salstddsznService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salstddsznMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


