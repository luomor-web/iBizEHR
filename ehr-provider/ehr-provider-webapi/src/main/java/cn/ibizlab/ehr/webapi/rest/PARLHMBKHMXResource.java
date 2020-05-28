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
import org.springframework.security.access.prepost.PostAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import cn.ibizlab.ehr.webapi.dto.*;
import cn.ibizlab.ehr.webapi.mapping.*;
import cn.ibizlab.ehr.core.par.domain.PARLHMBKHMX;
import cn.ibizlab.ehr.core.par.service.IPARLHMBKHMXService;
import cn.ibizlab.ehr.core.par.filter.PARLHMBKHMXSearchContext;

@Slf4j
@Api(tags = {"PARLHMBKHMX" })
@RestController("WebApi-parlhmbkhmx")
@RequestMapping("")
public class PARLHMBKHMXResource {

    @Autowired
    public IPARLHMBKHMXService parlhmbkhmxService;

    @Autowired
    @Lazy
    public PARLHMBKHMXMapping parlhmbkhmxMapping;

    @PreAuthorize("hasPermission(this.parlhmbkhmxService.get(#parlhmbkhmx_id),'ehr-PARLHMBKHMX-Update')")
    @ApiOperation(value = "Update", tags = {"PARLHMBKHMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parlhmbkhmxes/{parlhmbkhmx_id}")
    @Transactional
    public ResponseEntity<PARLHMBKHMXDTO> update(@PathVariable("parlhmbkhmx_id") String parlhmbkhmx_id, @RequestBody PARLHMBKHMXDTO parlhmbkhmxdto) {
		PARLHMBKHMX domain  = parlhmbkhmxMapping.toDomain(parlhmbkhmxdto);
        domain .setParlhmbkhmxid(parlhmbkhmx_id);
		parlhmbkhmxService.update(domain );
		PARLHMBKHMXDTO dto = parlhmbkhmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parlhmbkhmxService.getParlhmbkhmxByEntities(this.parlhmbkhmxMapping.toDomain(#parlhmbkhmxdtos)),'ehr-PARLHMBKHMX-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PARLHMBKHMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parlhmbkhmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARLHMBKHMXDTO> parlhmbkhmxdtos) {
        parlhmbkhmxService.updateBatch(parlhmbkhmxMapping.toDomain(parlhmbkhmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"PARLHMBKHMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parlhmbkhmxes/getdraft")
    public ResponseEntity<PARLHMBKHMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parlhmbkhmxMapping.toDto(parlhmbkhmxService.getDraft(new PARLHMBKHMX())));
    }

    @PreAuthorize("hasPermission(this.parlhmbkhmxService.get(#parlhmbkhmx_id),'ehr-PARLHMBKHMX-Remove')")
    @ApiOperation(value = "Remove", tags = {"PARLHMBKHMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parlhmbkhmxes/{parlhmbkhmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parlhmbkhmx_id") String parlhmbkhmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parlhmbkhmxService.remove(parlhmbkhmx_id));
    }

    @PreAuthorize("hasPermission(this.parlhmbkhmxService.getParlhmbkhmxByIds(#ids),'ehr-PARLHMBKHMX-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PARLHMBKHMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parlhmbkhmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parlhmbkhmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parlhmbkhmxMapping.toDomain(#parlhmbkhmxdto),'ehr-PARLHMBKHMX-Save')")
    @ApiOperation(value = "Save", tags = {"PARLHMBKHMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parlhmbkhmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PARLHMBKHMXDTO parlhmbkhmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parlhmbkhmxService.save(parlhmbkhmxMapping.toDomain(parlhmbkhmxdto)));
    }

    @PreAuthorize("hasPermission(this.parlhmbkhmxMapping.toDomain(#parlhmbkhmxdtos),'ehr-PARLHMBKHMX-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PARLHMBKHMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parlhmbkhmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARLHMBKHMXDTO> parlhmbkhmxdtos) {
        parlhmbkhmxService.saveBatch(parlhmbkhmxMapping.toDomain(parlhmbkhmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"PARLHMBKHMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parlhmbkhmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARLHMBKHMXDTO parlhmbkhmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parlhmbkhmxService.checkKey(parlhmbkhmxMapping.toDomain(parlhmbkhmxdto)));
    }

    @PostAuthorize("hasPermission(this.parlhmbkhmxMapping.toDomain(returnObject.body),'ehr-PARLHMBKHMX-Get')")
    @ApiOperation(value = "Get", tags = {"PARLHMBKHMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parlhmbkhmxes/{parlhmbkhmx_id}")
    public ResponseEntity<PARLHMBKHMXDTO> get(@PathVariable("parlhmbkhmx_id") String parlhmbkhmx_id) {
        PARLHMBKHMX domain = parlhmbkhmxService.get(parlhmbkhmx_id);
        PARLHMBKHMXDTO dto = parlhmbkhmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parlhmbkhmxMapping.toDomain(#parlhmbkhmxdto),'ehr-PARLHMBKHMX-Create')")
    @ApiOperation(value = "Create", tags = {"PARLHMBKHMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parlhmbkhmxes")
    @Transactional
    public ResponseEntity<PARLHMBKHMXDTO> create(@RequestBody PARLHMBKHMXDTO parlhmbkhmxdto) {
        PARLHMBKHMX domain = parlhmbkhmxMapping.toDomain(parlhmbkhmxdto);
		parlhmbkhmxService.create(domain);
        PARLHMBKHMXDTO dto = parlhmbkhmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parlhmbkhmxMapping.toDomain(#parlhmbkhmxdtos),'ehr-PARLHMBKHMX-Create')")
    @ApiOperation(value = "createBatch", tags = {"PARLHMBKHMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parlhmbkhmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARLHMBKHMXDTO> parlhmbkhmxdtos) {
        parlhmbkhmxService.createBatch(parlhmbkhmxMapping.toDomain(parlhmbkhmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARLHMBKHMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PARLHMBKHMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parlhmbkhmxes/fetchdefault")
	public ResponseEntity<List<PARLHMBKHMXDTO>> fetchDefault(PARLHMBKHMXSearchContext context) {
        Page<PARLHMBKHMX> domains = parlhmbkhmxService.searchDefault(context) ;
        List<PARLHMBKHMXDTO> list = parlhmbkhmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARLHMBKHMX-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PARLHMBKHMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parlhmbkhmxes/searchdefault")
	public ResponseEntity<Page<PARLHMBKHMXDTO>> searchDefault(@RequestBody PARLHMBKHMXSearchContext context) {
        Page<PARLHMBKHMX> domains = parlhmbkhmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parlhmbkhmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

