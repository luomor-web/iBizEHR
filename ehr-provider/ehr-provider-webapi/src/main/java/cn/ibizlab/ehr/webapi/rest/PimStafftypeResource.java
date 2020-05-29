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
import cn.ibizlab.ehr.core.pim.domain.PimStafftype;
import cn.ibizlab.ehr.core.pim.service.IPimStafftypeService;
import cn.ibizlab.ehr.core.pim.filter.PimStafftypeSearchContext;

@Slf4j
@Api(tags = {"PimStafftype" })
@RestController("WebApi-pimstafftype")
@RequestMapping("")
public class PimStafftypeResource {

    @Autowired
    public IPimStafftypeService pimstafftypeService;

    @Autowired
    @Lazy
    public PimStafftypeMapping pimstafftypeMapping;

    @ApiOperation(value = "CheckKey", tags = {"PimStafftype" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimstafftypes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimStafftypeDTO pimstafftypedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimstafftypeService.checkKey(pimstafftypeMapping.toDomain(pimstafftypedto)));
    }

    @PostAuthorize("hasPermission(this.pimstafftypeMapping.toDomain(returnObject.body),'ehr-PimStafftype-Get')")
    @ApiOperation(value = "Get", tags = {"PimStafftype" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimstafftypes/{pimstafftype_id}")
    public ResponseEntity<PimStafftypeDTO> get(@PathVariable("pimstafftype_id") String pimstafftype_id) {
        PimStafftype domain = pimstafftypeService.get(pimstafftype_id);
        PimStafftypeDTO dto = pimstafftypeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "GetDraft", tags = {"PimStafftype" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimstafftypes/getdraft")
    public ResponseEntity<PimStafftypeDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimstafftypeMapping.toDto(pimstafftypeService.getDraft(new PimStafftype())));
    }

    @PreAuthorize("hasPermission(this.pimstafftypeMapping.toDomain(#pimstafftypedto),'ehr-PimStafftype-Create')")
    @ApiOperation(value = "Create", tags = {"PimStafftype" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimstafftypes")
    @Transactional
    public ResponseEntity<PimStafftypeDTO> create(@RequestBody PimStafftypeDTO pimstafftypedto) {
        PimStafftype domain = pimstafftypeMapping.toDomain(pimstafftypedto);
		pimstafftypeService.create(domain);
        PimStafftypeDTO dto = pimstafftypeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimstafftypeMapping.toDomain(#pimstafftypedtos),'ehr-PimStafftype-Create')")
    @ApiOperation(value = "createBatch", tags = {"PimStafftype" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimstafftypes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimStafftypeDTO> pimstafftypedtos) {
        pimstafftypeService.createBatch(pimstafftypeMapping.toDomain(pimstafftypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimstafftypeService.get(#pimstafftype_id),'ehr-PimStafftype-Remove')")
    @ApiOperation(value = "Remove", tags = {"PimStafftype" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimstafftypes/{pimstafftype_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimstafftype_id") String pimstafftype_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimstafftypeService.remove(pimstafftype_id));
    }

    @PreAuthorize("hasPermission(this.pimstafftypeService.getPimstafftypeByIds(#ids),'ehr-PimStafftype-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PimStafftype" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimstafftypes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimstafftypeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimstafftypeMapping.toDomain(#pimstafftypedto),'ehr-PimStafftype-Save')")
    @ApiOperation(value = "Save", tags = {"PimStafftype" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimstafftypes/save")
    public ResponseEntity<Boolean> save(@RequestBody PimStafftypeDTO pimstafftypedto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimstafftypeService.save(pimstafftypeMapping.toDomain(pimstafftypedto)));
    }

    @PreAuthorize("hasPermission(this.pimstafftypeMapping.toDomain(#pimstafftypedtos),'ehr-PimStafftype-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PimStafftype" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimstafftypes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimStafftypeDTO> pimstafftypedtos) {
        pimstafftypeService.saveBatch(pimstafftypeMapping.toDomain(pimstafftypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimstafftypeService.get(#pimstafftype_id),'ehr-PimStafftype-Update')")
    @ApiOperation(value = "Update", tags = {"PimStafftype" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimstafftypes/{pimstafftype_id}")
    @Transactional
    public ResponseEntity<PimStafftypeDTO> update(@PathVariable("pimstafftype_id") String pimstafftype_id, @RequestBody PimStafftypeDTO pimstafftypedto) {
		PimStafftype domain  = pimstafftypeMapping.toDomain(pimstafftypedto);
        domain .setPimstafftypeid(pimstafftype_id);
		pimstafftypeService.update(domain );
		PimStafftypeDTO dto = pimstafftypeMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimstafftypeService.getPimstafftypeByEntities(this.pimstafftypeMapping.toDomain(#pimstafftypedtos)),'ehr-PimStafftype-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PimStafftype" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimstafftypes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimStafftypeDTO> pimstafftypedtos) {
        pimstafftypeService.updateBatch(pimstafftypeMapping.toDomain(pimstafftypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimStafftype-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PimStafftype" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimstafftypes/fetchdefault")
	public ResponseEntity<List<PimStafftypeDTO>> fetchDefault(PimStafftypeSearchContext context) {
        Page<PimStafftype> domains = pimstafftypeService.searchDefault(context) ;
        List<PimStafftypeDTO> list = pimstafftypeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimStafftype-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PimStafftype" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimstafftypes/searchdefault")
	public ResponseEntity<Page<PimStafftypeDTO>> searchDefault(@RequestBody PimStafftypeSearchContext context) {
        Page<PimStafftype> domains = pimstafftypeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimstafftypeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimStafftype-YPZ-all')")
	@ApiOperation(value = "fetch应聘者专用", tags = {"PimStafftype" } ,notes = "fetch应聘者专用")
    @RequestMapping(method= RequestMethod.GET , value="/pimstafftypes/fetchypz")
	public ResponseEntity<List<PimStafftypeDTO>> fetchYPZ(PimStafftypeSearchContext context) {
        Page<PimStafftype> domains = pimstafftypeService.searchYPZ(context) ;
        List<PimStafftypeDTO> list = pimstafftypeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimStafftype-YPZ-all')")
	@ApiOperation(value = "search应聘者专用", tags = {"PimStafftype" } ,notes = "search应聘者专用")
    @RequestMapping(method= RequestMethod.POST , value="/pimstafftypes/searchypz")
	public ResponseEntity<Page<PimStafftypeDTO>> searchYPZ(@RequestBody PimStafftypeSearchContext context) {
        Page<PimStafftype> domains = pimstafftypeService.searchYPZ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimstafftypeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

