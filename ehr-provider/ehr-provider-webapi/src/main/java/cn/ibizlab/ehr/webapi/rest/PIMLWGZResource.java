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
import cn.ibizlab.ehr.core.pim.domain.PIMLWGZ;
import cn.ibizlab.ehr.core.pim.service.IPIMLWGZService;
import cn.ibizlab.ehr.core.pim.filter.PIMLWGZSearchContext;




@Slf4j
@Api(tags = {"PIMLWGZ" })
@RestController("WebApi-pimlwgz")
@RequestMapping("")
public class PIMLWGZResource {

    @Autowired
    private IPIMLWGZService pimlwgzService;

    @Autowired
    @Lazy
    public PIMLWGZMapping pimlwgzMapping;

    public PIMLWGZDTO permissionDTO=new PIMLWGZDTO();




    @PreAuthorize("hasPermission('','Create',{'Sql',this.pimlwgzMapping,#pimlwgzdto})")
    @ApiOperation(value = "Create", tags = {"PIMLWGZ" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimlwgzs")
    @Transactional
    public ResponseEntity<PIMLWGZDTO> create(@RequestBody PIMLWGZDTO pimlwgzdto) {
        PIMLWGZ domain = pimlwgzMapping.toDomain(pimlwgzdto);
		pimlwgzService.create(domain);
        PIMLWGZDTO dto = pimlwgzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"PIMLWGZ" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimlwgzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMLWGZDTO> pimlwgzdtos) {
        pimlwgzService.createBatch(pimlwgzMapping.toDomain(pimlwgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pimlwgz_id,'Get',{'Sql',this.pimlwgzMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PIMLWGZ" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimlwgzs/{pimlwgz_id}")
    public ResponseEntity<PIMLWGZDTO> get(@PathVariable("pimlwgz_id") String pimlwgz_id) {
        PIMLWGZ domain = pimlwgzService.get(pimlwgz_id);
        PIMLWGZDTO dto = pimlwgzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#pimlwgz_id,'Remove',{'Sql',this.pimlwgzMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PIMLWGZ" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimlwgzs/{pimlwgz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimlwgz_id") String pimlwgz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimlwgzService.remove(pimlwgz_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PIMLWGZ" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimlwgzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimlwgzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLWGZ-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PIMLWGZ" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimlwgzs/getdraft")
    public ResponseEntity<PIMLWGZDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimlwgzMapping.toDto(pimlwgzService.getDraft(new PIMLWGZ())));
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLWGZ-Save-all')")
    @ApiOperation(value = "Save", tags = {"PIMLWGZ" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimlwgzs/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMLWGZDTO pimlwgzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimlwgzService.save(pimlwgzMapping.toDomain(pimlwgzdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PIMLWGZ" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimlwgzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMLWGZDTO> pimlwgzdtos) {
        pimlwgzService.saveBatch(pimlwgzMapping.toDomain(pimlwgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pimlwgz_id,'Update',{'Sql',this.pimlwgzMapping,#pimlwgzdto})")
    @ApiOperation(value = "Update", tags = {"PIMLWGZ" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimlwgzs/{pimlwgz_id}")
    @Transactional
    public ResponseEntity<PIMLWGZDTO> update(@PathVariable("pimlwgz_id") String pimlwgz_id, @RequestBody PIMLWGZDTO pimlwgzdto) {
		PIMLWGZ domain = pimlwgzMapping.toDomain(pimlwgzdto);
        domain.setPimlwgzid(pimlwgz_id);
		pimlwgzService.update(domain);
		PIMLWGZDTO dto = pimlwgzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"PIMLWGZ" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimlwgzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMLWGZDTO> pimlwgzdtos) {
        pimlwgzService.updateBatch(pimlwgzMapping.toDomain(pimlwgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLWGZ-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PIMLWGZ" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimlwgzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMLWGZDTO pimlwgzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimlwgzService.checkKey(pimlwgzMapping.toDomain(pimlwgzdto)));
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLWGZ-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMLWGZ" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimlwgzs/fetchdefault")
	public ResponseEntity<List<PIMLWGZDTO>> fetchDefault(PIMLWGZSearchContext context) {
        Page<PIMLWGZ> domains = pimlwgzService.searchDefault(context) ;
        List<PIMLWGZDTO> list = pimlwgzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMLWGZ-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMLWGZ" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimlwgzs/searchdefault")
	public ResponseEntity<Page<PIMLWGZDTO>> searchDefault(@RequestBody PIMLWGZSearchContext context) {
        Page<PIMLWGZ> domains = pimlwgzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimlwgzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


