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
import cn.ibizlab.ehr.core.pcm.domain.PCMNORecyclingLibrary;
import cn.ibizlab.ehr.core.pcm.service.IPCMNORecyclingLibraryService;
import cn.ibizlab.ehr.core.pcm.filter.PCMNORecyclingLibrarySearchContext;




@Slf4j
@Api(tags = {"PCMNORecyclingLibrary" })
@RestController("WebApi-pcmnorecyclinglibrary")
@RequestMapping("")
public class PCMNORecyclingLibraryResource {

    @Autowired
    private IPCMNORecyclingLibraryService pcmnorecyclinglibraryService;

    @Autowired
    @Lazy
    private PCMNORecyclingLibraryMapping pcmnorecyclinglibraryMapping;




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PCMNORecyclingLibrary" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmnorecyclinglibraries")
    @Transactional
    public ResponseEntity<PCMNORecyclingLibraryDTO> create(@RequestBody PCMNORecyclingLibraryDTO pcmnorecyclinglibrarydto) {
        PCMNORecyclingLibrary domain = pcmnorecyclinglibraryMapping.toDomain(pcmnorecyclinglibrarydto);
		pcmnorecyclinglibraryService.create(domain);
        PCMNORecyclingLibraryDTO dto = pcmnorecyclinglibraryMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PCMNORecyclingLibrary" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmnorecyclinglibraries/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMNORecyclingLibraryDTO> pcmnorecyclinglibrarydtos) {
        pcmnorecyclinglibraryService.createBatch(pcmnorecyclinglibraryMapping.toDomain(pcmnorecyclinglibrarydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PCMNORecyclingLibrary" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmnorecyclinglibraries/getdraft")
    public ResponseEntity<PCMNORecyclingLibraryDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmnorecyclinglibraryMapping.toDto(pcmnorecyclinglibraryService.getDraft(new PCMNORecyclingLibrary())));
    }




    @PreAuthorize("hasPermission(#pcmnorecyclinglibrary_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PCMNORecyclingLibrary" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmnorecyclinglibraries/{pcmnorecyclinglibrary_id}")
    public ResponseEntity<PCMNORecyclingLibraryDTO> get(@PathVariable("pcmnorecyclinglibrary_id") String pcmnorecyclinglibrary_id) {
        PCMNORecyclingLibrary domain = pcmnorecyclinglibraryService.get(pcmnorecyclinglibrary_id);
        PCMNORecyclingLibraryDTO dto = pcmnorecyclinglibraryMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('Remove',{#pcmnorecyclinglibrary_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PCMNORecyclingLibrary" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmnorecyclinglibraries/{pcmnorecyclinglibrary_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmnorecyclinglibrary_id") String pcmnorecyclinglibrary_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmnorecyclinglibraryService.remove(pcmnorecyclinglibrary_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PCMNORecyclingLibrary" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmnorecyclinglibraries/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmnorecyclinglibraryService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pcmnorecyclinglibrary_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PCMNORecyclingLibrary" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmnorecyclinglibraries/{pcmnorecyclinglibrary_id}")
    @Transactional
    public ResponseEntity<PCMNORecyclingLibraryDTO> update(@PathVariable("pcmnorecyclinglibrary_id") String pcmnorecyclinglibrary_id, @RequestBody PCMNORecyclingLibraryDTO pcmnorecyclinglibrarydto) {
		PCMNORecyclingLibrary domain = pcmnorecyclinglibraryMapping.toDomain(pcmnorecyclinglibrarydto);
        domain.setPcmnorecyclinglibraryid(pcmnorecyclinglibrary_id);
		pcmnorecyclinglibraryService.update(domain);
		PCMNORecyclingLibraryDTO dto = pcmnorecyclinglibraryMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pcmnorecyclinglibrary_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMNORecyclingLibrary" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmnorecyclinglibraries/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMNORecyclingLibraryDTO> pcmnorecyclinglibrarydtos) {
        pcmnorecyclinglibraryService.updateBatch(pcmnorecyclinglibraryMapping.toDomain(pcmnorecyclinglibrarydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"PCMNORecyclingLibrary" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmnorecyclinglibraries/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMNORecyclingLibraryDTO pcmnorecyclinglibrarydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmnorecyclinglibraryService.checkKey(pcmnorecyclinglibraryMapping.toDomain(pcmnorecyclinglibrarydto)));
    }




    @ApiOperation(value = "Save", tags = {"PCMNORecyclingLibrary" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmnorecyclinglibraries/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMNORecyclingLibraryDTO pcmnorecyclinglibrarydto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmnorecyclinglibraryService.save(pcmnorecyclinglibraryMapping.toDomain(pcmnorecyclinglibrarydto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PCMNORecyclingLibrary" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmnorecyclinglibraries/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMNORecyclingLibraryDTO> pcmnorecyclinglibrarydtos) {
        pcmnorecyclinglibraryService.saveBatch(pcmnorecyclinglibraryMapping.toDomain(pcmnorecyclinglibrarydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMNORecyclingLibrary" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmnorecyclinglibraries/fetchdefault")
	public ResponseEntity<List<PCMNORecyclingLibraryDTO>> fetchDefault(PCMNORecyclingLibrarySearchContext context) {
        Page<PCMNORecyclingLibrary> domains = pcmnorecyclinglibraryService.searchDefault(context) ;
        List<PCMNORecyclingLibraryDTO> list = pcmnorecyclinglibraryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMNORecyclingLibrary" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmnorecyclinglibraries/searchdefault")
	public ResponseEntity<Page<PCMNORecyclingLibraryDTO>> searchDefault(PCMNORecyclingLibrarySearchContext context) {
        Page<PCMNORecyclingLibrary> domains = pcmnorecyclinglibraryService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmnorecyclinglibraryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PCMNORecyclingLibrary getEntity(){
        return new PCMNORecyclingLibrary();
    }

}