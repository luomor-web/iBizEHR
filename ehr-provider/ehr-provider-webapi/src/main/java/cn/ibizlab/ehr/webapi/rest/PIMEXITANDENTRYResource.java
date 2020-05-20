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
import cn.ibizlab.ehr.core.pim.domain.PIMEXITANDENTRY;
import cn.ibizlab.ehr.core.pim.service.IPIMEXITANDENTRYService;
import cn.ibizlab.ehr.core.pim.filter.PIMEXITANDENTRYSearchContext;




@Slf4j
@Api(tags = {"PIMEXITANDENTRY" })
@RestController("WebApi-pimexitandentry")
@RequestMapping("")
public class PIMEXITANDENTRYResource {

    @Autowired
    private IPIMEXITANDENTRYService pimexitandentryService;

    @Autowired
    @Lazy
    private PIMEXITANDENTRYMapping pimexitandentryMapping;




    @PreAuthorize("hasPermission(#pimexitandentry_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PIMEXITANDENTRY" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimexitandentries/{pimexitandentry_id}")
    @Transactional
    public ResponseEntity<PIMEXITANDENTRYDTO> update(@PathVariable("pimexitandentry_id") String pimexitandentry_id, @RequestBody PIMEXITANDENTRYDTO pimexitandentrydto) {
		PIMEXITANDENTRY domain = pimexitandentryMapping.toDomain(pimexitandentrydto);
        domain.setPimexitandentryid(pimexitandentry_id);
		pimexitandentryService.update(domain);
		PIMEXITANDENTRYDTO dto = pimexitandentryMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pimexitandentry_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMEXITANDENTRY" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimexitandentries/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMEXITANDENTRYDTO> pimexitandentrydtos) {
        pimexitandentryService.updateBatch(pimexitandentryMapping.toDomain(pimexitandentrydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"PIMEXITANDENTRY" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexitandentries/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMEXITANDENTRYDTO pimexitandentrydto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimexitandentryService.save(pimexitandentryMapping.toDomain(pimexitandentrydto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PIMEXITANDENTRY" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexitandentries/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMEXITANDENTRYDTO> pimexitandentrydtos) {
        pimexitandentryService.saveBatch(pimexitandentryMapping.toDomain(pimexitandentrydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "撤销", tags = {"PIMEXITANDENTRY" },  notes = "撤销")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexitandentries/{pimexitandentry_id}/cx")
    @Transactional
    public ResponseEntity<PIMEXITANDENTRYDTO> cX(@PathVariable("pimexitandentry_id") String pimexitandentry_id, @RequestBody PIMEXITANDENTRYDTO pimexitandentrydto) {
        PIMEXITANDENTRY pimexitandentry = pimexitandentryMapping.toDomain(pimexitandentrydto);
        pimexitandentry = pimexitandentryService.cX(pimexitandentry);
        pimexitandentrydto = pimexitandentryMapping.toDto(pimexitandentry);
        return ResponseEntity.status(HttpStatus.OK).body(pimexitandentrydto);
    }




    @PreAuthorize("hasPermission(#pimexitandentry_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PIMEXITANDENTRY" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimexitandentries/{pimexitandentry_id}")
    public ResponseEntity<PIMEXITANDENTRYDTO> get(@PathVariable("pimexitandentry_id") String pimexitandentry_id) {
        PIMEXITANDENTRY domain = pimexitandentryService.get(pimexitandentry_id);
        PIMEXITANDENTRYDTO dto = pimexitandentryMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "GetDraft", tags = {"PIMEXITANDENTRY" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimexitandentries/getdraft")
    public ResponseEntity<PIMEXITANDENTRYDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimexitandentryMapping.toDto(pimexitandentryService.getDraft(new PIMEXITANDENTRY())));
    }




    @ApiOperation(value = "移动端启动流程", tags = {"PIMEXITANDENTRY" },  notes = "移动端启动流程")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexitandentries/{pimexitandentry_id}/mobstart")
    @Transactional
    public ResponseEntity<PIMEXITANDENTRYDTO> mobStart(@PathVariable("pimexitandentry_id") String pimexitandentry_id, @RequestBody PIMEXITANDENTRYDTO pimexitandentrydto) {
        PIMEXITANDENTRY pimexitandentry = pimexitandentryMapping.toDomain(pimexitandentrydto);
        pimexitandentry = pimexitandentryService.mobStart(pimexitandentry);
        pimexitandentrydto = pimexitandentryMapping.toDto(pimexitandentry);
        return ResponseEntity.status(HttpStatus.OK).body(pimexitandentrydto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PIMEXITANDENTRY" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexitandentries")
    @Transactional
    public ResponseEntity<PIMEXITANDENTRYDTO> create(@RequestBody PIMEXITANDENTRYDTO pimexitandentrydto) {
        PIMEXITANDENTRY domain = pimexitandentryMapping.toDomain(pimexitandentrydto);
		pimexitandentryService.create(domain);
        PIMEXITANDENTRYDTO dto = pimexitandentryMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PIMEXITANDENTRY" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexitandentries/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMEXITANDENTRYDTO> pimexitandentrydtos) {
        pimexitandentryService.createBatch(pimexitandentryMapping.toDomain(pimexitandentrydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pimexitandentry_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"PIMEXITANDENTRY" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimexitandentries/{pimexitandentry_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimexitandentry_id") String pimexitandentry_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimexitandentryService.remove(pimexitandentry_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PIMEXITANDENTRY" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimexitandentries/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimexitandentryService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "催办", tags = {"PIMEXITANDENTRY" },  notes = "催办")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexitandentries/{pimexitandentry_id}/cb")
    @Transactional
    public ResponseEntity<PIMEXITANDENTRYDTO> cB(@PathVariable("pimexitandentry_id") String pimexitandentry_id, @RequestBody PIMEXITANDENTRYDTO pimexitandentrydto) {
        PIMEXITANDENTRY pimexitandentry = pimexitandentryMapping.toDomain(pimexitandentrydto);
        pimexitandentry = pimexitandentryService.cB(pimexitandentry);
        pimexitandentrydto = pimexitandentryMapping.toDto(pimexitandentry);
        return ResponseEntity.status(HttpStatus.OK).body(pimexitandentrydto);
    }




    @ApiOperation(value = "CheckKey", tags = {"PIMEXITANDENTRY" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexitandentries/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMEXITANDENTRYDTO pimexitandentrydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimexitandentryService.checkKey(pimexitandentryMapping.toDomain(pimexitandentrydto)));
    }




    @ApiOperation(value = "启动流程", tags = {"PIMEXITANDENTRY" },  notes = "启动流程")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexitandentries/{pimexitandentry_id}/start")
    @Transactional
    public ResponseEntity<PIMEXITANDENTRYDTO> start(@PathVariable("pimexitandentry_id") String pimexitandentry_id, @RequestBody PIMEXITANDENTRYDTO pimexitandentrydto) {
        PIMEXITANDENTRY pimexitandentry = pimexitandentryMapping.toDomain(pimexitandentrydto);
        pimexitandentry = pimexitandentryService.start(pimexitandentry);
        pimexitandentrydto = pimexitandentryMapping.toDto(pimexitandentry);
        return ResponseEntity.status(HttpStatus.OK).body(pimexitandentrydto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEXITANDENTRY-YGCGJ-all')")
	@ApiOperation(value = "fetch因公出国境", tags = {"PIMEXITANDENTRY" } ,notes = "fetch因公出国境")
    @RequestMapping(method= RequestMethod.GET , value="/pimexitandentries/fetchygcgj")
	public ResponseEntity<List<PIMEXITANDENTRYDTO>> fetchYGCGJ(PIMEXITANDENTRYSearchContext context) {
        Page<PIMEXITANDENTRY> domains = pimexitandentryService.searchYGCGJ(context) ;
        List<PIMEXITANDENTRYDTO> list = pimexitandentryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEXITANDENTRY-YGCGJ-all')")
	@ApiOperation(value = "search因公出国境", tags = {"PIMEXITANDENTRY" } ,notes = "search因公出国境")
    @RequestMapping(method= RequestMethod.POST , value="/pimexitandentries/searchygcgj")
	public ResponseEntity<Page<PIMEXITANDENTRYDTO>> searchYGCGJ(@RequestBody PIMEXITANDENTRYSearchContext context) {
        Page<PIMEXITANDENTRY> domains = pimexitandentryService.searchYGCGJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimexitandentryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEXITANDENTRY-YGZZ-all')")
	@ApiOperation(value = "fetch员工自助", tags = {"PIMEXITANDENTRY" } ,notes = "fetch员工自助")
    @RequestMapping(method= RequestMethod.GET , value="/pimexitandentries/fetchygzz")
	public ResponseEntity<List<PIMEXITANDENTRYDTO>> fetchYGZZ(PIMEXITANDENTRYSearchContext context) {
        Page<PIMEXITANDENTRY> domains = pimexitandentryService.searchYGZZ(context) ;
        List<PIMEXITANDENTRYDTO> list = pimexitandentryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEXITANDENTRY-YGZZ-all')")
	@ApiOperation(value = "search员工自助", tags = {"PIMEXITANDENTRY" } ,notes = "search员工自助")
    @RequestMapping(method= RequestMethod.POST , value="/pimexitandentries/searchygzz")
	public ResponseEntity<Page<PIMEXITANDENTRYDTO>> searchYGZZ(@RequestBody PIMEXITANDENTRYSearchContext context) {
        Page<PIMEXITANDENTRY> domains = pimexitandentryService.searchYGZZ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimexitandentryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEXITANDENTRY-MOBJLSS-all')")
	@ApiOperation(value = "fetch记录所属（移动端）", tags = {"PIMEXITANDENTRY" } ,notes = "fetch记录所属（移动端）")
    @RequestMapping(method= RequestMethod.GET , value="/pimexitandentries/fetchmobjlss")
	public ResponseEntity<List<PIMEXITANDENTRYDTO>> fetchMOBJLSS(PIMEXITANDENTRYSearchContext context) {
        Page<PIMEXITANDENTRY> domains = pimexitandentryService.searchMOBJLSS(context) ;
        List<PIMEXITANDENTRYDTO> list = pimexitandentryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEXITANDENTRY-MOBJLSS-all')")
	@ApiOperation(value = "search记录所属（移动端）", tags = {"PIMEXITANDENTRY" } ,notes = "search记录所属（移动端）")
    @RequestMapping(method= RequestMethod.POST , value="/pimexitandentries/searchmobjlss")
	public ResponseEntity<Page<PIMEXITANDENTRYDTO>> searchMOBJLSS(@RequestBody PIMEXITANDENTRYSearchContext context) {
        Page<PIMEXITANDENTRY> domains = pimexitandentryService.searchMOBJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimexitandentryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEXITANDENTRY-YSCGJ-all')")
	@ApiOperation(value = "fetch因私出国境", tags = {"PIMEXITANDENTRY" } ,notes = "fetch因私出国境")
    @RequestMapping(method= RequestMethod.GET , value="/pimexitandentries/fetchyscgj")
	public ResponseEntity<List<PIMEXITANDENTRYDTO>> fetchYSCGJ(PIMEXITANDENTRYSearchContext context) {
        Page<PIMEXITANDENTRY> domains = pimexitandentryService.searchYSCGJ(context) ;
        List<PIMEXITANDENTRYDTO> list = pimexitandentryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEXITANDENTRY-YSCGJ-all')")
	@ApiOperation(value = "search因私出国境", tags = {"PIMEXITANDENTRY" } ,notes = "search因私出国境")
    @RequestMapping(method= RequestMethod.POST , value="/pimexitandentries/searchyscgj")
	public ResponseEntity<Page<PIMEXITANDENTRYDTO>> searchYSCGJ(@RequestBody PIMEXITANDENTRYSearchContext context) {
        Page<PIMEXITANDENTRY> domains = pimexitandentryService.searchYSCGJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimexitandentryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEXITANDENTRY-FormType-all')")
	@ApiOperation(value = "fetchFormType", tags = {"PIMEXITANDENTRY" } ,notes = "fetchFormType")
    @RequestMapping(method= RequestMethod.GET , value="/pimexitandentries/fetchformtype")
	public ResponseEntity<List<PIMEXITANDENTRYDTO>> fetchFormType(PIMEXITANDENTRYSearchContext context) {
        Page<PIMEXITANDENTRY> domains = pimexitandentryService.searchFormType(context) ;
        List<PIMEXITANDENTRYDTO> list = pimexitandentryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEXITANDENTRY-FormType-all')")
	@ApiOperation(value = "searchFormType", tags = {"PIMEXITANDENTRY" } ,notes = "searchFormType")
    @RequestMapping(method= RequestMethod.POST , value="/pimexitandentries/searchformtype")
	public ResponseEntity<Page<PIMEXITANDENTRYDTO>> searchFormType(@RequestBody PIMEXITANDENTRYSearchContext context) {
        Page<PIMEXITANDENTRY> domains = pimexitandentryService.searchFormType(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimexitandentryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEXITANDENTRY-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMEXITANDENTRY" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimexitandentries/fetchdefault")
	public ResponseEntity<List<PIMEXITANDENTRYDTO>> fetchDefault(PIMEXITANDENTRYSearchContext context) {
        Page<PIMEXITANDENTRY> domains = pimexitandentryService.searchDefault(context) ;
        List<PIMEXITANDENTRYDTO> list = pimexitandentryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEXITANDENTRY-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMEXITANDENTRY" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimexitandentries/searchdefault")
	public ResponseEntity<Page<PIMEXITANDENTRYDTO>> searchDefault(@RequestBody PIMEXITANDENTRYSearchContext context) {
        Page<PIMEXITANDENTRY> domains = pimexitandentryService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimexitandentryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}



    @ApiOperation(value = "UpdateByPIMPERSON", tags = {"PIMEXITANDENTRY" },  notes = "UpdateByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimexitandentries/{pimexitandentry_id}")
    @Transactional
    public ResponseEntity<PIMEXITANDENTRYDTO> updateByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimexitandentry_id") String pimexitandentry_id, @RequestBody PIMEXITANDENTRYDTO pimexitandentrydto) {
        PIMEXITANDENTRY domain = pimexitandentryMapping.toDomain(pimexitandentrydto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimexitandentryid(pimexitandentry_id);
		pimexitandentryService.update(domain);
        PIMEXITANDENTRYDTO dto = pimexitandentryMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatchByPIMPERSON", tags = {"PIMEXITANDENTRY" },  notes = "UpdateBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimexitandentries/batch")
    public ResponseEntity<Boolean> updateBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMEXITANDENTRYDTO> pimexitandentrydtos) {
        List<PIMEXITANDENTRY> domainlist=pimexitandentryMapping.toDomain(pimexitandentrydtos);
        for(PIMEXITANDENTRY domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimexitandentryService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "SaveByPIMPERSON", tags = {"PIMEXITANDENTRY" },  notes = "SaveByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimexitandentries/save")
    public ResponseEntity<Boolean> saveByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMEXITANDENTRYDTO pimexitandentrydto) {
        PIMEXITANDENTRY domain = pimexitandentryMapping.toDomain(pimexitandentrydto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimexitandentryService.save(domain));
    }

    @ApiOperation(value = "SaveBatchByPIMPERSON", tags = {"PIMEXITANDENTRY" },  notes = "SaveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimexitandentries/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMEXITANDENTRYDTO> pimexitandentrydtos) {
        List<PIMEXITANDENTRY> domainlist=pimexitandentryMapping.toDomain(pimexitandentrydtos);
        for(PIMEXITANDENTRY domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimexitandentryService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "撤销ByPIMPERSON", tags = {"PIMEXITANDENTRY" },  notes = "撤销ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimexitandentries/{pimexitandentrypimexitandentryid}/cx")
    @Transactional
    public ResponseEntity<PIMEXITANDENTRYDTO> cXByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimexitandentry_id") String pimexitandentry_id, @RequestBody PIMEXITANDENTRYDTO pimexitandentrydto) {
        PIMEXITANDENTRY domain = pimexitandentryMapping.toDomain(pimexitandentrydto);
        domain.setPimpersonid(pimperson_id);
        domain = pimexitandentryService.cX(domain) ;
        pimexitandentrydto = pimexitandentryMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimexitandentrydto);
    }

    @ApiOperation(value = "GetByPIMPERSON", tags = {"PIMEXITANDENTRY" },  notes = "GetByPIMPERSON")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimexitandentries/{pimexitandentry_id}")
    public ResponseEntity<PIMEXITANDENTRYDTO> getByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimexitandentry_id") String pimexitandentry_id) {
        PIMEXITANDENTRY domain = pimexitandentryService.get(pimexitandentry_id);
        PIMEXITANDENTRYDTO dto = pimexitandentryMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "GetDraftByPIMPERSON", tags = {"PIMEXITANDENTRY" },  notes = "GetDraftByPIMPERSON")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimexitandentries/getdraft")
    public ResponseEntity<PIMEXITANDENTRYDTO> getDraftByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id) {
        PIMEXITANDENTRY domain = new PIMEXITANDENTRY();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimexitandentryMapping.toDto(pimexitandentryService.getDraft(domain)));
    }

    @ApiOperation(value = "移动端启动流程ByPIMPERSON", tags = {"PIMEXITANDENTRY" },  notes = "移动端启动流程ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimexitandentries/{pimexitandentrypimexitandentryid}/mobstart")
    @Transactional
    public ResponseEntity<PIMEXITANDENTRYDTO> mobStartByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimexitandentry_id") String pimexitandentry_id, @RequestBody PIMEXITANDENTRYDTO pimexitandentrydto) {
        PIMEXITANDENTRY domain = pimexitandentryMapping.toDomain(pimexitandentrydto);
        domain.setPimpersonid(pimperson_id);
        domain = pimexitandentryService.mobStart(domain) ;
        pimexitandentrydto = pimexitandentryMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimexitandentrydto);
    }

    @ApiOperation(value = "CreateByPIMPERSON", tags = {"PIMEXITANDENTRY" },  notes = "CreateByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimexitandentries")
    @Transactional
    public ResponseEntity<PIMEXITANDENTRYDTO> createByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMEXITANDENTRYDTO pimexitandentrydto) {
        PIMEXITANDENTRY domain = pimexitandentryMapping.toDomain(pimexitandentrydto);
        domain.setPimpersonid(pimperson_id);
		pimexitandentryService.create(domain);
        PIMEXITANDENTRYDTO dto = pimexitandentryMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatchByPIMPERSON", tags = {"PIMEXITANDENTRY" },  notes = "createBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimexitandentries/batch")
    public ResponseEntity<Boolean> createBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMEXITANDENTRYDTO> pimexitandentrydtos) {
        List<PIMEXITANDENTRY> domainlist=pimexitandentryMapping.toDomain(pimexitandentrydtos);
        for(PIMEXITANDENTRY domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimexitandentryService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "RemoveByPIMPERSON", tags = {"PIMEXITANDENTRY" },  notes = "RemoveByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimexitandentries/{pimexitandentry_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimexitandentry_id") String pimexitandentry_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimexitandentryService.remove(pimexitandentry_id));
    }

    @ApiOperation(value = "RemoveBatchByPIMPERSON", tags = {"PIMEXITANDENTRY" },  notes = "RemoveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimexitandentries/batch")
    public ResponseEntity<Boolean> removeBatchByPIMPERSON(@RequestBody List<String> ids) {
        pimexitandentryService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "催办ByPIMPERSON", tags = {"PIMEXITANDENTRY" },  notes = "催办ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimexitandentries/{pimexitandentrypimexitandentryid}/cb")
    @Transactional
    public ResponseEntity<PIMEXITANDENTRYDTO> cBByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimexitandentry_id") String pimexitandentry_id, @RequestBody PIMEXITANDENTRYDTO pimexitandentrydto) {
        PIMEXITANDENTRY domain = pimexitandentryMapping.toDomain(pimexitandentrydto);
        domain.setPimpersonid(pimperson_id);
        domain = pimexitandentryService.cB(domain) ;
        pimexitandentrydto = pimexitandentryMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimexitandentrydto);
    }

    @ApiOperation(value = "CheckKeyByPIMPERSON", tags = {"PIMEXITANDENTRY" },  notes = "CheckKeyByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimexitandentries/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMEXITANDENTRYDTO pimexitandentrydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimexitandentryService.checkKey(pimexitandentryMapping.toDomain(pimexitandentrydto)));
    }

    @ApiOperation(value = "启动流程ByPIMPERSON", tags = {"PIMEXITANDENTRY" },  notes = "启动流程ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimexitandentries/{pimexitandentrypimexitandentryid}/start")
    @Transactional
    public ResponseEntity<PIMEXITANDENTRYDTO> startByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimexitandentry_id") String pimexitandentry_id, @RequestBody PIMEXITANDENTRYDTO pimexitandentrydto) {
        PIMEXITANDENTRY domain = pimexitandentryMapping.toDomain(pimexitandentrydto);
        domain.setPimpersonid(pimperson_id);
        domain = pimexitandentryService.start(domain) ;
        pimexitandentrydto = pimexitandentryMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimexitandentrydto);
    }

	@ApiOperation(value = "fetch因公出国境ByPIMPERSON", tags = {"PIMEXITANDENTRY" } ,notes = "fetch因公出国境ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimexitandentries/fetchygcgj")
	public ResponseEntity<List<PIMEXITANDENTRYDTO>> fetchPIMEXITANDENTRYYGCGJByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMEXITANDENTRYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMEXITANDENTRY> domains = pimexitandentryService.searchYGCGJ(context) ;
        List<PIMEXITANDENTRYDTO> list = pimexitandentryMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search因公出国境ByPIMPERSON", tags = {"PIMEXITANDENTRY" } ,notes = "search因公出国境ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimexitandentries/searchygcgj")
	public ResponseEntity<Page<PIMEXITANDENTRYDTO>> searchPIMEXITANDENTRYYGCGJByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMEXITANDENTRYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMEXITANDENTRY> domains = pimexitandentryService.searchYGCGJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimexitandentryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch员工自助ByPIMPERSON", tags = {"PIMEXITANDENTRY" } ,notes = "fetch员工自助ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimexitandentries/fetchygzz")
	public ResponseEntity<List<PIMEXITANDENTRYDTO>> fetchPIMEXITANDENTRYYGZZByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMEXITANDENTRYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMEXITANDENTRY> domains = pimexitandentryService.searchYGZZ(context) ;
        List<PIMEXITANDENTRYDTO> list = pimexitandentryMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search员工自助ByPIMPERSON", tags = {"PIMEXITANDENTRY" } ,notes = "search员工自助ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimexitandentries/searchygzz")
	public ResponseEntity<Page<PIMEXITANDENTRYDTO>> searchPIMEXITANDENTRYYGZZByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMEXITANDENTRYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMEXITANDENTRY> domains = pimexitandentryService.searchYGZZ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimexitandentryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch记录所属（移动端）ByPIMPERSON", tags = {"PIMEXITANDENTRY" } ,notes = "fetch记录所属（移动端）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimexitandentries/fetchmobjlss")
	public ResponseEntity<List<PIMEXITANDENTRYDTO>> fetchPIMEXITANDENTRYMOBJLSSByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMEXITANDENTRYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMEXITANDENTRY> domains = pimexitandentryService.searchMOBJLSS(context) ;
        List<PIMEXITANDENTRYDTO> list = pimexitandentryMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search记录所属（移动端）ByPIMPERSON", tags = {"PIMEXITANDENTRY" } ,notes = "search记录所属（移动端）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimexitandentries/searchmobjlss")
	public ResponseEntity<Page<PIMEXITANDENTRYDTO>> searchPIMEXITANDENTRYMOBJLSSByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMEXITANDENTRYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMEXITANDENTRY> domains = pimexitandentryService.searchMOBJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimexitandentryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch因私出国境ByPIMPERSON", tags = {"PIMEXITANDENTRY" } ,notes = "fetch因私出国境ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimexitandentries/fetchyscgj")
	public ResponseEntity<List<PIMEXITANDENTRYDTO>> fetchPIMEXITANDENTRYYSCGJByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMEXITANDENTRYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMEXITANDENTRY> domains = pimexitandentryService.searchYSCGJ(context) ;
        List<PIMEXITANDENTRYDTO> list = pimexitandentryMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search因私出国境ByPIMPERSON", tags = {"PIMEXITANDENTRY" } ,notes = "search因私出国境ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimexitandentries/searchyscgj")
	public ResponseEntity<Page<PIMEXITANDENTRYDTO>> searchPIMEXITANDENTRYYSCGJByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMEXITANDENTRYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMEXITANDENTRY> domains = pimexitandentryService.searchYSCGJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimexitandentryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetchFormTypeByPIMPERSON", tags = {"PIMEXITANDENTRY" } ,notes = "fetchFormTypeByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimexitandentries/fetchformtype")
	public ResponseEntity<List<PIMEXITANDENTRYDTO>> fetchPIMEXITANDENTRYFormTypeByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMEXITANDENTRYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMEXITANDENTRY> domains = pimexitandentryService.searchFormType(context) ;
        List<PIMEXITANDENTRYDTO> list = pimexitandentryMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchFormTypeByPIMPERSON", tags = {"PIMEXITANDENTRY" } ,notes = "searchFormTypeByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimexitandentries/searchformtype")
	public ResponseEntity<Page<PIMEXITANDENTRYDTO>> searchPIMEXITANDENTRYFormTypeByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMEXITANDENTRYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMEXITANDENTRY> domains = pimexitandentryService.searchFormType(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimexitandentryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetchDEFAULTByPIMPERSON", tags = {"PIMEXITANDENTRY" } ,notes = "fetchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimexitandentries/fetchdefault")
	public ResponseEntity<List<PIMEXITANDENTRYDTO>> fetchPIMEXITANDENTRYDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMEXITANDENTRYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMEXITANDENTRY> domains = pimexitandentryService.searchDefault(context) ;
        List<PIMEXITANDENTRYDTO> list = pimexitandentryMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULTByPIMPERSON", tags = {"PIMEXITANDENTRY" } ,notes = "searchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimexitandentries/searchdefault")
	public ResponseEntity<Page<PIMEXITANDENTRYDTO>> searchPIMEXITANDENTRYDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMEXITANDENTRYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMEXITANDENTRY> domains = pimexitandentryService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimexitandentryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PIMEXITANDENTRY getEntity(){
        return new PIMEXITANDENTRY();
    }

}
