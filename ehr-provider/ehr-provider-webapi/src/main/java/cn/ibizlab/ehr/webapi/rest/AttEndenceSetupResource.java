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
import cn.ibizlab.ehr.core.att.domain.AttEndenceSetup;
import cn.ibizlab.ehr.core.att.service.IAttEndenceSetupService;
import cn.ibizlab.ehr.core.att.filter.AttEndenceSetupSearchContext;

@Slf4j
@Api(tags = {"AttEndenceSetup" })
@RestController("WebApi-attendencesetup")
@RequestMapping("")
public class AttEndenceSetupResource {

    @Autowired
    public IAttEndenceSetupService attendencesetupService;

    @Autowired
    @Lazy
    public AttEndenceSetupMapping attendencesetupMapping;

    @PreAuthorize("hasPermission(this.attendencesetupService.get(#attendencesetup_id),'ehr-AttEndenceSetup-Update')")
    @ApiOperation(value = "Update", tags = {"AttEndenceSetup" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendencesetups/{attendencesetup_id}")
    @Transactional
    public ResponseEntity<AttEndenceSetupDTO> update(@PathVariable("attendencesetup_id") String attendencesetup_id, @RequestBody AttEndenceSetupDTO attendencesetupdto) {
		AttEndenceSetup domain  = attendencesetupMapping.toDomain(attendencesetupdto);
        domain .setAttendencesetupid(attendencesetup_id);
		attendencesetupService.update(domain );
		AttEndenceSetupDTO dto = attendencesetupMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendencesetupService.getAttendencesetupByEntities(this.attendencesetupMapping.toDomain(#attendencesetupdtos)),'ehr-AttEndenceSetup-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"AttEndenceSetup" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendencesetups/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<AttEndenceSetupDTO> attendencesetupdtos) {
        attendencesetupService.updateBatch(attendencesetupMapping.toDomain(attendencesetupdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendencesetupMapping.toDomain(#attendencesetupdto),'ehr-AttEndenceSetup-Save')")
    @ApiOperation(value = "Save", tags = {"AttEndenceSetup" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencesetups/save")
    public ResponseEntity<Boolean> save(@RequestBody AttEndenceSetupDTO attendencesetupdto) {
        return ResponseEntity.status(HttpStatus.OK).body(attendencesetupService.save(attendencesetupMapping.toDomain(attendencesetupdto)));
    }

    @PreAuthorize("hasPermission(this.attendencesetupMapping.toDomain(#attendencesetupdtos),'ehr-AttEndenceSetup-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"AttEndenceSetup" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencesetups/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<AttEndenceSetupDTO> attendencesetupdtos) {
        attendencesetupService.saveBatch(attendencesetupMapping.toDomain(attendencesetupdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.attendencesetupMapping.toDomain(returnObject.body),'ehr-AttEndenceSetup-Get')")
    @ApiOperation(value = "Get", tags = {"AttEndenceSetup" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/attendencesetups/{attendencesetup_id}")
    public ResponseEntity<AttEndenceSetupDTO> get(@PathVariable("attendencesetup_id") String attendencesetup_id) {
        AttEndenceSetup domain = attendencesetupService.get(attendencesetup_id);
        AttEndenceSetupDTO dto = attendencesetupMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "GetDraft", tags = {"AttEndenceSetup" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/attendencesetups/getdraft")
    public ResponseEntity<AttEndenceSetupDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(attendencesetupMapping.toDto(attendencesetupService.getDraft(new AttEndenceSetup())));
    }

    @PreAuthorize("hasPermission(this.attendencesetupService.get(#attendencesetup_id),'ehr-AttEndenceSetup-Remove')")
    @ApiOperation(value = "Remove", tags = {"AttEndenceSetup" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendencesetups/{attendencesetup_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("attendencesetup_id") String attendencesetup_id) {
         return ResponseEntity.status(HttpStatus.OK).body(attendencesetupService.remove(attendencesetup_id));
    }

    @PreAuthorize("hasPermission(this.attendencesetupService.getAttendencesetupByIds(#ids),'ehr-AttEndenceSetup-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"AttEndenceSetup" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendencesetups/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        attendencesetupService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendencesetupMapping.toDomain(#attendencesetupdto),'ehr-AttEndenceSetup-Create')")
    @ApiOperation(value = "Create", tags = {"AttEndenceSetup" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencesetups")
    @Transactional
    public ResponseEntity<AttEndenceSetupDTO> create(@RequestBody AttEndenceSetupDTO attendencesetupdto) {
        AttEndenceSetup domain = attendencesetupMapping.toDomain(attendencesetupdto);
		attendencesetupService.create(domain);
        AttEndenceSetupDTO dto = attendencesetupMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendencesetupMapping.toDomain(#attendencesetupdtos),'ehr-AttEndenceSetup-Create')")
    @ApiOperation(value = "createBatch", tags = {"AttEndenceSetup" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencesetups/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<AttEndenceSetupDTO> attendencesetupdtos) {
        attendencesetupService.createBatch(attendencesetupMapping.toDomain(attendencesetupdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"AttEndenceSetup" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencesetups/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody AttEndenceSetupDTO attendencesetupdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(attendencesetupService.checkKey(attendencesetupMapping.toDomain(attendencesetupdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndenceSetup-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"AttEndenceSetup" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/attendencesetups/fetchdefault")
	public ResponseEntity<List<AttEndenceSetupDTO>> fetchDefault(AttEndenceSetupSearchContext context) {
        Page<AttEndenceSetup> domains = attendencesetupService.searchDefault(context) ;
        List<AttEndenceSetupDTO> list = attendencesetupMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndenceSetup-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"AttEndenceSetup" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/attendencesetups/searchdefault")
	public ResponseEntity<Page<AttEndenceSetupDTO>> searchDefault(@RequestBody AttEndenceSetupSearchContext context) {
        Page<AttEndenceSetup> domains = attendencesetupService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendencesetupMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndenceSetup-CurOrgKQSZ-all')")
	@ApiOperation(value = "fetch当前组织下的考勤设置", tags = {"AttEndenceSetup" } ,notes = "fetch当前组织下的考勤设置")
    @RequestMapping(method= RequestMethod.GET , value="/attendencesetups/fetchcurorgkqsz")
	public ResponseEntity<List<AttEndenceSetupDTO>> fetchCurOrgKQSZ(AttEndenceSetupSearchContext context) {
        Page<AttEndenceSetup> domains = attendencesetupService.searchCurOrgKQSZ(context) ;
        List<AttEndenceSetupDTO> list = attendencesetupMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndenceSetup-CurOrgKQSZ-all')")
	@ApiOperation(value = "search当前组织下的考勤设置", tags = {"AttEndenceSetup" } ,notes = "search当前组织下的考勤设置")
    @RequestMapping(method= RequestMethod.POST , value="/attendencesetups/searchcurorgkqsz")
	public ResponseEntity<Page<AttEndenceSetupDTO>> searchCurOrgKQSZ(@RequestBody AttEndenceSetupSearchContext context) {
        Page<AttEndenceSetup> domains = attendencesetupService.searchCurOrgKQSZ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendencesetupMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndenceSetup-KQYBXKQB-all')")
	@ApiOperation(value = "fetch考勤月报中选考勤表", tags = {"AttEndenceSetup" } ,notes = "fetch考勤月报中选考勤表")
    @RequestMapping(method= RequestMethod.GET , value="/attendencesetups/fetchkqybxkqb")
	public ResponseEntity<List<AttEndenceSetupDTO>> fetchKQYBXKQB(AttEndenceSetupSearchContext context) {
        Page<AttEndenceSetup> domains = attendencesetupService.searchKQYBXKQB(context) ;
        List<AttEndenceSetupDTO> list = attendencesetupMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndenceSetup-KQYBXKQB-all')")
	@ApiOperation(value = "search考勤月报中选考勤表", tags = {"AttEndenceSetup" } ,notes = "search考勤月报中选考勤表")
    @RequestMapping(method= RequestMethod.POST , value="/attendencesetups/searchkqybxkqb")
	public ResponseEntity<Page<AttEndenceSetupDTO>> searchKQYBXKQB(@RequestBody AttEndenceSetupSearchContext context) {
        Page<AttEndenceSetup> domains = attendencesetupService.searchKQYBXKQB(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendencesetupMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndenceSetup-KQYCZKQSZ-all')")
	@ApiOperation(value = "fetch考勤员操作考勤设置", tags = {"AttEndenceSetup" } ,notes = "fetch考勤员操作考勤设置")
    @RequestMapping(method= RequestMethod.GET , value="/attendencesetups/fetchkqyczkqsz")
	public ResponseEntity<List<AttEndenceSetupDTO>> fetchKQYCZKQSZ(AttEndenceSetupSearchContext context) {
        Page<AttEndenceSetup> domains = attendencesetupService.searchKQYCZKQSZ(context) ;
        List<AttEndenceSetupDTO> list = attendencesetupMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndenceSetup-KQYCZKQSZ-all')")
	@ApiOperation(value = "search考勤员操作考勤设置", tags = {"AttEndenceSetup" } ,notes = "search考勤员操作考勤设置")
    @RequestMapping(method= RequestMethod.POST , value="/attendencesetups/searchkqyczkqsz")
	public ResponseEntity<Page<AttEndenceSetupDTO>> searchKQYCZKQSZ(@RequestBody AttEndenceSetupSearchContext context) {
        Page<AttEndenceSetup> domains = attendencesetupService.searchKQYCZKQSZ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendencesetupMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

