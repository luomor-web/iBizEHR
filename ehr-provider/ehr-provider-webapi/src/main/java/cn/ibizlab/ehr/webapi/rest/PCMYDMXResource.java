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
import cn.ibizlab.ehr.core.pcm.domain.PCMYDMX;
import cn.ibizlab.ehr.core.pcm.service.IPCMYDMXService;
import cn.ibizlab.ehr.core.pcm.filter.PCMYDMXSearchContext;




@Slf4j
@Api(tags = {"PCMYDMX" })
@RestController("WebApi-pcmydmx")
@RequestMapping("")
public class PCMYDMXResource {

    @Autowired
    private IPCMYDMXService pcmydmxService;

    @Autowired
    @Lazy
    private PCMYDMXMapping pcmydmxMapping;




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PCMYDMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydmxes")
    @Transactional
    public ResponseEntity<PCMYDMXDTO> create(@RequestBody PCMYDMXDTO pcmydmxdto) {
        PCMYDMX domain = pcmydmxMapping.toDomain(pcmydmxdto);
		pcmydmxService.create(domain);
        PCMYDMXDTO dto = pcmydmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PCMYDMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMYDMXDTO> pcmydmxdtos) {
        pcmydmxService.createBatch(pcmydmxMapping.toDomain(pcmydmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"PCMYDMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMYDMXDTO pcmydmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydmxService.save(pcmydmxMapping.toDomain(pcmydmxdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PCMYDMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMYDMXDTO> pcmydmxdtos) {
        pcmydmxService.saveBatch(pcmydmxMapping.toDomain(pcmydmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "填充员工信息", tags = {"PCMYDMX" },  notes = "填充员工信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydmxes/{pcmydmx_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PCMYDMXDTO> fillPersonInfo(@PathVariable("pcmydmx_id") String pcmydmx_id, @RequestBody PCMYDMXDTO pcmydmxdto) {
        PCMYDMX pcmydmx = pcmydmxMapping.toDomain(pcmydmxdto);
        pcmydmx = pcmydmxService.fillPersonInfo(pcmydmx);
        pcmydmxdto = pcmydmxMapping.toDto(pcmydmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydmxdto);
    }




    @ApiOperation(value = "CheckKey", tags = {"PCMYDMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMYDMXDTO pcmydmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmydmxService.checkKey(pcmydmxMapping.toDomain(pcmydmxdto)));
    }




    @PreAuthorize("hasPermission('Remove',{#pcmydmx_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PCMYDMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydmxes/{pcmydmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmydmx_id") String pcmydmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmydmxService.remove(pcmydmx_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PCMYDMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmydmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pcmydmx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PCMYDMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydmxes/{pcmydmx_id}")
    @Transactional
    public ResponseEntity<PCMYDMXDTO> update(@PathVariable("pcmydmx_id") String pcmydmx_id, @RequestBody PCMYDMXDTO pcmydmxdto) {
		PCMYDMX domain = pcmydmxMapping.toDomain(pcmydmxdto);
        domain.setPcmydmxid(pcmydmx_id);
		pcmydmxService.update(domain);
		PCMYDMXDTO dto = pcmydmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pcmydmx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMYDMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMYDMXDTO> pcmydmxdtos) {
        pcmydmxService.updateBatch(pcmydmxMapping.toDomain(pcmydmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PCMYDMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydmxes/getdraft")
    public ResponseEntity<PCMYDMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydmxMapping.toDto(pcmydmxService.getDraft(new PCMYDMX())));
    }




    @PreAuthorize("hasPermission(#pcmydmx_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PCMYDMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydmxes/{pcmydmx_id}")
    public ResponseEntity<PCMYDMXDTO> get(@PathVariable("pcmydmx_id") String pcmydmx_id) {
        PCMYDMX domain = pcmydmxService.get(pcmydmx_id);
        PCMYDMXDTO dto = pcmydmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Get',{#context,'IndexDER',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchIndexDER", tags = {"PCMYDMX" } ,notes = "fetchIndexDER")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydmxes/fetchindexder")
	public ResponseEntity<List<PCMYDMXDTO>> fetchIndexDER(PCMYDMXSearchContext context) {
        Page<PCMYDMX> domains = pcmydmxService.searchIndexDER(context) ;
        List<PCMYDMXDTO> list = pcmydmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'IndexDER',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchIndexDER", tags = {"PCMYDMX" } ,notes = "searchIndexDER")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydmxes/searchindexder")
	public ResponseEntity<Page<PCMYDMXDTO>> searchIndexDER(PCMYDMXSearchContext context) {
        Page<PCMYDMX> domains = pcmydmxService.searchIndexDER(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMYDMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydmxes/fetchdefault")
	public ResponseEntity<List<PCMYDMXDTO>> fetchDefault(PCMYDMXSearchContext context) {
        Page<PCMYDMX> domains = pcmydmxService.searchDefault(context) ;
        List<PCMYDMXDTO> list = pcmydmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMYDMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydmxes/searchdefault")
	public ResponseEntity<Page<PCMYDMXDTO>> searchDefault(PCMYDMXSearchContext context) {
        Page<PCMYDMX> domains = pcmydmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PCMYDMX getEntity(){
        return new PCMYDMX();
    }

}