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
import cn.ibizlab.ehr.core.pim.domain.PimArchivesChange;
import cn.ibizlab.ehr.core.pim.service.IPimArchivesChangeService;
import cn.ibizlab.ehr.core.pim.filter.PimArchivesChangeSearchContext;

@Slf4j
@Api(tags = {"档案归档地变更记录" })
@RestController("WebApi-pimarchiveschange")
@RequestMapping("")
public class PimArchivesChangeResource {

    @Autowired
    public IPimArchivesChangeService pimarchiveschangeService;

    @Autowired
    @Lazy
    public PimArchivesChangeMapping pimarchiveschangeMapping;

    @PreAuthorize("hasPermission(this.pimarchiveschangeService.get(#pimarchiveschange_id),'ehr-PimArchivesChange-Update')")
    @ApiOperation(value = "更新档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "更新档案归档地变更记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchiveschanges/{pimarchiveschange_id}")
    @Transactional
    public ResponseEntity<PimArchivesChangeDTO> update(@PathVariable("pimarchiveschange_id") String pimarchiveschange_id, @RequestBody PimArchivesChangeDTO pimarchiveschangedto) {
		PimArchivesChange domain  = pimarchiveschangeMapping.toDomain(pimarchiveschangedto);
        domain .setPimarchiveschangeid(pimarchiveschange_id);
		pimarchiveschangeService.update(domain );
		PimArchivesChangeDTO dto = pimarchiveschangeMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeService.getPimarchiveschangeByEntities(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedtos)),'ehr-PimArchivesChange-Update')")
    @ApiOperation(value = "批量更新档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "批量更新档案归档地变更记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchiveschanges/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimArchivesChangeDTO> pimarchiveschangedtos) {
        pimarchiveschangeService.updateBatch(pimarchiveschangeMapping.toDomain(pimarchiveschangedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(returnObject.body),'ehr-PimArchivesChange-Get')")
    @ApiOperation(value = "获取档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "获取档案归档地变更记录")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarchiveschanges/{pimarchiveschange_id}")
    public ResponseEntity<PimArchivesChangeDTO> get(@PathVariable("pimarchiveschange_id") String pimarchiveschange_id) {
        PimArchivesChange domain = pimarchiveschangeService.get(pimarchiveschange_id);
        PimArchivesChangeDTO dto = pimarchiveschangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedto),'ehr-PimArchivesChange-Create')")
    @ApiOperation(value = "新建档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "新建档案归档地变更记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchiveschanges")
    @Transactional
    public ResponseEntity<PimArchivesChangeDTO> create(@RequestBody PimArchivesChangeDTO pimarchiveschangedto) {
        PimArchivesChange domain = pimarchiveschangeMapping.toDomain(pimarchiveschangedto);
		pimarchiveschangeService.create(domain);
        PimArchivesChangeDTO dto = pimarchiveschangeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedtos),'ehr-PimArchivesChange-Create')")
    @ApiOperation(value = "批量新建档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "批量新建档案归档地变更记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchiveschanges/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimArchivesChangeDTO> pimarchiveschangedtos) {
        pimarchiveschangeService.createBatch(pimarchiveschangeMapping.toDomain(pimarchiveschangedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取档案归档地变更记录草稿", tags = {"档案归档地变更记录" },  notes = "获取档案归档地变更记录草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarchiveschanges/getdraft")
    public ResponseEntity<PimArchivesChangeDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeMapping.toDto(pimarchiveschangeService.getDraft(new PimArchivesChange())));
    }

    @ApiOperation(value = "检查档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "检查档案归档地变更记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchiveschanges/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimArchivesChangeDTO pimarchiveschangedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeService.checkKey(pimarchiveschangeMapping.toDomain(pimarchiveschangedto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchivesChange-UpdatePersonFile-all')")
    @ApiOperation(value = "更新档案信息", tags = {"档案归档地变更记录" },  notes = "更新档案信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchiveschanges/{pimarchiveschange_id}/updatepersonfile")
    @Transactional
    public ResponseEntity<PimArchivesChangeDTO> updatePersonFile(@PathVariable("pimarchiveschange_id") String pimarchiveschange_id, @RequestBody PimArchivesChangeDTO pimarchiveschangedto) {
        PimArchivesChange pimarchiveschange = pimarchiveschangeMapping.toDomain(pimarchiveschangedto);
        pimarchiveschange.setPimarchiveschangeid(pimarchiveschange_id);
        pimarchiveschange = pimarchiveschangeService.updatePersonFile(pimarchiveschange);
        pimarchiveschangedto = pimarchiveschangeMapping.toDto(pimarchiveschange);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangedto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedto),'ehr-PimArchivesChange-Save')")
    @ApiOperation(value = "保存档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "保存档案归档地变更记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchiveschanges/save")
    public ResponseEntity<Boolean> save(@RequestBody PimArchivesChangeDTO pimarchiveschangedto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeService.save(pimarchiveschangeMapping.toDomain(pimarchiveschangedto)));
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedtos),'ehr-PimArchivesChange-Save')")
    @ApiOperation(value = "批量保存档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "批量保存档案归档地变更记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchiveschanges/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimArchivesChangeDTO> pimarchiveschangedtos) {
        pimarchiveschangeService.saveBatch(pimarchiveschangeMapping.toDomain(pimarchiveschangedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeService.get(#pimarchiveschange_id),'ehr-PimArchivesChange-Remove')")
    @ApiOperation(value = "删除档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "删除档案归档地变更记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchiveschanges/{pimarchiveschange_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimarchiveschange_id") String pimarchiveschange_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeService.remove(pimarchiveschange_id));
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeService.getPimarchiveschangeByIds(#ids),'ehr-PimArchivesChange-Remove')")
    @ApiOperation(value = "批量删除档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "批量删除档案归档地变更记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchiveschanges/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimarchiveschangeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchivesChange-DADCJL-all')")
	@ApiOperation(value = "获取档案调出记录", tags = {"档案归档地变更记录" } ,notes = "获取档案调出记录")
    @RequestMapping(method= RequestMethod.GET , value="/pimarchiveschanges/fetchdadcjl")
	public ResponseEntity<List<PimArchivesChangeDTO>> fetchDADCJL(PimArchivesChangeSearchContext context) {
        Page<PimArchivesChange> domains = pimarchiveschangeService.searchDADCJL(context) ;
        List<PimArchivesChangeDTO> list = pimarchiveschangeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchivesChange-DADCJL-all')")
	@ApiOperation(value = "查询档案调出记录", tags = {"档案归档地变更记录" } ,notes = "查询档案调出记录")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchiveschanges/searchdadcjl")
	public ResponseEntity<Page<PimArchivesChangeDTO>> searchDADCJL(@RequestBody PimArchivesChangeSearchContext context) {
        Page<PimArchivesChange> domains = pimarchiveschangeService.searchDADCJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchiveschangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchivesChange-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"档案归档地变更记录" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimarchiveschanges/fetchdefault")
	public ResponseEntity<List<PimArchivesChangeDTO>> fetchDefault(PimArchivesChangeSearchContext context) {
        Page<PimArchivesChange> domains = pimarchiveschangeService.searchDefault(context) ;
        List<PimArchivesChangeDTO> list = pimarchiveschangeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchivesChange-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"档案归档地变更记录" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchiveschanges/searchdefault")
	public ResponseEntity<Page<PimArchivesChangeDTO>> searchDefault(@RequestBody PimArchivesChangeSearchContext context) {
        Page<PimArchivesChange> domains = pimarchiveschangeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchiveschangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pimarchiveschangeService.get(#pimarchiveschange_id),'ehr-PimArchivesChange-Update')")
    @ApiOperation(value = "根据档案信息更新档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据档案信息更新档案归档地变更记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/{pimarchiveschange_id}")
    @Transactional
    public ResponseEntity<PimArchivesChangeDTO> updateByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchiveschange_id") String pimarchiveschange_id, @RequestBody PimArchivesChangeDTO pimarchiveschangedto) {
        PimArchivesChange domain = pimarchiveschangeMapping.toDomain(pimarchiveschangedto);
        domain.setPimarchivesid(pimarchives_id);
        domain.setPimarchiveschangeid(pimarchiveschange_id);
		pimarchiveschangeService.update(domain);
        PimArchivesChangeDTO dto = pimarchiveschangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeService.getPimarchiveschangeByEntities(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedtos)),'ehr-PimArchivesChange-Update')")
    @ApiOperation(value = "根据档案信息批量更新档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据档案信息批量更新档案归档地变更记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/batch")
    public ResponseEntity<Boolean> updateBatchByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PimArchivesChangeDTO> pimarchiveschangedtos) {
        List<PimArchivesChange> domainlist=pimarchiveschangeMapping.toDomain(pimarchiveschangedtos);
        for(PimArchivesChange domain:domainlist){
            domain.setPimarchivesid(pimarchives_id);
        }
        pimarchiveschangeService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(returnObject.body),'ehr-PimArchivesChange-Get')")
    @ApiOperation(value = "根据档案信息获取档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据档案信息获取档案归档地变更记录")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/{pimarchiveschange_id}")
    public ResponseEntity<PimArchivesChangeDTO> getByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchiveschange_id") String pimarchiveschange_id) {
        PimArchivesChange domain = pimarchiveschangeService.get(pimarchiveschange_id);
        PimArchivesChangeDTO dto = pimarchiveschangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedto),'ehr-PimArchivesChange-Create')")
    @ApiOperation(value = "根据档案信息建立档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据档案信息建立档案归档地变更记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges")
    @Transactional
    public ResponseEntity<PimArchivesChangeDTO> createByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PimArchivesChangeDTO pimarchiveschangedto) {
        PimArchivesChange domain = pimarchiveschangeMapping.toDomain(pimarchiveschangedto);
        domain.setPimarchivesid(pimarchives_id);
		pimarchiveschangeService.create(domain);
        PimArchivesChangeDTO dto = pimarchiveschangeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedtos),'ehr-PimArchivesChange-Create')")
    @ApiOperation(value = "根据档案信息批量建立档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据档案信息批量建立档案归档地变更记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/batch")
    public ResponseEntity<Boolean> createBatchByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PimArchivesChangeDTO> pimarchiveschangedtos) {
        List<PimArchivesChange> domainlist=pimarchiveschangeMapping.toDomain(pimarchiveschangedtos);
        for(PimArchivesChange domain:domainlist){
            domain.setPimarchivesid(pimarchives_id);
        }
        pimarchiveschangeService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据档案信息获取档案归档地变更记录草稿", tags = {"档案归档地变更记录" },  notes = "根据档案信息获取档案归档地变更记录草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/getdraft")
    public ResponseEntity<PimArchivesChangeDTO> getDraftByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id) {
        PimArchivesChange domain = new PimArchivesChange();
        domain.setPimarchivesid(pimarchives_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeMapping.toDto(pimarchiveschangeService.getDraft(domain)));
    }

    @ApiOperation(value = "根据档案信息检查档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据档案信息检查档案归档地变更记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PimArchivesChangeDTO pimarchiveschangedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeService.checkKey(pimarchiveschangeMapping.toDomain(pimarchiveschangedto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchivesChange-UpdatePersonFile-all')")
    @ApiOperation(value = "根据档案信息档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据档案信息档案归档地变更记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/{pimarchiveschange_id}/updatepersonfile")
    @Transactional
    public ResponseEntity<PimArchivesChangeDTO> updatePersonFileByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchiveschange_id") String pimarchiveschange_id, @RequestBody PimArchivesChangeDTO pimarchiveschangedto) {
        PimArchivesChange domain = pimarchiveschangeMapping.toDomain(pimarchiveschangedto);
        domain.setPimarchivesid(pimarchives_id);
        domain = pimarchiveschangeService.updatePersonFile(domain) ;
        pimarchiveschangedto = pimarchiveschangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangedto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedto),'ehr-PimArchivesChange-Save')")
    @ApiOperation(value = "根据档案信息保存档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据档案信息保存档案归档地变更记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/save")
    public ResponseEntity<Boolean> saveByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PimArchivesChangeDTO pimarchiveschangedto) {
        PimArchivesChange domain = pimarchiveschangeMapping.toDomain(pimarchiveschangedto);
        domain.setPimarchivesid(pimarchives_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedtos),'ehr-PimArchivesChange-Save')")
    @ApiOperation(value = "根据档案信息批量保存档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据档案信息批量保存档案归档地变更记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PimArchivesChangeDTO> pimarchiveschangedtos) {
        List<PimArchivesChange> domainlist=pimarchiveschangeMapping.toDomain(pimarchiveschangedtos);
        for(PimArchivesChange domain:domainlist){
             domain.setPimarchivesid(pimarchives_id);
        }
        pimarchiveschangeService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeService.get(#pimarchiveschange_id),'ehr-PimArchivesChange-Remove')")
    @ApiOperation(value = "根据档案信息删除档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据档案信息删除档案归档地变更记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/{pimarchiveschange_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchiveschange_id") String pimarchiveschange_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeService.remove(pimarchiveschange_id));
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeService.getPimarchiveschangeByIds(#ids),'ehr-PimArchivesChange-Remove')")
    @ApiOperation(value = "根据档案信息批量删除档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据档案信息批量删除档案归档地变更记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchives/{pimarchives_id}/pimarchiveschanges/batch")
    public ResponseEntity<Boolean> removeBatchByPimArchives(@RequestBody List<String> ids) {
        pimarchiveschangeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchivesChange-DADCJL-all')")
	@ApiOperation(value = "根据档案信息获取档案调出记录", tags = {"档案归档地变更记录" } ,notes = "根据档案信息获取档案调出记录")
    @RequestMapping(method= RequestMethod.GET , value="/pimarchives/{pimarchives_id}/pimarchiveschanges/fetchdadcjl")
	public ResponseEntity<List<PimArchivesChangeDTO>> fetchPimArchivesChangeDADCJLByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id,PimArchivesChangeSearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PimArchivesChange> domains = pimarchiveschangeService.searchDADCJL(context) ;
        List<PimArchivesChangeDTO> list = pimarchiveschangeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchivesChange-DADCJL-all')")
	@ApiOperation(value = "根据档案信息查询档案调出记录", tags = {"档案归档地变更记录" } ,notes = "根据档案信息查询档案调出记录")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchives/{pimarchives_id}/pimarchiveschanges/searchdadcjl")
	public ResponseEntity<Page<PimArchivesChangeDTO>> searchPimArchivesChangeDADCJLByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PimArchivesChangeSearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PimArchivesChange> domains = pimarchiveschangeService.searchDADCJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchiveschangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchivesChange-Default-all')")
	@ApiOperation(value = "根据档案信息获取DEFAULT", tags = {"档案归档地变更记录" } ,notes = "根据档案信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimarchives/{pimarchives_id}/pimarchiveschanges/fetchdefault")
	public ResponseEntity<List<PimArchivesChangeDTO>> fetchPimArchivesChangeDefaultByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id,PimArchivesChangeSearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PimArchivesChange> domains = pimarchiveschangeService.searchDefault(context) ;
        List<PimArchivesChangeDTO> list = pimarchiveschangeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchivesChange-Default-all')")
	@ApiOperation(value = "根据档案信息查询DEFAULT", tags = {"档案归档地变更记录" } ,notes = "根据档案信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchives/{pimarchives_id}/pimarchiveschanges/searchdefault")
	public ResponseEntity<Page<PimArchivesChangeDTO>> searchPimArchivesChangeDefaultByPimArchives(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PimArchivesChangeSearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PimArchivesChange> domains = pimarchiveschangeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchiveschangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pimarchiveschangeService.get(#pimarchiveschange_id),'ehr-PimArchivesChange-Update')")
    @ApiOperation(value = "根据人员信息档案信息更新档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据人员信息档案信息更新档案归档地变更记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/{pimarchiveschange_id}")
    @Transactional
    public ResponseEntity<PimArchivesChangeDTO> updateByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchiveschange_id") String pimarchiveschange_id, @RequestBody PimArchivesChangeDTO pimarchiveschangedto) {
        PimArchivesChange domain = pimarchiveschangeMapping.toDomain(pimarchiveschangedto);
        domain.setPimarchivesid(pimarchives_id);
        domain.setPimarchiveschangeid(pimarchiveschange_id);
		pimarchiveschangeService.update(domain);
        PimArchivesChangeDTO dto = pimarchiveschangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeService.getPimarchiveschangeByEntities(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedtos)),'ehr-PimArchivesChange-Update')")
    @ApiOperation(value = "根据人员信息档案信息批量更新档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据人员信息档案信息批量更新档案归档地变更记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/batch")
    public ResponseEntity<Boolean> updateBatchByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PimArchivesChangeDTO> pimarchiveschangedtos) {
        List<PimArchivesChange> domainlist=pimarchiveschangeMapping.toDomain(pimarchiveschangedtos);
        for(PimArchivesChange domain:domainlist){
            domain.setPimarchivesid(pimarchives_id);
        }
        pimarchiveschangeService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(returnObject.body),'ehr-PimArchivesChange-Get')")
    @ApiOperation(value = "根据人员信息档案信息获取档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据人员信息档案信息获取档案归档地变更记录")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/{pimarchiveschange_id}")
    public ResponseEntity<PimArchivesChangeDTO> getByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchiveschange_id") String pimarchiveschange_id) {
        PimArchivesChange domain = pimarchiveschangeService.get(pimarchiveschange_id);
        PimArchivesChangeDTO dto = pimarchiveschangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedto),'ehr-PimArchivesChange-Create')")
    @ApiOperation(value = "根据人员信息档案信息建立档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据人员信息档案信息建立档案归档地变更记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges")
    @Transactional
    public ResponseEntity<PimArchivesChangeDTO> createByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PimArchivesChangeDTO pimarchiveschangedto) {
        PimArchivesChange domain = pimarchiveschangeMapping.toDomain(pimarchiveschangedto);
        domain.setPimarchivesid(pimarchives_id);
		pimarchiveschangeService.create(domain);
        PimArchivesChangeDTO dto = pimarchiveschangeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedtos),'ehr-PimArchivesChange-Create')")
    @ApiOperation(value = "根据人员信息档案信息批量建立档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据人员信息档案信息批量建立档案归档地变更记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/batch")
    public ResponseEntity<Boolean> createBatchByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PimArchivesChangeDTO> pimarchiveschangedtos) {
        List<PimArchivesChange> domainlist=pimarchiveschangeMapping.toDomain(pimarchiveschangedtos);
        for(PimArchivesChange domain:domainlist){
            domain.setPimarchivesid(pimarchives_id);
        }
        pimarchiveschangeService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息档案信息获取档案归档地变更记录草稿", tags = {"档案归档地变更记录" },  notes = "根据人员信息档案信息获取档案归档地变更记录草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/getdraft")
    public ResponseEntity<PimArchivesChangeDTO> getDraftByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id) {
        PimArchivesChange domain = new PimArchivesChange();
        domain.setPimarchivesid(pimarchives_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeMapping.toDto(pimarchiveschangeService.getDraft(domain)));
    }

    @ApiOperation(value = "根据人员信息档案信息检查档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据人员信息档案信息检查档案归档地变更记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PimArchivesChangeDTO pimarchiveschangedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeService.checkKey(pimarchiveschangeMapping.toDomain(pimarchiveschangedto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchivesChange-UpdatePersonFile-all')")
    @ApiOperation(value = "根据人员信息档案信息档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据人员信息档案信息档案归档地变更记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/{pimarchiveschange_id}/updatepersonfile")
    @Transactional
    public ResponseEntity<PimArchivesChangeDTO> updatePersonFileByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchiveschange_id") String pimarchiveschange_id, @RequestBody PimArchivesChangeDTO pimarchiveschangedto) {
        PimArchivesChange domain = pimarchiveschangeMapping.toDomain(pimarchiveschangedto);
        domain.setPimarchivesid(pimarchives_id);
        domain = pimarchiveschangeService.updatePersonFile(domain) ;
        pimarchiveschangedto = pimarchiveschangeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangedto);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedto),'ehr-PimArchivesChange-Save')")
    @ApiOperation(value = "根据人员信息档案信息保存档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据人员信息档案信息保存档案归档地变更记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/save")
    public ResponseEntity<Boolean> saveByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PimArchivesChangeDTO pimarchiveschangedto) {
        PimArchivesChange domain = pimarchiveschangeMapping.toDomain(pimarchiveschangedto);
        domain.setPimarchivesid(pimarchives_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeMapping.toDomain(#pimarchiveschangedtos),'ehr-PimArchivesChange-Save')")
    @ApiOperation(value = "根据人员信息档案信息批量保存档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据人员信息档案信息批量保存档案归档地变更记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PimArchivesChangeDTO> pimarchiveschangedtos) {
        List<PimArchivesChange> domainlist=pimarchiveschangeMapping.toDomain(pimarchiveschangedtos);
        for(PimArchivesChange domain:domainlist){
             domain.setPimarchivesid(pimarchives_id);
        }
        pimarchiveschangeService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeService.get(#pimarchiveschange_id),'ehr-PimArchivesChange-Remove')")
    @ApiOperation(value = "根据人员信息档案信息删除档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据人员信息档案信息删除档案归档地变更记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/{pimarchiveschange_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchiveschange_id") String pimarchiveschange_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimarchiveschangeService.remove(pimarchiveschange_id));
    }

    @PreAuthorize("hasPermission(this.pimarchiveschangeService.getPimarchiveschangeByIds(#ids),'ehr-PimArchivesChange-Remove')")
    @ApiOperation(value = "根据人员信息档案信息批量删除档案归档地变更记录", tags = {"档案归档地变更记录" },  notes = "根据人员信息档案信息批量删除档案归档地变更记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/batch")
    public ResponseEntity<Boolean> removeBatchByPimPersonPimArchives(@RequestBody List<String> ids) {
        pimarchiveschangeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchivesChange-DADCJL-all')")
	@ApiOperation(value = "根据人员信息档案信息获取档案调出记录", tags = {"档案归档地变更记录" } ,notes = "根据人员信息档案信息获取档案调出记录")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/fetchdadcjl")
	public ResponseEntity<List<PimArchivesChangeDTO>> fetchPimArchivesChangeDADCJLByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id,PimArchivesChangeSearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PimArchivesChange> domains = pimarchiveschangeService.searchDADCJL(context) ;
        List<PimArchivesChangeDTO> list = pimarchiveschangeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchivesChange-DADCJL-all')")
	@ApiOperation(value = "根据人员信息档案信息查询档案调出记录", tags = {"档案归档地变更记录" } ,notes = "根据人员信息档案信息查询档案调出记录")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/searchdadcjl")
	public ResponseEntity<Page<PimArchivesChangeDTO>> searchPimArchivesChangeDADCJLByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PimArchivesChangeSearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PimArchivesChange> domains = pimarchiveschangeService.searchDADCJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchiveschangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchivesChange-Default-all')")
	@ApiOperation(value = "根据人员信息档案信息获取DEFAULT", tags = {"档案归档地变更记录" } ,notes = "根据人员信息档案信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/fetchdefault")
	public ResponseEntity<List<PimArchivesChangeDTO>> fetchPimArchivesChangeDefaultByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id,PimArchivesChangeSearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PimArchivesChange> domains = pimarchiveschangeService.searchDefault(context) ;
        List<PimArchivesChangeDTO> list = pimarchiveschangeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArchivesChange-Default-all')")
	@ApiOperation(value = "根据人员信息档案信息查询DEFAULT", tags = {"档案归档地变更记录" } ,notes = "根据人员信息档案信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchiveschanges/searchdefault")
	public ResponseEntity<Page<PimArchivesChangeDTO>> searchPimArchivesChangeDefaultByPimPersonPimArchives(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PimArchivesChangeSearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PimArchivesChange> domains = pimarchiveschangeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchiveschangeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

