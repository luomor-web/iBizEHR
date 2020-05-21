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
import cn.ibizlab.ehr.core.sal.domain.SALRULEDETAIL;
import cn.ibizlab.ehr.core.sal.service.ISALRULEDETAILService;
import cn.ibizlab.ehr.core.sal.filter.SALRULEDETAILSearchContext;




@Slf4j
@Api(tags = {"SALRULEDETAIL" })
@RestController("WebApi-salruledetail")
@RequestMapping("")
public class SALRULEDETAILResource {

    @Autowired
    private ISALRULEDETAILService salruledetailService;

    @Autowired
    @Lazy
    public SALRULEDETAILMapping salruledetailMapping;

    public SALRULEDETAILDTO permissionDTO=new SALRULEDETAILDTO();




    @PreAuthorize("hasPermission(#salruledetail_id,'Get',{'Sql',this.salruledetailMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"SALRULEDETAIL" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/salruledetails/{salruledetail_id}")
    public ResponseEntity<SALRULEDETAILDTO> get(@PathVariable("salruledetail_id") String salruledetail_id) {
        SALRULEDETAIL domain = salruledetailService.get(salruledetail_id);
        SALRULEDETAILDTO dto = salruledetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALRULEDETAIL-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"SALRULEDETAIL" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/salruledetails/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SALRULEDETAILDTO salruledetaildto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salruledetailService.checkKey(salruledetailMapping.toDomain(salruledetaildto)));
    }




    @PreAuthorize("hasPermission(#salruledetail_id,'Update',{'Sql',this.salruledetailMapping,#salruledetaildto})")
    @ApiOperation(value = "Update", tags = {"SALRULEDETAIL" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/salruledetails/{salruledetail_id}")
    @Transactional
    public ResponseEntity<SALRULEDETAILDTO> update(@PathVariable("salruledetail_id") String salruledetail_id, @RequestBody SALRULEDETAILDTO salruledetaildto) {
		SALRULEDETAIL domain = salruledetailMapping.toDomain(salruledetaildto);
        domain.setSalruledetailid(salruledetail_id);
		salruledetailService.update(domain);
		SALRULEDETAILDTO dto = salruledetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"SALRULEDETAIL" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/salruledetails/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SALRULEDETAILDTO> salruledetaildtos) {
        salruledetailService.updateBatch(salruledetailMapping.toDomain(salruledetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALRULEDETAIL-Save-all')")
    @ApiOperation(value = "Save", tags = {"SALRULEDETAIL" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/salruledetails/save")
    public ResponseEntity<Boolean> save(@RequestBody SALRULEDETAILDTO salruledetaildto) {
        return ResponseEntity.status(HttpStatus.OK).body(salruledetailService.save(salruledetailMapping.toDomain(salruledetaildto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"SALRULEDETAIL" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salruledetails/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SALRULEDETAILDTO> salruledetaildtos) {
        salruledetailService.saveBatch(salruledetailMapping.toDomain(salruledetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.salruledetailMapping,#salruledetaildto})")
    @ApiOperation(value = "Create", tags = {"SALRULEDETAIL" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/salruledetails")
    @Transactional
    public ResponseEntity<SALRULEDETAILDTO> create(@RequestBody SALRULEDETAILDTO salruledetaildto) {
        SALRULEDETAIL domain = salruledetailMapping.toDomain(salruledetaildto);
		salruledetailService.create(domain);
        SALRULEDETAILDTO dto = salruledetailMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"SALRULEDETAIL" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salruledetails/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SALRULEDETAILDTO> salruledetaildtos) {
        salruledetailService.createBatch(salruledetailMapping.toDomain(salruledetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#salruledetail_id,'Remove',{'Sql',this.salruledetailMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"SALRULEDETAIL" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salruledetails/{salruledetail_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salruledetail_id") String salruledetail_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salruledetailService.remove(salruledetail_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"SALRULEDETAIL" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salruledetails/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salruledetailService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALRULEDETAIL-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"SALRULEDETAIL" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/salruledetails/getdraft")
    public ResponseEntity<SALRULEDETAILDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salruledetailMapping.toDto(salruledetailService.getDraft(new SALRULEDETAIL())));
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALRULEDETAIL-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SALRULEDETAIL" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salruledetails/fetchdefault")
	public ResponseEntity<List<SALRULEDETAILDTO>> fetchDefault(SALRULEDETAILSearchContext context) {
        Page<SALRULEDETAIL> domains = salruledetailService.searchDefault(context) ;
        List<SALRULEDETAILDTO> list = salruledetailMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALRULEDETAIL-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SALRULEDETAIL" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salruledetails/searchdefault")
	public ResponseEntity<Page<SALRULEDETAILDTO>> searchDefault(@RequestBody SALRULEDETAILSearchContext context) {
        Page<SALRULEDETAIL> domains = salruledetailService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salruledetailMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


