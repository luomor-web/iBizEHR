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
import cn.ibizlab.ehr.core.sal.domain.SALSTDZX;
import cn.ibizlab.ehr.core.sal.service.ISALSTDZXService;
import cn.ibizlab.ehr.core.sal.filter.SALSTDZXSearchContext;




@Slf4j
@Api(tags = {"SALSTDZX" })
@RestController("WebApi-salstdzx")
@RequestMapping("")
public class SALSTDZXResource {

    @Autowired
    private ISALSTDZXService salstdzxService;

    @Autowired
    @Lazy
    private SALSTDZXMapping salstdzxMapping;




    @ApiOperation(value = "Save", tags = {"SALSTDZX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzxes/save")
    public ResponseEntity<Boolean> save(@RequestBody SALSTDZXDTO salstdzxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(salstdzxService.save(salstdzxMapping.toDomain(salstdzxdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"SALSTDZX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SALSTDZXDTO> salstdzxdtos) {
        salstdzxService.saveBatch(salstdzxMapping.toDomain(salstdzxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#salstdzx_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"SALSTDZX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdzxes/{salstdzx_id}")
    public ResponseEntity<SALSTDZXDTO> get(@PathVariable("salstdzx_id") String salstdzx_id) {
        SALSTDZX domain = salstdzxService.get(salstdzx_id);
        SALSTDZXDTO dto = salstdzxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#salstdzx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"SALSTDZX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdzxes/{salstdzx_id}")
    @Transactional
    public ResponseEntity<SALSTDZXDTO> update(@PathVariable("salstdzx_id") String salstdzx_id, @RequestBody SALSTDZXDTO salstdzxdto) {
		SALSTDZX domain = salstdzxMapping.toDomain(salstdzxdto);
        domain.setSalstdzxid(salstdzx_id);
		salstdzxService.update(domain);
		SALSTDZXDTO dto = salstdzxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#salstdzx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"SALSTDZX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/salstdzxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SALSTDZXDTO> salstdzxdtos) {
        salstdzxService.updateBatch(salstdzxMapping.toDomain(salstdzxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"SALSTDZX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzxes")
    @Transactional
    public ResponseEntity<SALSTDZXDTO> create(@RequestBody SALSTDZXDTO salstdzxdto) {
        SALSTDZX domain = salstdzxMapping.toDomain(salstdzxdto);
		salstdzxService.create(domain);
        SALSTDZXDTO dto = salstdzxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"SALSTDZX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SALSTDZXDTO> salstdzxdtos) {
        salstdzxService.createBatch(salstdzxMapping.toDomain(salstdzxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"SALSTDZX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/salstdzxes/getdraft")
    public ResponseEntity<SALSTDZXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salstdzxMapping.toDto(salstdzxService.getDraft(new SALSTDZX())));
    }




    @ApiOperation(value = "CheckKey", tags = {"SALSTDZX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/salstdzxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SALSTDZXDTO salstdzxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salstdzxService.checkKey(salstdzxMapping.toDomain(salstdzxdto)));
    }




    @PreAuthorize("hasPermission('Remove',{#salstdzx_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"SALSTDZX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdzxes/{salstdzx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salstdzx_id") String salstdzx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salstdzxService.remove(salstdzx_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"SALSTDZX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salstdzxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salstdzxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"SALSTDZX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salstdzxes/fetchdefault")
	public ResponseEntity<List<SALSTDZXDTO>> fetchDefault(SALSTDZXSearchContext context) {
        Page<SALSTDZX> domains = salstdzxService.searchDefault(context) ;
        List<SALSTDZXDTO> list = salstdzxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"SALSTDZX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salstdzxes/searchdefault")
	public ResponseEntity<Page<SALSTDZXDTO>> searchDefault(@RequestBody SALSTDZXSearchContext context) {
        Page<SALSTDZX> domains = salstdzxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salstdzxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public SALSTDZX getEntity(){
        return new SALSTDZX();
    }

}
