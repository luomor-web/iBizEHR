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
import cn.ibizlab.ehr.core.trm.domain.TrmDemdeftion;
import cn.ibizlab.ehr.core.trm.service.ITrmDemdeftionService;
import cn.ibizlab.ehr.core.trm.filter.TrmDemdeftionSearchContext;

@Slf4j
@Api(tags = {"培训需求汇总" })
@RestController("WebApi-trmdemdeftion")
@RequestMapping("")
public class TrmDemdeftionResource {

    @Autowired
    public ITrmDemdeftionService trmdemdeftionService;

    @Autowired
    @Lazy
    public TrmDemdeftionMapping trmdemdeftionMapping;

    @ApiOperation(value = "获取培训需求汇总草稿", tags = {"培训需求汇总" },  notes = "获取培训需求汇总草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmdemdeftions/getdraft")
    public ResponseEntity<TrmDemdeftionDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmdemdeftionMapping.toDto(trmdemdeftionService.getDraft(new TrmDemdeftion())));
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionMapping.toDomain(#trmdemdeftiondto),'ehr-TrmDemdeftion-Create')")
    @ApiOperation(value = "新建培训需求汇总", tags = {"培训需求汇总" },  notes = "新建培训需求汇总")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdemdeftions")
    @Transactional
    public ResponseEntity<TrmDemdeftionDTO> create(@RequestBody TrmDemdeftionDTO trmdemdeftiondto) {
        TrmDemdeftion domain = trmdemdeftionMapping.toDomain(trmdemdeftiondto);
		trmdemdeftionService.create(domain);
        TrmDemdeftionDTO dto = trmdemdeftionMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionMapping.toDomain(#trmdemdeftiondtos),'ehr-TrmDemdeftion-Create')")
    @ApiOperation(value = "批量新建培训需求汇总", tags = {"培训需求汇总" },  notes = "批量新建培训需求汇总")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdemdeftions/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmDemdeftionDTO> trmdemdeftiondtos) {
        trmdemdeftionService.createBatch(trmdemdeftionMapping.toDomain(trmdemdeftiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionService.get(#trmdemdeftion_id),'ehr-TrmDemdeftion-Update')")
    @ApiOperation(value = "更新培训需求汇总", tags = {"培训需求汇总" },  notes = "更新培训需求汇总")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmdemdeftions/{trmdemdeftion_id}")
    @Transactional
    public ResponseEntity<TrmDemdeftionDTO> update(@PathVariable("trmdemdeftion_id") String trmdemdeftion_id, @RequestBody TrmDemdeftionDTO trmdemdeftiondto) {
		TrmDemdeftion domain  = trmdemdeftionMapping.toDomain(trmdemdeftiondto);
        domain .setTrmdemdeftionid(trmdemdeftion_id);
		trmdemdeftionService.update(domain );
		TrmDemdeftionDTO dto = trmdemdeftionMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionService.getTrmdemdeftionByEntities(this.trmdemdeftionMapping.toDomain(#trmdemdeftiondtos)),'ehr-TrmDemdeftion-Update')")
    @ApiOperation(value = "批量更新培训需求汇总", tags = {"培训需求汇总" },  notes = "批量更新培训需求汇总")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmdemdeftions/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmDemdeftionDTO> trmdemdeftiondtos) {
        trmdemdeftionService.updateBatch(trmdemdeftionMapping.toDomain(trmdemdeftiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionService.get(#trmdemdeftion_id),'ehr-TrmDemdeftion-Remove')")
    @ApiOperation(value = "删除培训需求汇总", tags = {"培训需求汇总" },  notes = "删除培训需求汇总")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmdemdeftions/{trmdemdeftion_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmdemdeftion_id") String trmdemdeftion_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmdemdeftionService.remove(trmdemdeftion_id));
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionService.getTrmdemdeftionByIds(#ids),'ehr-TrmDemdeftion-Remove')")
    @ApiOperation(value = "批量删除培训需求汇总", tags = {"培训需求汇总" },  notes = "批量删除培训需求汇总")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmdemdeftions/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmdemdeftionService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionMapping.toDomain(#trmdemdeftiondto),'ehr-TrmDemdeftion-Save')")
    @ApiOperation(value = "保存培训需求汇总", tags = {"培训需求汇总" },  notes = "保存培训需求汇总")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdemdeftions/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmDemdeftionDTO trmdemdeftiondto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmdemdeftionService.save(trmdemdeftionMapping.toDomain(trmdemdeftiondto)));
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionMapping.toDomain(#trmdemdeftiondtos),'ehr-TrmDemdeftion-Save')")
    @ApiOperation(value = "批量保存培训需求汇总", tags = {"培训需求汇总" },  notes = "批量保存培训需求汇总")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdemdeftions/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmDemdeftionDTO> trmdemdeftiondtos) {
        trmdemdeftionService.saveBatch(trmdemdeftionMapping.toDomain(trmdemdeftiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查培训需求汇总", tags = {"培训需求汇总" },  notes = "检查培训需求汇总")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdemdeftions/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmDemdeftionDTO trmdemdeftiondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmdemdeftionService.checkKey(trmdemdeftionMapping.toDomain(trmdemdeftiondto)));
    }

    @PostAuthorize("hasPermission(this.trmdemdeftionMapping.toDomain(returnObject.body),'ehr-TrmDemdeftion-Get')")
    @ApiOperation(value = "获取培训需求汇总", tags = {"培训需求汇总" },  notes = "获取培训需求汇总")
	@RequestMapping(method = RequestMethod.GET, value = "/trmdemdeftions/{trmdemdeftion_id}")
    public ResponseEntity<TrmDemdeftionDTO> get(@PathVariable("trmdemdeftion_id") String trmdemdeftion_id) {
        TrmDemdeftion domain = trmdemdeftionService.get(trmdemdeftion_id);
        TrmDemdeftionDTO dto = trmdemdeftionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmDemdeftion-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"培训需求汇总" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmdemdeftions/fetchdefault")
	public ResponseEntity<List<TrmDemdeftionDTO>> fetchDefault(TrmDemdeftionSearchContext context) {
        Page<TrmDemdeftion> domains = trmdemdeftionService.searchDefault(context) ;
        List<TrmDemdeftionDTO> list = trmdemdeftionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmDemdeftion-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"培训需求汇总" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmdemdeftions/searchdefault")
	public ResponseEntity<Page<TrmDemdeftionDTO>> searchDefault(@RequestBody TrmDemdeftionSearchContext context) {
        Page<TrmDemdeftion> domains = trmdemdeftionService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmdemdeftionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据培训需求填报获取培训需求汇总草稿", tags = {"培训需求汇总" },  notes = "根据培训需求填报获取培训需求汇总草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/getdraft")
    public ResponseEntity<TrmDemdeftionDTO> getDraftByTrmTrainFillin(@PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
        TrmDemdeftion domain = new TrmDemdeftion();
        domain.setTrmtrainfillinid(trmtrainfillin_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmdemdeftionMapping.toDto(trmdemdeftionService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionMapping.toDomain(#trmdemdeftiondto),'ehr-TrmDemdeftion-Create')")
    @ApiOperation(value = "根据培训需求填报建立培训需求汇总", tags = {"培训需求汇总" },  notes = "根据培训需求填报建立培训需求汇总")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions")
    @Transactional
    public ResponseEntity<TrmDemdeftionDTO> createByTrmTrainFillin(@PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody TrmDemdeftionDTO trmdemdeftiondto) {
        TrmDemdeftion domain = trmdemdeftionMapping.toDomain(trmdemdeftiondto);
        domain.setTrmtrainfillinid(trmtrainfillin_id);
		trmdemdeftionService.create(domain);
        TrmDemdeftionDTO dto = trmdemdeftionMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionMapping.toDomain(#trmdemdeftiondtos),'ehr-TrmDemdeftion-Create')")
    @ApiOperation(value = "根据培训需求填报批量建立培训需求汇总", tags = {"培训需求汇总" },  notes = "根据培训需求填报批量建立培训需求汇总")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/batch")
    public ResponseEntity<Boolean> createBatchByTrmTrainFillin(@PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody List<TrmDemdeftionDTO> trmdemdeftiondtos) {
        List<TrmDemdeftion> domainlist=trmdemdeftionMapping.toDomain(trmdemdeftiondtos);
        for(TrmDemdeftion domain:domainlist){
            domain.setTrmtrainfillinid(trmtrainfillin_id);
        }
        trmdemdeftionService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionService.get(#trmdemdeftion_id),'ehr-TrmDemdeftion-Update')")
    @ApiOperation(value = "根据培训需求填报更新培训需求汇总", tags = {"培训需求汇总" },  notes = "根据培训需求填报更新培训需求汇总")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/{trmdemdeftion_id}")
    @Transactional
    public ResponseEntity<TrmDemdeftionDTO> updateByTrmTrainFillin(@PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @PathVariable("trmdemdeftion_id") String trmdemdeftion_id, @RequestBody TrmDemdeftionDTO trmdemdeftiondto) {
        TrmDemdeftion domain = trmdemdeftionMapping.toDomain(trmdemdeftiondto);
        domain.setTrmtrainfillinid(trmtrainfillin_id);
        domain.setTrmdemdeftionid(trmdemdeftion_id);
		trmdemdeftionService.update(domain);
        TrmDemdeftionDTO dto = trmdemdeftionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionService.getTrmdemdeftionByEntities(this.trmdemdeftionMapping.toDomain(#trmdemdeftiondtos)),'ehr-TrmDemdeftion-Update')")
    @ApiOperation(value = "根据培训需求填报批量更新培训需求汇总", tags = {"培训需求汇总" },  notes = "根据培训需求填报批量更新培训需求汇总")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/batch")
    public ResponseEntity<Boolean> updateBatchByTrmTrainFillin(@PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody List<TrmDemdeftionDTO> trmdemdeftiondtos) {
        List<TrmDemdeftion> domainlist=trmdemdeftionMapping.toDomain(trmdemdeftiondtos);
        for(TrmDemdeftion domain:domainlist){
            domain.setTrmtrainfillinid(trmtrainfillin_id);
        }
        trmdemdeftionService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionService.get(#trmdemdeftion_id),'ehr-TrmDemdeftion-Remove')")
    @ApiOperation(value = "根据培训需求填报删除培训需求汇总", tags = {"培训需求汇总" },  notes = "根据培训需求填报删除培训需求汇总")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/{trmdemdeftion_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByTrmTrainFillin(@PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @PathVariable("trmdemdeftion_id") String trmdemdeftion_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmdemdeftionService.remove(trmdemdeftion_id));
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionService.getTrmdemdeftionByIds(#ids),'ehr-TrmDemdeftion-Remove')")
    @ApiOperation(value = "根据培训需求填报批量删除培训需求汇总", tags = {"培训需求汇总" },  notes = "根据培训需求填报批量删除培训需求汇总")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/batch")
    public ResponseEntity<Boolean> removeBatchByTrmTrainFillin(@RequestBody List<String> ids) {
        trmdemdeftionService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionMapping.toDomain(#trmdemdeftiondto),'ehr-TrmDemdeftion-Save')")
    @ApiOperation(value = "根据培训需求填报保存培训需求汇总", tags = {"培训需求汇总" },  notes = "根据培训需求填报保存培训需求汇总")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/save")
    public ResponseEntity<Boolean> saveByTrmTrainFillin(@PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody TrmDemdeftionDTO trmdemdeftiondto) {
        TrmDemdeftion domain = trmdemdeftionMapping.toDomain(trmdemdeftiondto);
        domain.setTrmtrainfillinid(trmtrainfillin_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmdemdeftionService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionMapping.toDomain(#trmdemdeftiondtos),'ehr-TrmDemdeftion-Save')")
    @ApiOperation(value = "根据培训需求填报批量保存培训需求汇总", tags = {"培训需求汇总" },  notes = "根据培训需求填报批量保存培训需求汇总")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/savebatch")
    public ResponseEntity<Boolean> saveBatchByTrmTrainFillin(@PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody List<TrmDemdeftionDTO> trmdemdeftiondtos) {
        List<TrmDemdeftion> domainlist=trmdemdeftionMapping.toDomain(trmdemdeftiondtos);
        for(TrmDemdeftion domain:domainlist){
             domain.setTrmtrainfillinid(trmtrainfillin_id);
        }
        trmdemdeftionService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据培训需求填报检查培训需求汇总", tags = {"培训需求汇总" },  notes = "根据培训需求填报检查培训需求汇总")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/checkkey")
    public ResponseEntity<Boolean> checkKeyByTrmTrainFillin(@PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody TrmDemdeftionDTO trmdemdeftiondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmdemdeftionService.checkKey(trmdemdeftionMapping.toDomain(trmdemdeftiondto)));
    }

    @PostAuthorize("hasPermission(this.trmdemdeftionMapping.toDomain(returnObject.body),'ehr-TrmDemdeftion-Get')")
    @ApiOperation(value = "根据培训需求填报获取培训需求汇总", tags = {"培训需求汇总" },  notes = "根据培训需求填报获取培训需求汇总")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/{trmdemdeftion_id}")
    public ResponseEntity<TrmDemdeftionDTO> getByTrmTrainFillin(@PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @PathVariable("trmdemdeftion_id") String trmdemdeftion_id) {
        TrmDemdeftion domain = trmdemdeftionService.get(trmdemdeftion_id);
        TrmDemdeftionDTO dto = trmdemdeftionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmDemdeftion-Default-all')")
	@ApiOperation(value = "根据培训需求填报获取DEFAULT", tags = {"培训需求汇总" } ,notes = "根据培训需求填报获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/fetchdefault")
	public ResponseEntity<List<TrmDemdeftionDTO>> fetchTrmDemdeftionDefaultByTrmTrainFillin(@PathVariable("trmtrainfillin_id") String trmtrainfillin_id,TrmDemdeftionSearchContext context) {
        context.setN_trmtrainfillinid_eq(trmtrainfillin_id);
        Page<TrmDemdeftion> domains = trmdemdeftionService.searchDefault(context) ;
        List<TrmDemdeftionDTO> list = trmdemdeftionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmDemdeftion-Default-all')")
	@ApiOperation(value = "根据培训需求填报查询DEFAULT", tags = {"培训需求汇总" } ,notes = "根据培训需求填报查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/searchdefault")
	public ResponseEntity<Page<TrmDemdeftionDTO>> searchTrmDemdeftionDefaultByTrmTrainFillin(@PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody TrmDemdeftionSearchContext context) {
        context.setN_trmtrainfillinid_eq(trmtrainfillin_id);
        Page<TrmDemdeftion> domains = trmdemdeftionService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmdemdeftionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据部门管理培训需求填报获取培训需求汇总草稿", tags = {"培训需求汇总" },  notes = "根据部门管理培训需求填报获取培训需求汇总草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/getdraft")
    public ResponseEntity<TrmDemdeftionDTO> getDraftByOrmOrgsectorTrmTrainFillin(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
        TrmDemdeftion domain = new TrmDemdeftion();
        domain.setTrmtrainfillinid(trmtrainfillin_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmdemdeftionMapping.toDto(trmdemdeftionService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionMapping.toDomain(#trmdemdeftiondto),'ehr-TrmDemdeftion-Create')")
    @ApiOperation(value = "根据部门管理培训需求填报建立培训需求汇总", tags = {"培训需求汇总" },  notes = "根据部门管理培训需求填报建立培训需求汇总")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions")
    @Transactional
    public ResponseEntity<TrmDemdeftionDTO> createByOrmOrgsectorTrmTrainFillin(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody TrmDemdeftionDTO trmdemdeftiondto) {
        TrmDemdeftion domain = trmdemdeftionMapping.toDomain(trmdemdeftiondto);
        domain.setTrmtrainfillinid(trmtrainfillin_id);
		trmdemdeftionService.create(domain);
        TrmDemdeftionDTO dto = trmdemdeftionMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionMapping.toDomain(#trmdemdeftiondtos),'ehr-TrmDemdeftion-Create')")
    @ApiOperation(value = "根据部门管理培训需求填报批量建立培训需求汇总", tags = {"培训需求汇总" },  notes = "根据部门管理培训需求填报批量建立培训需求汇总")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgsectorTrmTrainFillin(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody List<TrmDemdeftionDTO> trmdemdeftiondtos) {
        List<TrmDemdeftion> domainlist=trmdemdeftionMapping.toDomain(trmdemdeftiondtos);
        for(TrmDemdeftion domain:domainlist){
            domain.setTrmtrainfillinid(trmtrainfillin_id);
        }
        trmdemdeftionService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionService.get(#trmdemdeftion_id),'ehr-TrmDemdeftion-Update')")
    @ApiOperation(value = "根据部门管理培训需求填报更新培训需求汇总", tags = {"培训需求汇总" },  notes = "根据部门管理培训需求填报更新培训需求汇总")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/{trmdemdeftion_id}")
    @Transactional
    public ResponseEntity<TrmDemdeftionDTO> updateByOrmOrgsectorTrmTrainFillin(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @PathVariable("trmdemdeftion_id") String trmdemdeftion_id, @RequestBody TrmDemdeftionDTO trmdemdeftiondto) {
        TrmDemdeftion domain = trmdemdeftionMapping.toDomain(trmdemdeftiondto);
        domain.setTrmtrainfillinid(trmtrainfillin_id);
        domain.setTrmdemdeftionid(trmdemdeftion_id);
		trmdemdeftionService.update(domain);
        TrmDemdeftionDTO dto = trmdemdeftionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionService.getTrmdemdeftionByEntities(this.trmdemdeftionMapping.toDomain(#trmdemdeftiondtos)),'ehr-TrmDemdeftion-Update')")
    @ApiOperation(value = "根据部门管理培训需求填报批量更新培训需求汇总", tags = {"培训需求汇总" },  notes = "根据部门管理培训需求填报批量更新培训需求汇总")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgsectorTrmTrainFillin(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody List<TrmDemdeftionDTO> trmdemdeftiondtos) {
        List<TrmDemdeftion> domainlist=trmdemdeftionMapping.toDomain(trmdemdeftiondtos);
        for(TrmDemdeftion domain:domainlist){
            domain.setTrmtrainfillinid(trmtrainfillin_id);
        }
        trmdemdeftionService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionService.get(#trmdemdeftion_id),'ehr-TrmDemdeftion-Remove')")
    @ApiOperation(value = "根据部门管理培训需求填报删除培训需求汇总", tags = {"培训需求汇总" },  notes = "根据部门管理培训需求填报删除培训需求汇总")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/{trmdemdeftion_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgsectorTrmTrainFillin(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @PathVariable("trmdemdeftion_id") String trmdemdeftion_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmdemdeftionService.remove(trmdemdeftion_id));
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionService.getTrmdemdeftionByIds(#ids),'ehr-TrmDemdeftion-Remove')")
    @ApiOperation(value = "根据部门管理培训需求填报批量删除培训需求汇总", tags = {"培训需求汇总" },  notes = "根据部门管理培训需求填报批量删除培训需求汇总")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgsectorTrmTrainFillin(@RequestBody List<String> ids) {
        trmdemdeftionService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionMapping.toDomain(#trmdemdeftiondto),'ehr-TrmDemdeftion-Save')")
    @ApiOperation(value = "根据部门管理培训需求填报保存培训需求汇总", tags = {"培训需求汇总" },  notes = "根据部门管理培训需求填报保存培训需求汇总")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/save")
    public ResponseEntity<Boolean> saveByOrmOrgsectorTrmTrainFillin(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody TrmDemdeftionDTO trmdemdeftiondto) {
        TrmDemdeftion domain = trmdemdeftionMapping.toDomain(trmdemdeftiondto);
        domain.setTrmtrainfillinid(trmtrainfillin_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmdemdeftionService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionMapping.toDomain(#trmdemdeftiondtos),'ehr-TrmDemdeftion-Save')")
    @ApiOperation(value = "根据部门管理培训需求填报批量保存培训需求汇总", tags = {"培训需求汇总" },  notes = "根据部门管理培训需求填报批量保存培训需求汇总")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgsectorTrmTrainFillin(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody List<TrmDemdeftionDTO> trmdemdeftiondtos) {
        List<TrmDemdeftion> domainlist=trmdemdeftionMapping.toDomain(trmdemdeftiondtos);
        for(TrmDemdeftion domain:domainlist){
             domain.setTrmtrainfillinid(trmtrainfillin_id);
        }
        trmdemdeftionService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据部门管理培训需求填报检查培训需求汇总", tags = {"培训需求汇总" },  notes = "根据部门管理培训需求填报检查培训需求汇总")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgsectorTrmTrainFillin(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody TrmDemdeftionDTO trmdemdeftiondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmdemdeftionService.checkKey(trmdemdeftionMapping.toDomain(trmdemdeftiondto)));
    }

    @PostAuthorize("hasPermission(this.trmdemdeftionMapping.toDomain(returnObject.body),'ehr-TrmDemdeftion-Get')")
    @ApiOperation(value = "根据部门管理培训需求填报获取培训需求汇总", tags = {"培训需求汇总" },  notes = "根据部门管理培训需求填报获取培训需求汇总")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/{trmdemdeftion_id}")
    public ResponseEntity<TrmDemdeftionDTO> getByOrmOrgsectorTrmTrainFillin(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @PathVariable("trmdemdeftion_id") String trmdemdeftion_id) {
        TrmDemdeftion domain = trmdemdeftionService.get(trmdemdeftion_id);
        TrmDemdeftionDTO dto = trmdemdeftionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmDemdeftion-Default-all')")
	@ApiOperation(value = "根据部门管理培训需求填报获取DEFAULT", tags = {"培训需求汇总" } ,notes = "根据部门管理培训需求填报获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/fetchdefault")
	public ResponseEntity<List<TrmDemdeftionDTO>> fetchTrmDemdeftionDefaultByOrmOrgsectorTrmTrainFillin(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id,TrmDemdeftionSearchContext context) {
        context.setN_trmtrainfillinid_eq(trmtrainfillin_id);
        Page<TrmDemdeftion> domains = trmdemdeftionService.searchDefault(context) ;
        List<TrmDemdeftionDTO> list = trmdemdeftionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmDemdeftion-Default-all')")
	@ApiOperation(value = "根据部门管理培训需求填报查询DEFAULT", tags = {"培训需求汇总" } ,notes = "根据部门管理培训需求填报查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/searchdefault")
	public ResponseEntity<Page<TrmDemdeftionDTO>> searchTrmDemdeftionDefaultByOrmOrgsectorTrmTrainFillin(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody TrmDemdeftionSearchContext context) {
        context.setN_trmtrainfillinid_eq(trmtrainfillin_id);
        Page<TrmDemdeftion> domains = trmdemdeftionService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmdemdeftionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据组织管理培训需求填报获取培训需求汇总草稿", tags = {"培训需求汇总" },  notes = "根据组织管理培训需求填报获取培训需求汇总草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/getdraft")
    public ResponseEntity<TrmDemdeftionDTO> getDraftByOrmOrgTrmTrainFillin(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
        TrmDemdeftion domain = new TrmDemdeftion();
        domain.setTrmtrainfillinid(trmtrainfillin_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmdemdeftionMapping.toDto(trmdemdeftionService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionMapping.toDomain(#trmdemdeftiondto),'ehr-TrmDemdeftion-Create')")
    @ApiOperation(value = "根据组织管理培训需求填报建立培训需求汇总", tags = {"培训需求汇总" },  notes = "根据组织管理培训需求填报建立培训需求汇总")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions")
    @Transactional
    public ResponseEntity<TrmDemdeftionDTO> createByOrmOrgTrmTrainFillin(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody TrmDemdeftionDTO trmdemdeftiondto) {
        TrmDemdeftion domain = trmdemdeftionMapping.toDomain(trmdemdeftiondto);
        domain.setTrmtrainfillinid(trmtrainfillin_id);
		trmdemdeftionService.create(domain);
        TrmDemdeftionDTO dto = trmdemdeftionMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionMapping.toDomain(#trmdemdeftiondtos),'ehr-TrmDemdeftion-Create')")
    @ApiOperation(value = "根据组织管理培训需求填报批量建立培训需求汇总", tags = {"培训需求汇总" },  notes = "根据组织管理培训需求填报批量建立培训需求汇总")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgTrmTrainFillin(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody List<TrmDemdeftionDTO> trmdemdeftiondtos) {
        List<TrmDemdeftion> domainlist=trmdemdeftionMapping.toDomain(trmdemdeftiondtos);
        for(TrmDemdeftion domain:domainlist){
            domain.setTrmtrainfillinid(trmtrainfillin_id);
        }
        trmdemdeftionService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionService.get(#trmdemdeftion_id),'ehr-TrmDemdeftion-Update')")
    @ApiOperation(value = "根据组织管理培训需求填报更新培训需求汇总", tags = {"培训需求汇总" },  notes = "根据组织管理培训需求填报更新培训需求汇总")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/{trmdemdeftion_id}")
    @Transactional
    public ResponseEntity<TrmDemdeftionDTO> updateByOrmOrgTrmTrainFillin(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @PathVariable("trmdemdeftion_id") String trmdemdeftion_id, @RequestBody TrmDemdeftionDTO trmdemdeftiondto) {
        TrmDemdeftion domain = trmdemdeftionMapping.toDomain(trmdemdeftiondto);
        domain.setTrmtrainfillinid(trmtrainfillin_id);
        domain.setTrmdemdeftionid(trmdemdeftion_id);
		trmdemdeftionService.update(domain);
        TrmDemdeftionDTO dto = trmdemdeftionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionService.getTrmdemdeftionByEntities(this.trmdemdeftionMapping.toDomain(#trmdemdeftiondtos)),'ehr-TrmDemdeftion-Update')")
    @ApiOperation(value = "根据组织管理培训需求填报批量更新培训需求汇总", tags = {"培训需求汇总" },  notes = "根据组织管理培训需求填报批量更新培训需求汇总")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgTrmTrainFillin(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody List<TrmDemdeftionDTO> trmdemdeftiondtos) {
        List<TrmDemdeftion> domainlist=trmdemdeftionMapping.toDomain(trmdemdeftiondtos);
        for(TrmDemdeftion domain:domainlist){
            domain.setTrmtrainfillinid(trmtrainfillin_id);
        }
        trmdemdeftionService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionService.get(#trmdemdeftion_id),'ehr-TrmDemdeftion-Remove')")
    @ApiOperation(value = "根据组织管理培训需求填报删除培训需求汇总", tags = {"培训需求汇总" },  notes = "根据组织管理培训需求填报删除培训需求汇总")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/{trmdemdeftion_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgTrmTrainFillin(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @PathVariable("trmdemdeftion_id") String trmdemdeftion_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmdemdeftionService.remove(trmdemdeftion_id));
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionService.getTrmdemdeftionByIds(#ids),'ehr-TrmDemdeftion-Remove')")
    @ApiOperation(value = "根据组织管理培训需求填报批量删除培训需求汇总", tags = {"培训需求汇总" },  notes = "根据组织管理培训需求填报批量删除培训需求汇总")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgTrmTrainFillin(@RequestBody List<String> ids) {
        trmdemdeftionService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionMapping.toDomain(#trmdemdeftiondto),'ehr-TrmDemdeftion-Save')")
    @ApiOperation(value = "根据组织管理培训需求填报保存培训需求汇总", tags = {"培训需求汇总" },  notes = "根据组织管理培训需求填报保存培训需求汇总")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/save")
    public ResponseEntity<Boolean> saveByOrmOrgTrmTrainFillin(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody TrmDemdeftionDTO trmdemdeftiondto) {
        TrmDemdeftion domain = trmdemdeftionMapping.toDomain(trmdemdeftiondto);
        domain.setTrmtrainfillinid(trmtrainfillin_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmdemdeftionService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionMapping.toDomain(#trmdemdeftiondtos),'ehr-TrmDemdeftion-Save')")
    @ApiOperation(value = "根据组织管理培训需求填报批量保存培训需求汇总", tags = {"培训需求汇总" },  notes = "根据组织管理培训需求填报批量保存培训需求汇总")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgTrmTrainFillin(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody List<TrmDemdeftionDTO> trmdemdeftiondtos) {
        List<TrmDemdeftion> domainlist=trmdemdeftionMapping.toDomain(trmdemdeftiondtos);
        for(TrmDemdeftion domain:domainlist){
             domain.setTrmtrainfillinid(trmtrainfillin_id);
        }
        trmdemdeftionService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据组织管理培训需求填报检查培训需求汇总", tags = {"培训需求汇总" },  notes = "根据组织管理培训需求填报检查培训需求汇总")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgTrmTrainFillin(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody TrmDemdeftionDTO trmdemdeftiondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmdemdeftionService.checkKey(trmdemdeftionMapping.toDomain(trmdemdeftiondto)));
    }

    @PostAuthorize("hasPermission(this.trmdemdeftionMapping.toDomain(returnObject.body),'ehr-TrmDemdeftion-Get')")
    @ApiOperation(value = "根据组织管理培训需求填报获取培训需求汇总", tags = {"培训需求汇总" },  notes = "根据组织管理培训需求填报获取培训需求汇总")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/{trmdemdeftion_id}")
    public ResponseEntity<TrmDemdeftionDTO> getByOrmOrgTrmTrainFillin(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @PathVariable("trmdemdeftion_id") String trmdemdeftion_id) {
        TrmDemdeftion domain = trmdemdeftionService.get(trmdemdeftion_id);
        TrmDemdeftionDTO dto = trmdemdeftionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmDemdeftion-Default-all')")
	@ApiOperation(value = "根据组织管理培训需求填报获取DEFAULT", tags = {"培训需求汇总" } ,notes = "根据组织管理培训需求填报获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/fetchdefault")
	public ResponseEntity<List<TrmDemdeftionDTO>> fetchTrmDemdeftionDefaultByOrmOrgTrmTrainFillin(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id,TrmDemdeftionSearchContext context) {
        context.setN_trmtrainfillinid_eq(trmtrainfillin_id);
        Page<TrmDemdeftion> domains = trmdemdeftionService.searchDefault(context) ;
        List<TrmDemdeftionDTO> list = trmdemdeftionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmDemdeftion-Default-all')")
	@ApiOperation(value = "根据组织管理培训需求填报查询DEFAULT", tags = {"培训需求汇总" } ,notes = "根据组织管理培训需求填报查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/searchdefault")
	public ResponseEntity<Page<TrmDemdeftionDTO>> searchTrmDemdeftionDefaultByOrmOrgTrmTrainFillin(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody TrmDemdeftionSearchContext context) {
        context.setN_trmtrainfillinid_eq(trmtrainfillin_id);
        Page<TrmDemdeftion> domains = trmdemdeftionService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmdemdeftionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据培训需求通知培训需求填报获取培训需求汇总草稿", tags = {"培训需求汇总" },  notes = "根据培训需求通知培训需求填报获取培训需求汇总草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/getdraft")
    public ResponseEntity<TrmDemdeftionDTO> getDraftByTrmDepartTrmTrainFillin(@PathVariable("trmdepart_id") String trmdepart_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
        TrmDemdeftion domain = new TrmDemdeftion();
        domain.setTrmtrainfillinid(trmtrainfillin_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmdemdeftionMapping.toDto(trmdemdeftionService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionMapping.toDomain(#trmdemdeftiondto),'ehr-TrmDemdeftion-Create')")
    @ApiOperation(value = "根据培训需求通知培训需求填报建立培训需求汇总", tags = {"培训需求汇总" },  notes = "根据培训需求通知培训需求填报建立培训需求汇总")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions")
    @Transactional
    public ResponseEntity<TrmDemdeftionDTO> createByTrmDepartTrmTrainFillin(@PathVariable("trmdepart_id") String trmdepart_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody TrmDemdeftionDTO trmdemdeftiondto) {
        TrmDemdeftion domain = trmdemdeftionMapping.toDomain(trmdemdeftiondto);
        domain.setTrmtrainfillinid(trmtrainfillin_id);
		trmdemdeftionService.create(domain);
        TrmDemdeftionDTO dto = trmdemdeftionMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionMapping.toDomain(#trmdemdeftiondtos),'ehr-TrmDemdeftion-Create')")
    @ApiOperation(value = "根据培训需求通知培训需求填报批量建立培训需求汇总", tags = {"培训需求汇总" },  notes = "根据培训需求通知培训需求填报批量建立培训需求汇总")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/batch")
    public ResponseEntity<Boolean> createBatchByTrmDepartTrmTrainFillin(@PathVariable("trmdepart_id") String trmdepart_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody List<TrmDemdeftionDTO> trmdemdeftiondtos) {
        List<TrmDemdeftion> domainlist=trmdemdeftionMapping.toDomain(trmdemdeftiondtos);
        for(TrmDemdeftion domain:domainlist){
            domain.setTrmtrainfillinid(trmtrainfillin_id);
        }
        trmdemdeftionService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionService.get(#trmdemdeftion_id),'ehr-TrmDemdeftion-Update')")
    @ApiOperation(value = "根据培训需求通知培训需求填报更新培训需求汇总", tags = {"培训需求汇总" },  notes = "根据培训需求通知培训需求填报更新培训需求汇总")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/{trmdemdeftion_id}")
    @Transactional
    public ResponseEntity<TrmDemdeftionDTO> updateByTrmDepartTrmTrainFillin(@PathVariable("trmdepart_id") String trmdepart_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @PathVariable("trmdemdeftion_id") String trmdemdeftion_id, @RequestBody TrmDemdeftionDTO trmdemdeftiondto) {
        TrmDemdeftion domain = trmdemdeftionMapping.toDomain(trmdemdeftiondto);
        domain.setTrmtrainfillinid(trmtrainfillin_id);
        domain.setTrmdemdeftionid(trmdemdeftion_id);
		trmdemdeftionService.update(domain);
        TrmDemdeftionDTO dto = trmdemdeftionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionService.getTrmdemdeftionByEntities(this.trmdemdeftionMapping.toDomain(#trmdemdeftiondtos)),'ehr-TrmDemdeftion-Update')")
    @ApiOperation(value = "根据培训需求通知培训需求填报批量更新培训需求汇总", tags = {"培训需求汇总" },  notes = "根据培训需求通知培训需求填报批量更新培训需求汇总")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/batch")
    public ResponseEntity<Boolean> updateBatchByTrmDepartTrmTrainFillin(@PathVariable("trmdepart_id") String trmdepart_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody List<TrmDemdeftionDTO> trmdemdeftiondtos) {
        List<TrmDemdeftion> domainlist=trmdemdeftionMapping.toDomain(trmdemdeftiondtos);
        for(TrmDemdeftion domain:domainlist){
            domain.setTrmtrainfillinid(trmtrainfillin_id);
        }
        trmdemdeftionService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionService.get(#trmdemdeftion_id),'ehr-TrmDemdeftion-Remove')")
    @ApiOperation(value = "根据培训需求通知培训需求填报删除培训需求汇总", tags = {"培训需求汇总" },  notes = "根据培训需求通知培训需求填报删除培训需求汇总")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/{trmdemdeftion_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByTrmDepartTrmTrainFillin(@PathVariable("trmdepart_id") String trmdepart_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @PathVariable("trmdemdeftion_id") String trmdemdeftion_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmdemdeftionService.remove(trmdemdeftion_id));
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionService.getTrmdemdeftionByIds(#ids),'ehr-TrmDemdeftion-Remove')")
    @ApiOperation(value = "根据培训需求通知培训需求填报批量删除培训需求汇总", tags = {"培训需求汇总" },  notes = "根据培训需求通知培训需求填报批量删除培训需求汇总")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/batch")
    public ResponseEntity<Boolean> removeBatchByTrmDepartTrmTrainFillin(@RequestBody List<String> ids) {
        trmdemdeftionService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionMapping.toDomain(#trmdemdeftiondto),'ehr-TrmDemdeftion-Save')")
    @ApiOperation(value = "根据培训需求通知培训需求填报保存培训需求汇总", tags = {"培训需求汇总" },  notes = "根据培训需求通知培训需求填报保存培训需求汇总")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/save")
    public ResponseEntity<Boolean> saveByTrmDepartTrmTrainFillin(@PathVariable("trmdepart_id") String trmdepart_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody TrmDemdeftionDTO trmdemdeftiondto) {
        TrmDemdeftion domain = trmdemdeftionMapping.toDomain(trmdemdeftiondto);
        domain.setTrmtrainfillinid(trmtrainfillin_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmdemdeftionService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionMapping.toDomain(#trmdemdeftiondtos),'ehr-TrmDemdeftion-Save')")
    @ApiOperation(value = "根据培训需求通知培训需求填报批量保存培训需求汇总", tags = {"培训需求汇总" },  notes = "根据培训需求通知培训需求填报批量保存培训需求汇总")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/savebatch")
    public ResponseEntity<Boolean> saveBatchByTrmDepartTrmTrainFillin(@PathVariable("trmdepart_id") String trmdepart_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody List<TrmDemdeftionDTO> trmdemdeftiondtos) {
        List<TrmDemdeftion> domainlist=trmdemdeftionMapping.toDomain(trmdemdeftiondtos);
        for(TrmDemdeftion domain:domainlist){
             domain.setTrmtrainfillinid(trmtrainfillin_id);
        }
        trmdemdeftionService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据培训需求通知培训需求填报检查培训需求汇总", tags = {"培训需求汇总" },  notes = "根据培训需求通知培训需求填报检查培训需求汇总")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/checkkey")
    public ResponseEntity<Boolean> checkKeyByTrmDepartTrmTrainFillin(@PathVariable("trmdepart_id") String trmdepart_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody TrmDemdeftionDTO trmdemdeftiondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmdemdeftionService.checkKey(trmdemdeftionMapping.toDomain(trmdemdeftiondto)));
    }

    @PostAuthorize("hasPermission(this.trmdemdeftionMapping.toDomain(returnObject.body),'ehr-TrmDemdeftion-Get')")
    @ApiOperation(value = "根据培训需求通知培训需求填报获取培训需求汇总", tags = {"培训需求汇总" },  notes = "根据培训需求通知培训需求填报获取培训需求汇总")
	@RequestMapping(method = RequestMethod.GET, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/{trmdemdeftion_id}")
    public ResponseEntity<TrmDemdeftionDTO> getByTrmDepartTrmTrainFillin(@PathVariable("trmdepart_id") String trmdepart_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @PathVariable("trmdemdeftion_id") String trmdemdeftion_id) {
        TrmDemdeftion domain = trmdemdeftionService.get(trmdemdeftion_id);
        TrmDemdeftionDTO dto = trmdemdeftionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmDemdeftion-Default-all')")
	@ApiOperation(value = "根据培训需求通知培训需求填报获取DEFAULT", tags = {"培训需求汇总" } ,notes = "根据培训需求通知培训需求填报获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmdeparts/{trmdepart_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/fetchdefault")
	public ResponseEntity<List<TrmDemdeftionDTO>> fetchTrmDemdeftionDefaultByTrmDepartTrmTrainFillin(@PathVariable("trmdepart_id") String trmdepart_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id,TrmDemdeftionSearchContext context) {
        context.setN_trmtrainfillinid_eq(trmtrainfillin_id);
        Page<TrmDemdeftion> domains = trmdemdeftionService.searchDefault(context) ;
        List<TrmDemdeftionDTO> list = trmdemdeftionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmDemdeftion-Default-all')")
	@ApiOperation(value = "根据培训需求通知培训需求填报查询DEFAULT", tags = {"培训需求汇总" } ,notes = "根据培训需求通知培训需求填报查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmdeparts/{trmdepart_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/searchdefault")
	public ResponseEntity<Page<TrmDemdeftionDTO>> searchTrmDemdeftionDefaultByTrmDepartTrmTrainFillin(@PathVariable("trmdepart_id") String trmdepart_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody TrmDemdeftionSearchContext context) {
        context.setN_trmtrainfillinid_eq(trmtrainfillin_id);
        Page<TrmDemdeftion> domains = trmdemdeftionService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmdemdeftionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据组织管理部门管理培训需求填报获取培训需求汇总草稿", tags = {"培训需求汇总" },  notes = "根据组织管理部门管理培训需求填报获取培训需求汇总草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/getdraft")
    public ResponseEntity<TrmDemdeftionDTO> getDraftByOrmOrgOrmOrgsectorTrmTrainFillin(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
        TrmDemdeftion domain = new TrmDemdeftion();
        domain.setTrmtrainfillinid(trmtrainfillin_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmdemdeftionMapping.toDto(trmdemdeftionService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionMapping.toDomain(#trmdemdeftiondto),'ehr-TrmDemdeftion-Create')")
    @ApiOperation(value = "根据组织管理部门管理培训需求填报建立培训需求汇总", tags = {"培训需求汇总" },  notes = "根据组织管理部门管理培训需求填报建立培训需求汇总")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions")
    @Transactional
    public ResponseEntity<TrmDemdeftionDTO> createByOrmOrgOrmOrgsectorTrmTrainFillin(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody TrmDemdeftionDTO trmdemdeftiondto) {
        TrmDemdeftion domain = trmdemdeftionMapping.toDomain(trmdemdeftiondto);
        domain.setTrmtrainfillinid(trmtrainfillin_id);
		trmdemdeftionService.create(domain);
        TrmDemdeftionDTO dto = trmdemdeftionMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionMapping.toDomain(#trmdemdeftiondtos),'ehr-TrmDemdeftion-Create')")
    @ApiOperation(value = "根据组织管理部门管理培训需求填报批量建立培训需求汇总", tags = {"培训需求汇总" },  notes = "根据组织管理部门管理培训需求填报批量建立培训需求汇总")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgOrmOrgsectorTrmTrainFillin(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody List<TrmDemdeftionDTO> trmdemdeftiondtos) {
        List<TrmDemdeftion> domainlist=trmdemdeftionMapping.toDomain(trmdemdeftiondtos);
        for(TrmDemdeftion domain:domainlist){
            domain.setTrmtrainfillinid(trmtrainfillin_id);
        }
        trmdemdeftionService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionService.get(#trmdemdeftion_id),'ehr-TrmDemdeftion-Update')")
    @ApiOperation(value = "根据组织管理部门管理培训需求填报更新培训需求汇总", tags = {"培训需求汇总" },  notes = "根据组织管理部门管理培训需求填报更新培训需求汇总")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/{trmdemdeftion_id}")
    @Transactional
    public ResponseEntity<TrmDemdeftionDTO> updateByOrmOrgOrmOrgsectorTrmTrainFillin(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @PathVariable("trmdemdeftion_id") String trmdemdeftion_id, @RequestBody TrmDemdeftionDTO trmdemdeftiondto) {
        TrmDemdeftion domain = trmdemdeftionMapping.toDomain(trmdemdeftiondto);
        domain.setTrmtrainfillinid(trmtrainfillin_id);
        domain.setTrmdemdeftionid(trmdemdeftion_id);
		trmdemdeftionService.update(domain);
        TrmDemdeftionDTO dto = trmdemdeftionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionService.getTrmdemdeftionByEntities(this.trmdemdeftionMapping.toDomain(#trmdemdeftiondtos)),'ehr-TrmDemdeftion-Update')")
    @ApiOperation(value = "根据组织管理部门管理培训需求填报批量更新培训需求汇总", tags = {"培训需求汇总" },  notes = "根据组织管理部门管理培训需求填报批量更新培训需求汇总")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgOrmOrgsectorTrmTrainFillin(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody List<TrmDemdeftionDTO> trmdemdeftiondtos) {
        List<TrmDemdeftion> domainlist=trmdemdeftionMapping.toDomain(trmdemdeftiondtos);
        for(TrmDemdeftion domain:domainlist){
            domain.setTrmtrainfillinid(trmtrainfillin_id);
        }
        trmdemdeftionService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionService.get(#trmdemdeftion_id),'ehr-TrmDemdeftion-Remove')")
    @ApiOperation(value = "根据组织管理部门管理培训需求填报删除培训需求汇总", tags = {"培训需求汇总" },  notes = "根据组织管理部门管理培训需求填报删除培训需求汇总")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/{trmdemdeftion_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgOrmOrgsectorTrmTrainFillin(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @PathVariable("trmdemdeftion_id") String trmdemdeftion_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmdemdeftionService.remove(trmdemdeftion_id));
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionService.getTrmdemdeftionByIds(#ids),'ehr-TrmDemdeftion-Remove')")
    @ApiOperation(value = "根据组织管理部门管理培训需求填报批量删除培训需求汇总", tags = {"培训需求汇总" },  notes = "根据组织管理部门管理培训需求填报批量删除培训需求汇总")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgOrmOrgsectorTrmTrainFillin(@RequestBody List<String> ids) {
        trmdemdeftionService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionMapping.toDomain(#trmdemdeftiondto),'ehr-TrmDemdeftion-Save')")
    @ApiOperation(value = "根据组织管理部门管理培训需求填报保存培训需求汇总", tags = {"培训需求汇总" },  notes = "根据组织管理部门管理培训需求填报保存培训需求汇总")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/save")
    public ResponseEntity<Boolean> saveByOrmOrgOrmOrgsectorTrmTrainFillin(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody TrmDemdeftionDTO trmdemdeftiondto) {
        TrmDemdeftion domain = trmdemdeftionMapping.toDomain(trmdemdeftiondto);
        domain.setTrmtrainfillinid(trmtrainfillin_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmdemdeftionService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmdemdeftionMapping.toDomain(#trmdemdeftiondtos),'ehr-TrmDemdeftion-Save')")
    @ApiOperation(value = "根据组织管理部门管理培训需求填报批量保存培训需求汇总", tags = {"培训需求汇总" },  notes = "根据组织管理部门管理培训需求填报批量保存培训需求汇总")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgOrmOrgsectorTrmTrainFillin(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody List<TrmDemdeftionDTO> trmdemdeftiondtos) {
        List<TrmDemdeftion> domainlist=trmdemdeftionMapping.toDomain(trmdemdeftiondtos);
        for(TrmDemdeftion domain:domainlist){
             domain.setTrmtrainfillinid(trmtrainfillin_id);
        }
        trmdemdeftionService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据组织管理部门管理培训需求填报检查培训需求汇总", tags = {"培训需求汇总" },  notes = "根据组织管理部门管理培训需求填报检查培训需求汇总")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgOrmOrgsectorTrmTrainFillin(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody TrmDemdeftionDTO trmdemdeftiondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmdemdeftionService.checkKey(trmdemdeftionMapping.toDomain(trmdemdeftiondto)));
    }

    @PostAuthorize("hasPermission(this.trmdemdeftionMapping.toDomain(returnObject.body),'ehr-TrmDemdeftion-Get')")
    @ApiOperation(value = "根据组织管理部门管理培训需求填报获取培训需求汇总", tags = {"培训需求汇总" },  notes = "根据组织管理部门管理培训需求填报获取培训需求汇总")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/{trmdemdeftion_id}")
    public ResponseEntity<TrmDemdeftionDTO> getByOrmOrgOrmOrgsectorTrmTrainFillin(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @PathVariable("trmdemdeftion_id") String trmdemdeftion_id) {
        TrmDemdeftion domain = trmdemdeftionService.get(trmdemdeftion_id);
        TrmDemdeftionDTO dto = trmdemdeftionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmDemdeftion-Default-all')")
	@ApiOperation(value = "根据组织管理部门管理培训需求填报获取DEFAULT", tags = {"培训需求汇总" } ,notes = "根据组织管理部门管理培训需求填报获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/fetchdefault")
	public ResponseEntity<List<TrmDemdeftionDTO>> fetchTrmDemdeftionDefaultByOrmOrgOrmOrgsectorTrmTrainFillin(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id,TrmDemdeftionSearchContext context) {
        context.setN_trmtrainfillinid_eq(trmtrainfillin_id);
        Page<TrmDemdeftion> domains = trmdemdeftionService.searchDefault(context) ;
        List<TrmDemdeftionDTO> list = trmdemdeftionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmDemdeftion-Default-all')")
	@ApiOperation(value = "根据组织管理部门管理培训需求填报查询DEFAULT", tags = {"培训需求汇总" } ,notes = "根据组织管理部门管理培训需求填报查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}/trmdemdeftions/searchdefault")
	public ResponseEntity<Page<TrmDemdeftionDTO>> searchTrmDemdeftionDefaultByOrmOrgOrmOrgsectorTrmTrainFillin(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody TrmDemdeftionSearchContext context) {
        context.setN_trmtrainfillinid_eq(trmtrainfillin_id);
        Page<TrmDemdeftion> domains = trmdemdeftionService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmdemdeftionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

