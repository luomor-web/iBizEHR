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
import cn.ibizlab.ehr.core.vac.domain.VacHolidayRules;
import cn.ibizlab.ehr.core.vac.service.IVacHolidayRulesService;
import cn.ibizlab.ehr.core.vac.filter.VacHolidayRulesSearchContext;

@Slf4j
@Api(tags = {"VacHolidayRules" })
@RestController("WebApi-vacholidayrules")
@RequestMapping("")
public class VacHolidayRulesResource {

    @Autowired
    public IVacHolidayRulesService vacholidayrulesService;

    @Autowired
    @Lazy
    public VacHolidayRulesMapping vacholidayrulesMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacHolidayRules-CopyKQGZData-all')")
    @ApiOperation(value = "拷贝考勤规则", tags = {"VacHolidayRules" },  notes = "拷贝考勤规则")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/{vacholidayrules_id}/copykqgzdata")
    @Transactional
    public ResponseEntity<VacHolidayRulesDTO> copyKQGZData(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody VacHolidayRulesDTO vacholidayrulesdto) {
        VacHolidayRules vacholidayrules = vacholidayrulesMapping.toDomain(vacholidayrulesdto);
        vacholidayrules.setVacholidayrulesid(vacholidayrules_id);
        vacholidayrules = vacholidayrulesService.copyKQGZData(vacholidayrules);
        vacholidayrulesdto = vacholidayrulesMapping.toDto(vacholidayrules);
        return ResponseEntity.status(HttpStatus.OK).body(vacholidayrulesdto);
    }

    @PreAuthorize("hasPermission(this.vacholidayrulesService.get(#vacholidayrules_id),'ehr-VacHolidayRules-Remove')")
    @ApiOperation(value = "Remove", tags = {"VacHolidayRules" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacholidayrules/{vacholidayrules_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacholidayrules_id") String vacholidayrules_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacholidayrulesService.remove(vacholidayrules_id));
    }

    @PreAuthorize("hasPermission(this.vacholidayrulesService.getVacholidayrulesByIds(#ids),'ehr-VacHolidayRules-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"VacHolidayRules" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacholidayrules/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacholidayrulesService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"VacHolidayRules" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VacHolidayRulesDTO vacholidayrulesdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacholidayrulesService.checkKey(vacholidayrulesMapping.toDomain(vacholidayrulesdto)));
    }

    @PreAuthorize("hasPermission(this.vacholidayrulesMapping.toDomain(#vacholidayrulesdto),'ehr-VacHolidayRules-Create')")
    @ApiOperation(value = "Create", tags = {"VacHolidayRules" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules")
    @Transactional
    public ResponseEntity<VacHolidayRulesDTO> create(@RequestBody VacHolidayRulesDTO vacholidayrulesdto) {
        VacHolidayRules domain = vacholidayrulesMapping.toDomain(vacholidayrulesdto);
		vacholidayrulesService.create(domain);
        VacHolidayRulesDTO dto = vacholidayrulesMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacholidayrulesMapping.toDomain(#vacholidayrulesdtos),'ehr-VacHolidayRules-Create')")
    @ApiOperation(value = "createBatch", tags = {"VacHolidayRules" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VacHolidayRulesDTO> vacholidayrulesdtos) {
        vacholidayrulesService.createBatch(vacholidayrulesMapping.toDomain(vacholidayrulesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"VacHolidayRules" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/vacholidayrules/getdraft")
    public ResponseEntity<VacHolidayRulesDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacholidayrulesMapping.toDto(vacholidayrulesService.getDraft(new VacHolidayRules())));
    }

    @PreAuthorize("hasPermission(this.vacholidayrulesService.get(#vacholidayrules_id),'ehr-VacHolidayRules-Update')")
    @ApiOperation(value = "Update", tags = {"VacHolidayRules" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacholidayrules/{vacholidayrules_id}")
    @Transactional
    public ResponseEntity<VacHolidayRulesDTO> update(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody VacHolidayRulesDTO vacholidayrulesdto) {
		VacHolidayRules domain  = vacholidayrulesMapping.toDomain(vacholidayrulesdto);
        domain .setVacholidayrulesid(vacholidayrules_id);
		vacholidayrulesService.update(domain );
		VacHolidayRulesDTO dto = vacholidayrulesMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacholidayrulesService.getVacholidayrulesByEntities(this.vacholidayrulesMapping.toDomain(#vacholidayrulesdtos)),'ehr-VacHolidayRules-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"VacHolidayRules" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacholidayrules/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VacHolidayRulesDTO> vacholidayrulesdtos) {
        vacholidayrulesService.updateBatch(vacholidayrulesMapping.toDomain(vacholidayrulesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.vacholidayrulesMapping.toDomain(returnObject.body),'ehr-VacHolidayRules-Get')")
    @ApiOperation(value = "Get", tags = {"VacHolidayRules" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/vacholidayrules/{vacholidayrules_id}")
    public ResponseEntity<VacHolidayRulesDTO> get(@PathVariable("vacholidayrules_id") String vacholidayrules_id) {
        VacHolidayRules domain = vacholidayrulesService.get(vacholidayrules_id);
        VacHolidayRulesDTO dto = vacholidayrulesMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacholidayrulesMapping.toDomain(#vacholidayrulesdto),'ehr-VacHolidayRules-Save')")
    @ApiOperation(value = "Save", tags = {"VacHolidayRules" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/save")
    public ResponseEntity<Boolean> save(@RequestBody VacHolidayRulesDTO vacholidayrulesdto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacholidayrulesService.save(vacholidayrulesMapping.toDomain(vacholidayrulesdto)));
    }

    @PreAuthorize("hasPermission(this.vacholidayrulesMapping.toDomain(#vacholidayrulesdtos),'ehr-VacHolidayRules-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"VacHolidayRules" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VacHolidayRulesDTO> vacholidayrulesdtos) {
        vacholidayrulesService.saveBatch(vacholidayrulesMapping.toDomain(vacholidayrulesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacHolidayRules-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"VacHolidayRules" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacholidayrules/fetchdefault")
	public ResponseEntity<List<VacHolidayRulesDTO>> fetchDefault(VacHolidayRulesSearchContext context) {
        Page<VacHolidayRules> domains = vacholidayrulesService.searchDefault(context) ;
        List<VacHolidayRulesDTO> list = vacholidayrulesMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacHolidayRules-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"VacHolidayRules" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacholidayrules/searchdefault")
	public ResponseEntity<Page<VacHolidayRulesDTO>> searchDefault(@RequestBody VacHolidayRulesSearchContext context) {
        Page<VacHolidayRules> domains = vacholidayrulesService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacholidayrulesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacHolidayRules-CurOrmorg-all')")
	@ApiOperation(value = "fetch当前组织下的假期规则", tags = {"VacHolidayRules" } ,notes = "fetch当前组织下的假期规则")
    @RequestMapping(method= RequestMethod.GET , value="/vacholidayrules/fetchcurormorg")
	public ResponseEntity<List<VacHolidayRulesDTO>> fetchCurOrmorg(VacHolidayRulesSearchContext context) {
        Page<VacHolidayRules> domains = vacholidayrulesService.searchCurOrmorg(context) ;
        List<VacHolidayRulesDTO> list = vacholidayrulesMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacHolidayRules-CurOrmorg-all')")
	@ApiOperation(value = "search当前组织下的假期规则", tags = {"VacHolidayRules" } ,notes = "search当前组织下的假期规则")
    @RequestMapping(method= RequestMethod.POST , value="/vacholidayrules/searchcurormorg")
	public ResponseEntity<Page<VacHolidayRulesDTO>> searchCurOrmorg(@RequestBody VacHolidayRulesSearchContext context) {
        Page<VacHolidayRules> domains = vacholidayrulesService.searchCurOrmorg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacholidayrulesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

