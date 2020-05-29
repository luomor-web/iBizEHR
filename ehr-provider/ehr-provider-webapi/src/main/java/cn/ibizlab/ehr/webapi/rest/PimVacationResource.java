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
import cn.ibizlab.ehr.core.pim.domain.PimVacation;
import cn.ibizlab.ehr.core.pim.service.IPimVacationService;
import cn.ibizlab.ehr.core.pim.filter.PimVacationSearchContext;

@Slf4j
@Api(tags = {"休假信息" })
@RestController("WebApi-pimvacation")
@RequestMapping("")
public class PimVacationResource {

    @Autowired
    public IPimVacationService pimvacationService;

    @Autowired
    @Lazy
    public PimVacationMapping pimvacationMapping;

    @PreAuthorize("hasPermission(this.pimvacationService.get(#pimvacation_id),'ehr-PimVacation-Update')")
    @ApiOperation(value = "更新休假信息", tags = {"休假信息" },  notes = "更新休假信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimvacations/{pimvacation_id}")
    @Transactional
    public ResponseEntity<PimVacationDTO> update(@PathVariable("pimvacation_id") String pimvacation_id, @RequestBody PimVacationDTO pimvacationdto) {
		PimVacation domain  = pimvacationMapping.toDomain(pimvacationdto);
        domain .setPimvacationid(pimvacation_id);
		pimvacationService.update(domain );
		PimVacationDTO dto = pimvacationMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimvacationService.getPimvacationByEntities(this.pimvacationMapping.toDomain(#pimvacationdtos)),'ehr-PimVacation-Update')")
    @ApiOperation(value = "批量更新休假信息", tags = {"休假信息" },  notes = "批量更新休假信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimvacations/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimVacationDTO> pimvacationdtos) {
        pimvacationService.updateBatch(pimvacationMapping.toDomain(pimvacationdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimvacationService.get(#pimvacation_id),'ehr-PimVacation-Remove')")
    @ApiOperation(value = "删除休假信息", tags = {"休假信息" },  notes = "删除休假信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimvacations/{pimvacation_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimvacation_id") String pimvacation_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimvacationService.remove(pimvacation_id));
    }

    @PreAuthorize("hasPermission(this.pimvacationService.getPimvacationByIds(#ids),'ehr-PimVacation-Remove')")
    @ApiOperation(value = "批量删除休假信息", tags = {"休假信息" },  notes = "批量删除休假信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimvacations/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimvacationService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取休假信息草稿", tags = {"休假信息" },  notes = "获取休假信息草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimvacations/getdraft")
    public ResponseEntity<PimVacationDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimvacationMapping.toDto(pimvacationService.getDraft(new PimVacation())));
    }

    @PreAuthorize("hasPermission(this.pimvacationMapping.toDomain(#pimvacationdto),'ehr-PimVacation-Save')")
    @ApiOperation(value = "保存休假信息", tags = {"休假信息" },  notes = "保存休假信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimvacations/save")
    public ResponseEntity<Boolean> save(@RequestBody PimVacationDTO pimvacationdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimvacationService.save(pimvacationMapping.toDomain(pimvacationdto)));
    }

    @PreAuthorize("hasPermission(this.pimvacationMapping.toDomain(#pimvacationdtos),'ehr-PimVacation-Save')")
    @ApiOperation(value = "批量保存休假信息", tags = {"休假信息" },  notes = "批量保存休假信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimvacations/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimVacationDTO> pimvacationdtos) {
        pimvacationService.saveBatch(pimvacationMapping.toDomain(pimvacationdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimvacationMapping.toDomain(#pimvacationdto),'ehr-PimVacation-Create')")
    @ApiOperation(value = "新建休假信息", tags = {"休假信息" },  notes = "新建休假信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimvacations")
    @Transactional
    public ResponseEntity<PimVacationDTO> create(@RequestBody PimVacationDTO pimvacationdto) {
        PimVacation domain = pimvacationMapping.toDomain(pimvacationdto);
		pimvacationService.create(domain);
        PimVacationDTO dto = pimvacationMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimvacationMapping.toDomain(#pimvacationdtos),'ehr-PimVacation-Create')")
    @ApiOperation(value = "批量新建休假信息", tags = {"休假信息" },  notes = "批量新建休假信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimvacations/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimVacationDTO> pimvacationdtos) {
        pimvacationService.createBatch(pimvacationMapping.toDomain(pimvacationdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查休假信息", tags = {"休假信息" },  notes = "检查休假信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimvacations/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimVacationDTO pimvacationdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimvacationService.checkKey(pimvacationMapping.toDomain(pimvacationdto)));
    }

    @PostAuthorize("hasPermission(this.pimvacationMapping.toDomain(returnObject.body),'ehr-PimVacation-Get')")
    @ApiOperation(value = "获取休假信息", tags = {"休假信息" },  notes = "获取休假信息")
	@RequestMapping(method = RequestMethod.GET, value = "/pimvacations/{pimvacation_id}")
    public ResponseEntity<PimVacationDTO> get(@PathVariable("pimvacation_id") String pimvacation_id) {
        PimVacation domain = pimvacationService.get(pimvacation_id);
        PimVacationDTO dto = pimvacationMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimVacation-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"休假信息" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimvacations/fetchdefault")
	public ResponseEntity<List<PimVacationDTO>> fetchDefault(PimVacationSearchContext context) {
        Page<PimVacation> domains = pimvacationService.searchDefault(context) ;
        List<PimVacationDTO> list = pimvacationMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimVacation-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"休假信息" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimvacations/searchdefault")
	public ResponseEntity<Page<PimVacationDTO>> searchDefault(@RequestBody PimVacationSearchContext context) {
        Page<PimVacation> domains = pimvacationService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimvacationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pimvacationService.get(#pimvacation_id),'ehr-PimVacation-Update')")
    @ApiOperation(value = "根据人员信息更新休假信息", tags = {"休假信息" },  notes = "根据人员信息更新休假信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimvacations/{pimvacation_id}")
    @Transactional
    public ResponseEntity<PimVacationDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimvacation_id") String pimvacation_id, @RequestBody PimVacationDTO pimvacationdto) {
        PimVacation domain = pimvacationMapping.toDomain(pimvacationdto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimvacationid(pimvacation_id);
		pimvacationService.update(domain);
        PimVacationDTO dto = pimvacationMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimvacationService.getPimvacationByEntities(this.pimvacationMapping.toDomain(#pimvacationdtos)),'ehr-PimVacation-Update')")
    @ApiOperation(value = "根据人员信息批量更新休假信息", tags = {"休假信息" },  notes = "根据人员信息批量更新休假信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimvacations/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimVacationDTO> pimvacationdtos) {
        List<PimVacation> domainlist=pimvacationMapping.toDomain(pimvacationdtos);
        for(PimVacation domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimvacationService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimvacationService.get(#pimvacation_id),'ehr-PimVacation-Remove')")
    @ApiOperation(value = "根据人员信息删除休假信息", tags = {"休假信息" },  notes = "根据人员信息删除休假信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimvacations/{pimvacation_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimvacation_id") String pimvacation_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimvacationService.remove(pimvacation_id));
    }

    @PreAuthorize("hasPermission(this.pimvacationService.getPimvacationByIds(#ids),'ehr-PimVacation-Remove')")
    @ApiOperation(value = "根据人员信息批量删除休假信息", tags = {"休假信息" },  notes = "根据人员信息批量删除休假信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimvacations/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        pimvacationService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息获取休假信息草稿", tags = {"休假信息" },  notes = "根据人员信息获取休假信息草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimvacations/getdraft")
    public ResponseEntity<PimVacationDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        PimVacation domain = new PimVacation();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimvacationMapping.toDto(pimvacationService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pimvacationMapping.toDomain(#pimvacationdto),'ehr-PimVacation-Save')")
    @ApiOperation(value = "根据人员信息保存休假信息", tags = {"休假信息" },  notes = "根据人员信息保存休假信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimvacations/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimVacationDTO pimvacationdto) {
        PimVacation domain = pimvacationMapping.toDomain(pimvacationdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimvacationService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimvacationMapping.toDomain(#pimvacationdtos),'ehr-PimVacation-Save')")
    @ApiOperation(value = "根据人员信息批量保存休假信息", tags = {"休假信息" },  notes = "根据人员信息批量保存休假信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimvacations/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimVacationDTO> pimvacationdtos) {
        List<PimVacation> domainlist=pimvacationMapping.toDomain(pimvacationdtos);
        for(PimVacation domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimvacationService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimvacationMapping.toDomain(#pimvacationdto),'ehr-PimVacation-Create')")
    @ApiOperation(value = "根据人员信息建立休假信息", tags = {"休假信息" },  notes = "根据人员信息建立休假信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimvacations")
    @Transactional
    public ResponseEntity<PimVacationDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimVacationDTO pimvacationdto) {
        PimVacation domain = pimvacationMapping.toDomain(pimvacationdto);
        domain.setPimpersonid(pimperson_id);
		pimvacationService.create(domain);
        PimVacationDTO dto = pimvacationMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimvacationMapping.toDomain(#pimvacationdtos),'ehr-PimVacation-Create')")
    @ApiOperation(value = "根据人员信息批量建立休假信息", tags = {"休假信息" },  notes = "根据人员信息批量建立休假信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimvacations/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimVacationDTO> pimvacationdtos) {
        List<PimVacation> domainlist=pimvacationMapping.toDomain(pimvacationdtos);
        for(PimVacation domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimvacationService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息检查休假信息", tags = {"休假信息" },  notes = "根据人员信息检查休假信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimvacations/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimVacationDTO pimvacationdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimvacationService.checkKey(pimvacationMapping.toDomain(pimvacationdto)));
    }

    @PostAuthorize("hasPermission(this.pimvacationMapping.toDomain(returnObject.body),'ehr-PimVacation-Get')")
    @ApiOperation(value = "根据人员信息获取休假信息", tags = {"休假信息" },  notes = "根据人员信息获取休假信息")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimvacations/{pimvacation_id}")
    public ResponseEntity<PimVacationDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimvacation_id") String pimvacation_id) {
        PimVacation domain = pimvacationService.get(pimvacation_id);
        PimVacationDTO dto = pimvacationMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimVacation-Default-all')")
	@ApiOperation(value = "根据人员信息获取DEFAULT", tags = {"休假信息" } ,notes = "根据人员信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimvacations/fetchdefault")
	public ResponseEntity<List<PimVacationDTO>> fetchPimVacationDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimVacationSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimVacation> domains = pimvacationService.searchDefault(context) ;
        List<PimVacationDTO> list = pimvacationMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimVacation-Default-all')")
	@ApiOperation(value = "根据人员信息查询DEFAULT", tags = {"休假信息" } ,notes = "根据人员信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimvacations/searchdefault")
	public ResponseEntity<Page<PimVacationDTO>> searchPimVacationDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimVacationSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimVacation> domains = pimvacationService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimvacationMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

