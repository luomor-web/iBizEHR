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
import cn.ibizlab.ehr.core.common.domain.UserObject;
import cn.ibizlab.ehr.core.common.service.IUserObjectService;
import cn.ibizlab.ehr.core.common.filter.UserObjectSearchContext;




@Slf4j
@Api(tags = {"UserObject" })
@RestController("WebApi-userobject")
@RequestMapping("")
public class UserObjectResource {

    @Autowired
    private IUserObjectService userobjectService;

    @Autowired
    @Lazy
    public UserObjectMapping userobjectMapping;

    public UserObjectDTO permissionDTO=new UserObjectDTO();

    @PreAuthorize("hasPermission(#userobject_id,'Update',{'Sql',this.userobjectMapping,#userobjectdto})")
    @ApiOperation(value = "Update", tags = {"UserObject" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/userobjects/{userobject_id}")
    @Transactional
    public ResponseEntity<UserObjectDTO> update(@PathVariable("userobject_id") String userobject_id, @RequestBody UserObjectDTO userobjectdto) {
		UserObject domain = userobjectMapping.toDomain(userobjectdto);
        domain.setUserobjectid(userobject_id);
		userobjectService.update(domain);
		UserObjectDTO dto = userobjectMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"UserObject" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/userobjects/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<UserObjectDTO> userobjectdtos) {
        userobjectService.updateBatch(userobjectMapping.toDomain(userobjectdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserObject-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"UserObject" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/userobjects/getdraft")
    public ResponseEntity<UserObjectDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(userobjectMapping.toDto(userobjectService.getDraft(new UserObject())));
    }

    @PreAuthorize("hasPermission(#userobject_id,'Get',{'Sql',this.userobjectMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"UserObject" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/userobjects/{userobject_id}")
    public ResponseEntity<UserObjectDTO> get(@PathVariable("userobject_id") String userobject_id) {
        UserObject domain = userobjectService.get(userobject_id);
        UserObjectDTO dto = userobjectMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserObject-Save-all')")
    @ApiOperation(value = "Save", tags = {"UserObject" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/userobjects/save")
    public ResponseEntity<Boolean> save(@RequestBody UserObjectDTO userobjectdto) {
        return ResponseEntity.status(HttpStatus.OK).body(userobjectService.save(userobjectMapping.toDomain(userobjectdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"UserObject" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/userobjects/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<UserObjectDTO> userobjectdtos) {
        userobjectService.saveBatch(userobjectMapping.toDomain(userobjectdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.userobjectMapping,#userobjectdto})")
    @ApiOperation(value = "Create", tags = {"UserObject" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/userobjects")
    @Transactional
    public ResponseEntity<UserObjectDTO> create(@RequestBody UserObjectDTO userobjectdto) {
        UserObject domain = userobjectMapping.toDomain(userobjectdto);
		userobjectService.create(domain);
        UserObjectDTO dto = userobjectMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"UserObject" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/userobjects/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<UserObjectDTO> userobjectdtos) {
        userobjectService.createBatch(userobjectMapping.toDomain(userobjectdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserObject-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"UserObject" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/userobjects/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody UserObjectDTO userobjectdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(userobjectService.checkKey(userobjectMapping.toDomain(userobjectdto)));
    }

    @PreAuthorize("hasPermission(#userobject_id,'Remove',{'Sql',this.userobjectMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"UserObject" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/userobjects/{userobject_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("userobject_id") String userobject_id) {
         return ResponseEntity.status(HttpStatus.OK).body(userobjectService.remove(userobject_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"UserObject" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/userobjects/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        userobjectService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserObject-IndexDER-all')")
	@ApiOperation(value = "fetchIndexDER", tags = {"UserObject" } ,notes = "fetchIndexDER")
    @RequestMapping(method= RequestMethod.GET , value="/userobjects/fetchindexder")
	public ResponseEntity<List<UserObjectDTO>> fetchIndexDER(UserObjectSearchContext context) {
        Page<UserObject> domains = userobjectService.searchIndexDER(context) ;
        List<UserObjectDTO> list = userobjectMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserObject-IndexDER-all')")
	@ApiOperation(value = "searchIndexDER", tags = {"UserObject" } ,notes = "searchIndexDER")
    @RequestMapping(method= RequestMethod.POST , value="/userobjects/searchindexder")
	public ResponseEntity<Page<UserObjectDTO>> searchIndexDER(@RequestBody UserObjectSearchContext context) {
        Page<UserObject> domains = userobjectService.searchIndexDER(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(userobjectMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserObject-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"UserObject" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/userobjects/fetchdefault")
	public ResponseEntity<List<UserObjectDTO>> fetchDefault(UserObjectSearchContext context) {
        Page<UserObject> domains = userobjectService.searchDefault(context) ;
        List<UserObjectDTO> list = userobjectMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserObject-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"UserObject" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/userobjects/searchdefault")
	public ResponseEntity<Page<UserObjectDTO>> searchDefault(@RequestBody UserObjectSearchContext context) {
        Page<UserObject> domains = userobjectService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(userobjectMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
