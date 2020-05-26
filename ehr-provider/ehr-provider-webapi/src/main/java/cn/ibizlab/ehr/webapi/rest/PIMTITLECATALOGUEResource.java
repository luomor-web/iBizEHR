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
@Api(tags = {"PIMTITLECATALOGUE" })
@RestController("WebApi-pimtitlecatalogue")
@RequestMapping("")
public class PIMTITLECATALOGUEResource {

    @Autowired
    private IPIMTITLECATALOGUEService pimtitlecatalogueService;

    @Autowired
    @Lazy
    public PIMTITLECATALOGUEMapping pimtitlecatalogueMapping;

    public PIMTITLECATALOGUEDTO permissionDTO=new PIMTITLECATALOGUEDTO();

    @PreAuthorize("hasPermission('','Save',{'Sql',this.pimtitlecatalogueMapping,#pimtitlecataloguedto})")
    @ApiOperation(value = "Save", tags = {"PIMTITLECATALOGUE" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimtitlecatalogues/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMTITLECATALOGUEDTO pimtitlecataloguedto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimtitlecatalogueService.save(pimtitlecatalogueMapping.toDomain(pimtitlecataloguedto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.pimtitlecatalogueMapping,#pimtitlecataloguedtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PIMTITLECATALOGUE" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimtitlecatalogues/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMTITLECATALOGUEDTO> pimtitlecataloguedtos) {
        pimtitlecatalogueService.saveBatch(pimtitlecatalogueMapping.toDomain(pimtitlecataloguedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pimtitlecatalogue_id,'Update',{'Sql',this.pimtitlecatalogueMapping,#pimtitlecataloguedto})")
    @ApiOperation(value = "Update", tags = {"PIMTITLECATALOGUE" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimtitlecatalogues/{pimtitlecatalogue_id}")
    @Transactional
    public ResponseEntity<PIMTITLECATALOGUEDTO> update(@PathVariable("pimtitlecatalogue_id") String pimtitlecatalogue_id, @RequestBody PIMTITLECATALOGUEDTO pimtitlecataloguedto) {
		PIMTITLECATALOGUE domain  = pimtitlecatalogueMapping.toDomain(pimtitlecataloguedto);
        domain .setPimtitlecatalogueid(pimtitlecatalogue_id);
		pimtitlecatalogueService.update(domain );
		PIMTITLECATALOGUEDTO dto = pimtitlecatalogueMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.pimtitlecatalogueMapping,#pimtitlecataloguedtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMTITLECATALOGUE" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimtitlecatalogues/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMTITLECATALOGUEDTO> pimtitlecataloguedtos) {
        pimtitlecatalogueService.updateBatch(pimtitlecatalogueMapping.toDomain(pimtitlecataloguedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMTITLECATALOGUE-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PIMTITLECATALOGUE" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimtitlecatalogues/getdraft")
    public ResponseEntity<PIMTITLECATALOGUEDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimtitlecatalogueMapping.toDto(pimtitlecatalogueService.getDraft(new PIMTITLECATALOGUE())));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pimtitlecatalogueMapping,#pimtitlecataloguedto})")
    @ApiOperation(value = "Create", tags = {"PIMTITLECATALOGUE" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimtitlecatalogues")
    @Transactional
    public ResponseEntity<PIMTITLECATALOGUEDTO> create(@RequestBody PIMTITLECATALOGUEDTO pimtitlecataloguedto) {
        PIMTITLECATALOGUE domain = pimtitlecatalogueMapping.toDomain(pimtitlecataloguedto);
		pimtitlecatalogueService.create(domain);
        PIMTITLECATALOGUEDTO dto = pimtitlecatalogueMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.pimtitlecatalogueMapping,#pimtitlecataloguedtos})")
    @ApiOperation(value = "createBatch", tags = {"PIMTITLECATALOGUE" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimtitlecatalogues/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMTITLECATALOGUEDTO> pimtitlecataloguedtos) {
        pimtitlecatalogueService.createBatch(pimtitlecatalogueMapping.toDomain(pimtitlecataloguedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMTITLECATALOGUE-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PIMTITLECATALOGUE" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimtitlecatalogues/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMTITLECATALOGUEDTO pimtitlecataloguedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimtitlecatalogueService.checkKey(pimtitlecatalogueMapping.toDomain(pimtitlecataloguedto)));
    }

    @PreAuthorize("hasPermission(#pimtitlecatalogue_id,'Remove',{'Sql',this.pimtitlecatalogueMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PIMTITLECATALOGUE" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimtitlecatalogues/{pimtitlecatalogue_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimtitlecatalogue_id") String pimtitlecatalogue_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimtitlecatalogueService.remove(pimtitlecatalogue_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.pimtitlecatalogueMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PIMTITLECATALOGUE" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimtitlecatalogues/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimtitlecatalogueService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pimtitlecatalogue_id,'Get',{'Sql',this.pimtitlecatalogueMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PIMTITLECATALOGUE" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimtitlecatalogues/{pimtitlecatalogue_id}")
    public ResponseEntity<PIMTITLECATALOGUEDTO> get(@PathVariable("pimtitlecatalogue_id") String pimtitlecatalogue_id) {
        PIMTITLECATALOGUE domain = pimtitlecatalogueService.get(pimtitlecatalogue_id);
        PIMTITLECATALOGUEDTO dto = pimtitlecatalogueMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMTITLECATALOGUE-IsRootDQ-all')")
	@ApiOperation(value = "fetch查询没有上级职称的", tags = {"PIMTITLECATALOGUE" } ,notes = "fetch查询没有上级职称的")
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
	@ApiOperation(value = "search查询没有上级职称的", tags = {"PIMTITLECATALOGUE" } ,notes = "search查询没有上级职称的")
    @RequestMapping(method= RequestMethod.POST , value="/pimtitlecatalogues/searchisrootdq")
	public ResponseEntity<Page<PIMTITLECATALOGUEDTO>> searchIsRootDQ(@RequestBody PIMTITLECATALOGUESearchContext context) {
        Page<PIMTITLECATALOGUE> domains = pimtitlecatalogueService.searchIsRootDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimtitlecatalogueMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMTITLECATALOGUE-NotRootDQ-all')")
	@ApiOperation(value = "fetch不查询没有上级职称的", tags = {"PIMTITLECATALOGUE" } ,notes = "fetch不查询没有上级职称的")
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
	@ApiOperation(value = "search不查询没有上级职称的", tags = {"PIMTITLECATALOGUE" } ,notes = "search不查询没有上级职称的")
    @RequestMapping(method= RequestMethod.POST , value="/pimtitlecatalogues/searchnotrootdq")
	public ResponseEntity<Page<PIMTITLECATALOGUEDTO>> searchNotRootDQ(@RequestBody PIMTITLECATALOGUESearchContext context) {
        Page<PIMTITLECATALOGUE> domains = pimtitlecatalogueService.searchNotRootDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimtitlecatalogueMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMTITLECATALOGUE-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMTITLECATALOGUE" } ,notes = "fetchDEFAULT")
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
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMTITLECATALOGUE" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimtitlecatalogues/searchdefault")
	public ResponseEntity<Page<PIMTITLECATALOGUEDTO>> searchDefault(@RequestBody PIMTITLECATALOGUESearchContext context) {
        Page<PIMTITLECATALOGUE> domains = pimtitlecatalogueService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimtitlecatalogueMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
