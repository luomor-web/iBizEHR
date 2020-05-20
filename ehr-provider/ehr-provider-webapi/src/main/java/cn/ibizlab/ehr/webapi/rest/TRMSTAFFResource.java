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
import cn.ibizlab.ehr.core.trm.domain.TRMSTAFF;
import cn.ibizlab.ehr.core.trm.service.ITRMSTAFFService;
import cn.ibizlab.ehr.core.trm.filter.TRMSTAFFSearchContext;




@Slf4j
@Api(tags = {"TRMSTAFF" })
@RestController("WebApi-trmstaff")
@RequestMapping("")
public class TRMSTAFFResource {

    @Autowired
    private ITRMSTAFFService trmstaffService;

    @Autowired
    @Lazy
    private TRMSTAFFMapping trmstaffMapping;




    @PreAuthorize("hasPermission('Remove',{#trmstaff_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"TRMSTAFF" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmstaffs/{trmstaff_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmstaff_id") String trmstaff_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmstaffService.remove(trmstaff_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"TRMSTAFF" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmstaffs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmstaffService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"TRMSTAFF" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmstaffs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMSTAFFDTO trmstaffdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmstaffService.checkKey(trmstaffMapping.toDomain(trmstaffdto)));
    }




    @PreAuthorize("hasPermission(#trmstaff_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"TRMSTAFF" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmstaffs/{trmstaff_id}")
    @Transactional
    public ResponseEntity<TRMSTAFFDTO> update(@PathVariable("trmstaff_id") String trmstaff_id, @RequestBody TRMSTAFFDTO trmstaffdto) {
		TRMSTAFF domain = trmstaffMapping.toDomain(trmstaffdto);
        domain.setTrmstaffid(trmstaff_id);
		trmstaffService.update(domain);
		TRMSTAFFDTO dto = trmstaffMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#trmstaff_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"TRMSTAFF" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmstaffs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMSTAFFDTO> trmstaffdtos) {
        trmstaffService.updateBatch(trmstaffMapping.toDomain(trmstaffdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"TRMSTAFF" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmstaffs")
    @Transactional
    public ResponseEntity<TRMSTAFFDTO> create(@RequestBody TRMSTAFFDTO trmstaffdto) {
        TRMSTAFF domain = trmstaffMapping.toDomain(trmstaffdto);
		trmstaffService.create(domain);
        TRMSTAFFDTO dto = trmstaffMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"TRMSTAFF" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmstaffs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMSTAFFDTO> trmstaffdtos) {
        trmstaffService.createBatch(trmstaffMapping.toDomain(trmstaffdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"TRMSTAFF" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmstaffs/getdraft")
    public ResponseEntity<TRMSTAFFDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmstaffMapping.toDto(trmstaffService.getDraft(new TRMSTAFF())));
    }




    @PreAuthorize("hasPermission(#trmstaff_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"TRMSTAFF" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmstaffs/{trmstaff_id}")
    public ResponseEntity<TRMSTAFFDTO> get(@PathVariable("trmstaff_id") String trmstaff_id) {
        TRMSTAFF domain = trmstaffService.get(trmstaff_id);
        TRMSTAFFDTO dto = trmstaffMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "Save", tags = {"TRMSTAFF" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmstaffs/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMSTAFFDTO trmstaffdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmstaffService.save(trmstaffMapping.toDomain(trmstaffdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"TRMSTAFF" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmstaffs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMSTAFFDTO> trmstaffdtos) {
        trmstaffService.saveBatch(trmstaffMapping.toDomain(trmstaffdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"TRMSTAFF" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmstaffs/fetchdefault")
	public ResponseEntity<List<TRMSTAFFDTO>> fetchDefault(TRMSTAFFSearchContext context) {
        Page<TRMSTAFF> domains = trmstaffService.searchDefault(context) ;
        List<TRMSTAFFDTO> list = trmstaffMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"TRMSTAFF" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmstaffs/searchdefault")
	public ResponseEntity<Page<TRMSTAFFDTO>> searchDefault(@RequestBody TRMSTAFFSearchContext context) {
        Page<TRMSTAFF> domains = trmstaffService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmstaffMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public TRMSTAFF getEntity(){
        return new TRMSTAFF();
    }

}
