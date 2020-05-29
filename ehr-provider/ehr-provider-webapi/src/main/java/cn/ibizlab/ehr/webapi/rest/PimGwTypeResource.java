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
import cn.ibizlab.ehr.core.pim.domain.PimGwType;
import cn.ibizlab.ehr.core.pim.service.IPimGwTypeService;
import cn.ibizlab.ehr.core.pim.filter.PimGwTypeSearchContext;

@Slf4j
@Api(tags = {"岗位类型对照表" })
@RestController("WebApi-pimgwtype")
@RequestMapping("")
public class PimGwTypeResource {

    @Autowired
    public IPimGwTypeService pimgwtypeService;

    @Autowired
    @Lazy
    public PimGwTypeMapping pimgwtypeMapping;

    @PreAuthorize("hasPermission(this.pimgwtypeMapping.toDomain(#pimgwtypedto),'ehr-PimGwType-Save')")
    @ApiOperation(value = "保存岗位类型对照表", tags = {"岗位类型对照表" },  notes = "保存岗位类型对照表")
	@RequestMapping(method = RequestMethod.POST, value = "/pimgwtypes/save")
    public ResponseEntity<Boolean> save(@RequestBody PimGwTypeDTO pimgwtypedto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimgwtypeService.save(pimgwtypeMapping.toDomain(pimgwtypedto)));
    }

    @PreAuthorize("hasPermission(this.pimgwtypeMapping.toDomain(#pimgwtypedtos),'ehr-PimGwType-Save')")
    @ApiOperation(value = "批量保存岗位类型对照表", tags = {"岗位类型对照表" },  notes = "批量保存岗位类型对照表")
	@RequestMapping(method = RequestMethod.POST, value = "/pimgwtypes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimGwTypeDTO> pimgwtypedtos) {
        pimgwtypeService.saveBatch(pimgwtypeMapping.toDomain(pimgwtypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取岗位类型对照表草稿", tags = {"岗位类型对照表" },  notes = "获取岗位类型对照表草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimgwtypes/getdraft")
    public ResponseEntity<PimGwTypeDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimgwtypeMapping.toDto(pimgwtypeService.getDraft(new PimGwType())));
    }

    @PostAuthorize("hasPermission(this.pimgwtypeMapping.toDomain(returnObject.body),'ehr-PimGwType-Get')")
    @ApiOperation(value = "获取岗位类型对照表", tags = {"岗位类型对照表" },  notes = "获取岗位类型对照表")
	@RequestMapping(method = RequestMethod.GET, value = "/pimgwtypes/{pimgwtype_id}")
    public ResponseEntity<PimGwTypeDTO> get(@PathVariable("pimgwtype_id") String pimgwtype_id) {
        PimGwType domain = pimgwtypeService.get(pimgwtype_id);
        PimGwTypeDTO dto = pimgwtypeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimgwtypeService.get(#pimgwtype_id),'ehr-PimGwType-Remove')")
    @ApiOperation(value = "删除岗位类型对照表", tags = {"岗位类型对照表" },  notes = "删除岗位类型对照表")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimgwtypes/{pimgwtype_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimgwtype_id") String pimgwtype_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimgwtypeService.remove(pimgwtype_id));
    }

    @PreAuthorize("hasPermission(this.pimgwtypeService.getPimgwtypeByIds(#ids),'ehr-PimGwType-Remove')")
    @ApiOperation(value = "批量删除岗位类型对照表", tags = {"岗位类型对照表" },  notes = "批量删除岗位类型对照表")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimgwtypes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimgwtypeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查岗位类型对照表", tags = {"岗位类型对照表" },  notes = "检查岗位类型对照表")
	@RequestMapping(method = RequestMethod.POST, value = "/pimgwtypes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimGwTypeDTO pimgwtypedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimgwtypeService.checkKey(pimgwtypeMapping.toDomain(pimgwtypedto)));
    }

    @PreAuthorize("hasPermission(this.pimgwtypeService.get(#pimgwtype_id),'ehr-PimGwType-Update')")
    @ApiOperation(value = "更新岗位类型对照表", tags = {"岗位类型对照表" },  notes = "更新岗位类型对照表")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimgwtypes/{pimgwtype_id}")
    @Transactional
    public ResponseEntity<PimGwTypeDTO> update(@PathVariable("pimgwtype_id") String pimgwtype_id, @RequestBody PimGwTypeDTO pimgwtypedto) {
		PimGwType domain  = pimgwtypeMapping.toDomain(pimgwtypedto);
        domain .setPimgwtypeid(pimgwtype_id);
		pimgwtypeService.update(domain );
		PimGwTypeDTO dto = pimgwtypeMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimgwtypeService.getPimgwtypeByEntities(this.pimgwtypeMapping.toDomain(#pimgwtypedtos)),'ehr-PimGwType-Update')")
    @ApiOperation(value = "批量更新岗位类型对照表", tags = {"岗位类型对照表" },  notes = "批量更新岗位类型对照表")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimgwtypes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimGwTypeDTO> pimgwtypedtos) {
        pimgwtypeService.updateBatch(pimgwtypeMapping.toDomain(pimgwtypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimgwtypeMapping.toDomain(#pimgwtypedto),'ehr-PimGwType-Create')")
    @ApiOperation(value = "新建岗位类型对照表", tags = {"岗位类型对照表" },  notes = "新建岗位类型对照表")
	@RequestMapping(method = RequestMethod.POST, value = "/pimgwtypes")
    @Transactional
    public ResponseEntity<PimGwTypeDTO> create(@RequestBody PimGwTypeDTO pimgwtypedto) {
        PimGwType domain = pimgwtypeMapping.toDomain(pimgwtypedto);
		pimgwtypeService.create(domain);
        PimGwTypeDTO dto = pimgwtypeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimgwtypeMapping.toDomain(#pimgwtypedtos),'ehr-PimGwType-Create')")
    @ApiOperation(value = "批量新建岗位类型对照表", tags = {"岗位类型对照表" },  notes = "批量新建岗位类型对照表")
	@RequestMapping(method = RequestMethod.POST, value = "/pimgwtypes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimGwTypeDTO> pimgwtypedtos) {
        pimgwtypeService.createBatch(pimgwtypeMapping.toDomain(pimgwtypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimGwType-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"岗位类型对照表" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimgwtypes/fetchdefault")
	public ResponseEntity<List<PimGwTypeDTO>> fetchDefault(PimGwTypeSearchContext context) {
        Page<PimGwType> domains = pimgwtypeService.searchDefault(context) ;
        List<PimGwTypeDTO> list = pimgwtypeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimGwType-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"岗位类型对照表" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimgwtypes/searchdefault")
	public ResponseEntity<Page<PimGwTypeDTO>> searchDefault(@RequestBody PimGwTypeSearchContext context) {
        Page<PimGwType> domains = pimgwtypeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimgwtypeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

