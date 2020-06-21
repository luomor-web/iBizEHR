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
import cn.ibizlab.ehr.core.trm.domain.TrmTraffic;
import cn.ibizlab.ehr.core.trm.service.ITrmTrafficService;
import cn.ibizlab.ehr.core.trm.filter.TrmTrafficSearchContext;

@Slf4j
@Api(tags = {"交通" })
@RestController("WebApi-trmtraffic")
@RequestMapping("")
public class TrmTrafficResource {

    @Autowired
    public ITrmTrafficService trmtrafficService;

    @Autowired
    @Lazy
    public TrmTrafficMapping trmtrafficMapping;

    @ApiOperation(value = "获取交通草稿", tags = {"交通" },  notes = "获取交通草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtraffics/getdraft")
    public ResponseEntity<TrmTrafficDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrafficMapping.toDto(trmtrafficService.getDraft(new TrmTraffic())));
    }

    @PreAuthorize("hasPermission(this.trmtrafficService.get(#trmtraffic_id),'ehr-TrmTraffic-Remove')")
    @ApiOperation(value = "删除交通", tags = {"交通" },  notes = "删除交通")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtraffics/{trmtraffic_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtraffic_id") String trmtraffic_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtrafficService.remove(trmtraffic_id));
    }

    @PreAuthorize("hasPermission(this.trmtrafficService.getTrmtrafficByIds(#ids),'ehr-TrmTraffic-Remove')")
    @ApiOperation(value = "批量删除交通", tags = {"交通" },  notes = "批量删除交通")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtraffics/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtrafficService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrafficMapping.toDomain(#trmtrafficdto),'ehr-TrmTraffic-Save')")
    @ApiOperation(value = "保存交通", tags = {"交通" },  notes = "保存交通")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraffics/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmTrafficDTO trmtrafficdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrafficService.save(trmtrafficMapping.toDomain(trmtrafficdto)));
    }

    @PreAuthorize("hasPermission(this.trmtrafficMapping.toDomain(#trmtrafficdtos),'ehr-TrmTraffic-Save')")
    @ApiOperation(value = "批量保存交通", tags = {"交通" },  notes = "批量保存交通")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraffics/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmTrafficDTO> trmtrafficdtos) {
        trmtrafficService.saveBatch(trmtrafficMapping.toDomain(trmtrafficdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmtrafficMapping.toDomain(returnObject.body),'ehr-TrmTraffic-Get')")
    @ApiOperation(value = "获取交通", tags = {"交通" },  notes = "获取交通")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtraffics/{trmtraffic_id}")
    public ResponseEntity<TrmTrafficDTO> get(@PathVariable("trmtraffic_id") String trmtraffic_id) {
        TrmTraffic domain = trmtrafficService.get(trmtraffic_id);
        TrmTrafficDTO dto = trmtrafficMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrafficService.get(#trmtraffic_id),'ehr-TrmTraffic-Update')")
    @ApiOperation(value = "更新交通", tags = {"交通" },  notes = "更新交通")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtraffics/{trmtraffic_id}")
    @Transactional
    public ResponseEntity<TrmTrafficDTO> update(@PathVariable("trmtraffic_id") String trmtraffic_id, @RequestBody TrmTrafficDTO trmtrafficdto) {
		TrmTraffic domain  = trmtrafficMapping.toDomain(trmtrafficdto);
        domain .setTrmtrafficid(trmtraffic_id);
		trmtrafficService.update(domain );
		TrmTrafficDTO dto = trmtrafficMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrafficService.getTrmtrafficByEntities(this.trmtrafficMapping.toDomain(#trmtrafficdtos)),'ehr-TrmTraffic-Update')")
    @ApiOperation(value = "批量更新交通", tags = {"交通" },  notes = "批量更新交通")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtraffics/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmTrafficDTO> trmtrafficdtos) {
        trmtrafficService.updateBatch(trmtrafficMapping.toDomain(trmtrafficdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrafficMapping.toDomain(#trmtrafficdto),'ehr-TrmTraffic-Create')")
    @ApiOperation(value = "新建交通", tags = {"交通" },  notes = "新建交通")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraffics")
    @Transactional
    public ResponseEntity<TrmTrafficDTO> create(@RequestBody TrmTrafficDTO trmtrafficdto) {
        TrmTraffic domain = trmtrafficMapping.toDomain(trmtrafficdto);
		trmtrafficService.create(domain);
        TrmTrafficDTO dto = trmtrafficMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrafficMapping.toDomain(#trmtrafficdtos),'ehr-TrmTraffic-Create')")
    @ApiOperation(value = "批量新建交通", tags = {"交通" },  notes = "批量新建交通")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraffics/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmTrafficDTO> trmtrafficdtos) {
        trmtrafficService.createBatch(trmtrafficMapping.toDomain(trmtrafficdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查交通", tags = {"交通" },  notes = "检查交通")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraffics/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmTrafficDTO trmtrafficdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrafficService.checkKey(trmtrafficMapping.toDomain(trmtrafficdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTraffic-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"交通" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtraffics/fetchdefault")
	public ResponseEntity<List<TrmTrafficDTO>> fetchDefault(TrmTrafficSearchContext context) {
        Page<TrmTraffic> domains = trmtrafficService.searchDefault(context) ;
        List<TrmTrafficDTO> list = trmtrafficMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTraffic-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"交通" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtraffics/searchdefault")
	public ResponseEntity<Page<TrmTrafficDTO>> searchDefault(@RequestBody TrmTrafficSearchContext context) {
        Page<TrmTraffic> domains = trmtrafficService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrafficMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据培训场地获取交通草稿", tags = {"交通" },  notes = "根据培训场地获取交通草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmtraffics/getdraft")
    public ResponseEntity<TrmTrafficDTO> getDraftByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id) {
        TrmTraffic domain = new TrmTraffic();
        domain.setTrmtrainaddressid(trmtrainaddress_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrafficMapping.toDto(trmtrafficService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.trmtrafficService.get(#trmtraffic_id),'ehr-TrmTraffic-Remove')")
    @ApiOperation(value = "根据培训场地删除交通", tags = {"交通" },  notes = "根据培训场地删除交通")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmtraffics/{trmtraffic_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @PathVariable("trmtraffic_id") String trmtraffic_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmtrafficService.remove(trmtraffic_id));
    }

    @PreAuthorize("hasPermission(this.trmtrafficService.getTrmtrafficByIds(#ids),'ehr-TrmTraffic-Remove')")
    @ApiOperation(value = "根据培训场地批量删除交通", tags = {"交通" },  notes = "根据培训场地批量删除交通")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmtraffics/batch")
    public ResponseEntity<Boolean> removeBatchByTrmTrainAddress(@RequestBody List<String> ids) {
        trmtrafficService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrafficMapping.toDomain(#trmtrafficdto),'ehr-TrmTraffic-Save')")
    @ApiOperation(value = "根据培训场地保存交通", tags = {"交通" },  notes = "根据培训场地保存交通")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmtraffics/save")
    public ResponseEntity<Boolean> saveByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @RequestBody TrmTrafficDTO trmtrafficdto) {
        TrmTraffic domain = trmtrafficMapping.toDomain(trmtrafficdto);
        domain.setTrmtrainaddressid(trmtrainaddress_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrafficService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmtrafficMapping.toDomain(#trmtrafficdtos),'ehr-TrmTraffic-Save')")
    @ApiOperation(value = "根据培训场地批量保存交通", tags = {"交通" },  notes = "根据培训场地批量保存交通")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmtraffics/savebatch")
    public ResponseEntity<Boolean> saveBatchByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @RequestBody List<TrmTrafficDTO> trmtrafficdtos) {
        List<TrmTraffic> domainlist=trmtrafficMapping.toDomain(trmtrafficdtos);
        for(TrmTraffic domain:domainlist){
             domain.setTrmtrainaddressid(trmtrainaddress_id);
        }
        trmtrafficService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmtrafficMapping.toDomain(returnObject.body),'ehr-TrmTraffic-Get')")
    @ApiOperation(value = "根据培训场地获取交通", tags = {"交通" },  notes = "根据培训场地获取交通")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmtraffics/{trmtraffic_id}")
    public ResponseEntity<TrmTrafficDTO> getByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @PathVariable("trmtraffic_id") String trmtraffic_id) {
        TrmTraffic domain = trmtrafficService.get(trmtraffic_id);
        TrmTrafficDTO dto = trmtrafficMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrafficService.get(#trmtraffic_id),'ehr-TrmTraffic-Update')")
    @ApiOperation(value = "根据培训场地更新交通", tags = {"交通" },  notes = "根据培训场地更新交通")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmtraffics/{trmtraffic_id}")
    @Transactional
    public ResponseEntity<TrmTrafficDTO> updateByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @PathVariable("trmtraffic_id") String trmtraffic_id, @RequestBody TrmTrafficDTO trmtrafficdto) {
        TrmTraffic domain = trmtrafficMapping.toDomain(trmtrafficdto);
        domain.setTrmtrainaddressid(trmtrainaddress_id);
        domain.setTrmtrafficid(trmtraffic_id);
		trmtrafficService.update(domain);
        TrmTrafficDTO dto = trmtrafficMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrafficService.getTrmtrafficByEntities(this.trmtrafficMapping.toDomain(#trmtrafficdtos)),'ehr-TrmTraffic-Update')")
    @ApiOperation(value = "根据培训场地批量更新交通", tags = {"交通" },  notes = "根据培训场地批量更新交通")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmtraffics/batch")
    public ResponseEntity<Boolean> updateBatchByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @RequestBody List<TrmTrafficDTO> trmtrafficdtos) {
        List<TrmTraffic> domainlist=trmtrafficMapping.toDomain(trmtrafficdtos);
        for(TrmTraffic domain:domainlist){
            domain.setTrmtrainaddressid(trmtrainaddress_id);
        }
        trmtrafficService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrafficMapping.toDomain(#trmtrafficdto),'ehr-TrmTraffic-Create')")
    @ApiOperation(value = "根据培训场地建立交通", tags = {"交通" },  notes = "根据培训场地建立交通")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmtraffics")
    @Transactional
    public ResponseEntity<TrmTrafficDTO> createByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @RequestBody TrmTrafficDTO trmtrafficdto) {
        TrmTraffic domain = trmtrafficMapping.toDomain(trmtrafficdto);
        domain.setTrmtrainaddressid(trmtrainaddress_id);
		trmtrafficService.create(domain);
        TrmTrafficDTO dto = trmtrafficMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrafficMapping.toDomain(#trmtrafficdtos),'ehr-TrmTraffic-Create')")
    @ApiOperation(value = "根据培训场地批量建立交通", tags = {"交通" },  notes = "根据培训场地批量建立交通")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmtraffics/batch")
    public ResponseEntity<Boolean> createBatchByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @RequestBody List<TrmTrafficDTO> trmtrafficdtos) {
        List<TrmTraffic> domainlist=trmtrafficMapping.toDomain(trmtrafficdtos);
        for(TrmTraffic domain:domainlist){
            domain.setTrmtrainaddressid(trmtrainaddress_id);
        }
        trmtrafficService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据培训场地检查交通", tags = {"交通" },  notes = "根据培训场地检查交通")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainaddresses/{trmtrainaddress_id}/trmtraffics/checkkey")
    public ResponseEntity<Boolean> checkKeyByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @RequestBody TrmTrafficDTO trmtrafficdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrafficService.checkKey(trmtrafficMapping.toDomain(trmtrafficdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTraffic-Default-all')")
	@ApiOperation(value = "根据培训场地获取DEFAULT", tags = {"交通" } ,notes = "根据培训场地获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainaddresses/{trmtrainaddress_id}/trmtraffics/fetchdefault")
	public ResponseEntity<List<TrmTrafficDTO>> fetchTrmTrafficDefaultByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id,TrmTrafficSearchContext context) {
        context.setN_trmtrainaddressid_eq(trmtrainaddress_id);
        Page<TrmTraffic> domains = trmtrafficService.searchDefault(context) ;
        List<TrmTrafficDTO> list = trmtrafficMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTraffic-Default-all')")
	@ApiOperation(value = "根据培训场地查询DEFAULT", tags = {"交通" } ,notes = "根据培训场地查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainaddresses/{trmtrainaddress_id}/trmtraffics/searchdefault")
	public ResponseEntity<Page<TrmTrafficDTO>> searchTrmTrafficDefaultByTrmTrainAddress(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @RequestBody TrmTrafficSearchContext context) {
        context.setN_trmtrainaddressid_eq(trmtrainaddress_id);
        Page<TrmTraffic> domains = trmtrafficService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrafficMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

