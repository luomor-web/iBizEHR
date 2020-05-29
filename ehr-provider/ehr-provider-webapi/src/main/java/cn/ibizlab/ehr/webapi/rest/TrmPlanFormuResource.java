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
import cn.ibizlab.ehr.core.trm.domain.TrmPlanFormu;
import cn.ibizlab.ehr.core.trm.service.ITrmPlanFormuService;
import cn.ibizlab.ehr.core.trm.filter.TrmPlanFormuSearchContext;

@Slf4j
@Api(tags = {"培训计划制定" })
@RestController("WebApi-trmplanformu")
@RequestMapping("")
public class TrmPlanFormuResource {

    @Autowired
    public ITrmPlanFormuService trmplanformuService;

    @Autowired
    @Lazy
    public TrmPlanFormuMapping trmplanformuMapping;

    @PreAuthorize("hasPermission(this.trmplanformuMapping.toDomain(#trmplanformudto),'ehr-TrmPlanFormu-Save')")
    @ApiOperation(value = "保存培训计划制定", tags = {"培训计划制定" },  notes = "保存培训计划制定")
	@RequestMapping(method = RequestMethod.POST, value = "/trmplanformus/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmPlanFormuDTO trmplanformudto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmplanformuService.save(trmplanformuMapping.toDomain(trmplanformudto)));
    }

    @PreAuthorize("hasPermission(this.trmplanformuMapping.toDomain(#trmplanformudtos),'ehr-TrmPlanFormu-Save')")
    @ApiOperation(value = "批量保存培训计划制定", tags = {"培训计划制定" },  notes = "批量保存培训计划制定")
	@RequestMapping(method = RequestMethod.POST, value = "/trmplanformus/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmPlanFormuDTO> trmplanformudtos) {
        trmplanformuService.saveBatch(trmplanformuMapping.toDomain(trmplanformudtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmplanformuService.get(#trmplanformu_id),'ehr-TrmPlanFormu-Remove')")
    @ApiOperation(value = "删除培训计划制定", tags = {"培训计划制定" },  notes = "删除培训计划制定")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmplanformus/{trmplanformu_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmplanformu_id") String trmplanformu_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmplanformuService.remove(trmplanformu_id));
    }

    @PreAuthorize("hasPermission(this.trmplanformuService.getTrmplanformuByIds(#ids),'ehr-TrmPlanFormu-Remove')")
    @ApiOperation(value = "批量删除培训计划制定", tags = {"培训计划制定" },  notes = "批量删除培训计划制定")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmplanformus/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmplanformuService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmplanformuMapping.toDomain(returnObject.body),'ehr-TrmPlanFormu-Get')")
    @ApiOperation(value = "获取培训计划制定", tags = {"培训计划制定" },  notes = "获取培训计划制定")
	@RequestMapping(method = RequestMethod.GET, value = "/trmplanformus/{trmplanformu_id}")
    public ResponseEntity<TrmPlanFormuDTO> get(@PathVariable("trmplanformu_id") String trmplanformu_id) {
        TrmPlanFormu domain = trmplanformuService.get(trmplanformu_id);
        TrmPlanFormuDTO dto = trmplanformuMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmplanformuService.get(#trmplanformu_id),'ehr-TrmPlanFormu-Update')")
    @ApiOperation(value = "更新培训计划制定", tags = {"培训计划制定" },  notes = "更新培训计划制定")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmplanformus/{trmplanformu_id}")
    @Transactional
    public ResponseEntity<TrmPlanFormuDTO> update(@PathVariable("trmplanformu_id") String trmplanformu_id, @RequestBody TrmPlanFormuDTO trmplanformudto) {
		TrmPlanFormu domain  = trmplanformuMapping.toDomain(trmplanformudto);
        domain .setTrmplanformuid(trmplanformu_id);
		trmplanformuService.update(domain );
		TrmPlanFormuDTO dto = trmplanformuMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmplanformuService.getTrmplanformuByEntities(this.trmplanformuMapping.toDomain(#trmplanformudtos)),'ehr-TrmPlanFormu-Update')")
    @ApiOperation(value = "批量更新培训计划制定", tags = {"培训计划制定" },  notes = "批量更新培训计划制定")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmplanformus/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmPlanFormuDTO> trmplanformudtos) {
        trmplanformuService.updateBatch(trmplanformuMapping.toDomain(trmplanformudtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmplanformuMapping.toDomain(#trmplanformudto),'ehr-TrmPlanFormu-Create')")
    @ApiOperation(value = "新建培训计划制定", tags = {"培训计划制定" },  notes = "新建培训计划制定")
	@RequestMapping(method = RequestMethod.POST, value = "/trmplanformus")
    @Transactional
    public ResponseEntity<TrmPlanFormuDTO> create(@RequestBody TrmPlanFormuDTO trmplanformudto) {
        TrmPlanFormu domain = trmplanformuMapping.toDomain(trmplanformudto);
		trmplanformuService.create(domain);
        TrmPlanFormuDTO dto = trmplanformuMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmplanformuMapping.toDomain(#trmplanformudtos),'ehr-TrmPlanFormu-Create')")
    @ApiOperation(value = "批量新建培训计划制定", tags = {"培训计划制定" },  notes = "批量新建培训计划制定")
	@RequestMapping(method = RequestMethod.POST, value = "/trmplanformus/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmPlanFormuDTO> trmplanformudtos) {
        trmplanformuService.createBatch(trmplanformuMapping.toDomain(trmplanformudtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取培训计划制定草稿", tags = {"培训计划制定" },  notes = "获取培训计划制定草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmplanformus/getdraft")
    public ResponseEntity<TrmPlanFormuDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmplanformuMapping.toDto(trmplanformuService.getDraft(new TrmPlanFormu())));
    }

    @ApiOperation(value = "检查培训计划制定", tags = {"培训计划制定" },  notes = "检查培训计划制定")
	@RequestMapping(method = RequestMethod.POST, value = "/trmplanformus/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmPlanFormuDTO trmplanformudto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmplanformuService.checkKey(trmplanformuMapping.toDomain(trmplanformudto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmPlanFormu-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"培训计划制定" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmplanformus/fetchdefault")
	public ResponseEntity<List<TrmPlanFormuDTO>> fetchDefault(TrmPlanFormuSearchContext context) {
        Page<TrmPlanFormu> domains = trmplanformuService.searchDefault(context) ;
        List<TrmPlanFormuDTO> list = trmplanformuMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmPlanFormu-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"培训计划制定" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmplanformus/searchdefault")
	public ResponseEntity<Page<TrmPlanFormuDTO>> searchDefault(@RequestBody TrmPlanFormuSearchContext context) {
        Page<TrmPlanFormu> domains = trmplanformuService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmplanformuMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

