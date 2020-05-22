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
import cn.ibizlab.ehr.core.trm.domain.TRMTRAINPLAN;
import cn.ibizlab.ehr.core.trm.service.ITRMTRAINPLANService;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINPLANSearchContext;




@Slf4j
@Api(tags = {"TRMTRAINPLAN" })
@RestController("WebApi-trmtrainplan")
@RequestMapping("")
public class TRMTRAINPLANResource {

    @Autowired
    private ITRMTRAINPLANService trmtrainplanService;

    @Autowired
    @Lazy
    public TRMTRAINPLANMapping trmtrainplanMapping;

    public TRMTRAINPLANDTO permissionDTO=new TRMTRAINPLANDTO();

    @PreAuthorize("hasPermission(#trmtrainplan_id,'Remove',{'Sql',this.trmtrainplanMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"TRMTRAINPLAN" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainplans/{trmtrainplan_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtrainplan_id") String trmtrainplan_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtrainplanService.remove(trmtrainplan_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"TRMTRAINPLAN" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainplans/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtrainplanService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINPLAN-Save-all')")
    @ApiOperation(value = "Save", tags = {"TRMTRAINPLAN" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplans/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMTRAINPLANDTO trmtrainplandto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplanService.save(trmtrainplanMapping.toDomain(trmtrainplandto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"TRMTRAINPLAN" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplans/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMTRAINPLANDTO> trmtrainplandtos) {
        trmtrainplanService.saveBatch(trmtrainplanMapping.toDomain(trmtrainplandtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINPLAN-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"TRMTRAINPLAN" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainplans/getdraft")
    public ResponseEntity<TRMTRAINPLANDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplanMapping.toDto(trmtrainplanService.getDraft(new TRMTRAINPLAN())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINPLAN-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"TRMTRAINPLAN" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplans/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMTRAINPLANDTO trmtrainplandto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainplanService.checkKey(trmtrainplanMapping.toDomain(trmtrainplandto)));
    }

    @PreAuthorize("hasPermission(#trmtrainplan_id,'Get',{'Sql',this.trmtrainplanMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"TRMTRAINPLAN" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainplans/{trmtrainplan_id}")
    public ResponseEntity<TRMTRAINPLANDTO> get(@PathVariable("trmtrainplan_id") String trmtrainplan_id) {
        TRMTRAINPLAN domain = trmtrainplanService.get(trmtrainplan_id);
        TRMTRAINPLANDTO dto = trmtrainplanMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.trmtrainplanMapping,#trmtrainplandto})")
    @ApiOperation(value = "Create", tags = {"TRMTRAINPLAN" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplans")
    @Transactional
    public ResponseEntity<TRMTRAINPLANDTO> create(@RequestBody TRMTRAINPLANDTO trmtrainplandto) {
        TRMTRAINPLAN domain = trmtrainplanMapping.toDomain(trmtrainplandto);
		trmtrainplanService.create(domain);
        TRMTRAINPLANDTO dto = trmtrainplanMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"TRMTRAINPLAN" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplans/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMTRAINPLANDTO> trmtrainplandtos) {
        trmtrainplanService.createBatch(trmtrainplanMapping.toDomain(trmtrainplandtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#trmtrainplan_id,'Update',{'Sql',this.trmtrainplanMapping,#trmtrainplandto})")
    @ApiOperation(value = "Update", tags = {"TRMTRAINPLAN" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainplans/{trmtrainplan_id}")
    @Transactional
    public ResponseEntity<TRMTRAINPLANDTO> update(@PathVariable("trmtrainplan_id") String trmtrainplan_id, @RequestBody TRMTRAINPLANDTO trmtrainplandto) {
		TRMTRAINPLAN domain = trmtrainplanMapping.toDomain(trmtrainplandto);
        domain.setTrmtrainplanid(trmtrainplan_id);
		trmtrainplanService.update(domain);
		TRMTRAINPLANDTO dto = trmtrainplanMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"TRMTRAINPLAN" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainplans/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMTRAINPLANDTO> trmtrainplandtos) {
        trmtrainplanService.updateBatch(trmtrainplanMapping.toDomain(trmtrainplandtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINPLAN-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TRMTRAINPLAN" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainplans/fetchdefault")
	public ResponseEntity<List<TRMTRAINPLANDTO>> fetchDefault(TRMTRAINPLANSearchContext context) {
        Page<TRMTRAINPLAN> domains = trmtrainplanService.searchDefault(context) ;
        List<TRMTRAINPLANDTO> list = trmtrainplanMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINPLAN-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TRMTRAINPLAN" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainplans/searchdefault")
	public ResponseEntity<Page<TRMTRAINPLANDTO>> searchDefault(@RequestBody TRMTRAINPLANSearchContext context) {
        Page<TRMTRAINPLAN> domains = trmtrainplanService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainplanMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
