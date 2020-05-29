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
@Api(tags = {"PcmYdjdmx" })
@RestController("WebApi-pcmydjdmx")
@RequestMapping("")
public class PcmYdjdmxResource {

    @Autowired
    public IPcmYdjdmxService pcmydjdmxService;

    @Autowired
    @Lazy
    public PcmYdjdmxMapping pcmydjdmxMapping;

    @PostAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(returnObject.body),'ehr-PcmYdjdmx-Get')")
    @ApiOperation(value = "Get", tags = {"PcmYdjdmx" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydjdmxes/{pcmydjdmx_id}")
    public ResponseEntity<PcmYdjdmxDTO> get(@PathVariable("pcmydjdmx_id") String pcmydjdmx_id) {
        PcmYdjdmx domain = pcmydjdmxService.get(pcmydjdmx_id);
        PcmYdjdmxDTO dto = pcmydjdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-FillPersonInfo-all')")
    @ApiOperation(value = "填充员工信息", tags = {"PcmYdjdmx" },  notes = "填充员工信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjdmxes/{pcmydjdmx_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> fillPersonInfo(@PathVariable("pcmydjdmx_id") String pcmydjdmx_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx pcmydjdmx = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        pcmydjdmx.setPcmydjdmxid(pcmydjdmx_id);
        pcmydjdmx = pcmydjdmxService.fillPersonInfo(pcmydjdmx);
        pcmydjdmxdto = pcmydjdmxMapping.toDto(pcmydjdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxdto);
    }

    @ApiOperation(value = "GetDraft", tags = {"PcmYdjdmx" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydjdmxes/getdraft")
    public ResponseEntity<PcmYdjdmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxMapping.toDto(pcmydjdmxService.getDraft(new PcmYdjdmx())));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.get(#pcmydjdmx_id),'ehr-PcmYdjdmx-Update')")
    @ApiOperation(value = "Update", tags = {"PcmYdjdmx" },  notes = "Update")
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
    @ApiOperation(value = "UpdateBatch", tags = {"PcmYdjdmx" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydjdmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmYdjdmxDTO> pcmydjdmxdtos) {
        pcmydjdmxService.updateBatch(pcmydjdmxMapping.toDomain(pcmydjdmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.get(#pcmydjdmx_id),'ehr-PcmYdjdmx-Remove')")
    @ApiOperation(value = "Remove", tags = {"PcmYdjdmx" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydjdmxes/{pcmydjdmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmydjdmx_id") String pcmydjdmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxService.remove(pcmydjdmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxService.getPcmydjdmxByIds(#ids),'ehr-PcmYdjdmx-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PcmYdjdmx" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydjdmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmydjdmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-RYHG-all')")
    @ApiOperation(value = "人员回归", tags = {"PcmYdjdmx" },  notes = "人员回归")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjdmxes/{pcmydjdmx_id}/ryhg")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> rYHG(@PathVariable("pcmydjdmx_id") String pcmydjdmx_id, @RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx pcmydjdmx = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        pcmydjdmx.setPcmydjdmxid(pcmydjdmx_id);
        pcmydjdmx = pcmydjdmxService.rYHG(pcmydjdmx);
        pcmydjdmxdto = pcmydjdmxMapping.toDto(pcmydjdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxdto);
    }

    @ApiOperation(value = "CheckKey", tags = {"PcmYdjdmx" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjdmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxService.checkKey(pcmydjdmxMapping.toDomain(pcmydjdmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdto),'ehr-PcmYdjdmx-Save')")
    @ApiOperation(value = "Save", tags = {"PcmYdjdmx" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjdmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxService.save(pcmydjdmxMapping.toDomain(pcmydjdmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdtos),'ehr-PcmYdjdmx-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PcmYdjdmx" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjdmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmYdjdmxDTO> pcmydjdmxdtos) {
        pcmydjdmxService.saveBatch(pcmydjdmxMapping.toDomain(pcmydjdmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdto),'ehr-PcmYdjdmx-Create')")
    @ApiOperation(value = "Create", tags = {"PcmYdjdmx" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjdmxes")
    @Transactional
    public ResponseEntity<PcmYdjdmxDTO> create(@RequestBody PcmYdjdmxDTO pcmydjdmxdto) {
        PcmYdjdmx domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
		pcmydjdmxService.create(domain);
        PcmYdjdmxDTO dto = pcmydjdmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmydjdmxMapping.toDomain(#pcmydjdmxdtos),'ehr-PcmYdjdmx-Create')")
    @ApiOperation(value = "createBatch", tags = {"PcmYdjdmx" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjdmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmYdjdmxDTO> pcmydjdmxdtos) {
        pcmydjdmxService.createBatch(pcmydjdmxMapping.toDomain(pcmydjdmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDGLDQ-all')")
	@ApiOperation(value = "fetch借调管理查询", tags = {"PcmYdjdmx" } ,notes = "fetch借调管理查询")
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
	@ApiOperation(value = "search借调管理查询", tags = {"PcmYdjdmx" } ,notes = "search借调管理查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydjdmxes/searchjdgldq")
	public ResponseEntity<Page<PcmYdjdmxDTO>> searchJDGLDQ(@RequestBody PcmYdjdmxSearchContext context) {
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDGLDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-JDLSJLDQ-all')")
	@ApiOperation(value = "fetch借调历史记录查询", tags = {"PcmYdjdmx" } ,notes = "fetch借调历史记录查询")
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
	@ApiOperation(value = "search借调历史记录查询", tags = {"PcmYdjdmx" } ,notes = "search借调历史记录查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydjdmxes/searchjdlsjldq")
	public ResponseEntity<Page<PcmYdjdmxDTO>> searchJDLSJLDQ(@RequestBody PcmYdjdmxSearchContext context) {
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchJDLSJLDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmYdjdmx-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PcmYdjdmx" } ,notes = "fetchDEFAULT")
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
	@ApiOperation(value = "searchDEFAULT", tags = {"PcmYdjdmx" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydjdmxes/searchdefault")
	public ResponseEntity<Page<PcmYdjdmxDTO>> searchDefault(@RequestBody PcmYdjdmxSearchContext context) {
        Page<PcmYdjdmx> domains = pcmydjdmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

