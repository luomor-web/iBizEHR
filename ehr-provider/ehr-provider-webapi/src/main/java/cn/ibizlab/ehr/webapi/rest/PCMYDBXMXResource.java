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
import cn.ibizlab.ehr.core.pcm.domain.PCMYDBXMX;
import cn.ibizlab.ehr.core.pcm.service.IPCMYDBXMXService;
import cn.ibizlab.ehr.core.pcm.filter.PCMYDBXMXSearchContext;




@Slf4j
@Api(tags = {"PCMYDBXMX" })
@RestController("WebApi-pcmydbxmx")
@RequestMapping("")
public class PCMYDBXMXResource {

    @Autowired
    private IPCMYDBXMXService pcmydbxmxService;

    @Autowired
    @Lazy
    public PCMYDBXMXMapping pcmydbxmxMapping;

    public PCMYDBXMXDTO permissionDTO=new PCMYDBXMXDTO();




    @PreAuthorize("hasPermission(#pcmydbxmx_id,'Get',{'Sql',this.pcmydbxmxMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PCMYDBXMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydbxmxes/{pcmydbxmx_id}")
    public ResponseEntity<PCMYDBXMXDTO> get(@PathVariable("pcmydbxmx_id") String pcmydbxmx_id) {
        PCMYDBXMX domain = pcmydbxmxService.get(pcmydbxmx_id);
        PCMYDBXMXDTO dto = pcmydbxmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDBXMX-FillPersonInfo-all')")
    @ApiOperation(value = "填充人员信息", tags = {"PCMYDBXMX" },  notes = "填充人员信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydbxmxes/{pcmydbxmx_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PCMYDBXMXDTO> fillPersonInfo(@PathVariable("pcmydbxmx_id") String pcmydbxmx_id, @RequestBody PCMYDBXMXDTO pcmydbxmxdto) {
        PCMYDBXMX pcmydbxmx = pcmydbxmxMapping.toDomain(pcmydbxmxdto);
        pcmydbxmx = pcmydbxmxService.fillPersonInfo(pcmydbxmx);
        pcmydbxmxdto = pcmydbxmxMapping.toDto(pcmydbxmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydbxmxdto);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDBXMX-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PCMYDBXMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydbxmxes/getdraft")
    public ResponseEntity<PCMYDBXMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydbxmxMapping.toDto(pcmydbxmxService.getDraft(new PCMYDBXMX())));
    }




    @PreAuthorize("hasPermission(#pcmydbxmx_id,'Update',{'Sql',this.pcmydbxmxMapping,#pcmydbxmxdto})")
    @ApiOperation(value = "Update", tags = {"PCMYDBXMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydbxmxes/{pcmydbxmx_id}")
    @Transactional
    public ResponseEntity<PCMYDBXMXDTO> update(@PathVariable("pcmydbxmx_id") String pcmydbxmx_id, @RequestBody PCMYDBXMXDTO pcmydbxmxdto) {
		PCMYDBXMX domain = pcmydbxmxMapping.toDomain(pcmydbxmxdto);
        domain.setPcmydbxmxid(pcmydbxmx_id);
		pcmydbxmxService.update(domain);
		PCMYDBXMXDTO dto = pcmydbxmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"PCMYDBXMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydbxmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMYDBXMXDTO> pcmydbxmxdtos) {
        pcmydbxmxService.updateBatch(pcmydbxmxMapping.toDomain(pcmydbxmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDBXMX-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PCMYDBXMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydbxmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMYDBXMXDTO pcmydbxmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmydbxmxService.checkKey(pcmydbxmxMapping.toDomain(pcmydbxmxdto)));
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDBXMX-Save-all')")
    @ApiOperation(value = "Save", tags = {"PCMYDBXMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydbxmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMYDBXMXDTO pcmydbxmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydbxmxService.save(pcmydbxmxMapping.toDomain(pcmydbxmxdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PCMYDBXMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydbxmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMYDBXMXDTO> pcmydbxmxdtos) {
        pcmydbxmxService.saveBatch(pcmydbxmxMapping.toDomain(pcmydbxmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDBXMX-FinishBX-all')")
    @ApiOperation(value = "结束病休", tags = {"PCMYDBXMX" },  notes = "结束病休")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydbxmxes/{pcmydbxmx_id}/finishbx")
    @Transactional
    public ResponseEntity<PCMYDBXMXDTO> finishBX(@PathVariable("pcmydbxmx_id") String pcmydbxmx_id, @RequestBody PCMYDBXMXDTO pcmydbxmxdto) {
        PCMYDBXMX pcmydbxmx = pcmydbxmxMapping.toDomain(pcmydbxmxdto);
        pcmydbxmx = pcmydbxmxService.finishBX(pcmydbxmx);
        pcmydbxmxdto = pcmydbxmxMapping.toDto(pcmydbxmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydbxmxdto);
    }




    @PreAuthorize("hasPermission(#pcmydbxmx_id,'Remove',{'Sql',this.pcmydbxmxMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PCMYDBXMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydbxmxes/{pcmydbxmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmydbxmx_id") String pcmydbxmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmydbxmxService.remove(pcmydbxmx_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PCMYDBXMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydbxmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmydbxmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.pcmydbxmxMapping,#pcmydbxmxdto})")
    @ApiOperation(value = "Create", tags = {"PCMYDBXMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydbxmxes")
    @Transactional
    public ResponseEntity<PCMYDBXMXDTO> create(@RequestBody PCMYDBXMXDTO pcmydbxmxdto) {
        PCMYDBXMX domain = pcmydbxmxMapping.toDomain(pcmydbxmxdto);
		pcmydbxmxService.create(domain);
        PCMYDBXMXDTO dto = pcmydbxmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"PCMYDBXMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydbxmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMYDBXMXDTO> pcmydbxmxdtos) {
        pcmydbxmxService.createBatch(pcmydbxmxMapping.toDomain(pcmydbxmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDBXMX-GLDS-all')")
	@ApiOperation(value = "fetch管理查询", tags = {"PCMYDBXMX" } ,notes = "fetch管理查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydbxmxes/fetchglds")
	public ResponseEntity<List<PCMYDBXMXDTO>> fetchGLDS(PCMYDBXMXSearchContext context) {
        Page<PCMYDBXMX> domains = pcmydbxmxService.searchGLDS(context) ;
        List<PCMYDBXMXDTO> list = pcmydbxmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDBXMX-GLDS-all')")
	@ApiOperation(value = "search管理查询", tags = {"PCMYDBXMX" } ,notes = "search管理查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydbxmxes/searchglds")
	public ResponseEntity<Page<PCMYDBXMXDTO>> searchGLDS(@RequestBody PCMYDBXMXSearchContext context) {
        Page<PCMYDBXMX> domains = pcmydbxmxService.searchGLDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydbxmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDBXMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMYDBXMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydbxmxes/fetchdefault")
	public ResponseEntity<List<PCMYDBXMXDTO>> fetchDefault(PCMYDBXMXSearchContext context) {
        Page<PCMYDBXMX> domains = pcmydbxmxService.searchDefault(context) ;
        List<PCMYDBXMXDTO> list = pcmydbxmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDBXMX-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMYDBXMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydbxmxes/searchdefault")
	public ResponseEntity<Page<PCMYDBXMXDTO>> searchDefault(@RequestBody PCMYDBXMXSearchContext context) {
        Page<PCMYDBXMX> domains = pcmydbxmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydbxmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDBXMX-JLDS-all')")
	@ApiOperation(value = "fetch记录查询", tags = {"PCMYDBXMX" } ,notes = "fetch记录查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydbxmxes/fetchjlds")
	public ResponseEntity<List<PCMYDBXMXDTO>> fetchJLDS(PCMYDBXMXSearchContext context) {
        Page<PCMYDBXMX> domains = pcmydbxmxService.searchJLDS(context) ;
        List<PCMYDBXMXDTO> list = pcmydbxmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDBXMX-JLDS-all')")
	@ApiOperation(value = "search记录查询", tags = {"PCMYDBXMX" } ,notes = "search记录查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydbxmxes/searchjlds")
	public ResponseEntity<Page<PCMYDBXMXDTO>> searchJLDS(@RequestBody PCMYDBXMXSearchContext context) {
        Page<PCMYDBXMX> domains = pcmydbxmxService.searchJLDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydbxmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


