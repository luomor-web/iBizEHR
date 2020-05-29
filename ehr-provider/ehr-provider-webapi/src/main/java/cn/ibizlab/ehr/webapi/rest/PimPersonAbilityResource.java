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
import cn.ibizlab.ehr.core.pim.domain.PimPersonAbility;
import cn.ibizlab.ehr.core.pim.service.IPimPersonAbilityService;
import cn.ibizlab.ehr.core.pim.filter.PimPersonAbilitySearchContext;

@Slf4j
@Api(tags = {"PimPersonAbility" })
@RestController("WebApi-pimpersonability")
@RequestMapping("")
public class PimPersonAbilityResource {

    @Autowired
    public IPimPersonAbilityService pimpersonabilityService;

    @Autowired
    @Lazy
    public PimPersonAbilityMapping pimpersonabilityMapping;

    @PreAuthorize("hasPermission(this.pimpersonabilityService.get(#pimpersonability_id),'ehr-PimPersonAbility-Update')")
    @ApiOperation(value = "Update", tags = {"PimPersonAbility" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpersonabilities/{pimpersonability_id}")
    @Transactional
    public ResponseEntity<PimPersonAbilityDTO> update(@PathVariable("pimpersonability_id") String pimpersonability_id, @RequestBody PimPersonAbilityDTO pimpersonabilitydto) {
		PimPersonAbility domain  = pimpersonabilityMapping.toDomain(pimpersonabilitydto);
        domain .setPimpersonabilityid(pimpersonability_id);
		pimpersonabilityService.update(domain );
		PimPersonAbilityDTO dto = pimpersonabilityMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimpersonabilityService.getPimpersonabilityByEntities(this.pimpersonabilityMapping.toDomain(#pimpersonabilitydtos)),'ehr-PimPersonAbility-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PimPersonAbility" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpersonabilities/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimPersonAbilityDTO> pimpersonabilitydtos) {
        pimpersonabilityService.updateBatch(pimpersonabilityMapping.toDomain(pimpersonabilitydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimpersonabilityService.get(#pimpersonability_id),'ehr-PimPersonAbility-Remove')")
    @ApiOperation(value = "Remove", tags = {"PimPersonAbility" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpersonabilities/{pimpersonability_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimpersonability_id") String pimpersonability_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimpersonabilityService.remove(pimpersonability_id));
    }

    @PreAuthorize("hasPermission(this.pimpersonabilityService.getPimpersonabilityByIds(#ids),'ehr-PimPersonAbility-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PimPersonAbility" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpersonabilities/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimpersonabilityService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimpersonabilityMapping.toDomain(returnObject.body),'ehr-PimPersonAbility-Get')")
    @ApiOperation(value = "Get", tags = {"PimPersonAbility" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpersonabilities/{pimpersonability_id}")
    public ResponseEntity<PimPersonAbilityDTO> get(@PathVariable("pimpersonability_id") String pimpersonability_id) {
        PimPersonAbility domain = pimpersonabilityService.get(pimpersonability_id);
        PimPersonAbilityDTO dto = pimpersonabilityMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimpersonabilityMapping.toDomain(#pimpersonabilitydto),'ehr-PimPersonAbility-Save')")
    @ApiOperation(value = "Save", tags = {"PimPersonAbility" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonabilities/save")
    public ResponseEntity<Boolean> save(@RequestBody PimPersonAbilityDTO pimpersonabilitydto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonabilityService.save(pimpersonabilityMapping.toDomain(pimpersonabilitydto)));
    }

    @PreAuthorize("hasPermission(this.pimpersonabilityMapping.toDomain(#pimpersonabilitydtos),'ehr-PimPersonAbility-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PimPersonAbility" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonabilities/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimPersonAbilityDTO> pimpersonabilitydtos) {
        pimpersonabilityService.saveBatch(pimpersonabilityMapping.toDomain(pimpersonabilitydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"PimPersonAbility" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpersonabilities/getdraft")
    public ResponseEntity<PimPersonAbilityDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonabilityMapping.toDto(pimpersonabilityService.getDraft(new PimPersonAbility())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPersonAbility-InitData-all')")
    @ApiOperation(value = "初始化数据", tags = {"PimPersonAbility" },  notes = "初始化数据")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonabilities/{pimpersonability_id}/initdata")
    @Transactional
    public ResponseEntity<PimPersonAbilityDTO> initData(@PathVariable("pimpersonability_id") String pimpersonability_id, @RequestBody PimPersonAbilityDTO pimpersonabilitydto) {
        PimPersonAbility pimpersonability = pimpersonabilityMapping.toDomain(pimpersonabilitydto);
        pimpersonability.setPimpersonabilityid(pimpersonability_id);
        pimpersonability = pimpersonabilityService.initData(pimpersonability);
        pimpersonabilitydto = pimpersonabilityMapping.toDto(pimpersonability);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonabilitydto);
    }

    @PreAuthorize("hasPermission(this.pimpersonabilityMapping.toDomain(#pimpersonabilitydto),'ehr-PimPersonAbility-Create')")
    @ApiOperation(value = "Create", tags = {"PimPersonAbility" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonabilities")
    @Transactional
    public ResponseEntity<PimPersonAbilityDTO> create(@RequestBody PimPersonAbilityDTO pimpersonabilitydto) {
        PimPersonAbility domain = pimpersonabilityMapping.toDomain(pimpersonabilitydto);
		pimpersonabilityService.create(domain);
        PimPersonAbilityDTO dto = pimpersonabilityMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimpersonabilityMapping.toDomain(#pimpersonabilitydtos),'ehr-PimPersonAbility-Create')")
    @ApiOperation(value = "createBatch", tags = {"PimPersonAbility" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonabilities/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimPersonAbilityDTO> pimpersonabilitydtos) {
        pimpersonabilityService.createBatch(pimpersonabilityMapping.toDomain(pimpersonabilitydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"PimPersonAbility" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonabilities/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimPersonAbilityDTO pimpersonabilitydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimpersonabilityService.checkKey(pimpersonabilityMapping.toDomain(pimpersonabilitydto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPersonAbility-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PimPersonAbility" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpersonabilities/fetchdefault")
	public ResponseEntity<List<PimPersonAbilityDTO>> fetchDefault(PimPersonAbilitySearchContext context) {
        Page<PimPersonAbility> domains = pimpersonabilityService.searchDefault(context) ;
        List<PimPersonAbilityDTO> list = pimpersonabilityMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPersonAbility-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PimPersonAbility" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpersonabilities/searchdefault")
	public ResponseEntity<Page<PimPersonAbilityDTO>> searchDefault(@RequestBody PimPersonAbilitySearchContext context) {
        Page<PimPersonAbility> domains = pimpersonabilityService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonabilityMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pimpersonabilityService.get(#pimpersonability_id),'ehr-PimPersonAbility-Update')")
    @ApiOperation(value = "UpdateByPimPerson", tags = {"PimPersonAbility" },  notes = "UpdateByPimPerson")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimpersonabilities/{pimpersonability_id}")
    @Transactional
    public ResponseEntity<PimPersonAbilityDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimpersonability_id") String pimpersonability_id, @RequestBody PimPersonAbilityDTO pimpersonabilitydto) {
        PimPersonAbility domain = pimpersonabilityMapping.toDomain(pimpersonabilitydto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimpersonabilityid(pimpersonability_id);
		pimpersonabilityService.update(domain);
        PimPersonAbilityDTO dto = pimpersonabilityMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimpersonabilityService.getPimpersonabilityByEntities(this.pimpersonabilityMapping.toDomain(#pimpersonabilitydtos)),'ehr-PimPersonAbility-Update')")
    @ApiOperation(value = "UpdateBatchByPimPerson", tags = {"PimPersonAbility" },  notes = "UpdateBatchByPimPerson")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimpersonabilities/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimPersonAbilityDTO> pimpersonabilitydtos) {
        List<PimPersonAbility> domainlist=pimpersonabilityMapping.toDomain(pimpersonabilitydtos);
        for(PimPersonAbility domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimpersonabilityService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimpersonabilityService.get(#pimpersonability_id),'ehr-PimPersonAbility-Remove')")
    @ApiOperation(value = "RemoveByPimPerson", tags = {"PimPersonAbility" },  notes = "RemoveByPimPerson")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimpersonabilities/{pimpersonability_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimpersonability_id") String pimpersonability_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimpersonabilityService.remove(pimpersonability_id));
    }

    @PreAuthorize("hasPermission(this.pimpersonabilityService.getPimpersonabilityByIds(#ids),'ehr-PimPersonAbility-Remove')")
    @ApiOperation(value = "RemoveBatchByPimPerson", tags = {"PimPersonAbility" },  notes = "RemoveBatchByPimPerson")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimpersonabilities/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        pimpersonabilityService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimpersonabilityMapping.toDomain(returnObject.body),'ehr-PimPersonAbility-Get')")
    @ApiOperation(value = "GetByPimPerson", tags = {"PimPersonAbility" },  notes = "GetByPimPerson")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimpersonabilities/{pimpersonability_id}")
    public ResponseEntity<PimPersonAbilityDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimpersonability_id") String pimpersonability_id) {
        PimPersonAbility domain = pimpersonabilityService.get(pimpersonability_id);
        PimPersonAbilityDTO dto = pimpersonabilityMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimpersonabilityMapping.toDomain(#pimpersonabilitydto),'ehr-PimPersonAbility-Save')")
    @ApiOperation(value = "SaveByPimPerson", tags = {"PimPersonAbility" },  notes = "SaveByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpersonabilities/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPersonAbilityDTO pimpersonabilitydto) {
        PimPersonAbility domain = pimpersonabilityMapping.toDomain(pimpersonabilitydto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonabilityService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimpersonabilityMapping.toDomain(#pimpersonabilitydtos),'ehr-PimPersonAbility-Save')")
    @ApiOperation(value = "SaveBatchByPimPerson", tags = {"PimPersonAbility" },  notes = "SaveBatchByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpersonabilities/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimPersonAbilityDTO> pimpersonabilitydtos) {
        List<PimPersonAbility> domainlist=pimpersonabilityMapping.toDomain(pimpersonabilitydtos);
        for(PimPersonAbility domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimpersonabilityService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPimPerson", tags = {"PimPersonAbility" },  notes = "GetDraftByPimPerson")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimpersonabilities/getdraft")
    public ResponseEntity<PimPersonAbilityDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        PimPersonAbility domain = new PimPersonAbility();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonabilityMapping.toDto(pimpersonabilityService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPersonAbility-InitData-all')")
    @ApiOperation(value = "初始化数据ByPimPerson", tags = {"PimPersonAbility" },  notes = "初始化数据ByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpersonabilities/{pimpersonability_id}/initdata")
    @Transactional
    public ResponseEntity<PimPersonAbilityDTO> initDataByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimpersonability_id") String pimpersonability_id, @RequestBody PimPersonAbilityDTO pimpersonabilitydto) {
        PimPersonAbility domain = pimpersonabilityMapping.toDomain(pimpersonabilitydto);
        domain.setPimpersonid(pimperson_id);
        domain = pimpersonabilityService.initData(domain) ;
        pimpersonabilitydto = pimpersonabilityMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonabilitydto);
    }

    @PreAuthorize("hasPermission(this.pimpersonabilityMapping.toDomain(#pimpersonabilitydto),'ehr-PimPersonAbility-Create')")
    @ApiOperation(value = "CreateByPimPerson", tags = {"PimPersonAbility" },  notes = "CreateByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpersonabilities")
    @Transactional
    public ResponseEntity<PimPersonAbilityDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPersonAbilityDTO pimpersonabilitydto) {
        PimPersonAbility domain = pimpersonabilityMapping.toDomain(pimpersonabilitydto);
        domain.setPimpersonid(pimperson_id);
		pimpersonabilityService.create(domain);
        PimPersonAbilityDTO dto = pimpersonabilityMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimpersonabilityMapping.toDomain(#pimpersonabilitydtos),'ehr-PimPersonAbility-Create')")
    @ApiOperation(value = "createBatchByPimPerson", tags = {"PimPersonAbility" },  notes = "createBatchByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpersonabilities/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimPersonAbilityDTO> pimpersonabilitydtos) {
        List<PimPersonAbility> domainlist=pimpersonabilityMapping.toDomain(pimpersonabilitydtos);
        for(PimPersonAbility domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimpersonabilityService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByPimPerson", tags = {"PimPersonAbility" },  notes = "CheckKeyByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpersonabilities/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPersonAbilityDTO pimpersonabilitydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimpersonabilityService.checkKey(pimpersonabilityMapping.toDomain(pimpersonabilitydto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPersonAbility-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPimPerson", tags = {"PimPersonAbility" } ,notes = "fetchDEFAULTByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimpersonabilities/fetchdefault")
	public ResponseEntity<List<PimPersonAbilityDTO>> fetchPimPersonAbilityDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimPersonAbilitySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimPersonAbility> domains = pimpersonabilityService.searchDefault(context) ;
        List<PimPersonAbilityDTO> list = pimpersonabilityMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPersonAbility-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPimPerson", tags = {"PimPersonAbility" } ,notes = "searchDEFAULTByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimpersonabilities/searchdefault")
	public ResponseEntity<Page<PimPersonAbilityDTO>> searchPimPersonAbilityDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPersonAbilitySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimPersonAbility> domains = pimpersonabilityService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonabilityMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

