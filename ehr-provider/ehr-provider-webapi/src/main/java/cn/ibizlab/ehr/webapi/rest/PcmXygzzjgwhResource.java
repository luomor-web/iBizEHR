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
import cn.ibizlab.ehr.core.pcm.domain.PcmXygzzjgwh;
import cn.ibizlab.ehr.core.pcm.service.IPcmXygzzjgwhService;
import cn.ibizlab.ehr.core.pcm.filter.PcmXygzzjgwhSearchContext;

@Slf4j
@Api(tags = {"PcmXygzzjgwh" })
@RestController("WebApi-pcmxygzzjgwh")
@RequestMapping("")
public class PcmXygzzjgwhResource {

    @Autowired
    public IPcmXygzzjgwhService pcmxygzzjgwhService;

    @Autowired
    @Lazy
    public PcmXygzzjgwhMapping pcmxygzzjgwhMapping;

    @ApiOperation(value = "GetDraft", tags = {"PcmXygzzjgwh" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmxygzzjgwhs/getdraft")
    public ResponseEntity<PcmXygzzjgwhDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzjgwhMapping.toDto(pcmxygzzjgwhService.getDraft(new PcmXygzzjgwh())));
    }

    @PreAuthorize("hasPermission(this.pcmxygzzjgwhMapping.toDomain(#pcmxygzzjgwhdto),'ehr-PcmXygzzjgwh-Save')")
    @ApiOperation(value = "Save", tags = {"PcmXygzzjgwh" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzjgwhs/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmXygzzjgwhDTO pcmxygzzjgwhdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzjgwhService.save(pcmxygzzjgwhMapping.toDomain(pcmxygzzjgwhdto)));
    }

    @PreAuthorize("hasPermission(this.pcmxygzzjgwhMapping.toDomain(#pcmxygzzjgwhdtos),'ehr-PcmXygzzjgwh-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PcmXygzzjgwh" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzjgwhs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmXygzzjgwhDTO> pcmxygzzjgwhdtos) {
        pcmxygzzjgwhService.saveBatch(pcmxygzzjgwhMapping.toDomain(pcmxygzzjgwhdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmxygzzjgwhService.get(#pcmxygzzjgwh_id),'ehr-PcmXygzzjgwh-Update')")
    @ApiOperation(value = "Update", tags = {"PcmXygzzjgwh" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmxygzzjgwhs/{pcmxygzzjgwh_id}")
    @Transactional
    public ResponseEntity<PcmXygzzjgwhDTO> update(@PathVariable("pcmxygzzjgwh_id") String pcmxygzzjgwh_id, @RequestBody PcmXygzzjgwhDTO pcmxygzzjgwhdto) {
		PcmXygzzjgwh domain  = pcmxygzzjgwhMapping.toDomain(pcmxygzzjgwhdto);
        domain .setPcmxygzzjgwhid(pcmxygzzjgwh_id);
		pcmxygzzjgwhService.update(domain );
		PcmXygzzjgwhDTO dto = pcmxygzzjgwhMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmxygzzjgwhService.getPcmxygzzjgwhByEntities(this.pcmxygzzjgwhMapping.toDomain(#pcmxygzzjgwhdtos)),'ehr-PcmXygzzjgwh-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PcmXygzzjgwh" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmxygzzjgwhs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmXygzzjgwhDTO> pcmxygzzjgwhdtos) {
        pcmxygzzjgwhService.updateBatch(pcmxygzzjgwhMapping.toDomain(pcmxygzzjgwhdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmxygzzjgwhMapping.toDomain(#pcmxygzzjgwhdto),'ehr-PcmXygzzjgwh-Create')")
    @ApiOperation(value = "Create", tags = {"PcmXygzzjgwh" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzjgwhs")
    @Transactional
    public ResponseEntity<PcmXygzzjgwhDTO> create(@RequestBody PcmXygzzjgwhDTO pcmxygzzjgwhdto) {
        PcmXygzzjgwh domain = pcmxygzzjgwhMapping.toDomain(pcmxygzzjgwhdto);
		pcmxygzzjgwhService.create(domain);
        PcmXygzzjgwhDTO dto = pcmxygzzjgwhMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmxygzzjgwhMapping.toDomain(#pcmxygzzjgwhdtos),'ehr-PcmXygzzjgwh-Create')")
    @ApiOperation(value = "createBatch", tags = {"PcmXygzzjgwh" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzjgwhs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmXygzzjgwhDTO> pcmxygzzjgwhdtos) {
        pcmxygzzjgwhService.createBatch(pcmxygzzjgwhMapping.toDomain(pcmxygzzjgwhdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"PcmXygzzjgwh" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzjgwhs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmXygzzjgwhDTO pcmxygzzjgwhdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmxygzzjgwhService.checkKey(pcmxygzzjgwhMapping.toDomain(pcmxygzzjgwhdto)));
    }

    @PreAuthorize("hasPermission(this.pcmxygzzjgwhService.get(#pcmxygzzjgwh_id),'ehr-PcmXygzzjgwh-Remove')")
    @ApiOperation(value = "Remove", tags = {"PcmXygzzjgwh" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmxygzzjgwhs/{pcmxygzzjgwh_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmxygzzjgwh_id") String pcmxygzzjgwh_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzjgwhService.remove(pcmxygzzjgwh_id));
    }

    @PreAuthorize("hasPermission(this.pcmxygzzjgwhService.getPcmxygzzjgwhByIds(#ids),'ehr-PcmXygzzjgwh-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PcmXygzzjgwh" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmxygzzjgwhs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmxygzzjgwhService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmxygzzjgwhMapping.toDomain(returnObject.body),'ehr-PcmXygzzjgwh-Get')")
    @ApiOperation(value = "Get", tags = {"PcmXygzzjgwh" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmxygzzjgwhs/{pcmxygzzjgwh_id}")
    public ResponseEntity<PcmXygzzjgwhDTO> get(@PathVariable("pcmxygzzjgwh_id") String pcmxygzzjgwh_id) {
        PcmXygzzjgwh domain = pcmxygzzjgwhService.get(pcmxygzzjgwh_id);
        PcmXygzzjgwhDTO dto = pcmxygzzjgwhMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmXygzzjgwh-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PcmXygzzjgwh" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmxygzzjgwhs/fetchdefault")
	public ResponseEntity<List<PcmXygzzjgwhDTO>> fetchDefault(PcmXygzzjgwhSearchContext context) {
        Page<PcmXygzzjgwh> domains = pcmxygzzjgwhService.searchDefault(context) ;
        List<PcmXygzzjgwhDTO> list = pcmxygzzjgwhMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmXygzzjgwh-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PcmXygzzjgwh" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmxygzzjgwhs/searchdefault")
	public ResponseEntity<Page<PcmXygzzjgwhDTO>> searchDefault(@RequestBody PcmXygzzjgwhSearchContext context) {
        Page<PcmXygzzjgwh> domains = pcmxygzzjgwhService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmxygzzjgwhMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

