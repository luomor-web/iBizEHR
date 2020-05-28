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
import cn.ibizlab.ehr.core.vac.domain.VACINITNXJ;
import cn.ibizlab.ehr.core.vac.service.IVACINITNXJService;
import cn.ibizlab.ehr.core.vac.filter.VACINITNXJSearchContext;

@Slf4j
@Api(tags = {"VACINITNXJ" })
@RestController("WebApi-vacinitnxj")
@RequestMapping("")
public class VACINITNXJResource {

    @Autowired
    public IVACINITNXJService vacinitnxjService;

    @Autowired
    @Lazy
    public VACINITNXJMapping vacinitnxjMapping;

    @ApiOperation(value = "CheckKey", tags = {"VACINITNXJ" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/vacinitnxjs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VACINITNXJDTO vacinitnxjdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacinitnxjService.checkKey(vacinitnxjMapping.toDomain(vacinitnxjdto)));
    }

    @PreAuthorize("hasPermission(this.vacinitnxjMapping.toDomain(#vacinitnxjdto),'ehr-VACINITNXJ-Create')")
    @ApiOperation(value = "Create", tags = {"VACINITNXJ" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/vacinitnxjs")
    @Transactional
    public ResponseEntity<VACINITNXJDTO> create(@RequestBody VACINITNXJDTO vacinitnxjdto) {
        VACINITNXJ domain = vacinitnxjMapping.toDomain(vacinitnxjdto);
		vacinitnxjService.create(domain);
        VACINITNXJDTO dto = vacinitnxjMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacinitnxjMapping.toDomain(#vacinitnxjdtos),'ehr-VACINITNXJ-Create')")
    @ApiOperation(value = "createBatch", tags = {"VACINITNXJ" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacinitnxjs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VACINITNXJDTO> vacinitnxjdtos) {
        vacinitnxjService.createBatch(vacinitnxjMapping.toDomain(vacinitnxjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"VACINITNXJ" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/vacinitnxjs/getdraft")
    public ResponseEntity<VACINITNXJDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacinitnxjMapping.toDto(vacinitnxjService.getDraft(new VACINITNXJ())));
    }

    @PreAuthorize("hasPermission(this.vacinitnxjService.get(#vacinitnxj_id),'ehr-VACINITNXJ-Remove')")
    @ApiOperation(value = "Remove", tags = {"VACINITNXJ" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacinitnxjs/{vacinitnxj_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacinitnxj_id") String vacinitnxj_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacinitnxjService.remove(vacinitnxj_id));
    }

    @PreAuthorize("hasPermission(this.vacinitnxjService.getVacinitnxjByIds(#ids),'ehr-VACINITNXJ-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"VACINITNXJ" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacinitnxjs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacinitnxjService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.vacinitnxjMapping.toDomain(returnObject.body),'ehr-VACINITNXJ-Get')")
    @ApiOperation(value = "Get", tags = {"VACINITNXJ" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/vacinitnxjs/{vacinitnxj_id}")
    public ResponseEntity<VACINITNXJDTO> get(@PathVariable("vacinitnxj_id") String vacinitnxj_id) {
        VACINITNXJ domain = vacinitnxjService.get(vacinitnxj_id);
        VACINITNXJDTO dto = vacinitnxjMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacinitnxjMapping.toDomain(#vacinitnxjdto),'ehr-VACINITNXJ-Save')")
    @ApiOperation(value = "Save", tags = {"VACINITNXJ" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/vacinitnxjs/save")
    public ResponseEntity<Boolean> save(@RequestBody VACINITNXJDTO vacinitnxjdto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacinitnxjService.save(vacinitnxjMapping.toDomain(vacinitnxjdto)));
    }

    @PreAuthorize("hasPermission(this.vacinitnxjMapping.toDomain(#vacinitnxjdtos),'ehr-VACINITNXJ-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"VACINITNXJ" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacinitnxjs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VACINITNXJDTO> vacinitnxjdtos) {
        vacinitnxjService.saveBatch(vacinitnxjMapping.toDomain(vacinitnxjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacinitnxjService.get(#vacinitnxj_id),'ehr-VACINITNXJ-Update')")
    @ApiOperation(value = "Update", tags = {"VACINITNXJ" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacinitnxjs/{vacinitnxj_id}")
    @Transactional
    public ResponseEntity<VACINITNXJDTO> update(@PathVariable("vacinitnxj_id") String vacinitnxj_id, @RequestBody VACINITNXJDTO vacinitnxjdto) {
		VACINITNXJ domain  = vacinitnxjMapping.toDomain(vacinitnxjdto);
        domain .setVacinitnxjid(vacinitnxj_id);
		vacinitnxjService.update(domain );
		VACINITNXJDTO dto = vacinitnxjMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacinitnxjService.getVacinitnxjByEntities(this.vacinitnxjMapping.toDomain(#vacinitnxjdtos)),'ehr-VACINITNXJ-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"VACINITNXJ" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacinitnxjs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VACINITNXJDTO> vacinitnxjdtos) {
        vacinitnxjService.updateBatch(vacinitnxjMapping.toDomain(vacinitnxjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACINITNXJ-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"VACINITNXJ" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacinitnxjs/fetchdefault")
	public ResponseEntity<List<VACINITNXJDTO>> fetchDefault(VACINITNXJSearchContext context) {
        Page<VACINITNXJ> domains = vacinitnxjService.searchDefault(context) ;
        List<VACINITNXJDTO> list = vacinitnxjMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACINITNXJ-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"VACINITNXJ" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacinitnxjs/searchdefault")
	public ResponseEntity<Page<VACINITNXJDTO>> searchDefault(@RequestBody VACINITNXJSearchContext context) {
        Page<VACINITNXJ> domains = vacinitnxjService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacinitnxjMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

