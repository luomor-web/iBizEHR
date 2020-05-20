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
import cn.ibizlab.ehr.core.pim.domain.ARCHIVALCATALOGUE;
import cn.ibizlab.ehr.core.pim.service.IARCHIVALCATALOGUEService;
import cn.ibizlab.ehr.core.pim.filter.ARCHIVALCATALOGUESearchContext;




@Slf4j
@Api(tags = {"ARCHIVALCATALOGUE" })
@RestController("WebApi-archivalcatalogue")
@RequestMapping("")
public class ARCHIVALCATALOGUEResource {

    @Autowired
    private IARCHIVALCATALOGUEService archivalcatalogueService;

    @Autowired
    @Lazy
    private ARCHIVALCATALOGUEMapping archivalcatalogueMapping;




    @ApiOperation(value = "Save", tags = {"ARCHIVALCATALOGUE" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/archivalcatalogues/save")
    public ResponseEntity<Boolean> save(@RequestBody ARCHIVALCATALOGUEDTO archivalcataloguedto) {
        return ResponseEntity.status(HttpStatus.OK).body(archivalcatalogueService.save(archivalcatalogueMapping.toDomain(archivalcataloguedto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"ARCHIVALCATALOGUE" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/archivalcatalogues/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ARCHIVALCATALOGUEDTO> archivalcataloguedtos) {
        archivalcatalogueService.saveBatch(archivalcatalogueMapping.toDomain(archivalcataloguedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"ARCHIVALCATALOGUE" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/archivalcatalogues/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ARCHIVALCATALOGUEDTO archivalcataloguedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(archivalcatalogueService.checkKey(archivalcatalogueMapping.toDomain(archivalcataloguedto)));
    }




    @PreAuthorize("hasPermission(#archivalcatalogue_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"ARCHIVALCATALOGUE" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/archivalcatalogues/{archivalcatalogue_id}")
    public ResponseEntity<ARCHIVALCATALOGUEDTO> get(@PathVariable("archivalcatalogue_id") String archivalcatalogue_id) {
        ARCHIVALCATALOGUE domain = archivalcatalogueService.get(archivalcatalogue_id);
        ARCHIVALCATALOGUEDTO dto = archivalcatalogueMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "GetDraft", tags = {"ARCHIVALCATALOGUE" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/archivalcatalogues/getdraft")
    public ResponseEntity<ARCHIVALCATALOGUEDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(archivalcatalogueMapping.toDto(archivalcatalogueService.getDraft(new ARCHIVALCATALOGUE())));
    }




    @PreAuthorize("hasPermission('Remove',{#archivalcatalogue_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"ARCHIVALCATALOGUE" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/archivalcatalogues/{archivalcatalogue_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("archivalcatalogue_id") String archivalcatalogue_id) {
         return ResponseEntity.status(HttpStatus.OK).body(archivalcatalogueService.remove(archivalcatalogue_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"ARCHIVALCATALOGUE" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/archivalcatalogues/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        archivalcatalogueService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#archivalcatalogue_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"ARCHIVALCATALOGUE" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/archivalcatalogues/{archivalcatalogue_id}")
    @Transactional
    public ResponseEntity<ARCHIVALCATALOGUEDTO> update(@PathVariable("archivalcatalogue_id") String archivalcatalogue_id, @RequestBody ARCHIVALCATALOGUEDTO archivalcataloguedto) {
		ARCHIVALCATALOGUE domain = archivalcatalogueMapping.toDomain(archivalcataloguedto);
        domain.setArchivalcatalogueid(archivalcatalogue_id);
		archivalcatalogueService.update(domain);
		ARCHIVALCATALOGUEDTO dto = archivalcatalogueMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#archivalcatalogue_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"ARCHIVALCATALOGUE" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/archivalcatalogues/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ARCHIVALCATALOGUEDTO> archivalcataloguedtos) {
        archivalcatalogueService.updateBatch(archivalcatalogueMapping.toDomain(archivalcataloguedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"ARCHIVALCATALOGUE" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/archivalcatalogues")
    @Transactional
    public ResponseEntity<ARCHIVALCATALOGUEDTO> create(@RequestBody ARCHIVALCATALOGUEDTO archivalcataloguedto) {
        ARCHIVALCATALOGUE domain = archivalcatalogueMapping.toDomain(archivalcataloguedto);
		archivalcatalogueService.create(domain);
        ARCHIVALCATALOGUEDTO dto = archivalcatalogueMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"ARCHIVALCATALOGUE" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/archivalcatalogues/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ARCHIVALCATALOGUEDTO> archivalcataloguedtos) {
        archivalcatalogueService.createBatch(archivalcatalogueMapping.toDomain(archivalcataloguedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"ARCHIVALCATALOGUE" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/archivalcatalogues/fetchdefault")
	public ResponseEntity<List<ARCHIVALCATALOGUEDTO>> fetchDefault(ARCHIVALCATALOGUESearchContext context) {
        Page<ARCHIVALCATALOGUE> domains = archivalcatalogueService.searchDefault(context) ;
        List<ARCHIVALCATALOGUEDTO> list = archivalcatalogueMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"ARCHIVALCATALOGUE" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/archivalcatalogues/searchdefault")
	public ResponseEntity<Page<ARCHIVALCATALOGUEDTO>> searchDefault(@RequestBody ARCHIVALCATALOGUESearchContext context) {
        Page<ARCHIVALCATALOGUE> domains = archivalcatalogueService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(archivalcatalogueMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public ARCHIVALCATALOGUE getEntity(){
        return new ARCHIVALCATALOGUE();
    }

}
