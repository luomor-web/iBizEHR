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
import cn.ibizlab.ehr.core.pcm.domain.PCMPRACTICEEXPERIENCE;
import cn.ibizlab.ehr.core.pcm.service.IPCMPRACTICEEXPERIENCEService;
import cn.ibizlab.ehr.core.pcm.filter.PCMPRACTICEEXPERIENCESearchContext;




@Slf4j
@Api(tags = {"PCMPRACTICEEXPERIENCE" })
@RestController("WebApi-pcmpracticeexperience")
@RequestMapping("")
public class PCMPRACTICEEXPERIENCEResource {

    @Autowired
    private IPCMPRACTICEEXPERIENCEService pcmpracticeexperienceService;

    @Autowired
    @Lazy
    private PCMPRACTICEEXPERIENCEMapping pcmpracticeexperienceMapping;




    @PreAuthorize("hasPermission('Remove',{#pcmpracticeexperience_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PCMPRACTICEEXPERIENCE" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmpracticeexperiences/{pcmpracticeexperience_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmpracticeexperience_id") String pcmpracticeexperience_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmpracticeexperienceService.remove(pcmpracticeexperience_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PCMPRACTICEEXPERIENCE" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmpracticeexperiences/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmpracticeexperienceService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PCMPRACTICEEXPERIENCE" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmpracticeexperiences")
    @Transactional
    public ResponseEntity<PCMPRACTICEEXPERIENCEDTO> create(@RequestBody PCMPRACTICEEXPERIENCEDTO pcmpracticeexperiencedto) {
        PCMPRACTICEEXPERIENCE domain = pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedto);
		pcmpracticeexperienceService.create(domain);
        PCMPRACTICEEXPERIENCEDTO dto = pcmpracticeexperienceMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PCMPRACTICEEXPERIENCE" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmpracticeexperiences/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMPRACTICEEXPERIENCEDTO> pcmpracticeexperiencedtos) {
        pcmpracticeexperienceService.createBatch(pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pcmpracticeexperience_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PCMPRACTICEEXPERIENCE" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmpracticeexperiences/{pcmpracticeexperience_id}")
    @Transactional
    public ResponseEntity<PCMPRACTICEEXPERIENCEDTO> update(@PathVariable("pcmpracticeexperience_id") String pcmpracticeexperience_id, @RequestBody PCMPRACTICEEXPERIENCEDTO pcmpracticeexperiencedto) {
		PCMPRACTICEEXPERIENCE domain = pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedto);
        domain.setPcmpracticeexperienceid(pcmpracticeexperience_id);
		pcmpracticeexperienceService.update(domain);
		PCMPRACTICEEXPERIENCEDTO dto = pcmpracticeexperienceMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pcmpracticeexperience_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMPRACTICEEXPERIENCE" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmpracticeexperiences/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMPRACTICEEXPERIENCEDTO> pcmpracticeexperiencedtos) {
        pcmpracticeexperienceService.updateBatch(pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PCMPRACTICEEXPERIENCE" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmpracticeexperiences/getdraft")
    public ResponseEntity<PCMPRACTICEEXPERIENCEDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmpracticeexperienceMapping.toDto(pcmpracticeexperienceService.getDraft(new PCMPRACTICEEXPERIENCE())));
    }




    @PreAuthorize("hasPermission(#pcmpracticeexperience_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PCMPRACTICEEXPERIENCE" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmpracticeexperiences/{pcmpracticeexperience_id}")
    public ResponseEntity<PCMPRACTICEEXPERIENCEDTO> get(@PathVariable("pcmpracticeexperience_id") String pcmpracticeexperience_id) {
        PCMPRACTICEEXPERIENCE domain = pcmpracticeexperienceService.get(pcmpracticeexperience_id);
        PCMPRACTICEEXPERIENCEDTO dto = pcmpracticeexperienceMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "CheckKey", tags = {"PCMPRACTICEEXPERIENCE" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmpracticeexperiences/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMPRACTICEEXPERIENCEDTO pcmpracticeexperiencedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmpracticeexperienceService.checkKey(pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedto)));
    }




    @ApiOperation(value = "Save", tags = {"PCMPRACTICEEXPERIENCE" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmpracticeexperiences/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMPRACTICEEXPERIENCEDTO pcmpracticeexperiencedto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmpracticeexperienceService.save(pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PCMPRACTICEEXPERIENCE" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmpracticeexperiences/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMPRACTICEEXPERIENCEDTO> pcmpracticeexperiencedtos) {
        pcmpracticeexperienceService.saveBatch(pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMPRACTICEEXPERIENCE" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmpracticeexperiences/fetchdefault")
	public ResponseEntity<List<PCMPRACTICEEXPERIENCEDTO>> fetchDefault(PCMPRACTICEEXPERIENCESearchContext context) {
        Page<PCMPRACTICEEXPERIENCE> domains = pcmpracticeexperienceService.searchDefault(context) ;
        List<PCMPRACTICEEXPERIENCEDTO> list = pcmpracticeexperienceMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"PCMPRACTICEEXPERIENCE" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmpracticeexperiences/searchdefault")
	public ResponseEntity<Page<PCMPRACTICEEXPERIENCEDTO>> searchDefault(@RequestBody PCMPRACTICEEXPERIENCESearchContext context) {
        Page<PCMPRACTICEEXPERIENCE> domains = pcmpracticeexperienceService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmpracticeexperienceMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}



    @ApiOperation(value = "RemoveByPCMPROFILE", tags = {"PCMPRACTICEEXPERIENCE" },  notes = "RemoveByPCMPROFILE")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences/{pcmpracticeexperience_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmpracticeexperience_id") String pcmpracticeexperience_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmpracticeexperienceService.remove(pcmpracticeexperience_id));
    }

    @ApiOperation(value = "RemoveBatchByPCMPROFILE", tags = {"PCMPRACTICEEXPERIENCE" },  notes = "RemoveBatchByPCMPROFILE")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences/batch")
    public ResponseEntity<Boolean> removeBatchByPCMPROFILE(@RequestBody List<String> ids) {
        pcmpracticeexperienceService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CreateByPCMPROFILE", tags = {"PCMPRACTICEEXPERIENCE" },  notes = "CreateByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences")
    @Transactional
    public ResponseEntity<PCMPRACTICEEXPERIENCEDTO> createByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPRACTICEEXPERIENCEDTO pcmpracticeexperiencedto) {
        PCMPRACTICEEXPERIENCE domain = pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedto);
        domain.setPcmprofileid(pcmprofile_id);
		pcmpracticeexperienceService.create(domain);
        PCMPRACTICEEXPERIENCEDTO dto = pcmpracticeexperienceMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatchByPCMPROFILE", tags = {"PCMPRACTICEEXPERIENCE" },  notes = "createBatchByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences/batch")
    public ResponseEntity<Boolean> createBatchByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PCMPRACTICEEXPERIENCEDTO> pcmpracticeexperiencedtos) {
        List<PCMPRACTICEEXPERIENCE> domainlist=pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedtos);
        for(PCMPRACTICEEXPERIENCE domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmpracticeexperienceService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "UpdateByPCMPROFILE", tags = {"PCMPRACTICEEXPERIENCE" },  notes = "UpdateByPCMPROFILE")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences/{pcmpracticeexperience_id}")
    @Transactional
    public ResponseEntity<PCMPRACTICEEXPERIENCEDTO> updateByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmpracticeexperience_id") String pcmpracticeexperience_id, @RequestBody PCMPRACTICEEXPERIENCEDTO pcmpracticeexperiencedto) {
        PCMPRACTICEEXPERIENCE domain = pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedto);
        domain.setPcmprofileid(pcmprofile_id);
        domain.setPcmpracticeexperienceid(pcmpracticeexperience_id);
		pcmpracticeexperienceService.update(domain);
        PCMPRACTICEEXPERIENCEDTO dto = pcmpracticeexperienceMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatchByPCMPROFILE", tags = {"PCMPRACTICEEXPERIENCE" },  notes = "UpdateBatchByPCMPROFILE")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences/batch")
    public ResponseEntity<Boolean> updateBatchByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PCMPRACTICEEXPERIENCEDTO> pcmpracticeexperiencedtos) {
        List<PCMPRACTICEEXPERIENCE> domainlist=pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedtos);
        for(PCMPRACTICEEXPERIENCE domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmpracticeexperienceService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPCMPROFILE", tags = {"PCMPRACTICEEXPERIENCE" },  notes = "GetDraftByPCMPROFILE")
    @RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences/getdraft")
    public ResponseEntity<PCMPRACTICEEXPERIENCEDTO> getDraftByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id) {
        PCMPRACTICEEXPERIENCE domain = new PCMPRACTICEEXPERIENCE();
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmpracticeexperienceMapping.toDto(pcmpracticeexperienceService.getDraft(domain)));
    }

    @ApiOperation(value = "GetByPCMPROFILE", tags = {"PCMPRACTICEEXPERIENCE" },  notes = "GetByPCMPROFILE")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences/{pcmpracticeexperience_id}")
    public ResponseEntity<PCMPRACTICEEXPERIENCEDTO> getByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmpracticeexperience_id") String pcmpracticeexperience_id) {
        PCMPRACTICEEXPERIENCE domain = pcmpracticeexperienceService.get(pcmpracticeexperience_id);
        PCMPRACTICEEXPERIENCEDTO dto = pcmpracticeexperienceMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKeyByPCMPROFILE", tags = {"PCMPRACTICEEXPERIENCE" },  notes = "CheckKeyByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences/checkkey")
    public ResponseEntity<Boolean> checkKeyByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPRACTICEEXPERIENCEDTO pcmpracticeexperiencedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmpracticeexperienceService.checkKey(pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedto)));
    }

    @ApiOperation(value = "SaveByPCMPROFILE", tags = {"PCMPRACTICEEXPERIENCE" },  notes = "SaveByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences/save")
    public ResponseEntity<Boolean> saveByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPRACTICEEXPERIENCEDTO pcmpracticeexperiencedto) {
        PCMPRACTICEEXPERIENCE domain = pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedto);
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmpracticeexperienceService.save(domain));
    }

    @ApiOperation(value = "SaveBatchByPCMPROFILE", tags = {"PCMPRACTICEEXPERIENCE" },  notes = "SaveBatchByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences/savebatch")
    public ResponseEntity<Boolean> saveBatchByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PCMPRACTICEEXPERIENCEDTO> pcmpracticeexperiencedtos) {
        List<PCMPRACTICEEXPERIENCE> domainlist=pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedtos);
        for(PCMPRACTICEEXPERIENCE domain:domainlist){
             domain.setPcmprofileid(pcmprofile_id);
        }
        pcmpracticeexperienceService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetchDEFAULTByPCMPROFILE", tags = {"PCMPRACTICEEXPERIENCE" } ,notes = "fetchDEFAULTByPCMPROFILE")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences/fetchdefault")
	public ResponseEntity<List<PCMPRACTICEEXPERIENCEDTO>> fetchPCMPRACTICEEXPERIENCEDefaultByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id,PCMPRACTICEEXPERIENCESearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PCMPRACTICEEXPERIENCE> domains = pcmpracticeexperienceService.searchDefault(context) ;
        List<PCMPRACTICEEXPERIENCEDTO> list = pcmpracticeexperienceMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULTByPCMPROFILE", tags = {"PCMPRACTICEEXPERIENCE" } ,notes = "searchDEFAULTByPCMPROFILE")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences/searchdefault")
	public ResponseEntity<Page<PCMPRACTICEEXPERIENCEDTO>> searchPCMPRACTICEEXPERIENCEDefaultByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPRACTICEEXPERIENCESearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PCMPRACTICEEXPERIENCE> domains = pcmpracticeexperienceService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmpracticeexperienceMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PCMPRACTICEEXPERIENCE getEntity(){
        return new PCMPRACTICEEXPERIENCE();
    }

}
