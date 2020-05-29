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
import cn.ibizlab.ehr.core.sal.domain.SALSTDXMGZ;
import cn.ibizlab.ehr.core.sal.service.ISALSTDXMGZService;
import cn.ibizlab.ehr.core.sal.filter.SALSTDXMGZSearchContext;

@Slf4j
@Api(tags = {"项目工资标准" })
@RestController("WebApi-salstdxmgz")
@RequestMapping("")
public class SALSTDXMGZResource {

    @Autowired
    public ISALSTDXMGZService salstdxmgzService;

    @Autowired
    @Lazy
    public SALSTDXMGZMapping salstdxmgzMapping;

    @ApiOperation(value = "检查项目工资标准", tags = {"项目工资标准" },  notes = "检查项目工资标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdxmgzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SALSTDXMGZDTO salstdxmgzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salstdxmgzService.checkKey(salstdxmgzMapping.toDomain(salstdxmgzdto)));
    }

    @PreAuthorize("hasPermission(this.salstdxmgzService.get(#salstdxmgz_id),'ehr-SALSTDXMGZ-Remove')")
    @ApiOperation(value = "删除项目工资标准", tags = {"项目工资标准" },  notes = "删除项目工资标准")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdxmgzs/{salstdxmgz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salstdxmgz_id") String salstdxmgz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salstdxmgzService.remove(salstdxmgz_id));
    }

    @PreAuthorize("hasPermission(this.salstdxmgzService.getSalstdxmgzByIds(#ids),'ehr-SALSTDXMGZ-Remove')")
    @ApiOperation(value = "批量删除项目工资标准", tags = {"项目工资标准" },  notes = "批量删除项目工资标准")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdxmgzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salstdxmgzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salstdxmgzService.get(#salstdxmgz_id),'ehr-SALSTDXMGZ-Update')")
    @ApiOperation(value = "更新项目工资标准", tags = {"项目工资标准" },  notes = "更新项目工资标准")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdxmgzs/{salstdxmgz_id}")
    @Transactional
    public ResponseEntity<SALSTDXMGZDTO> update(@PathVariable("salstdxmgz_id") String salstdxmgz_id, @RequestBody SALSTDXMGZDTO salstdxmgzdto) {
		SALSTDXMGZ domain  = salstdxmgzMapping.toDomain(salstdxmgzdto);
        domain .setSalstdxmgzid(salstdxmgz_id);
		salstdxmgzService.update(domain );
		SALSTDXMGZDTO dto = salstdxmgzMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salstdxmgzService.getSalstdxmgzByEntities(this.salstdxmgzMapping.toDomain(#salstdxmgzdtos)),'ehr-SALSTDXMGZ-Update')")
    @ApiOperation(value = "批量更新项目工资标准", tags = {"项目工资标准" },  notes = "批量更新项目工资标准")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdxmgzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SALSTDXMGZDTO> salstdxmgzdtos) {
        salstdxmgzService.updateBatch(salstdxmgzMapping.toDomain(salstdxmgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取项目工资标准草稿", tags = {"项目工资标准" },  notes = "获取项目工资标准草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdxmgzs/getdraft")
    public ResponseEntity<SALSTDXMGZDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salstdxmgzMapping.toDto(salstdxmgzService.getDraft(new SALSTDXMGZ())));
    }

    @PreAuthorize("hasPermission(this.salstdxmgzMapping.toDomain(#salstdxmgzdto),'ehr-SALSTDXMGZ-Save')")
    @ApiOperation(value = "保存项目工资标准", tags = {"项目工资标准" },  notes = "保存项目工资标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdxmgzs/save")
    public ResponseEntity<Boolean> save(@RequestBody SALSTDXMGZDTO salstdxmgzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(salstdxmgzService.save(salstdxmgzMapping.toDomain(salstdxmgzdto)));
    }

    @PreAuthorize("hasPermission(this.salstdxmgzMapping.toDomain(#salstdxmgzdtos),'ehr-SALSTDXMGZ-Save')")
    @ApiOperation(value = "批量保存项目工资标准", tags = {"项目工资标准" },  notes = "批量保存项目工资标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdxmgzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SALSTDXMGZDTO> salstdxmgzdtos) {
        salstdxmgzService.saveBatch(salstdxmgzMapping.toDomain(salstdxmgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.salstdxmgzMapping.toDomain(returnObject.body),'ehr-SALSTDXMGZ-Get')")
    @ApiOperation(value = "获取项目工资标准", tags = {"项目工资标准" },  notes = "获取项目工资标准")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdxmgzs/{salstdxmgz_id}")
    public ResponseEntity<SALSTDXMGZDTO> get(@PathVariable("salstdxmgz_id") String salstdxmgz_id) {
        SALSTDXMGZ domain = salstdxmgzService.get(salstdxmgz_id);
        SALSTDXMGZDTO dto = salstdxmgzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salstdxmgzMapping.toDomain(#salstdxmgzdto),'ehr-SALSTDXMGZ-Create')")
    @ApiOperation(value = "新建项目工资标准", tags = {"项目工资标准" },  notes = "新建项目工资标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdxmgzs")
    @Transactional
    public ResponseEntity<SALSTDXMGZDTO> create(@RequestBody SALSTDXMGZDTO salstdxmgzdto) {
        SALSTDXMGZ domain = salstdxmgzMapping.toDomain(salstdxmgzdto);
		salstdxmgzService.create(domain);
        SALSTDXMGZDTO dto = salstdxmgzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salstdxmgzMapping.toDomain(#salstdxmgzdtos),'ehr-SALSTDXMGZ-Create')")
    @ApiOperation(value = "批量新建项目工资标准", tags = {"项目工资标准" },  notes = "批量新建项目工资标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdxmgzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SALSTDXMGZDTO> salstdxmgzdtos) {
        salstdxmgzService.createBatch(salstdxmgzMapping.toDomain(salstdxmgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDXMGZ-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"项目工资标准" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/salstdxmgzs/fetchdefault")
	public ResponseEntity<List<SALSTDXMGZDTO>> fetchDefault(SALSTDXMGZSearchContext context) {
        Page<SALSTDXMGZ> domains = salstdxmgzService.searchDefault(context) ;
        List<SALSTDXMGZDTO> list = salstdxmgzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDXMGZ-Default-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"项目工资标准" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/salstdxmgzs/searchdefault")
	public ResponseEntity<Page<SALSTDXMGZDTO>> searchDefault(@RequestBody SALSTDXMGZSearchContext context) {
        Page<SALSTDXMGZ> domains = salstdxmgzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salstdxmgzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

