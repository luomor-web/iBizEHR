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
import cn.ibizlab.ehr.core.par.domain.PARYDGZJHMX;
import cn.ibizlab.ehr.core.par.service.IPARYDGZJHMXService;
import cn.ibizlab.ehr.core.par.filter.PARYDGZJHMXSearchContext;

@Slf4j
@Api(tags = {"PARYDGZJHMX" })
@RestController("WebApi-parydgzjhmx")
@RequestMapping("")
public class PARYDGZJHMXResource {

    @Autowired
    private IPARYDGZJHMXService parydgzjhmxService;

    @Autowired
    @Lazy
    public PARYDGZJHMXMapping parydgzjhmxMapping;

    public PARYDGZJHMXDTO permissionDTO=new PARYDGZJHMXDTO();

    @PreAuthorize("hasPermission(#parydgzjhmx_id,'Update',{'Sql',this.parydgzjhmxMapping,#parydgzjhmxdto})")
    @ApiOperation(value = "Update", tags = {"PARYDGZJHMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parydgzjhmxes/{parydgzjhmx_id}")
    @Transactional
    public ResponseEntity<PARYDGZJHMXDTO> update(@PathVariable("parydgzjhmx_id") String parydgzjhmx_id, @RequestBody PARYDGZJHMXDTO parydgzjhmxdto) {
		PARYDGZJHMX domain = parydgzjhmxMapping.toDomain(parydgzjhmxdto);
        domain.setParydgzjhmxid(parydgzjhmx_id);
		parydgzjhmxService.update(domain);
		PARYDGZJHMXDTO dto = parydgzjhmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PARYDGZJHMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parydgzjhmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARYDGZJHMXDTO> parydgzjhmxdtos) {
        parydgzjhmxService.updateBatch(parydgzjhmxMapping.toDomain(parydgzjhmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.parydgzjhmxMapping,#parydgzjhmxdto})")
    @ApiOperation(value = "Save", tags = {"PARYDGZJHMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parydgzjhmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PARYDGZJHMXDTO parydgzjhmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parydgzjhmxService.save(parydgzjhmxMapping.toDomain(parydgzjhmxdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PARYDGZJHMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parydgzjhmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARYDGZJHMXDTO> parydgzjhmxdtos) {
        parydgzjhmxService.saveBatch(parydgzjhmxMapping.toDomain(parydgzjhmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#parydgzjhmx_id,'Remove',{'Sql',this.parydgzjhmxMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PARYDGZJHMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parydgzjhmxes/{parydgzjhmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parydgzjhmx_id") String parydgzjhmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parydgzjhmxService.remove(parydgzjhmx_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PARYDGZJHMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parydgzjhmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parydgzjhmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#parydgzjhmx_id,'Get',{'Sql',this.parydgzjhmxMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PARYDGZJHMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parydgzjhmxes/{parydgzjhmx_id}")
    public ResponseEntity<PARYDGZJHMXDTO> get(@PathVariable("parydgzjhmx_id") String parydgzjhmx_id) {
        PARYDGZJHMX domain = parydgzjhmxService.get(parydgzjhmx_id);
        PARYDGZJHMXDTO dto = parydgzjhmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARYDGZJHMX-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PARYDGZJHMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parydgzjhmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARYDGZJHMXDTO parydgzjhmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parydgzjhmxService.checkKey(parydgzjhmxMapping.toDomain(parydgzjhmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARYDGZJHMX-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PARYDGZJHMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parydgzjhmxes/getdraft")
    public ResponseEntity<PARYDGZJHMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parydgzjhmxMapping.toDto(parydgzjhmxService.getDraft(new PARYDGZJHMX())));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.parydgzjhmxMapping,#parydgzjhmxdto})")
    @ApiOperation(value = "Create", tags = {"PARYDGZJHMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parydgzjhmxes")
    @Transactional
    public ResponseEntity<PARYDGZJHMXDTO> create(@RequestBody PARYDGZJHMXDTO parydgzjhmxdto) {
        PARYDGZJHMX domain = parydgzjhmxMapping.toDomain(parydgzjhmxdto);
		parydgzjhmxService.create(domain);
        PARYDGZJHMXDTO dto = parydgzjhmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"PARYDGZJHMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parydgzjhmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARYDGZJHMXDTO> parydgzjhmxdtos) {
        parydgzjhmxService.createBatch(parydgzjhmxMapping.toDomain(parydgzjhmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARYDGZJHMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PARYDGZJHMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parydgzjhmxes/fetchdefault")
	public ResponseEntity<List<PARYDGZJHMXDTO>> fetchDefault(PARYDGZJHMXSearchContext context) {
        Page<PARYDGZJHMX> domains = parydgzjhmxService.searchDefault(context) ;
        List<PARYDGZJHMXDTO> list = parydgzjhmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARYDGZJHMX-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PARYDGZJHMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parydgzjhmxes/searchdefault")
	public ResponseEntity<Page<PARYDGZJHMXDTO>> searchDefault(@RequestBody PARYDGZJHMXSearchContext context) {
        Page<PARYDGZJHMX> domains = parydgzjhmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parydgzjhmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
