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
import cn.ibizlab.ehr.core.pcm.domain.PCMBDSQD;
import cn.ibizlab.ehr.core.pcm.service.IPCMBDSQDService;
import cn.ibizlab.ehr.core.pcm.filter.PCMBDSQDSearchContext;

@Slf4j
@Api(tags = {"PCMBDSQD" })
@RestController("WebApi-pcmbdsqd")
@RequestMapping("")
public class PCMBDSQDResource {

    @Autowired
    public IPCMBDSQDService pcmbdsqdService;

    @Autowired
    @Lazy
    public PCMBDSQDMapping pcmbdsqdMapping;

    @PreAuthorize("hasPermission(this.pcmbdsqdService.get(#pcmbdsqd_id),'ehr-PCMBDSQD-Update')")
    @ApiOperation(value = "Update", tags = {"PCMBDSQD" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmbdsqds/{pcmbdsqd_id}")
    @Transactional
    public ResponseEntity<PCMBDSQDDTO> update(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PCMBDSQDDTO pcmbdsqddto) {
		PCMBDSQD domain  = pcmbdsqdMapping.toDomain(pcmbdsqddto);
        domain .setPcmbdsqdid(pcmbdsqd_id);
		pcmbdsqdService.update(domain );
		PCMBDSQDDTO dto = pcmbdsqdMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdService.getPcmbdsqdByEntities(this.pcmbdsqdMapping.toDomain(#pcmbdsqddtos)),'ehr-PCMBDSQD-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMBDSQD" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmbdsqds/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMBDSQDDTO> pcmbdsqddtos) {
        pcmbdsqdService.updateBatch(pcmbdsqdMapping.toDomain(pcmbdsqddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdMapping.toDomain(#pcmbdsqddto),'ehr-PCMBDSQD-Save')")
    @ApiOperation(value = "Save", tags = {"PCMBDSQD" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMBDSQDDTO pcmbdsqddto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdService.save(pcmbdsqdMapping.toDomain(pcmbdsqddto)));
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdMapping.toDomain(#pcmbdsqddtos),'ehr-PCMBDSQD-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PCMBDSQD" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMBDSQDDTO> pcmbdsqddtos) {
        pcmbdsqdService.saveBatch(pcmbdsqdMapping.toDomain(pcmbdsqddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmbdsqdMapping.toDomain(returnObject.body),'ehr-PCMBDSQD-Get')")
    @ApiOperation(value = "Get", tags = {"PCMBDSQD" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmbdsqds/{pcmbdsqd_id}")
    public ResponseEntity<PCMBDSQDDTO> get(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id) {
        PCMBDSQD domain = pcmbdsqdService.get(pcmbdsqd_id);
        PCMBDSQDDTO dto = pcmbdsqdMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "GetDraft", tags = {"PCMBDSQD" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmbdsqds/getdraft")
    public ResponseEntity<PCMBDSQDDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdMapping.toDto(pcmbdsqdService.getDraft(new PCMBDSQD())));
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdMapping.toDomain(#pcmbdsqddto),'ehr-PCMBDSQD-Create')")
    @ApiOperation(value = "Create", tags = {"PCMBDSQD" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds")
    @Transactional
    public ResponseEntity<PCMBDSQDDTO> create(@RequestBody PCMBDSQDDTO pcmbdsqddto) {
        PCMBDSQD domain = pcmbdsqdMapping.toDomain(pcmbdsqddto);
		pcmbdsqdService.create(domain);
        PCMBDSQDDTO dto = pcmbdsqdMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdMapping.toDomain(#pcmbdsqddtos),'ehr-PCMBDSQD-Create')")
    @ApiOperation(value = "createBatch", tags = {"PCMBDSQD" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMBDSQDDTO> pcmbdsqddtos) {
        pcmbdsqdService.createBatch(pcmbdsqdMapping.toDomain(pcmbdsqddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"PCMBDSQD" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMBDSQDDTO pcmbdsqddto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdService.checkKey(pcmbdsqdMapping.toDomain(pcmbdsqddto)));
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdService.get(#pcmbdsqd_id),'ehr-PCMBDSQD-Remove')")
    @ApiOperation(value = "Remove", tags = {"PCMBDSQD" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmbdsqds/{pcmbdsqd_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdService.remove(pcmbdsqd_id));
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdService.getPcmbdsqdByIds(#ids),'ehr-PCMBDSQD-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PCMBDSQD" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmbdsqds/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmbdsqdService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQD-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMBDSQD" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqds/fetchdefault")
	public ResponseEntity<List<PCMBDSQDDTO>> fetchDefault(PCMBDSQDSearchContext context) {
        Page<PCMBDSQD> domains = pcmbdsqdService.searchDefault(context) ;
        List<PCMBDSQDDTO> list = pcmbdsqdMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQD-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMBDSQD" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqds/searchdefault")
	public ResponseEntity<Page<PCMBDSQDDTO>> searchDefault(@RequestBody PCMBDSQDSearchContext context) {
        Page<PCMBDSQD> domains = pcmbdsqdService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

