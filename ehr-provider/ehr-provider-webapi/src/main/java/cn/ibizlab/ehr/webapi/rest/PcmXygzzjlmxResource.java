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
import org.springframework.security.access.prepost.PostAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import cn.ibizlab.ehr.webapi.dto.*;
import cn.ibizlab.ehr.webapi.mapping.*;
import cn.ibizlab.ehr.core.pcm.domain.PcmXygzzjlmx;
import cn.ibizlab.ehr.core.pcm.service.IPcmXygzzjlmxService;
import cn.ibizlab.ehr.core.pcm.filter.PcmXygzzjlmxSearchContext;

@Slf4j
@Api(tags = {"试用期员工转正记录引用明细" })
@RestController("WebApi-pcmxygzzjlmx")
@RequestMapping("")
public class PcmXygzzjlmxResource {

    @Autowired
    public IPcmXygzzjlmxService pcmxygzzjlmxService;

    @Autowired
    @Lazy
    public PcmXygzzjlmxMapping pcmxygzzjlmxMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmXygzzjlmx-XYGZZCZ-all')")
    @ApiOperation(value = "新员工转正操作", tags = {"试用期员工转正记录引用明细" },  notes = "新员工转正操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzjlmxes/{pcmxygzzjlmx_id}/xygzzcz")
    @Transactional
    public ResponseEntity<PcmXygzzjlmxDTO> xYGZZCZ(@PathVariable("pcmxygzzjlmx_id") String pcmxygzzjlmx_id, @RequestBody PcmXygzzjlmxDTO pcmxygzzjlmxdto) {
        PcmXygzzjlmx pcmxygzzjlmx = pcmxygzzjlmxMapping.toDomain(pcmxygzzjlmxdto);
        pcmxygzzjlmx.setPcmxygzzjlmxid(pcmxygzzjlmx_id);
        pcmxygzzjlmx = pcmxygzzjlmxService.xYGZZCZ(pcmxygzzjlmx);
        pcmxygzzjlmxdto = pcmxygzzjlmxMapping.toDto(pcmxygzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzjlmxdto);
    }

    @PostAuthorize("hasPermission(this.pcmxygzzjlmxMapping.toDomain(returnObject.body),'ehr-PcmXygzzjlmx-Get')")
    @ApiOperation(value = "获取试用期员工转正记录引用明细", tags = {"试用期员工转正记录引用明细" },  notes = "获取试用期员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmxygzzjlmxes/{pcmxygzzjlmx_id}")
    public ResponseEntity<PcmXygzzjlmxDTO> get(@PathVariable("pcmxygzzjlmx_id") String pcmxygzzjlmx_id) {
        PcmXygzzjlmx domain = pcmxygzzjlmxService.get(pcmxygzzjlmx_id);
        PcmXygzzjlmxDTO dto = pcmxygzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmXygzzjlmx-SHTG-all')")
    @ApiOperation(value = "审核通过", tags = {"试用期员工转正记录引用明细" },  notes = "审核通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzjlmxes/{pcmxygzzjlmx_id}/shtg")
    @Transactional
    public ResponseEntity<PcmXygzzjlmxDTO> sHTG(@PathVariable("pcmxygzzjlmx_id") String pcmxygzzjlmx_id, @RequestBody PcmXygzzjlmxDTO pcmxygzzjlmxdto) {
        PcmXygzzjlmx pcmxygzzjlmx = pcmxygzzjlmxMapping.toDomain(pcmxygzzjlmxdto);
        pcmxygzzjlmx.setPcmxygzzjlmxid(pcmxygzzjlmx_id);
        pcmxygzzjlmx = pcmxygzzjlmxService.sHTG(pcmxygzzjlmx);
        pcmxygzzjlmxdto = pcmxygzzjlmxMapping.toDto(pcmxygzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmXygzzjlmx-FillPersonInfo-all')")
    @ApiOperation(value = "设置人员信息", tags = {"试用期员工转正记录引用明细" },  notes = "设置人员信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzjlmxes/{pcmxygzzjlmx_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PcmXygzzjlmxDTO> fillPersonInfo(@PathVariable("pcmxygzzjlmx_id") String pcmxygzzjlmx_id, @RequestBody PcmXygzzjlmxDTO pcmxygzzjlmxdto) {
        PcmXygzzjlmx pcmxygzzjlmx = pcmxygzzjlmxMapping.toDomain(pcmxygzzjlmxdto);
        pcmxygzzjlmx.setPcmxygzzjlmxid(pcmxygzzjlmx_id);
        pcmxygzzjlmx = pcmxygzzjlmxService.fillPersonInfo(pcmxygzzjlmx);
        pcmxygzzjlmxdto = pcmxygzzjlmxMapping.toDto(pcmxygzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzjlmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmxygzzjlmxMapping.toDomain(#pcmxygzzjlmxdto),'ehr-PcmXygzzjlmx-Create')")
    @ApiOperation(value = "新建试用期员工转正记录引用明细", tags = {"试用期员工转正记录引用明细" },  notes = "新建试用期员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzjlmxes")
    @Transactional
    public ResponseEntity<PcmXygzzjlmxDTO> create(@RequestBody PcmXygzzjlmxDTO pcmxygzzjlmxdto) {
        PcmXygzzjlmx domain = pcmxygzzjlmxMapping.toDomain(pcmxygzzjlmxdto);
		pcmxygzzjlmxService.create(domain);
        PcmXygzzjlmxDTO dto = pcmxygzzjlmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmxygzzjlmxMapping.toDomain(#pcmxygzzjlmxdtos),'ehr-PcmXygzzjlmx-Create')")
    @ApiOperation(value = "批量新建试用期员工转正记录引用明细", tags = {"试用期员工转正记录引用明细" },  notes = "批量新建试用期员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzjlmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmXygzzjlmxDTO> pcmxygzzjlmxdtos) {
        pcmxygzzjlmxService.createBatch(pcmxygzzjlmxMapping.toDomain(pcmxygzzjlmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmxygzzjlmxService.get(#pcmxygzzjlmx_id),'ehr-PcmXygzzjlmx-Remove')")
    @ApiOperation(value = "删除试用期员工转正记录引用明细", tags = {"试用期员工转正记录引用明细" },  notes = "删除试用期员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmxygzzjlmxes/{pcmxygzzjlmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmxygzzjlmx_id") String pcmxygzzjlmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzjlmxService.remove(pcmxygzzjlmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmxygzzjlmxService.getPcmxygzzjlmxByIds(#ids),'ehr-PcmXygzzjlmx-Remove')")
    @ApiOperation(value = "批量删除试用期员工转正记录引用明细", tags = {"试用期员工转正记录引用明细" },  notes = "批量删除试用期员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmxygzzjlmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmxygzzjlmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查试用期员工转正记录引用明细", tags = {"试用期员工转正记录引用明细" },  notes = "检查试用期员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzjlmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmXygzzjlmxDTO pcmxygzzjlmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmxygzzjlmxService.checkKey(pcmxygzzjlmxMapping.toDomain(pcmxygzzjlmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmxygzzjlmxService.get(#pcmxygzzjlmx_id),'ehr-PcmXygzzjlmx-Update')")
    @ApiOperation(value = "更新试用期员工转正记录引用明细", tags = {"试用期员工转正记录引用明细" },  notes = "更新试用期员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmxygzzjlmxes/{pcmxygzzjlmx_id}")
    @Transactional
    public ResponseEntity<PcmXygzzjlmxDTO> update(@PathVariable("pcmxygzzjlmx_id") String pcmxygzzjlmx_id, @RequestBody PcmXygzzjlmxDTO pcmxygzzjlmxdto) {
		PcmXygzzjlmx domain  = pcmxygzzjlmxMapping.toDomain(pcmxygzzjlmxdto);
        domain .setPcmxygzzjlmxid(pcmxygzzjlmx_id);
		pcmxygzzjlmxService.update(domain );
		PcmXygzzjlmxDTO dto = pcmxygzzjlmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmxygzzjlmxService.getPcmxygzzjlmxByEntities(this.pcmxygzzjlmxMapping.toDomain(#pcmxygzzjlmxdtos)),'ehr-PcmXygzzjlmx-Update')")
    @ApiOperation(value = "批量更新试用期员工转正记录引用明细", tags = {"试用期员工转正记录引用明细" },  notes = "批量更新试用期员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmxygzzjlmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmXygzzjlmxDTO> pcmxygzzjlmxdtos) {
        pcmxygzzjlmxService.updateBatch(pcmxygzzjlmxMapping.toDomain(pcmxygzzjlmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取试用期员工转正记录引用明细草稿", tags = {"试用期员工转正记录引用明细" },  notes = "获取试用期员工转正记录引用明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmxygzzjlmxes/getdraft")
    public ResponseEntity<PcmXygzzjlmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzjlmxMapping.toDto(pcmxygzzjlmxService.getDraft(new PcmXygzzjlmx())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmXygzzjlmx-SHBTG-all')")
    @ApiOperation(value = "审核不通过", tags = {"试用期员工转正记录引用明细" },  notes = "审核不通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzjlmxes/{pcmxygzzjlmx_id}/shbtg")
    @Transactional
    public ResponseEntity<PcmXygzzjlmxDTO> sHBTG(@PathVariable("pcmxygzzjlmx_id") String pcmxygzzjlmx_id, @RequestBody PcmXygzzjlmxDTO pcmxygzzjlmxdto) {
        PcmXygzzjlmx pcmxygzzjlmx = pcmxygzzjlmxMapping.toDomain(pcmxygzzjlmxdto);
        pcmxygzzjlmx.setPcmxygzzjlmxid(pcmxygzzjlmx_id);
        pcmxygzzjlmx = pcmxygzzjlmxService.sHBTG(pcmxygzzjlmx);
        pcmxygzzjlmxdto = pcmxygzzjlmxMapping.toDto(pcmxygzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzjlmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmxygzzjlmxMapping.toDomain(#pcmxygzzjlmxdto),'ehr-PcmXygzzjlmx-Save')")
    @ApiOperation(value = "保存试用期员工转正记录引用明细", tags = {"试用期员工转正记录引用明细" },  notes = "保存试用期员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzjlmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmXygzzjlmxDTO pcmxygzzjlmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzjlmxService.save(pcmxygzzjlmxMapping.toDomain(pcmxygzzjlmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmxygzzjlmxMapping.toDomain(#pcmxygzzjlmxdtos),'ehr-PcmXygzzjlmx-Save')")
    @ApiOperation(value = "批量保存试用期员工转正记录引用明细", tags = {"试用期员工转正记录引用明细" },  notes = "批量保存试用期员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzjlmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmXygzzjlmxDTO> pcmxygzzjlmxdtos) {
        pcmxygzzjlmxService.saveBatch(pcmxygzzjlmxMapping.toDomain(pcmxygzzjlmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmXygzzjlmx-ZZWSHDS-all')")
	@ApiOperation(value = "获取试用期转正申请未审核", tags = {"试用期员工转正记录引用明细" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/pcmxygzzjlmxes/fetchzzwshds")
	public ResponseEntity<List<PcmXygzzjlmxDTO>> fetchZZWSHDS(PcmXygzzjlmxSearchContext context) {
        Page<PcmXygzzjlmx> domains = pcmxygzzjlmxService.searchZZWSHDS(context) ;
        List<PcmXygzzjlmxDTO> list = pcmxygzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmXygzzjlmx-ZZWSHDS-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"试用期员工转正记录引用明细" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/pcmxygzzjlmxes/searchzzwshds")
	public ResponseEntity<Page<PcmXygzzjlmxDTO>> searchZZWSHDS(@RequestBody PcmXygzzjlmxSearchContext context) {
        Page<PcmXygzzjlmx> domains = pcmxygzzjlmxService.searchZZWSHDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmxygzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmXygzzjlmx-ALLDS-all')")
	@ApiOperation(value = "获取所有的试用期转正申请", tags = {"试用期员工转正记录引用明细" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/pcmxygzzjlmxes/fetchallds")
	public ResponseEntity<List<PcmXygzzjlmxDTO>> fetchALLDS(PcmXygzzjlmxSearchContext context) {
        Page<PcmXygzzjlmx> domains = pcmxygzzjlmxService.searchALLDS(context) ;
        List<PcmXygzzjlmxDTO> list = pcmxygzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmXygzzjlmx-ALLDS-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"试用期员工转正记录引用明细" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/pcmxygzzjlmxes/searchallds")
	public ResponseEntity<Page<PcmXygzzjlmxDTO>> searchALLDS(@RequestBody PcmXygzzjlmxSearchContext context) {
        Page<PcmXygzzjlmx> domains = pcmxygzzjlmxService.searchALLDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmxygzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmXygzzjlmx-SYQZZJL-all')")
	@ApiOperation(value = "获取试用期转正记录", tags = {"试用期员工转正记录引用明细" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/pcmxygzzjlmxes/fetchsyqzzjl")
	public ResponseEntity<List<PcmXygzzjlmxDTO>> fetchSYQZZJL(PcmXygzzjlmxSearchContext context) {
        Page<PcmXygzzjlmx> domains = pcmxygzzjlmxService.searchSYQZZJL(context) ;
        List<PcmXygzzjlmxDTO> list = pcmxygzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmXygzzjlmx-SYQZZJL-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"试用期员工转正记录引用明细" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/pcmxygzzjlmxes/searchsyqzzjl")
	public ResponseEntity<Page<PcmXygzzjlmxDTO>> searchSYQZZJL(@RequestBody PcmXygzzjlmxSearchContext context) {
        Page<PcmXygzzjlmx> domains = pcmxygzzjlmxService.searchSYQZZJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmxygzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmXygzzjlmx-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"试用期员工转正记录引用明细" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/pcmxygzzjlmxes/fetchdefault")
	public ResponseEntity<List<PcmXygzzjlmxDTO>> fetchDefault(PcmXygzzjlmxSearchContext context) {
        Page<PcmXygzzjlmx> domains = pcmxygzzjlmxService.searchDefault(context) ;
        List<PcmXygzzjlmxDTO> list = pcmxygzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmXygzzjlmx-Default-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"试用期员工转正记录引用明细" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/pcmxygzzjlmxes/searchdefault")
	public ResponseEntity<Page<PcmXygzzjlmxDTO>> searchDefault(@RequestBody PcmXygzzjlmxSearchContext context) {
        Page<PcmXygzzjlmx> domains = pcmxygzzjlmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmxygzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

