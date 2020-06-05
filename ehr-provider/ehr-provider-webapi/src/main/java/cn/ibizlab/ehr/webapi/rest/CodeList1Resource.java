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
import cn.ibizlab.ehr.core.common.domain.CodeList1;
import cn.ibizlab.ehr.core.common.service.ICodeList1Service;
import cn.ibizlab.ehr.core.common.filter.CodeList1SearchContext;

@Slf4j
@Api(tags = {"代码表" })
@RestController("WebApi-codelist1")
@RequestMapping("")
public class CodeList1Resource {

    @Autowired
    public ICodeList1Service codelist1Service;

    @Autowired
    @Lazy
    public CodeList1Mapping codelist1Mapping;

    @PostAuthorize("hasPermission(this.codelist1Mapping.toDomain(returnObject.body),'ehr-CodeList1-Get')")
    @ApiOperation(value = "获取代码表", tags = {"代码表" },  notes = "获取代码表")
	@RequestMapping(method = RequestMethod.GET, value = "/codelist1s/{codelist1_id}")
    public ResponseEntity<CodeList1DTO> get(@PathVariable("codelist1_id") String codelist1_id) {
        CodeList1 domain = codelist1Service.get(codelist1_id);
        CodeList1DTO dto = codelist1Mapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取代码表草稿", tags = {"代码表" },  notes = "获取代码表草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/codelist1s/getdraft")
    public ResponseEntity<CodeList1DTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(codelist1Mapping.toDto(codelist1Service.getDraft(new CodeList1())));
    }

    @PreAuthorize("hasPermission(this.codelist1Service.get(#codelist1_id),'ehr-CodeList1-Update')")
    @ApiOperation(value = "更新代码表", tags = {"代码表" },  notes = "更新代码表")
	@RequestMapping(method = RequestMethod.PUT, value = "/codelist1s/{codelist1_id}")
    @Transactional
    public ResponseEntity<CodeList1DTO> update(@PathVariable("codelist1_id") String codelist1_id, @RequestBody CodeList1DTO codelist1dto) {
		CodeList1 domain  = codelist1Mapping.toDomain(codelist1dto);
        domain .setCodelistid(codelist1_id);
		codelist1Service.update(domain );
		CodeList1DTO dto = codelist1Mapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.codelist1Service.getCodelist1ByEntities(this.codelist1Mapping.toDomain(#codelist1dtos)),'ehr-CodeList1-Update')")
    @ApiOperation(value = "批量更新代码表", tags = {"代码表" },  notes = "批量更新代码表")
	@RequestMapping(method = RequestMethod.PUT, value = "/codelist1s/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<CodeList1DTO> codelist1dtos) {
        codelist1Service.updateBatch(codelist1Mapping.toDomain(codelist1dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-CodeList1-RefreshModel-all')")
    @ApiOperation(value = "刷新代码表", tags = {"代码表" },  notes = "刷新代码表")
	@RequestMapping(method = RequestMethod.POST, value = "/codelist1s/{codelist1_id}/refreshmodel")
    @Transactional
    public ResponseEntity<CodeList1DTO> refreshModel(@PathVariable("codelist1_id") String codelist1_id, @RequestBody CodeList1DTO codelist1dto) {
        CodeList1 codelist1 = codelist1Mapping.toDomain(codelist1dto);
        codelist1.setCodelistid(codelist1_id);
        codelist1 = codelist1Service.refreshModel(codelist1);
        codelist1dto = codelist1Mapping.toDto(codelist1);
        return ResponseEntity.status(HttpStatus.OK).body(codelist1dto);
    }

    @ApiOperation(value = "检查代码表", tags = {"代码表" },  notes = "检查代码表")
	@RequestMapping(method = RequestMethod.POST, value = "/codelist1s/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody CodeList1DTO codelist1dto) {
        return  ResponseEntity.status(HttpStatus.OK).body(codelist1Service.checkKey(codelist1Mapping.toDomain(codelist1dto)));
    }

    @PreAuthorize("hasPermission(this.codelist1Mapping.toDomain(#codelist1dto),'ehr-CodeList1-Create')")
    @ApiOperation(value = "新建代码表", tags = {"代码表" },  notes = "新建代码表")
	@RequestMapping(method = RequestMethod.POST, value = "/codelist1s")
    @Transactional
    public ResponseEntity<CodeList1DTO> create(@RequestBody CodeList1DTO codelist1dto) {
        CodeList1 domain = codelist1Mapping.toDomain(codelist1dto);
		codelist1Service.create(domain);
        CodeList1DTO dto = codelist1Mapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.codelist1Mapping.toDomain(#codelist1dtos),'ehr-CodeList1-Create')")
    @ApiOperation(value = "批量新建代码表", tags = {"代码表" },  notes = "批量新建代码表")
	@RequestMapping(method = RequestMethod.POST, value = "/codelist1s/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<CodeList1DTO> codelist1dtos) {
        codelist1Service.createBatch(codelist1Mapping.toDomain(codelist1dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.codelist1Service.get(#codelist1_id),'ehr-CodeList1-Remove')")
    @ApiOperation(value = "删除代码表", tags = {"代码表" },  notes = "删除代码表")
	@RequestMapping(method = RequestMethod.DELETE, value = "/codelist1s/{codelist1_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("codelist1_id") String codelist1_id) {
         return ResponseEntity.status(HttpStatus.OK).body(codelist1Service.remove(codelist1_id));
    }

    @PreAuthorize("hasPermission(this.codelist1Service.getCodelist1ByIds(#ids),'ehr-CodeList1-Remove')")
    @ApiOperation(value = "批量删除代码表", tags = {"代码表" },  notes = "批量删除代码表")
	@RequestMapping(method = RequestMethod.DELETE, value = "/codelist1s/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        codelist1Service.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.codelist1Mapping.toDomain(#codelist1dto),'ehr-CodeList1-Save')")
    @ApiOperation(value = "保存代码表", tags = {"代码表" },  notes = "保存代码表")
	@RequestMapping(method = RequestMethod.POST, value = "/codelist1s/save")
    public ResponseEntity<Boolean> save(@RequestBody CodeList1DTO codelist1dto) {
        return ResponseEntity.status(HttpStatus.OK).body(codelist1Service.save(codelist1Mapping.toDomain(codelist1dto)));
    }

    @PreAuthorize("hasPermission(this.codelist1Mapping.toDomain(#codelist1dtos),'ehr-CodeList1-Save')")
    @ApiOperation(value = "批量保存代码表", tags = {"代码表" },  notes = "批量保存代码表")
	@RequestMapping(method = RequestMethod.POST, value = "/codelist1s/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<CodeList1DTO> codelist1dtos) {
        codelist1Service.saveBatch(codelist1Mapping.toDomain(codelist1dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-CodeList1-PersonUse-all')")
	@ApiOperation(value = "获取用户使用", tags = {"代码表" } ,notes = "获取用户使用")
    @RequestMapping(method= RequestMethod.GET , value="/codelist1s/fetchpersonuse")
	public ResponseEntity<List<CodeList1DTO>> fetchPersonUse(CodeList1SearchContext context) {
        Page<CodeList1> domains = codelist1Service.searchPersonUse(context) ;
        List<CodeList1DTO> list = codelist1Mapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-CodeList1-PersonUse-all')")
	@ApiOperation(value = "查询用户使用", tags = {"代码表" } ,notes = "查询用户使用")
    @RequestMapping(method= RequestMethod.POST , value="/codelist1s/searchpersonuse")
	public ResponseEntity<Page<CodeList1DTO>> searchPersonUse(@RequestBody CodeList1SearchContext context) {
        Page<CodeList1> domains = codelist1Service.searchPersonUse(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(codelist1Mapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-CodeList1-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"代码表" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/codelist1s/fetchdefault")
	public ResponseEntity<List<CodeList1DTO>> fetchDefault(CodeList1SearchContext context) {
        Page<CodeList1> domains = codelist1Service.searchDefault(context) ;
        List<CodeList1DTO> list = codelist1Mapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-CodeList1-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"代码表" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/codelist1s/searchdefault")
	public ResponseEntity<Page<CodeList1DTO>> searchDefault(@RequestBody CodeList1SearchContext context) {
        Page<CodeList1> domains = codelist1Service.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(codelist1Mapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

