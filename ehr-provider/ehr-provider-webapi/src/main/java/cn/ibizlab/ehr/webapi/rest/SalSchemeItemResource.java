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
import cn.ibizlab.ehr.core.sal.domain.SalSchemeItem;
import cn.ibizlab.ehr.core.sal.service.ISalSchemeItemService;
import cn.ibizlab.ehr.core.sal.filter.SalSchemeItemSearchContext;

@Slf4j
@Api(tags = {"SalSchemeItem" })
@RestController("WebApi-salschemeitem")
@RequestMapping("")
public class SalSchemeItemResource {

    @Autowired
    public ISalSchemeItemService salschemeitemService;

    @Autowired
    @Lazy
    public SalSchemeItemMapping salschemeitemMapping;

    @PreAuthorize("hasPermission(this.salschemeitemService.get(#salschemeitem_id),'ehr-SalSchemeItem-Update')")
    @ApiOperation(value = "Update", tags = {"SalSchemeItem" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/salschemeitems/{salschemeitem_id}")
    @Transactional
    public ResponseEntity<SalSchemeItemDTO> update(@PathVariable("salschemeitem_id") String salschemeitem_id, @RequestBody SalSchemeItemDTO salschemeitemdto) {
		SalSchemeItem domain  = salschemeitemMapping.toDomain(salschemeitemdto);
        domain .setSalschemeitemid(salschemeitem_id);
		salschemeitemService.update(domain );
		SalSchemeItemDTO dto = salschemeitemMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salschemeitemService.getSalschemeitemByEntities(this.salschemeitemMapping.toDomain(#salschemeitemdtos)),'ehr-SalSchemeItem-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"SalSchemeItem" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/salschemeitems/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SalSchemeItemDTO> salschemeitemdtos) {
        salschemeitemService.updateBatch(salschemeitemMapping.toDomain(salschemeitemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salschemeitemMapping.toDomain(#salschemeitemdto),'ehr-SalSchemeItem-Save')")
    @ApiOperation(value = "Save", tags = {"SalSchemeItem" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemeitems/save")
    public ResponseEntity<Boolean> save(@RequestBody SalSchemeItemDTO salschemeitemdto) {
        return ResponseEntity.status(HttpStatus.OK).body(salschemeitemService.save(salschemeitemMapping.toDomain(salschemeitemdto)));
    }

    @PreAuthorize("hasPermission(this.salschemeitemMapping.toDomain(#salschemeitemdtos),'ehr-SalSchemeItem-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"SalSchemeItem" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemeitems/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SalSchemeItemDTO> salschemeitemdtos) {
        salschemeitemService.saveBatch(salschemeitemMapping.toDomain(salschemeitemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.salschemeitemMapping.toDomain(returnObject.body),'ehr-SalSchemeItem-Get')")
    @ApiOperation(value = "Get", tags = {"SalSchemeItem" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/salschemeitems/{salschemeitem_id}")
    public ResponseEntity<SalSchemeItemDTO> get(@PathVariable("salschemeitem_id") String salschemeitem_id) {
        SalSchemeItem domain = salschemeitemService.get(salschemeitem_id);
        SalSchemeItemDTO dto = salschemeitemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salschemeitemService.get(#salschemeitem_id),'ehr-SalSchemeItem-Remove')")
    @ApiOperation(value = "Remove", tags = {"SalSchemeItem" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salschemeitems/{salschemeitem_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salschemeitem_id") String salschemeitem_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salschemeitemService.remove(salschemeitem_id));
    }

    @PreAuthorize("hasPermission(this.salschemeitemService.getSalschemeitemByIds(#ids),'ehr-SalSchemeItem-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"SalSchemeItem" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salschemeitems/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salschemeitemService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"SalSchemeItem" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemeitems/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SalSchemeItemDTO salschemeitemdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salschemeitemService.checkKey(salschemeitemMapping.toDomain(salschemeitemdto)));
    }

    @PreAuthorize("hasPermission(this.salschemeitemMapping.toDomain(#salschemeitemdto),'ehr-SalSchemeItem-Create')")
    @ApiOperation(value = "Create", tags = {"SalSchemeItem" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemeitems")
    @Transactional
    public ResponseEntity<SalSchemeItemDTO> create(@RequestBody SalSchemeItemDTO salschemeitemdto) {
        SalSchemeItem domain = salschemeitemMapping.toDomain(salschemeitemdto);
		salschemeitemService.create(domain);
        SalSchemeItemDTO dto = salschemeitemMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salschemeitemMapping.toDomain(#salschemeitemdtos),'ehr-SalSchemeItem-Create')")
    @ApiOperation(value = "createBatch", tags = {"SalSchemeItem" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemeitems/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SalSchemeItemDTO> salschemeitemdtos) {
        salschemeitemService.createBatch(salschemeitemMapping.toDomain(salschemeitemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"SalSchemeItem" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/salschemeitems/getdraft")
    public ResponseEntity<SalSchemeItemDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salschemeitemMapping.toDto(salschemeitemService.getDraft(new SalSchemeItem())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalSchemeItem-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SalSchemeItem" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salschemeitems/fetchdefault")
	public ResponseEntity<List<SalSchemeItemDTO>> fetchDefault(SalSchemeItemSearchContext context) {
        Page<SalSchemeItem> domains = salschemeitemService.searchDefault(context) ;
        List<SalSchemeItemDTO> list = salschemeitemMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalSchemeItem-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SalSchemeItem" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salschemeitems/searchdefault")
	public ResponseEntity<Page<SalSchemeItemDTO>> searchDefault(@RequestBody SalSchemeItemSearchContext context) {
        Page<SalSchemeItem> domains = salschemeitemService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salschemeitemMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.salschemeitemService.get(#salschemeitem_id),'ehr-SalSchemeItem-Update')")
    @ApiOperation(value = "UpdateBySALITEM", tags = {"SalSchemeItem" },  notes = "UpdateBySALITEM")
	@RequestMapping(method = RequestMethod.PUT, value = "/salitems/{salitem_id}/salschemeitems/{salschemeitem_id}")
    @Transactional
    public ResponseEntity<SalSchemeItemDTO> updateBySALITEM(@PathVariable("salitem_id") String salitem_id, @PathVariable("salschemeitem_id") String salschemeitem_id, @RequestBody SalSchemeItemDTO salschemeitemdto) {
        SalSchemeItem domain = salschemeitemMapping.toDomain(salschemeitemdto);
        domain.setSalitemid(salitem_id);
        domain.setSalschemeitemid(salschemeitem_id);
		salschemeitemService.update(domain);
        SalSchemeItemDTO dto = salschemeitemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salschemeitemService.getSalschemeitemByEntities(this.salschemeitemMapping.toDomain(#salschemeitemdtos)),'ehr-SalSchemeItem-Update')")
    @ApiOperation(value = "UpdateBatchBySALITEM", tags = {"SalSchemeItem" },  notes = "UpdateBatchBySALITEM")
	@RequestMapping(method = RequestMethod.PUT, value = "/salitems/{salitem_id}/salschemeitems/batch")
    public ResponseEntity<Boolean> updateBatchBySALITEM(@PathVariable("salitem_id") String salitem_id, @RequestBody List<SalSchemeItemDTO> salschemeitemdtos) {
        List<SalSchemeItem> domainlist=salschemeitemMapping.toDomain(salschemeitemdtos);
        for(SalSchemeItem domain:domainlist){
            domain.setSalitemid(salitem_id);
        }
        salschemeitemService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salschemeitemMapping.toDomain(#salschemeitemdto),'ehr-SalSchemeItem-Save')")
    @ApiOperation(value = "SaveBySALITEM", tags = {"SalSchemeItem" },  notes = "SaveBySALITEM")
	@RequestMapping(method = RequestMethod.POST, value = "/salitems/{salitem_id}/salschemeitems/save")
    public ResponseEntity<Boolean> saveBySALITEM(@PathVariable("salitem_id") String salitem_id, @RequestBody SalSchemeItemDTO salschemeitemdto) {
        SalSchemeItem domain = salschemeitemMapping.toDomain(salschemeitemdto);
        domain.setSalitemid(salitem_id);
        return ResponseEntity.status(HttpStatus.OK).body(salschemeitemService.save(domain));
    }

    @PreAuthorize("hasPermission(this.salschemeitemMapping.toDomain(#salschemeitemdtos),'ehr-SalSchemeItem-Save')")
    @ApiOperation(value = "SaveBatchBySALITEM", tags = {"SalSchemeItem" },  notes = "SaveBatchBySALITEM")
	@RequestMapping(method = RequestMethod.POST, value = "/salitems/{salitem_id}/salschemeitems/savebatch")
    public ResponseEntity<Boolean> saveBatchBySALITEM(@PathVariable("salitem_id") String salitem_id, @RequestBody List<SalSchemeItemDTO> salschemeitemdtos) {
        List<SalSchemeItem> domainlist=salschemeitemMapping.toDomain(salschemeitemdtos);
        for(SalSchemeItem domain:domainlist){
             domain.setSalitemid(salitem_id);
        }
        salschemeitemService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.salschemeitemMapping.toDomain(returnObject.body),'ehr-SalSchemeItem-Get')")
    @ApiOperation(value = "GetBySALITEM", tags = {"SalSchemeItem" },  notes = "GetBySALITEM")
	@RequestMapping(method = RequestMethod.GET, value = "/salitems/{salitem_id}/salschemeitems/{salschemeitem_id}")
    public ResponseEntity<SalSchemeItemDTO> getBySALITEM(@PathVariable("salitem_id") String salitem_id, @PathVariable("salschemeitem_id") String salschemeitem_id) {
        SalSchemeItem domain = salschemeitemService.get(salschemeitem_id);
        SalSchemeItemDTO dto = salschemeitemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salschemeitemService.get(#salschemeitem_id),'ehr-SalSchemeItem-Remove')")
    @ApiOperation(value = "RemoveBySALITEM", tags = {"SalSchemeItem" },  notes = "RemoveBySALITEM")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salitems/{salitem_id}/salschemeitems/{salschemeitem_id}")
    @Transactional
    public ResponseEntity<Boolean> removeBySALITEM(@PathVariable("salitem_id") String salitem_id, @PathVariable("salschemeitem_id") String salschemeitem_id) {
		return ResponseEntity.status(HttpStatus.OK).body(salschemeitemService.remove(salschemeitem_id));
    }

    @PreAuthorize("hasPermission(this.salschemeitemService.getSalschemeitemByIds(#ids),'ehr-SalSchemeItem-Remove')")
    @ApiOperation(value = "RemoveBatchBySALITEM", tags = {"SalSchemeItem" },  notes = "RemoveBatchBySALITEM")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salitems/{salitem_id}/salschemeitems/batch")
    public ResponseEntity<Boolean> removeBatchBySALITEM(@RequestBody List<String> ids) {
        salschemeitemService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyBySALITEM", tags = {"SalSchemeItem" },  notes = "CheckKeyBySALITEM")
	@RequestMapping(method = RequestMethod.POST, value = "/salitems/{salitem_id}/salschemeitems/checkkey")
    public ResponseEntity<Boolean> checkKeyBySALITEM(@PathVariable("salitem_id") String salitem_id, @RequestBody SalSchemeItemDTO salschemeitemdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salschemeitemService.checkKey(salschemeitemMapping.toDomain(salschemeitemdto)));
    }

    @PreAuthorize("hasPermission(this.salschemeitemMapping.toDomain(#salschemeitemdto),'ehr-SalSchemeItem-Create')")
    @ApiOperation(value = "CreateBySALITEM", tags = {"SalSchemeItem" },  notes = "CreateBySALITEM")
	@RequestMapping(method = RequestMethod.POST, value = "/salitems/{salitem_id}/salschemeitems")
    @Transactional
    public ResponseEntity<SalSchemeItemDTO> createBySALITEM(@PathVariable("salitem_id") String salitem_id, @RequestBody SalSchemeItemDTO salschemeitemdto) {
        SalSchemeItem domain = salschemeitemMapping.toDomain(salschemeitemdto);
        domain.setSalitemid(salitem_id);
		salschemeitemService.create(domain);
        SalSchemeItemDTO dto = salschemeitemMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salschemeitemMapping.toDomain(#salschemeitemdtos),'ehr-SalSchemeItem-Create')")
    @ApiOperation(value = "createBatchBySALITEM", tags = {"SalSchemeItem" },  notes = "createBatchBySALITEM")
	@RequestMapping(method = RequestMethod.POST, value = "/salitems/{salitem_id}/salschemeitems/batch")
    public ResponseEntity<Boolean> createBatchBySALITEM(@PathVariable("salitem_id") String salitem_id, @RequestBody List<SalSchemeItemDTO> salschemeitemdtos) {
        List<SalSchemeItem> domainlist=salschemeitemMapping.toDomain(salschemeitemdtos);
        for(SalSchemeItem domain:domainlist){
            domain.setSalitemid(salitem_id);
        }
        salschemeitemService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftBySALITEM", tags = {"SalSchemeItem" },  notes = "GetDraftBySALITEM")
    @RequestMapping(method = RequestMethod.GET, value = "/salitems/{salitem_id}/salschemeitems/getdraft")
    public ResponseEntity<SalSchemeItemDTO> getDraftBySALITEM(@PathVariable("salitem_id") String salitem_id) {
        SalSchemeItem domain = new SalSchemeItem();
        domain.setSalitemid(salitem_id);
        return ResponseEntity.status(HttpStatus.OK).body(salschemeitemMapping.toDto(salschemeitemService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalSchemeItem-Default-all')")
	@ApiOperation(value = "fetchDEFAULTBySALITEM", tags = {"SalSchemeItem" } ,notes = "fetchDEFAULTBySALITEM")
    @RequestMapping(method= RequestMethod.GET , value="/salitems/{salitem_id}/salschemeitems/fetchdefault")
	public ResponseEntity<List<SalSchemeItemDTO>> fetchSalSchemeItemDefaultBySALITEM(@PathVariable("salitem_id") String salitem_id,SalSchemeItemSearchContext context) {
        context.setN_salitemid_eq(salitem_id);
        Page<SalSchemeItem> domains = salschemeitemService.searchDefault(context) ;
        List<SalSchemeItemDTO> list = salschemeitemMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalSchemeItem-Default-all')")
	@ApiOperation(value = "searchDEFAULTBySALITEM", tags = {"SalSchemeItem" } ,notes = "searchDEFAULTBySALITEM")
    @RequestMapping(method= RequestMethod.POST , value="/salitems/{salitem_id}/salschemeitems/searchdefault")
	public ResponseEntity<Page<SalSchemeItemDTO>> searchSalSchemeItemDefaultBySALITEM(@PathVariable("salitem_id") String salitem_id, @RequestBody SalSchemeItemSearchContext context) {
        context.setN_salitemid_eq(salitem_id);
        Page<SalSchemeItem> domains = salschemeitemService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salschemeitemMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.salschemeitemService.get(#salschemeitem_id),'ehr-SalSchemeItem-Update')")
    @ApiOperation(value = "UpdateBySALSCHEME", tags = {"SalSchemeItem" },  notes = "UpdateBySALSCHEME")
	@RequestMapping(method = RequestMethod.PUT, value = "/salschemes/{salscheme_id}/salschemeitems/{salschemeitem_id}")
    @Transactional
    public ResponseEntity<SalSchemeItemDTO> updateBySALSCHEME(@PathVariable("salscheme_id") String salscheme_id, @PathVariable("salschemeitem_id") String salschemeitem_id, @RequestBody SalSchemeItemDTO salschemeitemdto) {
        SalSchemeItem domain = salschemeitemMapping.toDomain(salschemeitemdto);
        domain.setSalschemeid(salscheme_id);
        domain.setSalschemeitemid(salschemeitem_id);
		salschemeitemService.update(domain);
        SalSchemeItemDTO dto = salschemeitemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salschemeitemService.getSalschemeitemByEntities(this.salschemeitemMapping.toDomain(#salschemeitemdtos)),'ehr-SalSchemeItem-Update')")
    @ApiOperation(value = "UpdateBatchBySALSCHEME", tags = {"SalSchemeItem" },  notes = "UpdateBatchBySALSCHEME")
	@RequestMapping(method = RequestMethod.PUT, value = "/salschemes/{salscheme_id}/salschemeitems/batch")
    public ResponseEntity<Boolean> updateBatchBySALSCHEME(@PathVariable("salscheme_id") String salscheme_id, @RequestBody List<SalSchemeItemDTO> salschemeitemdtos) {
        List<SalSchemeItem> domainlist=salschemeitemMapping.toDomain(salschemeitemdtos);
        for(SalSchemeItem domain:domainlist){
            domain.setSalschemeid(salscheme_id);
        }
        salschemeitemService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salschemeitemMapping.toDomain(#salschemeitemdto),'ehr-SalSchemeItem-Save')")
    @ApiOperation(value = "SaveBySALSCHEME", tags = {"SalSchemeItem" },  notes = "SaveBySALSCHEME")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemes/{salscheme_id}/salschemeitems/save")
    public ResponseEntity<Boolean> saveBySALSCHEME(@PathVariable("salscheme_id") String salscheme_id, @RequestBody SalSchemeItemDTO salschemeitemdto) {
        SalSchemeItem domain = salschemeitemMapping.toDomain(salschemeitemdto);
        domain.setSalschemeid(salscheme_id);
        return ResponseEntity.status(HttpStatus.OK).body(salschemeitemService.save(domain));
    }

    @PreAuthorize("hasPermission(this.salschemeitemMapping.toDomain(#salschemeitemdtos),'ehr-SalSchemeItem-Save')")
    @ApiOperation(value = "SaveBatchBySALSCHEME", tags = {"SalSchemeItem" },  notes = "SaveBatchBySALSCHEME")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemes/{salscheme_id}/salschemeitems/savebatch")
    public ResponseEntity<Boolean> saveBatchBySALSCHEME(@PathVariable("salscheme_id") String salscheme_id, @RequestBody List<SalSchemeItemDTO> salschemeitemdtos) {
        List<SalSchemeItem> domainlist=salschemeitemMapping.toDomain(salschemeitemdtos);
        for(SalSchemeItem domain:domainlist){
             domain.setSalschemeid(salscheme_id);
        }
        salschemeitemService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.salschemeitemMapping.toDomain(returnObject.body),'ehr-SalSchemeItem-Get')")
    @ApiOperation(value = "GetBySALSCHEME", tags = {"SalSchemeItem" },  notes = "GetBySALSCHEME")
	@RequestMapping(method = RequestMethod.GET, value = "/salschemes/{salscheme_id}/salschemeitems/{salschemeitem_id}")
    public ResponseEntity<SalSchemeItemDTO> getBySALSCHEME(@PathVariable("salscheme_id") String salscheme_id, @PathVariable("salschemeitem_id") String salschemeitem_id) {
        SalSchemeItem domain = salschemeitemService.get(salschemeitem_id);
        SalSchemeItemDTO dto = salschemeitemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salschemeitemService.get(#salschemeitem_id),'ehr-SalSchemeItem-Remove')")
    @ApiOperation(value = "RemoveBySALSCHEME", tags = {"SalSchemeItem" },  notes = "RemoveBySALSCHEME")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salschemes/{salscheme_id}/salschemeitems/{salschemeitem_id}")
    @Transactional
    public ResponseEntity<Boolean> removeBySALSCHEME(@PathVariable("salscheme_id") String salscheme_id, @PathVariable("salschemeitem_id") String salschemeitem_id) {
		return ResponseEntity.status(HttpStatus.OK).body(salschemeitemService.remove(salschemeitem_id));
    }

    @PreAuthorize("hasPermission(this.salschemeitemService.getSalschemeitemByIds(#ids),'ehr-SalSchemeItem-Remove')")
    @ApiOperation(value = "RemoveBatchBySALSCHEME", tags = {"SalSchemeItem" },  notes = "RemoveBatchBySALSCHEME")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salschemes/{salscheme_id}/salschemeitems/batch")
    public ResponseEntity<Boolean> removeBatchBySALSCHEME(@RequestBody List<String> ids) {
        salschemeitemService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyBySALSCHEME", tags = {"SalSchemeItem" },  notes = "CheckKeyBySALSCHEME")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemes/{salscheme_id}/salschemeitems/checkkey")
    public ResponseEntity<Boolean> checkKeyBySALSCHEME(@PathVariable("salscheme_id") String salscheme_id, @RequestBody SalSchemeItemDTO salschemeitemdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salschemeitemService.checkKey(salschemeitemMapping.toDomain(salschemeitemdto)));
    }

    @PreAuthorize("hasPermission(this.salschemeitemMapping.toDomain(#salschemeitemdto),'ehr-SalSchemeItem-Create')")
    @ApiOperation(value = "CreateBySALSCHEME", tags = {"SalSchemeItem" },  notes = "CreateBySALSCHEME")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemes/{salscheme_id}/salschemeitems")
    @Transactional
    public ResponseEntity<SalSchemeItemDTO> createBySALSCHEME(@PathVariable("salscheme_id") String salscheme_id, @RequestBody SalSchemeItemDTO salschemeitemdto) {
        SalSchemeItem domain = salschemeitemMapping.toDomain(salschemeitemdto);
        domain.setSalschemeid(salscheme_id);
		salschemeitemService.create(domain);
        SalSchemeItemDTO dto = salschemeitemMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salschemeitemMapping.toDomain(#salschemeitemdtos),'ehr-SalSchemeItem-Create')")
    @ApiOperation(value = "createBatchBySALSCHEME", tags = {"SalSchemeItem" },  notes = "createBatchBySALSCHEME")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemes/{salscheme_id}/salschemeitems/batch")
    public ResponseEntity<Boolean> createBatchBySALSCHEME(@PathVariable("salscheme_id") String salscheme_id, @RequestBody List<SalSchemeItemDTO> salschemeitemdtos) {
        List<SalSchemeItem> domainlist=salschemeitemMapping.toDomain(salschemeitemdtos);
        for(SalSchemeItem domain:domainlist){
            domain.setSalschemeid(salscheme_id);
        }
        salschemeitemService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftBySALSCHEME", tags = {"SalSchemeItem" },  notes = "GetDraftBySALSCHEME")
    @RequestMapping(method = RequestMethod.GET, value = "/salschemes/{salscheme_id}/salschemeitems/getdraft")
    public ResponseEntity<SalSchemeItemDTO> getDraftBySALSCHEME(@PathVariable("salscheme_id") String salscheme_id) {
        SalSchemeItem domain = new SalSchemeItem();
        domain.setSalschemeid(salscheme_id);
        return ResponseEntity.status(HttpStatus.OK).body(salschemeitemMapping.toDto(salschemeitemService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalSchemeItem-Default-all')")
	@ApiOperation(value = "fetchDEFAULTBySALSCHEME", tags = {"SalSchemeItem" } ,notes = "fetchDEFAULTBySALSCHEME")
    @RequestMapping(method= RequestMethod.GET , value="/salschemes/{salscheme_id}/salschemeitems/fetchdefault")
	public ResponseEntity<List<SalSchemeItemDTO>> fetchSalSchemeItemDefaultBySALSCHEME(@PathVariable("salscheme_id") String salscheme_id,SalSchemeItemSearchContext context) {
        context.setN_salschemeid_eq(salscheme_id);
        Page<SalSchemeItem> domains = salschemeitemService.searchDefault(context) ;
        List<SalSchemeItemDTO> list = salschemeitemMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalSchemeItem-Default-all')")
	@ApiOperation(value = "searchDEFAULTBySALSCHEME", tags = {"SalSchemeItem" } ,notes = "searchDEFAULTBySALSCHEME")
    @RequestMapping(method= RequestMethod.POST , value="/salschemes/{salscheme_id}/salschemeitems/searchdefault")
	public ResponseEntity<Page<SalSchemeItemDTO>> searchSalSchemeItemDefaultBySALSCHEME(@PathVariable("salscheme_id") String salscheme_id, @RequestBody SalSchemeItemSearchContext context) {
        context.setN_salschemeid_eq(salscheme_id);
        Page<SalSchemeItem> domains = salschemeitemService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salschemeitemMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

