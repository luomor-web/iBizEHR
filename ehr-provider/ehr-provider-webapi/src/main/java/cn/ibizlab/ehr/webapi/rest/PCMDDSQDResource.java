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
import cn.ibizlab.ehr.core.pcm.domain.PCMDDSQD;
import cn.ibizlab.ehr.core.pcm.service.IPCMDDSQDService;
import cn.ibizlab.ehr.core.pcm.filter.PCMDDSQDSearchContext;

@Slf4j
@Api(tags = {"PCMDDSQD" })
@RestController("WebApi-pcmddsqd")
@RequestMapping("")
public class PCMDDSQDResource {

    @Autowired
    public IPCMDDSQDService pcmddsqdService;

    @Autowired
    @Lazy
    public PCMDDSQDMapping pcmddsqdMapping;

    @PreAuthorize("hasPermission(this.pcmddsqdMapping.toDomain(#pcmddsqddto),'ehr-PCMDDSQD-Create')")
    @ApiOperation(value = "Create", tags = {"PCMDDSQD" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqds")
    @Transactional
    public ResponseEntity<PCMDDSQDDTO> create(@RequestBody PCMDDSQDDTO pcmddsqddto) {
        PCMDDSQD domain = pcmddsqdMapping.toDomain(pcmddsqddto);
		pcmddsqdService.create(domain);
        PCMDDSQDDTO dto = pcmddsqdMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdMapping.toDomain(#pcmddsqddtos),'ehr-PCMDDSQD-Create')")
    @ApiOperation(value = "createBatch", tags = {"PCMDDSQD" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqds/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMDDSQDDTO> pcmddsqddtos) {
        pcmddsqdService.createBatch(pcmddsqdMapping.toDomain(pcmddsqddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQD-PDD-all')")
    @ApiOperation(value = "批调动", tags = {"PCMDDSQD" },  notes = "批调动")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqds/{pcmddsqd_id}/pdd")
    @Transactional
    public ResponseEntity<PCMDDSQDDTO> pDD(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @RequestBody PCMDDSQDDTO pcmddsqddto) {
        PCMDDSQD pcmddsqd = pcmddsqdMapping.toDomain(pcmddsqddto);
        pcmddsqd.setPcmddsqdid(pcmddsqd_id);
        pcmddsqd = pcmddsqdService.pDD(pcmddsqd);
        pcmddsqddto = pcmddsqdMapping.toDto(pcmddsqd);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqddto);
    }

    @PostAuthorize("hasPermission(this.pcmddsqdMapping.toDomain(returnObject.body),'ehr-PCMDDSQD-Get')")
    @ApiOperation(value = "Get", tags = {"PCMDDSQD" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmddsqds/{pcmddsqd_id}")
    public ResponseEntity<PCMDDSQDDTO> get(@PathVariable("pcmddsqd_id") String pcmddsqd_id) {
        PCMDDSQD domain = pcmddsqdService.get(pcmddsqd_id);
        PCMDDSQDDTO dto = pcmddsqdMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdService.get(#pcmddsqd_id),'ehr-PCMDDSQD-Update')")
    @ApiOperation(value = "Update", tags = {"PCMDDSQD" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmddsqds/{pcmddsqd_id}")
    @Transactional
    public ResponseEntity<PCMDDSQDDTO> update(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @RequestBody PCMDDSQDDTO pcmddsqddto) {
		PCMDDSQD domain  = pcmddsqdMapping.toDomain(pcmddsqddto);
        domain .setPcmddsqdid(pcmddsqd_id);
		pcmddsqdService.update(domain );
		PCMDDSQDDTO dto = pcmddsqdMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdService.getPcmddsqdByEntities(this.pcmddsqdMapping.toDomain(#pcmddsqddtos)),'ehr-PCMDDSQD-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMDDSQD" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmddsqds/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMDDSQDDTO> pcmddsqddtos) {
        pcmddsqdService.updateBatch(pcmddsqdMapping.toDomain(pcmddsqddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"PCMDDSQD" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqds/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMDDSQDDTO pcmddsqddto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmddsqdService.checkKey(pcmddsqdMapping.toDomain(pcmddsqddto)));
    }

    @PreAuthorize("hasPermission(this.pcmddsqdMapping.toDomain(#pcmddsqddto),'ehr-PCMDDSQD-Save')")
    @ApiOperation(value = "Save", tags = {"PCMDDSQD" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqds/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMDDSQDDTO pcmddsqddto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdService.save(pcmddsqdMapping.toDomain(pcmddsqddto)));
    }

    @PreAuthorize("hasPermission(this.pcmddsqdMapping.toDomain(#pcmddsqddtos),'ehr-PCMDDSQD-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PCMDDSQD" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqds/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMDDSQDDTO> pcmddsqddtos) {
        pcmddsqdService.saveBatch(pcmddsqdMapping.toDomain(pcmddsqddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdService.get(#pcmddsqd_id),'ehr-PCMDDSQD-Remove')")
    @ApiOperation(value = "Remove", tags = {"PCMDDSQD" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmddsqds/{pcmddsqd_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmddsqd_id") String pcmddsqd_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdService.remove(pcmddsqd_id));
    }

    @PreAuthorize("hasPermission(this.pcmddsqdService.getPcmddsqdByIds(#ids),'ehr-PCMDDSQD-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PCMDDSQD" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmddsqds/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmddsqdService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"PCMDDSQD" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmddsqds/getdraft")
    public ResponseEntity<PCMDDSQDDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdMapping.toDto(pcmddsqdService.getDraft(new PCMDDSQD())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQD-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMDDSQD" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqds/fetchdefault")
	public ResponseEntity<List<PCMDDSQDDTO>> fetchDefault(PCMDDSQDSearchContext context) {
        Page<PCMDDSQD> domains = pcmddsqdService.searchDefault(context) ;
        List<PCMDDSQDDTO> list = pcmddsqdMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQD-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMDDSQD" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqds/searchdefault")
	public ResponseEntity<Page<PCMDDSQDDTO>> searchDefault(@RequestBody PCMDDSQDSearchContext context) {
        Page<PCMDDSQD> domains = pcmddsqdService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

