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
import cn.ibizlab.ehr.core.orm.domain.ORMBMGWBZ;
import cn.ibizlab.ehr.core.orm.service.IORMBMGWBZService;
import cn.ibizlab.ehr.core.orm.filter.ORMBMGWBZSearchContext;




@Slf4j
@Api(tags = {"ORMBMGWBZ" })
@RestController("WebApi-ormbmgwbz")
@RequestMapping("")
public class ORMBMGWBZResource {

    @Autowired
    private IORMBMGWBZService ormbmgwbzService;

    @Autowired
    @Lazy
    public ORMBMGWBZMapping ormbmgwbzMapping;

    public ORMBMGWBZDTO permissionDTO=new ORMBMGWBZDTO();

    @PreAuthorize("hasPermission('','Create',{'Sql',this.ormbmgwbzMapping,#ormbmgwbzdto})")
    @ApiOperation(value = "Create", tags = {"ORMBMGWBZ" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmgwbzs")
    @Transactional
    public ResponseEntity<ORMBMGWBZDTO> create(@RequestBody ORMBMGWBZDTO ormbmgwbzdto) {
        ORMBMGWBZ domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
		ormbmgwbzService.create(domain);
        ORMBMGWBZDTO dto = ormbmgwbzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"ORMBMGWBZ" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ORMBMGWBZDTO> ormbmgwbzdtos) {
        ormbmgwbzService.createBatch(ormbmgwbzMapping.toDomain(ormbmgwbzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMBMGWBZ-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"ORMBMGWBZ" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmgwbzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ORMBMGWBZDTO ormbmgwbzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.checkKey(ormbmgwbzMapping.toDomain(ormbmgwbzdto)));
    }

    @PreAuthorize("hasPermission(#ormbmgwbz_id,'Get',{'Sql',this.ormbmgwbzMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"ORMBMGWBZ" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormbmgwbzs/{ormbmgwbz_id}")
    public ResponseEntity<ORMBMGWBZDTO> get(@PathVariable("ormbmgwbz_id") String ormbmgwbz_id) {
        ORMBMGWBZ domain = ormbmgwbzService.get(ormbmgwbz_id);
        ORMBMGWBZDTO dto = ormbmgwbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMBMGWBZ-Save-all')")
    @ApiOperation(value = "Save", tags = {"ORMBMGWBZ" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmgwbzs/save")
    public ResponseEntity<Boolean> save(@RequestBody ORMBMGWBZDTO ormbmgwbzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.save(ormbmgwbzMapping.toDomain(ormbmgwbzdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"ORMBMGWBZ" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmgwbzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ORMBMGWBZDTO> ormbmgwbzdtos) {
        ormbmgwbzService.saveBatch(ormbmgwbzMapping.toDomain(ormbmgwbzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#ormbmgwbz_id,'Update',{'Sql',this.ormbmgwbzMapping,#ormbmgwbzdto})")
    @ApiOperation(value = "Update", tags = {"ORMBMGWBZ" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormbmgwbzs/{ormbmgwbz_id}")
    @Transactional
    public ResponseEntity<ORMBMGWBZDTO> update(@PathVariable("ormbmgwbz_id") String ormbmgwbz_id, @RequestBody ORMBMGWBZDTO ormbmgwbzdto) {
		ORMBMGWBZ domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmbmgwbzid(ormbmgwbz_id);
		ormbmgwbzService.update(domain);
		ORMBMGWBZDTO dto = ormbmgwbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"ORMBMGWBZ" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ORMBMGWBZDTO> ormbmgwbzdtos) {
        ormbmgwbzService.updateBatch(ormbmgwbzMapping.toDomain(ormbmgwbzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMBMGWBZ-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"ORMBMGWBZ" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormbmgwbzs/getdraft")
    public ResponseEntity<ORMBMGWBZDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzMapping.toDto(ormbmgwbzService.getDraft(new ORMBMGWBZ())));
    }

    @PreAuthorize("hasPermission(#ormbmgwbz_id,'Remove',{'Sql',this.ormbmgwbzMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"ORMBMGWBZ" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormbmgwbzs/{ormbmgwbz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormbmgwbz_id") String ormbmgwbz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.remove(ormbmgwbz_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"ORMBMGWBZ" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormbmgwbzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMBMGWBZ-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ORMBMGWBZ" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormbmgwbzs/fetchdefault")
	public ResponseEntity<List<ORMBMGWBZDTO>> fetchDefault(ORMBMGWBZSearchContext context) {
        Page<ORMBMGWBZ> domains = ormbmgwbzService.searchDefault(context) ;
        List<ORMBMGWBZDTO> list = ormbmgwbzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMBMGWBZ-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ORMBMGWBZ" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormbmgwbzs/searchdefault")
	public ResponseEntity<Page<ORMBMGWBZDTO>> searchDefault(@RequestBody ORMBMGWBZSearchContext context) {
        Page<ORMBMGWBZ> domains = ormbmgwbzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormbmgwbzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
