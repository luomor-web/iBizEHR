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
import cn.ibizlab.ehr.core.pim.domain.PimQualMajor;
import cn.ibizlab.ehr.core.pim.service.IPimQualMajorService;
import cn.ibizlab.ehr.core.pim.filter.PimQualMajorSearchContext;

@Slf4j
@Api(tags = {"执业资格专业" })
@RestController("WebApi-pimqualmajor")
@RequestMapping("")
public class PimQualMajorResource {

    @Autowired
    public IPimQualMajorService pimqualmajorService;

    @Autowired
    @Lazy
    public PimQualMajorMapping pimqualmajorMapping;

    @PreAuthorize("hasPermission(this.pimqualmajorMapping.toDomain(#pimqualmajordto),'ehr-PimQualMajor-Create')")
    @ApiOperation(value = "新建执业资格专业", tags = {"执业资格专业" },  notes = "新建执业资格专业")
	@RequestMapping(method = RequestMethod.POST, value = "/pimqualmajors")
    @Transactional
    public ResponseEntity<PimQualMajorDTO> create(@RequestBody PimQualMajorDTO pimqualmajordto) {
        PimQualMajor domain = pimqualmajorMapping.toDomain(pimqualmajordto);
		pimqualmajorService.create(domain);
        PimQualMajorDTO dto = pimqualmajorMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimqualmajorMapping.toDomain(#pimqualmajordtos),'ehr-PimQualMajor-Create')")
    @ApiOperation(value = "批量新建执业资格专业", tags = {"执业资格专业" },  notes = "批量新建执业资格专业")
	@RequestMapping(method = RequestMethod.POST, value = "/pimqualmajors/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimQualMajorDTO> pimqualmajordtos) {
        pimqualmajorService.createBatch(pimqualmajorMapping.toDomain(pimqualmajordtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查执业资格专业", tags = {"执业资格专业" },  notes = "检查执业资格专业")
	@RequestMapping(method = RequestMethod.POST, value = "/pimqualmajors/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimQualMajorDTO pimqualmajordto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimqualmajorService.checkKey(pimqualmajorMapping.toDomain(pimqualmajordto)));
    }

    @PreAuthorize("hasPermission(this.pimqualmajorService.get(#pimqualmajor_id),'ehr-PimQualMajor-Update')")
    @ApiOperation(value = "更新执业资格专业", tags = {"执业资格专业" },  notes = "更新执业资格专业")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimqualmajors/{pimqualmajor_id}")
    @Transactional
    public ResponseEntity<PimQualMajorDTO> update(@PathVariable("pimqualmajor_id") String pimqualmajor_id, @RequestBody PimQualMajorDTO pimqualmajordto) {
		PimQualMajor domain  = pimqualmajorMapping.toDomain(pimqualmajordto);
        domain .setPimqualmajorid(pimqualmajor_id);
		pimqualmajorService.update(domain );
		PimQualMajorDTO dto = pimqualmajorMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimqualmajorService.getPimqualmajorByEntities(this.pimqualmajorMapping.toDomain(#pimqualmajordtos)),'ehr-PimQualMajor-Update')")
    @ApiOperation(value = "批量更新执业资格专业", tags = {"执业资格专业" },  notes = "批量更新执业资格专业")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimqualmajors/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimQualMajorDTO> pimqualmajordtos) {
        pimqualmajorService.updateBatch(pimqualmajorMapping.toDomain(pimqualmajordtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimqualmajorService.get(#pimqualmajor_id),'ehr-PimQualMajor-Remove')")
    @ApiOperation(value = "删除执业资格专业", tags = {"执业资格专业" },  notes = "删除执业资格专业")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimqualmajors/{pimqualmajor_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimqualmajor_id") String pimqualmajor_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimqualmajorService.remove(pimqualmajor_id));
    }

    @PreAuthorize("hasPermission(this.pimqualmajorService.getPimqualmajorByIds(#ids),'ehr-PimQualMajor-Remove')")
    @ApiOperation(value = "批量删除执业资格专业", tags = {"执业资格专业" },  notes = "批量删除执业资格专业")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimqualmajors/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimqualmajorService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取执业资格专业草稿", tags = {"执业资格专业" },  notes = "获取执业资格专业草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimqualmajors/getdraft")
    public ResponseEntity<PimQualMajorDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimqualmajorMapping.toDto(pimqualmajorService.getDraft(new PimQualMajor())));
    }

    @PreAuthorize("hasPermission(this.pimqualmajorMapping.toDomain(#pimqualmajordto),'ehr-PimQualMajor-Save')")
    @ApiOperation(value = "保存执业资格专业", tags = {"执业资格专业" },  notes = "保存执业资格专业")
	@RequestMapping(method = RequestMethod.POST, value = "/pimqualmajors/save")
    public ResponseEntity<Boolean> save(@RequestBody PimQualMajorDTO pimqualmajordto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimqualmajorService.save(pimqualmajorMapping.toDomain(pimqualmajordto)));
    }

    @PreAuthorize("hasPermission(this.pimqualmajorMapping.toDomain(#pimqualmajordtos),'ehr-PimQualMajor-Save')")
    @ApiOperation(value = "批量保存执业资格专业", tags = {"执业资格专业" },  notes = "批量保存执业资格专业")
	@RequestMapping(method = RequestMethod.POST, value = "/pimqualmajors/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimQualMajorDTO> pimqualmajordtos) {
        pimqualmajorService.saveBatch(pimqualmajorMapping.toDomain(pimqualmajordtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimqualmajorMapping.toDomain(returnObject.body),'ehr-PimQualMajor-Get')")
    @ApiOperation(value = "获取执业资格专业", tags = {"执业资格专业" },  notes = "获取执业资格专业")
	@RequestMapping(method = RequestMethod.GET, value = "/pimqualmajors/{pimqualmajor_id}")
    public ResponseEntity<PimQualMajorDTO> get(@PathVariable("pimqualmajor_id") String pimqualmajor_id) {
        PimQualMajor domain = pimqualmajorService.get(pimqualmajor_id);
        PimQualMajorDTO dto = pimqualmajorMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimQualMajor-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"执业资格专业" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimqualmajors/fetchdefault")
	public ResponseEntity<List<PimQualMajorDTO>> fetchDefault(PimQualMajorSearchContext context) {
        Page<PimQualMajor> domains = pimqualmajorService.searchDefault(context) ;
        List<PimQualMajorDTO> list = pimqualmajorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimQualMajor-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"执业资格专业" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimqualmajors/searchdefault")
	public ResponseEntity<Page<PimQualMajorDTO>> searchDefault(@RequestBody PimQualMajorSearchContext context) {
        Page<PimQualMajor> domains = pimqualmajorService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimqualmajorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimQualMajor-XZZGZY-all')")
	@ApiOperation(value = "获取选择资格类别下对应的资格专业", tags = {"执业资格专业" } ,notes = "获取选择资格类别下对应的资格专业")
    @RequestMapping(method= RequestMethod.GET , value="/pimqualmajors/fetchxzzgzy")
	public ResponseEntity<List<PimQualMajorDTO>> fetchXZZGZY(PimQualMajorSearchContext context) {
        Page<PimQualMajor> domains = pimqualmajorService.searchXZZGZY(context) ;
        List<PimQualMajorDTO> list = pimqualmajorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimQualMajor-XZZGZY-all')")
	@ApiOperation(value = "查询选择资格类别下对应的资格专业", tags = {"执业资格专业" } ,notes = "查询选择资格类别下对应的资格专业")
    @RequestMapping(method= RequestMethod.POST , value="/pimqualmajors/searchxzzgzy")
	public ResponseEntity<Page<PimQualMajorDTO>> searchXZZGZY(@RequestBody PimQualMajorSearchContext context) {
        Page<PimQualMajor> domains = pimqualmajorService.searchXZZGZY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimqualmajorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

