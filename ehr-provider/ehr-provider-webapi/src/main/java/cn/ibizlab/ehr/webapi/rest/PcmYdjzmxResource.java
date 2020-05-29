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
import cn.ibizlab.ehr.core.pcm.domain.PcmYdjzmx;
import cn.ibizlab.ehr.core.pcm.service.IPcmYdjzmxService;
import cn.ibizlab.ehr.core.pcm.filter.PcmYdjzmxSearchContext;

@Slf4j
@Api(tags = {"异动兼职明细" })
@RestController("WebApi-pcmydjzmx")
@RequestMapping("")
public class PcmYdjzmxResource {

    @Autowired
    public IPcmYdjzmxService pcmydjzmxService;

    @Autowired
    @Lazy
    public PcmYdjzmxMapping pcmydjzmxMapping;

    @ApiOperation(value = "获取异动兼职明细草稿", tags = {"异动兼职明细" },  notes = "获取异动兼职明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydjzmxes/getdraft")
    public ResponseEntity<PcmYdjzmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjzmxMapping.toDto(pcmydjzmxService.getDraft(new PcmYdjzmx())));
    }

    @PreAuthorize("hasPermission(this.pcmydjzmxMapping.toDomain(#pcmydjzmxdto),'ehr-PcmYdjzmx-Save')")
    @ApiOperation(value = "保存异动兼职明细", tags = {"异动兼职明细" },  notes = "保存异动兼职明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjzmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmYdjzmxDTO pcmydjzmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjzmxService.save(pcmydjzmxMapping.toDomain(pcmydjzmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmydjzmxMapping.toDomain(#pcmydjzmxdtos),'ehr-PcmYdjzmx-Save')")
    @ApiOperation(value = "批量保存异动兼职明细", tags = {"异动兼职明细" },  notes = "批量保存异动兼职明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjzmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmYdjzmxDTO> pcmydjzmxdtos) {
        pcmydjzmxService.saveBatch(pcmydjzmxMapping.toDomain(pcmydjzmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjzmx-RYHG-all')")
    @ApiOperation(value = "人员回归", tags = {"异动兼职明细" },  notes = "人员回归")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjzmxes/{pcmydjzmx_id}/ryhg")
    @Transactional
    public ResponseEntity<PcmYdjzmxDTO> rYHG(@PathVariable("pcmydjzmx_id") String pcmydjzmx_id, @RequestBody PcmYdjzmxDTO pcmydjzmxdto) {
        PcmYdjzmx pcmydjzmx = pcmydjzmxMapping.toDomain(pcmydjzmxdto);
        pcmydjzmx.setPcmydjzmxid(pcmydjzmx_id);
        pcmydjzmx = pcmydjzmxService.rYHG(pcmydjzmx);
        pcmydjzmxdto = pcmydjzmxMapping.toDto(pcmydjzmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjzmxdto);
    }

    @PostAuthorize("hasPermission(this.pcmydjzmxMapping.toDomain(returnObject.body),'ehr-PcmYdjzmx-Get')")
    @ApiOperation(value = "获取异动兼职明细", tags = {"异动兼职明细" },  notes = "获取异动兼职明细")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydjzmxes/{pcmydjzmx_id}")
    public ResponseEntity<PcmYdjzmxDTO> get(@PathVariable("pcmydjzmx_id") String pcmydjzmx_id) {
        PcmYdjzmx domain = pcmydjzmxService.get(pcmydjzmx_id);
        PcmYdjzmxDTO dto = pcmydjzmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydjzmxService.get(#pcmydjzmx_id),'ehr-PcmYdjzmx-Update')")
    @ApiOperation(value = "更新异动兼职明细", tags = {"异动兼职明细" },  notes = "更新异动兼职明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydjzmxes/{pcmydjzmx_id}")
    @Transactional
    public ResponseEntity<PcmYdjzmxDTO> update(@PathVariable("pcmydjzmx_id") String pcmydjzmx_id, @RequestBody PcmYdjzmxDTO pcmydjzmxdto) {
		PcmYdjzmx domain  = pcmydjzmxMapping.toDomain(pcmydjzmxdto);
        domain .setPcmydjzmxid(pcmydjzmx_id);
		pcmydjzmxService.update(domain );
		PcmYdjzmxDTO dto = pcmydjzmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydjzmxService.getPcmydjzmxByEntities(this.pcmydjzmxMapping.toDomain(#pcmydjzmxdtos)),'ehr-PcmYdjzmx-Update')")
    @ApiOperation(value = "批量更新异动兼职明细", tags = {"异动兼职明细" },  notes = "批量更新异动兼职明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydjzmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmYdjzmxDTO> pcmydjzmxdtos) {
        pcmydjzmxService.updateBatch(pcmydjzmxMapping.toDomain(pcmydjzmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydjzmxService.get(#pcmydjzmx_id),'ehr-PcmYdjzmx-Remove')")
    @ApiOperation(value = "删除异动兼职明细", tags = {"异动兼职明细" },  notes = "删除异动兼职明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydjzmxes/{pcmydjzmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmydjzmx_id") String pcmydjzmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmydjzmxService.remove(pcmydjzmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmydjzmxService.getPcmydjzmxByIds(#ids),'ehr-PcmYdjzmx-Remove')")
    @ApiOperation(value = "批量删除异动兼职明细", tags = {"异动兼职明细" },  notes = "批量删除异动兼职明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydjzmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmydjzmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjzmx-FillPersonInfo-all')")
    @ApiOperation(value = "填充员工信息", tags = {"异动兼职明细" },  notes = "填充员工信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjzmxes/{pcmydjzmx_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PcmYdjzmxDTO> fillPersonInfo(@PathVariable("pcmydjzmx_id") String pcmydjzmx_id, @RequestBody PcmYdjzmxDTO pcmydjzmxdto) {
        PcmYdjzmx pcmydjzmx = pcmydjzmxMapping.toDomain(pcmydjzmxdto);
        pcmydjzmx.setPcmydjzmxid(pcmydjzmx_id);
        pcmydjzmx = pcmydjzmxService.fillPersonInfo(pcmydjzmx);
        pcmydjzmxdto = pcmydjzmxMapping.toDto(pcmydjzmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjzmxdto);
    }

    @ApiOperation(value = "检查异动兼职明细", tags = {"异动兼职明细" },  notes = "检查异动兼职明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjzmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmYdjzmxDTO pcmydjzmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmydjzmxService.checkKey(pcmydjzmxMapping.toDomain(pcmydjzmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmydjzmxMapping.toDomain(#pcmydjzmxdto),'ehr-PcmYdjzmx-Create')")
    @ApiOperation(value = "新建异动兼职明细", tags = {"异动兼职明细" },  notes = "新建异动兼职明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjzmxes")
    @Transactional
    public ResponseEntity<PcmYdjzmxDTO> create(@RequestBody PcmYdjzmxDTO pcmydjzmxdto) {
        PcmYdjzmx domain = pcmydjzmxMapping.toDomain(pcmydjzmxdto);
		pcmydjzmxService.create(domain);
        PcmYdjzmxDTO dto = pcmydjzmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydjzmxMapping.toDomain(#pcmydjzmxdtos),'ehr-PcmYdjzmx-Create')")
    @ApiOperation(value = "批量新建异动兼职明细", tags = {"异动兼职明细" },  notes = "批量新建异动兼职明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjzmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmYdjzmxDTO> pcmydjzmxdtos) {
        pcmydjzmxService.createBatch(pcmydjzmxMapping.toDomain(pcmydjzmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjzmx-GLDS-all')")
	@ApiOperation(value = "获取管理查询", tags = {"异动兼职明细" } ,notes = "获取管理查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydjzmxes/fetchglds")
	public ResponseEntity<List<PcmYdjzmxDTO>> fetchGLDS(PcmYdjzmxSearchContext context) {
        Page<PcmYdjzmx> domains = pcmydjzmxService.searchGLDS(context) ;
        List<PcmYdjzmxDTO> list = pcmydjzmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjzmx-GLDS-all')")
	@ApiOperation(value = "查询管理查询", tags = {"异动兼职明细" } ,notes = "查询管理查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydjzmxes/searchglds")
	public ResponseEntity<Page<PcmYdjzmxDTO>> searchGLDS(@RequestBody PcmYdjzmxSearchContext context) {
        Page<PcmYdjzmx> domains = pcmydjzmxService.searchGLDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjzmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjzmx-LSJLDS-all')")
	@ApiOperation(value = "获取历史记录查看", tags = {"异动兼职明细" } ,notes = "获取历史记录查看")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydjzmxes/fetchlsjlds")
	public ResponseEntity<List<PcmYdjzmxDTO>> fetchLSJLDS(PcmYdjzmxSearchContext context) {
        Page<PcmYdjzmx> domains = pcmydjzmxService.searchLSJLDS(context) ;
        List<PcmYdjzmxDTO> list = pcmydjzmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjzmx-LSJLDS-all')")
	@ApiOperation(value = "查询历史记录查看", tags = {"异动兼职明细" } ,notes = "查询历史记录查看")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydjzmxes/searchlsjlds")
	public ResponseEntity<Page<PcmYdjzmxDTO>> searchLSJLDS(@RequestBody PcmYdjzmxSearchContext context) {
        Page<PcmYdjzmx> domains = pcmydjzmxService.searchLSJLDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjzmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjzmx-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"异动兼职明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydjzmxes/fetchdefault")
	public ResponseEntity<List<PcmYdjzmxDTO>> fetchDefault(PcmYdjzmxSearchContext context) {
        Page<PcmYdjzmx> domains = pcmydjzmxService.searchDefault(context) ;
        List<PcmYdjzmxDTO> list = pcmydjzmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjzmx-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"异动兼职明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydjzmxes/searchdefault")
	public ResponseEntity<Page<PcmYdjzmxDTO>> searchDefault(@RequestBody PcmYdjzmxSearchContext context) {
        Page<PcmYdjzmx> domains = pcmydjzmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjzmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

