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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainBuapply;
import cn.ibizlab.ehr.core.trm.service.ITrmTrainBuapplyService;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainBuapplySearchContext;

@Slf4j
@Api(tags = {"TrmTrainBuapply" })
@RestController("WebApi-trmtrainbuapply")
@RequestMapping("")
public class TrmTrainBuapplyResource {

    @Autowired
    public ITrmTrainBuapplyService trmtrainbuapplyService;

    @Autowired
    @Lazy
    public TrmTrainBuapplyMapping trmtrainbuapplyMapping;

    @PreAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydto),'ehr-TrmTrainBuapply-Create')")
    @ApiOperation(value = "Create", tags = {"TrmTrainBuapply" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainbuapplies")
    @Transactional
    public ResponseEntity<TrmTrainBuapplyDTO> create(@RequestBody TrmTrainBuapplyDTO trmtrainbuapplydto) {
        TrmTrainBuapply domain = trmtrainbuapplyMapping.toDomain(trmtrainbuapplydto);
		trmtrainbuapplyService.create(domain);
        TrmTrainBuapplyDTO dto = trmtrainbuapplyMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydtos),'ehr-TrmTrainBuapply-Create')")
    @ApiOperation(value = "createBatch", tags = {"TrmTrainBuapply" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainbuapplies/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmTrainBuapplyDTO> trmtrainbuapplydtos) {
        trmtrainbuapplyService.createBatch(trmtrainbuapplyMapping.toDomain(trmtrainbuapplydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyService.get(#trmtrainbuapply_id),'ehr-TrmTrainBuapply-Update')")
    @ApiOperation(value = "Update", tags = {"TrmTrainBuapply" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainbuapplies/{trmtrainbuapply_id}")
    @Transactional
    public ResponseEntity<TrmTrainBuapplyDTO> update(@PathVariable("trmtrainbuapply_id") String trmtrainbuapply_id, @RequestBody TrmTrainBuapplyDTO trmtrainbuapplydto) {
		TrmTrainBuapply domain  = trmtrainbuapplyMapping.toDomain(trmtrainbuapplydto);
        domain .setTrmtrainbuapplyid(trmtrainbuapply_id);
		trmtrainbuapplyService.update(domain );
		TrmTrainBuapplyDTO dto = trmtrainbuapplyMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyService.getTrmtrainbuapplyByEntities(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydtos)),'ehr-TrmTrainBuapply-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"TrmTrainBuapply" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainbuapplies/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmTrainBuapplyDTO> trmtrainbuapplydtos) {
        trmtrainbuapplyService.updateBatch(trmtrainbuapplyMapping.toDomain(trmtrainbuapplydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"TrmTrainBuapply" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainbuapplies/getdraft")
    public ResponseEntity<TrmTrainBuapplyDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainbuapplyMapping.toDto(trmtrainbuapplyService.getDraft(new TrmTrainBuapply())));
    }

    @PostAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(returnObject.body),'ehr-TrmTrainBuapply-Get')")
    @ApiOperation(value = "Get", tags = {"TrmTrainBuapply" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainbuapplies/{trmtrainbuapply_id}")
    public ResponseEntity<TrmTrainBuapplyDTO> get(@PathVariable("trmtrainbuapply_id") String trmtrainbuapply_id) {
        TrmTrainBuapply domain = trmtrainbuapplyService.get(trmtrainbuapply_id);
        TrmTrainBuapplyDTO dto = trmtrainbuapplyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKey", tags = {"TrmTrainBuapply" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainbuapplies/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmTrainBuapplyDTO trmtrainbuapplydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainbuapplyService.checkKey(trmtrainbuapplyMapping.toDomain(trmtrainbuapplydto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyService.get(#trmtrainbuapply_id),'ehr-TrmTrainBuapply-Remove')")
    @ApiOperation(value = "Remove", tags = {"TrmTrainBuapply" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainbuapplies/{trmtrainbuapply_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtrainbuapply_id") String trmtrainbuapply_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtrainbuapplyService.remove(trmtrainbuapply_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyService.getTrmtrainbuapplyByIds(#ids),'ehr-TrmTrainBuapply-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"TrmTrainBuapply" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainbuapplies/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtrainbuapplyService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydto),'ehr-TrmTrainBuapply-Save')")
    @ApiOperation(value = "Save", tags = {"TrmTrainBuapply" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainbuapplies/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmTrainBuapplyDTO trmtrainbuapplydto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainbuapplyService.save(trmtrainbuapplyMapping.toDomain(trmtrainbuapplydto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainbuapplyMapping.toDomain(#trmtrainbuapplydtos),'ehr-TrmTrainBuapply-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"TrmTrainBuapply" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainbuapplies/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmTrainBuapplyDTO> trmtrainbuapplydtos) {
        trmtrainbuapplyService.saveBatch(trmtrainbuapplyMapping.toDomain(trmtrainbuapplydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainBuapply-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TrmTrainBuapply" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainbuapplies/fetchdefault")
	public ResponseEntity<List<TrmTrainBuapplyDTO>> fetchDefault(TrmTrainBuapplySearchContext context) {
        Page<TrmTrainBuapply> domains = trmtrainbuapplyService.searchDefault(context) ;
        List<TrmTrainBuapplyDTO> list = trmtrainbuapplyMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainBuapply-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TrmTrainBuapply" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainbuapplies/searchdefault")
	public ResponseEntity<Page<TrmTrainBuapplyDTO>> searchDefault(@RequestBody TrmTrainBuapplySearchContext context) {
        Page<TrmTrainBuapply> domains = trmtrainbuapplyService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainbuapplyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

