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
import cn.ibizlab.ehr.core.orm.domain.ORMBMKQDZ;
import cn.ibizlab.ehr.core.orm.service.IORMBMKQDZService;
import cn.ibizlab.ehr.core.orm.filter.ORMBMKQDZSearchContext;




@Slf4j
@Api(tags = {"ORMBMKQDZ" })
@RestController("WebApi-ormbmkqdz")
@RequestMapping("")
public class ORMBMKQDZResource {

    @Autowired
    private IORMBMKQDZService ormbmkqdzService;

    @Autowired
    @Lazy
    public ORMBMKQDZMapping ormbmkqdzMapping;

    public ORMBMKQDZDTO permissionDTO=new ORMBMKQDZDTO();




    @PreAuthorize("hasPermission(#ormbmkqdz_id,'Remove',{'Sql',this.ormbmkqdzMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"ORMBMKQDZ" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormbmkqdzs/{ormbmkqdz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormbmkqdz_id") String ormbmkqdz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzService.remove(ormbmkqdz_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"ORMBMKQDZ" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormbmkqdzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormbmkqdzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMBMKQDZ-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"ORMBMKQDZ" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormbmkqdzs/getdraft")
    public ResponseEntity<ORMBMKQDZDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzMapping.toDto(ormbmkqdzService.getDraft(new ORMBMKQDZ())));
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMBMKQDZ-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"ORMBMKQDZ" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmkqdzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ORMBMKQDZDTO ormbmkqdzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzService.checkKey(ormbmkqdzMapping.toDomain(ormbmkqdzdto)));
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMBMKQDZ-Save-all')")
    @ApiOperation(value = "Save", tags = {"ORMBMKQDZ" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmkqdzs/save")
    public ResponseEntity<Boolean> save(@RequestBody ORMBMKQDZDTO ormbmkqdzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzService.save(ormbmkqdzMapping.toDomain(ormbmkqdzdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"ORMBMKQDZ" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmkqdzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ORMBMKQDZDTO> ormbmkqdzdtos) {
        ormbmkqdzService.saveBatch(ormbmkqdzMapping.toDomain(ormbmkqdzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#ormbmkqdz_id,'Update',{'Sql',this.ormbmkqdzMapping,#ormbmkqdzdto})")
    @ApiOperation(value = "Update", tags = {"ORMBMKQDZ" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormbmkqdzs/{ormbmkqdz_id}")
    @Transactional
    public ResponseEntity<ORMBMKQDZDTO> update(@PathVariable("ormbmkqdz_id") String ormbmkqdz_id, @RequestBody ORMBMKQDZDTO ormbmkqdzdto) {
		ORMBMKQDZ domain = ormbmkqdzMapping.toDomain(ormbmkqdzdto);
        domain.setOrmbmkqdzid(ormbmkqdz_id);
		ormbmkqdzService.update(domain);
		ORMBMKQDZDTO dto = ormbmkqdzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"ORMBMKQDZ" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormbmkqdzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ORMBMKQDZDTO> ormbmkqdzdtos) {
        ormbmkqdzService.updateBatch(ormbmkqdzMapping.toDomain(ormbmkqdzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.ormbmkqdzMapping,#ormbmkqdzdto})")
    @ApiOperation(value = "Create", tags = {"ORMBMKQDZ" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmkqdzs")
    @Transactional
    public ResponseEntity<ORMBMKQDZDTO> create(@RequestBody ORMBMKQDZDTO ormbmkqdzdto) {
        ORMBMKQDZ domain = ormbmkqdzMapping.toDomain(ormbmkqdzdto);
		ormbmkqdzService.create(domain);
        ORMBMKQDZDTO dto = ormbmkqdzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"ORMBMKQDZ" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmkqdzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ORMBMKQDZDTO> ormbmkqdzdtos) {
        ormbmkqdzService.createBatch(ormbmkqdzMapping.toDomain(ormbmkqdzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#ormbmkqdz_id,'Get',{'Sql',this.ormbmkqdzMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"ORMBMKQDZ" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormbmkqdzs/{ormbmkqdz_id}")
    public ResponseEntity<ORMBMKQDZDTO> get(@PathVariable("ormbmkqdz_id") String ormbmkqdz_id) {
        ORMBMKQDZ domain = ormbmkqdzService.get(ormbmkqdz_id);
        ORMBMKQDZDTO dto = ormbmkqdzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMBMKQDZ-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ORMBMKQDZ" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormbmkqdzs/fetchdefault")
	public ResponseEntity<List<ORMBMKQDZDTO>> fetchDefault(ORMBMKQDZSearchContext context) {
        Page<ORMBMKQDZ> domains = ormbmkqdzService.searchDefault(context) ;
        List<ORMBMKQDZDTO> list = ormbmkqdzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMBMKQDZ-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ORMBMKQDZ" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormbmkqdzs/searchdefault")
	public ResponseEntity<Page<ORMBMKQDZDTO>> searchDefault(@RequestBody ORMBMKQDZSearchContext context) {
        Page<ORMBMKQDZ> domains = ormbmkqdzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormbmkqdzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


