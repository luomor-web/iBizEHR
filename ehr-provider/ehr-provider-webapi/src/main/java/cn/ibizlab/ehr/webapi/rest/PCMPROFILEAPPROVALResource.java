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
@Api(tags = {"PCMPROFILEAPPROVAL" })
@RestController("WebApi-pcmprofileapproval")
@RequestMapping("")
public class PCMPROFILEAPPROVALResource {

    @Autowired
    private IPCMPROFILEAPPROVALService pcmprofileapprovalService;

    @Autowired
    @Lazy
    private PCMPROFILEAPPROVALMapping pcmprofileapprovalMapping;




    @PreAuthorize("hasPermission(#pcmprofileapproval_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PCMPROFILEAPPROVAL" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofileapprovals/{pcmprofileapproval_id}")
    @Transactional
    public ResponseEntity<PCMPROFILEAPPROVALDTO> update(@PathVariable("pcmprofileapproval_id") String pcmprofileapproval_id, @RequestBody PCMPROFILEAPPROVALDTO pcmprofileapprovaldto) {
		PCMPROFILEAPPROVAL domain = pcmprofileapprovalMapping.toDomain(pcmprofileapprovaldto);
        domain.setPcmprofileapprovalid(pcmprofileapproval_id);
		pcmprofileapprovalService.update(domain);
		PCMPROFILEAPPROVALDTO dto = pcmprofileapprovalMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pcmprofileapproval_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMPROFILEAPPROVAL" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofileapprovals/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMPROFILEAPPROVALDTO> pcmprofileapprovaldtos) {
        pcmprofileapprovalService.updateBatch(pcmprofileapprovalMapping.toDomain(pcmprofileapprovaldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PCMPROFILEAPPROVAL" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofileapprovals/getdraft")
    public ResponseEntity<PCMPROFILEAPPROVALDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofileapprovalMapping.toDto(pcmprofileapprovalService.getDraft(new PCMPROFILEAPPROVAL())));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PCMPROFILEAPPROVAL" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileapprovals")
    @Transactional
    public ResponseEntity<PCMPROFILEAPPROVALDTO> create(@RequestBody PCMPROFILEAPPROVALDTO pcmprofileapprovaldto) {
        PCMPROFILEAPPROVAL domain = pcmprofileapprovalMapping.toDomain(pcmprofileapprovaldto);
		pcmprofileapprovalService.create(domain);
        PCMPROFILEAPPROVALDTO dto = pcmprofileapprovalMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PCMPROFILEAPPROVAL" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileapprovals/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMPROFILEAPPROVALDTO> pcmprofileapprovaldtos) {
        pcmprofileapprovalService.createBatch(pcmprofileapprovalMapping.toDomain(pcmprofileapprovaldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"PCMPROFILEAPPROVAL" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileapprovals/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMPROFILEAPPROVALDTO pcmprofileapprovaldto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofileapprovalService.save(pcmprofileapprovalMapping.toDomain(pcmprofileapprovaldto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PCMPROFILEAPPROVAL" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileapprovals/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMPROFILEAPPROVALDTO> pcmprofileapprovaldtos) {
        pcmprofileapprovalService.saveBatch(pcmprofileapprovalMapping.toDomain(pcmprofileapprovaldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#pcmprofileapproval_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PCMPROFILEAPPROVAL" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofileapprovals/{pcmprofileapproval_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmprofileapproval_id") String pcmprofileapproval_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmprofileapprovalService.remove(pcmprofileapproval_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PCMPROFILEAPPROVAL" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofileapprovals/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmprofileapprovalService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pcmprofileapproval_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PCMPROFILEAPPROVAL" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofileapprovals/{pcmprofileapproval_id}")
    public ResponseEntity<PCMPROFILEAPPROVALDTO> get(@PathVariable("pcmprofileapproval_id") String pcmprofileapproval_id) {
        PCMPROFILEAPPROVAL domain = pcmprofileapprovalService.get(pcmprofileapproval_id);
        PCMPROFILEAPPROVALDTO dto = pcmprofileapprovalMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "CheckKey", tags = {"PCMPROFILEAPPROVAL" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileapprovals/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMPROFILEAPPROVALDTO pcmprofileapprovaldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmprofileapprovalService.checkKey(pcmprofileapprovalMapping.toDomain(pcmprofileapprovaldto)));
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMPROFILEAPPROVAL" } ,notes = "fetchDEFAULT")
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

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMPROFILEAPPROVAL" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofileapprovals/searchdefault")
	public ResponseEntity<Page<PCMPROFILEAPPROVALDTO>> searchDefault(PCMPROFILEAPPROVALSearchContext context) {
        Page<PCMPROFILEAPPROVAL> domains = pcmprofileapprovalService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileapprovalMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'Disagree',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch拒绝", tags = {"PCMPROFILEAPPROVAL" } ,notes = "fetch拒绝")
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

    @PreAuthorize("hasPermission('Get',{#context,'Disagree',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search拒绝", tags = {"PCMPROFILEAPPROVAL" } ,notes = "search拒绝")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofileapprovals/searchdisagree")
	public ResponseEntity<Page<PCMPROFILEAPPROVALDTO>> searchDisagree(PCMPROFILEAPPROVALSearchContext context) {
        Page<PCMPROFILEAPPROVAL> domains = pcmprofileapprovalService.searchDisagree(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileapprovalMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}



    @ApiOperation(value = "UpdateByPCMPROFILE", tags = {"PCMPROFILEAPPROVAL" },  notes = "UpdateByPCMPROFILE")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmprofileapprovals/{pcmprofileapproval_id}")
    @Transactional
    public ResponseEntity<PCMPROFILEAPPROVALDTO> updateByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmprofileapproval_id") String pcmprofileapproval_id, @RequestBody PCMPROFILEAPPROVALDTO pcmprofileapprovaldto) {
        PCMPROFILEAPPROVAL domain = pcmprofileapprovalMapping.toDomain(pcmprofileapprovaldto);
        domain.setPcmprofileid(pcmprofile_id);
        domain.setPcmprofileapprovalid(pcmprofileapproval_id);
		pcmprofileapprovalService.update(domain);
        PCMPROFILEAPPROVALDTO dto = pcmprofileapprovalMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatchByPCMPROFILE", tags = {"PCMPROFILEAPPROVAL" },  notes = "UpdateBatchByPCMPROFILE")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmprofileapprovals/batch")
    public ResponseEntity<Boolean> updateBatchByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PCMPROFILEAPPROVALDTO> pcmprofileapprovaldtos) {
        List<PCMPROFILEAPPROVAL> domainlist=pcmprofileapprovalMapping.toDomain(pcmprofileapprovaldtos);
        for(PCMPROFILEAPPROVAL domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmprofileapprovalService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPCMPROFILE", tags = {"PCMPROFILEAPPROVAL" },  notes = "GetDraftByPCMPROFILE")
    @RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmprofileapprovals/getdraft")
    public ResponseEntity<PCMPROFILEAPPROVALDTO> getDraftByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id) {
        PCMPROFILEAPPROVAL domain = new PCMPROFILEAPPROVAL();
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofileapprovalMapping.toDto(pcmprofileapprovalService.getDraft(domain)));
    }

    @ApiOperation(value = "CreateByPCMPROFILE", tags = {"PCMPROFILEAPPROVAL" },  notes = "CreateByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmprofileapprovals")
    @Transactional
    public ResponseEntity<PCMPROFILEAPPROVALDTO> createByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEAPPROVALDTO pcmprofileapprovaldto) {
        PCMPROFILEAPPROVAL domain = pcmprofileapprovalMapping.toDomain(pcmprofileapprovaldto);
        domain.setPcmprofileid(pcmprofile_id);
		pcmprofileapprovalService.create(domain);
        PCMPROFILEAPPROVALDTO dto = pcmprofileapprovalMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatchByPCMPROFILE", tags = {"PCMPROFILEAPPROVAL" },  notes = "createBatchByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmprofileapprovals/batch")
    public ResponseEntity<Boolean> createBatchByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PCMPROFILEAPPROVALDTO> pcmprofileapprovaldtos) {
        List<PCMPROFILEAPPROVAL> domainlist=pcmprofileapprovalMapping.toDomain(pcmprofileapprovaldtos);
        for(PCMPROFILEAPPROVAL domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmprofileapprovalService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "SaveByPCMPROFILE", tags = {"PCMPROFILEAPPROVAL" },  notes = "SaveByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmprofileapprovals/save")
    public ResponseEntity<Boolean> saveByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEAPPROVALDTO pcmprofileapprovaldto) {
        PCMPROFILEAPPROVAL domain = pcmprofileapprovalMapping.toDomain(pcmprofileapprovaldto);
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofileapprovalService.save(domain));
    }

    @ApiOperation(value = "SaveBatchByPCMPROFILE", tags = {"PCMPROFILEAPPROVAL" },  notes = "SaveBatchByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmprofileapprovals/savebatch")
    public ResponseEntity<Boolean> saveBatchByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PCMPROFILEAPPROVALDTO> pcmprofileapprovaldtos) {
        List<PCMPROFILEAPPROVAL> domainlist=pcmprofileapprovalMapping.toDomain(pcmprofileapprovaldtos);
        for(PCMPROFILEAPPROVAL domain:domainlist){
             domain.setPcmprofileid(pcmprofile_id);
        }
        pcmprofileapprovalService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "RemoveByPCMPROFILE", tags = {"PCMPROFILEAPPROVAL" },  notes = "RemoveByPCMPROFILE")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmprofileapprovals/{pcmprofileapproval_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmprofileapproval_id") String pcmprofileapproval_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmprofileapprovalService.remove(pcmprofileapproval_id));
    }

    @ApiOperation(value = "RemoveBatchByPCMPROFILE", tags = {"PCMPROFILEAPPROVAL" },  notes = "RemoveBatchByPCMPROFILE")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmprofileapprovals/batch")
    public ResponseEntity<Boolean> removeBatchByPCMPROFILE(@RequestBody List<String> ids) {
        pcmprofileapprovalService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetByPCMPROFILE", tags = {"PCMPROFILEAPPROVAL" },  notes = "GetByPCMPROFILE")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmprofileapprovals/{pcmprofileapproval_id}")
    public ResponseEntity<PCMPROFILEAPPROVALDTO> getByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmprofileapproval_id") String pcmprofileapproval_id) {
        PCMPROFILEAPPROVAL domain = pcmprofileapprovalService.get(pcmprofileapproval_id);
        PCMPROFILEAPPROVALDTO dto = pcmprofileapprovalMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKeyByPCMPROFILE", tags = {"PCMPROFILEAPPROVAL" },  notes = "CheckKeyByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmprofileapprovals/checkkey")
    public ResponseEntity<Boolean> checkKeyByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPROFILEAPPROVALDTO pcmprofileapprovaldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmprofileapprovalService.checkKey(pcmprofileapprovalMapping.toDomain(pcmprofileapprovaldto)));
    }

	@ApiOperation(value = "fetchDEFAULTByPCMPROFILE", tags = {"PCMPROFILEAPPROVAL" } ,notes = "fetchDEFAULTByPCMPROFILE")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/{pcmprofile_id}/pcmprofileapprovals/fetchdefault")
	public ResponseEntity<List<PCMPROFILEAPPROVALDTO>> fetchPCMPROFILEAPPROVALDefaultByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id,PCMPROFILEAPPROVALSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PCMPROFILEAPPROVAL> domains = pcmprofileapprovalService.searchDefault(context) ;
        List<PCMPROFILEAPPROVALDTO> list = pcmprofileapprovalMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULTByPCMPROFILE", tags = {"PCMPROFILEAPPROVAL" } ,notes = "searchDEFAULTByPCMPROFILE")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/{pcmprofile_id}/pcmprofileapprovals/searchdefault")
	public ResponseEntity<Page<PCMPROFILEAPPROVALDTO>> searchPCMPROFILEAPPROVALDefaultByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id,PCMPROFILEAPPROVALSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PCMPROFILEAPPROVAL> domains = pcmprofileapprovalService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileapprovalMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch拒绝ByPCMPROFILE", tags = {"PCMPROFILEAPPROVAL" } ,notes = "fetch拒绝ByPCMPROFILE")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/{pcmprofile_id}/pcmprofileapprovals/fetchdisagree")
	public ResponseEntity<List<PCMPROFILEAPPROVALDTO>> fetchPCMPROFILEAPPROVALDisagreeByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id,PCMPROFILEAPPROVALSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PCMPROFILEAPPROVAL> domains = pcmprofileapprovalService.searchDisagree(context) ;
        List<PCMPROFILEAPPROVALDTO> list = pcmprofileapprovalMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search拒绝ByPCMPROFILE", tags = {"PCMPROFILEAPPROVAL" } ,notes = "search拒绝ByPCMPROFILE")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/{pcmprofile_id}/pcmprofileapprovals/searchdisagree")
	public ResponseEntity<Page<PCMPROFILEAPPROVALDTO>> searchPCMPROFILEAPPROVALDisagreeByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id,PCMPROFILEAPPROVALSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PCMPROFILEAPPROVAL> domains = pcmprofileapprovalService.searchDisagree(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileapprovalMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PCMPROFILEAPPROVAL getEntity(){
        return new PCMPROFILEAPPROVAL();
    }

}