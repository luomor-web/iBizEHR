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
import cn.ibizlab.ehr.core.par.domain.ParLhmbmx;
import cn.ibizlab.ehr.core.par.service.IParLhmbmxService;
import cn.ibizlab.ehr.core.par.filter.ParLhmbmxSearchContext;

@Slf4j
@Api(tags = {"绩效量化目标明细" })
@RestController("WebApi-parlhmbmx")
@RequestMapping("")
public class ParLhmbmxResource {

    @Autowired
    public IParLhmbmxService parlhmbmxService;

    @Autowired
    @Lazy
    public ParLhmbmxMapping parlhmbmxMapping;

    @ApiOperation(value = "检查绩效量化目标明细", tags = {"绩效量化目标明细" },  notes = "检查绩效量化目标明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parlhmbmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParLhmbmxDTO parlhmbmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parlhmbmxService.checkKey(parlhmbmxMapping.toDomain(parlhmbmxdto)));
    }

    @PreAuthorize("hasPermission(this.parlhmbmxService.get(#parlhmbmx_id),'ehr-ParLhmbmx-Remove')")
    @ApiOperation(value = "删除绩效量化目标明细", tags = {"绩效量化目标明细" },  notes = "删除绩效量化目标明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parlhmbmxes/{parlhmbmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parlhmbmx_id") String parlhmbmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parlhmbmxService.remove(parlhmbmx_id));
    }

    @PreAuthorize("hasPermission(this.parlhmbmxService.getParlhmbmxByIds(#ids),'ehr-ParLhmbmx-Remove')")
    @ApiOperation(value = "批量删除绩效量化目标明细", tags = {"绩效量化目标明细" },  notes = "批量删除绩效量化目标明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parlhmbmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parlhmbmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parlhmbmxMapping.toDomain(#parlhmbmxdto),'ehr-ParLhmbmx-Save')")
    @ApiOperation(value = "保存绩效量化目标明细", tags = {"绩效量化目标明细" },  notes = "保存绩效量化目标明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parlhmbmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody ParLhmbmxDTO parlhmbmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parlhmbmxService.save(parlhmbmxMapping.toDomain(parlhmbmxdto)));
    }

    @PreAuthorize("hasPermission(this.parlhmbmxMapping.toDomain(#parlhmbmxdtos),'ehr-ParLhmbmx-Save')")
    @ApiOperation(value = "批量保存绩效量化目标明细", tags = {"绩效量化目标明细" },  notes = "批量保存绩效量化目标明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parlhmbmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParLhmbmxDTO> parlhmbmxdtos) {
        parlhmbmxService.saveBatch(parlhmbmxMapping.toDomain(parlhmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取绩效量化目标明细草稿", tags = {"绩效量化目标明细" },  notes = "获取绩效量化目标明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/parlhmbmxes/getdraft")
    public ResponseEntity<ParLhmbmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parlhmbmxMapping.toDto(parlhmbmxService.getDraft(new ParLhmbmx())));
    }

    @PostAuthorize("hasPermission(this.parlhmbmxMapping.toDomain(returnObject.body),'ehr-ParLhmbmx-Get')")
    @ApiOperation(value = "获取绩效量化目标明细", tags = {"绩效量化目标明细" },  notes = "获取绩效量化目标明细")
	@RequestMapping(method = RequestMethod.GET, value = "/parlhmbmxes/{parlhmbmx_id}")
    public ResponseEntity<ParLhmbmxDTO> get(@PathVariable("parlhmbmx_id") String parlhmbmx_id) {
        ParLhmbmx domain = parlhmbmxService.get(parlhmbmx_id);
        ParLhmbmxDTO dto = parlhmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parlhmbmxService.get(#parlhmbmx_id),'ehr-ParLhmbmx-Update')")
    @ApiOperation(value = "更新绩效量化目标明细", tags = {"绩效量化目标明细" },  notes = "更新绩效量化目标明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/parlhmbmxes/{parlhmbmx_id}")
    @Transactional
    public ResponseEntity<ParLhmbmxDTO> update(@PathVariable("parlhmbmx_id") String parlhmbmx_id, @RequestBody ParLhmbmxDTO parlhmbmxdto) {
		ParLhmbmx domain  = parlhmbmxMapping.toDomain(parlhmbmxdto);
        domain .setParlhmbmxid(parlhmbmx_id);
		parlhmbmxService.update(domain );
		ParLhmbmxDTO dto = parlhmbmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parlhmbmxService.getParlhmbmxByEntities(this.parlhmbmxMapping.toDomain(#parlhmbmxdtos)),'ehr-ParLhmbmx-Update')")
    @ApiOperation(value = "批量更新绩效量化目标明细", tags = {"绩效量化目标明细" },  notes = "批量更新绩效量化目标明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/parlhmbmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParLhmbmxDTO> parlhmbmxdtos) {
        parlhmbmxService.updateBatch(parlhmbmxMapping.toDomain(parlhmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parlhmbmxMapping.toDomain(#parlhmbmxdto),'ehr-ParLhmbmx-Create')")
    @ApiOperation(value = "新建绩效量化目标明细", tags = {"绩效量化目标明细" },  notes = "新建绩效量化目标明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parlhmbmxes")
    @Transactional
    public ResponseEntity<ParLhmbmxDTO> create(@RequestBody ParLhmbmxDTO parlhmbmxdto) {
        ParLhmbmx domain = parlhmbmxMapping.toDomain(parlhmbmxdto);
		parlhmbmxService.create(domain);
        ParLhmbmxDTO dto = parlhmbmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parlhmbmxMapping.toDomain(#parlhmbmxdtos),'ehr-ParLhmbmx-Create')")
    @ApiOperation(value = "批量新建绩效量化目标明细", tags = {"绩效量化目标明细" },  notes = "批量新建绩效量化目标明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parlhmbmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParLhmbmxDTO> parlhmbmxdtos) {
        parlhmbmxService.createBatch(parlhmbmxMapping.toDomain(parlhmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParLhmbmx-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"绩效量化目标明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parlhmbmxes/fetchdefault")
	public ResponseEntity<List<ParLhmbmxDTO>> fetchDefault(ParLhmbmxSearchContext context) {
        Page<ParLhmbmx> domains = parlhmbmxService.searchDefault(context) ;
        List<ParLhmbmxDTO> list = parlhmbmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParLhmbmx-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"绩效量化目标明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parlhmbmxes/searchdefault")
	public ResponseEntity<Page<ParLhmbmxDTO>> searchDefault(@RequestBody ParLhmbmxSearchContext context) {
        Page<ParLhmbmx> domains = parlhmbmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parlhmbmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

