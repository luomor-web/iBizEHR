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
import cn.ibizlab.ehr.core.pim.domain.PimArchivalCatalogue;
import cn.ibizlab.ehr.core.pim.service.IPimArchivalCatalogueService;
import cn.ibizlab.ehr.core.pim.filter.PimArchivalCatalogueSearchContext;

@Slf4j
@Api(tags = {"档案目录" })
@RestController("WebApi-pimarchivalcatalogue")
@RequestMapping("")
public class PimArchivalCatalogueResource {

    @Autowired
    public IPimArchivalCatalogueService pimarchivalcatalogueService;

    @Autowired
    @Lazy
    public PimArchivalCatalogueMapping pimarchivalcatalogueMapping;

    @PreAuthorize("hasPermission(this.pimarchivalcatalogueMapping.toDomain(#pimarchivalcataloguedto),'ehr-PimArchivalCatalogue-Save')")
    @ApiOperation(value = "保存档案目录", tags = {"档案目录" },  notes = "保存档案目录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchivalcatalogues/save")
    public ResponseEntity<Boolean> save(@RequestBody PimArchivalCatalogueDTO pimarchivalcataloguedto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivalcatalogueService.save(pimarchivalcatalogueMapping.toDomain(pimarchivalcataloguedto)));
    }

    @PreAuthorize("hasPermission(this.pimarchivalcatalogueMapping.toDomain(#pimarchivalcataloguedtos),'ehr-PimArchivalCatalogue-Save')")
    @ApiOperation(value = "批量保存档案目录", tags = {"档案目录" },  notes = "批量保存档案目录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchivalcatalogues/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimArchivalCatalogueDTO> pimarchivalcataloguedtos) {
        pimarchivalcatalogueService.saveBatch(pimarchivalcatalogueMapping.toDomain(pimarchivalcataloguedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查档案目录", tags = {"档案目录" },  notes = "检查档案目录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchivalcatalogues/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimArchivalCatalogueDTO pimarchivalcataloguedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimarchivalcatalogueService.checkKey(pimarchivalcatalogueMapping.toDomain(pimarchivalcataloguedto)));
    }

    @PostAuthorize("hasPermission(this.pimarchivalcatalogueMapping.toDomain(returnObject.body),'ehr-PimArchivalCatalogue-Get')")
    @ApiOperation(value = "获取档案目录", tags = {"档案目录" },  notes = "获取档案目录")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarchivalcatalogues/{pimarchivalcatalogue_id}")
    public ResponseEntity<PimArchivalCatalogueDTO> get(@PathVariable("pimarchivalcatalogue_id") String pimarchivalcatalogue_id) {
        PimArchivalCatalogue domain = pimarchivalcatalogueService.get(pimarchivalcatalogue_id);
        PimArchivalCatalogueDTO dto = pimarchivalcatalogueMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取档案目录草稿", tags = {"档案目录" },  notes = "获取档案目录草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarchivalcatalogues/getdraft")
    public ResponseEntity<PimArchivalCatalogueDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivalcatalogueMapping.toDto(pimarchivalcatalogueService.getDraft(new PimArchivalCatalogue())));
    }

    @PreAuthorize("hasPermission(this.pimarchivalcatalogueService.get(#pimarchivalcatalogue_id),'ehr-PimArchivalCatalogue-Remove')")
    @ApiOperation(value = "删除档案目录", tags = {"档案目录" },  notes = "删除档案目录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchivalcatalogues/{pimarchivalcatalogue_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimarchivalcatalogue_id") String pimarchivalcatalogue_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimarchivalcatalogueService.remove(pimarchivalcatalogue_id));
    }

    @PreAuthorize("hasPermission(this.pimarchivalcatalogueService.getPimarchivalcatalogueByIds(#ids),'ehr-PimArchivalCatalogue-Remove')")
    @ApiOperation(value = "批量删除档案目录", tags = {"档案目录" },  notes = "批量删除档案目录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchivalcatalogues/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimarchivalcatalogueService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimarchivalcatalogueService.get(#pimarchivalcatalogue_id),'ehr-PimArchivalCatalogue-Update')")
    @ApiOperation(value = "更新档案目录", tags = {"档案目录" },  notes = "更新档案目录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchivalcatalogues/{pimarchivalcatalogue_id}")
    @Transactional
    public ResponseEntity<PimArchivalCatalogueDTO> update(@PathVariable("pimarchivalcatalogue_id") String pimarchivalcatalogue_id, @RequestBody PimArchivalCatalogueDTO pimarchivalcataloguedto) {
		PimArchivalCatalogue domain  = pimarchivalcatalogueMapping.toDomain(pimarchivalcataloguedto);
        domain .setArchivalcatalogueid(pimarchivalcatalogue_id);
		pimarchivalcatalogueService.update(domain );
		PimArchivalCatalogueDTO dto = pimarchivalcatalogueMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchivalcatalogueService.getPimarchivalcatalogueByEntities(this.pimarchivalcatalogueMapping.toDomain(#pimarchivalcataloguedtos)),'ehr-PimArchivalCatalogue-Update')")
    @ApiOperation(value = "批量更新档案目录", tags = {"档案目录" },  notes = "批量更新档案目录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchivalcatalogues/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimArchivalCatalogueDTO> pimarchivalcataloguedtos) {
        pimarchivalcatalogueService.updateBatch(pimarchivalcatalogueMapping.toDomain(pimarchivalcataloguedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimarchivalcatalogueMapping.toDomain(#pimarchivalcataloguedto),'ehr-PimArchivalCatalogue-Create')")
    @ApiOperation(value = "新建档案目录", tags = {"档案目录" },  notes = "新建档案目录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchivalcatalogues")
    @Transactional
    public ResponseEntity<PimArchivalCatalogueDTO> create(@RequestBody PimArchivalCatalogueDTO pimarchivalcataloguedto) {
        PimArchivalCatalogue domain = pimarchivalcatalogueMapping.toDomain(pimarchivalcataloguedto);
		pimarchivalcatalogueService.create(domain);
        PimArchivalCatalogueDTO dto = pimarchivalcatalogueMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchivalcatalogueMapping.toDomain(#pimarchivalcataloguedtos),'ehr-PimArchivalCatalogue-Create')")
    @ApiOperation(value = "批量新建档案目录", tags = {"档案目录" },  notes = "批量新建档案目录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchivalcatalogues/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimArchivalCatalogueDTO> pimarchivalcataloguedtos) {
        pimarchivalcatalogueService.createBatch(pimarchivalcatalogueMapping.toDomain(pimarchivalcataloguedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchivalCatalogue-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"档案目录" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimarchivalcatalogues/fetchdefault")
	public ResponseEntity<List<PimArchivalCatalogueDTO>> fetchDefault(PimArchivalCatalogueSearchContext context) {
        Page<PimArchivalCatalogue> domains = pimarchivalcatalogueService.searchDefault(context) ;
        List<PimArchivalCatalogueDTO> list = pimarchivalcatalogueMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchivalCatalogue-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"档案目录" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchivalcatalogues/searchdefault")
	public ResponseEntity<Page<PimArchivalCatalogueDTO>> searchDefault(@RequestBody PimArchivalCatalogueSearchContext context) {
        Page<PimArchivalCatalogue> domains = pimarchivalcatalogueService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivalcatalogueMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

