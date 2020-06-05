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
import cn.ibizlab.ehr.core.sal.domain.SalStdzx;
import cn.ibizlab.ehr.core.sal.service.ISalStdzxService;
import cn.ibizlab.ehr.core.sal.filter.SalStdzxSearchContext;

@Slf4j
@Api(tags = {"专项津贴标准" })
@RestController("WebApi-salstdzx")
@RequestMapping("")
public class SalStdzxResource {

    @Autowired
    public ISalStdzxService salstdzxService;

    @Autowired
    @Lazy
    public SalStdzxMapping salstdzxMapping;

    @PreAuthorize("hasPermission(this.salstdzxMapping.toDomain(#salstdzxdto),'ehr-SalStdzx-Save')")
    @ApiOperation(value = "保存专项津贴标准", tags = {"专项津贴标准" },  notes = "保存专项津贴标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzxes/save")
    public ResponseEntity<Boolean> save(@RequestBody SalStdzxDTO salstdzxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(salstdzxService.save(salstdzxMapping.toDomain(salstdzxdto)));
    }

    @PreAuthorize("hasPermission(this.salstdzxMapping.toDomain(#salstdzxdtos),'ehr-SalStdzx-Save')")
    @ApiOperation(value = "批量保存专项津贴标准", tags = {"专项津贴标准" },  notes = "批量保存专项津贴标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SalStdzxDTO> salstdzxdtos) {
        salstdzxService.saveBatch(salstdzxMapping.toDomain(salstdzxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.salstdzxMapping.toDomain(returnObject.body),'ehr-SalStdzx-Get')")
    @ApiOperation(value = "获取专项津贴标准", tags = {"专项津贴标准" },  notes = "获取专项津贴标准")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdzxes/{salstdzx_id}")
    public ResponseEntity<SalStdzxDTO> get(@PathVariable("salstdzx_id") String salstdzx_id) {
        SalStdzx domain = salstdzxService.get(salstdzx_id);
        SalStdzxDTO dto = salstdzxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salstdzxService.get(#salstdzx_id),'ehr-SalStdzx-Update')")
    @ApiOperation(value = "更新专项津贴标准", tags = {"专项津贴标准" },  notes = "更新专项津贴标准")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdzxes/{salstdzx_id}")
    @Transactional
    public ResponseEntity<SalStdzxDTO> update(@PathVariable("salstdzx_id") String salstdzx_id, @RequestBody SalStdzxDTO salstdzxdto) {
		SalStdzx domain  = salstdzxMapping.toDomain(salstdzxdto);
        domain .setSalstdzxid(salstdzx_id);
		salstdzxService.update(domain );
		SalStdzxDTO dto = salstdzxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salstdzxService.getSalstdzxByEntities(this.salstdzxMapping.toDomain(#salstdzxdtos)),'ehr-SalStdzx-Update')")
    @ApiOperation(value = "批量更新专项津贴标准", tags = {"专项津贴标准" },  notes = "批量更新专项津贴标准")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdzxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SalStdzxDTO> salstdzxdtos) {
        salstdzxService.updateBatch(salstdzxMapping.toDomain(salstdzxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salstdzxMapping.toDomain(#salstdzxdto),'ehr-SalStdzx-Create')")
    @ApiOperation(value = "新建专项津贴标准", tags = {"专项津贴标准" },  notes = "新建专项津贴标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzxes")
    @Transactional
    public ResponseEntity<SalStdzxDTO> create(@RequestBody SalStdzxDTO salstdzxdto) {
        SalStdzx domain = salstdzxMapping.toDomain(salstdzxdto);
		salstdzxService.create(domain);
        SalStdzxDTO dto = salstdzxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salstdzxMapping.toDomain(#salstdzxdtos),'ehr-SalStdzx-Create')")
    @ApiOperation(value = "批量新建专项津贴标准", tags = {"专项津贴标准" },  notes = "批量新建专项津贴标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SalStdzxDTO> salstdzxdtos) {
        salstdzxService.createBatch(salstdzxMapping.toDomain(salstdzxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取专项津贴标准草稿", tags = {"专项津贴标准" },  notes = "获取专项津贴标准草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdzxes/getdraft")
    public ResponseEntity<SalStdzxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salstdzxMapping.toDto(salstdzxService.getDraft(new SalStdzx())));
    }

    @ApiOperation(value = "检查专项津贴标准", tags = {"专项津贴标准" },  notes = "检查专项津贴标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SalStdzxDTO salstdzxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salstdzxService.checkKey(salstdzxMapping.toDomain(salstdzxdto)));
    }

    @PreAuthorize("hasPermission(this.salstdzxService.get(#salstdzx_id),'ehr-SalStdzx-Remove')")
    @ApiOperation(value = "删除专项津贴标准", tags = {"专项津贴标准" },  notes = "删除专项津贴标准")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdzxes/{salstdzx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salstdzx_id") String salstdzx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salstdzxService.remove(salstdzx_id));
    }

    @PreAuthorize("hasPermission(this.salstdzxService.getSalstdzxByIds(#ids),'ehr-SalStdzx-Remove')")
    @ApiOperation(value = "批量删除专项津贴标准", tags = {"专项津贴标准" },  notes = "批量删除专项津贴标准")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdzxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salstdzxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalStdzx-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"专项津贴标准" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salstdzxes/fetchdefault")
	public ResponseEntity<List<SalStdzxDTO>> fetchDefault(SalStdzxSearchContext context) {
        Page<SalStdzx> domains = salstdzxService.searchDefault(context) ;
        List<SalStdzxDTO> list = salstdzxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalStdzx-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"专项津贴标准" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salstdzxes/searchdefault")
	public ResponseEntity<Page<SalStdzxDTO>> searchDefault(@RequestBody SalStdzxSearchContext context) {
        Page<SalStdzx> domains = salstdzxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salstdzxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

