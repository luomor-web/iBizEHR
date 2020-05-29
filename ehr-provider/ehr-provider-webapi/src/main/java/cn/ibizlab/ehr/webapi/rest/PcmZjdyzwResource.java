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
import cn.ibizlab.ehr.core.pcm.domain.PcmZjdyzw;
import cn.ibizlab.ehr.core.pcm.service.IPcmZjdyzwService;
import cn.ibizlab.ehr.core.pcm.filter.PcmZjdyzwSearchContext;

@Slf4j
@Api(tags = {"PcmZjdyzw" })
@RestController("WebApi-pcmzjdyzw")
@RequestMapping("")
public class PcmZjdyzwResource {

    @Autowired
    public IPcmZjdyzwService pcmzjdyzwService;

    @Autowired
    @Lazy
    public PcmZjdyzwMapping pcmzjdyzwMapping;

    @ApiOperation(value = "CheckKey", tags = {"PcmZjdyzw" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzjdyzws/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmZjdyzwDTO pcmzjdyzwdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmzjdyzwService.checkKey(pcmzjdyzwMapping.toDomain(pcmzjdyzwdto)));
    }

    @ApiOperation(value = "GetDraft", tags = {"PcmZjdyzw" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmzjdyzws/getdraft")
    public ResponseEntity<PcmZjdyzwDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmzjdyzwMapping.toDto(pcmzjdyzwService.getDraft(new PcmZjdyzw())));
    }

    @PreAuthorize("hasPermission(this.pcmzjdyzwMapping.toDomain(#pcmzjdyzwdto),'ehr-PcmZjdyzw-Create')")
    @ApiOperation(value = "Create", tags = {"PcmZjdyzw" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzjdyzws")
    @Transactional
    public ResponseEntity<PcmZjdyzwDTO> create(@RequestBody PcmZjdyzwDTO pcmzjdyzwdto) {
        PcmZjdyzw domain = pcmzjdyzwMapping.toDomain(pcmzjdyzwdto);
		pcmzjdyzwService.create(domain);
        PcmZjdyzwDTO dto = pcmzjdyzwMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmzjdyzwMapping.toDomain(#pcmzjdyzwdtos),'ehr-PcmZjdyzw-Create')")
    @ApiOperation(value = "createBatch", tags = {"PcmZjdyzw" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzjdyzws/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmZjdyzwDTO> pcmzjdyzwdtos) {
        pcmzjdyzwService.createBatch(pcmzjdyzwMapping.toDomain(pcmzjdyzwdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmzjdyzwMapping.toDomain(returnObject.body),'ehr-PcmZjdyzw-Get')")
    @ApiOperation(value = "Get", tags = {"PcmZjdyzw" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmzjdyzws/{pcmzjdyzw_id}")
    public ResponseEntity<PcmZjdyzwDTO> get(@PathVariable("pcmzjdyzw_id") String pcmzjdyzw_id) {
        PcmZjdyzw domain = pcmzjdyzwService.get(pcmzjdyzw_id);
        PcmZjdyzwDTO dto = pcmzjdyzwMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmzjdyzwService.get(#pcmzjdyzw_id),'ehr-PcmZjdyzw-Update')")
    @ApiOperation(value = "Update", tags = {"PcmZjdyzw" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmzjdyzws/{pcmzjdyzw_id}")
    @Transactional
    public ResponseEntity<PcmZjdyzwDTO> update(@PathVariable("pcmzjdyzw_id") String pcmzjdyzw_id, @RequestBody PcmZjdyzwDTO pcmzjdyzwdto) {
		PcmZjdyzw domain  = pcmzjdyzwMapping.toDomain(pcmzjdyzwdto);
        domain .setPcmzjdyzwid(pcmzjdyzw_id);
		pcmzjdyzwService.update(domain );
		PcmZjdyzwDTO dto = pcmzjdyzwMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmzjdyzwService.getPcmzjdyzwByEntities(this.pcmzjdyzwMapping.toDomain(#pcmzjdyzwdtos)),'ehr-PcmZjdyzw-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PcmZjdyzw" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmzjdyzws/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmZjdyzwDTO> pcmzjdyzwdtos) {
        pcmzjdyzwService.updateBatch(pcmzjdyzwMapping.toDomain(pcmzjdyzwdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmzjdyzwService.get(#pcmzjdyzw_id),'ehr-PcmZjdyzw-Remove')")
    @ApiOperation(value = "Remove", tags = {"PcmZjdyzw" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmzjdyzws/{pcmzjdyzw_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmzjdyzw_id") String pcmzjdyzw_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmzjdyzwService.remove(pcmzjdyzw_id));
    }

    @PreAuthorize("hasPermission(this.pcmzjdyzwService.getPcmzjdyzwByIds(#ids),'ehr-PcmZjdyzw-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PcmZjdyzw" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmzjdyzws/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmzjdyzwService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmzjdyzwMapping.toDomain(#pcmzjdyzwdto),'ehr-PcmZjdyzw-Save')")
    @ApiOperation(value = "Save", tags = {"PcmZjdyzw" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzjdyzws/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmZjdyzwDTO pcmzjdyzwdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmzjdyzwService.save(pcmzjdyzwMapping.toDomain(pcmzjdyzwdto)));
    }

    @PreAuthorize("hasPermission(this.pcmzjdyzwMapping.toDomain(#pcmzjdyzwdtos),'ehr-PcmZjdyzw-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PcmZjdyzw" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzjdyzws/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmZjdyzwDTO> pcmzjdyzwdtos) {
        pcmzjdyzwService.saveBatch(pcmzjdyzwMapping.toDomain(pcmzjdyzwdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmZjdyzw-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PcmZjdyzw" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmzjdyzws/fetchdefault")
	public ResponseEntity<List<PcmZjdyzwDTO>> fetchDefault(PcmZjdyzwSearchContext context) {
        Page<PcmZjdyzw> domains = pcmzjdyzwService.searchDefault(context) ;
        List<PcmZjdyzwDTO> list = pcmzjdyzwMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmZjdyzw-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PcmZjdyzw" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmzjdyzws/searchdefault")
	public ResponseEntity<Page<PcmZjdyzwDTO>> searchDefault(@RequestBody PcmZjdyzwSearchContext context) {
        Page<PcmZjdyzw> domains = pcmzjdyzwService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmzjdyzwMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

