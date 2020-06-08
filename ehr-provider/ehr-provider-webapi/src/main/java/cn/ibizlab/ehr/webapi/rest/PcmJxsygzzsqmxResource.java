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
import cn.ibizlab.ehr.core.pcm.domain.PcmJxsygzzsqmx;
import cn.ibizlab.ehr.core.pcm.service.IPcmJxsygzzsqmxService;
import cn.ibizlab.ehr.core.pcm.filter.PcmJxsygzzsqmxSearchContext;

@Slf4j
@Api(tags = {"见习生员工转正申请明细（停用）" })
@RestController("WebApi-pcmjxsygzzsqmx")
@RequestMapping("")
public class PcmJxsygzzsqmxResource {

    @Autowired
    public IPcmJxsygzzsqmxService pcmjxsygzzsqmxService;

    @Autowired
    @Lazy
    public PcmJxsygzzsqmxMapping pcmjxsygzzsqmxMapping;

    @PreAuthorize("hasPermission(this.pcmjxsygzzsqmxMapping.toDomain(#pcmjxsygzzsqmxdto),'ehr-PcmJxsygzzsqmx-Create')")
    @ApiOperation(value = "新建见习生员工转正申请明细（停用）", tags = {"见习生员工转正申请明细（停用）" },  notes = "新建见习生员工转正申请明细（停用）")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzsqmxes")
    @Transactional
    public ResponseEntity<PcmJxsygzzsqmxDTO> create(@RequestBody PcmJxsygzzsqmxDTO pcmjxsygzzsqmxdto) {
        PcmJxsygzzsqmx domain = pcmjxsygzzsqmxMapping.toDomain(pcmjxsygzzsqmxdto);
		pcmjxsygzzsqmxService.create(domain);
        PcmJxsygzzsqmxDTO dto = pcmjxsygzzsqmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzsqmxMapping.toDomain(#pcmjxsygzzsqmxdtos),'ehr-PcmJxsygzzsqmx-Create')")
    @ApiOperation(value = "批量新建见习生员工转正申请明细（停用）", tags = {"见习生员工转正申请明细（停用）" },  notes = "批量新建见习生员工转正申请明细（停用）")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzsqmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmJxsygzzsqmxDTO> pcmjxsygzzsqmxdtos) {
        pcmjxsygzzsqmxService.createBatch(pcmjxsygzzsqmxMapping.toDomain(pcmjxsygzzsqmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzsqmxMapping.toDomain(#pcmjxsygzzsqmxdto),'ehr-PcmJxsygzzsqmx-Save')")
    @ApiOperation(value = "保存见习生员工转正申请明细（停用）", tags = {"见习生员工转正申请明细（停用）" },  notes = "保存见习生员工转正申请明细（停用）")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzsqmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmJxsygzzsqmxDTO pcmjxsygzzsqmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzsqmxService.save(pcmjxsygzzsqmxMapping.toDomain(pcmjxsygzzsqmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzsqmxMapping.toDomain(#pcmjxsygzzsqmxdtos),'ehr-PcmJxsygzzsqmx-Save')")
    @ApiOperation(value = "批量保存见习生员工转正申请明细（停用）", tags = {"见习生员工转正申请明细（停用）" },  notes = "批量保存见习生员工转正申请明细（停用）")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzsqmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmJxsygzzsqmxDTO> pcmjxsygzzsqmxdtos) {
        pcmjxsygzzsqmxService.saveBatch(pcmjxsygzzsqmxMapping.toDomain(pcmjxsygzzsqmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取见习生员工转正申请明细（停用）草稿", tags = {"见习生员工转正申请明细（停用）" },  notes = "获取见习生员工转正申请明细（停用）草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmjxsygzzsqmxes/getdraft")
    public ResponseEntity<PcmJxsygzzsqmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzsqmxMapping.toDto(pcmjxsygzzsqmxService.getDraft(new PcmJxsygzzsqmx())));
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzsqmxService.get(#pcmjxsygzzsqmx_id),'ehr-PcmJxsygzzsqmx-Update')")
    @ApiOperation(value = "更新见习生员工转正申请明细（停用）", tags = {"见习生员工转正申请明细（停用）" },  notes = "更新见习生员工转正申请明细（停用）")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmjxsygzzsqmxes/{pcmjxsygzzsqmx_id}")
    @Transactional
    public ResponseEntity<PcmJxsygzzsqmxDTO> update(@PathVariable("pcmjxsygzzsqmx_id") String pcmjxsygzzsqmx_id, @RequestBody PcmJxsygzzsqmxDTO pcmjxsygzzsqmxdto) {
		PcmJxsygzzsqmx domain  = pcmjxsygzzsqmxMapping.toDomain(pcmjxsygzzsqmxdto);
        domain .setPcmjxsygzzsqmxid(pcmjxsygzzsqmx_id);
		pcmjxsygzzsqmxService.update(domain );
		PcmJxsygzzsqmxDTO dto = pcmjxsygzzsqmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzsqmxService.getPcmjxsygzzsqmxByEntities(this.pcmjxsygzzsqmxMapping.toDomain(#pcmjxsygzzsqmxdtos)),'ehr-PcmJxsygzzsqmx-Update')")
    @ApiOperation(value = "批量更新见习生员工转正申请明细（停用）", tags = {"见习生员工转正申请明细（停用）" },  notes = "批量更新见习生员工转正申请明细（停用）")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmjxsygzzsqmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmJxsygzzsqmxDTO> pcmjxsygzzsqmxdtos) {
        pcmjxsygzzsqmxService.updateBatch(pcmjxsygzzsqmxMapping.toDomain(pcmjxsygzzsqmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmjxsygzzsqmxMapping.toDomain(returnObject.body),'ehr-PcmJxsygzzsqmx-Get')")
    @ApiOperation(value = "获取见习生员工转正申请明细（停用）", tags = {"见习生员工转正申请明细（停用）" },  notes = "获取见习生员工转正申请明细（停用）")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmjxsygzzsqmxes/{pcmjxsygzzsqmx_id}")
    public ResponseEntity<PcmJxsygzzsqmxDTO> get(@PathVariable("pcmjxsygzzsqmx_id") String pcmjxsygzzsqmx_id) {
        PcmJxsygzzsqmx domain = pcmjxsygzzsqmxService.get(pcmjxsygzzsqmx_id);
        PcmJxsygzzsqmxDTO dto = pcmjxsygzzsqmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "检查见习生员工转正申请明细（停用）", tags = {"见习生员工转正申请明细（停用）" },  notes = "检查见习生员工转正申请明细（停用）")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzsqmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmJxsygzzsqmxDTO pcmjxsygzzsqmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzsqmxService.checkKey(pcmjxsygzzsqmxMapping.toDomain(pcmjxsygzzsqmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzsqmx-ZZAction-all')")
    @ApiOperation(value = "转正操作", tags = {"见习生员工转正申请明细（停用）" },  notes = "转正操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzsqmxes/{pcmjxsygzzsqmx_id}/zzaction")
    @Transactional
    public ResponseEntity<PcmJxsygzzsqmxDTO> zZAction(@PathVariable("pcmjxsygzzsqmx_id") String pcmjxsygzzsqmx_id, @RequestBody PcmJxsygzzsqmxDTO pcmjxsygzzsqmxdto) {
        PcmJxsygzzsqmx pcmjxsygzzsqmx = pcmjxsygzzsqmxMapping.toDomain(pcmjxsygzzsqmxdto);
        pcmjxsygzzsqmx.setPcmjxsygzzsqmxid(pcmjxsygzzsqmx_id);
        pcmjxsygzzsqmx = pcmjxsygzzsqmxService.zZAction(pcmjxsygzzsqmx);
        pcmjxsygzzsqmxdto = pcmjxsygzzsqmxMapping.toDto(pcmjxsygzzsqmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzsqmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzsqmxService.get(#pcmjxsygzzsqmx_id),'ehr-PcmJxsygzzsqmx-Remove')")
    @ApiOperation(value = "删除见习生员工转正申请明细（停用）", tags = {"见习生员工转正申请明细（停用）" },  notes = "删除见习生员工转正申请明细（停用）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmjxsygzzsqmxes/{pcmjxsygzzsqmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmjxsygzzsqmx_id") String pcmjxsygzzsqmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzsqmxService.remove(pcmjxsygzzsqmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzsqmxService.getPcmjxsygzzsqmxByIds(#ids),'ehr-PcmJxsygzzsqmx-Remove')")
    @ApiOperation(value = "批量删除见习生员工转正申请明细（停用）", tags = {"见习生员工转正申请明细（停用）" },  notes = "批量删除见习生员工转正申请明细（停用）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmjxsygzzsqmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmjxsygzzsqmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzsqmx-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"见习生员工转正申请明细（停用）" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmjxsygzzsqmxes/fetchdefault")
	public ResponseEntity<List<PcmJxsygzzsqmxDTO>> fetchDefault(PcmJxsygzzsqmxSearchContext context) {
        Page<PcmJxsygzzsqmx> domains = pcmjxsygzzsqmxService.searchDefault(context) ;
        List<PcmJxsygzzsqmxDTO> list = pcmjxsygzzsqmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzsqmx-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"见习生员工转正申请明细（停用）" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmjxsygzzsqmxes/searchdefault")
	public ResponseEntity<Page<PcmJxsygzzsqmxDTO>> searchDefault(@RequestBody PcmJxsygzzsqmxSearchContext context) {
        Page<PcmJxsygzzsqmx> domains = pcmjxsygzzsqmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmjxsygzzsqmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzsqmx-DSHSQ-all')")
	@ApiOperation(value = "获取待审核申请", tags = {"见习生员工转正申请明细（停用）" } ,notes = "获取待审核申请")
    @RequestMapping(method= RequestMethod.GET , value="/pcmjxsygzzsqmxes/fetchdshsq")
	public ResponseEntity<List<PcmJxsygzzsqmxDTO>> fetchDSHSQ(PcmJxsygzzsqmxSearchContext context) {
        Page<PcmJxsygzzsqmx> domains = pcmjxsygzzsqmxService.searchDSHSQ(context) ;
        List<PcmJxsygzzsqmxDTO> list = pcmjxsygzzsqmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzsqmx-DSHSQ-all')")
	@ApiOperation(value = "查询待审核申请", tags = {"见习生员工转正申请明细（停用）" } ,notes = "查询待审核申请")
    @RequestMapping(method= RequestMethod.POST , value="/pcmjxsygzzsqmxes/searchdshsq")
	public ResponseEntity<Page<PcmJxsygzzsqmxDTO>> searchDSHSQ(@RequestBody PcmJxsygzzsqmxSearchContext context) {
        Page<PcmJxsygzzsqmx> domains = pcmjxsygzzsqmxService.searchDSHSQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmjxsygzzsqmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

