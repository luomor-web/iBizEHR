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
import cn.ibizlab.ehr.core.common.domain.UserRole;
import cn.ibizlab.ehr.core.common.service.IUserRoleService;
import cn.ibizlab.ehr.core.common.filter.UserRoleSearchContext;




@Slf4j
@Api(tags = {"UserRole" })
@RestController("WebApi-userrole")
@RequestMapping("")
public class UserRoleResource {

    @Autowired
    private IUserRoleService userroleService;

    @Autowired
    @Lazy
    public UserRoleMapping userroleMapping;

    public UserRoleDTO permissionDTO=new UserRoleDTO();

    @PreAuthorize("hasPermission('','Create',{'Sql',this.userroleMapping,#userroledto})")
    @ApiOperation(value = "Create", tags = {"UserRole" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/userroles")
    @Transactional
    public ResponseEntity<UserRoleDTO> create(@RequestBody UserRoleDTO userroledto) {
        UserRole domain = userroleMapping.toDomain(userroledto);
		userroleService.create(domain);
        UserRoleDTO dto = userroleMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"UserRole" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/userroles/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<UserRoleDTO> userroledtos) {
        userroleService.createBatch(userroleMapping.toDomain(userroledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserRole-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"UserRole" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/userroles/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody UserRoleDTO userroledto) {
        return  ResponseEntity.status(HttpStatus.OK).body(userroleService.checkKey(userroleMapping.toDomain(userroledto)));
    }

    @PreAuthorize("hasPermission(#userrole_id,'Remove',{'Sql',this.userroleMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"UserRole" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/userroles/{userrole_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("userrole_id") String userrole_id) {
         return ResponseEntity.status(HttpStatus.OK).body(userroleService.remove(userrole_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"UserRole" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/userroles/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        userroleService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#userrole_id,'Update',{'Sql',this.userroleMapping,#userroledto})")
    @ApiOperation(value = "Update", tags = {"UserRole" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/userroles/{userrole_id}")
    @Transactional
    public ResponseEntity<UserRoleDTO> update(@PathVariable("userrole_id") String userrole_id, @RequestBody UserRoleDTO userroledto) {
		UserRole domain = userroleMapping.toDomain(userroledto);
        domain.setUserroleid(userrole_id);
		userroleService.update(domain);
		UserRoleDTO dto = userroleMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"UserRole" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/userroles/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<UserRoleDTO> userroledtos) {
        userroleService.updateBatch(userroleMapping.toDomain(userroledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserRole-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"UserRole" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/userroles/getdraft")
    public ResponseEntity<UserRoleDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(userroleMapping.toDto(userroleService.getDraft(new UserRole())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserRole-Save-all')")
    @ApiOperation(value = "Save", tags = {"UserRole" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/userroles/save")
    public ResponseEntity<Boolean> save(@RequestBody UserRoleDTO userroledto) {
        return ResponseEntity.status(HttpStatus.OK).body(userroleService.save(userroleMapping.toDomain(userroledto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"UserRole" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/userroles/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<UserRoleDTO> userroledtos) {
        userroleService.saveBatch(userroleMapping.toDomain(userroledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#userrole_id,'Get',{'Sql',this.userroleMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"UserRole" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/userroles/{userrole_id}")
    public ResponseEntity<UserRoleDTO> get(@PathVariable("userrole_id") String userrole_id) {
        UserRole domain = userroleService.get(userrole_id);
        UserRoleDTO dto = userroleMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserRole-LevelC-all')")
	@ApiOperation(value = "fetch用户角色权限配置", tags = {"UserRole" } ,notes = "fetch用户角色权限配置")
    @RequestMapping(method= RequestMethod.GET , value="/userroles/fetchlevelc")
	public ResponseEntity<List<UserRoleDTO>> fetchLevelC(UserRoleSearchContext context) {
        Page<UserRole> domains = userroleService.searchLevelC(context) ;
        List<UserRoleDTO> list = userroleMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserRole-LevelC-all')")
	@ApiOperation(value = "search用户角色权限配置", tags = {"UserRole" } ,notes = "search用户角色权限配置")
    @RequestMapping(method= RequestMethod.POST , value="/userroles/searchlevelc")
	public ResponseEntity<Page<UserRoleDTO>> searchLevelC(@RequestBody UserRoleSearchContext context) {
        Page<UserRole> domains = userroleService.searchLevelC(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(userroleMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserRole-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"UserRole" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/userroles/fetchdefault")
	public ResponseEntity<List<UserRoleDTO>> fetchDefault(UserRoleSearchContext context) {
        Page<UserRole> domains = userroleService.searchDefault(context) ;
        List<UserRoleDTO> list = userroleMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserRole-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"UserRole" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/userroles/searchdefault")
	public ResponseEntity<Page<UserRoleDTO>> searchDefault(@RequestBody UserRoleSearchContext context) {
        Page<UserRole> domains = userroleService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(userroleMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
