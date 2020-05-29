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
import cn.ibizlab.ehr.core.vac.domain.VacWorkDay;
import cn.ibizlab.ehr.core.vac.service.IVacWorkDayService;
import cn.ibizlab.ehr.core.vac.filter.VacWorkDaySearchContext;

@Slf4j
@Api(tags = {"VacWorkDay" })
@RestController("WebApi-vacworkday")
@RequestMapping("")
public class VacWorkDayResource {

    @Autowired
    public IVacWorkDayService vacworkdayService;

    @Autowired
    @Lazy
    public VacWorkDayMapping vacworkdayMapping;

    @ApiOperation(value = "CheckKey", tags = {"VacWorkDay" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/vacworkdays/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VacWorkDayDTO vacworkdaydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacworkdayService.checkKey(vacworkdayMapping.toDomain(vacworkdaydto)));
    }

    @PreAuthorize("hasPermission(this.vacworkdayMapping.toDomain(#vacworkdaydto),'ehr-VacWorkDay-Save')")
    @ApiOperation(value = "Save", tags = {"VacWorkDay" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/vacworkdays/save")
    public ResponseEntity<Boolean> save(@RequestBody VacWorkDayDTO vacworkdaydto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacworkdayService.save(vacworkdayMapping.toDomain(vacworkdaydto)));
    }

    @PreAuthorize("hasPermission(this.vacworkdayMapping.toDomain(#vacworkdaydtos),'ehr-VacWorkDay-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"VacWorkDay" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacworkdays/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VacWorkDayDTO> vacworkdaydtos) {
        vacworkdayService.saveBatch(vacworkdayMapping.toDomain(vacworkdaydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacworkdayService.get(#vacworkday_id),'ehr-VacWorkDay-Remove')")
    @ApiOperation(value = "Remove", tags = {"VacWorkDay" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacworkdays/{vacworkday_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacworkday_id") String vacworkday_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacworkdayService.remove(vacworkday_id));
    }

    @PreAuthorize("hasPermission(this.vacworkdayService.getVacworkdayByIds(#ids),'ehr-VacWorkDay-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"VacWorkDay" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacworkdays/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacworkdayService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacworkdayMapping.toDomain(#vacworkdaydto),'ehr-VacWorkDay-Create')")
    @ApiOperation(value = "Create", tags = {"VacWorkDay" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/vacworkdays")
    @Transactional
    public ResponseEntity<VacWorkDayDTO> create(@RequestBody VacWorkDayDTO vacworkdaydto) {
        VacWorkDay domain = vacworkdayMapping.toDomain(vacworkdaydto);
		vacworkdayService.create(domain);
        VacWorkDayDTO dto = vacworkdayMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacworkdayMapping.toDomain(#vacworkdaydtos),'ehr-VacWorkDay-Create')")
    @ApiOperation(value = "createBatch", tags = {"VacWorkDay" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacworkdays/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VacWorkDayDTO> vacworkdaydtos) {
        vacworkdayService.createBatch(vacworkdayMapping.toDomain(vacworkdaydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacworkdayService.get(#vacworkday_id),'ehr-VacWorkDay-Update')")
    @ApiOperation(value = "Update", tags = {"VacWorkDay" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacworkdays/{vacworkday_id}")
    @Transactional
    public ResponseEntity<VacWorkDayDTO> update(@PathVariable("vacworkday_id") String vacworkday_id, @RequestBody VacWorkDayDTO vacworkdaydto) {
		VacWorkDay domain  = vacworkdayMapping.toDomain(vacworkdaydto);
        domain .setVacworkdayid(vacworkday_id);
		vacworkdayService.update(domain );
		VacWorkDayDTO dto = vacworkdayMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacworkdayService.getVacworkdayByEntities(this.vacworkdayMapping.toDomain(#vacworkdaydtos)),'ehr-VacWorkDay-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"VacWorkDay" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacworkdays/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VacWorkDayDTO> vacworkdaydtos) {
        vacworkdayService.updateBatch(vacworkdayMapping.toDomain(vacworkdaydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.vacworkdayMapping.toDomain(returnObject.body),'ehr-VacWorkDay-Get')")
    @ApiOperation(value = "Get", tags = {"VacWorkDay" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/vacworkdays/{vacworkday_id}")
    public ResponseEntity<VacWorkDayDTO> get(@PathVariable("vacworkday_id") String vacworkday_id) {
        VacWorkDay domain = vacworkdayService.get(vacworkday_id);
        VacWorkDayDTO dto = vacworkdayMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "GetDraft", tags = {"VacWorkDay" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/vacworkdays/getdraft")
    public ResponseEntity<VacWorkDayDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacworkdayMapping.toDto(vacworkdayService.getDraft(new VacWorkDay())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacWorkDay-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"VacWorkDay" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacworkdays/fetchdefault")
	public ResponseEntity<List<VacWorkDayDTO>> fetchDefault(VacWorkDaySearchContext context) {
        Page<VacWorkDay> domains = vacworkdayService.searchDefault(context) ;
        List<VacWorkDayDTO> list = vacworkdayMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacWorkDay-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"VacWorkDay" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacworkdays/searchdefault")
	public ResponseEntity<Page<VacWorkDayDTO>> searchDefault(@RequestBody VacWorkDaySearchContext context) {
        Page<VacWorkDay> domains = vacworkdayService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacworkdayMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

