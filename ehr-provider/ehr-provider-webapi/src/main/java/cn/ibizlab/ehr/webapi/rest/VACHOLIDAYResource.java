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
import cn.ibizlab.ehr.core.vac.domain.VACHOLIDAY;
import cn.ibizlab.ehr.core.vac.service.IVACHOLIDAYService;
import cn.ibizlab.ehr.core.vac.filter.VACHOLIDAYSearchContext;

@Slf4j
@Api(tags = {"VACHOLIDAY" })
@RestController("WebApi-vacholiday")
@RequestMapping("")
public class VACHOLIDAYResource {

    @Autowired
    public IVACHOLIDAYService vacholidayService;

    @Autowired
    @Lazy
    public VACHOLIDAYMapping vacholidayMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACHOLIDAY-APPOINTJZBJJR-all')")
    @ApiOperation(value = "引用局总部节假日", tags = {"VACHOLIDAY" },  notes = "引用局总部节假日")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidays/{vacholiday_id}/appointjzbjjr")
    @Transactional
    public ResponseEntity<VACHOLIDAYDTO> aPPOINTJZBJJR(@PathVariable("vacholiday_id") String vacholiday_id, @RequestBody VACHOLIDAYDTO vacholidaydto) {
        VACHOLIDAY vacholiday = vacholidayMapping.toDomain(vacholidaydto);
        vacholiday.setVacholidayid(vacholiday_id);
        vacholiday = vacholidayService.aPPOINTJZBJJR(vacholiday);
        vacholidaydto = vacholidayMapping.toDto(vacholiday);
        return ResponseEntity.status(HttpStatus.OK).body(vacholidaydto);
    }

    @PreAuthorize("hasPermission(this.vacholidayService.get(#vacholiday_id),'ehr-VACHOLIDAY-Update')")
    @ApiOperation(value = "Update", tags = {"VACHOLIDAY" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacholidays/{vacholiday_id}")
    @Transactional
    public ResponseEntity<VACHOLIDAYDTO> update(@PathVariable("vacholiday_id") String vacholiday_id, @RequestBody VACHOLIDAYDTO vacholidaydto) {
		VACHOLIDAY domain  = vacholidayMapping.toDomain(vacholidaydto);
        domain .setVacholidayid(vacholiday_id);
		vacholidayService.update(domain );
		VACHOLIDAYDTO dto = vacholidayMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacholidayService.getVacholidayByEntities(this.vacholidayMapping.toDomain(#vacholidaydtos)),'ehr-VACHOLIDAY-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"VACHOLIDAY" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacholidays/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VACHOLIDAYDTO> vacholidaydtos) {
        vacholidayService.updateBatch(vacholidayMapping.toDomain(vacholidaydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacholidayService.get(#vacholiday_id),'ehr-VACHOLIDAY-Remove')")
    @ApiOperation(value = "Remove", tags = {"VACHOLIDAY" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacholidays/{vacholiday_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacholiday_id") String vacholiday_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacholidayService.remove(vacholiday_id));
    }

    @PreAuthorize("hasPermission(this.vacholidayService.getVacholidayByIds(#ids),'ehr-VACHOLIDAY-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"VACHOLIDAY" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacholidays/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacholidayService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"VACHOLIDAY" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidays/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VACHOLIDAYDTO vacholidaydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacholidayService.checkKey(vacholidayMapping.toDomain(vacholidaydto)));
    }

    @ApiOperation(value = "GetDraft", tags = {"VACHOLIDAY" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/vacholidays/getdraft")
    public ResponseEntity<VACHOLIDAYDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacholidayMapping.toDto(vacholidayService.getDraft(new VACHOLIDAY())));
    }

    @PostAuthorize("hasPermission(this.vacholidayMapping.toDomain(returnObject.body),'ehr-VACHOLIDAY-Get')")
    @ApiOperation(value = "Get", tags = {"VACHOLIDAY" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/vacholidays/{vacholiday_id}")
    public ResponseEntity<VACHOLIDAYDTO> get(@PathVariable("vacholiday_id") String vacholiday_id) {
        VACHOLIDAY domain = vacholidayService.get(vacholiday_id);
        VACHOLIDAYDTO dto = vacholidayMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacholidayMapping.toDomain(#vacholidaydto),'ehr-VACHOLIDAY-Save')")
    @ApiOperation(value = "Save", tags = {"VACHOLIDAY" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidays/save")
    public ResponseEntity<Boolean> save(@RequestBody VACHOLIDAYDTO vacholidaydto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacholidayService.save(vacholidayMapping.toDomain(vacholidaydto)));
    }

    @PreAuthorize("hasPermission(this.vacholidayMapping.toDomain(#vacholidaydtos),'ehr-VACHOLIDAY-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"VACHOLIDAY" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidays/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VACHOLIDAYDTO> vacholidaydtos) {
        vacholidayService.saveBatch(vacholidayMapping.toDomain(vacholidaydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacholidayMapping.toDomain(#vacholidaydto),'ehr-VACHOLIDAY-Create')")
    @ApiOperation(value = "Create", tags = {"VACHOLIDAY" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidays")
    @Transactional
    public ResponseEntity<VACHOLIDAYDTO> create(@RequestBody VACHOLIDAYDTO vacholidaydto) {
        VACHOLIDAY domain = vacholidayMapping.toDomain(vacholidaydto);
		vacholidayService.create(domain);
        VACHOLIDAYDTO dto = vacholidayMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacholidayMapping.toDomain(#vacholidaydtos),'ehr-VACHOLIDAY-Create')")
    @ApiOperation(value = "createBatch", tags = {"VACHOLIDAY" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidays/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VACHOLIDAYDTO> vacholidaydtos) {
        vacholidayService.createBatch(vacholidayMapping.toDomain(vacholidaydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACHOLIDAY-CheckTime-all')")
    @ApiOperation(value = "校验开始时间、结束时间", tags = {"VACHOLIDAY" },  notes = "校验开始时间、结束时间")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidays/{vacholiday_id}/checktime")
    @Transactional
    public ResponseEntity<VACHOLIDAYDTO> checkTime(@PathVariable("vacholiday_id") String vacholiday_id, @RequestBody VACHOLIDAYDTO vacholidaydto) {
        VACHOLIDAY vacholiday = vacholidayMapping.toDomain(vacholidaydto);
        vacholiday.setVacholidayid(vacholiday_id);
        vacholiday = vacholidayService.checkTime(vacholiday);
        vacholidaydto = vacholidayMapping.toDto(vacholiday);
        return ResponseEntity.status(HttpStatus.OK).body(vacholidaydto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACHOLIDAY-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"VACHOLIDAY" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacholidays/fetchdefault")
	public ResponseEntity<List<VACHOLIDAYDTO>> fetchDefault(VACHOLIDAYSearchContext context) {
        Page<VACHOLIDAY> domains = vacholidayService.searchDefault(context) ;
        List<VACHOLIDAYDTO> list = vacholidayMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACHOLIDAY-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"VACHOLIDAY" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacholidays/searchdefault")
	public ResponseEntity<Page<VACHOLIDAYDTO>> searchDefault(@RequestBody VACHOLIDAYSearchContext context) {
        Page<VACHOLIDAY> domains = vacholidayService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacholidayMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACHOLIDAY-APPOINTJZBJJR-all')")
    @ApiOperation(value = "引用局总部节假日ByVACHOLIDAYRULES", tags = {"VACHOLIDAY" },  notes = "引用局总部节假日ByVACHOLIDAYRULES")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays/{vacholiday_id}/appointjzbjjr")
    @Transactional
    public ResponseEntity<VACHOLIDAYDTO> aPPOINTJZBJJRByVACHOLIDAYRULES(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @PathVariable("vacholiday_id") String vacholiday_id, @RequestBody VACHOLIDAYDTO vacholidaydto) {
        VACHOLIDAY domain = vacholidayMapping.toDomain(vacholidaydto);
        domain.setVacholidayrulesid(vacholidayrules_id);
        domain = vacholidayService.aPPOINTJZBJJR(domain) ;
        vacholidaydto = vacholidayMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(vacholidaydto);
    }

    @PreAuthorize("hasPermission(this.vacholidayService.get(#vacholiday_id),'ehr-VACHOLIDAY-Update')")
    @ApiOperation(value = "UpdateByVACHOLIDAYRULES", tags = {"VACHOLIDAY" },  notes = "UpdateByVACHOLIDAYRULES")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays/{vacholiday_id}")
    @Transactional
    public ResponseEntity<VACHOLIDAYDTO> updateByVACHOLIDAYRULES(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @PathVariable("vacholiday_id") String vacholiday_id, @RequestBody VACHOLIDAYDTO vacholidaydto) {
        VACHOLIDAY domain = vacholidayMapping.toDomain(vacholidaydto);
        domain.setVacholidayrulesid(vacholidayrules_id);
        domain.setVacholidayid(vacholiday_id);
		vacholidayService.update(domain);
        VACHOLIDAYDTO dto = vacholidayMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacholidayService.getVacholidayByEntities(this.vacholidayMapping.toDomain(#vacholidaydtos)),'ehr-VACHOLIDAY-Update')")
    @ApiOperation(value = "UpdateBatchByVACHOLIDAYRULES", tags = {"VACHOLIDAY" },  notes = "UpdateBatchByVACHOLIDAYRULES")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays/batch")
    public ResponseEntity<Boolean> updateBatchByVACHOLIDAYRULES(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody List<VACHOLIDAYDTO> vacholidaydtos) {
        List<VACHOLIDAY> domainlist=vacholidayMapping.toDomain(vacholidaydtos);
        for(VACHOLIDAY domain:domainlist){
            domain.setVacholidayrulesid(vacholidayrules_id);
        }
        vacholidayService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacholidayService.get(#vacholiday_id),'ehr-VACHOLIDAY-Remove')")
    @ApiOperation(value = "RemoveByVACHOLIDAYRULES", tags = {"VACHOLIDAY" },  notes = "RemoveByVACHOLIDAYRULES")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays/{vacholiday_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByVACHOLIDAYRULES(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @PathVariable("vacholiday_id") String vacholiday_id) {
		return ResponseEntity.status(HttpStatus.OK).body(vacholidayService.remove(vacholiday_id));
    }

    @PreAuthorize("hasPermission(this.vacholidayService.getVacholidayByIds(#ids),'ehr-VACHOLIDAY-Remove')")
    @ApiOperation(value = "RemoveBatchByVACHOLIDAYRULES", tags = {"VACHOLIDAY" },  notes = "RemoveBatchByVACHOLIDAYRULES")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays/batch")
    public ResponseEntity<Boolean> removeBatchByVACHOLIDAYRULES(@RequestBody List<String> ids) {
        vacholidayService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByVACHOLIDAYRULES", tags = {"VACHOLIDAY" },  notes = "CheckKeyByVACHOLIDAYRULES")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays/checkkey")
    public ResponseEntity<Boolean> checkKeyByVACHOLIDAYRULES(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody VACHOLIDAYDTO vacholidaydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacholidayService.checkKey(vacholidayMapping.toDomain(vacholidaydto)));
    }

    @ApiOperation(value = "GetDraftByVACHOLIDAYRULES", tags = {"VACHOLIDAY" },  notes = "GetDraftByVACHOLIDAYRULES")
    @RequestMapping(method = RequestMethod.GET, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays/getdraft")
    public ResponseEntity<VACHOLIDAYDTO> getDraftByVACHOLIDAYRULES(@PathVariable("vacholidayrules_id") String vacholidayrules_id) {
        VACHOLIDAY domain = new VACHOLIDAY();
        domain.setVacholidayrulesid(vacholidayrules_id);
        return ResponseEntity.status(HttpStatus.OK).body(vacholidayMapping.toDto(vacholidayService.getDraft(domain)));
    }

    @PostAuthorize("hasPermission(this.vacholidayMapping.toDomain(returnObject.body),'ehr-VACHOLIDAY-Get')")
    @ApiOperation(value = "GetByVACHOLIDAYRULES", tags = {"VACHOLIDAY" },  notes = "GetByVACHOLIDAYRULES")
	@RequestMapping(method = RequestMethod.GET, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays/{vacholiday_id}")
    public ResponseEntity<VACHOLIDAYDTO> getByVACHOLIDAYRULES(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @PathVariable("vacholiday_id") String vacholiday_id) {
        VACHOLIDAY domain = vacholidayService.get(vacholiday_id);
        VACHOLIDAYDTO dto = vacholidayMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacholidayMapping.toDomain(#vacholidaydto),'ehr-VACHOLIDAY-Save')")
    @ApiOperation(value = "SaveByVACHOLIDAYRULES", tags = {"VACHOLIDAY" },  notes = "SaveByVACHOLIDAYRULES")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays/save")
    public ResponseEntity<Boolean> saveByVACHOLIDAYRULES(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody VACHOLIDAYDTO vacholidaydto) {
        VACHOLIDAY domain = vacholidayMapping.toDomain(vacholidaydto);
        domain.setVacholidayrulesid(vacholidayrules_id);
        return ResponseEntity.status(HttpStatus.OK).body(vacholidayService.save(domain));
    }

    @PreAuthorize("hasPermission(this.vacholidayMapping.toDomain(#vacholidaydtos),'ehr-VACHOLIDAY-Save')")
    @ApiOperation(value = "SaveBatchByVACHOLIDAYRULES", tags = {"VACHOLIDAY" },  notes = "SaveBatchByVACHOLIDAYRULES")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays/savebatch")
    public ResponseEntity<Boolean> saveBatchByVACHOLIDAYRULES(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody List<VACHOLIDAYDTO> vacholidaydtos) {
        List<VACHOLIDAY> domainlist=vacholidayMapping.toDomain(vacholidaydtos);
        for(VACHOLIDAY domain:domainlist){
             domain.setVacholidayrulesid(vacholidayrules_id);
        }
        vacholidayService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacholidayMapping.toDomain(#vacholidaydto),'ehr-VACHOLIDAY-Create')")
    @ApiOperation(value = "CreateByVACHOLIDAYRULES", tags = {"VACHOLIDAY" },  notes = "CreateByVACHOLIDAYRULES")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays")
    @Transactional
    public ResponseEntity<VACHOLIDAYDTO> createByVACHOLIDAYRULES(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody VACHOLIDAYDTO vacholidaydto) {
        VACHOLIDAY domain = vacholidayMapping.toDomain(vacholidaydto);
        domain.setVacholidayrulesid(vacholidayrules_id);
		vacholidayService.create(domain);
        VACHOLIDAYDTO dto = vacholidayMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacholidayMapping.toDomain(#vacholidaydtos),'ehr-VACHOLIDAY-Create')")
    @ApiOperation(value = "createBatchByVACHOLIDAYRULES", tags = {"VACHOLIDAY" },  notes = "createBatchByVACHOLIDAYRULES")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays/batch")
    public ResponseEntity<Boolean> createBatchByVACHOLIDAYRULES(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody List<VACHOLIDAYDTO> vacholidaydtos) {
        List<VACHOLIDAY> domainlist=vacholidayMapping.toDomain(vacholidaydtos);
        for(VACHOLIDAY domain:domainlist){
            domain.setVacholidayrulesid(vacholidayrules_id);
        }
        vacholidayService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACHOLIDAY-CheckTime-all')")
    @ApiOperation(value = "校验开始时间、结束时间ByVACHOLIDAYRULES", tags = {"VACHOLIDAY" },  notes = "校验开始时间、结束时间ByVACHOLIDAYRULES")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays/{vacholiday_id}/checktime")
    @Transactional
    public ResponseEntity<VACHOLIDAYDTO> checkTimeByVACHOLIDAYRULES(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @PathVariable("vacholiday_id") String vacholiday_id, @RequestBody VACHOLIDAYDTO vacholidaydto) {
        VACHOLIDAY domain = vacholidayMapping.toDomain(vacholidaydto);
        domain.setVacholidayrulesid(vacholidayrules_id);
        domain = vacholidayService.checkTime(domain) ;
        vacholidaydto = vacholidayMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(vacholidaydto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACHOLIDAY-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByVACHOLIDAYRULES", tags = {"VACHOLIDAY" } ,notes = "fetchDEFAULTByVACHOLIDAYRULES")
    @RequestMapping(method= RequestMethod.GET , value="/vacholidayrules/{vacholidayrules_id}/vacholidays/fetchdefault")
	public ResponseEntity<List<VACHOLIDAYDTO>> fetchVACHOLIDAYDefaultByVACHOLIDAYRULES(@PathVariable("vacholidayrules_id") String vacholidayrules_id,VACHOLIDAYSearchContext context) {
        context.setN_vacholidayrulesid_eq(vacholidayrules_id);
        Page<VACHOLIDAY> domains = vacholidayService.searchDefault(context) ;
        List<VACHOLIDAYDTO> list = vacholidayMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACHOLIDAY-Default-all')")
	@ApiOperation(value = "searchDEFAULTByVACHOLIDAYRULES", tags = {"VACHOLIDAY" } ,notes = "searchDEFAULTByVACHOLIDAYRULES")
    @RequestMapping(method= RequestMethod.POST , value="/vacholidayrules/{vacholidayrules_id}/vacholidays/searchdefault")
	public ResponseEntity<Page<VACHOLIDAYDTO>> searchVACHOLIDAYDefaultByVACHOLIDAYRULES(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody VACHOLIDAYSearchContext context) {
        context.setN_vacholidayrulesid_eq(vacholidayrules_id);
        Page<VACHOLIDAY> domains = vacholidayService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacholidayMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

