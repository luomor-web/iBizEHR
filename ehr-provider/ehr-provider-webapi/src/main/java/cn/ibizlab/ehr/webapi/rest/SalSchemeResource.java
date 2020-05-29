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
import cn.ibizlab.ehr.core.sal.domain.SalScheme;
import cn.ibizlab.ehr.core.sal.service.ISalSchemeService;
import cn.ibizlab.ehr.core.sal.filter.SalSchemeSearchContext;

@Slf4j
@Api(tags = {"工资单" })
@RestController("WebApi-salscheme")
@RequestMapping("")
public class SalSchemeResource {

    @Autowired
    public ISalSchemeService salschemeService;

    @Autowired
    @Lazy
    public SalSchemeMapping salschemeMapping;

    @PreAuthorize("hasPermission(this.salschemeMapping.toDomain(#salschemedto),'ehr-SalScheme-Create')")
    @ApiOperation(value = "新建工资单", tags = {"工资单" },  notes = "新建工资单")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemes")
    @Transactional
    public ResponseEntity<SalSchemeDTO> create(@RequestBody SalSchemeDTO salschemedto) {
        SalScheme domain = salschemeMapping.toDomain(salschemedto);
		salschemeService.create(domain);
        SalSchemeDTO dto = salschemeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salschemeMapping.toDomain(#salschemedtos),'ehr-SalScheme-Create')")
    @ApiOperation(value = "批量新建工资单", tags = {"工资单" },  notes = "批量新建工资单")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SalSchemeDTO> salschemedtos) {
        salschemeService.createBatch(salschemeMapping.toDomain(salschemedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salschemeService.get(#salscheme_id),'ehr-SalScheme-Update')")
    @ApiOperation(value = "更新工资单", tags = {"工资单" },  notes = "更新工资单")
	@RequestMapping(method = RequestMethod.PUT, value = "/salschemes/{salscheme_id}")
    @Transactional
    public ResponseEntity<SalSchemeDTO> update(@PathVariable("salscheme_id") String salscheme_id, @RequestBody SalSchemeDTO salschemedto) {
		SalScheme domain  = salschemeMapping.toDomain(salschemedto);
        domain .setSalschemeid(salscheme_id);
		salschemeService.update(domain );
		SalSchemeDTO dto = salschemeMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salschemeService.getSalschemeByEntities(this.salschemeMapping.toDomain(#salschemedtos)),'ehr-SalScheme-Update')")
    @ApiOperation(value = "批量更新工资单", tags = {"工资单" },  notes = "批量更新工资单")
	@RequestMapping(method = RequestMethod.PUT, value = "/salschemes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SalSchemeDTO> salschemedtos) {
        salschemeService.updateBatch(salschemeMapping.toDomain(salschemedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取工资单草稿", tags = {"工资单" },  notes = "获取工资单草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/salschemes/getdraft")
    public ResponseEntity<SalSchemeDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salschemeMapping.toDto(salschemeService.getDraft(new SalScheme())));
    }

    @PreAuthorize("hasPermission(this.salschemeMapping.toDomain(#salschemedto),'ehr-SalScheme-Save')")
    @ApiOperation(value = "保存工资单", tags = {"工资单" },  notes = "保存工资单")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemes/save")
    public ResponseEntity<Boolean> save(@RequestBody SalSchemeDTO salschemedto) {
        return ResponseEntity.status(HttpStatus.OK).body(salschemeService.save(salschemeMapping.toDomain(salschemedto)));
    }

    @PreAuthorize("hasPermission(this.salschemeMapping.toDomain(#salschemedtos),'ehr-SalScheme-Save')")
    @ApiOperation(value = "批量保存工资单", tags = {"工资单" },  notes = "批量保存工资单")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SalSchemeDTO> salschemedtos) {
        salschemeService.saveBatch(salschemeMapping.toDomain(salschemedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salschemeService.get(#salscheme_id),'ehr-SalScheme-Remove')")
    @ApiOperation(value = "删除工资单", tags = {"工资单" },  notes = "删除工资单")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salschemes/{salscheme_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salscheme_id") String salscheme_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salschemeService.remove(salscheme_id));
    }

    @PreAuthorize("hasPermission(this.salschemeService.getSalschemeByIds(#ids),'ehr-SalScheme-Remove')")
    @ApiOperation(value = "批量删除工资单", tags = {"工资单" },  notes = "批量删除工资单")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salschemes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salschemeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.salschemeMapping.toDomain(returnObject.body),'ehr-SalScheme-Get')")
    @ApiOperation(value = "获取工资单", tags = {"工资单" },  notes = "获取工资单")
	@RequestMapping(method = RequestMethod.GET, value = "/salschemes/{salscheme_id}")
    public ResponseEntity<SalSchemeDTO> get(@PathVariable("salscheme_id") String salscheme_id) {
        SalScheme domain = salschemeService.get(salscheme_id);
        SalSchemeDTO dto = salschemeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "检查工资单", tags = {"工资单" },  notes = "检查工资单")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SalSchemeDTO salschemedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salschemeService.checkKey(salschemeMapping.toDomain(salschemedto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalScheme-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"工资单" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salschemes/fetchdefault")
	public ResponseEntity<List<SalSchemeDTO>> fetchDefault(SalSchemeSearchContext context) {
        Page<SalScheme> domains = salschemeService.searchDefault(context) ;
        List<SalSchemeDTO> list = salschemeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalScheme-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"工资单" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salschemes/searchdefault")
	public ResponseEntity<Page<SalSchemeDTO>> searchDefault(@RequestBody SalSchemeSearchContext context) {
        Page<SalScheme> domains = salschemeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salschemeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

