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
import cn.ibizlab.ehr.core.orm.domain.ORMBMGWBZ;
import cn.ibizlab.ehr.core.orm.service.IORMBMGWBZService;
import cn.ibizlab.ehr.core.orm.filter.ORMBMGWBZSearchContext;

@Slf4j
@Api(tags = {"ORMBMGWBZ" })
@RestController("WebApi-ormbmgwbz")
@RequestMapping("")
public class ORMBMGWBZResource {

    @Autowired
    public IORMBMGWBZService ormbmgwbzService;

    @Autowired
    @Lazy
    public ORMBMGWBZMapping ormbmgwbzMapping;

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdto),'ehr-ORMBMGWBZ-Create')")
    @ApiOperation(value = "Create", tags = {"ORMBMGWBZ" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmgwbzs")
    @Transactional
    public ResponseEntity<ORMBMGWBZDTO> create(@RequestBody ORMBMGWBZDTO ormbmgwbzdto) {
        ORMBMGWBZ domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
		ormbmgwbzService.create(domain);
        ORMBMGWBZDTO dto = ormbmgwbzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos),'ehr-ORMBMGWBZ-Create')")
    @ApiOperation(value = "createBatch", tags = {"ORMBMGWBZ" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ORMBMGWBZDTO> ormbmgwbzdtos) {
        ormbmgwbzService.createBatch(ormbmgwbzMapping.toDomain(ormbmgwbzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"ORMBMGWBZ" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmgwbzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ORMBMGWBZDTO ormbmgwbzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.checkKey(ormbmgwbzMapping.toDomain(ormbmgwbzdto)));
    }

    @PostAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(returnObject.body),'ehr-ORMBMGWBZ-Get')")
    @ApiOperation(value = "Get", tags = {"ORMBMGWBZ" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormbmgwbzs/{ormbmgwbz_id}")
    public ResponseEntity<ORMBMGWBZDTO> get(@PathVariable("ormbmgwbz_id") String ormbmgwbz_id) {
        ORMBMGWBZ domain = ormbmgwbzService.get(ormbmgwbz_id);
        ORMBMGWBZDTO dto = ormbmgwbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdto),'ehr-ORMBMGWBZ-Save')")
    @ApiOperation(value = "Save", tags = {"ORMBMGWBZ" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmgwbzs/save")
    public ResponseEntity<Boolean> save(@RequestBody ORMBMGWBZDTO ormbmgwbzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.save(ormbmgwbzMapping.toDomain(ormbmgwbzdto)));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos),'ehr-ORMBMGWBZ-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"ORMBMGWBZ" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmgwbzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ORMBMGWBZDTO> ormbmgwbzdtos) {
        ormbmgwbzService.saveBatch(ormbmgwbzMapping.toDomain(ormbmgwbzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.get(#ormbmgwbz_id),'ehr-ORMBMGWBZ-Update')")
    @ApiOperation(value = "Update", tags = {"ORMBMGWBZ" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormbmgwbzs/{ormbmgwbz_id}")
    @Transactional
    public ResponseEntity<ORMBMGWBZDTO> update(@PathVariable("ormbmgwbz_id") String ormbmgwbz_id, @RequestBody ORMBMGWBZDTO ormbmgwbzdto) {
		ORMBMGWBZ domain  = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain .setOrmbmgwbzid(ormbmgwbz_id);
		ormbmgwbzService.update(domain );
		ORMBMGWBZDTO dto = ormbmgwbzMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.getOrmbmgwbzByEntities(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos)),'ehr-ORMBMGWBZ-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"ORMBMGWBZ" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ORMBMGWBZDTO> ormbmgwbzdtos) {
        ormbmgwbzService.updateBatch(ormbmgwbzMapping.toDomain(ormbmgwbzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"ORMBMGWBZ" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormbmgwbzs/getdraft")
    public ResponseEntity<ORMBMGWBZDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzMapping.toDto(ormbmgwbzService.getDraft(new ORMBMGWBZ())));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.get(#ormbmgwbz_id),'ehr-ORMBMGWBZ-Remove')")
    @ApiOperation(value = "Remove", tags = {"ORMBMGWBZ" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormbmgwbzs/{ormbmgwbz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormbmgwbz_id") String ormbmgwbz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.remove(ormbmgwbz_id));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.getOrmbmgwbzByIds(#ids),'ehr-ORMBMGWBZ-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"ORMBMGWBZ" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormbmgwbzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMBMGWBZ-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ORMBMGWBZ" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormbmgwbzs/fetchdefault")
	public ResponseEntity<List<ORMBMGWBZDTO>> fetchDefault(ORMBMGWBZSearchContext context) {
        Page<ORMBMGWBZ> domains = ormbmgwbzService.searchDefault(context) ;
        List<ORMBMGWBZDTO> list = ormbmgwbzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMBMGWBZ-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ORMBMGWBZ" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormbmgwbzs/searchdefault")
	public ResponseEntity<Page<ORMBMGWBZDTO>> searchDefault(@RequestBody ORMBMGWBZSearchContext context) {
        Page<ORMBMGWBZ> domains = ormbmgwbzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormbmgwbzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdto),'ehr-ORMBMGWBZ-Create')")
    @ApiOperation(value = "CreateByOrmOrgsector", tags = {"ORMBMGWBZ" },  notes = "CreateByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs")
    @Transactional
    public ResponseEntity<ORMBMGWBZDTO> createByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMBMGWBZDTO ormbmgwbzdto) {
        ORMBMGWBZ domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmgwbzid(ormorgsector_id);
		ormbmgwbzService.create(domain);
        ORMBMGWBZDTO dto = ormbmgwbzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos),'ehr-ORMBMGWBZ-Create')")
    @ApiOperation(value = "createBatchByOrmOrgsector", tags = {"ORMBMGWBZ" },  notes = "createBatchByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMBMGWBZDTO> ormbmgwbzdtos) {
        List<ORMBMGWBZ> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(ORMBMGWBZ domain:domainlist){
            domain.setOrmgwbzid(ormorgsector_id);
        }
        ormbmgwbzService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByOrmOrgsector", tags = {"ORMBMGWBZ" },  notes = "CheckKeyByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMBMGWBZDTO ormbmgwbzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.checkKey(ormbmgwbzMapping.toDomain(ormbmgwbzdto)));
    }

    @PostAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(returnObject.body),'ehr-ORMBMGWBZ-Get')")
    @ApiOperation(value = "GetByOrmOrgsector", tags = {"ORMBMGWBZ" },  notes = "GetByOrmOrgsector")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/{ormbmgwbz_id}")
    public ResponseEntity<ORMBMGWBZDTO> getByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id) {
        ORMBMGWBZ domain = ormbmgwbzService.get(ormbmgwbz_id);
        ORMBMGWBZDTO dto = ormbmgwbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdto),'ehr-ORMBMGWBZ-Save')")
    @ApiOperation(value = "SaveByOrmOrgsector", tags = {"ORMBMGWBZ" },  notes = "SaveByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/save")
    public ResponseEntity<Boolean> saveByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMBMGWBZDTO ormbmgwbzdto) {
        ORMBMGWBZ domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmgwbzid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos),'ehr-ORMBMGWBZ-Save')")
    @ApiOperation(value = "SaveBatchByOrmOrgsector", tags = {"ORMBMGWBZ" },  notes = "SaveBatchByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMBMGWBZDTO> ormbmgwbzdtos) {
        List<ORMBMGWBZ> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(ORMBMGWBZ domain:domainlist){
             domain.setOrmgwbzid(ormorgsector_id);
        }
        ormbmgwbzService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.get(#ormbmgwbz_id),'ehr-ORMBMGWBZ-Update')")
    @ApiOperation(value = "UpdateByOrmOrgsector", tags = {"ORMBMGWBZ" },  notes = "UpdateByOrmOrgsector")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/{ormbmgwbz_id}")
    @Transactional
    public ResponseEntity<ORMBMGWBZDTO> updateByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id, @RequestBody ORMBMGWBZDTO ormbmgwbzdto) {
        ORMBMGWBZ domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmgwbzid(ormorgsector_id);
        domain.setOrmbmgwbzid(ormbmgwbz_id);
		ormbmgwbzService.update(domain);
        ORMBMGWBZDTO dto = ormbmgwbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.getOrmbmgwbzByEntities(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos)),'ehr-ORMBMGWBZ-Update')")
    @ApiOperation(value = "UpdateBatchByOrmOrgsector", tags = {"ORMBMGWBZ" },  notes = "UpdateBatchByOrmOrgsector")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMBMGWBZDTO> ormbmgwbzdtos) {
        List<ORMBMGWBZ> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(ORMBMGWBZ domain:domainlist){
            domain.setOrmgwbzid(ormorgsector_id);
        }
        ormbmgwbzService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByOrmOrgsector", tags = {"ORMBMGWBZ" },  notes = "GetDraftByOrmOrgsector")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/getdraft")
    public ResponseEntity<ORMBMGWBZDTO> getDraftByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id) {
        ORMBMGWBZ domain = new ORMBMGWBZ();
        domain.setOrmgwbzid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzMapping.toDto(ormbmgwbzService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.get(#ormbmgwbz_id),'ehr-ORMBMGWBZ-Remove')")
    @ApiOperation(value = "RemoveByOrmOrgsector", tags = {"ORMBMGWBZ" },  notes = "RemoveByOrmOrgsector")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/{ormbmgwbz_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.remove(ormbmgwbz_id));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.getOrmbmgwbzByIds(#ids),'ehr-ORMBMGWBZ-Remove')")
    @ApiOperation(value = "RemoveBatchByOrmOrgsector", tags = {"ORMBMGWBZ" },  notes = "RemoveBatchByOrmOrgsector")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgsector(@RequestBody List<String> ids) {
        ormbmgwbzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMBMGWBZ-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByOrmOrgsector", tags = {"ORMBMGWBZ" } ,notes = "fetchDEFAULTByOrmOrgsector")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/fetchdefault")
	public ResponseEntity<List<ORMBMGWBZDTO>> fetchORMBMGWBZDefaultByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id,ORMBMGWBZSearchContext context) {
        context.setN_ormgwbzid_eq(ormorgsector_id);
        Page<ORMBMGWBZ> domains = ormbmgwbzService.searchDefault(context) ;
        List<ORMBMGWBZDTO> list = ormbmgwbzMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMBMGWBZ-Default-all')")
	@ApiOperation(value = "searchDEFAULTByOrmOrgsector", tags = {"ORMBMGWBZ" } ,notes = "searchDEFAULTByOrmOrgsector")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/searchdefault")
	public ResponseEntity<Page<ORMBMGWBZDTO>> searchORMBMGWBZDefaultByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMBMGWBZSearchContext context) {
        context.setN_ormgwbzid_eq(ormorgsector_id);
        Page<ORMBMGWBZ> domains = ormbmgwbzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormbmgwbzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdto),'ehr-ORMBMGWBZ-Create')")
    @ApiOperation(value = "CreateByORMPOST", tags = {"ORMBMGWBZ" },  notes = "CreateByORMPOST")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/ormbmgwbzs")
    @Transactional
    public ResponseEntity<ORMBMGWBZDTO> createByORMPOST(@PathVariable("ormpost_id") String ormpost_id, @RequestBody ORMBMGWBZDTO ormbmgwbzdto) {
        ORMBMGWBZ domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmpostid(ormpost_id);
		ormbmgwbzService.create(domain);
        ORMBMGWBZDTO dto = ormbmgwbzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos),'ehr-ORMBMGWBZ-Create')")
    @ApiOperation(value = "createBatchByORMPOST", tags = {"ORMBMGWBZ" },  notes = "createBatchByORMPOST")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> createBatchByORMPOST(@PathVariable("ormpost_id") String ormpost_id, @RequestBody List<ORMBMGWBZDTO> ormbmgwbzdtos) {
        List<ORMBMGWBZ> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(ORMBMGWBZ domain:domainlist){
            domain.setOrmpostid(ormpost_id);
        }
        ormbmgwbzService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByORMPOST", tags = {"ORMBMGWBZ" },  notes = "CheckKeyByORMPOST")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/ormbmgwbzs/checkkey")
    public ResponseEntity<Boolean> checkKeyByORMPOST(@PathVariable("ormpost_id") String ormpost_id, @RequestBody ORMBMGWBZDTO ormbmgwbzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.checkKey(ormbmgwbzMapping.toDomain(ormbmgwbzdto)));
    }

    @PostAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(returnObject.body),'ehr-ORMBMGWBZ-Get')")
    @ApiOperation(value = "GetByORMPOST", tags = {"ORMBMGWBZ" },  notes = "GetByORMPOST")
	@RequestMapping(method = RequestMethod.GET, value = "/ormposts/{ormpost_id}/ormbmgwbzs/{ormbmgwbz_id}")
    public ResponseEntity<ORMBMGWBZDTO> getByORMPOST(@PathVariable("ormpost_id") String ormpost_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id) {
        ORMBMGWBZ domain = ormbmgwbzService.get(ormbmgwbz_id);
        ORMBMGWBZDTO dto = ormbmgwbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdto),'ehr-ORMBMGWBZ-Save')")
    @ApiOperation(value = "SaveByORMPOST", tags = {"ORMBMGWBZ" },  notes = "SaveByORMPOST")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/ormbmgwbzs/save")
    public ResponseEntity<Boolean> saveByORMPOST(@PathVariable("ormpost_id") String ormpost_id, @RequestBody ORMBMGWBZDTO ormbmgwbzdto) {
        ORMBMGWBZ domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmpostid(ormpost_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos),'ehr-ORMBMGWBZ-Save')")
    @ApiOperation(value = "SaveBatchByORMPOST", tags = {"ORMBMGWBZ" },  notes = "SaveBatchByORMPOST")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/ormbmgwbzs/savebatch")
    public ResponseEntity<Boolean> saveBatchByORMPOST(@PathVariable("ormpost_id") String ormpost_id, @RequestBody List<ORMBMGWBZDTO> ormbmgwbzdtos) {
        List<ORMBMGWBZ> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(ORMBMGWBZ domain:domainlist){
             domain.setOrmpostid(ormpost_id);
        }
        ormbmgwbzService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.get(#ormbmgwbz_id),'ehr-ORMBMGWBZ-Update')")
    @ApiOperation(value = "UpdateByORMPOST", tags = {"ORMBMGWBZ" },  notes = "UpdateByORMPOST")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormposts/{ormpost_id}/ormbmgwbzs/{ormbmgwbz_id}")
    @Transactional
    public ResponseEntity<ORMBMGWBZDTO> updateByORMPOST(@PathVariable("ormpost_id") String ormpost_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id, @RequestBody ORMBMGWBZDTO ormbmgwbzdto) {
        ORMBMGWBZ domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmpostid(ormpost_id);
        domain.setOrmbmgwbzid(ormbmgwbz_id);
		ormbmgwbzService.update(domain);
        ORMBMGWBZDTO dto = ormbmgwbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.getOrmbmgwbzByEntities(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos)),'ehr-ORMBMGWBZ-Update')")
    @ApiOperation(value = "UpdateBatchByORMPOST", tags = {"ORMBMGWBZ" },  notes = "UpdateBatchByORMPOST")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormposts/{ormpost_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> updateBatchByORMPOST(@PathVariable("ormpost_id") String ormpost_id, @RequestBody List<ORMBMGWBZDTO> ormbmgwbzdtos) {
        List<ORMBMGWBZ> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(ORMBMGWBZ domain:domainlist){
            domain.setOrmpostid(ormpost_id);
        }
        ormbmgwbzService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByORMPOST", tags = {"ORMBMGWBZ" },  notes = "GetDraftByORMPOST")
    @RequestMapping(method = RequestMethod.GET, value = "/ormposts/{ormpost_id}/ormbmgwbzs/getdraft")
    public ResponseEntity<ORMBMGWBZDTO> getDraftByORMPOST(@PathVariable("ormpost_id") String ormpost_id) {
        ORMBMGWBZ domain = new ORMBMGWBZ();
        domain.setOrmpostid(ormpost_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzMapping.toDto(ormbmgwbzService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.get(#ormbmgwbz_id),'ehr-ORMBMGWBZ-Remove')")
    @ApiOperation(value = "RemoveByORMPOST", tags = {"ORMBMGWBZ" },  notes = "RemoveByORMPOST")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormposts/{ormpost_id}/ormbmgwbzs/{ormbmgwbz_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByORMPOST(@PathVariable("ormpost_id") String ormpost_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.remove(ormbmgwbz_id));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.getOrmbmgwbzByIds(#ids),'ehr-ORMBMGWBZ-Remove')")
    @ApiOperation(value = "RemoveBatchByORMPOST", tags = {"ORMBMGWBZ" },  notes = "RemoveBatchByORMPOST")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormposts/{ormpost_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> removeBatchByORMPOST(@RequestBody List<String> ids) {
        ormbmgwbzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMBMGWBZ-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByORMPOST", tags = {"ORMBMGWBZ" } ,notes = "fetchDEFAULTByORMPOST")
    @RequestMapping(method= RequestMethod.GET , value="/ormposts/{ormpost_id}/ormbmgwbzs/fetchdefault")
	public ResponseEntity<List<ORMBMGWBZDTO>> fetchORMBMGWBZDefaultByORMPOST(@PathVariable("ormpost_id") String ormpost_id,ORMBMGWBZSearchContext context) {
        context.setN_ormpostid_eq(ormpost_id);
        Page<ORMBMGWBZ> domains = ormbmgwbzService.searchDefault(context) ;
        List<ORMBMGWBZDTO> list = ormbmgwbzMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMBMGWBZ-Default-all')")
	@ApiOperation(value = "searchDEFAULTByORMPOST", tags = {"ORMBMGWBZ" } ,notes = "searchDEFAULTByORMPOST")
    @RequestMapping(method= RequestMethod.POST , value="/ormposts/{ormpost_id}/ormbmgwbzs/searchdefault")
	public ResponseEntity<Page<ORMBMGWBZDTO>> searchORMBMGWBZDefaultByORMPOST(@PathVariable("ormpost_id") String ormpost_id, @RequestBody ORMBMGWBZSearchContext context) {
        context.setN_ormpostid_eq(ormpost_id);
        Page<ORMBMGWBZ> domains = ormbmgwbzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormbmgwbzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdto),'ehr-ORMBMGWBZ-Create')")
    @ApiOperation(value = "CreateByOrmOrgOrmOrgsector", tags = {"ORMBMGWBZ" },  notes = "CreateByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs")
    @Transactional
    public ResponseEntity<ORMBMGWBZDTO> createByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMBMGWBZDTO ormbmgwbzdto) {
        ORMBMGWBZ domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmgwbzid(ormorgsector_id);
		ormbmgwbzService.create(domain);
        ORMBMGWBZDTO dto = ormbmgwbzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos),'ehr-ORMBMGWBZ-Create')")
    @ApiOperation(value = "createBatchByOrmOrgOrmOrgsector", tags = {"ORMBMGWBZ" },  notes = "createBatchByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMBMGWBZDTO> ormbmgwbzdtos) {
        List<ORMBMGWBZ> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(ORMBMGWBZ domain:domainlist){
            domain.setOrmgwbzid(ormorgsector_id);
        }
        ormbmgwbzService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByOrmOrgOrmOrgsector", tags = {"ORMBMGWBZ" },  notes = "CheckKeyByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMBMGWBZDTO ormbmgwbzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.checkKey(ormbmgwbzMapping.toDomain(ormbmgwbzdto)));
    }

    @PostAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(returnObject.body),'ehr-ORMBMGWBZ-Get')")
    @ApiOperation(value = "GetByOrmOrgOrmOrgsector", tags = {"ORMBMGWBZ" },  notes = "GetByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/{ormbmgwbz_id}")
    public ResponseEntity<ORMBMGWBZDTO> getByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id) {
        ORMBMGWBZ domain = ormbmgwbzService.get(ormbmgwbz_id);
        ORMBMGWBZDTO dto = ormbmgwbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdto),'ehr-ORMBMGWBZ-Save')")
    @ApiOperation(value = "SaveByOrmOrgOrmOrgsector", tags = {"ORMBMGWBZ" },  notes = "SaveByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/save")
    public ResponseEntity<Boolean> saveByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMBMGWBZDTO ormbmgwbzdto) {
        ORMBMGWBZ domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmgwbzid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos),'ehr-ORMBMGWBZ-Save')")
    @ApiOperation(value = "SaveBatchByOrmOrgOrmOrgsector", tags = {"ORMBMGWBZ" },  notes = "SaveBatchByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMBMGWBZDTO> ormbmgwbzdtos) {
        List<ORMBMGWBZ> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(ORMBMGWBZ domain:domainlist){
             domain.setOrmgwbzid(ormorgsector_id);
        }
        ormbmgwbzService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.get(#ormbmgwbz_id),'ehr-ORMBMGWBZ-Update')")
    @ApiOperation(value = "UpdateByOrmOrgOrmOrgsector", tags = {"ORMBMGWBZ" },  notes = "UpdateByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/{ormbmgwbz_id}")
    @Transactional
    public ResponseEntity<ORMBMGWBZDTO> updateByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id, @RequestBody ORMBMGWBZDTO ormbmgwbzdto) {
        ORMBMGWBZ domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmgwbzid(ormorgsector_id);
        domain.setOrmbmgwbzid(ormbmgwbz_id);
		ormbmgwbzService.update(domain);
        ORMBMGWBZDTO dto = ormbmgwbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.getOrmbmgwbzByEntities(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos)),'ehr-ORMBMGWBZ-Update')")
    @ApiOperation(value = "UpdateBatchByOrmOrgOrmOrgsector", tags = {"ORMBMGWBZ" },  notes = "UpdateBatchByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMBMGWBZDTO> ormbmgwbzdtos) {
        List<ORMBMGWBZ> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(ORMBMGWBZ domain:domainlist){
            domain.setOrmgwbzid(ormorgsector_id);
        }
        ormbmgwbzService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByOrmOrgOrmOrgsector", tags = {"ORMBMGWBZ" },  notes = "GetDraftByOrmOrgOrmOrgsector")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/getdraft")
    public ResponseEntity<ORMBMGWBZDTO> getDraftByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id) {
        ORMBMGWBZ domain = new ORMBMGWBZ();
        domain.setOrmgwbzid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzMapping.toDto(ormbmgwbzService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.get(#ormbmgwbz_id),'ehr-ORMBMGWBZ-Remove')")
    @ApiOperation(value = "RemoveByOrmOrgOrmOrgsector", tags = {"ORMBMGWBZ" },  notes = "RemoveByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/{ormbmgwbz_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.remove(ormbmgwbz_id));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.getOrmbmgwbzByIds(#ids),'ehr-ORMBMGWBZ-Remove')")
    @ApiOperation(value = "RemoveBatchByOrmOrgOrmOrgsector", tags = {"ORMBMGWBZ" },  notes = "RemoveBatchByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgOrmOrgsector(@RequestBody List<String> ids) {
        ormbmgwbzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMBMGWBZ-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByOrmOrgOrmOrgsector", tags = {"ORMBMGWBZ" } ,notes = "fetchDEFAULTByOrmOrgOrmOrgsector")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/fetchdefault")
	public ResponseEntity<List<ORMBMGWBZDTO>> fetchORMBMGWBZDefaultByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id,ORMBMGWBZSearchContext context) {
        context.setN_ormgwbzid_eq(ormorgsector_id);
        Page<ORMBMGWBZ> domains = ormbmgwbzService.searchDefault(context) ;
        List<ORMBMGWBZDTO> list = ormbmgwbzMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMBMGWBZ-Default-all')")
	@ApiOperation(value = "searchDEFAULTByOrmOrgOrmOrgsector", tags = {"ORMBMGWBZ" } ,notes = "searchDEFAULTByOrmOrgOrmOrgsector")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/searchdefault")
	public ResponseEntity<Page<ORMBMGWBZDTO>> searchORMBMGWBZDefaultByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMBMGWBZSearchContext context) {
        context.setN_ormgwbzid_eq(ormorgsector_id);
        Page<ORMBMGWBZ> domains = ormbmgwbzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormbmgwbzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

