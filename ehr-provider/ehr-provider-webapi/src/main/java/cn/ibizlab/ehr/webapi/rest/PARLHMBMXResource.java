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
import cn.ibizlab.ehr.core.par.domain.PARLHMBMX;
import cn.ibizlab.ehr.core.par.service.IPARLHMBMXService;
import cn.ibizlab.ehr.core.par.filter.PARLHMBMXSearchContext;

@Slf4j
@Api(tags = {"PARLHMBMX" })
@RestController("WebApi-parlhmbmx")
@RequestMapping("")
public class PARLHMBMXResource {

    @Autowired
    private IPARLHMBMXService parlhmbmxService;

    @Autowired
    @Lazy
    public PARLHMBMXMapping parlhmbmxMapping;

    public PARLHMBMXDTO permissionDTO=new PARLHMBMXDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARLHMBMX-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PARLHMBMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parlhmbmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARLHMBMXDTO parlhmbmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parlhmbmxService.checkKey(parlhmbmxMapping.toDomain(parlhmbmxdto)));
    }

    @PreAuthorize("hasPermission(#parlhmbmx_id,'Remove',{'Sql',this.parlhmbmxMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PARLHMBMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parlhmbmxes/{parlhmbmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parlhmbmx_id") String parlhmbmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parlhmbmxService.remove(parlhmbmx_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.parlhmbmxMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PARLHMBMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parlhmbmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parlhmbmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.parlhmbmxMapping,#parlhmbmxdto})")
    @ApiOperation(value = "Save", tags = {"PARLHMBMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parlhmbmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PARLHMBMXDTO parlhmbmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parlhmbmxService.save(parlhmbmxMapping.toDomain(parlhmbmxdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.parlhmbmxMapping,#parlhmbmxdtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PARLHMBMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parlhmbmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARLHMBMXDTO> parlhmbmxdtos) {
        parlhmbmxService.saveBatch(parlhmbmxMapping.toDomain(parlhmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARLHMBMX-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PARLHMBMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parlhmbmxes/getdraft")
    public ResponseEntity<PARLHMBMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parlhmbmxMapping.toDto(parlhmbmxService.getDraft(new PARLHMBMX())));
    }

    @PreAuthorize("hasPermission(#parlhmbmx_id,'Get',{'Sql',this.parlhmbmxMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PARLHMBMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parlhmbmxes/{parlhmbmx_id}")
    public ResponseEntity<PARLHMBMXDTO> get(@PathVariable("parlhmbmx_id") String parlhmbmx_id) {
        PARLHMBMX domain = parlhmbmxService.get(parlhmbmx_id);
        PARLHMBMXDTO dto = parlhmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#parlhmbmx_id,'Update',{'Sql',this.parlhmbmxMapping,#parlhmbmxdto})")
    @ApiOperation(value = "Update", tags = {"PARLHMBMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parlhmbmxes/{parlhmbmx_id}")
    @Transactional
    public ResponseEntity<PARLHMBMXDTO> update(@PathVariable("parlhmbmx_id") String parlhmbmx_id, @RequestBody PARLHMBMXDTO parlhmbmxdto) {
		PARLHMBMX domain  = parlhmbmxMapping.toDomain(parlhmbmxdto);
        domain .setParlhmbmxid(parlhmbmx_id);
		parlhmbmxService.update(domain );
		PARLHMBMXDTO dto = parlhmbmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.parlhmbmxMapping,#parlhmbmxdtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PARLHMBMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parlhmbmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARLHMBMXDTO> parlhmbmxdtos) {
        parlhmbmxService.updateBatch(parlhmbmxMapping.toDomain(parlhmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.parlhmbmxMapping,#parlhmbmxdto})")
    @ApiOperation(value = "Create", tags = {"PARLHMBMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parlhmbmxes")
    @Transactional
    public ResponseEntity<PARLHMBMXDTO> create(@RequestBody PARLHMBMXDTO parlhmbmxdto) {
        PARLHMBMX domain = parlhmbmxMapping.toDomain(parlhmbmxdto);
		parlhmbmxService.create(domain);
        PARLHMBMXDTO dto = parlhmbmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.parlhmbmxMapping,#parlhmbmxdtos})")
    @ApiOperation(value = "createBatch", tags = {"PARLHMBMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parlhmbmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARLHMBMXDTO> parlhmbmxdtos) {
        parlhmbmxService.createBatch(parlhmbmxMapping.toDomain(parlhmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARLHMBMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PARLHMBMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parlhmbmxes/fetchdefault")
	public ResponseEntity<List<PARLHMBMXDTO>> fetchDefault(PARLHMBMXSearchContext context) {
        Page<PARLHMBMX> domains = parlhmbmxService.searchDefault(context) ;
        List<PARLHMBMXDTO> list = parlhmbmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARLHMBMX-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PARLHMBMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parlhmbmxes/searchdefault")
	public ResponseEntity<Page<PARLHMBMXDTO>> searchDefault(@RequestBody PARLHMBMXSearchContext context) {
        Page<PARLHMBMX> domains = parlhmbmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parlhmbmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
