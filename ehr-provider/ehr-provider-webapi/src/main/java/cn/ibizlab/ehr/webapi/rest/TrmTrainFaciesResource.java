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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainFacies;
import cn.ibizlab.ehr.core.trm.service.ITrmTrainFaciesService;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainFaciesSearchContext;

@Slf4j
@Api(tags = {"培训设施" })
@RestController("WebApi-trmtrainfacies")
@RequestMapping("")
public class TrmTrainFaciesResource {

    @Autowired
    public ITrmTrainFaciesService trmtrainfaciesService;

    @Autowired
    @Lazy
    public TrmTrainFaciesMapping trmtrainfaciesMapping;

    @ApiOperation(value = "检查培训设施", tags = {"培训设施" },  notes = "检查培训设施")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfacies/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmTrainFaciesDTO trmtrainfaciesdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainfaciesService.checkKey(trmtrainfaciesMapping.toDomain(trmtrainfaciesdto)));
    }

    @ApiOperation(value = "获取培训设施草稿", tags = {"培训设施" },  notes = "获取培训设施草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainfacies/getdraft")
    public ResponseEntity<TrmTrainFaciesDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfaciesMapping.toDto(trmtrainfaciesService.getDraft(new TrmTrainFacies())));
    }

    @PreAuthorize("hasPermission(this.trmtrainfaciesService.get(#trmtrainfacies_id),'ehr-TrmTrainFacies-Update')")
    @ApiOperation(value = "更新培训设施", tags = {"培训设施" },  notes = "更新培训设施")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainfacies/{trmtrainfacies_id}")
    @Transactional
    public ResponseEntity<TrmTrainFaciesDTO> update(@PathVariable("trmtrainfacies_id") String trmtrainfacies_id, @RequestBody TrmTrainFaciesDTO trmtrainfaciesdto) {
		TrmTrainFacies domain  = trmtrainfaciesMapping.toDomain(trmtrainfaciesdto);
        domain .setTrmtrainfaciesid(trmtrainfacies_id);
		trmtrainfaciesService.update(domain );
		TrmTrainFaciesDTO dto = trmtrainfaciesMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfaciesService.getTrmtrainfaciesByEntities(this.trmtrainfaciesMapping.toDomain(#trmtrainfaciesdtos)),'ehr-TrmTrainFacies-Update')")
    @ApiOperation(value = "批量更新培训设施", tags = {"培训设施" },  notes = "批量更新培训设施")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainfacies/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmTrainFaciesDTO> trmtrainfaciesdtos) {
        trmtrainfaciesService.updateBatch(trmtrainfaciesMapping.toDomain(trmtrainfaciesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainfaciesMapping.toDomain(#trmtrainfaciesdto),'ehr-TrmTrainFacies-Create')")
    @ApiOperation(value = "新建培训设施", tags = {"培训设施" },  notes = "新建培训设施")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfacies")
    @Transactional
    public ResponseEntity<TrmTrainFaciesDTO> create(@RequestBody TrmTrainFaciesDTO trmtrainfaciesdto) {
        TrmTrainFacies domain = trmtrainfaciesMapping.toDomain(trmtrainfaciesdto);
		trmtrainfaciesService.create(domain);
        TrmTrainFaciesDTO dto = trmtrainfaciesMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfaciesMapping.toDomain(#trmtrainfaciesdtos),'ehr-TrmTrainFacies-Create')")
    @ApiOperation(value = "批量新建培训设施", tags = {"培训设施" },  notes = "批量新建培训设施")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfacies/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmTrainFaciesDTO> trmtrainfaciesdtos) {
        trmtrainfaciesService.createBatch(trmtrainfaciesMapping.toDomain(trmtrainfaciesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainfaciesService.get(#trmtrainfacies_id),'ehr-TrmTrainFacies-Remove')")
    @ApiOperation(value = "删除培训设施", tags = {"培训设施" },  notes = "删除培训设施")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainfacies/{trmtrainfacies_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtrainfacies_id") String trmtrainfacies_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtrainfaciesService.remove(trmtrainfacies_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainfaciesService.getTrmtrainfaciesByIds(#ids),'ehr-TrmTrainFacies-Remove')")
    @ApiOperation(value = "批量删除培训设施", tags = {"培训设施" },  notes = "批量删除培训设施")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainfacies/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtrainfaciesService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainfaciesMapping.toDomain(#trmtrainfaciesdto),'ehr-TrmTrainFacies-Save')")
    @ApiOperation(value = "保存培训设施", tags = {"培训设施" },  notes = "保存培训设施")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfacies/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmTrainFaciesDTO trmtrainfaciesdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfaciesService.save(trmtrainfaciesMapping.toDomain(trmtrainfaciesdto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainfaciesMapping.toDomain(#trmtrainfaciesdtos),'ehr-TrmTrainFacies-Save')")
    @ApiOperation(value = "批量保存培训设施", tags = {"培训设施" },  notes = "批量保存培训设施")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfacies/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmTrainFaciesDTO> trmtrainfaciesdtos) {
        trmtrainfaciesService.saveBatch(trmtrainfaciesMapping.toDomain(trmtrainfaciesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmtrainfaciesMapping.toDomain(returnObject.body),'ehr-TrmTrainFacies-Get')")
    @ApiOperation(value = "获取培训设施", tags = {"培训设施" },  notes = "获取培训设施")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainfacies/{trmtrainfacies_id}")
    public ResponseEntity<TrmTrainFaciesDTO> get(@PathVariable("trmtrainfacies_id") String trmtrainfacies_id) {
        TrmTrainFacies domain = trmtrainfaciesService.get(trmtrainfacies_id);
        TrmTrainFaciesDTO dto = trmtrainfaciesMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainFacies-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"培训设施" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainfacies/fetchdefault")
	public ResponseEntity<List<TrmTrainFaciesDTO>> fetchDefault(TrmTrainFaciesSearchContext context) {
        Page<TrmTrainFacies> domains = trmtrainfaciesService.searchDefault(context) ;
        List<TrmTrainFaciesDTO> list = trmtrainfaciesMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainFacies-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"培训设施" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainfacies/searchdefault")
	public ResponseEntity<Page<TrmTrainFaciesDTO>> searchDefault(@RequestBody TrmTrainFaciesSearchContext context) {
        Page<TrmTrainFacies> domains = trmtrainfaciesService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainfaciesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据培训场地检查培训设施", tags = {"培训设施" },  notes = "根据培训场地检查培训设施")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmtrainfacies/checkkey")
    public ResponseEntity<Boolean> checkKeyByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @RequestBody TrmTrainFaciesDTO trmtrainfaciesdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainfaciesService.checkKey(trmtrainfaciesMapping.toDomain(trmtrainfaciesdto)));
    }

    @ApiOperation(value = "根据培训场地获取培训设施草稿", tags = {"培训设施" },  notes = "根据培训场地获取培训设施草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmtrainfacies/getdraft")
    public ResponseEntity<TrmTrainFaciesDTO> getDraftByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id) {
        TrmTrainFacies domain = new TrmTrainFacies();
        domain.setTrmtrainaddressid(trmtrainaddress_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfaciesMapping.toDto(trmtrainfaciesService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.trmtrainfaciesService.get(#trmtrainfacies_id),'ehr-TrmTrainFacies-Update')")
    @ApiOperation(value = "根据培训场地更新培训设施", tags = {"培训设施" },  notes = "根据培训场地更新培训设施")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmtrainfacies/{trmtrainfacies_id}")
    @Transactional
    public ResponseEntity<TrmTrainFaciesDTO> updateByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @PathVariable("trmtrainfacies_id") String trmtrainfacies_id, @RequestBody TrmTrainFaciesDTO trmtrainfaciesdto) {
        TrmTrainFacies domain = trmtrainfaciesMapping.toDomain(trmtrainfaciesdto);
        domain.setTrmtrainaddressid(trmtrainaddress_id);
        domain.setTrmtrainfaciesid(trmtrainfacies_id);
		trmtrainfaciesService.update(domain);
        TrmTrainFaciesDTO dto = trmtrainfaciesMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfaciesService.getTrmtrainfaciesByEntities(this.trmtrainfaciesMapping.toDomain(#trmtrainfaciesdtos)),'ehr-TrmTrainFacies-Update')")
    @ApiOperation(value = "根据培训场地批量更新培训设施", tags = {"培训设施" },  notes = "根据培训场地批量更新培训设施")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmtrainfacies/batch")
    public ResponseEntity<Boolean> updateBatchByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @RequestBody List<TrmTrainFaciesDTO> trmtrainfaciesdtos) {
        List<TrmTrainFacies> domainlist=trmtrainfaciesMapping.toDomain(trmtrainfaciesdtos);
        for(TrmTrainFacies domain:domainlist){
            domain.setTrmtrainaddressid(trmtrainaddress_id);
        }
        trmtrainfaciesService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainfaciesMapping.toDomain(#trmtrainfaciesdto),'ehr-TrmTrainFacies-Create')")
    @ApiOperation(value = "根据培训场地建立培训设施", tags = {"培训设施" },  notes = "根据培训场地建立培训设施")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmtrainfacies")
    @Transactional
    public ResponseEntity<TrmTrainFaciesDTO> createByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @RequestBody TrmTrainFaciesDTO trmtrainfaciesdto) {
        TrmTrainFacies domain = trmtrainfaciesMapping.toDomain(trmtrainfaciesdto);
        domain.setTrmtrainaddressid(trmtrainaddress_id);
		trmtrainfaciesService.create(domain);
        TrmTrainFaciesDTO dto = trmtrainfaciesMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfaciesMapping.toDomain(#trmtrainfaciesdtos),'ehr-TrmTrainFacies-Create')")
    @ApiOperation(value = "根据培训场地批量建立培训设施", tags = {"培训设施" },  notes = "根据培训场地批量建立培训设施")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmtrainfacies/batch")
    public ResponseEntity<Boolean> createBatchByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @RequestBody List<TrmTrainFaciesDTO> trmtrainfaciesdtos) {
        List<TrmTrainFacies> domainlist=trmtrainfaciesMapping.toDomain(trmtrainfaciesdtos);
        for(TrmTrainFacies domain:domainlist){
            domain.setTrmtrainaddressid(trmtrainaddress_id);
        }
        trmtrainfaciesService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainfaciesService.get(#trmtrainfacies_id),'ehr-TrmTrainFacies-Remove')")
    @ApiOperation(value = "根据培训场地删除培训设施", tags = {"培训设施" },  notes = "根据培训场地删除培训设施")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmtrainfacies/{trmtrainfacies_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @PathVariable("trmtrainfacies_id") String trmtrainfacies_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmtrainfaciesService.remove(trmtrainfacies_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainfaciesService.getTrmtrainfaciesByIds(#ids),'ehr-TrmTrainFacies-Remove')")
    @ApiOperation(value = "根据培训场地批量删除培训设施", tags = {"培训设施" },  notes = "根据培训场地批量删除培训设施")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmtrainfacies/batch")
    public ResponseEntity<Boolean> removeBatchByTrmTrainAddress(@RequestBody List<String> ids) {
        trmtrainfaciesService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainfaciesMapping.toDomain(#trmtrainfaciesdto),'ehr-TrmTrainFacies-Save')")
    @ApiOperation(value = "根据培训场地保存培训设施", tags = {"培训设施" },  notes = "根据培训场地保存培训设施")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmtrainfacies/save")
    public ResponseEntity<Boolean> saveByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @RequestBody TrmTrainFaciesDTO trmtrainfaciesdto) {
        TrmTrainFacies domain = trmtrainfaciesMapping.toDomain(trmtrainfaciesdto);
        domain.setTrmtrainaddressid(trmtrainaddress_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfaciesService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmtrainfaciesMapping.toDomain(#trmtrainfaciesdtos),'ehr-TrmTrainFacies-Save')")
    @ApiOperation(value = "根据培训场地批量保存培训设施", tags = {"培训设施" },  notes = "根据培训场地批量保存培训设施")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmtrainfacies/savebatch")
    public ResponseEntity<Boolean> saveBatchByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @RequestBody List<TrmTrainFaciesDTO> trmtrainfaciesdtos) {
        List<TrmTrainFacies> domainlist=trmtrainfaciesMapping.toDomain(trmtrainfaciesdtos);
        for(TrmTrainFacies domain:domainlist){
             domain.setTrmtrainaddressid(trmtrainaddress_id);
        }
        trmtrainfaciesService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmtrainfaciesMapping.toDomain(returnObject.body),'ehr-TrmTrainFacies-Get')")
    @ApiOperation(value = "根据培训场地获取培训设施", tags = {"培训设施" },  notes = "根据培训场地获取培训设施")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmtrainfacies/{trmtrainfacies_id}")
    public ResponseEntity<TrmTrainFaciesDTO> getByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @PathVariable("trmtrainfacies_id") String trmtrainfacies_id) {
        TrmTrainFacies domain = trmtrainfaciesService.get(trmtrainfacies_id);
        TrmTrainFaciesDTO dto = trmtrainfaciesMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainFacies-Default-all')")
	@ApiOperation(value = "根据培训场地获取DEFAULT", tags = {"培训设施" } ,notes = "根据培训场地获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainaddresses/{trmtrainaddress_id}/trmtrainfacies/fetchdefault")
	public ResponseEntity<List<TrmTrainFaciesDTO>> fetchTrmTrainFaciesDefaultByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id,TrmTrainFaciesSearchContext context) {
        context.setN_trmtrainaddressid_eq(trmtrainaddress_id);
        Page<TrmTrainFacies> domains = trmtrainfaciesService.searchDefault(context) ;
        List<TrmTrainFaciesDTO> list = trmtrainfaciesMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainFacies-Default-all')")
	@ApiOperation(value = "根据培训场地查询DEFAULT", tags = {"培训设施" } ,notes = "根据培训场地查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainaddresses/{trmtrainaddress_id}/trmtrainfacies/searchdefault")
	public ResponseEntity<Page<TrmTrainFaciesDTO>> searchTrmTrainFaciesDefaultByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @RequestBody TrmTrainFaciesSearchContext context) {
        context.setN_trmtrainaddressid_eq(trmtrainaddress_id);
        Page<TrmTrainFacies> domains = trmtrainfaciesService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainfaciesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

