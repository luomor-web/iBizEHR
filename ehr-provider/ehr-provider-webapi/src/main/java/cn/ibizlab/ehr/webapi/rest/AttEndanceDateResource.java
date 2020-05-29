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
import cn.ibizlab.ehr.core.att.domain.AttEndanceDate;
import cn.ibizlab.ehr.core.att.service.IAttEndanceDateService;
import cn.ibizlab.ehr.core.att.filter.AttEndanceDateSearchContext;

@Slf4j
@Api(tags = {"考勤日期" })
@RestController("WebApi-attendancedate")
@RequestMapping("")
public class AttEndanceDateResource {

    @Autowired
    public IAttEndanceDateService attendancedateService;

    @Autowired
    @Lazy
    public AttEndanceDateMapping attendancedateMapping;

    @PostAuthorize("hasPermission(this.attendancedateMapping.toDomain(returnObject.body),'ehr-AttEndanceDate-Get')")
    @ApiOperation(value = "获取考勤日期", tags = {"考勤日期" },  notes = "获取考勤日期")
	@RequestMapping(method = RequestMethod.GET, value = "/attendancedates/{attendancedate_id}")
    public ResponseEntity<AttEndanceDateDTO> get(@PathVariable("attendancedate_id") String attendancedate_id) {
        AttEndanceDate domain = attendancedateService.get(attendancedate_id);
        AttEndanceDateDTO dto = attendancedateMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancedateService.get(#attendancedate_id),'ehr-AttEndanceDate-Remove')")
    @ApiOperation(value = "删除考勤日期", tags = {"考勤日期" },  notes = "删除考勤日期")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendancedates/{attendancedate_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("attendancedate_id") String attendancedate_id) {
         return ResponseEntity.status(HttpStatus.OK).body(attendancedateService.remove(attendancedate_id));
    }

    @PreAuthorize("hasPermission(this.attendancedateService.getAttendancedateByIds(#ids),'ehr-AttEndanceDate-Remove')")
    @ApiOperation(value = "批量删除考勤日期", tags = {"考勤日期" },  notes = "批量删除考勤日期")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendancedates/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        attendancedateService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendancedateMapping.toDomain(#attendancedatedto),'ehr-AttEndanceDate-Create')")
    @ApiOperation(value = "新建考勤日期", tags = {"考勤日期" },  notes = "新建考勤日期")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancedates")
    @Transactional
    public ResponseEntity<AttEndanceDateDTO> create(@RequestBody AttEndanceDateDTO attendancedatedto) {
        AttEndanceDate domain = attendancedateMapping.toDomain(attendancedatedto);
		attendancedateService.create(domain);
        AttEndanceDateDTO dto = attendancedateMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancedateMapping.toDomain(#attendancedatedtos),'ehr-AttEndanceDate-Create')")
    @ApiOperation(value = "批量新建考勤日期", tags = {"考勤日期" },  notes = "批量新建考勤日期")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancedates/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<AttEndanceDateDTO> attendancedatedtos) {
        attendancedateService.createBatch(attendancedateMapping.toDomain(attendancedatedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取考勤日期草稿", tags = {"考勤日期" },  notes = "获取考勤日期草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/attendancedates/getdraft")
    public ResponseEntity<AttEndanceDateDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(attendancedateMapping.toDto(attendancedateService.getDraft(new AttEndanceDate())));
    }

    @PreAuthorize("hasPermission(this.attendancedateMapping.toDomain(#attendancedatedto),'ehr-AttEndanceDate-Save')")
    @ApiOperation(value = "保存考勤日期", tags = {"考勤日期" },  notes = "保存考勤日期")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancedates/save")
    public ResponseEntity<Boolean> save(@RequestBody AttEndanceDateDTO attendancedatedto) {
        return ResponseEntity.status(HttpStatus.OK).body(attendancedateService.save(attendancedateMapping.toDomain(attendancedatedto)));
    }

    @PreAuthorize("hasPermission(this.attendancedateMapping.toDomain(#attendancedatedtos),'ehr-AttEndanceDate-Save')")
    @ApiOperation(value = "批量保存考勤日期", tags = {"考勤日期" },  notes = "批量保存考勤日期")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancedates/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<AttEndanceDateDTO> attendancedatedtos) {
        attendancedateService.saveBatch(attendancedateMapping.toDomain(attendancedatedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendancedateService.get(#attendancedate_id),'ehr-AttEndanceDate-Update')")
    @ApiOperation(value = "更新考勤日期", tags = {"考勤日期" },  notes = "更新考勤日期")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendancedates/{attendancedate_id}")
    @Transactional
    public ResponseEntity<AttEndanceDateDTO> update(@PathVariable("attendancedate_id") String attendancedate_id, @RequestBody AttEndanceDateDTO attendancedatedto) {
		AttEndanceDate domain  = attendancedateMapping.toDomain(attendancedatedto);
        domain .setAttendancedateid(attendancedate_id);
		attendancedateService.update(domain );
		AttEndanceDateDTO dto = attendancedateMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancedateService.getAttendancedateByEntities(this.attendancedateMapping.toDomain(#attendancedatedtos)),'ehr-AttEndanceDate-Update')")
    @ApiOperation(value = "批量更新考勤日期", tags = {"考勤日期" },  notes = "批量更新考勤日期")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendancedates/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<AttEndanceDateDTO> attendancedatedtos) {
        attendancedateService.updateBatch(attendancedateMapping.toDomain(attendancedatedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查考勤日期", tags = {"考勤日期" },  notes = "检查考勤日期")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancedates/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody AttEndanceDateDTO attendancedatedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(attendancedateService.checkKey(attendancedateMapping.toDomain(attendancedatedto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceDate-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"考勤日期" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/attendancedates/fetchdefault")
	public ResponseEntity<List<AttEndanceDateDTO>> fetchDefault(AttEndanceDateSearchContext context) {
        Page<AttEndanceDate> domains = attendancedateService.searchDefault(context) ;
        List<AttEndanceDateDTO> list = attendancedateMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceDate-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"考勤日期" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/attendancedates/searchdefault")
	public ResponseEntity<Page<AttEndanceDateDTO>> searchDefault(@RequestBody AttEndanceDateSearchContext context) {
        Page<AttEndanceDate> domains = attendancedateService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancedateMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

