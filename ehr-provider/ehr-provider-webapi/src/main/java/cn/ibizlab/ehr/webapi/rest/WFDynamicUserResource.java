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
import cn.ibizlab.ehr.core.wf.domain.WFDynamicUser;
import cn.ibizlab.ehr.core.wf.service.IWFDynamicUserService;
import cn.ibizlab.ehr.core.wf.filter.WFDynamicUserSearchContext;




@Slf4j
@Api(tags = {"WFDynamicUser" })
@RestController("WebApi-wfdynamicuser")
@RequestMapping("")
public class WFDynamicUserResource {

    @Autowired
    private IWFDynamicUserService wfdynamicuserService;

    @Autowired
    @Lazy
    private WFDynamicUserMapping wfdynamicuserMapping;




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"WFDynamicUser" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/wfdynamicusers")
    @Transactional
    public ResponseEntity<WFDynamicUserDTO> create(@RequestBody WFDynamicUserDTO wfdynamicuserdto) {
        WFDynamicUser domain = wfdynamicuserMapping.toDomain(wfdynamicuserdto);
		wfdynamicuserService.create(domain);
        WFDynamicUserDTO dto = wfdynamicuserMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"WFDynamicUser" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfdynamicusers/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WFDynamicUserDTO> wfdynamicuserdtos) {
        wfdynamicuserService.createBatch(wfdynamicuserMapping.toDomain(wfdynamicuserdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#wfdynamicuser_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"WFDynamicUser" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/wfdynamicusers/{wfdynamicuser_id}")
    public ResponseEntity<WFDynamicUserDTO> get(@PathVariable("wfdynamicuser_id") String wfdynamicuser_id) {
        WFDynamicUser domain = wfdynamicuserService.get(wfdynamicuser_id);
        WFDynamicUserDTO dto = wfdynamicuserMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "Save", tags = {"WFDynamicUser" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/wfdynamicusers/save")
    public ResponseEntity<Boolean> save(@RequestBody WFDynamicUserDTO wfdynamicuserdto) {
        return ResponseEntity.status(HttpStatus.OK).body(wfdynamicuserService.save(wfdynamicuserMapping.toDomain(wfdynamicuserdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"WFDynamicUser" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfdynamicusers/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WFDynamicUserDTO> wfdynamicuserdtos) {
        wfdynamicuserService.saveBatch(wfdynamicuserMapping.toDomain(wfdynamicuserdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"WFDynamicUser" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/wfdynamicusers/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WFDynamicUserDTO wfdynamicuserdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wfdynamicuserService.checkKey(wfdynamicuserMapping.toDomain(wfdynamicuserdto)));
    }




    @ApiOperation(value = "GetDraft", tags = {"WFDynamicUser" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/wfdynamicusers/getdraft")
    public ResponseEntity<WFDynamicUserDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wfdynamicuserMapping.toDto(wfdynamicuserService.getDraft(new WFDynamicUser())));
    }




    @PreAuthorize("hasPermission(#wfdynamicuser_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"WFDynamicUser" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfdynamicusers/{wfdynamicuser_id}")
    @Transactional
    public ResponseEntity<WFDynamicUserDTO> update(@PathVariable("wfdynamicuser_id") String wfdynamicuser_id, @RequestBody WFDynamicUserDTO wfdynamicuserdto) {
		WFDynamicUser domain = wfdynamicuserMapping.toDomain(wfdynamicuserdto);
        domain.setWfdynamicuserid(wfdynamicuser_id);
		wfdynamicuserService.update(domain);
		WFDynamicUserDTO dto = wfdynamicuserMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#wfdynamicuser_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"WFDynamicUser" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfdynamicusers/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WFDynamicUserDTO> wfdynamicuserdtos) {
        wfdynamicuserService.updateBatch(wfdynamicuserMapping.toDomain(wfdynamicuserdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#wfdynamicuser_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"WFDynamicUser" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfdynamicusers/{wfdynamicuser_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("wfdynamicuser_id") String wfdynamicuser_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wfdynamicuserService.remove(wfdynamicuser_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"WFDynamicUser" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfdynamicusers/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wfdynamicuserService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFDynamicUser-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"WFDynamicUser" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfdynamicusers/fetchdefault")
	public ResponseEntity<List<WFDynamicUserDTO>> fetchDefault(WFDynamicUserSearchContext context) {
        Page<WFDynamicUser> domains = wfdynamicuserService.searchDefault(context) ;
        List<WFDynamicUserDTO> list = wfdynamicuserMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFDynamicUser-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"WFDynamicUser" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/wfdynamicusers/searchdefault")
	public ResponseEntity<Page<WFDynamicUserDTO>> searchDefault(@RequestBody WFDynamicUserSearchContext context) {
        Page<WFDynamicUser> domains = wfdynamicuserService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfdynamicuserMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public WFDynamicUser getEntity(){
        return new WFDynamicUser();
    }

}
