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
import cn.ibizlab.ehr.core.pcm.domain.PCMYDJPMX;
import cn.ibizlab.ehr.core.pcm.service.IPCMYDJPMXService;
import cn.ibizlab.ehr.core.pcm.filter.PCMYDJPMXSearchContext;




@Slf4j
@Api(tags = {"PCMYDJPMX" })
@RestController("WebApi-pcmydjpmx")
@RequestMapping("")
public class PCMYDJPMXResource {

    @Autowired
    private IPCMYDJPMXService pcmydjpmxService;

    @Autowired
    @Lazy
    private PCMYDJPMXMapping pcmydjpmxMapping;




    @ApiOperation(value = "填充人员信息", tags = {"PCMYDJPMX" },  notes = "填充人员信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjpmxes/{pcmydjpmx_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PCMYDJPMXDTO> fillPersonInfo(@PathVariable("pcmydjpmx_id") String pcmydjpmx_id, @RequestBody PCMYDJPMXDTO pcmydjpmxdto) {
        PCMYDJPMX pcmydjpmx = pcmydjpmxMapping.toDomain(pcmydjpmxdto);
        pcmydjpmx = pcmydjpmxService.fillPersonInfo(pcmydjpmx);
        pcmydjpmxdto = pcmydjpmxMapping.toDto(pcmydjpmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjpmxdto);
    }




    @PreAuthorize("hasPermission(#pcmydjpmx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PCMYDJPMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydjpmxes/{pcmydjpmx_id}")
    @Transactional
    public ResponseEntity<PCMYDJPMXDTO> update(@PathVariable("pcmydjpmx_id") String pcmydjpmx_id, @RequestBody PCMYDJPMXDTO pcmydjpmxdto) {
		PCMYDJPMX domain = pcmydjpmxMapping.toDomain(pcmydjpmxdto);
        domain.setPcmydjpmxid(pcmydjpmx_id);
		pcmydjpmxService.update(domain);
		PCMYDJPMXDTO dto = pcmydjpmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pcmydjpmx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMYDJPMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydjpmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMYDJPMXDTO> pcmydjpmxdtos) {
        pcmydjpmxService.updateBatch(pcmydjpmxMapping.toDomain(pcmydjpmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PCMYDJPMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydjpmxes/getdraft")
    public ResponseEntity<PCMYDJPMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjpmxMapping.toDto(pcmydjpmxService.getDraft(new PCMYDJPMX())));
    }




    @ApiOperation(value = "CheckKey", tags = {"PCMYDJPMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjpmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMYDJPMXDTO pcmydjpmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmydjpmxService.checkKey(pcmydjpmxMapping.toDomain(pcmydjpmxdto)));
    }




    @ApiOperation(value = "Save", tags = {"PCMYDJPMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjpmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMYDJPMXDTO pcmydjpmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjpmxService.save(pcmydjpmxMapping.toDomain(pcmydjpmxdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PCMYDJPMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjpmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMYDJPMXDTO> pcmydjpmxdtos) {
        pcmydjpmxService.saveBatch(pcmydjpmxMapping.toDomain(pcmydjpmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pcmydjpmx_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PCMYDJPMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydjpmxes/{pcmydjpmx_id}")
    public ResponseEntity<PCMYDJPMXDTO> get(@PathVariable("pcmydjpmx_id") String pcmydjpmx_id) {
        PCMYDJPMX domain = pcmydjpmxService.get(pcmydjpmx_id);
        PCMYDJPMXDTO dto = pcmydjpmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "解聘完成", tags = {"PCMYDJPMX" },  notes = "解聘完成")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjpmxes/{pcmydjpmx_id}/jpwc")
    @Transactional
    public ResponseEntity<PCMYDJPMXDTO> jPWC(@PathVariable("pcmydjpmx_id") String pcmydjpmx_id, @RequestBody PCMYDJPMXDTO pcmydjpmxdto) {
        PCMYDJPMX pcmydjpmx = pcmydjpmxMapping.toDomain(pcmydjpmxdto);
        pcmydjpmx = pcmydjpmxService.jPWC(pcmydjpmx);
        pcmydjpmxdto = pcmydjpmxMapping.toDto(pcmydjpmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjpmxdto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PCMYDJPMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjpmxes")
    @Transactional
    public ResponseEntity<PCMYDJPMXDTO> create(@RequestBody PCMYDJPMXDTO pcmydjpmxdto) {
        PCMYDJPMX domain = pcmydjpmxMapping.toDomain(pcmydjpmxdto);
		pcmydjpmxService.create(domain);
        PCMYDJPMXDTO dto = pcmydjpmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PCMYDJPMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjpmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMYDJPMXDTO> pcmydjpmxdtos) {
        pcmydjpmxService.createBatch(pcmydjpmxMapping.toDomain(pcmydjpmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#pcmydjpmx_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PCMYDJPMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydjpmxes/{pcmydjpmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmydjpmx_id") String pcmydjpmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmydjpmxService.remove(pcmydjpmx_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PCMYDJPMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydjpmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmydjpmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('Get',{#context,'JLDS',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch记录查询", tags = {"PCMYDJPMX" } ,notes = "fetch记录查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydjpmxes/fetchjlds")
	public ResponseEntity<List<PCMYDJPMXDTO>> fetchJLDS(PCMYDJPMXSearchContext context) {
        Page<PCMYDJPMX> domains = pcmydjpmxService.searchJLDS(context) ;
        List<PCMYDJPMXDTO> list = pcmydjpmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'JLDS',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search记录查询", tags = {"PCMYDJPMX" } ,notes = "search记录查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydjpmxes/searchjlds")
	public ResponseEntity<Page<PCMYDJPMXDTO>> searchJLDS(PCMYDJPMXSearchContext context) {
        Page<PCMYDJPMX> domains = pcmydjpmxService.searchJLDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjpmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMYDJPMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydjpmxes/fetchdefault")
	public ResponseEntity<List<PCMYDJPMXDTO>> fetchDefault(PCMYDJPMXSearchContext context) {
        Page<PCMYDJPMX> domains = pcmydjpmxService.searchDefault(context) ;
        List<PCMYDJPMXDTO> list = pcmydjpmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMYDJPMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydjpmxes/searchdefault")
	public ResponseEntity<Page<PCMYDJPMXDTO>> searchDefault(PCMYDJPMXSearchContext context) {
        Page<PCMYDJPMX> domains = pcmydjpmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjpmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'GLDS',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch管理查询", tags = {"PCMYDJPMX" } ,notes = "fetch管理查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydjpmxes/fetchglds")
	public ResponseEntity<List<PCMYDJPMXDTO>> fetchGLDS(PCMYDJPMXSearchContext context) {
        Page<PCMYDJPMX> domains = pcmydjpmxService.searchGLDS(context) ;
        List<PCMYDJPMXDTO> list = pcmydjpmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'GLDS',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search管理查询", tags = {"PCMYDJPMX" } ,notes = "search管理查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydjpmxes/searchglds")
	public ResponseEntity<Page<PCMYDJPMXDTO>> searchGLDS(PCMYDJPMXSearchContext context) {
        Page<PCMYDJPMX> domains = pcmydjpmxService.searchGLDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjpmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PCMYDJPMX getEntity(){
        return new PCMYDJPMX();
    }

}