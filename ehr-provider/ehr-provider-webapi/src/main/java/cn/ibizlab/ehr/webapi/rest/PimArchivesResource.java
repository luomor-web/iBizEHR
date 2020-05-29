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
import cn.ibizlab.ehr.core.pim.domain.PimArchives;
import cn.ibizlab.ehr.core.pim.service.IPimArchivesService;
import cn.ibizlab.ehr.core.pim.filter.PimArchivesSearchContext;

@Slf4j
@Api(tags = {"PimArchives" })
@RestController("WebApi-pimarchives")
@RequestMapping("")
public class PimArchivesResource {

    @Autowired
    public IPimArchivesService pimarchivesService;

    @Autowired
    @Lazy
    public PimArchivesMapping pimarchivesMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchives-GetPersonOrg-all')")
    @ApiOperation(value = "获取员工组织", tags = {"PimArchives" },  notes = "获取员工组织")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarchives/{pimarchives_id}/getpersonorg")
    @Transactional
    public ResponseEntity<PimArchivesDTO> getPersonOrg(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PimArchivesDTO pimarchivesdto) {
        PimArchives pimarchives = pimarchivesMapping.toDomain(pimarchivesdto);
        pimarchives.setPimarchivesid(pimarchives_id);
        pimarchives = pimarchivesService.getPersonOrg(pimarchives);
        pimarchivesdto = pimarchivesMapping.toDto(pimarchives);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesdto);
    }

    @ApiOperation(value = "GetDraft", tags = {"PimArchives" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarchives/getdraft")
    public ResponseEntity<PimArchivesDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesMapping.toDto(pimarchivesService.getDraft(new PimArchives())));
    }

    @PreAuthorize("hasPermission(this.pimarchivesMapping.toDomain(#pimarchivesdto),'ehr-PimArchives-Save')")
    @ApiOperation(value = "Save", tags = {"PimArchives" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/save")
    public ResponseEntity<Boolean> save(@RequestBody PimArchivesDTO pimarchivesdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesService.save(pimarchivesMapping.toDomain(pimarchivesdto)));
    }

    @PreAuthorize("hasPermission(this.pimarchivesMapping.toDomain(#pimarchivesdtos),'ehr-PimArchives-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PimArchives" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimArchivesDTO> pimarchivesdtos) {
        pimarchivesService.saveBatch(pimarchivesMapping.toDomain(pimarchivesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimarchivesMapping.toDomain(returnObject.body),'ehr-PimArchives-Get')")
    @ApiOperation(value = "Get", tags = {"PimArchives" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarchives/{pimarchives_id}")
    public ResponseEntity<PimArchivesDTO> get(@PathVariable("pimarchives_id") String pimarchives_id) {
        PimArchives domain = pimarchivesService.get(pimarchives_id);
        PimArchivesDTO dto = pimarchivesMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchivesService.get(#pimarchives_id),'ehr-PimArchives-Update')")
    @ApiOperation(value = "Update", tags = {"PimArchives" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchives/{pimarchives_id}")
    @Transactional
    public ResponseEntity<PimArchivesDTO> update(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PimArchivesDTO pimarchivesdto) {
		PimArchives domain  = pimarchivesMapping.toDomain(pimarchivesdto);
        domain .setPimarchivesid(pimarchives_id);
		pimarchivesService.update(domain );
		PimArchivesDTO dto = pimarchivesMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchivesService.getPimarchivesByEntities(this.pimarchivesMapping.toDomain(#pimarchivesdtos)),'ehr-PimArchives-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PimArchives" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchives/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimArchivesDTO> pimarchivesdtos) {
        pimarchivesService.updateBatch(pimarchivesMapping.toDomain(pimarchivesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"PimArchives" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimArchivesDTO pimarchivesdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimarchivesService.checkKey(pimarchivesMapping.toDomain(pimarchivesdto)));
    }

    @PreAuthorize("hasPermission(this.pimarchivesMapping.toDomain(#pimarchivesdto),'ehr-PimArchives-Create')")
    @ApiOperation(value = "Create", tags = {"PimArchives" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives")
    @Transactional
    public ResponseEntity<PimArchivesDTO> create(@RequestBody PimArchivesDTO pimarchivesdto) {
        PimArchives domain = pimarchivesMapping.toDomain(pimarchivesdto);
		pimarchivesService.create(domain);
        PimArchivesDTO dto = pimarchivesMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchivesMapping.toDomain(#pimarchivesdtos),'ehr-PimArchives-Create')")
    @ApiOperation(value = "createBatch", tags = {"PimArchives" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimArchivesDTO> pimarchivesdtos) {
        pimarchivesService.createBatch(pimarchivesMapping.toDomain(pimarchivesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimarchivesService.get(#pimarchives_id),'ehr-PimArchives-Remove')")
    @ApiOperation(value = "Remove", tags = {"PimArchives" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchives/{pimarchives_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimarchives_id") String pimarchives_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimarchivesService.remove(pimarchives_id));
    }

    @PreAuthorize("hasPermission(this.pimarchivesService.getPimarchivesByIds(#ids),'ehr-PimArchives-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PimArchives" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchives/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimarchivesService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchives-EMLOYEENOFILE-all')")
	@ApiOperation(value = "fetch员工不在档档案", tags = {"PimArchives" } ,notes = "fetch员工不在档档案")
    @RequestMapping(method= RequestMethod.GET , value="/pimarchives/fetchemloyeenofile")
	public ResponseEntity<List<PimArchivesDTO>> fetchEMLOYEENOFILE(PimArchivesSearchContext context) {
        Page<PimArchives> domains = pimarchivesService.searchEMLOYEENOFILE(context) ;
        List<PimArchivesDTO> list = pimarchivesMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchives-EMLOYEENOFILE-all')")
	@ApiOperation(value = "search员工不在档档案", tags = {"PimArchives" } ,notes = "search员工不在档档案")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchives/searchemloyeenofile")
	public ResponseEntity<Page<PimArchivesDTO>> searchEMLOYEENOFILE(@RequestBody PimArchivesSearchContext context) {
        Page<PimArchives> domains = pimarchivesService.searchEMLOYEENOFILE(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchives-SysOrgIsSrfOrg-all')")
	@ApiOperation(value = "fetch管理单位等于当前登录人的单位（用于非员工在档数据查询）", tags = {"PimArchives" } ,notes = "fetch管理单位等于当前登录人的单位（用于非员工在档数据查询）")
    @RequestMapping(method= RequestMethod.GET , value="/pimarchives/fetchsysorgissrforg")
	public ResponseEntity<List<PimArchivesDTO>> fetchSysOrgIsSrfOrg(PimArchivesSearchContext context) {
        Page<PimArchives> domains = pimarchivesService.searchSysOrgIsSrfOrg(context) ;
        List<PimArchivesDTO> list = pimarchivesMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchives-SysOrgIsSrfOrg-all')")
	@ApiOperation(value = "search管理单位等于当前登录人的单位（用于非员工在档数据查询）", tags = {"PimArchives" } ,notes = "search管理单位等于当前登录人的单位（用于非员工在档数据查询）")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchives/searchsysorgissrforg")
	public ResponseEntity<Page<PimArchivesDTO>> searchSysOrgIsSrfOrg(@RequestBody PimArchivesSearchContext context) {
        Page<PimArchives> domains = pimarchivesService.searchSysOrgIsSrfOrg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchives-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PimArchives" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimarchives/fetchdefault")
	public ResponseEntity<List<PimArchivesDTO>> fetchDefault(PimArchivesSearchContext context) {
        Page<PimArchives> domains = pimarchivesService.searchDefault(context) ;
        List<PimArchivesDTO> list = pimarchivesMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchives-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PimArchives" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchives/searchdefault")
	public ResponseEntity<Page<PimArchivesDTO>> searchDefault(@RequestBody PimArchivesSearchContext context) {
        Page<PimArchives> domains = pimarchivesService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchives-JLSS-all')")
	@ApiOperation(value = "fetch记录所属和个人ID不符的", tags = {"PimArchives" } ,notes = "fetch记录所属和个人ID不符的")
    @RequestMapping(method= RequestMethod.GET , value="/pimarchives/fetchjlss")
	public ResponseEntity<List<PimArchivesDTO>> fetchJLSS(PimArchivesSearchContext context) {
        Page<PimArchives> domains = pimarchivesService.searchJLSS(context) ;
        List<PimArchivesDTO> list = pimarchivesMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchives-JLSS-all')")
	@ApiOperation(value = "search记录所属和个人ID不符的", tags = {"PimArchives" } ,notes = "search记录所属和个人ID不符的")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchives/searchjlss")
	public ResponseEntity<Page<PimArchivesDTO>> searchJLSS(@RequestBody PimArchivesSearchContext context) {
        Page<PimArchives> domains = pimarchivesService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchives-ZIZHU-all')")
	@ApiOperation(value = "fetch自助(档案信息)", tags = {"PimArchives" } ,notes = "fetch自助(档案信息)")
    @RequestMapping(method= RequestMethod.GET , value="/pimarchives/fetchzizhu")
	public ResponseEntity<List<PimArchivesDTO>> fetchZIZHU(PimArchivesSearchContext context) {
        Page<PimArchives> domains = pimarchivesService.searchZIZHU(context) ;
        List<PimArchivesDTO> list = pimarchivesMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchives-ZIZHU-all')")
	@ApiOperation(value = "search自助(档案信息)", tags = {"PimArchives" } ,notes = "search自助(档案信息)")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchives/searchzizhu")
	public ResponseEntity<Page<PimArchivesDTO>> searchZIZHU(@RequestBody PimArchivesSearchContext context) {
        Page<PimArchives> domains = pimarchivesService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchives-NOEMLOYEENOFILE-all')")
	@ApiOperation(value = "fetch非员工在档档案", tags = {"PimArchives" } ,notes = "fetch非员工在档档案")
    @RequestMapping(method= RequestMethod.GET , value="/pimarchives/fetchnoemloyeenofile")
	public ResponseEntity<List<PimArchivesDTO>> fetchNOEMLOYEENOFILE(PimArchivesSearchContext context) {
        Page<PimArchives> domains = pimarchivesService.searchNOEMLOYEENOFILE(context) ;
        List<PimArchivesDTO> list = pimarchivesMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchives-NOEMLOYEENOFILE-all')")
	@ApiOperation(value = "search非员工在档档案", tags = {"PimArchives" } ,notes = "search非员工在档档案")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchives/searchnoemloyeenofile")
	public ResponseEntity<Page<PimArchivesDTO>> searchNOEMLOYEENOFILE(@RequestBody PimArchivesSearchContext context) {
        Page<PimArchives> domains = pimarchivesService.searchNOEMLOYEENOFILE(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchives-PIMREADGJD-all')")
	@ApiOperation(value = "fetch档案信息组织查询", tags = {"PimArchives" } ,notes = "fetch档案信息组织查询")
    @RequestMapping(method= RequestMethod.GET , value="/pimarchives/fetchpimreadgjd")
	public ResponseEntity<List<PimArchivesDTO>> fetchPIMREADGJD(PimArchivesSearchContext context) {
        Page<PimArchives> domains = pimarchivesService.searchPIMREADGJD(context) ;
        List<PimArchivesDTO> list = pimarchivesMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchives-PIMREADGJD-all')")
	@ApiOperation(value = "search档案信息组织查询", tags = {"PimArchives" } ,notes = "search档案信息组织查询")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchives/searchpimreadgjd")
	public ResponseEntity<Page<PimArchivesDTO>> searchPIMREADGJD(@RequestBody PimArchivesSearchContext context) {
        Page<PimArchives> domains = pimarchivesService.searchPIMREADGJD(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchives-GetPersonOrg-all')")
    @ApiOperation(value = "获取员工组织ByPimPerson", tags = {"PimArchives" },  notes = "获取员工组织ByPimPerson")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/getpersonorg")
    @Transactional
    public ResponseEntity<PimArchivesDTO> getPersonOrgByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PimArchivesDTO pimarchivesdto) {
        PimArchives domain = pimarchivesMapping.toDomain(pimarchivesdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimarchivesService.getPersonOrg(domain) ;
        pimarchivesdto = pimarchivesMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesdto);
    }

    @ApiOperation(value = "GetDraftByPimPerson", tags = {"PimArchives" },  notes = "GetDraftByPimPerson")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimarchives/getdraft")
    public ResponseEntity<PimArchivesDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        PimArchives domain = new PimArchives();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesMapping.toDto(pimarchivesService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pimarchivesMapping.toDomain(#pimarchivesdto),'ehr-PimArchives-Save')")
    @ApiOperation(value = "SaveByPimPerson", tags = {"PimArchives" },  notes = "SaveByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimArchivesDTO pimarchivesdto) {
        PimArchives domain = pimarchivesMapping.toDomain(pimarchivesdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimarchivesMapping.toDomain(#pimarchivesdtos),'ehr-PimArchives-Save')")
    @ApiOperation(value = "SaveBatchByPimPerson", tags = {"PimArchives" },  notes = "SaveBatchByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimArchivesDTO> pimarchivesdtos) {
        List<PimArchives> domainlist=pimarchivesMapping.toDomain(pimarchivesdtos);
        for(PimArchives domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimarchivesService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimarchivesMapping.toDomain(returnObject.body),'ehr-PimArchives-Get')")
    @ApiOperation(value = "GetByPimPerson", tags = {"PimArchives" },  notes = "GetByPimPerson")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}")
    public ResponseEntity<PimArchivesDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id) {
        PimArchives domain = pimarchivesService.get(pimarchives_id);
        PimArchivesDTO dto = pimarchivesMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchivesService.get(#pimarchives_id),'ehr-PimArchives-Update')")
    @ApiOperation(value = "UpdateByPimPerson", tags = {"PimArchives" },  notes = "UpdateByPimPerson")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}")
    @Transactional
    public ResponseEntity<PimArchivesDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PimArchivesDTO pimarchivesdto) {
        PimArchives domain = pimarchivesMapping.toDomain(pimarchivesdto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimarchivesid(pimarchives_id);
		pimarchivesService.update(domain);
        PimArchivesDTO dto = pimarchivesMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchivesService.getPimarchivesByEntities(this.pimarchivesMapping.toDomain(#pimarchivesdtos)),'ehr-PimArchives-Update')")
    @ApiOperation(value = "UpdateBatchByPimPerson", tags = {"PimArchives" },  notes = "UpdateBatchByPimPerson")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimarchives/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimArchivesDTO> pimarchivesdtos) {
        List<PimArchives> domainlist=pimarchivesMapping.toDomain(pimarchivesdtos);
        for(PimArchives domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimarchivesService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByPimPerson", tags = {"PimArchives" },  notes = "CheckKeyByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimArchivesDTO pimarchivesdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimarchivesService.checkKey(pimarchivesMapping.toDomain(pimarchivesdto)));
    }

    @PreAuthorize("hasPermission(this.pimarchivesMapping.toDomain(#pimarchivesdto),'ehr-PimArchives-Create')")
    @ApiOperation(value = "CreateByPimPerson", tags = {"PimArchives" },  notes = "CreateByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives")
    @Transactional
    public ResponseEntity<PimArchivesDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimArchivesDTO pimarchivesdto) {
        PimArchives domain = pimarchivesMapping.toDomain(pimarchivesdto);
        domain.setPimpersonid(pimperson_id);
		pimarchivesService.create(domain);
        PimArchivesDTO dto = pimarchivesMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchivesMapping.toDomain(#pimarchivesdtos),'ehr-PimArchives-Create')")
    @ApiOperation(value = "createBatchByPimPerson", tags = {"PimArchives" },  notes = "createBatchByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimArchivesDTO> pimarchivesdtos) {
        List<PimArchives> domainlist=pimarchivesMapping.toDomain(pimarchivesdtos);
        for(PimArchives domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimarchivesService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimarchivesService.get(#pimarchives_id),'ehr-PimArchives-Remove')")
    @ApiOperation(value = "RemoveByPimPerson", tags = {"PimArchives" },  notes = "RemoveByPimPerson")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimarchivesService.remove(pimarchives_id));
    }

    @PreAuthorize("hasPermission(this.pimarchivesService.getPimarchivesByIds(#ids),'ehr-PimArchives-Remove')")
    @ApiOperation(value = "RemoveBatchByPimPerson", tags = {"PimArchives" },  notes = "RemoveBatchByPimPerson")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimarchives/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        pimarchivesService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchives-EMLOYEENOFILE-all')")
	@ApiOperation(value = "fetch员工不在档档案ByPimPerson", tags = {"PimArchives" } ,notes = "fetch员工不在档档案ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimarchives/fetchemloyeenofile")
	public ResponseEntity<List<PimArchivesDTO>> fetchPimArchivesEMLOYEENOFILEByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimArchivesSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimArchives> domains = pimarchivesService.searchEMLOYEENOFILE(context) ;
        List<PimArchivesDTO> list = pimarchivesMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchives-EMLOYEENOFILE-all')")
	@ApiOperation(value = "search员工不在档档案ByPimPerson", tags = {"PimArchives" } ,notes = "search员工不在档档案ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimarchives/searchemloyeenofile")
	public ResponseEntity<Page<PimArchivesDTO>> searchPimArchivesEMLOYEENOFILEByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimArchivesSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimArchives> domains = pimarchivesService.searchEMLOYEENOFILE(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchives-SysOrgIsSrfOrg-all')")
	@ApiOperation(value = "fetch管理单位等于当前登录人的单位（用于非员工在档数据查询）ByPimPerson", tags = {"PimArchives" } ,notes = "fetch管理单位等于当前登录人的单位（用于非员工在档数据查询）ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimarchives/fetchsysorgissrforg")
	public ResponseEntity<List<PimArchivesDTO>> fetchPimArchivesSysOrgIsSrfOrgByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimArchivesSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimArchives> domains = pimarchivesService.searchSysOrgIsSrfOrg(context) ;
        List<PimArchivesDTO> list = pimarchivesMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchives-SysOrgIsSrfOrg-all')")
	@ApiOperation(value = "search管理单位等于当前登录人的单位（用于非员工在档数据查询）ByPimPerson", tags = {"PimArchives" } ,notes = "search管理单位等于当前登录人的单位（用于非员工在档数据查询）ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimarchives/searchsysorgissrforg")
	public ResponseEntity<Page<PimArchivesDTO>> searchPimArchivesSysOrgIsSrfOrgByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimArchivesSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimArchives> domains = pimarchivesService.searchSysOrgIsSrfOrg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchives-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPimPerson", tags = {"PimArchives" } ,notes = "fetchDEFAULTByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimarchives/fetchdefault")
	public ResponseEntity<List<PimArchivesDTO>> fetchPimArchivesDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimArchivesSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimArchives> domains = pimarchivesService.searchDefault(context) ;
        List<PimArchivesDTO> list = pimarchivesMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchives-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPimPerson", tags = {"PimArchives" } ,notes = "searchDEFAULTByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimarchives/searchdefault")
	public ResponseEntity<Page<PimArchivesDTO>> searchPimArchivesDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimArchivesSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimArchives> domains = pimarchivesService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchives-JLSS-all')")
	@ApiOperation(value = "fetch记录所属和个人ID不符的ByPimPerson", tags = {"PimArchives" } ,notes = "fetch记录所属和个人ID不符的ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimarchives/fetchjlss")
	public ResponseEntity<List<PimArchivesDTO>> fetchPimArchivesJLSSByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimArchivesSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimArchives> domains = pimarchivesService.searchJLSS(context) ;
        List<PimArchivesDTO> list = pimarchivesMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchives-JLSS-all')")
	@ApiOperation(value = "search记录所属和个人ID不符的ByPimPerson", tags = {"PimArchives" } ,notes = "search记录所属和个人ID不符的ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimarchives/searchjlss")
	public ResponseEntity<Page<PimArchivesDTO>> searchPimArchivesJLSSByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimArchivesSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimArchives> domains = pimarchivesService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchives-ZIZHU-all')")
	@ApiOperation(value = "fetch自助(档案信息)ByPimPerson", tags = {"PimArchives" } ,notes = "fetch自助(档案信息)ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimarchives/fetchzizhu")
	public ResponseEntity<List<PimArchivesDTO>> fetchPimArchivesZIZHUByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimArchivesSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimArchives> domains = pimarchivesService.searchZIZHU(context) ;
        List<PimArchivesDTO> list = pimarchivesMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchives-ZIZHU-all')")
	@ApiOperation(value = "search自助(档案信息)ByPimPerson", tags = {"PimArchives" } ,notes = "search自助(档案信息)ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimarchives/searchzizhu")
	public ResponseEntity<Page<PimArchivesDTO>> searchPimArchivesZIZHUByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimArchivesSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimArchives> domains = pimarchivesService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchives-NOEMLOYEENOFILE-all')")
	@ApiOperation(value = "fetch非员工在档档案ByPimPerson", tags = {"PimArchives" } ,notes = "fetch非员工在档档案ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimarchives/fetchnoemloyeenofile")
	public ResponseEntity<List<PimArchivesDTO>> fetchPimArchivesNOEMLOYEENOFILEByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimArchivesSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimArchives> domains = pimarchivesService.searchNOEMLOYEENOFILE(context) ;
        List<PimArchivesDTO> list = pimarchivesMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchives-NOEMLOYEENOFILE-all')")
	@ApiOperation(value = "search非员工在档档案ByPimPerson", tags = {"PimArchives" } ,notes = "search非员工在档档案ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimarchives/searchnoemloyeenofile")
	public ResponseEntity<Page<PimArchivesDTO>> searchPimArchivesNOEMLOYEENOFILEByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimArchivesSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimArchives> domains = pimarchivesService.searchNOEMLOYEENOFILE(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchives-PIMREADGJD-all')")
	@ApiOperation(value = "fetch档案信息组织查询ByPimPerson", tags = {"PimArchives" } ,notes = "fetch档案信息组织查询ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimarchives/fetchpimreadgjd")
	public ResponseEntity<List<PimArchivesDTO>> fetchPimArchivesPIMREADGJDByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimArchivesSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimArchives> domains = pimarchivesService.searchPIMREADGJD(context) ;
        List<PimArchivesDTO> list = pimarchivesMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchives-PIMREADGJD-all')")
	@ApiOperation(value = "search档案信息组织查询ByPimPerson", tags = {"PimArchives" } ,notes = "search档案信息组织查询ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimarchives/searchpimreadgjd")
	public ResponseEntity<Page<PimArchivesDTO>> searchPimArchivesPIMREADGJDByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimArchivesSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimArchives> domains = pimarchivesService.searchPIMREADGJD(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

