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
import cn.ibizlab.ehr.core.common.domain.UserRoleDEField;
import cn.ibizlab.ehr.core.common.service.IUserRoleDEFieldService;
import cn.ibizlab.ehr.core.common.filter.UserRoleDEFieldSearchContext;




@Slf4j
@Api(tags = {"UserRoleDEField" })
@RestController("WebApi-userroledefield")
@RequestMapping("")
public class UserRoleDEFieldResource {

    @Autowired
    private IUserRoleDEFieldService userroledefieldService;

    @Autowired
    @Lazy
    public UserRoleDEFieldMapping userroledefieldMapping;

    public UserRoleDEFieldDTO permissionDTO=new UserRoleDEFieldDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserRoleDEField-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"UserRoleDEField" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/userroledefields/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody UserRoleDEFieldDTO userroledefielddto) {
        return  ResponseEntity.status(HttpStatus.OK).body(userroledefieldService.checkKey(userroledefieldMapping.toDomain(userroledefielddto)));
    }

    @PreAuthorize("hasPermission(#userroledefield_id,'Update',{'Sql',this.userroledefieldMapping,#userroledefielddto})")
    @ApiOperation(value = "Update", tags = {"UserRoleDEField" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/userroledefields/{userroledefield_id}")
    @Transactional
    public ResponseEntity<UserRoleDEFieldDTO> update(@PathVariable("userroledefield_id") String userroledefield_id, @RequestBody UserRoleDEFieldDTO userroledefielddto) {
		UserRoleDEField domain = userroledefieldMapping.toDomain(userroledefielddto);
        domain.setUserroledefieldid(userroledefield_id);
		userroledefieldService.update(domain);
		UserRoleDEFieldDTO dto = userroledefieldMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"UserRoleDEField" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/userroledefields/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<UserRoleDEFieldDTO> userroledefielddtos) {
        userroledefieldService.updateBatch(userroledefieldMapping.toDomain(userroledefielddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.userroledefieldMapping,#userroledefielddto})")
    @ApiOperation(value = "Create", tags = {"UserRoleDEField" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/userroledefields")
    @Transactional
    public ResponseEntity<UserRoleDEFieldDTO> create(@RequestBody UserRoleDEFieldDTO userroledefielddto) {
        UserRoleDEField domain = userroledefieldMapping.toDomain(userroledefielddto);
		userroledefieldService.create(domain);
        UserRoleDEFieldDTO dto = userroledefieldMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"UserRoleDEField" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/userroledefields/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<UserRoleDEFieldDTO> userroledefielddtos) {
        userroledefieldService.createBatch(userroledefieldMapping.toDomain(userroledefielddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserRoleDEField-Save-all')")
    @ApiOperation(value = "Save", tags = {"UserRoleDEField" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/userroledefields/save")
    public ResponseEntity<Boolean> save(@RequestBody UserRoleDEFieldDTO userroledefielddto) {
        return ResponseEntity.status(HttpStatus.OK).body(userroledefieldService.save(userroledefieldMapping.toDomain(userroledefielddto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"UserRoleDEField" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/userroledefields/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<UserRoleDEFieldDTO> userroledefielddtos) {
        userroledefieldService.saveBatch(userroledefieldMapping.toDomain(userroledefielddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#userroledefield_id,'Remove',{'Sql',this.userroledefieldMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"UserRoleDEField" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/userroledefields/{userroledefield_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("userroledefield_id") String userroledefield_id) {
         return ResponseEntity.status(HttpStatus.OK).body(userroledefieldService.remove(userroledefield_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"UserRoleDEField" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/userroledefields/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        userroledefieldService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#userroledefield_id,'Get',{'Sql',this.userroledefieldMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"UserRoleDEField" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/userroledefields/{userroledefield_id}")
    public ResponseEntity<UserRoleDEFieldDTO> get(@PathVariable("userroledefield_id") String userroledefield_id) {
        UserRoleDEField domain = userroledefieldService.get(userroledefield_id);
        UserRoleDEFieldDTO dto = userroledefieldMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserRoleDEField-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"UserRoleDEField" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/userroledefields/getdraft")
    public ResponseEntity<UserRoleDEFieldDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(userroledefieldMapping.toDto(userroledefieldService.getDraft(new UserRoleDEField())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserRoleDEField-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"UserRoleDEField" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/userroledefields/fetchdefault")
	public ResponseEntity<List<UserRoleDEFieldDTO>> fetchDefault(UserRoleDEFieldSearchContext context) {
        Page<UserRoleDEField> domains = userroledefieldService.searchDefault(context) ;
        List<UserRoleDEFieldDTO> list = userroledefieldMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserRoleDEField-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"UserRoleDEField" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/userroledefields/searchdefault")
	public ResponseEntity<Page<UserRoleDEFieldDTO>> searchDefault(@RequestBody UserRoleDEFieldSearchContext context) {
        Page<UserRoleDEField> domains = userroledefieldService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(userroledefieldMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
