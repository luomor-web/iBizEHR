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
import cn.ibizlab.ehr.core.att.domain.ATTENDENCESETUP;
import cn.ibizlab.ehr.core.att.service.IATTENDENCESETUPService;
import cn.ibizlab.ehr.core.att.filter.ATTENDENCESETUPSearchContext;




@Slf4j
@Api(tags = {"ATTENDENCESETUP" })
@RestController("WebApi-attendencesetup")
@RequestMapping("")
public class ATTENDENCESETUPResource {

    @Autowired
    private IATTENDENCESETUPService attendencesetupService;

    @Autowired
    @Lazy
    public ATTENDENCESETUPMapping attendencesetupMapping;

    public ATTENDENCESETUPDTO permissionDTO=new ATTENDENCESETUPDTO();

    @PreAuthorize("hasPermission(#attendencesetup_id,'Update',{'Sql',this.attendencesetupMapping,#attendencesetupdto})")
    @ApiOperation(value = "Update", tags = {"ATTENDENCESETUP" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendencesetups/{attendencesetup_id}")
    @Transactional
    public ResponseEntity<ATTENDENCESETUPDTO> update(@PathVariable("attendencesetup_id") String attendencesetup_id, @RequestBody ATTENDENCESETUPDTO attendencesetupdto) {
		ATTENDENCESETUP domain = attendencesetupMapping.toDomain(attendencesetupdto);
        domain.setAttendencesetupid(attendencesetup_id);
		attendencesetupService.update(domain);
		ATTENDENCESETUPDTO dto = attendencesetupMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"ATTENDENCESETUP" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendencesetups/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ATTENDENCESETUPDTO> attendencesetupdtos) {
        attendencesetupService.updateBatch(attendencesetupMapping.toDomain(attendencesetupdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDENCESETUP-Save-all')")
    @ApiOperation(value = "Save", tags = {"ATTENDENCESETUP" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencesetups/save")
    public ResponseEntity<Boolean> save(@RequestBody ATTENDENCESETUPDTO attendencesetupdto) {
        return ResponseEntity.status(HttpStatus.OK).body(attendencesetupService.save(attendencesetupMapping.toDomain(attendencesetupdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"ATTENDENCESETUP" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencesetups/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ATTENDENCESETUPDTO> attendencesetupdtos) {
        attendencesetupService.saveBatch(attendencesetupMapping.toDomain(attendencesetupdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#attendencesetup_id,'Get',{'Sql',this.attendencesetupMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"ATTENDENCESETUP" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/attendencesetups/{attendencesetup_id}")
    public ResponseEntity<ATTENDENCESETUPDTO> get(@PathVariable("attendencesetup_id") String attendencesetup_id) {
        ATTENDENCESETUP domain = attendencesetupService.get(attendencesetup_id);
        ATTENDENCESETUPDTO dto = attendencesetupMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDENCESETUP-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"ATTENDENCESETUP" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/attendencesetups/getdraft")
    public ResponseEntity<ATTENDENCESETUPDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(attendencesetupMapping.toDto(attendencesetupService.getDraft(new ATTENDENCESETUP())));
    }

    @PreAuthorize("hasPermission(#attendencesetup_id,'Remove',{'Sql',this.attendencesetupMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"ATTENDENCESETUP" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendencesetups/{attendencesetup_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("attendencesetup_id") String attendencesetup_id) {
         return ResponseEntity.status(HttpStatus.OK).body(attendencesetupService.remove(attendencesetup_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"ATTENDENCESETUP" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendencesetups/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        attendencesetupService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.attendencesetupMapping,#attendencesetupdto})")
    @ApiOperation(value = "Create", tags = {"ATTENDENCESETUP" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencesetups")
    @Transactional
    public ResponseEntity<ATTENDENCESETUPDTO> create(@RequestBody ATTENDENCESETUPDTO attendencesetupdto) {
        ATTENDENCESETUP domain = attendencesetupMapping.toDomain(attendencesetupdto);
		attendencesetupService.create(domain);
        ATTENDENCESETUPDTO dto = attendencesetupMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"ATTENDENCESETUP" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencesetups/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ATTENDENCESETUPDTO> attendencesetupdtos) {
        attendencesetupService.createBatch(attendencesetupMapping.toDomain(attendencesetupdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDENCESETUP-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"ATTENDENCESETUP" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencesetups/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ATTENDENCESETUPDTO attendencesetupdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(attendencesetupService.checkKey(attendencesetupMapping.toDomain(attendencesetupdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDENCESETUP-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ATTENDENCESETUP" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/attendencesetups/fetchdefault")
	public ResponseEntity<List<ATTENDENCESETUPDTO>> fetchDefault(ATTENDENCESETUPSearchContext context) {
        Page<ATTENDENCESETUP> domains = attendencesetupService.searchDefault(context) ;
        List<ATTENDENCESETUPDTO> list = attendencesetupMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDENCESETUP-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ATTENDENCESETUP" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/attendencesetups/searchdefault")
	public ResponseEntity<Page<ATTENDENCESETUPDTO>> searchDefault(@RequestBody ATTENDENCESETUPSearchContext context) {
        Page<ATTENDENCESETUP> domains = attendencesetupService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendencesetupMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDENCESETUP-CurOrgKQSZ-all')")
	@ApiOperation(value = "fetch当前组织下的考勤设置", tags = {"ATTENDENCESETUP" } ,notes = "fetch当前组织下的考勤设置")
    @RequestMapping(method= RequestMethod.GET , value="/attendencesetups/fetchcurorgkqsz")
	public ResponseEntity<List<ATTENDENCESETUPDTO>> fetchCurOrgKQSZ(ATTENDENCESETUPSearchContext context) {
        Page<ATTENDENCESETUP> domains = attendencesetupService.searchCurOrgKQSZ(context) ;
        List<ATTENDENCESETUPDTO> list = attendencesetupMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDENCESETUP-CurOrgKQSZ-all')")
	@ApiOperation(value = "search当前组织下的考勤设置", tags = {"ATTENDENCESETUP" } ,notes = "search当前组织下的考勤设置")
    @RequestMapping(method= RequestMethod.POST , value="/attendencesetups/searchcurorgkqsz")
	public ResponseEntity<Page<ATTENDENCESETUPDTO>> searchCurOrgKQSZ(@RequestBody ATTENDENCESETUPSearchContext context) {
        Page<ATTENDENCESETUP> domains = attendencesetupService.searchCurOrgKQSZ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendencesetupMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDENCESETUP-KQYBXKQB-all')")
	@ApiOperation(value = "fetch考勤月报中选考勤表", tags = {"ATTENDENCESETUP" } ,notes = "fetch考勤月报中选考勤表")
    @RequestMapping(method= RequestMethod.GET , value="/attendencesetups/fetchkqybxkqb")
	public ResponseEntity<List<ATTENDENCESETUPDTO>> fetchKQYBXKQB(ATTENDENCESETUPSearchContext context) {
        Page<ATTENDENCESETUP> domains = attendencesetupService.searchKQYBXKQB(context) ;
        List<ATTENDENCESETUPDTO> list = attendencesetupMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDENCESETUP-KQYBXKQB-all')")
	@ApiOperation(value = "search考勤月报中选考勤表", tags = {"ATTENDENCESETUP" } ,notes = "search考勤月报中选考勤表")
    @RequestMapping(method= RequestMethod.POST , value="/attendencesetups/searchkqybxkqb")
	public ResponseEntity<Page<ATTENDENCESETUPDTO>> searchKQYBXKQB(@RequestBody ATTENDENCESETUPSearchContext context) {
        Page<ATTENDENCESETUP> domains = attendencesetupService.searchKQYBXKQB(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendencesetupMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDENCESETUP-KQYCZKQSZ-all')")
	@ApiOperation(value = "fetch考勤员操作考勤设置", tags = {"ATTENDENCESETUP" } ,notes = "fetch考勤员操作考勤设置")
    @RequestMapping(method= RequestMethod.GET , value="/attendencesetups/fetchkqyczkqsz")
	public ResponseEntity<List<ATTENDENCESETUPDTO>> fetchKQYCZKQSZ(ATTENDENCESETUPSearchContext context) {
        Page<ATTENDENCESETUP> domains = attendencesetupService.searchKQYCZKQSZ(context) ;
        List<ATTENDENCESETUPDTO> list = attendencesetupMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDENCESETUP-KQYCZKQSZ-all')")
	@ApiOperation(value = "search考勤员操作考勤设置", tags = {"ATTENDENCESETUP" } ,notes = "search考勤员操作考勤设置")
    @RequestMapping(method= RequestMethod.POST , value="/attendencesetups/searchkqyczkqsz")
	public ResponseEntity<Page<ATTENDENCESETUPDTO>> searchKQYCZKQSZ(@RequestBody ATTENDENCESETUPSearchContext context) {
        Page<ATTENDENCESETUP> domains = attendencesetupService.searchKQYCZKQSZ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendencesetupMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
