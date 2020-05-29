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
import cn.ibizlab.ehr.core.att.domain.ATTENDANCESETTINGS;
import cn.ibizlab.ehr.core.att.service.IATTENDANCESETTINGSService;
import cn.ibizlab.ehr.core.att.filter.ATTENDANCESETTINGSSearchContext;

@Slf4j
@Api(tags = {"考勤人员" })
@RestController("WebApi-attendancesettings")
@RequestMapping("")
public class ATTENDANCESETTINGSResource {

    @Autowired
    public IATTENDANCESETTINGSService attendancesettingsService;

    @Autowired
    @Lazy
    public ATTENDANCESETTINGSMapping attendancesettingsMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCESETTINGS-AddToKqz-all')")
    @ApiOperation(value = "添加到考勤组（废弃）", tags = {"考勤人员" },  notes = "添加到考勤组（废弃）")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancesettings/{attendancesettings_id}/addtokqz")
    @Transactional
    public ResponseEntity<ATTENDANCESETTINGSDTO> addToKqz(@PathVariable("attendancesettings_id") String attendancesettings_id, @RequestBody ATTENDANCESETTINGSDTO attendancesettingsdto) {
        ATTENDANCESETTINGS attendancesettings = attendancesettingsMapping.toDomain(attendancesettingsdto);
        attendancesettings.setAttendancesettingsid(attendancesettings_id);
        attendancesettings = attendancesettingsService.addToKqz(attendancesettings);
        attendancesettingsdto = attendancesettingsMapping.toDto(attendancesettings);
        return ResponseEntity.status(HttpStatus.OK).body(attendancesettingsdto);
    }

    @PreAuthorize("hasPermission(this.attendancesettingsService.get(#attendancesettings_id),'ehr-ATTENDANCESETTINGS-Update')")
    @ApiOperation(value = "更新考勤人员", tags = {"考勤人员" },  notes = "更新考勤人员")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendancesettings/{attendancesettings_id}")
    @Transactional
    public ResponseEntity<ATTENDANCESETTINGSDTO> update(@PathVariable("attendancesettings_id") String attendancesettings_id, @RequestBody ATTENDANCESETTINGSDTO attendancesettingsdto) {
		ATTENDANCESETTINGS domain  = attendancesettingsMapping.toDomain(attendancesettingsdto);
        domain .setAttendancesettingsid(attendancesettings_id);
		attendancesettingsService.update(domain );
		ATTENDANCESETTINGSDTO dto = attendancesettingsMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancesettingsService.getAttendancesettingsByEntities(this.attendancesettingsMapping.toDomain(#attendancesettingsdtos)),'ehr-ATTENDANCESETTINGS-Update')")
    @ApiOperation(value = "批量更新考勤人员", tags = {"考勤人员" },  notes = "批量更新考勤人员")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendancesettings/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ATTENDANCESETTINGSDTO> attendancesettingsdtos) {
        attendancesettingsService.updateBatch(attendancesettingsMapping.toDomain(attendancesettingsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendancesettingsMapping.toDomain(#attendancesettingsdto),'ehr-ATTENDANCESETTINGS-Create')")
    @ApiOperation(value = "新建考勤人员", tags = {"考勤人员" },  notes = "新建考勤人员")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancesettings")
    @Transactional
    public ResponseEntity<ATTENDANCESETTINGSDTO> create(@RequestBody ATTENDANCESETTINGSDTO attendancesettingsdto) {
        ATTENDANCESETTINGS domain = attendancesettingsMapping.toDomain(attendancesettingsdto);
		attendancesettingsService.create(domain);
        ATTENDANCESETTINGSDTO dto = attendancesettingsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancesettingsMapping.toDomain(#attendancesettingsdtos),'ehr-ATTENDANCESETTINGS-Create')")
    @ApiOperation(value = "批量新建考勤人员", tags = {"考勤人员" },  notes = "批量新建考勤人员")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancesettings/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ATTENDANCESETTINGSDTO> attendancesettingsdtos) {
        attendancesettingsService.createBatch(attendancesettingsMapping.toDomain(attendancesettingsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendancesettingsMapping.toDomain(#attendancesettingsdto),'ehr-ATTENDANCESETTINGS-Save')")
    @ApiOperation(value = "保存考勤人员", tags = {"考勤人员" },  notes = "保存考勤人员")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancesettings/save")
    public ResponseEntity<Boolean> save(@RequestBody ATTENDANCESETTINGSDTO attendancesettingsdto) {
        return ResponseEntity.status(HttpStatus.OK).body(attendancesettingsService.save(attendancesettingsMapping.toDomain(attendancesettingsdto)));
    }

    @PreAuthorize("hasPermission(this.attendancesettingsMapping.toDomain(#attendancesettingsdtos),'ehr-ATTENDANCESETTINGS-Save')")
    @ApiOperation(value = "批量保存考勤人员", tags = {"考勤人员" },  notes = "批量保存考勤人员")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancesettings/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ATTENDANCESETTINGSDTO> attendancesettingsdtos) {
        attendancesettingsService.saveBatch(attendancesettingsMapping.toDomain(attendancesettingsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.attendancesettingsMapping.toDomain(returnObject.body),'ehr-ATTENDANCESETTINGS-Get')")
    @ApiOperation(value = "获取考勤人员", tags = {"考勤人员" },  notes = "获取考勤人员")
	@RequestMapping(method = RequestMethod.GET, value = "/attendancesettings/{attendancesettings_id}")
    public ResponseEntity<ATTENDANCESETTINGSDTO> get(@PathVariable("attendancesettings_id") String attendancesettings_id) {
        ATTENDANCESETTINGS domain = attendancesettingsService.get(attendancesettings_id);
        ATTENDANCESETTINGSDTO dto = attendancesettingsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancesettingsService.get(#attendancesettings_id),'ehr-ATTENDANCESETTINGS-Remove')")
    @ApiOperation(value = "删除考勤人员", tags = {"考勤人员" },  notes = "删除考勤人员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendancesettings/{attendancesettings_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("attendancesettings_id") String attendancesettings_id) {
         return ResponseEntity.status(HttpStatus.OK).body(attendancesettingsService.remove(attendancesettings_id));
    }

    @PreAuthorize("hasPermission(this.attendancesettingsService.getAttendancesettingsByIds(#ids),'ehr-ATTENDANCESETTINGS-Remove')")
    @ApiOperation(value = "批量删除考勤人员", tags = {"考勤人员" },  notes = "批量删除考勤人员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendancesettings/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        attendancesettingsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查考勤人员", tags = {"考勤人员" },  notes = "检查考勤人员")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancesettings/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ATTENDANCESETTINGSDTO attendancesettingsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(attendancesettingsService.checkKey(attendancesettingsMapping.toDomain(attendancesettingsdto)));
    }

    @ApiOperation(value = "获取考勤人员草稿", tags = {"考勤人员" },  notes = "获取考勤人员草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/attendancesettings/getdraft")
    public ResponseEntity<ATTENDANCESETTINGSDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(attendancesettingsMapping.toDto(attendancesettingsService.getDraft(new ATTENDANCESETTINGS())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCESETTINGS-YGSZKQ-all')")
	@ApiOperation(value = "获取员工设置考勤视图", tags = {"考勤人员" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/attendancesettings/fetchygszkq")
	public ResponseEntity<List<ATTENDANCESETTINGSDTO>> fetchYGSZKQ(ATTENDANCESETTINGSSearchContext context) {
        Page<ATTENDANCESETTINGS> domains = attendancesettingsService.searchYGSZKQ(context) ;
        List<ATTENDANCESETTINGSDTO> list = attendancesettingsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCESETTINGS-YGSZKQ-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"考勤人员" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/attendancesettings/searchygszkq")
	public ResponseEntity<Page<ATTENDANCESETTINGSDTO>> searchYGSZKQ(@RequestBody ATTENDANCESETTINGSSearchContext context) {
        Page<ATTENDANCESETTINGS> domains = attendancesettingsService.searchYGSZKQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancesettingsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCESETTINGS-FYGZZKQ-all')")
	@ApiOperation(value = "获取非员工终止考勤视图", tags = {"考勤人员" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/attendancesettings/fetchfygzzkq")
	public ResponseEntity<List<ATTENDANCESETTINGSDTO>> fetchFYGZZKQ(ATTENDANCESETTINGSSearchContext context) {
        Page<ATTENDANCESETTINGS> domains = attendancesettingsService.searchFYGZZKQ(context) ;
        List<ATTENDANCESETTINGSDTO> list = attendancesettingsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCESETTINGS-FYGZZKQ-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"考勤人员" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/attendancesettings/searchfygzzkq")
	public ResponseEntity<Page<ATTENDANCESETTINGSDTO>> searchFYGZZKQ(@RequestBody ATTENDANCESETTINGSSearchContext context) {
        Page<ATTENDANCESETTINGS> domains = attendancesettingsService.searchFYGZZKQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancesettingsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCESETTINGS-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"考勤人员" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/attendancesettings/fetchdefault")
	public ResponseEntity<List<ATTENDANCESETTINGSDTO>> fetchDefault(ATTENDANCESETTINGSSearchContext context) {
        Page<ATTENDANCESETTINGS> domains = attendancesettingsService.searchDefault(context) ;
        List<ATTENDANCESETTINGSDTO> list = attendancesettingsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCESETTINGS-Default-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"考勤人员" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/attendancesettings/searchdefault")
	public ResponseEntity<Page<ATTENDANCESETTINGSDTO>> searchDefault(@RequestBody ATTENDANCESETTINGSSearchContext context) {
        Page<ATTENDANCESETTINGS> domains = attendancesettingsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancesettingsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

