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
import cn.ibizlab.ehr.core.common.domain.UserRoleType;
import cn.ibizlab.ehr.core.common.service.IUserRoleTypeService;
import cn.ibizlab.ehr.core.common.filter.UserRoleTypeSearchContext;




@Slf4j
@Api(tags = {"UserRoleType" })
@RestController("WebApi-userroletype")
@RequestMapping("")
public class UserRoleTypeResource {

    @Autowired
    private IUserRoleTypeService userroletypeService;

    @Autowired
    @Lazy
    public UserRoleTypeMapping userroletypeMapping;

    public UserRoleTypeDTO permissionDTO=new UserRoleTypeDTO();




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserRoleType-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"UserRoleType" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/userroletypes/getdraft")
    public ResponseEntity<UserRoleTypeDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(userroletypeMapping.toDto(userroletypeService.getDraft(new UserRoleType())));
    }




    @PreAuthorize("hasPermission(#userroletype_id,'Get',{'Sql',this.userroletypeMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"UserRoleType" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/userroletypes/{userroletype_id}")
    public ResponseEntity<UserRoleTypeDTO> get(@PathVariable("userroletype_id") String userroletype_id) {
        UserRoleType domain = userroletypeService.get(userroletype_id);
        UserRoleTypeDTO dto = userroletypeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#userroletype_id,'Update',{'Sql',this.userroletypeMapping,#userroletypedto})")
    @ApiOperation(value = "Update", tags = {"UserRoleType" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/userroletypes/{userroletype_id}")
    @Transactional
    public ResponseEntity<UserRoleTypeDTO> update(@PathVariable("userroletype_id") String userroletype_id, @RequestBody UserRoleTypeDTO userroletypedto) {
		UserRoleType domain = userroletypeMapping.toDomain(userroletypedto);
        domain.setUserroletypeid(userroletype_id);
		userroletypeService.update(domain);
		UserRoleTypeDTO dto = userroletypeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"UserRoleType" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/userroletypes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<UserRoleTypeDTO> userroletypedtos) {
        userroletypeService.updateBatch(userroletypeMapping.toDomain(userroletypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserRoleType-Save-all')")
    @ApiOperation(value = "Save", tags = {"UserRoleType" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/userroletypes/save")
    public ResponseEntity<Boolean> save(@RequestBody UserRoleTypeDTO userroletypedto) {
        return ResponseEntity.status(HttpStatus.OK).body(userroletypeService.save(userroletypeMapping.toDomain(userroletypedto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"UserRoleType" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/userroletypes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<UserRoleTypeDTO> userroletypedtos) {
        userroletypeService.saveBatch(userroletypeMapping.toDomain(userroletypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#userroletype_id,'Remove',{'Sql',this.userroletypeMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"UserRoleType" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/userroletypes/{userroletype_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("userroletype_id") String userroletype_id) {
         return ResponseEntity.status(HttpStatus.OK).body(userroletypeService.remove(userroletype_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"UserRoleType" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/userroletypes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        userroletypeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserRoleType-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"UserRoleType" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/userroletypes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody UserRoleTypeDTO userroletypedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(userroletypeService.checkKey(userroletypeMapping.toDomain(userroletypedto)));
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.userroletypeMapping,#userroletypedto})")
    @ApiOperation(value = "Create", tags = {"UserRoleType" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/userroletypes")
    @Transactional
    public ResponseEntity<UserRoleTypeDTO> create(@RequestBody UserRoleTypeDTO userroletypedto) {
        UserRoleType domain = userroletypeMapping.toDomain(userroletypedto);
		userroletypeService.create(domain);
        UserRoleTypeDTO dto = userroletypeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"UserRoleType" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/userroletypes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<UserRoleTypeDTO> userroletypedtos) {
        userroletypeService.createBatch(userroletypeMapping.toDomain(userroletypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserRoleType-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"UserRoleType" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/userroletypes/fetchdefault")
	public ResponseEntity<List<UserRoleTypeDTO>> fetchDefault(UserRoleTypeSearchContext context) {
        Page<UserRoleType> domains = userroletypeService.searchDefault(context) ;
        List<UserRoleTypeDTO> list = userroletypeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserRoleType-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"UserRoleType" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/userroletypes/searchdefault")
	public ResponseEntity<Page<UserRoleTypeDTO>> searchDefault(@RequestBody UserRoleTypeSearchContext context) {
        Page<UserRoleType> domains = userroletypeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(userroletypeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


