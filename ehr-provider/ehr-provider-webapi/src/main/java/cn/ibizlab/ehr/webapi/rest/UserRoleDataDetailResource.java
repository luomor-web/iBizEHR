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
import cn.ibizlab.ehr.core.common.domain.UserRoleDataDetail;
import cn.ibizlab.ehr.core.common.service.IUserRoleDataDetailService;
import cn.ibizlab.ehr.core.common.filter.UserRoleDataDetailSearchContext;




@Slf4j
@Api(tags = {"UserRoleDataDetail" })
@RestController("WebApi-userroledatadetail")
@RequestMapping("")
public class UserRoleDataDetailResource {

    @Autowired
    private IUserRoleDataDetailService userroledatadetailService;

    @Autowired
    @Lazy
    public UserRoleDataDetailMapping userroledatadetailMapping;

    public UserRoleDataDetailDTO permissionDTO=new UserRoleDataDetailDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserRoleDataDetail-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"UserRoleDataDetail" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/userroledatadetails/getdraft")
    public ResponseEntity<UserRoleDataDetailDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(userroledatadetailMapping.toDto(userroledatadetailService.getDraft(new UserRoleDataDetail())));
    }

    @PreAuthorize("hasPermission(#userroledatadetail_id,'Remove',{'Sql',this.userroledatadetailMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"UserRoleDataDetail" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/userroledatadetails/{userroledatadetail_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("userroledatadetail_id") String userroledatadetail_id) {
         return ResponseEntity.status(HttpStatus.OK).body(userroledatadetailService.remove(userroledatadetail_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"UserRoleDataDetail" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/userroledatadetails/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        userroledatadetailService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserRoleDataDetail-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"UserRoleDataDetail" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/userroledatadetails/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody UserRoleDataDetailDTO userroledatadetaildto) {
        return  ResponseEntity.status(HttpStatus.OK).body(userroledatadetailService.checkKey(userroledatadetailMapping.toDomain(userroledatadetaildto)));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.userroledatadetailMapping,#userroledatadetaildto})")
    @ApiOperation(value = "Create", tags = {"UserRoleDataDetail" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/userroledatadetails")
    @Transactional
    public ResponseEntity<UserRoleDataDetailDTO> create(@RequestBody UserRoleDataDetailDTO userroledatadetaildto) {
        UserRoleDataDetail domain = userroledatadetailMapping.toDomain(userroledatadetaildto);
		userroledatadetailService.create(domain);
        UserRoleDataDetailDTO dto = userroledatadetailMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"UserRoleDataDetail" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/userroledatadetails/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<UserRoleDataDetailDTO> userroledatadetaildtos) {
        userroledatadetailService.createBatch(userroledatadetailMapping.toDomain(userroledatadetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserRoleDataDetail-Save-all')")
    @ApiOperation(value = "Save", tags = {"UserRoleDataDetail" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/userroledatadetails/save")
    public ResponseEntity<Boolean> save(@RequestBody UserRoleDataDetailDTO userroledatadetaildto) {
        return ResponseEntity.status(HttpStatus.OK).body(userroledatadetailService.save(userroledatadetailMapping.toDomain(userroledatadetaildto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"UserRoleDataDetail" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/userroledatadetails/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<UserRoleDataDetailDTO> userroledatadetaildtos) {
        userroledatadetailService.saveBatch(userroledatadetailMapping.toDomain(userroledatadetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#userroledatadetail_id,'Update',{'Sql',this.userroledatadetailMapping,#userroledatadetaildto})")
    @ApiOperation(value = "Update", tags = {"UserRoleDataDetail" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/userroledatadetails/{userroledatadetail_id}")
    @Transactional
    public ResponseEntity<UserRoleDataDetailDTO> update(@PathVariable("userroledatadetail_id") String userroledatadetail_id, @RequestBody UserRoleDataDetailDTO userroledatadetaildto) {
		UserRoleDataDetail domain = userroledatadetailMapping.toDomain(userroledatadetaildto);
        domain.setUserroledatadetailid(userroledatadetail_id);
		userroledatadetailService.update(domain);
		UserRoleDataDetailDTO dto = userroledatadetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"UserRoleDataDetail" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/userroledatadetails/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<UserRoleDataDetailDTO> userroledatadetaildtos) {
        userroledatadetailService.updateBatch(userroledatadetailMapping.toDomain(userroledatadetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#userroledatadetail_id,'Get',{'Sql',this.userroledatadetailMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"UserRoleDataDetail" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/userroledatadetails/{userroledatadetail_id}")
    public ResponseEntity<UserRoleDataDetailDTO> get(@PathVariable("userroledatadetail_id") String userroledatadetail_id) {
        UserRoleDataDetail domain = userroledatadetailService.get(userroledatadetail_id);
        UserRoleDataDetailDTO dto = userroledatadetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserRoleDataDetail-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"UserRoleDataDetail" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/userroledatadetails/fetchdefault")
	public ResponseEntity<List<UserRoleDataDetailDTO>> fetchDefault(UserRoleDataDetailSearchContext context) {
        Page<UserRoleDataDetail> domains = userroledatadetailService.searchDefault(context) ;
        List<UserRoleDataDetailDTO> list = userroledatadetailMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserRoleDataDetail-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"UserRoleDataDetail" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/userroledatadetails/searchdefault")
	public ResponseEntity<Page<UserRoleDataDetailDTO>> searchDefault(@RequestBody UserRoleDataDetailSearchContext context) {
        Page<UserRoleDataDetail> domains = userroledatadetailService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(userroledatadetailMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
