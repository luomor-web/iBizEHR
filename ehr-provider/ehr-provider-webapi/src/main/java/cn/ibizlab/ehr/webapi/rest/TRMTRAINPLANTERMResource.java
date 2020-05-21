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
import cn.ibizlab.ehr.core.trm.domain.TRMTRAINPLANTERM;
import cn.ibizlab.ehr.core.trm.service.ITRMTRAINPLANTERMService;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINPLANTERMSearchContext;




@Slf4j
@Api(tags = {"TRMTRAINPLANTERM" })
@RestController("WebApi-trmtrainplanterm")
@RequestMapping("")
public class TRMTRAINPLANTERMResource {

    @Autowired
    private ITRMTRAINPLANTERMService trmtrainplantermService;

    @Autowired
    @Lazy
    public TRMTRAINPLANTERMMapping trmtrainplantermMapping;

    public TRMTRAINPLANTERMDTO permissionDTO=new TRMTRAINPLANTERMDTO();




    @PreAuthorize("hasPermission(#trmtrainplanterm_id,'Get',{'Sql',this.trmtrainplantermMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"TRMTRAINPLANTERM" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainplanterms/{trmtrainplanterm_id}")
    public ResponseEntity<TRMTRAINPLANTERMDTO> get(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id) {
        TRMTRAINPLANTERM domain = trmtrainplantermService.get(trmtrainplanterm_id);
        TRMTRAINPLANTERMDTO dto = trmtrainplantermMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#trmtrainplanterm_id,'Remove',{'Sql',this.trmtrainplantermMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"TRMTRAINPLANTERM" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainplanterms/{trmtrainplanterm_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermService.remove(trmtrainplanterm_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"TRMTRAINPLANTERM" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainplanterms/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtrainplantermService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINPLANTERM-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"TRMTRAINPLANTERM" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplanterms/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMTRAINPLANTERMDTO trmtrainplantermdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermService.checkKey(trmtrainplantermMapping.toDomain(trmtrainplantermdto)));
    }




    @PreAuthorize("hasPermission(#trmtrainplanterm_id,'Update',{'Sql',this.trmtrainplantermMapping,#trmtrainplantermdto})")
    @ApiOperation(value = "Update", tags = {"TRMTRAINPLANTERM" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainplanterms/{trmtrainplanterm_id}")
    @Transactional
    public ResponseEntity<TRMTRAINPLANTERMDTO> update(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TRMTRAINPLANTERMDTO trmtrainplantermdto) {
		TRMTRAINPLANTERM domain = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
        domain.setTrmtrainplantermid(trmtrainplanterm_id);
		trmtrainplantermService.update(domain);
		TRMTRAINPLANTERMDTO dto = trmtrainplantermMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"TRMTRAINPLANTERM" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainplanterms/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMTRAINPLANTERMDTO> trmtrainplantermdtos) {
        trmtrainplantermService.updateBatch(trmtrainplantermMapping.toDomain(trmtrainplantermdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINPLANTERM-Save-all')")
    @ApiOperation(value = "Save", tags = {"TRMTRAINPLANTERM" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplanterms/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMTRAINPLANTERMDTO trmtrainplantermdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermService.save(trmtrainplantermMapping.toDomain(trmtrainplantermdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"TRMTRAINPLANTERM" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplanterms/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMTRAINPLANTERMDTO> trmtrainplantermdtos) {
        trmtrainplantermService.saveBatch(trmtrainplantermMapping.toDomain(trmtrainplantermdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINPLANTERM-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"TRMTRAINPLANTERM" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainplanterms/getdraft")
    public ResponseEntity<TRMTRAINPLANTERMDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermMapping.toDto(trmtrainplantermService.getDraft(new TRMTRAINPLANTERM())));
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINPLANTERM-KB-all')")
    @ApiOperation(value = "开班", tags = {"TRMTRAINPLANTERM" },  notes = "开班")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplanterms/{trmtrainplanterm_id}/kb")
    @Transactional
    public ResponseEntity<TRMTRAINPLANTERMDTO> kB(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TRMTRAINPLANTERMDTO trmtrainplantermdto) {
        TRMTRAINPLANTERM trmtrainplanterm = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
        trmtrainplanterm = trmtrainplantermService.kB(trmtrainplanterm);
        trmtrainplantermdto = trmtrainplantermMapping.toDto(trmtrainplanterm);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermdto);
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.trmtrainplantermMapping,#trmtrainplantermdto})")
    @ApiOperation(value = "Create", tags = {"TRMTRAINPLANTERM" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplanterms")
    @Transactional
    public ResponseEntity<TRMTRAINPLANTERMDTO> create(@RequestBody TRMTRAINPLANTERMDTO trmtrainplantermdto) {
        TRMTRAINPLANTERM domain = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
		trmtrainplantermService.create(domain);
        TRMTRAINPLANTERMDTO dto = trmtrainplantermMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"TRMTRAINPLANTERM" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplanterms/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMTRAINPLANTERMDTO> trmtrainplantermdtos) {
        trmtrainplantermService.createBatch(trmtrainplantermMapping.toDomain(trmtrainplantermdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINPLANTERM-QX-all')")
    @ApiOperation(value = "取消", tags = {"TRMTRAINPLANTERM" },  notes = "取消")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplanterms/{trmtrainplanterm_id}/qx")
    @Transactional
    public ResponseEntity<TRMTRAINPLANTERMDTO> qX(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TRMTRAINPLANTERMDTO trmtrainplantermdto) {
        TRMTRAINPLANTERM trmtrainplanterm = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
        trmtrainplanterm = trmtrainplantermService.qX(trmtrainplanterm);
        trmtrainplantermdto = trmtrainplantermMapping.toDto(trmtrainplanterm);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermdto);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINPLANTERM-LX-all')")
    @ApiOperation(value = "立项", tags = {"TRMTRAINPLANTERM" },  notes = "立项")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainplanterms/{trmtrainplanterm_id}/lx")
    @Transactional
    public ResponseEntity<TRMTRAINPLANTERMDTO> lX(@PathVariable("trmtrainplanterm_id") String trmtrainplanterm_id, @RequestBody TRMTRAINPLANTERMDTO trmtrainplantermdto) {
        TRMTRAINPLANTERM trmtrainplanterm = trmtrainplantermMapping.toDomain(trmtrainplantermdto);
        trmtrainplanterm = trmtrainplantermService.lX(trmtrainplanterm);
        trmtrainplantermdto = trmtrainplantermMapping.toDto(trmtrainplanterm);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainplantermdto);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINPLANTERM-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TRMTRAINPLANTERM" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainplanterms/fetchdefault")
	public ResponseEntity<List<TRMTRAINPLANTERMDTO>> fetchDefault(TRMTRAINPLANTERMSearchContext context) {
        Page<TRMTRAINPLANTERM> domains = trmtrainplantermService.searchDefault(context) ;
        List<TRMTRAINPLANTERMDTO> list = trmtrainplantermMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINPLANTERM-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TRMTRAINPLANTERM" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainplanterms/searchdefault")
	public ResponseEntity<Page<TRMTRAINPLANTERMDTO>> searchDefault(@RequestBody TRMTRAINPLANTERMSearchContext context) {
        Page<TRMTRAINPLANTERM> domains = trmtrainplantermService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainplantermMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


