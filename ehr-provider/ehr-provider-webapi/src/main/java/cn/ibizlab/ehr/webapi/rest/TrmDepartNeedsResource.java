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
import cn.ibizlab.ehr.core.trm.domain.TrmDepartNeeds;
import cn.ibizlab.ehr.core.trm.service.ITrmDepartNeedsService;
import cn.ibizlab.ehr.core.trm.filter.TrmDepartNeedsSearchContext;

@Slf4j
@Api(tags = {"TrmDepartNeeds" })
@RestController("WebApi-trmdepartneeds")
@RequestMapping("")
public class TrmDepartNeedsResource {

    @Autowired
    public ITrmDepartNeedsService trmdepartneedsService;

    @Autowired
    @Lazy
    public TrmDepartNeedsMapping trmdepartneedsMapping;

    @PreAuthorize("hasPermission(this.trmdepartneedsService.get(#trmdepartneeds_id),'ehr-TrmDepartNeeds-Update')")
    @ApiOperation(value = "Update", tags = {"TrmDepartNeeds" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmdepartneeds/{trmdepartneeds_id}")
    @Transactional
    public ResponseEntity<TrmDepartNeedsDTO> update(@PathVariable("trmdepartneeds_id") String trmdepartneeds_id, @RequestBody TrmDepartNeedsDTO trmdepartneedsdto) {
		TrmDepartNeeds domain  = trmdepartneedsMapping.toDomain(trmdepartneedsdto);
        domain .setTrmdepartneedsid(trmdepartneeds_id);
		trmdepartneedsService.update(domain );
		TrmDepartNeedsDTO dto = trmdepartneedsMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmdepartneedsService.getTrmdepartneedsByEntities(this.trmdepartneedsMapping.toDomain(#trmdepartneedsdtos)),'ehr-TrmDepartNeeds-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"TrmDepartNeeds" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmdepartneeds/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmDepartNeedsDTO> trmdepartneedsdtos) {
        trmdepartneedsService.updateBatch(trmdepartneedsMapping.toDomain(trmdepartneedsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmdepartneedsMapping.toDomain(returnObject.body),'ehr-TrmDepartNeeds-Get')")
    @ApiOperation(value = "Get", tags = {"TrmDepartNeeds" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmdepartneeds/{trmdepartneeds_id}")
    public ResponseEntity<TrmDepartNeedsDTO> get(@PathVariable("trmdepartneeds_id") String trmdepartneeds_id) {
        TrmDepartNeeds domain = trmdepartneedsService.get(trmdepartneeds_id);
        TrmDepartNeedsDTO dto = trmdepartneedsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmdepartneedsService.get(#trmdepartneeds_id),'ehr-TrmDepartNeeds-Remove')")
    @ApiOperation(value = "Remove", tags = {"TrmDepartNeeds" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmdepartneeds/{trmdepartneeds_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmdepartneeds_id") String trmdepartneeds_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmdepartneedsService.remove(trmdepartneeds_id));
    }

    @PreAuthorize("hasPermission(this.trmdepartneedsService.getTrmdepartneedsByIds(#ids),'ehr-TrmDepartNeeds-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"TrmDepartNeeds" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmdepartneeds/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmdepartneedsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmdepartneedsMapping.toDomain(#trmdepartneedsdto),'ehr-TrmDepartNeeds-Save')")
    @ApiOperation(value = "Save", tags = {"TrmDepartNeeds" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdepartneeds/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmDepartNeedsDTO trmdepartneedsdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmdepartneedsService.save(trmdepartneedsMapping.toDomain(trmdepartneedsdto)));
    }

    @PreAuthorize("hasPermission(this.trmdepartneedsMapping.toDomain(#trmdepartneedsdtos),'ehr-TrmDepartNeeds-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"TrmDepartNeeds" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdepartneeds/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmDepartNeedsDTO> trmdepartneedsdtos) {
        trmdepartneedsService.saveBatch(trmdepartneedsMapping.toDomain(trmdepartneedsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"TrmDepartNeeds" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmdepartneeds/getdraft")
    public ResponseEntity<TrmDepartNeedsDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmdepartneedsMapping.toDto(trmdepartneedsService.getDraft(new TrmDepartNeeds())));
    }

    @ApiOperation(value = "CheckKey", tags = {"TrmDepartNeeds" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdepartneeds/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmDepartNeedsDTO trmdepartneedsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmdepartneedsService.checkKey(trmdepartneedsMapping.toDomain(trmdepartneedsdto)));
    }

    @PreAuthorize("hasPermission(this.trmdepartneedsMapping.toDomain(#trmdepartneedsdto),'ehr-TrmDepartNeeds-Create')")
    @ApiOperation(value = "Create", tags = {"TrmDepartNeeds" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdepartneeds")
    @Transactional
    public ResponseEntity<TrmDepartNeedsDTO> create(@RequestBody TrmDepartNeedsDTO trmdepartneedsdto) {
        TrmDepartNeeds domain = trmdepartneedsMapping.toDomain(trmdepartneedsdto);
		trmdepartneedsService.create(domain);
        TrmDepartNeedsDTO dto = trmdepartneedsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmdepartneedsMapping.toDomain(#trmdepartneedsdtos),'ehr-TrmDepartNeeds-Create')")
    @ApiOperation(value = "createBatch", tags = {"TrmDepartNeeds" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdepartneeds/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmDepartNeedsDTO> trmdepartneedsdtos) {
        trmdepartneedsService.createBatch(trmdepartneedsMapping.toDomain(trmdepartneedsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmDepartNeeds-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TrmDepartNeeds" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmdepartneeds/fetchdefault")
	public ResponseEntity<List<TrmDepartNeedsDTO>> fetchDefault(TrmDepartNeedsSearchContext context) {
        Page<TrmDepartNeeds> domains = trmdepartneedsService.searchDefault(context) ;
        List<TrmDepartNeedsDTO> list = trmdepartneedsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmDepartNeeds-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TrmDepartNeeds" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmdepartneeds/searchdefault")
	public ResponseEntity<Page<TrmDepartNeedsDTO>> searchDefault(@RequestBody TrmDepartNeedsSearchContext context) {
        Page<TrmDepartNeeds> domains = trmdepartneedsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmdepartneedsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

