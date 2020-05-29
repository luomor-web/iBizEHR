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
import cn.ibizlab.ehr.core.pim.domain.PimExaminationResults;
import cn.ibizlab.ehr.core.pim.service.IPimExaminationResultsService;
import cn.ibizlab.ehr.core.pim.filter.PimExaminationResultsSearchContext;

@Slf4j
@Api(tags = {"B/Y员工转正考核结果记录" })
@RestController("WebApi-pimexaminationresults")
@RequestMapping("")
public class PimExaminationResultsResource {

    @Autowired
    public IPimExaminationResultsService pimexaminationresultsService;

    @Autowired
    @Lazy
    public PimExaminationResultsMapping pimexaminationresultsMapping;

    @PreAuthorize("hasPermission(this.pimexaminationresultsService.get(#pimexaminationresults_id),'ehr-PimExaminationResults-Update')")
    @ApiOperation(value = "更新B/Y员工转正考核结果记录", tags = {"B/Y员工转正考核结果记录" },  notes = "更新B/Y员工转正考核结果记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimexaminationresults/{pimexaminationresults_id}")
    @Transactional
    public ResponseEntity<PimExaminationResultsDTO> update(@PathVariable("pimexaminationresults_id") String pimexaminationresults_id, @RequestBody PimExaminationResultsDTO pimexaminationresultsdto) {
		PimExaminationResults domain  = pimexaminationresultsMapping.toDomain(pimexaminationresultsdto);
        domain .setPimexaminationresultsid(pimexaminationresults_id);
		pimexaminationresultsService.update(domain );
		PimExaminationResultsDTO dto = pimexaminationresultsMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimexaminationresultsService.getPimexaminationresultsByEntities(this.pimexaminationresultsMapping.toDomain(#pimexaminationresultsdtos)),'ehr-PimExaminationResults-Update')")
    @ApiOperation(value = "批量更新B/Y员工转正考核结果记录", tags = {"B/Y员工转正考核结果记录" },  notes = "批量更新B/Y员工转正考核结果记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimexaminationresults/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimExaminationResultsDTO> pimexaminationresultsdtos) {
        pimexaminationresultsService.updateBatch(pimexaminationresultsMapping.toDomain(pimexaminationresultsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimexaminationresultsMapping.toDomain(#pimexaminationresultsdto),'ehr-PimExaminationResults-Save')")
    @ApiOperation(value = "保存B/Y员工转正考核结果记录", tags = {"B/Y员工转正考核结果记录" },  notes = "保存B/Y员工转正考核结果记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexaminationresults/save")
    public ResponseEntity<Boolean> save(@RequestBody PimExaminationResultsDTO pimexaminationresultsdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimexaminationresultsService.save(pimexaminationresultsMapping.toDomain(pimexaminationresultsdto)));
    }

    @PreAuthorize("hasPermission(this.pimexaminationresultsMapping.toDomain(#pimexaminationresultsdtos),'ehr-PimExaminationResults-Save')")
    @ApiOperation(value = "批量保存B/Y员工转正考核结果记录", tags = {"B/Y员工转正考核结果记录" },  notes = "批量保存B/Y员工转正考核结果记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexaminationresults/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimExaminationResultsDTO> pimexaminationresultsdtos) {
        pimexaminationresultsService.saveBatch(pimexaminationresultsMapping.toDomain(pimexaminationresultsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查B/Y员工转正考核结果记录", tags = {"B/Y员工转正考核结果记录" },  notes = "检查B/Y员工转正考核结果记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexaminationresults/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimExaminationResultsDTO pimexaminationresultsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimexaminationresultsService.checkKey(pimexaminationresultsMapping.toDomain(pimexaminationresultsdto)));
    }

    @PreAuthorize("hasPermission(this.pimexaminationresultsMapping.toDomain(#pimexaminationresultsdto),'ehr-PimExaminationResults-Create')")
    @ApiOperation(value = "新建B/Y员工转正考核结果记录", tags = {"B/Y员工转正考核结果记录" },  notes = "新建B/Y员工转正考核结果记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexaminationresults")
    @Transactional
    public ResponseEntity<PimExaminationResultsDTO> create(@RequestBody PimExaminationResultsDTO pimexaminationresultsdto) {
        PimExaminationResults domain = pimexaminationresultsMapping.toDomain(pimexaminationresultsdto);
		pimexaminationresultsService.create(domain);
        PimExaminationResultsDTO dto = pimexaminationresultsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimexaminationresultsMapping.toDomain(#pimexaminationresultsdtos),'ehr-PimExaminationResults-Create')")
    @ApiOperation(value = "批量新建B/Y员工转正考核结果记录", tags = {"B/Y员工转正考核结果记录" },  notes = "批量新建B/Y员工转正考核结果记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexaminationresults/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimExaminationResultsDTO> pimexaminationresultsdtos) {
        pimexaminationresultsService.createBatch(pimexaminationresultsMapping.toDomain(pimexaminationresultsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimexaminationresultsService.get(#pimexaminationresults_id),'ehr-PimExaminationResults-Remove')")
    @ApiOperation(value = "删除B/Y员工转正考核结果记录", tags = {"B/Y员工转正考核结果记录" },  notes = "删除B/Y员工转正考核结果记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimexaminationresults/{pimexaminationresults_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimexaminationresults_id") String pimexaminationresults_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimexaminationresultsService.remove(pimexaminationresults_id));
    }

    @PreAuthorize("hasPermission(this.pimexaminationresultsService.getPimexaminationresultsByIds(#ids),'ehr-PimExaminationResults-Remove')")
    @ApiOperation(value = "批量删除B/Y员工转正考核结果记录", tags = {"B/Y员工转正考核结果记录" },  notes = "批量删除B/Y员工转正考核结果记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimexaminationresults/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimexaminationresultsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取B/Y员工转正考核结果记录草稿", tags = {"B/Y员工转正考核结果记录" },  notes = "获取B/Y员工转正考核结果记录草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimexaminationresults/getdraft")
    public ResponseEntity<PimExaminationResultsDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimexaminationresultsMapping.toDto(pimexaminationresultsService.getDraft(new PimExaminationResults())));
    }

    @PostAuthorize("hasPermission(this.pimexaminationresultsMapping.toDomain(returnObject.body),'ehr-PimExaminationResults-Get')")
    @ApiOperation(value = "获取B/Y员工转正考核结果记录", tags = {"B/Y员工转正考核结果记录" },  notes = "获取B/Y员工转正考核结果记录")
	@RequestMapping(method = RequestMethod.GET, value = "/pimexaminationresults/{pimexaminationresults_id}")
    public ResponseEntity<PimExaminationResultsDTO> get(@PathVariable("pimexaminationresults_id") String pimexaminationresults_id) {
        PimExaminationResults domain = pimexaminationresultsService.get(pimexaminationresults_id);
        PimExaminationResultsDTO dto = pimexaminationresultsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExaminationResults-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"B/Y员工转正考核结果记录" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimexaminationresults/fetchdefault")
	public ResponseEntity<List<PimExaminationResultsDTO>> fetchDefault(PimExaminationResultsSearchContext context) {
        Page<PimExaminationResults> domains = pimexaminationresultsService.searchDefault(context) ;
        List<PimExaminationResultsDTO> list = pimexaminationresultsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExaminationResults-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"B/Y员工转正考核结果记录" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimexaminationresults/searchdefault")
	public ResponseEntity<Page<PimExaminationResultsDTO>> searchDefault(@RequestBody PimExaminationResultsSearchContext context) {
        Page<PimExaminationResults> domains = pimexaminationresultsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimexaminationresultsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

