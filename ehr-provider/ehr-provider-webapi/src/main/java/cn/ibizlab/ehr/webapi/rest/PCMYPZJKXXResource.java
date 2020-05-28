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
import org.springframework.security.access.prepost.PostAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import cn.ibizlab.ehr.webapi.dto.*;
import cn.ibizlab.ehr.webapi.mapping.*;
import cn.ibizlab.ehr.core.pcm.domain.PCMYPZJKXX;
import cn.ibizlab.ehr.core.pcm.service.IPCMYPZJKXXService;
import cn.ibizlab.ehr.core.pcm.filter.PCMYPZJKXXSearchContext;

@Slf4j
@Api(tags = {"PCMYPZJKXX" })
@RestController("WebApi-pcmypzjkxx")
@RequestMapping("")
public class PCMYPZJKXXResource {

    @Autowired
    public IPCMYPZJKXXService pcmypzjkxxService;

    @Autowired
    @Lazy
    public PCMYPZJKXXMapping pcmypzjkxxMapping;

    @PreAuthorize("hasPermission(this.pcmypzjkxxService.get(#pcmypzjkxx_id),'ehr-PCMYPZJKXX-Update')")
    @ApiOperation(value = "Update", tags = {"PCMYPZJKXX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmypzjkxxes/{pcmypzjkxx_id}")
    @Transactional
    public ResponseEntity<PCMYPZJKXXDTO> update(@PathVariable("pcmypzjkxx_id") String pcmypzjkxx_id, @RequestBody PCMYPZJKXXDTO pcmypzjkxxdto) {
		PCMYPZJKXX domain  = pcmypzjkxxMapping.toDomain(pcmypzjkxxdto);
        domain .setPcmypzjkxxid(pcmypzjkxx_id);
		pcmypzjkxxService.update(domain );
		PCMYPZJKXXDTO dto = pcmypzjkxxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmypzjkxxService.getPcmypzjkxxByEntities(this.pcmypzjkxxMapping.toDomain(#pcmypzjkxxdtos)),'ehr-PCMYPZJKXX-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMYPZJKXX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmypzjkxxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMYPZJKXXDTO> pcmypzjkxxdtos) {
        pcmypzjkxxService.updateBatch(pcmypzjkxxMapping.toDomain(pcmypzjkxxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmypzjkxxService.get(#pcmypzjkxx_id),'ehr-PCMYPZJKXX-Remove')")
    @ApiOperation(value = "Remove", tags = {"PCMYPZJKXX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmypzjkxxes/{pcmypzjkxx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmypzjkxx_id") String pcmypzjkxx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmypzjkxxService.remove(pcmypzjkxx_id));
    }

    @PreAuthorize("hasPermission(this.pcmypzjkxxService.getPcmypzjkxxByIds(#ids),'ehr-PCMYPZJKXX-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PCMYPZJKXX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmypzjkxxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmypzjkxxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"PCMYPZJKXX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmypzjkxxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMYPZJKXXDTO pcmypzjkxxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmypzjkxxService.checkKey(pcmypzjkxxMapping.toDomain(pcmypzjkxxdto)));
    }

    @PostAuthorize("hasPermission(this.pcmypzjkxxMapping.toDomain(returnObject.body),'ehr-PCMYPZJKXX-Get')")
    @ApiOperation(value = "Get", tags = {"PCMYPZJKXX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmypzjkxxes/{pcmypzjkxx_id}")
    public ResponseEntity<PCMYPZJKXXDTO> get(@PathVariable("pcmypzjkxx_id") String pcmypzjkxx_id) {
        PCMYPZJKXX domain = pcmypzjkxxService.get(pcmypzjkxx_id);
        PCMYPZJKXXDTO dto = pcmypzjkxxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "GetDraft", tags = {"PCMYPZJKXX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmypzjkxxes/getdraft")
    public ResponseEntity<PCMYPZJKXXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmypzjkxxMapping.toDto(pcmypzjkxxService.getDraft(new PCMYPZJKXX())));
    }

    @PreAuthorize("hasPermission(this.pcmypzjkxxMapping.toDomain(#pcmypzjkxxdto),'ehr-PCMYPZJKXX-Create')")
    @ApiOperation(value = "Create", tags = {"PCMYPZJKXX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmypzjkxxes")
    @Transactional
    public ResponseEntity<PCMYPZJKXXDTO> create(@RequestBody PCMYPZJKXXDTO pcmypzjkxxdto) {
        PCMYPZJKXX domain = pcmypzjkxxMapping.toDomain(pcmypzjkxxdto);
		pcmypzjkxxService.create(domain);
        PCMYPZJKXXDTO dto = pcmypzjkxxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmypzjkxxMapping.toDomain(#pcmypzjkxxdtos),'ehr-PCMYPZJKXX-Create')")
    @ApiOperation(value = "createBatch", tags = {"PCMYPZJKXX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmypzjkxxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMYPZJKXXDTO> pcmypzjkxxdtos) {
        pcmypzjkxxService.createBatch(pcmypzjkxxMapping.toDomain(pcmypzjkxxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmypzjkxxMapping.toDomain(#pcmypzjkxxdto),'ehr-PCMYPZJKXX-Save')")
    @ApiOperation(value = "Save", tags = {"PCMYPZJKXX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmypzjkxxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMYPZJKXXDTO pcmypzjkxxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmypzjkxxService.save(pcmypzjkxxMapping.toDomain(pcmypzjkxxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmypzjkxxMapping.toDomain(#pcmypzjkxxdtos),'ehr-PCMYPZJKXX-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PCMYPZJKXX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmypzjkxxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMYPZJKXXDTO> pcmypzjkxxdtos) {
        pcmypzjkxxService.saveBatch(pcmypzjkxxMapping.toDomain(pcmypzjkxxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYPZJKXX-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMYPZJKXX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmypzjkxxes/fetchdefault")
	public ResponseEntity<List<PCMYPZJKXXDTO>> fetchDefault(PCMYPZJKXXSearchContext context) {
        Page<PCMYPZJKXX> domains = pcmypzjkxxService.searchDefault(context) ;
        List<PCMYPZJKXXDTO> list = pcmypzjkxxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYPZJKXX-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMYPZJKXX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmypzjkxxes/searchdefault")
	public ResponseEntity<Page<PCMYPZJKXXDTO>> searchDefault(@RequestBody PCMYPZJKXXSearchContext context) {
        Page<PCMYPZJKXX> domains = pcmypzjkxxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmypzjkxxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

