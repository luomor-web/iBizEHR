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
import cn.ibizlab.ehr.core.sal.domain.SALSTDGW;
import cn.ibizlab.ehr.core.sal.service.ISALSTDGWService;
import cn.ibizlab.ehr.core.sal.filter.SALSTDGWSearchContext;

@Slf4j
@Api(tags = {"高温津贴标准" })
@RestController("WebApi-salstdgw")
@RequestMapping("")
public class SALSTDGWResource {

    @Autowired
    public ISALSTDGWService salstdgwService;

    @Autowired
    @Lazy
    public SALSTDGWMapping salstdgwMapping;

    @PreAuthorize("hasPermission(this.salstdgwMapping.toDomain(#salstdgwdto),'ehr-SALSTDGW-Create')")
    @ApiOperation(value = "新建高温津贴标准", tags = {"高温津贴标准" },  notes = "新建高温津贴标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgws")
    @Transactional
    public ResponseEntity<SALSTDGWDTO> create(@RequestBody SALSTDGWDTO salstdgwdto) {
        SALSTDGW domain = salstdgwMapping.toDomain(salstdgwdto);
		salstdgwService.create(domain);
        SALSTDGWDTO dto = salstdgwMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salstdgwMapping.toDomain(#salstdgwdtos),'ehr-SALSTDGW-Create')")
    @ApiOperation(value = "批量新建高温津贴标准", tags = {"高温津贴标准" },  notes = "批量新建高温津贴标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgws/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SALSTDGWDTO> salstdgwdtos) {
        salstdgwService.createBatch(salstdgwMapping.toDomain(salstdgwdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查高温津贴标准", tags = {"高温津贴标准" },  notes = "检查高温津贴标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgws/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SALSTDGWDTO salstdgwdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salstdgwService.checkKey(salstdgwMapping.toDomain(salstdgwdto)));
    }

    @PreAuthorize("hasPermission(this.salstdgwService.get(#salstdgw_id),'ehr-SALSTDGW-Remove')")
    @ApiOperation(value = "删除高温津贴标准", tags = {"高温津贴标准" },  notes = "删除高温津贴标准")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdgws/{salstdgw_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salstdgw_id") String salstdgw_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salstdgwService.remove(salstdgw_id));
    }

    @PreAuthorize("hasPermission(this.salstdgwService.getSalstdgwByIds(#ids),'ehr-SALSTDGW-Remove')")
    @ApiOperation(value = "批量删除高温津贴标准", tags = {"高温津贴标准" },  notes = "批量删除高温津贴标准")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdgws/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salstdgwService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.salstdgwMapping.toDomain(returnObject.body),'ehr-SALSTDGW-Get')")
    @ApiOperation(value = "获取高温津贴标准", tags = {"高温津贴标准" },  notes = "获取高温津贴标准")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdgws/{salstdgw_id}")
    public ResponseEntity<SALSTDGWDTO> get(@PathVariable("salstdgw_id") String salstdgw_id) {
        SALSTDGW domain = salstdgwService.get(salstdgw_id);
        SALSTDGWDTO dto = salstdgwMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取高温津贴标准草稿", tags = {"高温津贴标准" },  notes = "获取高温津贴标准草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdgws/getdraft")
    public ResponseEntity<SALSTDGWDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salstdgwMapping.toDto(salstdgwService.getDraft(new SALSTDGW())));
    }

    @PreAuthorize("hasPermission(this.salstdgwMapping.toDomain(#salstdgwdto),'ehr-SALSTDGW-Save')")
    @ApiOperation(value = "保存高温津贴标准", tags = {"高温津贴标准" },  notes = "保存高温津贴标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgws/save")
    public ResponseEntity<Boolean> save(@RequestBody SALSTDGWDTO salstdgwdto) {
        return ResponseEntity.status(HttpStatus.OK).body(salstdgwService.save(salstdgwMapping.toDomain(salstdgwdto)));
    }

    @PreAuthorize("hasPermission(this.salstdgwMapping.toDomain(#salstdgwdtos),'ehr-SALSTDGW-Save')")
    @ApiOperation(value = "批量保存高温津贴标准", tags = {"高温津贴标准" },  notes = "批量保存高温津贴标准")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgws/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SALSTDGWDTO> salstdgwdtos) {
        salstdgwService.saveBatch(salstdgwMapping.toDomain(salstdgwdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salstdgwService.get(#salstdgw_id),'ehr-SALSTDGW-Update')")
    @ApiOperation(value = "更新高温津贴标准", tags = {"高温津贴标准" },  notes = "更新高温津贴标准")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdgws/{salstdgw_id}")
    @Transactional
    public ResponseEntity<SALSTDGWDTO> update(@PathVariable("salstdgw_id") String salstdgw_id, @RequestBody SALSTDGWDTO salstdgwdto) {
		SALSTDGW domain  = salstdgwMapping.toDomain(salstdgwdto);
        domain .setSalstdgwid(salstdgw_id);
		salstdgwService.update(domain );
		SALSTDGWDTO dto = salstdgwMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salstdgwService.getSalstdgwByEntities(this.salstdgwMapping.toDomain(#salstdgwdtos)),'ehr-SALSTDGW-Update')")
    @ApiOperation(value = "批量更新高温津贴标准", tags = {"高温津贴标准" },  notes = "批量更新高温津贴标准")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdgws/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SALSTDGWDTO> salstdgwdtos) {
        salstdgwService.updateBatch(salstdgwMapping.toDomain(salstdgwdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDGW-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"高温津贴标准" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salstdgws/fetchdefault")
	public ResponseEntity<List<SALSTDGWDTO>> fetchDefault(SALSTDGWSearchContext context) {
        Page<SALSTDGW> domains = salstdgwService.searchDefault(context) ;
        List<SALSTDGWDTO> list = salstdgwMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDGW-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"高温津贴标准" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salstdgws/searchdefault")
	public ResponseEntity<Page<SALSTDGWDTO>> searchDefault(@RequestBody SALSTDGWSearchContext context) {
        Page<SALSTDGW> domains = salstdgwService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salstdgwMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

