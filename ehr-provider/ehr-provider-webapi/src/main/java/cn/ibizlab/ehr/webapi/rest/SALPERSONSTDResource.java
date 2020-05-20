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
import cn.ibizlab.ehr.core.sal.domain.SALPERSONSTD;
import cn.ibizlab.ehr.core.sal.service.ISALPERSONSTDService;
import cn.ibizlab.ehr.core.sal.filter.SALPERSONSTDSearchContext;




@Slf4j
@Api(tags = {"SALPERSONSTD" })
@RestController("WebApi-salpersonstd")
@RequestMapping("")
public class SALPERSONSTDResource {

    @Autowired
    private ISALPERSONSTDService salpersonstdService;

    @Autowired
    @Lazy
    private SALPERSONSTDMapping salpersonstdMapping;




    @ApiOperation(value = "Save", tags = {"SALPERSONSTD" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/salpersonstds/save")
    public ResponseEntity<Boolean> save(@RequestBody SALPERSONSTDDTO salpersonstddto) {
        return ResponseEntity.status(HttpStatus.OK).body(salpersonstdService.save(salpersonstdMapping.toDomain(salpersonstddto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"SALPERSONSTD" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salpersonstds/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SALPERSONSTDDTO> salpersonstddtos) {
        salpersonstdService.saveBatch(salpersonstdMapping.toDomain(salpersonstddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"SALPERSONSTD" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/salpersonstds/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SALPERSONSTDDTO salpersonstddto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salpersonstdService.checkKey(salpersonstdMapping.toDomain(salpersonstddto)));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"SALPERSONSTD" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/salpersonstds")
    @Transactional
    public ResponseEntity<SALPERSONSTDDTO> create(@RequestBody SALPERSONSTDDTO salpersonstddto) {
        SALPERSONSTD domain = salpersonstdMapping.toDomain(salpersonstddto);
		salpersonstdService.create(domain);
        SALPERSONSTDDTO dto = salpersonstdMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"SALPERSONSTD" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salpersonstds/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SALPERSONSTDDTO> salpersonstddtos) {
        salpersonstdService.createBatch(salpersonstdMapping.toDomain(salpersonstddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#salpersonstd_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"SALPERSONSTD" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salpersonstds/{salpersonstd_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salpersonstd_id") String salpersonstd_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salpersonstdService.remove(salpersonstd_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"SALPERSONSTD" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salpersonstds/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salpersonstdService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"SALPERSONSTD" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/salpersonstds/getdraft")
    public ResponseEntity<SALPERSONSTDDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salpersonstdMapping.toDto(salpersonstdService.getDraft(new SALPERSONSTD())));
    }




    @PreAuthorize("hasPermission(#salpersonstd_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"SALPERSONSTD" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/salpersonstds/{salpersonstd_id}")
    @Transactional
    public ResponseEntity<SALPERSONSTDDTO> update(@PathVariable("salpersonstd_id") String salpersonstd_id, @RequestBody SALPERSONSTDDTO salpersonstddto) {
		SALPERSONSTD domain = salpersonstdMapping.toDomain(salpersonstddto);
        domain.setSalpersonstdid(salpersonstd_id);
		salpersonstdService.update(domain);
		SALPERSONSTDDTO dto = salpersonstdMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#salpersonstd_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"SALPERSONSTD" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/salpersonstds/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SALPERSONSTDDTO> salpersonstddtos) {
        salpersonstdService.updateBatch(salpersonstdMapping.toDomain(salpersonstddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#salpersonstd_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"SALPERSONSTD" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/salpersonstds/{salpersonstd_id}")
    public ResponseEntity<SALPERSONSTDDTO> get(@PathVariable("salpersonstd_id") String salpersonstd_id) {
        SALPERSONSTD domain = salpersonstdService.get(salpersonstd_id);
        SALPERSONSTDDTO dto = salpersonstdMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"SALPERSONSTD" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salpersonstds/fetchdefault")
	public ResponseEntity<List<SALPERSONSTDDTO>> fetchDefault(SALPERSONSTDSearchContext context) {
        Page<SALPERSONSTD> domains = salpersonstdService.searchDefault(context) ;
        List<SALPERSONSTDDTO> list = salpersonstdMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"SALPERSONSTD" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salpersonstds/searchdefault")
	public ResponseEntity<Page<SALPERSONSTDDTO>> searchDefault(@RequestBody SALPERSONSTDSearchContext context) {
        Page<SALPERSONSTD> domains = salpersonstdService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salpersonstdMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public SALPERSONSTD getEntity(){
        return new SALPERSONSTD();
    }

}
