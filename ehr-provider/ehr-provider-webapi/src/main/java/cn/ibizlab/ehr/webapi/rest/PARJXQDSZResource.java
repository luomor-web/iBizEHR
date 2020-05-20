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
import cn.ibizlab.ehr.core.par.domain.PARJXQDSZ;
import cn.ibizlab.ehr.core.par.service.IPARJXQDSZService;
import cn.ibizlab.ehr.core.par.filter.PARJXQDSZSearchContext;




@Slf4j
@Api(tags = {"PARJXQDSZ" })
@RestController("WebApi-parjxqdsz")
@RequestMapping("")
public class PARJXQDSZResource {

    @Autowired
    private IPARJXQDSZService parjxqdszService;

    @Autowired
    @Lazy
    private PARJXQDSZMapping parjxqdszMapping;




    @PreAuthorize("hasPermission(#parjxqdsz_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PARJXQDSZ" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxqdszs/{parjxqdsz_id}")
    @Transactional
    public ResponseEntity<PARJXQDSZDTO> update(@PathVariable("parjxqdsz_id") String parjxqdsz_id, @RequestBody PARJXQDSZDTO parjxqdszdto) {
		PARJXQDSZ domain = parjxqdszMapping.toDomain(parjxqdszdto);
        domain.setParjxqdszid(parjxqdsz_id);
		parjxqdszService.update(domain);
		PARJXQDSZDTO dto = parjxqdszMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#parjxqdsz_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PARJXQDSZ" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxqdszs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARJXQDSZDTO> parjxqdszdtos) {
        parjxqdszService.updateBatch(parjxqdszMapping.toDomain(parjxqdszdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#parjxqdsz_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PARJXQDSZ" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxqdszs/{parjxqdsz_id}")
    public ResponseEntity<PARJXQDSZDTO> get(@PathVariable("parjxqdsz_id") String parjxqdsz_id) {
        PARJXQDSZ domain = parjxqdszService.get(parjxqdsz_id);
        PARJXQDSZDTO dto = parjxqdszMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "Save", tags = {"PARJXQDSZ" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxqdszs/save")
    public ResponseEntity<Boolean> save(@RequestBody PARJXQDSZDTO parjxqdszdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parjxqdszService.save(parjxqdszMapping.toDomain(parjxqdszdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PARJXQDSZ" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxqdszs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARJXQDSZDTO> parjxqdszdtos) {
        parjxqdszService.saveBatch(parjxqdszMapping.toDomain(parjxqdszdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"PARJXQDSZ" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxqdszs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARJXQDSZDTO parjxqdszdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parjxqdszService.checkKey(parjxqdszMapping.toDomain(parjxqdszdto)));
    }




    @ApiOperation(value = "GetDraft", tags = {"PARJXQDSZ" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxqdszs/getdraft")
    public ResponseEntity<PARJXQDSZDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parjxqdszMapping.toDto(parjxqdszService.getDraft(new PARJXQDSZ())));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PARJXQDSZ" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxqdszs")
    @Transactional
    public ResponseEntity<PARJXQDSZDTO> create(@RequestBody PARJXQDSZDTO parjxqdszdto) {
        PARJXQDSZ domain = parjxqdszMapping.toDomain(parjxqdszdto);
		parjxqdszService.create(domain);
        PARJXQDSZDTO dto = parjxqdszMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PARJXQDSZ" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxqdszs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARJXQDSZDTO> parjxqdszdtos) {
        parjxqdszService.createBatch(parjxqdszMapping.toDomain(parjxqdszdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#parjxqdsz_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PARJXQDSZ" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxqdszs/{parjxqdsz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parjxqdsz_id") String parjxqdsz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parjxqdszService.remove(parjxqdsz_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PARJXQDSZ" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxqdszs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parjxqdszService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"PARJXQDSZ" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parjxqdszs/fetchdefault")
	public ResponseEntity<List<PARJXQDSZDTO>> fetchDefault(PARJXQDSZSearchContext context) {
        Page<PARJXQDSZ> domains = parjxqdszService.searchDefault(context) ;
        List<PARJXQDSZDTO> list = parjxqdszMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"PARJXQDSZ" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parjxqdszs/searchdefault")
	public ResponseEntity<Page<PARJXQDSZDTO>> searchDefault(@RequestBody PARJXQDSZSearchContext context) {
        Page<PARJXQDSZ> domains = parjxqdszService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjxqdszMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PARJXQDSZ getEntity(){
        return new PARJXQDSZ();
    }

}
