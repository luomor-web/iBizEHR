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
import cn.ibizlab.ehr.core.pcm.domain.PCMTXBZ;
import cn.ibizlab.ehr.core.pcm.service.IPCMTXBZService;
import cn.ibizlab.ehr.core.pcm.filter.PCMTXBZSearchContext;

@Slf4j
@Api(tags = {"PCMTXBZ" })
@RestController("WebApi-pcmtxbz")
@RequestMapping("")
public class PCMTXBZResource {

    @Autowired
    public IPCMTXBZService pcmtxbzService;

    @Autowired
    @Lazy
    public PCMTXBZMapping pcmtxbzMapping;

    @ApiOperation(value = "CheckKey", tags = {"PCMTXBZ" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtxbzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMTXBZDTO pcmtxbzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmtxbzService.checkKey(pcmtxbzMapping.toDomain(pcmtxbzdto)));
    }

    @PostAuthorize("hasPermission(this.pcmtxbzMapping.toDomain(returnObject.body),'ehr-PCMTXBZ-Get')")
    @ApiOperation(value = "Get", tags = {"PCMTXBZ" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmtxbzs/{pcmtxbz_id}")
    public ResponseEntity<PCMTXBZDTO> get(@PathVariable("pcmtxbz_id") String pcmtxbz_id) {
        PCMTXBZ domain = pcmtxbzService.get(pcmtxbz_id);
        PCMTXBZDTO dto = pcmtxbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "GetDraft", tags = {"PCMTXBZ" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmtxbzs/getdraft")
    public ResponseEntity<PCMTXBZDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmtxbzMapping.toDto(pcmtxbzService.getDraft(new PCMTXBZ())));
    }

    @PreAuthorize("hasPermission(this.pcmtxbzService.get(#pcmtxbz_id),'ehr-PCMTXBZ-Update')")
    @ApiOperation(value = "Update", tags = {"PCMTXBZ" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmtxbzs/{pcmtxbz_id}")
    @Transactional
    public ResponseEntity<PCMTXBZDTO> update(@PathVariable("pcmtxbz_id") String pcmtxbz_id, @RequestBody PCMTXBZDTO pcmtxbzdto) {
		PCMTXBZ domain  = pcmtxbzMapping.toDomain(pcmtxbzdto);
        domain .setPcmtxbzid(pcmtxbz_id);
		pcmtxbzService.update(domain );
		PCMTXBZDTO dto = pcmtxbzMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmtxbzService.getPcmtxbzByEntities(this.pcmtxbzMapping.toDomain(#pcmtxbzdtos)),'ehr-PCMTXBZ-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMTXBZ" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmtxbzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMTXBZDTO> pcmtxbzdtos) {
        pcmtxbzService.updateBatch(pcmtxbzMapping.toDomain(pcmtxbzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmtxbzMapping.toDomain(#pcmtxbzdto),'ehr-PCMTXBZ-Create')")
    @ApiOperation(value = "Create", tags = {"PCMTXBZ" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtxbzs")
    @Transactional
    public ResponseEntity<PCMTXBZDTO> create(@RequestBody PCMTXBZDTO pcmtxbzdto) {
        PCMTXBZ domain = pcmtxbzMapping.toDomain(pcmtxbzdto);
		pcmtxbzService.create(domain);
        PCMTXBZDTO dto = pcmtxbzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmtxbzMapping.toDomain(#pcmtxbzdtos),'ehr-PCMTXBZ-Create')")
    @ApiOperation(value = "createBatch", tags = {"PCMTXBZ" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtxbzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMTXBZDTO> pcmtxbzdtos) {
        pcmtxbzService.createBatch(pcmtxbzMapping.toDomain(pcmtxbzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmtxbzMapping.toDomain(#pcmtxbzdto),'ehr-PCMTXBZ-Save')")
    @ApiOperation(value = "Save", tags = {"PCMTXBZ" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtxbzs/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMTXBZDTO pcmtxbzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmtxbzService.save(pcmtxbzMapping.toDomain(pcmtxbzdto)));
    }

    @PreAuthorize("hasPermission(this.pcmtxbzMapping.toDomain(#pcmtxbzdtos),'ehr-PCMTXBZ-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PCMTXBZ" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtxbzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMTXBZDTO> pcmtxbzdtos) {
        pcmtxbzService.saveBatch(pcmtxbzMapping.toDomain(pcmtxbzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmtxbzService.get(#pcmtxbz_id),'ehr-PCMTXBZ-Remove')")
    @ApiOperation(value = "Remove", tags = {"PCMTXBZ" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmtxbzs/{pcmtxbz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmtxbz_id") String pcmtxbz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmtxbzService.remove(pcmtxbz_id));
    }

    @PreAuthorize("hasPermission(this.pcmtxbzService.getPcmtxbzByIds(#ids),'ehr-PCMTXBZ-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PCMTXBZ" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmtxbzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmtxbzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMTXBZ-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMTXBZ" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmtxbzs/fetchdefault")
	public ResponseEntity<List<PCMTXBZDTO>> fetchDefault(PCMTXBZSearchContext context) {
        Page<PCMTXBZ> domains = pcmtxbzService.searchDefault(context) ;
        List<PCMTXBZDTO> list = pcmtxbzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMTXBZ-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMTXBZ" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmtxbzs/searchdefault")
	public ResponseEntity<Page<PCMTXBZDTO>> searchDefault(@RequestBody PCMTXBZSearchContext context) {
        Page<PCMTXBZ> domains = pcmtxbzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmtxbzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

