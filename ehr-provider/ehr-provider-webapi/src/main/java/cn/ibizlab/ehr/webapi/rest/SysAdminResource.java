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
import cn.ibizlab.ehr.core.common.domain.SysAdmin;
import cn.ibizlab.ehr.core.common.service.ISysAdminService;
import cn.ibizlab.ehr.core.common.filter.SysAdminSearchContext;




@Slf4j
@Api(tags = {"SysAdmin" })
@RestController("WebApi-sysadmin")
@RequestMapping("")
public class SysAdminResource {

    @Autowired
    private ISysAdminService sysadminService;

    @Autowired
    @Lazy
    public SysAdminMapping sysadminMapping;

    public SysAdminDTO permissionDTO=new SysAdminDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SysAdmin-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"SysAdmin" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/sysadmins/getdraft")
    public ResponseEntity<SysAdminDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(sysadminMapping.toDto(sysadminService.getDraft(new SysAdmin())));
    }

    @PreAuthorize("hasPermission(#sysadmin_id,'Update',{'Sql',this.sysadminMapping,#sysadmindto})")
    @ApiOperation(value = "Update", tags = {"SysAdmin" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysadmins/{sysadmin_id}")
    @Transactional
    public ResponseEntity<SysAdminDTO> update(@PathVariable("sysadmin_id") String sysadmin_id, @RequestBody SysAdminDTO sysadmindto) {
		SysAdmin domain = sysadminMapping.toDomain(sysadmindto);
        domain.setSysadminid(sysadmin_id);
		sysadminService.update(domain);
		SysAdminDTO dto = sysadminMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"SysAdmin" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysadmins/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SysAdminDTO> sysadmindtos) {
        sysadminService.updateBatch(sysadminMapping.toDomain(sysadmindtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.sysadminMapping,#sysadmindto})")
    @ApiOperation(value = "Create", tags = {"SysAdmin" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/sysadmins")
    @Transactional
    public ResponseEntity<SysAdminDTO> create(@RequestBody SysAdminDTO sysadmindto) {
        SysAdmin domain = sysadminMapping.toDomain(sysadmindto);
		sysadminService.create(domain);
        SysAdminDTO dto = sysadminMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"SysAdmin" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/sysadmins/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SysAdminDTO> sysadmindtos) {
        sysadminService.createBatch(sysadminMapping.toDomain(sysadmindtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#sysadmin_id,'Remove',{'Sql',this.sysadminMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"SysAdmin" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysadmins/{sysadmin_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("sysadmin_id") String sysadmin_id) {
         return ResponseEntity.status(HttpStatus.OK).body(sysadminService.remove(sysadmin_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"SysAdmin" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysadmins/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        sysadminService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#sysadmin_id,'Get',{'Sql',this.sysadminMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"SysAdmin" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/sysadmins/{sysadmin_id}")
    public ResponseEntity<SysAdminDTO> get(@PathVariable("sysadmin_id") String sysadmin_id) {
        SysAdmin domain = sysadminService.get(sysadmin_id);
        SysAdminDTO dto = sysadminMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SysAdmin-Save-all')")
    @ApiOperation(value = "Save", tags = {"SysAdmin" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/sysadmins/save")
    public ResponseEntity<Boolean> save(@RequestBody SysAdminDTO sysadmindto) {
        return ResponseEntity.status(HttpStatus.OK).body(sysadminService.save(sysadminMapping.toDomain(sysadmindto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"SysAdmin" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/sysadmins/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SysAdminDTO> sysadmindtos) {
        sysadminService.saveBatch(sysadminMapping.toDomain(sysadmindtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SysAdmin-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"SysAdmin" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/sysadmins/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SysAdminDTO sysadmindto) {
        return  ResponseEntity.status(HttpStatus.OK).body(sysadminService.checkKey(sysadminMapping.toDomain(sysadmindto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SysAdmin-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SysAdmin" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/sysadmins/fetchdefault")
	public ResponseEntity<List<SysAdminDTO>> fetchDefault(SysAdminSearchContext context) {
        Page<SysAdmin> domains = sysadminService.searchDefault(context) ;
        List<SysAdminDTO> list = sysadminMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SysAdmin-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SysAdmin" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/sysadmins/searchdefault")
	public ResponseEntity<Page<SysAdminDTO>> searchDefault(@RequestBody SysAdminSearchContext context) {
        Page<SysAdmin> domains = sysadminService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(sysadminMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
