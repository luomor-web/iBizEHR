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
import cn.ibizlab.ehr.core.orm.domain.OrmBmgwbz;
import cn.ibizlab.ehr.core.orm.service.IOrmBmgwbzService;
import cn.ibizlab.ehr.core.orm.filter.OrmBmgwbzSearchContext;

@Slf4j
@Api(tags = {"OrmBmgwbz" })
@RestController("WebApi-ormbmgwbz")
@RequestMapping("")
public class OrmBmgwbzResource {

    @Autowired
    public IOrmBmgwbzService ormbmgwbzService;

    @Autowired
    @Lazy
    public OrmBmgwbzMapping ormbmgwbzMapping;

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdto),'ehr-OrmBmgwbz-Create')")
    @ApiOperation(value = "Create", tags = {"OrmBmgwbz" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmgwbzs")
    @Transactional
    public ResponseEntity<OrmBmgwbzDTO> create(@RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        OrmBmgwbz domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
		ormbmgwbzService.create(domain);
        OrmBmgwbzDTO dto = ormbmgwbzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos),'ehr-OrmBmgwbz-Create')")
    @ApiOperation(value = "createBatch", tags = {"OrmBmgwbz" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrmBmgwbzDTO> ormbmgwbzdtos) {
        ormbmgwbzService.createBatch(ormbmgwbzMapping.toDomain(ormbmgwbzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"OrmBmgwbz" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmgwbzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.checkKey(ormbmgwbzMapping.toDomain(ormbmgwbzdto)));
    }

    @PostAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(returnObject.body),'ehr-OrmBmgwbz-Get')")
    @ApiOperation(value = "Get", tags = {"OrmBmgwbz" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormbmgwbzs/{ormbmgwbz_id}")
    public ResponseEntity<OrmBmgwbzDTO> get(@PathVariable("ormbmgwbz_id") String ormbmgwbz_id) {
        OrmBmgwbz domain = ormbmgwbzService.get(ormbmgwbz_id);
        OrmBmgwbzDTO dto = ormbmgwbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdto),'ehr-OrmBmgwbz-Save')")
    @ApiOperation(value = "Save", tags = {"OrmBmgwbz" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmgwbzs/save")
    public ResponseEntity<Boolean> save(@RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.save(ormbmgwbzMapping.toDomain(ormbmgwbzdto)));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos),'ehr-OrmBmgwbz-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"OrmBmgwbz" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormbmgwbzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrmBmgwbzDTO> ormbmgwbzdtos) {
        ormbmgwbzService.saveBatch(ormbmgwbzMapping.toDomain(ormbmgwbzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.get(#ormbmgwbz_id),'ehr-OrmBmgwbz-Update')")
    @ApiOperation(value = "Update", tags = {"OrmBmgwbz" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormbmgwbzs/{ormbmgwbz_id}")
    @Transactional
    public ResponseEntity<OrmBmgwbzDTO> update(@PathVariable("ormbmgwbz_id") String ormbmgwbz_id, @RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
		OrmBmgwbz domain  = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain .setOrmbmgwbzid(ormbmgwbz_id);
		ormbmgwbzService.update(domain );
		OrmBmgwbzDTO dto = ormbmgwbzMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.getOrmbmgwbzByEntities(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos)),'ehr-OrmBmgwbz-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"OrmBmgwbz" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrmBmgwbzDTO> ormbmgwbzdtos) {
        ormbmgwbzService.updateBatch(ormbmgwbzMapping.toDomain(ormbmgwbzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"OrmBmgwbz" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormbmgwbzs/getdraft")
    public ResponseEntity<OrmBmgwbzDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzMapping.toDto(ormbmgwbzService.getDraft(new OrmBmgwbz())));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.get(#ormbmgwbz_id),'ehr-OrmBmgwbz-Remove')")
    @ApiOperation(value = "Remove", tags = {"OrmBmgwbz" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormbmgwbzs/{ormbmgwbz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormbmgwbz_id") String ormbmgwbz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.remove(ormbmgwbz_id));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.getOrmbmgwbzByIds(#ids),'ehr-OrmBmgwbz-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"OrmBmgwbz" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormbmgwbzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmBmgwbz-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"OrmBmgwbz" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormbmgwbzs/fetchdefault")
	public ResponseEntity<List<OrmBmgwbzDTO>> fetchDefault(OrmBmgwbzSearchContext context) {
        Page<OrmBmgwbz> domains = ormbmgwbzService.searchDefault(context) ;
        List<OrmBmgwbzDTO> list = ormbmgwbzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmBmgwbz-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"OrmBmgwbz" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormbmgwbzs/searchdefault")
	public ResponseEntity<Page<OrmBmgwbzDTO>> searchDefault(@RequestBody OrmBmgwbzSearchContext context) {
        Page<OrmBmgwbz> domains = ormbmgwbzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormbmgwbzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdto),'ehr-OrmBmgwbz-Create')")
    @ApiOperation(value = "CreateByOrmOrgsector", tags = {"OrmBmgwbz" },  notes = "CreateByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs")
    @Transactional
    public ResponseEntity<OrmBmgwbzDTO> createByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        OrmBmgwbz domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmgwbzid(ormorgsector_id);
		ormbmgwbzService.create(domain);
        OrmBmgwbzDTO dto = ormbmgwbzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos),'ehr-OrmBmgwbz-Create')")
    @ApiOperation(value = "createBatchByOrmOrgsector", tags = {"OrmBmgwbz" },  notes = "createBatchByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<OrmBmgwbzDTO> ormbmgwbzdtos) {
        List<OrmBmgwbz> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(OrmBmgwbz domain:domainlist){
            domain.setOrmgwbzid(ormorgsector_id);
        }
        ormbmgwbzService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByOrmOrgsector", tags = {"OrmBmgwbz" },  notes = "CheckKeyByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.checkKey(ormbmgwbzMapping.toDomain(ormbmgwbzdto)));
    }

    @PostAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(returnObject.body),'ehr-OrmBmgwbz-Get')")
    @ApiOperation(value = "GetByOrmOrgsector", tags = {"OrmBmgwbz" },  notes = "GetByOrmOrgsector")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/{ormbmgwbz_id}")
    public ResponseEntity<OrmBmgwbzDTO> getByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id) {
        OrmBmgwbz domain = ormbmgwbzService.get(ormbmgwbz_id);
        OrmBmgwbzDTO dto = ormbmgwbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdto),'ehr-OrmBmgwbz-Save')")
    @ApiOperation(value = "SaveByOrmOrgsector", tags = {"OrmBmgwbz" },  notes = "SaveByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/save")
    public ResponseEntity<Boolean> saveByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        OrmBmgwbz domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmgwbzid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos),'ehr-OrmBmgwbz-Save')")
    @ApiOperation(value = "SaveBatchByOrmOrgsector", tags = {"OrmBmgwbz" },  notes = "SaveBatchByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<OrmBmgwbzDTO> ormbmgwbzdtos) {
        List<OrmBmgwbz> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(OrmBmgwbz domain:domainlist){
             domain.setOrmgwbzid(ormorgsector_id);
        }
        ormbmgwbzService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.get(#ormbmgwbz_id),'ehr-OrmBmgwbz-Update')")
    @ApiOperation(value = "UpdateByOrmOrgsector", tags = {"OrmBmgwbz" },  notes = "UpdateByOrmOrgsector")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/{ormbmgwbz_id}")
    @Transactional
    public ResponseEntity<OrmBmgwbzDTO> updateByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id, @RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        OrmBmgwbz domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmgwbzid(ormorgsector_id);
        domain.setOrmbmgwbzid(ormbmgwbz_id);
		ormbmgwbzService.update(domain);
        OrmBmgwbzDTO dto = ormbmgwbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.getOrmbmgwbzByEntities(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos)),'ehr-OrmBmgwbz-Update')")
    @ApiOperation(value = "UpdateBatchByOrmOrgsector", tags = {"OrmBmgwbz" },  notes = "UpdateBatchByOrmOrgsector")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<OrmBmgwbzDTO> ormbmgwbzdtos) {
        List<OrmBmgwbz> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(OrmBmgwbz domain:domainlist){
            domain.setOrmgwbzid(ormorgsector_id);
        }
        ormbmgwbzService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByOrmOrgsector", tags = {"OrmBmgwbz" },  notes = "GetDraftByOrmOrgsector")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/getdraft")
    public ResponseEntity<OrmBmgwbzDTO> getDraftByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id) {
        OrmBmgwbz domain = new OrmBmgwbz();
        domain.setOrmgwbzid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzMapping.toDto(ormbmgwbzService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.get(#ormbmgwbz_id),'ehr-OrmBmgwbz-Remove')")
    @ApiOperation(value = "RemoveByOrmOrgsector", tags = {"OrmBmgwbz" },  notes = "RemoveByOrmOrgsector")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/{ormbmgwbz_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.remove(ormbmgwbz_id));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.getOrmbmgwbzByIds(#ids),'ehr-OrmBmgwbz-Remove')")
    @ApiOperation(value = "RemoveBatchByOrmOrgsector", tags = {"OrmBmgwbz" },  notes = "RemoveBatchByOrmOrgsector")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgsector(@RequestBody List<String> ids) {
        ormbmgwbzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmBmgwbz-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByOrmOrgsector", tags = {"OrmBmgwbz" } ,notes = "fetchDEFAULTByOrmOrgsector")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/fetchdefault")
	public ResponseEntity<List<OrmBmgwbzDTO>> fetchOrmBmgwbzDefaultByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id,OrmBmgwbzSearchContext context) {
        context.setN_ormgwbzid_eq(ormorgsector_id);
        Page<OrmBmgwbz> domains = ormbmgwbzService.searchDefault(context) ;
        List<OrmBmgwbzDTO> list = ormbmgwbzMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmBmgwbz-Default-all')")
	@ApiOperation(value = "searchDEFAULTByOrmOrgsector", tags = {"OrmBmgwbz" } ,notes = "searchDEFAULTByOrmOrgsector")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/searchdefault")
	public ResponseEntity<Page<OrmBmgwbzDTO>> searchOrmBmgwbzDefaultByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmBmgwbzSearchContext context) {
        context.setN_ormgwbzid_eq(ormorgsector_id);
        Page<OrmBmgwbz> domains = ormbmgwbzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormbmgwbzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdto),'ehr-OrmBmgwbz-Create')")
    @ApiOperation(value = "CreateByOrmPost", tags = {"OrmBmgwbz" },  notes = "CreateByOrmPost")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/ormbmgwbzs")
    @Transactional
    public ResponseEntity<OrmBmgwbzDTO> createByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        OrmBmgwbz domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmpostid(ormpost_id);
		ormbmgwbzService.create(domain);
        OrmBmgwbzDTO dto = ormbmgwbzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos),'ehr-OrmBmgwbz-Create')")
    @ApiOperation(value = "createBatchByOrmPost", tags = {"OrmBmgwbz" },  notes = "createBatchByOrmPost")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> createBatchByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @RequestBody List<OrmBmgwbzDTO> ormbmgwbzdtos) {
        List<OrmBmgwbz> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(OrmBmgwbz domain:domainlist){
            domain.setOrmpostid(ormpost_id);
        }
        ormbmgwbzService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByOrmPost", tags = {"OrmBmgwbz" },  notes = "CheckKeyByOrmPost")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/ormbmgwbzs/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.checkKey(ormbmgwbzMapping.toDomain(ormbmgwbzdto)));
    }

    @PostAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(returnObject.body),'ehr-OrmBmgwbz-Get')")
    @ApiOperation(value = "GetByOrmPost", tags = {"OrmBmgwbz" },  notes = "GetByOrmPost")
	@RequestMapping(method = RequestMethod.GET, value = "/ormposts/{ormpost_id}/ormbmgwbzs/{ormbmgwbz_id}")
    public ResponseEntity<OrmBmgwbzDTO> getByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id) {
        OrmBmgwbz domain = ormbmgwbzService.get(ormbmgwbz_id);
        OrmBmgwbzDTO dto = ormbmgwbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdto),'ehr-OrmBmgwbz-Save')")
    @ApiOperation(value = "SaveByOrmPost", tags = {"OrmBmgwbz" },  notes = "SaveByOrmPost")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/ormbmgwbzs/save")
    public ResponseEntity<Boolean> saveByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        OrmBmgwbz domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmpostid(ormpost_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos),'ehr-OrmBmgwbz-Save')")
    @ApiOperation(value = "SaveBatchByOrmPost", tags = {"OrmBmgwbz" },  notes = "SaveBatchByOrmPost")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/ormbmgwbzs/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @RequestBody List<OrmBmgwbzDTO> ormbmgwbzdtos) {
        List<OrmBmgwbz> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(OrmBmgwbz domain:domainlist){
             domain.setOrmpostid(ormpost_id);
        }
        ormbmgwbzService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.get(#ormbmgwbz_id),'ehr-OrmBmgwbz-Update')")
    @ApiOperation(value = "UpdateByOrmPost", tags = {"OrmBmgwbz" },  notes = "UpdateByOrmPost")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormposts/{ormpost_id}/ormbmgwbzs/{ormbmgwbz_id}")
    @Transactional
    public ResponseEntity<OrmBmgwbzDTO> updateByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id, @RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        OrmBmgwbz domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmpostid(ormpost_id);
        domain.setOrmbmgwbzid(ormbmgwbz_id);
		ormbmgwbzService.update(domain);
        OrmBmgwbzDTO dto = ormbmgwbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.getOrmbmgwbzByEntities(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos)),'ehr-OrmBmgwbz-Update')")
    @ApiOperation(value = "UpdateBatchByOrmPost", tags = {"OrmBmgwbz" },  notes = "UpdateBatchByOrmPost")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormposts/{ormpost_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> updateBatchByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @RequestBody List<OrmBmgwbzDTO> ormbmgwbzdtos) {
        List<OrmBmgwbz> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(OrmBmgwbz domain:domainlist){
            domain.setOrmpostid(ormpost_id);
        }
        ormbmgwbzService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByOrmPost", tags = {"OrmBmgwbz" },  notes = "GetDraftByOrmPost")
    @RequestMapping(method = RequestMethod.GET, value = "/ormposts/{ormpost_id}/ormbmgwbzs/getdraft")
    public ResponseEntity<OrmBmgwbzDTO> getDraftByOrmPost(@PathVariable("ormpost_id") String ormpost_id) {
        OrmBmgwbz domain = new OrmBmgwbz();
        domain.setOrmpostid(ormpost_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzMapping.toDto(ormbmgwbzService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.get(#ormbmgwbz_id),'ehr-OrmBmgwbz-Remove')")
    @ApiOperation(value = "RemoveByOrmPost", tags = {"OrmBmgwbz" },  notes = "RemoveByOrmPost")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormposts/{ormpost_id}/ormbmgwbzs/{ormbmgwbz_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.remove(ormbmgwbz_id));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.getOrmbmgwbzByIds(#ids),'ehr-OrmBmgwbz-Remove')")
    @ApiOperation(value = "RemoveBatchByOrmPost", tags = {"OrmBmgwbz" },  notes = "RemoveBatchByOrmPost")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormposts/{ormpost_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> removeBatchByOrmPost(@RequestBody List<String> ids) {
        ormbmgwbzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmBmgwbz-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByOrmPost", tags = {"OrmBmgwbz" } ,notes = "fetchDEFAULTByOrmPost")
    @RequestMapping(method= RequestMethod.GET , value="/ormposts/{ormpost_id}/ormbmgwbzs/fetchdefault")
	public ResponseEntity<List<OrmBmgwbzDTO>> fetchOrmBmgwbzDefaultByOrmPost(@PathVariable("ormpost_id") String ormpost_id,OrmBmgwbzSearchContext context) {
        context.setN_ormpostid_eq(ormpost_id);
        Page<OrmBmgwbz> domains = ormbmgwbzService.searchDefault(context) ;
        List<OrmBmgwbzDTO> list = ormbmgwbzMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmBmgwbz-Default-all')")
	@ApiOperation(value = "searchDEFAULTByOrmPost", tags = {"OrmBmgwbz" } ,notes = "searchDEFAULTByOrmPost")
    @RequestMapping(method= RequestMethod.POST , value="/ormposts/{ormpost_id}/ormbmgwbzs/searchdefault")
	public ResponseEntity<Page<OrmBmgwbzDTO>> searchOrmBmgwbzDefaultByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @RequestBody OrmBmgwbzSearchContext context) {
        context.setN_ormpostid_eq(ormpost_id);
        Page<OrmBmgwbz> domains = ormbmgwbzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormbmgwbzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdto),'ehr-OrmBmgwbz-Create')")
    @ApiOperation(value = "CreateByOrmOrgOrmOrgsector", tags = {"OrmBmgwbz" },  notes = "CreateByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs")
    @Transactional
    public ResponseEntity<OrmBmgwbzDTO> createByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        OrmBmgwbz domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmgwbzid(ormorgsector_id);
		ormbmgwbzService.create(domain);
        OrmBmgwbzDTO dto = ormbmgwbzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos),'ehr-OrmBmgwbz-Create')")
    @ApiOperation(value = "createBatchByOrmOrgOrmOrgsector", tags = {"OrmBmgwbz" },  notes = "createBatchByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<OrmBmgwbzDTO> ormbmgwbzdtos) {
        List<OrmBmgwbz> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(OrmBmgwbz domain:domainlist){
            domain.setOrmgwbzid(ormorgsector_id);
        }
        ormbmgwbzService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByOrmOrgOrmOrgsector", tags = {"OrmBmgwbz" },  notes = "CheckKeyByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.checkKey(ormbmgwbzMapping.toDomain(ormbmgwbzdto)));
    }

    @PostAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(returnObject.body),'ehr-OrmBmgwbz-Get')")
    @ApiOperation(value = "GetByOrmOrgOrmOrgsector", tags = {"OrmBmgwbz" },  notes = "GetByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/{ormbmgwbz_id}")
    public ResponseEntity<OrmBmgwbzDTO> getByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id) {
        OrmBmgwbz domain = ormbmgwbzService.get(ormbmgwbz_id);
        OrmBmgwbzDTO dto = ormbmgwbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdto),'ehr-OrmBmgwbz-Save')")
    @ApiOperation(value = "SaveByOrmOrgOrmOrgsector", tags = {"OrmBmgwbz" },  notes = "SaveByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/save")
    public ResponseEntity<Boolean> saveByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        OrmBmgwbz domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmgwbzid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos),'ehr-OrmBmgwbz-Save')")
    @ApiOperation(value = "SaveBatchByOrmOrgOrmOrgsector", tags = {"OrmBmgwbz" },  notes = "SaveBatchByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<OrmBmgwbzDTO> ormbmgwbzdtos) {
        List<OrmBmgwbz> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(OrmBmgwbz domain:domainlist){
             domain.setOrmgwbzid(ormorgsector_id);
        }
        ormbmgwbzService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.get(#ormbmgwbz_id),'ehr-OrmBmgwbz-Update')")
    @ApiOperation(value = "UpdateByOrmOrgOrmOrgsector", tags = {"OrmBmgwbz" },  notes = "UpdateByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/{ormbmgwbz_id}")
    @Transactional
    public ResponseEntity<OrmBmgwbzDTO> updateByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id, @RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        OrmBmgwbz domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmgwbzid(ormorgsector_id);
        domain.setOrmbmgwbzid(ormbmgwbz_id);
		ormbmgwbzService.update(domain);
        OrmBmgwbzDTO dto = ormbmgwbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.getOrmbmgwbzByEntities(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos)),'ehr-OrmBmgwbz-Update')")
    @ApiOperation(value = "UpdateBatchByOrmOrgOrmOrgsector", tags = {"OrmBmgwbz" },  notes = "UpdateBatchByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<OrmBmgwbzDTO> ormbmgwbzdtos) {
        List<OrmBmgwbz> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(OrmBmgwbz domain:domainlist){
            domain.setOrmgwbzid(ormorgsector_id);
        }
        ormbmgwbzService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByOrmOrgOrmOrgsector", tags = {"OrmBmgwbz" },  notes = "GetDraftByOrmOrgOrmOrgsector")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/getdraft")
    public ResponseEntity<OrmBmgwbzDTO> getDraftByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id) {
        OrmBmgwbz domain = new OrmBmgwbz();
        domain.setOrmgwbzid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzMapping.toDto(ormbmgwbzService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.get(#ormbmgwbz_id),'ehr-OrmBmgwbz-Remove')")
    @ApiOperation(value = "RemoveByOrmOrgOrmOrgsector", tags = {"OrmBmgwbz" },  notes = "RemoveByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/{ormbmgwbz_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.remove(ormbmgwbz_id));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.getOrmbmgwbzByIds(#ids),'ehr-OrmBmgwbz-Remove')")
    @ApiOperation(value = "RemoveBatchByOrmOrgOrmOrgsector", tags = {"OrmBmgwbz" },  notes = "RemoveBatchByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgOrmOrgsector(@RequestBody List<String> ids) {
        ormbmgwbzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmBmgwbz-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByOrmOrgOrmOrgsector", tags = {"OrmBmgwbz" } ,notes = "fetchDEFAULTByOrmOrgOrmOrgsector")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/fetchdefault")
	public ResponseEntity<List<OrmBmgwbzDTO>> fetchOrmBmgwbzDefaultByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id,OrmBmgwbzSearchContext context) {
        context.setN_ormgwbzid_eq(ormorgsector_id);
        Page<OrmBmgwbz> domains = ormbmgwbzService.searchDefault(context) ;
        List<OrmBmgwbzDTO> list = ormbmgwbzMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmBmgwbz-Default-all')")
	@ApiOperation(value = "searchDEFAULTByOrmOrgOrmOrgsector", tags = {"OrmBmgwbz" } ,notes = "searchDEFAULTByOrmOrgOrmOrgsector")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormbmgwbzs/searchdefault")
	public ResponseEntity<Page<OrmBmgwbzDTO>> searchOrmBmgwbzDefaultByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmBmgwbzSearchContext context) {
        context.setN_ormgwbzid_eq(ormorgsector_id);
        Page<OrmBmgwbz> domains = ormbmgwbzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormbmgwbzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdto),'ehr-OrmBmgwbz-Create')")
    @ApiOperation(value = "CreateByOrmOrgOrmPost", tags = {"OrmBmgwbz" },  notes = "CreateByOrmOrgOrmPost")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormbmgwbzs")
    @Transactional
    public ResponseEntity<OrmBmgwbzDTO> createByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        OrmBmgwbz domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmpostid(ormpost_id);
		ormbmgwbzService.create(domain);
        OrmBmgwbzDTO dto = ormbmgwbzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos),'ehr-OrmBmgwbz-Create')")
    @ApiOperation(value = "createBatchByOrmOrgOrmPost", tags = {"OrmBmgwbz" },  notes = "createBatchByOrmOrgOrmPost")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody List<OrmBmgwbzDTO> ormbmgwbzdtos) {
        List<OrmBmgwbz> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(OrmBmgwbz domain:domainlist){
            domain.setOrmpostid(ormpost_id);
        }
        ormbmgwbzService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByOrmOrgOrmPost", tags = {"OrmBmgwbz" },  notes = "CheckKeyByOrmOrgOrmPost")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormbmgwbzs/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.checkKey(ormbmgwbzMapping.toDomain(ormbmgwbzdto)));
    }

    @PostAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(returnObject.body),'ehr-OrmBmgwbz-Get')")
    @ApiOperation(value = "GetByOrmOrgOrmPost", tags = {"OrmBmgwbz" },  notes = "GetByOrmOrgOrmPost")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormbmgwbzs/{ormbmgwbz_id}")
    public ResponseEntity<OrmBmgwbzDTO> getByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id) {
        OrmBmgwbz domain = ormbmgwbzService.get(ormbmgwbz_id);
        OrmBmgwbzDTO dto = ormbmgwbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdto),'ehr-OrmBmgwbz-Save')")
    @ApiOperation(value = "SaveByOrmOrgOrmPost", tags = {"OrmBmgwbz" },  notes = "SaveByOrmOrgOrmPost")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormbmgwbzs/save")
    public ResponseEntity<Boolean> saveByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        OrmBmgwbz domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmpostid(ormpost_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos),'ehr-OrmBmgwbz-Save')")
    @ApiOperation(value = "SaveBatchByOrmOrgOrmPost", tags = {"OrmBmgwbz" },  notes = "SaveBatchByOrmOrgOrmPost")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormbmgwbzs/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody List<OrmBmgwbzDTO> ormbmgwbzdtos) {
        List<OrmBmgwbz> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(OrmBmgwbz domain:domainlist){
             domain.setOrmpostid(ormpost_id);
        }
        ormbmgwbzService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.get(#ormbmgwbz_id),'ehr-OrmBmgwbz-Update')")
    @ApiOperation(value = "UpdateByOrmOrgOrmPost", tags = {"OrmBmgwbz" },  notes = "UpdateByOrmOrgOrmPost")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormbmgwbzs/{ormbmgwbz_id}")
    @Transactional
    public ResponseEntity<OrmBmgwbzDTO> updateByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id, @RequestBody OrmBmgwbzDTO ormbmgwbzdto) {
        OrmBmgwbz domain = ormbmgwbzMapping.toDomain(ormbmgwbzdto);
        domain.setOrmpostid(ormpost_id);
        domain.setOrmbmgwbzid(ormbmgwbz_id);
		ormbmgwbzService.update(domain);
        OrmBmgwbzDTO dto = ormbmgwbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.getOrmbmgwbzByEntities(this.ormbmgwbzMapping.toDomain(#ormbmgwbzdtos)),'ehr-OrmBmgwbz-Update')")
    @ApiOperation(value = "UpdateBatchByOrmOrgOrmPost", tags = {"OrmBmgwbz" },  notes = "UpdateBatchByOrmOrgOrmPost")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody List<OrmBmgwbzDTO> ormbmgwbzdtos) {
        List<OrmBmgwbz> domainlist=ormbmgwbzMapping.toDomain(ormbmgwbzdtos);
        for(OrmBmgwbz domain:domainlist){
            domain.setOrmpostid(ormpost_id);
        }
        ormbmgwbzService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByOrmOrgOrmPost", tags = {"OrmBmgwbz" },  notes = "GetDraftByOrmOrgOrmPost")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormbmgwbzs/getdraft")
    public ResponseEntity<OrmBmgwbzDTO> getDraftByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id) {
        OrmBmgwbz domain = new OrmBmgwbz();
        domain.setOrmpostid(ormpost_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzMapping.toDto(ormbmgwbzService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.get(#ormbmgwbz_id),'ehr-OrmBmgwbz-Remove')")
    @ApiOperation(value = "RemoveByOrmOrgOrmPost", tags = {"OrmBmgwbz" },  notes = "RemoveByOrmOrgOrmPost")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormbmgwbzs/{ormbmgwbz_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @PathVariable("ormbmgwbz_id") String ormbmgwbz_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormbmgwbzService.remove(ormbmgwbz_id));
    }

    @PreAuthorize("hasPermission(this.ormbmgwbzService.getOrmbmgwbzByIds(#ids),'ehr-OrmBmgwbz-Remove')")
    @ApiOperation(value = "RemoveBatchByOrmOrgOrmPost", tags = {"OrmBmgwbz" },  notes = "RemoveBatchByOrmOrgOrmPost")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormbmgwbzs/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgOrmPost(@RequestBody List<String> ids) {
        ormbmgwbzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmBmgwbz-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByOrmOrgOrmPost", tags = {"OrmBmgwbz" } ,notes = "fetchDEFAULTByOrmOrgOrmPost")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormbmgwbzs/fetchdefault")
	public ResponseEntity<List<OrmBmgwbzDTO>> fetchOrmBmgwbzDefaultByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id,OrmBmgwbzSearchContext context) {
        context.setN_ormpostid_eq(ormpost_id);
        Page<OrmBmgwbz> domains = ormbmgwbzService.searchDefault(context) ;
        List<OrmBmgwbzDTO> list = ormbmgwbzMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmBmgwbz-Default-all')")
	@ApiOperation(value = "searchDEFAULTByOrmOrgOrmPost", tags = {"OrmBmgwbz" } ,notes = "searchDEFAULTByOrmOrgOrmPost")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormbmgwbzs/searchdefault")
	public ResponseEntity<Page<OrmBmgwbzDTO>> searchOrmBmgwbzDefaultByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody OrmBmgwbzSearchContext context) {
        context.setN_ormpostid_eq(ormpost_id);
        Page<OrmBmgwbz> domains = ormbmgwbzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormbmgwbzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

