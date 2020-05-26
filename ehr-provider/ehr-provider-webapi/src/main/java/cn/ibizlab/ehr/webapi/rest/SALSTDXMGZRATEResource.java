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
import cn.ibizlab.ehr.core.sal.domain.SALSTDXMGZRATE;
import cn.ibizlab.ehr.core.sal.service.ISALSTDXMGZRATEService;
import cn.ibizlab.ehr.core.sal.filter.SALSTDXMGZRATESearchContext;

@Slf4j
@Api(tags = {"SALSTDXMGZRATE" })
@RestController("WebApi-salstdxmgzrate")
@RequestMapping("")
public class SALSTDXMGZRATEResource {

    @Autowired
    private ISALSTDXMGZRATEService salstdxmgzrateService;

    @Autowired
    @Lazy
    public SALSTDXMGZRATEMapping salstdxmgzrateMapping;

    public SALSTDXMGZRATEDTO permissionDTO=new SALSTDXMGZRATEDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDXMGZRATE-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"SALSTDXMGZRATE" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdxmgzrates/getdraft")
    public ResponseEntity<SALSTDXMGZRATEDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salstdxmgzrateMapping.toDto(salstdxmgzrateService.getDraft(new SALSTDXMGZRATE())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDXMGZRATE-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"SALSTDXMGZRATE" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdxmgzrates/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SALSTDXMGZRATEDTO salstdxmgzratedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salstdxmgzrateService.checkKey(salstdxmgzrateMapping.toDomain(salstdxmgzratedto)));
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.salstdxmgzrateMapping,#salstdxmgzratedto})")
    @ApiOperation(value = "Save", tags = {"SALSTDXMGZRATE" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdxmgzrates/save")
    public ResponseEntity<Boolean> save(@RequestBody SALSTDXMGZRATEDTO salstdxmgzratedto) {
        return ResponseEntity.status(HttpStatus.OK).body(salstdxmgzrateService.save(salstdxmgzrateMapping.toDomain(salstdxmgzratedto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.salstdxmgzrateMapping,#salstdxmgzratedtos})")
    @ApiOperation(value = "SaveBatch", tags = {"SALSTDXMGZRATE" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdxmgzrates/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SALSTDXMGZRATEDTO> salstdxmgzratedtos) {
        salstdxmgzrateService.saveBatch(salstdxmgzrateMapping.toDomain(salstdxmgzratedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.salstdxmgzrateMapping,#salstdxmgzratedto})")
    @ApiOperation(value = "Create", tags = {"SALSTDXMGZRATE" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdxmgzrates")
    @Transactional
    public ResponseEntity<SALSTDXMGZRATEDTO> create(@RequestBody SALSTDXMGZRATEDTO salstdxmgzratedto) {
        SALSTDXMGZRATE domain = salstdxmgzrateMapping.toDomain(salstdxmgzratedto);
		salstdxmgzrateService.create(domain);
        SALSTDXMGZRATEDTO dto = salstdxmgzrateMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.salstdxmgzrateMapping,#salstdxmgzratedtos})")
    @ApiOperation(value = "createBatch", tags = {"SALSTDXMGZRATE" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdxmgzrates/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SALSTDXMGZRATEDTO> salstdxmgzratedtos) {
        salstdxmgzrateService.createBatch(salstdxmgzrateMapping.toDomain(salstdxmgzratedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#salstdxmgzrate_id,'Remove',{'Sql',this.salstdxmgzrateMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"SALSTDXMGZRATE" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdxmgzrates/{salstdxmgzrate_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salstdxmgzrate_id") String salstdxmgzrate_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salstdxmgzrateService.remove(salstdxmgzrate_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.salstdxmgzrateMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"SALSTDXMGZRATE" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdxmgzrates/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salstdxmgzrateService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#salstdxmgzrate_id,'Get',{'Sql',this.salstdxmgzrateMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"SALSTDXMGZRATE" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdxmgzrates/{salstdxmgzrate_id}")
    public ResponseEntity<SALSTDXMGZRATEDTO> get(@PathVariable("salstdxmgzrate_id") String salstdxmgzrate_id) {
        SALSTDXMGZRATE domain = salstdxmgzrateService.get(salstdxmgzrate_id);
        SALSTDXMGZRATEDTO dto = salstdxmgzrateMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#salstdxmgzrate_id,'Update',{'Sql',this.salstdxmgzrateMapping,#salstdxmgzratedto})")
    @ApiOperation(value = "Update", tags = {"SALSTDXMGZRATE" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdxmgzrates/{salstdxmgzrate_id}")
    @Transactional
    public ResponseEntity<SALSTDXMGZRATEDTO> update(@PathVariable("salstdxmgzrate_id") String salstdxmgzrate_id, @RequestBody SALSTDXMGZRATEDTO salstdxmgzratedto) {
		SALSTDXMGZRATE domain  = salstdxmgzrateMapping.toDomain(salstdxmgzratedto);
        domain .setSalstdxmgzrateid(salstdxmgzrate_id);
		salstdxmgzrateService.update(domain );
		SALSTDXMGZRATEDTO dto = salstdxmgzrateMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.salstdxmgzrateMapping,#salstdxmgzratedtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"SALSTDXMGZRATE" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdxmgzrates/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SALSTDXMGZRATEDTO> salstdxmgzratedtos) {
        salstdxmgzrateService.updateBatch(salstdxmgzrateMapping.toDomain(salstdxmgzratedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDXMGZRATE-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SALSTDXMGZRATE" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salstdxmgzrates/fetchdefault")
	public ResponseEntity<List<SALSTDXMGZRATEDTO>> fetchDefault(SALSTDXMGZRATESearchContext context) {
        Page<SALSTDXMGZRATE> domains = salstdxmgzrateService.searchDefault(context) ;
        List<SALSTDXMGZRATEDTO> list = salstdxmgzrateMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDXMGZRATE-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SALSTDXMGZRATE" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salstdxmgzrates/searchdefault")
	public ResponseEntity<Page<SALSTDXMGZRATEDTO>> searchDefault(@RequestBody SALSTDXMGZRATESearchContext context) {
        Page<SALSTDXMGZRATE> domains = salstdxmgzrateService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salstdxmgzrateMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
