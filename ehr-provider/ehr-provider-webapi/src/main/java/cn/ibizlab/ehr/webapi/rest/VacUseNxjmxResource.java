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
import cn.ibizlab.ehr.core.vac.domain.VacUseNxjmx;
import cn.ibizlab.ehr.core.vac.service.IVacUseNxjmxService;
import cn.ibizlab.ehr.core.vac.filter.VacUseNxjmxSearchContext;

@Slf4j
@Api(tags = {"假期使用明细" })
@RestController("WebApi-vacusenxjmx")
@RequestMapping("")
public class VacUseNxjmxResource {

    @Autowired
    public IVacUseNxjmxService vacusenxjmxService;

    @Autowired
    @Lazy
    public VacUseNxjmxMapping vacusenxjmxMapping;

    @PreAuthorize("hasPermission(this.vacusenxjmxService.get(#vacusenxjmx_id),'ehr-VacUseNxjmx-Remove')")
    @ApiOperation(value = "删除假期使用明细", tags = {"假期使用明细" },  notes = "删除假期使用明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacusenxjmxes/{vacusenxjmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacusenxjmx_id") String vacusenxjmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacusenxjmxService.remove(vacusenxjmx_id));
    }

    @PreAuthorize("hasPermission(this.vacusenxjmxService.getVacusenxjmxByIds(#ids),'ehr-VacUseNxjmx-Remove')")
    @ApiOperation(value = "批量删除假期使用明细", tags = {"假期使用明细" },  notes = "批量删除假期使用明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacusenxjmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacusenxjmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查假期使用明细", tags = {"假期使用明细" },  notes = "检查假期使用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/vacusenxjmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VacUseNxjmxDTO vacusenxjmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacusenxjmxService.checkKey(vacusenxjmxMapping.toDomain(vacusenxjmxdto)));
    }

    @PreAuthorize("hasPermission(this.vacusenxjmxMapping.toDomain(#vacusenxjmxdto),'ehr-VacUseNxjmx-Create')")
    @ApiOperation(value = "新建假期使用明细", tags = {"假期使用明细" },  notes = "新建假期使用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/vacusenxjmxes")
    @Transactional
    public ResponseEntity<VacUseNxjmxDTO> create(@RequestBody VacUseNxjmxDTO vacusenxjmxdto) {
        VacUseNxjmx domain = vacusenxjmxMapping.toDomain(vacusenxjmxdto);
		vacusenxjmxService.create(domain);
        VacUseNxjmxDTO dto = vacusenxjmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacusenxjmxMapping.toDomain(#vacusenxjmxdtos),'ehr-VacUseNxjmx-Create')")
    @ApiOperation(value = "批量新建假期使用明细", tags = {"假期使用明细" },  notes = "批量新建假期使用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/vacusenxjmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VacUseNxjmxDTO> vacusenxjmxdtos) {
        vacusenxjmxService.createBatch(vacusenxjmxMapping.toDomain(vacusenxjmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacusenxjmxService.get(#vacusenxjmx_id),'ehr-VacUseNxjmx-Update')")
    @ApiOperation(value = "更新假期使用明细", tags = {"假期使用明细" },  notes = "更新假期使用明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacusenxjmxes/{vacusenxjmx_id}")
    @Transactional
    public ResponseEntity<VacUseNxjmxDTO> update(@PathVariable("vacusenxjmx_id") String vacusenxjmx_id, @RequestBody VacUseNxjmxDTO vacusenxjmxdto) {
		VacUseNxjmx domain  = vacusenxjmxMapping.toDomain(vacusenxjmxdto);
        domain .setVacusenxjmxid(vacusenxjmx_id);
		vacusenxjmxService.update(domain );
		VacUseNxjmxDTO dto = vacusenxjmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacusenxjmxService.getVacusenxjmxByEntities(this.vacusenxjmxMapping.toDomain(#vacusenxjmxdtos)),'ehr-VacUseNxjmx-Update')")
    @ApiOperation(value = "批量更新假期使用明细", tags = {"假期使用明细" },  notes = "批量更新假期使用明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacusenxjmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VacUseNxjmxDTO> vacusenxjmxdtos) {
        vacusenxjmxService.updateBatch(vacusenxjmxMapping.toDomain(vacusenxjmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacusenxjmxMapping.toDomain(#vacusenxjmxdto),'ehr-VacUseNxjmx-Save')")
    @ApiOperation(value = "保存假期使用明细", tags = {"假期使用明细" },  notes = "保存假期使用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/vacusenxjmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody VacUseNxjmxDTO vacusenxjmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacusenxjmxService.save(vacusenxjmxMapping.toDomain(vacusenxjmxdto)));
    }

    @PreAuthorize("hasPermission(this.vacusenxjmxMapping.toDomain(#vacusenxjmxdtos),'ehr-VacUseNxjmx-Save')")
    @ApiOperation(value = "批量保存假期使用明细", tags = {"假期使用明细" },  notes = "批量保存假期使用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/vacusenxjmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VacUseNxjmxDTO> vacusenxjmxdtos) {
        vacusenxjmxService.saveBatch(vacusenxjmxMapping.toDomain(vacusenxjmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取假期使用明细草稿", tags = {"假期使用明细" },  notes = "获取假期使用明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/vacusenxjmxes/getdraft")
    public ResponseEntity<VacUseNxjmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacusenxjmxMapping.toDto(vacusenxjmxService.getDraft(new VacUseNxjmx())));
    }

    @PostAuthorize("hasPermission(this.vacusenxjmxMapping.toDomain(returnObject.body),'ehr-VacUseNxjmx-Get')")
    @ApiOperation(value = "获取假期使用明细", tags = {"假期使用明细" },  notes = "获取假期使用明细")
	@RequestMapping(method = RequestMethod.GET, value = "/vacusenxjmxes/{vacusenxjmx_id}")
    public ResponseEntity<VacUseNxjmxDTO> get(@PathVariable("vacusenxjmx_id") String vacusenxjmx_id) {
        VacUseNxjmx domain = vacusenxjmxService.get(vacusenxjmx_id);
        VacUseNxjmxDTO dto = vacusenxjmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacUseNxjmx-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"假期使用明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacusenxjmxes/fetchdefault")
	public ResponseEntity<List<VacUseNxjmxDTO>> fetchDefault(VacUseNxjmxSearchContext context) {
        Page<VacUseNxjmx> domains = vacusenxjmxService.searchDefault(context) ;
        List<VacUseNxjmxDTO> list = vacusenxjmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacUseNxjmx-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"假期使用明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacusenxjmxes/searchdefault")
	public ResponseEntity<Page<VacUseNxjmxDTO>> searchDefault(@RequestBody VacUseNxjmxSearchContext context) {
        Page<VacUseNxjmx> domains = vacusenxjmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacusenxjmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

