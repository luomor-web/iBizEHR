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
import cn.ibizlab.ehr.core.sal.domain.SalStdGwGzrate;
import cn.ibizlab.ehr.core.sal.service.ISalStdGwGzrateService;
import cn.ibizlab.ehr.core.sal.filter.SalStdGwGzrateSearchContext;

@Slf4j
@Api(tags = {"SalStdGwGzrate" })
@RestController("WebApi-salstdgwgzrate")
@RequestMapping("")
public class SalStdGwGzrateResource {

    @Autowired
    public ISalStdGwGzrateService salstdgwgzrateService;

    @Autowired
    @Lazy
    public SalStdGwGzrateMapping salstdgwgzrateMapping;

    @ApiOperation(value = "CheckKey", tags = {"SalStdGwGzrate" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgwgzrates/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SalStdGwGzrateDTO salstdgwgzratedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salstdgwgzrateService.checkKey(salstdgwgzrateMapping.toDomain(salstdgwgzratedto)));
    }

    @PostAuthorize("hasPermission(this.salstdgwgzrateMapping.toDomain(returnObject.body),'ehr-SalStdGwGzrate-Get')")
    @ApiOperation(value = "Get", tags = {"SalStdGwGzrate" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdgwgzrates/{salstdgwgzrate_id}")
    public ResponseEntity<SalStdGwGzrateDTO> get(@PathVariable("salstdgwgzrate_id") String salstdgwgzrate_id) {
        SalStdGwGzrate domain = salstdgwgzrateService.get(salstdgwgzrate_id);
        SalStdGwGzrateDTO dto = salstdgwgzrateMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salstdgwgzrateService.get(#salstdgwgzrate_id),'ehr-SalStdGwGzrate-Remove')")
    @ApiOperation(value = "Remove", tags = {"SalStdGwGzrate" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdgwgzrates/{salstdgwgzrate_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salstdgwgzrate_id") String salstdgwgzrate_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salstdgwgzrateService.remove(salstdgwgzrate_id));
    }

    @PreAuthorize("hasPermission(this.salstdgwgzrateService.getSalstdgwgzrateByIds(#ids),'ehr-SalStdGwGzrate-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"SalStdGwGzrate" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdgwgzrates/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salstdgwgzrateService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salstdgwgzrateMapping.toDomain(#salstdgwgzratedto),'ehr-SalStdGwGzrate-Create')")
    @ApiOperation(value = "Create", tags = {"SalStdGwGzrate" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgwgzrates")
    @Transactional
    public ResponseEntity<SalStdGwGzrateDTO> create(@RequestBody SalStdGwGzrateDTO salstdgwgzratedto) {
        SalStdGwGzrate domain = salstdgwgzrateMapping.toDomain(salstdgwgzratedto);
		salstdgwgzrateService.create(domain);
        SalStdGwGzrateDTO dto = salstdgwgzrateMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salstdgwgzrateMapping.toDomain(#salstdgwgzratedtos),'ehr-SalStdGwGzrate-Create')")
    @ApiOperation(value = "createBatch", tags = {"SalStdGwGzrate" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgwgzrates/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SalStdGwGzrateDTO> salstdgwgzratedtos) {
        salstdgwgzrateService.createBatch(salstdgwgzrateMapping.toDomain(salstdgwgzratedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salstdgwgzrateMapping.toDomain(#salstdgwgzratedto),'ehr-SalStdGwGzrate-Save')")
    @ApiOperation(value = "Save", tags = {"SalStdGwGzrate" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgwgzrates/save")
    public ResponseEntity<Boolean> save(@RequestBody SalStdGwGzrateDTO salstdgwgzratedto) {
        return ResponseEntity.status(HttpStatus.OK).body(salstdgwgzrateService.save(salstdgwgzrateMapping.toDomain(salstdgwgzratedto)));
    }

    @PreAuthorize("hasPermission(this.salstdgwgzrateMapping.toDomain(#salstdgwgzratedtos),'ehr-SalStdGwGzrate-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"SalStdGwGzrate" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgwgzrates/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SalStdGwGzrateDTO> salstdgwgzratedtos) {
        salstdgwgzrateService.saveBatch(salstdgwgzrateMapping.toDomain(salstdgwgzratedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salstdgwgzrateService.get(#salstdgwgzrate_id),'ehr-SalStdGwGzrate-Update')")
    @ApiOperation(value = "Update", tags = {"SalStdGwGzrate" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdgwgzrates/{salstdgwgzrate_id}")
    @Transactional
    public ResponseEntity<SalStdGwGzrateDTO> update(@PathVariable("salstdgwgzrate_id") String salstdgwgzrate_id, @RequestBody SalStdGwGzrateDTO salstdgwgzratedto) {
		SalStdGwGzrate domain  = salstdgwgzrateMapping.toDomain(salstdgwgzratedto);
        domain .setSalstdgwgzrateid(salstdgwgzrate_id);
		salstdgwgzrateService.update(domain );
		SalStdGwGzrateDTO dto = salstdgwgzrateMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salstdgwgzrateService.getSalstdgwgzrateByEntities(this.salstdgwgzrateMapping.toDomain(#salstdgwgzratedtos)),'ehr-SalStdGwGzrate-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"SalStdGwGzrate" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdgwgzrates/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SalStdGwGzrateDTO> salstdgwgzratedtos) {
        salstdgwgzrateService.updateBatch(salstdgwgzrateMapping.toDomain(salstdgwgzratedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"SalStdGwGzrate" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdgwgzrates/getdraft")
    public ResponseEntity<SalStdGwGzrateDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salstdgwgzrateMapping.toDto(salstdgwgzrateService.getDraft(new SalStdGwGzrate())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalStdGwGzrate-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SalStdGwGzrate" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salstdgwgzrates/fetchdefault")
	public ResponseEntity<List<SalStdGwGzrateDTO>> fetchDefault(SalStdGwGzrateSearchContext context) {
        Page<SalStdGwGzrate> domains = salstdgwgzrateService.searchDefault(context) ;
        List<SalStdGwGzrateDTO> list = salstdgwgzrateMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalStdGwGzrate-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SalStdGwGzrate" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salstdgwgzrates/searchdefault")
	public ResponseEntity<Page<SalStdGwGzrateDTO>> searchDefault(@RequestBody SalStdGwGzrateSearchContext context) {
        Page<SalStdGwGzrate> domains = salstdgwgzrateService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salstdgwgzrateMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

