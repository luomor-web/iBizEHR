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
import cn.ibizlab.ehr.core.att.domain.ATTENDANCEMREPORTMX;
import cn.ibizlab.ehr.core.att.service.IATTENDANCEMREPORTMXService;
import cn.ibizlab.ehr.core.att.filter.ATTENDANCEMREPORTMXSearchContext;

@Slf4j
@Api(tags = {"考勤月报明细" })
@RestController("WebApi-attendancemreportmx")
@RequestMapping("")
public class ATTENDANCEMREPORTMXResource {

    @Autowired
    public IATTENDANCEMREPORTMXService attendancemreportmxService;

    @Autowired
    @Lazy
    public ATTENDANCEMREPORTMXMapping attendancemreportmxMapping;

    @ApiOperation(value = "获取考勤月报明细草稿", tags = {"考勤月报明细" },  notes = "获取考勤月报明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/attendancemreportmxes/getdraft")
    public ResponseEntity<ATTENDANCEMREPORTMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(attendancemreportmxMapping.toDto(attendancemreportmxService.getDraft(new ATTENDANCEMREPORTMX())));
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxService.get(#attendancemreportmx_id),'ehr-ATTENDANCEMREPORTMX-Update')")
    @ApiOperation(value = "更新考勤月报明细", tags = {"考勤月报明细" },  notes = "更新考勤月报明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendancemreportmxes/{attendancemreportmx_id}")
    @Transactional
    public ResponseEntity<ATTENDANCEMREPORTMXDTO> update(@PathVariable("attendancemreportmx_id") String attendancemreportmx_id, @RequestBody ATTENDANCEMREPORTMXDTO attendancemreportmxdto) {
		ATTENDANCEMREPORTMX domain  = attendancemreportmxMapping.toDomain(attendancemreportmxdto);
        domain .setAttendancemreportmxid(attendancemreportmx_id);
		attendancemreportmxService.update(domain );
		ATTENDANCEMREPORTMXDTO dto = attendancemreportmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxService.getAttendancemreportmxByEntities(this.attendancemreportmxMapping.toDomain(#attendancemreportmxdtos)),'ehr-ATTENDANCEMREPORTMX-Update')")
    @ApiOperation(value = "批量更新考勤月报明细", tags = {"考勤月报明细" },  notes = "批量更新考勤月报明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendancemreportmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ATTENDANCEMREPORTMXDTO> attendancemreportmxdtos) {
        attendancemreportmxService.updateBatch(attendancemreportmxMapping.toDomain(attendancemreportmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxService.get(#attendancemreportmx_id),'ehr-ATTENDANCEMREPORTMX-Remove')")
    @ApiOperation(value = "删除考勤月报明细", tags = {"考勤月报明细" },  notes = "删除考勤月报明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendancemreportmxes/{attendancemreportmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("attendancemreportmx_id") String attendancemreportmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(attendancemreportmxService.remove(attendancemreportmx_id));
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxService.getAttendancemreportmxByIds(#ids),'ehr-ATTENDANCEMREPORTMX-Remove')")
    @ApiOperation(value = "批量删除考勤月报明细", tags = {"考勤月报明细" },  notes = "批量删除考勤月报明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendancemreportmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        attendancemreportmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查考勤月报明细", tags = {"考勤月报明细" },  notes = "检查考勤月报明细")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancemreportmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ATTENDANCEMREPORTMXDTO attendancemreportmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(attendancemreportmxService.checkKey(attendancemreportmxMapping.toDomain(attendancemreportmxdto)));
    }

    @PostAuthorize("hasPermission(this.attendancemreportmxMapping.toDomain(returnObject.body),'ehr-ATTENDANCEMREPORTMX-Get')")
    @ApiOperation(value = "获取考勤月报明细", tags = {"考勤月报明细" },  notes = "获取考勤月报明细")
	@RequestMapping(method = RequestMethod.GET, value = "/attendancemreportmxes/{attendancemreportmx_id}")
    public ResponseEntity<ATTENDANCEMREPORTMXDTO> get(@PathVariable("attendancemreportmx_id") String attendancemreportmx_id) {
        ATTENDANCEMREPORTMX domain = attendancemreportmxService.get(attendancemreportmx_id);
        ATTENDANCEMREPORTMXDTO dto = attendancemreportmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxMapping.toDomain(#attendancemreportmxdto),'ehr-ATTENDANCEMREPORTMX-Save')")
    @ApiOperation(value = "保存考勤月报明细", tags = {"考勤月报明细" },  notes = "保存考勤月报明细")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancemreportmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody ATTENDANCEMREPORTMXDTO attendancemreportmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(attendancemreportmxService.save(attendancemreportmxMapping.toDomain(attendancemreportmxdto)));
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxMapping.toDomain(#attendancemreportmxdtos),'ehr-ATTENDANCEMREPORTMX-Save')")
    @ApiOperation(value = "批量保存考勤月报明细", tags = {"考勤月报明细" },  notes = "批量保存考勤月报明细")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancemreportmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ATTENDANCEMREPORTMXDTO> attendancemreportmxdtos) {
        attendancemreportmxService.saveBatch(attendancemreportmxMapping.toDomain(attendancemreportmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxMapping.toDomain(#attendancemreportmxdto),'ehr-ATTENDANCEMREPORTMX-Create')")
    @ApiOperation(value = "新建考勤月报明细", tags = {"考勤月报明细" },  notes = "新建考勤月报明细")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancemreportmxes")
    @Transactional
    public ResponseEntity<ATTENDANCEMREPORTMXDTO> create(@RequestBody ATTENDANCEMREPORTMXDTO attendancemreportmxdto) {
        ATTENDANCEMREPORTMX domain = attendancemreportmxMapping.toDomain(attendancemreportmxdto);
		attendancemreportmxService.create(domain);
        ATTENDANCEMREPORTMXDTO dto = attendancemreportmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxMapping.toDomain(#attendancemreportmxdtos),'ehr-ATTENDANCEMREPORTMX-Create')")
    @ApiOperation(value = "批量新建考勤月报明细", tags = {"考勤月报明细" },  notes = "批量新建考勤月报明细")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancemreportmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ATTENDANCEMREPORTMXDTO> attendancemreportmxdtos) {
        attendancemreportmxService.createBatch(attendancemreportmxMapping.toDomain(attendancemreportmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCEMREPORTMX-Export2Excel-all')")
    @ApiOperation(value = "导出数据到Excel", tags = {"考勤月报明细" },  notes = "导出数据到Excel")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancemreportmxes/{attendancemreportmx_id}/export2excel")
    @Transactional
    public ResponseEntity<ATTENDANCEMREPORTMXDTO> export2Excel(@PathVariable("attendancemreportmx_id") String attendancemreportmx_id, @RequestBody ATTENDANCEMREPORTMXDTO attendancemreportmxdto) {
        ATTENDANCEMREPORTMX attendancemreportmx = attendancemreportmxMapping.toDomain(attendancemreportmxdto);
        attendancemreportmx.setAttendancemreportmxid(attendancemreportmx_id);
        attendancemreportmx = attendancemreportmxService.export2Excel(attendancemreportmx);
        attendancemreportmxdto = attendancemreportmxMapping.toDto(attendancemreportmx);
        return ResponseEntity.status(HttpStatus.OK).body(attendancemreportmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCEMREPORTMX-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"考勤月报明细" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/attendancemreportmxes/fetchdefault")
	public ResponseEntity<List<ATTENDANCEMREPORTMXDTO>> fetchDefault(ATTENDANCEMREPORTMXSearchContext context) {
        Page<ATTENDANCEMREPORTMX> domains = attendancemreportmxService.searchDefault(context) ;
        List<ATTENDANCEMREPORTMXDTO> list = attendancemreportmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCEMREPORTMX-Default-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"考勤月报明细" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/attendancemreportmxes/searchdefault")
	public ResponseEntity<Page<ATTENDANCEMREPORTMXDTO>> searchDefault(@RequestBody ATTENDANCEMREPORTMXSearchContext context) {
        Page<ATTENDANCEMREPORTMX> domains = attendancemreportmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancemreportmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCEMREPORTMX-KQYBMXDY-all')")
	@ApiOperation(value = "获取考勤月报明细打印", tags = {"考勤月报明细" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/attendancemreportmxes/fetchkqybmxdy")
	public ResponseEntity<List<ATTENDANCEMREPORTMXDTO>> fetchKQYBMXDY(ATTENDANCEMREPORTMXSearchContext context) {
        Page<ATTENDANCEMREPORTMX> domains = attendancemreportmxService.searchKQYBMXDY(context) ;
        List<ATTENDANCEMREPORTMXDTO> list = attendancemreportmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCEMREPORTMX-KQYBMXDY-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"考勤月报明细" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/attendancemreportmxes/searchkqybmxdy")
	public ResponseEntity<Page<ATTENDANCEMREPORTMXDTO>> searchKQYBMXDY(@RequestBody ATTENDANCEMREPORTMXSearchContext context) {
        Page<ATTENDANCEMREPORTMX> domains = attendancemreportmxService.searchKQYBMXDY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancemreportmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCEMREPORTMX-CurPerson-all')")
	@ApiOperation(value = "获取当前员工考勤月报", tags = {"考勤月报明细" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/attendancemreportmxes/fetchcurperson")
	public ResponseEntity<List<ATTENDANCEMREPORTMXDTO>> fetchCurPerson(ATTENDANCEMREPORTMXSearchContext context) {
        Page<ATTENDANCEMREPORTMX> domains = attendancemreportmxService.searchCurPerson(context) ;
        List<ATTENDANCEMREPORTMXDTO> list = attendancemreportmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCEMREPORTMX-CurPerson-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"考勤月报明细" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/attendancemreportmxes/searchcurperson")
	public ResponseEntity<Page<ATTENDANCEMREPORTMXDTO>> searchCurPerson(@RequestBody ATTENDANCEMREPORTMXSearchContext context) {
        Page<ATTENDANCEMREPORTMX> domains = attendancemreportmxService.searchCurPerson(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancemreportmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据人员信息获取考勤月报明细草稿", tags = {"考勤月报明细" },  notes = "根据人员信息获取考勤月报明细草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/attendancemreportmxes/getdraft")
    public ResponseEntity<ATTENDANCEMREPORTMXDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        ATTENDANCEMREPORTMX domain = new ATTENDANCEMREPORTMX();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(attendancemreportmxMapping.toDto(attendancemreportmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxService.get(#attendancemreportmx_id),'ehr-ATTENDANCEMREPORTMX-Update')")
    @ApiOperation(value = "根据人员信息更新考勤月报明细", tags = {"考勤月报明细" },  notes = "根据人员信息更新考勤月报明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/attendancemreportmxes/{attendancemreportmx_id}")
    @Transactional
    public ResponseEntity<ATTENDANCEMREPORTMXDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("attendancemreportmx_id") String attendancemreportmx_id, @RequestBody ATTENDANCEMREPORTMXDTO attendancemreportmxdto) {
        ATTENDANCEMREPORTMX domain = attendancemreportmxMapping.toDomain(attendancemreportmxdto);
        domain.setPimpersonid(pimperson_id);
        domain.setAttendancemreportmxid(attendancemreportmx_id);
		attendancemreportmxService.update(domain);
        ATTENDANCEMREPORTMXDTO dto = attendancemreportmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxService.getAttendancemreportmxByEntities(this.attendancemreportmxMapping.toDomain(#attendancemreportmxdtos)),'ehr-ATTENDANCEMREPORTMX-Update')")
    @ApiOperation(value = "根据人员信息批量更新考勤月报明细", tags = {"考勤月报明细" },  notes = "根据人员信息批量更新考勤月报明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/attendancemreportmxes/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<ATTENDANCEMREPORTMXDTO> attendancemreportmxdtos) {
        List<ATTENDANCEMREPORTMX> domainlist=attendancemreportmxMapping.toDomain(attendancemreportmxdtos);
        for(ATTENDANCEMREPORTMX domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        attendancemreportmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxService.get(#attendancemreportmx_id),'ehr-ATTENDANCEMREPORTMX-Remove')")
    @ApiOperation(value = "根据人员信息删除考勤月报明细", tags = {"考勤月报明细" },  notes = "根据人员信息删除考勤月报明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/attendancemreportmxes/{attendancemreportmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("attendancemreportmx_id") String attendancemreportmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(attendancemreportmxService.remove(attendancemreportmx_id));
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxService.getAttendancemreportmxByIds(#ids),'ehr-ATTENDANCEMREPORTMX-Remove')")
    @ApiOperation(value = "根据人员信息批量删除考勤月报明细", tags = {"考勤月报明细" },  notes = "根据人员信息批量删除考勤月报明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/attendancemreportmxes/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        attendancemreportmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息检查考勤月报明细", tags = {"考勤月报明细" },  notes = "根据人员信息检查考勤月报明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/attendancemreportmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ATTENDANCEMREPORTMXDTO attendancemreportmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(attendancemreportmxService.checkKey(attendancemreportmxMapping.toDomain(attendancemreportmxdto)));
    }

    @PostAuthorize("hasPermission(this.attendancemreportmxMapping.toDomain(returnObject.body),'ehr-ATTENDANCEMREPORTMX-Get')")
    @ApiOperation(value = "根据人员信息获取考勤月报明细", tags = {"考勤月报明细" },  notes = "根据人员信息获取考勤月报明细")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/attendancemreportmxes/{attendancemreportmx_id}")
    public ResponseEntity<ATTENDANCEMREPORTMXDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("attendancemreportmx_id") String attendancemreportmx_id) {
        ATTENDANCEMREPORTMX domain = attendancemreportmxService.get(attendancemreportmx_id);
        ATTENDANCEMREPORTMXDTO dto = attendancemreportmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxMapping.toDomain(#attendancemreportmxdto),'ehr-ATTENDANCEMREPORTMX-Save')")
    @ApiOperation(value = "根据人员信息保存考勤月报明细", tags = {"考勤月报明细" },  notes = "根据人员信息保存考勤月报明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/attendancemreportmxes/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ATTENDANCEMREPORTMXDTO attendancemreportmxdto) {
        ATTENDANCEMREPORTMX domain = attendancemreportmxMapping.toDomain(attendancemreportmxdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(attendancemreportmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxMapping.toDomain(#attendancemreportmxdtos),'ehr-ATTENDANCEMREPORTMX-Save')")
    @ApiOperation(value = "根据人员信息批量保存考勤月报明细", tags = {"考勤月报明细" },  notes = "根据人员信息批量保存考勤月报明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/attendancemreportmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<ATTENDANCEMREPORTMXDTO> attendancemreportmxdtos) {
        List<ATTENDANCEMREPORTMX> domainlist=attendancemreportmxMapping.toDomain(attendancemreportmxdtos);
        for(ATTENDANCEMREPORTMX domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        attendancemreportmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxMapping.toDomain(#attendancemreportmxdto),'ehr-ATTENDANCEMREPORTMX-Create')")
    @ApiOperation(value = "根据人员信息建立考勤月报明细", tags = {"考勤月报明细" },  notes = "根据人员信息建立考勤月报明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/attendancemreportmxes")
    @Transactional
    public ResponseEntity<ATTENDANCEMREPORTMXDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ATTENDANCEMREPORTMXDTO attendancemreportmxdto) {
        ATTENDANCEMREPORTMX domain = attendancemreportmxMapping.toDomain(attendancemreportmxdto);
        domain.setPimpersonid(pimperson_id);
		attendancemreportmxService.create(domain);
        ATTENDANCEMREPORTMXDTO dto = attendancemreportmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxMapping.toDomain(#attendancemreportmxdtos),'ehr-ATTENDANCEMREPORTMX-Create')")
    @ApiOperation(value = "根据人员信息批量建立考勤月报明细", tags = {"考勤月报明细" },  notes = "根据人员信息批量建立考勤月报明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/attendancemreportmxes/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<ATTENDANCEMREPORTMXDTO> attendancemreportmxdtos) {
        List<ATTENDANCEMREPORTMX> domainlist=attendancemreportmxMapping.toDomain(attendancemreportmxdtos);
        for(ATTENDANCEMREPORTMX domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        attendancemreportmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCEMREPORTMX-Export2Excel-all')")
    @ApiOperation(value = "根据人员信息考勤月报明细", tags = {"考勤月报明细" },  notes = "根据人员信息考勤月报明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/attendancemreportmxes/{attendancemreportmx_id}/export2excel")
    @Transactional
    public ResponseEntity<ATTENDANCEMREPORTMXDTO> export2ExcelByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("attendancemreportmx_id") String attendancemreportmx_id, @RequestBody ATTENDANCEMREPORTMXDTO attendancemreportmxdto) {
        ATTENDANCEMREPORTMX domain = attendancemreportmxMapping.toDomain(attendancemreportmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = attendancemreportmxService.export2Excel(domain) ;
        attendancemreportmxdto = attendancemreportmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(attendancemreportmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCEMREPORTMX-Default-all')")
	@ApiOperation(value = "根据人员信息获取DEFAULT", tags = {"考勤月报明细" } ,notes = "根据人员信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/attendancemreportmxes/fetchdefault")
	public ResponseEntity<List<ATTENDANCEMREPORTMXDTO>> fetchATTENDANCEMREPORTMXDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,ATTENDANCEMREPORTMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<ATTENDANCEMREPORTMX> domains = attendancemreportmxService.searchDefault(context) ;
        List<ATTENDANCEMREPORTMXDTO> list = attendancemreportmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCEMREPORTMX-Default-all')")
	@ApiOperation(value = "根据人员信息查询DEFAULT", tags = {"考勤月报明细" } ,notes = "根据人员信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/attendancemreportmxes/searchdefault")
	public ResponseEntity<Page<ATTENDANCEMREPORTMXDTO>> searchATTENDANCEMREPORTMXDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ATTENDANCEMREPORTMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<ATTENDANCEMREPORTMX> domains = attendancemreportmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancemreportmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCEMREPORTMX-KQYBMXDY-all')")
	@ApiOperation(value = "根据人员信息获取考勤月报明细打印", tags = {"考勤月报明细" } ,notes = "根据人员信息获取考勤月报明细打印")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/attendancemreportmxes/fetchkqybmxdy")
	public ResponseEntity<List<ATTENDANCEMREPORTMXDTO>> fetchATTENDANCEMREPORTMXKQYBMXDYByPimPerson(@PathVariable("pimperson_id") String pimperson_id,ATTENDANCEMREPORTMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<ATTENDANCEMREPORTMX> domains = attendancemreportmxService.searchKQYBMXDY(context) ;
        List<ATTENDANCEMREPORTMXDTO> list = attendancemreportmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCEMREPORTMX-KQYBMXDY-all')")
	@ApiOperation(value = "根据人员信息查询考勤月报明细打印", tags = {"考勤月报明细" } ,notes = "根据人员信息查询考勤月报明细打印")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/attendancemreportmxes/searchkqybmxdy")
	public ResponseEntity<Page<ATTENDANCEMREPORTMXDTO>> searchATTENDANCEMREPORTMXKQYBMXDYByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ATTENDANCEMREPORTMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<ATTENDANCEMREPORTMX> domains = attendancemreportmxService.searchKQYBMXDY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancemreportmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCEMREPORTMX-CurPerson-all')")
	@ApiOperation(value = "根据人员信息获取当前员工考勤月报", tags = {"考勤月报明细" } ,notes = "根据人员信息获取当前员工考勤月报")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/attendancemreportmxes/fetchcurperson")
	public ResponseEntity<List<ATTENDANCEMREPORTMXDTO>> fetchATTENDANCEMREPORTMXCurPersonByPimPerson(@PathVariable("pimperson_id") String pimperson_id,ATTENDANCEMREPORTMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<ATTENDANCEMREPORTMX> domains = attendancemreportmxService.searchCurPerson(context) ;
        List<ATTENDANCEMREPORTMXDTO> list = attendancemreportmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCEMREPORTMX-CurPerson-all')")
	@ApiOperation(value = "根据人员信息查询当前员工考勤月报", tags = {"考勤月报明细" } ,notes = "根据人员信息查询当前员工考勤月报")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/attendancemreportmxes/searchcurperson")
	public ResponseEntity<Page<ATTENDANCEMREPORTMXDTO>> searchATTENDANCEMREPORTMXCurPersonByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ATTENDANCEMREPORTMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<ATTENDANCEMREPORTMX> domains = attendancemreportmxService.searchCurPerson(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancemreportmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

