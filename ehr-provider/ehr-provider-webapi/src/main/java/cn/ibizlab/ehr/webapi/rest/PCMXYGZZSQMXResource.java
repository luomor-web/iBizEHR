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
import cn.ibizlab.ehr.core.pcm.domain.PCMXYGZZSQMX;
import cn.ibizlab.ehr.core.pcm.service.IPCMXYGZZSQMXService;
import cn.ibizlab.ehr.core.pcm.filter.PCMXYGZZSQMXSearchContext;




@Slf4j
@Api(tags = {"PCMXYGZZSQMX" })
@RestController("WebApi-pcmxygzzsqmx")
@RequestMapping("")
public class PCMXYGZZSQMXResource {

    @Autowired
    private IPCMXYGZZSQMXService pcmxygzzsqmxService;

    @Autowired
    @Lazy
    private PCMXYGZZSQMXMapping pcmxygzzsqmxMapping;




    @PreAuthorize("hasPermission('Remove',{#pcmxygzzsqmx_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PCMXYGZZSQMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmxygzzsqmxes/{pcmxygzzsqmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmxygzzsqmx_id") String pcmxygzzsqmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzsqmxService.remove(pcmxygzzsqmx_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PCMXYGZZSQMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmxygzzsqmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmxygzzsqmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PCMXYGZZSQMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmxygzzsqmxes/getdraft")
    public ResponseEntity<PCMXYGZZSQMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzsqmxMapping.toDto(pcmxygzzsqmxService.getDraft(new PCMXYGZZSQMX())));
    }




    @PreAuthorize("hasPermission(#pcmxygzzsqmx_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PCMXYGZZSQMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmxygzzsqmxes/{pcmxygzzsqmx_id}")
    public ResponseEntity<PCMXYGZZSQMXDTO> get(@PathVariable("pcmxygzzsqmx_id") String pcmxygzzsqmx_id) {
        PCMXYGZZSQMX domain = pcmxygzzsqmxService.get(pcmxygzzsqmx_id);
        PCMXYGZZSQMXDTO dto = pcmxygzzsqmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#pcmxygzzsqmx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PCMXYGZZSQMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmxygzzsqmxes/{pcmxygzzsqmx_id}")
    @Transactional
    public ResponseEntity<PCMXYGZZSQMXDTO> update(@PathVariable("pcmxygzzsqmx_id") String pcmxygzzsqmx_id, @RequestBody PCMXYGZZSQMXDTO pcmxygzzsqmxdto) {
		PCMXYGZZSQMX domain = pcmxygzzsqmxMapping.toDomain(pcmxygzzsqmxdto);
        domain.setPcmxygzzsqmxid(pcmxygzzsqmx_id);
		pcmxygzzsqmxService.update(domain);
		PCMXYGZZSQMXDTO dto = pcmxygzzsqmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pcmxygzzsqmx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMXYGZZSQMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmxygzzsqmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMXYGZZSQMXDTO> pcmxygzzsqmxdtos) {
        pcmxygzzsqmxService.updateBatch(pcmxygzzsqmxMapping.toDomain(pcmxygzzsqmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "审核不通过", tags = {"PCMXYGZZSQMX" },  notes = "审核不通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzsqmxes/{pcmxygzzsqmx_id}/shbtg")
    @Transactional
    public ResponseEntity<PCMXYGZZSQMXDTO> sHBTG(@PathVariable("pcmxygzzsqmx_id") String pcmxygzzsqmx_id, @RequestBody PCMXYGZZSQMXDTO pcmxygzzsqmxdto) {
        PCMXYGZZSQMX pcmxygzzsqmx = pcmxygzzsqmxMapping.toDomain(pcmxygzzsqmxdto);
        pcmxygzzsqmx = pcmxygzzsqmxService.sHBTG(pcmxygzzsqmx);
        pcmxygzzsqmxdto = pcmxygzzsqmxMapping.toDto(pcmxygzzsqmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzsqmxdto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PCMXYGZZSQMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzsqmxes")
    @Transactional
    public ResponseEntity<PCMXYGZZSQMXDTO> create(@RequestBody PCMXYGZZSQMXDTO pcmxygzzsqmxdto) {
        PCMXYGZZSQMX domain = pcmxygzzsqmxMapping.toDomain(pcmxygzzsqmxdto);
		pcmxygzzsqmxService.create(domain);
        PCMXYGZZSQMXDTO dto = pcmxygzzsqmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PCMXYGZZSQMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzsqmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMXYGZZSQMXDTO> pcmxygzzsqmxdtos) {
        pcmxygzzsqmxService.createBatch(pcmxygzzsqmxMapping.toDomain(pcmxygzzsqmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"PCMXYGZZSQMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzsqmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMXYGZZSQMXDTO pcmxygzzsqmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzsqmxService.save(pcmxygzzsqmxMapping.toDomain(pcmxygzzsqmxdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PCMXYGZZSQMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzsqmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMXYGZZSQMXDTO> pcmxygzzsqmxdtos) {
        pcmxygzzsqmxService.saveBatch(pcmxygzzsqmxMapping.toDomain(pcmxygzzsqmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "审核通过", tags = {"PCMXYGZZSQMX" },  notes = "审核通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzsqmxes/{pcmxygzzsqmx_id}/shtg")
    @Transactional
    public ResponseEntity<PCMXYGZZSQMXDTO> sHTG(@PathVariable("pcmxygzzsqmx_id") String pcmxygzzsqmx_id, @RequestBody PCMXYGZZSQMXDTO pcmxygzzsqmxdto) {
        PCMXYGZZSQMX pcmxygzzsqmx = pcmxygzzsqmxMapping.toDomain(pcmxygzzsqmxdto);
        pcmxygzzsqmx = pcmxygzzsqmxService.sHTG(pcmxygzzsqmx);
        pcmxygzzsqmxdto = pcmxygzzsqmxMapping.toDto(pcmxygzzsqmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzsqmxdto);
    }




    @ApiOperation(value = "转正操作", tags = {"PCMXYGZZSQMX" },  notes = "转正操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzsqmxes/{pcmxygzzsqmx_id}/zzcz")
    @Transactional
    public ResponseEntity<PCMXYGZZSQMXDTO> zZCZ(@PathVariable("pcmxygzzsqmx_id") String pcmxygzzsqmx_id, @RequestBody PCMXYGZZSQMXDTO pcmxygzzsqmxdto) {
        PCMXYGZZSQMX pcmxygzzsqmx = pcmxygzzsqmxMapping.toDomain(pcmxygzzsqmxdto);
        pcmxygzzsqmx = pcmxygzzsqmxService.zZCZ(pcmxygzzsqmx);
        pcmxygzzsqmxdto = pcmxygzzsqmxMapping.toDto(pcmxygzzsqmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzsqmxdto);
    }




    @ApiOperation(value = "CheckKey", tags = {"PCMXYGZZSQMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzsqmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMXYGZZSQMXDTO pcmxygzzsqmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmxygzzsqmxService.checkKey(pcmxygzzsqmxMapping.toDomain(pcmxygzzsqmxdto)));
    }

    @PreAuthorize("hasPermission('Get',{#context,'WSHSQ',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch未完成审核的申请", tags = {"PCMXYGZZSQMX" } ,notes = "fetch未完成审核的申请")
    @RequestMapping(method= RequestMethod.GET , value="/pcmxygzzsqmxes/fetchwshsq")
	public ResponseEntity<List<PCMXYGZZSQMXDTO>> fetchWSHSQ(PCMXYGZZSQMXSearchContext context) {
        Page<PCMXYGZZSQMX> domains = pcmxygzzsqmxService.searchWSHSQ(context) ;
        List<PCMXYGZZSQMXDTO> list = pcmxygzzsqmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'WSHSQ',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search未完成审核的申请", tags = {"PCMXYGZZSQMX" } ,notes = "search未完成审核的申请")
    @RequestMapping(method= RequestMethod.GET , value="/pcmxygzzsqmxes/searchwshsq")
	public ResponseEntity<Page<PCMXYGZZSQMXDTO>> searchWSHSQ(PCMXYGZZSQMXSearchContext context) {
        Page<PCMXYGZZSQMX> domains = pcmxygzzsqmxService.searchWSHSQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmxygzzsqmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMXYGZZSQMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmxygzzsqmxes/fetchdefault")
	public ResponseEntity<List<PCMXYGZZSQMXDTO>> fetchDefault(PCMXYGZZSQMXSearchContext context) {
        Page<PCMXYGZZSQMX> domains = pcmxygzzsqmxService.searchDefault(context) ;
        List<PCMXYGZZSQMXDTO> list = pcmxygzzsqmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMXYGZZSQMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmxygzzsqmxes/searchdefault")
	public ResponseEntity<Page<PCMXYGZZSQMXDTO>> searchDefault(PCMXYGZZSQMXSearchContext context) {
        Page<PCMXYGZZSQMX> domains = pcmxygzzsqmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmxygzzsqmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PCMXYGZZSQMX getEntity(){
        return new PCMXYGZZSQMX();
    }

}