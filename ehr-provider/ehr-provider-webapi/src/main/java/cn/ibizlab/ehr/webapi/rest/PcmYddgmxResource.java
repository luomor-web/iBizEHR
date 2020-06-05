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
import cn.ibizlab.ehr.core.pcm.domain.PcmYddgmx;
import cn.ibizlab.ehr.core.pcm.service.IPcmYddgmxService;
import cn.ibizlab.ehr.core.pcm.filter.PcmYddgmxSearchContext;

@Slf4j
@Api(tags = {"异动待岗明细" })
@RestController("WebApi-pcmyddgmx")
@RequestMapping("")
public class PcmYddgmxResource {

    @Autowired
    public IPcmYddgmxService pcmyddgmxService;

    @Autowired
    @Lazy
    public PcmYddgmxMapping pcmyddgmxMapping;

    @PreAuthorize("hasPermission(this.pcmyddgmxService.get(#pcmyddgmx_id),'ehr-PcmYddgmx-Remove')")
    @ApiOperation(value = "删除异动待岗明细", tags = {"异动待岗明细" },  notes = "删除异动待岗明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmyddgmxes/{pcmyddgmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmyddgmx_id") String pcmyddgmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmyddgmxService.remove(pcmyddgmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmyddgmxService.getPcmyddgmxByIds(#ids),'ehr-PcmYddgmx-Remove')")
    @ApiOperation(value = "批量删除异动待岗明细", tags = {"异动待岗明细" },  notes = "批量删除异动待岗明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmyddgmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmyddgmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查异动待岗明细", tags = {"异动待岗明细" },  notes = "检查异动待岗明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmyddgmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmYddgmxDTO pcmyddgmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmyddgmxService.checkKey(pcmyddgmxMapping.toDomain(pcmyddgmxdto)));
    }

    @PostAuthorize("hasPermission(this.pcmyddgmxMapping.toDomain(returnObject.body),'ehr-PcmYddgmx-Get')")
    @ApiOperation(value = "获取异动待岗明细", tags = {"异动待岗明细" },  notes = "获取异动待岗明细")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmyddgmxes/{pcmyddgmx_id}")
    public ResponseEntity<PcmYddgmxDTO> get(@PathVariable("pcmyddgmx_id") String pcmyddgmx_id) {
        PcmYddgmx domain = pcmyddgmxService.get(pcmyddgmx_id);
        PcmYddgmxDTO dto = pcmyddgmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmyddgmxMapping.toDomain(#pcmyddgmxdto),'ehr-PcmYddgmx-Save')")
    @ApiOperation(value = "保存异动待岗明细", tags = {"异动待岗明细" },  notes = "保存异动待岗明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmyddgmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmYddgmxDTO pcmyddgmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmyddgmxService.save(pcmyddgmxMapping.toDomain(pcmyddgmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmyddgmxMapping.toDomain(#pcmyddgmxdtos),'ehr-PcmYddgmx-Save')")
    @ApiOperation(value = "批量保存异动待岗明细", tags = {"异动待岗明细" },  notes = "批量保存异动待岗明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmyddgmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmYddgmxDTO> pcmyddgmxdtos) {
        pcmyddgmxService.saveBatch(pcmyddgmxMapping.toDomain(pcmyddgmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmyddgmxMapping.toDomain(#pcmyddgmxdto),'ehr-PcmYddgmx-Create')")
    @ApiOperation(value = "新建异动待岗明细", tags = {"异动待岗明细" },  notes = "新建异动待岗明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmyddgmxes")
    @Transactional
    public ResponseEntity<PcmYddgmxDTO> create(@RequestBody PcmYddgmxDTO pcmyddgmxdto) {
        PcmYddgmx domain = pcmyddgmxMapping.toDomain(pcmyddgmxdto);
		pcmyddgmxService.create(domain);
        PcmYddgmxDTO dto = pcmyddgmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmyddgmxMapping.toDomain(#pcmyddgmxdtos),'ehr-PcmYddgmx-Create')")
    @ApiOperation(value = "批量新建异动待岗明细", tags = {"异动待岗明细" },  notes = "批量新建异动待岗明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmyddgmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmYddgmxDTO> pcmyddgmxdtos) {
        pcmyddgmxService.createBatch(pcmyddgmxMapping.toDomain(pcmyddgmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYddgmx-FillPersonInfo-all')")
    @ApiOperation(value = "填充人员信息", tags = {"异动待岗明细" },  notes = "填充人员信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmyddgmxes/{pcmyddgmx_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PcmYddgmxDTO> fillPersonInfo(@PathVariable("pcmyddgmx_id") String pcmyddgmx_id, @RequestBody PcmYddgmxDTO pcmyddgmxdto) {
        PcmYddgmx pcmyddgmx = pcmyddgmxMapping.toDomain(pcmyddgmxdto);
        pcmyddgmx.setPcmyddgmxid(pcmyddgmx_id);
        pcmyddgmx = pcmyddgmxService.fillPersonInfo(pcmyddgmx);
        pcmyddgmxdto = pcmyddgmxMapping.toDto(pcmyddgmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmyddgmxdto);
    }

    @ApiOperation(value = "获取异动待岗明细草稿", tags = {"异动待岗明细" },  notes = "获取异动待岗明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmyddgmxes/getdraft")
    public ResponseEntity<PcmYddgmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmyddgmxMapping.toDto(pcmyddgmxService.getDraft(new PcmYddgmx())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYddgmx-QXDG-all')")
    @ApiOperation(value = "取消待岗", tags = {"异动待岗明细" },  notes = "取消待岗")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmyddgmxes/{pcmyddgmx_id}/qxdg")
    @Transactional
    public ResponseEntity<PcmYddgmxDTO> qXDG(@PathVariable("pcmyddgmx_id") String pcmyddgmx_id, @RequestBody PcmYddgmxDTO pcmyddgmxdto) {
        PcmYddgmx pcmyddgmx = pcmyddgmxMapping.toDomain(pcmyddgmxdto);
        pcmyddgmx.setPcmyddgmxid(pcmyddgmx_id);
        pcmyddgmx = pcmyddgmxService.qXDG(pcmyddgmx);
        pcmyddgmxdto = pcmyddgmxMapping.toDto(pcmyddgmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmyddgmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmyddgmxService.get(#pcmyddgmx_id),'ehr-PcmYddgmx-Update')")
    @ApiOperation(value = "更新异动待岗明细", tags = {"异动待岗明细" },  notes = "更新异动待岗明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmyddgmxes/{pcmyddgmx_id}")
    @Transactional
    public ResponseEntity<PcmYddgmxDTO> update(@PathVariable("pcmyddgmx_id") String pcmyddgmx_id, @RequestBody PcmYddgmxDTO pcmyddgmxdto) {
		PcmYddgmx domain  = pcmyddgmxMapping.toDomain(pcmyddgmxdto);
        domain .setPcmyddgmxid(pcmyddgmx_id);
		pcmyddgmxService.update(domain );
		PcmYddgmxDTO dto = pcmyddgmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmyddgmxService.getPcmyddgmxByEntities(this.pcmyddgmxMapping.toDomain(#pcmyddgmxdtos)),'ehr-PcmYddgmx-Update')")
    @ApiOperation(value = "批量更新异动待岗明细", tags = {"异动待岗明细" },  notes = "批量更新异动待岗明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmyddgmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmYddgmxDTO> pcmyddgmxdtos) {
        pcmyddgmxService.updateBatch(pcmyddgmxMapping.toDomain(pcmyddgmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYddgmx-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"异动待岗明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmyddgmxes/fetchdefault")
	public ResponseEntity<List<PcmYddgmxDTO>> fetchDefault(PcmYddgmxSearchContext context) {
        Page<PcmYddgmx> domains = pcmyddgmxService.searchDefault(context) ;
        List<PcmYddgmxDTO> list = pcmyddgmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYddgmx-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"异动待岗明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmyddgmxes/searchdefault")
	public ResponseEntity<Page<PcmYddgmxDTO>> searchDefault(@RequestBody PcmYddgmxSearchContext context) {
        Page<PcmYddgmx> domains = pcmyddgmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmyddgmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYddgmx-JLDS-all')")
	@ApiOperation(value = "获取记录查询", tags = {"异动待岗明细" } ,notes = "获取记录查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmyddgmxes/fetchjlds")
	public ResponseEntity<List<PcmYddgmxDTO>> fetchJLDS(PcmYddgmxSearchContext context) {
        Page<PcmYddgmx> domains = pcmyddgmxService.searchJLDS(context) ;
        List<PcmYddgmxDTO> list = pcmyddgmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYddgmx-JLDS-all')")
	@ApiOperation(value = "查询记录查询", tags = {"异动待岗明细" } ,notes = "查询记录查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmyddgmxes/searchjlds")
	public ResponseEntity<Page<PcmYddgmxDTO>> searchJLDS(@RequestBody PcmYddgmxSearchContext context) {
        Page<PcmYddgmx> domains = pcmyddgmxService.searchJLDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmyddgmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYddgmx-GLDS-all')")
	@ApiOperation(value = "获取管理查询", tags = {"异动待岗明细" } ,notes = "获取管理查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmyddgmxes/fetchglds")
	public ResponseEntity<List<PcmYddgmxDTO>> fetchGLDS(PcmYddgmxSearchContext context) {
        Page<PcmYddgmx> domains = pcmyddgmxService.searchGLDS(context) ;
        List<PcmYddgmxDTO> list = pcmyddgmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYddgmx-GLDS-all')")
	@ApiOperation(value = "查询管理查询", tags = {"异动待岗明细" } ,notes = "查询管理查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmyddgmxes/searchglds")
	public ResponseEntity<Page<PcmYddgmxDTO>> searchGLDS(@RequestBody PcmYddgmxSearchContext context) {
        Page<PcmYddgmx> domains = pcmyddgmxService.searchGLDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmyddgmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

