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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainActment;
import cn.ibizlab.ehr.core.trm.service.ITrmTrainActmentService;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainActmentSearchContext;

@Slf4j
@Api(tags = {"培训活动评估" })
@RestController("WebApi-trmtrainactment")
@RequestMapping("")
public class TrmTrainActmentResource {

    @Autowired
    public ITrmTrainActmentService trmtrainactmentService;

    @Autowired
    @Lazy
    public TrmTrainActmentMapping trmtrainactmentMapping;

    @PreAuthorize("hasPermission(this.trmtrainactmentService.get(#trmtrainactment_id),'ehr-TrmTrainActment-Remove')")
    @ApiOperation(value = "删除培训活动评估", tags = {"培训活动评估" },  notes = "删除培训活动评估")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainactments/{trmtrainactment_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtrainactment_id") String trmtrainactment_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtrainactmentService.remove(trmtrainactment_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainactmentService.getTrmtrainactmentByIds(#ids),'ehr-TrmTrainActment-Remove')")
    @ApiOperation(value = "批量删除培训活动评估", tags = {"培训活动评估" },  notes = "批量删除培训活动评估")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainactments/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtrainactmentService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取培训活动评估草稿", tags = {"培训活动评估" },  notes = "获取培训活动评估草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainactments/getdraft")
    public ResponseEntity<TrmTrainActmentDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainactmentMapping.toDto(trmtrainactmentService.getDraft(new TrmTrainActment())));
    }

    @ApiOperation(value = "检查培训活动评估", tags = {"培训活动评估" },  notes = "检查培训活动评估")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainactments/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmTrainActmentDTO trmtrainactmentdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainactmentService.checkKey(trmtrainactmentMapping.toDomain(trmtrainactmentdto)));
    }

    @PostAuthorize("hasPermission(this.trmtrainactmentMapping.toDomain(returnObject.body),'ehr-TrmTrainActment-Get')")
    @ApiOperation(value = "获取培训活动评估", tags = {"培训活动评估" },  notes = "获取培训活动评估")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainactments/{trmtrainactment_id}")
    public ResponseEntity<TrmTrainActmentDTO> get(@PathVariable("trmtrainactment_id") String trmtrainactment_id) {
        TrmTrainActment domain = trmtrainactmentService.get(trmtrainactment_id);
        TrmTrainActmentDTO dto = trmtrainactmentMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainactmentMapping.toDomain(#trmtrainactmentdto),'ehr-TrmTrainActment-Save')")
    @ApiOperation(value = "保存培训活动评估", tags = {"培训活动评估" },  notes = "保存培训活动评估")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainactments/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmTrainActmentDTO trmtrainactmentdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainactmentService.save(trmtrainactmentMapping.toDomain(trmtrainactmentdto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainactmentMapping.toDomain(#trmtrainactmentdtos),'ehr-TrmTrainActment-Save')")
    @ApiOperation(value = "批量保存培训活动评估", tags = {"培训活动评估" },  notes = "批量保存培训活动评估")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainactments/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmTrainActmentDTO> trmtrainactmentdtos) {
        trmtrainactmentService.saveBatch(trmtrainactmentMapping.toDomain(trmtrainactmentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainactmentMapping.toDomain(#trmtrainactmentdto),'ehr-TrmTrainActment-Create')")
    @ApiOperation(value = "新建培训活动评估", tags = {"培训活动评估" },  notes = "新建培训活动评估")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainactments")
    @Transactional
    public ResponseEntity<TrmTrainActmentDTO> create(@RequestBody TrmTrainActmentDTO trmtrainactmentdto) {
        TrmTrainActment domain = trmtrainactmentMapping.toDomain(trmtrainactmentdto);
		trmtrainactmentService.create(domain);
        TrmTrainActmentDTO dto = trmtrainactmentMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainactmentMapping.toDomain(#trmtrainactmentdtos),'ehr-TrmTrainActment-Create')")
    @ApiOperation(value = "批量新建培训活动评估", tags = {"培训活动评估" },  notes = "批量新建培训活动评估")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainactments/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmTrainActmentDTO> trmtrainactmentdtos) {
        trmtrainactmentService.createBatch(trmtrainactmentMapping.toDomain(trmtrainactmentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainactmentService.get(#trmtrainactment_id),'ehr-TrmTrainActment-Update')")
    @ApiOperation(value = "更新培训活动评估", tags = {"培训活动评估" },  notes = "更新培训活动评估")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainactments/{trmtrainactment_id}")
    @Transactional
    public ResponseEntity<TrmTrainActmentDTO> update(@PathVariable("trmtrainactment_id") String trmtrainactment_id, @RequestBody TrmTrainActmentDTO trmtrainactmentdto) {
		TrmTrainActment domain  = trmtrainactmentMapping.toDomain(trmtrainactmentdto);
        domain .setTrmtrainactmentid(trmtrainactment_id);
		trmtrainactmentService.update(domain );
		TrmTrainActmentDTO dto = trmtrainactmentMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainactmentService.getTrmtrainactmentByEntities(this.trmtrainactmentMapping.toDomain(#trmtrainactmentdtos)),'ehr-TrmTrainActment-Update')")
    @ApiOperation(value = "批量更新培训活动评估", tags = {"培训活动评估" },  notes = "批量更新培训活动评估")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainactments/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmTrainActmentDTO> trmtrainactmentdtos) {
        trmtrainactmentService.updateBatch(trmtrainactmentMapping.toDomain(trmtrainactmentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainActment-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"培训活动评估" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainactments/fetchdefault")
	public ResponseEntity<List<TrmTrainActmentDTO>> fetchDefault(TrmTrainActmentSearchContext context) {
        Page<TrmTrainActment> domains = trmtrainactmentService.searchDefault(context) ;
        List<TrmTrainActmentDTO> list = trmtrainactmentMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainActment-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"培训活动评估" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainactments/searchdefault")
	public ResponseEntity<Page<TrmTrainActmentDTO>> searchDefault(@RequestBody TrmTrainActmentSearchContext context) {
        Page<TrmTrainActment> domains = trmtrainactmentService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainactmentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

