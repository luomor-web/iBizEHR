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
    @ApiOperation(value = "CheckKeyByOrmOrgsector", tags = {"PARZNBMMX" },  notes = "CheckKeyByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/parznbmmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody PARZNBMMXDTO parznbmmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parznbmmxService.checkKey(parznbmmxMapping.toDomain(parznbmmxdto)));
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.get(#parznbmmx_id),'ehr-PARZNBMMX-Update')")
    @ApiOperation(value = "UpdateByOrmOrgsector", tags = {"PARZNBMMX" },  notes = "UpdateByOrmOrgsector")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/parznbmmxes/{parznbmmx_id}")
    @Transactional
    public ResponseEntity<PARZNBMMXDTO> updateByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("parznbmmx_id") String parznbmmx_id, @RequestBody PARZNBMMXDTO parznbmmxdto) {
        PARZNBMMX domain = parznbmmxMapping.toDomain(parznbmmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        domain.setParznbmmxid(parznbmmx_id);
		parznbmmxService.update(domain);
        PARZNBMMXDTO dto = parznbmmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.getParznbmmxByEntities(this.parznbmmxMapping.toDomain(#parznbmmxdtos)),'ehr-PARZNBMMX-Update')")
    @ApiOperation(value = "UpdateBatchByOrmOrgsector", tags = {"PARZNBMMX" },  notes = "UpdateBatchByOrmOrgsector")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/parznbmmxes/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<PARZNBMMXDTO> parznbmmxdtos) {
        List<PARZNBMMX> domainlist=parznbmmxMapping.toDomain(parznbmmxdtos);
        for(PARZNBMMX domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        parznbmmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByOrmOrgsector", tags = {"PARZNBMMX" },  notes = "GetDraftByOrmOrgsector")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/parznbmmxes/getdraft")
    public ResponseEntity<PARZNBMMXDTO> getDraftByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id) {
        PARZNBMMX domain = new PARZNBMMX();
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(parznbmmxMapping.toDto(parznbmmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdto),'ehr-PARZNBMMX-Create')")
    @ApiOperation(value = "CreateByOrmOrgsector", tags = {"PARZNBMMX" },  notes = "CreateByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/parznbmmxes")
    @Transactional
    public ResponseEntity<PARZNBMMXDTO> createByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody PARZNBMMXDTO parznbmmxdto) {
        PARZNBMMX domain = parznbmmxMapping.toDomain(parznbmmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
		parznbmmxService.create(domain);
        PARZNBMMXDTO dto = parznbmmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdtos),'ehr-PARZNBMMX-Create')")
    @ApiOperation(value = "createBatchByOrmOrgsector", tags = {"PARZNBMMX" },  notes = "createBatchByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/parznbmmxes/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<PARZNBMMXDTO> parznbmmxdtos) {
        List<PARZNBMMX> domainlist=parznbmmxMapping.toDomain(parznbmmxdtos);
        for(PARZNBMMX domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        parznbmmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.get(#parznbmmx_id),'ehr-PARZNBMMX-Remove')")
    @ApiOperation(value = "RemoveByOrmOrgsector", tags = {"PARZNBMMX" },  notes = "RemoveByOrmOrgsector")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/parznbmmxes/{parznbmmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("parznbmmx_id") String parznbmmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(parznbmmxService.remove(parznbmmx_id));
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.getParznbmmxByIds(#ids),'ehr-PARZNBMMX-Remove')")
    @ApiOperation(value = "RemoveBatchByOrmOrgsector", tags = {"PARZNBMMX" },  notes = "RemoveBatchByOrmOrgsector")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/parznbmmxes/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgsector(@RequestBody List<String> ids) {
        parznbmmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdto),'ehr-PARZNBMMX-Save')")
    @ApiOperation(value = "SaveByOrmOrgsector", tags = {"PARZNBMMX" },  notes = "SaveByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/parznbmmxes/save")
    public ResponseEntity<Boolean> saveByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody PARZNBMMXDTO parznbmmxdto) {
        PARZNBMMX domain = parznbmmxMapping.toDomain(parznbmmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(parznbmmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdtos),'ehr-PARZNBMMX-Save')")
    @ApiOperation(value = "SaveBatchByOrmOrgsector", tags = {"PARZNBMMX" },  notes = "SaveBatchByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/parznbmmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<PARZNBMMXDTO> parznbmmxdtos) {
        List<PARZNBMMX> domainlist=parznbmmxMapping.toDomain(parznbmmxdtos);
        for(PARZNBMMX domain:domainlist){
             domain.setOrmorgsectorid(ormorgsector_id);
        }
        parznbmmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parznbmmxMapping.toDomain(returnObject.body),'ehr-PARZNBMMX-Get')")
    @ApiOperation(value = "GetByOrmOrgsector", tags = {"PARZNBMMX" },  notes = "GetByOrmOrgsector")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/parznbmmxes/{parznbmmx_id}")
    public ResponseEntity<PARZNBMMXDTO> getByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("parznbmmx_id") String parznbmmx_id) {
        PARZNBMMX domain = parznbmmxService.get(parznbmmx_id);
        PARZNBMMXDTO dto = parznbmmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARZNBMMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByOrmOrgsector", tags = {"PARZNBMMX" } ,notes = "fetchDEFAULTByOrmOrgsector")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/{ormorgsector_id}/parznbmmxes/fetchdefault")
	public ResponseEntity<List<PARZNBMMXDTO>> fetchPARZNBMMXDefaultByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id,PARZNBMMXSearchContext context) {
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
	@ApiOperation(value = "searchDEFAULTByOrmOrgsector", tags = {"PARZNBMMX" } ,notes = "searchDEFAULTByOrmOrgsector")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/{ormorgsector_id}/parznbmmxes/searchdefault")
	public ResponseEntity<Page<PARZNBMMXDTO>> searchPARZNBMMXDefaultByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody PARZNBMMXSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<PARZNBMMX> domains = parznbmmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parznbmmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "CheckKeyByParTzgg", tags = {"PARZNBMMX" },  notes = "CheckKeyByParTzgg")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parznbmmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @RequestBody PARZNBMMXDTO parznbmmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parznbmmxService.checkKey(parznbmmxMapping.toDomain(parznbmmxdto)));
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.get(#parznbmmx_id),'ehr-PARZNBMMX-Update')")
    @ApiOperation(value = "UpdateByParTzgg", tags = {"PARZNBMMX" },  notes = "UpdateByParTzgg")
	@RequestMapping(method = RequestMethod.PUT, value = "/partzggs/{partzgg_id}/parznbmmxes/{parznbmmx_id}")
    @Transactional
    public ResponseEntity<PARZNBMMXDTO> updateByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @PathVariable("parznbmmx_id") String parznbmmx_id, @RequestBody PARZNBMMXDTO parznbmmxdto) {
        PARZNBMMX domain = parznbmmxMapping.toDomain(parznbmmxdto);
        domain.setPartzggid(partzgg_id);
        domain.setParznbmmxid(parznbmmx_id);
		parznbmmxService.update(domain);
        PARZNBMMXDTO dto = parznbmmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.getParznbmmxByEntities(this.parznbmmxMapping.toDomain(#parznbmmxdtos)),'ehr-PARZNBMMX-Update')")
    @ApiOperation(value = "UpdateBatchByParTzgg", tags = {"PARZNBMMX" },  notes = "UpdateBatchByParTzgg")
	@RequestMapping(method = RequestMethod.PUT, value = "/partzggs/{partzgg_id}/parznbmmxes/batch")
    public ResponseEntity<Boolean> updateBatchByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @RequestBody List<PARZNBMMXDTO> parznbmmxdtos) {
        List<PARZNBMMX> domainlist=parznbmmxMapping.toDomain(parznbmmxdtos);
        for(PARZNBMMX domain:domainlist){
            domain.setPartzggid(partzgg_id);
        }
        parznbmmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByParTzgg", tags = {"PARZNBMMX" },  notes = "GetDraftByParTzgg")
    @RequestMapping(method = RequestMethod.GET, value = "/partzggs/{partzgg_id}/parznbmmxes/getdraft")
    public ResponseEntity<PARZNBMMXDTO> getDraftByParTzgg(@PathVariable("partzgg_id") String partzgg_id) {
        PARZNBMMX domain = new PARZNBMMX();
        domain.setPartzggid(partzgg_id);
        return ResponseEntity.status(HttpStatus.OK).body(parznbmmxMapping.toDto(parznbmmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdto),'ehr-PARZNBMMX-Create')")
    @ApiOperation(value = "CreateByParTzgg", tags = {"PARZNBMMX" },  notes = "CreateByParTzgg")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parznbmmxes")
    @Transactional
    public ResponseEntity<PARZNBMMXDTO> createByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @RequestBody PARZNBMMXDTO parznbmmxdto) {
        PARZNBMMX domain = parznbmmxMapping.toDomain(parznbmmxdto);
        domain.setPartzggid(partzgg_id);
		parznbmmxService.create(domain);
        PARZNBMMXDTO dto = parznbmmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdtos),'ehr-PARZNBMMX-Create')")
    @ApiOperation(value = "createBatchByParTzgg", tags = {"PARZNBMMX" },  notes = "createBatchByParTzgg")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parznbmmxes/batch")
    public ResponseEntity<Boolean> createBatchByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @RequestBody List<PARZNBMMXDTO> parznbmmxdtos) {
        List<PARZNBMMX> domainlist=parznbmmxMapping.toDomain(parznbmmxdtos);
        for(PARZNBMMX domain:domainlist){
            domain.setPartzggid(partzgg_id);
        }
        parznbmmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.get(#parznbmmx_id),'ehr-PARZNBMMX-Remove')")
    @ApiOperation(value = "RemoveByParTzgg", tags = {"PARZNBMMX" },  notes = "RemoveByParTzgg")
	@RequestMapping(method = RequestMethod.DELETE, value = "/partzggs/{partzgg_id}/parznbmmxes/{parznbmmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @PathVariable("parznbmmx_id") String parznbmmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(parznbmmxService.remove(parznbmmx_id));
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.getParznbmmxByIds(#ids),'ehr-PARZNBMMX-Remove')")
    @ApiOperation(value = "RemoveBatchByParTzgg", tags = {"PARZNBMMX" },  notes = "RemoveBatchByParTzgg")
	@RequestMapping(method = RequestMethod.DELETE, value = "/partzggs/{partzgg_id}/parznbmmxes/batch")
    public ResponseEntity<Boolean> removeBatchByParTzgg(@RequestBody List<String> ids) {
        parznbmmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdto),'ehr-PARZNBMMX-Save')")
    @ApiOperation(value = "SaveByParTzgg", tags = {"PARZNBMMX" },  notes = "SaveByParTzgg")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parznbmmxes/save")
    public ResponseEntity<Boolean> saveByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @RequestBody PARZNBMMXDTO parznbmmxdto) {
        PARZNBMMX domain = parznbmmxMapping.toDomain(parznbmmxdto);
        domain.setPartzggid(partzgg_id);
        return ResponseEntity.status(HttpStatus.OK).body(parznbmmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdtos),'ehr-PARZNBMMX-Save')")
    @ApiOperation(value = "SaveBatchByParTzgg", tags = {"PARZNBMMX" },  notes = "SaveBatchByParTzgg")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parznbmmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @RequestBody List<PARZNBMMXDTO> parznbmmxdtos) {
        List<PARZNBMMX> domainlist=parznbmmxMapping.toDomain(parznbmmxdtos);
        for(PARZNBMMX domain:domainlist){
             domain.setPartzggid(partzgg_id);
        }
        parznbmmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parznbmmxMapping.toDomain(returnObject.body),'ehr-PARZNBMMX-Get')")
    @ApiOperation(value = "GetByParTzgg", tags = {"PARZNBMMX" },  notes = "GetByParTzgg")
	@RequestMapping(method = RequestMethod.GET, value = "/partzggs/{partzgg_id}/parznbmmxes/{parznbmmx_id}")
    public ResponseEntity<PARZNBMMXDTO> getByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @PathVariable("parznbmmx_id") String parznbmmx_id) {
        PARZNBMMX domain = parznbmmxService.get(parznbmmx_id);
        PARZNBMMXDTO dto = parznbmmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARZNBMMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByParTzgg", tags = {"PARZNBMMX" } ,notes = "fetchDEFAULTByParTzgg")
    @RequestMapping(method= RequestMethod.GET , value="/partzggs/{partzgg_id}/parznbmmxes/fetchdefault")
	public ResponseEntity<List<PARZNBMMXDTO>> fetchPARZNBMMXDefaultByParTzgg(@PathVariable("partzgg_id") String partzgg_id,PARZNBMMXSearchContext context) {
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
	@ApiOperation(value = "searchDEFAULTByParTzgg", tags = {"PARZNBMMX" } ,notes = "searchDEFAULTByParTzgg")
    @RequestMapping(method= RequestMethod.POST , value="/partzggs/{partzgg_id}/parznbmmxes/searchdefault")
	public ResponseEntity<Page<PARZNBMMXDTO>> searchPARZNBMMXDefaultByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @RequestBody PARZNBMMXSearchContext context) {
        context.setN_partzggid_eq(partzgg_id);
        Page<PARZNBMMX> domains = parznbmmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parznbmmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "CheckKeyByOrmOrgOrmOrgsector", tags = {"PARZNBMMX" },  notes = "CheckKeyByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody PARZNBMMXDTO parznbmmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parznbmmxService.checkKey(parznbmmxMapping.toDomain(parznbmmxdto)));
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.get(#parznbmmx_id),'ehr-PARZNBMMX-Update')")
    @ApiOperation(value = "UpdateByOrmOrgOrmOrgsector", tags = {"PARZNBMMX" },  notes = "UpdateByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes/{parznbmmx_id}")
    @Transactional
    public ResponseEntity<PARZNBMMXDTO> updateByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("parznbmmx_id") String parznbmmx_id, @RequestBody PARZNBMMXDTO parznbmmxdto) {
        PARZNBMMX domain = parznbmmxMapping.toDomain(parznbmmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        domain.setParznbmmxid(parznbmmx_id);
		parznbmmxService.update(domain);
        PARZNBMMXDTO dto = parznbmmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.getParznbmmxByEntities(this.parznbmmxMapping.toDomain(#parznbmmxdtos)),'ehr-PARZNBMMX-Update')")
    @ApiOperation(value = "UpdateBatchByOrmOrgOrmOrgsector", tags = {"PARZNBMMX" },  notes = "UpdateBatchByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<PARZNBMMXDTO> parznbmmxdtos) {
        List<PARZNBMMX> domainlist=parznbmmxMapping.toDomain(parznbmmxdtos);
        for(PARZNBMMX domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        parznbmmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByOrmOrgOrmOrgsector", tags = {"PARZNBMMX" },  notes = "GetDraftByOrmOrgOrmOrgsector")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes/getdraft")
    public ResponseEntity<PARZNBMMXDTO> getDraftByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id) {
        PARZNBMMX domain = new PARZNBMMX();
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(parznbmmxMapping.toDto(parznbmmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdto),'ehr-PARZNBMMX-Create')")
    @ApiOperation(value = "CreateByOrmOrgOrmOrgsector", tags = {"PARZNBMMX" },  notes = "CreateByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes")
    @Transactional
    public ResponseEntity<PARZNBMMXDTO> createByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody PARZNBMMXDTO parznbmmxdto) {
        PARZNBMMX domain = parznbmmxMapping.toDomain(parznbmmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
		parznbmmxService.create(domain);
        PARZNBMMXDTO dto = parznbmmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdtos),'ehr-PARZNBMMX-Create')")
    @ApiOperation(value = "createBatchByOrmOrgOrmOrgsector", tags = {"PARZNBMMX" },  notes = "createBatchByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<PARZNBMMXDTO> parznbmmxdtos) {
        List<PARZNBMMX> domainlist=parznbmmxMapping.toDomain(parznbmmxdtos);
        for(PARZNBMMX domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        parznbmmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.get(#parznbmmx_id),'ehr-PARZNBMMX-Remove')")
    @ApiOperation(value = "RemoveByOrmOrgOrmOrgsector", tags = {"PARZNBMMX" },  notes = "RemoveByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes/{parznbmmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("parznbmmx_id") String parznbmmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(parznbmmxService.remove(parznbmmx_id));
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.getParznbmmxByIds(#ids),'ehr-PARZNBMMX-Remove')")
    @ApiOperation(value = "RemoveBatchByOrmOrgOrmOrgsector", tags = {"PARZNBMMX" },  notes = "RemoveBatchByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgOrmOrgsector(@RequestBody List<String> ids) {
        parznbmmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdto),'ehr-PARZNBMMX-Save')")
    @ApiOperation(value = "SaveByOrmOrgOrmOrgsector", tags = {"PARZNBMMX" },  notes = "SaveByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes/save")
    public ResponseEntity<Boolean> saveByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody PARZNBMMXDTO parznbmmxdto) {
        PARZNBMMX domain = parznbmmxMapping.toDomain(parznbmmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(parznbmmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdtos),'ehr-PARZNBMMX-Save')")
    @ApiOperation(value = "SaveBatchByOrmOrgOrmOrgsector", tags = {"PARZNBMMX" },  notes = "SaveBatchByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<PARZNBMMXDTO> parznbmmxdtos) {
        List<PARZNBMMX> domainlist=parznbmmxMapping.toDomain(parznbmmxdtos);
        for(PARZNBMMX domain:domainlist){
             domain.setOrmorgsectorid(ormorgsector_id);
        }
        parznbmmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parznbmmxMapping.toDomain(returnObject.body),'ehr-PARZNBMMX-Get')")
    @ApiOperation(value = "GetByOrmOrgOrmOrgsector", tags = {"PARZNBMMX" },  notes = "GetByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes/{parznbmmx_id}")
    public ResponseEntity<PARZNBMMXDTO> getByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("parznbmmx_id") String parznbmmx_id) {
        PARZNBMMX domain = parznbmmxService.get(parznbmmx_id);
        PARZNBMMXDTO dto = parznbmmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARZNBMMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByOrmOrgOrmOrgsector", tags = {"PARZNBMMX" } ,notes = "fetchDEFAULTByOrmOrgOrmOrgsector")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes/fetchdefault")
	public ResponseEntity<List<PARZNBMMXDTO>> fetchPARZNBMMXDefaultByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id,PARZNBMMXSearchContext context) {
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
	@ApiOperation(value = "searchDEFAULTByOrmOrgOrmOrgsector", tags = {"PARZNBMMX" } ,notes = "searchDEFAULTByOrmOrgOrmOrgsector")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes/searchdefault")
	public ResponseEntity<Page<PARZNBMMXDTO>> searchPARZNBMMXDefaultByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody PARZNBMMXSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<PARZNBMMX> domains = parznbmmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parznbmmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

