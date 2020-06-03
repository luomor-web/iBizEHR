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
import cn.ibizlab.ehr.core.sal.domain.SalStdgl;
import cn.ibizlab.ehr.core.sal.service.ISalStdglService;
import cn.ibizlab.ehr.core.sal.filter.SalStdglSearchContext;

@Slf4j
@Api(tags = {"工龄工资标准" })
@RestController("WebApi-salstdgl")
@RequestMapping("")
public class SalStdglResource {

    @Autowired
    public ISalStdglService salstdglService;

    @Autowired
    @Lazy
    public SalStdglMapping salstdglMapping;

    @PreAuthorize("hasPermission(this.salstdglService.get(#salstdgl_id),'ehr-SalStdgl-Remove')")
    @ApiOperation(value = "删除工龄工资标准", tags = {"工龄工资标准" },  notes = "删除工龄工资标准")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdgls/{salstdgl_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salstdgl_id") String salstdgl_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salstdglService.remove(salstdgl_id));
    }

    @PreAuthorize("hasPermission(this.salstdglService.getSalstdglByIds(#ids),'ehr-SalStdgl-Remove')")
    @ApiOperation(value = "批量删除工龄工资标准", tags = {"工龄工资标准" },  notes = "批量删除工龄工资标准")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdgls/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salstdglService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salstdglService.get(#salstdgl_id),'ehr-SalStdgl-Update')")
    @ApiOperation(value = "更新工龄工资标准", tags = {"工龄工资标准" },  notes = "更新工龄工资标准")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdgls/{salstdgl_id}")
    @Transactional
    public ResponseEntity<SalStdglDTO> update(@PathVariable("salstdgl_id") String salstdgl_id, @RequestBody SalStdglDTO salstdgldto) {
		SalStdgl domain  = salstdglMapping.toDomain(salstdgldto);
        domain .setSalstdglid(salstdgl_id);
		salstdglService.update(domain );
		SalStdglDTO dto = salstdglMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salstdglService.getSalstdglByEntities(this.salstdglMapping.toDomain(#salstdgldtos)),'ehr-SalStdgl-Update')")
    @ApiOperation(value = "批量更新工龄工资标准", tags = {"工龄工资标准" },  notes = "批量更新工龄工资标准")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdgls/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SalStdglDTO> salstdgldtos) {
        salstdglService.updateBatch(salstdglMapping.toDomain(salstdgldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salstdglMapping.toDomain(#salstdgldto),'ehr-SalStdgl-Create')")
    @ApiOperation(value = "新建工龄工资标准", tags = {"工龄工资标准" },  notes = "新建工龄工资标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgls")
    @Transactional
    public ResponseEntity<SalStdglDTO> create(@RequestBody SalStdglDTO salstdgldto) {
        SalStdgl domain = salstdglMapping.toDomain(salstdgldto);
		salstdglService.create(domain);
        SalStdglDTO dto = salstdglMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salstdglMapping.toDomain(#salstdgldtos),'ehr-SalStdgl-Create')")
    @ApiOperation(value = "批量新建工龄工资标准", tags = {"工龄工资标准" },  notes = "批量新建工龄工资标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgls/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SalStdglDTO> salstdgldtos) {
        salstdglService.createBatch(salstdglMapping.toDomain(salstdgldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查工龄工资标准", tags = {"工龄工资标准" },  notes = "检查工龄工资标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgls/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SalStdglDTO salstdgldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salstdglService.checkKey(salstdglMapping.toDomain(salstdgldto)));
    }

    @PreAuthorize("hasPermission(this.salstdglMapping.toDomain(#salstdgldto),'ehr-SalStdgl-Save')")
    @ApiOperation(value = "保存工龄工资标准", tags = {"工龄工资标准" },  notes = "保存工龄工资标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgls/save")
    public ResponseEntity<Boolean> save(@RequestBody SalStdglDTO salstdgldto) {
        return ResponseEntity.status(HttpStatus.OK).body(salstdglService.save(salstdglMapping.toDomain(salstdgldto)));
    }

    @PreAuthorize("hasPermission(this.salstdglMapping.toDomain(#salstdgldtos),'ehr-SalStdgl-Save')")
    @ApiOperation(value = "批量保存工龄工资标准", tags = {"工龄工资标准" },  notes = "批量保存工龄工资标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgls/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SalStdglDTO> salstdgldtos) {
        salstdglService.saveBatch(salstdglMapping.toDomain(salstdgldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.salstdglMapping.toDomain(returnObject.body),'ehr-SalStdgl-Get')")
    @ApiOperation(value = "获取工龄工资标准", tags = {"工龄工资标准" },  notes = "获取工龄工资标准")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdgls/{salstdgl_id}")
    public ResponseEntity<SalStdglDTO> get(@PathVariable("salstdgl_id") String salstdgl_id) {
        SalStdgl domain = salstdglService.get(salstdgl_id);
        SalStdglDTO dto = salstdglMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取工龄工资标准草稿", tags = {"工龄工资标准" },  notes = "获取工龄工资标准草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdgls/getdraft")
    public ResponseEntity<SalStdglDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salstdglMapping.toDto(salstdglService.getDraft(new SalStdgl())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalStdgl-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"工龄工资标准" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salstdgls/fetchdefault")
	public ResponseEntity<List<SalStdglDTO>> fetchDefault(SalStdglSearchContext context) {
        Page<SalStdgl> domains = salstdglService.searchDefault(context) ;
        List<SalStdglDTO> list = salstdglMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalStdgl-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"工龄工资标准" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salstdgls/searchdefault")
	public ResponseEntity<Page<SalStdglDTO>> searchDefault(@RequestBody SalStdglSearchContext context) {
        Page<SalStdgl> domains = salstdglService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salstdglMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

