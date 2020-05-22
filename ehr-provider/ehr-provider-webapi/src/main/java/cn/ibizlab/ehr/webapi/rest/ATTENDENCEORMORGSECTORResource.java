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
import cn.ibizlab.ehr.core.att.domain.ATTENDENCEORMORGSECTOR;
import cn.ibizlab.ehr.core.att.service.IATTENDENCEORMORGSECTORService;
import cn.ibizlab.ehr.core.att.filter.ATTENDENCEORMORGSECTORSearchContext;




@Slf4j
@Api(tags = {"ATTENDENCEORMORGSECTOR" })
@RestController("WebApi-attendenceormorgsector")
@RequestMapping("")
public class ATTENDENCEORMORGSECTORResource {

    @Autowired
    private IATTENDENCEORMORGSECTORService attendenceormorgsectorService;

    @Autowired
    @Lazy
    public ATTENDENCEORMORGSECTORMapping attendenceormorgsectorMapping;

    public ATTENDENCEORMORGSECTORDTO permissionDTO=new ATTENDENCEORMORGSECTORDTO();

    @PreAuthorize("hasPermission(#attendenceormorgsector_id,'Get',{'Sql',this.attendenceormorgsectorMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"ATTENDENCEORMORGSECTOR" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/attendenceormorgsectors/{attendenceormorgsector_id}")
    public ResponseEntity<ATTENDENCEORMORGSECTORDTO> get(@PathVariable("attendenceormorgsector_id") String attendenceormorgsector_id) {
        ATTENDENCEORMORGSECTOR domain = attendenceormorgsectorService.get(attendenceormorgsector_id);
        ATTENDENCEORMORGSECTORDTO dto = attendenceormorgsectorMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.attendenceormorgsectorMapping,#attendenceormorgsectordto})")
    @ApiOperation(value = "Create", tags = {"ATTENDENCEORMORGSECTOR" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/attendenceormorgsectors")
    @Transactional
    public ResponseEntity<ATTENDENCEORMORGSECTORDTO> create(@RequestBody ATTENDENCEORMORGSECTORDTO attendenceormorgsectordto) {
        ATTENDENCEORMORGSECTOR domain = attendenceormorgsectorMapping.toDomain(attendenceormorgsectordto);
		attendenceormorgsectorService.create(domain);
        ATTENDENCEORMORGSECTORDTO dto = attendenceormorgsectorMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"ATTENDENCEORMORGSECTOR" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/attendenceormorgsectors/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ATTENDENCEORMORGSECTORDTO> attendenceormorgsectordtos) {
        attendenceormorgsectorService.createBatch(attendenceormorgsectorMapping.toDomain(attendenceormorgsectordtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#attendenceormorgsector_id,'Update',{'Sql',this.attendenceormorgsectorMapping,#attendenceormorgsectordto})")
    @ApiOperation(value = "Update", tags = {"ATTENDENCEORMORGSECTOR" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendenceormorgsectors/{attendenceormorgsector_id}")
    @Transactional
    public ResponseEntity<ATTENDENCEORMORGSECTORDTO> update(@PathVariable("attendenceormorgsector_id") String attendenceormorgsector_id, @RequestBody ATTENDENCEORMORGSECTORDTO attendenceormorgsectordto) {
		ATTENDENCEORMORGSECTOR domain = attendenceormorgsectorMapping.toDomain(attendenceormorgsectordto);
        domain.setAttendenceormorgsectorid(attendenceormorgsector_id);
		attendenceormorgsectorService.update(domain);
		ATTENDENCEORMORGSECTORDTO dto = attendenceormorgsectorMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"ATTENDENCEORMORGSECTOR" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendenceormorgsectors/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ATTENDENCEORMORGSECTORDTO> attendenceormorgsectordtos) {
        attendenceormorgsectorService.updateBatch(attendenceormorgsectorMapping.toDomain(attendenceormorgsectordtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDENCEORMORGSECTOR-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"ATTENDENCEORMORGSECTOR" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/attendenceormorgsectors/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ATTENDENCEORMORGSECTORDTO attendenceormorgsectordto) {
        return  ResponseEntity.status(HttpStatus.OK).body(attendenceormorgsectorService.checkKey(attendenceormorgsectorMapping.toDomain(attendenceormorgsectordto)));
    }

    @PreAuthorize("hasPermission(#attendenceormorgsector_id,'Remove',{'Sql',this.attendenceormorgsectorMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"ATTENDENCEORMORGSECTOR" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendenceormorgsectors/{attendenceormorgsector_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("attendenceormorgsector_id") String attendenceormorgsector_id) {
         return ResponseEntity.status(HttpStatus.OK).body(attendenceormorgsectorService.remove(attendenceormorgsector_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"ATTENDENCEORMORGSECTOR" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendenceormorgsectors/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        attendenceormorgsectorService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDENCEORMORGSECTOR-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"ATTENDENCEORMORGSECTOR" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/attendenceormorgsectors/getdraft")
    public ResponseEntity<ATTENDENCEORMORGSECTORDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(attendenceormorgsectorMapping.toDto(attendenceormorgsectorService.getDraft(new ATTENDENCEORMORGSECTOR())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDENCEORMORGSECTOR-Save-all')")
    @ApiOperation(value = "Save", tags = {"ATTENDENCEORMORGSECTOR" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/attendenceormorgsectors/save")
    public ResponseEntity<Boolean> save(@RequestBody ATTENDENCEORMORGSECTORDTO attendenceormorgsectordto) {
        return ResponseEntity.status(HttpStatus.OK).body(attendenceormorgsectorService.save(attendenceormorgsectorMapping.toDomain(attendenceormorgsectordto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"ATTENDENCEORMORGSECTOR" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/attendenceormorgsectors/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ATTENDENCEORMORGSECTORDTO> attendenceormorgsectordtos) {
        attendenceormorgsectorService.saveBatch(attendenceormorgsectorMapping.toDomain(attendenceormorgsectordtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDENCEORMORGSECTOR-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ATTENDENCEORMORGSECTOR" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/attendenceormorgsectors/fetchdefault")
	public ResponseEntity<List<ATTENDENCEORMORGSECTORDTO>> fetchDefault(ATTENDENCEORMORGSECTORSearchContext context) {
        Page<ATTENDENCEORMORGSECTOR> domains = attendenceormorgsectorService.searchDefault(context) ;
        List<ATTENDENCEORMORGSECTORDTO> list = attendenceormorgsectorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDENCEORMORGSECTOR-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ATTENDENCEORMORGSECTOR" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/attendenceormorgsectors/searchdefault")
	public ResponseEntity<Page<ATTENDENCEORMORGSECTORDTO>> searchDefault(@RequestBody ATTENDENCEORMORGSECTORSearchContext context) {
        Page<ATTENDENCEORMORGSECTOR> domains = attendenceormorgsectorService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendenceormorgsectorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
