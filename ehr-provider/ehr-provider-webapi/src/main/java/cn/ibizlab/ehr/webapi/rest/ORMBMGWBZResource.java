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
    @ApiOperation(value = "CreateByORMORGSECTOR", tags = {"ORMBMGWBZ" },  notes = "CreateByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs")
    @Transactional
    public ResponseEntity<ORMBMGWBZDTO> createByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMBMGWBZDTO ormbmgwbzdto) {
        ORMBMGWBZ domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmgwbzid(ormorgsector_id);
		ormbmgwbzService.create(domain);
        ORMBMGWBZDTO dto = ormbmgwbzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos),'ehr-ORMBMGWBZ-Create')")
    @ApiOperation(value = "createBatchByORMORGSECTOR", tags = {"ORMBMGWBZ" },  notes = "createBatchByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> createBatchByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMBMGWBZDTO> ormbmgwbzdtos) {
        List<ORMBMGWBZ> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(ORMBMGWBZ domain:domainlist){
            domain.setOrmgwbzid(ormorgsector_id);
        }
        ormbmgwbzService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByORMORGSECTOR", tags = {"ORMBMGWBZ" },  notes = "CheckKeyByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/checkkey")
    public ResponseEntity<Boolean> checkKeyByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMBMGWBZDTO ormbmgwbzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.checkKey(ormbmgwbzMapping.toDomain(ormbmgwbzdto)));
    }

    @PostAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(returnObject.body),'ehr-ORMBMGWBZ-Get')")
    @ApiOperation(value = "GetByORMORGSECTOR", tags = {"ORMBMGWBZ" },  notes = "GetByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/{ormbmgwbz_id}")
    public ResponseEntity<ORMBMGWBZDTO> getByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id) {
        ORMBMGWBZ domain = ormbmgwbzService.get(ormbmgwbz_id);
        ORMBMGWBZDTO dto = ormbmgwbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdto),'ehr-ORMBMGWBZ-Save')")
    @ApiOperation(value = "SaveByORMORGSECTOR", tags = {"ORMBMGWBZ" },  notes = "SaveByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/save")
    public ResponseEntity<Boolean> saveByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMBMGWBZDTO ormbmgwbzdto) {
        ORMBMGWBZ domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmgwbzid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos),'ehr-ORMBMGWBZ-Save')")
    @ApiOperation(value = "SaveBatchByORMORGSECTOR", tags = {"ORMBMGWBZ" },  notes = "SaveBatchByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/savebatch")
    public ResponseEntity<Boolean> saveBatchByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMBMGWBZDTO> ormbmgwbzdtos) {
        List<ORMBMGWBZ> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(ORMBMGWBZ domain:domainlist){
             domain.setOrmgwbzid(ormorgsector_id);
        }
        ormbmgwbzService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.get(#ormbmgwbz_id),'ehr-ORMBMGWBZ-Update')")
    @ApiOperation(value = "UpdateByORMORGSECTOR", tags = {"ORMBMGWBZ" },  notes = "UpdateByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/{ormbmgwbz_id}")
    @Transactional
    public ResponseEntity<ORMBMGWBZDTO> updateByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id, @RequestBody ORMBMGWBZDTO ormbmgwbzdto) {
        ORMBMGWBZ domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmgwbzid(ormorgsector_id);
        domain.setOrmbmgwbzid(ormbmgwbz_id);
		ormbmgwbzService.update(domain);
        ORMBMGWBZDTO dto = ormbmgwbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.getOrmbmgwbzByEntities(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos)),'ehr-ORMBMGWBZ-Update')")
    @ApiOperation(value = "UpdateBatchByORMORGSECTOR", tags = {"ORMBMGWBZ" },  notes = "UpdateBatchByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> updateBatchByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMBMGWBZDTO> ormbmgwbzdtos) {
        List<ORMBMGWBZ> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(ORMBMGWBZ domain:domainlist){
            domain.setOrmgwbzid(ormorgsector_id);
        }
        ormbmgwbzService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByORMORGSECTOR", tags = {"ORMBMGWBZ" },  notes = "GetDraftByORMORGSECTOR")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/getdraft")
    public ResponseEntity<ORMBMGWBZDTO> getDraftByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id) {
        ORMBMGWBZ domain = new ORMBMGWBZ();
        domain.setOrmgwbzid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzMapping.toDto(ormbmgwbzService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.get(#ormbmgwbz_id),'ehr-ORMBMGWBZ-Remove')")
    @ApiOperation(value = "RemoveByORMORGSECTOR", tags = {"ORMBMGWBZ" },  notes = "RemoveByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/{ormbmgwbz_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.remove(ormbmgwbz_id));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.getOrmbmgwbzByIds(#ids),'ehr-ORMBMGWBZ-Remove')")
    @ApiOperation(value = "RemoveBatchByORMORGSECTOR", tags = {"ORMBMGWBZ" },  notes = "RemoveBatchByORMORGSECTOR")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> removeBatchByORMORGSECTOR(@RequestBody List<String> ids) {
        ormbmgwbzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMBMGWBZ-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByORMORGSECTOR", tags = {"ORMBMGWBZ" } ,notes = "fetchDEFAULTByORMORGSECTOR")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/fetchdefault")
	public ResponseEntity<List<ORMBMGWBZDTO>> fetchORMBMGWBZDefaultByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id,ORMBMGWBZSearchContext context) {
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
	@ApiOperation(value = "searchDEFAULTByORMORGSECTOR", tags = {"ORMBMGWBZ" } ,notes = "searchDEFAULTByORMORGSECTOR")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/searchdefault")
	public ResponseEntity<Page<ORMBMGWBZDTO>> searchORMBMGWBZDefaultByORMORGSECTOR(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMBMGWBZSearchContext context) {
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
    @ApiOperation(value = "CreateByORMORGORMORGSECTOR", tags = {"ORMBMGWBZ" },  notes = "CreateByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs")
    @Transactional
    public ResponseEntity<ORMBMGWBZDTO> createByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMBMGWBZDTO ormbmgwbzdto) {
        ORMBMGWBZ domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmgwbzid(ormorgsector_id);
		ormbmgwbzService.create(domain);
        ORMBMGWBZDTO dto = ormbmgwbzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos),'ehr-ORMBMGWBZ-Create')")
    @ApiOperation(value = "createBatchByORMORGORMORGSECTOR", tags = {"ORMBMGWBZ" },  notes = "createBatchByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> createBatchByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMBMGWBZDTO> ormbmgwbzdtos) {
        List<ORMBMGWBZ> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(ORMBMGWBZ domain:domainlist){
            domain.setOrmgwbzid(ormorgsector_id);
        }
        ormbmgwbzService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByORMORGORMORGSECTOR", tags = {"ORMBMGWBZ" },  notes = "CheckKeyByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/checkkey")
    public ResponseEntity<Boolean> checkKeyByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMBMGWBZDTO ormbmgwbzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.checkKey(ormbmgwbzMapping.toDomain(ormbmgwbzdto)));
    }

    @PostAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(returnObject.body),'ehr-ORMBMGWBZ-Get')")
    @ApiOperation(value = "GetByORMORGORMORGSECTOR", tags = {"ORMBMGWBZ" },  notes = "GetByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/{ormbmgwbz_id}")
    public ResponseEntity<ORMBMGWBZDTO> getByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id) {
        ORMBMGWBZ domain = ormbmgwbzService.get(ormbmgwbz_id);
        ORMBMGWBZDTO dto = ormbmgwbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdto),'ehr-ORMBMGWBZ-Save')")
    @ApiOperation(value = "SaveByORMORGORMORGSECTOR", tags = {"ORMBMGWBZ" },  notes = "SaveByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/save")
    public ResponseEntity<Boolean> saveByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMBMGWBZDTO ormbmgwbzdto) {
        ORMBMGWBZ domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmgwbzid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos),'ehr-ORMBMGWBZ-Save')")
    @ApiOperation(value = "SaveBatchByORMORGORMORGSECTOR", tags = {"ORMBMGWBZ" },  notes = "SaveBatchByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/savebatch")
    public ResponseEntity<Boolean> saveBatchByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMBMGWBZDTO> ormbmgwbzdtos) {
        List<ORMBMGWBZ> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(ORMBMGWBZ domain:domainlist){
             domain.setOrmgwbzid(ormorgsector_id);
        }
        ormbmgwbzService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.get(#ormbmgwbz_id),'ehr-ORMBMGWBZ-Update')")
    @ApiOperation(value = "UpdateByORMORGORMORGSECTOR", tags = {"ORMBMGWBZ" },  notes = "UpdateByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/{ormbmgwbz_id}")
    @Transactional
    public ResponseEntity<ORMBMGWBZDTO> updateByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id, @RequestBody ORMBMGWBZDTO ormbmgwbzdto) {
        ORMBMGWBZ domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmgwbzid(ormorgsector_id);
        domain.setOrmbmgwbzid(ormbmgwbz_id);
		ormbmgwbzService.update(domain);
        ORMBMGWBZDTO dto = ormbmgwbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.getOrmbmgwbzByEntities(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos)),'ehr-ORMBMGWBZ-Update')")
    @ApiOperation(value = "UpdateBatchByORMORGORMORGSECTOR", tags = {"ORMBMGWBZ" },  notes = "UpdateBatchByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> updateBatchByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMBMGWBZDTO> ormbmgwbzdtos) {
        List<ORMBMGWBZ> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(ORMBMGWBZ domain:domainlist){
            domain.setOrmgwbzid(ormorgsector_id);
        }
        ormbmgwbzService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByORMORGORMORGSECTOR", tags = {"ORMBMGWBZ" },  notes = "GetDraftByORMORGORMORGSECTOR")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/getdraft")
    public ResponseEntity<ORMBMGWBZDTO> getDraftByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id) {
        ORMBMGWBZ domain = new ORMBMGWBZ();
        domain.setOrmgwbzid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzMapping.toDto(ormbmgwbzService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.get(#ormbmgwbz_id),'ehr-ORMBMGWBZ-Remove')")
    @ApiOperation(value = "RemoveByORMORGORMORGSECTOR", tags = {"ORMBMGWBZ" },  notes = "RemoveByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/{ormbmgwbz_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.remove(ormbmgwbz_id));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.getOrmbmgwbzByIds(#ids),'ehr-ORMBMGWBZ-Remove')")
    @ApiOperation(value = "RemoveBatchByORMORGORMORGSECTOR", tags = {"ORMBMGWBZ" },  notes = "RemoveBatchByORMORGORMORGSECTOR")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> removeBatchByORMORGORMORGSECTOR(@RequestBody List<String> ids) {
        ormbmgwbzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMBMGWBZ-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByORMORGORMORGSECTOR", tags = {"ORMBMGWBZ" } ,notes = "fetchDEFAULTByORMORGORMORGSECTOR")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/fetchdefault")
	public ResponseEntity<List<ORMBMGWBZDTO>> fetchORMBMGWBZDefaultByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id,ORMBMGWBZSearchContext context) {
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
	@ApiOperation(value = "searchDEFAULTByORMORGORMORGSECTOR", tags = {"ORMBMGWBZ" } ,notes = "searchDEFAULTByORMORGORMORGSECTOR")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/searchdefault")
	public ResponseEntity<Page<ORMBMGWBZDTO>> searchORMBMGWBZDefaultByORMORGORMORGSECTOR(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMBMGWBZSearchContext context) {
        context.setN_ormgwbzid_eq(ormorgsector_id);
        Page<ORMBMGWBZ> domains = ormbmgwbzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormbmgwbzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

