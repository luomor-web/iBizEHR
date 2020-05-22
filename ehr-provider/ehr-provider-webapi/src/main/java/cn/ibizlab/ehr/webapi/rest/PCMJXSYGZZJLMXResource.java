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
import cn.ibizlab.ehr.core.pcm.domain.PCMJXSYGZZJLMX;
import cn.ibizlab.ehr.core.pcm.service.IPCMJXSYGZZJLMXService;
import cn.ibizlab.ehr.core.pcm.filter.PCMJXSYGZZJLMXSearchContext;




@Slf4j
@Api(tags = {"PCMJXSYGZZJLMX" })
@RestController("WebApi-pcmjxsygzzjlmx")
@RequestMapping("")
public class PCMJXSYGZZJLMXResource {

    @Autowired
    private IPCMJXSYGZZJLMXService pcmjxsygzzjlmxService;

    @Autowired
    @Lazy
    public PCMJXSYGZZJLMXMapping pcmjxsygzzjlmxMapping;

    public PCMJXSYGZZJLMXDTO permissionDTO=new PCMJXSYGZZJLMXDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMJXSYGZZJLMX-SHBTG-all')")
    @ApiOperation(value = "审核不通过", tags = {"PCMJXSYGZZJLMX" },  notes = "审核不通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzjlmxes/{pcmjxsygzzjlmx_id}/shbtg")
    @Transactional
    public ResponseEntity<PCMJXSYGZZJLMXDTO> sHBTG(@PathVariable("pcmjxsygzzjlmx_id") String pcmjxsygzzjlmx_id, @RequestBody PCMJXSYGZZJLMXDTO pcmjxsygzzjlmxdto) {
        PCMJXSYGZZJLMX pcmjxsygzzjlmx = pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdto);
        pcmjxsygzzjlmx = pcmjxsygzzjlmxService.sHBTG(pcmjxsygzzjlmx);
        pcmjxsygzzjlmxdto = pcmjxsygzzjlmxMapping.toDto(pcmjxsygzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMJXSYGZZJLMX-SHTG-all')")
    @ApiOperation(value = "审核通过", tags = {"PCMJXSYGZZJLMX" },  notes = "审核通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzjlmxes/{pcmjxsygzzjlmx_id}/shtg")
    @Transactional
    public ResponseEntity<PCMJXSYGZZJLMXDTO> sHTG(@PathVariable("pcmjxsygzzjlmx_id") String pcmjxsygzzjlmx_id, @RequestBody PCMJXSYGZZJLMXDTO pcmjxsygzzjlmxdto) {
        PCMJXSYGZZJLMX pcmjxsygzzjlmx = pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdto);
        pcmjxsygzzjlmx = pcmjxsygzzjlmxService.sHTG(pcmjxsygzzjlmx);
        pcmjxsygzzjlmxdto = pcmjxsygzzjlmxMapping.toDto(pcmjxsygzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMJXSYGZZJLMX-Save-all')")
    @ApiOperation(value = "Save", tags = {"PCMJXSYGZZJLMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzjlmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMJXSYGZZJLMXDTO pcmjxsygzzjlmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzjlmxService.save(pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PCMJXSYGZZJLMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzjlmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMJXSYGZZJLMXDTO> pcmjxsygzzjlmxdtos) {
        pcmjxsygzzjlmxService.saveBatch(pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMJXSYGZZJLMX-FillPersonInfo-all')")
    @ApiOperation(value = "", tags = {"PCMJXSYGZZJLMX" },  notes = "")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzjlmxes/{pcmjxsygzzjlmx_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PCMJXSYGZZJLMXDTO> fillPersonInfo(@PathVariable("pcmjxsygzzjlmx_id") String pcmjxsygzzjlmx_id, @RequestBody PCMJXSYGZZJLMXDTO pcmjxsygzzjlmxdto) {
        PCMJXSYGZZJLMX pcmjxsygzzjlmx = pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdto);
        pcmjxsygzzjlmx = pcmjxsygzzjlmxService.fillPersonInfo(pcmjxsygzzjlmx);
        pcmjxsygzzjlmxdto = pcmjxsygzzjlmxMapping.toDto(pcmjxsygzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMJXSYGZZJLMX-ZZCZ-all')")
    @ApiOperation(value = "转正操作", tags = {"PCMJXSYGZZJLMX" },  notes = "转正操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzjlmxes/{pcmjxsygzzjlmx_id}/zzcz")
    @Transactional
    public ResponseEntity<PCMJXSYGZZJLMXDTO> zZCZ(@PathVariable("pcmjxsygzzjlmx_id") String pcmjxsygzzjlmx_id, @RequestBody PCMJXSYGZZJLMXDTO pcmjxsygzzjlmxdto) {
        PCMJXSYGZZJLMX pcmjxsygzzjlmx = pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdto);
        pcmjxsygzzjlmx = pcmjxsygzzjlmxService.zZCZ(pcmjxsygzzjlmx);
        pcmjxsygzzjlmxdto = pcmjxsygzzjlmxMapping.toDto(pcmjxsygzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMJXSYGZZJLMX-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PCMJXSYGZZJLMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmjxsygzzjlmxes/getdraft")
    public ResponseEntity<PCMJXSYGZZJLMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzjlmxMapping.toDto(pcmjxsygzzjlmxService.getDraft(new PCMJXSYGZZJLMX())));
    }

    @PreAuthorize("hasPermission(#pcmjxsygzzjlmx_id,'Get',{'Sql',this.pcmjxsygzzjlmxMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PCMJXSYGZZJLMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmjxsygzzjlmxes/{pcmjxsygzzjlmx_id}")
    public ResponseEntity<PCMJXSYGZZJLMXDTO> get(@PathVariable("pcmjxsygzzjlmx_id") String pcmjxsygzzjlmx_id) {
        PCMJXSYGZZJLMX domain = pcmjxsygzzjlmxService.get(pcmjxsygzzjlmx_id);
        PCMJXSYGZZJLMXDTO dto = pcmjxsygzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pcmjxsygzzjlmx_id,'Remove',{'Sql',this.pcmjxsygzzjlmxMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PCMJXSYGZZJLMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmjxsygzzjlmxes/{pcmjxsygzzjlmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmjxsygzzjlmx_id") String pcmjxsygzzjlmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzjlmxService.remove(pcmjxsygzzjlmx_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PCMJXSYGZZJLMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmjxsygzzjlmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmjxsygzzjlmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pcmjxsygzzjlmxMapping,#pcmjxsygzzjlmxdto})")
    @ApiOperation(value = "Create", tags = {"PCMJXSYGZZJLMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzjlmxes")
    @Transactional
    public ResponseEntity<PCMJXSYGZZJLMXDTO> create(@RequestBody PCMJXSYGZZJLMXDTO pcmjxsygzzjlmxdto) {
        PCMJXSYGZZJLMX domain = pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdto);
		pcmjxsygzzjlmxService.create(domain);
        PCMJXSYGZZJLMXDTO dto = pcmjxsygzzjlmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"PCMJXSYGZZJLMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzjlmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMJXSYGZZJLMXDTO> pcmjxsygzzjlmxdtos) {
        pcmjxsygzzjlmxService.createBatch(pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pcmjxsygzzjlmx_id,'Update',{'Sql',this.pcmjxsygzzjlmxMapping,#pcmjxsygzzjlmxdto})")
    @ApiOperation(value = "Update", tags = {"PCMJXSYGZZJLMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmjxsygzzjlmxes/{pcmjxsygzzjlmx_id}")
    @Transactional
    public ResponseEntity<PCMJXSYGZZJLMXDTO> update(@PathVariable("pcmjxsygzzjlmx_id") String pcmjxsygzzjlmx_id, @RequestBody PCMJXSYGZZJLMXDTO pcmjxsygzzjlmxdto) {
		PCMJXSYGZZJLMX domain = pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdto);
        domain.setPcmjxsygzzjlmxid(pcmjxsygzzjlmx_id);
		pcmjxsygzzjlmxService.update(domain);
		PCMJXSYGZZJLMXDTO dto = pcmjxsygzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMJXSYGZZJLMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmjxsygzzjlmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMJXSYGZZJLMXDTO> pcmjxsygzzjlmxdtos) {
        pcmjxsygzzjlmxService.updateBatch(pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMJXSYGZZJLMX-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PCMJXSYGZZJLMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzjlmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMJXSYGZZJLMXDTO pcmjxsygzzjlmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzjlmxService.checkKey(pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMJXSYGZZJLMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMJXSYGZZJLMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmjxsygzzjlmxes/fetchdefault")
	public ResponseEntity<List<PCMJXSYGZZJLMXDTO>> fetchDefault(PCMJXSYGZZJLMXSearchContext context) {
        Page<PCMJXSYGZZJLMX> domains = pcmjxsygzzjlmxService.searchDefault(context) ;
        List<PCMJXSYGZZJLMXDTO> list = pcmjxsygzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMJXSYGZZJLMX-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMJXSYGZZJLMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmjxsygzzjlmxes/searchdefault")
	public ResponseEntity<Page<PCMJXSYGZZJLMXDTO>> searchDefault(@RequestBody PCMJXSYGZZJLMXSearchContext context) {
        Page<PCMJXSYGZZJLMX> domains = pcmjxsygzzjlmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmjxsygzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMJXSYGZZJLMX-WSHSQ-all')")
	@ApiOperation(value = "fetch未审核完成的申请", tags = {"PCMJXSYGZZJLMX" } ,notes = "fetch未审核完成的申请")
    @RequestMapping(method= RequestMethod.GET , value="/pcmjxsygzzjlmxes/fetchwshsq")
	public ResponseEntity<List<PCMJXSYGZZJLMXDTO>> fetchWSHSQ(PCMJXSYGZZJLMXSearchContext context) {
        Page<PCMJXSYGZZJLMX> domains = pcmjxsygzzjlmxService.searchWSHSQ(context) ;
        List<PCMJXSYGZZJLMXDTO> list = pcmjxsygzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMJXSYGZZJLMX-WSHSQ-all')")
	@ApiOperation(value = "search未审核完成的申请", tags = {"PCMJXSYGZZJLMX" } ,notes = "search未审核完成的申请")
    @RequestMapping(method= RequestMethod.POST , value="/pcmjxsygzzjlmxes/searchwshsq")
	public ResponseEntity<Page<PCMJXSYGZZJLMXDTO>> searchWSHSQ(@RequestBody PCMJXSYGZZJLMXSearchContext context) {
        Page<PCMJXSYGZZJLMX> domains = pcmjxsygzzjlmxService.searchWSHSQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmjxsygzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMJXSYGZZJLMX-JXSZZJL-all')")
	@ApiOperation(value = "fetch见习生转正记录", tags = {"PCMJXSYGZZJLMX" } ,notes = "fetch见习生转正记录")
    @RequestMapping(method= RequestMethod.GET , value="/pcmjxsygzzjlmxes/fetchjxszzjl")
	public ResponseEntity<List<PCMJXSYGZZJLMXDTO>> fetchJXSZZJL(PCMJXSYGZZJLMXSearchContext context) {
        Page<PCMJXSYGZZJLMX> domains = pcmjxsygzzjlmxService.searchJXSZZJL(context) ;
        List<PCMJXSYGZZJLMXDTO> list = pcmjxsygzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMJXSYGZZJLMX-JXSZZJL-all')")
	@ApiOperation(value = "search见习生转正记录", tags = {"PCMJXSYGZZJLMX" } ,notes = "search见习生转正记录")
    @RequestMapping(method= RequestMethod.POST , value="/pcmjxsygzzjlmxes/searchjxszzjl")
	public ResponseEntity<Page<PCMJXSYGZZJLMXDTO>> searchJXSZZJL(@RequestBody PCMJXSYGZZJLMXSearchContext context) {
        Page<PCMJXSYGZZJLMX> domains = pcmjxsygzzjlmxService.searchJXSZZJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmjxsygzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMJXSYGZZJLMX-ALLDS-all')")
	@ApiOperation(value = "fetch所有的申请明细", tags = {"PCMJXSYGZZJLMX" } ,notes = "fetch所有的申请明细")
    @RequestMapping(method= RequestMethod.GET , value="/pcmjxsygzzjlmxes/fetchallds")
	public ResponseEntity<List<PCMJXSYGZZJLMXDTO>> fetchALLDS(PCMJXSYGZZJLMXSearchContext context) {
        Page<PCMJXSYGZZJLMX> domains = pcmjxsygzzjlmxService.searchALLDS(context) ;
        List<PCMJXSYGZZJLMXDTO> list = pcmjxsygzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMJXSYGZZJLMX-ALLDS-all')")
	@ApiOperation(value = "search所有的申请明细", tags = {"PCMJXSYGZZJLMX" } ,notes = "search所有的申请明细")
    @RequestMapping(method= RequestMethod.POST , value="/pcmjxsygzzjlmxes/searchallds")
	public ResponseEntity<Page<PCMJXSYGZZJLMXDTO>> searchALLDS(@RequestBody PCMJXSYGZZJLMXSearchContext context) {
        Page<PCMJXSYGZZJLMX> domains = pcmjxsygzzjlmxService.searchALLDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmjxsygzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
