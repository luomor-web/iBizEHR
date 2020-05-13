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
import cn.ibizlab.ehr.core.pcm.domain.PCMXKML;
import cn.ibizlab.ehr.core.pcm.service.IPCMXKMLService;
import cn.ibizlab.ehr.core.pcm.filter.PCMXKMLSearchContext;




@Slf4j
@Api(tags = {"PCMXKML" })
@RestController("WebApi-pcmxkml")
@RequestMapping("")
public class PCMXKMLResource {

    @Autowired
    private IPCMXKMLService pcmxkmlService;

    @Autowired
    @Lazy
    private PCMXKMLMapping pcmxkmlMapping;




    @PreAuthorize("hasPermission(#pcmxkml_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PCMXKML" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmxkmls/{pcmxkml_id}")
    @Transactional
    public ResponseEntity<PCMXKMLDTO> update(@PathVariable("pcmxkml_id") String pcmxkml_id, @RequestBody PCMXKMLDTO pcmxkmldto) {
		PCMXKML domain = pcmxkmlMapping.toDomain(pcmxkmldto);
        domain.setPcmxkmlid(pcmxkml_id);
		pcmxkmlService.update(domain);
		PCMXKMLDTO dto = pcmxkmlMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pcmxkml_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMXKML" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmxkmls/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMXKMLDTO> pcmxkmldtos) {
        pcmxkmlService.updateBatch(pcmxkmlMapping.toDomain(pcmxkmldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#pcmxkml_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PCMXKML" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmxkmls/{pcmxkml_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmxkml_id") String pcmxkml_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmxkmlService.remove(pcmxkml_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PCMXKML" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmxkmls/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmxkmlService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pcmxkml_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PCMXKML" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmxkmls/{pcmxkml_id}")
    public ResponseEntity<PCMXKMLDTO> get(@PathVariable("pcmxkml_id") String pcmxkml_id) {
        PCMXKML domain = pcmxkmlService.get(pcmxkml_id);
        PCMXKMLDTO dto = pcmxkmlMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PCMXKML" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxkmls")
    @Transactional
    public ResponseEntity<PCMXKMLDTO> create(@RequestBody PCMXKMLDTO pcmxkmldto) {
        PCMXKML domain = pcmxkmlMapping.toDomain(pcmxkmldto);
		pcmxkmlService.create(domain);
        PCMXKMLDTO dto = pcmxkmlMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PCMXKML" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxkmls/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMXKMLDTO> pcmxkmldtos) {
        pcmxkmlService.createBatch(pcmxkmlMapping.toDomain(pcmxkmldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"PCMXKML" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxkmls/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMXKMLDTO pcmxkmldto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmxkmlService.save(pcmxkmlMapping.toDomain(pcmxkmldto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PCMXKML" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxkmls/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMXKMLDTO> pcmxkmldtos) {
        pcmxkmlService.saveBatch(pcmxkmlMapping.toDomain(pcmxkmldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"PCMXKML" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxkmls/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMXKMLDTO pcmxkmldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmxkmlService.checkKey(pcmxkmlMapping.toDomain(pcmxkmldto)));
    }




    @ApiOperation(value = "GetDraft", tags = {"PCMXKML" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmxkmls/getdraft")
    public ResponseEntity<PCMXKMLDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmxkmlMapping.toDto(pcmxkmlService.getDraft(new PCMXKML())));
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMXKML" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmxkmls/fetchdefault")
	public ResponseEntity<List<PCMXKMLDTO>> fetchDefault(PCMXKMLSearchContext context) {
        Page<PCMXKML> domains = pcmxkmlService.searchDefault(context) ;
        List<PCMXKMLDTO> list = pcmxkmlMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMXKML" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmxkmls/searchdefault")
	public ResponseEntity<Page<PCMXKMLDTO>> searchDefault(PCMXKMLSearchContext context) {
        Page<PCMXKML> domains = pcmxkmlService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmxkmlMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'CurND',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch当前年度", tags = {"PCMXKML" } ,notes = "fetch当前年度")
    @RequestMapping(method= RequestMethod.GET , value="/pcmxkmls/fetchcurnd")
	public ResponseEntity<List<PCMXKMLDTO>> fetchCurND(PCMXKMLSearchContext context) {
        Page<PCMXKML> domains = pcmxkmlService.searchCurND(context) ;
        List<PCMXKMLDTO> list = pcmxkmlMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'CurND',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search当前年度", tags = {"PCMXKML" } ,notes = "search当前年度")
    @RequestMapping(method= RequestMethod.GET , value="/pcmxkmls/searchcurnd")
	public ResponseEntity<Page<PCMXKMLDTO>> searchCurND(PCMXKMLSearchContext context) {
        Page<PCMXKML> domains = pcmxkmlService.searchCurND(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmxkmlMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PCMXKML getEntity(){
        return new PCMXKML();
    }

}