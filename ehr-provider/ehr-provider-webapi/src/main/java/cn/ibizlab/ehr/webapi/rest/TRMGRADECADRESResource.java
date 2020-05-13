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
import cn.ibizlab.ehr.core.trm.domain.TRMGRADECADRES;
import cn.ibizlab.ehr.core.trm.service.ITRMGRADECADRESService;
import cn.ibizlab.ehr.core.trm.filter.TRMGRADECADRESSearchContext;




@Slf4j
@Api(tags = {"TRMGRADECADRES" })
@RestController("WebApi-trmgradecadres")
@RequestMapping("")
public class TRMGRADECADRESResource {

    @Autowired
    private ITRMGRADECADRESService trmgradecadresService;

    @Autowired
    @Lazy
    private TRMGRADECADRESMapping trmgradecadresMapping;




    @PreAuthorize("hasPermission(#trmgradecadres_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"TRMGRADECADRES" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmgradecadres/{trmgradecadres_id}")
    @Transactional
    public ResponseEntity<TRMGRADECADRESDTO> update(@PathVariable("trmgradecadres_id") String trmgradecadres_id, @RequestBody TRMGRADECADRESDTO trmgradecadresdto) {
		TRMGRADECADRES domain = trmgradecadresMapping.toDomain(trmgradecadresdto);
        domain.setTrmgradecadresid(trmgradecadres_id);
		trmgradecadresService.update(domain);
		TRMGRADECADRESDTO dto = trmgradecadresMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#trmgradecadres_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"TRMGRADECADRES" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmgradecadres/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMGRADECADRESDTO> trmgradecadresdtos) {
        trmgradecadresService.updateBatch(trmgradecadresMapping.toDomain(trmgradecadresdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"TRMGRADECADRES" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmgradecadres/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMGRADECADRESDTO trmgradecadresdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmgradecadresService.checkKey(trmgradecadresMapping.toDomain(trmgradecadresdto)));
    }




    @PreAuthorize("hasPermission('Remove',{#trmgradecadres_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"TRMGRADECADRES" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmgradecadres/{trmgradecadres_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmgradecadres_id") String trmgradecadres_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmgradecadresService.remove(trmgradecadres_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"TRMGRADECADRES" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmgradecadres/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmgradecadresService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"TRMGRADECADRES" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmgradecadres")
    @Transactional
    public ResponseEntity<TRMGRADECADRESDTO> create(@RequestBody TRMGRADECADRESDTO trmgradecadresdto) {
        TRMGRADECADRES domain = trmgradecadresMapping.toDomain(trmgradecadresdto);
		trmgradecadresService.create(domain);
        TRMGRADECADRESDTO dto = trmgradecadresMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"TRMGRADECADRES" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmgradecadres/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMGRADECADRESDTO> trmgradecadresdtos) {
        trmgradecadresService.createBatch(trmgradecadresMapping.toDomain(trmgradecadresdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"TRMGRADECADRES" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmgradecadres/getdraft")
    public ResponseEntity<TRMGRADECADRESDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmgradecadresMapping.toDto(trmgradecadresService.getDraft(new TRMGRADECADRES())));
    }




    @ApiOperation(value = "Save", tags = {"TRMGRADECADRES" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmgradecadres/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMGRADECADRESDTO trmgradecadresdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmgradecadresService.save(trmgradecadresMapping.toDomain(trmgradecadresdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"TRMGRADECADRES" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmgradecadres/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMGRADECADRESDTO> trmgradecadresdtos) {
        trmgradecadresService.saveBatch(trmgradecadresMapping.toDomain(trmgradecadresdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#trmgradecadres_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"TRMGRADECADRES" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmgradecadres/{trmgradecadres_id}")
    public ResponseEntity<TRMGRADECADRESDTO> get(@PathVariable("trmgradecadres_id") String trmgradecadres_id) {
        TRMGRADECADRES domain = trmgradecadresService.get(trmgradecadres_id);
        TRMGRADECADRESDTO dto = trmgradecadresMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TRMGRADECADRES" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmgradecadres/fetchdefault")
	public ResponseEntity<List<TRMGRADECADRESDTO>> fetchDefault(TRMGRADECADRESSearchContext context) {
        Page<TRMGRADECADRES> domains = trmgradecadresService.searchDefault(context) ;
        List<TRMGRADECADRESDTO> list = trmgradecadresMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"TRMGRADECADRES" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmgradecadres/searchdefault")
	public ResponseEntity<Page<TRMGRADECADRESDTO>> searchDefault(TRMGRADECADRESSearchContext context) {
        Page<TRMGRADECADRES> domains = trmgradecadresService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmgradecadresMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public TRMGRADECADRES getEntity(){
        return new TRMGRADECADRES();
    }

}