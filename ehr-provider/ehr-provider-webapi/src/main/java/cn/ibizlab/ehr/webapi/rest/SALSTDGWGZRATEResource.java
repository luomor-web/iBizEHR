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
import cn.ibizlab.ehr.core.sal.domain.SALSTDGWGZRATE;
import cn.ibizlab.ehr.core.sal.service.ISALSTDGWGZRATEService;
import cn.ibizlab.ehr.core.sal.filter.SALSTDGWGZRATESearchContext;




@Slf4j
@Api(tags = {"SALSTDGWGZRATE" })
@RestController("WebApi-salstdgwgzrate")
@RequestMapping("")
public class SALSTDGWGZRATEResource {

    @Autowired
    private ISALSTDGWGZRATEService salstdgwgzrateService;

    @Autowired
    @Lazy
    public SALSTDGWGZRATEMapping salstdgwgzrateMapping;

    public SALSTDGWGZRATEDTO permissionDTO=new SALSTDGWGZRATEDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDGWGZRATE-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"SALSTDGWGZRATE" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgwgzrates/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SALSTDGWGZRATEDTO salstdgwgzratedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salstdgwgzrateService.checkKey(salstdgwgzrateMapping.toDomain(salstdgwgzratedto)));
    }

    @PreAuthorize("hasPermission(#salstdgwgzrate_id,'Get',{'Sql',this.salstdgwgzrateMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"SALSTDGWGZRATE" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdgwgzrates/{salstdgwgzrate_id}")
    public ResponseEntity<SALSTDGWGZRATEDTO> get(@PathVariable("salstdgwgzrate_id") String salstdgwgzrate_id) {
        SALSTDGWGZRATE domain = salstdgwgzrateService.get(salstdgwgzrate_id);
        SALSTDGWGZRATEDTO dto = salstdgwgzrateMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#salstdgwgzrate_id,'Remove',{'Sql',this.salstdgwgzrateMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"SALSTDGWGZRATE" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdgwgzrates/{salstdgwgzrate_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salstdgwgzrate_id") String salstdgwgzrate_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salstdgwgzrateService.remove(salstdgwgzrate_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"SALSTDGWGZRATE" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdgwgzrates/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salstdgwgzrateService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.salstdgwgzrateMapping,#salstdgwgzratedto})")
    @ApiOperation(value = "Create", tags = {"SALSTDGWGZRATE" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgwgzrates")
    @Transactional
    public ResponseEntity<SALSTDGWGZRATEDTO> create(@RequestBody SALSTDGWGZRATEDTO salstdgwgzratedto) {
        SALSTDGWGZRATE domain = salstdgwgzrateMapping.toDomain(salstdgwgzratedto);
		salstdgwgzrateService.create(domain);
        SALSTDGWGZRATEDTO dto = salstdgwgzrateMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"SALSTDGWGZRATE" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgwgzrates/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SALSTDGWGZRATEDTO> salstdgwgzratedtos) {
        salstdgwgzrateService.createBatch(salstdgwgzrateMapping.toDomain(salstdgwgzratedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDGWGZRATE-Save-all')")
    @ApiOperation(value = "Save", tags = {"SALSTDGWGZRATE" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgwgzrates/save")
    public ResponseEntity<Boolean> save(@RequestBody SALSTDGWGZRATEDTO salstdgwgzratedto) {
        return ResponseEntity.status(HttpStatus.OK).body(salstdgwgzrateService.save(salstdgwgzrateMapping.toDomain(salstdgwgzratedto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"SALSTDGWGZRATE" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgwgzrates/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SALSTDGWGZRATEDTO> salstdgwgzratedtos) {
        salstdgwgzrateService.saveBatch(salstdgwgzrateMapping.toDomain(salstdgwgzratedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#salstdgwgzrate_id,'Update',{'Sql',this.salstdgwgzrateMapping,#salstdgwgzratedto})")
    @ApiOperation(value = "Update", tags = {"SALSTDGWGZRATE" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdgwgzrates/{salstdgwgzrate_id}")
    @Transactional
    public ResponseEntity<SALSTDGWGZRATEDTO> update(@PathVariable("salstdgwgzrate_id") String salstdgwgzrate_id, @RequestBody SALSTDGWGZRATEDTO salstdgwgzratedto) {
		SALSTDGWGZRATE domain = salstdgwgzrateMapping.toDomain(salstdgwgzratedto);
        domain.setSalstdgwgzrateid(salstdgwgzrate_id);
		salstdgwgzrateService.update(domain);
		SALSTDGWGZRATEDTO dto = salstdgwgzrateMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"SALSTDGWGZRATE" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdgwgzrates/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SALSTDGWGZRATEDTO> salstdgwgzratedtos) {
        salstdgwgzrateService.updateBatch(salstdgwgzrateMapping.toDomain(salstdgwgzratedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDGWGZRATE-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"SALSTDGWGZRATE" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdgwgzrates/getdraft")
    public ResponseEntity<SALSTDGWGZRATEDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salstdgwgzrateMapping.toDto(salstdgwgzrateService.getDraft(new SALSTDGWGZRATE())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDGWGZRATE-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SALSTDGWGZRATE" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salstdgwgzrates/fetchdefault")
	public ResponseEntity<List<SALSTDGWGZRATEDTO>> fetchDefault(SALSTDGWGZRATESearchContext context) {
        Page<SALSTDGWGZRATE> domains = salstdgwgzrateService.searchDefault(context) ;
        List<SALSTDGWGZRATEDTO> list = salstdgwgzrateMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDGWGZRATE-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SALSTDGWGZRATE" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salstdgwgzrates/searchdefault")
	public ResponseEntity<Page<SALSTDGWGZRATEDTO>> searchDefault(@RequestBody SALSTDGWGZRATESearchContext context) {
        Page<SALSTDGWGZRATE> domains = salstdgwgzrateService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salstdgwgzrateMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
