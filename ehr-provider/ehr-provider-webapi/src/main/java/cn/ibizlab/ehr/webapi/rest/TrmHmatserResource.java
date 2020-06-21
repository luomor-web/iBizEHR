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
import cn.ibizlab.ehr.core.trm.domain.TrmHmatser;
import cn.ibizlab.ehr.core.trm.service.ITrmHmatserService;
import cn.ibizlab.ehr.core.trm.filter.TrmHmatserSearchContext;

@Slf4j
@Api(tags = {"班主任" })
@RestController("WebApi-trmhmatser")
@RequestMapping("")
public class TrmHmatserResource {

    @Autowired
    public ITrmHmatserService trmhmatserService;

    @Autowired
    @Lazy
    public TrmHmatserMapping trmhmatserMapping;

    @PreAuthorize("hasPermission(this.trmhmatserService.get(#trmhmatser_id),'ehr-TrmHmatser-Remove')")
    @ApiOperation(value = "删除班主任", tags = {"班主任" },  notes = "删除班主任")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmhmatsers/{trmhmatser_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmhmatser_id") String trmhmatser_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmhmatserService.remove(trmhmatser_id));
    }

    @PreAuthorize("hasPermission(this.trmhmatserService.getTrmhmatserByIds(#ids),'ehr-TrmHmatser-Remove')")
    @ApiOperation(value = "批量删除班主任", tags = {"班主任" },  notes = "批量删除班主任")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmhmatsers/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmhmatserService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmhmatserMapping.toDomain(#trmhmatserdto),'ehr-TrmHmatser-Save')")
    @ApiOperation(value = "保存班主任", tags = {"班主任" },  notes = "保存班主任")
	@RequestMapping(method = RequestMethod.POST, value = "/trmhmatsers/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmHmatserDTO trmhmatserdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmhmatserService.save(trmhmatserMapping.toDomain(trmhmatserdto)));
    }

    @PreAuthorize("hasPermission(this.trmhmatserMapping.toDomain(#trmhmatserdtos),'ehr-TrmHmatser-Save')")
    @ApiOperation(value = "批量保存班主任", tags = {"班主任" },  notes = "批量保存班主任")
	@RequestMapping(method = RequestMethod.POST, value = "/trmhmatsers/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmHmatserDTO> trmhmatserdtos) {
        trmhmatserService.saveBatch(trmhmatserMapping.toDomain(trmhmatserdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmhmatserService.get(#trmhmatser_id),'ehr-TrmHmatser-Update')")
    @ApiOperation(value = "更新班主任", tags = {"班主任" },  notes = "更新班主任")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmhmatsers/{trmhmatser_id}")
    @Transactional
    public ResponseEntity<TrmHmatserDTO> update(@PathVariable("trmhmatser_id") String trmhmatser_id, @RequestBody TrmHmatserDTO trmhmatserdto) {
		TrmHmatser domain  = trmhmatserMapping.toDomain(trmhmatserdto);
        domain .setTrmhmatserid(trmhmatser_id);
		trmhmatserService.update(domain );
		TrmHmatserDTO dto = trmhmatserMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmhmatserService.getTrmhmatserByEntities(this.trmhmatserMapping.toDomain(#trmhmatserdtos)),'ehr-TrmHmatser-Update')")
    @ApiOperation(value = "批量更新班主任", tags = {"班主任" },  notes = "批量更新班主任")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmhmatsers/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmHmatserDTO> trmhmatserdtos) {
        trmhmatserService.updateBatch(trmhmatserMapping.toDomain(trmhmatserdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmhmatserMapping.toDomain(#trmhmatserdto),'ehr-TrmHmatser-Create')")
    @ApiOperation(value = "新建班主任", tags = {"班主任" },  notes = "新建班主任")
	@RequestMapping(method = RequestMethod.POST, value = "/trmhmatsers")
    @Transactional
    public ResponseEntity<TrmHmatserDTO> create(@RequestBody TrmHmatserDTO trmhmatserdto) {
        TrmHmatser domain = trmhmatserMapping.toDomain(trmhmatserdto);
		trmhmatserService.create(domain);
        TrmHmatserDTO dto = trmhmatserMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmhmatserMapping.toDomain(#trmhmatserdtos),'ehr-TrmHmatser-Create')")
    @ApiOperation(value = "批量新建班主任", tags = {"班主任" },  notes = "批量新建班主任")
	@RequestMapping(method = RequestMethod.POST, value = "/trmhmatsers/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmHmatserDTO> trmhmatserdtos) {
        trmhmatserService.createBatch(trmhmatserMapping.toDomain(trmhmatserdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查班主任", tags = {"班主任" },  notes = "检查班主任")
	@RequestMapping(method = RequestMethod.POST, value = "/trmhmatsers/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmHmatserDTO trmhmatserdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmhmatserService.checkKey(trmhmatserMapping.toDomain(trmhmatserdto)));
    }

    @ApiOperation(value = "获取班主任草稿", tags = {"班主任" },  notes = "获取班主任草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmhmatsers/getdraft")
    public ResponseEntity<TrmHmatserDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmhmatserMapping.toDto(trmhmatserService.getDraft(new TrmHmatser())));
    }

    @PostAuthorize("hasPermission(this.trmhmatserMapping.toDomain(returnObject.body),'ehr-TrmHmatser-Get')")
    @ApiOperation(value = "获取班主任", tags = {"班主任" },  notes = "获取班主任")
	@RequestMapping(method = RequestMethod.GET, value = "/trmhmatsers/{trmhmatser_id}")
    public ResponseEntity<TrmHmatserDTO> get(@PathVariable("trmhmatser_id") String trmhmatser_id) {
        TrmHmatser domain = trmhmatserService.get(trmhmatser_id);
        TrmHmatserDTO dto = trmhmatserMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmHmatser-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"班主任" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmhmatsers/fetchdefault")
	public ResponseEntity<List<TrmHmatserDTO>> fetchDefault(TrmHmatserSearchContext context) {
        Page<TrmHmatser> domains = trmhmatserService.searchDefault(context) ;
        List<TrmHmatserDTO> list = trmhmatserMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmHmatser-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"班主任" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmhmatsers/searchdefault")
	public ResponseEntity<Page<TrmHmatserDTO>> searchDefault(@RequestBody TrmHmatserSearchContext context) {
        Page<TrmHmatser> domains = trmhmatserService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmhmatserMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.trmhmatserService.get(#trmhmatser_id),'ehr-TrmHmatser-Remove')")
    @ApiOperation(value = "根据培训机构删除班主任", tags = {"班主任" },  notes = "根据培训机构删除班主任")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainagencies/{trmtrainagency_id}/trmhmatsers/{trmhmatser_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByTrmTrainAgency(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmhmatser_id") String trmhmatser_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmhmatserService.remove(trmhmatser_id));
    }

    @PreAuthorize("hasPermission(this.trmhmatserService.getTrmhmatserByIds(#ids),'ehr-TrmHmatser-Remove')")
    @ApiOperation(value = "根据培训机构批量删除班主任", tags = {"班主任" },  notes = "根据培训机构批量删除班主任")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainagencies/{trmtrainagency_id}/trmhmatsers/batch")
    public ResponseEntity<Boolean> removeBatchByTrmTrainAgency(@RequestBody List<String> ids) {
        trmhmatserService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmhmatserMapping.toDomain(#trmhmatserdto),'ehr-TrmHmatser-Save')")
    @ApiOperation(value = "根据培训机构保存班主任", tags = {"班主任" },  notes = "根据培训机构保存班主任")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmhmatsers/save")
    public ResponseEntity<Boolean> saveByTrmTrainAgency(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @RequestBody TrmHmatserDTO trmhmatserdto) {
        TrmHmatser domain = trmhmatserMapping.toDomain(trmhmatserdto);
        domain.setTrmtrainagencyid(trmtrainagency_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmhmatserService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmhmatserMapping.toDomain(#trmhmatserdtos),'ehr-TrmHmatser-Save')")
    @ApiOperation(value = "根据培训机构批量保存班主任", tags = {"班主任" },  notes = "根据培训机构批量保存班主任")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmhmatsers/savebatch")
    public ResponseEntity<Boolean> saveBatchByTrmTrainAgency(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @RequestBody List<TrmHmatserDTO> trmhmatserdtos) {
        List<TrmHmatser> domainlist=trmhmatserMapping.toDomain(trmhmatserdtos);
        for(TrmHmatser domain:domainlist){
             domain.setTrmtrainagencyid(trmtrainagency_id);
        }
        trmhmatserService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmhmatserService.get(#trmhmatser_id),'ehr-TrmHmatser-Update')")
    @ApiOperation(value = "根据培训机构更新班主任", tags = {"班主任" },  notes = "根据培训机构更新班主任")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainagencies/{trmtrainagency_id}/trmhmatsers/{trmhmatser_id}")
    @Transactional
    public ResponseEntity<TrmHmatserDTO> updateByTrmTrainAgency(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmhmatser_id") String trmhmatser_id, @RequestBody TrmHmatserDTO trmhmatserdto) {
        TrmHmatser domain = trmhmatserMapping.toDomain(trmhmatserdto);
        domain.setTrmtrainagencyid(trmtrainagency_id);
        domain.setTrmhmatserid(trmhmatser_id);
		trmhmatserService.update(domain);
        TrmHmatserDTO dto = trmhmatserMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmhmatserService.getTrmhmatserByEntities(this.trmhmatserMapping.toDomain(#trmhmatserdtos)),'ehr-TrmHmatser-Update')")
    @ApiOperation(value = "根据培训机构批量更新班主任", tags = {"班主任" },  notes = "根据培训机构批量更新班主任")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainagencies/{trmtrainagency_id}/trmhmatsers/batch")
    public ResponseEntity<Boolean> updateBatchByTrmTrainAgency(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @RequestBody List<TrmHmatserDTO> trmhmatserdtos) {
        List<TrmHmatser> domainlist=trmhmatserMapping.toDomain(trmhmatserdtos);
        for(TrmHmatser domain:domainlist){
            domain.setTrmtrainagencyid(trmtrainagency_id);
        }
        trmhmatserService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmhmatserMapping.toDomain(#trmhmatserdto),'ehr-TrmHmatser-Create')")
    @ApiOperation(value = "根据培训机构建立班主任", tags = {"班主任" },  notes = "根据培训机构建立班主任")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmhmatsers")
    @Transactional
    public ResponseEntity<TrmHmatserDTO> createByTrmTrainAgency(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @RequestBody TrmHmatserDTO trmhmatserdto) {
        TrmHmatser domain = trmhmatserMapping.toDomain(trmhmatserdto);
        domain.setTrmtrainagencyid(trmtrainagency_id);
		trmhmatserService.create(domain);
        TrmHmatserDTO dto = trmhmatserMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmhmatserMapping.toDomain(#trmhmatserdtos),'ehr-TrmHmatser-Create')")
    @ApiOperation(value = "根据培训机构批量建立班主任", tags = {"班主任" },  notes = "根据培训机构批量建立班主任")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmhmatsers/batch")
    public ResponseEntity<Boolean> createBatchByTrmTrainAgency(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @RequestBody List<TrmHmatserDTO> trmhmatserdtos) {
        List<TrmHmatser> domainlist=trmhmatserMapping.toDomain(trmhmatserdtos);
        for(TrmHmatser domain:domainlist){
            domain.setTrmtrainagencyid(trmtrainagency_id);
        }
        trmhmatserService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据培训机构检查班主任", tags = {"班主任" },  notes = "根据培训机构检查班主任")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmhmatsers/checkkey")
    public ResponseEntity<Boolean> checkKeyByTrmTrainAgency(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @RequestBody TrmHmatserDTO trmhmatserdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmhmatserService.checkKey(trmhmatserMapping.toDomain(trmhmatserdto)));
    }

    @ApiOperation(value = "根据培训机构获取班主任草稿", tags = {"班主任" },  notes = "根据培训机构获取班主任草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/trmtrainagencies/{trmtrainagency_id}/trmhmatsers/getdraft")
    public ResponseEntity<TrmHmatserDTO> getDraftByTrmTrainAgency(@PathVariable("trmtrainagency_id") String trmtrainagency_id) {
        TrmHmatser domain = new TrmHmatser();
        domain.setTrmtrainagencyid(trmtrainagency_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmhmatserMapping.toDto(trmhmatserService.getDraft(domain)));
    }

    @PostAuthorize("hasPermission(this.trmhmatserMapping.toDomain(returnObject.body),'ehr-TrmHmatser-Get')")
    @ApiOperation(value = "根据培训机构获取班主任", tags = {"班主任" },  notes = "根据培训机构获取班主任")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainagencies/{trmtrainagency_id}/trmhmatsers/{trmhmatser_id}")
    public ResponseEntity<TrmHmatserDTO> getByTrmTrainAgency(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmhmatser_id") String trmhmatser_id) {
        TrmHmatser domain = trmhmatserService.get(trmhmatser_id);
        TrmHmatserDTO dto = trmhmatserMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmHmatser-Default-all')")
	@ApiOperation(value = "根据培训机构获取DEFAULT", tags = {"班主任" } ,notes = "根据培训机构获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainagencies/{trmtrainagency_id}/trmhmatsers/fetchdefault")
	public ResponseEntity<List<TrmHmatserDTO>> fetchTrmHmatserDefaultByTrmTrainAgency(@PathVariable("trmtrainagency_id") String trmtrainagency_id,TrmHmatserSearchContext context) {
        context.setN_trmtrainagencyid_eq(trmtrainagency_id);
        Page<TrmHmatser> domains = trmhmatserService.searchDefault(context) ;
        List<TrmHmatserDTO> list = trmhmatserMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmHmatser-Default-all')")
	@ApiOperation(value = "根据培训机构查询DEFAULT", tags = {"班主任" } ,notes = "根据培训机构查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainagencies/{trmtrainagency_id}/trmhmatsers/searchdefault")
	public ResponseEntity<Page<TrmHmatserDTO>> searchTrmHmatserDefaultByTrmTrainAgency(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @RequestBody TrmHmatserSearchContext context) {
        context.setN_trmtrainagencyid_eq(trmtrainagency_id);
        Page<TrmHmatser> domains = trmhmatserService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmhmatserMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

