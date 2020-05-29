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
import cn.ibizlab.ehr.core.par.domain.PARTZGG;
import cn.ibizlab.ehr.core.par.service.IPARTZGGService;
import cn.ibizlab.ehr.core.par.filter.PARTZGGSearchContext;

@Slf4j
@Api(tags = {"PARTZGG" })
@RestController("WebApi-partzgg")
@RequestMapping("")
public class PARTZGGResource {

    @Autowired
    public IPARTZGGService partzggService;

    @Autowired
    @Lazy
    public PARTZGGMapping partzggMapping;

    @ApiOperation(value = "GetDraft", tags = {"PARTZGG" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/partzggs/getdraft")
    public ResponseEntity<PARTZGGDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(partzggMapping.toDto(partzggService.getDraft(new PARTZGG())));
    }

    @PreAuthorize("hasPermission(this.partzggService.get(#partzgg_id),'ehr-PARTZGG-Remove')")
    @ApiOperation(value = "Remove", tags = {"PARTZGG" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/partzggs/{partzgg_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("partzgg_id") String partzgg_id) {
         return ResponseEntity.status(HttpStatus.OK).body(partzggService.remove(partzgg_id));
    }

    @PreAuthorize("hasPermission(this.partzggService.getPartzggByIds(#ids),'ehr-PARTZGG-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PARTZGG" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/partzggs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        partzggService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.partzggMapping.toDomain(#partzggdto),'ehr-PARTZGG-Save')")
    @ApiOperation(value = "Save", tags = {"PARTZGG" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/save")
    public ResponseEntity<Boolean> save(@RequestBody PARTZGGDTO partzggdto) {
        return ResponseEntity.status(HttpStatus.OK).body(partzggService.save(partzggMapping.toDomain(partzggdto)));
    }

    @PreAuthorize("hasPermission(this.partzggMapping.toDomain(#partzggdtos),'ehr-PARTZGG-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PARTZGG" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARTZGGDTO> partzggdtos) {
        partzggService.saveBatch(partzggMapping.toDomain(partzggdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.partzggMapping.toDomain(#partzggdto),'ehr-PARTZGG-Create')")
    @ApiOperation(value = "Create", tags = {"PARTZGG" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs")
    @Transactional
    public ResponseEntity<PARTZGGDTO> create(@RequestBody PARTZGGDTO partzggdto) {
        PARTZGG domain = partzggMapping.toDomain(partzggdto);
		partzggService.create(domain);
        PARTZGGDTO dto = partzggMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.partzggMapping.toDomain(#partzggdtos),'ehr-PARTZGG-Create')")
    @ApiOperation(value = "createBatch", tags = {"PARTZGG" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARTZGGDTO> partzggdtos) {
        partzggService.createBatch(partzggMapping.toDomain(partzggdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.partzggMapping.toDomain(returnObject.body),'ehr-PARTZGG-Get')")
    @ApiOperation(value = "Get", tags = {"PARTZGG" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/partzggs/{partzgg_id}")
    public ResponseEntity<PARTZGGDTO> get(@PathVariable("partzgg_id") String partzgg_id) {
        PARTZGG domain = partzggService.get(partzgg_id);
        PARTZGGDTO dto = partzggMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKey", tags = {"PARTZGG" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARTZGGDTO partzggdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(partzggService.checkKey(partzggMapping.toDomain(partzggdto)));
    }

    @PreAuthorize("hasPermission(this.partzggService.get(#partzgg_id),'ehr-PARTZGG-Update')")
    @ApiOperation(value = "Update", tags = {"PARTZGG" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/partzggs/{partzgg_id}")
    @Transactional
    public ResponseEntity<PARTZGGDTO> update(@PathVariable("partzgg_id") String partzgg_id, @RequestBody PARTZGGDTO partzggdto) {
		PARTZGG domain  = partzggMapping.toDomain(partzggdto);
        domain .setPartzggid(partzgg_id);
		partzggService.update(domain );
		PARTZGGDTO dto = partzggMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.partzggService.getPartzggByEntities(this.partzggMapping.toDomain(#partzggdtos)),'ehr-PARTZGG-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PARTZGG" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/partzggs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARTZGGDTO> partzggdtos) {
        partzggService.updateBatch(partzggMapping.toDomain(partzggdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARTZGG-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PARTZGG" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/partzggs/fetchdefault")
	public ResponseEntity<List<PARTZGGDTO>> fetchDefault(PARTZGGSearchContext context) {
        Page<PARTZGG> domains = partzggService.searchDefault(context) ;
        List<PARTZGGDTO> list = partzggMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARTZGG-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PARTZGG" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/partzggs/searchdefault")
	public ResponseEntity<Page<PARTZGGDTO>> searchDefault(@RequestBody PARTZGGSearchContext context) {
        Page<PARTZGG> domains = partzggService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(partzggMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

