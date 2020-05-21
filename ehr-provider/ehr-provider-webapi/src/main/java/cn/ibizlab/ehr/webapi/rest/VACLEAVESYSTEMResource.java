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
import cn.ibizlab.ehr.core.vac.domain.VACLEAVESYSTEM;
import cn.ibizlab.ehr.core.vac.service.IVACLEAVESYSTEMService;
import cn.ibizlab.ehr.core.vac.filter.VACLEAVESYSTEMSearchContext;




@Slf4j
@Api(tags = {"VACLEAVESYSTEM" })
@RestController("WebApi-vacleavesystem")
@RequestMapping("")
public class VACLEAVESYSTEMResource {

    @Autowired
    private IVACLEAVESYSTEMService vacleavesystemService;

    @Autowired
    @Lazy
    public VACLEAVESYSTEMMapping vacleavesystemMapping;

    public VACLEAVESYSTEMDTO permissionDTO=new VACLEAVESYSTEMDTO();




    @PreAuthorize("hasPermission(#vacleavesystem_id,'Get',{'Sql',this.vacleavesystemMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"VACLEAVESYSTEM" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/vacleavesystems/{vacleavesystem_id}")
    public ResponseEntity<VACLEAVESYSTEMDTO> get(@PathVariable("vacleavesystem_id") String vacleavesystem_id) {
        VACLEAVESYSTEM domain = vacleavesystemService.get(vacleavesystem_id);
        VACLEAVESYSTEMDTO dto = vacleavesystemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.vacleavesystemMapping,#vacleavesystemdto})")
    @ApiOperation(value = "Create", tags = {"VACLEAVESYSTEM" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavesystems")
    @Transactional
    public ResponseEntity<VACLEAVESYSTEMDTO> create(@RequestBody VACLEAVESYSTEMDTO vacleavesystemdto) {
        VACLEAVESYSTEM domain = vacleavesystemMapping.toDomain(vacleavesystemdto);
		vacleavesystemService.create(domain);
        VACLEAVESYSTEMDTO dto = vacleavesystemMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"VACLEAVESYSTEM" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavesystems/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VACLEAVESYSTEMDTO> vacleavesystemdtos) {
        vacleavesystemService.createBatch(vacleavesystemMapping.toDomain(vacleavesystemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVESYSTEM-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"VACLEAVESYSTEM" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/vacleavesystems/getdraft")
    public ResponseEntity<VACLEAVESYSTEMDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacleavesystemMapping.toDto(vacleavesystemService.getDraft(new VACLEAVESYSTEM())));
    }




    @PreAuthorize("hasPermission(#vacleavesystem_id,'Update',{'Sql',this.vacleavesystemMapping,#vacleavesystemdto})")
    @ApiOperation(value = "Update", tags = {"VACLEAVESYSTEM" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacleavesystems/{vacleavesystem_id}")
    @Transactional
    public ResponseEntity<VACLEAVESYSTEMDTO> update(@PathVariable("vacleavesystem_id") String vacleavesystem_id, @RequestBody VACLEAVESYSTEMDTO vacleavesystemdto) {
		VACLEAVESYSTEM domain = vacleavesystemMapping.toDomain(vacleavesystemdto);
        domain.setVacleavesystemid(vacleavesystem_id);
		vacleavesystemService.update(domain);
		VACLEAVESYSTEMDTO dto = vacleavesystemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"VACLEAVESYSTEM" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacleavesystems/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VACLEAVESYSTEMDTO> vacleavesystemdtos) {
        vacleavesystemService.updateBatch(vacleavesystemMapping.toDomain(vacleavesystemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#vacleavesystem_id,'Remove',{'Sql',this.vacleavesystemMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"VACLEAVESYSTEM" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacleavesystems/{vacleavesystem_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacleavesystem_id") String vacleavesystem_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacleavesystemService.remove(vacleavesystem_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"VACLEAVESYSTEM" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacleavesystems/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacleavesystemService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVESYSTEM-Save-all')")
    @ApiOperation(value = "Save", tags = {"VACLEAVESYSTEM" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavesystems/save")
    public ResponseEntity<Boolean> save(@RequestBody VACLEAVESYSTEMDTO vacleavesystemdto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacleavesystemService.save(vacleavesystemMapping.toDomain(vacleavesystemdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"VACLEAVESYSTEM" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavesystems/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VACLEAVESYSTEMDTO> vacleavesystemdtos) {
        vacleavesystemService.saveBatch(vacleavesystemMapping.toDomain(vacleavesystemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVESYSTEM-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"VACLEAVESYSTEM" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavesystems/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VACLEAVESYSTEMDTO vacleavesystemdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacleavesystemService.checkKey(vacleavesystemMapping.toDomain(vacleavesystemdto)));
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVESYSTEM-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"VACLEAVESYSTEM" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacleavesystems/fetchdefault")
	public ResponseEntity<List<VACLEAVESYSTEMDTO>> fetchDefault(VACLEAVESYSTEMSearchContext context) {
        Page<VACLEAVESYSTEM> domains = vacleavesystemService.searchDefault(context) ;
        List<VACLEAVESYSTEMDTO> list = vacleavesystemMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVESYSTEM-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"VACLEAVESYSTEM" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacleavesystems/searchdefault")
	public ResponseEntity<Page<VACLEAVESYSTEMDTO>> searchDefault(@RequestBody VACLEAVESYSTEMSearchContext context) {
        Page<VACLEAVESYSTEM> domains = vacleavesystemService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleavesystemMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


