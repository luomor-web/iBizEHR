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
import cn.ibizlab.ehr.core.pcm.domain.PcmZpmeglmx;
import cn.ibizlab.ehr.core.pcm.service.IPcmZpmeglmxService;
import cn.ibizlab.ehr.core.pcm.filter.PcmZpmeglmxSearchContext;

@Slf4j
@Api(tags = {"招聘名额管理明细" })
@RestController("WebApi-pcmzpmeglmx")
@RequestMapping("")
public class PcmZpmeglmxResource {

    @Autowired
    public IPcmZpmeglmxService pcmzpmeglmxService;

    @Autowired
    @Lazy
    public PcmZpmeglmxMapping pcmzpmeglmxMapping;

    @ApiOperation(value = "检查招聘名额管理明细", tags = {"招聘名额管理明细" },  notes = "检查招聘名额管理明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzpmeglmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmZpmeglmxDTO pcmzpmeglmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmzpmeglmxService.checkKey(pcmzpmeglmxMapping.toDomain(pcmzpmeglmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmzpmeglmxMapping.toDomain(#pcmzpmeglmxdto),'ehr-PcmZpmeglmx-Create')")
    @ApiOperation(value = "新建招聘名额管理明细", tags = {"招聘名额管理明细" },  notes = "新建招聘名额管理明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzpmeglmxes")
    @Transactional
    public ResponseEntity<PcmZpmeglmxDTO> create(@RequestBody PcmZpmeglmxDTO pcmzpmeglmxdto) {
        PcmZpmeglmx domain = pcmzpmeglmxMapping.toDomain(pcmzpmeglmxdto);
		pcmzpmeglmxService.create(domain);
        PcmZpmeglmxDTO dto = pcmzpmeglmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmzpmeglmxMapping.toDomain(#pcmzpmeglmxdtos),'ehr-PcmZpmeglmx-Create')")
    @ApiOperation(value = "批量新建招聘名额管理明细", tags = {"招聘名额管理明细" },  notes = "批量新建招聘名额管理明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzpmeglmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmZpmeglmxDTO> pcmzpmeglmxdtos) {
        pcmzpmeglmxService.createBatch(pcmzpmeglmxMapping.toDomain(pcmzpmeglmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmzpmeglmxMapping.toDomain(returnObject.body),'ehr-PcmZpmeglmx-Get')")
    @ApiOperation(value = "获取招聘名额管理明细", tags = {"招聘名额管理明细" },  notes = "获取招聘名额管理明细")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmzpmeglmxes/{pcmzpmeglmx_id}")
    public ResponseEntity<PcmZpmeglmxDTO> get(@PathVariable("pcmzpmeglmx_id") String pcmzpmeglmx_id) {
        PcmZpmeglmx domain = pcmzpmeglmxService.get(pcmzpmeglmx_id);
        PcmZpmeglmxDTO dto = pcmzpmeglmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取招聘名额管理明细草稿", tags = {"招聘名额管理明细" },  notes = "获取招聘名额管理明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmzpmeglmxes/getdraft")
    public ResponseEntity<PcmZpmeglmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmzpmeglmxMapping.toDto(pcmzpmeglmxService.getDraft(new PcmZpmeglmx())));
    }

    @PreAuthorize("hasPermission(this.pcmzpmeglmxService.get(#pcmzpmeglmx_id),'ehr-PcmZpmeglmx-Update')")
    @ApiOperation(value = "更新招聘名额管理明细", tags = {"招聘名额管理明细" },  notes = "更新招聘名额管理明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmzpmeglmxes/{pcmzpmeglmx_id}")
    @Transactional
    public ResponseEntity<PcmZpmeglmxDTO> update(@PathVariable("pcmzpmeglmx_id") String pcmzpmeglmx_id, @RequestBody PcmZpmeglmxDTO pcmzpmeglmxdto) {
		PcmZpmeglmx domain  = pcmzpmeglmxMapping.toDomain(pcmzpmeglmxdto);
        domain .setPcmzpmeglmxid(pcmzpmeglmx_id);
		pcmzpmeglmxService.update(domain );
		PcmZpmeglmxDTO dto = pcmzpmeglmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmzpmeglmxService.getPcmzpmeglmxByEntities(this.pcmzpmeglmxMapping.toDomain(#pcmzpmeglmxdtos)),'ehr-PcmZpmeglmx-Update')")
    @ApiOperation(value = "批量更新招聘名额管理明细", tags = {"招聘名额管理明细" },  notes = "批量更新招聘名额管理明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmzpmeglmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmZpmeglmxDTO> pcmzpmeglmxdtos) {
        pcmzpmeglmxService.updateBatch(pcmzpmeglmxMapping.toDomain(pcmzpmeglmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmzpmeglmxMapping.toDomain(#pcmzpmeglmxdto),'ehr-PcmZpmeglmx-Save')")
    @ApiOperation(value = "保存招聘名额管理明细", tags = {"招聘名额管理明细" },  notes = "保存招聘名额管理明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzpmeglmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmZpmeglmxDTO pcmzpmeglmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmzpmeglmxService.save(pcmzpmeglmxMapping.toDomain(pcmzpmeglmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmzpmeglmxMapping.toDomain(#pcmzpmeglmxdtos),'ehr-PcmZpmeglmx-Save')")
    @ApiOperation(value = "批量保存招聘名额管理明细", tags = {"招聘名额管理明细" },  notes = "批量保存招聘名额管理明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzpmeglmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmZpmeglmxDTO> pcmzpmeglmxdtos) {
        pcmzpmeglmxService.saveBatch(pcmzpmeglmxMapping.toDomain(pcmzpmeglmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmzpmeglmxService.get(#pcmzpmeglmx_id),'ehr-PcmZpmeglmx-Remove')")
    @ApiOperation(value = "删除招聘名额管理明细", tags = {"招聘名额管理明细" },  notes = "删除招聘名额管理明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmzpmeglmxes/{pcmzpmeglmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmzpmeglmx_id") String pcmzpmeglmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmzpmeglmxService.remove(pcmzpmeglmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmzpmeglmxService.getPcmzpmeglmxByIds(#ids),'ehr-PcmZpmeglmx-Remove')")
    @ApiOperation(value = "批量删除招聘名额管理明细", tags = {"招聘名额管理明细" },  notes = "批量删除招聘名额管理明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmzpmeglmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmzpmeglmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmZpmeglmx-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"招聘名额管理明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmzpmeglmxes/fetchdefault")
	public ResponseEntity<List<PcmZpmeglmxDTO>> fetchDefault(PcmZpmeglmxSearchContext context) {
        Page<PcmZpmeglmx> domains = pcmzpmeglmxService.searchDefault(context) ;
        List<PcmZpmeglmxDTO> list = pcmzpmeglmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmZpmeglmx-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"招聘名额管理明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmzpmeglmxes/searchdefault")
	public ResponseEntity<Page<PcmZpmeglmxDTO>> searchDefault(@RequestBody PcmZpmeglmxSearchContext context) {
        Page<PcmZpmeglmx> domains = pcmzpmeglmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmzpmeglmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

