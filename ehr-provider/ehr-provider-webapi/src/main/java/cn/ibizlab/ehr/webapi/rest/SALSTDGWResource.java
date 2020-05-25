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
import cn.ibizlab.ehr.core.sal.domain.SALSTDGW;
import cn.ibizlab.ehr.core.sal.service.ISALSTDGWService;
import cn.ibizlab.ehr.core.sal.filter.SALSTDGWSearchContext;

@Slf4j
@Api(tags = {"SALSTDGW" })
@RestController("WebApi-salstdgw")
@RequestMapping("")
public class SALSTDGWResource {

    @Autowired
    private ISALSTDGWService salstdgwService;

    @Autowired
    @Lazy
    public SALSTDGWMapping salstdgwMapping;

    public SALSTDGWDTO permissionDTO=new SALSTDGWDTO();

    @PreAuthorize("hasPermission('','Create',{'Sql',this.salstdgwMapping,#salstdgwdto})")
    @ApiOperation(value = "Create", tags = {"SALSTDGW" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgws")
    @Transactional
    public ResponseEntity<SALSTDGWDTO> create(@RequestBody SALSTDGWDTO salstdgwdto) {
        SALSTDGW domain = salstdgwMapping.toDomain(salstdgwdto);
		salstdgwService.create(domain);
        SALSTDGWDTO dto = salstdgwMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"SALSTDGW" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgws/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SALSTDGWDTO> salstdgwdtos) {
        salstdgwService.createBatch(salstdgwMapping.toDomain(salstdgwdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDGW-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"SALSTDGW" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgws/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SALSTDGWDTO salstdgwdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salstdgwService.checkKey(salstdgwMapping.toDomain(salstdgwdto)));
    }

    @PreAuthorize("hasPermission(#salstdgw_id,'Remove',{'Sql',this.salstdgwMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"SALSTDGW" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdgws/{salstdgw_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salstdgw_id") String salstdgw_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salstdgwService.remove(salstdgw_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"SALSTDGW" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdgws/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salstdgwService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#salstdgw_id,'Get',{'Sql',this.salstdgwMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"SALSTDGW" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdgws/{salstdgw_id}")
    public ResponseEntity<SALSTDGWDTO> get(@PathVariable("salstdgw_id") String salstdgw_id) {
        SALSTDGW domain = salstdgwService.get(salstdgw_id);
        SALSTDGWDTO dto = salstdgwMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDGW-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"SALSTDGW" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdgws/getdraft")
    public ResponseEntity<SALSTDGWDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salstdgwMapping.toDto(salstdgwService.getDraft(new SALSTDGW())));
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.salstdgwMapping,#salstdgwdto})")
    @ApiOperation(value = "Save", tags = {"SALSTDGW" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgws/save")
    public ResponseEntity<Boolean> save(@RequestBody SALSTDGWDTO salstdgwdto) {
        return ResponseEntity.status(HttpStatus.OK).body(salstdgwService.save(salstdgwMapping.toDomain(salstdgwdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"SALSTDGW" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgws/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SALSTDGWDTO> salstdgwdtos) {
        salstdgwService.saveBatch(salstdgwMapping.toDomain(salstdgwdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#salstdgw_id,'Update',{'Sql',this.salstdgwMapping,#salstdgwdto})")
    @ApiOperation(value = "Update", tags = {"SALSTDGW" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdgws/{salstdgw_id}")
    @Transactional
    public ResponseEntity<SALSTDGWDTO> update(@PathVariable("salstdgw_id") String salstdgw_id, @RequestBody SALSTDGWDTO salstdgwdto) {
		SALSTDGW domain = salstdgwMapping.toDomain(salstdgwdto);
        domain.setSalstdgwid(salstdgw_id);
		salstdgwService.update(domain);
		SALSTDGWDTO dto = salstdgwMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"SALSTDGW" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdgws/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SALSTDGWDTO> salstdgwdtos) {
        salstdgwService.updateBatch(salstdgwMapping.toDomain(salstdgwdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDGW-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SALSTDGW" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salstdgws/fetchdefault")
	public ResponseEntity<List<SALSTDGWDTO>> fetchDefault(SALSTDGWSearchContext context) {
        Page<SALSTDGW> domains = salstdgwService.searchDefault(context) ;
        List<SALSTDGWDTO> list = salstdgwMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDGW-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SALSTDGW" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salstdgws/searchdefault")
	public ResponseEntity<Page<SALSTDGWDTO>> searchDefault(@RequestBody SALSTDGWSearchContext context) {
        Page<SALSTDGW> domains = salstdgwService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salstdgwMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
