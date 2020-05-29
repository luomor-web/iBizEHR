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
import cn.ibizlab.ehr.core.sal.domain.SalStdgwgz;
import cn.ibizlab.ehr.core.sal.service.ISalStdgwgzService;
import cn.ibizlab.ehr.core.sal.filter.SalStdgwgzSearchContext;

@Slf4j
@Api(tags = {"岗位工资标准" })
@RestController("WebApi-salstdgwgz")
@RequestMapping("")
public class SalStdgwgzResource {

    @Autowired
    public ISalStdgwgzService salstdgwgzService;

    @Autowired
    @Lazy
    public SalStdgwgzMapping salstdgwgzMapping;

    @PreAuthorize("hasPermission(this.salstdgwgzService.get(#salstdgwgz_id),'ehr-SalStdgwgz-Remove')")
    @ApiOperation(value = "删除岗位工资标准", tags = {"岗位工资标准" },  notes = "删除岗位工资标准")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdgwgzs/{salstdgwgz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salstdgwgz_id") String salstdgwgz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salstdgwgzService.remove(salstdgwgz_id));
    }

    @PreAuthorize("hasPermission(this.salstdgwgzService.getSalstdgwgzByIds(#ids),'ehr-SalStdgwgz-Remove')")
    @ApiOperation(value = "批量删除岗位工资标准", tags = {"岗位工资标准" },  notes = "批量删除岗位工资标准")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdgwgzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salstdgwgzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salstdgwgzMapping.toDomain(#salstdgwgzdto),'ehr-SalStdgwgz-Save')")
    @ApiOperation(value = "保存岗位工资标准", tags = {"岗位工资标准" },  notes = "保存岗位工资标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgwgzs/save")
    public ResponseEntity<Boolean> save(@RequestBody SalStdgwgzDTO salstdgwgzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(salstdgwgzService.save(salstdgwgzMapping.toDomain(salstdgwgzdto)));
    }

    @PreAuthorize("hasPermission(this.salstdgwgzMapping.toDomain(#salstdgwgzdtos),'ehr-SalStdgwgz-Save')")
    @ApiOperation(value = "批量保存岗位工资标准", tags = {"岗位工资标准" },  notes = "批量保存岗位工资标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgwgzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SalStdgwgzDTO> salstdgwgzdtos) {
        salstdgwgzService.saveBatch(salstdgwgzMapping.toDomain(salstdgwgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salstdgwgzMapping.toDomain(#salstdgwgzdto),'ehr-SalStdgwgz-Create')")
    @ApiOperation(value = "新建岗位工资标准", tags = {"岗位工资标准" },  notes = "新建岗位工资标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgwgzs")
    @Transactional
    public ResponseEntity<SalStdgwgzDTO> create(@RequestBody SalStdgwgzDTO salstdgwgzdto) {
        SalStdgwgz domain = salstdgwgzMapping.toDomain(salstdgwgzdto);
		salstdgwgzService.create(domain);
        SalStdgwgzDTO dto = salstdgwgzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salstdgwgzMapping.toDomain(#salstdgwgzdtos),'ehr-SalStdgwgz-Create')")
    @ApiOperation(value = "批量新建岗位工资标准", tags = {"岗位工资标准" },  notes = "批量新建岗位工资标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgwgzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SalStdgwgzDTO> salstdgwgzdtos) {
        salstdgwgzService.createBatch(salstdgwgzMapping.toDomain(salstdgwgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.salstdgwgzMapping.toDomain(returnObject.body),'ehr-SalStdgwgz-Get')")
    @ApiOperation(value = "获取岗位工资标准", tags = {"岗位工资标准" },  notes = "获取岗位工资标准")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdgwgzs/{salstdgwgz_id}")
    public ResponseEntity<SalStdgwgzDTO> get(@PathVariable("salstdgwgz_id") String salstdgwgz_id) {
        SalStdgwgz domain = salstdgwgzService.get(salstdgwgz_id);
        SalStdgwgzDTO dto = salstdgwgzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "检查岗位工资标准", tags = {"岗位工资标准" },  notes = "检查岗位工资标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgwgzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SalStdgwgzDTO salstdgwgzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salstdgwgzService.checkKey(salstdgwgzMapping.toDomain(salstdgwgzdto)));
    }

    @PreAuthorize("hasPermission(this.salstdgwgzService.get(#salstdgwgz_id),'ehr-SalStdgwgz-Update')")
    @ApiOperation(value = "更新岗位工资标准", tags = {"岗位工资标准" },  notes = "更新岗位工资标准")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdgwgzs/{salstdgwgz_id}")
    @Transactional
    public ResponseEntity<SalStdgwgzDTO> update(@PathVariable("salstdgwgz_id") String salstdgwgz_id, @RequestBody SalStdgwgzDTO salstdgwgzdto) {
		SalStdgwgz domain  = salstdgwgzMapping.toDomain(salstdgwgzdto);
        domain .setSalstdgwgzid(salstdgwgz_id);
		salstdgwgzService.update(domain );
		SalStdgwgzDTO dto = salstdgwgzMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salstdgwgzService.getSalstdgwgzByEntities(this.salstdgwgzMapping.toDomain(#salstdgwgzdtos)),'ehr-SalStdgwgz-Update')")
    @ApiOperation(value = "批量更新岗位工资标准", tags = {"岗位工资标准" },  notes = "批量更新岗位工资标准")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdgwgzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SalStdgwgzDTO> salstdgwgzdtos) {
        salstdgwgzService.updateBatch(salstdgwgzMapping.toDomain(salstdgwgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取岗位工资标准草稿", tags = {"岗位工资标准" },  notes = "获取岗位工资标准草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdgwgzs/getdraft")
    public ResponseEntity<SalStdgwgzDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salstdgwgzMapping.toDto(salstdgwgzService.getDraft(new SalStdgwgz())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalStdgwgz-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"岗位工资标准" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salstdgwgzs/fetchdefault")
	public ResponseEntity<List<SalStdgwgzDTO>> fetchDefault(SalStdgwgzSearchContext context) {
        Page<SalStdgwgz> domains = salstdgwgzService.searchDefault(context) ;
        List<SalStdgwgzDTO> list = salstdgwgzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalStdgwgz-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"岗位工资标准" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salstdgwgzs/searchdefault")
	public ResponseEntity<Page<SalStdgwgzDTO>> searchDefault(@RequestBody SalStdgwgzSearchContext context) {
        Page<SalStdgwgz> domains = salstdgwgzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salstdgwgzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

