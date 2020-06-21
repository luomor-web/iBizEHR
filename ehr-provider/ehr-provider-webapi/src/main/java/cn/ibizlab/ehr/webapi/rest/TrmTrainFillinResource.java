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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainFillin;
import cn.ibizlab.ehr.core.trm.service.ITrmTrainFillinService;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainFillinSearchContext;

@Slf4j
@Api(tags = {"培训需求填报" })
@RestController("WebApi-trmtrainfillin")
@RequestMapping("")
public class TrmTrainFillinResource {

    @Autowired
    public ITrmTrainFillinService trmtrainfillinService;

    @Autowired
    @Lazy
    public TrmTrainFillinMapping trmtrainfillinMapping;

    @PostAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(returnObject.body),'ehr-TrmTrainFillin-Get')")
    @ApiOperation(value = "获取培训需求填报", tags = {"培训需求填报" },  notes = "获取培训需求填报")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainfillins/{trmtrainfillin_id}")
    public ResponseEntity<TrmTrainFillinDTO> get(@PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
        TrmTrainFillin domain = trmtrainfillinService.get(trmtrainfillin_id);
        TrmTrainFillinDTO dto = trmtrainfillinMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.get(#trmtrainfillin_id),'ehr-TrmTrainFillin-Update')")
    @ApiOperation(value = "更新培训需求填报", tags = {"培训需求填报" },  notes = "更新培训需求填报")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainfillins/{trmtrainfillin_id}")
    @Transactional
    public ResponseEntity<TrmTrainFillinDTO> update(@PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody TrmTrainFillinDTO trmtrainfillindto) {
		TrmTrainFillin domain  = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain .setTrmtrainfillinid(trmtrainfillin_id);
		trmtrainfillinService.update(domain );
		TrmTrainFillinDTO dto = trmtrainfillinMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.getTrmtrainfillinByEntities(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos)),'ehr-TrmTrainFillin-Update')")
    @ApiOperation(value = "批量更新培训需求填报", tags = {"培训需求填报" },  notes = "批量更新培训需求填报")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainfillins/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmTrainFillinDTO> trmtrainfillindtos) {
        trmtrainfillinService.updateBatch(trmtrainfillinMapping.toDomain(trmtrainfillindtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查培训需求填报", tags = {"培训需求填报" },  notes = "检查培训需求填报")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfillins/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmTrainFillinDTO trmtrainfillindto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.checkKey(trmtrainfillinMapping.toDomain(trmtrainfillindto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindto),'ehr-TrmTrainFillin-Create')")
    @ApiOperation(value = "新建培训需求填报", tags = {"培训需求填报" },  notes = "新建培训需求填报")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfillins")
    @Transactional
    public ResponseEntity<TrmTrainFillinDTO> create(@RequestBody TrmTrainFillinDTO trmtrainfillindto) {
        TrmTrainFillin domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
		trmtrainfillinService.create(domain);
        TrmTrainFillinDTO dto = trmtrainfillinMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos),'ehr-TrmTrainFillin-Create')")
    @ApiOperation(value = "批量新建培训需求填报", tags = {"培训需求填报" },  notes = "批量新建培训需求填报")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfillins/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmTrainFillinDTO> trmtrainfillindtos) {
        trmtrainfillinService.createBatch(trmtrainfillinMapping.toDomain(trmtrainfillindtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindto),'ehr-TrmTrainFillin-Save')")
    @ApiOperation(value = "保存培训需求填报", tags = {"培训需求填报" },  notes = "保存培训需求填报")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfillins/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmTrainFillinDTO trmtrainfillindto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.save(trmtrainfillinMapping.toDomain(trmtrainfillindto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos),'ehr-TrmTrainFillin-Save')")
    @ApiOperation(value = "批量保存培训需求填报", tags = {"培训需求填报" },  notes = "批量保存培训需求填报")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfillins/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmTrainFillinDTO> trmtrainfillindtos) {
        trmtrainfillinService.saveBatch(trmtrainfillinMapping.toDomain(trmtrainfillindtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取培训需求填报草稿", tags = {"培训需求填报" },  notes = "获取培训需求填报草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainfillins/getdraft")
    public ResponseEntity<TrmTrainFillinDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinMapping.toDto(trmtrainfillinService.getDraft(new TrmTrainFillin())));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.get(#trmtrainfillin_id),'ehr-TrmTrainFillin-Remove')")
    @ApiOperation(value = "删除培训需求填报", tags = {"培训需求填报" },  notes = "删除培训需求填报")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainfillins/{trmtrainfillin_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.remove(trmtrainfillin_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.getTrmtrainfillinByIds(#ids),'ehr-TrmTrainFillin-Remove')")
    @ApiOperation(value = "批量删除培训需求填报", tags = {"培训需求填报" },  notes = "批量删除培训需求填报")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainfillins/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtrainfillinService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainFillin-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"培训需求填报" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainfillins/fetchdefault")
	public ResponseEntity<List<TrmTrainFillinDTO>> fetchDefault(TrmTrainFillinSearchContext context) {
        Page<TrmTrainFillin> domains = trmtrainfillinService.searchDefault(context) ;
        List<TrmTrainFillinDTO> list = trmtrainfillinMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainFillin-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"培训需求填报" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainfillins/searchdefault")
	public ResponseEntity<Page<TrmTrainFillinDTO>> searchDefault(@RequestBody TrmTrainFillinSearchContext context) {
        Page<TrmTrainFillin> domains = trmtrainfillinService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainfillinMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(returnObject.body),'ehr-TrmTrainFillin-Get')")
    @ApiOperation(value = "根据部门管理获取培训需求填报", tags = {"培训需求填报" },  notes = "根据部门管理获取培训需求填报")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}")
    public ResponseEntity<TrmTrainFillinDTO> getByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
        TrmTrainFillin domain = trmtrainfillinService.get(trmtrainfillin_id);
        TrmTrainFillinDTO dto = trmtrainfillinMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.get(#trmtrainfillin_id),'ehr-TrmTrainFillin-Update')")
    @ApiOperation(value = "根据部门管理更新培训需求填报", tags = {"培训需求填报" },  notes = "根据部门管理更新培训需求填报")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}")
    @Transactional
    public ResponseEntity<TrmTrainFillinDTO> updateByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody TrmTrainFillinDTO trmtrainfillindto) {
        TrmTrainFillin domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setOrmorgsectorid(ormorgsector_id);
        domain.setTrmtrainfillinid(trmtrainfillin_id);
		trmtrainfillinService.update(domain);
        TrmTrainFillinDTO dto = trmtrainfillinMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.getTrmtrainfillinByEntities(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos)),'ehr-TrmTrainFillin-Update')")
    @ApiOperation(value = "根据部门管理批量更新培训需求填报", tags = {"培训需求填报" },  notes = "根据部门管理批量更新培训需求填报")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<TrmTrainFillinDTO> trmtrainfillindtos) {
        List<TrmTrainFillin> domainlist=trmtrainfillinMapping.toDomain(trmtrainfillindtos);
        for(TrmTrainFillin domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        trmtrainfillinService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据部门管理检查培训需求填报", tags = {"培训需求填报" },  notes = "根据部门管理检查培训需求填报")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody TrmTrainFillinDTO trmtrainfillindto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.checkKey(trmtrainfillinMapping.toDomain(trmtrainfillindto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindto),'ehr-TrmTrainFillin-Create')")
    @ApiOperation(value = "根据部门管理建立培训需求填报", tags = {"培训需求填报" },  notes = "根据部门管理建立培训需求填报")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins")
    @Transactional
    public ResponseEntity<TrmTrainFillinDTO> createByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody TrmTrainFillinDTO trmtrainfillindto) {
        TrmTrainFillin domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setOrmorgsectorid(ormorgsector_id);
		trmtrainfillinService.create(domain);
        TrmTrainFillinDTO dto = trmtrainfillinMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos),'ehr-TrmTrainFillin-Create')")
    @ApiOperation(value = "根据部门管理批量建立培训需求填报", tags = {"培训需求填报" },  notes = "根据部门管理批量建立培训需求填报")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<TrmTrainFillinDTO> trmtrainfillindtos) {
        List<TrmTrainFillin> domainlist=trmtrainfillinMapping.toDomain(trmtrainfillindtos);
        for(TrmTrainFillin domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        trmtrainfillinService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindto),'ehr-TrmTrainFillin-Save')")
    @ApiOperation(value = "根据部门管理保存培训需求填报", tags = {"培训需求填报" },  notes = "根据部门管理保存培训需求填报")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/save")
    public ResponseEntity<Boolean> saveByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody TrmTrainFillinDTO trmtrainfillindto) {
        TrmTrainFillin domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos),'ehr-TrmTrainFillin-Save')")
    @ApiOperation(value = "根据部门管理批量保存培训需求填报", tags = {"培训需求填报" },  notes = "根据部门管理批量保存培训需求填报")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<TrmTrainFillinDTO> trmtrainfillindtos) {
        List<TrmTrainFillin> domainlist=trmtrainfillinMapping.toDomain(trmtrainfillindtos);
        for(TrmTrainFillin domain:domainlist){
             domain.setOrmorgsectorid(ormorgsector_id);
        }
        trmtrainfillinService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据部门管理获取培训需求填报草稿", tags = {"培训需求填报" },  notes = "根据部门管理获取培训需求填报草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/getdraft")
    public ResponseEntity<TrmTrainFillinDTO> getDraftByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id) {
        TrmTrainFillin domain = new TrmTrainFillin();
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinMapping.toDto(trmtrainfillinService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.get(#trmtrainfillin_id),'ehr-TrmTrainFillin-Remove')")
    @ApiOperation(value = "根据部门管理删除培训需求填报", tags = {"培训需求填报" },  notes = "根据部门管理删除培训需求填报")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.remove(trmtrainfillin_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.getTrmtrainfillinByIds(#ids),'ehr-TrmTrainFillin-Remove')")
    @ApiOperation(value = "根据部门管理批量删除培训需求填报", tags = {"培训需求填报" },  notes = "根据部门管理批量删除培训需求填报")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgsector(@RequestBody List<String> ids) {
        trmtrainfillinService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainFillin-Default-all')")
	@ApiOperation(value = "根据部门管理获取DEFAULT", tags = {"培训需求填报" } ,notes = "根据部门管理获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/{ormorgsector_id}/trmtrainfillins/fetchdefault")
	public ResponseEntity<List<TrmTrainFillinDTO>> fetchTrmTrainFillinDefaultByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id,TrmTrainFillinSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<TrmTrainFillin> domains = trmtrainfillinService.searchDefault(context) ;
        List<TrmTrainFillinDTO> list = trmtrainfillinMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainFillin-Default-all')")
	@ApiOperation(value = "根据部门管理查询DEFAULT", tags = {"培训需求填报" } ,notes = "根据部门管理查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/{ormorgsector_id}/trmtrainfillins/searchdefault")
	public ResponseEntity<Page<TrmTrainFillinDTO>> searchTrmTrainFillinDefaultByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody TrmTrainFillinSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<TrmTrainFillin> domains = trmtrainfillinService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainfillinMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(returnObject.body),'ehr-TrmTrainFillin-Get')")
    @ApiOperation(value = "根据组织管理获取培训需求填报", tags = {"培训需求填报" },  notes = "根据组织管理获取培训需求填报")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/trmtrainfillins/{trmtrainfillin_id}")
    public ResponseEntity<TrmTrainFillinDTO> getByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
        TrmTrainFillin domain = trmtrainfillinService.get(trmtrainfillin_id);
        TrmTrainFillinDTO dto = trmtrainfillinMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.get(#trmtrainfillin_id),'ehr-TrmTrainFillin-Update')")
    @ApiOperation(value = "根据组织管理更新培训需求填报", tags = {"培训需求填报" },  notes = "根据组织管理更新培训需求填报")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/trmtrainfillins/{trmtrainfillin_id}")
    @Transactional
    public ResponseEntity<TrmTrainFillinDTO> updateByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody TrmTrainFillinDTO trmtrainfillindto) {
        TrmTrainFillin domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setOrmorgid(ormorg_id);
        domain.setTrmtrainfillinid(trmtrainfillin_id);
		trmtrainfillinService.update(domain);
        TrmTrainFillinDTO dto = trmtrainfillinMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.getTrmtrainfillinByEntities(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos)),'ehr-TrmTrainFillin-Update')")
    @ApiOperation(value = "根据组织管理批量更新培训需求填报", tags = {"培训需求填报" },  notes = "根据组织管理批量更新培训需求填报")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/trmtrainfillins/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody List<TrmTrainFillinDTO> trmtrainfillindtos) {
        List<TrmTrainFillin> domainlist=trmtrainfillinMapping.toDomain(trmtrainfillindtos);
        for(TrmTrainFillin domain:domainlist){
            domain.setOrmorgid(ormorg_id);
        }
        trmtrainfillinService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据组织管理检查培训需求填报", tags = {"培训需求填报" },  notes = "根据组织管理检查培训需求填报")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/trmtrainfillins/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody TrmTrainFillinDTO trmtrainfillindto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.checkKey(trmtrainfillinMapping.toDomain(trmtrainfillindto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindto),'ehr-TrmTrainFillin-Create')")
    @ApiOperation(value = "根据组织管理建立培训需求填报", tags = {"培训需求填报" },  notes = "根据组织管理建立培训需求填报")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/trmtrainfillins")
    @Transactional
    public ResponseEntity<TrmTrainFillinDTO> createByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody TrmTrainFillinDTO trmtrainfillindto) {
        TrmTrainFillin domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setOrmorgid(ormorg_id);
		trmtrainfillinService.create(domain);
        TrmTrainFillinDTO dto = trmtrainfillinMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos),'ehr-TrmTrainFillin-Create')")
    @ApiOperation(value = "根据组织管理批量建立培训需求填报", tags = {"培训需求填报" },  notes = "根据组织管理批量建立培训需求填报")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/trmtrainfillins/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody List<TrmTrainFillinDTO> trmtrainfillindtos) {
        List<TrmTrainFillin> domainlist=trmtrainfillinMapping.toDomain(trmtrainfillindtos);
        for(TrmTrainFillin domain:domainlist){
            domain.setOrmorgid(ormorg_id);
        }
        trmtrainfillinService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindto),'ehr-TrmTrainFillin-Save')")
    @ApiOperation(value = "根据组织管理保存培训需求填报", tags = {"培训需求填报" },  notes = "根据组织管理保存培训需求填报")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/trmtrainfillins/save")
    public ResponseEntity<Boolean> saveByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody TrmTrainFillinDTO trmtrainfillindto) {
        TrmTrainFillin domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setOrmorgid(ormorg_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos),'ehr-TrmTrainFillin-Save')")
    @ApiOperation(value = "根据组织管理批量保存培训需求填报", tags = {"培训需求填报" },  notes = "根据组织管理批量保存培训需求填报")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/trmtrainfillins/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody List<TrmTrainFillinDTO> trmtrainfillindtos) {
        List<TrmTrainFillin> domainlist=trmtrainfillinMapping.toDomain(trmtrainfillindtos);
        for(TrmTrainFillin domain:domainlist){
             domain.setOrmorgid(ormorg_id);
        }
        trmtrainfillinService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据组织管理获取培训需求填报草稿", tags = {"培训需求填报" },  notes = "根据组织管理获取培训需求填报草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/trmtrainfillins/getdraft")
    public ResponseEntity<TrmTrainFillinDTO> getDraftByOrmOrg(@PathVariable("ormorg_id") String ormorg_id) {
        TrmTrainFillin domain = new TrmTrainFillin();
        domain.setOrmorgid(ormorg_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinMapping.toDto(trmtrainfillinService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.get(#trmtrainfillin_id),'ehr-TrmTrainFillin-Remove')")
    @ApiOperation(value = "根据组织管理删除培训需求填报", tags = {"培训需求填报" },  notes = "根据组织管理删除培训需求填报")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/trmtrainfillins/{trmtrainfillin_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.remove(trmtrainfillin_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.getTrmtrainfillinByIds(#ids),'ehr-TrmTrainFillin-Remove')")
    @ApiOperation(value = "根据组织管理批量删除培训需求填报", tags = {"培训需求填报" },  notes = "根据组织管理批量删除培训需求填报")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/trmtrainfillins/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrg(@RequestBody List<String> ids) {
        trmtrainfillinService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainFillin-Default-all')")
	@ApiOperation(value = "根据组织管理获取DEFAULT", tags = {"培训需求填报" } ,notes = "根据组织管理获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/trmtrainfillins/fetchdefault")
	public ResponseEntity<List<TrmTrainFillinDTO>> fetchTrmTrainFillinDefaultByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,TrmTrainFillinSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<TrmTrainFillin> domains = trmtrainfillinService.searchDefault(context) ;
        List<TrmTrainFillinDTO> list = trmtrainfillinMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainFillin-Default-all')")
	@ApiOperation(value = "根据组织管理查询DEFAULT", tags = {"培训需求填报" } ,notes = "根据组织管理查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/trmtrainfillins/searchdefault")
	public ResponseEntity<Page<TrmTrainFillinDTO>> searchTrmTrainFillinDefaultByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody TrmTrainFillinSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<TrmTrainFillin> domains = trmtrainfillinService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainfillinMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(returnObject.body),'ehr-TrmTrainFillin-Get')")
    @ApiOperation(value = "根据培训需求通知获取培训需求填报", tags = {"培训需求填报" },  notes = "根据培训需求通知获取培训需求填报")
	@RequestMapping(method = RequestMethod.GET, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/{trmtrainfillin_id}")
    public ResponseEntity<TrmTrainFillinDTO> getByTrmDepart(@PathVariable("trmdepart_id") String trmdepart_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
        TrmTrainFillin domain = trmtrainfillinService.get(trmtrainfillin_id);
        TrmTrainFillinDTO dto = trmtrainfillinMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.get(#trmtrainfillin_id),'ehr-TrmTrainFillin-Update')")
    @ApiOperation(value = "根据培训需求通知更新培训需求填报", tags = {"培训需求填报" },  notes = "根据培训需求通知更新培训需求填报")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/{trmtrainfillin_id}")
    @Transactional
    public ResponseEntity<TrmTrainFillinDTO> updateByTrmDepart(@PathVariable("trmdepart_id") String trmdepart_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody TrmTrainFillinDTO trmtrainfillindto) {
        TrmTrainFillin domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setTrmdepartid(trmdepart_id);
        domain.setTrmtrainfillinid(trmtrainfillin_id);
		trmtrainfillinService.update(domain);
        TrmTrainFillinDTO dto = trmtrainfillinMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.getTrmtrainfillinByEntities(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos)),'ehr-TrmTrainFillin-Update')")
    @ApiOperation(value = "根据培训需求通知批量更新培训需求填报", tags = {"培训需求填报" },  notes = "根据培训需求通知批量更新培训需求填报")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/batch")
    public ResponseEntity<Boolean> updateBatchByTrmDepart(@PathVariable("trmdepart_id") String trmdepart_id, @RequestBody List<TrmTrainFillinDTO> trmtrainfillindtos) {
        List<TrmTrainFillin> domainlist=trmtrainfillinMapping.toDomain(trmtrainfillindtos);
        for(TrmTrainFillin domain:domainlist){
            domain.setTrmdepartid(trmdepart_id);
        }
        trmtrainfillinService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据培训需求通知检查培训需求填报", tags = {"培训需求填报" },  notes = "根据培训需求通知检查培训需求填报")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/checkkey")
    public ResponseEntity<Boolean> checkKeyByTrmDepart(@PathVariable("trmdepart_id") String trmdepart_id, @RequestBody TrmTrainFillinDTO trmtrainfillindto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.checkKey(trmtrainfillinMapping.toDomain(trmtrainfillindto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindto),'ehr-TrmTrainFillin-Create')")
    @ApiOperation(value = "根据培训需求通知建立培训需求填报", tags = {"培训需求填报" },  notes = "根据培训需求通知建立培训需求填报")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins")
    @Transactional
    public ResponseEntity<TrmTrainFillinDTO> createByTrmDepart(@PathVariable("trmdepart_id") String trmdepart_id, @RequestBody TrmTrainFillinDTO trmtrainfillindto) {
        TrmTrainFillin domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setTrmdepartid(trmdepart_id);
		trmtrainfillinService.create(domain);
        TrmTrainFillinDTO dto = trmtrainfillinMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos),'ehr-TrmTrainFillin-Create')")
    @ApiOperation(value = "根据培训需求通知批量建立培训需求填报", tags = {"培训需求填报" },  notes = "根据培训需求通知批量建立培训需求填报")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/batch")
    public ResponseEntity<Boolean> createBatchByTrmDepart(@PathVariable("trmdepart_id") String trmdepart_id, @RequestBody List<TrmTrainFillinDTO> trmtrainfillindtos) {
        List<TrmTrainFillin> domainlist=trmtrainfillinMapping.toDomain(trmtrainfillindtos);
        for(TrmTrainFillin domain:domainlist){
            domain.setTrmdepartid(trmdepart_id);
        }
        trmtrainfillinService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindto),'ehr-TrmTrainFillin-Save')")
    @ApiOperation(value = "根据培训需求通知保存培训需求填报", tags = {"培训需求填报" },  notes = "根据培训需求通知保存培训需求填报")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/save")
    public ResponseEntity<Boolean> saveByTrmDepart(@PathVariable("trmdepart_id") String trmdepart_id, @RequestBody TrmTrainFillinDTO trmtrainfillindto) {
        TrmTrainFillin domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setTrmdepartid(trmdepart_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos),'ehr-TrmTrainFillin-Save')")
    @ApiOperation(value = "根据培训需求通知批量保存培训需求填报", tags = {"培训需求填报" },  notes = "根据培训需求通知批量保存培训需求填报")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/savebatch")
    public ResponseEntity<Boolean> saveBatchByTrmDepart(@PathVariable("trmdepart_id") String trmdepart_id, @RequestBody List<TrmTrainFillinDTO> trmtrainfillindtos) {
        List<TrmTrainFillin> domainlist=trmtrainfillinMapping.toDomain(trmtrainfillindtos);
        for(TrmTrainFillin domain:domainlist){
             domain.setTrmdepartid(trmdepart_id);
        }
        trmtrainfillinService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据培训需求通知获取培训需求填报草稿", tags = {"培训需求填报" },  notes = "根据培训需求通知获取培训需求填报草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/getdraft")
    public ResponseEntity<TrmTrainFillinDTO> getDraftByTrmDepart(@PathVariable("trmdepart_id") String trmdepart_id) {
        TrmTrainFillin domain = new TrmTrainFillin();
        domain.setTrmdepartid(trmdepart_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinMapping.toDto(trmtrainfillinService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.get(#trmtrainfillin_id),'ehr-TrmTrainFillin-Remove')")
    @ApiOperation(value = "根据培训需求通知删除培训需求填报", tags = {"培训需求填报" },  notes = "根据培训需求通知删除培训需求填报")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/{trmtrainfillin_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByTrmDepart(@PathVariable("trmdepart_id") String trmdepart_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.remove(trmtrainfillin_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.getTrmtrainfillinByIds(#ids),'ehr-TrmTrainFillin-Remove')")
    @ApiOperation(value = "根据培训需求通知批量删除培训需求填报", tags = {"培训需求填报" },  notes = "根据培训需求通知批量删除培训需求填报")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/batch")
    public ResponseEntity<Boolean> removeBatchByTrmDepart(@RequestBody List<String> ids) {
        trmtrainfillinService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainFillin-Default-all')")
	@ApiOperation(value = "根据培训需求通知获取DEFAULT", tags = {"培训需求填报" } ,notes = "根据培训需求通知获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmdeparts/{trmdepart_id}/trmtrainfillins/fetchdefault")
	public ResponseEntity<List<TrmTrainFillinDTO>> fetchTrmTrainFillinDefaultByTrmDepart(@PathVariable("trmdepart_id") String trmdepart_id,TrmTrainFillinSearchContext context) {
        context.setN_trmdepartid_eq(trmdepart_id);
        Page<TrmTrainFillin> domains = trmtrainfillinService.searchDefault(context) ;
        List<TrmTrainFillinDTO> list = trmtrainfillinMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainFillin-Default-all')")
	@ApiOperation(value = "根据培训需求通知查询DEFAULT", tags = {"培训需求填报" } ,notes = "根据培训需求通知查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmdeparts/{trmdepart_id}/trmtrainfillins/searchdefault")
	public ResponseEntity<Page<TrmTrainFillinDTO>> searchTrmTrainFillinDefaultByTrmDepart(@PathVariable("trmdepart_id") String trmdepart_id, @RequestBody TrmTrainFillinSearchContext context) {
        context.setN_trmdepartid_eq(trmdepart_id);
        Page<TrmTrainFillin> domains = trmtrainfillinService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainfillinMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(returnObject.body),'ehr-TrmTrainFillin-Get')")
    @ApiOperation(value = "根据组织管理部门管理获取培训需求填报", tags = {"培训需求填报" },  notes = "根据组织管理部门管理获取培训需求填报")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}")
    public ResponseEntity<TrmTrainFillinDTO> getByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
        TrmTrainFillin domain = trmtrainfillinService.get(trmtrainfillin_id);
        TrmTrainFillinDTO dto = trmtrainfillinMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.get(#trmtrainfillin_id),'ehr-TrmTrainFillin-Update')")
    @ApiOperation(value = "根据组织管理部门管理更新培训需求填报", tags = {"培训需求填报" },  notes = "根据组织管理部门管理更新培训需求填报")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}")
    @Transactional
    public ResponseEntity<TrmTrainFillinDTO> updateByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody TrmTrainFillinDTO trmtrainfillindto) {
        TrmTrainFillin domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setOrmorgsectorid(ormorgsector_id);
        domain.setTrmtrainfillinid(trmtrainfillin_id);
		trmtrainfillinService.update(domain);
        TrmTrainFillinDTO dto = trmtrainfillinMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.getTrmtrainfillinByEntities(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos)),'ehr-TrmTrainFillin-Update')")
    @ApiOperation(value = "根据组织管理部门管理批量更新培训需求填报", tags = {"培训需求填报" },  notes = "根据组织管理部门管理批量更新培训需求填报")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<TrmTrainFillinDTO> trmtrainfillindtos) {
        List<TrmTrainFillin> domainlist=trmtrainfillinMapping.toDomain(trmtrainfillindtos);
        for(TrmTrainFillin domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        trmtrainfillinService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据组织管理部门管理检查培训需求填报", tags = {"培训需求填报" },  notes = "根据组织管理部门管理检查培训需求填报")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody TrmTrainFillinDTO trmtrainfillindto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.checkKey(trmtrainfillinMapping.toDomain(trmtrainfillindto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindto),'ehr-TrmTrainFillin-Create')")
    @ApiOperation(value = "根据组织管理部门管理建立培训需求填报", tags = {"培训需求填报" },  notes = "根据组织管理部门管理建立培训需求填报")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins")
    @Transactional
    public ResponseEntity<TrmTrainFillinDTO> createByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody TrmTrainFillinDTO trmtrainfillindto) {
        TrmTrainFillin domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setOrmorgsectorid(ormorgsector_id);
		trmtrainfillinService.create(domain);
        TrmTrainFillinDTO dto = trmtrainfillinMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos),'ehr-TrmTrainFillin-Create')")
    @ApiOperation(value = "根据组织管理部门管理批量建立培训需求填报", tags = {"培训需求填报" },  notes = "根据组织管理部门管理批量建立培训需求填报")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<TrmTrainFillinDTO> trmtrainfillindtos) {
        List<TrmTrainFillin> domainlist=trmtrainfillinMapping.toDomain(trmtrainfillindtos);
        for(TrmTrainFillin domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        trmtrainfillinService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindto),'ehr-TrmTrainFillin-Save')")
    @ApiOperation(value = "根据组织管理部门管理保存培训需求填报", tags = {"培训需求填报" },  notes = "根据组织管理部门管理保存培训需求填报")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/save")
    public ResponseEntity<Boolean> saveByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody TrmTrainFillinDTO trmtrainfillindto) {
        TrmTrainFillin domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos),'ehr-TrmTrainFillin-Save')")
    @ApiOperation(value = "根据组织管理部门管理批量保存培训需求填报", tags = {"培训需求填报" },  notes = "根据组织管理部门管理批量保存培训需求填报")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<TrmTrainFillinDTO> trmtrainfillindtos) {
        List<TrmTrainFillin> domainlist=trmtrainfillinMapping.toDomain(trmtrainfillindtos);
        for(TrmTrainFillin domain:domainlist){
             domain.setOrmorgsectorid(ormorgsector_id);
        }
        trmtrainfillinService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据组织管理部门管理获取培训需求填报草稿", tags = {"培训需求填报" },  notes = "根据组织管理部门管理获取培训需求填报草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/getdraft")
    public ResponseEntity<TrmTrainFillinDTO> getDraftByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id) {
        TrmTrainFillin domain = new TrmTrainFillin();
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinMapping.toDto(trmtrainfillinService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.get(#trmtrainfillin_id),'ehr-TrmTrainFillin-Remove')")
    @ApiOperation(value = "根据组织管理部门管理删除培训需求填报", tags = {"培训需求填报" },  notes = "根据组织管理部门管理删除培训需求填报")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.remove(trmtrainfillin_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.getTrmtrainfillinByIds(#ids),'ehr-TrmTrainFillin-Remove')")
    @ApiOperation(value = "根据组织管理部门管理批量删除培训需求填报", tags = {"培训需求填报" },  notes = "根据组织管理部门管理批量删除培训需求填报")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgOrmOrgsector(@RequestBody List<String> ids) {
        trmtrainfillinService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainFillin-Default-all')")
	@ApiOperation(value = "根据组织管理部门管理获取DEFAULT", tags = {"培训需求填报" } ,notes = "根据组织管理部门管理获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/fetchdefault")
	public ResponseEntity<List<TrmTrainFillinDTO>> fetchTrmTrainFillinDefaultByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id,TrmTrainFillinSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<TrmTrainFillin> domains = trmtrainfillinService.searchDefault(context) ;
        List<TrmTrainFillinDTO> list = trmtrainfillinMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainFillin-Default-all')")
	@ApiOperation(value = "根据组织管理部门管理查询DEFAULT", tags = {"培训需求填报" } ,notes = "根据组织管理部门管理查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/searchdefault")
	public ResponseEntity<Page<TrmTrainFillinDTO>> searchTrmTrainFillinDefaultByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody TrmTrainFillinSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<TrmTrainFillin> domains = trmtrainfillinService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainfillinMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

