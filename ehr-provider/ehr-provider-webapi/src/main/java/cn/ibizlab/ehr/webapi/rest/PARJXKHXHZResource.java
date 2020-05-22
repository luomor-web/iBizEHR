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
import cn.ibizlab.ehr.core.par.domain.PARJXKHXHZ;
import cn.ibizlab.ehr.core.par.service.IPARJXKHXHZService;
import cn.ibizlab.ehr.core.par.filter.PARJXKHXHZSearchContext;




@Slf4j
@Api(tags = {"PARJXKHXHZ" })
@RestController("WebApi-parjxkhxhz")
@RequestMapping("")
public class PARJXKHXHZResource {

    @Autowired
    private IPARJXKHXHZService parjxkhxhzService;

    @Autowired
    @Lazy
    public PARJXKHXHZMapping parjxkhxhzMapping;

    public PARJXKHXHZDTO permissionDTO=new PARJXKHXHZDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXKHXHZ-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PARJXKHXHZ" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxkhxhzs/getdraft")
    public ResponseEntity<PARJXKHXHZDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parjxkhxhzMapping.toDto(parjxkhxhzService.getDraft(new PARJXKHXHZ())));
    }

    @PreAuthorize("hasPermission(#parjxkhxhz_id,'Update',{'Sql',this.parjxkhxhzMapping,#parjxkhxhzdto})")
    @ApiOperation(value = "Update", tags = {"PARJXKHXHZ" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxkhxhzs/{parjxkhxhz_id}")
    @Transactional
    public ResponseEntity<PARJXKHXHZDTO> update(@PathVariable("parjxkhxhz_id") String parjxkhxhz_id, @RequestBody PARJXKHXHZDTO parjxkhxhzdto) {
		PARJXKHXHZ domain = parjxkhxhzMapping.toDomain(parjxkhxhzdto);
        domain.setParjxkhxhzid(parjxkhxhz_id);
		parjxkhxhzService.update(domain);
		PARJXKHXHZDTO dto = parjxkhxhzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PARJXKHXHZ" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxkhxhzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARJXKHXHZDTO> parjxkhxhzdtos) {
        parjxkhxhzService.updateBatch(parjxkhxhzMapping.toDomain(parjxkhxhzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXKHXHZ-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PARJXKHXHZ" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhxhzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARJXKHXHZDTO parjxkhxhzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parjxkhxhzService.checkKey(parjxkhxhzMapping.toDomain(parjxkhxhzdto)));
    }

    @PreAuthorize("hasPermission(#parjxkhxhz_id,'Get',{'Sql',this.parjxkhxhzMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PARJXKHXHZ" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxkhxhzs/{parjxkhxhz_id}")
    public ResponseEntity<PARJXKHXHZDTO> get(@PathVariable("parjxkhxhz_id") String parjxkhxhz_id) {
        PARJXKHXHZ domain = parjxkhxhzService.get(parjxkhxhz_id);
        PARJXKHXHZDTO dto = parjxkhxhzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#parjxkhxhz_id,'Remove',{'Sql',this.parjxkhxhzMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PARJXKHXHZ" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxkhxhzs/{parjxkhxhz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parjxkhxhz_id") String parjxkhxhz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parjxkhxhzService.remove(parjxkhxhz_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PARJXKHXHZ" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxkhxhzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parjxkhxhzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.parjxkhxhzMapping,#parjxkhxhzdto})")
    @ApiOperation(value = "Create", tags = {"PARJXKHXHZ" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhxhzs")
    @Transactional
    public ResponseEntity<PARJXKHXHZDTO> create(@RequestBody PARJXKHXHZDTO parjxkhxhzdto) {
        PARJXKHXHZ domain = parjxkhxhzMapping.toDomain(parjxkhxhzdto);
		parjxkhxhzService.create(domain);
        PARJXKHXHZDTO dto = parjxkhxhzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"PARJXKHXHZ" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhxhzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARJXKHXHZDTO> parjxkhxhzdtos) {
        parjxkhxhzService.createBatch(parjxkhxhzMapping.toDomain(parjxkhxhzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXKHXHZ-Save-all')")
    @ApiOperation(value = "Save", tags = {"PARJXKHXHZ" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhxhzs/save")
    public ResponseEntity<Boolean> save(@RequestBody PARJXKHXHZDTO parjxkhxhzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parjxkhxhzService.save(parjxkhxhzMapping.toDomain(parjxkhxhzdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PARJXKHXHZ" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhxhzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARJXKHXHZDTO> parjxkhxhzdtos) {
        parjxkhxhzService.saveBatch(parjxkhxhzMapping.toDomain(parjxkhxhzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXKHXHZ-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PARJXKHXHZ" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parjxkhxhzs/fetchdefault")
	public ResponseEntity<List<PARJXKHXHZDTO>> fetchDefault(PARJXKHXHZSearchContext context) {
        Page<PARJXKHXHZ> domains = parjxkhxhzService.searchDefault(context) ;
        List<PARJXKHXHZDTO> list = parjxkhxhzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXKHXHZ-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PARJXKHXHZ" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parjxkhxhzs/searchdefault")
	public ResponseEntity<Page<PARJXKHXHZDTO>> searchDefault(@RequestBody PARJXKHXHZSearchContext context) {
        Page<PARJXKHXHZ> domains = parjxkhxhzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjxkhxhzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
