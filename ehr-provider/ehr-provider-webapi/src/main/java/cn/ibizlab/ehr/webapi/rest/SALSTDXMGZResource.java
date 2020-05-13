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
import cn.ibizlab.ehr.core.sal.domain.SALSTDXMGZ;
import cn.ibizlab.ehr.core.sal.service.ISALSTDXMGZService;
import cn.ibizlab.ehr.core.sal.filter.SALSTDXMGZSearchContext;




@Slf4j
@Api(tags = {"SALSTDXMGZ" })
@RestController("WebApi-salstdxmgz")
@RequestMapping("")
public class SALSTDXMGZResource {

    @Autowired
    private ISALSTDXMGZService salstdxmgzService;

    @Autowired
    @Lazy
    private SALSTDXMGZMapping salstdxmgzMapping;




    @ApiOperation(value = "CheckKey", tags = {"SALSTDXMGZ" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdxmgzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SALSTDXMGZDTO salstdxmgzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salstdxmgzService.checkKey(salstdxmgzMapping.toDomain(salstdxmgzdto)));
    }




    @PreAuthorize("hasPermission('Remove',{#salstdxmgz_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"SALSTDXMGZ" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdxmgzs/{salstdxmgz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salstdxmgz_id") String salstdxmgz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salstdxmgzService.remove(salstdxmgz_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"SALSTDXMGZ" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdxmgzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salstdxmgzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#salstdxmgz_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"SALSTDXMGZ" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdxmgzs/{salstdxmgz_id}")
    @Transactional
    public ResponseEntity<SALSTDXMGZDTO> update(@PathVariable("salstdxmgz_id") String salstdxmgz_id, @RequestBody SALSTDXMGZDTO salstdxmgzdto) {
		SALSTDXMGZ domain = salstdxmgzMapping.toDomain(salstdxmgzdto);
        domain.setSalstdxmgzid(salstdxmgz_id);
		salstdxmgzService.update(domain);
		SALSTDXMGZDTO dto = salstdxmgzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#salstdxmgz_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"SALSTDXMGZ" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdxmgzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SALSTDXMGZDTO> salstdxmgzdtos) {
        salstdxmgzService.updateBatch(salstdxmgzMapping.toDomain(salstdxmgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"SALSTDXMGZ" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdxmgzs/getdraft")
    public ResponseEntity<SALSTDXMGZDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salstdxmgzMapping.toDto(salstdxmgzService.getDraft(new SALSTDXMGZ())));
    }




    @ApiOperation(value = "Save", tags = {"SALSTDXMGZ" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdxmgzs/save")
    public ResponseEntity<Boolean> save(@RequestBody SALSTDXMGZDTO salstdxmgzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(salstdxmgzService.save(salstdxmgzMapping.toDomain(salstdxmgzdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"SALSTDXMGZ" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdxmgzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SALSTDXMGZDTO> salstdxmgzdtos) {
        salstdxmgzService.saveBatch(salstdxmgzMapping.toDomain(salstdxmgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#salstdxmgz_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"SALSTDXMGZ" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdxmgzs/{salstdxmgz_id}")
    public ResponseEntity<SALSTDXMGZDTO> get(@PathVariable("salstdxmgz_id") String salstdxmgz_id) {
        SALSTDXMGZ domain = salstdxmgzService.get(salstdxmgz_id);
        SALSTDXMGZDTO dto = salstdxmgzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"SALSTDXMGZ" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdxmgzs")
    @Transactional
    public ResponseEntity<SALSTDXMGZDTO> create(@RequestBody SALSTDXMGZDTO salstdxmgzdto) {
        SALSTDXMGZ domain = salstdxmgzMapping.toDomain(salstdxmgzdto);
		salstdxmgzService.create(domain);
        SALSTDXMGZDTO dto = salstdxmgzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"SALSTDXMGZ" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdxmgzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SALSTDXMGZDTO> salstdxmgzdtos) {
        salstdxmgzService.createBatch(salstdxmgzMapping.toDomain(salstdxmgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SALSTDXMGZ" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salstdxmgzs/fetchdefault")
	public ResponseEntity<List<SALSTDXMGZDTO>> fetchDefault(SALSTDXMGZSearchContext context) {
        Page<SALSTDXMGZ> domains = salstdxmgzService.searchDefault(context) ;
        List<SALSTDXMGZDTO> list = salstdxmgzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"SALSTDXMGZ" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salstdxmgzs/searchdefault")
	public ResponseEntity<Page<SALSTDXMGZDTO>> searchDefault(SALSTDXMGZSearchContext context) {
        Page<SALSTDXMGZ> domains = salstdxmgzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salstdxmgzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public SALSTDXMGZ getEntity(){
        return new SALSTDXMGZ();
    }

}
