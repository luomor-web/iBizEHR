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
import cn.ibizlab.ehr.core.sal.domain.SALITEM;
import cn.ibizlab.ehr.core.sal.service.ISALITEMService;
import cn.ibizlab.ehr.core.sal.filter.SALITEMSearchContext;




@Slf4j
@Api(tags = {"SALITEM" })
@RestController("WebApi-salitem")
@RequestMapping("")
public class SALITEMResource {

    @Autowired
    private ISALITEMService salitemService;

    @Autowired
    @Lazy
    private SALITEMMapping salitemMapping;




    @PreAuthorize("hasPermission(#salitem_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"SALITEM" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/salitems/{salitem_id}")
    public ResponseEntity<SALITEMDTO> get(@PathVariable("salitem_id") String salitem_id) {
        SALITEM domain = salitemService.get(salitem_id);
        SALITEMDTO dto = salitemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('Remove',{#salitem_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"SALITEM" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salitems/{salitem_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salitem_id") String salitem_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salitemService.remove(salitem_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"SALITEM" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salitems/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salitemService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"SALITEM" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/salitems/save")
    public ResponseEntity<Boolean> save(@RequestBody SALITEMDTO salitemdto) {
        return ResponseEntity.status(HttpStatus.OK).body(salitemService.save(salitemMapping.toDomain(salitemdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"SALITEM" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salitems/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SALITEMDTO> salitemdtos) {
        salitemService.saveBatch(salitemMapping.toDomain(salitemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"SALITEM" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/salitems/getdraft")
    public ResponseEntity<SALITEMDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salitemMapping.toDto(salitemService.getDraft(new SALITEM())));
    }




    @ApiOperation(value = "CheckKey", tags = {"SALITEM" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/salitems/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SALITEMDTO salitemdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salitemService.checkKey(salitemMapping.toDomain(salitemdto)));
    }




    @PreAuthorize("hasPermission(#salitem_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"SALITEM" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/salitems/{salitem_id}")
    @Transactional
    public ResponseEntity<SALITEMDTO> update(@PathVariable("salitem_id") String salitem_id, @RequestBody SALITEMDTO salitemdto) {
		SALITEM domain = salitemMapping.toDomain(salitemdto);
        domain.setSalitemid(salitem_id);
		salitemService.update(domain);
		SALITEMDTO dto = salitemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#salitem_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"SALITEM" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/salitems/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SALITEMDTO> salitemdtos) {
        salitemService.updateBatch(salitemMapping.toDomain(salitemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"SALITEM" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/salitems")
    @Transactional
    public ResponseEntity<SALITEMDTO> create(@RequestBody SALITEMDTO salitemdto) {
        SALITEM domain = salitemMapping.toDomain(salitemdto);
		salitemService.create(domain);
        SALITEMDTO dto = salitemMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"SALITEM" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salitems/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SALITEMDTO> salitemdtos) {
        salitemService.createBatch(salitemMapping.toDomain(salitemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"SALITEM" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salitems/fetchdefault")
	public ResponseEntity<List<SALITEMDTO>> fetchDefault(SALITEMSearchContext context) {
        Page<SALITEM> domains = salitemService.searchDefault(context) ;
        List<SALITEMDTO> list = salitemMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"SALITEM" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salitems/searchdefault")
	public ResponseEntity<Page<SALITEMDTO>> searchDefault(@RequestBody SALITEMSearchContext context) {
        Page<SALITEM> domains = salitemService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salitemMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public SALITEM getEntity(){
        return new SALITEM();
    }

}
