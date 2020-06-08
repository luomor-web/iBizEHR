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
import cn.ibizlab.ehr.core.pcm.domain.PcmYdgzmx;
import cn.ibizlab.ehr.core.pcm.service.IPcmYdgzmxService;
import cn.ibizlab.ehr.core.pcm.filter.PcmYdgzmxSearchContext;

@Slf4j
@Api(tags = {"异动挂职明细" })
@RestController("WebApi-pcmydgzmx")
@RequestMapping("")
public class PcmYdgzmxResource {

    @Autowired
    public IPcmYdgzmxService pcmydgzmxService;

    @Autowired
    @Lazy
    public PcmYdgzmxMapping pcmydgzmxMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdgzmx-RYHG-all')")
    @ApiOperation(value = "人员回归", tags = {"异动挂职明细" },  notes = "人员回归")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydgzmxes/{pcmydgzmx_id}/ryhg")
    @Transactional
    public ResponseEntity<PcmYdgzmxDTO> rYHG(@PathVariable("pcmydgzmx_id") String pcmydgzmx_id, @RequestBody PcmYdgzmxDTO pcmydgzmxdto) {
        PcmYdgzmx pcmydgzmx = pcmydgzmxMapping.toDomain(pcmydgzmxdto);
        pcmydgzmx.setPcmydgzmxid(pcmydgzmx_id);
        pcmydgzmx = pcmydgzmxService.rYHG(pcmydgzmx);
        pcmydgzmxdto = pcmydgzmxMapping.toDto(pcmydgzmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydgzmxdto);
    }

    @ApiOperation(value = "获取异动挂职明细草稿", tags = {"异动挂职明细" },  notes = "获取异动挂职明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydgzmxes/getdraft")
    public ResponseEntity<PcmYdgzmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydgzmxMapping.toDto(pcmydgzmxService.getDraft(new PcmYdgzmx())));
    }

    @PreAuthorize("hasPermission(this.pcmydgzmxService.get(#pcmydgzmx_id),'ehr-PcmYdgzmx-Update')")
    @ApiOperation(value = "更新异动挂职明细", tags = {"异动挂职明细" },  notes = "更新异动挂职明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydgzmxes/{pcmydgzmx_id}")
    @Transactional
    public ResponseEntity<PcmYdgzmxDTO> update(@PathVariable("pcmydgzmx_id") String pcmydgzmx_id, @RequestBody PcmYdgzmxDTO pcmydgzmxdto) {
		PcmYdgzmx domain  = pcmydgzmxMapping.toDomain(pcmydgzmxdto);
        domain .setPcmydgzmxid(pcmydgzmx_id);
		pcmydgzmxService.update(domain );
		PcmYdgzmxDTO dto = pcmydgzmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydgzmxService.getPcmydgzmxByEntities(this.pcmydgzmxMapping.toDomain(#pcmydgzmxdtos)),'ehr-PcmYdgzmx-Update')")
    @ApiOperation(value = "批量更新异动挂职明细", tags = {"异动挂职明细" },  notes = "批量更新异动挂职明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydgzmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmYdgzmxDTO> pcmydgzmxdtos) {
        pcmydgzmxService.updateBatch(pcmydgzmxMapping.toDomain(pcmydgzmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmydgzmxMapping.toDomain(returnObject.body),'ehr-PcmYdgzmx-Get')")
    @ApiOperation(value = "获取异动挂职明细", tags = {"异动挂职明细" },  notes = "获取异动挂职明细")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydgzmxes/{pcmydgzmx_id}")
    public ResponseEntity<PcmYdgzmxDTO> get(@PathVariable("pcmydgzmx_id") String pcmydgzmx_id) {
        PcmYdgzmx domain = pcmydgzmxService.get(pcmydgzmx_id);
        PcmYdgzmxDTO dto = pcmydgzmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdgzmx-FillPersonInfo-all')")
    @ApiOperation(value = "填充人员信息", tags = {"异动挂职明细" },  notes = "填充人员信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydgzmxes/{pcmydgzmx_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PcmYdgzmxDTO> fillPersonInfo(@PathVariable("pcmydgzmx_id") String pcmydgzmx_id, @RequestBody PcmYdgzmxDTO pcmydgzmxdto) {
        PcmYdgzmx pcmydgzmx = pcmydgzmxMapping.toDomain(pcmydgzmxdto);
        pcmydgzmx.setPcmydgzmxid(pcmydgzmx_id);
        pcmydgzmx = pcmydgzmxService.fillPersonInfo(pcmydgzmx);
        pcmydgzmxdto = pcmydgzmxMapping.toDto(pcmydgzmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydgzmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmydgzmxMapping.toDomain(#pcmydgzmxdto),'ehr-PcmYdgzmx-Create')")
    @ApiOperation(value = "新建异动挂职明细", tags = {"异动挂职明细" },  notes = "新建异动挂职明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydgzmxes")
    @Transactional
    public ResponseEntity<PcmYdgzmxDTO> create(@RequestBody PcmYdgzmxDTO pcmydgzmxdto) {
        PcmYdgzmx domain = pcmydgzmxMapping.toDomain(pcmydgzmxdto);
		pcmydgzmxService.create(domain);
        PcmYdgzmxDTO dto = pcmydgzmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydgzmxMapping.toDomain(#pcmydgzmxdtos),'ehr-PcmYdgzmx-Create')")
    @ApiOperation(value = "批量新建异动挂职明细", tags = {"异动挂职明细" },  notes = "批量新建异动挂职明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydgzmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmYdgzmxDTO> pcmydgzmxdtos) {
        pcmydgzmxService.createBatch(pcmydgzmxMapping.toDomain(pcmydgzmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydgzmxMapping.toDomain(#pcmydgzmxdto),'ehr-PcmYdgzmx-Save')")
    @ApiOperation(value = "保存异动挂职明细", tags = {"异动挂职明细" },  notes = "保存异动挂职明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydgzmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmYdgzmxDTO pcmydgzmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydgzmxService.save(pcmydgzmxMapping.toDomain(pcmydgzmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmydgzmxMapping.toDomain(#pcmydgzmxdtos),'ehr-PcmYdgzmx-Save')")
    @ApiOperation(value = "批量保存异动挂职明细", tags = {"异动挂职明细" },  notes = "批量保存异动挂职明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydgzmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmYdgzmxDTO> pcmydgzmxdtos) {
        pcmydgzmxService.saveBatch(pcmydgzmxMapping.toDomain(pcmydgzmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查异动挂职明细", tags = {"异动挂职明细" },  notes = "检查异动挂职明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydgzmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmYdgzmxDTO pcmydgzmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmydgzmxService.checkKey(pcmydgzmxMapping.toDomain(pcmydgzmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmydgzmxService.get(#pcmydgzmx_id),'ehr-PcmYdgzmx-Remove')")
    @ApiOperation(value = "删除异动挂职明细", tags = {"异动挂职明细" },  notes = "删除异动挂职明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydgzmxes/{pcmydgzmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmydgzmx_id") String pcmydgzmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmydgzmxService.remove(pcmydgzmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmydgzmxService.getPcmydgzmxByIds(#ids),'ehr-PcmYdgzmx-Remove')")
    @ApiOperation(value = "批量删除异动挂职明细", tags = {"异动挂职明细" },  notes = "批量删除异动挂职明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydgzmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmydgzmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdgzmx-GZCRYDQ-all')")
	@ApiOperation(value = "获取挂职出人员查询", tags = {"异动挂职明细" } ,notes = "获取挂职出人员查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydgzmxes/fetchgzcrydq")
	public ResponseEntity<List<PcmYdgzmxDTO>> fetchGZCRYDQ(PcmYdgzmxSearchContext context) {
        Page<PcmYdgzmx> domains = pcmydgzmxService.searchGZCRYDQ(context) ;
        List<PcmYdgzmxDTO> list = pcmydgzmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdgzmx-GZCRYDQ-all')")
	@ApiOperation(value = "查询挂职出人员查询", tags = {"异动挂职明细" } ,notes = "查询挂职出人员查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydgzmxes/searchgzcrydq")
	public ResponseEntity<Page<PcmYdgzmxDTO>> searchGZCRYDQ(@RequestBody PcmYdgzmxSearchContext context) {
        Page<PcmYdgzmx> domains = pcmydgzmxService.searchGZCRYDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydgzmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdgzmx-GZJLSJLDQ-all')")
	@ApiOperation(value = "获取挂职进历史记录查询", tags = {"异动挂职明细" } ,notes = "获取挂职进历史记录查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydgzmxes/fetchgzjlsjldq")
	public ResponseEntity<List<PcmYdgzmxDTO>> fetchGZJLSJLDQ(PcmYdgzmxSearchContext context) {
        Page<PcmYdgzmx> domains = pcmydgzmxService.searchGZJLSJLDQ(context) ;
        List<PcmYdgzmxDTO> list = pcmydgzmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdgzmx-GZJLSJLDQ-all')")
	@ApiOperation(value = "查询挂职进历史记录查询", tags = {"异动挂职明细" } ,notes = "查询挂职进历史记录查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydgzmxes/searchgzjlsjldq")
	public ResponseEntity<Page<PcmYdgzmxDTO>> searchGZJLSJLDQ(@RequestBody PcmYdgzmxSearchContext context) {
        Page<PcmYdgzmx> domains = pcmydgzmxService.searchGZJLSJLDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydgzmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdgzmx-GZJRY-all')")
	@ApiOperation(value = "获取挂职进人员", tags = {"异动挂职明细" } ,notes = "获取挂职进人员")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydgzmxes/fetchgzjry")
	public ResponseEntity<List<PcmYdgzmxDTO>> fetchGZJRY(PcmYdgzmxSearchContext context) {
        Page<PcmYdgzmx> domains = pcmydgzmxService.searchGZJRY(context) ;
        List<PcmYdgzmxDTO> list = pcmydgzmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdgzmx-GZJRY-all')")
	@ApiOperation(value = "查询挂职进人员", tags = {"异动挂职明细" } ,notes = "查询挂职进人员")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydgzmxes/searchgzjry")
	public ResponseEntity<Page<PcmYdgzmxDTO>> searchGZJRY(@RequestBody PcmYdgzmxSearchContext context) {
        Page<PcmYdgzmx> domains = pcmydgzmxService.searchGZJRY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydgzmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdgzmx-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"异动挂职明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydgzmxes/fetchdefault")
	public ResponseEntity<List<PcmYdgzmxDTO>> fetchDefault(PcmYdgzmxSearchContext context) {
        Page<PcmYdgzmx> domains = pcmydgzmxService.searchDefault(context) ;
        List<PcmYdgzmxDTO> list = pcmydgzmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdgzmx-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"异动挂职明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydgzmxes/searchdefault")
	public ResponseEntity<Page<PcmYdgzmxDTO>> searchDefault(@RequestBody PcmYdgzmxSearchContext context) {
        Page<PcmYdgzmx> domains = pcmydgzmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydgzmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdgzmx-GZCLSJLDQ-all')")
	@ApiOperation(value = "获取挂职出历史记录查询", tags = {"异动挂职明细" } ,notes = "获取挂职出历史记录查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydgzmxes/fetchgzclsjldq")
	public ResponseEntity<List<PcmYdgzmxDTO>> fetchGZCLSJLDQ(PcmYdgzmxSearchContext context) {
        Page<PcmYdgzmx> domains = pcmydgzmxService.searchGZCLSJLDQ(context) ;
        List<PcmYdgzmxDTO> list = pcmydgzmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdgzmx-GZCLSJLDQ-all')")
	@ApiOperation(value = "查询挂职出历史记录查询", tags = {"异动挂职明细" } ,notes = "查询挂职出历史记录查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydgzmxes/searchgzclsjldq")
	public ResponseEntity<Page<PcmYdgzmxDTO>> searchGZCLSJLDQ(@RequestBody PcmYdgzmxSearchContext context) {
        Page<PcmYdgzmx> domains = pcmydgzmxService.searchGZCLSJLDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydgzmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

