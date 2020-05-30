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
@Api(tags = {"通知选择助总领导明细" })
@RestController("WebApi-parfzsmx")
@RequestMapping("")
public class ParFzsmxResource {

    @Autowired
    public IParFzsmxService parfzsmxService;

    @Autowired
    @Lazy
    public ParFzsmxMapping parfzsmxMapping;

    @ApiOperation(value = "获取通知选择助总领导明细草稿", tags = {"通知选择助总领导明细" },  notes = "获取通知选择助总领导明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/parfzsmxes/getdraft")
    public ResponseEntity<ParFzsmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parfzsmxMapping.toDto(parfzsmxService.getDraft(new ParFzsmx())));
    }

    @PreAuthorize("hasPermission(this.parfzsmxService.get(#parfzsmx_id),'ehr-ParFzsmx-Update')")
    @ApiOperation(value = "更新通知选择助总领导明细", tags = {"通知选择助总领导明细" },  notes = "更新通知选择助总领导明细")
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
    @ApiOperation(value = "批量更新通知选择助总领导明细", tags = {"通知选择助总领导明细" },  notes = "批量更新通知选择助总领导明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/parfzsmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParFzsmxDTO> parfzsmxdtos) {
        parfzsmxService.updateBatch(parfzsmxMapping.toDomain(parfzsmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parfzsmxService.get(#parfzsmx_id),'ehr-ParFzsmx-Remove')")
    @ApiOperation(value = "删除通知选择助总领导明细", tags = {"通知选择助总领导明细" },  notes = "删除通知选择助总领导明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parfzsmxes/{parfzsmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parfzsmx_id") String parfzsmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parfzsmxService.remove(parfzsmx_id));
    }

    @PreAuthorize("hasPermission(this.parfzsmxService.getParfzsmxByIds(#ids),'ehr-ParFzsmx-Remove')")
    @ApiOperation(value = "批量删除通知选择助总领导明细", tags = {"通知选择助总领导明细" },  notes = "批量删除通知选择助总领导明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parfzsmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parfzsmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parfzsmxMapping.toDomain(#parfzsmxdto),'ehr-ParFzsmx-Create')")
    @ApiOperation(value = "新建通知选择助总领导明细", tags = {"通知选择助总领导明细" },  notes = "新建通知选择助总领导明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parfzsmxes")
    @Transactional
    public ResponseEntity<ParFzsmxDTO> create(@RequestBody ParFzsmxDTO parfzsmxdto) {
        ParFzsmx domain = parfzsmxMapping.toDomain(parfzsmxdto);
		parfzsmxService.create(domain);
        ParFzsmxDTO dto = parfzsmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parfzsmxMapping.toDomain(#parfzsmxdtos),'ehr-ParFzsmx-Create')")
    @ApiOperation(value = "批量新建通知选择助总领导明细", tags = {"通知选择助总领导明细" },  notes = "批量新建通知选择助总领导明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parfzsmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParFzsmxDTO> parfzsmxdtos) {
        parfzsmxService.createBatch(parfzsmxMapping.toDomain(parfzsmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查通知选择助总领导明细", tags = {"通知选择助总领导明细" },  notes = "检查通知选择助总领导明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parfzsmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParFzsmxDTO parfzsmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parfzsmxService.checkKey(parfzsmxMapping.toDomain(parfzsmxdto)));
    }

    @PreAuthorize("hasPermission(this.parfzsmxMapping.toDomain(#parfzsmxdto),'ehr-ParFzsmx-Save')")
    @ApiOperation(value = "保存通知选择助总领导明细", tags = {"通知选择助总领导明细" },  notes = "保存通知选择助总领导明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parfzsmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody ParFzsmxDTO parfzsmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parfzsmxService.save(parfzsmxMapping.toDomain(parfzsmxdto)));
    }

    @PreAuthorize("hasPermission(this.parfzsmxMapping.toDomain(#parfzsmxdtos),'ehr-ParFzsmx-Save')")
    @ApiOperation(value = "批量保存通知选择助总领导明细", tags = {"通知选择助总领导明细" },  notes = "批量保存通知选择助总领导明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parfzsmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParFzsmxDTO> parfzsmxdtos) {
        parfzsmxService.saveBatch(parfzsmxMapping.toDomain(parfzsmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parfzsmxMapping.toDomain(returnObject.body),'ehr-ParFzsmx-Get')")
    @ApiOperation(value = "获取通知选择助总领导明细", tags = {"通知选择助总领导明细" },  notes = "获取通知选择助总领导明细")
	@RequestMapping(method = RequestMethod.GET, value = "/parfzsmxes/{parfzsmx_id}")
    public ResponseEntity<ParFzsmxDTO> get(@PathVariable("parfzsmx_id") String parfzsmx_id) {
        ParFzsmx domain = parfzsmxService.get(parfzsmx_id);
        ParFzsmxDTO dto = parfzsmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParFzsmx-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"通知选择助总领导明细" } ,notes = "获取DEFAULT")
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
	@ApiOperation(value = "查询DEFAULT", tags = {"通知选择助总领导明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parfzsmxes/searchdefault")
	public ResponseEntity<Page<ParFzsmxDTO>> searchDefault(@RequestBody ParFzsmxSearchContext context) {
        Page<ParFzsmx> domains = parfzsmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parfzsmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据通知发布获取通知选择助总领导明细草稿", tags = {"通知选择助总领导明细" },  notes = "根据通知发布获取通知选择助总领导明细草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/partzggs/{partzgg_id}/parfzsmxes/getdraft")
    public ResponseEntity<ParFzsmxDTO> getDraftByParTzgg(@PathVariable("partzgg_id") String partzgg_id) {
        ParFzsmx domain = new ParFzsmx();
        domain.setPartzggid(partzgg_id);
        return ResponseEntity.status(HttpStatus.OK).body(parfzsmxMapping.toDto(parfzsmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.parfzsmxService.get(#parfzsmx_id),'ehr-ParFzsmx-Update')")
    @ApiOperation(value = "根据通知发布更新通知选择助总领导明细", tags = {"通知选择助总领导明细" },  notes = "根据通知发布更新通知选择助总领导明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/partzggs/{partzgg_id}/parfzsmxes/{parfzsmx_id}")
    @Transactional
    public ResponseEntity<ParFzsmxDTO> updateByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @PathVariable("parfzsmx_id") String parfzsmx_id, @RequestBody ParFzsmxDTO parfzsmxdto) {
        ParFzsmx domain = parfzsmxMapping.toDomain(parfzsmxdto);
        domain.setPartzggid(partzgg_id);
        domain.setParfzsmxid(parfzsmx_id);
		parfzsmxService.update(domain);
        ParFzsmxDTO dto = parfzsmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parfzsmxService.getParfzsmxByEntities(this.parfzsmxMapping.toDomain(#parfzsmxdtos)),'ehr-ParFzsmx-Update')")
    @ApiOperation(value = "根据通知发布批量更新通知选择助总领导明细", tags = {"通知选择助总领导明细" },  notes = "根据通知发布批量更新通知选择助总领导明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/partzggs/{partzgg_id}/parfzsmxes/batch")
    public ResponseEntity<Boolean> updateBatchByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @RequestBody List<ParFzsmxDTO> parfzsmxdtos) {
        List<ParFzsmx> domainlist=parfzsmxMapping.toDomain(parfzsmxdtos);
        for(ParFzsmx domain:domainlist){
            domain.setPartzggid(partzgg_id);
        }
        parfzsmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parfzsmxService.get(#parfzsmx_id),'ehr-ParFzsmx-Remove')")
    @ApiOperation(value = "根据通知发布删除通知选择助总领导明细", tags = {"通知选择助总领导明细" },  notes = "根据通知发布删除通知选择助总领导明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/partzggs/{partzgg_id}/parfzsmxes/{parfzsmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @PathVariable("parfzsmx_id") String parfzsmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(parfzsmxService.remove(parfzsmx_id));
    }

    @PreAuthorize("hasPermission(this.parfzsmxService.getParfzsmxByIds(#ids),'ehr-ParFzsmx-Remove')")
    @ApiOperation(value = "根据通知发布批量删除通知选择助总领导明细", tags = {"通知选择助总领导明细" },  notes = "根据通知发布批量删除通知选择助总领导明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/partzggs/{partzgg_id}/parfzsmxes/batch")
    public ResponseEntity<Boolean> removeBatchByParTzgg(@RequestBody List<String> ids) {
        parfzsmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parfzsmxMapping.toDomain(#parfzsmxdto),'ehr-ParFzsmx-Create')")
    @ApiOperation(value = "根据通知发布建立通知选择助总领导明细", tags = {"通知选择助总领导明细" },  notes = "根据通知发布建立通知选择助总领导明细")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parfzsmxes")
    @Transactional
    public ResponseEntity<ParFzsmxDTO> createByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @RequestBody ParFzsmxDTO parfzsmxdto) {
        ParFzsmx domain = parfzsmxMapping.toDomain(parfzsmxdto);
        domain.setPartzggid(partzgg_id);
		parfzsmxService.create(domain);
        ParFzsmxDTO dto = parfzsmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parfzsmxMapping.toDomain(#parfzsmxdtos),'ehr-ParFzsmx-Create')")
    @ApiOperation(value = "根据通知发布批量建立通知选择助总领导明细", tags = {"通知选择助总领导明细" },  notes = "根据通知发布批量建立通知选择助总领导明细")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parfzsmxes/batch")
    public ResponseEntity<Boolean> createBatchByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @RequestBody List<ParFzsmxDTO> parfzsmxdtos) {
        List<ParFzsmx> domainlist=parfzsmxMapping.toDomain(parfzsmxdtos);
        for(ParFzsmx domain:domainlist){
            domain.setPartzggid(partzgg_id);
        }
        parfzsmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据通知发布检查通知选择助总领导明细", tags = {"通知选择助总领导明细" },  notes = "根据通知发布检查通知选择助总领导明细")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parfzsmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @RequestBody ParFzsmxDTO parfzsmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parfzsmxService.checkKey(parfzsmxMapping.toDomain(parfzsmxdto)));
    }

    @PreAuthorize("hasPermission(this.parfzsmxMapping.toDomain(#parfzsmxdto),'ehr-ParFzsmx-Save')")
    @ApiOperation(value = "根据通知发布保存通知选择助总领导明细", tags = {"通知选择助总领导明细" },  notes = "根据通知发布保存通知选择助总领导明细")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parfzsmxes/save")
    public ResponseEntity<Boolean> saveByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @RequestBody ParFzsmxDTO parfzsmxdto) {
        ParFzsmx domain = parfzsmxMapping.toDomain(parfzsmxdto);
        domain.setPartzggid(partzgg_id);
        return ResponseEntity.status(HttpStatus.OK).body(parfzsmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.parfzsmxMapping.toDomain(#parfzsmxdtos),'ehr-ParFzsmx-Save')")
    @ApiOperation(value = "根据通知发布批量保存通知选择助总领导明细", tags = {"通知选择助总领导明细" },  notes = "根据通知发布批量保存通知选择助总领导明细")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parfzsmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @RequestBody List<ParFzsmxDTO> parfzsmxdtos) {
        List<ParFzsmx> domainlist=parfzsmxMapping.toDomain(parfzsmxdtos);
        for(ParFzsmx domain:domainlist){
             domain.setPartzggid(partzgg_id);
        }
        parfzsmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parfzsmxMapping.toDomain(returnObject.body),'ehr-ParFzsmx-Get')")
    @ApiOperation(value = "根据通知发布获取通知选择助总领导明细", tags = {"通知选择助总领导明细" },  notes = "根据通知发布获取通知选择助总领导明细")
	@RequestMapping(method = RequestMethod.GET, value = "/partzggs/{partzgg_id}/parfzsmxes/{parfzsmx_id}")
    public ResponseEntity<ParFzsmxDTO> getByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @PathVariable("parfzsmx_id") String parfzsmx_id) {
        ParFzsmx domain = parfzsmxService.get(parfzsmx_id);
        ParFzsmxDTO dto = parfzsmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParFzsmx-Default-all')")
	@ApiOperation(value = "根据通知发布获取DEFAULT", tags = {"通知选择助总领导明细" } ,notes = "根据通知发布获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/partzggs/{partzgg_id}/parfzsmxes/fetchdefault")
	public ResponseEntity<List<ParFzsmxDTO>> fetchParFzsmxDefaultByParTzgg(@PathVariable("partzgg_id") String partzgg_id,ParFzsmxSearchContext context) {
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
	@ApiOperation(value = "根据通知发布查询DEFAULT", tags = {"通知选择助总领导明细" } ,notes = "根据通知发布查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/partzggs/{partzgg_id}/parfzsmxes/searchdefault")
	public ResponseEntity<Page<ParFzsmxDTO>> searchParFzsmxDefaultByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @RequestBody ParFzsmxSearchContext context) {
        context.setN_partzggid_eq(partzgg_id);
        Page<ParFzsmx> domains = parfzsmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parfzsmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据人员信息获取通知选择助总领导明细草稿", tags = {"通知选择助总领导明细" },  notes = "根据人员信息获取通知选择助总领导明细草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/parfzsmxes/getdraft")
    public ResponseEntity<ParFzsmxDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        ParFzsmx domain = new ParFzsmx();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(parfzsmxMapping.toDto(parfzsmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.parfzsmxService.get(#parfzsmx_id),'ehr-ParFzsmx-Update')")
    @ApiOperation(value = "根据人员信息更新通知选择助总领导明细", tags = {"通知选择助总领导明细" },  notes = "根据人员信息更新通知选择助总领导明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/parfzsmxes/{parfzsmx_id}")
    @Transactional
    public ResponseEntity<ParFzsmxDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("parfzsmx_id") String parfzsmx_id, @RequestBody ParFzsmxDTO parfzsmxdto) {
        ParFzsmx domain = parfzsmxMapping.toDomain(parfzsmxdto);
        domain.setPimpersonid(pimperson_id);
        domain.setParfzsmxid(parfzsmx_id);
		parfzsmxService.update(domain);
        ParFzsmxDTO dto = parfzsmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parfzsmxService.getParfzsmxByEntities(this.parfzsmxMapping.toDomain(#parfzsmxdtos)),'ehr-ParFzsmx-Update')")
    @ApiOperation(value = "根据人员信息批量更新通知选择助总领导明细", tags = {"通知选择助总领导明细" },  notes = "根据人员信息批量更新通知选择助总领导明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/parfzsmxes/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<ParFzsmxDTO> parfzsmxdtos) {
        List<ParFzsmx> domainlist=parfzsmxMapping.toDomain(parfzsmxdtos);
        for(ParFzsmx domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        parfzsmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parfzsmxService.get(#parfzsmx_id),'ehr-ParFzsmx-Remove')")
    @ApiOperation(value = "根据人员信息删除通知选择助总领导明细", tags = {"通知选择助总领导明细" },  notes = "根据人员信息删除通知选择助总领导明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/parfzsmxes/{parfzsmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("parfzsmx_id") String parfzsmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(parfzsmxService.remove(parfzsmx_id));
    }

    @PreAuthorize("hasPermission(this.parfzsmxService.getParfzsmxByIds(#ids),'ehr-ParFzsmx-Remove')")
    @ApiOperation(value = "根据人员信息批量删除通知选择助总领导明细", tags = {"通知选择助总领导明细" },  notes = "根据人员信息批量删除通知选择助总领导明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/parfzsmxes/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        parfzsmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parfzsmxMapping.toDomain(#parfzsmxdto),'ehr-ParFzsmx-Create')")
    @ApiOperation(value = "根据人员信息建立通知选择助总领导明细", tags = {"通知选择助总领导明细" },  notes = "根据人员信息建立通知选择助总领导明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/parfzsmxes")
    @Transactional
    public ResponseEntity<ParFzsmxDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ParFzsmxDTO parfzsmxdto) {
        ParFzsmx domain = parfzsmxMapping.toDomain(parfzsmxdto);
        domain.setPimpersonid(pimperson_id);
		parfzsmxService.create(domain);
        ParFzsmxDTO dto = parfzsmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parfzsmxMapping.toDomain(#parfzsmxdtos),'ehr-ParFzsmx-Create')")
    @ApiOperation(value = "根据人员信息批量建立通知选择助总领导明细", tags = {"通知选择助总领导明细" },  notes = "根据人员信息批量建立通知选择助总领导明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/parfzsmxes/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<ParFzsmxDTO> parfzsmxdtos) {
        List<ParFzsmx> domainlist=parfzsmxMapping.toDomain(parfzsmxdtos);
        for(ParFzsmx domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        parfzsmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息检查通知选择助总领导明细", tags = {"通知选择助总领导明细" },  notes = "根据人员信息检查通知选择助总领导明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/parfzsmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ParFzsmxDTO parfzsmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parfzsmxService.checkKey(parfzsmxMapping.toDomain(parfzsmxdto)));
    }

    @PreAuthorize("hasPermission(this.parfzsmxMapping.toDomain(#parfzsmxdto),'ehr-ParFzsmx-Save')")
    @ApiOperation(value = "根据人员信息保存通知选择助总领导明细", tags = {"通知选择助总领导明细" },  notes = "根据人员信息保存通知选择助总领导明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/parfzsmxes/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ParFzsmxDTO parfzsmxdto) {
        ParFzsmx domain = parfzsmxMapping.toDomain(parfzsmxdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(parfzsmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.parfzsmxMapping.toDomain(#parfzsmxdtos),'ehr-ParFzsmx-Save')")
    @ApiOperation(value = "根据人员信息批量保存通知选择助总领导明细", tags = {"通知选择助总领导明细" },  notes = "根据人员信息批量保存通知选择助总领导明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/parfzsmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<ParFzsmxDTO> parfzsmxdtos) {
        List<ParFzsmx> domainlist=parfzsmxMapping.toDomain(parfzsmxdtos);
        for(ParFzsmx domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        parfzsmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parfzsmxMapping.toDomain(returnObject.body),'ehr-ParFzsmx-Get')")
    @ApiOperation(value = "根据人员信息获取通知选择助总领导明细", tags = {"通知选择助总领导明细" },  notes = "根据人员信息获取通知选择助总领导明细")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/parfzsmxes/{parfzsmx_id}")
    public ResponseEntity<ParFzsmxDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("parfzsmx_id") String parfzsmx_id) {
        ParFzsmx domain = parfzsmxService.get(parfzsmx_id);
        ParFzsmxDTO dto = parfzsmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParFzsmx-Default-all')")
	@ApiOperation(value = "根据人员信息获取DEFAULT", tags = {"通知选择助总领导明细" } ,notes = "根据人员信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/parfzsmxes/fetchdefault")
	public ResponseEntity<List<ParFzsmxDTO>> fetchParFzsmxDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,ParFzsmxSearchContext context) {
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
	@ApiOperation(value = "根据人员信息查询DEFAULT", tags = {"通知选择助总领导明细" } ,notes = "根据人员信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/parfzsmxes/searchdefault")
	public ResponseEntity<Page<ParFzsmxDTO>> searchParFzsmxDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ParFzsmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<ParFzsmx> domains = parfzsmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parfzsmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

