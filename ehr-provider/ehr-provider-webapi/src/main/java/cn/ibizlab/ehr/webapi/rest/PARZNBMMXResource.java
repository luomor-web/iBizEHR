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
import cn.ibizlab.ehr.core.par.domain.PARZNBMMX;
import cn.ibizlab.ehr.core.par.service.IPARZNBMMXService;
import cn.ibizlab.ehr.core.par.filter.PARZNBMMXSearchContext;

@Slf4j
@Api(tags = {"PARZNBMMX" })
@RestController("WebApi-parznbmmx")
@RequestMapping("")
public class PARZNBMMXResource {

    @Autowired
    public IPARZNBMMXService parznbmmxService;

    @Autowired
    @Lazy
    public PARZNBMMXMapping parznbmmxMapping;

    @ApiOperation(value = "CheckKey", tags = {"PARZNBMMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARZNBMMXDTO parznbmmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parznbmmxService.checkKey(parznbmmxMapping.toDomain(parznbmmxdto)));
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.get(#parznbmmx_id),'ehr-PARZNBMMX-Update')")
    @ApiOperation(value = "Update", tags = {"PARZNBMMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parznbmmxes/{parznbmmx_id}")
    @Transactional
    public ResponseEntity<PARZNBMMXDTO> update(@PathVariable("parznbmmx_id") String parznbmmx_id, @RequestBody PARZNBMMXDTO parznbmmxdto) {
		PARZNBMMX domain  = parznbmmxMapping.toDomain(parznbmmxdto);
        domain .setParznbmmxid(parznbmmx_id);
		parznbmmxService.update(domain );
		PARZNBMMXDTO dto = parznbmmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.getParznbmmxByEntities(this.parznbmmxMapping.toDomain(#parznbmmxdtos)),'ehr-PARZNBMMX-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PARZNBMMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parznbmmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARZNBMMXDTO> parznbmmxdtos) {
        parznbmmxService.updateBatch(parznbmmxMapping.toDomain(parznbmmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"PARZNBMMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parznbmmxes/getdraft")
    public ResponseEntity<PARZNBMMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parznbmmxMapping.toDto(parznbmmxService.getDraft(new PARZNBMMX())));
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdto),'ehr-PARZNBMMX-Create')")
    @ApiOperation(value = "Create", tags = {"PARZNBMMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmmxes")
    @Transactional
    public ResponseEntity<PARZNBMMXDTO> create(@RequestBody PARZNBMMXDTO parznbmmxdto) {
        PARZNBMMX domain = parznbmmxMapping.toDomain(parznbmmxdto);
		parznbmmxService.create(domain);
        PARZNBMMXDTO dto = parznbmmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdtos),'ehr-PARZNBMMX-Create')")
    @ApiOperation(value = "createBatch", tags = {"PARZNBMMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARZNBMMXDTO> parznbmmxdtos) {
        parznbmmxService.createBatch(parznbmmxMapping.toDomain(parznbmmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.get(#parznbmmx_id),'ehr-PARZNBMMX-Remove')")
    @ApiOperation(value = "Remove", tags = {"PARZNBMMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parznbmmxes/{parznbmmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parznbmmx_id") String parznbmmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parznbmmxService.remove(parznbmmx_id));
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.getParznbmmxByIds(#ids),'ehr-PARZNBMMX-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PARZNBMMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parznbmmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parznbmmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdto),'ehr-PARZNBMMX-Save')")
    @ApiOperation(value = "Save", tags = {"PARZNBMMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PARZNBMMXDTO parznbmmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parznbmmxService.save(parznbmmxMapping.toDomain(parznbmmxdto)));
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdtos),'ehr-PARZNBMMX-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PARZNBMMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARZNBMMXDTO> parznbmmxdtos) {
        parznbmmxService.saveBatch(parznbmmxMapping.toDomain(parznbmmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parznbmmxMapping.toDomain(returnObject.body),'ehr-PARZNBMMX-Get')")
    @ApiOperation(value = "Get", tags = {"PARZNBMMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parznbmmxes/{parznbmmx_id}")
    public ResponseEntity<PARZNBMMXDTO> get(@PathVariable("parznbmmx_id") String parznbmmx_id) {
        PARZNBMMX domain = parznbmmxService.get(parznbmmx_id);
        PARZNBMMXDTO dto = parznbmmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARZNBMMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PARZNBMMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parznbmmxes/fetchdefault")
	public ResponseEntity<List<PARZNBMMXDTO>> fetchDefault(PARZNBMMXSearchContext context) {
        Page<PARZNBMMX> domains = parznbmmxService.searchDefault(context) ;
        List<PARZNBMMXDTO> list = parznbmmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARZNBMMX-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PARZNBMMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parznbmmxes/searchdefault")
	public ResponseEntity<Page<PARZNBMMXDTO>> searchDefault(@RequestBody PARZNBMMXSearchContext context) {
        Page<PARZNBMMX> domains = parznbmmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parznbmmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "CheckKeyByORMORGSECTOR", tags = {"PARZNBMMX" },  notes = "CheckKeyByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/parznbmmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody PARZNBMMXDTO parznbmmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parznbmmxService.checkKey(parznbmmxMapping.toDomain(parznbmmxdto)));
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.get(#parznbmmx_id),'ehr-PARZNBMMX-Update')")
    @ApiOperation(value = "UpdateByORMORGSECTOR", tags = {"PARZNBMMX" },  notes = "UpdateByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/parznbmmxes/{parznbmmx_id}")
    @Transactional
    public ResponseEntity<PARZNBMMXDTO> updateByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("parznbmmx_id") String parznbmmx_id, @RequestBody PARZNBMMXDTO parznbmmxdto) {
        PARZNBMMX domain = parznbmmxMapping.toDomain(parznbmmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        domain.setParznbmmxid(parznbmmx_id);
		parznbmmxService.update(domain);
        PARZNBMMXDTO dto = parznbmmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.getParznbmmxByEntities(this.parznbmmxMapping.toDomain(#parznbmmxdtos)),'ehr-PARZNBMMX-Update')")
    @ApiOperation(value = "UpdateBatchByORMORGSECTOR", tags = {"PARZNBMMX" },  notes = "UpdateBatchByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/parznbmmxes/batch")
    public ResponseEntity<Boolean> updateBatchByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<PARZNBMMXDTO> parznbmmxdtos) {
        List<PARZNBMMX> domainlist=parznbmmxMapping.toDomain(parznbmmxdtos);
        for(PARZNBMMX domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        parznbmmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByORMORGSECTOR", tags = {"PARZNBMMX" },  notes = "GetDraftByORMORGSECTOR")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/parznbmmxes/getdraft")
    public ResponseEntity<PARZNBMMXDTO> getDraftByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id) {
        PARZNBMMX domain = new PARZNBMMX();
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(parznbmmxMapping.toDto(parznbmmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdto),'ehr-PARZNBMMX-Create')")
    @ApiOperation(value = "CreateByORMORGSECTOR", tags = {"PARZNBMMX" },  notes = "CreateByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/parznbmmxes")
    @Transactional
    public ResponseEntity<PARZNBMMXDTO> createByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody PARZNBMMXDTO parznbmmxdto) {
        PARZNBMMX domain = parznbmmxMapping.toDomain(parznbmmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
		parznbmmxService.create(domain);
        PARZNBMMXDTO dto = parznbmmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdtos),'ehr-PARZNBMMX-Create')")
    @ApiOperation(value = "createBatchByORMORGSECTOR", tags = {"PARZNBMMX" },  notes = "createBatchByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/parznbmmxes/batch")
    public ResponseEntity<Boolean> createBatchByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<PARZNBMMXDTO> parznbmmxdtos) {
        List<PARZNBMMX> domainlist=parznbmmxMapping.toDomain(parznbmmxdtos);
        for(PARZNBMMX domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        parznbmmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.get(#parznbmmx_id),'ehr-PARZNBMMX-Remove')")
    @ApiOperation(value = "RemoveByORMORGSECTOR", tags = {"PARZNBMMX" },  notes = "RemoveByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/parznbmmxes/{parznbmmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("parznbmmx_id") String parznbmmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(parznbmmxService.remove(parznbmmx_id));
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.getParznbmmxByIds(#ids),'ehr-PARZNBMMX-Remove')")
    @ApiOperation(value = "RemoveBatchByORMORGSECTOR", tags = {"PARZNBMMX" },  notes = "RemoveBatchByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/parznbmmxes/batch")
    public ResponseEntity<Boolean> removeBatchByORMORGSECTOR(@RequestBody List<String> ids) {
        parznbmmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdto),'ehr-PARZNBMMX-Save')")
    @ApiOperation(value = "SaveByORMORGSECTOR", tags = {"PARZNBMMX" },  notes = "SaveByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/parznbmmxes/save")
    public ResponseEntity<Boolean> saveByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody PARZNBMMXDTO parznbmmxdto) {
        PARZNBMMX domain = parznbmmxMapping.toDomain(parznbmmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(parznbmmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdtos),'ehr-PARZNBMMX-Save')")
    @ApiOperation(value = "SaveBatchByORMORGSECTOR", tags = {"PARZNBMMX" },  notes = "SaveBatchByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/parznbmmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<PARZNBMMXDTO> parznbmmxdtos) {
        List<PARZNBMMX> domainlist=parznbmmxMapping.toDomain(parznbmmxdtos);
        for(PARZNBMMX domain:domainlist){
             domain.setOrmorgsectorid(ormorgsector_id);
        }
        parznbmmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parznbmmxMapping.toDomain(returnObject.body),'ehr-PARZNBMMX-Get')")
    @ApiOperation(value = "GetByORMORGSECTOR", tags = {"PARZNBMMX" },  notes = "GetByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/parznbmmxes/{parznbmmx_id}")
    public ResponseEntity<PARZNBMMXDTO> getByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("parznbmmx_id") String parznbmmx_id) {
        PARZNBMMX domain = parznbmmxService.get(parznbmmx_id);
        PARZNBMMXDTO dto = parznbmmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARZNBMMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByORMORGSECTOR", tags = {"PARZNBMMX" } ,notes = "fetchDEFAULTByORMORGSECTOR")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/{ormorgsector_id}/parznbmmxes/fetchdefault")
	public ResponseEntity<List<PARZNBMMXDTO>> fetchPARZNBMMXDefaultByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id,PARZNBMMXSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<PARZNBMMX> domains = parznbmmxService.searchDefault(context) ;
        List<PARZNBMMXDTO> list = parznbmmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARZNBMMX-Default-all')")
	@ApiOperation(value = "searchDEFAULTByORMORGSECTOR", tags = {"PARZNBMMX" } ,notes = "searchDEFAULTByORMORGSECTOR")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/{ormorgsector_id}/parznbmmxes/searchdefault")
	public ResponseEntity<Page<PARZNBMMXDTO>> searchPARZNBMMXDefaultByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody PARZNBMMXSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<PARZNBMMX> domains = parznbmmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parznbmmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "CheckKeyByPARTZGG", tags = {"PARZNBMMX" },  notes = "CheckKeyByPARTZGG")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parznbmmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @RequestBody PARZNBMMXDTO parznbmmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parznbmmxService.checkKey(parznbmmxMapping.toDomain(parznbmmxdto)));
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.get(#parznbmmx_id),'ehr-PARZNBMMX-Update')")
    @ApiOperation(value = "UpdateByPARTZGG", tags = {"PARZNBMMX" },  notes = "UpdateByPARTZGG")
	@RequestMapping(method = RequestMethod.PUT, value = "/partzggs/{partzgg_id}/parznbmmxes/{parznbmmx_id}")
    @Transactional
    public ResponseEntity<PARZNBMMXDTO> updateByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @PathVariable("parznbmmx_id") String parznbmmx_id, @RequestBody PARZNBMMXDTO parznbmmxdto) {
        PARZNBMMX domain = parznbmmxMapping.toDomain(parznbmmxdto);
        domain.setPartzggid(partzgg_id);
        domain.setParznbmmxid(parznbmmx_id);
		parznbmmxService.update(domain);
        PARZNBMMXDTO dto = parznbmmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.getParznbmmxByEntities(this.parznbmmxMapping.toDomain(#parznbmmxdtos)),'ehr-PARZNBMMX-Update')")
    @ApiOperation(value = "UpdateBatchByPARTZGG", tags = {"PARZNBMMX" },  notes = "UpdateBatchByPARTZGG")
	@RequestMapping(method = RequestMethod.PUT, value = "/partzggs/{partzgg_id}/parznbmmxes/batch")
    public ResponseEntity<Boolean> updateBatchByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @RequestBody List<PARZNBMMXDTO> parznbmmxdtos) {
        List<PARZNBMMX> domainlist=parznbmmxMapping.toDomain(parznbmmxdtos);
        for(PARZNBMMX domain:domainlist){
            domain.setPartzggid(partzgg_id);
        }
        parznbmmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPARTZGG", tags = {"PARZNBMMX" },  notes = "GetDraftByPARTZGG")
    @RequestMapping(method = RequestMethod.GET, value = "/partzggs/{partzgg_id}/parznbmmxes/getdraft")
    public ResponseEntity<PARZNBMMXDTO> getDraftByPARTZGG(@PathVariable("partzgg_id") String partzgg_id) {
        PARZNBMMX domain = new PARZNBMMX();
        domain.setPartzggid(partzgg_id);
        return ResponseEntity.status(HttpStatus.OK).body(parznbmmxMapping.toDto(parznbmmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdto),'ehr-PARZNBMMX-Create')")
    @ApiOperation(value = "CreateByPARTZGG", tags = {"PARZNBMMX" },  notes = "CreateByPARTZGG")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parznbmmxes")
    @Transactional
    public ResponseEntity<PARZNBMMXDTO> createByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @RequestBody PARZNBMMXDTO parznbmmxdto) {
        PARZNBMMX domain = parznbmmxMapping.toDomain(parznbmmxdto);
        domain.setPartzggid(partzgg_id);
		parznbmmxService.create(domain);
        PARZNBMMXDTO dto = parznbmmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdtos),'ehr-PARZNBMMX-Create')")
    @ApiOperation(value = "createBatchByPARTZGG", tags = {"PARZNBMMX" },  notes = "createBatchByPARTZGG")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parznbmmxes/batch")
    public ResponseEntity<Boolean> createBatchByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @RequestBody List<PARZNBMMXDTO> parznbmmxdtos) {
        List<PARZNBMMX> domainlist=parznbmmxMapping.toDomain(parznbmmxdtos);
        for(PARZNBMMX domain:domainlist){
            domain.setPartzggid(partzgg_id);
        }
        parznbmmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.get(#parznbmmx_id),'ehr-PARZNBMMX-Remove')")
    @ApiOperation(value = "RemoveByPARTZGG", tags = {"PARZNBMMX" },  notes = "RemoveByPARTZGG")
	@RequestMapping(method = RequestMethod.DELETE, value = "/partzggs/{partzgg_id}/parznbmmxes/{parznbmmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @PathVariable("parznbmmx_id") String parznbmmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(parznbmmxService.remove(parznbmmx_id));
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.getParznbmmxByIds(#ids),'ehr-PARZNBMMX-Remove')")
    @ApiOperation(value = "RemoveBatchByPARTZGG", tags = {"PARZNBMMX" },  notes = "RemoveBatchByPARTZGG")
	@RequestMapping(method = RequestMethod.DELETE, value = "/partzggs/{partzgg_id}/parznbmmxes/batch")
    public ResponseEntity<Boolean> removeBatchByPARTZGG(@RequestBody List<String> ids) {
        parznbmmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdto),'ehr-PARZNBMMX-Save')")
    @ApiOperation(value = "SaveByPARTZGG", tags = {"PARZNBMMX" },  notes = "SaveByPARTZGG")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parznbmmxes/save")
    public ResponseEntity<Boolean> saveByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @RequestBody PARZNBMMXDTO parznbmmxdto) {
        PARZNBMMX domain = parznbmmxMapping.toDomain(parznbmmxdto);
        domain.setPartzggid(partzgg_id);
        return ResponseEntity.status(HttpStatus.OK).body(parznbmmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdtos),'ehr-PARZNBMMX-Save')")
    @ApiOperation(value = "SaveBatchByPARTZGG", tags = {"PARZNBMMX" },  notes = "SaveBatchByPARTZGG")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parznbmmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @RequestBody List<PARZNBMMXDTO> parznbmmxdtos) {
        List<PARZNBMMX> domainlist=parznbmmxMapping.toDomain(parznbmmxdtos);
        for(PARZNBMMX domain:domainlist){
             domain.setPartzggid(partzgg_id);
        }
        parznbmmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parznbmmxMapping.toDomain(returnObject.body),'ehr-PARZNBMMX-Get')")
    @ApiOperation(value = "GetByPARTZGG", tags = {"PARZNBMMX" },  notes = "GetByPARTZGG")
	@RequestMapping(method = RequestMethod.GET, value = "/partzggs/{partzgg_id}/parznbmmxes/{parznbmmx_id}")
    public ResponseEntity<PARZNBMMXDTO> getByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @PathVariable("parznbmmx_id") String parznbmmx_id) {
        PARZNBMMX domain = parznbmmxService.get(parznbmmx_id);
        PARZNBMMXDTO dto = parznbmmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARZNBMMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPARTZGG", tags = {"PARZNBMMX" } ,notes = "fetchDEFAULTByPARTZGG")
    @RequestMapping(method= RequestMethod.GET , value="/partzggs/{partzgg_id}/parznbmmxes/fetchdefault")
	public ResponseEntity<List<PARZNBMMXDTO>> fetchPARZNBMMXDefaultByPARTZGG(@PathVariable("partzgg_id") String partzgg_id,PARZNBMMXSearchContext context) {
        context.setN_partzggid_eq(partzgg_id);
        Page<PARZNBMMX> domains = parznbmmxService.searchDefault(context) ;
        List<PARZNBMMXDTO> list = parznbmmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARZNBMMX-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPARTZGG", tags = {"PARZNBMMX" } ,notes = "searchDEFAULTByPARTZGG")
    @RequestMapping(method= RequestMethod.POST , value="/partzggs/{partzgg_id}/parznbmmxes/searchdefault")
	public ResponseEntity<Page<PARZNBMMXDTO>> searchPARZNBMMXDefaultByPARTZGG(@PathVariable("partzgg_id") String partzgg_id, @RequestBody PARZNBMMXSearchContext context) {
        context.setN_partzggid_eq(partzgg_id);
        Page<PARZNBMMX> domains = parznbmmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parznbmmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "CheckKeyByORMORGORMORGSECTOR", tags = {"PARZNBMMX" },  notes = "CheckKeyByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody PARZNBMMXDTO parznbmmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parznbmmxService.checkKey(parznbmmxMapping.toDomain(parznbmmxdto)));
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.get(#parznbmmx_id),'ehr-PARZNBMMX-Update')")
    @ApiOperation(value = "UpdateByORMORGORMORGSECTOR", tags = {"PARZNBMMX" },  notes = "UpdateByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes/{parznbmmx_id}")
    @Transactional
    public ResponseEntity<PARZNBMMXDTO> updateByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("parznbmmx_id") String parznbmmx_id, @RequestBody PARZNBMMXDTO parznbmmxdto) {
        PARZNBMMX domain = parznbmmxMapping.toDomain(parznbmmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        domain.setParznbmmxid(parznbmmx_id);
		parznbmmxService.update(domain);
        PARZNBMMXDTO dto = parznbmmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.getParznbmmxByEntities(this.parznbmmxMapping.toDomain(#parznbmmxdtos)),'ehr-PARZNBMMX-Update')")
    @ApiOperation(value = "UpdateBatchByORMORGORMORGSECTOR", tags = {"PARZNBMMX" },  notes = "UpdateBatchByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes/batch")
    public ResponseEntity<Boolean> updateBatchByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<PARZNBMMXDTO> parznbmmxdtos) {
        List<PARZNBMMX> domainlist=parznbmmxMapping.toDomain(parznbmmxdtos);
        for(PARZNBMMX domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        parznbmmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByORMORGORMORGSECTOR", tags = {"PARZNBMMX" },  notes = "GetDraftByORMORGORMORGSECTOR")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes/getdraft")
    public ResponseEntity<PARZNBMMXDTO> getDraftByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id) {
        PARZNBMMX domain = new PARZNBMMX();
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(parznbmmxMapping.toDto(parznbmmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdto),'ehr-PARZNBMMX-Create')")
    @ApiOperation(value = "CreateByORMORGORMORGSECTOR", tags = {"PARZNBMMX" },  notes = "CreateByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes")
    @Transactional
    public ResponseEntity<PARZNBMMXDTO> createByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody PARZNBMMXDTO parznbmmxdto) {
        PARZNBMMX domain = parznbmmxMapping.toDomain(parznbmmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
		parznbmmxService.create(domain);
        PARZNBMMXDTO dto = parznbmmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdtos),'ehr-PARZNBMMX-Create')")
    @ApiOperation(value = "createBatchByORMORGORMORGSECTOR", tags = {"PARZNBMMX" },  notes = "createBatchByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes/batch")
    public ResponseEntity<Boolean> createBatchByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<PARZNBMMXDTO> parznbmmxdtos) {
        List<PARZNBMMX> domainlist=parznbmmxMapping.toDomain(parznbmmxdtos);
        for(PARZNBMMX domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        parznbmmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.get(#parznbmmx_id),'ehr-PARZNBMMX-Remove')")
    @ApiOperation(value = "RemoveByORMORGORMORGSECTOR", tags = {"PARZNBMMX" },  notes = "RemoveByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes/{parznbmmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("parznbmmx_id") String parznbmmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(parznbmmxService.remove(parznbmmx_id));
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.getParznbmmxByIds(#ids),'ehr-PARZNBMMX-Remove')")
    @ApiOperation(value = "RemoveBatchByORMORGORMORGSECTOR", tags = {"PARZNBMMX" },  notes = "RemoveBatchByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes/batch")
    public ResponseEntity<Boolean> removeBatchByORMORGORMORGSECTOR(@RequestBody List<String> ids) {
        parznbmmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdto),'ehr-PARZNBMMX-Save')")
    @ApiOperation(value = "SaveByORMORGORMORGSECTOR", tags = {"PARZNBMMX" },  notes = "SaveByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes/save")
    public ResponseEntity<Boolean> saveByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody PARZNBMMXDTO parznbmmxdto) {
        PARZNBMMX domain = parznbmmxMapping.toDomain(parznbmmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(parznbmmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdtos),'ehr-PARZNBMMX-Save')")
    @ApiOperation(value = "SaveBatchByORMORGORMORGSECTOR", tags = {"PARZNBMMX" },  notes = "SaveBatchByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<PARZNBMMXDTO> parznbmmxdtos) {
        List<PARZNBMMX> domainlist=parznbmmxMapping.toDomain(parznbmmxdtos);
        for(PARZNBMMX domain:domainlist){
             domain.setOrmorgsectorid(ormorgsector_id);
        }
        parznbmmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parznbmmxMapping.toDomain(returnObject.body),'ehr-PARZNBMMX-Get')")
    @ApiOperation(value = "GetByORMORGORMORGSECTOR", tags = {"PARZNBMMX" },  notes = "GetByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes/{parznbmmx_id}")
    public ResponseEntity<PARZNBMMXDTO> getByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("parznbmmx_id") String parznbmmx_id) {
        PARZNBMMX domain = parznbmmxService.get(parznbmmx_id);
        PARZNBMMXDTO dto = parznbmmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARZNBMMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByORMORGORMORGSECTOR", tags = {"PARZNBMMX" } ,notes = "fetchDEFAULTByORMORGORMORGSECTOR")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes/fetchdefault")
	public ResponseEntity<List<PARZNBMMXDTO>> fetchPARZNBMMXDefaultByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id,PARZNBMMXSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<PARZNBMMX> domains = parznbmmxService.searchDefault(context) ;
        List<PARZNBMMXDTO> list = parznbmmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARZNBMMX-Default-all')")
	@ApiOperation(value = "searchDEFAULTByORMORGORMORGSECTOR", tags = {"PARZNBMMX" } ,notes = "searchDEFAULTByORMORGORMORGSECTOR")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes/searchdefault")
	public ResponseEntity<Page<PARZNBMMXDTO>> searchPARZNBMMXDefaultByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody PARZNBMMXSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<PARZNBMMX> domains = parznbmmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parznbmmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

