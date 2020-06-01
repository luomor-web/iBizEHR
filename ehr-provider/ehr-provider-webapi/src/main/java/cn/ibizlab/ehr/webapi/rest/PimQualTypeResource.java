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
import cn.ibizlab.ehr.core.pim.domain.PimQualType;
import cn.ibizlab.ehr.core.pim.service.IPimQualTypeService;
import cn.ibizlab.ehr.core.pim.filter.PimQualTypeSearchContext;

@Slf4j
@Api(tags = {"岗位（技能）证书" })
@RestController("WebApi-pimqualtype")
@RequestMapping("")
public class PimQualTypeResource {

    @Autowired
    public IPimQualTypeService pimqualtypeService;

    @Autowired
    @Lazy
    public PimQualTypeMapping pimqualtypeMapping;

    @PreAuthorize("hasPermission(this.pimqualtypeMapping.toDomain(#pimqualtypedto),'ehr-PimQualType-Create')")
    @ApiOperation(value = "新建岗位（技能）证书", tags = {"岗位（技能）证书" },  notes = "新建岗位（技能）证书")
	@RequestMapping(method = RequestMethod.POST, value = "/pimqualtypes")
    @Transactional
    public ResponseEntity<PimQualTypeDTO> create(@RequestBody PimQualTypeDTO pimqualtypedto) {
        PimQualType domain = pimqualtypeMapping.toDomain(pimqualtypedto);
		pimqualtypeService.create(domain);
        PimQualTypeDTO dto = pimqualtypeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimqualtypeMapping.toDomain(#pimqualtypedtos),'ehr-PimQualType-Create')")
    @ApiOperation(value = "批量新建岗位（技能）证书", tags = {"岗位（技能）证书" },  notes = "批量新建岗位（技能）证书")
	@RequestMapping(method = RequestMethod.POST, value = "/pimqualtypes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimQualTypeDTO> pimqualtypedtos) {
        pimqualtypeService.createBatch(pimqualtypeMapping.toDomain(pimqualtypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimqualtypeMapping.toDomain(#pimqualtypedto),'ehr-PimQualType-Save')")
    @ApiOperation(value = "保存岗位（技能）证书", tags = {"岗位（技能）证书" },  notes = "保存岗位（技能）证书")
	@RequestMapping(method = RequestMethod.POST, value = "/pimqualtypes/save")
    public ResponseEntity<Boolean> save(@RequestBody PimQualTypeDTO pimqualtypedto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimqualtypeService.save(pimqualtypeMapping.toDomain(pimqualtypedto)));
    }

    @PreAuthorize("hasPermission(this.pimqualtypeMapping.toDomain(#pimqualtypedtos),'ehr-PimQualType-Save')")
    @ApiOperation(value = "批量保存岗位（技能）证书", tags = {"岗位（技能）证书" },  notes = "批量保存岗位（技能）证书")
	@RequestMapping(method = RequestMethod.POST, value = "/pimqualtypes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimQualTypeDTO> pimqualtypedtos) {
        pimqualtypeService.saveBatch(pimqualtypeMapping.toDomain(pimqualtypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查岗位（技能）证书", tags = {"岗位（技能）证书" },  notes = "检查岗位（技能）证书")
	@RequestMapping(method = RequestMethod.POST, value = "/pimqualtypes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimQualTypeDTO pimqualtypedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimqualtypeService.checkKey(pimqualtypeMapping.toDomain(pimqualtypedto)));
    }

    @PreAuthorize("hasPermission(this.pimqualtypeService.get(#pimqualtype_id),'ehr-PimQualType-Update')")
    @ApiOperation(value = "更新岗位（技能）证书", tags = {"岗位（技能）证书" },  notes = "更新岗位（技能）证书")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimqualtypes/{pimqualtype_id}")
    @Transactional
    public ResponseEntity<PimQualTypeDTO> update(@PathVariable("pimqualtype_id") String pimqualtype_id, @RequestBody PimQualTypeDTO pimqualtypedto) {
		PimQualType domain  = pimqualtypeMapping.toDomain(pimqualtypedto);
        domain .setPimqualtypeid(pimqualtype_id);
		pimqualtypeService.update(domain );
		PimQualTypeDTO dto = pimqualtypeMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimqualtypeService.getPimqualtypeByEntities(this.pimqualtypeMapping.toDomain(#pimqualtypedtos)),'ehr-PimQualType-Update')")
    @ApiOperation(value = "批量更新岗位（技能）证书", tags = {"岗位（技能）证书" },  notes = "批量更新岗位（技能）证书")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimqualtypes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimQualTypeDTO> pimqualtypedtos) {
        pimqualtypeService.updateBatch(pimqualtypeMapping.toDomain(pimqualtypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimqualtypeService.get(#pimqualtype_id),'ehr-PimQualType-Remove')")
    @ApiOperation(value = "删除岗位（技能）证书", tags = {"岗位（技能）证书" },  notes = "删除岗位（技能）证书")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimqualtypes/{pimqualtype_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimqualtype_id") String pimqualtype_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimqualtypeService.remove(pimqualtype_id));
    }

    @PreAuthorize("hasPermission(this.pimqualtypeService.getPimqualtypeByIds(#ids),'ehr-PimQualType-Remove')")
    @ApiOperation(value = "批量删除岗位（技能）证书", tags = {"岗位（技能）证书" },  notes = "批量删除岗位（技能）证书")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimqualtypes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimqualtypeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimqualtypeMapping.toDomain(returnObject.body),'ehr-PimQualType-Get')")
    @ApiOperation(value = "获取岗位（技能）证书", tags = {"岗位（技能）证书" },  notes = "获取岗位（技能）证书")
	@RequestMapping(method = RequestMethod.GET, value = "/pimqualtypes/{pimqualtype_id}")
    public ResponseEntity<PimQualTypeDTO> get(@PathVariable("pimqualtype_id") String pimqualtype_id) {
        PimQualType domain = pimqualtypeService.get(pimqualtype_id);
        PimQualTypeDTO dto = pimqualtypeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取岗位（技能）证书草稿", tags = {"岗位（技能）证书" },  notes = "获取岗位（技能）证书草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimqualtypes/getdraft")
    public ResponseEntity<PimQualTypeDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimqualtypeMapping.toDto(pimqualtypeService.getDraft(new PimQualType())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimQualType-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"岗位（技能）证书" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimqualtypes/fetchdefault")
	public ResponseEntity<List<PimQualTypeDTO>> fetchDefault(PimQualTypeSearchContext context) {
        Page<PimQualType> domains = pimqualtypeService.searchDefault(context) ;
        List<PimQualTypeDTO> list = pimqualtypeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimQualType-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"岗位（技能）证书" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimqualtypes/searchdefault")
	public ResponseEntity<Page<PimQualTypeDTO>> searchDefault(@RequestBody PimQualTypeSearchContext context) {
        Page<PimQualType> domains = pimqualtypeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimqualtypeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

