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
import cn.ibizlab.ehr.core.vac.domain.VACWORKDAY;
import cn.ibizlab.ehr.core.vac.service.IVACWORKDAYService;
import cn.ibizlab.ehr.core.vac.filter.VACWORKDAYSearchContext;

@Slf4j
@Api(tags = {"VACWORKDAY" })
@RestController("WebApi-vacworkday")
@RequestMapping("")
public class VACWORKDAYResource {

    @Autowired
    public IVACWORKDAYService vacworkdayService;

    @Autowired
    @Lazy
    public VACWORKDAYMapping vacworkdayMapping;

    @ApiOperation(value = "CheckKey", tags = {"VACWORKDAY" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/vacworkdays/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VACWORKDAYDTO vacworkdaydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacworkdayService.checkKey(vacworkdayMapping.toDomain(vacworkdaydto)));
    }

    @PreAuthorize("hasPermission(this.vacworkdayMapping.toDomain(#vacworkdaydto),'ehr-VACWORKDAY-Save')")
    @ApiOperation(value = "Save", tags = {"VACWORKDAY" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/vacworkdays/save")
    public ResponseEntity<Boolean> save(@RequestBody VACWORKDAYDTO vacworkdaydto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacworkdayService.save(vacworkdayMapping.toDomain(vacworkdaydto)));
    }

    @PreAuthorize("hasPermission(this.vacworkdayMapping.toDomain(#vacworkdaydtos),'ehr-VACWORKDAY-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"VACWORKDAY" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacworkdays/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VACWORKDAYDTO> vacworkdaydtos) {
        vacworkdayService.saveBatch(vacworkdayMapping.toDomain(vacworkdaydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacworkdayService.get(#vacworkday_id),'ehr-VACWORKDAY-Remove')")
    @ApiOperation(value = "Remove", tags = {"VACWORKDAY" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacworkdays/{vacworkday_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacworkday_id") String vacworkday_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacworkdayService.remove(vacworkday_id));
    }

    @PreAuthorize("hasPermission(this.vacworkdayService.getVacworkdayByIds(#ids),'ehr-VACWORKDAY-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"VACWORKDAY" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacworkdays/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacworkdayService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacworkdayMapping.toDomain(#vacworkdaydto),'ehr-VACWORKDAY-Create')")
    @ApiOperation(value = "Create", tags = {"VACWORKDAY" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/vacworkdays")
    @Transactional
    public ResponseEntity<VACWORKDAYDTO> create(@RequestBody VACWORKDAYDTO vacworkdaydto) {
        VACWORKDAY domain = vacworkdayMapping.toDomain(vacworkdaydto);
		vacworkdayService.create(domain);
        VACWORKDAYDTO dto = vacworkdayMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacworkdayMapping.toDomain(#vacworkdaydtos),'ehr-VACWORKDAY-Create')")
    @ApiOperation(value = "createBatch", tags = {"VACWORKDAY" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacworkdays/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VACWORKDAYDTO> vacworkdaydtos) {
        vacworkdayService.createBatch(vacworkdayMapping.toDomain(vacworkdaydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacworkdayService.get(#vacworkday_id),'ehr-VACWORKDAY-Update')")
    @ApiOperation(value = "Update", tags = {"VACWORKDAY" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacworkdays/{vacworkday_id}")
    @Transactional
    public ResponseEntity<VACWORKDAYDTO> update(@PathVariable("vacworkday_id") String vacworkday_id, @RequestBody VACWORKDAYDTO vacworkdaydto) {
		VACWORKDAY domain  = vacworkdayMapping.toDomain(vacworkdaydto);
        domain .setVacworkdayid(vacworkday_id);
		vacworkdayService.update(domain );
		VACWORKDAYDTO dto = vacworkdayMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacworkdayService.getVacworkdayByEntities(this.vacworkdayMapping.toDomain(#vacworkdaydtos)),'ehr-VACWORKDAY-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"VACWORKDAY" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacworkdays/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VACWORKDAYDTO> vacworkdaydtos) {
        vacworkdayService.updateBatch(vacworkdayMapping.toDomain(vacworkdaydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.vacworkdayMapping.toDomain(returnObject.body),'ehr-VACWORKDAY-Get')")
    @ApiOperation(value = "Get", tags = {"VACWORKDAY" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/vacworkdays/{vacworkday_id}")
    public ResponseEntity<VACWORKDAYDTO> get(@PathVariable("vacworkday_id") String vacworkday_id) {
        VACWORKDAY domain = vacworkdayService.get(vacworkday_id);
        VACWORKDAYDTO dto = vacworkdayMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "GetDraft", tags = {"VACWORKDAY" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/vacworkdays/getdraft")
    public ResponseEntity<VACWORKDAYDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacworkdayMapping.toDto(vacworkdayService.getDraft(new VACWORKDAY())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACWORKDAY-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"VACWORKDAY" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacworkdays/fetchdefault")
	public ResponseEntity<List<VACWORKDAYDTO>> fetchDefault(VACWORKDAYSearchContext context) {
        Page<VACWORKDAY> domains = vacworkdayService.searchDefault(context) ;
        List<VACWORKDAYDTO> list = vacworkdayMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACWORKDAY-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"VACWORKDAY" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacworkdays/searchdefault")
	public ResponseEntity<Page<VACWORKDAYDTO>> searchDefault(@RequestBody VACWORKDAYSearchContext context) {
        Page<VACWORKDAY> domains = vacworkdayService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacworkdayMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

