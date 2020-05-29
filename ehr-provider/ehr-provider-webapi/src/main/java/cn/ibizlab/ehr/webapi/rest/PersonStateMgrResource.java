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
import cn.ibizlab.ehr.core.pim.domain.PersonStateMgr;
import cn.ibizlab.ehr.core.pim.service.IPersonStateMgrService;
import cn.ibizlab.ehr.core.pim.filter.PersonStateMgrSearchContext;

@Slf4j
@Api(tags = {"PersonStateMgr" })
@RestController("WebApi-personstatemgr")
@RequestMapping("")
public class PersonStateMgrResource {

    @Autowired
    public IPersonStateMgrService personstatemgrService;

    @Autowired
    @Lazy
    public PersonStateMgrMapping personstatemgrMapping;

    @PreAuthorize("hasPermission(this.personstatemgrMapping.toDomain(#personstatemgrdto),'ehr-PersonStateMgr-Save')")
    @ApiOperation(value = "Save", tags = {"PersonStateMgr" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/personstatemgrs/save")
    public ResponseEntity<Boolean> save(@RequestBody PersonStateMgrDTO personstatemgrdto) {
        return ResponseEntity.status(HttpStatus.OK).body(personstatemgrService.save(personstatemgrMapping.toDomain(personstatemgrdto)));
    }

    @PreAuthorize("hasPermission(this.personstatemgrMapping.toDomain(#personstatemgrdtos),'ehr-PersonStateMgr-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PersonStateMgr" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/personstatemgrs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PersonStateMgrDTO> personstatemgrdtos) {
        personstatemgrService.saveBatch(personstatemgrMapping.toDomain(personstatemgrdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"PersonStateMgr" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/personstatemgrs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PersonStateMgrDTO personstatemgrdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(personstatemgrService.checkKey(personstatemgrMapping.toDomain(personstatemgrdto)));
    }

    @ApiOperation(value = "GetDraft", tags = {"PersonStateMgr" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/personstatemgrs/getdraft")
    public ResponseEntity<PersonStateMgrDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(personstatemgrMapping.toDto(personstatemgrService.getDraft(new PersonStateMgr())));
    }

    @PostAuthorize("hasPermission(this.personstatemgrMapping.toDomain(returnObject.body),'ehr-PersonStateMgr-Get')")
    @ApiOperation(value = "Get", tags = {"PersonStateMgr" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/personstatemgrs/{personstatemgr_id}")
    public ResponseEntity<PersonStateMgrDTO> get(@PathVariable("personstatemgr_id") String personstatemgr_id) {
        PersonStateMgr domain = personstatemgrService.get(personstatemgr_id);
        PersonStateMgrDTO dto = personstatemgrMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.personstatemgrMapping.toDomain(#personstatemgrdto),'ehr-PersonStateMgr-Create')")
    @ApiOperation(value = "Create", tags = {"PersonStateMgr" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/personstatemgrs")
    @Transactional
    public ResponseEntity<PersonStateMgrDTO> create(@RequestBody PersonStateMgrDTO personstatemgrdto) {
        PersonStateMgr domain = personstatemgrMapping.toDomain(personstatemgrdto);
		personstatemgrService.create(domain);
        PersonStateMgrDTO dto = personstatemgrMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.personstatemgrMapping.toDomain(#personstatemgrdtos),'ehr-PersonStateMgr-Create')")
    @ApiOperation(value = "createBatch", tags = {"PersonStateMgr" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/personstatemgrs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PersonStateMgrDTO> personstatemgrdtos) {
        personstatemgrService.createBatch(personstatemgrMapping.toDomain(personstatemgrdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.personstatemgrService.get(#personstatemgr_id),'ehr-PersonStateMgr-Update')")
    @ApiOperation(value = "Update", tags = {"PersonStateMgr" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/personstatemgrs/{personstatemgr_id}")
    @Transactional
    public ResponseEntity<PersonStateMgrDTO> update(@PathVariable("personstatemgr_id") String personstatemgr_id, @RequestBody PersonStateMgrDTO personstatemgrdto) {
		PersonStateMgr domain  = personstatemgrMapping.toDomain(personstatemgrdto);
        domain .setPersonstatemgrid(personstatemgr_id);
		personstatemgrService.update(domain );
		PersonStateMgrDTO dto = personstatemgrMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.personstatemgrService.getPersonstatemgrByEntities(this.personstatemgrMapping.toDomain(#personstatemgrdtos)),'ehr-PersonStateMgr-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PersonStateMgr" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/personstatemgrs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PersonStateMgrDTO> personstatemgrdtos) {
        personstatemgrService.updateBatch(personstatemgrMapping.toDomain(personstatemgrdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.personstatemgrService.get(#personstatemgr_id),'ehr-PersonStateMgr-Remove')")
    @ApiOperation(value = "Remove", tags = {"PersonStateMgr" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/personstatemgrs/{personstatemgr_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("personstatemgr_id") String personstatemgr_id) {
         return ResponseEntity.status(HttpStatus.OK).body(personstatemgrService.remove(personstatemgr_id));
    }

    @PreAuthorize("hasPermission(this.personstatemgrService.getPersonstatemgrByIds(#ids),'ehr-PersonStateMgr-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PersonStateMgr" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/personstatemgrs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        personstatemgrService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PersonStateMgr-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PersonStateMgr" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/personstatemgrs/fetchdefault")
	public ResponseEntity<List<PersonStateMgrDTO>> fetchDefault(PersonStateMgrSearchContext context) {
        Page<PersonStateMgr> domains = personstatemgrService.searchDefault(context) ;
        List<PersonStateMgrDTO> list = personstatemgrMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PersonStateMgr-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PersonStateMgr" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/personstatemgrs/searchdefault")
	public ResponseEntity<Page<PersonStateMgrDTO>> searchDefault(@RequestBody PersonStateMgrSearchContext context) {
        Page<PersonStateMgr> domains = personstatemgrService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(personstatemgrMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

