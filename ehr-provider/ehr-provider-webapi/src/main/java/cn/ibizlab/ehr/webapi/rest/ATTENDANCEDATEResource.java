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
import cn.ibizlab.ehr.core.att.domain.ATTENDANCEDATE;
import cn.ibizlab.ehr.core.att.service.IATTENDANCEDATEService;
import cn.ibizlab.ehr.core.att.filter.ATTENDANCEDATESearchContext;

@Slf4j
@Api(tags = {"ATTENDANCEDATE" })
@RestController("WebApi-attendancedate")
@RequestMapping("")
public class ATTENDANCEDATEResource {

    @Autowired
    public IATTENDANCEDATEService attendancedateService;

    @Autowired
    @Lazy
    public ATTENDANCEDATEMapping attendancedateMapping;

    @PostAuthorize("hasPermission(this.attendancedateMapping.toDomain(returnObject.body),'ehr-ATTENDANCEDATE-Get')")
    @ApiOperation(value = "Get", tags = {"ATTENDANCEDATE" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/attendancedates/{attendancedate_id}")
    public ResponseEntity<ATTENDANCEDATEDTO> get(@PathVariable("attendancedate_id") String attendancedate_id) {
        ATTENDANCEDATE domain = attendancedateService.get(attendancedate_id);
        ATTENDANCEDATEDTO dto = attendancedateMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancedateService.get(#attendancedate_id),'ehr-ATTENDANCEDATE-Remove')")
    @ApiOperation(value = "Remove", tags = {"ATTENDANCEDATE" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendancedates/{attendancedate_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("attendancedate_id") String attendancedate_id) {
         return ResponseEntity.status(HttpStatus.OK).body(attendancedateService.remove(attendancedate_id));
    }

    @PreAuthorize("hasPermission(this.attendancedateService.getAttendancedateByIds(#ids),'ehr-ATTENDANCEDATE-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"ATTENDANCEDATE" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendancedates/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        attendancedateService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendancedateMapping.toDomain(#attendancedatedto),'ehr-ATTENDANCEDATE-Create')")
    @ApiOperation(value = "Create", tags = {"ATTENDANCEDATE" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancedates")
    @Transactional
    public ResponseEntity<ATTENDANCEDATEDTO> create(@RequestBody ATTENDANCEDATEDTO attendancedatedto) {
        ATTENDANCEDATE domain = attendancedateMapping.toDomain(attendancedatedto);
		attendancedateService.create(domain);
        ATTENDANCEDATEDTO dto = attendancedateMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancedateMapping.toDomain(#attendancedatedtos),'ehr-ATTENDANCEDATE-Create')")
    @ApiOperation(value = "createBatch", tags = {"ATTENDANCEDATE" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancedates/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ATTENDANCEDATEDTO> attendancedatedtos) {
        attendancedateService.createBatch(attendancedateMapping.toDomain(attendancedatedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"ATTENDANCEDATE" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/attendancedates/getdraft")
    public ResponseEntity<ATTENDANCEDATEDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(attendancedateMapping.toDto(attendancedateService.getDraft(new ATTENDANCEDATE())));
    }

    @PreAuthorize("hasPermission(this.attendancedateMapping.toDomain(#attendancedatedto),'ehr-ATTENDANCEDATE-Save')")
    @ApiOperation(value = "Save", tags = {"ATTENDANCEDATE" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancedates/save")
    public ResponseEntity<Boolean> save(@RequestBody ATTENDANCEDATEDTO attendancedatedto) {
        return ResponseEntity.status(HttpStatus.OK).body(attendancedateService.save(attendancedateMapping.toDomain(attendancedatedto)));
    }

    @PreAuthorize("hasPermission(this.attendancedateMapping.toDomain(#attendancedatedtos),'ehr-ATTENDANCEDATE-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"ATTENDANCEDATE" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancedates/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ATTENDANCEDATEDTO> attendancedatedtos) {
        attendancedateService.saveBatch(attendancedateMapping.toDomain(attendancedatedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendancedateService.get(#attendancedate_id),'ehr-ATTENDANCEDATE-Update')")
    @ApiOperation(value = "Update", tags = {"ATTENDANCEDATE" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendancedates/{attendancedate_id}")
    @Transactional
    public ResponseEntity<ATTENDANCEDATEDTO> update(@PathVariable("attendancedate_id") String attendancedate_id, @RequestBody ATTENDANCEDATEDTO attendancedatedto) {
		ATTENDANCEDATE domain  = attendancedateMapping.toDomain(attendancedatedto);
        domain .setAttendancedateid(attendancedate_id);
		attendancedateService.update(domain );
		ATTENDANCEDATEDTO dto = attendancedateMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancedateService.getAttendancedateByEntities(this.attendancedateMapping.toDomain(#attendancedatedtos)),'ehr-ATTENDANCEDATE-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"ATTENDANCEDATE" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendancedates/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ATTENDANCEDATEDTO> attendancedatedtos) {
        attendancedateService.updateBatch(attendancedateMapping.toDomain(attendancedatedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"ATTENDANCEDATE" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancedates/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ATTENDANCEDATEDTO attendancedatedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(attendancedateService.checkKey(attendancedateMapping.toDomain(attendancedatedto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCEDATE-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ATTENDANCEDATE" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/attendancedates/fetchdefault")
	public ResponseEntity<List<ATTENDANCEDATEDTO>> fetchDefault(ATTENDANCEDATESearchContext context) {
        Page<ATTENDANCEDATE> domains = attendancedateService.searchDefault(context) ;
        List<ATTENDANCEDATEDTO> list = attendancedateMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCEDATE-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ATTENDANCEDATE" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/attendancedates/searchdefault")
	public ResponseEntity<Page<ATTENDANCEDATEDTO>> searchDefault(@RequestBody ATTENDANCEDATESearchContext context) {
        Page<ATTENDANCEDATE> domains = attendancedateService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancedateMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

