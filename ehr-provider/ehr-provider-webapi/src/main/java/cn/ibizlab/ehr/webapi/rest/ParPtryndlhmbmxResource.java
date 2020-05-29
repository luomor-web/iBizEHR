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
import cn.ibizlab.ehr.core.par.domain.ParPtryndlhmbmx;
import cn.ibizlab.ehr.core.par.service.IParPtryndlhmbmxService;
import cn.ibizlab.ehr.core.par.filter.ParPtryndlhmbmxSearchContext;

@Slf4j
@Api(tags = {"年度量化目标明细（部门副职及以下人员）" })
@RestController("WebApi-parptryndlhmbmx")
@RequestMapping("")
public class ParPtryndlhmbmxResource {

    @Autowired
    public IParPtryndlhmbmxService parptryndlhmbmxService;

    @Autowired
    @Lazy
    public ParPtryndlhmbmxMapping parptryndlhmbmxMapping;

    @ApiOperation(value = "获取年度量化目标明细（部门副职及以下人员）草稿", tags = {"年度量化目标明细（部门副职及以下人员）" },  notes = "获取年度量化目标明细（部门副职及以下人员）草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/parptryndlhmbmxes/getdraft")
    public ResponseEntity<ParPtryndlhmbmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parptryndlhmbmxMapping.toDto(parptryndlhmbmxService.getDraft(new ParPtryndlhmbmx())));
    }

    @PreAuthorize("hasPermission(this.parptryndlhmbmxService.get(#parptryndlhmbmx_id),'ehr-ParPtryndlhmbmx-Remove')")
    @ApiOperation(value = "删除年度量化目标明细（部门副职及以下人员）", tags = {"年度量化目标明细（部门副职及以下人员）" },  notes = "删除年度量化目标明细（部门副职及以下人员）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parptryndlhmbmxes/{parptryndlhmbmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parptryndlhmbmx_id") String parptryndlhmbmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parptryndlhmbmxService.remove(parptryndlhmbmx_id));
    }

    @PreAuthorize("hasPermission(this.parptryndlhmbmxService.getParptryndlhmbmxByIds(#ids),'ehr-ParPtryndlhmbmx-Remove')")
    @ApiOperation(value = "批量删除年度量化目标明细（部门副职及以下人员）", tags = {"年度量化目标明细（部门副职及以下人员）" },  notes = "批量删除年度量化目标明细（部门副职及以下人员）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parptryndlhmbmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parptryndlhmbmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查年度量化目标明细（部门副职及以下人员）", tags = {"年度量化目标明细（部门副职及以下人员）" },  notes = "检查年度量化目标明细（部门副职及以下人员）")
	@RequestMapping(method = RequestMethod.POST, value = "/parptryndlhmbmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParPtryndlhmbmxDTO parptryndlhmbmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parptryndlhmbmxService.checkKey(parptryndlhmbmxMapping.toDomain(parptryndlhmbmxdto)));
    }

    @PostAuthorize("hasPermission(this.parptryndlhmbmxMapping.toDomain(returnObject.body),'ehr-ParPtryndlhmbmx-Get')")
    @ApiOperation(value = "获取年度量化目标明细（部门副职及以下人员）", tags = {"年度量化目标明细（部门副职及以下人员）" },  notes = "获取年度量化目标明细（部门副职及以下人员）")
	@RequestMapping(method = RequestMethod.GET, value = "/parptryndlhmbmxes/{parptryndlhmbmx_id}")
    public ResponseEntity<ParPtryndlhmbmxDTO> get(@PathVariable("parptryndlhmbmx_id") String parptryndlhmbmx_id) {
        ParPtryndlhmbmx domain = parptryndlhmbmxService.get(parptryndlhmbmx_id);
        ParPtryndlhmbmxDTO dto = parptryndlhmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parptryndlhmbmxMapping.toDomain(#parptryndlhmbmxdto),'ehr-ParPtryndlhmbmx-Save')")
    @ApiOperation(value = "保存年度量化目标明细（部门副职及以下人员）", tags = {"年度量化目标明细（部门副职及以下人员）" },  notes = "保存年度量化目标明细（部门副职及以下人员）")
	@RequestMapping(method = RequestMethod.POST, value = "/parptryndlhmbmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody ParPtryndlhmbmxDTO parptryndlhmbmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parptryndlhmbmxService.save(parptryndlhmbmxMapping.toDomain(parptryndlhmbmxdto)));
    }

    @PreAuthorize("hasPermission(this.parptryndlhmbmxMapping.toDomain(#parptryndlhmbmxdtos),'ehr-ParPtryndlhmbmx-Save')")
    @ApiOperation(value = "批量保存年度量化目标明细（部门副职及以下人员）", tags = {"年度量化目标明细（部门副职及以下人员）" },  notes = "批量保存年度量化目标明细（部门副职及以下人员）")
	@RequestMapping(method = RequestMethod.POST, value = "/parptryndlhmbmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParPtryndlhmbmxDTO> parptryndlhmbmxdtos) {
        parptryndlhmbmxService.saveBatch(parptryndlhmbmxMapping.toDomain(parptryndlhmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parptryndlhmbmxService.get(#parptryndlhmbmx_id),'ehr-ParPtryndlhmbmx-Update')")
    @ApiOperation(value = "更新年度量化目标明细（部门副职及以下人员）", tags = {"年度量化目标明细（部门副职及以下人员）" },  notes = "更新年度量化目标明细（部门副职及以下人员）")
	@RequestMapping(method = RequestMethod.PUT, value = "/parptryndlhmbmxes/{parptryndlhmbmx_id}")
    @Transactional
    public ResponseEntity<ParPtryndlhmbmxDTO> update(@PathVariable("parptryndlhmbmx_id") String parptryndlhmbmx_id, @RequestBody ParPtryndlhmbmxDTO parptryndlhmbmxdto) {
		ParPtryndlhmbmx domain  = parptryndlhmbmxMapping.toDomain(parptryndlhmbmxdto);
        domain .setParptryndlhmbmxid(parptryndlhmbmx_id);
		parptryndlhmbmxService.update(domain );
		ParPtryndlhmbmxDTO dto = parptryndlhmbmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parptryndlhmbmxService.getParptryndlhmbmxByEntities(this.parptryndlhmbmxMapping.toDomain(#parptryndlhmbmxdtos)),'ehr-ParPtryndlhmbmx-Update')")
    @ApiOperation(value = "批量更新年度量化目标明细（部门副职及以下人员）", tags = {"年度量化目标明细（部门副职及以下人员）" },  notes = "批量更新年度量化目标明细（部门副职及以下人员）")
	@RequestMapping(method = RequestMethod.PUT, value = "/parptryndlhmbmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParPtryndlhmbmxDTO> parptryndlhmbmxdtos) {
        parptryndlhmbmxService.updateBatch(parptryndlhmbmxMapping.toDomain(parptryndlhmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parptryndlhmbmxMapping.toDomain(#parptryndlhmbmxdto),'ehr-ParPtryndlhmbmx-Create')")
    @ApiOperation(value = "新建年度量化目标明细（部门副职及以下人员）", tags = {"年度量化目标明细（部门副职及以下人员）" },  notes = "新建年度量化目标明细（部门副职及以下人员）")
	@RequestMapping(method = RequestMethod.POST, value = "/parptryndlhmbmxes")
    @Transactional
    public ResponseEntity<ParPtryndlhmbmxDTO> create(@RequestBody ParPtryndlhmbmxDTO parptryndlhmbmxdto) {
        ParPtryndlhmbmx domain = parptryndlhmbmxMapping.toDomain(parptryndlhmbmxdto);
		parptryndlhmbmxService.create(domain);
        ParPtryndlhmbmxDTO dto = parptryndlhmbmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parptryndlhmbmxMapping.toDomain(#parptryndlhmbmxdtos),'ehr-ParPtryndlhmbmx-Create')")
    @ApiOperation(value = "批量新建年度量化目标明细（部门副职及以下人员）", tags = {"年度量化目标明细（部门副职及以下人员）" },  notes = "批量新建年度量化目标明细（部门副职及以下人员）")
	@RequestMapping(method = RequestMethod.POST, value = "/parptryndlhmbmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParPtryndlhmbmxDTO> parptryndlhmbmxdtos) {
        parptryndlhmbmxService.createBatch(parptryndlhmbmxMapping.toDomain(parptryndlhmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParPtryndlhmbmx-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"年度量化目标明细（部门副职及以下人员）" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parptryndlhmbmxes/fetchdefault")
	public ResponseEntity<List<ParPtryndlhmbmxDTO>> fetchDefault(ParPtryndlhmbmxSearchContext context) {
        Page<ParPtryndlhmbmx> domains = parptryndlhmbmxService.searchDefault(context) ;
        List<ParPtryndlhmbmxDTO> list = parptryndlhmbmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParPtryndlhmbmx-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"年度量化目标明细（部门副职及以下人员）" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parptryndlhmbmxes/searchdefault")
	public ResponseEntity<Page<ParPtryndlhmbmxDTO>> searchDefault(@RequestBody ParPtryndlhmbmxSearchContext context) {
        Page<ParPtryndlhmbmx> domains = parptryndlhmbmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parptryndlhmbmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

