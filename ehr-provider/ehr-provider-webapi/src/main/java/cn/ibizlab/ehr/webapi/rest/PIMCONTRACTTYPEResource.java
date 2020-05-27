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
import cn.ibizlab.ehr.core.pim.domain.PIMCONTRACTTYPE;
import cn.ibizlab.ehr.core.pim.service.IPIMCONTRACTTYPEService;
import cn.ibizlab.ehr.core.pim.filter.PIMCONTRACTTYPESearchContext;

@Slf4j
@Api(tags = {"PIMCONTRACTTYPE" })
@RestController("WebApi-pimcontracttype")
@RequestMapping("")
public class PIMCONTRACTTYPEResource {

    @Autowired
    public IPIMCONTRACTTYPEService pimcontracttypeService;

    @Autowired
    @Lazy
    public PIMCONTRACTTYPEMapping pimcontracttypeMapping;

    @PreAuthorize("hasPermission(this.pimcontracttypeService.get(#pimcontracttype_id),'ehr-PIMCONTRACTTYPE-Update')")
    @ApiOperation(value = "Update", tags = {"PIMCONTRACTTYPE" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimcontracttypes/{pimcontracttype_id}")
    @Transactional
    public ResponseEntity<PIMCONTRACTTYPEDTO> update(@PathVariable("pimcontracttype_id") String pimcontracttype_id, @RequestBody PIMCONTRACTTYPEDTO pimcontracttypedto) {
		PIMCONTRACTTYPE domain  = pimcontracttypeMapping.toDomain(pimcontracttypedto);
        domain .setPimcontracttypeid(pimcontracttype_id);
		pimcontracttypeService.update(domain );
		PIMCONTRACTTYPEDTO dto = pimcontracttypeMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimcontracttypeService.getPimcontracttypeByEntities(this.pimcontracttypeMapping.toDomain(#pimcontracttypedtos)),'ehr-PIMCONTRACTTYPE-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMCONTRACTTYPE" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimcontracttypes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMCONTRACTTYPEDTO> pimcontracttypedtos) {
        pimcontracttypeService.updateBatch(pimcontracttypeMapping.toDomain(pimcontracttypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimcontracttypeMapping.toDomain(#pimcontracttypedto),'ehr-PIMCONTRACTTYPE-Save')")
    @ApiOperation(value = "Save", tags = {"PIMCONTRACTTYPE" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcontracttypes/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMCONTRACTTYPEDTO pimcontracttypedto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimcontracttypeService.save(pimcontracttypeMapping.toDomain(pimcontracttypedto)));
    }

    @PreAuthorize("hasPermission(this.pimcontracttypeMapping.toDomain(#pimcontracttypedtos),'ehr-PIMCONTRACTTYPE-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PIMCONTRACTTYPE" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcontracttypes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMCONTRACTTYPEDTO> pimcontracttypedtos) {
        pimcontracttypeService.saveBatch(pimcontracttypeMapping.toDomain(pimcontracttypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimcontracttypeService.get(#pimcontracttype_id),'ehr-PIMCONTRACTTYPE-Remove')")
    @ApiOperation(value = "Remove", tags = {"PIMCONTRACTTYPE" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimcontracttypes/{pimcontracttype_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimcontracttype_id") String pimcontracttype_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimcontracttypeService.remove(pimcontracttype_id));
    }

    @PreAuthorize("hasPermission(this.pimcontracttypeService.getPimcontracttypeByIds(#ids),'ehr-PIMCONTRACTTYPE-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PIMCONTRACTTYPE" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimcontracttypes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimcontracttypeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimcontracttypeMapping.toDomain(#pimcontracttypedto),'ehr-PIMCONTRACTTYPE-Create')")
    @ApiOperation(value = "Create", tags = {"PIMCONTRACTTYPE" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcontracttypes")
    @Transactional
    public ResponseEntity<PIMCONTRACTTYPEDTO> create(@RequestBody PIMCONTRACTTYPEDTO pimcontracttypedto) {
        PIMCONTRACTTYPE domain = pimcontracttypeMapping.toDomain(pimcontracttypedto);
		pimcontracttypeService.create(domain);
        PIMCONTRACTTYPEDTO dto = pimcontracttypeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimcontracttypeMapping.toDomain(#pimcontracttypedtos),'ehr-PIMCONTRACTTYPE-Create')")
    @ApiOperation(value = "createBatch", tags = {"PIMCONTRACTTYPE" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcontracttypes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMCONTRACTTYPEDTO> pimcontracttypedtos) {
        pimcontracttypeService.createBatch(pimcontracttypeMapping.toDomain(pimcontracttypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimcontracttypeMapping.toDomain(returnObject.body),'ehr-PIMCONTRACTTYPE-Get')")
    @ApiOperation(value = "Get", tags = {"PIMCONTRACTTYPE" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimcontracttypes/{pimcontracttype_id}")
    public ResponseEntity<PIMCONTRACTTYPEDTO> get(@PathVariable("pimcontracttype_id") String pimcontracttype_id) {
        PIMCONTRACTTYPE domain = pimcontracttypeService.get(pimcontracttype_id);
        PIMCONTRACTTYPEDTO dto = pimcontracttypeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "GetDraft", tags = {"PIMCONTRACTTYPE" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimcontracttypes/getdraft")
    public ResponseEntity<PIMCONTRACTTYPEDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimcontracttypeMapping.toDto(pimcontracttypeService.getDraft(new PIMCONTRACTTYPE())));
    }

    @ApiOperation(value = "CheckKey", tags = {"PIMCONTRACTTYPE" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcontracttypes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMCONTRACTTYPEDTO pimcontracttypedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimcontracttypeService.checkKey(pimcontracttypeMapping.toDomain(pimcontracttypedto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACTTYPE-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMCONTRACTTYPE" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimcontracttypes/fetchdefault")
	public ResponseEntity<List<PIMCONTRACTTYPEDTO>> fetchDefault(PIMCONTRACTTYPESearchContext context) {
        Page<PIMCONTRACTTYPE> domains = pimcontracttypeService.searchDefault(context) ;
        List<PIMCONTRACTTYPEDTO> list = pimcontracttypeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCONTRACTTYPE-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMCONTRACTTYPE" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimcontracttypes/searchdefault")
	public ResponseEntity<Page<PIMCONTRACTTYPEDTO>> searchDefault(@RequestBody PIMCONTRACTTYPESearchContext context) {
        Page<PIMCONTRACTTYPE> domains = pimcontracttypeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcontracttypeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

