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
import cn.ibizlab.ehr.core.pcm.domain.PCMDDSQDMX;
import cn.ibizlab.ehr.core.pcm.service.IPCMDDSQDMXService;
import cn.ibizlab.ehr.core.pcm.filter.PCMDDSQDMXSearchContext;

@Slf4j
@Api(tags = {"PCMDDSQDMX" })
@RestController("WebApi-pcmddsqdmx")
@RequestMapping("")
public class PCMDDSQDMXResource {

    @Autowired
    public IPCMDDSQDMXService pcmddsqdmxService;

    @Autowired
    @Lazy
    public PCMDDSQDMXMapping pcmddsqdmxMapping;

    @PreAuthorize("hasPermission(this.pcmddsqdmxService.get(#pcmddsqdmx_id),'ehr-PCMDDSQDMX-Update')")
    @ApiOperation(value = "Update", tags = {"PCMDDSQDMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmddsqdmxes/{pcmddsqdmx_id}")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> update(@PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
		PCMDDSQDMX domain  = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain .setPcmddsqdmxid(pcmddsqdmx_id);
		pcmddsqdmxService.update(domain );
		PCMDDSQDMXDTO dto = pcmddsqdmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxService.getPcmddsqdmxByEntities(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdtos)),'ehr-PCMDDSQDMX-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMDDSQDMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmddsqdmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMDDSQDMXDTO> pcmddsqdmxdtos) {
        pcmddsqdmxService.updateBatch(pcmddsqdmxMapping.toDomain(pcmddsqdmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDUpdate-all')")
    @ApiOperation(value = "调动更正", tags = {"PCMDDSQDMX" },  notes = "调动更正")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmddsqdmxes/{pcmddsqdmx_id}/ddupdate")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> dDUpdate(@PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX pcmddsqdmx = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        pcmddsqdmx.setPcmddsqdmxid(pcmddsqdmx_id);
        pcmddsqdmx = pcmddsqdmxService.dDUpdate(pcmddsqdmx);
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(pcmddsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-SQBTG-all')")
    @ApiOperation(value = "申请不通过", tags = {"PCMDDSQDMX" },  notes = "申请不通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqdmxes/{pcmddsqdmx_id}/sqbtg")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> sQBTG(@PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX pcmddsqdmx = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        pcmddsqdmx.setPcmddsqdmxid(pcmddsqdmx_id);
        pcmddsqdmx = pcmddsqdmxService.sQBTG(pcmddsqdmx);
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(pcmddsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JDCZ-all')")
    @ApiOperation(value = "借调操作", tags = {"PCMDDSQDMX" },  notes = "借调操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqdmxes/{pcmddsqdmx_id}/jdcz")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> jDCZ(@PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX pcmddsqdmx = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        pcmddsqdmx.setPcmddsqdmxid(pcmddsqdmx_id);
        pcmddsqdmx = pcmddsqdmxService.jDCZ(pcmddsqdmx);
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(pcmddsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @ApiOperation(value = "GetDraft", tags = {"PCMDDSQDMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmddsqdmxes/getdraft")
    public ResponseEntity<PCMDDSQDMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxMapping.toDto(pcmddsqdmxService.getDraft(new PCMDDSQDMX())));
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdto),'ehr-PCMDDSQDMX-Create')")
    @ApiOperation(value = "Create", tags = {"PCMDDSQDMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqdmxes")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> create(@RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
		pcmddsqdmxService.create(domain);
        PCMDDSQDMXDTO dto = pcmddsqdmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdtos),'ehr-PCMDDSQDMX-Create')")
    @ApiOperation(value = "createBatch", tags = {"PCMDDSQDMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqdmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMDDSQDMXDTO> pcmddsqdmxdtos) {
        pcmddsqdmxService.createBatch(pcmddsqdmxMapping.toDomain(pcmddsqdmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDCreate-all')")
    @ApiOperation(value = "调动更新", tags = {"PCMDDSQDMX" },  notes = "调动更新")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqdmxes/{pcmddsqdmx_id}/ddcreate")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> dDCreate(@PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX pcmddsqdmx = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        pcmddsqdmx.setPcmddsqdmxid(pcmddsqdmx_id);
        pcmddsqdmx = pcmddsqdmxService.dDCreate(pcmddsqdmx);
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(pcmddsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PostAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(returnObject.body),'ehr-PCMDDSQDMX-Get')")
    @ApiOperation(value = "Get", tags = {"PCMDDSQDMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmddsqdmxes/{pcmddsqdmx_id}")
    public ResponseEntity<PCMDDSQDMXDTO> get(@PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id) {
        PCMDDSQDMX domain = pcmddsqdmxService.get(pcmddsqdmx_id);
        PCMDDSQDMXDTO dto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxService.get(#pcmddsqdmx_id),'ehr-PCMDDSQDMX-Remove')")
    @ApiOperation(value = "Remove", tags = {"PCMDDSQDMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmddsqdmxes/{pcmddsqdmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxService.remove(pcmddsqdmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxService.getPcmddsqdmxByIds(#ids),'ehr-PCMDDSQDMX-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PCMDDSQDMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmddsqdmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmddsqdmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-ZZSQ-all')")
    @ApiOperation(value = "自助申请", tags = {"PCMDDSQDMX" },  notes = "自助申请")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqdmxes/{pcmddsqdmx_id}/zzsq")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> zZSQ(@PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX pcmddsqdmx = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        pcmddsqdmx.setPcmddsqdmxid(pcmddsqdmx_id);
        pcmddsqdmx = pcmddsqdmxService.zZSQ(pcmddsqdmx);
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(pcmddsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @ApiOperation(value = "CheckKey", tags = {"PCMDDSQDMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqdmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxService.checkKey(pcmddsqdmxMapping.toDomain(pcmddsqdmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDCZ-all')")
    @ApiOperation(value = "调动操作", tags = {"PCMDDSQDMX" },  notes = "调动操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqdmxes/{pcmddsqdmx_id}/ddcz")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> dDCZ(@PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX pcmddsqdmx = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        pcmddsqdmx.setPcmddsqdmxid(pcmddsqdmx_id);
        pcmddsqdmx = pcmddsqdmxService.dDCZ(pcmddsqdmx);
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(pcmddsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-SQTG-all')")
    @ApiOperation(value = "申请通过", tags = {"PCMDDSQDMX" },  notes = "申请通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqdmxes/{pcmddsqdmx_id}/sqtg")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> sQTG(@PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX pcmddsqdmx = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        pcmddsqdmx.setPcmddsqdmxid(pcmddsqdmx_id);
        pcmddsqdmx = pcmddsqdmxService.sQTG(pcmddsqdmx);
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(pcmddsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdto),'ehr-PCMDDSQDMX-Save')")
    @ApiOperation(value = "Save", tags = {"PCMDDSQDMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqdmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxService.save(pcmddsqdmxMapping.toDomain(pcmddsqdmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdtos),'ehr-PCMDDSQDMX-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PCMDDSQDMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqdmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMDDSQDMXDTO> pcmddsqdmxdtos) {
        pcmddsqdmxService.saveBatch(pcmddsqdmxMapping.toDomain(pcmddsqdmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JZCZ-all')")
    @ApiOperation(value = "兼职操作", tags = {"PCMDDSQDMX" },  notes = "兼职操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqdmxes/{pcmddsqdmx_id}/jzcz")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> jZCZ(@PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX pcmddsqdmx = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        pcmddsqdmx.setPcmddsqdmxid(pcmddsqdmx_id);
        pcmddsqdmx = pcmddsqdmxService.jZCZ(pcmddsqdmx);
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(pcmddsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JZSQMX-all')")
	@ApiOperation(value = "fetch兼职申请明细（未审核完成）", tags = {"PCMDDSQDMX" } ,notes = "fetch兼职申请明细（未审核完成）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqdmxes/fetchjzsqmx")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchJZSQMX(PCMDDSQDMXSearchContext context) {
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJZSQMX(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JZSQMX-all')")
	@ApiOperation(value = "search兼职申请明细（未审核完成）", tags = {"PCMDDSQDMX" } ,notes = "search兼职申请明细（未审核完成）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqdmxes/searchjzsqmx")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchJZSQMX(@RequestBody PCMDDSQDMXSearchContext context) {
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJZSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JDSQGR-all')")
	@ApiOperation(value = "fetch借调申请（个人）", tags = {"PCMDDSQDMX" } ,notes = "fetch借调申请（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqdmxes/fetchjdsqgr")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchJDSQGR(PCMDDSQDMXSearchContext context) {
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJDSQGR(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JDSQGR-all')")
	@ApiOperation(value = "search借调申请（个人）", tags = {"PCMDDSQDMX" } ,notes = "search借调申请（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqdmxes/searchjdsqgr")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchJDSQGR(@RequestBody PCMDDSQDMXSearchContext context) {
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJDSQGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMDDSQDMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqdmxes/fetchdefault")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchDefault(PCMDDSQDMXSearchContext context) {
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDefault(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMDDSQDMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqdmxes/searchdefault")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchDefault(@RequestBody PCMDDSQDMXSearchContext context) {
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JDSQMX-all')")
	@ApiOperation(value = "fetch借调申请明细（未审核完成）", tags = {"PCMDDSQDMX" } ,notes = "fetch借调申请明细（未审核完成）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqdmxes/fetchjdsqmx")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchJDSQMX(PCMDDSQDMXSearchContext context) {
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJDSQMX(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JDSQMX-all')")
	@ApiOperation(value = "search借调申请明细（未审核完成）", tags = {"PCMDDSQDMX" } ,notes = "search借调申请明细（未审核完成）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqdmxes/searchjdsqmx")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchJDSQMX(@RequestBody PCMDDSQDMXSearchContext context) {
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJDSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDJL-all')")
	@ApiOperation(value = "fetch调动记录", tags = {"PCMDDSQDMX" } ,notes = "fetch调动记录")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqdmxes/fetchddjl")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchDDJL(PCMDDSQDMXSearchContext context) {
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDDJL(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDJL-all')")
	@ApiOperation(value = "search调动记录", tags = {"PCMDDSQDMX" } ,notes = "search调动记录")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqdmxes/searchddjl")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchDDJL(@RequestBody PCMDDSQDMXSearchContext context) {
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDDJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-GBDDJL-all')")
	@ApiOperation(value = "fetch调动记录", tags = {"PCMDDSQDMX" } ,notes = "fetch调动记录")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqdmxes/fetchgbddjl")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchGBDDJL(PCMDDSQDMXSearchContext context) {
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchGBDDJL(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-GBDDJL-all')")
	@ApiOperation(value = "search调动记录", tags = {"PCMDDSQDMX" } ,notes = "search调动记录")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqdmxes/searchgbddjl")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchGBDDJL(@RequestBody PCMDDSQDMXSearchContext context) {
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchGBDDJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDSQGR-all')")
	@ApiOperation(value = "fetch调动申请（个人）", tags = {"PCMDDSQDMX" } ,notes = "fetch调动申请（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqdmxes/fetchddsqgr")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchDDSQGR(PCMDDSQDMXSearchContext context) {
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDDSQGR(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDSQGR-all')")
	@ApiOperation(value = "search调动申请（个人）", tags = {"PCMDDSQDMX" } ,notes = "search调动申请（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqdmxes/searchddsqgr")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchDDSQGR(@RequestBody PCMDDSQDMXSearchContext context) {
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDDSQGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDMX-all')")
	@ApiOperation(value = "fetch调动明细", tags = {"PCMDDSQDMX" } ,notes = "fetch调动明细")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqdmxes/fetchddmx")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchDDMX(PCMDDSQDMXSearchContext context) {
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDDMX(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDMX-all')")
	@ApiOperation(value = "search调动明细", tags = {"PCMDDSQDMX" } ,notes = "search调动明细")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqdmxes/searchddmx")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchDDMX(@RequestBody PCMDDSQDMXSearchContext context) {
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDDMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JZSQGR-all')")
	@ApiOperation(value = "fetch兼职申请（个人）", tags = {"PCMDDSQDMX" } ,notes = "fetch兼职申请（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqdmxes/fetchjzsqgr")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchJZSQGR(PCMDDSQDMXSearchContext context) {
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJZSQGR(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JZSQGR-all')")
	@ApiOperation(value = "search兼职申请（个人）", tags = {"PCMDDSQDMX" } ,notes = "search兼职申请（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqdmxes/searchjzsqgr")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchJZSQGR(@RequestBody PCMDDSQDMXSearchContext context) {
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJZSQGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pcmddsqdmxService.get(#pcmddsqdmx_id),'ehr-PCMDDSQDMX-Update')")
    @ApiOperation(value = "UpdateByPCMDDSQD", tags = {"PCMDDSQDMX" },  notes = "UpdateByPCMDDSQD")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/{pcmddsqdmx_id}")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> updateByPCMDDSQD(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPcmddsqdid(pcmddsqd_id);
        domain.setPcmddsqdmxid(pcmddsqdmx_id);
		pcmddsqdmxService.update(domain);
        PCMDDSQDMXDTO dto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxService.getPcmddsqdmxByEntities(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdtos)),'ehr-PCMDDSQDMX-Update')")
    @ApiOperation(value = "UpdateBatchByPCMDDSQD", tags = {"PCMDDSQDMX" },  notes = "UpdateBatchByPCMDDSQD")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/batch")
    public ResponseEntity<Boolean> updateBatchByPCMDDSQD(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @RequestBody List<PCMDDSQDMXDTO> pcmddsqdmxdtos) {
        List<PCMDDSQDMX> domainlist=pcmddsqdmxMapping.toDomain(pcmddsqdmxdtos);
        for(PCMDDSQDMX domain:domainlist){
            domain.setPcmddsqdid(pcmddsqd_id);
        }
        pcmddsqdmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDUpdate-all')")
    @ApiOperation(value = "调动更正ByPCMDDSQD", tags = {"PCMDDSQDMX" },  notes = "调动更正ByPCMDDSQD")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/{pcmddsqdmx_id}/ddupdate")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> dDUpdateByPCMDDSQD(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPcmddsqdid(pcmddsqd_id);
        domain = pcmddsqdmxService.dDUpdate(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-SQBTG-all')")
    @ApiOperation(value = "申请不通过ByPCMDDSQD", tags = {"PCMDDSQDMX" },  notes = "申请不通过ByPCMDDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/{pcmddsqdmx_id}/sqbtg")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> sQBTGByPCMDDSQD(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPcmddsqdid(pcmddsqd_id);
        domain = pcmddsqdmxService.sQBTG(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JDCZ-all')")
    @ApiOperation(value = "借调操作ByPCMDDSQD", tags = {"PCMDDSQDMX" },  notes = "借调操作ByPCMDDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/{pcmddsqdmx_id}/jdcz")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> jDCZByPCMDDSQD(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPcmddsqdid(pcmddsqd_id);
        domain = pcmddsqdmxService.jDCZ(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @ApiOperation(value = "GetDraftByPCMDDSQD", tags = {"PCMDDSQDMX" },  notes = "GetDraftByPCMDDSQD")
    @RequestMapping(method = RequestMethod.GET, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/getdraft")
    public ResponseEntity<PCMDDSQDMXDTO> getDraftByPCMDDSQD(@PathVariable("pcmddsqd_id") String pcmddsqd_id) {
        PCMDDSQDMX domain = new PCMDDSQDMX();
        domain.setPcmddsqdid(pcmddsqd_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxMapping.toDto(pcmddsqdmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdto),'ehr-PCMDDSQDMX-Create')")
    @ApiOperation(value = "CreateByPCMDDSQD", tags = {"PCMDDSQDMX" },  notes = "CreateByPCMDDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> createByPCMDDSQD(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPcmddsqdid(pcmddsqd_id);
		pcmddsqdmxService.create(domain);
        PCMDDSQDMXDTO dto = pcmddsqdmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdtos),'ehr-PCMDDSQDMX-Create')")
    @ApiOperation(value = "createBatchByPCMDDSQD", tags = {"PCMDDSQDMX" },  notes = "createBatchByPCMDDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/batch")
    public ResponseEntity<Boolean> createBatchByPCMDDSQD(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @RequestBody List<PCMDDSQDMXDTO> pcmddsqdmxdtos) {
        List<PCMDDSQDMX> domainlist=pcmddsqdmxMapping.toDomain(pcmddsqdmxdtos);
        for(PCMDDSQDMX domain:domainlist){
            domain.setPcmddsqdid(pcmddsqd_id);
        }
        pcmddsqdmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDCreate-all')")
    @ApiOperation(value = "调动更新ByPCMDDSQD", tags = {"PCMDDSQDMX" },  notes = "调动更新ByPCMDDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/{pcmddsqdmx_id}/ddcreate")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> dDCreateByPCMDDSQD(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPcmddsqdid(pcmddsqd_id);
        domain = pcmddsqdmxService.dDCreate(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PostAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(returnObject.body),'ehr-PCMDDSQDMX-Get')")
    @ApiOperation(value = "GetByPCMDDSQD", tags = {"PCMDDSQDMX" },  notes = "GetByPCMDDSQD")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/{pcmddsqdmx_id}")
    public ResponseEntity<PCMDDSQDMXDTO> getByPCMDDSQD(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id) {
        PCMDDSQDMX domain = pcmddsqdmxService.get(pcmddsqdmx_id);
        PCMDDSQDMXDTO dto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxService.get(#pcmddsqdmx_id),'ehr-PCMDDSQDMX-Remove')")
    @ApiOperation(value = "RemoveByPCMDDSQD", tags = {"PCMDDSQDMX" },  notes = "RemoveByPCMDDSQD")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/{pcmddsqdmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPCMDDSQD(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxService.remove(pcmddsqdmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxService.getPcmddsqdmxByIds(#ids),'ehr-PCMDDSQDMX-Remove')")
    @ApiOperation(value = "RemoveBatchByPCMDDSQD", tags = {"PCMDDSQDMX" },  notes = "RemoveBatchByPCMDDSQD")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/batch")
    public ResponseEntity<Boolean> removeBatchByPCMDDSQD(@RequestBody List<String> ids) {
        pcmddsqdmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-ZZSQ-all')")
    @ApiOperation(value = "自助申请ByPCMDDSQD", tags = {"PCMDDSQDMX" },  notes = "自助申请ByPCMDDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/{pcmddsqdmx_id}/zzsq")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> zZSQByPCMDDSQD(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPcmddsqdid(pcmddsqd_id);
        domain = pcmddsqdmxService.zZSQ(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @ApiOperation(value = "CheckKeyByPCMDDSQD", tags = {"PCMDDSQDMX" },  notes = "CheckKeyByPCMDDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPCMDDSQD(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxService.checkKey(pcmddsqdmxMapping.toDomain(pcmddsqdmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDCZ-all')")
    @ApiOperation(value = "调动操作ByPCMDDSQD", tags = {"PCMDDSQDMX" },  notes = "调动操作ByPCMDDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/{pcmddsqdmx_id}/ddcz")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> dDCZByPCMDDSQD(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPcmddsqdid(pcmddsqd_id);
        domain = pcmddsqdmxService.dDCZ(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-SQTG-all')")
    @ApiOperation(value = "申请通过ByPCMDDSQD", tags = {"PCMDDSQDMX" },  notes = "申请通过ByPCMDDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/{pcmddsqdmx_id}/sqtg")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> sQTGByPCMDDSQD(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPcmddsqdid(pcmddsqd_id);
        domain = pcmddsqdmxService.sQTG(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdto),'ehr-PCMDDSQDMX-Save')")
    @ApiOperation(value = "SaveByPCMDDSQD", tags = {"PCMDDSQDMX" },  notes = "SaveByPCMDDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/save")
    public ResponseEntity<Boolean> saveByPCMDDSQD(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPcmddsqdid(pcmddsqd_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdtos),'ehr-PCMDDSQDMX-Save')")
    @ApiOperation(value = "SaveBatchByPCMDDSQD", tags = {"PCMDDSQDMX" },  notes = "SaveBatchByPCMDDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPCMDDSQD(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @RequestBody List<PCMDDSQDMXDTO> pcmddsqdmxdtos) {
        List<PCMDDSQDMX> domainlist=pcmddsqdmxMapping.toDomain(pcmddsqdmxdtos);
        for(PCMDDSQDMX domain:domainlist){
             domain.setPcmddsqdid(pcmddsqd_id);
        }
        pcmddsqdmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JZCZ-all')")
    @ApiOperation(value = "兼职操作ByPCMDDSQD", tags = {"PCMDDSQDMX" },  notes = "兼职操作ByPCMDDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/{pcmddsqdmx_id}/jzcz")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> jZCZByPCMDDSQD(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPcmddsqdid(pcmddsqd_id);
        domain = pcmddsqdmxService.jZCZ(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JZSQMX-all')")
	@ApiOperation(value = "fetch兼职申请明细（未审核完成）ByPCMDDSQD", tags = {"PCMDDSQDMX" } ,notes = "fetch兼职申请明细（未审核完成）ByPCMDDSQD")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/fetchjzsqmx")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchPCMDDSQDMXJZSQMXByPCMDDSQD(@PathVariable("pcmddsqd_id") String pcmddsqd_id,PCMDDSQDMXSearchContext context) {
        context.setN_pcmddsqdid_eq(pcmddsqd_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJZSQMX(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JZSQMX-all')")
	@ApiOperation(value = "search兼职申请明细（未审核完成）ByPCMDDSQD", tags = {"PCMDDSQDMX" } ,notes = "search兼职申请明细（未审核完成）ByPCMDDSQD")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/searchjzsqmx")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchPCMDDSQDMXJZSQMXByPCMDDSQD(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @RequestBody PCMDDSQDMXSearchContext context) {
        context.setN_pcmddsqdid_eq(pcmddsqd_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJZSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JDSQGR-all')")
	@ApiOperation(value = "fetch借调申请（个人）ByPCMDDSQD", tags = {"PCMDDSQDMX" } ,notes = "fetch借调申请（个人）ByPCMDDSQD")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/fetchjdsqgr")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchPCMDDSQDMXJDSQGRByPCMDDSQD(@PathVariable("pcmddsqd_id") String pcmddsqd_id,PCMDDSQDMXSearchContext context) {
        context.setN_pcmddsqdid_eq(pcmddsqd_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJDSQGR(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JDSQGR-all')")
	@ApiOperation(value = "search借调申请（个人）ByPCMDDSQD", tags = {"PCMDDSQDMX" } ,notes = "search借调申请（个人）ByPCMDDSQD")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/searchjdsqgr")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchPCMDDSQDMXJDSQGRByPCMDDSQD(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @RequestBody PCMDDSQDMXSearchContext context) {
        context.setN_pcmddsqdid_eq(pcmddsqd_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJDSQGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPCMDDSQD", tags = {"PCMDDSQDMX" } ,notes = "fetchDEFAULTByPCMDDSQD")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/fetchdefault")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchPCMDDSQDMXDefaultByPCMDDSQD(@PathVariable("pcmddsqd_id") String pcmddsqd_id,PCMDDSQDMXSearchContext context) {
        context.setN_pcmddsqdid_eq(pcmddsqd_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDefault(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPCMDDSQD", tags = {"PCMDDSQDMX" } ,notes = "searchDEFAULTByPCMDDSQD")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/searchdefault")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchPCMDDSQDMXDefaultByPCMDDSQD(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @RequestBody PCMDDSQDMXSearchContext context) {
        context.setN_pcmddsqdid_eq(pcmddsqd_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JDSQMX-all')")
	@ApiOperation(value = "fetch借调申请明细（未审核完成）ByPCMDDSQD", tags = {"PCMDDSQDMX" } ,notes = "fetch借调申请明细（未审核完成）ByPCMDDSQD")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/fetchjdsqmx")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchPCMDDSQDMXJDSQMXByPCMDDSQD(@PathVariable("pcmddsqd_id") String pcmddsqd_id,PCMDDSQDMXSearchContext context) {
        context.setN_pcmddsqdid_eq(pcmddsqd_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJDSQMX(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JDSQMX-all')")
	@ApiOperation(value = "search借调申请明细（未审核完成）ByPCMDDSQD", tags = {"PCMDDSQDMX" } ,notes = "search借调申请明细（未审核完成）ByPCMDDSQD")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/searchjdsqmx")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchPCMDDSQDMXJDSQMXByPCMDDSQD(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @RequestBody PCMDDSQDMXSearchContext context) {
        context.setN_pcmddsqdid_eq(pcmddsqd_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJDSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDJL-all')")
	@ApiOperation(value = "fetch调动记录ByPCMDDSQD", tags = {"PCMDDSQDMX" } ,notes = "fetch调动记录ByPCMDDSQD")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/fetchddjl")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchPCMDDSQDMXDDJLByPCMDDSQD(@PathVariable("pcmddsqd_id") String pcmddsqd_id,PCMDDSQDMXSearchContext context) {
        context.setN_pcmddsqdid_eq(pcmddsqd_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDDJL(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDJL-all')")
	@ApiOperation(value = "search调动记录ByPCMDDSQD", tags = {"PCMDDSQDMX" } ,notes = "search调动记录ByPCMDDSQD")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/searchddjl")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchPCMDDSQDMXDDJLByPCMDDSQD(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @RequestBody PCMDDSQDMXSearchContext context) {
        context.setN_pcmddsqdid_eq(pcmddsqd_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDDJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-GBDDJL-all')")
	@ApiOperation(value = "fetch调动记录ByPCMDDSQD", tags = {"PCMDDSQDMX" } ,notes = "fetch调动记录ByPCMDDSQD")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/fetchgbddjl")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchPCMDDSQDMXGBDDJLByPCMDDSQD(@PathVariable("pcmddsqd_id") String pcmddsqd_id,PCMDDSQDMXSearchContext context) {
        context.setN_pcmddsqdid_eq(pcmddsqd_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchGBDDJL(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-GBDDJL-all')")
	@ApiOperation(value = "search调动记录ByPCMDDSQD", tags = {"PCMDDSQDMX" } ,notes = "search调动记录ByPCMDDSQD")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/searchgbddjl")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchPCMDDSQDMXGBDDJLByPCMDDSQD(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @RequestBody PCMDDSQDMXSearchContext context) {
        context.setN_pcmddsqdid_eq(pcmddsqd_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchGBDDJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDSQGR-all')")
	@ApiOperation(value = "fetch调动申请（个人）ByPCMDDSQD", tags = {"PCMDDSQDMX" } ,notes = "fetch调动申请（个人）ByPCMDDSQD")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/fetchddsqgr")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchPCMDDSQDMXDDSQGRByPCMDDSQD(@PathVariable("pcmddsqd_id") String pcmddsqd_id,PCMDDSQDMXSearchContext context) {
        context.setN_pcmddsqdid_eq(pcmddsqd_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDDSQGR(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDSQGR-all')")
	@ApiOperation(value = "search调动申请（个人）ByPCMDDSQD", tags = {"PCMDDSQDMX" } ,notes = "search调动申请（个人）ByPCMDDSQD")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/searchddsqgr")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchPCMDDSQDMXDDSQGRByPCMDDSQD(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @RequestBody PCMDDSQDMXSearchContext context) {
        context.setN_pcmddsqdid_eq(pcmddsqd_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDDSQGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDMX-all')")
	@ApiOperation(value = "fetch调动明细ByPCMDDSQD", tags = {"PCMDDSQDMX" } ,notes = "fetch调动明细ByPCMDDSQD")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/fetchddmx")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchPCMDDSQDMXDDMXByPCMDDSQD(@PathVariable("pcmddsqd_id") String pcmddsqd_id,PCMDDSQDMXSearchContext context) {
        context.setN_pcmddsqdid_eq(pcmddsqd_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDDMX(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDMX-all')")
	@ApiOperation(value = "search调动明细ByPCMDDSQD", tags = {"PCMDDSQDMX" } ,notes = "search调动明细ByPCMDDSQD")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/searchddmx")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchPCMDDSQDMXDDMXByPCMDDSQD(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @RequestBody PCMDDSQDMXSearchContext context) {
        context.setN_pcmddsqdid_eq(pcmddsqd_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDDMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JZSQGR-all')")
	@ApiOperation(value = "fetch兼职申请（个人）ByPCMDDSQD", tags = {"PCMDDSQDMX" } ,notes = "fetch兼职申请（个人）ByPCMDDSQD")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/fetchjzsqgr")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchPCMDDSQDMXJZSQGRByPCMDDSQD(@PathVariable("pcmddsqd_id") String pcmddsqd_id,PCMDDSQDMXSearchContext context) {
        context.setN_pcmddsqdid_eq(pcmddsqd_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJZSQGR(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JZSQGR-all')")
	@ApiOperation(value = "search兼职申请（个人）ByPCMDDSQD", tags = {"PCMDDSQDMX" } ,notes = "search兼职申请（个人）ByPCMDDSQD")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqds/{pcmddsqd_id}/pcmddsqdmxes/searchjzsqgr")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchPCMDDSQDMXJZSQGRByPCMDDSQD(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @RequestBody PCMDDSQDMXSearchContext context) {
        context.setN_pcmddsqdid_eq(pcmddsqd_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJZSQGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pcmddsqdmxService.get(#pcmddsqdmx_id),'ehr-PCMDDSQDMX-Update')")
    @ApiOperation(value = "UpdateByPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "UpdateByPIMDISTIRBUTION")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> updateByPIMDISTIRBUTION(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain.setPcmddsqdmxid(pcmddsqdmx_id);
		pcmddsqdmxService.update(domain);
        PCMDDSQDMXDTO dto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxService.getPcmddsqdmxByEntities(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdtos)),'ehr-PCMDDSQDMX-Update')")
    @ApiOperation(value = "UpdateBatchByPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "UpdateBatchByPIMDISTIRBUTION")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/batch")
    public ResponseEntity<Boolean> updateBatchByPIMDISTIRBUTION(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody List<PCMDDSQDMXDTO> pcmddsqdmxdtos) {
        List<PCMDDSQDMX> domainlist=pcmddsqdmxMapping.toDomain(pcmddsqdmxdtos);
        for(PCMDDSQDMX domain:domainlist){
            domain.setPimdistirbutionid(pimdistirbution_id);
        }
        pcmddsqdmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDUpdate-all')")
    @ApiOperation(value = "调动更正ByPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "调动更正ByPIMDISTIRBUTION")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}/ddupdate")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> dDUpdateByPIMDISTIRBUTION(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain = pcmddsqdmxService.dDUpdate(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-SQBTG-all')")
    @ApiOperation(value = "申请不通过ByPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "申请不通过ByPIMDISTIRBUTION")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}/sqbtg")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> sQBTGByPIMDISTIRBUTION(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain = pcmddsqdmxService.sQBTG(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JDCZ-all')")
    @ApiOperation(value = "借调操作ByPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "借调操作ByPIMDISTIRBUTION")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}/jdcz")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> jDCZByPIMDISTIRBUTION(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain = pcmddsqdmxService.jDCZ(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @ApiOperation(value = "GetDraftByPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "GetDraftByPIMDISTIRBUTION")
    @RequestMapping(method = RequestMethod.GET, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/getdraft")
    public ResponseEntity<PCMDDSQDMXDTO> getDraftByPIMDISTIRBUTION(@PathVariable("pimdistirbution_id") String pimdistirbution_id) {
        PCMDDSQDMX domain = new PCMDDSQDMX();
        domain.setPimdistirbutionid(pimdistirbution_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxMapping.toDto(pcmddsqdmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdto),'ehr-PCMDDSQDMX-Create')")
    @ApiOperation(value = "CreateByPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "CreateByPIMDISTIRBUTION")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> createByPIMDISTIRBUTION(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
		pcmddsqdmxService.create(domain);
        PCMDDSQDMXDTO dto = pcmddsqdmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdtos),'ehr-PCMDDSQDMX-Create')")
    @ApiOperation(value = "createBatchByPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "createBatchByPIMDISTIRBUTION")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/batch")
    public ResponseEntity<Boolean> createBatchByPIMDISTIRBUTION(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody List<PCMDDSQDMXDTO> pcmddsqdmxdtos) {
        List<PCMDDSQDMX> domainlist=pcmddsqdmxMapping.toDomain(pcmddsqdmxdtos);
        for(PCMDDSQDMX domain:domainlist){
            domain.setPimdistirbutionid(pimdistirbution_id);
        }
        pcmddsqdmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDCreate-all')")
    @ApiOperation(value = "调动更新ByPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "调动更新ByPIMDISTIRBUTION")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}/ddcreate")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> dDCreateByPIMDISTIRBUTION(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain = pcmddsqdmxService.dDCreate(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PostAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(returnObject.body),'ehr-PCMDDSQDMX-Get')")
    @ApiOperation(value = "GetByPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "GetByPIMDISTIRBUTION")
	@RequestMapping(method = RequestMethod.GET, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}")
    public ResponseEntity<PCMDDSQDMXDTO> getByPIMDISTIRBUTION(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id) {
        PCMDDSQDMX domain = pcmddsqdmxService.get(pcmddsqdmx_id);
        PCMDDSQDMXDTO dto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxService.get(#pcmddsqdmx_id),'ehr-PCMDDSQDMX-Remove')")
    @ApiOperation(value = "RemoveByPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "RemoveByPIMDISTIRBUTION")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMDISTIRBUTION(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxService.remove(pcmddsqdmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxService.getPcmddsqdmxByIds(#ids),'ehr-PCMDDSQDMX-Remove')")
    @ApiOperation(value = "RemoveBatchByPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "RemoveBatchByPIMDISTIRBUTION")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/batch")
    public ResponseEntity<Boolean> removeBatchByPIMDISTIRBUTION(@RequestBody List<String> ids) {
        pcmddsqdmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-ZZSQ-all')")
    @ApiOperation(value = "自助申请ByPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "自助申请ByPIMDISTIRBUTION")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}/zzsq")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> zZSQByPIMDISTIRBUTION(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain = pcmddsqdmxService.zZSQ(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @ApiOperation(value = "CheckKeyByPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "CheckKeyByPIMDISTIRBUTION")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMDISTIRBUTION(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxService.checkKey(pcmddsqdmxMapping.toDomain(pcmddsqdmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDCZ-all')")
    @ApiOperation(value = "调动操作ByPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "调动操作ByPIMDISTIRBUTION")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}/ddcz")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> dDCZByPIMDISTIRBUTION(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain = pcmddsqdmxService.dDCZ(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-SQTG-all')")
    @ApiOperation(value = "申请通过ByPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "申请通过ByPIMDISTIRBUTION")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}/sqtg")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> sQTGByPIMDISTIRBUTION(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain = pcmddsqdmxService.sQTG(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdto),'ehr-PCMDDSQDMX-Save')")
    @ApiOperation(value = "SaveByPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "SaveByPIMDISTIRBUTION")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/save")
    public ResponseEntity<Boolean> saveByPIMDISTIRBUTION(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdtos),'ehr-PCMDDSQDMX-Save')")
    @ApiOperation(value = "SaveBatchByPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "SaveBatchByPIMDISTIRBUTION")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMDISTIRBUTION(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody List<PCMDDSQDMXDTO> pcmddsqdmxdtos) {
        List<PCMDDSQDMX> domainlist=pcmddsqdmxMapping.toDomain(pcmddsqdmxdtos);
        for(PCMDDSQDMX domain:domainlist){
             domain.setPimdistirbutionid(pimdistirbution_id);
        }
        pcmddsqdmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JZCZ-all')")
    @ApiOperation(value = "兼职操作ByPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "兼职操作ByPIMDISTIRBUTION")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}/jzcz")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> jZCZByPIMDISTIRBUTION(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain = pcmddsqdmxService.jZCZ(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JZSQMX-all')")
	@ApiOperation(value = "fetch兼职申请明细（未审核完成）ByPIMDISTIRBUTION", tags = {"PCMDDSQDMX" } ,notes = "fetch兼职申请明细（未审核完成）ByPIMDISTIRBUTION")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/fetchjzsqmx")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchPCMDDSQDMXJZSQMXByPIMDISTIRBUTION(@PathVariable("pimdistirbution_id") String pimdistirbution_id,PCMDDSQDMXSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJZSQMX(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JZSQMX-all')")
	@ApiOperation(value = "search兼职申请明细（未审核完成）ByPIMDISTIRBUTION", tags = {"PCMDDSQDMX" } ,notes = "search兼职申请明细（未审核完成）ByPIMDISTIRBUTION")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/searchjzsqmx")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchPCMDDSQDMXJZSQMXByPIMDISTIRBUTION(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PCMDDSQDMXSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJZSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JDSQGR-all')")
	@ApiOperation(value = "fetch借调申请（个人）ByPIMDISTIRBUTION", tags = {"PCMDDSQDMX" } ,notes = "fetch借调申请（个人）ByPIMDISTIRBUTION")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/fetchjdsqgr")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchPCMDDSQDMXJDSQGRByPIMDISTIRBUTION(@PathVariable("pimdistirbution_id") String pimdistirbution_id,PCMDDSQDMXSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJDSQGR(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JDSQGR-all')")
	@ApiOperation(value = "search借调申请（个人）ByPIMDISTIRBUTION", tags = {"PCMDDSQDMX" } ,notes = "search借调申请（个人）ByPIMDISTIRBUTION")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/searchjdsqgr")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchPCMDDSQDMXJDSQGRByPIMDISTIRBUTION(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PCMDDSQDMXSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJDSQGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPIMDISTIRBUTION", tags = {"PCMDDSQDMX" } ,notes = "fetchDEFAULTByPIMDISTIRBUTION")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/fetchdefault")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchPCMDDSQDMXDefaultByPIMDISTIRBUTION(@PathVariable("pimdistirbution_id") String pimdistirbution_id,PCMDDSQDMXSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDefault(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPIMDISTIRBUTION", tags = {"PCMDDSQDMX" } ,notes = "searchDEFAULTByPIMDISTIRBUTION")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/searchdefault")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchPCMDDSQDMXDefaultByPIMDISTIRBUTION(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PCMDDSQDMXSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JDSQMX-all')")
	@ApiOperation(value = "fetch借调申请明细（未审核完成）ByPIMDISTIRBUTION", tags = {"PCMDDSQDMX" } ,notes = "fetch借调申请明细（未审核完成）ByPIMDISTIRBUTION")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/fetchjdsqmx")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchPCMDDSQDMXJDSQMXByPIMDISTIRBUTION(@PathVariable("pimdistirbution_id") String pimdistirbution_id,PCMDDSQDMXSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJDSQMX(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JDSQMX-all')")
	@ApiOperation(value = "search借调申请明细（未审核完成）ByPIMDISTIRBUTION", tags = {"PCMDDSQDMX" } ,notes = "search借调申请明细（未审核完成）ByPIMDISTIRBUTION")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/searchjdsqmx")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchPCMDDSQDMXJDSQMXByPIMDISTIRBUTION(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PCMDDSQDMXSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJDSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDJL-all')")
	@ApiOperation(value = "fetch调动记录ByPIMDISTIRBUTION", tags = {"PCMDDSQDMX" } ,notes = "fetch调动记录ByPIMDISTIRBUTION")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/fetchddjl")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchPCMDDSQDMXDDJLByPIMDISTIRBUTION(@PathVariable("pimdistirbution_id") String pimdistirbution_id,PCMDDSQDMXSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDDJL(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDJL-all')")
	@ApiOperation(value = "search调动记录ByPIMDISTIRBUTION", tags = {"PCMDDSQDMX" } ,notes = "search调动记录ByPIMDISTIRBUTION")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/searchddjl")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchPCMDDSQDMXDDJLByPIMDISTIRBUTION(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PCMDDSQDMXSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDDJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-GBDDJL-all')")
	@ApiOperation(value = "fetch调动记录ByPIMDISTIRBUTION", tags = {"PCMDDSQDMX" } ,notes = "fetch调动记录ByPIMDISTIRBUTION")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/fetchgbddjl")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchPCMDDSQDMXGBDDJLByPIMDISTIRBUTION(@PathVariable("pimdistirbution_id") String pimdistirbution_id,PCMDDSQDMXSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchGBDDJL(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-GBDDJL-all')")
	@ApiOperation(value = "search调动记录ByPIMDISTIRBUTION", tags = {"PCMDDSQDMX" } ,notes = "search调动记录ByPIMDISTIRBUTION")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/searchgbddjl")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchPCMDDSQDMXGBDDJLByPIMDISTIRBUTION(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PCMDDSQDMXSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchGBDDJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDSQGR-all')")
	@ApiOperation(value = "fetch调动申请（个人）ByPIMDISTIRBUTION", tags = {"PCMDDSQDMX" } ,notes = "fetch调动申请（个人）ByPIMDISTIRBUTION")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/fetchddsqgr")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchPCMDDSQDMXDDSQGRByPIMDISTIRBUTION(@PathVariable("pimdistirbution_id") String pimdistirbution_id,PCMDDSQDMXSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDDSQGR(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDSQGR-all')")
	@ApiOperation(value = "search调动申请（个人）ByPIMDISTIRBUTION", tags = {"PCMDDSQDMX" } ,notes = "search调动申请（个人）ByPIMDISTIRBUTION")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/searchddsqgr")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchPCMDDSQDMXDDSQGRByPIMDISTIRBUTION(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PCMDDSQDMXSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDDSQGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDMX-all')")
	@ApiOperation(value = "fetch调动明细ByPIMDISTIRBUTION", tags = {"PCMDDSQDMX" } ,notes = "fetch调动明细ByPIMDISTIRBUTION")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/fetchddmx")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchPCMDDSQDMXDDMXByPIMDISTIRBUTION(@PathVariable("pimdistirbution_id") String pimdistirbution_id,PCMDDSQDMXSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDDMX(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDMX-all')")
	@ApiOperation(value = "search调动明细ByPIMDISTIRBUTION", tags = {"PCMDDSQDMX" } ,notes = "search调动明细ByPIMDISTIRBUTION")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/searchddmx")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchPCMDDSQDMXDDMXByPIMDISTIRBUTION(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PCMDDSQDMXSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDDMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JZSQGR-all')")
	@ApiOperation(value = "fetch兼职申请（个人）ByPIMDISTIRBUTION", tags = {"PCMDDSQDMX" } ,notes = "fetch兼职申请（个人）ByPIMDISTIRBUTION")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/fetchjzsqgr")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchPCMDDSQDMXJZSQGRByPIMDISTIRBUTION(@PathVariable("pimdistirbution_id") String pimdistirbution_id,PCMDDSQDMXSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJZSQGR(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JZSQGR-all')")
	@ApiOperation(value = "search兼职申请（个人）ByPIMDISTIRBUTION", tags = {"PCMDDSQDMX" } ,notes = "search兼职申请（个人）ByPIMDISTIRBUTION")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/searchjzsqgr")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchPCMDDSQDMXJZSQGRByPIMDISTIRBUTION(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PCMDDSQDMXSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJZSQGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pcmddsqdmxService.get(#pcmddsqdmx_id),'ehr-PCMDDSQDMX-Update')")
    @ApiOperation(value = "UpdateByPIMPERSONPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "UpdateByPIMPERSONPIMDISTIRBUTION")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> updateByPIMPERSONPIMDISTIRBUTION(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain.setPcmddsqdmxid(pcmddsqdmx_id);
		pcmddsqdmxService.update(domain);
        PCMDDSQDMXDTO dto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxService.getPcmddsqdmxByEntities(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdtos)),'ehr-PCMDDSQDMX-Update')")
    @ApiOperation(value = "UpdateBatchByPIMPERSONPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "UpdateBatchByPIMPERSONPIMDISTIRBUTION")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/batch")
    public ResponseEntity<Boolean> updateBatchByPIMPERSONPIMDISTIRBUTION(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody List<PCMDDSQDMXDTO> pcmddsqdmxdtos) {
        List<PCMDDSQDMX> domainlist=pcmddsqdmxMapping.toDomain(pcmddsqdmxdtos);
        for(PCMDDSQDMX domain:domainlist){
            domain.setPimdistirbutionid(pimdistirbution_id);
        }
        pcmddsqdmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDUpdate-all')")
    @ApiOperation(value = "调动更正ByPIMPERSONPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "调动更正ByPIMPERSONPIMDISTIRBUTION")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}/ddupdate")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> dDUpdateByPIMPERSONPIMDISTIRBUTION(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain = pcmddsqdmxService.dDUpdate(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-SQBTG-all')")
    @ApiOperation(value = "申请不通过ByPIMPERSONPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "申请不通过ByPIMPERSONPIMDISTIRBUTION")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}/sqbtg")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> sQBTGByPIMPERSONPIMDISTIRBUTION(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain = pcmddsqdmxService.sQBTG(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JDCZ-all')")
    @ApiOperation(value = "借调操作ByPIMPERSONPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "借调操作ByPIMPERSONPIMDISTIRBUTION")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}/jdcz")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> jDCZByPIMPERSONPIMDISTIRBUTION(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain = pcmddsqdmxService.jDCZ(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @ApiOperation(value = "GetDraftByPIMPERSONPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "GetDraftByPIMPERSONPIMDISTIRBUTION")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/getdraft")
    public ResponseEntity<PCMDDSQDMXDTO> getDraftByPIMPERSONPIMDISTIRBUTION(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id) {
        PCMDDSQDMX domain = new PCMDDSQDMX();
        domain.setPimdistirbutionid(pimdistirbution_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxMapping.toDto(pcmddsqdmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdto),'ehr-PCMDDSQDMX-Create')")
    @ApiOperation(value = "CreateByPIMPERSONPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "CreateByPIMPERSONPIMDISTIRBUTION")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> createByPIMPERSONPIMDISTIRBUTION(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
		pcmddsqdmxService.create(domain);
        PCMDDSQDMXDTO dto = pcmddsqdmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdtos),'ehr-PCMDDSQDMX-Create')")
    @ApiOperation(value = "createBatchByPIMPERSONPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "createBatchByPIMPERSONPIMDISTIRBUTION")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/batch")
    public ResponseEntity<Boolean> createBatchByPIMPERSONPIMDISTIRBUTION(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody List<PCMDDSQDMXDTO> pcmddsqdmxdtos) {
        List<PCMDDSQDMX> domainlist=pcmddsqdmxMapping.toDomain(pcmddsqdmxdtos);
        for(PCMDDSQDMX domain:domainlist){
            domain.setPimdistirbutionid(pimdistirbution_id);
        }
        pcmddsqdmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDCreate-all')")
    @ApiOperation(value = "调动更新ByPIMPERSONPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "调动更新ByPIMPERSONPIMDISTIRBUTION")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}/ddcreate")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> dDCreateByPIMPERSONPIMDISTIRBUTION(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain = pcmddsqdmxService.dDCreate(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PostAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(returnObject.body),'ehr-PCMDDSQDMX-Get')")
    @ApiOperation(value = "GetByPIMPERSONPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "GetByPIMPERSONPIMDISTIRBUTION")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}")
    public ResponseEntity<PCMDDSQDMXDTO> getByPIMPERSONPIMDISTIRBUTION(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id) {
        PCMDDSQDMX domain = pcmddsqdmxService.get(pcmddsqdmx_id);
        PCMDDSQDMXDTO dto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxService.get(#pcmddsqdmx_id),'ehr-PCMDDSQDMX-Remove')")
    @ApiOperation(value = "RemoveByPIMPERSONPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "RemoveByPIMPERSONPIMDISTIRBUTION")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMPERSONPIMDISTIRBUTION(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxService.remove(pcmddsqdmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxService.getPcmddsqdmxByIds(#ids),'ehr-PCMDDSQDMX-Remove')")
    @ApiOperation(value = "RemoveBatchByPIMPERSONPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "RemoveBatchByPIMPERSONPIMDISTIRBUTION")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/batch")
    public ResponseEntity<Boolean> removeBatchByPIMPERSONPIMDISTIRBUTION(@RequestBody List<String> ids) {
        pcmddsqdmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-ZZSQ-all')")
    @ApiOperation(value = "自助申请ByPIMPERSONPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "自助申请ByPIMPERSONPIMDISTIRBUTION")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}/zzsq")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> zZSQByPIMPERSONPIMDISTIRBUTION(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain = pcmddsqdmxService.zZSQ(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @ApiOperation(value = "CheckKeyByPIMPERSONPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "CheckKeyByPIMPERSONPIMDISTIRBUTION")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMPERSONPIMDISTIRBUTION(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxService.checkKey(pcmddsqdmxMapping.toDomain(pcmddsqdmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDCZ-all')")
    @ApiOperation(value = "调动操作ByPIMPERSONPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "调动操作ByPIMPERSONPIMDISTIRBUTION")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}/ddcz")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> dDCZByPIMPERSONPIMDISTIRBUTION(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain = pcmddsqdmxService.dDCZ(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-SQTG-all')")
    @ApiOperation(value = "申请通过ByPIMPERSONPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "申请通过ByPIMPERSONPIMDISTIRBUTION")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}/sqtg")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> sQTGByPIMPERSONPIMDISTIRBUTION(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain = pcmddsqdmxService.sQTG(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdto),'ehr-PCMDDSQDMX-Save')")
    @ApiOperation(value = "SaveByPIMPERSONPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "SaveByPIMPERSONPIMDISTIRBUTION")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/save")
    public ResponseEntity<Boolean> saveByPIMPERSONPIMDISTIRBUTION(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmddsqdmxMapping.toDomain(#pcmddsqdmxdtos),'ehr-PCMDDSQDMX-Save')")
    @ApiOperation(value = "SaveBatchByPIMPERSONPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "SaveBatchByPIMPERSONPIMDISTIRBUTION")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMPERSONPIMDISTIRBUTION(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody List<PCMDDSQDMXDTO> pcmddsqdmxdtos) {
        List<PCMDDSQDMX> domainlist=pcmddsqdmxMapping.toDomain(pcmddsqdmxdtos);
        for(PCMDDSQDMX domain:domainlist){
             domain.setPimdistirbutionid(pimdistirbution_id);
        }
        pcmddsqdmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JZCZ-all')")
    @ApiOperation(value = "兼职操作ByPIMPERSONPIMDISTIRBUTION", tags = {"PCMDDSQDMX" },  notes = "兼职操作ByPIMPERSONPIMDISTIRBUTION")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/{pcmddsqdmx_id}/jzcz")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> jZCZByPIMPERSONPIMDISTIRBUTION(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPimdistirbutionid(pimdistirbution_id);
        domain = pcmddsqdmxService.jZCZ(domain) ;
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JZSQMX-all')")
	@ApiOperation(value = "fetch兼职申请明细（未审核完成）ByPIMPERSONPIMDISTIRBUTION", tags = {"PCMDDSQDMX" } ,notes = "fetch兼职申请明细（未审核完成）ByPIMPERSONPIMDISTIRBUTION")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/fetchjzsqmx")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchPCMDDSQDMXJZSQMXByPIMPERSONPIMDISTIRBUTION(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id,PCMDDSQDMXSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJZSQMX(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JZSQMX-all')")
	@ApiOperation(value = "search兼职申请明细（未审核完成）ByPIMPERSONPIMDISTIRBUTION", tags = {"PCMDDSQDMX" } ,notes = "search兼职申请明细（未审核完成）ByPIMPERSONPIMDISTIRBUTION")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/searchjzsqmx")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchPCMDDSQDMXJZSQMXByPIMPERSONPIMDISTIRBUTION(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PCMDDSQDMXSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJZSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JDSQGR-all')")
	@ApiOperation(value = "fetch借调申请（个人）ByPIMPERSONPIMDISTIRBUTION", tags = {"PCMDDSQDMX" } ,notes = "fetch借调申请（个人）ByPIMPERSONPIMDISTIRBUTION")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/fetchjdsqgr")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchPCMDDSQDMXJDSQGRByPIMPERSONPIMDISTIRBUTION(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id,PCMDDSQDMXSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJDSQGR(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JDSQGR-all')")
	@ApiOperation(value = "search借调申请（个人）ByPIMPERSONPIMDISTIRBUTION", tags = {"PCMDDSQDMX" } ,notes = "search借调申请（个人）ByPIMPERSONPIMDISTIRBUTION")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/searchjdsqgr")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchPCMDDSQDMXJDSQGRByPIMPERSONPIMDISTIRBUTION(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PCMDDSQDMXSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJDSQGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPIMPERSONPIMDISTIRBUTION", tags = {"PCMDDSQDMX" } ,notes = "fetchDEFAULTByPIMPERSONPIMDISTIRBUTION")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/fetchdefault")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchPCMDDSQDMXDefaultByPIMPERSONPIMDISTIRBUTION(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id,PCMDDSQDMXSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDefault(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPIMPERSONPIMDISTIRBUTION", tags = {"PCMDDSQDMX" } ,notes = "searchDEFAULTByPIMPERSONPIMDISTIRBUTION")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/searchdefault")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchPCMDDSQDMXDefaultByPIMPERSONPIMDISTIRBUTION(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PCMDDSQDMXSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JDSQMX-all')")
	@ApiOperation(value = "fetch借调申请明细（未审核完成）ByPIMPERSONPIMDISTIRBUTION", tags = {"PCMDDSQDMX" } ,notes = "fetch借调申请明细（未审核完成）ByPIMPERSONPIMDISTIRBUTION")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/fetchjdsqmx")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchPCMDDSQDMXJDSQMXByPIMPERSONPIMDISTIRBUTION(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id,PCMDDSQDMXSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJDSQMX(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JDSQMX-all')")
	@ApiOperation(value = "search借调申请明细（未审核完成）ByPIMPERSONPIMDISTIRBUTION", tags = {"PCMDDSQDMX" } ,notes = "search借调申请明细（未审核完成）ByPIMPERSONPIMDISTIRBUTION")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/searchjdsqmx")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchPCMDDSQDMXJDSQMXByPIMPERSONPIMDISTIRBUTION(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PCMDDSQDMXSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJDSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDJL-all')")
	@ApiOperation(value = "fetch调动记录ByPIMPERSONPIMDISTIRBUTION", tags = {"PCMDDSQDMX" } ,notes = "fetch调动记录ByPIMPERSONPIMDISTIRBUTION")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/fetchddjl")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchPCMDDSQDMXDDJLByPIMPERSONPIMDISTIRBUTION(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id,PCMDDSQDMXSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDDJL(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDJL-all')")
	@ApiOperation(value = "search调动记录ByPIMPERSONPIMDISTIRBUTION", tags = {"PCMDDSQDMX" } ,notes = "search调动记录ByPIMPERSONPIMDISTIRBUTION")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/searchddjl")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchPCMDDSQDMXDDJLByPIMPERSONPIMDISTIRBUTION(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PCMDDSQDMXSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDDJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-GBDDJL-all')")
	@ApiOperation(value = "fetch调动记录ByPIMPERSONPIMDISTIRBUTION", tags = {"PCMDDSQDMX" } ,notes = "fetch调动记录ByPIMPERSONPIMDISTIRBUTION")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/fetchgbddjl")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchPCMDDSQDMXGBDDJLByPIMPERSONPIMDISTIRBUTION(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id,PCMDDSQDMXSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchGBDDJL(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-GBDDJL-all')")
	@ApiOperation(value = "search调动记录ByPIMPERSONPIMDISTIRBUTION", tags = {"PCMDDSQDMX" } ,notes = "search调动记录ByPIMPERSONPIMDISTIRBUTION")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/searchgbddjl")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchPCMDDSQDMXGBDDJLByPIMPERSONPIMDISTIRBUTION(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PCMDDSQDMXSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchGBDDJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDSQGR-all')")
	@ApiOperation(value = "fetch调动申请（个人）ByPIMPERSONPIMDISTIRBUTION", tags = {"PCMDDSQDMX" } ,notes = "fetch调动申请（个人）ByPIMPERSONPIMDISTIRBUTION")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/fetchddsqgr")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchPCMDDSQDMXDDSQGRByPIMPERSONPIMDISTIRBUTION(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id,PCMDDSQDMXSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDDSQGR(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDSQGR-all')")
	@ApiOperation(value = "search调动申请（个人）ByPIMPERSONPIMDISTIRBUTION", tags = {"PCMDDSQDMX" } ,notes = "search调动申请（个人）ByPIMPERSONPIMDISTIRBUTION")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/searchddsqgr")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchPCMDDSQDMXDDSQGRByPIMPERSONPIMDISTIRBUTION(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PCMDDSQDMXSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDDSQGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDMX-all')")
	@ApiOperation(value = "fetch调动明细ByPIMPERSONPIMDISTIRBUTION", tags = {"PCMDDSQDMX" } ,notes = "fetch调动明细ByPIMPERSONPIMDISTIRBUTION")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/fetchddmx")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchPCMDDSQDMXDDMXByPIMPERSONPIMDISTIRBUTION(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id,PCMDDSQDMXSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDDMX(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDMX-all')")
	@ApiOperation(value = "search调动明细ByPIMPERSONPIMDISTIRBUTION", tags = {"PCMDDSQDMX" } ,notes = "search调动明细ByPIMPERSONPIMDISTIRBUTION")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/searchddmx")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchPCMDDSQDMXDDMXByPIMPERSONPIMDISTIRBUTION(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PCMDDSQDMXSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDDMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JZSQGR-all')")
	@ApiOperation(value = "fetch兼职申请（个人）ByPIMPERSONPIMDISTIRBUTION", tags = {"PCMDDSQDMX" } ,notes = "fetch兼职申请（个人）ByPIMPERSONPIMDISTIRBUTION")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/fetchjzsqgr")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchPCMDDSQDMXJZSQGRByPIMPERSONPIMDISTIRBUTION(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id,PCMDDSQDMXSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJZSQGR(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JZSQGR-all')")
	@ApiOperation(value = "search兼职申请（个人）ByPIMPERSONPIMDISTIRBUTION", tags = {"PCMDDSQDMX" } ,notes = "search兼职申请（个人）ByPIMPERSONPIMDISTIRBUTION")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/pcmddsqdmxes/searchjzsqgr")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchPCMDDSQDMXJZSQGRByPIMPERSONPIMDISTIRBUTION(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PCMDDSQDMXSearchContext context) {
        context.setN_pimdistirbutionid_eq(pimdistirbution_id);
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJZSQGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

