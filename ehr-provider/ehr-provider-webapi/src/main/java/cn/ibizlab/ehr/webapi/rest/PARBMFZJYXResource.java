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
import cn.ibizlab.ehr.core.par.domain.PARBMFZJYX;
import cn.ibizlab.ehr.core.par.service.IPARBMFZJYXService;
import cn.ibizlab.ehr.core.par.filter.PARBMFZJYXSearchContext;




@Slf4j
@Api(tags = {"PARBMFZJYX" })
@RestController("WebApi-parbmfzjyx")
@RequestMapping("")
public class PARBMFZJYXResource {

    @Autowired
    private IPARBMFZJYXService parbmfzjyxService;

    @Autowired
    @Lazy
    private PARBMFZJYXMapping parbmfzjyxMapping;




    @ApiOperation(value = "Save", tags = {"PARBMFZJYX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parbmfzjyxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PARBMFZJYXDTO parbmfzjyxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parbmfzjyxService.save(parbmfzjyxMapping.toDomain(parbmfzjyxdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PARBMFZJYX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parbmfzjyxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARBMFZJYXDTO> parbmfzjyxdtos) {
        parbmfzjyxService.saveBatch(parbmfzjyxMapping.toDomain(parbmfzjyxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PARBMFZJYX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parbmfzjyxes/getdraft")
    public ResponseEntity<PARBMFZJYXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parbmfzjyxMapping.toDto(parbmfzjyxService.getDraft(new PARBMFZJYX())));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PARBMFZJYX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parbmfzjyxes")
    @Transactional
    public ResponseEntity<PARBMFZJYXDTO> create(@RequestBody PARBMFZJYXDTO parbmfzjyxdto) {
        PARBMFZJYX domain = parbmfzjyxMapping.toDomain(parbmfzjyxdto);
		parbmfzjyxService.create(domain);
        PARBMFZJYXDTO dto = parbmfzjyxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PARBMFZJYX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parbmfzjyxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARBMFZJYXDTO> parbmfzjyxdtos) {
        parbmfzjyxService.createBatch(parbmfzjyxMapping.toDomain(parbmfzjyxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"PARBMFZJYX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parbmfzjyxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARBMFZJYXDTO parbmfzjyxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parbmfzjyxService.checkKey(parbmfzjyxMapping.toDomain(parbmfzjyxdto)));
    }




    @PreAuthorize("hasPermission('Remove',{#parbmfzjyx_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PARBMFZJYX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parbmfzjyxes/{parbmfzjyx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parbmfzjyx_id") String parbmfzjyx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parbmfzjyxService.remove(parbmfzjyx_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PARBMFZJYX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parbmfzjyxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parbmfzjyxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#parbmfzjyx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PARBMFZJYX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parbmfzjyxes/{parbmfzjyx_id}")
    @Transactional
    public ResponseEntity<PARBMFZJYXDTO> update(@PathVariable("parbmfzjyx_id") String parbmfzjyx_id, @RequestBody PARBMFZJYXDTO parbmfzjyxdto) {
		PARBMFZJYX domain = parbmfzjyxMapping.toDomain(parbmfzjyxdto);
        domain.setParbmfzjyxid(parbmfzjyx_id);
		parbmfzjyxService.update(domain);
		PARBMFZJYXDTO dto = parbmfzjyxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#parbmfzjyx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PARBMFZJYX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parbmfzjyxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARBMFZJYXDTO> parbmfzjyxdtos) {
        parbmfzjyxService.updateBatch(parbmfzjyxMapping.toDomain(parbmfzjyxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#parbmfzjyx_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PARBMFZJYX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parbmfzjyxes/{parbmfzjyx_id}")
    public ResponseEntity<PARBMFZJYXDTO> get(@PathVariable("parbmfzjyx_id") String parbmfzjyx_id) {
        PARBMFZJYX domain = parbmfzjyxService.get(parbmfzjyx_id);
        PARBMFZJYXDTO dto = parbmfzjyxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PARBMFZJYX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parbmfzjyxes/fetchdefault")
	public ResponseEntity<List<PARBMFZJYXDTO>> fetchDefault(PARBMFZJYXSearchContext context) {
        Page<PARBMFZJYX> domains = parbmfzjyxService.searchDefault(context) ;
        List<PARBMFZJYXDTO> list = parbmfzjyxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"PARBMFZJYX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parbmfzjyxes/searchdefault")
	public ResponseEntity<Page<PARBMFZJYXDTO>> searchDefault(PARBMFZJYXSearchContext context) {
        Page<PARBMFZJYX> domains = parbmfzjyxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parbmfzjyxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PARBMFZJYX getEntity(){
        return new PARBMFZJYX();
    }

}
