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
import cn.ibizlab.ehr.core.sal.domain.SALSTDZJ;
import cn.ibizlab.ehr.core.sal.service.ISALSTDZJService;
import cn.ibizlab.ehr.core.sal.filter.SALSTDZJSearchContext;




@Slf4j
@Api(tags = {"SALSTDZJ" })
@RestController("WebApi-salstdzj")
@RequestMapping("")
public class SALSTDZJResource {

    @Autowired
    private ISALSTDZJService salstdzjService;

    @Autowired
    @Lazy
    public SALSTDZJMapping salstdzjMapping;

    public SALSTDZJDTO permissionDTO=new SALSTDZJDTO();

    @PreAuthorize("hasPermission(#salstdzj_id,'Get',{'Sql',this.salstdzjMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"SALSTDZJ" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdzjs/{salstdzj_id}")
    public ResponseEntity<SALSTDZJDTO> get(@PathVariable("salstdzj_id") String salstdzj_id) {
        SALSTDZJ domain = salstdzjService.get(salstdzj_id);
        SALSTDZJDTO dto = salstdzjMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.salstdzjMapping,#salstdzjdto})")
    @ApiOperation(value = "Create", tags = {"SALSTDZJ" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzjs")
    @Transactional
    public ResponseEntity<SALSTDZJDTO> create(@RequestBody SALSTDZJDTO salstdzjdto) {
        SALSTDZJ domain = salstdzjMapping.toDomain(salstdzjdto);
		salstdzjService.create(domain);
        SALSTDZJDTO dto = salstdzjMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"SALSTDZJ" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzjs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SALSTDZJDTO> salstdzjdtos) {
        salstdzjService.createBatch(salstdzjMapping.toDomain(salstdzjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDZJ-Save-all')")
    @ApiOperation(value = "Save", tags = {"SALSTDZJ" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzjs/save")
    public ResponseEntity<Boolean> save(@RequestBody SALSTDZJDTO salstdzjdto) {
        return ResponseEntity.status(HttpStatus.OK).body(salstdzjService.save(salstdzjMapping.toDomain(salstdzjdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"SALSTDZJ" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzjs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SALSTDZJDTO> salstdzjdtos) {
        salstdzjService.saveBatch(salstdzjMapping.toDomain(salstdzjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#salstdzj_id,'Update',{'Sql',this.salstdzjMapping,#salstdzjdto})")
    @ApiOperation(value = "Update", tags = {"SALSTDZJ" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdzjs/{salstdzj_id}")
    @Transactional
    public ResponseEntity<SALSTDZJDTO> update(@PathVariable("salstdzj_id") String salstdzj_id, @RequestBody SALSTDZJDTO salstdzjdto) {
		SALSTDZJ domain = salstdzjMapping.toDomain(salstdzjdto);
        domain.setSalstdzjid(salstdzj_id);
		salstdzjService.update(domain);
		SALSTDZJDTO dto = salstdzjMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"SALSTDZJ" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdzjs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SALSTDZJDTO> salstdzjdtos) {
        salstdzjService.updateBatch(salstdzjMapping.toDomain(salstdzjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#salstdzj_id,'Remove',{'Sql',this.salstdzjMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"SALSTDZJ" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdzjs/{salstdzj_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salstdzj_id") String salstdzj_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salstdzjService.remove(salstdzj_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"SALSTDZJ" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdzjs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salstdzjService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDZJ-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"SALSTDZJ" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdzjs/getdraft")
    public ResponseEntity<SALSTDZJDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salstdzjMapping.toDto(salstdzjService.getDraft(new SALSTDZJ())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDZJ-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"SALSTDZJ" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzjs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SALSTDZJDTO salstdzjdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salstdzjService.checkKey(salstdzjMapping.toDomain(salstdzjdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDZJ-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SALSTDZJ" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salstdzjs/fetchdefault")
	public ResponseEntity<List<SALSTDZJDTO>> fetchDefault(SALSTDZJSearchContext context) {
        Page<SALSTDZJ> domains = salstdzjService.searchDefault(context) ;
        List<SALSTDZJDTO> list = salstdzjMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDZJ-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SALSTDZJ" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salstdzjs/searchdefault")
	public ResponseEntity<Page<SALSTDZJDTO>> searchDefault(@RequestBody SALSTDZJSearchContext context) {
        Page<SALSTDZJ> domains = salstdzjService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salstdzjMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
