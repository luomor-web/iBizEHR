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
import cn.ibizlab.ehr.core.pim.domain.PimEnclosure;
import cn.ibizlab.ehr.core.pim.service.IPimEnclosureService;
import cn.ibizlab.ehr.core.pim.filter.PimEnclosureSearchContext;

@Slf4j
@Api(tags = {"附件信息" })
@RestController("WebApi-pimenclosure")
@RequestMapping("")
public class PimEnclosureResource {

    @Autowired
    public IPimEnclosureService pimenclosureService;

    @Autowired
    @Lazy
    public PimEnclosureMapping pimenclosureMapping;

    @ApiOperation(value = "获取附件信息草稿", tags = {"附件信息" },  notes = "获取附件信息草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimenclosures/getdraft")
    public ResponseEntity<PimEnclosureDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimenclosureMapping.toDto(pimenclosureService.getDraft(new PimEnclosure())));
    }

    @ApiOperation(value = "检查附件信息", tags = {"附件信息" },  notes = "检查附件信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimenclosures/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimEnclosureDTO pimenclosuredto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimenclosureService.checkKey(pimenclosureMapping.toDomain(pimenclosuredto)));
    }

    @PreAuthorize("hasPermission(this.pimenclosureMapping.toDomain(#pimenclosuredto),'ehr-PimEnclosure-Save')")
    @ApiOperation(value = "保存附件信息", tags = {"附件信息" },  notes = "保存附件信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimenclosures/save")
    public ResponseEntity<Boolean> save(@RequestBody PimEnclosureDTO pimenclosuredto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimenclosureService.save(pimenclosureMapping.toDomain(pimenclosuredto)));
    }

    @PreAuthorize("hasPermission(this.pimenclosureMapping.toDomain(#pimenclosuredtos),'ehr-PimEnclosure-Save')")
    @ApiOperation(value = "批量保存附件信息", tags = {"附件信息" },  notes = "批量保存附件信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimenclosures/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimEnclosureDTO> pimenclosuredtos) {
        pimenclosureService.saveBatch(pimenclosureMapping.toDomain(pimenclosuredtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimenclosureService.get(#pimenclosure_id),'ehr-PimEnclosure-Update')")
    @ApiOperation(value = "更新附件信息", tags = {"附件信息" },  notes = "更新附件信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimenclosures/{pimenclosure_id}")
    @Transactional
    public ResponseEntity<PimEnclosureDTO> update(@PathVariable("pimenclosure_id") String pimenclosure_id, @RequestBody PimEnclosureDTO pimenclosuredto) {
		PimEnclosure domain  = pimenclosureMapping.toDomain(pimenclosuredto);
        domain .setPimenclosureid(pimenclosure_id);
		pimenclosureService.update(domain );
		PimEnclosureDTO dto = pimenclosureMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimenclosureService.getPimenclosureByEntities(this.pimenclosureMapping.toDomain(#pimenclosuredtos)),'ehr-PimEnclosure-Update')")
    @ApiOperation(value = "批量更新附件信息", tags = {"附件信息" },  notes = "批量更新附件信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimenclosures/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimEnclosureDTO> pimenclosuredtos) {
        pimenclosureService.updateBatch(pimenclosureMapping.toDomain(pimenclosuredtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimenclosureService.get(#pimenclosure_id),'ehr-PimEnclosure-Remove')")
    @ApiOperation(value = "删除附件信息", tags = {"附件信息" },  notes = "删除附件信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimenclosures/{pimenclosure_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimenclosure_id") String pimenclosure_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimenclosureService.remove(pimenclosure_id));
    }

    @PreAuthorize("hasPermission(this.pimenclosureService.getPimenclosureByIds(#ids),'ehr-PimEnclosure-Remove')")
    @ApiOperation(value = "批量删除附件信息", tags = {"附件信息" },  notes = "批量删除附件信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimenclosures/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimenclosureService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimenclosureMapping.toDomain(#pimenclosuredto),'ehr-PimEnclosure-Create')")
    @ApiOperation(value = "新建附件信息", tags = {"附件信息" },  notes = "新建附件信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimenclosures")
    @Transactional
    public ResponseEntity<PimEnclosureDTO> create(@RequestBody PimEnclosureDTO pimenclosuredto) {
        PimEnclosure domain = pimenclosureMapping.toDomain(pimenclosuredto);
		pimenclosureService.create(domain);
        PimEnclosureDTO dto = pimenclosureMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimenclosureMapping.toDomain(#pimenclosuredtos),'ehr-PimEnclosure-Create')")
    @ApiOperation(value = "批量新建附件信息", tags = {"附件信息" },  notes = "批量新建附件信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimenclosures/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimEnclosureDTO> pimenclosuredtos) {
        pimenclosureService.createBatch(pimenclosureMapping.toDomain(pimenclosuredtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimenclosureMapping.toDomain(returnObject.body),'ehr-PimEnclosure-Get')")
    @ApiOperation(value = "获取附件信息", tags = {"附件信息" },  notes = "获取附件信息")
	@RequestMapping(method = RequestMethod.GET, value = "/pimenclosures/{pimenclosure_id}")
    public ResponseEntity<PimEnclosureDTO> get(@PathVariable("pimenclosure_id") String pimenclosure_id) {
        PimEnclosure domain = pimenclosureService.get(pimenclosure_id);
        PimEnclosureDTO dto = pimenclosureMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEnclosure-PCMPROFILE_FJ-all')")
	@ApiOperation(value = "获取应聘者附件预览", tags = {"附件信息" } ,notes = "获取应聘者附件预览")
    @RequestMapping(method= RequestMethod.GET , value="/pimenclosures/fetchpcmprofile_fj")
	public ResponseEntity<List<PimEnclosureDTO>> fetchPCMPROFILE_FJ(PimEnclosureSearchContext context) {
        Page<PimEnclosure> domains = pimenclosureService.searchPCMPROFILE_FJ(context) ;
        List<PimEnclosureDTO> list = pimenclosureMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEnclosure-PCMPROFILE_FJ-all')")
	@ApiOperation(value = "查询应聘者附件预览", tags = {"附件信息" } ,notes = "查询应聘者附件预览")
    @RequestMapping(method= RequestMethod.POST , value="/pimenclosures/searchpcmprofile_fj")
	public ResponseEntity<Page<PimEnclosureDTO>> searchPCMPROFILE_FJ(@RequestBody PimEnclosureSearchContext context) {
        Page<PimEnclosure> domains = pimenclosureService.searchPCMPROFILE_FJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimenclosureMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEnclosure-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"附件信息" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimenclosures/fetchdefault")
	public ResponseEntity<List<PimEnclosureDTO>> fetchDefault(PimEnclosureSearchContext context) {
        Page<PimEnclosure> domains = pimenclosureService.searchDefault(context) ;
        List<PimEnclosureDTO> list = pimenclosureMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEnclosure-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"附件信息" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimenclosures/searchdefault")
	public ResponseEntity<Page<PimEnclosureDTO>> searchDefault(@RequestBody PimEnclosureSearchContext context) {
        Page<PimEnclosure> domains = pimenclosureService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimenclosureMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

