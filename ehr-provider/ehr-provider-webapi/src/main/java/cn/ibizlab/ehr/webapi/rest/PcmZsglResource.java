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
import cn.ibizlab.ehr.core.pcm.domain.PcmZsgl;
import cn.ibizlab.ehr.core.pcm.service.IPcmZsglService;
import cn.ibizlab.ehr.core.pcm.filter.PcmZsglSearchContext;

@Slf4j
@Api(tags = {"PcmZsgl" })
@RestController("WebApi-pcmzsgl")
@RequestMapping("")
public class PcmZsglResource {

    @Autowired
    public IPcmZsglService pcmzsglService;

    @Autowired
    @Lazy
    public PcmZsglMapping pcmzsglMapping;

    @PreAuthorize("hasPermission(this.pcmzsglService.get(#pcmzsgl_id),'ehr-PcmZsgl-Remove')")
    @ApiOperation(value = "Remove", tags = {"PcmZsgl" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmzsgls/{pcmzsgl_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmzsgl_id") String pcmzsgl_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmzsglService.remove(pcmzsgl_id));
    }

    @PreAuthorize("hasPermission(this.pcmzsglService.getPcmzsglByIds(#ids),'ehr-PcmZsgl-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PcmZsgl" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmzsgls/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmzsglService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmzsglMapping.toDomain(returnObject.body),'ehr-PcmZsgl-Get')")
    @ApiOperation(value = "Get", tags = {"PcmZsgl" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmzsgls/{pcmzsgl_id}")
    public ResponseEntity<PcmZsglDTO> get(@PathVariable("pcmzsgl_id") String pcmzsgl_id) {
        PcmZsgl domain = pcmzsglService.get(pcmzsgl_id);
        PcmZsglDTO dto = pcmzsglMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "GetDraft", tags = {"PcmZsgl" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmzsgls/getdraft")
    public ResponseEntity<PcmZsglDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmzsglMapping.toDto(pcmzsglService.getDraft(new PcmZsgl())));
    }

    @ApiOperation(value = "CheckKey", tags = {"PcmZsgl" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzsgls/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmZsglDTO pcmzsgldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmzsglService.checkKey(pcmzsglMapping.toDomain(pcmzsgldto)));
    }

    @PreAuthorize("hasPermission(this.pcmzsglService.get(#pcmzsgl_id),'ehr-PcmZsgl-Update')")
    @ApiOperation(value = "Update", tags = {"PcmZsgl" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmzsgls/{pcmzsgl_id}")
    @Transactional
    public ResponseEntity<PcmZsglDTO> update(@PathVariable("pcmzsgl_id") String pcmzsgl_id, @RequestBody PcmZsglDTO pcmzsgldto) {
		PcmZsgl domain  = pcmzsglMapping.toDomain(pcmzsgldto);
        domain .setPcmzsglid(pcmzsgl_id);
		pcmzsglService.update(domain );
		PcmZsglDTO dto = pcmzsglMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmzsglService.getPcmzsglByEntities(this.pcmzsglMapping.toDomain(#pcmzsgldtos)),'ehr-PcmZsgl-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PcmZsgl" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmzsgls/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmZsglDTO> pcmzsgldtos) {
        pcmzsglService.updateBatch(pcmzsglMapping.toDomain(pcmzsgldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmzsglMapping.toDomain(#pcmzsgldto),'ehr-PcmZsgl-Save')")
    @ApiOperation(value = "Save", tags = {"PcmZsgl" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzsgls/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmZsglDTO pcmzsgldto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmzsglService.save(pcmzsglMapping.toDomain(pcmzsgldto)));
    }

    @PreAuthorize("hasPermission(this.pcmzsglMapping.toDomain(#pcmzsgldtos),'ehr-PcmZsgl-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PcmZsgl" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzsgls/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmZsglDTO> pcmzsgldtos) {
        pcmzsglService.saveBatch(pcmzsglMapping.toDomain(pcmzsgldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmzsglMapping.toDomain(#pcmzsgldto),'ehr-PcmZsgl-Create')")
    @ApiOperation(value = "Create", tags = {"PcmZsgl" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzsgls")
    @Transactional
    public ResponseEntity<PcmZsglDTO> create(@RequestBody PcmZsglDTO pcmzsgldto) {
        PcmZsgl domain = pcmzsglMapping.toDomain(pcmzsgldto);
		pcmzsglService.create(domain);
        PcmZsglDTO dto = pcmzsglMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmzsglMapping.toDomain(#pcmzsgldtos),'ehr-PcmZsgl-Create')")
    @ApiOperation(value = "createBatch", tags = {"PcmZsgl" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzsgls/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmZsglDTO> pcmzsgldtos) {
        pcmzsglService.createBatch(pcmzsglMapping.toDomain(pcmzsgldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmZsgl-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PcmZsgl" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmzsgls/fetchdefault")
	public ResponseEntity<List<PcmZsglDTO>> fetchDefault(PcmZsglSearchContext context) {
        Page<PcmZsgl> domains = pcmzsglService.searchDefault(context) ;
        List<PcmZsglDTO> list = pcmzsglMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmZsgl-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PcmZsgl" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmzsgls/searchdefault")
	public ResponseEntity<Page<PcmZsglDTO>> searchDefault(@RequestBody PcmZsglSearchContext context) {
        Page<PcmZsgl> domains = pcmzsglService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmzsglMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

