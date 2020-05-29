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
import cn.ibizlab.ehr.core.pim.domain.PimMajorSetype;
import cn.ibizlab.ehr.core.pim.service.IPimMajorSetypeService;
import cn.ibizlab.ehr.core.pim.filter.PimMajorSetypeSearchContext;

@Slf4j
@Api(tags = {"PimMajorSetype" })
@RestController("WebApi-pimmajorsetype")
@RequestMapping("")
public class PimMajorSetypeResource {

    @Autowired
    public IPimMajorSetypeService pimmajorsetypeService;

    @Autowired
    @Lazy
    public PimMajorSetypeMapping pimmajorsetypeMapping;

    @PreAuthorize("hasPermission(this.pimmajorsetypeService.get(#pimmajorsetype_id),'ehr-PimMajorSetype-Remove')")
    @ApiOperation(value = "Remove", tags = {"PimMajorSetype" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimmajorsetypes/{pimmajorsetype_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimmajorsetype_id") String pimmajorsetype_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimmajorsetypeService.remove(pimmajorsetype_id));
    }

    @PreAuthorize("hasPermission(this.pimmajorsetypeService.getPimmajorsetypeByIds(#ids),'ehr-PimMajorSetype-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PimMajorSetype" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimmajorsetypes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimmajorsetypeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"PimMajorSetype" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimmajorsetypes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimMajorSetypeDTO pimmajorsetypedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimmajorsetypeService.checkKey(pimmajorsetypeMapping.toDomain(pimmajorsetypedto)));
    }

    @PostAuthorize("hasPermission(this.pimmajorsetypeMapping.toDomain(returnObject.body),'ehr-PimMajorSetype-Get')")
    @ApiOperation(value = "Get", tags = {"PimMajorSetype" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimmajorsetypes/{pimmajorsetype_id}")
    public ResponseEntity<PimMajorSetypeDTO> get(@PathVariable("pimmajorsetype_id") String pimmajorsetype_id) {
        PimMajorSetype domain = pimmajorsetypeService.get(pimmajorsetype_id);
        PimMajorSetypeDTO dto = pimmajorsetypeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimmajorsetypeMapping.toDomain(#pimmajorsetypedto),'ehr-PimMajorSetype-Save')")
    @ApiOperation(value = "Save", tags = {"PimMajorSetype" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimmajorsetypes/save")
    public ResponseEntity<Boolean> save(@RequestBody PimMajorSetypeDTO pimmajorsetypedto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimmajorsetypeService.save(pimmajorsetypeMapping.toDomain(pimmajorsetypedto)));
    }

    @PreAuthorize("hasPermission(this.pimmajorsetypeMapping.toDomain(#pimmajorsetypedtos),'ehr-PimMajorSetype-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PimMajorSetype" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimmajorsetypes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimMajorSetypeDTO> pimmajorsetypedtos) {
        pimmajorsetypeService.saveBatch(pimmajorsetypeMapping.toDomain(pimmajorsetypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimmajorsetypeMapping.toDomain(#pimmajorsetypedto),'ehr-PimMajorSetype-Create')")
    @ApiOperation(value = "Create", tags = {"PimMajorSetype" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimmajorsetypes")
    @Transactional
    public ResponseEntity<PimMajorSetypeDTO> create(@RequestBody PimMajorSetypeDTO pimmajorsetypedto) {
        PimMajorSetype domain = pimmajorsetypeMapping.toDomain(pimmajorsetypedto);
		pimmajorsetypeService.create(domain);
        PimMajorSetypeDTO dto = pimmajorsetypeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimmajorsetypeMapping.toDomain(#pimmajorsetypedtos),'ehr-PimMajorSetype-Create')")
    @ApiOperation(value = "createBatch", tags = {"PimMajorSetype" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimmajorsetypes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimMajorSetypeDTO> pimmajorsetypedtos) {
        pimmajorsetypeService.createBatch(pimmajorsetypeMapping.toDomain(pimmajorsetypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"PimMajorSetype" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimmajorsetypes/getdraft")
    public ResponseEntity<PimMajorSetypeDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimmajorsetypeMapping.toDto(pimmajorsetypeService.getDraft(new PimMajorSetype())));
    }

    @PreAuthorize("hasPermission(this.pimmajorsetypeService.get(#pimmajorsetype_id),'ehr-PimMajorSetype-Update')")
    @ApiOperation(value = "Update", tags = {"PimMajorSetype" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimmajorsetypes/{pimmajorsetype_id}")
    @Transactional
    public ResponseEntity<PimMajorSetypeDTO> update(@PathVariable("pimmajorsetype_id") String pimmajorsetype_id, @RequestBody PimMajorSetypeDTO pimmajorsetypedto) {
		PimMajorSetype domain  = pimmajorsetypeMapping.toDomain(pimmajorsetypedto);
        domain .setPimmajorsetypeid(pimmajorsetype_id);
		pimmajorsetypeService.update(domain );
		PimMajorSetypeDTO dto = pimmajorsetypeMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimmajorsetypeService.getPimmajorsetypeByEntities(this.pimmajorsetypeMapping.toDomain(#pimmajorsetypedtos)),'ehr-PimMajorSetype-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PimMajorSetype" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimmajorsetypes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimMajorSetypeDTO> pimmajorsetypedtos) {
        pimmajorsetypeService.updateBatch(pimmajorsetypeMapping.toDomain(pimmajorsetypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimMajorSetype-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PimMajorSetype" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimmajorsetypes/fetchdefault")
	public ResponseEntity<List<PimMajorSetypeDTO>> fetchDefault(PimMajorSetypeSearchContext context) {
        Page<PimMajorSetype> domains = pimmajorsetypeService.searchDefault(context) ;
        List<PimMajorSetypeDTO> list = pimmajorsetypeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimMajorSetype-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PimMajorSetype" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimmajorsetypes/searchdefault")
	public ResponseEntity<Page<PimMajorSetypeDTO>> searchDefault(@RequestBody PimMajorSetypeSearchContext context) {
        Page<PimMajorSetype> domains = pimmajorsetypeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimmajorsetypeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

