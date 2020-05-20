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
import cn.ibizlab.ehr.core.par.domain.PARDJBZ;
import cn.ibizlab.ehr.core.par.service.IPARDJBZService;
import cn.ibizlab.ehr.core.par.filter.PARDJBZSearchContext;




@Slf4j
@Api(tags = {"PARDJBZ" })
@RestController("WebApi-pardjbz")
@RequestMapping("")
public class PARDJBZResource {

    @Autowired
    private IPARDJBZService pardjbzService;

    @Autowired
    @Lazy
    private PARDJBZMapping pardjbzMapping;




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PARDJBZ" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pardjbzs")
    @Transactional
    public ResponseEntity<PARDJBZDTO> create(@RequestBody PARDJBZDTO pardjbzdto) {
        PARDJBZ domain = pardjbzMapping.toDomain(pardjbzdto);
		pardjbzService.create(domain);
        PARDJBZDTO dto = pardjbzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PARDJBZ" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pardjbzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARDJBZDTO> pardjbzdtos) {
        pardjbzService.createBatch(pardjbzMapping.toDomain(pardjbzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pardjbz_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PARDJBZ" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pardjbzs/{pardjbz_id}")
    public ResponseEntity<PARDJBZDTO> get(@PathVariable("pardjbz_id") String pardjbz_id) {
        PARDJBZ domain = pardjbzService.get(pardjbz_id);
        PARDJBZDTO dto = pardjbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "Save", tags = {"PARDJBZ" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pardjbzs/save")
    public ResponseEntity<Boolean> save(@RequestBody PARDJBZDTO pardjbzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pardjbzService.save(pardjbzMapping.toDomain(pardjbzdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PARDJBZ" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pardjbzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARDJBZDTO> pardjbzdtos) {
        pardjbzService.saveBatch(pardjbzMapping.toDomain(pardjbzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PARDJBZ" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pardjbzs/getdraft")
    public ResponseEntity<PARDJBZDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pardjbzMapping.toDto(pardjbzService.getDraft(new PARDJBZ())));
    }




    @PreAuthorize("hasPermission(#pardjbz_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PARDJBZ" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pardjbzs/{pardjbz_id}")
    @Transactional
    public ResponseEntity<PARDJBZDTO> update(@PathVariable("pardjbz_id") String pardjbz_id, @RequestBody PARDJBZDTO pardjbzdto) {
		PARDJBZ domain = pardjbzMapping.toDomain(pardjbzdto);
        domain.setPardjbzid(pardjbz_id);
		pardjbzService.update(domain);
		PARDJBZDTO dto = pardjbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pardjbz_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PARDJBZ" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pardjbzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARDJBZDTO> pardjbzdtos) {
        pardjbzService.updateBatch(pardjbzMapping.toDomain(pardjbzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#pardjbz_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PARDJBZ" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pardjbzs/{pardjbz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pardjbz_id") String pardjbz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pardjbzService.remove(pardjbz_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PARDJBZ" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pardjbzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pardjbzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"PARDJBZ" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pardjbzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARDJBZDTO pardjbzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pardjbzService.checkKey(pardjbzMapping.toDomain(pardjbzdto)));
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"PARDJBZ" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pardjbzs/fetchdefault")
	public ResponseEntity<List<PARDJBZDTO>> fetchDefault(PARDJBZSearchContext context) {
        Page<PARDJBZ> domains = pardjbzService.searchDefault(context) ;
        List<PARDJBZDTO> list = pardjbzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"PARDJBZ" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pardjbzs/searchdefault")
	public ResponseEntity<Page<PARDJBZDTO>> searchDefault(@RequestBody PARDJBZSearchContext context) {
        Page<PARDJBZ> domains = pardjbzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pardjbzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PARDJBZ getEntity(){
        return new PARDJBZ();
    }

}
