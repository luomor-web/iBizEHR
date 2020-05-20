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
import cn.ibizlab.ehr.core.pim.domain.ARCHIVESMANAGE;
import cn.ibizlab.ehr.core.pim.service.IARCHIVESMANAGEService;
import cn.ibizlab.ehr.core.pim.filter.ARCHIVESMANAGESearchContext;




@Slf4j
@Api(tags = {"ARCHIVESMANAGE" })
@RestController("WebApi-archivesmanage")
@RequestMapping("")
public class ARCHIVESMANAGEResource {

    @Autowired
    private IARCHIVESMANAGEService archivesmanageService;

    @Autowired
    @Lazy
    private ARCHIVESMANAGEMapping archivesmanageMapping;




    @PreAuthorize("hasPermission('Remove',{#archivesmanage_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"ARCHIVESMANAGE" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/archivesmanages/{archivesmanage_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("archivesmanage_id") String archivesmanage_id) {
         return ResponseEntity.status(HttpStatus.OK).body(archivesmanageService.remove(archivesmanage_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"ARCHIVESMANAGE" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/archivesmanages/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        archivesmanageService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"ARCHIVESMANAGE" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/archivesmanages/getdraft")
    public ResponseEntity<ARCHIVESMANAGEDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(archivesmanageMapping.toDto(archivesmanageService.getDraft(new ARCHIVESMANAGE())));
    }




    @PreAuthorize("hasPermission(#archivesmanage_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"ARCHIVESMANAGE" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/archivesmanages/{archivesmanage_id}")
    @Transactional
    public ResponseEntity<ARCHIVESMANAGEDTO> update(@PathVariable("archivesmanage_id") String archivesmanage_id, @RequestBody ARCHIVESMANAGEDTO archivesmanagedto) {
		ARCHIVESMANAGE domain = archivesmanageMapping.toDomain(archivesmanagedto);
        domain.setArchivesmanageid(archivesmanage_id);
		archivesmanageService.update(domain);
		ARCHIVESMANAGEDTO dto = archivesmanageMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#archivesmanage_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"ARCHIVESMANAGE" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/archivesmanages/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ARCHIVESMANAGEDTO> archivesmanagedtos) {
        archivesmanageService.updateBatch(archivesmanageMapping.toDomain(archivesmanagedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"ARCHIVESMANAGE" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/archivesmanages")
    @Transactional
    public ResponseEntity<ARCHIVESMANAGEDTO> create(@RequestBody ARCHIVESMANAGEDTO archivesmanagedto) {
        ARCHIVESMANAGE domain = archivesmanageMapping.toDomain(archivesmanagedto);
		archivesmanageService.create(domain);
        ARCHIVESMANAGEDTO dto = archivesmanageMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"ARCHIVESMANAGE" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/archivesmanages/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ARCHIVESMANAGEDTO> archivesmanagedtos) {
        archivesmanageService.createBatch(archivesmanageMapping.toDomain(archivesmanagedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"ARCHIVESMANAGE" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/archivesmanages/save")
    public ResponseEntity<Boolean> save(@RequestBody ARCHIVESMANAGEDTO archivesmanagedto) {
        return ResponseEntity.status(HttpStatus.OK).body(archivesmanageService.save(archivesmanageMapping.toDomain(archivesmanagedto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"ARCHIVESMANAGE" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/archivesmanages/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ARCHIVESMANAGEDTO> archivesmanagedtos) {
        archivesmanageService.saveBatch(archivesmanageMapping.toDomain(archivesmanagedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"ARCHIVESMANAGE" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/archivesmanages/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ARCHIVESMANAGEDTO archivesmanagedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(archivesmanageService.checkKey(archivesmanageMapping.toDomain(archivesmanagedto)));
    }




    @PreAuthorize("hasPermission(#archivesmanage_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"ARCHIVESMANAGE" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/archivesmanages/{archivesmanage_id}")
    public ResponseEntity<ARCHIVESMANAGEDTO> get(@PathVariable("archivesmanage_id") String archivesmanage_id) {
        ARCHIVESMANAGE domain = archivesmanageService.get(archivesmanage_id);
        ARCHIVESMANAGEDTO dto = archivesmanageMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"ARCHIVESMANAGE" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/archivesmanages/fetchdefault")
	public ResponseEntity<List<ARCHIVESMANAGEDTO>> fetchDefault(ARCHIVESMANAGESearchContext context) {
        Page<ARCHIVESMANAGE> domains = archivesmanageService.searchDefault(context) ;
        List<ARCHIVESMANAGEDTO> list = archivesmanageMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"ARCHIVESMANAGE" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/archivesmanages/searchdefault")
	public ResponseEntity<Page<ARCHIVESMANAGEDTO>> searchDefault(@RequestBody ARCHIVESMANAGESearchContext context) {
        Page<ARCHIVESMANAGE> domains = archivesmanageService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(archivesmanageMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public ARCHIVESMANAGE getEntity(){
        return new ARCHIVESMANAGE();
    }

}
