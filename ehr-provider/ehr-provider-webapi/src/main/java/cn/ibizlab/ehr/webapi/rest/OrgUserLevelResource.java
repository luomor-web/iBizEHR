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
import cn.ibizlab.ehr.core.common.domain.OrgUserLevel;
import cn.ibizlab.ehr.core.common.service.IOrgUserLevelService;
import cn.ibizlab.ehr.core.common.filter.OrgUserLevelSearchContext;




@Slf4j
@Api(tags = {"OrgUserLevel" })
@RestController("WebApi-orguserlevel")
@RequestMapping("")
public class OrgUserLevelResource {

    @Autowired
    private IOrgUserLevelService orguserlevelService;

    @Autowired
    @Lazy
    public OrgUserLevelMapping orguserlevelMapping;

    public OrgUserLevelDTO permissionDTO=new OrgUserLevelDTO();




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgUserLevel-Save-all')")
    @ApiOperation(value = "Save", tags = {"OrgUserLevel" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/orguserlevels/save")
    public ResponseEntity<Boolean> save(@RequestBody OrgUserLevelDTO orguserleveldto) {
        return ResponseEntity.status(HttpStatus.OK).body(orguserlevelService.save(orguserlevelMapping.toDomain(orguserleveldto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"OrgUserLevel" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/orguserlevels/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrgUserLevelDTO> orguserleveldtos) {
        orguserlevelService.saveBatch(orguserlevelMapping.toDomain(orguserleveldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#orguserlevel_id,'Remove',{'Sql',this.orguserlevelMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"OrgUserLevel" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/orguserlevels/{orguserlevel_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("orguserlevel_id") String orguserlevel_id) {
         return ResponseEntity.status(HttpStatus.OK).body(orguserlevelService.remove(orguserlevel_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"OrgUserLevel" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/orguserlevels/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        orguserlevelService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.orguserlevelMapping,#orguserleveldto})")
    @ApiOperation(value = "Create", tags = {"OrgUserLevel" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/orguserlevels")
    @Transactional
    public ResponseEntity<OrgUserLevelDTO> create(@RequestBody OrgUserLevelDTO orguserleveldto) {
        OrgUserLevel domain = orguserlevelMapping.toDomain(orguserleveldto);
		orguserlevelService.create(domain);
        OrgUserLevelDTO dto = orguserlevelMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"OrgUserLevel" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/orguserlevels/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrgUserLevelDTO> orguserleveldtos) {
        orguserlevelService.createBatch(orguserlevelMapping.toDomain(orguserleveldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#orguserlevel_id,'Get',{'Sql',this.orguserlevelMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"OrgUserLevel" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/orguserlevels/{orguserlevel_id}")
    public ResponseEntity<OrgUserLevelDTO> get(@PathVariable("orguserlevel_id") String orguserlevel_id) {
        OrgUserLevel domain = orguserlevelService.get(orguserlevel_id);
        OrgUserLevelDTO dto = orguserlevelMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgUserLevel-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"OrgUserLevel" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/orguserlevels/getdraft")
    public ResponseEntity<OrgUserLevelDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(orguserlevelMapping.toDto(orguserlevelService.getDraft(new OrgUserLevel())));
    }




    @PreAuthorize("hasPermission(#orguserlevel_id,'Update',{'Sql',this.orguserlevelMapping,#orguserleveldto})")
    @ApiOperation(value = "Update", tags = {"OrgUserLevel" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/orguserlevels/{orguserlevel_id}")
    @Transactional
    public ResponseEntity<OrgUserLevelDTO> update(@PathVariable("orguserlevel_id") String orguserlevel_id, @RequestBody OrgUserLevelDTO orguserleveldto) {
		OrgUserLevel domain = orguserlevelMapping.toDomain(orguserleveldto);
        domain.setOrguserlevelid(orguserlevel_id);
		orguserlevelService.update(domain);
		OrgUserLevelDTO dto = orguserlevelMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"OrgUserLevel" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/orguserlevels/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrgUserLevelDTO> orguserleveldtos) {
        orguserlevelService.updateBatch(orguserlevelMapping.toDomain(orguserleveldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgUserLevel-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"OrgUserLevel" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/orguserlevels/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrgUserLevelDTO orguserleveldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(orguserlevelService.checkKey(orguserlevelMapping.toDomain(orguserleveldto)));
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgUserLevel-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"OrgUserLevel" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/orguserlevels/fetchdefault")
	public ResponseEntity<List<OrgUserLevelDTO>> fetchDefault(OrgUserLevelSearchContext context) {
        Page<OrgUserLevel> domains = orguserlevelService.searchDefault(context) ;
        List<OrgUserLevelDTO> list = orguserlevelMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgUserLevel-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"OrgUserLevel" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/orguserlevels/searchdefault")
	public ResponseEntity<Page<OrgUserLevelDTO>> searchDefault(@RequestBody OrgUserLevelSearchContext context) {
        Page<OrgUserLevel> domains = orguserlevelService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(orguserlevelMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


