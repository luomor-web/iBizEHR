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
import cn.ibizlab.ehr.core.trm.domain.TRMCOURSESYSTEM;
import cn.ibizlab.ehr.core.trm.service.ITRMCOURSESYSTEMService;
import cn.ibizlab.ehr.core.trm.filter.TRMCOURSESYSTEMSearchContext;




@Slf4j
@Api(tags = {"TRMCOURSESYSTEM" })
@RestController("WebApi-trmcoursesystem")
@RequestMapping("")
public class TRMCOURSESYSTEMResource {

    @Autowired
    private ITRMCOURSESYSTEMService trmcoursesystemService;

    @Autowired
    @Lazy
    private TRMCOURSESYSTEMMapping trmcoursesystemMapping;




    @PreAuthorize("hasPermission(#trmcoursesystem_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"TRMCOURSESYSTEM" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmcoursesystems/{trmcoursesystem_id}")
    @Transactional
    public ResponseEntity<TRMCOURSESYSTEMDTO> update(@PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @RequestBody TRMCOURSESYSTEMDTO trmcoursesystemdto) {
		TRMCOURSESYSTEM domain = trmcoursesystemMapping.toDomain(trmcoursesystemdto);
        domain.setTrmcoursesystemid(trmcoursesystem_id);
		trmcoursesystemService.update(domain);
		TRMCOURSESYSTEMDTO dto = trmcoursesystemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#trmcoursesystem_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"TRMCOURSESYSTEM" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmcoursesystems/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMCOURSESYSTEMDTO> trmcoursesystemdtos) {
        trmcoursesystemService.updateBatch(trmcoursesystemMapping.toDomain(trmcoursesystemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"TRMCOURSESYSTEM" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcoursesystems/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMCOURSESYSTEMDTO trmcoursesystemdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmcoursesystemService.save(trmcoursesystemMapping.toDomain(trmcoursesystemdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"TRMCOURSESYSTEM" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcoursesystems/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMCOURSESYSTEMDTO> trmcoursesystemdtos) {
        trmcoursesystemService.saveBatch(trmcoursesystemMapping.toDomain(trmcoursesystemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"TRMCOURSESYSTEM" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcoursesystems/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMCOURSESYSTEMDTO trmcoursesystemdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmcoursesystemService.checkKey(trmcoursesystemMapping.toDomain(trmcoursesystemdto)));
    }




    @ApiOperation(value = "GetDraft", tags = {"TRMCOURSESYSTEM" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmcoursesystems/getdraft")
    public ResponseEntity<TRMCOURSESYSTEMDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmcoursesystemMapping.toDto(trmcoursesystemService.getDraft(new TRMCOURSESYSTEM())));
    }




    @PreAuthorize("hasPermission(#trmcoursesystem_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"TRMCOURSESYSTEM" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmcoursesystems/{trmcoursesystem_id}")
    public ResponseEntity<TRMCOURSESYSTEMDTO> get(@PathVariable("trmcoursesystem_id") String trmcoursesystem_id) {
        TRMCOURSESYSTEM domain = trmcoursesystemService.get(trmcoursesystem_id);
        TRMCOURSESYSTEMDTO dto = trmcoursesystemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('Remove',{#trmcoursesystem_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"TRMCOURSESYSTEM" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmcoursesystems/{trmcoursesystem_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmcoursesystem_id") String trmcoursesystem_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmcoursesystemService.remove(trmcoursesystem_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"TRMCOURSESYSTEM" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmcoursesystems/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmcoursesystemService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"TRMCOURSESYSTEM" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcoursesystems")
    @Transactional
    public ResponseEntity<TRMCOURSESYSTEMDTO> create(@RequestBody TRMCOURSESYSTEMDTO trmcoursesystemdto) {
        TRMCOURSESYSTEM domain = trmcoursesystemMapping.toDomain(trmcoursesystemdto);
		trmcoursesystemService.create(domain);
        TRMCOURSESYSTEMDTO dto = trmcoursesystemMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"TRMCOURSESYSTEM" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcoursesystems/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMCOURSESYSTEMDTO> trmcoursesystemdtos) {
        trmcoursesystemService.createBatch(trmcoursesystemMapping.toDomain(trmcoursesystemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TRMCOURSESYSTEM" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmcoursesystems/fetchdefault")
	public ResponseEntity<List<TRMCOURSESYSTEMDTO>> fetchDefault(TRMCOURSESYSTEMSearchContext context) {
        Page<TRMCOURSESYSTEM> domains = trmcoursesystemService.searchDefault(context) ;
        List<TRMCOURSESYSTEMDTO> list = trmcoursesystemMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"TRMCOURSESYSTEM" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmcoursesystems/searchdefault")
	public ResponseEntity<Page<TRMCOURSESYSTEMDTO>> searchDefault(TRMCOURSESYSTEMSearchContext context) {
        Page<TRMCOURSESYSTEM> domains = trmcoursesystemService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmcoursesystemMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public TRMCOURSESYSTEM getEntity(){
        return new TRMCOURSESYSTEM();
    }

}
