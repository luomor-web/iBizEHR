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
import cn.ibizlab.ehr.core.pim.domain.PIMCITY;
import cn.ibizlab.ehr.core.pim.service.IPIMCITYService;
import cn.ibizlab.ehr.core.pim.filter.PIMCITYSearchContext;




@Slf4j
@Api(tags = {"PIMCITY" })
@RestController("WebApi-pimcity")
@RequestMapping("")
public class PIMCITYResource {

    @Autowired
    private IPIMCITYService pimcityService;

    @Autowired
    @Lazy
    private PIMCITYMapping pimcityMapping;




    @ApiOperation(value = "CheckKey", tags = {"PIMCITY" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcities/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMCITYDTO pimcitydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimcityService.checkKey(pimcityMapping.toDomain(pimcitydto)));
    }




    @PreAuthorize("hasPermission('Remove',{#pimcity_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PIMCITY" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimcities/{pimcity_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimcity_id") String pimcity_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimcityService.remove(pimcity_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PIMCITY" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimcities/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimcityService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PIMCITY" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimcities/getdraft")
    public ResponseEntity<PIMCITYDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimcityMapping.toDto(pimcityService.getDraft(new PIMCITY())));
    }




    @PreAuthorize("hasPermission(#pimcity_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PIMCITY" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimcities/{pimcity_id}")
    @Transactional
    public ResponseEntity<PIMCITYDTO> update(@PathVariable("pimcity_id") String pimcity_id, @RequestBody PIMCITYDTO pimcitydto) {
		PIMCITY domain = pimcityMapping.toDomain(pimcitydto);
        domain.setPimcityid(pimcity_id);
		pimcityService.update(domain);
		PIMCITYDTO dto = pimcityMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pimcity_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMCITY" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimcities/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMCITYDTO> pimcitydtos) {
        pimcityService.updateBatch(pimcityMapping.toDomain(pimcitydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"PIMCITY" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcities/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMCITYDTO pimcitydto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimcityService.save(pimcityMapping.toDomain(pimcitydto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PIMCITY" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcities/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMCITYDTO> pimcitydtos) {
        pimcityService.saveBatch(pimcityMapping.toDomain(pimcitydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pimcity_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PIMCITY" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimcities/{pimcity_id}")
    public ResponseEntity<PIMCITYDTO> get(@PathVariable("pimcity_id") String pimcity_id) {
        PIMCITY domain = pimcityService.get(pimcity_id);
        PIMCITYDTO dto = pimcityMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PIMCITY" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcities")
    @Transactional
    public ResponseEntity<PIMCITYDTO> create(@RequestBody PIMCITYDTO pimcitydto) {
        PIMCITY domain = pimcityMapping.toDomain(pimcitydto);
		pimcityService.create(domain);
        PIMCITYDTO dto = pimcityMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PIMCITY" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcities/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMCITYDTO> pimcitydtos) {
        pimcityService.createBatch(pimcityMapping.toDomain(pimcitydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMCITY" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimcities/fetchdefault")
	public ResponseEntity<List<PIMCITYDTO>> fetchDefault(PIMCITYSearchContext context) {
        Page<PIMCITY> domains = pimcityService.searchDefault(context) ;
        List<PIMCITYDTO> list = pimcityMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMCITY" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimcities/searchdefault")
	public ResponseEntity<Page<PIMCITYDTO>> searchDefault(PIMCITYSearchContext context) {
        Page<PIMCITY> domains = pimcityService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcityMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PIMCITY getEntity(){
        return new PIMCITY();
    }

}
