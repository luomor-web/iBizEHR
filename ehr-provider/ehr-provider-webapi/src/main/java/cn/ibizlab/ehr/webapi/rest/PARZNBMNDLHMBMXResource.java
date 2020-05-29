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
import cn.ibizlab.ehr.core.par.domain.PARZNBMNDLHMBMX;
import cn.ibizlab.ehr.core.par.service.IPARZNBMNDLHMBMXService;
import cn.ibizlab.ehr.core.par.filter.PARZNBMNDLHMBMXSearchContext;

@Slf4j
@Api(tags = {"年度量化目标明细（职能部门级 ）" })
@RestController("WebApi-parznbmndlhmbmx")
@RequestMapping("")
public class PARZNBMNDLHMBMXResource {

    @Autowired
    public IPARZNBMNDLHMBMXService parznbmndlhmbmxService;

    @Autowired
    @Lazy
    public PARZNBMNDLHMBMXMapping parznbmndlhmbmxMapping;

    @PreAuthorize("hasPermission(this.parznbmndlhmbmxMapping.toDomain(#parznbmndlhmbmxdto),'ehr-PARZNBMNDLHMBMX-Create')")
    @ApiOperation(value = "新建年度量化目标明细（职能部门级 ）", tags = {"年度量化目标明细（职能部门级 ）" },  notes = "新建年度量化目标明细（职能部门级 ）")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmndlhmbmxes")
    @Transactional
    public ResponseEntity<PARZNBMNDLHMBMXDTO> create(@RequestBody PARZNBMNDLHMBMXDTO parznbmndlhmbmxdto) {
        PARZNBMNDLHMBMX domain = parznbmndlhmbmxMapping.toDomain(parznbmndlhmbmxdto);
		parznbmndlhmbmxService.create(domain);
        PARZNBMNDLHMBMXDTO dto = parznbmndlhmbmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parznbmndlhmbmxMapping.toDomain(#parznbmndlhmbmxdtos),'ehr-PARZNBMNDLHMBMX-Create')")
    @ApiOperation(value = "批量新建年度量化目标明细（职能部门级 ）", tags = {"年度量化目标明细（职能部门级 ）" },  notes = "批量新建年度量化目标明细（职能部门级 ）")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmndlhmbmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARZNBMNDLHMBMXDTO> parznbmndlhmbmxdtos) {
        parznbmndlhmbmxService.createBatch(parznbmndlhmbmxMapping.toDomain(parznbmndlhmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parznbmndlhmbmxService.get(#parznbmndlhmbmx_id),'ehr-PARZNBMNDLHMBMX-Update')")
    @ApiOperation(value = "更新年度量化目标明细（职能部门级 ）", tags = {"年度量化目标明细（职能部门级 ）" },  notes = "更新年度量化目标明细（职能部门级 ）")
	@RequestMapping(method = RequestMethod.PUT, value = "/parznbmndlhmbmxes/{parznbmndlhmbmx_id}")
    @Transactional
    public ResponseEntity<PARZNBMNDLHMBMXDTO> update(@PathVariable("parznbmndlhmbmx_id") String parznbmndlhmbmx_id, @RequestBody PARZNBMNDLHMBMXDTO parznbmndlhmbmxdto) {
		PARZNBMNDLHMBMX domain  = parznbmndlhmbmxMapping.toDomain(parznbmndlhmbmxdto);
        domain .setParznbmndlhmbmxid(parznbmndlhmbmx_id);
		parznbmndlhmbmxService.update(domain );
		PARZNBMNDLHMBMXDTO dto = parznbmndlhmbmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parznbmndlhmbmxService.getParznbmndlhmbmxByEntities(this.parznbmndlhmbmxMapping.toDomain(#parznbmndlhmbmxdtos)),'ehr-PARZNBMNDLHMBMX-Update')")
    @ApiOperation(value = "批量更新年度量化目标明细（职能部门级 ）", tags = {"年度量化目标明细（职能部门级 ）" },  notes = "批量更新年度量化目标明细（职能部门级 ）")
	@RequestMapping(method = RequestMethod.PUT, value = "/parznbmndlhmbmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARZNBMNDLHMBMXDTO> parznbmndlhmbmxdtos) {
        parznbmndlhmbmxService.updateBatch(parznbmndlhmbmxMapping.toDomain(parznbmndlhmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取年度量化目标明细（职能部门级 ）草稿", tags = {"年度量化目标明细（职能部门级 ）" },  notes = "获取年度量化目标明细（职能部门级 ）草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/parznbmndlhmbmxes/getdraft")
    public ResponseEntity<PARZNBMNDLHMBMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parznbmndlhmbmxMapping.toDto(parznbmndlhmbmxService.getDraft(new PARZNBMNDLHMBMX())));
    }

    @PostAuthorize("hasPermission(this.parznbmndlhmbmxMapping.toDomain(returnObject.body),'ehr-PARZNBMNDLHMBMX-Get')")
    @ApiOperation(value = "获取年度量化目标明细（职能部门级 ）", tags = {"年度量化目标明细（职能部门级 ）" },  notes = "获取年度量化目标明细（职能部门级 ）")
	@RequestMapping(method = RequestMethod.GET, value = "/parznbmndlhmbmxes/{parznbmndlhmbmx_id}")
    public ResponseEntity<PARZNBMNDLHMBMXDTO> get(@PathVariable("parznbmndlhmbmx_id") String parznbmndlhmbmx_id) {
        PARZNBMNDLHMBMX domain = parznbmndlhmbmxService.get(parznbmndlhmbmx_id);
        PARZNBMNDLHMBMXDTO dto = parznbmndlhmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "检查年度量化目标明细（职能部门级 ）", tags = {"年度量化目标明细（职能部门级 ）" },  notes = "检查年度量化目标明细（职能部门级 ）")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmndlhmbmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARZNBMNDLHMBMXDTO parznbmndlhmbmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parznbmndlhmbmxService.checkKey(parznbmndlhmbmxMapping.toDomain(parznbmndlhmbmxdto)));
    }

    @PreAuthorize("hasPermission(this.parznbmndlhmbmxMapping.toDomain(#parznbmndlhmbmxdto),'ehr-PARZNBMNDLHMBMX-Save')")
    @ApiOperation(value = "保存年度量化目标明细（职能部门级 ）", tags = {"年度量化目标明细（职能部门级 ）" },  notes = "保存年度量化目标明细（职能部门级 ）")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmndlhmbmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PARZNBMNDLHMBMXDTO parznbmndlhmbmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parznbmndlhmbmxService.save(parznbmndlhmbmxMapping.toDomain(parznbmndlhmbmxdto)));
    }

    @PreAuthorize("hasPermission(this.parznbmndlhmbmxMapping.toDomain(#parznbmndlhmbmxdtos),'ehr-PARZNBMNDLHMBMX-Save')")
    @ApiOperation(value = "批量保存年度量化目标明细（职能部门级 ）", tags = {"年度量化目标明细（职能部门级 ）" },  notes = "批量保存年度量化目标明细（职能部门级 ）")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmndlhmbmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARZNBMNDLHMBMXDTO> parznbmndlhmbmxdtos) {
        parznbmndlhmbmxService.saveBatch(parznbmndlhmbmxMapping.toDomain(parznbmndlhmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parznbmndlhmbmxService.get(#parznbmndlhmbmx_id),'ehr-PARZNBMNDLHMBMX-Remove')")
    @ApiOperation(value = "删除年度量化目标明细（职能部门级 ）", tags = {"年度量化目标明细（职能部门级 ）" },  notes = "删除年度量化目标明细（职能部门级 ）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parznbmndlhmbmxes/{parznbmndlhmbmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parznbmndlhmbmx_id") String parznbmndlhmbmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parznbmndlhmbmxService.remove(parznbmndlhmbmx_id));
    }

    @PreAuthorize("hasPermission(this.parznbmndlhmbmxService.getParznbmndlhmbmxByIds(#ids),'ehr-PARZNBMNDLHMBMX-Remove')")
    @ApiOperation(value = "批量删除年度量化目标明细（职能部门级 ）", tags = {"年度量化目标明细（职能部门级 ）" },  notes = "批量删除年度量化目标明细（职能部门级 ）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parznbmndlhmbmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parznbmndlhmbmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARZNBMNDLHMBMX-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"年度量化目标明细（职能部门级 ）" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/parznbmndlhmbmxes/fetchdefault")
	public ResponseEntity<List<PARZNBMNDLHMBMXDTO>> fetchDefault(PARZNBMNDLHMBMXSearchContext context) {
        Page<PARZNBMNDLHMBMX> domains = parznbmndlhmbmxService.searchDefault(context) ;
        List<PARZNBMNDLHMBMXDTO> list = parznbmndlhmbmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARZNBMNDLHMBMX-Default-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"年度量化目标明细（职能部门级 ）" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/parznbmndlhmbmxes/searchdefault")
	public ResponseEntity<Page<PARZNBMNDLHMBMXDTO>> searchDefault(@RequestBody PARZNBMNDLHMBMXSearchContext context) {
        Page<PARZNBMNDLHMBMX> domains = parznbmndlhmbmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parznbmndlhmbmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

