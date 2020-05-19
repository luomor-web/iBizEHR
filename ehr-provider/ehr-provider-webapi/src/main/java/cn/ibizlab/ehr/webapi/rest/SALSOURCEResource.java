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
import cn.ibizlab.ehr.core.sal.domain.SALSOURCE;
import cn.ibizlab.ehr.core.sal.service.ISALSOURCEService;
import cn.ibizlab.ehr.core.sal.filter.SALSOURCESearchContext;




@Slf4j
@Api(tags = {"SALSOURCE" })
@RestController("WebApi-salsource")
@RequestMapping("")
public class SALSOURCEResource {

    @Autowired
    private ISALSOURCEService salsourceService;

    @Autowired
    @Lazy
    private SALSOURCEMapping salsourceMapping;




    @PreAuthorize("hasPermission(#salsource_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"SALSOURCE" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/salsources/{salsource_id}")
    public ResponseEntity<SALSOURCEDTO> get(@PathVariable("salsource_id") String salsource_id) {
        SALSOURCE domain = salsourceService.get(salsource_id);
        SALSOURCEDTO dto = salsourceMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "Save", tags = {"SALSOURCE" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/salsources/save")
    public ResponseEntity<Boolean> save(@RequestBody SALSOURCEDTO salsourcedto) {
        return ResponseEntity.status(HttpStatus.OK).body(salsourceService.save(salsourceMapping.toDomain(salsourcedto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"SALSOURCE" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salsources/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SALSOURCEDTO> salsourcedtos) {
        salsourceService.saveBatch(salsourceMapping.toDomain(salsourcedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#salsource_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"SALSOURCE" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/salsources/{salsource_id}")
    @Transactional
    public ResponseEntity<SALSOURCEDTO> update(@PathVariable("salsource_id") String salsource_id, @RequestBody SALSOURCEDTO salsourcedto) {
		SALSOURCE domain = salsourceMapping.toDomain(salsourcedto);
        domain.setSalsourceid(salsource_id);
		salsourceService.update(domain);
		SALSOURCEDTO dto = salsourceMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#salsource_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"SALSOURCE" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/salsources/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SALSOURCEDTO> salsourcedtos) {
        salsourceService.updateBatch(salsourceMapping.toDomain(salsourcedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#salsource_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"SALSOURCE" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salsources/{salsource_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salsource_id") String salsource_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salsourceService.remove(salsource_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"SALSOURCE" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salsources/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salsourceService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"SALSOURCE" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/salsources")
    @Transactional
    public ResponseEntity<SALSOURCEDTO> create(@RequestBody SALSOURCEDTO salsourcedto) {
        SALSOURCE domain = salsourceMapping.toDomain(salsourcedto);
		salsourceService.create(domain);
        SALSOURCEDTO dto = salsourceMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"SALSOURCE" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salsources/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SALSOURCEDTO> salsourcedtos) {
        salsourceService.createBatch(salsourceMapping.toDomain(salsourcedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"SALSOURCE" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/salsources/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SALSOURCEDTO salsourcedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salsourceService.checkKey(salsourceMapping.toDomain(salsourcedto)));
    }




    @ApiOperation(value = "GetDraft", tags = {"SALSOURCE" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/salsources/getdraft")
    public ResponseEntity<SALSOURCEDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salsourceMapping.toDto(salsourceService.getDraft(new SALSOURCE())));
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SALSOURCE" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salsources/fetchdefault")
	public ResponseEntity<List<SALSOURCEDTO>> fetchDefault(SALSOURCESearchContext context) {
        Page<SALSOURCE> domains = salsourceService.searchDefault(context) ;
        List<SALSOURCEDTO> list = salsourceMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"SALSOURCE" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salsources/searchdefault")
	public ResponseEntity<Page<SALSOURCEDTO>> searchDefault(SALSOURCESearchContext context) {
        Page<SALSOURCE> domains = salsourceService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salsourceMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public SALSOURCE getEntity(){
        return new SALSOURCE();
    }

}
