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
import cn.ibizlab.ehr.core.trm.domain.TRMTRAINFILLIN;
import cn.ibizlab.ehr.core.trm.service.ITRMTRAINFILLINService;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINFILLINSearchContext;

@Slf4j
@Api(tags = {"TRMTRAINFILLIN" })
@RestController("WebApi-trmtrainfillin")
@RequestMapping("")
public class TRMTRAINFILLINResource {

    @Autowired
    public ITRMTRAINFILLINService trmtrainfillinService;

    @Autowired
    @Lazy
    public TRMTRAINFILLINMapping trmtrainfillinMapping;

    @PostAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(returnObject.body),'ehr-TRMTRAINFILLIN-Get')")
    @ApiOperation(value = "Get", tags = {"TRMTRAINFILLIN" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainfillins/{trmtrainfillin_id}")
    public ResponseEntity<TRMTRAINFILLINDTO> get(@PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
        TRMTRAINFILLIN domain = trmtrainfillinService.get(trmtrainfillin_id);
        TRMTRAINFILLINDTO dto = trmtrainfillinMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.get(#trmtrainfillin_id),'ehr-TRMTRAINFILLIN-Update')")
    @ApiOperation(value = "Update", tags = {"TRMTRAINFILLIN" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainfillins/{trmtrainfillin_id}")
    @Transactional
    public ResponseEntity<TRMTRAINFILLINDTO> update(@PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody TRMTRAINFILLINDTO trmtrainfillindto) {
		TRMTRAINFILLIN domain  = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain .setTrmtrainfillinid(trmtrainfillin_id);
		trmtrainfillinService.update(domain );
		TRMTRAINFILLINDTO dto = trmtrainfillinMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.getTrmtrainfillinByEntities(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos)),'ehr-TRMTRAINFILLIN-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"TRMTRAINFILLIN" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainfillins/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMTRAINFILLINDTO> trmtrainfillindtos) {
        trmtrainfillinService.updateBatch(trmtrainfillinMapping.toDomain(trmtrainfillindtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"TRMTRAINFILLIN" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfillins/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMTRAINFILLINDTO trmtrainfillindto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.checkKey(trmtrainfillinMapping.toDomain(trmtrainfillindto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindto),'ehr-TRMTRAINFILLIN-Create')")
    @ApiOperation(value = "Create", tags = {"TRMTRAINFILLIN" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfillins")
    @Transactional
    public ResponseEntity<TRMTRAINFILLINDTO> create(@RequestBody TRMTRAINFILLINDTO trmtrainfillindto) {
        TRMTRAINFILLIN domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
		trmtrainfillinService.create(domain);
        TRMTRAINFILLINDTO dto = trmtrainfillinMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos),'ehr-TRMTRAINFILLIN-Create')")
    @ApiOperation(value = "createBatch", tags = {"TRMTRAINFILLIN" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfillins/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMTRAINFILLINDTO> trmtrainfillindtos) {
        trmtrainfillinService.createBatch(trmtrainfillinMapping.toDomain(trmtrainfillindtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindto),'ehr-TRMTRAINFILLIN-Save')")
    @ApiOperation(value = "Save", tags = {"TRMTRAINFILLIN" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfillins/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMTRAINFILLINDTO trmtrainfillindto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.save(trmtrainfillinMapping.toDomain(trmtrainfillindto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos),'ehr-TRMTRAINFILLIN-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"TRMTRAINFILLIN" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfillins/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMTRAINFILLINDTO> trmtrainfillindtos) {
        trmtrainfillinService.saveBatch(trmtrainfillinMapping.toDomain(trmtrainfillindtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"TRMTRAINFILLIN" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainfillins/getdraft")
    public ResponseEntity<TRMTRAINFILLINDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinMapping.toDto(trmtrainfillinService.getDraft(new TRMTRAINFILLIN())));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.get(#trmtrainfillin_id),'ehr-TRMTRAINFILLIN-Remove')")
    @ApiOperation(value = "Remove", tags = {"TRMTRAINFILLIN" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainfillins/{trmtrainfillin_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.remove(trmtrainfillin_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.getTrmtrainfillinByIds(#ids),'ehr-TRMTRAINFILLIN-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"TRMTRAINFILLIN" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainfillins/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtrainfillinService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINFILLIN-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TRMTRAINFILLIN" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainfillins/fetchdefault")
	public ResponseEntity<List<TRMTRAINFILLINDTO>> fetchDefault(TRMTRAINFILLINSearchContext context) {
        Page<TRMTRAINFILLIN> domains = trmtrainfillinService.searchDefault(context) ;
        List<TRMTRAINFILLINDTO> list = trmtrainfillinMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINFILLIN-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TRMTRAINFILLIN" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainfillins/searchdefault")
	public ResponseEntity<Page<TRMTRAINFILLINDTO>> searchDefault(@RequestBody TRMTRAINFILLINSearchContext context) {
        Page<TRMTRAINFILLIN> domains = trmtrainfillinService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainfillinMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(returnObject.body),'ehr-TRMTRAINFILLIN-Get')")
    @ApiOperation(value = "GetByOrmOrgsector", tags = {"TRMTRAINFILLIN" },  notes = "GetByOrmOrgsector")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}")
    public ResponseEntity<TRMTRAINFILLINDTO> getByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
        TRMTRAINFILLIN domain = trmtrainfillinService.get(trmtrainfillin_id);
        TRMTRAINFILLINDTO dto = trmtrainfillinMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.get(#trmtrainfillin_id),'ehr-TRMTRAINFILLIN-Update')")
    @ApiOperation(value = "UpdateByOrmOrgsector", tags = {"TRMTRAINFILLIN" },  notes = "UpdateByOrmOrgsector")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}")
    @Transactional
    public ResponseEntity<TRMTRAINFILLINDTO> updateByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody TRMTRAINFILLINDTO trmtrainfillindto) {
        TRMTRAINFILLIN domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setOrmorgsectorid(ormorgsector_id);
        domain.setTrmtrainfillinid(trmtrainfillin_id);
		trmtrainfillinService.update(domain);
        TRMTRAINFILLINDTO dto = trmtrainfillinMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.getTrmtrainfillinByEntities(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos)),'ehr-TRMTRAINFILLIN-Update')")
    @ApiOperation(value = "UpdateBatchByOrmOrgsector", tags = {"TRMTRAINFILLIN" },  notes = "UpdateBatchByOrmOrgsector")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<TRMTRAINFILLINDTO> trmtrainfillindtos) {
        List<TRMTRAINFILLIN> domainlist=trmtrainfillinMapping.toDomain(trmtrainfillindtos);
        for(TRMTRAINFILLIN domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        trmtrainfillinService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByOrmOrgsector", tags = {"TRMTRAINFILLIN" },  notes = "CheckKeyByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody TRMTRAINFILLINDTO trmtrainfillindto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.checkKey(trmtrainfillinMapping.toDomain(trmtrainfillindto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindto),'ehr-TRMTRAINFILLIN-Create')")
    @ApiOperation(value = "CreateByOrmOrgsector", tags = {"TRMTRAINFILLIN" },  notes = "CreateByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins")
    @Transactional
    public ResponseEntity<TRMTRAINFILLINDTO> createByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody TRMTRAINFILLINDTO trmtrainfillindto) {
        TRMTRAINFILLIN domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setOrmorgsectorid(ormorgsector_id);
		trmtrainfillinService.create(domain);
        TRMTRAINFILLINDTO dto = trmtrainfillinMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos),'ehr-TRMTRAINFILLIN-Create')")
    @ApiOperation(value = "createBatchByOrmOrgsector", tags = {"TRMTRAINFILLIN" },  notes = "createBatchByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<TRMTRAINFILLINDTO> trmtrainfillindtos) {
        List<TRMTRAINFILLIN> domainlist=trmtrainfillinMapping.toDomain(trmtrainfillindtos);
        for(TRMTRAINFILLIN domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        trmtrainfillinService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindto),'ehr-TRMTRAINFILLIN-Save')")
    @ApiOperation(value = "SaveByOrmOrgsector", tags = {"TRMTRAINFILLIN" },  notes = "SaveByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/save")
    public ResponseEntity<Boolean> saveByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody TRMTRAINFILLINDTO trmtrainfillindto) {
        TRMTRAINFILLIN domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos),'ehr-TRMTRAINFILLIN-Save')")
    @ApiOperation(value = "SaveBatchByOrmOrgsector", tags = {"TRMTRAINFILLIN" },  notes = "SaveBatchByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<TRMTRAINFILLINDTO> trmtrainfillindtos) {
        List<TRMTRAINFILLIN> domainlist=trmtrainfillinMapping.toDomain(trmtrainfillindtos);
        for(TRMTRAINFILLIN domain:domainlist){
             domain.setOrmorgsectorid(ormorgsector_id);
        }
        trmtrainfillinService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByOrmOrgsector", tags = {"TRMTRAINFILLIN" },  notes = "GetDraftByOrmOrgsector")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/getdraft")
    public ResponseEntity<TRMTRAINFILLINDTO> getDraftByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id) {
        TRMTRAINFILLIN domain = new TRMTRAINFILLIN();
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinMapping.toDto(trmtrainfillinService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.get(#trmtrainfillin_id),'ehr-TRMTRAINFILLIN-Remove')")
    @ApiOperation(value = "RemoveByOrmOrgsector", tags = {"TRMTRAINFILLIN" },  notes = "RemoveByOrmOrgsector")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.remove(trmtrainfillin_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.getTrmtrainfillinByIds(#ids),'ehr-TRMTRAINFILLIN-Remove')")
    @ApiOperation(value = "RemoveBatchByOrmOrgsector", tags = {"TRMTRAINFILLIN" },  notes = "RemoveBatchByOrmOrgsector")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgsector(@RequestBody List<String> ids) {
        trmtrainfillinService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINFILLIN-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByOrmOrgsector", tags = {"TRMTRAINFILLIN" } ,notes = "fetchDEFAULTByOrmOrgsector")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/{ormorgsector_id}/trmtrainfillins/fetchdefault")
	public ResponseEntity<List<TRMTRAINFILLINDTO>> fetchTRMTRAINFILLINDefaultByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id,TRMTRAINFILLINSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<TRMTRAINFILLIN> domains = trmtrainfillinService.searchDefault(context) ;
        List<TRMTRAINFILLINDTO> list = trmtrainfillinMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINFILLIN-Default-all')")
	@ApiOperation(value = "searchDEFAULTByOrmOrgsector", tags = {"TRMTRAINFILLIN" } ,notes = "searchDEFAULTByOrmOrgsector")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/{ormorgsector_id}/trmtrainfillins/searchdefault")
	public ResponseEntity<Page<TRMTRAINFILLINDTO>> searchTRMTRAINFILLINDefaultByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody TRMTRAINFILLINSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<TRMTRAINFILLIN> domains = trmtrainfillinService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainfillinMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(returnObject.body),'ehr-TRMTRAINFILLIN-Get')")
    @ApiOperation(value = "GetByTRMDEPART", tags = {"TRMTRAINFILLIN" },  notes = "GetByTRMDEPART")
	@RequestMapping(method = RequestMethod.GET, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/{trmtrainfillin_id}")
    public ResponseEntity<TRMTRAINFILLINDTO> getByTRMDEPART(@PathVariable("trmdepart_id") String trmdepart_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
        TRMTRAINFILLIN domain = trmtrainfillinService.get(trmtrainfillin_id);
        TRMTRAINFILLINDTO dto = trmtrainfillinMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.get(#trmtrainfillin_id),'ehr-TRMTRAINFILLIN-Update')")
    @ApiOperation(value = "UpdateByTRMDEPART", tags = {"TRMTRAINFILLIN" },  notes = "UpdateByTRMDEPART")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/{trmtrainfillin_id}")
    @Transactional
    public ResponseEntity<TRMTRAINFILLINDTO> updateByTRMDEPART(@PathVariable("trmdepart_id") String trmdepart_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody TRMTRAINFILLINDTO trmtrainfillindto) {
        TRMTRAINFILLIN domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setTrmdepartid(trmdepart_id);
        domain.setTrmtrainfillinid(trmtrainfillin_id);
		trmtrainfillinService.update(domain);
        TRMTRAINFILLINDTO dto = trmtrainfillinMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.getTrmtrainfillinByEntities(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos)),'ehr-TRMTRAINFILLIN-Update')")
    @ApiOperation(value = "UpdateBatchByTRMDEPART", tags = {"TRMTRAINFILLIN" },  notes = "UpdateBatchByTRMDEPART")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/batch")
    public ResponseEntity<Boolean> updateBatchByTRMDEPART(@PathVariable("trmdepart_id") String trmdepart_id, @RequestBody List<TRMTRAINFILLINDTO> trmtrainfillindtos) {
        List<TRMTRAINFILLIN> domainlist=trmtrainfillinMapping.toDomain(trmtrainfillindtos);
        for(TRMTRAINFILLIN domain:domainlist){
            domain.setTrmdepartid(trmdepart_id);
        }
        trmtrainfillinService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByTRMDEPART", tags = {"TRMTRAINFILLIN" },  notes = "CheckKeyByTRMDEPART")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/checkkey")
    public ResponseEntity<Boolean> checkKeyByTRMDEPART(@PathVariable("trmdepart_id") String trmdepart_id, @RequestBody TRMTRAINFILLINDTO trmtrainfillindto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.checkKey(trmtrainfillinMapping.toDomain(trmtrainfillindto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindto),'ehr-TRMTRAINFILLIN-Create')")
    @ApiOperation(value = "CreateByTRMDEPART", tags = {"TRMTRAINFILLIN" },  notes = "CreateByTRMDEPART")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins")
    @Transactional
    public ResponseEntity<TRMTRAINFILLINDTO> createByTRMDEPART(@PathVariable("trmdepart_id") String trmdepart_id, @RequestBody TRMTRAINFILLINDTO trmtrainfillindto) {
        TRMTRAINFILLIN domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setTrmdepartid(trmdepart_id);
		trmtrainfillinService.create(domain);
        TRMTRAINFILLINDTO dto = trmtrainfillinMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos),'ehr-TRMTRAINFILLIN-Create')")
    @ApiOperation(value = "createBatchByTRMDEPART", tags = {"TRMTRAINFILLIN" },  notes = "createBatchByTRMDEPART")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/batch")
    public ResponseEntity<Boolean> createBatchByTRMDEPART(@PathVariable("trmdepart_id") String trmdepart_id, @RequestBody List<TRMTRAINFILLINDTO> trmtrainfillindtos) {
        List<TRMTRAINFILLIN> domainlist=trmtrainfillinMapping.toDomain(trmtrainfillindtos);
        for(TRMTRAINFILLIN domain:domainlist){
            domain.setTrmdepartid(trmdepart_id);
        }
        trmtrainfillinService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindto),'ehr-TRMTRAINFILLIN-Save')")
    @ApiOperation(value = "SaveByTRMDEPART", tags = {"TRMTRAINFILLIN" },  notes = "SaveByTRMDEPART")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/save")
    public ResponseEntity<Boolean> saveByTRMDEPART(@PathVariable("trmdepart_id") String trmdepart_id, @RequestBody TRMTRAINFILLINDTO trmtrainfillindto) {
        TRMTRAINFILLIN domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setTrmdepartid(trmdepart_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos),'ehr-TRMTRAINFILLIN-Save')")
    @ApiOperation(value = "SaveBatchByTRMDEPART", tags = {"TRMTRAINFILLIN" },  notes = "SaveBatchByTRMDEPART")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/savebatch")
    public ResponseEntity<Boolean> saveBatchByTRMDEPART(@PathVariable("trmdepart_id") String trmdepart_id, @RequestBody List<TRMTRAINFILLINDTO> trmtrainfillindtos) {
        List<TRMTRAINFILLIN> domainlist=trmtrainfillinMapping.toDomain(trmtrainfillindtos);
        for(TRMTRAINFILLIN domain:domainlist){
             domain.setTrmdepartid(trmdepart_id);
        }
        trmtrainfillinService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByTRMDEPART", tags = {"TRMTRAINFILLIN" },  notes = "GetDraftByTRMDEPART")
    @RequestMapping(method = RequestMethod.GET, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/getdraft")
    public ResponseEntity<TRMTRAINFILLINDTO> getDraftByTRMDEPART(@PathVariable("trmdepart_id") String trmdepart_id) {
        TRMTRAINFILLIN domain = new TRMTRAINFILLIN();
        domain.setTrmdepartid(trmdepart_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinMapping.toDto(trmtrainfillinService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.get(#trmtrainfillin_id),'ehr-TRMTRAINFILLIN-Remove')")
    @ApiOperation(value = "RemoveByTRMDEPART", tags = {"TRMTRAINFILLIN" },  notes = "RemoveByTRMDEPART")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/{trmtrainfillin_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByTRMDEPART(@PathVariable("trmdepart_id") String trmdepart_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.remove(trmtrainfillin_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.getTrmtrainfillinByIds(#ids),'ehr-TRMTRAINFILLIN-Remove')")
    @ApiOperation(value = "RemoveBatchByTRMDEPART", tags = {"TRMTRAINFILLIN" },  notes = "RemoveBatchByTRMDEPART")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/batch")
    public ResponseEntity<Boolean> removeBatchByTRMDEPART(@RequestBody List<String> ids) {
        trmtrainfillinService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINFILLIN-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByTRMDEPART", tags = {"TRMTRAINFILLIN" } ,notes = "fetchDEFAULTByTRMDEPART")
    @RequestMapping(method= RequestMethod.GET , value="/trmdeparts/{trmdepart_id}/trmtrainfillins/fetchdefault")
	public ResponseEntity<List<TRMTRAINFILLINDTO>> fetchTRMTRAINFILLINDefaultByTRMDEPART(@PathVariable("trmdepart_id") String trmdepart_id,TRMTRAINFILLINSearchContext context) {
        context.setN_trmdepartid_eq(trmdepart_id);
        Page<TRMTRAINFILLIN> domains = trmtrainfillinService.searchDefault(context) ;
        List<TRMTRAINFILLINDTO> list = trmtrainfillinMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINFILLIN-Default-all')")
	@ApiOperation(value = "searchDEFAULTByTRMDEPART", tags = {"TRMTRAINFILLIN" } ,notes = "searchDEFAULTByTRMDEPART")
    @RequestMapping(method= RequestMethod.POST , value="/trmdeparts/{trmdepart_id}/trmtrainfillins/searchdefault")
	public ResponseEntity<Page<TRMTRAINFILLINDTO>> searchTRMTRAINFILLINDefaultByTRMDEPART(@PathVariable("trmdepart_id") String trmdepart_id, @RequestBody TRMTRAINFILLINSearchContext context) {
        context.setN_trmdepartid_eq(trmdepart_id);
        Page<TRMTRAINFILLIN> domains = trmtrainfillinService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainfillinMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(returnObject.body),'ehr-TRMTRAINFILLIN-Get')")
    @ApiOperation(value = "GetByOrmOrgOrmOrgsector", tags = {"TRMTRAINFILLIN" },  notes = "GetByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}")
    public ResponseEntity<TRMTRAINFILLINDTO> getByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
        TRMTRAINFILLIN domain = trmtrainfillinService.get(trmtrainfillin_id);
        TRMTRAINFILLINDTO dto = trmtrainfillinMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.get(#trmtrainfillin_id),'ehr-TRMTRAINFILLIN-Update')")
    @ApiOperation(value = "UpdateByOrmOrgOrmOrgsector", tags = {"TRMTRAINFILLIN" },  notes = "UpdateByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}")
    @Transactional
    public ResponseEntity<TRMTRAINFILLINDTO> updateByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody TRMTRAINFILLINDTO trmtrainfillindto) {
        TRMTRAINFILLIN domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setOrmorgsectorid(ormorgsector_id);
        domain.setTrmtrainfillinid(trmtrainfillin_id);
		trmtrainfillinService.update(domain);
        TRMTRAINFILLINDTO dto = trmtrainfillinMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.getTrmtrainfillinByEntities(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos)),'ehr-TRMTRAINFILLIN-Update')")
    @ApiOperation(value = "UpdateBatchByOrmOrgOrmOrgsector", tags = {"TRMTRAINFILLIN" },  notes = "UpdateBatchByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<TRMTRAINFILLINDTO> trmtrainfillindtos) {
        List<TRMTRAINFILLIN> domainlist=trmtrainfillinMapping.toDomain(trmtrainfillindtos);
        for(TRMTRAINFILLIN domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        trmtrainfillinService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByOrmOrgOrmOrgsector", tags = {"TRMTRAINFILLIN" },  notes = "CheckKeyByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody TRMTRAINFILLINDTO trmtrainfillindto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.checkKey(trmtrainfillinMapping.toDomain(trmtrainfillindto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindto),'ehr-TRMTRAINFILLIN-Create')")
    @ApiOperation(value = "CreateByOrmOrgOrmOrgsector", tags = {"TRMTRAINFILLIN" },  notes = "CreateByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins")
    @Transactional
    public ResponseEntity<TRMTRAINFILLINDTO> createByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody TRMTRAINFILLINDTO trmtrainfillindto) {
        TRMTRAINFILLIN domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setOrmorgsectorid(ormorgsector_id);
		trmtrainfillinService.create(domain);
        TRMTRAINFILLINDTO dto = trmtrainfillinMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos),'ehr-TRMTRAINFILLIN-Create')")
    @ApiOperation(value = "createBatchByOrmOrgOrmOrgsector", tags = {"TRMTRAINFILLIN" },  notes = "createBatchByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<TRMTRAINFILLINDTO> trmtrainfillindtos) {
        List<TRMTRAINFILLIN> domainlist=trmtrainfillinMapping.toDomain(trmtrainfillindtos);
        for(TRMTRAINFILLIN domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        trmtrainfillinService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindto),'ehr-TRMTRAINFILLIN-Save')")
    @ApiOperation(value = "SaveByOrmOrgOrmOrgsector", tags = {"TRMTRAINFILLIN" },  notes = "SaveByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/save")
    public ResponseEntity<Boolean> saveByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody TRMTRAINFILLINDTO trmtrainfillindto) {
        TRMTRAINFILLIN domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos),'ehr-TRMTRAINFILLIN-Save')")
    @ApiOperation(value = "SaveBatchByOrmOrgOrmOrgsector", tags = {"TRMTRAINFILLIN" },  notes = "SaveBatchByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<TRMTRAINFILLINDTO> trmtrainfillindtos) {
        List<TRMTRAINFILLIN> domainlist=trmtrainfillinMapping.toDomain(trmtrainfillindtos);
        for(TRMTRAINFILLIN domain:domainlist){
             domain.setOrmorgsectorid(ormorgsector_id);
        }
        trmtrainfillinService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByOrmOrgOrmOrgsector", tags = {"TRMTRAINFILLIN" },  notes = "GetDraftByOrmOrgOrmOrgsector")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/getdraft")
    public ResponseEntity<TRMTRAINFILLINDTO> getDraftByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id) {
        TRMTRAINFILLIN domain = new TRMTRAINFILLIN();
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinMapping.toDto(trmtrainfillinService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.get(#trmtrainfillin_id),'ehr-TRMTRAINFILLIN-Remove')")
    @ApiOperation(value = "RemoveByOrmOrgOrmOrgsector", tags = {"TRMTRAINFILLIN" },  notes = "RemoveByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.remove(trmtrainfillin_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.getTrmtrainfillinByIds(#ids),'ehr-TRMTRAINFILLIN-Remove')")
    @ApiOperation(value = "RemoveBatchByOrmOrgOrmOrgsector", tags = {"TRMTRAINFILLIN" },  notes = "RemoveBatchByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgOrmOrgsector(@RequestBody List<String> ids) {
        trmtrainfillinService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINFILLIN-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByOrmOrgOrmOrgsector", tags = {"TRMTRAINFILLIN" } ,notes = "fetchDEFAULTByOrmOrgOrmOrgsector")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/fetchdefault")
	public ResponseEntity<List<TRMTRAINFILLINDTO>> fetchTRMTRAINFILLINDefaultByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id,TRMTRAINFILLINSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<TRMTRAINFILLIN> domains = trmtrainfillinService.searchDefault(context) ;
        List<TRMTRAINFILLINDTO> list = trmtrainfillinMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINFILLIN-Default-all')")
	@ApiOperation(value = "searchDEFAULTByOrmOrgOrmOrgsector", tags = {"TRMTRAINFILLIN" } ,notes = "searchDEFAULTByOrmOrgOrmOrgsector")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/searchdefault")
	public ResponseEntity<Page<TRMTRAINFILLINDTO>> searchTRMTRAINFILLINDefaultByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody TRMTRAINFILLINSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<TRMTRAINFILLIN> domains = trmtrainfillinService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainfillinMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

