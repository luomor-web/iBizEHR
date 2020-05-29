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
import cn.ibizlab.ehr.core.pcm.domain.PcmJxsgz;
import cn.ibizlab.ehr.core.pcm.service.IPcmJxsgzService;
import cn.ibizlab.ehr.core.pcm.filter.PcmJxsgzSearchContext;

@Slf4j
@Api(tags = {"PcmJxsgz" })
@RestController("WebApi-pcmjxsgz")
@RequestMapping("")
public class PcmJxsgzResource {

    @Autowired
    public IPcmJxsgzService pcmjxsgzService;

    @Autowired
    @Lazy
    public PcmJxsgzMapping pcmjxsgzMapping;

    @ApiOperation(value = "CheckKey", tags = {"PcmJxsgz" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsgzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmJxsgzDTO pcmjxsgzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmjxsgzService.checkKey(pcmjxsgzMapping.toDomain(pcmjxsgzdto)));
    }

    @PreAuthorize("hasPermission(this.pcmjxsgzService.get(#pcmjxsgz_id),'ehr-PcmJxsgz-Remove')")
    @ApiOperation(value = "Remove", tags = {"PcmJxsgz" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmjxsgzs/{pcmjxsgz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmjxsgz_id") String pcmjxsgz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmjxsgzService.remove(pcmjxsgz_id));
    }

    @PreAuthorize("hasPermission(this.pcmjxsgzService.getPcmjxsgzByIds(#ids),'ehr-PcmJxsgz-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PcmJxsgz" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmjxsgzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmjxsgzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmjxsgzService.get(#pcmjxsgz_id),'ehr-PcmJxsgz-Update')")
    @ApiOperation(value = "Update", tags = {"PcmJxsgz" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmjxsgzs/{pcmjxsgz_id}")
    @Transactional
    public ResponseEntity<PcmJxsgzDTO> update(@PathVariable("pcmjxsgz_id") String pcmjxsgz_id, @RequestBody PcmJxsgzDTO pcmjxsgzdto) {
		PcmJxsgz domain  = pcmjxsgzMapping.toDomain(pcmjxsgzdto);
        domain .setPcmjxsgzid(pcmjxsgz_id);
		pcmjxsgzService.update(domain );
		PcmJxsgzDTO dto = pcmjxsgzMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmjxsgzService.getPcmjxsgzByEntities(this.pcmjxsgzMapping.toDomain(#pcmjxsgzdtos)),'ehr-PcmJxsgz-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PcmJxsgz" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmjxsgzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmJxsgzDTO> pcmjxsgzdtos) {
        pcmjxsgzService.updateBatch(pcmjxsgzMapping.toDomain(pcmjxsgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmjxsgzMapping.toDomain(returnObject.body),'ehr-PcmJxsgz-Get')")
    @ApiOperation(value = "Get", tags = {"PcmJxsgz" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmjxsgzs/{pcmjxsgz_id}")
    public ResponseEntity<PcmJxsgzDTO> get(@PathVariable("pcmjxsgz_id") String pcmjxsgz_id) {
        PcmJxsgz domain = pcmjxsgzService.get(pcmjxsgz_id);
        PcmJxsgzDTO dto = pcmjxsgzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "GetDraft", tags = {"PcmJxsgz" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmjxsgzs/getdraft")
    public ResponseEntity<PcmJxsgzDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsgzMapping.toDto(pcmjxsgzService.getDraft(new PcmJxsgz())));
    }

    @PreAuthorize("hasPermission(this.pcmjxsgzMapping.toDomain(#pcmjxsgzdto),'ehr-PcmJxsgz-Create')")
    @ApiOperation(value = "Create", tags = {"PcmJxsgz" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsgzs")
    @Transactional
    public ResponseEntity<PcmJxsgzDTO> create(@RequestBody PcmJxsgzDTO pcmjxsgzdto) {
        PcmJxsgz domain = pcmjxsgzMapping.toDomain(pcmjxsgzdto);
		pcmjxsgzService.create(domain);
        PcmJxsgzDTO dto = pcmjxsgzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmjxsgzMapping.toDomain(#pcmjxsgzdtos),'ehr-PcmJxsgz-Create')")
    @ApiOperation(value = "createBatch", tags = {"PcmJxsgz" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsgzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmJxsgzDTO> pcmjxsgzdtos) {
        pcmjxsgzService.createBatch(pcmjxsgzMapping.toDomain(pcmjxsgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmjxsgzMapping.toDomain(#pcmjxsgzdto),'ehr-PcmJxsgz-Save')")
    @ApiOperation(value = "Save", tags = {"PcmJxsgz" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsgzs/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmJxsgzDTO pcmjxsgzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsgzService.save(pcmjxsgzMapping.toDomain(pcmjxsgzdto)));
    }

    @PreAuthorize("hasPermission(this.pcmjxsgzMapping.toDomain(#pcmjxsgzdtos),'ehr-PcmJxsgz-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PcmJxsgz" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsgzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmJxsgzDTO> pcmjxsgzdtos) {
        pcmjxsgzService.saveBatch(pcmjxsgzMapping.toDomain(pcmjxsgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsgz-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PcmJxsgz" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmjxsgzs/fetchdefault")
	public ResponseEntity<List<PcmJxsgzDTO>> fetchDefault(PcmJxsgzSearchContext context) {
        Page<PcmJxsgz> domains = pcmjxsgzService.searchDefault(context) ;
        List<PcmJxsgzDTO> list = pcmjxsgzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsgz-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PcmJxsgz" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmjxsgzs/searchdefault")
	public ResponseEntity<Page<PcmJxsgzDTO>> searchDefault(@RequestBody PcmJxsgzSearchContext context) {
        Page<PcmJxsgz> domains = pcmjxsgzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmjxsgzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

