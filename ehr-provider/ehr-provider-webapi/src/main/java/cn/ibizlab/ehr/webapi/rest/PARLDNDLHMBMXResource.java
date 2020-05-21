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
import cn.ibizlab.ehr.core.par.domain.PARLDNDLHMBMX;
import cn.ibizlab.ehr.core.par.service.IPARLDNDLHMBMXService;
import cn.ibizlab.ehr.core.par.filter.PARLDNDLHMBMXSearchContext;




@Slf4j
@Api(tags = {"PARLDNDLHMBMX" })
@RestController("WebApi-parldndlhmbmx")
@RequestMapping("")
public class PARLDNDLHMBMXResource {

    @Autowired
    private IPARLDNDLHMBMXService parldndlhmbmxService;

    @Autowired
    @Lazy
    public PARLDNDLHMBMXMapping parldndlhmbmxMapping;

    public PARLDNDLHMBMXDTO permissionDTO=new PARLDNDLHMBMXDTO();




    @PreAuthorize("hasPermission(#parldndlhmbmx_id,'Get',{'Sql',this.parldndlhmbmxMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PARLDNDLHMBMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parldndlhmbmxes/{parldndlhmbmx_id}")
    public ResponseEntity<PARLDNDLHMBMXDTO> get(@PathVariable("parldndlhmbmx_id") String parldndlhmbmx_id) {
        PARLDNDLHMBMX domain = parldndlhmbmxService.get(parldndlhmbmx_id);
        PARLDNDLHMBMXDTO dto = parldndlhmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARLDNDLHMBMX-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PARLDNDLHMBMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parldndlhmbmxes/getdraft")
    public ResponseEntity<PARLDNDLHMBMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parldndlhmbmxMapping.toDto(parldndlhmbmxService.getDraft(new PARLDNDLHMBMX())));
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.parldndlhmbmxMapping,#parldndlhmbmxdto})")
    @ApiOperation(value = "Create", tags = {"PARLDNDLHMBMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parldndlhmbmxes")
    @Transactional
    public ResponseEntity<PARLDNDLHMBMXDTO> create(@RequestBody PARLDNDLHMBMXDTO parldndlhmbmxdto) {
        PARLDNDLHMBMX domain = parldndlhmbmxMapping.toDomain(parldndlhmbmxdto);
		parldndlhmbmxService.create(domain);
        PARLDNDLHMBMXDTO dto = parldndlhmbmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"PARLDNDLHMBMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parldndlhmbmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARLDNDLHMBMXDTO> parldndlhmbmxdtos) {
        parldndlhmbmxService.createBatch(parldndlhmbmxMapping.toDomain(parldndlhmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARLDNDLHMBMX-Save-all')")
    @ApiOperation(value = "Save", tags = {"PARLDNDLHMBMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parldndlhmbmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PARLDNDLHMBMXDTO parldndlhmbmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parldndlhmbmxService.save(parldndlhmbmxMapping.toDomain(parldndlhmbmxdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PARLDNDLHMBMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parldndlhmbmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARLDNDLHMBMXDTO> parldndlhmbmxdtos) {
        parldndlhmbmxService.saveBatch(parldndlhmbmxMapping.toDomain(parldndlhmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#parldndlhmbmx_id,'Remove',{'Sql',this.parldndlhmbmxMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PARLDNDLHMBMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parldndlhmbmxes/{parldndlhmbmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parldndlhmbmx_id") String parldndlhmbmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parldndlhmbmxService.remove(parldndlhmbmx_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PARLDNDLHMBMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parldndlhmbmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parldndlhmbmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARLDNDLHMBMX-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PARLDNDLHMBMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parldndlhmbmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARLDNDLHMBMXDTO parldndlhmbmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parldndlhmbmxService.checkKey(parldndlhmbmxMapping.toDomain(parldndlhmbmxdto)));
    }




    @PreAuthorize("hasPermission(#parldndlhmbmx_id,'Update',{'Sql',this.parldndlhmbmxMapping,#parldndlhmbmxdto})")
    @ApiOperation(value = "Update", tags = {"PARLDNDLHMBMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parldndlhmbmxes/{parldndlhmbmx_id}")
    @Transactional
    public ResponseEntity<PARLDNDLHMBMXDTO> update(@PathVariable("parldndlhmbmx_id") String parldndlhmbmx_id, @RequestBody PARLDNDLHMBMXDTO parldndlhmbmxdto) {
		PARLDNDLHMBMX domain = parldndlhmbmxMapping.toDomain(parldndlhmbmxdto);
        domain.setParldndlhmbmxid(parldndlhmbmx_id);
		parldndlhmbmxService.update(domain);
		PARLDNDLHMBMXDTO dto = parldndlhmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"PARLDNDLHMBMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parldndlhmbmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARLDNDLHMBMXDTO> parldndlhmbmxdtos) {
        parldndlhmbmxService.updateBatch(parldndlhmbmxMapping.toDomain(parldndlhmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARLDNDLHMBMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PARLDNDLHMBMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parldndlhmbmxes/fetchdefault")
	public ResponseEntity<List<PARLDNDLHMBMXDTO>> fetchDefault(PARLDNDLHMBMXSearchContext context) {
        Page<PARLDNDLHMBMX> domains = parldndlhmbmxService.searchDefault(context) ;
        List<PARLDNDLHMBMXDTO> list = parldndlhmbmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARLDNDLHMBMX-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PARLDNDLHMBMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parldndlhmbmxes/searchdefault")
	public ResponseEntity<Page<PARLDNDLHMBMXDTO>> searchDefault(@RequestBody PARLDNDLHMBMXSearchContext context) {
        Page<PARLDNDLHMBMX> domains = parldndlhmbmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parldndlhmbmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


