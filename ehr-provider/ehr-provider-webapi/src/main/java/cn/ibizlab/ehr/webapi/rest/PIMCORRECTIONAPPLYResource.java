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
import cn.ibizlab.ehr.core.pim.domain.PIMCORRECTIONAPPLY;
import cn.ibizlab.ehr.core.pim.service.IPIMCORRECTIONAPPLYService;
import cn.ibizlab.ehr.core.pim.filter.PIMCORRECTIONAPPLYSearchContext;

@Slf4j
@Api(tags = {"PIMCORRECTIONAPPLY" })
@RestController("WebApi-pimcorrectionapply")
@RequestMapping("")
public class PIMCORRECTIONAPPLYResource {

    @Autowired
    public IPIMCORRECTIONAPPLYService pimcorrectionapplyService;

    @Autowired
    @Lazy
    public PIMCORRECTIONAPPLYMapping pimcorrectionapplyMapping;

    @PreAuthorize("hasPermission(this.pimcorrectionapplyMapping.toDomain(#pimcorrectionapplydto),'ehr-PIMCORRECTIONAPPLY-Create')")
    @ApiOperation(value = "Create", tags = {"PIMCORRECTIONAPPLY" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcorrectionapplies")
    @Transactional
    public ResponseEntity<PIMCORRECTIONAPPLYDTO> create(@RequestBody PIMCORRECTIONAPPLYDTO pimcorrectionapplydto) {
        PIMCORRECTIONAPPLY domain = pimcorrectionapplyMapping.toDomain(pimcorrectionapplydto);
		pimcorrectionapplyService.create(domain);
        PIMCORRECTIONAPPLYDTO dto = pimcorrectionapplyMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyMapping.toDomain(#pimcorrectionapplydtos),'ehr-PIMCORRECTIONAPPLY-Create')")
    @ApiOperation(value = "createBatch", tags = {"PIMCORRECTIONAPPLY" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcorrectionapplies/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMCORRECTIONAPPLYDTO> pimcorrectionapplydtos) {
        pimcorrectionapplyService.createBatch(pimcorrectionapplyMapping.toDomain(pimcorrectionapplydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"PIMCORRECTIONAPPLY" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimcorrectionapplies/getdraft")
    public ResponseEntity<PIMCORRECTIONAPPLYDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimcorrectionapplyMapping.toDto(pimcorrectionapplyService.getDraft(new PIMCORRECTIONAPPLY())));
    }

    @ApiOperation(value = "CheckKey", tags = {"PIMCORRECTIONAPPLY" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcorrectionapplies/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMCORRECTIONAPPLYDTO pimcorrectionapplydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimcorrectionapplyService.checkKey(pimcorrectionapplyMapping.toDomain(pimcorrectionapplydto)));
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyMapping.toDomain(#pimcorrectionapplydto),'ehr-PIMCORRECTIONAPPLY-Save')")
    @ApiOperation(value = "Save", tags = {"PIMCORRECTIONAPPLY" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcorrectionapplies/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMCORRECTIONAPPLYDTO pimcorrectionapplydto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimcorrectionapplyService.save(pimcorrectionapplyMapping.toDomain(pimcorrectionapplydto)));
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyMapping.toDomain(#pimcorrectionapplydtos),'ehr-PIMCORRECTIONAPPLY-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PIMCORRECTIONAPPLY" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcorrectionapplies/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMCORRECTIONAPPLYDTO> pimcorrectionapplydtos) {
        pimcorrectionapplyService.saveBatch(pimcorrectionapplyMapping.toDomain(pimcorrectionapplydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimcorrectionapplyMapping.toDomain(returnObject.body),'ehr-PIMCORRECTIONAPPLY-Get')")
    @ApiOperation(value = "Get", tags = {"PIMCORRECTIONAPPLY" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimcorrectionapplies/{pimcorrectionapply_id}")
    public ResponseEntity<PIMCORRECTIONAPPLYDTO> get(@PathVariable("pimcorrectionapply_id") String pimcorrectionapply_id) {
        PIMCORRECTIONAPPLY domain = pimcorrectionapplyService.get(pimcorrectionapply_id);
        PIMCORRECTIONAPPLYDTO dto = pimcorrectionapplyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyService.get(#pimcorrectionapply_id),'ehr-PIMCORRECTIONAPPLY-Update')")
    @ApiOperation(value = "Update", tags = {"PIMCORRECTIONAPPLY" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimcorrectionapplies/{pimcorrectionapply_id}")
    @Transactional
    public ResponseEntity<PIMCORRECTIONAPPLYDTO> update(@PathVariable("pimcorrectionapply_id") String pimcorrectionapply_id, @RequestBody PIMCORRECTIONAPPLYDTO pimcorrectionapplydto) {
		PIMCORRECTIONAPPLY domain  = pimcorrectionapplyMapping.toDomain(pimcorrectionapplydto);
        domain .setPimcorrectionapplyid(pimcorrectionapply_id);
		pimcorrectionapplyService.update(domain );
		PIMCORRECTIONAPPLYDTO dto = pimcorrectionapplyMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyService.getPimcorrectionapplyByEntities(this.pimcorrectionapplyMapping.toDomain(#pimcorrectionapplydtos)),'ehr-PIMCORRECTIONAPPLY-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMCORRECTIONAPPLY" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimcorrectionapplies/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMCORRECTIONAPPLYDTO> pimcorrectionapplydtos) {
        pimcorrectionapplyService.updateBatch(pimcorrectionapplyMapping.toDomain(pimcorrectionapplydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyService.get(#pimcorrectionapply_id),'ehr-PIMCORRECTIONAPPLY-Remove')")
    @ApiOperation(value = "Remove", tags = {"PIMCORRECTIONAPPLY" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimcorrectionapplies/{pimcorrectionapply_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimcorrectionapply_id") String pimcorrectionapply_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimcorrectionapplyService.remove(pimcorrectionapply_id));
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyService.getPimcorrectionapplyByIds(#ids),'ehr-PIMCORRECTIONAPPLY-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PIMCORRECTIONAPPLY" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimcorrectionapplies/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimcorrectionapplyService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCORRECTIONAPPLY-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMCORRECTIONAPPLY" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimcorrectionapplies/fetchdefault")
	public ResponseEntity<List<PIMCORRECTIONAPPLYDTO>> fetchDefault(PIMCORRECTIONAPPLYSearchContext context) {
        Page<PIMCORRECTIONAPPLY> domains = pimcorrectionapplyService.searchDefault(context) ;
        List<PIMCORRECTIONAPPLYDTO> list = pimcorrectionapplyMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCORRECTIONAPPLY-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMCORRECTIONAPPLY" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimcorrectionapplies/searchdefault")
	public ResponseEntity<Page<PIMCORRECTIONAPPLYDTO>> searchDefault(@RequestBody PIMCORRECTIONAPPLYSearchContext context) {
        Page<PIMCORRECTIONAPPLY> domains = pimcorrectionapplyService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcorrectionapplyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pimcorrectionapplyMapping.toDomain(#pimcorrectionapplydto),'ehr-PIMCORRECTIONAPPLY-Create')")
    @ApiOperation(value = "CreateByPIMBYYGZZSQ", tags = {"PIMCORRECTIONAPPLY" },  notes = "CreateByPIMBYYGZZSQ")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimcorrectionapplies")
    @Transactional
    public ResponseEntity<PIMCORRECTIONAPPLYDTO> createByPIMBYYGZZSQ(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PIMCORRECTIONAPPLYDTO pimcorrectionapplydto) {
        PIMCORRECTIONAPPLY domain = pimcorrectionapplyMapping.toDomain(pimcorrectionapplydto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
		pimcorrectionapplyService.create(domain);
        PIMCORRECTIONAPPLYDTO dto = pimcorrectionapplyMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyMapping.toDomain(#pimcorrectionapplydtos),'ehr-PIMCORRECTIONAPPLY-Create')")
    @ApiOperation(value = "createBatchByPIMBYYGZZSQ", tags = {"PIMCORRECTIONAPPLY" },  notes = "createBatchByPIMBYYGZZSQ")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimcorrectionapplies/batch")
    public ResponseEntity<Boolean> createBatchByPIMBYYGZZSQ(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody List<PIMCORRECTIONAPPLYDTO> pimcorrectionapplydtos) {
        List<PIMCORRECTIONAPPLY> domainlist=pimcorrectionapplyMapping.toDomain(pimcorrectionapplydtos);
        for(PIMCORRECTIONAPPLY domain:domainlist){
            domain.setPimbyygzzsqid(pimbyygzzsq_id);
        }
        pimcorrectionapplyService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPIMBYYGZZSQ", tags = {"PIMCORRECTIONAPPLY" },  notes = "GetDraftByPIMBYYGZZSQ")
    @RequestMapping(method = RequestMethod.GET, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimcorrectionapplies/getdraft")
    public ResponseEntity<PIMCORRECTIONAPPLYDTO> getDraftByPIMBYYGZZSQ(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id) {
        PIMCORRECTIONAPPLY domain = new PIMCORRECTIONAPPLY();
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimcorrectionapplyMapping.toDto(pimcorrectionapplyService.getDraft(domain)));
    }

    @ApiOperation(value = "CheckKeyByPIMBYYGZZSQ", tags = {"PIMCORRECTIONAPPLY" },  notes = "CheckKeyByPIMBYYGZZSQ")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimcorrectionapplies/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMBYYGZZSQ(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PIMCORRECTIONAPPLYDTO pimcorrectionapplydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimcorrectionapplyService.checkKey(pimcorrectionapplyMapping.toDomain(pimcorrectionapplydto)));
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyMapping.toDomain(#pimcorrectionapplydto),'ehr-PIMCORRECTIONAPPLY-Save')")
    @ApiOperation(value = "SaveByPIMBYYGZZSQ", tags = {"PIMCORRECTIONAPPLY" },  notes = "SaveByPIMBYYGZZSQ")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimcorrectionapplies/save")
    public ResponseEntity<Boolean> saveByPIMBYYGZZSQ(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PIMCORRECTIONAPPLYDTO pimcorrectionapplydto) {
        PIMCORRECTIONAPPLY domain = pimcorrectionapplyMapping.toDomain(pimcorrectionapplydto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimcorrectionapplyService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyMapping.toDomain(#pimcorrectionapplydtos),'ehr-PIMCORRECTIONAPPLY-Save')")
    @ApiOperation(value = "SaveBatchByPIMBYYGZZSQ", tags = {"PIMCORRECTIONAPPLY" },  notes = "SaveBatchByPIMBYYGZZSQ")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimcorrectionapplies/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMBYYGZZSQ(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody List<PIMCORRECTIONAPPLYDTO> pimcorrectionapplydtos) {
        List<PIMCORRECTIONAPPLY> domainlist=pimcorrectionapplyMapping.toDomain(pimcorrectionapplydtos);
        for(PIMCORRECTIONAPPLY domain:domainlist){
             domain.setPimbyygzzsqid(pimbyygzzsq_id);
        }
        pimcorrectionapplyService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimcorrectionapplyMapping.toDomain(returnObject.body),'ehr-PIMCORRECTIONAPPLY-Get')")
    @ApiOperation(value = "GetByPIMBYYGZZSQ", tags = {"PIMCORRECTIONAPPLY" },  notes = "GetByPIMBYYGZZSQ")
	@RequestMapping(method = RequestMethod.GET, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimcorrectionapplies/{pimcorrectionapply_id}")
    public ResponseEntity<PIMCORRECTIONAPPLYDTO> getByPIMBYYGZZSQ(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimcorrectionapply_id") String pimcorrectionapply_id) {
        PIMCORRECTIONAPPLY domain = pimcorrectionapplyService.get(pimcorrectionapply_id);
        PIMCORRECTIONAPPLYDTO dto = pimcorrectionapplyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyService.get(#pimcorrectionapply_id),'ehr-PIMCORRECTIONAPPLY-Update')")
    @ApiOperation(value = "UpdateByPIMBYYGZZSQ", tags = {"PIMCORRECTIONAPPLY" },  notes = "UpdateByPIMBYYGZZSQ")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimcorrectionapplies/{pimcorrectionapply_id}")
    @Transactional
    public ResponseEntity<PIMCORRECTIONAPPLYDTO> updateByPIMBYYGZZSQ(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimcorrectionapply_id") String pimcorrectionapply_id, @RequestBody PIMCORRECTIONAPPLYDTO pimcorrectionapplydto) {
        PIMCORRECTIONAPPLY domain = pimcorrectionapplyMapping.toDomain(pimcorrectionapplydto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain.setPimcorrectionapplyid(pimcorrectionapply_id);
		pimcorrectionapplyService.update(domain);
        PIMCORRECTIONAPPLYDTO dto = pimcorrectionapplyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyService.getPimcorrectionapplyByEntities(this.pimcorrectionapplyMapping.toDomain(#pimcorrectionapplydtos)),'ehr-PIMCORRECTIONAPPLY-Update')")
    @ApiOperation(value = "UpdateBatchByPIMBYYGZZSQ", tags = {"PIMCORRECTIONAPPLY" },  notes = "UpdateBatchByPIMBYYGZZSQ")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimcorrectionapplies/batch")
    public ResponseEntity<Boolean> updateBatchByPIMBYYGZZSQ(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody List<PIMCORRECTIONAPPLYDTO> pimcorrectionapplydtos) {
        List<PIMCORRECTIONAPPLY> domainlist=pimcorrectionapplyMapping.toDomain(pimcorrectionapplydtos);
        for(PIMCORRECTIONAPPLY domain:domainlist){
            domain.setPimbyygzzsqid(pimbyygzzsq_id);
        }
        pimcorrectionapplyService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyService.get(#pimcorrectionapply_id),'ehr-PIMCORRECTIONAPPLY-Remove')")
    @ApiOperation(value = "RemoveByPIMBYYGZZSQ", tags = {"PIMCORRECTIONAPPLY" },  notes = "RemoveByPIMBYYGZZSQ")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimcorrectionapplies/{pimcorrectionapply_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMBYYGZZSQ(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimcorrectionapply_id") String pimcorrectionapply_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimcorrectionapplyService.remove(pimcorrectionapply_id));
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyService.getPimcorrectionapplyByIds(#ids),'ehr-PIMCORRECTIONAPPLY-Remove')")
    @ApiOperation(value = "RemoveBatchByPIMBYYGZZSQ", tags = {"PIMCORRECTIONAPPLY" },  notes = "RemoveBatchByPIMBYYGZZSQ")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimcorrectionapplies/batch")
    public ResponseEntity<Boolean> removeBatchByPIMBYYGZZSQ(@RequestBody List<String> ids) {
        pimcorrectionapplyService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCORRECTIONAPPLY-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPIMBYYGZZSQ", tags = {"PIMCORRECTIONAPPLY" } ,notes = "fetchDEFAULTByPIMBYYGZZSQ")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimcorrectionapplies/fetchdefault")
	public ResponseEntity<List<PIMCORRECTIONAPPLYDTO>> fetchPIMCORRECTIONAPPLYDefaultByPIMBYYGZZSQ(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id,PIMCORRECTIONAPPLYSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PIMCORRECTIONAPPLY> domains = pimcorrectionapplyService.searchDefault(context) ;
        List<PIMCORRECTIONAPPLYDTO> list = pimcorrectionapplyMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCORRECTIONAPPLY-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPIMBYYGZZSQ", tags = {"PIMCORRECTIONAPPLY" } ,notes = "searchDEFAULTByPIMBYYGZZSQ")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimcorrectionapplies/searchdefault")
	public ResponseEntity<Page<PIMCORRECTIONAPPLYDTO>> searchPIMCORRECTIONAPPLYDefaultByPIMBYYGZZSQ(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PIMCORRECTIONAPPLYSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PIMCORRECTIONAPPLY> domains = pimcorrectionapplyService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcorrectionapplyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pimcorrectionapplyMapping.toDomain(#pimcorrectionapplydto),'ehr-PIMCORRECTIONAPPLY-Create')")
    @ApiOperation(value = "CreateByPIMPERSON", tags = {"PIMCORRECTIONAPPLY" },  notes = "CreateByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimcorrectionapplies")
    @Transactional
    public ResponseEntity<PIMCORRECTIONAPPLYDTO> createByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMCORRECTIONAPPLYDTO pimcorrectionapplydto) {
        PIMCORRECTIONAPPLY domain = pimcorrectionapplyMapping.toDomain(pimcorrectionapplydto);
        domain.setPimpersonid(pimperson_id);
		pimcorrectionapplyService.create(domain);
        PIMCORRECTIONAPPLYDTO dto = pimcorrectionapplyMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyMapping.toDomain(#pimcorrectionapplydtos),'ehr-PIMCORRECTIONAPPLY-Create')")
    @ApiOperation(value = "createBatchByPIMPERSON", tags = {"PIMCORRECTIONAPPLY" },  notes = "createBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimcorrectionapplies/batch")
    public ResponseEntity<Boolean> createBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMCORRECTIONAPPLYDTO> pimcorrectionapplydtos) {
        List<PIMCORRECTIONAPPLY> domainlist=pimcorrectionapplyMapping.toDomain(pimcorrectionapplydtos);
        for(PIMCORRECTIONAPPLY domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimcorrectionapplyService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPIMPERSON", tags = {"PIMCORRECTIONAPPLY" },  notes = "GetDraftByPIMPERSON")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimcorrectionapplies/getdraft")
    public ResponseEntity<PIMCORRECTIONAPPLYDTO> getDraftByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id) {
        PIMCORRECTIONAPPLY domain = new PIMCORRECTIONAPPLY();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimcorrectionapplyMapping.toDto(pimcorrectionapplyService.getDraft(domain)));
    }

    @ApiOperation(value = "CheckKeyByPIMPERSON", tags = {"PIMCORRECTIONAPPLY" },  notes = "CheckKeyByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimcorrectionapplies/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMCORRECTIONAPPLYDTO pimcorrectionapplydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimcorrectionapplyService.checkKey(pimcorrectionapplyMapping.toDomain(pimcorrectionapplydto)));
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyMapping.toDomain(#pimcorrectionapplydto),'ehr-PIMCORRECTIONAPPLY-Save')")
    @ApiOperation(value = "SaveByPIMPERSON", tags = {"PIMCORRECTIONAPPLY" },  notes = "SaveByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimcorrectionapplies/save")
    public ResponseEntity<Boolean> saveByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMCORRECTIONAPPLYDTO pimcorrectionapplydto) {
        PIMCORRECTIONAPPLY domain = pimcorrectionapplyMapping.toDomain(pimcorrectionapplydto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimcorrectionapplyService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyMapping.toDomain(#pimcorrectionapplydtos),'ehr-PIMCORRECTIONAPPLY-Save')")
    @ApiOperation(value = "SaveBatchByPIMPERSON", tags = {"PIMCORRECTIONAPPLY" },  notes = "SaveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimcorrectionapplies/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMCORRECTIONAPPLYDTO> pimcorrectionapplydtos) {
        List<PIMCORRECTIONAPPLY> domainlist=pimcorrectionapplyMapping.toDomain(pimcorrectionapplydtos);
        for(PIMCORRECTIONAPPLY domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimcorrectionapplyService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimcorrectionapplyMapping.toDomain(returnObject.body),'ehr-PIMCORRECTIONAPPLY-Get')")
    @ApiOperation(value = "GetByPIMPERSON", tags = {"PIMCORRECTIONAPPLY" },  notes = "GetByPIMPERSON")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimcorrectionapplies/{pimcorrectionapply_id}")
    public ResponseEntity<PIMCORRECTIONAPPLYDTO> getByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimcorrectionapply_id") String pimcorrectionapply_id) {
        PIMCORRECTIONAPPLY domain = pimcorrectionapplyService.get(pimcorrectionapply_id);
        PIMCORRECTIONAPPLYDTO dto = pimcorrectionapplyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyService.get(#pimcorrectionapply_id),'ehr-PIMCORRECTIONAPPLY-Update')")
    @ApiOperation(value = "UpdateByPIMPERSON", tags = {"PIMCORRECTIONAPPLY" },  notes = "UpdateByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimcorrectionapplies/{pimcorrectionapply_id}")
    @Transactional
    public ResponseEntity<PIMCORRECTIONAPPLYDTO> updateByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimcorrectionapply_id") String pimcorrectionapply_id, @RequestBody PIMCORRECTIONAPPLYDTO pimcorrectionapplydto) {
        PIMCORRECTIONAPPLY domain = pimcorrectionapplyMapping.toDomain(pimcorrectionapplydto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimcorrectionapplyid(pimcorrectionapply_id);
		pimcorrectionapplyService.update(domain);
        PIMCORRECTIONAPPLYDTO dto = pimcorrectionapplyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyService.getPimcorrectionapplyByEntities(this.pimcorrectionapplyMapping.toDomain(#pimcorrectionapplydtos)),'ehr-PIMCORRECTIONAPPLY-Update')")
    @ApiOperation(value = "UpdateBatchByPIMPERSON", tags = {"PIMCORRECTIONAPPLY" },  notes = "UpdateBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimcorrectionapplies/batch")
    public ResponseEntity<Boolean> updateBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMCORRECTIONAPPLYDTO> pimcorrectionapplydtos) {
        List<PIMCORRECTIONAPPLY> domainlist=pimcorrectionapplyMapping.toDomain(pimcorrectionapplydtos);
        for(PIMCORRECTIONAPPLY domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimcorrectionapplyService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyService.get(#pimcorrectionapply_id),'ehr-PIMCORRECTIONAPPLY-Remove')")
    @ApiOperation(value = "RemoveByPIMPERSON", tags = {"PIMCORRECTIONAPPLY" },  notes = "RemoveByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimcorrectionapplies/{pimcorrectionapply_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimcorrectionapply_id") String pimcorrectionapply_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimcorrectionapplyService.remove(pimcorrectionapply_id));
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyService.getPimcorrectionapplyByIds(#ids),'ehr-PIMCORRECTIONAPPLY-Remove')")
    @ApiOperation(value = "RemoveBatchByPIMPERSON", tags = {"PIMCORRECTIONAPPLY" },  notes = "RemoveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimcorrectionapplies/batch")
    public ResponseEntity<Boolean> removeBatchByPIMPERSON(@RequestBody List<String> ids) {
        pimcorrectionapplyService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCORRECTIONAPPLY-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPIMPERSON", tags = {"PIMCORRECTIONAPPLY" } ,notes = "fetchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimcorrectionapplies/fetchdefault")
	public ResponseEntity<List<PIMCORRECTIONAPPLYDTO>> fetchPIMCORRECTIONAPPLYDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PIMCORRECTIONAPPLYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMCORRECTIONAPPLY> domains = pimcorrectionapplyService.searchDefault(context) ;
        List<PIMCORRECTIONAPPLYDTO> list = pimcorrectionapplyMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMCORRECTIONAPPLY-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPIMPERSON", tags = {"PIMCORRECTIONAPPLY" } ,notes = "searchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimcorrectionapplies/searchdefault")
	public ResponseEntity<Page<PIMCORRECTIONAPPLYDTO>> searchPIMCORRECTIONAPPLYDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMCORRECTIONAPPLYSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMCORRECTIONAPPLY> domains = pimcorrectionapplyService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcorrectionapplyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

