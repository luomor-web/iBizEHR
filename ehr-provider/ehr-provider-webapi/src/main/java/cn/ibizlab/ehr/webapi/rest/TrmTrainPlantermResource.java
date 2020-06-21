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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainPlanterm;
import cn.ibizlab.ehr.core.trm.service.ITrmTrainPlantermService;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainPlantermSearchContext;

@Slf4j
@Api(tags = {"培训立项" })
@RestController("WebApi-trmtrainplanterm")
@RequestMapping("")
public class TrmTrainPlantermResource {

    @Autowired
    public ITrmTrainPlantermService trmtrainplantermService;

    @Autowired
    @Lazy
    public TrmTrainPlantermMapping trmtrainplantermMapping;

    @PostAuthorize("hasPermission(this.trmtrainplantermMapping.toDomain(returnObject.body),'ehr-TrmTrainPlanterm-Get')")
    @ApiOperation(value = "获取培训立项", tags = {"培训立项" },  notes = "获取培训立项")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainplanterms/{trmtrainplanterm_id}")
    public ResponseEntity<TrmTrainPlantermDTO> get(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id) {
        TrmTrainPlanterm domain = trmtrainplantermService.get(trmtrainplanterm_id);
        TrmTrainPlantermDTO dto = trmtrainplantermMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermService.get(#trmtrainplanterm_id),'ehr-TrmTrainPlanterm-Remove')")
    @ApiOperation(value = "删除培训立项", tags = {"培训立项" },  notes = "删除培训立项")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainplanterms/{trmtrainplanterm_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermService.remove(trmtrainplanterm_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermService.getTrmtrainplantermByIds(#ids),'ehr-TrmTrainPlanterm-Remove')")
    @ApiOperation(value = "批量删除培训立项", tags = {"培训立项" },  notes = "批量删除培训立项")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainplanterms/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtrainplantermService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查培训立项", tags = {"培训立项" },  notes = "检查培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplanterms/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermService.checkKey(trmtrainplantermMapping.toDomain(trmtrainplantermdto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermService.get(#trmtrainplanterm_id),'ehr-TrmTrainPlanterm-Update')")
    @ApiOperation(value = "更新培训立项", tags = {"培训立项" },  notes = "更新培训立项")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainplanterms/{trmtrainplanterm_id}")
    @Transactional
    public ResponseEntity<TrmTrainPlantermDTO> update(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
		TrmTrainPlanterm domain  = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
        domain .setTrmtrainplantermid(trmtrainplanterm_id);
		trmtrainplantermService.update(domain );
		TrmTrainPlantermDTO dto = trmtrainplantermMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermService.getTrmtrainplantermByEntities(this.trmtrainplantermMapping.toDomain(#trmtrainplantermdtos)),'ehr-TrmTrainPlanterm-Update')")
    @ApiOperation(value = "批量更新培训立项", tags = {"培训立项" },  notes = "批量更新培训立项")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainplanterms/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmTrainPlantermDTO> trmtrainplantermdtos) {
        trmtrainplantermService.updateBatch(trmtrainplantermMapping.toDomain(trmtrainplantermdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermMapping.toDomain(#trmtrainplantermdto),'ehr-TrmTrainPlanterm-Save')")
    @ApiOperation(value = "保存培训立项", tags = {"培训立项" },  notes = "保存培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplanterms/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermService.save(trmtrainplantermMapping.toDomain(trmtrainplantermdto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermMapping.toDomain(#trmtrainplantermdtos),'ehr-TrmTrainPlanterm-Save')")
    @ApiOperation(value = "批量保存培训立项", tags = {"培训立项" },  notes = "批量保存培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplanterms/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmTrainPlantermDTO> trmtrainplantermdtos) {
        trmtrainplantermService.saveBatch(trmtrainplantermMapping.toDomain(trmtrainplantermdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取培训立项草稿", tags = {"培训立项" },  notes = "获取培训立项草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainplanterms/getdraft")
    public ResponseEntity<TrmTrainPlantermDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermMapping.toDto(trmtrainplantermService.getDraft(new TrmTrainPlanterm())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPlanterm-KB-all')")
    @ApiOperation(value = "开班", tags = {"培训立项" },  notes = "开班")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplanterms/{trmtrainplanterm_id}/kb")
    @Transactional
    public ResponseEntity<TrmTrainPlantermDTO> kB(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        TrmTrainPlanterm trmtrainplanterm = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
        trmtrainplanterm.setTrmtrainplantermid(trmtrainplanterm_id);
        trmtrainplanterm = trmtrainplantermService.kB(trmtrainplanterm);
        trmtrainplantermdto = trmtrainplantermMapping.toDto(trmtrainplanterm);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermdto);
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermMapping.toDomain(#trmtrainplantermdto),'ehr-TrmTrainPlanterm-Create')")
    @ApiOperation(value = "新建培训立项", tags = {"培训立项" },  notes = "新建培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplanterms")
    @Transactional
    public ResponseEntity<TrmTrainPlantermDTO> create(@RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        TrmTrainPlanterm domain = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
		trmtrainplantermService.create(domain);
        TrmTrainPlantermDTO dto = trmtrainplantermMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermMapping.toDomain(#trmtrainplantermdtos),'ehr-TrmTrainPlanterm-Create')")
    @ApiOperation(value = "批量新建培训立项", tags = {"培训立项" },  notes = "批量新建培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplanterms/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmTrainPlantermDTO> trmtrainplantermdtos) {
        trmtrainplantermService.createBatch(trmtrainplantermMapping.toDomain(trmtrainplantermdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPlanterm-QX-all')")
    @ApiOperation(value = "取消", tags = {"培训立项" },  notes = "取消")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplanterms/{trmtrainplanterm_id}/qx")
    @Transactional
    public ResponseEntity<TrmTrainPlantermDTO> qX(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        TrmTrainPlanterm trmtrainplanterm = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
        trmtrainplanterm.setTrmtrainplantermid(trmtrainplanterm_id);
        trmtrainplanterm = trmtrainplantermService.qX(trmtrainplanterm);
        trmtrainplantermdto = trmtrainplantermMapping.toDto(trmtrainplanterm);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPlanterm-LX-all')")
    @ApiOperation(value = "立项", tags = {"培训立项" },  notes = "立项")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplanterms/{trmtrainplanterm_id}/lx")
    @Transactional
    public ResponseEntity<TrmTrainPlantermDTO> lX(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        TrmTrainPlanterm trmtrainplanterm = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
        trmtrainplanterm.setTrmtrainplantermid(trmtrainplanterm_id);
        trmtrainplanterm = trmtrainplantermService.lX(trmtrainplanterm);
        trmtrainplantermdto = trmtrainplantermMapping.toDto(trmtrainplanterm);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPlanterm-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"培训立项" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainplanterms/fetchdefault")
	public ResponseEntity<List<TrmTrainPlantermDTO>> fetchDefault(TrmTrainPlantermSearchContext context) {
        Page<TrmTrainPlanterm> domains = trmtrainplantermService.searchDefault(context) ;
        List<TrmTrainPlantermDTO> list = trmtrainplantermMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPlanterm-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"培训立项" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainplanterms/searchdefault")
	public ResponseEntity<Page<TrmTrainPlantermDTO>> searchDefault(@RequestBody TrmTrainPlantermSearchContext context) {
        Page<TrmTrainPlanterm> domains = trmtrainplantermService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainplantermMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.trmtrainplantermMapping.toDomain(returnObject.body),'ehr-TrmTrainPlanterm-Get')")
    @ApiOperation(value = "根据培训计划获取培训立项", tags = {"培训立项" },  notes = "根据培训计划获取培训立项")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}")
    public ResponseEntity<TrmTrainPlantermDTO> getByTrmTrainPlan(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id) {
        TrmTrainPlanterm domain = trmtrainplantermService.get(trmtrainplanterm_id);
        TrmTrainPlantermDTO dto = trmtrainplantermMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermService.get(#trmtrainplanterm_id),'ehr-TrmTrainPlanterm-Remove')")
    @ApiOperation(value = "根据培训计划删除培训立项", tags = {"培训立项" },  notes = "根据培训计划删除培训立项")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByTrmTrainPlan(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermService.remove(trmtrainplanterm_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermService.getTrmtrainplantermByIds(#ids),'ehr-TrmTrainPlanterm-Remove')")
    @ApiOperation(value = "根据培训计划批量删除培训立项", tags = {"培训立项" },  notes = "根据培训计划批量删除培训立项")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/batch")
    public ResponseEntity<Boolean> removeBatchByTrmTrainPlan(@RequestBody List<String> ids) {
        trmtrainplantermService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据培训计划检查培训立项", tags = {"培训立项" },  notes = "根据培训计划检查培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/checkkey")
    public ResponseEntity<Boolean> checkKeyByTrmTrainPlan(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermService.checkKey(trmtrainplantermMapping.toDomain(trmtrainplantermdto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermService.get(#trmtrainplanterm_id),'ehr-TrmTrainPlanterm-Update')")
    @ApiOperation(value = "根据培训计划更新培训立项", tags = {"培训立项" },  notes = "根据培训计划更新培训立项")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}")
    @Transactional
    public ResponseEntity<TrmTrainPlantermDTO> updateByTrmTrainPlan(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        TrmTrainPlanterm domain = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
        domain.setTrmtrainplanid(trmtrainplan_id);
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
		trmtrainplantermService.update(domain);
        TrmTrainPlantermDTO dto = trmtrainplantermMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermService.getTrmtrainplantermByEntities(this.trmtrainplantermMapping.toDomain(#trmtrainplantermdtos)),'ehr-TrmTrainPlanterm-Update')")
    @ApiOperation(value = "根据培训计划批量更新培训立项", tags = {"培训立项" },  notes = "根据培训计划批量更新培训立项")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/batch")
    public ResponseEntity<Boolean> updateBatchByTrmTrainPlan(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @RequestBody List<TrmTrainPlantermDTO> trmtrainplantermdtos) {
        List<TrmTrainPlanterm> domainlist=trmtrainplantermMapping.toDomain(trmtrainplantermdtos);
        for(TrmTrainPlanterm domain:domainlist){
            domain.setTrmtrainplanid(trmtrainplan_id);
        }
        trmtrainplantermService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermMapping.toDomain(#trmtrainplantermdto),'ehr-TrmTrainPlanterm-Save')")
    @ApiOperation(value = "根据培训计划保存培训立项", tags = {"培训立项" },  notes = "根据培训计划保存培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/save")
    public ResponseEntity<Boolean> saveByTrmTrainPlan(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        TrmTrainPlanterm domain = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
        domain.setTrmtrainplanid(trmtrainplan_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermMapping.toDomain(#trmtrainplantermdtos),'ehr-TrmTrainPlanterm-Save')")
    @ApiOperation(value = "根据培训计划批量保存培训立项", tags = {"培训立项" },  notes = "根据培训计划批量保存培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/savebatch")
    public ResponseEntity<Boolean> saveBatchByTrmTrainPlan(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @RequestBody List<TrmTrainPlantermDTO> trmtrainplantermdtos) {
        List<TrmTrainPlanterm> domainlist=trmtrainplantermMapping.toDomain(trmtrainplantermdtos);
        for(TrmTrainPlanterm domain:domainlist){
             domain.setTrmtrainplanid(trmtrainplan_id);
        }
        trmtrainplantermService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据培训计划获取培训立项草稿", tags = {"培训立项" },  notes = "根据培训计划获取培训立项草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/getdraft")
    public ResponseEntity<TrmTrainPlantermDTO> getDraftByTrmTrainPlan(@PathVariable("trmtrainplan_id") String trmtrainplan_id) {
        TrmTrainPlanterm domain = new TrmTrainPlanterm();
        domain.setTrmtrainplanid(trmtrainplan_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermMapping.toDto(trmtrainplantermService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPlanterm-KB-all')")
    @ApiOperation(value = "根据培训计划培训立项", tags = {"培训立项" },  notes = "根据培训计划培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/kb")
    @Transactional
    public ResponseEntity<TrmTrainPlantermDTO> kBByTrmTrainPlan(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        TrmTrainPlanterm domain = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
        domain.setTrmtrainplanid(trmtrainplan_id);
        domain = trmtrainplantermService.kB(domain) ;
        trmtrainplantermdto = trmtrainplantermMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermdto);
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermMapping.toDomain(#trmtrainplantermdto),'ehr-TrmTrainPlanterm-Create')")
    @ApiOperation(value = "根据培训计划建立培训立项", tags = {"培训立项" },  notes = "根据培训计划建立培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms")
    @Transactional
    public ResponseEntity<TrmTrainPlantermDTO> createByTrmTrainPlan(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        TrmTrainPlanterm domain = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
        domain.setTrmtrainplanid(trmtrainplan_id);
		trmtrainplantermService.create(domain);
        TrmTrainPlantermDTO dto = trmtrainplantermMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermMapping.toDomain(#trmtrainplantermdtos),'ehr-TrmTrainPlanterm-Create')")
    @ApiOperation(value = "根据培训计划批量建立培训立项", tags = {"培训立项" },  notes = "根据培训计划批量建立培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/batch")
    public ResponseEntity<Boolean> createBatchByTrmTrainPlan(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @RequestBody List<TrmTrainPlantermDTO> trmtrainplantermdtos) {
        List<TrmTrainPlanterm> domainlist=trmtrainplantermMapping.toDomain(trmtrainplantermdtos);
        for(TrmTrainPlanterm domain:domainlist){
            domain.setTrmtrainplanid(trmtrainplan_id);
        }
        trmtrainplantermService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPlanterm-QX-all')")
    @ApiOperation(value = "根据培训计划培训立项", tags = {"培训立项" },  notes = "根据培训计划培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/qx")
    @Transactional
    public ResponseEntity<TrmTrainPlantermDTO> qXByTrmTrainPlan(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        TrmTrainPlanterm domain = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
        domain.setTrmtrainplanid(trmtrainplan_id);
        domain = trmtrainplantermService.qX(domain) ;
        trmtrainplantermdto = trmtrainplantermMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPlanterm-LX-all')")
    @ApiOperation(value = "根据培训计划培训立项", tags = {"培训立项" },  notes = "根据培训计划培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/lx")
    @Transactional
    public ResponseEntity<TrmTrainPlantermDTO> lXByTrmTrainPlan(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        TrmTrainPlanterm domain = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
        domain.setTrmtrainplanid(trmtrainplan_id);
        domain = trmtrainplantermService.lX(domain) ;
        trmtrainplantermdto = trmtrainplantermMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPlanterm-Default-all')")
	@ApiOperation(value = "根据培训计划获取DEFAULT", tags = {"培训立项" } ,notes = "根据培训计划获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/fetchdefault")
	public ResponseEntity<List<TrmTrainPlantermDTO>> fetchTrmTrainPlantermDefaultByTrmTrainPlan(@PathVariable("trmtrainplan_id") String trmtrainplan_id,TrmTrainPlantermSearchContext context) {
        context.setN_trmtrainplanid_eq(trmtrainplan_id);
        Page<TrmTrainPlanterm> domains = trmtrainplantermService.searchDefault(context) ;
        List<TrmTrainPlantermDTO> list = trmtrainplantermMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPlanterm-Default-all')")
	@ApiOperation(value = "根据培训计划查询DEFAULT", tags = {"培训立项" } ,notes = "根据培训计划查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/searchdefault")
	public ResponseEntity<Page<TrmTrainPlantermDTO>> searchTrmTrainPlantermDefaultByTrmTrainPlan(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @RequestBody TrmTrainPlantermSearchContext context) {
        context.setN_trmtrainplanid_eq(trmtrainplan_id);
        Page<TrmTrainPlanterm> domains = trmtrainplantermService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainplantermMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.trmtrainplantermMapping.toDomain(returnObject.body),'ehr-TrmTrainPlanterm-Get')")
    @ApiOperation(value = "根据培训讲师获取培训立项", tags = {"培训立项" },  notes = "根据培训讲师获取培训立项")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}")
    public ResponseEntity<TrmTrainPlantermDTO> getByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id) {
        TrmTrainPlanterm domain = trmtrainplantermService.get(trmtrainplanterm_id);
        TrmTrainPlantermDTO dto = trmtrainplantermMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermService.get(#trmtrainplanterm_id),'ehr-TrmTrainPlanterm-Remove')")
    @ApiOperation(value = "根据培训讲师删除培训立项", tags = {"培训立项" },  notes = "根据培训讲师删除培训立项")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermService.remove(trmtrainplanterm_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermService.getTrmtrainplantermByIds(#ids),'ehr-TrmTrainPlanterm-Remove')")
    @ApiOperation(value = "根据培训讲师批量删除培训立项", tags = {"培训立项" },  notes = "根据培训讲师批量删除培训立项")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/batch")
    public ResponseEntity<Boolean> removeBatchByTrmTrainTeacher(@RequestBody List<String> ids) {
        trmtrainplantermService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据培训讲师检查培训立项", tags = {"培训立项" },  notes = "根据培训讲师检查培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/checkkey")
    public ResponseEntity<Boolean> checkKeyByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermService.checkKey(trmtrainplantermMapping.toDomain(trmtrainplantermdto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermService.get(#trmtrainplanterm_id),'ehr-TrmTrainPlanterm-Update')")
    @ApiOperation(value = "根据培训讲师更新培训立项", tags = {"培训立项" },  notes = "根据培训讲师更新培训立项")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}")
    @Transactional
    public ResponseEntity<TrmTrainPlantermDTO> updateByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        TrmTrainPlanterm domain = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
        domain.setTrmtrainteacherid(trmtrainteacher_id);
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
		trmtrainplantermService.update(domain);
        TrmTrainPlantermDTO dto = trmtrainplantermMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermService.getTrmtrainplantermByEntities(this.trmtrainplantermMapping.toDomain(#trmtrainplantermdtos)),'ehr-TrmTrainPlanterm-Update')")
    @ApiOperation(value = "根据培训讲师批量更新培训立项", tags = {"培训立项" },  notes = "根据培训讲师批量更新培训立项")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/batch")
    public ResponseEntity<Boolean> updateBatchByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody List<TrmTrainPlantermDTO> trmtrainplantermdtos) {
        List<TrmTrainPlanterm> domainlist=trmtrainplantermMapping.toDomain(trmtrainplantermdtos);
        for(TrmTrainPlanterm domain:domainlist){
            domain.setTrmtrainteacherid(trmtrainteacher_id);
        }
        trmtrainplantermService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermMapping.toDomain(#trmtrainplantermdto),'ehr-TrmTrainPlanterm-Save')")
    @ApiOperation(value = "根据培训讲师保存培训立项", tags = {"培训立项" },  notes = "根据培训讲师保存培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/save")
    public ResponseEntity<Boolean> saveByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        TrmTrainPlanterm domain = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
        domain.setTrmtrainteacherid(trmtrainteacher_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermMapping.toDomain(#trmtrainplantermdtos),'ehr-TrmTrainPlanterm-Save')")
    @ApiOperation(value = "根据培训讲师批量保存培训立项", tags = {"培训立项" },  notes = "根据培训讲师批量保存培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/savebatch")
    public ResponseEntity<Boolean> saveBatchByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody List<TrmTrainPlantermDTO> trmtrainplantermdtos) {
        List<TrmTrainPlanterm> domainlist=trmtrainplantermMapping.toDomain(trmtrainplantermdtos);
        for(TrmTrainPlanterm domain:domainlist){
             domain.setTrmtrainteacherid(trmtrainteacher_id);
        }
        trmtrainplantermService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据培训讲师获取培训立项草稿", tags = {"培训立项" },  notes = "根据培训讲师获取培训立项草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/getdraft")
    public ResponseEntity<TrmTrainPlantermDTO> getDraftByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id) {
        TrmTrainPlanterm domain = new TrmTrainPlanterm();
        domain.setTrmtrainteacherid(trmtrainteacher_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermMapping.toDto(trmtrainplantermService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPlanterm-KB-all')")
    @ApiOperation(value = "根据培训讲师培训立项", tags = {"培训立项" },  notes = "根据培训讲师培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/kb")
    @Transactional
    public ResponseEntity<TrmTrainPlantermDTO> kBByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        TrmTrainPlanterm domain = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
        domain.setTrmtrainteacherid(trmtrainteacher_id);
        domain = trmtrainplantermService.kB(domain) ;
        trmtrainplantermdto = trmtrainplantermMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermdto);
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermMapping.toDomain(#trmtrainplantermdto),'ehr-TrmTrainPlanterm-Create')")
    @ApiOperation(value = "根据培训讲师建立培训立项", tags = {"培训立项" },  notes = "根据培训讲师建立培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms")
    @Transactional
    public ResponseEntity<TrmTrainPlantermDTO> createByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        TrmTrainPlanterm domain = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
        domain.setTrmtrainteacherid(trmtrainteacher_id);
		trmtrainplantermService.create(domain);
        TrmTrainPlantermDTO dto = trmtrainplantermMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermMapping.toDomain(#trmtrainplantermdtos),'ehr-TrmTrainPlanterm-Create')")
    @ApiOperation(value = "根据培训讲师批量建立培训立项", tags = {"培训立项" },  notes = "根据培训讲师批量建立培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/batch")
    public ResponseEntity<Boolean> createBatchByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody List<TrmTrainPlantermDTO> trmtrainplantermdtos) {
        List<TrmTrainPlanterm> domainlist=trmtrainplantermMapping.toDomain(trmtrainplantermdtos);
        for(TrmTrainPlanterm domain:domainlist){
            domain.setTrmtrainteacherid(trmtrainteacher_id);
        }
        trmtrainplantermService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPlanterm-QX-all')")
    @ApiOperation(value = "根据培训讲师培训立项", tags = {"培训立项" },  notes = "根据培训讲师培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/qx")
    @Transactional
    public ResponseEntity<TrmTrainPlantermDTO> qXByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        TrmTrainPlanterm domain = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
        domain.setTrmtrainteacherid(trmtrainteacher_id);
        domain = trmtrainplantermService.qX(domain) ;
        trmtrainplantermdto = trmtrainplantermMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPlanterm-LX-all')")
    @ApiOperation(value = "根据培训讲师培训立项", tags = {"培训立项" },  notes = "根据培训讲师培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/lx")
    @Transactional
    public ResponseEntity<TrmTrainPlantermDTO> lXByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        TrmTrainPlanterm domain = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
        domain.setTrmtrainteacherid(trmtrainteacher_id);
        domain = trmtrainplantermService.lX(domain) ;
        trmtrainplantermdto = trmtrainplantermMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPlanterm-Default-all')")
	@ApiOperation(value = "根据培训讲师获取DEFAULT", tags = {"培训立项" } ,notes = "根据培训讲师获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/fetchdefault")
	public ResponseEntity<List<TrmTrainPlantermDTO>> fetchTrmTrainPlantermDefaultByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id,TrmTrainPlantermSearchContext context) {
        context.setN_trmtrainteacherid_eq(trmtrainteacher_id);
        Page<TrmTrainPlanterm> domains = trmtrainplantermService.searchDefault(context) ;
        List<TrmTrainPlantermDTO> list = trmtrainplantermMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPlanterm-Default-all')")
	@ApiOperation(value = "根据培训讲师查询DEFAULT", tags = {"培训立项" } ,notes = "根据培训讲师查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/searchdefault")
	public ResponseEntity<Page<TrmTrainPlantermDTO>> searchTrmTrainPlantermDefaultByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody TrmTrainPlantermSearchContext context) {
        context.setN_trmtrainteacherid_eq(trmtrainteacher_id);
        Page<TrmTrainPlanterm> domains = trmtrainplantermService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainplantermMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.trmtrainplantermMapping.toDomain(returnObject.body),'ehr-TrmTrainPlanterm-Get')")
    @ApiOperation(value = "根据人员信息培训计划获取培训立项", tags = {"培训立项" },  notes = "根据人员信息培训计划获取培训立项")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}")
    public ResponseEntity<TrmTrainPlantermDTO> getByPimPersonTrmTrainPlan(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id) {
        TrmTrainPlanterm domain = trmtrainplantermService.get(trmtrainplanterm_id);
        TrmTrainPlantermDTO dto = trmtrainplantermMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermService.get(#trmtrainplanterm_id),'ehr-TrmTrainPlanterm-Remove')")
    @ApiOperation(value = "根据人员信息培训计划删除培训立项", tags = {"培训立项" },  notes = "根据人员信息培训计划删除培训立项")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPersonTrmTrainPlan(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermService.remove(trmtrainplanterm_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermService.getTrmtrainplantermByIds(#ids),'ehr-TrmTrainPlanterm-Remove')")
    @ApiOperation(value = "根据人员信息培训计划批量删除培训立项", tags = {"培训立项" },  notes = "根据人员信息培训计划批量删除培训立项")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/batch")
    public ResponseEntity<Boolean> removeBatchByPimPersonTrmTrainPlan(@RequestBody List<String> ids) {
        trmtrainplantermService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息培训计划检查培训立项", tags = {"培训立项" },  notes = "根据人员信息培训计划检查培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPersonTrmTrainPlan(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id, @RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermService.checkKey(trmtrainplantermMapping.toDomain(trmtrainplantermdto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermService.get(#trmtrainplanterm_id),'ehr-TrmTrainPlanterm-Update')")
    @ApiOperation(value = "根据人员信息培训计划更新培训立项", tags = {"培训立项" },  notes = "根据人员信息培训计划更新培训立项")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}")
    @Transactional
    public ResponseEntity<TrmTrainPlantermDTO> updateByPimPersonTrmTrainPlan(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        TrmTrainPlanterm domain = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
        domain.setTrmtrainplanid(trmtrainplan_id);
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
		trmtrainplantermService.update(domain);
        TrmTrainPlantermDTO dto = trmtrainplantermMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermService.getTrmtrainplantermByEntities(this.trmtrainplantermMapping.toDomain(#trmtrainplantermdtos)),'ehr-TrmTrainPlanterm-Update')")
    @ApiOperation(value = "根据人员信息培训计划批量更新培训立项", tags = {"培训立项" },  notes = "根据人员信息培训计划批量更新培训立项")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/batch")
    public ResponseEntity<Boolean> updateBatchByPimPersonTrmTrainPlan(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id, @RequestBody List<TrmTrainPlantermDTO> trmtrainplantermdtos) {
        List<TrmTrainPlanterm> domainlist=trmtrainplantermMapping.toDomain(trmtrainplantermdtos);
        for(TrmTrainPlanterm domain:domainlist){
            domain.setTrmtrainplanid(trmtrainplan_id);
        }
        trmtrainplantermService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermMapping.toDomain(#trmtrainplantermdto),'ehr-TrmTrainPlanterm-Save')")
    @ApiOperation(value = "根据人员信息培训计划保存培训立项", tags = {"培训立项" },  notes = "根据人员信息培训计划保存培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/save")
    public ResponseEntity<Boolean> saveByPimPersonTrmTrainPlan(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id, @RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        TrmTrainPlanterm domain = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
        domain.setTrmtrainplanid(trmtrainplan_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermMapping.toDomain(#trmtrainplantermdtos),'ehr-TrmTrainPlanterm-Save')")
    @ApiOperation(value = "根据人员信息培训计划批量保存培训立项", tags = {"培训立项" },  notes = "根据人员信息培训计划批量保存培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPersonTrmTrainPlan(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id, @RequestBody List<TrmTrainPlantermDTO> trmtrainplantermdtos) {
        List<TrmTrainPlanterm> domainlist=trmtrainplantermMapping.toDomain(trmtrainplantermdtos);
        for(TrmTrainPlanterm domain:domainlist){
             domain.setTrmtrainplanid(trmtrainplan_id);
        }
        trmtrainplantermService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息培训计划获取培训立项草稿", tags = {"培训立项" },  notes = "根据人员信息培训计划获取培训立项草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/getdraft")
    public ResponseEntity<TrmTrainPlantermDTO> getDraftByPimPersonTrmTrainPlan(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id) {
        TrmTrainPlanterm domain = new TrmTrainPlanterm();
        domain.setTrmtrainplanid(trmtrainplan_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermMapping.toDto(trmtrainplantermService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPlanterm-KB-all')")
    @ApiOperation(value = "根据人员信息培训计划培训立项", tags = {"培训立项" },  notes = "根据人员信息培训计划培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/kb")
    @Transactional
    public ResponseEntity<TrmTrainPlantermDTO> kBByPimPersonTrmTrainPlan(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        TrmTrainPlanterm domain = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
        domain.setTrmtrainplanid(trmtrainplan_id);
        domain = trmtrainplantermService.kB(domain) ;
        trmtrainplantermdto = trmtrainplantermMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermdto);
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermMapping.toDomain(#trmtrainplantermdto),'ehr-TrmTrainPlanterm-Create')")
    @ApiOperation(value = "根据人员信息培训计划建立培训立项", tags = {"培训立项" },  notes = "根据人员信息培训计划建立培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms")
    @Transactional
    public ResponseEntity<TrmTrainPlantermDTO> createByPimPersonTrmTrainPlan(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id, @RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        TrmTrainPlanterm domain = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
        domain.setTrmtrainplanid(trmtrainplan_id);
		trmtrainplantermService.create(domain);
        TrmTrainPlantermDTO dto = trmtrainplantermMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermMapping.toDomain(#trmtrainplantermdtos),'ehr-TrmTrainPlanterm-Create')")
    @ApiOperation(value = "根据人员信息培训计划批量建立培训立项", tags = {"培训立项" },  notes = "根据人员信息培训计划批量建立培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/batch")
    public ResponseEntity<Boolean> createBatchByPimPersonTrmTrainPlan(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id, @RequestBody List<TrmTrainPlantermDTO> trmtrainplantermdtos) {
        List<TrmTrainPlanterm> domainlist=trmtrainplantermMapping.toDomain(trmtrainplantermdtos);
        for(TrmTrainPlanterm domain:domainlist){
            domain.setTrmtrainplanid(trmtrainplan_id);
        }
        trmtrainplantermService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPlanterm-QX-all')")
    @ApiOperation(value = "根据人员信息培训计划培训立项", tags = {"培训立项" },  notes = "根据人员信息培训计划培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/qx")
    @Transactional
    public ResponseEntity<TrmTrainPlantermDTO> qXByPimPersonTrmTrainPlan(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        TrmTrainPlanterm domain = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
        domain.setTrmtrainplanid(trmtrainplan_id);
        domain = trmtrainplantermService.qX(domain) ;
        trmtrainplantermdto = trmtrainplantermMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPlanterm-LX-all')")
    @ApiOperation(value = "根据人员信息培训计划培训立项", tags = {"培训立项" },  notes = "根据人员信息培训计划培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/lx")
    @Transactional
    public ResponseEntity<TrmTrainPlantermDTO> lXByPimPersonTrmTrainPlan(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        TrmTrainPlanterm domain = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
        domain.setTrmtrainplanid(trmtrainplan_id);
        domain = trmtrainplantermService.lX(domain) ;
        trmtrainplantermdto = trmtrainplantermMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPlanterm-Default-all')")
	@ApiOperation(value = "根据人员信息培训计划获取DEFAULT", tags = {"培训立项" } ,notes = "根据人员信息培训计划获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/fetchdefault")
	public ResponseEntity<List<TrmTrainPlantermDTO>> fetchTrmTrainPlantermDefaultByPimPersonTrmTrainPlan(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id,TrmTrainPlantermSearchContext context) {
        context.setN_trmtrainplanid_eq(trmtrainplan_id);
        Page<TrmTrainPlanterm> domains = trmtrainplantermService.searchDefault(context) ;
        List<TrmTrainPlantermDTO> list = trmtrainplantermMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPlanterm-Default-all')")
	@ApiOperation(value = "根据人员信息培训计划查询DEFAULT", tags = {"培训立项" } ,notes = "根据人员信息培训计划查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/searchdefault")
	public ResponseEntity<Page<TrmTrainPlantermDTO>> searchTrmTrainPlantermDefaultByPimPersonTrmTrainPlan(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id, @RequestBody TrmTrainPlantermSearchContext context) {
        context.setN_trmtrainplanid_eq(trmtrainplan_id);
        Page<TrmTrainPlanterm> domains = trmtrainplantermService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainplantermMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.trmtrainplantermMapping.toDomain(returnObject.body),'ehr-TrmTrainPlanterm-Get')")
    @ApiOperation(value = "根据培训机构培训讲师获取培训立项", tags = {"培训立项" },  notes = "根据培训机构培训讲师获取培训立项")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}")
    public ResponseEntity<TrmTrainPlantermDTO> getByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id) {
        TrmTrainPlanterm domain = trmtrainplantermService.get(trmtrainplanterm_id);
        TrmTrainPlantermDTO dto = trmtrainplantermMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermService.get(#trmtrainplanterm_id),'ehr-TrmTrainPlanterm-Remove')")
    @ApiOperation(value = "根据培训机构培训讲师删除培训立项", tags = {"培训立项" },  notes = "根据培训机构培训讲师删除培训立项")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermService.remove(trmtrainplanterm_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermService.getTrmtrainplantermByIds(#ids),'ehr-TrmTrainPlanterm-Remove')")
    @ApiOperation(value = "根据培训机构培训讲师批量删除培训立项", tags = {"培训立项" },  notes = "根据培训机构培训讲师批量删除培训立项")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/batch")
    public ResponseEntity<Boolean> removeBatchByTrmTrainAgencyTrmTrainTeacher(@RequestBody List<String> ids) {
        trmtrainplantermService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据培训机构培训讲师检查培训立项", tags = {"培训立项" },  notes = "根据培训机构培训讲师检查培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/checkkey")
    public ResponseEntity<Boolean> checkKeyByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermService.checkKey(trmtrainplantermMapping.toDomain(trmtrainplantermdto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermService.get(#trmtrainplanterm_id),'ehr-TrmTrainPlanterm-Update')")
    @ApiOperation(value = "根据培训机构培训讲师更新培训立项", tags = {"培训立项" },  notes = "根据培训机构培训讲师更新培训立项")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}")
    @Transactional
    public ResponseEntity<TrmTrainPlantermDTO> updateByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        TrmTrainPlanterm domain = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
        domain.setTrmtrainteacherid(trmtrainteacher_id);
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
		trmtrainplantermService.update(domain);
        TrmTrainPlantermDTO dto = trmtrainplantermMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermService.getTrmtrainplantermByEntities(this.trmtrainplantermMapping.toDomain(#trmtrainplantermdtos)),'ehr-TrmTrainPlanterm-Update')")
    @ApiOperation(value = "根据培训机构培训讲师批量更新培训立项", tags = {"培训立项" },  notes = "根据培训机构培训讲师批量更新培训立项")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/batch")
    public ResponseEntity<Boolean> updateBatchByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody List<TrmTrainPlantermDTO> trmtrainplantermdtos) {
        List<TrmTrainPlanterm> domainlist=trmtrainplantermMapping.toDomain(trmtrainplantermdtos);
        for(TrmTrainPlanterm domain:domainlist){
            domain.setTrmtrainteacherid(trmtrainteacher_id);
        }
        trmtrainplantermService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermMapping.toDomain(#trmtrainplantermdto),'ehr-TrmTrainPlanterm-Save')")
    @ApiOperation(value = "根据培训机构培训讲师保存培训立项", tags = {"培训立项" },  notes = "根据培训机构培训讲师保存培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/save")
    public ResponseEntity<Boolean> saveByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        TrmTrainPlanterm domain = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
        domain.setTrmtrainteacherid(trmtrainteacher_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermMapping.toDomain(#trmtrainplantermdtos),'ehr-TrmTrainPlanterm-Save')")
    @ApiOperation(value = "根据培训机构培训讲师批量保存培训立项", tags = {"培训立项" },  notes = "根据培训机构培训讲师批量保存培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/savebatch")
    public ResponseEntity<Boolean> saveBatchByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody List<TrmTrainPlantermDTO> trmtrainplantermdtos) {
        List<TrmTrainPlanterm> domainlist=trmtrainplantermMapping.toDomain(trmtrainplantermdtos);
        for(TrmTrainPlanterm domain:domainlist){
             domain.setTrmtrainteacherid(trmtrainteacher_id);
        }
        trmtrainplantermService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据培训机构培训讲师获取培训立项草稿", tags = {"培训立项" },  notes = "根据培训机构培训讲师获取培训立项草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/getdraft")
    public ResponseEntity<TrmTrainPlantermDTO> getDraftByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id) {
        TrmTrainPlanterm domain = new TrmTrainPlanterm();
        domain.setTrmtrainteacherid(trmtrainteacher_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermMapping.toDto(trmtrainplantermService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPlanterm-KB-all')")
    @ApiOperation(value = "根据培训机构培训讲师培训立项", tags = {"培训立项" },  notes = "根据培训机构培训讲师培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/kb")
    @Transactional
    public ResponseEntity<TrmTrainPlantermDTO> kBByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        TrmTrainPlanterm domain = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
        domain.setTrmtrainteacherid(trmtrainteacher_id);
        domain = trmtrainplantermService.kB(domain) ;
        trmtrainplantermdto = trmtrainplantermMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermdto);
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermMapping.toDomain(#trmtrainplantermdto),'ehr-TrmTrainPlanterm-Create')")
    @ApiOperation(value = "根据培训机构培训讲师建立培训立项", tags = {"培训立项" },  notes = "根据培训机构培训讲师建立培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms")
    @Transactional
    public ResponseEntity<TrmTrainPlantermDTO> createByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        TrmTrainPlanterm domain = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
        domain.setTrmtrainteacherid(trmtrainteacher_id);
		trmtrainplantermService.create(domain);
        TrmTrainPlantermDTO dto = trmtrainplantermMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainplantermMapping.toDomain(#trmtrainplantermdtos),'ehr-TrmTrainPlanterm-Create')")
    @ApiOperation(value = "根据培训机构培训讲师批量建立培训立项", tags = {"培训立项" },  notes = "根据培训机构培训讲师批量建立培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/batch")
    public ResponseEntity<Boolean> createBatchByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody List<TrmTrainPlantermDTO> trmtrainplantermdtos) {
        List<TrmTrainPlanterm> domainlist=trmtrainplantermMapping.toDomain(trmtrainplantermdtos);
        for(TrmTrainPlanterm domain:domainlist){
            domain.setTrmtrainteacherid(trmtrainteacher_id);
        }
        trmtrainplantermService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPlanterm-QX-all')")
    @ApiOperation(value = "根据培训机构培训讲师培训立项", tags = {"培训立项" },  notes = "根据培训机构培训讲师培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/qx")
    @Transactional
    public ResponseEntity<TrmTrainPlantermDTO> qXByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        TrmTrainPlanterm domain = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
        domain.setTrmtrainteacherid(trmtrainteacher_id);
        domain = trmtrainplantermService.qX(domain) ;
        trmtrainplantermdto = trmtrainplantermMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPlanterm-LX-all')")
    @ApiOperation(value = "根据培训机构培训讲师培训立项", tags = {"培训立项" },  notes = "根据培训机构培训讲师培训立项")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/lx")
    @Transactional
    public ResponseEntity<TrmTrainPlantermDTO> lXByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainPlantermDTO trmtrainplantermdto) {
        TrmTrainPlanterm domain = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
        domain.setTrmtrainteacherid(trmtrainteacher_id);
        domain = trmtrainplantermService.lX(domain) ;
        trmtrainplantermdto = trmtrainplantermMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPlanterm-Default-all')")
	@ApiOperation(value = "根据培训机构培训讲师获取DEFAULT", tags = {"培训立项" } ,notes = "根据培训机构培训讲师获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/fetchdefault")
	public ResponseEntity<List<TrmTrainPlantermDTO>> fetchTrmTrainPlantermDefaultByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id,TrmTrainPlantermSearchContext context) {
        context.setN_trmtrainteacherid_eq(trmtrainteacher_id);
        Page<TrmTrainPlanterm> domains = trmtrainplantermService.searchDefault(context) ;
        List<TrmTrainPlantermDTO> list = trmtrainplantermMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPlanterm-Default-all')")
	@ApiOperation(value = "根据培训机构培训讲师查询DEFAULT", tags = {"培训立项" } ,notes = "根据培训机构培训讲师查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/searchdefault")
	public ResponseEntity<Page<TrmTrainPlantermDTO>> searchTrmTrainPlantermDefaultByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody TrmTrainPlantermSearchContext context) {
        context.setN_trmtrainteacherid_eq(trmtrainteacher_id);
        Page<TrmTrainPlanterm> domains = trmtrainplantermService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainplantermMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

