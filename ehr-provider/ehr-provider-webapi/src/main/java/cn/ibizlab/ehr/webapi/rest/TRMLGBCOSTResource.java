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
import cn.ibizlab.ehr.core.trm.domain.TRMLGBCOST;
import cn.ibizlab.ehr.core.trm.service.ITRMLGBCOSTService;
import cn.ibizlab.ehr.core.trm.filter.TRMLGBCOSTSearchContext;

@Slf4j
@Api(tags = {"TRMLGBCOST" })
@RestController("WebApi-trmlgbcost")
@RequestMapping("")
public class TRMLGBCOSTResource {

    @Autowired
    public ITRMLGBCOSTService trmlgbcostService;

    @Autowired
    @Lazy
    public TRMLGBCOSTMapping trmlgbcostMapping;

    @PostAuthorize("hasPermission(this.trmlgbcostMapping.toDomain(returnObject.body),'ehr-TRMLGBCOST-Get')")
    @ApiOperation(value = "Get", tags = {"TRMLGBCOST" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmlgbcosts/{trmlgbcost_id}")
    public ResponseEntity<TRMLGBCOSTDTO> get(@PathVariable("trmlgbcost_id") String trmlgbcost_id) {
        TRMLGBCOST domain = trmlgbcostService.get(trmlgbcost_id);
        TRMLGBCOSTDTO dto = trmlgbcostMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmlgbcostService.get(#trmlgbcost_id),'ehr-TRMLGBCOST-Remove')")
    @ApiOperation(value = "Remove", tags = {"TRMLGBCOST" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmlgbcosts/{trmlgbcost_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmlgbcost_id") String trmlgbcost_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmlgbcostService.remove(trmlgbcost_id));
    }

    @PreAuthorize("hasPermission(this.trmlgbcostService.getTrmlgbcostByIds(#ids),'ehr-TRMLGBCOST-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"TRMLGBCOST" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmlgbcosts/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmlgbcostService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"TRMLGBCOST" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmlgbcosts/getdraft")
    public ResponseEntity<TRMLGBCOSTDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmlgbcostMapping.toDto(trmlgbcostService.getDraft(new TRMLGBCOST())));
    }

    @ApiOperation(value = "CheckKey", tags = {"TRMLGBCOST" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmlgbcosts/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMLGBCOSTDTO trmlgbcostdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmlgbcostService.checkKey(trmlgbcostMapping.toDomain(trmlgbcostdto)));
    }

    @PreAuthorize("hasPermission(this.trmlgbcostService.get(#trmlgbcost_id),'ehr-TRMLGBCOST-Update')")
    @ApiOperation(value = "Update", tags = {"TRMLGBCOST" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmlgbcosts/{trmlgbcost_id}")
    @Transactional
    public ResponseEntity<TRMLGBCOSTDTO> update(@PathVariable("trmlgbcost_id") String trmlgbcost_id, @RequestBody TRMLGBCOSTDTO trmlgbcostdto) {
		TRMLGBCOST domain  = trmlgbcostMapping.toDomain(trmlgbcostdto);
        domain .setTrmlgbcostid(trmlgbcost_id);
		trmlgbcostService.update(domain );
		TRMLGBCOSTDTO dto = trmlgbcostMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmlgbcostService.getTrmlgbcostByEntities(this.trmlgbcostMapping.toDomain(#trmlgbcostdtos)),'ehr-TRMLGBCOST-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"TRMLGBCOST" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmlgbcosts/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMLGBCOSTDTO> trmlgbcostdtos) {
        trmlgbcostService.updateBatch(trmlgbcostMapping.toDomain(trmlgbcostdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmlgbcostMapping.toDomain(#trmlgbcostdto),'ehr-TRMLGBCOST-Create')")
    @ApiOperation(value = "Create", tags = {"TRMLGBCOST" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmlgbcosts")
    @Transactional
    public ResponseEntity<TRMLGBCOSTDTO> create(@RequestBody TRMLGBCOSTDTO trmlgbcostdto) {
        TRMLGBCOST domain = trmlgbcostMapping.toDomain(trmlgbcostdto);
		trmlgbcostService.create(domain);
        TRMLGBCOSTDTO dto = trmlgbcostMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmlgbcostMapping.toDomain(#trmlgbcostdtos),'ehr-TRMLGBCOST-Create')")
    @ApiOperation(value = "createBatch", tags = {"TRMLGBCOST" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmlgbcosts/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMLGBCOSTDTO> trmlgbcostdtos) {
        trmlgbcostService.createBatch(trmlgbcostMapping.toDomain(trmlgbcostdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmlgbcostMapping.toDomain(#trmlgbcostdto),'ehr-TRMLGBCOST-Save')")
    @ApiOperation(value = "Save", tags = {"TRMLGBCOST" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmlgbcosts/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMLGBCOSTDTO trmlgbcostdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmlgbcostService.save(trmlgbcostMapping.toDomain(trmlgbcostdto)));
    }

    @PreAuthorize("hasPermission(this.trmlgbcostMapping.toDomain(#trmlgbcostdtos),'ehr-TRMLGBCOST-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"TRMLGBCOST" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmlgbcosts/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMLGBCOSTDTO> trmlgbcostdtos) {
        trmlgbcostService.saveBatch(trmlgbcostMapping.toDomain(trmlgbcostdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMLGBCOST-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TRMLGBCOST" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmlgbcosts/fetchdefault")
	public ResponseEntity<List<TRMLGBCOSTDTO>> fetchDefault(TRMLGBCOSTSearchContext context) {
        Page<TRMLGBCOST> domains = trmlgbcostService.searchDefault(context) ;
        List<TRMLGBCOSTDTO> list = trmlgbcostMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMLGBCOST-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TRMLGBCOST" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmlgbcosts/searchdefault")
	public ResponseEntity<Page<TRMLGBCOSTDTO>> searchDefault(@RequestBody TRMLGBCOSTSearchContext context) {
        Page<TRMLGBCOST> domains = trmlgbcostService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmlgbcostMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

