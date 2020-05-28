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
import cn.ibizlab.ehr.core.orm.domain.OrmOrgdz;
import cn.ibizlab.ehr.core.orm.service.IOrmOrgdzService;
import cn.ibizlab.ehr.core.orm.filter.OrmOrgdzSearchContext;

@Slf4j
@Api(tags = {"OrmOrgdz" })
@RestController("WebApi-ormorgdz")
@RequestMapping("")
public class OrmOrgdzResource {

    @Autowired
    public IOrmOrgdzService ormorgdzService;

    @Autowired
    @Lazy
    public OrmOrgdzMapping ormorgdzMapping;

    @PostAuthorize("hasPermission(this.ormorgdzMapping.toDomain(returnObject.body),'ehr-OrmOrgdz-Get')")
    @ApiOperation(value = "Get", tags = {"OrmOrgdz" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgdzs/{ormorgdz_id}")
    public ResponseEntity<OrmOrgdzDTO> get(@PathVariable("ormorgdz_id") String ormorgdz_id) {
        OrmOrgdz domain = ormorgdzService.get(ormorgdz_id);
        OrmOrgdzDTO dto = ormorgdzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "GetDraft", tags = {"OrmOrgdz" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgdzs/getdraft")
    public ResponseEntity<OrmOrgdzDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormorgdzMapping.toDto(ormorgdzService.getDraft(new OrmOrgdz())));
    }

    @PreAuthorize("hasPermission(this.ormorgdzService.get(#ormorgdz_id),'ehr-OrmOrgdz-Remove')")
    @ApiOperation(value = "Remove", tags = {"OrmOrgdz" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgdzs/{ormorgdz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormorgdz_id") String ormorgdz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormorgdzService.remove(ormorgdz_id));
    }

    @PreAuthorize("hasPermission(this.ormorgdzService.getOrmorgdzByIds(#ids),'ehr-OrmOrgdz-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"OrmOrgdz" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgdzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormorgdzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormorgdzMapping.toDomain(#ormorgdzdto),'ehr-OrmOrgdz-Save')")
    @ApiOperation(value = "Save", tags = {"OrmOrgdz" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgdzs/save")
    public ResponseEntity<Boolean> save(@RequestBody OrmOrgdzDTO ormorgdzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormorgdzService.save(ormorgdzMapping.toDomain(ormorgdzdto)));
    }

    @PreAuthorize("hasPermission(this.ormorgdzMapping.toDomain(#ormorgdzdtos),'ehr-OrmOrgdz-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"OrmOrgdz" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgdzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrmOrgdzDTO> ormorgdzdtos) {
        ormorgdzService.saveBatch(ormorgdzMapping.toDomain(ormorgdzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormorgdzMapping.toDomain(#ormorgdzdto),'ehr-OrmOrgdz-Create')")
    @ApiOperation(value = "Create", tags = {"OrmOrgdz" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgdzs")
    @Transactional
    public ResponseEntity<OrmOrgdzDTO> create(@RequestBody OrmOrgdzDTO ormorgdzdto) {
        OrmOrgdz domain = ormorgdzMapping.toDomain(ormorgdzdto);
		ormorgdzService.create(domain);
        OrmOrgdzDTO dto = ormorgdzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormorgdzMapping.toDomain(#ormorgdzdtos),'ehr-OrmOrgdz-Create')")
    @ApiOperation(value = "createBatch", tags = {"OrmOrgdz" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgdzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrmOrgdzDTO> ormorgdzdtos) {
        ormorgdzService.createBatch(ormorgdzMapping.toDomain(ormorgdzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormorgdzService.get(#ormorgdz_id),'ehr-OrmOrgdz-Update')")
    @ApiOperation(value = "Update", tags = {"OrmOrgdz" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgdzs/{ormorgdz_id}")
    @Transactional
    public ResponseEntity<OrmOrgdzDTO> update(@PathVariable("ormorgdz_id") String ormorgdz_id, @RequestBody OrmOrgdzDTO ormorgdzdto) {
		OrmOrgdz domain  = ormorgdzMapping.toDomain(ormorgdzdto);
        domain .setOrmorgdzid(ormorgdz_id);
		ormorgdzService.update(domain );
		OrmOrgdzDTO dto = ormorgdzMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormorgdzService.getOrmorgdzByEntities(this.ormorgdzMapping.toDomain(#ormorgdzdtos)),'ehr-OrmOrgdz-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"OrmOrgdz" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgdzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrmOrgdzDTO> ormorgdzdtos) {
        ormorgdzService.updateBatch(ormorgdzMapping.toDomain(ormorgdzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"OrmOrgdz" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgdzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrmOrgdzDTO ormorgdzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormorgdzService.checkKey(ormorgdzMapping.toDomain(ormorgdzdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgdz-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"OrmOrgdz" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgdzs/fetchdefault")
	public ResponseEntity<List<OrmOrgdzDTO>> fetchDefault(OrmOrgdzSearchContext context) {
        Page<OrmOrgdz> domains = ormorgdzService.searchDefault(context) ;
        List<OrmOrgdzDTO> list = ormorgdzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgdz-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"OrmOrgdz" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgdzs/searchdefault")
	public ResponseEntity<Page<OrmOrgdzDTO>> searchDefault(@RequestBody OrmOrgdzSearchContext context) {
        Page<OrmOrgdz> domains = ormorgdzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgdzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.ormorgdzMapping.toDomain(returnObject.body),'ehr-OrmOrgdz-Get')")
    @ApiOperation(value = "GetByOrmOrg", tags = {"OrmOrgdz" },  notes = "GetByOrmOrg")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgdzs/{ormorgdz_id}")
    public ResponseEntity<OrmOrgdzDTO> getByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgdz_id") String ormorgdz_id) {
        OrmOrgdz domain = ormorgdzService.get(ormorgdz_id);
        OrmOrgdzDTO dto = ormorgdzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "GetDraftByOrmOrg", tags = {"OrmOrgdz" },  notes = "GetDraftByOrmOrg")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgdzs/getdraft")
    public ResponseEntity<OrmOrgdzDTO> getDraftByOrmOrg(@PathVariable("ormorg_id") String ormorg_id) {
        OrmOrgdz domain = new OrmOrgdz();
        domain.setOrmorgid(ormorg_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormorgdzMapping.toDto(ormorgdzService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.ormorgdzService.get(#ormorgdz_id),'ehr-OrmOrgdz-Remove')")
    @ApiOperation(value = "RemoveByOrmOrg", tags = {"OrmOrgdz" },  notes = "RemoveByOrmOrg")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgdzs/{ormorgdz_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgdz_id") String ormorgdz_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormorgdzService.remove(ormorgdz_id));
    }

    @PreAuthorize("hasPermission(this.ormorgdzService.getOrmorgdzByIds(#ids),'ehr-OrmOrgdz-Remove')")
    @ApiOperation(value = "RemoveBatchByOrmOrg", tags = {"OrmOrgdz" },  notes = "RemoveBatchByOrmOrg")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgdzs/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrg(@RequestBody List<String> ids) {
        ormorgdzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormorgdzMapping.toDomain(#ormorgdzdto),'ehr-OrmOrgdz-Save')")
    @ApiOperation(value = "SaveByOrmOrg", tags = {"OrmOrgdz" },  notes = "SaveByOrmOrg")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgdzs/save")
    public ResponseEntity<Boolean> saveByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmOrgdzDTO ormorgdzdto) {
        OrmOrgdz domain = ormorgdzMapping.toDomain(ormorgdzdto);
        domain.setOrmorgid(ormorg_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormorgdzService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormorgdzMapping.toDomain(#ormorgdzdtos),'ehr-OrmOrgdz-Save')")
    @ApiOperation(value = "SaveBatchByOrmOrg", tags = {"OrmOrgdz" },  notes = "SaveBatchByOrmOrg")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgdzs/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody List<OrmOrgdzDTO> ormorgdzdtos) {
        List<OrmOrgdz> domainlist=ormorgdzMapping.toDomain(ormorgdzdtos);
        for(OrmOrgdz domain:domainlist){
             domain.setOrmorgid(ormorg_id);
        }
        ormorgdzService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormorgdzMapping.toDomain(#ormorgdzdto),'ehr-OrmOrgdz-Create')")
    @ApiOperation(value = "CreateByOrmOrg", tags = {"OrmOrgdz" },  notes = "CreateByOrmOrg")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgdzs")
    @Transactional
    public ResponseEntity<OrmOrgdzDTO> createByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmOrgdzDTO ormorgdzdto) {
        OrmOrgdz domain = ormorgdzMapping.toDomain(ormorgdzdto);
        domain.setOrmorgid(ormorg_id);
		ormorgdzService.create(domain);
        OrmOrgdzDTO dto = ormorgdzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormorgdzMapping.toDomain(#ormorgdzdtos),'ehr-OrmOrgdz-Create')")
    @ApiOperation(value = "createBatchByOrmOrg", tags = {"OrmOrgdz" },  notes = "createBatchByOrmOrg")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgdzs/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody List<OrmOrgdzDTO> ormorgdzdtos) {
        List<OrmOrgdz> domainlist=ormorgdzMapping.toDomain(ormorgdzdtos);
        for(OrmOrgdz domain:domainlist){
            domain.setOrmorgid(ormorg_id);
        }
        ormorgdzService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormorgdzService.get(#ormorgdz_id),'ehr-OrmOrgdz-Update')")
    @ApiOperation(value = "UpdateByOrmOrg", tags = {"OrmOrgdz" },  notes = "UpdateByOrmOrg")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgdzs/{ormorgdz_id}")
    @Transactional
    public ResponseEntity<OrmOrgdzDTO> updateByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgdz_id") String ormorgdz_id, @RequestBody OrmOrgdzDTO ormorgdzdto) {
        OrmOrgdz domain = ormorgdzMapping.toDomain(ormorgdzdto);
        domain.setOrmorgid(ormorg_id);
        domain.setOrmorgdzid(ormorgdz_id);
		ormorgdzService.update(domain);
        OrmOrgdzDTO dto = ormorgdzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormorgdzService.getOrmorgdzByEntities(this.ormorgdzMapping.toDomain(#ormorgdzdtos)),'ehr-OrmOrgdz-Update')")
    @ApiOperation(value = "UpdateBatchByOrmOrg", tags = {"OrmOrgdz" },  notes = "UpdateBatchByOrmOrg")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgdzs/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody List<OrmOrgdzDTO> ormorgdzdtos) {
        List<OrmOrgdz> domainlist=ormorgdzMapping.toDomain(ormorgdzdtos);
        for(OrmOrgdz domain:domainlist){
            domain.setOrmorgid(ormorg_id);
        }
        ormorgdzService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByOrmOrg", tags = {"OrmOrgdz" },  notes = "CheckKeyByOrmOrg")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgdzs/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmOrgdzDTO ormorgdzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormorgdzService.checkKey(ormorgdzMapping.toDomain(ormorgdzdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgdz-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByOrmOrg", tags = {"OrmOrgdz" } ,notes = "fetchDEFAULTByOrmOrg")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgdzs/fetchdefault")
	public ResponseEntity<List<OrmOrgdzDTO>> fetchOrmOrgdzDefaultByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,OrmOrgdzSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<OrmOrgdz> domains = ormorgdzService.searchDefault(context) ;
        List<OrmOrgdzDTO> list = ormorgdzMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgdz-Default-all')")
	@ApiOperation(value = "searchDEFAULTByOrmOrg", tags = {"OrmOrgdz" } ,notes = "searchDEFAULTByOrmOrg")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgdzs/searchdefault")
	public ResponseEntity<Page<OrmOrgdzDTO>> searchOrmOrgdzDefaultByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmOrgdzSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<OrmOrgdz> domains = ormorgdzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgdzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

