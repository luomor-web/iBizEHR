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
import cn.ibizlab.ehr.core.att.domain.AttEndanceSettings;
import cn.ibizlab.ehr.core.att.service.IAttEndanceSettingsService;
import cn.ibizlab.ehr.core.att.filter.AttEndanceSettingsSearchContext;

@Slf4j
@Api(tags = {"考勤人员" })
@RestController("WebApi-attendancesettings")
@RequestMapping("")
public class AttEndanceSettingsResource {

    @Autowired
    public IAttEndanceSettingsService attendancesettingsService;

    @Autowired
    @Lazy
    public AttEndanceSettingsMapping attendancesettingsMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceSettings-AddToKqz-all')")
    @ApiOperation(value = "添加到考勤组（废弃）", tags = {"考勤人员" },  notes = "添加到考勤组（废弃）")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancesettings/{attendancesettings_id}/addtokqz")
    @Transactional
    public ResponseEntity<AttEndanceSettingsDTO> addToKqz(@PathVariable("attendancesettings_id") String attendancesettings_id, @RequestBody AttEndanceSettingsDTO attendancesettingsdto) {
        AttEndanceSettings attendancesettings = attendancesettingsMapping.toDomain(attendancesettingsdto);
        attendancesettings.setAttendancesettingsid(attendancesettings_id);
        attendancesettings = attendancesettingsService.addToKqz(attendancesettings);
        attendancesettingsdto = attendancesettingsMapping.toDto(attendancesettings);
        return ResponseEntity.status(HttpStatus.OK).body(attendancesettingsdto);
    }

    @PreAuthorize("hasPermission(this.attendancesettingsService.get(#attendancesettings_id),'ehr-AttEndanceSettings-Update')")
    @ApiOperation(value = "更新考勤人员", tags = {"考勤人员" },  notes = "更新考勤人员")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendancesettings/{attendancesettings_id}")
    @Transactional
    public ResponseEntity<AttEndanceSettingsDTO> update(@PathVariable("attendancesettings_id") String attendancesettings_id, @RequestBody AttEndanceSettingsDTO attendancesettingsdto) {
		AttEndanceSettings domain  = attendancesettingsMapping.toDomain(attendancesettingsdto);
        domain .setAttendancesettingsid(attendancesettings_id);
		attendancesettingsService.update(domain );
		AttEndanceSettingsDTO dto = attendancesettingsMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancesettingsService.getAttendancesettingsByEntities(this.attendancesettingsMapping.toDomain(#attendancesettingsdtos)),'ehr-AttEndanceSettings-Update')")
    @ApiOperation(value = "批量更新考勤人员", tags = {"考勤人员" },  notes = "批量更新考勤人员")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendancesettings/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<AttEndanceSettingsDTO> attendancesettingsdtos) {
        attendancesettingsService.updateBatch(attendancesettingsMapping.toDomain(attendancesettingsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendancesettingsMapping.toDomain(#attendancesettingsdto),'ehr-AttEndanceSettings-Create')")
    @ApiOperation(value = "新建考勤人员", tags = {"考勤人员" },  notes = "新建考勤人员")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancesettings")
    @Transactional
    public ResponseEntity<AttEndanceSettingsDTO> create(@RequestBody AttEndanceSettingsDTO attendancesettingsdto) {
        AttEndanceSettings domain = attendancesettingsMapping.toDomain(attendancesettingsdto);
		attendancesettingsService.create(domain);
        AttEndanceSettingsDTO dto = attendancesettingsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancesettingsMapping.toDomain(#attendancesettingsdtos),'ehr-AttEndanceSettings-Create')")
    @ApiOperation(value = "批量新建考勤人员", tags = {"考勤人员" },  notes = "批量新建考勤人员")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancesettings/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<AttEndanceSettingsDTO> attendancesettingsdtos) {
        attendancesettingsService.createBatch(attendancesettingsMapping.toDomain(attendancesettingsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendancesettingsMapping.toDomain(#attendancesettingsdto),'ehr-AttEndanceSettings-Save')")
    @ApiOperation(value = "保存考勤人员", tags = {"考勤人员" },  notes = "保存考勤人员")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancesettings/save")
    public ResponseEntity<Boolean> save(@RequestBody AttEndanceSettingsDTO attendancesettingsdto) {
        return ResponseEntity.status(HttpStatus.OK).body(attendancesettingsService.save(attendancesettingsMapping.toDomain(attendancesettingsdto)));
    }

    @PreAuthorize("hasPermission(this.attendancesettingsMapping.toDomain(#attendancesettingsdtos),'ehr-AttEndanceSettings-Save')")
    @ApiOperation(value = "批量保存考勤人员", tags = {"考勤人员" },  notes = "批量保存考勤人员")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancesettings/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<AttEndanceSettingsDTO> attendancesettingsdtos) {
        attendancesettingsService.saveBatch(attendancesettingsMapping.toDomain(attendancesettingsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.attendancesettingsMapping.toDomain(returnObject.body),'ehr-AttEndanceSettings-Get')")
    @ApiOperation(value = "获取考勤人员", tags = {"考勤人员" },  notes = "获取考勤人员")
	@RequestMapping(method = RequestMethod.GET, value = "/attendancesettings/{attendancesettings_id}")
    public ResponseEntity<AttEndanceSettingsDTO> get(@PathVariable("attendancesettings_id") String attendancesettings_id) {
        AttEndanceSettings domain = attendancesettingsService.get(attendancesettings_id);
        AttEndanceSettingsDTO dto = attendancesettingsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancesettingsService.get(#attendancesettings_id),'ehr-AttEndanceSettings-Remove')")
    @ApiOperation(value = "删除考勤人员", tags = {"考勤人员" },  notes = "删除考勤人员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendancesettings/{attendancesettings_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("attendancesettings_id") String attendancesettings_id) {
         return ResponseEntity.status(HttpStatus.OK).body(attendancesettingsService.remove(attendancesettings_id));
    }

    @PreAuthorize("hasPermission(this.attendancesettingsService.getAttendancesettingsByIds(#ids),'ehr-AttEndanceSettings-Remove')")
    @ApiOperation(value = "批量删除考勤人员", tags = {"考勤人员" },  notes = "批量删除考勤人员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendancesettings/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        attendancesettingsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查考勤人员", tags = {"考勤人员" },  notes = "检查考勤人员")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancesettings/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody AttEndanceSettingsDTO attendancesettingsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(attendancesettingsService.checkKey(attendancesettingsMapping.toDomain(attendancesettingsdto)));
    }

    @ApiOperation(value = "获取考勤人员草稿", tags = {"考勤人员" },  notes = "获取考勤人员草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/attendancesettings/getdraft")
    public ResponseEntity<AttEndanceSettingsDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(attendancesettingsMapping.toDto(attendancesettingsService.getDraft(new AttEndanceSettings())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceSettings-YGSZKQ-all')")
	@ApiOperation(value = "获取员工设置考勤视图", tags = {"考勤人员" } ,notes = "获取员工设置考勤视图")
    @RequestMapping(method= RequestMethod.GET , value="/attendancesettings/fetchygszkq")
	public ResponseEntity<List<AttEndanceSettingsDTO>> fetchYGSZKQ(AttEndanceSettingsSearchContext context) {
        Page<AttEndanceSettings> domains = attendancesettingsService.searchYGSZKQ(context) ;
        List<AttEndanceSettingsDTO> list = attendancesettingsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceSettings-YGSZKQ-all')")
	@ApiOperation(value = "查询员工设置考勤视图", tags = {"考勤人员" } ,notes = "查询员工设置考勤视图")
    @RequestMapping(method= RequestMethod.POST , value="/attendancesettings/searchygszkq")
	public ResponseEntity<Page<AttEndanceSettingsDTO>> searchYGSZKQ(@RequestBody AttEndanceSettingsSearchContext context) {
        Page<AttEndanceSettings> domains = attendancesettingsService.searchYGSZKQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancesettingsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceSettings-FYGZZKQ-all')")
	@ApiOperation(value = "获取非员工终止考勤视图", tags = {"考勤人员" } ,notes = "获取非员工终止考勤视图")
    @RequestMapping(method= RequestMethod.GET , value="/attendancesettings/fetchfygzzkq")
	public ResponseEntity<List<AttEndanceSettingsDTO>> fetchFYGZZKQ(AttEndanceSettingsSearchContext context) {
        Page<AttEndanceSettings> domains = attendancesettingsService.searchFYGZZKQ(context) ;
        List<AttEndanceSettingsDTO> list = attendancesettingsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceSettings-FYGZZKQ-all')")
	@ApiOperation(value = "查询非员工终止考勤视图", tags = {"考勤人员" } ,notes = "查询非员工终止考勤视图")
    @RequestMapping(method= RequestMethod.POST , value="/attendancesettings/searchfygzzkq")
	public ResponseEntity<Page<AttEndanceSettingsDTO>> searchFYGZZKQ(@RequestBody AttEndanceSettingsSearchContext context) {
        Page<AttEndanceSettings> domains = attendancesettingsService.searchFYGZZKQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancesettingsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceSettings-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"考勤人员" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/attendancesettings/fetchdefault")
	public ResponseEntity<List<AttEndanceSettingsDTO>> fetchDefault(AttEndanceSettingsSearchContext context) {
        Page<AttEndanceSettings> domains = attendancesettingsService.searchDefault(context) ;
        List<AttEndanceSettingsDTO> list = attendancesettingsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceSettings-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"考勤人员" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/attendancesettings/searchdefault")
	public ResponseEntity<Page<AttEndanceSettingsDTO>> searchDefault(@RequestBody AttEndanceSettingsSearchContext context) {
        Page<AttEndanceSettings> domains = attendancesettingsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancesettingsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

