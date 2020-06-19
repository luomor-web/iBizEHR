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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainBuapply;
import cn.ibizlab.ehr.core.trm.service.ITrmTrainBuapplyService;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainBuapplySearchContext;

@Slf4j
@Api(tags = {"教育经费" })
@RestController("WebApi-trmtrainbuapply")
@RequestMapping("")
public class TrmTrainBuapplyResource {

    @Autowired
    public ITrmTrainBuapplyService trmtrainbuapplyService;

    @Autowired
    @Lazy
    public TrmTrainBuapplyMapping trmtrainbuapplyMapping;

    @PreAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydto),'ehr-TrmTrainBuapply-Create')")
    @ApiOperation(value = "新建教育经费", tags = {"教育经费" },  notes = "新建教育经费")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainbuapplies")
    @Transactional
    public ResponseEntity<TrmTrainBuapplyDTO> create(@RequestBody TrmTrainBuapplyDTO trmtrainbuapplydto) {
        TrmTrainBuapply domain = trmtrainbuapplyMapping.toDomain(trmtrainbuapplydto);
		trmtrainbuapplyService.create(domain);
        TrmTrainBuapplyDTO dto = trmtrainbuapplyMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydtos),'ehr-TrmTrainBuapply-Create')")
    @ApiOperation(value = "批量新建教育经费", tags = {"教育经费" },  notes = "批量新建教育经费")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainbuapplies/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmTrainBuapplyDTO> trmtrainbuapplydtos) {
        trmtrainbuapplyService.createBatch(trmtrainbuapplyMapping.toDomain(trmtrainbuapplydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyService.get(#trmtrainbuapply_id),'ehr-TrmTrainBuapply-Update')")
    @ApiOperation(value = "更新教育经费", tags = {"教育经费" },  notes = "更新教育经费")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainbuapplies/{trmtrainbuapply_id}")
    @Transactional
    public ResponseEntity<TrmTrainBuapplyDTO> update(@PathVariable("trmtrainbuapply_id") String trmtrainbuapply_id, @RequestBody TrmTrainBuapplyDTO trmtrainbuapplydto) {
		TrmTrainBuapply domain  = trmtrainbuapplyMapping.toDomain(trmtrainbuapplydto);
        domain .setTrmtrainbuapplyid(trmtrainbuapply_id);
		trmtrainbuapplyService.update(domain );
		TrmTrainBuapplyDTO dto = trmtrainbuapplyMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyService.getTrmtrainbuapplyByEntities(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydtos)),'ehr-TrmTrainBuapply-Update')")
    @ApiOperation(value = "批量更新教育经费", tags = {"教育经费" },  notes = "批量更新教育经费")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainbuapplies/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmTrainBuapplyDTO> trmtrainbuapplydtos) {
        trmtrainbuapplyService.updateBatch(trmtrainbuapplyMapping.toDomain(trmtrainbuapplydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取教育经费草稿", tags = {"教育经费" },  notes = "获取教育经费草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainbuapplies/getdraft")
    public ResponseEntity<TrmTrainBuapplyDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainbuapplyMapping.toDto(trmtrainbuapplyService.getDraft(new TrmTrainBuapply())));
    }

    @PostAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(returnObject.body),'ehr-TrmTrainBuapply-Get')")
    @ApiOperation(value = "获取教育经费", tags = {"教育经费" },  notes = "获取教育经费")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainbuapplies/{trmtrainbuapply_id}")
    public ResponseEntity<TrmTrainBuapplyDTO> get(@PathVariable("trmtrainbuapply_id") String trmtrainbuapply_id) {
        TrmTrainBuapply domain = trmtrainbuapplyService.get(trmtrainbuapply_id);
        TrmTrainBuapplyDTO dto = trmtrainbuapplyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "检查教育经费", tags = {"教育经费" },  notes = "检查教育经费")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainbuapplies/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmTrainBuapplyDTO trmtrainbuapplydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainbuapplyService.checkKey(trmtrainbuapplyMapping.toDomain(trmtrainbuapplydto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyService.get(#trmtrainbuapply_id),'ehr-TrmTrainBuapply-Remove')")
    @ApiOperation(value = "删除教育经费", tags = {"教育经费" },  notes = "删除教育经费")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainbuapplies/{trmtrainbuapply_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtrainbuapply_id") String trmtrainbuapply_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtrainbuapplyService.remove(trmtrainbuapply_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyService.getTrmtrainbuapplyByIds(#ids),'ehr-TrmTrainBuapply-Remove')")
    @ApiOperation(value = "批量删除教育经费", tags = {"教育经费" },  notes = "批量删除教育经费")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainbuapplies/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtrainbuapplyService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydto),'ehr-TrmTrainBuapply-Save')")
    @ApiOperation(value = "保存教育经费", tags = {"教育经费" },  notes = "保存教育经费")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainbuapplies/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmTrainBuapplyDTO trmtrainbuapplydto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainbuapplyService.save(trmtrainbuapplyMapping.toDomain(trmtrainbuapplydto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydtos),'ehr-TrmTrainBuapply-Save')")
    @ApiOperation(value = "批量保存教育经费", tags = {"教育经费" },  notes = "批量保存教育经费")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainbuapplies/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmTrainBuapplyDTO> trmtrainbuapplydtos) {
        trmtrainbuapplyService.saveBatch(trmtrainbuapplyMapping.toDomain(trmtrainbuapplydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainBuapply-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"教育经费" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainbuapplies/fetchdefault")
	public ResponseEntity<List<TrmTrainBuapplyDTO>> fetchDefault(TrmTrainBuapplySearchContext context) {
        Page<TrmTrainBuapply> domains = trmtrainbuapplyService.searchDefault(context) ;
        List<TrmTrainBuapplyDTO> list = trmtrainbuapplyMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainBuapply-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"教育经费" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainbuapplies/searchdefault")
	public ResponseEntity<Page<TrmTrainBuapplyDTO>> searchDefault(@RequestBody TrmTrainBuapplySearchContext context) {
        Page<TrmTrainBuapply> domains = trmtrainbuapplyService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainbuapplyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydto),'ehr-TrmTrainBuapply-Create')")
    @ApiOperation(value = "根据培训立项建立教育经费", tags = {"教育经费" },  notes = "根据培训立项建立教育经费")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies")
    @Transactional
    public ResponseEntity<TrmTrainBuapplyDTO> createByTrmTrainPlanterm(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainBuapplyDTO trmtrainbuapplydto) {
        TrmTrainBuapply domain = trmtrainbuapplyMapping.toDomain(trmtrainbuapplydto);
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
		trmtrainbuapplyService.create(domain);
        TrmTrainBuapplyDTO dto = trmtrainbuapplyMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydtos),'ehr-TrmTrainBuapply-Create')")
    @ApiOperation(value = "根据培训立项批量建立教育经费", tags = {"教育经费" },  notes = "根据培训立项批量建立教育经费")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/batch")
    public ResponseEntity<Boolean> createBatchByTrmTrainPlanterm(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody List<TrmTrainBuapplyDTO> trmtrainbuapplydtos) {
        List<TrmTrainBuapply> domainlist=trmtrainbuapplyMapping.toDomain(trmtrainbuapplydtos);
        for(TrmTrainBuapply domain:domainlist){
            domain.setTrmtrainplantermid(trmtrainplanterm_id);
        }
        trmtrainbuapplyService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyService.get(#trmtrainbuapply_id),'ehr-TrmTrainBuapply-Update')")
    @ApiOperation(value = "根据培训立项更新教育经费", tags = {"教育经费" },  notes = "根据培训立项更新教育经费")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/{trmtrainbuapply_id}")
    @Transactional
    public ResponseEntity<TrmTrainBuapplyDTO> updateByTrmTrainPlanterm(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @PathVariable("trmtrainbuapply_id") String trmtrainbuapply_id, @RequestBody TrmTrainBuapplyDTO trmtrainbuapplydto) {
        TrmTrainBuapply domain = trmtrainbuapplyMapping.toDomain(trmtrainbuapplydto);
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
        domain.setTrmtrainbuapplyid(trmtrainbuapply_id);
		trmtrainbuapplyService.update(domain);
        TrmTrainBuapplyDTO dto = trmtrainbuapplyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyService.getTrmtrainbuapplyByEntities(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydtos)),'ehr-TrmTrainBuapply-Update')")
    @ApiOperation(value = "根据培训立项批量更新教育经费", tags = {"教育经费" },  notes = "根据培训立项批量更新教育经费")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/batch")
    public ResponseEntity<Boolean> updateBatchByTrmTrainPlanterm(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody List<TrmTrainBuapplyDTO> trmtrainbuapplydtos) {
        List<TrmTrainBuapply> domainlist=trmtrainbuapplyMapping.toDomain(trmtrainbuapplydtos);
        for(TrmTrainBuapply domain:domainlist){
            domain.setTrmtrainplantermid(trmtrainplanterm_id);
        }
        trmtrainbuapplyService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据培训立项获取教育经费草稿", tags = {"教育经费" },  notes = "根据培训立项获取教育经费草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/getdraft")
    public ResponseEntity<TrmTrainBuapplyDTO> getDraftByTrmTrainPlanterm(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id) {
        TrmTrainBuapply domain = new TrmTrainBuapply();
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainbuapplyMapping.toDto(trmtrainbuapplyService.getDraft(domain)));
    }

    @PostAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(returnObject.body),'ehr-TrmTrainBuapply-Get')")
    @ApiOperation(value = "根据培训立项获取教育经费", tags = {"教育经费" },  notes = "根据培训立项获取教育经费")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/{trmtrainbuapply_id}")
    public ResponseEntity<TrmTrainBuapplyDTO> getByTrmTrainPlanterm(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @PathVariable("trmtrainbuapply_id") String trmtrainbuapply_id) {
        TrmTrainBuapply domain = trmtrainbuapplyService.get(trmtrainbuapply_id);
        TrmTrainBuapplyDTO dto = trmtrainbuapplyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据培训立项检查教育经费", tags = {"教育经费" },  notes = "根据培训立项检查教育经费")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/checkkey")
    public ResponseEntity<Boolean> checkKeyByTrmTrainPlanterm(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainBuapplyDTO trmtrainbuapplydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainbuapplyService.checkKey(trmtrainbuapplyMapping.toDomain(trmtrainbuapplydto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyService.get(#trmtrainbuapply_id),'ehr-TrmTrainBuapply-Remove')")
    @ApiOperation(value = "根据培训立项删除教育经费", tags = {"教育经费" },  notes = "根据培训立项删除教育经费")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/{trmtrainbuapply_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByTrmTrainPlanterm(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @PathVariable("trmtrainbuapply_id") String trmtrainbuapply_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmtrainbuapplyService.remove(trmtrainbuapply_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyService.getTrmtrainbuapplyByIds(#ids),'ehr-TrmTrainBuapply-Remove')")
    @ApiOperation(value = "根据培训立项批量删除教育经费", tags = {"教育经费" },  notes = "根据培训立项批量删除教育经费")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/batch")
    public ResponseEntity<Boolean> removeBatchByTrmTrainPlanterm(@RequestBody List<String> ids) {
        trmtrainbuapplyService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydto),'ehr-TrmTrainBuapply-Save')")
    @ApiOperation(value = "根据培训立项保存教育经费", tags = {"教育经费" },  notes = "根据培训立项保存教育经费")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/save")
    public ResponseEntity<Boolean> saveByTrmTrainPlanterm(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainBuapplyDTO trmtrainbuapplydto) {
        TrmTrainBuapply domain = trmtrainbuapplyMapping.toDomain(trmtrainbuapplydto);
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainbuapplyService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydtos),'ehr-TrmTrainBuapply-Save')")
    @ApiOperation(value = "根据培训立项批量保存教育经费", tags = {"教育经费" },  notes = "根据培训立项批量保存教育经费")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/savebatch")
    public ResponseEntity<Boolean> saveBatchByTrmTrainPlanterm(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody List<TrmTrainBuapplyDTO> trmtrainbuapplydtos) {
        List<TrmTrainBuapply> domainlist=trmtrainbuapplyMapping.toDomain(trmtrainbuapplydtos);
        for(TrmTrainBuapply domain:domainlist){
             domain.setTrmtrainplantermid(trmtrainplanterm_id);
        }
        trmtrainbuapplyService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainBuapply-Default-all')")
	@ApiOperation(value = "根据培训立项获取DEFAULT", tags = {"教育经费" } ,notes = "根据培训立项获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/fetchdefault")
	public ResponseEntity<List<TrmTrainBuapplyDTO>> fetchTrmTrainBuapplyDefaultByTrmTrainPlanterm(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id,TrmTrainBuapplySearchContext context) {
        context.setN_trmtrainplantermid_eq(trmtrainplanterm_id);
        Page<TrmTrainBuapply> domains = trmtrainbuapplyService.searchDefault(context) ;
        List<TrmTrainBuapplyDTO> list = trmtrainbuapplyMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainBuapply-Default-all')")
	@ApiOperation(value = "根据培训立项查询DEFAULT", tags = {"教育经费" } ,notes = "根据培训立项查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/searchdefault")
	public ResponseEntity<Page<TrmTrainBuapplyDTO>> searchTrmTrainBuapplyDefaultByTrmTrainPlanterm(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainBuapplySearchContext context) {
        context.setN_trmtrainplantermid_eq(trmtrainplanterm_id);
        Page<TrmTrainBuapply> domains = trmtrainbuapplyService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainbuapplyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydto),'ehr-TrmTrainBuapply-Create')")
    @ApiOperation(value = "根据培训计划培训立项建立教育经费", tags = {"教育经费" },  notes = "根据培训计划培训立项建立教育经费")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies")
    @Transactional
    public ResponseEntity<TrmTrainBuapplyDTO> createByTrmTrainPlanTrmTrainPlanterm(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainBuapplyDTO trmtrainbuapplydto) {
        TrmTrainBuapply domain = trmtrainbuapplyMapping.toDomain(trmtrainbuapplydto);
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
		trmtrainbuapplyService.create(domain);
        TrmTrainBuapplyDTO dto = trmtrainbuapplyMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydtos),'ehr-TrmTrainBuapply-Create')")
    @ApiOperation(value = "根据培训计划培训立项批量建立教育经费", tags = {"教育经费" },  notes = "根据培训计划培训立项批量建立教育经费")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/batch")
    public ResponseEntity<Boolean> createBatchByTrmTrainPlanTrmTrainPlanterm(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody List<TrmTrainBuapplyDTO> trmtrainbuapplydtos) {
        List<TrmTrainBuapply> domainlist=trmtrainbuapplyMapping.toDomain(trmtrainbuapplydtos);
        for(TrmTrainBuapply domain:domainlist){
            domain.setTrmtrainplantermid(trmtrainplanterm_id);
        }
        trmtrainbuapplyService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyService.get(#trmtrainbuapply_id),'ehr-TrmTrainBuapply-Update')")
    @ApiOperation(value = "根据培训计划培训立项更新教育经费", tags = {"教育经费" },  notes = "根据培训计划培训立项更新教育经费")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/{trmtrainbuapply_id}")
    @Transactional
    public ResponseEntity<TrmTrainBuapplyDTO> updateByTrmTrainPlanTrmTrainPlanterm(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @PathVariable("trmtrainbuapply_id") String trmtrainbuapply_id, @RequestBody TrmTrainBuapplyDTO trmtrainbuapplydto) {
        TrmTrainBuapply domain = trmtrainbuapplyMapping.toDomain(trmtrainbuapplydto);
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
        domain.setTrmtrainbuapplyid(trmtrainbuapply_id);
		trmtrainbuapplyService.update(domain);
        TrmTrainBuapplyDTO dto = trmtrainbuapplyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyService.getTrmtrainbuapplyByEntities(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydtos)),'ehr-TrmTrainBuapply-Update')")
    @ApiOperation(value = "根据培训计划培训立项批量更新教育经费", tags = {"教育经费" },  notes = "根据培训计划培训立项批量更新教育经费")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/batch")
    public ResponseEntity<Boolean> updateBatchByTrmTrainPlanTrmTrainPlanterm(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody List<TrmTrainBuapplyDTO> trmtrainbuapplydtos) {
        List<TrmTrainBuapply> domainlist=trmtrainbuapplyMapping.toDomain(trmtrainbuapplydtos);
        for(TrmTrainBuapply domain:domainlist){
            domain.setTrmtrainplantermid(trmtrainplanterm_id);
        }
        trmtrainbuapplyService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据培训计划培训立项获取教育经费草稿", tags = {"教育经费" },  notes = "根据培训计划培训立项获取教育经费草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/getdraft")
    public ResponseEntity<TrmTrainBuapplyDTO> getDraftByTrmTrainPlanTrmTrainPlanterm(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id) {
        TrmTrainBuapply domain = new TrmTrainBuapply();
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainbuapplyMapping.toDto(trmtrainbuapplyService.getDraft(domain)));
    }

    @PostAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(returnObject.body),'ehr-TrmTrainBuapply-Get')")
    @ApiOperation(value = "根据培训计划培训立项获取教育经费", tags = {"教育经费" },  notes = "根据培训计划培训立项获取教育经费")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/{trmtrainbuapply_id}")
    public ResponseEntity<TrmTrainBuapplyDTO> getByTrmTrainPlanTrmTrainPlanterm(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @PathVariable("trmtrainbuapply_id") String trmtrainbuapply_id) {
        TrmTrainBuapply domain = trmtrainbuapplyService.get(trmtrainbuapply_id);
        TrmTrainBuapplyDTO dto = trmtrainbuapplyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据培训计划培训立项检查教育经费", tags = {"教育经费" },  notes = "根据培训计划培训立项检查教育经费")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/checkkey")
    public ResponseEntity<Boolean> checkKeyByTrmTrainPlanTrmTrainPlanterm(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainBuapplyDTO trmtrainbuapplydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainbuapplyService.checkKey(trmtrainbuapplyMapping.toDomain(trmtrainbuapplydto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyService.get(#trmtrainbuapply_id),'ehr-TrmTrainBuapply-Remove')")
    @ApiOperation(value = "根据培训计划培训立项删除教育经费", tags = {"教育经费" },  notes = "根据培训计划培训立项删除教育经费")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/{trmtrainbuapply_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByTrmTrainPlanTrmTrainPlanterm(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @PathVariable("trmtrainbuapply_id") String trmtrainbuapply_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmtrainbuapplyService.remove(trmtrainbuapply_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyService.getTrmtrainbuapplyByIds(#ids),'ehr-TrmTrainBuapply-Remove')")
    @ApiOperation(value = "根据培训计划培训立项批量删除教育经费", tags = {"教育经费" },  notes = "根据培训计划培训立项批量删除教育经费")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/batch")
    public ResponseEntity<Boolean> removeBatchByTrmTrainPlanTrmTrainPlanterm(@RequestBody List<String> ids) {
        trmtrainbuapplyService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydto),'ehr-TrmTrainBuapply-Save')")
    @ApiOperation(value = "根据培训计划培训立项保存教育经费", tags = {"教育经费" },  notes = "根据培训计划培训立项保存教育经费")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/save")
    public ResponseEntity<Boolean> saveByTrmTrainPlanTrmTrainPlanterm(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainBuapplyDTO trmtrainbuapplydto) {
        TrmTrainBuapply domain = trmtrainbuapplyMapping.toDomain(trmtrainbuapplydto);
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainbuapplyService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydtos),'ehr-TrmTrainBuapply-Save')")
    @ApiOperation(value = "根据培训计划培训立项批量保存教育经费", tags = {"教育经费" },  notes = "根据培训计划培训立项批量保存教育经费")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/savebatch")
    public ResponseEntity<Boolean> saveBatchByTrmTrainPlanTrmTrainPlanterm(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody List<TrmTrainBuapplyDTO> trmtrainbuapplydtos) {
        List<TrmTrainBuapply> domainlist=trmtrainbuapplyMapping.toDomain(trmtrainbuapplydtos);
        for(TrmTrainBuapply domain:domainlist){
             domain.setTrmtrainplantermid(trmtrainplanterm_id);
        }
        trmtrainbuapplyService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainBuapply-Default-all')")
	@ApiOperation(value = "根据培训计划培训立项获取DEFAULT", tags = {"教育经费" } ,notes = "根据培训计划培训立项获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/fetchdefault")
	public ResponseEntity<List<TrmTrainBuapplyDTO>> fetchTrmTrainBuapplyDefaultByTrmTrainPlanTrmTrainPlanterm(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id,TrmTrainBuapplySearchContext context) {
        context.setN_trmtrainplantermid_eq(trmtrainplanterm_id);
        Page<TrmTrainBuapply> domains = trmtrainbuapplyService.searchDefault(context) ;
        List<TrmTrainBuapplyDTO> list = trmtrainbuapplyMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainBuapply-Default-all')")
	@ApiOperation(value = "根据培训计划培训立项查询DEFAULT", tags = {"教育经费" } ,notes = "根据培训计划培训立项查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/searchdefault")
	public ResponseEntity<Page<TrmTrainBuapplyDTO>> searchTrmTrainBuapplyDefaultByTrmTrainPlanTrmTrainPlanterm(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainBuapplySearchContext context) {
        context.setN_trmtrainplantermid_eq(trmtrainplanterm_id);
        Page<TrmTrainBuapply> domains = trmtrainbuapplyService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainbuapplyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydto),'ehr-TrmTrainBuapply-Create')")
    @ApiOperation(value = "根据培训讲师培训立项建立教育经费", tags = {"教育经费" },  notes = "根据培训讲师培训立项建立教育经费")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies")
    @Transactional
    public ResponseEntity<TrmTrainBuapplyDTO> createByTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainBuapplyDTO trmtrainbuapplydto) {
        TrmTrainBuapply domain = trmtrainbuapplyMapping.toDomain(trmtrainbuapplydto);
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
		trmtrainbuapplyService.create(domain);
        TrmTrainBuapplyDTO dto = trmtrainbuapplyMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydtos),'ehr-TrmTrainBuapply-Create')")
    @ApiOperation(value = "根据培训讲师培训立项批量建立教育经费", tags = {"教育经费" },  notes = "根据培训讲师培训立项批量建立教育经费")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/batch")
    public ResponseEntity<Boolean> createBatchByTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody List<TrmTrainBuapplyDTO> trmtrainbuapplydtos) {
        List<TrmTrainBuapply> domainlist=trmtrainbuapplyMapping.toDomain(trmtrainbuapplydtos);
        for(TrmTrainBuapply domain:domainlist){
            domain.setTrmtrainplantermid(trmtrainplanterm_id);
        }
        trmtrainbuapplyService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyService.get(#trmtrainbuapply_id),'ehr-TrmTrainBuapply-Update')")
    @ApiOperation(value = "根据培训讲师培训立项更新教育经费", tags = {"教育经费" },  notes = "根据培训讲师培训立项更新教育经费")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/{trmtrainbuapply_id}")
    @Transactional
    public ResponseEntity<TrmTrainBuapplyDTO> updateByTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @PathVariable("trmtrainbuapply_id") String trmtrainbuapply_id, @RequestBody TrmTrainBuapplyDTO trmtrainbuapplydto) {
        TrmTrainBuapply domain = trmtrainbuapplyMapping.toDomain(trmtrainbuapplydto);
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
        domain.setTrmtrainbuapplyid(trmtrainbuapply_id);
		trmtrainbuapplyService.update(domain);
        TrmTrainBuapplyDTO dto = trmtrainbuapplyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyService.getTrmtrainbuapplyByEntities(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydtos)),'ehr-TrmTrainBuapply-Update')")
    @ApiOperation(value = "根据培训讲师培训立项批量更新教育经费", tags = {"教育经费" },  notes = "根据培训讲师培训立项批量更新教育经费")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/batch")
    public ResponseEntity<Boolean> updateBatchByTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody List<TrmTrainBuapplyDTO> trmtrainbuapplydtos) {
        List<TrmTrainBuapply> domainlist=trmtrainbuapplyMapping.toDomain(trmtrainbuapplydtos);
        for(TrmTrainBuapply domain:domainlist){
            domain.setTrmtrainplantermid(trmtrainplanterm_id);
        }
        trmtrainbuapplyService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据培训讲师培训立项获取教育经费草稿", tags = {"教育经费" },  notes = "根据培训讲师培训立项获取教育经费草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/getdraft")
    public ResponseEntity<TrmTrainBuapplyDTO> getDraftByTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id) {
        TrmTrainBuapply domain = new TrmTrainBuapply();
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainbuapplyMapping.toDto(trmtrainbuapplyService.getDraft(domain)));
    }

    @PostAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(returnObject.body),'ehr-TrmTrainBuapply-Get')")
    @ApiOperation(value = "根据培训讲师培训立项获取教育经费", tags = {"教育经费" },  notes = "根据培训讲师培训立项获取教育经费")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/{trmtrainbuapply_id}")
    public ResponseEntity<TrmTrainBuapplyDTO> getByTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @PathVariable("trmtrainbuapply_id") String trmtrainbuapply_id) {
        TrmTrainBuapply domain = trmtrainbuapplyService.get(trmtrainbuapply_id);
        TrmTrainBuapplyDTO dto = trmtrainbuapplyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据培训讲师培训立项检查教育经费", tags = {"教育经费" },  notes = "根据培训讲师培训立项检查教育经费")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/checkkey")
    public ResponseEntity<Boolean> checkKeyByTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainBuapplyDTO trmtrainbuapplydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainbuapplyService.checkKey(trmtrainbuapplyMapping.toDomain(trmtrainbuapplydto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyService.get(#trmtrainbuapply_id),'ehr-TrmTrainBuapply-Remove')")
    @ApiOperation(value = "根据培训讲师培训立项删除教育经费", tags = {"教育经费" },  notes = "根据培训讲师培训立项删除教育经费")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/{trmtrainbuapply_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @PathVariable("trmtrainbuapply_id") String trmtrainbuapply_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmtrainbuapplyService.remove(trmtrainbuapply_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyService.getTrmtrainbuapplyByIds(#ids),'ehr-TrmTrainBuapply-Remove')")
    @ApiOperation(value = "根据培训讲师培训立项批量删除教育经费", tags = {"教育经费" },  notes = "根据培训讲师培训立项批量删除教育经费")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/batch")
    public ResponseEntity<Boolean> removeBatchByTrmTrainTeacherTrmTrainPlanterm(@RequestBody List<String> ids) {
        trmtrainbuapplyService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydto),'ehr-TrmTrainBuapply-Save')")
    @ApiOperation(value = "根据培训讲师培训立项保存教育经费", tags = {"教育经费" },  notes = "根据培训讲师培训立项保存教育经费")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/save")
    public ResponseEntity<Boolean> saveByTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainBuapplyDTO trmtrainbuapplydto) {
        TrmTrainBuapply domain = trmtrainbuapplyMapping.toDomain(trmtrainbuapplydto);
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainbuapplyService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydtos),'ehr-TrmTrainBuapply-Save')")
    @ApiOperation(value = "根据培训讲师培训立项批量保存教育经费", tags = {"教育经费" },  notes = "根据培训讲师培训立项批量保存教育经费")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/savebatch")
    public ResponseEntity<Boolean> saveBatchByTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody List<TrmTrainBuapplyDTO> trmtrainbuapplydtos) {
        List<TrmTrainBuapply> domainlist=trmtrainbuapplyMapping.toDomain(trmtrainbuapplydtos);
        for(TrmTrainBuapply domain:domainlist){
             domain.setTrmtrainplantermid(trmtrainplanterm_id);
        }
        trmtrainbuapplyService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainBuapply-Default-all')")
	@ApiOperation(value = "根据培训讲师培训立项获取DEFAULT", tags = {"教育经费" } ,notes = "根据培训讲师培训立项获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/fetchdefault")
	public ResponseEntity<List<TrmTrainBuapplyDTO>> fetchTrmTrainBuapplyDefaultByTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id,TrmTrainBuapplySearchContext context) {
        context.setN_trmtrainplantermid_eq(trmtrainplanterm_id);
        Page<TrmTrainBuapply> domains = trmtrainbuapplyService.searchDefault(context) ;
        List<TrmTrainBuapplyDTO> list = trmtrainbuapplyMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainBuapply-Default-all')")
	@ApiOperation(value = "根据培训讲师培训立项查询DEFAULT", tags = {"教育经费" } ,notes = "根据培训讲师培训立项查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/searchdefault")
	public ResponseEntity<Page<TrmTrainBuapplyDTO>> searchTrmTrainBuapplyDefaultByTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainBuapplySearchContext context) {
        context.setN_trmtrainplantermid_eq(trmtrainplanterm_id);
        Page<TrmTrainBuapply> domains = trmtrainbuapplyService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainbuapplyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydto),'ehr-TrmTrainBuapply-Create')")
    @ApiOperation(value = "根据人员信息培训计划培训立项建立教育经费", tags = {"教育经费" },  notes = "根据人员信息培训计划培训立项建立教育经费")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies")
    @Transactional
    public ResponseEntity<TrmTrainBuapplyDTO> createByPimPersonTrmTrainPlanTrmTrainPlanterm(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainBuapplyDTO trmtrainbuapplydto) {
        TrmTrainBuapply domain = trmtrainbuapplyMapping.toDomain(trmtrainbuapplydto);
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
		trmtrainbuapplyService.create(domain);
        TrmTrainBuapplyDTO dto = trmtrainbuapplyMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydtos),'ehr-TrmTrainBuapply-Create')")
    @ApiOperation(value = "根据人员信息培训计划培训立项批量建立教育经费", tags = {"教育经费" },  notes = "根据人员信息培训计划培训立项批量建立教育经费")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/batch")
    public ResponseEntity<Boolean> createBatchByPimPersonTrmTrainPlanTrmTrainPlanterm(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody List<TrmTrainBuapplyDTO> trmtrainbuapplydtos) {
        List<TrmTrainBuapply> domainlist=trmtrainbuapplyMapping.toDomain(trmtrainbuapplydtos);
        for(TrmTrainBuapply domain:domainlist){
            domain.setTrmtrainplantermid(trmtrainplanterm_id);
        }
        trmtrainbuapplyService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyService.get(#trmtrainbuapply_id),'ehr-TrmTrainBuapply-Update')")
    @ApiOperation(value = "根据人员信息培训计划培训立项更新教育经费", tags = {"教育经费" },  notes = "根据人员信息培训计划培训立项更新教育经费")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/{trmtrainbuapply_id}")
    @Transactional
    public ResponseEntity<TrmTrainBuapplyDTO> updateByPimPersonTrmTrainPlanTrmTrainPlanterm(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @PathVariable("trmtrainbuapply_id") String trmtrainbuapply_id, @RequestBody TrmTrainBuapplyDTO trmtrainbuapplydto) {
        TrmTrainBuapply domain = trmtrainbuapplyMapping.toDomain(trmtrainbuapplydto);
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
        domain.setTrmtrainbuapplyid(trmtrainbuapply_id);
		trmtrainbuapplyService.update(domain);
        TrmTrainBuapplyDTO dto = trmtrainbuapplyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyService.getTrmtrainbuapplyByEntities(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydtos)),'ehr-TrmTrainBuapply-Update')")
    @ApiOperation(value = "根据人员信息培训计划培训立项批量更新教育经费", tags = {"教育经费" },  notes = "根据人员信息培训计划培训立项批量更新教育经费")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/batch")
    public ResponseEntity<Boolean> updateBatchByPimPersonTrmTrainPlanTrmTrainPlanterm(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody List<TrmTrainBuapplyDTO> trmtrainbuapplydtos) {
        List<TrmTrainBuapply> domainlist=trmtrainbuapplyMapping.toDomain(trmtrainbuapplydtos);
        for(TrmTrainBuapply domain:domainlist){
            domain.setTrmtrainplantermid(trmtrainplanterm_id);
        }
        trmtrainbuapplyService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息培训计划培训立项获取教育经费草稿", tags = {"教育经费" },  notes = "根据人员信息培训计划培训立项获取教育经费草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/getdraft")
    public ResponseEntity<TrmTrainBuapplyDTO> getDraftByPimPersonTrmTrainPlanTrmTrainPlanterm(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id) {
        TrmTrainBuapply domain = new TrmTrainBuapply();
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainbuapplyMapping.toDto(trmtrainbuapplyService.getDraft(domain)));
    }

    @PostAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(returnObject.body),'ehr-TrmTrainBuapply-Get')")
    @ApiOperation(value = "根据人员信息培训计划培训立项获取教育经费", tags = {"教育经费" },  notes = "根据人员信息培训计划培训立项获取教育经费")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/{trmtrainbuapply_id}")
    public ResponseEntity<TrmTrainBuapplyDTO> getByPimPersonTrmTrainPlanTrmTrainPlanterm(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @PathVariable("trmtrainbuapply_id") String trmtrainbuapply_id) {
        TrmTrainBuapply domain = trmtrainbuapplyService.get(trmtrainbuapply_id);
        TrmTrainBuapplyDTO dto = trmtrainbuapplyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据人员信息培训计划培训立项检查教育经费", tags = {"教育经费" },  notes = "根据人员信息培训计划培训立项检查教育经费")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPersonTrmTrainPlanTrmTrainPlanterm(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainBuapplyDTO trmtrainbuapplydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainbuapplyService.checkKey(trmtrainbuapplyMapping.toDomain(trmtrainbuapplydto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyService.get(#trmtrainbuapply_id),'ehr-TrmTrainBuapply-Remove')")
    @ApiOperation(value = "根据人员信息培训计划培训立项删除教育经费", tags = {"教育经费" },  notes = "根据人员信息培训计划培训立项删除教育经费")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/{trmtrainbuapply_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPersonTrmTrainPlanTrmTrainPlanterm(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @PathVariable("trmtrainbuapply_id") String trmtrainbuapply_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmtrainbuapplyService.remove(trmtrainbuapply_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyService.getTrmtrainbuapplyByIds(#ids),'ehr-TrmTrainBuapply-Remove')")
    @ApiOperation(value = "根据人员信息培训计划培训立项批量删除教育经费", tags = {"教育经费" },  notes = "根据人员信息培训计划培训立项批量删除教育经费")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/batch")
    public ResponseEntity<Boolean> removeBatchByPimPersonTrmTrainPlanTrmTrainPlanterm(@RequestBody List<String> ids) {
        trmtrainbuapplyService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydto),'ehr-TrmTrainBuapply-Save')")
    @ApiOperation(value = "根据人员信息培训计划培训立项保存教育经费", tags = {"教育经费" },  notes = "根据人员信息培训计划培训立项保存教育经费")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/save")
    public ResponseEntity<Boolean> saveByPimPersonTrmTrainPlanTrmTrainPlanterm(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainBuapplyDTO trmtrainbuapplydto) {
        TrmTrainBuapply domain = trmtrainbuapplyMapping.toDomain(trmtrainbuapplydto);
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainbuapplyService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydtos),'ehr-TrmTrainBuapply-Save')")
    @ApiOperation(value = "根据人员信息培训计划培训立项批量保存教育经费", tags = {"教育经费" },  notes = "根据人员信息培训计划培训立项批量保存教育经费")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPersonTrmTrainPlanTrmTrainPlanterm(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody List<TrmTrainBuapplyDTO> trmtrainbuapplydtos) {
        List<TrmTrainBuapply> domainlist=trmtrainbuapplyMapping.toDomain(trmtrainbuapplydtos);
        for(TrmTrainBuapply domain:domainlist){
             domain.setTrmtrainplantermid(trmtrainplanterm_id);
        }
        trmtrainbuapplyService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainBuapply-Default-all')")
	@ApiOperation(value = "根据人员信息培训计划培训立项获取DEFAULT", tags = {"教育经费" } ,notes = "根据人员信息培训计划培训立项获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/fetchdefault")
	public ResponseEntity<List<TrmTrainBuapplyDTO>> fetchTrmTrainBuapplyDefaultByPimPersonTrmTrainPlanTrmTrainPlanterm(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id,TrmTrainBuapplySearchContext context) {
        context.setN_trmtrainplantermid_eq(trmtrainplanterm_id);
        Page<TrmTrainBuapply> domains = trmtrainbuapplyService.searchDefault(context) ;
        List<TrmTrainBuapplyDTO> list = trmtrainbuapplyMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainBuapply-Default-all')")
	@ApiOperation(value = "根据人员信息培训计划培训立项查询DEFAULT", tags = {"教育经费" } ,notes = "根据人员信息培训计划培训立项查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/searchdefault")
	public ResponseEntity<Page<TrmTrainBuapplyDTO>> searchTrmTrainBuapplyDefaultByPimPersonTrmTrainPlanTrmTrainPlanterm(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainBuapplySearchContext context) {
        context.setN_trmtrainplantermid_eq(trmtrainplanterm_id);
        Page<TrmTrainBuapply> domains = trmtrainbuapplyService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainbuapplyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydto),'ehr-TrmTrainBuapply-Create')")
    @ApiOperation(value = "根据培训机构培训讲师培训立项建立教育经费", tags = {"教育经费" },  notes = "根据培训机构培训讲师培训立项建立教育经费")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies")
    @Transactional
    public ResponseEntity<TrmTrainBuapplyDTO> createByTrmTrainAgencyTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainBuapplyDTO trmtrainbuapplydto) {
        TrmTrainBuapply domain = trmtrainbuapplyMapping.toDomain(trmtrainbuapplydto);
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
		trmtrainbuapplyService.create(domain);
        TrmTrainBuapplyDTO dto = trmtrainbuapplyMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydtos),'ehr-TrmTrainBuapply-Create')")
    @ApiOperation(value = "根据培训机构培训讲师培训立项批量建立教育经费", tags = {"教育经费" },  notes = "根据培训机构培训讲师培训立项批量建立教育经费")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/batch")
    public ResponseEntity<Boolean> createBatchByTrmTrainAgencyTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody List<TrmTrainBuapplyDTO> trmtrainbuapplydtos) {
        List<TrmTrainBuapply> domainlist=trmtrainbuapplyMapping.toDomain(trmtrainbuapplydtos);
        for(TrmTrainBuapply domain:domainlist){
            domain.setTrmtrainplantermid(trmtrainplanterm_id);
        }
        trmtrainbuapplyService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyService.get(#trmtrainbuapply_id),'ehr-TrmTrainBuapply-Update')")
    @ApiOperation(value = "根据培训机构培训讲师培训立项更新教育经费", tags = {"教育经费" },  notes = "根据培训机构培训讲师培训立项更新教育经费")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/{trmtrainbuapply_id}")
    @Transactional
    public ResponseEntity<TrmTrainBuapplyDTO> updateByTrmTrainAgencyTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @PathVariable("trmtrainbuapply_id") String trmtrainbuapply_id, @RequestBody TrmTrainBuapplyDTO trmtrainbuapplydto) {
        TrmTrainBuapply domain = trmtrainbuapplyMapping.toDomain(trmtrainbuapplydto);
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
        domain.setTrmtrainbuapplyid(trmtrainbuapply_id);
		trmtrainbuapplyService.update(domain);
        TrmTrainBuapplyDTO dto = trmtrainbuapplyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyService.getTrmtrainbuapplyByEntities(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydtos)),'ehr-TrmTrainBuapply-Update')")
    @ApiOperation(value = "根据培训机构培训讲师培训立项批量更新教育经费", tags = {"教育经费" },  notes = "根据培训机构培训讲师培训立项批量更新教育经费")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/batch")
    public ResponseEntity<Boolean> updateBatchByTrmTrainAgencyTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody List<TrmTrainBuapplyDTO> trmtrainbuapplydtos) {
        List<TrmTrainBuapply> domainlist=trmtrainbuapplyMapping.toDomain(trmtrainbuapplydtos);
        for(TrmTrainBuapply domain:domainlist){
            domain.setTrmtrainplantermid(trmtrainplanterm_id);
        }
        trmtrainbuapplyService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据培训机构培训讲师培训立项获取教育经费草稿", tags = {"教育经费" },  notes = "根据培训机构培训讲师培训立项获取教育经费草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/getdraft")
    public ResponseEntity<TrmTrainBuapplyDTO> getDraftByTrmTrainAgencyTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id) {
        TrmTrainBuapply domain = new TrmTrainBuapply();
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainbuapplyMapping.toDto(trmtrainbuapplyService.getDraft(domain)));
    }

    @PostAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(returnObject.body),'ehr-TrmTrainBuapply-Get')")
    @ApiOperation(value = "根据培训机构培训讲师培训立项获取教育经费", tags = {"教育经费" },  notes = "根据培训机构培训讲师培训立项获取教育经费")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/{trmtrainbuapply_id}")
    public ResponseEntity<TrmTrainBuapplyDTO> getByTrmTrainAgencyTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @PathVariable("trmtrainbuapply_id") String trmtrainbuapply_id) {
        TrmTrainBuapply domain = trmtrainbuapplyService.get(trmtrainbuapply_id);
        TrmTrainBuapplyDTO dto = trmtrainbuapplyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据培训机构培训讲师培训立项检查教育经费", tags = {"教育经费" },  notes = "根据培训机构培训讲师培训立项检查教育经费")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/checkkey")
    public ResponseEntity<Boolean> checkKeyByTrmTrainAgencyTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainBuapplyDTO trmtrainbuapplydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainbuapplyService.checkKey(trmtrainbuapplyMapping.toDomain(trmtrainbuapplydto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyService.get(#trmtrainbuapply_id),'ehr-TrmTrainBuapply-Remove')")
    @ApiOperation(value = "根据培训机构培训讲师培训立项删除教育经费", tags = {"教育经费" },  notes = "根据培训机构培训讲师培训立项删除教育经费")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/{trmtrainbuapply_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByTrmTrainAgencyTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @PathVariable("trmtrainbuapply_id") String trmtrainbuapply_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmtrainbuapplyService.remove(trmtrainbuapply_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyService.getTrmtrainbuapplyByIds(#ids),'ehr-TrmTrainBuapply-Remove')")
    @ApiOperation(value = "根据培训机构培训讲师培训立项批量删除教育经费", tags = {"教育经费" },  notes = "根据培训机构培训讲师培训立项批量删除教育经费")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/batch")
    public ResponseEntity<Boolean> removeBatchByTrmTrainAgencyTrmTrainTeacherTrmTrainPlanterm(@RequestBody List<String> ids) {
        trmtrainbuapplyService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydto),'ehr-TrmTrainBuapply-Save')")
    @ApiOperation(value = "根据培训机构培训讲师培训立项保存教育经费", tags = {"教育经费" },  notes = "根据培训机构培训讲师培训立项保存教育经费")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/save")
    public ResponseEntity<Boolean> saveByTrmTrainAgencyTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainBuapplyDTO trmtrainbuapplydto) {
        TrmTrainBuapply domain = trmtrainbuapplyMapping.toDomain(trmtrainbuapplydto);
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainbuapplyService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydtos),'ehr-TrmTrainBuapply-Save')")
    @ApiOperation(value = "根据培训机构培训讲师培训立项批量保存教育经费", tags = {"教育经费" },  notes = "根据培训机构培训讲师培训立项批量保存教育经费")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/savebatch")
    public ResponseEntity<Boolean> saveBatchByTrmTrainAgencyTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody List<TrmTrainBuapplyDTO> trmtrainbuapplydtos) {
        List<TrmTrainBuapply> domainlist=trmtrainbuapplyMapping.toDomain(trmtrainbuapplydtos);
        for(TrmTrainBuapply domain:domainlist){
             domain.setTrmtrainplantermid(trmtrainplanterm_id);
        }
        trmtrainbuapplyService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainBuapply-Default-all')")
	@ApiOperation(value = "根据培训机构培训讲师培训立项获取DEFAULT", tags = {"教育经费" } ,notes = "根据培训机构培训讲师培训立项获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/fetchdefault")
	public ResponseEntity<List<TrmTrainBuapplyDTO>> fetchTrmTrainBuapplyDefaultByTrmTrainAgencyTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id,TrmTrainBuapplySearchContext context) {
        context.setN_trmtrainplantermid_eq(trmtrainplanterm_id);
        Page<TrmTrainBuapply> domains = trmtrainbuapplyService.searchDefault(context) ;
        List<TrmTrainBuapplyDTO> list = trmtrainbuapplyMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainBuapply-Default-all')")
	@ApiOperation(value = "根据培训机构培训讲师培训立项查询DEFAULT", tags = {"教育经费" } ,notes = "根据培训机构培训讲师培训立项查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmtrainbuapplies/searchdefault")
	public ResponseEntity<Page<TrmTrainBuapplyDTO>> searchTrmTrainBuapplyDefaultByTrmTrainAgencyTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTrainBuapplySearchContext context) {
        context.setN_trmtrainplantermid_eq(trmtrainplanterm_id);
        Page<TrmTrainBuapply> domains = trmtrainbuapplyService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainbuapplyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

