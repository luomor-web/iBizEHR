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
import cn.ibizlab.ehr.core.trm.domain.TRMDEPARTNEEDS;
import cn.ibizlab.ehr.core.trm.service.ITRMDEPARTNEEDSService;
import cn.ibizlab.ehr.core.trm.filter.TRMDEPARTNEEDSSearchContext;

@Slf4j
@Api(tags = {"TRMDEPARTNEEDS" })
@RestController("WebApi-trmdepartneeds")
@RequestMapping("")
public class TRMDEPARTNEEDSResource {

    @Autowired
    private ITRMDEPARTNEEDSService trmdepartneedsService;

    @Autowired
    @Lazy
    public TRMDEPARTNEEDSMapping trmdepartneedsMapping;

    public TRMDEPARTNEEDSDTO permissionDTO=new TRMDEPARTNEEDSDTO();

    @PreAuthorize("hasPermission(#trmdepartneeds_id,'Update',{'Sql',this.trmdepartneedsMapping,#trmdepartneedsdto})")
    @ApiOperation(value = "Update", tags = {"TRMDEPARTNEEDS" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmdepartneeds/{trmdepartneeds_id}")
    @Transactional
    public ResponseEntity<TRMDEPARTNEEDSDTO> update(@PathVariable("trmdepartneeds_id") String trmdepartneeds_id, @RequestBody TRMDEPARTNEEDSDTO trmdepartneedsdto) {
		TRMDEPARTNEEDS domain = trmdepartneedsMapping.toDomain(trmdepartneedsdto);
        domain.setTrmdepartneedsid(trmdepartneeds_id);
		trmdepartneedsService.update(domain);
		TRMDEPARTNEEDSDTO dto = trmdepartneedsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"TRMDEPARTNEEDS" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmdepartneeds/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMDEPARTNEEDSDTO> trmdepartneedsdtos) {
        trmdepartneedsService.updateBatch(trmdepartneedsMapping.toDomain(trmdepartneedsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#trmdepartneeds_id,'Get',{'Sql',this.trmdepartneedsMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"TRMDEPARTNEEDS" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmdepartneeds/{trmdepartneeds_id}")
    public ResponseEntity<TRMDEPARTNEEDSDTO> get(@PathVariable("trmdepartneeds_id") String trmdepartneeds_id) {
        TRMDEPARTNEEDS domain = trmdepartneedsService.get(trmdepartneeds_id);
        TRMDEPARTNEEDSDTO dto = trmdepartneedsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#trmdepartneeds_id,'Remove',{'Sql',this.trmdepartneedsMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"TRMDEPARTNEEDS" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmdepartneeds/{trmdepartneeds_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmdepartneeds_id") String trmdepartneeds_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmdepartneedsService.remove(trmdepartneeds_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"TRMDEPARTNEEDS" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmdepartneeds/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmdepartneedsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.trmdepartneedsMapping,#trmdepartneedsdto})")
    @ApiOperation(value = "Save", tags = {"TRMDEPARTNEEDS" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdepartneeds/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMDEPARTNEEDSDTO trmdepartneedsdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmdepartneedsService.save(trmdepartneedsMapping.toDomain(trmdepartneedsdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"TRMDEPARTNEEDS" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdepartneeds/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMDEPARTNEEDSDTO> trmdepartneedsdtos) {
        trmdepartneedsService.saveBatch(trmdepartneedsMapping.toDomain(trmdepartneedsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMDEPARTNEEDS-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"TRMDEPARTNEEDS" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmdepartneeds/getdraft")
    public ResponseEntity<TRMDEPARTNEEDSDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmdepartneedsMapping.toDto(trmdepartneedsService.getDraft(new TRMDEPARTNEEDS())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMDEPARTNEEDS-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"TRMDEPARTNEEDS" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdepartneeds/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMDEPARTNEEDSDTO trmdepartneedsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmdepartneedsService.checkKey(trmdepartneedsMapping.toDomain(trmdepartneedsdto)));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.trmdepartneedsMapping,#trmdepartneedsdto})")
    @ApiOperation(value = "Create", tags = {"TRMDEPARTNEEDS" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdepartneeds")
    @Transactional
    public ResponseEntity<TRMDEPARTNEEDSDTO> create(@RequestBody TRMDEPARTNEEDSDTO trmdepartneedsdto) {
        TRMDEPARTNEEDS domain = trmdepartneedsMapping.toDomain(trmdepartneedsdto);
		trmdepartneedsService.create(domain);
        TRMDEPARTNEEDSDTO dto = trmdepartneedsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"TRMDEPARTNEEDS" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdepartneeds/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMDEPARTNEEDSDTO> trmdepartneedsdtos) {
        trmdepartneedsService.createBatch(trmdepartneedsMapping.toDomain(trmdepartneedsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMDEPARTNEEDS-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TRMDEPARTNEEDS" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmdepartneeds/fetchdefault")
	public ResponseEntity<List<TRMDEPARTNEEDSDTO>> fetchDefault(TRMDEPARTNEEDSSearchContext context) {
        Page<TRMDEPARTNEEDS> domains = trmdepartneedsService.searchDefault(context) ;
        List<TRMDEPARTNEEDSDTO> list = trmdepartneedsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMDEPARTNEEDS-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TRMDEPARTNEEDS" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmdepartneeds/searchdefault")
	public ResponseEntity<Page<TRMDEPARTNEEDSDTO>> searchDefault(@RequestBody TRMDEPARTNEEDSSearchContext context) {
        Page<TRMDEPARTNEEDS> domains = trmdepartneedsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmdepartneedsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
