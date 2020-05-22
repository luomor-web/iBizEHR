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
import cn.ibizlab.ehr.core.common.domain.UserGroupDetail;
import cn.ibizlab.ehr.core.common.service.IUserGroupDetailService;
import cn.ibizlab.ehr.core.common.filter.UserGroupDetailSearchContext;




@Slf4j
@Api(tags = {"UserGroupDetail" })
@RestController("WebApi-usergroupdetail")
@RequestMapping("")
public class UserGroupDetailResource {

    @Autowired
    private IUserGroupDetailService usergroupdetailService;

    @Autowired
    @Lazy
    public UserGroupDetailMapping usergroupdetailMapping;

    public UserGroupDetailDTO permissionDTO=new UserGroupDetailDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserGroupDetail-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"UserGroupDetail" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/usergroupdetails/getdraft")
    public ResponseEntity<UserGroupDetailDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(usergroupdetailMapping.toDto(usergroupdetailService.getDraft(new UserGroupDetail())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserGroupDetail-Save-all')")
    @ApiOperation(value = "Save", tags = {"UserGroupDetail" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/usergroupdetails/save")
    public ResponseEntity<Boolean> save(@RequestBody UserGroupDetailDTO usergroupdetaildto) {
        return ResponseEntity.status(HttpStatus.OK).body(usergroupdetailService.save(usergroupdetailMapping.toDomain(usergroupdetaildto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"UserGroupDetail" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/usergroupdetails/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<UserGroupDetailDTO> usergroupdetaildtos) {
        usergroupdetailService.saveBatch(usergroupdetailMapping.toDomain(usergroupdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#usergroupdetail_id,'Update',{'Sql',this.usergroupdetailMapping,#usergroupdetaildto})")
    @ApiOperation(value = "Update", tags = {"UserGroupDetail" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/usergroupdetails/{usergroupdetail_id}")
    @Transactional
    public ResponseEntity<UserGroupDetailDTO> update(@PathVariable("usergroupdetail_id") String usergroupdetail_id, @RequestBody UserGroupDetailDTO usergroupdetaildto) {
		UserGroupDetail domain = usergroupdetailMapping.toDomain(usergroupdetaildto);
        domain.setUsergroupdetailid(usergroupdetail_id);
		usergroupdetailService.update(domain);
		UserGroupDetailDTO dto = usergroupdetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"UserGroupDetail" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/usergroupdetails/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<UserGroupDetailDTO> usergroupdetaildtos) {
        usergroupdetailService.updateBatch(usergroupdetailMapping.toDomain(usergroupdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#usergroupdetail_id,'Get',{'Sql',this.usergroupdetailMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"UserGroupDetail" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/usergroupdetails/{usergroupdetail_id}")
    public ResponseEntity<UserGroupDetailDTO> get(@PathVariable("usergroupdetail_id") String usergroupdetail_id) {
        UserGroupDetail domain = usergroupdetailService.get(usergroupdetail_id);
        UserGroupDetailDTO dto = usergroupdetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#usergroupdetail_id,'Remove',{'Sql',this.usergroupdetailMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"UserGroupDetail" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/usergroupdetails/{usergroupdetail_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("usergroupdetail_id") String usergroupdetail_id) {
         return ResponseEntity.status(HttpStatus.OK).body(usergroupdetailService.remove(usergroupdetail_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"UserGroupDetail" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/usergroupdetails/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        usergroupdetailService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserGroupDetail-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"UserGroupDetail" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/usergroupdetails/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody UserGroupDetailDTO usergroupdetaildto) {
        return  ResponseEntity.status(HttpStatus.OK).body(usergroupdetailService.checkKey(usergroupdetailMapping.toDomain(usergroupdetaildto)));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.usergroupdetailMapping,#usergroupdetaildto})")
    @ApiOperation(value = "Create", tags = {"UserGroupDetail" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/usergroupdetails")
    @Transactional
    public ResponseEntity<UserGroupDetailDTO> create(@RequestBody UserGroupDetailDTO usergroupdetaildto) {
        UserGroupDetail domain = usergroupdetailMapping.toDomain(usergroupdetaildto);
		usergroupdetailService.create(domain);
        UserGroupDetailDTO dto = usergroupdetailMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"UserGroupDetail" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/usergroupdetails/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<UserGroupDetailDTO> usergroupdetaildtos) {
        usergroupdetailService.createBatch(usergroupdetailMapping.toDomain(usergroupdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserGroupDetail-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"UserGroupDetail" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/usergroupdetails/fetchdefault")
	public ResponseEntity<List<UserGroupDetailDTO>> fetchDefault(UserGroupDetailSearchContext context) {
        Page<UserGroupDetail> domains = usergroupdetailService.searchDefault(context) ;
        List<UserGroupDetailDTO> list = usergroupdetailMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserGroupDetail-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"UserGroupDetail" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/usergroupdetails/searchdefault")
	public ResponseEntity<Page<UserGroupDetailDTO>> searchDefault(@RequestBody UserGroupDetailSearchContext context) {
        Page<UserGroupDetail> domains = usergroupdetailService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(usergroupdetailMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
