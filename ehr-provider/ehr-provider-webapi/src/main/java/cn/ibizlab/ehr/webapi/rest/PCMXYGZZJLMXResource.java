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
import cn.ibizlab.ehr.core.pcm.domain.PCMXYGZZJLMX;
import cn.ibizlab.ehr.core.pcm.service.IPCMXYGZZJLMXService;
import cn.ibizlab.ehr.core.pcm.filter.PCMXYGZZJLMXSearchContext;




@Slf4j
@Api(tags = {"PCMXYGZZJLMX" })
@RestController("WebApi-pcmxygzzjlmx")
@RequestMapping("")
public class PCMXYGZZJLMXResource {

    @Autowired
    private IPCMXYGZZJLMXService pcmxygzzjlmxService;

    @Autowired
    @Lazy
    private PCMXYGZZJLMXMapping pcmxygzzjlmxMapping;




    @ApiOperation(value = "新员工转正操作", tags = {"PCMXYGZZJLMX" },  notes = "新员工转正操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzjlmxes/{pcmxygzzjlmx_id}/xygzzcz")
    @Transactional
    public ResponseEntity<PCMXYGZZJLMXDTO> xYGZZCZ(@PathVariable("pcmxygzzjlmx_id") String pcmxygzzjlmx_id, @RequestBody PCMXYGZZJLMXDTO pcmxygzzjlmxdto) {
        PCMXYGZZJLMX pcmxygzzjlmx = pcmxygzzjlmxMapping.toDomain(pcmxygzzjlmxdto);
        pcmxygzzjlmx = pcmxygzzjlmxService.xYGZZCZ(pcmxygzzjlmx);
        pcmxygzzjlmxdto = pcmxygzzjlmxMapping.toDto(pcmxygzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzjlmxdto);
    }




    @PreAuthorize("hasPermission(#pcmxygzzjlmx_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PCMXYGZZJLMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmxygzzjlmxes/{pcmxygzzjlmx_id}")
    public ResponseEntity<PCMXYGZZJLMXDTO> get(@PathVariable("pcmxygzzjlmx_id") String pcmxygzzjlmx_id) {
        PCMXYGZZJLMX domain = pcmxygzzjlmxService.get(pcmxygzzjlmx_id);
        PCMXYGZZJLMXDTO dto = pcmxygzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "审核通过", tags = {"PCMXYGZZJLMX" },  notes = "审核通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzjlmxes/{pcmxygzzjlmx_id}/shtg")
    @Transactional
    public ResponseEntity<PCMXYGZZJLMXDTO> sHTG(@PathVariable("pcmxygzzjlmx_id") String pcmxygzzjlmx_id, @RequestBody PCMXYGZZJLMXDTO pcmxygzzjlmxdto) {
        PCMXYGZZJLMX pcmxygzzjlmx = pcmxygzzjlmxMapping.toDomain(pcmxygzzjlmxdto);
        pcmxygzzjlmx = pcmxygzzjlmxService.sHTG(pcmxygzzjlmx);
        pcmxygzzjlmxdto = pcmxygzzjlmxMapping.toDto(pcmxygzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzjlmxdto);
    }




    @ApiOperation(value = "设置人员信息", tags = {"PCMXYGZZJLMX" },  notes = "设置人员信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzjlmxes/{pcmxygzzjlmx_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PCMXYGZZJLMXDTO> fillPersonInfo(@PathVariable("pcmxygzzjlmx_id") String pcmxygzzjlmx_id, @RequestBody PCMXYGZZJLMXDTO pcmxygzzjlmxdto) {
        PCMXYGZZJLMX pcmxygzzjlmx = pcmxygzzjlmxMapping.toDomain(pcmxygzzjlmxdto);
        pcmxygzzjlmx = pcmxygzzjlmxService.fillPersonInfo(pcmxygzzjlmx);
        pcmxygzzjlmxdto = pcmxygzzjlmxMapping.toDto(pcmxygzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzjlmxdto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PCMXYGZZJLMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzjlmxes")
    @Transactional
    public ResponseEntity<PCMXYGZZJLMXDTO> create(@RequestBody PCMXYGZZJLMXDTO pcmxygzzjlmxdto) {
        PCMXYGZZJLMX domain = pcmxygzzjlmxMapping.toDomain(pcmxygzzjlmxdto);
		pcmxygzzjlmxService.create(domain);
        PCMXYGZZJLMXDTO dto = pcmxygzzjlmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PCMXYGZZJLMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzjlmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMXYGZZJLMXDTO> pcmxygzzjlmxdtos) {
        pcmxygzzjlmxService.createBatch(pcmxygzzjlmxMapping.toDomain(pcmxygzzjlmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pcmxygzzjlmx_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"PCMXYGZZJLMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmxygzzjlmxes/{pcmxygzzjlmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmxygzzjlmx_id") String pcmxygzzjlmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzjlmxService.remove(pcmxygzzjlmx_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PCMXYGZZJLMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmxygzzjlmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmxygzzjlmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"PCMXYGZZJLMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzjlmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMXYGZZJLMXDTO pcmxygzzjlmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmxygzzjlmxService.checkKey(pcmxygzzjlmxMapping.toDomain(pcmxygzzjlmxdto)));
    }




    @PreAuthorize("hasPermission(#pcmxygzzjlmx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PCMXYGZZJLMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmxygzzjlmxes/{pcmxygzzjlmx_id}")
    @Transactional
    public ResponseEntity<PCMXYGZZJLMXDTO> update(@PathVariable("pcmxygzzjlmx_id") String pcmxygzzjlmx_id, @RequestBody PCMXYGZZJLMXDTO pcmxygzzjlmxdto) {
		PCMXYGZZJLMX domain = pcmxygzzjlmxMapping.toDomain(pcmxygzzjlmxdto);
        domain.setPcmxygzzjlmxid(pcmxygzzjlmx_id);
		pcmxygzzjlmxService.update(domain);
		PCMXYGZZJLMXDTO dto = pcmxygzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pcmxygzzjlmx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMXYGZZJLMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmxygzzjlmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMXYGZZJLMXDTO> pcmxygzzjlmxdtos) {
        pcmxygzzjlmxService.updateBatch(pcmxygzzjlmxMapping.toDomain(pcmxygzzjlmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PCMXYGZZJLMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmxygzzjlmxes/getdraft")
    public ResponseEntity<PCMXYGZZJLMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzjlmxMapping.toDto(pcmxygzzjlmxService.getDraft(new PCMXYGZZJLMX())));
    }




    @ApiOperation(value = "审核不通过", tags = {"PCMXYGZZJLMX" },  notes = "审核不通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzjlmxes/{pcmxygzzjlmx_id}/shbtg")
    @Transactional
    public ResponseEntity<PCMXYGZZJLMXDTO> sHBTG(@PathVariable("pcmxygzzjlmx_id") String pcmxygzzjlmx_id, @RequestBody PCMXYGZZJLMXDTO pcmxygzzjlmxdto) {
        PCMXYGZZJLMX pcmxygzzjlmx = pcmxygzzjlmxMapping.toDomain(pcmxygzzjlmxdto);
        pcmxygzzjlmx = pcmxygzzjlmxService.sHBTG(pcmxygzzjlmx);
        pcmxygzzjlmxdto = pcmxygzzjlmxMapping.toDto(pcmxygzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzjlmxdto);
    }




    @ApiOperation(value = "Save", tags = {"PCMXYGZZJLMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzjlmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMXYGZZJLMXDTO pcmxygzzjlmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzjlmxService.save(pcmxygzzjlmxMapping.toDomain(pcmxygzzjlmxdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PCMXYGZZJLMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzjlmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMXYGZZJLMXDTO> pcmxygzzjlmxdtos) {
        pcmxygzzjlmxService.saveBatch(pcmxygzzjlmxMapping.toDomain(pcmxygzzjlmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMXYGZZJLMX-ZZWSHDS-all')")
	@ApiOperation(value = "fetch试用期转正申请未审核", tags = {"PCMXYGZZJLMX" } ,notes = "fetch试用期转正申请未审核")
    @RequestMapping(method= RequestMethod.GET , value="/pcmxygzzjlmxes/fetchzzwshds")
	public ResponseEntity<List<PCMXYGZZJLMXDTO>> fetchZZWSHDS(PCMXYGZZJLMXSearchContext context) {
        Page<PCMXYGZZJLMX> domains = pcmxygzzjlmxService.searchZZWSHDS(context) ;
        List<PCMXYGZZJLMXDTO> list = pcmxygzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMXYGZZJLMX-ZZWSHDS-all')")
	@ApiOperation(value = "search试用期转正申请未审核", tags = {"PCMXYGZZJLMX" } ,notes = "search试用期转正申请未审核")
    @RequestMapping(method= RequestMethod.POST , value="/pcmxygzzjlmxes/searchzzwshds")
	public ResponseEntity<Page<PCMXYGZZJLMXDTO>> searchZZWSHDS(@RequestBody PCMXYGZZJLMXSearchContext context) {
        Page<PCMXYGZZJLMX> domains = pcmxygzzjlmxService.searchZZWSHDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmxygzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMXYGZZJLMX-ALLDS-all')")
	@ApiOperation(value = "fetch所有的试用期转正申请", tags = {"PCMXYGZZJLMX" } ,notes = "fetch所有的试用期转正申请")
    @RequestMapping(method= RequestMethod.GET , value="/pcmxygzzjlmxes/fetchallds")
	public ResponseEntity<List<PCMXYGZZJLMXDTO>> fetchALLDS(PCMXYGZZJLMXSearchContext context) {
        Page<PCMXYGZZJLMX> domains = pcmxygzzjlmxService.searchALLDS(context) ;
        List<PCMXYGZZJLMXDTO> list = pcmxygzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMXYGZZJLMX-ALLDS-all')")
	@ApiOperation(value = "search所有的试用期转正申请", tags = {"PCMXYGZZJLMX" } ,notes = "search所有的试用期转正申请")
    @RequestMapping(method= RequestMethod.POST , value="/pcmxygzzjlmxes/searchallds")
	public ResponseEntity<Page<PCMXYGZZJLMXDTO>> searchALLDS(@RequestBody PCMXYGZZJLMXSearchContext context) {
        Page<PCMXYGZZJLMX> domains = pcmxygzzjlmxService.searchALLDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmxygzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMXYGZZJLMX-SYQZZJL-all')")
	@ApiOperation(value = "fetch试用期转正记录", tags = {"PCMXYGZZJLMX" } ,notes = "fetch试用期转正记录")
    @RequestMapping(method= RequestMethod.GET , value="/pcmxygzzjlmxes/fetchsyqzzjl")
	public ResponseEntity<List<PCMXYGZZJLMXDTO>> fetchSYQZZJL(PCMXYGZZJLMXSearchContext context) {
        Page<PCMXYGZZJLMX> domains = pcmxygzzjlmxService.searchSYQZZJL(context) ;
        List<PCMXYGZZJLMXDTO> list = pcmxygzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMXYGZZJLMX-SYQZZJL-all')")
	@ApiOperation(value = "search试用期转正记录", tags = {"PCMXYGZZJLMX" } ,notes = "search试用期转正记录")
    @RequestMapping(method= RequestMethod.POST , value="/pcmxygzzjlmxes/searchsyqzzjl")
	public ResponseEntity<Page<PCMXYGZZJLMXDTO>> searchSYQZZJL(@RequestBody PCMXYGZZJLMXSearchContext context) {
        Page<PCMXYGZZJLMX> domains = pcmxygzzjlmxService.searchSYQZZJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmxygzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMXYGZZJLMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMXYGZZJLMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmxygzzjlmxes/fetchdefault")
	public ResponseEntity<List<PCMXYGZZJLMXDTO>> fetchDefault(PCMXYGZZJLMXSearchContext context) {
        Page<PCMXYGZZJLMX> domains = pcmxygzzjlmxService.searchDefault(context) ;
        List<PCMXYGZZJLMXDTO> list = pcmxygzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMXYGZZJLMX-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMXYGZZJLMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmxygzzjlmxes/searchdefault")
	public ResponseEntity<Page<PCMXYGZZJLMXDTO>> searchDefault(@RequestBody PCMXYGZZJLMXSearchContext context) {
        Page<PCMXYGZZJLMX> domains = pcmxygzzjlmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmxygzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PCMXYGZZJLMX getEntity(){
        return new PCMXYGZZJLMX();
    }

}
