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
import cn.ibizlab.ehr.core.sal.domain.SALITEMSUB;
import cn.ibizlab.ehr.core.sal.service.ISALITEMSUBService;
import cn.ibizlab.ehr.core.sal.filter.SALITEMSUBSearchContext;




@Slf4j
@Api(tags = {"SALITEMSUB" })
@RestController("WebApi-salitemsub")
@RequestMapping("")
public class SALITEMSUBResource {

    @Autowired
    private ISALITEMSUBService salitemsubService;

    @Autowired
    @Lazy
    private SALITEMSUBMapping salitemsubMapping;




    @PreAuthorize("hasPermission(#salitemsub_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"SALITEMSUB" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/salitemsubs/{salitemsub_id}")
    public ResponseEntity<SALITEMSUBDTO> get(@PathVariable("salitemsub_id") String salitemsub_id) {
        SALITEMSUB domain = salitemsubService.get(salitemsub_id);
        SALITEMSUBDTO dto = salitemsubMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#salitemsub_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"SALITEMSUB" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/salitemsubs/{salitemsub_id}")
    @Transactional
    public ResponseEntity<SALITEMSUBDTO> update(@PathVariable("salitemsub_id") String salitemsub_id, @RequestBody SALITEMSUBDTO salitemsubdto) {
		SALITEMSUB domain = salitemsubMapping.toDomain(salitemsubdto);
        domain.setSalitemsubid(salitemsub_id);
		salitemsubService.update(domain);
		SALITEMSUBDTO dto = salitemsubMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#salitemsub_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"SALITEMSUB" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/salitemsubs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SALITEMSUBDTO> salitemsubdtos) {
        salitemsubService.updateBatch(salitemsubMapping.toDomain(salitemsubdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#salitemsub_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"SALITEMSUB" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salitemsubs/{salitemsub_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salitemsub_id") String salitemsub_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salitemsubService.remove(salitemsub_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"SALITEMSUB" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salitemsubs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salitemsubService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"SALITEMSUB" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/salitemsubs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SALITEMSUBDTO salitemsubdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salitemsubService.checkKey(salitemsubMapping.toDomain(salitemsubdto)));
    }




    @ApiOperation(value = "Save", tags = {"SALITEMSUB" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/salitemsubs/save")
    public ResponseEntity<Boolean> save(@RequestBody SALITEMSUBDTO salitemsubdto) {
        return ResponseEntity.status(HttpStatus.OK).body(salitemsubService.save(salitemsubMapping.toDomain(salitemsubdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"SALITEMSUB" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salitemsubs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SALITEMSUBDTO> salitemsubdtos) {
        salitemsubService.saveBatch(salitemsubMapping.toDomain(salitemsubdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"SALITEMSUB" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/salitemsubs/getdraft")
    public ResponseEntity<SALITEMSUBDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salitemsubMapping.toDto(salitemsubService.getDraft(new SALITEMSUB())));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"SALITEMSUB" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/salitemsubs")
    @Transactional
    public ResponseEntity<SALITEMSUBDTO> create(@RequestBody SALITEMSUBDTO salitemsubdto) {
        SALITEMSUB domain = salitemsubMapping.toDomain(salitemsubdto);
		salitemsubService.create(domain);
        SALITEMSUBDTO dto = salitemsubMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"SALITEMSUB" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salitemsubs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SALITEMSUBDTO> salitemsubdtos) {
        salitemsubService.createBatch(salitemsubMapping.toDomain(salitemsubdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"SALITEMSUB" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salitemsubs/fetchdefault")
	public ResponseEntity<List<SALITEMSUBDTO>> fetchDefault(SALITEMSUBSearchContext context) {
        Page<SALITEMSUB> domains = salitemsubService.searchDefault(context) ;
        List<SALITEMSUBDTO> list = salitemsubMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"SALITEMSUB" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salitemsubs/searchdefault")
	public ResponseEntity<Page<SALITEMSUBDTO>> searchDefault(@RequestBody SALITEMSUBSearchContext context) {
        Page<SALITEMSUB> domains = salitemsubService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salitemsubMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public SALITEMSUB getEntity(){
        return new SALITEMSUB();
    }

}
