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
import cn.ibizlab.ehr.core.sal.domain.SALSALARYBILL;
import cn.ibizlab.ehr.core.sal.service.ISALSALARYBILLService;
import cn.ibizlab.ehr.core.sal.filter.SALSALARYBILLSearchContext;




@Slf4j
@Api(tags = {"SALSALARYBILL" })
@RestController("WebApi-salsalarybill")
@RequestMapping("")
public class SALSALARYBILLResource {

    @Autowired
    private ISALSALARYBILLService salsalarybillService;

    @Autowired
    @Lazy
    private SALSALARYBILLMapping salsalarybillMapping;




    @PreAuthorize("hasPermission(#salsalarybill_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"SALSALARYBILL" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salsalarybills/{salsalarybill_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salsalarybill_id") String salsalarybill_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salsalarybillService.remove(salsalarybill_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"SALSALARYBILL" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salsalarybills/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salsalarybillService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"SALSALARYBILL" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/salsalarybills/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SALSALARYBILLDTO salsalarybilldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salsalarybillService.checkKey(salsalarybillMapping.toDomain(salsalarybilldto)));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"SALSALARYBILL" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/salsalarybills")
    @Transactional
    public ResponseEntity<SALSALARYBILLDTO> create(@RequestBody SALSALARYBILLDTO salsalarybilldto) {
        SALSALARYBILL domain = salsalarybillMapping.toDomain(salsalarybilldto);
		salsalarybillService.create(domain);
        SALSALARYBILLDTO dto = salsalarybillMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"SALSALARYBILL" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salsalarybills/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SALSALARYBILLDTO> salsalarybilldtos) {
        salsalarybillService.createBatch(salsalarybillMapping.toDomain(salsalarybilldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"SALSALARYBILL" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/salsalarybills/getdraft")
    public ResponseEntity<SALSALARYBILLDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salsalarybillMapping.toDto(salsalarybillService.getDraft(new SALSALARYBILL())));
    }




    @PreAuthorize("hasPermission(#salsalarybill_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"SALSALARYBILL" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/salsalarybills/{salsalarybill_id}")
    @Transactional
    public ResponseEntity<SALSALARYBILLDTO> update(@PathVariable("salsalarybill_id") String salsalarybill_id, @RequestBody SALSALARYBILLDTO salsalarybilldto) {
		SALSALARYBILL domain = salsalarybillMapping.toDomain(salsalarybilldto);
        domain.setSalsalarybillid(salsalarybill_id);
		salsalarybillService.update(domain);
		SALSALARYBILLDTO dto = salsalarybillMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#salsalarybill_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"SALSALARYBILL" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/salsalarybills/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SALSALARYBILLDTO> salsalarybilldtos) {
        salsalarybillService.updateBatch(salsalarybillMapping.toDomain(salsalarybilldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#salsalarybill_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"SALSALARYBILL" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/salsalarybills/{salsalarybill_id}")
    public ResponseEntity<SALSALARYBILLDTO> get(@PathVariable("salsalarybill_id") String salsalarybill_id) {
        SALSALARYBILL domain = salsalarybillService.get(salsalarybill_id);
        SALSALARYBILLDTO dto = salsalarybillMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "Save", tags = {"SALSALARYBILL" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/salsalarybills/save")
    public ResponseEntity<Boolean> save(@RequestBody SALSALARYBILLDTO salsalarybilldto) {
        return ResponseEntity.status(HttpStatus.OK).body(salsalarybillService.save(salsalarybillMapping.toDomain(salsalarybilldto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"SALSALARYBILL" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salsalarybills/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SALSALARYBILLDTO> salsalarybilldtos) {
        salsalarybillService.saveBatch(salsalarybillMapping.toDomain(salsalarybilldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSALARYBILL-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SALSALARYBILL" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salsalarybills/fetchdefault")
	public ResponseEntity<List<SALSALARYBILLDTO>> fetchDefault(SALSALARYBILLSearchContext context) {
        Page<SALSALARYBILL> domains = salsalarybillService.searchDefault(context) ;
        List<SALSALARYBILLDTO> list = salsalarybillMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSALARYBILL-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SALSALARYBILL" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salsalarybills/searchdefault")
	public ResponseEntity<Page<SALSALARYBILLDTO>> searchDefault(@RequestBody SALSALARYBILLSearchContext context) {
        Page<SALSALARYBILL> domains = salsalarybillService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salsalarybillMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public SALSALARYBILL getEntity(){
        return new SALSALARYBILL();
    }

}
