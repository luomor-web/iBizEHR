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
import cn.ibizlab.ehr.core.sal.domain.SalStdgwgz;
import cn.ibizlab.ehr.core.sal.service.ISalStdgwgzService;
import cn.ibizlab.ehr.core.sal.filter.SalStdgwgzSearchContext;

@Slf4j
@Api(tags = {"SalStdgwgz" })
@RestController("WebApi-salstdgwgz")
@RequestMapping("")
public class SalStdgwgzResource {

    @Autowired
    public ISalStdgwgzService salstdgwgzService;

    @Autowired
    @Lazy
    public SalStdgwgzMapping salstdgwgzMapping;

    @PreAuthorize("hasPermission(this.salstdgwgzService.get(#salstdgwgz_id),'ehr-SalStdgwgz-Remove')")
    @ApiOperation(value = "Remove", tags = {"SalStdgwgz" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdgwgzs/{salstdgwgz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salstdgwgz_id") String salstdgwgz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salstdgwgzService.remove(salstdgwgz_id));
    }

    @PreAuthorize("hasPermission(this.salstdgwgzService.getSalstdgwgzByIds(#ids),'ehr-SalStdgwgz-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"SalStdgwgz" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdgwgzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salstdgwgzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salstdgwgzMapping.toDomain(#salstdgwgzdto),'ehr-SalStdgwgz-Save')")
    @ApiOperation(value = "Save", tags = {"SalStdgwgz" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgwgzs/save")
    public ResponseEntity<Boolean> save(@RequestBody SalStdgwgzDTO salstdgwgzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(salstdgwgzService.save(salstdgwgzMapping.toDomain(salstdgwgzdto)));
    }

    @PreAuthorize("hasPermission(this.salstdgwgzMapping.toDomain(#salstdgwgzdtos),'ehr-SalStdgwgz-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"SalStdgwgz" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgwgzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SalStdgwgzDTO> salstdgwgzdtos) {
        salstdgwgzService.saveBatch(salstdgwgzMapping.toDomain(salstdgwgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salstdgwgzMapping.toDomain(#salstdgwgzdto),'ehr-SalStdgwgz-Create')")
    @ApiOperation(value = "Create", tags = {"SalStdgwgz" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgwgzs")
    @Transactional
    public ResponseEntity<SalStdgwgzDTO> create(@RequestBody SalStdgwgzDTO salstdgwgzdto) {
        SalStdgwgz domain = salstdgwgzMapping.toDomain(salstdgwgzdto);
		salstdgwgzService.create(domain);
        SalStdgwgzDTO dto = salstdgwgzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salstdgwgzMapping.toDomain(#salstdgwgzdtos),'ehr-SalStdgwgz-Create')")
    @ApiOperation(value = "createBatch", tags = {"SalStdgwgz" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgwgzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SalStdgwgzDTO> salstdgwgzdtos) {
        salstdgwgzService.createBatch(salstdgwgzMapping.toDomain(salstdgwgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.salstdgwgzMapping.toDomain(returnObject.body),'ehr-SalStdgwgz-Get')")
    @ApiOperation(value = "Get", tags = {"SalStdgwgz" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdgwgzs/{salstdgwgz_id}")
    public ResponseEntity<SalStdgwgzDTO> get(@PathVariable("salstdgwgz_id") String salstdgwgz_id) {
        SalStdgwgz domain = salstdgwgzService.get(salstdgwgz_id);
        SalStdgwgzDTO dto = salstdgwgzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKey", tags = {"SalStdgwgz" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdgwgzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SalStdgwgzDTO salstdgwgzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salstdgwgzService.checkKey(salstdgwgzMapping.toDomain(salstdgwgzdto)));
    }

    @PreAuthorize("hasPermission(this.salstdgwgzService.get(#salstdgwgz_id),'ehr-SalStdgwgz-Update')")
    @ApiOperation(value = "Update", tags = {"SalStdgwgz" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdgwgzs/{salstdgwgz_id}")
    @Transactional
    public ResponseEntity<SalStdgwgzDTO> update(@PathVariable("salstdgwgz_id") String salstdgwgz_id, @RequestBody SalStdgwgzDTO salstdgwgzdto) {
		SalStdgwgz domain  = salstdgwgzMapping.toDomain(salstdgwgzdto);
        domain .setSalstdgwgzid(salstdgwgz_id);
		salstdgwgzService.update(domain );
		SalStdgwgzDTO dto = salstdgwgzMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salstdgwgzService.getSalstdgwgzByEntities(this.salstdgwgzMapping.toDomain(#salstdgwgzdtos)),'ehr-SalStdgwgz-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"SalStdgwgz" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdgwgzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SalStdgwgzDTO> salstdgwgzdtos) {
        salstdgwgzService.updateBatch(salstdgwgzMapping.toDomain(salstdgwgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"SalStdgwgz" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdgwgzs/getdraft")
    public ResponseEntity<SalStdgwgzDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salstdgwgzMapping.toDto(salstdgwgzService.getDraft(new SalStdgwgz())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalStdgwgz-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SalStdgwgz" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salstdgwgzs/fetchdefault")
	public ResponseEntity<List<SalStdgwgzDTO>> fetchDefault(SalStdgwgzSearchContext context) {
        Page<SalStdgwgz> domains = salstdgwgzService.searchDefault(context) ;
        List<SalStdgwgzDTO> list = salstdgwgzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalStdgwgz-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SalStdgwgz" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salstdgwgzs/searchdefault")
	public ResponseEntity<Page<SalStdgwgzDTO>> searchDefault(@RequestBody SalStdgwgzSearchContext context) {
        Page<SalStdgwgz> domains = salstdgwgzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salstdgwgzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

