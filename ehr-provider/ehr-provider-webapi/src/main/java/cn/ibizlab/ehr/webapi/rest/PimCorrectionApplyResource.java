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
import cn.ibizlab.ehr.core.pim.domain.PimCorrectionApply;
import cn.ibizlab.ehr.core.pim.service.IPimCorrectionApplyService;
import cn.ibizlab.ehr.core.pim.filter.PimCorrectionApplySearchContext;

@Slf4j
@Api(tags = {"PimCorrectionApply" })
@RestController("WebApi-pimcorrectionapply")
@RequestMapping("")
public class PimCorrectionApplyResource {

    @Autowired
    public IPimCorrectionApplyService pimcorrectionapplyService;

    @Autowired
    @Lazy
    public PimCorrectionApplyMapping pimcorrectionapplyMapping;

    @PreAuthorize("hasPermission(this.pimcorrectionapplyMapping.toDomain(#pimcorrectionapplydto),'ehr-PimCorrectionApply-Create')")
    @ApiOperation(value = "Create", tags = {"PimCorrectionApply" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcorrectionapplies")
    @Transactional
    public ResponseEntity<PimCorrectionApplyDTO> create(@RequestBody PimCorrectionApplyDTO pimcorrectionapplydto) {
        PimCorrectionApply domain = pimcorrectionapplyMapping.toDomain(pimcorrectionapplydto);
		pimcorrectionapplyService.create(domain);
        PimCorrectionApplyDTO dto = pimcorrectionapplyMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyMapping.toDomain(#pimcorrectionapplydtos),'ehr-PimCorrectionApply-Create')")
    @ApiOperation(value = "createBatch", tags = {"PimCorrectionApply" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcorrectionapplies/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimCorrectionApplyDTO> pimcorrectionapplydtos) {
        pimcorrectionapplyService.createBatch(pimcorrectionapplyMapping.toDomain(pimcorrectionapplydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"PimCorrectionApply" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimcorrectionapplies/getdraft")
    public ResponseEntity<PimCorrectionApplyDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimcorrectionapplyMapping.toDto(pimcorrectionapplyService.getDraft(new PimCorrectionApply())));
    }

    @ApiOperation(value = "CheckKey", tags = {"PimCorrectionApply" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcorrectionapplies/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimCorrectionApplyDTO pimcorrectionapplydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimcorrectionapplyService.checkKey(pimcorrectionapplyMapping.toDomain(pimcorrectionapplydto)));
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyMapping.toDomain(#pimcorrectionapplydto),'ehr-PimCorrectionApply-Save')")
    @ApiOperation(value = "Save", tags = {"PimCorrectionApply" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcorrectionapplies/save")
    public ResponseEntity<Boolean> save(@RequestBody PimCorrectionApplyDTO pimcorrectionapplydto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimcorrectionapplyService.save(pimcorrectionapplyMapping.toDomain(pimcorrectionapplydto)));
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyMapping.toDomain(#pimcorrectionapplydtos),'ehr-PimCorrectionApply-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PimCorrectionApply" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimcorrectionapplies/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimCorrectionApplyDTO> pimcorrectionapplydtos) {
        pimcorrectionapplyService.saveBatch(pimcorrectionapplyMapping.toDomain(pimcorrectionapplydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimcorrectionapplyMapping.toDomain(returnObject.body),'ehr-PimCorrectionApply-Get')")
    @ApiOperation(value = "Get", tags = {"PimCorrectionApply" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimcorrectionapplies/{pimcorrectionapply_id}")
    public ResponseEntity<PimCorrectionApplyDTO> get(@PathVariable("pimcorrectionapply_id") String pimcorrectionapply_id) {
        PimCorrectionApply domain = pimcorrectionapplyService.get(pimcorrectionapply_id);
        PimCorrectionApplyDTO dto = pimcorrectionapplyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyService.get(#pimcorrectionapply_id),'ehr-PimCorrectionApply-Update')")
    @ApiOperation(value = "Update", tags = {"PimCorrectionApply" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimcorrectionapplies/{pimcorrectionapply_id}")
    @Transactional
    public ResponseEntity<PimCorrectionApplyDTO> update(@PathVariable("pimcorrectionapply_id") String pimcorrectionapply_id, @RequestBody PimCorrectionApplyDTO pimcorrectionapplydto) {
		PimCorrectionApply domain  = pimcorrectionapplyMapping.toDomain(pimcorrectionapplydto);
        domain .setPimcorrectionapplyid(pimcorrectionapply_id);
		pimcorrectionapplyService.update(domain );
		PimCorrectionApplyDTO dto = pimcorrectionapplyMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyService.getPimcorrectionapplyByEntities(this.pimcorrectionapplyMapping.toDomain(#pimcorrectionapplydtos)),'ehr-PimCorrectionApply-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PimCorrectionApply" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimcorrectionapplies/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimCorrectionApplyDTO> pimcorrectionapplydtos) {
        pimcorrectionapplyService.updateBatch(pimcorrectionapplyMapping.toDomain(pimcorrectionapplydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyService.get(#pimcorrectionapply_id),'ehr-PimCorrectionApply-Remove')")
    @ApiOperation(value = "Remove", tags = {"PimCorrectionApply" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimcorrectionapplies/{pimcorrectionapply_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimcorrectionapply_id") String pimcorrectionapply_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimcorrectionapplyService.remove(pimcorrectionapply_id));
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyService.getPimcorrectionapplyByIds(#ids),'ehr-PimCorrectionApply-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PimCorrectionApply" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimcorrectionapplies/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimcorrectionapplyService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimCorrectionApply-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PimCorrectionApply" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimcorrectionapplies/fetchdefault")
	public ResponseEntity<List<PimCorrectionApplyDTO>> fetchDefault(PimCorrectionApplySearchContext context) {
        Page<PimCorrectionApply> domains = pimcorrectionapplyService.searchDefault(context) ;
        List<PimCorrectionApplyDTO> list = pimcorrectionapplyMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimCorrectionApply-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PimCorrectionApply" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimcorrectionapplies/searchdefault")
	public ResponseEntity<Page<PimCorrectionApplyDTO>> searchDefault(@RequestBody PimCorrectionApplySearchContext context) {
        Page<PimCorrectionApply> domains = pimcorrectionapplyService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcorrectionapplyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pimcorrectionapplyMapping.toDomain(#pimcorrectionapplydto),'ehr-PimCorrectionApply-Create')")
    @ApiOperation(value = "CreateByPimByygzzsq", tags = {"PimCorrectionApply" },  notes = "CreateByPimByygzzsq")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimcorrectionapplies")
    @Transactional
    public ResponseEntity<PimCorrectionApplyDTO> createByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PimCorrectionApplyDTO pimcorrectionapplydto) {
        PimCorrectionApply domain = pimcorrectionapplyMapping.toDomain(pimcorrectionapplydto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
		pimcorrectionapplyService.create(domain);
        PimCorrectionApplyDTO dto = pimcorrectionapplyMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyMapping.toDomain(#pimcorrectionapplydtos),'ehr-PimCorrectionApply-Create')")
    @ApiOperation(value = "createBatchByPimByygzzsq", tags = {"PimCorrectionApply" },  notes = "createBatchByPimByygzzsq")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimcorrectionapplies/batch")
    public ResponseEntity<Boolean> createBatchByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody List<PimCorrectionApplyDTO> pimcorrectionapplydtos) {
        List<PimCorrectionApply> domainlist=pimcorrectionapplyMapping.toDomain(pimcorrectionapplydtos);
        for(PimCorrectionApply domain:domainlist){
            domain.setPimbyygzzsqid(pimbyygzzsq_id);
        }
        pimcorrectionapplyService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPimByygzzsq", tags = {"PimCorrectionApply" },  notes = "GetDraftByPimByygzzsq")
    @RequestMapping(method = RequestMethod.GET, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimcorrectionapplies/getdraft")
    public ResponseEntity<PimCorrectionApplyDTO> getDraftByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id) {
        PimCorrectionApply domain = new PimCorrectionApply();
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimcorrectionapplyMapping.toDto(pimcorrectionapplyService.getDraft(domain)));
    }

    @ApiOperation(value = "CheckKeyByPimByygzzsq", tags = {"PimCorrectionApply" },  notes = "CheckKeyByPimByygzzsq")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimcorrectionapplies/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PimCorrectionApplyDTO pimcorrectionapplydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimcorrectionapplyService.checkKey(pimcorrectionapplyMapping.toDomain(pimcorrectionapplydto)));
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyMapping.toDomain(#pimcorrectionapplydto),'ehr-PimCorrectionApply-Save')")
    @ApiOperation(value = "SaveByPimByygzzsq", tags = {"PimCorrectionApply" },  notes = "SaveByPimByygzzsq")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimcorrectionapplies/save")
    public ResponseEntity<Boolean> saveByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PimCorrectionApplyDTO pimcorrectionapplydto) {
        PimCorrectionApply domain = pimcorrectionapplyMapping.toDomain(pimcorrectionapplydto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimcorrectionapplyService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyMapping.toDomain(#pimcorrectionapplydtos),'ehr-PimCorrectionApply-Save')")
    @ApiOperation(value = "SaveBatchByPimByygzzsq", tags = {"PimCorrectionApply" },  notes = "SaveBatchByPimByygzzsq")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimcorrectionapplies/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody List<PimCorrectionApplyDTO> pimcorrectionapplydtos) {
        List<PimCorrectionApply> domainlist=pimcorrectionapplyMapping.toDomain(pimcorrectionapplydtos);
        for(PimCorrectionApply domain:domainlist){
             domain.setPimbyygzzsqid(pimbyygzzsq_id);
        }
        pimcorrectionapplyService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimcorrectionapplyMapping.toDomain(returnObject.body),'ehr-PimCorrectionApply-Get')")
    @ApiOperation(value = "GetByPimByygzzsq", tags = {"PimCorrectionApply" },  notes = "GetByPimByygzzsq")
	@RequestMapping(method = RequestMethod.GET, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimcorrectionapplies/{pimcorrectionapply_id}")
    public ResponseEntity<PimCorrectionApplyDTO> getByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimcorrectionapply_id") String pimcorrectionapply_id) {
        PimCorrectionApply domain = pimcorrectionapplyService.get(pimcorrectionapply_id);
        PimCorrectionApplyDTO dto = pimcorrectionapplyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyService.get(#pimcorrectionapply_id),'ehr-PimCorrectionApply-Update')")
    @ApiOperation(value = "UpdateByPimByygzzsq", tags = {"PimCorrectionApply" },  notes = "UpdateByPimByygzzsq")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimcorrectionapplies/{pimcorrectionapply_id}")
    @Transactional
    public ResponseEntity<PimCorrectionApplyDTO> updateByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimcorrectionapply_id") String pimcorrectionapply_id, @RequestBody PimCorrectionApplyDTO pimcorrectionapplydto) {
        PimCorrectionApply domain = pimcorrectionapplyMapping.toDomain(pimcorrectionapplydto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain.setPimcorrectionapplyid(pimcorrectionapply_id);
		pimcorrectionapplyService.update(domain);
        PimCorrectionApplyDTO dto = pimcorrectionapplyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyService.getPimcorrectionapplyByEntities(this.pimcorrectionapplyMapping.toDomain(#pimcorrectionapplydtos)),'ehr-PimCorrectionApply-Update')")
    @ApiOperation(value = "UpdateBatchByPimByygzzsq", tags = {"PimCorrectionApply" },  notes = "UpdateBatchByPimByygzzsq")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimcorrectionapplies/batch")
    public ResponseEntity<Boolean> updateBatchByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody List<PimCorrectionApplyDTO> pimcorrectionapplydtos) {
        List<PimCorrectionApply> domainlist=pimcorrectionapplyMapping.toDomain(pimcorrectionapplydtos);
        for(PimCorrectionApply domain:domainlist){
            domain.setPimbyygzzsqid(pimbyygzzsq_id);
        }
        pimcorrectionapplyService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyService.get(#pimcorrectionapply_id),'ehr-PimCorrectionApply-Remove')")
    @ApiOperation(value = "RemoveByPimByygzzsq", tags = {"PimCorrectionApply" },  notes = "RemoveByPimByygzzsq")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimcorrectionapplies/{pimcorrectionapply_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimcorrectionapply_id") String pimcorrectionapply_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimcorrectionapplyService.remove(pimcorrectionapply_id));
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyService.getPimcorrectionapplyByIds(#ids),'ehr-PimCorrectionApply-Remove')")
    @ApiOperation(value = "RemoveBatchByPimByygzzsq", tags = {"PimCorrectionApply" },  notes = "RemoveBatchByPimByygzzsq")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimcorrectionapplies/batch")
    public ResponseEntity<Boolean> removeBatchByPimByygzzsq(@RequestBody List<String> ids) {
        pimcorrectionapplyService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimCorrectionApply-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPimByygzzsq", tags = {"PimCorrectionApply" } ,notes = "fetchDEFAULTByPimByygzzsq")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimcorrectionapplies/fetchdefault")
	public ResponseEntity<List<PimCorrectionApplyDTO>> fetchPimCorrectionApplyDefaultByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id,PimCorrectionApplySearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PimCorrectionApply> domains = pimcorrectionapplyService.searchDefault(context) ;
        List<PimCorrectionApplyDTO> list = pimcorrectionapplyMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimCorrectionApply-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPimByygzzsq", tags = {"PimCorrectionApply" } ,notes = "searchDEFAULTByPimByygzzsq")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimcorrectionapplies/searchdefault")
	public ResponseEntity<Page<PimCorrectionApplyDTO>> searchPimCorrectionApplyDefaultByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PimCorrectionApplySearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PimCorrectionApply> domains = pimcorrectionapplyService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcorrectionapplyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pimcorrectionapplyMapping.toDomain(#pimcorrectionapplydto),'ehr-PimCorrectionApply-Create')")
    @ApiOperation(value = "CreateByPIMPERSON", tags = {"PimCorrectionApply" },  notes = "CreateByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimcorrectionapplies")
    @Transactional
    public ResponseEntity<PimCorrectionApplyDTO> createByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimCorrectionApplyDTO pimcorrectionapplydto) {
        PimCorrectionApply domain = pimcorrectionapplyMapping.toDomain(pimcorrectionapplydto);
        domain.setPimpersonid(pimperson_id);
		pimcorrectionapplyService.create(domain);
        PimCorrectionApplyDTO dto = pimcorrectionapplyMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyMapping.toDomain(#pimcorrectionapplydtos),'ehr-PimCorrectionApply-Create')")
    @ApiOperation(value = "createBatchByPIMPERSON", tags = {"PimCorrectionApply" },  notes = "createBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimcorrectionapplies/batch")
    public ResponseEntity<Boolean> createBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimCorrectionApplyDTO> pimcorrectionapplydtos) {
        List<PimCorrectionApply> domainlist=pimcorrectionapplyMapping.toDomain(pimcorrectionapplydtos);
        for(PimCorrectionApply domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimcorrectionapplyService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPIMPERSON", tags = {"PimCorrectionApply" },  notes = "GetDraftByPIMPERSON")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimcorrectionapplies/getdraft")
    public ResponseEntity<PimCorrectionApplyDTO> getDraftByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id) {
        PimCorrectionApply domain = new PimCorrectionApply();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimcorrectionapplyMapping.toDto(pimcorrectionapplyService.getDraft(domain)));
    }

    @ApiOperation(value = "CheckKeyByPIMPERSON", tags = {"PimCorrectionApply" },  notes = "CheckKeyByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimcorrectionapplies/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimCorrectionApplyDTO pimcorrectionapplydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimcorrectionapplyService.checkKey(pimcorrectionapplyMapping.toDomain(pimcorrectionapplydto)));
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyMapping.toDomain(#pimcorrectionapplydto),'ehr-PimCorrectionApply-Save')")
    @ApiOperation(value = "SaveByPIMPERSON", tags = {"PimCorrectionApply" },  notes = "SaveByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimcorrectionapplies/save")
    public ResponseEntity<Boolean> saveByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimCorrectionApplyDTO pimcorrectionapplydto) {
        PimCorrectionApply domain = pimcorrectionapplyMapping.toDomain(pimcorrectionapplydto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimcorrectionapplyService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyMapping.toDomain(#pimcorrectionapplydtos),'ehr-PimCorrectionApply-Save')")
    @ApiOperation(value = "SaveBatchByPIMPERSON", tags = {"PimCorrectionApply" },  notes = "SaveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimcorrectionapplies/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimCorrectionApplyDTO> pimcorrectionapplydtos) {
        List<PimCorrectionApply> domainlist=pimcorrectionapplyMapping.toDomain(pimcorrectionapplydtos);
        for(PimCorrectionApply domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimcorrectionapplyService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimcorrectionapplyMapping.toDomain(returnObject.body),'ehr-PimCorrectionApply-Get')")
    @ApiOperation(value = "GetByPIMPERSON", tags = {"PimCorrectionApply" },  notes = "GetByPIMPERSON")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimcorrectionapplies/{pimcorrectionapply_id}")
    public ResponseEntity<PimCorrectionApplyDTO> getByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimcorrectionapply_id") String pimcorrectionapply_id) {
        PimCorrectionApply domain = pimcorrectionapplyService.get(pimcorrectionapply_id);
        PimCorrectionApplyDTO dto = pimcorrectionapplyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyService.get(#pimcorrectionapply_id),'ehr-PimCorrectionApply-Update')")
    @ApiOperation(value = "UpdateByPIMPERSON", tags = {"PimCorrectionApply" },  notes = "UpdateByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimcorrectionapplies/{pimcorrectionapply_id}")
    @Transactional
    public ResponseEntity<PimCorrectionApplyDTO> updateByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimcorrectionapply_id") String pimcorrectionapply_id, @RequestBody PimCorrectionApplyDTO pimcorrectionapplydto) {
        PimCorrectionApply domain = pimcorrectionapplyMapping.toDomain(pimcorrectionapplydto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimcorrectionapplyid(pimcorrectionapply_id);
		pimcorrectionapplyService.update(domain);
        PimCorrectionApplyDTO dto = pimcorrectionapplyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyService.getPimcorrectionapplyByEntities(this.pimcorrectionapplyMapping.toDomain(#pimcorrectionapplydtos)),'ehr-PimCorrectionApply-Update')")
    @ApiOperation(value = "UpdateBatchByPIMPERSON", tags = {"PimCorrectionApply" },  notes = "UpdateBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimcorrectionapplies/batch")
    public ResponseEntity<Boolean> updateBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimCorrectionApplyDTO> pimcorrectionapplydtos) {
        List<PimCorrectionApply> domainlist=pimcorrectionapplyMapping.toDomain(pimcorrectionapplydtos);
        for(PimCorrectionApply domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimcorrectionapplyService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyService.get(#pimcorrectionapply_id),'ehr-PimCorrectionApply-Remove')")
    @ApiOperation(value = "RemoveByPIMPERSON", tags = {"PimCorrectionApply" },  notes = "RemoveByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimcorrectionapplies/{pimcorrectionapply_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimcorrectionapply_id") String pimcorrectionapply_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimcorrectionapplyService.remove(pimcorrectionapply_id));
    }

    @PreAuthorize("hasPermission(this.pimcorrectionapplyService.getPimcorrectionapplyByIds(#ids),'ehr-PimCorrectionApply-Remove')")
    @ApiOperation(value = "RemoveBatchByPIMPERSON", tags = {"PimCorrectionApply" },  notes = "RemoveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimcorrectionapplies/batch")
    public ResponseEntity<Boolean> removeBatchByPIMPERSON(@RequestBody List<String> ids) {
        pimcorrectionapplyService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimCorrectionApply-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPIMPERSON", tags = {"PimCorrectionApply" } ,notes = "fetchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimcorrectionapplies/fetchdefault")
	public ResponseEntity<List<PimCorrectionApplyDTO>> fetchPimCorrectionApplyDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PimCorrectionApplySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimCorrectionApply> domains = pimcorrectionapplyService.searchDefault(context) ;
        List<PimCorrectionApplyDTO> list = pimcorrectionapplyMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimCorrectionApply-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPIMPERSON", tags = {"PimCorrectionApply" } ,notes = "searchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimcorrectionapplies/searchdefault")
	public ResponseEntity<Page<PimCorrectionApplyDTO>> searchPimCorrectionApplyDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimCorrectionApplySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimCorrectionApply> domains = pimcorrectionapplyService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimcorrectionapplyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

