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
import cn.ibizlab.ehr.core.wf.domain.WFUserGroup;
import cn.ibizlab.ehr.core.wf.service.IWFUserGroupService;
import cn.ibizlab.ehr.core.wf.filter.WFUserGroupSearchContext;




@Slf4j
@Api(tags = {"WFUserGroup" })
@RestController("WebApi-wfusergroup")
@RequestMapping("")
public class WFUserGroupResource {

    @Autowired
    private IWFUserGroupService wfusergroupService;

    @Autowired
    @Lazy
    private WFUserGroupMapping wfusergroupMapping;




    @ApiOperation(value = "Save", tags = {"WFUserGroup" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/wfusergroups/save")
    public ResponseEntity<Boolean> save(@RequestBody WFUserGroupDTO wfusergroupdto) {
        return ResponseEntity.status(HttpStatus.OK).body(wfusergroupService.save(wfusergroupMapping.toDomain(wfusergroupdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"WFUserGroup" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfusergroups/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WFUserGroupDTO> wfusergroupdtos) {
        wfusergroupService.saveBatch(wfusergroupMapping.toDomain(wfusergroupdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"WFUserGroup" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/wfusergroups")
    @Transactional
    public ResponseEntity<WFUserGroupDTO> create(@RequestBody WFUserGroupDTO wfusergroupdto) {
        WFUserGroup domain = wfusergroupMapping.toDomain(wfusergroupdto);
		wfusergroupService.create(domain);
        WFUserGroupDTO dto = wfusergroupMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"WFUserGroup" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfusergroups/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WFUserGroupDTO> wfusergroupdtos) {
        wfusergroupService.createBatch(wfusergroupMapping.toDomain(wfusergroupdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"WFUserGroup" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/wfusergroups/getdraft")
    public ResponseEntity<WFUserGroupDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wfusergroupMapping.toDto(wfusergroupService.getDraft(new WFUserGroup())));
    }




    @PreAuthorize("hasPermission(#wfusergroup_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"WFUserGroup" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/wfusergroups/{wfusergroup_id}")
    public ResponseEntity<WFUserGroupDTO> get(@PathVariable("wfusergroup_id") String wfusergroup_id) {
        WFUserGroup domain = wfusergroupService.get(wfusergroup_id);
        WFUserGroupDTO dto = wfusergroupMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "CheckKey", tags = {"WFUserGroup" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/wfusergroups/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WFUserGroupDTO wfusergroupdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wfusergroupService.checkKey(wfusergroupMapping.toDomain(wfusergroupdto)));
    }




    @PreAuthorize("hasPermission(#wfusergroup_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"WFUserGroup" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfusergroups/{wfusergroup_id}")
    @Transactional
    public ResponseEntity<WFUserGroupDTO> update(@PathVariable("wfusergroup_id") String wfusergroup_id, @RequestBody WFUserGroupDTO wfusergroupdto) {
		WFUserGroup domain = wfusergroupMapping.toDomain(wfusergroupdto);
        domain.setWfusergroupid(wfusergroup_id);
		wfusergroupService.update(domain);
		WFUserGroupDTO dto = wfusergroupMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#wfusergroup_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"WFUserGroup" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfusergroups/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WFUserGroupDTO> wfusergroupdtos) {
        wfusergroupService.updateBatch(wfusergroupMapping.toDomain(wfusergroupdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#wfusergroup_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"WFUserGroup" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfusergroups/{wfusergroup_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("wfusergroup_id") String wfusergroup_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wfusergroupService.remove(wfusergroup_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"WFUserGroup" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfusergroups/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wfusergroupService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFUserGroup-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"WFUserGroup" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfusergroups/fetchdefault")
	public ResponseEntity<List<WFUserGroupDTO>> fetchDefault(WFUserGroupSearchContext context) {
        Page<WFUserGroup> domains = wfusergroupService.searchDefault(context) ;
        List<WFUserGroupDTO> list = wfusergroupMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFUserGroup-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"WFUserGroup" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/wfusergroups/searchdefault")
	public ResponseEntity<Page<WFUserGroupDTO>> searchDefault(@RequestBody WFUserGroupSearchContext context) {
        Page<WFUserGroup> domains = wfusergroupService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfusergroupMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public WFUserGroup getEntity(){
        return new WFUserGroup();
    }

}
