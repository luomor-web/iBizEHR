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
import cn.ibizlab.ehr.core.orm.domain.OrmDepEstMan;
import cn.ibizlab.ehr.core.orm.service.IOrmDepEstManService;
import cn.ibizlab.ehr.core.orm.filter.OrmDepEstManSearchContext;

@Slf4j
@Api(tags = {"OrmDepEstMan" })
@RestController("WebApi-ormdepestman")
@RequestMapping("")
public class OrmDepEstManResource {

    @Autowired
    public IOrmDepEstManService ormdepestmanService;

    @Autowired
    @Lazy
    public OrmDepEstManMapping ormdepestmanMapping;

    @ApiOperation(value = "GetDraft", tags = {"OrmDepEstMan" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormdepestmen/getdraft")
    public ResponseEntity<OrmDepEstManDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanMapping.toDto(ormdepestmanService.getDraft(new OrmDepEstMan())));
    }

    @ApiOperation(value = "CheckKey", tags = {"OrmDepEstMan" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormdepestmen/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrmDepEstManDTO ormdepestmandto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.checkKey(ormdepestmanMapping.toDomain(ormdepestmandto)));
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandto),'ehr-OrmDepEstMan-Create')")
    @ApiOperation(value = "Create", tags = {"OrmDepEstMan" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormdepestmen")
    @Transactional
    public ResponseEntity<OrmDepEstManDTO> create(@RequestBody OrmDepEstManDTO ormdepestmandto) {
        OrmDepEstMan domain = ormdepestmanMapping.toDomain(ormdepestmandto);
		ormdepestmanService.create(domain);
        OrmDepEstManDTO dto = ormdepestmanMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandtos),'ehr-OrmDepEstMan-Create')")
    @ApiOperation(value = "createBatch", tags = {"OrmDepEstMan" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormdepestmen/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrmDepEstManDTO> ormdepestmandtos) {
        ormdepestmanService.createBatch(ormdepestmanMapping.toDomain(ormdepestmandtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(returnObject.body),'ehr-OrmDepEstMan-Get')")
    @ApiOperation(value = "Get", tags = {"OrmDepEstMan" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormdepestmen/{ormdepestman_id}")
    public ResponseEntity<OrmDepEstManDTO> get(@PathVariable("ormdepestman_id") String ormdepestman_id) {
        OrmDepEstMan domain = ormdepestmanService.get(ormdepestman_id);
        OrmDepEstManDTO dto = ormdepestmanMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.get(#ormdepestman_id),'ehr-OrmDepEstMan-Remove')")
    @ApiOperation(value = "Remove", tags = {"OrmDepEstMan" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormdepestmen/{ormdepestman_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormdepestman_id") String ormdepestman_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.remove(ormdepestman_id));
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.getOrmdepestmanByIds(#ids),'ehr-OrmDepEstMan-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"OrmDepEstMan" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormdepestmen/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormdepestmanService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.get(#ormdepestman_id),'ehr-OrmDepEstMan-Update')")
    @ApiOperation(value = "Update", tags = {"OrmDepEstMan" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormdepestmen/{ormdepestman_id}")
    @Transactional
    public ResponseEntity<OrmDepEstManDTO> update(@PathVariable("ormdepestman_id") String ormdepestman_id, @RequestBody OrmDepEstManDTO ormdepestmandto) {
		OrmDepEstMan domain  = ormdepestmanMapping.toDomain(ormdepestmandto);
        domain .setOrmdepestmanid(ormdepestman_id);
		ormdepestmanService.update(domain );
		OrmDepEstManDTO dto = ormdepestmanMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.getOrmdepestmanByEntities(this.ormdepestmanMapping.toDomain(#ormdepestmandtos)),'ehr-OrmDepEstMan-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"OrmDepEstMan" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormdepestmen/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrmDepEstManDTO> ormdepestmandtos) {
        ormdepestmanService.updateBatch(ormdepestmanMapping.toDomain(ormdepestmandtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandto),'ehr-OrmDepEstMan-Save')")
    @ApiOperation(value = "Save", tags = {"OrmDepEstMan" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormdepestmen/save")
    public ResponseEntity<Boolean> save(@RequestBody OrmDepEstManDTO ormdepestmandto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.save(ormdepestmanMapping.toDomain(ormdepestmandto)));
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandtos),'ehr-OrmDepEstMan-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"OrmDepEstMan" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormdepestmen/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrmDepEstManDTO> ormdepestmandtos) {
        ormdepestmanService.saveBatch(ormdepestmanMapping.toDomain(ormdepestmandtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmDepEstMan-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"OrmDepEstMan" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormdepestmen/fetchdefault")
	public ResponseEntity<List<OrmDepEstManDTO>> fetchDefault(OrmDepEstManSearchContext context) {
        Page<OrmDepEstMan> domains = ormdepestmanService.searchDefault(context) ;
        List<OrmDepEstManDTO> list = ormdepestmanMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmDepEstMan-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"OrmDepEstMan" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormdepestmen/searchdefault")
	public ResponseEntity<Page<OrmDepEstManDTO>> searchDefault(@RequestBody OrmDepEstManSearchContext context) {
        Page<OrmDepEstMan> domains = ormdepestmanService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormdepestmanMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "GetDraftByORMDUTY", tags = {"OrmDepEstMan" },  notes = "GetDraftByORMDUTY")
    @RequestMapping(method = RequestMethod.GET, value = "/ormduties/{ormduty_id}/ormdepestmen/getdraft")
    public ResponseEntity<OrmDepEstManDTO> getDraftByORMDUTY(@PathVariable("ormduty_id") String ormduty_id) {
        OrmDepEstMan domain = new OrmDepEstMan();
        domain.setOrmdutyid(ormduty_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanMapping.toDto(ormdepestmanService.getDraft(domain)));
    }

    @ApiOperation(value = "CheckKeyByORMDUTY", tags = {"OrmDepEstMan" },  notes = "CheckKeyByORMDUTY")
	@RequestMapping(method = RequestMethod.POST, value = "/ormduties/{ormduty_id}/ormdepestmen/checkkey")
    public ResponseEntity<Boolean> checkKeyByORMDUTY(@PathVariable("ormduty_id") String ormduty_id, @RequestBody OrmDepEstManDTO ormdepestmandto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.checkKey(ormdepestmanMapping.toDomain(ormdepestmandto)));
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandto),'ehr-OrmDepEstMan-Create')")
    @ApiOperation(value = "CreateByORMDUTY", tags = {"OrmDepEstMan" },  notes = "CreateByORMDUTY")
	@RequestMapping(method = RequestMethod.POST, value = "/ormduties/{ormduty_id}/ormdepestmen")
    @Transactional
    public ResponseEntity<OrmDepEstManDTO> createByORMDUTY(@PathVariable("ormduty_id") String ormduty_id, @RequestBody OrmDepEstManDTO ormdepestmandto) {
        OrmDepEstMan domain = ormdepestmanMapping.toDomain(ormdepestmandto);
        domain.setOrmdutyid(ormduty_id);
		ormdepestmanService.create(domain);
        OrmDepEstManDTO dto = ormdepestmanMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandtos),'ehr-OrmDepEstMan-Create')")
    @ApiOperation(value = "createBatchByORMDUTY", tags = {"OrmDepEstMan" },  notes = "createBatchByORMDUTY")
	@RequestMapping(method = RequestMethod.POST, value = "/ormduties/{ormduty_id}/ormdepestmen/batch")
    public ResponseEntity<Boolean> createBatchByORMDUTY(@PathVariable("ormduty_id") String ormduty_id, @RequestBody List<OrmDepEstManDTO> ormdepestmandtos) {
        List<OrmDepEstMan> domainlist=ormdepestmanMapping.toDomain(ormdepestmandtos);
        for(OrmDepEstMan domain:domainlist){
            domain.setOrmdutyid(ormduty_id);
        }
        ormdepestmanService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(returnObject.body),'ehr-OrmDepEstMan-Get')")
    @ApiOperation(value = "GetByORMDUTY", tags = {"OrmDepEstMan" },  notes = "GetByORMDUTY")
	@RequestMapping(method = RequestMethod.GET, value = "/ormduties/{ormduty_id}/ormdepestmen/{ormdepestman_id}")
    public ResponseEntity<OrmDepEstManDTO> getByORMDUTY(@PathVariable("ormduty_id") String ormduty_id, @PathVariable("ormdepestman_id") String ormdepestman_id) {
        OrmDepEstMan domain = ormdepestmanService.get(ormdepestman_id);
        OrmDepEstManDTO dto = ormdepestmanMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.get(#ormdepestman_id),'ehr-OrmDepEstMan-Remove')")
    @ApiOperation(value = "RemoveByORMDUTY", tags = {"OrmDepEstMan" },  notes = "RemoveByORMDUTY")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormduties/{ormduty_id}/ormdepestmen/{ormdepestman_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByORMDUTY(@PathVariable("ormduty_id") String ormduty_id, @PathVariable("ormdepestman_id") String ormdepestman_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.remove(ormdepestman_id));
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.getOrmdepestmanByIds(#ids),'ehr-OrmDepEstMan-Remove')")
    @ApiOperation(value = "RemoveBatchByORMDUTY", tags = {"OrmDepEstMan" },  notes = "RemoveBatchByORMDUTY")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormduties/{ormduty_id}/ormdepestmen/batch")
    public ResponseEntity<Boolean> removeBatchByORMDUTY(@RequestBody List<String> ids) {
        ormdepestmanService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.get(#ormdepestman_id),'ehr-OrmDepEstMan-Update')")
    @ApiOperation(value = "UpdateByORMDUTY", tags = {"OrmDepEstMan" },  notes = "UpdateByORMDUTY")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormduties/{ormduty_id}/ormdepestmen/{ormdepestman_id}")
    @Transactional
    public ResponseEntity<OrmDepEstManDTO> updateByORMDUTY(@PathVariable("ormduty_id") String ormduty_id, @PathVariable("ormdepestman_id") String ormdepestman_id, @RequestBody OrmDepEstManDTO ormdepestmandto) {
        OrmDepEstMan domain = ormdepestmanMapping.toDomain(ormdepestmandto);
        domain.setOrmdutyid(ormduty_id);
        domain.setOrmdepestmanid(ormdepestman_id);
		ormdepestmanService.update(domain);
        OrmDepEstManDTO dto = ormdepestmanMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.getOrmdepestmanByEntities(this.ormdepestmanMapping.toDomain(#ormdepestmandtos)),'ehr-OrmDepEstMan-Update')")
    @ApiOperation(value = "UpdateBatchByORMDUTY", tags = {"OrmDepEstMan" },  notes = "UpdateBatchByORMDUTY")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormduties/{ormduty_id}/ormdepestmen/batch")
    public ResponseEntity<Boolean> updateBatchByORMDUTY(@PathVariable("ormduty_id") String ormduty_id, @RequestBody List<OrmDepEstManDTO> ormdepestmandtos) {
        List<OrmDepEstMan> domainlist=ormdepestmanMapping.toDomain(ormdepestmandtos);
        for(OrmDepEstMan domain:domainlist){
            domain.setOrmdutyid(ormduty_id);
        }
        ormdepestmanService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandto),'ehr-OrmDepEstMan-Save')")
    @ApiOperation(value = "SaveByORMDUTY", tags = {"OrmDepEstMan" },  notes = "SaveByORMDUTY")
	@RequestMapping(method = RequestMethod.POST, value = "/ormduties/{ormduty_id}/ormdepestmen/save")
    public ResponseEntity<Boolean> saveByORMDUTY(@PathVariable("ormduty_id") String ormduty_id, @RequestBody OrmDepEstManDTO ormdepestmandto) {
        OrmDepEstMan domain = ormdepestmanMapping.toDomain(ormdepestmandto);
        domain.setOrmdutyid(ormduty_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandtos),'ehr-OrmDepEstMan-Save')")
    @ApiOperation(value = "SaveBatchByORMDUTY", tags = {"OrmDepEstMan" },  notes = "SaveBatchByORMDUTY")
	@RequestMapping(method = RequestMethod.POST, value = "/ormduties/{ormduty_id}/ormdepestmen/savebatch")
    public ResponseEntity<Boolean> saveBatchByORMDUTY(@PathVariable("ormduty_id") String ormduty_id, @RequestBody List<OrmDepEstManDTO> ormdepestmandtos) {
        List<OrmDepEstMan> domainlist=ormdepestmanMapping.toDomain(ormdepestmandtos);
        for(OrmDepEstMan domain:domainlist){
             domain.setOrmdutyid(ormduty_id);
        }
        ormdepestmanService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmDepEstMan-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByORMDUTY", tags = {"OrmDepEstMan" } ,notes = "fetchDEFAULTByORMDUTY")
    @RequestMapping(method= RequestMethod.GET , value="/ormduties/{ormduty_id}/ormdepestmen/fetchdefault")
	public ResponseEntity<List<OrmDepEstManDTO>> fetchOrmDepEstManDefaultByORMDUTY(@PathVariable("ormduty_id") String ormduty_id,OrmDepEstManSearchContext context) {
        context.setN_ormdutyid_eq(ormduty_id);
        Page<OrmDepEstMan> domains = ormdepestmanService.searchDefault(context) ;
        List<OrmDepEstManDTO> list = ormdepestmanMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmDepEstMan-Default-all')")
	@ApiOperation(value = "searchDEFAULTByORMDUTY", tags = {"OrmDepEstMan" } ,notes = "searchDEFAULTByORMDUTY")
    @RequestMapping(method= RequestMethod.POST , value="/ormduties/{ormduty_id}/ormdepestmen/searchdefault")
	public ResponseEntity<Page<OrmDepEstManDTO>> searchOrmDepEstManDefaultByORMDUTY(@PathVariable("ormduty_id") String ormduty_id, @RequestBody OrmDepEstManSearchContext context) {
        context.setN_ormdutyid_eq(ormduty_id);
        Page<OrmDepEstMan> domains = ormdepestmanService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormdepestmanMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "GetDraftByOrmOrgsector", tags = {"OrmDepEstMan" },  notes = "GetDraftByOrmOrgsector")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/ormdepestmen/getdraft")
    public ResponseEntity<OrmDepEstManDTO> getDraftByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id) {
        OrmDepEstMan domain = new OrmDepEstMan();
        domain.setOrmzwbzid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanMapping.toDto(ormdepestmanService.getDraft(domain)));
    }

    @ApiOperation(value = "CheckKeyByOrmOrgsector", tags = {"OrmDepEstMan" },  notes = "CheckKeyByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormdepestmen/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmDepEstManDTO ormdepestmandto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.checkKey(ormdepestmanMapping.toDomain(ormdepestmandto)));
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandto),'ehr-OrmDepEstMan-Create')")
    @ApiOperation(value = "CreateByOrmOrgsector", tags = {"OrmDepEstMan" },  notes = "CreateByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormdepestmen")
    @Transactional
    public ResponseEntity<OrmDepEstManDTO> createByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmDepEstManDTO ormdepestmandto) {
        OrmDepEstMan domain = ormdepestmanMapping.toDomain(ormdepestmandto);
        domain.setOrmzwbzid(ormorgsector_id);
		ormdepestmanService.create(domain);
        OrmDepEstManDTO dto = ormdepestmanMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandtos),'ehr-OrmDepEstMan-Create')")
    @ApiOperation(value = "createBatchByOrmOrgsector", tags = {"OrmDepEstMan" },  notes = "createBatchByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormdepestmen/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<OrmDepEstManDTO> ormdepestmandtos) {
        List<OrmDepEstMan> domainlist=ormdepestmanMapping.toDomain(ormdepestmandtos);
        for(OrmDepEstMan domain:domainlist){
            domain.setOrmzwbzid(ormorgsector_id);
        }
        ormdepestmanService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(returnObject.body),'ehr-OrmDepEstMan-Get')")
    @ApiOperation(value = "GetByOrmOrgsector", tags = {"OrmDepEstMan" },  notes = "GetByOrmOrgsector")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/ormdepestmen/{ormdepestman_id}")
    public ResponseEntity<OrmDepEstManDTO> getByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormdepestman_id") String ormdepestman_id) {
        OrmDepEstMan domain = ormdepestmanService.get(ormdepestman_id);
        OrmDepEstManDTO dto = ormdepestmanMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.get(#ormdepestman_id),'ehr-OrmDepEstMan-Remove')")
    @ApiOperation(value = "RemoveByOrmOrgsector", tags = {"OrmDepEstMan" },  notes = "RemoveByOrmOrgsector")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/ormdepestmen/{ormdepestman_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormdepestman_id") String ormdepestman_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.remove(ormdepestman_id));
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.getOrmdepestmanByIds(#ids),'ehr-OrmDepEstMan-Remove')")
    @ApiOperation(value = "RemoveBatchByOrmOrgsector", tags = {"OrmDepEstMan" },  notes = "RemoveBatchByOrmOrgsector")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/ormdepestmen/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgsector(@RequestBody List<String> ids) {
        ormdepestmanService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.get(#ormdepestman_id),'ehr-OrmDepEstMan-Update')")
    @ApiOperation(value = "UpdateByOrmOrgsector", tags = {"OrmDepEstMan" },  notes = "UpdateByOrmOrgsector")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/ormdepestmen/{ormdepestman_id}")
    @Transactional
    public ResponseEntity<OrmDepEstManDTO> updateByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormdepestman_id") String ormdepestman_id, @RequestBody OrmDepEstManDTO ormdepestmandto) {
        OrmDepEstMan domain = ormdepestmanMapping.toDomain(ormdepestmandto);
        domain.setOrmzwbzid(ormorgsector_id);
        domain.setOrmdepestmanid(ormdepestman_id);
		ormdepestmanService.update(domain);
        OrmDepEstManDTO dto = ormdepestmanMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.getOrmdepestmanByEntities(this.ormdepestmanMapping.toDomain(#ormdepestmandtos)),'ehr-OrmDepEstMan-Update')")
    @ApiOperation(value = "UpdateBatchByOrmOrgsector", tags = {"OrmDepEstMan" },  notes = "UpdateBatchByOrmOrgsector")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/ormdepestmen/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<OrmDepEstManDTO> ormdepestmandtos) {
        List<OrmDepEstMan> domainlist=ormdepestmanMapping.toDomain(ormdepestmandtos);
        for(OrmDepEstMan domain:domainlist){
            domain.setOrmzwbzid(ormorgsector_id);
        }
        ormdepestmanService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandto),'ehr-OrmDepEstMan-Save')")
    @ApiOperation(value = "SaveByOrmOrgsector", tags = {"OrmDepEstMan" },  notes = "SaveByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormdepestmen/save")
    public ResponseEntity<Boolean> saveByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmDepEstManDTO ormdepestmandto) {
        OrmDepEstMan domain = ormdepestmanMapping.toDomain(ormdepestmandto);
        domain.setOrmzwbzid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandtos),'ehr-OrmDepEstMan-Save')")
    @ApiOperation(value = "SaveBatchByOrmOrgsector", tags = {"OrmDepEstMan" },  notes = "SaveBatchByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormdepestmen/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<OrmDepEstManDTO> ormdepestmandtos) {
        List<OrmDepEstMan> domainlist=ormdepestmanMapping.toDomain(ormdepestmandtos);
        for(OrmDepEstMan domain:domainlist){
             domain.setOrmzwbzid(ormorgsector_id);
        }
        ormdepestmanService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmDepEstMan-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByOrmOrgsector", tags = {"OrmDepEstMan" } ,notes = "fetchDEFAULTByOrmOrgsector")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/{ormorgsector_id}/ormdepestmen/fetchdefault")
	public ResponseEntity<List<OrmDepEstManDTO>> fetchOrmDepEstManDefaultByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id,OrmDepEstManSearchContext context) {
        context.setN_ormzwbzid_eq(ormorgsector_id);
        Page<OrmDepEstMan> domains = ormdepestmanService.searchDefault(context) ;
        List<OrmDepEstManDTO> list = ormdepestmanMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmDepEstMan-Default-all')")
	@ApiOperation(value = "searchDEFAULTByOrmOrgsector", tags = {"OrmDepEstMan" } ,notes = "searchDEFAULTByOrmOrgsector")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/{ormorgsector_id}/ormdepestmen/searchdefault")
	public ResponseEntity<Page<OrmDepEstManDTO>> searchOrmDepEstManDefaultByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmDepEstManSearchContext context) {
        context.setN_ormzwbzid_eq(ormorgsector_id);
        Page<OrmDepEstMan> domains = ormdepestmanService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormdepestmanMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "GetDraftByOrmOrgOrmOrgsector", tags = {"OrmDepEstMan" },  notes = "GetDraftByOrmOrgOrmOrgsector")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen/getdraft")
    public ResponseEntity<OrmDepEstManDTO> getDraftByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id) {
        OrmDepEstMan domain = new OrmDepEstMan();
        domain.setOrmzwbzid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanMapping.toDto(ormdepestmanService.getDraft(domain)));
    }

    @ApiOperation(value = "CheckKeyByOrmOrgOrmOrgsector", tags = {"OrmDepEstMan" },  notes = "CheckKeyByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmDepEstManDTO ormdepestmandto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.checkKey(ormdepestmanMapping.toDomain(ormdepestmandto)));
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandto),'ehr-OrmDepEstMan-Create')")
    @ApiOperation(value = "CreateByOrmOrgOrmOrgsector", tags = {"OrmDepEstMan" },  notes = "CreateByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen")
    @Transactional
    public ResponseEntity<OrmDepEstManDTO> createByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmDepEstManDTO ormdepestmandto) {
        OrmDepEstMan domain = ormdepestmanMapping.toDomain(ormdepestmandto);
        domain.setOrmzwbzid(ormorgsector_id);
		ormdepestmanService.create(domain);
        OrmDepEstManDTO dto = ormdepestmanMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandtos),'ehr-OrmDepEstMan-Create')")
    @ApiOperation(value = "createBatchByOrmOrgOrmOrgsector", tags = {"OrmDepEstMan" },  notes = "createBatchByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<OrmDepEstManDTO> ormdepestmandtos) {
        List<OrmDepEstMan> domainlist=ormdepestmanMapping.toDomain(ormdepestmandtos);
        for(OrmDepEstMan domain:domainlist){
            domain.setOrmzwbzid(ormorgsector_id);
        }
        ormdepestmanService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(returnObject.body),'ehr-OrmDepEstMan-Get')")
    @ApiOperation(value = "GetByOrmOrgOrmOrgsector", tags = {"OrmDepEstMan" },  notes = "GetByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen/{ormdepestman_id}")
    public ResponseEntity<OrmDepEstManDTO> getByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormdepestman_id") String ormdepestman_id) {
        OrmDepEstMan domain = ormdepestmanService.get(ormdepestman_id);
        OrmDepEstManDTO dto = ormdepestmanMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.get(#ormdepestman_id),'ehr-OrmDepEstMan-Remove')")
    @ApiOperation(value = "RemoveByOrmOrgOrmOrgsector", tags = {"OrmDepEstMan" },  notes = "RemoveByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen/{ormdepestman_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormdepestman_id") String ormdepestman_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.remove(ormdepestman_id));
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.getOrmdepestmanByIds(#ids),'ehr-OrmDepEstMan-Remove')")
    @ApiOperation(value = "RemoveBatchByOrmOrgOrmOrgsector", tags = {"OrmDepEstMan" },  notes = "RemoveBatchByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgOrmOrgsector(@RequestBody List<String> ids) {
        ormdepestmanService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.get(#ormdepestman_id),'ehr-OrmDepEstMan-Update')")
    @ApiOperation(value = "UpdateByOrmOrgOrmOrgsector", tags = {"OrmDepEstMan" },  notes = "UpdateByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen/{ormdepestman_id}")
    @Transactional
    public ResponseEntity<OrmDepEstManDTO> updateByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormdepestman_id") String ormdepestman_id, @RequestBody OrmDepEstManDTO ormdepestmandto) {
        OrmDepEstMan domain = ormdepestmanMapping.toDomain(ormdepestmandto);
        domain.setOrmzwbzid(ormorgsector_id);
        domain.setOrmdepestmanid(ormdepestman_id);
		ormdepestmanService.update(domain);
        OrmDepEstManDTO dto = ormdepestmanMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.getOrmdepestmanByEntities(this.ormdepestmanMapping.toDomain(#ormdepestmandtos)),'ehr-OrmDepEstMan-Update')")
    @ApiOperation(value = "UpdateBatchByOrmOrgOrmOrgsector", tags = {"OrmDepEstMan" },  notes = "UpdateBatchByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<OrmDepEstManDTO> ormdepestmandtos) {
        List<OrmDepEstMan> domainlist=ormdepestmanMapping.toDomain(ormdepestmandtos);
        for(OrmDepEstMan domain:domainlist){
            domain.setOrmzwbzid(ormorgsector_id);
        }
        ormdepestmanService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandto),'ehr-OrmDepEstMan-Save')")
    @ApiOperation(value = "SaveByOrmOrgOrmOrgsector", tags = {"OrmDepEstMan" },  notes = "SaveByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen/save")
    public ResponseEntity<Boolean> saveByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmDepEstManDTO ormdepestmandto) {
        OrmDepEstMan domain = ormdepestmanMapping.toDomain(ormdepestmandto);
        domain.setOrmzwbzid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandtos),'ehr-OrmDepEstMan-Save')")
    @ApiOperation(value = "SaveBatchByOrmOrgOrmOrgsector", tags = {"OrmDepEstMan" },  notes = "SaveBatchByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<OrmDepEstManDTO> ormdepestmandtos) {
        List<OrmDepEstMan> domainlist=ormdepestmanMapping.toDomain(ormdepestmandtos);
        for(OrmDepEstMan domain:domainlist){
             domain.setOrmzwbzid(ormorgsector_id);
        }
        ormdepestmanService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmDepEstMan-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByOrmOrgOrmOrgsector", tags = {"OrmDepEstMan" } ,notes = "fetchDEFAULTByOrmOrgOrmOrgsector")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen/fetchdefault")
	public ResponseEntity<List<OrmDepEstManDTO>> fetchOrmDepEstManDefaultByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id,OrmDepEstManSearchContext context) {
        context.setN_ormzwbzid_eq(ormorgsector_id);
        Page<OrmDepEstMan> domains = ormdepestmanService.searchDefault(context) ;
        List<OrmDepEstManDTO> list = ormdepestmanMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmDepEstMan-Default-all')")
	@ApiOperation(value = "searchDEFAULTByOrmOrgOrmOrgsector", tags = {"OrmDepEstMan" } ,notes = "searchDEFAULTByOrmOrgOrmOrgsector")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen/searchdefault")
	public ResponseEntity<Page<OrmDepEstManDTO>> searchOrmDepEstManDefaultByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody OrmDepEstManSearchContext context) {
        context.setN_ormzwbzid_eq(ormorgsector_id);
        Page<OrmDepEstMan> domains = ormdepestmanService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormdepestmanMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

