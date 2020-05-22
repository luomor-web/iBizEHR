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
import cn.ibizlab.ehr.core.sal.domain.SALSTDGWGZ;
import cn.ibizlab.ehr.core.sal.service.ISALSTDGWGZService;
import cn.ibizlab.ehr.core.sal.filter.SALSTDGWGZSearchContext;




@Slf4j
@Api(tags = {"SALSTDGWGZ" })
@RestController("WebApi-salstdgwgz")
@RequestMapping("")
public class SALSTDGWGZResource {

    @Autowired
    private ISALSTDGWGZService salstdgwgzService;

    @Autowired
    @Lazy
    public SALSTDGWGZMapping salstdgwgzMapping;

    public SALSTDGWGZDTO permissionDTO=new SALSTDGWGZDTO();

    @PreAuthorize("hasPermission(#salstdgwgz_id,'Remove',{'Sql',this.salstdgwgzMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"SALSTDGWGZ" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdgwgzs/{salstdgwgz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salstdgwgz_id") String salstdgwgz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salstdgwgzService.remove(salstdgwgz_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"SALSTDGWGZ" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdgwgzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salstdgwgzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDGWGZ-Save-all')")
    @ApiOperation(value = "Save", tags = {"SALSTDGWGZ" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgwgzs/save")
    public ResponseEntity<Boolean> save(@RequestBody SALSTDGWGZDTO salstdgwgzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(salstdgwgzService.save(salstdgwgzMapping.toDomain(salstdgwgzdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"SALSTDGWGZ" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgwgzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SALSTDGWGZDTO> salstdgwgzdtos) {
        salstdgwgzService.saveBatch(salstdgwgzMapping.toDomain(salstdgwgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.salstdgwgzMapping,#salstdgwgzdto})")
    @ApiOperation(value = "Create", tags = {"SALSTDGWGZ" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgwgzs")
    @Transactional
    public ResponseEntity<SALSTDGWGZDTO> create(@RequestBody SALSTDGWGZDTO salstdgwgzdto) {
        SALSTDGWGZ domain = salstdgwgzMapping.toDomain(salstdgwgzdto);
		salstdgwgzService.create(domain);
        SALSTDGWGZDTO dto = salstdgwgzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"SALSTDGWGZ" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgwgzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SALSTDGWGZDTO> salstdgwgzdtos) {
        salstdgwgzService.createBatch(salstdgwgzMapping.toDomain(salstdgwgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#salstdgwgz_id,'Get',{'Sql',this.salstdgwgzMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"SALSTDGWGZ" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdgwgzs/{salstdgwgz_id}")
    public ResponseEntity<SALSTDGWGZDTO> get(@PathVariable("salstdgwgz_id") String salstdgwgz_id) {
        SALSTDGWGZ domain = salstdgwgzService.get(salstdgwgz_id);
        SALSTDGWGZDTO dto = salstdgwgzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDGWGZ-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"SALSTDGWGZ" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgwgzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SALSTDGWGZDTO salstdgwgzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salstdgwgzService.checkKey(salstdgwgzMapping.toDomain(salstdgwgzdto)));
    }

    @PreAuthorize("hasPermission(#salstdgwgz_id,'Update',{'Sql',this.salstdgwgzMapping,#salstdgwgzdto})")
    @ApiOperation(value = "Update", tags = {"SALSTDGWGZ" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdgwgzs/{salstdgwgz_id}")
    @Transactional
    public ResponseEntity<SALSTDGWGZDTO> update(@PathVariable("salstdgwgz_id") String salstdgwgz_id, @RequestBody SALSTDGWGZDTO salstdgwgzdto) {
		SALSTDGWGZ domain = salstdgwgzMapping.toDomain(salstdgwgzdto);
        domain.setSalstdgwgzid(salstdgwgz_id);
		salstdgwgzService.update(domain);
		SALSTDGWGZDTO dto = salstdgwgzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"SALSTDGWGZ" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdgwgzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SALSTDGWGZDTO> salstdgwgzdtos) {
        salstdgwgzService.updateBatch(salstdgwgzMapping.toDomain(salstdgwgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDGWGZ-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"SALSTDGWGZ" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdgwgzs/getdraft")
    public ResponseEntity<SALSTDGWGZDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salstdgwgzMapping.toDto(salstdgwgzService.getDraft(new SALSTDGWGZ())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDGWGZ-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SALSTDGWGZ" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salstdgwgzs/fetchdefault")
	public ResponseEntity<List<SALSTDGWGZDTO>> fetchDefault(SALSTDGWGZSearchContext context) {
        Page<SALSTDGWGZ> domains = salstdgwgzService.searchDefault(context) ;
        List<SALSTDGWGZDTO> list = salstdgwgzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDGWGZ-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SALSTDGWGZ" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salstdgwgzs/searchdefault")
	public ResponseEntity<Page<SALSTDGWGZDTO>> searchDefault(@RequestBody SALSTDGWGZSearchContext context) {
        Page<SALSTDGWGZ> domains = salstdgwgzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salstdgwgzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
