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
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceSettings-AddToKqz-all')")
    @ApiOperation(value = "根据人员信息考勤人员", tags = {"考勤人员" },  notes = "根据人员信息考勤人员")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/attendancesettings/{attendancesettings_id}/addtokqz")
    @Transactional
    public ResponseEntity<AttEndanceSettingsDTO> addToKqzByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("attendancesettings_id") String attendancesettings_id, @RequestBody AttEndanceSettingsDTO attendancesettingsdto) {
        AttEndanceSettings domain = attendancesettingsMapping.toDomain(attendancesettingsdto);
        domain.setPimpersonid(pimperson_id);
        domain = attendancesettingsService.addToKqz(domain) ;
        attendancesettingsdto = attendancesettingsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(attendancesettingsdto);
    }

    @PreAuthorize("hasPermission(this.attendancesettingsService.get(#attendancesettings_id),'ehr-AttEndanceSettings-Update')")
    @ApiOperation(value = "根据人员信息更新考勤人员", tags = {"考勤人员" },  notes = "根据人员信息更新考勤人员")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/attendancesettings/{attendancesettings_id}")
    @Transactional
    public ResponseEntity<AttEndanceSettingsDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("attendancesettings_id") String attendancesettings_id, @RequestBody AttEndanceSettingsDTO attendancesettingsdto) {
        AttEndanceSettings domain = attendancesettingsMapping.toDomain(attendancesettingsdto);
        domain.setPimpersonid(pimperson_id);
        domain.setAttendancesettingsid(attendancesettings_id);
		attendancesettingsService.update(domain);
        AttEndanceSettingsDTO dto = attendancesettingsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancesettingsService.getAttendancesettingsByEntities(this.attendancesettingsMapping.toDomain(#attendancesettingsdtos)),'ehr-AttEndanceSettings-Update')")
    @ApiOperation(value = "根据人员信息批量更新考勤人员", tags = {"考勤人员" },  notes = "根据人员信息批量更新考勤人员")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/attendancesettings/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<AttEndanceSettingsDTO> attendancesettingsdtos) {
        List<AttEndanceSettings> domainlist=attendancesettingsMapping.toDomain(attendancesettingsdtos);
        for(AttEndanceSettings domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        attendancesettingsService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendancesettingsMapping.toDomain(#attendancesettingsdto),'ehr-AttEndanceSettings-Create')")
    @ApiOperation(value = "根据人员信息建立考勤人员", tags = {"考勤人员" },  notes = "根据人员信息建立考勤人员")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/attendancesettings")
    @Transactional
    public ResponseEntity<AttEndanceSettingsDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody AttEndanceSettingsDTO attendancesettingsdto) {
        AttEndanceSettings domain = attendancesettingsMapping.toDomain(attendancesettingsdto);
        domain.setPimpersonid(pimperson_id);
		attendancesettingsService.create(domain);
        AttEndanceSettingsDTO dto = attendancesettingsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancesettingsMapping.toDomain(#attendancesettingsdtos),'ehr-AttEndanceSettings-Create')")
    @ApiOperation(value = "根据人员信息批量建立考勤人员", tags = {"考勤人员" },  notes = "根据人员信息批量建立考勤人员")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/attendancesettings/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<AttEndanceSettingsDTO> attendancesettingsdtos) {
        List<AttEndanceSettings> domainlist=attendancesettingsMapping.toDomain(attendancesettingsdtos);
        for(AttEndanceSettings domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        attendancesettingsService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendancesettingsMapping.toDomain(#attendancesettingsdto),'ehr-AttEndanceSettings-Save')")
    @ApiOperation(value = "根据人员信息保存考勤人员", tags = {"考勤人员" },  notes = "根据人员信息保存考勤人员")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/attendancesettings/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody AttEndanceSettingsDTO attendancesettingsdto) {
        AttEndanceSettings domain = attendancesettingsMapping.toDomain(attendancesettingsdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(attendancesettingsService.save(domain));
    }

    @PreAuthorize("hasPermission(this.attendancesettingsMapping.toDomain(#attendancesettingsdtos),'ehr-AttEndanceSettings-Save')")
    @ApiOperation(value = "根据人员信息批量保存考勤人员", tags = {"考勤人员" },  notes = "根据人员信息批量保存考勤人员")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/attendancesettings/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<AttEndanceSettingsDTO> attendancesettingsdtos) {
        List<AttEndanceSettings> domainlist=attendancesettingsMapping.toDomain(attendancesettingsdtos);
        for(AttEndanceSettings domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        attendancesettingsService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.attendancesettingsMapping.toDomain(returnObject.body),'ehr-AttEndanceSettings-Get')")
    @ApiOperation(value = "根据人员信息获取考勤人员", tags = {"考勤人员" },  notes = "根据人员信息获取考勤人员")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/attendancesettings/{attendancesettings_id}")
    public ResponseEntity<AttEndanceSettingsDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("attendancesettings_id") String attendancesettings_id) {
        AttEndanceSettings domain = attendancesettingsService.get(attendancesettings_id);
        AttEndanceSettingsDTO dto = attendancesettingsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancesettingsService.get(#attendancesettings_id),'ehr-AttEndanceSettings-Remove')")
    @ApiOperation(value = "根据人员信息删除考勤人员", tags = {"考勤人员" },  notes = "根据人员信息删除考勤人员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/attendancesettings/{attendancesettings_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("attendancesettings_id") String attendancesettings_id) {
		return ResponseEntity.status(HttpStatus.OK).body(attendancesettingsService.remove(attendancesettings_id));
    }

    @PreAuthorize("hasPermission(this.attendancesettingsService.getAttendancesettingsByIds(#ids),'ehr-AttEndanceSettings-Remove')")
    @ApiOperation(value = "根据人员信息批量删除考勤人员", tags = {"考勤人员" },  notes = "根据人员信息批量删除考勤人员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/attendancesettings/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        attendancesettingsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息检查考勤人员", tags = {"考勤人员" },  notes = "根据人员信息检查考勤人员")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/attendancesettings/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody AttEndanceSettingsDTO attendancesettingsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(attendancesettingsService.checkKey(attendancesettingsMapping.toDomain(attendancesettingsdto)));
    }

    @ApiOperation(value = "根据人员信息获取考勤人员草稿", tags = {"考勤人员" },  notes = "根据人员信息获取考勤人员草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/attendancesettings/getdraft")
    public ResponseEntity<AttEndanceSettingsDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        AttEndanceSettings domain = new AttEndanceSettings();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(attendancesettingsMapping.toDto(attendancesettingsService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceSettings-YGSZKQ-all')")
	@ApiOperation(value = "根据人员信息获取员工设置考勤视图", tags = {"考勤人员" } ,notes = "根据人员信息获取员工设置考勤视图")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/attendancesettings/fetchygszkq")
	public ResponseEntity<List<AttEndanceSettingsDTO>> fetchAttEndanceSettingsYGSZKQByPimPerson(@PathVariable("pimperson_id") String pimperson_id,AttEndanceSettingsSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<AttEndanceSettings> domains = attendancesettingsService.searchYGSZKQ(context) ;
        List<AttEndanceSettingsDTO> list = attendancesettingsMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceSettings-YGSZKQ-all')")
	@ApiOperation(value = "根据人员信息查询员工设置考勤视图", tags = {"考勤人员" } ,notes = "根据人员信息查询员工设置考勤视图")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/attendancesettings/searchygszkq")
	public ResponseEntity<Page<AttEndanceSettingsDTO>> searchAttEndanceSettingsYGSZKQByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody AttEndanceSettingsSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<AttEndanceSettings> domains = attendancesettingsService.searchYGSZKQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancesettingsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceSettings-FYGZZKQ-all')")
	@ApiOperation(value = "根据人员信息获取非员工终止考勤视图", tags = {"考勤人员" } ,notes = "根据人员信息获取非员工终止考勤视图")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/attendancesettings/fetchfygzzkq")
	public ResponseEntity<List<AttEndanceSettingsDTO>> fetchAttEndanceSettingsFYGZZKQByPimPerson(@PathVariable("pimperson_id") String pimperson_id,AttEndanceSettingsSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<AttEndanceSettings> domains = attendancesettingsService.searchFYGZZKQ(context) ;
        List<AttEndanceSettingsDTO> list = attendancesettingsMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceSettings-FYGZZKQ-all')")
	@ApiOperation(value = "根据人员信息查询非员工终止考勤视图", tags = {"考勤人员" } ,notes = "根据人员信息查询非员工终止考勤视图")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/attendancesettings/searchfygzzkq")
	public ResponseEntity<Page<AttEndanceSettingsDTO>> searchAttEndanceSettingsFYGZZKQByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody AttEndanceSettingsSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<AttEndanceSettings> domains = attendancesettingsService.searchFYGZZKQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancesettingsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceSettings-Default-all')")
	@ApiOperation(value = "根据人员信息获取DEFAULT", tags = {"考勤人员" } ,notes = "根据人员信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/attendancesettings/fetchdefault")
	public ResponseEntity<List<AttEndanceSettingsDTO>> fetchAttEndanceSettingsDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,AttEndanceSettingsSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<AttEndanceSettings> domains = attendancesettingsService.searchDefault(context) ;
        List<AttEndanceSettingsDTO> list = attendancesettingsMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceSettings-Default-all')")
	@ApiOperation(value = "根据人员信息查询DEFAULT", tags = {"考勤人员" } ,notes = "根据人员信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/attendancesettings/searchdefault")
	public ResponseEntity<Page<AttEndanceSettingsDTO>> searchAttEndanceSettingsDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody AttEndanceSettingsSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<AttEndanceSettings> domains = attendancesettingsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancesettingsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceSettings-AddToKqz-all')")
    @ApiOperation(value = "根据考勤设置考勤人员", tags = {"考勤人员" },  notes = "根据考勤设置考勤人员")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencesetups/{attendencesetup_id}/attendancesettings/{attendancesettings_id}/addtokqz")
    @Transactional
    public ResponseEntity<AttEndanceSettingsDTO> addToKqzByAttEndenceSetup(@PathVariable("attendencesetup_id") String attendencesetup_id, @PathVariable("attendancesettings_id") String attendancesettings_id, @RequestBody AttEndanceSettingsDTO attendancesettingsdto) {
        AttEndanceSettings domain = attendancesettingsMapping.toDomain(attendancesettingsdto);
        domain.setAttendencesetupid(attendencesetup_id);
        domain = attendancesettingsService.addToKqz(domain) ;
        attendancesettingsdto = attendancesettingsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(attendancesettingsdto);
    }

    @PreAuthorize("hasPermission(this.attendancesettingsService.get(#attendancesettings_id),'ehr-AttEndanceSettings-Update')")
    @ApiOperation(value = "根据考勤设置更新考勤人员", tags = {"考勤人员" },  notes = "根据考勤设置更新考勤人员")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendencesetups/{attendencesetup_id}/attendancesettings/{attendancesettings_id}")
    @Transactional
    public ResponseEntity<AttEndanceSettingsDTO> updateByAttEndenceSetup(@PathVariable("attendencesetup_id") String attendencesetup_id, @PathVariable("attendancesettings_id") String attendancesettings_id, @RequestBody AttEndanceSettingsDTO attendancesettingsdto) {
        AttEndanceSettings domain = attendancesettingsMapping.toDomain(attendancesettingsdto);
        domain.setAttendencesetupid(attendencesetup_id);
        domain.setAttendancesettingsid(attendancesettings_id);
		attendancesettingsService.update(domain);
        AttEndanceSettingsDTO dto = attendancesettingsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancesettingsService.getAttendancesettingsByEntities(this.attendancesettingsMapping.toDomain(#attendancesettingsdtos)),'ehr-AttEndanceSettings-Update')")
    @ApiOperation(value = "根据考勤设置批量更新考勤人员", tags = {"考勤人员" },  notes = "根据考勤设置批量更新考勤人员")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendencesetups/{attendencesetup_id}/attendancesettings/batch")
    public ResponseEntity<Boolean> updateBatchByAttEndenceSetup(@PathVariable("attendencesetup_id") String attendencesetup_id, @RequestBody List<AttEndanceSettingsDTO> attendancesettingsdtos) {
        List<AttEndanceSettings> domainlist=attendancesettingsMapping.toDomain(attendancesettingsdtos);
        for(AttEndanceSettings domain:domainlist){
            domain.setAttendencesetupid(attendencesetup_id);
        }
        attendancesettingsService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendancesettingsMapping.toDomain(#attendancesettingsdto),'ehr-AttEndanceSettings-Create')")
    @ApiOperation(value = "根据考勤设置建立考勤人员", tags = {"考勤人员" },  notes = "根据考勤设置建立考勤人员")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencesetups/{attendencesetup_id}/attendancesettings")
    @Transactional
    public ResponseEntity<AttEndanceSettingsDTO> createByAttEndenceSetup(@PathVariable("attendencesetup_id") String attendencesetup_id, @RequestBody AttEndanceSettingsDTO attendancesettingsdto) {
        AttEndanceSettings domain = attendancesettingsMapping.toDomain(attendancesettingsdto);
        domain.setAttendencesetupid(attendencesetup_id);
		attendancesettingsService.create(domain);
        AttEndanceSettingsDTO dto = attendancesettingsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancesettingsMapping.toDomain(#attendancesettingsdtos),'ehr-AttEndanceSettings-Create')")
    @ApiOperation(value = "根据考勤设置批量建立考勤人员", tags = {"考勤人员" },  notes = "根据考勤设置批量建立考勤人员")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencesetups/{attendencesetup_id}/attendancesettings/batch")
    public ResponseEntity<Boolean> createBatchByAttEndenceSetup(@PathVariable("attendencesetup_id") String attendencesetup_id, @RequestBody List<AttEndanceSettingsDTO> attendancesettingsdtos) {
        List<AttEndanceSettings> domainlist=attendancesettingsMapping.toDomain(attendancesettingsdtos);
        for(AttEndanceSettings domain:domainlist){
            domain.setAttendencesetupid(attendencesetup_id);
        }
        attendancesettingsService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendancesettingsMapping.toDomain(#attendancesettingsdto),'ehr-AttEndanceSettings-Save')")
    @ApiOperation(value = "根据考勤设置保存考勤人员", tags = {"考勤人员" },  notes = "根据考勤设置保存考勤人员")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencesetups/{attendencesetup_id}/attendancesettings/save")
    public ResponseEntity<Boolean> saveByAttEndenceSetup(@PathVariable("attendencesetup_id") String attendencesetup_id, @RequestBody AttEndanceSettingsDTO attendancesettingsdto) {
        AttEndanceSettings domain = attendancesettingsMapping.toDomain(attendancesettingsdto);
        domain.setAttendencesetupid(attendencesetup_id);
        return ResponseEntity.status(HttpStatus.OK).body(attendancesettingsService.save(domain));
    }

    @PreAuthorize("hasPermission(this.attendancesettingsMapping.toDomain(#attendancesettingsdtos),'ehr-AttEndanceSettings-Save')")
    @ApiOperation(value = "根据考勤设置批量保存考勤人员", tags = {"考勤人员" },  notes = "根据考勤设置批量保存考勤人员")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencesetups/{attendencesetup_id}/attendancesettings/savebatch")
    public ResponseEntity<Boolean> saveBatchByAttEndenceSetup(@PathVariable("attendencesetup_id") String attendencesetup_id, @RequestBody List<AttEndanceSettingsDTO> attendancesettingsdtos) {
        List<AttEndanceSettings> domainlist=attendancesettingsMapping.toDomain(attendancesettingsdtos);
        for(AttEndanceSettings domain:domainlist){
             domain.setAttendencesetupid(attendencesetup_id);
        }
        attendancesettingsService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.attendancesettingsMapping.toDomain(returnObject.body),'ehr-AttEndanceSettings-Get')")
    @ApiOperation(value = "根据考勤设置获取考勤人员", tags = {"考勤人员" },  notes = "根据考勤设置获取考勤人员")
	@RequestMapping(method = RequestMethod.GET, value = "/attendencesetups/{attendencesetup_id}/attendancesettings/{attendancesettings_id}")
    public ResponseEntity<AttEndanceSettingsDTO> getByAttEndenceSetup(@PathVariable("attendencesetup_id") String attendencesetup_id, @PathVariable("attendancesettings_id") String attendancesettings_id) {
        AttEndanceSettings domain = attendancesettingsService.get(attendancesettings_id);
        AttEndanceSettingsDTO dto = attendancesettingsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancesettingsService.get(#attendancesettings_id),'ehr-AttEndanceSettings-Remove')")
    @ApiOperation(value = "根据考勤设置删除考勤人员", tags = {"考勤人员" },  notes = "根据考勤设置删除考勤人员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendencesetups/{attendencesetup_id}/attendancesettings/{attendancesettings_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByAttEndenceSetup(@PathVariable("attendencesetup_id") String attendencesetup_id, @PathVariable("attendancesettings_id") String attendancesettings_id) {
		return ResponseEntity.status(HttpStatus.OK).body(attendancesettingsService.remove(attendancesettings_id));
    }

    @PreAuthorize("hasPermission(this.attendancesettingsService.getAttendancesettingsByIds(#ids),'ehr-AttEndanceSettings-Remove')")
    @ApiOperation(value = "根据考勤设置批量删除考勤人员", tags = {"考勤人员" },  notes = "根据考勤设置批量删除考勤人员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendencesetups/{attendencesetup_id}/attendancesettings/batch")
    public ResponseEntity<Boolean> removeBatchByAttEndenceSetup(@RequestBody List<String> ids) {
        attendancesettingsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据考勤设置检查考勤人员", tags = {"考勤人员" },  notes = "根据考勤设置检查考勤人员")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencesetups/{attendencesetup_id}/attendancesettings/checkkey")
    public ResponseEntity<Boolean> checkKeyByAttEndenceSetup(@PathVariable("attendencesetup_id") String attendencesetup_id, @RequestBody AttEndanceSettingsDTO attendancesettingsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(attendancesettingsService.checkKey(attendancesettingsMapping.toDomain(attendancesettingsdto)));
    }

    @ApiOperation(value = "根据考勤设置获取考勤人员草稿", tags = {"考勤人员" },  notes = "根据考勤设置获取考勤人员草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/attendencesetups/{attendencesetup_id}/attendancesettings/getdraft")
    public ResponseEntity<AttEndanceSettingsDTO> getDraftByAttEndenceSetup(@PathVariable("attendencesetup_id") String attendencesetup_id) {
        AttEndanceSettings domain = new AttEndanceSettings();
        domain.setAttendencesetupid(attendencesetup_id);
        return ResponseEntity.status(HttpStatus.OK).body(attendancesettingsMapping.toDto(attendancesettingsService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceSettings-YGSZKQ-all')")
	@ApiOperation(value = "根据考勤设置获取员工设置考勤视图", tags = {"考勤人员" } ,notes = "根据考勤设置获取员工设置考勤视图")
    @RequestMapping(method= RequestMethod.GET , value="/attendencesetups/{attendencesetup_id}/attendancesettings/fetchygszkq")
	public ResponseEntity<List<AttEndanceSettingsDTO>> fetchAttEndanceSettingsYGSZKQByAttEndenceSetup(@PathVariable("attendencesetup_id") String attendencesetup_id,AttEndanceSettingsSearchContext context) {
        context.setN_attendencesetupid_eq(attendencesetup_id);
        Page<AttEndanceSettings> domains = attendancesettingsService.searchYGSZKQ(context) ;
        List<AttEndanceSettingsDTO> list = attendancesettingsMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceSettings-YGSZKQ-all')")
	@ApiOperation(value = "根据考勤设置查询员工设置考勤视图", tags = {"考勤人员" } ,notes = "根据考勤设置查询员工设置考勤视图")
    @RequestMapping(method= RequestMethod.POST , value="/attendencesetups/{attendencesetup_id}/attendancesettings/searchygszkq")
	public ResponseEntity<Page<AttEndanceSettingsDTO>> searchAttEndanceSettingsYGSZKQByAttEndenceSetup(@PathVariable("attendencesetup_id") String attendencesetup_id, @RequestBody AttEndanceSettingsSearchContext context) {
        context.setN_attendencesetupid_eq(attendencesetup_id);
        Page<AttEndanceSettings> domains = attendancesettingsService.searchYGSZKQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancesettingsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceSettings-FYGZZKQ-all')")
	@ApiOperation(value = "根据考勤设置获取非员工终止考勤视图", tags = {"考勤人员" } ,notes = "根据考勤设置获取非员工终止考勤视图")
    @RequestMapping(method= RequestMethod.GET , value="/attendencesetups/{attendencesetup_id}/attendancesettings/fetchfygzzkq")
	public ResponseEntity<List<AttEndanceSettingsDTO>> fetchAttEndanceSettingsFYGZZKQByAttEndenceSetup(@PathVariable("attendencesetup_id") String attendencesetup_id,AttEndanceSettingsSearchContext context) {
        context.setN_attendencesetupid_eq(attendencesetup_id);
        Page<AttEndanceSettings> domains = attendancesettingsService.searchFYGZZKQ(context) ;
        List<AttEndanceSettingsDTO> list = attendancesettingsMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceSettings-FYGZZKQ-all')")
	@ApiOperation(value = "根据考勤设置查询非员工终止考勤视图", tags = {"考勤人员" } ,notes = "根据考勤设置查询非员工终止考勤视图")
    @RequestMapping(method= RequestMethod.POST , value="/attendencesetups/{attendencesetup_id}/attendancesettings/searchfygzzkq")
	public ResponseEntity<Page<AttEndanceSettingsDTO>> searchAttEndanceSettingsFYGZZKQByAttEndenceSetup(@PathVariable("attendencesetup_id") String attendencesetup_id, @RequestBody AttEndanceSettingsSearchContext context) {
        context.setN_attendencesetupid_eq(attendencesetup_id);
        Page<AttEndanceSettings> domains = attendancesettingsService.searchFYGZZKQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancesettingsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceSettings-Default-all')")
	@ApiOperation(value = "根据考勤设置获取DEFAULT", tags = {"考勤人员" } ,notes = "根据考勤设置获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/attendencesetups/{attendencesetup_id}/attendancesettings/fetchdefault")
	public ResponseEntity<List<AttEndanceSettingsDTO>> fetchAttEndanceSettingsDefaultByAttEndenceSetup(@PathVariable("attendencesetup_id") String attendencesetup_id,AttEndanceSettingsSearchContext context) {
        context.setN_attendencesetupid_eq(attendencesetup_id);
        Page<AttEndanceSettings> domains = attendancesettingsService.searchDefault(context) ;
        List<AttEndanceSettingsDTO> list = attendancesettingsMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceSettings-Default-all')")
	@ApiOperation(value = "根据考勤设置查询DEFAULT", tags = {"考勤人员" } ,notes = "根据考勤设置查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/attendencesetups/{attendencesetup_id}/attendancesettings/searchdefault")
	public ResponseEntity<Page<AttEndanceSettingsDTO>> searchAttEndanceSettingsDefaultByAttEndenceSetup(@PathVariable("attendencesetup_id") String attendencesetup_id, @RequestBody AttEndanceSettingsSearchContext context) {
        context.setN_attendencesetupid_eq(attendencesetup_id);
        Page<AttEndanceSettings> domains = attendancesettingsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancesettingsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

