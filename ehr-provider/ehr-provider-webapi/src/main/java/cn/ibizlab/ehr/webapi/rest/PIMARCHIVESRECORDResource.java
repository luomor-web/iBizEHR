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
import cn.ibizlab.ehr.core.pim.domain.PIMARCHIVESRECORD;
import cn.ibizlab.ehr.core.pim.service.IPIMARCHIVESRECORDService;
import cn.ibizlab.ehr.core.pim.filter.PIMARCHIVESRECORDSearchContext;

@Slf4j
@Api(tags = {"PIMARCHIVESRECORD" })
@RestController("WebApi-pimarchivesrecord")
@RequestMapping("")
public class PIMARCHIVESRECORDResource {

    @Autowired
    private IPIMARCHIVESRECORDService pimarchivesrecordService;

    @Autowired
    @Lazy
    public PIMARCHIVESRECORDMapping pimarchivesrecordMapping;

    public PIMARCHIVESRECORDDTO permissionDTO=new PIMARCHIVESRECORDDTO();

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pimarchivesrecordMapping,#pimarchivesrecorddto})")
    @ApiOperation(value = "Create", tags = {"PIMARCHIVESRECORD" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchivesrecords")
    @Transactional
    public ResponseEntity<PIMARCHIVESRECORDDTO> create(@RequestBody PIMARCHIVESRECORDDTO pimarchivesrecorddto) {
        PIMARCHIVESRECORD domain = pimarchivesrecordMapping.toDomain(pimarchivesrecorddto);
		pimarchivesrecordService.create(domain);
        PIMARCHIVESRECORDDTO dto = pimarchivesrecordMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.pimarchivesrecordMapping,#pimarchivesrecorddtos})")
    @ApiOperation(value = "createBatch", tags = {"PIMARCHIVESRECORD" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchivesrecords/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMARCHIVESRECORDDTO> pimarchivesrecorddtos) {
        pimarchivesrecordService.createBatch(pimarchivesrecordMapping.toDomain(pimarchivesrecorddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.pimarchivesrecordMapping,#pimarchivesrecorddto})")
    @ApiOperation(value = "Save", tags = {"PIMARCHIVESRECORD" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchivesrecords/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMARCHIVESRECORDDTO pimarchivesrecorddto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesrecordService.save(pimarchivesrecordMapping.toDomain(pimarchivesrecorddto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.pimarchivesrecordMapping,#pimarchivesrecorddtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PIMARCHIVESRECORD" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchivesrecords/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMARCHIVESRECORDDTO> pimarchivesrecorddtos) {
        pimarchivesrecordService.saveBatch(pimarchivesrecordMapping.toDomain(pimarchivesrecorddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pimarchivesrecord_id,'Update',{'Sql',this.pimarchivesrecordMapping,#pimarchivesrecorddto})")
    @ApiOperation(value = "Update", tags = {"PIMARCHIVESRECORD" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchivesrecords/{pimarchivesrecord_id}")
    @Transactional
    public ResponseEntity<PIMARCHIVESRECORDDTO> update(@PathVariable("pimarchivesrecord_id") String pimarchivesrecord_id, @RequestBody PIMARCHIVESRECORDDTO pimarchivesrecorddto) {
		PIMARCHIVESRECORD domain  = pimarchivesrecordMapping.toDomain(pimarchivesrecorddto);
        domain .setPimarchivesrecordid(pimarchivesrecord_id);
		pimarchivesrecordService.update(domain );
		PIMARCHIVESRECORDDTO dto = pimarchivesrecordMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.pimarchivesrecordMapping,#pimarchivesrecorddtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMARCHIVESRECORD" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchivesrecords/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMARCHIVESRECORDDTO> pimarchivesrecorddtos) {
        pimarchivesrecordService.updateBatch(pimarchivesrecordMapping.toDomain(pimarchivesrecorddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESRECORD-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PIMARCHIVESRECORD" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchivesrecords/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMARCHIVESRECORDDTO pimarchivesrecorddto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimarchivesrecordService.checkKey(pimarchivesrecordMapping.toDomain(pimarchivesrecorddto)));
    }

    @PreAuthorize("hasPermission(#pimarchivesrecord_id,'Get',{'Sql',this.pimarchivesrecordMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PIMARCHIVESRECORD" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarchivesrecords/{pimarchivesrecord_id}")
    public ResponseEntity<PIMARCHIVESRECORDDTO> get(@PathVariable("pimarchivesrecord_id") String pimarchivesrecord_id) {
        PIMARCHIVESRECORD domain = pimarchivesrecordService.get(pimarchivesrecord_id);
        PIMARCHIVESRECORDDTO dto = pimarchivesrecordMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESRECORD-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PIMARCHIVESRECORD" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarchivesrecords/getdraft")
    public ResponseEntity<PIMARCHIVESRECORDDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesrecordMapping.toDto(pimarchivesrecordService.getDraft(new PIMARCHIVESRECORD())));
    }

    @PreAuthorize("hasPermission(#pimarchivesrecord_id,'Remove',{'Sql',this.pimarchivesrecordMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PIMARCHIVESRECORD" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchivesrecords/{pimarchivesrecord_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimarchivesrecord_id") String pimarchivesrecord_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimarchivesrecordService.remove(pimarchivesrecord_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.pimarchivesrecordMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PIMARCHIVESRECORD" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchivesrecords/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimarchivesrecordService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESRECORD-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMARCHIVESRECORD" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimarchivesrecords/fetchdefault")
	public ResponseEntity<List<PIMARCHIVESRECORDDTO>> fetchDefault(PIMARCHIVESRECORDSearchContext context) {
        Page<PIMARCHIVESRECORD> domains = pimarchivesrecordService.searchDefault(context) ;
        List<PIMARCHIVESRECORDDTO> list = pimarchivesrecordMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESRECORD-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMARCHIVESRECORD" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchivesrecords/searchdefault")
	public ResponseEntity<Page<PIMARCHIVESRECORDDTO>> searchDefault(@RequestBody PIMARCHIVESRECORDSearchContext context) {
        Page<PIMARCHIVESRECORD> domains = pimarchivesrecordService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesrecordMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission('','Create',{'Sql',this.pimarchivesrecordMapping,#pimarchivesrecorddto})")
    @ApiOperation(value = "CreateByPIMARCHIVES", tags = {"PIMARCHIVESRECORD" },  notes = "CreateByPIMARCHIVES")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchivesrecords")
    @Transactional
    public ResponseEntity<PIMARCHIVESRECORDDTO> createByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESRECORDDTO pimarchivesrecorddto) {
        PIMARCHIVESRECORD domain = pimarchivesrecordMapping.toDomain(pimarchivesrecorddto);
        domain.setPimarchivesid(pimarchives_id);
		pimarchivesrecordService.create(domain);
        PIMARCHIVESRECORDDTO dto = pimarchivesrecordMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.pimarchivesrecordMapping,#pimarchivesrecorddtos})")
    @ApiOperation(value = "createBatchByPIMARCHIVES", tags = {"PIMARCHIVESRECORD" },  notes = "createBatchByPIMARCHIVES")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchivesrecords/batch")
    public ResponseEntity<Boolean> createBatchByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PIMARCHIVESRECORDDTO> pimarchivesrecorddtos) {
        List<PIMARCHIVESRECORD> domainlist=pimarchivesrecordMapping.toDomain(pimarchivesrecorddtos);
        for(PIMARCHIVESRECORD domain:domainlist){
            domain.setPimarchivesid(pimarchives_id);
        }
        pimarchivesrecordService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.pimarchivesrecordMapping,#pimarchivesrecorddto})")
    @ApiOperation(value = "SaveByPIMARCHIVES", tags = {"PIMARCHIVESRECORD" },  notes = "SaveByPIMARCHIVES")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchivesrecords/save")
    public ResponseEntity<Boolean> saveByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESRECORDDTO pimarchivesrecorddto) {
        PIMARCHIVESRECORD domain = pimarchivesrecordMapping.toDomain(pimarchivesrecorddto);
        domain.setPimarchivesid(pimarchives_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesrecordService.save(domain));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.pimarchivesrecordMapping,#pimarchivesrecorddtos})")
    @ApiOperation(value = "SaveBatchByPIMARCHIVES", tags = {"PIMARCHIVESRECORD" },  notes = "SaveBatchByPIMARCHIVES")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchivesrecords/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PIMARCHIVESRECORDDTO> pimarchivesrecorddtos) {
        List<PIMARCHIVESRECORD> domainlist=pimarchivesrecordMapping.toDomain(pimarchivesrecorddtos);
        for(PIMARCHIVESRECORD domain:domainlist){
             domain.setPimarchivesid(pimarchives_id);
        }
        pimarchivesrecordService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pimarchivesrecord_id,'Update',{'Sql',this.pimarchivesrecordMapping,#pimarchivesrecorddto})")
    @ApiOperation(value = "UpdateByPIMARCHIVES", tags = {"PIMARCHIVESRECORD" },  notes = "UpdateByPIMARCHIVES")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchives/{pimarchives_id}/pimarchivesrecords/{pimarchivesrecord_id}")
    @Transactional
    public ResponseEntity<PIMARCHIVESRECORDDTO> updateByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchivesrecord_id") String pimarchivesrecord_id, @RequestBody PIMARCHIVESRECORDDTO pimarchivesrecorddto) {
        PIMARCHIVESRECORD domain = pimarchivesrecordMapping.toDomain(pimarchivesrecorddto);
        domain.setPimarchivesid(pimarchives_id);
        domain.setPimarchivesrecordid(pimarchivesrecord_id);
		pimarchivesrecordService.update(domain);
        PIMARCHIVESRECORDDTO dto = pimarchivesrecordMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.pimarchivesrecordMapping,#pimarchivesrecorddtos})")
    @ApiOperation(value = "UpdateBatchByPIMARCHIVES", tags = {"PIMARCHIVESRECORD" },  notes = "UpdateBatchByPIMARCHIVES")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchives/{pimarchives_id}/pimarchivesrecords/batch")
    public ResponseEntity<Boolean> updateBatchByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PIMARCHIVESRECORDDTO> pimarchivesrecorddtos) {
        List<PIMARCHIVESRECORD> domainlist=pimarchivesrecordMapping.toDomain(pimarchivesrecorddtos);
        for(PIMARCHIVESRECORD domain:domainlist){
            domain.setPimarchivesid(pimarchives_id);
        }
        pimarchivesrecordService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESRECORD-CheckKey-all')")
    @ApiOperation(value = "CheckKeyByPIMARCHIVES", tags = {"PIMARCHIVESRECORD" },  notes = "CheckKeyByPIMARCHIVES")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchivesrecords/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESRECORDDTO pimarchivesrecorddto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimarchivesrecordService.checkKey(pimarchivesrecordMapping.toDomain(pimarchivesrecorddto)));
    }

    @PreAuthorize("hasPermission(#pimarchivesrecord_id,'Get',{'Sql',this.pimarchivesrecordMapping,this.permissionDTO})")
    @ApiOperation(value = "GetByPIMARCHIVES", tags = {"PIMARCHIVESRECORD" },  notes = "GetByPIMARCHIVES")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarchives/{pimarchives_id}/pimarchivesrecords/{pimarchivesrecord_id}")
    public ResponseEntity<PIMARCHIVESRECORDDTO> getByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchivesrecord_id") String pimarchivesrecord_id) {
        PIMARCHIVESRECORD domain = pimarchivesrecordService.get(pimarchivesrecord_id);
        PIMARCHIVESRECORDDTO dto = pimarchivesrecordMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESRECORD-GetDraft-all')")
    @ApiOperation(value = "GetDraftByPIMARCHIVES", tags = {"PIMARCHIVESRECORD" },  notes = "GetDraftByPIMARCHIVES")
    @RequestMapping(method = RequestMethod.GET, value = "/pimarchives/{pimarchives_id}/pimarchivesrecords/getdraft")
    public ResponseEntity<PIMARCHIVESRECORDDTO> getDraftByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id) {
        PIMARCHIVESRECORD domain = new PIMARCHIVESRECORD();
        domain.setPimarchivesid(pimarchives_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesrecordMapping.toDto(pimarchivesrecordService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(#pimarchivesrecord_id,'Remove',{'Sql',this.pimarchivesrecordMapping,this.permissionDTO})")
    @ApiOperation(value = "RemoveByPIMARCHIVES", tags = {"PIMARCHIVESRECORD" },  notes = "RemoveByPIMARCHIVES")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchives/{pimarchives_id}/pimarchivesrecords/{pimarchivesrecord_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchivesrecord_id") String pimarchivesrecord_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimarchivesrecordService.remove(pimarchivesrecord_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.pimarchivesrecordMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatchByPIMARCHIVES", tags = {"PIMARCHIVESRECORD" },  notes = "RemoveBatchByPIMARCHIVES")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchives/{pimarchives_id}/pimarchivesrecords/batch")
    public ResponseEntity<Boolean> removeBatchByPIMARCHIVES(@RequestBody List<String> ids) {
        pimarchivesrecordService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESRECORD-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPIMARCHIVES", tags = {"PIMARCHIVESRECORD" } ,notes = "fetchDEFAULTByPIMARCHIVES")
    @RequestMapping(method= RequestMethod.GET , value="/pimarchives/{pimarchives_id}/pimarchivesrecords/fetchdefault")
	public ResponseEntity<List<PIMARCHIVESRECORDDTO>> fetchPIMARCHIVESRECORDDefaultByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id,PIMARCHIVESRECORDSearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PIMARCHIVESRECORD> domains = pimarchivesrecordService.searchDefault(context) ;
        List<PIMARCHIVESRECORDDTO> list = pimarchivesrecordMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESRECORD-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPIMARCHIVES", tags = {"PIMARCHIVESRECORD" } ,notes = "searchDEFAULTByPIMARCHIVES")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchives/{pimarchives_id}/pimarchivesrecords/searchdefault")
	public ResponseEntity<Page<PIMARCHIVESRECORDDTO>> searchPIMARCHIVESRECORDDefaultByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESRECORDSearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PIMARCHIVESRECORD> domains = pimarchivesrecordService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesrecordMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission('','Create',{'Sql',this.pimarchivesrecordMapping,#pimarchivesrecorddto})")
    @ApiOperation(value = "CreateByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESRECORD" },  notes = "CreateByPIMPERSONPIMARCHIVES")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesrecords")
    @Transactional
    public ResponseEntity<PIMARCHIVESRECORDDTO> createByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESRECORDDTO pimarchivesrecorddto) {
        PIMARCHIVESRECORD domain = pimarchivesrecordMapping.toDomain(pimarchivesrecorddto);
        domain.setPimarchivesid(pimarchives_id);
		pimarchivesrecordService.create(domain);
        PIMARCHIVESRECORDDTO dto = pimarchivesrecordMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.pimarchivesrecordMapping,#pimarchivesrecorddtos})")
    @ApiOperation(value = "createBatchByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESRECORD" },  notes = "createBatchByPIMPERSONPIMARCHIVES")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesrecords/batch")
    public ResponseEntity<Boolean> createBatchByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PIMARCHIVESRECORDDTO> pimarchivesrecorddtos) {
        List<PIMARCHIVESRECORD> domainlist=pimarchivesrecordMapping.toDomain(pimarchivesrecorddtos);
        for(PIMARCHIVESRECORD domain:domainlist){
            domain.setPimarchivesid(pimarchives_id);
        }
        pimarchivesrecordService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.pimarchivesrecordMapping,#pimarchivesrecorddto})")
    @ApiOperation(value = "SaveByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESRECORD" },  notes = "SaveByPIMPERSONPIMARCHIVES")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesrecords/save")
    public ResponseEntity<Boolean> saveByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESRECORDDTO pimarchivesrecorddto) {
        PIMARCHIVESRECORD domain = pimarchivesrecordMapping.toDomain(pimarchivesrecorddto);
        domain.setPimarchivesid(pimarchives_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesrecordService.save(domain));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.pimarchivesrecordMapping,#pimarchivesrecorddtos})")
    @ApiOperation(value = "SaveBatchByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESRECORD" },  notes = "SaveBatchByPIMPERSONPIMARCHIVES")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesrecords/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PIMARCHIVESRECORDDTO> pimarchivesrecorddtos) {
        List<PIMARCHIVESRECORD> domainlist=pimarchivesrecordMapping.toDomain(pimarchivesrecorddtos);
        for(PIMARCHIVESRECORD domain:domainlist){
             domain.setPimarchivesid(pimarchives_id);
        }
        pimarchivesrecordService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pimarchivesrecord_id,'Update',{'Sql',this.pimarchivesrecordMapping,#pimarchivesrecorddto})")
    @ApiOperation(value = "UpdateByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESRECORD" },  notes = "UpdateByPIMPERSONPIMARCHIVES")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesrecords/{pimarchivesrecord_id}")
    @Transactional
    public ResponseEntity<PIMARCHIVESRECORDDTO> updateByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchivesrecord_id") String pimarchivesrecord_id, @RequestBody PIMARCHIVESRECORDDTO pimarchivesrecorddto) {
        PIMARCHIVESRECORD domain = pimarchivesrecordMapping.toDomain(pimarchivesrecorddto);
        domain.setPimarchivesid(pimarchives_id);
        domain.setPimarchivesrecordid(pimarchivesrecord_id);
		pimarchivesrecordService.update(domain);
        PIMARCHIVESRECORDDTO dto = pimarchivesrecordMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.pimarchivesrecordMapping,#pimarchivesrecorddtos})")
    @ApiOperation(value = "UpdateBatchByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESRECORD" },  notes = "UpdateBatchByPIMPERSONPIMARCHIVES")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesrecords/batch")
    public ResponseEntity<Boolean> updateBatchByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PIMARCHIVESRECORDDTO> pimarchivesrecorddtos) {
        List<PIMARCHIVESRECORD> domainlist=pimarchivesrecordMapping.toDomain(pimarchivesrecorddtos);
        for(PIMARCHIVESRECORD domain:domainlist){
            domain.setPimarchivesid(pimarchives_id);
        }
        pimarchivesrecordService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESRECORD-CheckKey-all')")
    @ApiOperation(value = "CheckKeyByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESRECORD" },  notes = "CheckKeyByPIMPERSONPIMARCHIVES")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesrecords/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESRECORDDTO pimarchivesrecorddto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimarchivesrecordService.checkKey(pimarchivesrecordMapping.toDomain(pimarchivesrecorddto)));
    }

    @PreAuthorize("hasPermission(#pimarchivesrecord_id,'Get',{'Sql',this.pimarchivesrecordMapping,this.permissionDTO})")
    @ApiOperation(value = "GetByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESRECORD" },  notes = "GetByPIMPERSONPIMARCHIVES")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesrecords/{pimarchivesrecord_id}")
    public ResponseEntity<PIMARCHIVESRECORDDTO> getByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchivesrecord_id") String pimarchivesrecord_id) {
        PIMARCHIVESRECORD domain = pimarchivesrecordService.get(pimarchivesrecord_id);
        PIMARCHIVESRECORDDTO dto = pimarchivesrecordMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESRECORD-GetDraft-all')")
    @ApiOperation(value = "GetDraftByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESRECORD" },  notes = "GetDraftByPIMPERSONPIMARCHIVES")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesrecords/getdraft")
    public ResponseEntity<PIMARCHIVESRECORDDTO> getDraftByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id) {
        PIMARCHIVESRECORD domain = new PIMARCHIVESRECORD();
        domain.setPimarchivesid(pimarchives_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesrecordMapping.toDto(pimarchivesrecordService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(#pimarchivesrecord_id,'Remove',{'Sql',this.pimarchivesrecordMapping,this.permissionDTO})")
    @ApiOperation(value = "RemoveByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESRECORD" },  notes = "RemoveByPIMPERSONPIMARCHIVES")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesrecords/{pimarchivesrecord_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchivesrecord_id") String pimarchivesrecord_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimarchivesrecordService.remove(pimarchivesrecord_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.pimarchivesrecordMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatchByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESRECORD" },  notes = "RemoveBatchByPIMPERSONPIMARCHIVES")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesrecords/batch")
    public ResponseEntity<Boolean> removeBatchByPIMPERSONPIMARCHIVES(@RequestBody List<String> ids) {
        pimarchivesrecordService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESRECORD-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESRECORD" } ,notes = "fetchDEFAULTByPIMPERSONPIMARCHIVES")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesrecords/fetchdefault")
	public ResponseEntity<List<PIMARCHIVESRECORDDTO>> fetchPIMARCHIVESRECORDDefaultByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id,PIMARCHIVESRECORDSearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PIMARCHIVESRECORD> domains = pimarchivesrecordService.searchDefault(context) ;
        List<PIMARCHIVESRECORDDTO> list = pimarchivesrecordMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESRECORD-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESRECORD" } ,notes = "searchDEFAULTByPIMPERSONPIMARCHIVES")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesrecords/searchdefault")
	public ResponseEntity<Page<PIMARCHIVESRECORDDTO>> searchPIMARCHIVESRECORDDefaultByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESRECORDSearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PIMARCHIVESRECORD> domains = pimarchivesrecordService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesrecordMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
