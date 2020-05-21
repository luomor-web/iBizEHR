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
import cn.ibizlab.ehr.core.common.domain.OrgUser;
import cn.ibizlab.ehr.core.common.service.IOrgUserService;
import cn.ibizlab.ehr.core.common.filter.OrgUserSearchContext;




@Slf4j
@Api(tags = {"OrgUser" })
@RestController("WebApi-orguser")
@RequestMapping("")
public class OrgUserResource {

    @Autowired
    private IOrgUserService orguserService;

    @Autowired
    @Lazy
    public OrgUserMapping orguserMapping;

    public OrgUserDTO permissionDTO=new OrgUserDTO();




    @PreAuthorize("hasPermission(#orguser_id,'Remove',{'Sql',this.orguserMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"OrgUser" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/orgusers/{orguser_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("orguser_id") String orguser_id) {
         return ResponseEntity.status(HttpStatus.OK).body(orguserService.remove(orguser_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"OrgUser" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/orgusers/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        orguserService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgUser-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"OrgUser" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/orgusers/getdraft")
    public ResponseEntity<OrgUserDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(orguserMapping.toDto(orguserService.getDraft(new OrgUser())));
    }




    @PreAuthorize("hasPermission(#orguser_id,'Update',{'Sql',this.orguserMapping,#orguserdto})")
    @ApiOperation(value = "Update", tags = {"OrgUser" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/orgusers/{orguser_id}")
    @Transactional
    public ResponseEntity<OrgUserDTO> update(@PathVariable("orguser_id") String orguser_id, @RequestBody OrgUserDTO orguserdto) {
		OrgUser domain = orguserMapping.toDomain(orguserdto);
        domain.setOrguserid(orguser_id);
		orguserService.update(domain);
		OrgUserDTO dto = orguserMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"OrgUser" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/orgusers/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrgUserDTO> orguserdtos) {
        orguserService.updateBatch(orguserMapping.toDomain(orguserdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#orguser_id,'Get',{'Sql',this.orguserMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"OrgUser" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/orgusers/{orguser_id}")
    public ResponseEntity<OrgUserDTO> get(@PathVariable("orguser_id") String orguser_id) {
        OrgUser domain = orguserService.get(orguser_id);
        OrgUserDTO dto = orguserMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgUser-Save-all')")
    @ApiOperation(value = "Save", tags = {"OrgUser" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/orgusers/save")
    public ResponseEntity<Boolean> save(@RequestBody OrgUserDTO orguserdto) {
        return ResponseEntity.status(HttpStatus.OK).body(orguserService.save(orguserMapping.toDomain(orguserdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"OrgUser" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/orgusers/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrgUserDTO> orguserdtos) {
        orguserService.saveBatch(orguserMapping.toDomain(orguserdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgUser-UpdateCurUser-all')")
    @ApiOperation(value = "更新当前用户", tags = {"OrgUser" },  notes = "更新当前用户")
	@RequestMapping(method = RequestMethod.PUT, value = "/orgusers/{orguser_id}/updatecuruser")
    @Transactional
    public ResponseEntity<OrgUserDTO> updateCurUser(@PathVariable("orguser_id") String orguser_id, @RequestBody OrgUserDTO orguserdto) {
        OrgUser orguser = orguserMapping.toDomain(orguserdto);
        orguser = orguserService.updateCurUser(orguser);
        orguserdto = orguserMapping.toDto(orguser);
        return ResponseEntity.status(HttpStatus.OK).body(orguserdto);
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.orguserMapping,#orguserdto})")
    @ApiOperation(value = "Create", tags = {"OrgUser" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/orgusers")
    @Transactional
    public ResponseEntity<OrgUserDTO> create(@RequestBody OrgUserDTO orguserdto) {
        OrgUser domain = orguserMapping.toDomain(orguserdto);
		orguserService.create(domain);
        OrgUserDTO dto = orguserMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"OrgUser" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/orgusers/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrgUserDTO> orguserdtos) {
        orguserService.createBatch(orguserMapping.toDomain(orguserdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgUser-GetCurUser-all')")
    @ApiOperation(value = "获取当前用户", tags = {"OrgUser" },  notes = "获取当前用户")
	@RequestMapping(method = RequestMethod.GET, value = "/orgusers/{orguser_id}/getcuruser")
    @Transactional
    public ResponseEntity<OrgUserDTO> getCurUser(@PathVariable("orguser_id") String orguser_id, @RequestBody OrgUserDTO orguserdto) {
        OrgUser orguser = orguserMapping.toDomain(orguserdto);
        orguser = orguserService.getCurUser(orguser);
        orguserdto = orguserMapping.toDto(orguser);
        return ResponseEntity.status(HttpStatus.OK).body(orguserdto);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgUser-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"OrgUser" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/orgusers/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrgUserDTO orguserdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(orguserService.checkKey(orguserMapping.toDomain(orguserdto)));
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgUser-CurOrg-all')")
	@ApiOperation(value = "fetch当前组织", tags = {"OrgUser" } ,notes = "fetch当前组织")
    @RequestMapping(method= RequestMethod.GET , value="/orgusers/fetchcurorg")
	public ResponseEntity<List<OrgUserDTO>> fetchCurOrg(OrgUserSearchContext context) {
        Page<OrgUser> domains = orguserService.searchCurOrg(context) ;
        List<OrgUserDTO> list = orguserMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgUser-CurOrg-all')")
	@ApiOperation(value = "search当前组织", tags = {"OrgUser" } ,notes = "search当前组织")
    @RequestMapping(method= RequestMethod.POST , value="/orgusers/searchcurorg")
	public ResponseEntity<Page<OrgUserDTO>> searchCurOrg(@RequestBody OrgUserSearchContext context) {
        Page<OrgUser> domains = orguserService.searchCurOrg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(orguserMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgUser-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"OrgUser" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/orgusers/fetchdefault")
	public ResponseEntity<List<OrgUserDTO>> fetchDefault(OrgUserSearchContext context) {
        Page<OrgUser> domains = orguserService.searchDefault(context) ;
        List<OrgUserDTO> list = orguserMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgUser-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"OrgUser" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/orgusers/searchdefault")
	public ResponseEntity<Page<OrgUserDTO>> searchDefault(@RequestBody OrgUserSearchContext context) {
        Page<OrgUser> domains = orguserService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(orguserMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgUser-CurOrgSector-all')")
	@ApiOperation(value = "fetch当前部门", tags = {"OrgUser" } ,notes = "fetch当前部门")
    @RequestMapping(method= RequestMethod.GET , value="/orgusers/fetchcurorgsector")
	public ResponseEntity<List<OrgUserDTO>> fetchCurOrgSector(OrgUserSearchContext context) {
        Page<OrgUser> domains = orguserService.searchCurOrgSector(context) ;
        List<OrgUserDTO> list = orguserMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgUser-CurOrgSector-all')")
	@ApiOperation(value = "search当前部门", tags = {"OrgUser" } ,notes = "search当前部门")
    @RequestMapping(method= RequestMethod.POST , value="/orgusers/searchcurorgsector")
	public ResponseEntity<Page<OrgUserDTO>> searchCurOrgSector(@RequestBody OrgUserSearchContext context) {
        Page<OrgUser> domains = orguserService.searchCurOrgSector(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(orguserMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgUser-UserOrgSector-all')")
	@ApiOperation(value = "fetch用户所在部门用户", tags = {"OrgUser" } ,notes = "fetch用户所在部门用户")
    @RequestMapping(method= RequestMethod.GET , value="/orgusers/fetchuserorgsector")
	public ResponseEntity<List<OrgUserDTO>> fetchUserOrgSector(OrgUserSearchContext context) {
        Page<OrgUser> domains = orguserService.searchUserOrgSector(context) ;
        List<OrgUserDTO> list = orguserMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgUser-UserOrgSector-all')")
	@ApiOperation(value = "search用户所在部门用户", tags = {"OrgUser" } ,notes = "search用户所在部门用户")
    @RequestMapping(method= RequestMethod.POST , value="/orgusers/searchuserorgsector")
	public ResponseEntity<Page<OrgUserDTO>> searchUserOrgSector(@RequestBody OrgUserSearchContext context) {
        Page<OrgUser> domains = orguserService.searchUserOrgSector(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(orguserMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgUser-UserOrg-all')")
	@ApiOperation(value = "fetch用户所在组织范围", tags = {"OrgUser" } ,notes = "fetch用户所在组织范围")
    @RequestMapping(method= RequestMethod.GET , value="/orgusers/fetchuserorg")
	public ResponseEntity<List<OrgUserDTO>> fetchUserOrg(OrgUserSearchContext context) {
        Page<OrgUser> domains = orguserService.searchUserOrg(context) ;
        List<OrgUserDTO> list = orguserMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgUser-UserOrg-all')")
	@ApiOperation(value = "search用户所在组织范围", tags = {"OrgUser" } ,notes = "search用户所在组织范围")
    @RequestMapping(method= RequestMethod.POST , value="/orgusers/searchuserorg")
	public ResponseEntity<Page<OrgUserDTO>> searchUserOrg(@RequestBody OrgUserSearchContext context) {
        Page<OrgUser> domains = orguserService.searchUserOrg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(orguserMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgUser-DQZZJXJZZ-all')")
	@ApiOperation(value = "fetch当前组织及下级组织", tags = {"OrgUser" } ,notes = "fetch当前组织及下级组织")
    @RequestMapping(method= RequestMethod.GET , value="/orgusers/fetchdqzzjxjzz")
	public ResponseEntity<List<OrgUserDTO>> fetchDQZZJXJZZ(OrgUserSearchContext context) {
        Page<OrgUser> domains = orguserService.searchDQZZJXJZZ(context) ;
        List<OrgUserDTO> list = orguserMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgUser-DQZZJXJZZ-all')")
	@ApiOperation(value = "search当前组织及下级组织", tags = {"OrgUser" } ,notes = "search当前组织及下级组织")
    @RequestMapping(method= RequestMethod.POST , value="/orgusers/searchdqzzjxjzz")
	public ResponseEntity<Page<OrgUserDTO>> searchDQZZJXJZZ(@RequestBody OrgUserSearchContext context) {
        Page<OrgUser> domains = orguserService.searchDQZZJXJZZ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(orguserMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


