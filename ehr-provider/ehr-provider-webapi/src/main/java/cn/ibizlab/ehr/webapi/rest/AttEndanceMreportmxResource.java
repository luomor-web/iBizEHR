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
import cn.ibizlab.ehr.core.att.domain.AttEndanceMreportmx;
import cn.ibizlab.ehr.core.att.service.IAttEndanceMreportmxService;
import cn.ibizlab.ehr.core.att.filter.AttEndanceMreportmxSearchContext;

@Slf4j
@Api(tags = {"考勤月报明细" })
@RestController("WebApi-attendancemreportmx")
@RequestMapping("")
public class AttEndanceMreportmxResource {

    @Autowired
    public IAttEndanceMreportmxService attendancemreportmxService;

    @Autowired
    @Lazy
    public AttEndanceMreportmxMapping attendancemreportmxMapping;

    @ApiOperation(value = "获取考勤月报明细草稿", tags = {"考勤月报明细" },  notes = "获取考勤月报明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/attendancemreportmxes/getdraft")
    public ResponseEntity<AttEndanceMreportmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(attendancemreportmxMapping.toDto(attendancemreportmxService.getDraft(new AttEndanceMreportmx())));
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxService.get(#attendancemreportmx_id),'ehr-AttEndanceMreportmx-Update')")
    @ApiOperation(value = "更新考勤月报明细", tags = {"考勤月报明细" },  notes = "更新考勤月报明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendancemreportmxes/{attendancemreportmx_id}")
    @Transactional
    public ResponseEntity<AttEndanceMreportmxDTO> update(@PathVariable("attendancemreportmx_id") String attendancemreportmx_id, @RequestBody AttEndanceMreportmxDTO attendancemreportmxdto) {
		AttEndanceMreportmx domain  = attendancemreportmxMapping.toDomain(attendancemreportmxdto);
        domain .setAttendancemreportmxid(attendancemreportmx_id);
		attendancemreportmxService.update(domain );
		AttEndanceMreportmxDTO dto = attendancemreportmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxService.getAttendancemreportmxByEntities(this.attendancemreportmxMapping.toDomain(#attendancemreportmxdtos)),'ehr-AttEndanceMreportmx-Update')")
    @ApiOperation(value = "批量更新考勤月报明细", tags = {"考勤月报明细" },  notes = "批量更新考勤月报明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendancemreportmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<AttEndanceMreportmxDTO> attendancemreportmxdtos) {
        attendancemreportmxService.updateBatch(attendancemreportmxMapping.toDomain(attendancemreportmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxService.get(#attendancemreportmx_id),'ehr-AttEndanceMreportmx-Remove')")
    @ApiOperation(value = "删除考勤月报明细", tags = {"考勤月报明细" },  notes = "删除考勤月报明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendancemreportmxes/{attendancemreportmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("attendancemreportmx_id") String attendancemreportmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(attendancemreportmxService.remove(attendancemreportmx_id));
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxService.getAttendancemreportmxByIds(#ids),'ehr-AttEndanceMreportmx-Remove')")
    @ApiOperation(value = "批量删除考勤月报明细", tags = {"考勤月报明细" },  notes = "批量删除考勤月报明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendancemreportmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        attendancemreportmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查考勤月报明细", tags = {"考勤月报明细" },  notes = "检查考勤月报明细")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancemreportmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody AttEndanceMreportmxDTO attendancemreportmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(attendancemreportmxService.checkKey(attendancemreportmxMapping.toDomain(attendancemreportmxdto)));
    }

    @PostAuthorize("hasPermission(this.attendancemreportmxMapping.toDomain(returnObject.body),'ehr-AttEndanceMreportmx-Get')")
    @ApiOperation(value = "获取考勤月报明细", tags = {"考勤月报明细" },  notes = "获取考勤月报明细")
	@RequestMapping(method = RequestMethod.GET, value = "/attendancemreportmxes/{attendancemreportmx_id}")
    public ResponseEntity<AttEndanceMreportmxDTO> get(@PathVariable("attendancemreportmx_id") String attendancemreportmx_id) {
        AttEndanceMreportmx domain = attendancemreportmxService.get(attendancemreportmx_id);
        AttEndanceMreportmxDTO dto = attendancemreportmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxMapping.toDomain(#attendancemreportmxdto),'ehr-AttEndanceMreportmx-Save')")
    @ApiOperation(value = "保存考勤月报明细", tags = {"考勤月报明细" },  notes = "保存考勤月报明细")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancemreportmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody AttEndanceMreportmxDTO attendancemreportmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(attendancemreportmxService.save(attendancemreportmxMapping.toDomain(attendancemreportmxdto)));
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxMapping.toDomain(#attendancemreportmxdtos),'ehr-AttEndanceMreportmx-Save')")
    @ApiOperation(value = "批量保存考勤月报明细", tags = {"考勤月报明细" },  notes = "批量保存考勤月报明细")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancemreportmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<AttEndanceMreportmxDTO> attendancemreportmxdtos) {
        attendancemreportmxService.saveBatch(attendancemreportmxMapping.toDomain(attendancemreportmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxMapping.toDomain(#attendancemreportmxdto),'ehr-AttEndanceMreportmx-Create')")
    @ApiOperation(value = "新建考勤月报明细", tags = {"考勤月报明细" },  notes = "新建考勤月报明细")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancemreportmxes")
    @Transactional
    public ResponseEntity<AttEndanceMreportmxDTO> create(@RequestBody AttEndanceMreportmxDTO attendancemreportmxdto) {
        AttEndanceMreportmx domain = attendancemreportmxMapping.toDomain(attendancemreportmxdto);
		attendancemreportmxService.create(domain);
        AttEndanceMreportmxDTO dto = attendancemreportmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxMapping.toDomain(#attendancemreportmxdtos),'ehr-AttEndanceMreportmx-Create')")
    @ApiOperation(value = "批量新建考勤月报明细", tags = {"考勤月报明细" },  notes = "批量新建考勤月报明细")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancemreportmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<AttEndanceMreportmxDTO> attendancemreportmxdtos) {
        attendancemreportmxService.createBatch(attendancemreportmxMapping.toDomain(attendancemreportmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceMreportmx-Export2Excel-all')")
    @ApiOperation(value = "导出数据到Excel", tags = {"考勤月报明细" },  notes = "导出数据到Excel")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancemreportmxes/{attendancemreportmx_id}/export2excel")
    @Transactional
    public ResponseEntity<AttEndanceMreportmxDTO> export2Excel(@PathVariable("attendancemreportmx_id") String attendancemreportmx_id, @RequestBody AttEndanceMreportmxDTO attendancemreportmxdto) {
        AttEndanceMreportmx attendancemreportmx = attendancemreportmxMapping.toDomain(attendancemreportmxdto);
        attendancemreportmx.setAttendancemreportmxid(attendancemreportmx_id);
        attendancemreportmx = attendancemreportmxService.export2Excel(attendancemreportmx);
        attendancemreportmxdto = attendancemreportmxMapping.toDto(attendancemreportmx);
        return ResponseEntity.status(HttpStatus.OK).body(attendancemreportmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceMreportmx-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"考勤月报明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/attendancemreportmxes/fetchdefault")
	public ResponseEntity<List<AttEndanceMreportmxDTO>> fetchDefault(AttEndanceMreportmxSearchContext context) {
        Page<AttEndanceMreportmx> domains = attendancemreportmxService.searchDefault(context) ;
        List<AttEndanceMreportmxDTO> list = attendancemreportmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceMreportmx-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"考勤月报明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/attendancemreportmxes/searchdefault")
	public ResponseEntity<Page<AttEndanceMreportmxDTO>> searchDefault(@RequestBody AttEndanceMreportmxSearchContext context) {
        Page<AttEndanceMreportmx> domains = attendancemreportmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancemreportmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceMreportmx-KQYBMXDY-all')")
	@ApiOperation(value = "获取考勤月报明细打印", tags = {"考勤月报明细" } ,notes = "获取考勤月报明细打印")
    @RequestMapping(method= RequestMethod.GET , value="/attendancemreportmxes/fetchkqybmxdy")
	public ResponseEntity<List<AttEndanceMreportmxDTO>> fetchKQYBMXDY(AttEndanceMreportmxSearchContext context) {
        Page<AttEndanceMreportmx> domains = attendancemreportmxService.searchKQYBMXDY(context) ;
        List<AttEndanceMreportmxDTO> list = attendancemreportmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceMreportmx-KQYBMXDY-all')")
	@ApiOperation(value = "查询考勤月报明细打印", tags = {"考勤月报明细" } ,notes = "查询考勤月报明细打印")
    @RequestMapping(method= RequestMethod.POST , value="/attendancemreportmxes/searchkqybmxdy")
	public ResponseEntity<Page<AttEndanceMreportmxDTO>> searchKQYBMXDY(@RequestBody AttEndanceMreportmxSearchContext context) {
        Page<AttEndanceMreportmx> domains = attendancemreportmxService.searchKQYBMXDY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancemreportmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceMreportmx-CurPerson-all')")
	@ApiOperation(value = "获取当前员工考勤月报", tags = {"考勤月报明细" } ,notes = "获取当前员工考勤月报")
    @RequestMapping(method= RequestMethod.GET , value="/attendancemreportmxes/fetchcurperson")
	public ResponseEntity<List<AttEndanceMreportmxDTO>> fetchCurPerson(AttEndanceMreportmxSearchContext context) {
        Page<AttEndanceMreportmx> domains = attendancemreportmxService.searchCurPerson(context) ;
        List<AttEndanceMreportmxDTO> list = attendancemreportmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceMreportmx-CurPerson-all')")
	@ApiOperation(value = "查询当前员工考勤月报", tags = {"考勤月报明细" } ,notes = "查询当前员工考勤月报")
    @RequestMapping(method= RequestMethod.POST , value="/attendancemreportmxes/searchcurperson")
	public ResponseEntity<Page<AttEndanceMreportmxDTO>> searchCurPerson(@RequestBody AttEndanceMreportmxSearchContext context) {
        Page<AttEndanceMreportmx> domains = attendancemreportmxService.searchCurPerson(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancemreportmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据考勤月报获取考勤月报明细草稿", tags = {"考勤月报明细" },  notes = "根据考勤月报获取考勤月报明细草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/attendancemreports/{attendancemreport_id}/attendancemreportmxes/getdraft")
    public ResponseEntity<AttEndanceMreportmxDTO> getDraftByAttEndanceMreport(@PathVariable("attendancemreport_id") String attendancemreport_id) {
        AttEndanceMreportmx domain = new AttEndanceMreportmx();
        domain.setAttendancemreportid2(attendancemreport_id);
        return ResponseEntity.status(HttpStatus.OK).body(attendancemreportmxMapping.toDto(attendancemreportmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxService.get(#attendancemreportmx_id),'ehr-AttEndanceMreportmx-Update')")
    @ApiOperation(value = "根据考勤月报更新考勤月报明细", tags = {"考勤月报明细" },  notes = "根据考勤月报更新考勤月报明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendancemreports/{attendancemreport_id}/attendancemreportmxes/{attendancemreportmx_id}")
    @Transactional
    public ResponseEntity<AttEndanceMreportmxDTO> updateByAttEndanceMreport(@PathVariable("attendancemreport_id") String attendancemreport_id, @PathVariable("attendancemreportmx_id") String attendancemreportmx_id, @RequestBody AttEndanceMreportmxDTO attendancemreportmxdto) {
        AttEndanceMreportmx domain = attendancemreportmxMapping.toDomain(attendancemreportmxdto);
        domain.setAttendancemreportid2(attendancemreport_id);
        domain.setAttendancemreportmxid(attendancemreportmx_id);
		attendancemreportmxService.update(domain);
        AttEndanceMreportmxDTO dto = attendancemreportmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxService.getAttendancemreportmxByEntities(this.attendancemreportmxMapping.toDomain(#attendancemreportmxdtos)),'ehr-AttEndanceMreportmx-Update')")
    @ApiOperation(value = "根据考勤月报批量更新考勤月报明细", tags = {"考勤月报明细" },  notes = "根据考勤月报批量更新考勤月报明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendancemreports/{attendancemreport_id}/attendancemreportmxes/batch")
    public ResponseEntity<Boolean> updateBatchByAttEndanceMreport(@PathVariable("attendancemreport_id") String attendancemreport_id, @RequestBody List<AttEndanceMreportmxDTO> attendancemreportmxdtos) {
        List<AttEndanceMreportmx> domainlist=attendancemreportmxMapping.toDomain(attendancemreportmxdtos);
        for(AttEndanceMreportmx domain:domainlist){
            domain.setAttendancemreportid2(attendancemreport_id);
        }
        attendancemreportmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxService.get(#attendancemreportmx_id),'ehr-AttEndanceMreportmx-Remove')")
    @ApiOperation(value = "根据考勤月报删除考勤月报明细", tags = {"考勤月报明细" },  notes = "根据考勤月报删除考勤月报明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendancemreports/{attendancemreport_id}/attendancemreportmxes/{attendancemreportmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByAttEndanceMreport(@PathVariable("attendancemreport_id") String attendancemreport_id, @PathVariable("attendancemreportmx_id") String attendancemreportmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(attendancemreportmxService.remove(attendancemreportmx_id));
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxService.getAttendancemreportmxByIds(#ids),'ehr-AttEndanceMreportmx-Remove')")
    @ApiOperation(value = "根据考勤月报批量删除考勤月报明细", tags = {"考勤月报明细" },  notes = "根据考勤月报批量删除考勤月报明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendancemreports/{attendancemreport_id}/attendancemreportmxes/batch")
    public ResponseEntity<Boolean> removeBatchByAttEndanceMreport(@RequestBody List<String> ids) {
        attendancemreportmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据考勤月报检查考勤月报明细", tags = {"考勤月报明细" },  notes = "根据考勤月报检查考勤月报明细")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancemreports/{attendancemreport_id}/attendancemreportmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByAttEndanceMreport(@PathVariable("attendancemreport_id") String attendancemreport_id, @RequestBody AttEndanceMreportmxDTO attendancemreportmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(attendancemreportmxService.checkKey(attendancemreportmxMapping.toDomain(attendancemreportmxdto)));
    }

    @PostAuthorize("hasPermission(this.attendancemreportmxMapping.toDomain(returnObject.body),'ehr-AttEndanceMreportmx-Get')")
    @ApiOperation(value = "根据考勤月报获取考勤月报明细", tags = {"考勤月报明细" },  notes = "根据考勤月报获取考勤月报明细")
	@RequestMapping(method = RequestMethod.GET, value = "/attendancemreports/{attendancemreport_id}/attendancemreportmxes/{attendancemreportmx_id}")
    public ResponseEntity<AttEndanceMreportmxDTO> getByAttEndanceMreport(@PathVariable("attendancemreport_id") String attendancemreport_id, @PathVariable("attendancemreportmx_id") String attendancemreportmx_id) {
        AttEndanceMreportmx domain = attendancemreportmxService.get(attendancemreportmx_id);
        AttEndanceMreportmxDTO dto = attendancemreportmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxMapping.toDomain(#attendancemreportmxdto),'ehr-AttEndanceMreportmx-Save')")
    @ApiOperation(value = "根据考勤月报保存考勤月报明细", tags = {"考勤月报明细" },  notes = "根据考勤月报保存考勤月报明细")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancemreports/{attendancemreport_id}/attendancemreportmxes/save")
    public ResponseEntity<Boolean> saveByAttEndanceMreport(@PathVariable("attendancemreport_id") String attendancemreport_id, @RequestBody AttEndanceMreportmxDTO attendancemreportmxdto) {
        AttEndanceMreportmx domain = attendancemreportmxMapping.toDomain(attendancemreportmxdto);
        domain.setAttendancemreportid2(attendancemreport_id);
        return ResponseEntity.status(HttpStatus.OK).body(attendancemreportmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxMapping.toDomain(#attendancemreportmxdtos),'ehr-AttEndanceMreportmx-Save')")
    @ApiOperation(value = "根据考勤月报批量保存考勤月报明细", tags = {"考勤月报明细" },  notes = "根据考勤月报批量保存考勤月报明细")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancemreports/{attendancemreport_id}/attendancemreportmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByAttEndanceMreport(@PathVariable("attendancemreport_id") String attendancemreport_id, @RequestBody List<AttEndanceMreportmxDTO> attendancemreportmxdtos) {
        List<AttEndanceMreportmx> domainlist=attendancemreportmxMapping.toDomain(attendancemreportmxdtos);
        for(AttEndanceMreportmx domain:domainlist){
             domain.setAttendancemreportid2(attendancemreport_id);
        }
        attendancemreportmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxMapping.toDomain(#attendancemreportmxdto),'ehr-AttEndanceMreportmx-Create')")
    @ApiOperation(value = "根据考勤月报建立考勤月报明细", tags = {"考勤月报明细" },  notes = "根据考勤月报建立考勤月报明细")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancemreports/{attendancemreport_id}/attendancemreportmxes")
    @Transactional
    public ResponseEntity<AttEndanceMreportmxDTO> createByAttEndanceMreport(@PathVariable("attendancemreport_id") String attendancemreport_id, @RequestBody AttEndanceMreportmxDTO attendancemreportmxdto) {
        AttEndanceMreportmx domain = attendancemreportmxMapping.toDomain(attendancemreportmxdto);
        domain.setAttendancemreportid2(attendancemreport_id);
		attendancemreportmxService.create(domain);
        AttEndanceMreportmxDTO dto = attendancemreportmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxMapping.toDomain(#attendancemreportmxdtos),'ehr-AttEndanceMreportmx-Create')")
    @ApiOperation(value = "根据考勤月报批量建立考勤月报明细", tags = {"考勤月报明细" },  notes = "根据考勤月报批量建立考勤月报明细")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancemreports/{attendancemreport_id}/attendancemreportmxes/batch")
    public ResponseEntity<Boolean> createBatchByAttEndanceMreport(@PathVariable("attendancemreport_id") String attendancemreport_id, @RequestBody List<AttEndanceMreportmxDTO> attendancemreportmxdtos) {
        List<AttEndanceMreportmx> domainlist=attendancemreportmxMapping.toDomain(attendancemreportmxdtos);
        for(AttEndanceMreportmx domain:domainlist){
            domain.setAttendancemreportid2(attendancemreport_id);
        }
        attendancemreportmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceMreportmx-Export2Excel-all')")
    @ApiOperation(value = "根据考勤月报考勤月报明细", tags = {"考勤月报明细" },  notes = "根据考勤月报考勤月报明细")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancemreports/{attendancemreport_id}/attendancemreportmxes/{attendancemreportmx_id}/export2excel")
    @Transactional
    public ResponseEntity<AttEndanceMreportmxDTO> export2ExcelByAttEndanceMreport(@PathVariable("attendancemreport_id") String attendancemreport_id, @PathVariable("attendancemreportmx_id") String attendancemreportmx_id, @RequestBody AttEndanceMreportmxDTO attendancemreportmxdto) {
        AttEndanceMreportmx domain = attendancemreportmxMapping.toDomain(attendancemreportmxdto);
        domain.setAttendancemreportid2(attendancemreport_id);
        domain = attendancemreportmxService.export2Excel(domain) ;
        attendancemreportmxdto = attendancemreportmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(attendancemreportmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceMreportmx-Default-all')")
	@ApiOperation(value = "根据考勤月报获取DEFAULT", tags = {"考勤月报明细" } ,notes = "根据考勤月报获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/attendancemreports/{attendancemreport_id}/attendancemreportmxes/fetchdefault")
	public ResponseEntity<List<AttEndanceMreportmxDTO>> fetchAttEndanceMreportmxDefaultByAttEndanceMreport(@PathVariable("attendancemreport_id") String attendancemreport_id,AttEndanceMreportmxSearchContext context) {
        context.setN_attendancemreportid2_eq(attendancemreport_id);
        Page<AttEndanceMreportmx> domains = attendancemreportmxService.searchDefault(context) ;
        List<AttEndanceMreportmxDTO> list = attendancemreportmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceMreportmx-Default-all')")
	@ApiOperation(value = "根据考勤月报查询DEFAULT", tags = {"考勤月报明细" } ,notes = "根据考勤月报查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/attendancemreports/{attendancemreport_id}/attendancemreportmxes/searchdefault")
	public ResponseEntity<Page<AttEndanceMreportmxDTO>> searchAttEndanceMreportmxDefaultByAttEndanceMreport(@PathVariable("attendancemreport_id") String attendancemreport_id, @RequestBody AttEndanceMreportmxSearchContext context) {
        context.setN_attendancemreportid2_eq(attendancemreport_id);
        Page<AttEndanceMreportmx> domains = attendancemreportmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancemreportmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceMreportmx-KQYBMXDY-all')")
	@ApiOperation(value = "根据考勤月报获取考勤月报明细打印", tags = {"考勤月报明细" } ,notes = "根据考勤月报获取考勤月报明细打印")
    @RequestMapping(method= RequestMethod.GET , value="/attendancemreports/{attendancemreport_id}/attendancemreportmxes/fetchkqybmxdy")
	public ResponseEntity<List<AttEndanceMreportmxDTO>> fetchAttEndanceMreportmxKQYBMXDYByAttEndanceMreport(@PathVariable("attendancemreport_id") String attendancemreport_id,AttEndanceMreportmxSearchContext context) {
        context.setN_attendancemreportid2_eq(attendancemreport_id);
        Page<AttEndanceMreportmx> domains = attendancemreportmxService.searchKQYBMXDY(context) ;
        List<AttEndanceMreportmxDTO> list = attendancemreportmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceMreportmx-KQYBMXDY-all')")
	@ApiOperation(value = "根据考勤月报查询考勤月报明细打印", tags = {"考勤月报明细" } ,notes = "根据考勤月报查询考勤月报明细打印")
    @RequestMapping(method= RequestMethod.POST , value="/attendancemreports/{attendancemreport_id}/attendancemreportmxes/searchkqybmxdy")
	public ResponseEntity<Page<AttEndanceMreportmxDTO>> searchAttEndanceMreportmxKQYBMXDYByAttEndanceMreport(@PathVariable("attendancemreport_id") String attendancemreport_id, @RequestBody AttEndanceMreportmxSearchContext context) {
        context.setN_attendancemreportid2_eq(attendancemreport_id);
        Page<AttEndanceMreportmx> domains = attendancemreportmxService.searchKQYBMXDY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancemreportmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceMreportmx-CurPerson-all')")
	@ApiOperation(value = "根据考勤月报获取当前员工考勤月报", tags = {"考勤月报明细" } ,notes = "根据考勤月报获取当前员工考勤月报")
    @RequestMapping(method= RequestMethod.GET , value="/attendancemreports/{attendancemreport_id}/attendancemreportmxes/fetchcurperson")
	public ResponseEntity<List<AttEndanceMreportmxDTO>> fetchAttEndanceMreportmxCurPersonByAttEndanceMreport(@PathVariable("attendancemreport_id") String attendancemreport_id,AttEndanceMreportmxSearchContext context) {
        context.setN_attendancemreportid2_eq(attendancemreport_id);
        Page<AttEndanceMreportmx> domains = attendancemreportmxService.searchCurPerson(context) ;
        List<AttEndanceMreportmxDTO> list = attendancemreportmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceMreportmx-CurPerson-all')")
	@ApiOperation(value = "根据考勤月报查询当前员工考勤月报", tags = {"考勤月报明细" } ,notes = "根据考勤月报查询当前员工考勤月报")
    @RequestMapping(method= RequestMethod.POST , value="/attendancemreports/{attendancemreport_id}/attendancemreportmxes/searchcurperson")
	public ResponseEntity<Page<AttEndanceMreportmxDTO>> searchAttEndanceMreportmxCurPersonByAttEndanceMreport(@PathVariable("attendancemreport_id") String attendancemreport_id, @RequestBody AttEndanceMreportmxSearchContext context) {
        context.setN_attendancemreportid2_eq(attendancemreport_id);
        Page<AttEndanceMreportmx> domains = attendancemreportmxService.searchCurPerson(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancemreportmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据人员信息获取考勤月报明细草稿", tags = {"考勤月报明细" },  notes = "根据人员信息获取考勤月报明细草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/attendancemreportmxes/getdraft")
    public ResponseEntity<AttEndanceMreportmxDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        AttEndanceMreportmx domain = new AttEndanceMreportmx();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(attendancemreportmxMapping.toDto(attendancemreportmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxService.get(#attendancemreportmx_id),'ehr-AttEndanceMreportmx-Update')")
    @ApiOperation(value = "根据人员信息更新考勤月报明细", tags = {"考勤月报明细" },  notes = "根据人员信息更新考勤月报明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/attendancemreportmxes/{attendancemreportmx_id}")
    @Transactional
    public ResponseEntity<AttEndanceMreportmxDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("attendancemreportmx_id") String attendancemreportmx_id, @RequestBody AttEndanceMreportmxDTO attendancemreportmxdto) {
        AttEndanceMreportmx domain = attendancemreportmxMapping.toDomain(attendancemreportmxdto);
        domain.setPimpersonid(pimperson_id);
        domain.setAttendancemreportmxid(attendancemreportmx_id);
		attendancemreportmxService.update(domain);
        AttEndanceMreportmxDTO dto = attendancemreportmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxService.getAttendancemreportmxByEntities(this.attendancemreportmxMapping.toDomain(#attendancemreportmxdtos)),'ehr-AttEndanceMreportmx-Update')")
    @ApiOperation(value = "根据人员信息批量更新考勤月报明细", tags = {"考勤月报明细" },  notes = "根据人员信息批量更新考勤月报明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/attendancemreportmxes/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<AttEndanceMreportmxDTO> attendancemreportmxdtos) {
        List<AttEndanceMreportmx> domainlist=attendancemreportmxMapping.toDomain(attendancemreportmxdtos);
        for(AttEndanceMreportmx domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        attendancemreportmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxService.get(#attendancemreportmx_id),'ehr-AttEndanceMreportmx-Remove')")
    @ApiOperation(value = "根据人员信息删除考勤月报明细", tags = {"考勤月报明细" },  notes = "根据人员信息删除考勤月报明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/attendancemreportmxes/{attendancemreportmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("attendancemreportmx_id") String attendancemreportmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(attendancemreportmxService.remove(attendancemreportmx_id));
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxService.getAttendancemreportmxByIds(#ids),'ehr-AttEndanceMreportmx-Remove')")
    @ApiOperation(value = "根据人员信息批量删除考勤月报明细", tags = {"考勤月报明细" },  notes = "根据人员信息批量删除考勤月报明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/attendancemreportmxes/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        attendancemreportmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息检查考勤月报明细", tags = {"考勤月报明细" },  notes = "根据人员信息检查考勤月报明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/attendancemreportmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody AttEndanceMreportmxDTO attendancemreportmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(attendancemreportmxService.checkKey(attendancemreportmxMapping.toDomain(attendancemreportmxdto)));
    }

    @PostAuthorize("hasPermission(this.attendancemreportmxMapping.toDomain(returnObject.body),'ehr-AttEndanceMreportmx-Get')")
    @ApiOperation(value = "根据人员信息获取考勤月报明细", tags = {"考勤月报明细" },  notes = "根据人员信息获取考勤月报明细")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/attendancemreportmxes/{attendancemreportmx_id}")
    public ResponseEntity<AttEndanceMreportmxDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("attendancemreportmx_id") String attendancemreportmx_id) {
        AttEndanceMreportmx domain = attendancemreportmxService.get(attendancemreportmx_id);
        AttEndanceMreportmxDTO dto = attendancemreportmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxMapping.toDomain(#attendancemreportmxdto),'ehr-AttEndanceMreportmx-Save')")
    @ApiOperation(value = "根据人员信息保存考勤月报明细", tags = {"考勤月报明细" },  notes = "根据人员信息保存考勤月报明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/attendancemreportmxes/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody AttEndanceMreportmxDTO attendancemreportmxdto) {
        AttEndanceMreportmx domain = attendancemreportmxMapping.toDomain(attendancemreportmxdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(attendancemreportmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxMapping.toDomain(#attendancemreportmxdtos),'ehr-AttEndanceMreportmx-Save')")
    @ApiOperation(value = "根据人员信息批量保存考勤月报明细", tags = {"考勤月报明细" },  notes = "根据人员信息批量保存考勤月报明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/attendancemreportmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<AttEndanceMreportmxDTO> attendancemreportmxdtos) {
        List<AttEndanceMreportmx> domainlist=attendancemreportmxMapping.toDomain(attendancemreportmxdtos);
        for(AttEndanceMreportmx domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        attendancemreportmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxMapping.toDomain(#attendancemreportmxdto),'ehr-AttEndanceMreportmx-Create')")
    @ApiOperation(value = "根据人员信息建立考勤月报明细", tags = {"考勤月报明细" },  notes = "根据人员信息建立考勤月报明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/attendancemreportmxes")
    @Transactional
    public ResponseEntity<AttEndanceMreportmxDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody AttEndanceMreportmxDTO attendancemreportmxdto) {
        AttEndanceMreportmx domain = attendancemreportmxMapping.toDomain(attendancemreportmxdto);
        domain.setPimpersonid(pimperson_id);
		attendancemreportmxService.create(domain);
        AttEndanceMreportmxDTO dto = attendancemreportmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancemreportmxMapping.toDomain(#attendancemreportmxdtos),'ehr-AttEndanceMreportmx-Create')")
    @ApiOperation(value = "根据人员信息批量建立考勤月报明细", tags = {"考勤月报明细" },  notes = "根据人员信息批量建立考勤月报明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/attendancemreportmxes/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<AttEndanceMreportmxDTO> attendancemreportmxdtos) {
        List<AttEndanceMreportmx> domainlist=attendancemreportmxMapping.toDomain(attendancemreportmxdtos);
        for(AttEndanceMreportmx domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        attendancemreportmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceMreportmx-Export2Excel-all')")
    @ApiOperation(value = "根据人员信息考勤月报明细", tags = {"考勤月报明细" },  notes = "根据人员信息考勤月报明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/attendancemreportmxes/{attendancemreportmx_id}/export2excel")
    @Transactional
    public ResponseEntity<AttEndanceMreportmxDTO> export2ExcelByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("attendancemreportmx_id") String attendancemreportmx_id, @RequestBody AttEndanceMreportmxDTO attendancemreportmxdto) {
        AttEndanceMreportmx domain = attendancemreportmxMapping.toDomain(attendancemreportmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = attendancemreportmxService.export2Excel(domain) ;
        attendancemreportmxdto = attendancemreportmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(attendancemreportmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceMreportmx-Default-all')")
	@ApiOperation(value = "根据人员信息获取DEFAULT", tags = {"考勤月报明细" } ,notes = "根据人员信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/attendancemreportmxes/fetchdefault")
	public ResponseEntity<List<AttEndanceMreportmxDTO>> fetchAttEndanceMreportmxDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,AttEndanceMreportmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<AttEndanceMreportmx> domains = attendancemreportmxService.searchDefault(context) ;
        List<AttEndanceMreportmxDTO> list = attendancemreportmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceMreportmx-Default-all')")
	@ApiOperation(value = "根据人员信息查询DEFAULT", tags = {"考勤月报明细" } ,notes = "根据人员信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/attendancemreportmxes/searchdefault")
	public ResponseEntity<Page<AttEndanceMreportmxDTO>> searchAttEndanceMreportmxDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody AttEndanceMreportmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<AttEndanceMreportmx> domains = attendancemreportmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancemreportmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceMreportmx-KQYBMXDY-all')")
	@ApiOperation(value = "根据人员信息获取考勤月报明细打印", tags = {"考勤月报明细" } ,notes = "根据人员信息获取考勤月报明细打印")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/attendancemreportmxes/fetchkqybmxdy")
	public ResponseEntity<List<AttEndanceMreportmxDTO>> fetchAttEndanceMreportmxKQYBMXDYByPimPerson(@PathVariable("pimperson_id") String pimperson_id,AttEndanceMreportmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<AttEndanceMreportmx> domains = attendancemreportmxService.searchKQYBMXDY(context) ;
        List<AttEndanceMreportmxDTO> list = attendancemreportmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceMreportmx-KQYBMXDY-all')")
	@ApiOperation(value = "根据人员信息查询考勤月报明细打印", tags = {"考勤月报明细" } ,notes = "根据人员信息查询考勤月报明细打印")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/attendancemreportmxes/searchkqybmxdy")
	public ResponseEntity<Page<AttEndanceMreportmxDTO>> searchAttEndanceMreportmxKQYBMXDYByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody AttEndanceMreportmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<AttEndanceMreportmx> domains = attendancemreportmxService.searchKQYBMXDY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancemreportmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceMreportmx-CurPerson-all')")
	@ApiOperation(value = "根据人员信息获取当前员工考勤月报", tags = {"考勤月报明细" } ,notes = "根据人员信息获取当前员工考勤月报")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/attendancemreportmxes/fetchcurperson")
	public ResponseEntity<List<AttEndanceMreportmxDTO>> fetchAttEndanceMreportmxCurPersonByPimPerson(@PathVariable("pimperson_id") String pimperson_id,AttEndanceMreportmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<AttEndanceMreportmx> domains = attendancemreportmxService.searchCurPerson(context) ;
        List<AttEndanceMreportmxDTO> list = attendancemreportmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceMreportmx-CurPerson-all')")
	@ApiOperation(value = "根据人员信息查询当前员工考勤月报", tags = {"考勤月报明细" } ,notes = "根据人员信息查询当前员工考勤月报")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/attendancemreportmxes/searchcurperson")
	public ResponseEntity<Page<AttEndanceMreportmxDTO>> searchAttEndanceMreportmxCurPersonByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody AttEndanceMreportmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<AttEndanceMreportmx> domains = attendancemreportmxService.searchCurPerson(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancemreportmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

