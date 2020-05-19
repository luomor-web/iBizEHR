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
import cn.ibizlab.ehr.core.pcm.domain.PCMWORKRESUME;
import cn.ibizlab.ehr.core.pcm.service.IPCMWORKRESUMEService;
import cn.ibizlab.ehr.core.pcm.filter.PCMWORKRESUMESearchContext;




@Slf4j
@Api(tags = {"PCMWORKRESUME" })
@RestController("WebApi-pcmworkresume")
@RequestMapping("")
public class PCMWORKRESUMEResource {

    @Autowired
    private IPCMWORKRESUMEService pcmworkresumeService;

    @Autowired
    @Lazy
    private PCMWORKRESUMEMapping pcmworkresumeMapping;




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PCMWORKRESUME" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmworkresumes")
    @Transactional
    public ResponseEntity<PCMWORKRESUMEDTO> create(@RequestBody PCMWORKRESUMEDTO pcmworkresumedto) {
        PCMWORKRESUME domain = pcmworkresumeMapping.toDomain(pcmworkresumedto);
		pcmworkresumeService.create(domain);
        PCMWORKRESUMEDTO dto = pcmworkresumeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PCMWORKRESUME" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmworkresumes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMWORKRESUMEDTO> pcmworkresumedtos) {
        pcmworkresumeService.createBatch(pcmworkresumeMapping.toDomain(pcmworkresumedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PCMWORKRESUME" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmworkresumes/getdraft")
    public ResponseEntity<PCMWORKRESUMEDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmworkresumeMapping.toDto(pcmworkresumeService.getDraft(new PCMWORKRESUME())));
    }




    @ApiOperation(value = "Save", tags = {"PCMWORKRESUME" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmworkresumes/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMWORKRESUMEDTO pcmworkresumedto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmworkresumeService.save(pcmworkresumeMapping.toDomain(pcmworkresumedto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PCMWORKRESUME" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmworkresumes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMWORKRESUMEDTO> pcmworkresumedtos) {
        pcmworkresumeService.saveBatch(pcmworkresumeMapping.toDomain(pcmworkresumedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pcmworkresume_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PCMWORKRESUME" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmworkresumes/{pcmworkresume_id}")
    public ResponseEntity<PCMWORKRESUMEDTO> get(@PathVariable("pcmworkresume_id") String pcmworkresume_id) {
        PCMWORKRESUME domain = pcmworkresumeService.get(pcmworkresume_id);
        PCMWORKRESUMEDTO dto = pcmworkresumeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#pcmworkresume_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PCMWORKRESUME" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmworkresumes/{pcmworkresume_id}")
    @Transactional
    public ResponseEntity<PCMWORKRESUMEDTO> update(@PathVariable("pcmworkresume_id") String pcmworkresume_id, @RequestBody PCMWORKRESUMEDTO pcmworkresumedto) {
		PCMWORKRESUME domain = pcmworkresumeMapping.toDomain(pcmworkresumedto);
        domain.setPcmworkresumeid(pcmworkresume_id);
		pcmworkresumeService.update(domain);
		PCMWORKRESUMEDTO dto = pcmworkresumeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pcmworkresume_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMWORKRESUME" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmworkresumes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMWORKRESUMEDTO> pcmworkresumedtos) {
        pcmworkresumeService.updateBatch(pcmworkresumeMapping.toDomain(pcmworkresumedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"PCMWORKRESUME" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmworkresumes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMWORKRESUMEDTO pcmworkresumedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmworkresumeService.checkKey(pcmworkresumeMapping.toDomain(pcmworkresumedto)));
    }




    @PreAuthorize("hasPermission('Remove',{#pcmworkresume_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PCMWORKRESUME" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmworkresumes/{pcmworkresume_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmworkresume_id") String pcmworkresume_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmworkresumeService.remove(pcmworkresume_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PCMWORKRESUME" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmworkresumes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmworkresumeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMWORKRESUME" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmworkresumes/fetchdefault")
	public ResponseEntity<List<PCMWORKRESUMEDTO>> fetchDefault(PCMWORKRESUMESearchContext context) {
        Page<PCMWORKRESUME> domains = pcmworkresumeService.searchDefault(context) ;
        List<PCMWORKRESUMEDTO> list = pcmworkresumeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMWORKRESUME" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmworkresumes/searchdefault")
	public ResponseEntity<Page<PCMWORKRESUMEDTO>> searchDefault(PCMWORKRESUMESearchContext context) {
        Page<PCMWORKRESUME> domains = pcmworkresumeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmworkresumeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}



    @ApiOperation(value = "CreateByPCMPROFILE", tags = {"PCMWORKRESUME" },  notes = "CreateByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmworkresumes")
    @Transactional
    public ResponseEntity<PCMWORKRESUMEDTO> createByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMWORKRESUMEDTO pcmworkresumedto) {
        PCMWORKRESUME domain = pcmworkresumeMapping.toDomain(pcmworkresumedto);
        domain.setPcmprofileid(pcmprofile_id);
		pcmworkresumeService.create(domain);
        PCMWORKRESUMEDTO dto = pcmworkresumeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatchByPCMPROFILE", tags = {"PCMWORKRESUME" },  notes = "createBatchByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmworkresumes/batch")
    public ResponseEntity<Boolean> createBatchByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PCMWORKRESUMEDTO> pcmworkresumedtos) {
        List<PCMWORKRESUME> domainlist=pcmworkresumeMapping.toDomain(pcmworkresumedtos);
        for(PCMWORKRESUME domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmworkresumeService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPCMPROFILE", tags = {"PCMWORKRESUME" },  notes = "GetDraftByPCMPROFILE")
    @RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmworkresumes/getdraft")
    public ResponseEntity<PCMWORKRESUMEDTO> getDraftByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id) {
        PCMWORKRESUME domain = new PCMWORKRESUME();
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmworkresumeMapping.toDto(pcmworkresumeService.getDraft(domain)));
    }

    @ApiOperation(value = "SaveByPCMPROFILE", tags = {"PCMWORKRESUME" },  notes = "SaveByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmworkresumes/save")
    public ResponseEntity<Boolean> saveByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMWORKRESUMEDTO pcmworkresumedto) {
        PCMWORKRESUME domain = pcmworkresumeMapping.toDomain(pcmworkresumedto);
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmworkresumeService.save(domain));
    }

    @ApiOperation(value = "SaveBatchByPCMPROFILE", tags = {"PCMWORKRESUME" },  notes = "SaveBatchByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmworkresumes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PCMWORKRESUMEDTO> pcmworkresumedtos) {
        List<PCMWORKRESUME> domainlist=pcmworkresumeMapping.toDomain(pcmworkresumedtos);
        for(PCMWORKRESUME domain:domainlist){
             domain.setPcmprofileid(pcmprofile_id);
        }
        pcmworkresumeService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetByPCMPROFILE", tags = {"PCMWORKRESUME" },  notes = "GetByPCMPROFILE")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmworkresumes/{pcmworkresume_id}")
    public ResponseEntity<PCMWORKRESUMEDTO> getByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmworkresume_id") String pcmworkresume_id) {
        PCMWORKRESUME domain = pcmworkresumeService.get(pcmworkresume_id);
        PCMWORKRESUMEDTO dto = pcmworkresumeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateByPCMPROFILE", tags = {"PCMWORKRESUME" },  notes = "UpdateByPCMPROFILE")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmworkresumes/{pcmworkresume_id}")
    @Transactional
    public ResponseEntity<PCMWORKRESUMEDTO> updateByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmworkresume_id") String pcmworkresume_id, @RequestBody PCMWORKRESUMEDTO pcmworkresumedto) {
        PCMWORKRESUME domain = pcmworkresumeMapping.toDomain(pcmworkresumedto);
        domain.setPcmprofileid(pcmprofile_id);
        domain.setPcmworkresumeid(pcmworkresume_id);
		pcmworkresumeService.update(domain);
        PCMWORKRESUMEDTO dto = pcmworkresumeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatchByPCMPROFILE", tags = {"PCMWORKRESUME" },  notes = "UpdateBatchByPCMPROFILE")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmworkresumes/batch")
    public ResponseEntity<Boolean> updateBatchByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PCMWORKRESUMEDTO> pcmworkresumedtos) {
        List<PCMWORKRESUME> domainlist=pcmworkresumeMapping.toDomain(pcmworkresumedtos);
        for(PCMWORKRESUME domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmworkresumeService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByPCMPROFILE", tags = {"PCMWORKRESUME" },  notes = "CheckKeyByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmworkresumes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMWORKRESUMEDTO pcmworkresumedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmworkresumeService.checkKey(pcmworkresumeMapping.toDomain(pcmworkresumedto)));
    }

    @ApiOperation(value = "RemoveByPCMPROFILE", tags = {"PCMWORKRESUME" },  notes = "RemoveByPCMPROFILE")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmworkresumes/{pcmworkresume_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmworkresume_id") String pcmworkresume_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmworkresumeService.remove(pcmworkresume_id));
    }

    @ApiOperation(value = "RemoveBatchByPCMPROFILE", tags = {"PCMWORKRESUME" },  notes = "RemoveBatchByPCMPROFILE")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmworkresumes/batch")
    public ResponseEntity<Boolean> removeBatchByPCMPROFILE(@RequestBody List<String> ids) {
        pcmworkresumeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetchDEFAULTByPCMPROFILE", tags = {"PCMWORKRESUME" } ,notes = "fetchDEFAULTByPCMPROFILE")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/{pcmprofile_id}/pcmworkresumes/fetchdefault")
	public ResponseEntity<List<PCMWORKRESUMEDTO>> fetchPCMWORKRESUMEDefaultByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id,PCMWORKRESUMESearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PCMWORKRESUME> domains = pcmworkresumeService.searchDefault(context) ;
        List<PCMWORKRESUMEDTO> list = pcmworkresumeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULTByPCMPROFILE", tags = {"PCMWORKRESUME" } ,notes = "searchDEFAULTByPCMPROFILE")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/{pcmprofile_id}/pcmworkresumes/searchdefault")
	public ResponseEntity<Page<PCMWORKRESUMEDTO>> searchPCMWORKRESUMEDefaultByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id,PCMWORKRESUMESearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PCMWORKRESUME> domains = pcmworkresumeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmworkresumeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PCMWORKRESUME getEntity(){
        return new PCMWORKRESUME();
    }

}
