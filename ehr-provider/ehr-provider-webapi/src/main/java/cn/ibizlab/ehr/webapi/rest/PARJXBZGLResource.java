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
import cn.ibizlab.ehr.core.par.domain.PARJXBZGL;
import cn.ibizlab.ehr.core.par.service.IPARJXBZGLService;
import cn.ibizlab.ehr.core.par.filter.PARJXBZGLSearchContext;




@Slf4j
@Api(tags = {"PARJXBZGL" })
@RestController("WebApi-parjxbzgl")
@RequestMapping("")
public class PARJXBZGLResource {

    @Autowired
    private IPARJXBZGLService parjxbzglService;

    @Autowired
    @Lazy
    private PARJXBZGLMapping parjxbzglMapping;




    @PreAuthorize("hasPermission(#parjxbzgl_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PARJXBZGL" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxbzgls/{parjxbzgl_id}")
    public ResponseEntity<PARJXBZGLDTO> get(@PathVariable("parjxbzgl_id") String parjxbzgl_id) {
        PARJXBZGL domain = parjxbzglService.get(parjxbzgl_id);
        PARJXBZGLDTO dto = parjxbzglMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "GetDraft", tags = {"PARJXBZGL" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxbzgls/getdraft")
    public ResponseEntity<PARJXBZGLDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parjxbzglMapping.toDto(parjxbzglService.getDraft(new PARJXBZGL())));
    }




    @ApiOperation(value = "Save", tags = {"PARJXBZGL" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzgls/save")
    public ResponseEntity<Boolean> save(@RequestBody PARJXBZGLDTO parjxbzgldto) {
        return ResponseEntity.status(HttpStatus.OK).body(parjxbzglService.save(parjxbzglMapping.toDomain(parjxbzgldto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PARJXBZGL" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzgls/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARJXBZGLDTO> parjxbzgldtos) {
        parjxbzglService.saveBatch(parjxbzglMapping.toDomain(parjxbzgldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PARJXBZGL" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzgls")
    @Transactional
    public ResponseEntity<PARJXBZGLDTO> create(@RequestBody PARJXBZGLDTO parjxbzgldto) {
        PARJXBZGL domain = parjxbzglMapping.toDomain(parjxbzgldto);
		parjxbzglService.create(domain);
        PARJXBZGLDTO dto = parjxbzglMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PARJXBZGL" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzgls/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARJXBZGLDTO> parjxbzgldtos) {
        parjxbzglService.createBatch(parjxbzglMapping.toDomain(parjxbzgldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#parjxbzgl_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PARJXBZGL" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxbzgls/{parjxbzgl_id}")
    @Transactional
    public ResponseEntity<PARJXBZGLDTO> update(@PathVariable("parjxbzgl_id") String parjxbzgl_id, @RequestBody PARJXBZGLDTO parjxbzgldto) {
		PARJXBZGL domain = parjxbzglMapping.toDomain(parjxbzgldto);
        domain.setParjxbzglid(parjxbzgl_id);
		parjxbzglService.update(domain);
		PARJXBZGLDTO dto = parjxbzglMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#parjxbzgl_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PARJXBZGL" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxbzgls/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARJXBZGLDTO> parjxbzgldtos) {
        parjxbzglService.updateBatch(parjxbzglMapping.toDomain(parjxbzgldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#parjxbzgl_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PARJXBZGL" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxbzgls/{parjxbzgl_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parjxbzgl_id") String parjxbzgl_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parjxbzglService.remove(parjxbzgl_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PARJXBZGL" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxbzgls/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parjxbzglService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"PARJXBZGL" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzgls/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARJXBZGLDTO parjxbzgldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parjxbzglService.checkKey(parjxbzglMapping.toDomain(parjxbzgldto)));
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PARJXBZGL" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parjxbzgls/fetchdefault")
	public ResponseEntity<List<PARJXBZGLDTO>> fetchDefault(PARJXBZGLSearchContext context) {
        Page<PARJXBZGL> domains = parjxbzglService.searchDefault(context) ;
        List<PARJXBZGLDTO> list = parjxbzglMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"PARJXBZGL" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parjxbzgls/searchdefault")
	public ResponseEntity<Page<PARJXBZGLDTO>> searchDefault(PARJXBZGLSearchContext context) {
        Page<PARJXBZGL> domains = parjxbzglService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjxbzglMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PARJXBZGL getEntity(){
        return new PARJXBZGL();
    }

}