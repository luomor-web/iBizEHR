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
import cn.ibizlab.ehr.core.pim.domain.PimSearchFieldSet;
import cn.ibizlab.ehr.core.pim.service.IPimSearchFieldSetService;
import cn.ibizlab.ehr.core.pim.filter.PimSearchFieldSetSearchContext;

@Slf4j
@Api(tags = {"组合查询条件设置" })
@RestController("WebApi-pimsearchfieldset")
@RequestMapping("")
public class PimSearchFieldSetResource {

    @Autowired
    public IPimSearchFieldSetService pimsearchfieldsetService;

    @Autowired
    @Lazy
    public PimSearchFieldSetMapping pimsearchfieldsetMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimSearchFieldSet-InitDictionary-all')")
    @ApiOperation(value = "生成字典", tags = {"组合查询条件设置" },  notes = "生成字典")
	@RequestMapping(method = RequestMethod.POST, value = "/pimsearchfieldsets/{pimsearchfieldset_id}/initdictionary")
    @Transactional
    public ResponseEntity<PimSearchFieldSetDTO> initDictionary(@PathVariable("pimsearchfieldset_id") String pimsearchfieldset_id, @RequestBody PimSearchFieldSetDTO pimsearchfieldsetdto) {
        PimSearchFieldSet pimsearchfieldset = pimsearchfieldsetMapping.toDomain(pimsearchfieldsetdto);
        pimsearchfieldset.setPimsearchfieldsetid(pimsearchfieldset_id);
        pimsearchfieldset = pimsearchfieldsetService.initDictionary(pimsearchfieldset);
        pimsearchfieldsetdto = pimsearchfieldsetMapping.toDto(pimsearchfieldset);
        return ResponseEntity.status(HttpStatus.OK).body(pimsearchfieldsetdto);
    }

    @PreAuthorize("hasPermission(this.pimsearchfieldsetMapping.toDomain(#pimsearchfieldsetdto),'ehr-PimSearchFieldSet-Save')")
    @ApiOperation(value = "保存组合查询条件设置", tags = {"组合查询条件设置" },  notes = "保存组合查询条件设置")
	@RequestMapping(method = RequestMethod.POST, value = "/pimsearchfieldsets/save")
    public ResponseEntity<Boolean> save(@RequestBody PimSearchFieldSetDTO pimsearchfieldsetdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimsearchfieldsetService.save(pimsearchfieldsetMapping.toDomain(pimsearchfieldsetdto)));
    }

    @PreAuthorize("hasPermission(this.pimsearchfieldsetMapping.toDomain(#pimsearchfieldsetdtos),'ehr-PimSearchFieldSet-Save')")
    @ApiOperation(value = "批量保存组合查询条件设置", tags = {"组合查询条件设置" },  notes = "批量保存组合查询条件设置")
	@RequestMapping(method = RequestMethod.POST, value = "/pimsearchfieldsets/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimSearchFieldSetDTO> pimsearchfieldsetdtos) {
        pimsearchfieldsetService.saveBatch(pimsearchfieldsetMapping.toDomain(pimsearchfieldsetdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimsearchfieldsetService.get(#pimsearchfieldset_id),'ehr-PimSearchFieldSet-Update')")
    @ApiOperation(value = "更新组合查询条件设置", tags = {"组合查询条件设置" },  notes = "更新组合查询条件设置")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimsearchfieldsets/{pimsearchfieldset_id}")
    @Transactional
    public ResponseEntity<PimSearchFieldSetDTO> update(@PathVariable("pimsearchfieldset_id") String pimsearchfieldset_id, @RequestBody PimSearchFieldSetDTO pimsearchfieldsetdto) {
		PimSearchFieldSet domain  = pimsearchfieldsetMapping.toDomain(pimsearchfieldsetdto);
        domain .setPimsearchfieldsetid(pimsearchfieldset_id);
		pimsearchfieldsetService.update(domain );
		PimSearchFieldSetDTO dto = pimsearchfieldsetMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimsearchfieldsetService.getPimsearchfieldsetByEntities(this.pimsearchfieldsetMapping.toDomain(#pimsearchfieldsetdtos)),'ehr-PimSearchFieldSet-Update')")
    @ApiOperation(value = "批量更新组合查询条件设置", tags = {"组合查询条件设置" },  notes = "批量更新组合查询条件设置")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimsearchfieldsets/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimSearchFieldSetDTO> pimsearchfieldsetdtos) {
        pimsearchfieldsetService.updateBatch(pimsearchfieldsetMapping.toDomain(pimsearchfieldsetdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取组合查询条件设置草稿", tags = {"组合查询条件设置" },  notes = "获取组合查询条件设置草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimsearchfieldsets/getdraft")
    public ResponseEntity<PimSearchFieldSetDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimsearchfieldsetMapping.toDto(pimsearchfieldsetService.getDraft(new PimSearchFieldSet())));
    }

    @ApiOperation(value = "检查组合查询条件设置", tags = {"组合查询条件设置" },  notes = "检查组合查询条件设置")
	@RequestMapping(method = RequestMethod.POST, value = "/pimsearchfieldsets/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimSearchFieldSetDTO pimsearchfieldsetdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimsearchfieldsetService.checkKey(pimsearchfieldsetMapping.toDomain(pimsearchfieldsetdto)));
    }

    @PreAuthorize("hasPermission(this.pimsearchfieldsetService.get(#pimsearchfieldset_id),'ehr-PimSearchFieldSet-Remove')")
    @ApiOperation(value = "删除组合查询条件设置", tags = {"组合查询条件设置" },  notes = "删除组合查询条件设置")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimsearchfieldsets/{pimsearchfieldset_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimsearchfieldset_id") String pimsearchfieldset_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimsearchfieldsetService.remove(pimsearchfieldset_id));
    }

    @PreAuthorize("hasPermission(this.pimsearchfieldsetService.getPimsearchfieldsetByIds(#ids),'ehr-PimSearchFieldSet-Remove')")
    @ApiOperation(value = "批量删除组合查询条件设置", tags = {"组合查询条件设置" },  notes = "批量删除组合查询条件设置")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimsearchfieldsets/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimsearchfieldsetService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimsearchfieldsetMapping.toDomain(returnObject.body),'ehr-PimSearchFieldSet-Get')")
    @ApiOperation(value = "获取组合查询条件设置", tags = {"组合查询条件设置" },  notes = "获取组合查询条件设置")
	@RequestMapping(method = RequestMethod.GET, value = "/pimsearchfieldsets/{pimsearchfieldset_id}")
    public ResponseEntity<PimSearchFieldSetDTO> get(@PathVariable("pimsearchfieldset_id") String pimsearchfieldset_id) {
        PimSearchFieldSet domain = pimsearchfieldsetService.get(pimsearchfieldset_id);
        PimSearchFieldSetDTO dto = pimsearchfieldsetMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimsearchfieldsetMapping.toDomain(#pimsearchfieldsetdto),'ehr-PimSearchFieldSet-Create')")
    @ApiOperation(value = "新建组合查询条件设置", tags = {"组合查询条件设置" },  notes = "新建组合查询条件设置")
	@RequestMapping(method = RequestMethod.POST, value = "/pimsearchfieldsets")
    @Transactional
    public ResponseEntity<PimSearchFieldSetDTO> create(@RequestBody PimSearchFieldSetDTO pimsearchfieldsetdto) {
        PimSearchFieldSet domain = pimsearchfieldsetMapping.toDomain(pimsearchfieldsetdto);
		pimsearchfieldsetService.create(domain);
        PimSearchFieldSetDTO dto = pimsearchfieldsetMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimsearchfieldsetMapping.toDomain(#pimsearchfieldsetdtos),'ehr-PimSearchFieldSet-Create')")
    @ApiOperation(value = "批量新建组合查询条件设置", tags = {"组合查询条件设置" },  notes = "批量新建组合查询条件设置")
	@RequestMapping(method = RequestMethod.POST, value = "/pimsearchfieldsets/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimSearchFieldSetDTO> pimsearchfieldsetdtos) {
        pimsearchfieldsetService.createBatch(pimsearchfieldsetMapping.toDomain(pimsearchfieldsetdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimSearchFieldSet-AllDATA-all')")
	@ApiOperation(value = "获取全部数据", tags = {"组合查询条件设置" } ,notes = "获取全部数据")
    @RequestMapping(method= RequestMethod.GET , value="/pimsearchfieldsets/fetchalldata")
	public ResponseEntity<List<PimSearchFieldSetDTO>> fetchAllDATA(PimSearchFieldSetSearchContext context) {
        Page<PimSearchFieldSet> domains = pimsearchfieldsetService.searchAllDATA(context) ;
        List<PimSearchFieldSetDTO> list = pimsearchfieldsetMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimSearchFieldSet-AllDATA-all')")
	@ApiOperation(value = "查询全部数据", tags = {"组合查询条件设置" } ,notes = "查询全部数据")
    @RequestMapping(method= RequestMethod.POST , value="/pimsearchfieldsets/searchalldata")
	public ResponseEntity<Page<PimSearchFieldSetDTO>> searchAllDATA(@RequestBody PimSearchFieldSetSearchContext context) {
        Page<PimSearchFieldSet> domains = pimsearchfieldsetService.searchAllDATA(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimsearchfieldsetMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimSearchFieldSet-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"组合查询条件设置" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimsearchfieldsets/fetchdefault")
	public ResponseEntity<List<PimSearchFieldSetDTO>> fetchDefault(PimSearchFieldSetSearchContext context) {
        Page<PimSearchFieldSet> domains = pimsearchfieldsetService.searchDefault(context) ;
        List<PimSearchFieldSetDTO> list = pimsearchfieldsetMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimSearchFieldSet-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"组合查询条件设置" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimsearchfieldsets/searchdefault")
	public ResponseEntity<Page<PimSearchFieldSetDTO>> searchDefault(@RequestBody PimSearchFieldSetSearchContext context) {
        Page<PimSearchFieldSet> domains = pimsearchfieldsetService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimsearchfieldsetMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

