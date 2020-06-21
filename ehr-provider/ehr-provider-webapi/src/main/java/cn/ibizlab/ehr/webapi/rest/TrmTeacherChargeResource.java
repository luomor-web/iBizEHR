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
import cn.ibizlab.ehr.core.trm.domain.TrmTeacherCharge;
import cn.ibizlab.ehr.core.trm.service.ITrmTeacherChargeService;
import cn.ibizlab.ehr.core.trm.filter.TrmTeacherChargeSearchContext;

@Slf4j
@Api(tags = {"讲师收费记录" })
@RestController("WebApi-trmteachercharge")
@RequestMapping("")
public class TrmTeacherChargeResource {

    @Autowired
    public ITrmTeacherChargeService trmteacherchargeService;

    @Autowired
    @Lazy
    public TrmTeacherChargeMapping trmteacherchargeMapping;

    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedto),'ehr-TrmTeacherCharge-Save')")
    @ApiOperation(value = "保存讲师收费记录", tags = {"讲师收费记录" },  notes = "保存讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmteachercharges/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeService.save(trmteacherchargeMapping.toDomain(trmteacherchargedto)));
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedtos),'ehr-TrmTeacherCharge-Save')")
    @ApiOperation(value = "批量保存讲师收费记录", tags = {"讲师收费记录" },  notes = "批量保存讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmteachercharges/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmTeacherChargeDTO> trmteacherchargedtos) {
        trmteacherchargeService.saveBatch(trmteacherchargeMapping.toDomain(trmteacherchargedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(returnObject.body),'ehr-TrmTeacherCharge-Get')")
    @ApiOperation(value = "获取讲师收费记录", tags = {"讲师收费记录" },  notes = "获取讲师收费记录")
	@RequestMapping(method = RequestMethod.GET, value = "/trmteachercharges/{trmteachercharge_id}")
    public ResponseEntity<TrmTeacherChargeDTO> get(@PathVariable("trmteachercharge_id") String trmteachercharge_id) {
        TrmTeacherCharge domain = trmteacherchargeService.get(trmteachercharge_id);
        TrmTeacherChargeDTO dto = trmteacherchargeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.get(#trmteachercharge_id),'ehr-TrmTeacherCharge-Remove')")
    @ApiOperation(value = "删除讲师收费记录", tags = {"讲师收费记录" },  notes = "删除讲师收费记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmteachercharges/{trmteachercharge_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmteachercharge_id") String trmteachercharge_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeService.remove(trmteachercharge_id));
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.getTrmteacherchargeByIds(#ids),'ehr-TrmTeacherCharge-Remove')")
    @ApiOperation(value = "批量删除讲师收费记录", tags = {"讲师收费记录" },  notes = "批量删除讲师收费记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmteachercharges/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmteacherchargeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.get(#trmteachercharge_id),'ehr-TrmTeacherCharge-Update')")
    @ApiOperation(value = "更新讲师收费记录", tags = {"讲师收费记录" },  notes = "更新讲师收费记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmteachercharges/{trmteachercharge_id}")
    @Transactional
    public ResponseEntity<TrmTeacherChargeDTO> update(@PathVariable("trmteachercharge_id") String trmteachercharge_id, @RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
		TrmTeacherCharge domain  = trmteacherchargeMapping.toDomain(trmteacherchargedto);
        domain .setTrmteacherchargeid(trmteachercharge_id);
		trmteacherchargeService.update(domain );
		TrmTeacherChargeDTO dto = trmteacherchargeMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.getTrmteacherchargeByEntities(this.trmteacherchargeMapping.toDomain(#trmteacherchargedtos)),'ehr-TrmTeacherCharge-Update')")
    @ApiOperation(value = "批量更新讲师收费记录", tags = {"讲师收费记录" },  notes = "批量更新讲师收费记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmteachercharges/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmTeacherChargeDTO> trmteacherchargedtos) {
        trmteacherchargeService.updateBatch(trmteacherchargeMapping.toDomain(trmteacherchargedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedto),'ehr-TrmTeacherCharge-Create')")
    @ApiOperation(value = "新建讲师收费记录", tags = {"讲师收费记录" },  notes = "新建讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmteachercharges")
    @Transactional
    public ResponseEntity<TrmTeacherChargeDTO> create(@RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
        TrmTeacherCharge domain = trmteacherchargeMapping.toDomain(trmteacherchargedto);
		trmteacherchargeService.create(domain);
        TrmTeacherChargeDTO dto = trmteacherchargeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedtos),'ehr-TrmTeacherCharge-Create')")
    @ApiOperation(value = "批量新建讲师收费记录", tags = {"讲师收费记录" },  notes = "批量新建讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmteachercharges/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmTeacherChargeDTO> trmteacherchargedtos) {
        trmteacherchargeService.createBatch(trmteacherchargeMapping.toDomain(trmteacherchargedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取讲师收费记录草稿", tags = {"讲师收费记录" },  notes = "获取讲师收费记录草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmteachercharges/getdraft")
    public ResponseEntity<TrmTeacherChargeDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeMapping.toDto(trmteacherchargeService.getDraft(new TrmTeacherCharge())));
    }

    @ApiOperation(value = "检查讲师收费记录", tags = {"讲师收费记录" },  notes = "检查讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmteachercharges/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeService.checkKey(trmteacherchargeMapping.toDomain(trmteacherchargedto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTeacherCharge-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"讲师收费记录" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmteachercharges/fetchdefault")
	public ResponseEntity<List<TrmTeacherChargeDTO>> fetchDefault(TrmTeacherChargeSearchContext context) {
        Page<TrmTeacherCharge> domains = trmteacherchargeService.searchDefault(context) ;
        List<TrmTeacherChargeDTO> list = trmteacherchargeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTeacherCharge-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"讲师收费记录" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmteachercharges/searchdefault")
	public ResponseEntity<Page<TrmTeacherChargeDTO>> searchDefault(@RequestBody TrmTeacherChargeSearchContext context) {
        Page<TrmTeacherCharge> domains = trmteacherchargeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmteacherchargeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedto),'ehr-TrmTeacherCharge-Save')")
    @ApiOperation(value = "根据培训立项保存讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训立项保存讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/save")
    public ResponseEntity<Boolean> saveByTrmTrainPlanterm(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
        TrmTeacherCharge domain = trmteacherchargeMapping.toDomain(trmteacherchargedto);
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedtos),'ehr-TrmTeacherCharge-Save')")
    @ApiOperation(value = "根据培训立项批量保存讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训立项批量保存讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/savebatch")
    public ResponseEntity<Boolean> saveBatchByTrmTrainPlanterm(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody List<TrmTeacherChargeDTO> trmteacherchargedtos) {
        List<TrmTeacherCharge> domainlist=trmteacherchargeMapping.toDomain(trmteacherchargedtos);
        for(TrmTeacherCharge domain:domainlist){
             domain.setTrmtrainplantermid(trmtrainplanterm_id);
        }
        trmteacherchargeService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(returnObject.body),'ehr-TrmTeacherCharge-Get')")
    @ApiOperation(value = "根据培训立项获取讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训立项获取讲师收费记录")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/{trmteachercharge_id}")
    public ResponseEntity<TrmTeacherChargeDTO> getByTrmTrainPlanterm(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @PathVariable("trmteachercharge_id") String trmteachercharge_id) {
        TrmTeacherCharge domain = trmteacherchargeService.get(trmteachercharge_id);
        TrmTeacherChargeDTO dto = trmteacherchargeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.get(#trmteachercharge_id),'ehr-TrmTeacherCharge-Remove')")
    @ApiOperation(value = "根据培训立项删除讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训立项删除讲师收费记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/{trmteachercharge_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByTrmTrainPlanterm(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @PathVariable("trmteachercharge_id") String trmteachercharge_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeService.remove(trmteachercharge_id));
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.getTrmteacherchargeByIds(#ids),'ehr-TrmTeacherCharge-Remove')")
    @ApiOperation(value = "根据培训立项批量删除讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训立项批量删除讲师收费记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/batch")
    public ResponseEntity<Boolean> removeBatchByTrmTrainPlanterm(@RequestBody List<String> ids) {
        trmteacherchargeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.get(#trmteachercharge_id),'ehr-TrmTeacherCharge-Update')")
    @ApiOperation(value = "根据培训立项更新讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训立项更新讲师收费记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/{trmteachercharge_id}")
    @Transactional
    public ResponseEntity<TrmTeacherChargeDTO> updateByTrmTrainPlanterm(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @PathVariable("trmteachercharge_id") String trmteachercharge_id, @RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
        TrmTeacherCharge domain = trmteacherchargeMapping.toDomain(trmteacherchargedto);
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
        domain.setTrmteacherchargeid(trmteachercharge_id);
		trmteacherchargeService.update(domain);
        TrmTeacherChargeDTO dto = trmteacherchargeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.getTrmteacherchargeByEntities(this.trmteacherchargeMapping.toDomain(#trmteacherchargedtos)),'ehr-TrmTeacherCharge-Update')")
    @ApiOperation(value = "根据培训立项批量更新讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训立项批量更新讲师收费记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/batch")
    public ResponseEntity<Boolean> updateBatchByTrmTrainPlanterm(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody List<TrmTeacherChargeDTO> trmteacherchargedtos) {
        List<TrmTeacherCharge> domainlist=trmteacherchargeMapping.toDomain(trmteacherchargedtos);
        for(TrmTeacherCharge domain:domainlist){
            domain.setTrmtrainplantermid(trmtrainplanterm_id);
        }
        trmteacherchargeService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedto),'ehr-TrmTeacherCharge-Create')")
    @ApiOperation(value = "根据培训立项建立讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训立项建立讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges")
    @Transactional
    public ResponseEntity<TrmTeacherChargeDTO> createByTrmTrainPlanterm(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
        TrmTeacherCharge domain = trmteacherchargeMapping.toDomain(trmteacherchargedto);
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
		trmteacherchargeService.create(domain);
        TrmTeacherChargeDTO dto = trmteacherchargeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedtos),'ehr-TrmTeacherCharge-Create')")
    @ApiOperation(value = "根据培训立项批量建立讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训立项批量建立讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/batch")
    public ResponseEntity<Boolean> createBatchByTrmTrainPlanterm(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody List<TrmTeacherChargeDTO> trmteacherchargedtos) {
        List<TrmTeacherCharge> domainlist=trmteacherchargeMapping.toDomain(trmteacherchargedtos);
        for(TrmTeacherCharge domain:domainlist){
            domain.setTrmtrainplantermid(trmtrainplanterm_id);
        }
        trmteacherchargeService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据培训立项获取讲师收费记录草稿", tags = {"讲师收费记录" },  notes = "根据培训立项获取讲师收费记录草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/getdraft")
    public ResponseEntity<TrmTeacherChargeDTO> getDraftByTrmTrainPlanterm(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id) {
        TrmTeacherCharge domain = new TrmTeacherCharge();
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeMapping.toDto(trmteacherchargeService.getDraft(domain)));
    }

    @ApiOperation(value = "根据培训立项检查讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训立项检查讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/checkkey")
    public ResponseEntity<Boolean> checkKeyByTrmTrainPlanterm(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeService.checkKey(trmteacherchargeMapping.toDomain(trmteacherchargedto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTeacherCharge-Default-all')")
	@ApiOperation(value = "根据培训立项获取DEFAULT", tags = {"讲师收费记录" } ,notes = "根据培训立项获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/fetchdefault")
	public ResponseEntity<List<TrmTeacherChargeDTO>> fetchTrmTeacherChargeDefaultByTrmTrainPlanterm(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id,TrmTeacherChargeSearchContext context) {
        context.setN_trmtrainplantermid_eq(trmtrainplanterm_id);
        Page<TrmTeacherCharge> domains = trmteacherchargeService.searchDefault(context) ;
        List<TrmTeacherChargeDTO> list = trmteacherchargeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTeacherCharge-Default-all')")
	@ApiOperation(value = "根据培训立项查询DEFAULT", tags = {"讲师收费记录" } ,notes = "根据培训立项查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/searchdefault")
	public ResponseEntity<Page<TrmTeacherChargeDTO>> searchTrmTeacherChargeDefaultByTrmTrainPlanterm(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTeacherChargeSearchContext context) {
        context.setN_trmtrainplantermid_eq(trmtrainplanterm_id);
        Page<TrmTeacherCharge> domains = trmteacherchargeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmteacherchargeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedto),'ehr-TrmTeacherCharge-Save')")
    @ApiOperation(value = "根据培训讲师保存讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训讲师保存讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers/{trmtrainteacher_id}/trmteachercharges/save")
    public ResponseEntity<Boolean> saveByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
        TrmTeacherCharge domain = trmteacherchargeMapping.toDomain(trmteacherchargedto);
        domain.setTrmtrainteacherid(trmtrainteacher_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedtos),'ehr-TrmTeacherCharge-Save')")
    @ApiOperation(value = "根据培训讲师批量保存讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训讲师批量保存讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers/{trmtrainteacher_id}/trmteachercharges/savebatch")
    public ResponseEntity<Boolean> saveBatchByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody List<TrmTeacherChargeDTO> trmteacherchargedtos) {
        List<TrmTeacherCharge> domainlist=trmteacherchargeMapping.toDomain(trmteacherchargedtos);
        for(TrmTeacherCharge domain:domainlist){
             domain.setTrmtrainteacherid(trmtrainteacher_id);
        }
        trmteacherchargeService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(returnObject.body),'ehr-TrmTeacherCharge-Get')")
    @ApiOperation(value = "根据培训讲师获取讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训讲师获取讲师收费记录")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainteachers/{trmtrainteacher_id}/trmteachercharges/{trmteachercharge_id}")
    public ResponseEntity<TrmTeacherChargeDTO> getByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmteachercharge_id") String trmteachercharge_id) {
        TrmTeacherCharge domain = trmteacherchargeService.get(trmteachercharge_id);
        TrmTeacherChargeDTO dto = trmteacherchargeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.get(#trmteachercharge_id),'ehr-TrmTeacherCharge-Remove')")
    @ApiOperation(value = "根据培训讲师删除讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训讲师删除讲师收费记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainteachers/{trmtrainteacher_id}/trmteachercharges/{trmteachercharge_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmteachercharge_id") String trmteachercharge_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeService.remove(trmteachercharge_id));
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.getTrmteacherchargeByIds(#ids),'ehr-TrmTeacherCharge-Remove')")
    @ApiOperation(value = "根据培训讲师批量删除讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训讲师批量删除讲师收费记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainteachers/{trmtrainteacher_id}/trmteachercharges/batch")
    public ResponseEntity<Boolean> removeBatchByTrmTrainTeacher(@RequestBody List<String> ids) {
        trmteacherchargeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.get(#trmteachercharge_id),'ehr-TrmTeacherCharge-Update')")
    @ApiOperation(value = "根据培训讲师更新讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训讲师更新讲师收费记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainteachers/{trmtrainteacher_id}/trmteachercharges/{trmteachercharge_id}")
    @Transactional
    public ResponseEntity<TrmTeacherChargeDTO> updateByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmteachercharge_id") String trmteachercharge_id, @RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
        TrmTeacherCharge domain = trmteacherchargeMapping.toDomain(trmteacherchargedto);
        domain.setTrmtrainteacherid(trmtrainteacher_id);
        domain.setTrmteacherchargeid(trmteachercharge_id);
		trmteacherchargeService.update(domain);
        TrmTeacherChargeDTO dto = trmteacherchargeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.getTrmteacherchargeByEntities(this.trmteacherchargeMapping.toDomain(#trmteacherchargedtos)),'ehr-TrmTeacherCharge-Update')")
    @ApiOperation(value = "根据培训讲师批量更新讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训讲师批量更新讲师收费记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainteachers/{trmtrainteacher_id}/trmteachercharges/batch")
    public ResponseEntity<Boolean> updateBatchByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody List<TrmTeacherChargeDTO> trmteacherchargedtos) {
        List<TrmTeacherCharge> domainlist=trmteacherchargeMapping.toDomain(trmteacherchargedtos);
        for(TrmTeacherCharge domain:domainlist){
            domain.setTrmtrainteacherid(trmtrainteacher_id);
        }
        trmteacherchargeService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedto),'ehr-TrmTeacherCharge-Create')")
    @ApiOperation(value = "根据培训讲师建立讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训讲师建立讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers/{trmtrainteacher_id}/trmteachercharges")
    @Transactional
    public ResponseEntity<TrmTeacherChargeDTO> createByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
        TrmTeacherCharge domain = trmteacherchargeMapping.toDomain(trmteacherchargedto);
        domain.setTrmtrainteacherid(trmtrainteacher_id);
		trmteacherchargeService.create(domain);
        TrmTeacherChargeDTO dto = trmteacherchargeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedtos),'ehr-TrmTeacherCharge-Create')")
    @ApiOperation(value = "根据培训讲师批量建立讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训讲师批量建立讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers/{trmtrainteacher_id}/trmteachercharges/batch")
    public ResponseEntity<Boolean> createBatchByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody List<TrmTeacherChargeDTO> trmteacherchargedtos) {
        List<TrmTeacherCharge> domainlist=trmteacherchargeMapping.toDomain(trmteacherchargedtos);
        for(TrmTeacherCharge domain:domainlist){
            domain.setTrmtrainteacherid(trmtrainteacher_id);
        }
        trmteacherchargeService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据培训讲师获取讲师收费记录草稿", tags = {"讲师收费记录" },  notes = "根据培训讲师获取讲师收费记录草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/trmtrainteachers/{trmtrainteacher_id}/trmteachercharges/getdraft")
    public ResponseEntity<TrmTeacherChargeDTO> getDraftByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id) {
        TrmTeacherCharge domain = new TrmTeacherCharge();
        domain.setTrmtrainteacherid(trmtrainteacher_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeMapping.toDto(trmteacherchargeService.getDraft(domain)));
    }

    @ApiOperation(value = "根据培训讲师检查讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训讲师检查讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers/{trmtrainteacher_id}/trmteachercharges/checkkey")
    public ResponseEntity<Boolean> checkKeyByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeService.checkKey(trmteacherchargeMapping.toDomain(trmteacherchargedto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTeacherCharge-Default-all')")
	@ApiOperation(value = "根据培训讲师获取DEFAULT", tags = {"讲师收费记录" } ,notes = "根据培训讲师获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainteachers/{trmtrainteacher_id}/trmteachercharges/fetchdefault")
	public ResponseEntity<List<TrmTeacherChargeDTO>> fetchTrmTeacherChargeDefaultByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id,TrmTeacherChargeSearchContext context) {
        context.setN_trmtrainteacherid_eq(trmtrainteacher_id);
        Page<TrmTeacherCharge> domains = trmteacherchargeService.searchDefault(context) ;
        List<TrmTeacherChargeDTO> list = trmteacherchargeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTeacherCharge-Default-all')")
	@ApiOperation(value = "根据培训讲师查询DEFAULT", tags = {"讲师收费记录" } ,notes = "根据培训讲师查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainteachers/{trmtrainteacher_id}/trmteachercharges/searchdefault")
	public ResponseEntity<Page<TrmTeacherChargeDTO>> searchTrmTeacherChargeDefaultByTrmTrainTeacher(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody TrmTeacherChargeSearchContext context) {
        context.setN_trmtrainteacherid_eq(trmtrainteacher_id);
        Page<TrmTeacherCharge> domains = trmteacherchargeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmteacherchargeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedto),'ehr-TrmTeacherCharge-Save')")
    @ApiOperation(value = "根据培训计划培训立项保存讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训计划培训立项保存讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/save")
    public ResponseEntity<Boolean> saveByTrmTrainPlanTrmTrainPlanterm(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
        TrmTeacherCharge domain = trmteacherchargeMapping.toDomain(trmteacherchargedto);
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedtos),'ehr-TrmTeacherCharge-Save')")
    @ApiOperation(value = "根据培训计划培训立项批量保存讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训计划培训立项批量保存讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/savebatch")
    public ResponseEntity<Boolean> saveBatchByTrmTrainPlanTrmTrainPlanterm(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody List<TrmTeacherChargeDTO> trmteacherchargedtos) {
        List<TrmTeacherCharge> domainlist=trmteacherchargeMapping.toDomain(trmteacherchargedtos);
        for(TrmTeacherCharge domain:domainlist){
             domain.setTrmtrainplantermid(trmtrainplanterm_id);
        }
        trmteacherchargeService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(returnObject.body),'ehr-TrmTeacherCharge-Get')")
    @ApiOperation(value = "根据培训计划培训立项获取讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训计划培训立项获取讲师收费记录")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/{trmteachercharge_id}")
    public ResponseEntity<TrmTeacherChargeDTO> getByTrmTrainPlanTrmTrainPlanterm(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @PathVariable("trmteachercharge_id") String trmteachercharge_id) {
        TrmTeacherCharge domain = trmteacherchargeService.get(trmteachercharge_id);
        TrmTeacherChargeDTO dto = trmteacherchargeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.get(#trmteachercharge_id),'ehr-TrmTeacherCharge-Remove')")
    @ApiOperation(value = "根据培训计划培训立项删除讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训计划培训立项删除讲师收费记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/{trmteachercharge_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByTrmTrainPlanTrmTrainPlanterm(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @PathVariable("trmteachercharge_id") String trmteachercharge_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeService.remove(trmteachercharge_id));
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.getTrmteacherchargeByIds(#ids),'ehr-TrmTeacherCharge-Remove')")
    @ApiOperation(value = "根据培训计划培训立项批量删除讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训计划培训立项批量删除讲师收费记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/batch")
    public ResponseEntity<Boolean> removeBatchByTrmTrainPlanTrmTrainPlanterm(@RequestBody List<String> ids) {
        trmteacherchargeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.get(#trmteachercharge_id),'ehr-TrmTeacherCharge-Update')")
    @ApiOperation(value = "根据培训计划培训立项更新讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训计划培训立项更新讲师收费记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/{trmteachercharge_id}")
    @Transactional
    public ResponseEntity<TrmTeacherChargeDTO> updateByTrmTrainPlanTrmTrainPlanterm(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @PathVariable("trmteachercharge_id") String trmteachercharge_id, @RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
        TrmTeacherCharge domain = trmteacherchargeMapping.toDomain(trmteacherchargedto);
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
        domain.setTrmteacherchargeid(trmteachercharge_id);
		trmteacherchargeService.update(domain);
        TrmTeacherChargeDTO dto = trmteacherchargeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.getTrmteacherchargeByEntities(this.trmteacherchargeMapping.toDomain(#trmteacherchargedtos)),'ehr-TrmTeacherCharge-Update')")
    @ApiOperation(value = "根据培训计划培训立项批量更新讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训计划培训立项批量更新讲师收费记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/batch")
    public ResponseEntity<Boolean> updateBatchByTrmTrainPlanTrmTrainPlanterm(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody List<TrmTeacherChargeDTO> trmteacherchargedtos) {
        List<TrmTeacherCharge> domainlist=trmteacherchargeMapping.toDomain(trmteacherchargedtos);
        for(TrmTeacherCharge domain:domainlist){
            domain.setTrmtrainplantermid(trmtrainplanterm_id);
        }
        trmteacherchargeService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedto),'ehr-TrmTeacherCharge-Create')")
    @ApiOperation(value = "根据培训计划培训立项建立讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训计划培训立项建立讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges")
    @Transactional
    public ResponseEntity<TrmTeacherChargeDTO> createByTrmTrainPlanTrmTrainPlanterm(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
        TrmTeacherCharge domain = trmteacherchargeMapping.toDomain(trmteacherchargedto);
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
		trmteacherchargeService.create(domain);
        TrmTeacherChargeDTO dto = trmteacherchargeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedtos),'ehr-TrmTeacherCharge-Create')")
    @ApiOperation(value = "根据培训计划培训立项批量建立讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训计划培训立项批量建立讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/batch")
    public ResponseEntity<Boolean> createBatchByTrmTrainPlanTrmTrainPlanterm(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody List<TrmTeacherChargeDTO> trmteacherchargedtos) {
        List<TrmTeacherCharge> domainlist=trmteacherchargeMapping.toDomain(trmteacherchargedtos);
        for(TrmTeacherCharge domain:domainlist){
            domain.setTrmtrainplantermid(trmtrainplanterm_id);
        }
        trmteacherchargeService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据培训计划培训立项获取讲师收费记录草稿", tags = {"讲师收费记录" },  notes = "根据培训计划培训立项获取讲师收费记录草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/getdraft")
    public ResponseEntity<TrmTeacherChargeDTO> getDraftByTrmTrainPlanTrmTrainPlanterm(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id) {
        TrmTeacherCharge domain = new TrmTeacherCharge();
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeMapping.toDto(trmteacherchargeService.getDraft(domain)));
    }

    @ApiOperation(value = "根据培训计划培训立项检查讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训计划培训立项检查讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/checkkey")
    public ResponseEntity<Boolean> checkKeyByTrmTrainPlanTrmTrainPlanterm(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeService.checkKey(trmteacherchargeMapping.toDomain(trmteacherchargedto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTeacherCharge-Default-all')")
	@ApiOperation(value = "根据培训计划培训立项获取DEFAULT", tags = {"讲师收费记录" } ,notes = "根据培训计划培训立项获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/fetchdefault")
	public ResponseEntity<List<TrmTeacherChargeDTO>> fetchTrmTeacherChargeDefaultByTrmTrainPlanTrmTrainPlanterm(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id,TrmTeacherChargeSearchContext context) {
        context.setN_trmtrainplantermid_eq(trmtrainplanterm_id);
        Page<TrmTeacherCharge> domains = trmteacherchargeService.searchDefault(context) ;
        List<TrmTeacherChargeDTO> list = trmteacherchargeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTeacherCharge-Default-all')")
	@ApiOperation(value = "根据培训计划培训立项查询DEFAULT", tags = {"讲师收费记录" } ,notes = "根据培训计划培训立项查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/searchdefault")
	public ResponseEntity<Page<TrmTeacherChargeDTO>> searchTrmTeacherChargeDefaultByTrmTrainPlanTrmTrainPlanterm(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTeacherChargeSearchContext context) {
        context.setN_trmtrainplantermid_eq(trmtrainplanterm_id);
        Page<TrmTeacherCharge> domains = trmteacherchargeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmteacherchargeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedto),'ehr-TrmTeacherCharge-Save')")
    @ApiOperation(value = "根据培训讲师培训立项保存讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训讲师培训立项保存讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/save")
    public ResponseEntity<Boolean> saveByTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
        TrmTeacherCharge domain = trmteacherchargeMapping.toDomain(trmteacherchargedto);
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedtos),'ehr-TrmTeacherCharge-Save')")
    @ApiOperation(value = "根据培训讲师培训立项批量保存讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训讲师培训立项批量保存讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/savebatch")
    public ResponseEntity<Boolean> saveBatchByTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody List<TrmTeacherChargeDTO> trmteacherchargedtos) {
        List<TrmTeacherCharge> domainlist=trmteacherchargeMapping.toDomain(trmteacherchargedtos);
        for(TrmTeacherCharge domain:domainlist){
             domain.setTrmtrainplantermid(trmtrainplanterm_id);
        }
        trmteacherchargeService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(returnObject.body),'ehr-TrmTeacherCharge-Get')")
    @ApiOperation(value = "根据培训讲师培训立项获取讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训讲师培训立项获取讲师收费记录")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/{trmteachercharge_id}")
    public ResponseEntity<TrmTeacherChargeDTO> getByTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @PathVariable("trmteachercharge_id") String trmteachercharge_id) {
        TrmTeacherCharge domain = trmteacherchargeService.get(trmteachercharge_id);
        TrmTeacherChargeDTO dto = trmteacherchargeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.get(#trmteachercharge_id),'ehr-TrmTeacherCharge-Remove')")
    @ApiOperation(value = "根据培训讲师培训立项删除讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训讲师培训立项删除讲师收费记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/{trmteachercharge_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @PathVariable("trmteachercharge_id") String trmteachercharge_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeService.remove(trmteachercharge_id));
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.getTrmteacherchargeByIds(#ids),'ehr-TrmTeacherCharge-Remove')")
    @ApiOperation(value = "根据培训讲师培训立项批量删除讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训讲师培训立项批量删除讲师收费记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/batch")
    public ResponseEntity<Boolean> removeBatchByTrmTrainTeacherTrmTrainPlanterm(@RequestBody List<String> ids) {
        trmteacherchargeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.get(#trmteachercharge_id),'ehr-TrmTeacherCharge-Update')")
    @ApiOperation(value = "根据培训讲师培训立项更新讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训讲师培训立项更新讲师收费记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/{trmteachercharge_id}")
    @Transactional
    public ResponseEntity<TrmTeacherChargeDTO> updateByTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @PathVariable("trmteachercharge_id") String trmteachercharge_id, @RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
        TrmTeacherCharge domain = trmteacherchargeMapping.toDomain(trmteacherchargedto);
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
        domain.setTrmteacherchargeid(trmteachercharge_id);
		trmteacherchargeService.update(domain);
        TrmTeacherChargeDTO dto = trmteacherchargeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.getTrmteacherchargeByEntities(this.trmteacherchargeMapping.toDomain(#trmteacherchargedtos)),'ehr-TrmTeacherCharge-Update')")
    @ApiOperation(value = "根据培训讲师培训立项批量更新讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训讲师培训立项批量更新讲师收费记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/batch")
    public ResponseEntity<Boolean> updateBatchByTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody List<TrmTeacherChargeDTO> trmteacherchargedtos) {
        List<TrmTeacherCharge> domainlist=trmteacherchargeMapping.toDomain(trmteacherchargedtos);
        for(TrmTeacherCharge domain:domainlist){
            domain.setTrmtrainplantermid(trmtrainplanterm_id);
        }
        trmteacherchargeService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedto),'ehr-TrmTeacherCharge-Create')")
    @ApiOperation(value = "根据培训讲师培训立项建立讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训讲师培训立项建立讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges")
    @Transactional
    public ResponseEntity<TrmTeacherChargeDTO> createByTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
        TrmTeacherCharge domain = trmteacherchargeMapping.toDomain(trmteacherchargedto);
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
		trmteacherchargeService.create(domain);
        TrmTeacherChargeDTO dto = trmteacherchargeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedtos),'ehr-TrmTeacherCharge-Create')")
    @ApiOperation(value = "根据培训讲师培训立项批量建立讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训讲师培训立项批量建立讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/batch")
    public ResponseEntity<Boolean> createBatchByTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody List<TrmTeacherChargeDTO> trmteacherchargedtos) {
        List<TrmTeacherCharge> domainlist=trmteacherchargeMapping.toDomain(trmteacherchargedtos);
        for(TrmTeacherCharge domain:domainlist){
            domain.setTrmtrainplantermid(trmtrainplanterm_id);
        }
        trmteacherchargeService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据培训讲师培训立项获取讲师收费记录草稿", tags = {"讲师收费记录" },  notes = "根据培训讲师培训立项获取讲师收费记录草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/getdraft")
    public ResponseEntity<TrmTeacherChargeDTO> getDraftByTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id) {
        TrmTeacherCharge domain = new TrmTeacherCharge();
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeMapping.toDto(trmteacherchargeService.getDraft(domain)));
    }

    @ApiOperation(value = "根据培训讲师培训立项检查讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训讲师培训立项检查讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/checkkey")
    public ResponseEntity<Boolean> checkKeyByTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeService.checkKey(trmteacherchargeMapping.toDomain(trmteacherchargedto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTeacherCharge-Default-all')")
	@ApiOperation(value = "根据培训讲师培训立项获取DEFAULT", tags = {"讲师收费记录" } ,notes = "根据培训讲师培训立项获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/fetchdefault")
	public ResponseEntity<List<TrmTeacherChargeDTO>> fetchTrmTeacherChargeDefaultByTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id,TrmTeacherChargeSearchContext context) {
        context.setN_trmtrainplantermid_eq(trmtrainplanterm_id);
        Page<TrmTeacherCharge> domains = trmteacherchargeService.searchDefault(context) ;
        List<TrmTeacherChargeDTO> list = trmteacherchargeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTeacherCharge-Default-all')")
	@ApiOperation(value = "根据培训讲师培训立项查询DEFAULT", tags = {"讲师收费记录" } ,notes = "根据培训讲师培训立项查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/searchdefault")
	public ResponseEntity<Page<TrmTeacherChargeDTO>> searchTrmTeacherChargeDefaultByTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTeacherChargeSearchContext context) {
        context.setN_trmtrainplantermid_eq(trmtrainplanterm_id);
        Page<TrmTeacherCharge> domains = trmteacherchargeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmteacherchargeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedto),'ehr-TrmTeacherCharge-Save')")
    @ApiOperation(value = "根据培训机构培训讲师保存讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训机构培训讲师保存讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmteachercharges/save")
    public ResponseEntity<Boolean> saveByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
        TrmTeacherCharge domain = trmteacherchargeMapping.toDomain(trmteacherchargedto);
        domain.setTrmtrainteacherid(trmtrainteacher_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedtos),'ehr-TrmTeacherCharge-Save')")
    @ApiOperation(value = "根据培训机构培训讲师批量保存讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训机构培训讲师批量保存讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmteachercharges/savebatch")
    public ResponseEntity<Boolean> saveBatchByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody List<TrmTeacherChargeDTO> trmteacherchargedtos) {
        List<TrmTeacherCharge> domainlist=trmteacherchargeMapping.toDomain(trmteacherchargedtos);
        for(TrmTeacherCharge domain:domainlist){
             domain.setTrmtrainteacherid(trmtrainteacher_id);
        }
        trmteacherchargeService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(returnObject.body),'ehr-TrmTeacherCharge-Get')")
    @ApiOperation(value = "根据培训机构培训讲师获取讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训机构培训讲师获取讲师收费记录")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmteachercharges/{trmteachercharge_id}")
    public ResponseEntity<TrmTeacherChargeDTO> getByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmteachercharge_id") String trmteachercharge_id) {
        TrmTeacherCharge domain = trmteacherchargeService.get(trmteachercharge_id);
        TrmTeacherChargeDTO dto = trmteacherchargeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.get(#trmteachercharge_id),'ehr-TrmTeacherCharge-Remove')")
    @ApiOperation(value = "根据培训机构培训讲师删除讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训机构培训讲师删除讲师收费记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmteachercharges/{trmteachercharge_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmteachercharge_id") String trmteachercharge_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeService.remove(trmteachercharge_id));
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.getTrmteacherchargeByIds(#ids),'ehr-TrmTeacherCharge-Remove')")
    @ApiOperation(value = "根据培训机构培训讲师批量删除讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训机构培训讲师批量删除讲师收费记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmteachercharges/batch")
    public ResponseEntity<Boolean> removeBatchByTrmTrainAgencyTrmTrainTeacher(@RequestBody List<String> ids) {
        trmteacherchargeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.get(#trmteachercharge_id),'ehr-TrmTeacherCharge-Update')")
    @ApiOperation(value = "根据培训机构培训讲师更新讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训机构培训讲师更新讲师收费记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmteachercharges/{trmteachercharge_id}")
    @Transactional
    public ResponseEntity<TrmTeacherChargeDTO> updateByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmteachercharge_id") String trmteachercharge_id, @RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
        TrmTeacherCharge domain = trmteacherchargeMapping.toDomain(trmteacherchargedto);
        domain.setTrmtrainteacherid(trmtrainteacher_id);
        domain.setTrmteacherchargeid(trmteachercharge_id);
		trmteacherchargeService.update(domain);
        TrmTeacherChargeDTO dto = trmteacherchargeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.getTrmteacherchargeByEntities(this.trmteacherchargeMapping.toDomain(#trmteacherchargedtos)),'ehr-TrmTeacherCharge-Update')")
    @ApiOperation(value = "根据培训机构培训讲师批量更新讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训机构培训讲师批量更新讲师收费记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmteachercharges/batch")
    public ResponseEntity<Boolean> updateBatchByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody List<TrmTeacherChargeDTO> trmteacherchargedtos) {
        List<TrmTeacherCharge> domainlist=trmteacherchargeMapping.toDomain(trmteacherchargedtos);
        for(TrmTeacherCharge domain:domainlist){
            domain.setTrmtrainteacherid(trmtrainteacher_id);
        }
        trmteacherchargeService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedto),'ehr-TrmTeacherCharge-Create')")
    @ApiOperation(value = "根据培训机构培训讲师建立讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训机构培训讲师建立讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmteachercharges")
    @Transactional
    public ResponseEntity<TrmTeacherChargeDTO> createByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
        TrmTeacherCharge domain = trmteacherchargeMapping.toDomain(trmteacherchargedto);
        domain.setTrmtrainteacherid(trmtrainteacher_id);
		trmteacherchargeService.create(domain);
        TrmTeacherChargeDTO dto = trmteacherchargeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedtos),'ehr-TrmTeacherCharge-Create')")
    @ApiOperation(value = "根据培训机构培训讲师批量建立讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训机构培训讲师批量建立讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmteachercharges/batch")
    public ResponseEntity<Boolean> createBatchByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody List<TrmTeacherChargeDTO> trmteacherchargedtos) {
        List<TrmTeacherCharge> domainlist=trmteacherchargeMapping.toDomain(trmteacherchargedtos);
        for(TrmTeacherCharge domain:domainlist){
            domain.setTrmtrainteacherid(trmtrainteacher_id);
        }
        trmteacherchargeService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据培训机构培训讲师获取讲师收费记录草稿", tags = {"讲师收费记录" },  notes = "根据培训机构培训讲师获取讲师收费记录草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmteachercharges/getdraft")
    public ResponseEntity<TrmTeacherChargeDTO> getDraftByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id) {
        TrmTeacherCharge domain = new TrmTeacherCharge();
        domain.setTrmtrainteacherid(trmtrainteacher_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeMapping.toDto(trmteacherchargeService.getDraft(domain)));
    }

    @ApiOperation(value = "根据培训机构培训讲师检查讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训机构培训讲师检查讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmteachercharges/checkkey")
    public ResponseEntity<Boolean> checkKeyByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeService.checkKey(trmteacherchargeMapping.toDomain(trmteacherchargedto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTeacherCharge-Default-all')")
	@ApiOperation(value = "根据培训机构培训讲师获取DEFAULT", tags = {"讲师收费记录" } ,notes = "根据培训机构培训讲师获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmteachercharges/fetchdefault")
	public ResponseEntity<List<TrmTeacherChargeDTO>> fetchTrmTeacherChargeDefaultByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id,TrmTeacherChargeSearchContext context) {
        context.setN_trmtrainteacherid_eq(trmtrainteacher_id);
        Page<TrmTeacherCharge> domains = trmteacherchargeService.searchDefault(context) ;
        List<TrmTeacherChargeDTO> list = trmteacherchargeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTeacherCharge-Default-all')")
	@ApiOperation(value = "根据培训机构培训讲师查询DEFAULT", tags = {"讲师收费记录" } ,notes = "根据培训机构培训讲师查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmteachercharges/searchdefault")
	public ResponseEntity<Page<TrmTeacherChargeDTO>> searchTrmTeacherChargeDefaultByTrmTrainAgencyTrmTrainTeacher(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody TrmTeacherChargeSearchContext context) {
        context.setN_trmtrainteacherid_eq(trmtrainteacher_id);
        Page<TrmTeacherCharge> domains = trmteacherchargeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmteacherchargeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedto),'ehr-TrmTeacherCharge-Save')")
    @ApiOperation(value = "根据人员信息培训计划培训立项保存讲师收费记录", tags = {"讲师收费记录" },  notes = "根据人员信息培训计划培训立项保存讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/save")
    public ResponseEntity<Boolean> saveByPimPersonTrmTrainPlanTrmTrainPlanterm(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
        TrmTeacherCharge domain = trmteacherchargeMapping.toDomain(trmteacherchargedto);
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedtos),'ehr-TrmTeacherCharge-Save')")
    @ApiOperation(value = "根据人员信息培训计划培训立项批量保存讲师收费记录", tags = {"讲师收费记录" },  notes = "根据人员信息培训计划培训立项批量保存讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPersonTrmTrainPlanTrmTrainPlanterm(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody List<TrmTeacherChargeDTO> trmteacherchargedtos) {
        List<TrmTeacherCharge> domainlist=trmteacherchargeMapping.toDomain(trmteacherchargedtos);
        for(TrmTeacherCharge domain:domainlist){
             domain.setTrmtrainplantermid(trmtrainplanterm_id);
        }
        trmteacherchargeService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(returnObject.body),'ehr-TrmTeacherCharge-Get')")
    @ApiOperation(value = "根据人员信息培训计划培训立项获取讲师收费记录", tags = {"讲师收费记录" },  notes = "根据人员信息培训计划培训立项获取讲师收费记录")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/{trmteachercharge_id}")
    public ResponseEntity<TrmTeacherChargeDTO> getByPimPersonTrmTrainPlanTrmTrainPlanterm(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @PathVariable("trmteachercharge_id") String trmteachercharge_id) {
        TrmTeacherCharge domain = trmteacherchargeService.get(trmteachercharge_id);
        TrmTeacherChargeDTO dto = trmteacherchargeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.get(#trmteachercharge_id),'ehr-TrmTeacherCharge-Remove')")
    @ApiOperation(value = "根据人员信息培训计划培训立项删除讲师收费记录", tags = {"讲师收费记录" },  notes = "根据人员信息培训计划培训立项删除讲师收费记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/{trmteachercharge_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPersonTrmTrainPlanTrmTrainPlanterm(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @PathVariable("trmteachercharge_id") String trmteachercharge_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeService.remove(trmteachercharge_id));
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.getTrmteacherchargeByIds(#ids),'ehr-TrmTeacherCharge-Remove')")
    @ApiOperation(value = "根据人员信息培训计划培训立项批量删除讲师收费记录", tags = {"讲师收费记录" },  notes = "根据人员信息培训计划培训立项批量删除讲师收费记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/batch")
    public ResponseEntity<Boolean> removeBatchByPimPersonTrmTrainPlanTrmTrainPlanterm(@RequestBody List<String> ids) {
        trmteacherchargeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.get(#trmteachercharge_id),'ehr-TrmTeacherCharge-Update')")
    @ApiOperation(value = "根据人员信息培训计划培训立项更新讲师收费记录", tags = {"讲师收费记录" },  notes = "根据人员信息培训计划培训立项更新讲师收费记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/{trmteachercharge_id}")
    @Transactional
    public ResponseEntity<TrmTeacherChargeDTO> updateByPimPersonTrmTrainPlanTrmTrainPlanterm(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @PathVariable("trmteachercharge_id") String trmteachercharge_id, @RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
        TrmTeacherCharge domain = trmteacherchargeMapping.toDomain(trmteacherchargedto);
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
        domain.setTrmteacherchargeid(trmteachercharge_id);
		trmteacherchargeService.update(domain);
        TrmTeacherChargeDTO dto = trmteacherchargeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.getTrmteacherchargeByEntities(this.trmteacherchargeMapping.toDomain(#trmteacherchargedtos)),'ehr-TrmTeacherCharge-Update')")
    @ApiOperation(value = "根据人员信息培训计划培训立项批量更新讲师收费记录", tags = {"讲师收费记录" },  notes = "根据人员信息培训计划培训立项批量更新讲师收费记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/batch")
    public ResponseEntity<Boolean> updateBatchByPimPersonTrmTrainPlanTrmTrainPlanterm(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody List<TrmTeacherChargeDTO> trmteacherchargedtos) {
        List<TrmTeacherCharge> domainlist=trmteacherchargeMapping.toDomain(trmteacherchargedtos);
        for(TrmTeacherCharge domain:domainlist){
            domain.setTrmtrainplantermid(trmtrainplanterm_id);
        }
        trmteacherchargeService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedto),'ehr-TrmTeacherCharge-Create')")
    @ApiOperation(value = "根据人员信息培训计划培训立项建立讲师收费记录", tags = {"讲师收费记录" },  notes = "根据人员信息培训计划培训立项建立讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges")
    @Transactional
    public ResponseEntity<TrmTeacherChargeDTO> createByPimPersonTrmTrainPlanTrmTrainPlanterm(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
        TrmTeacherCharge domain = trmteacherchargeMapping.toDomain(trmteacherchargedto);
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
		trmteacherchargeService.create(domain);
        TrmTeacherChargeDTO dto = trmteacherchargeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedtos),'ehr-TrmTeacherCharge-Create')")
    @ApiOperation(value = "根据人员信息培训计划培训立项批量建立讲师收费记录", tags = {"讲师收费记录" },  notes = "根据人员信息培训计划培训立项批量建立讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/batch")
    public ResponseEntity<Boolean> createBatchByPimPersonTrmTrainPlanTrmTrainPlanterm(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody List<TrmTeacherChargeDTO> trmteacherchargedtos) {
        List<TrmTeacherCharge> domainlist=trmteacherchargeMapping.toDomain(trmteacherchargedtos);
        for(TrmTeacherCharge domain:domainlist){
            domain.setTrmtrainplantermid(trmtrainplanterm_id);
        }
        trmteacherchargeService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息培训计划培训立项获取讲师收费记录草稿", tags = {"讲师收费记录" },  notes = "根据人员信息培训计划培训立项获取讲师收费记录草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/getdraft")
    public ResponseEntity<TrmTeacherChargeDTO> getDraftByPimPersonTrmTrainPlanTrmTrainPlanterm(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id) {
        TrmTeacherCharge domain = new TrmTeacherCharge();
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeMapping.toDto(trmteacherchargeService.getDraft(domain)));
    }

    @ApiOperation(value = "根据人员信息培训计划培训立项检查讲师收费记录", tags = {"讲师收费记录" },  notes = "根据人员信息培训计划培训立项检查讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPersonTrmTrainPlanTrmTrainPlanterm(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeService.checkKey(trmteacherchargeMapping.toDomain(trmteacherchargedto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTeacherCharge-Default-all')")
	@ApiOperation(value = "根据人员信息培训计划培训立项获取DEFAULT", tags = {"讲师收费记录" } ,notes = "根据人员信息培训计划培训立项获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/fetchdefault")
	public ResponseEntity<List<TrmTeacherChargeDTO>> fetchTrmTeacherChargeDefaultByPimPersonTrmTrainPlanTrmTrainPlanterm(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id,TrmTeacherChargeSearchContext context) {
        context.setN_trmtrainplantermid_eq(trmtrainplanterm_id);
        Page<TrmTeacherCharge> domains = trmteacherchargeService.searchDefault(context) ;
        List<TrmTeacherChargeDTO> list = trmteacherchargeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTeacherCharge-Default-all')")
	@ApiOperation(value = "根据人员信息培训计划培训立项查询DEFAULT", tags = {"讲师收费记录" } ,notes = "根据人员信息培训计划培训立项查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/trmtrainplans/{trmtrainplan_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/searchdefault")
	public ResponseEntity<Page<TrmTeacherChargeDTO>> searchTrmTeacherChargeDefaultByPimPersonTrmTrainPlanTrmTrainPlanterm(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainplan_id") String trmtrainplan_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTeacherChargeSearchContext context) {
        context.setN_trmtrainplantermid_eq(trmtrainplanterm_id);
        Page<TrmTeacherCharge> domains = trmteacherchargeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmteacherchargeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedto),'ehr-TrmTeacherCharge-Save')")
    @ApiOperation(value = "根据培训机构培训讲师培训立项保存讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训机构培训讲师培训立项保存讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/save")
    public ResponseEntity<Boolean> saveByTrmTrainAgencyTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
        TrmTeacherCharge domain = trmteacherchargeMapping.toDomain(trmteacherchargedto);
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedtos),'ehr-TrmTeacherCharge-Save')")
    @ApiOperation(value = "根据培训机构培训讲师培训立项批量保存讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训机构培训讲师培训立项批量保存讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/savebatch")
    public ResponseEntity<Boolean> saveBatchByTrmTrainAgencyTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody List<TrmTeacherChargeDTO> trmteacherchargedtos) {
        List<TrmTeacherCharge> domainlist=trmteacherchargeMapping.toDomain(trmteacherchargedtos);
        for(TrmTeacherCharge domain:domainlist){
             domain.setTrmtrainplantermid(trmtrainplanterm_id);
        }
        trmteacherchargeService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(returnObject.body),'ehr-TrmTeacherCharge-Get')")
    @ApiOperation(value = "根据培训机构培训讲师培训立项获取讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训机构培训讲师培训立项获取讲师收费记录")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/{trmteachercharge_id}")
    public ResponseEntity<TrmTeacherChargeDTO> getByTrmTrainAgencyTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @PathVariable("trmteachercharge_id") String trmteachercharge_id) {
        TrmTeacherCharge domain = trmteacherchargeService.get(trmteachercharge_id);
        TrmTeacherChargeDTO dto = trmteacherchargeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.get(#trmteachercharge_id),'ehr-TrmTeacherCharge-Remove')")
    @ApiOperation(value = "根据培训机构培训讲师培训立项删除讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训机构培训讲师培训立项删除讲师收费记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/{trmteachercharge_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByTrmTrainAgencyTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @PathVariable("trmteachercharge_id") String trmteachercharge_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeService.remove(trmteachercharge_id));
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.getTrmteacherchargeByIds(#ids),'ehr-TrmTeacherCharge-Remove')")
    @ApiOperation(value = "根据培训机构培训讲师培训立项批量删除讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训机构培训讲师培训立项批量删除讲师收费记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/batch")
    public ResponseEntity<Boolean> removeBatchByTrmTrainAgencyTrmTrainTeacherTrmTrainPlanterm(@RequestBody List<String> ids) {
        trmteacherchargeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.get(#trmteachercharge_id),'ehr-TrmTeacherCharge-Update')")
    @ApiOperation(value = "根据培训机构培训讲师培训立项更新讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训机构培训讲师培训立项更新讲师收费记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/{trmteachercharge_id}")
    @Transactional
    public ResponseEntity<TrmTeacherChargeDTO> updateByTrmTrainAgencyTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @PathVariable("trmteachercharge_id") String trmteachercharge_id, @RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
        TrmTeacherCharge domain = trmteacherchargeMapping.toDomain(trmteacherchargedto);
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
        domain.setTrmteacherchargeid(trmteachercharge_id);
		trmteacherchargeService.update(domain);
        TrmTeacherChargeDTO dto = trmteacherchargeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.getTrmteacherchargeByEntities(this.trmteacherchargeMapping.toDomain(#trmteacherchargedtos)),'ehr-TrmTeacherCharge-Update')")
    @ApiOperation(value = "根据培训机构培训讲师培训立项批量更新讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训机构培训讲师培训立项批量更新讲师收费记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/batch")
    public ResponseEntity<Boolean> updateBatchByTrmTrainAgencyTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody List<TrmTeacherChargeDTO> trmteacherchargedtos) {
        List<TrmTeacherCharge> domainlist=trmteacherchargeMapping.toDomain(trmteacherchargedtos);
        for(TrmTeacherCharge domain:domainlist){
            domain.setTrmtrainplantermid(trmtrainplanterm_id);
        }
        trmteacherchargeService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedto),'ehr-TrmTeacherCharge-Create')")
    @ApiOperation(value = "根据培训机构培训讲师培训立项建立讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训机构培训讲师培训立项建立讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges")
    @Transactional
    public ResponseEntity<TrmTeacherChargeDTO> createByTrmTrainAgencyTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
        TrmTeacherCharge domain = trmteacherchargeMapping.toDomain(trmteacherchargedto);
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
		trmteacherchargeService.create(domain);
        TrmTeacherChargeDTO dto = trmteacherchargeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedtos),'ehr-TrmTeacherCharge-Create')")
    @ApiOperation(value = "根据培训机构培训讲师培训立项批量建立讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训机构培训讲师培训立项批量建立讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/batch")
    public ResponseEntity<Boolean> createBatchByTrmTrainAgencyTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody List<TrmTeacherChargeDTO> trmteacherchargedtos) {
        List<TrmTeacherCharge> domainlist=trmteacherchargeMapping.toDomain(trmteacherchargedtos);
        for(TrmTeacherCharge domain:domainlist){
            domain.setTrmtrainplantermid(trmtrainplanterm_id);
        }
        trmteacherchargeService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据培训机构培训讲师培训立项获取讲师收费记录草稿", tags = {"讲师收费记录" },  notes = "根据培训机构培训讲师培训立项获取讲师收费记录草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/getdraft")
    public ResponseEntity<TrmTeacherChargeDTO> getDraftByTrmTrainAgencyTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id) {
        TrmTeacherCharge domain = new TrmTeacherCharge();
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeMapping.toDto(trmteacherchargeService.getDraft(domain)));
    }

    @ApiOperation(value = "根据培训机构培训讲师培训立项检查讲师收费记录", tags = {"讲师收费记录" },  notes = "根据培训机构培训讲师培训立项检查讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/checkkey")
    public ResponseEntity<Boolean> checkKeyByTrmTrainAgencyTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeService.checkKey(trmteacherchargeMapping.toDomain(trmteacherchargedto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTeacherCharge-Default-all')")
	@ApiOperation(value = "根据培训机构培训讲师培训立项获取DEFAULT", tags = {"讲师收费记录" } ,notes = "根据培训机构培训讲师培训立项获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/fetchdefault")
	public ResponseEntity<List<TrmTeacherChargeDTO>> fetchTrmTeacherChargeDefaultByTrmTrainAgencyTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id,TrmTeacherChargeSearchContext context) {
        context.setN_trmtrainplantermid_eq(trmtrainplanterm_id);
        Page<TrmTeacherCharge> domains = trmteacherchargeService.searchDefault(context) ;
        List<TrmTeacherChargeDTO> list = trmteacherchargeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTeacherCharge-Default-all')")
	@ApiOperation(value = "根据培训机构培训讲师培训立项查询DEFAULT", tags = {"讲师收费记录" } ,notes = "根据培训机构培训讲师培训立项查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainagencies/{trmtrainagency_id}/trmtrainteachers/{trmtrainteacher_id}/trmtrainplanterms/{trmtrainplanterm_id}/trmteachercharges/searchdefault")
	public ResponseEntity<Page<TrmTeacherChargeDTO>> searchTrmTeacherChargeDefaultByTrmTrainAgencyTrmTrainTeacherTrmTrainPlanterm(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TrmTeacherChargeSearchContext context) {
        context.setN_trmtrainplantermid_eq(trmtrainplanterm_id);
        Page<TrmTeacherCharge> domains = trmteacherchargeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmteacherchargeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

