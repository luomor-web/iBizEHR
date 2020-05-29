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
import cn.ibizlab.ehr.core.pim.domain.PimGwType;
import cn.ibizlab.ehr.core.pim.service.IPimGwTypeService;
import cn.ibizlab.ehr.core.pim.filter.PimGwTypeSearchContext;

@Slf4j
@Api(tags = {"PimGwType" })
@RestController("WebApi-pimgwtype")
@RequestMapping("")
public class PimGwTypeResource {

    @Autowired
    public IPimGwTypeService pimgwtypeService;

    @Autowired
    @Lazy
    public PimGwTypeMapping pimgwtypeMapping;

    @PreAuthorize("hasPermission(this.pimgwtypeMapping.toDomain(#pimgwtypedto),'ehr-PimGwType-Save')")
    @ApiOperation(value = "Save", tags = {"PimGwType" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimgwtypes/save")
    public ResponseEntity<Boolean> save(@RequestBody PimGwTypeDTO pimgwtypedto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimgwtypeService.save(pimgwtypeMapping.toDomain(pimgwtypedto)));
    }

    @PreAuthorize("hasPermission(this.pimgwtypeMapping.toDomain(#pimgwtypedtos),'ehr-PimGwType-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PimGwType" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimgwtypes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimGwTypeDTO> pimgwtypedtos) {
        pimgwtypeService.saveBatch(pimgwtypeMapping.toDomain(pimgwtypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"PimGwType" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimgwtypes/getdraft")
    public ResponseEntity<PimGwTypeDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimgwtypeMapping.toDto(pimgwtypeService.getDraft(new PimGwType())));
    }

    @PostAuthorize("hasPermission(this.pimgwtypeMapping.toDomain(returnObject.body),'ehr-PimGwType-Get')")
    @ApiOperation(value = "Get", tags = {"PimGwType" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimgwtypes/{pimgwtype_id}")
    public ResponseEntity<PimGwTypeDTO> get(@PathVariable("pimgwtype_id") String pimgwtype_id) {
        PimGwType domain = pimgwtypeService.get(pimgwtype_id);
        PimGwTypeDTO dto = pimgwtypeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimgwtypeService.get(#pimgwtype_id),'ehr-PimGwType-Remove')")
    @ApiOperation(value = "Remove", tags = {"PimGwType" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimgwtypes/{pimgwtype_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimgwtype_id") String pimgwtype_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimgwtypeService.remove(pimgwtype_id));
    }

    @PreAuthorize("hasPermission(this.pimgwtypeService.getPimgwtypeByIds(#ids),'ehr-PimGwType-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PimGwType" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimgwtypes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimgwtypeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"PimGwType" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimgwtypes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimGwTypeDTO pimgwtypedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimgwtypeService.checkKey(pimgwtypeMapping.toDomain(pimgwtypedto)));
    }

    @PreAuthorize("hasPermission(this.pimgwtypeService.get(#pimgwtype_id),'ehr-PimGwType-Update')")
    @ApiOperation(value = "Update", tags = {"PimGwType" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimgwtypes/{pimgwtype_id}")
    @Transactional
    public ResponseEntity<PimGwTypeDTO> update(@PathVariable("pimgwtype_id") String pimgwtype_id, @RequestBody PimGwTypeDTO pimgwtypedto) {
		PimGwType domain  = pimgwtypeMapping.toDomain(pimgwtypedto);
        domain .setPimgwtypeid(pimgwtype_id);
		pimgwtypeService.update(domain );
		PimGwTypeDTO dto = pimgwtypeMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimgwtypeService.getPimgwtypeByEntities(this.pimgwtypeMapping.toDomain(#pimgwtypedtos)),'ehr-PimGwType-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PimGwType" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimgwtypes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimGwTypeDTO> pimgwtypedtos) {
        pimgwtypeService.updateBatch(pimgwtypeMapping.toDomain(pimgwtypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimgwtypeMapping.toDomain(#pimgwtypedto),'ehr-PimGwType-Create')")
    @ApiOperation(value = "Create", tags = {"PimGwType" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimgwtypes")
    @Transactional
    public ResponseEntity<PimGwTypeDTO> create(@RequestBody PimGwTypeDTO pimgwtypedto) {
        PimGwType domain = pimgwtypeMapping.toDomain(pimgwtypedto);
		pimgwtypeService.create(domain);
        PimGwTypeDTO dto = pimgwtypeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimgwtypeMapping.toDomain(#pimgwtypedtos),'ehr-PimGwType-Create')")
    @ApiOperation(value = "createBatch", tags = {"PimGwType" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimgwtypes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimGwTypeDTO> pimgwtypedtos) {
        pimgwtypeService.createBatch(pimgwtypeMapping.toDomain(pimgwtypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimGwType-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PimGwType" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimgwtypes/fetchdefault")
	public ResponseEntity<List<PimGwTypeDTO>> fetchDefault(PimGwTypeSearchContext context) {
        Page<PimGwType> domains = pimgwtypeService.searchDefault(context) ;
        List<PimGwTypeDTO> list = pimgwtypeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimGwType-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PimGwType" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimgwtypes/searchdefault")
	public ResponseEntity<Page<PimGwTypeDTO>> searchDefault(@RequestBody PimGwTypeSearchContext context) {
        Page<PimGwType> domains = pimgwtypeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimgwtypeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

