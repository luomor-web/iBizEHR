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
import cn.ibizlab.ehr.core.sal.domain.SALPLAN;
import cn.ibizlab.ehr.core.sal.service.ISALPLANService;
import cn.ibizlab.ehr.core.sal.filter.SALPLANSearchContext;




@Slf4j
@Api(tags = {"SALPLAN" })
@RestController("WebApi-salplan")
@RequestMapping("")
public class SALPLANResource {

    @Autowired
    private ISALPLANService salplanService;

    @Autowired
    @Lazy
    private SALPLANMapping salplanMapping;




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"SALPLAN" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/salplans")
    @Transactional
    public ResponseEntity<SALPLANDTO> create(@RequestBody SALPLANDTO salplandto) {
        SALPLAN domain = salplanMapping.toDomain(salplandto);
		salplanService.create(domain);
        SALPLANDTO dto = salplanMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"SALPLAN" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salplans/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SALPLANDTO> salplandtos) {
        salplanService.createBatch(salplanMapping.toDomain(salplandtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#salplan_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"SALPLAN" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salplans/{salplan_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salplan_id") String salplan_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salplanService.remove(salplan_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"SALPLAN" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salplans/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salplanService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"SALPLAN" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/salplans/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SALPLANDTO salplandto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salplanService.checkKey(salplanMapping.toDomain(salplandto)));
    }




    @ApiOperation(value = "Save", tags = {"SALPLAN" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/salplans/save")
    public ResponseEntity<Boolean> save(@RequestBody SALPLANDTO salplandto) {
        return ResponseEntity.status(HttpStatus.OK).body(salplanService.save(salplanMapping.toDomain(salplandto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"SALPLAN" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salplans/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SALPLANDTO> salplandtos) {
        salplanService.saveBatch(salplanMapping.toDomain(salplandtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"SALPLAN" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/salplans/getdraft")
    public ResponseEntity<SALPLANDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salplanMapping.toDto(salplanService.getDraft(new SALPLAN())));
    }




    @PreAuthorize("hasPermission(#salplan_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"SALPLAN" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/salplans/{salplan_id}")
    @Transactional
    public ResponseEntity<SALPLANDTO> update(@PathVariable("salplan_id") String salplan_id, @RequestBody SALPLANDTO salplandto) {
		SALPLAN domain = salplanMapping.toDomain(salplandto);
        domain.setSalplanid(salplan_id);
		salplanService.update(domain);
		SALPLANDTO dto = salplanMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#salplan_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"SALPLAN" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/salplans/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SALPLANDTO> salplandtos) {
        salplanService.updateBatch(salplanMapping.toDomain(salplandtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#salplan_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"SALPLAN" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/salplans/{salplan_id}")
    public ResponseEntity<SALPLANDTO> get(@PathVariable("salplan_id") String salplan_id) {
        SALPLAN domain = salplanService.get(salplan_id);
        SALPLANDTO dto = salplanMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"SALPLAN" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salplans/fetchdefault")
	public ResponseEntity<List<SALPLANDTO>> fetchDefault(SALPLANSearchContext context) {
        Page<SALPLAN> domains = salplanService.searchDefault(context) ;
        List<SALPLANDTO> list = salplanMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"SALPLAN" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salplans/searchdefault")
	public ResponseEntity<Page<SALPLANDTO>> searchDefault(@RequestBody SALPLANSearchContext context) {
        Page<SALPLAN> domains = salplanService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salplanMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public SALPLAN getEntity(){
        return new SALPLAN();
    }

}
