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
import cn.ibizlab.ehr.core.pcm.domain.PcmYdjzmx;
import cn.ibizlab.ehr.core.pcm.service.IPcmYdjzmxService;
import cn.ibizlab.ehr.core.pcm.filter.PcmYdjzmxSearchContext;

@Slf4j
@Api(tags = {"PcmYdjzmx" })
@RestController("WebApi-pcmydjzmx")
@RequestMapping("")
public class PcmYdjzmxResource {

    @Autowired
    public IPcmYdjzmxService pcmydjzmxService;

    @Autowired
    @Lazy
    public PcmYdjzmxMapping pcmydjzmxMapping;

    @ApiOperation(value = "GetDraft", tags = {"PcmYdjzmx" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydjzmxes/getdraft")
    public ResponseEntity<PcmYdjzmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjzmxMapping.toDto(pcmydjzmxService.getDraft(new PcmYdjzmx())));
    }

    @PreAuthorize("hasPermission(this.pcmydjzmxMapping.toDomain(#pcmydjzmxdto),'ehr-PcmYdjzmx-Save')")
    @ApiOperation(value = "Save", tags = {"PcmYdjzmx" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjzmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmYdjzmxDTO pcmydjzmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjzmxService.save(pcmydjzmxMapping.toDomain(pcmydjzmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmydjzmxMapping.toDomain(#pcmydjzmxdtos),'ehr-PcmYdjzmx-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PcmYdjzmx" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjzmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmYdjzmxDTO> pcmydjzmxdtos) {
        pcmydjzmxService.saveBatch(pcmydjzmxMapping.toDomain(pcmydjzmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjzmx-RYHG-all')")
    @ApiOperation(value = "人员回归", tags = {"PcmYdjzmx" },  notes = "人员回归")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjzmxes/{pcmydjzmx_id}/ryhg")
    @Transactional
    public ResponseEntity<PcmYdjzmxDTO> rYHG(@PathVariable("pcmydjzmx_id") String pcmydjzmx_id, @RequestBody PcmYdjzmxDTO pcmydjzmxdto) {
        PcmYdjzmx pcmydjzmx = pcmydjzmxMapping.toDomain(pcmydjzmxdto);
        pcmydjzmx.setPcmydjzmxid(pcmydjzmx_id);
        pcmydjzmx = pcmydjzmxService.rYHG(pcmydjzmx);
        pcmydjzmxdto = pcmydjzmxMapping.toDto(pcmydjzmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjzmxdto);
    }

    @PostAuthorize("hasPermission(this.pcmydjzmxMapping.toDomain(returnObject.body),'ehr-PcmYdjzmx-Get')")
    @ApiOperation(value = "Get", tags = {"PcmYdjzmx" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydjzmxes/{pcmydjzmx_id}")
    public ResponseEntity<PcmYdjzmxDTO> get(@PathVariable("pcmydjzmx_id") String pcmydjzmx_id) {
        PcmYdjzmx domain = pcmydjzmxService.get(pcmydjzmx_id);
        PcmYdjzmxDTO dto = pcmydjzmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydjzmxService.get(#pcmydjzmx_id),'ehr-PcmYdjzmx-Update')")
    @ApiOperation(value = "Update", tags = {"PcmYdjzmx" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydjzmxes/{pcmydjzmx_id}")
    @Transactional
    public ResponseEntity<PcmYdjzmxDTO> update(@PathVariable("pcmydjzmx_id") String pcmydjzmx_id, @RequestBody PcmYdjzmxDTO pcmydjzmxdto) {
		PcmYdjzmx domain  = pcmydjzmxMapping.toDomain(pcmydjzmxdto);
        domain .setPcmydjzmxid(pcmydjzmx_id);
		pcmydjzmxService.update(domain );
		PcmYdjzmxDTO dto = pcmydjzmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydjzmxService.getPcmydjzmxByEntities(this.pcmydjzmxMapping.toDomain(#pcmydjzmxdtos)),'ehr-PcmYdjzmx-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PcmYdjzmx" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydjzmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmYdjzmxDTO> pcmydjzmxdtos) {
        pcmydjzmxService.updateBatch(pcmydjzmxMapping.toDomain(pcmydjzmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydjzmxService.get(#pcmydjzmx_id),'ehr-PcmYdjzmx-Remove')")
    @ApiOperation(value = "Remove", tags = {"PcmYdjzmx" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydjzmxes/{pcmydjzmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmydjzmx_id") String pcmydjzmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmydjzmxService.remove(pcmydjzmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmydjzmxService.getPcmydjzmxByIds(#ids),'ehr-PcmYdjzmx-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PcmYdjzmx" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydjzmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmydjzmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjzmx-FillPersonInfo-all')")
    @ApiOperation(value = "填充员工信息", tags = {"PcmYdjzmx" },  notes = "填充员工信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjzmxes/{pcmydjzmx_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PcmYdjzmxDTO> fillPersonInfo(@PathVariable("pcmydjzmx_id") String pcmydjzmx_id, @RequestBody PcmYdjzmxDTO pcmydjzmxdto) {
        PcmYdjzmx pcmydjzmx = pcmydjzmxMapping.toDomain(pcmydjzmxdto);
        pcmydjzmx.setPcmydjzmxid(pcmydjzmx_id);
        pcmydjzmx = pcmydjzmxService.fillPersonInfo(pcmydjzmx);
        pcmydjzmxdto = pcmydjzmxMapping.toDto(pcmydjzmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjzmxdto);
    }

    @ApiOperation(value = "CheckKey", tags = {"PcmYdjzmx" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjzmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmYdjzmxDTO pcmydjzmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmydjzmxService.checkKey(pcmydjzmxMapping.toDomain(pcmydjzmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmydjzmxMapping.toDomain(#pcmydjzmxdto),'ehr-PcmYdjzmx-Create')")
    @ApiOperation(value = "Create", tags = {"PcmYdjzmx" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjzmxes")
    @Transactional
    public ResponseEntity<PcmYdjzmxDTO> create(@RequestBody PcmYdjzmxDTO pcmydjzmxdto) {
        PcmYdjzmx domain = pcmydjzmxMapping.toDomain(pcmydjzmxdto);
		pcmydjzmxService.create(domain);
        PcmYdjzmxDTO dto = pcmydjzmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydjzmxMapping.toDomain(#pcmydjzmxdtos),'ehr-PcmYdjzmx-Create')")
    @ApiOperation(value = "createBatch", tags = {"PcmYdjzmx" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjzmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmYdjzmxDTO> pcmydjzmxdtos) {
        pcmydjzmxService.createBatch(pcmydjzmxMapping.toDomain(pcmydjzmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjzmx-GLDS-all')")
	@ApiOperation(value = "fetch管理查询", tags = {"PcmYdjzmx" } ,notes = "fetch管理查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydjzmxes/fetchglds")
	public ResponseEntity<List<PcmYdjzmxDTO>> fetchGLDS(PcmYdjzmxSearchContext context) {
        Page<PcmYdjzmx> domains = pcmydjzmxService.searchGLDS(context) ;
        List<PcmYdjzmxDTO> list = pcmydjzmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjzmx-GLDS-all')")
	@ApiOperation(value = "search管理查询", tags = {"PcmYdjzmx" } ,notes = "search管理查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydjzmxes/searchglds")
	public ResponseEntity<Page<PcmYdjzmxDTO>> searchGLDS(@RequestBody PcmYdjzmxSearchContext context) {
        Page<PcmYdjzmx> domains = pcmydjzmxService.searchGLDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjzmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjzmx-LSJLDS-all')")
	@ApiOperation(value = "fetch历史记录查看", tags = {"PcmYdjzmx" } ,notes = "fetch历史记录查看")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydjzmxes/fetchlsjlds")
	public ResponseEntity<List<PcmYdjzmxDTO>> fetchLSJLDS(PcmYdjzmxSearchContext context) {
        Page<PcmYdjzmx> domains = pcmydjzmxService.searchLSJLDS(context) ;
        List<PcmYdjzmxDTO> list = pcmydjzmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjzmx-LSJLDS-all')")
	@ApiOperation(value = "search历史记录查看", tags = {"PcmYdjzmx" } ,notes = "search历史记录查看")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydjzmxes/searchlsjlds")
	public ResponseEntity<Page<PcmYdjzmxDTO>> searchLSJLDS(@RequestBody PcmYdjzmxSearchContext context) {
        Page<PcmYdjzmx> domains = pcmydjzmxService.searchLSJLDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjzmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjzmx-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PcmYdjzmx" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydjzmxes/fetchdefault")
	public ResponseEntity<List<PcmYdjzmxDTO>> fetchDefault(PcmYdjzmxSearchContext context) {
        Page<PcmYdjzmx> domains = pcmydjzmxService.searchDefault(context) ;
        List<PcmYdjzmxDTO> list = pcmydjzmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjzmx-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PcmYdjzmx" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydjzmxes/searchdefault")
	public ResponseEntity<Page<PcmYdjzmxDTO>> searchDefault(@RequestBody PcmYdjzmxSearchContext context) {
        Page<PcmYdjzmx> domains = pcmydjzmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjzmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

