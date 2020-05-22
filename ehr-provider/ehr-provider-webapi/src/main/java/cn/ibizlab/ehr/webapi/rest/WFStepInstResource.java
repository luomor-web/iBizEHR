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
import cn.ibizlab.ehr.core.wf.domain.WFStepInst;
import cn.ibizlab.ehr.core.wf.service.IWFStepInstService;
import cn.ibizlab.ehr.core.wf.filter.WFStepInstSearchContext;




@Slf4j
@Api(tags = {"WFStepInst" })
@RestController("WebApi-wfstepinst")
@RequestMapping("")
public class WFStepInstResource {

    @Autowired
    private IWFStepInstService wfstepinstService;

    @Autowired
    @Lazy
    public WFStepInstMapping wfstepinstMapping;

    public WFStepInstDTO permissionDTO=new WFStepInstDTO();

    @PreAuthorize("hasPermission(#wfstepinst_id,'Update',{'Sql',this.wfstepinstMapping,#wfstepinstdto})")
    @ApiOperation(value = "Update", tags = {"WFStepInst" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfstepinsts/{wfstepinst_id}")
    @Transactional
    public ResponseEntity<WFStepInstDTO> update(@PathVariable("wfstepinst_id") String wfstepinst_id, @RequestBody WFStepInstDTO wfstepinstdto) {
		WFStepInst domain = wfstepinstMapping.toDomain(wfstepinstdto);
        domain.setWfstepinstid(wfstepinst_id);
		wfstepinstService.update(domain);
		WFStepInstDTO dto = wfstepinstMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"WFStepInst" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfstepinsts/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WFStepInstDTO> wfstepinstdtos) {
        wfstepinstService.updateBatch(wfstepinstMapping.toDomain(wfstepinstdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFStepInst-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"WFStepInst" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/wfstepinsts/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WFStepInstDTO wfstepinstdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wfstepinstService.checkKey(wfstepinstMapping.toDomain(wfstepinstdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFStepInst-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"WFStepInst" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/wfstepinsts/getdraft")
    public ResponseEntity<WFStepInstDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wfstepinstMapping.toDto(wfstepinstService.getDraft(new WFStepInst())));
    }

    @PreAuthorize("hasPermission(#wfstepinst_id,'Get',{'Sql',this.wfstepinstMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"WFStepInst" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/wfstepinsts/{wfstepinst_id}")
    public ResponseEntity<WFStepInstDTO> get(@PathVariable("wfstepinst_id") String wfstepinst_id) {
        WFStepInst domain = wfstepinstService.get(wfstepinst_id);
        WFStepInstDTO dto = wfstepinstMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFStepInst-Save-all')")
    @ApiOperation(value = "Save", tags = {"WFStepInst" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/wfstepinsts/save")
    public ResponseEntity<Boolean> save(@RequestBody WFStepInstDTO wfstepinstdto) {
        return ResponseEntity.status(HttpStatus.OK).body(wfstepinstService.save(wfstepinstMapping.toDomain(wfstepinstdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"WFStepInst" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfstepinsts/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WFStepInstDTO> wfstepinstdtos) {
        wfstepinstService.saveBatch(wfstepinstMapping.toDomain(wfstepinstdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.wfstepinstMapping,#wfstepinstdto})")
    @ApiOperation(value = "Create", tags = {"WFStepInst" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/wfstepinsts")
    @Transactional
    public ResponseEntity<WFStepInstDTO> create(@RequestBody WFStepInstDTO wfstepinstdto) {
        WFStepInst domain = wfstepinstMapping.toDomain(wfstepinstdto);
		wfstepinstService.create(domain);
        WFStepInstDTO dto = wfstepinstMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"WFStepInst" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wfstepinsts/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WFStepInstDTO> wfstepinstdtos) {
        wfstepinstService.createBatch(wfstepinstMapping.toDomain(wfstepinstdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#wfstepinst_id,'Remove',{'Sql',this.wfstepinstMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"WFStepInst" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfstepinsts/{wfstepinst_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("wfstepinst_id") String wfstepinst_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wfstepinstService.remove(wfstepinst_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"WFStepInst" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfstepinsts/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wfstepinstService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFStepInst-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"WFStepInst" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfstepinsts/fetchdefault")
	public ResponseEntity<List<WFStepInstDTO>> fetchDefault(WFStepInstSearchContext context) {
        Page<WFStepInst> domains = wfstepinstService.searchDefault(context) ;
        List<WFStepInstDTO> list = wfstepinstMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFStepInst-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"WFStepInst" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/wfstepinsts/searchdefault")
	public ResponseEntity<Page<WFStepInstDTO>> searchDefault(@RequestBody WFStepInstSearchContext context) {
        Page<WFStepInst> domains = wfstepinstService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfstepinstMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
