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
import cn.ibizlab.ehr.core.pim.domain.PimEducation;
import cn.ibizlab.ehr.core.pim.service.IPimEducationService;
import cn.ibizlab.ehr.core.pim.filter.PimEducationSearchContext;

@Slf4j
@Api(tags = {"教育信息" })
@RestController("WebApi-pimeducation")
@RequestMapping("")
public class PimEducationResource {

    @Autowired
    public IPimEducationService pimeducationService;

    @Autowired
    @Lazy
    public PimEducationMapping pimeducationMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEducation-CheckHighestEdu-all')")
    @ApiOperation(value = "检查最高学历", tags = {"教育信息" },  notes = "检查最高学历")
	@RequestMapping(method = RequestMethod.POST, value = "/pimeducations/{pimeducation_id}/checkhighestedu")
    @Transactional
    public ResponseEntity<PimEducationDTO> checkHighestEdu(@PathVariable("pimeducation_id") String pimeducation_id, @RequestBody PimEducationDTO pimeducationdto) {
        PimEducation pimeducation = pimeducationMapping.toDomain(pimeducationdto);
        pimeducation.setPimeducationid(pimeducation_id);
        pimeducation = pimeducationService.checkHighestEdu(pimeducation);
        pimeducationdto = pimeducationMapping.toDto(pimeducation);
        return ResponseEntity.status(HttpStatus.OK).body(pimeducationdto);
    }

    @PostAuthorize("hasPermission(this.pimeducationMapping.toDomain(returnObject.body),'ehr-PimEducation-Get')")
    @ApiOperation(value = "获取教育信息", tags = {"教育信息" },  notes = "获取教育信息")
	@RequestMapping(method = RequestMethod.GET, value = "/pimeducations/{pimeducation_id}")
    public ResponseEntity<PimEducationDTO> get(@PathVariable("pimeducation_id") String pimeducation_id) {
        PimEducation domain = pimeducationService.get(pimeducation_id);
        PimEducationDTO dto = pimeducationMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimeducationMapping.toDomain(#pimeducationdto),'ehr-PimEducation-Save')")
    @ApiOperation(value = "保存教育信息", tags = {"教育信息" },  notes = "保存教育信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimeducations/save")
    public ResponseEntity<Boolean> save(@RequestBody PimEducationDTO pimeducationdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimeducationService.save(pimeducationMapping.toDomain(pimeducationdto)));
    }

    @PreAuthorize("hasPermission(this.pimeducationMapping.toDomain(#pimeducationdtos),'ehr-PimEducation-Save')")
    @ApiOperation(value = "批量保存教育信息", tags = {"教育信息" },  notes = "批量保存教育信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimeducations/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimEducationDTO> pimeducationdtos) {
        pimeducationService.saveBatch(pimeducationMapping.toDomain(pimeducationdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimeducationMapping.toDomain(#pimeducationdto),'ehr-PimEducation-Create')")
    @ApiOperation(value = "新建教育信息", tags = {"教育信息" },  notes = "新建教育信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimeducations")
    @Transactional
    public ResponseEntity<PimEducationDTO> create(@RequestBody PimEducationDTO pimeducationdto) {
        PimEducation domain = pimeducationMapping.toDomain(pimeducationdto);
		pimeducationService.create(domain);
        PimEducationDTO dto = pimeducationMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimeducationMapping.toDomain(#pimeducationdtos),'ehr-PimEducation-Create')")
    @ApiOperation(value = "批量新建教育信息", tags = {"教育信息" },  notes = "批量新建教育信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimeducations/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimEducationDTO> pimeducationdtos) {
        pimeducationService.createBatch(pimeducationMapping.toDomain(pimeducationdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取教育信息草稿", tags = {"教育信息" },  notes = "获取教育信息草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimeducations/getdraft")
    public ResponseEntity<PimEducationDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimeducationMapping.toDto(pimeducationService.getDraft(new PimEducation())));
    }

    @ApiOperation(value = "检查教育信息", tags = {"教育信息" },  notes = "检查教育信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimeducations/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimEducationDTO pimeducationdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimeducationService.checkKey(pimeducationMapping.toDomain(pimeducationdto)));
    }

    @PreAuthorize("hasPermission(this.pimeducationService.get(#pimeducation_id),'ehr-PimEducation-Remove')")
    @ApiOperation(value = "删除教育信息", tags = {"教育信息" },  notes = "删除教育信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimeducations/{pimeducation_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimeducation_id") String pimeducation_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimeducationService.remove(pimeducation_id));
    }

    @PreAuthorize("hasPermission(this.pimeducationService.getPimeducationByIds(#ids),'ehr-PimEducation-Remove')")
    @ApiOperation(value = "批量删除教育信息", tags = {"教育信息" },  notes = "批量删除教育信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimeducations/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimeducationService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimeducationService.get(#pimeducation_id),'ehr-PimEducation-Update')")
    @ApiOperation(value = "更新教育信息", tags = {"教育信息" },  notes = "更新教育信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimeducations/{pimeducation_id}")
    @Transactional
    public ResponseEntity<PimEducationDTO> update(@PathVariable("pimeducation_id") String pimeducation_id, @RequestBody PimEducationDTO pimeducationdto) {
		PimEducation domain  = pimeducationMapping.toDomain(pimeducationdto);
        domain .setPimeducationid(pimeducation_id);
		pimeducationService.update(domain );
		PimEducationDTO dto = pimeducationMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimeducationService.getPimeducationByEntities(this.pimeducationMapping.toDomain(#pimeducationdtos)),'ehr-PimEducation-Update')")
    @ApiOperation(value = "批量更新教育信息", tags = {"教育信息" },  notes = "批量更新教育信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimeducations/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimEducationDTO> pimeducationdtos) {
        pimeducationService.updateBatch(pimeducationMapping.toDomain(pimeducationdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEducation-FAZZSY-all')")
	@ApiOperation(value = "获取教育信息（非A转正专用）", tags = {"教育信息" } ,notes = "获取教育信息（非A转正专用）")
    @RequestMapping(method= RequestMethod.GET , value="/pimeducations/fetchfazzsy")
	public ResponseEntity<List<PimEducationDTO>> fetchFAZZSY(PimEducationSearchContext context) {
        Page<PimEducation> domains = pimeducationService.searchFAZZSY(context) ;
        List<PimEducationDTO> list = pimeducationMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEducation-FAZZSY-all')")
	@ApiOperation(value = "查询教育信息（非A转正专用）", tags = {"教育信息" } ,notes = "查询教育信息（非A转正专用）")
    @RequestMapping(method= RequestMethod.POST , value="/pimeducations/searchfazzsy")
	public ResponseEntity<Page<PimEducationDTO>> searchFAZZSY(@RequestBody PimEducationSearchContext context) {
        Page<PimEducation> domains = pimeducationService.searchFAZZSY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimeducationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEducation-JLSS-all')")
	@ApiOperation(value = "获取记录所属", tags = {"教育信息" } ,notes = "获取记录所属")
    @RequestMapping(method= RequestMethod.GET , value="/pimeducations/fetchjlss")
	public ResponseEntity<List<PimEducationDTO>> fetchJLSS(PimEducationSearchContext context) {
        Page<PimEducation> domains = pimeducationService.searchJLSS(context) ;
        List<PimEducationDTO> list = pimeducationMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEducation-JLSS-all')")
	@ApiOperation(value = "查询记录所属", tags = {"教育信息" } ,notes = "查询记录所属")
    @RequestMapping(method= RequestMethod.POST , value="/pimeducations/searchjlss")
	public ResponseEntity<Page<PimEducationDTO>> searchJLSS(@RequestBody PimEducationSearchContext context) {
        Page<PimEducation> domains = pimeducationService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimeducationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEducation-ZIZHU-all')")
	@ApiOperation(value = "获取自助(教育信息)", tags = {"教育信息" } ,notes = "获取自助(教育信息)")
    @RequestMapping(method= RequestMethod.GET , value="/pimeducations/fetchzizhu")
	public ResponseEntity<List<PimEducationDTO>> fetchZIZHU(PimEducationSearchContext context) {
        Page<PimEducation> domains = pimeducationService.searchZIZHU(context) ;
        List<PimEducationDTO> list = pimeducationMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEducation-ZIZHU-all')")
	@ApiOperation(value = "查询自助(教育信息)", tags = {"教育信息" } ,notes = "查询自助(教育信息)")
    @RequestMapping(method= RequestMethod.POST , value="/pimeducations/searchzizhu")
	public ResponseEntity<Page<PimEducationDTO>> searchZIZHU(@RequestBody PimEducationSearchContext context) {
        Page<PimEducation> domains = pimeducationService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimeducationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEducation-ADMDYZG-all')")
	@ApiOperation(value = "获取第一学历和最高学历（管理员）", tags = {"教育信息" } ,notes = "获取第一学历和最高学历（管理员）")
    @RequestMapping(method= RequestMethod.GET , value="/pimeducations/fetchadmdyzg")
	public ResponseEntity<List<PimEducationDTO>> fetchADMDYZG(PimEducationSearchContext context) {
        Page<PimEducation> domains = pimeducationService.searchADMDYZG(context) ;
        List<PimEducationDTO> list = pimeducationMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEducation-ADMDYZG-all')")
	@ApiOperation(value = "查询第一学历和最高学历（管理员）", tags = {"教育信息" } ,notes = "查询第一学历和最高学历（管理员）")
    @RequestMapping(method= RequestMethod.POST , value="/pimeducations/searchadmdyzg")
	public ResponseEntity<Page<PimEducationDTO>> searchADMDYZG(@RequestBody PimEducationSearchContext context) {
        Page<PimEducation> domains = pimeducationService.searchADMDYZG(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimeducationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEducation-PERSONAL-all')")
	@ApiOperation(value = "获取记录所属（个人）", tags = {"教育信息" } ,notes = "获取记录所属（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pimeducations/fetchpersonal")
	public ResponseEntity<List<PimEducationDTO>> fetchPERSONAL(PimEducationSearchContext context) {
        Page<PimEducation> domains = pimeducationService.searchPERSONAL(context) ;
        List<PimEducationDTO> list = pimeducationMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEducation-PERSONAL-all')")
	@ApiOperation(value = "查询记录所属（个人）", tags = {"教育信息" } ,notes = "查询记录所属（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pimeducations/searchpersonal")
	public ResponseEntity<Page<PimEducationDTO>> searchPERSONAL(@RequestBody PimEducationSearchContext context) {
        Page<PimEducation> domains = pimeducationService.searchPERSONAL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimeducationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEducation-ADMSYSTEM-all')")
	@ApiOperation(value = "获取记录所属（管理员）", tags = {"教育信息" } ,notes = "获取记录所属（管理员）")
    @RequestMapping(method= RequestMethod.GET , value="/pimeducations/fetchadmsystem")
	public ResponseEntity<List<PimEducationDTO>> fetchADMSYSTEM(PimEducationSearchContext context) {
        Page<PimEducation> domains = pimeducationService.searchADMSYSTEM(context) ;
        List<PimEducationDTO> list = pimeducationMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEducation-ADMSYSTEM-all')")
	@ApiOperation(value = "查询记录所属（管理员）", tags = {"教育信息" } ,notes = "查询记录所属（管理员）")
    @RequestMapping(method= RequestMethod.POST , value="/pimeducations/searchadmsystem")
	public ResponseEntity<Page<PimEducationDTO>> searchADMSYSTEM(@RequestBody PimEducationSearchContext context) {
        Page<PimEducation> domains = pimeducationService.searchADMSYSTEM(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimeducationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEducation-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"教育信息" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimeducations/fetchdefault")
	public ResponseEntity<List<PimEducationDTO>> fetchDefault(PimEducationSearchContext context) {
        Page<PimEducation> domains = pimeducationService.searchDefault(context) ;
        List<PimEducationDTO> list = pimeducationMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEducation-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"教育信息" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimeducations/searchdefault")
	public ResponseEntity<Page<PimEducationDTO>> searchDefault(@RequestBody PimEducationSearchContext context) {
        Page<PimEducation> domains = pimeducationService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimeducationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEducation-REP_EDU-all')")
	@ApiOperation(value = "获取图表_学历分布统计", tags = {"教育信息" } ,notes = "获取图表_学历分布统计")
    @RequestMapping(method= RequestMethod.GET , value="/pimeducations/fetchrep_edu")
	public ResponseEntity<List<HashMap>> fetchREP_EDU(PimEducationSearchContext context) {
        Page<HashMap> domains = pimeducationService.searchREP_EDU(context) ;
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(domains.getContent());
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEducation-REP_EDU-all')")
	@ApiOperation(value = "查询图表_学历分布统计", tags = {"教育信息" } ,notes = "查询图表_学历分布统计")
    @RequestMapping(method= RequestMethod.POST , value="/pimeducations/searchrep_edu")
	public ResponseEntity<Page<HashMap>> searchREP_EDU(@RequestBody PimEducationSearchContext context) {
        Page<HashMap> domains = pimeducationService.searchREP_EDU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(domains.getContent(), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEducation-CheckHighestEdu-all')")
    @ApiOperation(value = "根据人员信息教育信息", tags = {"教育信息" },  notes = "根据人员信息教育信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimeducations/{pimeducation_id}/checkhighestedu")
    @Transactional
    public ResponseEntity<PimEducationDTO> checkHighestEduByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimeducation_id") String pimeducation_id, @RequestBody PimEducationDTO pimeducationdto) {
        PimEducation domain = pimeducationMapping.toDomain(pimeducationdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimeducationService.checkHighestEdu(domain) ;
        pimeducationdto = pimeducationMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimeducationdto);
    }

    @PostAuthorize("hasPermission(this.pimeducationMapping.toDomain(returnObject.body),'ehr-PimEducation-Get')")
    @ApiOperation(value = "根据人员信息获取教育信息", tags = {"教育信息" },  notes = "根据人员信息获取教育信息")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimeducations/{pimeducation_id}")
    public ResponseEntity<PimEducationDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimeducation_id") String pimeducation_id) {
        PimEducation domain = pimeducationService.get(pimeducation_id);
        PimEducationDTO dto = pimeducationMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimeducationMapping.toDomain(#pimeducationdto),'ehr-PimEducation-Save')")
    @ApiOperation(value = "根据人员信息保存教育信息", tags = {"教育信息" },  notes = "根据人员信息保存教育信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimeducations/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimEducationDTO pimeducationdto) {
        PimEducation domain = pimeducationMapping.toDomain(pimeducationdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimeducationService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimeducationMapping.toDomain(#pimeducationdtos),'ehr-PimEducation-Save')")
    @ApiOperation(value = "根据人员信息批量保存教育信息", tags = {"教育信息" },  notes = "根据人员信息批量保存教育信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimeducations/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimEducationDTO> pimeducationdtos) {
        List<PimEducation> domainlist=pimeducationMapping.toDomain(pimeducationdtos);
        for(PimEducation domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimeducationService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimeducationMapping.toDomain(#pimeducationdto),'ehr-PimEducation-Create')")
    @ApiOperation(value = "根据人员信息建立教育信息", tags = {"教育信息" },  notes = "根据人员信息建立教育信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimeducations")
    @Transactional
    public ResponseEntity<PimEducationDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimEducationDTO pimeducationdto) {
        PimEducation domain = pimeducationMapping.toDomain(pimeducationdto);
        domain.setPimpersonid(pimperson_id);
		pimeducationService.create(domain);
        PimEducationDTO dto = pimeducationMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimeducationMapping.toDomain(#pimeducationdtos),'ehr-PimEducation-Create')")
    @ApiOperation(value = "根据人员信息批量建立教育信息", tags = {"教育信息" },  notes = "根据人员信息批量建立教育信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimeducations/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimEducationDTO> pimeducationdtos) {
        List<PimEducation> domainlist=pimeducationMapping.toDomain(pimeducationdtos);
        for(PimEducation domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimeducationService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息获取教育信息草稿", tags = {"教育信息" },  notes = "根据人员信息获取教育信息草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimeducations/getdraft")
    public ResponseEntity<PimEducationDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        PimEducation domain = new PimEducation();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimeducationMapping.toDto(pimeducationService.getDraft(domain)));
    }

    @ApiOperation(value = "根据人员信息检查教育信息", tags = {"教育信息" },  notes = "根据人员信息检查教育信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimeducations/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimEducationDTO pimeducationdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimeducationService.checkKey(pimeducationMapping.toDomain(pimeducationdto)));
    }

    @PreAuthorize("hasPermission(this.pimeducationService.get(#pimeducation_id),'ehr-PimEducation-Remove')")
    @ApiOperation(value = "根据人员信息删除教育信息", tags = {"教育信息" },  notes = "根据人员信息删除教育信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimeducations/{pimeducation_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimeducation_id") String pimeducation_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimeducationService.remove(pimeducation_id));
    }

    @PreAuthorize("hasPermission(this.pimeducationService.getPimeducationByIds(#ids),'ehr-PimEducation-Remove')")
    @ApiOperation(value = "根据人员信息批量删除教育信息", tags = {"教育信息" },  notes = "根据人员信息批量删除教育信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimeducations/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        pimeducationService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimeducationService.get(#pimeducation_id),'ehr-PimEducation-Update')")
    @ApiOperation(value = "根据人员信息更新教育信息", tags = {"教育信息" },  notes = "根据人员信息更新教育信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimeducations/{pimeducation_id}")
    @Transactional
    public ResponseEntity<PimEducationDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimeducation_id") String pimeducation_id, @RequestBody PimEducationDTO pimeducationdto) {
        PimEducation domain = pimeducationMapping.toDomain(pimeducationdto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimeducationid(pimeducation_id);
		pimeducationService.update(domain);
        PimEducationDTO dto = pimeducationMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimeducationService.getPimeducationByEntities(this.pimeducationMapping.toDomain(#pimeducationdtos)),'ehr-PimEducation-Update')")
    @ApiOperation(value = "根据人员信息批量更新教育信息", tags = {"教育信息" },  notes = "根据人员信息批量更新教育信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimeducations/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimEducationDTO> pimeducationdtos) {
        List<PimEducation> domainlist=pimeducationMapping.toDomain(pimeducationdtos);
        for(PimEducation domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimeducationService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEducation-FAZZSY-all')")
	@ApiOperation(value = "根据人员信息获取教育信息（非A转正专用）", tags = {"教育信息" } ,notes = "根据人员信息获取教育信息（非A转正专用）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimeducations/fetchfazzsy")
	public ResponseEntity<List<PimEducationDTO>> fetchPimEducationFAZZSYByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimEducationSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimEducation> domains = pimeducationService.searchFAZZSY(context) ;
        List<PimEducationDTO> list = pimeducationMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEducation-FAZZSY-all')")
	@ApiOperation(value = "根据人员信息查询教育信息（非A转正专用）", tags = {"教育信息" } ,notes = "根据人员信息查询教育信息（非A转正专用）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimeducations/searchfazzsy")
	public ResponseEntity<Page<PimEducationDTO>> searchPimEducationFAZZSYByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimEducationSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimEducation> domains = pimeducationService.searchFAZZSY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimeducationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEducation-JLSS-all')")
	@ApiOperation(value = "根据人员信息获取记录所属", tags = {"教育信息" } ,notes = "根据人员信息获取记录所属")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimeducations/fetchjlss")
	public ResponseEntity<List<PimEducationDTO>> fetchPimEducationJLSSByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimEducationSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimEducation> domains = pimeducationService.searchJLSS(context) ;
        List<PimEducationDTO> list = pimeducationMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEducation-JLSS-all')")
	@ApiOperation(value = "根据人员信息查询记录所属", tags = {"教育信息" } ,notes = "根据人员信息查询记录所属")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimeducations/searchjlss")
	public ResponseEntity<Page<PimEducationDTO>> searchPimEducationJLSSByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimEducationSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimEducation> domains = pimeducationService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimeducationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEducation-ZIZHU-all')")
	@ApiOperation(value = "根据人员信息获取自助(教育信息)", tags = {"教育信息" } ,notes = "根据人员信息获取自助(教育信息)")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimeducations/fetchzizhu")
	public ResponseEntity<List<PimEducationDTO>> fetchPimEducationZIZHUByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimEducationSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimEducation> domains = pimeducationService.searchZIZHU(context) ;
        List<PimEducationDTO> list = pimeducationMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEducation-ZIZHU-all')")
	@ApiOperation(value = "根据人员信息查询自助(教育信息)", tags = {"教育信息" } ,notes = "根据人员信息查询自助(教育信息)")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimeducations/searchzizhu")
	public ResponseEntity<Page<PimEducationDTO>> searchPimEducationZIZHUByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimEducationSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimEducation> domains = pimeducationService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimeducationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEducation-ADMDYZG-all')")
	@ApiOperation(value = "根据人员信息获取第一学历和最高学历（管理员）", tags = {"教育信息" } ,notes = "根据人员信息获取第一学历和最高学历（管理员）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimeducations/fetchadmdyzg")
	public ResponseEntity<List<PimEducationDTO>> fetchPimEducationADMDYZGByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimEducationSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimEducation> domains = pimeducationService.searchADMDYZG(context) ;
        List<PimEducationDTO> list = pimeducationMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEducation-ADMDYZG-all')")
	@ApiOperation(value = "根据人员信息查询第一学历和最高学历（管理员）", tags = {"教育信息" } ,notes = "根据人员信息查询第一学历和最高学历（管理员）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimeducations/searchadmdyzg")
	public ResponseEntity<Page<PimEducationDTO>> searchPimEducationADMDYZGByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimEducationSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimEducation> domains = pimeducationService.searchADMDYZG(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimeducationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEducation-PERSONAL-all')")
	@ApiOperation(value = "根据人员信息获取记录所属（个人）", tags = {"教育信息" } ,notes = "根据人员信息获取记录所属（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimeducations/fetchpersonal")
	public ResponseEntity<List<PimEducationDTO>> fetchPimEducationPERSONALByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimEducationSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimEducation> domains = pimeducationService.searchPERSONAL(context) ;
        List<PimEducationDTO> list = pimeducationMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEducation-PERSONAL-all')")
	@ApiOperation(value = "根据人员信息查询记录所属（个人）", tags = {"教育信息" } ,notes = "根据人员信息查询记录所属（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimeducations/searchpersonal")
	public ResponseEntity<Page<PimEducationDTO>> searchPimEducationPERSONALByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimEducationSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimEducation> domains = pimeducationService.searchPERSONAL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimeducationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEducation-ADMSYSTEM-all')")
	@ApiOperation(value = "根据人员信息获取记录所属（管理员）", tags = {"教育信息" } ,notes = "根据人员信息获取记录所属（管理员）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimeducations/fetchadmsystem")
	public ResponseEntity<List<PimEducationDTO>> fetchPimEducationADMSYSTEMByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimEducationSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimEducation> domains = pimeducationService.searchADMSYSTEM(context) ;
        List<PimEducationDTO> list = pimeducationMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEducation-ADMSYSTEM-all')")
	@ApiOperation(value = "根据人员信息查询记录所属（管理员）", tags = {"教育信息" } ,notes = "根据人员信息查询记录所属（管理员）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimeducations/searchadmsystem")
	public ResponseEntity<Page<PimEducationDTO>> searchPimEducationADMSYSTEMByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimEducationSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimEducation> domains = pimeducationService.searchADMSYSTEM(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimeducationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEducation-Default-all')")
	@ApiOperation(value = "根据人员信息获取DEFAULT", tags = {"教育信息" } ,notes = "根据人员信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimeducations/fetchdefault")
	public ResponseEntity<List<PimEducationDTO>> fetchPimEducationDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimEducationSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimEducation> domains = pimeducationService.searchDefault(context) ;
        List<PimEducationDTO> list = pimeducationMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEducation-Default-all')")
	@ApiOperation(value = "根据人员信息查询DEFAULT", tags = {"教育信息" } ,notes = "根据人员信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimeducations/searchdefault")
	public ResponseEntity<Page<PimEducationDTO>> searchPimEducationDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimEducationSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimEducation> domains = pimeducationService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimeducationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEducation-REP_EDU-all')")
	@ApiOperation(value = "根据人员信息获取图表_学历分布统计", tags = {"教育信息" } ,notes = "根据人员信息获取图表_学历分布统计")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimeducations/fetchrep_edu")
	public ResponseEntity<List<HashMap>> fetchPimEducationREP_EDUByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimEducationSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<HashMap> domains = pimeducationService.searchREP_EDU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(domains.getContent());
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimEducation-REP_EDU-all')")
	@ApiOperation(value = "根据人员信息查询图表_学历分布统计", tags = {"教育信息" } ,notes = "根据人员信息查询图表_学历分布统计")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimeducations/searchrep_edu")
	public ResponseEntity<Page<HashMap>> searchPimEducationREP_EDUByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimEducationSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<HashMap> domains = pimeducationService.searchREP_EDU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(domains.getContent(), context.getPageable(), domains.getTotalElements()));
	}
}

