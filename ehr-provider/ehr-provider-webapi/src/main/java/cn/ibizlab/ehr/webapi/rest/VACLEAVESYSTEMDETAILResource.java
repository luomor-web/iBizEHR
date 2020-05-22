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
import cn.ibizlab.ehr.core.vac.domain.VACLEAVESYSTEMDETAIL;
import cn.ibizlab.ehr.core.vac.service.IVACLEAVESYSTEMDETAILService;
import cn.ibizlab.ehr.core.vac.filter.VACLEAVESYSTEMDETAILSearchContext;




@Slf4j
@Api(tags = {"VACLEAVESYSTEMDETAIL" })
@RestController("WebApi-vacleavesystemdetail")
@RequestMapping("")
public class VACLEAVESYSTEMDETAILResource {

    @Autowired
    private IVACLEAVESYSTEMDETAILService vacleavesystemdetailService;

    @Autowired
    @Lazy
    public VACLEAVESYSTEMDETAILMapping vacleavesystemdetailMapping;

    public VACLEAVESYSTEMDETAILDTO permissionDTO=new VACLEAVESYSTEMDETAILDTO();

    @PreAuthorize("hasPermission(#vacleavesystemdetail_id,'Update',{'Sql',this.vacleavesystemdetailMapping,#vacleavesystemdetaildto})")
    @ApiOperation(value = "Update", tags = {"VACLEAVESYSTEMDETAIL" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacleavesystemdetails/{vacleavesystemdetail_id}")
    @Transactional
    public ResponseEntity<VACLEAVESYSTEMDETAILDTO> update(@PathVariable("vacleavesystemdetail_id") String vacleavesystemdetail_id, @RequestBody VACLEAVESYSTEMDETAILDTO vacleavesystemdetaildto) {
		VACLEAVESYSTEMDETAIL domain = vacleavesystemdetailMapping.toDomain(vacleavesystemdetaildto);
        domain.setVacleavesystemdetailid(vacleavesystemdetail_id);
		vacleavesystemdetailService.update(domain);
		VACLEAVESYSTEMDETAILDTO dto = vacleavesystemdetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"VACLEAVESYSTEMDETAIL" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacleavesystemdetails/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VACLEAVESYSTEMDETAILDTO> vacleavesystemdetaildtos) {
        vacleavesystemdetailService.updateBatch(vacleavesystemdetailMapping.toDomain(vacleavesystemdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVESYSTEMDETAIL-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"VACLEAVESYSTEMDETAIL" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavesystemdetails/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VACLEAVESYSTEMDETAILDTO vacleavesystemdetaildto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacleavesystemdetailService.checkKey(vacleavesystemdetailMapping.toDomain(vacleavesystemdetaildto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVESYSTEMDETAIL-Save-all')")
    @ApiOperation(value = "Save", tags = {"VACLEAVESYSTEMDETAIL" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavesystemdetails/save")
    public ResponseEntity<Boolean> save(@RequestBody VACLEAVESYSTEMDETAILDTO vacleavesystemdetaildto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacleavesystemdetailService.save(vacleavesystemdetailMapping.toDomain(vacleavesystemdetaildto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"VACLEAVESYSTEMDETAIL" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavesystemdetails/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VACLEAVESYSTEMDETAILDTO> vacleavesystemdetaildtos) {
        vacleavesystemdetailService.saveBatch(vacleavesystemdetailMapping.toDomain(vacleavesystemdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#vacleavesystemdetail_id,'Remove',{'Sql',this.vacleavesystemdetailMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"VACLEAVESYSTEMDETAIL" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacleavesystemdetails/{vacleavesystemdetail_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacleavesystemdetail_id") String vacleavesystemdetail_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacleavesystemdetailService.remove(vacleavesystemdetail_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"VACLEAVESYSTEMDETAIL" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacleavesystemdetails/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacleavesystemdetailService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVESYSTEMDETAIL-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"VACLEAVESYSTEMDETAIL" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/vacleavesystemdetails/getdraft")
    public ResponseEntity<VACLEAVESYSTEMDETAILDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacleavesystemdetailMapping.toDto(vacleavesystemdetailService.getDraft(new VACLEAVESYSTEMDETAIL())));
    }

    @PreAuthorize("hasPermission(#vacleavesystemdetail_id,'Get',{'Sql',this.vacleavesystemdetailMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"VACLEAVESYSTEMDETAIL" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/vacleavesystemdetails/{vacleavesystemdetail_id}")
    public ResponseEntity<VACLEAVESYSTEMDETAILDTO> get(@PathVariable("vacleavesystemdetail_id") String vacleavesystemdetail_id) {
        VACLEAVESYSTEMDETAIL domain = vacleavesystemdetailService.get(vacleavesystemdetail_id);
        VACLEAVESYSTEMDETAILDTO dto = vacleavesystemdetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.vacleavesystemdetailMapping,#vacleavesystemdetaildto})")
    @ApiOperation(value = "Create", tags = {"VACLEAVESYSTEMDETAIL" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavesystemdetails")
    @Transactional
    public ResponseEntity<VACLEAVESYSTEMDETAILDTO> create(@RequestBody VACLEAVESYSTEMDETAILDTO vacleavesystemdetaildto) {
        VACLEAVESYSTEMDETAIL domain = vacleavesystemdetailMapping.toDomain(vacleavesystemdetaildto);
		vacleavesystemdetailService.create(domain);
        VACLEAVESYSTEMDETAILDTO dto = vacleavesystemdetailMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"VACLEAVESYSTEMDETAIL" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacleavesystemdetails/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VACLEAVESYSTEMDETAILDTO> vacleavesystemdetaildtos) {
        vacleavesystemdetailService.createBatch(vacleavesystemdetailMapping.toDomain(vacleavesystemdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVESYSTEMDETAIL-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"VACLEAVESYSTEMDETAIL" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacleavesystemdetails/fetchdefault")
	public ResponseEntity<List<VACLEAVESYSTEMDETAILDTO>> fetchDefault(VACLEAVESYSTEMDETAILSearchContext context) {
        Page<VACLEAVESYSTEMDETAIL> domains = vacleavesystemdetailService.searchDefault(context) ;
        List<VACLEAVESYSTEMDETAILDTO> list = vacleavesystemdetailMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACLEAVESYSTEMDETAIL-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"VACLEAVESYSTEMDETAIL" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacleavesystemdetails/searchdefault")
	public ResponseEntity<Page<VACLEAVESYSTEMDETAILDTO>> searchDefault(@RequestBody VACLEAVESYSTEMDETAILSearchContext context) {
        Page<VACLEAVESYSTEMDETAIL> domains = vacleavesystemdetailService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacleavesystemdetailMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
