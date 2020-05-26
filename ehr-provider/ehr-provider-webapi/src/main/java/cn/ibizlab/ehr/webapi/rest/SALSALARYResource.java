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
import cn.ibizlab.ehr.core.sal.domain.SALSALARY;
import cn.ibizlab.ehr.core.sal.service.ISALSALARYService;
import cn.ibizlab.ehr.core.sal.filter.SALSALARYSearchContext;

@Slf4j
@Api(tags = {"SALSALARY" })
@RestController("WebApi-salsalary")
@RequestMapping("")
public class SALSALARYResource {

    @Autowired
    private ISALSALARYService salsalaryService;

    @Autowired
    @Lazy
    public SALSALARYMapping salsalaryMapping;

    public SALSALARYDTO permissionDTO=new SALSALARYDTO();

    @PreAuthorize("hasPermission('','Save',{'Sql',this.salsalaryMapping,#salsalarydto})")
    @ApiOperation(value = "Save", tags = {"SALSALARY" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/salsalaries/save")
    public ResponseEntity<Boolean> save(@RequestBody SALSALARYDTO salsalarydto) {
        return ResponseEntity.status(HttpStatus.OK).body(salsalaryService.save(salsalaryMapping.toDomain(salsalarydto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.salsalaryMapping,#salsalarydtos})")
    @ApiOperation(value = "SaveBatch", tags = {"SALSALARY" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salsalaries/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SALSALARYDTO> salsalarydtos) {
        salsalaryService.saveBatch(salsalaryMapping.toDomain(salsalarydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSALARY-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"SALSALARY" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/salsalaries/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SALSALARYDTO salsalarydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salsalaryService.checkKey(salsalaryMapping.toDomain(salsalarydto)));
    }

    @PreAuthorize("hasPermission(#salsalary_id,'Get',{'Sql',this.salsalaryMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"SALSALARY" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/salsalaries/{salsalary_id}")
    public ResponseEntity<SALSALARYDTO> get(@PathVariable("salsalary_id") String salsalary_id) {
        SALSALARY domain = salsalaryService.get(salsalary_id);
        SALSALARYDTO dto = salsalaryMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSALARY-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"SALSALARY" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/salsalaries/getdraft")
    public ResponseEntity<SALSALARYDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salsalaryMapping.toDto(salsalaryService.getDraft(new SALSALARY())));
    }

    @PreAuthorize("hasPermission(#salsalary_id,'Remove',{'Sql',this.salsalaryMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"SALSALARY" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salsalaries/{salsalary_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salsalary_id") String salsalary_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salsalaryService.remove(salsalary_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.salsalaryMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"SALSALARY" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salsalaries/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salsalaryService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.salsalaryMapping,#salsalarydto})")
    @ApiOperation(value = "Create", tags = {"SALSALARY" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/salsalaries")
    @Transactional
    public ResponseEntity<SALSALARYDTO> create(@RequestBody SALSALARYDTO salsalarydto) {
        SALSALARY domain = salsalaryMapping.toDomain(salsalarydto);
		salsalaryService.create(domain);
        SALSALARYDTO dto = salsalaryMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.salsalaryMapping,#salsalarydtos})")
    @ApiOperation(value = "createBatch", tags = {"SALSALARY" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salsalaries/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SALSALARYDTO> salsalarydtos) {
        salsalaryService.createBatch(salsalaryMapping.toDomain(salsalarydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#salsalary_id,'Update',{'Sql',this.salsalaryMapping,#salsalarydto})")
    @ApiOperation(value = "Update", tags = {"SALSALARY" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/salsalaries/{salsalary_id}")
    @Transactional
    public ResponseEntity<SALSALARYDTO> update(@PathVariable("salsalary_id") String salsalary_id, @RequestBody SALSALARYDTO salsalarydto) {
		SALSALARY domain  = salsalaryMapping.toDomain(salsalarydto);
        domain .setSalsalaryid(salsalary_id);
		salsalaryService.update(domain );
		SALSALARYDTO dto = salsalaryMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.salsalaryMapping,#salsalarydtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"SALSALARY" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/salsalaries/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SALSALARYDTO> salsalarydtos) {
        salsalaryService.updateBatch(salsalaryMapping.toDomain(salsalarydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSALARY-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SALSALARY" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salsalaries/fetchdefault")
	public ResponseEntity<List<SALSALARYDTO>> fetchDefault(SALSALARYSearchContext context) {
        Page<SALSALARY> domains = salsalaryService.searchDefault(context) ;
        List<SALSALARYDTO> list = salsalaryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSALARY-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SALSALARY" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salsalaries/searchdefault")
	public ResponseEntity<Page<SALSALARYDTO>> searchDefault(@RequestBody SALSALARYSearchContext context) {
        Page<SALSALARY> domains = salsalaryService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salsalaryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
