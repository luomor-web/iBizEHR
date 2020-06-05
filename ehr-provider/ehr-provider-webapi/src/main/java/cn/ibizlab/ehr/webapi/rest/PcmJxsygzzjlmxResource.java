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
import cn.ibizlab.ehr.core.pcm.domain.PcmJxsygzzjlmx;
import cn.ibizlab.ehr.core.pcm.service.IPcmJxsygzzjlmxService;
import cn.ibizlab.ehr.core.pcm.filter.PcmJxsygzzjlmxSearchContext;

@Slf4j
@Api(tags = {"见习生员工转正记录引用明细" })
@RestController("WebApi-pcmjxsygzzjlmx")
@RequestMapping("")
public class PcmJxsygzzjlmxResource {

    @Autowired
    public IPcmJxsygzzjlmxService pcmjxsygzzjlmxService;

    @Autowired
    @Lazy
    public PcmJxsygzzjlmxMapping pcmjxsygzzjlmxMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzjlmx-SHBTG-all')")
    @ApiOperation(value = "审核不通过", tags = {"见习生员工转正记录引用明细" },  notes = "审核不通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzjlmxes/{pcmjxsygzzjlmx_id}/shbtg")
    @Transactional
    public ResponseEntity<PcmJxsygzzjlmxDTO> sHBTG(@PathVariable("pcmjxsygzzjlmx_id") String pcmjxsygzzjlmx_id, @RequestBody PcmJxsygzzjlmxDTO pcmjxsygzzjlmxdto) {
        PcmJxsygzzjlmx pcmjxsygzzjlmx = pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdto);
        pcmjxsygzzjlmx.setPcmjxsygzzjlmxid(pcmjxsygzzjlmx_id);
        pcmjxsygzzjlmx = pcmjxsygzzjlmxService.sHBTG(pcmjxsygzzjlmx);
        pcmjxsygzzjlmxdto = pcmjxsygzzjlmxMapping.toDto(pcmjxsygzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzjlmx-SHTG-all')")
    @ApiOperation(value = "审核通过", tags = {"见习生员工转正记录引用明细" },  notes = "审核通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzjlmxes/{pcmjxsygzzjlmx_id}/shtg")
    @Transactional
    public ResponseEntity<PcmJxsygzzjlmxDTO> sHTG(@PathVariable("pcmjxsygzzjlmx_id") String pcmjxsygzzjlmx_id, @RequestBody PcmJxsygzzjlmxDTO pcmjxsygzzjlmxdto) {
        PcmJxsygzzjlmx pcmjxsygzzjlmx = pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdto);
        pcmjxsygzzjlmx.setPcmjxsygzzjlmxid(pcmjxsygzzjlmx_id);
        pcmjxsygzzjlmx = pcmjxsygzzjlmxService.sHTG(pcmjxsygzzjlmx);
        pcmjxsygzzjlmxdto = pcmjxsygzzjlmxMapping.toDto(pcmjxsygzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzjlmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzjlmxMapping.toDomain(#pcmjxsygzzjlmxdto),'ehr-PcmJxsygzzjlmx-Save')")
    @ApiOperation(value = "保存见习生员工转正记录引用明细", tags = {"见习生员工转正记录引用明细" },  notes = "保存见习生员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzjlmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmJxsygzzjlmxDTO pcmjxsygzzjlmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzjlmxService.save(pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzjlmxMapping.toDomain(#pcmjxsygzzjlmxdtos),'ehr-PcmJxsygzzjlmx-Save')")
    @ApiOperation(value = "批量保存见习生员工转正记录引用明细", tags = {"见习生员工转正记录引用明细" },  notes = "批量保存见习生员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzjlmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmJxsygzzjlmxDTO> pcmjxsygzzjlmxdtos) {
        pcmjxsygzzjlmxService.saveBatch(pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzjlmx-FillPersonInfo-all')")
    @ApiOperation(value = "", tags = {"见习生员工转正记录引用明细" },  notes = "")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzjlmxes/{pcmjxsygzzjlmx_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PcmJxsygzzjlmxDTO> fillPersonInfo(@PathVariable("pcmjxsygzzjlmx_id") String pcmjxsygzzjlmx_id, @RequestBody PcmJxsygzzjlmxDTO pcmjxsygzzjlmxdto) {
        PcmJxsygzzjlmx pcmjxsygzzjlmx = pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdto);
        pcmjxsygzzjlmx.setPcmjxsygzzjlmxid(pcmjxsygzzjlmx_id);
        pcmjxsygzzjlmx = pcmjxsygzzjlmxService.fillPersonInfo(pcmjxsygzzjlmx);
        pcmjxsygzzjlmxdto = pcmjxsygzzjlmxMapping.toDto(pcmjxsygzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzjlmx-ZZCZ-all')")
    @ApiOperation(value = "转正操作", tags = {"见习生员工转正记录引用明细" },  notes = "转正操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzjlmxes/{pcmjxsygzzjlmx_id}/zzcz")
    @Transactional
    public ResponseEntity<PcmJxsygzzjlmxDTO> zZCZ(@PathVariable("pcmjxsygzzjlmx_id") String pcmjxsygzzjlmx_id, @RequestBody PcmJxsygzzjlmxDTO pcmjxsygzzjlmxdto) {
        PcmJxsygzzjlmx pcmjxsygzzjlmx = pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdto);
        pcmjxsygzzjlmx.setPcmjxsygzzjlmxid(pcmjxsygzzjlmx_id);
        pcmjxsygzzjlmx = pcmjxsygzzjlmxService.zZCZ(pcmjxsygzzjlmx);
        pcmjxsygzzjlmxdto = pcmjxsygzzjlmxMapping.toDto(pcmjxsygzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzjlmx-SetPass-all')")
    @ApiOperation(value = "审核通过", tags = {"见习生员工转正记录引用明细" },  notes = "审核通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzjlmxes/{pcmjxsygzzjlmx_id}/setpass")
    @Transactional
    public ResponseEntity<PcmJxsygzzjlmxDTO> setPass(@PathVariable("pcmjxsygzzjlmx_id") String pcmjxsygzzjlmx_id, @RequestBody PcmJxsygzzjlmxDTO pcmjxsygzzjlmxdto) {
        PcmJxsygzzjlmx pcmjxsygzzjlmx = pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdto);
        pcmjxsygzzjlmx.setPcmjxsygzzjlmxid(pcmjxsygzzjlmx_id);
        pcmjxsygzzjlmx = pcmjxsygzzjlmxService.setPass(pcmjxsygzzjlmx);
        pcmjxsygzzjlmxdto = pcmjxsygzzjlmxMapping.toDto(pcmjxsygzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzjlmxdto);
    }

    @ApiOperation(value = "获取见习生员工转正记录引用明细草稿", tags = {"见习生员工转正记录引用明细" },  notes = "获取见习生员工转正记录引用明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmjxsygzzjlmxes/getdraft")
    public ResponseEntity<PcmJxsygzzjlmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzjlmxMapping.toDto(pcmjxsygzzjlmxService.getDraft(new PcmJxsygzzjlmx())));
    }

    @PostAuthorize("hasPermission(this.pcmjxsygzzjlmxMapping.toDomain(returnObject.body),'ehr-PcmJxsygzzjlmx-Get')")
    @ApiOperation(value = "获取见习生员工转正记录引用明细", tags = {"见习生员工转正记录引用明细" },  notes = "获取见习生员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmjxsygzzjlmxes/{pcmjxsygzzjlmx_id}")
    public ResponseEntity<PcmJxsygzzjlmxDTO> get(@PathVariable("pcmjxsygzzjlmx_id") String pcmjxsygzzjlmx_id) {
        PcmJxsygzzjlmx domain = pcmjxsygzzjlmxService.get(pcmjxsygzzjlmx_id);
        PcmJxsygzzjlmxDTO dto = pcmjxsygzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzjlmx-SetReject-all')")
    @ApiOperation(value = "审核不通过", tags = {"见习生员工转正记录引用明细" },  notes = "审核不通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzjlmxes/{pcmjxsygzzjlmx_id}/setreject")
    @Transactional
    public ResponseEntity<PcmJxsygzzjlmxDTO> setReject(@PathVariable("pcmjxsygzzjlmx_id") String pcmjxsygzzjlmx_id, @RequestBody PcmJxsygzzjlmxDTO pcmjxsygzzjlmxdto) {
        PcmJxsygzzjlmx pcmjxsygzzjlmx = pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdto);
        pcmjxsygzzjlmx.setPcmjxsygzzjlmxid(pcmjxsygzzjlmx_id);
        pcmjxsygzzjlmx = pcmjxsygzzjlmxService.setReject(pcmjxsygzzjlmx);
        pcmjxsygzzjlmxdto = pcmjxsygzzjlmxMapping.toDto(pcmjxsygzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzjlmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzjlmxService.get(#pcmjxsygzzjlmx_id),'ehr-PcmJxsygzzjlmx-Remove')")
    @ApiOperation(value = "删除见习生员工转正记录引用明细", tags = {"见习生员工转正记录引用明细" },  notes = "删除见习生员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmjxsygzzjlmxes/{pcmjxsygzzjlmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmjxsygzzjlmx_id") String pcmjxsygzzjlmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzjlmxService.remove(pcmjxsygzzjlmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzjlmxService.getPcmjxsygzzjlmxByIds(#ids),'ehr-PcmJxsygzzjlmx-Remove')")
    @ApiOperation(value = "批量删除见习生员工转正记录引用明细", tags = {"见习生员工转正记录引用明细" },  notes = "批量删除见习生员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmjxsygzzjlmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmjxsygzzjlmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzjlmxMapping.toDomain(#pcmjxsygzzjlmxdto),'ehr-PcmJxsygzzjlmx-Create')")
    @ApiOperation(value = "新建见习生员工转正记录引用明细", tags = {"见习生员工转正记录引用明细" },  notes = "新建见习生员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzjlmxes")
    @Transactional
    public ResponseEntity<PcmJxsygzzjlmxDTO> create(@RequestBody PcmJxsygzzjlmxDTO pcmjxsygzzjlmxdto) {
        PcmJxsygzzjlmx domain = pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdto);
		pcmjxsygzzjlmxService.create(domain);
        PcmJxsygzzjlmxDTO dto = pcmjxsygzzjlmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzjlmxMapping.toDomain(#pcmjxsygzzjlmxdtos),'ehr-PcmJxsygzzjlmx-Create')")
    @ApiOperation(value = "批量新建见习生员工转正记录引用明细", tags = {"见习生员工转正记录引用明细" },  notes = "批量新建见习生员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzjlmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmJxsygzzjlmxDTO> pcmjxsygzzjlmxdtos) {
        pcmjxsygzzjlmxService.createBatch(pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzjlmxService.get(#pcmjxsygzzjlmx_id),'ehr-PcmJxsygzzjlmx-Update')")
    @ApiOperation(value = "更新见习生员工转正记录引用明细", tags = {"见习生员工转正记录引用明细" },  notes = "更新见习生员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmjxsygzzjlmxes/{pcmjxsygzzjlmx_id}")
    @Transactional
    public ResponseEntity<PcmJxsygzzjlmxDTO> update(@PathVariable("pcmjxsygzzjlmx_id") String pcmjxsygzzjlmx_id, @RequestBody PcmJxsygzzjlmxDTO pcmjxsygzzjlmxdto) {
		PcmJxsygzzjlmx domain  = pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdto);
        domain .setPcmjxsygzzjlmxid(pcmjxsygzzjlmx_id);
		pcmjxsygzzjlmxService.update(domain );
		PcmJxsygzzjlmxDTO dto = pcmjxsygzzjlmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzjlmxService.getPcmjxsygzzjlmxByEntities(this.pcmjxsygzzjlmxMapping.toDomain(#pcmjxsygzzjlmxdtos)),'ehr-PcmJxsygzzjlmx-Update')")
    @ApiOperation(value = "批量更新见习生员工转正记录引用明细", tags = {"见习生员工转正记录引用明细" },  notes = "批量更新见习生员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmjxsygzzjlmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmJxsygzzjlmxDTO> pcmjxsygzzjlmxdtos) {
        pcmjxsygzzjlmxService.updateBatch(pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查见习生员工转正记录引用明细", tags = {"见习生员工转正记录引用明细" },  notes = "检查见习生员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzjlmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmJxsygzzjlmxDTO pcmjxsygzzjlmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzjlmxService.checkKey(pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzjlmx-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"见习生员工转正记录引用明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmjxsygzzjlmxes/fetchdefault")
	public ResponseEntity<List<PcmJxsygzzjlmxDTO>> fetchDefault(PcmJxsygzzjlmxSearchContext context) {
        Page<PcmJxsygzzjlmx> domains = pcmjxsygzzjlmxService.searchDefault(context) ;
        List<PcmJxsygzzjlmxDTO> list = pcmjxsygzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzjlmx-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"见习生员工转正记录引用明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmjxsygzzjlmxes/searchdefault")
	public ResponseEntity<Page<PcmJxsygzzjlmxDTO>> searchDefault(@RequestBody PcmJxsygzzjlmxSearchContext context) {
        Page<PcmJxsygzzjlmx> domains = pcmjxsygzzjlmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmjxsygzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzjlmx-WSHSQ-all')")
	@ApiOperation(value = "获取未审核完成的申请", tags = {"见习生员工转正记录引用明细" } ,notes = "获取未审核完成的申请")
    @RequestMapping(method= RequestMethod.GET , value="/pcmjxsygzzjlmxes/fetchwshsq")
	public ResponseEntity<List<PcmJxsygzzjlmxDTO>> fetchWSHSQ(PcmJxsygzzjlmxSearchContext context) {
        Page<PcmJxsygzzjlmx> domains = pcmjxsygzzjlmxService.searchWSHSQ(context) ;
        List<PcmJxsygzzjlmxDTO> list = pcmjxsygzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzjlmx-WSHSQ-all')")
	@ApiOperation(value = "查询未审核完成的申请", tags = {"见习生员工转正记录引用明细" } ,notes = "查询未审核完成的申请")
    @RequestMapping(method= RequestMethod.POST , value="/pcmjxsygzzjlmxes/searchwshsq")
	public ResponseEntity<Page<PcmJxsygzzjlmxDTO>> searchWSHSQ(@RequestBody PcmJxsygzzjlmxSearchContext context) {
        Page<PcmJxsygzzjlmx> domains = pcmjxsygzzjlmxService.searchWSHSQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmjxsygzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzjlmx-JXSZZJL-all')")
	@ApiOperation(value = "获取见习生转正记录", tags = {"见习生员工转正记录引用明细" } ,notes = "获取见习生转正记录")
    @RequestMapping(method= RequestMethod.GET , value="/pcmjxsygzzjlmxes/fetchjxszzjl")
	public ResponseEntity<List<PcmJxsygzzjlmxDTO>> fetchJXSZZJL(PcmJxsygzzjlmxSearchContext context) {
        Page<PcmJxsygzzjlmx> domains = pcmjxsygzzjlmxService.searchJXSZZJL(context) ;
        List<PcmJxsygzzjlmxDTO> list = pcmjxsygzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzjlmx-JXSZZJL-all')")
	@ApiOperation(value = "查询见习生转正记录", tags = {"见习生员工转正记录引用明细" } ,notes = "查询见习生转正记录")
    @RequestMapping(method= RequestMethod.POST , value="/pcmjxsygzzjlmxes/searchjxszzjl")
	public ResponseEntity<Page<PcmJxsygzzjlmxDTO>> searchJXSZZJL(@RequestBody PcmJxsygzzjlmxSearchContext context) {
        Page<PcmJxsygzzjlmx> domains = pcmjxsygzzjlmxService.searchJXSZZJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmjxsygzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzjlmx-ALLDS-all')")
	@ApiOperation(value = "获取所有的申请明细", tags = {"见习生员工转正记录引用明细" } ,notes = "获取所有的申请明细")
    @RequestMapping(method= RequestMethod.GET , value="/pcmjxsygzzjlmxes/fetchallds")
	public ResponseEntity<List<PcmJxsygzzjlmxDTO>> fetchALLDS(PcmJxsygzzjlmxSearchContext context) {
        Page<PcmJxsygzzjlmx> domains = pcmjxsygzzjlmxService.searchALLDS(context) ;
        List<PcmJxsygzzjlmxDTO> list = pcmjxsygzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzjlmx-ALLDS-all')")
	@ApiOperation(value = "查询所有的申请明细", tags = {"见习生员工转正记录引用明细" } ,notes = "查询所有的申请明细")
    @RequestMapping(method= RequestMethod.POST , value="/pcmjxsygzzjlmxes/searchallds")
	public ResponseEntity<Page<PcmJxsygzzjlmxDTO>> searchALLDS(@RequestBody PcmJxsygzzjlmxSearchContext context) {
        Page<PcmJxsygzzjlmx> domains = pcmjxsygzzjlmxService.searchALLDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmjxsygzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzjlmx-SHBTG-all')")
    @ApiOperation(value = "根据人员信息见习生员工转正记录引用明细", tags = {"见习生员工转正记录引用明细" },  notes = "根据人员信息见习生员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmjxsygzzjlmxes/{pcmjxsygzzjlmx_id}/shbtg")
    @Transactional
    public ResponseEntity<PcmJxsygzzjlmxDTO> sHBTGByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmjxsygzzjlmx_id") String pcmjxsygzzjlmx_id, @RequestBody PcmJxsygzzjlmxDTO pcmjxsygzzjlmxdto) {
        PcmJxsygzzjlmx domain = pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmjxsygzzjlmxService.sHBTG(domain) ;
        pcmjxsygzzjlmxdto = pcmjxsygzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzjlmx-SHTG-all')")
    @ApiOperation(value = "根据人员信息见习生员工转正记录引用明细", tags = {"见习生员工转正记录引用明细" },  notes = "根据人员信息见习生员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmjxsygzzjlmxes/{pcmjxsygzzjlmx_id}/shtg")
    @Transactional
    public ResponseEntity<PcmJxsygzzjlmxDTO> sHTGByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmjxsygzzjlmx_id") String pcmjxsygzzjlmx_id, @RequestBody PcmJxsygzzjlmxDTO pcmjxsygzzjlmxdto) {
        PcmJxsygzzjlmx domain = pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmjxsygzzjlmxService.sHTG(domain) ;
        pcmjxsygzzjlmxdto = pcmjxsygzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzjlmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzjlmxMapping.toDomain(#pcmjxsygzzjlmxdto),'ehr-PcmJxsygzzjlmx-Save')")
    @ApiOperation(value = "根据人员信息保存见习生员工转正记录引用明细", tags = {"见习生员工转正记录引用明细" },  notes = "根据人员信息保存见习生员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmjxsygzzjlmxes/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmJxsygzzjlmxDTO pcmjxsygzzjlmxdto) {
        PcmJxsygzzjlmx domain = pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzjlmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzjlmxMapping.toDomain(#pcmjxsygzzjlmxdtos),'ehr-PcmJxsygzzjlmx-Save')")
    @ApiOperation(value = "根据人员信息批量保存见习生员工转正记录引用明细", tags = {"见习生员工转正记录引用明细" },  notes = "根据人员信息批量保存见习生员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmjxsygzzjlmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PcmJxsygzzjlmxDTO> pcmjxsygzzjlmxdtos) {
        List<PcmJxsygzzjlmx> domainlist=pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdtos);
        for(PcmJxsygzzjlmx domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pcmjxsygzzjlmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzjlmx-FillPersonInfo-all')")
    @ApiOperation(value = "根据人员信息见习生员工转正记录引用明细", tags = {"见习生员工转正记录引用明细" },  notes = "根据人员信息见习生员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmjxsygzzjlmxes/{pcmjxsygzzjlmx_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PcmJxsygzzjlmxDTO> fillPersonInfoByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmjxsygzzjlmx_id") String pcmjxsygzzjlmx_id, @RequestBody PcmJxsygzzjlmxDTO pcmjxsygzzjlmxdto) {
        PcmJxsygzzjlmx domain = pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmjxsygzzjlmxService.fillPersonInfo(domain) ;
        pcmjxsygzzjlmxdto = pcmjxsygzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzjlmx-ZZCZ-all')")
    @ApiOperation(value = "根据人员信息见习生员工转正记录引用明细", tags = {"见习生员工转正记录引用明细" },  notes = "根据人员信息见习生员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmjxsygzzjlmxes/{pcmjxsygzzjlmx_id}/zzcz")
    @Transactional
    public ResponseEntity<PcmJxsygzzjlmxDTO> zZCZByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmjxsygzzjlmx_id") String pcmjxsygzzjlmx_id, @RequestBody PcmJxsygzzjlmxDTO pcmjxsygzzjlmxdto) {
        PcmJxsygzzjlmx domain = pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmjxsygzzjlmxService.zZCZ(domain) ;
        pcmjxsygzzjlmxdto = pcmjxsygzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzjlmx-SetPass-all')")
    @ApiOperation(value = "根据人员信息见习生员工转正记录引用明细", tags = {"见习生员工转正记录引用明细" },  notes = "根据人员信息见习生员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmjxsygzzjlmxes/{pcmjxsygzzjlmx_id}/setpass")
    @Transactional
    public ResponseEntity<PcmJxsygzzjlmxDTO> setPassByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmjxsygzzjlmx_id") String pcmjxsygzzjlmx_id, @RequestBody PcmJxsygzzjlmxDTO pcmjxsygzzjlmxdto) {
        PcmJxsygzzjlmx domain = pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmjxsygzzjlmxService.setPass(domain) ;
        pcmjxsygzzjlmxdto = pcmjxsygzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzjlmxdto);
    }

    @ApiOperation(value = "根据人员信息获取见习生员工转正记录引用明细草稿", tags = {"见习生员工转正记录引用明细" },  notes = "根据人员信息获取见习生员工转正记录引用明细草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pcmjxsygzzjlmxes/getdraft")
    public ResponseEntity<PcmJxsygzzjlmxDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        PcmJxsygzzjlmx domain = new PcmJxsygzzjlmx();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzjlmxMapping.toDto(pcmjxsygzzjlmxService.getDraft(domain)));
    }

    @PostAuthorize("hasPermission(this.pcmjxsygzzjlmxMapping.toDomain(returnObject.body),'ehr-PcmJxsygzzjlmx-Get')")
    @ApiOperation(value = "根据人员信息获取见习生员工转正记录引用明细", tags = {"见习生员工转正记录引用明细" },  notes = "根据人员信息获取见习生员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pcmjxsygzzjlmxes/{pcmjxsygzzjlmx_id}")
    public ResponseEntity<PcmJxsygzzjlmxDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmjxsygzzjlmx_id") String pcmjxsygzzjlmx_id) {
        PcmJxsygzzjlmx domain = pcmjxsygzzjlmxService.get(pcmjxsygzzjlmx_id);
        PcmJxsygzzjlmxDTO dto = pcmjxsygzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzjlmx-SetReject-all')")
    @ApiOperation(value = "根据人员信息见习生员工转正记录引用明细", tags = {"见习生员工转正记录引用明细" },  notes = "根据人员信息见习生员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmjxsygzzjlmxes/{pcmjxsygzzjlmx_id}/setreject")
    @Transactional
    public ResponseEntity<PcmJxsygzzjlmxDTO> setRejectByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmjxsygzzjlmx_id") String pcmjxsygzzjlmx_id, @RequestBody PcmJxsygzzjlmxDTO pcmjxsygzzjlmxdto) {
        PcmJxsygzzjlmx domain = pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmjxsygzzjlmxService.setReject(domain) ;
        pcmjxsygzzjlmxdto = pcmjxsygzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzjlmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzjlmxService.get(#pcmjxsygzzjlmx_id),'ehr-PcmJxsygzzjlmx-Remove')")
    @ApiOperation(value = "根据人员信息删除见习生员工转正记录引用明细", tags = {"见习生员工转正记录引用明细" },  notes = "根据人员信息删除见习生员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pcmjxsygzzjlmxes/{pcmjxsygzzjlmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmjxsygzzjlmx_id") String pcmjxsygzzjlmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzjlmxService.remove(pcmjxsygzzjlmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzjlmxService.getPcmjxsygzzjlmxByIds(#ids),'ehr-PcmJxsygzzjlmx-Remove')")
    @ApiOperation(value = "根据人员信息批量删除见习生员工转正记录引用明细", tags = {"见习生员工转正记录引用明细" },  notes = "根据人员信息批量删除见习生员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pcmjxsygzzjlmxes/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        pcmjxsygzzjlmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzjlmxMapping.toDomain(#pcmjxsygzzjlmxdto),'ehr-PcmJxsygzzjlmx-Create')")
    @ApiOperation(value = "根据人员信息建立见习生员工转正记录引用明细", tags = {"见习生员工转正记录引用明细" },  notes = "根据人员信息建立见习生员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmjxsygzzjlmxes")
    @Transactional
    public ResponseEntity<PcmJxsygzzjlmxDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmJxsygzzjlmxDTO pcmjxsygzzjlmxdto) {
        PcmJxsygzzjlmx domain = pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
		pcmjxsygzzjlmxService.create(domain);
        PcmJxsygzzjlmxDTO dto = pcmjxsygzzjlmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzjlmxMapping.toDomain(#pcmjxsygzzjlmxdtos),'ehr-PcmJxsygzzjlmx-Create')")
    @ApiOperation(value = "根据人员信息批量建立见习生员工转正记录引用明细", tags = {"见习生员工转正记录引用明细" },  notes = "根据人员信息批量建立见习生员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmjxsygzzjlmxes/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PcmJxsygzzjlmxDTO> pcmjxsygzzjlmxdtos) {
        List<PcmJxsygzzjlmx> domainlist=pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdtos);
        for(PcmJxsygzzjlmx domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pcmjxsygzzjlmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzjlmxService.get(#pcmjxsygzzjlmx_id),'ehr-PcmJxsygzzjlmx-Update')")
    @ApiOperation(value = "根据人员信息更新见习生员工转正记录引用明细", tags = {"见习生员工转正记录引用明细" },  notes = "根据人员信息更新见习生员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pcmjxsygzzjlmxes/{pcmjxsygzzjlmx_id}")
    @Transactional
    public ResponseEntity<PcmJxsygzzjlmxDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmjxsygzzjlmx_id") String pcmjxsygzzjlmx_id, @RequestBody PcmJxsygzzjlmxDTO pcmjxsygzzjlmxdto) {
        PcmJxsygzzjlmx domain = pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain.setPcmjxsygzzjlmxid(pcmjxsygzzjlmx_id);
		pcmjxsygzzjlmxService.update(domain);
        PcmJxsygzzjlmxDTO dto = pcmjxsygzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzjlmxService.getPcmjxsygzzjlmxByEntities(this.pcmjxsygzzjlmxMapping.toDomain(#pcmjxsygzzjlmxdtos)),'ehr-PcmJxsygzzjlmx-Update')")
    @ApiOperation(value = "根据人员信息批量更新见习生员工转正记录引用明细", tags = {"见习生员工转正记录引用明细" },  notes = "根据人员信息批量更新见习生员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pcmjxsygzzjlmxes/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PcmJxsygzzjlmxDTO> pcmjxsygzzjlmxdtos) {
        List<PcmJxsygzzjlmx> domainlist=pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdtos);
        for(PcmJxsygzzjlmx domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pcmjxsygzzjlmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息检查见习生员工转正记录引用明细", tags = {"见习生员工转正记录引用明细" },  notes = "根据人员信息检查见习生员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmjxsygzzjlmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmJxsygzzjlmxDTO pcmjxsygzzjlmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzjlmxService.checkKey(pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzjlmx-Default-all')")
	@ApiOperation(value = "根据人员信息获取DEFAULT", tags = {"见习生员工转正记录引用明细" } ,notes = "根据人员信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmjxsygzzjlmxes/fetchdefault")
	public ResponseEntity<List<PcmJxsygzzjlmxDTO>> fetchPcmJxsygzzjlmxDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PcmJxsygzzjlmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmJxsygzzjlmx> domains = pcmjxsygzzjlmxService.searchDefault(context) ;
        List<PcmJxsygzzjlmxDTO> list = pcmjxsygzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzjlmx-Default-all')")
	@ApiOperation(value = "根据人员信息查询DEFAULT", tags = {"见习生员工转正记录引用明细" } ,notes = "根据人员信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmjxsygzzjlmxes/searchdefault")
	public ResponseEntity<Page<PcmJxsygzzjlmxDTO>> searchPcmJxsygzzjlmxDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmJxsygzzjlmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmJxsygzzjlmx> domains = pcmjxsygzzjlmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmjxsygzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzjlmx-WSHSQ-all')")
	@ApiOperation(value = "根据人员信息获取未审核完成的申请", tags = {"见习生员工转正记录引用明细" } ,notes = "根据人员信息获取未审核完成的申请")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmjxsygzzjlmxes/fetchwshsq")
	public ResponseEntity<List<PcmJxsygzzjlmxDTO>> fetchPcmJxsygzzjlmxWSHSQByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PcmJxsygzzjlmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmJxsygzzjlmx> domains = pcmjxsygzzjlmxService.searchWSHSQ(context) ;
        List<PcmJxsygzzjlmxDTO> list = pcmjxsygzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzjlmx-WSHSQ-all')")
	@ApiOperation(value = "根据人员信息查询未审核完成的申请", tags = {"见习生员工转正记录引用明细" } ,notes = "根据人员信息查询未审核完成的申请")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmjxsygzzjlmxes/searchwshsq")
	public ResponseEntity<Page<PcmJxsygzzjlmxDTO>> searchPcmJxsygzzjlmxWSHSQByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmJxsygzzjlmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmJxsygzzjlmx> domains = pcmjxsygzzjlmxService.searchWSHSQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmjxsygzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzjlmx-JXSZZJL-all')")
	@ApiOperation(value = "根据人员信息获取见习生转正记录", tags = {"见习生员工转正记录引用明细" } ,notes = "根据人员信息获取见习生转正记录")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmjxsygzzjlmxes/fetchjxszzjl")
	public ResponseEntity<List<PcmJxsygzzjlmxDTO>> fetchPcmJxsygzzjlmxJXSZZJLByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PcmJxsygzzjlmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmJxsygzzjlmx> domains = pcmjxsygzzjlmxService.searchJXSZZJL(context) ;
        List<PcmJxsygzzjlmxDTO> list = pcmjxsygzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzjlmx-JXSZZJL-all')")
	@ApiOperation(value = "根据人员信息查询见习生转正记录", tags = {"见习生员工转正记录引用明细" } ,notes = "根据人员信息查询见习生转正记录")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmjxsygzzjlmxes/searchjxszzjl")
	public ResponseEntity<Page<PcmJxsygzzjlmxDTO>> searchPcmJxsygzzjlmxJXSZZJLByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmJxsygzzjlmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmJxsygzzjlmx> domains = pcmjxsygzzjlmxService.searchJXSZZJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmjxsygzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzjlmx-ALLDS-all')")
	@ApiOperation(value = "根据人员信息获取所有的申请明细", tags = {"见习生员工转正记录引用明细" } ,notes = "根据人员信息获取所有的申请明细")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmjxsygzzjlmxes/fetchallds")
	public ResponseEntity<List<PcmJxsygzzjlmxDTO>> fetchPcmJxsygzzjlmxALLDSByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PcmJxsygzzjlmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmJxsygzzjlmx> domains = pcmjxsygzzjlmxService.searchALLDS(context) ;
        List<PcmJxsygzzjlmxDTO> list = pcmjxsygzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzjlmx-ALLDS-all')")
	@ApiOperation(value = "根据人员信息查询所有的申请明细", tags = {"见习生员工转正记录引用明细" } ,notes = "根据人员信息查询所有的申请明细")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmjxsygzzjlmxes/searchallds")
	public ResponseEntity<Page<PcmJxsygzzjlmxDTO>> searchPcmJxsygzzjlmxALLDSByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmJxsygzzjlmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmJxsygzzjlmx> domains = pcmjxsygzzjlmxService.searchALLDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmjxsygzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

