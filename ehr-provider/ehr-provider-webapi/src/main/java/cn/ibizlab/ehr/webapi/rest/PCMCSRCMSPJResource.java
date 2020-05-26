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
import cn.ibizlab.ehr.core.pcm.domain.PCMCSRCMSPJ;
import cn.ibizlab.ehr.core.pcm.service.IPCMCSRCMSPJService;
import cn.ibizlab.ehr.core.pcm.filter.PCMCSRCMSPJSearchContext;

@Slf4j
@Api(tags = {"PCMCSRCMSPJ" })
@RestController("WebApi-pcmcsrcmspj")
@RequestMapping("")
public class PCMCSRCMSPJResource {

    @Autowired
    private IPCMCSRCMSPJService pcmcsrcmspjService;

    @Autowired
    @Lazy
    public PCMCSRCMSPJMapping pcmcsrcmspjMapping;

    public PCMCSRCMSPJDTO permissionDTO=new PCMCSRCMSPJDTO();

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pcmcsrcmspjMapping,#pcmcsrcmspjdto})")
    @ApiOperation(value = "Create", tags = {"PCMCSRCMSPJ" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmcsrcmspjs")
    @Transactional
    public ResponseEntity<PCMCSRCMSPJDTO> create(@RequestBody PCMCSRCMSPJDTO pcmcsrcmspjdto) {
        PCMCSRCMSPJ domain = pcmcsrcmspjMapping.toDomain(pcmcsrcmspjdto);
		pcmcsrcmspjService.create(domain);
        PCMCSRCMSPJDTO dto = pcmcsrcmspjMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.pcmcsrcmspjMapping,#pcmcsrcmspjdtos})")
    @ApiOperation(value = "createBatch", tags = {"PCMCSRCMSPJ" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmcsrcmspjs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMCSRCMSPJDTO> pcmcsrcmspjdtos) {
        pcmcsrcmspjService.createBatch(pcmcsrcmspjMapping.toDomain(pcmcsrcmspjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMCSRCMSPJ-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PCMCSRCMSPJ" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmcsrcmspjs/getdraft")
    public ResponseEntity<PCMCSRCMSPJDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmcsrcmspjMapping.toDto(pcmcsrcmspjService.getDraft(new PCMCSRCMSPJ())));
    }

    @PreAuthorize("hasPermission(#pcmcsrcmspj_id,'Remove',{'Sql',this.pcmcsrcmspjMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PCMCSRCMSPJ" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmcsrcmspjs/{pcmcsrcmspj_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmcsrcmspj_id") String pcmcsrcmspj_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmcsrcmspjService.remove(pcmcsrcmspj_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.pcmcsrcmspjMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PCMCSRCMSPJ" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmcsrcmspjs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmcsrcmspjService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pcmcsrcmspj_id,'Update',{'Sql',this.pcmcsrcmspjMapping,#pcmcsrcmspjdto})")
    @ApiOperation(value = "Update", tags = {"PCMCSRCMSPJ" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmcsrcmspjs/{pcmcsrcmspj_id}")
    @Transactional
    public ResponseEntity<PCMCSRCMSPJDTO> update(@PathVariable("pcmcsrcmspj_id") String pcmcsrcmspj_id, @RequestBody PCMCSRCMSPJDTO pcmcsrcmspjdto) {
		PCMCSRCMSPJ domain  = pcmcsrcmspjMapping.toDomain(pcmcsrcmspjdto);
        domain .setPcmcsrcmspjid(pcmcsrcmspj_id);
		pcmcsrcmspjService.update(domain );
		PCMCSRCMSPJDTO dto = pcmcsrcmspjMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.pcmcsrcmspjMapping,#pcmcsrcmspjdtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMCSRCMSPJ" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmcsrcmspjs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMCSRCMSPJDTO> pcmcsrcmspjdtos) {
        pcmcsrcmspjService.updateBatch(pcmcsrcmspjMapping.toDomain(pcmcsrcmspjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.pcmcsrcmspjMapping,#pcmcsrcmspjdto})")
    @ApiOperation(value = "Save", tags = {"PCMCSRCMSPJ" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmcsrcmspjs/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMCSRCMSPJDTO pcmcsrcmspjdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmcsrcmspjService.save(pcmcsrcmspjMapping.toDomain(pcmcsrcmspjdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.pcmcsrcmspjMapping,#pcmcsrcmspjdtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PCMCSRCMSPJ" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmcsrcmspjs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMCSRCMSPJDTO> pcmcsrcmspjdtos) {
        pcmcsrcmspjService.saveBatch(pcmcsrcmspjMapping.toDomain(pcmcsrcmspjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMCSRCMSPJ-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PCMCSRCMSPJ" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmcsrcmspjs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMCSRCMSPJDTO pcmcsrcmspjdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmcsrcmspjService.checkKey(pcmcsrcmspjMapping.toDomain(pcmcsrcmspjdto)));
    }

    @PreAuthorize("hasPermission(#pcmcsrcmspj_id,'Get',{'Sql',this.pcmcsrcmspjMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PCMCSRCMSPJ" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmcsrcmspjs/{pcmcsrcmspj_id}")
    public ResponseEntity<PCMCSRCMSPJDTO> get(@PathVariable("pcmcsrcmspj_id") String pcmcsrcmspj_id) {
        PCMCSRCMSPJ domain = pcmcsrcmspjService.get(pcmcsrcmspj_id);
        PCMCSRCMSPJDTO dto = pcmcsrcmspjMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMCSRCMSPJ-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMCSRCMSPJ" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmcsrcmspjs/fetchdefault")
	public ResponseEntity<List<PCMCSRCMSPJDTO>> fetchDefault(PCMCSRCMSPJSearchContext context) {
        Page<PCMCSRCMSPJ> domains = pcmcsrcmspjService.searchDefault(context) ;
        List<PCMCSRCMSPJDTO> list = pcmcsrcmspjMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMCSRCMSPJ-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMCSRCMSPJ" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmcsrcmspjs/searchdefault")
	public ResponseEntity<Page<PCMCSRCMSPJDTO>> searchDefault(@RequestBody PCMCSRCMSPJSearchContext context) {
        Page<PCMCSRCMSPJ> domains = pcmcsrcmspjService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmcsrcmspjMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
