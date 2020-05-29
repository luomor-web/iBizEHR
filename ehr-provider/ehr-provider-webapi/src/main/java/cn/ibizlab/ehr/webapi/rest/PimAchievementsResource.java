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
import cn.ibizlab.ehr.core.pim.domain.PimAchievements;
import cn.ibizlab.ehr.core.pim.service.IPimAchievementsService;
import cn.ibizlab.ehr.core.pim.filter.PimAchievementsSearchContext;

@Slf4j
@Api(tags = {"PimAchievements" })
@RestController("WebApi-pimachievements")
@RequestMapping("")
public class PimAchievementsResource {

    @Autowired
    public IPimAchievementsService pimachievementsService;

    @Autowired
    @Lazy
    public PimAchievementsMapping pimachievementsMapping;

    @PreAuthorize("hasPermission(this.pimachievementsService.get(#pimachievements_id),'ehr-PimAchievements-Update')")
    @ApiOperation(value = "Update", tags = {"PimAchievements" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimachievements/{pimachievements_id}")
    @Transactional
    public ResponseEntity<PimAchievementsDTO> update(@PathVariable("pimachievements_id") String pimachievements_id, @RequestBody PimAchievementsDTO pimachievementsdto) {
		PimAchievements domain  = pimachievementsMapping.toDomain(pimachievementsdto);
        domain .setPimachievementsid(pimachievements_id);
		pimachievementsService.update(domain );
		PimAchievementsDTO dto = pimachievementsMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimachievementsService.getPimachievementsByEntities(this.pimachievementsMapping.toDomain(#pimachievementsdtos)),'ehr-PimAchievements-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PimAchievements" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimachievements/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimAchievementsDTO> pimachievementsdtos) {
        pimachievementsService.updateBatch(pimachievementsMapping.toDomain(pimachievementsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimachievementsMapping.toDomain(#pimachievementsdto),'ehr-PimAchievements-Save')")
    @ApiOperation(value = "Save", tags = {"PimAchievements" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimachievements/save")
    public ResponseEntity<Boolean> save(@RequestBody PimAchievementsDTO pimachievementsdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimachievementsService.save(pimachievementsMapping.toDomain(pimachievementsdto)));
    }

    @PreAuthorize("hasPermission(this.pimachievementsMapping.toDomain(#pimachievementsdtos),'ehr-PimAchievements-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PimAchievements" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimachievements/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimAchievementsDTO> pimachievementsdtos) {
        pimachievementsService.saveBatch(pimachievementsMapping.toDomain(pimachievementsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"PimAchievements" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimachievements/getdraft")
    public ResponseEntity<PimAchievementsDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimachievementsMapping.toDto(pimachievementsService.getDraft(new PimAchievements())));
    }

    @PreAuthorize("hasPermission(this.pimachievementsService.get(#pimachievements_id),'ehr-PimAchievements-Remove')")
    @ApiOperation(value = "Remove", tags = {"PimAchievements" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimachievements/{pimachievements_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimachievements_id") String pimachievements_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimachievementsService.remove(pimachievements_id));
    }

    @PreAuthorize("hasPermission(this.pimachievementsService.getPimachievementsByIds(#ids),'ehr-PimAchievements-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PimAchievements" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimachievements/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimachievementsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimachievementsMapping.toDomain(returnObject.body),'ehr-PimAchievements-Get')")
    @ApiOperation(value = "Get", tags = {"PimAchievements" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimachievements/{pimachievements_id}")
    public ResponseEntity<PimAchievementsDTO> get(@PathVariable("pimachievements_id") String pimachievements_id) {
        PimAchievements domain = pimachievementsService.get(pimachievements_id);
        PimAchievementsDTO dto = pimachievementsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKey", tags = {"PimAchievements" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimachievements/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimAchievementsDTO pimachievementsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimachievementsService.checkKey(pimachievementsMapping.toDomain(pimachievementsdto)));
    }

    @PreAuthorize("hasPermission(this.pimachievementsMapping.toDomain(#pimachievementsdto),'ehr-PimAchievements-Create')")
    @ApiOperation(value = "Create", tags = {"PimAchievements" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimachievements")
    @Transactional
    public ResponseEntity<PimAchievementsDTO> create(@RequestBody PimAchievementsDTO pimachievementsdto) {
        PimAchievements domain = pimachievementsMapping.toDomain(pimachievementsdto);
		pimachievementsService.create(domain);
        PimAchievementsDTO dto = pimachievementsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimachievementsMapping.toDomain(#pimachievementsdtos),'ehr-PimAchievements-Create')")
    @ApiOperation(value = "createBatch", tags = {"PimAchievements" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimachievements/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimAchievementsDTO> pimachievementsdtos) {
        pimachievementsService.createBatch(pimachievementsMapping.toDomain(pimachievementsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimAchievements-JLSS-all')")
	@ApiOperation(value = "fetch记录所属和人员ID不符的", tags = {"PimAchievements" } ,notes = "fetch记录所属和人员ID不符的")
    @RequestMapping(method= RequestMethod.GET , value="/pimachievements/fetchjlss")
	public ResponseEntity<List<PimAchievementsDTO>> fetchJLSS(PimAchievementsSearchContext context) {
        Page<PimAchievements> domains = pimachievementsService.searchJLSS(context) ;
        List<PimAchievementsDTO> list = pimachievementsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimAchievements-JLSS-all')")
	@ApiOperation(value = "search记录所属和人员ID不符的", tags = {"PimAchievements" } ,notes = "search记录所属和人员ID不符的")
    @RequestMapping(method= RequestMethod.POST , value="/pimachievements/searchjlss")
	public ResponseEntity<Page<PimAchievementsDTO>> searchJLSS(@RequestBody PimAchievementsSearchContext context) {
        Page<PimAchievements> domains = pimachievementsService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimachievementsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimAchievements-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PimAchievements" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimachievements/fetchdefault")
	public ResponseEntity<List<PimAchievementsDTO>> fetchDefault(PimAchievementsSearchContext context) {
        Page<PimAchievements> domains = pimachievementsService.searchDefault(context) ;
        List<PimAchievementsDTO> list = pimachievementsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimAchievements-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PimAchievements" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimachievements/searchdefault")
	public ResponseEntity<Page<PimAchievementsDTO>> searchDefault(@RequestBody PimAchievementsSearchContext context) {
        Page<PimAchievements> domains = pimachievementsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimachievementsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimAchievements-ZIZHU-all')")
	@ApiOperation(value = "fetch自助(绩效信息)", tags = {"PimAchievements" } ,notes = "fetch自助(绩效信息)")
    @RequestMapping(method= RequestMethod.GET , value="/pimachievements/fetchzizhu")
	public ResponseEntity<List<PimAchievementsDTO>> fetchZIZHU(PimAchievementsSearchContext context) {
        Page<PimAchievements> domains = pimachievementsService.searchZIZHU(context) ;
        List<PimAchievementsDTO> list = pimachievementsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimAchievements-ZIZHU-all')")
	@ApiOperation(value = "search自助(绩效信息)", tags = {"PimAchievements" } ,notes = "search自助(绩效信息)")
    @RequestMapping(method= RequestMethod.POST , value="/pimachievements/searchzizhu")
	public ResponseEntity<Page<PimAchievementsDTO>> searchZIZHU(@RequestBody PimAchievementsSearchContext context) {
        Page<PimAchievements> domains = pimachievementsService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimachievementsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pimachievementsService.get(#pimachievements_id),'ehr-PimAchievements-Update')")
    @ApiOperation(value = "UpdateByPimPerson", tags = {"PimAchievements" },  notes = "UpdateByPimPerson")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimachievements/{pimachievements_id}")
    @Transactional
    public ResponseEntity<PimAchievementsDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimachievements_id") String pimachievements_id, @RequestBody PimAchievementsDTO pimachievementsdto) {
        PimAchievements domain = pimachievementsMapping.toDomain(pimachievementsdto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimachievementsid(pimachievements_id);
		pimachievementsService.update(domain);
        PimAchievementsDTO dto = pimachievementsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimachievementsService.getPimachievementsByEntities(this.pimachievementsMapping.toDomain(#pimachievementsdtos)),'ehr-PimAchievements-Update')")
    @ApiOperation(value = "UpdateBatchByPimPerson", tags = {"PimAchievements" },  notes = "UpdateBatchByPimPerson")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimachievements/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimAchievementsDTO> pimachievementsdtos) {
        List<PimAchievements> domainlist=pimachievementsMapping.toDomain(pimachievementsdtos);
        for(PimAchievements domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimachievementsService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimachievementsMapping.toDomain(#pimachievementsdto),'ehr-PimAchievements-Save')")
    @ApiOperation(value = "SaveByPimPerson", tags = {"PimAchievements" },  notes = "SaveByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimachievements/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimAchievementsDTO pimachievementsdto) {
        PimAchievements domain = pimachievementsMapping.toDomain(pimachievementsdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimachievementsService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimachievementsMapping.toDomain(#pimachievementsdtos),'ehr-PimAchievements-Save')")
    @ApiOperation(value = "SaveBatchByPimPerson", tags = {"PimAchievements" },  notes = "SaveBatchByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimachievements/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimAchievementsDTO> pimachievementsdtos) {
        List<PimAchievements> domainlist=pimachievementsMapping.toDomain(pimachievementsdtos);
        for(PimAchievements domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimachievementsService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPimPerson", tags = {"PimAchievements" },  notes = "GetDraftByPimPerson")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimachievements/getdraft")
    public ResponseEntity<PimAchievementsDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        PimAchievements domain = new PimAchievements();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimachievementsMapping.toDto(pimachievementsService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pimachievementsService.get(#pimachievements_id),'ehr-PimAchievements-Remove')")
    @ApiOperation(value = "RemoveByPimPerson", tags = {"PimAchievements" },  notes = "RemoveByPimPerson")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimachievements/{pimachievements_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimachievements_id") String pimachievements_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimachievementsService.remove(pimachievements_id));
    }

    @PreAuthorize("hasPermission(this.pimachievementsService.getPimachievementsByIds(#ids),'ehr-PimAchievements-Remove')")
    @ApiOperation(value = "RemoveBatchByPimPerson", tags = {"PimAchievements" },  notes = "RemoveBatchByPimPerson")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimachievements/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        pimachievementsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimachievementsMapping.toDomain(returnObject.body),'ehr-PimAchievements-Get')")
    @ApiOperation(value = "GetByPimPerson", tags = {"PimAchievements" },  notes = "GetByPimPerson")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimachievements/{pimachievements_id}")
    public ResponseEntity<PimAchievementsDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimachievements_id") String pimachievements_id) {
        PimAchievements domain = pimachievementsService.get(pimachievements_id);
        PimAchievementsDTO dto = pimachievementsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKeyByPimPerson", tags = {"PimAchievements" },  notes = "CheckKeyByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimachievements/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimAchievementsDTO pimachievementsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimachievementsService.checkKey(pimachievementsMapping.toDomain(pimachievementsdto)));
    }

    @PreAuthorize("hasPermission(this.pimachievementsMapping.toDomain(#pimachievementsdto),'ehr-PimAchievements-Create')")
    @ApiOperation(value = "CreateByPimPerson", tags = {"PimAchievements" },  notes = "CreateByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimachievements")
    @Transactional
    public ResponseEntity<PimAchievementsDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimAchievementsDTO pimachievementsdto) {
        PimAchievements domain = pimachievementsMapping.toDomain(pimachievementsdto);
        domain.setPimpersonid(pimperson_id);
		pimachievementsService.create(domain);
        PimAchievementsDTO dto = pimachievementsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimachievementsMapping.toDomain(#pimachievementsdtos),'ehr-PimAchievements-Create')")
    @ApiOperation(value = "createBatchByPimPerson", tags = {"PimAchievements" },  notes = "createBatchByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimachievements/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimAchievementsDTO> pimachievementsdtos) {
        List<PimAchievements> domainlist=pimachievementsMapping.toDomain(pimachievementsdtos);
        for(PimAchievements domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimachievementsService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimAchievements-JLSS-all')")
	@ApiOperation(value = "fetch记录所属和人员ID不符的ByPimPerson", tags = {"PimAchievements" } ,notes = "fetch记录所属和人员ID不符的ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimachievements/fetchjlss")
	public ResponseEntity<List<PimAchievementsDTO>> fetchPimAchievementsJLSSByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimAchievementsSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimAchievements> domains = pimachievementsService.searchJLSS(context) ;
        List<PimAchievementsDTO> list = pimachievementsMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimAchievements-JLSS-all')")
	@ApiOperation(value = "search记录所属和人员ID不符的ByPimPerson", tags = {"PimAchievements" } ,notes = "search记录所属和人员ID不符的ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimachievements/searchjlss")
	public ResponseEntity<Page<PimAchievementsDTO>> searchPimAchievementsJLSSByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimAchievementsSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimAchievements> domains = pimachievementsService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimachievementsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimAchievements-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPimPerson", tags = {"PimAchievements" } ,notes = "fetchDEFAULTByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimachievements/fetchdefault")
	public ResponseEntity<List<PimAchievementsDTO>> fetchPimAchievementsDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimAchievementsSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimAchievements> domains = pimachievementsService.searchDefault(context) ;
        List<PimAchievementsDTO> list = pimachievementsMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimAchievements-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPimPerson", tags = {"PimAchievements" } ,notes = "searchDEFAULTByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimachievements/searchdefault")
	public ResponseEntity<Page<PimAchievementsDTO>> searchPimAchievementsDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimAchievementsSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimAchievements> domains = pimachievementsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimachievementsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimAchievements-ZIZHU-all')")
	@ApiOperation(value = "fetch自助(绩效信息)ByPimPerson", tags = {"PimAchievements" } ,notes = "fetch自助(绩效信息)ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimachievements/fetchzizhu")
	public ResponseEntity<List<PimAchievementsDTO>> fetchPimAchievementsZIZHUByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimAchievementsSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimAchievements> domains = pimachievementsService.searchZIZHU(context) ;
        List<PimAchievementsDTO> list = pimachievementsMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimAchievements-ZIZHU-all')")
	@ApiOperation(value = "search自助(绩效信息)ByPimPerson", tags = {"PimAchievements" } ,notes = "search自助(绩效信息)ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimachievements/searchzizhu")
	public ResponseEntity<Page<PimAchievementsDTO>> searchPimAchievementsZIZHUByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimAchievementsSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimAchievements> domains = pimachievementsService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimachievementsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

