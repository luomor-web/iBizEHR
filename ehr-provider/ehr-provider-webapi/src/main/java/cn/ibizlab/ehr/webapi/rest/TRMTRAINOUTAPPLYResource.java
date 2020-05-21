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
import cn.ibizlab.ehr.core.trm.domain.TRMTRAINOUTAPPLY;
import cn.ibizlab.ehr.core.trm.service.ITRMTRAINOUTAPPLYService;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINOUTAPPLYSearchContext;




@Slf4j
@Api(tags = {"TRMTRAINOUTAPPLY" })
@RestController("WebApi-trmtrainoutapply")
@RequestMapping("")
public class TRMTRAINOUTAPPLYResource {

    @Autowired
    private ITRMTRAINOUTAPPLYService trmtrainoutapplyService;

    @Autowired
    @Lazy
    public TRMTRAINOUTAPPLYMapping trmtrainoutapplyMapping;

    public TRMTRAINOUTAPPLYDTO permissionDTO=new TRMTRAINOUTAPPLYDTO();




    @PreAuthorize("hasPermission(#trmtrainoutapply_id,'Get',{'Sql',this.trmtrainoutapplyMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"TRMTRAINOUTAPPLY" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainoutapplies/{trmtrainoutapply_id}")
    public ResponseEntity<TRMTRAINOUTAPPLYDTO> get(@PathVariable("trmtrainoutapply_id") String trmtrainoutapply_id) {
        TRMTRAINOUTAPPLY domain = trmtrainoutapplyService.get(trmtrainoutapply_id);
        TRMTRAINOUTAPPLYDTO dto = trmtrainoutapplyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINOUTAPPLY-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"TRMTRAINOUTAPPLY" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainoutapplies/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMTRAINOUTAPPLYDTO trmtrainoutapplydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainoutapplyService.checkKey(trmtrainoutapplyMapping.toDomain(trmtrainoutapplydto)));
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINOUTAPPLY-Save-all')")
    @ApiOperation(value = "Save", tags = {"TRMTRAINOUTAPPLY" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainoutapplies/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMTRAINOUTAPPLYDTO trmtrainoutapplydto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainoutapplyService.save(trmtrainoutapplyMapping.toDomain(trmtrainoutapplydto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"TRMTRAINOUTAPPLY" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainoutapplies/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMTRAINOUTAPPLYDTO> trmtrainoutapplydtos) {
        trmtrainoutapplyService.saveBatch(trmtrainoutapplyMapping.toDomain(trmtrainoutapplydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINOUTAPPLY-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"TRMTRAINOUTAPPLY" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainoutapplies/getdraft")
    public ResponseEntity<TRMTRAINOUTAPPLYDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainoutapplyMapping.toDto(trmtrainoutapplyService.getDraft(new TRMTRAINOUTAPPLY())));
    }




    @PreAuthorize("hasPermission(#trmtrainoutapply_id,'Remove',{'Sql',this.trmtrainoutapplyMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"TRMTRAINOUTAPPLY" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainoutapplies/{trmtrainoutapply_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtrainoutapply_id") String trmtrainoutapply_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtrainoutapplyService.remove(trmtrainoutapply_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"TRMTRAINOUTAPPLY" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainoutapplies/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtrainoutapplyService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#trmtrainoutapply_id,'Update',{'Sql',this.trmtrainoutapplyMapping,#trmtrainoutapplydto})")
    @ApiOperation(value = "Update", tags = {"TRMTRAINOUTAPPLY" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainoutapplies/{trmtrainoutapply_id}")
    @Transactional
    public ResponseEntity<TRMTRAINOUTAPPLYDTO> update(@PathVariable("trmtrainoutapply_id") String trmtrainoutapply_id, @RequestBody TRMTRAINOUTAPPLYDTO trmtrainoutapplydto) {
		TRMTRAINOUTAPPLY domain = trmtrainoutapplyMapping.toDomain(trmtrainoutapplydto);
        domain.setTrmtrainoutapplyid(trmtrainoutapply_id);
		trmtrainoutapplyService.update(domain);
		TRMTRAINOUTAPPLYDTO dto = trmtrainoutapplyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"TRMTRAINOUTAPPLY" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainoutapplies/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMTRAINOUTAPPLYDTO> trmtrainoutapplydtos) {
        trmtrainoutapplyService.updateBatch(trmtrainoutapplyMapping.toDomain(trmtrainoutapplydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.trmtrainoutapplyMapping,#trmtrainoutapplydto})")
    @ApiOperation(value = "Create", tags = {"TRMTRAINOUTAPPLY" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainoutapplies")
    @Transactional
    public ResponseEntity<TRMTRAINOUTAPPLYDTO> create(@RequestBody TRMTRAINOUTAPPLYDTO trmtrainoutapplydto) {
        TRMTRAINOUTAPPLY domain = trmtrainoutapplyMapping.toDomain(trmtrainoutapplydto);
		trmtrainoutapplyService.create(domain);
        TRMTRAINOUTAPPLYDTO dto = trmtrainoutapplyMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"TRMTRAINOUTAPPLY" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainoutapplies/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMTRAINOUTAPPLYDTO> trmtrainoutapplydtos) {
        trmtrainoutapplyService.createBatch(trmtrainoutapplyMapping.toDomain(trmtrainoutapplydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINOUTAPPLY-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TRMTRAINOUTAPPLY" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainoutapplies/fetchdefault")
	public ResponseEntity<List<TRMTRAINOUTAPPLYDTO>> fetchDefault(TRMTRAINOUTAPPLYSearchContext context) {
        Page<TRMTRAINOUTAPPLY> domains = trmtrainoutapplyService.searchDefault(context) ;
        List<TRMTRAINOUTAPPLYDTO> list = trmtrainoutapplyMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINOUTAPPLY-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TRMTRAINOUTAPPLY" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainoutapplies/searchdefault")
	public ResponseEntity<Page<TRMTRAINOUTAPPLYDTO>> searchDefault(@RequestBody TRMTRAINOUTAPPLYSearchContext context) {
        Page<TRMTRAINOUTAPPLY> domains = trmtrainoutapplyService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainoutapplyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


