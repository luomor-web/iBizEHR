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
import cn.ibizlab.ehr.core.vac.domain.VACUSENXJMX;
import cn.ibizlab.ehr.core.vac.service.IVACUSENXJMXService;
import cn.ibizlab.ehr.core.vac.filter.VACUSENXJMXSearchContext;




@Slf4j
@Api(tags = {"VACUSENXJMX" })
@RestController("WebApi-vacusenxjmx")
@RequestMapping("")
public class VACUSENXJMXResource {

    @Autowired
    private IVACUSENXJMXService vacusenxjmxService;

    @Autowired
    @Lazy
    private VACUSENXJMXMapping vacusenxjmxMapping;




    @PreAuthorize("hasPermission('Remove',{#vacusenxjmx_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"VACUSENXJMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacusenxjmxes/{vacusenxjmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacusenxjmx_id") String vacusenxjmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacusenxjmxService.remove(vacusenxjmx_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"VACUSENXJMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacusenxjmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacusenxjmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"VACUSENXJMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/vacusenxjmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VACUSENXJMXDTO vacusenxjmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacusenxjmxService.checkKey(vacusenxjmxMapping.toDomain(vacusenxjmxdto)));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"VACUSENXJMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/vacusenxjmxes")
    @Transactional
    public ResponseEntity<VACUSENXJMXDTO> create(@RequestBody VACUSENXJMXDTO vacusenxjmxdto) {
        VACUSENXJMX domain = vacusenxjmxMapping.toDomain(vacusenxjmxdto);
		vacusenxjmxService.create(domain);
        VACUSENXJMXDTO dto = vacusenxjmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"VACUSENXJMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacusenxjmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VACUSENXJMXDTO> vacusenxjmxdtos) {
        vacusenxjmxService.createBatch(vacusenxjmxMapping.toDomain(vacusenxjmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#vacusenxjmx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"VACUSENXJMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacusenxjmxes/{vacusenxjmx_id}")
    @Transactional
    public ResponseEntity<VACUSENXJMXDTO> update(@PathVariable("vacusenxjmx_id") String vacusenxjmx_id, @RequestBody VACUSENXJMXDTO vacusenxjmxdto) {
		VACUSENXJMX domain = vacusenxjmxMapping.toDomain(vacusenxjmxdto);
        domain.setVacusenxjmxid(vacusenxjmx_id);
		vacusenxjmxService.update(domain);
		VACUSENXJMXDTO dto = vacusenxjmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#vacusenxjmx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"VACUSENXJMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacusenxjmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VACUSENXJMXDTO> vacusenxjmxdtos) {
        vacusenxjmxService.updateBatch(vacusenxjmxMapping.toDomain(vacusenxjmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"VACUSENXJMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/vacusenxjmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody VACUSENXJMXDTO vacusenxjmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacusenxjmxService.save(vacusenxjmxMapping.toDomain(vacusenxjmxdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"VACUSENXJMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacusenxjmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VACUSENXJMXDTO> vacusenxjmxdtos) {
        vacusenxjmxService.saveBatch(vacusenxjmxMapping.toDomain(vacusenxjmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"VACUSENXJMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/vacusenxjmxes/getdraft")
    public ResponseEntity<VACUSENXJMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacusenxjmxMapping.toDto(vacusenxjmxService.getDraft(new VACUSENXJMX())));
    }




    @PreAuthorize("hasPermission(#vacusenxjmx_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"VACUSENXJMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/vacusenxjmxes/{vacusenxjmx_id}")
    public ResponseEntity<VACUSENXJMXDTO> get(@PathVariable("vacusenxjmx_id") String vacusenxjmx_id) {
        VACUSENXJMX domain = vacusenxjmxService.get(vacusenxjmx_id);
        VACUSENXJMXDTO dto = vacusenxjmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"VACUSENXJMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacusenxjmxes/fetchdefault")
	public ResponseEntity<List<VACUSENXJMXDTO>> fetchDefault(VACUSENXJMXSearchContext context) {
        Page<VACUSENXJMX> domains = vacusenxjmxService.searchDefault(context) ;
        List<VACUSENXJMXDTO> list = vacusenxjmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"VACUSENXJMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacusenxjmxes/searchdefault")
	public ResponseEntity<Page<VACUSENXJMXDTO>> searchDefault(VACUSENXJMXSearchContext context) {
        Page<VACUSENXJMX> domains = vacusenxjmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacusenxjmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public VACUSENXJMX getEntity(){
        return new VACUSENXJMX();
    }

}
