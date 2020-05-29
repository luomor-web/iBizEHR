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
import cn.ibizlab.ehr.core.sal.domain.SalPlan;
import cn.ibizlab.ehr.core.sal.service.ISalPlanService;
import cn.ibizlab.ehr.core.sal.filter.SalPlanSearchContext;

@Slf4j
@Api(tags = {"薪酬计算计划" })
@RestController("WebApi-salplan")
@RequestMapping("")
public class SalPlanResource {

    @Autowired
    public ISalPlanService salplanService;

    @Autowired
    @Lazy
    public SalPlanMapping salplanMapping;

    @PreAuthorize("hasPermission(this.salplanMapping.toDomain(#salplandto),'ehr-SalPlan-Create')")
    @ApiOperation(value = "新建薪酬计算计划", tags = {"薪酬计算计划" },  notes = "新建薪酬计算计划")
	@RequestMapping(method = RequestMethod.POST, value = "/salplans")
    @Transactional
    public ResponseEntity<SalPlanDTO> create(@RequestBody SalPlanDTO salplandto) {
        SalPlan domain = salplanMapping.toDomain(salplandto);
		salplanService.create(domain);
        SalPlanDTO dto = salplanMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salplanMapping.toDomain(#salplandtos),'ehr-SalPlan-Create')")
    @ApiOperation(value = "批量新建薪酬计算计划", tags = {"薪酬计算计划" },  notes = "批量新建薪酬计算计划")
	@RequestMapping(method = RequestMethod.POST, value = "/salplans/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SalPlanDTO> salplandtos) {
        salplanService.createBatch(salplanMapping.toDomain(salplandtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salplanService.get(#salplan_id),'ehr-SalPlan-Remove')")
    @ApiOperation(value = "删除薪酬计算计划", tags = {"薪酬计算计划" },  notes = "删除薪酬计算计划")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salplans/{salplan_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salplan_id") String salplan_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salplanService.remove(salplan_id));
    }

    @PreAuthorize("hasPermission(this.salplanService.getSalplanByIds(#ids),'ehr-SalPlan-Remove')")
    @ApiOperation(value = "批量删除薪酬计算计划", tags = {"薪酬计算计划" },  notes = "批量删除薪酬计算计划")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salplans/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salplanService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查薪酬计算计划", tags = {"薪酬计算计划" },  notes = "检查薪酬计算计划")
	@RequestMapping(method = RequestMethod.POST, value = "/salplans/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SalPlanDTO salplandto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salplanService.checkKey(salplanMapping.toDomain(salplandto)));
    }

    @PreAuthorize("hasPermission(this.salplanMapping.toDomain(#salplandto),'ehr-SalPlan-Save')")
    @ApiOperation(value = "保存薪酬计算计划", tags = {"薪酬计算计划" },  notes = "保存薪酬计算计划")
	@RequestMapping(method = RequestMethod.POST, value = "/salplans/save")
    public ResponseEntity<Boolean> save(@RequestBody SalPlanDTO salplandto) {
        return ResponseEntity.status(HttpStatus.OK).body(salplanService.save(salplanMapping.toDomain(salplandto)));
    }

    @PreAuthorize("hasPermission(this.salplanMapping.toDomain(#salplandtos),'ehr-SalPlan-Save')")
    @ApiOperation(value = "批量保存薪酬计算计划", tags = {"薪酬计算计划" },  notes = "批量保存薪酬计算计划")
	@RequestMapping(method = RequestMethod.POST, value = "/salplans/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SalPlanDTO> salplandtos) {
        salplanService.saveBatch(salplanMapping.toDomain(salplandtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取薪酬计算计划草稿", tags = {"薪酬计算计划" },  notes = "获取薪酬计算计划草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/salplans/getdraft")
    public ResponseEntity<SalPlanDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salplanMapping.toDto(salplanService.getDraft(new SalPlan())));
    }

    @PreAuthorize("hasPermission(this.salplanService.get(#salplan_id),'ehr-SalPlan-Update')")
    @ApiOperation(value = "更新薪酬计算计划", tags = {"薪酬计算计划" },  notes = "更新薪酬计算计划")
	@RequestMapping(method = RequestMethod.PUT, value = "/salplans/{salplan_id}")
    @Transactional
    public ResponseEntity<SalPlanDTO> update(@PathVariable("salplan_id") String salplan_id, @RequestBody SalPlanDTO salplandto) {
		SalPlan domain  = salplanMapping.toDomain(salplandto);
        domain .setSalplanid(salplan_id);
		salplanService.update(domain );
		SalPlanDTO dto = salplanMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salplanService.getSalplanByEntities(this.salplanMapping.toDomain(#salplandtos)),'ehr-SalPlan-Update')")
    @ApiOperation(value = "批量更新薪酬计算计划", tags = {"薪酬计算计划" },  notes = "批量更新薪酬计算计划")
	@RequestMapping(method = RequestMethod.PUT, value = "/salplans/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SalPlanDTO> salplandtos) {
        salplanService.updateBatch(salplanMapping.toDomain(salplandtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.salplanMapping.toDomain(returnObject.body),'ehr-SalPlan-Get')")
    @ApiOperation(value = "获取薪酬计算计划", tags = {"薪酬计算计划" },  notes = "获取薪酬计算计划")
	@RequestMapping(method = RequestMethod.GET, value = "/salplans/{salplan_id}")
    public ResponseEntity<SalPlanDTO> get(@PathVariable("salplan_id") String salplan_id) {
        SalPlan domain = salplanService.get(salplan_id);
        SalPlanDTO dto = salplanMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalPlan-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"薪酬计算计划" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salplans/fetchdefault")
	public ResponseEntity<List<SalPlanDTO>> fetchDefault(SalPlanSearchContext context) {
        Page<SalPlan> domains = salplanService.searchDefault(context) ;
        List<SalPlanDTO> list = salplanMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalPlan-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"薪酬计算计划" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salplans/searchdefault")
	public ResponseEntity<Page<SalPlanDTO>> searchDefault(@RequestBody SalPlanSearchContext context) {
        Page<SalPlan> domains = salplanService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salplanMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

