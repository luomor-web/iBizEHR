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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainPlan;
import cn.ibizlab.ehr.core.trm.service.ITrmTrainPlanService;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainPlanSearchContext;

@Slf4j
@Api(tags = {"培训计划" })
@RestController("WebApi-trmtrainplan")
@RequestMapping("")
public class TrmTrainPlanResource {

    @Autowired
    public ITrmTrainPlanService trmtrainplanService;

    @Autowired
    @Lazy
    public TrmTrainPlanMapping trmtrainplanMapping;

    @PreAuthorize("hasPermission(this.trmtrainplanService.get(#trmtrainplan_id),'ehr-TrmTrainPlan-Remove')")
    @ApiOperation(value = "删除培训计划", tags = {"培训计划" },  notes = "删除培训计划")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainplans/{trmtrainplan_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtrainplan_id") String trmtrainplan_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtrainplanService.remove(trmtrainplan_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainplanService.getTrmtrainplanByIds(#ids),'ehr-TrmTrainPlan-Remove')")
    @ApiOperation(value = "批量删除培训计划", tags = {"培训计划" },  notes = "批量删除培训计划")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainplans/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtrainplanService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainplanMapping.toDomain(#trmtrainplandto),'ehr-TrmTrainPlan-Save')")
    @ApiOperation(value = "保存培训计划", tags = {"培训计划" },  notes = "保存培训计划")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplans/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmTrainPlanDTO trmtrainplandto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplanService.save(trmtrainplanMapping.toDomain(trmtrainplandto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainplanMapping.toDomain(#trmtrainplandtos),'ehr-TrmTrainPlan-Save')")
    @ApiOperation(value = "批量保存培训计划", tags = {"培训计划" },  notes = "批量保存培训计划")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplans/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmTrainPlanDTO> trmtrainplandtos) {
        trmtrainplanService.saveBatch(trmtrainplanMapping.toDomain(trmtrainplandtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取培训计划草稿", tags = {"培训计划" },  notes = "获取培训计划草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainplans/getdraft")
    public ResponseEntity<TrmTrainPlanDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplanMapping.toDto(trmtrainplanService.getDraft(new TrmTrainPlan())));
    }

    @ApiOperation(value = "检查培训计划", tags = {"培训计划" },  notes = "检查培训计划")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplans/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmTrainPlanDTO trmtrainplandto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainplanService.checkKey(trmtrainplanMapping.toDomain(trmtrainplandto)));
    }

    @PostAuthorize("hasPermission(this.trmtrainplanMapping.toDomain(returnObject.body),'ehr-TrmTrainPlan-Get')")
    @ApiOperation(value = "获取培训计划", tags = {"培训计划" },  notes = "获取培训计划")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainplans/{trmtrainplan_id}")
    public ResponseEntity<TrmTrainPlanDTO> get(@PathVariable("trmtrainplan_id") String trmtrainplan_id) {
        TrmTrainPlan domain = trmtrainplanService.get(trmtrainplan_id);
        TrmTrainPlanDTO dto = trmtrainplanMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainplanMapping.toDomain(#trmtrainplandto),'ehr-TrmTrainPlan-Create')")
    @ApiOperation(value = "新建培训计划", tags = {"培训计划" },  notes = "新建培训计划")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplans")
    @Transactional
    public ResponseEntity<TrmTrainPlanDTO> create(@RequestBody TrmTrainPlanDTO trmtrainplandto) {
        TrmTrainPlan domain = trmtrainplanMapping.toDomain(trmtrainplandto);
		trmtrainplanService.create(domain);
        TrmTrainPlanDTO dto = trmtrainplanMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainplanMapping.toDomain(#trmtrainplandtos),'ehr-TrmTrainPlan-Create')")
    @ApiOperation(value = "批量新建培训计划", tags = {"培训计划" },  notes = "批量新建培训计划")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplans/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmTrainPlanDTO> trmtrainplandtos) {
        trmtrainplanService.createBatch(trmtrainplanMapping.toDomain(trmtrainplandtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainplanService.get(#trmtrainplan_id),'ehr-TrmTrainPlan-Update')")
    @ApiOperation(value = "更新培训计划", tags = {"培训计划" },  notes = "更新培训计划")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainplans/{trmtrainplan_id}")
    @Transactional
    public ResponseEntity<TrmTrainPlanDTO> update(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @RequestBody TrmTrainPlanDTO trmtrainplandto) {
		TrmTrainPlan domain  = trmtrainplanMapping.toDomain(trmtrainplandto);
        domain .setTrmtrainplanid(trmtrainplan_id);
		trmtrainplanService.update(domain );
		TrmTrainPlanDTO dto = trmtrainplanMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainplanService.getTrmtrainplanByEntities(this.trmtrainplanMapping.toDomain(#trmtrainplandtos)),'ehr-TrmTrainPlan-Update')")
    @ApiOperation(value = "批量更新培训计划", tags = {"培训计划" },  notes = "批量更新培训计划")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainplans/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmTrainPlanDTO> trmtrainplandtos) {
        trmtrainplanService.updateBatch(trmtrainplanMapping.toDomain(trmtrainplandtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPlan-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"培训计划" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainplans/fetchdefault")
	public ResponseEntity<List<TrmTrainPlanDTO>> fetchDefault(TrmTrainPlanSearchContext context) {
        Page<TrmTrainPlan> domains = trmtrainplanService.searchDefault(context) ;
        List<TrmTrainPlanDTO> list = trmtrainplanMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPlan-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"培训计划" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainplans/searchdefault")
	public ResponseEntity<Page<TrmTrainPlanDTO>> searchDefault(@RequestBody TrmTrainPlanSearchContext context) {
        Page<TrmTrainPlan> domains = trmtrainplanService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainplanMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

