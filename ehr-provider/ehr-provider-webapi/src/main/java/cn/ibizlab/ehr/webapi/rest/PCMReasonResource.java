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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import cn.ibizlab.ehr.webapi.dto.*;
import cn.ibizlab.ehr.webapi.mapping.*;
import cn.ibizlab.ehr.core.pcm.domain.PCMReason;
import cn.ibizlab.ehr.core.pcm.service.IPCMReasonService;
import cn.ibizlab.ehr.core.pcm.filter.PCMReasonSearchContext;

@Slf4j
@Api(tags = {"PCMReason" })
@RestController("WebApi-pcmreason")
@RequestMapping("")
public class PCMReasonResource {

    @Autowired
    private IPCMReasonService pcmreasonService;

    @Autowired
    @Lazy
    public PCMReasonMapping pcmreasonMapping;

    public PCMReasonDTO permissionDTO=new PCMReasonDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMReason-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PCMReason" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmreasons/getdraft")
    public ResponseEntity<PCMReasonDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmreasonMapping.toDto(pcmreasonService.getDraft(new PCMReason())));
    }

    @PreAuthorize("hasPermission(#pcmreason_id,'Remove',{'Sql',this.pcmreasonMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PCMReason" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmreasons/{pcmreason_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmreason_id") String pcmreason_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmreasonService.remove(pcmreason_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.pcmreasonMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PCMReason" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmreasons/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmreasonService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pcmreason_id,'Update',{'Sql',this.pcmreasonMapping,#pcmreasondto})")
    @ApiOperation(value = "Update", tags = {"PCMReason" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmreasons/{pcmreason_id}")
    @Transactional
    public ResponseEntity<PCMReasonDTO> update(@PathVariable("pcmreason_id") String pcmreason_id, @RequestBody PCMReasonDTO pcmreasondto) {
		PCMReason domain  = pcmreasonMapping.toDomain(pcmreasondto);
        domain .setPcmreasonid(pcmreason_id);
		pcmreasonService.update(domain );
		PCMReasonDTO dto = pcmreasonMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.pcmreasonMapping,#pcmreasondtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMReason" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmreasons/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMReasonDTO> pcmreasondtos) {
        pcmreasonService.updateBatch(pcmreasonMapping.toDomain(pcmreasondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pcmreason_id,'Get',{'Sql',this.pcmreasonMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PCMReason" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmreasons/{pcmreason_id}")
    public ResponseEntity<PCMReasonDTO> get(@PathVariable("pcmreason_id") String pcmreason_id) {
        PCMReason domain = pcmreasonService.get(pcmreason_id);
        PCMReasonDTO dto = pcmreasonMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pcmreasonMapping,#pcmreasondto})")
    @ApiOperation(value = "Create", tags = {"PCMReason" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmreasons")
    @Transactional
    public ResponseEntity<PCMReasonDTO> create(@RequestBody PCMReasonDTO pcmreasondto) {
        PCMReason domain = pcmreasonMapping.toDomain(pcmreasondto);
		pcmreasonService.create(domain);
        PCMReasonDTO dto = pcmreasonMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.pcmreasonMapping,#pcmreasondtos})")
    @ApiOperation(value = "createBatch", tags = {"PCMReason" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmreasons/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMReasonDTO> pcmreasondtos) {
        pcmreasonService.createBatch(pcmreasonMapping.toDomain(pcmreasondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMReason-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PCMReason" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmreasons/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMReasonDTO pcmreasondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmreasonService.checkKey(pcmreasonMapping.toDomain(pcmreasondto)));
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.pcmreasonMapping,#pcmreasondto})")
    @ApiOperation(value = "Save", tags = {"PCMReason" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmreasons/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMReasonDTO pcmreasondto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmreasonService.save(pcmreasonMapping.toDomain(pcmreasondto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.pcmreasonMapping,#pcmreasondtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PCMReason" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmreasons/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMReasonDTO> pcmreasondtos) {
        pcmreasonService.saveBatch(pcmreasonMapping.toDomain(pcmreasondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMReason-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMReason" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmreasons/fetchdefault")
	public ResponseEntity<List<PCMReasonDTO>> fetchDefault(PCMReasonSearchContext context) {
        Page<PCMReason> domains = pcmreasonService.searchDefault(context) ;
        List<PCMReasonDTO> list = pcmreasonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMReason-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMReason" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmreasons/searchdefault")
	public ResponseEntity<Page<PCMReasonDTO>> searchDefault(@RequestBody PCMReasonSearchContext context) {
        Page<PCMReason> domains = pcmreasonService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmreasonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
