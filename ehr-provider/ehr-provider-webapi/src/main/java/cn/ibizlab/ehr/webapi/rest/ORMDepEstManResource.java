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
import cn.ibizlab.ehr.core.orm.domain.ORMDepEstMan;
import cn.ibizlab.ehr.core.orm.service.IORMDepEstManService;
import cn.ibizlab.ehr.core.orm.filter.ORMDepEstManSearchContext;

@Slf4j
@Api(tags = {"ORMDepEstMan" })
@RestController("WebApi-ormdepestman")
@RequestMapping("")
public class ORMDepEstManResource {

    @Autowired
    public IORMDepEstManService ormdepestmanService;

    @Autowired
    @Lazy
    public ORMDepEstManMapping ormdepestmanMapping;

    @ApiOperation(value = "GetDraft", tags = {"ORMDepEstMan" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormdepestmen/getdraft")
    public ResponseEntity<ORMDepEstManDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanMapping.toDto(ormdepestmanService.getDraft(new ORMDepEstMan())));
    }

    @ApiOperation(value = "CheckKey", tags = {"ORMDepEstMan" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormdepestmen/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ORMDepEstManDTO ormdepestmandto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.checkKey(ormdepestmanMapping.toDomain(ormdepestmandto)));
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandto),'ehr-ORMDepEstMan-Create')")
    @ApiOperation(value = "Create", tags = {"ORMDepEstMan" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormdepestmen")
    @Transactional
    public ResponseEntity<ORMDepEstManDTO> create(@RequestBody ORMDepEstManDTO ormdepestmandto) {
        ORMDepEstMan domain = ormdepestmanMapping.toDomain(ormdepestmandto);
		ormdepestmanService.create(domain);
        ORMDepEstManDTO dto = ormdepestmanMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandtos),'ehr-ORMDepEstMan-Create')")
    @ApiOperation(value = "createBatch", tags = {"ORMDepEstMan" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormdepestmen/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ORMDepEstManDTO> ormdepestmandtos) {
        ormdepestmanService.createBatch(ormdepestmanMapping.toDomain(ormdepestmandtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(returnObject.body),'ehr-ORMDepEstMan-Get')")
    @ApiOperation(value = "Get", tags = {"ORMDepEstMan" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormdepestmen/{ormdepestman_id}")
    public ResponseEntity<ORMDepEstManDTO> get(@PathVariable("ormdepestman_id") String ormdepestman_id) {
        ORMDepEstMan domain = ormdepestmanService.get(ormdepestman_id);
        ORMDepEstManDTO dto = ormdepestmanMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.get(#ormdepestman_id),'ehr-ORMDepEstMan-Remove')")
    @ApiOperation(value = "Remove", tags = {"ORMDepEstMan" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormdepestmen/{ormdepestman_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormdepestman_id") String ormdepestman_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.remove(ormdepestman_id));
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.getOrmdepestmanByIds(#ids),'ehr-ORMDepEstMan-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"ORMDepEstMan" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormdepestmen/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormdepestmanService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.get(#ormdepestman_id),'ehr-ORMDepEstMan-Update')")
    @ApiOperation(value = "Update", tags = {"ORMDepEstMan" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormdepestmen/{ormdepestman_id}")
    @Transactional
    public ResponseEntity<ORMDepEstManDTO> update(@PathVariable("ormdepestman_id") String ormdepestman_id, @RequestBody ORMDepEstManDTO ormdepestmandto) {
		ORMDepEstMan domain  = ormdepestmanMapping.toDomain(ormdepestmandto);
        domain .setOrmdepestmanid(ormdepestman_id);
		ormdepestmanService.update(domain );
		ORMDepEstManDTO dto = ormdepestmanMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.getOrmdepestmanByEntities(this.ormdepestmanMapping.toDomain(#ormdepestmandtos)),'ehr-ORMDepEstMan-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"ORMDepEstMan" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormdepestmen/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ORMDepEstManDTO> ormdepestmandtos) {
        ormdepestmanService.updateBatch(ormdepestmanMapping.toDomain(ormdepestmandtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandto),'ehr-ORMDepEstMan-Save')")
    @ApiOperation(value = "Save", tags = {"ORMDepEstMan" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormdepestmen/save")
    public ResponseEntity<Boolean> save(@RequestBody ORMDepEstManDTO ormdepestmandto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.save(ormdepestmanMapping.toDomain(ormdepestmandto)));
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandtos),'ehr-ORMDepEstMan-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"ORMDepEstMan" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormdepestmen/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ORMDepEstManDTO> ormdepestmandtos) {
        ormdepestmanService.saveBatch(ormdepestmanMapping.toDomain(ormdepestmandtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMDepEstMan-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ORMDepEstMan" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormdepestmen/fetchdefault")
	public ResponseEntity<List<ORMDepEstManDTO>> fetchDefault(ORMDepEstManSearchContext context) {
        Page<ORMDepEstMan> domains = ormdepestmanService.searchDefault(context) ;
        List<ORMDepEstManDTO> list = ormdepestmanMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMDepEstMan-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ORMDepEstMan" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormdepestmen/searchdefault")
	public ResponseEntity<Page<ORMDepEstManDTO>> searchDefault(@RequestBody ORMDepEstManSearchContext context) {
        Page<ORMDepEstMan> domains = ormdepestmanService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormdepestmanMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "GetDraftByORMDUTY", tags = {"ORMDepEstMan" },  notes = "GetDraftByORMDUTY")
    @RequestMapping(method = RequestMethod.GET, value = "/ormduties/{ormduty_id}/ormdepestmen/getdraft")
    public ResponseEntity<ORMDepEstManDTO> getDraftByORMDUTY(@PathVariable("ormduty_id") String ormduty_id) {
        ORMDepEstMan domain = new ORMDepEstMan();
        domain.setOrmdutyid(ormduty_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanMapping.toDto(ormdepestmanService.getDraft(domain)));
    }

    @ApiOperation(value = "CheckKeyByORMDUTY", tags = {"ORMDepEstMan" },  notes = "CheckKeyByORMDUTY")
	@RequestMapping(method = RequestMethod.POST, value = "/ormduties/{ormduty_id}/ormdepestmen/checkkey")
    public ResponseEntity<Boolean> checkKeyByORMDUTY(@PathVariable("ormduty_id") String ormduty_id, @RequestBody ORMDepEstManDTO ormdepestmandto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.checkKey(ormdepestmanMapping.toDomain(ormdepestmandto)));
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandto),'ehr-ORMDepEstMan-Create')")
    @ApiOperation(value = "CreateByORMDUTY", tags = {"ORMDepEstMan" },  notes = "CreateByORMDUTY")
	@RequestMapping(method = RequestMethod.POST, value = "/ormduties/{ormduty_id}/ormdepestmen")
    @Transactional
    public ResponseEntity<ORMDepEstManDTO> createByORMDUTY(@PathVariable("ormduty_id") String ormduty_id, @RequestBody ORMDepEstManDTO ormdepestmandto) {
        ORMDepEstMan domain = ormdepestmanMapping.toDomain(ormdepestmandto);
        domain.setOrmdutyid(ormduty_id);
		ormdepestmanService.create(domain);
        ORMDepEstManDTO dto = ormdepestmanMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandtos),'ehr-ORMDepEstMan-Create')")
    @ApiOperation(value = "createBatchByORMDUTY", tags = {"ORMDepEstMan" },  notes = "createBatchByORMDUTY")
	@RequestMapping(method = RequestMethod.POST, value = "/ormduties/{ormduty_id}/ormdepestmen/batch")
    public ResponseEntity<Boolean> createBatchByORMDUTY(@PathVariable("ormduty_id") String ormduty_id, @RequestBody List<ORMDepEstManDTO> ormdepestmandtos) {
        List<ORMDepEstMan> domainlist=ormdepestmanMapping.toDomain(ormdepestmandtos);
        for(ORMDepEstMan domain:domainlist){
            domain.setOrmdutyid(ormduty_id);
        }
        ormdepestmanService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(returnObject.body),'ehr-ORMDepEstMan-Get')")
    @ApiOperation(value = "GetByORMDUTY", tags = {"ORMDepEstMan" },  notes = "GetByORMDUTY")
	@RequestMapping(method = RequestMethod.GET, value = "/ormduties/{ormduty_id}/ormdepestmen/{ormdepestman_id}")
    public ResponseEntity<ORMDepEstManDTO> getByORMDUTY(@PathVariable("ormduty_id") String ormduty_id, @PathVariable("ormdepestman_id") String ormdepestman_id) {
        ORMDepEstMan domain = ormdepestmanService.get(ormdepestman_id);
        ORMDepEstManDTO dto = ormdepestmanMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.get(#ormdepestman_id),'ehr-ORMDepEstMan-Remove')")
    @ApiOperation(value = "RemoveByORMDUTY", tags = {"ORMDepEstMan" },  notes = "RemoveByORMDUTY")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormduties/{ormduty_id}/ormdepestmen/{ormdepestman_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByORMDUTY(@PathVariable("ormduty_id") String ormduty_id, @PathVariable("ormdepestman_id") String ormdepestman_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.remove(ormdepestman_id));
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.getOrmdepestmanByIds(#ids),'ehr-ORMDepEstMan-Remove')")
    @ApiOperation(value = "RemoveBatchByORMDUTY", tags = {"ORMDepEstMan" },  notes = "RemoveBatchByORMDUTY")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormduties/{ormduty_id}/ormdepestmen/batch")
    public ResponseEntity<Boolean> removeBatchByORMDUTY(@RequestBody List<String> ids) {
        ormdepestmanService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.get(#ormdepestman_id),'ehr-ORMDepEstMan-Update')")
    @ApiOperation(value = "UpdateByORMDUTY", tags = {"ORMDepEstMan" },  notes = "UpdateByORMDUTY")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormduties/{ormduty_id}/ormdepestmen/{ormdepestman_id}")
    @Transactional
    public ResponseEntity<ORMDepEstManDTO> updateByORMDUTY(@PathVariable("ormduty_id") String ormduty_id, @PathVariable("ormdepestman_id") String ormdepestman_id, @RequestBody ORMDepEstManDTO ormdepestmandto) {
        ORMDepEstMan domain = ormdepestmanMapping.toDomain(ormdepestmandto);
        domain.setOrmdutyid(ormduty_id);
        domain.setOrmdepestmanid(ormdepestman_id);
		ormdepestmanService.update(domain);
        ORMDepEstManDTO dto = ormdepestmanMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.getOrmdepestmanByEntities(this.ormdepestmanMapping.toDomain(#ormdepestmandtos)),'ehr-ORMDepEstMan-Update')")
    @ApiOperation(value = "UpdateBatchByORMDUTY", tags = {"ORMDepEstMan" },  notes = "UpdateBatchByORMDUTY")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormduties/{ormduty_id}/ormdepestmen/batch")
    public ResponseEntity<Boolean> updateBatchByORMDUTY(@PathVariable("ormduty_id") String ormduty_id, @RequestBody List<ORMDepEstManDTO> ormdepestmandtos) {
        List<ORMDepEstMan> domainlist=ormdepestmanMapping.toDomain(ormdepestmandtos);
        for(ORMDepEstMan domain:domainlist){
            domain.setOrmdutyid(ormduty_id);
        }
        ormdepestmanService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandto),'ehr-ORMDepEstMan-Save')")
    @ApiOperation(value = "SaveByORMDUTY", tags = {"ORMDepEstMan" },  notes = "SaveByORMDUTY")
	@RequestMapping(method = RequestMethod.POST, value = "/ormduties/{ormduty_id}/ormdepestmen/save")
    public ResponseEntity<Boolean> saveByORMDUTY(@PathVariable("ormduty_id") String ormduty_id, @RequestBody ORMDepEstManDTO ormdepestmandto) {
        ORMDepEstMan domain = ormdepestmanMapping.toDomain(ormdepestmandto);
        domain.setOrmdutyid(ormduty_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandtos),'ehr-ORMDepEstMan-Save')")
    @ApiOperation(value = "SaveBatchByORMDUTY", tags = {"ORMDepEstMan" },  notes = "SaveBatchByORMDUTY")
	@RequestMapping(method = RequestMethod.POST, value = "/ormduties/{ormduty_id}/ormdepestmen/savebatch")
    public ResponseEntity<Boolean> saveBatchByORMDUTY(@PathVariable("ormduty_id") String ormduty_id, @RequestBody List<ORMDepEstManDTO> ormdepestmandtos) {
        List<ORMDepEstMan> domainlist=ormdepestmanMapping.toDomain(ormdepestmandtos);
        for(ORMDepEstMan domain:domainlist){
             domain.setOrmdutyid(ormduty_id);
        }
        ormdepestmanService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMDepEstMan-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByORMDUTY", tags = {"ORMDepEstMan" } ,notes = "fetchDEFAULTByORMDUTY")
    @RequestMapping(method= RequestMethod.GET , value="/ormduties/{ormduty_id}/ormdepestmen/fetchdefault")
	public ResponseEntity<List<ORMDepEstManDTO>> fetchORMDepEstManDefaultByORMDUTY(@PathVariable("ormduty_id") String ormduty_id,ORMDepEstManSearchContext context) {
        context.setN_ormdutyid_eq(ormduty_id);
        Page<ORMDepEstMan> domains = ormdepestmanService.searchDefault(context) ;
        List<ORMDepEstManDTO> list = ormdepestmanMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMDepEstMan-Default-all')")
	@ApiOperation(value = "searchDEFAULTByORMDUTY", tags = {"ORMDepEstMan" } ,notes = "searchDEFAULTByORMDUTY")
    @RequestMapping(method= RequestMethod.POST , value="/ormduties/{ormduty_id}/ormdepestmen/searchdefault")
	public ResponseEntity<Page<ORMDepEstManDTO>> searchORMDepEstManDefaultByORMDUTY(@PathVariable("ormduty_id") String ormduty_id, @RequestBody ORMDepEstManSearchContext context) {
        context.setN_ormdutyid_eq(ormduty_id);
        Page<ORMDepEstMan> domains = ormdepestmanService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormdepestmanMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "GetDraftByOrmOrgsector", tags = {"ORMDepEstMan" },  notes = "GetDraftByOrmOrgsector")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/ormdepestmen/getdraft")
    public ResponseEntity<ORMDepEstManDTO> getDraftByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id) {
        ORMDepEstMan domain = new ORMDepEstMan();
        domain.setOrmzwbzid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanMapping.toDto(ormdepestmanService.getDraft(domain)));
    }

    @ApiOperation(value = "CheckKeyByOrmOrgsector", tags = {"ORMDepEstMan" },  notes = "CheckKeyByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormdepestmen/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMDepEstManDTO ormdepestmandto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.checkKey(ormdepestmanMapping.toDomain(ormdepestmandto)));
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandto),'ehr-ORMDepEstMan-Create')")
    @ApiOperation(value = "CreateByOrmOrgsector", tags = {"ORMDepEstMan" },  notes = "CreateByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormdepestmen")
    @Transactional
    public ResponseEntity<ORMDepEstManDTO> createByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMDepEstManDTO ormdepestmandto) {
        ORMDepEstMan domain = ormdepestmanMapping.toDomain(ormdepestmandto);
        domain.setOrmzwbzid(ormorgsector_id);
		ormdepestmanService.create(domain);
        ORMDepEstManDTO dto = ormdepestmanMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandtos),'ehr-ORMDepEstMan-Create')")
    @ApiOperation(value = "createBatchByOrmOrgsector", tags = {"ORMDepEstMan" },  notes = "createBatchByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormdepestmen/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMDepEstManDTO> ormdepestmandtos) {
        List<ORMDepEstMan> domainlist=ormdepestmanMapping.toDomain(ormdepestmandtos);
        for(ORMDepEstMan domain:domainlist){
            domain.setOrmzwbzid(ormorgsector_id);
        }
        ormdepestmanService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(returnObject.body),'ehr-ORMDepEstMan-Get')")
    @ApiOperation(value = "GetByOrmOrgsector", tags = {"ORMDepEstMan" },  notes = "GetByOrmOrgsector")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/ormdepestmen/{ormdepestman_id}")
    public ResponseEntity<ORMDepEstManDTO> getByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormdepestman_id") String ormdepestman_id) {
        ORMDepEstMan domain = ormdepestmanService.get(ormdepestman_id);
        ORMDepEstManDTO dto = ormdepestmanMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.get(#ormdepestman_id),'ehr-ORMDepEstMan-Remove')")
    @ApiOperation(value = "RemoveByOrmOrgsector", tags = {"ORMDepEstMan" },  notes = "RemoveByOrmOrgsector")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/ormdepestmen/{ormdepestman_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormdepestman_id") String ormdepestman_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.remove(ormdepestman_id));
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.getOrmdepestmanByIds(#ids),'ehr-ORMDepEstMan-Remove')")
    @ApiOperation(value = "RemoveBatchByOrmOrgsector", tags = {"ORMDepEstMan" },  notes = "RemoveBatchByOrmOrgsector")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/ormdepestmen/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgsector(@RequestBody List<String> ids) {
        ormdepestmanService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.get(#ormdepestman_id),'ehr-ORMDepEstMan-Update')")
    @ApiOperation(value = "UpdateByOrmOrgsector", tags = {"ORMDepEstMan" },  notes = "UpdateByOrmOrgsector")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/ormdepestmen/{ormdepestman_id}")
    @Transactional
    public ResponseEntity<ORMDepEstManDTO> updateByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormdepestman_id") String ormdepestman_id, @RequestBody ORMDepEstManDTO ormdepestmandto) {
        ORMDepEstMan domain = ormdepestmanMapping.toDomain(ormdepestmandto);
        domain.setOrmzwbzid(ormorgsector_id);
        domain.setOrmdepestmanid(ormdepestman_id);
		ormdepestmanService.update(domain);
        ORMDepEstManDTO dto = ormdepestmanMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.getOrmdepestmanByEntities(this.ormdepestmanMapping.toDomain(#ormdepestmandtos)),'ehr-ORMDepEstMan-Update')")
    @ApiOperation(value = "UpdateBatchByOrmOrgsector", tags = {"ORMDepEstMan" },  notes = "UpdateBatchByOrmOrgsector")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/ormdepestmen/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMDepEstManDTO> ormdepestmandtos) {
        List<ORMDepEstMan> domainlist=ormdepestmanMapping.toDomain(ormdepestmandtos);
        for(ORMDepEstMan domain:domainlist){
            domain.setOrmzwbzid(ormorgsector_id);
        }
        ormdepestmanService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandto),'ehr-ORMDepEstMan-Save')")
    @ApiOperation(value = "SaveByOrmOrgsector", tags = {"ORMDepEstMan" },  notes = "SaveByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormdepestmen/save")
    public ResponseEntity<Boolean> saveByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMDepEstManDTO ormdepestmandto) {
        ORMDepEstMan domain = ormdepestmanMapping.toDomain(ormdepestmandto);
        domain.setOrmzwbzid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandtos),'ehr-ORMDepEstMan-Save')")
    @ApiOperation(value = "SaveBatchByOrmOrgsector", tags = {"ORMDepEstMan" },  notes = "SaveBatchByOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormdepestmen/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMDepEstManDTO> ormdepestmandtos) {
        List<ORMDepEstMan> domainlist=ormdepestmanMapping.toDomain(ormdepestmandtos);
        for(ORMDepEstMan domain:domainlist){
             domain.setOrmzwbzid(ormorgsector_id);
        }
        ormdepestmanService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMDepEstMan-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByOrmOrgsector", tags = {"ORMDepEstMan" } ,notes = "fetchDEFAULTByOrmOrgsector")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/{ormorgsector_id}/ormdepestmen/fetchdefault")
	public ResponseEntity<List<ORMDepEstManDTO>> fetchORMDepEstManDefaultByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id,ORMDepEstManSearchContext context) {
        context.setN_ormzwbzid_eq(ormorgsector_id);
        Page<ORMDepEstMan> domains = ormdepestmanService.searchDefault(context) ;
        List<ORMDepEstManDTO> list = ormdepestmanMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMDepEstMan-Default-all')")
	@ApiOperation(value = "searchDEFAULTByOrmOrgsector", tags = {"ORMDepEstMan" } ,notes = "searchDEFAULTByOrmOrgsector")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/{ormorgsector_id}/ormdepestmen/searchdefault")
	public ResponseEntity<Page<ORMDepEstManDTO>> searchORMDepEstManDefaultByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMDepEstManSearchContext context) {
        context.setN_ormzwbzid_eq(ormorgsector_id);
        Page<ORMDepEstMan> domains = ormdepestmanService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormdepestmanMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "GetDraftByOrmOrgOrmOrgsector", tags = {"ORMDepEstMan" },  notes = "GetDraftByOrmOrgOrmOrgsector")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen/getdraft")
    public ResponseEntity<ORMDepEstManDTO> getDraftByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id) {
        ORMDepEstMan domain = new ORMDepEstMan();
        domain.setOrmzwbzid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanMapping.toDto(ormdepestmanService.getDraft(domain)));
    }

    @ApiOperation(value = "CheckKeyByOrmOrgOrmOrgsector", tags = {"ORMDepEstMan" },  notes = "CheckKeyByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMDepEstManDTO ormdepestmandto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.checkKey(ormdepestmanMapping.toDomain(ormdepestmandto)));
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandto),'ehr-ORMDepEstMan-Create')")
    @ApiOperation(value = "CreateByOrmOrgOrmOrgsector", tags = {"ORMDepEstMan" },  notes = "CreateByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen")
    @Transactional
    public ResponseEntity<ORMDepEstManDTO> createByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMDepEstManDTO ormdepestmandto) {
        ORMDepEstMan domain = ormdepestmanMapping.toDomain(ormdepestmandto);
        domain.setOrmzwbzid(ormorgsector_id);
		ormdepestmanService.create(domain);
        ORMDepEstManDTO dto = ormdepestmanMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandtos),'ehr-ORMDepEstMan-Create')")
    @ApiOperation(value = "createBatchByOrmOrgOrmOrgsector", tags = {"ORMDepEstMan" },  notes = "createBatchByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMDepEstManDTO> ormdepestmandtos) {
        List<ORMDepEstMan> domainlist=ormdepestmanMapping.toDomain(ormdepestmandtos);
        for(ORMDepEstMan domain:domainlist){
            domain.setOrmzwbzid(ormorgsector_id);
        }
        ormdepestmanService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(returnObject.body),'ehr-ORMDepEstMan-Get')")
    @ApiOperation(value = "GetByOrmOrgOrmOrgsector", tags = {"ORMDepEstMan" },  notes = "GetByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen/{ormdepestman_id}")
    public ResponseEntity<ORMDepEstManDTO> getByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormdepestman_id") String ormdepestman_id) {
        ORMDepEstMan domain = ormdepestmanService.get(ormdepestman_id);
        ORMDepEstManDTO dto = ormdepestmanMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.get(#ormdepestman_id),'ehr-ORMDepEstMan-Remove')")
    @ApiOperation(value = "RemoveByOrmOrgOrmOrgsector", tags = {"ORMDepEstMan" },  notes = "RemoveByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen/{ormdepestman_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormdepestman_id") String ormdepestman_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.remove(ormdepestman_id));
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.getOrmdepestmanByIds(#ids),'ehr-ORMDepEstMan-Remove')")
    @ApiOperation(value = "RemoveBatchByOrmOrgOrmOrgsector", tags = {"ORMDepEstMan" },  notes = "RemoveBatchByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgOrmOrgsector(@RequestBody List<String> ids) {
        ormdepestmanService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.get(#ormdepestman_id),'ehr-ORMDepEstMan-Update')")
    @ApiOperation(value = "UpdateByOrmOrgOrmOrgsector", tags = {"ORMDepEstMan" },  notes = "UpdateByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen/{ormdepestman_id}")
    @Transactional
    public ResponseEntity<ORMDepEstManDTO> updateByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormdepestman_id") String ormdepestman_id, @RequestBody ORMDepEstManDTO ormdepestmandto) {
        ORMDepEstMan domain = ormdepestmanMapping.toDomain(ormdepestmandto);
        domain.setOrmzwbzid(ormorgsector_id);
        domain.setOrmdepestmanid(ormdepestman_id);
		ormdepestmanService.update(domain);
        ORMDepEstManDTO dto = ormdepestmanMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanService.getOrmdepestmanByEntities(this.ormdepestmanMapping.toDomain(#ormdepestmandtos)),'ehr-ORMDepEstMan-Update')")
    @ApiOperation(value = "UpdateBatchByOrmOrgOrmOrgsector", tags = {"ORMDepEstMan" },  notes = "UpdateBatchByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMDepEstManDTO> ormdepestmandtos) {
        List<ORMDepEstMan> domainlist=ormdepestmanMapping.toDomain(ormdepestmandtos);
        for(ORMDepEstMan domain:domainlist){
            domain.setOrmzwbzid(ormorgsector_id);
        }
        ormdepestmanService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandto),'ehr-ORMDepEstMan-Save')")
    @ApiOperation(value = "SaveByOrmOrgOrmOrgsector", tags = {"ORMDepEstMan" },  notes = "SaveByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen/save")
    public ResponseEntity<Boolean> saveByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMDepEstManDTO ormdepestmandto) {
        ORMDepEstMan domain = ormdepestmanMapping.toDomain(ormdepestmandto);
        domain.setOrmzwbzid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormdepestmanService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormdepestmanMapping.toDomain(#ormdepestmandtos),'ehr-ORMDepEstMan-Save')")
    @ApiOperation(value = "SaveBatchByOrmOrgOrmOrgsector", tags = {"ORMDepEstMan" },  notes = "SaveBatchByOrmOrgOrmOrgsector")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMDepEstManDTO> ormdepestmandtos) {
        List<ORMDepEstMan> domainlist=ormdepestmanMapping.toDomain(ormdepestmandtos);
        for(ORMDepEstMan domain:domainlist){
             domain.setOrmzwbzid(ormorgsector_id);
        }
        ormdepestmanService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMDepEstMan-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByOrmOrgOrmOrgsector", tags = {"ORMDepEstMan" } ,notes = "fetchDEFAULTByOrmOrgOrmOrgsector")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen/fetchdefault")
	public ResponseEntity<List<ORMDepEstManDTO>> fetchORMDepEstManDefaultByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id,ORMDepEstManSearchContext context) {
        context.setN_ormzwbzid_eq(ormorgsector_id);
        Page<ORMDepEstMan> domains = ormdepestmanService.searchDefault(context) ;
        List<ORMDepEstManDTO> list = ormdepestmanMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMDepEstMan-Default-all')")
	@ApiOperation(value = "searchDEFAULTByOrmOrgOrmOrgsector", tags = {"ORMDepEstMan" } ,notes = "searchDEFAULTByOrmOrgOrmOrgsector")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormdepestmen/searchdefault")
	public ResponseEntity<Page<ORMDepEstManDTO>> searchORMDepEstManDefaultByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMDepEstManSearchContext context) {
        context.setN_ormzwbzid_eq(ormorgsector_id);
        Page<ORMDepEstMan> domains = ormdepestmanService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormdepestmanMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

