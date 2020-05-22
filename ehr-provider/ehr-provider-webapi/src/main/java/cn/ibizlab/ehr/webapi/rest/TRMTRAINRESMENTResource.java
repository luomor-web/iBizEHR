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
import cn.ibizlab.ehr.core.trm.domain.TRMTRAINRESMENT;
import cn.ibizlab.ehr.core.trm.service.ITRMTRAINRESMENTService;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINRESMENTSearchContext;




@Slf4j
@Api(tags = {"TRMTRAINRESMENT" })
@RestController("WebApi-trmtrainresment")
@RequestMapping("")
public class TRMTRAINRESMENTResource {

    @Autowired
    private ITRMTRAINRESMENTService trmtrainresmentService;

    @Autowired
    @Lazy
    public TRMTRAINRESMENTMapping trmtrainresmentMapping;

    public TRMTRAINRESMENTDTO permissionDTO=new TRMTRAINRESMENTDTO();

    @PreAuthorize("hasPermission(#trmtrainresment_id,'Update',{'Sql',this.trmtrainresmentMapping,#trmtrainresmentdto})")
    @ApiOperation(value = "Update", tags = {"TRMTRAINRESMENT" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainresments/{trmtrainresment_id}")
    @Transactional
    public ResponseEntity<TRMTRAINRESMENTDTO> update(@PathVariable("trmtrainresment_id") String trmtrainresment_id, @RequestBody TRMTRAINRESMENTDTO trmtrainresmentdto) {
		TRMTRAINRESMENT domain = trmtrainresmentMapping.toDomain(trmtrainresmentdto);
        domain.setTrmtrainresmentid(trmtrainresment_id);
		trmtrainresmentService.update(domain);
		TRMTRAINRESMENTDTO dto = trmtrainresmentMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"TRMTRAINRESMENT" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainresments/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMTRAINRESMENTDTO> trmtrainresmentdtos) {
        trmtrainresmentService.updateBatch(trmtrainresmentMapping.toDomain(trmtrainresmentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINRESMENT-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"TRMTRAINRESMENT" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainresments/getdraft")
    public ResponseEntity<TRMTRAINRESMENTDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainresmentMapping.toDto(trmtrainresmentService.getDraft(new TRMTRAINRESMENT())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINRESMENT-Save-all')")
    @ApiOperation(value = "Save", tags = {"TRMTRAINRESMENT" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainresments/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMTRAINRESMENTDTO trmtrainresmentdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainresmentService.save(trmtrainresmentMapping.toDomain(trmtrainresmentdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"TRMTRAINRESMENT" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainresments/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMTRAINRESMENTDTO> trmtrainresmentdtos) {
        trmtrainresmentService.saveBatch(trmtrainresmentMapping.toDomain(trmtrainresmentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINRESMENT-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"TRMTRAINRESMENT" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainresments/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMTRAINRESMENTDTO trmtrainresmentdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainresmentService.checkKey(trmtrainresmentMapping.toDomain(trmtrainresmentdto)));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.trmtrainresmentMapping,#trmtrainresmentdto})")
    @ApiOperation(value = "Create", tags = {"TRMTRAINRESMENT" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainresments")
    @Transactional
    public ResponseEntity<TRMTRAINRESMENTDTO> create(@RequestBody TRMTRAINRESMENTDTO trmtrainresmentdto) {
        TRMTRAINRESMENT domain = trmtrainresmentMapping.toDomain(trmtrainresmentdto);
		trmtrainresmentService.create(domain);
        TRMTRAINRESMENTDTO dto = trmtrainresmentMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"TRMTRAINRESMENT" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainresments/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMTRAINRESMENTDTO> trmtrainresmentdtos) {
        trmtrainresmentService.createBatch(trmtrainresmentMapping.toDomain(trmtrainresmentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#trmtrainresment_id,'Remove',{'Sql',this.trmtrainresmentMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"TRMTRAINRESMENT" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainresments/{trmtrainresment_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtrainresment_id") String trmtrainresment_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtrainresmentService.remove(trmtrainresment_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"TRMTRAINRESMENT" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainresments/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtrainresmentService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#trmtrainresment_id,'Get',{'Sql',this.trmtrainresmentMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"TRMTRAINRESMENT" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainresments/{trmtrainresment_id}")
    public ResponseEntity<TRMTRAINRESMENTDTO> get(@PathVariable("trmtrainresment_id") String trmtrainresment_id) {
        TRMTRAINRESMENT domain = trmtrainresmentService.get(trmtrainresment_id);
        TRMTRAINRESMENTDTO dto = trmtrainresmentMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINRESMENT-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TRMTRAINRESMENT" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainresments/fetchdefault")
	public ResponseEntity<List<TRMTRAINRESMENTDTO>> fetchDefault(TRMTRAINRESMENTSearchContext context) {
        Page<TRMTRAINRESMENT> domains = trmtrainresmentService.searchDefault(context) ;
        List<TRMTRAINRESMENTDTO> list = trmtrainresmentMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINRESMENT-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TRMTRAINRESMENT" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainresments/searchdefault")
	public ResponseEntity<Page<TRMTRAINRESMENTDTO>> searchDefault(@RequestBody TRMTRAINRESMENTSearchContext context) {
        Page<TRMTRAINRESMENT> domains = trmtrainresmentService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainresmentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
