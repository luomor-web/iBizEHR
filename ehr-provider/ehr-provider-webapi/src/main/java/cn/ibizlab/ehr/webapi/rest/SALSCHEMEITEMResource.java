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
import cn.ibizlab.ehr.core.sal.domain.SALSCHEMEITEM;
import cn.ibizlab.ehr.core.sal.service.ISALSCHEMEITEMService;
import cn.ibizlab.ehr.core.sal.filter.SALSCHEMEITEMSearchContext;

@Slf4j
@Api(tags = {"SALSCHEMEITEM" })
@RestController("WebApi-salschemeitem")
@RequestMapping("")
public class SALSCHEMEITEMResource {

    @Autowired
    public ISALSCHEMEITEMService salschemeitemService;

    @Autowired
    @Lazy
    public SALSCHEMEITEMMapping salschemeitemMapping;

    @PreAuthorize("hasPermission(this.salschemeitemService.get(#salschemeitem_id),'ehr-SALSCHEMEITEM-Update')")
    @ApiOperation(value = "Update", tags = {"SALSCHEMEITEM" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/salschemeitems/{salschemeitem_id}")
    @Transactional
    public ResponseEntity<SALSCHEMEITEMDTO> update(@PathVariable("salschemeitem_id") String salschemeitem_id, @RequestBody SALSCHEMEITEMDTO salschemeitemdto) {
		SALSCHEMEITEM domain  = salschemeitemMapping.toDomain(salschemeitemdto);
        domain .setSalschemeitemid(salschemeitem_id);
		salschemeitemService.update(domain );
		SALSCHEMEITEMDTO dto = salschemeitemMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salschemeitemService.getSalschemeitemByEntities(this.salschemeitemMapping.toDomain(#salschemeitemdtos)),'ehr-SALSCHEMEITEM-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"SALSCHEMEITEM" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/salschemeitems/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SALSCHEMEITEMDTO> salschemeitemdtos) {
        salschemeitemService.updateBatch(salschemeitemMapping.toDomain(salschemeitemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salschemeitemMapping.toDomain(#salschemeitemdto),'ehr-SALSCHEMEITEM-Save')")
    @ApiOperation(value = "Save", tags = {"SALSCHEMEITEM" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemeitems/save")
    public ResponseEntity<Boolean> save(@RequestBody SALSCHEMEITEMDTO salschemeitemdto) {
        return ResponseEntity.status(HttpStatus.OK).body(salschemeitemService.save(salschemeitemMapping.toDomain(salschemeitemdto)));
    }

    @PreAuthorize("hasPermission(this.salschemeitemMapping.toDomain(#salschemeitemdtos),'ehr-SALSCHEMEITEM-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"SALSCHEMEITEM" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemeitems/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SALSCHEMEITEMDTO> salschemeitemdtos) {
        salschemeitemService.saveBatch(salschemeitemMapping.toDomain(salschemeitemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.salschemeitemMapping.toDomain(returnObject.body),'ehr-SALSCHEMEITEM-Get')")
    @ApiOperation(value = "Get", tags = {"SALSCHEMEITEM" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/salschemeitems/{salschemeitem_id}")
    public ResponseEntity<SALSCHEMEITEMDTO> get(@PathVariable("salschemeitem_id") String salschemeitem_id) {
        SALSCHEMEITEM domain = salschemeitemService.get(salschemeitem_id);
        SALSCHEMEITEMDTO dto = salschemeitemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salschemeitemService.get(#salschemeitem_id),'ehr-SALSCHEMEITEM-Remove')")
    @ApiOperation(value = "Remove", tags = {"SALSCHEMEITEM" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salschemeitems/{salschemeitem_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salschemeitem_id") String salschemeitem_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salschemeitemService.remove(salschemeitem_id));
    }

    @PreAuthorize("hasPermission(this.salschemeitemService.getSalschemeitemByIds(#ids),'ehr-SALSCHEMEITEM-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"SALSCHEMEITEM" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salschemeitems/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salschemeitemService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"SALSCHEMEITEM" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemeitems/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SALSCHEMEITEMDTO salschemeitemdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salschemeitemService.checkKey(salschemeitemMapping.toDomain(salschemeitemdto)));
    }

    @PreAuthorize("hasPermission(this.salschemeitemMapping.toDomain(#salschemeitemdto),'ehr-SALSCHEMEITEM-Create')")
    @ApiOperation(value = "Create", tags = {"SALSCHEMEITEM" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemeitems")
    @Transactional
    public ResponseEntity<SALSCHEMEITEMDTO> create(@RequestBody SALSCHEMEITEMDTO salschemeitemdto) {
        SALSCHEMEITEM domain = salschemeitemMapping.toDomain(salschemeitemdto);
		salschemeitemService.create(domain);
        SALSCHEMEITEMDTO dto = salschemeitemMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salschemeitemMapping.toDomain(#salschemeitemdtos),'ehr-SALSCHEMEITEM-Create')")
    @ApiOperation(value = "createBatch", tags = {"SALSCHEMEITEM" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemeitems/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SALSCHEMEITEMDTO> salschemeitemdtos) {
        salschemeitemService.createBatch(salschemeitemMapping.toDomain(salschemeitemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"SALSCHEMEITEM" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/salschemeitems/getdraft")
    public ResponseEntity<SALSCHEMEITEMDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salschemeitemMapping.toDto(salschemeitemService.getDraft(new SALSCHEMEITEM())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSCHEMEITEM-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SALSCHEMEITEM" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salschemeitems/fetchdefault")
	public ResponseEntity<List<SALSCHEMEITEMDTO>> fetchDefault(SALSCHEMEITEMSearchContext context) {
        Page<SALSCHEMEITEM> domains = salschemeitemService.searchDefault(context) ;
        List<SALSCHEMEITEMDTO> list = salschemeitemMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSCHEMEITEM-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SALSCHEMEITEM" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salschemeitems/searchdefault")
	public ResponseEntity<Page<SALSCHEMEITEMDTO>> searchDefault(@RequestBody SALSCHEMEITEMSearchContext context) {
        Page<SALSCHEMEITEM> domains = salschemeitemService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salschemeitemMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.salschemeitemService.get(#salschemeitem_id),'ehr-SALSCHEMEITEM-Update')")
    @ApiOperation(value = "UpdateBySALITEM", tags = {"SALSCHEMEITEM" },  notes = "UpdateBySALITEM")
	@RequestMapping(method = RequestMethod.PUT, value = "/salitems/{salitem_id}/salschemeitems/{salschemeitem_id}")
    @Transactional
    public ResponseEntity<SALSCHEMEITEMDTO> updateBySALITEM(@PathVariable("salitem_id") String salitem_id, @PathVariable("salschemeitem_id") String salschemeitem_id, @RequestBody SALSCHEMEITEMDTO salschemeitemdto) {
        SALSCHEMEITEM domain = salschemeitemMapping.toDomain(salschemeitemdto);
        domain.setSalitemid(salitem_id);
        domain.setSalschemeitemid(salschemeitem_id);
		salschemeitemService.update(domain);
        SALSCHEMEITEMDTO dto = salschemeitemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salschemeitemService.getSalschemeitemByEntities(this.salschemeitemMapping.toDomain(#salschemeitemdtos)),'ehr-SALSCHEMEITEM-Update')")
    @ApiOperation(value = "UpdateBatchBySALITEM", tags = {"SALSCHEMEITEM" },  notes = "UpdateBatchBySALITEM")
	@RequestMapping(method = RequestMethod.PUT, value = "/salitems/{salitem_id}/salschemeitems/batch")
    public ResponseEntity<Boolean> updateBatchBySALITEM(@PathVariable("salitem_id") String salitem_id, @RequestBody List<SALSCHEMEITEMDTO> salschemeitemdtos) {
        List<SALSCHEMEITEM> domainlist=salschemeitemMapping.toDomain(salschemeitemdtos);
        for(SALSCHEMEITEM domain:domainlist){
            domain.setSalitemid(salitem_id);
        }
        salschemeitemService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salschemeitemMapping.toDomain(#salschemeitemdto),'ehr-SALSCHEMEITEM-Save')")
    @ApiOperation(value = "SaveBySALITEM", tags = {"SALSCHEMEITEM" },  notes = "SaveBySALITEM")
	@RequestMapping(method = RequestMethod.POST, value = "/salitems/{salitem_id}/salschemeitems/save")
    public ResponseEntity<Boolean> saveBySALITEM(@PathVariable("salitem_id") String salitem_id, @RequestBody SALSCHEMEITEMDTO salschemeitemdto) {
        SALSCHEMEITEM domain = salschemeitemMapping.toDomain(salschemeitemdto);
        domain.setSalitemid(salitem_id);
        return ResponseEntity.status(HttpStatus.OK).body(salschemeitemService.save(domain));
    }

    @PreAuthorize("hasPermission(this.salschemeitemMapping.toDomain(#salschemeitemdtos),'ehr-SALSCHEMEITEM-Save')")
    @ApiOperation(value = "SaveBatchBySALITEM", tags = {"SALSCHEMEITEM" },  notes = "SaveBatchBySALITEM")
	@RequestMapping(method = RequestMethod.POST, value = "/salitems/{salitem_id}/salschemeitems/savebatch")
    public ResponseEntity<Boolean> saveBatchBySALITEM(@PathVariable("salitem_id") String salitem_id, @RequestBody List<SALSCHEMEITEMDTO> salschemeitemdtos) {
        List<SALSCHEMEITEM> domainlist=salschemeitemMapping.toDomain(salschemeitemdtos);
        for(SALSCHEMEITEM domain:domainlist){
             domain.setSalitemid(salitem_id);
        }
        salschemeitemService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.salschemeitemMapping.toDomain(returnObject.body),'ehr-SALSCHEMEITEM-Get')")
    @ApiOperation(value = "GetBySALITEM", tags = {"SALSCHEMEITEM" },  notes = "GetBySALITEM")
	@RequestMapping(method = RequestMethod.GET, value = "/salitems/{salitem_id}/salschemeitems/{salschemeitem_id}")
    public ResponseEntity<SALSCHEMEITEMDTO> getBySALITEM(@PathVariable("salitem_id") String salitem_id, @PathVariable("salschemeitem_id") String salschemeitem_id) {
        SALSCHEMEITEM domain = salschemeitemService.get(salschemeitem_id);
        SALSCHEMEITEMDTO dto = salschemeitemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salschemeitemService.get(#salschemeitem_id),'ehr-SALSCHEMEITEM-Remove')")
    @ApiOperation(value = "RemoveBySALITEM", tags = {"SALSCHEMEITEM" },  notes = "RemoveBySALITEM")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salitems/{salitem_id}/salschemeitems/{salschemeitem_id}")
    @Transactional
    public ResponseEntity<Boolean> removeBySALITEM(@PathVariable("salitem_id") String salitem_id, @PathVariable("salschemeitem_id") String salschemeitem_id) {
		return ResponseEntity.status(HttpStatus.OK).body(salschemeitemService.remove(salschemeitem_id));
    }

    @PreAuthorize("hasPermission(this.salschemeitemService.getSalschemeitemByIds(#ids),'ehr-SALSCHEMEITEM-Remove')")
    @ApiOperation(value = "RemoveBatchBySALITEM", tags = {"SALSCHEMEITEM" },  notes = "RemoveBatchBySALITEM")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salitems/{salitem_id}/salschemeitems/batch")
    public ResponseEntity<Boolean> removeBatchBySALITEM(@RequestBody List<String> ids) {
        salschemeitemService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyBySALITEM", tags = {"SALSCHEMEITEM" },  notes = "CheckKeyBySALITEM")
	@RequestMapping(method = RequestMethod.POST, value = "/salitems/{salitem_id}/salschemeitems/checkkey")
    public ResponseEntity<Boolean> checkKeyBySALITEM(@PathVariable("salitem_id") String salitem_id, @RequestBody SALSCHEMEITEMDTO salschemeitemdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salschemeitemService.checkKey(salschemeitemMapping.toDomain(salschemeitemdto)));
    }

    @PreAuthorize("hasPermission(this.salschemeitemMapping.toDomain(#salschemeitemdto),'ehr-SALSCHEMEITEM-Create')")
    @ApiOperation(value = "CreateBySALITEM", tags = {"SALSCHEMEITEM" },  notes = "CreateBySALITEM")
	@RequestMapping(method = RequestMethod.POST, value = "/salitems/{salitem_id}/salschemeitems")
    @Transactional
    public ResponseEntity<SALSCHEMEITEMDTO> createBySALITEM(@PathVariable("salitem_id") String salitem_id, @RequestBody SALSCHEMEITEMDTO salschemeitemdto) {
        SALSCHEMEITEM domain = salschemeitemMapping.toDomain(salschemeitemdto);
        domain.setSalitemid(salitem_id);
		salschemeitemService.create(domain);
        SALSCHEMEITEMDTO dto = salschemeitemMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salschemeitemMapping.toDomain(#salschemeitemdtos),'ehr-SALSCHEMEITEM-Create')")
    @ApiOperation(value = "createBatchBySALITEM", tags = {"SALSCHEMEITEM" },  notes = "createBatchBySALITEM")
	@RequestMapping(method = RequestMethod.POST, value = "/salitems/{salitem_id}/salschemeitems/batch")
    public ResponseEntity<Boolean> createBatchBySALITEM(@PathVariable("salitem_id") String salitem_id, @RequestBody List<SALSCHEMEITEMDTO> salschemeitemdtos) {
        List<SALSCHEMEITEM> domainlist=salschemeitemMapping.toDomain(salschemeitemdtos);
        for(SALSCHEMEITEM domain:domainlist){
            domain.setSalitemid(salitem_id);
        }
        salschemeitemService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftBySALITEM", tags = {"SALSCHEMEITEM" },  notes = "GetDraftBySALITEM")
    @RequestMapping(method = RequestMethod.GET, value = "/salitems/{salitem_id}/salschemeitems/getdraft")
    public ResponseEntity<SALSCHEMEITEMDTO> getDraftBySALITEM(@PathVariable("salitem_id") String salitem_id) {
        SALSCHEMEITEM domain = new SALSCHEMEITEM();
        domain.setSalitemid(salitem_id);
        return ResponseEntity.status(HttpStatus.OK).body(salschemeitemMapping.toDto(salschemeitemService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSCHEMEITEM-Default-all')")
	@ApiOperation(value = "fetchDEFAULTBySALITEM", tags = {"SALSCHEMEITEM" } ,notes = "fetchDEFAULTBySALITEM")
    @RequestMapping(method= RequestMethod.GET , value="/salitems/{salitem_id}/salschemeitems/fetchdefault")
	public ResponseEntity<List<SALSCHEMEITEMDTO>> fetchSALSCHEMEITEMDefaultBySALITEM(@PathVariable("salitem_id") String salitem_id,SALSCHEMEITEMSearchContext context) {
        context.setN_salitemid_eq(salitem_id);
        Page<SALSCHEMEITEM> domains = salschemeitemService.searchDefault(context) ;
        List<SALSCHEMEITEMDTO> list = salschemeitemMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSCHEMEITEM-Default-all')")
	@ApiOperation(value = "searchDEFAULTBySALITEM", tags = {"SALSCHEMEITEM" } ,notes = "searchDEFAULTBySALITEM")
    @RequestMapping(method= RequestMethod.POST , value="/salitems/{salitem_id}/salschemeitems/searchdefault")
	public ResponseEntity<Page<SALSCHEMEITEMDTO>> searchSALSCHEMEITEMDefaultBySALITEM(@PathVariable("salitem_id") String salitem_id, @RequestBody SALSCHEMEITEMSearchContext context) {
        context.setN_salitemid_eq(salitem_id);
        Page<SALSCHEMEITEM> domains = salschemeitemService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salschemeitemMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.salschemeitemService.get(#salschemeitem_id),'ehr-SALSCHEMEITEM-Update')")
    @ApiOperation(value = "UpdateBySALSCHEME", tags = {"SALSCHEMEITEM" },  notes = "UpdateBySALSCHEME")
	@RequestMapping(method = RequestMethod.PUT, value = "/salschemes/{salscheme_id}/salschemeitems/{salschemeitem_id}")
    @Transactional
    public ResponseEntity<SALSCHEMEITEMDTO> updateBySALSCHEME(@PathVariable("salscheme_id") String salscheme_id, @PathVariable("salschemeitem_id") String salschemeitem_id, @RequestBody SALSCHEMEITEMDTO salschemeitemdto) {
        SALSCHEMEITEM domain = salschemeitemMapping.toDomain(salschemeitemdto);
        domain.setSalschemeid(salscheme_id);
        domain.setSalschemeitemid(salschemeitem_id);
		salschemeitemService.update(domain);
        SALSCHEMEITEMDTO dto = salschemeitemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salschemeitemService.getSalschemeitemByEntities(this.salschemeitemMapping.toDomain(#salschemeitemdtos)),'ehr-SALSCHEMEITEM-Update')")
    @ApiOperation(value = "UpdateBatchBySALSCHEME", tags = {"SALSCHEMEITEM" },  notes = "UpdateBatchBySALSCHEME")
	@RequestMapping(method = RequestMethod.PUT, value = "/salschemes/{salscheme_id}/salschemeitems/batch")
    public ResponseEntity<Boolean> updateBatchBySALSCHEME(@PathVariable("salscheme_id") String salscheme_id, @RequestBody List<SALSCHEMEITEMDTO> salschemeitemdtos) {
        List<SALSCHEMEITEM> domainlist=salschemeitemMapping.toDomain(salschemeitemdtos);
        for(SALSCHEMEITEM domain:domainlist){
            domain.setSalschemeid(salscheme_id);
        }
        salschemeitemService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salschemeitemMapping.toDomain(#salschemeitemdto),'ehr-SALSCHEMEITEM-Save')")
    @ApiOperation(value = "SaveBySALSCHEME", tags = {"SALSCHEMEITEM" },  notes = "SaveBySALSCHEME")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemes/{salscheme_id}/salschemeitems/save")
    public ResponseEntity<Boolean> saveBySALSCHEME(@PathVariable("salscheme_id") String salscheme_id, @RequestBody SALSCHEMEITEMDTO salschemeitemdto) {
        SALSCHEMEITEM domain = salschemeitemMapping.toDomain(salschemeitemdto);
        domain.setSalschemeid(salscheme_id);
        return ResponseEntity.status(HttpStatus.OK).body(salschemeitemService.save(domain));
    }

    @PreAuthorize("hasPermission(this.salschemeitemMapping.toDomain(#salschemeitemdtos),'ehr-SALSCHEMEITEM-Save')")
    @ApiOperation(value = "SaveBatchBySALSCHEME", tags = {"SALSCHEMEITEM" },  notes = "SaveBatchBySALSCHEME")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemes/{salscheme_id}/salschemeitems/savebatch")
    public ResponseEntity<Boolean> saveBatchBySALSCHEME(@PathVariable("salscheme_id") String salscheme_id, @RequestBody List<SALSCHEMEITEMDTO> salschemeitemdtos) {
        List<SALSCHEMEITEM> domainlist=salschemeitemMapping.toDomain(salschemeitemdtos);
        for(SALSCHEMEITEM domain:domainlist){
             domain.setSalschemeid(salscheme_id);
        }
        salschemeitemService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.salschemeitemMapping.toDomain(returnObject.body),'ehr-SALSCHEMEITEM-Get')")
    @ApiOperation(value = "GetBySALSCHEME", tags = {"SALSCHEMEITEM" },  notes = "GetBySALSCHEME")
	@RequestMapping(method = RequestMethod.GET, value = "/salschemes/{salscheme_id}/salschemeitems/{salschemeitem_id}")
    public ResponseEntity<SALSCHEMEITEMDTO> getBySALSCHEME(@PathVariable("salscheme_id") String salscheme_id, @PathVariable("salschemeitem_id") String salschemeitem_id) {
        SALSCHEMEITEM domain = salschemeitemService.get(salschemeitem_id);
        SALSCHEMEITEMDTO dto = salschemeitemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salschemeitemService.get(#salschemeitem_id),'ehr-SALSCHEMEITEM-Remove')")
    @ApiOperation(value = "RemoveBySALSCHEME", tags = {"SALSCHEMEITEM" },  notes = "RemoveBySALSCHEME")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salschemes/{salscheme_id}/salschemeitems/{salschemeitem_id}")
    @Transactional
    public ResponseEntity<Boolean> removeBySALSCHEME(@PathVariable("salscheme_id") String salscheme_id, @PathVariable("salschemeitem_id") String salschemeitem_id) {
		return ResponseEntity.status(HttpStatus.OK).body(salschemeitemService.remove(salschemeitem_id));
    }

    @PreAuthorize("hasPermission(this.salschemeitemService.getSalschemeitemByIds(#ids),'ehr-SALSCHEMEITEM-Remove')")
    @ApiOperation(value = "RemoveBatchBySALSCHEME", tags = {"SALSCHEMEITEM" },  notes = "RemoveBatchBySALSCHEME")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salschemes/{salscheme_id}/salschemeitems/batch")
    public ResponseEntity<Boolean> removeBatchBySALSCHEME(@RequestBody List<String> ids) {
        salschemeitemService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyBySALSCHEME", tags = {"SALSCHEMEITEM" },  notes = "CheckKeyBySALSCHEME")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemes/{salscheme_id}/salschemeitems/checkkey")
    public ResponseEntity<Boolean> checkKeyBySALSCHEME(@PathVariable("salscheme_id") String salscheme_id, @RequestBody SALSCHEMEITEMDTO salschemeitemdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salschemeitemService.checkKey(salschemeitemMapping.toDomain(salschemeitemdto)));
    }

    @PreAuthorize("hasPermission(this.salschemeitemMapping.toDomain(#salschemeitemdto),'ehr-SALSCHEMEITEM-Create')")
    @ApiOperation(value = "CreateBySALSCHEME", tags = {"SALSCHEMEITEM" },  notes = "CreateBySALSCHEME")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemes/{salscheme_id}/salschemeitems")
    @Transactional
    public ResponseEntity<SALSCHEMEITEMDTO> createBySALSCHEME(@PathVariable("salscheme_id") String salscheme_id, @RequestBody SALSCHEMEITEMDTO salschemeitemdto) {
        SALSCHEMEITEM domain = salschemeitemMapping.toDomain(salschemeitemdto);
        domain.setSalschemeid(salscheme_id);
		salschemeitemService.create(domain);
        SALSCHEMEITEMDTO dto = salschemeitemMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salschemeitemMapping.toDomain(#salschemeitemdtos),'ehr-SALSCHEMEITEM-Create')")
    @ApiOperation(value = "createBatchBySALSCHEME", tags = {"SALSCHEMEITEM" },  notes = "createBatchBySALSCHEME")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemes/{salscheme_id}/salschemeitems/batch")
    public ResponseEntity<Boolean> createBatchBySALSCHEME(@PathVariable("salscheme_id") String salscheme_id, @RequestBody List<SALSCHEMEITEMDTO> salschemeitemdtos) {
        List<SALSCHEMEITEM> domainlist=salschemeitemMapping.toDomain(salschemeitemdtos);
        for(SALSCHEMEITEM domain:domainlist){
            domain.setSalschemeid(salscheme_id);
        }
        salschemeitemService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftBySALSCHEME", tags = {"SALSCHEMEITEM" },  notes = "GetDraftBySALSCHEME")
    @RequestMapping(method = RequestMethod.GET, value = "/salschemes/{salscheme_id}/salschemeitems/getdraft")
    public ResponseEntity<SALSCHEMEITEMDTO> getDraftBySALSCHEME(@PathVariable("salscheme_id") String salscheme_id) {
        SALSCHEMEITEM domain = new SALSCHEMEITEM();
        domain.setSalschemeid(salscheme_id);
        return ResponseEntity.status(HttpStatus.OK).body(salschemeitemMapping.toDto(salschemeitemService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSCHEMEITEM-Default-all')")
	@ApiOperation(value = "fetchDEFAULTBySALSCHEME", tags = {"SALSCHEMEITEM" } ,notes = "fetchDEFAULTBySALSCHEME")
    @RequestMapping(method= RequestMethod.GET , value="/salschemes/{salscheme_id}/salschemeitems/fetchdefault")
	public ResponseEntity<List<SALSCHEMEITEMDTO>> fetchSALSCHEMEITEMDefaultBySALSCHEME(@PathVariable("salscheme_id") String salscheme_id,SALSCHEMEITEMSearchContext context) {
        context.setN_salschemeid_eq(salscheme_id);
        Page<SALSCHEMEITEM> domains = salschemeitemService.searchDefault(context) ;
        List<SALSCHEMEITEMDTO> list = salschemeitemMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSCHEMEITEM-Default-all')")
	@ApiOperation(value = "searchDEFAULTBySALSCHEME", tags = {"SALSCHEMEITEM" } ,notes = "searchDEFAULTBySALSCHEME")
    @RequestMapping(method= RequestMethod.POST , value="/salschemes/{salscheme_id}/salschemeitems/searchdefault")
	public ResponseEntity<Page<SALSCHEMEITEMDTO>> searchSALSCHEMEITEMDefaultBySALSCHEME(@PathVariable("salscheme_id") String salscheme_id, @RequestBody SALSCHEMEITEMSearchContext context) {
        context.setN_salschemeid_eq(salscheme_id);
        Page<SALSCHEMEITEM> domains = salschemeitemService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salschemeitemMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

