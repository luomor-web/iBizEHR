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
import cn.ibizlab.ehr.core.vac.domain.VACUSENXJMX;
import cn.ibizlab.ehr.core.vac.service.IVACUSENXJMXService;
import cn.ibizlab.ehr.core.vac.filter.VACUSENXJMXSearchContext;

@Slf4j
@Api(tags = {"假期使用明细" })
@RestController("WebApi-vacusenxjmx")
@RequestMapping("")
public class VACUSENXJMXResource {

    @Autowired
    public IVACUSENXJMXService vacusenxjmxService;

    @Autowired
    @Lazy
    public VACUSENXJMXMapping vacusenxjmxMapping;

    @PreAuthorize("hasPermission(this.vacusenxjmxService.get(#vacusenxjmx_id),'ehr-VACUSENXJMX-Remove')")
    @ApiOperation(value = "删除假期使用明细", tags = {"假期使用明细" },  notes = "删除假期使用明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacusenxjmxes/{vacusenxjmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacusenxjmx_id") String vacusenxjmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacusenxjmxService.remove(vacusenxjmx_id));
    }

    @PreAuthorize("hasPermission(this.vacusenxjmxService.getVacusenxjmxByIds(#ids),'ehr-VACUSENXJMX-Remove')")
    @ApiOperation(value = "批量删除假期使用明细", tags = {"假期使用明细" },  notes = "批量删除假期使用明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacusenxjmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacusenxjmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查假期使用明细", tags = {"假期使用明细" },  notes = "检查假期使用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/vacusenxjmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VACUSENXJMXDTO vacusenxjmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacusenxjmxService.checkKey(vacusenxjmxMapping.toDomain(vacusenxjmxdto)));
    }

    @PreAuthorize("hasPermission(this.vacusenxjmxMapping.toDomain(#vacusenxjmxdto),'ehr-VACUSENXJMX-Create')")
    @ApiOperation(value = "新建假期使用明细", tags = {"假期使用明细" },  notes = "新建假期使用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/vacusenxjmxes")
    @Transactional
    public ResponseEntity<VACUSENXJMXDTO> create(@RequestBody VACUSENXJMXDTO vacusenxjmxdto) {
        VACUSENXJMX domain = vacusenxjmxMapping.toDomain(vacusenxjmxdto);
		vacusenxjmxService.create(domain);
        VACUSENXJMXDTO dto = vacusenxjmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacusenxjmxMapping.toDomain(#vacusenxjmxdtos),'ehr-VACUSENXJMX-Create')")
    @ApiOperation(value = "批量新建假期使用明细", tags = {"假期使用明细" },  notes = "批量新建假期使用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/vacusenxjmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VACUSENXJMXDTO> vacusenxjmxdtos) {
        vacusenxjmxService.createBatch(vacusenxjmxMapping.toDomain(vacusenxjmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacusenxjmxService.get(#vacusenxjmx_id),'ehr-VACUSENXJMX-Update')")
    @ApiOperation(value = "更新假期使用明细", tags = {"假期使用明细" },  notes = "更新假期使用明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacusenxjmxes/{vacusenxjmx_id}")
    @Transactional
    public ResponseEntity<VACUSENXJMXDTO> update(@PathVariable("vacusenxjmx_id") String vacusenxjmx_id, @RequestBody VACUSENXJMXDTO vacusenxjmxdto) {
		VACUSENXJMX domain  = vacusenxjmxMapping.toDomain(vacusenxjmxdto);
        domain .setVacusenxjmxid(vacusenxjmx_id);
		vacusenxjmxService.update(domain );
		VACUSENXJMXDTO dto = vacusenxjmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacusenxjmxService.getVacusenxjmxByEntities(this.vacusenxjmxMapping.toDomain(#vacusenxjmxdtos)),'ehr-VACUSENXJMX-Update')")
    @ApiOperation(value = "批量更新假期使用明细", tags = {"假期使用明细" },  notes = "批量更新假期使用明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacusenxjmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VACUSENXJMXDTO> vacusenxjmxdtos) {
        vacusenxjmxService.updateBatch(vacusenxjmxMapping.toDomain(vacusenxjmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacusenxjmxMapping.toDomain(#vacusenxjmxdto),'ehr-VACUSENXJMX-Save')")
    @ApiOperation(value = "保存假期使用明细", tags = {"假期使用明细" },  notes = "保存假期使用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/vacusenxjmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody VACUSENXJMXDTO vacusenxjmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacusenxjmxService.save(vacusenxjmxMapping.toDomain(vacusenxjmxdto)));
    }

    @PreAuthorize("hasPermission(this.vacusenxjmxMapping.toDomain(#vacusenxjmxdtos),'ehr-VACUSENXJMX-Save')")
    @ApiOperation(value = "批量保存假期使用明细", tags = {"假期使用明细" },  notes = "批量保存假期使用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/vacusenxjmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VACUSENXJMXDTO> vacusenxjmxdtos) {
        vacusenxjmxService.saveBatch(vacusenxjmxMapping.toDomain(vacusenxjmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取假期使用明细草稿", tags = {"假期使用明细" },  notes = "获取假期使用明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/vacusenxjmxes/getdraft")
    public ResponseEntity<VACUSENXJMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacusenxjmxMapping.toDto(vacusenxjmxService.getDraft(new VACUSENXJMX())));
    }

    @PostAuthorize("hasPermission(this.vacusenxjmxMapping.toDomain(returnObject.body),'ehr-VACUSENXJMX-Get')")
    @ApiOperation(value = "获取假期使用明细", tags = {"假期使用明细" },  notes = "获取假期使用明细")
	@RequestMapping(method = RequestMethod.GET, value = "/vacusenxjmxes/{vacusenxjmx_id}")
    public ResponseEntity<VACUSENXJMXDTO> get(@PathVariable("vacusenxjmx_id") String vacusenxjmx_id) {
        VACUSENXJMX domain = vacusenxjmxService.get(vacusenxjmx_id);
        VACUSENXJMXDTO dto = vacusenxjmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACUSENXJMX-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"假期使用明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacusenxjmxes/fetchdefault")
	public ResponseEntity<List<VACUSENXJMXDTO>> fetchDefault(VACUSENXJMXSearchContext context) {
        Page<VACUSENXJMX> domains = vacusenxjmxService.searchDefault(context) ;
        List<VACUSENXJMXDTO> list = vacusenxjmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACUSENXJMX-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"假期使用明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacusenxjmxes/searchdefault")
	public ResponseEntity<Page<VACUSENXJMXDTO>> searchDefault(@RequestBody VACUSENXJMXSearchContext context) {
        Page<VACUSENXJMX> domains = vacusenxjmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacusenxjmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

