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
import cn.ibizlab.ehr.core.sal.domain.SALSTDZC;
import cn.ibizlab.ehr.core.sal.service.ISALSTDZCService;
import cn.ibizlab.ehr.core.sal.filter.SALSTDZCSearchContext;

@Slf4j
@Api(tags = {"SALSTDZC" })
@RestController("WebApi-salstdzc")
@RequestMapping("")
public class SALSTDZCResource {

    @Autowired
    private ISALSTDZCService salstdzcService;

    @Autowired
    @Lazy
    public SALSTDZCMapping salstdzcMapping;

    public SALSTDZCDTO permissionDTO=new SALSTDZCDTO();

    @PreAuthorize("hasPermission('','Create',{'Sql',this.salstdzcMapping,#salstdzcdto})")
    @ApiOperation(value = "Create", tags = {"SALSTDZC" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzcs")
    @Transactional
    public ResponseEntity<SALSTDZCDTO> create(@RequestBody SALSTDZCDTO salstdzcdto) {
        SALSTDZC domain = salstdzcMapping.toDomain(salstdzcdto);
		salstdzcService.create(domain);
        SALSTDZCDTO dto = salstdzcMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.salstdzcMapping,#salstdzcdtos})")
    @ApiOperation(value = "createBatch", tags = {"SALSTDZC" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzcs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SALSTDZCDTO> salstdzcdtos) {
        salstdzcService.createBatch(salstdzcMapping.toDomain(salstdzcdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#salstdzc_id,'Get',{'Sql',this.salstdzcMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"SALSTDZC" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdzcs/{salstdzc_id}")
    public ResponseEntity<SALSTDZCDTO> get(@PathVariable("salstdzc_id") String salstdzc_id) {
        SALSTDZC domain = salstdzcService.get(salstdzc_id);
        SALSTDZCDTO dto = salstdzcMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.salstdzcMapping,#salstdzcdto})")
    @ApiOperation(value = "Save", tags = {"SALSTDZC" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzcs/save")
    public ResponseEntity<Boolean> save(@RequestBody SALSTDZCDTO salstdzcdto) {
        return ResponseEntity.status(HttpStatus.OK).body(salstdzcService.save(salstdzcMapping.toDomain(salstdzcdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.salstdzcMapping,#salstdzcdtos})")
    @ApiOperation(value = "SaveBatch", tags = {"SALSTDZC" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzcs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SALSTDZCDTO> salstdzcdtos) {
        salstdzcService.saveBatch(salstdzcMapping.toDomain(salstdzcdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDZC-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"SALSTDZC" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdzcs/getdraft")
    public ResponseEntity<SALSTDZCDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salstdzcMapping.toDto(salstdzcService.getDraft(new SALSTDZC())));
    }

    @PreAuthorize("hasPermission(#salstdzc_id,'Remove',{'Sql',this.salstdzcMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"SALSTDZC" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdzcs/{salstdzc_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salstdzc_id") String salstdzc_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salstdzcService.remove(salstdzc_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.salstdzcMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"SALSTDZC" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdzcs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salstdzcService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#salstdzc_id,'Update',{'Sql',this.salstdzcMapping,#salstdzcdto})")
    @ApiOperation(value = "Update", tags = {"SALSTDZC" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdzcs/{salstdzc_id}")
    @Transactional
    public ResponseEntity<SALSTDZCDTO> update(@PathVariable("salstdzc_id") String salstdzc_id, @RequestBody SALSTDZCDTO salstdzcdto) {
		SALSTDZC domain  = salstdzcMapping.toDomain(salstdzcdto);
        domain .setSalstdzcid(salstdzc_id);
		salstdzcService.update(domain );
		SALSTDZCDTO dto = salstdzcMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.salstdzcMapping,#salstdzcdtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"SALSTDZC" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdzcs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SALSTDZCDTO> salstdzcdtos) {
        salstdzcService.updateBatch(salstdzcMapping.toDomain(salstdzcdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDZC-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"SALSTDZC" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzcs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SALSTDZCDTO salstdzcdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salstdzcService.checkKey(salstdzcMapping.toDomain(salstdzcdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDZC-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SALSTDZC" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salstdzcs/fetchdefault")
	public ResponseEntity<List<SALSTDZCDTO>> fetchDefault(SALSTDZCSearchContext context) {
        Page<SALSTDZC> domains = salstdzcService.searchDefault(context) ;
        List<SALSTDZCDTO> list = salstdzcMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDZC-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SALSTDZC" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salstdzcs/searchdefault")
	public ResponseEntity<Page<SALSTDZCDTO>> searchDefault(@RequestBody SALSTDZCSearchContext context) {
        Page<SALSTDZC> domains = salstdzcService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salstdzcMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
