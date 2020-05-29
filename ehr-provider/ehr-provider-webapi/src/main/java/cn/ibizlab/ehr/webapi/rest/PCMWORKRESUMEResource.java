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
import cn.ibizlab.ehr.core.pcm.domain.PCMWORKRESUME;
import cn.ibizlab.ehr.core.pcm.service.IPCMWORKRESUMEService;
import cn.ibizlab.ehr.core.pcm.filter.PCMWORKRESUMESearchContext;

@Slf4j
@Api(tags = {"PCMWORKRESUME" })
@RestController("WebApi-pcmworkresume")
@RequestMapping("")
public class PCMWORKRESUMEResource {

    @Autowired
    public IPCMWORKRESUMEService pcmworkresumeService;

    @Autowired
    @Lazy
    public PCMWORKRESUMEMapping pcmworkresumeMapping;

    @PreAuthorize("hasPermission(this.pcmworkresumeMapping.toDomain(#pcmworkresumedto),'ehr-PCMWORKRESUME-Create')")
    @ApiOperation(value = "Create", tags = {"PCMWORKRESUME" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmworkresumes")
    @Transactional
    public ResponseEntity<PCMWORKRESUMEDTO> create(@RequestBody PCMWORKRESUMEDTO pcmworkresumedto) {
        PCMWORKRESUME domain = pcmworkresumeMapping.toDomain(pcmworkresumedto);
		pcmworkresumeService.create(domain);
        PCMWORKRESUMEDTO dto = pcmworkresumeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmworkresumeMapping.toDomain(#pcmworkresumedtos),'ehr-PCMWORKRESUME-Create')")
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

    @PreAuthorize("hasPermission(this.pcmworkresumeMapping.toDomain(#pcmworkresumedto),'ehr-PCMWORKRESUME-Save')")
    @ApiOperation(value = "Save", tags = {"PCMWORKRESUME" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmworkresumes/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMWORKRESUMEDTO pcmworkresumedto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmworkresumeService.save(pcmworkresumeMapping.toDomain(pcmworkresumedto)));
    }

    @PreAuthorize("hasPermission(this.pcmworkresumeMapping.toDomain(#pcmworkresumedtos),'ehr-PCMWORKRESUME-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PCMWORKRESUME" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmworkresumes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMWORKRESUMEDTO> pcmworkresumedtos) {
        pcmworkresumeService.saveBatch(pcmworkresumeMapping.toDomain(pcmworkresumedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmworkresumeMapping.toDomain(returnObject.body),'ehr-PCMWORKRESUME-Get')")
    @ApiOperation(value = "Get", tags = {"PCMWORKRESUME" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmworkresumes/{pcmworkresume_id}")
    public ResponseEntity<PCMWORKRESUMEDTO> get(@PathVariable("pcmworkresume_id") String pcmworkresume_id) {
        PCMWORKRESUME domain = pcmworkresumeService.get(pcmworkresume_id);
        PCMWORKRESUMEDTO dto = pcmworkresumeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmworkresumeService.get(#pcmworkresume_id),'ehr-PCMWORKRESUME-Update')")
    @ApiOperation(value = "Update", tags = {"PCMWORKRESUME" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmworkresumes/{pcmworkresume_id}")
    @Transactional
    public ResponseEntity<PCMWORKRESUMEDTO> update(@PathVariable("pcmworkresume_id") String pcmworkresume_id, @RequestBody PCMWORKRESUMEDTO pcmworkresumedto) {
		PCMWORKRESUME domain  = pcmworkresumeMapping.toDomain(pcmworkresumedto);
        domain .setPcmworkresumeid(pcmworkresume_id);
		pcmworkresumeService.update(domain );
		PCMWORKRESUMEDTO dto = pcmworkresumeMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmworkresumeService.getPcmworkresumeByEntities(this.pcmworkresumeMapping.toDomain(#pcmworkresumedtos)),'ehr-PCMWORKRESUME-Update')")
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

    @PreAuthorize("hasPermission(this.pcmworkresumeService.get(#pcmworkresume_id),'ehr-PCMWORKRESUME-Remove')")
    @ApiOperation(value = "Remove", tags = {"PCMWORKRESUME" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmworkresumes/{pcmworkresume_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmworkresume_id") String pcmworkresume_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmworkresumeService.remove(pcmworkresume_id));
    }

    @PreAuthorize("hasPermission(this.pcmworkresumeService.getPcmworkresumeByIds(#ids),'ehr-PCMWORKRESUME-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PCMWORKRESUME" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmworkresumes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmworkresumeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMWORKRESUME-Default-all')")
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

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMWORKRESUME-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMWORKRESUME" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmworkresumes/searchdefault")
	public ResponseEntity<Page<PCMWORKRESUMEDTO>> searchDefault(@RequestBody PCMWORKRESUMESearchContext context) {
        Page<PCMWORKRESUME> domains = pcmworkresumeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmworkresumeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pcmworkresumeMapping.toDomain(#pcmworkresumedto),'ehr-PCMWORKRESUME-Create')")
    @ApiOperation(value = "CreateByPcmProfile", tags = {"PCMWORKRESUME" },  notes = "CreateByPcmProfile")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmworkresumes")
    @Transactional
    public ResponseEntity<PCMWORKRESUMEDTO> createByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMWORKRESUMEDTO pcmworkresumedto) {
        PCMWORKRESUME domain = pcmworkresumeMapping.toDomain(pcmworkresumedto);
        domain.setPcmprofileid(pcmprofile_id);
		pcmworkresumeService.create(domain);
        PCMWORKRESUMEDTO dto = pcmworkresumeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmworkresumeMapping.toDomain(#pcmworkresumedtos),'ehr-PCMWORKRESUME-Create')")
    @ApiOperation(value = "createBatchByPcmProfile", tags = {"PCMWORKRESUME" },  notes = "createBatchByPcmProfile")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmworkresumes/batch")
    public ResponseEntity<Boolean> createBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PCMWORKRESUMEDTO> pcmworkresumedtos) {
        List<PCMWORKRESUME> domainlist=pcmworkresumeMapping.toDomain(pcmworkresumedtos);
        for(PCMWORKRESUME domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmworkresumeService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPcmProfile", tags = {"PCMWORKRESUME" },  notes = "GetDraftByPcmProfile")
    @RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmworkresumes/getdraft")
    public ResponseEntity<PCMWORKRESUMEDTO> getDraftByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id) {
        PCMWORKRESUME domain = new PCMWORKRESUME();
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmworkresumeMapping.toDto(pcmworkresumeService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pcmworkresumeMapping.toDomain(#pcmworkresumedto),'ehr-PCMWORKRESUME-Save')")
    @ApiOperation(value = "SaveByPcmProfile", tags = {"PCMWORKRESUME" },  notes = "SaveByPcmProfile")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmworkresumes/save")
    public ResponseEntity<Boolean> saveByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMWORKRESUMEDTO pcmworkresumedto) {
        PCMWORKRESUME domain = pcmworkresumeMapping.toDomain(pcmworkresumedto);
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmworkresumeService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmworkresumeMapping.toDomain(#pcmworkresumedtos),'ehr-PCMWORKRESUME-Save')")
    @ApiOperation(value = "SaveBatchByPcmProfile", tags = {"PCMWORKRESUME" },  notes = "SaveBatchByPcmProfile")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmworkresumes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PCMWORKRESUMEDTO> pcmworkresumedtos) {
        List<PCMWORKRESUME> domainlist=pcmworkresumeMapping.toDomain(pcmworkresumedtos);
        for(PCMWORKRESUME domain:domainlist){
             domain.setPcmprofileid(pcmprofile_id);
        }
        pcmworkresumeService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmworkresumeMapping.toDomain(returnObject.body),'ehr-PCMWORKRESUME-Get')")
    @ApiOperation(value = "GetByPcmProfile", tags = {"PCMWORKRESUME" },  notes = "GetByPcmProfile")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmworkresumes/{pcmworkresume_id}")
    public ResponseEntity<PCMWORKRESUMEDTO> getByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmworkresume_id") String pcmworkresume_id) {
        PCMWORKRESUME domain = pcmworkresumeService.get(pcmworkresume_id);
        PCMWORKRESUMEDTO dto = pcmworkresumeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmworkresumeService.get(#pcmworkresume_id),'ehr-PCMWORKRESUME-Update')")
    @ApiOperation(value = "UpdateByPcmProfile", tags = {"PCMWORKRESUME" },  notes = "UpdateByPcmProfile")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmworkresumes/{pcmworkresume_id}")
    @Transactional
    public ResponseEntity<PCMWORKRESUMEDTO> updateByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmworkresume_id") String pcmworkresume_id, @RequestBody PCMWORKRESUMEDTO pcmworkresumedto) {
        PCMWORKRESUME domain = pcmworkresumeMapping.toDomain(pcmworkresumedto);
        domain.setPcmprofileid(pcmprofile_id);
        domain.setPcmworkresumeid(pcmworkresume_id);
		pcmworkresumeService.update(domain);
        PCMWORKRESUMEDTO dto = pcmworkresumeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmworkresumeService.getPcmworkresumeByEntities(this.pcmworkresumeMapping.toDomain(#pcmworkresumedtos)),'ehr-PCMWORKRESUME-Update')")
    @ApiOperation(value = "UpdateBatchByPcmProfile", tags = {"PCMWORKRESUME" },  notes = "UpdateBatchByPcmProfile")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmworkresumes/batch")
    public ResponseEntity<Boolean> updateBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PCMWORKRESUMEDTO> pcmworkresumedtos) {
        List<PCMWORKRESUME> domainlist=pcmworkresumeMapping.toDomain(pcmworkresumedtos);
        for(PCMWORKRESUME domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmworkresumeService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByPcmProfile", tags = {"PCMWORKRESUME" },  notes = "CheckKeyByPcmProfile")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmworkresumes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMWORKRESUMEDTO pcmworkresumedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmworkresumeService.checkKey(pcmworkresumeMapping.toDomain(pcmworkresumedto)));
    }

    @PreAuthorize("hasPermission(this.pcmworkresumeService.get(#pcmworkresume_id),'ehr-PCMWORKRESUME-Remove')")
    @ApiOperation(value = "RemoveByPcmProfile", tags = {"PCMWORKRESUME" },  notes = "RemoveByPcmProfile")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmworkresumes/{pcmworkresume_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmworkresume_id") String pcmworkresume_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmworkresumeService.remove(pcmworkresume_id));
    }

    @PreAuthorize("hasPermission(this.pcmworkresumeService.getPcmworkresumeByIds(#ids),'ehr-PCMWORKRESUME-Remove')")
    @ApiOperation(value = "RemoveBatchByPcmProfile", tags = {"PCMWORKRESUME" },  notes = "RemoveBatchByPcmProfile")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmworkresumes/batch")
    public ResponseEntity<Boolean> removeBatchByPcmProfile(@RequestBody List<String> ids) {
        pcmworkresumeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMWORKRESUME-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPcmProfile", tags = {"PCMWORKRESUME" } ,notes = "fetchDEFAULTByPcmProfile")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/{pcmprofile_id}/pcmworkresumes/fetchdefault")
	public ResponseEntity<List<PCMWORKRESUMEDTO>> fetchPCMWORKRESUMEDefaultByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id,PCMWORKRESUMESearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PCMWORKRESUME> domains = pcmworkresumeService.searchDefault(context) ;
        List<PCMWORKRESUMEDTO> list = pcmworkresumeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMWORKRESUME-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPcmProfile", tags = {"PCMWORKRESUME" } ,notes = "searchDEFAULTByPcmProfile")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/{pcmprofile_id}/pcmworkresumes/searchdefault")
	public ResponseEntity<Page<PCMWORKRESUMEDTO>> searchPCMWORKRESUMEDefaultByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMWORKRESUMESearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PCMWORKRESUME> domains = pcmworkresumeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmworkresumeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

