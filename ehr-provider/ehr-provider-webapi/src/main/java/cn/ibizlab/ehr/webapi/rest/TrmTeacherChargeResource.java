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
import cn.ibizlab.ehr.core.trm.domain.TrmTeacherCharge;
import cn.ibizlab.ehr.core.trm.service.ITrmTeacherChargeService;
import cn.ibizlab.ehr.core.trm.filter.TrmTeacherChargeSearchContext;

@Slf4j
@Api(tags = {"TrmTeacherCharge" })
@RestController("WebApi-trmteachercharge")
@RequestMapping("")
public class TrmTeacherChargeResource {

    @Autowired
    public ITrmTeacherChargeService trmteacherchargeService;

    @Autowired
    @Lazy
    public TrmTeacherChargeMapping trmteacherchargeMapping;

    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedto),'ehr-TrmTeacherCharge-Save')")
    @ApiOperation(value = "Save", tags = {"TrmTeacherCharge" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmteachercharges/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeService.save(trmteacherchargeMapping.toDomain(trmteacherchargedto)));
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedtos),'ehr-TrmTeacherCharge-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"TrmTeacherCharge" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmteachercharges/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmTeacherChargeDTO> trmteacherchargedtos) {
        trmteacherchargeService.saveBatch(trmteacherchargeMapping.toDomain(trmteacherchargedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(returnObject.body),'ehr-TrmTeacherCharge-Get')")
    @ApiOperation(value = "Get", tags = {"TrmTeacherCharge" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmteachercharges/{trmteachercharge_id}")
    public ResponseEntity<TrmTeacherChargeDTO> get(@PathVariable("trmteachercharge_id") String trmteachercharge_id) {
        TrmTeacherCharge domain = trmteacherchargeService.get(trmteachercharge_id);
        TrmTeacherChargeDTO dto = trmteacherchargeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.get(#trmteachercharge_id),'ehr-TrmTeacherCharge-Remove')")
    @ApiOperation(value = "Remove", tags = {"TrmTeacherCharge" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmteachercharges/{trmteachercharge_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmteachercharge_id") String trmteachercharge_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeService.remove(trmteachercharge_id));
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.getTrmteacherchargeByIds(#ids),'ehr-TrmTeacherCharge-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"TrmTeacherCharge" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmteachercharges/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmteacherchargeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.get(#trmteachercharge_id),'ehr-TrmTeacherCharge-Update')")
    @ApiOperation(value = "Update", tags = {"TrmTeacherCharge" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmteachercharges/{trmteachercharge_id}")
    @Transactional
    public ResponseEntity<TrmTeacherChargeDTO> update(@PathVariable("trmteachercharge_id") String trmteachercharge_id, @RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
		TrmTeacherCharge domain  = trmteacherchargeMapping.toDomain(trmteacherchargedto);
        domain .setTrmteacherchargeid(trmteachercharge_id);
		trmteacherchargeService.update(domain );
		TrmTeacherChargeDTO dto = trmteacherchargeMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.getTrmteacherchargeByEntities(this.trmteacherchargeMapping.toDomain(#trmteacherchargedtos)),'ehr-TrmTeacherCharge-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"TrmTeacherCharge" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmteachercharges/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmTeacherChargeDTO> trmteacherchargedtos) {
        trmteacherchargeService.updateBatch(trmteacherchargeMapping.toDomain(trmteacherchargedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedto),'ehr-TrmTeacherCharge-Create')")
    @ApiOperation(value = "Create", tags = {"TrmTeacherCharge" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmteachercharges")
    @Transactional
    public ResponseEntity<TrmTeacherChargeDTO> create(@RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
        TrmTeacherCharge domain = trmteacherchargeMapping.toDomain(trmteacherchargedto);
		trmteacherchargeService.create(domain);
        TrmTeacherChargeDTO dto = trmteacherchargeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedtos),'ehr-TrmTeacherCharge-Create')")
    @ApiOperation(value = "createBatch", tags = {"TrmTeacherCharge" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmteachercharges/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmTeacherChargeDTO> trmteacherchargedtos) {
        trmteacherchargeService.createBatch(trmteacherchargeMapping.toDomain(trmteacherchargedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"TrmTeacherCharge" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmteachercharges/getdraft")
    public ResponseEntity<TrmTeacherChargeDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeMapping.toDto(trmteacherchargeService.getDraft(new TrmTeacherCharge())));
    }

    @ApiOperation(value = "CheckKey", tags = {"TrmTeacherCharge" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmteachercharges/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeService.checkKey(trmteacherchargeMapping.toDomain(trmteacherchargedto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTeacherCharge-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TrmTeacherCharge" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmteachercharges/fetchdefault")
	public ResponseEntity<List<TrmTeacherChargeDTO>> fetchDefault(TrmTeacherChargeSearchContext context) {
        Page<TrmTeacherCharge> domains = trmteacherchargeService.searchDefault(context) ;
        List<TrmTeacherChargeDTO> list = trmteacherchargeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTeacherCharge-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TrmTeacherCharge" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmteachercharges/searchdefault")
	public ResponseEntity<Page<TrmTeacherChargeDTO>> searchDefault(@RequestBody TrmTeacherChargeSearchContext context) {
        Page<TrmTeacherCharge> domains = trmteacherchargeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmteacherchargeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

