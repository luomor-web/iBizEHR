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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainFillin;
import cn.ibizlab.ehr.core.trm.service.ITrmTrainFillinService;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainFillinSearchContext;

@Slf4j
@Api(tags = {"TrmTrainFillin" })
@RestController("WebApi-trmtrainfillin")
@RequestMapping("")
public class TrmTrainFillinResource {

    @Autowired
    public ITrmTrainFillinService trmtrainfillinService;

    @Autowired
    @Lazy
    public TrmTrainFillinMapping trmtrainfillinMapping;

    @PostAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(returnObject.body),'ehr-TrmTrainFillin-Get')")
    @ApiOperation(value = "Get", tags = {"TrmTrainFillin" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainfillins/{trmtrainfillin_id}")
    public ResponseEntity<TrmTrainFillinDTO> get(@PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
        TrmTrainFillin domain = trmtrainfillinService.get(trmtrainfillin_id);
        TrmTrainFillinDTO dto = trmtrainfillinMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.get(#trmtrainfillin_id),'ehr-TrmTrainFillin-Update')")
    @ApiOperation(value = "Update", tags = {"TrmTrainFillin" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainfillins/{trmtrainfillin_id}")
    @Transactional
    public ResponseEntity<TrmTrainFillinDTO> update(@PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody TrmTrainFillinDTO trmtrainfillindto) {
		TrmTrainFillin domain  = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain .setTrmtrainfillinid(trmtrainfillin_id);
		trmtrainfillinService.update(domain );
		TrmTrainFillinDTO dto = trmtrainfillinMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.getTrmtrainfillinByEntities(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos)),'ehr-TrmTrainFillin-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"TrmTrainFillin" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainfillins/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmTrainFillinDTO> trmtrainfillindtos) {
        trmtrainfillinService.updateBatch(trmtrainfillinMapping.toDomain(trmtrainfillindtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"TrmTrainFillin" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfillins/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmTrainFillinDTO trmtrainfillindto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.checkKey(trmtrainfillinMapping.toDomain(trmtrainfillindto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindto),'ehr-TrmTrainFillin-Create')")
    @ApiOperation(value = "Create", tags = {"TrmTrainFillin" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfillins")
    @Transactional
    public ResponseEntity<TrmTrainFillinDTO> create(@RequestBody TrmTrainFillinDTO trmtrainfillindto) {
        TrmTrainFillin domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
		trmtrainfillinService.create(domain);
        TrmTrainFillinDTO dto = trmtrainfillinMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos),'ehr-TrmTrainFillin-Create')")
    @ApiOperation(value = "createBatch", tags = {"TrmTrainFillin" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfillins/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmTrainFillinDTO> trmtrainfillindtos) {
        trmtrainfillinService.createBatch(trmtrainfillinMapping.toDomain(trmtrainfillindtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindto),'ehr-TrmTrainFillin-Save')")
    @ApiOperation(value = "Save", tags = {"TrmTrainFillin" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfillins/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmTrainFillinDTO trmtrainfillindto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.save(trmtrainfillinMapping.toDomain(trmtrainfillindto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos),'ehr-TrmTrainFillin-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"TrmTrainFillin" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfillins/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmTrainFillinDTO> trmtrainfillindtos) {
        trmtrainfillinService.saveBatch(trmtrainfillinMapping.toDomain(trmtrainfillindtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"TrmTrainFillin" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainfillins/getdraft")
    public ResponseEntity<TrmTrainFillinDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinMapping.toDto(trmtrainfillinService.getDraft(new TrmTrainFillin())));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.get(#trmtrainfillin_id),'ehr-TrmTrainFillin-Remove')")
    @ApiOperation(value = "Remove", tags = {"TrmTrainFillin" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainfillins/{trmtrainfillin_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.remove(trmtrainfillin_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.getTrmtrainfillinByIds(#ids),'ehr-TrmTrainFillin-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"TrmTrainFillin" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainfillins/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtrainfillinService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainFillin-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TrmTrainFillin" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainfillins/fetchdefault")
	public ResponseEntity<List<TrmTrainFillinDTO>> fetchDefault(TrmTrainFillinSearchContext context) {
        Page<TrmTrainFillin> domains = trmtrainfillinService.searchDefault(context) ;
        List<TrmTrainFillinDTO> list = trmtrainfillinMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainFillin-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TrmTrainFillin" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainfillins/searchdefault")
	public ResponseEntity<Page<TrmTrainFillinDTO>> searchDefault(@RequestBody TrmTrainFillinSearchContext context) {
        Page<TrmTrainFillin> domains = trmtrainfillinService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainfillinMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(returnObject.body),'ehr-TrmTrainFillin-Get')")
    @ApiOperation(value = "GetByOrmOrgsector", tags = {"TrmTrainFillin" },  notes = "GetByOrmOrgsector")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}")
    public ResponseEntity<TrmTrainFillinDTO> getByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
        TrmTrainFillin domain = trmtrainfillinService.get(trmtrainfillin_id);
        TrmTrainFillinDTO dto = trmtrainfillinMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.get(#trmtrainfillin_id),'ehr-TrmTrainFillin-Update')")
    @ApiOperation(value = "UpdateByOrmOrgsector", tags = {"TrmTrainFillin" },  notes = "UpdateByOrmOrgsector")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}")
    @Transactional
    public ResponseEntity<TrmTrainFillinDTO> updateByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody TrmTrainFillinDTO trmtrainfillindto) {
        TrmTrainFillin domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setOrmorgsectorid(ormorgsector_id);
        domain.setTrmtrainfillinid(trmtrainfillin_id);
		trmtrainfillinService.update(domain);
        TrmTrainFillinDTO dto = trmtrainfillinMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.getTrmtrainfillinByEntities(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos)),'ehr-TrmTrainFillin-Update')")
    @ApiOperation(value = "UpdateBatchByOrmOrgsector", tags = {"TrmTrainFillin" },  notes = "UpdateBatchByOrmOrgsector")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<TrmTrainFillinDTO> trmtrainfillindtos) {
        List<TrmTrainFillin> domainlist=trmtrainfillinMapping.toDomain(trmtrainfillindtos);
        for(TrmTrainFillin domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        trmtrainfillinService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByOrmOrgsector", tags = {"TrmTrainFillin" },  notes = "CheckKeyByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody TrmTrainFillinDTO trmtrainfillindto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.checkKey(trmtrainfillinMapping.toDomain(trmtrainfillindto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindto),'ehr-TrmTrainFillin-Create')")
    @ApiOperation(value = "CreateByOrmOrgsector", tags = {"TrmTrainFillin" },  notes = "CreateByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins")
    @Transactional
    public ResponseEntity<TrmTrainFillinDTO> createByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody TrmTrainFillinDTO trmtrainfillindto) {
        TrmTrainFillin domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setOrmorgsectorid(ormorgsector_id);
		trmtrainfillinService.create(domain);
        TrmTrainFillinDTO dto = trmtrainfillinMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos),'ehr-TrmTrainFillin-Create')")
    @ApiOperation(value = "createBatchByOrmOrgsector", tags = {"TrmTrainFillin" },  notes = "createBatchByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<TrmTrainFillinDTO> trmtrainfillindtos) {
        List<TrmTrainFillin> domainlist=trmtrainfillinMapping.toDomain(trmtrainfillindtos);
        for(TrmTrainFillin domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        trmtrainfillinService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindto),'ehr-TrmTrainFillin-Save')")
    @ApiOperation(value = "SaveByOrmOrgsector", tags = {"TrmTrainFillin" },  notes = "SaveByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/save")
    public ResponseEntity<Boolean> saveByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody TrmTrainFillinDTO trmtrainfillindto) {
        TrmTrainFillin domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos),'ehr-TrmTrainFillin-Save')")
    @ApiOperation(value = "SaveBatchByOrmOrgsector", tags = {"TrmTrainFillin" },  notes = "SaveBatchByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<TrmTrainFillinDTO> trmtrainfillindtos) {
        List<TrmTrainFillin> domainlist=trmtrainfillinMapping.toDomain(trmtrainfillindtos);
        for(TrmTrainFillin domain:domainlist){
             domain.setOrmorgsectorid(ormorgsector_id);
        }
        trmtrainfillinService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByOrmOrgsector", tags = {"TrmTrainFillin" },  notes = "GetDraftByOrmOrgsector")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/getdraft")
    public ResponseEntity<TrmTrainFillinDTO> getDraftByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id) {
        TrmTrainFillin domain = new TrmTrainFillin();
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinMapping.toDto(trmtrainfillinService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.get(#trmtrainfillin_id),'ehr-TrmTrainFillin-Remove')")
    @ApiOperation(value = "RemoveByOrmOrgsector", tags = {"TrmTrainFillin" },  notes = "RemoveByOrmOrgsector")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.remove(trmtrainfillin_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.getTrmtrainfillinByIds(#ids),'ehr-TrmTrainFillin-Remove')")
    @ApiOperation(value = "RemoveBatchByOrmOrgsector", tags = {"TrmTrainFillin" },  notes = "RemoveBatchByOrmOrgsector")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgsector(@RequestBody List<String> ids) {
        trmtrainfillinService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainFillin-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByOrmOrgsector", tags = {"TrmTrainFillin" } ,notes = "fetchDEFAULTByOrmOrgsector")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/{ormorgsector_id}/trmtrainfillins/fetchdefault")
	public ResponseEntity<List<TrmTrainFillinDTO>> fetchTrmTrainFillinDefaultByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id,TrmTrainFillinSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<TrmTrainFillin> domains = trmtrainfillinService.searchDefault(context) ;
        List<TrmTrainFillinDTO> list = trmtrainfillinMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainFillin-Default-all')")
	@ApiOperation(value = "searchDEFAULTByOrmOrgsector", tags = {"TrmTrainFillin" } ,notes = "searchDEFAULTByOrmOrgsector")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/{ormorgsector_id}/trmtrainfillins/searchdefault")
	public ResponseEntity<Page<TrmTrainFillinDTO>> searchTrmTrainFillinDefaultByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody TrmTrainFillinSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<TrmTrainFillin> domains = trmtrainfillinService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainfillinMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(returnObject.body),'ehr-TrmTrainFillin-Get')")
    @ApiOperation(value = "GetByTrmDepart", tags = {"TrmTrainFillin" },  notes = "GetByTrmDepart")
	@RequestMapping(method = RequestMethod.GET, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/{trmtrainfillin_id}")
    public ResponseEntity<TrmTrainFillinDTO> getByTrmDepart(@PathVariable("trmdepart_id") String trmdepart_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
        TrmTrainFillin domain = trmtrainfillinService.get(trmtrainfillin_id);
        TrmTrainFillinDTO dto = trmtrainfillinMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.get(#trmtrainfillin_id),'ehr-TrmTrainFillin-Update')")
    @ApiOperation(value = "UpdateByTrmDepart", tags = {"TrmTrainFillin" },  notes = "UpdateByTrmDepart")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/{trmtrainfillin_id}")
    @Transactional
    public ResponseEntity<TrmTrainFillinDTO> updateByTrmDepart(@PathVariable("trmdepart_id") String trmdepart_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody TrmTrainFillinDTO trmtrainfillindto) {
        TrmTrainFillin domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setTrmdepartid(trmdepart_id);
        domain.setTrmtrainfillinid(trmtrainfillin_id);
		trmtrainfillinService.update(domain);
        TrmTrainFillinDTO dto = trmtrainfillinMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.getTrmtrainfillinByEntities(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos)),'ehr-TrmTrainFillin-Update')")
    @ApiOperation(value = "UpdateBatchByTrmDepart", tags = {"TrmTrainFillin" },  notes = "UpdateBatchByTrmDepart")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/batch")
    public ResponseEntity<Boolean> updateBatchByTrmDepart(@PathVariable("trmdepart_id") String trmdepart_id, @RequestBody List<TrmTrainFillinDTO> trmtrainfillindtos) {
        List<TrmTrainFillin> domainlist=trmtrainfillinMapping.toDomain(trmtrainfillindtos);
        for(TrmTrainFillin domain:domainlist){
            domain.setTrmdepartid(trmdepart_id);
        }
        trmtrainfillinService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByTrmDepart", tags = {"TrmTrainFillin" },  notes = "CheckKeyByTrmDepart")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/checkkey")
    public ResponseEntity<Boolean> checkKeyByTrmDepart(@PathVariable("trmdepart_id") String trmdepart_id, @RequestBody TrmTrainFillinDTO trmtrainfillindto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.checkKey(trmtrainfillinMapping.toDomain(trmtrainfillindto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindto),'ehr-TrmTrainFillin-Create')")
    @ApiOperation(value = "CreateByTrmDepart", tags = {"TrmTrainFillin" },  notes = "CreateByTrmDepart")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins")
    @Transactional
    public ResponseEntity<TrmTrainFillinDTO> createByTrmDepart(@PathVariable("trmdepart_id") String trmdepart_id, @RequestBody TrmTrainFillinDTO trmtrainfillindto) {
        TrmTrainFillin domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setTrmdepartid(trmdepart_id);
		trmtrainfillinService.create(domain);
        TrmTrainFillinDTO dto = trmtrainfillinMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos),'ehr-TrmTrainFillin-Create')")
    @ApiOperation(value = "createBatchByTrmDepart", tags = {"TrmTrainFillin" },  notes = "createBatchByTrmDepart")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/batch")
    public ResponseEntity<Boolean> createBatchByTrmDepart(@PathVariable("trmdepart_id") String trmdepart_id, @RequestBody List<TrmTrainFillinDTO> trmtrainfillindtos) {
        List<TrmTrainFillin> domainlist=trmtrainfillinMapping.toDomain(trmtrainfillindtos);
        for(TrmTrainFillin domain:domainlist){
            domain.setTrmdepartid(trmdepart_id);
        }
        trmtrainfillinService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindto),'ehr-TrmTrainFillin-Save')")
    @ApiOperation(value = "SaveByTrmDepart", tags = {"TrmTrainFillin" },  notes = "SaveByTrmDepart")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/save")
    public ResponseEntity<Boolean> saveByTrmDepart(@PathVariable("trmdepart_id") String trmdepart_id, @RequestBody TrmTrainFillinDTO trmtrainfillindto) {
        TrmTrainFillin domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setTrmdepartid(trmdepart_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos),'ehr-TrmTrainFillin-Save')")
    @ApiOperation(value = "SaveBatchByTrmDepart", tags = {"TrmTrainFillin" },  notes = "SaveBatchByTrmDepart")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/savebatch")
    public ResponseEntity<Boolean> saveBatchByTrmDepart(@PathVariable("trmdepart_id") String trmdepart_id, @RequestBody List<TrmTrainFillinDTO> trmtrainfillindtos) {
        List<TrmTrainFillin> domainlist=trmtrainfillinMapping.toDomain(trmtrainfillindtos);
        for(TrmTrainFillin domain:domainlist){
             domain.setTrmdepartid(trmdepart_id);
        }
        trmtrainfillinService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByTrmDepart", tags = {"TrmTrainFillin" },  notes = "GetDraftByTrmDepart")
    @RequestMapping(method = RequestMethod.GET, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/getdraft")
    public ResponseEntity<TrmTrainFillinDTO> getDraftByTrmDepart(@PathVariable("trmdepart_id") String trmdepart_id) {
        TrmTrainFillin domain = new TrmTrainFillin();
        domain.setTrmdepartid(trmdepart_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinMapping.toDto(trmtrainfillinService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.get(#trmtrainfillin_id),'ehr-TrmTrainFillin-Remove')")
    @ApiOperation(value = "RemoveByTrmDepart", tags = {"TrmTrainFillin" },  notes = "RemoveByTrmDepart")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/{trmtrainfillin_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByTrmDepart(@PathVariable("trmdepart_id") String trmdepart_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.remove(trmtrainfillin_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.getTrmtrainfillinByIds(#ids),'ehr-TrmTrainFillin-Remove')")
    @ApiOperation(value = "RemoveBatchByTrmDepart", tags = {"TrmTrainFillin" },  notes = "RemoveBatchByTrmDepart")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/batch")
    public ResponseEntity<Boolean> removeBatchByTrmDepart(@RequestBody List<String> ids) {
        trmtrainfillinService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainFillin-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByTrmDepart", tags = {"TrmTrainFillin" } ,notes = "fetchDEFAULTByTrmDepart")
    @RequestMapping(method= RequestMethod.GET , value="/trmdeparts/{trmdepart_id}/trmtrainfillins/fetchdefault")
	public ResponseEntity<List<TrmTrainFillinDTO>> fetchTrmTrainFillinDefaultByTrmDepart(@PathVariable("trmdepart_id") String trmdepart_id,TrmTrainFillinSearchContext context) {
        context.setN_trmdepartid_eq(trmdepart_id);
        Page<TrmTrainFillin> domains = trmtrainfillinService.searchDefault(context) ;
        List<TrmTrainFillinDTO> list = trmtrainfillinMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainFillin-Default-all')")
	@ApiOperation(value = "searchDEFAULTByTrmDepart", tags = {"TrmTrainFillin" } ,notes = "searchDEFAULTByTrmDepart")
    @RequestMapping(method= RequestMethod.POST , value="/trmdeparts/{trmdepart_id}/trmtrainfillins/searchdefault")
	public ResponseEntity<Page<TrmTrainFillinDTO>> searchTrmTrainFillinDefaultByTrmDepart(@PathVariable("trmdepart_id") String trmdepart_id, @RequestBody TrmTrainFillinSearchContext context) {
        context.setN_trmdepartid_eq(trmdepart_id);
        Page<TrmTrainFillin> domains = trmtrainfillinService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainfillinMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(returnObject.body),'ehr-TrmTrainFillin-Get')")
    @ApiOperation(value = "GetByOrmOrgOrmOrgsector", tags = {"TrmTrainFillin" },  notes = "GetByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}")
    public ResponseEntity<TrmTrainFillinDTO> getByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
        TrmTrainFillin domain = trmtrainfillinService.get(trmtrainfillin_id);
        TrmTrainFillinDTO dto = trmtrainfillinMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.get(#trmtrainfillin_id),'ehr-TrmTrainFillin-Update')")
    @ApiOperation(value = "UpdateByOrmOrgOrmOrgsector", tags = {"TrmTrainFillin" },  notes = "UpdateByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}")
    @Transactional
    public ResponseEntity<TrmTrainFillinDTO> updateByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody TrmTrainFillinDTO trmtrainfillindto) {
        TrmTrainFillin domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setOrmorgsectorid(ormorgsector_id);
        domain.setTrmtrainfillinid(trmtrainfillin_id);
		trmtrainfillinService.update(domain);
        TrmTrainFillinDTO dto = trmtrainfillinMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.getTrmtrainfillinByEntities(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos)),'ehr-TrmTrainFillin-Update')")
    @ApiOperation(value = "UpdateBatchByOrmOrgOrmOrgsector", tags = {"TrmTrainFillin" },  notes = "UpdateBatchByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<TrmTrainFillinDTO> trmtrainfillindtos) {
        List<TrmTrainFillin> domainlist=trmtrainfillinMapping.toDomain(trmtrainfillindtos);
        for(TrmTrainFillin domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        trmtrainfillinService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByOrmOrgOrmOrgsector", tags = {"TrmTrainFillin" },  notes = "CheckKeyByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody TrmTrainFillinDTO trmtrainfillindto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.checkKey(trmtrainfillinMapping.toDomain(trmtrainfillindto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindto),'ehr-TrmTrainFillin-Create')")
    @ApiOperation(value = "CreateByOrmOrgOrmOrgsector", tags = {"TrmTrainFillin" },  notes = "CreateByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins")
    @Transactional
    public ResponseEntity<TrmTrainFillinDTO> createByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody TrmTrainFillinDTO trmtrainfillindto) {
        TrmTrainFillin domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setOrmorgsectorid(ormorgsector_id);
		trmtrainfillinService.create(domain);
        TrmTrainFillinDTO dto = trmtrainfillinMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos),'ehr-TrmTrainFillin-Create')")
    @ApiOperation(value = "createBatchByOrmOrgOrmOrgsector", tags = {"TrmTrainFillin" },  notes = "createBatchByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<TrmTrainFillinDTO> trmtrainfillindtos) {
        List<TrmTrainFillin> domainlist=trmtrainfillinMapping.toDomain(trmtrainfillindtos);
        for(TrmTrainFillin domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        trmtrainfillinService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindto),'ehr-TrmTrainFillin-Save')")
    @ApiOperation(value = "SaveByOrmOrgOrmOrgsector", tags = {"TrmTrainFillin" },  notes = "SaveByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/save")
    public ResponseEntity<Boolean> saveByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody TrmTrainFillinDTO trmtrainfillindto) {
        TrmTrainFillin domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinMapping.toDomain(#trmtrainfillindtos),'ehr-TrmTrainFillin-Save')")
    @ApiOperation(value = "SaveBatchByOrmOrgOrmOrgsector", tags = {"TrmTrainFillin" },  notes = "SaveBatchByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<TrmTrainFillinDTO> trmtrainfillindtos) {
        List<TrmTrainFillin> domainlist=trmtrainfillinMapping.toDomain(trmtrainfillindtos);
        for(TrmTrainFillin domain:domainlist){
             domain.setOrmorgsectorid(ormorgsector_id);
        }
        trmtrainfillinService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByOrmOrgOrmOrgsector", tags = {"TrmTrainFillin" },  notes = "GetDraftByOrmOrgOrmOrgsector")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/getdraft")
    public ResponseEntity<TrmTrainFillinDTO> getDraftByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id) {
        TrmTrainFillin domain = new TrmTrainFillin();
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinMapping.toDto(trmtrainfillinService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.get(#trmtrainfillin_id),'ehr-TrmTrainFillin-Remove')")
    @ApiOperation(value = "RemoveByOrmOrgOrmOrgsector", tags = {"TrmTrainFillin" },  notes = "RemoveByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.remove(trmtrainfillin_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainfillinService.getTrmtrainfillinByIds(#ids),'ehr-TrmTrainFillin-Remove')")
    @ApiOperation(value = "RemoveBatchByOrmOrgOrmOrgsector", tags = {"TrmTrainFillin" },  notes = "RemoveBatchByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgOrmOrgsector(@RequestBody List<String> ids) {
        trmtrainfillinService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainFillin-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByOrmOrgOrmOrgsector", tags = {"TrmTrainFillin" } ,notes = "fetchDEFAULTByOrmOrgOrmOrgsector")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/fetchdefault")
	public ResponseEntity<List<TrmTrainFillinDTO>> fetchTrmTrainFillinDefaultByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id,TrmTrainFillinSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<TrmTrainFillin> domains = trmtrainfillinService.searchDefault(context) ;
        List<TrmTrainFillinDTO> list = trmtrainfillinMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainFillin-Default-all')")
	@ApiOperation(value = "searchDEFAULTByOrmOrgOrmOrgsector", tags = {"TrmTrainFillin" } ,notes = "searchDEFAULTByOrmOrgOrmOrgsector")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/searchdefault")
	public ResponseEntity<Page<TrmTrainFillinDTO>> searchTrmTrainFillinDefaultByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody TrmTrainFillinSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<TrmTrainFillin> domains = trmtrainfillinService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainfillinMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

