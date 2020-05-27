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
import cn.ibizlab.ehr.core.trm.domain.TRMTRAINFILLIN;
import cn.ibizlab.ehr.core.trm.service.ITRMTRAINFILLINService;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINFILLINSearchContext;

@Slf4j
@Api(tags = {"TRMTRAINFILLIN" })
@RestController("WebApi-trmtrainfillin")
@RequestMapping("")
public class TRMTRAINFILLINResource {

    @Autowired
    private ITRMTRAINFILLINService trmtrainfillinService;

    @Autowired
    @Lazy
    public TRMTRAINFILLINMapping trmtrainfillinMapping;

    public TRMTRAINFILLINDTO permissionDTO=new TRMTRAINFILLINDTO();

    @PreAuthorize("hasPermission(#trmtrainfillin_id,'Get',{'Sql',this.trmtrainfillinMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"TRMTRAINFILLIN" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainfillins/{trmtrainfillin_id}")
    public ResponseEntity<TRMTRAINFILLINDTO> get(@PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
        TRMTRAINFILLIN domain = trmtrainfillinService.get(trmtrainfillin_id);
        TRMTRAINFILLINDTO dto = trmtrainfillinMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#trmtrainfillin_id,'Update',{'Sql',this.trmtrainfillinMapping,#trmtrainfillindto})")
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

    @PreAuthorize("hasPermission('Update',{'Sql',this.trmtrainfillinMapping,#trmtrainfillindtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"TRMTRAINFILLIN" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainfillins/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMTRAINFILLINDTO> trmtrainfillindtos) {
        trmtrainfillinService.updateBatch(trmtrainfillinMapping.toDomain(trmtrainfillindtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINFILLIN-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"TRMTRAINFILLIN" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfillins/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMTRAINFILLINDTO trmtrainfillindto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.checkKey(trmtrainfillinMapping.toDomain(trmtrainfillindto)));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.trmtrainfillinMapping,#trmtrainfillindto})")
    @ApiOperation(value = "Create", tags = {"TRMTRAINFILLIN" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfillins")
    @Transactional
    public ResponseEntity<TRMTRAINFILLINDTO> create(@RequestBody TRMTRAINFILLINDTO trmtrainfillindto) {
        TRMTRAINFILLIN domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
		trmtrainfillinService.create(domain);
        TRMTRAINFILLINDTO dto = trmtrainfillinMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.trmtrainfillinMapping,#trmtrainfillindtos})")
    @ApiOperation(value = "createBatch", tags = {"TRMTRAINFILLIN" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfillins/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMTRAINFILLINDTO> trmtrainfillindtos) {
        trmtrainfillinService.createBatch(trmtrainfillinMapping.toDomain(trmtrainfillindtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.trmtrainfillinMapping,#trmtrainfillindto})")
    @ApiOperation(value = "Save", tags = {"TRMTRAINFILLIN" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfillins/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMTRAINFILLINDTO trmtrainfillindto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.save(trmtrainfillinMapping.toDomain(trmtrainfillindto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.trmtrainfillinMapping,#trmtrainfillindtos})")
    @ApiOperation(value = "SaveBatch", tags = {"TRMTRAINFILLIN" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfillins/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMTRAINFILLINDTO> trmtrainfillindtos) {
        trmtrainfillinService.saveBatch(trmtrainfillinMapping.toDomain(trmtrainfillindtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINFILLIN-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"TRMTRAINFILLIN" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainfillins/getdraft")
    public ResponseEntity<TRMTRAINFILLINDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinMapping.toDto(trmtrainfillinService.getDraft(new TRMTRAINFILLIN())));
    }

    @PreAuthorize("hasPermission(#trmtrainfillin_id,'Remove',{'Sql',this.trmtrainfillinMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"TRMTRAINFILLIN" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainfillins/{trmtrainfillin_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.remove(trmtrainfillin_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.trmtrainfillinMapping,this.permissionDTO,#ids})")
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
    @PreAuthorize("hasPermission(#trmtrainfillin_id,'Get',{'Sql',this.trmtrainfillinMapping,this.permissionDTO})")
    @ApiOperation(value = "GetByORMORGSECTOR", tags = {"TRMTRAINFILLIN" },  notes = "GetByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}")
    public ResponseEntity<TRMTRAINFILLINDTO> getByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
        TRMTRAINFILLIN domain = trmtrainfillinService.get(trmtrainfillin_id);
        TRMTRAINFILLINDTO dto = trmtrainfillinMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#trmtrainfillin_id,'Update',{'Sql',this.trmtrainfillinMapping,#trmtrainfillindto})")
    @ApiOperation(value = "UpdateByORMORGSECTOR", tags = {"TRMTRAINFILLIN" },  notes = "UpdateByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}")
    @Transactional
    public ResponseEntity<TRMTRAINFILLINDTO> updateByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody TRMTRAINFILLINDTO trmtrainfillindto) {
        TRMTRAINFILLIN domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setOrmorgsectorid(ormorgsector_id);
        domain.setTrmtrainfillinid(trmtrainfillin_id);
		trmtrainfillinService.update(domain);
        TRMTRAINFILLINDTO dto = trmtrainfillinMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.trmtrainfillinMapping,#trmtrainfillindtos})")
    @ApiOperation(value = "UpdateBatchByORMORGSECTOR", tags = {"TRMTRAINFILLIN" },  notes = "UpdateBatchByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/batch")
    public ResponseEntity<Boolean> updateBatchByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<TRMTRAINFILLINDTO> trmtrainfillindtos) {
        List<TRMTRAINFILLIN> domainlist=trmtrainfillinMapping.toDomain(trmtrainfillindtos);
        for(TRMTRAINFILLIN domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        trmtrainfillinService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINFILLIN-CheckKey-all')")
    @ApiOperation(value = "CheckKeyByORMORGSECTOR", tags = {"TRMTRAINFILLIN" },  notes = "CheckKeyByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/checkkey")
    public ResponseEntity<Boolean> checkKeyByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody TRMTRAINFILLINDTO trmtrainfillindto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.checkKey(trmtrainfillinMapping.toDomain(trmtrainfillindto)));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.trmtrainfillinMapping,#trmtrainfillindto})")
    @ApiOperation(value = "CreateByORMORGSECTOR", tags = {"TRMTRAINFILLIN" },  notes = "CreateByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins")
    @Transactional
    public ResponseEntity<TRMTRAINFILLINDTO> createByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody TRMTRAINFILLINDTO trmtrainfillindto) {
        TRMTRAINFILLIN domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setOrmorgsectorid(ormorgsector_id);
		trmtrainfillinService.create(domain);
        TRMTRAINFILLINDTO dto = trmtrainfillinMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.trmtrainfillinMapping,#trmtrainfillindtos})")
    @ApiOperation(value = "createBatchByORMORGSECTOR", tags = {"TRMTRAINFILLIN" },  notes = "createBatchByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/batch")
    public ResponseEntity<Boolean> createBatchByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<TRMTRAINFILLINDTO> trmtrainfillindtos) {
        List<TRMTRAINFILLIN> domainlist=trmtrainfillinMapping.toDomain(trmtrainfillindtos);
        for(TRMTRAINFILLIN domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        trmtrainfillinService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.trmtrainfillinMapping,#trmtrainfillindto})")
    @ApiOperation(value = "SaveByORMORGSECTOR", tags = {"TRMTRAINFILLIN" },  notes = "SaveByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/save")
    public ResponseEntity<Boolean> saveByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody TRMTRAINFILLINDTO trmtrainfillindto) {
        TRMTRAINFILLIN domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.save(domain));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.trmtrainfillinMapping,#trmtrainfillindtos})")
    @ApiOperation(value = "SaveBatchByORMORGSECTOR", tags = {"TRMTRAINFILLIN" },  notes = "SaveBatchByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/savebatch")
    public ResponseEntity<Boolean> saveBatchByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<TRMTRAINFILLINDTO> trmtrainfillindtos) {
        List<TRMTRAINFILLIN> domainlist=trmtrainfillinMapping.toDomain(trmtrainfillindtos);
        for(TRMTRAINFILLIN domain:domainlist){
             domain.setOrmorgsectorid(ormorgsector_id);
        }
        trmtrainfillinService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINFILLIN-GetDraft-all')")
    @ApiOperation(value = "GetDraftByORMORGSECTOR", tags = {"TRMTRAINFILLIN" },  notes = "GetDraftByORMORGSECTOR")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/getdraft")
    public ResponseEntity<TRMTRAINFILLINDTO> getDraftByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id) {
        TRMTRAINFILLIN domain = new TRMTRAINFILLIN();
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinMapping.toDto(trmtrainfillinService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(#trmtrainfillin_id,'Remove',{'Sql',this.trmtrainfillinMapping,this.permissionDTO})")
    @ApiOperation(value = "RemoveByORMORGSECTOR", tags = {"TRMTRAINFILLIN" },  notes = "RemoveByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.remove(trmtrainfillin_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.trmtrainfillinMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatchByORMORGSECTOR", tags = {"TRMTRAINFILLIN" },  notes = "RemoveBatchByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/trmtrainfillins/batch")
    public ResponseEntity<Boolean> removeBatchByORMORGSECTOR(@RequestBody List<String> ids) {
        trmtrainfillinService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINFILLIN-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByORMORGSECTOR", tags = {"TRMTRAINFILLIN" } ,notes = "fetchDEFAULTByORMORGSECTOR")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/{ormorgsector_id}/trmtrainfillins/fetchdefault")
	public ResponseEntity<List<TRMTRAINFILLINDTO>> fetchTRMTRAINFILLINDefaultByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id,TRMTRAINFILLINSearchContext context) {
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
	@ApiOperation(value = "searchDEFAULTByORMORGSECTOR", tags = {"TRMTRAINFILLIN" } ,notes = "searchDEFAULTByORMORGSECTOR")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/{ormorgsector_id}/trmtrainfillins/searchdefault")
	public ResponseEntity<Page<TRMTRAINFILLINDTO>> searchTRMTRAINFILLINDefaultByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody TRMTRAINFILLINSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<TRMTRAINFILLIN> domains = trmtrainfillinService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainfillinMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(#trmtrainfillin_id,'Get',{'Sql',this.trmtrainfillinMapping,this.permissionDTO})")
    @ApiOperation(value = "GetByTRMDEPART", tags = {"TRMTRAINFILLIN" },  notes = "GetByTRMDEPART")
	@RequestMapping(method = RequestMethod.GET, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/{trmtrainfillin_id}")
    public ResponseEntity<TRMTRAINFILLINDTO> getByTRMDEPART(@PathVariable("trmdepart_id") String trmdepart_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
        TRMTRAINFILLIN domain = trmtrainfillinService.get(trmtrainfillin_id);
        TRMTRAINFILLINDTO dto = trmtrainfillinMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#trmtrainfillin_id,'Update',{'Sql',this.trmtrainfillinMapping,#trmtrainfillindto})")
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

    @PreAuthorize("hasPermission('Update',{'Sql',this.trmtrainfillinMapping,#trmtrainfillindtos})")
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

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINFILLIN-CheckKey-all')")
    @ApiOperation(value = "CheckKeyByTRMDEPART", tags = {"TRMTRAINFILLIN" },  notes = "CheckKeyByTRMDEPART")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/checkkey")
    public ResponseEntity<Boolean> checkKeyByTRMDEPART(@PathVariable("trmdepart_id") String trmdepart_id, @RequestBody TRMTRAINFILLINDTO trmtrainfillindto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.checkKey(trmtrainfillinMapping.toDomain(trmtrainfillindto)));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.trmtrainfillinMapping,#trmtrainfillindto})")
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

    @PreAuthorize("hasPermission('Create',{'Sql',this.trmtrainfillinMapping,#trmtrainfillindtos})")
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

    @PreAuthorize("hasPermission('','Save',{'Sql',this.trmtrainfillinMapping,#trmtrainfillindto})")
    @ApiOperation(value = "SaveByTRMDEPART", tags = {"TRMTRAINFILLIN" },  notes = "SaveByTRMDEPART")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/save")
    public ResponseEntity<Boolean> saveByTRMDEPART(@PathVariable("trmdepart_id") String trmdepart_id, @RequestBody TRMTRAINFILLINDTO trmtrainfillindto) {
        TRMTRAINFILLIN domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setTrmdepartid(trmdepart_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.save(domain));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.trmtrainfillinMapping,#trmtrainfillindtos})")
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

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINFILLIN-GetDraft-all')")
    @ApiOperation(value = "GetDraftByTRMDEPART", tags = {"TRMTRAINFILLIN" },  notes = "GetDraftByTRMDEPART")
    @RequestMapping(method = RequestMethod.GET, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/getdraft")
    public ResponseEntity<TRMTRAINFILLINDTO> getDraftByTRMDEPART(@PathVariable("trmdepart_id") String trmdepart_id) {
        TRMTRAINFILLIN domain = new TRMTRAINFILLIN();
        domain.setTrmdepartid(trmdepart_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinMapping.toDto(trmtrainfillinService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(#trmtrainfillin_id,'Remove',{'Sql',this.trmtrainfillinMapping,this.permissionDTO})")
    @ApiOperation(value = "RemoveByTRMDEPART", tags = {"TRMTRAINFILLIN" },  notes = "RemoveByTRMDEPART")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmdeparts/{trmdepart_id}/trmtrainfillins/{trmtrainfillin_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByTRMDEPART(@PathVariable("trmdepart_id") String trmdepart_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.remove(trmtrainfillin_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.trmtrainfillinMapping,this.permissionDTO,#ids})")
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
    @PreAuthorize("hasPermission(#trmtrainfillin_id,'Get',{'Sql',this.trmtrainfillinMapping,this.permissionDTO})")
    @ApiOperation(value = "GetByORMORGORMORGSECTOR", tags = {"TRMTRAINFILLIN" },  notes = "GetByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}")
    public ResponseEntity<TRMTRAINFILLINDTO> getByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
        TRMTRAINFILLIN domain = trmtrainfillinService.get(trmtrainfillin_id);
        TRMTRAINFILLINDTO dto = trmtrainfillinMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#trmtrainfillin_id,'Update',{'Sql',this.trmtrainfillinMapping,#trmtrainfillindto})")
    @ApiOperation(value = "UpdateByORMORGORMORGSECTOR", tags = {"TRMTRAINFILLIN" },  notes = "UpdateByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}")
    @Transactional
    public ResponseEntity<TRMTRAINFILLINDTO> updateByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody TRMTRAINFILLINDTO trmtrainfillindto) {
        TRMTRAINFILLIN domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setOrmorgsectorid(ormorgsector_id);
        domain.setTrmtrainfillinid(trmtrainfillin_id);
		trmtrainfillinService.update(domain);
        TRMTRAINFILLINDTO dto = trmtrainfillinMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.trmtrainfillinMapping,#trmtrainfillindtos})")
    @ApiOperation(value = "UpdateBatchByORMORGORMORGSECTOR", tags = {"TRMTRAINFILLIN" },  notes = "UpdateBatchByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/batch")
    public ResponseEntity<Boolean> updateBatchByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<TRMTRAINFILLINDTO> trmtrainfillindtos) {
        List<TRMTRAINFILLIN> domainlist=trmtrainfillinMapping.toDomain(trmtrainfillindtos);
        for(TRMTRAINFILLIN domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        trmtrainfillinService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINFILLIN-CheckKey-all')")
    @ApiOperation(value = "CheckKeyByORMORGORMORGSECTOR", tags = {"TRMTRAINFILLIN" },  notes = "CheckKeyByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/checkkey")
    public ResponseEntity<Boolean> checkKeyByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody TRMTRAINFILLINDTO trmtrainfillindto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.checkKey(trmtrainfillinMapping.toDomain(trmtrainfillindto)));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.trmtrainfillinMapping,#trmtrainfillindto})")
    @ApiOperation(value = "CreateByORMORGORMORGSECTOR", tags = {"TRMTRAINFILLIN" },  notes = "CreateByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins")
    @Transactional
    public ResponseEntity<TRMTRAINFILLINDTO> createByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody TRMTRAINFILLINDTO trmtrainfillindto) {
        TRMTRAINFILLIN domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setOrmorgsectorid(ormorgsector_id);
		trmtrainfillinService.create(domain);
        TRMTRAINFILLINDTO dto = trmtrainfillinMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.trmtrainfillinMapping,#trmtrainfillindtos})")
    @ApiOperation(value = "createBatchByORMORGORMORGSECTOR", tags = {"TRMTRAINFILLIN" },  notes = "createBatchByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/batch")
    public ResponseEntity<Boolean> createBatchByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<TRMTRAINFILLINDTO> trmtrainfillindtos) {
        List<TRMTRAINFILLIN> domainlist=trmtrainfillinMapping.toDomain(trmtrainfillindtos);
        for(TRMTRAINFILLIN domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        trmtrainfillinService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.trmtrainfillinMapping,#trmtrainfillindto})")
    @ApiOperation(value = "SaveByORMORGORMORGSECTOR", tags = {"TRMTRAINFILLIN" },  notes = "SaveByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/save")
    public ResponseEntity<Boolean> saveByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody TRMTRAINFILLINDTO trmtrainfillindto) {
        TRMTRAINFILLIN domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.save(domain));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.trmtrainfillinMapping,#trmtrainfillindtos})")
    @ApiOperation(value = "SaveBatchByORMORGORMORGSECTOR", tags = {"TRMTRAINFILLIN" },  notes = "SaveBatchByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/savebatch")
    public ResponseEntity<Boolean> saveBatchByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<TRMTRAINFILLINDTO> trmtrainfillindtos) {
        List<TRMTRAINFILLIN> domainlist=trmtrainfillinMapping.toDomain(trmtrainfillindtos);
        for(TRMTRAINFILLIN domain:domainlist){
             domain.setOrmorgsectorid(ormorgsector_id);
        }
        trmtrainfillinService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINFILLIN-GetDraft-all')")
    @ApiOperation(value = "GetDraftByORMORGORMORGSECTOR", tags = {"TRMTRAINFILLIN" },  notes = "GetDraftByORMORGORMORGSECTOR")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/getdraft")
    public ResponseEntity<TRMTRAINFILLINDTO> getDraftByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id) {
        TRMTRAINFILLIN domain = new TRMTRAINFILLIN();
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinMapping.toDto(trmtrainfillinService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(#trmtrainfillin_id,'Remove',{'Sql',this.trmtrainfillinMapping,this.permissionDTO})")
    @ApiOperation(value = "RemoveByORMORGORMORGSECTOR", tags = {"TRMTRAINFILLIN" },  notes = "RemoveByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/{trmtrainfillin_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.remove(trmtrainfillin_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.trmtrainfillinMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatchByORMORGORMORGSECTOR", tags = {"TRMTRAINFILLIN" },  notes = "RemoveBatchByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/batch")
    public ResponseEntity<Boolean> removeBatchByORMORGORMORGSECTOR(@RequestBody List<String> ids) {
        trmtrainfillinService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINFILLIN-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByORMORGORMORGSECTOR", tags = {"TRMTRAINFILLIN" } ,notes = "fetchDEFAULTByORMORGORMORGSECTOR")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/fetchdefault")
	public ResponseEntity<List<TRMTRAINFILLINDTO>> fetchTRMTRAINFILLINDefaultByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id,TRMTRAINFILLINSearchContext context) {
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
	@ApiOperation(value = "searchDEFAULTByORMORGORMORGSECTOR", tags = {"TRMTRAINFILLIN" } ,notes = "searchDEFAULTByORMORGORMORGSECTOR")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/trmtrainfillins/searchdefault")
	public ResponseEntity<Page<TRMTRAINFILLINDTO>> searchTRMTRAINFILLINDefaultByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody TRMTRAINFILLINSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<TRMTRAINFILLIN> domains = trmtrainfillinService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainfillinMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
