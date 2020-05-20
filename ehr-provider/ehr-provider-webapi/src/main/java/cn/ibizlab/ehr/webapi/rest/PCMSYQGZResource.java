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
import cn.ibizlab.ehr.core.pcm.domain.PCMSYQGZ;
import cn.ibizlab.ehr.core.pcm.service.IPCMSYQGZService;
import cn.ibizlab.ehr.core.pcm.filter.PCMSYQGZSearchContext;




@Slf4j
@Api(tags = {"PCMSYQGZ" })
@RestController("WebApi-pcmsyqgz")
@RequestMapping("")
public class PCMSYQGZResource {

    @Autowired
    private IPCMSYQGZService pcmsyqgzService;

    @Autowired
    @Lazy
    private PCMSYQGZMapping pcmsyqgzMapping;




    @PreAuthorize("hasPermission(#pcmsyqgz_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PCMSYQGZ" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmsyqgzs/{pcmsyqgz_id}")
    @Transactional
    public ResponseEntity<PCMSYQGZDTO> update(@PathVariable("pcmsyqgz_id") String pcmsyqgz_id, @RequestBody PCMSYQGZDTO pcmsyqgzdto) {
		PCMSYQGZ domain = pcmsyqgzMapping.toDomain(pcmsyqgzdto);
        domain.setPcmsyqgzid(pcmsyqgz_id);
		pcmsyqgzService.update(domain);
		PCMSYQGZDTO dto = pcmsyqgzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pcmsyqgz_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMSYQGZ" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmsyqgzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMSYQGZDTO> pcmsyqgzdtos) {
        pcmsyqgzService.updateBatch(pcmsyqgzMapping.toDomain(pcmsyqgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pcmsyqgz_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PCMSYQGZ" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmsyqgzs/{pcmsyqgz_id}")
    public ResponseEntity<PCMSYQGZDTO> get(@PathVariable("pcmsyqgz_id") String pcmsyqgz_id) {
        PCMSYQGZ domain = pcmsyqgzService.get(pcmsyqgz_id);
        PCMSYQGZDTO dto = pcmsyqgzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PCMSYQGZ" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmsyqgzs")
    @Transactional
    public ResponseEntity<PCMSYQGZDTO> create(@RequestBody PCMSYQGZDTO pcmsyqgzdto) {
        PCMSYQGZ domain = pcmsyqgzMapping.toDomain(pcmsyqgzdto);
		pcmsyqgzService.create(domain);
        PCMSYQGZDTO dto = pcmsyqgzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PCMSYQGZ" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmsyqgzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMSYQGZDTO> pcmsyqgzdtos) {
        pcmsyqgzService.createBatch(pcmsyqgzMapping.toDomain(pcmsyqgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"PCMSYQGZ" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmsyqgzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMSYQGZDTO pcmsyqgzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmsyqgzService.checkKey(pcmsyqgzMapping.toDomain(pcmsyqgzdto)));
    }




    @PreAuthorize("hasPermission('Remove',{#pcmsyqgz_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PCMSYQGZ" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmsyqgzs/{pcmsyqgz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmsyqgz_id") String pcmsyqgz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmsyqgzService.remove(pcmsyqgz_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PCMSYQGZ" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmsyqgzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmsyqgzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"PCMSYQGZ" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmsyqgzs/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMSYQGZDTO pcmsyqgzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmsyqgzService.save(pcmsyqgzMapping.toDomain(pcmsyqgzdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PCMSYQGZ" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmsyqgzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMSYQGZDTO> pcmsyqgzdtos) {
        pcmsyqgzService.saveBatch(pcmsyqgzMapping.toDomain(pcmsyqgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PCMSYQGZ" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmsyqgzs/getdraft")
    public ResponseEntity<PCMSYQGZDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmsyqgzMapping.toDto(pcmsyqgzService.getDraft(new PCMSYQGZ())));
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMSYQGZ" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmsyqgzs/fetchdefault")
	public ResponseEntity<List<PCMSYQGZDTO>> fetchDefault(PCMSYQGZSearchContext context) {
        Page<PCMSYQGZ> domains = pcmsyqgzService.searchDefault(context) ;
        List<PCMSYQGZDTO> list = pcmsyqgzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"PCMSYQGZ" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmsyqgzs/searchdefault")
	public ResponseEntity<Page<PCMSYQGZDTO>> searchDefault(@RequestBody PCMSYQGZSearchContext context) {
        Page<PCMSYQGZ> domains = pcmsyqgzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmsyqgzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PCMSYQGZ getEntity(){
        return new PCMSYQGZ();
    }

}
