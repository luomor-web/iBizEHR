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
import cn.ibizlab.ehr.core.pcm.domain.PCMZJDYZW;
import cn.ibizlab.ehr.core.pcm.service.IPCMZJDYZWService;
import cn.ibizlab.ehr.core.pcm.filter.PCMZJDYZWSearchContext;

@Slf4j
@Api(tags = {"PCMZJDYZW" })
@RestController("WebApi-pcmzjdyzw")
@RequestMapping("")
public class PCMZJDYZWResource {

    @Autowired
    public IPCMZJDYZWService pcmzjdyzwService;

    @Autowired
    @Lazy
    public PCMZJDYZWMapping pcmzjdyzwMapping;

    @ApiOperation(value = "CheckKey", tags = {"PCMZJDYZW" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzjdyzws/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMZJDYZWDTO pcmzjdyzwdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmzjdyzwService.checkKey(pcmzjdyzwMapping.toDomain(pcmzjdyzwdto)));
    }

    @ApiOperation(value = "GetDraft", tags = {"PCMZJDYZW" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmzjdyzws/getdraft")
    public ResponseEntity<PCMZJDYZWDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmzjdyzwMapping.toDto(pcmzjdyzwService.getDraft(new PCMZJDYZW())));
    }

    @PreAuthorize("hasPermission(this.pcmzjdyzwMapping.toDomain(#pcmzjdyzwdto),'ehr-PCMZJDYZW-Create')")
    @ApiOperation(value = "Create", tags = {"PCMZJDYZW" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzjdyzws")
    @Transactional
    public ResponseEntity<PCMZJDYZWDTO> create(@RequestBody PCMZJDYZWDTO pcmzjdyzwdto) {
        PCMZJDYZW domain = pcmzjdyzwMapping.toDomain(pcmzjdyzwdto);
		pcmzjdyzwService.create(domain);
        PCMZJDYZWDTO dto = pcmzjdyzwMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmzjdyzwMapping.toDomain(#pcmzjdyzwdtos),'ehr-PCMZJDYZW-Create')")
    @ApiOperation(value = "createBatch", tags = {"PCMZJDYZW" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzjdyzws/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMZJDYZWDTO> pcmzjdyzwdtos) {
        pcmzjdyzwService.createBatch(pcmzjdyzwMapping.toDomain(pcmzjdyzwdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmzjdyzwMapping.toDomain(returnObject.body),'ehr-PCMZJDYZW-Get')")
    @ApiOperation(value = "Get", tags = {"PCMZJDYZW" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmzjdyzws/{pcmzjdyzw_id}")
    public ResponseEntity<PCMZJDYZWDTO> get(@PathVariable("pcmzjdyzw_id") String pcmzjdyzw_id) {
        PCMZJDYZW domain = pcmzjdyzwService.get(pcmzjdyzw_id);
        PCMZJDYZWDTO dto = pcmzjdyzwMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmzjdyzwService.get(#pcmzjdyzw_id),'ehr-PCMZJDYZW-Update')")
    @ApiOperation(value = "Update", tags = {"PCMZJDYZW" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmzjdyzws/{pcmzjdyzw_id}")
    @Transactional
    public ResponseEntity<PCMZJDYZWDTO> update(@PathVariable("pcmzjdyzw_id") String pcmzjdyzw_id, @RequestBody PCMZJDYZWDTO pcmzjdyzwdto) {
		PCMZJDYZW domain  = pcmzjdyzwMapping.toDomain(pcmzjdyzwdto);
        domain .setPcmzjdyzwid(pcmzjdyzw_id);
		pcmzjdyzwService.update(domain );
		PCMZJDYZWDTO dto = pcmzjdyzwMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmzjdyzwService.getPcmzjdyzwByEntities(this.pcmzjdyzwMapping.toDomain(#pcmzjdyzwdtos)),'ehr-PCMZJDYZW-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMZJDYZW" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmzjdyzws/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMZJDYZWDTO> pcmzjdyzwdtos) {
        pcmzjdyzwService.updateBatch(pcmzjdyzwMapping.toDomain(pcmzjdyzwdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmzjdyzwService.get(#pcmzjdyzw_id),'ehr-PCMZJDYZW-Remove')")
    @ApiOperation(value = "Remove", tags = {"PCMZJDYZW" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmzjdyzws/{pcmzjdyzw_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmzjdyzw_id") String pcmzjdyzw_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmzjdyzwService.remove(pcmzjdyzw_id));
    }

    @PreAuthorize("hasPermission(this.pcmzjdyzwService.getPcmzjdyzwByIds(#ids),'ehr-PCMZJDYZW-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PCMZJDYZW" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmzjdyzws/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmzjdyzwService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmzjdyzwMapping.toDomain(#pcmzjdyzwdto),'ehr-PCMZJDYZW-Save')")
    @ApiOperation(value = "Save", tags = {"PCMZJDYZW" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzjdyzws/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMZJDYZWDTO pcmzjdyzwdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmzjdyzwService.save(pcmzjdyzwMapping.toDomain(pcmzjdyzwdto)));
    }

    @PreAuthorize("hasPermission(this.pcmzjdyzwMapping.toDomain(#pcmzjdyzwdtos),'ehr-PCMZJDYZW-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PCMZJDYZW" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzjdyzws/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMZJDYZWDTO> pcmzjdyzwdtos) {
        pcmzjdyzwService.saveBatch(pcmzjdyzwMapping.toDomain(pcmzjdyzwdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMZJDYZW-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMZJDYZW" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmzjdyzws/fetchdefault")
	public ResponseEntity<List<PCMZJDYZWDTO>> fetchDefault(PCMZJDYZWSearchContext context) {
        Page<PCMZJDYZW> domains = pcmzjdyzwService.searchDefault(context) ;
        List<PCMZJDYZWDTO> list = pcmzjdyzwMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMZJDYZW-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMZJDYZW" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmzjdyzws/searchdefault")
	public ResponseEntity<Page<PCMZJDYZWDTO>> searchDefault(@RequestBody PCMZJDYZWSearchContext context) {
        Page<PCMZJDYZW> domains = pcmzjdyzwService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmzjdyzwMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

