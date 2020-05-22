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
import cn.ibizlab.ehr.core.pim.domain.PIMPROVINCE;
import cn.ibizlab.ehr.core.pim.service.IPIMPROVINCEService;
import cn.ibizlab.ehr.core.pim.filter.PIMPROVINCESearchContext;




@Slf4j
@Api(tags = {"PIMPROVINCE" })
@RestController("WebApi-pimprovince")
@RequestMapping("")
public class PIMPROVINCEResource {

    @Autowired
    private IPIMPROVINCEService pimprovinceService;

    @Autowired
    @Lazy
    public PIMPROVINCEMapping pimprovinceMapping;

    public PIMPROVINCEDTO permissionDTO=new PIMPROVINCEDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPROVINCE-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PIMPROVINCE" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimprovinces/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMPROVINCEDTO pimprovincedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimprovinceService.checkKey(pimprovinceMapping.toDomain(pimprovincedto)));
    }

    @PreAuthorize("hasPermission(#pimprovince_id,'Remove',{'Sql',this.pimprovinceMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PIMPROVINCE" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimprovinces/{pimprovince_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimprovince_id") String pimprovince_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimprovinceService.remove(pimprovince_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PIMPROVINCE" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimprovinces/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimprovinceService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pimprovince_id,'Get',{'Sql',this.pimprovinceMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PIMPROVINCE" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimprovinces/{pimprovince_id}")
    public ResponseEntity<PIMPROVINCEDTO> get(@PathVariable("pimprovince_id") String pimprovince_id) {
        PIMPROVINCE domain = pimprovinceService.get(pimprovince_id);
        PIMPROVINCEDTO dto = pimprovinceMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pimprovinceMapping,#pimprovincedto})")
    @ApiOperation(value = "Create", tags = {"PIMPROVINCE" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimprovinces")
    @Transactional
    public ResponseEntity<PIMPROVINCEDTO> create(@RequestBody PIMPROVINCEDTO pimprovincedto) {
        PIMPROVINCE domain = pimprovinceMapping.toDomain(pimprovincedto);
		pimprovinceService.create(domain);
        PIMPROVINCEDTO dto = pimprovinceMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"PIMPROVINCE" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimprovinces/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMPROVINCEDTO> pimprovincedtos) {
        pimprovinceService.createBatch(pimprovinceMapping.toDomain(pimprovincedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPROVINCE-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PIMPROVINCE" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimprovinces/getdraft")
    public ResponseEntity<PIMPROVINCEDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimprovinceMapping.toDto(pimprovinceService.getDraft(new PIMPROVINCE())));
    }

    @PreAuthorize("hasPermission(#pimprovince_id,'Update',{'Sql',this.pimprovinceMapping,#pimprovincedto})")
    @ApiOperation(value = "Update", tags = {"PIMPROVINCE" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimprovinces/{pimprovince_id}")
    @Transactional
    public ResponseEntity<PIMPROVINCEDTO> update(@PathVariable("pimprovince_id") String pimprovince_id, @RequestBody PIMPROVINCEDTO pimprovincedto) {
		PIMPROVINCE domain = pimprovinceMapping.toDomain(pimprovincedto);
        domain.setPimprovinceid(pimprovince_id);
		pimprovinceService.update(domain);
		PIMPROVINCEDTO dto = pimprovinceMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMPROVINCE" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimprovinces/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMPROVINCEDTO> pimprovincedtos) {
        pimprovinceService.updateBatch(pimprovinceMapping.toDomain(pimprovincedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPROVINCE-Save-all')")
    @ApiOperation(value = "Save", tags = {"PIMPROVINCE" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimprovinces/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMPROVINCEDTO pimprovincedto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimprovinceService.save(pimprovinceMapping.toDomain(pimprovincedto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PIMPROVINCE" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimprovinces/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMPROVINCEDTO> pimprovincedtos) {
        pimprovinceService.saveBatch(pimprovinceMapping.toDomain(pimprovincedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPROVINCE-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMPROVINCE" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimprovinces/fetchdefault")
	public ResponseEntity<List<PIMPROVINCEDTO>> fetchDefault(PIMPROVINCESearchContext context) {
        Page<PIMPROVINCE> domains = pimprovinceService.searchDefault(context) ;
        List<PIMPROVINCEDTO> list = pimprovinceMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMPROVINCE-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMPROVINCE" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimprovinces/searchdefault")
	public ResponseEntity<Page<PIMPROVINCEDTO>> searchDefault(@RequestBody PIMPROVINCESearchContext context) {
        Page<PIMPROVINCE> domains = pimprovinceService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimprovinceMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
