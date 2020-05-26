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
import cn.ibizlab.ehr.core.par.domain.PARJXBZGLMX;
import cn.ibizlab.ehr.core.par.service.IPARJXBZGLMXService;
import cn.ibizlab.ehr.core.par.filter.PARJXBZGLMXSearchContext;

@Slf4j
@Api(tags = {"PARJXBZGLMX" })
@RestController("WebApi-parjxbzglmx")
@RequestMapping("")
public class PARJXBZGLMXResource {

    @Autowired
    private IPARJXBZGLMXService parjxbzglmxService;

    @Autowired
    @Lazy
    public PARJXBZGLMXMapping parjxbzglmxMapping;

    public PARJXBZGLMXDTO permissionDTO=new PARJXBZGLMXDTO();

    @PreAuthorize("hasPermission(#parjxbzglmx_id,'Update',{'Sql',this.parjxbzglmxMapping,#parjxbzglmxdto})")
    @ApiOperation(value = "Update", tags = {"PARJXBZGLMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxbzglmxes/{parjxbzglmx_id}")
    @Transactional
    public ResponseEntity<PARJXBZGLMXDTO> update(@PathVariable("parjxbzglmx_id") String parjxbzglmx_id, @RequestBody PARJXBZGLMXDTO parjxbzglmxdto) {
		PARJXBZGLMX domain  = parjxbzglmxMapping.toDomain(parjxbzglmxdto);
        domain .setParjxbzglmxid(parjxbzglmx_id);
		parjxbzglmxService.update(domain );
		PARJXBZGLMXDTO dto = parjxbzglmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.parjxbzglmxMapping,#parjxbzglmxdtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PARJXBZGLMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxbzglmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARJXBZGLMXDTO> parjxbzglmxdtos) {
        parjxbzglmxService.updateBatch(parjxbzglmxMapping.toDomain(parjxbzglmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.parjxbzglmxMapping,#parjxbzglmxdto})")
    @ApiOperation(value = "Save", tags = {"PARJXBZGLMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzglmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PARJXBZGLMXDTO parjxbzglmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parjxbzglmxService.save(parjxbzglmxMapping.toDomain(parjxbzglmxdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.parjxbzglmxMapping,#parjxbzglmxdtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PARJXBZGLMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzglmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARJXBZGLMXDTO> parjxbzglmxdtos) {
        parjxbzglmxService.saveBatch(parjxbzglmxMapping.toDomain(parjxbzglmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#parjxbzglmx_id,'Get',{'Sql',this.parjxbzglmxMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PARJXBZGLMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxbzglmxes/{parjxbzglmx_id}")
    public ResponseEntity<PARJXBZGLMXDTO> get(@PathVariable("parjxbzglmx_id") String parjxbzglmx_id) {
        PARJXBZGLMX domain = parjxbzglmxService.get(parjxbzglmx_id);
        PARJXBZGLMXDTO dto = parjxbzglmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#parjxbzglmx_id,'Remove',{'Sql',this.parjxbzglmxMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PARJXBZGLMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxbzglmxes/{parjxbzglmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parjxbzglmx_id") String parjxbzglmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parjxbzglmxService.remove(parjxbzglmx_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.parjxbzglmxMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PARJXBZGLMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxbzglmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parjxbzglmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.parjxbzglmxMapping,#parjxbzglmxdto})")
    @ApiOperation(value = "Create", tags = {"PARJXBZGLMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzglmxes")
    @Transactional
    public ResponseEntity<PARJXBZGLMXDTO> create(@RequestBody PARJXBZGLMXDTO parjxbzglmxdto) {
        PARJXBZGLMX domain = parjxbzglmxMapping.toDomain(parjxbzglmxdto);
		parjxbzglmxService.create(domain);
        PARJXBZGLMXDTO dto = parjxbzglmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.parjxbzglmxMapping,#parjxbzglmxdtos})")
    @ApiOperation(value = "createBatch", tags = {"PARJXBZGLMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzglmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARJXBZGLMXDTO> parjxbzglmxdtos) {
        parjxbzglmxService.createBatch(parjxbzglmxMapping.toDomain(parjxbzglmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXBZGLMX-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PARJXBZGLMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxbzglmxes/getdraft")
    public ResponseEntity<PARJXBZGLMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parjxbzglmxMapping.toDto(parjxbzglmxService.getDraft(new PARJXBZGLMX())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXBZGLMX-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PARJXBZGLMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzglmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARJXBZGLMXDTO parjxbzglmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parjxbzglmxService.checkKey(parjxbzglmxMapping.toDomain(parjxbzglmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXBZGLMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PARJXBZGLMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parjxbzglmxes/fetchdefault")
	public ResponseEntity<List<PARJXBZGLMXDTO>> fetchDefault(PARJXBZGLMXSearchContext context) {
        Page<PARJXBZGLMX> domains = parjxbzglmxService.searchDefault(context) ;
        List<PARJXBZGLMXDTO> list = parjxbzglmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXBZGLMX-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PARJXBZGLMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parjxbzglmxes/searchdefault")
	public ResponseEntity<Page<PARJXBZGLMXDTO>> searchDefault(@RequestBody PARJXBZGLMXSearchContext context) {
        Page<PARJXBZGLMX> domains = parjxbzglmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjxbzglmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
