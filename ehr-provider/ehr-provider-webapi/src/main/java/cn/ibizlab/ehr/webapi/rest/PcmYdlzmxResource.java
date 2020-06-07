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
import cn.ibizlab.ehr.core.pcm.domain.PcmYdlzmx;
import cn.ibizlab.ehr.core.pcm.service.IPcmYdlzmxService;
import cn.ibizlab.ehr.core.pcm.filter.PcmYdlzmxSearchContext;

@Slf4j
@Api(tags = {"异动离职明细" })
@RestController("WebApi-pcmydlzmx")
@RequestMapping("")
public class PcmYdlzmxResource {

    @Autowired
    public IPcmYdlzmxService pcmydlzmxService;

    @Autowired
    @Lazy
    public PcmYdlzmxMapping pcmydlzmxMapping;

    @PreAuthorize("hasPermission(this.pcmydlzmxService.get(#pcmydlzmx_id),'ehr-PcmYdlzmx-Update')")
    @ApiOperation(value = "更新异动离职明细", tags = {"异动离职明细" },  notes = "更新异动离职明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydlzmxes/{pcmydlzmx_id}")
    @Transactional
    public ResponseEntity<PcmYdlzmxDTO> update(@PathVariable("pcmydlzmx_id") String pcmydlzmx_id, @RequestBody PcmYdlzmxDTO pcmydlzmxdto) {
		PcmYdlzmx domain  = pcmydlzmxMapping.toDomain(pcmydlzmxdto);
        domain .setPcmydlzmxid(pcmydlzmx_id);
		pcmydlzmxService.update(domain );
		PcmYdlzmxDTO dto = pcmydlzmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydlzmxService.getPcmydlzmxByEntities(this.pcmydlzmxMapping.toDomain(#pcmydlzmxdtos)),'ehr-PcmYdlzmx-Update')")
    @ApiOperation(value = "批量更新异动离职明细", tags = {"异动离职明细" },  notes = "批量更新异动离职明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydlzmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmYdlzmxDTO> pcmydlzmxdtos) {
        pcmydlzmxService.updateBatch(pcmydlzmxMapping.toDomain(pcmydlzmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdlzmx-IsFinished-all')")
    @ApiOperation(value = "是否完成离职操作", tags = {"异动离职明细" },  notes = "是否完成离职操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydlzmxes/{pcmydlzmx_id}/isfinished")
    @Transactional
    public ResponseEntity<PcmYdlzmxDTO> isFinished(@PathVariable("pcmydlzmx_id") String pcmydlzmx_id, @RequestBody PcmYdlzmxDTO pcmydlzmxdto) {
        PcmYdlzmx pcmydlzmx = pcmydlzmxMapping.toDomain(pcmydlzmxdto);
        pcmydlzmx.setPcmydlzmxid(pcmydlzmx_id);
        pcmydlzmx = pcmydlzmxService.isFinished(pcmydlzmx);
        pcmydlzmxdto = pcmydlzmxMapping.toDto(pcmydlzmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydlzmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdlzmx-FillPersonInfo-all')")
    @ApiOperation(value = "填充人员信息", tags = {"异动离职明细" },  notes = "填充人员信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydlzmxes/{pcmydlzmx_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PcmYdlzmxDTO> fillPersonInfo(@PathVariable("pcmydlzmx_id") String pcmydlzmx_id, @RequestBody PcmYdlzmxDTO pcmydlzmxdto) {
        PcmYdlzmx pcmydlzmx = pcmydlzmxMapping.toDomain(pcmydlzmxdto);
        pcmydlzmx.setPcmydlzmxid(pcmydlzmx_id);
        pcmydlzmx = pcmydlzmxService.fillPersonInfo(pcmydlzmx);
        pcmydlzmxdto = pcmydlzmxMapping.toDto(pcmydlzmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydlzmxdto);
    }

    @PostAuthorize("hasPermission(this.pcmydlzmxMapping.toDomain(returnObject.body),'ehr-PcmYdlzmx-Get')")
    @ApiOperation(value = "获取异动离职明细", tags = {"异动离职明细" },  notes = "获取异动离职明细")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydlzmxes/{pcmydlzmx_id}")
    public ResponseEntity<PcmYdlzmxDTO> get(@PathVariable("pcmydlzmx_id") String pcmydlzmx_id) {
        PcmYdlzmx domain = pcmydlzmxService.get(pcmydlzmx_id);
        PcmYdlzmxDTO dto = pcmydlzmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydlzmxMapping.toDomain(#pcmydlzmxdto),'ehr-PcmYdlzmx-Create')")
    @ApiOperation(value = "新建异动离职明细", tags = {"异动离职明细" },  notes = "新建异动离职明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydlzmxes")
    @Transactional
    public ResponseEntity<PcmYdlzmxDTO> create(@RequestBody PcmYdlzmxDTO pcmydlzmxdto) {
        PcmYdlzmx domain = pcmydlzmxMapping.toDomain(pcmydlzmxdto);
		pcmydlzmxService.create(domain);
        PcmYdlzmxDTO dto = pcmydlzmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydlzmxMapping.toDomain(#pcmydlzmxdtos),'ehr-PcmYdlzmx-Create')")
    @ApiOperation(value = "批量新建异动离职明细", tags = {"异动离职明细" },  notes = "批量新建异动离职明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydlzmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmYdlzmxDTO> pcmydlzmxdtos) {
        pcmydlzmxService.createBatch(pcmydlzmxMapping.toDomain(pcmydlzmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查异动离职明细", tags = {"异动离职明细" },  notes = "检查异动离职明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydlzmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmYdlzmxDTO pcmydlzmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmydlzmxService.checkKey(pcmydlzmxMapping.toDomain(pcmydlzmxdto)));
    }

    @ApiOperation(value = "获取异动离职明细草稿", tags = {"异动离职明细" },  notes = "获取异动离职明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydlzmxes/getdraft")
    public ResponseEntity<PcmYdlzmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydlzmxMapping.toDto(pcmydlzmxService.getDraft(new PcmYdlzmx())));
    }

    @PreAuthorize("hasPermission(this.pcmydlzmxMapping.toDomain(#pcmydlzmxdto),'ehr-PcmYdlzmx-Save')")
    @ApiOperation(value = "保存异动离职明细", tags = {"异动离职明细" },  notes = "保存异动离职明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydlzmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmYdlzmxDTO pcmydlzmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydlzmxService.save(pcmydlzmxMapping.toDomain(pcmydlzmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmydlzmxMapping.toDomain(#pcmydlzmxdtos),'ehr-PcmYdlzmx-Save')")
    @ApiOperation(value = "批量保存异动离职明细", tags = {"异动离职明细" },  notes = "批量保存异动离职明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydlzmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmYdlzmxDTO> pcmydlzmxdtos) {
        pcmydlzmxService.saveBatch(pcmydlzmxMapping.toDomain(pcmydlzmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydlzmxService.get(#pcmydlzmx_id),'ehr-PcmYdlzmx-Remove')")
    @ApiOperation(value = "删除异动离职明细", tags = {"异动离职明细" },  notes = "删除异动离职明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydlzmxes/{pcmydlzmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmydlzmx_id") String pcmydlzmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmydlzmxService.remove(pcmydlzmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmydlzmxService.getPcmydlzmxByIds(#ids),'ehr-PcmYdlzmx-Remove')")
    @ApiOperation(value = "批量删除异动离职明细", tags = {"异动离职明细" },  notes = "批量删除异动离职明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydlzmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmydlzmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdlzmx-GLDQ-all')")
	@ApiOperation(value = "获取管理查询", tags = {"异动离职明细" } ,notes = "获取管理查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydlzmxes/fetchgldq")
	public ResponseEntity<List<PcmYdlzmxDTO>> fetchGLDQ(PcmYdlzmxSearchContext context) {
        Page<PcmYdlzmx> domains = pcmydlzmxService.searchGLDQ(context) ;
        List<PcmYdlzmxDTO> list = pcmydlzmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdlzmx-GLDQ-all')")
	@ApiOperation(value = "查询管理查询", tags = {"异动离职明细" } ,notes = "查询管理查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydlzmxes/searchgldq")
	public ResponseEntity<Page<PcmYdlzmxDTO>> searchGLDQ(@RequestBody PcmYdlzmxSearchContext context) {
        Page<PcmYdlzmx> domains = pcmydlzmxService.searchGLDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydlzmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdlzmx-JLDQ-all')")
	@ApiOperation(value = "获取记录查询", tags = {"异动离职明细" } ,notes = "获取记录查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydlzmxes/fetchjldq")
	public ResponseEntity<List<PcmYdlzmxDTO>> fetchJLDQ(PcmYdlzmxSearchContext context) {
        Page<PcmYdlzmx> domains = pcmydlzmxService.searchJLDQ(context) ;
        List<PcmYdlzmxDTO> list = pcmydlzmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdlzmx-JLDQ-all')")
	@ApiOperation(value = "查询记录查询", tags = {"异动离职明细" } ,notes = "查询记录查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydlzmxes/searchjldq")
	public ResponseEntity<Page<PcmYdlzmxDTO>> searchJLDQ(@RequestBody PcmYdlzmxSearchContext context) {
        Page<PcmYdlzmx> domains = pcmydlzmxService.searchJLDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydlzmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdlzmx-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"异动离职明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydlzmxes/fetchdefault")
	public ResponseEntity<List<PcmYdlzmxDTO>> fetchDefault(PcmYdlzmxSearchContext context) {
        Page<PcmYdlzmx> domains = pcmydlzmxService.searchDefault(context) ;
        List<PcmYdlzmxDTO> list = pcmydlzmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdlzmx-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"异动离职明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydlzmxes/searchdefault")
	public ResponseEntity<Page<PcmYdlzmxDTO>> searchDefault(@RequestBody PcmYdlzmxSearchContext context) {
        Page<PcmYdlzmx> domains = pcmydlzmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydlzmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

