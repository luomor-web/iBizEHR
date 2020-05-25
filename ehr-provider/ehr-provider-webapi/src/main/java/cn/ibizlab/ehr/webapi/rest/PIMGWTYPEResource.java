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
import cn.ibizlab.ehr.core.pim.domain.PIMGWTYPE;
import cn.ibizlab.ehr.core.pim.service.IPIMGWTYPEService;
import cn.ibizlab.ehr.core.pim.filter.PIMGWTYPESearchContext;

@Slf4j
@Api(tags = {"PIMGWTYPE" })
@RestController("WebApi-pimgwtype")
@RequestMapping("")
public class PIMGWTYPEResource {

    @Autowired
    private IPIMGWTYPEService pimgwtypeService;

    @Autowired
    @Lazy
    public PIMGWTYPEMapping pimgwtypeMapping;

    public PIMGWTYPEDTO permissionDTO=new PIMGWTYPEDTO();

    @PreAuthorize("hasPermission('','Save',{'Sql',this.pimgwtypeMapping,#pimgwtypedto})")
    @ApiOperation(value = "Save", tags = {"PIMGWTYPE" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimgwtypes/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMGWTYPEDTO pimgwtypedto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimgwtypeService.save(pimgwtypeMapping.toDomain(pimgwtypedto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PIMGWTYPE" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimgwtypes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMGWTYPEDTO> pimgwtypedtos) {
        pimgwtypeService.saveBatch(pimgwtypeMapping.toDomain(pimgwtypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMGWTYPE-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PIMGWTYPE" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimgwtypes/getdraft")
    public ResponseEntity<PIMGWTYPEDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimgwtypeMapping.toDto(pimgwtypeService.getDraft(new PIMGWTYPE())));
    }

    @PreAuthorize("hasPermission(#pimgwtype_id,'Get',{'Sql',this.pimgwtypeMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PIMGWTYPE" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimgwtypes/{pimgwtype_id}")
    public ResponseEntity<PIMGWTYPEDTO> get(@PathVariable("pimgwtype_id") String pimgwtype_id) {
        PIMGWTYPE domain = pimgwtypeService.get(pimgwtype_id);
        PIMGWTYPEDTO dto = pimgwtypeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pimgwtype_id,'Remove',{'Sql',this.pimgwtypeMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PIMGWTYPE" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimgwtypes/{pimgwtype_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimgwtype_id") String pimgwtype_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimgwtypeService.remove(pimgwtype_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PIMGWTYPE" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimgwtypes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimgwtypeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMGWTYPE-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PIMGWTYPE" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimgwtypes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMGWTYPEDTO pimgwtypedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimgwtypeService.checkKey(pimgwtypeMapping.toDomain(pimgwtypedto)));
    }

    @PreAuthorize("hasPermission(#pimgwtype_id,'Update',{'Sql',this.pimgwtypeMapping,#pimgwtypedto})")
    @ApiOperation(value = "Update", tags = {"PIMGWTYPE" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimgwtypes/{pimgwtype_id}")
    @Transactional
    public ResponseEntity<PIMGWTYPEDTO> update(@PathVariable("pimgwtype_id") String pimgwtype_id, @RequestBody PIMGWTYPEDTO pimgwtypedto) {
		PIMGWTYPE domain = pimgwtypeMapping.toDomain(pimgwtypedto);
        domain.setPimgwtypeid(pimgwtype_id);
		pimgwtypeService.update(domain);
		PIMGWTYPEDTO dto = pimgwtypeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMGWTYPE" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimgwtypes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMGWTYPEDTO> pimgwtypedtos) {
        pimgwtypeService.updateBatch(pimgwtypeMapping.toDomain(pimgwtypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pimgwtypeMapping,#pimgwtypedto})")
    @ApiOperation(value = "Create", tags = {"PIMGWTYPE" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimgwtypes")
    @Transactional
    public ResponseEntity<PIMGWTYPEDTO> create(@RequestBody PIMGWTYPEDTO pimgwtypedto) {
        PIMGWTYPE domain = pimgwtypeMapping.toDomain(pimgwtypedto);
		pimgwtypeService.create(domain);
        PIMGWTYPEDTO dto = pimgwtypeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"PIMGWTYPE" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimgwtypes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMGWTYPEDTO> pimgwtypedtos) {
        pimgwtypeService.createBatch(pimgwtypeMapping.toDomain(pimgwtypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMGWTYPE-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMGWTYPE" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimgwtypes/fetchdefault")
	public ResponseEntity<List<PIMGWTYPEDTO>> fetchDefault(PIMGWTYPESearchContext context) {
        Page<PIMGWTYPE> domains = pimgwtypeService.searchDefault(context) ;
        List<PIMGWTYPEDTO> list = pimgwtypeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMGWTYPE-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMGWTYPE" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimgwtypes/searchdefault")
	public ResponseEntity<Page<PIMGWTYPEDTO>> searchDefault(@RequestBody PIMGWTYPESearchContext context) {
        Page<PIMGWTYPE> domains = pimgwtypeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimgwtypeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
