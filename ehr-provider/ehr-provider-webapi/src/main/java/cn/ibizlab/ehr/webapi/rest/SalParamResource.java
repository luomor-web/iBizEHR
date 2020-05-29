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
import cn.ibizlab.ehr.core.sal.domain.SalParam;
import cn.ibizlab.ehr.core.sal.service.ISalParamService;
import cn.ibizlab.ehr.core.sal.filter.SalParamSearchContext;

@Slf4j
@Api(tags = {"SalParam" })
@RestController("WebApi-salparam")
@RequestMapping("")
public class SalParamResource {

    @Autowired
    public ISalParamService salparamService;

    @Autowired
    @Lazy
    public SalParamMapping salparamMapping;

    @PreAuthorize("hasPermission(this.salparamMapping.toDomain(#salparamdto),'ehr-SalParam-Save')")
    @ApiOperation(value = "Save", tags = {"SalParam" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/salparams/save")
    public ResponseEntity<Boolean> save(@RequestBody SalParamDTO salparamdto) {
        return ResponseEntity.status(HttpStatus.OK).body(salparamService.save(salparamMapping.toDomain(salparamdto)));
    }

    @PreAuthorize("hasPermission(this.salparamMapping.toDomain(#salparamdtos),'ehr-SalParam-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"SalParam" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salparams/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SalParamDTO> salparamdtos) {
        salparamService.saveBatch(salparamMapping.toDomain(salparamdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.salparamMapping.toDomain(returnObject.body),'ehr-SalParam-Get')")
    @ApiOperation(value = "Get", tags = {"SalParam" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/salparams/{salparam_id}")
    public ResponseEntity<SalParamDTO> get(@PathVariable("salparam_id") String salparam_id) {
        SalParam domain = salparamService.get(salparam_id);
        SalParamDTO dto = salparamMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salparamService.get(#salparam_id),'ehr-SalParam-Remove')")
    @ApiOperation(value = "Remove", tags = {"SalParam" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salparams/{salparam_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salparam_id") String salparam_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salparamService.remove(salparam_id));
    }

    @PreAuthorize("hasPermission(this.salparamService.getSalparamByIds(#ids),'ehr-SalParam-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"SalParam" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salparams/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salparamService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"SalParam" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/salparams/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SalParamDTO salparamdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salparamService.checkKey(salparamMapping.toDomain(salparamdto)));
    }

    @PreAuthorize("hasPermission(this.salparamMapping.toDomain(#salparamdto),'ehr-SalParam-Create')")
    @ApiOperation(value = "Create", tags = {"SalParam" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/salparams")
    @Transactional
    public ResponseEntity<SalParamDTO> create(@RequestBody SalParamDTO salparamdto) {
        SalParam domain = salparamMapping.toDomain(salparamdto);
		salparamService.create(domain);
        SalParamDTO dto = salparamMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salparamMapping.toDomain(#salparamdtos),'ehr-SalParam-Create')")
    @ApiOperation(value = "createBatch", tags = {"SalParam" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salparams/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SalParamDTO> salparamdtos) {
        salparamService.createBatch(salparamMapping.toDomain(salparamdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salparamService.get(#salparam_id),'ehr-SalParam-Update')")
    @ApiOperation(value = "Update", tags = {"SalParam" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/salparams/{salparam_id}")
    @Transactional
    public ResponseEntity<SalParamDTO> update(@PathVariable("salparam_id") String salparam_id, @RequestBody SalParamDTO salparamdto) {
		SalParam domain  = salparamMapping.toDomain(salparamdto);
        domain .setSalparamid(salparam_id);
		salparamService.update(domain );
		SalParamDTO dto = salparamMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salparamService.getSalparamByEntities(this.salparamMapping.toDomain(#salparamdtos)),'ehr-SalParam-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"SalParam" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/salparams/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SalParamDTO> salparamdtos) {
        salparamService.updateBatch(salparamMapping.toDomain(salparamdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"SalParam" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/salparams/getdraft")
    public ResponseEntity<SalParamDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salparamMapping.toDto(salparamService.getDraft(new SalParam())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalParam-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SalParam" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salparams/fetchdefault")
	public ResponseEntity<List<SalParamDTO>> fetchDefault(SalParamSearchContext context) {
        Page<SalParam> domains = salparamService.searchDefault(context) ;
        List<SalParamDTO> list = salparamMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalParam-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SalParam" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salparams/searchdefault")
	public ResponseEntity<Page<SalParamDTO>> searchDefault(@RequestBody SalParamSearchContext context) {
        Page<SalParam> domains = salparamService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salparamMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

