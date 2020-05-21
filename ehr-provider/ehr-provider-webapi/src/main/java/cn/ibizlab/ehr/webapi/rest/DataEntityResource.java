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
import cn.ibizlab.ehr.core.demodel.domain.DataEntity;
import cn.ibizlab.ehr.core.demodel.service.IDataEntityService;
import cn.ibizlab.ehr.core.demodel.filter.DataEntitySearchContext;




@Slf4j
@Api(tags = {"DataEntity" })
@RestController("WebApi-dataentity")
@RequestMapping("")
public class DataEntityResource {

    @Autowired
    private IDataEntityService dataentityService;

    @Autowired
    @Lazy
    public DataEntityMapping dataentityMapping;

    public DataEntityDTO permissionDTO=new DataEntityDTO();




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-DataEntity-InitUserRoleData-all')")
    @ApiOperation(value = "初始化角色数据对象", tags = {"DataEntity" },  notes = "初始化角色数据对象")
	@RequestMapping(method = RequestMethod.POST, value = "/dataentities/{dataentity_id}/inituserroledata")
    @Transactional
    public ResponseEntity<DataEntityDTO> initUserRoleData(@PathVariable("dataentity_id") String dataentity_id, @RequestBody DataEntityDTO dataentitydto) {
        DataEntity dataentity = dataentityMapping.toDomain(dataentitydto);
        dataentity = dataentityService.initUserRoleData(dataentity);
        dataentitydto = dataentityMapping.toDto(dataentity);
        return ResponseEntity.status(HttpStatus.OK).body(dataentitydto);
    }




    @PreAuthorize("hasPermission(#dataentity_id,'Remove',{'Sql',this.dataentityMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"DataEntity" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/dataentities/{dataentity_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("dataentity_id") String dataentity_id) {
         return ResponseEntity.status(HttpStatus.OK).body(dataentityService.remove(dataentity_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"DataEntity" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/dataentities/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        dataentityService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-DataEntity-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"DataEntity" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/dataentities/getdraft")
    public ResponseEntity<DataEntityDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(dataentityMapping.toDto(dataentityService.getDraft(new DataEntity())));
    }




    @PreAuthorize("hasPermission(#dataentity_id,'Get',{'Sql',this.dataentityMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"DataEntity" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/dataentities/{dataentity_id}")
    public ResponseEntity<DataEntityDTO> get(@PathVariable("dataentity_id") String dataentity_id) {
        DataEntity domain = dataentityService.get(dataentity_id);
        DataEntityDTO dto = dataentityMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-DataEntity-InitAll-all')")
    @ApiOperation(value = "初始化", tags = {"DataEntity" },  notes = "初始化")
	@RequestMapping(method = RequestMethod.POST, value = "/dataentities/{dataentity_id}/initall")
    @Transactional
    public ResponseEntity<DataEntityDTO> initAll(@PathVariable("dataentity_id") String dataentity_id, @RequestBody DataEntityDTO dataentitydto) {
        DataEntity dataentity = dataentityMapping.toDomain(dataentitydto);
        dataentity = dataentityService.initAll(dataentity);
        dataentitydto = dataentityMapping.toDto(dataentity);
        return ResponseEntity.status(HttpStatus.OK).body(dataentitydto);
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.dataentityMapping,#dataentitydto})")
    @ApiOperation(value = "Create", tags = {"DataEntity" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/dataentities")
    @Transactional
    public ResponseEntity<DataEntityDTO> create(@RequestBody DataEntityDTO dataentitydto) {
        DataEntity domain = dataentityMapping.toDomain(dataentitydto);
		dataentityService.create(domain);
        DataEntityDTO dto = dataentityMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"DataEntity" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/dataentities/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<DataEntityDTO> dataentitydtos) {
        dataentityService.createBatch(dataentityMapping.toDomain(dataentitydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-DataEntity-Save-all')")
    @ApiOperation(value = "Save", tags = {"DataEntity" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/dataentities/save")
    public ResponseEntity<Boolean> save(@RequestBody DataEntityDTO dataentitydto) {
        return ResponseEntity.status(HttpStatus.OK).body(dataentityService.save(dataentityMapping.toDomain(dataentitydto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"DataEntity" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/dataentities/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<DataEntityDTO> dataentitydtos) {
        dataentityService.saveBatch(dataentityMapping.toDomain(dataentitydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#dataentity_id,'Update',{'Sql',this.dataentityMapping,#dataentitydto})")
    @ApiOperation(value = "Update", tags = {"DataEntity" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/dataentities/{dataentity_id}")
    @Transactional
    public ResponseEntity<DataEntityDTO> update(@PathVariable("dataentity_id") String dataentity_id, @RequestBody DataEntityDTO dataentitydto) {
		DataEntity domain = dataentityMapping.toDomain(dataentitydto);
        domain.setDeid(dataentity_id);
		dataentityService.update(domain);
		DataEntityDTO dto = dataentityMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"DataEntity" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/dataentities/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<DataEntityDTO> dataentitydtos) {
        dataentityService.updateBatch(dataentityMapping.toDomain(dataentitydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-DataEntity-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"DataEntity" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/dataentities/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody DataEntityDTO dataentitydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(dataentityService.checkKey(dataentityMapping.toDomain(dataentitydto)));
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-DataEntity-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"DataEntity" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/dataentities/fetchdefault")
	public ResponseEntity<List<DataEntityDTO>> fetchDefault(DataEntitySearchContext context) {
        Page<DataEntity> domains = dataentityService.searchDefault(context) ;
        List<DataEntityDTO> list = dataentityMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-DataEntity-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"DataEntity" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/dataentities/searchdefault")
	public ResponseEntity<Page<DataEntityDTO>> searchDefault(@RequestBody DataEntitySearchContext context) {
        Page<DataEntity> domains = dataentityService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(dataentityMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


