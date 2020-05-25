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
import cn.ibizlab.ehr.core.par.domain.PARJXKHJCSZ;
import cn.ibizlab.ehr.core.par.service.IPARJXKHJCSZService;
import cn.ibizlab.ehr.core.par.filter.PARJXKHJCSZSearchContext;

@Slf4j
@Api(tags = {"PARJXKHJCSZ" })
@RestController("WebApi-parjxkhjcsz")
@RequestMapping("")
public class PARJXKHJCSZResource {

    @Autowired
    private IPARJXKHJCSZService parjxkhjcszService;

    @Autowired
    @Lazy
    public PARJXKHJCSZMapping parjxkhjcszMapping;

    public PARJXKHJCSZDTO permissionDTO=new PARJXKHJCSZDTO();

    @PreAuthorize("hasPermission(#parjxkhjcsz_id,'Update',{'Sql',this.parjxkhjcszMapping,#parjxkhjcszdto})")
    @ApiOperation(value = "Update", tags = {"PARJXKHJCSZ" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxkhjcszs/{parjxkhjcsz_id}")
    @Transactional
    public ResponseEntity<PARJXKHJCSZDTO> update(@PathVariable("parjxkhjcsz_id") String parjxkhjcsz_id, @RequestBody PARJXKHJCSZDTO parjxkhjcszdto) {
		PARJXKHJCSZ domain = parjxkhjcszMapping.toDomain(parjxkhjcszdto);
        domain.setParjxkhjcszid(parjxkhjcsz_id);
		parjxkhjcszService.update(domain);
		PARJXKHJCSZDTO dto = parjxkhjcszMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PARJXKHJCSZ" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxkhjcszs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARJXKHJCSZDTO> parjxkhjcszdtos) {
        parjxkhjcszService.updateBatch(parjxkhjcszMapping.toDomain(parjxkhjcszdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXKHJCSZ-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PARJXKHJCSZ" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxkhjcszs/getdraft")
    public ResponseEntity<PARJXKHJCSZDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parjxkhjcszMapping.toDto(parjxkhjcszService.getDraft(new PARJXKHJCSZ())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXKHJCSZ-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PARJXKHJCSZ" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhjcszs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARJXKHJCSZDTO parjxkhjcszdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parjxkhjcszService.checkKey(parjxkhjcszMapping.toDomain(parjxkhjcszdto)));
    }

    @PreAuthorize("hasPermission(#parjxkhjcsz_id,'Remove',{'Sql',this.parjxkhjcszMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PARJXKHJCSZ" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxkhjcszs/{parjxkhjcsz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parjxkhjcsz_id") String parjxkhjcsz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parjxkhjcszService.remove(parjxkhjcsz_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PARJXKHJCSZ" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxkhjcszs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parjxkhjcszService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.parjxkhjcszMapping,#parjxkhjcszdto})")
    @ApiOperation(value = "Save", tags = {"PARJXKHJCSZ" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhjcszs/save")
    public ResponseEntity<Boolean> save(@RequestBody PARJXKHJCSZDTO parjxkhjcszdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parjxkhjcszService.save(parjxkhjcszMapping.toDomain(parjxkhjcszdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PARJXKHJCSZ" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhjcszs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARJXKHJCSZDTO> parjxkhjcszdtos) {
        parjxkhjcszService.saveBatch(parjxkhjcszMapping.toDomain(parjxkhjcszdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.parjxkhjcszMapping,#parjxkhjcszdto})")
    @ApiOperation(value = "Create", tags = {"PARJXKHJCSZ" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhjcszs")
    @Transactional
    public ResponseEntity<PARJXKHJCSZDTO> create(@RequestBody PARJXKHJCSZDTO parjxkhjcszdto) {
        PARJXKHJCSZ domain = parjxkhjcszMapping.toDomain(parjxkhjcszdto);
		parjxkhjcszService.create(domain);
        PARJXKHJCSZDTO dto = parjxkhjcszMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"PARJXKHJCSZ" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhjcszs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARJXKHJCSZDTO> parjxkhjcszdtos) {
        parjxkhjcszService.createBatch(parjxkhjcszMapping.toDomain(parjxkhjcszdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#parjxkhjcsz_id,'Get',{'Sql',this.parjxkhjcszMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PARJXKHJCSZ" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxkhjcszs/{parjxkhjcsz_id}")
    public ResponseEntity<PARJXKHJCSZDTO> get(@PathVariable("parjxkhjcsz_id") String parjxkhjcsz_id) {
        PARJXKHJCSZ domain = parjxkhjcszService.get(parjxkhjcsz_id);
        PARJXKHJCSZDTO dto = parjxkhjcszMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXKHJCSZ-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PARJXKHJCSZ" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parjxkhjcszs/fetchdefault")
	public ResponseEntity<List<PARJXKHJCSZDTO>> fetchDefault(PARJXKHJCSZSearchContext context) {
        Page<PARJXKHJCSZ> domains = parjxkhjcszService.searchDefault(context) ;
        List<PARJXKHJCSZDTO> list = parjxkhjcszMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXKHJCSZ-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PARJXKHJCSZ" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parjxkhjcszs/searchdefault")
	public ResponseEntity<Page<PARJXKHJCSZDTO>> searchDefault(@RequestBody PARJXKHJCSZSearchContext context) {
        Page<PARJXKHJCSZ> domains = parjxkhjcszService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjxkhjcszMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
