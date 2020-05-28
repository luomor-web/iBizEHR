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
import cn.ibizlab.ehr.core.pim.domain.PIMARCHIVESCHANGE;
import cn.ibizlab.ehr.core.pim.service.IPIMARCHIVESCHANGEService;
import cn.ibizlab.ehr.core.pim.filter.PIMARCHIVESCHANGESearchContext;

@Slf4j
@Api(tags = {"PIMARCHIVESCHANGE" })
@RestController("WebApi-pimarchiveschange")
@RequestMapping("")
public class PIMARCHIVESCHANGEResource {

    @Autowired
    public IPIMARCHIVESCHANGEService pimarchiveschangeService;

    @Autowired
    @Lazy
    public PIMARCHIVESCHANGEMapping pimarchiveschangeMapping;

    @PreAuthorize("hasPermission(this.pimarchiveschangeService.get(#pimarchiveschange_id),'ehr-PIMARCHIVESCHANGE-Update')")
    @ApiOperation(value = "Update", tags = {"PIMARCHIVESCHANGE" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchiveschanges/{pimarchiveschange_id}")
    @Transactional
    public ResponseEntity<PIMARCHIVESCHANGEDTO> update(@PathVariable("pimarchiveschange_id") String pimarchiveschange_id, @RequestBody PIMARCHIVESCHANGEDTO pimarchiveschangedto) {
		PIMARCHIVESCHANGE domain  = pimarchiveschangeMapping.toDomain(pimarchiveschangedto);
        domain .setPimarchiveschangeid(pimarchiveschange_id);
		pimarchiveschangeService.update(domain );
		PIMARCHIVESCHANGEDTO dto = pimarchiveschangeMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeService.getPimarchiveschangeByEntities(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedtos)),'ehr-PIMARCHIVESCHANGE-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMARCHIVESCHANGE" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchiveschanges/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMARCHIVESCHANGEDTO> pimarchiveschangedtos) {
        pimarchiveschangeService.updateBatch(pimarchiveschangeMapping.toDomain(pimarchiveschangedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(returnObject.body),'ehr-PIMARCHIVESCHANGE-Get')")
    @ApiOperation(value = "Get", tags = {"PIMARCHIVESCHANGE" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarchiveschanges/{pimarchiveschange_id}")
    public ResponseEntity<PIMARCHIVESCHANGEDTO> get(@PathVariable("pimarchiveschange_id") String pimarchiveschange_id) {
        PIMARCHIVESCHANGE domain = pimarchiveschangeService.get(pimarchiveschange_id);
        PIMARCHIVESCHANGEDTO dto = pimarchiveschangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedto),'ehr-PIMARCHIVESCHANGE-Create')")
    @ApiOperation(value = "Create", tags = {"PIMARCHIVESCHANGE" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchiveschanges")
    @Transactional
    public ResponseEntity<PIMARCHIVESCHANGEDTO> create(@RequestBody PIMARCHIVESCHANGEDTO pimarchiveschangedto) {
        PIMARCHIVESCHANGE domain = pimarchiveschangeMapping.toDomain(pimarchiveschangedto);
		pimarchiveschangeService.create(domain);
        PIMARCHIVESCHANGEDTO dto = pimarchiveschangeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedtos),'ehr-PIMARCHIVESCHANGE-Create')")
    @ApiOperation(value = "createBatch", tags = {"PIMARCHIVESCHANGE" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchiveschanges/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMARCHIVESCHANGEDTO> pimarchiveschangedtos) {
        pimarchiveschangeService.createBatch(pimarchiveschangeMapping.toDomain(pimarchiveschangedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"PIMARCHIVESCHANGE" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarchiveschanges/getdraft")
    public ResponseEntity<PIMARCHIVESCHANGEDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeMapping.toDto(pimarchiveschangeService.getDraft(new PIMARCHIVESCHANGE())));
    }

    @ApiOperation(value = "CheckKey", tags = {"PIMARCHIVESCHANGE" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchiveschanges/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMARCHIVESCHANGEDTO pimarchiveschangedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeService.checkKey(pimarchiveschangeMapping.toDomain(pimarchiveschangedto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESCHANGE-UpdatePersonFile-all')")
    @ApiOperation(value = "更新档案信息", tags = {"PIMARCHIVESCHANGE" },  notes = "更新档案信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchiveschanges/{pimarchiveschange_id}/updatepersonfile")
    @Transactional
    public ResponseEntity<PIMARCHIVESCHANGEDTO> updatePersonFile(@PathVariable("pimarchiveschange_id") String pimarchiveschange_id, @RequestBody PIMARCHIVESCHANGEDTO pimarchiveschangedto) {
        PIMARCHIVESCHANGE pimarchiveschange = pimarchiveschangeMapping.toDomain(pimarchiveschangedto);
        pimarchiveschange.setPimarchiveschangeid(pimarchiveschange_id);
        pimarchiveschange = pimarchiveschangeService.updatePersonFile(pimarchiveschange);
        pimarchiveschangedto = pimarchiveschangeMapping.toDto(pimarchiveschange);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangedto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedto),'ehr-PIMARCHIVESCHANGE-Save')")
    @ApiOperation(value = "Save", tags = {"PIMARCHIVESCHANGE" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchiveschanges/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMARCHIVESCHANGEDTO pimarchiveschangedto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeService.save(pimarchiveschangeMapping.toDomain(pimarchiveschangedto)));
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedtos),'ehr-PIMARCHIVESCHANGE-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PIMARCHIVESCHANGE" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchiveschanges/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMARCHIVESCHANGEDTO> pimarchiveschangedtos) {
        pimarchiveschangeService.saveBatch(pimarchiveschangeMapping.toDomain(pimarchiveschangedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeService.get(#pimarchiveschange_id),'ehr-PIMARCHIVESCHANGE-Remove')")
    @ApiOperation(value = "Remove", tags = {"PIMARCHIVESCHANGE" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchiveschanges/{pimarchiveschange_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimarchiveschange_id") String pimarchiveschange_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeService.remove(pimarchiveschange_id));
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeService.getPimarchiveschangeByIds(#ids),'ehr-PIMARCHIVESCHANGE-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PIMARCHIVESCHANGE" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchiveschanges/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimarchiveschangeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESCHANGE-DADCJL-all')")
	@ApiOperation(value = "fetch档案调出记录", tags = {"PIMARCHIVESCHANGE" } ,notes = "fetch档案调出记录")
    @RequestMapping(method= RequestMethod.GET , value="/pimarchiveschanges/fetchdadcjl")
	public ResponseEntity<List<PIMARCHIVESCHANGEDTO>> fetchDADCJL(PIMARCHIVESCHANGESearchContext context) {
        Page<PIMARCHIVESCHANGE> domains = pimarchiveschangeService.searchDADCJL(context) ;
        List<PIMARCHIVESCHANGEDTO> list = pimarchiveschangeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESCHANGE-DADCJL-all')")
	@ApiOperation(value = "search档案调出记录", tags = {"PIMARCHIVESCHANGE" } ,notes = "search档案调出记录")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchiveschanges/searchdadcjl")
	public ResponseEntity<Page<PIMARCHIVESCHANGEDTO>> searchDADCJL(@RequestBody PIMARCHIVESCHANGESearchContext context) {
        Page<PIMARCHIVESCHANGE> domains = pimarchiveschangeService.searchDADCJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchiveschangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESCHANGE-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMARCHIVESCHANGE" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimarchiveschanges/fetchdefault")
	public ResponseEntity<List<PIMARCHIVESCHANGEDTO>> fetchDefault(PIMARCHIVESCHANGESearchContext context) {
        Page<PIMARCHIVESCHANGE> domains = pimarchiveschangeService.searchDefault(context) ;
        List<PIMARCHIVESCHANGEDTO> list = pimarchiveschangeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESCHANGE-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMARCHIVESCHANGE" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchiveschanges/searchdefault")
	public ResponseEntity<Page<PIMARCHIVESCHANGEDTO>> searchDefault(@RequestBody PIMARCHIVESCHANGESearchContext context) {
        Page<PIMARCHIVESCHANGE> domains = pimarchiveschangeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchiveschangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pimarchiveschangeService.get(#pimarchiveschange_id),'ehr-PIMARCHIVESCHANGE-Update')")
    @ApiOperation(value = "UpdateByPIMARCHIVES", tags = {"PIMARCHIVESCHANGE" },  notes = "UpdateByPIMARCHIVES")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/{pimarchiveschange_id}")
    @Transactional
    public ResponseEntity<PIMARCHIVESCHANGEDTO> updateByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchiveschange_id") String pimarchiveschange_id, @RequestBody PIMARCHIVESCHANGEDTO pimarchiveschangedto) {
        PIMARCHIVESCHANGE domain = pimarchiveschangeMapping.toDomain(pimarchiveschangedto);
        domain.setPimarchivesid(pimarchives_id);
        domain.setPimarchiveschangeid(pimarchiveschange_id);
		pimarchiveschangeService.update(domain);
        PIMARCHIVESCHANGEDTO dto = pimarchiveschangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeService.getPimarchiveschangeByEntities(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedtos)),'ehr-PIMARCHIVESCHANGE-Update')")
    @ApiOperation(value = "UpdateBatchByPIMARCHIVES", tags = {"PIMARCHIVESCHANGE" },  notes = "UpdateBatchByPIMARCHIVES")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/batch")
    public ResponseEntity<Boolean> updateBatchByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PIMARCHIVESCHANGEDTO> pimarchiveschangedtos) {
        List<PIMARCHIVESCHANGE> domainlist=pimarchiveschangeMapping.toDomain(pimarchiveschangedtos);
        for(PIMARCHIVESCHANGE domain:domainlist){
            domain.setPimarchivesid(pimarchives_id);
        }
        pimarchiveschangeService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(returnObject.body),'ehr-PIMARCHIVESCHANGE-Get')")
    @ApiOperation(value = "GetByPIMARCHIVES", tags = {"PIMARCHIVESCHANGE" },  notes = "GetByPIMARCHIVES")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/{pimarchiveschange_id}")
    public ResponseEntity<PIMARCHIVESCHANGEDTO> getByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchiveschange_id") String pimarchiveschange_id) {
        PIMARCHIVESCHANGE domain = pimarchiveschangeService.get(pimarchiveschange_id);
        PIMARCHIVESCHANGEDTO dto = pimarchiveschangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedto),'ehr-PIMARCHIVESCHANGE-Create')")
    @ApiOperation(value = "CreateByPIMARCHIVES", tags = {"PIMARCHIVESCHANGE" },  notes = "CreateByPIMARCHIVES")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges")
    @Transactional
    public ResponseEntity<PIMARCHIVESCHANGEDTO> createByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESCHANGEDTO pimarchiveschangedto) {
        PIMARCHIVESCHANGE domain = pimarchiveschangeMapping.toDomain(pimarchiveschangedto);
        domain.setPimarchivesid(pimarchives_id);
		pimarchiveschangeService.create(domain);
        PIMARCHIVESCHANGEDTO dto = pimarchiveschangeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedtos),'ehr-PIMARCHIVESCHANGE-Create')")
    @ApiOperation(value = "createBatchByPIMARCHIVES", tags = {"PIMARCHIVESCHANGE" },  notes = "createBatchByPIMARCHIVES")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/batch")
    public ResponseEntity<Boolean> createBatchByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PIMARCHIVESCHANGEDTO> pimarchiveschangedtos) {
        List<PIMARCHIVESCHANGE> domainlist=pimarchiveschangeMapping.toDomain(pimarchiveschangedtos);
        for(PIMARCHIVESCHANGE domain:domainlist){
            domain.setPimarchivesid(pimarchives_id);
        }
        pimarchiveschangeService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPIMARCHIVES", tags = {"PIMARCHIVESCHANGE" },  notes = "GetDraftByPIMARCHIVES")
    @RequestMapping(method = RequestMethod.GET, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/getdraft")
    public ResponseEntity<PIMARCHIVESCHANGEDTO> getDraftByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id) {
        PIMARCHIVESCHANGE domain = new PIMARCHIVESCHANGE();
        domain.setPimarchivesid(pimarchives_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeMapping.toDto(pimarchiveschangeService.getDraft(domain)));
    }

    @ApiOperation(value = "CheckKeyByPIMARCHIVES", tags = {"PIMARCHIVESCHANGE" },  notes = "CheckKeyByPIMARCHIVES")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESCHANGEDTO pimarchiveschangedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeService.checkKey(pimarchiveschangeMapping.toDomain(pimarchiveschangedto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESCHANGE-UpdatePersonFile-all')")
    @ApiOperation(value = "更新档案信息ByPIMARCHIVES", tags = {"PIMARCHIVESCHANGE" },  notes = "更新档案信息ByPIMARCHIVES")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/{pimarchiveschange_id}/updatepersonfile")
    @Transactional
    public ResponseEntity<PIMARCHIVESCHANGEDTO> updatePersonFileByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchiveschange_id") String pimarchiveschange_id, @RequestBody PIMARCHIVESCHANGEDTO pimarchiveschangedto) {
        PIMARCHIVESCHANGE domain = pimarchiveschangeMapping.toDomain(pimarchiveschangedto);
        domain.setPimarchivesid(pimarchives_id);
        domain = pimarchiveschangeService.updatePersonFile(domain) ;
        pimarchiveschangedto = pimarchiveschangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangedto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedto),'ehr-PIMARCHIVESCHANGE-Save')")
    @ApiOperation(value = "SaveByPIMARCHIVES", tags = {"PIMARCHIVESCHANGE" },  notes = "SaveByPIMARCHIVES")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/save")
    public ResponseEntity<Boolean> saveByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESCHANGEDTO pimarchiveschangedto) {
        PIMARCHIVESCHANGE domain = pimarchiveschangeMapping.toDomain(pimarchiveschangedto);
        domain.setPimarchivesid(pimarchives_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedtos),'ehr-PIMARCHIVESCHANGE-Save')")
    @ApiOperation(value = "SaveBatchByPIMARCHIVES", tags = {"PIMARCHIVESCHANGE" },  notes = "SaveBatchByPIMARCHIVES")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PIMARCHIVESCHANGEDTO> pimarchiveschangedtos) {
        List<PIMARCHIVESCHANGE> domainlist=pimarchiveschangeMapping.toDomain(pimarchiveschangedtos);
        for(PIMARCHIVESCHANGE domain:domainlist){
             domain.setPimarchivesid(pimarchives_id);
        }
        pimarchiveschangeService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeService.get(#pimarchiveschange_id),'ehr-PIMARCHIVESCHANGE-Remove')")
    @ApiOperation(value = "RemoveByPIMARCHIVES", tags = {"PIMARCHIVESCHANGE" },  notes = "RemoveByPIMARCHIVES")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/{pimarchiveschange_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchiveschange_id") String pimarchiveschange_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeService.remove(pimarchiveschange_id));
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeService.getPimarchiveschangeByIds(#ids),'ehr-PIMARCHIVESCHANGE-Remove')")
    @ApiOperation(value = "RemoveBatchByPIMARCHIVES", tags = {"PIMARCHIVESCHANGE" },  notes = "RemoveBatchByPIMARCHIVES")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/batch")
    public ResponseEntity<Boolean> removeBatchByPIMARCHIVES(@RequestBody List<String> ids) {
        pimarchiveschangeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESCHANGE-DADCJL-all')")
	@ApiOperation(value = "fetch档案调出记录ByPIMARCHIVES", tags = {"PIMARCHIVESCHANGE" } ,notes = "fetch档案调出记录ByPIMARCHIVES")
    @RequestMapping(method= RequestMethod.GET , value="/pimarchives/{pimarchives_id}/pimarchiveschanges/fetchdadcjl")
	public ResponseEntity<List<PIMARCHIVESCHANGEDTO>> fetchPIMARCHIVESCHANGEDADCJLByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id,PIMARCHIVESCHANGESearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PIMARCHIVESCHANGE> domains = pimarchiveschangeService.searchDADCJL(context) ;
        List<PIMARCHIVESCHANGEDTO> list = pimarchiveschangeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESCHANGE-DADCJL-all')")
	@ApiOperation(value = "search档案调出记录ByPIMARCHIVES", tags = {"PIMARCHIVESCHANGE" } ,notes = "search档案调出记录ByPIMARCHIVES")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchives/{pimarchives_id}/pimarchiveschanges/searchdadcjl")
	public ResponseEntity<Page<PIMARCHIVESCHANGEDTO>> searchPIMARCHIVESCHANGEDADCJLByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESCHANGESearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PIMARCHIVESCHANGE> domains = pimarchiveschangeService.searchDADCJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchiveschangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESCHANGE-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPIMARCHIVES", tags = {"PIMARCHIVESCHANGE" } ,notes = "fetchDEFAULTByPIMARCHIVES")
    @RequestMapping(method= RequestMethod.GET , value="/pimarchives/{pimarchives_id}/pimarchiveschanges/fetchdefault")
	public ResponseEntity<List<PIMARCHIVESCHANGEDTO>> fetchPIMARCHIVESCHANGEDefaultByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id,PIMARCHIVESCHANGESearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PIMARCHIVESCHANGE> domains = pimarchiveschangeService.searchDefault(context) ;
        List<PIMARCHIVESCHANGEDTO> list = pimarchiveschangeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESCHANGE-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPIMARCHIVES", tags = {"PIMARCHIVESCHANGE" } ,notes = "searchDEFAULTByPIMARCHIVES")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchives/{pimarchives_id}/pimarchiveschanges/searchdefault")
	public ResponseEntity<Page<PIMARCHIVESCHANGEDTO>> searchPIMARCHIVESCHANGEDefaultByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESCHANGESearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PIMARCHIVESCHANGE> domains = pimarchiveschangeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchiveschangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pimarchiveschangeService.get(#pimarchiveschange_id),'ehr-PIMARCHIVESCHANGE-Update')")
    @ApiOperation(value = "UpdateByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESCHANGE" },  notes = "UpdateByPIMPERSONPIMARCHIVES")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/{pimarchiveschange_id}")
    @Transactional
    public ResponseEntity<PIMARCHIVESCHANGEDTO> updateByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchiveschange_id") String pimarchiveschange_id, @RequestBody PIMARCHIVESCHANGEDTO pimarchiveschangedto) {
        PIMARCHIVESCHANGE domain = pimarchiveschangeMapping.toDomain(pimarchiveschangedto);
        domain.setPimarchivesid(pimarchives_id);
        domain.setPimarchiveschangeid(pimarchiveschange_id);
		pimarchiveschangeService.update(domain);
        PIMARCHIVESCHANGEDTO dto = pimarchiveschangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeService.getPimarchiveschangeByEntities(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedtos)),'ehr-PIMARCHIVESCHANGE-Update')")
    @ApiOperation(value = "UpdateBatchByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESCHANGE" },  notes = "UpdateBatchByPIMPERSONPIMARCHIVES")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/batch")
    public ResponseEntity<Boolean> updateBatchByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PIMARCHIVESCHANGEDTO> pimarchiveschangedtos) {
        List<PIMARCHIVESCHANGE> domainlist=pimarchiveschangeMapping.toDomain(pimarchiveschangedtos);
        for(PIMARCHIVESCHANGE domain:domainlist){
            domain.setPimarchivesid(pimarchives_id);
        }
        pimarchiveschangeService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(returnObject.body),'ehr-PIMARCHIVESCHANGE-Get')")
    @ApiOperation(value = "GetByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESCHANGE" },  notes = "GetByPIMPERSONPIMARCHIVES")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/{pimarchiveschange_id}")
    public ResponseEntity<PIMARCHIVESCHANGEDTO> getByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchiveschange_id") String pimarchiveschange_id) {
        PIMARCHIVESCHANGE domain = pimarchiveschangeService.get(pimarchiveschange_id);
        PIMARCHIVESCHANGEDTO dto = pimarchiveschangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedto),'ehr-PIMARCHIVESCHANGE-Create')")
    @ApiOperation(value = "CreateByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESCHANGE" },  notes = "CreateByPIMPERSONPIMARCHIVES")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges")
    @Transactional
    public ResponseEntity<PIMARCHIVESCHANGEDTO> createByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESCHANGEDTO pimarchiveschangedto) {
        PIMARCHIVESCHANGE domain = pimarchiveschangeMapping.toDomain(pimarchiveschangedto);
        domain.setPimarchivesid(pimarchives_id);
		pimarchiveschangeService.create(domain);
        PIMARCHIVESCHANGEDTO dto = pimarchiveschangeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedtos),'ehr-PIMARCHIVESCHANGE-Create')")
    @ApiOperation(value = "createBatchByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESCHANGE" },  notes = "createBatchByPIMPERSONPIMARCHIVES")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/batch")
    public ResponseEntity<Boolean> createBatchByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PIMARCHIVESCHANGEDTO> pimarchiveschangedtos) {
        List<PIMARCHIVESCHANGE> domainlist=pimarchiveschangeMapping.toDomain(pimarchiveschangedtos);
        for(PIMARCHIVESCHANGE domain:domainlist){
            domain.setPimarchivesid(pimarchives_id);
        }
        pimarchiveschangeService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESCHANGE" },  notes = "GetDraftByPIMPERSONPIMARCHIVES")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/getdraft")
    public ResponseEntity<PIMARCHIVESCHANGEDTO> getDraftByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id) {
        PIMARCHIVESCHANGE domain = new PIMARCHIVESCHANGE();
        domain.setPimarchivesid(pimarchives_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeMapping.toDto(pimarchiveschangeService.getDraft(domain)));
    }

    @ApiOperation(value = "CheckKeyByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESCHANGE" },  notes = "CheckKeyByPIMPERSONPIMARCHIVES")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESCHANGEDTO pimarchiveschangedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeService.checkKey(pimarchiveschangeMapping.toDomain(pimarchiveschangedto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESCHANGE-UpdatePersonFile-all')")
    @ApiOperation(value = "更新档案信息ByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESCHANGE" },  notes = "更新档案信息ByPIMPERSONPIMARCHIVES")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/{pimarchiveschange_id}/updatepersonfile")
    @Transactional
    public ResponseEntity<PIMARCHIVESCHANGEDTO> updatePersonFileByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchiveschange_id") String pimarchiveschange_id, @RequestBody PIMARCHIVESCHANGEDTO pimarchiveschangedto) {
        PIMARCHIVESCHANGE domain = pimarchiveschangeMapping.toDomain(pimarchiveschangedto);
        domain.setPimarchivesid(pimarchives_id);
        domain = pimarchiveschangeService.updatePersonFile(domain) ;
        pimarchiveschangedto = pimarchiveschangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangedto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedto),'ehr-PIMARCHIVESCHANGE-Save')")
    @ApiOperation(value = "SaveByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESCHANGE" },  notes = "SaveByPIMPERSONPIMARCHIVES")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/save")
    public ResponseEntity<Boolean> saveByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESCHANGEDTO pimarchiveschangedto) {
        PIMARCHIVESCHANGE domain = pimarchiveschangeMapping.toDomain(pimarchiveschangedto);
        domain.setPimarchivesid(pimarchives_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedtos),'ehr-PIMARCHIVESCHANGE-Save')")
    @ApiOperation(value = "SaveBatchByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESCHANGE" },  notes = "SaveBatchByPIMPERSONPIMARCHIVES")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PIMARCHIVESCHANGEDTO> pimarchiveschangedtos) {
        List<PIMARCHIVESCHANGE> domainlist=pimarchiveschangeMapping.toDomain(pimarchiveschangedtos);
        for(PIMARCHIVESCHANGE domain:domainlist){
             domain.setPimarchivesid(pimarchives_id);
        }
        pimarchiveschangeService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeService.get(#pimarchiveschange_id),'ehr-PIMARCHIVESCHANGE-Remove')")
    @ApiOperation(value = "RemoveByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESCHANGE" },  notes = "RemoveByPIMPERSONPIMARCHIVES")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/{pimarchiveschange_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchiveschange_id") String pimarchiveschange_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeService.remove(pimarchiveschange_id));
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeService.getPimarchiveschangeByIds(#ids),'ehr-PIMARCHIVESCHANGE-Remove')")
    @ApiOperation(value = "RemoveBatchByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESCHANGE" },  notes = "RemoveBatchByPIMPERSONPIMARCHIVES")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/batch")
    public ResponseEntity<Boolean> removeBatchByPIMPERSONPIMARCHIVES(@RequestBody List<String> ids) {
        pimarchiveschangeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESCHANGE-DADCJL-all')")
	@ApiOperation(value = "fetch档案调出记录ByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESCHANGE" } ,notes = "fetch档案调出记录ByPIMPERSONPIMARCHIVES")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/fetchdadcjl")
	public ResponseEntity<List<PIMARCHIVESCHANGEDTO>> fetchPIMARCHIVESCHANGEDADCJLByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id,PIMARCHIVESCHANGESearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PIMARCHIVESCHANGE> domains = pimarchiveschangeService.searchDADCJL(context) ;
        List<PIMARCHIVESCHANGEDTO> list = pimarchiveschangeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESCHANGE-DADCJL-all')")
	@ApiOperation(value = "search档案调出记录ByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESCHANGE" } ,notes = "search档案调出记录ByPIMPERSONPIMARCHIVES")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/searchdadcjl")
	public ResponseEntity<Page<PIMARCHIVESCHANGEDTO>> searchPIMARCHIVESCHANGEDADCJLByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESCHANGESearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PIMARCHIVESCHANGE> domains = pimarchiveschangeService.searchDADCJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchiveschangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESCHANGE-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESCHANGE" } ,notes = "fetchDEFAULTByPIMPERSONPIMARCHIVES")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/fetchdefault")
	public ResponseEntity<List<PIMARCHIVESCHANGEDTO>> fetchPIMARCHIVESCHANGEDefaultByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id,PIMARCHIVESCHANGESearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PIMARCHIVESCHANGE> domains = pimarchiveschangeService.searchDefault(context) ;
        List<PIMARCHIVESCHANGEDTO> list = pimarchiveschangeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESCHANGE-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESCHANGE" } ,notes = "searchDEFAULTByPIMPERSONPIMARCHIVES")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/searchdefault")
	public ResponseEntity<Page<PIMARCHIVESCHANGEDTO>> searchPIMARCHIVESCHANGEDefaultByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESCHANGESearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PIMARCHIVESCHANGE> domains = pimarchiveschangeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchiveschangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

