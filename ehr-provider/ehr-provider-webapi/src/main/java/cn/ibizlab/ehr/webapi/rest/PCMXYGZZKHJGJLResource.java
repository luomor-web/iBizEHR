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
import cn.ibizlab.ehr.core.pcm.domain.PCMXYGZZKHJGJL;
import cn.ibizlab.ehr.core.pcm.service.IPCMXYGZZKHJGJLService;
import cn.ibizlab.ehr.core.pcm.filter.PCMXYGZZKHJGJLSearchContext;




@Slf4j
@Api(tags = {"PCMXYGZZKHJGJL" })
@RestController("WebApi-pcmxygzzkhjgjl")
@RequestMapping("")
public class PCMXYGZZKHJGJLResource {

    @Autowired
    private IPCMXYGZZKHJGJLService pcmxygzzkhjgjlService;

    @Autowired
    @Lazy
    private PCMXYGZZKHJGJLMapping pcmxygzzkhjgjlMapping;




    @PreAuthorize("hasPermission(#pcmxygzzkhjgjl_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PCMXYGZZKHJGJL" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmxygzzkhjgjls/{pcmxygzzkhjgjl_id}")
    @Transactional
    public ResponseEntity<PCMXYGZZKHJGJLDTO> update(@PathVariable("pcmxygzzkhjgjl_id") String pcmxygzzkhjgjl_id, @RequestBody PCMXYGZZKHJGJLDTO pcmxygzzkhjgjldto) {
		PCMXYGZZKHJGJL domain = pcmxygzzkhjgjlMapping.toDomain(pcmxygzzkhjgjldto);
        domain.setPcmxygzzkhjgjlid(pcmxygzzkhjgjl_id);
		pcmxygzzkhjgjlService.update(domain);
		PCMXYGZZKHJGJLDTO dto = pcmxygzzkhjgjlMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pcmxygzzkhjgjl_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMXYGZZKHJGJL" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmxygzzkhjgjls/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMXYGZZKHJGJLDTO> pcmxygzzkhjgjldtos) {
        pcmxygzzkhjgjlService.updateBatch(pcmxygzzkhjgjlMapping.toDomain(pcmxygzzkhjgjldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pcmxygzzkhjgjl_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PCMXYGZZKHJGJL" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmxygzzkhjgjls/{pcmxygzzkhjgjl_id}")
    public ResponseEntity<PCMXYGZZKHJGJLDTO> get(@PathVariable("pcmxygzzkhjgjl_id") String pcmxygzzkhjgjl_id) {
        PCMXYGZZKHJGJL domain = pcmxygzzkhjgjlService.get(pcmxygzzkhjgjl_id);
        PCMXYGZZKHJGJLDTO dto = pcmxygzzkhjgjlMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PCMXYGZZKHJGJL" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzkhjgjls")
    @Transactional
    public ResponseEntity<PCMXYGZZKHJGJLDTO> create(@RequestBody PCMXYGZZKHJGJLDTO pcmxygzzkhjgjldto) {
        PCMXYGZZKHJGJL domain = pcmxygzzkhjgjlMapping.toDomain(pcmxygzzkhjgjldto);
		pcmxygzzkhjgjlService.create(domain);
        PCMXYGZZKHJGJLDTO dto = pcmxygzzkhjgjlMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PCMXYGZZKHJGJL" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzkhjgjls/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMXYGZZKHJGJLDTO> pcmxygzzkhjgjldtos) {
        pcmxygzzkhjgjlService.createBatch(pcmxygzzkhjgjlMapping.toDomain(pcmxygzzkhjgjldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#pcmxygzzkhjgjl_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PCMXYGZZKHJGJL" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmxygzzkhjgjls/{pcmxygzzkhjgjl_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmxygzzkhjgjl_id") String pcmxygzzkhjgjl_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzkhjgjlService.remove(pcmxygzzkhjgjl_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PCMXYGZZKHJGJL" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmxygzzkhjgjls/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmxygzzkhjgjlService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"PCMXYGZZKHJGJL" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzkhjgjls/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMXYGZZKHJGJLDTO pcmxygzzkhjgjldto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzkhjgjlService.save(pcmxygzzkhjgjlMapping.toDomain(pcmxygzzkhjgjldto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PCMXYGZZKHJGJL" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzkhjgjls/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMXYGZZKHJGJLDTO> pcmxygzzkhjgjldtos) {
        pcmxygzzkhjgjlService.saveBatch(pcmxygzzkhjgjlMapping.toDomain(pcmxygzzkhjgjldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PCMXYGZZKHJGJL" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmxygzzkhjgjls/getdraft")
    public ResponseEntity<PCMXYGZZKHJGJLDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzkhjgjlMapping.toDto(pcmxygzzkhjgjlService.getDraft(new PCMXYGZZKHJGJL())));
    }




    @ApiOperation(value = "CheckKey", tags = {"PCMXYGZZKHJGJL" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzkhjgjls/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMXYGZZKHJGJLDTO pcmxygzzkhjgjldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmxygzzkhjgjlService.checkKey(pcmxygzzkhjgjlMapping.toDomain(pcmxygzzkhjgjldto)));
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMXYGZZKHJGJL" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmxygzzkhjgjls/fetchdefault")
	public ResponseEntity<List<PCMXYGZZKHJGJLDTO>> fetchDefault(PCMXYGZZKHJGJLSearchContext context) {
        Page<PCMXYGZZKHJGJL> domains = pcmxygzzkhjgjlService.searchDefault(context) ;
        List<PCMXYGZZKHJGJLDTO> list = pcmxygzzkhjgjlMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMXYGZZKHJGJL" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmxygzzkhjgjls/searchdefault")
	public ResponseEntity<Page<PCMXYGZZKHJGJLDTO>> searchDefault(PCMXYGZZKHJGJLSearchContext context) {
        Page<PCMXYGZZKHJGJL> domains = pcmxygzzkhjgjlService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmxygzzkhjgjlMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PCMXYGZZKHJGJL getEntity(){
        return new PCMXYGZZKHJGJL();
    }

}