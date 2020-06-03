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
import cn.ibizlab.ehr.core.sal.domain.SalStdzc;
import cn.ibizlab.ehr.core.sal.service.ISalStdzcService;
import cn.ibizlab.ehr.core.sal.filter.SalStdzcSearchContext;

@Slf4j
@Api(tags = {"技术津贴标准" })
@RestController("WebApi-salstdzc")
@RequestMapping("")
public class SalStdzcResource {

    @Autowired
    public ISalStdzcService salstdzcService;

    @Autowired
    @Lazy
    public SalStdzcMapping salstdzcMapping;

    @PreAuthorize("hasPermission(this.salstdzcMapping.toDomain(#salstdzcdto),'ehr-SalStdzc-Create')")
    @ApiOperation(value = "新建技术津贴标准", tags = {"技术津贴标准" },  notes = "新建技术津贴标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzcs")
    @Transactional
    public ResponseEntity<SalStdzcDTO> create(@RequestBody SalStdzcDTO salstdzcdto) {
        SalStdzc domain = salstdzcMapping.toDomain(salstdzcdto);
		salstdzcService.create(domain);
        SalStdzcDTO dto = salstdzcMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salstdzcMapping.toDomain(#salstdzcdtos),'ehr-SalStdzc-Create')")
    @ApiOperation(value = "批量新建技术津贴标准", tags = {"技术津贴标准" },  notes = "批量新建技术津贴标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzcs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SalStdzcDTO> salstdzcdtos) {
        salstdzcService.createBatch(salstdzcMapping.toDomain(salstdzcdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.salstdzcMapping.toDomain(returnObject.body),'ehr-SalStdzc-Get')")
    @ApiOperation(value = "获取技术津贴标准", tags = {"技术津贴标准" },  notes = "获取技术津贴标准")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdzcs/{salstdzc_id}")
    public ResponseEntity<SalStdzcDTO> get(@PathVariable("salstdzc_id") String salstdzc_id) {
        SalStdzc domain = salstdzcService.get(salstdzc_id);
        SalStdzcDTO dto = salstdzcMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salstdzcMapping.toDomain(#salstdzcdto),'ehr-SalStdzc-Save')")
    @ApiOperation(value = "保存技术津贴标准", tags = {"技术津贴标准" },  notes = "保存技术津贴标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzcs/save")
    public ResponseEntity<Boolean> save(@RequestBody SalStdzcDTO salstdzcdto) {
        return ResponseEntity.status(HttpStatus.OK).body(salstdzcService.save(salstdzcMapping.toDomain(salstdzcdto)));
    }

    @PreAuthorize("hasPermission(this.salstdzcMapping.toDomain(#salstdzcdtos),'ehr-SalStdzc-Save')")
    @ApiOperation(value = "批量保存技术津贴标准", tags = {"技术津贴标准" },  notes = "批量保存技术津贴标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzcs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SalStdzcDTO> salstdzcdtos) {
        salstdzcService.saveBatch(salstdzcMapping.toDomain(salstdzcdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取技术津贴标准草稿", tags = {"技术津贴标准" },  notes = "获取技术津贴标准草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdzcs/getdraft")
    public ResponseEntity<SalStdzcDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salstdzcMapping.toDto(salstdzcService.getDraft(new SalStdzc())));
    }

    @PreAuthorize("hasPermission(this.salstdzcService.get(#salstdzc_id),'ehr-SalStdzc-Remove')")
    @ApiOperation(value = "删除技术津贴标准", tags = {"技术津贴标准" },  notes = "删除技术津贴标准")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdzcs/{salstdzc_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salstdzc_id") String salstdzc_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salstdzcService.remove(salstdzc_id));
    }

    @PreAuthorize("hasPermission(this.salstdzcService.getSalstdzcByIds(#ids),'ehr-SalStdzc-Remove')")
    @ApiOperation(value = "批量删除技术津贴标准", tags = {"技术津贴标准" },  notes = "批量删除技术津贴标准")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdzcs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salstdzcService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salstdzcService.get(#salstdzc_id),'ehr-SalStdzc-Update')")
    @ApiOperation(value = "更新技术津贴标准", tags = {"技术津贴标准" },  notes = "更新技术津贴标准")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdzcs/{salstdzc_id}")
    @Transactional
    public ResponseEntity<SalStdzcDTO> update(@PathVariable("salstdzc_id") String salstdzc_id, @RequestBody SalStdzcDTO salstdzcdto) {
		SalStdzc domain  = salstdzcMapping.toDomain(salstdzcdto);
        domain .setSalstdzcid(salstdzc_id);
		salstdzcService.update(domain );
		SalStdzcDTO dto = salstdzcMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salstdzcService.getSalstdzcByEntities(this.salstdzcMapping.toDomain(#salstdzcdtos)),'ehr-SalStdzc-Update')")
    @ApiOperation(value = "批量更新技术津贴标准", tags = {"技术津贴标准" },  notes = "批量更新技术津贴标准")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdzcs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SalStdzcDTO> salstdzcdtos) {
        salstdzcService.updateBatch(salstdzcMapping.toDomain(salstdzcdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查技术津贴标准", tags = {"技术津贴标准" },  notes = "检查技术津贴标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzcs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SalStdzcDTO salstdzcdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salstdzcService.checkKey(salstdzcMapping.toDomain(salstdzcdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalStdzc-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"技术津贴标准" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salstdzcs/fetchdefault")
	public ResponseEntity<List<SalStdzcDTO>> fetchDefault(SalStdzcSearchContext context) {
        Page<SalStdzc> domains = salstdzcService.searchDefault(context) ;
        List<SalStdzcDTO> list = salstdzcMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalStdzc-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"技术津贴标准" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salstdzcs/searchdefault")
	public ResponseEntity<Page<SalStdzcDTO>> searchDefault(@RequestBody SalStdzcSearchContext context) {
        Page<SalStdzc> domains = salstdzcService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salstdzcMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

