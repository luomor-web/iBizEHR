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
import cn.ibizlab.ehr.core.pcm.domain.PcmYdjdmx;
import cn.ibizlab.ehr.core.pcm.service.IPcmYdjdmxService;
import cn.ibizlab.ehr.core.pcm.filter.PcmYdjdmxSearchContext;

@Slf4j
@Api(tags = {"异动借调明细" })
@RestController("WebApi-pcmydjdmx")
@RequestMapping("")
public class PcmYdjdmxResource {

    @Autowired
    public IPcmYdjdmxService pcmydjdmxService;

    @Autowired
    @Lazy
    public PcmYdjdmxMapping pcmydjdmxMapping;

    @PostAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(returnObject.body),'ehr-PcmYdjdmx-Get')")
    @ApiOperation(value = "获取异动借调明细", tags = {"异动借调明细" },  notes = "获取异动借调明细")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydjdmxes/{pcmydjdmx_id}")
    public ResponseEntity<PcmYdjdmxDTO> get(@PathVariable("pcmydjdmx_id") String pcmydjdmx_id) {
        PcmYdjdmx domain = pcmydjdmxService.get(pcmydjdmx_id);
        PcmYdjdmxDTO dto = pcmydjdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取异动借调明细草稿", tags = {"异动借调明细" },  notes = "获取异动借调明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydjdmxes/getdraft")
    public ResponseEntity<PcmYdjdmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxMapping.toDto(pcmydjdmxService.getDraft(new PcmYdjdmx())));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.get(#pcmydjdmx_id),'ehr-PcmYdjdmx-Update')")
    @ApiOperation(value = "更新异动借调明细", tags = {"异动借调明细" },  notes = "更新异动借调明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydjdmxes/{pcmydjdmx_id}")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> update(@PathVariable("pcmydjdmx_id") String pcmydjdmx_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
		PcmYdjdmx domain  = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain .setPcmydjdmxid(pcmydjdmx_id);
		pcmydjdmxService.update(domain );
		PcmYdjdmxDTO dto = pcmydjdmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.getPcmydjdmxByEntities(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdtos)),'ehr-PcmYdjdmx-Update')")
    @ApiOperation(value = "批量更新异动借调明细", tags = {"异动借调明细" },  notes = "批量更新异动借调明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydjdmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmYdjdmxDTO> pcmydjdmxdtos) {
        pcmydjdmxService.updateBatch(pcmydjdmxMapping.toDomain(pcmydjdmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.get(#pcmydjdmx_id),'ehr-PcmYdjdmx-Remove')")
    @ApiOperation(value = "删除异动借调明细", tags = {"异动借调明细" },  notes = "删除异动借调明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydjdmxes/{pcmydjdmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmydjdmx_id") String pcmydjdmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxService.remove(pcmydjdmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.getPcmydjdmxByIds(#ids),'ehr-PcmYdjdmx-Remove')")
    @ApiOperation(value = "批量删除异动借调明细", tags = {"异动借调明细" },  notes = "批量删除异动借调明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydjdmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmydjdmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-PersonBack-all')")
    @ApiOperation(value = "人员回归", tags = {"异动借调明细" },  notes = "人员回归")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjdmxes/{pcmydjdmx_id}/personback")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> personBack(@PathVariable("pcmydjdmx_id") String pcmydjdmx_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx pcmydjdmx = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        pcmydjdmx.setPcmydjdmxid(pcmydjdmx_id);
        pcmydjdmx = pcmydjdmxService.personBack(pcmydjdmx);
        pcmydjdmxdto = pcmydjdmxMapping.toDto(pcmydjdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-PersonInfo-all')")
    @ApiOperation(value = "填充人员信息", tags = {"异动借调明细" },  notes = "填充人员信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjdmxes/{pcmydjdmx_id}/personinfo")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> personInfo(@PathVariable("pcmydjdmx_id") String pcmydjdmx_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx pcmydjdmx = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        pcmydjdmx.setPcmydjdmxid(pcmydjdmx_id);
        pcmydjdmx = pcmydjdmxService.personInfo(pcmydjdmx);
        pcmydjdmxdto = pcmydjdmxMapping.toDto(pcmydjdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxdto);
    }

    @ApiOperation(value = "检查异动借调明细", tags = {"异动借调明细" },  notes = "检查异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjdmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxService.checkKey(pcmydjdmxMapping.toDomain(pcmydjdmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdto),'ehr-PcmYdjdmx-Save')")
    @ApiOperation(value = "保存异动借调明细", tags = {"异动借调明细" },  notes = "保存异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjdmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxService.save(pcmydjdmxMapping.toDomain(pcmydjdmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdtos),'ehr-PcmYdjdmx-Save')")
    @ApiOperation(value = "批量保存异动借调明细", tags = {"异动借调明细" },  notes = "批量保存异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjdmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmYdjdmxDTO> pcmydjdmxdtos) {
        pcmydjdmxService.saveBatch(pcmydjdmxMapping.toDomain(pcmydjdmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdto),'ehr-PcmYdjdmx-Create')")
    @ApiOperation(value = "新建异动借调明细", tags = {"异动借调明细" },  notes = "新建异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjdmxes")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> create(@RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
		pcmydjdmxService.create(domain);
        PcmYdjdmxDTO dto = pcmydjdmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdtos),'ehr-PcmYdjdmx-Create')")
    @ApiOperation(value = "批量新建异动借调明细", tags = {"异动借调明细" },  notes = "批量新建异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjdmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmYdjdmxDTO> pcmydjdmxdtos) {
        pcmydjdmxService.createBatch(pcmydjdmxMapping.toDomain(pcmydjdmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDGLDQ-all')")
	@ApiOperation(value = "获取借调管理查询", tags = {"异动借调明细" } ,notes = "获取借调管理查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydjdmxes/fetchjdgldq")
	public ResponseEntity<List<PcmYdjdmxDTO>> fetchJDGLDQ(PcmYdjdmxSearchContext context) {
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDGLDQ(context) ;
        List<PcmYdjdmxDTO> list = pcmydjdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDGLDQ-all')")
	@ApiOperation(value = "查询借调管理查询", tags = {"异动借调明细" } ,notes = "查询借调管理查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydjdmxes/searchjdgldq")
	public ResponseEntity<Page<PcmYdjdmxDTO>> searchJDGLDQ(@RequestBody PcmYdjdmxSearchContext context) {
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDGLDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDLSJLDQ-all')")
	@ApiOperation(value = "获取借调历史记录查询", tags = {"异动借调明细" } ,notes = "获取借调历史记录查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydjdmxes/fetchjdlsjldq")
	public ResponseEntity<List<PcmYdjdmxDTO>> fetchJDLSJLDQ(PcmYdjdmxSearchContext context) {
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDLSJLDQ(context) ;
        List<PcmYdjdmxDTO> list = pcmydjdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDLSJLDQ-all')")
	@ApiOperation(value = "查询借调历史记录查询", tags = {"异动借调明细" } ,notes = "查询借调历史记录查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydjdmxes/searchjdlsjldq")
	public ResponseEntity<Page<PcmYdjdmxDTO>> searchJDLSJLDQ(@RequestBody PcmYdjdmxSearchContext context) {
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDLSJLDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"异动借调明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydjdmxes/fetchdefault")
	public ResponseEntity<List<PcmYdjdmxDTO>> fetchDefault(PcmYdjdmxSearchContext context) {
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchDefault(context) ;
        List<PcmYdjdmxDTO> list = pcmydjdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"异动借调明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydjdmxes/searchdefault")
	public ResponseEntity<Page<PcmYdjdmxDTO>> searchDefault(@RequestBody PcmYdjdmxSearchContext context) {
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(returnObject.body),'ehr-PcmYdjdmx-Get')")
    @ApiOperation(value = "根据职务管理获取异动借调明细", tags = {"异动借调明细" },  notes = "根据职务管理获取异动借调明细")
	@RequestMapping(method = RequestMethod.GET, value = "/ormduties/{ormduty_id}/pcmydjdmxes/{pcmydjdmx_id}")
    public ResponseEntity<PcmYdjdmxDTO> getByOrmDuty(@PathVariable("ormduty_id") String ormduty_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id) {
        PcmYdjdmx domain = pcmydjdmxService.get(pcmydjdmx_id);
        PcmYdjdmxDTO dto = pcmydjdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据职务管理获取异动借调明细草稿", tags = {"异动借调明细" },  notes = "根据职务管理获取异动借调明细草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ormduties/{ormduty_id}/pcmydjdmxes/getdraft")
    public ResponseEntity<PcmYdjdmxDTO> getDraftByOrmDuty(@PathVariable("ormduty_id") String ormduty_id) {
        PcmYdjdmx domain = new PcmYdjdmx();
        domain.setOrmdutyid(ormduty_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxMapping.toDto(pcmydjdmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.get(#pcmydjdmx_id),'ehr-PcmYdjdmx-Update')")
    @ApiOperation(value = "根据职务管理更新异动借调明细", tags = {"异动借调明细" },  notes = "根据职务管理更新异动借调明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormduties/{ormduty_id}/pcmydjdmxes/{pcmydjdmx_id}")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> updateByOrmDuty(@PathVariable("ormduty_id") String ormduty_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setOrmdutyid(ormduty_id);
        domain.setPcmydjdmxid(pcmydjdmx_id);
		pcmydjdmxService.update(domain);
        PcmYdjdmxDTO dto = pcmydjdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.getPcmydjdmxByEntities(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdtos)),'ehr-PcmYdjdmx-Update')")
    @ApiOperation(value = "根据职务管理批量更新异动借调明细", tags = {"异动借调明细" },  notes = "根据职务管理批量更新异动借调明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormduties/{ormduty_id}/pcmydjdmxes/batch")
    public ResponseEntity<Boolean> updateBatchByOrmDuty(@PathVariable("ormduty_id") String ormduty_id, @RequestBody List<PcmYdjdmxDTO> pcmydjdmxdtos) {
        List<PcmYdjdmx> domainlist=pcmydjdmxMapping.toDomain(pcmydjdmxdtos);
        for(PcmYdjdmx domain:domainlist){
            domain.setOrmdutyid(ormduty_id);
        }
        pcmydjdmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.get(#pcmydjdmx_id),'ehr-PcmYdjdmx-Remove')")
    @ApiOperation(value = "根据职务管理删除异动借调明细", tags = {"异动借调明细" },  notes = "根据职务管理删除异动借调明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormduties/{ormduty_id}/pcmydjdmxes/{pcmydjdmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmDuty(@PathVariable("ormduty_id") String ormduty_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxService.remove(pcmydjdmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.getPcmydjdmxByIds(#ids),'ehr-PcmYdjdmx-Remove')")
    @ApiOperation(value = "根据职务管理批量删除异动借调明细", tags = {"异动借调明细" },  notes = "根据职务管理批量删除异动借调明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormduties/{ormduty_id}/pcmydjdmxes/batch")
    public ResponseEntity<Boolean> removeBatchByOrmDuty(@RequestBody List<String> ids) {
        pcmydjdmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-PersonBack-all')")
    @ApiOperation(value = "根据职务管理异动借调明细", tags = {"异动借调明细" },  notes = "根据职务管理异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormduties/{ormduty_id}/pcmydjdmxes/{pcmydjdmx_id}/personback")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> personBackByOrmDuty(@PathVariable("ormduty_id") String ormduty_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setOrmdutyid(ormduty_id);
        domain = pcmydjdmxService.personBack(domain) ;
        pcmydjdmxdto = pcmydjdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-PersonInfo-all')")
    @ApiOperation(value = "根据职务管理异动借调明细", tags = {"异动借调明细" },  notes = "根据职务管理异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormduties/{ormduty_id}/pcmydjdmxes/{pcmydjdmx_id}/personinfo")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> personInfoByOrmDuty(@PathVariable("ormduty_id") String ormduty_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setOrmdutyid(ormduty_id);
        domain = pcmydjdmxService.personInfo(domain) ;
        pcmydjdmxdto = pcmydjdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxdto);
    }

    @ApiOperation(value = "根据职务管理检查异动借调明细", tags = {"异动借调明细" },  notes = "根据职务管理检查异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormduties/{ormduty_id}/pcmydjdmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmDuty(@PathVariable("ormduty_id") String ormduty_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxService.checkKey(pcmydjdmxMapping.toDomain(pcmydjdmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdto),'ehr-PcmYdjdmx-Save')")
    @ApiOperation(value = "根据职务管理保存异动借调明细", tags = {"异动借调明细" },  notes = "根据职务管理保存异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormduties/{ormduty_id}/pcmydjdmxes/save")
    public ResponseEntity<Boolean> saveByOrmDuty(@PathVariable("ormduty_id") String ormduty_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setOrmdutyid(ormduty_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdtos),'ehr-PcmYdjdmx-Save')")
    @ApiOperation(value = "根据职务管理批量保存异动借调明细", tags = {"异动借调明细" },  notes = "根据职务管理批量保存异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormduties/{ormduty_id}/pcmydjdmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmDuty(@PathVariable("ormduty_id") String ormduty_id, @RequestBody List<PcmYdjdmxDTO> pcmydjdmxdtos) {
        List<PcmYdjdmx> domainlist=pcmydjdmxMapping.toDomain(pcmydjdmxdtos);
        for(PcmYdjdmx domain:domainlist){
             domain.setOrmdutyid(ormduty_id);
        }
        pcmydjdmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdto),'ehr-PcmYdjdmx-Create')")
    @ApiOperation(value = "根据职务管理建立异动借调明细", tags = {"异动借调明细" },  notes = "根据职务管理建立异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormduties/{ormduty_id}/pcmydjdmxes")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> createByOrmDuty(@PathVariable("ormduty_id") String ormduty_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setOrmdutyid(ormduty_id);
		pcmydjdmxService.create(domain);
        PcmYdjdmxDTO dto = pcmydjdmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdtos),'ehr-PcmYdjdmx-Create')")
    @ApiOperation(value = "根据职务管理批量建立异动借调明细", tags = {"异动借调明细" },  notes = "根据职务管理批量建立异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormduties/{ormduty_id}/pcmydjdmxes/batch")
    public ResponseEntity<Boolean> createBatchByOrmDuty(@PathVariable("ormduty_id") String ormduty_id, @RequestBody List<PcmYdjdmxDTO> pcmydjdmxdtos) {
        List<PcmYdjdmx> domainlist=pcmydjdmxMapping.toDomain(pcmydjdmxdtos);
        for(PcmYdjdmx domain:domainlist){
            domain.setOrmdutyid(ormduty_id);
        }
        pcmydjdmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDGLDQ-all')")
	@ApiOperation(value = "根据职务管理获取借调管理查询", tags = {"异动借调明细" } ,notes = "根据职务管理获取借调管理查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormduties/{ormduty_id}/pcmydjdmxes/fetchjdgldq")
	public ResponseEntity<List<PcmYdjdmxDTO>> fetchPcmYdjdmxJDGLDQByOrmDuty(@PathVariable("ormduty_id") String ormduty_id,PcmYdjdmxSearchContext context) {
        context.setN_ormdutyid_eq(ormduty_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDGLDQ(context) ;
        List<PcmYdjdmxDTO> list = pcmydjdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDGLDQ-all')")
	@ApiOperation(value = "根据职务管理查询借调管理查询", tags = {"异动借调明细" } ,notes = "根据职务管理查询借调管理查询")
    @RequestMapping(method= RequestMethod.POST , value="/ormduties/{ormduty_id}/pcmydjdmxes/searchjdgldq")
	public ResponseEntity<Page<PcmYdjdmxDTO>> searchPcmYdjdmxJDGLDQByOrmDuty(@PathVariable("ormduty_id") String ormduty_id, @RequestBody PcmYdjdmxSearchContext context) {
        context.setN_ormdutyid_eq(ormduty_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDGLDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDLSJLDQ-all')")
	@ApiOperation(value = "根据职务管理获取借调历史记录查询", tags = {"异动借调明细" } ,notes = "根据职务管理获取借调历史记录查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormduties/{ormduty_id}/pcmydjdmxes/fetchjdlsjldq")
	public ResponseEntity<List<PcmYdjdmxDTO>> fetchPcmYdjdmxJDLSJLDQByOrmDuty(@PathVariable("ormduty_id") String ormduty_id,PcmYdjdmxSearchContext context) {
        context.setN_ormdutyid_eq(ormduty_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDLSJLDQ(context) ;
        List<PcmYdjdmxDTO> list = pcmydjdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDLSJLDQ-all')")
	@ApiOperation(value = "根据职务管理查询借调历史记录查询", tags = {"异动借调明细" } ,notes = "根据职务管理查询借调历史记录查询")
    @RequestMapping(method= RequestMethod.POST , value="/ormduties/{ormduty_id}/pcmydjdmxes/searchjdlsjldq")
	public ResponseEntity<Page<PcmYdjdmxDTO>> searchPcmYdjdmxJDLSJLDQByOrmDuty(@PathVariable("ormduty_id") String ormduty_id, @RequestBody PcmYdjdmxSearchContext context) {
        context.setN_ormdutyid_eq(ormduty_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDLSJLDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-Default-all')")
	@ApiOperation(value = "根据职务管理获取DEFAULT", tags = {"异动借调明细" } ,notes = "根据职务管理获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormduties/{ormduty_id}/pcmydjdmxes/fetchdefault")
	public ResponseEntity<List<PcmYdjdmxDTO>> fetchPcmYdjdmxDefaultByOrmDuty(@PathVariable("ormduty_id") String ormduty_id,PcmYdjdmxSearchContext context) {
        context.setN_ormdutyid_eq(ormduty_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchDefault(context) ;
        List<PcmYdjdmxDTO> list = pcmydjdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-Default-all')")
	@ApiOperation(value = "根据职务管理查询DEFAULT", tags = {"异动借调明细" } ,notes = "根据职务管理查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormduties/{ormduty_id}/pcmydjdmxes/searchdefault")
	public ResponseEntity<Page<PcmYdjdmxDTO>> searchPcmYdjdmxDefaultByOrmDuty(@PathVariable("ormduty_id") String ormduty_id, @RequestBody PcmYdjdmxSearchContext context) {
        context.setN_ormdutyid_eq(ormduty_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(returnObject.body),'ehr-PcmYdjdmx-Get')")
    @ApiOperation(value = "根据部门管理获取异动借调明细", tags = {"异动借调明细" },  notes = "根据部门管理获取异动借调明细")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/pcmydjdmxes/{pcmydjdmx_id}")
    public ResponseEntity<PcmYdjdmxDTO> getByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id) {
        PcmYdjdmx domain = pcmydjdmxService.get(pcmydjdmx_id);
        PcmYdjdmxDTO dto = pcmydjdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据部门管理获取异动借调明细草稿", tags = {"异动借调明细" },  notes = "根据部门管理获取异动借调明细草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/pcmydjdmxes/getdraft")
    public ResponseEntity<PcmYdjdmxDTO> getDraftByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id) {
        PcmYdjdmx domain = new PcmYdjdmx();
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxMapping.toDto(pcmydjdmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.get(#pcmydjdmx_id),'ehr-PcmYdjdmx-Update')")
    @ApiOperation(value = "根据部门管理更新异动借调明细", tags = {"异动借调明细" },  notes = "根据部门管理更新异动借调明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/pcmydjdmxes/{pcmydjdmx_id}")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> updateByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        domain.setPcmydjdmxid(pcmydjdmx_id);
		pcmydjdmxService.update(domain);
        PcmYdjdmxDTO dto = pcmydjdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.getPcmydjdmxByEntities(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdtos)),'ehr-PcmYdjdmx-Update')")
    @ApiOperation(value = "根据部门管理批量更新异动借调明细", tags = {"异动借调明细" },  notes = "根据部门管理批量更新异动借调明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/pcmydjdmxes/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<PcmYdjdmxDTO> pcmydjdmxdtos) {
        List<PcmYdjdmx> domainlist=pcmydjdmxMapping.toDomain(pcmydjdmxdtos);
        for(PcmYdjdmx domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        pcmydjdmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.get(#pcmydjdmx_id),'ehr-PcmYdjdmx-Remove')")
    @ApiOperation(value = "根据部门管理删除异动借调明细", tags = {"异动借调明细" },  notes = "根据部门管理删除异动借调明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/pcmydjdmxes/{pcmydjdmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxService.remove(pcmydjdmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.getPcmydjdmxByIds(#ids),'ehr-PcmYdjdmx-Remove')")
    @ApiOperation(value = "根据部门管理批量删除异动借调明细", tags = {"异动借调明细" },  notes = "根据部门管理批量删除异动借调明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/pcmydjdmxes/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgsector(@RequestBody List<String> ids) {
        pcmydjdmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-PersonBack-all')")
    @ApiOperation(value = "根据部门管理异动借调明细", tags = {"异动借调明细" },  notes = "根据部门管理异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/pcmydjdmxes/{pcmydjdmx_id}/personback")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> personBackByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        domain = pcmydjdmxService.personBack(domain) ;
        pcmydjdmxdto = pcmydjdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-PersonInfo-all')")
    @ApiOperation(value = "根据部门管理异动借调明细", tags = {"异动借调明细" },  notes = "根据部门管理异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/pcmydjdmxes/{pcmydjdmx_id}/personinfo")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> personInfoByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        domain = pcmydjdmxService.personInfo(domain) ;
        pcmydjdmxdto = pcmydjdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxdto);
    }

    @ApiOperation(value = "根据部门管理检查异动借调明细", tags = {"异动借调明细" },  notes = "根据部门管理检查异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/pcmydjdmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxService.checkKey(pcmydjdmxMapping.toDomain(pcmydjdmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdto),'ehr-PcmYdjdmx-Save')")
    @ApiOperation(value = "根据部门管理保存异动借调明细", tags = {"异动借调明细" },  notes = "根据部门管理保存异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/pcmydjdmxes/save")
    public ResponseEntity<Boolean> saveByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdtos),'ehr-PcmYdjdmx-Save')")
    @ApiOperation(value = "根据部门管理批量保存异动借调明细", tags = {"异动借调明细" },  notes = "根据部门管理批量保存异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/pcmydjdmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<PcmYdjdmxDTO> pcmydjdmxdtos) {
        List<PcmYdjdmx> domainlist=pcmydjdmxMapping.toDomain(pcmydjdmxdtos);
        for(PcmYdjdmx domain:domainlist){
             domain.setOrmorgsectorid(ormorgsector_id);
        }
        pcmydjdmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdto),'ehr-PcmYdjdmx-Create')")
    @ApiOperation(value = "根据部门管理建立异动借调明细", tags = {"异动借调明细" },  notes = "根据部门管理建立异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/pcmydjdmxes")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> createByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
		pcmydjdmxService.create(domain);
        PcmYdjdmxDTO dto = pcmydjdmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdtos),'ehr-PcmYdjdmx-Create')")
    @ApiOperation(value = "根据部门管理批量建立异动借调明细", tags = {"异动借调明细" },  notes = "根据部门管理批量建立异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/pcmydjdmxes/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<PcmYdjdmxDTO> pcmydjdmxdtos) {
        List<PcmYdjdmx> domainlist=pcmydjdmxMapping.toDomain(pcmydjdmxdtos);
        for(PcmYdjdmx domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        pcmydjdmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDGLDQ-all')")
	@ApiOperation(value = "根据部门管理获取借调管理查询", tags = {"异动借调明细" } ,notes = "根据部门管理获取借调管理查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/{ormorgsector_id}/pcmydjdmxes/fetchjdgldq")
	public ResponseEntity<List<PcmYdjdmxDTO>> fetchPcmYdjdmxJDGLDQByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id,PcmYdjdmxSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDGLDQ(context) ;
        List<PcmYdjdmxDTO> list = pcmydjdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDGLDQ-all')")
	@ApiOperation(value = "根据部门管理查询借调管理查询", tags = {"异动借调明细" } ,notes = "根据部门管理查询借调管理查询")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/{ormorgsector_id}/pcmydjdmxes/searchjdgldq")
	public ResponseEntity<Page<PcmYdjdmxDTO>> searchPcmYdjdmxJDGLDQByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody PcmYdjdmxSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDGLDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDLSJLDQ-all')")
	@ApiOperation(value = "根据部门管理获取借调历史记录查询", tags = {"异动借调明细" } ,notes = "根据部门管理获取借调历史记录查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/{ormorgsector_id}/pcmydjdmxes/fetchjdlsjldq")
	public ResponseEntity<List<PcmYdjdmxDTO>> fetchPcmYdjdmxJDLSJLDQByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id,PcmYdjdmxSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDLSJLDQ(context) ;
        List<PcmYdjdmxDTO> list = pcmydjdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDLSJLDQ-all')")
	@ApiOperation(value = "根据部门管理查询借调历史记录查询", tags = {"异动借调明细" } ,notes = "根据部门管理查询借调历史记录查询")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/{ormorgsector_id}/pcmydjdmxes/searchjdlsjldq")
	public ResponseEntity<Page<PcmYdjdmxDTO>> searchPcmYdjdmxJDLSJLDQByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody PcmYdjdmxSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDLSJLDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-Default-all')")
	@ApiOperation(value = "根据部门管理获取DEFAULT", tags = {"异动借调明细" } ,notes = "根据部门管理获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/{ormorgsector_id}/pcmydjdmxes/fetchdefault")
	public ResponseEntity<List<PcmYdjdmxDTO>> fetchPcmYdjdmxDefaultByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id,PcmYdjdmxSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchDefault(context) ;
        List<PcmYdjdmxDTO> list = pcmydjdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-Default-all')")
	@ApiOperation(value = "根据部门管理查询DEFAULT", tags = {"异动借调明细" } ,notes = "根据部门管理查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/{ormorgsector_id}/pcmydjdmxes/searchdefault")
	public ResponseEntity<Page<PcmYdjdmxDTO>> searchPcmYdjdmxDefaultByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody PcmYdjdmxSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(returnObject.body),'ehr-PcmYdjdmx-Get')")
    @ApiOperation(value = "根据组织管理获取异动借调明细", tags = {"异动借调明细" },  notes = "根据组织管理获取异动借调明细")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/pcmydjdmxes/{pcmydjdmx_id}")
    public ResponseEntity<PcmYdjdmxDTO> getByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id) {
        PcmYdjdmx domain = pcmydjdmxService.get(pcmydjdmx_id);
        PcmYdjdmxDTO dto = pcmydjdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据组织管理获取异动借调明细草稿", tags = {"异动借调明细" },  notes = "根据组织管理获取异动借调明细草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/pcmydjdmxes/getdraft")
    public ResponseEntity<PcmYdjdmxDTO> getDraftByOrmOrg(@PathVariable("ormorg_id") String ormorg_id) {
        PcmYdjdmx domain = new PcmYdjdmx();
        domain.setOrmorgid(ormorg_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxMapping.toDto(pcmydjdmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.get(#pcmydjdmx_id),'ehr-PcmYdjdmx-Update')")
    @ApiOperation(value = "根据组织管理更新异动借调明细", tags = {"异动借调明细" },  notes = "根据组织管理更新异动借调明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/pcmydjdmxes/{pcmydjdmx_id}")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> updateByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setOrmorgid(ormorg_id);
        domain.setPcmydjdmxid(pcmydjdmx_id);
		pcmydjdmxService.update(domain);
        PcmYdjdmxDTO dto = pcmydjdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.getPcmydjdmxByEntities(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdtos)),'ehr-PcmYdjdmx-Update')")
    @ApiOperation(value = "根据组织管理批量更新异动借调明细", tags = {"异动借调明细" },  notes = "根据组织管理批量更新异动借调明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/pcmydjdmxes/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody List<PcmYdjdmxDTO> pcmydjdmxdtos) {
        List<PcmYdjdmx> domainlist=pcmydjdmxMapping.toDomain(pcmydjdmxdtos);
        for(PcmYdjdmx domain:domainlist){
            domain.setOrmorgid(ormorg_id);
        }
        pcmydjdmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.get(#pcmydjdmx_id),'ehr-PcmYdjdmx-Remove')")
    @ApiOperation(value = "根据组织管理删除异动借调明细", tags = {"异动借调明细" },  notes = "根据组织管理删除异动借调明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/pcmydjdmxes/{pcmydjdmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxService.remove(pcmydjdmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.getPcmydjdmxByIds(#ids),'ehr-PcmYdjdmx-Remove')")
    @ApiOperation(value = "根据组织管理批量删除异动借调明细", tags = {"异动借调明细" },  notes = "根据组织管理批量删除异动借调明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/pcmydjdmxes/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrg(@RequestBody List<String> ids) {
        pcmydjdmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-PersonBack-all')")
    @ApiOperation(value = "根据组织管理异动借调明细", tags = {"异动借调明细" },  notes = "根据组织管理异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/pcmydjdmxes/{pcmydjdmx_id}/personback")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> personBackByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setOrmorgid(ormorg_id);
        domain = pcmydjdmxService.personBack(domain) ;
        pcmydjdmxdto = pcmydjdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-PersonInfo-all')")
    @ApiOperation(value = "根据组织管理异动借调明细", tags = {"异动借调明细" },  notes = "根据组织管理异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/pcmydjdmxes/{pcmydjdmx_id}/personinfo")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> personInfoByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setOrmorgid(ormorg_id);
        domain = pcmydjdmxService.personInfo(domain) ;
        pcmydjdmxdto = pcmydjdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxdto);
    }

    @ApiOperation(value = "根据组织管理检查异动借调明细", tags = {"异动借调明细" },  notes = "根据组织管理检查异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/pcmydjdmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxService.checkKey(pcmydjdmxMapping.toDomain(pcmydjdmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdto),'ehr-PcmYdjdmx-Save')")
    @ApiOperation(value = "根据组织管理保存异动借调明细", tags = {"异动借调明细" },  notes = "根据组织管理保存异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/pcmydjdmxes/save")
    public ResponseEntity<Boolean> saveByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setOrmorgid(ormorg_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdtos),'ehr-PcmYdjdmx-Save')")
    @ApiOperation(value = "根据组织管理批量保存异动借调明细", tags = {"异动借调明细" },  notes = "根据组织管理批量保存异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/pcmydjdmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody List<PcmYdjdmxDTO> pcmydjdmxdtos) {
        List<PcmYdjdmx> domainlist=pcmydjdmxMapping.toDomain(pcmydjdmxdtos);
        for(PcmYdjdmx domain:domainlist){
             domain.setOrmorgid(ormorg_id);
        }
        pcmydjdmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdto),'ehr-PcmYdjdmx-Create')")
    @ApiOperation(value = "根据组织管理建立异动借调明细", tags = {"异动借调明细" },  notes = "根据组织管理建立异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/pcmydjdmxes")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> createByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setOrmorgid(ormorg_id);
		pcmydjdmxService.create(domain);
        PcmYdjdmxDTO dto = pcmydjdmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdtos),'ehr-PcmYdjdmx-Create')")
    @ApiOperation(value = "根据组织管理批量建立异动借调明细", tags = {"异动借调明细" },  notes = "根据组织管理批量建立异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/pcmydjdmxes/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody List<PcmYdjdmxDTO> pcmydjdmxdtos) {
        List<PcmYdjdmx> domainlist=pcmydjdmxMapping.toDomain(pcmydjdmxdtos);
        for(PcmYdjdmx domain:domainlist){
            domain.setOrmorgid(ormorg_id);
        }
        pcmydjdmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDGLDQ-all')")
	@ApiOperation(value = "根据组织管理获取借调管理查询", tags = {"异动借调明细" } ,notes = "根据组织管理获取借调管理查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/pcmydjdmxes/fetchjdgldq")
	public ResponseEntity<List<PcmYdjdmxDTO>> fetchPcmYdjdmxJDGLDQByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,PcmYdjdmxSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDGLDQ(context) ;
        List<PcmYdjdmxDTO> list = pcmydjdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDGLDQ-all')")
	@ApiOperation(value = "根据组织管理查询借调管理查询", tags = {"异动借调明细" } ,notes = "根据组织管理查询借调管理查询")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/pcmydjdmxes/searchjdgldq")
	public ResponseEntity<Page<PcmYdjdmxDTO>> searchPcmYdjdmxJDGLDQByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody PcmYdjdmxSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDGLDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDLSJLDQ-all')")
	@ApiOperation(value = "根据组织管理获取借调历史记录查询", tags = {"异动借调明细" } ,notes = "根据组织管理获取借调历史记录查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/pcmydjdmxes/fetchjdlsjldq")
	public ResponseEntity<List<PcmYdjdmxDTO>> fetchPcmYdjdmxJDLSJLDQByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,PcmYdjdmxSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDLSJLDQ(context) ;
        List<PcmYdjdmxDTO> list = pcmydjdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDLSJLDQ-all')")
	@ApiOperation(value = "根据组织管理查询借调历史记录查询", tags = {"异动借调明细" } ,notes = "根据组织管理查询借调历史记录查询")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/pcmydjdmxes/searchjdlsjldq")
	public ResponseEntity<Page<PcmYdjdmxDTO>> searchPcmYdjdmxJDLSJLDQByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody PcmYdjdmxSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDLSJLDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-Default-all')")
	@ApiOperation(value = "根据组织管理获取DEFAULT", tags = {"异动借调明细" } ,notes = "根据组织管理获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/pcmydjdmxes/fetchdefault")
	public ResponseEntity<List<PcmYdjdmxDTO>> fetchPcmYdjdmxDefaultByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,PcmYdjdmxSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchDefault(context) ;
        List<PcmYdjdmxDTO> list = pcmydjdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-Default-all')")
	@ApiOperation(value = "根据组织管理查询DEFAULT", tags = {"异动借调明细" } ,notes = "根据组织管理查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/pcmydjdmxes/searchdefault")
	public ResponseEntity<Page<PcmYdjdmxDTO>> searchPcmYdjdmxDefaultByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody PcmYdjdmxSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(returnObject.body),'ehr-PcmYdjdmx-Get')")
    @ApiOperation(value = "根据岗位获取异动借调明细", tags = {"异动借调明细" },  notes = "根据岗位获取异动借调明细")
	@RequestMapping(method = RequestMethod.GET, value = "/ormposts/{ormpost_id}/pcmydjdmxes/{pcmydjdmx_id}")
    public ResponseEntity<PcmYdjdmxDTO> getByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id) {
        PcmYdjdmx domain = pcmydjdmxService.get(pcmydjdmx_id);
        PcmYdjdmxDTO dto = pcmydjdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据岗位获取异动借调明细草稿", tags = {"异动借调明细" },  notes = "根据岗位获取异动借调明细草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ormposts/{ormpost_id}/pcmydjdmxes/getdraft")
    public ResponseEntity<PcmYdjdmxDTO> getDraftByOrmPost(@PathVariable("ormpost_id") String ormpost_id) {
        PcmYdjdmx domain = new PcmYdjdmx();
        domain.setOrmpostid(ormpost_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxMapping.toDto(pcmydjdmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.get(#pcmydjdmx_id),'ehr-PcmYdjdmx-Update')")
    @ApiOperation(value = "根据岗位更新异动借调明细", tags = {"异动借调明细" },  notes = "根据岗位更新异动借调明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormposts/{ormpost_id}/pcmydjdmxes/{pcmydjdmx_id}")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> updateByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setOrmpostid(ormpost_id);
        domain.setPcmydjdmxid(pcmydjdmx_id);
		pcmydjdmxService.update(domain);
        PcmYdjdmxDTO dto = pcmydjdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.getPcmydjdmxByEntities(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdtos)),'ehr-PcmYdjdmx-Update')")
    @ApiOperation(value = "根据岗位批量更新异动借调明细", tags = {"异动借调明细" },  notes = "根据岗位批量更新异动借调明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormposts/{ormpost_id}/pcmydjdmxes/batch")
    public ResponseEntity<Boolean> updateBatchByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @RequestBody List<PcmYdjdmxDTO> pcmydjdmxdtos) {
        List<PcmYdjdmx> domainlist=pcmydjdmxMapping.toDomain(pcmydjdmxdtos);
        for(PcmYdjdmx domain:domainlist){
            domain.setOrmpostid(ormpost_id);
        }
        pcmydjdmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.get(#pcmydjdmx_id),'ehr-PcmYdjdmx-Remove')")
    @ApiOperation(value = "根据岗位删除异动借调明细", tags = {"异动借调明细" },  notes = "根据岗位删除异动借调明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormposts/{ormpost_id}/pcmydjdmxes/{pcmydjdmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxService.remove(pcmydjdmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.getPcmydjdmxByIds(#ids),'ehr-PcmYdjdmx-Remove')")
    @ApiOperation(value = "根据岗位批量删除异动借调明细", tags = {"异动借调明细" },  notes = "根据岗位批量删除异动借调明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormposts/{ormpost_id}/pcmydjdmxes/batch")
    public ResponseEntity<Boolean> removeBatchByOrmPost(@RequestBody List<String> ids) {
        pcmydjdmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-PersonBack-all')")
    @ApiOperation(value = "根据岗位异动借调明细", tags = {"异动借调明细" },  notes = "根据岗位异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/pcmydjdmxes/{pcmydjdmx_id}/personback")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> personBackByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setOrmpostid(ormpost_id);
        domain = pcmydjdmxService.personBack(domain) ;
        pcmydjdmxdto = pcmydjdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-PersonInfo-all')")
    @ApiOperation(value = "根据岗位异动借调明细", tags = {"异动借调明细" },  notes = "根据岗位异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/pcmydjdmxes/{pcmydjdmx_id}/personinfo")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> personInfoByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setOrmpostid(ormpost_id);
        domain = pcmydjdmxService.personInfo(domain) ;
        pcmydjdmxdto = pcmydjdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxdto);
    }

    @ApiOperation(value = "根据岗位检查异动借调明细", tags = {"异动借调明细" },  notes = "根据岗位检查异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/pcmydjdmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxService.checkKey(pcmydjdmxMapping.toDomain(pcmydjdmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdto),'ehr-PcmYdjdmx-Save')")
    @ApiOperation(value = "根据岗位保存异动借调明细", tags = {"异动借调明细" },  notes = "根据岗位保存异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/pcmydjdmxes/save")
    public ResponseEntity<Boolean> saveByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setOrmpostid(ormpost_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdtos),'ehr-PcmYdjdmx-Save')")
    @ApiOperation(value = "根据岗位批量保存异动借调明细", tags = {"异动借调明细" },  notes = "根据岗位批量保存异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/pcmydjdmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @RequestBody List<PcmYdjdmxDTO> pcmydjdmxdtos) {
        List<PcmYdjdmx> domainlist=pcmydjdmxMapping.toDomain(pcmydjdmxdtos);
        for(PcmYdjdmx domain:domainlist){
             domain.setOrmpostid(ormpost_id);
        }
        pcmydjdmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdto),'ehr-PcmYdjdmx-Create')")
    @ApiOperation(value = "根据岗位建立异动借调明细", tags = {"异动借调明细" },  notes = "根据岗位建立异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/pcmydjdmxes")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> createByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setOrmpostid(ormpost_id);
		pcmydjdmxService.create(domain);
        PcmYdjdmxDTO dto = pcmydjdmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdtos),'ehr-PcmYdjdmx-Create')")
    @ApiOperation(value = "根据岗位批量建立异动借调明细", tags = {"异动借调明细" },  notes = "根据岗位批量建立异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/pcmydjdmxes/batch")
    public ResponseEntity<Boolean> createBatchByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @RequestBody List<PcmYdjdmxDTO> pcmydjdmxdtos) {
        List<PcmYdjdmx> domainlist=pcmydjdmxMapping.toDomain(pcmydjdmxdtos);
        for(PcmYdjdmx domain:domainlist){
            domain.setOrmpostid(ormpost_id);
        }
        pcmydjdmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDGLDQ-all')")
	@ApiOperation(value = "根据岗位获取借调管理查询", tags = {"异动借调明细" } ,notes = "根据岗位获取借调管理查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormposts/{ormpost_id}/pcmydjdmxes/fetchjdgldq")
	public ResponseEntity<List<PcmYdjdmxDTO>> fetchPcmYdjdmxJDGLDQByOrmPost(@PathVariable("ormpost_id") String ormpost_id,PcmYdjdmxSearchContext context) {
        context.setN_ormpostid_eq(ormpost_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDGLDQ(context) ;
        List<PcmYdjdmxDTO> list = pcmydjdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDGLDQ-all')")
	@ApiOperation(value = "根据岗位查询借调管理查询", tags = {"异动借调明细" } ,notes = "根据岗位查询借调管理查询")
    @RequestMapping(method= RequestMethod.POST , value="/ormposts/{ormpost_id}/pcmydjdmxes/searchjdgldq")
	public ResponseEntity<Page<PcmYdjdmxDTO>> searchPcmYdjdmxJDGLDQByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @RequestBody PcmYdjdmxSearchContext context) {
        context.setN_ormpostid_eq(ormpost_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDGLDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDLSJLDQ-all')")
	@ApiOperation(value = "根据岗位获取借调历史记录查询", tags = {"异动借调明细" } ,notes = "根据岗位获取借调历史记录查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormposts/{ormpost_id}/pcmydjdmxes/fetchjdlsjldq")
	public ResponseEntity<List<PcmYdjdmxDTO>> fetchPcmYdjdmxJDLSJLDQByOrmPost(@PathVariable("ormpost_id") String ormpost_id,PcmYdjdmxSearchContext context) {
        context.setN_ormpostid_eq(ormpost_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDLSJLDQ(context) ;
        List<PcmYdjdmxDTO> list = pcmydjdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDLSJLDQ-all')")
	@ApiOperation(value = "根据岗位查询借调历史记录查询", tags = {"异动借调明细" } ,notes = "根据岗位查询借调历史记录查询")
    @RequestMapping(method= RequestMethod.POST , value="/ormposts/{ormpost_id}/pcmydjdmxes/searchjdlsjldq")
	public ResponseEntity<Page<PcmYdjdmxDTO>> searchPcmYdjdmxJDLSJLDQByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @RequestBody PcmYdjdmxSearchContext context) {
        context.setN_ormpostid_eq(ormpost_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDLSJLDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-Default-all')")
	@ApiOperation(value = "根据岗位获取DEFAULT", tags = {"异动借调明细" } ,notes = "根据岗位获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormposts/{ormpost_id}/pcmydjdmxes/fetchdefault")
	public ResponseEntity<List<PcmYdjdmxDTO>> fetchPcmYdjdmxDefaultByOrmPost(@PathVariable("ormpost_id") String ormpost_id,PcmYdjdmxSearchContext context) {
        context.setN_ormpostid_eq(ormpost_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchDefault(context) ;
        List<PcmYdjdmxDTO> list = pcmydjdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-Default-all')")
	@ApiOperation(value = "根据岗位查询DEFAULT", tags = {"异动借调明细" } ,notes = "根据岗位查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormposts/{ormpost_id}/pcmydjdmxes/searchdefault")
	public ResponseEntity<Page<PcmYdjdmxDTO>> searchPcmYdjdmxDefaultByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @RequestBody PcmYdjdmxSearchContext context) {
        context.setN_ormpostid_eq(ormpost_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(returnObject.body),'ehr-PcmYdjdmx-Get')")
    @ApiOperation(value = "根据分配信息获取异动借调明细", tags = {"异动借调明细" },  notes = "根据分配信息获取异动借调明细")
	@RequestMapping(method = RequestMethod.GET, value = "/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes/{pcmydjdmx_id}")
    public ResponseEntity<PcmYdjdmxDTO> getByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id) {
        PcmYdjdmx domain = pcmydjdmxService.get(pcmydjdmx_id);
        PcmYdjdmxDTO dto = pcmydjdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据分配信息获取异动借调明细草稿", tags = {"异动借调明细" },  notes = "根据分配信息获取异动借调明细草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes/getdraft")
    public ResponseEntity<PcmYdjdmxDTO> getDraftByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id) {
        PcmYdjdmx domain = new PcmYdjdmx();
        domain.setPimdistirbutionid(pimdistirbution_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxMapping.toDto(pcmydjdmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.get(#pcmydjdmx_id),'ehr-PcmYdjdmx-Update')")
    @ApiOperation(value = "根据分配信息更新异动借调明细", tags = {"异动借调明细" },  notes = "根据分配信息更新异动借调明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes/{pcmydjdmx_id}")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> updateByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain.setPcmydjdmxid(pcmydjdmx_id);
		pcmydjdmxService.update(domain);
        PcmYdjdmxDTO dto = pcmydjdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.getPcmydjdmxByEntities(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdtos)),'ehr-PcmYdjdmx-Update')")
    @ApiOperation(value = "根据分配信息批量更新异动借调明细", tags = {"异动借调明细" },  notes = "根据分配信息批量更新异动借调明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes/batch")
    public ResponseEntity<Boolean> updateBatchByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody List<PcmYdjdmxDTO> pcmydjdmxdtos) {
        List<PcmYdjdmx> domainlist=pcmydjdmxMapping.toDomain(pcmydjdmxdtos);
        for(PcmYdjdmx domain:domainlist){
            domain.setPimdistirbutionid(pimdistirbution_id);
        }
        pcmydjdmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.get(#pcmydjdmx_id),'ehr-PcmYdjdmx-Remove')")
    @ApiOperation(value = "根据分配信息删除异动借调明细", tags = {"异动借调明细" },  notes = "根据分配信息删除异动借调明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes/{pcmydjdmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxService.remove(pcmydjdmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.getPcmydjdmxByIds(#ids),'ehr-PcmYdjdmx-Remove')")
    @ApiOperation(value = "根据分配信息批量删除异动借调明细", tags = {"异动借调明细" },  notes = "根据分配信息批量删除异动借调明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes/batch")
    public ResponseEntity<Boolean> removeBatchByPimDistirbution(@RequestBody List<String> ids) {
        pcmydjdmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-PersonBack-all')")
    @ApiOperation(value = "根据分配信息异动借调明细", tags = {"异动借调明细" },  notes = "根据分配信息异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes/{pcmydjdmx_id}/personback")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> personBackByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain = pcmydjdmxService.personBack(domain) ;
        pcmydjdmxdto = pcmydjdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-PersonInfo-all')")
    @ApiOperation(value = "根据分配信息异动借调明细", tags = {"异动借调明细" },  notes = "根据分配信息异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes/{pcmydjdmx_id}/personinfo")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> personInfoByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain = pcmydjdmxService.personInfo(domain) ;
        pcmydjdmxdto = pcmydjdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxdto);
    }

    @ApiOperation(value = "根据分配信息检查异动借调明细", tags = {"异动借调明细" },  notes = "根据分配信息检查异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxService.checkKey(pcmydjdmxMapping.toDomain(pcmydjdmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdto),'ehr-PcmYdjdmx-Save')")
    @ApiOperation(value = "根据分配信息保存异动借调明细", tags = {"异动借调明细" },  notes = "根据分配信息保存异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes/save")
    public ResponseEntity<Boolean> saveByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdtos),'ehr-PcmYdjdmx-Save')")
    @ApiOperation(value = "根据分配信息批量保存异动借调明细", tags = {"异动借调明细" },  notes = "根据分配信息批量保存异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody List<PcmYdjdmxDTO> pcmydjdmxdtos) {
        List<PcmYdjdmx> domainlist=pcmydjdmxMapping.toDomain(pcmydjdmxdtos);
        for(PcmYdjdmx domain:domainlist){
             domain.setPimdistirbutionid(pimdistirbution_id);
        }
        pcmydjdmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdto),'ehr-PcmYdjdmx-Create')")
    @ApiOperation(value = "根据分配信息建立异动借调明细", tags = {"异动借调明细" },  notes = "根据分配信息建立异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> createByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
		pcmydjdmxService.create(domain);
        PcmYdjdmxDTO dto = pcmydjdmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdtos),'ehr-PcmYdjdmx-Create')")
    @ApiOperation(value = "根据分配信息批量建立异动借调明细", tags = {"异动借调明细" },  notes = "根据分配信息批量建立异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes/batch")
    public ResponseEntity<Boolean> createBatchByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody List<PcmYdjdmxDTO> pcmydjdmxdtos) {
        List<PcmYdjdmx> domainlist=pcmydjdmxMapping.toDomain(pcmydjdmxdtos);
        for(PcmYdjdmx domain:domainlist){
            domain.setPimdistirbutionid(pimdistirbution_id);
        }
        pcmydjdmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDGLDQ-all')")
	@ApiOperation(value = "根据分配信息获取借调管理查询", tags = {"异动借调明细" } ,notes = "根据分配信息获取借调管理查询")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes/fetchjdgldq")
	public ResponseEntity<List<PcmYdjdmxDTO>> fetchPcmYdjdmxJDGLDQByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id,PcmYdjdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDGLDQ(context) ;
        List<PcmYdjdmxDTO> list = pcmydjdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDGLDQ-all')")
	@ApiOperation(value = "根据分配信息查询借调管理查询", tags = {"异动借调明细" } ,notes = "根据分配信息查询借调管理查询")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes/searchjdgldq")
	public ResponseEntity<Page<PcmYdjdmxDTO>> searchPcmYdjdmxJDGLDQByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PcmYdjdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDGLDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDLSJLDQ-all')")
	@ApiOperation(value = "根据分配信息获取借调历史记录查询", tags = {"异动借调明细" } ,notes = "根据分配信息获取借调历史记录查询")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes/fetchjdlsjldq")
	public ResponseEntity<List<PcmYdjdmxDTO>> fetchPcmYdjdmxJDLSJLDQByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id,PcmYdjdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDLSJLDQ(context) ;
        List<PcmYdjdmxDTO> list = pcmydjdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDLSJLDQ-all')")
	@ApiOperation(value = "根据分配信息查询借调历史记录查询", tags = {"异动借调明细" } ,notes = "根据分配信息查询借调历史记录查询")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes/searchjdlsjldq")
	public ResponseEntity<Page<PcmYdjdmxDTO>> searchPcmYdjdmxJDLSJLDQByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PcmYdjdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDLSJLDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-Default-all')")
	@ApiOperation(value = "根据分配信息获取DEFAULT", tags = {"异动借调明细" } ,notes = "根据分配信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes/fetchdefault")
	public ResponseEntity<List<PcmYdjdmxDTO>> fetchPcmYdjdmxDefaultByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id,PcmYdjdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchDefault(context) ;
        List<PcmYdjdmxDTO> list = pcmydjdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-Default-all')")
	@ApiOperation(value = "根据分配信息查询DEFAULT", tags = {"异动借调明细" } ,notes = "根据分配信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes/searchdefault")
	public ResponseEntity<Page<PcmYdjdmxDTO>> searchPcmYdjdmxDefaultByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PcmYdjdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(returnObject.body),'ehr-PcmYdjdmx-Get')")
    @ApiOperation(value = "根据组织管理部门管理获取异动借调明细", tags = {"异动借调明细" },  notes = "根据组织管理部门管理获取异动借调明细")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/pcmydjdmxes/{pcmydjdmx_id}")
    public ResponseEntity<PcmYdjdmxDTO> getByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id) {
        PcmYdjdmx domain = pcmydjdmxService.get(pcmydjdmx_id);
        PcmYdjdmxDTO dto = pcmydjdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据组织管理部门管理获取异动借调明细草稿", tags = {"异动借调明细" },  notes = "根据组织管理部门管理获取异动借调明细草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/pcmydjdmxes/getdraft")
    public ResponseEntity<PcmYdjdmxDTO> getDraftByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id) {
        PcmYdjdmx domain = new PcmYdjdmx();
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxMapping.toDto(pcmydjdmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.get(#pcmydjdmx_id),'ehr-PcmYdjdmx-Update')")
    @ApiOperation(value = "根据组织管理部门管理更新异动借调明细", tags = {"异动借调明细" },  notes = "根据组织管理部门管理更新异动借调明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/pcmydjdmxes/{pcmydjdmx_id}")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> updateByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        domain.setPcmydjdmxid(pcmydjdmx_id);
		pcmydjdmxService.update(domain);
        PcmYdjdmxDTO dto = pcmydjdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.getPcmydjdmxByEntities(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdtos)),'ehr-PcmYdjdmx-Update')")
    @ApiOperation(value = "根据组织管理部门管理批量更新异动借调明细", tags = {"异动借调明细" },  notes = "根据组织管理部门管理批量更新异动借调明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/pcmydjdmxes/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<PcmYdjdmxDTO> pcmydjdmxdtos) {
        List<PcmYdjdmx> domainlist=pcmydjdmxMapping.toDomain(pcmydjdmxdtos);
        for(PcmYdjdmx domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        pcmydjdmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.get(#pcmydjdmx_id),'ehr-PcmYdjdmx-Remove')")
    @ApiOperation(value = "根据组织管理部门管理删除异动借调明细", tags = {"异动借调明细" },  notes = "根据组织管理部门管理删除异动借调明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/pcmydjdmxes/{pcmydjdmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxService.remove(pcmydjdmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.getPcmydjdmxByIds(#ids),'ehr-PcmYdjdmx-Remove')")
    @ApiOperation(value = "根据组织管理部门管理批量删除异动借调明细", tags = {"异动借调明细" },  notes = "根据组织管理部门管理批量删除异动借调明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/pcmydjdmxes/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgOrmOrgsector(@RequestBody List<String> ids) {
        pcmydjdmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-PersonBack-all')")
    @ApiOperation(value = "根据组织管理部门管理异动借调明细", tags = {"异动借调明细" },  notes = "根据组织管理部门管理异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/pcmydjdmxes/{pcmydjdmx_id}/personback")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> personBackByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        domain = pcmydjdmxService.personBack(domain) ;
        pcmydjdmxdto = pcmydjdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-PersonInfo-all')")
    @ApiOperation(value = "根据组织管理部门管理异动借调明细", tags = {"异动借调明细" },  notes = "根据组织管理部门管理异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/pcmydjdmxes/{pcmydjdmx_id}/personinfo")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> personInfoByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        domain = pcmydjdmxService.personInfo(domain) ;
        pcmydjdmxdto = pcmydjdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxdto);
    }

    @ApiOperation(value = "根据组织管理部门管理检查异动借调明细", tags = {"异动借调明细" },  notes = "根据组织管理部门管理检查异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/pcmydjdmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxService.checkKey(pcmydjdmxMapping.toDomain(pcmydjdmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdto),'ehr-PcmYdjdmx-Save')")
    @ApiOperation(value = "根据组织管理部门管理保存异动借调明细", tags = {"异动借调明细" },  notes = "根据组织管理部门管理保存异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/pcmydjdmxes/save")
    public ResponseEntity<Boolean> saveByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdtos),'ehr-PcmYdjdmx-Save')")
    @ApiOperation(value = "根据组织管理部门管理批量保存异动借调明细", tags = {"异动借调明细" },  notes = "根据组织管理部门管理批量保存异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/pcmydjdmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<PcmYdjdmxDTO> pcmydjdmxdtos) {
        List<PcmYdjdmx> domainlist=pcmydjdmxMapping.toDomain(pcmydjdmxdtos);
        for(PcmYdjdmx domain:domainlist){
             domain.setOrmorgsectorid(ormorgsector_id);
        }
        pcmydjdmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdto),'ehr-PcmYdjdmx-Create')")
    @ApiOperation(value = "根据组织管理部门管理建立异动借调明细", tags = {"异动借调明细" },  notes = "根据组织管理部门管理建立异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/pcmydjdmxes")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> createByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
		pcmydjdmxService.create(domain);
        PcmYdjdmxDTO dto = pcmydjdmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdtos),'ehr-PcmYdjdmx-Create')")
    @ApiOperation(value = "根据组织管理部门管理批量建立异动借调明细", tags = {"异动借调明细" },  notes = "根据组织管理部门管理批量建立异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/pcmydjdmxes/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<PcmYdjdmxDTO> pcmydjdmxdtos) {
        List<PcmYdjdmx> domainlist=pcmydjdmxMapping.toDomain(pcmydjdmxdtos);
        for(PcmYdjdmx domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        pcmydjdmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDGLDQ-all')")
	@ApiOperation(value = "根据组织管理部门管理获取借调管理查询", tags = {"异动借调明细" } ,notes = "根据组织管理部门管理获取借调管理查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/pcmydjdmxes/fetchjdgldq")
	public ResponseEntity<List<PcmYdjdmxDTO>> fetchPcmYdjdmxJDGLDQByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id,PcmYdjdmxSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDGLDQ(context) ;
        List<PcmYdjdmxDTO> list = pcmydjdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDGLDQ-all')")
	@ApiOperation(value = "根据组织管理部门管理查询借调管理查询", tags = {"异动借调明细" } ,notes = "根据组织管理部门管理查询借调管理查询")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/pcmydjdmxes/searchjdgldq")
	public ResponseEntity<Page<PcmYdjdmxDTO>> searchPcmYdjdmxJDGLDQByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody PcmYdjdmxSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDGLDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDLSJLDQ-all')")
	@ApiOperation(value = "根据组织管理部门管理获取借调历史记录查询", tags = {"异动借调明细" } ,notes = "根据组织管理部门管理获取借调历史记录查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/pcmydjdmxes/fetchjdlsjldq")
	public ResponseEntity<List<PcmYdjdmxDTO>> fetchPcmYdjdmxJDLSJLDQByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id,PcmYdjdmxSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDLSJLDQ(context) ;
        List<PcmYdjdmxDTO> list = pcmydjdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDLSJLDQ-all')")
	@ApiOperation(value = "根据组织管理部门管理查询借调历史记录查询", tags = {"异动借调明细" } ,notes = "根据组织管理部门管理查询借调历史记录查询")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/pcmydjdmxes/searchjdlsjldq")
	public ResponseEntity<Page<PcmYdjdmxDTO>> searchPcmYdjdmxJDLSJLDQByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody PcmYdjdmxSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDLSJLDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-Default-all')")
	@ApiOperation(value = "根据组织管理部门管理获取DEFAULT", tags = {"异动借调明细" } ,notes = "根据组织管理部门管理获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/pcmydjdmxes/fetchdefault")
	public ResponseEntity<List<PcmYdjdmxDTO>> fetchPcmYdjdmxDefaultByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id,PcmYdjdmxSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchDefault(context) ;
        List<PcmYdjdmxDTO> list = pcmydjdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-Default-all')")
	@ApiOperation(value = "根据组织管理部门管理查询DEFAULT", tags = {"异动借调明细" } ,notes = "根据组织管理部门管理查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/pcmydjdmxes/searchdefault")
	public ResponseEntity<Page<PcmYdjdmxDTO>> searchPcmYdjdmxDefaultByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody PcmYdjdmxSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(returnObject.body),'ehr-PcmYdjdmx-Get')")
    @ApiOperation(value = "根据组织管理岗位获取异动借调明细", tags = {"异动借调明细" },  notes = "根据组织管理岗位获取异动借调明细")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/pcmydjdmxes/{pcmydjdmx_id}")
    public ResponseEntity<PcmYdjdmxDTO> getByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id) {
        PcmYdjdmx domain = pcmydjdmxService.get(pcmydjdmx_id);
        PcmYdjdmxDTO dto = pcmydjdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据组织管理岗位获取异动借调明细草稿", tags = {"异动借调明细" },  notes = "根据组织管理岗位获取异动借调明细草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/pcmydjdmxes/getdraft")
    public ResponseEntity<PcmYdjdmxDTO> getDraftByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id) {
        PcmYdjdmx domain = new PcmYdjdmx();
        domain.setOrmpostid(ormpost_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxMapping.toDto(pcmydjdmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.get(#pcmydjdmx_id),'ehr-PcmYdjdmx-Update')")
    @ApiOperation(value = "根据组织管理岗位更新异动借调明细", tags = {"异动借调明细" },  notes = "根据组织管理岗位更新异动借调明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/pcmydjdmxes/{pcmydjdmx_id}")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> updateByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setOrmpostid(ormpost_id);
        domain.setPcmydjdmxid(pcmydjdmx_id);
		pcmydjdmxService.update(domain);
        PcmYdjdmxDTO dto = pcmydjdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.getPcmydjdmxByEntities(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdtos)),'ehr-PcmYdjdmx-Update')")
    @ApiOperation(value = "根据组织管理岗位批量更新异动借调明细", tags = {"异动借调明细" },  notes = "根据组织管理岗位批量更新异动借调明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/pcmydjdmxes/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody List<PcmYdjdmxDTO> pcmydjdmxdtos) {
        List<PcmYdjdmx> domainlist=pcmydjdmxMapping.toDomain(pcmydjdmxdtos);
        for(PcmYdjdmx domain:domainlist){
            domain.setOrmpostid(ormpost_id);
        }
        pcmydjdmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.get(#pcmydjdmx_id),'ehr-PcmYdjdmx-Remove')")
    @ApiOperation(value = "根据组织管理岗位删除异动借调明细", tags = {"异动借调明细" },  notes = "根据组织管理岗位删除异动借调明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/pcmydjdmxes/{pcmydjdmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxService.remove(pcmydjdmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.getPcmydjdmxByIds(#ids),'ehr-PcmYdjdmx-Remove')")
    @ApiOperation(value = "根据组织管理岗位批量删除异动借调明细", tags = {"异动借调明细" },  notes = "根据组织管理岗位批量删除异动借调明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/pcmydjdmxes/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgOrmPost(@RequestBody List<String> ids) {
        pcmydjdmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-PersonBack-all')")
    @ApiOperation(value = "根据组织管理岗位异动借调明细", tags = {"异动借调明细" },  notes = "根据组织管理岗位异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/pcmydjdmxes/{pcmydjdmx_id}/personback")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> personBackByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setOrmpostid(ormpost_id);
        domain = pcmydjdmxService.personBack(domain) ;
        pcmydjdmxdto = pcmydjdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-PersonInfo-all')")
    @ApiOperation(value = "根据组织管理岗位异动借调明细", tags = {"异动借调明细" },  notes = "根据组织管理岗位异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/pcmydjdmxes/{pcmydjdmx_id}/personinfo")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> personInfoByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setOrmpostid(ormpost_id);
        domain = pcmydjdmxService.personInfo(domain) ;
        pcmydjdmxdto = pcmydjdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxdto);
    }

    @ApiOperation(value = "根据组织管理岗位检查异动借调明细", tags = {"异动借调明细" },  notes = "根据组织管理岗位检查异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/pcmydjdmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxService.checkKey(pcmydjdmxMapping.toDomain(pcmydjdmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdto),'ehr-PcmYdjdmx-Save')")
    @ApiOperation(value = "根据组织管理岗位保存异动借调明细", tags = {"异动借调明细" },  notes = "根据组织管理岗位保存异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/pcmydjdmxes/save")
    public ResponseEntity<Boolean> saveByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setOrmpostid(ormpost_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdtos),'ehr-PcmYdjdmx-Save')")
    @ApiOperation(value = "根据组织管理岗位批量保存异动借调明细", tags = {"异动借调明细" },  notes = "根据组织管理岗位批量保存异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/pcmydjdmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody List<PcmYdjdmxDTO> pcmydjdmxdtos) {
        List<PcmYdjdmx> domainlist=pcmydjdmxMapping.toDomain(pcmydjdmxdtos);
        for(PcmYdjdmx domain:domainlist){
             domain.setOrmpostid(ormpost_id);
        }
        pcmydjdmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdto),'ehr-PcmYdjdmx-Create')")
    @ApiOperation(value = "根据组织管理岗位建立异动借调明细", tags = {"异动借调明细" },  notes = "根据组织管理岗位建立异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/pcmydjdmxes")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> createByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setOrmpostid(ormpost_id);
		pcmydjdmxService.create(domain);
        PcmYdjdmxDTO dto = pcmydjdmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdtos),'ehr-PcmYdjdmx-Create')")
    @ApiOperation(value = "根据组织管理岗位批量建立异动借调明细", tags = {"异动借调明细" },  notes = "根据组织管理岗位批量建立异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/pcmydjdmxes/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody List<PcmYdjdmxDTO> pcmydjdmxdtos) {
        List<PcmYdjdmx> domainlist=pcmydjdmxMapping.toDomain(pcmydjdmxdtos);
        for(PcmYdjdmx domain:domainlist){
            domain.setOrmpostid(ormpost_id);
        }
        pcmydjdmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDGLDQ-all')")
	@ApiOperation(value = "根据组织管理岗位获取借调管理查询", tags = {"异动借调明细" } ,notes = "根据组织管理岗位获取借调管理查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/pcmydjdmxes/fetchjdgldq")
	public ResponseEntity<List<PcmYdjdmxDTO>> fetchPcmYdjdmxJDGLDQByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id,PcmYdjdmxSearchContext context) {
        context.setN_ormpostid_eq(ormpost_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDGLDQ(context) ;
        List<PcmYdjdmxDTO> list = pcmydjdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDGLDQ-all')")
	@ApiOperation(value = "根据组织管理岗位查询借调管理查询", tags = {"异动借调明细" } ,notes = "根据组织管理岗位查询借调管理查询")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/pcmydjdmxes/searchjdgldq")
	public ResponseEntity<Page<PcmYdjdmxDTO>> searchPcmYdjdmxJDGLDQByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody PcmYdjdmxSearchContext context) {
        context.setN_ormpostid_eq(ormpost_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDGLDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDLSJLDQ-all')")
	@ApiOperation(value = "根据组织管理岗位获取借调历史记录查询", tags = {"异动借调明细" } ,notes = "根据组织管理岗位获取借调历史记录查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/pcmydjdmxes/fetchjdlsjldq")
	public ResponseEntity<List<PcmYdjdmxDTO>> fetchPcmYdjdmxJDLSJLDQByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id,PcmYdjdmxSearchContext context) {
        context.setN_ormpostid_eq(ormpost_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDLSJLDQ(context) ;
        List<PcmYdjdmxDTO> list = pcmydjdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDLSJLDQ-all')")
	@ApiOperation(value = "根据组织管理岗位查询借调历史记录查询", tags = {"异动借调明细" } ,notes = "根据组织管理岗位查询借调历史记录查询")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/pcmydjdmxes/searchjdlsjldq")
	public ResponseEntity<Page<PcmYdjdmxDTO>> searchPcmYdjdmxJDLSJLDQByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody PcmYdjdmxSearchContext context) {
        context.setN_ormpostid_eq(ormpost_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDLSJLDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-Default-all')")
	@ApiOperation(value = "根据组织管理岗位获取DEFAULT", tags = {"异动借调明细" } ,notes = "根据组织管理岗位获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/pcmydjdmxes/fetchdefault")
	public ResponseEntity<List<PcmYdjdmxDTO>> fetchPcmYdjdmxDefaultByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id,PcmYdjdmxSearchContext context) {
        context.setN_ormpostid_eq(ormpost_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchDefault(context) ;
        List<PcmYdjdmxDTO> list = pcmydjdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-Default-all')")
	@ApiOperation(value = "根据组织管理岗位查询DEFAULT", tags = {"异动借调明细" } ,notes = "根据组织管理岗位查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/pcmydjdmxes/searchdefault")
	public ResponseEntity<Page<PcmYdjdmxDTO>> searchPcmYdjdmxDefaultByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody PcmYdjdmxSearchContext context) {
        context.setN_ormpostid_eq(ormpost_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(returnObject.body),'ehr-PcmYdjdmx-Get')")
    @ApiOperation(value = "根据人员信息分配信息获取异动借调明细", tags = {"异动借调明细" },  notes = "根据人员信息分配信息获取异动借调明细")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes/{pcmydjdmx_id}")
    public ResponseEntity<PcmYdjdmxDTO> getByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id) {
        PcmYdjdmx domain = pcmydjdmxService.get(pcmydjdmx_id);
        PcmYdjdmxDTO dto = pcmydjdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据人员信息分配信息获取异动借调明细草稿", tags = {"异动借调明细" },  notes = "根据人员信息分配信息获取异动借调明细草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes/getdraft")
    public ResponseEntity<PcmYdjdmxDTO> getDraftByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id) {
        PcmYdjdmx domain = new PcmYdjdmx();
        domain.setPimdistirbutionid(pimdistirbution_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxMapping.toDto(pcmydjdmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.get(#pcmydjdmx_id),'ehr-PcmYdjdmx-Update')")
    @ApiOperation(value = "根据人员信息分配信息更新异动借调明细", tags = {"异动借调明细" },  notes = "根据人员信息分配信息更新异动借调明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes/{pcmydjdmx_id}")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> updateByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain.setPcmydjdmxid(pcmydjdmx_id);
		pcmydjdmxService.update(domain);
        PcmYdjdmxDTO dto = pcmydjdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.getPcmydjdmxByEntities(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdtos)),'ehr-PcmYdjdmx-Update')")
    @ApiOperation(value = "根据人员信息分配信息批量更新异动借调明细", tags = {"异动借调明细" },  notes = "根据人员信息分配信息批量更新异动借调明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes/batch")
    public ResponseEntity<Boolean> updateBatchByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody List<PcmYdjdmxDTO> pcmydjdmxdtos) {
        List<PcmYdjdmx> domainlist=pcmydjdmxMapping.toDomain(pcmydjdmxdtos);
        for(PcmYdjdmx domain:domainlist){
            domain.setPimdistirbutionid(pimdistirbution_id);
        }
        pcmydjdmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.get(#pcmydjdmx_id),'ehr-PcmYdjdmx-Remove')")
    @ApiOperation(value = "根据人员信息分配信息删除异动借调明细", tags = {"异动借调明细" },  notes = "根据人员信息分配信息删除异动借调明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes/{pcmydjdmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxService.remove(pcmydjdmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.getPcmydjdmxByIds(#ids),'ehr-PcmYdjdmx-Remove')")
    @ApiOperation(value = "根据人员信息分配信息批量删除异动借调明细", tags = {"异动借调明细" },  notes = "根据人员信息分配信息批量删除异动借调明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes/batch")
    public ResponseEntity<Boolean> removeBatchByPimPersonPimDistirbution(@RequestBody List<String> ids) {
        pcmydjdmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-PersonBack-all')")
    @ApiOperation(value = "根据人员信息分配信息异动借调明细", tags = {"异动借调明细" },  notes = "根据人员信息分配信息异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes/{pcmydjdmx_id}/personback")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> personBackByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain = pcmydjdmxService.personBack(domain) ;
        pcmydjdmxdto = pcmydjdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-PersonInfo-all')")
    @ApiOperation(value = "根据人员信息分配信息异动借调明细", tags = {"异动借调明细" },  notes = "根据人员信息分配信息异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes/{pcmydjdmx_id}/personinfo")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> personInfoByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmydjdmx_id") String pcmydjdmx_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain = pcmydjdmxService.personInfo(domain) ;
        pcmydjdmxdto = pcmydjdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxdto);
    }

    @ApiOperation(value = "根据人员信息分配信息检查异动借调明细", tags = {"异动借调明细" },  notes = "根据人员信息分配信息检查异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxService.checkKey(pcmydjdmxMapping.toDomain(pcmydjdmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdto),'ehr-PcmYdjdmx-Save')")
    @ApiOperation(value = "根据人员信息分配信息保存异动借调明细", tags = {"异动借调明细" },  notes = "根据人员信息分配信息保存异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes/save")
    public ResponseEntity<Boolean> saveByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdtos),'ehr-PcmYdjdmx-Save')")
    @ApiOperation(value = "根据人员信息分配信息批量保存异动借调明细", tags = {"异动借调明细" },  notes = "根据人员信息分配信息批量保存异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody List<PcmYdjdmxDTO> pcmydjdmxdtos) {
        List<PcmYdjdmx> domainlist=pcmydjdmxMapping.toDomain(pcmydjdmxdtos);
        for(PcmYdjdmx domain:domainlist){
             domain.setPimdistirbutionid(pimdistirbution_id);
        }
        pcmydjdmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdto),'ehr-PcmYdjdmx-Create')")
    @ApiOperation(value = "根据人员信息分配信息建立异动借调明细", tags = {"异动借调明细" },  notes = "根据人员信息分配信息建立异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> createByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
		pcmydjdmxService.create(domain);
        PcmYdjdmxDTO dto = pcmydjdmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdtos),'ehr-PcmYdjdmx-Create')")
    @ApiOperation(value = "根据人员信息分配信息批量建立异动借调明细", tags = {"异动借调明细" },  notes = "根据人员信息分配信息批量建立异动借调明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes/batch")
    public ResponseEntity<Boolean> createBatchByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody List<PcmYdjdmxDTO> pcmydjdmxdtos) {
        List<PcmYdjdmx> domainlist=pcmydjdmxMapping.toDomain(pcmydjdmxdtos);
        for(PcmYdjdmx domain:domainlist){
            domain.setPimdistirbutionid(pimdistirbution_id);
        }
        pcmydjdmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDGLDQ-all')")
	@ApiOperation(value = "根据人员信息分配信息获取借调管理查询", tags = {"异动借调明细" } ,notes = "根据人员信息分配信息获取借调管理查询")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes/fetchjdgldq")
	public ResponseEntity<List<PcmYdjdmxDTO>> fetchPcmYdjdmxJDGLDQByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id,PcmYdjdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDGLDQ(context) ;
        List<PcmYdjdmxDTO> list = pcmydjdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDGLDQ-all')")
	@ApiOperation(value = "根据人员信息分配信息查询借调管理查询", tags = {"异动借调明细" } ,notes = "根据人员信息分配信息查询借调管理查询")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes/searchjdgldq")
	public ResponseEntity<Page<PcmYdjdmxDTO>> searchPcmYdjdmxJDGLDQByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PcmYdjdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDGLDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDLSJLDQ-all')")
	@ApiOperation(value = "根据人员信息分配信息获取借调历史记录查询", tags = {"异动借调明细" } ,notes = "根据人员信息分配信息获取借调历史记录查询")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes/fetchjdlsjldq")
	public ResponseEntity<List<PcmYdjdmxDTO>> fetchPcmYdjdmxJDLSJLDQByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id,PcmYdjdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDLSJLDQ(context) ;
        List<PcmYdjdmxDTO> list = pcmydjdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDLSJLDQ-all')")
	@ApiOperation(value = "根据人员信息分配信息查询借调历史记录查询", tags = {"异动借调明细" } ,notes = "根据人员信息分配信息查询借调历史记录查询")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes/searchjdlsjldq")
	public ResponseEntity<Page<PcmYdjdmxDTO>> searchPcmYdjdmxJDLSJLDQByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PcmYdjdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDLSJLDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-Default-all')")
	@ApiOperation(value = "根据人员信息分配信息获取DEFAULT", tags = {"异动借调明细" } ,notes = "根据人员信息分配信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes/fetchdefault")
	public ResponseEntity<List<PcmYdjdmxDTO>> fetchPcmYdjdmxDefaultByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id,PcmYdjdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchDefault(context) ;
        List<PcmYdjdmxDTO> list = pcmydjdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-Default-all')")
	@ApiOperation(value = "根据人员信息分配信息查询DEFAULT", tags = {"异动借调明细" } ,notes = "根据人员信息分配信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmydjdmxes/searchdefault")
	public ResponseEntity<Page<PcmYdjdmxDTO>> searchPcmYdjdmxDefaultByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PcmYdjdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

