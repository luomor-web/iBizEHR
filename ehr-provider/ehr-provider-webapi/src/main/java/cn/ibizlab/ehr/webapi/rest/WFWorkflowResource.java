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
import cn.ibizlab.ehr.core.wf.domain.WFWorkflow;
import cn.ibizlab.ehr.core.wf.service.IWFWorkflowService;
import cn.ibizlab.ehr.core.wf.filter.WFWorkflowSearchContext;




@Slf4j
@Api(tags = {"WFWorkflow" })
@RestController("WebApi-wfworkflow")
@RequestMapping("")
public class WFWorkflowResource {

    @Autowired
    private IWFWorkflowService wfworkflowService;

    @Autowired
    @Lazy
    private WFWorkflowMapping wfworkflowMapping;




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"WFWorkflow" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/wfworkflows")
    @Transactional
    public ResponseEntity<WFWorkflowDTO> create(@RequestBody WFWorkflowDTO wfworkflowdto) {
        WFWorkflow domain = wfworkflowMapping.toDomain(wfworkflowdto);
		wfworkflowService.create(domain);
        WFWorkflowDTO dto = wfworkflowMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"WFWorkflow" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfworkflows/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WFWorkflowDTO> wfworkflowdtos) {
        wfworkflowService.createBatch(wfworkflowMapping.toDomain(wfworkflowdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#wfworkflow_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"WFWorkflow" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfworkflows/{wfworkflow_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("wfworkflow_id") String wfworkflow_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wfworkflowService.remove(wfworkflow_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"WFWorkflow" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfworkflows/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wfworkflowService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"WFWorkflow" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/wfworkflows/save")
    public ResponseEntity<Boolean> save(@RequestBody WFWorkflowDTO wfworkflowdto) {
        return ResponseEntity.status(HttpStatus.OK).body(wfworkflowService.save(wfworkflowMapping.toDomain(wfworkflowdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"WFWorkflow" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfworkflows/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WFWorkflowDTO> wfworkflowdtos) {
        wfworkflowService.saveBatch(wfworkflowMapping.toDomain(wfworkflowdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#wfworkflow_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"WFWorkflow" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfworkflows/{wfworkflow_id}")
    @Transactional
    public ResponseEntity<WFWorkflowDTO> update(@PathVariable("wfworkflow_id") String wfworkflow_id, @RequestBody WFWorkflowDTO wfworkflowdto) {
		WFWorkflow domain = wfworkflowMapping.toDomain(wfworkflowdto);
        domain.setWfworkflowid(wfworkflow_id);
		wfworkflowService.update(domain);
		WFWorkflowDTO dto = wfworkflowMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#wfworkflow_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"WFWorkflow" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfworkflows/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WFWorkflowDTO> wfworkflowdtos) {
        wfworkflowService.updateBatch(wfworkflowMapping.toDomain(wfworkflowdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"WFWorkflow" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/wfworkflows/getdraft")
    public ResponseEntity<WFWorkflowDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wfworkflowMapping.toDto(wfworkflowService.getDraft(new WFWorkflow())));
    }




    @PreAuthorize("hasPermission(#wfworkflow_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"WFWorkflow" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/wfworkflows/{wfworkflow_id}")
    public ResponseEntity<WFWorkflowDTO> get(@PathVariable("wfworkflow_id") String wfworkflow_id) {
        WFWorkflow domain = wfworkflowService.get(wfworkflow_id);
        WFWorkflowDTO dto = wfworkflowMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "CheckKey", tags = {"WFWorkflow" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/wfworkflows/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WFWorkflowDTO wfworkflowdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wfworkflowService.checkKey(wfworkflowMapping.toDomain(wfworkflowdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFWorkflow-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"WFWorkflow" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfworkflows/fetchdefault")
	public ResponseEntity<List<WFWorkflowDTO>> fetchDefault(WFWorkflowSearchContext context) {
        Page<WFWorkflow> domains = wfworkflowService.searchDefault(context) ;
        List<WFWorkflowDTO> list = wfworkflowMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFWorkflow-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"WFWorkflow" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/wfworkflows/searchdefault")
	public ResponseEntity<Page<WFWorkflowDTO>> searchDefault(@RequestBody WFWorkflowSearchContext context) {
        Page<WFWorkflow> domains = wfworkflowService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfworkflowMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public WFWorkflow getEntity(){
        return new WFWorkflow();
    }

}
