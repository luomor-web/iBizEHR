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
import cn.ibizlab.ehr.core.pim.domain.PimPersonChange;
import cn.ibizlab.ehr.core.pim.service.IPimPersonChangeService;
import cn.ibizlab.ehr.core.pim.filter.PimPersonChangeSearchContext;

@Slf4j
@Api(tags = {"PimPersonChange" })
@RestController("WebApi-pimpersonchange")
@RequestMapping("")
public class PimPersonChangeResource {

    @Autowired
    public IPimPersonChangeService pimpersonchangeService;

    @Autowired
    @Lazy
    public PimPersonChangeMapping pimpersonchangeMapping;

    @PreAuthorize("hasPermission(this.pimpersonchangeMapping.toDomain(#pimpersonchangedto),'ehr-PimPersonChange-Save')")
    @ApiOperation(value = "Save", tags = {"PimPersonChange" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonchanges/save")
    public ResponseEntity<Boolean> save(@RequestBody PimPersonChangeDTO pimpersonchangedto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonchangeService.save(pimpersonchangeMapping.toDomain(pimpersonchangedto)));
    }

    @PreAuthorize("hasPermission(this.pimpersonchangeMapping.toDomain(#pimpersonchangedtos),'ehr-PimPersonChange-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PimPersonChange" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonchanges/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimPersonChangeDTO> pimpersonchangedtos) {
        pimpersonchangeService.saveBatch(pimpersonchangeMapping.toDomain(pimpersonchangedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPersonChange-BH-all')")
    @ApiOperation(value = "驳回", tags = {"PimPersonChange" },  notes = "驳回")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonchanges/{pimpersonchange_id}/bh")
    @Transactional
    public ResponseEntity<PimPersonChangeDTO> bH(@PathVariable("pimpersonchange_id") String pimpersonchange_id, @RequestBody PimPersonChangeDTO pimpersonchangedto) {
        PimPersonChange pimpersonchange = pimpersonchangeMapping.toDomain(pimpersonchangedto);
        pimpersonchange.setPimpersonchangeid(pimpersonchange_id);
        pimpersonchange = pimpersonchangeService.bH(pimpersonchange);
        pimpersonchangedto = pimpersonchangeMapping.toDto(pimpersonchange);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonchangedto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPersonChange-Ensure-all')")
    @ApiOperation(value = "确认", tags = {"PimPersonChange" },  notes = "确认")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonchanges/{pimpersonchange_id}/ensure")
    @Transactional
    public ResponseEntity<PimPersonChangeDTO> ensure(@PathVariable("pimpersonchange_id") String pimpersonchange_id, @RequestBody PimPersonChangeDTO pimpersonchangedto) {
        PimPersonChange pimpersonchange = pimpersonchangeMapping.toDomain(pimpersonchangedto);
        pimpersonchange.setPimpersonchangeid(pimpersonchange_id);
        pimpersonchange = pimpersonchangeService.ensure(pimpersonchange);
        pimpersonchangedto = pimpersonchangeMapping.toDto(pimpersonchange);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonchangedto);
    }

    @PreAuthorize("hasPermission(this.pimpersonchangeService.get(#pimpersonchange_id),'ehr-PimPersonChange-Update')")
    @ApiOperation(value = "Update", tags = {"PimPersonChange" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpersonchanges/{pimpersonchange_id}")
    @Transactional
    public ResponseEntity<PimPersonChangeDTO> update(@PathVariable("pimpersonchange_id") String pimpersonchange_id, @RequestBody PimPersonChangeDTO pimpersonchangedto) {
		PimPersonChange domain  = pimpersonchangeMapping.toDomain(pimpersonchangedto);
        domain .setPimpersonchangeid(pimpersonchange_id);
		pimpersonchangeService.update(domain );
		PimPersonChangeDTO dto = pimpersonchangeMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimpersonchangeService.getPimpersonchangeByEntities(this.pimpersonchangeMapping.toDomain(#pimpersonchangedtos)),'ehr-PimPersonChange-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PimPersonChange" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpersonchanges/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimPersonChangeDTO> pimpersonchangedtos) {
        pimpersonchangeService.updateBatch(pimpersonchangeMapping.toDomain(pimpersonchangedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimpersonchangeMapping.toDomain(returnObject.body),'ehr-PimPersonChange-Get')")
    @ApiOperation(value = "Get", tags = {"PimPersonChange" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpersonchanges/{pimpersonchange_id}")
    public ResponseEntity<PimPersonChangeDTO> get(@PathVariable("pimpersonchange_id") String pimpersonchange_id) {
        PimPersonChange domain = pimpersonchangeService.get(pimpersonchange_id);
        PimPersonChangeDTO dto = pimpersonchangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimpersonchangeMapping.toDomain(#pimpersonchangedto),'ehr-PimPersonChange-Create')")
    @ApiOperation(value = "Create", tags = {"PimPersonChange" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonchanges")
    @Transactional
    public ResponseEntity<PimPersonChangeDTO> create(@RequestBody PimPersonChangeDTO pimpersonchangedto) {
        PimPersonChange domain = pimpersonchangeMapping.toDomain(pimpersonchangedto);
		pimpersonchangeService.create(domain);
        PimPersonChangeDTO dto = pimpersonchangeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimpersonchangeMapping.toDomain(#pimpersonchangedtos),'ehr-PimPersonChange-Create')")
    @ApiOperation(value = "createBatch", tags = {"PimPersonChange" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonchanges/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimPersonChangeDTO> pimpersonchangedtos) {
        pimpersonchangeService.createBatch(pimpersonchangeMapping.toDomain(pimpersonchangedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimpersonchangeService.get(#pimpersonchange_id),'ehr-PimPersonChange-Remove')")
    @ApiOperation(value = "Remove", tags = {"PimPersonChange" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpersonchanges/{pimpersonchange_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimpersonchange_id") String pimpersonchange_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimpersonchangeService.remove(pimpersonchange_id));
    }

    @PreAuthorize("hasPermission(this.pimpersonchangeService.getPimpersonchangeByIds(#ids),'ehr-PimPersonChange-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PimPersonChange" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpersonchanges/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimpersonchangeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPersonChange-QR-all')")
    @ApiOperation(value = "确认", tags = {"PimPersonChange" },  notes = "确认")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonchanges/{pimpersonchange_id}/qr")
    @Transactional
    public ResponseEntity<PimPersonChangeDTO> qR(@PathVariable("pimpersonchange_id") String pimpersonchange_id, @RequestBody PimPersonChangeDTO pimpersonchangedto) {
        PimPersonChange pimpersonchange = pimpersonchangeMapping.toDomain(pimpersonchangedto);
        pimpersonchange.setPimpersonchangeid(pimpersonchange_id);
        pimpersonchange = pimpersonchangeService.qR(pimpersonchange);
        pimpersonchangedto = pimpersonchangeMapping.toDto(pimpersonchange);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonchangedto);
    }

    @ApiOperation(value = "CheckKey", tags = {"PimPersonChange" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpersonchanges/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimPersonChangeDTO pimpersonchangedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimpersonchangeService.checkKey(pimpersonchangeMapping.toDomain(pimpersonchangedto)));
    }

    @ApiOperation(value = "GetDraft", tags = {"PimPersonChange" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpersonchanges/getdraft")
    public ResponseEntity<PimPersonChangeDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonchangeMapping.toDto(pimpersonchangeService.getDraft(new PimPersonChange())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPersonChange-HistoryRec-all')")
	@ApiOperation(value = "fetch历史审批记录", tags = {"PimPersonChange" } ,notes = "fetch历史审批记录")
    @RequestMapping(method= RequestMethod.GET , value="/pimpersonchanges/fetchhistoryrec")
	public ResponseEntity<List<PimPersonChangeDTO>> fetchHistoryRec(PimPersonChangeSearchContext context) {
        Page<PimPersonChange> domains = pimpersonchangeService.searchHistoryRec(context) ;
        List<PimPersonChangeDTO> list = pimpersonchangeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPersonChange-HistoryRec-all')")
	@ApiOperation(value = "search历史审批记录", tags = {"PimPersonChange" } ,notes = "search历史审批记录")
    @RequestMapping(method= RequestMethod.POST , value="/pimpersonchanges/searchhistoryrec")
	public ResponseEntity<Page<PimPersonChangeDTO>> searchHistoryRec(@RequestBody PimPersonChangeSearchContext context) {
        Page<PimPersonChange> domains = pimpersonchangeService.searchHistoryRec(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonchangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPersonChange-PIMCL_NOTAPPROVAL-all')")
	@ApiOperation(value = "fetchPIMCL_NOTAPPROVAL", tags = {"PimPersonChange" } ,notes = "fetchPIMCL_NOTAPPROVAL")
    @RequestMapping(method= RequestMethod.GET , value="/pimpersonchanges/fetchpimcl_notapproval")
	public ResponseEntity<List<PimPersonChangeDTO>> fetchPIMCL_NOTAPPROVAL(PimPersonChangeSearchContext context) {
        Page<PimPersonChange> domains = pimpersonchangeService.searchPIMCL_NOTAPPROVAL(context) ;
        List<PimPersonChangeDTO> list = pimpersonchangeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPersonChange-PIMCL_NOTAPPROVAL-all')")
	@ApiOperation(value = "searchPIMCL_NOTAPPROVAL", tags = {"PimPersonChange" } ,notes = "searchPIMCL_NOTAPPROVAL")
    @RequestMapping(method= RequestMethod.POST , value="/pimpersonchanges/searchpimcl_notapproval")
	public ResponseEntity<Page<PimPersonChangeDTO>> searchPIMCL_NOTAPPROVAL(@RequestBody PimPersonChangeSearchContext context) {
        Page<PimPersonChange> domains = pimpersonchangeService.searchPIMCL_NOTAPPROVAL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonchangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPersonChange-HeadRed-all')")
	@ApiOperation(value = "fetch总部记录", tags = {"PimPersonChange" } ,notes = "fetch总部记录")
    @RequestMapping(method= RequestMethod.GET , value="/pimpersonchanges/fetchheadred")
	public ResponseEntity<List<PimPersonChangeDTO>> fetchHeadRed(PimPersonChangeSearchContext context) {
        Page<PimPersonChange> domains = pimpersonchangeService.searchHeadRed(context) ;
        List<PimPersonChangeDTO> list = pimpersonchangeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPersonChange-HeadRed-all')")
	@ApiOperation(value = "search总部记录", tags = {"PimPersonChange" } ,notes = "search总部记录")
    @RequestMapping(method= RequestMethod.POST , value="/pimpersonchanges/searchheadred")
	public ResponseEntity<Page<PimPersonChangeDTO>> searchHeadRed(@RequestBody PimPersonChangeSearchContext context) {
        Page<PimPersonChange> domains = pimpersonchangeService.searchHeadRed(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonchangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPersonChange-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PimPersonChange" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpersonchanges/fetchdefault")
	public ResponseEntity<List<PimPersonChangeDTO>> fetchDefault(PimPersonChangeSearchContext context) {
        Page<PimPersonChange> domains = pimpersonchangeService.searchDefault(context) ;
        List<PimPersonChangeDTO> list = pimpersonchangeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPersonChange-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PimPersonChange" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpersonchanges/searchdefault")
	public ResponseEntity<Page<PimPersonChangeDTO>> searchDefault(@RequestBody PimPersonChangeSearchContext context) {
        Page<PimPersonChange> domains = pimpersonchangeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonchangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pimpersonchangeMapping.toDomain(#pimpersonchangedto),'ehr-PimPersonChange-Save')")
    @ApiOperation(value = "SaveByPimPerson", tags = {"PimPersonChange" },  notes = "SaveByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpersonchanges/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPersonChangeDTO pimpersonchangedto) {
        PimPersonChange domain = pimpersonchangeMapping.toDomain(pimpersonchangedto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonchangeService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimpersonchangeMapping.toDomain(#pimpersonchangedtos),'ehr-PimPersonChange-Save')")
    @ApiOperation(value = "SaveBatchByPimPerson", tags = {"PimPersonChange" },  notes = "SaveBatchByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpersonchanges/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimPersonChangeDTO> pimpersonchangedtos) {
        List<PimPersonChange> domainlist=pimpersonchangeMapping.toDomain(pimpersonchangedtos);
        for(PimPersonChange domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimpersonchangeService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPersonChange-BH-all')")
    @ApiOperation(value = "驳回ByPimPerson", tags = {"PimPersonChange" },  notes = "驳回ByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpersonchanges/{pimpersonchange_id}/bh")
    @Transactional
    public ResponseEntity<PimPersonChangeDTO> bHByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimpersonchange_id") String pimpersonchange_id, @RequestBody PimPersonChangeDTO pimpersonchangedto) {
        PimPersonChange domain = pimpersonchangeMapping.toDomain(pimpersonchangedto);
        domain.setPimpersonid(pimperson_id);
        domain = pimpersonchangeService.bH(domain) ;
        pimpersonchangedto = pimpersonchangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonchangedto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPersonChange-Ensure-all')")
    @ApiOperation(value = "确认ByPimPerson", tags = {"PimPersonChange" },  notes = "确认ByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpersonchanges/{pimpersonchange_id}/ensure")
    @Transactional
    public ResponseEntity<PimPersonChangeDTO> ensureByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimpersonchange_id") String pimpersonchange_id, @RequestBody PimPersonChangeDTO pimpersonchangedto) {
        PimPersonChange domain = pimpersonchangeMapping.toDomain(pimpersonchangedto);
        domain.setPimpersonid(pimperson_id);
        domain = pimpersonchangeService.ensure(domain) ;
        pimpersonchangedto = pimpersonchangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonchangedto);
    }

    @PreAuthorize("hasPermission(this.pimpersonchangeService.get(#pimpersonchange_id),'ehr-PimPersonChange-Update')")
    @ApiOperation(value = "UpdateByPimPerson", tags = {"PimPersonChange" },  notes = "UpdateByPimPerson")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimpersonchanges/{pimpersonchange_id}")
    @Transactional
    public ResponseEntity<PimPersonChangeDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimpersonchange_id") String pimpersonchange_id, @RequestBody PimPersonChangeDTO pimpersonchangedto) {
        PimPersonChange domain = pimpersonchangeMapping.toDomain(pimpersonchangedto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimpersonchangeid(pimpersonchange_id);
		pimpersonchangeService.update(domain);
        PimPersonChangeDTO dto = pimpersonchangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimpersonchangeService.getPimpersonchangeByEntities(this.pimpersonchangeMapping.toDomain(#pimpersonchangedtos)),'ehr-PimPersonChange-Update')")
    @ApiOperation(value = "UpdateBatchByPimPerson", tags = {"PimPersonChange" },  notes = "UpdateBatchByPimPerson")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimpersonchanges/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimPersonChangeDTO> pimpersonchangedtos) {
        List<PimPersonChange> domainlist=pimpersonchangeMapping.toDomain(pimpersonchangedtos);
        for(PimPersonChange domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimpersonchangeService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimpersonchangeMapping.toDomain(returnObject.body),'ehr-PimPersonChange-Get')")
    @ApiOperation(value = "GetByPimPerson", tags = {"PimPersonChange" },  notes = "GetByPimPerson")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimpersonchanges/{pimpersonchange_id}")
    public ResponseEntity<PimPersonChangeDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimpersonchange_id") String pimpersonchange_id) {
        PimPersonChange domain = pimpersonchangeService.get(pimpersonchange_id);
        PimPersonChangeDTO dto = pimpersonchangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimpersonchangeMapping.toDomain(#pimpersonchangedto),'ehr-PimPersonChange-Create')")
    @ApiOperation(value = "CreateByPimPerson", tags = {"PimPersonChange" },  notes = "CreateByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpersonchanges")
    @Transactional
    public ResponseEntity<PimPersonChangeDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPersonChangeDTO pimpersonchangedto) {
        PimPersonChange domain = pimpersonchangeMapping.toDomain(pimpersonchangedto);
        domain.setPimpersonid(pimperson_id);
		pimpersonchangeService.create(domain);
        PimPersonChangeDTO dto = pimpersonchangeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimpersonchangeMapping.toDomain(#pimpersonchangedtos),'ehr-PimPersonChange-Create')")
    @ApiOperation(value = "createBatchByPimPerson", tags = {"PimPersonChange" },  notes = "createBatchByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpersonchanges/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimPersonChangeDTO> pimpersonchangedtos) {
        List<PimPersonChange> domainlist=pimpersonchangeMapping.toDomain(pimpersonchangedtos);
        for(PimPersonChange domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimpersonchangeService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimpersonchangeService.get(#pimpersonchange_id),'ehr-PimPersonChange-Remove')")
    @ApiOperation(value = "RemoveByPimPerson", tags = {"PimPersonChange" },  notes = "RemoveByPimPerson")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimpersonchanges/{pimpersonchange_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimpersonchange_id") String pimpersonchange_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimpersonchangeService.remove(pimpersonchange_id));
    }

    @PreAuthorize("hasPermission(this.pimpersonchangeService.getPimpersonchangeByIds(#ids),'ehr-PimPersonChange-Remove')")
    @ApiOperation(value = "RemoveBatchByPimPerson", tags = {"PimPersonChange" },  notes = "RemoveBatchByPimPerson")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimpersonchanges/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        pimpersonchangeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPersonChange-QR-all')")
    @ApiOperation(value = "确认ByPimPerson", tags = {"PimPersonChange" },  notes = "确认ByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpersonchanges/{pimpersonchange_id}/qr")
    @Transactional
    public ResponseEntity<PimPersonChangeDTO> qRByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimpersonchange_id") String pimpersonchange_id, @RequestBody PimPersonChangeDTO pimpersonchangedto) {
        PimPersonChange domain = pimpersonchangeMapping.toDomain(pimpersonchangedto);
        domain.setPimpersonid(pimperson_id);
        domain = pimpersonchangeService.qR(domain) ;
        pimpersonchangedto = pimpersonchangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonchangedto);
    }

    @ApiOperation(value = "CheckKeyByPimPerson", tags = {"PimPersonChange" },  notes = "CheckKeyByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpersonchanges/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPersonChangeDTO pimpersonchangedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimpersonchangeService.checkKey(pimpersonchangeMapping.toDomain(pimpersonchangedto)));
    }

    @ApiOperation(value = "GetDraftByPimPerson", tags = {"PimPersonChange" },  notes = "GetDraftByPimPerson")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimpersonchanges/getdraft")
    public ResponseEntity<PimPersonChangeDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        PimPersonChange domain = new PimPersonChange();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimpersonchangeMapping.toDto(pimpersonchangeService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPersonChange-HistoryRec-all')")
	@ApiOperation(value = "fetch历史审批记录ByPimPerson", tags = {"PimPersonChange" } ,notes = "fetch历史审批记录ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimpersonchanges/fetchhistoryrec")
	public ResponseEntity<List<PimPersonChangeDTO>> fetchPimPersonChangeHistoryRecByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimPersonChangeSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimPersonChange> domains = pimpersonchangeService.searchHistoryRec(context) ;
        List<PimPersonChangeDTO> list = pimpersonchangeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPersonChange-HistoryRec-all')")
	@ApiOperation(value = "search历史审批记录ByPimPerson", tags = {"PimPersonChange" } ,notes = "search历史审批记录ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimpersonchanges/searchhistoryrec")
	public ResponseEntity<Page<PimPersonChangeDTO>> searchPimPersonChangeHistoryRecByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPersonChangeSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimPersonChange> domains = pimpersonchangeService.searchHistoryRec(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonchangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPersonChange-PIMCL_NOTAPPROVAL-all')")
	@ApiOperation(value = "fetchPIMCL_NOTAPPROVALByPimPerson", tags = {"PimPersonChange" } ,notes = "fetchPIMCL_NOTAPPROVALByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimpersonchanges/fetchpimcl_notapproval")
	public ResponseEntity<List<PimPersonChangeDTO>> fetchPimPersonChangePIMCL_NOTAPPROVALByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimPersonChangeSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimPersonChange> domains = pimpersonchangeService.searchPIMCL_NOTAPPROVAL(context) ;
        List<PimPersonChangeDTO> list = pimpersonchangeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPersonChange-PIMCL_NOTAPPROVAL-all')")
	@ApiOperation(value = "searchPIMCL_NOTAPPROVALByPimPerson", tags = {"PimPersonChange" } ,notes = "searchPIMCL_NOTAPPROVALByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimpersonchanges/searchpimcl_notapproval")
	public ResponseEntity<Page<PimPersonChangeDTO>> searchPimPersonChangePIMCL_NOTAPPROVALByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPersonChangeSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimPersonChange> domains = pimpersonchangeService.searchPIMCL_NOTAPPROVAL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonchangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPersonChange-HeadRed-all')")
	@ApiOperation(value = "fetch总部记录ByPimPerson", tags = {"PimPersonChange" } ,notes = "fetch总部记录ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimpersonchanges/fetchheadred")
	public ResponseEntity<List<PimPersonChangeDTO>> fetchPimPersonChangeHeadRedByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimPersonChangeSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimPersonChange> domains = pimpersonchangeService.searchHeadRed(context) ;
        List<PimPersonChangeDTO> list = pimpersonchangeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPersonChange-HeadRed-all')")
	@ApiOperation(value = "search总部记录ByPimPerson", tags = {"PimPersonChange" } ,notes = "search总部记录ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimpersonchanges/searchheadred")
	public ResponseEntity<Page<PimPersonChangeDTO>> searchPimPersonChangeHeadRedByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPersonChangeSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimPersonChange> domains = pimpersonchangeService.searchHeadRed(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonchangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPersonChange-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPimPerson", tags = {"PimPersonChange" } ,notes = "fetchDEFAULTByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimpersonchanges/fetchdefault")
	public ResponseEntity<List<PimPersonChangeDTO>> fetchPimPersonChangeDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimPersonChangeSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimPersonChange> domains = pimpersonchangeService.searchDefault(context) ;
        List<PimPersonChangeDTO> list = pimpersonchangeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPersonChange-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPimPerson", tags = {"PimPersonChange" } ,notes = "searchDEFAULTByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimpersonchanges/searchdefault")
	public ResponseEntity<Page<PimPersonChangeDTO>> searchPimPersonChangeDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPersonChangeSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimPersonChange> domains = pimpersonchangeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpersonchangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

