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
import cn.ibizlab.ehr.core.pcm.domain.PCMPROFILENUMBEPREFIX;
import cn.ibizlab.ehr.core.pcm.service.IPCMPROFILENUMBEPREFIXService;
import cn.ibizlab.ehr.core.pcm.filter.PCMPROFILENUMBEPREFIXSearchContext;

@Slf4j
@Api(tags = {"PCMPROFILENUMBEPREFIX" })
@RestController("WebApi-pcmprofilenumbeprefix")
@RequestMapping("")
public class PCMPROFILENUMBEPREFIXResource {

    @Autowired
    private IPCMPROFILENUMBEPREFIXService pcmprofilenumbeprefixService;

    @Autowired
    @Lazy
    public PCMPROFILENUMBEPREFIXMapping pcmprofilenumbeprefixMapping;

    public PCMPROFILENUMBEPREFIXDTO permissionDTO=new PCMPROFILENUMBEPREFIXDTO();

    @PreAuthorize("hasPermission(#pcmprofilenumbeprefix_id,'Get',{'Sql',this.pcmprofilenumbeprefixMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PCMPROFILENUMBEPREFIX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofilenumbeprefixes/{pcmprofilenumbeprefix_id}")
    public ResponseEntity<PCMPROFILENUMBEPREFIXDTO> get(@PathVariable("pcmprofilenumbeprefix_id") String pcmprofilenumbeprefix_id) {
        PCMPROFILENUMBEPREFIX domain = pcmprofilenumbeprefixService.get(pcmprofilenumbeprefix_id);
        PCMPROFILENUMBEPREFIXDTO dto = pcmprofilenumbeprefixMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.pcmprofilenumbeprefixMapping,#pcmprofilenumbeprefixdto})")
    @ApiOperation(value = "Save", tags = {"PCMPROFILENUMBEPREFIX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofilenumbeprefixes/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMPROFILENUMBEPREFIXDTO pcmprofilenumbeprefixdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofilenumbeprefixService.save(pcmprofilenumbeprefixMapping.toDomain(pcmprofilenumbeprefixdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PCMPROFILENUMBEPREFIX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofilenumbeprefixes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMPROFILENUMBEPREFIXDTO> pcmprofilenumbeprefixdtos) {
        pcmprofilenumbeprefixService.saveBatch(pcmprofilenumbeprefixMapping.toDomain(pcmprofilenumbeprefixdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pcmprofilenumbeprefix_id,'Update',{'Sql',this.pcmprofilenumbeprefixMapping,#pcmprofilenumbeprefixdto})")
    @ApiOperation(value = "Update", tags = {"PCMPROFILENUMBEPREFIX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofilenumbeprefixes/{pcmprofilenumbeprefix_id}")
    @Transactional
    public ResponseEntity<PCMPROFILENUMBEPREFIXDTO> update(@PathVariable("pcmprofilenumbeprefix_id") String pcmprofilenumbeprefix_id, @RequestBody PCMPROFILENUMBEPREFIXDTO pcmprofilenumbeprefixdto) {
		PCMPROFILENUMBEPREFIX domain = pcmprofilenumbeprefixMapping.toDomain(pcmprofilenumbeprefixdto);
        domain.setPcmprofilenumbeprefixid(pcmprofilenumbeprefix_id);
		pcmprofilenumbeprefixService.update(domain);
		PCMPROFILENUMBEPREFIXDTO dto = pcmprofilenumbeprefixMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMPROFILENUMBEPREFIX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofilenumbeprefixes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMPROFILENUMBEPREFIXDTO> pcmprofilenumbeprefixdtos) {
        pcmprofilenumbeprefixService.updateBatch(pcmprofilenumbeprefixMapping.toDomain(pcmprofilenumbeprefixdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pcmprofilenumbeprefixMapping,#pcmprofilenumbeprefixdto})")
    @ApiOperation(value = "Create", tags = {"PCMPROFILENUMBEPREFIX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofilenumbeprefixes")
    @Transactional
    public ResponseEntity<PCMPROFILENUMBEPREFIXDTO> create(@RequestBody PCMPROFILENUMBEPREFIXDTO pcmprofilenumbeprefixdto) {
        PCMPROFILENUMBEPREFIX domain = pcmprofilenumbeprefixMapping.toDomain(pcmprofilenumbeprefixdto);
		pcmprofilenumbeprefixService.create(domain);
        PCMPROFILENUMBEPREFIXDTO dto = pcmprofilenumbeprefixMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"PCMPROFILENUMBEPREFIX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofilenumbeprefixes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMPROFILENUMBEPREFIXDTO> pcmprofilenumbeprefixdtos) {
        pcmprofilenumbeprefixService.createBatch(pcmprofilenumbeprefixMapping.toDomain(pcmprofilenumbeprefixdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILENUMBEPREFIX-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PCMPROFILENUMBEPREFIX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofilenumbeprefixes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMPROFILENUMBEPREFIXDTO pcmprofilenumbeprefixdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmprofilenumbeprefixService.checkKey(pcmprofilenumbeprefixMapping.toDomain(pcmprofilenumbeprefixdto)));
    }

    @PreAuthorize("hasPermission(#pcmprofilenumbeprefix_id,'Remove',{'Sql',this.pcmprofilenumbeprefixMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PCMPROFILENUMBEPREFIX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofilenumbeprefixes/{pcmprofilenumbeprefix_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmprofilenumbeprefix_id") String pcmprofilenumbeprefix_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmprofilenumbeprefixService.remove(pcmprofilenumbeprefix_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PCMPROFILENUMBEPREFIX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofilenumbeprefixes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmprofilenumbeprefixService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILENUMBEPREFIX-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PCMPROFILENUMBEPREFIX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofilenumbeprefixes/getdraft")
    public ResponseEntity<PCMPROFILENUMBEPREFIXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofilenumbeprefixMapping.toDto(pcmprofilenumbeprefixService.getDraft(new PCMPROFILENUMBEPREFIX())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILENUMBEPREFIX-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMPROFILENUMBEPREFIX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofilenumbeprefixes/fetchdefault")
	public ResponseEntity<List<PCMPROFILENUMBEPREFIXDTO>> fetchDefault(PCMPROFILENUMBEPREFIXSearchContext context) {
        Page<PCMPROFILENUMBEPREFIX> domains = pcmprofilenumbeprefixService.searchDefault(context) ;
        List<PCMPROFILENUMBEPREFIXDTO> list = pcmprofilenumbeprefixMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILENUMBEPREFIX-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMPROFILENUMBEPREFIX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofilenumbeprefixes/searchdefault")
	public ResponseEntity<Page<PCMPROFILENUMBEPREFIXDTO>> searchDefault(@RequestBody PCMPROFILENUMBEPREFIXSearchContext context) {
        Page<PCMPROFILENUMBEPREFIX> domains = pcmprofilenumbeprefixService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofilenumbeprefixMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
