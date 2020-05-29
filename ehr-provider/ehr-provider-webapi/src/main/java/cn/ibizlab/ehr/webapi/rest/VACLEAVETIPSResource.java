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
import cn.ibizlab.ehr.core.vac.domain.VACLEAVETIPS;
import cn.ibizlab.ehr.core.vac.service.IVACLEAVETIPSService;
import cn.ibizlab.ehr.core.vac.filter.VACLEAVETIPSSearchContext;

@Slf4j
@Api(tags = {"请假提示" })
@RestController("WebApi-vacleavetips")
@RequestMapping("")
public class VACLEAVETIPSResource {

    @Autowired
    public IVACLEAVETIPSService vacleavetipsService;

    @Autowired
    @Lazy
    public VACLEAVETIPSMapping vacleavetipsMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVETIPS-CheckQJZL-all')")
    @ApiOperation(value = "检查请假种类", tags = {"请假提示" },  notes = "检查请假种类")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavetips/{vacleavetips_id}/checkqjzl")
    @Transactional
    public ResponseEntity<VACLEAVETIPSDTO> checkQJZL(@PathVariable("vacleavetips_id") String vacleavetips_id, @RequestBody VACLEAVETIPSDTO vacleavetipsdto) {
        VACLEAVETIPS vacleavetips = vacleavetipsMapping.toDomain(vacleavetipsdto);
        vacleavetips.setVacleavetipsid(vacleavetips_id);
        vacleavetips = vacleavetipsService.checkQJZL(vacleavetips);
        vacleavetipsdto = vacleavetipsMapping.toDto(vacleavetips);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavetipsdto);
    }

    @PreAuthorize("hasPermission(this.vacleavetipsMapping.toDomain(#vacleavetipsdto),'ehr-VACLEAVETIPS-Create')")
    @ApiOperation(value = "新建请假提示", tags = {"请假提示" },  notes = "新建请假提示")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavetips")
    @Transactional
    public ResponseEntity<VACLEAVETIPSDTO> create(@RequestBody VACLEAVETIPSDTO vacleavetipsdto) {
        VACLEAVETIPS domain = vacleavetipsMapping.toDomain(vacleavetipsdto);
		vacleavetipsService.create(domain);
        VACLEAVETIPSDTO dto = vacleavetipsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacleavetipsMapping.toDomain(#vacleavetipsdtos),'ehr-VACLEAVETIPS-Create')")
    @ApiOperation(value = "批量新建请假提示", tags = {"请假提示" },  notes = "批量新建请假提示")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavetips/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VACLEAVETIPSDTO> vacleavetipsdtos) {
        vacleavetipsService.createBatch(vacleavetipsMapping.toDomain(vacleavetipsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取请假提示草稿", tags = {"请假提示" },  notes = "获取请假提示草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/vacleavetips/getdraft")
    public ResponseEntity<VACLEAVETIPSDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacleavetipsMapping.toDto(vacleavetipsService.getDraft(new VACLEAVETIPS())));
    }

    @PreAuthorize("hasPermission(this.vacleavetipsService.get(#vacleavetips_id),'ehr-VACLEAVETIPS-Remove')")
    @ApiOperation(value = "删除请假提示", tags = {"请假提示" },  notes = "删除请假提示")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacleavetips/{vacleavetips_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacleavetips_id") String vacleavetips_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacleavetipsService.remove(vacleavetips_id));
    }

    @PreAuthorize("hasPermission(this.vacleavetipsService.getVacleavetipsByIds(#ids),'ehr-VACLEAVETIPS-Remove')")
    @ApiOperation(value = "批量删除请假提示", tags = {"请假提示" },  notes = "批量删除请假提示")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacleavetips/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacleavetipsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查请假提示", tags = {"请假提示" },  notes = "检查请假提示")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavetips/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VACLEAVETIPSDTO vacleavetipsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacleavetipsService.checkKey(vacleavetipsMapping.toDomain(vacleavetipsdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVETIPS-CheckRepeat-all')")
    @ApiOperation(value = "检查重复", tags = {"请假提示" },  notes = "检查重复")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavetips/{vacleavetips_id}/checkrepeat")
    @Transactional
    public ResponseEntity<VACLEAVETIPSDTO> checkRepeat(@PathVariable("vacleavetips_id") String vacleavetips_id, @RequestBody VACLEAVETIPSDTO vacleavetipsdto) {
        VACLEAVETIPS vacleavetips = vacleavetipsMapping.toDomain(vacleavetipsdto);
        vacleavetips.setVacleavetipsid(vacleavetips_id);
        vacleavetips = vacleavetipsService.checkRepeat(vacleavetips);
        vacleavetipsdto = vacleavetipsMapping.toDto(vacleavetips);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavetipsdto);
    }

    @PostAuthorize("hasPermission(this.vacleavetipsMapping.toDomain(returnObject.body),'ehr-VACLEAVETIPS-Get')")
    @ApiOperation(value = "获取请假提示", tags = {"请假提示" },  notes = "获取请假提示")
	@RequestMapping(method = RequestMethod.GET, value = "/vacleavetips/{vacleavetips_id}")
    public ResponseEntity<VACLEAVETIPSDTO> get(@PathVariable("vacleavetips_id") String vacleavetips_id) {
        VACLEAVETIPS domain = vacleavetipsService.get(vacleavetips_id);
        VACLEAVETIPSDTO dto = vacleavetipsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacleavetipsService.get(#vacleavetips_id),'ehr-VACLEAVETIPS-Update')")
    @ApiOperation(value = "更新请假提示", tags = {"请假提示" },  notes = "更新请假提示")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacleavetips/{vacleavetips_id}")
    @Transactional
    public ResponseEntity<VACLEAVETIPSDTO> update(@PathVariable("vacleavetips_id") String vacleavetips_id, @RequestBody VACLEAVETIPSDTO vacleavetipsdto) {
		VACLEAVETIPS domain  = vacleavetipsMapping.toDomain(vacleavetipsdto);
        domain .setVacleavetipsid(vacleavetips_id);
		vacleavetipsService.update(domain );
		VACLEAVETIPSDTO dto = vacleavetipsMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacleavetipsService.getVacleavetipsByEntities(this.vacleavetipsMapping.toDomain(#vacleavetipsdtos)),'ehr-VACLEAVETIPS-Update')")
    @ApiOperation(value = "批量更新请假提示", tags = {"请假提示" },  notes = "批量更新请假提示")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacleavetips/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VACLEAVETIPSDTO> vacleavetipsdtos) {
        vacleavetipsService.updateBatch(vacleavetipsMapping.toDomain(vacleavetipsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacleavetipsMapping.toDomain(#vacleavetipsdto),'ehr-VACLEAVETIPS-Save')")
    @ApiOperation(value = "保存请假提示", tags = {"请假提示" },  notes = "保存请假提示")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavetips/save")
    public ResponseEntity<Boolean> save(@RequestBody VACLEAVETIPSDTO vacleavetipsdto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacleavetipsService.save(vacleavetipsMapping.toDomain(vacleavetipsdto)));
    }

    @PreAuthorize("hasPermission(this.vacleavetipsMapping.toDomain(#vacleavetipsdtos),'ehr-VACLEAVETIPS-Save')")
    @ApiOperation(value = "批量保存请假提示", tags = {"请假提示" },  notes = "批量保存请假提示")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavetips/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VACLEAVETIPSDTO> vacleavetipsdtos) {
        vacleavetipsService.saveBatch(vacleavetipsMapping.toDomain(vacleavetipsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVETIPS-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"请假提示" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacleavetips/fetchdefault")
	public ResponseEntity<List<VACLEAVETIPSDTO>> fetchDefault(VACLEAVETIPSSearchContext context) {
        Page<VACLEAVETIPS> domains = vacleavetipsService.searchDefault(context) ;
        List<VACLEAVETIPSDTO> list = vacleavetipsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVETIPS-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"请假提示" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacleavetips/searchdefault")
	public ResponseEntity<Page<VACLEAVETIPSDTO>> searchDefault(@RequestBody VACLEAVETIPSSearchContext context) {
        Page<VACLEAVETIPS> domains = vacleavetipsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleavetipsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVETIPS-CheckQJZL-all')")
    @ApiOperation(value = "根据考勤规则请假提示", tags = {"请假提示" },  notes = "根据考勤规则请假提示")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/{vacholidayrules_id}/vacleavetips/{vacleavetips_id}/checkqjzl")
    @Transactional
    public ResponseEntity<VACLEAVETIPSDTO> checkQJZLByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @PathVariable("vacleavetips_id") String vacleavetips_id, @RequestBody VACLEAVETIPSDTO vacleavetipsdto) {
        VACLEAVETIPS domain = vacleavetipsMapping.toDomain(vacleavetipsdto);
        domain.setVacholidayrulesid(vacholidayrules_id);
        domain = vacleavetipsService.checkQJZL(domain) ;
        vacleavetipsdto = vacleavetipsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavetipsdto);
    }

    @PreAuthorize("hasPermission(this.vacleavetipsMapping.toDomain(#vacleavetipsdto),'ehr-VACLEAVETIPS-Create')")
    @ApiOperation(value = "根据考勤规则建立请假提示", tags = {"请假提示" },  notes = "根据考勤规则建立请假提示")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/{vacholidayrules_id}/vacleavetips")
    @Transactional
    public ResponseEntity<VACLEAVETIPSDTO> createByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody VACLEAVETIPSDTO vacleavetipsdto) {
        VACLEAVETIPS domain = vacleavetipsMapping.toDomain(vacleavetipsdto);
        domain.setVacholidayrulesid(vacholidayrules_id);
		vacleavetipsService.create(domain);
        VACLEAVETIPSDTO dto = vacleavetipsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacleavetipsMapping.toDomain(#vacleavetipsdtos),'ehr-VACLEAVETIPS-Create')")
    @ApiOperation(value = "根据考勤规则批量建立请假提示", tags = {"请假提示" },  notes = "根据考勤规则批量建立请假提示")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/{vacholidayrules_id}/vacleavetips/batch")
    public ResponseEntity<Boolean> createBatchByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody List<VACLEAVETIPSDTO> vacleavetipsdtos) {
        List<VACLEAVETIPS> domainlist=vacleavetipsMapping.toDomain(vacleavetipsdtos);
        for(VACLEAVETIPS domain:domainlist){
            domain.setVacholidayrulesid(vacholidayrules_id);
        }
        vacleavetipsService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据考勤规则获取请假提示草稿", tags = {"请假提示" },  notes = "根据考勤规则获取请假提示草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/vacholidayrules/{vacholidayrules_id}/vacleavetips/getdraft")
    public ResponseEntity<VACLEAVETIPSDTO> getDraftByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id) {
        VACLEAVETIPS domain = new VACLEAVETIPS();
        domain.setVacholidayrulesid(vacholidayrules_id);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavetipsMapping.toDto(vacleavetipsService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.vacleavetipsService.get(#vacleavetips_id),'ehr-VACLEAVETIPS-Remove')")
    @ApiOperation(value = "根据考勤规则删除请假提示", tags = {"请假提示" },  notes = "根据考勤规则删除请假提示")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacholidayrules/{vacholidayrules_id}/vacleavetips/{vacleavetips_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @PathVariable("vacleavetips_id") String vacleavetips_id) {
		return ResponseEntity.status(HttpStatus.OK).body(vacleavetipsService.remove(vacleavetips_id));
    }

    @PreAuthorize("hasPermission(this.vacleavetipsService.getVacleavetipsByIds(#ids),'ehr-VACLEAVETIPS-Remove')")
    @ApiOperation(value = "根据考勤规则批量删除请假提示", tags = {"请假提示" },  notes = "根据考勤规则批量删除请假提示")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacholidayrules/{vacholidayrules_id}/vacleavetips/batch")
    public ResponseEntity<Boolean> removeBatchByVacHolidayRules(@RequestBody List<String> ids) {
        vacleavetipsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据考勤规则检查请假提示", tags = {"请假提示" },  notes = "根据考勤规则检查请假提示")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/{vacholidayrules_id}/vacleavetips/checkkey")
    public ResponseEntity<Boolean> checkKeyByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody VACLEAVETIPSDTO vacleavetipsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacleavetipsService.checkKey(vacleavetipsMapping.toDomain(vacleavetipsdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVETIPS-CheckRepeat-all')")
    @ApiOperation(value = "根据考勤规则请假提示", tags = {"请假提示" },  notes = "根据考勤规则请假提示")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/{vacholidayrules_id}/vacleavetips/{vacleavetips_id}/checkrepeat")
    @Transactional
    public ResponseEntity<VACLEAVETIPSDTO> checkRepeatByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @PathVariable("vacleavetips_id") String vacleavetips_id, @RequestBody VACLEAVETIPSDTO vacleavetipsdto) {
        VACLEAVETIPS domain = vacleavetipsMapping.toDomain(vacleavetipsdto);
        domain.setVacholidayrulesid(vacholidayrules_id);
        domain = vacleavetipsService.checkRepeat(domain) ;
        vacleavetipsdto = vacleavetipsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavetipsdto);
    }

    @PostAuthorize("hasPermission(this.vacleavetipsMapping.toDomain(returnObject.body),'ehr-VACLEAVETIPS-Get')")
    @ApiOperation(value = "根据考勤规则获取请假提示", tags = {"请假提示" },  notes = "根据考勤规则获取请假提示")
	@RequestMapping(method = RequestMethod.GET, value = "/vacholidayrules/{vacholidayrules_id}/vacleavetips/{vacleavetips_id}")
    public ResponseEntity<VACLEAVETIPSDTO> getByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @PathVariable("vacleavetips_id") String vacleavetips_id) {
        VACLEAVETIPS domain = vacleavetipsService.get(vacleavetips_id);
        VACLEAVETIPSDTO dto = vacleavetipsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacleavetipsService.get(#vacleavetips_id),'ehr-VACLEAVETIPS-Update')")
    @ApiOperation(value = "根据考勤规则更新请假提示", tags = {"请假提示" },  notes = "根据考勤规则更新请假提示")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacholidayrules/{vacholidayrules_id}/vacleavetips/{vacleavetips_id}")
    @Transactional
    public ResponseEntity<VACLEAVETIPSDTO> updateByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @PathVariable("vacleavetips_id") String vacleavetips_id, @RequestBody VACLEAVETIPSDTO vacleavetipsdto) {
        VACLEAVETIPS domain = vacleavetipsMapping.toDomain(vacleavetipsdto);
        domain.setVacholidayrulesid(vacholidayrules_id);
        domain.setVacleavetipsid(vacleavetips_id);
		vacleavetipsService.update(domain);
        VACLEAVETIPSDTO dto = vacleavetipsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacleavetipsService.getVacleavetipsByEntities(this.vacleavetipsMapping.toDomain(#vacleavetipsdtos)),'ehr-VACLEAVETIPS-Update')")
    @ApiOperation(value = "根据考勤规则批量更新请假提示", tags = {"请假提示" },  notes = "根据考勤规则批量更新请假提示")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacholidayrules/{vacholidayrules_id}/vacleavetips/batch")
    public ResponseEntity<Boolean> updateBatchByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody List<VACLEAVETIPSDTO> vacleavetipsdtos) {
        List<VACLEAVETIPS> domainlist=vacleavetipsMapping.toDomain(vacleavetipsdtos);
        for(VACLEAVETIPS domain:domainlist){
            domain.setVacholidayrulesid(vacholidayrules_id);
        }
        vacleavetipsService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacleavetipsMapping.toDomain(#vacleavetipsdto),'ehr-VACLEAVETIPS-Save')")
    @ApiOperation(value = "根据考勤规则保存请假提示", tags = {"请假提示" },  notes = "根据考勤规则保存请假提示")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/{vacholidayrules_id}/vacleavetips/save")
    public ResponseEntity<Boolean> saveByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody VACLEAVETIPSDTO vacleavetipsdto) {
        VACLEAVETIPS domain = vacleavetipsMapping.toDomain(vacleavetipsdto);
        domain.setVacholidayrulesid(vacholidayrules_id);
        return ResponseEntity.status(HttpStatus.OK).body(vacleavetipsService.save(domain));
    }

    @PreAuthorize("hasPermission(this.vacleavetipsMapping.toDomain(#vacleavetipsdtos),'ehr-VACLEAVETIPS-Save')")
    @ApiOperation(value = "根据考勤规则批量保存请假提示", tags = {"请假提示" },  notes = "根据考勤规则批量保存请假提示")
	@RequestMapping(method = RequestMethod.POST, value = "/vacholidayrules/{vacholidayrules_id}/vacleavetips/savebatch")
    public ResponseEntity<Boolean> saveBatchByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody List<VACLEAVETIPSDTO> vacleavetipsdtos) {
        List<VACLEAVETIPS> domainlist=vacleavetipsMapping.toDomain(vacleavetipsdtos);
        for(VACLEAVETIPS domain:domainlist){
             domain.setVacholidayrulesid(vacholidayrules_id);
        }
        vacleavetipsService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVETIPS-Default-all')")
	@ApiOperation(value = "根据考勤规则获取DEFAULT", tags = {"请假提示" } ,notes = "根据考勤规则获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacholidayrules/{vacholidayrules_id}/vacleavetips/fetchdefault")
	public ResponseEntity<List<VACLEAVETIPSDTO>> fetchVACLEAVETIPSDefaultByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id,VACLEAVETIPSSearchContext context) {
        context.setN_vacholidayrulesid_eq(vacholidayrules_id);
        Page<VACLEAVETIPS> domains = vacleavetipsService.searchDefault(context) ;
        List<VACLEAVETIPSDTO> list = vacleavetipsMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVETIPS-Default-all')")
	@ApiOperation(value = "根据考勤规则查询DEFAULT", tags = {"请假提示" } ,notes = "根据考勤规则查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacholidayrules/{vacholidayrules_id}/vacleavetips/searchdefault")
	public ResponseEntity<Page<VACLEAVETIPSDTO>> searchVACLEAVETIPSDefaultByVacHolidayRules(@PathVariable("vacholidayrules_id") String vacholidayrules_id, @RequestBody VACLEAVETIPSSearchContext context) {
        context.setN_vacholidayrulesid_eq(vacholidayrules_id);
        Page<VACLEAVETIPS> domains = vacleavetipsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleavetipsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

