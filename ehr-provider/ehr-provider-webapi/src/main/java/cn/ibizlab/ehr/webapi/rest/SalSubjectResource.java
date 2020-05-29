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
import cn.ibizlab.ehr.core.sal.domain.SalSubject;
import cn.ibizlab.ehr.core.sal.service.ISalSubjectService;
import cn.ibizlab.ehr.core.sal.filter.SalSubjectSearchContext;

@Slf4j
@Api(tags = {"SalSubject" })
@RestController("WebApi-salsubject")
@RequestMapping("")
public class SalSubjectResource {

    @Autowired
    public ISalSubjectService salsubjectService;

    @Autowired
    @Lazy
    public SalSubjectMapping salsubjectMapping;

    @ApiOperation(value = "GetDraft", tags = {"SalSubject" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/salsubjects/getdraft")
    public ResponseEntity<SalSubjectDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salsubjectMapping.toDto(salsubjectService.getDraft(new SalSubject())));
    }

    @PreAuthorize("hasPermission(this.salsubjectMapping.toDomain(#salsubjectdto),'ehr-SalSubject-Save')")
    @ApiOperation(value = "Save", tags = {"SalSubject" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/salsubjects/save")
    public ResponseEntity<Boolean> save(@RequestBody SalSubjectDTO salsubjectdto) {
        return ResponseEntity.status(HttpStatus.OK).body(salsubjectService.save(salsubjectMapping.toDomain(salsubjectdto)));
    }

    @PreAuthorize("hasPermission(this.salsubjectMapping.toDomain(#salsubjectdtos),'ehr-SalSubject-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"SalSubject" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salsubjects/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SalSubjectDTO> salsubjectdtos) {
        salsubjectService.saveBatch(salsubjectMapping.toDomain(salsubjectdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"SalSubject" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/salsubjects/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SalSubjectDTO salsubjectdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salsubjectService.checkKey(salsubjectMapping.toDomain(salsubjectdto)));
    }

    @PreAuthorize("hasPermission(this.salsubjectService.get(#salsubject_id),'ehr-SalSubject-Update')")
    @ApiOperation(value = "Update", tags = {"SalSubject" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/salsubjects/{salsubject_id}")
    @Transactional
    public ResponseEntity<SalSubjectDTO> update(@PathVariable("salsubject_id") String salsubject_id, @RequestBody SalSubjectDTO salsubjectdto) {
		SalSubject domain  = salsubjectMapping.toDomain(salsubjectdto);
        domain .setSalsubjectid(salsubject_id);
		salsubjectService.update(domain );
		SalSubjectDTO dto = salsubjectMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salsubjectService.getSalsubjectByEntities(this.salsubjectMapping.toDomain(#salsubjectdtos)),'ehr-SalSubject-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"SalSubject" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/salsubjects/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SalSubjectDTO> salsubjectdtos) {
        salsubjectService.updateBatch(salsubjectMapping.toDomain(salsubjectdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salsubjectService.get(#salsubject_id),'ehr-SalSubject-Remove')")
    @ApiOperation(value = "Remove", tags = {"SalSubject" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salsubjects/{salsubject_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salsubject_id") String salsubject_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salsubjectService.remove(salsubject_id));
    }

    @PreAuthorize("hasPermission(this.salsubjectService.getSalsubjectByIds(#ids),'ehr-SalSubject-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"SalSubject" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salsubjects/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salsubjectService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.salsubjectMapping.toDomain(returnObject.body),'ehr-SalSubject-Get')")
    @ApiOperation(value = "Get", tags = {"SalSubject" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/salsubjects/{salsubject_id}")
    public ResponseEntity<SalSubjectDTO> get(@PathVariable("salsubject_id") String salsubject_id) {
        SalSubject domain = salsubjectService.get(salsubject_id);
        SalSubjectDTO dto = salsubjectMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salsubjectMapping.toDomain(#salsubjectdto),'ehr-SalSubject-Create')")
    @ApiOperation(value = "Create", tags = {"SalSubject" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/salsubjects")
    @Transactional
    public ResponseEntity<SalSubjectDTO> create(@RequestBody SalSubjectDTO salsubjectdto) {
        SalSubject domain = salsubjectMapping.toDomain(salsubjectdto);
		salsubjectService.create(domain);
        SalSubjectDTO dto = salsubjectMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salsubjectMapping.toDomain(#salsubjectdtos),'ehr-SalSubject-Create')")
    @ApiOperation(value = "createBatch", tags = {"SalSubject" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salsubjects/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SalSubjectDTO> salsubjectdtos) {
        salsubjectService.createBatch(salsubjectMapping.toDomain(salsubjectdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalSubject-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SalSubject" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salsubjects/fetchdefault")
	public ResponseEntity<List<SalSubjectDTO>> fetchDefault(SalSubjectSearchContext context) {
        Page<SalSubject> domains = salsubjectService.searchDefault(context) ;
        List<SalSubjectDTO> list = salsubjectMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalSubject-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SalSubject" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salsubjects/searchdefault")
	public ResponseEntity<Page<SalSubjectDTO>> searchDefault(@RequestBody SalSubjectSearchContext context) {
        Page<SalSubject> domains = salsubjectService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salsubjectMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

