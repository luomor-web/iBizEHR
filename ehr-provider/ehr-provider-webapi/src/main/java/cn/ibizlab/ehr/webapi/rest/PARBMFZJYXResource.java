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
import cn.ibizlab.ehr.core.par.domain.PARBMFZJYX;
import cn.ibizlab.ehr.core.par.service.IPARBMFZJYXService;
import cn.ibizlab.ehr.core.par.filter.PARBMFZJYXSearchContext;

@Slf4j
@Api(tags = {"PARBMFZJYX" })
@RestController("WebApi-parbmfzjyx")
@RequestMapping("")
public class PARBMFZJYXResource {

    @Autowired
    public IPARBMFZJYXService parbmfzjyxService;

    @Autowired
    @Lazy
    public PARBMFZJYXMapping parbmfzjyxMapping;

    @PreAuthorize("hasPermission(this.parbmfzjyxMapping.toDomain(#parbmfzjyxdto),'ehr-PARBMFZJYX-Save')")
    @ApiOperation(value = "Save", tags = {"PARBMFZJYX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parbmfzjyxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PARBMFZJYXDTO parbmfzjyxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parbmfzjyxService.save(parbmfzjyxMapping.toDomain(parbmfzjyxdto)));
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxMapping.toDomain(#parbmfzjyxdtos),'ehr-PARBMFZJYX-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PARBMFZJYX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parbmfzjyxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARBMFZJYXDTO> parbmfzjyxdtos) {
        parbmfzjyxService.saveBatch(parbmfzjyxMapping.toDomain(parbmfzjyxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"PARBMFZJYX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parbmfzjyxes/getdraft")
    public ResponseEntity<PARBMFZJYXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parbmfzjyxMapping.toDto(parbmfzjyxService.getDraft(new PARBMFZJYX())));
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxMapping.toDomain(#parbmfzjyxdto),'ehr-PARBMFZJYX-Create')")
    @ApiOperation(value = "Create", tags = {"PARBMFZJYX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parbmfzjyxes")
    @Transactional
    public ResponseEntity<PARBMFZJYXDTO> create(@RequestBody PARBMFZJYXDTO parbmfzjyxdto) {
        PARBMFZJYX domain = parbmfzjyxMapping.toDomain(parbmfzjyxdto);
		parbmfzjyxService.create(domain);
        PARBMFZJYXDTO dto = parbmfzjyxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxMapping.toDomain(#parbmfzjyxdtos),'ehr-PARBMFZJYX-Create')")
    @ApiOperation(value = "createBatch", tags = {"PARBMFZJYX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parbmfzjyxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARBMFZJYXDTO> parbmfzjyxdtos) {
        parbmfzjyxService.createBatch(parbmfzjyxMapping.toDomain(parbmfzjyxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"PARBMFZJYX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parbmfzjyxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARBMFZJYXDTO parbmfzjyxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parbmfzjyxService.checkKey(parbmfzjyxMapping.toDomain(parbmfzjyxdto)));
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxService.get(#parbmfzjyx_id),'ehr-PARBMFZJYX-Remove')")
    @ApiOperation(value = "Remove", tags = {"PARBMFZJYX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parbmfzjyxes/{parbmfzjyx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parbmfzjyx_id") String parbmfzjyx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parbmfzjyxService.remove(parbmfzjyx_id));
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxService.getParbmfzjyxByIds(#ids),'ehr-PARBMFZJYX-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PARBMFZJYX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parbmfzjyxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parbmfzjyxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxService.get(#parbmfzjyx_id),'ehr-PARBMFZJYX-Update')")
    @ApiOperation(value = "Update", tags = {"PARBMFZJYX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parbmfzjyxes/{parbmfzjyx_id}")
    @Transactional
    public ResponseEntity<PARBMFZJYXDTO> update(@PathVariable("parbmfzjyx_id") String parbmfzjyx_id, @RequestBody PARBMFZJYXDTO parbmfzjyxdto) {
		PARBMFZJYX domain  = parbmfzjyxMapping.toDomain(parbmfzjyxdto);
        domain .setParbmfzjyxid(parbmfzjyx_id);
		parbmfzjyxService.update(domain );
		PARBMFZJYXDTO dto = parbmfzjyxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxService.getParbmfzjyxByEntities(this.parbmfzjyxMapping.toDomain(#parbmfzjyxdtos)),'ehr-PARBMFZJYX-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PARBMFZJYX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parbmfzjyxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARBMFZJYXDTO> parbmfzjyxdtos) {
        parbmfzjyxService.updateBatch(parbmfzjyxMapping.toDomain(parbmfzjyxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parbmfzjyxMapping.toDomain(returnObject.body),'ehr-PARBMFZJYX-Get')")
    @ApiOperation(value = "Get", tags = {"PARBMFZJYX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parbmfzjyxes/{parbmfzjyx_id}")
    public ResponseEntity<PARBMFZJYXDTO> get(@PathVariable("parbmfzjyx_id") String parbmfzjyx_id) {
        PARBMFZJYX domain = parbmfzjyxService.get(parbmfzjyx_id);
        PARBMFZJYXDTO dto = parbmfzjyxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARBMFZJYX-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PARBMFZJYX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parbmfzjyxes/fetchdefault")
	public ResponseEntity<List<PARBMFZJYXDTO>> fetchDefault(PARBMFZJYXSearchContext context) {
        Page<PARBMFZJYX> domains = parbmfzjyxService.searchDefault(context) ;
        List<PARBMFZJYXDTO> list = parbmfzjyxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARBMFZJYX-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PARBMFZJYX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parbmfzjyxes/searchdefault")
	public ResponseEntity<Page<PARBMFZJYXDTO>> searchDefault(@RequestBody PARBMFZJYXSearchContext context) {
        Page<PARBMFZJYX> domains = parbmfzjyxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parbmfzjyxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.parbmfzjyxMapping.toDomain(#parbmfzjyxdto),'ehr-PARBMFZJYX-Save')")
    @ApiOperation(value = "SaveByPARTZGG", tags = {"PARBMFZJYX" },  notes = "SaveByPARTZGG")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parbmfzjyxes/save")
    public ResponseEntity<Boolean> saveByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @RequestBody PARBMFZJYXDTO parbmfzjyxdto) {
        PARBMFZJYX domain = parbmfzjyxMapping.toDomain(parbmfzjyxdto);
        domain.setPartzggid(partzgg_id);
        return ResponseEntity.status(HttpStatus.OK).body(parbmfzjyxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxMapping.toDomain(#parbmfzjyxdtos),'ehr-PARBMFZJYX-Save')")
    @ApiOperation(value = "SaveBatchByPARTZGG", tags = {"PARBMFZJYX" },  notes = "SaveBatchByPARTZGG")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parbmfzjyxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @RequestBody List<PARBMFZJYXDTO> parbmfzjyxdtos) {
        List<PARBMFZJYX> domainlist=parbmfzjyxMapping.toDomain(parbmfzjyxdtos);
        for(PARBMFZJYX domain:domainlist){
             domain.setPartzggid(partzgg_id);
        }
        parbmfzjyxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPARTZGG", tags = {"PARBMFZJYX" },  notes = "GetDraftByPARTZGG")
    @RequestMapping(method = RequestMethod.GET, value = "/partzggs/{partzgg_id}/parbmfzjyxes/getdraft")
    public ResponseEntity<PARBMFZJYXDTO> getDraftByPARTZGG(@PathVariable("partzgg_id") String partzgg_id) {
        PARBMFZJYX domain = new PARBMFZJYX();
        domain.setPartzggid(partzgg_id);
        return ResponseEntity.status(HttpStatus.OK).body(parbmfzjyxMapping.toDto(parbmfzjyxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxMapping.toDomain(#parbmfzjyxdto),'ehr-PARBMFZJYX-Create')")
    @ApiOperation(value = "CreateByPARTZGG", tags = {"PARBMFZJYX" },  notes = "CreateByPARTZGG")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parbmfzjyxes")
    @Transactional
    public ResponseEntity<PARBMFZJYXDTO> createByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @RequestBody PARBMFZJYXDTO parbmfzjyxdto) {
        PARBMFZJYX domain = parbmfzjyxMapping.toDomain(parbmfzjyxdto);
        domain.setPartzggid(partzgg_id);
		parbmfzjyxService.create(domain);
        PARBMFZJYXDTO dto = parbmfzjyxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxMapping.toDomain(#parbmfzjyxdtos),'ehr-PARBMFZJYX-Create')")
    @ApiOperation(value = "createBatchByPARTZGG", tags = {"PARBMFZJYX" },  notes = "createBatchByPARTZGG")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parbmfzjyxes/batch")
    public ResponseEntity<Boolean> createBatchByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @RequestBody List<PARBMFZJYXDTO> parbmfzjyxdtos) {
        List<PARBMFZJYX> domainlist=parbmfzjyxMapping.toDomain(parbmfzjyxdtos);
        for(PARBMFZJYX domain:domainlist){
            domain.setPartzggid(partzgg_id);
        }
        parbmfzjyxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByPARTZGG", tags = {"PARBMFZJYX" },  notes = "CheckKeyByPARTZGG")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parbmfzjyxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @RequestBody PARBMFZJYXDTO parbmfzjyxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parbmfzjyxService.checkKey(parbmfzjyxMapping.toDomain(parbmfzjyxdto)));
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxService.get(#parbmfzjyx_id),'ehr-PARBMFZJYX-Remove')")
    @ApiOperation(value = "RemoveByPARTZGG", tags = {"PARBMFZJYX" },  notes = "RemoveByPARTZGG")
	@RequestMapping(method = RequestMethod.DELETE, value = "/partzggs/{partzgg_id}/parbmfzjyxes/{parbmfzjyx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @PathVariable("parbmfzjyx_id") String parbmfzjyx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(parbmfzjyxService.remove(parbmfzjyx_id));
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxService.getParbmfzjyxByIds(#ids),'ehr-PARBMFZJYX-Remove')")
    @ApiOperation(value = "RemoveBatchByPARTZGG", tags = {"PARBMFZJYX" },  notes = "RemoveBatchByPARTZGG")
	@RequestMapping(method = RequestMethod.DELETE, value = "/partzggs/{partzgg_id}/parbmfzjyxes/batch")
    public ResponseEntity<Boolean> removeBatchByPARTZGG(@RequestBody List<String> ids) {
        parbmfzjyxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxService.get(#parbmfzjyx_id),'ehr-PARBMFZJYX-Update')")
    @ApiOperation(value = "UpdateByPARTZGG", tags = {"PARBMFZJYX" },  notes = "UpdateByPARTZGG")
	@RequestMapping(method = RequestMethod.PUT, value = "/partzggs/{partzgg_id}/parbmfzjyxes/{parbmfzjyx_id}")
    @Transactional
    public ResponseEntity<PARBMFZJYXDTO> updateByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @PathVariable("parbmfzjyx_id") String parbmfzjyx_id, @RequestBody PARBMFZJYXDTO parbmfzjyxdto) {
        PARBMFZJYX domain = parbmfzjyxMapping.toDomain(parbmfzjyxdto);
        domain.setPartzggid(partzgg_id);
        domain.setParbmfzjyxid(parbmfzjyx_id);
		parbmfzjyxService.update(domain);
        PARBMFZJYXDTO dto = parbmfzjyxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxService.getParbmfzjyxByEntities(this.parbmfzjyxMapping.toDomain(#parbmfzjyxdtos)),'ehr-PARBMFZJYX-Update')")
    @ApiOperation(value = "UpdateBatchByPARTZGG", tags = {"PARBMFZJYX" },  notes = "UpdateBatchByPARTZGG")
	@RequestMapping(method = RequestMethod.PUT, value = "/partzggs/{partzgg_id}/parbmfzjyxes/batch")
    public ResponseEntity<Boolean> updateBatchByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @RequestBody List<PARBMFZJYXDTO> parbmfzjyxdtos) {
        List<PARBMFZJYX> domainlist=parbmfzjyxMapping.toDomain(parbmfzjyxdtos);
        for(PARBMFZJYX domain:domainlist){
            domain.setPartzggid(partzgg_id);
        }
        parbmfzjyxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parbmfzjyxMapping.toDomain(returnObject.body),'ehr-PARBMFZJYX-Get')")
    @ApiOperation(value = "GetByPARTZGG", tags = {"PARBMFZJYX" },  notes = "GetByPARTZGG")
	@RequestMapping(method = RequestMethod.GET, value = "/partzggs/{partzgg_id}/parbmfzjyxes/{parbmfzjyx_id}")
    public ResponseEntity<PARBMFZJYXDTO> getByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @PathVariable("parbmfzjyx_id") String parbmfzjyx_id) {
        PARBMFZJYX domain = parbmfzjyxService.get(parbmfzjyx_id);
        PARBMFZJYXDTO dto = parbmfzjyxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARBMFZJYX-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPARTZGG", tags = {"PARBMFZJYX" } ,notes = "fetchDEFAULTByPARTZGG")
    @RequestMapping(method= RequestMethod.GET , value="/partzggs/{partzgg_id}/parbmfzjyxes/fetchdefault")
	public ResponseEntity<List<PARBMFZJYXDTO>> fetchPARBMFZJYXDefaultByPARTZGG(@PathVariable("partzgg_id") String partzgg_id,PARBMFZJYXSearchContext context) {
        context.setN_partzggid_eq(partzgg_id);
        Page<PARBMFZJYX> domains = parbmfzjyxService.searchDefault(context) ;
        List<PARBMFZJYXDTO> list = parbmfzjyxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARBMFZJYX-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPARTZGG", tags = {"PARBMFZJYX" } ,notes = "searchDEFAULTByPARTZGG")
    @RequestMapping(method= RequestMethod.POST , value="/partzggs/{partzgg_id}/parbmfzjyxes/searchdefault")
	public ResponseEntity<Page<PARBMFZJYXDTO>> searchPARBMFZJYXDefaultByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @RequestBody PARBMFZJYXSearchContext context) {
        context.setN_partzggid_eq(partzgg_id);
        Page<PARBMFZJYX> domains = parbmfzjyxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parbmfzjyxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.parbmfzjyxMapping.toDomain(#parbmfzjyxdto),'ehr-PARBMFZJYX-Save')")
    @ApiOperation(value = "SaveByPIMPERSON", tags = {"PARBMFZJYX" },  notes = "SaveByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/parbmfzjyxes/save")
    public ResponseEntity<Boolean> saveByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PARBMFZJYXDTO parbmfzjyxdto) {
        PARBMFZJYX domain = parbmfzjyxMapping.toDomain(parbmfzjyxdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(parbmfzjyxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxMapping.toDomain(#parbmfzjyxdtos),'ehr-PARBMFZJYX-Save')")
    @ApiOperation(value = "SaveBatchByPIMPERSON", tags = {"PARBMFZJYX" },  notes = "SaveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/parbmfzjyxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PARBMFZJYXDTO> parbmfzjyxdtos) {
        List<PARBMFZJYX> domainlist=parbmfzjyxMapping.toDomain(parbmfzjyxdtos);
        for(PARBMFZJYX domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        parbmfzjyxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPIMPERSON", tags = {"PARBMFZJYX" },  notes = "GetDraftByPIMPERSON")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/parbmfzjyxes/getdraft")
    public ResponseEntity<PARBMFZJYXDTO> getDraftByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id) {
        PARBMFZJYX domain = new PARBMFZJYX();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(parbmfzjyxMapping.toDto(parbmfzjyxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxMapping.toDomain(#parbmfzjyxdto),'ehr-PARBMFZJYX-Create')")
    @ApiOperation(value = "CreateByPIMPERSON", tags = {"PARBMFZJYX" },  notes = "CreateByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/parbmfzjyxes")
    @Transactional
    public ResponseEntity<PARBMFZJYXDTO> createByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PARBMFZJYXDTO parbmfzjyxdto) {
        PARBMFZJYX domain = parbmfzjyxMapping.toDomain(parbmfzjyxdto);
        domain.setPimpersonid(pimperson_id);
		parbmfzjyxService.create(domain);
        PARBMFZJYXDTO dto = parbmfzjyxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxMapping.toDomain(#parbmfzjyxdtos),'ehr-PARBMFZJYX-Create')")
    @ApiOperation(value = "createBatchByPIMPERSON", tags = {"PARBMFZJYX" },  notes = "createBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/parbmfzjyxes/batch")
    public ResponseEntity<Boolean> createBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PARBMFZJYXDTO> parbmfzjyxdtos) {
        List<PARBMFZJYX> domainlist=parbmfzjyxMapping.toDomain(parbmfzjyxdtos);
        for(PARBMFZJYX domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        parbmfzjyxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByPIMPERSON", tags = {"PARBMFZJYX" },  notes = "CheckKeyByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/parbmfzjyxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PARBMFZJYXDTO parbmfzjyxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parbmfzjyxService.checkKey(parbmfzjyxMapping.toDomain(parbmfzjyxdto)));
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxService.get(#parbmfzjyx_id),'ehr-PARBMFZJYX-Remove')")
    @ApiOperation(value = "RemoveByPIMPERSON", tags = {"PARBMFZJYX" },  notes = "RemoveByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/parbmfzjyxes/{parbmfzjyx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("parbmfzjyx_id") String parbmfzjyx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(parbmfzjyxService.remove(parbmfzjyx_id));
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxService.getParbmfzjyxByIds(#ids),'ehr-PARBMFZJYX-Remove')")
    @ApiOperation(value = "RemoveBatchByPIMPERSON", tags = {"PARBMFZJYX" },  notes = "RemoveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/parbmfzjyxes/batch")
    public ResponseEntity<Boolean> removeBatchByPIMPERSON(@RequestBody List<String> ids) {
        parbmfzjyxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxService.get(#parbmfzjyx_id),'ehr-PARBMFZJYX-Update')")
    @ApiOperation(value = "UpdateByPIMPERSON", tags = {"PARBMFZJYX" },  notes = "UpdateByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/parbmfzjyxes/{parbmfzjyx_id}")
    @Transactional
    public ResponseEntity<PARBMFZJYXDTO> updateByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("parbmfzjyx_id") String parbmfzjyx_id, @RequestBody PARBMFZJYXDTO parbmfzjyxdto) {
        PARBMFZJYX domain = parbmfzjyxMapping.toDomain(parbmfzjyxdto);
        domain.setPimpersonid(pimperson_id);
        domain.setParbmfzjyxid(parbmfzjyx_id);
		parbmfzjyxService.update(domain);
        PARBMFZJYXDTO dto = parbmfzjyxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parbmfzjyxService.getParbmfzjyxByEntities(this.parbmfzjyxMapping.toDomain(#parbmfzjyxdtos)),'ehr-PARBMFZJYX-Update')")
    @ApiOperation(value = "UpdateBatchByPIMPERSON", tags = {"PARBMFZJYX" },  notes = "UpdateBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/parbmfzjyxes/batch")
    public ResponseEntity<Boolean> updateBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PARBMFZJYXDTO> parbmfzjyxdtos) {
        List<PARBMFZJYX> domainlist=parbmfzjyxMapping.toDomain(parbmfzjyxdtos);
        for(PARBMFZJYX domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        parbmfzjyxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parbmfzjyxMapping.toDomain(returnObject.body),'ehr-PARBMFZJYX-Get')")
    @ApiOperation(value = "GetByPIMPERSON", tags = {"PARBMFZJYX" },  notes = "GetByPIMPERSON")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/parbmfzjyxes/{parbmfzjyx_id}")
    public ResponseEntity<PARBMFZJYXDTO> getByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("parbmfzjyx_id") String parbmfzjyx_id) {
        PARBMFZJYX domain = parbmfzjyxService.get(parbmfzjyx_id);
        PARBMFZJYXDTO dto = parbmfzjyxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARBMFZJYX-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPIMPERSON", tags = {"PARBMFZJYX" } ,notes = "fetchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/parbmfzjyxes/fetchdefault")
	public ResponseEntity<List<PARBMFZJYXDTO>> fetchPARBMFZJYXDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PARBMFZJYXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PARBMFZJYX> domains = parbmfzjyxService.searchDefault(context) ;
        List<PARBMFZJYXDTO> list = parbmfzjyxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARBMFZJYX-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPIMPERSON", tags = {"PARBMFZJYX" } ,notes = "searchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/parbmfzjyxes/searchdefault")
	public ResponseEntity<Page<PARBMFZJYXDTO>> searchPARBMFZJYXDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PARBMFZJYXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PARBMFZJYX> domains = parbmfzjyxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parbmfzjyxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

