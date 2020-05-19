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
import cn.ibizlab.ehr.core.trm.domain.TRMEMPLOYRETION;
import cn.ibizlab.ehr.core.trm.service.ITRMEMPLOYRETIONService;
import cn.ibizlab.ehr.core.trm.filter.TRMEMPLOYRETIONSearchContext;




@Slf4j
@Api(tags = {"TRMEMPLOYRETION" })
@RestController("WebApi-trmemployretion")
@RequestMapping("")
public class TRMEMPLOYRETIONResource {

    @Autowired
    private ITRMEMPLOYRETIONService trmemployretionService;

    @Autowired
    @Lazy
    private TRMEMPLOYRETIONMapping trmemployretionMapping;




    @PreAuthorize("hasPermission('Remove',{#trmemployretion_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"TRMEMPLOYRETION" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmemployretions/{trmemployretion_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmemployretion_id") String trmemployretion_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmemployretionService.remove(trmemployretion_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"TRMEMPLOYRETION" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmemployretions/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmemployretionService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"TRMEMPLOYRETION" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmemployretions/getdraft")
    public ResponseEntity<TRMEMPLOYRETIONDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmemployretionMapping.toDto(trmemployretionService.getDraft(new TRMEMPLOYRETION())));
    }




    @PreAuthorize("hasPermission(#trmemployretion_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"TRMEMPLOYRETION" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmemployretions/{trmemployretion_id}")
    @Transactional
    public ResponseEntity<TRMEMPLOYRETIONDTO> update(@PathVariable("trmemployretion_id") String trmemployretion_id, @RequestBody TRMEMPLOYRETIONDTO trmemployretiondto) {
		TRMEMPLOYRETION domain = trmemployretionMapping.toDomain(trmemployretiondto);
        domain.setTrmemployretionid(trmemployretion_id);
		trmemployretionService.update(domain);
		TRMEMPLOYRETIONDTO dto = trmemployretionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#trmemployretion_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"TRMEMPLOYRETION" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmemployretions/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMEMPLOYRETIONDTO> trmemployretiondtos) {
        trmemployretionService.updateBatch(trmemployretionMapping.toDomain(trmemployretiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"TRMEMPLOYRETION" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmemployretions/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMEMPLOYRETIONDTO trmemployretiondto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmemployretionService.save(trmemployretionMapping.toDomain(trmemployretiondto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"TRMEMPLOYRETION" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmemployretions/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMEMPLOYRETIONDTO> trmemployretiondtos) {
        trmemployretionService.saveBatch(trmemployretionMapping.toDomain(trmemployretiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"TRMEMPLOYRETION" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmemployretions")
    @Transactional
    public ResponseEntity<TRMEMPLOYRETIONDTO> create(@RequestBody TRMEMPLOYRETIONDTO trmemployretiondto) {
        TRMEMPLOYRETION domain = trmemployretionMapping.toDomain(trmemployretiondto);
		trmemployretionService.create(domain);
        TRMEMPLOYRETIONDTO dto = trmemployretionMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"TRMEMPLOYRETION" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmemployretions/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMEMPLOYRETIONDTO> trmemployretiondtos) {
        trmemployretionService.createBatch(trmemployretionMapping.toDomain(trmemployretiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"TRMEMPLOYRETION" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmemployretions/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMEMPLOYRETIONDTO trmemployretiondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmemployretionService.checkKey(trmemployretionMapping.toDomain(trmemployretiondto)));
    }




    @PreAuthorize("hasPermission(#trmemployretion_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"TRMEMPLOYRETION" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmemployretions/{trmemployretion_id}")
    public ResponseEntity<TRMEMPLOYRETIONDTO> get(@PathVariable("trmemployretion_id") String trmemployretion_id) {
        TRMEMPLOYRETION domain = trmemployretionService.get(trmemployretion_id);
        TRMEMPLOYRETIONDTO dto = trmemployretionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TRMEMPLOYRETION" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmemployretions/fetchdefault")
	public ResponseEntity<List<TRMEMPLOYRETIONDTO>> fetchDefault(TRMEMPLOYRETIONSearchContext context) {
        Page<TRMEMPLOYRETION> domains = trmemployretionService.searchDefault(context) ;
        List<TRMEMPLOYRETIONDTO> list = trmemployretionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"TRMEMPLOYRETION" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmemployretions/searchdefault")
	public ResponseEntity<Page<TRMEMPLOYRETIONDTO>> searchDefault(TRMEMPLOYRETIONSearchContext context) {
        Page<TRMEMPLOYRETION> domains = trmemployretionService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmemployretionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public TRMEMPLOYRETION getEntity(){
        return new TRMEMPLOYRETION();
    }

}
