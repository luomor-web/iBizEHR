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
import cn.ibizlab.ehr.core.wf.domain.WFStep;
import cn.ibizlab.ehr.core.wf.service.IWFStepService;
import cn.ibizlab.ehr.core.wf.filter.WFStepSearchContext;




@Slf4j
@Api(tags = {"WFStep" })
@RestController("WebApi-wfstep")
@RequestMapping("")
public class WFStepResource {

    @Autowired
    private IWFStepService wfstepService;

    @Autowired
    @Lazy
    private WFStepMapping wfstepMapping;




    @PreAuthorize("hasPermission(#wfstep_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"WFStep" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/wfsteps/{wfstep_id}")
    public ResponseEntity<WFStepDTO> get(@PathVariable("wfstep_id") String wfstep_id) {
        WFStep domain = wfstepService.get(wfstep_id);
        WFStepDTO dto = wfstepMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#wfstep_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"WFStep" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfsteps/{wfstep_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("wfstep_id") String wfstep_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wfstepService.remove(wfstep_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"WFStep" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfsteps/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wfstepService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"WFStep" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/wfsteps/getdraft")
    public ResponseEntity<WFStepDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wfstepMapping.toDto(wfstepService.getDraft(new WFStep())));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"WFStep" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/wfsteps")
    @Transactional
    public ResponseEntity<WFStepDTO> create(@RequestBody WFStepDTO wfstepdto) {
        WFStep domain = wfstepMapping.toDomain(wfstepdto);
		wfstepService.create(domain);
        WFStepDTO dto = wfstepMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"WFStep" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfsteps/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WFStepDTO> wfstepdtos) {
        wfstepService.createBatch(wfstepMapping.toDomain(wfstepdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"WFStep" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/wfsteps/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WFStepDTO wfstepdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wfstepService.checkKey(wfstepMapping.toDomain(wfstepdto)));
    }




    @ApiOperation(value = "Save", tags = {"WFStep" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/wfsteps/save")
    public ResponseEntity<Boolean> save(@RequestBody WFStepDTO wfstepdto) {
        return ResponseEntity.status(HttpStatus.OK).body(wfstepService.save(wfstepMapping.toDomain(wfstepdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"WFStep" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfsteps/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WFStepDTO> wfstepdtos) {
        wfstepService.saveBatch(wfstepMapping.toDomain(wfstepdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#wfstep_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"WFStep" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfsteps/{wfstep_id}")
    @Transactional
    public ResponseEntity<WFStepDTO> update(@PathVariable("wfstep_id") String wfstep_id, @RequestBody WFStepDTO wfstepdto) {
		WFStep domain = wfstepMapping.toDomain(wfstepdto);
        domain.setWfstepid(wfstep_id);
		wfstepService.update(domain);
		WFStepDTO dto = wfstepMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#wfstep_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"WFStep" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfsteps/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WFStepDTO> wfstepdtos) {
        wfstepService.updateBatch(wfstepMapping.toDomain(wfstepdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFStep-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"WFStep" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfsteps/fetchdefault")
	public ResponseEntity<List<WFStepDTO>> fetchDefault(WFStepSearchContext context) {
        Page<WFStep> domains = wfstepService.searchDefault(context) ;
        List<WFStepDTO> list = wfstepMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFStep-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"WFStep" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/wfsteps/searchdefault")
	public ResponseEntity<Page<WFStepDTO>> searchDefault(@RequestBody WFStepSearchContext context) {
        Page<WFStep> domains = wfstepService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfstepMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public WFStep getEntity(){
        return new WFStep();
    }

}
