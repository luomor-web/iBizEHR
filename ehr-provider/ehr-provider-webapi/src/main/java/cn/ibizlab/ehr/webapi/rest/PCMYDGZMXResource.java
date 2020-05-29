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
import cn.ibizlab.ehr.core.pcm.domain.PCMYDGZMX;
import cn.ibizlab.ehr.core.pcm.service.IPCMYDGZMXService;
import cn.ibizlab.ehr.core.pcm.filter.PCMYDGZMXSearchContext;

@Slf4j
@Api(tags = {"异动挂职明细" })
@RestController("WebApi-pcmydgzmx")
@RequestMapping("")
public class PCMYDGZMXResource {

    @Autowired
    public IPCMYDGZMXService pcmydgzmxService;

    @Autowired
    @Lazy
    public PCMYDGZMXMapping pcmydgzmxMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDGZMX-RYHG-all')")
    @ApiOperation(value = "人员回归", tags = {"异动挂职明细" },  notes = "人员回归")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydgzmxes/{pcmydgzmx_id}/ryhg")
    @Transactional
    public ResponseEntity<PCMYDGZMXDTO> rYHG(@PathVariable("pcmydgzmx_id") String pcmydgzmx_id, @RequestBody PCMYDGZMXDTO pcmydgzmxdto) {
        PCMYDGZMX pcmydgzmx = pcmydgzmxMapping.toDomain(pcmydgzmxdto);
        pcmydgzmx.setPcmydgzmxid(pcmydgzmx_id);
        pcmydgzmx = pcmydgzmxService.rYHG(pcmydgzmx);
        pcmydgzmxdto = pcmydgzmxMapping.toDto(pcmydgzmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydgzmxdto);
    }

    @ApiOperation(value = "获取异动挂职明细草稿", tags = {"异动挂职明细" },  notes = "获取异动挂职明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydgzmxes/getdraft")
    public ResponseEntity<PCMYDGZMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydgzmxMapping.toDto(pcmydgzmxService.getDraft(new PCMYDGZMX())));
    }

    @PreAuthorize("hasPermission(this.pcmydgzmxService.get(#pcmydgzmx_id),'ehr-PCMYDGZMX-Update')")
    @ApiOperation(value = "更新异动挂职明细", tags = {"异动挂职明细" },  notes = "更新异动挂职明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydgzmxes/{pcmydgzmx_id}")
    @Transactional
    public ResponseEntity<PCMYDGZMXDTO> update(@PathVariable("pcmydgzmx_id") String pcmydgzmx_id, @RequestBody PCMYDGZMXDTO pcmydgzmxdto) {
		PCMYDGZMX domain  = pcmydgzmxMapping.toDomain(pcmydgzmxdto);
        domain .setPcmydgzmxid(pcmydgzmx_id);
		pcmydgzmxService.update(domain );
		PCMYDGZMXDTO dto = pcmydgzmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydgzmxService.getPcmydgzmxByEntities(this.pcmydgzmxMapping.toDomain(#pcmydgzmxdtos)),'ehr-PCMYDGZMX-Update')")
    @ApiOperation(value = "批量更新异动挂职明细", tags = {"异动挂职明细" },  notes = "批量更新异动挂职明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydgzmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMYDGZMXDTO> pcmydgzmxdtos) {
        pcmydgzmxService.updateBatch(pcmydgzmxMapping.toDomain(pcmydgzmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmydgzmxMapping.toDomain(returnObject.body),'ehr-PCMYDGZMX-Get')")
    @ApiOperation(value = "获取异动挂职明细", tags = {"异动挂职明细" },  notes = "获取异动挂职明细")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydgzmxes/{pcmydgzmx_id}")
    public ResponseEntity<PCMYDGZMXDTO> get(@PathVariable("pcmydgzmx_id") String pcmydgzmx_id) {
        PCMYDGZMX domain = pcmydgzmxService.get(pcmydgzmx_id);
        PCMYDGZMXDTO dto = pcmydgzmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDGZMX-FillPersonInfo-all')")
    @ApiOperation(value = "填充人员信息", tags = {"异动挂职明细" },  notes = "填充人员信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydgzmxes/{pcmydgzmx_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PCMYDGZMXDTO> fillPersonInfo(@PathVariable("pcmydgzmx_id") String pcmydgzmx_id, @RequestBody PCMYDGZMXDTO pcmydgzmxdto) {
        PCMYDGZMX pcmydgzmx = pcmydgzmxMapping.toDomain(pcmydgzmxdto);
        pcmydgzmx.setPcmydgzmxid(pcmydgzmx_id);
        pcmydgzmx = pcmydgzmxService.fillPersonInfo(pcmydgzmx);
        pcmydgzmxdto = pcmydgzmxMapping.toDto(pcmydgzmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydgzmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmydgzmxMapping.toDomain(#pcmydgzmxdto),'ehr-PCMYDGZMX-Create')")
    @ApiOperation(value = "新建异动挂职明细", tags = {"异动挂职明细" },  notes = "新建异动挂职明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydgzmxes")
    @Transactional
    public ResponseEntity<PCMYDGZMXDTO> create(@RequestBody PCMYDGZMXDTO pcmydgzmxdto) {
        PCMYDGZMX domain = pcmydgzmxMapping.toDomain(pcmydgzmxdto);
		pcmydgzmxService.create(domain);
        PCMYDGZMXDTO dto = pcmydgzmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydgzmxMapping.toDomain(#pcmydgzmxdtos),'ehr-PCMYDGZMX-Create')")
    @ApiOperation(value = "批量新建异动挂职明细", tags = {"异动挂职明细" },  notes = "批量新建异动挂职明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydgzmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMYDGZMXDTO> pcmydgzmxdtos) {
        pcmydgzmxService.createBatch(pcmydgzmxMapping.toDomain(pcmydgzmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydgzmxMapping.toDomain(#pcmydgzmxdto),'ehr-PCMYDGZMX-Save')")
    @ApiOperation(value = "保存异动挂职明细", tags = {"异动挂职明细" },  notes = "保存异动挂职明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydgzmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMYDGZMXDTO pcmydgzmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydgzmxService.save(pcmydgzmxMapping.toDomain(pcmydgzmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmydgzmxMapping.toDomain(#pcmydgzmxdtos),'ehr-PCMYDGZMX-Save')")
    @ApiOperation(value = "批量保存异动挂职明细", tags = {"异动挂职明细" },  notes = "批量保存异动挂职明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydgzmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMYDGZMXDTO> pcmydgzmxdtos) {
        pcmydgzmxService.saveBatch(pcmydgzmxMapping.toDomain(pcmydgzmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查异动挂职明细", tags = {"异动挂职明细" },  notes = "检查异动挂职明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydgzmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMYDGZMXDTO pcmydgzmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmydgzmxService.checkKey(pcmydgzmxMapping.toDomain(pcmydgzmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmydgzmxService.get(#pcmydgzmx_id),'ehr-PCMYDGZMX-Remove')")
    @ApiOperation(value = "删除异动挂职明细", tags = {"异动挂职明细" },  notes = "删除异动挂职明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydgzmxes/{pcmydgzmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmydgzmx_id") String pcmydgzmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmydgzmxService.remove(pcmydgzmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmydgzmxService.getPcmydgzmxByIds(#ids),'ehr-PCMYDGZMX-Remove')")
    @ApiOperation(value = "批量删除异动挂职明细", tags = {"异动挂职明细" },  notes = "批量删除异动挂职明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydgzmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmydgzmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDGZMX-GZCRYDQ-all')")
	@ApiOperation(value = "获取挂职出人员查询", tags = {"异动挂职明细" } ,notes = "获取挂职出人员查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydgzmxes/fetchgzcrydq")
	public ResponseEntity<List<PCMYDGZMXDTO>> fetchGZCRYDQ(PCMYDGZMXSearchContext context) {
        Page<PCMYDGZMX> domains = pcmydgzmxService.searchGZCRYDQ(context) ;
        List<PCMYDGZMXDTO> list = pcmydgzmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDGZMX-GZCRYDQ-all')")
	@ApiOperation(value = "查询挂职出人员查询", tags = {"异动挂职明细" } ,notes = "查询挂职出人员查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydgzmxes/searchgzcrydq")
	public ResponseEntity<Page<PCMYDGZMXDTO>> searchGZCRYDQ(@RequestBody PCMYDGZMXSearchContext context) {
        Page<PCMYDGZMX> domains = pcmydgzmxService.searchGZCRYDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydgzmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDGZMX-GZJLSJLDQ-all')")
	@ApiOperation(value = "获取挂职进历史记录查询", tags = {"异动挂职明细" } ,notes = "获取挂职进历史记录查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydgzmxes/fetchgzjlsjldq")
	public ResponseEntity<List<PCMYDGZMXDTO>> fetchGZJLSJLDQ(PCMYDGZMXSearchContext context) {
        Page<PCMYDGZMX> domains = pcmydgzmxService.searchGZJLSJLDQ(context) ;
        List<PCMYDGZMXDTO> list = pcmydgzmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDGZMX-GZJLSJLDQ-all')")
	@ApiOperation(value = "查询挂职进历史记录查询", tags = {"异动挂职明细" } ,notes = "查询挂职进历史记录查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydgzmxes/searchgzjlsjldq")
	public ResponseEntity<Page<PCMYDGZMXDTO>> searchGZJLSJLDQ(@RequestBody PCMYDGZMXSearchContext context) {
        Page<PCMYDGZMX> domains = pcmydgzmxService.searchGZJLSJLDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydgzmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDGZMX-GZJRY-all')")
	@ApiOperation(value = "获取挂职进人员", tags = {"异动挂职明细" } ,notes = "获取挂职进人员")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydgzmxes/fetchgzjry")
	public ResponseEntity<List<PCMYDGZMXDTO>> fetchGZJRY(PCMYDGZMXSearchContext context) {
        Page<PCMYDGZMX> domains = pcmydgzmxService.searchGZJRY(context) ;
        List<PCMYDGZMXDTO> list = pcmydgzmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDGZMX-GZJRY-all')")
	@ApiOperation(value = "查询挂职进人员", tags = {"异动挂职明细" } ,notes = "查询挂职进人员")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydgzmxes/searchgzjry")
	public ResponseEntity<Page<PCMYDGZMXDTO>> searchGZJRY(@RequestBody PCMYDGZMXSearchContext context) {
        Page<PCMYDGZMX> domains = pcmydgzmxService.searchGZJRY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydgzmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDGZMX-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"异动挂职明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydgzmxes/fetchdefault")
	public ResponseEntity<List<PCMYDGZMXDTO>> fetchDefault(PCMYDGZMXSearchContext context) {
        Page<PCMYDGZMX> domains = pcmydgzmxService.searchDefault(context) ;
        List<PCMYDGZMXDTO> list = pcmydgzmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDGZMX-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"异动挂职明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydgzmxes/searchdefault")
	public ResponseEntity<Page<PCMYDGZMXDTO>> searchDefault(@RequestBody PCMYDGZMXSearchContext context) {
        Page<PCMYDGZMX> domains = pcmydgzmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydgzmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDGZMX-GZCLSJLDQ-all')")
	@ApiOperation(value = "获取挂职出历史记录查询", tags = {"异动挂职明细" } ,notes = "获取挂职出历史记录查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydgzmxes/fetchgzclsjldq")
	public ResponseEntity<List<PCMYDGZMXDTO>> fetchGZCLSJLDQ(PCMYDGZMXSearchContext context) {
        Page<PCMYDGZMX> domains = pcmydgzmxService.searchGZCLSJLDQ(context) ;
        List<PCMYDGZMXDTO> list = pcmydgzmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDGZMX-GZCLSJLDQ-all')")
	@ApiOperation(value = "查询挂职出历史记录查询", tags = {"异动挂职明细" } ,notes = "查询挂职出历史记录查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydgzmxes/searchgzclsjldq")
	public ResponseEntity<Page<PCMYDGZMXDTO>> searchGZCLSJLDQ(@RequestBody PCMYDGZMXSearchContext context) {
        Page<PCMYDGZMX> domains = pcmydgzmxService.searchGZCLSJLDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydgzmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

