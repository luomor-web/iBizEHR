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
import cn.ibizlab.ehr.core.pcm.domain.PCMYDNTMX;
import cn.ibizlab.ehr.core.pcm.service.IPCMYDNTMXService;
import cn.ibizlab.ehr.core.pcm.filter.PCMYDNTMXSearchContext;

@Slf4j
@Api(tags = {"PCMYDNTMX" })
@RestController("WebApi-pcmydntmx")
@RequestMapping("")
public class PCMYDNTMXResource {

    @Autowired
    private IPCMYDNTMXService pcmydntmxService;

    @Autowired
    @Lazy
    public PCMYDNTMXMapping pcmydntmxMapping;

    public PCMYDNTMXDTO permissionDTO=new PCMYDNTMXDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDNTMX-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PCMYDNTMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydntmxes/getdraft")
    public ResponseEntity<PCMYDNTMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydntmxMapping.toDto(pcmydntmxService.getDraft(new PCMYDNTMX())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDNTMX-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PCMYDNTMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydntmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMYDNTMXDTO pcmydntmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmydntmxService.checkKey(pcmydntmxMapping.toDomain(pcmydntmxdto)));
    }

    @PreAuthorize("hasPermission(#pcmydntmx_id,'Get',{'Sql',this.pcmydntmxMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PCMYDNTMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydntmxes/{pcmydntmx_id}")
    public ResponseEntity<PCMYDNTMXDTO> get(@PathVariable("pcmydntmx_id") String pcmydntmx_id) {
        PCMYDNTMX domain = pcmydntmxService.get(pcmydntmx_id);
        PCMYDNTMXDTO dto = pcmydntmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pcmydntmxMapping,#pcmydntmxdto})")
    @ApiOperation(value = "Create", tags = {"PCMYDNTMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydntmxes")
    @Transactional
    public ResponseEntity<PCMYDNTMXDTO> create(@RequestBody PCMYDNTMXDTO pcmydntmxdto) {
        PCMYDNTMX domain = pcmydntmxMapping.toDomain(pcmydntmxdto);
		pcmydntmxService.create(domain);
        PCMYDNTMXDTO dto = pcmydntmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"PCMYDNTMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydntmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMYDNTMXDTO> pcmydntmxdtos) {
        pcmydntmxService.createBatch(pcmydntmxMapping.toDomain(pcmydntmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.pcmydntmxMapping,#pcmydntmxdto})")
    @ApiOperation(value = "Save", tags = {"PCMYDNTMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydntmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMYDNTMXDTO pcmydntmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydntmxService.save(pcmydntmxMapping.toDomain(pcmydntmxdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PCMYDNTMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydntmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMYDNTMXDTO> pcmydntmxdtos) {
        pcmydntmxService.saveBatch(pcmydntmxMapping.toDomain(pcmydntmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pcmydntmx_id,'Remove',{'Sql',this.pcmydntmxMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PCMYDNTMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydntmxes/{pcmydntmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmydntmx_id") String pcmydntmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmydntmxService.remove(pcmydntmx_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PCMYDNTMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydntmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmydntmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDNTMX-FillPersonInfo-all')")
    @ApiOperation(value = "填充人员信息", tags = {"PCMYDNTMX" },  notes = "填充人员信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydntmxes/{pcmydntmx_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PCMYDNTMXDTO> fillPersonInfo(@PathVariable("pcmydntmx_id") String pcmydntmx_id, @RequestBody PCMYDNTMXDTO pcmydntmxdto) {
        PCMYDNTMX pcmydntmx = pcmydntmxMapping.toDomain(pcmydntmxdto);
        pcmydntmx = pcmydntmxService.fillPersonInfo(pcmydntmx);
        pcmydntmxdto = pcmydntmxMapping.toDto(pcmydntmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydntmxdto);
    }

    @PreAuthorize("hasPermission(#pcmydntmx_id,'Update',{'Sql',this.pcmydntmxMapping,#pcmydntmxdto})")
    @ApiOperation(value = "Update", tags = {"PCMYDNTMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydntmxes/{pcmydntmx_id}")
    @Transactional
    public ResponseEntity<PCMYDNTMXDTO> update(@PathVariable("pcmydntmx_id") String pcmydntmx_id, @RequestBody PCMYDNTMXDTO pcmydntmxdto) {
		PCMYDNTMX domain = pcmydntmxMapping.toDomain(pcmydntmxdto);
        domain.setPcmydntmxid(pcmydntmx_id);
		pcmydntmxService.update(domain);
		PCMYDNTMXDTO dto = pcmydntmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMYDNTMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydntmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMYDNTMXDTO> pcmydntmxdtos) {
        pcmydntmxService.updateBatch(pcmydntmxMapping.toDomain(pcmydntmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDNTMX-FinishNT-all')")
    @ApiOperation(value = "结束内退", tags = {"PCMYDNTMX" },  notes = "结束内退")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydntmxes/{pcmydntmx_id}/finishnt")
    @Transactional
    public ResponseEntity<PCMYDNTMXDTO> finishNT(@PathVariable("pcmydntmx_id") String pcmydntmx_id, @RequestBody PCMYDNTMXDTO pcmydntmxdto) {
        PCMYDNTMX pcmydntmx = pcmydntmxMapping.toDomain(pcmydntmxdto);
        pcmydntmx = pcmydntmxService.finishNT(pcmydntmx);
        pcmydntmxdto = pcmydntmxMapping.toDto(pcmydntmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydntmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDNTMX-JLDS-all')")
	@ApiOperation(value = "fetch记录查询", tags = {"PCMYDNTMX" } ,notes = "fetch记录查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydntmxes/fetchjlds")
	public ResponseEntity<List<PCMYDNTMXDTO>> fetchJLDS(PCMYDNTMXSearchContext context) {
        Page<PCMYDNTMX> domains = pcmydntmxService.searchJLDS(context) ;
        List<PCMYDNTMXDTO> list = pcmydntmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDNTMX-JLDS-all')")
	@ApiOperation(value = "search记录查询", tags = {"PCMYDNTMX" } ,notes = "search记录查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydntmxes/searchjlds")
	public ResponseEntity<Page<PCMYDNTMXDTO>> searchJLDS(@RequestBody PCMYDNTMXSearchContext context) {
        Page<PCMYDNTMX> domains = pcmydntmxService.searchJLDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydntmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDNTMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMYDNTMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydntmxes/fetchdefault")
	public ResponseEntity<List<PCMYDNTMXDTO>> fetchDefault(PCMYDNTMXSearchContext context) {
        Page<PCMYDNTMX> domains = pcmydntmxService.searchDefault(context) ;
        List<PCMYDNTMXDTO> list = pcmydntmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDNTMX-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMYDNTMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydntmxes/searchdefault")
	public ResponseEntity<Page<PCMYDNTMXDTO>> searchDefault(@RequestBody PCMYDNTMXSearchContext context) {
        Page<PCMYDNTMX> domains = pcmydntmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydntmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDNTMX-GLDS-all')")
	@ApiOperation(value = "fetch管理查询", tags = {"PCMYDNTMX" } ,notes = "fetch管理查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydntmxes/fetchglds")
	public ResponseEntity<List<PCMYDNTMXDTO>> fetchGLDS(PCMYDNTMXSearchContext context) {
        Page<PCMYDNTMX> domains = pcmydntmxService.searchGLDS(context) ;
        List<PCMYDNTMXDTO> list = pcmydntmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDNTMX-GLDS-all')")
	@ApiOperation(value = "search管理查询", tags = {"PCMYDNTMX" } ,notes = "search管理查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydntmxes/searchglds")
	public ResponseEntity<Page<PCMYDNTMXDTO>> searchGLDS(@RequestBody PCMYDNTMXSearchContext context) {
        Page<PCMYDNTMX> domains = pcmydntmxService.searchGLDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydntmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
