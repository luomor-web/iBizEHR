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
import cn.ibizlab.ehr.core.sal.domain.SALSCHEME;
import cn.ibizlab.ehr.core.sal.service.ISALSCHEMEService;
import cn.ibizlab.ehr.core.sal.filter.SALSCHEMESearchContext;




@Slf4j
@Api(tags = {"SALSCHEME" })
@RestController("WebApi-salscheme")
@RequestMapping("")
public class SALSCHEMEResource {

    @Autowired
    private ISALSCHEMEService salschemeService;

    @Autowired
    @Lazy
    public SALSCHEMEMapping salschemeMapping;

    public SALSCHEMEDTO permissionDTO=new SALSCHEMEDTO();

    @PreAuthorize("hasPermission('','Create',{'Sql',this.salschemeMapping,#salschemedto})")
    @ApiOperation(value = "Create", tags = {"SALSCHEME" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemes")
    @Transactional
    public ResponseEntity<SALSCHEMEDTO> create(@RequestBody SALSCHEMEDTO salschemedto) {
        SALSCHEME domain = salschemeMapping.toDomain(salschemedto);
		salschemeService.create(domain);
        SALSCHEMEDTO dto = salschemeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"SALSCHEME" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SALSCHEMEDTO> salschemedtos) {
        salschemeService.createBatch(salschemeMapping.toDomain(salschemedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#salscheme_id,'Update',{'Sql',this.salschemeMapping,#salschemedto})")
    @ApiOperation(value = "Update", tags = {"SALSCHEME" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/salschemes/{salscheme_id}")
    @Transactional
    public ResponseEntity<SALSCHEMEDTO> update(@PathVariable("salscheme_id") String salscheme_id, @RequestBody SALSCHEMEDTO salschemedto) {
		SALSCHEME domain = salschemeMapping.toDomain(salschemedto);
        domain.setSalschemeid(salscheme_id);
		salschemeService.update(domain);
		SALSCHEMEDTO dto = salschemeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"SALSCHEME" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/salschemes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SALSCHEMEDTO> salschemedtos) {
        salschemeService.updateBatch(salschemeMapping.toDomain(salschemedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSCHEME-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"SALSCHEME" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/salschemes/getdraft")
    public ResponseEntity<SALSCHEMEDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salschemeMapping.toDto(salschemeService.getDraft(new SALSCHEME())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSCHEME-Save-all')")
    @ApiOperation(value = "Save", tags = {"SALSCHEME" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemes/save")
    public ResponseEntity<Boolean> save(@RequestBody SALSCHEMEDTO salschemedto) {
        return ResponseEntity.status(HttpStatus.OK).body(salschemeService.save(salschemeMapping.toDomain(salschemedto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"SALSCHEME" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SALSCHEMEDTO> salschemedtos) {
        salschemeService.saveBatch(salschemeMapping.toDomain(salschemedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#salscheme_id,'Remove',{'Sql',this.salschemeMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"SALSCHEME" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salschemes/{salscheme_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salscheme_id") String salscheme_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salschemeService.remove(salscheme_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"SALSCHEME" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salschemes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salschemeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#salscheme_id,'Get',{'Sql',this.salschemeMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"SALSCHEME" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/salschemes/{salscheme_id}")
    public ResponseEntity<SALSCHEMEDTO> get(@PathVariable("salscheme_id") String salscheme_id) {
        SALSCHEME domain = salschemeService.get(salscheme_id);
        SALSCHEMEDTO dto = salschemeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSCHEME-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"SALSCHEME" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SALSCHEMEDTO salschemedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salschemeService.checkKey(salschemeMapping.toDomain(salschemedto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSCHEME-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SALSCHEME" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salschemes/fetchdefault")
	public ResponseEntity<List<SALSCHEMEDTO>> fetchDefault(SALSCHEMESearchContext context) {
        Page<SALSCHEME> domains = salschemeService.searchDefault(context) ;
        List<SALSCHEMEDTO> list = salschemeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSCHEME-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SALSCHEME" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salschemes/searchdefault")
	public ResponseEntity<Page<SALSCHEMEDTO>> searchDefault(@RequestBody SALSCHEMESearchContext context) {
        Page<SALSCHEME> domains = salschemeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salschemeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
