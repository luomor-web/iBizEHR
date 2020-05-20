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
import cn.ibizlab.ehr.core.trm.domain.TRMTRAINBUAPPLY;
import cn.ibizlab.ehr.core.trm.service.ITRMTRAINBUAPPLYService;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINBUAPPLYSearchContext;




@Slf4j
@Api(tags = {"TRMTRAINBUAPPLY" })
@RestController("WebApi-trmtrainbuapply")
@RequestMapping("")
public class TRMTRAINBUAPPLYResource {

    @Autowired
    private ITRMTRAINBUAPPLYService trmtrainbuapplyService;

    @Autowired
    @Lazy
    private TRMTRAINBUAPPLYMapping trmtrainbuapplyMapping;




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"TRMTRAINBUAPPLY" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainbuapplies")
    @Transactional
    public ResponseEntity<TRMTRAINBUAPPLYDTO> create(@RequestBody TRMTRAINBUAPPLYDTO trmtrainbuapplydto) {
        TRMTRAINBUAPPLY domain = trmtrainbuapplyMapping.toDomain(trmtrainbuapplydto);
		trmtrainbuapplyService.create(domain);
        TRMTRAINBUAPPLYDTO dto = trmtrainbuapplyMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"TRMTRAINBUAPPLY" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainbuapplies/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMTRAINBUAPPLYDTO> trmtrainbuapplydtos) {
        trmtrainbuapplyService.createBatch(trmtrainbuapplyMapping.toDomain(trmtrainbuapplydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#trmtrainbuapply_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"TRMTRAINBUAPPLY" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainbuapplies/{trmtrainbuapply_id}")
    @Transactional
    public ResponseEntity<TRMTRAINBUAPPLYDTO> update(@PathVariable("trmtrainbuapply_id") String trmtrainbuapply_id, @RequestBody TRMTRAINBUAPPLYDTO trmtrainbuapplydto) {
		TRMTRAINBUAPPLY domain = trmtrainbuapplyMapping.toDomain(trmtrainbuapplydto);
        domain.setTrmtrainbuapplyid(trmtrainbuapply_id);
		trmtrainbuapplyService.update(domain);
		TRMTRAINBUAPPLYDTO dto = trmtrainbuapplyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#trmtrainbuapply_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"TRMTRAINBUAPPLY" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainbuapplies/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMTRAINBUAPPLYDTO> trmtrainbuapplydtos) {
        trmtrainbuapplyService.updateBatch(trmtrainbuapplyMapping.toDomain(trmtrainbuapplydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"TRMTRAINBUAPPLY" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainbuapplies/getdraft")
    public ResponseEntity<TRMTRAINBUAPPLYDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainbuapplyMapping.toDto(trmtrainbuapplyService.getDraft(new TRMTRAINBUAPPLY())));
    }




    @PreAuthorize("hasPermission(#trmtrainbuapply_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"TRMTRAINBUAPPLY" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainbuapplies/{trmtrainbuapply_id}")
    public ResponseEntity<TRMTRAINBUAPPLYDTO> get(@PathVariable("trmtrainbuapply_id") String trmtrainbuapply_id) {
        TRMTRAINBUAPPLY domain = trmtrainbuapplyService.get(trmtrainbuapply_id);
        TRMTRAINBUAPPLYDTO dto = trmtrainbuapplyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "CheckKey", tags = {"TRMTRAINBUAPPLY" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainbuapplies/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMTRAINBUAPPLYDTO trmtrainbuapplydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainbuapplyService.checkKey(trmtrainbuapplyMapping.toDomain(trmtrainbuapplydto)));
    }




    @PreAuthorize("hasPermission('Remove',{#trmtrainbuapply_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"TRMTRAINBUAPPLY" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainbuapplies/{trmtrainbuapply_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtrainbuapply_id") String trmtrainbuapply_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtrainbuapplyService.remove(trmtrainbuapply_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"TRMTRAINBUAPPLY" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainbuapplies/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtrainbuapplyService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"TRMTRAINBUAPPLY" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainbuapplies/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMTRAINBUAPPLYDTO trmtrainbuapplydto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainbuapplyService.save(trmtrainbuapplyMapping.toDomain(trmtrainbuapplydto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"TRMTRAINBUAPPLY" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainbuapplies/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMTRAINBUAPPLYDTO> trmtrainbuapplydtos) {
        trmtrainbuapplyService.saveBatch(trmtrainbuapplyMapping.toDomain(trmtrainbuapplydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"TRMTRAINBUAPPLY" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainbuapplies/fetchdefault")
	public ResponseEntity<List<TRMTRAINBUAPPLYDTO>> fetchDefault(TRMTRAINBUAPPLYSearchContext context) {
        Page<TRMTRAINBUAPPLY> domains = trmtrainbuapplyService.searchDefault(context) ;
        List<TRMTRAINBUAPPLYDTO> list = trmtrainbuapplyMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"TRMTRAINBUAPPLY" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainbuapplies/searchdefault")
	public ResponseEntity<Page<TRMTRAINBUAPPLYDTO>> searchDefault(@RequestBody TRMTRAINBUAPPLYSearchContext context) {
        Page<TRMTRAINBUAPPLY> domains = trmtrainbuapplyService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainbuapplyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public TRMTRAINBUAPPLY getEntity(){
        return new TRMTRAINBUAPPLY();
    }

}
