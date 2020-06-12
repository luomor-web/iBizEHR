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
import cn.ibizlab.ehr.core.vac.domain.VacLeaveTips;
import cn.ibizlab.ehr.core.vac.service.IVacLeaveTipsService;
import cn.ibizlab.ehr.core.vac.filter.VacLeaveTipsSearchContext;

@Slf4j
@Api(tags = {"请假提示" })
@RestController("WebApi-vacleavetips")
@RequestMapping("")
public class VacLeaveTipsResource {

    @Autowired
    public IVacLeaveTipsService vacleavetipsService;

    @Autowired
    @Lazy
    public VacLeaveTipsMapping vacleavetipsMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveTips-CheckQJZL-all')")
    @ApiOperation(value = "检查请假种类", tags = {"请假提示" },  notes = "检查请假种类")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavetips/{vacleavetips_id}/checkqjzl")
    @Transactional
    public ResponseEntity<VacLeaveTipsDTO> checkQJZL(@PathVariable("vacleavetips_id") String vacleavetips_id, @RequestBody VacLeaveTipsDTO vacleavetipsdto) {
        VacLeaveTips vacleavetips = vacleavetipsMapping.toDomain(vacleavetipsdto);
        vacleavetips.setVacleavetipsid(vacleavetips_id);
        vacleavetips = vacleavetipsService.checkQJZL(vacleavetips);
        vacleavetipsdto = vacleavetipsMapping.toDto(vacleavetips);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavetipsdto);
    }

    @PreAuthorize("hasPermission(this.vacleavetipsMapping.toDomain(#vacleavetipsdto),'ehr-VacLeaveTips-Create')")
    @ApiOperation(value = "新建请假提示", tags = {"请假提示" },  notes = "新建请假提示")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavetips")
    @Transactional
    public ResponseEntity<VacLeaveTipsDTO> create(@RequestBody VacLeaveTipsDTO vacleavetipsdto) {
        VacLeaveTips domain = vacleavetipsMapping.toDomain(vacleavetipsdto);
		vacleavetipsService.create(domain);
        VacLeaveTipsDTO dto = vacleavetipsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacleavetipsMapping.toDomain(#vacleavetipsdtos),'ehr-VacLeaveTips-Create')")
    @ApiOperation(value = "批量新建请假提示", tags = {"请假提示" },  notes = "批量新建请假提示")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavetips/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VacLeaveTipsDTO> vacleavetipsdtos) {
        vacleavetipsService.createBatch(vacleavetipsMapping.toDomain(vacleavetipsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取请假提示草稿", tags = {"请假提示" },  notes = "获取请假提示草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/vacleavetips/getdraft")
    public ResponseEntity<VacLeaveTipsDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacleavetipsMapping.toDto(vacleavetipsService.getDraft(new VacLeaveTips())));
    }

    @PreAuthorize("hasPermission(this.vacleavetipsService.get(#vacleavetips_id),'ehr-VacLeaveTips-Remove')")
    @ApiOperation(value = "删除请假提示", tags = {"请假提示" },  notes = "删除请假提示")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacleavetips/{vacleavetips_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacleavetips_id") String vacleavetips_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacleavetipsService.remove(vacleavetips_id));
    }

    @PreAuthorize("hasPermission(this.vacleavetipsService.getVacleavetipsByIds(#ids),'ehr-VacLeaveTips-Remove')")
    @ApiOperation(value = "批量删除请假提示", tags = {"请假提示" },  notes = "批量删除请假提示")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacleavetips/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacleavetipsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查请假提示", tags = {"请假提示" },  notes = "检查请假提示")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavetips/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VacLeaveTipsDTO vacleavetipsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacleavetipsService.checkKey(vacleavetipsMapping.toDomain(vacleavetipsdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveTips-CheckRepeat-all')")
    @ApiOperation(value = "检查重复", tags = {"请假提示" },  notes = "检查重复")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavetips/{vacleavetips_id}/checkrepeat")
    @Transactional
    public ResponseEntity<VacLeaveTipsDTO> checkRepeat(@PathVariable("vacleavetips_id") String vacleavetips_id, @RequestBody VacLeaveTipsDTO vacleavetipsdto) {
        VacLeaveTips vacleavetips = vacleavetipsMapping.toDomain(vacleavetipsdto);
        vacleavetips.setVacleavetipsid(vacleavetips_id);
        vacleavetips = vacleavetipsService.checkRepeat(vacleavetips);
        vacleavetipsdto = vacleavetipsMapping.toDto(vacleavetips);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavetipsdto);
    }

    @PostAuthorize("hasPermission(this.vacleavetipsMapping.toDomain(returnObject.body),'ehr-VacLeaveTips-Get')")
    @ApiOperation(value = "获取请假提示", tags = {"请假提示" },  notes = "获取请假提示")
	@RequestMapping(method = RequestMethod.GET, value = "/vacleavetips/{vacleavetips_id}")
    public ResponseEntity<VacLeaveTipsDTO> get(@PathVariable("vacleavetips_id") String vacleavetips_id) {
        VacLeaveTips domain = vacleavetipsService.get(vacleavetips_id);
        VacLeaveTipsDTO dto = vacleavetipsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacleavetipsService.get(#vacleavetips_id),'ehr-VacLeaveTips-Update')")
    @ApiOperation(value = "更新请假提示", tags = {"请假提示" },  notes = "更新请假提示")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacleavetips/{vacleavetips_id}")
    @Transactional
    public ResponseEntity<VacLeaveTipsDTO> update(@PathVariable("vacleavetips_id") String vacleavetips_id, @RequestBody VacLeaveTipsDTO vacleavetipsdto) {
		VacLeaveTips domain  = vacleavetipsMapping.toDomain(vacleavetipsdto);
        domain .setVacleavetipsid(vacleavetips_id);
		vacleavetipsService.update(domain );
		VacLeaveTipsDTO dto = vacleavetipsMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacleavetipsService.getVacleavetipsByEntities(this.vacleavetipsMapping.toDomain(#vacleavetipsdtos)),'ehr-VacLeaveTips-Update')")
    @ApiOperation(value = "批量更新请假提示", tags = {"请假提示" },  notes = "批量更新请假提示")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacleavetips/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VacLeaveTipsDTO> vacleavetipsdtos) {
        vacleavetipsService.updateBatch(vacleavetipsMapping.toDomain(vacleavetipsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacleavetipsMapping.toDomain(#vacleavetipsdto),'ehr-VacLeaveTips-Save')")
    @ApiOperation(value = "保存请假提示", tags = {"请假提示" },  notes = "保存请假提示")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavetips/save")
    public ResponseEntity<Boolean> save(@RequestBody VacLeaveTipsDTO vacleavetipsdto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacleavetipsService.save(vacleavetipsMapping.toDomain(vacleavetipsdto)));
    }

    @PreAuthorize("hasPermission(this.vacleavetipsMapping.toDomain(#vacleavetipsdtos),'ehr-VacLeaveTips-Save')")
    @ApiOperation(value = "批量保存请假提示", tags = {"请假提示" },  notes = "批量保存请假提示")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavetips/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VacLeaveTipsDTO> vacleavetipsdtos) {
        vacleavetipsService.saveBatch(vacleavetipsMapping.toDomain(vacleavetipsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveTips-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"请假提示" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacleavetips/fetchdefault")
	public ResponseEntity<List<VacLeaveTipsDTO>> fetchDefault(VacLeaveTipsSearchContext context) {
        Page<VacLeaveTips> domains = vacleavetipsService.searchDefault(context) ;
        List<VacLeaveTipsDTO> list = vacleavetipsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveTips-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"请假提示" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacleavetips/searchdefault")
	public ResponseEntity<Page<VacLeaveTipsDTO>> searchDefault(@RequestBody VacLeaveTipsSearchContext context) {
        Page<VacLeaveTips> domains = vacleavetipsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleavetipsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveTips-CheckQJZL-all')")
    @ApiOperation(value = "根据考勤规则请假提示", tags = {"请假提示" },  notes = "根据考勤规则请假提示")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/{vacholidayrules_id}/vacleavetips/{vacleavetips_id}/checkqjzl")
    @Transactional
    public ResponseEntity<VacLeaveTipsDTO> checkQJZLByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @PathVariable("vacleavetips_id") String vacleavetips_id, @RequestBody VacLeaveTipsDTO vacleavetipsdto) {
        VacLeaveTips domain = vacleavetipsMapping.toDomain(vacleavetipsdto);
        domain.setVacholidayrulesid(vacholidayrules_id);
        domain = vacleavetipsService.checkQJZL(domain) ;
        vacleavetipsdto = vacleavetipsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavetipsdto);
    }

    @PreAuthorize("hasPermission(this.vacleavetipsMapping.toDomain(#vacleavetipsdto),'ehr-VacLeaveTips-Create')")
    @ApiOperation(value = "根据考勤规则建立请假提示", tags = {"请假提示" },  notes = "根据考勤规则建立请假提示")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/{vacholidayrules_id}/vacleavetips")
    @Transactional
    public ResponseEntity<VacLeaveTipsDTO> createByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody VacLeaveTipsDTO vacleavetipsdto) {
        VacLeaveTips domain = vacleavetipsMapping.toDomain(vacleavetipsdto);
        domain.setVacholidayrulesid(vacholidayrules_id);
		vacleavetipsService.create(domain);
        VacLeaveTipsDTO dto = vacleavetipsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacleavetipsMapping.toDomain(#vacleavetipsdtos),'ehr-VacLeaveTips-Create')")
    @ApiOperation(value = "根据考勤规则批量建立请假提示", tags = {"请假提示" },  notes = "根据考勤规则批量建立请假提示")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/{vacholidayrules_id}/vacleavetips/batch")
    public ResponseEntity<Boolean> createBatchByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody List<VacLeaveTipsDTO> vacleavetipsdtos) {
        List<VacLeaveTips> domainlist=vacleavetipsMapping.toDomain(vacleavetipsdtos);
        for(VacLeaveTips domain:domainlist){
            domain.setVacholidayrulesid(vacholidayrules_id);
        }
        vacleavetipsService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据考勤规则获取请假提示草稿", tags = {"请假提示" },  notes = "根据考勤规则获取请假提示草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/vacholidayrules/{vacholidayrules_id}/vacleavetips/getdraft")
    public ResponseEntity<VacLeaveTipsDTO> getDraftByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id) {
        VacLeaveTips domain = new VacLeaveTips();
        domain.setVacholidayrulesid(vacholidayrules_id);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavetipsMapping.toDto(vacleavetipsService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.vacleavetipsService.get(#vacleavetips_id),'ehr-VacLeaveTips-Remove')")
    @ApiOperation(value = "根据考勤规则删除请假提示", tags = {"请假提示" },  notes = "根据考勤规则删除请假提示")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacholidayrules/{vacholidayrules_id}/vacleavetips/{vacleavetips_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @PathVariable("vacleavetips_id") String vacleavetips_id) {
		return ResponseEntity.status(HttpStatus.OK).body(vacleavetipsService.remove(vacleavetips_id));
    }

    @PreAuthorize("hasPermission(this.vacleavetipsService.getVacleavetipsByIds(#ids),'ehr-VacLeaveTips-Remove')")
    @ApiOperation(value = "根据考勤规则批量删除请假提示", tags = {"请假提示" },  notes = "根据考勤规则批量删除请假提示")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacholidayrules/{vacholidayrules_id}/vacleavetips/batch")
    public ResponseEntity<Boolean> removeBatchByVacHolidayRules(@RequestBody List<String> ids) {
        vacleavetipsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据考勤规则检查请假提示", tags = {"请假提示" },  notes = "根据考勤规则检查请假提示")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/{vacholidayrules_id}/vacleavetips/checkkey")
    public ResponseEntity<Boolean> checkKeyByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody VacLeaveTipsDTO vacleavetipsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacleavetipsService.checkKey(vacleavetipsMapping.toDomain(vacleavetipsdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveTips-CheckRepeat-all')")
    @ApiOperation(value = "根据考勤规则请假提示", tags = {"请假提示" },  notes = "根据考勤规则请假提示")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/{vacholidayrules_id}/vacleavetips/{vacleavetips_id}/checkrepeat")
    @Transactional
    public ResponseEntity<VacLeaveTipsDTO> checkRepeatByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @PathVariable("vacleavetips_id") String vacleavetips_id, @RequestBody VacLeaveTipsDTO vacleavetipsdto) {
        VacLeaveTips domain = vacleavetipsMapping.toDomain(vacleavetipsdto);
        domain.setVacholidayrulesid(vacholidayrules_id);
        domain = vacleavetipsService.checkRepeat(domain) ;
        vacleavetipsdto = vacleavetipsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavetipsdto);
    }

    @PostAuthorize("hasPermission(this.vacleavetipsMapping.toDomain(returnObject.body),'ehr-VacLeaveTips-Get')")
    @ApiOperation(value = "根据考勤规则获取请假提示", tags = {"请假提示" },  notes = "根据考勤规则获取请假提示")
	@RequestMapping(method = RequestMethod.GET, value = "/vacholidayrules/{vacholidayrules_id}/vacleavetips/{vacleavetips_id}")
    public ResponseEntity<VacLeaveTipsDTO> getByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @PathVariable("vacleavetips_id") String vacleavetips_id) {
        VacLeaveTips domain = vacleavetipsService.get(vacleavetips_id);
        VacLeaveTipsDTO dto = vacleavetipsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacleavetipsService.get(#vacleavetips_id),'ehr-VacLeaveTips-Update')")
    @ApiOperation(value = "根据考勤规则更新请假提示", tags = {"请假提示" },  notes = "根据考勤规则更新请假提示")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacholidayrules/{vacholidayrules_id}/vacleavetips/{vacleavetips_id}")
    @Transactional
    public ResponseEntity<VacLeaveTipsDTO> updateByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @PathVariable("vacleavetips_id") String vacleavetips_id, @RequestBody VacLeaveTipsDTO vacleavetipsdto) {
        VacLeaveTips domain = vacleavetipsMapping.toDomain(vacleavetipsdto);
        domain.setVacholidayrulesid(vacholidayrules_id);
        domain.setVacleavetipsid(vacleavetips_id);
		vacleavetipsService.update(domain);
        VacLeaveTipsDTO dto = vacleavetipsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacleavetipsService.getVacleavetipsByEntities(this.vacleavetipsMapping.toDomain(#vacleavetipsdtos)),'ehr-VacLeaveTips-Update')")
    @ApiOperation(value = "根据考勤规则批量更新请假提示", tags = {"请假提示" },  notes = "根据考勤规则批量更新请假提示")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacholidayrules/{vacholidayrules_id}/vacleavetips/batch")
    public ResponseEntity<Boolean> updateBatchByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody List<VacLeaveTipsDTO> vacleavetipsdtos) {
        List<VacLeaveTips> domainlist=vacleavetipsMapping.toDomain(vacleavetipsdtos);
        for(VacLeaveTips domain:domainlist){
            domain.setVacholidayrulesid(vacholidayrules_id);
        }
        vacleavetipsService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacleavetipsMapping.toDomain(#vacleavetipsdto),'ehr-VacLeaveTips-Save')")
    @ApiOperation(value = "根据考勤规则保存请假提示", tags = {"请假提示" },  notes = "根据考勤规则保存请假提示")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/{vacholidayrules_id}/vacleavetips/save")
    public ResponseEntity<Boolean> saveByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody VacLeaveTipsDTO vacleavetipsdto) {
        VacLeaveTips domain = vacleavetipsMapping.toDomain(vacleavetipsdto);
        domain.setVacholidayrulesid(vacholidayrules_id);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavetipsService.save(domain));
    }

    @PreAuthorize("hasPermission(this.vacleavetipsMapping.toDomain(#vacleavetipsdtos),'ehr-VacLeaveTips-Save')")
    @ApiOperation(value = "根据考勤规则批量保存请假提示", tags = {"请假提示" },  notes = "根据考勤规则批量保存请假提示")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/{vacholidayrules_id}/vacleavetips/savebatch")
    public ResponseEntity<Boolean> saveBatchByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody List<VacLeaveTipsDTO> vacleavetipsdtos) {
        List<VacLeaveTips> domainlist=vacleavetipsMapping.toDomain(vacleavetipsdtos);
        for(VacLeaveTips domain:domainlist){
             domain.setVacholidayrulesid(vacholidayrules_id);
        }
        vacleavetipsService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveTips-Default-all')")
	@ApiOperation(value = "根据考勤规则获取DEFAULT", tags = {"请假提示" } ,notes = "根据考勤规则获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacholidayrules/{vacholidayrules_id}/vacleavetips/fetchdefault")
	public ResponseEntity<List<VacLeaveTipsDTO>> fetchVacLeaveTipsDefaultByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id,VacLeaveTipsSearchContext context) {
        context.setN_vacholidayrulesid_eq(vacholidayrules_id);
        Page<VacLeaveTips> domains = vacleavetipsService.searchDefault(context) ;
        List<VacLeaveTipsDTO> list = vacleavetipsMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaveTips-Default-all')")
	@ApiOperation(value = "根据考勤规则查询DEFAULT", tags = {"请假提示" } ,notes = "根据考勤规则查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacholidayrules/{vacholidayrules_id}/vacleavetips/searchdefault")
	public ResponseEntity<Page<VacLeaveTipsDTO>> searchVacLeaveTipsDefaultByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody VacLeaveTipsSearchContext context) {
        context.setN_vacholidayrulesid_eq(vacholidayrules_id);
        Page<VacLeaveTips> domains = vacleavetipsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleavetipsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

