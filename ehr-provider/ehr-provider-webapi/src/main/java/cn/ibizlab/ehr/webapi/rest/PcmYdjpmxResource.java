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
import cn.ibizlab.ehr.core.pcm.domain.PcmYdjpmx;
import cn.ibizlab.ehr.core.pcm.service.IPcmYdjpmxService;
import cn.ibizlab.ehr.core.pcm.filter.PcmYdjpmxSearchContext;

@Slf4j
@Api(tags = {"异动解聘明细" })
@RestController("WebApi-pcmydjpmx")
@RequestMapping("")
public class PcmYdjpmxResource {

    @Autowired
    public IPcmYdjpmxService pcmydjpmxService;

    @Autowired
    @Lazy
    public PcmYdjpmxMapping pcmydjpmxMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjpmx-FillPersonInfo-all')")
    @ApiOperation(value = "填充人员信息", tags = {"异动解聘明细" },  notes = "填充人员信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjpmxes/{pcmydjpmx_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PcmYdjpmxDTO> fillPersonInfo(@PathVariable("pcmydjpmx_id") String pcmydjpmx_id, @RequestBody PcmYdjpmxDTO pcmydjpmxdto) {
        PcmYdjpmx pcmydjpmx = pcmydjpmxMapping.toDomain(pcmydjpmxdto);
        pcmydjpmx.setPcmydjpmxid(pcmydjpmx_id);
        pcmydjpmx = pcmydjpmxService.fillPersonInfo(pcmydjpmx);
        pcmydjpmxdto = pcmydjpmxMapping.toDto(pcmydjpmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjpmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmydjpmxService.get(#pcmydjpmx_id),'ehr-PcmYdjpmx-Update')")
    @ApiOperation(value = "更新异动解聘明细", tags = {"异动解聘明细" },  notes = "更新异动解聘明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydjpmxes/{pcmydjpmx_id}")
    @Transactional
    public ResponseEntity<PcmYdjpmxDTO> update(@PathVariable("pcmydjpmx_id") String pcmydjpmx_id, @RequestBody PcmYdjpmxDTO pcmydjpmxdto) {
		PcmYdjpmx domain  = pcmydjpmxMapping.toDomain(pcmydjpmxdto);
        domain .setPcmydjpmxid(pcmydjpmx_id);
		pcmydjpmxService.update(domain );
		PcmYdjpmxDTO dto = pcmydjpmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydjpmxService.getPcmydjpmxByEntities(this.pcmydjpmxMapping.toDomain(#pcmydjpmxdtos)),'ehr-PcmYdjpmx-Update')")
    @ApiOperation(value = "批量更新异动解聘明细", tags = {"异动解聘明细" },  notes = "批量更新异动解聘明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydjpmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmYdjpmxDTO> pcmydjpmxdtos) {
        pcmydjpmxService.updateBatch(pcmydjpmxMapping.toDomain(pcmydjpmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取异动解聘明细草稿", tags = {"异动解聘明细" },  notes = "获取异动解聘明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydjpmxes/getdraft")
    public ResponseEntity<PcmYdjpmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjpmxMapping.toDto(pcmydjpmxService.getDraft(new PcmYdjpmx())));
    }

    @ApiOperation(value = "检查异动解聘明细", tags = {"异动解聘明细" },  notes = "检查异动解聘明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjpmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmYdjpmxDTO pcmydjpmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmydjpmxService.checkKey(pcmydjpmxMapping.toDomain(pcmydjpmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmydjpmxMapping.toDomain(#pcmydjpmxdto),'ehr-PcmYdjpmx-Save')")
    @ApiOperation(value = "保存异动解聘明细", tags = {"异动解聘明细" },  notes = "保存异动解聘明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjpmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmYdjpmxDTO pcmydjpmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjpmxService.save(pcmydjpmxMapping.toDomain(pcmydjpmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmydjpmxMapping.toDomain(#pcmydjpmxdtos),'ehr-PcmYdjpmx-Save')")
    @ApiOperation(value = "批量保存异动解聘明细", tags = {"异动解聘明细" },  notes = "批量保存异动解聘明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjpmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmYdjpmxDTO> pcmydjpmxdtos) {
        pcmydjpmxService.saveBatch(pcmydjpmxMapping.toDomain(pcmydjpmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjpmx-IsFinished-all')")
    @ApiOperation(value = "是否完成解聘", tags = {"异动解聘明细" },  notes = "是否完成解聘")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjpmxes/{pcmydjpmx_id}/isfinished")
    @Transactional
    public ResponseEntity<PcmYdjpmxDTO> isFinished(@PathVariable("pcmydjpmx_id") String pcmydjpmx_id, @RequestBody PcmYdjpmxDTO pcmydjpmxdto) {
        PcmYdjpmx pcmydjpmx = pcmydjpmxMapping.toDomain(pcmydjpmxdto);
        pcmydjpmx.setPcmydjpmxid(pcmydjpmx_id);
        pcmydjpmx = pcmydjpmxService.isFinished(pcmydjpmx);
        pcmydjpmxdto = pcmydjpmxMapping.toDto(pcmydjpmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjpmxdto);
    }

    @PostAuthorize("hasPermission(this.pcmydjpmxMapping.toDomain(returnObject.body),'ehr-PcmYdjpmx-Get')")
    @ApiOperation(value = "获取异动解聘明细", tags = {"异动解聘明细" },  notes = "获取异动解聘明细")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydjpmxes/{pcmydjpmx_id}")
    public ResponseEntity<PcmYdjpmxDTO> get(@PathVariable("pcmydjpmx_id") String pcmydjpmx_id) {
        PcmYdjpmx domain = pcmydjpmxService.get(pcmydjpmx_id);
        PcmYdjpmxDTO dto = pcmydjpmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydjpmxMapping.toDomain(#pcmydjpmxdto),'ehr-PcmYdjpmx-Create')")
    @ApiOperation(value = "新建异动解聘明细", tags = {"异动解聘明细" },  notes = "新建异动解聘明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjpmxes")
    @Transactional
    public ResponseEntity<PcmYdjpmxDTO> create(@RequestBody PcmYdjpmxDTO pcmydjpmxdto) {
        PcmYdjpmx domain = pcmydjpmxMapping.toDomain(pcmydjpmxdto);
		pcmydjpmxService.create(domain);
        PcmYdjpmxDTO dto = pcmydjpmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydjpmxMapping.toDomain(#pcmydjpmxdtos),'ehr-PcmYdjpmx-Create')")
    @ApiOperation(value = "批量新建异动解聘明细", tags = {"异动解聘明细" },  notes = "批量新建异动解聘明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjpmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmYdjpmxDTO> pcmydjpmxdtos) {
        pcmydjpmxService.createBatch(pcmydjpmxMapping.toDomain(pcmydjpmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydjpmxService.get(#pcmydjpmx_id),'ehr-PcmYdjpmx-Remove')")
    @ApiOperation(value = "删除异动解聘明细", tags = {"异动解聘明细" },  notes = "删除异动解聘明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydjpmxes/{pcmydjpmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmydjpmx_id") String pcmydjpmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmydjpmxService.remove(pcmydjpmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmydjpmxService.getPcmydjpmxByIds(#ids),'ehr-PcmYdjpmx-Remove')")
    @ApiOperation(value = "批量删除异动解聘明细", tags = {"异动解聘明细" },  notes = "批量删除异动解聘明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydjpmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmydjpmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjpmx-JLDS-all')")
	@ApiOperation(value = "获取记录查询", tags = {"异动解聘明细" } ,notes = "获取记录查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydjpmxes/fetchjlds")
	public ResponseEntity<List<PcmYdjpmxDTO>> fetchJLDS(PcmYdjpmxSearchContext context) {
        Page<PcmYdjpmx> domains = pcmydjpmxService.searchJLDS(context) ;
        List<PcmYdjpmxDTO> list = pcmydjpmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjpmx-JLDS-all')")
	@ApiOperation(value = "查询记录查询", tags = {"异动解聘明细" } ,notes = "查询记录查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydjpmxes/searchjlds")
	public ResponseEntity<Page<PcmYdjpmxDTO>> searchJLDS(@RequestBody PcmYdjpmxSearchContext context) {
        Page<PcmYdjpmx> domains = pcmydjpmxService.searchJLDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjpmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjpmx-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"异动解聘明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydjpmxes/fetchdefault")
	public ResponseEntity<List<PcmYdjpmxDTO>> fetchDefault(PcmYdjpmxSearchContext context) {
        Page<PcmYdjpmx> domains = pcmydjpmxService.searchDefault(context) ;
        List<PcmYdjpmxDTO> list = pcmydjpmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjpmx-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"异动解聘明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydjpmxes/searchdefault")
	public ResponseEntity<Page<PcmYdjpmxDTO>> searchDefault(@RequestBody PcmYdjpmxSearchContext context) {
        Page<PcmYdjpmx> domains = pcmydjpmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjpmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjpmx-GLDS-all')")
	@ApiOperation(value = "获取管理查询", tags = {"异动解聘明细" } ,notes = "获取管理查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydjpmxes/fetchglds")
	public ResponseEntity<List<PcmYdjpmxDTO>> fetchGLDS(PcmYdjpmxSearchContext context) {
        Page<PcmYdjpmx> domains = pcmydjpmxService.searchGLDS(context) ;
        List<PcmYdjpmxDTO> list = pcmydjpmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjpmx-GLDS-all')")
	@ApiOperation(value = "查询管理查询", tags = {"异动解聘明细" } ,notes = "查询管理查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydjpmxes/searchglds")
	public ResponseEntity<Page<PcmYdjpmxDTO>> searchGLDS(@RequestBody PcmYdjpmxSearchContext context) {
        Page<PcmYdjpmx> domains = pcmydjpmxService.searchGLDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjpmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

