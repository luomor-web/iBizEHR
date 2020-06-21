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
import cn.ibizlab.ehr.core.trm.domain.TrmStay;
import cn.ibizlab.ehr.core.trm.service.ITrmStayService;
import cn.ibizlab.ehr.core.trm.filter.TrmStaySearchContext;

@Slf4j
@Api(tags = {"培训住宿" })
@RestController("WebApi-trmstay")
@RequestMapping("")
public class TrmStayResource {

    @Autowired
    public ITrmStayService trmstayService;

    @Autowired
    @Lazy
    public TrmStayMapping trmstayMapping;

    @ApiOperation(value = "获取培训住宿草稿", tags = {"培训住宿" },  notes = "获取培训住宿草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmstays/getdraft")
    public ResponseEntity<TrmStayDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmstayMapping.toDto(trmstayService.getDraft(new TrmStay())));
    }

    @PostAuthorize("hasPermission(this.trmstayMapping.toDomain(returnObject.body),'ehr-TrmStay-Get')")
    @ApiOperation(value = "获取培训住宿", tags = {"培训住宿" },  notes = "获取培训住宿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmstays/{trmstay_id}")
    public ResponseEntity<TrmStayDTO> get(@PathVariable("trmstay_id") String trmstay_id) {
        TrmStay domain = trmstayService.get(trmstay_id);
        TrmStayDTO dto = trmstayMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmstayService.get(#trmstay_id),'ehr-TrmStay-Remove')")
    @ApiOperation(value = "删除培训住宿", tags = {"培训住宿" },  notes = "删除培训住宿")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmstays/{trmstay_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmstay_id") String trmstay_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmstayService.remove(trmstay_id));
    }

    @PreAuthorize("hasPermission(this.trmstayService.getTrmstayByIds(#ids),'ehr-TrmStay-Remove')")
    @ApiOperation(value = "批量删除培训住宿", tags = {"培训住宿" },  notes = "批量删除培训住宿")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmstays/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmstayService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmstayMapping.toDomain(#trmstaydto),'ehr-TrmStay-Save')")
    @ApiOperation(value = "保存培训住宿", tags = {"培训住宿" },  notes = "保存培训住宿")
	@RequestMapping(method = RequestMethod.POST, value = "/trmstays/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmStayDTO trmstaydto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmstayService.save(trmstayMapping.toDomain(trmstaydto)));
    }

    @PreAuthorize("hasPermission(this.trmstayMapping.toDomain(#trmstaydtos),'ehr-TrmStay-Save')")
    @ApiOperation(value = "批量保存培训住宿", tags = {"培训住宿" },  notes = "批量保存培训住宿")
	@RequestMapping(method = RequestMethod.POST, value = "/trmstays/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmStayDTO> trmstaydtos) {
        trmstayService.saveBatch(trmstayMapping.toDomain(trmstaydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmstayService.get(#trmstay_id),'ehr-TrmStay-Update')")
    @ApiOperation(value = "更新培训住宿", tags = {"培训住宿" },  notes = "更新培训住宿")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmstays/{trmstay_id}")
    @Transactional
    public ResponseEntity<TrmStayDTO> update(@PathVariable("trmstay_id") String trmstay_id, @RequestBody TrmStayDTO trmstaydto) {
		TrmStay domain  = trmstayMapping.toDomain(trmstaydto);
        domain .setTrmstayid(trmstay_id);
		trmstayService.update(domain );
		TrmStayDTO dto = trmstayMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmstayService.getTrmstayByEntities(this.trmstayMapping.toDomain(#trmstaydtos)),'ehr-TrmStay-Update')")
    @ApiOperation(value = "批量更新培训住宿", tags = {"培训住宿" },  notes = "批量更新培训住宿")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmstays/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmStayDTO> trmstaydtos) {
        trmstayService.updateBatch(trmstayMapping.toDomain(trmstaydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmstayMapping.toDomain(#trmstaydto),'ehr-TrmStay-Create')")
    @ApiOperation(value = "新建培训住宿", tags = {"培训住宿" },  notes = "新建培训住宿")
	@RequestMapping(method = RequestMethod.POST, value = "/trmstays")
    @Transactional
    public ResponseEntity<TrmStayDTO> create(@RequestBody TrmStayDTO trmstaydto) {
        TrmStay domain = trmstayMapping.toDomain(trmstaydto);
		trmstayService.create(domain);
        TrmStayDTO dto = trmstayMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmstayMapping.toDomain(#trmstaydtos),'ehr-TrmStay-Create')")
    @ApiOperation(value = "批量新建培训住宿", tags = {"培训住宿" },  notes = "批量新建培训住宿")
	@RequestMapping(method = RequestMethod.POST, value = "/trmstays/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmStayDTO> trmstaydtos) {
        trmstayService.createBatch(trmstayMapping.toDomain(trmstaydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查培训住宿", tags = {"培训住宿" },  notes = "检查培训住宿")
	@RequestMapping(method = RequestMethod.POST, value = "/trmstays/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmStayDTO trmstaydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmstayService.checkKey(trmstayMapping.toDomain(trmstaydto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmStay-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"培训住宿" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmstays/fetchdefault")
	public ResponseEntity<List<TrmStayDTO>> fetchDefault(TrmStaySearchContext context) {
        Page<TrmStay> domains = trmstayService.searchDefault(context) ;
        List<TrmStayDTO> list = trmstayMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmStay-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"培训住宿" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmstays/searchdefault")
	public ResponseEntity<Page<TrmStayDTO>> searchDefault(@RequestBody TrmStaySearchContext context) {
        Page<TrmStay> domains = trmstayService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmstayMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据培训场地获取培训住宿草稿", tags = {"培训住宿" },  notes = "根据培训场地获取培训住宿草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmstays/getdraft")
    public ResponseEntity<TrmStayDTO> getDraftByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id) {
        TrmStay domain = new TrmStay();
        domain.setTrmtrainaddressid(trmtrainaddress_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmstayMapping.toDto(trmstayService.getDraft(domain)));
    }

    @PostAuthorize("hasPermission(this.trmstayMapping.toDomain(returnObject.body),'ehr-TrmStay-Get')")
    @ApiOperation(value = "根据培训场地获取培训住宿", tags = {"培训住宿" },  notes = "根据培训场地获取培训住宿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmstays/{trmstay_id}")
    public ResponseEntity<TrmStayDTO> getByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @PathVariable("trmstay_id") String trmstay_id) {
        TrmStay domain = trmstayService.get(trmstay_id);
        TrmStayDTO dto = trmstayMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmstayService.get(#trmstay_id),'ehr-TrmStay-Remove')")
    @ApiOperation(value = "根据培训场地删除培训住宿", tags = {"培训住宿" },  notes = "根据培训场地删除培训住宿")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmstays/{trmstay_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @PathVariable("trmstay_id") String trmstay_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmstayService.remove(trmstay_id));
    }

    @PreAuthorize("hasPermission(this.trmstayService.getTrmstayByIds(#ids),'ehr-TrmStay-Remove')")
    @ApiOperation(value = "根据培训场地批量删除培训住宿", tags = {"培训住宿" },  notes = "根据培训场地批量删除培训住宿")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmstays/batch")
    public ResponseEntity<Boolean> removeBatchByTrmTrainAddress(@RequestBody List<String> ids) {
        trmstayService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmstayMapping.toDomain(#trmstaydto),'ehr-TrmStay-Save')")
    @ApiOperation(value = "根据培训场地保存培训住宿", tags = {"培训住宿" },  notes = "根据培训场地保存培训住宿")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmstays/save")
    public ResponseEntity<Boolean> saveByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @RequestBody TrmStayDTO trmstaydto) {
        TrmStay domain = trmstayMapping.toDomain(trmstaydto);
        domain.setTrmtrainaddressid(trmtrainaddress_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmstayService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmstayMapping.toDomain(#trmstaydtos),'ehr-TrmStay-Save')")
    @ApiOperation(value = "根据培训场地批量保存培训住宿", tags = {"培训住宿" },  notes = "根据培训场地批量保存培训住宿")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmstays/savebatch")
    public ResponseEntity<Boolean> saveBatchByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @RequestBody List<TrmStayDTO> trmstaydtos) {
        List<TrmStay> domainlist=trmstayMapping.toDomain(trmstaydtos);
        for(TrmStay domain:domainlist){
             domain.setTrmtrainaddressid(trmtrainaddress_id);
        }
        trmstayService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmstayService.get(#trmstay_id),'ehr-TrmStay-Update')")
    @ApiOperation(value = "根据培训场地更新培训住宿", tags = {"培训住宿" },  notes = "根据培训场地更新培训住宿")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmstays/{trmstay_id}")
    @Transactional
    public ResponseEntity<TrmStayDTO> updateByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @PathVariable("trmstay_id") String trmstay_id, @RequestBody TrmStayDTO trmstaydto) {
        TrmStay domain = trmstayMapping.toDomain(trmstaydto);
        domain.setTrmtrainaddressid(trmtrainaddress_id);
        domain.setTrmstayid(trmstay_id);
		trmstayService.update(domain);
        TrmStayDTO dto = trmstayMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmstayService.getTrmstayByEntities(this.trmstayMapping.toDomain(#trmstaydtos)),'ehr-TrmStay-Update')")
    @ApiOperation(value = "根据培训场地批量更新培训住宿", tags = {"培训住宿" },  notes = "根据培训场地批量更新培训住宿")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmstays/batch")
    public ResponseEntity<Boolean> updateBatchByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @RequestBody List<TrmStayDTO> trmstaydtos) {
        List<TrmStay> domainlist=trmstayMapping.toDomain(trmstaydtos);
        for(TrmStay domain:domainlist){
            domain.setTrmtrainaddressid(trmtrainaddress_id);
        }
        trmstayService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmstayMapping.toDomain(#trmstaydto),'ehr-TrmStay-Create')")
    @ApiOperation(value = "根据培训场地建立培训住宿", tags = {"培训住宿" },  notes = "根据培训场地建立培训住宿")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmstays")
    @Transactional
    public ResponseEntity<TrmStayDTO> createByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @RequestBody TrmStayDTO trmstaydto) {
        TrmStay domain = trmstayMapping.toDomain(trmstaydto);
        domain.setTrmtrainaddressid(trmtrainaddress_id);
		trmstayService.create(domain);
        TrmStayDTO dto = trmstayMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmstayMapping.toDomain(#trmstaydtos),'ehr-TrmStay-Create')")
    @ApiOperation(value = "根据培训场地批量建立培训住宿", tags = {"培训住宿" },  notes = "根据培训场地批量建立培训住宿")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmstays/batch")
    public ResponseEntity<Boolean> createBatchByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @RequestBody List<TrmStayDTO> trmstaydtos) {
        List<TrmStay> domainlist=trmstayMapping.toDomain(trmstaydtos);
        for(TrmStay domain:domainlist){
            domain.setTrmtrainaddressid(trmtrainaddress_id);
        }
        trmstayService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据培训场地检查培训住宿", tags = {"培训住宿" },  notes = "根据培训场地检查培训住宿")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmstays/checkkey")
    public ResponseEntity<Boolean> checkKeyByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @RequestBody TrmStayDTO trmstaydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmstayService.checkKey(trmstayMapping.toDomain(trmstaydto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmStay-Default-all')")
	@ApiOperation(value = "根据培训场地获取DEFAULT", tags = {"培训住宿" } ,notes = "根据培训场地获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainaddresses/{trmtrainaddress_id}/trmstays/fetchdefault")
	public ResponseEntity<List<TrmStayDTO>> fetchTrmStayDefaultByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id,TrmStaySearchContext context) {
        context.setN_trmtrainaddressid_eq(trmtrainaddress_id);
        Page<TrmStay> domains = trmstayService.searchDefault(context) ;
        List<TrmStayDTO> list = trmstayMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmStay-Default-all')")
	@ApiOperation(value = "根据培训场地查询DEFAULT", tags = {"培训住宿" } ,notes = "根据培训场地查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainaddresses/{trmtrainaddress_id}/trmstays/searchdefault")
	public ResponseEntity<Page<TrmStayDTO>> searchTrmStayDefaultByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @RequestBody TrmStaySearchContext context) {
        context.setN_trmtrainaddressid_eq(trmtrainaddress_id);
        Page<TrmStay> domains = trmstayService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmstayMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

