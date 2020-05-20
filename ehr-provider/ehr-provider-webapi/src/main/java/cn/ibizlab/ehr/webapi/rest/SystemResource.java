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
import cn.ibizlab.ehr.core.common.domain.System;
import cn.ibizlab.ehr.core.common.service.ISystemService;
import cn.ibizlab.ehr.core.common.filter.SystemSearchContext;




@Slf4j
@Api(tags = {"System" })
@RestController("WebApi-system")
@RequestMapping("")
public class SystemResource {

    @Autowired
    private ISystemService systemService;

    @Autowired
    @Lazy
    private SystemMapping systemMapping;




    @ApiOperation(value = "GetDraft", tags = {"System" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/systems/getdraft")
    public ResponseEntity<SystemDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(systemMapping.toDto(systemService.getDraft(new System())));
    }




    @PreAuthorize("hasPermission('Remove',{#system_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"System" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/systems/{system_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("system_id") String system_id) {
         return ResponseEntity.status(HttpStatus.OK).body(systemService.remove(system_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"System" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/systems/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        systemService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"System" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/systems/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SystemDTO systemdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(systemService.checkKey(systemMapping.toDomain(systemdto)));
    }




    @ApiOperation(value = "Save", tags = {"System" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/systems/save")
    public ResponseEntity<Boolean> save(@RequestBody SystemDTO systemdto) {
        return ResponseEntity.status(HttpStatus.OK).body(systemService.save(systemMapping.toDomain(systemdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"System" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/systems/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SystemDTO> systemdtos) {
        systemService.saveBatch(systemMapping.toDomain(systemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"System" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/systems")
    @Transactional
    public ResponseEntity<SystemDTO> create(@RequestBody SystemDTO systemdto) {
        System domain = systemMapping.toDomain(systemdto);
		systemService.create(domain);
        SystemDTO dto = systemMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"System" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/systems/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SystemDTO> systemdtos) {
        systemService.createBatch(systemMapping.toDomain(systemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#system_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"System" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/systems/{system_id}")
    public ResponseEntity<SystemDTO> get(@PathVariable("system_id") String system_id) {
        System domain = systemService.get(system_id);
        SystemDTO dto = systemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#system_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"System" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/systems/{system_id}")
    @Transactional
    public ResponseEntity<SystemDTO> update(@PathVariable("system_id") String system_id, @RequestBody SystemDTO systemdto) {
		System domain = systemMapping.toDomain(systemdto);
        domain.setSystemid(system_id);
		systemService.update(domain);
		SystemDTO dto = systemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#system_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"System" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/systems/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SystemDTO> systemdtos) {
        systemService.updateBatch(systemMapping.toDomain(systemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"System" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/systems/fetchdefault")
	public ResponseEntity<List<SystemDTO>> fetchDefault(SystemSearchContext context) {
        Page<System> domains = systemService.searchDefault(context) ;
        List<SystemDTO> list = systemMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"System" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/systems/searchdefault")
	public ResponseEntity<Page<SystemDTO>> searchDefault(@RequestBody SystemSearchContext context) {
        Page<System> domains = systemService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(systemMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public System getEntity(){
        return new System();
    }

}
