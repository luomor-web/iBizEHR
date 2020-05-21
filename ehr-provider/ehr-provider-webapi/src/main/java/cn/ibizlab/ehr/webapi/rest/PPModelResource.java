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
import cn.ibizlab.ehr.core.common.domain.PPModel;
import cn.ibizlab.ehr.core.common.service.IPPModelService;
import cn.ibizlab.ehr.core.common.filter.PPModelSearchContext;




@Slf4j
@Api(tags = {"PPModel" })
@RestController("WebApi-ppmodel")
@RequestMapping("")
public class PPModelResource {

    @Autowired
    private IPPModelService ppmodelService;

    @Autowired
    @Lazy
    public PPModelMapping ppmodelMapping;

    public PPModelDTO permissionDTO=new PPModelDTO();




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PPModel-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PPModel" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ppmodels/getdraft")
    public ResponseEntity<PPModelDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ppmodelMapping.toDto(ppmodelService.getDraft(new PPModel())));
    }




    @PreAuthorize("hasPermission(#ppmodel_id,'Remove',{'Sql',this.ppmodelMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PPModel" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ppmodels/{ppmodel_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ppmodel_id") String ppmodel_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ppmodelService.remove(ppmodel_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PPModel" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ppmodels/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ppmodelService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PPModel-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PPModel" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ppmodels/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PPModelDTO ppmodeldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ppmodelService.checkKey(ppmodelMapping.toDomain(ppmodeldto)));
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PPModel-Save-all')")
    @ApiOperation(value = "Save", tags = {"PPModel" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ppmodels/save")
    public ResponseEntity<Boolean> save(@RequestBody PPModelDTO ppmodeldto) {
        return ResponseEntity.status(HttpStatus.OK).body(ppmodelService.save(ppmodelMapping.toDomain(ppmodeldto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PPModel" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ppmodels/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PPModelDTO> ppmodeldtos) {
        ppmodelService.saveBatch(ppmodelMapping.toDomain(ppmodeldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#ppmodel_id,'Get',{'Sql',this.ppmodelMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PPModel" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ppmodels/{ppmodel_id}")
    public ResponseEntity<PPModelDTO> get(@PathVariable("ppmodel_id") String ppmodel_id) {
        PPModel domain = ppmodelService.get(ppmodel_id);
        PPModelDTO dto = ppmodelMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.ppmodelMapping,#ppmodeldto})")
    @ApiOperation(value = "Create", tags = {"PPModel" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ppmodels")
    @Transactional
    public ResponseEntity<PPModelDTO> create(@RequestBody PPModelDTO ppmodeldto) {
        PPModel domain = ppmodelMapping.toDomain(ppmodeldto);
		ppmodelService.create(domain);
        PPModelDTO dto = ppmodelMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"PPModel" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ppmodels/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PPModelDTO> ppmodeldtos) {
        ppmodelService.createBatch(ppmodelMapping.toDomain(ppmodeldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#ppmodel_id,'Update',{'Sql',this.ppmodelMapping,#ppmodeldto})")
    @ApiOperation(value = "Update", tags = {"PPModel" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ppmodels/{ppmodel_id}")
    @Transactional
    public ResponseEntity<PPModelDTO> update(@PathVariable("ppmodel_id") String ppmodel_id, @RequestBody PPModelDTO ppmodeldto) {
		PPModel domain = ppmodelMapping.toDomain(ppmodeldto);
        domain.setPpmodelid(ppmodel_id);
		ppmodelService.update(domain);
		PPModelDTO dto = ppmodelMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"PPModel" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ppmodels/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PPModelDTO> ppmodeldtos) {
        ppmodelService.updateBatch(ppmodelMapping.toDomain(ppmodeldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PPModel-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PPModel" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ppmodels/fetchdefault")
	public ResponseEntity<List<PPModelDTO>> fetchDefault(PPModelSearchContext context) {
        Page<PPModel> domains = ppmodelService.searchDefault(context) ;
        List<PPModelDTO> list = ppmodelMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PPModel-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PPModel" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ppmodels/searchdefault")
	public ResponseEntity<Page<PPModelDTO>> searchDefault(@RequestBody PPModelSearchContext context) {
        Page<PPModel> domains = ppmodelService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ppmodelMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


