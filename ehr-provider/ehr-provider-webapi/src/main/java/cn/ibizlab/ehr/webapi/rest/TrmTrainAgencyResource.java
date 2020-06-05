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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainAgency;
import cn.ibizlab.ehr.core.trm.service.ITrmTrainAgencyService;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainAgencySearchContext;

@Slf4j
@Api(tags = {"培训机构" })
@RestController("WebApi-trmtrainagency")
@RequestMapping("")
public class TrmTrainAgencyResource {

    @Autowired
    public ITrmTrainAgencyService trmtrainagencyService;

    @Autowired
    @Lazy
    public TrmTrainAgencyMapping trmtrainagencyMapping;

    @PreAuthorize("hasPermission(this.trmtrainagencyMapping.toDomain(#trmtrainagencydto),'ehr-TrmTrainAgency-Save')")
    @ApiOperation(value = "保存培训机构", tags = {"培训机构" },  notes = "保存培训机构")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmTrainAgencyDTO trmtrainagencydto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainagencyService.save(trmtrainagencyMapping.toDomain(trmtrainagencydto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainagencyMapping.toDomain(#trmtrainagencydtos),'ehr-TrmTrainAgency-Save')")
    @ApiOperation(value = "批量保存培训机构", tags = {"培训机构" },  notes = "批量保存培训机构")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmTrainAgencyDTO> trmtrainagencydtos) {
        trmtrainagencyService.saveBatch(trmtrainagencyMapping.toDomain(trmtrainagencydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查培训机构", tags = {"培训机构" },  notes = "检查培训机构")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmTrainAgencyDTO trmtrainagencydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainagencyService.checkKey(trmtrainagencyMapping.toDomain(trmtrainagencydto)));
    }

    @ApiOperation(value = "获取培训机构草稿", tags = {"培训机构" },  notes = "获取培训机构草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainagencies/getdraft")
    public ResponseEntity<TrmTrainAgencyDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainagencyMapping.toDto(trmtrainagencyService.getDraft(new TrmTrainAgency())));
    }

    @PostAuthorize("hasPermission(this.trmtrainagencyMapping.toDomain(returnObject.body),'ehr-TrmTrainAgency-Get')")
    @ApiOperation(value = "获取培训机构", tags = {"培训机构" },  notes = "获取培训机构")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainagencies/{trmtrainagency_id}")
    public ResponseEntity<TrmTrainAgencyDTO> get(@PathVariable("trmtrainagency_id") String trmtrainagency_id) {
        TrmTrainAgency domain = trmtrainagencyService.get(trmtrainagency_id);
        TrmTrainAgencyDTO dto = trmtrainagencyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainagencyService.get(#trmtrainagency_id),'ehr-TrmTrainAgency-Update')")
    @ApiOperation(value = "更新培训机构", tags = {"培训机构" },  notes = "更新培训机构")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainagencies/{trmtrainagency_id}")
    @Transactional
    public ResponseEntity<TrmTrainAgencyDTO> update(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @RequestBody TrmTrainAgencyDTO trmtrainagencydto) {
		TrmTrainAgency domain  = trmtrainagencyMapping.toDomain(trmtrainagencydto);
        domain .setTrmtrainagencyid(trmtrainagency_id);
		trmtrainagencyService.update(domain );
		TrmTrainAgencyDTO dto = trmtrainagencyMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainagencyService.getTrmtrainagencyByEntities(this.trmtrainagencyMapping.toDomain(#trmtrainagencydtos)),'ehr-TrmTrainAgency-Update')")
    @ApiOperation(value = "批量更新培训机构", tags = {"培训机构" },  notes = "批量更新培训机构")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainagencies/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmTrainAgencyDTO> trmtrainagencydtos) {
        trmtrainagencyService.updateBatch(trmtrainagencyMapping.toDomain(trmtrainagencydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainagencyMapping.toDomain(#trmtrainagencydto),'ehr-TrmTrainAgency-Create')")
    @ApiOperation(value = "新建培训机构", tags = {"培训机构" },  notes = "新建培训机构")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies")
    @Transactional
    public ResponseEntity<TrmTrainAgencyDTO> create(@RequestBody TrmTrainAgencyDTO trmtrainagencydto) {
        TrmTrainAgency domain = trmtrainagencyMapping.toDomain(trmtrainagencydto);
		trmtrainagencyService.create(domain);
        TrmTrainAgencyDTO dto = trmtrainagencyMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainagencyMapping.toDomain(#trmtrainagencydtos),'ehr-TrmTrainAgency-Create')")
    @ApiOperation(value = "批量新建培训机构", tags = {"培训机构" },  notes = "批量新建培训机构")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmTrainAgencyDTO> trmtrainagencydtos) {
        trmtrainagencyService.createBatch(trmtrainagencyMapping.toDomain(trmtrainagencydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainagencyService.get(#trmtrainagency_id),'ehr-TrmTrainAgency-Remove')")
    @ApiOperation(value = "删除培训机构", tags = {"培训机构" },  notes = "删除培训机构")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainagencies/{trmtrainagency_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtrainagency_id") String trmtrainagency_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtrainagencyService.remove(trmtrainagency_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainagencyService.getTrmtrainagencyByIds(#ids),'ehr-TrmTrainAgency-Remove')")
    @ApiOperation(value = "批量删除培训机构", tags = {"培训机构" },  notes = "批量删除培训机构")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainagencies/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtrainagencyService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainAgency-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"培训机构" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainagencies/fetchdefault")
	public ResponseEntity<List<TrmTrainAgencyDTO>> fetchDefault(TrmTrainAgencySearchContext context) {
        Page<TrmTrainAgency> domains = trmtrainagencyService.searchDefault(context) ;
        List<TrmTrainAgencyDTO> list = trmtrainagencyMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainAgency-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"培训机构" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainagencies/searchdefault")
	public ResponseEntity<Page<TrmTrainAgencyDTO>> searchDefault(@RequestBody TrmTrainAgencySearchContext context) {
        Page<TrmTrainAgency> domains = trmtrainagencyService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainagencyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

