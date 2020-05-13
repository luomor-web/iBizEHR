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
import cn.ibizlab.ehr.core.pim.domain.PIMQUALMAJOR;
import cn.ibizlab.ehr.core.pim.service.IPIMQUALMAJORService;
import cn.ibizlab.ehr.core.pim.filter.PIMQUALMAJORSearchContext;




@Slf4j
@Api(tags = {"PIMQUALMAJOR" })
@RestController("WebApi-pimqualmajor")
@RequestMapping("")
public class PIMQUALMAJORResource {

    @Autowired
    private IPIMQUALMAJORService pimqualmajorService;

    @Autowired
    @Lazy
    private PIMQUALMAJORMapping pimqualmajorMapping;




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PIMQUALMAJOR" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimqualmajors")
    @Transactional
    public ResponseEntity<PIMQUALMAJORDTO> create(@RequestBody PIMQUALMAJORDTO pimqualmajordto) {
        PIMQUALMAJOR domain = pimqualmajorMapping.toDomain(pimqualmajordto);
		pimqualmajorService.create(domain);
        PIMQUALMAJORDTO dto = pimqualmajorMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PIMQUALMAJOR" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimqualmajors/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMQUALMAJORDTO> pimqualmajordtos) {
        pimqualmajorService.createBatch(pimqualmajorMapping.toDomain(pimqualmajordtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"PIMQUALMAJOR" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimqualmajors/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMQUALMAJORDTO pimqualmajordto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimqualmajorService.checkKey(pimqualmajorMapping.toDomain(pimqualmajordto)));
    }




    @PreAuthorize("hasPermission(#pimqualmajor_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PIMQUALMAJOR" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimqualmajors/{pimqualmajor_id}")
    @Transactional
    public ResponseEntity<PIMQUALMAJORDTO> update(@PathVariable("pimqualmajor_id") String pimqualmajor_id, @RequestBody PIMQUALMAJORDTO pimqualmajordto) {
		PIMQUALMAJOR domain = pimqualmajorMapping.toDomain(pimqualmajordto);
        domain.setPimqualmajorid(pimqualmajor_id);
		pimqualmajorService.update(domain);
		PIMQUALMAJORDTO dto = pimqualmajorMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pimqualmajor_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMQUALMAJOR" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimqualmajors/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMQUALMAJORDTO> pimqualmajordtos) {
        pimqualmajorService.updateBatch(pimqualmajorMapping.toDomain(pimqualmajordtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#pimqualmajor_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PIMQUALMAJOR" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimqualmajors/{pimqualmajor_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimqualmajor_id") String pimqualmajor_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimqualmajorService.remove(pimqualmajor_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PIMQUALMAJOR" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimqualmajors/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimqualmajorService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PIMQUALMAJOR" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimqualmajors/getdraft")
    public ResponseEntity<PIMQUALMAJORDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimqualmajorMapping.toDto(pimqualmajorService.getDraft(new PIMQUALMAJOR())));
    }




    @ApiOperation(value = "Save", tags = {"PIMQUALMAJOR" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimqualmajors/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMQUALMAJORDTO pimqualmajordto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimqualmajorService.save(pimqualmajorMapping.toDomain(pimqualmajordto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PIMQUALMAJOR" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimqualmajors/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMQUALMAJORDTO> pimqualmajordtos) {
        pimqualmajorService.saveBatch(pimqualmajorMapping.toDomain(pimqualmajordtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pimqualmajor_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PIMQUALMAJOR" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimqualmajors/{pimqualmajor_id}")
    public ResponseEntity<PIMQUALMAJORDTO> get(@PathVariable("pimqualmajor_id") String pimqualmajor_id) {
        PIMQUALMAJOR domain = pimqualmajorService.get(pimqualmajor_id);
        PIMQUALMAJORDTO dto = pimqualmajorMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMQUALMAJOR" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimqualmajors/fetchdefault")
	public ResponseEntity<List<PIMQUALMAJORDTO>> fetchDefault(PIMQUALMAJORSearchContext context) {
        Page<PIMQUALMAJOR> domains = pimqualmajorService.searchDefault(context) ;
        List<PIMQUALMAJORDTO> list = pimqualmajorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMQUALMAJOR" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimqualmajors/searchdefault")
	public ResponseEntity<Page<PIMQUALMAJORDTO>> searchDefault(PIMQUALMAJORSearchContext context) {
        Page<PIMQUALMAJOR> domains = pimqualmajorService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimqualmajorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'XZZGZY',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch选择资格类别下对应的资格专业", tags = {"PIMQUALMAJOR" } ,notes = "fetch选择资格类别下对应的资格专业")
    @RequestMapping(method= RequestMethod.GET , value="/pimqualmajors/fetchxzzgzy")
	public ResponseEntity<List<PIMQUALMAJORDTO>> fetchXZZGZY(PIMQUALMAJORSearchContext context) {
        Page<PIMQUALMAJOR> domains = pimqualmajorService.searchXZZGZY(context) ;
        List<PIMQUALMAJORDTO> list = pimqualmajorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'XZZGZY',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search选择资格类别下对应的资格专业", tags = {"PIMQUALMAJOR" } ,notes = "search选择资格类别下对应的资格专业")
    @RequestMapping(method= RequestMethod.GET , value="/pimqualmajors/searchxzzgzy")
	public ResponseEntity<Page<PIMQUALMAJORDTO>> searchXZZGZY(PIMQUALMAJORSearchContext context) {
        Page<PIMQUALMAJOR> domains = pimqualmajorService.searchXZZGZY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimqualmajorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PIMQUALMAJOR getEntity(){
        return new PIMQUALMAJOR();
    }

}
