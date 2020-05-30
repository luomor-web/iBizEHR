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
import cn.ibizlab.ehr.core.pcm.domain.PcmXygzzsqmx;
import cn.ibizlab.ehr.core.pcm.service.IPcmXygzzsqmxService;
import cn.ibizlab.ehr.core.pcm.filter.PcmXygzzsqmxSearchContext;

@Slf4j
@Api(tags = {"试用期员工转正申请明细（停用）" })
@RestController("WebApi-pcmxygzzsqmx")
@RequestMapping("")
public class PcmXygzzsqmxResource {

    @Autowired
    public IPcmXygzzsqmxService pcmxygzzsqmxService;

    @Autowired
    @Lazy
    public PcmXygzzsqmxMapping pcmxygzzsqmxMapping;

    @PreAuthorize("hasPermission(this.pcmxygzzsqmxService.get(#pcmxygzzsqmx_id),'ehr-PcmXygzzsqmx-Remove')")
    @ApiOperation(value = "删除试用期员工转正申请明细（停用）", tags = {"试用期员工转正申请明细（停用）" },  notes = "删除试用期员工转正申请明细（停用）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmxygzzsqmxes/{pcmxygzzsqmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmxygzzsqmx_id") String pcmxygzzsqmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzsqmxService.remove(pcmxygzzsqmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmxygzzsqmxService.getPcmxygzzsqmxByIds(#ids),'ehr-PcmXygzzsqmx-Remove')")
    @ApiOperation(value = "批量删除试用期员工转正申请明细（停用）", tags = {"试用期员工转正申请明细（停用）" },  notes = "批量删除试用期员工转正申请明细（停用）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmxygzzsqmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmxygzzsqmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取试用期员工转正申请明细（停用）草稿", tags = {"试用期员工转正申请明细（停用）" },  notes = "获取试用期员工转正申请明细（停用）草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmxygzzsqmxes/getdraft")
    public ResponseEntity<PcmXygzzsqmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzsqmxMapping.toDto(pcmxygzzsqmxService.getDraft(new PcmXygzzsqmx())));
    }

    @PostAuthorize("hasPermission(this.pcmxygzzsqmxMapping.toDomain(returnObject.body),'ehr-PcmXygzzsqmx-Get')")
    @ApiOperation(value = "获取试用期员工转正申请明细（停用）", tags = {"试用期员工转正申请明细（停用）" },  notes = "获取试用期员工转正申请明细（停用）")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmxygzzsqmxes/{pcmxygzzsqmx_id}")
    public ResponseEntity<PcmXygzzsqmxDTO> get(@PathVariable("pcmxygzzsqmx_id") String pcmxygzzsqmx_id) {
        PcmXygzzsqmx domain = pcmxygzzsqmxService.get(pcmxygzzsqmx_id);
        PcmXygzzsqmxDTO dto = pcmxygzzsqmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmxygzzsqmxService.get(#pcmxygzzsqmx_id),'ehr-PcmXygzzsqmx-Update')")
    @ApiOperation(value = "更新试用期员工转正申请明细（停用）", tags = {"试用期员工转正申请明细（停用）" },  notes = "更新试用期员工转正申请明细（停用）")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmxygzzsqmxes/{pcmxygzzsqmx_id}")
    @Transactional
    public ResponseEntity<PcmXygzzsqmxDTO> update(@PathVariable("pcmxygzzsqmx_id") String pcmxygzzsqmx_id, @RequestBody PcmXygzzsqmxDTO pcmxygzzsqmxdto) {
		PcmXygzzsqmx domain  = pcmxygzzsqmxMapping.toDomain(pcmxygzzsqmxdto);
        domain .setPcmxygzzsqmxid(pcmxygzzsqmx_id);
		pcmxygzzsqmxService.update(domain );
		PcmXygzzsqmxDTO dto = pcmxygzzsqmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmxygzzsqmxService.getPcmxygzzsqmxByEntities(this.pcmxygzzsqmxMapping.toDomain(#pcmxygzzsqmxdtos)),'ehr-PcmXygzzsqmx-Update')")
    @ApiOperation(value = "批量更新试用期员工转正申请明细（停用）", tags = {"试用期员工转正申请明细（停用）" },  notes = "批量更新试用期员工转正申请明细（停用）")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmxygzzsqmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmXygzzsqmxDTO> pcmxygzzsqmxdtos) {
        pcmxygzzsqmxService.updateBatch(pcmxygzzsqmxMapping.toDomain(pcmxygzzsqmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmXygzzsqmx-SHBTG-all')")
    @ApiOperation(value = "审核不通过", tags = {"试用期员工转正申请明细（停用）" },  notes = "审核不通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzsqmxes/{pcmxygzzsqmx_id}/shbtg")
    @Transactional
    public ResponseEntity<PcmXygzzsqmxDTO> sHBTG(@PathVariable("pcmxygzzsqmx_id") String pcmxygzzsqmx_id, @RequestBody PcmXygzzsqmxDTO pcmxygzzsqmxdto) {
        PcmXygzzsqmx pcmxygzzsqmx = pcmxygzzsqmxMapping.toDomain(pcmxygzzsqmxdto);
        pcmxygzzsqmx.setPcmxygzzsqmxid(pcmxygzzsqmx_id);
        pcmxygzzsqmx = pcmxygzzsqmxService.sHBTG(pcmxygzzsqmx);
        pcmxygzzsqmxdto = pcmxygzzsqmxMapping.toDto(pcmxygzzsqmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzsqmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmxygzzsqmxMapping.toDomain(#pcmxygzzsqmxdto),'ehr-PcmXygzzsqmx-Create')")
    @ApiOperation(value = "新建试用期员工转正申请明细（停用）", tags = {"试用期员工转正申请明细（停用）" },  notes = "新建试用期员工转正申请明细（停用）")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzsqmxes")
    @Transactional
    public ResponseEntity<PcmXygzzsqmxDTO> create(@RequestBody PcmXygzzsqmxDTO pcmxygzzsqmxdto) {
        PcmXygzzsqmx domain = pcmxygzzsqmxMapping.toDomain(pcmxygzzsqmxdto);
		pcmxygzzsqmxService.create(domain);
        PcmXygzzsqmxDTO dto = pcmxygzzsqmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmxygzzsqmxMapping.toDomain(#pcmxygzzsqmxdtos),'ehr-PcmXygzzsqmx-Create')")
    @ApiOperation(value = "批量新建试用期员工转正申请明细（停用）", tags = {"试用期员工转正申请明细（停用）" },  notes = "批量新建试用期员工转正申请明细（停用）")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzsqmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmXygzzsqmxDTO> pcmxygzzsqmxdtos) {
        pcmxygzzsqmxService.createBatch(pcmxygzzsqmxMapping.toDomain(pcmxygzzsqmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmxygzzsqmxMapping.toDomain(#pcmxygzzsqmxdto),'ehr-PcmXygzzsqmx-Save')")
    @ApiOperation(value = "保存试用期员工转正申请明细（停用）", tags = {"试用期员工转正申请明细（停用）" },  notes = "保存试用期员工转正申请明细（停用）")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzsqmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmXygzzsqmxDTO pcmxygzzsqmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzsqmxService.save(pcmxygzzsqmxMapping.toDomain(pcmxygzzsqmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmxygzzsqmxMapping.toDomain(#pcmxygzzsqmxdtos),'ehr-PcmXygzzsqmx-Save')")
    @ApiOperation(value = "批量保存试用期员工转正申请明细（停用）", tags = {"试用期员工转正申请明细（停用）" },  notes = "批量保存试用期员工转正申请明细（停用）")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzsqmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmXygzzsqmxDTO> pcmxygzzsqmxdtos) {
        pcmxygzzsqmxService.saveBatch(pcmxygzzsqmxMapping.toDomain(pcmxygzzsqmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmXygzzsqmx-SHTG-all')")
    @ApiOperation(value = "审核通过", tags = {"试用期员工转正申请明细（停用）" },  notes = "审核通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzsqmxes/{pcmxygzzsqmx_id}/shtg")
    @Transactional
    public ResponseEntity<PcmXygzzsqmxDTO> sHTG(@PathVariable("pcmxygzzsqmx_id") String pcmxygzzsqmx_id, @RequestBody PcmXygzzsqmxDTO pcmxygzzsqmxdto) {
        PcmXygzzsqmx pcmxygzzsqmx = pcmxygzzsqmxMapping.toDomain(pcmxygzzsqmxdto);
        pcmxygzzsqmx.setPcmxygzzsqmxid(pcmxygzzsqmx_id);
        pcmxygzzsqmx = pcmxygzzsqmxService.sHTG(pcmxygzzsqmx);
        pcmxygzzsqmxdto = pcmxygzzsqmxMapping.toDto(pcmxygzzsqmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzsqmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmXygzzsqmx-ZZCZ-all')")
    @ApiOperation(value = "转正操作", tags = {"试用期员工转正申请明细（停用）" },  notes = "转正操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzsqmxes/{pcmxygzzsqmx_id}/zzcz")
    @Transactional
    public ResponseEntity<PcmXygzzsqmxDTO> zZCZ(@PathVariable("pcmxygzzsqmx_id") String pcmxygzzsqmx_id, @RequestBody PcmXygzzsqmxDTO pcmxygzzsqmxdto) {
        PcmXygzzsqmx pcmxygzzsqmx = pcmxygzzsqmxMapping.toDomain(pcmxygzzsqmxdto);
        pcmxygzzsqmx.setPcmxygzzsqmxid(pcmxygzzsqmx_id);
        pcmxygzzsqmx = pcmxygzzsqmxService.zZCZ(pcmxygzzsqmx);
        pcmxygzzsqmxdto = pcmxygzzsqmxMapping.toDto(pcmxygzzsqmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzsqmxdto);
    }

    @ApiOperation(value = "检查试用期员工转正申请明细（停用）", tags = {"试用期员工转正申请明细（停用）" },  notes = "检查试用期员工转正申请明细（停用）")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzsqmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmXygzzsqmxDTO pcmxygzzsqmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmxygzzsqmxService.checkKey(pcmxygzzsqmxMapping.toDomain(pcmxygzzsqmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmXygzzsqmx-WSHSQ-all')")
	@ApiOperation(value = "获取未完成审核的申请", tags = {"试用期员工转正申请明细（停用）" } ,notes = "获取未完成审核的申请")
    @RequestMapping(method= RequestMethod.GET , value="/pcmxygzzsqmxes/fetchwshsq")
	public ResponseEntity<List<PcmXygzzsqmxDTO>> fetchWSHSQ(PcmXygzzsqmxSearchContext context) {
        Page<PcmXygzzsqmx> domains = pcmxygzzsqmxService.searchWSHSQ(context) ;
        List<PcmXygzzsqmxDTO> list = pcmxygzzsqmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmXygzzsqmx-WSHSQ-all')")
	@ApiOperation(value = "查询未完成审核的申请", tags = {"试用期员工转正申请明细（停用）" } ,notes = "查询未完成审核的申请")
    @RequestMapping(method= RequestMethod.POST , value="/pcmxygzzsqmxes/searchwshsq")
	public ResponseEntity<Page<PcmXygzzsqmxDTO>> searchWSHSQ(@RequestBody PcmXygzzsqmxSearchContext context) {
        Page<PcmXygzzsqmx> domains = pcmxygzzsqmxService.searchWSHSQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmxygzzsqmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmXygzzsqmx-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"试用期员工转正申请明细（停用）" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmxygzzsqmxes/fetchdefault")
	public ResponseEntity<List<PcmXygzzsqmxDTO>> fetchDefault(PcmXygzzsqmxSearchContext context) {
        Page<PcmXygzzsqmx> domains = pcmxygzzsqmxService.searchDefault(context) ;
        List<PcmXygzzsqmxDTO> list = pcmxygzzsqmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmXygzzsqmx-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"试用期员工转正申请明细（停用）" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmxygzzsqmxes/searchdefault")
	public ResponseEntity<Page<PcmXygzzsqmxDTO>> searchDefault(@RequestBody PcmXygzzsqmxSearchContext context) {
        Page<PcmXygzzsqmx> domains = pcmxygzzsqmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmxygzzsqmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

