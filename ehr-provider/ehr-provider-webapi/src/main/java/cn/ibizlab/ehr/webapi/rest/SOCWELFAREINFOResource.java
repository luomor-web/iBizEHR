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
import cn.ibizlab.ehr.core.soc.domain.SOCWELFAREINFO;
import cn.ibizlab.ehr.core.soc.service.ISOCWELFAREINFOService;
import cn.ibizlab.ehr.core.soc.filter.SOCWELFAREINFOSearchContext;




@Slf4j
@Api(tags = {"SOCWELFAREINFO" })
@RestController("WebApi-socwelfareinfo")
@RequestMapping("")
public class SOCWELFAREINFOResource {

    @Autowired
    private ISOCWELFAREINFOService socwelfareinfoService;

    @Autowired
    @Lazy
    public SOCWELFAREINFOMapping socwelfareinfoMapping;

    public SOCWELFAREINFODTO permissionDTO=new SOCWELFAREINFODTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SOCWELFAREINFO-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"SOCWELFAREINFO" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/socwelfareinfos/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SOCWELFAREINFODTO socwelfareinfodto) {
        return  ResponseEntity.status(HttpStatus.OK).body(socwelfareinfoService.checkKey(socwelfareinfoMapping.toDomain(socwelfareinfodto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SOCWELFAREINFO-GetFJSJofPerson-all')")
    @ApiOperation(value = "获取人员的附加数据", tags = {"SOCWELFAREINFO" },  notes = "获取人员的附加数据")
	@RequestMapping(method = RequestMethod.GET, value = "/socwelfareinfos/{socwelfareinfo_id}/getfjsjofperson")
    @Transactional
    public ResponseEntity<SOCWELFAREINFODTO> getFJSJofPerson(@PathVariable("socwelfareinfo_id") String socwelfareinfo_id, @RequestBody SOCWELFAREINFODTO socwelfareinfodto) {
        SOCWELFAREINFO socwelfareinfo = socwelfareinfoMapping.toDomain(socwelfareinfodto);
        socwelfareinfo = socwelfareinfoService.getFJSJofPerson(socwelfareinfo);
        socwelfareinfodto = socwelfareinfoMapping.toDto(socwelfareinfo);
        return ResponseEntity.status(HttpStatus.OK).body(socwelfareinfodto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SOCWELFAREINFO-Save-all')")
    @ApiOperation(value = "Save", tags = {"SOCWELFAREINFO" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/socwelfareinfos/save")
    public ResponseEntity<Boolean> save(@RequestBody SOCWELFAREINFODTO socwelfareinfodto) {
        return ResponseEntity.status(HttpStatus.OK).body(socwelfareinfoService.save(socwelfareinfoMapping.toDomain(socwelfareinfodto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"SOCWELFAREINFO" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/socwelfareinfos/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SOCWELFAREINFODTO> socwelfareinfodtos) {
        socwelfareinfoService.saveBatch(socwelfareinfoMapping.toDomain(socwelfareinfodtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SOCWELFAREINFO-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"SOCWELFAREINFO" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/socwelfareinfos/getdraft")
    public ResponseEntity<SOCWELFAREINFODTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(socwelfareinfoMapping.toDto(socwelfareinfoService.getDraft(new SOCWELFAREINFO())));
    }

    @PreAuthorize("hasPermission(#socwelfareinfo_id,'Get',{'Sql',this.socwelfareinfoMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"SOCWELFAREINFO" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/socwelfareinfos/{socwelfareinfo_id}")
    public ResponseEntity<SOCWELFAREINFODTO> get(@PathVariable("socwelfareinfo_id") String socwelfareinfo_id) {
        SOCWELFAREINFO domain = socwelfareinfoService.get(socwelfareinfo_id);
        SOCWELFAREINFODTO dto = socwelfareinfoMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SOCWELFAREINFO-GetCBDofSOCCOMPANYWEL-all')")
    @ApiOperation(value = "获取单位社保账户的参保地", tags = {"SOCWELFAREINFO" },  notes = "获取单位社保账户的参保地")
	@RequestMapping(method = RequestMethod.GET, value = "/socwelfareinfos/{socwelfareinfo_id}/getcbdofsoccompanywel")
    @Transactional
    public ResponseEntity<SOCWELFAREINFODTO> getCBDofSOCCOMPANYWEL(@PathVariable("socwelfareinfo_id") String socwelfareinfo_id, @RequestBody SOCWELFAREINFODTO socwelfareinfodto) {
        SOCWELFAREINFO socwelfareinfo = socwelfareinfoMapping.toDomain(socwelfareinfodto);
        socwelfareinfo = socwelfareinfoService.getCBDofSOCCOMPANYWEL(socwelfareinfo);
        socwelfareinfodto = socwelfareinfoMapping.toDto(socwelfareinfo);
        return ResponseEntity.status(HttpStatus.OK).body(socwelfareinfodto);
    }

    @PreAuthorize("hasPermission(#socwelfareinfo_id,'Update',{'Sql',this.socwelfareinfoMapping,#socwelfareinfodto})")
    @ApiOperation(value = "Update", tags = {"SOCWELFAREINFO" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/socwelfareinfos/{socwelfareinfo_id}")
    @Transactional
    public ResponseEntity<SOCWELFAREINFODTO> update(@PathVariable("socwelfareinfo_id") String socwelfareinfo_id, @RequestBody SOCWELFAREINFODTO socwelfareinfodto) {
		SOCWELFAREINFO domain = socwelfareinfoMapping.toDomain(socwelfareinfodto);
        domain.setSocwelfareinfoid(socwelfareinfo_id);
		socwelfareinfoService.update(domain);
		SOCWELFAREINFODTO dto = socwelfareinfoMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"SOCWELFAREINFO" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/socwelfareinfos/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SOCWELFAREINFODTO> socwelfareinfodtos) {
        socwelfareinfoService.updateBatch(socwelfareinfoMapping.toDomain(socwelfareinfodtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#socwelfareinfo_id,'Remove',{'Sql',this.socwelfareinfoMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"SOCWELFAREINFO" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/socwelfareinfos/{socwelfareinfo_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("socwelfareinfo_id") String socwelfareinfo_id) {
         return ResponseEntity.status(HttpStatus.OK).body(socwelfareinfoService.remove(socwelfareinfo_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"SOCWELFAREINFO" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/socwelfareinfos/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        socwelfareinfoService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.socwelfareinfoMapping,#socwelfareinfodto})")
    @ApiOperation(value = "Create", tags = {"SOCWELFAREINFO" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/socwelfareinfos")
    @Transactional
    public ResponseEntity<SOCWELFAREINFODTO> create(@RequestBody SOCWELFAREINFODTO socwelfareinfodto) {
        SOCWELFAREINFO domain = socwelfareinfoMapping.toDomain(socwelfareinfodto);
		socwelfareinfoService.create(domain);
        SOCWELFAREINFODTO dto = socwelfareinfoMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"SOCWELFAREINFO" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/socwelfareinfos/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SOCWELFAREINFODTO> socwelfareinfodtos) {
        socwelfareinfoService.createBatch(socwelfareinfoMapping.toDomain(socwelfareinfodtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SOCWELFAREINFO-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SOCWELFAREINFO" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/socwelfareinfos/fetchdefault")
	public ResponseEntity<List<SOCWELFAREINFODTO>> fetchDefault(SOCWELFAREINFOSearchContext context) {
        Page<SOCWELFAREINFO> domains = socwelfareinfoService.searchDefault(context) ;
        List<SOCWELFAREINFODTO> list = socwelfareinfoMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SOCWELFAREINFO-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SOCWELFAREINFO" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/socwelfareinfos/searchdefault")
	public ResponseEntity<Page<SOCWELFAREINFODTO>> searchDefault(@RequestBody SOCWELFAREINFOSearchContext context) {
        Page<SOCWELFAREINFO> domains = socwelfareinfoService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(socwelfareinfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
