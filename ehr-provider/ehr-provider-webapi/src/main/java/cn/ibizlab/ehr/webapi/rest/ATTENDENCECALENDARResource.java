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
import cn.ibizlab.ehr.core.att.domain.ATTENDENCECALENDAR;
import cn.ibizlab.ehr.core.att.service.IATTENDENCECALENDARService;
import cn.ibizlab.ehr.core.att.filter.ATTENDENCECALENDARSearchContext;




@Slf4j
@Api(tags = {"ATTENDENCECALENDAR" })
@RestController("WebApi-attendencecalendar")
@RequestMapping("")
public class ATTENDENCECALENDARResource {

    @Autowired
    private IATTENDENCECALENDARService attendencecalendarService;

    @Autowired
    @Lazy
    public ATTENDENCECALENDARMapping attendencecalendarMapping;

    public ATTENDENCECALENDARDTO permissionDTO=new ATTENDENCECALENDARDTO();




    @PreAuthorize("hasPermission('','Create',{'Sql',this.attendencecalendarMapping,#attendencecalendardto})")
    @ApiOperation(value = "Create", tags = {"ATTENDENCECALENDAR" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencecalendars")
    @Transactional
    public ResponseEntity<ATTENDENCECALENDARDTO> create(@RequestBody ATTENDENCECALENDARDTO attendencecalendardto) {
        ATTENDENCECALENDAR domain = attendencecalendarMapping.toDomain(attendencecalendardto);
		attendencecalendarService.create(domain);
        ATTENDENCECALENDARDTO dto = attendencecalendarMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"ATTENDENCECALENDAR" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencecalendars/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ATTENDENCECALENDARDTO> attendencecalendardtos) {
        attendencecalendarService.createBatch(attendencecalendarMapping.toDomain(attendencecalendardtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDENCECALENDAR-Save-all')")
    @ApiOperation(value = "Save", tags = {"ATTENDENCECALENDAR" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencecalendars/save")
    public ResponseEntity<Boolean> save(@RequestBody ATTENDENCECALENDARDTO attendencecalendardto) {
        return ResponseEntity.status(HttpStatus.OK).body(attendencecalendarService.save(attendencecalendarMapping.toDomain(attendencecalendardto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"ATTENDENCECALENDAR" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencecalendars/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ATTENDENCECALENDARDTO> attendencecalendardtos) {
        attendencecalendarService.saveBatch(attendencecalendarMapping.toDomain(attendencecalendardtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#attendencecalendar_id,'Update',{'Sql',this.attendencecalendarMapping,#attendencecalendardto})")
    @ApiOperation(value = "Update", tags = {"ATTENDENCECALENDAR" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendencecalendars/{attendencecalendar_id}")
    @Transactional
    public ResponseEntity<ATTENDENCECALENDARDTO> update(@PathVariable("attendencecalendar_id") String attendencecalendar_id, @RequestBody ATTENDENCECALENDARDTO attendencecalendardto) {
		ATTENDENCECALENDAR domain = attendencecalendarMapping.toDomain(attendencecalendardto);
        domain.setAttendencecalendarid(attendencecalendar_id);
		attendencecalendarService.update(domain);
		ATTENDENCECALENDARDTO dto = attendencecalendarMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"ATTENDENCECALENDAR" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendencecalendars/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ATTENDENCECALENDARDTO> attendencecalendardtos) {
        attendencecalendarService.updateBatch(attendencecalendarMapping.toDomain(attendencecalendardtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDENCECALENDAR-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"ATTENDENCECALENDAR" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencecalendars/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ATTENDENCECALENDARDTO attendencecalendardto) {
        return  ResponseEntity.status(HttpStatus.OK).body(attendencecalendarService.checkKey(attendencecalendarMapping.toDomain(attendencecalendardto)));
    }




    @PreAuthorize("hasPermission(#attendencecalendar_id,'Get',{'Sql',this.attendencecalendarMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"ATTENDENCECALENDAR" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/attendencecalendars/{attendencecalendar_id}")
    public ResponseEntity<ATTENDENCECALENDARDTO> get(@PathVariable("attendencecalendar_id") String attendencecalendar_id) {
        ATTENDENCECALENDAR domain = attendencecalendarService.get(attendencecalendar_id);
        ATTENDENCECALENDARDTO dto = attendencecalendarMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#attendencecalendar_id,'Remove',{'Sql',this.attendencecalendarMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"ATTENDENCECALENDAR" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendencecalendars/{attendencecalendar_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("attendencecalendar_id") String attendencecalendar_id) {
         return ResponseEntity.status(HttpStatus.OK).body(attendencecalendarService.remove(attendencecalendar_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"ATTENDENCECALENDAR" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendencecalendars/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        attendencecalendarService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDENCECALENDAR-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"ATTENDENCECALENDAR" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/attendencecalendars/getdraft")
    public ResponseEntity<ATTENDENCECALENDARDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(attendencecalendarMapping.toDto(attendencecalendarService.getDraft(new ATTENDENCECALENDAR())));
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDENCECALENDAR-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ATTENDENCECALENDAR" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/attendencecalendars/fetchdefault")
	public ResponseEntity<List<ATTENDENCECALENDARDTO>> fetchDefault(ATTENDENCECALENDARSearchContext context) {
        Page<ATTENDENCECALENDAR> domains = attendencecalendarService.searchDefault(context) ;
        List<ATTENDENCECALENDARDTO> list = attendencecalendarMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDENCECALENDAR-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ATTENDENCECALENDAR" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/attendencecalendars/searchdefault")
	public ResponseEntity<Page<ATTENDENCECALENDARDTO>> searchDefault(@RequestBody ATTENDENCECALENDARSearchContext context) {
        Page<ATTENDENCECALENDAR> domains = attendencecalendarService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendencecalendarMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


