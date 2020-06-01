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
import cn.ibizlab.ehr.core.pim.domain.PimTitleCatalogue;
import cn.ibizlab.ehr.core.pim.service.IPimTitleCatalogueService;
import cn.ibizlab.ehr.core.pim.filter.PimTitleCatalogueSearchContext;

@Slf4j
@Api(tags = {"职称目录" })
@RestController("WebApi-pimtitlecatalogue")
@RequestMapping("")
public class PimTitleCatalogueResource {

    @Autowired
    public IPimTitleCatalogueService pimtitlecatalogueService;

    @Autowired
    @Lazy
    public PimTitleCatalogueMapping pimtitlecatalogueMapping;

    @PreAuthorize("hasPermission(this.pimtitlecatalogueMapping.toDomain(#pimtitlecataloguedto),'ehr-PimTitleCatalogue-Save')")
    @ApiOperation(value = "保存职称目录", tags = {"职称目录" },  notes = "保存职称目录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimtitlecatalogues/save")
    public ResponseEntity<Boolean> save(@RequestBody PimTitleCatalogueDTO pimtitlecataloguedto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimtitlecatalogueService.save(pimtitlecatalogueMapping.toDomain(pimtitlecataloguedto)));
    }

    @PreAuthorize("hasPermission(this.pimtitlecatalogueMapping.toDomain(#pimtitlecataloguedtos),'ehr-PimTitleCatalogue-Save')")
    @ApiOperation(value = "批量保存职称目录", tags = {"职称目录" },  notes = "批量保存职称目录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimtitlecatalogues/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimTitleCatalogueDTO> pimtitlecataloguedtos) {
        pimtitlecatalogueService.saveBatch(pimtitlecatalogueMapping.toDomain(pimtitlecataloguedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimtitlecatalogueService.get(#pimtitlecatalogue_id),'ehr-PimTitleCatalogue-Update')")
    @ApiOperation(value = "更新职称目录", tags = {"职称目录" },  notes = "更新职称目录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimtitlecatalogues/{pimtitlecatalogue_id}")
    @Transactional
    public ResponseEntity<PimTitleCatalogueDTO> update(@PathVariable("pimtitlecatalogue_id") String pimtitlecatalogue_id, @RequestBody PimTitleCatalogueDTO pimtitlecataloguedto) {
		PimTitleCatalogue domain  = pimtitlecatalogueMapping.toDomain(pimtitlecataloguedto);
        domain .setPimtitlecatalogueid(pimtitlecatalogue_id);
		pimtitlecatalogueService.update(domain );
		PimTitleCatalogueDTO dto = pimtitlecatalogueMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimtitlecatalogueService.getPimtitlecatalogueByEntities(this.pimtitlecatalogueMapping.toDomain(#pimtitlecataloguedtos)),'ehr-PimTitleCatalogue-Update')")
    @ApiOperation(value = "批量更新职称目录", tags = {"职称目录" },  notes = "批量更新职称目录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimtitlecatalogues/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimTitleCatalogueDTO> pimtitlecataloguedtos) {
        pimtitlecatalogueService.updateBatch(pimtitlecatalogueMapping.toDomain(pimtitlecataloguedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取职称目录草稿", tags = {"职称目录" },  notes = "获取职称目录草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimtitlecatalogues/getdraft")
    public ResponseEntity<PimTitleCatalogueDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimtitlecatalogueMapping.toDto(pimtitlecatalogueService.getDraft(new PimTitleCatalogue())));
    }

    @PreAuthorize("hasPermission(this.pimtitlecatalogueMapping.toDomain(#pimtitlecataloguedto),'ehr-PimTitleCatalogue-Create')")
    @ApiOperation(value = "新建职称目录", tags = {"职称目录" },  notes = "新建职称目录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimtitlecatalogues")
    @Transactional
    public ResponseEntity<PimTitleCatalogueDTO> create(@RequestBody PimTitleCatalogueDTO pimtitlecataloguedto) {
        PimTitleCatalogue domain = pimtitlecatalogueMapping.toDomain(pimtitlecataloguedto);
		pimtitlecatalogueService.create(domain);
        PimTitleCatalogueDTO dto = pimtitlecatalogueMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimtitlecatalogueMapping.toDomain(#pimtitlecataloguedtos),'ehr-PimTitleCatalogue-Create')")
    @ApiOperation(value = "批量新建职称目录", tags = {"职称目录" },  notes = "批量新建职称目录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimtitlecatalogues/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimTitleCatalogueDTO> pimtitlecataloguedtos) {
        pimtitlecatalogueService.createBatch(pimtitlecatalogueMapping.toDomain(pimtitlecataloguedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查职称目录", tags = {"职称目录" },  notes = "检查职称目录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimtitlecatalogues/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimTitleCatalogueDTO pimtitlecataloguedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimtitlecatalogueService.checkKey(pimtitlecatalogueMapping.toDomain(pimtitlecataloguedto)));
    }

    @PreAuthorize("hasPermission(this.pimtitlecatalogueService.get(#pimtitlecatalogue_id),'ehr-PimTitleCatalogue-Remove')")
    @ApiOperation(value = "删除职称目录", tags = {"职称目录" },  notes = "删除职称目录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimtitlecatalogues/{pimtitlecatalogue_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimtitlecatalogue_id") String pimtitlecatalogue_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimtitlecatalogueService.remove(pimtitlecatalogue_id));
    }

    @PreAuthorize("hasPermission(this.pimtitlecatalogueService.getPimtitlecatalogueByIds(#ids),'ehr-PimTitleCatalogue-Remove')")
    @ApiOperation(value = "批量删除职称目录", tags = {"职称目录" },  notes = "批量删除职称目录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimtitlecatalogues/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimtitlecatalogueService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimtitlecatalogueMapping.toDomain(returnObject.body),'ehr-PimTitleCatalogue-Get')")
    @ApiOperation(value = "获取职称目录", tags = {"职称目录" },  notes = "获取职称目录")
	@RequestMapping(method = RequestMethod.GET, value = "/pimtitlecatalogues/{pimtitlecatalogue_id}")
    public ResponseEntity<PimTitleCatalogueDTO> get(@PathVariable("pimtitlecatalogue_id") String pimtitlecatalogue_id) {
        PimTitleCatalogue domain = pimtitlecatalogueService.get(pimtitlecatalogue_id);
        PimTitleCatalogueDTO dto = pimtitlecatalogueMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimTitleCatalogue-IsRootDQ-all')")
	@ApiOperation(value = "获取查询没有上级职称的", tags = {"职称目录" } ,notes = "获取查询没有上级职称的")
    @RequestMapping(method= RequestMethod.GET , value="/pimtitlecatalogues/fetchisrootdq")
	public ResponseEntity<List<PimTitleCatalogueDTO>> fetchIsRootDQ(PimTitleCatalogueSearchContext context) {
        Page<PimTitleCatalogue> domains = pimtitlecatalogueService.searchIsRootDQ(context) ;
        List<PimTitleCatalogueDTO> list = pimtitlecatalogueMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimTitleCatalogue-IsRootDQ-all')")
	@ApiOperation(value = "查询查询没有上级职称的", tags = {"职称目录" } ,notes = "查询查询没有上级职称的")
    @RequestMapping(method= RequestMethod.POST , value="/pimtitlecatalogues/searchisrootdq")
	public ResponseEntity<Page<PimTitleCatalogueDTO>> searchIsRootDQ(@RequestBody PimTitleCatalogueSearchContext context) {
        Page<PimTitleCatalogue> domains = pimtitlecatalogueService.searchIsRootDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimtitlecatalogueMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimTitleCatalogue-NotRootDQ-all')")
	@ApiOperation(value = "获取不查询没有上级职称的", tags = {"职称目录" } ,notes = "获取不查询没有上级职称的")
    @RequestMapping(method= RequestMethod.GET , value="/pimtitlecatalogues/fetchnotrootdq")
	public ResponseEntity<List<PimTitleCatalogueDTO>> fetchNotRootDQ(PimTitleCatalogueSearchContext context) {
        Page<PimTitleCatalogue> domains = pimtitlecatalogueService.searchNotRootDQ(context) ;
        List<PimTitleCatalogueDTO> list = pimtitlecatalogueMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimTitleCatalogue-NotRootDQ-all')")
	@ApiOperation(value = "查询不查询没有上级职称的", tags = {"职称目录" } ,notes = "查询不查询没有上级职称的")
    @RequestMapping(method= RequestMethod.POST , value="/pimtitlecatalogues/searchnotrootdq")
	public ResponseEntity<Page<PimTitleCatalogueDTO>> searchNotRootDQ(@RequestBody PimTitleCatalogueSearchContext context) {
        Page<PimTitleCatalogue> domains = pimtitlecatalogueService.searchNotRootDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimtitlecatalogueMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimTitleCatalogue-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"职称目录" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimtitlecatalogues/fetchdefault")
	public ResponseEntity<List<PimTitleCatalogueDTO>> fetchDefault(PimTitleCatalogueSearchContext context) {
        Page<PimTitleCatalogue> domains = pimtitlecatalogueService.searchDefault(context) ;
        List<PimTitleCatalogueDTO> list = pimtitlecatalogueMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimTitleCatalogue-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"职称目录" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimtitlecatalogues/searchdefault")
	public ResponseEntity<Page<PimTitleCatalogueDTO>> searchDefault(@RequestBody PimTitleCatalogueSearchContext context) {
        Page<PimTitleCatalogue> domains = pimtitlecatalogueService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimtitlecatalogueMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

