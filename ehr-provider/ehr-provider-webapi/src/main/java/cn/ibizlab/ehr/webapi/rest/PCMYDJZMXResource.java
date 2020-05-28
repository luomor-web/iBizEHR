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
import cn.ibizlab.ehr.core.pcm.domain.PCMYDJZMX;
import cn.ibizlab.ehr.core.pcm.service.IPCMYDJZMXService;
import cn.ibizlab.ehr.core.pcm.filter.PCMYDJZMXSearchContext;

@Slf4j
@Api(tags = {"PCMYDJZMX" })
@RestController("WebApi-pcmydjzmx")
@RequestMapping("")
public class PCMYDJZMXResource {

    @Autowired
    public IPCMYDJZMXService pcmydjzmxService;

    @Autowired
    @Lazy
    public PCMYDJZMXMapping pcmydjzmxMapping;

    @ApiOperation(value = "GetDraft", tags = {"PCMYDJZMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydjzmxes/getdraft")
    public ResponseEntity<PCMYDJZMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjzmxMapping.toDto(pcmydjzmxService.getDraft(new PCMYDJZMX())));
    }

    @PreAuthorize("hasPermission(this.pcmydjzmxMapping.toDomain(#pcmydjzmxdto),'ehr-PCMYDJZMX-Save')")
    @ApiOperation(value = "Save", tags = {"PCMYDJZMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjzmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMYDJZMXDTO pcmydjzmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjzmxService.save(pcmydjzmxMapping.toDomain(pcmydjzmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmydjzmxMapping.toDomain(#pcmydjzmxdtos),'ehr-PCMYDJZMX-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PCMYDJZMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjzmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMYDJZMXDTO> pcmydjzmxdtos) {
        pcmydjzmxService.saveBatch(pcmydjzmxMapping.toDomain(pcmydjzmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDJZMX-RYHG-all')")
    @ApiOperation(value = "人员回归", tags = {"PCMYDJZMX" },  notes = "人员回归")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjzmxes/{pcmydjzmx_id}/ryhg")
    @Transactional
    public ResponseEntity<PCMYDJZMXDTO> rYHG(@PathVariable("pcmydjzmx_id") String pcmydjzmx_id, @RequestBody PCMYDJZMXDTO pcmydjzmxdto) {
        PCMYDJZMX pcmydjzmx = pcmydjzmxMapping.toDomain(pcmydjzmxdto);
        pcmydjzmx.setPcmydjzmxid(pcmydjzmx_id);
        pcmydjzmx = pcmydjzmxService.rYHG(pcmydjzmx);
        pcmydjzmxdto = pcmydjzmxMapping.toDto(pcmydjzmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjzmxdto);
    }

    @PostAuthorize("hasPermission(this.pcmydjzmxMapping.toDomain(returnObject.body),'ehr-PCMYDJZMX-Get')")
    @ApiOperation(value = "Get", tags = {"PCMYDJZMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydjzmxes/{pcmydjzmx_id}")
    public ResponseEntity<PCMYDJZMXDTO> get(@PathVariable("pcmydjzmx_id") String pcmydjzmx_id) {
        PCMYDJZMX domain = pcmydjzmxService.get(pcmydjzmx_id);
        PCMYDJZMXDTO dto = pcmydjzmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydjzmxService.get(#pcmydjzmx_id),'ehr-PCMYDJZMX-Update')")
    @ApiOperation(value = "Update", tags = {"PCMYDJZMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydjzmxes/{pcmydjzmx_id}")
    @Transactional
    public ResponseEntity<PCMYDJZMXDTO> update(@PathVariable("pcmydjzmx_id") String pcmydjzmx_id, @RequestBody PCMYDJZMXDTO pcmydjzmxdto) {
		PCMYDJZMX domain  = pcmydjzmxMapping.toDomain(pcmydjzmxdto);
        domain .setPcmydjzmxid(pcmydjzmx_id);
		pcmydjzmxService.update(domain );
		PCMYDJZMXDTO dto = pcmydjzmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydjzmxService.getPcmydjzmxByEntities(this.pcmydjzmxMapping.toDomain(#pcmydjzmxdtos)),'ehr-PCMYDJZMX-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMYDJZMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydjzmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMYDJZMXDTO> pcmydjzmxdtos) {
        pcmydjzmxService.updateBatch(pcmydjzmxMapping.toDomain(pcmydjzmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydjzmxService.get(#pcmydjzmx_id),'ehr-PCMYDJZMX-Remove')")
    @ApiOperation(value = "Remove", tags = {"PCMYDJZMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydjzmxes/{pcmydjzmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmydjzmx_id") String pcmydjzmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmydjzmxService.remove(pcmydjzmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmydjzmxService.getPcmydjzmxByIds(#ids),'ehr-PCMYDJZMX-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PCMYDJZMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydjzmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmydjzmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDJZMX-FillPersonInfo-all')")
    @ApiOperation(value = "填充员工信息", tags = {"PCMYDJZMX" },  notes = "填充员工信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjzmxes/{pcmydjzmx_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PCMYDJZMXDTO> fillPersonInfo(@PathVariable("pcmydjzmx_id") String pcmydjzmx_id, @RequestBody PCMYDJZMXDTO pcmydjzmxdto) {
        PCMYDJZMX pcmydjzmx = pcmydjzmxMapping.toDomain(pcmydjzmxdto);
        pcmydjzmx.setPcmydjzmxid(pcmydjzmx_id);
        pcmydjzmx = pcmydjzmxService.fillPersonInfo(pcmydjzmx);
        pcmydjzmxdto = pcmydjzmxMapping.toDto(pcmydjzmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjzmxdto);
    }

    @ApiOperation(value = "CheckKey", tags = {"PCMYDJZMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjzmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMYDJZMXDTO pcmydjzmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmydjzmxService.checkKey(pcmydjzmxMapping.toDomain(pcmydjzmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmydjzmxMapping.toDomain(#pcmydjzmxdto),'ehr-PCMYDJZMX-Create')")
    @ApiOperation(value = "Create", tags = {"PCMYDJZMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjzmxes")
    @Transactional
    public ResponseEntity<PCMYDJZMXDTO> create(@RequestBody PCMYDJZMXDTO pcmydjzmxdto) {
        PCMYDJZMX domain = pcmydjzmxMapping.toDomain(pcmydjzmxdto);
		pcmydjzmxService.create(domain);
        PCMYDJZMXDTO dto = pcmydjzmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydjzmxMapping.toDomain(#pcmydjzmxdtos),'ehr-PCMYDJZMX-Create')")
    @ApiOperation(value = "createBatch", tags = {"PCMYDJZMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjzmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMYDJZMXDTO> pcmydjzmxdtos) {
        pcmydjzmxService.createBatch(pcmydjzmxMapping.toDomain(pcmydjzmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDJZMX-GLDS-all')")
	@ApiOperation(value = "fetch管理查询", tags = {"PCMYDJZMX" } ,notes = "fetch管理查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydjzmxes/fetchglds")
	public ResponseEntity<List<PCMYDJZMXDTO>> fetchGLDS(PCMYDJZMXSearchContext context) {
        Page<PCMYDJZMX> domains = pcmydjzmxService.searchGLDS(context) ;
        List<PCMYDJZMXDTO> list = pcmydjzmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDJZMX-GLDS-all')")
	@ApiOperation(value = "search管理查询", tags = {"PCMYDJZMX" } ,notes = "search管理查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydjzmxes/searchglds")
	public ResponseEntity<Page<PCMYDJZMXDTO>> searchGLDS(@RequestBody PCMYDJZMXSearchContext context) {
        Page<PCMYDJZMX> domains = pcmydjzmxService.searchGLDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjzmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDJZMX-LSJLDS-all')")
	@ApiOperation(value = "fetch历史记录查看", tags = {"PCMYDJZMX" } ,notes = "fetch历史记录查看")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydjzmxes/fetchlsjlds")
	public ResponseEntity<List<PCMYDJZMXDTO>> fetchLSJLDS(PCMYDJZMXSearchContext context) {
        Page<PCMYDJZMX> domains = pcmydjzmxService.searchLSJLDS(context) ;
        List<PCMYDJZMXDTO> list = pcmydjzmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDJZMX-LSJLDS-all')")
	@ApiOperation(value = "search历史记录查看", tags = {"PCMYDJZMX" } ,notes = "search历史记录查看")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydjzmxes/searchlsjlds")
	public ResponseEntity<Page<PCMYDJZMXDTO>> searchLSJLDS(@RequestBody PCMYDJZMXSearchContext context) {
        Page<PCMYDJZMX> domains = pcmydjzmxService.searchLSJLDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjzmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDJZMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMYDJZMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydjzmxes/fetchdefault")
	public ResponseEntity<List<PCMYDJZMXDTO>> fetchDefault(PCMYDJZMXSearchContext context) {
        Page<PCMYDJZMX> domains = pcmydjzmxService.searchDefault(context) ;
        List<PCMYDJZMXDTO> list = pcmydjzmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDJZMX-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMYDJZMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydjzmxes/searchdefault")
	public ResponseEntity<Page<PCMYDJZMXDTO>> searchDefault(@RequestBody PCMYDJZMXSearchContext context) {
        Page<PCMYDJZMX> domains = pcmydjzmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjzmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

