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
import cn.ibizlab.ehr.core.soc.domain.SocType;
import cn.ibizlab.ehr.core.soc.service.ISocTypeService;
import cn.ibizlab.ehr.core.soc.filter.SocTypeSearchContext;

@Slf4j
@Api(tags = {"保险类型" })
@RestController("WebApi-soctype")
@RequestMapping("")
public class SocTypeResource {

    @Autowired
    public ISocTypeService soctypeService;

    @Autowired
    @Lazy
    public SocTypeMapping soctypeMapping;

    @PreAuthorize("hasPermission(this.soctypeMapping.toDomain(#soctypedto),'ehr-SocType-Create')")
    @ApiOperation(value = "新建保险类型", tags = {"保险类型" },  notes = "新建保险类型")
	@RequestMapping(method = RequestMethod.POST, value = "/soctypes")
    @Transactional
    public ResponseEntity<SocTypeDTO> create(@RequestBody SocTypeDTO soctypedto) {
        SocType domain = soctypeMapping.toDomain(soctypedto);
		soctypeService.create(domain);
        SocTypeDTO dto = soctypeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.soctypeMapping.toDomain(#soctypedtos),'ehr-SocType-Create')")
    @ApiOperation(value = "批量新建保险类型", tags = {"保险类型" },  notes = "批量新建保险类型")
	@RequestMapping(method = RequestMethod.POST, value = "/soctypes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SocTypeDTO> soctypedtos) {
        soctypeService.createBatch(soctypeMapping.toDomain(soctypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.soctypeService.get(#soctype_id),'ehr-SocType-Update')")
    @ApiOperation(value = "更新保险类型", tags = {"保险类型" },  notes = "更新保险类型")
	@RequestMapping(method = RequestMethod.PUT, value = "/soctypes/{soctype_id}")
    @Transactional
    public ResponseEntity<SocTypeDTO> update(@PathVariable("soctype_id") String soctype_id, @RequestBody SocTypeDTO soctypedto) {
		SocType domain  = soctypeMapping.toDomain(soctypedto);
        domain .setSoctypeid(soctype_id);
		soctypeService.update(domain );
		SocTypeDTO dto = soctypeMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.soctypeService.getSoctypeByEntities(this.soctypeMapping.toDomain(#soctypedtos)),'ehr-SocType-Update')")
    @ApiOperation(value = "批量更新保险类型", tags = {"保险类型" },  notes = "批量更新保险类型")
	@RequestMapping(method = RequestMethod.PUT, value = "/soctypes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SocTypeDTO> soctypedtos) {
        soctypeService.updateBatch(soctypeMapping.toDomain(soctypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.soctypeService.get(#soctype_id),'ehr-SocType-Remove')")
    @ApiOperation(value = "删除保险类型", tags = {"保险类型" },  notes = "删除保险类型")
	@RequestMapping(method = RequestMethod.DELETE, value = "/soctypes/{soctype_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("soctype_id") String soctype_id) {
         return ResponseEntity.status(HttpStatus.OK).body(soctypeService.remove(soctype_id));
    }

    @PreAuthorize("hasPermission(this.soctypeService.getSoctypeByIds(#ids),'ehr-SocType-Remove')")
    @ApiOperation(value = "批量删除保险类型", tags = {"保险类型" },  notes = "批量删除保险类型")
	@RequestMapping(method = RequestMethod.DELETE, value = "/soctypes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        soctypeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.soctypeMapping.toDomain(#soctypedto),'ehr-SocType-Save')")
    @ApiOperation(value = "保存保险类型", tags = {"保险类型" },  notes = "保存保险类型")
	@RequestMapping(method = RequestMethod.POST, value = "/soctypes/save")
    public ResponseEntity<Boolean> save(@RequestBody SocTypeDTO soctypedto) {
        return ResponseEntity.status(HttpStatus.OK).body(soctypeService.save(soctypeMapping.toDomain(soctypedto)));
    }

    @PreAuthorize("hasPermission(this.soctypeMapping.toDomain(#soctypedtos),'ehr-SocType-Save')")
    @ApiOperation(value = "批量保存保险类型", tags = {"保险类型" },  notes = "批量保存保险类型")
	@RequestMapping(method = RequestMethod.POST, value = "/soctypes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SocTypeDTO> soctypedtos) {
        soctypeService.saveBatch(soctypeMapping.toDomain(soctypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取保险类型草稿", tags = {"保险类型" },  notes = "获取保险类型草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/soctypes/getdraft")
    public ResponseEntity<SocTypeDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(soctypeMapping.toDto(soctypeService.getDraft(new SocType())));
    }

    @PostAuthorize("hasPermission(this.soctypeMapping.toDomain(returnObject.body),'ehr-SocType-Get')")
    @ApiOperation(value = "获取保险类型", tags = {"保险类型" },  notes = "获取保险类型")
	@RequestMapping(method = RequestMethod.GET, value = "/soctypes/{soctype_id}")
    public ResponseEntity<SocTypeDTO> get(@PathVariable("soctype_id") String soctype_id) {
        SocType domain = soctypeService.get(soctype_id);
        SocTypeDTO dto = soctypeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "检查保险类型", tags = {"保险类型" },  notes = "检查保险类型")
	@RequestMapping(method = RequestMethod.POST, value = "/soctypes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SocTypeDTO soctypedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(soctypeService.checkKey(soctypeMapping.toDomain(soctypedto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocType-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"保险类型" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/soctypes/fetchdefault")
	public ResponseEntity<List<SocTypeDTO>> fetchDefault(SocTypeSearchContext context) {
        Page<SocType> domains = soctypeService.searchDefault(context) ;
        List<SocTypeDTO> list = soctypeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocType-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"保险类型" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/soctypes/searchdefault")
	public ResponseEntity<Page<SocTypeDTO>> searchDefault(@RequestBody SocTypeSearchContext context) {
        Page<SocType> domains = soctypeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(soctypeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

