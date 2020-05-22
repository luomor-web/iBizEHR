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
import cn.ibizlab.ehr.core.trm.domain.TRMSTAFFNODES;
import cn.ibizlab.ehr.core.trm.service.ITRMSTAFFNODESService;
import cn.ibizlab.ehr.core.trm.filter.TRMSTAFFNODESSearchContext;




@Slf4j
@Api(tags = {"TRMSTAFFNODES" })
@RestController("WebApi-trmstaffnodes")
@RequestMapping("")
public class TRMSTAFFNODESResource {

    @Autowired
    private ITRMSTAFFNODESService trmstaffnodesService;

    @Autowired
    @Lazy
    public TRMSTAFFNODESMapping trmstaffnodesMapping;

    public TRMSTAFFNODESDTO permissionDTO=new TRMSTAFFNODESDTO();

    @PreAuthorize("hasPermission(#trmstaffnodes_id,'Remove',{'Sql',this.trmstaffnodesMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"TRMSTAFFNODES" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmstaffnodes/{trmstaffnodes_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmstaffnodes_id") String trmstaffnodes_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmstaffnodesService.remove(trmstaffnodes_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"TRMSTAFFNODES" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmstaffnodes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmstaffnodesService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#trmstaffnodes_id,'Get',{'Sql',this.trmstaffnodesMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"TRMSTAFFNODES" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmstaffnodes/{trmstaffnodes_id}")
    public ResponseEntity<TRMSTAFFNODESDTO> get(@PathVariable("trmstaffnodes_id") String trmstaffnodes_id) {
        TRMSTAFFNODES domain = trmstaffnodesService.get(trmstaffnodes_id);
        TRMSTAFFNODESDTO dto = trmstaffnodesMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMSTAFFNODES-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"TRMSTAFFNODES" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmstaffnodes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMSTAFFNODESDTO trmstaffnodesdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmstaffnodesService.checkKey(trmstaffnodesMapping.toDomain(trmstaffnodesdto)));
    }

    @PreAuthorize("hasPermission(#trmstaffnodes_id,'Update',{'Sql',this.trmstaffnodesMapping,#trmstaffnodesdto})")
    @ApiOperation(value = "Update", tags = {"TRMSTAFFNODES" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmstaffnodes/{trmstaffnodes_id}")
    @Transactional
    public ResponseEntity<TRMSTAFFNODESDTO> update(@PathVariable("trmstaffnodes_id") String trmstaffnodes_id, @RequestBody TRMSTAFFNODESDTO trmstaffnodesdto) {
		TRMSTAFFNODES domain = trmstaffnodesMapping.toDomain(trmstaffnodesdto);
        domain.setTrmstaffnodesid(trmstaffnodes_id);
		trmstaffnodesService.update(domain);
		TRMSTAFFNODESDTO dto = trmstaffnodesMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"TRMSTAFFNODES" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmstaffnodes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMSTAFFNODESDTO> trmstaffnodesdtos) {
        trmstaffnodesService.updateBatch(trmstaffnodesMapping.toDomain(trmstaffnodesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMSTAFFNODES-Save-all')")
    @ApiOperation(value = "Save", tags = {"TRMSTAFFNODES" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmstaffnodes/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMSTAFFNODESDTO trmstaffnodesdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmstaffnodesService.save(trmstaffnodesMapping.toDomain(trmstaffnodesdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"TRMSTAFFNODES" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmstaffnodes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMSTAFFNODESDTO> trmstaffnodesdtos) {
        trmstaffnodesService.saveBatch(trmstaffnodesMapping.toDomain(trmstaffnodesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMSTAFFNODES-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"TRMSTAFFNODES" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmstaffnodes/getdraft")
    public ResponseEntity<TRMSTAFFNODESDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmstaffnodesMapping.toDto(trmstaffnodesService.getDraft(new TRMSTAFFNODES())));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.trmstaffnodesMapping,#trmstaffnodesdto})")
    @ApiOperation(value = "Create", tags = {"TRMSTAFFNODES" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmstaffnodes")
    @Transactional
    public ResponseEntity<TRMSTAFFNODESDTO> create(@RequestBody TRMSTAFFNODESDTO trmstaffnodesdto) {
        TRMSTAFFNODES domain = trmstaffnodesMapping.toDomain(trmstaffnodesdto);
		trmstaffnodesService.create(domain);
        TRMSTAFFNODESDTO dto = trmstaffnodesMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"TRMSTAFFNODES" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmstaffnodes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMSTAFFNODESDTO> trmstaffnodesdtos) {
        trmstaffnodesService.createBatch(trmstaffnodesMapping.toDomain(trmstaffnodesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMSTAFFNODES-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TRMSTAFFNODES" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmstaffnodes/fetchdefault")
	public ResponseEntity<List<TRMSTAFFNODESDTO>> fetchDefault(TRMSTAFFNODESSearchContext context) {
        Page<TRMSTAFFNODES> domains = trmstaffnodesService.searchDefault(context) ;
        List<TRMSTAFFNODESDTO> list = trmstaffnodesMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMSTAFFNODES-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TRMSTAFFNODES" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmstaffnodes/searchdefault")
	public ResponseEntity<Page<TRMSTAFFNODESDTO>> searchDefault(@RequestBody TRMSTAFFNODESSearchContext context) {
        Page<TRMSTAFFNODES> domains = trmstaffnodesService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmstaffnodesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
