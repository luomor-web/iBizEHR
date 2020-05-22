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
import cn.ibizlab.ehr.core.common.domain.OrgSecUser;
import cn.ibizlab.ehr.core.common.service.IOrgSecUserService;
import cn.ibizlab.ehr.core.common.filter.OrgSecUserSearchContext;




@Slf4j
@Api(tags = {"OrgSecUser" })
@RestController("WebApi-orgsecuser")
@RequestMapping("")
public class OrgSecUserResource {

    @Autowired
    private IOrgSecUserService orgsecuserService;

    @Autowired
    @Lazy
    public OrgSecUserMapping orgsecuserMapping;

    public OrgSecUserDTO permissionDTO=new OrgSecUserDTO();

    @PreAuthorize("hasPermission(#orgsecuser_id,'Update',{'Sql',this.orgsecuserMapping,#orgsecuserdto})")
    @ApiOperation(value = "Update", tags = {"OrgSecUser" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/orgsecusers/{orgsecuser_id}")
    @Transactional
    public ResponseEntity<OrgSecUserDTO> update(@PathVariable("orgsecuser_id") String orgsecuser_id, @RequestBody OrgSecUserDTO orgsecuserdto) {
		OrgSecUser domain = orgsecuserMapping.toDomain(orgsecuserdto);
        domain.setOrgsecuserid(orgsecuser_id);
		orgsecuserService.update(domain);
		OrgSecUserDTO dto = orgsecuserMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"OrgSecUser" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/orgsecusers/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrgSecUserDTO> orgsecuserdtos) {
        orgsecuserService.updateBatch(orgsecuserMapping.toDomain(orgsecuserdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgSecUser-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"OrgSecUser" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/orgsecusers/getdraft")
    public ResponseEntity<OrgSecUserDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(orgsecuserMapping.toDto(orgsecuserService.getDraft(new OrgSecUser())));
    }

    @PreAuthorize("hasPermission(#orgsecuser_id,'Remove',{'Sql',this.orgsecuserMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"OrgSecUser" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/orgsecusers/{orgsecuser_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("orgsecuser_id") String orgsecuser_id) {
         return ResponseEntity.status(HttpStatus.OK).body(orgsecuserService.remove(orgsecuser_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"OrgSecUser" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/orgsecusers/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        orgsecuserService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.orgsecuserMapping,#orgsecuserdto})")
    @ApiOperation(value = "Create", tags = {"OrgSecUser" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/orgsecusers")
    @Transactional
    public ResponseEntity<OrgSecUserDTO> create(@RequestBody OrgSecUserDTO orgsecuserdto) {
        OrgSecUser domain = orgsecuserMapping.toDomain(orgsecuserdto);
		orgsecuserService.create(domain);
        OrgSecUserDTO dto = orgsecuserMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"OrgSecUser" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/orgsecusers/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrgSecUserDTO> orgsecuserdtos) {
        orgsecuserService.createBatch(orgsecuserMapping.toDomain(orgsecuserdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgSecUser-Save-all')")
    @ApiOperation(value = "Save", tags = {"OrgSecUser" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/orgsecusers/save")
    public ResponseEntity<Boolean> save(@RequestBody OrgSecUserDTO orgsecuserdto) {
        return ResponseEntity.status(HttpStatus.OK).body(orgsecuserService.save(orgsecuserMapping.toDomain(orgsecuserdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"OrgSecUser" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/orgsecusers/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrgSecUserDTO> orgsecuserdtos) {
        orgsecuserService.saveBatch(orgsecuserMapping.toDomain(orgsecuserdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgSecUser-RemoveDefault-all')")
    @ApiOperation(value = "删除默认关系", tags = {"OrgSecUser" },  notes = "删除默认关系")
	@RequestMapping(method = RequestMethod.DELETE, value = "/orgsecusers/{orgsecuser_id}/removedefault")
    @Transactional
    public ResponseEntity<OrgSecUserDTO> removeDefault(@PathVariable("orgsecuser_id") String orgsecuser_id, @RequestBody OrgSecUserDTO orgsecuserdto) {
        OrgSecUser orgsecuser = orgsecuserMapping.toDomain(orgsecuserdto);
        orgsecuser = orgsecuserService.removeDefault(orgsecuser);
        orgsecuserdto = orgsecuserMapping.toDto(orgsecuser);
        return ResponseEntity.status(HttpStatus.OK).body(orgsecuserdto);
    }

    @PreAuthorize("hasPermission(#orgsecuser_id,'Get',{'Sql',this.orgsecuserMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"OrgSecUser" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/orgsecusers/{orgsecuser_id}")
    public ResponseEntity<OrgSecUserDTO> get(@PathVariable("orgsecuser_id") String orgsecuser_id) {
        OrgSecUser domain = orgsecuserService.get(orgsecuser_id);
        OrgSecUserDTO dto = orgsecuserMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgSecUser-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"OrgSecUser" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/orgsecusers/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrgSecUserDTO orgsecuserdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(orgsecuserService.checkKey(orgsecuserMapping.toDomain(orgsecuserdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgSecUser-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"OrgSecUser" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/orgsecusers/fetchdefault")
	public ResponseEntity<List<OrgSecUserDTO>> fetchDefault(OrgSecUserSearchContext context) {
        Page<OrgSecUser> domains = orgsecuserService.searchDefault(context) ;
        List<OrgSecUserDTO> list = orgsecuserMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgSecUser-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"OrgSecUser" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/orgsecusers/searchdefault")
	public ResponseEntity<Page<OrgSecUserDTO>> searchDefault(@RequestBody OrgSecUserSearchContext context) {
        Page<OrgSecUser> domains = orgsecuserService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(orgsecuserMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
