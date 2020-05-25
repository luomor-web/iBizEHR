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
import cn.ibizlab.ehr.core.pim.domain.PIMMAJORSETYPE;
import cn.ibizlab.ehr.core.pim.service.IPIMMAJORSETYPEService;
import cn.ibizlab.ehr.core.pim.filter.PIMMAJORSETYPESearchContext;

@Slf4j
@Api(tags = {"PIMMAJORSETYPE" })
@RestController("WebApi-pimmajorsetype")
@RequestMapping("")
public class PIMMAJORSETYPEResource {

    @Autowired
    private IPIMMAJORSETYPEService pimmajorsetypeService;

    @Autowired
    @Lazy
    public PIMMAJORSETYPEMapping pimmajorsetypeMapping;

    public PIMMAJORSETYPEDTO permissionDTO=new PIMMAJORSETYPEDTO();

    @PreAuthorize("hasPermission(#pimmajorsetype_id,'Remove',{'Sql',this.pimmajorsetypeMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PIMMAJORSETYPE" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimmajorsetypes/{pimmajorsetype_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimmajorsetype_id") String pimmajorsetype_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimmajorsetypeService.remove(pimmajorsetype_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PIMMAJORSETYPE" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimmajorsetypes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimmajorsetypeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMMAJORSETYPE-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PIMMAJORSETYPE" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimmajorsetypes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMMAJORSETYPEDTO pimmajorsetypedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimmajorsetypeService.checkKey(pimmajorsetypeMapping.toDomain(pimmajorsetypedto)));
    }

    @PreAuthorize("hasPermission(#pimmajorsetype_id,'Get',{'Sql',this.pimmajorsetypeMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PIMMAJORSETYPE" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimmajorsetypes/{pimmajorsetype_id}")
    public ResponseEntity<PIMMAJORSETYPEDTO> get(@PathVariable("pimmajorsetype_id") String pimmajorsetype_id) {
        PIMMAJORSETYPE domain = pimmajorsetypeService.get(pimmajorsetype_id);
        PIMMAJORSETYPEDTO dto = pimmajorsetypeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.pimmajorsetypeMapping,#pimmajorsetypedto})")
    @ApiOperation(value = "Save", tags = {"PIMMAJORSETYPE" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimmajorsetypes/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMMAJORSETYPEDTO pimmajorsetypedto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimmajorsetypeService.save(pimmajorsetypeMapping.toDomain(pimmajorsetypedto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PIMMAJORSETYPE" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimmajorsetypes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMMAJORSETYPEDTO> pimmajorsetypedtos) {
        pimmajorsetypeService.saveBatch(pimmajorsetypeMapping.toDomain(pimmajorsetypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pimmajorsetypeMapping,#pimmajorsetypedto})")
    @ApiOperation(value = "Create", tags = {"PIMMAJORSETYPE" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimmajorsetypes")
    @Transactional
    public ResponseEntity<PIMMAJORSETYPEDTO> create(@RequestBody PIMMAJORSETYPEDTO pimmajorsetypedto) {
        PIMMAJORSETYPE domain = pimmajorsetypeMapping.toDomain(pimmajorsetypedto);
		pimmajorsetypeService.create(domain);
        PIMMAJORSETYPEDTO dto = pimmajorsetypeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"PIMMAJORSETYPE" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimmajorsetypes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMMAJORSETYPEDTO> pimmajorsetypedtos) {
        pimmajorsetypeService.createBatch(pimmajorsetypeMapping.toDomain(pimmajorsetypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMMAJORSETYPE-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PIMMAJORSETYPE" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimmajorsetypes/getdraft")
    public ResponseEntity<PIMMAJORSETYPEDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimmajorsetypeMapping.toDto(pimmajorsetypeService.getDraft(new PIMMAJORSETYPE())));
    }

    @PreAuthorize("hasPermission(#pimmajorsetype_id,'Update',{'Sql',this.pimmajorsetypeMapping,#pimmajorsetypedto})")
    @ApiOperation(value = "Update", tags = {"PIMMAJORSETYPE" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimmajorsetypes/{pimmajorsetype_id}")
    @Transactional
    public ResponseEntity<PIMMAJORSETYPEDTO> update(@PathVariable("pimmajorsetype_id") String pimmajorsetype_id, @RequestBody PIMMAJORSETYPEDTO pimmajorsetypedto) {
		PIMMAJORSETYPE domain = pimmajorsetypeMapping.toDomain(pimmajorsetypedto);
        domain.setPimmajorsetypeid(pimmajorsetype_id);
		pimmajorsetypeService.update(domain);
		PIMMAJORSETYPEDTO dto = pimmajorsetypeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMMAJORSETYPE" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimmajorsetypes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMMAJORSETYPEDTO> pimmajorsetypedtos) {
        pimmajorsetypeService.updateBatch(pimmajorsetypeMapping.toDomain(pimmajorsetypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMMAJORSETYPE-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMMAJORSETYPE" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimmajorsetypes/fetchdefault")
	public ResponseEntity<List<PIMMAJORSETYPEDTO>> fetchDefault(PIMMAJORSETYPESearchContext context) {
        Page<PIMMAJORSETYPE> domains = pimmajorsetypeService.searchDefault(context) ;
        List<PIMMAJORSETYPEDTO> list = pimmajorsetypeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMMAJORSETYPE-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMMAJORSETYPE" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimmajorsetypes/searchdefault")
	public ResponseEntity<Page<PIMMAJORSETYPEDTO>> searchDefault(@RequestBody PIMMAJORSETYPESearchContext context) {
        Page<PIMMAJORSETYPE> domains = pimmajorsetypeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimmajorsetypeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
