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
import cn.ibizlab.ehr.core.pcm.domain.PCMXYGZZSQMX;
import cn.ibizlab.ehr.core.pcm.service.IPCMXYGZZSQMXService;
import cn.ibizlab.ehr.core.pcm.filter.PCMXYGZZSQMXSearchContext;

@Slf4j
@Api(tags = {"试用期员工转正申请明细（停用）" })
@RestController("WebApi-pcmxygzzsqmx")
@RequestMapping("")
public class PCMXYGZZSQMXResource {

    @Autowired
    public IPCMXYGZZSQMXService pcmxygzzsqmxService;

    @Autowired
    @Lazy
    public PCMXYGZZSQMXMapping pcmxygzzsqmxMapping;

    @PreAuthorize("hasPermission(this.pcmxygzzsqmxService.get(#pcmxygzzsqmx_id),'ehr-PCMXYGZZSQMX-Remove')")
    @ApiOperation(value = "删除试用期员工转正申请明细（停用）", tags = {"试用期员工转正申请明细（停用）" },  notes = "删除试用期员工转正申请明细（停用）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmxygzzsqmxes/{pcmxygzzsqmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmxygzzsqmx_id") String pcmxygzzsqmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzsqmxService.remove(pcmxygzzsqmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmxygzzsqmxService.getPcmxygzzsqmxByIds(#ids),'ehr-PCMXYGZZSQMX-Remove')")
    @ApiOperation(value = "批量删除试用期员工转正申请明细（停用）", tags = {"试用期员工转正申请明细（停用）" },  notes = "批量删除试用期员工转正申请明细（停用）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmxygzzsqmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmxygzzsqmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取试用期员工转正申请明细（停用）草稿", tags = {"试用期员工转正申请明细（停用）" },  notes = "获取试用期员工转正申请明细（停用）草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmxygzzsqmxes/getdraft")
    public ResponseEntity<PCMXYGZZSQMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzsqmxMapping.toDto(pcmxygzzsqmxService.getDraft(new PCMXYGZZSQMX())));
    }

    @PostAuthorize("hasPermission(this.pcmxygzzsqmxMapping.toDomain(returnObject.body),'ehr-PCMXYGZZSQMX-Get')")
    @ApiOperation(value = "获取试用期员工转正申请明细（停用）", tags = {"试用期员工转正申请明细（停用）" },  notes = "获取试用期员工转正申请明细（停用）")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmxygzzsqmxes/{pcmxygzzsqmx_id}")
    public ResponseEntity<PCMXYGZZSQMXDTO> get(@PathVariable("pcmxygzzsqmx_id") String pcmxygzzsqmx_id) {
        PCMXYGZZSQMX domain = pcmxygzzsqmxService.get(pcmxygzzsqmx_id);
        PCMXYGZZSQMXDTO dto = pcmxygzzsqmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmxygzzsqmxService.get(#pcmxygzzsqmx_id),'ehr-PCMXYGZZSQMX-Update')")
    @ApiOperation(value = "更新试用期员工转正申请明细（停用）", tags = {"试用期员工转正申请明细（停用）" },  notes = "更新试用期员工转正申请明细（停用）")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmxygzzsqmxes/{pcmxygzzsqmx_id}")
    @Transactional
    public ResponseEntity<PCMXYGZZSQMXDTO> update(@PathVariable("pcmxygzzsqmx_id") String pcmxygzzsqmx_id, @RequestBody PCMXYGZZSQMXDTO pcmxygzzsqmxdto) {
		PCMXYGZZSQMX domain  = pcmxygzzsqmxMapping.toDomain(pcmxygzzsqmxdto);
        domain .setPcmxygzzsqmxid(pcmxygzzsqmx_id);
		pcmxygzzsqmxService.update(domain );
		PCMXYGZZSQMXDTO dto = pcmxygzzsqmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmxygzzsqmxService.getPcmxygzzsqmxByEntities(this.pcmxygzzsqmxMapping.toDomain(#pcmxygzzsqmxdtos)),'ehr-PCMXYGZZSQMX-Update')")
    @ApiOperation(value = "批量更新试用期员工转正申请明细（停用）", tags = {"试用期员工转正申请明细（停用）" },  notes = "批量更新试用期员工转正申请明细（停用）")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmxygzzsqmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMXYGZZSQMXDTO> pcmxygzzsqmxdtos) {
        pcmxygzzsqmxService.updateBatch(pcmxygzzsqmxMapping.toDomain(pcmxygzzsqmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMXYGZZSQMX-SHBTG-all')")
    @ApiOperation(value = "审核不通过", tags = {"试用期员工转正申请明细（停用）" },  notes = "审核不通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzsqmxes/{pcmxygzzsqmx_id}/shbtg")
    @Transactional
    public ResponseEntity<PCMXYGZZSQMXDTO> sHBTG(@PathVariable("pcmxygzzsqmx_id") String pcmxygzzsqmx_id, @RequestBody PCMXYGZZSQMXDTO pcmxygzzsqmxdto) {
        PCMXYGZZSQMX pcmxygzzsqmx = pcmxygzzsqmxMapping.toDomain(pcmxygzzsqmxdto);
        pcmxygzzsqmx.setPcmxygzzsqmxid(pcmxygzzsqmx_id);
        pcmxygzzsqmx = pcmxygzzsqmxService.sHBTG(pcmxygzzsqmx);
        pcmxygzzsqmxdto = pcmxygzzsqmxMapping.toDto(pcmxygzzsqmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzsqmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmxygzzsqmxMapping.toDomain(#pcmxygzzsqmxdto),'ehr-PCMXYGZZSQMX-Create')")
    @ApiOperation(value = "新建试用期员工转正申请明细（停用）", tags = {"试用期员工转正申请明细（停用）" },  notes = "新建试用期员工转正申请明细（停用）")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzsqmxes")
    @Transactional
    public ResponseEntity<PCMXYGZZSQMXDTO> create(@RequestBody PCMXYGZZSQMXDTO pcmxygzzsqmxdto) {
        PCMXYGZZSQMX domain = pcmxygzzsqmxMapping.toDomain(pcmxygzzsqmxdto);
		pcmxygzzsqmxService.create(domain);
        PCMXYGZZSQMXDTO dto = pcmxygzzsqmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmxygzzsqmxMapping.toDomain(#pcmxygzzsqmxdtos),'ehr-PCMXYGZZSQMX-Create')")
    @ApiOperation(value = "批量新建试用期员工转正申请明细（停用）", tags = {"试用期员工转正申请明细（停用）" },  notes = "批量新建试用期员工转正申请明细（停用）")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzsqmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMXYGZZSQMXDTO> pcmxygzzsqmxdtos) {
        pcmxygzzsqmxService.createBatch(pcmxygzzsqmxMapping.toDomain(pcmxygzzsqmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmxygzzsqmxMapping.toDomain(#pcmxygzzsqmxdto),'ehr-PCMXYGZZSQMX-Save')")
    @ApiOperation(value = "保存试用期员工转正申请明细（停用）", tags = {"试用期员工转正申请明细（停用）" },  notes = "保存试用期员工转正申请明细（停用）")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzsqmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMXYGZZSQMXDTO pcmxygzzsqmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzsqmxService.save(pcmxygzzsqmxMapping.toDomain(pcmxygzzsqmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmxygzzsqmxMapping.toDomain(#pcmxygzzsqmxdtos),'ehr-PCMXYGZZSQMX-Save')")
    @ApiOperation(value = "批量保存试用期员工转正申请明细（停用）", tags = {"试用期员工转正申请明细（停用）" },  notes = "批量保存试用期员工转正申请明细（停用）")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzsqmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMXYGZZSQMXDTO> pcmxygzzsqmxdtos) {
        pcmxygzzsqmxService.saveBatch(pcmxygzzsqmxMapping.toDomain(pcmxygzzsqmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMXYGZZSQMX-SHTG-all')")
    @ApiOperation(value = "审核通过", tags = {"试用期员工转正申请明细（停用）" },  notes = "审核通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzsqmxes/{pcmxygzzsqmx_id}/shtg")
    @Transactional
    public ResponseEntity<PCMXYGZZSQMXDTO> sHTG(@PathVariable("pcmxygzzsqmx_id") String pcmxygzzsqmx_id, @RequestBody PCMXYGZZSQMXDTO pcmxygzzsqmxdto) {
        PCMXYGZZSQMX pcmxygzzsqmx = pcmxygzzsqmxMapping.toDomain(pcmxygzzsqmxdto);
        pcmxygzzsqmx.setPcmxygzzsqmxid(pcmxygzzsqmx_id);
        pcmxygzzsqmx = pcmxygzzsqmxService.sHTG(pcmxygzzsqmx);
        pcmxygzzsqmxdto = pcmxygzzsqmxMapping.toDto(pcmxygzzsqmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzsqmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMXYGZZSQMX-ZZCZ-all')")
    @ApiOperation(value = "转正操作", tags = {"试用期员工转正申请明细（停用）" },  notes = "转正操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzsqmxes/{pcmxygzzsqmx_id}/zzcz")
    @Transactional
    public ResponseEntity<PCMXYGZZSQMXDTO> zZCZ(@PathVariable("pcmxygzzsqmx_id") String pcmxygzzsqmx_id, @RequestBody PCMXYGZZSQMXDTO pcmxygzzsqmxdto) {
        PCMXYGZZSQMX pcmxygzzsqmx = pcmxygzzsqmxMapping.toDomain(pcmxygzzsqmxdto);
        pcmxygzzsqmx.setPcmxygzzsqmxid(pcmxygzzsqmx_id);
        pcmxygzzsqmx = pcmxygzzsqmxService.zZCZ(pcmxygzzsqmx);
        pcmxygzzsqmxdto = pcmxygzzsqmxMapping.toDto(pcmxygzzsqmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzsqmxdto);
    }

    @ApiOperation(value = "检查试用期员工转正申请明细（停用）", tags = {"试用期员工转正申请明细（停用）" },  notes = "检查试用期员工转正申请明细（停用）")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzsqmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMXYGZZSQMXDTO pcmxygzzsqmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmxygzzsqmxService.checkKey(pcmxygzzsqmxMapping.toDomain(pcmxygzzsqmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMXYGZZSQMX-WSHSQ-all')")
	@ApiOperation(value = "获取未完成审核的申请", tags = {"试用期员工转正申请明细（停用）" } ,notes = "获取未完成审核的申请")
    @RequestMapping(method= RequestMethod.GET , value="/pcmxygzzsqmxes/fetchwshsq")
	public ResponseEntity<List<PCMXYGZZSQMXDTO>> fetchWSHSQ(PCMXYGZZSQMXSearchContext context) {
        Page<PCMXYGZZSQMX> domains = pcmxygzzsqmxService.searchWSHSQ(context) ;
        List<PCMXYGZZSQMXDTO> list = pcmxygzzsqmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMXYGZZSQMX-WSHSQ-all')")
	@ApiOperation(value = "查询未完成审核的申请", tags = {"试用期员工转正申请明细（停用）" } ,notes = "查询未完成审核的申请")
    @RequestMapping(method= RequestMethod.POST , value="/pcmxygzzsqmxes/searchwshsq")
	public ResponseEntity<Page<PCMXYGZZSQMXDTO>> searchWSHSQ(@RequestBody PCMXYGZZSQMXSearchContext context) {
        Page<PCMXYGZZSQMX> domains = pcmxygzzsqmxService.searchWSHSQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmxygzzsqmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMXYGZZSQMX-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"试用期员工转正申请明细（停用）" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmxygzzsqmxes/fetchdefault")
	public ResponseEntity<List<PCMXYGZZSQMXDTO>> fetchDefault(PCMXYGZZSQMXSearchContext context) {
        Page<PCMXYGZZSQMX> domains = pcmxygzzsqmxService.searchDefault(context) ;
        List<PCMXYGZZSQMXDTO> list = pcmxygzzsqmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMXYGZZSQMX-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"试用期员工转正申请明细（停用）" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmxygzzsqmxes/searchdefault")
	public ResponseEntity<Page<PCMXYGZZSQMXDTO>> searchDefault(@RequestBody PCMXYGZZSQMXSearchContext context) {
        Page<PCMXYGZZSQMX> domains = pcmxygzzsqmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmxygzzsqmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

