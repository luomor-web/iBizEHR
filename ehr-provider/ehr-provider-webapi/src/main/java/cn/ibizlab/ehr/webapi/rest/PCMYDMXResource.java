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
import cn.ibizlab.ehr.core.pcm.domain.PCMYDMX;
import cn.ibizlab.ehr.core.pcm.service.IPCMYDMXService;
import cn.ibizlab.ehr.core.pcm.filter.PCMYDMXSearchContext;

@Slf4j
@Api(tags = {"异动明细" })
@RestController("WebApi-pcmydmx")
@RequestMapping("")
public class PCMYDMXResource {

    @Autowired
    public IPCMYDMXService pcmydmxService;

    @Autowired
    @Lazy
    public PCMYDMXMapping pcmydmxMapping;

    @PreAuthorize("hasPermission(this.pcmydmxMapping.toDomain(#pcmydmxdto),'ehr-PCMYDMX-Create')")
    @ApiOperation(value = "新建异动明细", tags = {"异动明细" },  notes = "新建异动明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydmxes")
    @Transactional
    public ResponseEntity<PCMYDMXDTO> create(@RequestBody PCMYDMXDTO pcmydmxdto) {
        PCMYDMX domain = pcmydmxMapping.toDomain(pcmydmxdto);
		pcmydmxService.create(domain);
        PCMYDMXDTO dto = pcmydmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydmxMapping.toDomain(#pcmydmxdtos),'ehr-PCMYDMX-Create')")
    @ApiOperation(value = "批量新建异动明细", tags = {"异动明细" },  notes = "批量新建异动明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMYDMXDTO> pcmydmxdtos) {
        pcmydmxService.createBatch(pcmydmxMapping.toDomain(pcmydmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydmxMapping.toDomain(#pcmydmxdto),'ehr-PCMYDMX-Save')")
    @ApiOperation(value = "保存异动明细", tags = {"异动明细" },  notes = "保存异动明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMYDMXDTO pcmydmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydmxService.save(pcmydmxMapping.toDomain(pcmydmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmydmxMapping.toDomain(#pcmydmxdtos),'ehr-PCMYDMX-Save')")
    @ApiOperation(value = "批量保存异动明细", tags = {"异动明细" },  notes = "批量保存异动明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMYDMXDTO> pcmydmxdtos) {
        pcmydmxService.saveBatch(pcmydmxMapping.toDomain(pcmydmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDMX-FillPersonInfo-all')")
    @ApiOperation(value = "填充员工信息", tags = {"异动明细" },  notes = "填充员工信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydmxes/{pcmydmx_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PCMYDMXDTO> fillPersonInfo(@PathVariable("pcmydmx_id") String pcmydmx_id, @RequestBody PCMYDMXDTO pcmydmxdto) {
        PCMYDMX pcmydmx = pcmydmxMapping.toDomain(pcmydmxdto);
        pcmydmx.setPcmydmxid(pcmydmx_id);
        pcmydmx = pcmydmxService.fillPersonInfo(pcmydmx);
        pcmydmxdto = pcmydmxMapping.toDto(pcmydmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydmxdto);
    }

    @ApiOperation(value = "检查异动明细", tags = {"异动明细" },  notes = "检查异动明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMYDMXDTO pcmydmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmydmxService.checkKey(pcmydmxMapping.toDomain(pcmydmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmydmxService.get(#pcmydmx_id),'ehr-PCMYDMX-Remove')")
    @ApiOperation(value = "删除异动明细", tags = {"异动明细" },  notes = "删除异动明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydmxes/{pcmydmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmydmx_id") String pcmydmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmydmxService.remove(pcmydmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmydmxService.getPcmydmxByIds(#ids),'ehr-PCMYDMX-Remove')")
    @ApiOperation(value = "批量删除异动明细", tags = {"异动明细" },  notes = "批量删除异动明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmydmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydmxService.get(#pcmydmx_id),'ehr-PCMYDMX-Update')")
    @ApiOperation(value = "更新异动明细", tags = {"异动明细" },  notes = "更新异动明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydmxes/{pcmydmx_id}")
    @Transactional
    public ResponseEntity<PCMYDMXDTO> update(@PathVariable("pcmydmx_id") String pcmydmx_id, @RequestBody PCMYDMXDTO pcmydmxdto) {
		PCMYDMX domain  = pcmydmxMapping.toDomain(pcmydmxdto);
        domain .setPcmydmxid(pcmydmx_id);
		pcmydmxService.update(domain );
		PCMYDMXDTO dto = pcmydmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydmxService.getPcmydmxByEntities(this.pcmydmxMapping.toDomain(#pcmydmxdtos)),'ehr-PCMYDMX-Update')")
    @ApiOperation(value = "批量更新异动明细", tags = {"异动明细" },  notes = "批量更新异动明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMYDMXDTO> pcmydmxdtos) {
        pcmydmxService.updateBatch(pcmydmxMapping.toDomain(pcmydmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取异动明细草稿", tags = {"异动明细" },  notes = "获取异动明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydmxes/getdraft")
    public ResponseEntity<PCMYDMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydmxMapping.toDto(pcmydmxService.getDraft(new PCMYDMX())));
    }

    @PostAuthorize("hasPermission(this.pcmydmxMapping.toDomain(returnObject.body),'ehr-PCMYDMX-Get')")
    @ApiOperation(value = "获取异动明细", tags = {"异动明细" },  notes = "获取异动明细")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydmxes/{pcmydmx_id}")
    public ResponseEntity<PCMYDMXDTO> get(@PathVariable("pcmydmx_id") String pcmydmx_id) {
        PCMYDMX domain = pcmydmxService.get(pcmydmx_id);
        PCMYDMXDTO dto = pcmydmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDMX-IndexDER-all')")
	@ApiOperation(value = "获取IndexDER", tags = {"异动明细" } ,notes = "获取IndexDER")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydmxes/fetchindexder")
	public ResponseEntity<List<PCMYDMXDTO>> fetchIndexDER(PCMYDMXSearchContext context) {
        Page<PCMYDMX> domains = pcmydmxService.searchIndexDER(context) ;
        List<PCMYDMXDTO> list = pcmydmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDMX-IndexDER-all')")
	@ApiOperation(value = "查询IndexDER", tags = {"异动明细" } ,notes = "查询IndexDER")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydmxes/searchindexder")
	public ResponseEntity<Page<PCMYDMXDTO>> searchIndexDER(@RequestBody PCMYDMXSearchContext context) {
        Page<PCMYDMX> domains = pcmydmxService.searchIndexDER(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDMX-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"异动明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydmxes/fetchdefault")
	public ResponseEntity<List<PCMYDMXDTO>> fetchDefault(PCMYDMXSearchContext context) {
        Page<PCMYDMX> domains = pcmydmxService.searchDefault(context) ;
        List<PCMYDMXDTO> list = pcmydmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDMX-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"异动明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydmxes/searchdefault")
	public ResponseEntity<Page<PCMYDMXDTO>> searchDefault(@RequestBody PCMYDMXSearchContext context) {
        Page<PCMYDMX> domains = pcmydmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

