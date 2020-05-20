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
import cn.ibizlab.ehr.core.pcm.domain.PCMYDTXMX;
import cn.ibizlab.ehr.core.pcm.service.IPCMYDTXMXService;
import cn.ibizlab.ehr.core.pcm.filter.PCMYDTXMXSearchContext;




@Slf4j
@Api(tags = {"PCMYDTXMX" })
@RestController("WebApi-pcmydtxmx")
@RequestMapping("")
public class PCMYDTXMXResource {

    @Autowired
    private IPCMYDTXMXService pcmydtxmxService;

    @Autowired
    @Lazy
    private PCMYDTXMXMapping pcmydtxmxMapping;




    @PreAuthorize("hasPermission('Remove',{#pcmydtxmx_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PCMYDTXMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydtxmxes/{pcmydtxmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmydtxmx_id") String pcmydtxmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmydtxmxService.remove(pcmydtxmx_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PCMYDTXMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydtxmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmydtxmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PCMYDTXMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydtxmxes")
    @Transactional
    public ResponseEntity<PCMYDTXMXDTO> create(@RequestBody PCMYDTXMXDTO pcmydtxmxdto) {
        PCMYDTXMX domain = pcmydtxmxMapping.toDomain(pcmydtxmxdto);
		pcmydtxmxService.create(domain);
        PCMYDTXMXDTO dto = pcmydtxmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PCMYDTXMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydtxmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMYDTXMXDTO> pcmydtxmxdtos) {
        pcmydtxmxService.createBatch(pcmydtxmxMapping.toDomain(pcmydtxmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"PCMYDTXMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydtxmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMYDTXMXDTO pcmydtxmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydtxmxService.save(pcmydtxmxMapping.toDomain(pcmydtxmxdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PCMYDTXMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydtxmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMYDTXMXDTO> pcmydtxmxdtos) {
        pcmydtxmxService.saveBatch(pcmydtxmxMapping.toDomain(pcmydtxmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PCMYDTXMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydtxmxes/getdraft")
    public ResponseEntity<PCMYDTXMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydtxmxMapping.toDto(pcmydtxmxService.getDraft(new PCMYDTXMX())));
    }




    @PreAuthorize("hasPermission(#pcmydtxmx_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PCMYDTXMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydtxmxes/{pcmydtxmx_id}")
    public ResponseEntity<PCMYDTXMXDTO> get(@PathVariable("pcmydtxmx_id") String pcmydtxmx_id) {
        PCMYDTXMX domain = pcmydtxmxService.get(pcmydtxmx_id);
        PCMYDTXMXDTO dto = pcmydtxmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "CheckKey", tags = {"PCMYDTXMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydtxmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMYDTXMXDTO pcmydtxmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmydtxmxService.checkKey(pcmydtxmxMapping.toDomain(pcmydtxmxdto)));
    }




    @PreAuthorize("hasPermission(#pcmydtxmx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PCMYDTXMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydtxmxes/{pcmydtxmx_id}")
    @Transactional
    public ResponseEntity<PCMYDTXMXDTO> update(@PathVariable("pcmydtxmx_id") String pcmydtxmx_id, @RequestBody PCMYDTXMXDTO pcmydtxmxdto) {
		PCMYDTXMX domain = pcmydtxmxMapping.toDomain(pcmydtxmxdto);
        domain.setPcmydtxmxid(pcmydtxmx_id);
		pcmydtxmxService.update(domain);
		PCMYDTXMXDTO dto = pcmydtxmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pcmydtxmx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMYDTXMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydtxmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMYDTXMXDTO> pcmydtxmxdtos) {
        pcmydtxmxService.updateBatch(pcmydtxmxMapping.toDomain(pcmydtxmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "填充人员信息", tags = {"PCMYDTXMX" },  notes = "填充人员信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydtxmxes/{pcmydtxmx_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PCMYDTXMXDTO> fillPersonInfo(@PathVariable("pcmydtxmx_id") String pcmydtxmx_id, @RequestBody PCMYDTXMXDTO pcmydtxmxdto) {
        PCMYDTXMX pcmydtxmx = pcmydtxmxMapping.toDomain(pcmydtxmxdto);
        pcmydtxmx = pcmydtxmxService.fillPersonInfo(pcmydtxmx);
        pcmydtxmxdto = pcmydtxmxMapping.toDto(pcmydtxmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydtxmxdto);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMYDTXMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydtxmxes/fetchdefault")
	public ResponseEntity<List<PCMYDTXMXDTO>> fetchDefault(PCMYDTXMXSearchContext context) {
        Page<PCMYDTXMX> domains = pcmydtxmxService.searchDefault(context) ;
        List<PCMYDTXMXDTO> list = pcmydtxmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"PCMYDTXMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydtxmxes/searchdefault")
	public ResponseEntity<Page<PCMYDTXMXDTO>> searchDefault(@RequestBody PCMYDTXMXSearchContext context) {
        Page<PCMYDTXMX> domains = pcmydtxmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydtxmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch管理查询", tags = {"PCMYDTXMX" } ,notes = "fetch管理查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydtxmxes/fetchglds")
	public ResponseEntity<List<PCMYDTXMXDTO>> fetchGLDS(PCMYDTXMXSearchContext context) {
        Page<PCMYDTXMX> domains = pcmydtxmxService.searchGLDS(context) ;
        List<PCMYDTXMXDTO> list = pcmydtxmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search管理查询", tags = {"PCMYDTXMX" } ,notes = "search管理查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydtxmxes/searchglds")
	public ResponseEntity<Page<PCMYDTXMXDTO>> searchGLDS(@RequestBody PCMYDTXMXSearchContext context) {
        Page<PCMYDTXMX> domains = pcmydtxmxService.searchGLDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydtxmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch记录查询", tags = {"PCMYDTXMX" } ,notes = "fetch记录查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydtxmxes/fetchjlds")
	public ResponseEntity<List<PCMYDTXMXDTO>> fetchJLDS(PCMYDTXMXSearchContext context) {
        Page<PCMYDTXMX> domains = pcmydtxmxService.searchJLDS(context) ;
        List<PCMYDTXMXDTO> list = pcmydtxmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search记录查询", tags = {"PCMYDTXMX" } ,notes = "search记录查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydtxmxes/searchjlds")
	public ResponseEntity<Page<PCMYDTXMXDTO>> searchJLDS(@RequestBody PCMYDTXMXSearchContext context) {
        Page<PCMYDTXMX> domains = pcmydtxmxService.searchJLDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydtxmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PCMYDTXMX getEntity(){
        return new PCMYDTXMX();
    }

}
