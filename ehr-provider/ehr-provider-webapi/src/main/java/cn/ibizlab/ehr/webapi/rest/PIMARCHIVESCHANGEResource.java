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
    @ApiOperation(value = "UpdateByPimArchives", tags = {"PIMARCHIVESCHANGE" },  notes = "UpdateByPimArchives")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/{pimarchiveschange_id}")
    @Transactional
    public ResponseEntity<PIMARCHIVESCHANGEDTO> updateByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchiveschange_id") String pimarchiveschange_id, @RequestBody PIMARCHIVESCHANGEDTO pimarchiveschangedto) {
        PIMARCHIVESCHANGE domain = pimarchiveschangeMapping.toDomain(pimarchiveschangedto);
        domain.setPimarchivesid(pimarchives_id);
        domain.setPimarchiveschangeid(pimarchiveschange_id);
		pimarchiveschangeService.update(domain);
        PIMARCHIVESCHANGEDTO dto = pimarchiveschangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeService.getPimarchiveschangeByEntities(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedtos)),'ehr-PIMARCHIVESCHANGE-Update')")
    @ApiOperation(value = "UpdateBatchByPimArchives", tags = {"PIMARCHIVESCHANGE" },  notes = "UpdateBatchByPimArchives")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/batch")
    public ResponseEntity<Boolean> updateBatchByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PIMARCHIVESCHANGEDTO> pimarchiveschangedtos) {
        List<PIMARCHIVESCHANGE> domainlist=pimarchiveschangeMapping.toDomain(pimarchiveschangedtos);
        for(PIMARCHIVESCHANGE domain:domainlist){
            domain.setPimarchivesid(pimarchives_id);
        }
        pimarchiveschangeService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(returnObject.body),'ehr-PIMARCHIVESCHANGE-Get')")
    @ApiOperation(value = "GetByPimArchives", tags = {"PIMARCHIVESCHANGE" },  notes = "GetByPimArchives")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/{pimarchiveschange_id}")
    public ResponseEntity<PIMARCHIVESCHANGEDTO> getByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchiveschange_id") String pimarchiveschange_id) {
        PIMARCHIVESCHANGE domain = pimarchiveschangeService.get(pimarchiveschange_id);
        PIMARCHIVESCHANGEDTO dto = pimarchiveschangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedto),'ehr-PIMARCHIVESCHANGE-Create')")
    @ApiOperation(value = "CreateByPimArchives", tags = {"PIMARCHIVESCHANGE" },  notes = "CreateByPimArchives")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges")
    @Transactional
    public ResponseEntity<PIMARCHIVESCHANGEDTO> createByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESCHANGEDTO pimarchiveschangedto) {
        PIMARCHIVESCHANGE domain = pimarchiveschangeMapping.toDomain(pimarchiveschangedto);
        domain.setPimarchivesid(pimarchives_id);
		pimarchiveschangeService.create(domain);
        PIMARCHIVESCHANGEDTO dto = pimarchiveschangeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedtos),'ehr-PIMARCHIVESCHANGE-Create')")
    @ApiOperation(value = "createBatchByPimArchives", tags = {"PIMARCHIVESCHANGE" },  notes = "createBatchByPimArchives")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/batch")
    public ResponseEntity<Boolean> createBatchByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PIMARCHIVESCHANGEDTO> pimarchiveschangedtos) {
        List<PIMARCHIVESCHANGE> domainlist=pimarchiveschangeMapping.toDomain(pimarchiveschangedtos);
        for(PIMARCHIVESCHANGE domain:domainlist){
            domain.setPimarchivesid(pimarchives_id);
        }
        pimarchiveschangeService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPimArchives", tags = {"PIMARCHIVESCHANGE" },  notes = "GetDraftByPimArchives")
    @RequestMapping(method = RequestMethod.GET, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/getdraft")
    public ResponseEntity<PIMARCHIVESCHANGEDTO> getDraftByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id) {
        PIMARCHIVESCHANGE domain = new PIMARCHIVESCHANGE();
        domain.setPimarchivesid(pimarchives_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeMapping.toDto(pimarchiveschangeService.getDraft(domain)));
    }

    @ApiOperation(value = "CheckKeyByPimArchives", tags = {"PIMARCHIVESCHANGE" },  notes = "CheckKeyByPimArchives")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESCHANGEDTO pimarchiveschangedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeService.checkKey(pimarchiveschangeMapping.toDomain(pimarchiveschangedto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESCHANGE-UpdatePersonFile-all')")
    @ApiOperation(value = "更新档案信息ByPimArchives", tags = {"PIMARCHIVESCHANGE" },  notes = "更新档案信息ByPimArchives")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/{pimarchiveschange_id}/updatepersonfile")
    @Transactional
    public ResponseEntity<PIMARCHIVESCHANGEDTO> updatePersonFileByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchiveschange_id") String pimarchiveschange_id, @RequestBody PIMARCHIVESCHANGEDTO pimarchiveschangedto) {
        PIMARCHIVESCHANGE domain = pimarchiveschangeMapping.toDomain(pimarchiveschangedto);
        domain.setPimarchivesid(pimarchives_id);
        domain = pimarchiveschangeService.updatePersonFile(domain) ;
        pimarchiveschangedto = pimarchiveschangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangedto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedto),'ehr-PIMARCHIVESCHANGE-Save')")
    @ApiOperation(value = "SaveByPimArchives", tags = {"PIMARCHIVESCHANGE" },  notes = "SaveByPimArchives")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/save")
    public ResponseEntity<Boolean> saveByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESCHANGEDTO pimarchiveschangedto) {
        PIMARCHIVESCHANGE domain = pimarchiveschangeMapping.toDomain(pimarchiveschangedto);
        domain.setPimarchivesid(pimarchives_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedtos),'ehr-PIMARCHIVESCHANGE-Save')")
    @ApiOperation(value = "SaveBatchByPimArchives", tags = {"PIMARCHIVESCHANGE" },  notes = "SaveBatchByPimArchives")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PIMARCHIVESCHANGEDTO> pimarchiveschangedtos) {
        List<PIMARCHIVESCHANGE> domainlist=pimarchiveschangeMapping.toDomain(pimarchiveschangedtos);
        for(PIMARCHIVESCHANGE domain:domainlist){
             domain.setPimarchivesid(pimarchives_id);
        }
        pimarchiveschangeService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeService.get(#pimarchiveschange_id),'ehr-PIMARCHIVESCHANGE-Remove')")
    @ApiOperation(value = "RemoveByPimArchives", tags = {"PIMARCHIVESCHANGE" },  notes = "RemoveByPimArchives")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/{pimarchiveschange_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchiveschange_id") String pimarchiveschange_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeService.remove(pimarchiveschange_id));
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeService.getPimarchiveschangeByIds(#ids),'ehr-PIMARCHIVESCHANGE-Remove')")
    @ApiOperation(value = "RemoveBatchByPimArchives", tags = {"PIMARCHIVESCHANGE" },  notes = "RemoveBatchByPimArchives")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/batch")
    public ResponseEntity<Boolean> removeBatchByPimArchives(@RequestBody List<String> ids) {
        pimarchiveschangeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESCHANGE-DADCJL-all')")
	@ApiOperation(value = "fetch档案调出记录ByPimArchives", tags = {"PIMARCHIVESCHANGE" } ,notes = "fetch档案调出记录ByPimArchives")
    @RequestMapping(method= RequestMethod.GET , value="/pimarchives/{pimarchives_id}/pimarchiveschanges/fetchdadcjl")
	public ResponseEntity<List<PIMARCHIVESCHANGEDTO>> fetchPIMARCHIVESCHANGEDADCJLByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id,PIMARCHIVESCHANGESearchContext context) {
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
	@ApiOperation(value = "search档案调出记录ByPimArchives", tags = {"PIMARCHIVESCHANGE" } ,notes = "search档案调出记录ByPimArchives")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchives/{pimarchives_id}/pimarchiveschanges/searchdadcjl")
	public ResponseEntity<Page<PIMARCHIVESCHANGEDTO>> searchPIMARCHIVESCHANGEDADCJLByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESCHANGESearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PIMARCHIVESCHANGE> domains = pimarchiveschangeService.searchDADCJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchiveschangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESCHANGE-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPimArchives", tags = {"PIMARCHIVESCHANGE" } ,notes = "fetchDEFAULTByPimArchives")
    @RequestMapping(method= RequestMethod.GET , value="/pimarchives/{pimarchives_id}/pimarchiveschanges/fetchdefault")
	public ResponseEntity<List<PIMARCHIVESCHANGEDTO>> fetchPIMARCHIVESCHANGEDefaultByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id,PIMARCHIVESCHANGESearchContext context) {
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
	@ApiOperation(value = "searchDEFAULTByPimArchives", tags = {"PIMARCHIVESCHANGE" } ,notes = "searchDEFAULTByPimArchives")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchives/{pimarchives_id}/pimarchiveschanges/searchdefault")
	public ResponseEntity<Page<PIMARCHIVESCHANGEDTO>> searchPIMARCHIVESCHANGEDefaultByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESCHANGESearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PIMARCHIVESCHANGE> domains = pimarchiveschangeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchiveschangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pimarchiveschangeService.get(#pimarchiveschange_id),'ehr-PIMARCHIVESCHANGE-Update')")
    @ApiOperation(value = "UpdateByPIMPERSONPimArchives", tags = {"PIMARCHIVESCHANGE" },  notes = "UpdateByPIMPERSONPimArchives")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/{pimarchiveschange_id}")
    @Transactional
    public ResponseEntity<PIMARCHIVESCHANGEDTO> updateByPIMPERSONPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchiveschange_id") String pimarchiveschange_id, @RequestBody PIMARCHIVESCHANGEDTO pimarchiveschangedto) {
        PIMARCHIVESCHANGE domain = pimarchiveschangeMapping.toDomain(pimarchiveschangedto);
        domain.setPimarchivesid(pimarchives_id);
        domain.setPimarchiveschangeid(pimarchiveschange_id);
		pimarchiveschangeService.update(domain);
        PIMARCHIVESCHANGEDTO dto = pimarchiveschangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeService.getPimarchiveschangeByEntities(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedtos)),'ehr-PIMARCHIVESCHANGE-Update')")
    @ApiOperation(value = "UpdateBatchByPIMPERSONPimArchives", tags = {"PIMARCHIVESCHANGE" },  notes = "UpdateBatchByPIMPERSONPimArchives")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/batch")
    public ResponseEntity<Boolean> updateBatchByPIMPERSONPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PIMARCHIVESCHANGEDTO> pimarchiveschangedtos) {
        List<PIMARCHIVESCHANGE> domainlist=pimarchiveschangeMapping.toDomain(pimarchiveschangedtos);
        for(PIMARCHIVESCHANGE domain:domainlist){
            domain.setPimarchivesid(pimarchives_id);
        }
        pimarchiveschangeService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(returnObject.body),'ehr-PIMARCHIVESCHANGE-Get')")
    @ApiOperation(value = "GetByPIMPERSONPimArchives", tags = {"PIMARCHIVESCHANGE" },  notes = "GetByPIMPERSONPimArchives")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/{pimarchiveschange_id}")
    public ResponseEntity<PIMARCHIVESCHANGEDTO> getByPIMPERSONPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchiveschange_id") String pimarchiveschange_id) {
        PIMARCHIVESCHANGE domain = pimarchiveschangeService.get(pimarchiveschange_id);
        PIMARCHIVESCHANGEDTO dto = pimarchiveschangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedto),'ehr-PIMARCHIVESCHANGE-Create')")
    @ApiOperation(value = "CreateByPIMPERSONPimArchives", tags = {"PIMARCHIVESCHANGE" },  notes = "CreateByPIMPERSONPimArchives")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges")
    @Transactional
    public ResponseEntity<PIMARCHIVESCHANGEDTO> createByPIMPERSONPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESCHANGEDTO pimarchiveschangedto) {
        PIMARCHIVESCHANGE domain = pimarchiveschangeMapping.toDomain(pimarchiveschangedto);
        domain.setPimarchivesid(pimarchives_id);
		pimarchiveschangeService.create(domain);
        PIMARCHIVESCHANGEDTO dto = pimarchiveschangeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedtos),'ehr-PIMARCHIVESCHANGE-Create')")
    @ApiOperation(value = "createBatchByPIMPERSONPimArchives", tags = {"PIMARCHIVESCHANGE" },  notes = "createBatchByPIMPERSONPimArchives")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/batch")
    public ResponseEntity<Boolean> createBatchByPIMPERSONPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PIMARCHIVESCHANGEDTO> pimarchiveschangedtos) {
        List<PIMARCHIVESCHANGE> domainlist=pimarchiveschangeMapping.toDomain(pimarchiveschangedtos);
        for(PIMARCHIVESCHANGE domain:domainlist){
            domain.setPimarchivesid(pimarchives_id);
        }
        pimarchiveschangeService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPIMPERSONPimArchives", tags = {"PIMARCHIVESCHANGE" },  notes = "GetDraftByPIMPERSONPimArchives")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/getdraft")
    public ResponseEntity<PIMARCHIVESCHANGEDTO> getDraftByPIMPERSONPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id) {
        PIMARCHIVESCHANGE domain = new PIMARCHIVESCHANGE();
        domain.setPimarchivesid(pimarchives_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeMapping.toDto(pimarchiveschangeService.getDraft(domain)));
    }

    @ApiOperation(value = "CheckKeyByPIMPERSONPimArchives", tags = {"PIMARCHIVESCHANGE" },  notes = "CheckKeyByPIMPERSONPimArchives")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMPERSONPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESCHANGEDTO pimarchiveschangedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeService.checkKey(pimarchiveschangeMapping.toDomain(pimarchiveschangedto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESCHANGE-UpdatePersonFile-all')")
    @ApiOperation(value = "更新档案信息ByPIMPERSONPimArchives", tags = {"PIMARCHIVESCHANGE" },  notes = "更新档案信息ByPIMPERSONPimArchives")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/{pimarchiveschange_id}/updatepersonfile")
    @Transactional
    public ResponseEntity<PIMARCHIVESCHANGEDTO> updatePersonFileByPIMPERSONPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchiveschange_id") String pimarchiveschange_id, @RequestBody PIMARCHIVESCHANGEDTO pimarchiveschangedto) {
        PIMARCHIVESCHANGE domain = pimarchiveschangeMapping.toDomain(pimarchiveschangedto);
        domain.setPimarchivesid(pimarchives_id);
        domain = pimarchiveschangeService.updatePersonFile(domain) ;
        pimarchiveschangedto = pimarchiveschangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangedto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedto),'ehr-PIMARCHIVESCHANGE-Save')")
    @ApiOperation(value = "SaveByPIMPERSONPimArchives", tags = {"PIMARCHIVESCHANGE" },  notes = "SaveByPIMPERSONPimArchives")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/save")
    public ResponseEntity<Boolean> saveByPIMPERSONPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESCHANGEDTO pimarchiveschangedto) {
        PIMARCHIVESCHANGE domain = pimarchiveschangeMapping.toDomain(pimarchiveschangedto);
        domain.setPimarchivesid(pimarchives_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedtos),'ehr-PIMARCHIVESCHANGE-Save')")
    @ApiOperation(value = "SaveBatchByPIMPERSONPimArchives", tags = {"PIMARCHIVESCHANGE" },  notes = "SaveBatchByPIMPERSONPimArchives")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMPERSONPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PIMARCHIVESCHANGEDTO> pimarchiveschangedtos) {
        List<PIMARCHIVESCHANGE> domainlist=pimarchiveschangeMapping.toDomain(pimarchiveschangedtos);
        for(PIMARCHIVESCHANGE domain:domainlist){
             domain.setPimarchivesid(pimarchives_id);
        }
        pimarchiveschangeService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeService.get(#pimarchiveschange_id),'ehr-PIMARCHIVESCHANGE-Remove')")
    @ApiOperation(value = "RemoveByPIMPERSONPimArchives", tags = {"PIMARCHIVESCHANGE" },  notes = "RemoveByPIMPERSONPimArchives")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/{pimarchiveschange_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMPERSONPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchiveschange_id") String pimarchiveschange_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeService.remove(pimarchiveschange_id));
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeService.getPimarchiveschangeByIds(#ids),'ehr-PIMARCHIVESCHANGE-Remove')")
    @ApiOperation(value = "RemoveBatchByPIMPERSONPimArchives", tags = {"PIMARCHIVESCHANGE" },  notes = "RemoveBatchByPIMPERSONPimArchives")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/batch")
    public ResponseEntity<Boolean> removeBatchByPIMPERSONPimArchives(@RequestBody List<String> ids) {
        pimarchiveschangeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESCHANGE-DADCJL-all')")
	@ApiOperation(value = "fetch档案调出记录ByPIMPERSONPimArchives", tags = {"PIMARCHIVESCHANGE" } ,notes = "fetch档案调出记录ByPIMPERSONPimArchives")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/fetchdadcjl")
	public ResponseEntity<List<PIMARCHIVESCHANGEDTO>> fetchPIMARCHIVESCHANGEDADCJLByPIMPERSONPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id,PIMARCHIVESCHANGESearchContext context) {
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
	@ApiOperation(value = "search档案调出记录ByPIMPERSONPimArchives", tags = {"PIMARCHIVESCHANGE" } ,notes = "search档案调出记录ByPIMPERSONPimArchives")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/searchdadcjl")
	public ResponseEntity<Page<PIMARCHIVESCHANGEDTO>> searchPIMARCHIVESCHANGEDADCJLByPIMPERSONPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESCHANGESearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PIMARCHIVESCHANGE> domains = pimarchiveschangeService.searchDADCJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchiveschangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESCHANGE-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPIMPERSONPimArchives", tags = {"PIMARCHIVESCHANGE" } ,notes = "fetchDEFAULTByPIMPERSONPimArchives")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/fetchdefault")
	public ResponseEntity<List<PIMARCHIVESCHANGEDTO>> fetchPIMARCHIVESCHANGEDefaultByPIMPERSONPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id,PIMARCHIVESCHANGESearchContext context) {
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
	@ApiOperation(value = "searchDEFAULTByPIMPERSONPimArchives", tags = {"PIMARCHIVESCHANGE" } ,notes = "searchDEFAULTByPIMPERSONPimArchives")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/searchdefault")
	public ResponseEntity<Page<PIMARCHIVESCHANGEDTO>> searchPIMARCHIVESCHANGEDefaultByPIMPERSONPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESCHANGESearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PIMARCHIVESCHANGE> domains = pimarchiveschangeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchiveschangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

