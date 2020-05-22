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
import cn.ibizlab.ehr.core.wf.domain.WFUser;
import cn.ibizlab.ehr.core.wf.service.IWFUserService;
import cn.ibizlab.ehr.core.wf.filter.WFUserSearchContext;




@Slf4j
@Api(tags = {"WFUser" })
@RestController("WebApi-wfuser")
@RequestMapping("")
public class WFUserResource {

    @Autowired
    private IWFUserService wfuserService;

    @Autowired
    @Lazy
    public WFUserMapping wfuserMapping;

    public WFUserDTO permissionDTO=new WFUserDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFUser-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"WFUser" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/wfusers/getdraft")
    public ResponseEntity<WFUserDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wfuserMapping.toDto(wfuserService.getDraft(new WFUser())));
    }

    @PreAuthorize("hasPermission(#wfuser_id,'Get',{'Sql',this.wfuserMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"WFUser" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/wfusers/{wfuser_id}")
    public ResponseEntity<WFUserDTO> get(@PathVariable("wfuser_id") String wfuser_id) {
        WFUser domain = wfuserService.get(wfuser_id);
        WFUserDTO dto = wfuserMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.wfuserMapping,#wfuserdto})")
    @ApiOperation(value = "Create", tags = {"WFUser" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/wfusers")
    @Transactional
    public ResponseEntity<WFUserDTO> create(@RequestBody WFUserDTO wfuserdto) {
        WFUser domain = wfuserMapping.toDomain(wfuserdto);
		wfuserService.create(domain);
        WFUserDTO dto = wfuserMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"WFUser" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfusers/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WFUserDTO> wfuserdtos) {
        wfuserService.createBatch(wfuserMapping.toDomain(wfuserdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFUser-Save-all')")
    @ApiOperation(value = "Save", tags = {"WFUser" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/wfusers/save")
    public ResponseEntity<Boolean> save(@RequestBody WFUserDTO wfuserdto) {
        return ResponseEntity.status(HttpStatus.OK).body(wfuserService.save(wfuserMapping.toDomain(wfuserdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"WFUser" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfusers/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WFUserDTO> wfuserdtos) {
        wfuserService.saveBatch(wfuserMapping.toDomain(wfuserdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#wfuser_id,'Update',{'Sql',this.wfuserMapping,#wfuserdto})")
    @ApiOperation(value = "Update", tags = {"WFUser" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfusers/{wfuser_id}")
    @Transactional
    public ResponseEntity<WFUserDTO> update(@PathVariable("wfuser_id") String wfuser_id, @RequestBody WFUserDTO wfuserdto) {
		WFUser domain = wfuserMapping.toDomain(wfuserdto);
        domain.setWfuserid(wfuser_id);
		wfuserService.update(domain);
		WFUserDTO dto = wfuserMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"WFUser" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfusers/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WFUserDTO> wfuserdtos) {
        wfuserService.updateBatch(wfuserMapping.toDomain(wfuserdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#wfuser_id,'Remove',{'Sql',this.wfuserMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"WFUser" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfusers/{wfuser_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("wfuser_id") String wfuser_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wfuserService.remove(wfuser_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"WFUser" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfusers/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wfuserService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFUser-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"WFUser" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/wfusers/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WFUserDTO wfuserdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wfuserService.checkKey(wfuserMapping.toDomain(wfuserdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFUser-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"WFUser" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfusers/fetchdefault")
	public ResponseEntity<List<WFUserDTO>> fetchDefault(WFUserSearchContext context) {
        Page<WFUser> domains = wfuserService.searchDefault(context) ;
        List<WFUserDTO> list = wfuserMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFUser-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"WFUser" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/wfusers/searchdefault")
	public ResponseEntity<Page<WFUserDTO>> searchDefault(@RequestBody WFUserSearchContext context) {
        Page<WFUser> domains = wfuserService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfuserMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
