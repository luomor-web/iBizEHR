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
@Api(tags = {"PcmJxsygzzjlmx" })
@RestController("WebApi-pcmjxsygzzjlmx")
@RequestMapping("")
public class PcmJxsygzzjlmxResource {

    @Autowired
    public IPcmJxsygzzjlmxService pcmjxsygzzjlmxService;

    @Autowired
    @Lazy
    public PcmJxsygzzjlmxMapping pcmjxsygzzjlmxMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzjlmx-SHBTG-all')")
    @ApiOperation(value = "审核不通过", tags = {"PcmJxsygzzjlmx" },  notes = "审核不通过")
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
    @ApiOperation(value = "审核通过", tags = {"PcmJxsygzzjlmx" },  notes = "审核通过")
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
    @ApiOperation(value = "Save", tags = {"PcmJxsygzzjlmx" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzjlmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmJxsygzzjlmxDTO pcmjxsygzzjlmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzjlmxService.save(pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzjlmxMapping.toDomain(#pcmjxsygzzjlmxdtos),'ehr-PcmJxsygzzjlmx-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PcmJxsygzzjlmx" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzjlmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmJxsygzzjlmxDTO> pcmjxsygzzjlmxdtos) {
        pcmjxsygzzjlmxService.saveBatch(pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzjlmx-FillPersonInfo-all')")
    @ApiOperation(value = "", tags = {"PcmJxsygzzjlmx" },  notes = "")
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
    @ApiOperation(value = "转正操作", tags = {"PcmJxsygzzjlmx" },  notes = "转正操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzjlmxes/{pcmjxsygzzjlmx_id}/zzcz")
    @Transactional
    public ResponseEntity<PcmJxsygzzjlmxDTO> zZCZ(@PathVariable("pcmjxsygzzjlmx_id") String pcmjxsygzzjlmx_id, @RequestBody PcmJxsygzzjlmxDTO pcmjxsygzzjlmxdto) {
        PcmJxsygzzjlmx pcmjxsygzzjlmx = pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdto);
        pcmjxsygzzjlmx.setPcmjxsygzzjlmxid(pcmjxsygzzjlmx_id);
        pcmjxsygzzjlmx = pcmjxsygzzjlmxService.zZCZ(pcmjxsygzzjlmx);
        pcmjxsygzzjlmxdto = pcmjxsygzzjlmxMapping.toDto(pcmjxsygzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzjlmxdto);
    }

    @ApiOperation(value = "GetDraft", tags = {"PcmJxsygzzjlmx" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmjxsygzzjlmxes/getdraft")
    public ResponseEntity<PcmJxsygzzjlmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzjlmxMapping.toDto(pcmjxsygzzjlmxService.getDraft(new PcmJxsygzzjlmx())));
    }

    @PostAuthorize("hasPermission(this.pcmjxsygzzjlmxMapping.toDomain(returnObject.body),'ehr-PcmJxsygzzjlmx-Get')")
    @ApiOperation(value = "Get", tags = {"PcmJxsygzzjlmx" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmjxsygzzjlmxes/{pcmjxsygzzjlmx_id}")
    public ResponseEntity<PcmJxsygzzjlmxDTO> get(@PathVariable("pcmjxsygzzjlmx_id") String pcmjxsygzzjlmx_id) {
        PcmJxsygzzjlmx domain = pcmjxsygzzjlmxService.get(pcmjxsygzzjlmx_id);
        PcmJxsygzzjlmxDTO dto = pcmjxsygzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzjlmxService.get(#pcmjxsygzzjlmx_id),'ehr-PcmJxsygzzjlmx-Remove')")
    @ApiOperation(value = "Remove", tags = {"PcmJxsygzzjlmx" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmjxsygzzjlmxes/{pcmjxsygzzjlmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmjxsygzzjlmx_id") String pcmjxsygzzjlmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzjlmxService.remove(pcmjxsygzzjlmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzjlmxService.getPcmjxsygzzjlmxByIds(#ids),'ehr-PcmJxsygzzjlmx-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PcmJxsygzzjlmx" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmjxsygzzjlmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmjxsygzzjlmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzjlmxMapping.toDomain(#pcmjxsygzzjlmxdto),'ehr-PcmJxsygzzjlmx-Create')")
    @ApiOperation(value = "Create", tags = {"PcmJxsygzzjlmx" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzjlmxes")
    @Transactional
    public ResponseEntity<PcmJxsygzzjlmxDTO> create(@RequestBody PcmJxsygzzjlmxDTO pcmjxsygzzjlmxdto) {
        PcmJxsygzzjlmx domain = pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdto);
		pcmjxsygzzjlmxService.create(domain);
        PcmJxsygzzjlmxDTO dto = pcmjxsygzzjlmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzjlmxMapping.toDomain(#pcmjxsygzzjlmxdtos),'ehr-PcmJxsygzzjlmx-Create')")
    @ApiOperation(value = "createBatch", tags = {"PcmJxsygzzjlmx" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzjlmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmJxsygzzjlmxDTO> pcmjxsygzzjlmxdtos) {
        pcmjxsygzzjlmxService.createBatch(pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzjlmxService.get(#pcmjxsygzzjlmx_id),'ehr-PcmJxsygzzjlmx-Update')")
    @ApiOperation(value = "Update", tags = {"PcmJxsygzzjlmx" },  notes = "Update")
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
    @ApiOperation(value = "UpdateBatch", tags = {"PcmJxsygzzjlmx" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmjxsygzzjlmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmJxsygzzjlmxDTO> pcmjxsygzzjlmxdtos) {
        pcmjxsygzzjlmxService.updateBatch(pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"PcmJxsygzzjlmx" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzjlmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmJxsygzzjlmxDTO pcmjxsygzzjlmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzjlmxService.checkKey(pcmjxsygzzjlmxMapping.toDomain(pcmjxsygzzjlmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzjlmx-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PcmJxsygzzjlmx" } ,notes = "fetchDEFAULT")
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
	@ApiOperation(value = "searchDEFAULT", tags = {"PcmJxsygzzjlmx" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmjxsygzzjlmxes/searchdefault")
	public ResponseEntity<Page<PcmJxsygzzjlmxDTO>> searchDefault(@RequestBody PcmJxsygzzjlmxSearchContext context) {
        Page<PcmJxsygzzjlmx> domains = pcmjxsygzzjlmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmjxsygzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzjlmx-WSHSQ-all')")
	@ApiOperation(value = "fetch未审核完成的申请", tags = {"PcmJxsygzzjlmx" } ,notes = "fetch未审核完成的申请")
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
	@ApiOperation(value = "search未审核完成的申请", tags = {"PcmJxsygzzjlmx" } ,notes = "search未审核完成的申请")
    @RequestMapping(method= RequestMethod.POST , value="/pcmjxsygzzjlmxes/searchwshsq")
	public ResponseEntity<Page<PcmJxsygzzjlmxDTO>> searchWSHSQ(@RequestBody PcmJxsygzzjlmxSearchContext context) {
        Page<PcmJxsygzzjlmx> domains = pcmjxsygzzjlmxService.searchWSHSQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmjxsygzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzjlmx-JXSZZJL-all')")
	@ApiOperation(value = "fetch见习生转正记录", tags = {"PcmJxsygzzjlmx" } ,notes = "fetch见习生转正记录")
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
	@ApiOperation(value = "search见习生转正记录", tags = {"PcmJxsygzzjlmx" } ,notes = "search见习生转正记录")
    @RequestMapping(method= RequestMethod.POST , value="/pcmjxsygzzjlmxes/searchjxszzjl")
	public ResponseEntity<Page<PcmJxsygzzjlmxDTO>> searchJXSZZJL(@RequestBody PcmJxsygzzjlmxSearchContext context) {
        Page<PcmJxsygzzjlmx> domains = pcmjxsygzzjlmxService.searchJXSZZJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmjxsygzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzjlmx-ALLDS-all')")
	@ApiOperation(value = "fetch所有的申请明细", tags = {"PcmJxsygzzjlmx" } ,notes = "fetch所有的申请明细")
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
	@ApiOperation(value = "search所有的申请明细", tags = {"PcmJxsygzzjlmx" } ,notes = "search所有的申请明细")
    @RequestMapping(method= RequestMethod.POST , value="/pcmjxsygzzjlmxes/searchallds")
	public ResponseEntity<Page<PcmJxsygzzjlmxDTO>> searchALLDS(@RequestBody PcmJxsygzzjlmxSearchContext context) {
        Page<PcmJxsygzzjlmx> domains = pcmjxsygzzjlmxService.searchALLDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmjxsygzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

