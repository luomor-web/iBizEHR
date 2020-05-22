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
import cn.ibizlab.ehr.core.pcm.domain.PCMJXSZZKHJGJL;
import cn.ibizlab.ehr.core.pcm.service.IPCMJXSZZKHJGJLService;
import cn.ibizlab.ehr.core.pcm.filter.PCMJXSZZKHJGJLSearchContext;




@Slf4j
@Api(tags = {"PCMJXSZZKHJGJL" })
@RestController("WebApi-pcmjxszzkhjgjl")
@RequestMapping("")
public class PCMJXSZZKHJGJLResource {

    @Autowired
    private IPCMJXSZZKHJGJLService pcmjxszzkhjgjlService;

    @Autowired
    @Lazy
    public PCMJXSZZKHJGJLMapping pcmjxszzkhjgjlMapping;

    public PCMJXSZZKHJGJLDTO permissionDTO=new PCMJXSZZKHJGJLDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMJXSZZKHJGJL-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PCMJXSZZKHJGJL" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxszzkhjgjls/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMJXSZZKHJGJLDTO pcmjxszzkhjgjldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmjxszzkhjgjlService.checkKey(pcmjxszzkhjgjlMapping.toDomain(pcmjxszzkhjgjldto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMJXSZZKHJGJL-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PCMJXSZZKHJGJL" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmjxszzkhjgjls/getdraft")
    public ResponseEntity<PCMJXSZZKHJGJLDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxszzkhjgjlMapping.toDto(pcmjxszzkhjgjlService.getDraft(new PCMJXSZZKHJGJL())));
    }

    @PreAuthorize("hasPermission(#pcmjxszzkhjgjl_id,'Remove',{'Sql',this.pcmjxszzkhjgjlMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PCMJXSZZKHJGJL" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmjxszzkhjgjls/{pcmjxszzkhjgjl_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmjxszzkhjgjl_id") String pcmjxszzkhjgjl_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmjxszzkhjgjlService.remove(pcmjxszzkhjgjl_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PCMJXSZZKHJGJL" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmjxszzkhjgjls/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmjxszzkhjgjlService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pcmjxszzkhjgjl_id,'Get',{'Sql',this.pcmjxszzkhjgjlMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PCMJXSZZKHJGJL" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmjxszzkhjgjls/{pcmjxszzkhjgjl_id}")
    public ResponseEntity<PCMJXSZZKHJGJLDTO> get(@PathVariable("pcmjxszzkhjgjl_id") String pcmjxszzkhjgjl_id) {
        PCMJXSZZKHJGJL domain = pcmjxszzkhjgjlService.get(pcmjxszzkhjgjl_id);
        PCMJXSZZKHJGJLDTO dto = pcmjxszzkhjgjlMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pcmjxszzkhjgjlMapping,#pcmjxszzkhjgjldto})")
    @ApiOperation(value = "Create", tags = {"PCMJXSZZKHJGJL" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxszzkhjgjls")
    @Transactional
    public ResponseEntity<PCMJXSZZKHJGJLDTO> create(@RequestBody PCMJXSZZKHJGJLDTO pcmjxszzkhjgjldto) {
        PCMJXSZZKHJGJL domain = pcmjxszzkhjgjlMapping.toDomain(pcmjxszzkhjgjldto);
		pcmjxszzkhjgjlService.create(domain);
        PCMJXSZZKHJGJLDTO dto = pcmjxszzkhjgjlMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"PCMJXSZZKHJGJL" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxszzkhjgjls/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMJXSZZKHJGJLDTO> pcmjxszzkhjgjldtos) {
        pcmjxszzkhjgjlService.createBatch(pcmjxszzkhjgjlMapping.toDomain(pcmjxszzkhjgjldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pcmjxszzkhjgjl_id,'Update',{'Sql',this.pcmjxszzkhjgjlMapping,#pcmjxszzkhjgjldto})")
    @ApiOperation(value = "Update", tags = {"PCMJXSZZKHJGJL" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmjxszzkhjgjls/{pcmjxszzkhjgjl_id}")
    @Transactional
    public ResponseEntity<PCMJXSZZKHJGJLDTO> update(@PathVariable("pcmjxszzkhjgjl_id") String pcmjxszzkhjgjl_id, @RequestBody PCMJXSZZKHJGJLDTO pcmjxszzkhjgjldto) {
		PCMJXSZZKHJGJL domain = pcmjxszzkhjgjlMapping.toDomain(pcmjxszzkhjgjldto);
        domain.setPcmjxszzkhjgjlid(pcmjxszzkhjgjl_id);
		pcmjxszzkhjgjlService.update(domain);
		PCMJXSZZKHJGJLDTO dto = pcmjxszzkhjgjlMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMJXSZZKHJGJL" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmjxszzkhjgjls/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMJXSZZKHJGJLDTO> pcmjxszzkhjgjldtos) {
        pcmjxszzkhjgjlService.updateBatch(pcmjxszzkhjgjlMapping.toDomain(pcmjxszzkhjgjldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMJXSZZKHJGJL-Save-all')")
    @ApiOperation(value = "Save", tags = {"PCMJXSZZKHJGJL" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxszzkhjgjls/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMJXSZZKHJGJLDTO pcmjxszzkhjgjldto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxszzkhjgjlService.save(pcmjxszzkhjgjlMapping.toDomain(pcmjxszzkhjgjldto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PCMJXSZZKHJGJL" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxszzkhjgjls/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMJXSZZKHJGJLDTO> pcmjxszzkhjgjldtos) {
        pcmjxszzkhjgjlService.saveBatch(pcmjxszzkhjgjlMapping.toDomain(pcmjxszzkhjgjldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMJXSZZKHJGJL-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMJXSZZKHJGJL" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmjxszzkhjgjls/fetchdefault")
	public ResponseEntity<List<PCMJXSZZKHJGJLDTO>> fetchDefault(PCMJXSZZKHJGJLSearchContext context) {
        Page<PCMJXSZZKHJGJL> domains = pcmjxszzkhjgjlService.searchDefault(context) ;
        List<PCMJXSZZKHJGJLDTO> list = pcmjxszzkhjgjlMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMJXSZZKHJGJL-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMJXSZZKHJGJL" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmjxszzkhjgjls/searchdefault")
	public ResponseEntity<Page<PCMJXSZZKHJGJLDTO>> searchDefault(@RequestBody PCMJXSZZKHJGJLSearchContext context) {
        Page<PCMJXSZZKHJGJL> domains = pcmjxszzkhjgjlService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmjxszzkhjgjlMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
