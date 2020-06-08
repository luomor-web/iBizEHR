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
import cn.ibizlab.ehr.core.pcm.domain.PcmYdbxmx;
import cn.ibizlab.ehr.core.pcm.service.IPcmYdbxmxService;
import cn.ibizlab.ehr.core.pcm.filter.PcmYdbxmxSearchContext;

@Slf4j
@Api(tags = {"异动病休明细" })
@RestController("WebApi-pcmydbxmx")
@RequestMapping("")
public class PcmYdbxmxResource {

    @Autowired
    public IPcmYdbxmxService pcmydbxmxService;

    @Autowired
    @Lazy
    public PcmYdbxmxMapping pcmydbxmxMapping;

    @PostAuthorize("hasPermission(this.pcmydbxmxMapping.toDomain(returnObject.body),'ehr-PcmYdbxmx-Get')")
    @ApiOperation(value = "获取异动病休明细", tags = {"异动病休明细" },  notes = "获取异动病休明细")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydbxmxes/{pcmydbxmx_id}")
    public ResponseEntity<PcmYdbxmxDTO> get(@PathVariable("pcmydbxmx_id") String pcmydbxmx_id) {
        PcmYdbxmx domain = pcmydbxmxService.get(pcmydbxmx_id);
        PcmYdbxmxDTO dto = pcmydbxmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdbxmx-FillPersonInfo-all')")
    @ApiOperation(value = "填充人员信息", tags = {"异动病休明细" },  notes = "填充人员信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydbxmxes/{pcmydbxmx_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PcmYdbxmxDTO> fillPersonInfo(@PathVariable("pcmydbxmx_id") String pcmydbxmx_id, @RequestBody PcmYdbxmxDTO pcmydbxmxdto) {
        PcmYdbxmx pcmydbxmx = pcmydbxmxMapping.toDomain(pcmydbxmxdto);
        pcmydbxmx.setPcmydbxmxid(pcmydbxmx_id);
        pcmydbxmx = pcmydbxmxService.fillPersonInfo(pcmydbxmx);
        pcmydbxmxdto = pcmydbxmxMapping.toDto(pcmydbxmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydbxmxdto);
    }

    @ApiOperation(value = "获取异动病休明细草稿", tags = {"异动病休明细" },  notes = "获取异动病休明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydbxmxes/getdraft")
    public ResponseEntity<PcmYdbxmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydbxmxMapping.toDto(pcmydbxmxService.getDraft(new PcmYdbxmx())));
    }

    @PreAuthorize("hasPermission(this.pcmydbxmxService.get(#pcmydbxmx_id),'ehr-PcmYdbxmx-Update')")
    @ApiOperation(value = "更新异动病休明细", tags = {"异动病休明细" },  notes = "更新异动病休明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydbxmxes/{pcmydbxmx_id}")
    @Transactional
    public ResponseEntity<PcmYdbxmxDTO> update(@PathVariable("pcmydbxmx_id") String pcmydbxmx_id, @RequestBody PcmYdbxmxDTO pcmydbxmxdto) {
		PcmYdbxmx domain  = pcmydbxmxMapping.toDomain(pcmydbxmxdto);
        domain .setPcmydbxmxid(pcmydbxmx_id);
		pcmydbxmxService.update(domain );
		PcmYdbxmxDTO dto = pcmydbxmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydbxmxService.getPcmydbxmxByEntities(this.pcmydbxmxMapping.toDomain(#pcmydbxmxdtos)),'ehr-PcmYdbxmx-Update')")
    @ApiOperation(value = "批量更新异动病休明细", tags = {"异动病休明细" },  notes = "批量更新异动病休明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydbxmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmYdbxmxDTO> pcmydbxmxdtos) {
        pcmydbxmxService.updateBatch(pcmydbxmxMapping.toDomain(pcmydbxmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查异动病休明细", tags = {"异动病休明细" },  notes = "检查异动病休明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydbxmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmYdbxmxDTO pcmydbxmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmydbxmxService.checkKey(pcmydbxmxMapping.toDomain(pcmydbxmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmydbxmxMapping.toDomain(#pcmydbxmxdto),'ehr-PcmYdbxmx-Save')")
    @ApiOperation(value = "保存异动病休明细", tags = {"异动病休明细" },  notes = "保存异动病休明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydbxmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmYdbxmxDTO pcmydbxmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydbxmxService.save(pcmydbxmxMapping.toDomain(pcmydbxmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmydbxmxMapping.toDomain(#pcmydbxmxdtos),'ehr-PcmYdbxmx-Save')")
    @ApiOperation(value = "批量保存异动病休明细", tags = {"异动病休明细" },  notes = "批量保存异动病休明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydbxmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmYdbxmxDTO> pcmydbxmxdtos) {
        pcmydbxmxService.saveBatch(pcmydbxmxMapping.toDomain(pcmydbxmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdbxmx-FinishBX-all')")
    @ApiOperation(value = "结束病休", tags = {"异动病休明细" },  notes = "结束病休")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydbxmxes/{pcmydbxmx_id}/finishbx")
    @Transactional
    public ResponseEntity<PcmYdbxmxDTO> finishBX(@PathVariable("pcmydbxmx_id") String pcmydbxmx_id, @RequestBody PcmYdbxmxDTO pcmydbxmxdto) {
        PcmYdbxmx pcmydbxmx = pcmydbxmxMapping.toDomain(pcmydbxmxdto);
        pcmydbxmx.setPcmydbxmxid(pcmydbxmx_id);
        pcmydbxmx = pcmydbxmxService.finishBX(pcmydbxmx);
        pcmydbxmxdto = pcmydbxmxMapping.toDto(pcmydbxmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydbxmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmydbxmxService.get(#pcmydbxmx_id),'ehr-PcmYdbxmx-Remove')")
    @ApiOperation(value = "删除异动病休明细", tags = {"异动病休明细" },  notes = "删除异动病休明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydbxmxes/{pcmydbxmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmydbxmx_id") String pcmydbxmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmydbxmxService.remove(pcmydbxmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmydbxmxService.getPcmydbxmxByIds(#ids),'ehr-PcmYdbxmx-Remove')")
    @ApiOperation(value = "批量删除异动病休明细", tags = {"异动病休明细" },  notes = "批量删除异动病休明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydbxmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmydbxmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydbxmxMapping.toDomain(#pcmydbxmxdto),'ehr-PcmYdbxmx-Create')")
    @ApiOperation(value = "新建异动病休明细", tags = {"异动病休明细" },  notes = "新建异动病休明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydbxmxes")
    @Transactional
    public ResponseEntity<PcmYdbxmxDTO> create(@RequestBody PcmYdbxmxDTO pcmydbxmxdto) {
        PcmYdbxmx domain = pcmydbxmxMapping.toDomain(pcmydbxmxdto);
		pcmydbxmxService.create(domain);
        PcmYdbxmxDTO dto = pcmydbxmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydbxmxMapping.toDomain(#pcmydbxmxdtos),'ehr-PcmYdbxmx-Create')")
    @ApiOperation(value = "批量新建异动病休明细", tags = {"异动病休明细" },  notes = "批量新建异动病休明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydbxmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmYdbxmxDTO> pcmydbxmxdtos) {
        pcmydbxmxService.createBatch(pcmydbxmxMapping.toDomain(pcmydbxmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdbxmx-GLDS-all')")
	@ApiOperation(value = "获取管理查询", tags = {"异动病休明细" } ,notes = "获取管理查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydbxmxes/fetchglds")
	public ResponseEntity<List<PcmYdbxmxDTO>> fetchGLDS(PcmYdbxmxSearchContext context) {
        Page<PcmYdbxmx> domains = pcmydbxmxService.searchGLDS(context) ;
        List<PcmYdbxmxDTO> list = pcmydbxmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdbxmx-GLDS-all')")
	@ApiOperation(value = "查询管理查询", tags = {"异动病休明细" } ,notes = "查询管理查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydbxmxes/searchglds")
	public ResponseEntity<Page<PcmYdbxmxDTO>> searchGLDS(@RequestBody PcmYdbxmxSearchContext context) {
        Page<PcmYdbxmx> domains = pcmydbxmxService.searchGLDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydbxmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdbxmx-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"异动病休明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydbxmxes/fetchdefault")
	public ResponseEntity<List<PcmYdbxmxDTO>> fetchDefault(PcmYdbxmxSearchContext context) {
        Page<PcmYdbxmx> domains = pcmydbxmxService.searchDefault(context) ;
        List<PcmYdbxmxDTO> list = pcmydbxmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdbxmx-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"异动病休明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydbxmxes/searchdefault")
	public ResponseEntity<Page<PcmYdbxmxDTO>> searchDefault(@RequestBody PcmYdbxmxSearchContext context) {
        Page<PcmYdbxmx> domains = pcmydbxmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydbxmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdbxmx-JLDS-all')")
	@ApiOperation(value = "获取记录查询", tags = {"异动病休明细" } ,notes = "获取记录查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydbxmxes/fetchjlds")
	public ResponseEntity<List<PcmYdbxmxDTO>> fetchJLDS(PcmYdbxmxSearchContext context) {
        Page<PcmYdbxmx> domains = pcmydbxmxService.searchJLDS(context) ;
        List<PcmYdbxmxDTO> list = pcmydbxmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdbxmx-JLDS-all')")
	@ApiOperation(value = "查询记录查询", tags = {"异动病休明细" } ,notes = "查询记录查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydbxmxes/searchjlds")
	public ResponseEntity<Page<PcmYdbxmxDTO>> searchJLDS(@RequestBody PcmYdbxmxSearchContext context) {
        Page<PcmYdbxmx> domains = pcmydbxmxService.searchJLDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydbxmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

