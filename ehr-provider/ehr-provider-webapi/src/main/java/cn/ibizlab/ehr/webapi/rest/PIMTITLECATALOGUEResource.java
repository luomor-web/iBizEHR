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
import cn.ibizlab.ehr.core.pim.domain.PIMTITLECATALOGUE;
import cn.ibizlab.ehr.core.pim.service.IPIMTITLECATALOGUEService;
import cn.ibizlab.ehr.core.pim.filter.PIMTITLECATALOGUESearchContext;

@Slf4j
@Api(tags = {"职称目录" })
@RestController("WebApi-pimtitlecatalogue")
@RequestMapping("")
public class PIMTITLECATALOGUEResource {

    @Autowired
    public IPIMTITLECATALOGUEService pimtitlecatalogueService;

    @Autowired
    @Lazy
    public PIMTITLECATALOGUEMapping pimtitlecatalogueMapping;

    @PreAuthorize("hasPermission(this.pimtitlecatalogueMapping.toDomain(#pimtitlecataloguedto),'ehr-PIMTITLECATALOGUE-Save')")
    @ApiOperation(value = "保存职称目录", tags = {"职称目录" },  notes = "保存职称目录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimtitlecatalogues/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMTITLECATALOGUEDTO pimtitlecataloguedto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimtitlecatalogueService.save(pimtitlecatalogueMapping.toDomain(pimtitlecataloguedto)));
    }

    @PreAuthorize("hasPermission(this.pimtitlecatalogueMapping.toDomain(#pimtitlecataloguedtos),'ehr-PIMTITLECATALOGUE-Save')")
    @ApiOperation(value = "批量保存职称目录", tags = {"职称目录" },  notes = "批量保存职称目录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimtitlecatalogues/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMTITLECATALOGUEDTO> pimtitlecataloguedtos) {
        pimtitlecatalogueService.saveBatch(pimtitlecatalogueMapping.toDomain(pimtitlecataloguedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimtitlecatalogueService.get(#pimtitlecatalogue_id),'ehr-PIMTITLECATALOGUE-Update')")
    @ApiOperation(value = "更新职称目录", tags = {"职称目录" },  notes = "更新职称目录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimtitlecatalogues/{pimtitlecatalogue_id}")
    @Transactional
    public ResponseEntity<PIMTITLECATALOGUEDTO> update(@PathVariable("pimtitlecatalogue_id") String pimtitlecatalogue_id, @RequestBody PIMTITLECATALOGUEDTO pimtitlecataloguedto) {
		PIMTITLECATALOGUE domain  = pimtitlecatalogueMapping.toDomain(pimtitlecataloguedto);
        domain .setPimtitlecatalogueid(pimtitlecatalogue_id);
		pimtitlecatalogueService.update(domain );
		PIMTITLECATALOGUEDTO dto = pimtitlecatalogueMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimtitlecatalogueService.getPimtitlecatalogueByEntities(this.pimtitlecatalogueMapping.toDomain(#pimtitlecataloguedtos)),'ehr-PIMTITLECATALOGUE-Update')")
    @ApiOperation(value = "批量更新职称目录", tags = {"职称目录" },  notes = "批量更新职称目录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimtitlecatalogues/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMTITLECATALOGUEDTO> pimtitlecataloguedtos) {
        pimtitlecatalogueService.updateBatch(pimtitlecatalogueMapping.toDomain(pimtitlecataloguedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取职称目录草稿", tags = {"职称目录" },  notes = "获取职称目录草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimtitlecatalogues/getdraft")
    public ResponseEntity<PIMTITLECATALOGUEDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimtitlecatalogueMapping.toDto(pimtitlecatalogueService.getDraft(new PIMTITLECATALOGUE())));
    }

    @PreAuthorize("hasPermission(this.pimtitlecatalogueMapping.toDomain(#pimtitlecataloguedto),'ehr-PIMTITLECATALOGUE-Create')")
    @ApiOperation(value = "新建职称目录", tags = {"职称目录" },  notes = "新建职称目录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimtitlecatalogues")
    @Transactional
    public ResponseEntity<PIMTITLECATALOGUEDTO> create(@RequestBody PIMTITLECATALOGUEDTO pimtitlecataloguedto) {
        PIMTITLECATALOGUE domain = pimtitlecatalogueMapping.toDomain(pimtitlecataloguedto);
		pimtitlecatalogueService.create(domain);
        PIMTITLECATALOGUEDTO dto = pimtitlecatalogueMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimtitlecatalogueMapping.toDomain(#pimtitlecataloguedtos),'ehr-PIMTITLECATALOGUE-Create')")
    @ApiOperation(value = "批量新建职称目录", tags = {"职称目录" },  notes = "批量新建职称目录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimtitlecatalogues/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMTITLECATALOGUEDTO> pimtitlecataloguedtos) {
        pimtitlecatalogueService.createBatch(pimtitlecatalogueMapping.toDomain(pimtitlecataloguedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查职称目录", tags = {"职称目录" },  notes = "检查职称目录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimtitlecatalogues/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMTITLECATALOGUEDTO pimtitlecataloguedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimtitlecatalogueService.checkKey(pimtitlecatalogueMapping.toDomain(pimtitlecataloguedto)));
    }

    @PreAuthorize("hasPermission(this.pimtitlecatalogueService.get(#pimtitlecatalogue_id),'ehr-PIMTITLECATALOGUE-Remove')")
    @ApiOperation(value = "删除职称目录", tags = {"职称目录" },  notes = "删除职称目录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimtitlecatalogues/{pimtitlecatalogue_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimtitlecatalogue_id") String pimtitlecatalogue_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimtitlecatalogueService.remove(pimtitlecatalogue_id));
    }

    @PreAuthorize("hasPermission(this.pimtitlecatalogueService.getPimtitlecatalogueByIds(#ids),'ehr-PIMTITLECATALOGUE-Remove')")
    @ApiOperation(value = "批量删除职称目录", tags = {"职称目录" },  notes = "批量删除职称目录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimtitlecatalogues/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimtitlecatalogueService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimtitlecatalogueMapping.toDomain(returnObject.body),'ehr-PIMTITLECATALOGUE-Get')")
    @ApiOperation(value = "获取职称目录", tags = {"职称目录" },  notes = "获取职称目录")
	@RequestMapping(method = RequestMethod.GET, value = "/pimtitlecatalogues/{pimtitlecatalogue_id}")
    public ResponseEntity<PIMTITLECATALOGUEDTO> get(@PathVariable("pimtitlecatalogue_id") String pimtitlecatalogue_id) {
        PIMTITLECATALOGUE domain = pimtitlecatalogueService.get(pimtitlecatalogue_id);
        PIMTITLECATALOGUEDTO dto = pimtitlecatalogueMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMTITLECATALOGUE-IsRootDQ-all')")
	@ApiOperation(value = "获取查询没有上级职称的", tags = {"职称目录" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/pimtitlecatalogues/fetchisrootdq")
	public ResponseEntity<List<PIMTITLECATALOGUEDTO>> fetchIsRootDQ(PIMTITLECATALOGUESearchContext context) {
        Page<PIMTITLECATALOGUE> domains = pimtitlecatalogueService.searchIsRootDQ(context) ;
        List<PIMTITLECATALOGUEDTO> list = pimtitlecatalogueMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMTITLECATALOGUE-IsRootDQ-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"职称目录" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/pimtitlecatalogues/searchisrootdq")
	public ResponseEntity<Page<PIMTITLECATALOGUEDTO>> searchIsRootDQ(@RequestBody PIMTITLECATALOGUESearchContext context) {
        Page<PIMTITLECATALOGUE> domains = pimtitlecatalogueService.searchIsRootDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimtitlecatalogueMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMTITLECATALOGUE-NotRootDQ-all')")
	@ApiOperation(value = "获取不查询没有上级职称的", tags = {"职称目录" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/pimtitlecatalogues/fetchnotrootdq")
	public ResponseEntity<List<PIMTITLECATALOGUEDTO>> fetchNotRootDQ(PIMTITLECATALOGUESearchContext context) {
        Page<PIMTITLECATALOGUE> domains = pimtitlecatalogueService.searchNotRootDQ(context) ;
        List<PIMTITLECATALOGUEDTO> list = pimtitlecatalogueMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMTITLECATALOGUE-NotRootDQ-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"职称目录" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/pimtitlecatalogues/searchnotrootdq")
	public ResponseEntity<Page<PIMTITLECATALOGUEDTO>> searchNotRootDQ(@RequestBody PIMTITLECATALOGUESearchContext context) {
        Page<PIMTITLECATALOGUE> domains = pimtitlecatalogueService.searchNotRootDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimtitlecatalogueMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMTITLECATALOGUE-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"职称目录" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/pimtitlecatalogues/fetchdefault")
	public ResponseEntity<List<PIMTITLECATALOGUEDTO>> fetchDefault(PIMTITLECATALOGUESearchContext context) {
        Page<PIMTITLECATALOGUE> domains = pimtitlecatalogueService.searchDefault(context) ;
        List<PIMTITLECATALOGUEDTO> list = pimtitlecatalogueMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMTITLECATALOGUE-Default-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"职称目录" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/pimtitlecatalogues/searchdefault")
	public ResponseEntity<Page<PIMTITLECATALOGUEDTO>> searchDefault(@RequestBody PIMTITLECATALOGUESearchContext context) {
        Page<PIMTITLECATALOGUE> domains = pimtitlecatalogueService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimtitlecatalogueMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

