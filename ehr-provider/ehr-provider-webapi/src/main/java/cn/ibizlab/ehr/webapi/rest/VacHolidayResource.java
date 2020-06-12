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
import cn.ibizlab.ehr.core.vac.domain.VacHoliday;
import cn.ibizlab.ehr.core.vac.service.IVacHolidayService;
import cn.ibizlab.ehr.core.vac.filter.VacHolidaySearchContext;

@Slf4j
@Api(tags = {"节假日管理" })
@RestController("WebApi-vacholiday")
@RequestMapping("")
public class VacHolidayResource {

    @Autowired
    public IVacHolidayService vacholidayService;

    @Autowired
    @Lazy
    public VacHolidayMapping vacholidayMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacHoliday-APPOINTJZBJJR-all')")
    @ApiOperation(value = "引用局总部节假日", tags = {"节假日管理" },  notes = "引用局总部节假日")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidays/{vacholiday_id}/appointjzbjjr")
    @Transactional
    public ResponseEntity<VacHolidayDTO> aPPOINTJZBJJR(@PathVariable("vacholiday_id") String vacholiday_id, @RequestBody VacHolidayDTO vacholidaydto) {
        VacHoliday vacholiday = vacholidayMapping.toDomain(vacholidaydto);
        vacholiday.setVacholidayid(vacholiday_id);
        vacholiday = vacholidayService.aPPOINTJZBJJR(vacholiday);
        vacholidaydto = vacholidayMapping.toDto(vacholiday);
        return ResponseEntity.status(HttpStatus.OK).body(vacholidaydto);
    }

    @PreAuthorize("hasPermission(this.vacholidayService.get(#vacholiday_id),'ehr-VacHoliday-Update')")
    @ApiOperation(value = "更新节假日管理", tags = {"节假日管理" },  notes = "更新节假日管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacholidays/{vacholiday_id}")
    @Transactional
    public ResponseEntity<VacHolidayDTO> update(@PathVariable("vacholiday_id") String vacholiday_id, @RequestBody VacHolidayDTO vacholidaydto) {
		VacHoliday domain  = vacholidayMapping.toDomain(vacholidaydto);
        domain .setVacholidayid(vacholiday_id);
		vacholidayService.update(domain );
		VacHolidayDTO dto = vacholidayMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacholidayService.getVacholidayByEntities(this.vacholidayMapping.toDomain(#vacholidaydtos)),'ehr-VacHoliday-Update')")
    @ApiOperation(value = "批量更新节假日管理", tags = {"节假日管理" },  notes = "批量更新节假日管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacholidays/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VacHolidayDTO> vacholidaydtos) {
        vacholidayService.updateBatch(vacholidayMapping.toDomain(vacholidaydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacholidayService.get(#vacholiday_id),'ehr-VacHoliday-Remove')")
    @ApiOperation(value = "删除节假日管理", tags = {"节假日管理" },  notes = "删除节假日管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacholidays/{vacholiday_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacholiday_id") String vacholiday_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacholidayService.remove(vacholiday_id));
    }

    @PreAuthorize("hasPermission(this.vacholidayService.getVacholidayByIds(#ids),'ehr-VacHoliday-Remove')")
    @ApiOperation(value = "批量删除节假日管理", tags = {"节假日管理" },  notes = "批量删除节假日管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacholidays/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacholidayService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查节假日管理", tags = {"节假日管理" },  notes = "检查节假日管理")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidays/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VacHolidayDTO vacholidaydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacholidayService.checkKey(vacholidayMapping.toDomain(vacholidaydto)));
    }

    @ApiOperation(value = "获取节假日管理草稿", tags = {"节假日管理" },  notes = "获取节假日管理草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/vacholidays/getdraft")
    public ResponseEntity<VacHolidayDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacholidayMapping.toDto(vacholidayService.getDraft(new VacHoliday())));
    }

    @PostAuthorize("hasPermission(this.vacholidayMapping.toDomain(returnObject.body),'ehr-VacHoliday-Get')")
    @ApiOperation(value = "获取节假日管理", tags = {"节假日管理" },  notes = "获取节假日管理")
	@RequestMapping(method = RequestMethod.GET, value = "/vacholidays/{vacholiday_id}")
    public ResponseEntity<VacHolidayDTO> get(@PathVariable("vacholiday_id") String vacholiday_id) {
        VacHoliday domain = vacholidayService.get(vacholiday_id);
        VacHolidayDTO dto = vacholidayMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacholidayMapping.toDomain(#vacholidaydto),'ehr-VacHoliday-Save')")
    @ApiOperation(value = "保存节假日管理", tags = {"节假日管理" },  notes = "保存节假日管理")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidays/save")
    public ResponseEntity<Boolean> save(@RequestBody VacHolidayDTO vacholidaydto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacholidayService.save(vacholidayMapping.toDomain(vacholidaydto)));
    }

    @PreAuthorize("hasPermission(this.vacholidayMapping.toDomain(#vacholidaydtos),'ehr-VacHoliday-Save')")
    @ApiOperation(value = "批量保存节假日管理", tags = {"节假日管理" },  notes = "批量保存节假日管理")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidays/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VacHolidayDTO> vacholidaydtos) {
        vacholidayService.saveBatch(vacholidayMapping.toDomain(vacholidaydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacholidayMapping.toDomain(#vacholidaydto),'ehr-VacHoliday-Create')")
    @ApiOperation(value = "新建节假日管理", tags = {"节假日管理" },  notes = "新建节假日管理")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidays")
    @Transactional
    public ResponseEntity<VacHolidayDTO> create(@RequestBody VacHolidayDTO vacholidaydto) {
        VacHoliday domain = vacholidayMapping.toDomain(vacholidaydto);
		vacholidayService.create(domain);
        VacHolidayDTO dto = vacholidayMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacholidayMapping.toDomain(#vacholidaydtos),'ehr-VacHoliday-Create')")
    @ApiOperation(value = "批量新建节假日管理", tags = {"节假日管理" },  notes = "批量新建节假日管理")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidays/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VacHolidayDTO> vacholidaydtos) {
        vacholidayService.createBatch(vacholidayMapping.toDomain(vacholidaydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacHoliday-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"节假日管理" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacholidays/fetchdefault")
	public ResponseEntity<List<VacHolidayDTO>> fetchDefault(VacHolidaySearchContext context) {
        Page<VacHoliday> domains = vacholidayService.searchDefault(context) ;
        List<VacHolidayDTO> list = vacholidayMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacHoliday-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"节假日管理" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacholidays/searchdefault")
	public ResponseEntity<Page<VacHolidayDTO>> searchDefault(@RequestBody VacHolidaySearchContext context) {
        Page<VacHoliday> domains = vacholidayService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacholidayMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacHoliday-APPOINTJZBJJR-all')")
    @ApiOperation(value = "根据考勤规则节假日管理", tags = {"节假日管理" },  notes = "根据考勤规则节假日管理")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays/{vacholiday_id}/appointjzbjjr")
    @Transactional
    public ResponseEntity<VacHolidayDTO> aPPOINTJZBJJRByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @PathVariable("vacholiday_id") String vacholiday_id, @RequestBody VacHolidayDTO vacholidaydto) {
        VacHoliday domain = vacholidayMapping.toDomain(vacholidaydto);
        domain.setVacholidayrulesid(vacholidayrules_id);
        domain = vacholidayService.aPPOINTJZBJJR(domain) ;
        vacholidaydto = vacholidayMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(vacholidaydto);
    }

    @PreAuthorize("hasPermission(this.vacholidayService.get(#vacholiday_id),'ehr-VacHoliday-Update')")
    @ApiOperation(value = "根据考勤规则更新节假日管理", tags = {"节假日管理" },  notes = "根据考勤规则更新节假日管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays/{vacholiday_id}")
    @Transactional
    public ResponseEntity<VacHolidayDTO> updateByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @PathVariable("vacholiday_id") String vacholiday_id, @RequestBody VacHolidayDTO vacholidaydto) {
        VacHoliday domain = vacholidayMapping.toDomain(vacholidaydto);
        domain.setVacholidayrulesid(vacholidayrules_id);
        domain.setVacholidayid(vacholiday_id);
		vacholidayService.update(domain);
        VacHolidayDTO dto = vacholidayMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacholidayService.getVacholidayByEntities(this.vacholidayMapping.toDomain(#vacholidaydtos)),'ehr-VacHoliday-Update')")
    @ApiOperation(value = "根据考勤规则批量更新节假日管理", tags = {"节假日管理" },  notes = "根据考勤规则批量更新节假日管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays/batch")
    public ResponseEntity<Boolean> updateBatchByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody List<VacHolidayDTO> vacholidaydtos) {
        List<VacHoliday> domainlist=vacholidayMapping.toDomain(vacholidaydtos);
        for(VacHoliday domain:domainlist){
            domain.setVacholidayrulesid(vacholidayrules_id);
        }
        vacholidayService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacholidayService.get(#vacholiday_id),'ehr-VacHoliday-Remove')")
    @ApiOperation(value = "根据考勤规则删除节假日管理", tags = {"节假日管理" },  notes = "根据考勤规则删除节假日管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays/{vacholiday_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @PathVariable("vacholiday_id") String vacholiday_id) {
		return ResponseEntity.status(HttpStatus.OK).body(vacholidayService.remove(vacholiday_id));
    }

    @PreAuthorize("hasPermission(this.vacholidayService.getVacholidayByIds(#ids),'ehr-VacHoliday-Remove')")
    @ApiOperation(value = "根据考勤规则批量删除节假日管理", tags = {"节假日管理" },  notes = "根据考勤规则批量删除节假日管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays/batch")
    public ResponseEntity<Boolean> removeBatchByVacHolidayRules(@RequestBody List<String> ids) {
        vacholidayService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据考勤规则检查节假日管理", tags = {"节假日管理" },  notes = "根据考勤规则检查节假日管理")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays/checkkey")
    public ResponseEntity<Boolean> checkKeyByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody VacHolidayDTO vacholidaydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacholidayService.checkKey(vacholidayMapping.toDomain(vacholidaydto)));
    }

    @ApiOperation(value = "根据考勤规则获取节假日管理草稿", tags = {"节假日管理" },  notes = "根据考勤规则获取节假日管理草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays/getdraft")
    public ResponseEntity<VacHolidayDTO> getDraftByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id) {
        VacHoliday domain = new VacHoliday();
        domain.setVacholidayrulesid(vacholidayrules_id);
        return ResponseEntity.status(HttpStatus.OK).body(vacholidayMapping.toDto(vacholidayService.getDraft(domain)));
    }

    @PostAuthorize("hasPermission(this.vacholidayMapping.toDomain(returnObject.body),'ehr-VacHoliday-Get')")
    @ApiOperation(value = "根据考勤规则获取节假日管理", tags = {"节假日管理" },  notes = "根据考勤规则获取节假日管理")
	@RequestMapping(method = RequestMethod.GET, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays/{vacholiday_id}")
    public ResponseEntity<VacHolidayDTO> getByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @PathVariable("vacholiday_id") String vacholiday_id) {
        VacHoliday domain = vacholidayService.get(vacholiday_id);
        VacHolidayDTO dto = vacholidayMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacholidayMapping.toDomain(#vacholidaydto),'ehr-VacHoliday-Save')")
    @ApiOperation(value = "根据考勤规则保存节假日管理", tags = {"节假日管理" },  notes = "根据考勤规则保存节假日管理")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays/save")
    public ResponseEntity<Boolean> saveByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody VacHolidayDTO vacholidaydto) {
        VacHoliday domain = vacholidayMapping.toDomain(vacholidaydto);
        domain.setVacholidayrulesid(vacholidayrules_id);
        return ResponseEntity.status(HttpStatus.OK).body(vacholidayService.save(domain));
    }

    @PreAuthorize("hasPermission(this.vacholidayMapping.toDomain(#vacholidaydtos),'ehr-VacHoliday-Save')")
    @ApiOperation(value = "根据考勤规则批量保存节假日管理", tags = {"节假日管理" },  notes = "根据考勤规则批量保存节假日管理")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays/savebatch")
    public ResponseEntity<Boolean> saveBatchByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody List<VacHolidayDTO> vacholidaydtos) {
        List<VacHoliday> domainlist=vacholidayMapping.toDomain(vacholidaydtos);
        for(VacHoliday domain:domainlist){
             domain.setVacholidayrulesid(vacholidayrules_id);
        }
        vacholidayService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacholidayMapping.toDomain(#vacholidaydto),'ehr-VacHoliday-Create')")
    @ApiOperation(value = "根据考勤规则建立节假日管理", tags = {"节假日管理" },  notes = "根据考勤规则建立节假日管理")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays")
    @Transactional
    public ResponseEntity<VacHolidayDTO> createByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody VacHolidayDTO vacholidaydto) {
        VacHoliday domain = vacholidayMapping.toDomain(vacholidaydto);
        domain.setVacholidayrulesid(vacholidayrules_id);
		vacholidayService.create(domain);
        VacHolidayDTO dto = vacholidayMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacholidayMapping.toDomain(#vacholidaydtos),'ehr-VacHoliday-Create')")
    @ApiOperation(value = "根据考勤规则批量建立节假日管理", tags = {"节假日管理" },  notes = "根据考勤规则批量建立节假日管理")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/{vacholidayrules_id}/vacholidays/batch")
    public ResponseEntity<Boolean> createBatchByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody List<VacHolidayDTO> vacholidaydtos) {
        List<VacHoliday> domainlist=vacholidayMapping.toDomain(vacholidaydtos);
        for(VacHoliday domain:domainlist){
            domain.setVacholidayrulesid(vacholidayrules_id);
        }
        vacholidayService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacHoliday-Default-all')")
	@ApiOperation(value = "根据考勤规则获取DEFAULT", tags = {"节假日管理" } ,notes = "根据考勤规则获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacholidayrules/{vacholidayrules_id}/vacholidays/fetchdefault")
	public ResponseEntity<List<VacHolidayDTO>> fetchVacHolidayDefaultByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id,VacHolidaySearchContext context) {
        context.setN_vacholidayrulesid_eq(vacholidayrules_id);
        Page<VacHoliday> domains = vacholidayService.searchDefault(context) ;
        List<VacHolidayDTO> list = vacholidayMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacHoliday-Default-all')")
	@ApiOperation(value = "根据考勤规则查询DEFAULT", tags = {"节假日管理" } ,notes = "根据考勤规则查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacholidayrules/{vacholidayrules_id}/vacholidays/searchdefault")
	public ResponseEntity<Page<VacHolidayDTO>> searchVacHolidayDefaultByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody VacHolidaySearchContext context) {
        context.setN_vacholidayrulesid_eq(vacholidayrules_id);
        Page<VacHoliday> domains = vacholidayService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacholidayMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

