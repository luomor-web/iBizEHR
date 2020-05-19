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
import cn.ibizlab.ehr.core.trm.domain.TRMTRAFFIC;
import cn.ibizlab.ehr.core.trm.service.ITRMTRAFFICService;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAFFICSearchContext;




@Slf4j
@Api(tags = {"TRMTRAFFIC" })
@RestController("WebApi-trmtraffic")
@RequestMapping("")
public class TRMTRAFFICResource {

    @Autowired
    private ITRMTRAFFICService trmtrafficService;

    @Autowired
    @Lazy
    private TRMTRAFFICMapping trmtrafficMapping;




    @ApiOperation(value = "GetDraft", tags = {"TRMTRAFFIC" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtraffics/getdraft")
    public ResponseEntity<TRMTRAFFICDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrafficMapping.toDto(trmtrafficService.getDraft(new TRMTRAFFIC())));
    }




    @PreAuthorize("hasPermission('Remove',{#trmtraffic_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"TRMTRAFFIC" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtraffics/{trmtraffic_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtraffic_id") String trmtraffic_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtrafficService.remove(trmtraffic_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"TRMTRAFFIC" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtraffics/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtrafficService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"TRMTRAFFIC" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraffics/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMTRAFFICDTO trmtrafficdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrafficService.save(trmtrafficMapping.toDomain(trmtrafficdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"TRMTRAFFIC" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraffics/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMTRAFFICDTO> trmtrafficdtos) {
        trmtrafficService.saveBatch(trmtrafficMapping.toDomain(trmtrafficdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#trmtraffic_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"TRMTRAFFIC" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtraffics/{trmtraffic_id}")
    public ResponseEntity<TRMTRAFFICDTO> get(@PathVariable("trmtraffic_id") String trmtraffic_id) {
        TRMTRAFFIC domain = trmtrafficService.get(trmtraffic_id);
        TRMTRAFFICDTO dto = trmtrafficMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#trmtraffic_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"TRMTRAFFIC" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtraffics/{trmtraffic_id}")
    @Transactional
    public ResponseEntity<TRMTRAFFICDTO> update(@PathVariable("trmtraffic_id") String trmtraffic_id, @RequestBody TRMTRAFFICDTO trmtrafficdto) {
		TRMTRAFFIC domain = trmtrafficMapping.toDomain(trmtrafficdto);
        domain.setTrmtrafficid(trmtraffic_id);
		trmtrafficService.update(domain);
		TRMTRAFFICDTO dto = trmtrafficMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#trmtraffic_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"TRMTRAFFIC" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtraffics/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMTRAFFICDTO> trmtrafficdtos) {
        trmtrafficService.updateBatch(trmtrafficMapping.toDomain(trmtrafficdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"TRMTRAFFIC" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraffics")
    @Transactional
    public ResponseEntity<TRMTRAFFICDTO> create(@RequestBody TRMTRAFFICDTO trmtrafficdto) {
        TRMTRAFFIC domain = trmtrafficMapping.toDomain(trmtrafficdto);
		trmtrafficService.create(domain);
        TRMTRAFFICDTO dto = trmtrafficMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"TRMTRAFFIC" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraffics/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMTRAFFICDTO> trmtrafficdtos) {
        trmtrafficService.createBatch(trmtrafficMapping.toDomain(trmtrafficdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"TRMTRAFFIC" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraffics/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMTRAFFICDTO trmtrafficdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrafficService.checkKey(trmtrafficMapping.toDomain(trmtrafficdto)));
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TRMTRAFFIC" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtraffics/fetchdefault")
	public ResponseEntity<List<TRMTRAFFICDTO>> fetchDefault(TRMTRAFFICSearchContext context) {
        Page<TRMTRAFFIC> domains = trmtrafficService.searchDefault(context) ;
        List<TRMTRAFFICDTO> list = trmtrafficMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"TRMTRAFFIC" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtraffics/searchdefault")
	public ResponseEntity<Page<TRMTRAFFICDTO>> searchDefault(TRMTRAFFICSearchContext context) {
        Page<TRMTRAFFIC> domains = trmtrafficService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrafficMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public TRMTRAFFIC getEntity(){
        return new TRMTRAFFIC();
    }

}
