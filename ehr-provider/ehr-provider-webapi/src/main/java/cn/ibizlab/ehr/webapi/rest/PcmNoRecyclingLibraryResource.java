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
import cn.ibizlab.ehr.core.pcm.domain.PcmNoRecyclingLibrary;
import cn.ibizlab.ehr.core.pcm.service.IPcmNoRecyclingLibraryService;
import cn.ibizlab.ehr.core.pcm.filter.PcmNoRecyclingLibrarySearchContext;

@Slf4j
@Api(tags = {"PcmNoRecyclingLibrary" })
@RestController("WebApi-pcmnorecyclinglibrary")
@RequestMapping("")
public class PcmNoRecyclingLibraryResource {

    @Autowired
    public IPcmNoRecyclingLibraryService pcmnorecyclinglibraryService;

    @Autowired
    @Lazy
    public PcmNoRecyclingLibraryMapping pcmnorecyclinglibraryMapping;

    @PreAuthorize("hasPermission(this.pcmnorecyclinglibraryMapping.toDomain(#pcmnorecyclinglibrarydto),'ehr-PcmNoRecyclingLibrary-Create')")
    @ApiOperation(value = "Create", tags = {"PcmNoRecyclingLibrary" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmnorecyclinglibraries")
    @Transactional
    public ResponseEntity<PcmNoRecyclingLibraryDTO> create(@RequestBody PcmNoRecyclingLibraryDTO pcmnorecyclinglibrarydto) {
        PcmNoRecyclingLibrary domain = pcmnorecyclinglibraryMapping.toDomain(pcmnorecyclinglibrarydto);
		pcmnorecyclinglibraryService.create(domain);
        PcmNoRecyclingLibraryDTO dto = pcmnorecyclinglibraryMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmnorecyclinglibraryMapping.toDomain(#pcmnorecyclinglibrarydtos),'ehr-PcmNoRecyclingLibrary-Create')")
    @ApiOperation(value = "createBatch", tags = {"PcmNoRecyclingLibrary" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmnorecyclinglibraries/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmNoRecyclingLibraryDTO> pcmnorecyclinglibrarydtos) {
        pcmnorecyclinglibraryService.createBatch(pcmnorecyclinglibraryMapping.toDomain(pcmnorecyclinglibrarydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"PcmNoRecyclingLibrary" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmnorecyclinglibraries/getdraft")
    public ResponseEntity<PcmNoRecyclingLibraryDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmnorecyclinglibraryMapping.toDto(pcmnorecyclinglibraryService.getDraft(new PcmNoRecyclingLibrary())));
    }

    @PostAuthorize("hasPermission(this.pcmnorecyclinglibraryMapping.toDomain(returnObject.body),'ehr-PcmNoRecyclingLibrary-Get')")
    @ApiOperation(value = "Get", tags = {"PcmNoRecyclingLibrary" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmnorecyclinglibraries/{pcmnorecyclinglibrary_id}")
    public ResponseEntity<PcmNoRecyclingLibraryDTO> get(@PathVariable("pcmnorecyclinglibrary_id") String pcmnorecyclinglibrary_id) {
        PcmNoRecyclingLibrary domain = pcmnorecyclinglibraryService.get(pcmnorecyclinglibrary_id);
        PcmNoRecyclingLibraryDTO dto = pcmnorecyclinglibraryMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmnorecyclinglibraryService.get(#pcmnorecyclinglibrary_id),'ehr-PcmNoRecyclingLibrary-Remove')")
    @ApiOperation(value = "Remove", tags = {"PcmNoRecyclingLibrary" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmnorecyclinglibraries/{pcmnorecyclinglibrary_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmnorecyclinglibrary_id") String pcmnorecyclinglibrary_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmnorecyclinglibraryService.remove(pcmnorecyclinglibrary_id));
    }

    @PreAuthorize("hasPermission(this.pcmnorecyclinglibraryService.getPcmnorecyclinglibraryByIds(#ids),'ehr-PcmNoRecyclingLibrary-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PcmNoRecyclingLibrary" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmnorecyclinglibraries/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmnorecyclinglibraryService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmnorecyclinglibraryService.get(#pcmnorecyclinglibrary_id),'ehr-PcmNoRecyclingLibrary-Update')")
    @ApiOperation(value = "Update", tags = {"PcmNoRecyclingLibrary" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmnorecyclinglibraries/{pcmnorecyclinglibrary_id}")
    @Transactional
    public ResponseEntity<PcmNoRecyclingLibraryDTO> update(@PathVariable("pcmnorecyclinglibrary_id") String pcmnorecyclinglibrary_id, @RequestBody PcmNoRecyclingLibraryDTO pcmnorecyclinglibrarydto) {
		PcmNoRecyclingLibrary domain  = pcmnorecyclinglibraryMapping.toDomain(pcmnorecyclinglibrarydto);
        domain .setPcmnorecyclinglibraryid(pcmnorecyclinglibrary_id);
		pcmnorecyclinglibraryService.update(domain );
		PcmNoRecyclingLibraryDTO dto = pcmnorecyclinglibraryMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmnorecyclinglibraryService.getPcmnorecyclinglibraryByEntities(this.pcmnorecyclinglibraryMapping.toDomain(#pcmnorecyclinglibrarydtos)),'ehr-PcmNoRecyclingLibrary-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PcmNoRecyclingLibrary" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmnorecyclinglibraries/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmNoRecyclingLibraryDTO> pcmnorecyclinglibrarydtos) {
        pcmnorecyclinglibraryService.updateBatch(pcmnorecyclinglibraryMapping.toDomain(pcmnorecyclinglibrarydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"PcmNoRecyclingLibrary" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmnorecyclinglibraries/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmNoRecyclingLibraryDTO pcmnorecyclinglibrarydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmnorecyclinglibraryService.checkKey(pcmnorecyclinglibraryMapping.toDomain(pcmnorecyclinglibrarydto)));
    }

    @PreAuthorize("hasPermission(this.pcmnorecyclinglibraryMapping.toDomain(#pcmnorecyclinglibrarydto),'ehr-PcmNoRecyclingLibrary-Save')")
    @ApiOperation(value = "Save", tags = {"PcmNoRecyclingLibrary" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmnorecyclinglibraries/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmNoRecyclingLibraryDTO pcmnorecyclinglibrarydto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmnorecyclinglibraryService.save(pcmnorecyclinglibraryMapping.toDomain(pcmnorecyclinglibrarydto)));
    }

    @PreAuthorize("hasPermission(this.pcmnorecyclinglibraryMapping.toDomain(#pcmnorecyclinglibrarydtos),'ehr-PcmNoRecyclingLibrary-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PcmNoRecyclingLibrary" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmnorecyclinglibraries/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmNoRecyclingLibraryDTO> pcmnorecyclinglibrarydtos) {
        pcmnorecyclinglibraryService.saveBatch(pcmnorecyclinglibraryMapping.toDomain(pcmnorecyclinglibrarydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmNoRecyclingLibrary-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PcmNoRecyclingLibrary" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmnorecyclinglibraries/fetchdefault")
	public ResponseEntity<List<PcmNoRecyclingLibraryDTO>> fetchDefault(PcmNoRecyclingLibrarySearchContext context) {
        Page<PcmNoRecyclingLibrary> domains = pcmnorecyclinglibraryService.searchDefault(context) ;
        List<PcmNoRecyclingLibraryDTO> list = pcmnorecyclinglibraryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmNoRecyclingLibrary-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PcmNoRecyclingLibrary" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmnorecyclinglibraries/searchdefault")
	public ResponseEntity<Page<PcmNoRecyclingLibraryDTO>> searchDefault(@RequestBody PcmNoRecyclingLibrarySearchContext context) {
        Page<PcmNoRecyclingLibrary> domains = pcmnorecyclinglibraryService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmnorecyclinglibraryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

