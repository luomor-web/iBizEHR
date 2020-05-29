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
import cn.ibizlab.ehr.core.par.domain.PARFZSMX;
import cn.ibizlab.ehr.core.par.service.IPARFZSMXService;
import cn.ibizlab.ehr.core.par.filter.PARFZSMXSearchContext;

@Slf4j
@Api(tags = {"PARFZSMX" })
@RestController("WebApi-parfzsmx")
@RequestMapping("")
public class PARFZSMXResource {

    @Autowired
    public IPARFZSMXService parfzsmxService;

    @Autowired
    @Lazy
    public PARFZSMXMapping parfzsmxMapping;

    @ApiOperation(value = "GetDraft", tags = {"PARFZSMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parfzsmxes/getdraft")
    public ResponseEntity<PARFZSMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parfzsmxMapping.toDto(parfzsmxService.getDraft(new PARFZSMX())));
    }

    @PreAuthorize("hasPermission(this.parfzsmxService.get(#parfzsmx_id),'ehr-PARFZSMX-Update')")
    @ApiOperation(value = "Update", tags = {"PARFZSMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parfzsmxes/{parfzsmx_id}")
    @Transactional
    public ResponseEntity<PARFZSMXDTO> update(@PathVariable("parfzsmx_id") String parfzsmx_id, @RequestBody PARFZSMXDTO parfzsmxdto) {
		PARFZSMX domain  = parfzsmxMapping.toDomain(parfzsmxdto);
        domain .setParfzsmxid(parfzsmx_id);
		parfzsmxService.update(domain );
		PARFZSMXDTO dto = parfzsmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parfzsmxService.getParfzsmxByEntities(this.parfzsmxMapping.toDomain(#parfzsmxdtos)),'ehr-PARFZSMX-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PARFZSMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parfzsmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARFZSMXDTO> parfzsmxdtos) {
        parfzsmxService.updateBatch(parfzsmxMapping.toDomain(parfzsmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parfzsmxService.get(#parfzsmx_id),'ehr-PARFZSMX-Remove')")
    @ApiOperation(value = "Remove", tags = {"PARFZSMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parfzsmxes/{parfzsmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parfzsmx_id") String parfzsmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parfzsmxService.remove(parfzsmx_id));
    }

    @PreAuthorize("hasPermission(this.parfzsmxService.getParfzsmxByIds(#ids),'ehr-PARFZSMX-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PARFZSMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parfzsmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parfzsmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parfzsmxMapping.toDomain(#parfzsmxdto),'ehr-PARFZSMX-Create')")
    @ApiOperation(value = "Create", tags = {"PARFZSMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parfzsmxes")
    @Transactional
    public ResponseEntity<PARFZSMXDTO> create(@RequestBody PARFZSMXDTO parfzsmxdto) {
        PARFZSMX domain = parfzsmxMapping.toDomain(parfzsmxdto);
		parfzsmxService.create(domain);
        PARFZSMXDTO dto = parfzsmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parfzsmxMapping.toDomain(#parfzsmxdtos),'ehr-PARFZSMX-Create')")
    @ApiOperation(value = "createBatch", tags = {"PARFZSMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parfzsmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARFZSMXDTO> parfzsmxdtos) {
        parfzsmxService.createBatch(parfzsmxMapping.toDomain(parfzsmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"PARFZSMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parfzsmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARFZSMXDTO parfzsmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parfzsmxService.checkKey(parfzsmxMapping.toDomain(parfzsmxdto)));
    }

    @PreAuthorize("hasPermission(this.parfzsmxMapping.toDomain(#parfzsmxdto),'ehr-PARFZSMX-Save')")
    @ApiOperation(value = "Save", tags = {"PARFZSMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parfzsmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PARFZSMXDTO parfzsmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parfzsmxService.save(parfzsmxMapping.toDomain(parfzsmxdto)));
    }

    @PreAuthorize("hasPermission(this.parfzsmxMapping.toDomain(#parfzsmxdtos),'ehr-PARFZSMX-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PARFZSMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parfzsmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARFZSMXDTO> parfzsmxdtos) {
        parfzsmxService.saveBatch(parfzsmxMapping.toDomain(parfzsmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parfzsmxMapping.toDomain(returnObject.body),'ehr-PARFZSMX-Get')")
    @ApiOperation(value = "Get", tags = {"PARFZSMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parfzsmxes/{parfzsmx_id}")
    public ResponseEntity<PARFZSMXDTO> get(@PathVariable("parfzsmx_id") String parfzsmx_id) {
        PARFZSMX domain = parfzsmxService.get(parfzsmx_id);
        PARFZSMXDTO dto = parfzsmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARFZSMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PARFZSMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parfzsmxes/fetchdefault")
	public ResponseEntity<List<PARFZSMXDTO>> fetchDefault(PARFZSMXSearchContext context) {
        Page<PARFZSMX> domains = parfzsmxService.searchDefault(context) ;
        List<PARFZSMXDTO> list = parfzsmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARFZSMX-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PARFZSMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parfzsmxes/searchdefault")
	public ResponseEntity<Page<PARFZSMXDTO>> searchDefault(@RequestBody PARFZSMXSearchContext context) {
        Page<PARFZSMX> domains = parfzsmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parfzsmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "GetDraftByPARTZGG", tags = {"PARFZSMX" },  notes = "GetDraftByPARTZGG")
    @RequestMapping(method = RequestMethod.GET, value = "/partzggs/{partzgg_id}/parfzsmxes/getdraft")
    public ResponseEntity<PARFZSMXDTO> getDraftByPARTZGG(@PathVariable("partzgg_id") String partzgg_id) {
        PARFZSMX domain = new PARFZSMX();
        domain.setPartzggid(partzgg_id);
        return ResponseEntity.status(HttpStatus.OK).body(parfzsmxMapping.toDto(parfzsmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.parfzsmxService.get(#parfzsmx_id),'ehr-PARFZSMX-Update')")
    @ApiOperation(value = "UpdateByPARTZGG", tags = {"PARFZSMX" },  notes = "UpdateByPARTZGG")
	@RequestMapping(method = RequestMethod.PUT, value = "/partzggs/{partzgg_id}/parfzsmxes/{parfzsmx_id}")
    @Transactional
    public ResponseEntity<PARFZSMXDTO> updateByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @PathVariable("parfzsmx_id") String parfzsmx_id, @RequestBody PARFZSMXDTO parfzsmxdto) {
        PARFZSMX domain = parfzsmxMapping.toDomain(parfzsmxdto);
        domain.setPartzggid(partzgg_id);
        domain.setParfzsmxid(parfzsmx_id);
		parfzsmxService.update(domain);
        PARFZSMXDTO dto = parfzsmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parfzsmxService.getParfzsmxByEntities(this.parfzsmxMapping.toDomain(#parfzsmxdtos)),'ehr-PARFZSMX-Update')")
    @ApiOperation(value = "UpdateBatchByPARTZGG", tags = {"PARFZSMX" },  notes = "UpdateBatchByPARTZGG")
	@RequestMapping(method = RequestMethod.PUT, value = "/partzggs/{partzgg_id}/parfzsmxes/batch")
    public ResponseEntity<Boolean> updateBatchByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @RequestBody List<PARFZSMXDTO> parfzsmxdtos) {
        List<PARFZSMX> domainlist=parfzsmxMapping.toDomain(parfzsmxdtos);
        for(PARFZSMX domain:domainlist){
            domain.setPartzggid(partzgg_id);
        }
        parfzsmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parfzsmxService.get(#parfzsmx_id),'ehr-PARFZSMX-Remove')")
    @ApiOperation(value = "RemoveByPARTZGG", tags = {"PARFZSMX" },  notes = "RemoveByPARTZGG")
	@RequestMapping(method = RequestMethod.DELETE, value = "/partzggs/{partzgg_id}/parfzsmxes/{parfzsmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @PathVariable("parfzsmx_id") String parfzsmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(parfzsmxService.remove(parfzsmx_id));
    }

    @PreAuthorize("hasPermission(this.parfzsmxService.getParfzsmxByIds(#ids),'ehr-PARFZSMX-Remove')")
    @ApiOperation(value = "RemoveBatchByPARTZGG", tags = {"PARFZSMX" },  notes = "RemoveBatchByPARTZGG")
	@RequestMapping(method = RequestMethod.DELETE, value = "/partzggs/{partzgg_id}/parfzsmxes/batch")
    public ResponseEntity<Boolean> removeBatchByPARTZGG(@RequestBody List<String> ids) {
        parfzsmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parfzsmxMapping.toDomain(#parfzsmxdto),'ehr-PARFZSMX-Create')")
    @ApiOperation(value = "CreateByPARTZGG", tags = {"PARFZSMX" },  notes = "CreateByPARTZGG")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parfzsmxes")
    @Transactional
    public ResponseEntity<PARFZSMXDTO> createByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @RequestBody PARFZSMXDTO parfzsmxdto) {
        PARFZSMX domain = parfzsmxMapping.toDomain(parfzsmxdto);
        domain.setPartzggid(partzgg_id);
		parfzsmxService.create(domain);
        PARFZSMXDTO dto = parfzsmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parfzsmxMapping.toDomain(#parfzsmxdtos),'ehr-PARFZSMX-Create')")
    @ApiOperation(value = "createBatchByPARTZGG", tags = {"PARFZSMX" },  notes = "createBatchByPARTZGG")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parfzsmxes/batch")
    public ResponseEntity<Boolean> createBatchByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @RequestBody List<PARFZSMXDTO> parfzsmxdtos) {
        List<PARFZSMX> domainlist=parfzsmxMapping.toDomain(parfzsmxdtos);
        for(PARFZSMX domain:domainlist){
            domain.setPartzggid(partzgg_id);
        }
        parfzsmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByPARTZGG", tags = {"PARFZSMX" },  notes = "CheckKeyByPARTZGG")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parfzsmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @RequestBody PARFZSMXDTO parfzsmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parfzsmxService.checkKey(parfzsmxMapping.toDomain(parfzsmxdto)));
    }

    @PreAuthorize("hasPermission(this.parfzsmxMapping.toDomain(#parfzsmxdto),'ehr-PARFZSMX-Save')")
    @ApiOperation(value = "SaveByPARTZGG", tags = {"PARFZSMX" },  notes = "SaveByPARTZGG")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parfzsmxes/save")
    public ResponseEntity<Boolean> saveByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @RequestBody PARFZSMXDTO parfzsmxdto) {
        PARFZSMX domain = parfzsmxMapping.toDomain(parfzsmxdto);
        domain.setPartzggid(partzgg_id);
        return ResponseEntity.status(HttpStatus.OK).body(parfzsmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.parfzsmxMapping.toDomain(#parfzsmxdtos),'ehr-PARFZSMX-Save')")
    @ApiOperation(value = "SaveBatchByPARTZGG", tags = {"PARFZSMX" },  notes = "SaveBatchByPARTZGG")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parfzsmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @RequestBody List<PARFZSMXDTO> parfzsmxdtos) {
        List<PARFZSMX> domainlist=parfzsmxMapping.toDomain(parfzsmxdtos);
        for(PARFZSMX domain:domainlist){
             domain.setPartzggid(partzgg_id);
        }
        parfzsmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parfzsmxMapping.toDomain(returnObject.body),'ehr-PARFZSMX-Get')")
    @ApiOperation(value = "GetByPARTZGG", tags = {"PARFZSMX" },  notes = "GetByPARTZGG")
	@RequestMapping(method = RequestMethod.GET, value = "/partzggs/{partzgg_id}/parfzsmxes/{parfzsmx_id}")
    public ResponseEntity<PARFZSMXDTO> getByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @PathVariable("parfzsmx_id") String parfzsmx_id) {
        PARFZSMX domain = parfzsmxService.get(parfzsmx_id);
        PARFZSMXDTO dto = parfzsmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARFZSMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPARTZGG", tags = {"PARFZSMX" } ,notes = "fetchDEFAULTByPARTZGG")
    @RequestMapping(method= RequestMethod.GET , value="/partzggs/{partzgg_id}/parfzsmxes/fetchdefault")
	public ResponseEntity<List<PARFZSMXDTO>> fetchPARFZSMXDefaultByPARTZGG(@PathVariable("partzgg_id") String partzgg_id,PARFZSMXSearchContext context) {
        context.setN_partzggid_eq(partzgg_id);
        Page<PARFZSMX> domains = parfzsmxService.searchDefault(context) ;
        List<PARFZSMXDTO> list = parfzsmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARFZSMX-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPARTZGG", tags = {"PARFZSMX" } ,notes = "searchDEFAULTByPARTZGG")
    @RequestMapping(method= RequestMethod.POST , value="/partzggs/{partzgg_id}/parfzsmxes/searchdefault")
	public ResponseEntity<Page<PARFZSMXDTO>> searchPARFZSMXDefaultByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @RequestBody PARFZSMXSearchContext context) {
        context.setN_partzggid_eq(partzgg_id);
        Page<PARFZSMX> domains = parfzsmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parfzsmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "GetDraftByPIMPERSON", tags = {"PARFZSMX" },  notes = "GetDraftByPIMPERSON")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/parfzsmxes/getdraft")
    public ResponseEntity<PARFZSMXDTO> getDraftByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id) {
        PARFZSMX domain = new PARFZSMX();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(parfzsmxMapping.toDto(parfzsmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.parfzsmxService.get(#parfzsmx_id),'ehr-PARFZSMX-Update')")
    @ApiOperation(value = "UpdateByPIMPERSON", tags = {"PARFZSMX" },  notes = "UpdateByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/parfzsmxes/{parfzsmx_id}")
    @Transactional
    public ResponseEntity<PARFZSMXDTO> updateByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("parfzsmx_id") String parfzsmx_id, @RequestBody PARFZSMXDTO parfzsmxdto) {
        PARFZSMX domain = parfzsmxMapping.toDomain(parfzsmxdto);
        domain.setPimpersonid(pimperson_id);
        domain.setParfzsmxid(parfzsmx_id);
		parfzsmxService.update(domain);
        PARFZSMXDTO dto = parfzsmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parfzsmxService.getParfzsmxByEntities(this.parfzsmxMapping.toDomain(#parfzsmxdtos)),'ehr-PARFZSMX-Update')")
    @ApiOperation(value = "UpdateBatchByPIMPERSON", tags = {"PARFZSMX" },  notes = "UpdateBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/parfzsmxes/batch")
    public ResponseEntity<Boolean> updateBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PARFZSMXDTO> parfzsmxdtos) {
        List<PARFZSMX> domainlist=parfzsmxMapping.toDomain(parfzsmxdtos);
        for(PARFZSMX domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        parfzsmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parfzsmxService.get(#parfzsmx_id),'ehr-PARFZSMX-Remove')")
    @ApiOperation(value = "RemoveByPIMPERSON", tags = {"PARFZSMX" },  notes = "RemoveByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/parfzsmxes/{parfzsmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("parfzsmx_id") String parfzsmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(parfzsmxService.remove(parfzsmx_id));
    }

    @PreAuthorize("hasPermission(this.parfzsmxService.getParfzsmxByIds(#ids),'ehr-PARFZSMX-Remove')")
    @ApiOperation(value = "RemoveBatchByPIMPERSON", tags = {"PARFZSMX" },  notes = "RemoveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/parfzsmxes/batch")
    public ResponseEntity<Boolean> removeBatchByPIMPERSON(@RequestBody List<String> ids) {
        parfzsmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parfzsmxMapping.toDomain(#parfzsmxdto),'ehr-PARFZSMX-Create')")
    @ApiOperation(value = "CreateByPIMPERSON", tags = {"PARFZSMX" },  notes = "CreateByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/parfzsmxes")
    @Transactional
    public ResponseEntity<PARFZSMXDTO> createByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PARFZSMXDTO parfzsmxdto) {
        PARFZSMX domain = parfzsmxMapping.toDomain(parfzsmxdto);
        domain.setPimpersonid(pimperson_id);
		parfzsmxService.create(domain);
        PARFZSMXDTO dto = parfzsmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parfzsmxMapping.toDomain(#parfzsmxdtos),'ehr-PARFZSMX-Create')")
    @ApiOperation(value = "createBatchByPIMPERSON", tags = {"PARFZSMX" },  notes = "createBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/parfzsmxes/batch")
    public ResponseEntity<Boolean> createBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PARFZSMXDTO> parfzsmxdtos) {
        List<PARFZSMX> domainlist=parfzsmxMapping.toDomain(parfzsmxdtos);
        for(PARFZSMX domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        parfzsmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByPIMPERSON", tags = {"PARFZSMX" },  notes = "CheckKeyByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/parfzsmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PARFZSMXDTO parfzsmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parfzsmxService.checkKey(parfzsmxMapping.toDomain(parfzsmxdto)));
    }

    @PreAuthorize("hasPermission(this.parfzsmxMapping.toDomain(#parfzsmxdto),'ehr-PARFZSMX-Save')")
    @ApiOperation(value = "SaveByPIMPERSON", tags = {"PARFZSMX" },  notes = "SaveByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/parfzsmxes/save")
    public ResponseEntity<Boolean> saveByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PARFZSMXDTO parfzsmxdto) {
        PARFZSMX domain = parfzsmxMapping.toDomain(parfzsmxdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(parfzsmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.parfzsmxMapping.toDomain(#parfzsmxdtos),'ehr-PARFZSMX-Save')")
    @ApiOperation(value = "SaveBatchByPIMPERSON", tags = {"PARFZSMX" },  notes = "SaveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/parfzsmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PARFZSMXDTO> parfzsmxdtos) {
        List<PARFZSMX> domainlist=parfzsmxMapping.toDomain(parfzsmxdtos);
        for(PARFZSMX domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        parfzsmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parfzsmxMapping.toDomain(returnObject.body),'ehr-PARFZSMX-Get')")
    @ApiOperation(value = "GetByPIMPERSON", tags = {"PARFZSMX" },  notes = "GetByPIMPERSON")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/parfzsmxes/{parfzsmx_id}")
    public ResponseEntity<PARFZSMXDTO> getByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("parfzsmx_id") String parfzsmx_id) {
        PARFZSMX domain = parfzsmxService.get(parfzsmx_id);
        PARFZSMXDTO dto = parfzsmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARFZSMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPIMPERSON", tags = {"PARFZSMX" } ,notes = "fetchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/parfzsmxes/fetchdefault")
	public ResponseEntity<List<PARFZSMXDTO>> fetchPARFZSMXDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PARFZSMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PARFZSMX> domains = parfzsmxService.searchDefault(context) ;
        List<PARFZSMXDTO> list = parfzsmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARFZSMX-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPIMPERSON", tags = {"PARFZSMX" } ,notes = "searchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/parfzsmxes/searchdefault")
	public ResponseEntity<Page<PARFZSMXDTO>> searchPARFZSMXDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PARFZSMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PARFZSMX> domains = parfzsmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parfzsmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

