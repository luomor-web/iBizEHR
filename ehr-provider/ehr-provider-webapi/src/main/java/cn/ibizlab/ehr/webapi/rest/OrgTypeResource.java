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
import cn.ibizlab.ehr.core.common.domain.OrgType;
import cn.ibizlab.ehr.core.common.service.IOrgTypeService;
import cn.ibizlab.ehr.core.common.filter.OrgTypeSearchContext;




@Slf4j
@Api(tags = {"OrgType" })
@RestController("WebApi-orgtype")
@RequestMapping("")
public class OrgTypeResource {

    @Autowired
    private IOrgTypeService orgtypeService;

    @Autowired
    @Lazy
    public OrgTypeMapping orgtypeMapping;

    public OrgTypeDTO permissionDTO=new OrgTypeDTO();




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgType-Save-all')")
    @ApiOperation(value = "Save", tags = {"OrgType" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/orgtypes/save")
    public ResponseEntity<Boolean> save(@RequestBody OrgTypeDTO orgtypedto) {
        return ResponseEntity.status(HttpStatus.OK).body(orgtypeService.save(orgtypeMapping.toDomain(orgtypedto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"OrgType" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/orgtypes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrgTypeDTO> orgtypedtos) {
        orgtypeService.saveBatch(orgtypeMapping.toDomain(orgtypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgType-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"OrgType" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/orgtypes/getdraft")
    public ResponseEntity<OrgTypeDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(orgtypeMapping.toDto(orgtypeService.getDraft(new OrgType())));
    }




    @PreAuthorize("hasPermission(#orgtype_id,'Remove',{'Sql',this.orgtypeMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"OrgType" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/orgtypes/{orgtype_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("orgtype_id") String orgtype_id) {
         return ResponseEntity.status(HttpStatus.OK).body(orgtypeService.remove(orgtype_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"OrgType" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/orgtypes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        orgtypeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#orgtype_id,'Get',{'Sql',this.orgtypeMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"OrgType" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/orgtypes/{orgtype_id}")
    public ResponseEntity<OrgTypeDTO> get(@PathVariable("orgtype_id") String orgtype_id) {
        OrgType domain = orgtypeService.get(orgtype_id);
        OrgTypeDTO dto = orgtypeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#orgtype_id,'Update',{'Sql',this.orgtypeMapping,#orgtypedto})")
    @ApiOperation(value = "Update", tags = {"OrgType" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/orgtypes/{orgtype_id}")
    @Transactional
    public ResponseEntity<OrgTypeDTO> update(@PathVariable("orgtype_id") String orgtype_id, @RequestBody OrgTypeDTO orgtypedto) {
		OrgType domain = orgtypeMapping.toDomain(orgtypedto);
        domain.setOrgtypeid(orgtype_id);
		orgtypeService.update(domain);
		OrgTypeDTO dto = orgtypeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"OrgType" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/orgtypes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrgTypeDTO> orgtypedtos) {
        orgtypeService.updateBatch(orgtypeMapping.toDomain(orgtypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.orgtypeMapping,#orgtypedto})")
    @ApiOperation(value = "Create", tags = {"OrgType" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/orgtypes")
    @Transactional
    public ResponseEntity<OrgTypeDTO> create(@RequestBody OrgTypeDTO orgtypedto) {
        OrgType domain = orgtypeMapping.toDomain(orgtypedto);
		orgtypeService.create(domain);
        OrgTypeDTO dto = orgtypeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"OrgType" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/orgtypes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrgTypeDTO> orgtypedtos) {
        orgtypeService.createBatch(orgtypeMapping.toDomain(orgtypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgType-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"OrgType" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/orgtypes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrgTypeDTO orgtypedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(orgtypeService.checkKey(orgtypeMapping.toDomain(orgtypedto)));
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgType-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"OrgType" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/orgtypes/fetchdefault")
	public ResponseEntity<List<OrgTypeDTO>> fetchDefault(OrgTypeSearchContext context) {
        Page<OrgType> domains = orgtypeService.searchDefault(context) ;
        List<OrgTypeDTO> list = orgtypeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrgType-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"OrgType" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/orgtypes/searchdefault")
	public ResponseEntity<Page<OrgTypeDTO>> searchDefault(@RequestBody OrgTypeSearchContext context) {
        Page<OrgType> domains = orgtypeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(orgtypeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


