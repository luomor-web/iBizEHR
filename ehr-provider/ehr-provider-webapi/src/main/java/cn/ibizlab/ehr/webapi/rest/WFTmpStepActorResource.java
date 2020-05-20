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
import cn.ibizlab.ehr.core.wf.domain.WFTmpStepActor;
import cn.ibizlab.ehr.core.wf.service.IWFTmpStepActorService;
import cn.ibizlab.ehr.core.wf.filter.WFTmpStepActorSearchContext;




@Slf4j
@Api(tags = {"WFTmpStepActor" })
@RestController("WebApi-wftmpstepactor")
@RequestMapping("")
public class WFTmpStepActorResource {

    @Autowired
    private IWFTmpStepActorService wftmpstepactorService;

    @Autowired
    @Lazy
    private WFTmpStepActorMapping wftmpstepactorMapping;




    @PreAuthorize("hasPermission(#wftmpstepactor_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"WFTmpStepActor" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/wftmpstepactors/{wftmpstepactor_id}")
    @Transactional
    public ResponseEntity<WFTmpStepActorDTO> update(@PathVariable("wftmpstepactor_id") String wftmpstepactor_id, @RequestBody WFTmpStepActorDTO wftmpstepactordto) {
		WFTmpStepActor domain = wftmpstepactorMapping.toDomain(wftmpstepactordto);
        domain.setWftmpstepactorid(wftmpstepactor_id);
		wftmpstepactorService.update(domain);
		WFTmpStepActorDTO dto = wftmpstepactorMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#wftmpstepactor_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"WFTmpStepActor" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/wftmpstepactors/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WFTmpStepActorDTO> wftmpstepactordtos) {
        wftmpstepactorService.updateBatch(wftmpstepactorMapping.toDomain(wftmpstepactordtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"WFTmpStepActor" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/wftmpstepactors/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WFTmpStepActorDTO wftmpstepactordto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wftmpstepactorService.checkKey(wftmpstepactorMapping.toDomain(wftmpstepactordto)));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"WFTmpStepActor" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/wftmpstepactors")
    @Transactional
    public ResponseEntity<WFTmpStepActorDTO> create(@RequestBody WFTmpStepActorDTO wftmpstepactordto) {
        WFTmpStepActor domain = wftmpstepactorMapping.toDomain(wftmpstepactordto);
		wftmpstepactorService.create(domain);
        WFTmpStepActorDTO dto = wftmpstepactorMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"WFTmpStepActor" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wftmpstepactors/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WFTmpStepActorDTO> wftmpstepactordtos) {
        wftmpstepactorService.createBatch(wftmpstepactorMapping.toDomain(wftmpstepactordtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#wftmpstepactor_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"WFTmpStepActor" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wftmpstepactors/{wftmpstepactor_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("wftmpstepactor_id") String wftmpstepactor_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wftmpstepactorService.remove(wftmpstepactor_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"WFTmpStepActor" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wftmpstepactors/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wftmpstepactorService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"WFTmpStepActor" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/wftmpstepactors/getdraft")
    public ResponseEntity<WFTmpStepActorDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wftmpstepactorMapping.toDto(wftmpstepactorService.getDraft(new WFTmpStepActor())));
    }




    @PreAuthorize("hasPermission(#wftmpstepactor_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"WFTmpStepActor" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/wftmpstepactors/{wftmpstepactor_id}")
    public ResponseEntity<WFTmpStepActorDTO> get(@PathVariable("wftmpstepactor_id") String wftmpstepactor_id) {
        WFTmpStepActor domain = wftmpstepactorService.get(wftmpstepactor_id);
        WFTmpStepActorDTO dto = wftmpstepactorMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "Save", tags = {"WFTmpStepActor" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/wftmpstepactors/save")
    public ResponseEntity<Boolean> save(@RequestBody WFTmpStepActorDTO wftmpstepactordto) {
        return ResponseEntity.status(HttpStatus.OK).body(wftmpstepactorService.save(wftmpstepactorMapping.toDomain(wftmpstepactordto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"WFTmpStepActor" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wftmpstepactors/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WFTmpStepActorDTO> wftmpstepactordtos) {
        wftmpstepactorService.saveBatch(wftmpstepactorMapping.toDomain(wftmpstepactordtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFTmpStepActor-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"WFTmpStepActor" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wftmpstepactors/fetchdefault")
	public ResponseEntity<List<WFTmpStepActorDTO>> fetchDefault(WFTmpStepActorSearchContext context) {
        Page<WFTmpStepActor> domains = wftmpstepactorService.searchDefault(context) ;
        List<WFTmpStepActorDTO> list = wftmpstepactorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFTmpStepActor-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"WFTmpStepActor" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/wftmpstepactors/searchdefault")
	public ResponseEntity<Page<WFTmpStepActorDTO>> searchDefault(@RequestBody WFTmpStepActorSearchContext context) {
        Page<WFTmpStepActor> domains = wftmpstepactorService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wftmpstepactorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public WFTmpStepActor getEntity(){
        return new WFTmpStepActor();
    }

}
