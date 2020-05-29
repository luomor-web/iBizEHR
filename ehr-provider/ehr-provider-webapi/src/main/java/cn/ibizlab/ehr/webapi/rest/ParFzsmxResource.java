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
import cn.ibizlab.ehr.core.par.domain.ParFzsmx;
import cn.ibizlab.ehr.core.par.service.IParFzsmxService;
import cn.ibizlab.ehr.core.par.filter.ParFzsmxSearchContext;

@Slf4j
@Api(tags = {"ParFzsmx" })
@RestController("WebApi-parfzsmx")
@RequestMapping("")
public class ParFzsmxResource {

    @Autowired
    public IParFzsmxService parfzsmxService;

    @Autowired
    @Lazy
    public ParFzsmxMapping parfzsmxMapping;

    @ApiOperation(value = "GetDraft", tags = {"ParFzsmx" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parfzsmxes/getdraft")
    public ResponseEntity<ParFzsmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parfzsmxMapping.toDto(parfzsmxService.getDraft(new ParFzsmx())));
    }

    @PreAuthorize("hasPermission(this.parfzsmxService.get(#parfzsmx_id),'ehr-ParFzsmx-Update')")
    @ApiOperation(value = "Update", tags = {"ParFzsmx" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parfzsmxes/{parfzsmx_id}")
    @Transactional
    public ResponseEntity<ParFzsmxDTO> update(@PathVariable("parfzsmx_id") String parfzsmx_id, @RequestBody ParFzsmxDTO parfzsmxdto) {
		ParFzsmx domain  = parfzsmxMapping.toDomain(parfzsmxdto);
        domain .setParfzsmxid(parfzsmx_id);
		parfzsmxService.update(domain );
		ParFzsmxDTO dto = parfzsmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parfzsmxService.getParfzsmxByEntities(this.parfzsmxMapping.toDomain(#parfzsmxdtos)),'ehr-ParFzsmx-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"ParFzsmx" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parfzsmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParFzsmxDTO> parfzsmxdtos) {
        parfzsmxService.updateBatch(parfzsmxMapping.toDomain(parfzsmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parfzsmxService.get(#parfzsmx_id),'ehr-ParFzsmx-Remove')")
    @ApiOperation(value = "Remove", tags = {"ParFzsmx" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parfzsmxes/{parfzsmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parfzsmx_id") String parfzsmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parfzsmxService.remove(parfzsmx_id));
    }

    @PreAuthorize("hasPermission(this.parfzsmxService.getParfzsmxByIds(#ids),'ehr-ParFzsmx-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"ParFzsmx" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parfzsmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parfzsmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parfzsmxMapping.toDomain(#parfzsmxdto),'ehr-ParFzsmx-Create')")
    @ApiOperation(value = "Create", tags = {"ParFzsmx" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parfzsmxes")
    @Transactional
    public ResponseEntity<ParFzsmxDTO> create(@RequestBody ParFzsmxDTO parfzsmxdto) {
        ParFzsmx domain = parfzsmxMapping.toDomain(parfzsmxdto);
		parfzsmxService.create(domain);
        ParFzsmxDTO dto = parfzsmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parfzsmxMapping.toDomain(#parfzsmxdtos),'ehr-ParFzsmx-Create')")
    @ApiOperation(value = "createBatch", tags = {"ParFzsmx" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parfzsmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParFzsmxDTO> parfzsmxdtos) {
        parfzsmxService.createBatch(parfzsmxMapping.toDomain(parfzsmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"ParFzsmx" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parfzsmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParFzsmxDTO parfzsmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parfzsmxService.checkKey(parfzsmxMapping.toDomain(parfzsmxdto)));
    }

    @PreAuthorize("hasPermission(this.parfzsmxMapping.toDomain(#parfzsmxdto),'ehr-ParFzsmx-Save')")
    @ApiOperation(value = "Save", tags = {"ParFzsmx" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parfzsmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody ParFzsmxDTO parfzsmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parfzsmxService.save(parfzsmxMapping.toDomain(parfzsmxdto)));
    }

    @PreAuthorize("hasPermission(this.parfzsmxMapping.toDomain(#parfzsmxdtos),'ehr-ParFzsmx-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"ParFzsmx" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parfzsmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParFzsmxDTO> parfzsmxdtos) {
        parfzsmxService.saveBatch(parfzsmxMapping.toDomain(parfzsmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parfzsmxMapping.toDomain(returnObject.body),'ehr-ParFzsmx-Get')")
    @ApiOperation(value = "Get", tags = {"ParFzsmx" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parfzsmxes/{parfzsmx_id}")
    public ResponseEntity<ParFzsmxDTO> get(@PathVariable("parfzsmx_id") String parfzsmx_id) {
        ParFzsmx domain = parfzsmxService.get(parfzsmx_id);
        ParFzsmxDTO dto = parfzsmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParFzsmx-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ParFzsmx" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parfzsmxes/fetchdefault")
	public ResponseEntity<List<ParFzsmxDTO>> fetchDefault(ParFzsmxSearchContext context) {
        Page<ParFzsmx> domains = parfzsmxService.searchDefault(context) ;
        List<ParFzsmxDTO> list = parfzsmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParFzsmx-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ParFzsmx" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parfzsmxes/searchdefault")
	public ResponseEntity<Page<ParFzsmxDTO>> searchDefault(@RequestBody ParFzsmxSearchContext context) {
        Page<ParFzsmx> domains = parfzsmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parfzsmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "GetDraftByPARTZGG", tags = {"ParFzsmx" },  notes = "GetDraftByPARTZGG")
    @RequestMapping(method = RequestMethod.GET, value = "/partzggs/{partzgg_id}/parfzsmxes/getdraft")
    public ResponseEntity<ParFzsmxDTO> getDraftByPARTZGG(@PathVariable("partzgg_id") String partzgg_id) {
        ParFzsmx domain = new ParFzsmx();
        domain.setPartzggid(partzgg_id);
        return ResponseEntity.status(HttpStatus.OK).body(parfzsmxMapping.toDto(parfzsmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.parfzsmxService.get(#parfzsmx_id),'ehr-ParFzsmx-Update')")
    @ApiOperation(value = "UpdateByPARTZGG", tags = {"ParFzsmx" },  notes = "UpdateByPARTZGG")
	@RequestMapping(method = RequestMethod.PUT, value = "/partzggs/{partzgg_id}/parfzsmxes/{parfzsmx_id}")
    @Transactional
    public ResponseEntity<ParFzsmxDTO> updateByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @PathVariable("parfzsmx_id") String parfzsmx_id, @RequestBody ParFzsmxDTO parfzsmxdto) {
        ParFzsmx domain = parfzsmxMapping.toDomain(parfzsmxdto);
        domain.setPartzggid(partzgg_id);
        domain.setParfzsmxid(parfzsmx_id);
		parfzsmxService.update(domain);
        ParFzsmxDTO dto = parfzsmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parfzsmxService.getParfzsmxByEntities(this.parfzsmxMapping.toDomain(#parfzsmxdtos)),'ehr-ParFzsmx-Update')")
    @ApiOperation(value = "UpdateBatchByPARTZGG", tags = {"ParFzsmx" },  notes = "UpdateBatchByPARTZGG")
	@RequestMapping(method = RequestMethod.PUT, value = "/partzggs/{partzgg_id}/parfzsmxes/batch")
    public ResponseEntity<Boolean> updateBatchByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @RequestBody List<ParFzsmxDTO> parfzsmxdtos) {
        List<ParFzsmx> domainlist=parfzsmxMapping.toDomain(parfzsmxdtos);
        for(ParFzsmx domain:domainlist){
            domain.setPartzggid(partzgg_id);
        }
        parfzsmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parfzsmxService.get(#parfzsmx_id),'ehr-ParFzsmx-Remove')")
    @ApiOperation(value = "RemoveByPARTZGG", tags = {"ParFzsmx" },  notes = "RemoveByPARTZGG")
	@RequestMapping(method = RequestMethod.DELETE, value = "/partzggs/{partzgg_id}/parfzsmxes/{parfzsmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @PathVariable("parfzsmx_id") String parfzsmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(parfzsmxService.remove(parfzsmx_id));
    }

    @PreAuthorize("hasPermission(this.parfzsmxService.getParfzsmxByIds(#ids),'ehr-ParFzsmx-Remove')")
    @ApiOperation(value = "RemoveBatchByPARTZGG", tags = {"ParFzsmx" },  notes = "RemoveBatchByPARTZGG")
	@RequestMapping(method = RequestMethod.DELETE, value = "/partzggs/{partzgg_id}/parfzsmxes/batch")
    public ResponseEntity<Boolean> removeBatchByPARTZGG(@RequestBody List<String> ids) {
        parfzsmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parfzsmxMapping.toDomain(#parfzsmxdto),'ehr-ParFzsmx-Create')")
    @ApiOperation(value = "CreateByPARTZGG", tags = {"ParFzsmx" },  notes = "CreateByPARTZGG")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parfzsmxes")
    @Transactional
    public ResponseEntity<ParFzsmxDTO> createByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @RequestBody ParFzsmxDTO parfzsmxdto) {
        ParFzsmx domain = parfzsmxMapping.toDomain(parfzsmxdto);
        domain.setPartzggid(partzgg_id);
		parfzsmxService.create(domain);
        ParFzsmxDTO dto = parfzsmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parfzsmxMapping.toDomain(#parfzsmxdtos),'ehr-ParFzsmx-Create')")
    @ApiOperation(value = "createBatchByPARTZGG", tags = {"ParFzsmx" },  notes = "createBatchByPARTZGG")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parfzsmxes/batch")
    public ResponseEntity<Boolean> createBatchByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @RequestBody List<ParFzsmxDTO> parfzsmxdtos) {
        List<ParFzsmx> domainlist=parfzsmxMapping.toDomain(parfzsmxdtos);
        for(ParFzsmx domain:domainlist){
            domain.setPartzggid(partzgg_id);
        }
        parfzsmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByPARTZGG", tags = {"ParFzsmx" },  notes = "CheckKeyByPARTZGG")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parfzsmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @RequestBody ParFzsmxDTO parfzsmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parfzsmxService.checkKey(parfzsmxMapping.toDomain(parfzsmxdto)));
    }

    @PreAuthorize("hasPermission(this.parfzsmxMapping.toDomain(#parfzsmxdto),'ehr-ParFzsmx-Save')")
    @ApiOperation(value = "SaveByPARTZGG", tags = {"ParFzsmx" },  notes = "SaveByPARTZGG")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parfzsmxes/save")
    public ResponseEntity<Boolean> saveByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @RequestBody ParFzsmxDTO parfzsmxdto) {
        ParFzsmx domain = parfzsmxMapping.toDomain(parfzsmxdto);
        domain.setPartzggid(partzgg_id);
        return ResponseEntity.status(HttpStatus.OK).body(parfzsmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.parfzsmxMapping.toDomain(#parfzsmxdtos),'ehr-ParFzsmx-Save')")
    @ApiOperation(value = "SaveBatchByPARTZGG", tags = {"ParFzsmx" },  notes = "SaveBatchByPARTZGG")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parfzsmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @RequestBody List<ParFzsmxDTO> parfzsmxdtos) {
        List<ParFzsmx> domainlist=parfzsmxMapping.toDomain(parfzsmxdtos);
        for(ParFzsmx domain:domainlist){
             domain.setPartzggid(partzgg_id);
        }
        parfzsmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parfzsmxMapping.toDomain(returnObject.body),'ehr-ParFzsmx-Get')")
    @ApiOperation(value = "GetByPARTZGG", tags = {"ParFzsmx" },  notes = "GetByPARTZGG")
	@RequestMapping(method = RequestMethod.GET, value = "/partzggs/{partzgg_id}/parfzsmxes/{parfzsmx_id}")
    public ResponseEntity<ParFzsmxDTO> getByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @PathVariable("parfzsmx_id") String parfzsmx_id) {
        ParFzsmx domain = parfzsmxService.get(parfzsmx_id);
        ParFzsmxDTO dto = parfzsmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParFzsmx-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPARTZGG", tags = {"ParFzsmx" } ,notes = "fetchDEFAULTByPARTZGG")
    @RequestMapping(method= RequestMethod.GET , value="/partzggs/{partzgg_id}/parfzsmxes/fetchdefault")
	public ResponseEntity<List<ParFzsmxDTO>> fetchParFzsmxDefaultByPARTZGG(@PathVariable("partzgg_id") String partzgg_id,ParFzsmxSearchContext context) {
        context.setN_partzggid_eq(partzgg_id);
        Page<ParFzsmx> domains = parfzsmxService.searchDefault(context) ;
        List<ParFzsmxDTO> list = parfzsmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParFzsmx-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPARTZGG", tags = {"ParFzsmx" } ,notes = "searchDEFAULTByPARTZGG")
    @RequestMapping(method= RequestMethod.POST , value="/partzggs/{partzgg_id}/parfzsmxes/searchdefault")
	public ResponseEntity<Page<ParFzsmxDTO>> searchParFzsmxDefaultByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @RequestBody ParFzsmxSearchContext context) {
        context.setN_partzggid_eq(partzgg_id);
        Page<ParFzsmx> domains = parfzsmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parfzsmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "GetDraftByPIMPERSON", tags = {"ParFzsmx" },  notes = "GetDraftByPIMPERSON")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/parfzsmxes/getdraft")
    public ResponseEntity<ParFzsmxDTO> getDraftByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id) {
        ParFzsmx domain = new ParFzsmx();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(parfzsmxMapping.toDto(parfzsmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.parfzsmxService.get(#parfzsmx_id),'ehr-ParFzsmx-Update')")
    @ApiOperation(value = "UpdateByPIMPERSON", tags = {"ParFzsmx" },  notes = "UpdateByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/parfzsmxes/{parfzsmx_id}")
    @Transactional
    public ResponseEntity<ParFzsmxDTO> updateByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("parfzsmx_id") String parfzsmx_id, @RequestBody ParFzsmxDTO parfzsmxdto) {
        ParFzsmx domain = parfzsmxMapping.toDomain(parfzsmxdto);
        domain.setPimpersonid(pimperson_id);
        domain.setParfzsmxid(parfzsmx_id);
		parfzsmxService.update(domain);
        ParFzsmxDTO dto = parfzsmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parfzsmxService.getParfzsmxByEntities(this.parfzsmxMapping.toDomain(#parfzsmxdtos)),'ehr-ParFzsmx-Update')")
    @ApiOperation(value = "UpdateBatchByPIMPERSON", tags = {"ParFzsmx" },  notes = "UpdateBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/parfzsmxes/batch")
    public ResponseEntity<Boolean> updateBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<ParFzsmxDTO> parfzsmxdtos) {
        List<ParFzsmx> domainlist=parfzsmxMapping.toDomain(parfzsmxdtos);
        for(ParFzsmx domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        parfzsmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parfzsmxService.get(#parfzsmx_id),'ehr-ParFzsmx-Remove')")
    @ApiOperation(value = "RemoveByPIMPERSON", tags = {"ParFzsmx" },  notes = "RemoveByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/parfzsmxes/{parfzsmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("parfzsmx_id") String parfzsmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(parfzsmxService.remove(parfzsmx_id));
    }

    @PreAuthorize("hasPermission(this.parfzsmxService.getParfzsmxByIds(#ids),'ehr-ParFzsmx-Remove')")
    @ApiOperation(value = "RemoveBatchByPIMPERSON", tags = {"ParFzsmx" },  notes = "RemoveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/parfzsmxes/batch")
    public ResponseEntity<Boolean> removeBatchByPIMPERSON(@RequestBody List<String> ids) {
        parfzsmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parfzsmxMapping.toDomain(#parfzsmxdto),'ehr-ParFzsmx-Create')")
    @ApiOperation(value = "CreateByPIMPERSON", tags = {"ParFzsmx" },  notes = "CreateByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/parfzsmxes")
    @Transactional
    public ResponseEntity<ParFzsmxDTO> createByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ParFzsmxDTO parfzsmxdto) {
        ParFzsmx domain = parfzsmxMapping.toDomain(parfzsmxdto);
        domain.setPimpersonid(pimperson_id);
		parfzsmxService.create(domain);
        ParFzsmxDTO dto = parfzsmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parfzsmxMapping.toDomain(#parfzsmxdtos),'ehr-ParFzsmx-Create')")
    @ApiOperation(value = "createBatchByPIMPERSON", tags = {"ParFzsmx" },  notes = "createBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/parfzsmxes/batch")
    public ResponseEntity<Boolean> createBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<ParFzsmxDTO> parfzsmxdtos) {
        List<ParFzsmx> domainlist=parfzsmxMapping.toDomain(parfzsmxdtos);
        for(ParFzsmx domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        parfzsmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByPIMPERSON", tags = {"ParFzsmx" },  notes = "CheckKeyByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/parfzsmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ParFzsmxDTO parfzsmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parfzsmxService.checkKey(parfzsmxMapping.toDomain(parfzsmxdto)));
    }

    @PreAuthorize("hasPermission(this.parfzsmxMapping.toDomain(#parfzsmxdto),'ehr-ParFzsmx-Save')")
    @ApiOperation(value = "SaveByPIMPERSON", tags = {"ParFzsmx" },  notes = "SaveByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/parfzsmxes/save")
    public ResponseEntity<Boolean> saveByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ParFzsmxDTO parfzsmxdto) {
        ParFzsmx domain = parfzsmxMapping.toDomain(parfzsmxdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(parfzsmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.parfzsmxMapping.toDomain(#parfzsmxdtos),'ehr-ParFzsmx-Save')")
    @ApiOperation(value = "SaveBatchByPIMPERSON", tags = {"ParFzsmx" },  notes = "SaveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/parfzsmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<ParFzsmxDTO> parfzsmxdtos) {
        List<ParFzsmx> domainlist=parfzsmxMapping.toDomain(parfzsmxdtos);
        for(ParFzsmx domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        parfzsmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parfzsmxMapping.toDomain(returnObject.body),'ehr-ParFzsmx-Get')")
    @ApiOperation(value = "GetByPIMPERSON", tags = {"ParFzsmx" },  notes = "GetByPIMPERSON")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/parfzsmxes/{parfzsmx_id}")
    public ResponseEntity<ParFzsmxDTO> getByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("parfzsmx_id") String parfzsmx_id) {
        ParFzsmx domain = parfzsmxService.get(parfzsmx_id);
        ParFzsmxDTO dto = parfzsmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParFzsmx-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPIMPERSON", tags = {"ParFzsmx" } ,notes = "fetchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/parfzsmxes/fetchdefault")
	public ResponseEntity<List<ParFzsmxDTO>> fetchParFzsmxDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,ParFzsmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<ParFzsmx> domains = parfzsmxService.searchDefault(context) ;
        List<ParFzsmxDTO> list = parfzsmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParFzsmx-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPIMPERSON", tags = {"ParFzsmx" } ,notes = "searchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/parfzsmxes/searchdefault")
	public ResponseEntity<Page<ParFzsmxDTO>> searchParFzsmxDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ParFzsmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<ParFzsmx> domains = parfzsmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parfzsmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

