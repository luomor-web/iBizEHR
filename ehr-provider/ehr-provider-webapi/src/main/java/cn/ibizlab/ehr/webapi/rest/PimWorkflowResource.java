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
import org.springframework.security.access.prepost.PostAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import cn.ibizlab.ehr.webapi.dto.*;
import cn.ibizlab.ehr.webapi.mapping.*;
import cn.ibizlab.ehr.core.pim.domain.PimWorkflow;
import cn.ibizlab.ehr.core.pim.service.IPimWorkflowService;
import cn.ibizlab.ehr.core.pim.filter.PimWorkflowSearchContext;

@Slf4j
@Api(tags = {"流程配置" })
@RestController("WebApi-pimworkflow")
@RequestMapping("")
public class PimWorkflowResource {

    @Autowired
    public IPimWorkflowService pimworkflowService;

    @Autowired
    @Lazy
    public PimWorkflowMapping pimworkflowMapping;

    @ApiOperation(value = "检查流程配置", tags = {"流程配置" },  notes = "检查流程配置")
	@RequestMapping(method = RequestMethod.POST, value = "/pimworkflows/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimWorkflowDTO pimworkflowdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimworkflowService.checkKey(pimworkflowMapping.toDomain(pimworkflowdto)));
    }

    @ApiOperation(value = "获取流程配置草稿", tags = {"流程配置" },  notes = "获取流程配置草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimworkflows/getdraft")
    public ResponseEntity<PimWorkflowDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimworkflowMapping.toDto(pimworkflowService.getDraft(new PimWorkflow())));
    }

    @PreAuthorize("hasPermission(this.pimworkflowService.get(#pimworkflow_id),'ehr-PimWorkflow-Remove')")
    @ApiOperation(value = "删除流程配置", tags = {"流程配置" },  notes = "删除流程配置")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimworkflows/{pimworkflow_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimworkflow_id") String pimworkflow_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimworkflowService.remove(pimworkflow_id));
    }

    @PreAuthorize("hasPermission(this.pimworkflowService.getPimworkflowByIds(#ids),'ehr-PimWorkflow-Remove')")
    @ApiOperation(value = "批量删除流程配置", tags = {"流程配置" },  notes = "批量删除流程配置")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimworkflows/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimworkflowService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimworkflowMapping.toDomain(#pimworkflowdto),'ehr-PimWorkflow-Save')")
    @ApiOperation(value = "保存流程配置", tags = {"流程配置" },  notes = "保存流程配置")
	@RequestMapping(method = RequestMethod.POST, value = "/pimworkflows/save")
    public ResponseEntity<Boolean> save(@RequestBody PimWorkflowDTO pimworkflowdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimworkflowService.save(pimworkflowMapping.toDomain(pimworkflowdto)));
    }

    @PreAuthorize("hasPermission(this.pimworkflowMapping.toDomain(#pimworkflowdtos),'ehr-PimWorkflow-Save')")
    @ApiOperation(value = "批量保存流程配置", tags = {"流程配置" },  notes = "批量保存流程配置")
	@RequestMapping(method = RequestMethod.POST, value = "/pimworkflows/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimWorkflowDTO> pimworkflowdtos) {
        pimworkflowService.saveBatch(pimworkflowMapping.toDomain(pimworkflowdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimWorkflow-Sync-all')")
    @ApiOperation(value = "同步平台流程", tags = {"流程配置" },  notes = "同步平台流程")
	@RequestMapping(method = RequestMethod.POST, value = "/pimworkflows/{pimworkflow_id}/sync")
    @Transactional
    public ResponseEntity<PimWorkflowDTO> sync(@PathVariable("pimworkflow_id") String pimworkflow_id, @RequestBody PimWorkflowDTO pimworkflowdto) {
        PimWorkflow pimworkflow = pimworkflowMapping.toDomain(pimworkflowdto);
        pimworkflow.setPimworkflowid(pimworkflow_id);
        pimworkflow = pimworkflowService.sync(pimworkflow);
        pimworkflowdto = pimworkflowMapping.toDto(pimworkflow);
        return ResponseEntity.status(HttpStatus.OK).body(pimworkflowdto);
    }

    @PostAuthorize("hasPermission(this.pimworkflowMapping.toDomain(returnObject.body),'ehr-PimWorkflow-Get')")
    @ApiOperation(value = "获取流程配置", tags = {"流程配置" },  notes = "获取流程配置")
	@RequestMapping(method = RequestMethod.GET, value = "/pimworkflows/{pimworkflow_id}")
    public ResponseEntity<PimWorkflowDTO> get(@PathVariable("pimworkflow_id") String pimworkflow_id) {
        PimWorkflow domain = pimworkflowService.get(pimworkflow_id);
        PimWorkflowDTO dto = pimworkflowMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimworkflowService.get(#pimworkflow_id),'ehr-PimWorkflow-Update')")
    @ApiOperation(value = "更新流程配置", tags = {"流程配置" },  notes = "更新流程配置")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimworkflows/{pimworkflow_id}")
    @Transactional
    public ResponseEntity<PimWorkflowDTO> update(@PathVariable("pimworkflow_id") String pimworkflow_id, @RequestBody PimWorkflowDTO pimworkflowdto) {
		PimWorkflow domain  = pimworkflowMapping.toDomain(pimworkflowdto);
        domain .setPimworkflowid(pimworkflow_id);
		pimworkflowService.update(domain );
		PimWorkflowDTO dto = pimworkflowMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimworkflowService.getPimworkflowByEntities(this.pimworkflowMapping.toDomain(#pimworkflowdtos)),'ehr-PimWorkflow-Update')")
    @ApiOperation(value = "批量更新流程配置", tags = {"流程配置" },  notes = "批量更新流程配置")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimworkflows/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimWorkflowDTO> pimworkflowdtos) {
        pimworkflowService.updateBatch(pimworkflowMapping.toDomain(pimworkflowdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimworkflowMapping.toDomain(#pimworkflowdto),'ehr-PimWorkflow-Create')")
    @ApiOperation(value = "新建流程配置", tags = {"流程配置" },  notes = "新建流程配置")
	@RequestMapping(method = RequestMethod.POST, value = "/pimworkflows")
    @Transactional
    public ResponseEntity<PimWorkflowDTO> create(@RequestBody PimWorkflowDTO pimworkflowdto) {
        PimWorkflow domain = pimworkflowMapping.toDomain(pimworkflowdto);
		pimworkflowService.create(domain);
        PimWorkflowDTO dto = pimworkflowMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimworkflowMapping.toDomain(#pimworkflowdtos),'ehr-PimWorkflow-Create')")
    @ApiOperation(value = "批量新建流程配置", tags = {"流程配置" },  notes = "批量新建流程配置")
	@RequestMapping(method = RequestMethod.POST, value = "/pimworkflows/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimWorkflowDTO> pimworkflowdtos) {
        pimworkflowService.createBatch(pimworkflowMapping.toDomain(pimworkflowdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimWorkflow-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"流程配置" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimworkflows/fetchdefault")
	public ResponseEntity<List<PimWorkflowDTO>> fetchDefault(PimWorkflowSearchContext context) {
        Page<PimWorkflow> domains = pimworkflowService.searchDefault(context) ;
        List<PimWorkflowDTO> list = pimworkflowMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimWorkflow-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"流程配置" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimworkflows/searchdefault")
	public ResponseEntity<Page<PimWorkflowDTO>> searchDefault(@RequestBody PimWorkflowSearchContext context) {
        Page<PimWorkflow> domains = pimworkflowService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimworkflowMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

