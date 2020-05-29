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
import cn.ibizlab.ehr.core.pcm.domain.PcmXygzzkhjgjl;
import cn.ibizlab.ehr.core.pcm.service.IPcmXygzzkhjgjlService;
import cn.ibizlab.ehr.core.pcm.filter.PcmXygzzkhjgjlSearchContext;

@Slf4j
@Api(tags = {"PcmXygzzkhjgjl" })
@RestController("WebApi-pcmxygzzkhjgjl")
@RequestMapping("")
public class PcmXygzzkhjgjlResource {

    @Autowired
    public IPcmXygzzkhjgjlService pcmxygzzkhjgjlService;

    @Autowired
    @Lazy
    public PcmXygzzkhjgjlMapping pcmxygzzkhjgjlMapping;

    @PreAuthorize("hasPermission(this.pcmxygzzkhjgjlService.get(#pcmxygzzkhjgjl_id),'ehr-PcmXygzzkhjgjl-Update')")
    @ApiOperation(value = "Update", tags = {"PcmXygzzkhjgjl" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmxygzzkhjgjls/{pcmxygzzkhjgjl_id}")
    @Transactional
    public ResponseEntity<PcmXygzzkhjgjlDTO> update(@PathVariable("pcmxygzzkhjgjl_id") String pcmxygzzkhjgjl_id, @RequestBody PcmXygzzkhjgjlDTO pcmxygzzkhjgjldto) {
		PcmXygzzkhjgjl domain  = pcmxygzzkhjgjlMapping.toDomain(pcmxygzzkhjgjldto);
        domain .setPcmxygzzkhjgjlid(pcmxygzzkhjgjl_id);
		pcmxygzzkhjgjlService.update(domain );
		PcmXygzzkhjgjlDTO dto = pcmxygzzkhjgjlMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmxygzzkhjgjlService.getPcmxygzzkhjgjlByEntities(this.pcmxygzzkhjgjlMapping.toDomain(#pcmxygzzkhjgjldtos)),'ehr-PcmXygzzkhjgjl-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PcmXygzzkhjgjl" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmxygzzkhjgjls/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmXygzzkhjgjlDTO> pcmxygzzkhjgjldtos) {
        pcmxygzzkhjgjlService.updateBatch(pcmxygzzkhjgjlMapping.toDomain(pcmxygzzkhjgjldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmxygzzkhjgjlMapping.toDomain(returnObject.body),'ehr-PcmXygzzkhjgjl-Get')")
    @ApiOperation(value = "Get", tags = {"PcmXygzzkhjgjl" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmxygzzkhjgjls/{pcmxygzzkhjgjl_id}")
    public ResponseEntity<PcmXygzzkhjgjlDTO> get(@PathVariable("pcmxygzzkhjgjl_id") String pcmxygzzkhjgjl_id) {
        PcmXygzzkhjgjl domain = pcmxygzzkhjgjlService.get(pcmxygzzkhjgjl_id);
        PcmXygzzkhjgjlDTO dto = pcmxygzzkhjgjlMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmxygzzkhjgjlMapping.toDomain(#pcmxygzzkhjgjldto),'ehr-PcmXygzzkhjgjl-Create')")
    @ApiOperation(value = "Create", tags = {"PcmXygzzkhjgjl" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzkhjgjls")
    @Transactional
    public ResponseEntity<PcmXygzzkhjgjlDTO> create(@RequestBody PcmXygzzkhjgjlDTO pcmxygzzkhjgjldto) {
        PcmXygzzkhjgjl domain = pcmxygzzkhjgjlMapping.toDomain(pcmxygzzkhjgjldto);
		pcmxygzzkhjgjlService.create(domain);
        PcmXygzzkhjgjlDTO dto = pcmxygzzkhjgjlMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmxygzzkhjgjlMapping.toDomain(#pcmxygzzkhjgjldtos),'ehr-PcmXygzzkhjgjl-Create')")
    @ApiOperation(value = "createBatch", tags = {"PcmXygzzkhjgjl" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzkhjgjls/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmXygzzkhjgjlDTO> pcmxygzzkhjgjldtos) {
        pcmxygzzkhjgjlService.createBatch(pcmxygzzkhjgjlMapping.toDomain(pcmxygzzkhjgjldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmxygzzkhjgjlService.get(#pcmxygzzkhjgjl_id),'ehr-PcmXygzzkhjgjl-Remove')")
    @ApiOperation(value = "Remove", tags = {"PcmXygzzkhjgjl" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmxygzzkhjgjls/{pcmxygzzkhjgjl_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmxygzzkhjgjl_id") String pcmxygzzkhjgjl_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzkhjgjlService.remove(pcmxygzzkhjgjl_id));
    }

    @PreAuthorize("hasPermission(this.pcmxygzzkhjgjlService.getPcmxygzzkhjgjlByIds(#ids),'ehr-PcmXygzzkhjgjl-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PcmXygzzkhjgjl" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmxygzzkhjgjls/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmxygzzkhjgjlService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmxygzzkhjgjlMapping.toDomain(#pcmxygzzkhjgjldto),'ehr-PcmXygzzkhjgjl-Save')")
    @ApiOperation(value = "Save", tags = {"PcmXygzzkhjgjl" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzkhjgjls/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmXygzzkhjgjlDTO pcmxygzzkhjgjldto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzkhjgjlService.save(pcmxygzzkhjgjlMapping.toDomain(pcmxygzzkhjgjldto)));
    }

    @PreAuthorize("hasPermission(this.pcmxygzzkhjgjlMapping.toDomain(#pcmxygzzkhjgjldtos),'ehr-PcmXygzzkhjgjl-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PcmXygzzkhjgjl" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzkhjgjls/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmXygzzkhjgjlDTO> pcmxygzzkhjgjldtos) {
        pcmxygzzkhjgjlService.saveBatch(pcmxygzzkhjgjlMapping.toDomain(pcmxygzzkhjgjldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"PcmXygzzkhjgjl" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmxygzzkhjgjls/getdraft")
    public ResponseEntity<PcmXygzzkhjgjlDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzkhjgjlMapping.toDto(pcmxygzzkhjgjlService.getDraft(new PcmXygzzkhjgjl())));
    }

    @ApiOperation(value = "CheckKey", tags = {"PcmXygzzkhjgjl" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzkhjgjls/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmXygzzkhjgjlDTO pcmxygzzkhjgjldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmxygzzkhjgjlService.checkKey(pcmxygzzkhjgjlMapping.toDomain(pcmxygzzkhjgjldto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmXygzzkhjgjl-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PcmXygzzkhjgjl" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmxygzzkhjgjls/fetchdefault")
	public ResponseEntity<List<PcmXygzzkhjgjlDTO>> fetchDefault(PcmXygzzkhjgjlSearchContext context) {
        Page<PcmXygzzkhjgjl> domains = pcmxygzzkhjgjlService.searchDefault(context) ;
        List<PcmXygzzkhjgjlDTO> list = pcmxygzzkhjgjlMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmXygzzkhjgjl-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PcmXygzzkhjgjl" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmxygzzkhjgjls/searchdefault")
	public ResponseEntity<Page<PcmXygzzkhjgjlDTO>> searchDefault(@RequestBody PcmXygzzkhjgjlSearchContext context) {
        Page<PcmXygzzkhjgjl> domains = pcmxygzzkhjgjlService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmxygzzkhjgjlMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

