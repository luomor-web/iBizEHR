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
import cn.ibizlab.ehr.core.pim.domain.PIMARCHIVES;
import cn.ibizlab.ehr.core.pim.service.IPIMARCHIVESService;
import cn.ibizlab.ehr.core.pim.filter.PIMARCHIVESSearchContext;




@Slf4j
@Api(tags = {"PIMARCHIVES" })
@RestController("WebApi-pimarchives")
@RequestMapping("")
public class PIMARCHIVESResource {

    @Autowired
    private IPIMARCHIVESService pimarchivesService;

    @Autowired
    @Lazy
    public PIMARCHIVESMapping pimarchivesMapping;

    public PIMARCHIVESDTO permissionDTO=new PIMARCHIVESDTO();




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVES-GetPersonOrg-all')")
    @ApiOperation(value = "获取员工组织", tags = {"PIMARCHIVES" },  notes = "获取员工组织")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarchives/{pimarchives_id}/getpersonorg")
    @Transactional
    public ResponseEntity<PIMARCHIVESDTO> getPersonOrg(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESDTO pimarchivesdto) {
        PIMARCHIVES pimarchives = pimarchivesMapping.toDomain(pimarchivesdto);
        pimarchives = pimarchivesService.getPersonOrg(pimarchives);
        pimarchivesdto = pimarchivesMapping.toDto(pimarchives);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesdto);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVES-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PIMARCHIVES" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarchives/getdraft")
    public ResponseEntity<PIMARCHIVESDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesMapping.toDto(pimarchivesService.getDraft(new PIMARCHIVES())));
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVES-Save-all')")
    @ApiOperation(value = "Save", tags = {"PIMARCHIVES" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMARCHIVESDTO pimarchivesdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesService.save(pimarchivesMapping.toDomain(pimarchivesdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PIMARCHIVES" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMARCHIVESDTO> pimarchivesdtos) {
        pimarchivesService.saveBatch(pimarchivesMapping.toDomain(pimarchivesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pimarchives_id,'Get',{'Sql',this.pimarchivesMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PIMARCHIVES" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarchives/{pimarchives_id}")
    public ResponseEntity<PIMARCHIVESDTO> get(@PathVariable("pimarchives_id") String pimarchives_id) {
        PIMARCHIVES domain = pimarchivesService.get(pimarchives_id);
        PIMARCHIVESDTO dto = pimarchivesMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#pimarchives_id,'Update',{'Sql',this.pimarchivesMapping,#pimarchivesdto})")
    @ApiOperation(value = "Update", tags = {"PIMARCHIVES" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchives/{pimarchives_id}")
    @Transactional
    public ResponseEntity<PIMARCHIVESDTO> update(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESDTO pimarchivesdto) {
		PIMARCHIVES domain = pimarchivesMapping.toDomain(pimarchivesdto);
        domain.setPimarchivesid(pimarchives_id);
		pimarchivesService.update(domain);
		PIMARCHIVESDTO dto = pimarchivesMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"PIMARCHIVES" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchives/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMARCHIVESDTO> pimarchivesdtos) {
        pimarchivesService.updateBatch(pimarchivesMapping.toDomain(pimarchivesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVES-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PIMARCHIVES" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMARCHIVESDTO pimarchivesdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimarchivesService.checkKey(pimarchivesMapping.toDomain(pimarchivesdto)));
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.pimarchivesMapping,#pimarchivesdto})")
    @ApiOperation(value = "Create", tags = {"PIMARCHIVES" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives")
    @Transactional
    public ResponseEntity<PIMARCHIVESDTO> create(@RequestBody PIMARCHIVESDTO pimarchivesdto) {
        PIMARCHIVES domain = pimarchivesMapping.toDomain(pimarchivesdto);
		pimarchivesService.create(domain);
        PIMARCHIVESDTO dto = pimarchivesMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"PIMARCHIVES" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMARCHIVESDTO> pimarchivesdtos) {
        pimarchivesService.createBatch(pimarchivesMapping.toDomain(pimarchivesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pimarchives_id,'Remove',{'Sql',this.pimarchivesMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PIMARCHIVES" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchives/{pimarchives_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimarchives_id") String pimarchives_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimarchivesService.remove(pimarchives_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PIMARCHIVES" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchives/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimarchivesService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVES-EMLOYEENOFILE-all')")
	@ApiOperation(value = "fetch员工不在档档案", tags = {"PIMARCHIVES" } ,notes = "fetch员工不在档档案")
    @RequestMapping(method= RequestMethod.GET , value="/pimarchives/fetchemloyeenofile")
	public ResponseEntity<List<PIMARCHIVESDTO>> fetchEMLOYEENOFILE(PIMARCHIVESSearchContext context) {
        Page<PIMARCHIVES> domains = pimarchivesService.searchEMLOYEENOFILE(context) ;
        List<PIMARCHIVESDTO> list = pimarchivesMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVES-EMLOYEENOFILE-all')")
	@ApiOperation(value = "search员工不在档档案", tags = {"PIMARCHIVES" } ,notes = "search员工不在档档案")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchives/searchemloyeenofile")
	public ResponseEntity<Page<PIMARCHIVESDTO>> searchEMLOYEENOFILE(@RequestBody PIMARCHIVESSearchContext context) {
        Page<PIMARCHIVES> domains = pimarchivesService.searchEMLOYEENOFILE(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVES-SysOrgIsSrfOrg-all')")
	@ApiOperation(value = "fetch管理单位等于当前登录人的单位（用于非员工在档数据查询）", tags = {"PIMARCHIVES" } ,notes = "fetch管理单位等于当前登录人的单位（用于非员工在档数据查询）")
    @RequestMapping(method= RequestMethod.GET , value="/pimarchives/fetchsysorgissrforg")
	public ResponseEntity<List<PIMARCHIVESDTO>> fetchSysOrgIsSrfOrg(PIMARCHIVESSearchContext context) {
        Page<PIMARCHIVES> domains = pimarchivesService.searchSysOrgIsSrfOrg(context) ;
        List<PIMARCHIVESDTO> list = pimarchivesMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVES-SysOrgIsSrfOrg-all')")
	@ApiOperation(value = "search管理单位等于当前登录人的单位（用于非员工在档数据查询）", tags = {"PIMARCHIVES" } ,notes = "search管理单位等于当前登录人的单位（用于非员工在档数据查询）")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchives/searchsysorgissrforg")
	public ResponseEntity<Page<PIMARCHIVESDTO>> searchSysOrgIsSrfOrg(@RequestBody PIMARCHIVESSearchContext context) {
        Page<PIMARCHIVES> domains = pimarchivesService.searchSysOrgIsSrfOrg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVES-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMARCHIVES" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimarchives/fetchdefault")
	public ResponseEntity<List<PIMARCHIVESDTO>> fetchDefault(PIMARCHIVESSearchContext context) {
        Page<PIMARCHIVES> domains = pimarchivesService.searchDefault(context) ;
        List<PIMARCHIVESDTO> list = pimarchivesMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVES-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMARCHIVES" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchives/searchdefault")
	public ResponseEntity<Page<PIMARCHIVESDTO>> searchDefault(@RequestBody PIMARCHIVESSearchContext context) {
        Page<PIMARCHIVES> domains = pimarchivesService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVES-JLSS-all')")
	@ApiOperation(value = "fetch记录所属和个人ID不符的", tags = {"PIMARCHIVES" } ,notes = "fetch记录所属和个人ID不符的")
    @RequestMapping(method= RequestMethod.GET , value="/pimarchives/fetchjlss")
	public ResponseEntity<List<PIMARCHIVESDTO>> fetchJLSS(PIMARCHIVESSearchContext context) {
        Page<PIMARCHIVES> domains = pimarchivesService.searchJLSS(context) ;
        List<PIMARCHIVESDTO> list = pimarchivesMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVES-JLSS-all')")
	@ApiOperation(value = "search记录所属和个人ID不符的", tags = {"PIMARCHIVES" } ,notes = "search记录所属和个人ID不符的")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchives/searchjlss")
	public ResponseEntity<Page<PIMARCHIVESDTO>> searchJLSS(@RequestBody PIMARCHIVESSearchContext context) {
        Page<PIMARCHIVES> domains = pimarchivesService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVES-ZIZHU-all')")
	@ApiOperation(value = "fetch自助(档案信息)", tags = {"PIMARCHIVES" } ,notes = "fetch自助(档案信息)")
    @RequestMapping(method= RequestMethod.GET , value="/pimarchives/fetchzizhu")
	public ResponseEntity<List<PIMARCHIVESDTO>> fetchZIZHU(PIMARCHIVESSearchContext context) {
        Page<PIMARCHIVES> domains = pimarchivesService.searchZIZHU(context) ;
        List<PIMARCHIVESDTO> list = pimarchivesMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVES-ZIZHU-all')")
	@ApiOperation(value = "search自助(档案信息)", tags = {"PIMARCHIVES" } ,notes = "search自助(档案信息)")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchives/searchzizhu")
	public ResponseEntity<Page<PIMARCHIVESDTO>> searchZIZHU(@RequestBody PIMARCHIVESSearchContext context) {
        Page<PIMARCHIVES> domains = pimarchivesService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVES-NOEMLOYEENOFILE-all')")
	@ApiOperation(value = "fetch非员工在档档案", tags = {"PIMARCHIVES" } ,notes = "fetch非员工在档档案")
    @RequestMapping(method= RequestMethod.GET , value="/pimarchives/fetchnoemloyeenofile")
	public ResponseEntity<List<PIMARCHIVESDTO>> fetchNOEMLOYEENOFILE(PIMARCHIVESSearchContext context) {
        Page<PIMARCHIVES> domains = pimarchivesService.searchNOEMLOYEENOFILE(context) ;
        List<PIMARCHIVESDTO> list = pimarchivesMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVES-NOEMLOYEENOFILE-all')")
	@ApiOperation(value = "search非员工在档档案", tags = {"PIMARCHIVES" } ,notes = "search非员工在档档案")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchives/searchnoemloyeenofile")
	public ResponseEntity<Page<PIMARCHIVESDTO>> searchNOEMLOYEENOFILE(@RequestBody PIMARCHIVESSearchContext context) {
        Page<PIMARCHIVES> domains = pimarchivesService.searchNOEMLOYEENOFILE(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVES-PIMREADGJD-all')")
	@ApiOperation(value = "fetch档案信息组织查询", tags = {"PIMARCHIVES" } ,notes = "fetch档案信息组织查询")
    @RequestMapping(method= RequestMethod.GET , value="/pimarchives/fetchpimreadgjd")
	public ResponseEntity<List<PIMARCHIVESDTO>> fetchPIMREADGJD(PIMARCHIVESSearchContext context) {
        Page<PIMARCHIVES> domains = pimarchivesService.searchPIMREADGJD(context) ;
        List<PIMARCHIVESDTO> list = pimarchivesMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVES-PIMREADGJD-all')")
	@ApiOperation(value = "search档案信息组织查询", tags = {"PIMARCHIVES" } ,notes = "search档案信息组织查询")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchives/searchpimreadgjd")
	public ResponseEntity<Page<PIMARCHIVESDTO>> searchPIMREADGJD(@RequestBody PIMARCHIVESSearchContext context) {
        Page<PIMARCHIVES> domains = pimarchivesService.searchPIMREADGJD(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}



    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVES-GetPersonOrg-all')")
    @ApiOperation(value = "获取员工组织ByPIMPERSON", tags = {"PIMARCHIVES" },  notes = "获取员工组织ByPIMPERSON")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchivespimarchivesid}/getpersonorg")
    @Transactional
    public ResponseEntity<PIMARCHIVESDTO> getPersonOrgByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESDTO pimarchivesdto) {
        PIMARCHIVES domain = pimarchivesMapping.toDomain(pimarchivesdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimarchivesService.getPersonOrg(domain) ;
        pimarchivesdto = pimarchivesMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesdto);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVES-GetDraft-all')")
    @ApiOperation(value = "GetDraftByPIMPERSON", tags = {"PIMARCHIVES" },  notes = "GetDraftByPIMPERSON")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimarchives/getdraft")
    public ResponseEntity<PIMARCHIVESDTO> getDraftByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id) {
        PIMARCHIVES domain = new PIMARCHIVES();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesMapping.toDto(pimarchivesService.getDraft(domain)));
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVES-Save-all')")
    @ApiOperation(value = "SaveByPIMPERSON", tags = {"PIMARCHIVES" },  notes = "SaveByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/save")
    public ResponseEntity<Boolean> saveByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMARCHIVESDTO pimarchivesdto) {
        PIMARCHIVES domain = pimarchivesMapping.toDomain(pimarchivesdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesService.save(domain));
    }

    @ApiOperation(value = "SaveBatchByPIMPERSON", tags = {"PIMARCHIVES" },  notes = "SaveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMARCHIVESDTO> pimarchivesdtos) {
        List<PIMARCHIVES> domainlist=pimarchivesMapping.toDomain(pimarchivesdtos);
        for(PIMARCHIVES domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimarchivesService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasPermission(#pimarchives_id,'Get',{'Sql',this.pimarchivesMapping,this.permissionDTO})")
    @ApiOperation(value = "GetByPIMPERSON", tags = {"PIMARCHIVES" },  notes = "GetByPIMPERSON")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}")
    public ResponseEntity<PIMARCHIVESDTO> getByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id) {
        PIMARCHIVES domain = pimarchivesService.get(pimarchives_id);
        PIMARCHIVESDTO dto = pimarchivesMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    //@PreAuthorize("hasPermission(#pimarchives_id,'Update',{'Sql',this.pimarchivesMapping,#pimarchivesdto})")
    @ApiOperation(value = "UpdateByPIMPERSON", tags = {"PIMARCHIVES" },  notes = "UpdateByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}")
    @Transactional
    public ResponseEntity<PIMARCHIVESDTO> updateByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESDTO pimarchivesdto) {
        PIMARCHIVES domain = pimarchivesMapping.toDomain(pimarchivesdto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimarchivesid(pimarchives_id);
		pimarchivesService.update(domain);
        PIMARCHIVESDTO dto = pimarchivesMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatchByPIMPERSON", tags = {"PIMARCHIVES" },  notes = "UpdateBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimarchives/batch")
    public ResponseEntity<Boolean> updateBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMARCHIVESDTO> pimarchivesdtos) {
        List<PIMARCHIVES> domainlist=pimarchivesMapping.toDomain(pimarchivesdtos);
        for(PIMARCHIVES domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimarchivesService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVES-CheckKey-all')")
    @ApiOperation(value = "CheckKeyByPIMPERSON", tags = {"PIMARCHIVES" },  notes = "CheckKeyByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMARCHIVESDTO pimarchivesdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimarchivesService.checkKey(pimarchivesMapping.toDomain(pimarchivesdto)));
    }

    //@PreAuthorize("hasPermission('','Create',{'Sql',this.pimarchivesMapping,#pimarchivesdto})")
    @ApiOperation(value = "CreateByPIMPERSON", tags = {"PIMARCHIVES" },  notes = "CreateByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives")
    @Transactional
    public ResponseEntity<PIMARCHIVESDTO> createByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMARCHIVESDTO pimarchivesdto) {
        PIMARCHIVES domain = pimarchivesMapping.toDomain(pimarchivesdto);
        domain.setPimpersonid(pimperson_id);
		pimarchivesService.create(domain);
        PIMARCHIVESDTO dto = pimarchivesMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatchByPIMPERSON", tags = {"PIMARCHIVES" },  notes = "createBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/batch")
    public ResponseEntity<Boolean> createBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMARCHIVESDTO> pimarchivesdtos) {
        List<PIMARCHIVES> domainlist=pimarchivesMapping.toDomain(pimarchivesdtos);
        for(PIMARCHIVES domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimarchivesService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasPermission(#pimarchives_id,'Remove',{'Sql',this.pimarchivesMapping,this.permissionDTO})")
    @ApiOperation(value = "RemoveByPIMPERSON", tags = {"PIMARCHIVES" },  notes = "RemoveByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimarchivesService.remove(pimarchives_id));
    }

    @ApiOperation(value = "RemoveBatchByPIMPERSON", tags = {"PIMARCHIVES" },  notes = "RemoveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimarchives/batch")
    public ResponseEntity<Boolean> removeBatchByPIMPERSON(@RequestBody List<String> ids) {
        pimarchivesService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVES-EMLOYEENOFILE-all')")
	@ApiOperation(value = "fetch员工不在档档案ByPIMPERSON", tags = {"PIMARCHIVES" } ,notes = "fetch员工不在档档案ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimarchives/fetchemloyeenofile")
	public ResponseEntity<List<PIMARCHIVESDTO>> fetchPIMARCHIVESEMLOYEENOFILEByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMARCHIVESSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMARCHIVES> domains = pimarchivesService.searchEMLOYEENOFILE(context) ;
        List<PIMARCHIVESDTO> list = pimarchivesMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVES-EMLOYEENOFILE-all')")
	@ApiOperation(value = "search员工不在档档案ByPIMPERSON", tags = {"PIMARCHIVES" } ,notes = "search员工不在档档案ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimarchives/searchemloyeenofile")
	public ResponseEntity<Page<PIMARCHIVESDTO>> searchPIMARCHIVESEMLOYEENOFILEByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMARCHIVESSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMARCHIVES> domains = pimarchivesService.searchEMLOYEENOFILE(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVES-SysOrgIsSrfOrg-all')")
	@ApiOperation(value = "fetch管理单位等于当前登录人的单位（用于非员工在档数据查询）ByPIMPERSON", tags = {"PIMARCHIVES" } ,notes = "fetch管理单位等于当前登录人的单位（用于非员工在档数据查询）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimarchives/fetchsysorgissrforg")
	public ResponseEntity<List<PIMARCHIVESDTO>> fetchPIMARCHIVESSysOrgIsSrfOrgByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMARCHIVESSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMARCHIVES> domains = pimarchivesService.searchSysOrgIsSrfOrg(context) ;
        List<PIMARCHIVESDTO> list = pimarchivesMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVES-SysOrgIsSrfOrg-all')")
	@ApiOperation(value = "search管理单位等于当前登录人的单位（用于非员工在档数据查询）ByPIMPERSON", tags = {"PIMARCHIVES" } ,notes = "search管理单位等于当前登录人的单位（用于非员工在档数据查询）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimarchives/searchsysorgissrforg")
	public ResponseEntity<Page<PIMARCHIVESDTO>> searchPIMARCHIVESSysOrgIsSrfOrgByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMARCHIVESSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMARCHIVES> domains = pimarchivesService.searchSysOrgIsSrfOrg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVES-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPIMPERSON", tags = {"PIMARCHIVES" } ,notes = "fetchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimarchives/fetchdefault")
	public ResponseEntity<List<PIMARCHIVESDTO>> fetchPIMARCHIVESDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMARCHIVESSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMARCHIVES> domains = pimarchivesService.searchDefault(context) ;
        List<PIMARCHIVESDTO> list = pimarchivesMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVES-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPIMPERSON", tags = {"PIMARCHIVES" } ,notes = "searchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimarchives/searchdefault")
	public ResponseEntity<Page<PIMARCHIVESDTO>> searchPIMARCHIVESDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMARCHIVESSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMARCHIVES> domains = pimarchivesService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVES-JLSS-all')")
	@ApiOperation(value = "fetch记录所属和个人ID不符的ByPIMPERSON", tags = {"PIMARCHIVES" } ,notes = "fetch记录所属和个人ID不符的ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimarchives/fetchjlss")
	public ResponseEntity<List<PIMARCHIVESDTO>> fetchPIMARCHIVESJLSSByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMARCHIVESSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMARCHIVES> domains = pimarchivesService.searchJLSS(context) ;
        List<PIMARCHIVESDTO> list = pimarchivesMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVES-JLSS-all')")
	@ApiOperation(value = "search记录所属和个人ID不符的ByPIMPERSON", tags = {"PIMARCHIVES" } ,notes = "search记录所属和个人ID不符的ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimarchives/searchjlss")
	public ResponseEntity<Page<PIMARCHIVESDTO>> searchPIMARCHIVESJLSSByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMARCHIVESSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMARCHIVES> domains = pimarchivesService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVES-ZIZHU-all')")
	@ApiOperation(value = "fetch自助(档案信息)ByPIMPERSON", tags = {"PIMARCHIVES" } ,notes = "fetch自助(档案信息)ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimarchives/fetchzizhu")
	public ResponseEntity<List<PIMARCHIVESDTO>> fetchPIMARCHIVESZIZHUByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMARCHIVESSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMARCHIVES> domains = pimarchivesService.searchZIZHU(context) ;
        List<PIMARCHIVESDTO> list = pimarchivesMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVES-ZIZHU-all')")
	@ApiOperation(value = "search自助(档案信息)ByPIMPERSON", tags = {"PIMARCHIVES" } ,notes = "search自助(档案信息)ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimarchives/searchzizhu")
	public ResponseEntity<Page<PIMARCHIVESDTO>> searchPIMARCHIVESZIZHUByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMARCHIVESSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMARCHIVES> domains = pimarchivesService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVES-NOEMLOYEENOFILE-all')")
	@ApiOperation(value = "fetch非员工在档档案ByPIMPERSON", tags = {"PIMARCHIVES" } ,notes = "fetch非员工在档档案ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimarchives/fetchnoemloyeenofile")
	public ResponseEntity<List<PIMARCHIVESDTO>> fetchPIMARCHIVESNOEMLOYEENOFILEByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMARCHIVESSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMARCHIVES> domains = pimarchivesService.searchNOEMLOYEENOFILE(context) ;
        List<PIMARCHIVESDTO> list = pimarchivesMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVES-NOEMLOYEENOFILE-all')")
	@ApiOperation(value = "search非员工在档档案ByPIMPERSON", tags = {"PIMARCHIVES" } ,notes = "search非员工在档档案ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimarchives/searchnoemloyeenofile")
	public ResponseEntity<Page<PIMARCHIVESDTO>> searchPIMARCHIVESNOEMLOYEENOFILEByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMARCHIVESSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMARCHIVES> domains = pimarchivesService.searchNOEMLOYEENOFILE(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVES-PIMREADGJD-all')")
	@ApiOperation(value = "fetch档案信息组织查询ByPIMPERSON", tags = {"PIMARCHIVES" } ,notes = "fetch档案信息组织查询ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimarchives/fetchpimreadgjd")
	public ResponseEntity<List<PIMARCHIVESDTO>> fetchPIMARCHIVESPIMREADGJDByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMARCHIVESSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMARCHIVES> domains = pimarchivesService.searchPIMREADGJD(context) ;
        List<PIMARCHIVESDTO> list = pimarchivesMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVES-PIMREADGJD-all')")
	@ApiOperation(value = "search档案信息组织查询ByPIMPERSON", tags = {"PIMARCHIVES" } ,notes = "search档案信息组织查询ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimarchives/searchpimreadgjd")
	public ResponseEntity<Page<PIMARCHIVESDTO>> searchPIMARCHIVESPIMREADGJDByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMARCHIVESSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMARCHIVES> domains = pimarchivesService.searchPIMREADGJD(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


