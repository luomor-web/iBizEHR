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
import cn.ibizlab.ehr.core.pcm.domain.PcmYdntmx;
import cn.ibizlab.ehr.core.pcm.service.IPcmYdntmxService;
import cn.ibizlab.ehr.core.pcm.filter.PcmYdntmxSearchContext;

@Slf4j
@Api(tags = {"异动内退明细" })
@RestController("WebApi-pcmydntmx")
@RequestMapping("")
public class PcmYdntmxResource {

    @Autowired
    public IPcmYdntmxService pcmydntmxService;

    @Autowired
    @Lazy
    public PcmYdntmxMapping pcmydntmxMapping;

    @ApiOperation(value = "获取异动内退明细草稿", tags = {"异动内退明细" },  notes = "获取异动内退明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydntmxes/getdraft")
    public ResponseEntity<PcmYdntmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydntmxMapping.toDto(pcmydntmxService.getDraft(new PcmYdntmx())));
    }

    @ApiOperation(value = "检查异动内退明细", tags = {"异动内退明细" },  notes = "检查异动内退明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydntmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmYdntmxDTO pcmydntmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmydntmxService.checkKey(pcmydntmxMapping.toDomain(pcmydntmxdto)));
    }

    @PostAuthorize("hasPermission(this.pcmydntmxMapping.toDomain(returnObject.body),'ehr-PcmYdntmx-Get')")
    @ApiOperation(value = "获取异动内退明细", tags = {"异动内退明细" },  notes = "获取异动内退明细")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydntmxes/{pcmydntmx_id}")
    public ResponseEntity<PcmYdntmxDTO> get(@PathVariable("pcmydntmx_id") String pcmydntmx_id) {
        PcmYdntmx domain = pcmydntmxService.get(pcmydntmx_id);
        PcmYdntmxDTO dto = pcmydntmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydntmxMapping.toDomain(#pcmydntmxdto),'ehr-PcmYdntmx-Create')")
    @ApiOperation(value = "新建异动内退明细", tags = {"异动内退明细" },  notes = "新建异动内退明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydntmxes")
    @Transactional
    public ResponseEntity<PcmYdntmxDTO> create(@RequestBody PcmYdntmxDTO pcmydntmxdto) {
        PcmYdntmx domain = pcmydntmxMapping.toDomain(pcmydntmxdto);
		pcmydntmxService.create(domain);
        PcmYdntmxDTO dto = pcmydntmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydntmxMapping.toDomain(#pcmydntmxdtos),'ehr-PcmYdntmx-Create')")
    @ApiOperation(value = "批量新建异动内退明细", tags = {"异动内退明细" },  notes = "批量新建异动内退明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydntmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmYdntmxDTO> pcmydntmxdtos) {
        pcmydntmxService.createBatch(pcmydntmxMapping.toDomain(pcmydntmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydntmxMapping.toDomain(#pcmydntmxdto),'ehr-PcmYdntmx-Save')")
    @ApiOperation(value = "保存异动内退明细", tags = {"异动内退明细" },  notes = "保存异动内退明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydntmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmYdntmxDTO pcmydntmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydntmxService.save(pcmydntmxMapping.toDomain(pcmydntmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmydntmxMapping.toDomain(#pcmydntmxdtos),'ehr-PcmYdntmx-Save')")
    @ApiOperation(value = "批量保存异动内退明细", tags = {"异动内退明细" },  notes = "批量保存异动内退明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydntmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmYdntmxDTO> pcmydntmxdtos) {
        pcmydntmxService.saveBatch(pcmydntmxMapping.toDomain(pcmydntmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydntmxService.get(#pcmydntmx_id),'ehr-PcmYdntmx-Remove')")
    @ApiOperation(value = "删除异动内退明细", tags = {"异动内退明细" },  notes = "删除异动内退明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydntmxes/{pcmydntmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmydntmx_id") String pcmydntmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmydntmxService.remove(pcmydntmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmydntmxService.getPcmydntmxByIds(#ids),'ehr-PcmYdntmx-Remove')")
    @ApiOperation(value = "批量删除异动内退明细", tags = {"异动内退明细" },  notes = "批量删除异动内退明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydntmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmydntmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdntmx-FillPersonInfo-all')")
    @ApiOperation(value = "填充人员信息", tags = {"异动内退明细" },  notes = "填充人员信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydntmxes/{pcmydntmx_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PcmYdntmxDTO> fillPersonInfo(@PathVariable("pcmydntmx_id") String pcmydntmx_id, @RequestBody PcmYdntmxDTO pcmydntmxdto) {
        PcmYdntmx pcmydntmx = pcmydntmxMapping.toDomain(pcmydntmxdto);
        pcmydntmx.setPcmydntmxid(pcmydntmx_id);
        pcmydntmx = pcmydntmxService.fillPersonInfo(pcmydntmx);
        pcmydntmxdto = pcmydntmxMapping.toDto(pcmydntmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydntmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmydntmxService.get(#pcmydntmx_id),'ehr-PcmYdntmx-Update')")
    @ApiOperation(value = "更新异动内退明细", tags = {"异动内退明细" },  notes = "更新异动内退明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydntmxes/{pcmydntmx_id}")
    @Transactional
    public ResponseEntity<PcmYdntmxDTO> update(@PathVariable("pcmydntmx_id") String pcmydntmx_id, @RequestBody PcmYdntmxDTO pcmydntmxdto) {
		PcmYdntmx domain  = pcmydntmxMapping.toDomain(pcmydntmxdto);
        domain .setPcmydntmxid(pcmydntmx_id);
		pcmydntmxService.update(domain );
		PcmYdntmxDTO dto = pcmydntmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydntmxService.getPcmydntmxByEntities(this.pcmydntmxMapping.toDomain(#pcmydntmxdtos)),'ehr-PcmYdntmx-Update')")
    @ApiOperation(value = "批量更新异动内退明细", tags = {"异动内退明细" },  notes = "批量更新异动内退明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydntmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmYdntmxDTO> pcmydntmxdtos) {
        pcmydntmxService.updateBatch(pcmydntmxMapping.toDomain(pcmydntmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdntmx-FinishNT-all')")
    @ApiOperation(value = "结束内退", tags = {"异动内退明细" },  notes = "结束内退")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydntmxes/{pcmydntmx_id}/finishnt")
    @Transactional
    public ResponseEntity<PcmYdntmxDTO> finishNT(@PathVariable("pcmydntmx_id") String pcmydntmx_id, @RequestBody PcmYdntmxDTO pcmydntmxdto) {
        PcmYdntmx pcmydntmx = pcmydntmxMapping.toDomain(pcmydntmxdto);
        pcmydntmx.setPcmydntmxid(pcmydntmx_id);
        pcmydntmx = pcmydntmxService.finishNT(pcmydntmx);
        pcmydntmxdto = pcmydntmxMapping.toDto(pcmydntmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydntmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdntmx-JLDS-all')")
	@ApiOperation(value = "获取记录查询", tags = {"异动内退明细" } ,notes = "获取记录查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydntmxes/fetchjlds")
	public ResponseEntity<List<PcmYdntmxDTO>> fetchJLDS(PcmYdntmxSearchContext context) {
        Page<PcmYdntmx> domains = pcmydntmxService.searchJLDS(context) ;
        List<PcmYdntmxDTO> list = pcmydntmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdntmx-JLDS-all')")
	@ApiOperation(value = "查询记录查询", tags = {"异动内退明细" } ,notes = "查询记录查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydntmxes/searchjlds")
	public ResponseEntity<Page<PcmYdntmxDTO>> searchJLDS(@RequestBody PcmYdntmxSearchContext context) {
        Page<PcmYdntmx> domains = pcmydntmxService.searchJLDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydntmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdntmx-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"异动内退明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydntmxes/fetchdefault")
	public ResponseEntity<List<PcmYdntmxDTO>> fetchDefault(PcmYdntmxSearchContext context) {
        Page<PcmYdntmx> domains = pcmydntmxService.searchDefault(context) ;
        List<PcmYdntmxDTO> list = pcmydntmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdntmx-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"异动内退明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydntmxes/searchdefault")
	public ResponseEntity<Page<PcmYdntmxDTO>> searchDefault(@RequestBody PcmYdntmxSearchContext context) {
        Page<PcmYdntmx> domains = pcmydntmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydntmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdntmx-GLDS-all')")
	@ApiOperation(value = "获取管理查询", tags = {"异动内退明细" } ,notes = "获取管理查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydntmxes/fetchglds")
	public ResponseEntity<List<PcmYdntmxDTO>> fetchGLDS(PcmYdntmxSearchContext context) {
        Page<PcmYdntmx> domains = pcmydntmxService.searchGLDS(context) ;
        List<PcmYdntmxDTO> list = pcmydntmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdntmx-GLDS-all')")
	@ApiOperation(value = "查询管理查询", tags = {"异动内退明细" } ,notes = "查询管理查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydntmxes/searchglds")
	public ResponseEntity<Page<PcmYdntmxDTO>> searchGLDS(@RequestBody PcmYdntmxSearchContext context) {
        Page<PcmYdntmx> domains = pcmydntmxService.searchGLDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydntmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

