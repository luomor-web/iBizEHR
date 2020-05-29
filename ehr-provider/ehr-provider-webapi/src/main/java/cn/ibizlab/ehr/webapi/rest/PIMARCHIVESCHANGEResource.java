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
@Api(tags = {"档案归档地变更记录" })
@RestController("WebApi-pimarchiveschange")
@RequestMapping("")
public class PIMARCHIVESCHANGEResource {

    @Autowired
    public IPIMARCHIVESCHANGEService pimarchiveschangeService;

    @Autowired
    @Lazy
    public PIMARCHIVESCHANGEMapping pimarchiveschangeMapping;

    @PreAuthorize("hasPermission(this.pimarchiveschangeService.get(#pimarchiveschange_id),'ehr-PIMARCHIVESCHANGE-Update')")
    @ApiOperation(value = "更新档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "更新档案归档地变更记录")
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
    @ApiOperation(value = "批量更新档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "批量更新档案归档地变更记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchiveschanges/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMARCHIVESCHANGEDTO> pimarchiveschangedtos) {
        pimarchiveschangeService.updateBatch(pimarchiveschangeMapping.toDomain(pimarchiveschangedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(returnObject.body),'ehr-PIMARCHIVESCHANGE-Get')")
    @ApiOperation(value = "获取档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "获取档案归档地变更记录")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarchiveschanges/{pimarchiveschange_id}")
    public ResponseEntity<PIMARCHIVESCHANGEDTO> get(@PathVariable("pimarchiveschange_id") String pimarchiveschange_id) {
        PIMARCHIVESCHANGE domain = pimarchiveschangeService.get(pimarchiveschange_id);
        PIMARCHIVESCHANGEDTO dto = pimarchiveschangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedto),'ehr-PIMARCHIVESCHANGE-Create')")
    @ApiOperation(value = "新建档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "新建档案归档地变更记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchiveschanges")
    @Transactional
    public ResponseEntity<PIMARCHIVESCHANGEDTO> create(@RequestBody PIMARCHIVESCHANGEDTO pimarchiveschangedto) {
        PIMARCHIVESCHANGE domain = pimarchiveschangeMapping.toDomain(pimarchiveschangedto);
		pimarchiveschangeService.create(domain);
        PIMARCHIVESCHANGEDTO dto = pimarchiveschangeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedtos),'ehr-PIMARCHIVESCHANGE-Create')")
    @ApiOperation(value = "批量新建档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "批量新建档案归档地变更记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchiveschanges/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMARCHIVESCHANGEDTO> pimarchiveschangedtos) {
        pimarchiveschangeService.createBatch(pimarchiveschangeMapping.toDomain(pimarchiveschangedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取档案归档地变更记录草稿", tags = {"档案归档地变更记录" },  notes = "获取档案归档地变更记录草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarchiveschanges/getdraft")
    public ResponseEntity<PIMARCHIVESCHANGEDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeMapping.toDto(pimarchiveschangeService.getDraft(new PIMARCHIVESCHANGE())));
    }

    @ApiOperation(value = "检查档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "检查档案归档地变更记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchiveschanges/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMARCHIVESCHANGEDTO pimarchiveschangedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeService.checkKey(pimarchiveschangeMapping.toDomain(pimarchiveschangedto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESCHANGE-UpdatePersonFile-all')")
    @ApiOperation(value = "更新档案信息", tags = {"档案归档地变更记录" },  notes = "更新档案信息")
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
    @ApiOperation(value = "保存档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "保存档案归档地变更记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchiveschanges/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMARCHIVESCHANGEDTO pimarchiveschangedto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeService.save(pimarchiveschangeMapping.toDomain(pimarchiveschangedto)));
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedtos),'ehr-PIMARCHIVESCHANGE-Save')")
    @ApiOperation(value = "批量保存档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "批量保存档案归档地变更记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchiveschanges/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMARCHIVESCHANGEDTO> pimarchiveschangedtos) {
        pimarchiveschangeService.saveBatch(pimarchiveschangeMapping.toDomain(pimarchiveschangedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeService.get(#pimarchiveschange_id),'ehr-PIMARCHIVESCHANGE-Remove')")
    @ApiOperation(value = "删除档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "删除档案归档地变更记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchiveschanges/{pimarchiveschange_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimarchiveschange_id") String pimarchiveschange_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeService.remove(pimarchiveschange_id));
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeService.getPimarchiveschangeByIds(#ids),'ehr-PIMARCHIVESCHANGE-Remove')")
    @ApiOperation(value = "批量删除档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "批量删除档案归档地变更记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchiveschanges/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimarchiveschangeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESCHANGE-DADCJL-all')")
	@ApiOperation(value = "获取档案调出记录", tags = {"档案归档地变更记录" } ,notes = "获取档案调出记录")
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
	@ApiOperation(value = "查询档案调出记录", tags = {"档案归档地变更记录" } ,notes = "查询档案调出记录")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchiveschanges/searchdadcjl")
	public ResponseEntity<Page<PIMARCHIVESCHANGEDTO>> searchDADCJL(@RequestBody PIMARCHIVESCHANGESearchContext context) {
        Page<PIMARCHIVESCHANGE> domains = pimarchiveschangeService.searchDADCJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchiveschangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESCHANGE-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"档案归档地变更记录" } ,notes = "获取DEFAULT")
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
	@ApiOperation(value = "查询DEFAULT", tags = {"档案归档地变更记录" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchiveschanges/searchdefault")
	public ResponseEntity<Page<PIMARCHIVESCHANGEDTO>> searchDefault(@RequestBody PIMARCHIVESCHANGESearchContext context) {
        Page<PIMARCHIVESCHANGE> domains = pimarchiveschangeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchiveschangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pimarchiveschangeService.get(#pimarchiveschange_id),'ehr-PIMARCHIVESCHANGE-Update')")
    @ApiOperation(value = "根据档案信息更新档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据档案信息更新档案归档地变更记录")
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
    @ApiOperation(value = "根据档案信息批量更新档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据档案信息批量更新档案归档地变更记录")
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
    @ApiOperation(value = "根据档案信息获取档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据档案信息获取档案归档地变更记录")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/{pimarchiveschange_id}")
    public ResponseEntity<PIMARCHIVESCHANGEDTO> getByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchiveschange_id") String pimarchiveschange_id) {
        PIMARCHIVESCHANGE domain = pimarchiveschangeService.get(pimarchiveschange_id);
        PIMARCHIVESCHANGEDTO dto = pimarchiveschangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedto),'ehr-PIMARCHIVESCHANGE-Create')")
    @ApiOperation(value = "根据档案信息建立档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据档案信息建立档案归档地变更记录")
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
    @ApiOperation(value = "根据档案信息批量建立档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据档案信息批量建立档案归档地变更记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/batch")
    public ResponseEntity<Boolean> createBatchByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PIMARCHIVESCHANGEDTO> pimarchiveschangedtos) {
        List<PIMARCHIVESCHANGE> domainlist=pimarchiveschangeMapping.toDomain(pimarchiveschangedtos);
        for(PIMARCHIVESCHANGE domain:domainlist){
            domain.setPimarchivesid(pimarchives_id);
        }
        pimarchiveschangeService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据档案信息获取档案归档地变更记录草稿", tags = {"档案归档地变更记录" },  notes = "根据档案信息获取档案归档地变更记录草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/getdraft")
    public ResponseEntity<PIMARCHIVESCHANGEDTO> getDraftByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id) {
        PIMARCHIVESCHANGE domain = new PIMARCHIVESCHANGE();
        domain.setPimarchivesid(pimarchives_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeMapping.toDto(pimarchiveschangeService.getDraft(domain)));
    }

    @ApiOperation(value = "根据档案信息检查档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据档案信息检查档案归档地变更记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESCHANGEDTO pimarchiveschangedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeService.checkKey(pimarchiveschangeMapping.toDomain(pimarchiveschangedto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESCHANGE-UpdatePersonFile-all')")
    @ApiOperation(value = "根据档案信息档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据档案信息档案归档地变更记录")
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
    @ApiOperation(value = "根据档案信息保存档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据档案信息保存档案归档地变更记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/save")
    public ResponseEntity<Boolean> saveByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESCHANGEDTO pimarchiveschangedto) {
        PIMARCHIVESCHANGE domain = pimarchiveschangeMapping.toDomain(pimarchiveschangedto);
        domain.setPimarchivesid(pimarchives_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedtos),'ehr-PIMARCHIVESCHANGE-Save')")
    @ApiOperation(value = "根据档案信息批量保存档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据档案信息批量保存档案归档地变更记录")
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
    @ApiOperation(value = "根据档案信息删除档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据档案信息删除档案归档地变更记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/{pimarchiveschange_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchiveschange_id") String pimarchiveschange_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeService.remove(pimarchiveschange_id));
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeService.getPimarchiveschangeByIds(#ids),'ehr-PIMARCHIVESCHANGE-Remove')")
    @ApiOperation(value = "根据档案信息批量删除档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据档案信息批量删除档案归档地变更记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/batch")
    public ResponseEntity<Boolean> removeBatchByPimArchives(@RequestBody List<String> ids) {
        pimarchiveschangeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESCHANGE-DADCJL-all')")
	@ApiOperation(value = "根据档案信息获取档案调出记录", tags = {"档案归档地变更记录" } ,notes = "根据档案信息获取档案调出记录")
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
	@ApiOperation(value = "根据档案信息查询档案调出记录", tags = {"档案归档地变更记录" } ,notes = "根据档案信息查询档案调出记录")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchives/{pimarchives_id}/pimarchiveschanges/searchdadcjl")
	public ResponseEntity<Page<PIMARCHIVESCHANGEDTO>> searchPIMARCHIVESCHANGEDADCJLByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESCHANGESearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PIMARCHIVESCHANGE> domains = pimarchiveschangeService.searchDADCJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchiveschangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESCHANGE-Default-all')")
	@ApiOperation(value = "根据档案信息获取DEFAULT", tags = {"档案归档地变更记录" } ,notes = "根据档案信息获取DEFAULT")
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
	@ApiOperation(value = "根据档案信息查询DEFAULT", tags = {"档案归档地变更记录" } ,notes = "根据档案信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchives/{pimarchives_id}/pimarchiveschanges/searchdefault")
	public ResponseEntity<Page<PIMARCHIVESCHANGEDTO>> searchPIMARCHIVESCHANGEDefaultByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESCHANGESearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PIMARCHIVESCHANGE> domains = pimarchiveschangeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchiveschangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pimarchiveschangeService.get(#pimarchiveschange_id),'ehr-PIMARCHIVESCHANGE-Update')")
    @ApiOperation(value = "根据人员信息档案信息更新档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据人员信息档案信息更新档案归档地变更记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/{pimarchiveschange_id}")
    @Transactional
    public ResponseEntity<PIMARCHIVESCHANGEDTO> updateByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchiveschange_id") String pimarchiveschange_id, @RequestBody PIMARCHIVESCHANGEDTO pimarchiveschangedto) {
        PIMARCHIVESCHANGE domain = pimarchiveschangeMapping.toDomain(pimarchiveschangedto);
        domain.setPimarchivesid(pimarchives_id);
        domain.setPimarchiveschangeid(pimarchiveschange_id);
		pimarchiveschangeService.update(domain);
        PIMARCHIVESCHANGEDTO dto = pimarchiveschangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeService.getPimarchiveschangeByEntities(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedtos)),'ehr-PIMARCHIVESCHANGE-Update')")
    @ApiOperation(value = "根据人员信息档案信息批量更新档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据人员信息档案信息批量更新档案归档地变更记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/batch")
    public ResponseEntity<Boolean> updateBatchByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PIMARCHIVESCHANGEDTO> pimarchiveschangedtos) {
        List<PIMARCHIVESCHANGE> domainlist=pimarchiveschangeMapping.toDomain(pimarchiveschangedtos);
        for(PIMARCHIVESCHANGE domain:domainlist){
            domain.setPimarchivesid(pimarchives_id);
        }
        pimarchiveschangeService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(returnObject.body),'ehr-PIMARCHIVESCHANGE-Get')")
    @ApiOperation(value = "根据人员信息档案信息获取档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据人员信息档案信息获取档案归档地变更记录")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/{pimarchiveschange_id}")
    public ResponseEntity<PIMARCHIVESCHANGEDTO> getByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchiveschange_id") String pimarchiveschange_id) {
        PIMARCHIVESCHANGE domain = pimarchiveschangeService.get(pimarchiveschange_id);
        PIMARCHIVESCHANGEDTO dto = pimarchiveschangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedto),'ehr-PIMARCHIVESCHANGE-Create')")
    @ApiOperation(value = "根据人员信息档案信息建立档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据人员信息档案信息建立档案归档地变更记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges")
    @Transactional
    public ResponseEntity<PIMARCHIVESCHANGEDTO> createByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESCHANGEDTO pimarchiveschangedto) {
        PIMARCHIVESCHANGE domain = pimarchiveschangeMapping.toDomain(pimarchiveschangedto);
        domain.setPimarchivesid(pimarchives_id);
		pimarchiveschangeService.create(domain);
        PIMARCHIVESCHANGEDTO dto = pimarchiveschangeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedtos),'ehr-PIMARCHIVESCHANGE-Create')")
    @ApiOperation(value = "根据人员信息档案信息批量建立档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据人员信息档案信息批量建立档案归档地变更记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/batch")
    public ResponseEntity<Boolean> createBatchByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PIMARCHIVESCHANGEDTO> pimarchiveschangedtos) {
        List<PIMARCHIVESCHANGE> domainlist=pimarchiveschangeMapping.toDomain(pimarchiveschangedtos);
        for(PIMARCHIVESCHANGE domain:domainlist){
            domain.setPimarchivesid(pimarchives_id);
        }
        pimarchiveschangeService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息档案信息获取档案归档地变更记录草稿", tags = {"档案归档地变更记录" },  notes = "根据人员信息档案信息获取档案归档地变更记录草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/getdraft")
    public ResponseEntity<PIMARCHIVESCHANGEDTO> getDraftByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id) {
        PIMARCHIVESCHANGE domain = new PIMARCHIVESCHANGE();
        domain.setPimarchivesid(pimarchives_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeMapping.toDto(pimarchiveschangeService.getDraft(domain)));
    }

    @ApiOperation(value = "根据人员信息档案信息检查档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据人员信息档案信息检查档案归档地变更记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESCHANGEDTO pimarchiveschangedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeService.checkKey(pimarchiveschangeMapping.toDomain(pimarchiveschangedto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESCHANGE-UpdatePersonFile-all')")
    @ApiOperation(value = "根据人员信息档案信息档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据人员信息档案信息档案归档地变更记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/{pimarchiveschange_id}/updatepersonfile")
    @Transactional
    public ResponseEntity<PIMARCHIVESCHANGEDTO> updatePersonFileByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchiveschange_id") String pimarchiveschange_id, @RequestBody PIMARCHIVESCHANGEDTO pimarchiveschangedto) {
        PIMARCHIVESCHANGE domain = pimarchiveschangeMapping.toDomain(pimarchiveschangedto);
        domain.setPimarchivesid(pimarchives_id);
        domain = pimarchiveschangeService.updatePersonFile(domain) ;
        pimarchiveschangedto = pimarchiveschangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangedto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedto),'ehr-PIMARCHIVESCHANGE-Save')")
    @ApiOperation(value = "根据人员信息档案信息保存档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据人员信息档案信息保存档案归档地变更记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/save")
    public ResponseEntity<Boolean> saveByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESCHANGEDTO pimarchiveschangedto) {
        PIMARCHIVESCHANGE domain = pimarchiveschangeMapping.toDomain(pimarchiveschangedto);
        domain.setPimarchivesid(pimarchives_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedtos),'ehr-PIMARCHIVESCHANGE-Save')")
    @ApiOperation(value = "根据人员信息档案信息批量保存档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据人员信息档案信息批量保存档案归档地变更记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PIMARCHIVESCHANGEDTO> pimarchiveschangedtos) {
        List<PIMARCHIVESCHANGE> domainlist=pimarchiveschangeMapping.toDomain(pimarchiveschangedtos);
        for(PIMARCHIVESCHANGE domain:domainlist){
             domain.setPimarchivesid(pimarchives_id);
        }
        pimarchiveschangeService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeService.get(#pimarchiveschange_id),'ehr-PIMARCHIVESCHANGE-Remove')")
    @ApiOperation(value = "根据人员信息档案信息删除档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据人员信息档案信息删除档案归档地变更记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/{pimarchiveschange_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchiveschange_id") String pimarchiveschange_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeService.remove(pimarchiveschange_id));
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeService.getPimarchiveschangeByIds(#ids),'ehr-PIMARCHIVESCHANGE-Remove')")
    @ApiOperation(value = "根据人员信息档案信息批量删除档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据人员信息档案信息批量删除档案归档地变更记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/batch")
    public ResponseEntity<Boolean> removeBatchByPimPersonPimArchives(@RequestBody List<String> ids) {
        pimarchiveschangeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESCHANGE-DADCJL-all')")
	@ApiOperation(value = "根据人员信息档案信息获取档案调出记录", tags = {"档案归档地变更记录" } ,notes = "根据人员信息档案信息获取档案调出记录")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/fetchdadcjl")
	public ResponseEntity<List<PIMARCHIVESCHANGEDTO>> fetchPIMARCHIVESCHANGEDADCJLByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id,PIMARCHIVESCHANGESearchContext context) {
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
	@ApiOperation(value = "根据人员信息档案信息查询档案调出记录", tags = {"档案归档地变更记录" } ,notes = "根据人员信息档案信息查询档案调出记录")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/searchdadcjl")
	public ResponseEntity<Page<PIMARCHIVESCHANGEDTO>> searchPIMARCHIVESCHANGEDADCJLByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESCHANGESearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PIMARCHIVESCHANGE> domains = pimarchiveschangeService.searchDADCJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchiveschangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESCHANGE-Default-all')")
	@ApiOperation(value = "根据人员信息档案信息获取DEFAULT", tags = {"档案归档地变更记录" } ,notes = "根据人员信息档案信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/fetchdefault")
	public ResponseEntity<List<PIMARCHIVESCHANGEDTO>> fetchPIMARCHIVESCHANGEDefaultByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id,PIMARCHIVESCHANGESearchContext context) {
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
	@ApiOperation(value = "根据人员信息档案信息查询DEFAULT", tags = {"档案归档地变更记录" } ,notes = "根据人员信息档案信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/searchdefault")
	public ResponseEntity<Page<PIMARCHIVESCHANGEDTO>> searchPIMARCHIVESCHANGEDefaultByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESCHANGESearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PIMARCHIVESCHANGE> domains = pimarchiveschangeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchiveschangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

