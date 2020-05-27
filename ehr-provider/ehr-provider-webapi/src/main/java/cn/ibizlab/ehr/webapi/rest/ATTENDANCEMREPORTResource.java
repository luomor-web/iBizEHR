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
import cn.ibizlab.ehr.core.att.domain.ATTENDANCEMREPORT;
import cn.ibizlab.ehr.core.att.service.IATTENDANCEMREPORTService;
import cn.ibizlab.ehr.core.att.filter.ATTENDANCEMREPORTSearchContext;

@Slf4j
@Api(tags = {"ATTENDANCEMREPORT" })
@RestController("WebApi-attendancemreport")
@RequestMapping("")
public class ATTENDANCEMREPORTResource {

    @Autowired
    public IATTENDANCEMREPORTService attendancemreportService;

    @Autowired
    @Lazy
    public ATTENDANCEMREPORTMapping attendancemreportMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCEMREPORT-GetAttendencemanOfKQSZ-all')")
    @ApiOperation(value = "获取考勤表的考勤员", tags = {"ATTENDANCEMREPORT" },  notes = "获取考勤表的考勤员")
	@RequestMapping(method = RequestMethod.GET, value = "/attendancemreports/{attendancemreport_id}/getattendencemanofkqsz")
    @Transactional
    public ResponseEntity<ATTENDANCEMREPORTDTO> getAttendencemanOfKQSZ(@PathVariable("attendancemreport_id") String attendancemreport_id, @RequestBody ATTENDANCEMREPORTDTO attendancemreportdto) {
        ATTENDANCEMREPORT attendancemreport = attendancemreportMapping.toDomain(attendancemreportdto);
        attendancemreport.setAttendancemreportid(attendancemreport_id);
        attendancemreport = attendancemreportService.getAttendencemanOfKQSZ(attendancemreport);
        attendancemreportdto = attendancemreportMapping.toDto(attendancemreport);
        return ResponseEntity.status(HttpStatus.OK).body(attendancemreportdto);
    }

    @PreAuthorize("hasPermission(this.attendancemreportMapping.toDomain(#attendancemreportdto),'ehr-ATTENDANCEMREPORT-Save')")
    @ApiOperation(value = "Save", tags = {"ATTENDANCEMREPORT" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancemreports/save")
    public ResponseEntity<Boolean> save(@RequestBody ATTENDANCEMREPORTDTO attendancemreportdto) {
        return ResponseEntity.status(HttpStatus.OK).body(attendancemreportService.save(attendancemreportMapping.toDomain(attendancemreportdto)));
    }

    @PreAuthorize("hasPermission(this.attendancemreportMapping.toDomain(#attendancemreportdtos),'ehr-ATTENDANCEMREPORT-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"ATTENDANCEMREPORT" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancemreports/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ATTENDANCEMREPORTDTO> attendancemreportdtos) {
        attendancemreportService.saveBatch(attendancemreportMapping.toDomain(attendancemreportdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendancemreportService.get(#attendancemreport_id),'ehr-ATTENDANCEMREPORT-Remove')")
    @ApiOperation(value = "Remove", tags = {"ATTENDANCEMREPORT" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendancemreports/{attendancemreport_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("attendancemreport_id") String attendancemreport_id) {
         return ResponseEntity.status(HttpStatus.OK).body(attendancemreportService.remove(attendancemreport_id));
    }

    @PreAuthorize("hasPermission(this.attendancemreportService.getAttendancemreportByIds(#ids),'ehr-ATTENDANCEMREPORT-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"ATTENDANCEMREPORT" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendancemreports/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        attendancemreportService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCEMREPORT-ExportKQYB-all')")
    @ApiOperation(value = "导出月报", tags = {"ATTENDANCEMREPORT" },  notes = "导出月报")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancemreports/{attendancemreport_id}/exportkqyb")
    @Transactional
    public ResponseEntity<ATTENDANCEMREPORTDTO> exportKQYB(@PathVariable("attendancemreport_id") String attendancemreport_id, @RequestBody ATTENDANCEMREPORTDTO attendancemreportdto) {
        ATTENDANCEMREPORT attendancemreport = attendancemreportMapping.toDomain(attendancemreportdto);
        attendancemreport.setAttendancemreportid(attendancemreport_id);
        attendancemreport = attendancemreportService.exportKQYB(attendancemreport);
        attendancemreportdto = attendancemreportMapping.toDto(attendancemreport);
        return ResponseEntity.status(HttpStatus.OK).body(attendancemreportdto);
    }

    @PreAuthorize("hasPermission(this.attendancemreportMapping.toDomain(#attendancemreportdto),'ehr-ATTENDANCEMREPORT-Create')")
    @ApiOperation(value = "Create", tags = {"ATTENDANCEMREPORT" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancemreports")
    @Transactional
    public ResponseEntity<ATTENDANCEMREPORTDTO> create(@RequestBody ATTENDANCEMREPORTDTO attendancemreportdto) {
        ATTENDANCEMREPORT domain = attendancemreportMapping.toDomain(attendancemreportdto);
		attendancemreportService.create(domain);
        ATTENDANCEMREPORTDTO dto = attendancemreportMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancemreportMapping.toDomain(#attendancemreportdtos),'ehr-ATTENDANCEMREPORT-Create')")
    @ApiOperation(value = "createBatch", tags = {"ATTENDANCEMREPORT" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancemreports/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ATTENDANCEMREPORTDTO> attendancemreportdtos) {
        attendancemreportService.createBatch(attendancemreportMapping.toDomain(attendancemreportdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCEMREPORT-SCKQYB-all')")
    @ApiOperation(value = "生成月报", tags = {"ATTENDANCEMREPORT" },  notes = "生成月报")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancemreports/{attendancemreport_id}/sckqyb")
    @Transactional
    public ResponseEntity<ATTENDANCEMREPORTDTO> sCKQYB(@PathVariable("attendancemreport_id") String attendancemreport_id, @RequestBody ATTENDANCEMREPORTDTO attendancemreportdto) {
        ATTENDANCEMREPORT attendancemreport = attendancemreportMapping.toDomain(attendancemreportdto);
        attendancemreport.setAttendancemreportid(attendancemreport_id);
        attendancemreport = attendancemreportService.sCKQYB(attendancemreport);
        attendancemreportdto = attendancemreportMapping.toDto(attendancemreport);
        return ResponseEntity.status(HttpStatus.OK).body(attendancemreportdto);
    }

    @PostAuthorize("hasPermission(this.attendancemreportMapping.toDomain(returnObject.body),'ehr-ATTENDANCEMREPORT-Get')")
    @ApiOperation(value = "Get", tags = {"ATTENDANCEMREPORT" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/attendancemreports/{attendancemreport_id}")
    public ResponseEntity<ATTENDANCEMREPORTDTO> get(@PathVariable("attendancemreport_id") String attendancemreport_id) {
        ATTENDANCEMREPORT domain = attendancemreportService.get(attendancemreport_id);
        ATTENDANCEMREPORTDTO dto = attendancemreportMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKey", tags = {"ATTENDANCEMREPORT" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancemreports/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ATTENDANCEMREPORTDTO attendancemreportdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(attendancemreportService.checkKey(attendancemreportMapping.toDomain(attendancemreportdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCEMREPORT-QR-all')")
    @ApiOperation(value = "确认月报", tags = {"ATTENDANCEMREPORT" },  notes = "确认月报")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancemreports/{attendancemreport_id}/qr")
    @Transactional
    public ResponseEntity<ATTENDANCEMREPORTDTO> qR(@PathVariable("attendancemreport_id") String attendancemreport_id, @RequestBody ATTENDANCEMREPORTDTO attendancemreportdto) {
        ATTENDANCEMREPORT attendancemreport = attendancemreportMapping.toDomain(attendancemreportdto);
        attendancemreport.setAttendancemreportid(attendancemreport_id);
        attendancemreport = attendancemreportService.qR(attendancemreport);
        attendancemreportdto = attendancemreportMapping.toDto(attendancemreport);
        return ResponseEntity.status(HttpStatus.OK).body(attendancemreportdto);
    }

    @PreAuthorize("hasPermission(this.attendancemreportService.get(#attendancemreport_id),'ehr-ATTENDANCEMREPORT-Update')")
    @ApiOperation(value = "Update", tags = {"ATTENDANCEMREPORT" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendancemreports/{attendancemreport_id}")
    @Transactional
    public ResponseEntity<ATTENDANCEMREPORTDTO> update(@PathVariable("attendancemreport_id") String attendancemreport_id, @RequestBody ATTENDANCEMREPORTDTO attendancemreportdto) {
		ATTENDANCEMREPORT domain  = attendancemreportMapping.toDomain(attendancemreportdto);
        domain .setAttendancemreportid(attendancemreport_id);
		attendancemreportService.update(domain );
		ATTENDANCEMREPORTDTO dto = attendancemreportMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancemreportService.getAttendancemreportByEntities(this.attendancemreportMapping.toDomain(#attendancemreportdtos)),'ehr-ATTENDANCEMREPORT-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"ATTENDANCEMREPORT" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendancemreports/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ATTENDANCEMREPORTDTO> attendancemreportdtos) {
        attendancemreportService.updateBatch(attendancemreportMapping.toDomain(attendancemreportdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"ATTENDANCEMREPORT" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/attendancemreports/getdraft")
    public ResponseEntity<ATTENDANCEMREPORTDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(attendancemreportMapping.toDto(attendancemreportService.getDraft(new ATTENDANCEMREPORT())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCEMREPORT-KQYBDY-all')")
	@ApiOperation(value = "fetch考勤月报打印", tags = {"ATTENDANCEMREPORT" } ,notes = "fetch考勤月报打印")
    @RequestMapping(method= RequestMethod.GET , value="/attendancemreports/fetchkqybdy")
	public ResponseEntity<List<ATTENDANCEMREPORTDTO>> fetchKQYBDY(ATTENDANCEMREPORTSearchContext context) {
        Page<ATTENDANCEMREPORT> domains = attendancemreportService.searchKQYBDY(context) ;
        List<ATTENDANCEMREPORTDTO> list = attendancemreportMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCEMREPORT-KQYBDY-all')")
	@ApiOperation(value = "search考勤月报打印", tags = {"ATTENDANCEMREPORT" } ,notes = "search考勤月报打印")
    @RequestMapping(method= RequestMethod.POST , value="/attendancemreports/searchkqybdy")
	public ResponseEntity<Page<ATTENDANCEMREPORTDTO>> searchKQYBDY(@RequestBody ATTENDANCEMREPORTSearchContext context) {
        Page<ATTENDANCEMREPORT> domains = attendancemreportService.searchKQYBDY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancemreportMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCEMREPORT-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ATTENDANCEMREPORT" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/attendancemreports/fetchdefault")
	public ResponseEntity<List<ATTENDANCEMREPORTDTO>> fetchDefault(ATTENDANCEMREPORTSearchContext context) {
        Page<ATTENDANCEMREPORT> domains = attendancemreportService.searchDefault(context) ;
        List<ATTENDANCEMREPORTDTO> list = attendancemreportMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCEMREPORT-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ATTENDANCEMREPORT" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/attendancemreports/searchdefault")
	public ResponseEntity<Page<ATTENDANCEMREPORTDTO>> searchDefault(@RequestBody ATTENDANCEMREPORTSearchContext context) {
        Page<ATTENDANCEMREPORT> domains = attendancemreportService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancemreportMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCEMREPORT-KQYCZKQYB-all')")
	@ApiOperation(value = "fetch考勤员操作考勤月报", tags = {"ATTENDANCEMREPORT" } ,notes = "fetch考勤员操作考勤月报")
    @RequestMapping(method= RequestMethod.GET , value="/attendancemreports/fetchkqyczkqyb")
	public ResponseEntity<List<ATTENDANCEMREPORTDTO>> fetchKQYCZKQYB(ATTENDANCEMREPORTSearchContext context) {
        Page<ATTENDANCEMREPORT> domains = attendancemreportService.searchKQYCZKQYB(context) ;
        List<ATTENDANCEMREPORTDTO> list = attendancemreportMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCEMREPORT-KQYCZKQYB-all')")
	@ApiOperation(value = "search考勤员操作考勤月报", tags = {"ATTENDANCEMREPORT" } ,notes = "search考勤员操作考勤月报")
    @RequestMapping(method= RequestMethod.POST , value="/attendancemreports/searchkqyczkqyb")
	public ResponseEntity<Page<ATTENDANCEMREPORTDTO>> searchKQYCZKQYB(@RequestBody ATTENDANCEMREPORTSearchContext context) {
        Page<ATTENDANCEMREPORT> domains = attendancemreportService.searchKQYCZKQYB(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancemreportMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCEMREPORT-CurORMORGKQYB-all')")
	@ApiOperation(value = "fetch当前组织考勤月报", tags = {"ATTENDANCEMREPORT" } ,notes = "fetch当前组织考勤月报")
    @RequestMapping(method= RequestMethod.GET , value="/attendancemreports/fetchcurormorgkqyb")
	public ResponseEntity<List<ATTENDANCEMREPORTDTO>> fetchCurORMORGKQYB(ATTENDANCEMREPORTSearchContext context) {
        Page<ATTENDANCEMREPORT> domains = attendancemreportService.searchCurORMORGKQYB(context) ;
        List<ATTENDANCEMREPORTDTO> list = attendancemreportMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCEMREPORT-CurORMORGKQYB-all')")
	@ApiOperation(value = "search当前组织考勤月报", tags = {"ATTENDANCEMREPORT" } ,notes = "search当前组织考勤月报")
    @RequestMapping(method= RequestMethod.POST , value="/attendancemreports/searchcurormorgkqyb")
	public ResponseEntity<Page<ATTENDANCEMREPORTDTO>> searchCurORMORGKQYB(@RequestBody ATTENDANCEMREPORTSearchContext context) {
        Page<ATTENDANCEMREPORT> domains = attendancemreportService.searchCurORMORGKQYB(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancemreportMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCEMREPORT-CurORMORGSECTORKQYB-all')")
	@ApiOperation(value = "fetch当前组织下部门考勤月报", tags = {"ATTENDANCEMREPORT" } ,notes = "fetch当前组织下部门考勤月报")
    @RequestMapping(method= RequestMethod.GET , value="/attendancemreports/fetchcurormorgsectorkqyb")
	public ResponseEntity<List<ATTENDANCEMREPORTDTO>> fetchCurORMORGSECTORKQYB(ATTENDANCEMREPORTSearchContext context) {
        Page<ATTENDANCEMREPORT> domains = attendancemreportService.searchCurORMORGSECTORKQYB(context) ;
        List<ATTENDANCEMREPORTDTO> list = attendancemreportMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCEMREPORT-CurORMORGSECTORKQYB-all')")
	@ApiOperation(value = "search当前组织下部门考勤月报", tags = {"ATTENDANCEMREPORT" } ,notes = "search当前组织下部门考勤月报")
    @RequestMapping(method= RequestMethod.POST , value="/attendancemreports/searchcurormorgsectorkqyb")
	public ResponseEntity<Page<ATTENDANCEMREPORTDTO>> searchCurORMORGSECTORKQYB(@RequestBody ATTENDANCEMREPORTSearchContext context) {
        Page<ATTENDANCEMREPORT> domains = attendancemreportService.searchCurORMORGSECTORKQYB(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancemreportMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

