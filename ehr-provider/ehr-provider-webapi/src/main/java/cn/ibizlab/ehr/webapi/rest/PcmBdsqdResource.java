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
import cn.ibizlab.ehr.core.pcm.domain.PcmBdsqd;
import cn.ibizlab.ehr.core.pcm.service.IPcmBdsqdService;
import cn.ibizlab.ehr.core.pcm.filter.PcmBdsqdSearchContext;

@Slf4j
@Api(tags = {"PcmBdsqd" })
@RestController("WebApi-pcmbdsqd")
@RequestMapping("")
public class PcmBdsqdResource {

    @Autowired
    public IPcmBdsqdService pcmbdsqdService;

    @Autowired
    @Lazy
    public PcmBdsqdMapping pcmbdsqdMapping;

    @PreAuthorize("hasPermission(this.pcmbdsqdService.get(#pcmbdsqd_id),'ehr-PcmBdsqd-Update')")
    @ApiOperation(value = "Update", tags = {"PcmBdsqd" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmbdsqds/{pcmbdsqd_id}")
    @Transactional
    public ResponseEntity<PcmBdsqdDTO> update(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PcmBdsqdDTO pcmbdsqddto) {
		PcmBdsqd domain  = pcmbdsqdMapping.toDomain(pcmbdsqddto);
        domain .setPcmbdsqdid(pcmbdsqd_id);
		pcmbdsqdService.update(domain );
		PcmBdsqdDTO dto = pcmbdsqdMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdService.getPcmbdsqdByEntities(this.pcmbdsqdMapping.toDomain(#pcmbdsqddtos)),'ehr-PcmBdsqd-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PcmBdsqd" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmbdsqds/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmBdsqdDTO> pcmbdsqddtos) {
        pcmbdsqdService.updateBatch(pcmbdsqdMapping.toDomain(pcmbdsqddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdMapping.toDomain(#pcmbdsqddto),'ehr-PcmBdsqd-Save')")
    @ApiOperation(value = "Save", tags = {"PcmBdsqd" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmBdsqdDTO pcmbdsqddto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdService.save(pcmbdsqdMapping.toDomain(pcmbdsqddto)));
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdMapping.toDomain(#pcmbdsqddtos),'ehr-PcmBdsqd-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PcmBdsqd" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmBdsqdDTO> pcmbdsqddtos) {
        pcmbdsqdService.saveBatch(pcmbdsqdMapping.toDomain(pcmbdsqddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmbdsqdMapping.toDomain(returnObject.body),'ehr-PcmBdsqd-Get')")
    @ApiOperation(value = "Get", tags = {"PcmBdsqd" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmbdsqds/{pcmbdsqd_id}")
    public ResponseEntity<PcmBdsqdDTO> get(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id) {
        PcmBdsqd domain = pcmbdsqdService.get(pcmbdsqd_id);
        PcmBdsqdDTO dto = pcmbdsqdMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "GetDraft", tags = {"PcmBdsqd" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmbdsqds/getdraft")
    public ResponseEntity<PcmBdsqdDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdMapping.toDto(pcmbdsqdService.getDraft(new PcmBdsqd())));
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdMapping.toDomain(#pcmbdsqddto),'ehr-PcmBdsqd-Create')")
    @ApiOperation(value = "Create", tags = {"PcmBdsqd" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds")
    @Transactional
    public ResponseEntity<PcmBdsqdDTO> create(@RequestBody PcmBdsqdDTO pcmbdsqddto) {
        PcmBdsqd domain = pcmbdsqdMapping.toDomain(pcmbdsqddto);
		pcmbdsqdService.create(domain);
        PcmBdsqdDTO dto = pcmbdsqdMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdMapping.toDomain(#pcmbdsqddtos),'ehr-PcmBdsqd-Create')")
    @ApiOperation(value = "createBatch", tags = {"PcmBdsqd" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmBdsqdDTO> pcmbdsqddtos) {
        pcmbdsqdService.createBatch(pcmbdsqdMapping.toDomain(pcmbdsqddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"PcmBdsqd" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmBdsqdDTO pcmbdsqddto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdService.checkKey(pcmbdsqdMapping.toDomain(pcmbdsqddto)));
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdService.get(#pcmbdsqd_id),'ehr-PcmBdsqd-Remove')")
    @ApiOperation(value = "Remove", tags = {"PcmBdsqd" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmbdsqds/{pcmbdsqd_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdService.remove(pcmbdsqd_id));
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdService.getPcmbdsqdByIds(#ids),'ehr-PcmBdsqd-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PcmBdsqd" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmbdsqds/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmbdsqdService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqd-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PcmBdsqd" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqds/fetchdefault")
	public ResponseEntity<List<PcmBdsqdDTO>> fetchDefault(PcmBdsqdSearchContext context) {
        Page<PcmBdsqd> domains = pcmbdsqdService.searchDefault(context) ;
        List<PcmBdsqdDTO> list = pcmbdsqdMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqd-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PcmBdsqd" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqds/searchdefault")
	public ResponseEntity<Page<PcmBdsqdDTO>> searchDefault(@RequestBody PcmBdsqdSearchContext context) {
        Page<PcmBdsqd> domains = pcmbdsqdService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

