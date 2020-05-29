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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainActapply;
import cn.ibizlab.ehr.core.trm.service.ITrmTrainActapplyService;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainActapplySearchContext;

@Slf4j
@Api(tags = {"TrmTrainActapply" })
@RestController("WebApi-trmtrainactapply")
@RequestMapping("")
public class TrmTrainActapplyResource {

    @Autowired
    public ITrmTrainActapplyService trmtrainactapplyService;

    @Autowired
    @Lazy
    public TrmTrainActapplyMapping trmtrainactapplyMapping;

    @ApiOperation(value = "GetDraft", tags = {"TrmTrainActapply" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainactapplies/getdraft")
    public ResponseEntity<TrmTrainActapplyDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainactapplyMapping.toDto(trmtrainactapplyService.getDraft(new TrmTrainActapply())));
    }

    @ApiOperation(value = "CheckKey", tags = {"TrmTrainActapply" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainactapplies/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmTrainActapplyDTO trmtrainactapplydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainactapplyService.checkKey(trmtrainactapplyMapping.toDomain(trmtrainactapplydto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainactapplyMapping.toDomain(#trmtrainactapplydto),'ehr-TrmTrainActapply-Create')")
    @ApiOperation(value = "Create", tags = {"TrmTrainActapply" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainactapplies")
    @Transactional
    public ResponseEntity<TrmTrainActapplyDTO> create(@RequestBody TrmTrainActapplyDTO trmtrainactapplydto) {
        TrmTrainActapply domain = trmtrainactapplyMapping.toDomain(trmtrainactapplydto);
		trmtrainactapplyService.create(domain);
        TrmTrainActapplyDTO dto = trmtrainactapplyMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainactapplyMapping.toDomain(#trmtrainactapplydtos),'ehr-TrmTrainActapply-Create')")
    @ApiOperation(value = "createBatch", tags = {"TrmTrainActapply" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainactapplies/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmTrainActapplyDTO> trmtrainactapplydtos) {
        trmtrainactapplyService.createBatch(trmtrainactapplyMapping.toDomain(trmtrainactapplydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmtrainactapplyMapping.toDomain(returnObject.body),'ehr-TrmTrainActapply-Get')")
    @ApiOperation(value = "Get", tags = {"TrmTrainActapply" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainactapplies/{trmtrainactapply_id}")
    public ResponseEntity<TrmTrainActapplyDTO> get(@PathVariable("trmtrainactapply_id") String trmtrainactapply_id) {
        TrmTrainActapply domain = trmtrainactapplyService.get(trmtrainactapply_id);
        TrmTrainActapplyDTO dto = trmtrainactapplyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainactapplyMapping.toDomain(#trmtrainactapplydto),'ehr-TrmTrainActapply-Save')")
    @ApiOperation(value = "Save", tags = {"TrmTrainActapply" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainactapplies/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmTrainActapplyDTO trmtrainactapplydto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainactapplyService.save(trmtrainactapplyMapping.toDomain(trmtrainactapplydto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainactapplyMapping.toDomain(#trmtrainactapplydtos),'ehr-TrmTrainActapply-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"TrmTrainActapply" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainactapplies/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmTrainActapplyDTO> trmtrainactapplydtos) {
        trmtrainactapplyService.saveBatch(trmtrainactapplyMapping.toDomain(trmtrainactapplydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainactapplyService.get(#trmtrainactapply_id),'ehr-TrmTrainActapply-Update')")
    @ApiOperation(value = "Update", tags = {"TrmTrainActapply" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainactapplies/{trmtrainactapply_id}")
    @Transactional
    public ResponseEntity<TrmTrainActapplyDTO> update(@PathVariable("trmtrainactapply_id") String trmtrainactapply_id, @RequestBody TrmTrainActapplyDTO trmtrainactapplydto) {
		TrmTrainActapply domain  = trmtrainactapplyMapping.toDomain(trmtrainactapplydto);
        domain .setTrmtrainactapplyid(trmtrainactapply_id);
		trmtrainactapplyService.update(domain );
		TrmTrainActapplyDTO dto = trmtrainactapplyMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainactapplyService.getTrmtrainactapplyByEntities(this.trmtrainactapplyMapping.toDomain(#trmtrainactapplydtos)),'ehr-TrmTrainActapply-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"TrmTrainActapply" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainactapplies/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmTrainActapplyDTO> trmtrainactapplydtos) {
        trmtrainactapplyService.updateBatch(trmtrainactapplyMapping.toDomain(trmtrainactapplydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainactapplyService.get(#trmtrainactapply_id),'ehr-TrmTrainActapply-Remove')")
    @ApiOperation(value = "Remove", tags = {"TrmTrainActapply" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainactapplies/{trmtrainactapply_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtrainactapply_id") String trmtrainactapply_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtrainactapplyService.remove(trmtrainactapply_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainactapplyService.getTrmtrainactapplyByIds(#ids),'ehr-TrmTrainActapply-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"TrmTrainActapply" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainactapplies/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtrainactapplyService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainActapply-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TrmTrainActapply" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainactapplies/fetchdefault")
	public ResponseEntity<List<TrmTrainActapplyDTO>> fetchDefault(TrmTrainActapplySearchContext context) {
        Page<TrmTrainActapply> domains = trmtrainactapplyService.searchDefault(context) ;
        List<TrmTrainActapplyDTO> list = trmtrainactapplyMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainActapply-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TrmTrainActapply" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainactapplies/searchdefault")
	public ResponseEntity<Page<TrmTrainActapplyDTO>> searchDefault(@RequestBody TrmTrainActapplySearchContext context) {
        Page<TrmTrainActapply> domains = trmtrainactapplyService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainactapplyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

