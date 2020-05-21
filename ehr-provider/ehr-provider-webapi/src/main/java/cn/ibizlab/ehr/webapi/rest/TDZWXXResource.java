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
import cn.ibizlab.ehr.core.pcm.domain.TDZWXX;
import cn.ibizlab.ehr.core.pcm.service.ITDZWXXService;
import cn.ibizlab.ehr.core.pcm.filter.TDZWXXSearchContext;




@Slf4j
@Api(tags = {"TDZWXX" })
@RestController("WebApi-tdzwxx")
@RequestMapping("")
public class TDZWXXResource {

    @Autowired
    private ITDZWXXService tdzwxxService;

    @Autowired
    @Lazy
    public TDZWXXMapping tdzwxxMapping;

    public TDZWXXDTO permissionDTO=new TDZWXXDTO();




    @PreAuthorize("hasPermission('','Create',{'Sql',this.tdzwxxMapping,#tdzwxxdto})")
    @ApiOperation(value = "Create", tags = {"TDZWXX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/tdzwxxes")
    @Transactional
    public ResponseEntity<TDZWXXDTO> create(@RequestBody TDZWXXDTO tdzwxxdto) {
        TDZWXX domain = tdzwxxMapping.toDomain(tdzwxxdto);
		tdzwxxService.create(domain);
        TDZWXXDTO dto = tdzwxxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"TDZWXX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/tdzwxxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TDZWXXDTO> tdzwxxdtos) {
        tdzwxxService.createBatch(tdzwxxMapping.toDomain(tdzwxxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TDZWXX-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"TDZWXX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/tdzwxxes/getdraft")
    public ResponseEntity<TDZWXXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(tdzwxxMapping.toDto(tdzwxxService.getDraft(new TDZWXX())));
    }




    @PreAuthorize("hasPermission(#tdzwxx_id,'Remove',{'Sql',this.tdzwxxMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"TDZWXX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/tdzwxxes/{tdzwxx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("tdzwxx_id") String tdzwxx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(tdzwxxService.remove(tdzwxx_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"TDZWXX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/tdzwxxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        tdzwxxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TDZWXX-Save-all')")
    @ApiOperation(value = "Save", tags = {"TDZWXX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/tdzwxxes/save")
    public ResponseEntity<Boolean> save(@RequestBody TDZWXXDTO tdzwxxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(tdzwxxService.save(tdzwxxMapping.toDomain(tdzwxxdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"TDZWXX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/tdzwxxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TDZWXXDTO> tdzwxxdtos) {
        tdzwxxService.saveBatch(tdzwxxMapping.toDomain(tdzwxxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#tdzwxx_id,'Update',{'Sql',this.tdzwxxMapping,#tdzwxxdto})")
    @ApiOperation(value = "Update", tags = {"TDZWXX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/tdzwxxes/{tdzwxx_id}")
    @Transactional
    public ResponseEntity<TDZWXXDTO> update(@PathVariable("tdzwxx_id") String tdzwxx_id, @RequestBody TDZWXXDTO tdzwxxdto) {
		TDZWXX domain = tdzwxxMapping.toDomain(tdzwxxdto);
        domain.setTdzwxxid(tdzwxx_id);
		tdzwxxService.update(domain);
		TDZWXXDTO dto = tdzwxxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"TDZWXX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/tdzwxxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TDZWXXDTO> tdzwxxdtos) {
        tdzwxxService.updateBatch(tdzwxxMapping.toDomain(tdzwxxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TDZWXX-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"TDZWXX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/tdzwxxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TDZWXXDTO tdzwxxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(tdzwxxService.checkKey(tdzwxxMapping.toDomain(tdzwxxdto)));
    }




    @PreAuthorize("hasPermission(#tdzwxx_id,'Get',{'Sql',this.tdzwxxMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"TDZWXX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/tdzwxxes/{tdzwxx_id}")
    public ResponseEntity<TDZWXXDTO> get(@PathVariable("tdzwxx_id") String tdzwxx_id) {
        TDZWXX domain = tdzwxxService.get(tdzwxx_id);
        TDZWXXDTO dto = tdzwxxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TDZWXX-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TDZWXX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/tdzwxxes/fetchdefault")
	public ResponseEntity<List<TDZWXXDTO>> fetchDefault(TDZWXXSearchContext context) {
        Page<TDZWXX> domains = tdzwxxService.searchDefault(context) ;
        List<TDZWXXDTO> list = tdzwxxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TDZWXX-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TDZWXX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/tdzwxxes/searchdefault")
	public ResponseEntity<Page<TDZWXXDTO>> searchDefault(@RequestBody TDZWXXSearchContext context) {
        Page<TDZWXX> domains = tdzwxxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(tdzwxxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}



    //@PreAuthorize("hasPermission('','Create',{'Sql',this.tdzwxxMapping,#tdzwxxdto})")
    @ApiOperation(value = "CreateByPCMPROFILE", tags = {"TDZWXX" },  notes = "CreateByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/tdzwxxes")
    @Transactional
    public ResponseEntity<TDZWXXDTO> createByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody TDZWXXDTO tdzwxxdto) {
        TDZWXX domain = tdzwxxMapping.toDomain(tdzwxxdto);
        domain.setPcmprofileid(pcmprofile_id);
		tdzwxxService.create(domain);
        TDZWXXDTO dto = tdzwxxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatchByPCMPROFILE", tags = {"TDZWXX" },  notes = "createBatchByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/tdzwxxes/batch")
    public ResponseEntity<Boolean> createBatchByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<TDZWXXDTO> tdzwxxdtos) {
        List<TDZWXX> domainlist=tdzwxxMapping.toDomain(tdzwxxdtos);
        for(TDZWXX domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        tdzwxxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TDZWXX-GetDraft-all')")
    @ApiOperation(value = "GetDraftByPCMPROFILE", tags = {"TDZWXX" },  notes = "GetDraftByPCMPROFILE")
    @RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/tdzwxxes/getdraft")
    public ResponseEntity<TDZWXXDTO> getDraftByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id) {
        TDZWXX domain = new TDZWXX();
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(tdzwxxMapping.toDto(tdzwxxService.getDraft(domain)));
    }

    //@PreAuthorize("hasPermission(#tdzwxx_id,'Remove',{'Sql',this.tdzwxxMapping,this.permissionDTO})")
    @ApiOperation(value = "RemoveByPCMPROFILE", tags = {"TDZWXX" },  notes = "RemoveByPCMPROFILE")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/tdzwxxes/{tdzwxx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("tdzwxx_id") String tdzwxx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(tdzwxxService.remove(tdzwxx_id));
    }

    @ApiOperation(value = "RemoveBatchByPCMPROFILE", tags = {"TDZWXX" },  notes = "RemoveBatchByPCMPROFILE")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/tdzwxxes/batch")
    public ResponseEntity<Boolean> removeBatchByPCMPROFILE(@RequestBody List<String> ids) {
        tdzwxxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TDZWXX-Save-all')")
    @ApiOperation(value = "SaveByPCMPROFILE", tags = {"TDZWXX" },  notes = "SaveByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/tdzwxxes/save")
    public ResponseEntity<Boolean> saveByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody TDZWXXDTO tdzwxxdto) {
        TDZWXX domain = tdzwxxMapping.toDomain(tdzwxxdto);
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(tdzwxxService.save(domain));
    }

    @ApiOperation(value = "SaveBatchByPCMPROFILE", tags = {"TDZWXX" },  notes = "SaveBatchByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/tdzwxxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<TDZWXXDTO> tdzwxxdtos) {
        List<TDZWXX> domainlist=tdzwxxMapping.toDomain(tdzwxxdtos);
        for(TDZWXX domain:domainlist){
             domain.setPcmprofileid(pcmprofile_id);
        }
        tdzwxxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasPermission(#tdzwxx_id,'Update',{'Sql',this.tdzwxxMapping,#tdzwxxdto})")
    @ApiOperation(value = "UpdateByPCMPROFILE", tags = {"TDZWXX" },  notes = "UpdateByPCMPROFILE")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/tdzwxxes/{tdzwxx_id}")
    @Transactional
    public ResponseEntity<TDZWXXDTO> updateByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("tdzwxx_id") String tdzwxx_id, @RequestBody TDZWXXDTO tdzwxxdto) {
        TDZWXX domain = tdzwxxMapping.toDomain(tdzwxxdto);
        domain.setPcmprofileid(pcmprofile_id);
        domain.setTdzwxxid(tdzwxx_id);
		tdzwxxService.update(domain);
        TDZWXXDTO dto = tdzwxxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatchByPCMPROFILE", tags = {"TDZWXX" },  notes = "UpdateBatchByPCMPROFILE")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/tdzwxxes/batch")
    public ResponseEntity<Boolean> updateBatchByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<TDZWXXDTO> tdzwxxdtos) {
        List<TDZWXX> domainlist=tdzwxxMapping.toDomain(tdzwxxdtos);
        for(TDZWXX domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        tdzwxxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TDZWXX-CheckKey-all')")
    @ApiOperation(value = "CheckKeyByPCMPROFILE", tags = {"TDZWXX" },  notes = "CheckKeyByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/tdzwxxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody TDZWXXDTO tdzwxxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(tdzwxxService.checkKey(tdzwxxMapping.toDomain(tdzwxxdto)));
    }

    //@PreAuthorize("hasPermission(#tdzwxx_id,'Get',{'Sql',this.tdzwxxMapping,this.permissionDTO})")
    @ApiOperation(value = "GetByPCMPROFILE", tags = {"TDZWXX" },  notes = "GetByPCMPROFILE")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/tdzwxxes/{tdzwxx_id}")
    public ResponseEntity<TDZWXXDTO> getByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("tdzwxx_id") String tdzwxx_id) {
        TDZWXX domain = tdzwxxService.get(tdzwxx_id);
        TDZWXXDTO dto = tdzwxxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TDZWXX-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPCMPROFILE", tags = {"TDZWXX" } ,notes = "fetchDEFAULTByPCMPROFILE")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/{pcmprofile_id}/tdzwxxes/fetchdefault")
	public ResponseEntity<List<TDZWXXDTO>> fetchTDZWXXDefaultByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id,TDZWXXSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<TDZWXX> domains = tdzwxxService.searchDefault(context) ;
        List<TDZWXXDTO> list = tdzwxxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TDZWXX-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPCMPROFILE", tags = {"TDZWXX" } ,notes = "searchDEFAULTByPCMPROFILE")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/{pcmprofile_id}/tdzwxxes/searchdefault")
	public ResponseEntity<Page<TDZWXXDTO>> searchTDZWXXDefaultByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody TDZWXXSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<TDZWXX> domains = tdzwxxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(tdzwxxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


