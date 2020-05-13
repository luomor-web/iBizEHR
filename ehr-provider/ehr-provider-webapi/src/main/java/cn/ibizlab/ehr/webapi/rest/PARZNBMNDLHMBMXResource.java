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
import cn.ibizlab.ehr.core.par.domain.PARZNBMNDLHMBMX;
import cn.ibizlab.ehr.core.par.service.IPARZNBMNDLHMBMXService;
import cn.ibizlab.ehr.core.par.filter.PARZNBMNDLHMBMXSearchContext;




@Slf4j
@Api(tags = {"PARZNBMNDLHMBMX" })
@RestController("WebApi-parznbmndlhmbmx")
@RequestMapping("")
public class PARZNBMNDLHMBMXResource {

    @Autowired
    private IPARZNBMNDLHMBMXService parznbmndlhmbmxService;

    @Autowired
    @Lazy
    private PARZNBMNDLHMBMXMapping parznbmndlhmbmxMapping;




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PARZNBMNDLHMBMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmndlhmbmxes")
    @Transactional
    public ResponseEntity<PARZNBMNDLHMBMXDTO> create(@RequestBody PARZNBMNDLHMBMXDTO parznbmndlhmbmxdto) {
        PARZNBMNDLHMBMX domain = parznbmndlhmbmxMapping.toDomain(parznbmndlhmbmxdto);
		parznbmndlhmbmxService.create(domain);
        PARZNBMNDLHMBMXDTO dto = parznbmndlhmbmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PARZNBMNDLHMBMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmndlhmbmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARZNBMNDLHMBMXDTO> parznbmndlhmbmxdtos) {
        parznbmndlhmbmxService.createBatch(parznbmndlhmbmxMapping.toDomain(parznbmndlhmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#parznbmndlhmbmx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PARZNBMNDLHMBMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parznbmndlhmbmxes/{parznbmndlhmbmx_id}")
    @Transactional
    public ResponseEntity<PARZNBMNDLHMBMXDTO> update(@PathVariable("parznbmndlhmbmx_id") String parznbmndlhmbmx_id, @RequestBody PARZNBMNDLHMBMXDTO parznbmndlhmbmxdto) {
		PARZNBMNDLHMBMX domain = parznbmndlhmbmxMapping.toDomain(parznbmndlhmbmxdto);
        domain.setParznbmndlhmbmxid(parznbmndlhmbmx_id);
		parznbmndlhmbmxService.update(domain);
		PARZNBMNDLHMBMXDTO dto = parznbmndlhmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#parznbmndlhmbmx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PARZNBMNDLHMBMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parznbmndlhmbmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARZNBMNDLHMBMXDTO> parznbmndlhmbmxdtos) {
        parznbmndlhmbmxService.updateBatch(parznbmndlhmbmxMapping.toDomain(parznbmndlhmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PARZNBMNDLHMBMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parznbmndlhmbmxes/getdraft")
    public ResponseEntity<PARZNBMNDLHMBMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parznbmndlhmbmxMapping.toDto(parznbmndlhmbmxService.getDraft(new PARZNBMNDLHMBMX())));
    }




    @PreAuthorize("hasPermission(#parznbmndlhmbmx_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PARZNBMNDLHMBMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parznbmndlhmbmxes/{parznbmndlhmbmx_id}")
    public ResponseEntity<PARZNBMNDLHMBMXDTO> get(@PathVariable("parznbmndlhmbmx_id") String parznbmndlhmbmx_id) {
        PARZNBMNDLHMBMX domain = parznbmndlhmbmxService.get(parznbmndlhmbmx_id);
        PARZNBMNDLHMBMXDTO dto = parznbmndlhmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "CheckKey", tags = {"PARZNBMNDLHMBMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmndlhmbmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARZNBMNDLHMBMXDTO parznbmndlhmbmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parznbmndlhmbmxService.checkKey(parznbmndlhmbmxMapping.toDomain(parznbmndlhmbmxdto)));
    }




    @ApiOperation(value = "Save", tags = {"PARZNBMNDLHMBMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmndlhmbmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PARZNBMNDLHMBMXDTO parznbmndlhmbmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parznbmndlhmbmxService.save(parznbmndlhmbmxMapping.toDomain(parznbmndlhmbmxdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PARZNBMNDLHMBMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmndlhmbmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARZNBMNDLHMBMXDTO> parznbmndlhmbmxdtos) {
        parznbmndlhmbmxService.saveBatch(parznbmndlhmbmxMapping.toDomain(parznbmndlhmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#parznbmndlhmbmx_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PARZNBMNDLHMBMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parznbmndlhmbmxes/{parznbmndlhmbmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parznbmndlhmbmx_id") String parznbmndlhmbmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parznbmndlhmbmxService.remove(parznbmndlhmbmx_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PARZNBMNDLHMBMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parznbmndlhmbmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parznbmndlhmbmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PARZNBMNDLHMBMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parznbmndlhmbmxes/fetchdefault")
	public ResponseEntity<List<PARZNBMNDLHMBMXDTO>> fetchDefault(PARZNBMNDLHMBMXSearchContext context) {
        Page<PARZNBMNDLHMBMX> domains = parznbmndlhmbmxService.searchDefault(context) ;
        List<PARZNBMNDLHMBMXDTO> list = parznbmndlhmbmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"PARZNBMNDLHMBMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parznbmndlhmbmxes/searchdefault")
	public ResponseEntity<Page<PARZNBMNDLHMBMXDTO>> searchDefault(PARZNBMNDLHMBMXSearchContext context) {
        Page<PARZNBMNDLHMBMX> domains = parznbmndlhmbmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parznbmndlhmbmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PARZNBMNDLHMBMX getEntity(){
        return new PARZNBMNDLHMBMX();
    }

}