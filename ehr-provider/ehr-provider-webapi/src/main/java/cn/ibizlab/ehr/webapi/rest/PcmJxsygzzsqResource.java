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
import cn.ibizlab.ehr.core.pcm.domain.PcmJxsygzzsq;
import cn.ibizlab.ehr.core.pcm.service.IPcmJxsygzzsqService;
import cn.ibizlab.ehr.core.pcm.filter.PcmJxsygzzsqSearchContext;

@Slf4j
@Api(tags = {"PcmJxsygzzsq" })
@RestController("WebApi-pcmjxsygzzsq")
@RequestMapping("")
public class PcmJxsygzzsqResource {

    @Autowired
    public IPcmJxsygzzsqService pcmjxsygzzsqService;

    @Autowired
    @Lazy
    public PcmJxsygzzsqMapping pcmjxsygzzsqMapping;

    @PreAuthorize("hasPermission(this.pcmjxsygzzsqService.get(#pcmjxsygzzsq_id),'ehr-PcmJxsygzzsq-Update')")
    @ApiOperation(value = "Update", tags = {"PcmJxsygzzsq" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmjxsygzzsqs/{pcmjxsygzzsq_id}")
    @Transactional
    public ResponseEntity<PcmJxsygzzsqDTO> update(@PathVariable("pcmjxsygzzsq_id") String pcmjxsygzzsq_id, @RequestBody PcmJxsygzzsqDTO pcmjxsygzzsqdto) {
		PcmJxsygzzsq domain  = pcmjxsygzzsqMapping.toDomain(pcmjxsygzzsqdto);
        domain .setPcmjxsygzzsqid(pcmjxsygzzsq_id);
		pcmjxsygzzsqService.update(domain );
		PcmJxsygzzsqDTO dto = pcmjxsygzzsqMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzsqService.getPcmjxsygzzsqByEntities(this.pcmjxsygzzsqMapping.toDomain(#pcmjxsygzzsqdtos)),'ehr-PcmJxsygzzsq-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PcmJxsygzzsq" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmjxsygzzsqs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmJxsygzzsqDTO> pcmjxsygzzsqdtos) {
        pcmjxsygzzsqService.updateBatch(pcmjxsygzzsqMapping.toDomain(pcmjxsygzzsqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzsqMapping.toDomain(#pcmjxsygzzsqdto),'ehr-PcmJxsygzzsq-Save')")
    @ApiOperation(value = "Save", tags = {"PcmJxsygzzsq" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzsqs/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmJxsygzzsqDTO pcmjxsygzzsqdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzsqService.save(pcmjxsygzzsqMapping.toDomain(pcmjxsygzzsqdto)));
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzsqMapping.toDomain(#pcmjxsygzzsqdtos),'ehr-PcmJxsygzzsq-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PcmJxsygzzsq" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzsqs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmJxsygzzsqDTO> pcmjxsygzzsqdtos) {
        pcmjxsygzzsqService.saveBatch(pcmjxsygzzsqMapping.toDomain(pcmjxsygzzsqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzsqService.get(#pcmjxsygzzsq_id),'ehr-PcmJxsygzzsq-Remove')")
    @ApiOperation(value = "Remove", tags = {"PcmJxsygzzsq" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmjxsygzzsqs/{pcmjxsygzzsq_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmjxsygzzsq_id") String pcmjxsygzzsq_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzsqService.remove(pcmjxsygzzsq_id));
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzsqService.getPcmjxsygzzsqByIds(#ids),'ehr-PcmJxsygzzsq-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PcmJxsygzzsq" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmjxsygzzsqs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmjxsygzzsqService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"PcmJxsygzzsq" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzsqs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmJxsygzzsqDTO pcmjxsygzzsqdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzsqService.checkKey(pcmjxsygzzsqMapping.toDomain(pcmjxsygzzsqdto)));
    }

    @ApiOperation(value = "GetDraft", tags = {"PcmJxsygzzsq" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmjxsygzzsqs/getdraft")
    public ResponseEntity<PcmJxsygzzsqDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzsqMapping.toDto(pcmjxsygzzsqService.getDraft(new PcmJxsygzzsq())));
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzsqMapping.toDomain(#pcmjxsygzzsqdto),'ehr-PcmJxsygzzsq-Create')")
    @ApiOperation(value = "Create", tags = {"PcmJxsygzzsq" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzsqs")
    @Transactional
    public ResponseEntity<PcmJxsygzzsqDTO> create(@RequestBody PcmJxsygzzsqDTO pcmjxsygzzsqdto) {
        PcmJxsygzzsq domain = pcmjxsygzzsqMapping.toDomain(pcmjxsygzzsqdto);
		pcmjxsygzzsqService.create(domain);
        PcmJxsygzzsqDTO dto = pcmjxsygzzsqMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmjxsygzzsqMapping.toDomain(#pcmjxsygzzsqdtos),'ehr-PcmJxsygzzsq-Create')")
    @ApiOperation(value = "createBatch", tags = {"PcmJxsygzzsq" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzsqs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmJxsygzzsqDTO> pcmjxsygzzsqdtos) {
        pcmjxsygzzsqService.createBatch(pcmjxsygzzsqMapping.toDomain(pcmjxsygzzsqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmjxsygzzsqMapping.toDomain(returnObject.body),'ehr-PcmJxsygzzsq-Get')")
    @ApiOperation(value = "Get", tags = {"PcmJxsygzzsq" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmjxsygzzsqs/{pcmjxsygzzsq_id}")
    public ResponseEntity<PcmJxsygzzsqDTO> get(@PathVariable("pcmjxsygzzsq_id") String pcmjxsygzzsq_id) {
        PcmJxsygzzsq domain = pcmjxsygzzsqService.get(pcmjxsygzzsq_id);
        PcmJxsygzzsqDTO dto = pcmjxsygzzsqMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzsq-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PcmJxsygzzsq" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmjxsygzzsqs/fetchdefault")
	public ResponseEntity<List<PcmJxsygzzsqDTO>> fetchDefault(PcmJxsygzzsqSearchContext context) {
        Page<PcmJxsygzzsq> domains = pcmjxsygzzsqService.searchDefault(context) ;
        List<PcmJxsygzzsqDTO> list = pcmjxsygzzsqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsygzzsq-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PcmJxsygzzsq" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmjxsygzzsqs/searchdefault")
	public ResponseEntity<Page<PcmJxsygzzsqDTO>> searchDefault(@RequestBody PcmJxsygzzsqSearchContext context) {
        Page<PcmJxsygzzsq> domains = pcmjxsygzzsqService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmjxsygzzsqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

