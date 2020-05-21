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
import cn.ibizlab.ehr.core.pcm.domain.PCMPROFILEFJ;
import cn.ibizlab.ehr.core.pcm.service.IPCMPROFILEFJService;
import cn.ibizlab.ehr.core.pcm.filter.PCMPROFILEFJSearchContext;




@Slf4j
@Api(tags = {"PCMPROFILEFJ" })
@RestController("WebApi-pcmprofilefj")
@RequestMapping("")
public class PCMPROFILEFJResource {

    @Autowired
    private IPCMPROFILEFJService pcmprofilefjService;

    @Autowired
    @Lazy
    public PCMPROFILEFJMapping pcmprofilefjMapping;

    public PCMPROFILEFJDTO permissionDTO=new PCMPROFILEFJDTO();




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILEFJ-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PCMPROFILEFJ" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofilefjs/getdraft")
    public ResponseEntity<PCMPROFILEFJDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofilefjMapping.toDto(pcmprofilefjService.getDraft(new PCMPROFILEFJ())));
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILEFJ-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PCMPROFILEFJ" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofilefjs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMPROFILEFJDTO pcmprofilefjdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmprofilefjService.checkKey(pcmprofilefjMapping.toDomain(pcmprofilefjdto)));
    }




    @PreAuthorize("hasPermission(#pcmprofilefj_id,'Update',{'Sql',this.pcmprofilefjMapping,#pcmprofilefjdto})")
    @ApiOperation(value = "Update", tags = {"PCMPROFILEFJ" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofilefjs/{pcmprofilefj_id}")
    @Transactional
    public ResponseEntity<PCMPROFILEFJDTO> update(@PathVariable("pcmprofilefj_id") String pcmprofilefj_id, @RequestBody PCMPROFILEFJDTO pcmprofilefjdto) {
		PCMPROFILEFJ domain = pcmprofilefjMapping.toDomain(pcmprofilefjdto);
        domain.setPcmprofilefjid(pcmprofilefj_id);
		pcmprofilefjService.update(domain);
		PCMPROFILEFJDTO dto = pcmprofilefjMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"PCMPROFILEFJ" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofilefjs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMPROFILEFJDTO> pcmprofilefjdtos) {
        pcmprofilefjService.updateBatch(pcmprofilefjMapping.toDomain(pcmprofilefjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pcmprofilefj_id,'Remove',{'Sql',this.pcmprofilefjMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PCMPROFILEFJ" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofilefjs/{pcmprofilefj_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmprofilefj_id") String pcmprofilefj_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmprofilefjService.remove(pcmprofilefj_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PCMPROFILEFJ" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofilefjs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmprofilefjService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pcmprofilefj_id,'Get',{'Sql',this.pcmprofilefjMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PCMPROFILEFJ" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofilefjs/{pcmprofilefj_id}")
    public ResponseEntity<PCMPROFILEFJDTO> get(@PathVariable("pcmprofilefj_id") String pcmprofilefj_id) {
        PCMPROFILEFJ domain = pcmprofilefjService.get(pcmprofilefj_id);
        PCMPROFILEFJDTO dto = pcmprofilefjMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILEFJ-Save-all')")
    @ApiOperation(value = "Save", tags = {"PCMPROFILEFJ" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofilefjs/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMPROFILEFJDTO pcmprofilefjdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofilefjService.save(pcmprofilefjMapping.toDomain(pcmprofilefjdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PCMPROFILEFJ" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofilefjs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMPROFILEFJDTO> pcmprofilefjdtos) {
        pcmprofilefjService.saveBatch(pcmprofilefjMapping.toDomain(pcmprofilefjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.pcmprofilefjMapping,#pcmprofilefjdto})")
    @ApiOperation(value = "Create", tags = {"PCMPROFILEFJ" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofilefjs")
    @Transactional
    public ResponseEntity<PCMPROFILEFJDTO> create(@RequestBody PCMPROFILEFJDTO pcmprofilefjdto) {
        PCMPROFILEFJ domain = pcmprofilefjMapping.toDomain(pcmprofilefjdto);
		pcmprofilefjService.create(domain);
        PCMPROFILEFJDTO dto = pcmprofilefjMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"PCMPROFILEFJ" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofilefjs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMPROFILEFJDTO> pcmprofilefjdtos) {
        pcmprofilefjService.createBatch(pcmprofilefjMapping.toDomain(pcmprofilefjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILEFJ-PROFILEFJ-all')")
	@ApiOperation(value = "fetch应聘者附件", tags = {"PCMPROFILEFJ" } ,notes = "fetch应聘者附件")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofilefjs/fetchprofilefj")
	public ResponseEntity<List<PCMPROFILEFJDTO>> fetchPROFILEFJ(PCMPROFILEFJSearchContext context) {
        Page<PCMPROFILEFJ> domains = pcmprofilefjService.searchPROFILEFJ(context) ;
        List<PCMPROFILEFJDTO> list = pcmprofilefjMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILEFJ-PROFILEFJ-all')")
	@ApiOperation(value = "search应聘者附件", tags = {"PCMPROFILEFJ" } ,notes = "search应聘者附件")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofilefjs/searchprofilefj")
	public ResponseEntity<Page<PCMPROFILEFJDTO>> searchPROFILEFJ(@RequestBody PCMPROFILEFJSearchContext context) {
        Page<PCMPROFILEFJ> domains = pcmprofilefjService.searchPROFILEFJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofilefjMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILEFJ-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMPROFILEFJ" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofilefjs/fetchdefault")
	public ResponseEntity<List<PCMPROFILEFJDTO>> fetchDefault(PCMPROFILEFJSearchContext context) {
        Page<PCMPROFILEFJ> domains = pcmprofilefjService.searchDefault(context) ;
        List<PCMPROFILEFJDTO> list = pcmprofilefjMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILEFJ-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMPROFILEFJ" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofilefjs/searchdefault")
	public ResponseEntity<Page<PCMPROFILEFJDTO>> searchDefault(@RequestBody PCMPROFILEFJSearchContext context) {
        Page<PCMPROFILEFJ> domains = pcmprofilefjService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofilefjMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


