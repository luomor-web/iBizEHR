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
import cn.ibizlab.ehr.core.pcm.domain.PCMAWARDSWONS;
import cn.ibizlab.ehr.core.pcm.service.IPCMAWARDSWONSService;
import cn.ibizlab.ehr.core.pcm.filter.PCMAWARDSWONSSearchContext;




@Slf4j
@Api(tags = {"PCMAWARDSWONS" })
@RestController("WebApi-pcmawardswons")
@RequestMapping("")
public class PCMAWARDSWONSResource {

    @Autowired
    private IPCMAWARDSWONSService pcmawardswonsService;

    @Autowired
    @Lazy
    private PCMAWARDSWONSMapping pcmawardswonsMapping;




    @ApiOperation(value = "GetDraft", tags = {"PCMAWARDSWONS" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmawardswons/getdraft")
    public ResponseEntity<PCMAWARDSWONSDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmawardswonsMapping.toDto(pcmawardswonsService.getDraft(new PCMAWARDSWONS())));
    }




    @PreAuthorize("hasPermission(#pcmawardswons_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PCMAWARDSWONS" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmawardswons/{pcmawardswons_id}")
    public ResponseEntity<PCMAWARDSWONSDTO> get(@PathVariable("pcmawardswons_id") String pcmawardswons_id) {
        PCMAWARDSWONS domain = pcmawardswonsService.get(pcmawardswons_id);
        PCMAWARDSWONSDTO dto = pcmawardswonsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#pcmawardswons_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PCMAWARDSWONS" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmawardswons/{pcmawardswons_id}")
    @Transactional
    public ResponseEntity<PCMAWARDSWONSDTO> update(@PathVariable("pcmawardswons_id") String pcmawardswons_id, @RequestBody PCMAWARDSWONSDTO pcmawardswonsdto) {
		PCMAWARDSWONS domain = pcmawardswonsMapping.toDomain(pcmawardswonsdto);
        domain.setPcmawardswonsid(pcmawardswons_id);
		pcmawardswonsService.update(domain);
		PCMAWARDSWONSDTO dto = pcmawardswonsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pcmawardswons_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMAWARDSWONS" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmawardswons/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMAWARDSWONSDTO> pcmawardswonsdtos) {
        pcmawardswonsService.updateBatch(pcmawardswonsMapping.toDomain(pcmawardswonsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PCMAWARDSWONS" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmawardswons")
    @Transactional
    public ResponseEntity<PCMAWARDSWONSDTO> create(@RequestBody PCMAWARDSWONSDTO pcmawardswonsdto) {
        PCMAWARDSWONS domain = pcmawardswonsMapping.toDomain(pcmawardswonsdto);
		pcmawardswonsService.create(domain);
        PCMAWARDSWONSDTO dto = pcmawardswonsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PCMAWARDSWONS" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmawardswons/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMAWARDSWONSDTO> pcmawardswonsdtos) {
        pcmawardswonsService.createBatch(pcmawardswonsMapping.toDomain(pcmawardswonsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"PCMAWARDSWONS" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmawardswons/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMAWARDSWONSDTO pcmawardswonsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmawardswonsService.checkKey(pcmawardswonsMapping.toDomain(pcmawardswonsdto)));
    }




    @ApiOperation(value = "Save", tags = {"PCMAWARDSWONS" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmawardswons/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMAWARDSWONSDTO pcmawardswonsdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmawardswonsService.save(pcmawardswonsMapping.toDomain(pcmawardswonsdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PCMAWARDSWONS" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmawardswons/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMAWARDSWONSDTO> pcmawardswonsdtos) {
        pcmawardswonsService.saveBatch(pcmawardswonsMapping.toDomain(pcmawardswonsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#pcmawardswons_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PCMAWARDSWONS" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmawardswons/{pcmawardswons_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmawardswons_id") String pcmawardswons_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmawardswonsService.remove(pcmawardswons_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PCMAWARDSWONS" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmawardswons/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmawardswonsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMAWARDSWONS" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmawardswons/fetchdefault")
	public ResponseEntity<List<PCMAWARDSWONSDTO>> fetchDefault(PCMAWARDSWONSSearchContext context) {
        Page<PCMAWARDSWONS> domains = pcmawardswonsService.searchDefault(context) ;
        List<PCMAWARDSWONSDTO> list = pcmawardswonsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMAWARDSWONS" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmawardswons/searchdefault")
	public ResponseEntity<Page<PCMAWARDSWONSDTO>> searchDefault(PCMAWARDSWONSSearchContext context) {
        Page<PCMAWARDSWONS> domains = pcmawardswonsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmawardswonsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}



    @ApiOperation(value = "GetDraftByPCMPROFILE", tags = {"PCMAWARDSWONS" },  notes = "GetDraftByPCMPROFILE")
    @RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmawardswons/getdraft")
    public ResponseEntity<PCMAWARDSWONSDTO> getDraftByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id) {
        PCMAWARDSWONS domain = new PCMAWARDSWONS();
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmawardswonsMapping.toDto(pcmawardswonsService.getDraft(domain)));
    }

    @ApiOperation(value = "GetByPCMPROFILE", tags = {"PCMAWARDSWONS" },  notes = "GetByPCMPROFILE")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmawardswons/{pcmawardswons_id}")
    public ResponseEntity<PCMAWARDSWONSDTO> getByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmawardswons_id") String pcmawardswons_id) {
        PCMAWARDSWONS domain = pcmawardswonsService.get(pcmawardswons_id);
        PCMAWARDSWONSDTO dto = pcmawardswonsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateByPCMPROFILE", tags = {"PCMAWARDSWONS" },  notes = "UpdateByPCMPROFILE")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmawardswons/{pcmawardswons_id}")
    @Transactional
    public ResponseEntity<PCMAWARDSWONSDTO> updateByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmawardswons_id") String pcmawardswons_id, @RequestBody PCMAWARDSWONSDTO pcmawardswonsdto) {
        PCMAWARDSWONS domain = pcmawardswonsMapping.toDomain(pcmawardswonsdto);
        domain.setPcmprofileid(pcmprofile_id);
        domain.setPcmawardswonsid(pcmawardswons_id);
		pcmawardswonsService.update(domain);
        PCMAWARDSWONSDTO dto = pcmawardswonsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatchByPCMPROFILE", tags = {"PCMAWARDSWONS" },  notes = "UpdateBatchByPCMPROFILE")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmawardswons/batch")
    public ResponseEntity<Boolean> updateBatchByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PCMAWARDSWONSDTO> pcmawardswonsdtos) {
        List<PCMAWARDSWONS> domainlist=pcmawardswonsMapping.toDomain(pcmawardswonsdtos);
        for(PCMAWARDSWONS domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmawardswonsService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CreateByPCMPROFILE", tags = {"PCMAWARDSWONS" },  notes = "CreateByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmawardswons")
    @Transactional
    public ResponseEntity<PCMAWARDSWONSDTO> createByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMAWARDSWONSDTO pcmawardswonsdto) {
        PCMAWARDSWONS domain = pcmawardswonsMapping.toDomain(pcmawardswonsdto);
        domain.setPcmprofileid(pcmprofile_id);
		pcmawardswonsService.create(domain);
        PCMAWARDSWONSDTO dto = pcmawardswonsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatchByPCMPROFILE", tags = {"PCMAWARDSWONS" },  notes = "createBatchByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmawardswons/batch")
    public ResponseEntity<Boolean> createBatchByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PCMAWARDSWONSDTO> pcmawardswonsdtos) {
        List<PCMAWARDSWONS> domainlist=pcmawardswonsMapping.toDomain(pcmawardswonsdtos);
        for(PCMAWARDSWONS domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmawardswonsService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByPCMPROFILE", tags = {"PCMAWARDSWONS" },  notes = "CheckKeyByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmawardswons/checkkey")
    public ResponseEntity<Boolean> checkKeyByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMAWARDSWONSDTO pcmawardswonsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmawardswonsService.checkKey(pcmawardswonsMapping.toDomain(pcmawardswonsdto)));
    }

    @ApiOperation(value = "SaveByPCMPROFILE", tags = {"PCMAWARDSWONS" },  notes = "SaveByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmawardswons/save")
    public ResponseEntity<Boolean> saveByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMAWARDSWONSDTO pcmawardswonsdto) {
        PCMAWARDSWONS domain = pcmawardswonsMapping.toDomain(pcmawardswonsdto);
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmawardswonsService.save(domain));
    }

    @ApiOperation(value = "SaveBatchByPCMPROFILE", tags = {"PCMAWARDSWONS" },  notes = "SaveBatchByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmawardswons/savebatch")
    public ResponseEntity<Boolean> saveBatchByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PCMAWARDSWONSDTO> pcmawardswonsdtos) {
        List<PCMAWARDSWONS> domainlist=pcmawardswonsMapping.toDomain(pcmawardswonsdtos);
        for(PCMAWARDSWONS domain:domainlist){
             domain.setPcmprofileid(pcmprofile_id);
        }
        pcmawardswonsService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "RemoveByPCMPROFILE", tags = {"PCMAWARDSWONS" },  notes = "RemoveByPCMPROFILE")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmawardswons/{pcmawardswons_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmawardswons_id") String pcmawardswons_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmawardswonsService.remove(pcmawardswons_id));
    }

    @ApiOperation(value = "RemoveBatchByPCMPROFILE", tags = {"PCMAWARDSWONS" },  notes = "RemoveBatchByPCMPROFILE")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmawardswons/batch")
    public ResponseEntity<Boolean> removeBatchByPCMPROFILE(@RequestBody List<String> ids) {
        pcmawardswonsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetchDEFAULTByPCMPROFILE", tags = {"PCMAWARDSWONS" } ,notes = "fetchDEFAULTByPCMPROFILE")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/{pcmprofile_id}/pcmawardswons/fetchdefault")
	public ResponseEntity<List<PCMAWARDSWONSDTO>> fetchPCMAWARDSWONSDefaultByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id,PCMAWARDSWONSSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PCMAWARDSWONS> domains = pcmawardswonsService.searchDefault(context) ;
        List<PCMAWARDSWONSDTO> list = pcmawardswonsMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULTByPCMPROFILE", tags = {"PCMAWARDSWONS" } ,notes = "searchDEFAULTByPCMPROFILE")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/{pcmprofile_id}/pcmawardswons/searchdefault")
	public ResponseEntity<Page<PCMAWARDSWONSDTO>> searchPCMAWARDSWONSDefaultByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id,PCMAWARDSWONSSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PCMAWARDSWONS> domains = pcmawardswonsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmawardswonsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PCMAWARDSWONS getEntity(){
        return new PCMAWARDSWONS();
    }

}
