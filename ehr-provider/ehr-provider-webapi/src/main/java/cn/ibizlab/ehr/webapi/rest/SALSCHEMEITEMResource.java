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
import cn.ibizlab.ehr.core.sal.domain.SALSCHEMEITEM;
import cn.ibizlab.ehr.core.sal.service.ISALSCHEMEITEMService;
import cn.ibizlab.ehr.core.sal.filter.SALSCHEMEITEMSearchContext;




@Slf4j
@Api(tags = {"SALSCHEMEITEM" })
@RestController("WebApi-salschemeitem")
@RequestMapping("")
public class SALSCHEMEITEMResource {

    @Autowired
    private ISALSCHEMEITEMService salschemeitemService;

    @Autowired
    @Lazy
    private SALSCHEMEITEMMapping salschemeitemMapping;




    @PreAuthorize("hasPermission(#salschemeitem_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"SALSCHEMEITEM" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/salschemeitems/{salschemeitem_id}")
    @Transactional
    public ResponseEntity<SALSCHEMEITEMDTO> update(@PathVariable("salschemeitem_id") String salschemeitem_id, @RequestBody SALSCHEMEITEMDTO salschemeitemdto) {
		SALSCHEMEITEM domain = salschemeitemMapping.toDomain(salschemeitemdto);
        domain.setSalschemeitemid(salschemeitem_id);
		salschemeitemService.update(domain);
		SALSCHEMEITEMDTO dto = salschemeitemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#salschemeitem_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"SALSCHEMEITEM" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/salschemeitems/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SALSCHEMEITEMDTO> salschemeitemdtos) {
        salschemeitemService.updateBatch(salschemeitemMapping.toDomain(salschemeitemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"SALSCHEMEITEM" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemeitems/save")
    public ResponseEntity<Boolean> save(@RequestBody SALSCHEMEITEMDTO salschemeitemdto) {
        return ResponseEntity.status(HttpStatus.OK).body(salschemeitemService.save(salschemeitemMapping.toDomain(salschemeitemdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"SALSCHEMEITEM" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemeitems/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SALSCHEMEITEMDTO> salschemeitemdtos) {
        salschemeitemService.saveBatch(salschemeitemMapping.toDomain(salschemeitemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#salschemeitem_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"SALSCHEMEITEM" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/salschemeitems/{salschemeitem_id}")
    public ResponseEntity<SALSCHEMEITEMDTO> get(@PathVariable("salschemeitem_id") String salschemeitem_id) {
        SALSCHEMEITEM domain = salschemeitemService.get(salschemeitem_id);
        SALSCHEMEITEMDTO dto = salschemeitemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#salschemeitem_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"SALSCHEMEITEM" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salschemeitems/{salschemeitem_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salschemeitem_id") String salschemeitem_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salschemeitemService.remove(salschemeitem_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"SALSCHEMEITEM" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salschemeitems/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salschemeitemService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"SALSCHEMEITEM" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemeitems/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SALSCHEMEITEMDTO salschemeitemdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salschemeitemService.checkKey(salschemeitemMapping.toDomain(salschemeitemdto)));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"SALSCHEMEITEM" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemeitems")
    @Transactional
    public ResponseEntity<SALSCHEMEITEMDTO> create(@RequestBody SALSCHEMEITEMDTO salschemeitemdto) {
        SALSCHEMEITEM domain = salschemeitemMapping.toDomain(salschemeitemdto);
		salschemeitemService.create(domain);
        SALSCHEMEITEMDTO dto = salschemeitemMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"SALSCHEMEITEM" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemeitems/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SALSCHEMEITEMDTO> salschemeitemdtos) {
        salschemeitemService.createBatch(salschemeitemMapping.toDomain(salschemeitemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"SALSCHEMEITEM" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/salschemeitems/getdraft")
    public ResponseEntity<SALSCHEMEITEMDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salschemeitemMapping.toDto(salschemeitemService.getDraft(new SALSCHEMEITEM())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSCHEMEITEM-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SALSCHEMEITEM" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salschemeitems/fetchdefault")
	public ResponseEntity<List<SALSCHEMEITEMDTO>> fetchDefault(SALSCHEMEITEMSearchContext context) {
        Page<SALSCHEMEITEM> domains = salschemeitemService.searchDefault(context) ;
        List<SALSCHEMEITEMDTO> list = salschemeitemMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SALSCHEMEITEM-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SALSCHEMEITEM" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salschemeitems/searchdefault")
	public ResponseEntity<Page<SALSCHEMEITEMDTO>> searchDefault(@RequestBody SALSCHEMEITEMSearchContext context) {
        Page<SALSCHEMEITEM> domains = salschemeitemService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salschemeitemMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public SALSCHEMEITEM getEntity(){
        return new SALSCHEMEITEM();
    }

}
