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
import cn.ibizlab.ehr.core.orm.domain.ORMEDITION;
import cn.ibizlab.ehr.core.orm.service.IORMEDITIONService;
import cn.ibizlab.ehr.core.orm.filter.ORMEDITIONSearchContext;




@Slf4j
@Api(tags = {"ORMEDITION" })
@RestController("WebApi-ormedition")
@RequestMapping("")
public class ORMEDITIONResource {

    @Autowired
    private IORMEDITIONService ormeditionService;

    @Autowired
    @Lazy
    public ORMEDITIONMapping ormeditionMapping;

    public ORMEDITIONDTO permissionDTO=new ORMEDITIONDTO();

    @PreAuthorize("hasPermission(#ormedition_id,'Remove',{'Sql',this.ormeditionMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"ORMEDITION" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormeditions/{ormedition_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormedition_id") String ormedition_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormeditionService.remove(ormedition_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"ORMEDITION" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormeditions/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormeditionService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.ormeditionMapping,#ormeditiondto})")
    @ApiOperation(value = "Create", tags = {"ORMEDITION" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormeditions")
    @Transactional
    public ResponseEntity<ORMEDITIONDTO> create(@RequestBody ORMEDITIONDTO ormeditiondto) {
        ORMEDITION domain = ormeditionMapping.toDomain(ormeditiondto);
		ormeditionService.create(domain);
        ORMEDITIONDTO dto = ormeditionMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"ORMEDITION" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormeditions/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ORMEDITIONDTO> ormeditiondtos) {
        ormeditionService.createBatch(ormeditionMapping.toDomain(ormeditiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMEDITION-Save-all')")
    @ApiOperation(value = "Save", tags = {"ORMEDITION" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormeditions/save")
    public ResponseEntity<Boolean> save(@RequestBody ORMEDITIONDTO ormeditiondto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormeditionService.save(ormeditionMapping.toDomain(ormeditiondto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"ORMEDITION" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormeditions/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ORMEDITIONDTO> ormeditiondtos) {
        ormeditionService.saveBatch(ormeditionMapping.toDomain(ormeditiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMEDITION-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"ORMEDITION" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormeditions/getdraft")
    public ResponseEntity<ORMEDITIONDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormeditionMapping.toDto(ormeditionService.getDraft(new ORMEDITION())));
    }

    @PreAuthorize("hasPermission(#ormedition_id,'Update',{'Sql',this.ormeditionMapping,#ormeditiondto})")
    @ApiOperation(value = "Update", tags = {"ORMEDITION" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormeditions/{ormedition_id}")
    @Transactional
    public ResponseEntity<ORMEDITIONDTO> update(@PathVariable("ormedition_id") String ormedition_id, @RequestBody ORMEDITIONDTO ormeditiondto) {
		ORMEDITION domain = ormeditionMapping.toDomain(ormeditiondto);
        domain.setOrmeditionid(ormedition_id);
		ormeditionService.update(domain);
		ORMEDITIONDTO dto = ormeditionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"ORMEDITION" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormeditions/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ORMEDITIONDTO> ormeditiondtos) {
        ormeditionService.updateBatch(ormeditionMapping.toDomain(ormeditiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMEDITION-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"ORMEDITION" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormeditions/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ORMEDITIONDTO ormeditiondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormeditionService.checkKey(ormeditionMapping.toDomain(ormeditiondto)));
    }

    @PreAuthorize("hasPermission(#ormedition_id,'Get',{'Sql',this.ormeditionMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"ORMEDITION" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormeditions/{ormedition_id}")
    public ResponseEntity<ORMEDITIONDTO> get(@PathVariable("ormedition_id") String ormedition_id) {
        ORMEDITION domain = ormeditionService.get(ormedition_id);
        ORMEDITIONDTO dto = ormeditionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMEDITION-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ORMEDITION" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormeditions/fetchdefault")
	public ResponseEntity<List<ORMEDITIONDTO>> fetchDefault(ORMEDITIONSearchContext context) {
        Page<ORMEDITION> domains = ormeditionService.searchDefault(context) ;
        List<ORMEDITIONDTO> list = ormeditionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMEDITION-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ORMEDITION" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormeditions/searchdefault")
	public ResponseEntity<Page<ORMEDITIONDTO>> searchDefault(@RequestBody ORMEDITIONSearchContext context) {
        Page<ORMEDITION> domains = ormeditionService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormeditionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
