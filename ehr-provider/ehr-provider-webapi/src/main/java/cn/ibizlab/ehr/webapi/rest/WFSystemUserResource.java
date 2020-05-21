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
import cn.ibizlab.ehr.core.wf.domain.WFSystemUser;
import cn.ibizlab.ehr.core.wf.service.IWFSystemUserService;
import cn.ibizlab.ehr.core.wf.filter.WFSystemUserSearchContext;




@Slf4j
@Api(tags = {"WFSystemUser" })
@RestController("WebApi-wfsystemuser")
@RequestMapping("")
public class WFSystemUserResource {

    @Autowired
    private IWFSystemUserService wfsystemuserService;

    @Autowired
    @Lazy
    public WFSystemUserMapping wfsystemuserMapping;

    public WFSystemUserDTO permissionDTO=new WFSystemUserDTO();




    @PreAuthorize("hasPermission('','Create',{'Sql',this.wfsystemuserMapping,#wfsystemuserdto})")
    @ApiOperation(value = "Create", tags = {"WFSystemUser" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/wfsystemusers")
    @Transactional
    public ResponseEntity<WFSystemUserDTO> create(@RequestBody WFSystemUserDTO wfsystemuserdto) {
        WFSystemUser domain = wfsystemuserMapping.toDomain(wfsystemuserdto);
		wfsystemuserService.create(domain);
        WFSystemUserDTO dto = wfsystemuserMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"WFSystemUser" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfsystemusers/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WFSystemUserDTO> wfsystemuserdtos) {
        wfsystemuserService.createBatch(wfsystemuserMapping.toDomain(wfsystemuserdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFSystemUser-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"WFSystemUser" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/wfsystemusers/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WFSystemUserDTO wfsystemuserdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wfsystemuserService.checkKey(wfsystemuserMapping.toDomain(wfsystemuserdto)));
    }




    @PreAuthorize("hasPermission(#wfsystemuser_id,'Get',{'Sql',this.wfsystemuserMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"WFSystemUser" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/wfsystemusers/{wfsystemuser_id}")
    public ResponseEntity<WFSystemUserDTO> get(@PathVariable("wfsystemuser_id") String wfsystemuser_id) {
        WFSystemUser domain = wfsystemuserService.get(wfsystemuser_id);
        WFSystemUserDTO dto = wfsystemuserMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFSystemUser-Save-all')")
    @ApiOperation(value = "Save", tags = {"WFSystemUser" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/wfsystemusers/save")
    public ResponseEntity<Boolean> save(@RequestBody WFSystemUserDTO wfsystemuserdto) {
        return ResponseEntity.status(HttpStatus.OK).body(wfsystemuserService.save(wfsystemuserMapping.toDomain(wfsystemuserdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"WFSystemUser" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfsystemusers/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WFSystemUserDTO> wfsystemuserdtos) {
        wfsystemuserService.saveBatch(wfsystemuserMapping.toDomain(wfsystemuserdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#wfsystemuser_id,'Remove',{'Sql',this.wfsystemuserMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"WFSystemUser" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfsystemusers/{wfsystemuser_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("wfsystemuser_id") String wfsystemuser_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wfsystemuserService.remove(wfsystemuser_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"WFSystemUser" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfsystemusers/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wfsystemuserService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFSystemUser-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"WFSystemUser" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/wfsystemusers/getdraft")
    public ResponseEntity<WFSystemUserDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wfsystemuserMapping.toDto(wfsystemuserService.getDraft(new WFSystemUser())));
    }




    @PreAuthorize("hasPermission(#wfsystemuser_id,'Update',{'Sql',this.wfsystemuserMapping,#wfsystemuserdto})")
    @ApiOperation(value = "Update", tags = {"WFSystemUser" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfsystemusers/{wfsystemuser_id}")
    @Transactional
    public ResponseEntity<WFSystemUserDTO> update(@PathVariable("wfsystemuser_id") String wfsystemuser_id, @RequestBody WFSystemUserDTO wfsystemuserdto) {
		WFSystemUser domain = wfsystemuserMapping.toDomain(wfsystemuserdto);
        domain.setWfsystemuserid(wfsystemuser_id);
		wfsystemuserService.update(domain);
		WFSystemUserDTO dto = wfsystemuserMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"WFSystemUser" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfsystemusers/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WFSystemUserDTO> wfsystemuserdtos) {
        wfsystemuserService.updateBatch(wfsystemuserMapping.toDomain(wfsystemuserdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFSystemUser-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"WFSystemUser" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfsystemusers/fetchdefault")
	public ResponseEntity<List<WFSystemUserDTO>> fetchDefault(WFSystemUserSearchContext context) {
        Page<WFSystemUser> domains = wfsystemuserService.searchDefault(context) ;
        List<WFSystemUserDTO> list = wfsystemuserMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFSystemUser-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"WFSystemUser" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/wfsystemusers/searchdefault")
	public ResponseEntity<Page<WFSystemUserDTO>> searchDefault(@RequestBody WFSystemUserSearchContext context) {
        Page<WFSystemUser> domains = wfsystemuserService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfsystemuserMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


