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
import cn.ibizlab.ehr.core.pim.domain.PIMARCHIVESLOANANDRETURN;
import cn.ibizlab.ehr.core.pim.service.IPIMARCHIVESLOANANDRETURNService;
import cn.ibizlab.ehr.core.pim.filter.PIMARCHIVESLOANANDRETURNSearchContext;

@Slf4j
@Api(tags = {"PIMARCHIVESLOANANDRETURN" })
@RestController("WebApi-pimarchivesloanandreturn")
@RequestMapping("")
public class PIMARCHIVESLOANANDRETURNResource {

    @Autowired
    private IPIMARCHIVESLOANANDRETURNService pimarchivesloanandreturnService;

    @Autowired
    @Lazy
    public PIMARCHIVESLOANANDRETURNMapping pimarchivesloanandreturnMapping;

    public PIMARCHIVESLOANANDRETURNDTO permissionDTO=new PIMARCHIVESLOANANDRETURNDTO();

    @PreAuthorize("hasPermission(#pimarchivesloanandreturn_id,'Get',{'Sql',this.pimarchivesloanandreturnMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarchivesloanandreturns/{pimarchivesloanandreturn_id}")
    public ResponseEntity<PIMARCHIVESLOANANDRETURNDTO> get(@PathVariable("pimarchivesloanandreturn_id") String pimarchivesloanandreturn_id) {
        PIMARCHIVESLOANANDRETURN domain = pimarchivesloanandreturnService.get(pimarchivesloanandreturn_id);
        PIMARCHIVESLOANANDRETURNDTO dto = pimarchivesloanandreturnMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pimarchivesloanandreturn_id,'Update',{'Sql',this.pimarchivesloanandreturnMapping,#pimarchivesloanandreturndto})")
    @ApiOperation(value = "Update", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchivesloanandreturns/{pimarchivesloanandreturn_id}")
    @Transactional
    public ResponseEntity<PIMARCHIVESLOANANDRETURNDTO> update(@PathVariable("pimarchivesloanandreturn_id") String pimarchivesloanandreturn_id, @RequestBody PIMARCHIVESLOANANDRETURNDTO pimarchivesloanandreturndto) {
		PIMARCHIVESLOANANDRETURN domain = pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndto);
        domain.setPimarchivesloanandreturnid(pimarchivesloanandreturn_id);
		pimarchivesloanandreturnService.update(domain);
		PIMARCHIVESLOANANDRETURNDTO dto = pimarchivesloanandreturnMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchivesloanandreturns/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMARCHIVESLOANANDRETURNDTO> pimarchivesloanandreturndtos) {
        pimarchivesloanandreturnService.updateBatch(pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pimarchivesloanandreturnMapping,#pimarchivesloanandreturndto})")
    @ApiOperation(value = "Create", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchivesloanandreturns")
    @Transactional
    public ResponseEntity<PIMARCHIVESLOANANDRETURNDTO> create(@RequestBody PIMARCHIVESLOANANDRETURNDTO pimarchivesloanandreturndto) {
        PIMARCHIVESLOANANDRETURN domain = pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndto);
		pimarchivesloanandreturnService.create(domain);
        PIMARCHIVESLOANANDRETURNDTO dto = pimarchivesloanandreturnMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchivesloanandreturns/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMARCHIVESLOANANDRETURNDTO> pimarchivesloanandreturndtos) {
        pimarchivesloanandreturnService.createBatch(pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESLOANANDRETURN-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarchivesloanandreturns/getdraft")
    public ResponseEntity<PIMARCHIVESLOANANDRETURNDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesloanandreturnMapping.toDto(pimarchivesloanandreturnService.getDraft(new PIMARCHIVESLOANANDRETURN())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESLOANANDRETURN-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchivesloanandreturns/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMARCHIVESLOANANDRETURNDTO pimarchivesloanandreturndto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimarchivesloanandreturnService.checkKey(pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESLOANANDRETURN-UpdateState-all')")
    @ApiOperation(value = "", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchivesloanandreturns/{pimarchivesloanandreturn_id}/updatestate")
    @Transactional
    public ResponseEntity<PIMARCHIVESLOANANDRETURNDTO> updateState(@PathVariable("pimarchivesloanandreturn_id") String pimarchivesloanandreturn_id, @RequestBody PIMARCHIVESLOANANDRETURNDTO pimarchivesloanandreturndto) {
        PIMARCHIVESLOANANDRETURN pimarchivesloanandreturn = pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndto);
        pimarchivesloanandreturn = pimarchivesloanandreturnService.updateState(pimarchivesloanandreturn);
        pimarchivesloanandreturndto = pimarchivesloanandreturnMapping.toDto(pimarchivesloanandreturn);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesloanandreturndto);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.pimarchivesloanandreturnMapping,#pimarchivesloanandreturndto})")
    @ApiOperation(value = "Save", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchivesloanandreturns/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMARCHIVESLOANANDRETURNDTO pimarchivesloanandreturndto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesloanandreturnService.save(pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchivesloanandreturns/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMARCHIVESLOANANDRETURNDTO> pimarchivesloanandreturndtos) {
        pimarchivesloanandreturnService.saveBatch(pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pimarchivesloanandreturn_id,'Remove',{'Sql',this.pimarchivesloanandreturnMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchivesloanandreturns/{pimarchivesloanandreturn_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimarchivesloanandreturn_id") String pimarchivesloanandreturn_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimarchivesloanandreturnService.remove(pimarchivesloanandreturn_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchivesloanandreturns/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimarchivesloanandreturnService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESLOANANDRETURN-UpdateArchiveState-all')")
    @ApiOperation(value = "更新档案信息借阅状态", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "更新档案信息借阅状态")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchivesloanandreturns/{pimarchivesloanandreturn_id}/updatearchivestate")
    @Transactional
    public ResponseEntity<PIMARCHIVESLOANANDRETURNDTO> updateArchiveState(@PathVariable("pimarchivesloanandreturn_id") String pimarchivesloanandreturn_id, @RequestBody PIMARCHIVESLOANANDRETURNDTO pimarchivesloanandreturndto) {
        PIMARCHIVESLOANANDRETURN pimarchivesloanandreturn = pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndto);
        pimarchivesloanandreturn = pimarchivesloanandreturnService.updateArchiveState(pimarchivesloanandreturn);
        pimarchivesloanandreturndto = pimarchivesloanandreturnMapping.toDto(pimarchivesloanandreturn);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesloanandreturndto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESLOANANDRETURN-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMARCHIVESLOANANDRETURN" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimarchivesloanandreturns/fetchdefault")
	public ResponseEntity<List<PIMARCHIVESLOANANDRETURNDTO>> fetchDefault(PIMARCHIVESLOANANDRETURNSearchContext context) {
        Page<PIMARCHIVESLOANANDRETURN> domains = pimarchivesloanandreturnService.searchDefault(context) ;
        List<PIMARCHIVESLOANANDRETURNDTO> list = pimarchivesloanandreturnMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESLOANANDRETURN-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMARCHIVESLOANANDRETURN" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchivesloanandreturns/searchdefault")
	public ResponseEntity<Page<PIMARCHIVESLOANANDRETURNDTO>> searchDefault(@RequestBody PIMARCHIVESLOANANDRETURNSearchContext context) {
        Page<PIMARCHIVESLOANANDRETURN> domains = pimarchivesloanandreturnService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesloanandreturnMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(#pimarchivesloanandreturn_id,'Get',{'Sql',this.pimarchivesloanandreturnMapping,this.permissionDTO})")
    @ApiOperation(value = "GetByPIMARCHIVES", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "GetByPIMARCHIVES")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/{pimarchivesloanandreturn_id}")
    public ResponseEntity<PIMARCHIVESLOANANDRETURNDTO> getByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchivesloanandreturn_id") String pimarchivesloanandreturn_id) {
        PIMARCHIVESLOANANDRETURN domain = pimarchivesloanandreturnService.get(pimarchivesloanandreturn_id);
        PIMARCHIVESLOANANDRETURNDTO dto = pimarchivesloanandreturnMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pimarchivesloanandreturn_id,'Update',{'Sql',this.pimarchivesloanandreturnMapping,#pimarchivesloanandreturndto})")
    @ApiOperation(value = "UpdateByPIMARCHIVES", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "UpdateByPIMARCHIVES")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/{pimarchivesloanandreturn_id}")
    @Transactional
    public ResponseEntity<PIMARCHIVESLOANANDRETURNDTO> updateByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchivesloanandreturn_id") String pimarchivesloanandreturn_id, @RequestBody PIMARCHIVESLOANANDRETURNDTO pimarchivesloanandreturndto) {
        PIMARCHIVESLOANANDRETURN domain = pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndto);
        domain.setPimarchivesid(pimarchives_id);
        domain.setPimarchivesloanandreturnid(pimarchivesloanandreturn_id);
		pimarchivesloanandreturnService.update(domain);
        PIMARCHIVESLOANANDRETURNDTO dto = pimarchivesloanandreturnMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatchByPIMARCHIVES", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "UpdateBatchByPIMARCHIVES")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/batch")
    public ResponseEntity<Boolean> updateBatchByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PIMARCHIVESLOANANDRETURNDTO> pimarchivesloanandreturndtos) {
        List<PIMARCHIVESLOANANDRETURN> domainlist=pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndtos);
        for(PIMARCHIVESLOANANDRETURN domain:domainlist){
            domain.setPimarchivesid(pimarchives_id);
        }
        pimarchivesloanandreturnService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pimarchivesloanandreturnMapping,#pimarchivesloanandreturndto})")
    @ApiOperation(value = "CreateByPIMARCHIVES", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "CreateByPIMARCHIVES")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchivesloanandreturns")
    @Transactional
    public ResponseEntity<PIMARCHIVESLOANANDRETURNDTO> createByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESLOANANDRETURNDTO pimarchivesloanandreturndto) {
        PIMARCHIVESLOANANDRETURN domain = pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndto);
        domain.setPimarchivesid(pimarchives_id);
		pimarchivesloanandreturnService.create(domain);
        PIMARCHIVESLOANANDRETURNDTO dto = pimarchivesloanandreturnMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatchByPIMARCHIVES", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "createBatchByPIMARCHIVES")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/batch")
    public ResponseEntity<Boolean> createBatchByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PIMARCHIVESLOANANDRETURNDTO> pimarchivesloanandreturndtos) {
        List<PIMARCHIVESLOANANDRETURN> domainlist=pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndtos);
        for(PIMARCHIVESLOANANDRETURN domain:domainlist){
            domain.setPimarchivesid(pimarchives_id);
        }
        pimarchivesloanandreturnService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESLOANANDRETURN-GetDraft-all')")
    @ApiOperation(value = "GetDraftByPIMARCHIVES", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "GetDraftByPIMARCHIVES")
    @RequestMapping(method = RequestMethod.GET, value = "/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/getdraft")
    public ResponseEntity<PIMARCHIVESLOANANDRETURNDTO> getDraftByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id) {
        PIMARCHIVESLOANANDRETURN domain = new PIMARCHIVESLOANANDRETURN();
        domain.setPimarchivesid(pimarchives_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesloanandreturnMapping.toDto(pimarchivesloanandreturnService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESLOANANDRETURN-CheckKey-all')")
    @ApiOperation(value = "CheckKeyByPIMARCHIVES", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "CheckKeyByPIMARCHIVES")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESLOANANDRETURNDTO pimarchivesloanandreturndto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimarchivesloanandreturnService.checkKey(pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESLOANANDRETURN-UpdateState-all')")
    @ApiOperation(value = "ByPIMARCHIVES", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "ByPIMARCHIVES")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/{pimarchivesloanandreturn_id}/updatestate")
    @Transactional
    public ResponseEntity<PIMARCHIVESLOANANDRETURNDTO> updateStateByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchivesloanandreturn_id") String pimarchivesloanandreturn_id, @RequestBody PIMARCHIVESLOANANDRETURNDTO pimarchivesloanandreturndto) {
        PIMARCHIVESLOANANDRETURN domain = pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndto);
        domain.setPimarchivesid(pimarchives_id);
        domain = pimarchivesloanandreturnService.updateState(domain) ;
        pimarchivesloanandreturndto = pimarchivesloanandreturnMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesloanandreturndto);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.pimarchivesloanandreturnMapping,#pimarchivesloanandreturndto})")
    @ApiOperation(value = "SaveByPIMARCHIVES", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "SaveByPIMARCHIVES")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/save")
    public ResponseEntity<Boolean> saveByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESLOANANDRETURNDTO pimarchivesloanandreturndto) {
        PIMARCHIVESLOANANDRETURN domain = pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndto);
        domain.setPimarchivesid(pimarchives_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesloanandreturnService.save(domain));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatchByPIMARCHIVES", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "SaveBatchByPIMARCHIVES")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PIMARCHIVESLOANANDRETURNDTO> pimarchivesloanandreturndtos) {
        List<PIMARCHIVESLOANANDRETURN> domainlist=pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndtos);
        for(PIMARCHIVESLOANANDRETURN domain:domainlist){
             domain.setPimarchivesid(pimarchives_id);
        }
        pimarchivesloanandreturnService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pimarchivesloanandreturn_id,'Remove',{'Sql',this.pimarchivesloanandreturnMapping,this.permissionDTO})")
    @ApiOperation(value = "RemoveByPIMARCHIVES", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "RemoveByPIMARCHIVES")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/{pimarchivesloanandreturn_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchivesloanandreturn_id") String pimarchivesloanandreturn_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimarchivesloanandreturnService.remove(pimarchivesloanandreturn_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatchByPIMARCHIVES", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "RemoveBatchByPIMARCHIVES")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/batch")
    public ResponseEntity<Boolean> removeBatchByPIMARCHIVES(@RequestBody List<String> ids) {
        pimarchivesloanandreturnService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESLOANANDRETURN-UpdateArchiveState-all')")
    @ApiOperation(value = "更新档案信息借阅状态ByPIMARCHIVES", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "更新档案信息借阅状态ByPIMARCHIVES")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/{pimarchivesloanandreturn_id}/updatearchivestate")
    @Transactional
    public ResponseEntity<PIMARCHIVESLOANANDRETURNDTO> updateArchiveStateByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchivesloanandreturn_id") String pimarchivesloanandreturn_id, @RequestBody PIMARCHIVESLOANANDRETURNDTO pimarchivesloanandreturndto) {
        PIMARCHIVESLOANANDRETURN domain = pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndto);
        domain.setPimarchivesid(pimarchives_id);
        domain = pimarchivesloanandreturnService.updateArchiveState(domain) ;
        pimarchivesloanandreturndto = pimarchivesloanandreturnMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesloanandreturndto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESLOANANDRETURN-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPIMARCHIVES", tags = {"PIMARCHIVESLOANANDRETURN" } ,notes = "fetchDEFAULTByPIMARCHIVES")
    @RequestMapping(method= RequestMethod.GET , value="/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/fetchdefault")
	public ResponseEntity<List<PIMARCHIVESLOANANDRETURNDTO>> fetchPIMARCHIVESLOANANDRETURNDefaultByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id,PIMARCHIVESLOANANDRETURNSearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PIMARCHIVESLOANANDRETURN> domains = pimarchivesloanandreturnService.searchDefault(context) ;
        List<PIMARCHIVESLOANANDRETURNDTO> list = pimarchivesloanandreturnMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESLOANANDRETURN-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPIMARCHIVES", tags = {"PIMARCHIVESLOANANDRETURN" } ,notes = "searchDEFAULTByPIMARCHIVES")
    @RequestMapping(method= RequestMethod.POST , value="/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/searchdefault")
	public ResponseEntity<Page<PIMARCHIVESLOANANDRETURNDTO>> searchPIMARCHIVESLOANANDRETURNDefaultByPIMARCHIVES(@PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESLOANANDRETURNSearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PIMARCHIVESLOANANDRETURN> domains = pimarchivesloanandreturnService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesloanandreturnMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(#pimarchivesloanandreturn_id,'Get',{'Sql',this.pimarchivesloanandreturnMapping,this.permissionDTO})")
    @ApiOperation(value = "GetByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "GetByPIMPERSONPIMARCHIVES")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/{pimarchivesloanandreturn_id}")
    public ResponseEntity<PIMARCHIVESLOANANDRETURNDTO> getByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchivesloanandreturn_id") String pimarchivesloanandreturn_id) {
        PIMARCHIVESLOANANDRETURN domain = pimarchivesloanandreturnService.get(pimarchivesloanandreturn_id);
        PIMARCHIVESLOANANDRETURNDTO dto = pimarchivesloanandreturnMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pimarchivesloanandreturn_id,'Update',{'Sql',this.pimarchivesloanandreturnMapping,#pimarchivesloanandreturndto})")
    @ApiOperation(value = "UpdateByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "UpdateByPIMPERSONPIMARCHIVES")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/{pimarchivesloanandreturn_id}")
    @Transactional
    public ResponseEntity<PIMARCHIVESLOANANDRETURNDTO> updateByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchivesloanandreturn_id") String pimarchivesloanandreturn_id, @RequestBody PIMARCHIVESLOANANDRETURNDTO pimarchivesloanandreturndto) {
        PIMARCHIVESLOANANDRETURN domain = pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndto);
        domain.setPimarchivesid(pimarchives_id);
        domain.setPimarchivesloanandreturnid(pimarchivesloanandreturn_id);
		pimarchivesloanandreturnService.update(domain);
        PIMARCHIVESLOANANDRETURNDTO dto = pimarchivesloanandreturnMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatchByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "UpdateBatchByPIMPERSONPIMARCHIVES")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/batch")
    public ResponseEntity<Boolean> updateBatchByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PIMARCHIVESLOANANDRETURNDTO> pimarchivesloanandreturndtos) {
        List<PIMARCHIVESLOANANDRETURN> domainlist=pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndtos);
        for(PIMARCHIVESLOANANDRETURN domain:domainlist){
            domain.setPimarchivesid(pimarchives_id);
        }
        pimarchivesloanandreturnService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pimarchivesloanandreturnMapping,#pimarchivesloanandreturndto})")
    @ApiOperation(value = "CreateByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "CreateByPIMPERSONPIMARCHIVES")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesloanandreturns")
    @Transactional
    public ResponseEntity<PIMARCHIVESLOANANDRETURNDTO> createByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESLOANANDRETURNDTO pimarchivesloanandreturndto) {
        PIMARCHIVESLOANANDRETURN domain = pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndto);
        domain.setPimarchivesid(pimarchives_id);
		pimarchivesloanandreturnService.create(domain);
        PIMARCHIVESLOANANDRETURNDTO dto = pimarchivesloanandreturnMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatchByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "createBatchByPIMPERSONPIMARCHIVES")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/batch")
    public ResponseEntity<Boolean> createBatchByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PIMARCHIVESLOANANDRETURNDTO> pimarchivesloanandreturndtos) {
        List<PIMARCHIVESLOANANDRETURN> domainlist=pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndtos);
        for(PIMARCHIVESLOANANDRETURN domain:domainlist){
            domain.setPimarchivesid(pimarchives_id);
        }
        pimarchivesloanandreturnService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESLOANANDRETURN-GetDraft-all')")
    @ApiOperation(value = "GetDraftByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "GetDraftByPIMPERSONPIMARCHIVES")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/getdraft")
    public ResponseEntity<PIMARCHIVESLOANANDRETURNDTO> getDraftByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id) {
        PIMARCHIVESLOANANDRETURN domain = new PIMARCHIVESLOANANDRETURN();
        domain.setPimarchivesid(pimarchives_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesloanandreturnMapping.toDto(pimarchivesloanandreturnService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESLOANANDRETURN-CheckKey-all')")
    @ApiOperation(value = "CheckKeyByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "CheckKeyByPIMPERSONPIMARCHIVES")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESLOANANDRETURNDTO pimarchivesloanandreturndto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimarchivesloanandreturnService.checkKey(pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESLOANANDRETURN-UpdateState-all')")
    @ApiOperation(value = "ByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "ByPIMPERSONPIMARCHIVES")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/{pimarchivesloanandreturn_id}/updatestate")
    @Transactional
    public ResponseEntity<PIMARCHIVESLOANANDRETURNDTO> updateStateByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchivesloanandreturn_id") String pimarchivesloanandreturn_id, @RequestBody PIMARCHIVESLOANANDRETURNDTO pimarchivesloanandreturndto) {
        PIMARCHIVESLOANANDRETURN domain = pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndto);
        domain.setPimarchivesid(pimarchives_id);
        domain = pimarchivesloanandreturnService.updateState(domain) ;
        pimarchivesloanandreturndto = pimarchivesloanandreturnMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesloanandreturndto);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.pimarchivesloanandreturnMapping,#pimarchivesloanandreturndto})")
    @ApiOperation(value = "SaveByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "SaveByPIMPERSONPIMARCHIVES")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/save")
    public ResponseEntity<Boolean> saveByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESLOANANDRETURNDTO pimarchivesloanandreturndto) {
        PIMARCHIVESLOANANDRETURN domain = pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndto);
        domain.setPimarchivesid(pimarchives_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesloanandreturnService.save(domain));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatchByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "SaveBatchByPIMPERSONPIMARCHIVES")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody List<PIMARCHIVESLOANANDRETURNDTO> pimarchivesloanandreturndtos) {
        List<PIMARCHIVESLOANANDRETURN> domainlist=pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndtos);
        for(PIMARCHIVESLOANANDRETURN domain:domainlist){
             domain.setPimarchivesid(pimarchives_id);
        }
        pimarchivesloanandreturnService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pimarchivesloanandreturn_id,'Remove',{'Sql',this.pimarchivesloanandreturnMapping,this.permissionDTO})")
    @ApiOperation(value = "RemoveByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "RemoveByPIMPERSONPIMARCHIVES")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/{pimarchivesloanandreturn_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchivesloanandreturn_id") String pimarchivesloanandreturn_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimarchivesloanandreturnService.remove(pimarchivesloanandreturn_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatchByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "RemoveBatchByPIMPERSONPIMARCHIVES")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/batch")
    public ResponseEntity<Boolean> removeBatchByPIMPERSONPIMARCHIVES(@RequestBody List<String> ids) {
        pimarchivesloanandreturnService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESLOANANDRETURN-UpdateArchiveState-all')")
    @ApiOperation(value = "更新档案信息借阅状态ByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESLOANANDRETURN" },  notes = "更新档案信息借阅状态ByPIMPERSONPIMARCHIVES")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/{pimarchivesloanandreturn_id}/updatearchivestate")
    @Transactional
    public ResponseEntity<PIMARCHIVESLOANANDRETURNDTO> updateArchiveStateByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @PathVariable("pimarchivesloanandreturn_id") String pimarchivesloanandreturn_id, @RequestBody PIMARCHIVESLOANANDRETURNDTO pimarchivesloanandreturndto) {
        PIMARCHIVESLOANANDRETURN domain = pimarchivesloanandreturnMapping.toDomain(pimarchivesloanandreturndto);
        domain.setPimarchivesid(pimarchives_id);
        domain = pimarchivesloanandreturnService.updateArchiveState(domain) ;
        pimarchivesloanandreturndto = pimarchivesloanandreturnMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimarchivesloanandreturndto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESLOANANDRETURN-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESLOANANDRETURN" } ,notes = "fetchDEFAULTByPIMPERSONPIMARCHIVES")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/fetchdefault")
	public ResponseEntity<List<PIMARCHIVESLOANANDRETURNDTO>> fetchPIMARCHIVESLOANANDRETURNDefaultByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id,PIMARCHIVESLOANANDRETURNSearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PIMARCHIVESLOANANDRETURN> domains = pimarchivesloanandreturnService.searchDefault(context) ;
        List<PIMARCHIVESLOANANDRETURNDTO> list = pimarchivesloanandreturnMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARCHIVESLOANANDRETURN-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPIMPERSONPIMARCHIVES", tags = {"PIMARCHIVESLOANANDRETURN" } ,notes = "searchDEFAULTByPIMPERSONPIMARCHIVES")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimarchives/{pimarchives_id}/pimarchivesloanandreturns/searchdefault")
	public ResponseEntity<Page<PIMARCHIVESLOANANDRETURNDTO>> searchPIMARCHIVESLOANANDRETURNDefaultByPIMPERSONPIMARCHIVES(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarchives_id") String pimarchives_id, @RequestBody PIMARCHIVESLOANANDRETURNSearchContext context) {
        context.setN_pimarchivesid_eq(pimarchives_id);
        Page<PIMARCHIVESLOANANDRETURN> domains = pimarchivesloanandreturnService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarchivesloanandreturnMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
