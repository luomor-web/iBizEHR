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
import cn.ibizlab.ehr.core.par.domain.PARLHMBMX;
import cn.ibizlab.ehr.core.par.service.IPARLHMBMXService;
import cn.ibizlab.ehr.core.par.filter.PARLHMBMXSearchContext;

@Slf4j
@Api(tags = {"绩效量化目标明细" })
@RestController("WebApi-parlhmbmx")
@RequestMapping("")
public class PARLHMBMXResource {

    @Autowired
    public IPARLHMBMXService parlhmbmxService;

    @Autowired
    @Lazy
    public PARLHMBMXMapping parlhmbmxMapping;

    @ApiOperation(value = "检查绩效量化目标明细", tags = {"绩效量化目标明细" },  notes = "检查绩效量化目标明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parlhmbmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARLHMBMXDTO parlhmbmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parlhmbmxService.checkKey(parlhmbmxMapping.toDomain(parlhmbmxdto)));
    }

    @PreAuthorize("hasPermission(this.parlhmbmxService.get(#parlhmbmx_id),'ehr-PARLHMBMX-Remove')")
    @ApiOperation(value = "删除绩效量化目标明细", tags = {"绩效量化目标明细" },  notes = "删除绩效量化目标明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parlhmbmxes/{parlhmbmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parlhmbmx_id") String parlhmbmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parlhmbmxService.remove(parlhmbmx_id));
    }

    @PreAuthorize("hasPermission(this.parlhmbmxService.getParlhmbmxByIds(#ids),'ehr-PARLHMBMX-Remove')")
    @ApiOperation(value = "批量删除绩效量化目标明细", tags = {"绩效量化目标明细" },  notes = "批量删除绩效量化目标明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parlhmbmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parlhmbmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parlhmbmxMapping.toDomain(#parlhmbmxdto),'ehr-PARLHMBMX-Save')")
    @ApiOperation(value = "保存绩效量化目标明细", tags = {"绩效量化目标明细" },  notes = "保存绩效量化目标明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parlhmbmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PARLHMBMXDTO parlhmbmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parlhmbmxService.save(parlhmbmxMapping.toDomain(parlhmbmxdto)));
    }

    @PreAuthorize("hasPermission(this.parlhmbmxMapping.toDomain(#parlhmbmxdtos),'ehr-PARLHMBMX-Save')")
    @ApiOperation(value = "批量保存绩效量化目标明细", tags = {"绩效量化目标明细" },  notes = "批量保存绩效量化目标明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parlhmbmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARLHMBMXDTO> parlhmbmxdtos) {
        parlhmbmxService.saveBatch(parlhmbmxMapping.toDomain(parlhmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取绩效量化目标明细草稿", tags = {"绩效量化目标明细" },  notes = "获取绩效量化目标明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/parlhmbmxes/getdraft")
    public ResponseEntity<PARLHMBMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parlhmbmxMapping.toDto(parlhmbmxService.getDraft(new PARLHMBMX())));
    }

    @PostAuthorize("hasPermission(this.parlhmbmxMapping.toDomain(returnObject.body),'ehr-PARLHMBMX-Get')")
    @ApiOperation(value = "获取绩效量化目标明细", tags = {"绩效量化目标明细" },  notes = "获取绩效量化目标明细")
	@RequestMapping(method = RequestMethod.GET, value = "/parlhmbmxes/{parlhmbmx_id}")
    public ResponseEntity<PARLHMBMXDTO> get(@PathVariable("parlhmbmx_id") String parlhmbmx_id) {
        PARLHMBMX domain = parlhmbmxService.get(parlhmbmx_id);
        PARLHMBMXDTO dto = parlhmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parlhmbmxService.get(#parlhmbmx_id),'ehr-PARLHMBMX-Update')")
    @ApiOperation(value = "更新绩效量化目标明细", tags = {"绩效量化目标明细" },  notes = "更新绩效量化目标明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/parlhmbmxes/{parlhmbmx_id}")
    @Transactional
    public ResponseEntity<PARLHMBMXDTO> update(@PathVariable("parlhmbmx_id") String parlhmbmx_id, @RequestBody PARLHMBMXDTO parlhmbmxdto) {
		PARLHMBMX domain  = parlhmbmxMapping.toDomain(parlhmbmxdto);
        domain .setParlhmbmxid(parlhmbmx_id);
		parlhmbmxService.update(domain );
		PARLHMBMXDTO dto = parlhmbmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parlhmbmxService.getParlhmbmxByEntities(this.parlhmbmxMapping.toDomain(#parlhmbmxdtos)),'ehr-PARLHMBMX-Update')")
    @ApiOperation(value = "批量更新绩效量化目标明细", tags = {"绩效量化目标明细" },  notes = "批量更新绩效量化目标明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/parlhmbmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARLHMBMXDTO> parlhmbmxdtos) {
        parlhmbmxService.updateBatch(parlhmbmxMapping.toDomain(parlhmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parlhmbmxMapping.toDomain(#parlhmbmxdto),'ehr-PARLHMBMX-Create')")
    @ApiOperation(value = "新建绩效量化目标明细", tags = {"绩效量化目标明细" },  notes = "新建绩效量化目标明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parlhmbmxes")
    @Transactional
    public ResponseEntity<PARLHMBMXDTO> create(@RequestBody PARLHMBMXDTO parlhmbmxdto) {
        PARLHMBMX domain = parlhmbmxMapping.toDomain(parlhmbmxdto);
		parlhmbmxService.create(domain);
        PARLHMBMXDTO dto = parlhmbmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parlhmbmxMapping.toDomain(#parlhmbmxdtos),'ehr-PARLHMBMX-Create')")
    @ApiOperation(value = "批量新建绩效量化目标明细", tags = {"绩效量化目标明细" },  notes = "批量新建绩效量化目标明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parlhmbmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARLHMBMXDTO> parlhmbmxdtos) {
        parlhmbmxService.createBatch(parlhmbmxMapping.toDomain(parlhmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARLHMBMX-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"绩效量化目标明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parlhmbmxes/fetchdefault")
	public ResponseEntity<List<PARLHMBMXDTO>> fetchDefault(PARLHMBMXSearchContext context) {
        Page<PARLHMBMX> domains = parlhmbmxService.searchDefault(context) ;
        List<PARLHMBMXDTO> list = parlhmbmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARLHMBMX-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"绩效量化目标明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parlhmbmxes/searchdefault")
	public ResponseEntity<Page<PARLHMBMXDTO>> searchDefault(@RequestBody PARLHMBMXSearchContext context) {
        Page<PARLHMBMX> domains = parlhmbmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parlhmbmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

