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
import cn.ibizlab.ehr.core.sal.domain.SALSUBJECT;
import cn.ibizlab.ehr.core.sal.service.ISALSUBJECTService;
import cn.ibizlab.ehr.core.sal.filter.SALSUBJECTSearchContext;

@Slf4j
@Api(tags = {"SALSUBJECT" })
@RestController("WebApi-salsubject")
@RequestMapping("")
public class SALSUBJECTResource {

    @Autowired
    public ISALSUBJECTService salsubjectService;

    @Autowired
    @Lazy
    public SALSUBJECTMapping salsubjectMapping;

    @ApiOperation(value = "GetDraft", tags = {"SALSUBJECT" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/salsubjects/getdraft")
    public ResponseEntity<SALSUBJECTDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salsubjectMapping.toDto(salsubjectService.getDraft(new SALSUBJECT())));
    }

    @PreAuthorize("hasPermission(this.salsubjectMapping.toDomain(#salsubjectdto),'ehr-SALSUBJECT-Save')")
    @ApiOperation(value = "Save", tags = {"SALSUBJECT" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/salsubjects/save")
    public ResponseEntity<Boolean> save(@RequestBody SALSUBJECTDTO salsubjectdto) {
        return ResponseEntity.status(HttpStatus.OK).body(salsubjectService.save(salsubjectMapping.toDomain(salsubjectdto)));
    }

    @PreAuthorize("hasPermission(this.salsubjectMapping.toDomain(#salsubjectdtos),'ehr-SALSUBJECT-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"SALSUBJECT" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salsubjects/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SALSUBJECTDTO> salsubjectdtos) {
        salsubjectService.saveBatch(salsubjectMapping.toDomain(salsubjectdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"SALSUBJECT" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/salsubjects/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SALSUBJECTDTO salsubjectdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salsubjectService.checkKey(salsubjectMapping.toDomain(salsubjectdto)));
    }

    @PreAuthorize("hasPermission(this.salsubjectService.get(#salsubject_id),'ehr-SALSUBJECT-Update')")
    @ApiOperation(value = "Update", tags = {"SALSUBJECT" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/salsubjects/{salsubject_id}")
    @Transactional
    public ResponseEntity<SALSUBJECTDTO> update(@PathVariable("salsubject_id") String salsubject_id, @RequestBody SALSUBJECTDTO salsubjectdto) {
		SALSUBJECT domain  = salsubjectMapping.toDomain(salsubjectdto);
        domain .setSalsubjectid(salsubject_id);
		salsubjectService.update(domain );
		SALSUBJECTDTO dto = salsubjectMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salsubjectService.getSalsubjectByEntities(this.salsubjectMapping.toDomain(#salsubjectdtos)),'ehr-SALSUBJECT-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"SALSUBJECT" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/salsubjects/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SALSUBJECTDTO> salsubjectdtos) {
        salsubjectService.updateBatch(salsubjectMapping.toDomain(salsubjectdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salsubjectService.get(#salsubject_id),'ehr-SALSUBJECT-Remove')")
    @ApiOperation(value = "Remove", tags = {"SALSUBJECT" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salsubjects/{salsubject_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salsubject_id") String salsubject_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salsubjectService.remove(salsubject_id));
    }

    @PreAuthorize("hasPermission(this.salsubjectService.getSalsubjectByIds(#ids),'ehr-SALSUBJECT-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"SALSUBJECT" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salsubjects/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salsubjectService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.salsubjectMapping.toDomain(returnObject.body),'ehr-SALSUBJECT-Get')")
    @ApiOperation(value = "Get", tags = {"SALSUBJECT" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/salsubjects/{salsubject_id}")
    public ResponseEntity<SALSUBJECTDTO> get(@PathVariable("salsubject_id") String salsubject_id) {
        SALSUBJECT domain = salsubjectService.get(salsubject_id);
        SALSUBJECTDTO dto = salsubjectMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salsubjectMapping.toDomain(#salsubjectdto),'ehr-SALSUBJECT-Create')")
    @ApiOperation(value = "Create", tags = {"SALSUBJECT" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/salsubjects")
    @Transactional
    public ResponseEntity<SALSUBJECTDTO> create(@RequestBody SALSUBJECTDTO salsubjectdto) {
        SALSUBJECT domain = salsubjectMapping.toDomain(salsubjectdto);
		salsubjectService.create(domain);
        SALSUBJECTDTO dto = salsubjectMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salsubjectMapping.toDomain(#salsubjectdtos),'ehr-SALSUBJECT-Create')")
    @ApiOperation(value = "createBatch", tags = {"SALSUBJECT" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salsubjects/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SALSUBJECTDTO> salsubjectdtos) {
        salsubjectService.createBatch(salsubjectMapping.toDomain(salsubjectdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSUBJECT-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SALSUBJECT" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salsubjects/fetchdefault")
	public ResponseEntity<List<SALSUBJECTDTO>> fetchDefault(SALSUBJECTSearchContext context) {
        Page<SALSUBJECT> domains = salsubjectService.searchDefault(context) ;
        List<SALSUBJECTDTO> list = salsubjectMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSUBJECT-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SALSUBJECT" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salsubjects/searchdefault")
	public ResponseEntity<Page<SALSUBJECTDTO>> searchDefault(@RequestBody SALSUBJECTSearchContext context) {
        Page<SALSUBJECT> domains = salsubjectService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salsubjectMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

