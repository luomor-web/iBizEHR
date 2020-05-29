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
import cn.ibizlab.ehr.core.vac.domain.VacLeaceType;
import cn.ibizlab.ehr.core.vac.service.IVacLeaceTypeService;
import cn.ibizlab.ehr.core.vac.filter.VacLeaceTypeSearchContext;

@Slf4j
@Api(tags = {"VacLeaceType" })
@RestController("WebApi-vacleacetype")
@RequestMapping("")
public class VacLeaceTypeResource {

    @Autowired
    public IVacLeaceTypeService vacleacetypeService;

    @Autowired
    @Lazy
    public VacLeaceTypeMapping vacleacetypeMapping;

    @PreAuthorize("hasPermission(this.vacleacetypeService.get(#vacleacetype_id),'ehr-VacLeaceType-Update')")
    @ApiOperation(value = "Update", tags = {"VacLeaceType" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacleacetypes/{vacleacetype_id}")
    @Transactional
    public ResponseEntity<VacLeaceTypeDTO> update(@PathVariable("vacleacetype_id") String vacleacetype_id, @RequestBody VacLeaceTypeDTO vacleacetypedto) {
		VacLeaceType domain  = vacleacetypeMapping.toDomain(vacleacetypedto);
        domain .setVacleacetypeid(vacleacetype_id);
		vacleacetypeService.update(domain );
		VacLeaceTypeDTO dto = vacleacetypeMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacleacetypeService.getVacleacetypeByEntities(this.vacleacetypeMapping.toDomain(#vacleacetypedtos)),'ehr-VacLeaceType-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"VacLeaceType" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacleacetypes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VacLeaceTypeDTO> vacleacetypedtos) {
        vacleacetypeService.updateBatch(vacleacetypeMapping.toDomain(vacleacetypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacleacetypeService.get(#vacleacetype_id),'ehr-VacLeaceType-Remove')")
    @ApiOperation(value = "Remove", tags = {"VacLeaceType" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacleacetypes/{vacleacetype_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacleacetype_id") String vacleacetype_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacleacetypeService.remove(vacleacetype_id));
    }

    @PreAuthorize("hasPermission(this.vacleacetypeService.getVacleacetypeByIds(#ids),'ehr-VacLeaceType-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"VacLeaceType" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacleacetypes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacleacetypeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacleacetypeMapping.toDomain(#vacleacetypedto),'ehr-VacLeaceType-Create')")
    @ApiOperation(value = "Create", tags = {"VacLeaceType" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleacetypes")
    @Transactional
    public ResponseEntity<VacLeaceTypeDTO> create(@RequestBody VacLeaceTypeDTO vacleacetypedto) {
        VacLeaceType domain = vacleacetypeMapping.toDomain(vacleacetypedto);
		vacleacetypeService.create(domain);
        VacLeaceTypeDTO dto = vacleacetypeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacleacetypeMapping.toDomain(#vacleacetypedtos),'ehr-VacLeaceType-Create')")
    @ApiOperation(value = "createBatch", tags = {"VacLeaceType" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleacetypes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VacLeaceTypeDTO> vacleacetypedtos) {
        vacleacetypeService.createBatch(vacleacetypeMapping.toDomain(vacleacetypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"VacLeaceType" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/vacleacetypes/getdraft")
    public ResponseEntity<VacLeaceTypeDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacleacetypeMapping.toDto(vacleacetypeService.getDraft(new VacLeaceType())));
    }

    @PreAuthorize("hasPermission(this.vacleacetypeMapping.toDomain(#vacleacetypedto),'ehr-VacLeaceType-Save')")
    @ApiOperation(value = "Save", tags = {"VacLeaceType" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleacetypes/save")
    public ResponseEntity<Boolean> save(@RequestBody VacLeaceTypeDTO vacleacetypedto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacleacetypeService.save(vacleacetypeMapping.toDomain(vacleacetypedto)));
    }

    @PreAuthorize("hasPermission(this.vacleacetypeMapping.toDomain(#vacleacetypedtos),'ehr-VacLeaceType-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"VacLeaceType" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleacetypes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VacLeaceTypeDTO> vacleacetypedtos) {
        vacleacetypeService.saveBatch(vacleacetypeMapping.toDomain(vacleacetypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"VacLeaceType" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleacetypes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VacLeaceTypeDTO vacleacetypedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacleacetypeService.checkKey(vacleacetypeMapping.toDomain(vacleacetypedto)));
    }

    @PostAuthorize("hasPermission(this.vacleacetypeMapping.toDomain(returnObject.body),'ehr-VacLeaceType-Get')")
    @ApiOperation(value = "Get", tags = {"VacLeaceType" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/vacleacetypes/{vacleacetype_id}")
    public ResponseEntity<VacLeaceTypeDTO> get(@PathVariable("vacleacetype_id") String vacleacetype_id) {
        VacLeaceType domain = vacleacetypeService.get(vacleacetype_id);
        VacLeaceTypeDTO dto = vacleacetypeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaceType-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"VacLeaceType" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacleacetypes/fetchdefault")
	public ResponseEntity<List<VacLeaceTypeDTO>> fetchDefault(VacLeaceTypeSearchContext context) {
        Page<VacLeaceType> domains = vacleacetypeService.searchDefault(context) ;
        List<VacLeaceTypeDTO> list = vacleacetypeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VacLeaceType-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"VacLeaceType" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacleacetypes/searchdefault")
	public ResponseEntity<Page<VacLeaceTypeDTO>> searchDefault(@RequestBody VacLeaceTypeSearchContext context) {
        Page<VacLeaceType> domains = vacleacetypeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleacetypeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

