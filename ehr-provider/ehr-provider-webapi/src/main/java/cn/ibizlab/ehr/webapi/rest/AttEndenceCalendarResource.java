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
import cn.ibizlab.ehr.core.att.domain.AttEndenceCalendar;
import cn.ibizlab.ehr.core.att.service.IAttEndenceCalendarService;
import cn.ibizlab.ehr.core.att.filter.AttEndenceCalendarSearchContext;

@Slf4j
@Api(tags = {"考勤日历" })
@RestController("WebApi-attendencecalendar")
@RequestMapping("")
public class AttEndenceCalendarResource {

    @Autowired
    public IAttEndenceCalendarService attendencecalendarService;

    @Autowired
    @Lazy
    public AttEndenceCalendarMapping attendencecalendarMapping;

    @PreAuthorize("hasPermission(this.attendencecalendarMapping.toDomain(#attendencecalendardto),'ehr-AttEndenceCalendar-Create')")
    @ApiOperation(value = "新建考勤日历", tags = {"考勤日历" },  notes = "新建考勤日历")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencecalendars")
    @Transactional
    public ResponseEntity<AttEndenceCalendarDTO> create(@RequestBody AttEndenceCalendarDTO attendencecalendardto) {
        AttEndenceCalendar domain = attendencecalendarMapping.toDomain(attendencecalendardto);
		attendencecalendarService.create(domain);
        AttEndenceCalendarDTO dto = attendencecalendarMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendencecalendarMapping.toDomain(#attendencecalendardtos),'ehr-AttEndenceCalendar-Create')")
    @ApiOperation(value = "批量新建考勤日历", tags = {"考勤日历" },  notes = "批量新建考勤日历")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencecalendars/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<AttEndenceCalendarDTO> attendencecalendardtos) {
        attendencecalendarService.createBatch(attendencecalendarMapping.toDomain(attendencecalendardtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendencecalendarMapping.toDomain(#attendencecalendardto),'ehr-AttEndenceCalendar-Save')")
    @ApiOperation(value = "保存考勤日历", tags = {"考勤日历" },  notes = "保存考勤日历")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencecalendars/save")
    public ResponseEntity<Boolean> save(@RequestBody AttEndenceCalendarDTO attendencecalendardto) {
        return ResponseEntity.status(HttpStatus.OK).body(attendencecalendarService.save(attendencecalendarMapping.toDomain(attendencecalendardto)));
    }

    @PreAuthorize("hasPermission(this.attendencecalendarMapping.toDomain(#attendencecalendardtos),'ehr-AttEndenceCalendar-Save')")
    @ApiOperation(value = "批量保存考勤日历", tags = {"考勤日历" },  notes = "批量保存考勤日历")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencecalendars/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<AttEndenceCalendarDTO> attendencecalendardtos) {
        attendencecalendarService.saveBatch(attendencecalendarMapping.toDomain(attendencecalendardtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendencecalendarService.get(#attendencecalendar_id),'ehr-AttEndenceCalendar-Update')")
    @ApiOperation(value = "更新考勤日历", tags = {"考勤日历" },  notes = "更新考勤日历")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendencecalendars/{attendencecalendar_id}")
    @Transactional
    public ResponseEntity<AttEndenceCalendarDTO> update(@PathVariable("attendencecalendar_id") String attendencecalendar_id, @RequestBody AttEndenceCalendarDTO attendencecalendardto) {
		AttEndenceCalendar domain  = attendencecalendarMapping.toDomain(attendencecalendardto);
        domain .setAttendencecalendarid(attendencecalendar_id);
		attendencecalendarService.update(domain );
		AttEndenceCalendarDTO dto = attendencecalendarMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendencecalendarService.getAttendencecalendarByEntities(this.attendencecalendarMapping.toDomain(#attendencecalendardtos)),'ehr-AttEndenceCalendar-Update')")
    @ApiOperation(value = "批量更新考勤日历", tags = {"考勤日历" },  notes = "批量更新考勤日历")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendencecalendars/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<AttEndenceCalendarDTO> attendencecalendardtos) {
        attendencecalendarService.updateBatch(attendencecalendarMapping.toDomain(attendencecalendardtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查考勤日历", tags = {"考勤日历" },  notes = "检查考勤日历")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencecalendars/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody AttEndenceCalendarDTO attendencecalendardto) {
        return  ResponseEntity.status(HttpStatus.OK).body(attendencecalendarService.checkKey(attendencecalendarMapping.toDomain(attendencecalendardto)));
    }

    @PostAuthorize("hasPermission(this.attendencecalendarMapping.toDomain(returnObject.body),'ehr-AttEndenceCalendar-Get')")
    @ApiOperation(value = "获取考勤日历", tags = {"考勤日历" },  notes = "获取考勤日历")
	@RequestMapping(method = RequestMethod.GET, value = "/attendencecalendars/{attendencecalendar_id}")
    public ResponseEntity<AttEndenceCalendarDTO> get(@PathVariable("attendencecalendar_id") String attendencecalendar_id) {
        AttEndenceCalendar domain = attendencecalendarService.get(attendencecalendar_id);
        AttEndenceCalendarDTO dto = attendencecalendarMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendencecalendarService.get(#attendencecalendar_id),'ehr-AttEndenceCalendar-Remove')")
    @ApiOperation(value = "删除考勤日历", tags = {"考勤日历" },  notes = "删除考勤日历")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendencecalendars/{attendencecalendar_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("attendencecalendar_id") String attendencecalendar_id) {
         return ResponseEntity.status(HttpStatus.OK).body(attendencecalendarService.remove(attendencecalendar_id));
    }

    @PreAuthorize("hasPermission(this.attendencecalendarService.getAttendencecalendarByIds(#ids),'ehr-AttEndenceCalendar-Remove')")
    @ApiOperation(value = "批量删除考勤日历", tags = {"考勤日历" },  notes = "批量删除考勤日历")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendencecalendars/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        attendencecalendarService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取考勤日历草稿", tags = {"考勤日历" },  notes = "获取考勤日历草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/attendencecalendars/getdraft")
    public ResponseEntity<AttEndenceCalendarDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(attendencecalendarMapping.toDto(attendencecalendarService.getDraft(new AttEndenceCalendar())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndenceCalendar-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"考勤日历" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/attendencecalendars/fetchdefault")
	public ResponseEntity<List<AttEndenceCalendarDTO>> fetchDefault(AttEndenceCalendarSearchContext context) {
        Page<AttEndenceCalendar> domains = attendencecalendarService.searchDefault(context) ;
        List<AttEndenceCalendarDTO> list = attendencecalendarMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndenceCalendar-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"考勤日历" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/attendencecalendars/searchdefault")
	public ResponseEntity<Page<AttEndenceCalendarDTO>> searchDefault(@RequestBody AttEndenceCalendarSearchContext context) {
        Page<AttEndenceCalendar> domains = attendencecalendarService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendencecalendarMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

