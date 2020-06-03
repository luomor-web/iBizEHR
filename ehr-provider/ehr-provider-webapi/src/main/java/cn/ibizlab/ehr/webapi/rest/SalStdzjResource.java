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
import cn.ibizlab.ehr.core.sal.domain.SalStdzj;
import cn.ibizlab.ehr.core.sal.service.ISalStdzjService;
import cn.ibizlab.ehr.core.sal.filter.SalStdzjSearchContext;

@Slf4j
@Api(tags = {"专家津贴标准" })
@RestController("WebApi-salstdzj")
@RequestMapping("")
public class SalStdzjResource {

    @Autowired
    public ISalStdzjService salstdzjService;

    @Autowired
    @Lazy
    public SalStdzjMapping salstdzjMapping;

    @PostAuthorize("hasPermission(this.salstdzjMapping.toDomain(returnObject.body),'ehr-SalStdzj-Get')")
    @ApiOperation(value = "获取专家津贴标准", tags = {"专家津贴标准" },  notes = "获取专家津贴标准")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdzjs/{salstdzj_id}")
    public ResponseEntity<SalStdzjDTO> get(@PathVariable("salstdzj_id") String salstdzj_id) {
        SalStdzj domain = salstdzjService.get(salstdzj_id);
        SalStdzjDTO dto = salstdzjMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salstdzjMapping.toDomain(#salstdzjdto),'ehr-SalStdzj-Create')")
    @ApiOperation(value = "新建专家津贴标准", tags = {"专家津贴标准" },  notes = "新建专家津贴标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzjs")
    @Transactional
    public ResponseEntity<SalStdzjDTO> create(@RequestBody SalStdzjDTO salstdzjdto) {
        SalStdzj domain = salstdzjMapping.toDomain(salstdzjdto);
		salstdzjService.create(domain);
        SalStdzjDTO dto = salstdzjMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salstdzjMapping.toDomain(#salstdzjdtos),'ehr-SalStdzj-Create')")
    @ApiOperation(value = "批量新建专家津贴标准", tags = {"专家津贴标准" },  notes = "批量新建专家津贴标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzjs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SalStdzjDTO> salstdzjdtos) {
        salstdzjService.createBatch(salstdzjMapping.toDomain(salstdzjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salstdzjMapping.toDomain(#salstdzjdto),'ehr-SalStdzj-Save')")
    @ApiOperation(value = "保存专家津贴标准", tags = {"专家津贴标准" },  notes = "保存专家津贴标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzjs/save")
    public ResponseEntity<Boolean> save(@RequestBody SalStdzjDTO salstdzjdto) {
        return ResponseEntity.status(HttpStatus.OK).body(salstdzjService.save(salstdzjMapping.toDomain(salstdzjdto)));
    }

    @PreAuthorize("hasPermission(this.salstdzjMapping.toDomain(#salstdzjdtos),'ehr-SalStdzj-Save')")
    @ApiOperation(value = "批量保存专家津贴标准", tags = {"专家津贴标准" },  notes = "批量保存专家津贴标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzjs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SalStdzjDTO> salstdzjdtos) {
        salstdzjService.saveBatch(salstdzjMapping.toDomain(salstdzjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salstdzjService.get(#salstdzj_id),'ehr-SalStdzj-Update')")
    @ApiOperation(value = "更新专家津贴标准", tags = {"专家津贴标准" },  notes = "更新专家津贴标准")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdzjs/{salstdzj_id}")
    @Transactional
    public ResponseEntity<SalStdzjDTO> update(@PathVariable("salstdzj_id") String salstdzj_id, @RequestBody SalStdzjDTO salstdzjdto) {
		SalStdzj domain  = salstdzjMapping.toDomain(salstdzjdto);
        domain .setSalstdzjid(salstdzj_id);
		salstdzjService.update(domain );
		SalStdzjDTO dto = salstdzjMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salstdzjService.getSalstdzjByEntities(this.salstdzjMapping.toDomain(#salstdzjdtos)),'ehr-SalStdzj-Update')")
    @ApiOperation(value = "批量更新专家津贴标准", tags = {"专家津贴标准" },  notes = "批量更新专家津贴标准")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdzjs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SalStdzjDTO> salstdzjdtos) {
        salstdzjService.updateBatch(salstdzjMapping.toDomain(salstdzjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salstdzjService.get(#salstdzj_id),'ehr-SalStdzj-Remove')")
    @ApiOperation(value = "删除专家津贴标准", tags = {"专家津贴标准" },  notes = "删除专家津贴标准")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdzjs/{salstdzj_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salstdzj_id") String salstdzj_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salstdzjService.remove(salstdzj_id));
    }

    @PreAuthorize("hasPermission(this.salstdzjService.getSalstdzjByIds(#ids),'ehr-SalStdzj-Remove')")
    @ApiOperation(value = "批量删除专家津贴标准", tags = {"专家津贴标准" },  notes = "批量删除专家津贴标准")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdzjs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salstdzjService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取专家津贴标准草稿", tags = {"专家津贴标准" },  notes = "获取专家津贴标准草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdzjs/getdraft")
    public ResponseEntity<SalStdzjDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salstdzjMapping.toDto(salstdzjService.getDraft(new SalStdzj())));
    }

    @ApiOperation(value = "检查专家津贴标准", tags = {"专家津贴标准" },  notes = "检查专家津贴标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzjs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SalStdzjDTO salstdzjdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salstdzjService.checkKey(salstdzjMapping.toDomain(salstdzjdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalStdzj-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"专家津贴标准" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salstdzjs/fetchdefault")
	public ResponseEntity<List<SalStdzjDTO>> fetchDefault(SalStdzjSearchContext context) {
        Page<SalStdzj> domains = salstdzjService.searchDefault(context) ;
        List<SalStdzjDTO> list = salstdzjMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalStdzj-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"专家津贴标准" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salstdzjs/searchdefault")
	public ResponseEntity<Page<SalStdzjDTO>> searchDefault(@RequestBody SalStdzjSearchContext context) {
        Page<SalStdzj> domains = salstdzjService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salstdzjMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

