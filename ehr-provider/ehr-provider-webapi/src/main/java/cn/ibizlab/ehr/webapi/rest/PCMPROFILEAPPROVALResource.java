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
import cn.ibizlab.ehr.core.pcm.domain.PCMPROFILEAPPROVAL;
import cn.ibizlab.ehr.core.pcm.service.IPCMPROFILEAPPROVALService;
import cn.ibizlab.ehr.core.pcm.filter.PCMPROFILEAPPROVALSearchContext;

@Slf4j
@Api(tags = {"应聘者审批表" })
@RestController("WebApi-pcmprofileapproval")
@RequestMapping("")
public class PCMPROFILEAPPROVALResource {

    @Autowired
    public IPCMPROFILEAPPROVALService pcmprofileapprovalService;

    @Autowired
    @Lazy
    public PCMPROFILEAPPROVALMapping pcmprofileapprovalMapping;

    @PreAuthorize("hasPermission(this.pcmprofileapprovalService.get(#pcmprofileapproval_id),'ehr-PCMPROFILEAPPROVAL-Update')")
    @ApiOperation(value = "更新应聘者审批表", tags = {"应聘者审批表" },  notes = "更新应聘者审批表")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofileapprovals/{pcmprofileapproval_id}")
    @Transactional
    public ResponseEntity<PCMPROFILEAPPROVALDTO> update(@PathVariable("pcmprofileapproval_id") String pcmprofileapproval_id, @RequestBody PCMPROFILEAPPROVALDTO pcmprofileapprovaldto) {
		PCMPROFILEAPPROVAL domain  = pcmprofileapprovalMapping.toDomain(pcmprofileapprovaldto);
        domain .setPcmprofileapprovalid(pcmprofileapproval_id);
		pcmprofileapprovalService.update(domain );
		PCMPROFILEAPPROVALDTO dto = pcmprofileapprovalMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmprofileapprovalService.getPcmprofileapprovalByEntities(this.pcmprofileapprovalMapping.toDomain(#pcmprofileapprovaldtos)),'ehr-PCMPROFILEAPPROVAL-Update')")
    @ApiOperation(value = "批量更新应聘者审批表", tags = {"应聘者审批表" },  notes = "批量更新应聘者审批表")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofileapprovals/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMPROFILEAPPROVALDTO> pcmprofileapprovaldtos) {
        pcmprofileapprovalService.updateBatch(pcmprofileapprovalMapping.toDomain(pcmprofileapprovaldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取应聘者审批表草稿", tags = {"应聘者审批表" },  notes = "获取应聘者审批表草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofileapprovals/getdraft")
    public ResponseEntity<PCMPROFILEAPPROVALDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofileapprovalMapping.toDto(pcmprofileapprovalService.getDraft(new PCMPROFILEAPPROVAL())));
    }

    @PreAuthorize("hasPermission(this.pcmprofileapprovalMapping.toDomain(#pcmprofileapprovaldto),'ehr-PCMPROFILEAPPROVAL-Create')")
    @ApiOperation(value = "新建应聘者审批表", tags = {"应聘者审批表" },  notes = "新建应聘者审批表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileapprovals")
    @Transactional
    public ResponseEntity<PCMPROFILEAPPROVALDTO> create(@RequestBody PCMPROFILEAPPROVALDTO pcmprofileapprovaldto) {
        PCMPROFILEAPPROVAL domain = pcmprofileapprovalMapping.toDomain(pcmprofileapprovaldto);
		pcmprofileapprovalService.create(domain);
        PCMPROFILEAPPROVALDTO dto = pcmprofileapprovalMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmprofileapprovalMapping.toDomain(#pcmprofileapprovaldtos),'ehr-PCMPROFILEAPPROVAL-Create')")
    @ApiOperation(value = "批量新建应聘者审批表", tags = {"应聘者审批表" },  notes = "批量新建应聘者审批表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileapprovals/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMPROFILEAPPROVALDTO> pcmprofileapprovaldtos) {
        pcmprofileapprovalService.createBatch(pcmprofileapprovalMapping.toDomain(pcmprofileapprovaldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmprofileapprovalMapping.toDomain(#pcmprofileapprovaldto),'ehr-PCMPROFILEAPPROVAL-Save')")
    @ApiOperation(value = "保存应聘者审批表", tags = {"应聘者审批表" },  notes = "保存应聘者审批表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileapprovals/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMPROFILEAPPROVALDTO pcmprofileapprovaldto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofileapprovalService.save(pcmprofileapprovalMapping.toDomain(pcmprofileapprovaldto)));
    }

    @PreAuthorize("hasPermission(this.pcmprofileapprovalMapping.toDomain(#pcmprofileapprovaldtos),'ehr-PCMPROFILEAPPROVAL-Save')")
    @ApiOperation(value = "批量保存应聘者审批表", tags = {"应聘者审批表" },  notes = "批量保存应聘者审批表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileapprovals/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMPROFILEAPPROVALDTO> pcmprofileapprovaldtos) {
        pcmprofileapprovalService.saveBatch(pcmprofileapprovalMapping.toDomain(pcmprofileapprovaldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmprofileapprovalService.get(#pcmprofileapproval_id),'ehr-PCMPROFILEAPPROVAL-Remove')")
    @ApiOperation(value = "删除应聘者审批表", tags = {"应聘者审批表" },  notes = "删除应聘者审批表")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofileapprovals/{pcmprofileapproval_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmprofileapproval_id") String pcmprofileapproval_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmprofileapprovalService.remove(pcmprofileapproval_id));
    }

    @PreAuthorize("hasPermission(this.pcmprofileapprovalService.getPcmprofileapprovalByIds(#ids),'ehr-PCMPROFILEAPPROVAL-Remove')")
    @ApiOperation(value = "批量删除应聘者审批表", tags = {"应聘者审批表" },  notes = "批量删除应聘者审批表")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofileapprovals/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmprofileapprovalService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmprofileapprovalMapping.toDomain(returnObject.body),'ehr-PCMPROFILEAPPROVAL-Get')")
    @ApiOperation(value = "获取应聘者审批表", tags = {"应聘者审批表" },  notes = "获取应聘者审批表")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofileapprovals/{pcmprofileapproval_id}")
    public ResponseEntity<PCMPROFILEAPPROVALDTO> get(@PathVariable("pcmprofileapproval_id") String pcmprofileapproval_id) {
        PCMPROFILEAPPROVAL domain = pcmprofileapprovalService.get(pcmprofileapproval_id);
        PCMPROFILEAPPROVALDTO dto = pcmprofileapprovalMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "检查应聘者审批表", tags = {"应聘者审批表" },  notes = "检查应聘者审批表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileapprovals/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMPROFILEAPPROVALDTO pcmprofileapprovaldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmprofileapprovalService.checkKey(pcmprofileapprovalMapping.toDomain(pcmprofileapprovaldto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILEAPPROVAL-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"应聘者审批表" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofileapprovals/fetchdefault")
	public ResponseEntity<List<PCMPROFILEAPPROVALDTO>> fetchDefault(PCMPROFILEAPPROVALSearchContext context) {
        Page<PCMPROFILEAPPROVAL> domains = pcmprofileapprovalService.searchDefault(context) ;
        List<PCMPROFILEAPPROVALDTO> list = pcmprofileapprovalMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILEAPPROVAL-Default-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"应聘者审批表" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofileapprovals/searchdefault")
	public ResponseEntity<Page<PCMPROFILEAPPROVALDTO>> searchDefault(@RequestBody PCMPROFILEAPPROVALSearchContext context) {
        Page<PCMPROFILEAPPROVAL> domains = pcmprofileapprovalService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileapprovalMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILEAPPROVAL-Disagree-all')")
	@ApiOperation(value = "获取拒绝", tags = {"应聘者审批表" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofileapprovals/fetchdisagree")
	public ResponseEntity<List<PCMPROFILEAPPROVALDTO>> fetchDisagree(PCMPROFILEAPPROVALSearchContext context) {
        Page<PCMPROFILEAPPROVAL> domains = pcmprofileapprovalService.searchDisagree(context) ;
        List<PCMPROFILEAPPROVALDTO> list = pcmprofileapprovalMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILEAPPROVAL-Disagree-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"应聘者审批表" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofileapprovals/searchdisagree")
	public ResponseEntity<Page<PCMPROFILEAPPROVALDTO>> searchDisagree(@RequestBody PCMPROFILEAPPROVALSearchContext context) {
        Page<PCMPROFILEAPPROVAL> domains = pcmprofileapprovalService.searchDisagree(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileapprovalMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pcmprofileapprovalService.get(#pcmprofileapproval_id),'ehr-PCMPROFILEAPPROVAL-Update')")
    @ApiOperation(value = "根据应聘者基本信息更新应聘者审批表", tags = {"应聘者审批表" },  notes = "根据应聘者基本信息更新应聘者审批表")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmprofileapprovals/{pcmprofileapproval_id}")
    @Transactional
    public ResponseEntity<PCMPROFILEAPPROVALDTO> updateByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmprofileapproval_id") String pcmprofileapproval_id, @RequestBody PCMPROFILEAPPROVALDTO pcmprofileapprovaldto) {
        PCMPROFILEAPPROVAL domain = pcmprofileapprovalMapping.toDomain(pcmprofileapprovaldto);
        domain.setPcmprofileid(pcmprofile_id);
        domain.setPcmprofileapprovalid(pcmprofileapproval_id);
		pcmprofileapprovalService.update(domain);
        PCMPROFILEAPPROVALDTO dto = pcmprofileapprovalMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmprofileapprovalService.getPcmprofileapprovalByEntities(this.pcmprofileapprovalMapping.toDomain(#pcmprofileapprovaldtos)),'ehr-PCMPROFILEAPPROVAL-Update')")
    @ApiOperation(value = "根据应聘者基本信息批量更新应聘者审批表", tags = {"应聘者审批表" },  notes = "根据应聘者基本信息批量更新应聘者审批表")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmprofileapprovals/batch")
    public ResponseEntity<Boolean> updateBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PCMPROFILEAPPROVALDTO> pcmprofileapprovaldtos) {
        List<PCMPROFILEAPPROVAL> domainlist=pcmprofileapprovalMapping.toDomain(pcmprofileapprovaldtos);
        for(PCMPROFILEAPPROVAL domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmprofileapprovalService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据应聘者基本信息获取应聘者审批表草稿", tags = {"应聘者审批表" },  notes = "根据应聘者基本信息获取应聘者审批表草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmprofileapprovals/getdraft")
    public ResponseEntity<PCMPROFILEAPPROVALDTO> getDraftByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id) {
        PCMPROFILEAPPROVAL domain = new PCMPROFILEAPPROVAL();
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofileapprovalMapping.toDto(pcmprofileapprovalService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pcmprofileapprovalMapping.toDomain(#pcmprofileapprovaldto),'ehr-PCMPROFILEAPPROVAL-Create')")
    @ApiOperation(value = "根据应聘者基本信息建立应聘者审批表", tags = {"应聘者审批表" },  notes = "根据应聘者基本信息建立应聘者审批表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmprofileapprovals")
    @Transactional
    public ResponseEntity<PCMPROFILEAPPROVALDTO> createByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEAPPROVALDTO pcmprofileapprovaldto) {
        PCMPROFILEAPPROVAL domain = pcmprofileapprovalMapping.toDomain(pcmprofileapprovaldto);
        domain.setPcmprofileid(pcmprofile_id);
		pcmprofileapprovalService.create(domain);
        PCMPROFILEAPPROVALDTO dto = pcmprofileapprovalMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmprofileapprovalMapping.toDomain(#pcmprofileapprovaldtos),'ehr-PCMPROFILEAPPROVAL-Create')")
    @ApiOperation(value = "根据应聘者基本信息批量建立应聘者审批表", tags = {"应聘者审批表" },  notes = "根据应聘者基本信息批量建立应聘者审批表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmprofileapprovals/batch")
    public ResponseEntity<Boolean> createBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PCMPROFILEAPPROVALDTO> pcmprofileapprovaldtos) {
        List<PCMPROFILEAPPROVAL> domainlist=pcmprofileapprovalMapping.toDomain(pcmprofileapprovaldtos);
        for(PCMPROFILEAPPROVAL domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmprofileapprovalService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmprofileapprovalMapping.toDomain(#pcmprofileapprovaldto),'ehr-PCMPROFILEAPPROVAL-Save')")
    @ApiOperation(value = "根据应聘者基本信息保存应聘者审批表", tags = {"应聘者审批表" },  notes = "根据应聘者基本信息保存应聘者审批表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmprofileapprovals/save")
    public ResponseEntity<Boolean> saveByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEAPPROVALDTO pcmprofileapprovaldto) {
        PCMPROFILEAPPROVAL domain = pcmprofileapprovalMapping.toDomain(pcmprofileapprovaldto);
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofileapprovalService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmprofileapprovalMapping.toDomain(#pcmprofileapprovaldtos),'ehr-PCMPROFILEAPPROVAL-Save')")
    @ApiOperation(value = "根据应聘者基本信息批量保存应聘者审批表", tags = {"应聘者审批表" },  notes = "根据应聘者基本信息批量保存应聘者审批表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmprofileapprovals/savebatch")
    public ResponseEntity<Boolean> saveBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PCMPROFILEAPPROVALDTO> pcmprofileapprovaldtos) {
        List<PCMPROFILEAPPROVAL> domainlist=pcmprofileapprovalMapping.toDomain(pcmprofileapprovaldtos);
        for(PCMPROFILEAPPROVAL domain:domainlist){
             domain.setPcmprofileid(pcmprofile_id);
        }
        pcmprofileapprovalService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmprofileapprovalService.get(#pcmprofileapproval_id),'ehr-PCMPROFILEAPPROVAL-Remove')")
    @ApiOperation(value = "根据应聘者基本信息删除应聘者审批表", tags = {"应聘者审批表" },  notes = "根据应聘者基本信息删除应聘者审批表")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmprofileapprovals/{pcmprofileapproval_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmprofileapproval_id") String pcmprofileapproval_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmprofileapprovalService.remove(pcmprofileapproval_id));
    }

    @PreAuthorize("hasPermission(this.pcmprofileapprovalService.getPcmprofileapprovalByIds(#ids),'ehr-PCMPROFILEAPPROVAL-Remove')")
    @ApiOperation(value = "根据应聘者基本信息批量删除应聘者审批表", tags = {"应聘者审批表" },  notes = "根据应聘者基本信息批量删除应聘者审批表")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmprofileapprovals/batch")
    public ResponseEntity<Boolean> removeBatchByPcmProfile(@RequestBody List<String> ids) {
        pcmprofileapprovalService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmprofileapprovalMapping.toDomain(returnObject.body),'ehr-PCMPROFILEAPPROVAL-Get')")
    @ApiOperation(value = "根据应聘者基本信息获取应聘者审批表", tags = {"应聘者审批表" },  notes = "根据应聘者基本信息获取应聘者审批表")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmprofileapprovals/{pcmprofileapproval_id}")
    public ResponseEntity<PCMPROFILEAPPROVALDTO> getByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmprofileapproval_id") String pcmprofileapproval_id) {
        PCMPROFILEAPPROVAL domain = pcmprofileapprovalService.get(pcmprofileapproval_id);
        PCMPROFILEAPPROVALDTO dto = pcmprofileapprovalMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据应聘者基本信息检查应聘者审批表", tags = {"应聘者审批表" },  notes = "根据应聘者基本信息检查应聘者审批表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmprofileapprovals/checkkey")
    public ResponseEntity<Boolean> checkKeyByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEAPPROVALDTO pcmprofileapprovaldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmprofileapprovalService.checkKey(pcmprofileapprovalMapping.toDomain(pcmprofileapprovaldto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILEAPPROVAL-Default-all')")
	@ApiOperation(value = "根据应聘者基本信息获取DEFAULT", tags = {"应聘者审批表" } ,notes = "根据应聘者基本信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/{pcmprofile_id}/pcmprofileapprovals/fetchdefault")
	public ResponseEntity<List<PCMPROFILEAPPROVALDTO>> fetchPCMPROFILEAPPROVALDefaultByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id,PCMPROFILEAPPROVALSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PCMPROFILEAPPROVAL> domains = pcmprofileapprovalService.searchDefault(context) ;
        List<PCMPROFILEAPPROVALDTO> list = pcmprofileapprovalMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILEAPPROVAL-Default-all')")
	@ApiOperation(value = "根据应聘者基本信息查询DEFAULT", tags = {"应聘者审批表" } ,notes = "根据应聘者基本信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/{pcmprofile_id}/pcmprofileapprovals/searchdefault")
	public ResponseEntity<Page<PCMPROFILEAPPROVALDTO>> searchPCMPROFILEAPPROVALDefaultByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEAPPROVALSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PCMPROFILEAPPROVAL> domains = pcmprofileapprovalService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileapprovalMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILEAPPROVAL-Disagree-all')")
	@ApiOperation(value = "根据应聘者基本信息获取拒绝", tags = {"应聘者审批表" } ,notes = "根据应聘者基本信息获取拒绝")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/{pcmprofile_id}/pcmprofileapprovals/fetchdisagree")
	public ResponseEntity<List<PCMPROFILEAPPROVALDTO>> fetchPCMPROFILEAPPROVALDisagreeByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id,PCMPROFILEAPPROVALSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PCMPROFILEAPPROVAL> domains = pcmprofileapprovalService.searchDisagree(context) ;
        List<PCMPROFILEAPPROVALDTO> list = pcmprofileapprovalMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILEAPPROVAL-Disagree-all')")
	@ApiOperation(value = "根据应聘者基本信息查询拒绝", tags = {"应聘者审批表" } ,notes = "根据应聘者基本信息查询拒绝")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/{pcmprofile_id}/pcmprofileapprovals/searchdisagree")
	public ResponseEntity<Page<PCMPROFILEAPPROVALDTO>> searchPCMPROFILEAPPROVALDisagreeByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEAPPROVALSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PCMPROFILEAPPROVAL> domains = pcmprofileapprovalService.searchDisagree(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileapprovalMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

