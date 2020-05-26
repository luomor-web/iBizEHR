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
import cn.ibizlab.ehr.core.orm.domain.ORMUSER;
import cn.ibizlab.ehr.core.orm.service.IORMUSERService;
import cn.ibizlab.ehr.core.orm.filter.ORMUSERSearchContext;

@Slf4j
@Api(tags = {"ORMUSER" })
@RestController("WebApi-ormuser")
@RequestMapping("")
public class ORMUSERResource {

    @Autowired
    private IORMUSERService ormuserService;

    @Autowired
    @Lazy
    public ORMUSERMapping ormuserMapping;

    public ORMUSERDTO permissionDTO=new ORMUSERDTO();

    @PreAuthorize("hasPermission(#ormuser_id,'Get',{'Sql',this.ormuserMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"ORMUSER" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormusers/{ormuser_id}")
    public ResponseEntity<ORMUSERDTO> get(@PathVariable("ormuser_id") String ormuser_id) {
        ORMUSER domain = ormuserService.get(ormuser_id);
        ORMUSERDTO dto = ormuserMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.ormuserMapping,#ormuserdto})")
    @ApiOperation(value = "Create", tags = {"ORMUSER" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormusers")
    @Transactional
    public ResponseEntity<ORMUSERDTO> create(@RequestBody ORMUSERDTO ormuserdto) {
        ORMUSER domain = ormuserMapping.toDomain(ormuserdto);
		ormuserService.create(domain);
        ORMUSERDTO dto = ormuserMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.ormuserMapping,#ormuserdtos})")
    @ApiOperation(value = "createBatch", tags = {"ORMUSER" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormusers/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ORMUSERDTO> ormuserdtos) {
        ormuserService.createBatch(ormuserMapping.toDomain(ormuserdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#ormuser_id,'Remove',{'Sql',this.ormuserMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"ORMUSER" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormusers/{ormuser_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormuser_id") String ormuser_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormuserService.remove(ormuser_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.ormuserMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"ORMUSER" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormusers/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormuserService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#ormuser_id,'Update',{'Sql',this.ormuserMapping,#ormuserdto})")
    @ApiOperation(value = "Update", tags = {"ORMUSER" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormusers/{ormuser_id}")
    @Transactional
    public ResponseEntity<ORMUSERDTO> update(@PathVariable("ormuser_id") String ormuser_id, @RequestBody ORMUSERDTO ormuserdto) {
		ORMUSER domain  = ormuserMapping.toDomain(ormuserdto);
        domain .setOrguserid(ormuser_id);
		ormuserService.update(domain );
		ORMUSERDTO dto = ormuserMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.ormuserMapping,#ormuserdtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"ORMUSER" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormusers/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ORMUSERDTO> ormuserdtos) {
        ormuserService.updateBatch(ormuserMapping.toDomain(ormuserdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMUSER-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"ORMUSER" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormusers/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ORMUSERDTO ormuserdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormuserService.checkKey(ormuserMapping.toDomain(ormuserdto)));
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.ormuserMapping,#ormuserdto})")
    @ApiOperation(value = "Save", tags = {"ORMUSER" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormusers/save")
    public ResponseEntity<Boolean> save(@RequestBody ORMUSERDTO ormuserdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormuserService.save(ormuserMapping.toDomain(ormuserdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.ormuserMapping,#ormuserdtos})")
    @ApiOperation(value = "SaveBatch", tags = {"ORMUSER" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormusers/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ORMUSERDTO> ormuserdtos) {
        ormuserService.saveBatch(ormuserMapping.toDomain(ormuserdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMUSER-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"ORMUSER" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormusers/getdraft")
    public ResponseEntity<ORMUSERDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormuserMapping.toDto(ormuserService.getDraft(new ORMUSER())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMUSER-DQZZJXJZZ-all')")
	@ApiOperation(value = "fetch当前组织及下级组织", tags = {"ORMUSER" } ,notes = "fetch当前组织及下级组织")
    @RequestMapping(method= RequestMethod.GET , value="/ormusers/fetchdqzzjxjzz")
	public ResponseEntity<List<ORMUSERDTO>> fetchDQZZJXJZZ(ORMUSERSearchContext context) {
        Page<ORMUSER> domains = ormuserService.searchDQZZJXJZZ(context) ;
        List<ORMUSERDTO> list = ormuserMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMUSER-DQZZJXJZZ-all')")
	@ApiOperation(value = "search当前组织及下级组织", tags = {"ORMUSER" } ,notes = "search当前组织及下级组织")
    @RequestMapping(method= RequestMethod.POST , value="/ormusers/searchdqzzjxjzz")
	public ResponseEntity<Page<ORMUSERDTO>> searchDQZZJXJZZ(@RequestBody ORMUSERSearchContext context) {
        Page<ORMUSER> domains = ormuserService.searchDQZZJXJZZ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormuserMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMUSER-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ORMUSER" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormusers/fetchdefault")
	public ResponseEntity<List<ORMUSERDTO>> fetchDefault(ORMUSERSearchContext context) {
        Page<ORMUSER> domains = ormuserService.searchDefault(context) ;
        List<ORMUSERDTO> list = ormuserMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMUSER-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ORMUSER" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormusers/searchdefault")
	public ResponseEntity<Page<ORMUSERDTO>> searchDefault(@RequestBody ORMUSERSearchContext context) {
        Page<ORMUSER> domains = ormuserService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormuserMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
