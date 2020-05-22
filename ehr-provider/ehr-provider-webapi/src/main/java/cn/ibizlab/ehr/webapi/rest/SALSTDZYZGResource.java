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
import cn.ibizlab.ehr.core.sal.domain.SALSTDZYZG;
import cn.ibizlab.ehr.core.sal.service.ISALSTDZYZGService;
import cn.ibizlab.ehr.core.sal.filter.SALSTDZYZGSearchContext;




@Slf4j
@Api(tags = {"SALSTDZYZG" })
@RestController("WebApi-salstdzyzg")
@RequestMapping("")
public class SALSTDZYZGResource {

    @Autowired
    private ISALSTDZYZGService salstdzyzgService;

    @Autowired
    @Lazy
    public SALSTDZYZGMapping salstdzyzgMapping;

    public SALSTDZYZGDTO permissionDTO=new SALSTDZYZGDTO();

    @PreAuthorize("hasPermission(#salstdzyzg_id,'Update',{'Sql',this.salstdzyzgMapping,#salstdzyzgdto})")
    @ApiOperation(value = "Update", tags = {"SALSTDZYZG" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdzyzgs/{salstdzyzg_id}")
    @Transactional
    public ResponseEntity<SALSTDZYZGDTO> update(@PathVariable("salstdzyzg_id") String salstdzyzg_id, @RequestBody SALSTDZYZGDTO salstdzyzgdto) {
		SALSTDZYZG domain = salstdzyzgMapping.toDomain(salstdzyzgdto);
        domain.setSalstdzyzgid(salstdzyzg_id);
		salstdzyzgService.update(domain);
		SALSTDZYZGDTO dto = salstdzyzgMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"SALSTDZYZG" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdzyzgs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SALSTDZYZGDTO> salstdzyzgdtos) {
        salstdzyzgService.updateBatch(salstdzyzgMapping.toDomain(salstdzyzgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#salstdzyzg_id,'Get',{'Sql',this.salstdzyzgMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"SALSTDZYZG" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdzyzgs/{salstdzyzg_id}")
    public ResponseEntity<SALSTDZYZGDTO> get(@PathVariable("salstdzyzg_id") String salstdzyzg_id) {
        SALSTDZYZG domain = salstdzyzgService.get(salstdzyzg_id);
        SALSTDZYZGDTO dto = salstdzyzgMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#salstdzyzg_id,'Remove',{'Sql',this.salstdzyzgMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"SALSTDZYZG" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdzyzgs/{salstdzyzg_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salstdzyzg_id") String salstdzyzg_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salstdzyzgService.remove(salstdzyzg_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"SALSTDZYZG" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdzyzgs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salstdzyzgService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.salstdzyzgMapping,#salstdzyzgdto})")
    @ApiOperation(value = "Create", tags = {"SALSTDZYZG" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzyzgs")
    @Transactional
    public ResponseEntity<SALSTDZYZGDTO> create(@RequestBody SALSTDZYZGDTO salstdzyzgdto) {
        SALSTDZYZG domain = salstdzyzgMapping.toDomain(salstdzyzgdto);
		salstdzyzgService.create(domain);
        SALSTDZYZGDTO dto = salstdzyzgMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"SALSTDZYZG" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzyzgs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SALSTDZYZGDTO> salstdzyzgdtos) {
        salstdzyzgService.createBatch(salstdzyzgMapping.toDomain(salstdzyzgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDZYZG-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"SALSTDZYZG" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdzyzgs/getdraft")
    public ResponseEntity<SALSTDZYZGDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salstdzyzgMapping.toDto(salstdzyzgService.getDraft(new SALSTDZYZG())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDZYZG-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"SALSTDZYZG" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzyzgs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SALSTDZYZGDTO salstdzyzgdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salstdzyzgService.checkKey(salstdzyzgMapping.toDomain(salstdzyzgdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDZYZG-Save-all')")
    @ApiOperation(value = "Save", tags = {"SALSTDZYZG" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzyzgs/save")
    public ResponseEntity<Boolean> save(@RequestBody SALSTDZYZGDTO salstdzyzgdto) {
        return ResponseEntity.status(HttpStatus.OK).body(salstdzyzgService.save(salstdzyzgMapping.toDomain(salstdzyzgdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"SALSTDZYZG" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzyzgs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SALSTDZYZGDTO> salstdzyzgdtos) {
        salstdzyzgService.saveBatch(salstdzyzgMapping.toDomain(salstdzyzgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDZYZG-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SALSTDZYZG" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salstdzyzgs/fetchdefault")
	public ResponseEntity<List<SALSTDZYZGDTO>> fetchDefault(SALSTDZYZGSearchContext context) {
        Page<SALSTDZYZG> domains = salstdzyzgService.searchDefault(context) ;
        List<SALSTDZYZGDTO> list = salstdzyzgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSTDZYZG-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SALSTDZYZG" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salstdzyzgs/searchdefault")
	public ResponseEntity<Page<SALSTDZYZGDTO>> searchDefault(@RequestBody SALSTDZYZGSearchContext context) {
        Page<SALSTDZYZG> domains = salstdzyzgService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salstdzyzgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
