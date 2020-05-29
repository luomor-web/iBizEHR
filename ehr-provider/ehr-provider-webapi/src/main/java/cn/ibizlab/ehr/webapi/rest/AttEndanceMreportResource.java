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
import cn.ibizlab.ehr.core.att.domain.AttEndanceMreport;
import cn.ibizlab.ehr.core.att.service.IAttEndanceMreportService;
import cn.ibizlab.ehr.core.att.filter.AttEndanceMreportSearchContext;

@Slf4j
@Api(tags = {"考勤月报" })
@RestController("WebApi-attendancemreport")
@RequestMapping("")
public class AttEndanceMreportResource {

    @Autowired
    public IAttEndanceMreportService attendancemreportService;

    @Autowired
    @Lazy
    public AttEndanceMreportMapping attendancemreportMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceMreport-GetAttendencemanOfKQSZ-all')")
    @ApiOperation(value = "获取考勤表的考勤员", tags = {"考勤月报" },  notes = "获取考勤表的考勤员")
	@RequestMapping(method = RequestMethod.GET, value = "/attendancemreports/{attendancemreport_id}/getattendencemanofkqsz")
    @Transactional
    public ResponseEntity<AttEndanceMreportDTO> getAttendencemanOfKQSZ(@PathVariable("attendancemreport_id") String attendancemreport_id, @RequestBody AttEndanceMreportDTO attendancemreportdto) {
        AttEndanceMreport attendancemreport = attendancemreportMapping.toDomain(attendancemreportdto);
        attendancemreport.setAttendancemreportid(attendancemreport_id);
        attendancemreport = attendancemreportService.getAttendencemanOfKQSZ(attendancemreport);
        attendancemreportdto = attendancemreportMapping.toDto(attendancemreport);
        return ResponseEntity.status(HttpStatus.OK).body(attendancemreportdto);
    }

    @PreAuthorize("hasPermission(this.attendancemreportMapping.toDomain(#attendancemreportdto),'ehr-AttEndanceMreport-Save')")
    @ApiOperation(value = "保存考勤月报", tags = {"考勤月报" },  notes = "保存考勤月报")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancemreports/save")
    public ResponseEntity<Boolean> save(@RequestBody AttEndanceMreportDTO attendancemreportdto) {
        return ResponseEntity.status(HttpStatus.OK).body(attendancemreportService.save(attendancemreportMapping.toDomain(attendancemreportdto)));
    }

    @PreAuthorize("hasPermission(this.attendancemreportMapping.toDomain(#attendancemreportdtos),'ehr-AttEndanceMreport-Save')")
    @ApiOperation(value = "批量保存考勤月报", tags = {"考勤月报" },  notes = "批量保存考勤月报")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancemreports/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<AttEndanceMreportDTO> attendancemreportdtos) {
        attendancemreportService.saveBatch(attendancemreportMapping.toDomain(attendancemreportdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendancemreportService.get(#attendancemreport_id),'ehr-AttEndanceMreport-Remove')")
    @ApiOperation(value = "删除考勤月报", tags = {"考勤月报" },  notes = "删除考勤月报")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendancemreports/{attendancemreport_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("attendancemreport_id") String attendancemreport_id) {
         return ResponseEntity.status(HttpStatus.OK).body(attendancemreportService.remove(attendancemreport_id));
    }

    @PreAuthorize("hasPermission(this.attendancemreportService.getAttendancemreportByIds(#ids),'ehr-AttEndanceMreport-Remove')")
    @ApiOperation(value = "批量删除考勤月报", tags = {"考勤月报" },  notes = "批量删除考勤月报")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendancemreports/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        attendancemreportService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceMreport-ExportKQYB-all')")
    @ApiOperation(value = "导出月报", tags = {"考勤月报" },  notes = "导出月报")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancemreports/{attendancemreport_id}/exportkqyb")
    @Transactional
    public ResponseEntity<AttEndanceMreportDTO> exportKQYB(@PathVariable("attendancemreport_id") String attendancemreport_id, @RequestBody AttEndanceMreportDTO attendancemreportdto) {
        AttEndanceMreport attendancemreport = attendancemreportMapping.toDomain(attendancemreportdto);
        attendancemreport.setAttendancemreportid(attendancemreport_id);
        attendancemreport = attendancemreportService.exportKQYB(attendancemreport);
        attendancemreportdto = attendancemreportMapping.toDto(attendancemreport);
        return ResponseEntity.status(HttpStatus.OK).body(attendancemreportdto);
    }

    @PreAuthorize("hasPermission(this.attendancemreportMapping.toDomain(#attendancemreportdto),'ehr-AttEndanceMreport-Create')")
    @ApiOperation(value = "新建考勤月报", tags = {"考勤月报" },  notes = "新建考勤月报")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancemreports")
    @Transactional
    public ResponseEntity<AttEndanceMreportDTO> create(@RequestBody AttEndanceMreportDTO attendancemreportdto) {
        AttEndanceMreport domain = attendancemreportMapping.toDomain(attendancemreportdto);
		attendancemreportService.create(domain);
        AttEndanceMreportDTO dto = attendancemreportMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancemreportMapping.toDomain(#attendancemreportdtos),'ehr-AttEndanceMreport-Create')")
    @ApiOperation(value = "批量新建考勤月报", tags = {"考勤月报" },  notes = "批量新建考勤月报")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancemreports/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<AttEndanceMreportDTO> attendancemreportdtos) {
        attendancemreportService.createBatch(attendancemreportMapping.toDomain(attendancemreportdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceMreport-SCKQYB-all')")
    @ApiOperation(value = "生成月报", tags = {"考勤月报" },  notes = "生成月报")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancemreports/{attendancemreport_id}/sckqyb")
    @Transactional
    public ResponseEntity<AttEndanceMreportDTO> sCKQYB(@PathVariable("attendancemreport_id") String attendancemreport_id, @RequestBody AttEndanceMreportDTO attendancemreportdto) {
        AttEndanceMreport attendancemreport = attendancemreportMapping.toDomain(attendancemreportdto);
        attendancemreport.setAttendancemreportid(attendancemreport_id);
        attendancemreport = attendancemreportService.sCKQYB(attendancemreport);
        attendancemreportdto = attendancemreportMapping.toDto(attendancemreport);
        return ResponseEntity.status(HttpStatus.OK).body(attendancemreportdto);
    }

    @PostAuthorize("hasPermission(this.attendancemreportMapping.toDomain(returnObject.body),'ehr-AttEndanceMreport-Get')")
    @ApiOperation(value = "获取考勤月报", tags = {"考勤月报" },  notes = "获取考勤月报")
	@RequestMapping(method = RequestMethod.GET, value = "/attendancemreports/{attendancemreport_id}")
    public ResponseEntity<AttEndanceMreportDTO> get(@PathVariable("attendancemreport_id") String attendancemreport_id) {
        AttEndanceMreport domain = attendancemreportService.get(attendancemreport_id);
        AttEndanceMreportDTO dto = attendancemreportMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "检查考勤月报", tags = {"考勤月报" },  notes = "检查考勤月报")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancemreports/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody AttEndanceMreportDTO attendancemreportdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(attendancemreportService.checkKey(attendancemreportMapping.toDomain(attendancemreportdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceMreport-QR-all')")
    @ApiOperation(value = "确认月报", tags = {"考勤月报" },  notes = "确认月报")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancemreports/{attendancemreport_id}/qr")
    @Transactional
    public ResponseEntity<AttEndanceMreportDTO> qR(@PathVariable("attendancemreport_id") String attendancemreport_id, @RequestBody AttEndanceMreportDTO attendancemreportdto) {
        AttEndanceMreport attendancemreport = attendancemreportMapping.toDomain(attendancemreportdto);
        attendancemreport.setAttendancemreportid(attendancemreport_id);
        attendancemreport = attendancemreportService.qR(attendancemreport);
        attendancemreportdto = attendancemreportMapping.toDto(attendancemreport);
        return ResponseEntity.status(HttpStatus.OK).body(attendancemreportdto);
    }

    @PreAuthorize("hasPermission(this.attendancemreportService.get(#attendancemreport_id),'ehr-AttEndanceMreport-Update')")
    @ApiOperation(value = "更新考勤月报", tags = {"考勤月报" },  notes = "更新考勤月报")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendancemreports/{attendancemreport_id}")
    @Transactional
    public ResponseEntity<AttEndanceMreportDTO> update(@PathVariable("attendancemreport_id") String attendancemreport_id, @RequestBody AttEndanceMreportDTO attendancemreportdto) {
		AttEndanceMreport domain  = attendancemreportMapping.toDomain(attendancemreportdto);
        domain .setAttendancemreportid(attendancemreport_id);
		attendancemreportService.update(domain );
		AttEndanceMreportDTO dto = attendancemreportMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancemreportService.getAttendancemreportByEntities(this.attendancemreportMapping.toDomain(#attendancemreportdtos)),'ehr-AttEndanceMreport-Update')")
    @ApiOperation(value = "批量更新考勤月报", tags = {"考勤月报" },  notes = "批量更新考勤月报")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendancemreports/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<AttEndanceMreportDTO> attendancemreportdtos) {
        attendancemreportService.updateBatch(attendancemreportMapping.toDomain(attendancemreportdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取考勤月报草稿", tags = {"考勤月报" },  notes = "获取考勤月报草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/attendancemreports/getdraft")
    public ResponseEntity<AttEndanceMreportDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(attendancemreportMapping.toDto(attendancemreportService.getDraft(new AttEndanceMreport())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceMreport-KQYBDY-all')")
	@ApiOperation(value = "获取考勤月报打印", tags = {"考勤月报" } ,notes = "获取考勤月报打印")
    @RequestMapping(method= RequestMethod.GET , value="/attendancemreports/fetchkqybdy")
	public ResponseEntity<List<AttEndanceMreportDTO>> fetchKQYBDY(AttEndanceMreportSearchContext context) {
        Page<AttEndanceMreport> domains = attendancemreportService.searchKQYBDY(context) ;
        List<AttEndanceMreportDTO> list = attendancemreportMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceMreport-KQYBDY-all')")
	@ApiOperation(value = "查询考勤月报打印", tags = {"考勤月报" } ,notes = "查询考勤月报打印")
    @RequestMapping(method= RequestMethod.POST , value="/attendancemreports/searchkqybdy")
	public ResponseEntity<Page<AttEndanceMreportDTO>> searchKQYBDY(@RequestBody AttEndanceMreportSearchContext context) {
        Page<AttEndanceMreport> domains = attendancemreportService.searchKQYBDY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancemreportMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceMreport-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"考勤月报" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/attendancemreports/fetchdefault")
	public ResponseEntity<List<AttEndanceMreportDTO>> fetchDefault(AttEndanceMreportSearchContext context) {
        Page<AttEndanceMreport> domains = attendancemreportService.searchDefault(context) ;
        List<AttEndanceMreportDTO> list = attendancemreportMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceMreport-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"考勤月报" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/attendancemreports/searchdefault")
	public ResponseEntity<Page<AttEndanceMreportDTO>> searchDefault(@RequestBody AttEndanceMreportSearchContext context) {
        Page<AttEndanceMreport> domains = attendancemreportService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancemreportMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceMreport-KQYCZKQYB-all')")
	@ApiOperation(value = "获取考勤员操作考勤月报", tags = {"考勤月报" } ,notes = "获取考勤员操作考勤月报")
    @RequestMapping(method= RequestMethod.GET , value="/attendancemreports/fetchkqyczkqyb")
	public ResponseEntity<List<AttEndanceMreportDTO>> fetchKQYCZKQYB(AttEndanceMreportSearchContext context) {
        Page<AttEndanceMreport> domains = attendancemreportService.searchKQYCZKQYB(context) ;
        List<AttEndanceMreportDTO> list = attendancemreportMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceMreport-KQYCZKQYB-all')")
	@ApiOperation(value = "查询考勤员操作考勤月报", tags = {"考勤月报" } ,notes = "查询考勤员操作考勤月报")
    @RequestMapping(method= RequestMethod.POST , value="/attendancemreports/searchkqyczkqyb")
	public ResponseEntity<Page<AttEndanceMreportDTO>> searchKQYCZKQYB(@RequestBody AttEndanceMreportSearchContext context) {
        Page<AttEndanceMreport> domains = attendancemreportService.searchKQYCZKQYB(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancemreportMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceMreport-CurORMORGKQYB-all')")
	@ApiOperation(value = "获取当前组织考勤月报", tags = {"考勤月报" } ,notes = "获取当前组织考勤月报")
    @RequestMapping(method= RequestMethod.GET , value="/attendancemreports/fetchcurormorgkqyb")
	public ResponseEntity<List<AttEndanceMreportDTO>> fetchCurORMORGKQYB(AttEndanceMreportSearchContext context) {
        Page<AttEndanceMreport> domains = attendancemreportService.searchCurORMORGKQYB(context) ;
        List<AttEndanceMreportDTO> list = attendancemreportMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceMreport-CurORMORGKQYB-all')")
	@ApiOperation(value = "查询当前组织考勤月报", tags = {"考勤月报" } ,notes = "查询当前组织考勤月报")
    @RequestMapping(method= RequestMethod.POST , value="/attendancemreports/searchcurormorgkqyb")
	public ResponseEntity<Page<AttEndanceMreportDTO>> searchCurORMORGKQYB(@RequestBody AttEndanceMreportSearchContext context) {
        Page<AttEndanceMreport> domains = attendancemreportService.searchCurORMORGKQYB(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancemreportMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceMreport-CurORMORGSECTORKQYB-all')")
	@ApiOperation(value = "获取当前组织下部门考勤月报", tags = {"考勤月报" } ,notes = "获取当前组织下部门考勤月报")
    @RequestMapping(method= RequestMethod.GET , value="/attendancemreports/fetchcurormorgsectorkqyb")
	public ResponseEntity<List<AttEndanceMreportDTO>> fetchCurORMORGSECTORKQYB(AttEndanceMreportSearchContext context) {
        Page<AttEndanceMreport> domains = attendancemreportService.searchCurORMORGSECTORKQYB(context) ;
        List<AttEndanceMreportDTO> list = attendancemreportMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceMreport-CurORMORGSECTORKQYB-all')")
	@ApiOperation(value = "查询当前组织下部门考勤月报", tags = {"考勤月报" } ,notes = "查询当前组织下部门考勤月报")
    @RequestMapping(method= RequestMethod.POST , value="/attendancemreports/searchcurormorgsectorkqyb")
	public ResponseEntity<Page<AttEndanceMreportDTO>> searchCurORMORGSECTORKQYB(@RequestBody AttEndanceMreportSearchContext context) {
        Page<AttEndanceMreport> domains = attendancemreportService.searchCurORMORGSECTORKQYB(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancemreportMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

