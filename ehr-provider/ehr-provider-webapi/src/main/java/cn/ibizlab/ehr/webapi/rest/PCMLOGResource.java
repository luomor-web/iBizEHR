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
import cn.ibizlab.ehr.core.pcm.domain.PCMLOG;
import cn.ibizlab.ehr.core.pcm.service.IPCMLOGService;
import cn.ibizlab.ehr.core.pcm.filter.PCMLOGSearchContext;




@Slf4j
@Api(tags = {"PCMLOG" })
@RestController("WebApi-pcmlog")
@RequestMapping("")
public class PCMLOGResource {

    @Autowired
    private IPCMLOGService pcmlogService;

    @Autowired
    @Lazy
    public PCMLOGMapping pcmlogMapping;

    public PCMLOGDTO permissionDTO=new PCMLOGDTO();

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pcmlogMapping,#pcmlogdto})")
    @ApiOperation(value = "Create", tags = {"PCMLOG" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmlogs")
    @Transactional
    public ResponseEntity<PCMLOGDTO> create(@RequestBody PCMLOGDTO pcmlogdto) {
        PCMLOG domain = pcmlogMapping.toDomain(pcmlogdto);
		pcmlogService.create(domain);
        PCMLOGDTO dto = pcmlogMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"PCMLOG" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmlogs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMLOGDTO> pcmlogdtos) {
        pcmlogService.createBatch(pcmlogMapping.toDomain(pcmlogdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pcmlog_id,'Update',{'Sql',this.pcmlogMapping,#pcmlogdto})")
    @ApiOperation(value = "Update", tags = {"PCMLOG" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmlogs/{pcmlog_id}")
    @Transactional
    public ResponseEntity<PCMLOGDTO> update(@PathVariable("pcmlog_id") String pcmlog_id, @RequestBody PCMLOGDTO pcmlogdto) {
		PCMLOG domain = pcmlogMapping.toDomain(pcmlogdto);
        domain.setPcmlogid(pcmlog_id);
		pcmlogService.update(domain);
		PCMLOGDTO dto = pcmlogMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMLOG" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmlogs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMLOGDTO> pcmlogdtos) {
        pcmlogService.updateBatch(pcmlogMapping.toDomain(pcmlogdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pcmlog_id,'Remove',{'Sql',this.pcmlogMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PCMLOG" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmlogs/{pcmlog_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmlog_id") String pcmlog_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmlogService.remove(pcmlog_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PCMLOG" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmlogs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmlogService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMLOG-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PCMLOG" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmlogs/getdraft")
    public ResponseEntity<PCMLOGDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmlogMapping.toDto(pcmlogService.getDraft(new PCMLOG())));
    }

    @PreAuthorize("hasPermission(#pcmlog_id,'Get',{'Sql',this.pcmlogMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PCMLOG" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmlogs/{pcmlog_id}")
    public ResponseEntity<PCMLOGDTO> get(@PathVariable("pcmlog_id") String pcmlog_id) {
        PCMLOG domain = pcmlogService.get(pcmlog_id);
        PCMLOGDTO dto = pcmlogMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMLOG-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PCMLOG" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmlogs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMLOGDTO pcmlogdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmlogService.checkKey(pcmlogMapping.toDomain(pcmlogdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMLOG-Save-all')")
    @ApiOperation(value = "Save", tags = {"PCMLOG" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmlogs/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMLOGDTO pcmlogdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmlogService.save(pcmlogMapping.toDomain(pcmlogdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PCMLOG" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmlogs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMLOGDTO> pcmlogdtos) {
        pcmlogService.saveBatch(pcmlogMapping.toDomain(pcmlogdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMLOG-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMLOG" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmlogs/fetchdefault")
	public ResponseEntity<List<PCMLOGDTO>> fetchDefault(PCMLOGSearchContext context) {
        Page<PCMLOG> domains = pcmlogService.searchDefault(context) ;
        List<PCMLOGDTO> list = pcmlogMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMLOG-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMLOG" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmlogs/searchdefault")
	public ResponseEntity<Page<PCMLOGDTO>> searchDefault(@RequestBody PCMLOGSearchContext context) {
        Page<PCMLOG> domains = pcmlogService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmlogMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
