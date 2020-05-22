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
import cn.ibizlab.ehr.core.pim.domain.PIMPersonAbility;
import cn.ibizlab.ehr.core.pim.service.IPIMPersonAbilityService;
import cn.ibizlab.ehr.core.pim.filter.PIMPersonAbilitySearchContext;




@Slf4j
@Api(tags = {"PIMPersonAbility" })
@RestController("WebApi-pimpersonability")
@RequestMapping("")
public class PIMPersonAbilityResource {

    @Autowired
    private IPIMPersonAbilityService pimpersonabilityService;

    @Autowired
    @Lazy
    public PIMPersonAbilityMapping pimpersonabilityMapping;

    public PIMPersonAbilityDTO permissionDTO=new PIMPersonAbilityDTO();

    @PreAuthorize("hasPermission(#pimpersonability_id,'Update',{'Sql',this.pimpersonabilityMapping,#pimpersonabilitydto})")
    @ApiOperation(value = "Update", tags = {"PIMPersonAbility" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpersonabilities/{pimpersonability_id}")
    @Transactional
    public ResponseEntity<PIMPersonAbilityDTO> update(@PathVariable("pimpersonability_id") String pimpersonability_id, @RequestBody PIMPersonAbilityDTO pimpersonabilitydto) {
		PIMPersonAbility domain = pimpersonabilityMapping.toDomain(pimpersonabilitydto);
        domain.setPimpersonabilityid(pimpersonability_id);
		pimpersonabilityService.update(domain);
		PIMPersonAbilityDTO dto = pimpersonabilityMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMPersonAbility" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpersonabilities/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMPersonAbilityDTO> pimpersonabilitydtos) {
        pimpersonabilityService.updateBatch(pimpersonabilityMapping.toDomain(pimpersonabilitydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pimpersonability_id,'Remove',{'Sql',this.pimpersonabilityMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PIMPersonAbility" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpersonabilities/{pimpersonability_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimpersonability_id") String pimpersonability_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimpersonabilityService.remove(pimpersonability_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PIMPersonAbility" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpersonabilities/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimpersonabilityService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pimpersonability_id,'Get',{'Sql',this.pimpersonabilityMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PIMPersonAbility" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpersonabilities/{pimpersonability_id}")
    public ResponseEntity<PIMPersonAbilityDTO> get(@PathVariable("pimpersonability_id") String pimpersonability_id) {
        PIMPersonAbility domain = pimpersonabilityService.get(pimpersonability_id);
        PIMPersonAbilityDTO dto = pimpersonabilityMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPersonAbility-Save-all')")
    @ApiOperation(value = "Save", tags = {"PIMPersonAbility" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonabilities/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMPersonAbilityDTO pimpersonabilitydto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonabilityService.save(pimpersonabilityMapping.toDomain(pimpersonabilitydto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PIMPersonAbility" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonabilities/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMPersonAbilityDTO> pimpersonabilitydtos) {
        pimpersonabilityService.saveBatch(pimpersonabilityMapping.toDomain(pimpersonabilitydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPersonAbility-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PIMPersonAbility" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpersonabilities/getdraft")
    public ResponseEntity<PIMPersonAbilityDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonabilityMapping.toDto(pimpersonabilityService.getDraft(new PIMPersonAbility())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPersonAbility-InitData-all')")
    @ApiOperation(value = "初始化数据", tags = {"PIMPersonAbility" },  notes = "初始化数据")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonabilities/{pimpersonability_id}/initdata")
    @Transactional
    public ResponseEntity<PIMPersonAbilityDTO> initData(@PathVariable("pimpersonability_id") String pimpersonability_id, @RequestBody PIMPersonAbilityDTO pimpersonabilitydto) {
        PIMPersonAbility pimpersonability = pimpersonabilityMapping.toDomain(pimpersonabilitydto);
        pimpersonability = pimpersonabilityService.initData(pimpersonability);
        pimpersonabilitydto = pimpersonabilityMapping.toDto(pimpersonability);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonabilitydto);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pimpersonabilityMapping,#pimpersonabilitydto})")
    @ApiOperation(value = "Create", tags = {"PIMPersonAbility" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonabilities")
    @Transactional
    public ResponseEntity<PIMPersonAbilityDTO> create(@RequestBody PIMPersonAbilityDTO pimpersonabilitydto) {
        PIMPersonAbility domain = pimpersonabilityMapping.toDomain(pimpersonabilitydto);
		pimpersonabilityService.create(domain);
        PIMPersonAbilityDTO dto = pimpersonabilityMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"PIMPersonAbility" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonabilities/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMPersonAbilityDTO> pimpersonabilitydtos) {
        pimpersonabilityService.createBatch(pimpersonabilityMapping.toDomain(pimpersonabilitydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPersonAbility-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PIMPersonAbility" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonabilities/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMPersonAbilityDTO pimpersonabilitydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimpersonabilityService.checkKey(pimpersonabilityMapping.toDomain(pimpersonabilitydto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPersonAbility-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMPersonAbility" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpersonabilities/fetchdefault")
	public ResponseEntity<List<PIMPersonAbilityDTO>> fetchDefault(PIMPersonAbilitySearchContext context) {
        Page<PIMPersonAbility> domains = pimpersonabilityService.searchDefault(context) ;
        List<PIMPersonAbilityDTO> list = pimpersonabilityMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPersonAbility-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMPersonAbility" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpersonabilities/searchdefault")
	public ResponseEntity<Page<PIMPersonAbilityDTO>> searchDefault(@RequestBody PIMPersonAbilitySearchContext context) {
        Page<PIMPersonAbility> domains = pimpersonabilityService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonabilityMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    //@PreAuthorize("hasPermission(#pimpersonability_id,'Update',{'Sql',this.pimpersonabilityMapping,#pimpersonabilitydto})")
    @ApiOperation(value = "UpdateByPIMPERSON", tags = {"PIMPersonAbility" },  notes = "UpdateByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimpersonabilities/{pimpersonability_id}")
    @Transactional
    public ResponseEntity<PIMPersonAbilityDTO> updateByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimpersonability_id") String pimpersonability_id, @RequestBody PIMPersonAbilityDTO pimpersonabilitydto) {
        PIMPersonAbility domain = pimpersonabilityMapping.toDomain(pimpersonabilitydto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimpersonabilityid(pimpersonability_id);
		pimpersonabilityService.update(domain);
        PIMPersonAbilityDTO dto = pimpersonabilityMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatchByPIMPERSON", tags = {"PIMPersonAbility" },  notes = "UpdateBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimpersonabilities/batch")
    public ResponseEntity<Boolean> updateBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMPersonAbilityDTO> pimpersonabilitydtos) {
        List<PIMPersonAbility> domainlist=pimpersonabilityMapping.toDomain(pimpersonabilitydtos);
        for(PIMPersonAbility domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimpersonabilityService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasPermission(#pimpersonability_id,'Remove',{'Sql',this.pimpersonabilityMapping,this.permissionDTO})")
    @ApiOperation(value = "RemoveByPIMPERSON", tags = {"PIMPersonAbility" },  notes = "RemoveByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimpersonabilities/{pimpersonability_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimpersonability_id") String pimpersonability_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimpersonabilityService.remove(pimpersonability_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatchByPIMPERSON", tags = {"PIMPersonAbility" },  notes = "RemoveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimpersonabilities/batch")
    public ResponseEntity<Boolean> removeBatchByPIMPERSON(@RequestBody List<String> ids) {
        pimpersonabilityService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasPermission(#pimpersonability_id,'Get',{'Sql',this.pimpersonabilityMapping,this.permissionDTO})")
    @ApiOperation(value = "GetByPIMPERSON", tags = {"PIMPersonAbility" },  notes = "GetByPIMPERSON")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimpersonabilities/{pimpersonability_id}")
    public ResponseEntity<PIMPersonAbilityDTO> getByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimpersonability_id") String pimpersonability_id) {
        PIMPersonAbility domain = pimpersonabilityService.get(pimpersonability_id);
        PIMPersonAbilityDTO dto = pimpersonabilityMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPersonAbility-Save-all')")
    @ApiOperation(value = "SaveByPIMPERSON", tags = {"PIMPersonAbility" },  notes = "SaveByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpersonabilities/save")
    public ResponseEntity<Boolean> saveByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMPersonAbilityDTO pimpersonabilitydto) {
        PIMPersonAbility domain = pimpersonabilityMapping.toDomain(pimpersonabilitydto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonabilityService.save(domain));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatchByPIMPERSON", tags = {"PIMPersonAbility" },  notes = "SaveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpersonabilities/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMPersonAbilityDTO> pimpersonabilitydtos) {
        List<PIMPersonAbility> domainlist=pimpersonabilityMapping.toDomain(pimpersonabilitydtos);
        for(PIMPersonAbility domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimpersonabilityService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPersonAbility-GetDraft-all')")
    @ApiOperation(value = "GetDraftByPIMPERSON", tags = {"PIMPersonAbility" },  notes = "GetDraftByPIMPERSON")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimpersonabilities/getdraft")
    public ResponseEntity<PIMPersonAbilityDTO> getDraftByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id) {
        PIMPersonAbility domain = new PIMPersonAbility();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonabilityMapping.toDto(pimpersonabilityService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPersonAbility-InitData-all')")
    @ApiOperation(value = "初始化数据ByPIMPERSON", tags = {"PIMPersonAbility" },  notes = "初始化数据ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpersonabilities/{pimpersonabilitypimpersonabilityid}/initdata")
    @Transactional
    public ResponseEntity<PIMPersonAbilityDTO> initDataByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimpersonability_id") String pimpersonability_id, @RequestBody PIMPersonAbilityDTO pimpersonabilitydto) {
        PIMPersonAbility domain = pimpersonabilityMapping.toDomain(pimpersonabilitydto);
        domain.setPimpersonid(pimperson_id);
        domain = pimpersonabilityService.initData(domain) ;
        pimpersonabilitydto = pimpersonabilityMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonabilitydto);
    }

    //@PreAuthorize("hasPermission('','Create',{'Sql',this.pimpersonabilityMapping,#pimpersonabilitydto})")
    @ApiOperation(value = "CreateByPIMPERSON", tags = {"PIMPersonAbility" },  notes = "CreateByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpersonabilities")
    @Transactional
    public ResponseEntity<PIMPersonAbilityDTO> createByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMPersonAbilityDTO pimpersonabilitydto) {
        PIMPersonAbility domain = pimpersonabilityMapping.toDomain(pimpersonabilitydto);
        domain.setPimpersonid(pimperson_id);
		pimpersonabilityService.create(domain);
        PIMPersonAbilityDTO dto = pimpersonabilityMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatchByPIMPERSON", tags = {"PIMPersonAbility" },  notes = "createBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpersonabilities/batch")
    public ResponseEntity<Boolean> createBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMPersonAbilityDTO> pimpersonabilitydtos) {
        List<PIMPersonAbility> domainlist=pimpersonabilityMapping.toDomain(pimpersonabilitydtos);
        for(PIMPersonAbility domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimpersonabilityService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPersonAbility-CheckKey-all')")
    @ApiOperation(value = "CheckKeyByPIMPERSON", tags = {"PIMPersonAbility" },  notes = "CheckKeyByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpersonabilities/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMPersonAbilityDTO pimpersonabilitydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimpersonabilityService.checkKey(pimpersonabilityMapping.toDomain(pimpersonabilitydto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPersonAbility-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPIMPERSON", tags = {"PIMPersonAbility" } ,notes = "fetchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimpersonabilities/fetchdefault")
	public ResponseEntity<List<PIMPersonAbilityDTO>> fetchPIMPersonAbilityDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMPersonAbilitySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMPersonAbility> domains = pimpersonabilityService.searchDefault(context) ;
        List<PIMPersonAbilityDTO> list = pimpersonabilityMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPersonAbility-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPIMPERSON", tags = {"PIMPersonAbility" } ,notes = "searchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimpersonabilities/searchdefault")
	public ResponseEntity<Page<PIMPersonAbilityDTO>> searchPIMPersonAbilityDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMPersonAbilitySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMPersonAbility> domains = pimpersonabilityService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonabilityMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
