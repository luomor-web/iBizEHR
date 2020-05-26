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
import cn.ibizlab.ehr.core.sal.domain.SALSTDGL;
import cn.ibizlab.ehr.core.sal.service.ISALSTDGLService;
import cn.ibizlab.ehr.core.sal.filter.SALSTDGLSearchContext;

@Slf4j
@Api(tags = {"SALSTDGL" })
@RestController("WebApi-salstdgl")
@RequestMapping("")
public class SALSTDGLResource {

    @Autowired
    private ISALSTDGLService salstdglService;

    @Autowired
    @Lazy
    public SALSTDGLMapping salstdglMapping;

    public SALSTDGLDTO permissionDTO=new SALSTDGLDTO();

    @PreAuthorize("hasPermission(#salstdgl_id,'Remove',{'Sql',this.salstdglMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"SALSTDGL" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdgls/{salstdgl_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salstdgl_id") String salstdgl_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salstdglService.remove(salstdgl_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.salstdglMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"SALSTDGL" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdgls/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salstdglService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#salstdgl_id,'Update',{'Sql',this.salstdglMapping,#salstdgldto})")
    @ApiOperation(value = "Update", tags = {"SALSTDGL" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdgls/{salstdgl_id}")
    @Transactional
    public ResponseEntity<SALSTDGLDTO> update(@PathVariable("salstdgl_id") String salstdgl_id, @RequestBody SALSTDGLDTO salstdgldto) {
		SALSTDGL domain  = salstdglMapping.toDomain(salstdgldto);
        domain .setSalstdglid(salstdgl_id);
		salstdglService.update(domain );
		SALSTDGLDTO dto = salstdglMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.salstdglMapping,#salstdgldtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"SALSTDGL" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdgls/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SALSTDGLDTO> salstdgldtos) {
        salstdglService.updateBatch(salstdglMapping.toDomain(salstdgldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.salstdglMapping,#salstdgldto})")
    @ApiOperation(value = "Create", tags = {"SALSTDGL" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgls")
    @Transactional
    public ResponseEntity<SALSTDGLDTO> create(@RequestBody SALSTDGLDTO salstdgldto) {
        SALSTDGL domain = salstdglMapping.toDomain(salstdgldto);
		salstdglService.create(domain);
        SALSTDGLDTO dto = salstdglMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.salstdglMapping,#salstdgldtos})")
    @ApiOperation(value = "createBatch", tags = {"SALSTDGL" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgls/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SALSTDGLDTO> salstdgldtos) {
        salstdglService.createBatch(salstdglMapping.toDomain(salstdgldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDGL-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"SALSTDGL" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgls/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SALSTDGLDTO salstdgldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salstdglService.checkKey(salstdglMapping.toDomain(salstdgldto)));
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.salstdglMapping,#salstdgldto})")
    @ApiOperation(value = "Save", tags = {"SALSTDGL" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgls/save")
    public ResponseEntity<Boolean> save(@RequestBody SALSTDGLDTO salstdgldto) {
        return ResponseEntity.status(HttpStatus.OK).body(salstdglService.save(salstdglMapping.toDomain(salstdgldto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.salstdglMapping,#salstdgldtos})")
    @ApiOperation(value = "SaveBatch", tags = {"SALSTDGL" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgls/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SALSTDGLDTO> salstdgldtos) {
        salstdglService.saveBatch(salstdglMapping.toDomain(salstdgldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#salstdgl_id,'Get',{'Sql',this.salstdglMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"SALSTDGL" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdgls/{salstdgl_id}")
    public ResponseEntity<SALSTDGLDTO> get(@PathVariable("salstdgl_id") String salstdgl_id) {
        SALSTDGL domain = salstdglService.get(salstdgl_id);
        SALSTDGLDTO dto = salstdglMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDGL-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"SALSTDGL" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdgls/getdraft")
    public ResponseEntity<SALSTDGLDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salstdglMapping.toDto(salstdglService.getDraft(new SALSTDGL())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDGL-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SALSTDGL" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salstdgls/fetchdefault")
	public ResponseEntity<List<SALSTDGLDTO>> fetchDefault(SALSTDGLSearchContext context) {
        Page<SALSTDGL> domains = salstdglService.searchDefault(context) ;
        List<SALSTDGLDTO> list = salstdglMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDGL-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SALSTDGL" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salstdgls/searchdefault")
	public ResponseEntity<Page<SALSTDGLDTO>> searchDefault(@RequestBody SALSTDGLSearchContext context) {
        Page<SALSTDGL> domains = salstdglService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salstdglMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
