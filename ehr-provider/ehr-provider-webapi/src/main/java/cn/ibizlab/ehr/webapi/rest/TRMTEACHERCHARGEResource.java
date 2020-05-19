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
import cn.ibizlab.ehr.core.trm.domain.TRMTEACHERCHARGE;
import cn.ibizlab.ehr.core.trm.service.ITRMTEACHERCHARGEService;
import cn.ibizlab.ehr.core.trm.filter.TRMTEACHERCHARGESearchContext;




@Slf4j
@Api(tags = {"TRMTEACHERCHARGE" })
@RestController("WebApi-trmteachercharge")
@RequestMapping("")
public class TRMTEACHERCHARGEResource {

    @Autowired
    private ITRMTEACHERCHARGEService trmteacherchargeService;

    @Autowired
    @Lazy
    private TRMTEACHERCHARGEMapping trmteacherchargeMapping;




    @ApiOperation(value = "Save", tags = {"TRMTEACHERCHARGE" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmteachercharges/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMTEACHERCHARGEDTO trmteacherchargedto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeService.save(trmteacherchargeMapping.toDomain(trmteacherchargedto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"TRMTEACHERCHARGE" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmteachercharges/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMTEACHERCHARGEDTO> trmteacherchargedtos) {
        trmteacherchargeService.saveBatch(trmteacherchargeMapping.toDomain(trmteacherchargedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#trmteachercharge_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"TRMTEACHERCHARGE" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmteachercharges/{trmteachercharge_id}")
    public ResponseEntity<TRMTEACHERCHARGEDTO> get(@PathVariable("trmteachercharge_id") String trmteachercharge_id) {
        TRMTEACHERCHARGE domain = trmteacherchargeService.get(trmteachercharge_id);
        TRMTEACHERCHARGEDTO dto = trmteacherchargeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('Remove',{#trmteachercharge_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"TRMTEACHERCHARGE" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmteachercharges/{trmteachercharge_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmteachercharge_id") String trmteachercharge_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeService.remove(trmteachercharge_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"TRMTEACHERCHARGE" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmteachercharges/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmteacherchargeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#trmteachercharge_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"TRMTEACHERCHARGE" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmteachercharges/{trmteachercharge_id}")
    @Transactional
    public ResponseEntity<TRMTEACHERCHARGEDTO> update(@PathVariable("trmteachercharge_id") String trmteachercharge_id, @RequestBody TRMTEACHERCHARGEDTO trmteacherchargedto) {
		TRMTEACHERCHARGE domain = trmteacherchargeMapping.toDomain(trmteacherchargedto);
        domain.setTrmteacherchargeid(trmteachercharge_id);
		trmteacherchargeService.update(domain);
		TRMTEACHERCHARGEDTO dto = trmteacherchargeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#trmteachercharge_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"TRMTEACHERCHARGE" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmteachercharges/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMTEACHERCHARGEDTO> trmteacherchargedtos) {
        trmteacherchargeService.updateBatch(trmteacherchargeMapping.toDomain(trmteacherchargedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"TRMTEACHERCHARGE" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmteachercharges")
    @Transactional
    public ResponseEntity<TRMTEACHERCHARGEDTO> create(@RequestBody TRMTEACHERCHARGEDTO trmteacherchargedto) {
        TRMTEACHERCHARGE domain = trmteacherchargeMapping.toDomain(trmteacherchargedto);
		trmteacherchargeService.create(domain);
        TRMTEACHERCHARGEDTO dto = trmteacherchargeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"TRMTEACHERCHARGE" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmteachercharges/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMTEACHERCHARGEDTO> trmteacherchargedtos) {
        trmteacherchargeService.createBatch(trmteacherchargeMapping.toDomain(trmteacherchargedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"TRMTEACHERCHARGE" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmteachercharges/getdraft")
    public ResponseEntity<TRMTEACHERCHARGEDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeMapping.toDto(trmteacherchargeService.getDraft(new TRMTEACHERCHARGE())));
    }




    @ApiOperation(value = "CheckKey", tags = {"TRMTEACHERCHARGE" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmteachercharges/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMTEACHERCHARGEDTO trmteacherchargedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeService.checkKey(trmteacherchargeMapping.toDomain(trmteacherchargedto)));
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TRMTEACHERCHARGE" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmteachercharges/fetchdefault")
	public ResponseEntity<List<TRMTEACHERCHARGEDTO>> fetchDefault(TRMTEACHERCHARGESearchContext context) {
        Page<TRMTEACHERCHARGE> domains = trmteacherchargeService.searchDefault(context) ;
        List<TRMTEACHERCHARGEDTO> list = trmteacherchargeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"TRMTEACHERCHARGE" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmteachercharges/searchdefault")
	public ResponseEntity<Page<TRMTEACHERCHARGEDTO>> searchDefault(TRMTEACHERCHARGESearchContext context) {
        Page<TRMTEACHERCHARGE> domains = trmteacherchargeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmteacherchargeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public TRMTEACHERCHARGE getEntity(){
        return new TRMTEACHERCHARGE();
    }

}
