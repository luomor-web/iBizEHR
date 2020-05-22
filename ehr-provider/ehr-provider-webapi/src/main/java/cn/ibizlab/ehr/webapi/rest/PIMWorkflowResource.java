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
import cn.ibizlab.ehr.core.pim.domain.PIMWorkflow;
import cn.ibizlab.ehr.core.pim.service.IPIMWorkflowService;
import cn.ibizlab.ehr.core.pim.filter.PIMWorkflowSearchContext;




@Slf4j
@Api(tags = {"PIMWorkflow" })
@RestController("WebApi-pimworkflow")
@RequestMapping("")
public class PIMWorkflowResource {

    @Autowired
    private IPIMWorkflowService pimworkflowService;

    @Autowired
    @Lazy
    public PIMWorkflowMapping pimworkflowMapping;

    public PIMWorkflowDTO permissionDTO=new PIMWorkflowDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMWorkflow-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PIMWorkflow" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimworkflows/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMWorkflowDTO pimworkflowdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimworkflowService.checkKey(pimworkflowMapping.toDomain(pimworkflowdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMWorkflow-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PIMWorkflow" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimworkflows/getdraft")
    public ResponseEntity<PIMWorkflowDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimworkflowMapping.toDto(pimworkflowService.getDraft(new PIMWorkflow())));
    }

    @PreAuthorize("hasPermission(#pimworkflow_id,'Remove',{'Sql',this.pimworkflowMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PIMWorkflow" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimworkflows/{pimworkflow_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimworkflow_id") String pimworkflow_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimworkflowService.remove(pimworkflow_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PIMWorkflow" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimworkflows/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimworkflowService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMWorkflow-Save-all')")
    @ApiOperation(value = "Save", tags = {"PIMWorkflow" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimworkflows/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMWorkflowDTO pimworkflowdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimworkflowService.save(pimworkflowMapping.toDomain(pimworkflowdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PIMWorkflow" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimworkflows/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMWorkflowDTO> pimworkflowdtos) {
        pimworkflowService.saveBatch(pimworkflowMapping.toDomain(pimworkflowdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMWorkflow-Sync-all')")
    @ApiOperation(value = "同步平台流程", tags = {"PIMWorkflow" },  notes = "同步平台流程")
	@RequestMapping(method = RequestMethod.POST, value = "/pimworkflows/{pimworkflow_id}/sync")
    @Transactional
    public ResponseEntity<PIMWorkflowDTO> sync(@PathVariable("pimworkflow_id") String pimworkflow_id, @RequestBody PIMWorkflowDTO pimworkflowdto) {
        PIMWorkflow pimworkflow = pimworkflowMapping.toDomain(pimworkflowdto);
        pimworkflow = pimworkflowService.sync(pimworkflow);
        pimworkflowdto = pimworkflowMapping.toDto(pimworkflow);
        return ResponseEntity.status(HttpStatus.OK).body(pimworkflowdto);
    }

    @PreAuthorize("hasPermission(#pimworkflow_id,'Get',{'Sql',this.pimworkflowMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PIMWorkflow" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimworkflows/{pimworkflow_id}")
    public ResponseEntity<PIMWorkflowDTO> get(@PathVariable("pimworkflow_id") String pimworkflow_id) {
        PIMWorkflow domain = pimworkflowService.get(pimworkflow_id);
        PIMWorkflowDTO dto = pimworkflowMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pimworkflow_id,'Update',{'Sql',this.pimworkflowMapping,#pimworkflowdto})")
    @ApiOperation(value = "Update", tags = {"PIMWorkflow" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimworkflows/{pimworkflow_id}")
    @Transactional
    public ResponseEntity<PIMWorkflowDTO> update(@PathVariable("pimworkflow_id") String pimworkflow_id, @RequestBody PIMWorkflowDTO pimworkflowdto) {
		PIMWorkflow domain = pimworkflowMapping.toDomain(pimworkflowdto);
        domain.setPimworkflowid(pimworkflow_id);
		pimworkflowService.update(domain);
		PIMWorkflowDTO dto = pimworkflowMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMWorkflow" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimworkflows/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMWorkflowDTO> pimworkflowdtos) {
        pimworkflowService.updateBatch(pimworkflowMapping.toDomain(pimworkflowdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pimworkflowMapping,#pimworkflowdto})")
    @ApiOperation(value = "Create", tags = {"PIMWorkflow" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimworkflows")
    @Transactional
    public ResponseEntity<PIMWorkflowDTO> create(@RequestBody PIMWorkflowDTO pimworkflowdto) {
        PIMWorkflow domain = pimworkflowMapping.toDomain(pimworkflowdto);
		pimworkflowService.create(domain);
        PIMWorkflowDTO dto = pimworkflowMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"PIMWorkflow" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimworkflows/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMWorkflowDTO> pimworkflowdtos) {
        pimworkflowService.createBatch(pimworkflowMapping.toDomain(pimworkflowdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMWorkflow-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMWorkflow" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimworkflows/fetchdefault")
	public ResponseEntity<List<PIMWorkflowDTO>> fetchDefault(PIMWorkflowSearchContext context) {
        Page<PIMWorkflow> domains = pimworkflowService.searchDefault(context) ;
        List<PIMWorkflowDTO> list = pimworkflowMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMWorkflow-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMWorkflow" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimworkflows/searchdefault")
	public ResponseEntity<Page<PIMWorkflowDTO>> searchDefault(@RequestBody PIMWorkflowSearchContext context) {
        Page<PIMWorkflow> domains = pimworkflowService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimworkflowMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
