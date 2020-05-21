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
import cn.ibizlab.ehr.core.common.domain.UserRoleDataAction;
import cn.ibizlab.ehr.core.common.service.IUserRoleDataActionService;
import cn.ibizlab.ehr.core.common.filter.UserRoleDataActionSearchContext;




@Slf4j
@Api(tags = {"UserRoleDataAction" })
@RestController("WebApi-userroledataaction")
@RequestMapping("")
public class UserRoleDataActionResource {

    @Autowired
    private IUserRoleDataActionService userroledataactionService;

    @Autowired
    @Lazy
    public UserRoleDataActionMapping userroledataactionMapping;

    public UserRoleDataActionDTO permissionDTO=new UserRoleDataActionDTO();




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserRoleDataAction-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"UserRoleDataAction" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/userroledataactions/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody UserRoleDataActionDTO userroledataactiondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(userroledataactionService.checkKey(userroledataactionMapping.toDomain(userroledataactiondto)));
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserRoleDataAction-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"UserRoleDataAction" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/userroledataactions/getdraft")
    public ResponseEntity<UserRoleDataActionDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(userroledataactionMapping.toDto(userroledataactionService.getDraft(new UserRoleDataAction())));
    }




    @PreAuthorize("hasPermission(#userroledataaction_id,'Get',{'Sql',this.userroledataactionMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"UserRoleDataAction" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/userroledataactions/{userroledataaction_id}")
    public ResponseEntity<UserRoleDataActionDTO> get(@PathVariable("userroledataaction_id") String userroledataaction_id) {
        UserRoleDataAction domain = userroledataactionService.get(userroledataaction_id);
        UserRoleDataActionDTO dto = userroledataactionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#userroledataaction_id,'Update',{'Sql',this.userroledataactionMapping,#userroledataactiondto})")
    @ApiOperation(value = "Update", tags = {"UserRoleDataAction" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/userroledataactions/{userroledataaction_id}")
    @Transactional
    public ResponseEntity<UserRoleDataActionDTO> update(@PathVariable("userroledataaction_id") String userroledataaction_id, @RequestBody UserRoleDataActionDTO userroledataactiondto) {
		UserRoleDataAction domain = userroledataactionMapping.toDomain(userroledataactiondto);
        domain.setUserroledataactionid(userroledataaction_id);
		userroledataactionService.update(domain);
		UserRoleDataActionDTO dto = userroledataactionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"UserRoleDataAction" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/userroledataactions/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<UserRoleDataActionDTO> userroledataactiondtos) {
        userroledataactionService.updateBatch(userroledataactionMapping.toDomain(userroledataactiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.userroledataactionMapping,#userroledataactiondto})")
    @ApiOperation(value = "Create", tags = {"UserRoleDataAction" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/userroledataactions")
    @Transactional
    public ResponseEntity<UserRoleDataActionDTO> create(@RequestBody UserRoleDataActionDTO userroledataactiondto) {
        UserRoleDataAction domain = userroledataactionMapping.toDomain(userroledataactiondto);
		userroledataactionService.create(domain);
        UserRoleDataActionDTO dto = userroledataactionMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"UserRoleDataAction" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/userroledataactions/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<UserRoleDataActionDTO> userroledataactiondtos) {
        userroledataactionService.createBatch(userroledataactionMapping.toDomain(userroledataactiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#userroledataaction_id,'Remove',{'Sql',this.userroledataactionMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"UserRoleDataAction" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/userroledataactions/{userroledataaction_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("userroledataaction_id") String userroledataaction_id) {
         return ResponseEntity.status(HttpStatus.OK).body(userroledataactionService.remove(userroledataaction_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"UserRoleDataAction" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/userroledataactions/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        userroledataactionService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserRoleDataAction-Save-all')")
    @ApiOperation(value = "Save", tags = {"UserRoleDataAction" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/userroledataactions/save")
    public ResponseEntity<Boolean> save(@RequestBody UserRoleDataActionDTO userroledataactiondto) {
        return ResponseEntity.status(HttpStatus.OK).body(userroledataactionService.save(userroledataactionMapping.toDomain(userroledataactiondto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"UserRoleDataAction" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/userroledataactions/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<UserRoleDataActionDTO> userroledataactiondtos) {
        userroledataactionService.saveBatch(userroledataactionMapping.toDomain(userroledataactiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserRoleDataAction-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"UserRoleDataAction" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/userroledataactions/fetchdefault")
	public ResponseEntity<List<UserRoleDataActionDTO>> fetchDefault(UserRoleDataActionSearchContext context) {
        Page<UserRoleDataAction> domains = userroledataactionService.searchDefault(context) ;
        List<UserRoleDataActionDTO> list = userroledataactionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserRoleDataAction-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"UserRoleDataAction" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/userroledataactions/searchdefault")
	public ResponseEntity<Page<UserRoleDataActionDTO>> searchDefault(@RequestBody UserRoleDataActionSearchContext context) {
        Page<UserRoleDataAction> domains = userroledataactionService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(userroledataactionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


