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
import cn.ibizlab.ehr.core.vac.domain.VACLEACETYPE;
import cn.ibizlab.ehr.core.vac.service.IVACLEACETYPEService;
import cn.ibizlab.ehr.core.vac.filter.VACLEACETYPESearchContext;

@Slf4j
@Api(tags = {"VACLEACETYPE" })
@RestController("WebApi-vacleacetype")
@RequestMapping("")
public class VACLEACETYPEResource {

    @Autowired
    public IVACLEACETYPEService vacleacetypeService;

    @Autowired
    @Lazy
    public VACLEACETYPEMapping vacleacetypeMapping;

    @PreAuthorize("hasPermission(this.vacleacetypeService.get(#vacleacetype_id),'ehr-VACLEACETYPE-Update')")
    @ApiOperation(value = "Update", tags = {"VACLEACETYPE" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacleacetypes/{vacleacetype_id}")
    @Transactional
    public ResponseEntity<VACLEACETYPEDTO> update(@PathVariable("vacleacetype_id") String vacleacetype_id, @RequestBody VACLEACETYPEDTO vacleacetypedto) {
		VACLEACETYPE domain  = vacleacetypeMapping.toDomain(vacleacetypedto);
        domain .setVacleacetypeid(vacleacetype_id);
		vacleacetypeService.update(domain );
		VACLEACETYPEDTO dto = vacleacetypeMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacleacetypeService.getVacleacetypeByEntities(this.vacleacetypeMapping.toDomain(#vacleacetypedtos)),'ehr-VACLEACETYPE-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"VACLEACETYPE" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacleacetypes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VACLEACETYPEDTO> vacleacetypedtos) {
        vacleacetypeService.updateBatch(vacleacetypeMapping.toDomain(vacleacetypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacleacetypeService.get(#vacleacetype_id),'ehr-VACLEACETYPE-Remove')")
    @ApiOperation(value = "Remove", tags = {"VACLEACETYPE" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacleacetypes/{vacleacetype_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacleacetype_id") String vacleacetype_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacleacetypeService.remove(vacleacetype_id));
    }

    @PreAuthorize("hasPermission(this.vacleacetypeService.getVacleacetypeByIds(#ids),'ehr-VACLEACETYPE-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"VACLEACETYPE" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacleacetypes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacleacetypeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacleacetypeMapping.toDomain(#vacleacetypedto),'ehr-VACLEACETYPE-Create')")
    @ApiOperation(value = "Create", tags = {"VACLEACETYPE" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleacetypes")
    @Transactional
    public ResponseEntity<VACLEACETYPEDTO> create(@RequestBody VACLEACETYPEDTO vacleacetypedto) {
        VACLEACETYPE domain = vacleacetypeMapping.toDomain(vacleacetypedto);
		vacleacetypeService.create(domain);
        VACLEACETYPEDTO dto = vacleacetypeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacleacetypeMapping.toDomain(#vacleacetypedtos),'ehr-VACLEACETYPE-Create')")
    @ApiOperation(value = "createBatch", tags = {"VACLEACETYPE" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleacetypes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VACLEACETYPEDTO> vacleacetypedtos) {
        vacleacetypeService.createBatch(vacleacetypeMapping.toDomain(vacleacetypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"VACLEACETYPE" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/vacleacetypes/getdraft")
    public ResponseEntity<VACLEACETYPEDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacleacetypeMapping.toDto(vacleacetypeService.getDraft(new VACLEACETYPE())));
    }

    @PreAuthorize("hasPermission(this.vacleacetypeMapping.toDomain(#vacleacetypedto),'ehr-VACLEACETYPE-Save')")
    @ApiOperation(value = "Save", tags = {"VACLEACETYPE" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleacetypes/save")
    public ResponseEntity<Boolean> save(@RequestBody VACLEACETYPEDTO vacleacetypedto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacleacetypeService.save(vacleacetypeMapping.toDomain(vacleacetypedto)));
    }

    @PreAuthorize("hasPermission(this.vacleacetypeMapping.toDomain(#vacleacetypedtos),'ehr-VACLEACETYPE-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"VACLEACETYPE" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleacetypes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VACLEACETYPEDTO> vacleacetypedtos) {
        vacleacetypeService.saveBatch(vacleacetypeMapping.toDomain(vacleacetypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"VACLEACETYPE" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleacetypes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VACLEACETYPEDTO vacleacetypedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacleacetypeService.checkKey(vacleacetypeMapping.toDomain(vacleacetypedto)));
    }

    @PostAuthorize("hasPermission(this.vacleacetypeMapping.toDomain(returnObject.body),'ehr-VACLEACETYPE-Get')")
    @ApiOperation(value = "Get", tags = {"VACLEACETYPE" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/vacleacetypes/{vacleacetype_id}")
    public ResponseEntity<VACLEACETYPEDTO> get(@PathVariable("vacleacetype_id") String vacleacetype_id) {
        VACLEACETYPE domain = vacleacetypeService.get(vacleacetype_id);
        VACLEACETYPEDTO dto = vacleacetypeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEACETYPE-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"VACLEACETYPE" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacleacetypes/fetchdefault")
	public ResponseEntity<List<VACLEACETYPEDTO>> fetchDefault(VACLEACETYPESearchContext context) {
        Page<VACLEACETYPE> domains = vacleacetypeService.searchDefault(context) ;
        List<VACLEACETYPEDTO> list = vacleacetypeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEACETYPE-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"VACLEACETYPE" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacleacetypes/searchdefault")
	public ResponseEntity<Page<VACLEACETYPEDTO>> searchDefault(@RequestBody VACLEACETYPESearchContext context) {
        Page<VACLEACETYPE> domains = vacleacetypeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleacetypeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

