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
import cn.ibizlab.ehr.core.sal.domain.SALTYPE;
import cn.ibizlab.ehr.core.sal.service.ISALTYPEService;
import cn.ibizlab.ehr.core.sal.filter.SALTYPESearchContext;

@Slf4j
@Api(tags = {"SALTYPE" })
@RestController("WebApi-saltype")
@RequestMapping("")
public class SALTYPEResource {

    @Autowired
    private ISALTYPEService saltypeService;

    @Autowired
    @Lazy
    public SALTYPEMapping saltypeMapping;

    public SALTYPEDTO permissionDTO=new SALTYPEDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALTYPE-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"SALTYPE" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/saltypes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SALTYPEDTO saltypedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(saltypeService.checkKey(saltypeMapping.toDomain(saltypedto)));
    }

    @PreAuthorize("hasPermission(#saltype_id,'Get',{'Sql',this.saltypeMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"SALTYPE" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/saltypes/{saltype_id}")
    public ResponseEntity<SALTYPEDTO> get(@PathVariable("saltype_id") String saltype_id) {
        SALTYPE domain = saltypeService.get(saltype_id);
        SALTYPEDTO dto = saltypeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALTYPE-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"SALTYPE" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/saltypes/getdraft")
    public ResponseEntity<SALTYPEDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(saltypeMapping.toDto(saltypeService.getDraft(new SALTYPE())));
    }

    @PreAuthorize("hasPermission(#saltype_id,'Remove',{'Sql',this.saltypeMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"SALTYPE" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/saltypes/{saltype_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("saltype_id") String saltype_id) {
         return ResponseEntity.status(HttpStatus.OK).body(saltypeService.remove(saltype_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"SALTYPE" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/saltypes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        saltypeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.saltypeMapping,#saltypedto})")
    @ApiOperation(value = "Save", tags = {"SALTYPE" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/saltypes/save")
    public ResponseEntity<Boolean> save(@RequestBody SALTYPEDTO saltypedto) {
        return ResponseEntity.status(HttpStatus.OK).body(saltypeService.save(saltypeMapping.toDomain(saltypedto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"SALTYPE" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/saltypes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SALTYPEDTO> saltypedtos) {
        saltypeService.saveBatch(saltypeMapping.toDomain(saltypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.saltypeMapping,#saltypedto})")
    @ApiOperation(value = "Create", tags = {"SALTYPE" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/saltypes")
    @Transactional
    public ResponseEntity<SALTYPEDTO> create(@RequestBody SALTYPEDTO saltypedto) {
        SALTYPE domain = saltypeMapping.toDomain(saltypedto);
		saltypeService.create(domain);
        SALTYPEDTO dto = saltypeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"SALTYPE" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/saltypes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SALTYPEDTO> saltypedtos) {
        saltypeService.createBatch(saltypeMapping.toDomain(saltypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#saltype_id,'Update',{'Sql',this.saltypeMapping,#saltypedto})")
    @ApiOperation(value = "Update", tags = {"SALTYPE" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/saltypes/{saltype_id}")
    @Transactional
    public ResponseEntity<SALTYPEDTO> update(@PathVariable("saltype_id") String saltype_id, @RequestBody SALTYPEDTO saltypedto) {
		SALTYPE domain = saltypeMapping.toDomain(saltypedto);
        domain.setSaltypeid(saltype_id);
		saltypeService.update(domain);
		SALTYPEDTO dto = saltypeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"SALTYPE" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/saltypes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SALTYPEDTO> saltypedtos) {
        saltypeService.updateBatch(saltypeMapping.toDomain(saltypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALTYPE-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SALTYPE" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/saltypes/fetchdefault")
	public ResponseEntity<List<SALTYPEDTO>> fetchDefault(SALTYPESearchContext context) {
        Page<SALTYPE> domains = saltypeService.searchDefault(context) ;
        List<SALTYPEDTO> list = saltypeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALTYPE-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SALTYPE" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/saltypes/searchdefault")
	public ResponseEntity<Page<SALTYPEDTO>> searchDefault(@RequestBody SALTYPESearchContext context) {
        Page<SALTYPE> domains = saltypeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(saltypeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
