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
import cn.ibizlab.ehr.core.soc.domain.SOCSELFAREBASE;
import cn.ibizlab.ehr.core.soc.service.ISOCSELFAREBASEService;
import cn.ibizlab.ehr.core.soc.filter.SOCSELFAREBASESearchContext;




@Slf4j
@Api(tags = {"SOCSELFAREBASE" })
@RestController("WebApi-socselfarebase")
@RequestMapping("")
public class SOCSELFAREBASEResource {

    @Autowired
    private ISOCSELFAREBASEService socselfarebaseService;

    @Autowired
    @Lazy
    public SOCSELFAREBASEMapping socselfarebaseMapping;

    public SOCSELFAREBASEDTO permissionDTO=new SOCSELFAREBASEDTO();




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SOCSELFAREBASE-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"SOCSELFAREBASE" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/socselfarebases/getdraft")
    public ResponseEntity<SOCSELFAREBASEDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(socselfarebaseMapping.toDto(socselfarebaseService.getDraft(new SOCSELFAREBASE())));
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SOCSELFAREBASE-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"SOCSELFAREBASE" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/socselfarebases/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SOCSELFAREBASEDTO socselfarebasedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(socselfarebaseService.checkKey(socselfarebaseMapping.toDomain(socselfarebasedto)));
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SOCSELFAREBASE-Save-all')")
    @ApiOperation(value = "Save", tags = {"SOCSELFAREBASE" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/socselfarebases/save")
    public ResponseEntity<Boolean> save(@RequestBody SOCSELFAREBASEDTO socselfarebasedto) {
        return ResponseEntity.status(HttpStatus.OK).body(socselfarebaseService.save(socselfarebaseMapping.toDomain(socselfarebasedto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"SOCSELFAREBASE" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/socselfarebases/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SOCSELFAREBASEDTO> socselfarebasedtos) {
        socselfarebaseService.saveBatch(socselfarebaseMapping.toDomain(socselfarebasedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#socselfarebase_id,'Remove',{'Sql',this.socselfarebaseMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"SOCSELFAREBASE" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/socselfarebases/{socselfarebase_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("socselfarebase_id") String socselfarebase_id) {
         return ResponseEntity.status(HttpStatus.OK).body(socselfarebaseService.remove(socselfarebase_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"SOCSELFAREBASE" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/socselfarebases/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        socselfarebaseService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.socselfarebaseMapping,#socselfarebasedto})")
    @ApiOperation(value = "Create", tags = {"SOCSELFAREBASE" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/socselfarebases")
    @Transactional
    public ResponseEntity<SOCSELFAREBASEDTO> create(@RequestBody SOCSELFAREBASEDTO socselfarebasedto) {
        SOCSELFAREBASE domain = socselfarebaseMapping.toDomain(socselfarebasedto);
		socselfarebaseService.create(domain);
        SOCSELFAREBASEDTO dto = socselfarebaseMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"SOCSELFAREBASE" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/socselfarebases/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SOCSELFAREBASEDTO> socselfarebasedtos) {
        socselfarebaseService.createBatch(socselfarebaseMapping.toDomain(socselfarebasedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#socselfarebase_id,'Update',{'Sql',this.socselfarebaseMapping,#socselfarebasedto})")
    @ApiOperation(value = "Update", tags = {"SOCSELFAREBASE" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/socselfarebases/{socselfarebase_id}")
    @Transactional
    public ResponseEntity<SOCSELFAREBASEDTO> update(@PathVariable("socselfarebase_id") String socselfarebase_id, @RequestBody SOCSELFAREBASEDTO socselfarebasedto) {
		SOCSELFAREBASE domain = socselfarebaseMapping.toDomain(socselfarebasedto);
        domain.setSocselfarebaseid(socselfarebase_id);
		socselfarebaseService.update(domain);
		SOCSELFAREBASEDTO dto = socselfarebaseMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"SOCSELFAREBASE" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/socselfarebases/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SOCSELFAREBASEDTO> socselfarebasedtos) {
        socselfarebaseService.updateBatch(socselfarebaseMapping.toDomain(socselfarebasedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#socselfarebase_id,'Get',{'Sql',this.socselfarebaseMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"SOCSELFAREBASE" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/socselfarebases/{socselfarebase_id}")
    public ResponseEntity<SOCSELFAREBASEDTO> get(@PathVariable("socselfarebase_id") String socselfarebase_id) {
        SOCSELFAREBASE domain = socselfarebaseService.get(socselfarebase_id);
        SOCSELFAREBASEDTO dto = socselfarebaseMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SOCSELFAREBASE-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SOCSELFAREBASE" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/socselfarebases/fetchdefault")
	public ResponseEntity<List<SOCSELFAREBASEDTO>> fetchDefault(SOCSELFAREBASESearchContext context) {
        Page<SOCSELFAREBASE> domains = socselfarebaseService.searchDefault(context) ;
        List<SOCSELFAREBASEDTO> list = socselfarebaseMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SOCSELFAREBASE-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SOCSELFAREBASE" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/socselfarebases/searchdefault")
	public ResponseEntity<Page<SOCSELFAREBASEDTO>> searchDefault(@RequestBody SOCSELFAREBASESearchContext context) {
        Page<SOCSELFAREBASE> domains = socselfarebaseService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(socselfarebaseMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


