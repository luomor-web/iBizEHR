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
import cn.ibizlab.ehr.core.wf.domain.WFActor;
import cn.ibizlab.ehr.core.wf.service.IWFActorService;
import cn.ibizlab.ehr.core.wf.filter.WFActorSearchContext;




@Slf4j
@Api(tags = {"WFActor" })
@RestController("WebApi-wfactor")
@RequestMapping("")
public class WFActorResource {

    @Autowired
    private IWFActorService wfactorService;

    @Autowired
    @Lazy
    public WFActorMapping wfactorMapping;

    public WFActorDTO permissionDTO=new WFActorDTO();




    @PreAuthorize("hasPermission(#wfactor_id,'Update',{'Sql',this.wfactorMapping,#wfactordto})")
    @ApiOperation(value = "Update", tags = {"WFActor" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfactors/{wfactor_id}")
    @Transactional
    public ResponseEntity<WFActorDTO> update(@PathVariable("wfactor_id") String wfactor_id, @RequestBody WFActorDTO wfactordto) {
		WFActor domain = wfactorMapping.toDomain(wfactordto);
        domain.setWfactorid(wfactor_id);
		wfactorService.update(domain);
		WFActorDTO dto = wfactorMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"WFActor" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfactors/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WFActorDTO> wfactordtos) {
        wfactorService.updateBatch(wfactorMapping.toDomain(wfactordtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFActor-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"WFActor" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/wfactors/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WFActorDTO wfactordto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wfactorService.checkKey(wfactorMapping.toDomain(wfactordto)));
    }




    @PreAuthorize("hasPermission(#wfactor_id,'Get',{'Sql',this.wfactorMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"WFActor" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/wfactors/{wfactor_id}")
    public ResponseEntity<WFActorDTO> get(@PathVariable("wfactor_id") String wfactor_id) {
        WFActor domain = wfactorService.get(wfactor_id);
        WFActorDTO dto = wfactorMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#wfactor_id,'Remove',{'Sql',this.wfactorMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"WFActor" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfactors/{wfactor_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("wfactor_id") String wfactor_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wfactorService.remove(wfactor_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"WFActor" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfactors/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wfactorService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.wfactorMapping,#wfactordto})")
    @ApiOperation(value = "Create", tags = {"WFActor" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/wfactors")
    @Transactional
    public ResponseEntity<WFActorDTO> create(@RequestBody WFActorDTO wfactordto) {
        WFActor domain = wfactorMapping.toDomain(wfactordto);
		wfactorService.create(domain);
        WFActorDTO dto = wfactorMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"WFActor" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfactors/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WFActorDTO> wfactordtos) {
        wfactorService.createBatch(wfactorMapping.toDomain(wfactordtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFActor-Save-all')")
    @ApiOperation(value = "Save", tags = {"WFActor" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/wfactors/save")
    public ResponseEntity<Boolean> save(@RequestBody WFActorDTO wfactordto) {
        return ResponseEntity.status(HttpStatus.OK).body(wfactorService.save(wfactorMapping.toDomain(wfactordto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"WFActor" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfactors/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WFActorDTO> wfactordtos) {
        wfactorService.saveBatch(wfactorMapping.toDomain(wfactordtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFActor-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"WFActor" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/wfactors/getdraft")
    public ResponseEntity<WFActorDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wfactorMapping.toDto(wfactorService.getDraft(new WFActor())));
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFActor-IndexDER-all')")
	@ApiOperation(value = "fetchIndexDER", tags = {"WFActor" } ,notes = "fetchIndexDER")
    @RequestMapping(method= RequestMethod.GET , value="/wfactors/fetchindexder")
	public ResponseEntity<List<WFActorDTO>> fetchIndexDER(WFActorSearchContext context) {
        Page<WFActor> domains = wfactorService.searchIndexDER(context) ;
        List<WFActorDTO> list = wfactorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFActor-IndexDER-all')")
	@ApiOperation(value = "searchIndexDER", tags = {"WFActor" } ,notes = "searchIndexDER")
    @RequestMapping(method= RequestMethod.POST , value="/wfactors/searchindexder")
	public ResponseEntity<Page<WFActorDTO>> searchIndexDER(@RequestBody WFActorSearchContext context) {
        Page<WFActor> domains = wfactorService.searchIndexDER(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfactorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFActor-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"WFActor" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfactors/fetchdefault")
	public ResponseEntity<List<WFActorDTO>> fetchDefault(WFActorSearchContext context) {
        Page<WFActor> domains = wfactorService.searchDefault(context) ;
        List<WFActorDTO> list = wfactorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFActor-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"WFActor" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/wfactors/searchdefault")
	public ResponseEntity<Page<WFActorDTO>> searchDefault(@RequestBody WFActorSearchContext context) {
        Page<WFActor> domains = wfactorService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfactorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


