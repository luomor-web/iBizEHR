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
import cn.ibizlab.ehr.core.par.domain.PARLDKHQZ;
import cn.ibizlab.ehr.core.par.service.IPARLDKHQZService;
import cn.ibizlab.ehr.core.par.filter.PARLDKHQZSearchContext;




@Slf4j
@Api(tags = {"PARLDKHQZ" })
@RestController("WebApi-parldkhqz")
@RequestMapping("")
public class PARLDKHQZResource {

    @Autowired
    private IPARLDKHQZService parldkhqzService;

    @Autowired
    @Lazy
    private PARLDKHQZMapping parldkhqzMapping;




    @ApiOperation(value = "CheckKey", tags = {"PARLDKHQZ" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parldkhqzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARLDKHQZDTO parldkhqzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parldkhqzService.checkKey(parldkhqzMapping.toDomain(parldkhqzdto)));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PARLDKHQZ" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parldkhqzs")
    @Transactional
    public ResponseEntity<PARLDKHQZDTO> create(@RequestBody PARLDKHQZDTO parldkhqzdto) {
        PARLDKHQZ domain = parldkhqzMapping.toDomain(parldkhqzdto);
		parldkhqzService.create(domain);
        PARLDKHQZDTO dto = parldkhqzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PARLDKHQZ" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parldkhqzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARLDKHQZDTO> parldkhqzdtos) {
        parldkhqzService.createBatch(parldkhqzMapping.toDomain(parldkhqzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PARLDKHQZ" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parldkhqzs/getdraft")
    public ResponseEntity<PARLDKHQZDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parldkhqzMapping.toDto(parldkhqzService.getDraft(new PARLDKHQZ())));
    }




    @PreAuthorize("hasPermission(#parldkhqz_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PARLDKHQZ" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parldkhqzs/{parldkhqz_id}")
    public ResponseEntity<PARLDKHQZDTO> get(@PathVariable("parldkhqz_id") String parldkhqz_id) {
        PARLDKHQZ domain = parldkhqzService.get(parldkhqz_id);
        PARLDKHQZDTO dto = parldkhqzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('Remove',{#parldkhqz_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PARLDKHQZ" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parldkhqzs/{parldkhqz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parldkhqz_id") String parldkhqz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parldkhqzService.remove(parldkhqz_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PARLDKHQZ" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parldkhqzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parldkhqzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"PARLDKHQZ" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parldkhqzs/save")
    public ResponseEntity<Boolean> save(@RequestBody PARLDKHQZDTO parldkhqzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parldkhqzService.save(parldkhqzMapping.toDomain(parldkhqzdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PARLDKHQZ" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parldkhqzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARLDKHQZDTO> parldkhqzdtos) {
        parldkhqzService.saveBatch(parldkhqzMapping.toDomain(parldkhqzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#parldkhqz_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PARLDKHQZ" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parldkhqzs/{parldkhqz_id}")
    @Transactional
    public ResponseEntity<PARLDKHQZDTO> update(@PathVariable("parldkhqz_id") String parldkhqz_id, @RequestBody PARLDKHQZDTO parldkhqzdto) {
		PARLDKHQZ domain = parldkhqzMapping.toDomain(parldkhqzdto);
        domain.setParldkhqzid(parldkhqz_id);
		parldkhqzService.update(domain);
		PARLDKHQZDTO dto = parldkhqzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#parldkhqz_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PARLDKHQZ" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parldkhqzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARLDKHQZDTO> parldkhqzdtos) {
        parldkhqzService.updateBatch(parldkhqzMapping.toDomain(parldkhqzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PARLDKHQZ" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parldkhqzs/fetchdefault")
	public ResponseEntity<List<PARLDKHQZDTO>> fetchDefault(PARLDKHQZSearchContext context) {
        Page<PARLDKHQZ> domains = parldkhqzService.searchDefault(context) ;
        List<PARLDKHQZDTO> list = parldkhqzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"PARLDKHQZ" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parldkhqzs/searchdefault")
	public ResponseEntity<Page<PARLDKHQZDTO>> searchDefault(PARLDKHQZSearchContext context) {
        Page<PARLDKHQZ> domains = parldkhqzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parldkhqzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PARLDKHQZ getEntity(){
        return new PARLDKHQZ();
    }

}
