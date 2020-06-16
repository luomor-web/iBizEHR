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
import cn.ibizlab.ehr.core.trm.domain.TrmCouarrange;
import cn.ibizlab.ehr.core.trm.service.ITrmCouarrangeService;
import cn.ibizlab.ehr.core.trm.filter.TrmCouarrangeSearchContext;

@Slf4j
@Api(tags = {"培训记录" })
@RestController("WebApi-trmcouarrange")
@RequestMapping("")
public class TrmCouarrangeResource {

    @Autowired
    public ITrmCouarrangeService trmcouarrangeService;

    @Autowired
    @Lazy
    public TrmCouarrangeMapping trmcouarrangeMapping;

    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedto),'ehr-TrmCouarrange-Create')")
    @ApiOperation(value = "新建培训记录", tags = {"培训记录" },  notes = "新建培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcouarranges")
    @Transactional
    public ResponseEntity<TrmCouarrangeDTO> create(@RequestBody TrmCouarrangeDTO trmcouarrangedto) {
        TrmCouarrange domain = trmcouarrangeMapping.toDomain(trmcouarrangedto);
		trmcouarrangeService.create(domain);
        TrmCouarrangeDTO dto = trmcouarrangeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedtos),'ehr-TrmCouarrange-Create')")
    @ApiOperation(value = "批量新建培训记录", tags = {"培训记录" },  notes = "批量新建培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcouarranges/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmCouarrangeDTO> trmcouarrangedtos) {
        trmcouarrangeService.createBatch(trmcouarrangeMapping.toDomain(trmcouarrangedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(returnObject.body),'ehr-TrmCouarrange-Get')")
    @ApiOperation(value = "获取培训记录", tags = {"培训记录" },  notes = "获取培训记录")
	@RequestMapping(method = RequestMethod.GET, value = "/trmcouarranges/{trmcouarrange_id}")
    public ResponseEntity<TrmCouarrangeDTO> get(@PathVariable("trmcouarrange_id") String trmcouarrange_id) {
        TrmCouarrange domain = trmcouarrangeService.get(trmcouarrange_id);
        TrmCouarrangeDTO dto = trmcouarrangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.get(#trmcouarrange_id),'ehr-TrmCouarrange-Remove')")
    @ApiOperation(value = "删除培训记录", tags = {"培训记录" },  notes = "删除培训记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmcouarranges/{trmcouarrange_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmcouarrange_id") String trmcouarrange_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeService.remove(trmcouarrange_id));
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.getTrmcouarrangeByIds(#ids),'ehr-TrmCouarrange-Remove')")
    @ApiOperation(value = "批量删除培训记录", tags = {"培训记录" },  notes = "批量删除培训记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmcouarranges/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmcouarrangeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取培训记录草稿", tags = {"培训记录" },  notes = "获取培训记录草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmcouarranges/getdraft")
    public ResponseEntity<TrmCouarrangeDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeMapping.toDto(trmcouarrangeService.getDraft(new TrmCouarrange())));
    }

    @ApiOperation(value = "检查培训记录", tags = {"培训记录" },  notes = "检查培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcouarranges/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmCouarrangeDTO trmcouarrangedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeService.checkKey(trmcouarrangeMapping.toDomain(trmcouarrangedto)));
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedto),'ehr-TrmCouarrange-Save')")
    @ApiOperation(value = "保存培训记录", tags = {"培训记录" },  notes = "保存培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcouarranges/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmCouarrangeDTO trmcouarrangedto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeService.save(trmcouarrangeMapping.toDomain(trmcouarrangedto)));
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedtos),'ehr-TrmCouarrange-Save')")
    @ApiOperation(value = "批量保存培训记录", tags = {"培训记录" },  notes = "批量保存培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcouarranges/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmCouarrangeDTO> trmcouarrangedtos) {
        trmcouarrangeService.saveBatch(trmcouarrangeMapping.toDomain(trmcouarrangedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.get(#trmcouarrange_id),'ehr-TrmCouarrange-Update')")
    @ApiOperation(value = "更新培训记录", tags = {"培训记录" },  notes = "更新培训记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmcouarranges/{trmcouarrange_id}")
    @Transactional
    public ResponseEntity<TrmCouarrangeDTO> update(@PathVariable("trmcouarrange_id") String trmcouarrange_id, @RequestBody TrmCouarrangeDTO trmcouarrangedto) {
		TrmCouarrange domain  = trmcouarrangeMapping.toDomain(trmcouarrangedto);
        domain .setTrmcouarrangeid(trmcouarrange_id);
		trmcouarrangeService.update(domain );
		TrmCouarrangeDTO dto = trmcouarrangeMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.getTrmcouarrangeByEntities(this.trmcouarrangeMapping.toDomain(#trmcouarrangedtos)),'ehr-TrmCouarrange-Update')")
    @ApiOperation(value = "批量更新培训记录", tags = {"培训记录" },  notes = "批量更新培训记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmcouarranges/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmCouarrangeDTO> trmcouarrangedtos) {
        trmcouarrangeService.updateBatch(trmcouarrangeMapping.toDomain(trmcouarrangedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmCouarrange-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"培训记录" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmcouarranges/fetchdefault")
	public ResponseEntity<List<TrmCouarrangeDTO>> fetchDefault(TrmCouarrangeSearchContext context) {
        Page<TrmCouarrange> domains = trmcouarrangeService.searchDefault(context) ;
        List<TrmCouarrangeDTO> list = trmcouarrangeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmCouarrange-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"培训记录" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmcouarranges/searchdefault")
	public ResponseEntity<Page<TrmCouarrangeDTO>> searchDefault(@RequestBody TrmCouarrangeSearchContext context) {
        Page<TrmCouarrange> domains = trmcouarrangeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmcouarrangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedto),'ehr-TrmCouarrange-Create')")
    @ApiOperation(value = "根据培训机构建立培训记录", tags = {"培训记录" },  notes = "根据培训机构建立培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmcouarranges")
    @Transactional
    public ResponseEntity<TrmCouarrangeDTO> createByTrmTrainAgency(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @RequestBody TrmCouarrangeDTO trmcouarrangedto) {
        TrmCouarrange domain = trmcouarrangeMapping.toDomain(trmcouarrangedto);
        domain.setTrmtrainagencyid(trmtrainagency_id);
		trmcouarrangeService.create(domain);
        TrmCouarrangeDTO dto = trmcouarrangeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedtos),'ehr-TrmCouarrange-Create')")
    @ApiOperation(value = "根据培训机构批量建立培训记录", tags = {"培训记录" },  notes = "根据培训机构批量建立培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmcouarranges/batch")
    public ResponseEntity<Boolean> createBatchByTrmTrainAgency(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @RequestBody List<TrmCouarrangeDTO> trmcouarrangedtos) {
        List<TrmCouarrange> domainlist=trmcouarrangeMapping.toDomain(trmcouarrangedtos);
        for(TrmCouarrange domain:domainlist){
            domain.setTrmtrainagencyid(trmtrainagency_id);
        }
        trmcouarrangeService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(returnObject.body),'ehr-TrmCouarrange-Get')")
    @ApiOperation(value = "根据培训机构获取培训记录", tags = {"培训记录" },  notes = "根据培训机构获取培训记录")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainagencies/{trmtrainagency_id}/trmcouarranges/{trmcouarrange_id}")
    public ResponseEntity<TrmCouarrangeDTO> getByTrmTrainAgency(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmcouarrange_id") String trmcouarrange_id) {
        TrmCouarrange domain = trmcouarrangeService.get(trmcouarrange_id);
        TrmCouarrangeDTO dto = trmcouarrangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.get(#trmcouarrange_id),'ehr-TrmCouarrange-Remove')")
    @ApiOperation(value = "根据培训机构删除培训记录", tags = {"培训记录" },  notes = "根据培训机构删除培训记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainagencies/{trmtrainagency_id}/trmcouarranges/{trmcouarrange_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByTrmTrainAgency(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmcouarrange_id") String trmcouarrange_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeService.remove(trmcouarrange_id));
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.getTrmcouarrangeByIds(#ids),'ehr-TrmCouarrange-Remove')")
    @ApiOperation(value = "根据培训机构批量删除培训记录", tags = {"培训记录" },  notes = "根据培训机构批量删除培训记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainagencies/{trmtrainagency_id}/trmcouarranges/batch")
    public ResponseEntity<Boolean> removeBatchByTrmTrainAgency(@RequestBody List<String> ids) {
        trmcouarrangeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据培训机构获取培训记录草稿", tags = {"培训记录" },  notes = "根据培训机构获取培训记录草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/trmtrainagencies/{trmtrainagency_id}/trmcouarranges/getdraft")
    public ResponseEntity<TrmCouarrangeDTO> getDraftByTrmTrainAgency(@PathVariable("trmtrainagency_id") String trmtrainagency_id) {
        TrmCouarrange domain = new TrmCouarrange();
        domain.setTrmtrainagencyid(trmtrainagency_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeMapping.toDto(trmcouarrangeService.getDraft(domain)));
    }

    @ApiOperation(value = "根据培训机构检查培训记录", tags = {"培训记录" },  notes = "根据培训机构检查培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmcouarranges/checkkey")
    public ResponseEntity<Boolean> checkKeyByTrmTrainAgency(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @RequestBody TrmCouarrangeDTO trmcouarrangedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeService.checkKey(trmcouarrangeMapping.toDomain(trmcouarrangedto)));
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedto),'ehr-TrmCouarrange-Save')")
    @ApiOperation(value = "根据培训机构保存培训记录", tags = {"培训记录" },  notes = "根据培训机构保存培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmcouarranges/save")
    public ResponseEntity<Boolean> saveByTrmTrainAgency(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @RequestBody TrmCouarrangeDTO trmcouarrangedto) {
        TrmCouarrange domain = trmcouarrangeMapping.toDomain(trmcouarrangedto);
        domain.setTrmtrainagencyid(trmtrainagency_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmcouarrangeService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeMapping.toDomain(#trmcouarrangedtos),'ehr-TrmCouarrange-Save')")
    @ApiOperation(value = "根据培训机构批量保存培训记录", tags = {"培训记录" },  notes = "根据培训机构批量保存培训记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmcouarranges/savebatch")
    public ResponseEntity<Boolean> saveBatchByTrmTrainAgency(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @RequestBody List<TrmCouarrangeDTO> trmcouarrangedtos) {
        List<TrmCouarrange> domainlist=trmcouarrangeMapping.toDomain(trmcouarrangedtos);
        for(TrmCouarrange domain:domainlist){
             domain.setTrmtrainagencyid(trmtrainagency_id);
        }
        trmcouarrangeService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.get(#trmcouarrange_id),'ehr-TrmCouarrange-Update')")
    @ApiOperation(value = "根据培训机构更新培训记录", tags = {"培训记录" },  notes = "根据培训机构更新培训记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainagencies/{trmtrainagency_id}/trmcouarranges/{trmcouarrange_id}")
    @Transactional
    public ResponseEntity<TrmCouarrangeDTO> updateByTrmTrainAgency(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmcouarrange_id") String trmcouarrange_id, @RequestBody TrmCouarrangeDTO trmcouarrangedto) {
        TrmCouarrange domain = trmcouarrangeMapping.toDomain(trmcouarrangedto);
        domain.setTrmtrainagencyid(trmtrainagency_id);
        domain.setTrmcouarrangeid(trmcouarrange_id);
		trmcouarrangeService.update(domain);
        TrmCouarrangeDTO dto = trmcouarrangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmcouarrangeService.getTrmcouarrangeByEntities(this.trmcouarrangeMapping.toDomain(#trmcouarrangedtos)),'ehr-TrmCouarrange-Update')")
    @ApiOperation(value = "根据培训机构批量更新培训记录", tags = {"培训记录" },  notes = "根据培训机构批量更新培训记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainagencies/{trmtrainagency_id}/trmcouarranges/batch")
    public ResponseEntity<Boolean> updateBatchByTrmTrainAgency(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @RequestBody List<TrmCouarrangeDTO> trmcouarrangedtos) {
        List<TrmCouarrange> domainlist=trmcouarrangeMapping.toDomain(trmcouarrangedtos);
        for(TrmCouarrange domain:domainlist){
            domain.setTrmtrainagencyid(trmtrainagency_id);
        }
        trmcouarrangeService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmCouarrange-Default-all')")
	@ApiOperation(value = "根据培训机构获取DEFAULT", tags = {"培训记录" } ,notes = "根据培训机构获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainagencies/{trmtrainagency_id}/trmcouarranges/fetchdefault")
	public ResponseEntity<List<TrmCouarrangeDTO>> fetchTrmCouarrangeDefaultByTrmTrainAgency(@PathVariable("trmtrainagency_id") String trmtrainagency_id,TrmCouarrangeSearchContext context) {
        context.setN_trmtrainagencyid_eq(trmtrainagency_id);
        Page<TrmCouarrange> domains = trmcouarrangeService.searchDefault(context) ;
        List<TrmCouarrangeDTO> list = trmcouarrangeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmCouarrange-Default-all')")
	@ApiOperation(value = "根据培训机构查询DEFAULT", tags = {"培训记录" } ,notes = "根据培训机构查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainagencies/{trmtrainagency_id}/trmcouarranges/searchdefault")
	public ResponseEntity<Page<TrmCouarrangeDTO>> searchTrmCouarrangeDefaultByTrmTrainAgency(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @RequestBody TrmCouarrangeSearchContext context) {
        context.setN_trmtrainagencyid_eq(trmtrainagency_id);
        Page<TrmCouarrange> domains = trmcouarrangeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmcouarrangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

