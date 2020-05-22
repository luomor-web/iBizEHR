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
import cn.ibizlab.ehr.core.wf.domain.WFReminder;
import cn.ibizlab.ehr.core.wf.service.IWFReminderService;
import cn.ibizlab.ehr.core.wf.filter.WFReminderSearchContext;




@Slf4j
@Api(tags = {"WFReminder" })
@RestController("WebApi-wfreminder")
@RequestMapping("")
public class WFReminderResource {

    @Autowired
    private IWFReminderService wfreminderService;

    @Autowired
    @Lazy
    public WFReminderMapping wfreminderMapping;

    public WFReminderDTO permissionDTO=new WFReminderDTO();

    @PreAuthorize("hasPermission(#wfreminder_id,'Remove',{'Sql',this.wfreminderMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"WFReminder" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfreminders/{wfreminder_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("wfreminder_id") String wfreminder_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wfreminderService.remove(wfreminder_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"WFReminder" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfreminders/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wfreminderService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.wfreminderMapping,#wfreminderdto})")
    @ApiOperation(value = "Create", tags = {"WFReminder" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/wfreminders")
    @Transactional
    public ResponseEntity<WFReminderDTO> create(@RequestBody WFReminderDTO wfreminderdto) {
        WFReminder domain = wfreminderMapping.toDomain(wfreminderdto);
		wfreminderService.create(domain);
        WFReminderDTO dto = wfreminderMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"WFReminder" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfreminders/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WFReminderDTO> wfreminderdtos) {
        wfreminderService.createBatch(wfreminderMapping.toDomain(wfreminderdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFReminder-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"WFReminder" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/wfreminders/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WFReminderDTO wfreminderdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wfreminderService.checkKey(wfreminderMapping.toDomain(wfreminderdto)));
    }

    @PreAuthorize("hasPermission(#wfreminder_id,'Get',{'Sql',this.wfreminderMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"WFReminder" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/wfreminders/{wfreminder_id}")
    public ResponseEntity<WFReminderDTO> get(@PathVariable("wfreminder_id") String wfreminder_id) {
        WFReminder domain = wfreminderService.get(wfreminder_id);
        WFReminderDTO dto = wfreminderMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFReminder-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"WFReminder" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/wfreminders/getdraft")
    public ResponseEntity<WFReminderDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wfreminderMapping.toDto(wfreminderService.getDraft(new WFReminder())));
    }

    @PreAuthorize("hasPermission(#wfreminder_id,'Update',{'Sql',this.wfreminderMapping,#wfreminderdto})")
    @ApiOperation(value = "Update", tags = {"WFReminder" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfreminders/{wfreminder_id}")
    @Transactional
    public ResponseEntity<WFReminderDTO> update(@PathVariable("wfreminder_id") String wfreminder_id, @RequestBody WFReminderDTO wfreminderdto) {
		WFReminder domain = wfreminderMapping.toDomain(wfreminderdto);
        domain.setWfreminderid(wfreminder_id);
		wfreminderService.update(domain);
		WFReminderDTO dto = wfreminderMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"WFReminder" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfreminders/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WFReminderDTO> wfreminderdtos) {
        wfreminderService.updateBatch(wfreminderMapping.toDomain(wfreminderdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFReminder-Save-all')")
    @ApiOperation(value = "Save", tags = {"WFReminder" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/wfreminders/save")
    public ResponseEntity<Boolean> save(@RequestBody WFReminderDTO wfreminderdto) {
        return ResponseEntity.status(HttpStatus.OK).body(wfreminderService.save(wfreminderMapping.toDomain(wfreminderdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"WFReminder" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfreminders/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WFReminderDTO> wfreminderdtos) {
        wfreminderService.saveBatch(wfreminderMapping.toDomain(wfreminderdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFReminder-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"WFReminder" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfreminders/fetchdefault")
	public ResponseEntity<List<WFReminderDTO>> fetchDefault(WFReminderSearchContext context) {
        Page<WFReminder> domains = wfreminderService.searchDefault(context) ;
        List<WFReminderDTO> list = wfreminderMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFReminder-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"WFReminder" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/wfreminders/searchdefault")
	public ResponseEntity<Page<WFReminderDTO>> searchDefault(@RequestBody WFReminderSearchContext context) {
        Page<WFReminder> domains = wfreminderService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfreminderMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
