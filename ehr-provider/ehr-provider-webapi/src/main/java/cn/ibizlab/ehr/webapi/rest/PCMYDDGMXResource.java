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
import cn.ibizlab.ehr.core.pcm.domain.PCMYDDGMX;
import cn.ibizlab.ehr.core.pcm.service.IPCMYDDGMXService;
import cn.ibizlab.ehr.core.pcm.filter.PCMYDDGMXSearchContext;

@Slf4j
@Api(tags = {"异动待岗明细" })
@RestController("WebApi-pcmyddgmx")
@RequestMapping("")
public class PCMYDDGMXResource {

    @Autowired
    public IPCMYDDGMXService pcmyddgmxService;

    @Autowired
    @Lazy
    public PCMYDDGMXMapping pcmyddgmxMapping;

    @PreAuthorize("hasPermission(this.pcmyddgmxService.get(#pcmyddgmx_id),'ehr-PCMYDDGMX-Remove')")
    @ApiOperation(value = "删除异动待岗明细", tags = {"异动待岗明细" },  notes = "删除异动待岗明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmyddgmxes/{pcmyddgmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmyddgmx_id") String pcmyddgmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmyddgmxService.remove(pcmyddgmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmyddgmxService.getPcmyddgmxByIds(#ids),'ehr-PCMYDDGMX-Remove')")
    @ApiOperation(value = "批量删除异动待岗明细", tags = {"异动待岗明细" },  notes = "批量删除异动待岗明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmyddgmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmyddgmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查异动待岗明细", tags = {"异动待岗明细" },  notes = "检查异动待岗明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmyddgmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMYDDGMXDTO pcmyddgmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmyddgmxService.checkKey(pcmyddgmxMapping.toDomain(pcmyddgmxdto)));
    }

    @PostAuthorize("hasPermission(this.pcmyddgmxMapping.toDomain(returnObject.body),'ehr-PCMYDDGMX-Get')")
    @ApiOperation(value = "获取异动待岗明细", tags = {"异动待岗明细" },  notes = "获取异动待岗明细")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmyddgmxes/{pcmyddgmx_id}")
    public ResponseEntity<PCMYDDGMXDTO> get(@PathVariable("pcmyddgmx_id") String pcmyddgmx_id) {
        PCMYDDGMX domain = pcmyddgmxService.get(pcmyddgmx_id);
        PCMYDDGMXDTO dto = pcmyddgmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmyddgmxMapping.toDomain(#pcmyddgmxdto),'ehr-PCMYDDGMX-Save')")
    @ApiOperation(value = "保存异动待岗明细", tags = {"异动待岗明细" },  notes = "保存异动待岗明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmyddgmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMYDDGMXDTO pcmyddgmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmyddgmxService.save(pcmyddgmxMapping.toDomain(pcmyddgmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmyddgmxMapping.toDomain(#pcmyddgmxdtos),'ehr-PCMYDDGMX-Save')")
    @ApiOperation(value = "批量保存异动待岗明细", tags = {"异动待岗明细" },  notes = "批量保存异动待岗明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmyddgmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMYDDGMXDTO> pcmyddgmxdtos) {
        pcmyddgmxService.saveBatch(pcmyddgmxMapping.toDomain(pcmyddgmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmyddgmxMapping.toDomain(#pcmyddgmxdto),'ehr-PCMYDDGMX-Create')")
    @ApiOperation(value = "新建异动待岗明细", tags = {"异动待岗明细" },  notes = "新建异动待岗明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmyddgmxes")
    @Transactional
    public ResponseEntity<PCMYDDGMXDTO> create(@RequestBody PCMYDDGMXDTO pcmyddgmxdto) {
        PCMYDDGMX domain = pcmyddgmxMapping.toDomain(pcmyddgmxdto);
		pcmyddgmxService.create(domain);
        PCMYDDGMXDTO dto = pcmyddgmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmyddgmxMapping.toDomain(#pcmyddgmxdtos),'ehr-PCMYDDGMX-Create')")
    @ApiOperation(value = "批量新建异动待岗明细", tags = {"异动待岗明细" },  notes = "批量新建异动待岗明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmyddgmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMYDDGMXDTO> pcmyddgmxdtos) {
        pcmyddgmxService.createBatch(pcmyddgmxMapping.toDomain(pcmyddgmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDDGMX-FillPersonInfo-all')")
    @ApiOperation(value = "填充人员信息", tags = {"异动待岗明细" },  notes = "填充人员信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmyddgmxes/{pcmyddgmx_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PCMYDDGMXDTO> fillPersonInfo(@PathVariable("pcmyddgmx_id") String pcmyddgmx_id, @RequestBody PCMYDDGMXDTO pcmyddgmxdto) {
        PCMYDDGMX pcmyddgmx = pcmyddgmxMapping.toDomain(pcmyddgmxdto);
        pcmyddgmx.setPcmyddgmxid(pcmyddgmx_id);
        pcmyddgmx = pcmyddgmxService.fillPersonInfo(pcmyddgmx);
        pcmyddgmxdto = pcmyddgmxMapping.toDto(pcmyddgmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmyddgmxdto);
    }

    @ApiOperation(value = "获取异动待岗明细草稿", tags = {"异动待岗明细" },  notes = "获取异动待岗明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmyddgmxes/getdraft")
    public ResponseEntity<PCMYDDGMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmyddgmxMapping.toDto(pcmyddgmxService.getDraft(new PCMYDDGMX())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDDGMX-QXDG-all')")
    @ApiOperation(value = "取消待岗", tags = {"异动待岗明细" },  notes = "取消待岗")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmyddgmxes/{pcmyddgmx_id}/qxdg")
    @Transactional
    public ResponseEntity<PCMYDDGMXDTO> qXDG(@PathVariable("pcmyddgmx_id") String pcmyddgmx_id, @RequestBody PCMYDDGMXDTO pcmyddgmxdto) {
        PCMYDDGMX pcmyddgmx = pcmyddgmxMapping.toDomain(pcmyddgmxdto);
        pcmyddgmx.setPcmyddgmxid(pcmyddgmx_id);
        pcmyddgmx = pcmyddgmxService.qXDG(pcmyddgmx);
        pcmyddgmxdto = pcmyddgmxMapping.toDto(pcmyddgmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmyddgmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmyddgmxService.get(#pcmyddgmx_id),'ehr-PCMYDDGMX-Update')")
    @ApiOperation(value = "更新异动待岗明细", tags = {"异动待岗明细" },  notes = "更新异动待岗明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmyddgmxes/{pcmyddgmx_id}")
    @Transactional
    public ResponseEntity<PCMYDDGMXDTO> update(@PathVariable("pcmyddgmx_id") String pcmyddgmx_id, @RequestBody PCMYDDGMXDTO pcmyddgmxdto) {
		PCMYDDGMX domain  = pcmyddgmxMapping.toDomain(pcmyddgmxdto);
        domain .setPcmyddgmxid(pcmyddgmx_id);
		pcmyddgmxService.update(domain );
		PCMYDDGMXDTO dto = pcmyddgmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmyddgmxService.getPcmyddgmxByEntities(this.pcmyddgmxMapping.toDomain(#pcmyddgmxdtos)),'ehr-PCMYDDGMX-Update')")
    @ApiOperation(value = "批量更新异动待岗明细", tags = {"异动待岗明细" },  notes = "批量更新异动待岗明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmyddgmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMYDDGMXDTO> pcmyddgmxdtos) {
        pcmyddgmxService.updateBatch(pcmyddgmxMapping.toDomain(pcmyddgmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDDGMX-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"异动待岗明细" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/pcmyddgmxes/fetchdefault")
	public ResponseEntity<List<PCMYDDGMXDTO>> fetchDefault(PCMYDDGMXSearchContext context) {
        Page<PCMYDDGMX> domains = pcmyddgmxService.searchDefault(context) ;
        List<PCMYDDGMXDTO> list = pcmyddgmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDDGMX-Default-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"异动待岗明细" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/pcmyddgmxes/searchdefault")
	public ResponseEntity<Page<PCMYDDGMXDTO>> searchDefault(@RequestBody PCMYDDGMXSearchContext context) {
        Page<PCMYDDGMX> domains = pcmyddgmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmyddgmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDDGMX-JLDS-all')")
	@ApiOperation(value = "获取记录查询", tags = {"异动待岗明细" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/pcmyddgmxes/fetchjlds")
	public ResponseEntity<List<PCMYDDGMXDTO>> fetchJLDS(PCMYDDGMXSearchContext context) {
        Page<PCMYDDGMX> domains = pcmyddgmxService.searchJLDS(context) ;
        List<PCMYDDGMXDTO> list = pcmyddgmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDDGMX-JLDS-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"异动待岗明细" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/pcmyddgmxes/searchjlds")
	public ResponseEntity<Page<PCMYDDGMXDTO>> searchJLDS(@RequestBody PCMYDDGMXSearchContext context) {
        Page<PCMYDDGMX> domains = pcmyddgmxService.searchJLDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmyddgmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDDGMX-GLDS-all')")
	@ApiOperation(value = "获取管理查询", tags = {"异动待岗明细" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/pcmyddgmxes/fetchglds")
	public ResponseEntity<List<PCMYDDGMXDTO>> fetchGLDS(PCMYDDGMXSearchContext context) {
        Page<PCMYDDGMX> domains = pcmyddgmxService.searchGLDS(context) ;
        List<PCMYDDGMXDTO> list = pcmyddgmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDDGMX-GLDS-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"异动待岗明细" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/pcmyddgmxes/searchglds")
	public ResponseEntity<Page<PCMYDDGMXDTO>> searchGLDS(@RequestBody PCMYDDGMXSearchContext context) {
        Page<PCMYDDGMX> domains = pcmyddgmxService.searchGLDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmyddgmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

