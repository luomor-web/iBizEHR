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
import cn.ibizlab.ehr.core.orm.domain.OrmBmkqdz;
import cn.ibizlab.ehr.core.orm.service.IOrmBmkqdzService;
import cn.ibizlab.ehr.core.orm.filter.OrmBmkqdzSearchContext;

@Slf4j
@Api(tags = {"OrmBmkqdz" })
@RestController("WebApi-ormbmkqdz")
@RequestMapping("")
public class OrmBmkqdzResource {

    @Autowired
    public IOrmBmkqdzService ormbmkqdzService;

    @Autowired
    @Lazy
    public OrmBmkqdzMapping ormbmkqdzMapping;

    @PreAuthorize("hasPermission(this.ormbmkqdzService.get(#ormbmkqdz_id),'ehr-OrmBmkqdz-Remove')")
    @ApiOperation(value = "Remove", tags = {"OrmBmkqdz" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormbmkqdzs/{ormbmkqdz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormbmkqdz_id") String ormbmkqdz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzService.remove(ormbmkqdz_id));
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzService.getOrmbmkqdzByIds(#ids),'ehr-OrmBmkqdz-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"OrmBmkqdz" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormbmkqdzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormbmkqdzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"OrmBmkqdz" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormbmkqdzs/getdraft")
    public ResponseEntity<OrmBmkqdzDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzMapping.toDto(ormbmkqdzService.getDraft(new OrmBmkqdz())));
    }

    @ApiOperation(value = "CheckKey", tags = {"OrmBmkqdz" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmkqdzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrmBmkqdzDTO ormbmkqdzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzService.checkKey(ormbmkqdzMapping.toDomain(ormbmkqdzdto)));
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdto),'ehr-OrmBmkqdz-Save')")
    @ApiOperation(value = "Save", tags = {"OrmBmkqdz" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmkqdzs/save")
    public ResponseEntity<Boolean> save(@RequestBody OrmBmkqdzDTO ormbmkqdzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzService.save(ormbmkqdzMapping.toDomain(ormbmkqdzdto)));
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdtos),'ehr-OrmBmkqdz-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"OrmBmkqdz" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmkqdzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrmBmkqdzDTO> ormbmkqdzdtos) {
        ormbmkqdzService.saveBatch(ormbmkqdzMapping.toDomain(ormbmkqdzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzService.get(#ormbmkqdz_id),'ehr-OrmBmkqdz-Update')")
    @ApiOperation(value = "Update", tags = {"OrmBmkqdz" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormbmkqdzs/{ormbmkqdz_id}")
    @Transactional
    public ResponseEntity<OrmBmkqdzDTO> update(@PathVariable("ormbmkqdz_id") String ormbmkqdz_id, @RequestBody OrmBmkqdzDTO ormbmkqdzdto) {
		OrmBmkqdz domain  = ormbmkqdzMapping.toDomain(ormbmkqdzdto);
        domain .setOrmbmkqdzid(ormbmkqdz_id);
		ormbmkqdzService.update(domain );
		OrmBmkqdzDTO dto = ormbmkqdzMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzService.getOrmbmkqdzByEntities(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdtos)),'ehr-OrmBmkqdz-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"OrmBmkqdz" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormbmkqdzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrmBmkqdzDTO> ormbmkqdzdtos) {
        ormbmkqdzService.updateBatch(ormbmkqdzMapping.toDomain(ormbmkqdzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdto),'ehr-OrmBmkqdz-Create')")
    @ApiOperation(value = "Create", tags = {"OrmBmkqdz" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmkqdzs")
    @Transactional
    public ResponseEntity<OrmBmkqdzDTO> create(@RequestBody OrmBmkqdzDTO ormbmkqdzdto) {
        OrmBmkqdz domain = ormbmkqdzMapping.toDomain(ormbmkqdzdto);
		ormbmkqdzService.create(domain);
        OrmBmkqdzDTO dto = ormbmkqdzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdtos),'ehr-OrmBmkqdz-Create')")
    @ApiOperation(value = "createBatch", tags = {"OrmBmkqdz" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmkqdzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrmBmkqdzDTO> ormbmkqdzdtos) {
        ormbmkqdzService.createBatch(ormbmkqdzMapping.toDomain(ormbmkqdzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(returnObject.body),'ehr-OrmBmkqdz-Get')")
    @ApiOperation(value = "Get", tags = {"OrmBmkqdz" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormbmkqdzs/{ormbmkqdz_id}")
    public ResponseEntity<OrmBmkqdzDTO> get(@PathVariable("ormbmkqdz_id") String ormbmkqdz_id) {
        OrmBmkqdz domain = ormbmkqdzService.get(ormbmkqdz_id);
        OrmBmkqdzDTO dto = ormbmkqdzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmBmkqdz-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"OrmBmkqdz" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormbmkqdzs/fetchdefault")
	public ResponseEntity<List<OrmBmkqdzDTO>> fetchDefault(OrmBmkqdzSearchContext context) {
        Page<OrmBmkqdz> domains = ormbmkqdzService.searchDefault(context) ;
        List<OrmBmkqdzDTO> list = ormbmkqdzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmBmkqdz-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"OrmBmkqdz" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormbmkqdzs/searchdefault")
	public ResponseEntity<Page<OrmBmkqdzDTO>> searchDefault(@RequestBody OrmBmkqdzSearchContext context) {
        Page<OrmBmkqdz> domains = ormbmkqdzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormbmkqdzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.ormbmkqdzService.get(#ormbmkqdz_id),'ehr-OrmBmkqdz-Remove')")
    @ApiOperation(value = "RemoveByOrmOrgsector", tags = {"OrmBmkqdz" },  notes = "RemoveByOrmOrgsector")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/{ormbmkqdz_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmkqdz_id") String ormbmkqdz_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzService.remove(ormbmkqdz_id));
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzService.getOrmbmkqdzByIds(#ids),'ehr-OrmBmkqdz-Remove')")
    @ApiOperation(value = "RemoveBatchByOrmOrgsector", tags = {"OrmBmkqdz" },  notes = "RemoveBatchByOrmOrgsector")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgsector(@RequestBody List<String> ids) {
        ormbmkqdzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByOrmOrgsector", tags = {"OrmBmkqdz" },  notes = "GetDraftByOrmOrgsector")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/getdraft")
    public ResponseEntity<OrmBmkqdzDTO> getDraftByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id) {
        OrmBmkqdz domain = new OrmBmkqdz();
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzMapping.toDto(ormbmkqdzService.getDraft(domain)));
    }

    @ApiOperation(value = "CheckKeyByOrmOrgsector", tags = {"OrmBmkqdz" },  notes = "CheckKeyByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmBmkqdzDTO ormbmkqdzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzService.checkKey(ormbmkqdzMapping.toDomain(ormbmkqdzdto)));
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdto),'ehr-OrmBmkqdz-Save')")
    @ApiOperation(value = "SaveByOrmOrgsector", tags = {"OrmBmkqdz" },  notes = "SaveByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/save")
    public ResponseEntity<Boolean> saveByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmBmkqdzDTO ormbmkqdzdto) {
        OrmBmkqdz domain = ormbmkqdzMapping.toDomain(ormbmkqdzdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdtos),'ehr-OrmBmkqdz-Save')")
    @ApiOperation(value = "SaveBatchByOrmOrgsector", tags = {"OrmBmkqdz" },  notes = "SaveBatchByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<OrmBmkqdzDTO> ormbmkqdzdtos) {
        List<OrmBmkqdz> domainlist=ormbmkqdzMapping.toDomain(ormbmkqdzdtos);
        for(OrmBmkqdz domain:domainlist){
             domain.setOrmorgsectorid(ormorgsector_id);
        }
        ormbmkqdzService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzService.get(#ormbmkqdz_id),'ehr-OrmBmkqdz-Update')")
    @ApiOperation(value = "UpdateByOrmOrgsector", tags = {"OrmBmkqdz" },  notes = "UpdateByOrmOrgsector")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/{ormbmkqdz_id}")
    @Transactional
    public ResponseEntity<OrmBmkqdzDTO> updateByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmkqdz_id") String ormbmkqdz_id, @RequestBody OrmBmkqdzDTO ormbmkqdzdto) {
        OrmBmkqdz domain = ormbmkqdzMapping.toDomain(ormbmkqdzdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        domain.setOrmbmkqdzid(ormbmkqdz_id);
		ormbmkqdzService.update(domain);
        OrmBmkqdzDTO dto = ormbmkqdzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzService.getOrmbmkqdzByEntities(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdtos)),'ehr-OrmBmkqdz-Update')")
    @ApiOperation(value = "UpdateBatchByOrmOrgsector", tags = {"OrmBmkqdz" },  notes = "UpdateBatchByOrmOrgsector")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<OrmBmkqdzDTO> ormbmkqdzdtos) {
        List<OrmBmkqdz> domainlist=ormbmkqdzMapping.toDomain(ormbmkqdzdtos);
        for(OrmBmkqdz domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        ormbmkqdzService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdto),'ehr-OrmBmkqdz-Create')")
    @ApiOperation(value = "CreateByOrmOrgsector", tags = {"OrmBmkqdz" },  notes = "CreateByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormbmkqdzs")
    @Transactional
    public ResponseEntity<OrmBmkqdzDTO> createByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmBmkqdzDTO ormbmkqdzdto) {
        OrmBmkqdz domain = ormbmkqdzMapping.toDomain(ormbmkqdzdto);
        domain.setOrmorgsectorid(ormorgsector_id);
		ormbmkqdzService.create(domain);
        OrmBmkqdzDTO dto = ormbmkqdzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdtos),'ehr-OrmBmkqdz-Create')")
    @ApiOperation(value = "createBatchByOrmOrgsector", tags = {"OrmBmkqdz" },  notes = "createBatchByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<OrmBmkqdzDTO> ormbmkqdzdtos) {
        List<OrmBmkqdz> domainlist=ormbmkqdzMapping.toDomain(ormbmkqdzdtos);
        for(OrmBmkqdz domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        ormbmkqdzService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(returnObject.body),'ehr-OrmBmkqdz-Get')")
    @ApiOperation(value = "GetByOrmOrgsector", tags = {"OrmBmkqdz" },  notes = "GetByOrmOrgsector")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/{ormbmkqdz_id}")
    public ResponseEntity<OrmBmkqdzDTO> getByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmkqdz_id") String ormbmkqdz_id) {
        OrmBmkqdz domain = ormbmkqdzService.get(ormbmkqdz_id);
        OrmBmkqdzDTO dto = ormbmkqdzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmBmkqdz-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByOrmOrgsector", tags = {"OrmBmkqdz" } ,notes = "fetchDEFAULTByOrmOrgsector")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/fetchdefault")
	public ResponseEntity<List<OrmBmkqdzDTO>> fetchOrmBmkqdzDefaultByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id,OrmBmkqdzSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<OrmBmkqdz> domains = ormbmkqdzService.searchDefault(context) ;
        List<OrmBmkqdzDTO> list = ormbmkqdzMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmBmkqdz-Default-all')")
	@ApiOperation(value = "searchDEFAULTByOrmOrgsector", tags = {"OrmBmkqdz" } ,notes = "searchDEFAULTByOrmOrgsector")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/searchdefault")
	public ResponseEntity<Page<OrmBmkqdzDTO>> searchOrmBmkqdzDefaultByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmBmkqdzSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<OrmBmkqdz> domains = ormbmkqdzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormbmkqdzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.ormbmkqdzService.get(#ormbmkqdz_id),'ehr-OrmBmkqdz-Remove')")
    @ApiOperation(value = "RemoveByOrmOrgOrmOrgsector", tags = {"OrmBmkqdz" },  notes = "RemoveByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/{ormbmkqdz_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmkqdz_id") String ormbmkqdz_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzService.remove(ormbmkqdz_id));
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzService.getOrmbmkqdzByIds(#ids),'ehr-OrmBmkqdz-Remove')")
    @ApiOperation(value = "RemoveBatchByOrmOrgOrmOrgsector", tags = {"OrmBmkqdz" },  notes = "RemoveBatchByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgOrmOrgsector(@RequestBody List<String> ids) {
        ormbmkqdzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByOrmOrgOrmOrgsector", tags = {"OrmBmkqdz" },  notes = "GetDraftByOrmOrgOrmOrgsector")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/getdraft")
    public ResponseEntity<OrmBmkqdzDTO> getDraftByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id) {
        OrmBmkqdz domain = new OrmBmkqdz();
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzMapping.toDto(ormbmkqdzService.getDraft(domain)));
    }

    @ApiOperation(value = "CheckKeyByOrmOrgOrmOrgsector", tags = {"OrmBmkqdz" },  notes = "CheckKeyByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmBmkqdzDTO ormbmkqdzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzService.checkKey(ormbmkqdzMapping.toDomain(ormbmkqdzdto)));
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdto),'ehr-OrmBmkqdz-Save')")
    @ApiOperation(value = "SaveByOrmOrgOrmOrgsector", tags = {"OrmBmkqdz" },  notes = "SaveByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/save")
    public ResponseEntity<Boolean> saveByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmBmkqdzDTO ormbmkqdzdto) {
        OrmBmkqdz domain = ormbmkqdzMapping.toDomain(ormbmkqdzdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmkqdzService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdtos),'ehr-OrmBmkqdz-Save')")
    @ApiOperation(value = "SaveBatchByOrmOrgOrmOrgsector", tags = {"OrmBmkqdz" },  notes = "SaveBatchByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<OrmBmkqdzDTO> ormbmkqdzdtos) {
        List<OrmBmkqdz> domainlist=ormbmkqdzMapping.toDomain(ormbmkqdzdtos);
        for(OrmBmkqdz domain:domainlist){
             domain.setOrmorgsectorid(ormorgsector_id);
        }
        ormbmkqdzService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzService.get(#ormbmkqdz_id),'ehr-OrmBmkqdz-Update')")
    @ApiOperation(value = "UpdateByOrmOrgOrmOrgsector", tags = {"OrmBmkqdz" },  notes = "UpdateByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/{ormbmkqdz_id}")
    @Transactional
    public ResponseEntity<OrmBmkqdzDTO> updateByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmkqdz_id") String ormbmkqdz_id, @RequestBody OrmBmkqdzDTO ormbmkqdzdto) {
        OrmBmkqdz domain = ormbmkqdzMapping.toDomain(ormbmkqdzdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        domain.setOrmbmkqdzid(ormbmkqdz_id);
		ormbmkqdzService.update(domain);
        OrmBmkqdzDTO dto = ormbmkqdzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzService.getOrmbmkqdzByEntities(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdtos)),'ehr-OrmBmkqdz-Update')")
    @ApiOperation(value = "UpdateBatchByOrmOrgOrmOrgsector", tags = {"OrmBmkqdz" },  notes = "UpdateBatchByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<OrmBmkqdzDTO> ormbmkqdzdtos) {
        List<OrmBmkqdz> domainlist=ormbmkqdzMapping.toDomain(ormbmkqdzdtos);
        for(OrmBmkqdz domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        ormbmkqdzService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdto),'ehr-OrmBmkqdz-Create')")
    @ApiOperation(value = "CreateByOrmOrgOrmOrgsector", tags = {"OrmBmkqdz" },  notes = "CreateByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs")
    @Transactional
    public ResponseEntity<OrmBmkqdzDTO> createByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmBmkqdzDTO ormbmkqdzdto) {
        OrmBmkqdz domain = ormbmkqdzMapping.toDomain(ormbmkqdzdto);
        domain.setOrmorgsectorid(ormorgsector_id);
		ormbmkqdzService.create(domain);
        OrmBmkqdzDTO dto = ormbmkqdzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(#ormbmkqdzdtos),'ehr-OrmBmkqdz-Create')")
    @ApiOperation(value = "createBatchByOrmOrgOrmOrgsector", tags = {"OrmBmkqdz" },  notes = "createBatchByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<OrmBmkqdzDTO> ormbmkqdzdtos) {
        List<OrmBmkqdz> domainlist=ormbmkqdzMapping.toDomain(ormbmkqdzdtos);
        for(OrmBmkqdz domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        ormbmkqdzService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormbmkqdzMapping.toDomain(returnObject.body),'ehr-OrmBmkqdz-Get')")
    @ApiOperation(value = "GetByOrmOrgOrmOrgsector", tags = {"OrmBmkqdz" },  notes = "GetByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/{ormbmkqdz_id}")
    public ResponseEntity<OrmBmkqdzDTO> getByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmkqdz_id") String ormbmkqdz_id) {
        OrmBmkqdz domain = ormbmkqdzService.get(ormbmkqdz_id);
        OrmBmkqdzDTO dto = ormbmkqdzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmBmkqdz-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByOrmOrgOrmOrgsector", tags = {"OrmBmkqdz" } ,notes = "fetchDEFAULTByOrmOrgOrmOrgsector")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/fetchdefault")
	public ResponseEntity<List<OrmBmkqdzDTO>> fetchOrmBmkqdzDefaultByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id,OrmBmkqdzSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<OrmBmkqdz> domains = ormbmkqdzService.searchDefault(context) ;
        List<OrmBmkqdzDTO> list = ormbmkqdzMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmBmkqdz-Default-all')")
	@ApiOperation(value = "searchDEFAULTByOrmOrgOrmOrgsector", tags = {"OrmBmkqdz" } ,notes = "searchDEFAULTByOrmOrgOrmOrgsector")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmkqdzs/searchdefault")
	public ResponseEntity<Page<OrmBmkqdzDTO>> searchOrmBmkqdzDefaultByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmBmkqdzSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<OrmBmkqdz> domains = ormbmkqdzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormbmkqdzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

