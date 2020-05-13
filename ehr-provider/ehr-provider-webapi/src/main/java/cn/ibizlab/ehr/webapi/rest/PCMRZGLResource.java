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
import cn.ibizlab.ehr.core.pcm.domain.PCMRZGL;
import cn.ibizlab.ehr.core.pcm.service.IPCMRZGLService;
import cn.ibizlab.ehr.core.pcm.filter.PCMRZGLSearchContext;




@Slf4j
@Api(tags = {"PCMRZGL" })
@RestController("WebApi-pcmrzgl")
@RequestMapping("")
public class PCMRZGLResource {

    @Autowired
    private IPCMRZGLService pcmrzglService;

    @Autowired
    @Lazy
    private PCMRZGLMapping pcmrzglMapping;




    @PreAuthorize("hasPermission(#pcmrzgl_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PCMRZGL" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmrzgls/{pcmrzgl_id}")
    public ResponseEntity<PCMRZGLDTO> get(@PathVariable("pcmrzgl_id") String pcmrzgl_id) {
        PCMRZGL domain = pcmrzglService.get(pcmrzgl_id);
        PCMRZGLDTO dto = pcmrzglMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "Save", tags = {"PCMRZGL" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmrzgls/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMRZGLDTO pcmrzgldto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmrzglService.save(pcmrzglMapping.toDomain(pcmrzgldto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PCMRZGL" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmrzgls/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMRZGLDTO> pcmrzgldtos) {
        pcmrzglService.saveBatch(pcmrzglMapping.toDomain(pcmrzgldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"PCMRZGL" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmrzgls/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMRZGLDTO pcmrzgldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmrzglService.checkKey(pcmrzglMapping.toDomain(pcmrzgldto)));
    }




    @PreAuthorize("hasPermission('Remove',{#pcmrzgl_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PCMRZGL" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmrzgls/{pcmrzgl_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmrzgl_id") String pcmrzgl_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmrzglService.remove(pcmrzgl_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PCMRZGL" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmrzgls/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmrzglService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PCMRZGL" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmrzgls")
    @Transactional
    public ResponseEntity<PCMRZGLDTO> create(@RequestBody PCMRZGLDTO pcmrzgldto) {
        PCMRZGL domain = pcmrzglMapping.toDomain(pcmrzgldto);
		pcmrzglService.create(domain);
        PCMRZGLDTO dto = pcmrzglMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PCMRZGL" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmrzgls/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMRZGLDTO> pcmrzgldtos) {
        pcmrzglService.createBatch(pcmrzglMapping.toDomain(pcmrzgldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PCMRZGL" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmrzgls/getdraft")
    public ResponseEntity<PCMRZGLDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmrzglMapping.toDto(pcmrzglService.getDraft(new PCMRZGL())));
    }




    @PreAuthorize("hasPermission(#pcmrzgl_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PCMRZGL" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmrzgls/{pcmrzgl_id}")
    @Transactional
    public ResponseEntity<PCMRZGLDTO> update(@PathVariable("pcmrzgl_id") String pcmrzgl_id, @RequestBody PCMRZGLDTO pcmrzgldto) {
		PCMRZGL domain = pcmrzglMapping.toDomain(pcmrzgldto);
        domain.setPcmrzglid(pcmrzgl_id);
		pcmrzglService.update(domain);
		PCMRZGLDTO dto = pcmrzglMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pcmrzgl_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMRZGL" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmrzgls/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMRZGLDTO> pcmrzgldtos) {
        pcmrzglService.updateBatch(pcmrzglMapping.toDomain(pcmrzgldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMRZGL" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmrzgls/fetchdefault")
	public ResponseEntity<List<PCMRZGLDTO>> fetchDefault(PCMRZGLSearchContext context) {
        Page<PCMRZGL> domains = pcmrzglService.searchDefault(context) ;
        List<PCMRZGLDTO> list = pcmrzglMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMRZGL" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmrzgls/searchdefault")
	public ResponseEntity<Page<PCMRZGLDTO>> searchDefault(PCMRZGLSearchContext context) {
        Page<PCMRZGL> domains = pcmrzglService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmrzglMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'GBRZQXDQ',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch干部任职期限查询", tags = {"PCMRZGL" } ,notes = "fetch干部任职期限查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmrzgls/fetchgbrzqxdq")
	public ResponseEntity<List<PCMRZGLDTO>> fetchGBRZQXDQ(PCMRZGLSearchContext context) {
        Page<PCMRZGL> domains = pcmrzglService.searchGBRZQXDQ(context) ;
        List<PCMRZGLDTO> list = pcmrzglMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'GBRZQXDQ',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search干部任职期限查询", tags = {"PCMRZGL" } ,notes = "search干部任职期限查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmrzgls/searchgbrzqxdq")
	public ResponseEntity<Page<PCMRZGLDTO>> searchGBRZQXDQ(PCMRZGLSearchContext context) {
        Page<PCMRZGL> domains = pcmrzglService.searchGBRZQXDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmrzglMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'RQCX',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchRQCX", tags = {"PCMRZGL" } ,notes = "fetchRQCX")
    @RequestMapping(method= RequestMethod.GET , value="/pcmrzgls/fetchrqcx")
	public ResponseEntity<List<PCMRZGLDTO>> fetchRQCX(PCMRZGLSearchContext context) {
        Page<PCMRZGL> domains = pcmrzglService.searchRQCX(context) ;
        List<PCMRZGLDTO> list = pcmrzglMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'RQCX',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchRQCX", tags = {"PCMRZGL" } ,notes = "searchRQCX")
    @RequestMapping(method= RequestMethod.GET , value="/pcmrzgls/searchrqcx")
	public ResponseEntity<Page<PCMRZGLDTO>> searchRQCX(PCMRZGLSearchContext context) {
        Page<PCMRZGL> domains = pcmrzglService.searchRQCX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmrzglMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PCMRZGL getEntity(){
        return new PCMRZGL();
    }

}
