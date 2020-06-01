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
import cn.ibizlab.ehr.core.sal.domain.SalLog;
import cn.ibizlab.ehr.core.sal.service.ISalLogService;
import cn.ibizlab.ehr.core.sal.filter.SalLogSearchContext;

@Slf4j
@Api(tags = {"薪酬调整日志" })
@RestController("WebApi-sallog")
@RequestMapping("")
public class SalLogResource {

    @Autowired
    public ISalLogService sallogService;

    @Autowired
    @Lazy
    public SalLogMapping sallogMapping;

    @PostAuthorize("hasPermission(this.sallogMapping.toDomain(returnObject.body),'ehr-SalLog-Get')")
    @ApiOperation(value = "获取薪酬调整日志", tags = {"薪酬调整日志" },  notes = "获取薪酬调整日志")
	@RequestMapping(method = RequestMethod.GET, value = "/sallogs/{sallog_id}")
    public ResponseEntity<SalLogDTO> get(@PathVariable("sallog_id") String sallog_id) {
        SalLog domain = sallogService.get(sallog_id);
        SalLogDTO dto = sallogMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.sallogService.get(#sallog_id),'ehr-SalLog-Update')")
    @ApiOperation(value = "更新薪酬调整日志", tags = {"薪酬调整日志" },  notes = "更新薪酬调整日志")
	@RequestMapping(method = RequestMethod.PUT, value = "/sallogs/{sallog_id}")
    @Transactional
    public ResponseEntity<SalLogDTO> update(@PathVariable("sallog_id") String sallog_id, @RequestBody SalLogDTO sallogdto) {
		SalLog domain  = sallogMapping.toDomain(sallogdto);
        domain .setSallogid(sallog_id);
		sallogService.update(domain );
		SalLogDTO dto = sallogMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.sallogService.getSallogByEntities(this.sallogMapping.toDomain(#sallogdtos)),'ehr-SalLog-Update')")
    @ApiOperation(value = "批量更新薪酬调整日志", tags = {"薪酬调整日志" },  notes = "批量更新薪酬调整日志")
	@RequestMapping(method = RequestMethod.PUT, value = "/sallogs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SalLogDTO> sallogdtos) {
        sallogService.updateBatch(sallogMapping.toDomain(sallogdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.sallogService.get(#sallog_id),'ehr-SalLog-Remove')")
    @ApiOperation(value = "删除薪酬调整日志", tags = {"薪酬调整日志" },  notes = "删除薪酬调整日志")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sallogs/{sallog_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("sallog_id") String sallog_id) {
         return ResponseEntity.status(HttpStatus.OK).body(sallogService.remove(sallog_id));
    }

    @PreAuthorize("hasPermission(this.sallogService.getSallogByIds(#ids),'ehr-SalLog-Remove')")
    @ApiOperation(value = "批量删除薪酬调整日志", tags = {"薪酬调整日志" },  notes = "批量删除薪酬调整日志")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sallogs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        sallogService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.sallogMapping.toDomain(#sallogdto),'ehr-SalLog-Create')")
    @ApiOperation(value = "新建薪酬调整日志", tags = {"薪酬调整日志" },  notes = "新建薪酬调整日志")
	@RequestMapping(method = RequestMethod.POST, value = "/sallogs")
    @Transactional
    public ResponseEntity<SalLogDTO> create(@RequestBody SalLogDTO sallogdto) {
        SalLog domain = sallogMapping.toDomain(sallogdto);
		sallogService.create(domain);
        SalLogDTO dto = sallogMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.sallogMapping.toDomain(#sallogdtos),'ehr-SalLog-Create')")
    @ApiOperation(value = "批量新建薪酬调整日志", tags = {"薪酬调整日志" },  notes = "批量新建薪酬调整日志")
	@RequestMapping(method = RequestMethod.POST, value = "/sallogs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SalLogDTO> sallogdtos) {
        sallogService.createBatch(sallogMapping.toDomain(sallogdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.sallogMapping.toDomain(#sallogdto),'ehr-SalLog-Save')")
    @ApiOperation(value = "保存薪酬调整日志", tags = {"薪酬调整日志" },  notes = "保存薪酬调整日志")
	@RequestMapping(method = RequestMethod.POST, value = "/sallogs/save")
    public ResponseEntity<Boolean> save(@RequestBody SalLogDTO sallogdto) {
        return ResponseEntity.status(HttpStatus.OK).body(sallogService.save(sallogMapping.toDomain(sallogdto)));
    }

    @PreAuthorize("hasPermission(this.sallogMapping.toDomain(#sallogdtos),'ehr-SalLog-Save')")
    @ApiOperation(value = "批量保存薪酬调整日志", tags = {"薪酬调整日志" },  notes = "批量保存薪酬调整日志")
	@RequestMapping(method = RequestMethod.POST, value = "/sallogs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SalLogDTO> sallogdtos) {
        sallogService.saveBatch(sallogMapping.toDomain(sallogdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取薪酬调整日志草稿", tags = {"薪酬调整日志" },  notes = "获取薪酬调整日志草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/sallogs/getdraft")
    public ResponseEntity<SalLogDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(sallogMapping.toDto(sallogService.getDraft(new SalLog())));
    }

    @ApiOperation(value = "检查薪酬调整日志", tags = {"薪酬调整日志" },  notes = "检查薪酬调整日志")
	@RequestMapping(method = RequestMethod.POST, value = "/sallogs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SalLogDTO sallogdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(sallogService.checkKey(sallogMapping.toDomain(sallogdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalLog-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"薪酬调整日志" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/sallogs/fetchdefault")
	public ResponseEntity<List<SalLogDTO>> fetchDefault(SalLogSearchContext context) {
        Page<SalLog> domains = sallogService.searchDefault(context) ;
        List<SalLogDTO> list = sallogMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalLog-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"薪酬调整日志" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/sallogs/searchdefault")
	public ResponseEntity<Page<SalLogDTO>> searchDefault(@RequestBody SalLogSearchContext context) {
        Page<SalLog> domains = sallogService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(sallogMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

