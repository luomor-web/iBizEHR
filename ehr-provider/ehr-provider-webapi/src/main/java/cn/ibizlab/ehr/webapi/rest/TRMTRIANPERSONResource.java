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
import cn.ibizlab.ehr.core.trm.domain.TRMTRIANPERSON;
import cn.ibizlab.ehr.core.trm.service.ITRMTRIANPERSONService;
import cn.ibizlab.ehr.core.trm.filter.TRMTRIANPERSONSearchContext;

@Slf4j
@Api(tags = {"TRMTRIANPERSON" })
@RestController("WebApi-trmtrianperson")
@RequestMapping("")
public class TRMTRIANPERSONResource {

    @Autowired
    private ITRMTRIANPERSONService trmtrianpersonService;

    @Autowired
    @Lazy
    public TRMTRIANPERSONMapping trmtrianpersonMapping;

    public TRMTRIANPERSONDTO permissionDTO=new TRMTRIANPERSONDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRIANPERSON-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"TRMTRIANPERSON" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrianpeople/getdraft")
    public ResponseEntity<TRMTRIANPERSONDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrianpersonMapping.toDto(trmtrianpersonService.getDraft(new TRMTRIANPERSON())));
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.trmtrianpersonMapping,#trmtrianpersondto})")
    @ApiOperation(value = "Save", tags = {"TRMTRIANPERSON" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrianpeople/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMTRIANPERSONDTO trmtrianpersondto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrianpersonService.save(trmtrianpersonMapping.toDomain(trmtrianpersondto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.trmtrianpersonMapping,#trmtrianpersondtos})")
    @ApiOperation(value = "SaveBatch", tags = {"TRMTRIANPERSON" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrianpeople/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMTRIANPERSONDTO> trmtrianpersondtos) {
        trmtrianpersonService.saveBatch(trmtrianpersonMapping.toDomain(trmtrianpersondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#trmtrianperson_id,'Remove',{'Sql',this.trmtrianpersonMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"TRMTRIANPERSON" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrianpeople/{trmtrianperson_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtrianperson_id") String trmtrianperson_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtrianpersonService.remove(trmtrianperson_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.trmtrianpersonMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"TRMTRIANPERSON" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrianpeople/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtrianpersonService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRIANPERSON-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"TRMTRIANPERSON" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrianpeople/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMTRIANPERSONDTO trmtrianpersondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrianpersonService.checkKey(trmtrianpersonMapping.toDomain(trmtrianpersondto)));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.trmtrianpersonMapping,#trmtrianpersondto})")
    @ApiOperation(value = "Create", tags = {"TRMTRIANPERSON" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrianpeople")
    @Transactional
    public ResponseEntity<TRMTRIANPERSONDTO> create(@RequestBody TRMTRIANPERSONDTO trmtrianpersondto) {
        TRMTRIANPERSON domain = trmtrianpersonMapping.toDomain(trmtrianpersondto);
		trmtrianpersonService.create(domain);
        TRMTRIANPERSONDTO dto = trmtrianpersonMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.trmtrianpersonMapping,#trmtrianpersondtos})")
    @ApiOperation(value = "createBatch", tags = {"TRMTRIANPERSON" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrianpeople/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMTRIANPERSONDTO> trmtrianpersondtos) {
        trmtrianpersonService.createBatch(trmtrianpersonMapping.toDomain(trmtrianpersondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#trmtrianperson_id,'Get',{'Sql',this.trmtrianpersonMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"TRMTRIANPERSON" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrianpeople/{trmtrianperson_id}")
    public ResponseEntity<TRMTRIANPERSONDTO> get(@PathVariable("trmtrianperson_id") String trmtrianperson_id) {
        TRMTRIANPERSON domain = trmtrianpersonService.get(trmtrianperson_id);
        TRMTRIANPERSONDTO dto = trmtrianpersonMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#trmtrianperson_id,'Update',{'Sql',this.trmtrianpersonMapping,#trmtrianpersondto})")
    @ApiOperation(value = "Update", tags = {"TRMTRIANPERSON" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrianpeople/{trmtrianperson_id}")
    @Transactional
    public ResponseEntity<TRMTRIANPERSONDTO> update(@PathVariable("trmtrianperson_id") String trmtrianperson_id, @RequestBody TRMTRIANPERSONDTO trmtrianpersondto) {
		TRMTRIANPERSON domain  = trmtrianpersonMapping.toDomain(trmtrianpersondto);
        domain .setTrmtrianpersonid(trmtrianperson_id);
		trmtrianpersonService.update(domain );
		TRMTRIANPERSONDTO dto = trmtrianpersonMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.trmtrianpersonMapping,#trmtrianpersondtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"TRMTRIANPERSON" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrianpeople/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMTRIANPERSONDTO> trmtrianpersondtos) {
        trmtrianpersonService.updateBatch(trmtrianpersonMapping.toDomain(trmtrianpersondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRIANPERSON-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TRMTRIANPERSON" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrianpeople/fetchdefault")
	public ResponseEntity<List<TRMTRIANPERSONDTO>> fetchDefault(TRMTRIANPERSONSearchContext context) {
        Page<TRMTRIANPERSON> domains = trmtrianpersonService.searchDefault(context) ;
        List<TRMTRIANPERSONDTO> list = trmtrianpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRIANPERSON-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TRMTRIANPERSON" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrianpeople/searchdefault")
	public ResponseEntity<Page<TRMTRIANPERSONDTO>> searchDefault(@RequestBody TRMTRIANPERSONSearchContext context) {
        Page<TRMTRIANPERSON> domains = trmtrianpersonService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrianpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRIANPERSON-GetDraft-all')")
    @ApiOperation(value = "GetDraftByPIMPERSON", tags = {"TRMTRIANPERSON" },  notes = "GetDraftByPIMPERSON")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/trmtrianpeople/getdraft")
    public ResponseEntity<TRMTRIANPERSONDTO> getDraftByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id) {
        TRMTRIANPERSON domain = new TRMTRIANPERSON();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrianpersonMapping.toDto(trmtrianpersonService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.trmtrianpersonMapping,#trmtrianpersondto})")
    @ApiOperation(value = "SaveByPIMPERSON", tags = {"TRMTRIANPERSON" },  notes = "SaveByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/trmtrianpeople/save")
    public ResponseEntity<Boolean> saveByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody TRMTRIANPERSONDTO trmtrianpersondto) {
        TRMTRIANPERSON domain = trmtrianpersonMapping.toDomain(trmtrianpersondto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrianpersonService.save(domain));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.trmtrianpersonMapping,#trmtrianpersondtos})")
    @ApiOperation(value = "SaveBatchByPIMPERSON", tags = {"TRMTRIANPERSON" },  notes = "SaveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/trmtrianpeople/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<TRMTRIANPERSONDTO> trmtrianpersondtos) {
        List<TRMTRIANPERSON> domainlist=trmtrianpersonMapping.toDomain(trmtrianpersondtos);
        for(TRMTRIANPERSON domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        trmtrianpersonService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#trmtrianperson_id,'Remove',{'Sql',this.trmtrianpersonMapping,this.permissionDTO})")
    @ApiOperation(value = "RemoveByPIMPERSON", tags = {"TRMTRIANPERSON" },  notes = "RemoveByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/trmtrianpeople/{trmtrianperson_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrianperson_id") String trmtrianperson_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmtrianpersonService.remove(trmtrianperson_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.trmtrianpersonMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatchByPIMPERSON", tags = {"TRMTRIANPERSON" },  notes = "RemoveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/trmtrianpeople/batch")
    public ResponseEntity<Boolean> removeBatchByPIMPERSON(@RequestBody List<String> ids) {
        trmtrianpersonService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRIANPERSON-CheckKey-all')")
    @ApiOperation(value = "CheckKeyByPIMPERSON", tags = {"TRMTRIANPERSON" },  notes = "CheckKeyByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/trmtrianpeople/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody TRMTRIANPERSONDTO trmtrianpersondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrianpersonService.checkKey(trmtrianpersonMapping.toDomain(trmtrianpersondto)));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.trmtrianpersonMapping,#trmtrianpersondto})")
    @ApiOperation(value = "CreateByPIMPERSON", tags = {"TRMTRIANPERSON" },  notes = "CreateByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/trmtrianpeople")
    @Transactional
    public ResponseEntity<TRMTRIANPERSONDTO> createByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody TRMTRIANPERSONDTO trmtrianpersondto) {
        TRMTRIANPERSON domain = trmtrianpersonMapping.toDomain(trmtrianpersondto);
        domain.setPimpersonid(pimperson_id);
		trmtrianpersonService.create(domain);
        TRMTRIANPERSONDTO dto = trmtrianpersonMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.trmtrianpersonMapping,#trmtrianpersondtos})")
    @ApiOperation(value = "createBatchByPIMPERSON", tags = {"TRMTRIANPERSON" },  notes = "createBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/trmtrianpeople/batch")
    public ResponseEntity<Boolean> createBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<TRMTRIANPERSONDTO> trmtrianpersondtos) {
        List<TRMTRIANPERSON> domainlist=trmtrianpersonMapping.toDomain(trmtrianpersondtos);
        for(TRMTRIANPERSON domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        trmtrianpersonService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#trmtrianperson_id,'Get',{'Sql',this.trmtrianpersonMapping,this.permissionDTO})")
    @ApiOperation(value = "GetByPIMPERSON", tags = {"TRMTRIANPERSON" },  notes = "GetByPIMPERSON")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/trmtrianpeople/{trmtrianperson_id}")
    public ResponseEntity<TRMTRIANPERSONDTO> getByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrianperson_id") String trmtrianperson_id) {
        TRMTRIANPERSON domain = trmtrianpersonService.get(trmtrianperson_id);
        TRMTRIANPERSONDTO dto = trmtrianpersonMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#trmtrianperson_id,'Update',{'Sql',this.trmtrianpersonMapping,#trmtrianpersondto})")
    @ApiOperation(value = "UpdateByPIMPERSON", tags = {"TRMTRIANPERSON" },  notes = "UpdateByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/trmtrianpeople/{trmtrianperson_id}")
    @Transactional
    public ResponseEntity<TRMTRIANPERSONDTO> updateByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrianperson_id") String trmtrianperson_id, @RequestBody TRMTRIANPERSONDTO trmtrianpersondto) {
        TRMTRIANPERSON domain = trmtrianpersonMapping.toDomain(trmtrianpersondto);
        domain.setPimpersonid(pimperson_id);
        domain.setTrmtrianpersonid(trmtrianperson_id);
		trmtrianpersonService.update(domain);
        TRMTRIANPERSONDTO dto = trmtrianpersonMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.trmtrianpersonMapping,#trmtrianpersondtos})")
    @ApiOperation(value = "UpdateBatchByPIMPERSON", tags = {"TRMTRIANPERSON" },  notes = "UpdateBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/trmtrianpeople/batch")
    public ResponseEntity<Boolean> updateBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<TRMTRIANPERSONDTO> trmtrianpersondtos) {
        List<TRMTRIANPERSON> domainlist=trmtrianpersonMapping.toDomain(trmtrianpersondtos);
        for(TRMTRIANPERSON domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        trmtrianpersonService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRIANPERSON-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPIMPERSON", tags = {"TRMTRIANPERSON" } ,notes = "fetchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/trmtrianpeople/fetchdefault")
	public ResponseEntity<List<TRMTRIANPERSONDTO>> fetchTRMTRIANPERSONDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,TRMTRIANPERSONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<TRMTRIANPERSON> domains = trmtrianpersonService.searchDefault(context) ;
        List<TRMTRIANPERSONDTO> list = trmtrianpersonMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRIANPERSON-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPIMPERSON", tags = {"TRMTRIANPERSON" } ,notes = "searchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/trmtrianpeople/searchdefault")
	public ResponseEntity<Page<TRMTRIANPERSONDTO>> searchTRMTRIANPERSONDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody TRMTRIANPERSONSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<TRMTRIANPERSON> domains = trmtrianpersonService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrianpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
