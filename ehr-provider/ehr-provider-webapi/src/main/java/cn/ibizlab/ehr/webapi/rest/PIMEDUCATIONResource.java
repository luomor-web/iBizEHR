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
import cn.ibizlab.ehr.core.pim.domain.PIMEDUCATION;
import cn.ibizlab.ehr.core.pim.service.IPIMEDUCATIONService;
import cn.ibizlab.ehr.core.pim.filter.PIMEDUCATIONSearchContext;




@Slf4j
@Api(tags = {"PIMEDUCATION" })
@RestController("WebApi-pimeducation")
@RequestMapping("")
public class PIMEDUCATIONResource {

    @Autowired
    private IPIMEDUCATIONService pimeducationService;

    @Autowired
    @Lazy
    public PIMEDUCATIONMapping pimeducationMapping;

    public PIMEDUCATIONDTO permissionDTO=new PIMEDUCATIONDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-CheckHighestEdu-all')")
    @ApiOperation(value = "检查最高学历", tags = {"PIMEDUCATION" },  notes = "检查最高学历")
	@RequestMapping(method = RequestMethod.POST, value = "/pimeducations/{pimeducation_id}/checkhighestedu")
    @Transactional
    public ResponseEntity<PIMEDUCATIONDTO> checkHighestEdu(@PathVariable("pimeducation_id") String pimeducation_id, @RequestBody PIMEDUCATIONDTO pimeducationdto) {
        PIMEDUCATION pimeducation = pimeducationMapping.toDomain(pimeducationdto);
        pimeducation = pimeducationService.checkHighestEdu(pimeducation);
        pimeducationdto = pimeducationMapping.toDto(pimeducation);
        return ResponseEntity.status(HttpStatus.OK).body(pimeducationdto);
    }

    @PreAuthorize("hasPermission(#pimeducation_id,'Get',{'Sql',this.pimeducationMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PIMEDUCATION" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimeducations/{pimeducation_id}")
    public ResponseEntity<PIMEDUCATIONDTO> get(@PathVariable("pimeducation_id") String pimeducation_id) {
        PIMEDUCATION domain = pimeducationService.get(pimeducation_id);
        PIMEDUCATIONDTO dto = pimeducationMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-Save-all')")
    @ApiOperation(value = "Save", tags = {"PIMEDUCATION" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimeducations/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMEDUCATIONDTO pimeducationdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimeducationService.save(pimeducationMapping.toDomain(pimeducationdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PIMEDUCATION" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimeducations/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMEDUCATIONDTO> pimeducationdtos) {
        pimeducationService.saveBatch(pimeducationMapping.toDomain(pimeducationdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pimeducationMapping,#pimeducationdto})")
    @ApiOperation(value = "Create", tags = {"PIMEDUCATION" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimeducations")
    @Transactional
    public ResponseEntity<PIMEDUCATIONDTO> create(@RequestBody PIMEDUCATIONDTO pimeducationdto) {
        PIMEDUCATION domain = pimeducationMapping.toDomain(pimeducationdto);
		pimeducationService.create(domain);
        PIMEDUCATIONDTO dto = pimeducationMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"PIMEDUCATION" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimeducations/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMEDUCATIONDTO> pimeducationdtos) {
        pimeducationService.createBatch(pimeducationMapping.toDomain(pimeducationdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PIMEDUCATION" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimeducations/getdraft")
    public ResponseEntity<PIMEDUCATIONDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimeducationMapping.toDto(pimeducationService.getDraft(new PIMEDUCATION())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PIMEDUCATION" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimeducations/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMEDUCATIONDTO pimeducationdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimeducationService.checkKey(pimeducationMapping.toDomain(pimeducationdto)));
    }

    @PreAuthorize("hasPermission(#pimeducation_id,'Remove',{'Sql',this.pimeducationMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PIMEDUCATION" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimeducations/{pimeducation_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimeducation_id") String pimeducation_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimeducationService.remove(pimeducation_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PIMEDUCATION" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimeducations/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimeducationService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pimeducation_id,'Update',{'Sql',this.pimeducationMapping,#pimeducationdto})")
    @ApiOperation(value = "Update", tags = {"PIMEDUCATION" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimeducations/{pimeducation_id}")
    @Transactional
    public ResponseEntity<PIMEDUCATIONDTO> update(@PathVariable("pimeducation_id") String pimeducation_id, @RequestBody PIMEDUCATIONDTO pimeducationdto) {
		PIMEDUCATION domain = pimeducationMapping.toDomain(pimeducationdto);
        domain.setPimeducationid(pimeducation_id);
		pimeducationService.update(domain);
		PIMEDUCATIONDTO dto = pimeducationMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMEDUCATION" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimeducations/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMEDUCATIONDTO> pimeducationdtos) {
        pimeducationService.updateBatch(pimeducationMapping.toDomain(pimeducationdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-FAZZSY-all')")
	@ApiOperation(value = "fetch教育信息（非A转正专用）", tags = {"PIMEDUCATION" } ,notes = "fetch教育信息（非A转正专用）")
    @RequestMapping(method= RequestMethod.GET , value="/pimeducations/fetchfazzsy")
	public ResponseEntity<List<PIMEDUCATIONDTO>> fetchFAZZSY(PIMEDUCATIONSearchContext context) {
        Page<PIMEDUCATION> domains = pimeducationService.searchFAZZSY(context) ;
        List<PIMEDUCATIONDTO> list = pimeducationMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-FAZZSY-all')")
	@ApiOperation(value = "search教育信息（非A转正专用）", tags = {"PIMEDUCATION" } ,notes = "search教育信息（非A转正专用）")
    @RequestMapping(method= RequestMethod.POST , value="/pimeducations/searchfazzsy")
	public ResponseEntity<Page<PIMEDUCATIONDTO>> searchFAZZSY(@RequestBody PIMEDUCATIONSearchContext context) {
        Page<PIMEDUCATION> domains = pimeducationService.searchFAZZSY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimeducationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-JLSS-all')")
	@ApiOperation(value = "fetch记录所属", tags = {"PIMEDUCATION" } ,notes = "fetch记录所属")
    @RequestMapping(method= RequestMethod.GET , value="/pimeducations/fetchjlss")
	public ResponseEntity<List<PIMEDUCATIONDTO>> fetchJLSS(PIMEDUCATIONSearchContext context) {
        Page<PIMEDUCATION> domains = pimeducationService.searchJLSS(context) ;
        List<PIMEDUCATIONDTO> list = pimeducationMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-JLSS-all')")
	@ApiOperation(value = "search记录所属", tags = {"PIMEDUCATION" } ,notes = "search记录所属")
    @RequestMapping(method= RequestMethod.POST , value="/pimeducations/searchjlss")
	public ResponseEntity<Page<PIMEDUCATIONDTO>> searchJLSS(@RequestBody PIMEDUCATIONSearchContext context) {
        Page<PIMEDUCATION> domains = pimeducationService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimeducationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-ZIZHU-all')")
	@ApiOperation(value = "fetch自助(教育信息)", tags = {"PIMEDUCATION" } ,notes = "fetch自助(教育信息)")
    @RequestMapping(method= RequestMethod.GET , value="/pimeducations/fetchzizhu")
	public ResponseEntity<List<PIMEDUCATIONDTO>> fetchZIZHU(PIMEDUCATIONSearchContext context) {
        Page<PIMEDUCATION> domains = pimeducationService.searchZIZHU(context) ;
        List<PIMEDUCATIONDTO> list = pimeducationMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-ZIZHU-all')")
	@ApiOperation(value = "search自助(教育信息)", tags = {"PIMEDUCATION" } ,notes = "search自助(教育信息)")
    @RequestMapping(method= RequestMethod.POST , value="/pimeducations/searchzizhu")
	public ResponseEntity<Page<PIMEDUCATIONDTO>> searchZIZHU(@RequestBody PIMEDUCATIONSearchContext context) {
        Page<PIMEDUCATION> domains = pimeducationService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimeducationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-ADMDYZG-all')")
	@ApiOperation(value = "fetch第一学历和最高学历（管理员）", tags = {"PIMEDUCATION" } ,notes = "fetch第一学历和最高学历（管理员）")
    @RequestMapping(method= RequestMethod.GET , value="/pimeducations/fetchadmdyzg")
	public ResponseEntity<List<PIMEDUCATIONDTO>> fetchADMDYZG(PIMEDUCATIONSearchContext context) {
        Page<PIMEDUCATION> domains = pimeducationService.searchADMDYZG(context) ;
        List<PIMEDUCATIONDTO> list = pimeducationMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-ADMDYZG-all')")
	@ApiOperation(value = "search第一学历和最高学历（管理员）", tags = {"PIMEDUCATION" } ,notes = "search第一学历和最高学历（管理员）")
    @RequestMapping(method= RequestMethod.POST , value="/pimeducations/searchadmdyzg")
	public ResponseEntity<Page<PIMEDUCATIONDTO>> searchADMDYZG(@RequestBody PIMEDUCATIONSearchContext context) {
        Page<PIMEDUCATION> domains = pimeducationService.searchADMDYZG(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimeducationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-PERSONAL-all')")
	@ApiOperation(value = "fetch记录所属（个人）", tags = {"PIMEDUCATION" } ,notes = "fetch记录所属（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pimeducations/fetchpersonal")
	public ResponseEntity<List<PIMEDUCATIONDTO>> fetchPERSONAL(PIMEDUCATIONSearchContext context) {
        Page<PIMEDUCATION> domains = pimeducationService.searchPERSONAL(context) ;
        List<PIMEDUCATIONDTO> list = pimeducationMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-PERSONAL-all')")
	@ApiOperation(value = "search记录所属（个人）", tags = {"PIMEDUCATION" } ,notes = "search记录所属（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pimeducations/searchpersonal")
	public ResponseEntity<Page<PIMEDUCATIONDTO>> searchPERSONAL(@RequestBody PIMEDUCATIONSearchContext context) {
        Page<PIMEDUCATION> domains = pimeducationService.searchPERSONAL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimeducationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-ADMSYSTEM-all')")
	@ApiOperation(value = "fetch记录所属（管理员）", tags = {"PIMEDUCATION" } ,notes = "fetch记录所属（管理员）")
    @RequestMapping(method= RequestMethod.GET , value="/pimeducations/fetchadmsystem")
	public ResponseEntity<List<PIMEDUCATIONDTO>> fetchADMSYSTEM(PIMEDUCATIONSearchContext context) {
        Page<PIMEDUCATION> domains = pimeducationService.searchADMSYSTEM(context) ;
        List<PIMEDUCATIONDTO> list = pimeducationMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-ADMSYSTEM-all')")
	@ApiOperation(value = "search记录所属（管理员）", tags = {"PIMEDUCATION" } ,notes = "search记录所属（管理员）")
    @RequestMapping(method= RequestMethod.POST , value="/pimeducations/searchadmsystem")
	public ResponseEntity<Page<PIMEDUCATIONDTO>> searchADMSYSTEM(@RequestBody PIMEDUCATIONSearchContext context) {
        Page<PIMEDUCATION> domains = pimeducationService.searchADMSYSTEM(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimeducationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMEDUCATION" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimeducations/fetchdefault")
	public ResponseEntity<List<PIMEDUCATIONDTO>> fetchDefault(PIMEDUCATIONSearchContext context) {
        Page<PIMEDUCATION> domains = pimeducationService.searchDefault(context) ;
        List<PIMEDUCATIONDTO> list = pimeducationMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMEDUCATION" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimeducations/searchdefault")
	public ResponseEntity<Page<PIMEDUCATIONDTO>> searchDefault(@RequestBody PIMEDUCATIONSearchContext context) {
        Page<PIMEDUCATION> domains = pimeducationService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimeducationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-REP_EDU-all')")
	@ApiOperation(value = "fetch图表_学历分布统计", tags = {"PIMEDUCATION" } ,notes = "fetch图表_学历分布统计")
    @RequestMapping(method= RequestMethod.GET , value="/pimeducations/fetchrep_edu")
	public ResponseEntity<List<HashMap>> fetchREP_EDU(PIMEDUCATIONSearchContext context) {
        Page<HashMap> domains = pimeducationService.searchREP_EDU(context) ;
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(domains.getContent());
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-REP_EDU-all')")
	@ApiOperation(value = "search图表_学历分布统计", tags = {"PIMEDUCATION" } ,notes = "search图表_学历分布统计")
    @RequestMapping(method= RequestMethod.POST , value="/pimeducations/searchrep_edu")
	public ResponseEntity<Page<HashMap>> searchREP_EDU(@RequestBody PIMEDUCATIONSearchContext context) {
        Page<HashMap> domains = pimeducationService.searchREP_EDU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(domains.getContent(), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-CheckHighestEdu-all')")
    @ApiOperation(value = "检查最高学历ByPIMPERSON", tags = {"PIMEDUCATION" },  notes = "检查最高学历ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimeducations/{pimeducationpimeducationid}/checkhighestedu")
    @Transactional
    public ResponseEntity<PIMEDUCATIONDTO> checkHighestEduByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimeducation_id") String pimeducation_id, @RequestBody PIMEDUCATIONDTO pimeducationdto) {
        PIMEDUCATION domain = pimeducationMapping.toDomain(pimeducationdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimeducationService.checkHighestEdu(domain) ;
        pimeducationdto = pimeducationMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimeducationdto);
    }

    //@PreAuthorize("hasPermission(#pimeducation_id,'Get',{'Sql',this.pimeducationMapping,this.permissionDTO})")
    @ApiOperation(value = "GetByPIMPERSON", tags = {"PIMEDUCATION" },  notes = "GetByPIMPERSON")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimeducations/{pimeducation_id}")
    public ResponseEntity<PIMEDUCATIONDTO> getByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimeducation_id") String pimeducation_id) {
        PIMEDUCATION domain = pimeducationService.get(pimeducation_id);
        PIMEDUCATIONDTO dto = pimeducationMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-Save-all')")
    @ApiOperation(value = "SaveByPIMPERSON", tags = {"PIMEDUCATION" },  notes = "SaveByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimeducations/save")
    public ResponseEntity<Boolean> saveByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMEDUCATIONDTO pimeducationdto) {
        PIMEDUCATION domain = pimeducationMapping.toDomain(pimeducationdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimeducationService.save(domain));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatchByPIMPERSON", tags = {"PIMEDUCATION" },  notes = "SaveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimeducations/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMEDUCATIONDTO> pimeducationdtos) {
        List<PIMEDUCATION> domainlist=pimeducationMapping.toDomain(pimeducationdtos);
        for(PIMEDUCATION domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimeducationService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasPermission('','Create',{'Sql',this.pimeducationMapping,#pimeducationdto})")
    @ApiOperation(value = "CreateByPIMPERSON", tags = {"PIMEDUCATION" },  notes = "CreateByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimeducations")
    @Transactional
    public ResponseEntity<PIMEDUCATIONDTO> createByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMEDUCATIONDTO pimeducationdto) {
        PIMEDUCATION domain = pimeducationMapping.toDomain(pimeducationdto);
        domain.setPimpersonid(pimperson_id);
		pimeducationService.create(domain);
        PIMEDUCATIONDTO dto = pimeducationMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatchByPIMPERSON", tags = {"PIMEDUCATION" },  notes = "createBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimeducations/batch")
    public ResponseEntity<Boolean> createBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMEDUCATIONDTO> pimeducationdtos) {
        List<PIMEDUCATION> domainlist=pimeducationMapping.toDomain(pimeducationdtos);
        for(PIMEDUCATION domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimeducationService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-GetDraft-all')")
    @ApiOperation(value = "GetDraftByPIMPERSON", tags = {"PIMEDUCATION" },  notes = "GetDraftByPIMPERSON")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimeducations/getdraft")
    public ResponseEntity<PIMEDUCATIONDTO> getDraftByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id) {
        PIMEDUCATION domain = new PIMEDUCATION();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimeducationMapping.toDto(pimeducationService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-CheckKey-all')")
    @ApiOperation(value = "CheckKeyByPIMPERSON", tags = {"PIMEDUCATION" },  notes = "CheckKeyByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimeducations/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMEDUCATIONDTO pimeducationdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimeducationService.checkKey(pimeducationMapping.toDomain(pimeducationdto)));
    }

    //@PreAuthorize("hasPermission(#pimeducation_id,'Remove',{'Sql',this.pimeducationMapping,this.permissionDTO})")
    @ApiOperation(value = "RemoveByPIMPERSON", tags = {"PIMEDUCATION" },  notes = "RemoveByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimeducations/{pimeducation_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimeducation_id") String pimeducation_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimeducationService.remove(pimeducation_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatchByPIMPERSON", tags = {"PIMEDUCATION" },  notes = "RemoveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimeducations/batch")
    public ResponseEntity<Boolean> removeBatchByPIMPERSON(@RequestBody List<String> ids) {
        pimeducationService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasPermission(#pimeducation_id,'Update',{'Sql',this.pimeducationMapping,#pimeducationdto})")
    @ApiOperation(value = "UpdateByPIMPERSON", tags = {"PIMEDUCATION" },  notes = "UpdateByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimeducations/{pimeducation_id}")
    @Transactional
    public ResponseEntity<PIMEDUCATIONDTO> updateByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimeducation_id") String pimeducation_id, @RequestBody PIMEDUCATIONDTO pimeducationdto) {
        PIMEDUCATION domain = pimeducationMapping.toDomain(pimeducationdto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimeducationid(pimeducation_id);
		pimeducationService.update(domain);
        PIMEDUCATIONDTO dto = pimeducationMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatchByPIMPERSON", tags = {"PIMEDUCATION" },  notes = "UpdateBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimeducations/batch")
    public ResponseEntity<Boolean> updateBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMEDUCATIONDTO> pimeducationdtos) {
        List<PIMEDUCATION> domainlist=pimeducationMapping.toDomain(pimeducationdtos);
        for(PIMEDUCATION domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimeducationService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-FAZZSY-all')")
	@ApiOperation(value = "fetch教育信息（非A转正专用）ByPIMPERSON", tags = {"PIMEDUCATION" } ,notes = "fetch教育信息（非A转正专用）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimeducations/fetchfazzsy")
	public ResponseEntity<List<PIMEDUCATIONDTO>> fetchPIMEDUCATIONFAZZSYByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMEDUCATIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMEDUCATION> domains = pimeducationService.searchFAZZSY(context) ;
        List<PIMEDUCATIONDTO> list = pimeducationMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-FAZZSY-all')")
	@ApiOperation(value = "search教育信息（非A转正专用）ByPIMPERSON", tags = {"PIMEDUCATION" } ,notes = "search教育信息（非A转正专用）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimeducations/searchfazzsy")
	public ResponseEntity<Page<PIMEDUCATIONDTO>> searchPIMEDUCATIONFAZZSYByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMEDUCATIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMEDUCATION> domains = pimeducationService.searchFAZZSY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimeducationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-JLSS-all')")
	@ApiOperation(value = "fetch记录所属ByPIMPERSON", tags = {"PIMEDUCATION" } ,notes = "fetch记录所属ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimeducations/fetchjlss")
	public ResponseEntity<List<PIMEDUCATIONDTO>> fetchPIMEDUCATIONJLSSByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMEDUCATIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMEDUCATION> domains = pimeducationService.searchJLSS(context) ;
        List<PIMEDUCATIONDTO> list = pimeducationMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-JLSS-all')")
	@ApiOperation(value = "search记录所属ByPIMPERSON", tags = {"PIMEDUCATION" } ,notes = "search记录所属ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimeducations/searchjlss")
	public ResponseEntity<Page<PIMEDUCATIONDTO>> searchPIMEDUCATIONJLSSByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMEDUCATIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMEDUCATION> domains = pimeducationService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimeducationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-ZIZHU-all')")
	@ApiOperation(value = "fetch自助(教育信息)ByPIMPERSON", tags = {"PIMEDUCATION" } ,notes = "fetch自助(教育信息)ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimeducations/fetchzizhu")
	public ResponseEntity<List<PIMEDUCATIONDTO>> fetchPIMEDUCATIONZIZHUByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMEDUCATIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMEDUCATION> domains = pimeducationService.searchZIZHU(context) ;
        List<PIMEDUCATIONDTO> list = pimeducationMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-ZIZHU-all')")
	@ApiOperation(value = "search自助(教育信息)ByPIMPERSON", tags = {"PIMEDUCATION" } ,notes = "search自助(教育信息)ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimeducations/searchzizhu")
	public ResponseEntity<Page<PIMEDUCATIONDTO>> searchPIMEDUCATIONZIZHUByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMEDUCATIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMEDUCATION> domains = pimeducationService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimeducationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-ADMDYZG-all')")
	@ApiOperation(value = "fetch第一学历和最高学历（管理员）ByPIMPERSON", tags = {"PIMEDUCATION" } ,notes = "fetch第一学历和最高学历（管理员）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimeducations/fetchadmdyzg")
	public ResponseEntity<List<PIMEDUCATIONDTO>> fetchPIMEDUCATIONADMDYZGByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMEDUCATIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMEDUCATION> domains = pimeducationService.searchADMDYZG(context) ;
        List<PIMEDUCATIONDTO> list = pimeducationMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-ADMDYZG-all')")
	@ApiOperation(value = "search第一学历和最高学历（管理员）ByPIMPERSON", tags = {"PIMEDUCATION" } ,notes = "search第一学历和最高学历（管理员）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimeducations/searchadmdyzg")
	public ResponseEntity<Page<PIMEDUCATIONDTO>> searchPIMEDUCATIONADMDYZGByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMEDUCATIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMEDUCATION> domains = pimeducationService.searchADMDYZG(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimeducationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-PERSONAL-all')")
	@ApiOperation(value = "fetch记录所属（个人）ByPIMPERSON", tags = {"PIMEDUCATION" } ,notes = "fetch记录所属（个人）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimeducations/fetchpersonal")
	public ResponseEntity<List<PIMEDUCATIONDTO>> fetchPIMEDUCATIONPERSONALByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMEDUCATIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMEDUCATION> domains = pimeducationService.searchPERSONAL(context) ;
        List<PIMEDUCATIONDTO> list = pimeducationMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-PERSONAL-all')")
	@ApiOperation(value = "search记录所属（个人）ByPIMPERSON", tags = {"PIMEDUCATION" } ,notes = "search记录所属（个人）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimeducations/searchpersonal")
	public ResponseEntity<Page<PIMEDUCATIONDTO>> searchPIMEDUCATIONPERSONALByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMEDUCATIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMEDUCATION> domains = pimeducationService.searchPERSONAL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimeducationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-ADMSYSTEM-all')")
	@ApiOperation(value = "fetch记录所属（管理员）ByPIMPERSON", tags = {"PIMEDUCATION" } ,notes = "fetch记录所属（管理员）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimeducations/fetchadmsystem")
	public ResponseEntity<List<PIMEDUCATIONDTO>> fetchPIMEDUCATIONADMSYSTEMByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMEDUCATIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMEDUCATION> domains = pimeducationService.searchADMSYSTEM(context) ;
        List<PIMEDUCATIONDTO> list = pimeducationMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-ADMSYSTEM-all')")
	@ApiOperation(value = "search记录所属（管理员）ByPIMPERSON", tags = {"PIMEDUCATION" } ,notes = "search记录所属（管理员）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimeducations/searchadmsystem")
	public ResponseEntity<Page<PIMEDUCATIONDTO>> searchPIMEDUCATIONADMSYSTEMByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMEDUCATIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMEDUCATION> domains = pimeducationService.searchADMSYSTEM(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimeducationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPIMPERSON", tags = {"PIMEDUCATION" } ,notes = "fetchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimeducations/fetchdefault")
	public ResponseEntity<List<PIMEDUCATIONDTO>> fetchPIMEDUCATIONDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMEDUCATIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMEDUCATION> domains = pimeducationService.searchDefault(context) ;
        List<PIMEDUCATIONDTO> list = pimeducationMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPIMPERSON", tags = {"PIMEDUCATION" } ,notes = "searchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimeducations/searchdefault")
	public ResponseEntity<Page<PIMEDUCATIONDTO>> searchPIMEDUCATIONDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMEDUCATIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMEDUCATION> domains = pimeducationService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimeducationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-REP_EDU-all')")
	@ApiOperation(value = "fetch图表_学历分布统计ByPIMPERSON", tags = {"PIMEDUCATION" } ,notes = "fetch图表_学历分布统计ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimeducations/fetchrep_edu")
	public ResponseEntity<List<HashMap>> fetchPIMEDUCATIONREP_EDUByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMEDUCATIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<HashMap> domains = pimeducationService.searchREP_EDU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(domains.getContent());
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEDUCATION-REP_EDU-all')")
	@ApiOperation(value = "search图表_学历分布统计ByPIMPERSON", tags = {"PIMEDUCATION" } ,notes = "search图表_学历分布统计ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimeducations/searchrep_edu")
	public ResponseEntity<Page<HashMap>> searchPIMEDUCATIONREP_EDUByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMEDUCATIONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<HashMap> domains = pimeducationService.searchREP_EDU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(domains.getContent(), context.getPageable(), domains.getTotalElements()));
	}
}
