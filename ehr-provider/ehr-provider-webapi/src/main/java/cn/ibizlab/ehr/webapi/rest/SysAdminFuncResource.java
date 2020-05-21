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
import cn.ibizlab.ehr.core.common.domain.SysAdminFunc;
import cn.ibizlab.ehr.core.common.service.ISysAdminFuncService;
import cn.ibizlab.ehr.core.common.filter.SysAdminFuncSearchContext;




@Slf4j
@Api(tags = {"SysAdminFunc" })
@RestController("WebApi-sysadminfunc")
@RequestMapping("")
public class SysAdminFuncResource {

    @Autowired
    private ISysAdminFuncService sysadminfuncService;

    @Autowired
    @Lazy
    public SysAdminFuncMapping sysadminfuncMapping;

    public SysAdminFuncDTO permissionDTO=new SysAdminFuncDTO();




    @PreAuthorize("hasPermission(#sysadminfunc_id,'Update',{'Sql',this.sysadminfuncMapping,#sysadminfuncdto})")
    @ApiOperation(value = "Update", tags = {"SysAdminFunc" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysadminfuncs/{sysadminfunc_id}")
    @Transactional
    public ResponseEntity<SysAdminFuncDTO> update(@PathVariable("sysadminfunc_id") String sysadminfunc_id, @RequestBody SysAdminFuncDTO sysadminfuncdto) {
		SysAdminFunc domain = sysadminfuncMapping.toDomain(sysadminfuncdto);
        domain.setSysadminfuncid(sysadminfunc_id);
		sysadminfuncService.update(domain);
		SysAdminFuncDTO dto = sysadminfuncMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"SysAdminFunc" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysadminfuncs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SysAdminFuncDTO> sysadminfuncdtos) {
        sysadminfuncService.updateBatch(sysadminfuncMapping.toDomain(sysadminfuncdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SysAdminFunc-Save-all')")
    @ApiOperation(value = "Save", tags = {"SysAdminFunc" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/sysadminfuncs/save")
    public ResponseEntity<Boolean> save(@RequestBody SysAdminFuncDTO sysadminfuncdto) {
        return ResponseEntity.status(HttpStatus.OK).body(sysadminfuncService.save(sysadminfuncMapping.toDomain(sysadminfuncdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"SysAdminFunc" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/sysadminfuncs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SysAdminFuncDTO> sysadminfuncdtos) {
        sysadminfuncService.saveBatch(sysadminfuncMapping.toDomain(sysadminfuncdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#sysadminfunc_id,'Remove',{'Sql',this.sysadminfuncMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"SysAdminFunc" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysadminfuncs/{sysadminfunc_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("sysadminfunc_id") String sysadminfunc_id) {
         return ResponseEntity.status(HttpStatus.OK).body(sysadminfuncService.remove(sysadminfunc_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"SysAdminFunc" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysadminfuncs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        sysadminfuncService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SysAdminFunc-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"SysAdminFunc" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/sysadminfuncs/getdraft")
    public ResponseEntity<SysAdminFuncDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(sysadminfuncMapping.toDto(sysadminfuncService.getDraft(new SysAdminFunc())));
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.sysadminfuncMapping,#sysadminfuncdto})")
    @ApiOperation(value = "Create", tags = {"SysAdminFunc" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/sysadminfuncs")
    @Transactional
    public ResponseEntity<SysAdminFuncDTO> create(@RequestBody SysAdminFuncDTO sysadminfuncdto) {
        SysAdminFunc domain = sysadminfuncMapping.toDomain(sysadminfuncdto);
		sysadminfuncService.create(domain);
        SysAdminFuncDTO dto = sysadminfuncMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"SysAdminFunc" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/sysadminfuncs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SysAdminFuncDTO> sysadminfuncdtos) {
        sysadminfuncService.createBatch(sysadminfuncMapping.toDomain(sysadminfuncdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#sysadminfunc_id,'Get',{'Sql',this.sysadminfuncMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"SysAdminFunc" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/sysadminfuncs/{sysadminfunc_id}")
    public ResponseEntity<SysAdminFuncDTO> get(@PathVariable("sysadminfunc_id") String sysadminfunc_id) {
        SysAdminFunc domain = sysadminfuncService.get(sysadminfunc_id);
        SysAdminFuncDTO dto = sysadminfuncMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SysAdminFunc-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"SysAdminFunc" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/sysadminfuncs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SysAdminFuncDTO sysadminfuncdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(sysadminfuncService.checkKey(sysadminfuncMapping.toDomain(sysadminfuncdto)));
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SysAdminFunc-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SysAdminFunc" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/sysadminfuncs/fetchdefault")
	public ResponseEntity<List<SysAdminFuncDTO>> fetchDefault(SysAdminFuncSearchContext context) {
        Page<SysAdminFunc> domains = sysadminfuncService.searchDefault(context) ;
        List<SysAdminFuncDTO> list = sysadminfuncMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SysAdminFunc-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SysAdminFunc" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/sysadminfuncs/searchdefault")
	public ResponseEntity<Page<SysAdminFuncDTO>> searchDefault(@RequestBody SysAdminFuncSearchContext context) {
        Page<SysAdminFunc> domains = sysadminfuncService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(sysadminfuncMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


