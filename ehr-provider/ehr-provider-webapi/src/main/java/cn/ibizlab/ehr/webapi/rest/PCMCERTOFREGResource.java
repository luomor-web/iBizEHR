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
import cn.ibizlab.ehr.core.pcm.domain.PCMCERTOFREG;
import cn.ibizlab.ehr.core.pcm.service.IPCMCERTOFREGService;
import cn.ibizlab.ehr.core.pcm.filter.PCMCERTOFREGSearchContext;




@Slf4j
@Api(tags = {"PCMCERTOFREG" })
@RestController("WebApi-pcmcertofreg")
@RequestMapping("")
public class PCMCERTOFREGResource {

    @Autowired
    private IPCMCERTOFREGService pcmcertofregService;

    @Autowired
    @Lazy
    private PCMCERTOFREGMapping pcmcertofregMapping;




    @PreAuthorize("hasPermission('Remove',{#pcmcertofreg_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PCMCERTOFREG" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmcertofregs/{pcmcertofreg_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmcertofreg_id") String pcmcertofreg_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmcertofregService.remove(pcmcertofreg_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PCMCERTOFREG" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmcertofregs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmcertofregService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"PCMCERTOFREG" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmcertofregs/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMCERTOFREGDTO pcmcertofregdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmcertofregService.save(pcmcertofregMapping.toDomain(pcmcertofregdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PCMCERTOFREG" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmcertofregs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMCERTOFREGDTO> pcmcertofregdtos) {
        pcmcertofregService.saveBatch(pcmcertofregMapping.toDomain(pcmcertofregdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PCMCERTOFREG" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmcertofregs/getdraft")
    public ResponseEntity<PCMCERTOFREGDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmcertofregMapping.toDto(pcmcertofregService.getDraft(new PCMCERTOFREG())));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PCMCERTOFREG" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmcertofregs")
    @Transactional
    public ResponseEntity<PCMCERTOFREGDTO> create(@RequestBody PCMCERTOFREGDTO pcmcertofregdto) {
        PCMCERTOFREG domain = pcmcertofregMapping.toDomain(pcmcertofregdto);
		pcmcertofregService.create(domain);
        PCMCERTOFREGDTO dto = pcmcertofregMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PCMCERTOFREG" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmcertofregs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMCERTOFREGDTO> pcmcertofregdtos) {
        pcmcertofregService.createBatch(pcmcertofregMapping.toDomain(pcmcertofregdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pcmcertofreg_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PCMCERTOFREG" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmcertofregs/{pcmcertofreg_id}")
    @Transactional
    public ResponseEntity<PCMCERTOFREGDTO> update(@PathVariable("pcmcertofreg_id") String pcmcertofreg_id, @RequestBody PCMCERTOFREGDTO pcmcertofregdto) {
		PCMCERTOFREG domain = pcmcertofregMapping.toDomain(pcmcertofregdto);
        domain.setPcmcertofregid(pcmcertofreg_id);
		pcmcertofregService.update(domain);
		PCMCERTOFREGDTO dto = pcmcertofregMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pcmcertofreg_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMCERTOFREG" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmcertofregs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMCERTOFREGDTO> pcmcertofregdtos) {
        pcmcertofregService.updateBatch(pcmcertofregMapping.toDomain(pcmcertofregdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pcmcertofreg_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PCMCERTOFREG" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmcertofregs/{pcmcertofreg_id}")
    public ResponseEntity<PCMCERTOFREGDTO> get(@PathVariable("pcmcertofreg_id") String pcmcertofreg_id) {
        PCMCERTOFREG domain = pcmcertofregService.get(pcmcertofreg_id);
        PCMCERTOFREGDTO dto = pcmcertofregMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "CheckKey", tags = {"PCMCERTOFREG" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmcertofregs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMCERTOFREGDTO pcmcertofregdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmcertofregService.checkKey(pcmcertofregMapping.toDomain(pcmcertofregdto)));
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMCERTOFREG" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmcertofregs/fetchdefault")
	public ResponseEntity<List<PCMCERTOFREGDTO>> fetchDefault(PCMCERTOFREGSearchContext context) {
        Page<PCMCERTOFREG> domains = pcmcertofregService.searchDefault(context) ;
        List<PCMCERTOFREGDTO> list = pcmcertofregMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMCERTOFREG" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmcertofregs/searchdefault")
	public ResponseEntity<Page<PCMCERTOFREGDTO>> searchDefault(PCMCERTOFREGSearchContext context) {
        Page<PCMCERTOFREG> domains = pcmcertofregService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmcertofregMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}



    @ApiOperation(value = "RemoveByPCMPROFILE", tags = {"PCMCERTOFREG" },  notes = "RemoveByPCMPROFILE")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmcertofregs/{pcmcertofreg_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmcertofreg_id") String pcmcertofreg_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmcertofregService.remove(pcmcertofreg_id));
    }

    @ApiOperation(value = "RemoveBatchByPCMPROFILE", tags = {"PCMCERTOFREG" },  notes = "RemoveBatchByPCMPROFILE")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmcertofregs/batch")
    public ResponseEntity<Boolean> removeBatchByPCMPROFILE(@RequestBody List<String> ids) {
        pcmcertofregService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "SaveByPCMPROFILE", tags = {"PCMCERTOFREG" },  notes = "SaveByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmcertofregs/save")
    public ResponseEntity<Boolean> saveByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMCERTOFREGDTO pcmcertofregdto) {
        PCMCERTOFREG domain = pcmcertofregMapping.toDomain(pcmcertofregdto);
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmcertofregService.save(domain));
    }

    @ApiOperation(value = "SaveBatchByPCMPROFILE", tags = {"PCMCERTOFREG" },  notes = "SaveBatchByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmcertofregs/savebatch")
    public ResponseEntity<Boolean> saveBatchByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PCMCERTOFREGDTO> pcmcertofregdtos) {
        List<PCMCERTOFREG> domainlist=pcmcertofregMapping.toDomain(pcmcertofregdtos);
        for(PCMCERTOFREG domain:domainlist){
             domain.setPcmprofileid(pcmprofile_id);
        }
        pcmcertofregService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPCMPROFILE", tags = {"PCMCERTOFREG" },  notes = "GetDraftByPCMPROFILE")
    @RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmcertofregs/getdraft")
    public ResponseEntity<PCMCERTOFREGDTO> getDraftByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id) {
        PCMCERTOFREG domain = new PCMCERTOFREG();
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmcertofregMapping.toDto(pcmcertofregService.getDraft(domain)));
    }

    @ApiOperation(value = "CreateByPCMPROFILE", tags = {"PCMCERTOFREG" },  notes = "CreateByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmcertofregs")
    @Transactional
    public ResponseEntity<PCMCERTOFREGDTO> createByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMCERTOFREGDTO pcmcertofregdto) {
        PCMCERTOFREG domain = pcmcertofregMapping.toDomain(pcmcertofregdto);
        domain.setPcmprofileid(pcmprofile_id);
		pcmcertofregService.create(domain);
        PCMCERTOFREGDTO dto = pcmcertofregMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatchByPCMPROFILE", tags = {"PCMCERTOFREG" },  notes = "createBatchByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmcertofregs/batch")
    public ResponseEntity<Boolean> createBatchByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PCMCERTOFREGDTO> pcmcertofregdtos) {
        List<PCMCERTOFREG> domainlist=pcmcertofregMapping.toDomain(pcmcertofregdtos);
        for(PCMCERTOFREG domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmcertofregService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "UpdateByPCMPROFILE", tags = {"PCMCERTOFREG" },  notes = "UpdateByPCMPROFILE")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmcertofregs/{pcmcertofreg_id}")
    @Transactional
    public ResponseEntity<PCMCERTOFREGDTO> updateByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmcertofreg_id") String pcmcertofreg_id, @RequestBody PCMCERTOFREGDTO pcmcertofregdto) {
        PCMCERTOFREG domain = pcmcertofregMapping.toDomain(pcmcertofregdto);
        domain.setPcmprofileid(pcmprofile_id);
        domain.setPcmcertofregid(pcmcertofreg_id);
		pcmcertofregService.update(domain);
        PCMCERTOFREGDTO dto = pcmcertofregMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatchByPCMPROFILE", tags = {"PCMCERTOFREG" },  notes = "UpdateBatchByPCMPROFILE")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmcertofregs/batch")
    public ResponseEntity<Boolean> updateBatchByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PCMCERTOFREGDTO> pcmcertofregdtos) {
        List<PCMCERTOFREG> domainlist=pcmcertofregMapping.toDomain(pcmcertofregdtos);
        for(PCMCERTOFREG domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmcertofregService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetByPCMPROFILE", tags = {"PCMCERTOFREG" },  notes = "GetByPCMPROFILE")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmcertofregs/{pcmcertofreg_id}")
    public ResponseEntity<PCMCERTOFREGDTO> getByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmcertofreg_id") String pcmcertofreg_id) {
        PCMCERTOFREG domain = pcmcertofregService.get(pcmcertofreg_id);
        PCMCERTOFREGDTO dto = pcmcertofregMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKeyByPCMPROFILE", tags = {"PCMCERTOFREG" },  notes = "CheckKeyByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmcertofregs/checkkey")
    public ResponseEntity<Boolean> checkKeyByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMCERTOFREGDTO pcmcertofregdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmcertofregService.checkKey(pcmcertofregMapping.toDomain(pcmcertofregdto)));
    }

	@ApiOperation(value = "fetchDEFAULTByPCMPROFILE", tags = {"PCMCERTOFREG" } ,notes = "fetchDEFAULTByPCMPROFILE")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/{pcmprofile_id}/pcmcertofregs/fetchdefault")
	public ResponseEntity<List<PCMCERTOFREGDTO>> fetchPCMCERTOFREGDefaultByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id,PCMCERTOFREGSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PCMCERTOFREG> domains = pcmcertofregService.searchDefault(context) ;
        List<PCMCERTOFREGDTO> list = pcmcertofregMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULTByPCMPROFILE", tags = {"PCMCERTOFREG" } ,notes = "searchDEFAULTByPCMPROFILE")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/{pcmprofile_id}/pcmcertofregs/searchdefault")
	public ResponseEntity<Page<PCMCERTOFREGDTO>> searchPCMCERTOFREGDefaultByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id,PCMCERTOFREGSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PCMCERTOFREG> domains = pcmcertofregService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmcertofregMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PCMCERTOFREG getEntity(){
        return new PCMCERTOFREG();
    }

}
