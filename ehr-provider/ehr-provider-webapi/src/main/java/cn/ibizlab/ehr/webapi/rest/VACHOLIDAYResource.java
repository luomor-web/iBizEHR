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
@Api(tags = {"节假日管理" })
@RestController("WebApi-vacholiday")
@RequestMapping("")
public class VACHOLIDAYResource {

    @Autowired
    public IVACHOLIDAYService vacholidayService;

    @Autowired
    @Lazy
    public VACHOLIDAYMapping vacholidayMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACHOLIDAY-APPOINTJZBJJR-all')")
    @ApiOperation(value = "引用局总部节假日", tags = {"节假日管理" },  notes = "引用局总部节假日")
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
    @ApiOperation(value = "更新节假日管理", tags = {"节假日管理" },  notes = "更新节假日管理")
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
    @ApiOperation(value = "批量更新节假日管理", tags = {"节假日管理" },  notes = "批量更新节假日管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacholidays/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VACHOLIDAYDTO> vacholidaydtos) {
        vacholidayService.updateBatch(vacholidayMapping.toDomain(vacholidaydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacholidayService.get(#vacholiday_id),'ehr-VACHOLIDAY-Remove')")
    @ApiOperation(value = "删除节假日管理", tags = {"节假日管理" },  notes = "删除节假日管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacholidays/{vacholiday_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacholiday_id") String vacholiday_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacholidayService.remove(vacholiday_id));
    }

    @PreAuthorize("hasPermission(this.vacholidayService.getVacholidayByIds(#ids),'ehr-VACHOLIDAY-Remove')")
    @ApiOperation(value = "批量删除节假日管理", tags = {"节假日管理" },  notes = "批量删除节假日管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacholidays/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacholidayService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查节假日管理", tags = {"节假日管理" },  notes = "检查节假日管理")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidays/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VACHOLIDAYDTO vacholidaydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacholidayService.checkKey(vacholidayMapping.toDomain(vacholidaydto)));
    }

    @ApiOperation(value = "获取节假日管理草稿", tags = {"节假日管理" },  notes = "获取节假日管理草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/vacholidays/getdraft")
    public ResponseEntity<VACHOLIDAYDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacholidayMapping.toDto(vacholidayService.getDraft(new VACHOLIDAY())));
    }

    @PostAuthorize("hasPermission(this.vacholidayMapping.toDomain(returnObject.body),'ehr-VACHOLIDAY-Get')")
    @ApiOperation(value = "获取节假日管理", tags = {"节假日管理" },  notes = "获取节假日管理")
	@RequestMapping(method = RequestMethod.GET, value = "/vacholidays/{vacholiday_id}")
    public ResponseEntity<VACHOLIDAYDTO> get(@PathVariable("vacholiday_id") String vacholiday_id) {
        VACHOLIDAY domain = vacholidayService.get(vacholiday_id);
        VACHOLIDAYDTO dto = vacholidayMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacholidayMapping.toDomain(#vacholidaydto),'ehr-VACHOLIDAY-Save')")
    @ApiOperation(value = "保存节假日管理", tags = {"节假日管理" },  notes = "保存节假日管理")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidays/save")
    public ResponseEntity<Boolean> save(@RequestBody VACHOLIDAYDTO vacholidaydto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacholidayService.save(vacholidayMapping.toDomain(vacholidaydto)));
    }

    @PreAuthorize("hasPermission(this.vacholidayMapping.toDomain(#vacholidaydtos),'ehr-VACHOLIDAY-Save')")
    @ApiOperation(value = "批量保存节假日管理", tags = {"节假日管理" },  notes = "批量保存节假日管理")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidays/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VACHOLIDAYDTO> vacholidaydtos) {
        vacholidayService.saveBatch(vacholidayMapping.toDomain(vacholidaydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacholidayMapping.toDomain(#vacholidaydto),'ehr-VACHOLIDAY-Create')")
    @ApiOperation(value = "新建节假日管理", tags = {"节假日管理" },  notes = "新建节假日管理")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidays")
    @Transactional
    public ResponseEntity<VACHOLIDAYDTO> create(@RequestBody VACHOLIDAYDTO vacholidaydto) {
        VACHOLIDAY domain = vacholidayMapping.toDomain(vacholidaydto);
		vacholidayService.create(domain);
        VACHOLIDAYDTO dto = vacholidayMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacholidayMapping.toDomain(#vacholidaydtos),'ehr-VACHOLIDAY-Create')")
    @ApiOperation(value = "批量新建节假日管理", tags = {"节假日管理" },  notes = "批量新建节假日管理")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidays/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VACHOLIDAYDTO> vacholidaydtos) {
        vacholidayService.createBatch(vacholidayMapping.toDomain(vacholidaydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACHOLIDAY-CheckTime-all')")
    @ApiOperation(value = "校验开始时间、结束时间", tags = {"节假日管理" },  notes = "校验开始时间、结束时间")
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
	@ApiOperation(value = "获取DEFAULT", tags = {"节假日管理" } ,notes = "获取{deds.getLogicName()}")
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
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"节假日管理" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/vacholidays/searchdefault")
	public ResponseEntity<Page<VACHOLIDAYDTO>> searchDefault(@RequestBody VACHOLIDAYSearchContext context) {
        Page<VACHOLIDAY> domains = vacholidayService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacholidayMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACHOLIDAY-APPOINTJZBJJR-all')")
    @ApiOperation(value = "根据考勤规则节假日管理", tags = {"节假日管理" },  notes = "根据考勤规则节假日管理")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays/{vacholiday_id}/appointjzbjjr")
    @Transactional
    public ResponseEntity<VACHOLIDAYDTO> aPPOINTJZBJJRByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @PathVariable("vacholiday_id") String vacholiday_id, @RequestBody VACHOLIDAYDTO vacholidaydto) {
        VACHOLIDAY domain = vacholidayMapping.toDomain(vacholidaydto);
        domain.setVacholidayrulesid(vacholidayrules_id);
        domain = vacholidayService.aPPOINTJZBJJR(domain) ;
        vacholidaydto = vacholidayMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(vacholidaydto);
    }

    @PreAuthorize("hasPermission(this.vacholidayService.get(#vacholiday_id),'ehr-VACHOLIDAY-Update')")
    @ApiOperation(value = "根据考勤规则更新节假日管理", tags = {"节假日管理" },  notes = "根据考勤规则更新节假日管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays/{vacholiday_id}")
    @Transactional
    public ResponseEntity<VACHOLIDAYDTO> updateByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @PathVariable("vacholiday_id") String vacholiday_id, @RequestBody VACHOLIDAYDTO vacholidaydto) {
        VACHOLIDAY domain = vacholidayMapping.toDomain(vacholidaydto);
        domain.setVacholidayrulesid(vacholidayrules_id);
        domain.setVacholidayid(vacholiday_id);
		vacholidayService.update(domain);
        VACHOLIDAYDTO dto = vacholidayMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacholidayService.getVacholidayByEntities(this.vacholidayMapping.toDomain(#vacholidaydtos)),'ehr-VACHOLIDAY-Update')")
    @ApiOperation(value = "根据考勤规则批量更新节假日管理", tags = {"节假日管理" },  notes = "根据考勤规则批量更新节假日管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays/batch")
    public ResponseEntity<Boolean> updateBatchByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody List<VACHOLIDAYDTO> vacholidaydtos) {
        List<VACHOLIDAY> domainlist=vacholidayMapping.toDomain(vacholidaydtos);
        for(VACHOLIDAY domain:domainlist){
            domain.setVacholidayrulesid(vacholidayrules_id);
        }
        vacholidayService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacholidayService.get(#vacholiday_id),'ehr-VACHOLIDAY-Remove')")
    @ApiOperation(value = "根据考勤规则删除节假日管理", tags = {"节假日管理" },  notes = "根据考勤规则删除节假日管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays/{vacholiday_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @PathVariable("vacholiday_id") String vacholiday_id) {
		return ResponseEntity.status(HttpStatus.OK).body(vacholidayService.remove(vacholiday_id));
    }

    @PreAuthorize("hasPermission(this.vacholidayService.getVacholidayByIds(#ids),'ehr-VACHOLIDAY-Remove')")
    @ApiOperation(value = "根据考勤规则批量删除节假日管理", tags = {"节假日管理" },  notes = "根据考勤规则批量删除节假日管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays/batch")
    public ResponseEntity<Boolean> removeBatchByVacHolidayRules(@RequestBody List<String> ids) {
        vacholidayService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据考勤规则检查节假日管理", tags = {"节假日管理" },  notes = "根据考勤规则检查节假日管理")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays/checkkey")
    public ResponseEntity<Boolean> checkKeyByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody VACHOLIDAYDTO vacholidaydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacholidayService.checkKey(vacholidayMapping.toDomain(vacholidaydto)));
    }

    @ApiOperation(value = "根据考勤规则获取节假日管理草稿", tags = {"节假日管理" },  notes = "根据考勤规则获取节假日管理草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays/getdraft")
    public ResponseEntity<VACHOLIDAYDTO> getDraftByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id) {
        VACHOLIDAY domain = new VACHOLIDAY();
        domain.setVacholidayrulesid(vacholidayrules_id);
        return ResponseEntity.status(HttpStatus.OK).body(vacholidayMapping.toDto(vacholidayService.getDraft(domain)));
    }

    @PostAuthorize("hasPermission(this.vacholidayMapping.toDomain(returnObject.body),'ehr-VACHOLIDAY-Get')")
    @ApiOperation(value = "根据考勤规则获取节假日管理", tags = {"节假日管理" },  notes = "根据考勤规则获取节假日管理")
	@RequestMapping(method = RequestMethod.GET, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays/{vacholiday_id}")
    public ResponseEntity<VACHOLIDAYDTO> getByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @PathVariable("vacholiday_id") String vacholiday_id) {
        VACHOLIDAY domain = vacholidayService.get(vacholiday_id);
        VACHOLIDAYDTO dto = vacholidayMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacholidayMapping.toDomain(#vacholidaydto),'ehr-VACHOLIDAY-Save')")
    @ApiOperation(value = "根据考勤规则保存节假日管理", tags = {"节假日管理" },  notes = "根据考勤规则保存节假日管理")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays/save")
    public ResponseEntity<Boolean> saveByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody VACHOLIDAYDTO vacholidaydto) {
        VACHOLIDAY domain = vacholidayMapping.toDomain(vacholidaydto);
        domain.setVacholidayrulesid(vacholidayrules_id);
        return ResponseEntity.status(HttpStatus.OK).body(vacholidayService.save(domain));
    }

    @PreAuthorize("hasPermission(this.vacholidayMapping.toDomain(#vacholidaydtos),'ehr-VACHOLIDAY-Save')")
    @ApiOperation(value = "根据考勤规则批量保存节假日管理", tags = {"节假日管理" },  notes = "根据考勤规则批量保存节假日管理")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays/savebatch")
    public ResponseEntity<Boolean> saveBatchByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody List<VACHOLIDAYDTO> vacholidaydtos) {
        List<VACHOLIDAY> domainlist=vacholidayMapping.toDomain(vacholidaydtos);
        for(VACHOLIDAY domain:domainlist){
             domain.setVacholidayrulesid(vacholidayrules_id);
        }
        vacholidayService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacholidayMapping.toDomain(#vacholidaydto),'ehr-VACHOLIDAY-Create')")
    @ApiOperation(value = "根据考勤规则建立节假日管理", tags = {"节假日管理" },  notes = "根据考勤规则建立节假日管理")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays")
    @Transactional
    public ResponseEntity<VACHOLIDAYDTO> createByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody VACHOLIDAYDTO vacholidaydto) {
        VACHOLIDAY domain = vacholidayMapping.toDomain(vacholidaydto);
        domain.setVacholidayrulesid(vacholidayrules_id);
		vacholidayService.create(domain);
        VACHOLIDAYDTO dto = vacholidayMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacholidayMapping.toDomain(#vacholidaydtos),'ehr-VACHOLIDAY-Create')")
    @ApiOperation(value = "根据考勤规则批量建立节假日管理", tags = {"节假日管理" },  notes = "根据考勤规则批量建立节假日管理")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays/batch")
    public ResponseEntity<Boolean> createBatchByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody List<VACHOLIDAYDTO> vacholidaydtos) {
        List<VACHOLIDAY> domainlist=vacholidayMapping.toDomain(vacholidaydtos);
        for(VACHOLIDAY domain:domainlist){
            domain.setVacholidayrulesid(vacholidayrules_id);
        }
        vacholidayService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACHOLIDAY-CheckTime-all')")
    @ApiOperation(value = "根据考勤规则节假日管理", tags = {"节假日管理" },  notes = "根据考勤规则节假日管理")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays/{vacholiday_id}/checktime")
    @Transactional
    public ResponseEntity<VACHOLIDAYDTO> checkTimeByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @PathVariable("vacholiday_id") String vacholiday_id, @RequestBody VACHOLIDAYDTO vacholidaydto) {
        VACHOLIDAY domain = vacholidayMapping.toDomain(vacholidaydto);
        domain.setVacholidayrulesid(vacholidayrules_id);
        domain = vacholidayService.checkTime(domain) ;
        vacholidaydto = vacholidayMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(vacholidaydto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACHOLIDAY-Default-all')")
	@ApiOperation(value = "根据考勤规则获取DEFAULT", tags = {"节假日管理" } ,notes = "根据考勤规则获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacholidayrules/{vacholidayrules_id}/vacholidays/fetchdefault")
	public ResponseEntity<List<VACHOLIDAYDTO>> fetchVACHOLIDAYDefaultByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id,VACHOLIDAYSearchContext context) {
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
	@ApiOperation(value = "根据考勤规则查询DEFAULT", tags = {"节假日管理" } ,notes = "根据考勤规则查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacholidayrules/{vacholidayrules_id}/vacholidays/searchdefault")
	public ResponseEntity<Page<VACHOLIDAYDTO>> searchVACHOLIDAYDefaultByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody VACHOLIDAYSearchContext context) {
        context.setN_vacholidayrulesid_eq(vacholidayrules_id);
        Page<VACHOLIDAY> domains = vacholidayService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacholidayMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

