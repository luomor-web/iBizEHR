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
import cn.ibizlab.ehr.core.pcm.domain.PcmDdsqdmx;
import cn.ibizlab.ehr.core.pcm.service.IPcmDdsqdmxService;
import cn.ibizlab.ehr.core.pcm.filter.PcmDdsqdmxSearchContext;

@Slf4j
@Api(tags = {"PcmDdsqdmx" })
@RestController("WebApi-pcmddsqdmx")
@RequestMapping("")
public class PcmDdsqdmxResource {

    @Autowired
    public IPcmDdsqdmxService pcmddsqdmxService;

    @Autowired
    @Lazy
    public PcmDdsqdmxMapping pcmddsqdmxMapping;

    @PreAuthorize("hasPermission(this.pcmddsqdmxService.get(#pcmddsqdmx_id),'ehr-PcmDdsqdmx-Update')")
    @ApiOperation(value = "Update", tags = {"PcmDdsqdmx" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmddsqdmxes/{pcmddsqdmx_id}")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> update(@PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
		PcmDdsqdmx domain  = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain .setPcmddsqdmxid(pcmddsqdmx_id);
		pcmddsqdmxService.update(domain );
		PcmDdsqdmxDTO dto = pcmddsqdmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxService.getPcmddsqdmxByEntities(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdtos)),'ehr-PcmDdsqdmx-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PcmDdsqdmx" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmddsqdmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmDdsqdmxDTO> pcmddsqdmxdtos) {
        pcmddsqdmxService.updateBatch(pcmddsqdmxMapping.toDomain(pcmddsqdmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-DDUpdate-all')")
    @ApiOperation(value = "调动更正", tags = {"PcmDdsqdmx" },  notes = "调动更正")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmddsqdmxes/{pcmddsqdmx_id}/ddupdate")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> dDUpdate(@PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx pcmddsqdmx = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        pcmddsqdmx.setPcmddsqdmxid(pcmddsqdmx_id);
        pcmddsqdmx = pcmddsqdmxService.dDUpdate(pcmddsqdmx);
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(pcmddsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-SQBTG-all')")
    @ApiOperation(value = "申请不通过", tags = {"PcmDdsqdmx" },  notes = "申请不通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqdmxes/{pcmddsqdmx_id}/sqbtg")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> sQBTG(@PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx pcmddsqdmx = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        pcmddsqdmx.setPcmddsqdmxid(pcmddsqdmx_id);
        pcmddsqdmx = pcmddsqdmxService.sQBTG(pcmddsqdmx);
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(pcmddsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JDCZ-all')")
    @ApiOperation(value = "借调操作", tags = {"PcmDdsqdmx" },  notes = "借调操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqdmxes/{pcmddsqdmx_id}/jdcz")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> jDCZ(@PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx pcmddsqdmx = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        pcmddsqdmx.setPcmddsqdmxid(pcmddsqdmx_id);
        pcmddsqdmx = pcmddsqdmxService.jDCZ(pcmddsqdmx);
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(pcmddsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @ApiOperation(value = "GetDraft", tags = {"PcmDdsqdmx" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmddsqdmxes/getdraft")
    public ResponseEntity<PcmDdsqdmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxMapping.toDto(pcmddsqdmxService.getDraft(new PcmDdsqdmx())));
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdto),'ehr-PcmDdsqdmx-Create')")
    @ApiOperation(value = "Create", tags = {"PcmDdsqdmx" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqdmxes")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> create(@RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
		pcmddsqdmxService.create(domain);
        PcmDdsqdmxDTO dto = pcmddsqdmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdtos),'ehr-PcmDdsqdmx-Create')")
    @ApiOperation(value = "createBatch", tags = {"PcmDdsqdmx" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqdmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmDdsqdmxDTO> pcmddsqdmxdtos) {
        pcmddsqdmxService.createBatch(pcmddsqdmxMapping.toDomain(pcmddsqdmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-DDCreate-all')")
    @ApiOperation(value = "调动更新", tags = {"PcmDdsqdmx" },  notes = "调动更新")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqdmxes/{pcmddsqdmx_id}/ddcreate")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> dDCreate(@PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx pcmddsqdmx = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        pcmddsqdmx.setPcmddsqdmxid(pcmddsqdmx_id);
        pcmddsqdmx = pcmddsqdmxService.dDCreate(pcmddsqdmx);
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(pcmddsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PostAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(returnObject.body),'ehr-PcmDdsqdmx-Get')")
    @ApiOperation(value = "Get", tags = {"PcmDdsqdmx" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmddsqdmxes/{pcmddsqdmx_id}")
    public ResponseEntity<PcmDdsqdmxDTO> get(@PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id) {
        PcmDdsqdmx domain = pcmddsqdmxService.get(pcmddsqdmx_id);
        PcmDdsqdmxDTO dto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxService.get(#pcmddsqdmx_id),'ehr-PcmDdsqdmx-Remove')")
    @ApiOperation(value = "Remove", tags = {"PcmDdsqdmx" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmddsqdmxes/{pcmddsqdmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxService.remove(pcmddsqdmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxService.getPcmddsqdmxByIds(#ids),'ehr-PcmDdsqdmx-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PcmDdsqdmx" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmddsqdmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmddsqdmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-ZZSQ-all')")
    @ApiOperation(value = "自助申请", tags = {"PcmDdsqdmx" },  notes = "自助申请")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqdmxes/{pcmddsqdmx_id}/zzsq")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> zZSQ(@PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx pcmddsqdmx = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        pcmddsqdmx.setPcmddsqdmxid(pcmddsqdmx_id);
        pcmddsqdmx = pcmddsqdmxService.zZSQ(pcmddsqdmx);
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(pcmddsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @ApiOperation(value = "CheckKey", tags = {"PcmDdsqdmx" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqdmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxService.checkKey(pcmddsqdmxMapping.toDomain(pcmddsqdmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-DDCZ-all')")
    @ApiOperation(value = "调动操作", tags = {"PcmDdsqdmx" },  notes = "调动操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqdmxes/{pcmddsqdmx_id}/ddcz")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> dDCZ(@PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx pcmddsqdmx = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        pcmddsqdmx.setPcmddsqdmxid(pcmddsqdmx_id);
        pcmddsqdmx = pcmddsqdmxService.dDCZ(pcmddsqdmx);
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(pcmddsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-SQTG-all')")
    @ApiOperation(value = "申请通过", tags = {"PcmDdsqdmx" },  notes = "申请通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqdmxes/{pcmddsqdmx_id}/sqtg")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> sQTG(@PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx pcmddsqdmx = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        pcmddsqdmx.setPcmddsqdmxid(pcmddsqdmx_id);
        pcmddsqdmx = pcmddsqdmxService.sQTG(pcmddsqdmx);
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(pcmddsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdto),'ehr-PcmDdsqdmx-Save')")
    @ApiOperation(value = "Save", tags = {"PcmDdsqdmx" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqdmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxService.save(pcmddsqdmxMapping.toDomain(pcmddsqdmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdtos),'ehr-PcmDdsqdmx-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PcmDdsqdmx" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqdmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmDdsqdmxDTO> pcmddsqdmxdtos) {
        pcmddsqdmxService.saveBatch(pcmddsqdmxMapping.toDomain(pcmddsqdmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JZCZ-all')")
    @ApiOperation(value = "兼职操作", tags = {"PcmDdsqdmx" },  notes = "兼职操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqdmxes/{pcmddsqdmx_id}/jzcz")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> jZCZ(@PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx pcmddsqdmx = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        pcmddsqdmx.setPcmddsqdmxid(pcmddsqdmx_id);
        pcmddsqdmx = pcmddsqdmxService.jZCZ(pcmddsqdmx);
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(pcmddsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JZSQMX-all')")
	@ApiOperation(value = "fetch兼职申请明细（未审核完成）", tags = {"PcmDdsqdmx" } ,notes = "fetch兼职申请明细（未审核完成）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqdmxes/fetchjzsqmx")
	public ResponseEntity<List<PcmDdsqdmxDTO>> fetchJZSQMX(PcmDdsqdmxSearchContext context) {
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchJZSQMX(context) ;
        List<PcmDdsqdmxDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JZSQMX-all')")
	@ApiOperation(value = "search兼职申请明细（未审核完成）", tags = {"PcmDdsqdmx" } ,notes = "search兼职申请明细（未审核完成）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqdmxes/searchjzsqmx")
	public ResponseEntity<Page<PcmDdsqdmxDTO>> searchJZSQMX(@RequestBody PcmDdsqdmxSearchContext context) {
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchJZSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JDSQGR-all')")
	@ApiOperation(value = "fetch借调申请（个人）", tags = {"PcmDdsqdmx" } ,notes = "fetch借调申请（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqdmxes/fetchjdsqgr")
	public ResponseEntity<List<PcmDdsqdmxDTO>> fetchJDSQGR(PcmDdsqdmxSearchContext context) {
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchJDSQGR(context) ;
        List<PcmDdsqdmxDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JDSQGR-all')")
	@ApiOperation(value = "search借调申请（个人）", tags = {"PcmDdsqdmx" } ,notes = "search借调申请（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqdmxes/searchjdsqgr")
	public ResponseEntity<Page<PcmDdsqdmxDTO>> searchJDSQGR(@RequestBody PcmDdsqdmxSearchContext context) {
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchJDSQGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PcmDdsqdmx" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqdmxes/fetchdefault")
	public ResponseEntity<List<PcmDdsqdmxDTO>> fetchDefault(PcmDdsqdmxSearchContext context) {
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchDefault(context) ;
        List<PcmDdsqdmxDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PcmDdsqdmx" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqdmxes/searchdefault")
	public ResponseEntity<Page<PcmDdsqdmxDTO>> searchDefault(@RequestBody PcmDdsqdmxSearchContext context) {
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JDSQMX-all')")
	@ApiOperation(value = "fetch借调申请明细（未审核完成）", tags = {"PcmDdsqdmx" } ,notes = "fetch借调申请明细（未审核完成）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqdmxes/fetchjdsqmx")
	public ResponseEntity<List<PcmDdsqdmxDTO>> fetchJDSQMX(PcmDdsqdmxSearchContext context) {
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchJDSQMX(context) ;
        List<PcmDdsqdmxDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JDSQMX-all')")
	@ApiOperation(value = "search借调申请明细（未审核完成）", tags = {"PcmDdsqdmx" } ,notes = "search借调申请明细（未审核完成）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqdmxes/searchjdsqmx")
	public ResponseEntity<Page<PcmDdsqdmxDTO>> searchJDSQMX(@RequestBody PcmDdsqdmxSearchContext context) {
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchJDSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-DDJL-all')")
	@ApiOperation(value = "fetch调动记录", tags = {"PcmDdsqdmx" } ,notes = "fetch调动记录")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqdmxes/fetchddjl")
	public ResponseEntity<List<PcmDdsqdmxDTO>> fetchDDJL(PcmDdsqdmxSearchContext context) {
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchDDJL(context) ;
        List<PcmDdsqdmxDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-DDJL-all')")
	@ApiOperation(value = "search调动记录", tags = {"PcmDdsqdmx" } ,notes = "search调动记录")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqdmxes/searchddjl")
	public ResponseEntity<Page<PcmDdsqdmxDTO>> searchDDJL(@RequestBody PcmDdsqdmxSearchContext context) {
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchDDJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-GBDDJL-all')")
	@ApiOperation(value = "fetch调动记录", tags = {"PcmDdsqdmx" } ,notes = "fetch调动记录")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqdmxes/fetchgbddjl")
	public ResponseEntity<List<PcmDdsqdmxDTO>> fetchGBDDJL(PcmDdsqdmxSearchContext context) {
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchGBDDJL(context) ;
        List<PcmDdsqdmxDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-GBDDJL-all')")
	@ApiOperation(value = "search调动记录", tags = {"PcmDdsqdmx" } ,notes = "search调动记录")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqdmxes/searchgbddjl")
	public ResponseEntity<Page<PcmDdsqdmxDTO>> searchGBDDJL(@RequestBody PcmDdsqdmxSearchContext context) {
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchGBDDJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-DDSQGR-all')")
	@ApiOperation(value = "fetch调动申请（个人）", tags = {"PcmDdsqdmx" } ,notes = "fetch调动申请（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqdmxes/fetchddsqgr")
	public ResponseEntity<List<PcmDdsqdmxDTO>> fetchDDSQGR(PcmDdsqdmxSearchContext context) {
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchDDSQGR(context) ;
        List<PcmDdsqdmxDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-DDSQGR-all')")
	@ApiOperation(value = "search调动申请（个人）", tags = {"PcmDdsqdmx" } ,notes = "search调动申请（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqdmxes/searchddsqgr")
	public ResponseEntity<Page<PcmDdsqdmxDTO>> searchDDSQGR(@RequestBody PcmDdsqdmxSearchContext context) {
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchDDSQGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-DDMX-all')")
	@ApiOperation(value = "fetch调动明细", tags = {"PcmDdsqdmx" } ,notes = "fetch调动明细")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqdmxes/fetchddmx")
	public ResponseEntity<List<PcmDdsqdmxDTO>> fetchDDMX(PcmDdsqdmxSearchContext context) {
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchDDMX(context) ;
        List<PcmDdsqdmxDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-DDMX-all')")
	@ApiOperation(value = "search调动明细", tags = {"PcmDdsqdmx" } ,notes = "search调动明细")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqdmxes/searchddmx")
	public ResponseEntity<Page<PcmDdsqdmxDTO>> searchDDMX(@RequestBody PcmDdsqdmxSearchContext context) {
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchDDMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JZSQGR-all')")
	@ApiOperation(value = "fetch兼职申请（个人）", tags = {"PcmDdsqdmx" } ,notes = "fetch兼职申请（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqdmxes/fetchjzsqgr")
	public ResponseEntity<List<PcmDdsqdmxDTO>> fetchJZSQGR(PcmDdsqdmxSearchContext context) {
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchJZSQGR(context) ;
        List<PcmDdsqdmxDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JZSQGR-all')")
	@ApiOperation(value = "search兼职申请（个人）", tags = {"PcmDdsqdmx" } ,notes = "search兼职申请（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqdmxes/searchjzsqgr")
	public ResponseEntity<Page<PcmDdsqdmxDTO>> searchJZSQGR(@RequestBody PcmDdsqdmxSearchContext context) {
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchJZSQGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pcmddsqdmxService.get(#pcmddsqdmx_id),'ehr-PcmDdsqdmx-Update')")
    @ApiOperation(value = "UpdateByPcmDdsqd", tags = {"PcmDdsqdmx" },  notes = "UpdateByPcmDdsqd")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/{pcmddsqdmx_id}")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> updateByPcmDdsqd(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPcmddsqdid(pcmddsqd_id);
        domain.setPcmddsqdmxid(pcmddsqdmx_id);
		pcmddsqdmxService.update(domain);
        PcmDdsqdmxDTO dto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxService.getPcmddsqdmxByEntities(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdtos)),'ehr-PcmDdsqdmx-Update')")
    @ApiOperation(value = "UpdateBatchByPcmDdsqd", tags = {"PcmDdsqdmx" },  notes = "UpdateBatchByPcmDdsqd")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/batch")
    public ResponseEntity<Boolean> updateBatchByPcmDdsqd(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @RequestBody List<PcmDdsqdmxDTO> pcmddsqdmxdtos) {
        List<PcmDdsqdmx> domainlist=pcmddsqdmxMapping.toDomain(pcmddsqdmxdtos);
        for(PcmDdsqdmx domain:domainlist){
            domain.setPcmddsqdid(pcmddsqd_id);
        }
        pcmddsqdmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-DDUpdate-all')")
    @ApiOperation(value = "调动更正ByPcmDdsqd", tags = {"PcmDdsqdmx" },  notes = "调动更正ByPcmDdsqd")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/{pcmddsqdmx_id}/ddupdate")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> dDUpdateByPcmDdsqd(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPcmddsqdid(pcmddsqd_id);
        domain = pcmddsqdmxService.dDUpdate(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-SQBTG-all')")
    @ApiOperation(value = "申请不通过ByPcmDdsqd", tags = {"PcmDdsqdmx" },  notes = "申请不通过ByPcmDdsqd")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/{pcmddsqdmx_id}/sqbtg")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> sQBTGByPcmDdsqd(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPcmddsqdid(pcmddsqd_id);
        domain = pcmddsqdmxService.sQBTG(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JDCZ-all')")
    @ApiOperation(value = "借调操作ByPcmDdsqd", tags = {"PcmDdsqdmx" },  notes = "借调操作ByPcmDdsqd")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/{pcmddsqdmx_id}/jdcz")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> jDCZByPcmDdsqd(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPcmddsqdid(pcmddsqd_id);
        domain = pcmddsqdmxService.jDCZ(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @ApiOperation(value = "GetDraftByPcmDdsqd", tags = {"PcmDdsqdmx" },  notes = "GetDraftByPcmDdsqd")
    @RequestMapping(method = RequestMethod.GET, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/getdraft")
    public ResponseEntity<PcmDdsqdmxDTO> getDraftByPcmDdsqd(@PathVariable("pcmddsqd_id") String pcmddsqd_id) {
        PcmDdsqdmx domain = new PcmDdsqdmx();
        domain.setPcmddsqdid(pcmddsqd_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxMapping.toDto(pcmddsqdmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdto),'ehr-PcmDdsqdmx-Create')")
    @ApiOperation(value = "CreateByPcmDdsqd", tags = {"PcmDdsqdmx" },  notes = "CreateByPcmDdsqd")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> createByPcmDdsqd(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPcmddsqdid(pcmddsqd_id);
		pcmddsqdmxService.create(domain);
        PcmDdsqdmxDTO dto = pcmddsqdmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdtos),'ehr-PcmDdsqdmx-Create')")
    @ApiOperation(value = "createBatchByPcmDdsqd", tags = {"PcmDdsqdmx" },  notes = "createBatchByPcmDdsqd")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/batch")
    public ResponseEntity<Boolean> createBatchByPcmDdsqd(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @RequestBody List<PcmDdsqdmxDTO> pcmddsqdmxdtos) {
        List<PcmDdsqdmx> domainlist=pcmddsqdmxMapping.toDomain(pcmddsqdmxdtos);
        for(PcmDdsqdmx domain:domainlist){
            domain.setPcmddsqdid(pcmddsqd_id);
        }
        pcmddsqdmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-DDCreate-all')")
    @ApiOperation(value = "调动更新ByPcmDdsqd", tags = {"PcmDdsqdmx" },  notes = "调动更新ByPcmDdsqd")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/{pcmddsqdmx_id}/ddcreate")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> dDCreateByPcmDdsqd(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPcmddsqdid(pcmddsqd_id);
        domain = pcmddsqdmxService.dDCreate(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PostAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(returnObject.body),'ehr-PcmDdsqdmx-Get')")
    @ApiOperation(value = "GetByPcmDdsqd", tags = {"PcmDdsqdmx" },  notes = "GetByPcmDdsqd")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/{pcmddsqdmx_id}")
    public ResponseEntity<PcmDdsqdmxDTO> getByPcmDdsqd(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id) {
        PcmDdsqdmx domain = pcmddsqdmxService.get(pcmddsqdmx_id);
        PcmDdsqdmxDTO dto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxService.get(#pcmddsqdmx_id),'ehr-PcmDdsqdmx-Remove')")
    @ApiOperation(value = "RemoveByPcmDdsqd", tags = {"PcmDdsqdmx" },  notes = "RemoveByPcmDdsqd")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/{pcmddsqdmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPcmDdsqd(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxService.remove(pcmddsqdmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxService.getPcmddsqdmxByIds(#ids),'ehr-PcmDdsqdmx-Remove')")
    @ApiOperation(value = "RemoveBatchByPcmDdsqd", tags = {"PcmDdsqdmx" },  notes = "RemoveBatchByPcmDdsqd")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/batch")
    public ResponseEntity<Boolean> removeBatchByPcmDdsqd(@RequestBody List<String> ids) {
        pcmddsqdmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-ZZSQ-all')")
    @ApiOperation(value = "自助申请ByPcmDdsqd", tags = {"PcmDdsqdmx" },  notes = "自助申请ByPcmDdsqd")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/{pcmddsqdmx_id}/zzsq")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> zZSQByPcmDdsqd(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPcmddsqdid(pcmddsqd_id);
        domain = pcmddsqdmxService.zZSQ(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @ApiOperation(value = "CheckKeyByPcmDdsqd", tags = {"PcmDdsqdmx" },  notes = "CheckKeyByPcmDdsqd")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPcmDdsqd(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxService.checkKey(pcmddsqdmxMapping.toDomain(pcmddsqdmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-DDCZ-all')")
    @ApiOperation(value = "调动操作ByPcmDdsqd", tags = {"PcmDdsqdmx" },  notes = "调动操作ByPcmDdsqd")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/{pcmddsqdmx_id}/ddcz")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> dDCZByPcmDdsqd(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPcmddsqdid(pcmddsqd_id);
        domain = pcmddsqdmxService.dDCZ(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-SQTG-all')")
    @ApiOperation(value = "申请通过ByPcmDdsqd", tags = {"PcmDdsqdmx" },  notes = "申请通过ByPcmDdsqd")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/{pcmddsqdmx_id}/sqtg")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> sQTGByPcmDdsqd(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPcmddsqdid(pcmddsqd_id);
        domain = pcmddsqdmxService.sQTG(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdto),'ehr-PcmDdsqdmx-Save')")
    @ApiOperation(value = "SaveByPcmDdsqd", tags = {"PcmDdsqdmx" },  notes = "SaveByPcmDdsqd")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/save")
    public ResponseEntity<Boolean> saveByPcmDdsqd(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPcmddsqdid(pcmddsqd_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdtos),'ehr-PcmDdsqdmx-Save')")
    @ApiOperation(value = "SaveBatchByPcmDdsqd", tags = {"PcmDdsqdmx" },  notes = "SaveBatchByPcmDdsqd")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPcmDdsqd(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @RequestBody List<PcmDdsqdmxDTO> pcmddsqdmxdtos) {
        List<PcmDdsqdmx> domainlist=pcmddsqdmxMapping.toDomain(pcmddsqdmxdtos);
        for(PcmDdsqdmx domain:domainlist){
             domain.setPcmddsqdid(pcmddsqd_id);
        }
        pcmddsqdmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JZCZ-all')")
    @ApiOperation(value = "兼职操作ByPcmDdsqd", tags = {"PcmDdsqdmx" },  notes = "兼职操作ByPcmDdsqd")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/{pcmddsqdmx_id}/jzcz")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> jZCZByPcmDdsqd(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPcmddsqdid(pcmddsqd_id);
        domain = pcmddsqdmxService.jZCZ(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JZSQMX-all')")
	@ApiOperation(value = "fetch兼职申请明细（未审核完成）ByPcmDdsqd", tags = {"PcmDdsqdmx" } ,notes = "fetch兼职申请明细（未审核完成）ByPcmDdsqd")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/fetchjzsqmx")
	public ResponseEntity<List<PcmDdsqdmxDTO>> fetchPcmDdsqdmxJZSQMXByPcmDdsqd(@PathVariable("pcmddsqd_id") String pcmddsqd_id,PcmDdsqdmxSearchContext context) {
        context.setN_pcmddsqdid_eq(pcmddsqd_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchJZSQMX(context) ;
        List<PcmDdsqdmxDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JZSQMX-all')")
	@ApiOperation(value = "search兼职申请明细（未审核完成）ByPcmDdsqd", tags = {"PcmDdsqdmx" } ,notes = "search兼职申请明细（未审核完成）ByPcmDdsqd")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/searchjzsqmx")
	public ResponseEntity<Page<PcmDdsqdmxDTO>> searchPcmDdsqdmxJZSQMXByPcmDdsqd(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @RequestBody PcmDdsqdmxSearchContext context) {
        context.setN_pcmddsqdid_eq(pcmddsqd_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchJZSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JDSQGR-all')")
	@ApiOperation(value = "fetch借调申请（个人）ByPcmDdsqd", tags = {"PcmDdsqdmx" } ,notes = "fetch借调申请（个人）ByPcmDdsqd")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/fetchjdsqgr")
	public ResponseEntity<List<PcmDdsqdmxDTO>> fetchPcmDdsqdmxJDSQGRByPcmDdsqd(@PathVariable("pcmddsqd_id") String pcmddsqd_id,PcmDdsqdmxSearchContext context) {
        context.setN_pcmddsqdid_eq(pcmddsqd_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchJDSQGR(context) ;
        List<PcmDdsqdmxDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JDSQGR-all')")
	@ApiOperation(value = "search借调申请（个人）ByPcmDdsqd", tags = {"PcmDdsqdmx" } ,notes = "search借调申请（个人）ByPcmDdsqd")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/searchjdsqgr")
	public ResponseEntity<Page<PcmDdsqdmxDTO>> searchPcmDdsqdmxJDSQGRByPcmDdsqd(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @RequestBody PcmDdsqdmxSearchContext context) {
        context.setN_pcmddsqdid_eq(pcmddsqd_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchJDSQGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPcmDdsqd", tags = {"PcmDdsqdmx" } ,notes = "fetchDEFAULTByPcmDdsqd")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/fetchdefault")
	public ResponseEntity<List<PcmDdsqdmxDTO>> fetchPcmDdsqdmxDefaultByPcmDdsqd(@PathVariable("pcmddsqd_id") String pcmddsqd_id,PcmDdsqdmxSearchContext context) {
        context.setN_pcmddsqdid_eq(pcmddsqd_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchDefault(context) ;
        List<PcmDdsqdmxDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPcmDdsqd", tags = {"PcmDdsqdmx" } ,notes = "searchDEFAULTByPcmDdsqd")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/searchdefault")
	public ResponseEntity<Page<PcmDdsqdmxDTO>> searchPcmDdsqdmxDefaultByPcmDdsqd(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @RequestBody PcmDdsqdmxSearchContext context) {
        context.setN_pcmddsqdid_eq(pcmddsqd_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JDSQMX-all')")
	@ApiOperation(value = "fetch借调申请明细（未审核完成）ByPcmDdsqd", tags = {"PcmDdsqdmx" } ,notes = "fetch借调申请明细（未审核完成）ByPcmDdsqd")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/fetchjdsqmx")
	public ResponseEntity<List<PcmDdsqdmxDTO>> fetchPcmDdsqdmxJDSQMXByPcmDdsqd(@PathVariable("pcmddsqd_id") String pcmddsqd_id,PcmDdsqdmxSearchContext context) {
        context.setN_pcmddsqdid_eq(pcmddsqd_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchJDSQMX(context) ;
        List<PcmDdsqdmxDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JDSQMX-all')")
	@ApiOperation(value = "search借调申请明细（未审核完成）ByPcmDdsqd", tags = {"PcmDdsqdmx" } ,notes = "search借调申请明细（未审核完成）ByPcmDdsqd")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/searchjdsqmx")
	public ResponseEntity<Page<PcmDdsqdmxDTO>> searchPcmDdsqdmxJDSQMXByPcmDdsqd(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @RequestBody PcmDdsqdmxSearchContext context) {
        context.setN_pcmddsqdid_eq(pcmddsqd_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchJDSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-DDJL-all')")
	@ApiOperation(value = "fetch调动记录ByPcmDdsqd", tags = {"PcmDdsqdmx" } ,notes = "fetch调动记录ByPcmDdsqd")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/fetchddjl")
	public ResponseEntity<List<PcmDdsqdmxDTO>> fetchPcmDdsqdmxDDJLByPcmDdsqd(@PathVariable("pcmddsqd_id") String pcmddsqd_id,PcmDdsqdmxSearchContext context) {
        context.setN_pcmddsqdid_eq(pcmddsqd_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchDDJL(context) ;
        List<PcmDdsqdmxDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-DDJL-all')")
	@ApiOperation(value = "search调动记录ByPcmDdsqd", tags = {"PcmDdsqdmx" } ,notes = "search调动记录ByPcmDdsqd")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/searchddjl")
	public ResponseEntity<Page<PcmDdsqdmxDTO>> searchPcmDdsqdmxDDJLByPcmDdsqd(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @RequestBody PcmDdsqdmxSearchContext context) {
        context.setN_pcmddsqdid_eq(pcmddsqd_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchDDJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-GBDDJL-all')")
	@ApiOperation(value = "fetch调动记录ByPcmDdsqd", tags = {"PcmDdsqdmx" } ,notes = "fetch调动记录ByPcmDdsqd")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/fetchgbddjl")
	public ResponseEntity<List<PcmDdsqdmxDTO>> fetchPcmDdsqdmxGBDDJLByPcmDdsqd(@PathVariable("pcmddsqd_id") String pcmddsqd_id,PcmDdsqdmxSearchContext context) {
        context.setN_pcmddsqdid_eq(pcmddsqd_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchGBDDJL(context) ;
        List<PcmDdsqdmxDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-GBDDJL-all')")
	@ApiOperation(value = "search调动记录ByPcmDdsqd", tags = {"PcmDdsqdmx" } ,notes = "search调动记录ByPcmDdsqd")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/searchgbddjl")
	public ResponseEntity<Page<PcmDdsqdmxDTO>> searchPcmDdsqdmxGBDDJLByPcmDdsqd(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @RequestBody PcmDdsqdmxSearchContext context) {
        context.setN_pcmddsqdid_eq(pcmddsqd_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchGBDDJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-DDSQGR-all')")
	@ApiOperation(value = "fetch调动申请（个人）ByPcmDdsqd", tags = {"PcmDdsqdmx" } ,notes = "fetch调动申请（个人）ByPcmDdsqd")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/fetchddsqgr")
	public ResponseEntity<List<PcmDdsqdmxDTO>> fetchPcmDdsqdmxDDSQGRByPcmDdsqd(@PathVariable("pcmddsqd_id") String pcmddsqd_id,PcmDdsqdmxSearchContext context) {
        context.setN_pcmddsqdid_eq(pcmddsqd_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchDDSQGR(context) ;
        List<PcmDdsqdmxDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-DDSQGR-all')")
	@ApiOperation(value = "search调动申请（个人）ByPcmDdsqd", tags = {"PcmDdsqdmx" } ,notes = "search调动申请（个人）ByPcmDdsqd")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/searchddsqgr")
	public ResponseEntity<Page<PcmDdsqdmxDTO>> searchPcmDdsqdmxDDSQGRByPcmDdsqd(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @RequestBody PcmDdsqdmxSearchContext context) {
        context.setN_pcmddsqdid_eq(pcmddsqd_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchDDSQGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-DDMX-all')")
	@ApiOperation(value = "fetch调动明细ByPcmDdsqd", tags = {"PcmDdsqdmx" } ,notes = "fetch调动明细ByPcmDdsqd")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/fetchddmx")
	public ResponseEntity<List<PcmDdsqdmxDTO>> fetchPcmDdsqdmxDDMXByPcmDdsqd(@PathVariable("pcmddsqd_id") String pcmddsqd_id,PcmDdsqdmxSearchContext context) {
        context.setN_pcmddsqdid_eq(pcmddsqd_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchDDMX(context) ;
        List<PcmDdsqdmxDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-DDMX-all')")
	@ApiOperation(value = "search调动明细ByPcmDdsqd", tags = {"PcmDdsqdmx" } ,notes = "search调动明细ByPcmDdsqd")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/searchddmx")
	public ResponseEntity<Page<PcmDdsqdmxDTO>> searchPcmDdsqdmxDDMXByPcmDdsqd(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @RequestBody PcmDdsqdmxSearchContext context) {
        context.setN_pcmddsqdid_eq(pcmddsqd_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchDDMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JZSQGR-all')")
	@ApiOperation(value = "fetch兼职申请（个人）ByPcmDdsqd", tags = {"PcmDdsqdmx" } ,notes = "fetch兼职申请（个人）ByPcmDdsqd")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/fetchjzsqgr")
	public ResponseEntity<List<PcmDdsqdmxDTO>> fetchPcmDdsqdmxJZSQGRByPcmDdsqd(@PathVariable("pcmddsqd_id") String pcmddsqd_id,PcmDdsqdmxSearchContext context) {
        context.setN_pcmddsqdid_eq(pcmddsqd_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchJZSQGR(context) ;
        List<PcmDdsqdmxDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JZSQGR-all')")
	@ApiOperation(value = "search兼职申请（个人）ByPcmDdsqd", tags = {"PcmDdsqdmx" } ,notes = "search兼职申请（个人）ByPcmDdsqd")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/searchjzsqgr")
	public ResponseEntity<Page<PcmDdsqdmxDTO>> searchPcmDdsqdmxJZSQGRByPcmDdsqd(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @RequestBody PcmDdsqdmxSearchContext context) {
        context.setN_pcmddsqdid_eq(pcmddsqd_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchJZSQGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pcmddsqdmxService.get(#pcmddsqdmx_id),'ehr-PcmDdsqdmx-Update')")
    @ApiOperation(value = "UpdateByPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "UpdateByPimDistirbution")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> updateByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain.setPcmddsqdmxid(pcmddsqdmx_id);
		pcmddsqdmxService.update(domain);
        PcmDdsqdmxDTO dto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxService.getPcmddsqdmxByEntities(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdtos)),'ehr-PcmDdsqdmx-Update')")
    @ApiOperation(value = "UpdateBatchByPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "UpdateBatchByPimDistirbution")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/batch")
    public ResponseEntity<Boolean> updateBatchByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody List<PcmDdsqdmxDTO> pcmddsqdmxdtos) {
        List<PcmDdsqdmx> domainlist=pcmddsqdmxMapping.toDomain(pcmddsqdmxdtos);
        for(PcmDdsqdmx domain:domainlist){
            domain.setPimdistirbutionid(pimdistirbution_id);
        }
        pcmddsqdmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-DDUpdate-all')")
    @ApiOperation(value = "调动更正ByPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "调动更正ByPimDistirbution")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}/ddupdate")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> dDUpdateByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain = pcmddsqdmxService.dDUpdate(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-SQBTG-all')")
    @ApiOperation(value = "申请不通过ByPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "申请不通过ByPimDistirbution")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}/sqbtg")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> sQBTGByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain = pcmddsqdmxService.sQBTG(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JDCZ-all')")
    @ApiOperation(value = "借调操作ByPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "借调操作ByPimDistirbution")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}/jdcz")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> jDCZByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain = pcmddsqdmxService.jDCZ(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @ApiOperation(value = "GetDraftByPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "GetDraftByPimDistirbution")
    @RequestMapping(method = RequestMethod.GET, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/getdraft")
    public ResponseEntity<PcmDdsqdmxDTO> getDraftByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id) {
        PcmDdsqdmx domain = new PcmDdsqdmx();
        domain.setPimdistirbutionid(pimdistirbution_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxMapping.toDto(pcmddsqdmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdto),'ehr-PcmDdsqdmx-Create')")
    @ApiOperation(value = "CreateByPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "CreateByPimDistirbution")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> createByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
		pcmddsqdmxService.create(domain);
        PcmDdsqdmxDTO dto = pcmddsqdmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdtos),'ehr-PcmDdsqdmx-Create')")
    @ApiOperation(value = "createBatchByPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "createBatchByPimDistirbution")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/batch")
    public ResponseEntity<Boolean> createBatchByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody List<PcmDdsqdmxDTO> pcmddsqdmxdtos) {
        List<PcmDdsqdmx> domainlist=pcmddsqdmxMapping.toDomain(pcmddsqdmxdtos);
        for(PcmDdsqdmx domain:domainlist){
            domain.setPimdistirbutionid(pimdistirbution_id);
        }
        pcmddsqdmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-DDCreate-all')")
    @ApiOperation(value = "调动更新ByPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "调动更新ByPimDistirbution")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}/ddcreate")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> dDCreateByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain = pcmddsqdmxService.dDCreate(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PostAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(returnObject.body),'ehr-PcmDdsqdmx-Get')")
    @ApiOperation(value = "GetByPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "GetByPimDistirbution")
	@RequestMapping(method = RequestMethod.GET, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}")
    public ResponseEntity<PcmDdsqdmxDTO> getByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id) {
        PcmDdsqdmx domain = pcmddsqdmxService.get(pcmddsqdmx_id);
        PcmDdsqdmxDTO dto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxService.get(#pcmddsqdmx_id),'ehr-PcmDdsqdmx-Remove')")
    @ApiOperation(value = "RemoveByPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "RemoveByPimDistirbution")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxService.remove(pcmddsqdmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxService.getPcmddsqdmxByIds(#ids),'ehr-PcmDdsqdmx-Remove')")
    @ApiOperation(value = "RemoveBatchByPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "RemoveBatchByPimDistirbution")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/batch")
    public ResponseEntity<Boolean> removeBatchByPimDistirbution(@RequestBody List<String> ids) {
        pcmddsqdmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-ZZSQ-all')")
    @ApiOperation(value = "自助申请ByPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "自助申请ByPimDistirbution")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}/zzsq")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> zZSQByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain = pcmddsqdmxService.zZSQ(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @ApiOperation(value = "CheckKeyByPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "CheckKeyByPimDistirbution")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxService.checkKey(pcmddsqdmxMapping.toDomain(pcmddsqdmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-DDCZ-all')")
    @ApiOperation(value = "调动操作ByPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "调动操作ByPimDistirbution")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}/ddcz")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> dDCZByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain = pcmddsqdmxService.dDCZ(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-SQTG-all')")
    @ApiOperation(value = "申请通过ByPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "申请通过ByPimDistirbution")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}/sqtg")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> sQTGByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain = pcmddsqdmxService.sQTG(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdto),'ehr-PcmDdsqdmx-Save')")
    @ApiOperation(value = "SaveByPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "SaveByPimDistirbution")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/save")
    public ResponseEntity<Boolean> saveByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdtos),'ehr-PcmDdsqdmx-Save')")
    @ApiOperation(value = "SaveBatchByPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "SaveBatchByPimDistirbution")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody List<PcmDdsqdmxDTO> pcmddsqdmxdtos) {
        List<PcmDdsqdmx> domainlist=pcmddsqdmxMapping.toDomain(pcmddsqdmxdtos);
        for(PcmDdsqdmx domain:domainlist){
             domain.setPimdistirbutionid(pimdistirbution_id);
        }
        pcmddsqdmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JZCZ-all')")
    @ApiOperation(value = "兼职操作ByPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "兼职操作ByPimDistirbution")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}/jzcz")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> jZCZByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain = pcmddsqdmxService.jZCZ(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JZSQMX-all')")
	@ApiOperation(value = "fetch兼职申请明细（未审核完成）ByPimDistirbution", tags = {"PcmDdsqdmx" } ,notes = "fetch兼职申请明细（未审核完成）ByPimDistirbution")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/fetchjzsqmx")
	public ResponseEntity<List<PcmDdsqdmxDTO>> fetchPcmDdsqdmxJZSQMXByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id,PcmDdsqdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchJZSQMX(context) ;
        List<PcmDdsqdmxDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JZSQMX-all')")
	@ApiOperation(value = "search兼职申请明细（未审核完成）ByPimDistirbution", tags = {"PcmDdsqdmx" } ,notes = "search兼职申请明细（未审核完成）ByPimDistirbution")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/searchjzsqmx")
	public ResponseEntity<Page<PcmDdsqdmxDTO>> searchPcmDdsqdmxJZSQMXByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PcmDdsqdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchJZSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JDSQGR-all')")
	@ApiOperation(value = "fetch借调申请（个人）ByPimDistirbution", tags = {"PcmDdsqdmx" } ,notes = "fetch借调申请（个人）ByPimDistirbution")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/fetchjdsqgr")
	public ResponseEntity<List<PcmDdsqdmxDTO>> fetchPcmDdsqdmxJDSQGRByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id,PcmDdsqdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchJDSQGR(context) ;
        List<PcmDdsqdmxDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JDSQGR-all')")
	@ApiOperation(value = "search借调申请（个人）ByPimDistirbution", tags = {"PcmDdsqdmx" } ,notes = "search借调申请（个人）ByPimDistirbution")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/searchjdsqgr")
	public ResponseEntity<Page<PcmDdsqdmxDTO>> searchPcmDdsqdmxJDSQGRByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PcmDdsqdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchJDSQGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPimDistirbution", tags = {"PcmDdsqdmx" } ,notes = "fetchDEFAULTByPimDistirbution")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/fetchdefault")
	public ResponseEntity<List<PcmDdsqdmxDTO>> fetchPcmDdsqdmxDefaultByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id,PcmDdsqdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchDefault(context) ;
        List<PcmDdsqdmxDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPimDistirbution", tags = {"PcmDdsqdmx" } ,notes = "searchDEFAULTByPimDistirbution")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/searchdefault")
	public ResponseEntity<Page<PcmDdsqdmxDTO>> searchPcmDdsqdmxDefaultByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PcmDdsqdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JDSQMX-all')")
	@ApiOperation(value = "fetch借调申请明细（未审核完成）ByPimDistirbution", tags = {"PcmDdsqdmx" } ,notes = "fetch借调申请明细（未审核完成）ByPimDistirbution")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/fetchjdsqmx")
	public ResponseEntity<List<PcmDdsqdmxDTO>> fetchPcmDdsqdmxJDSQMXByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id,PcmDdsqdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchJDSQMX(context) ;
        List<PcmDdsqdmxDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JDSQMX-all')")
	@ApiOperation(value = "search借调申请明细（未审核完成）ByPimDistirbution", tags = {"PcmDdsqdmx" } ,notes = "search借调申请明细（未审核完成）ByPimDistirbution")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/searchjdsqmx")
	public ResponseEntity<Page<PcmDdsqdmxDTO>> searchPcmDdsqdmxJDSQMXByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PcmDdsqdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchJDSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-DDJL-all')")
	@ApiOperation(value = "fetch调动记录ByPimDistirbution", tags = {"PcmDdsqdmx" } ,notes = "fetch调动记录ByPimDistirbution")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/fetchddjl")
	public ResponseEntity<List<PcmDdsqdmxDTO>> fetchPcmDdsqdmxDDJLByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id,PcmDdsqdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchDDJL(context) ;
        List<PcmDdsqdmxDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-DDJL-all')")
	@ApiOperation(value = "search调动记录ByPimDistirbution", tags = {"PcmDdsqdmx" } ,notes = "search调动记录ByPimDistirbution")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/searchddjl")
	public ResponseEntity<Page<PcmDdsqdmxDTO>> searchPcmDdsqdmxDDJLByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PcmDdsqdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchDDJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-GBDDJL-all')")
	@ApiOperation(value = "fetch调动记录ByPimDistirbution", tags = {"PcmDdsqdmx" } ,notes = "fetch调动记录ByPimDistirbution")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/fetchgbddjl")
	public ResponseEntity<List<PcmDdsqdmxDTO>> fetchPcmDdsqdmxGBDDJLByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id,PcmDdsqdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchGBDDJL(context) ;
        List<PcmDdsqdmxDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-GBDDJL-all')")
	@ApiOperation(value = "search调动记录ByPimDistirbution", tags = {"PcmDdsqdmx" } ,notes = "search调动记录ByPimDistirbution")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/searchgbddjl")
	public ResponseEntity<Page<PcmDdsqdmxDTO>> searchPcmDdsqdmxGBDDJLByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PcmDdsqdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchGBDDJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-DDSQGR-all')")
	@ApiOperation(value = "fetch调动申请（个人）ByPimDistirbution", tags = {"PcmDdsqdmx" } ,notes = "fetch调动申请（个人）ByPimDistirbution")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/fetchddsqgr")
	public ResponseEntity<List<PcmDdsqdmxDTO>> fetchPcmDdsqdmxDDSQGRByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id,PcmDdsqdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchDDSQGR(context) ;
        List<PcmDdsqdmxDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-DDSQGR-all')")
	@ApiOperation(value = "search调动申请（个人）ByPimDistirbution", tags = {"PcmDdsqdmx" } ,notes = "search调动申请（个人）ByPimDistirbution")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/searchddsqgr")
	public ResponseEntity<Page<PcmDdsqdmxDTO>> searchPcmDdsqdmxDDSQGRByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PcmDdsqdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchDDSQGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-DDMX-all')")
	@ApiOperation(value = "fetch调动明细ByPimDistirbution", tags = {"PcmDdsqdmx" } ,notes = "fetch调动明细ByPimDistirbution")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/fetchddmx")
	public ResponseEntity<List<PcmDdsqdmxDTO>> fetchPcmDdsqdmxDDMXByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id,PcmDdsqdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchDDMX(context) ;
        List<PcmDdsqdmxDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-DDMX-all')")
	@ApiOperation(value = "search调动明细ByPimDistirbution", tags = {"PcmDdsqdmx" } ,notes = "search调动明细ByPimDistirbution")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/searchddmx")
	public ResponseEntity<Page<PcmDdsqdmxDTO>> searchPcmDdsqdmxDDMXByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PcmDdsqdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchDDMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JZSQGR-all')")
	@ApiOperation(value = "fetch兼职申请（个人）ByPimDistirbution", tags = {"PcmDdsqdmx" } ,notes = "fetch兼职申请（个人）ByPimDistirbution")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/fetchjzsqgr")
	public ResponseEntity<List<PcmDdsqdmxDTO>> fetchPcmDdsqdmxJZSQGRByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id,PcmDdsqdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchJZSQGR(context) ;
        List<PcmDdsqdmxDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JZSQGR-all')")
	@ApiOperation(value = "search兼职申请（个人）ByPimDistirbution", tags = {"PcmDdsqdmx" } ,notes = "search兼职申请（个人）ByPimDistirbution")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/searchjzsqgr")
	public ResponseEntity<Page<PcmDdsqdmxDTO>> searchPcmDdsqdmxJZSQGRByPimDistirbution(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PcmDdsqdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchJZSQGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pcmddsqdmxService.get(#pcmddsqdmx_id),'ehr-PcmDdsqdmx-Update')")
    @ApiOperation(value = "UpdateByPimPersonPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "UpdateByPimPersonPimDistirbution")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> updateByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain.setPcmddsqdmxid(pcmddsqdmx_id);
		pcmddsqdmxService.update(domain);
        PcmDdsqdmxDTO dto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxService.getPcmddsqdmxByEntities(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdtos)),'ehr-PcmDdsqdmx-Update')")
    @ApiOperation(value = "UpdateBatchByPimPersonPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "UpdateBatchByPimPersonPimDistirbution")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/batch")
    public ResponseEntity<Boolean> updateBatchByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody List<PcmDdsqdmxDTO> pcmddsqdmxdtos) {
        List<PcmDdsqdmx> domainlist=pcmddsqdmxMapping.toDomain(pcmddsqdmxdtos);
        for(PcmDdsqdmx domain:domainlist){
            domain.setPimdistirbutionid(pimdistirbution_id);
        }
        pcmddsqdmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-DDUpdate-all')")
    @ApiOperation(value = "调动更正ByPimPersonPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "调动更正ByPimPersonPimDistirbution")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}/ddupdate")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> dDUpdateByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain = pcmddsqdmxService.dDUpdate(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-SQBTG-all')")
    @ApiOperation(value = "申请不通过ByPimPersonPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "申请不通过ByPimPersonPimDistirbution")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}/sqbtg")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> sQBTGByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain = pcmddsqdmxService.sQBTG(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JDCZ-all')")
    @ApiOperation(value = "借调操作ByPimPersonPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "借调操作ByPimPersonPimDistirbution")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}/jdcz")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> jDCZByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain = pcmddsqdmxService.jDCZ(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @ApiOperation(value = "GetDraftByPimPersonPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "GetDraftByPimPersonPimDistirbution")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/getdraft")
    public ResponseEntity<PcmDdsqdmxDTO> getDraftByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id) {
        PcmDdsqdmx domain = new PcmDdsqdmx();
        domain.setPimdistirbutionid(pimdistirbution_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxMapping.toDto(pcmddsqdmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdto),'ehr-PcmDdsqdmx-Create')")
    @ApiOperation(value = "CreateByPimPersonPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "CreateByPimPersonPimDistirbution")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> createByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
		pcmddsqdmxService.create(domain);
        PcmDdsqdmxDTO dto = pcmddsqdmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdtos),'ehr-PcmDdsqdmx-Create')")
    @ApiOperation(value = "createBatchByPimPersonPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "createBatchByPimPersonPimDistirbution")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/batch")
    public ResponseEntity<Boolean> createBatchByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody List<PcmDdsqdmxDTO> pcmddsqdmxdtos) {
        List<PcmDdsqdmx> domainlist=pcmddsqdmxMapping.toDomain(pcmddsqdmxdtos);
        for(PcmDdsqdmx domain:domainlist){
            domain.setPimdistirbutionid(pimdistirbution_id);
        }
        pcmddsqdmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-DDCreate-all')")
    @ApiOperation(value = "调动更新ByPimPersonPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "调动更新ByPimPersonPimDistirbution")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}/ddcreate")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> dDCreateByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain = pcmddsqdmxService.dDCreate(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PostAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(returnObject.body),'ehr-PcmDdsqdmx-Get')")
    @ApiOperation(value = "GetByPimPersonPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "GetByPimPersonPimDistirbution")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}")
    public ResponseEntity<PcmDdsqdmxDTO> getByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id) {
        PcmDdsqdmx domain = pcmddsqdmxService.get(pcmddsqdmx_id);
        PcmDdsqdmxDTO dto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxService.get(#pcmddsqdmx_id),'ehr-PcmDdsqdmx-Remove')")
    @ApiOperation(value = "RemoveByPimPersonPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "RemoveByPimPersonPimDistirbution")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxService.remove(pcmddsqdmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxService.getPcmddsqdmxByIds(#ids),'ehr-PcmDdsqdmx-Remove')")
    @ApiOperation(value = "RemoveBatchByPimPersonPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "RemoveBatchByPimPersonPimDistirbution")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/batch")
    public ResponseEntity<Boolean> removeBatchByPimPersonPimDistirbution(@RequestBody List<String> ids) {
        pcmddsqdmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-ZZSQ-all')")
    @ApiOperation(value = "自助申请ByPimPersonPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "自助申请ByPimPersonPimDistirbution")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}/zzsq")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> zZSQByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain = pcmddsqdmxService.zZSQ(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @ApiOperation(value = "CheckKeyByPimPersonPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "CheckKeyByPimPersonPimDistirbution")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxService.checkKey(pcmddsqdmxMapping.toDomain(pcmddsqdmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-DDCZ-all')")
    @ApiOperation(value = "调动操作ByPimPersonPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "调动操作ByPimPersonPimDistirbution")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}/ddcz")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> dDCZByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain = pcmddsqdmxService.dDCZ(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-SQTG-all')")
    @ApiOperation(value = "申请通过ByPimPersonPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "申请通过ByPimPersonPimDistirbution")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}/sqtg")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> sQTGByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain = pcmddsqdmxService.sQTG(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdto),'ehr-PcmDdsqdmx-Save')")
    @ApiOperation(value = "SaveByPimPersonPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "SaveByPimPersonPimDistirbution")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/save")
    public ResponseEntity<Boolean> saveByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdtos),'ehr-PcmDdsqdmx-Save')")
    @ApiOperation(value = "SaveBatchByPimPersonPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "SaveBatchByPimPersonPimDistirbution")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody List<PcmDdsqdmxDTO> pcmddsqdmxdtos) {
        List<PcmDdsqdmx> domainlist=pcmddsqdmxMapping.toDomain(pcmddsqdmxdtos);
        for(PcmDdsqdmx domain:domainlist){
             domain.setPimdistirbutionid(pimdistirbution_id);
        }
        pcmddsqdmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JZCZ-all')")
    @ApiOperation(value = "兼职操作ByPimPersonPimDistirbution", tags = {"PcmDdsqdmx" },  notes = "兼职操作ByPimPersonPimDistirbution")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}/jzcz")
    @Transactional
    public ResponseEntity<PcmDdsqdmxDTO> jZCZByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PcmDdsqdmxDTO pcmddsqdmxdto) {
        PcmDdsqdmx domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain = pcmddsqdmxService.jZCZ(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JZSQMX-all')")
	@ApiOperation(value = "fetch兼职申请明细（未审核完成）ByPimPersonPimDistirbution", tags = {"PcmDdsqdmx" } ,notes = "fetch兼职申请明细（未审核完成）ByPimPersonPimDistirbution")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/fetchjzsqmx")
	public ResponseEntity<List<PcmDdsqdmxDTO>> fetchPcmDdsqdmxJZSQMXByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id,PcmDdsqdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchJZSQMX(context) ;
        List<PcmDdsqdmxDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JZSQMX-all')")
	@ApiOperation(value = "search兼职申请明细（未审核完成）ByPimPersonPimDistirbution", tags = {"PcmDdsqdmx" } ,notes = "search兼职申请明细（未审核完成）ByPimPersonPimDistirbution")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/searchjzsqmx")
	public ResponseEntity<Page<PcmDdsqdmxDTO>> searchPcmDdsqdmxJZSQMXByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PcmDdsqdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchJZSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JDSQGR-all')")
	@ApiOperation(value = "fetch借调申请（个人）ByPimPersonPimDistirbution", tags = {"PcmDdsqdmx" } ,notes = "fetch借调申请（个人）ByPimPersonPimDistirbution")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/fetchjdsqgr")
	public ResponseEntity<List<PcmDdsqdmxDTO>> fetchPcmDdsqdmxJDSQGRByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id,PcmDdsqdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchJDSQGR(context) ;
        List<PcmDdsqdmxDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JDSQGR-all')")
	@ApiOperation(value = "search借调申请（个人）ByPimPersonPimDistirbution", tags = {"PcmDdsqdmx" } ,notes = "search借调申请（个人）ByPimPersonPimDistirbution")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/searchjdsqgr")
	public ResponseEntity<Page<PcmDdsqdmxDTO>> searchPcmDdsqdmxJDSQGRByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PcmDdsqdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchJDSQGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPimPersonPimDistirbution", tags = {"PcmDdsqdmx" } ,notes = "fetchDEFAULTByPimPersonPimDistirbution")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/fetchdefault")
	public ResponseEntity<List<PcmDdsqdmxDTO>> fetchPcmDdsqdmxDefaultByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id,PcmDdsqdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchDefault(context) ;
        List<PcmDdsqdmxDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPimPersonPimDistirbution", tags = {"PcmDdsqdmx" } ,notes = "searchDEFAULTByPimPersonPimDistirbution")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/searchdefault")
	public ResponseEntity<Page<PcmDdsqdmxDTO>> searchPcmDdsqdmxDefaultByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PcmDdsqdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JDSQMX-all')")
	@ApiOperation(value = "fetch借调申请明细（未审核完成）ByPimPersonPimDistirbution", tags = {"PcmDdsqdmx" } ,notes = "fetch借调申请明细（未审核完成）ByPimPersonPimDistirbution")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/fetchjdsqmx")
	public ResponseEntity<List<PcmDdsqdmxDTO>> fetchPcmDdsqdmxJDSQMXByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id,PcmDdsqdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchJDSQMX(context) ;
        List<PcmDdsqdmxDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JDSQMX-all')")
	@ApiOperation(value = "search借调申请明细（未审核完成）ByPimPersonPimDistirbution", tags = {"PcmDdsqdmx" } ,notes = "search借调申请明细（未审核完成）ByPimPersonPimDistirbution")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/searchjdsqmx")
	public ResponseEntity<Page<PcmDdsqdmxDTO>> searchPcmDdsqdmxJDSQMXByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PcmDdsqdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchJDSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-DDJL-all')")
	@ApiOperation(value = "fetch调动记录ByPimPersonPimDistirbution", tags = {"PcmDdsqdmx" } ,notes = "fetch调动记录ByPimPersonPimDistirbution")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/fetchddjl")
	public ResponseEntity<List<PcmDdsqdmxDTO>> fetchPcmDdsqdmxDDJLByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id,PcmDdsqdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchDDJL(context) ;
        List<PcmDdsqdmxDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-DDJL-all')")
	@ApiOperation(value = "search调动记录ByPimPersonPimDistirbution", tags = {"PcmDdsqdmx" } ,notes = "search调动记录ByPimPersonPimDistirbution")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/searchddjl")
	public ResponseEntity<Page<PcmDdsqdmxDTO>> searchPcmDdsqdmxDDJLByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PcmDdsqdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchDDJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-GBDDJL-all')")
	@ApiOperation(value = "fetch调动记录ByPimPersonPimDistirbution", tags = {"PcmDdsqdmx" } ,notes = "fetch调动记录ByPimPersonPimDistirbution")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/fetchgbddjl")
	public ResponseEntity<List<PcmDdsqdmxDTO>> fetchPcmDdsqdmxGBDDJLByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id,PcmDdsqdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchGBDDJL(context) ;
        List<PcmDdsqdmxDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-GBDDJL-all')")
	@ApiOperation(value = "search调动记录ByPimPersonPimDistirbution", tags = {"PcmDdsqdmx" } ,notes = "search调动记录ByPimPersonPimDistirbution")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/searchgbddjl")
	public ResponseEntity<Page<PcmDdsqdmxDTO>> searchPcmDdsqdmxGBDDJLByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PcmDdsqdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchGBDDJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-DDSQGR-all')")
	@ApiOperation(value = "fetch调动申请（个人）ByPimPersonPimDistirbution", tags = {"PcmDdsqdmx" } ,notes = "fetch调动申请（个人）ByPimPersonPimDistirbution")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/fetchddsqgr")
	public ResponseEntity<List<PcmDdsqdmxDTO>> fetchPcmDdsqdmxDDSQGRByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id,PcmDdsqdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchDDSQGR(context) ;
        List<PcmDdsqdmxDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-DDSQGR-all')")
	@ApiOperation(value = "search调动申请（个人）ByPimPersonPimDistirbution", tags = {"PcmDdsqdmx" } ,notes = "search调动申请（个人）ByPimPersonPimDistirbution")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/searchddsqgr")
	public ResponseEntity<Page<PcmDdsqdmxDTO>> searchPcmDdsqdmxDDSQGRByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PcmDdsqdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchDDSQGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-DDMX-all')")
	@ApiOperation(value = "fetch调动明细ByPimPersonPimDistirbution", tags = {"PcmDdsqdmx" } ,notes = "fetch调动明细ByPimPersonPimDistirbution")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/fetchddmx")
	public ResponseEntity<List<PcmDdsqdmxDTO>> fetchPcmDdsqdmxDDMXByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id,PcmDdsqdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchDDMX(context) ;
        List<PcmDdsqdmxDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-DDMX-all')")
	@ApiOperation(value = "search调动明细ByPimPersonPimDistirbution", tags = {"PcmDdsqdmx" } ,notes = "search调动明细ByPimPersonPimDistirbution")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/searchddmx")
	public ResponseEntity<Page<PcmDdsqdmxDTO>> searchPcmDdsqdmxDDMXByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PcmDdsqdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchDDMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JZSQGR-all')")
	@ApiOperation(value = "fetch兼职申请（个人）ByPimPersonPimDistirbution", tags = {"PcmDdsqdmx" } ,notes = "fetch兼职申请（个人）ByPimPersonPimDistirbution")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/fetchjzsqgr")
	public ResponseEntity<List<PcmDdsqdmxDTO>> fetchPcmDdsqdmxJZSQGRByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id,PcmDdsqdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchJZSQGR(context) ;
        List<PcmDdsqdmxDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqdmx-JZSQGR-all')")
	@ApiOperation(value = "search兼职申请（个人）ByPimPersonPimDistirbution", tags = {"PcmDdsqdmx" } ,notes = "search兼职申请（个人）ByPimPersonPimDistirbution")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/searchjzsqgr")
	public ResponseEntity<Page<PcmDdsqdmxDTO>> searchPcmDdsqdmxJZSQGRByPimPersonPimDistirbution(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PcmDdsqdmxSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PcmDdsqdmx> domains = pcmddsqdmxService.searchJZSQGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

