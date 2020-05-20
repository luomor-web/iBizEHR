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
import cn.ibizlab.ehr.core.pcm.domain.PCMJXSBDJL;
import cn.ibizlab.ehr.core.pcm.service.IPCMJXSBDJLService;
import cn.ibizlab.ehr.core.pcm.filter.PCMJXSBDJLSearchContext;




@Slf4j
@Api(tags = {"PCMJXSBDJL" })
@RestController("WebApi-pcmjxsbdjl")
@RequestMapping("")
public class PCMJXSBDJLResource {

    @Autowired
    private IPCMJXSBDJLService pcmjxsbdjlService;

    @Autowired
    @Lazy
    private PCMJXSBDJLMapping pcmjxsbdjlMapping;




    @ApiOperation(value = "CheckKey", tags = {"PCMJXSBDJL" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsbdjls/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMJXSBDJLDTO pcmjxsbdjldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmjxsbdjlService.checkKey(pcmjxsbdjlMapping.toDomain(pcmjxsbdjldto)));
    }




    @PreAuthorize("hasPermission(#pcmjxsbdjl_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PCMJXSBDJL" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmjxsbdjls/{pcmjxsbdjl_id}")
    public ResponseEntity<PCMJXSBDJLDTO> get(@PathVariable("pcmjxsbdjl_id") String pcmjxsbdjl_id) {
        PCMJXSBDJL domain = pcmjxsbdjlService.get(pcmjxsbdjl_id);
        PCMJXSBDJLDTO dto = pcmjxsbdjlMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#pcmjxsbdjl_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PCMJXSBDJL" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmjxsbdjls/{pcmjxsbdjl_id}")
    @Transactional
    public ResponseEntity<PCMJXSBDJLDTO> update(@PathVariable("pcmjxsbdjl_id") String pcmjxsbdjl_id, @RequestBody PCMJXSBDJLDTO pcmjxsbdjldto) {
		PCMJXSBDJL domain = pcmjxsbdjlMapping.toDomain(pcmjxsbdjldto);
        domain.setPcmjxsbdjlid(pcmjxsbdjl_id);
		pcmjxsbdjlService.update(domain);
		PCMJXSBDJLDTO dto = pcmjxsbdjlMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pcmjxsbdjl_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMJXSBDJL" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmjxsbdjls/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMJXSBDJLDTO> pcmjxsbdjldtos) {
        pcmjxsbdjlService.updateBatch(pcmjxsbdjlMapping.toDomain(pcmjxsbdjldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#pcmjxsbdjl_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PCMJXSBDJL" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmjxsbdjls/{pcmjxsbdjl_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmjxsbdjl_id") String pcmjxsbdjl_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmjxsbdjlService.remove(pcmjxsbdjl_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PCMJXSBDJL" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmjxsbdjls/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmjxsbdjlService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"PCMJXSBDJL" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsbdjls/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMJXSBDJLDTO pcmjxsbdjldto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsbdjlService.save(pcmjxsbdjlMapping.toDomain(pcmjxsbdjldto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PCMJXSBDJL" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsbdjls/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMJXSBDJLDTO> pcmjxsbdjldtos) {
        pcmjxsbdjlService.saveBatch(pcmjxsbdjlMapping.toDomain(pcmjxsbdjldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PCMJXSBDJL" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsbdjls")
    @Transactional
    public ResponseEntity<PCMJXSBDJLDTO> create(@RequestBody PCMJXSBDJLDTO pcmjxsbdjldto) {
        PCMJXSBDJL domain = pcmjxsbdjlMapping.toDomain(pcmjxsbdjldto);
		pcmjxsbdjlService.create(domain);
        PCMJXSBDJLDTO dto = pcmjxsbdjlMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PCMJXSBDJL" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsbdjls/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMJXSBDJLDTO> pcmjxsbdjldtos) {
        pcmjxsbdjlService.createBatch(pcmjxsbdjlMapping.toDomain(pcmjxsbdjldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PCMJXSBDJL" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmjxsbdjls/getdraft")
    public ResponseEntity<PCMJXSBDJLDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsbdjlMapping.toDto(pcmjxsbdjlService.getDraft(new PCMJXSBDJL())));
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMJXSBDJL" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmjxsbdjls/fetchdefault")
	public ResponseEntity<List<PCMJXSBDJLDTO>> fetchDefault(PCMJXSBDJLSearchContext context) {
        Page<PCMJXSBDJL> domains = pcmjxsbdjlService.searchDefault(context) ;
        List<PCMJXSBDJLDTO> list = pcmjxsbdjlMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"PCMJXSBDJL" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmjxsbdjls/searchdefault")
	public ResponseEntity<Page<PCMJXSBDJLDTO>> searchDefault(@RequestBody PCMJXSBDJLSearchContext context) {
        Page<PCMJXSBDJL> domains = pcmjxsbdjlService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmjxsbdjlMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch自助(见习记录)", tags = {"PCMJXSBDJL" } ,notes = "fetch自助(见习记录)")
    @RequestMapping(method= RequestMethod.GET , value="/pcmjxsbdjls/fetchzizhu")
	public ResponseEntity<List<PCMJXSBDJLDTO>> fetchZIZHU(PCMJXSBDJLSearchContext context) {
        Page<PCMJXSBDJL> domains = pcmjxsbdjlService.searchZIZHU(context) ;
        List<PCMJXSBDJLDTO> list = pcmjxsbdjlMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search自助(见习记录)", tags = {"PCMJXSBDJL" } ,notes = "search自助(见习记录)")
    @RequestMapping(method= RequestMethod.POST , value="/pcmjxsbdjls/searchzizhu")
	public ResponseEntity<Page<PCMJXSBDJLDTO>> searchZIZHU(@RequestBody PCMJXSBDJLSearchContext context) {
        Page<PCMJXSBDJL> domains = pcmjxsbdjlService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmjxsbdjlMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch记录所属和人员ID不符的", tags = {"PCMJXSBDJL" } ,notes = "fetch记录所属和人员ID不符的")
    @RequestMapping(method= RequestMethod.GET , value="/pcmjxsbdjls/fetchjlss")
	public ResponseEntity<List<PCMJXSBDJLDTO>> fetchJLSS(PCMJXSBDJLSearchContext context) {
        Page<PCMJXSBDJL> domains = pcmjxsbdjlService.searchJLSS(context) ;
        List<PCMJXSBDJLDTO> list = pcmjxsbdjlMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search记录所属和人员ID不符的", tags = {"PCMJXSBDJL" } ,notes = "search记录所属和人员ID不符的")
    @RequestMapping(method= RequestMethod.POST , value="/pcmjxsbdjls/searchjlss")
	public ResponseEntity<Page<PCMJXSBDJLDTO>> searchJLSS(@RequestBody PCMJXSBDJLSearchContext context) {
        Page<PCMJXSBDJL> domains = pcmjxsbdjlService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmjxsbdjlMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PCMJXSBDJL getEntity(){
        return new PCMJXSBDJL();
    }

}
