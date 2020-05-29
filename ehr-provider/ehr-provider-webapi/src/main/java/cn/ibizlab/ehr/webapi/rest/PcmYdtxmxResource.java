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
import cn.ibizlab.ehr.core.pcm.domain.PcmYdtxmx;
import cn.ibizlab.ehr.core.pcm.service.IPcmYdtxmxService;
import cn.ibizlab.ehr.core.pcm.filter.PcmYdtxmxSearchContext;

@Slf4j
@Api(tags = {"异动退休明细" })
@RestController("WebApi-pcmydtxmx")
@RequestMapping("")
public class PcmYdtxmxResource {

    @Autowired
    public IPcmYdtxmxService pcmydtxmxService;

    @Autowired
    @Lazy
    public PcmYdtxmxMapping pcmydtxmxMapping;

    @PreAuthorize("hasPermission(this.pcmydtxmxService.get(#pcmydtxmx_id),'ehr-PcmYdtxmx-Remove')")
    @ApiOperation(value = "删除异动退休明细", tags = {"异动退休明细" },  notes = "删除异动退休明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydtxmxes/{pcmydtxmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmydtxmx_id") String pcmydtxmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmydtxmxService.remove(pcmydtxmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmydtxmxService.getPcmydtxmxByIds(#ids),'ehr-PcmYdtxmx-Remove')")
    @ApiOperation(value = "批量删除异动退休明细", tags = {"异动退休明细" },  notes = "批量删除异动退休明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydtxmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmydtxmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydtxmxMapping.toDomain(#pcmydtxmxdto),'ehr-PcmYdtxmx-Create')")
    @ApiOperation(value = "新建异动退休明细", tags = {"异动退休明细" },  notes = "新建异动退休明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydtxmxes")
    @Transactional
    public ResponseEntity<PcmYdtxmxDTO> create(@RequestBody PcmYdtxmxDTO pcmydtxmxdto) {
        PcmYdtxmx domain = pcmydtxmxMapping.toDomain(pcmydtxmxdto);
		pcmydtxmxService.create(domain);
        PcmYdtxmxDTO dto = pcmydtxmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydtxmxMapping.toDomain(#pcmydtxmxdtos),'ehr-PcmYdtxmx-Create')")
    @ApiOperation(value = "批量新建异动退休明细", tags = {"异动退休明细" },  notes = "批量新建异动退休明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydtxmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmYdtxmxDTO> pcmydtxmxdtos) {
        pcmydtxmxService.createBatch(pcmydtxmxMapping.toDomain(pcmydtxmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydtxmxMapping.toDomain(#pcmydtxmxdto),'ehr-PcmYdtxmx-Save')")
    @ApiOperation(value = "保存异动退休明细", tags = {"异动退休明细" },  notes = "保存异动退休明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydtxmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmYdtxmxDTO pcmydtxmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydtxmxService.save(pcmydtxmxMapping.toDomain(pcmydtxmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmydtxmxMapping.toDomain(#pcmydtxmxdtos),'ehr-PcmYdtxmx-Save')")
    @ApiOperation(value = "批量保存异动退休明细", tags = {"异动退休明细" },  notes = "批量保存异动退休明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydtxmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmYdtxmxDTO> pcmydtxmxdtos) {
        pcmydtxmxService.saveBatch(pcmydtxmxMapping.toDomain(pcmydtxmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取异动退休明细草稿", tags = {"异动退休明细" },  notes = "获取异动退休明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydtxmxes/getdraft")
    public ResponseEntity<PcmYdtxmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydtxmxMapping.toDto(pcmydtxmxService.getDraft(new PcmYdtxmx())));
    }

    @PostAuthorize("hasPermission(this.pcmydtxmxMapping.toDomain(returnObject.body),'ehr-PcmYdtxmx-Get')")
    @ApiOperation(value = "获取异动退休明细", tags = {"异动退休明细" },  notes = "获取异动退休明细")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydtxmxes/{pcmydtxmx_id}")
    public ResponseEntity<PcmYdtxmxDTO> get(@PathVariable("pcmydtxmx_id") String pcmydtxmx_id) {
        PcmYdtxmx domain = pcmydtxmxService.get(pcmydtxmx_id);
        PcmYdtxmxDTO dto = pcmydtxmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "检查异动退休明细", tags = {"异动退休明细" },  notes = "检查异动退休明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydtxmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmYdtxmxDTO pcmydtxmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmydtxmxService.checkKey(pcmydtxmxMapping.toDomain(pcmydtxmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmydtxmxService.get(#pcmydtxmx_id),'ehr-PcmYdtxmx-Update')")
    @ApiOperation(value = "更新异动退休明细", tags = {"异动退休明细" },  notes = "更新异动退休明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydtxmxes/{pcmydtxmx_id}")
    @Transactional
    public ResponseEntity<PcmYdtxmxDTO> update(@PathVariable("pcmydtxmx_id") String pcmydtxmx_id, @RequestBody PcmYdtxmxDTO pcmydtxmxdto) {
		PcmYdtxmx domain  = pcmydtxmxMapping.toDomain(pcmydtxmxdto);
        domain .setPcmydtxmxid(pcmydtxmx_id);
		pcmydtxmxService.update(domain );
		PcmYdtxmxDTO dto = pcmydtxmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydtxmxService.getPcmydtxmxByEntities(this.pcmydtxmxMapping.toDomain(#pcmydtxmxdtos)),'ehr-PcmYdtxmx-Update')")
    @ApiOperation(value = "批量更新异动退休明细", tags = {"异动退休明细" },  notes = "批量更新异动退休明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydtxmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmYdtxmxDTO> pcmydtxmxdtos) {
        pcmydtxmxService.updateBatch(pcmydtxmxMapping.toDomain(pcmydtxmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdtxmx-FillPersonInfo-all')")
    @ApiOperation(value = "填充人员信息", tags = {"异动退休明细" },  notes = "填充人员信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydtxmxes/{pcmydtxmx_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PcmYdtxmxDTO> fillPersonInfo(@PathVariable("pcmydtxmx_id") String pcmydtxmx_id, @RequestBody PcmYdtxmxDTO pcmydtxmxdto) {
        PcmYdtxmx pcmydtxmx = pcmydtxmxMapping.toDomain(pcmydtxmxdto);
        pcmydtxmx.setPcmydtxmxid(pcmydtxmx_id);
        pcmydtxmx = pcmydtxmxService.fillPersonInfo(pcmydtxmx);
        pcmydtxmxdto = pcmydtxmxMapping.toDto(pcmydtxmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydtxmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdtxmx-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"异动退休明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydtxmxes/fetchdefault")
	public ResponseEntity<List<PcmYdtxmxDTO>> fetchDefault(PcmYdtxmxSearchContext context) {
        Page<PcmYdtxmx> domains = pcmydtxmxService.searchDefault(context) ;
        List<PcmYdtxmxDTO> list = pcmydtxmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdtxmx-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"异动退休明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydtxmxes/searchdefault")
	public ResponseEntity<Page<PcmYdtxmxDTO>> searchDefault(@RequestBody PcmYdtxmxSearchContext context) {
        Page<PcmYdtxmx> domains = pcmydtxmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydtxmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdtxmx-GLDS-all')")
	@ApiOperation(value = "获取管理查询", tags = {"异动退休明细" } ,notes = "获取管理查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydtxmxes/fetchglds")
	public ResponseEntity<List<PcmYdtxmxDTO>> fetchGLDS(PcmYdtxmxSearchContext context) {
        Page<PcmYdtxmx> domains = pcmydtxmxService.searchGLDS(context) ;
        List<PcmYdtxmxDTO> list = pcmydtxmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdtxmx-GLDS-all')")
	@ApiOperation(value = "查询管理查询", tags = {"异动退休明细" } ,notes = "查询管理查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydtxmxes/searchglds")
	public ResponseEntity<Page<PcmYdtxmxDTO>> searchGLDS(@RequestBody PcmYdtxmxSearchContext context) {
        Page<PcmYdtxmx> domains = pcmydtxmxService.searchGLDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydtxmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdtxmx-JLDS-all')")
	@ApiOperation(value = "获取记录查询", tags = {"异动退休明细" } ,notes = "获取记录查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydtxmxes/fetchjlds")
	public ResponseEntity<List<PcmYdtxmxDTO>> fetchJLDS(PcmYdtxmxSearchContext context) {
        Page<PcmYdtxmx> domains = pcmydtxmxService.searchJLDS(context) ;
        List<PcmYdtxmxDTO> list = pcmydtxmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdtxmx-JLDS-all')")
	@ApiOperation(value = "查询记录查询", tags = {"异动退休明细" } ,notes = "查询记录查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydtxmxes/searchjlds")
	public ResponseEntity<Page<PcmYdtxmxDTO>> searchJLDS(@RequestBody PcmYdtxmxSearchContext context) {
        Page<PcmYdtxmx> domains = pcmydtxmxService.searchJLDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydtxmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

