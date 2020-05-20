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
import cn.ibizlab.ehr.core.pcm.domain.PCMJXSGZ;
import cn.ibizlab.ehr.core.pcm.service.IPCMJXSGZService;
import cn.ibizlab.ehr.core.pcm.filter.PCMJXSGZSearchContext;




@Slf4j
@Api(tags = {"PCMJXSGZ" })
@RestController("WebApi-pcmjxsgz")
@RequestMapping("")
public class PCMJXSGZResource {

    @Autowired
    private IPCMJXSGZService pcmjxsgzService;

    @Autowired
    @Lazy
    private PCMJXSGZMapping pcmjxsgzMapping;




    @ApiOperation(value = "CheckKey", tags = {"PCMJXSGZ" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsgzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMJXSGZDTO pcmjxsgzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmjxsgzService.checkKey(pcmjxsgzMapping.toDomain(pcmjxsgzdto)));
    }




    @PreAuthorize("hasPermission(#pcmjxsgz_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"PCMJXSGZ" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmjxsgzs/{pcmjxsgz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmjxsgz_id") String pcmjxsgz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmjxsgzService.remove(pcmjxsgz_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PCMJXSGZ" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmjxsgzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmjxsgzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pcmjxsgz_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PCMJXSGZ" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmjxsgzs/{pcmjxsgz_id}")
    @Transactional
    public ResponseEntity<PCMJXSGZDTO> update(@PathVariable("pcmjxsgz_id") String pcmjxsgz_id, @RequestBody PCMJXSGZDTO pcmjxsgzdto) {
		PCMJXSGZ domain = pcmjxsgzMapping.toDomain(pcmjxsgzdto);
        domain.setPcmjxsgzid(pcmjxsgz_id);
		pcmjxsgzService.update(domain);
		PCMJXSGZDTO dto = pcmjxsgzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pcmjxsgz_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMJXSGZ" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmjxsgzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMJXSGZDTO> pcmjxsgzdtos) {
        pcmjxsgzService.updateBatch(pcmjxsgzMapping.toDomain(pcmjxsgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pcmjxsgz_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PCMJXSGZ" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmjxsgzs/{pcmjxsgz_id}")
    public ResponseEntity<PCMJXSGZDTO> get(@PathVariable("pcmjxsgz_id") String pcmjxsgz_id) {
        PCMJXSGZ domain = pcmjxsgzService.get(pcmjxsgz_id);
        PCMJXSGZDTO dto = pcmjxsgzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "GetDraft", tags = {"PCMJXSGZ" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmjxsgzs/getdraft")
    public ResponseEntity<PCMJXSGZDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsgzMapping.toDto(pcmjxsgzService.getDraft(new PCMJXSGZ())));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PCMJXSGZ" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsgzs")
    @Transactional
    public ResponseEntity<PCMJXSGZDTO> create(@RequestBody PCMJXSGZDTO pcmjxsgzdto) {
        PCMJXSGZ domain = pcmjxsgzMapping.toDomain(pcmjxsgzdto);
		pcmjxsgzService.create(domain);
        PCMJXSGZDTO dto = pcmjxsgzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PCMJXSGZ" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsgzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMJXSGZDTO> pcmjxsgzdtos) {
        pcmjxsgzService.createBatch(pcmjxsgzMapping.toDomain(pcmjxsgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"PCMJXSGZ" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsgzs/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMJXSGZDTO pcmjxsgzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsgzService.save(pcmjxsgzMapping.toDomain(pcmjxsgzdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PCMJXSGZ" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsgzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMJXSGZDTO> pcmjxsgzdtos) {
        pcmjxsgzService.saveBatch(pcmjxsgzMapping.toDomain(pcmjxsgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMJXSGZ-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMJXSGZ" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmjxsgzs/fetchdefault")
	public ResponseEntity<List<PCMJXSGZDTO>> fetchDefault(PCMJXSGZSearchContext context) {
        Page<PCMJXSGZ> domains = pcmjxsgzService.searchDefault(context) ;
        List<PCMJXSGZDTO> list = pcmjxsgzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMJXSGZ-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMJXSGZ" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmjxsgzs/searchdefault")
	public ResponseEntity<Page<PCMJXSGZDTO>> searchDefault(@RequestBody PCMJXSGZSearchContext context) {
        Page<PCMJXSGZ> domains = pcmjxsgzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmjxsgzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PCMJXSGZ getEntity(){
        return new PCMJXSGZ();
    }

}
