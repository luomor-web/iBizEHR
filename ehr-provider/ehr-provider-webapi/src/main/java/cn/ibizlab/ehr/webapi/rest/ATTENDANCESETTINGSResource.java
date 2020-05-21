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
@Api(tags = {"ATTENDANCESETTINGS" })
@RestController("WebApi-attendancesettings")
@RequestMapping("")
public class ATTENDANCESETTINGSResource {

    @Autowired
    private IATTENDANCESETTINGSService attendancesettingsService;

    @Autowired
    @Lazy
    public ATTENDANCESETTINGSMapping attendancesettingsMapping;

    public ATTENDANCESETTINGSDTO permissionDTO=new ATTENDANCESETTINGSDTO();




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCESETTINGS-AddToKqz-all')")
    @ApiOperation(value = "添加到考勤组（废弃）", tags = {"ATTENDANCESETTINGS" },  notes = "添加到考勤组（废弃）")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancesettings/{attendancesettings_id}/addtokqz")
    @Transactional
    public ResponseEntity<ATTENDANCESETTINGSDTO> addToKqz(@PathVariable("attendancesettings_id") String attendancesettings_id, @RequestBody ATTENDANCESETTINGSDTO attendancesettingsdto) {
        ATTENDANCESETTINGS attendancesettings = attendancesettingsMapping.toDomain(attendancesettingsdto);
        attendancesettings = attendancesettingsService.addToKqz(attendancesettings);
        attendancesettingsdto = attendancesettingsMapping.toDto(attendancesettings);
        return ResponseEntity.status(HttpStatus.OK).body(attendancesettingsdto);
    }




    @PreAuthorize("hasPermission(#attendancesettings_id,'Update',{'Sql',this.attendancesettingsMapping,#attendancesettingsdto})")
    @ApiOperation(value = "Update", tags = {"ATTENDANCESETTINGS" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendancesettings/{attendancesettings_id}")
    @Transactional
    public ResponseEntity<ATTENDANCESETTINGSDTO> update(@PathVariable("attendancesettings_id") String attendancesettings_id, @RequestBody ATTENDANCESETTINGSDTO attendancesettingsdto) {
		ATTENDANCESETTINGS domain = attendancesettingsMapping.toDomain(attendancesettingsdto);
        domain.setAttendancesettingsid(attendancesettings_id);
		attendancesettingsService.update(domain);
		ATTENDANCESETTINGSDTO dto = attendancesettingsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"ATTENDANCESETTINGS" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendancesettings/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ATTENDANCESETTINGSDTO> attendancesettingsdtos) {
        attendancesettingsService.updateBatch(attendancesettingsMapping.toDomain(attendancesettingsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.attendancesettingsMapping,#attendancesettingsdto})")
    @ApiOperation(value = "Create", tags = {"ATTENDANCESETTINGS" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancesettings")
    @Transactional
    public ResponseEntity<ATTENDANCESETTINGSDTO> create(@RequestBody ATTENDANCESETTINGSDTO attendancesettingsdto) {
        ATTENDANCESETTINGS domain = attendancesettingsMapping.toDomain(attendancesettingsdto);
		attendancesettingsService.create(domain);
        ATTENDANCESETTINGSDTO dto = attendancesettingsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"ATTENDANCESETTINGS" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancesettings/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ATTENDANCESETTINGSDTO> attendancesettingsdtos) {
        attendancesettingsService.createBatch(attendancesettingsMapping.toDomain(attendancesettingsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCESETTINGS-Save-all')")
    @ApiOperation(value = "Save", tags = {"ATTENDANCESETTINGS" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancesettings/save")
    public ResponseEntity<Boolean> save(@RequestBody ATTENDANCESETTINGSDTO attendancesettingsdto) {
        return ResponseEntity.status(HttpStatus.OK).body(attendancesettingsService.save(attendancesettingsMapping.toDomain(attendancesettingsdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"ATTENDANCESETTINGS" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancesettings/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ATTENDANCESETTINGSDTO> attendancesettingsdtos) {
        attendancesettingsService.saveBatch(attendancesettingsMapping.toDomain(attendancesettingsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#attendancesettings_id,'Get',{'Sql',this.attendancesettingsMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"ATTENDANCESETTINGS" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/attendancesettings/{attendancesettings_id}")
    public ResponseEntity<ATTENDANCESETTINGSDTO> get(@PathVariable("attendancesettings_id") String attendancesettings_id) {
        ATTENDANCESETTINGS domain = attendancesettingsService.get(attendancesettings_id);
        ATTENDANCESETTINGSDTO dto = attendancesettingsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#attendancesettings_id,'Remove',{'Sql',this.attendancesettingsMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"ATTENDANCESETTINGS" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendancesettings/{attendancesettings_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("attendancesettings_id") String attendancesettings_id) {
         return ResponseEntity.status(HttpStatus.OK).body(attendancesettingsService.remove(attendancesettings_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"ATTENDANCESETTINGS" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendancesettings/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        attendancesettingsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCESETTINGS-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"ATTENDANCESETTINGS" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancesettings/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ATTENDANCESETTINGSDTO attendancesettingsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(attendancesettingsService.checkKey(attendancesettingsMapping.toDomain(attendancesettingsdto)));
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCESETTINGS-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"ATTENDANCESETTINGS" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/attendancesettings/getdraft")
    public ResponseEntity<ATTENDANCESETTINGSDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(attendancesettingsMapping.toDto(attendancesettingsService.getDraft(new ATTENDANCESETTINGS())));
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCESETTINGS-YGSZKQ-all')")
	@ApiOperation(value = "fetch员工设置考勤视图", tags = {"ATTENDANCESETTINGS" } ,notes = "fetch员工设置考勤视图")
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

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCESETTINGS-YGSZKQ-all')")
	@ApiOperation(value = "search员工设置考勤视图", tags = {"ATTENDANCESETTINGS" } ,notes = "search员工设置考勤视图")
    @RequestMapping(method= RequestMethod.POST , value="/attendancesettings/searchygszkq")
	public ResponseEntity<Page<ATTENDANCESETTINGSDTO>> searchYGSZKQ(@RequestBody ATTENDANCESETTINGSSearchContext context) {
        Page<ATTENDANCESETTINGS> domains = attendancesettingsService.searchYGSZKQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancesettingsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCESETTINGS-FYGZZKQ-all')")
	@ApiOperation(value = "fetch非员工终止考勤视图", tags = {"ATTENDANCESETTINGS" } ,notes = "fetch非员工终止考勤视图")
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

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCESETTINGS-FYGZZKQ-all')")
	@ApiOperation(value = "search非员工终止考勤视图", tags = {"ATTENDANCESETTINGS" } ,notes = "search非员工终止考勤视图")
    @RequestMapping(method= RequestMethod.POST , value="/attendancesettings/searchfygzzkq")
	public ResponseEntity<Page<ATTENDANCESETTINGSDTO>> searchFYGZZKQ(@RequestBody ATTENDANCESETTINGSSearchContext context) {
        Page<ATTENDANCESETTINGS> domains = attendancesettingsService.searchFYGZZKQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancesettingsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCESETTINGS-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ATTENDANCESETTINGS" } ,notes = "fetchDEFAULT")
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

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCESETTINGS-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ATTENDANCESETTINGS" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/attendancesettings/searchdefault")
	public ResponseEntity<Page<ATTENDANCESETTINGSDTO>> searchDefault(@RequestBody ATTENDANCESETTINGSSearchContext context) {
        Page<ATTENDANCESETTINGS> domains = attendancesettingsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancesettingsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


