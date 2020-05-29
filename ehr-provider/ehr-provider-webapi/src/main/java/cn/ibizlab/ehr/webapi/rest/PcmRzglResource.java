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
import cn.ibizlab.ehr.core.pcm.domain.PcmRzgl;
import cn.ibizlab.ehr.core.pcm.service.IPcmRzglService;
import cn.ibizlab.ehr.core.pcm.filter.PcmRzglSearchContext;

@Slf4j
@Api(tags = {"PcmRzgl" })
@RestController("WebApi-pcmrzgl")
@RequestMapping("")
public class PcmRzglResource {

    @Autowired
    public IPcmRzglService pcmrzglService;

    @Autowired
    @Lazy
    public PcmRzglMapping pcmrzglMapping;

    @PostAuthorize("hasPermission(this.pcmrzglMapping.toDomain(returnObject.body),'ehr-PcmRzgl-Get')")
    @ApiOperation(value = "Get", tags = {"PcmRzgl" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmrzgls/{pcmrzgl_id}")
    public ResponseEntity<PcmRzglDTO> get(@PathVariable("pcmrzgl_id") String pcmrzgl_id) {
        PcmRzgl domain = pcmrzglService.get(pcmrzgl_id);
        PcmRzglDTO dto = pcmrzglMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmrzglMapping.toDomain(#pcmrzgldto),'ehr-PcmRzgl-Save')")
    @ApiOperation(value = "Save", tags = {"PcmRzgl" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmrzgls/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmRzglDTO pcmrzgldto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmrzglService.save(pcmrzglMapping.toDomain(pcmrzgldto)));
    }

    @PreAuthorize("hasPermission(this.pcmrzglMapping.toDomain(#pcmrzgldtos),'ehr-PcmRzgl-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PcmRzgl" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmrzgls/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmRzglDTO> pcmrzgldtos) {
        pcmrzglService.saveBatch(pcmrzglMapping.toDomain(pcmrzgldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"PcmRzgl" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmrzgls/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmRzglDTO pcmrzgldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmrzglService.checkKey(pcmrzglMapping.toDomain(pcmrzgldto)));
    }

    @PreAuthorize("hasPermission(this.pcmrzglService.get(#pcmrzgl_id),'ehr-PcmRzgl-Remove')")
    @ApiOperation(value = "Remove", tags = {"PcmRzgl" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmrzgls/{pcmrzgl_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmrzgl_id") String pcmrzgl_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmrzglService.remove(pcmrzgl_id));
    }

    @PreAuthorize("hasPermission(this.pcmrzglService.getPcmrzglByIds(#ids),'ehr-PcmRzgl-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PcmRzgl" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmrzgls/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmrzglService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmrzglMapping.toDomain(#pcmrzgldto),'ehr-PcmRzgl-Create')")
    @ApiOperation(value = "Create", tags = {"PcmRzgl" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmrzgls")
    @Transactional
    public ResponseEntity<PcmRzglDTO> create(@RequestBody PcmRzglDTO pcmrzgldto) {
        PcmRzgl domain = pcmrzglMapping.toDomain(pcmrzgldto);
		pcmrzglService.create(domain);
        PcmRzglDTO dto = pcmrzglMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmrzglMapping.toDomain(#pcmrzgldtos),'ehr-PcmRzgl-Create')")
    @ApiOperation(value = "createBatch", tags = {"PcmRzgl" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmrzgls/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmRzglDTO> pcmrzgldtos) {
        pcmrzglService.createBatch(pcmrzglMapping.toDomain(pcmrzgldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"PcmRzgl" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmrzgls/getdraft")
    public ResponseEntity<PcmRzglDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmrzglMapping.toDto(pcmrzglService.getDraft(new PcmRzgl())));
    }

    @PreAuthorize("hasPermission(this.pcmrzglService.get(#pcmrzgl_id),'ehr-PcmRzgl-Update')")
    @ApiOperation(value = "Update", tags = {"PcmRzgl" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmrzgls/{pcmrzgl_id}")
    @Transactional
    public ResponseEntity<PcmRzglDTO> update(@PathVariable("pcmrzgl_id") String pcmrzgl_id, @RequestBody PcmRzglDTO pcmrzgldto) {
		PcmRzgl domain  = pcmrzglMapping.toDomain(pcmrzgldto);
        domain .setPcmrzglid(pcmrzgl_id);
		pcmrzglService.update(domain );
		PcmRzglDTO dto = pcmrzglMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmrzglService.getPcmrzglByEntities(this.pcmrzglMapping.toDomain(#pcmrzgldtos)),'ehr-PcmRzgl-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PcmRzgl" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmrzgls/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmRzglDTO> pcmrzgldtos) {
        pcmrzglService.updateBatch(pcmrzglMapping.toDomain(pcmrzgldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmRzgl-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PcmRzgl" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmrzgls/fetchdefault")
	public ResponseEntity<List<PcmRzglDTO>> fetchDefault(PcmRzglSearchContext context) {
        Page<PcmRzgl> domains = pcmrzglService.searchDefault(context) ;
        List<PcmRzglDTO> list = pcmrzglMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmRzgl-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PcmRzgl" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmrzgls/searchdefault")
	public ResponseEntity<Page<PcmRzglDTO>> searchDefault(@RequestBody PcmRzglSearchContext context) {
        Page<PcmRzgl> domains = pcmrzglService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmrzglMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmRzgl-GBRZQXDQ-all')")
	@ApiOperation(value = "fetch干部任职期限查询", tags = {"PcmRzgl" } ,notes = "fetch干部任职期限查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmrzgls/fetchgbrzqxdq")
	public ResponseEntity<List<PcmRzglDTO>> fetchGBRZQXDQ(PcmRzglSearchContext context) {
        Page<PcmRzgl> domains = pcmrzglService.searchGBRZQXDQ(context) ;
        List<PcmRzglDTO> list = pcmrzglMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmRzgl-GBRZQXDQ-all')")
	@ApiOperation(value = "search干部任职期限查询", tags = {"PcmRzgl" } ,notes = "search干部任职期限查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmrzgls/searchgbrzqxdq")
	public ResponseEntity<Page<PcmRzglDTO>> searchGBRZQXDQ(@RequestBody PcmRzglSearchContext context) {
        Page<PcmRzgl> domains = pcmrzglService.searchGBRZQXDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmrzglMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmRzgl-RQCX-all')")
	@ApiOperation(value = "fetchRQCX", tags = {"PcmRzgl" } ,notes = "fetchRQCX")
    @RequestMapping(method= RequestMethod.GET , value="/pcmrzgls/fetchrqcx")
	public ResponseEntity<List<PcmRzglDTO>> fetchRQCX(PcmRzglSearchContext context) {
        Page<PcmRzgl> domains = pcmrzglService.searchRQCX(context) ;
        List<PcmRzglDTO> list = pcmrzglMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmRzgl-RQCX-all')")
	@ApiOperation(value = "searchRQCX", tags = {"PcmRzgl" } ,notes = "searchRQCX")
    @RequestMapping(method= RequestMethod.POST , value="/pcmrzgls/searchrqcx")
	public ResponseEntity<Page<PcmRzglDTO>> searchRQCX(@RequestBody PcmRzglSearchContext context) {
        Page<PcmRzgl> domains = pcmrzglService.searchRQCX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmrzglMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

