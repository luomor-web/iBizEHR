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
import cn.ibizlab.ehr.core.pim.domain.PimLanguageAbility;
import cn.ibizlab.ehr.core.pim.service.IPimLanguageAbilityService;
import cn.ibizlab.ehr.core.pim.filter.PimLanguageAbilitySearchContext;

@Slf4j
@Api(tags = {"PimLanguageAbility" })
@RestController("WebApi-pimlanguageability")
@RequestMapping("")
public class PimLanguageAbilityResource {

    @Autowired
    public IPimLanguageAbilityService pimlanguageabilityService;

    @Autowired
    @Lazy
    public PimLanguageAbilityMapping pimlanguageabilityMapping;

    @ApiOperation(value = "GetDraft", tags = {"PimLanguageAbility" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimlanguageabilities/getdraft")
    public ResponseEntity<PimLanguageAbilityDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimlanguageabilityMapping.toDto(pimlanguageabilityService.getDraft(new PimLanguageAbility())));
    }

    @PostAuthorize("hasPermission(this.pimlanguageabilityMapping.toDomain(returnObject.body),'ehr-PimLanguageAbility-Get')")
    @ApiOperation(value = "Get", tags = {"PimLanguageAbility" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimlanguageabilities/{pimlanguageability_id}")
    public ResponseEntity<PimLanguageAbilityDTO> get(@PathVariable("pimlanguageability_id") String pimlanguageability_id) {
        PimLanguageAbility domain = pimlanguageabilityService.get(pimlanguageability_id);
        PimLanguageAbilityDTO dto = pimlanguageabilityMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimLanguageAbility-CustRemove-all')")
    @ApiOperation(value = "员工删除数据", tags = {"PimLanguageAbility" },  notes = "员工删除数据")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimlanguageabilities/{pimlanguageability_id}/custremove")
    @Transactional
    public ResponseEntity<PimLanguageAbilityDTO> custRemove(@PathVariable("pimlanguageability_id") String pimlanguageability_id, @RequestBody PimLanguageAbilityDTO pimlanguageabilitydto) {
        PimLanguageAbility pimlanguageability = pimlanguageabilityMapping.toDomain(pimlanguageabilitydto);
        pimlanguageability.setPimlanguageabilityid(pimlanguageability_id);
        pimlanguageability = pimlanguageabilityService.custRemove(pimlanguageability);
        pimlanguageabilitydto = pimlanguageabilityMapping.toDto(pimlanguageability);
        return ResponseEntity.status(HttpStatus.OK).body(pimlanguageabilitydto);
    }

    @PreAuthorize("hasPermission(this.pimlanguageabilityMapping.toDomain(#pimlanguageabilitydto),'ehr-PimLanguageAbility-Save')")
    @ApiOperation(value = "Save", tags = {"PimLanguageAbility" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimlanguageabilities/save")
    public ResponseEntity<Boolean> save(@RequestBody PimLanguageAbilityDTO pimlanguageabilitydto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimlanguageabilityService.save(pimlanguageabilityMapping.toDomain(pimlanguageabilitydto)));
    }

    @PreAuthorize("hasPermission(this.pimlanguageabilityMapping.toDomain(#pimlanguageabilitydtos),'ehr-PimLanguageAbility-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PimLanguageAbility" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimlanguageabilities/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimLanguageAbilityDTO> pimlanguageabilitydtos) {
        pimlanguageabilityService.saveBatch(pimlanguageabilityMapping.toDomain(pimlanguageabilitydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"PimLanguageAbility" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimlanguageabilities/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimLanguageAbilityDTO pimlanguageabilitydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimlanguageabilityService.checkKey(pimlanguageabilityMapping.toDomain(pimlanguageabilitydto)));
    }

    @PreAuthorize("hasPermission(this.pimlanguageabilityService.get(#pimlanguageability_id),'ehr-PimLanguageAbility-Remove')")
    @ApiOperation(value = "Remove", tags = {"PimLanguageAbility" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimlanguageabilities/{pimlanguageability_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimlanguageability_id") String pimlanguageability_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimlanguageabilityService.remove(pimlanguageability_id));
    }

    @PreAuthorize("hasPermission(this.pimlanguageabilityService.getPimlanguageabilityByIds(#ids),'ehr-PimLanguageAbility-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PimLanguageAbility" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimlanguageabilities/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimlanguageabilityService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimlanguageabilityService.get(#pimlanguageability_id),'ehr-PimLanguageAbility-Update')")
    @ApiOperation(value = "Update", tags = {"PimLanguageAbility" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimlanguageabilities/{pimlanguageability_id}")
    @Transactional
    public ResponseEntity<PimLanguageAbilityDTO> update(@PathVariable("pimlanguageability_id") String pimlanguageability_id, @RequestBody PimLanguageAbilityDTO pimlanguageabilitydto) {
		PimLanguageAbility domain  = pimlanguageabilityMapping.toDomain(pimlanguageabilitydto);
        domain .setPimlanguageabilityid(pimlanguageability_id);
		pimlanguageabilityService.update(domain );
		PimLanguageAbilityDTO dto = pimlanguageabilityMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimlanguageabilityService.getPimlanguageabilityByEntities(this.pimlanguageabilityMapping.toDomain(#pimlanguageabilitydtos)),'ehr-PimLanguageAbility-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PimLanguageAbility" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimlanguageabilities/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimLanguageAbilityDTO> pimlanguageabilitydtos) {
        pimlanguageabilityService.updateBatch(pimlanguageabilityMapping.toDomain(pimlanguageabilitydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimlanguageabilityMapping.toDomain(#pimlanguageabilitydto),'ehr-PimLanguageAbility-Create')")
    @ApiOperation(value = "Create", tags = {"PimLanguageAbility" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimlanguageabilities")
    @Transactional
    public ResponseEntity<PimLanguageAbilityDTO> create(@RequestBody PimLanguageAbilityDTO pimlanguageabilitydto) {
        PimLanguageAbility domain = pimlanguageabilityMapping.toDomain(pimlanguageabilitydto);
		pimlanguageabilityService.create(domain);
        PimLanguageAbilityDTO dto = pimlanguageabilityMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimlanguageabilityMapping.toDomain(#pimlanguageabilitydtos),'ehr-PimLanguageAbility-Create')")
    @ApiOperation(value = "createBatch", tags = {"PimLanguageAbility" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimlanguageabilities/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimLanguageAbilityDTO> pimlanguageabilitydtos) {
        pimlanguageabilityService.createBatch(pimlanguageabilityMapping.toDomain(pimlanguageabilitydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimLanguageAbility-JLSSGR-all')")
	@ApiOperation(value = "fetch记录所属（个人）", tags = {"PimLanguageAbility" } ,notes = "fetch记录所属（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pimlanguageabilities/fetchjlssgr")
	public ResponseEntity<List<PimLanguageAbilityDTO>> fetchJLSSGR(PimLanguageAbilitySearchContext context) {
        Page<PimLanguageAbility> domains = pimlanguageabilityService.searchJLSSGR(context) ;
        List<PimLanguageAbilityDTO> list = pimlanguageabilityMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimLanguageAbility-JLSSGR-all')")
	@ApiOperation(value = "search记录所属（个人）", tags = {"PimLanguageAbility" } ,notes = "search记录所属（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pimlanguageabilities/searchjlssgr")
	public ResponseEntity<Page<PimLanguageAbilityDTO>> searchJLSSGR(@RequestBody PimLanguageAbilitySearchContext context) {
        Page<PimLanguageAbility> domains = pimlanguageabilityService.searchJLSSGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimlanguageabilityMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimLanguageAbility-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PimLanguageAbility" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimlanguageabilities/fetchdefault")
	public ResponseEntity<List<PimLanguageAbilityDTO>> fetchDefault(PimLanguageAbilitySearchContext context) {
        Page<PimLanguageAbility> domains = pimlanguageabilityService.searchDefault(context) ;
        List<PimLanguageAbilityDTO> list = pimlanguageabilityMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimLanguageAbility-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PimLanguageAbility" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimlanguageabilities/searchdefault")
	public ResponseEntity<Page<PimLanguageAbilityDTO>> searchDefault(@RequestBody PimLanguageAbilitySearchContext context) {
        Page<PimLanguageAbility> domains = pimlanguageabilityService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimlanguageabilityMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimLanguageAbility-JLSS-all')")
	@ApiOperation(value = "fetch记录所属", tags = {"PimLanguageAbility" } ,notes = "fetch记录所属")
    @RequestMapping(method= RequestMethod.GET , value="/pimlanguageabilities/fetchjlss")
	public ResponseEntity<List<PimLanguageAbilityDTO>> fetchJLSS(PimLanguageAbilitySearchContext context) {
        Page<PimLanguageAbility> domains = pimlanguageabilityService.searchJLSS(context) ;
        List<PimLanguageAbilityDTO> list = pimlanguageabilityMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimLanguageAbility-JLSS-all')")
	@ApiOperation(value = "search记录所属", tags = {"PimLanguageAbility" } ,notes = "search记录所属")
    @RequestMapping(method= RequestMethod.POST , value="/pimlanguageabilities/searchjlss")
	public ResponseEntity<Page<PimLanguageAbilityDTO>> searchJLSS(@RequestBody PimLanguageAbilitySearchContext context) {
        Page<PimLanguageAbility> domains = pimlanguageabilityService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimlanguageabilityMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimLanguageAbility-ZIZHU-all')")
	@ApiOperation(value = "fetch自助(语言能力)", tags = {"PimLanguageAbility" } ,notes = "fetch自助(语言能力)")
    @RequestMapping(method= RequestMethod.GET , value="/pimlanguageabilities/fetchzizhu")
	public ResponseEntity<List<PimLanguageAbilityDTO>> fetchZIZHU(PimLanguageAbilitySearchContext context) {
        Page<PimLanguageAbility> domains = pimlanguageabilityService.searchZIZHU(context) ;
        List<PimLanguageAbilityDTO> list = pimlanguageabilityMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimLanguageAbility-ZIZHU-all')")
	@ApiOperation(value = "search自助(语言能力)", tags = {"PimLanguageAbility" } ,notes = "search自助(语言能力)")
    @RequestMapping(method= RequestMethod.POST , value="/pimlanguageabilities/searchzizhu")
	public ResponseEntity<Page<PimLanguageAbilityDTO>> searchZIZHU(@RequestBody PimLanguageAbilitySearchContext context) {
        Page<PimLanguageAbility> domains = pimlanguageabilityService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimlanguageabilityMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimLanguageAbility-JLSSGLY-all')")
	@ApiOperation(value = "fetch记录所属（管理员）", tags = {"PimLanguageAbility" } ,notes = "fetch记录所属（管理员）")
    @RequestMapping(method= RequestMethod.GET , value="/pimlanguageabilities/fetchjlssgly")
	public ResponseEntity<List<PimLanguageAbilityDTO>> fetchJLSSGLY(PimLanguageAbilitySearchContext context) {
        Page<PimLanguageAbility> domains = pimlanguageabilityService.searchJLSSGLY(context) ;
        List<PimLanguageAbilityDTO> list = pimlanguageabilityMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimLanguageAbility-JLSSGLY-all')")
	@ApiOperation(value = "search记录所属（管理员）", tags = {"PimLanguageAbility" } ,notes = "search记录所属（管理员）")
    @RequestMapping(method= RequestMethod.POST , value="/pimlanguageabilities/searchjlssgly")
	public ResponseEntity<Page<PimLanguageAbilityDTO>> searchJLSSGLY(@RequestBody PimLanguageAbilitySearchContext context) {
        Page<PimLanguageAbility> domains = pimlanguageabilityService.searchJLSSGLY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimlanguageabilityMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "GetDraftByPimPerson", tags = {"PimLanguageAbility" },  notes = "GetDraftByPimPerson")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimlanguageabilities/getdraft")
    public ResponseEntity<PimLanguageAbilityDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        PimLanguageAbility domain = new PimLanguageAbility();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimlanguageabilityMapping.toDto(pimlanguageabilityService.getDraft(domain)));
    }

    @PostAuthorize("hasPermission(this.pimlanguageabilityMapping.toDomain(returnObject.body),'ehr-PimLanguageAbility-Get')")
    @ApiOperation(value = "GetByPimPerson", tags = {"PimLanguageAbility" },  notes = "GetByPimPerson")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimlanguageabilities/{pimlanguageability_id}")
    public ResponseEntity<PimLanguageAbilityDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimlanguageability_id") String pimlanguageability_id) {
        PimLanguageAbility domain = pimlanguageabilityService.get(pimlanguageability_id);
        PimLanguageAbilityDTO dto = pimlanguageabilityMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimLanguageAbility-CustRemove-all')")
    @ApiOperation(value = "员工删除数据ByPimPerson", tags = {"PimLanguageAbility" },  notes = "员工删除数据ByPimPerson")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimlanguageabilities/{pimlanguageability_id}/custremove")
    @Transactional
    public ResponseEntity<PimLanguageAbilityDTO> custRemoveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimlanguageability_id") String pimlanguageability_id, @RequestBody PimLanguageAbilityDTO pimlanguageabilitydto) {
        PimLanguageAbility domain = pimlanguageabilityMapping.toDomain(pimlanguageabilitydto);
        domain.setPimpersonid(pimperson_id);
        domain = pimlanguageabilityService.custRemove(domain) ;
        pimlanguageabilitydto = pimlanguageabilityMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimlanguageabilitydto);
    }

    @PreAuthorize("hasPermission(this.pimlanguageabilityMapping.toDomain(#pimlanguageabilitydto),'ehr-PimLanguageAbility-Save')")
    @ApiOperation(value = "SaveByPimPerson", tags = {"PimLanguageAbility" },  notes = "SaveByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimlanguageabilities/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimLanguageAbilityDTO pimlanguageabilitydto) {
        PimLanguageAbility domain = pimlanguageabilityMapping.toDomain(pimlanguageabilitydto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimlanguageabilityService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimlanguageabilityMapping.toDomain(#pimlanguageabilitydtos),'ehr-PimLanguageAbility-Save')")
    @ApiOperation(value = "SaveBatchByPimPerson", tags = {"PimLanguageAbility" },  notes = "SaveBatchByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimlanguageabilities/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimLanguageAbilityDTO> pimlanguageabilitydtos) {
        List<PimLanguageAbility> domainlist=pimlanguageabilityMapping.toDomain(pimlanguageabilitydtos);
        for(PimLanguageAbility domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimlanguageabilityService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByPimPerson", tags = {"PimLanguageAbility" },  notes = "CheckKeyByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimlanguageabilities/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimLanguageAbilityDTO pimlanguageabilitydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimlanguageabilityService.checkKey(pimlanguageabilityMapping.toDomain(pimlanguageabilitydto)));
    }

    @PreAuthorize("hasPermission(this.pimlanguageabilityService.get(#pimlanguageability_id),'ehr-PimLanguageAbility-Remove')")
    @ApiOperation(value = "RemoveByPimPerson", tags = {"PimLanguageAbility" },  notes = "RemoveByPimPerson")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimlanguageabilities/{pimlanguageability_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimlanguageability_id") String pimlanguageability_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimlanguageabilityService.remove(pimlanguageability_id));
    }

    @PreAuthorize("hasPermission(this.pimlanguageabilityService.getPimlanguageabilityByIds(#ids),'ehr-PimLanguageAbility-Remove')")
    @ApiOperation(value = "RemoveBatchByPimPerson", tags = {"PimLanguageAbility" },  notes = "RemoveBatchByPimPerson")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimlanguageabilities/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        pimlanguageabilityService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimlanguageabilityService.get(#pimlanguageability_id),'ehr-PimLanguageAbility-Update')")
    @ApiOperation(value = "UpdateByPimPerson", tags = {"PimLanguageAbility" },  notes = "UpdateByPimPerson")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimlanguageabilities/{pimlanguageability_id}")
    @Transactional
    public ResponseEntity<PimLanguageAbilityDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimlanguageability_id") String pimlanguageability_id, @RequestBody PimLanguageAbilityDTO pimlanguageabilitydto) {
        PimLanguageAbility domain = pimlanguageabilityMapping.toDomain(pimlanguageabilitydto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimlanguageabilityid(pimlanguageability_id);
		pimlanguageabilityService.update(domain);
        PimLanguageAbilityDTO dto = pimlanguageabilityMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimlanguageabilityService.getPimlanguageabilityByEntities(this.pimlanguageabilityMapping.toDomain(#pimlanguageabilitydtos)),'ehr-PimLanguageAbility-Update')")
    @ApiOperation(value = "UpdateBatchByPimPerson", tags = {"PimLanguageAbility" },  notes = "UpdateBatchByPimPerson")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimlanguageabilities/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimLanguageAbilityDTO> pimlanguageabilitydtos) {
        List<PimLanguageAbility> domainlist=pimlanguageabilityMapping.toDomain(pimlanguageabilitydtos);
        for(PimLanguageAbility domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimlanguageabilityService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimlanguageabilityMapping.toDomain(#pimlanguageabilitydto),'ehr-PimLanguageAbility-Create')")
    @ApiOperation(value = "CreateByPimPerson", tags = {"PimLanguageAbility" },  notes = "CreateByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimlanguageabilities")
    @Transactional
    public ResponseEntity<PimLanguageAbilityDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimLanguageAbilityDTO pimlanguageabilitydto) {
        PimLanguageAbility domain = pimlanguageabilityMapping.toDomain(pimlanguageabilitydto);
        domain.setPimpersonid(pimperson_id);
		pimlanguageabilityService.create(domain);
        PimLanguageAbilityDTO dto = pimlanguageabilityMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimlanguageabilityMapping.toDomain(#pimlanguageabilitydtos),'ehr-PimLanguageAbility-Create')")
    @ApiOperation(value = "createBatchByPimPerson", tags = {"PimLanguageAbility" },  notes = "createBatchByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimlanguageabilities/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimLanguageAbilityDTO> pimlanguageabilitydtos) {
        List<PimLanguageAbility> domainlist=pimlanguageabilityMapping.toDomain(pimlanguageabilitydtos);
        for(PimLanguageAbility domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimlanguageabilityService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimLanguageAbility-JLSSGR-all')")
	@ApiOperation(value = "fetch记录所属（个人）ByPimPerson", tags = {"PimLanguageAbility" } ,notes = "fetch记录所属（个人）ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimlanguageabilities/fetchjlssgr")
	public ResponseEntity<List<PimLanguageAbilityDTO>> fetchPimLanguageAbilityJLSSGRByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimLanguageAbilitySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimLanguageAbility> domains = pimlanguageabilityService.searchJLSSGR(context) ;
        List<PimLanguageAbilityDTO> list = pimlanguageabilityMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimLanguageAbility-JLSSGR-all')")
	@ApiOperation(value = "search记录所属（个人）ByPimPerson", tags = {"PimLanguageAbility" } ,notes = "search记录所属（个人）ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimlanguageabilities/searchjlssgr")
	public ResponseEntity<Page<PimLanguageAbilityDTO>> searchPimLanguageAbilityJLSSGRByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimLanguageAbilitySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimLanguageAbility> domains = pimlanguageabilityService.searchJLSSGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimlanguageabilityMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimLanguageAbility-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPimPerson", tags = {"PimLanguageAbility" } ,notes = "fetchDEFAULTByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimlanguageabilities/fetchdefault")
	public ResponseEntity<List<PimLanguageAbilityDTO>> fetchPimLanguageAbilityDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimLanguageAbilitySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimLanguageAbility> domains = pimlanguageabilityService.searchDefault(context) ;
        List<PimLanguageAbilityDTO> list = pimlanguageabilityMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimLanguageAbility-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPimPerson", tags = {"PimLanguageAbility" } ,notes = "searchDEFAULTByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimlanguageabilities/searchdefault")
	public ResponseEntity<Page<PimLanguageAbilityDTO>> searchPimLanguageAbilityDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimLanguageAbilitySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimLanguageAbility> domains = pimlanguageabilityService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimlanguageabilityMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimLanguageAbility-JLSS-all')")
	@ApiOperation(value = "fetch记录所属ByPimPerson", tags = {"PimLanguageAbility" } ,notes = "fetch记录所属ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimlanguageabilities/fetchjlss")
	public ResponseEntity<List<PimLanguageAbilityDTO>> fetchPimLanguageAbilityJLSSByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimLanguageAbilitySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimLanguageAbility> domains = pimlanguageabilityService.searchJLSS(context) ;
        List<PimLanguageAbilityDTO> list = pimlanguageabilityMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimLanguageAbility-JLSS-all')")
	@ApiOperation(value = "search记录所属ByPimPerson", tags = {"PimLanguageAbility" } ,notes = "search记录所属ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimlanguageabilities/searchjlss")
	public ResponseEntity<Page<PimLanguageAbilityDTO>> searchPimLanguageAbilityJLSSByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimLanguageAbilitySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimLanguageAbility> domains = pimlanguageabilityService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimlanguageabilityMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimLanguageAbility-ZIZHU-all')")
	@ApiOperation(value = "fetch自助(语言能力)ByPimPerson", tags = {"PimLanguageAbility" } ,notes = "fetch自助(语言能力)ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimlanguageabilities/fetchzizhu")
	public ResponseEntity<List<PimLanguageAbilityDTO>> fetchPimLanguageAbilityZIZHUByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimLanguageAbilitySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimLanguageAbility> domains = pimlanguageabilityService.searchZIZHU(context) ;
        List<PimLanguageAbilityDTO> list = pimlanguageabilityMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimLanguageAbility-ZIZHU-all')")
	@ApiOperation(value = "search自助(语言能力)ByPimPerson", tags = {"PimLanguageAbility" } ,notes = "search自助(语言能力)ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimlanguageabilities/searchzizhu")
	public ResponseEntity<Page<PimLanguageAbilityDTO>> searchPimLanguageAbilityZIZHUByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimLanguageAbilitySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimLanguageAbility> domains = pimlanguageabilityService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimlanguageabilityMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimLanguageAbility-JLSSGLY-all')")
	@ApiOperation(value = "fetch记录所属（管理员）ByPimPerson", tags = {"PimLanguageAbility" } ,notes = "fetch记录所属（管理员）ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimlanguageabilities/fetchjlssgly")
	public ResponseEntity<List<PimLanguageAbilityDTO>> fetchPimLanguageAbilityJLSSGLYByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimLanguageAbilitySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimLanguageAbility> domains = pimlanguageabilityService.searchJLSSGLY(context) ;
        List<PimLanguageAbilityDTO> list = pimlanguageabilityMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimLanguageAbility-JLSSGLY-all')")
	@ApiOperation(value = "search记录所属（管理员）ByPimPerson", tags = {"PimLanguageAbility" } ,notes = "search记录所属（管理员）ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimlanguageabilities/searchjlssgly")
	public ResponseEntity<Page<PimLanguageAbilityDTO>> searchPimLanguageAbilityJLSSGLYByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimLanguageAbilitySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimLanguageAbility> domains = pimlanguageabilityService.searchJLSSGLY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimlanguageabilityMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

