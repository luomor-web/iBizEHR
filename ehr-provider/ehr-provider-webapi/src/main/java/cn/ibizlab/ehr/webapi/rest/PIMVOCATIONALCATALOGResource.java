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
import cn.ibizlab.ehr.core.pim.domain.PIMVOCATIONALCATALOG;
import cn.ibizlab.ehr.core.pim.service.IPIMVOCATIONALCATALOGService;
import cn.ibizlab.ehr.core.pim.filter.PIMVOCATIONALCATALOGSearchContext;

@Slf4j
@Api(tags = {"执（职）业资格管理" })
@RestController("WebApi-pimvocationalcatalog")
@RequestMapping("")
public class PIMVOCATIONALCATALOGResource {

    @Autowired
    public IPIMVOCATIONALCATALOGService pimvocationalcatalogService;

    @Autowired
    @Lazy
    public PIMVOCATIONALCATALOGMapping pimvocationalcatalogMapping;

    @PreAuthorize("hasPermission(this.pimvocationalcatalogMapping.toDomain(#pimvocationalcatalogdto),'ehr-PIMVOCATIONALCATALOG-Save')")
    @ApiOperation(value = "保存执（职）业资格管理", tags = {"执（职）业资格管理" },  notes = "保存执（职）业资格管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pimvocationalcatalogs/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMVOCATIONALCATALOGDTO pimvocationalcatalogdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimvocationalcatalogService.save(pimvocationalcatalogMapping.toDomain(pimvocationalcatalogdto)));
    }

    @PreAuthorize("hasPermission(this.pimvocationalcatalogMapping.toDomain(#pimvocationalcatalogdtos),'ehr-PIMVOCATIONALCATALOG-Save')")
    @ApiOperation(value = "批量保存执（职）业资格管理", tags = {"执（职）业资格管理" },  notes = "批量保存执（职）业资格管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pimvocationalcatalogs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMVOCATIONALCATALOGDTO> pimvocationalcatalogdtos) {
        pimvocationalcatalogService.saveBatch(pimvocationalcatalogMapping.toDomain(pimvocationalcatalogdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取执（职）业资格管理草稿", tags = {"执（职）业资格管理" },  notes = "获取执（职）业资格管理草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimvocationalcatalogs/getdraft")
    public ResponseEntity<PIMVOCATIONALCATALOGDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimvocationalcatalogMapping.toDto(pimvocationalcatalogService.getDraft(new PIMVOCATIONALCATALOG())));
    }

    @PostAuthorize("hasPermission(this.pimvocationalcatalogMapping.toDomain(returnObject.body),'ehr-PIMVOCATIONALCATALOG-Get')")
    @ApiOperation(value = "获取执（职）业资格管理", tags = {"执（职）业资格管理" },  notes = "获取执（职）业资格管理")
	@RequestMapping(method = RequestMethod.GET, value = "/pimvocationalcatalogs/{pimvocationalcatalog_id}")
    public ResponseEntity<PIMVOCATIONALCATALOGDTO> get(@PathVariable("pimvocationalcatalog_id") String pimvocationalcatalog_id) {
        PIMVOCATIONALCATALOG domain = pimvocationalcatalogService.get(pimvocationalcatalog_id);
        PIMVOCATIONALCATALOGDTO dto = pimvocationalcatalogMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "检查执（职）业资格管理", tags = {"执（职）业资格管理" },  notes = "检查执（职）业资格管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pimvocationalcatalogs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMVOCATIONALCATALOGDTO pimvocationalcatalogdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimvocationalcatalogService.checkKey(pimvocationalcatalogMapping.toDomain(pimvocationalcatalogdto)));
    }

    @PreAuthorize("hasPermission(this.pimvocationalcatalogService.get(#pimvocationalcatalog_id),'ehr-PIMVOCATIONALCATALOG-Update')")
    @ApiOperation(value = "更新执（职）业资格管理", tags = {"执（职）业资格管理" },  notes = "更新执（职）业资格管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimvocationalcatalogs/{pimvocationalcatalog_id}")
    @Transactional
    public ResponseEntity<PIMVOCATIONALCATALOGDTO> update(@PathVariable("pimvocationalcatalog_id") String pimvocationalcatalog_id, @RequestBody PIMVOCATIONALCATALOGDTO pimvocationalcatalogdto) {
		PIMVOCATIONALCATALOG domain  = pimvocationalcatalogMapping.toDomain(pimvocationalcatalogdto);
        domain .setPimvocationalcatalogid(pimvocationalcatalog_id);
		pimvocationalcatalogService.update(domain );
		PIMVOCATIONALCATALOGDTO dto = pimvocationalcatalogMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimvocationalcatalogService.getPimvocationalcatalogByEntities(this.pimvocationalcatalogMapping.toDomain(#pimvocationalcatalogdtos)),'ehr-PIMVOCATIONALCATALOG-Update')")
    @ApiOperation(value = "批量更新执（职）业资格管理", tags = {"执（职）业资格管理" },  notes = "批量更新执（职）业资格管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimvocationalcatalogs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMVOCATIONALCATALOGDTO> pimvocationalcatalogdtos) {
        pimvocationalcatalogService.updateBatch(pimvocationalcatalogMapping.toDomain(pimvocationalcatalogdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimvocationalcatalogMapping.toDomain(#pimvocationalcatalogdto),'ehr-PIMVOCATIONALCATALOG-Create')")
    @ApiOperation(value = "新建执（职）业资格管理", tags = {"执（职）业资格管理" },  notes = "新建执（职）业资格管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pimvocationalcatalogs")
    @Transactional
    public ResponseEntity<PIMVOCATIONALCATALOGDTO> create(@RequestBody PIMVOCATIONALCATALOGDTO pimvocationalcatalogdto) {
        PIMVOCATIONALCATALOG domain = pimvocationalcatalogMapping.toDomain(pimvocationalcatalogdto);
		pimvocationalcatalogService.create(domain);
        PIMVOCATIONALCATALOGDTO dto = pimvocationalcatalogMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimvocationalcatalogMapping.toDomain(#pimvocationalcatalogdtos),'ehr-PIMVOCATIONALCATALOG-Create')")
    @ApiOperation(value = "批量新建执（职）业资格管理", tags = {"执（职）业资格管理" },  notes = "批量新建执（职）业资格管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pimvocationalcatalogs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMVOCATIONALCATALOGDTO> pimvocationalcatalogdtos) {
        pimvocationalcatalogService.createBatch(pimvocationalcatalogMapping.toDomain(pimvocationalcatalogdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimvocationalcatalogService.get(#pimvocationalcatalog_id),'ehr-PIMVOCATIONALCATALOG-Remove')")
    @ApiOperation(value = "删除执（职）业资格管理", tags = {"执（职）业资格管理" },  notes = "删除执（职）业资格管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimvocationalcatalogs/{pimvocationalcatalog_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimvocationalcatalog_id") String pimvocationalcatalog_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimvocationalcatalogService.remove(pimvocationalcatalog_id));
    }

    @PreAuthorize("hasPermission(this.pimvocationalcatalogService.getPimvocationalcatalogByIds(#ids),'ehr-PIMVOCATIONALCATALOG-Remove')")
    @ApiOperation(value = "批量删除执（职）业资格管理", tags = {"执（职）业资格管理" },  notes = "批量删除执（职）业资格管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimvocationalcatalogs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimvocationalcatalogService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMVOCATIONALCATALOG-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"执（职）业资格管理" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimvocationalcatalogs/fetchdefault")
	public ResponseEntity<List<PIMVOCATIONALCATALOGDTO>> fetchDefault(PIMVOCATIONALCATALOGSearchContext context) {
        Page<PIMVOCATIONALCATALOG> domains = pimvocationalcatalogService.searchDefault(context) ;
        List<PIMVOCATIONALCATALOGDTO> list = pimvocationalcatalogMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMVOCATIONALCATALOG-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"执（职）业资格管理" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimvocationalcatalogs/searchdefault")
	public ResponseEntity<Page<PIMVOCATIONALCATALOGDTO>> searchDefault(@RequestBody PIMVOCATIONALCATALOGSearchContext context) {
        Page<PIMVOCATIONALCATALOG> domains = pimvocationalcatalogService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimvocationalcatalogMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

