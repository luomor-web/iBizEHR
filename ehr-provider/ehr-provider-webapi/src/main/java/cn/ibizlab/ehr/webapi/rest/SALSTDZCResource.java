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
import cn.ibizlab.ehr.core.sal.domain.SALSTDZC;
import cn.ibizlab.ehr.core.sal.service.ISALSTDZCService;
import cn.ibizlab.ehr.core.sal.filter.SALSTDZCSearchContext;

@Slf4j
@Api(tags = {"技术津贴标准" })
@RestController("WebApi-salstdzc")
@RequestMapping("")
public class SALSTDZCResource {

    @Autowired
    public ISALSTDZCService salstdzcService;

    @Autowired
    @Lazy
    public SALSTDZCMapping salstdzcMapping;

    @PreAuthorize("hasPermission(this.salstdzcMapping.toDomain(#salstdzcdto),'ehr-SALSTDZC-Create')")
    @ApiOperation(value = "新建技术津贴标准", tags = {"技术津贴标准" },  notes = "新建技术津贴标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzcs")
    @Transactional
    public ResponseEntity<SALSTDZCDTO> create(@RequestBody SALSTDZCDTO salstdzcdto) {
        SALSTDZC domain = salstdzcMapping.toDomain(salstdzcdto);
		salstdzcService.create(domain);
        SALSTDZCDTO dto = salstdzcMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salstdzcMapping.toDomain(#salstdzcdtos),'ehr-SALSTDZC-Create')")
    @ApiOperation(value = "批量新建技术津贴标准", tags = {"技术津贴标准" },  notes = "批量新建技术津贴标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzcs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SALSTDZCDTO> salstdzcdtos) {
        salstdzcService.createBatch(salstdzcMapping.toDomain(salstdzcdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.salstdzcMapping.toDomain(returnObject.body),'ehr-SALSTDZC-Get')")
    @ApiOperation(value = "获取技术津贴标准", tags = {"技术津贴标准" },  notes = "获取技术津贴标准")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdzcs/{salstdzc_id}")
    public ResponseEntity<SALSTDZCDTO> get(@PathVariable("salstdzc_id") String salstdzc_id) {
        SALSTDZC domain = salstdzcService.get(salstdzc_id);
        SALSTDZCDTO dto = salstdzcMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salstdzcMapping.toDomain(#salstdzcdto),'ehr-SALSTDZC-Save')")
    @ApiOperation(value = "保存技术津贴标准", tags = {"技术津贴标准" },  notes = "保存技术津贴标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzcs/save")
    public ResponseEntity<Boolean> save(@RequestBody SALSTDZCDTO salstdzcdto) {
        return ResponseEntity.status(HttpStatus.OK).body(salstdzcService.save(salstdzcMapping.toDomain(salstdzcdto)));
    }

    @PreAuthorize("hasPermission(this.salstdzcMapping.toDomain(#salstdzcdtos),'ehr-SALSTDZC-Save')")
    @ApiOperation(value = "批量保存技术津贴标准", tags = {"技术津贴标准" },  notes = "批量保存技术津贴标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzcs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SALSTDZCDTO> salstdzcdtos) {
        salstdzcService.saveBatch(salstdzcMapping.toDomain(salstdzcdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取技术津贴标准草稿", tags = {"技术津贴标准" },  notes = "获取技术津贴标准草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdzcs/getdraft")
    public ResponseEntity<SALSTDZCDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salstdzcMapping.toDto(salstdzcService.getDraft(new SALSTDZC())));
    }

    @PreAuthorize("hasPermission(this.salstdzcService.get(#salstdzc_id),'ehr-SALSTDZC-Remove')")
    @ApiOperation(value = "删除技术津贴标准", tags = {"技术津贴标准" },  notes = "删除技术津贴标准")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdzcs/{salstdzc_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salstdzc_id") String salstdzc_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salstdzcService.remove(salstdzc_id));
    }

    @PreAuthorize("hasPermission(this.salstdzcService.getSalstdzcByIds(#ids),'ehr-SALSTDZC-Remove')")
    @ApiOperation(value = "批量删除技术津贴标准", tags = {"技术津贴标准" },  notes = "批量删除技术津贴标准")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdzcs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salstdzcService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salstdzcService.get(#salstdzc_id),'ehr-SALSTDZC-Update')")
    @ApiOperation(value = "更新技术津贴标准", tags = {"技术津贴标准" },  notes = "更新技术津贴标准")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdzcs/{salstdzc_id}")
    @Transactional
    public ResponseEntity<SALSTDZCDTO> update(@PathVariable("salstdzc_id") String salstdzc_id, @RequestBody SALSTDZCDTO salstdzcdto) {
		SALSTDZC domain  = salstdzcMapping.toDomain(salstdzcdto);
        domain .setSalstdzcid(salstdzc_id);
		salstdzcService.update(domain );
		SALSTDZCDTO dto = salstdzcMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salstdzcService.getSalstdzcByEntities(this.salstdzcMapping.toDomain(#salstdzcdtos)),'ehr-SALSTDZC-Update')")
    @ApiOperation(value = "批量更新技术津贴标准", tags = {"技术津贴标准" },  notes = "批量更新技术津贴标准")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdzcs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SALSTDZCDTO> salstdzcdtos) {
        salstdzcService.updateBatch(salstdzcMapping.toDomain(salstdzcdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查技术津贴标准", tags = {"技术津贴标准" },  notes = "检查技术津贴标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzcs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SALSTDZCDTO salstdzcdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salstdzcService.checkKey(salstdzcMapping.toDomain(salstdzcdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDZC-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"技术津贴标准" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salstdzcs/fetchdefault")
	public ResponseEntity<List<SALSTDZCDTO>> fetchDefault(SALSTDZCSearchContext context) {
        Page<SALSTDZC> domains = salstdzcService.searchDefault(context) ;
        List<SALSTDZCDTO> list = salstdzcMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDZC-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"技术津贴标准" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salstdzcs/searchdefault")
	public ResponseEntity<Page<SALSTDZCDTO>> searchDefault(@RequestBody SALSTDZCSearchContext context) {
        Page<SALSTDZC> domains = salstdzcService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salstdzcMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

