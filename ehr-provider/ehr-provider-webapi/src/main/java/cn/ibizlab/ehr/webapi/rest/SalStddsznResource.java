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
import cn.ibizlab.ehr.core.sal.domain.SalStddszn;
import cn.ibizlab.ehr.core.sal.service.ISalStddsznService;
import cn.ibizlab.ehr.core.sal.filter.SalStddsznSearchContext;

@Slf4j
@Api(tags = {"SalStddszn" })
@RestController("WebApi-salstddszn")
@RequestMapping("")
public class SalStddsznResource {

    @Autowired
    public ISalStddsznService salstddsznService;

    @Autowired
    @Lazy
    public SalStddsznMapping salstddsznMapping;

    @PreAuthorize("hasPermission(this.salstddsznMapping.toDomain(#salstddszndto),'ehr-SalStddszn-Save')")
    @ApiOperation(value = "Save", tags = {"SalStddszn" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/salstddszns/save")
    public ResponseEntity<Boolean> save(@RequestBody SalStddsznDTO salstddszndto) {
        return ResponseEntity.status(HttpStatus.OK).body(salstddsznService.save(salstddsznMapping.toDomain(salstddszndto)));
    }

    @PreAuthorize("hasPermission(this.salstddsznMapping.toDomain(#salstddszndtos),'ehr-SalStddszn-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"SalStddszn" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salstddszns/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SalStddsznDTO> salstddszndtos) {
        salstddsznService.saveBatch(salstddsznMapping.toDomain(salstddszndtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salstddsznService.get(#salstddszn_id),'ehr-SalStddszn-Remove')")
    @ApiOperation(value = "Remove", tags = {"SalStddszn" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstddszns/{salstddszn_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salstddszn_id") String salstddszn_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salstddsznService.remove(salstddszn_id));
    }

    @PreAuthorize("hasPermission(this.salstddsznService.getSalstddsznByIds(#ids),'ehr-SalStddszn-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"SalStddszn" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstddszns/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salstddsznService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.salstddsznMapping.toDomain(returnObject.body),'ehr-SalStddszn-Get')")
    @ApiOperation(value = "Get", tags = {"SalStddszn" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/salstddszns/{salstddszn_id}")
    public ResponseEntity<SalStddsznDTO> get(@PathVariable("salstddszn_id") String salstddszn_id) {
        SalStddszn domain = salstddsznService.get(salstddszn_id);
        SalStddsznDTO dto = salstddsznMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salstddsznService.get(#salstddszn_id),'ehr-SalStddszn-Update')")
    @ApiOperation(value = "Update", tags = {"SalStddszn" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstddszns/{salstddszn_id}")
    @Transactional
    public ResponseEntity<SalStddsznDTO> update(@PathVariable("salstddszn_id") String salstddszn_id, @RequestBody SalStddsznDTO salstddszndto) {
		SalStddszn domain  = salstddsznMapping.toDomain(salstddszndto);
        domain .setSalstddsznid(salstddszn_id);
		salstddsznService.update(domain );
		SalStddsznDTO dto = salstddsznMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salstddsznService.getSalstddsznByEntities(this.salstddsznMapping.toDomain(#salstddszndtos)),'ehr-SalStddszn-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"SalStddszn" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstddszns/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SalStddsznDTO> salstddszndtos) {
        salstddsznService.updateBatch(salstddsznMapping.toDomain(salstddszndtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salstddsznMapping.toDomain(#salstddszndto),'ehr-SalStddszn-Create')")
    @ApiOperation(value = "Create", tags = {"SalStddszn" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/salstddszns")
    @Transactional
    public ResponseEntity<SalStddsznDTO> create(@RequestBody SalStddsznDTO salstddszndto) {
        SalStddszn domain = salstddsznMapping.toDomain(salstddszndto);
		salstddsznService.create(domain);
        SalStddsznDTO dto = salstddsznMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salstddsznMapping.toDomain(#salstddszndtos),'ehr-SalStddszn-Create')")
    @ApiOperation(value = "createBatch", tags = {"SalStddszn" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salstddszns/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SalStddsznDTO> salstddszndtos) {
        salstddsznService.createBatch(salstddsznMapping.toDomain(salstddszndtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"SalStddszn" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/salstddszns/getdraft")
    public ResponseEntity<SalStddsznDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salstddsznMapping.toDto(salstddsznService.getDraft(new SalStddszn())));
    }

    @ApiOperation(value = "CheckKey", tags = {"SalStddszn" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/salstddszns/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SalStddsznDTO salstddszndto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salstddsznService.checkKey(salstddsznMapping.toDomain(salstddszndto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalStddszn-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SalStddszn" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salstddszns/fetchdefault")
	public ResponseEntity<List<SalStddsznDTO>> fetchDefault(SalStddsznSearchContext context) {
        Page<SalStddszn> domains = salstddsznService.searchDefault(context) ;
        List<SalStddsznDTO> list = salstddsznMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalStddszn-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SalStddszn" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salstddszns/searchdefault")
	public ResponseEntity<Page<SalStddsznDTO>> searchDefault(@RequestBody SalStddsznSearchContext context) {
        Page<SalStddszn> domains = salstddsznService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salstddsznMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

