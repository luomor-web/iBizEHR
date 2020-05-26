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
import cn.ibizlab.ehr.core.pcm.domain.PCMMSPJXX;
import cn.ibizlab.ehr.core.pcm.service.IPCMMSPJXXService;
import cn.ibizlab.ehr.core.pcm.filter.PCMMSPJXXSearchContext;

@Slf4j
@Api(tags = {"PCMMSPJXX" })
@RestController("WebApi-pcmmspjxx")
@RequestMapping("")
public class PCMMSPJXXResource {

    @Autowired
    private IPCMMSPJXXService pcmmspjxxService;

    @Autowired
    @Lazy
    public PCMMSPJXXMapping pcmmspjxxMapping;

    public PCMMSPJXXDTO permissionDTO=new PCMMSPJXXDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMMSPJXX-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PCMMSPJXX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmmspjxxes/getdraft")
    public ResponseEntity<PCMMSPJXXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmmspjxxMapping.toDto(pcmmspjxxService.getDraft(new PCMMSPJXX())));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pcmmspjxxMapping,#pcmmspjxxdto})")
    @ApiOperation(value = "Create", tags = {"PCMMSPJXX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmmspjxxes")
    @Transactional
    public ResponseEntity<PCMMSPJXXDTO> create(@RequestBody PCMMSPJXXDTO pcmmspjxxdto) {
        PCMMSPJXX domain = pcmmspjxxMapping.toDomain(pcmmspjxxdto);
		pcmmspjxxService.create(domain);
        PCMMSPJXXDTO dto = pcmmspjxxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.pcmmspjxxMapping,#pcmmspjxxdtos})")
    @ApiOperation(value = "createBatch", tags = {"PCMMSPJXX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmmspjxxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMMSPJXXDTO> pcmmspjxxdtos) {
        pcmmspjxxService.createBatch(pcmmspjxxMapping.toDomain(pcmmspjxxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMMSPJXX-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PCMMSPJXX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmmspjxxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMMSPJXXDTO pcmmspjxxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmmspjxxService.checkKey(pcmmspjxxMapping.toDomain(pcmmspjxxdto)));
    }

    @PreAuthorize("hasPermission(#pcmmspjxx_id,'Remove',{'Sql',this.pcmmspjxxMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PCMMSPJXX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmmspjxxes/{pcmmspjxx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmmspjxx_id") String pcmmspjxx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmmspjxxService.remove(pcmmspjxx_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.pcmmspjxxMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PCMMSPJXX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmmspjxxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmmspjxxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pcmmspjxx_id,'Get',{'Sql',this.pcmmspjxxMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PCMMSPJXX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmmspjxxes/{pcmmspjxx_id}")
    public ResponseEntity<PCMMSPJXXDTO> get(@PathVariable("pcmmspjxx_id") String pcmmspjxx_id) {
        PCMMSPJXX domain = pcmmspjxxService.get(pcmmspjxx_id);
        PCMMSPJXXDTO dto = pcmmspjxxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.pcmmspjxxMapping,#pcmmspjxxdto})")
    @ApiOperation(value = "Save", tags = {"PCMMSPJXX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmmspjxxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMMSPJXXDTO pcmmspjxxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmmspjxxService.save(pcmmspjxxMapping.toDomain(pcmmspjxxdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.pcmmspjxxMapping,#pcmmspjxxdtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PCMMSPJXX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmmspjxxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMMSPJXXDTO> pcmmspjxxdtos) {
        pcmmspjxxService.saveBatch(pcmmspjxxMapping.toDomain(pcmmspjxxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pcmmspjxx_id,'Update',{'Sql',this.pcmmspjxxMapping,#pcmmspjxxdto})")
    @ApiOperation(value = "Update", tags = {"PCMMSPJXX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmmspjxxes/{pcmmspjxx_id}")
    @Transactional
    public ResponseEntity<PCMMSPJXXDTO> update(@PathVariable("pcmmspjxx_id") String pcmmspjxx_id, @RequestBody PCMMSPJXXDTO pcmmspjxxdto) {
		PCMMSPJXX domain  = pcmmspjxxMapping.toDomain(pcmmspjxxdto);
        domain .setPcmmspjxxid(pcmmspjxx_id);
		pcmmspjxxService.update(domain );
		PCMMSPJXXDTO dto = pcmmspjxxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.pcmmspjxxMapping,#pcmmspjxxdtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMMSPJXX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmmspjxxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMMSPJXXDTO> pcmmspjxxdtos) {
        pcmmspjxxService.updateBatch(pcmmspjxxMapping.toDomain(pcmmspjxxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMMSPJXX-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMMSPJXX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmmspjxxes/fetchdefault")
	public ResponseEntity<List<PCMMSPJXXDTO>> fetchDefault(PCMMSPJXXSearchContext context) {
        Page<PCMMSPJXX> domains = pcmmspjxxService.searchDefault(context) ;
        List<PCMMSPJXXDTO> list = pcmmspjxxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMMSPJXX-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMMSPJXX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmmspjxxes/searchdefault")
	public ResponseEntity<Page<PCMMSPJXXDTO>> searchDefault(@RequestBody PCMMSPJXXSearchContext context) {
        Page<PCMMSPJXX> domains = pcmmspjxxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmmspjxxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
