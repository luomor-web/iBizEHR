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
import cn.ibizlab.ehr.core.wf.domain.WFUserCandidate;
import cn.ibizlab.ehr.core.wf.service.IWFUserCandidateService;
import cn.ibizlab.ehr.core.wf.filter.WFUserCandidateSearchContext;




@Slf4j
@Api(tags = {"WFUserCandidate" })
@RestController("WebApi-wfusercandidate")
@RequestMapping("")
public class WFUserCandidateResource {

    @Autowired
    private IWFUserCandidateService wfusercandidateService;

    @Autowired
    @Lazy
    public WFUserCandidateMapping wfusercandidateMapping;

    public WFUserCandidateDTO permissionDTO=new WFUserCandidateDTO();

    @PreAuthorize("hasPermission(#wfusercandidate_id,'Get',{'Sql',this.wfusercandidateMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"WFUserCandidate" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/wfusercandidates/{wfusercandidate_id}")
    public ResponseEntity<WFUserCandidateDTO> get(@PathVariable("wfusercandidate_id") String wfusercandidate_id) {
        WFUserCandidate domain = wfusercandidateService.get(wfusercandidate_id);
        WFUserCandidateDTO dto = wfusercandidateMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.wfusercandidateMapping,#wfusercandidatedto})")
    @ApiOperation(value = "Create", tags = {"WFUserCandidate" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/wfusercandidates")
    @Transactional
    public ResponseEntity<WFUserCandidateDTO> create(@RequestBody WFUserCandidateDTO wfusercandidatedto) {
        WFUserCandidate domain = wfusercandidateMapping.toDomain(wfusercandidatedto);
		wfusercandidateService.create(domain);
        WFUserCandidateDTO dto = wfusercandidateMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"WFUserCandidate" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfusercandidates/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WFUserCandidateDTO> wfusercandidatedtos) {
        wfusercandidateService.createBatch(wfusercandidateMapping.toDomain(wfusercandidatedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#wfusercandidate_id,'Remove',{'Sql',this.wfusercandidateMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"WFUserCandidate" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfusercandidates/{wfusercandidate_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("wfusercandidate_id") String wfusercandidate_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wfusercandidateService.remove(wfusercandidate_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"WFUserCandidate" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfusercandidates/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wfusercandidateService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#wfusercandidate_id,'Update',{'Sql',this.wfusercandidateMapping,#wfusercandidatedto})")
    @ApiOperation(value = "Update", tags = {"WFUserCandidate" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfusercandidates/{wfusercandidate_id}")
    @Transactional
    public ResponseEntity<WFUserCandidateDTO> update(@PathVariable("wfusercandidate_id") String wfusercandidate_id, @RequestBody WFUserCandidateDTO wfusercandidatedto) {
		WFUserCandidate domain = wfusercandidateMapping.toDomain(wfusercandidatedto);
        domain.setWfusercandidateid(wfusercandidate_id);
		wfusercandidateService.update(domain);
		WFUserCandidateDTO dto = wfusercandidateMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"WFUserCandidate" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfusercandidates/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WFUserCandidateDTO> wfusercandidatedtos) {
        wfusercandidateService.updateBatch(wfusercandidateMapping.toDomain(wfusercandidatedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFUserCandidate-Save-all')")
    @ApiOperation(value = "Save", tags = {"WFUserCandidate" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/wfusercandidates/save")
    public ResponseEntity<Boolean> save(@RequestBody WFUserCandidateDTO wfusercandidatedto) {
        return ResponseEntity.status(HttpStatus.OK).body(wfusercandidateService.save(wfusercandidateMapping.toDomain(wfusercandidatedto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"WFUserCandidate" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfusercandidates/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WFUserCandidateDTO> wfusercandidatedtos) {
        wfusercandidateService.saveBatch(wfusercandidateMapping.toDomain(wfusercandidatedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFUserCandidate-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"WFUserCandidate" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/wfusercandidates/getdraft")
    public ResponseEntity<WFUserCandidateDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wfusercandidateMapping.toDto(wfusercandidateService.getDraft(new WFUserCandidate())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFUserCandidate-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"WFUserCandidate" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/wfusercandidates/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WFUserCandidateDTO wfusercandidatedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wfusercandidateService.checkKey(wfusercandidateMapping.toDomain(wfusercandidatedto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFUserCandidate-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"WFUserCandidate" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfusercandidates/fetchdefault")
	public ResponseEntity<List<WFUserCandidateDTO>> fetchDefault(WFUserCandidateSearchContext context) {
        Page<WFUserCandidate> domains = wfusercandidateService.searchDefault(context) ;
        List<WFUserCandidateDTO> list = wfusercandidateMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFUserCandidate-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"WFUserCandidate" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/wfusercandidates/searchdefault")
	public ResponseEntity<Page<WFUserCandidateDTO>> searchDefault(@RequestBody WFUserCandidateSearchContext context) {
        Page<WFUserCandidate> domains = wfusercandidateService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfusercandidateMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
