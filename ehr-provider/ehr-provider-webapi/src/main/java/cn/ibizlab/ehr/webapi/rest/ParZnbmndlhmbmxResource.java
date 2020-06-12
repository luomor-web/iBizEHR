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
import cn.ibizlab.ehr.core.par.domain.ParZnbmndlhmbmx;
import cn.ibizlab.ehr.core.par.service.IParZnbmndlhmbmxService;
import cn.ibizlab.ehr.core.par.filter.ParZnbmndlhmbmxSearchContext;

@Slf4j
@Api(tags = {"年度量化目标明细（职能部门级 ）" })
@RestController("WebApi-parznbmndlhmbmx")
@RequestMapping("")
public class ParZnbmndlhmbmxResource {

    @Autowired
    public IParZnbmndlhmbmxService parznbmndlhmbmxService;

    @Autowired
    @Lazy
    public ParZnbmndlhmbmxMapping parznbmndlhmbmxMapping;

    @PreAuthorize("hasPermission(this.parznbmndlhmbmxMapping.toDomain(#parznbmndlhmbmxdto),'ehr-ParZnbmndlhmbmx-Create')")
    @ApiOperation(value = "新建年度量化目标明细（职能部门级 ）", tags = {"年度量化目标明细（职能部门级 ）" },  notes = "新建年度量化目标明细（职能部门级 ）")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmndlhmbmxes")
    @Transactional
    public ResponseEntity<ParZnbmndlhmbmxDTO> create(@RequestBody ParZnbmndlhmbmxDTO parznbmndlhmbmxdto) {
        ParZnbmndlhmbmx domain = parznbmndlhmbmxMapping.toDomain(parznbmndlhmbmxdto);
		parznbmndlhmbmxService.create(domain);
        ParZnbmndlhmbmxDTO dto = parznbmndlhmbmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parznbmndlhmbmxMapping.toDomain(#parznbmndlhmbmxdtos),'ehr-ParZnbmndlhmbmx-Create')")
    @ApiOperation(value = "批量新建年度量化目标明细（职能部门级 ）", tags = {"年度量化目标明细（职能部门级 ）" },  notes = "批量新建年度量化目标明细（职能部门级 ）")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmndlhmbmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParZnbmndlhmbmxDTO> parznbmndlhmbmxdtos) {
        parznbmndlhmbmxService.createBatch(parznbmndlhmbmxMapping.toDomain(parznbmndlhmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parznbmndlhmbmxService.get(#parznbmndlhmbmx_id),'ehr-ParZnbmndlhmbmx-Update')")
    @ApiOperation(value = "更新年度量化目标明细（职能部门级 ）", tags = {"年度量化目标明细（职能部门级 ）" },  notes = "更新年度量化目标明细（职能部门级 ）")
	@RequestMapping(method = RequestMethod.PUT, value = "/parznbmndlhmbmxes/{parznbmndlhmbmx_id}")
    @Transactional
    public ResponseEntity<ParZnbmndlhmbmxDTO> update(@PathVariable("parznbmndlhmbmx_id") String parznbmndlhmbmx_id, @RequestBody ParZnbmndlhmbmxDTO parznbmndlhmbmxdto) {
		ParZnbmndlhmbmx domain  = parznbmndlhmbmxMapping.toDomain(parznbmndlhmbmxdto);
        domain .setParznbmndlhmbmxid(parznbmndlhmbmx_id);
		parznbmndlhmbmxService.update(domain );
		ParZnbmndlhmbmxDTO dto = parznbmndlhmbmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parznbmndlhmbmxService.getParznbmndlhmbmxByEntities(this.parznbmndlhmbmxMapping.toDomain(#parznbmndlhmbmxdtos)),'ehr-ParZnbmndlhmbmx-Update')")
    @ApiOperation(value = "批量更新年度量化目标明细（职能部门级 ）", tags = {"年度量化目标明细（职能部门级 ）" },  notes = "批量更新年度量化目标明细（职能部门级 ）")
	@RequestMapping(method = RequestMethod.PUT, value = "/parznbmndlhmbmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParZnbmndlhmbmxDTO> parznbmndlhmbmxdtos) {
        parznbmndlhmbmxService.updateBatch(parznbmndlhmbmxMapping.toDomain(parznbmndlhmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取年度量化目标明细（职能部门级 ）草稿", tags = {"年度量化目标明细（职能部门级 ）" },  notes = "获取年度量化目标明细（职能部门级 ）草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/parznbmndlhmbmxes/getdraft")
    public ResponseEntity<ParZnbmndlhmbmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parznbmndlhmbmxMapping.toDto(parznbmndlhmbmxService.getDraft(new ParZnbmndlhmbmx())));
    }

    @PostAuthorize("hasPermission(this.parznbmndlhmbmxMapping.toDomain(returnObject.body),'ehr-ParZnbmndlhmbmx-Get')")
    @ApiOperation(value = "获取年度量化目标明细（职能部门级 ）", tags = {"年度量化目标明细（职能部门级 ）" },  notes = "获取年度量化目标明细（职能部门级 ）")
	@RequestMapping(method = RequestMethod.GET, value = "/parznbmndlhmbmxes/{parznbmndlhmbmx_id}")
    public ResponseEntity<ParZnbmndlhmbmxDTO> get(@PathVariable("parznbmndlhmbmx_id") String parznbmndlhmbmx_id) {
        ParZnbmndlhmbmx domain = parznbmndlhmbmxService.get(parznbmndlhmbmx_id);
        ParZnbmndlhmbmxDTO dto = parznbmndlhmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "检查年度量化目标明细（职能部门级 ）", tags = {"年度量化目标明细（职能部门级 ）" },  notes = "检查年度量化目标明细（职能部门级 ）")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmndlhmbmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParZnbmndlhmbmxDTO parznbmndlhmbmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parznbmndlhmbmxService.checkKey(parznbmndlhmbmxMapping.toDomain(parznbmndlhmbmxdto)));
    }

    @PreAuthorize("hasPermission(this.parznbmndlhmbmxMapping.toDomain(#parznbmndlhmbmxdto),'ehr-ParZnbmndlhmbmx-Save')")
    @ApiOperation(value = "保存年度量化目标明细（职能部门级 ）", tags = {"年度量化目标明细（职能部门级 ）" },  notes = "保存年度量化目标明细（职能部门级 ）")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmndlhmbmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody ParZnbmndlhmbmxDTO parznbmndlhmbmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parznbmndlhmbmxService.save(parznbmndlhmbmxMapping.toDomain(parznbmndlhmbmxdto)));
    }

    @PreAuthorize("hasPermission(this.parznbmndlhmbmxMapping.toDomain(#parznbmndlhmbmxdtos),'ehr-ParZnbmndlhmbmx-Save')")
    @ApiOperation(value = "批量保存年度量化目标明细（职能部门级 ）", tags = {"年度量化目标明细（职能部门级 ）" },  notes = "批量保存年度量化目标明细（职能部门级 ）")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmndlhmbmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParZnbmndlhmbmxDTO> parznbmndlhmbmxdtos) {
        parznbmndlhmbmxService.saveBatch(parznbmndlhmbmxMapping.toDomain(parznbmndlhmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parznbmndlhmbmxService.get(#parznbmndlhmbmx_id),'ehr-ParZnbmndlhmbmx-Remove')")
    @ApiOperation(value = "删除年度量化目标明细（职能部门级 ）", tags = {"年度量化目标明细（职能部门级 ）" },  notes = "删除年度量化目标明细（职能部门级 ）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parznbmndlhmbmxes/{parznbmndlhmbmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parznbmndlhmbmx_id") String parznbmndlhmbmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parznbmndlhmbmxService.remove(parznbmndlhmbmx_id));
    }

    @PreAuthorize("hasPermission(this.parznbmndlhmbmxService.getParznbmndlhmbmxByIds(#ids),'ehr-ParZnbmndlhmbmx-Remove')")
    @ApiOperation(value = "批量删除年度量化目标明细（职能部门级 ）", tags = {"年度量化目标明细（职能部门级 ）" },  notes = "批量删除年度量化目标明细（职能部门级 ）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parznbmndlhmbmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parznbmndlhmbmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParZnbmndlhmbmx-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"年度量化目标明细（职能部门级 ）" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parznbmndlhmbmxes/fetchdefault")
	public ResponseEntity<List<ParZnbmndlhmbmxDTO>> fetchDefault(ParZnbmndlhmbmxSearchContext context) {
        Page<ParZnbmndlhmbmx> domains = parznbmndlhmbmxService.searchDefault(context) ;
        List<ParZnbmndlhmbmxDTO> list = parznbmndlhmbmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParZnbmndlhmbmx-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"年度量化目标明细（职能部门级 ）" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parznbmndlhmbmxes/searchdefault")
	public ResponseEntity<Page<ParZnbmndlhmbmxDTO>> searchDefault(@RequestBody ParZnbmndlhmbmxSearchContext context) {
        Page<ParZnbmndlhmbmx> domains = parznbmndlhmbmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parznbmndlhmbmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

