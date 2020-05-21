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
import cn.ibizlab.ehr.core.wf.domain.WFStepActor;
import cn.ibizlab.ehr.core.wf.service.IWFStepActorService;
import cn.ibizlab.ehr.core.wf.filter.WFStepActorSearchContext;




@Slf4j
@Api(tags = {"WFStepActor" })
@RestController("WebApi-wfstepactor")
@RequestMapping("")
public class WFStepActorResource {

    @Autowired
    private IWFStepActorService wfstepactorService;

    @Autowired
    @Lazy
    public WFStepActorMapping wfstepactorMapping;

    public WFStepActorDTO permissionDTO=new WFStepActorDTO();




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFStepActor-Save-all')")
    @ApiOperation(value = "Save", tags = {"WFStepActor" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/wfstepactors/save")
    public ResponseEntity<Boolean> save(@RequestBody WFStepActorDTO wfstepactordto) {
        return ResponseEntity.status(HttpStatus.OK).body(wfstepactorService.save(wfstepactorMapping.toDomain(wfstepactordto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"WFStepActor" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfstepactors/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WFStepActorDTO> wfstepactordtos) {
        wfstepactorService.saveBatch(wfstepactorMapping.toDomain(wfstepactordtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFStepActor-RemindSave-all')")
    @ApiOperation(value = "催办保存", tags = {"WFStepActor" },  notes = "催办保存")
	@RequestMapping(method = RequestMethod.POST, value = "/wfstepactors/{wfstepactor_id}/remindsave")
    @Transactional
    public ResponseEntity<WFStepActorDTO> remindSave(@PathVariable("wfstepactor_id") String wfstepactor_id, @RequestBody WFStepActorDTO wfstepactordto) {
        WFStepActor wfstepactor = wfstepactorMapping.toDomain(wfstepactordto);
        wfstepactor = wfstepactorService.remindSave(wfstepactor);
        wfstepactordto = wfstepactorMapping.toDto(wfstepactor);
        return ResponseEntity.status(HttpStatus.OK).body(wfstepactordto);
    }




    @PreAuthorize("hasPermission(#wfstepactor_id,'Get',{'Sql',this.wfstepactorMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"WFStepActor" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/wfstepactors/{wfstepactor_id}")
    public ResponseEntity<WFStepActorDTO> get(@PathVariable("wfstepactor_id") String wfstepactor_id) {
        WFStepActor domain = wfstepactorService.get(wfstepactor_id);
        WFStepActorDTO dto = wfstepactorMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#wfstepactor_id,'Update',{'Sql',this.wfstepactorMapping,#wfstepactordto})")
    @ApiOperation(value = "Update", tags = {"WFStepActor" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfstepactors/{wfstepactor_id}")
    @Transactional
    public ResponseEntity<WFStepActorDTO> update(@PathVariable("wfstepactor_id") String wfstepactor_id, @RequestBody WFStepActorDTO wfstepactordto) {
		WFStepActor domain = wfstepactorMapping.toDomain(wfstepactordto);
        domain.setWfstepactorid(wfstepactor_id);
		wfstepactorService.update(domain);
		WFStepActorDTO dto = wfstepactorMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"WFStepActor" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfstepactors/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WFStepActorDTO> wfstepactordtos) {
        wfstepactorService.updateBatch(wfstepactorMapping.toDomain(wfstepactordtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.wfstepactorMapping,#wfstepactordto})")
    @ApiOperation(value = "Create", tags = {"WFStepActor" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/wfstepactors")
    @Transactional
    public ResponseEntity<WFStepActorDTO> create(@RequestBody WFStepActorDTO wfstepactordto) {
        WFStepActor domain = wfstepactorMapping.toDomain(wfstepactordto);
		wfstepactorService.create(domain);
        WFStepActorDTO dto = wfstepactorMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"WFStepActor" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfstepactors/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WFStepActorDTO> wfstepactordtos) {
        wfstepactorService.createBatch(wfstepactorMapping.toDomain(wfstepactordtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#wfstepactor_id,'Remove',{'Sql',this.wfstepactorMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"WFStepActor" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfstepactors/{wfstepactor_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("wfstepactor_id") String wfstepactor_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wfstepactorService.remove(wfstepactor_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"WFStepActor" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfstepactors/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wfstepactorService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFStepActor-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"WFStepActor" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/wfstepactors/getdraft")
    public ResponseEntity<WFStepActorDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wfstepactorMapping.toDto(wfstepactorService.getDraft(new WFStepActor())));
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFStepActor-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"WFStepActor" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/wfstepactors/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WFStepActorDTO wfstepactordto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wfstepactorService.checkKey(wfstepactorMapping.toDomain(wfstepactordto)));
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFStepActor-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"WFStepActor" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfstepactors/fetchdefault")
	public ResponseEntity<List<WFStepActorDTO>> fetchDefault(WFStepActorSearchContext context) {
        Page<WFStepActor> domains = wfstepactorService.searchDefault(context) ;
        List<WFStepActorDTO> list = wfstepactorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFStepActor-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"WFStepActor" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/wfstepactors/searchdefault")
	public ResponseEntity<Page<WFStepActorDTO>> searchDefault(@RequestBody WFStepActorSearchContext context) {
        Page<WFStepActor> domains = wfstepactorService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfstepactorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


