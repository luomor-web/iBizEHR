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
@Api(tags = {"员工能力" })
@RestController("WebApi-pimpersonability")
@RequestMapping("")
public class PimPersonAbilityResource {

    @Autowired
    public IPimPersonAbilityService pimpersonabilityService;

    @Autowired
    @Lazy
    public PimPersonAbilityMapping pimpersonabilityMapping;

    @PreAuthorize("hasPermission(this.pimpersonabilityService.get(#pimpersonability_id),'ehr-PimPersonAbility-Update')")
    @ApiOperation(value = "更新员工能力", tags = {"员工能力" },  notes = "更新员工能力")
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
    @ApiOperation(value = "批量更新员工能力", tags = {"员工能力" },  notes = "批量更新员工能力")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpersonabilities/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimPersonAbilityDTO> pimpersonabilitydtos) {
        pimpersonabilityService.updateBatch(pimpersonabilityMapping.toDomain(pimpersonabilitydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimpersonabilityService.get(#pimpersonability_id),'ehr-PimPersonAbility-Remove')")
    @ApiOperation(value = "删除员工能力", tags = {"员工能力" },  notes = "删除员工能力")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpersonabilities/{pimpersonability_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimpersonability_id") String pimpersonability_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimpersonabilityService.remove(pimpersonability_id));
    }

    @PreAuthorize("hasPermission(this.pimpersonabilityService.getPimpersonabilityByIds(#ids),'ehr-PimPersonAbility-Remove')")
    @ApiOperation(value = "批量删除员工能力", tags = {"员工能力" },  notes = "批量删除员工能力")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpersonabilities/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimpersonabilityService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimpersonabilityMapping.toDomain(returnObject.body),'ehr-PimPersonAbility-Get')")
    @ApiOperation(value = "获取员工能力", tags = {"员工能力" },  notes = "获取员工能力")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpersonabilities/{pimpersonability_id}")
    public ResponseEntity<PimPersonAbilityDTO> get(@PathVariable("pimpersonability_id") String pimpersonability_id) {
        PimPersonAbility domain = pimpersonabilityService.get(pimpersonability_id);
        PimPersonAbilityDTO dto = pimpersonabilityMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimpersonabilityMapping.toDomain(#pimpersonabilitydto),'ehr-PimPersonAbility-Save')")
    @ApiOperation(value = "保存员工能力", tags = {"员工能力" },  notes = "保存员工能力")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonabilities/save")
    public ResponseEntity<Boolean> save(@RequestBody PimPersonAbilityDTO pimpersonabilitydto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonabilityService.save(pimpersonabilityMapping.toDomain(pimpersonabilitydto)));
    }

    @PreAuthorize("hasPermission(this.pimpersonabilityMapping.toDomain(#pimpersonabilitydtos),'ehr-PimPersonAbility-Save')")
    @ApiOperation(value = "批量保存员工能力", tags = {"员工能力" },  notes = "批量保存员工能力")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonabilities/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimPersonAbilityDTO> pimpersonabilitydtos) {
        pimpersonabilityService.saveBatch(pimpersonabilityMapping.toDomain(pimpersonabilitydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取员工能力草稿", tags = {"员工能力" },  notes = "获取员工能力草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpersonabilities/getdraft")
    public ResponseEntity<PimPersonAbilityDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonabilityMapping.toDto(pimpersonabilityService.getDraft(new PimPersonAbility())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPersonAbility-InitData-all')")
    @ApiOperation(value = "初始化数据", tags = {"员工能力" },  notes = "初始化数据")
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
    @ApiOperation(value = "新建员工能力", tags = {"员工能力" },  notes = "新建员工能力")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonabilities")
    @Transactional
    public ResponseEntity<PimPersonAbilityDTO> create(@RequestBody PimPersonAbilityDTO pimpersonabilitydto) {
        PimPersonAbility domain = pimpersonabilityMapping.toDomain(pimpersonabilitydto);
		pimpersonabilityService.create(domain);
        PimPersonAbilityDTO dto = pimpersonabilityMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimpersonabilityMapping.toDomain(#pimpersonabilitydtos),'ehr-PimPersonAbility-Create')")
    @ApiOperation(value = "批量新建员工能力", tags = {"员工能力" },  notes = "批量新建员工能力")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonabilities/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimPersonAbilityDTO> pimpersonabilitydtos) {
        pimpersonabilityService.createBatch(pimpersonabilityMapping.toDomain(pimpersonabilitydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查员工能力", tags = {"员工能力" },  notes = "检查员工能力")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonabilities/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimPersonAbilityDTO pimpersonabilitydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimpersonabilityService.checkKey(pimpersonabilityMapping.toDomain(pimpersonabilitydto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPersonAbility-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"员工能力" } ,notes = "获取DEFAULT")
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
	@ApiOperation(value = "查询DEFAULT", tags = {"员工能力" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpersonabilities/searchdefault")
	public ResponseEntity<Page<PimPersonAbilityDTO>> searchDefault(@RequestBody PimPersonAbilitySearchContext context) {
        Page<PimPersonAbility> domains = pimpersonabilityService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonabilityMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pimpersonabilityService.get(#pimpersonability_id),'ehr-PimPersonAbility-Update')")
    @ApiOperation(value = "根据人员信息更新员工能力", tags = {"员工能力" },  notes = "根据人员信息更新员工能力")
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
    @ApiOperation(value = "根据人员信息批量更新员工能力", tags = {"员工能力" },  notes = "根据人员信息批量更新员工能力")
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
    @ApiOperation(value = "根据人员信息删除员工能力", tags = {"员工能力" },  notes = "根据人员信息删除员工能力")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimpersonabilities/{pimpersonability_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimpersonability_id") String pimpersonability_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimpersonabilityService.remove(pimpersonability_id));
    }

    @PreAuthorize("hasPermission(this.pimpersonabilityService.getPimpersonabilityByIds(#ids),'ehr-PimPersonAbility-Remove')")
    @ApiOperation(value = "根据人员信息批量删除员工能力", tags = {"员工能力" },  notes = "根据人员信息批量删除员工能力")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimpersonabilities/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        pimpersonabilityService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimpersonabilityMapping.toDomain(returnObject.body),'ehr-PimPersonAbility-Get')")
    @ApiOperation(value = "根据人员信息获取员工能力", tags = {"员工能力" },  notes = "根据人员信息获取员工能力")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimpersonabilities/{pimpersonability_id}")
    public ResponseEntity<PimPersonAbilityDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimpersonability_id") String pimpersonability_id) {
        PimPersonAbility domain = pimpersonabilityService.get(pimpersonability_id);
        PimPersonAbilityDTO dto = pimpersonabilityMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimpersonabilityMapping.toDomain(#pimpersonabilitydto),'ehr-PimPersonAbility-Save')")
    @ApiOperation(value = "根据人员信息保存员工能力", tags = {"员工能力" },  notes = "根据人员信息保存员工能力")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpersonabilities/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPersonAbilityDTO pimpersonabilitydto) {
        PimPersonAbility domain = pimpersonabilityMapping.toDomain(pimpersonabilitydto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonabilityService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimpersonabilityMapping.toDomain(#pimpersonabilitydtos),'ehr-PimPersonAbility-Save')")
    @ApiOperation(value = "根据人员信息批量保存员工能力", tags = {"员工能力" },  notes = "根据人员信息批量保存员工能力")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpersonabilities/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimPersonAbilityDTO> pimpersonabilitydtos) {
        List<PimPersonAbility> domainlist=pimpersonabilityMapping.toDomain(pimpersonabilitydtos);
        for(PimPersonAbility domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimpersonabilityService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息获取员工能力草稿", tags = {"员工能力" },  notes = "根据人员信息获取员工能力草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimpersonabilities/getdraft")
    public ResponseEntity<PimPersonAbilityDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        PimPersonAbility domain = new PimPersonAbility();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonabilityMapping.toDto(pimpersonabilityService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPersonAbility-InitData-all')")
    @ApiOperation(value = "根据人员信息员工能力", tags = {"员工能力" },  notes = "根据人员信息员工能力")
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
    @ApiOperation(value = "根据人员信息建立员工能力", tags = {"员工能力" },  notes = "根据人员信息建立员工能力")
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
    @ApiOperation(value = "根据人员信息批量建立员工能力", tags = {"员工能力" },  notes = "根据人员信息批量建立员工能力")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpersonabilities/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimPersonAbilityDTO> pimpersonabilitydtos) {
        List<PimPersonAbility> domainlist=pimpersonabilityMapping.toDomain(pimpersonabilitydtos);
        for(PimPersonAbility domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimpersonabilityService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息检查员工能力", tags = {"员工能力" },  notes = "根据人员信息检查员工能力")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpersonabilities/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPersonAbilityDTO pimpersonabilitydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimpersonabilityService.checkKey(pimpersonabilityMapping.toDomain(pimpersonabilitydto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPersonAbility-Default-all')")
	@ApiOperation(value = "根据人员信息获取DEFAULT", tags = {"员工能力" } ,notes = "根据人员信息获取DEFAULT")
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
	@ApiOperation(value = "根据人员信息查询DEFAULT", tags = {"员工能力" } ,notes = "根据人员信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimpersonabilities/searchdefault")
	public ResponseEntity<Page<PimPersonAbilityDTO>> searchPimPersonAbilityDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPersonAbilitySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimPersonAbility> domains = pimpersonabilityService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonabilityMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

