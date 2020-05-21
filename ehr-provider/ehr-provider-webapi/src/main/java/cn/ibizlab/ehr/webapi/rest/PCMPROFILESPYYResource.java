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
import cn.ibizlab.ehr.core.pcm.domain.PCMPROFILESPYY;
import cn.ibizlab.ehr.core.pcm.service.IPCMPROFILESPYYService;
import cn.ibizlab.ehr.core.pcm.filter.PCMPROFILESPYYSearchContext;




@Slf4j
@Api(tags = {"PCMPROFILESPYY" })
@RestController("WebApi-pcmprofilespyy")
@RequestMapping("")
public class PCMPROFILESPYYResource {

    @Autowired
    private IPCMPROFILESPYYService pcmprofilespyyService;

    @Autowired
    @Lazy
    public PCMPROFILESPYYMapping pcmprofilespyyMapping;

    public PCMPROFILESPYYDTO permissionDTO=new PCMPROFILESPYYDTO();




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILESPYY-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PCMPROFILESPYY" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofilespyys/getdraft")
    public ResponseEntity<PCMPROFILESPYYDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofilespyyMapping.toDto(pcmprofilespyyService.getDraft(new PCMPROFILESPYY())));
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILESPYY-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PCMPROFILESPYY" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofilespyys/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMPROFILESPYYDTO pcmprofilespyydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmprofilespyyService.checkKey(pcmprofilespyyMapping.toDomain(pcmprofilespyydto)));
    }




    @PreAuthorize("hasPermission(#pcmprofilespyy_id,'Get',{'Sql',this.pcmprofilespyyMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PCMPROFILESPYY" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofilespyys/{pcmprofilespyy_id}")
    public ResponseEntity<PCMPROFILESPYYDTO> get(@PathVariable("pcmprofilespyy_id") String pcmprofilespyy_id) {
        PCMPROFILESPYY domain = pcmprofilespyyService.get(pcmprofilespyy_id);
        PCMPROFILESPYYDTO dto = pcmprofilespyyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILESPYY-Save-all')")
    @ApiOperation(value = "Save", tags = {"PCMPROFILESPYY" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofilespyys/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMPROFILESPYYDTO pcmprofilespyydto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofilespyyService.save(pcmprofilespyyMapping.toDomain(pcmprofilespyydto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PCMPROFILESPYY" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofilespyys/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMPROFILESPYYDTO> pcmprofilespyydtos) {
        pcmprofilespyyService.saveBatch(pcmprofilespyyMapping.toDomain(pcmprofilespyydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.pcmprofilespyyMapping,#pcmprofilespyydto})")
    @ApiOperation(value = "Create", tags = {"PCMPROFILESPYY" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofilespyys")
    @Transactional
    public ResponseEntity<PCMPROFILESPYYDTO> create(@RequestBody PCMPROFILESPYYDTO pcmprofilespyydto) {
        PCMPROFILESPYY domain = pcmprofilespyyMapping.toDomain(pcmprofilespyydto);
		pcmprofilespyyService.create(domain);
        PCMPROFILESPYYDTO dto = pcmprofilespyyMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"PCMPROFILESPYY" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofilespyys/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMPROFILESPYYDTO> pcmprofilespyydtos) {
        pcmprofilespyyService.createBatch(pcmprofilespyyMapping.toDomain(pcmprofilespyydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pcmprofilespyy_id,'Update',{'Sql',this.pcmprofilespyyMapping,#pcmprofilespyydto})")
    @ApiOperation(value = "Update", tags = {"PCMPROFILESPYY" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofilespyys/{pcmprofilespyy_id}")
    @Transactional
    public ResponseEntity<PCMPROFILESPYYDTO> update(@PathVariable("pcmprofilespyy_id") String pcmprofilespyy_id, @RequestBody PCMPROFILESPYYDTO pcmprofilespyydto) {
		PCMPROFILESPYY domain = pcmprofilespyyMapping.toDomain(pcmprofilespyydto);
        domain.setPcmprofilespyyid(pcmprofilespyy_id);
		pcmprofilespyyService.update(domain);
		PCMPROFILESPYYDTO dto = pcmprofilespyyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"PCMPROFILESPYY" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofilespyys/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMPROFILESPYYDTO> pcmprofilespyydtos) {
        pcmprofilespyyService.updateBatch(pcmprofilespyyMapping.toDomain(pcmprofilespyydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pcmprofilespyy_id,'Remove',{'Sql',this.pcmprofilespyyMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PCMPROFILESPYY" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofilespyys/{pcmprofilespyy_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmprofilespyy_id") String pcmprofilespyy_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmprofilespyyService.remove(pcmprofilespyy_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PCMPROFILESPYY" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofilespyys/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmprofilespyyService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILESPYY-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMPROFILESPYY" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofilespyys/fetchdefault")
	public ResponseEntity<List<PCMPROFILESPYYDTO>> fetchDefault(PCMPROFILESPYYSearchContext context) {
        Page<PCMPROFILESPYY> domains = pcmprofilespyyService.searchDefault(context) ;
        List<PCMPROFILESPYYDTO> list = pcmprofilespyyMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILESPYY-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMPROFILESPYY" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofilespyys/searchdefault")
	public ResponseEntity<Page<PCMPROFILESPYYDTO>> searchDefault(@RequestBody PCMPROFILESPYYSearchContext context) {
        Page<PCMPROFILESPYY> domains = pcmprofilespyyService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofilespyyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


