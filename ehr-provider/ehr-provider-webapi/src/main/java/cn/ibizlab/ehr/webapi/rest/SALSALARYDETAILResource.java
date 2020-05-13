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
import cn.ibizlab.ehr.core.sal.domain.SALSALARYDETAIL;
import cn.ibizlab.ehr.core.sal.service.ISALSALARYDETAILService;
import cn.ibizlab.ehr.core.sal.filter.SALSALARYDETAILSearchContext;




@Slf4j
@Api(tags = {"SALSALARYDETAIL" })
@RestController("WebApi-salsalarydetail")
@RequestMapping("")
public class SALSALARYDETAILResource {

    @Autowired
    private ISALSALARYDETAILService salsalarydetailService;

    @Autowired
    @Lazy
    private SALSALARYDETAILMapping salsalarydetailMapping;




    @PreAuthorize("hasPermission(#salsalarydetail_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"SALSALARYDETAIL" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/salsalarydetails/{salsalarydetail_id}")
    @Transactional
    public ResponseEntity<SALSALARYDETAILDTO> update(@PathVariable("salsalarydetail_id") String salsalarydetail_id, @RequestBody SALSALARYDETAILDTO salsalarydetaildto) {
		SALSALARYDETAIL domain = salsalarydetailMapping.toDomain(salsalarydetaildto);
        domain.setSalsalarydetailid(salsalarydetail_id);
		salsalarydetailService.update(domain);
		SALSALARYDETAILDTO dto = salsalarydetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#salsalarydetail_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"SALSALARYDETAIL" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/salsalarydetails/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SALSALARYDETAILDTO> salsalarydetaildtos) {
        salsalarydetailService.updateBatch(salsalarydetailMapping.toDomain(salsalarydetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"SALSALARYDETAIL" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/salsalarydetails")
    @Transactional
    public ResponseEntity<SALSALARYDETAILDTO> create(@RequestBody SALSALARYDETAILDTO salsalarydetaildto) {
        SALSALARYDETAIL domain = salsalarydetailMapping.toDomain(salsalarydetaildto);
		salsalarydetailService.create(domain);
        SALSALARYDETAILDTO dto = salsalarydetailMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"SALSALARYDETAIL" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salsalarydetails/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SALSALARYDETAILDTO> salsalarydetaildtos) {
        salsalarydetailService.createBatch(salsalarydetailMapping.toDomain(salsalarydetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"SALSALARYDETAIL" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/salsalarydetails/getdraft")
    public ResponseEntity<SALSALARYDETAILDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salsalarydetailMapping.toDto(salsalarydetailService.getDraft(new SALSALARYDETAIL())));
    }




    @PreAuthorize("hasPermission('Remove',{#salsalarydetail_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"SALSALARYDETAIL" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salsalarydetails/{salsalarydetail_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salsalarydetail_id") String salsalarydetail_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salsalarydetailService.remove(salsalarydetail_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"SALSALARYDETAIL" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salsalarydetails/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salsalarydetailService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#salsalarydetail_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"SALSALARYDETAIL" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/salsalarydetails/{salsalarydetail_id}")
    public ResponseEntity<SALSALARYDETAILDTO> get(@PathVariable("salsalarydetail_id") String salsalarydetail_id) {
        SALSALARYDETAIL domain = salsalarydetailService.get(salsalarydetail_id);
        SALSALARYDETAILDTO dto = salsalarydetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "CheckKey", tags = {"SALSALARYDETAIL" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/salsalarydetails/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SALSALARYDETAILDTO salsalarydetaildto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salsalarydetailService.checkKey(salsalarydetailMapping.toDomain(salsalarydetaildto)));
    }




    @ApiOperation(value = "Save", tags = {"SALSALARYDETAIL" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/salsalarydetails/save")
    public ResponseEntity<Boolean> save(@RequestBody SALSALARYDETAILDTO salsalarydetaildto) {
        return ResponseEntity.status(HttpStatus.OK).body(salsalarydetailService.save(salsalarydetailMapping.toDomain(salsalarydetaildto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"SALSALARYDETAIL" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salsalarydetails/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SALSALARYDETAILDTO> salsalarydetaildtos) {
        salsalarydetailService.saveBatch(salsalarydetailMapping.toDomain(salsalarydetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SALSALARYDETAIL" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salsalarydetails/fetchdefault")
	public ResponseEntity<List<SALSALARYDETAILDTO>> fetchDefault(SALSALARYDETAILSearchContext context) {
        Page<SALSALARYDETAIL> domains = salsalarydetailService.searchDefault(context) ;
        List<SALSALARYDETAILDTO> list = salsalarydetailMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"SALSALARYDETAIL" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salsalarydetails/searchdefault")
	public ResponseEntity<Page<SALSALARYDETAILDTO>> searchDefault(SALSALARYDETAILSearchContext context) {
        Page<SALSALARYDETAIL> domains = salsalarydetailService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salsalarydetailMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public SALSALARYDETAIL getEntity(){
        return new SALSALARYDETAIL();
    }

}
