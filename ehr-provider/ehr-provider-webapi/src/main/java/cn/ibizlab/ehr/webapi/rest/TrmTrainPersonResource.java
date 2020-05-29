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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainPerson;
import cn.ibizlab.ehr.core.trm.service.ITrmTrainPersonService;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainPersonSearchContext;

@Slf4j
@Api(tags = {"TrmTrainPerson" })
@RestController("WebApi-trmtrainperson")
@RequestMapping("")
public class TrmTrainPersonResource {

    @Autowired
    public ITrmTrainPersonService trmtrainpersonService;

    @Autowired
    @Lazy
    public TrmTrainPersonMapping trmtrainpersonMapping;

    @ApiOperation(value = "GetDraft", tags = {"TrmTrainPerson" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainpeople/getdraft")
    public ResponseEntity<TrmTrainPersonDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainpersonMapping.toDto(trmtrainpersonService.getDraft(new TrmTrainPerson())));
    }

    @PreAuthorize("hasPermission(this.trmtrainpersonMapping.toDomain(#trmtrainpersondto),'ehr-TrmTrainPerson-Save')")
    @ApiOperation(value = "Save", tags = {"TrmTrainPerson" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainpeople/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmTrainPersonDTO trmtrainpersondto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainpersonService.save(trmtrainpersonMapping.toDomain(trmtrainpersondto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainpersonMapping.toDomain(#trmtrainpersondtos),'ehr-TrmTrainPerson-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"TrmTrainPerson" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainpeople/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmTrainPersonDTO> trmtrainpersondtos) {
        trmtrainpersonService.saveBatch(trmtrainpersonMapping.toDomain(trmtrainpersondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainpersonService.get(#trmtrainperson_id),'ehr-TrmTrainPerson-Remove')")
    @ApiOperation(value = "Remove", tags = {"TrmTrainPerson" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainpeople/{trmtrainperson_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtrainperson_id") String trmtrainperson_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtrainpersonService.remove(trmtrainperson_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainpersonService.getTrmtrainpersonByIds(#ids),'ehr-TrmTrainPerson-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"TrmTrainPerson" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainpeople/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtrainpersonService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"TrmTrainPerson" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainpeople/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmTrainPersonDTO trmtrainpersondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainpersonService.checkKey(trmtrainpersonMapping.toDomain(trmtrainpersondto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainpersonMapping.toDomain(#trmtrainpersondto),'ehr-TrmTrainPerson-Create')")
    @ApiOperation(value = "Create", tags = {"TrmTrainPerson" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainpeople")
    @Transactional
    public ResponseEntity<TrmTrainPersonDTO> create(@RequestBody TrmTrainPersonDTO trmtrainpersondto) {
        TrmTrainPerson domain = trmtrainpersonMapping.toDomain(trmtrainpersondto);
		trmtrainpersonService.create(domain);
        TrmTrainPersonDTO dto = trmtrainpersonMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainpersonMapping.toDomain(#trmtrainpersondtos),'ehr-TrmTrainPerson-Create')")
    @ApiOperation(value = "createBatch", tags = {"TrmTrainPerson" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainpeople/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmTrainPersonDTO> trmtrainpersondtos) {
        trmtrainpersonService.createBatch(trmtrainpersonMapping.toDomain(trmtrainpersondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmtrainpersonMapping.toDomain(returnObject.body),'ehr-TrmTrainPerson-Get')")
    @ApiOperation(value = "Get", tags = {"TrmTrainPerson" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainpeople/{trmtrainperson_id}")
    public ResponseEntity<TrmTrainPersonDTO> get(@PathVariable("trmtrainperson_id") String trmtrainperson_id) {
        TrmTrainPerson domain = trmtrainpersonService.get(trmtrainperson_id);
        TrmTrainPersonDTO dto = trmtrainpersonMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainpersonService.get(#trmtrainperson_id),'ehr-TrmTrainPerson-Update')")
    @ApiOperation(value = "Update", tags = {"TrmTrainPerson" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainpeople/{trmtrainperson_id}")
    @Transactional
    public ResponseEntity<TrmTrainPersonDTO> update(@PathVariable("trmtrainperson_id") String trmtrainperson_id, @RequestBody TrmTrainPersonDTO trmtrainpersondto) {
		TrmTrainPerson domain  = trmtrainpersonMapping.toDomain(trmtrainpersondto);
        domain .setTrmtrianpersonid(trmtrainperson_id);
		trmtrainpersonService.update(domain );
		TrmTrainPersonDTO dto = trmtrainpersonMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainpersonService.getTrmtrainpersonByEntities(this.trmtrainpersonMapping.toDomain(#trmtrainpersondtos)),'ehr-TrmTrainPerson-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"TrmTrainPerson" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainpeople/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmTrainPersonDTO> trmtrainpersondtos) {
        trmtrainpersonService.updateBatch(trmtrainpersonMapping.toDomain(trmtrainpersondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPerson-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TrmTrainPerson" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainpeople/fetchdefault")
	public ResponseEntity<List<TrmTrainPersonDTO>> fetchDefault(TrmTrainPersonSearchContext context) {
        Page<TrmTrainPerson> domains = trmtrainpersonService.searchDefault(context) ;
        List<TrmTrainPersonDTO> list = trmtrainpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPerson-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TrmTrainPerson" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainpeople/searchdefault")
	public ResponseEntity<Page<TrmTrainPersonDTO>> searchDefault(@RequestBody TrmTrainPersonSearchContext context) {
        Page<TrmTrainPerson> domains = trmtrainpersonService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "GetDraftByPimPerson", tags = {"TrmTrainPerson" },  notes = "GetDraftByPimPerson")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/trmtrainpeople/getdraft")
    public ResponseEntity<TrmTrainPersonDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        TrmTrainPerson domain = new TrmTrainPerson();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainpersonMapping.toDto(trmtrainpersonService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.trmtrainpersonMapping.toDomain(#trmtrainpersondto),'ehr-TrmTrainPerson-Save')")
    @ApiOperation(value = "SaveByPimPerson", tags = {"TrmTrainPerson" },  notes = "SaveByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/trmtrainpeople/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody TrmTrainPersonDTO trmtrainpersondto) {
        TrmTrainPerson domain = trmtrainpersonMapping.toDomain(trmtrainpersondto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainpersonService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmtrainpersonMapping.toDomain(#trmtrainpersondtos),'ehr-TrmTrainPerson-Save')")
    @ApiOperation(value = "SaveBatchByPimPerson", tags = {"TrmTrainPerson" },  notes = "SaveBatchByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/trmtrainpeople/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<TrmTrainPersonDTO> trmtrainpersondtos) {
        List<TrmTrainPerson> domainlist=trmtrainpersonMapping.toDomain(trmtrainpersondtos);
        for(TrmTrainPerson domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        trmtrainpersonService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainpersonService.get(#trmtrainperson_id),'ehr-TrmTrainPerson-Remove')")
    @ApiOperation(value = "RemoveByPimPerson", tags = {"TrmTrainPerson" },  notes = "RemoveByPimPerson")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/trmtrainpeople/{trmtrainperson_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainperson_id") String trmtrainperson_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmtrainpersonService.remove(trmtrainperson_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainpersonService.getTrmtrainpersonByIds(#ids),'ehr-TrmTrainPerson-Remove')")
    @ApiOperation(value = "RemoveBatchByPimPerson", tags = {"TrmTrainPerson" },  notes = "RemoveBatchByPimPerson")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/trmtrainpeople/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        trmtrainpersonService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByPimPerson", tags = {"TrmTrainPerson" },  notes = "CheckKeyByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/trmtrainpeople/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody TrmTrainPersonDTO trmtrainpersondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainpersonService.checkKey(trmtrainpersonMapping.toDomain(trmtrainpersondto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainpersonMapping.toDomain(#trmtrainpersondto),'ehr-TrmTrainPerson-Create')")
    @ApiOperation(value = "CreateByPimPerson", tags = {"TrmTrainPerson" },  notes = "CreateByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/trmtrainpeople")
    @Transactional
    public ResponseEntity<TrmTrainPersonDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody TrmTrainPersonDTO trmtrainpersondto) {
        TrmTrainPerson domain = trmtrainpersonMapping.toDomain(trmtrainpersondto);
        domain.setPimpersonid(pimperson_id);
		trmtrainpersonService.create(domain);
        TrmTrainPersonDTO dto = trmtrainpersonMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainpersonMapping.toDomain(#trmtrainpersondtos),'ehr-TrmTrainPerson-Create')")
    @ApiOperation(value = "createBatchByPimPerson", tags = {"TrmTrainPerson" },  notes = "createBatchByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/trmtrainpeople/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<TrmTrainPersonDTO> trmtrainpersondtos) {
        List<TrmTrainPerson> domainlist=trmtrainpersonMapping.toDomain(trmtrainpersondtos);
        for(TrmTrainPerson domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        trmtrainpersonService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmtrainpersonMapping.toDomain(returnObject.body),'ehr-TrmTrainPerson-Get')")
    @ApiOperation(value = "GetByPimPerson", tags = {"TrmTrainPerson" },  notes = "GetByPimPerson")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/trmtrainpeople/{trmtrainperson_id}")
    public ResponseEntity<TrmTrainPersonDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainperson_id") String trmtrainperson_id) {
        TrmTrainPerson domain = trmtrainpersonService.get(trmtrainperson_id);
        TrmTrainPersonDTO dto = trmtrainpersonMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainpersonService.get(#trmtrainperson_id),'ehr-TrmTrainPerson-Update')")
    @ApiOperation(value = "UpdateByPimPerson", tags = {"TrmTrainPerson" },  notes = "UpdateByPimPerson")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/trmtrainpeople/{trmtrainperson_id}")
    @Transactional
    public ResponseEntity<TrmTrainPersonDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("trmtrainperson_id") String trmtrainperson_id, @RequestBody TrmTrainPersonDTO trmtrainpersondto) {
        TrmTrainPerson domain = trmtrainpersonMapping.toDomain(trmtrainpersondto);
        domain.setPimpersonid(pimperson_id);
        domain.setTrmtrianpersonid(trmtrainperson_id);
		trmtrainpersonService.update(domain);
        TrmTrainPersonDTO dto = trmtrainpersonMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainpersonService.getTrmtrainpersonByEntities(this.trmtrainpersonMapping.toDomain(#trmtrainpersondtos)),'ehr-TrmTrainPerson-Update')")
    @ApiOperation(value = "UpdateBatchByPimPerson", tags = {"TrmTrainPerson" },  notes = "UpdateBatchByPimPerson")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/trmtrainpeople/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<TrmTrainPersonDTO> trmtrainpersondtos) {
        List<TrmTrainPerson> domainlist=trmtrainpersonMapping.toDomain(trmtrainpersondtos);
        for(TrmTrainPerson domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        trmtrainpersonService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPerson-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPimPerson", tags = {"TrmTrainPerson" } ,notes = "fetchDEFAULTByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/trmtrainpeople/fetchdefault")
	public ResponseEntity<List<TrmTrainPersonDTO>> fetchTrmTrainPersonDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,TrmTrainPersonSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<TrmTrainPerson> domains = trmtrainpersonService.searchDefault(context) ;
        List<TrmTrainPersonDTO> list = trmtrainpersonMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainPerson-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPimPerson", tags = {"TrmTrainPerson" } ,notes = "searchDEFAULTByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/trmtrainpeople/searchdefault")
	public ResponseEntity<Page<TrmTrainPersonDTO>> searchTrmTrainPersonDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody TrmTrainPersonSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<TrmTrainPerson> domains = trmtrainpersonService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

