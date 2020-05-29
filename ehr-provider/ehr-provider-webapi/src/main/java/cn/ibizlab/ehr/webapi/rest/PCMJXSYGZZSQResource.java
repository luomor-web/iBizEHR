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
import cn.ibizlab.ehr.core.pcm.domain.PCMJXSYGZZSQ;
import cn.ibizlab.ehr.core.pcm.service.IPCMJXSYGZZSQService;
import cn.ibizlab.ehr.core.pcm.filter.PCMJXSYGZZSQSearchContext;

@Slf4j
@Api(tags = {"PCMJXSYGZZSQ" })
@RestController("WebApi-pcmjxsygzzsq")
@RequestMapping("")
public class PCMJXSYGZZSQResource {

    @Autowired
    public IPCMJXSYGZZSQService pcmjxsygzzsqService;

    @Autowired
    @Lazy
    public PCMJXSYGZZSQMapping pcmjxsygzzsqMapping;

    @PreAuthorize("hasPermission(this.pcmjxsygzzsqService.get(#pcmjxsygzzsq_id),'ehr-PCMJXSYGZZSQ-Update')")
    @ApiOperation(value = "Update", tags = {"PCMJXSYGZZSQ" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmjxsygzzsqs/{pcmjxsygzzsq_id}")
    @Transactional
    public ResponseEntity<PCMJXSYGZZSQDTO> update(@PathVariable("pcmjxsygzzsq_id") String pcmjxsygzzsq_id, @RequestBody PCMJXSYGZZSQDTO pcmjxsygzzsqdto) {
		PCMJXSYGZZSQ domain  = pcmjxsygzzsqMapping.toDomain(pcmjxsygzzsqdto);
        domain .setPcmjxsygzzsqid(pcmjxsygzzsq_id);
		pcmjxsygzzsqService.update(domain );
		PCMJXSYGZZSQDTO dto = pcmjxsygzzsqMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzsqService.getPcmjxsygzzsqByEntities(this.pcmjxsygzzsqMapping.toDomain(#pcmjxsygzzsqdtos)),'ehr-PCMJXSYGZZSQ-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMJXSYGZZSQ" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmjxsygzzsqs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMJXSYGZZSQDTO> pcmjxsygzzsqdtos) {
        pcmjxsygzzsqService.updateBatch(pcmjxsygzzsqMapping.toDomain(pcmjxsygzzsqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzsqMapping.toDomain(#pcmjxsygzzsqdto),'ehr-PCMJXSYGZZSQ-Save')")
    @ApiOperation(value = "Save", tags = {"PCMJXSYGZZSQ" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzsqs/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMJXSYGZZSQDTO pcmjxsygzzsqdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzsqService.save(pcmjxsygzzsqMapping.toDomain(pcmjxsygzzsqdto)));
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzsqMapping.toDomain(#pcmjxsygzzsqdtos),'ehr-PCMJXSYGZZSQ-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PCMJXSYGZZSQ" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzsqs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMJXSYGZZSQDTO> pcmjxsygzzsqdtos) {
        pcmjxsygzzsqService.saveBatch(pcmjxsygzzsqMapping.toDomain(pcmjxsygzzsqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzsqService.get(#pcmjxsygzzsq_id),'ehr-PCMJXSYGZZSQ-Remove')")
    @ApiOperation(value = "Remove", tags = {"PCMJXSYGZZSQ" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmjxsygzzsqs/{pcmjxsygzzsq_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmjxsygzzsq_id") String pcmjxsygzzsq_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzsqService.remove(pcmjxsygzzsq_id));
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzsqService.getPcmjxsygzzsqByIds(#ids),'ehr-PCMJXSYGZZSQ-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PCMJXSYGZZSQ" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmjxsygzzsqs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmjxsygzzsqService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"PCMJXSYGZZSQ" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzsqs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMJXSYGZZSQDTO pcmjxsygzzsqdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzsqService.checkKey(pcmjxsygzzsqMapping.toDomain(pcmjxsygzzsqdto)));
    }

    @ApiOperation(value = "GetDraft", tags = {"PCMJXSYGZZSQ" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmjxsygzzsqs/getdraft")
    public ResponseEntity<PCMJXSYGZZSQDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzsqMapping.toDto(pcmjxsygzzsqService.getDraft(new PCMJXSYGZZSQ())));
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzsqMapping.toDomain(#pcmjxsygzzsqdto),'ehr-PCMJXSYGZZSQ-Create')")
    @ApiOperation(value = "Create", tags = {"PCMJXSYGZZSQ" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzsqs")
    @Transactional
    public ResponseEntity<PCMJXSYGZZSQDTO> create(@RequestBody PCMJXSYGZZSQDTO pcmjxsygzzsqdto) {
        PCMJXSYGZZSQ domain = pcmjxsygzzsqMapping.toDomain(pcmjxsygzzsqdto);
		pcmjxsygzzsqService.create(domain);
        PCMJXSYGZZSQDTO dto = pcmjxsygzzsqMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzsqMapping.toDomain(#pcmjxsygzzsqdtos),'ehr-PCMJXSYGZZSQ-Create')")
    @ApiOperation(value = "createBatch", tags = {"PCMJXSYGZZSQ" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzsqs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMJXSYGZZSQDTO> pcmjxsygzzsqdtos) {
        pcmjxsygzzsqService.createBatch(pcmjxsygzzsqMapping.toDomain(pcmjxsygzzsqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmjxsygzzsqMapping.toDomain(returnObject.body),'ehr-PCMJXSYGZZSQ-Get')")
    @ApiOperation(value = "Get", tags = {"PCMJXSYGZZSQ" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmjxsygzzsqs/{pcmjxsygzzsq_id}")
    public ResponseEntity<PCMJXSYGZZSQDTO> get(@PathVariable("pcmjxsygzzsq_id") String pcmjxsygzzsq_id) {
        PCMJXSYGZZSQ domain = pcmjxsygzzsqService.get(pcmjxsygzzsq_id);
        PCMJXSYGZZSQDTO dto = pcmjxsygzzsqMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMJXSYGZZSQ-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMJXSYGZZSQ" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmjxsygzzsqs/fetchdefault")
	public ResponseEntity<List<PCMJXSYGZZSQDTO>> fetchDefault(PCMJXSYGZZSQSearchContext context) {
        Page<PCMJXSYGZZSQ> domains = pcmjxsygzzsqService.searchDefault(context) ;
        List<PCMJXSYGZZSQDTO> list = pcmjxsygzzsqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMJXSYGZZSQ-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMJXSYGZZSQ" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmjxsygzzsqs/searchdefault")
	public ResponseEntity<Page<PCMJXSYGZZSQDTO>> searchDefault(@RequestBody PCMJXSYGZZSQSearchContext context) {
        Page<PCMJXSYGZZSQ> domains = pcmjxsygzzsqService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmjxsygzzsqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

