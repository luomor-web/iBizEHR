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
import cn.ibizlab.ehr.core.orm.domain.ORMBMKQDZ;
import cn.ibizlab.ehr.core.orm.service.IORMBMKQDZService;
import cn.ibizlab.ehr.core.orm.filter.ORMBMKQDZSearchContext;

@Slf4j
@Api(tags = {"ORMBMKQDZ" })
@RestController("WebApi-ormbmkqdz")
@RequestMapping("")
public class ORMBMKQDZResource {

    @Autowired
    public IORMBMKQDZService ormbmkqdzService;

    @Autowired
    @Lazy
    public ORMBMKQDZMapping ormbmkqdzMapping;

    @PreAuthorize("hasPermission(this.ormbmkqdzService.get(#ormbmkqdz_id),'ehr-ORMBMKQDZ-Remove')")
    @ApiOperation(value = "Remove", tags = {"ORMBMKQDZ" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormbmkqdzs/{ormbmkqdz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormbmkqdz_id") String ormbmkqdz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzService.remove(ormbmkqdz_id));
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzService.getOrmbmkqdzByIds(#ids),'ehr-ORMBMKQDZ-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"ORMBMKQDZ" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormbmkqdzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormbmkqdzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"ORMBMKQDZ" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormbmkqdzs/getdraft")
    public ResponseEntity<ORMBMKQDZDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzMapping.toDto(ormbmkqdzService.getDraft(new ORMBMKQDZ())));
    }

    @ApiOperation(value = "CheckKey", tags = {"ORMBMKQDZ" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmkqdzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ORMBMKQDZDTO ormbmkqdzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzService.checkKey(ormbmkqdzMapping.toDomain(ormbmkqdzdto)));
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdto),'ehr-ORMBMKQDZ-Save')")
    @ApiOperation(value = "Save", tags = {"ORMBMKQDZ" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmkqdzs/save")
    public ResponseEntity<Boolean> save(@RequestBody ORMBMKQDZDTO ormbmkqdzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzService.save(ormbmkqdzMapping.toDomain(ormbmkqdzdto)));
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdtos),'ehr-ORMBMKQDZ-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"ORMBMKQDZ" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmkqdzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ORMBMKQDZDTO> ormbmkqdzdtos) {
        ormbmkqdzService.saveBatch(ormbmkqdzMapping.toDomain(ormbmkqdzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzService.get(#ormbmkqdz_id),'ehr-ORMBMKQDZ-Update')")
    @ApiOperation(value = "Update", tags = {"ORMBMKQDZ" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormbmkqdzs/{ormbmkqdz_id}")
    @Transactional
    public ResponseEntity<ORMBMKQDZDTO> update(@PathVariable("ormbmkqdz_id") String ormbmkqdz_id, @RequestBody ORMBMKQDZDTO ormbmkqdzdto) {
		ORMBMKQDZ domain  = ormbmkqdzMapping.toDomain(ormbmkqdzdto);
        domain .setOrmbmkqdzid(ormbmkqdz_id);
		ormbmkqdzService.update(domain );
		ORMBMKQDZDTO dto = ormbmkqdzMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzService.getOrmbmkqdzByEntities(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdtos)),'ehr-ORMBMKQDZ-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"ORMBMKQDZ" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormbmkqdzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ORMBMKQDZDTO> ormbmkqdzdtos) {
        ormbmkqdzService.updateBatch(ormbmkqdzMapping.toDomain(ormbmkqdzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdto),'ehr-ORMBMKQDZ-Create')")
    @ApiOperation(value = "Create", tags = {"ORMBMKQDZ" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmkqdzs")
    @Transactional
    public ResponseEntity<ORMBMKQDZDTO> create(@RequestBody ORMBMKQDZDTO ormbmkqdzdto) {
        ORMBMKQDZ domain = ormbmkqdzMapping.toDomain(ormbmkqdzdto);
		ormbmkqdzService.create(domain);
        ORMBMKQDZDTO dto = ormbmkqdzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdtos),'ehr-ORMBMKQDZ-Create')")
    @ApiOperation(value = "createBatch", tags = {"ORMBMKQDZ" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmkqdzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ORMBMKQDZDTO> ormbmkqdzdtos) {
        ormbmkqdzService.createBatch(ormbmkqdzMapping.toDomain(ormbmkqdzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(returnObject.body),'ehr-ORMBMKQDZ-Get')")
    @ApiOperation(value = "Get", tags = {"ORMBMKQDZ" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormbmkqdzs/{ormbmkqdz_id}")
    public ResponseEntity<ORMBMKQDZDTO> get(@PathVariable("ormbmkqdz_id") String ormbmkqdz_id) {
        ORMBMKQDZ domain = ormbmkqdzService.get(ormbmkqdz_id);
        ORMBMKQDZDTO dto = ormbmkqdzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMBMKQDZ-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ORMBMKQDZ" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormbmkqdzs/fetchdefault")
	public ResponseEntity<List<ORMBMKQDZDTO>> fetchDefault(ORMBMKQDZSearchContext context) {
        Page<ORMBMKQDZ> domains = ormbmkqdzService.searchDefault(context) ;
        List<ORMBMKQDZDTO> list = ormbmkqdzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMBMKQDZ-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ORMBMKQDZ" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormbmkqdzs/searchdefault")
	public ResponseEntity<Page<ORMBMKQDZDTO>> searchDefault(@RequestBody ORMBMKQDZSearchContext context) {
        Page<ORMBMKQDZ> domains = ormbmkqdzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormbmkqdzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.ormbmkqdzService.get(#ormbmkqdz_id),'ehr-ORMBMKQDZ-Remove')")
    @ApiOperation(value = "RemoveByORMORGSECTOR", tags = {"ORMBMKQDZ" },  notes = "RemoveByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/{ormbmkqdz_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmkqdz_id") String ormbmkqdz_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzService.remove(ormbmkqdz_id));
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzService.getOrmbmkqdzByIds(#ids),'ehr-ORMBMKQDZ-Remove')")
    @ApiOperation(value = "RemoveBatchByORMORGSECTOR", tags = {"ORMBMKQDZ" },  notes = "RemoveBatchByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/batch")
    public ResponseEntity<Boolean> removeBatchByORMORGSECTOR(@RequestBody List<String> ids) {
        ormbmkqdzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByORMORGSECTOR", tags = {"ORMBMKQDZ" },  notes = "GetDraftByORMORGSECTOR")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/getdraft")
    public ResponseEntity<ORMBMKQDZDTO> getDraftByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id) {
        ORMBMKQDZ domain = new ORMBMKQDZ();
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzMapping.toDto(ormbmkqdzService.getDraft(domain)));
    }

    @ApiOperation(value = "CheckKeyByORMORGSECTOR", tags = {"ORMBMKQDZ" },  notes = "CheckKeyByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/checkkey")
    public ResponseEntity<Boolean> checkKeyByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMBMKQDZDTO ormbmkqdzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzService.checkKey(ormbmkqdzMapping.toDomain(ormbmkqdzdto)));
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdto),'ehr-ORMBMKQDZ-Save')")
    @ApiOperation(value = "SaveByORMORGSECTOR", tags = {"ORMBMKQDZ" },  notes = "SaveByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/save")
    public ResponseEntity<Boolean> saveByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMBMKQDZDTO ormbmkqdzdto) {
        ORMBMKQDZ domain = ormbmkqdzMapping.toDomain(ormbmkqdzdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdtos),'ehr-ORMBMKQDZ-Save')")
    @ApiOperation(value = "SaveBatchByORMORGSECTOR", tags = {"ORMBMKQDZ" },  notes = "SaveBatchByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/savebatch")
    public ResponseEntity<Boolean> saveBatchByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMBMKQDZDTO> ormbmkqdzdtos) {
        List<ORMBMKQDZ> domainlist=ormbmkqdzMapping.toDomain(ormbmkqdzdtos);
        for(ORMBMKQDZ domain:domainlist){
             domain.setOrmorgsectorid(ormorgsector_id);
        }
        ormbmkqdzService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzService.get(#ormbmkqdz_id),'ehr-ORMBMKQDZ-Update')")
    @ApiOperation(value = "UpdateByORMORGSECTOR", tags = {"ORMBMKQDZ" },  notes = "UpdateByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/{ormbmkqdz_id}")
    @Transactional
    public ResponseEntity<ORMBMKQDZDTO> updateByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmkqdz_id") String ormbmkqdz_id, @RequestBody ORMBMKQDZDTO ormbmkqdzdto) {
        ORMBMKQDZ domain = ormbmkqdzMapping.toDomain(ormbmkqdzdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        domain.setOrmbmkqdzid(ormbmkqdz_id);
		ormbmkqdzService.update(domain);
        ORMBMKQDZDTO dto = ormbmkqdzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzService.getOrmbmkqdzByEntities(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdtos)),'ehr-ORMBMKQDZ-Update')")
    @ApiOperation(value = "UpdateBatchByORMORGSECTOR", tags = {"ORMBMKQDZ" },  notes = "UpdateBatchByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/batch")
    public ResponseEntity<Boolean> updateBatchByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMBMKQDZDTO> ormbmkqdzdtos) {
        List<ORMBMKQDZ> domainlist=ormbmkqdzMapping.toDomain(ormbmkqdzdtos);
        for(ORMBMKQDZ domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        ormbmkqdzService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdto),'ehr-ORMBMKQDZ-Create')")
    @ApiOperation(value = "CreateByORMORGSECTOR", tags = {"ORMBMKQDZ" },  notes = "CreateByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormbmkqdzs")
    @Transactional
    public ResponseEntity<ORMBMKQDZDTO> createByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMBMKQDZDTO ormbmkqdzdto) {
        ORMBMKQDZ domain = ormbmkqdzMapping.toDomain(ormbmkqdzdto);
        domain.setOrmorgsectorid(ormorgsector_id);
		ormbmkqdzService.create(domain);
        ORMBMKQDZDTO dto = ormbmkqdzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdtos),'ehr-ORMBMKQDZ-Create')")
    @ApiOperation(value = "createBatchByORMORGSECTOR", tags = {"ORMBMKQDZ" },  notes = "createBatchByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/batch")
    public ResponseEntity<Boolean> createBatchByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMBMKQDZDTO> ormbmkqdzdtos) {
        List<ORMBMKQDZ> domainlist=ormbmkqdzMapping.toDomain(ormbmkqdzdtos);
        for(ORMBMKQDZ domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        ormbmkqdzService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(returnObject.body),'ehr-ORMBMKQDZ-Get')")
    @ApiOperation(value = "GetByORMORGSECTOR", tags = {"ORMBMKQDZ" },  notes = "GetByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/{ormbmkqdz_id}")
    public ResponseEntity<ORMBMKQDZDTO> getByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmkqdz_id") String ormbmkqdz_id) {
        ORMBMKQDZ domain = ormbmkqdzService.get(ormbmkqdz_id);
        ORMBMKQDZDTO dto = ormbmkqdzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMBMKQDZ-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByORMORGSECTOR", tags = {"ORMBMKQDZ" } ,notes = "fetchDEFAULTByORMORGSECTOR")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/fetchdefault")
	public ResponseEntity<List<ORMBMKQDZDTO>> fetchORMBMKQDZDefaultByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id,ORMBMKQDZSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<ORMBMKQDZ> domains = ormbmkqdzService.searchDefault(context) ;
        List<ORMBMKQDZDTO> list = ormbmkqdzMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMBMKQDZ-Default-all')")
	@ApiOperation(value = "searchDEFAULTByORMORGSECTOR", tags = {"ORMBMKQDZ" } ,notes = "searchDEFAULTByORMORGSECTOR")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/searchdefault")
	public ResponseEntity<Page<ORMBMKQDZDTO>> searchORMBMKQDZDefaultByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMBMKQDZSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<ORMBMKQDZ> domains = ormbmkqdzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormbmkqdzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.ormbmkqdzService.get(#ormbmkqdz_id),'ehr-ORMBMKQDZ-Remove')")
    @ApiOperation(value = "RemoveByORMORGORMORGSECTOR", tags = {"ORMBMKQDZ" },  notes = "RemoveByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/{ormbmkqdz_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmkqdz_id") String ormbmkqdz_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzService.remove(ormbmkqdz_id));
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzService.getOrmbmkqdzByIds(#ids),'ehr-ORMBMKQDZ-Remove')")
    @ApiOperation(value = "RemoveBatchByORMORGORMORGSECTOR", tags = {"ORMBMKQDZ" },  notes = "RemoveBatchByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/batch")
    public ResponseEntity<Boolean> removeBatchByORMORGORMORGSECTOR(@RequestBody List<String> ids) {
        ormbmkqdzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByORMORGORMORGSECTOR", tags = {"ORMBMKQDZ" },  notes = "GetDraftByORMORGORMORGSECTOR")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/getdraft")
    public ResponseEntity<ORMBMKQDZDTO> getDraftByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id) {
        ORMBMKQDZ domain = new ORMBMKQDZ();
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzMapping.toDto(ormbmkqdzService.getDraft(domain)));
    }

    @ApiOperation(value = "CheckKeyByORMORGORMORGSECTOR", tags = {"ORMBMKQDZ" },  notes = "CheckKeyByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/checkkey")
    public ResponseEntity<Boolean> checkKeyByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMBMKQDZDTO ormbmkqdzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzService.checkKey(ormbmkqdzMapping.toDomain(ormbmkqdzdto)));
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdto),'ehr-ORMBMKQDZ-Save')")
    @ApiOperation(value = "SaveByORMORGORMORGSECTOR", tags = {"ORMBMKQDZ" },  notes = "SaveByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/save")
    public ResponseEntity<Boolean> saveByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMBMKQDZDTO ormbmkqdzdto) {
        ORMBMKQDZ domain = ormbmkqdzMapping.toDomain(ormbmkqdzdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdtos),'ehr-ORMBMKQDZ-Save')")
    @ApiOperation(value = "SaveBatchByORMORGORMORGSECTOR", tags = {"ORMBMKQDZ" },  notes = "SaveBatchByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/savebatch")
    public ResponseEntity<Boolean> saveBatchByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMBMKQDZDTO> ormbmkqdzdtos) {
        List<ORMBMKQDZ> domainlist=ormbmkqdzMapping.toDomain(ormbmkqdzdtos);
        for(ORMBMKQDZ domain:domainlist){
             domain.setOrmorgsectorid(ormorgsector_id);
        }
        ormbmkqdzService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzService.get(#ormbmkqdz_id),'ehr-ORMBMKQDZ-Update')")
    @ApiOperation(value = "UpdateByORMORGORMORGSECTOR", tags = {"ORMBMKQDZ" },  notes = "UpdateByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/{ormbmkqdz_id}")
    @Transactional
    public ResponseEntity<ORMBMKQDZDTO> updateByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmkqdz_id") String ormbmkqdz_id, @RequestBody ORMBMKQDZDTO ormbmkqdzdto) {
        ORMBMKQDZ domain = ormbmkqdzMapping.toDomain(ormbmkqdzdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        domain.setOrmbmkqdzid(ormbmkqdz_id);
		ormbmkqdzService.update(domain);
        ORMBMKQDZDTO dto = ormbmkqdzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzService.getOrmbmkqdzByEntities(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdtos)),'ehr-ORMBMKQDZ-Update')")
    @ApiOperation(value = "UpdateBatchByORMORGORMORGSECTOR", tags = {"ORMBMKQDZ" },  notes = "UpdateBatchByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/batch")
    public ResponseEntity<Boolean> updateBatchByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMBMKQDZDTO> ormbmkqdzdtos) {
        List<ORMBMKQDZ> domainlist=ormbmkqdzMapping.toDomain(ormbmkqdzdtos);
        for(ORMBMKQDZ domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        ormbmkqdzService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdto),'ehr-ORMBMKQDZ-Create')")
    @ApiOperation(value = "CreateByORMORGORMORGSECTOR", tags = {"ORMBMKQDZ" },  notes = "CreateByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs")
    @Transactional
    public ResponseEntity<ORMBMKQDZDTO> createByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMBMKQDZDTO ormbmkqdzdto) {
        ORMBMKQDZ domain = ormbmkqdzMapping.toDomain(ormbmkqdzdto);
        domain.setOrmorgsectorid(ormorgsector_id);
		ormbmkqdzService.create(domain);
        ORMBMKQDZDTO dto = ormbmkqdzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdtos),'ehr-ORMBMKQDZ-Create')")
    @ApiOperation(value = "createBatchByORMORGORMORGSECTOR", tags = {"ORMBMKQDZ" },  notes = "createBatchByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/batch")
    public ResponseEntity<Boolean> createBatchByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMBMKQDZDTO> ormbmkqdzdtos) {
        List<ORMBMKQDZ> domainlist=ormbmkqdzMapping.toDomain(ormbmkqdzdtos);
        for(ORMBMKQDZ domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        ormbmkqdzService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(returnObject.body),'ehr-ORMBMKQDZ-Get')")
    @ApiOperation(value = "GetByORMORGORMORGSECTOR", tags = {"ORMBMKQDZ" },  notes = "GetByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/{ormbmkqdz_id}")
    public ResponseEntity<ORMBMKQDZDTO> getByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmkqdz_id") String ormbmkqdz_id) {
        ORMBMKQDZ domain = ormbmkqdzService.get(ormbmkqdz_id);
        ORMBMKQDZDTO dto = ormbmkqdzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMBMKQDZ-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByORMORGORMORGSECTOR", tags = {"ORMBMKQDZ" } ,notes = "fetchDEFAULTByORMORGORMORGSECTOR")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/fetchdefault")
	public ResponseEntity<List<ORMBMKQDZDTO>> fetchORMBMKQDZDefaultByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id,ORMBMKQDZSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<ORMBMKQDZ> domains = ormbmkqdzService.searchDefault(context) ;
        List<ORMBMKQDZDTO> list = ormbmkqdzMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMBMKQDZ-Default-all')")
	@ApiOperation(value = "searchDEFAULTByORMORGORMORGSECTOR", tags = {"ORMBMKQDZ" } ,notes = "searchDEFAULTByORMORGORMORGSECTOR")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/searchdefault")
	public ResponseEntity<Page<ORMBMKQDZDTO>> searchORMBMKQDZDefaultByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMBMKQDZSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<ORMBMKQDZ> domains = ormbmkqdzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormbmkqdzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

