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
import cn.ibizlab.ehr.core.sal.domain.SALPARAM;
import cn.ibizlab.ehr.core.sal.service.ISALPARAMService;
import cn.ibizlab.ehr.core.sal.filter.SALPARAMSearchContext;

@Slf4j
@Api(tags = {"SALPARAM" })
@RestController("WebApi-salparam")
@RequestMapping("")
public class SALPARAMResource {

    @Autowired
    public ISALPARAMService salparamService;

    @Autowired
    @Lazy
    public SALPARAMMapping salparamMapping;

    @PreAuthorize("hasPermission(this.salparamMapping.toDomain(#salparamdto),'ehr-SALPARAM-Save')")
    @ApiOperation(value = "Save", tags = {"SALPARAM" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/salparams/save")
    public ResponseEntity<Boolean> save(@RequestBody SALPARAMDTO salparamdto) {
        return ResponseEntity.status(HttpStatus.OK).body(salparamService.save(salparamMapping.toDomain(salparamdto)));
    }

    @PreAuthorize("hasPermission(this.salparamMapping.toDomain(#salparamdtos),'ehr-SALPARAM-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"SALPARAM" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salparams/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SALPARAMDTO> salparamdtos) {
        salparamService.saveBatch(salparamMapping.toDomain(salparamdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.salparamMapping.toDomain(returnObject.body),'ehr-SALPARAM-Get')")
    @ApiOperation(value = "Get", tags = {"SALPARAM" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/salparams/{salparam_id}")
    public ResponseEntity<SALPARAMDTO> get(@PathVariable("salparam_id") String salparam_id) {
        SALPARAM domain = salparamService.get(salparam_id);
        SALPARAMDTO dto = salparamMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salparamService.get(#salparam_id),'ehr-SALPARAM-Remove')")
    @ApiOperation(value = "Remove", tags = {"SALPARAM" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salparams/{salparam_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salparam_id") String salparam_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salparamService.remove(salparam_id));
    }

    @PreAuthorize("hasPermission(this.salparamService.getSalparamByIds(#ids),'ehr-SALPARAM-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"SALPARAM" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salparams/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salparamService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"SALPARAM" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/salparams/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SALPARAMDTO salparamdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salparamService.checkKey(salparamMapping.toDomain(salparamdto)));
    }

    @PreAuthorize("hasPermission(this.salparamMapping.toDomain(#salparamdto),'ehr-SALPARAM-Create')")
    @ApiOperation(value = "Create", tags = {"SALPARAM" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/salparams")
    @Transactional
    public ResponseEntity<SALPARAMDTO> create(@RequestBody SALPARAMDTO salparamdto) {
        SALPARAM domain = salparamMapping.toDomain(salparamdto);
		salparamService.create(domain);
        SALPARAMDTO dto = salparamMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salparamMapping.toDomain(#salparamdtos),'ehr-SALPARAM-Create')")
    @ApiOperation(value = "createBatch", tags = {"SALPARAM" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salparams/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SALPARAMDTO> salparamdtos) {
        salparamService.createBatch(salparamMapping.toDomain(salparamdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salparamService.get(#salparam_id),'ehr-SALPARAM-Update')")
    @ApiOperation(value = "Update", tags = {"SALPARAM" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/salparams/{salparam_id}")
    @Transactional
    public ResponseEntity<SALPARAMDTO> update(@PathVariable("salparam_id") String salparam_id, @RequestBody SALPARAMDTO salparamdto) {
		SALPARAM domain  = salparamMapping.toDomain(salparamdto);
        domain .setSalparamid(salparam_id);
		salparamService.update(domain );
		SALPARAMDTO dto = salparamMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salparamService.getSalparamByEntities(this.salparamMapping.toDomain(#salparamdtos)),'ehr-SALPARAM-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"SALPARAM" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/salparams/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SALPARAMDTO> salparamdtos) {
        salparamService.updateBatch(salparamMapping.toDomain(salparamdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"SALPARAM" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/salparams/getdraft")
    public ResponseEntity<SALPARAMDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salparamMapping.toDto(salparamService.getDraft(new SALPARAM())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALPARAM-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SALPARAM" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salparams/fetchdefault")
	public ResponseEntity<List<SALPARAMDTO>> fetchDefault(SALPARAMSearchContext context) {
        Page<SALPARAM> domains = salparamService.searchDefault(context) ;
        List<SALPARAMDTO> list = salparamMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALPARAM-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SALPARAM" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salparams/searchdefault")
	public ResponseEntity<Page<SALPARAMDTO>> searchDefault(@RequestBody SALPARAMSearchContext context) {
        Page<SALPARAM> domains = salparamService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salparamMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

