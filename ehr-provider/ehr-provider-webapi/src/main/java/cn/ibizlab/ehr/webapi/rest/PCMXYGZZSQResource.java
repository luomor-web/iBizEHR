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
import cn.ibizlab.ehr.core.pcm.domain.PCMXYGZZSQ;
import cn.ibizlab.ehr.core.pcm.service.IPCMXYGZZSQService;
import cn.ibizlab.ehr.core.pcm.filter.PCMXYGZZSQSearchContext;

@Slf4j
@Api(tags = {"PCMXYGZZSQ" })
@RestController("WebApi-pcmxygzzsq")
@RequestMapping("")
public class PCMXYGZZSQResource {

    @Autowired
    private IPCMXYGZZSQService pcmxygzzsqService;

    @Autowired
    @Lazy
    public PCMXYGZZSQMapping pcmxygzzsqMapping;

    public PCMXYGZZSQDTO permissionDTO=new PCMXYGZZSQDTO();

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pcmxygzzsqMapping,#pcmxygzzsqdto})")
    @ApiOperation(value = "Create", tags = {"PCMXYGZZSQ" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzsqs")
    @Transactional
    public ResponseEntity<PCMXYGZZSQDTO> create(@RequestBody PCMXYGZZSQDTO pcmxygzzsqdto) {
        PCMXYGZZSQ domain = pcmxygzzsqMapping.toDomain(pcmxygzzsqdto);
		pcmxygzzsqService.create(domain);
        PCMXYGZZSQDTO dto = pcmxygzzsqMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.pcmxygzzsqMapping,#pcmxygzzsqdtos})")
    @ApiOperation(value = "createBatch", tags = {"PCMXYGZZSQ" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzsqs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMXYGZZSQDTO> pcmxygzzsqdtos) {
        pcmxygzzsqService.createBatch(pcmxygzzsqMapping.toDomain(pcmxygzzsqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pcmxygzzsq_id,'Get',{'Sql',this.pcmxygzzsqMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PCMXYGZZSQ" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmxygzzsqs/{pcmxygzzsq_id}")
    public ResponseEntity<PCMXYGZZSQDTO> get(@PathVariable("pcmxygzzsq_id") String pcmxygzzsq_id) {
        PCMXYGZZSQ domain = pcmxygzzsqService.get(pcmxygzzsq_id);
        PCMXYGZZSQDTO dto = pcmxygzzsqMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.pcmxygzzsqMapping,#pcmxygzzsqdto})")
    @ApiOperation(value = "Save", tags = {"PCMXYGZZSQ" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzsqs/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMXYGZZSQDTO pcmxygzzsqdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzsqService.save(pcmxygzzsqMapping.toDomain(pcmxygzzsqdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.pcmxygzzsqMapping,#pcmxygzzsqdtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PCMXYGZZSQ" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzsqs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMXYGZZSQDTO> pcmxygzzsqdtos) {
        pcmxygzzsqService.saveBatch(pcmxygzzsqMapping.toDomain(pcmxygzzsqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pcmxygzzsq_id,'Remove',{'Sql',this.pcmxygzzsqMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PCMXYGZZSQ" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmxygzzsqs/{pcmxygzzsq_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmxygzzsq_id") String pcmxygzzsq_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzsqService.remove(pcmxygzzsq_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.pcmxygzzsqMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PCMXYGZZSQ" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmxygzzsqs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmxygzzsqService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMXYGZZSQ-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PCMXYGZZSQ" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzsqs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMXYGZZSQDTO pcmxygzzsqdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmxygzzsqService.checkKey(pcmxygzzsqMapping.toDomain(pcmxygzzsqdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMXYGZZSQ-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PCMXYGZZSQ" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmxygzzsqs/getdraft")
    public ResponseEntity<PCMXYGZZSQDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzsqMapping.toDto(pcmxygzzsqService.getDraft(new PCMXYGZZSQ())));
    }

    @PreAuthorize("hasPermission(#pcmxygzzsq_id,'Update',{'Sql',this.pcmxygzzsqMapping,#pcmxygzzsqdto})")
    @ApiOperation(value = "Update", tags = {"PCMXYGZZSQ" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmxygzzsqs/{pcmxygzzsq_id}")
    @Transactional
    public ResponseEntity<PCMXYGZZSQDTO> update(@PathVariable("pcmxygzzsq_id") String pcmxygzzsq_id, @RequestBody PCMXYGZZSQDTO pcmxygzzsqdto) {
		PCMXYGZZSQ domain  = pcmxygzzsqMapping.toDomain(pcmxygzzsqdto);
        domain .setPcmxygzzsqid(pcmxygzzsq_id);
		pcmxygzzsqService.update(domain );
		PCMXYGZZSQDTO dto = pcmxygzzsqMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.pcmxygzzsqMapping,#pcmxygzzsqdtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMXYGZZSQ" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmxygzzsqs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMXYGZZSQDTO> pcmxygzzsqdtos) {
        pcmxygzzsqService.updateBatch(pcmxygzzsqMapping.toDomain(pcmxygzzsqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMXYGZZSQ-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMXYGZZSQ" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmxygzzsqs/fetchdefault")
	public ResponseEntity<List<PCMXYGZZSQDTO>> fetchDefault(PCMXYGZZSQSearchContext context) {
        Page<PCMXYGZZSQ> domains = pcmxygzzsqService.searchDefault(context) ;
        List<PCMXYGZZSQDTO> list = pcmxygzzsqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMXYGZZSQ-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMXYGZZSQ" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmxygzzsqs/searchdefault")
	public ResponseEntity<Page<PCMXYGZZSQDTO>> searchDefault(@RequestBody PCMXYGZZSQSearchContext context) {
        Page<PCMXYGZZSQ> domains = pcmxygzzsqService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmxygzzsqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
