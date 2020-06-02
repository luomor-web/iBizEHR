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
import cn.ibizlab.ehr.core.sal.domain.SalType;
import cn.ibizlab.ehr.core.sal.service.ISalTypeService;
import cn.ibizlab.ehr.core.sal.filter.SalTypeSearchContext;

@Slf4j
@Api(tags = {"薪酬类型" })
@RestController("WebApi-saltype")
@RequestMapping("")
public class SalTypeResource {

    @Autowired
    public ISalTypeService saltypeService;

    @Autowired
    @Lazy
    public SalTypeMapping saltypeMapping;

    @ApiOperation(value = "检查薪酬类型", tags = {"薪酬类型" },  notes = "检查薪酬类型")
	@RequestMapping(method = RequestMethod.POST, value = "/saltypes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SalTypeDTO saltypedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(saltypeService.checkKey(saltypeMapping.toDomain(saltypedto)));
    }

    @PostAuthorize("hasPermission(this.saltypeMapping.toDomain(returnObject.body),'ehr-SalType-Get')")
    @ApiOperation(value = "获取薪酬类型", tags = {"薪酬类型" },  notes = "获取薪酬类型")
	@RequestMapping(method = RequestMethod.GET, value = "/saltypes/{saltype_id}")
    public ResponseEntity<SalTypeDTO> get(@PathVariable("saltype_id") String saltype_id) {
        SalType domain = saltypeService.get(saltype_id);
        SalTypeDTO dto = saltypeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取薪酬类型草稿", tags = {"薪酬类型" },  notes = "获取薪酬类型草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/saltypes/getdraft")
    public ResponseEntity<SalTypeDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(saltypeMapping.toDto(saltypeService.getDraft(new SalType())));
    }

    @PreAuthorize("hasPermission(this.saltypeService.get(#saltype_id),'ehr-SalType-Remove')")
    @ApiOperation(value = "删除薪酬类型", tags = {"薪酬类型" },  notes = "删除薪酬类型")
	@RequestMapping(method = RequestMethod.DELETE, value = "/saltypes/{saltype_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("saltype_id") String saltype_id) {
         return ResponseEntity.status(HttpStatus.OK).body(saltypeService.remove(saltype_id));
    }

    @PreAuthorize("hasPermission(this.saltypeService.getSaltypeByIds(#ids),'ehr-SalType-Remove')")
    @ApiOperation(value = "批量删除薪酬类型", tags = {"薪酬类型" },  notes = "批量删除薪酬类型")
	@RequestMapping(method = RequestMethod.DELETE, value = "/saltypes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        saltypeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.saltypeMapping.toDomain(#saltypedto),'ehr-SalType-Save')")
    @ApiOperation(value = "保存薪酬类型", tags = {"薪酬类型" },  notes = "保存薪酬类型")
	@RequestMapping(method = RequestMethod.POST, value = "/saltypes/save")
    public ResponseEntity<Boolean> save(@RequestBody SalTypeDTO saltypedto) {
        return ResponseEntity.status(HttpStatus.OK).body(saltypeService.save(saltypeMapping.toDomain(saltypedto)));
    }

    @PreAuthorize("hasPermission(this.saltypeMapping.toDomain(#saltypedtos),'ehr-SalType-Save')")
    @ApiOperation(value = "批量保存薪酬类型", tags = {"薪酬类型" },  notes = "批量保存薪酬类型")
	@RequestMapping(method = RequestMethod.POST, value = "/saltypes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SalTypeDTO> saltypedtos) {
        saltypeService.saveBatch(saltypeMapping.toDomain(saltypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.saltypeMapping.toDomain(#saltypedto),'ehr-SalType-Create')")
    @ApiOperation(value = "新建薪酬类型", tags = {"薪酬类型" },  notes = "新建薪酬类型")
	@RequestMapping(method = RequestMethod.POST, value = "/saltypes")
    @Transactional
    public ResponseEntity<SalTypeDTO> create(@RequestBody SalTypeDTO saltypedto) {
        SalType domain = saltypeMapping.toDomain(saltypedto);
		saltypeService.create(domain);
        SalTypeDTO dto = saltypeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.saltypeMapping.toDomain(#saltypedtos),'ehr-SalType-Create')")
    @ApiOperation(value = "批量新建薪酬类型", tags = {"薪酬类型" },  notes = "批量新建薪酬类型")
	@RequestMapping(method = RequestMethod.POST, value = "/saltypes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SalTypeDTO> saltypedtos) {
        saltypeService.createBatch(saltypeMapping.toDomain(saltypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.saltypeService.get(#saltype_id),'ehr-SalType-Update')")
    @ApiOperation(value = "更新薪酬类型", tags = {"薪酬类型" },  notes = "更新薪酬类型")
	@RequestMapping(method = RequestMethod.PUT, value = "/saltypes/{saltype_id}")
    @Transactional
    public ResponseEntity<SalTypeDTO> update(@PathVariable("saltype_id") String saltype_id, @RequestBody SalTypeDTO saltypedto) {
		SalType domain  = saltypeMapping.toDomain(saltypedto);
        domain .setSaltypeid(saltype_id);
		saltypeService.update(domain );
		SalTypeDTO dto = saltypeMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.saltypeService.getSaltypeByEntities(this.saltypeMapping.toDomain(#saltypedtos)),'ehr-SalType-Update')")
    @ApiOperation(value = "批量更新薪酬类型", tags = {"薪酬类型" },  notes = "批量更新薪酬类型")
	@RequestMapping(method = RequestMethod.PUT, value = "/saltypes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SalTypeDTO> saltypedtos) {
        saltypeService.updateBatch(saltypeMapping.toDomain(saltypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalType-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"薪酬类型" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/saltypes/fetchdefault")
	public ResponseEntity<List<SalTypeDTO>> fetchDefault(SalTypeSearchContext context) {
        Page<SalType> domains = saltypeService.searchDefault(context) ;
        List<SalTypeDTO> list = saltypeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalType-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"薪酬类型" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/saltypes/searchdefault")
	public ResponseEntity<Page<SalTypeDTO>> searchDefault(@RequestBody SalTypeSearchContext context) {
        Page<SalType> domains = saltypeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(saltypeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

