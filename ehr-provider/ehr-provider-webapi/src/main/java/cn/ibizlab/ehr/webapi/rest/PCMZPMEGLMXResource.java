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
import cn.ibizlab.ehr.core.pcm.domain.PCMZPMEGLMX;
import cn.ibizlab.ehr.core.pcm.service.IPCMZPMEGLMXService;
import cn.ibizlab.ehr.core.pcm.filter.PCMZPMEGLMXSearchContext;




@Slf4j
@Api(tags = {"PCMZPMEGLMX" })
@RestController("WebApi-pcmzpmeglmx")
@RequestMapping("")
public class PCMZPMEGLMXResource {

    @Autowired
    private IPCMZPMEGLMXService pcmzpmeglmxService;

    @Autowired
    @Lazy
    public PCMZPMEGLMXMapping pcmzpmeglmxMapping;

    public PCMZPMEGLMXDTO permissionDTO=new PCMZPMEGLMXDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMZPMEGLMX-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PCMZPMEGLMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzpmeglmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMZPMEGLMXDTO pcmzpmeglmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmzpmeglmxService.checkKey(pcmzpmeglmxMapping.toDomain(pcmzpmeglmxdto)));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pcmzpmeglmxMapping,#pcmzpmeglmxdto})")
    @ApiOperation(value = "Create", tags = {"PCMZPMEGLMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzpmeglmxes")
    @Transactional
    public ResponseEntity<PCMZPMEGLMXDTO> create(@RequestBody PCMZPMEGLMXDTO pcmzpmeglmxdto) {
        PCMZPMEGLMX domain = pcmzpmeglmxMapping.toDomain(pcmzpmeglmxdto);
		pcmzpmeglmxService.create(domain);
        PCMZPMEGLMXDTO dto = pcmzpmeglmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"PCMZPMEGLMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzpmeglmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMZPMEGLMXDTO> pcmzpmeglmxdtos) {
        pcmzpmeglmxService.createBatch(pcmzpmeglmxMapping.toDomain(pcmzpmeglmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pcmzpmeglmx_id,'Get',{'Sql',this.pcmzpmeglmxMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PCMZPMEGLMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmzpmeglmxes/{pcmzpmeglmx_id}")
    public ResponseEntity<PCMZPMEGLMXDTO> get(@PathVariable("pcmzpmeglmx_id") String pcmzpmeglmx_id) {
        PCMZPMEGLMX domain = pcmzpmeglmxService.get(pcmzpmeglmx_id);
        PCMZPMEGLMXDTO dto = pcmzpmeglmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMZPMEGLMX-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PCMZPMEGLMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmzpmeglmxes/getdraft")
    public ResponseEntity<PCMZPMEGLMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmzpmeglmxMapping.toDto(pcmzpmeglmxService.getDraft(new PCMZPMEGLMX())));
    }

    @PreAuthorize("hasPermission(#pcmzpmeglmx_id,'Update',{'Sql',this.pcmzpmeglmxMapping,#pcmzpmeglmxdto})")
    @ApiOperation(value = "Update", tags = {"PCMZPMEGLMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmzpmeglmxes/{pcmzpmeglmx_id}")
    @Transactional
    public ResponseEntity<PCMZPMEGLMXDTO> update(@PathVariable("pcmzpmeglmx_id") String pcmzpmeglmx_id, @RequestBody PCMZPMEGLMXDTO pcmzpmeglmxdto) {
		PCMZPMEGLMX domain = pcmzpmeglmxMapping.toDomain(pcmzpmeglmxdto);
        domain.setPcmzpmeglmxid(pcmzpmeglmx_id);
		pcmzpmeglmxService.update(domain);
		PCMZPMEGLMXDTO dto = pcmzpmeglmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMZPMEGLMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmzpmeglmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMZPMEGLMXDTO> pcmzpmeglmxdtos) {
        pcmzpmeglmxService.updateBatch(pcmzpmeglmxMapping.toDomain(pcmzpmeglmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMZPMEGLMX-Save-all')")
    @ApiOperation(value = "Save", tags = {"PCMZPMEGLMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzpmeglmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMZPMEGLMXDTO pcmzpmeglmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmzpmeglmxService.save(pcmzpmeglmxMapping.toDomain(pcmzpmeglmxdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PCMZPMEGLMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzpmeglmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMZPMEGLMXDTO> pcmzpmeglmxdtos) {
        pcmzpmeglmxService.saveBatch(pcmzpmeglmxMapping.toDomain(pcmzpmeglmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pcmzpmeglmx_id,'Remove',{'Sql',this.pcmzpmeglmxMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PCMZPMEGLMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmzpmeglmxes/{pcmzpmeglmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmzpmeglmx_id") String pcmzpmeglmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmzpmeglmxService.remove(pcmzpmeglmx_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PCMZPMEGLMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmzpmeglmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmzpmeglmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMZPMEGLMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMZPMEGLMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmzpmeglmxes/fetchdefault")
	public ResponseEntity<List<PCMZPMEGLMXDTO>> fetchDefault(PCMZPMEGLMXSearchContext context) {
        Page<PCMZPMEGLMX> domains = pcmzpmeglmxService.searchDefault(context) ;
        List<PCMZPMEGLMXDTO> list = pcmzpmeglmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMZPMEGLMX-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMZPMEGLMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmzpmeglmxes/searchdefault")
	public ResponseEntity<Page<PCMZPMEGLMXDTO>> searchDefault(@RequestBody PCMZPMEGLMXSearchContext context) {
        Page<PCMZPMEGLMX> domains = pcmzpmeglmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmzpmeglmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
