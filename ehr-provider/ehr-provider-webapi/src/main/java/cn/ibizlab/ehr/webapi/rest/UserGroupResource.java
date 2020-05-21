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
import cn.ibizlab.ehr.core.common.domain.UserGroup;
import cn.ibizlab.ehr.core.common.service.IUserGroupService;
import cn.ibizlab.ehr.core.common.filter.UserGroupSearchContext;




@Slf4j
@Api(tags = {"UserGroup" })
@RestController("WebApi-usergroup")
@RequestMapping("")
public class UserGroupResource {

    @Autowired
    private IUserGroupService usergroupService;

    @Autowired
    @Lazy
    public UserGroupMapping usergroupMapping;

    public UserGroupDTO permissionDTO=new UserGroupDTO();




    @PreAuthorize("hasPermission(#usergroup_id,'Update',{'Sql',this.usergroupMapping,#usergroupdto})")
    @ApiOperation(value = "Update", tags = {"UserGroup" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/usergroups/{usergroup_id}")
    @Transactional
    public ResponseEntity<UserGroupDTO> update(@PathVariable("usergroup_id") String usergroup_id, @RequestBody UserGroupDTO usergroupdto) {
		UserGroup domain = usergroupMapping.toDomain(usergroupdto);
        domain.setUsergroupid(usergroup_id);
		usergroupService.update(domain);
		UserGroupDTO dto = usergroupMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"UserGroup" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/usergroups/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<UserGroupDTO> usergroupdtos) {
        usergroupService.updateBatch(usergroupMapping.toDomain(usergroupdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#usergroup_id,'Remove',{'Sql',this.usergroupMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"UserGroup" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/usergroups/{usergroup_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("usergroup_id") String usergroup_id) {
         return ResponseEntity.status(HttpStatus.OK).body(usergroupService.remove(usergroup_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"UserGroup" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/usergroups/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        usergroupService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserGroup-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"UserGroup" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/usergroups/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody UserGroupDTO usergroupdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(usergroupService.checkKey(usergroupMapping.toDomain(usergroupdto)));
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.usergroupMapping,#usergroupdto})")
    @ApiOperation(value = "Create", tags = {"UserGroup" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/usergroups")
    @Transactional
    public ResponseEntity<UserGroupDTO> create(@RequestBody UserGroupDTO usergroupdto) {
        UserGroup domain = usergroupMapping.toDomain(usergroupdto);
		usergroupService.create(domain);
        UserGroupDTO dto = usergroupMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"UserGroup" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/usergroups/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<UserGroupDTO> usergroupdtos) {
        usergroupService.createBatch(usergroupMapping.toDomain(usergroupdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserGroup-Save-all')")
    @ApiOperation(value = "Save", tags = {"UserGroup" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/usergroups/save")
    public ResponseEntity<Boolean> save(@RequestBody UserGroupDTO usergroupdto) {
        return ResponseEntity.status(HttpStatus.OK).body(usergroupService.save(usergroupMapping.toDomain(usergroupdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"UserGroup" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/usergroups/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<UserGroupDTO> usergroupdtos) {
        usergroupService.saveBatch(usergroupMapping.toDomain(usergroupdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#usergroup_id,'Get',{'Sql',this.usergroupMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"UserGroup" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/usergroups/{usergroup_id}")
    public ResponseEntity<UserGroupDTO> get(@PathVariable("usergroup_id") String usergroup_id) {
        UserGroup domain = usergroupService.get(usergroup_id);
        UserGroupDTO dto = usergroupMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserGroup-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"UserGroup" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/usergroups/getdraft")
    public ResponseEntity<UserGroupDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(usergroupMapping.toDto(usergroupService.getDraft(new UserGroup())));
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserGroup-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"UserGroup" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/usergroups/fetchdefault")
	public ResponseEntity<List<UserGroupDTO>> fetchDefault(UserGroupSearchContext context) {
        Page<UserGroup> domains = usergroupService.searchDefault(context) ;
        List<UserGroupDTO> list = usergroupMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserGroup-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"UserGroup" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/usergroups/searchdefault")
	public ResponseEntity<Page<UserGroupDTO>> searchDefault(@RequestBody UserGroupSearchContext context) {
        Page<UserGroup> domains = usergroupService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(usergroupMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


