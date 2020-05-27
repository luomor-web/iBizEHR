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
import cn.ibizlab.ehr.core.par.domain.PARJXBZGLMX;
import cn.ibizlab.ehr.core.par.service.IPARJXBZGLMXService;
import cn.ibizlab.ehr.core.par.filter.PARJXBZGLMXSearchContext;

@Slf4j
@Api(tags = {"PARJXBZGLMX" })
@RestController("WebApi-parjxbzglmx")
@RequestMapping("")
public class PARJXBZGLMXResource {

    @Autowired
    public IPARJXBZGLMXService parjxbzglmxService;

    @Autowired
    @Lazy
    public PARJXBZGLMXMapping parjxbzglmxMapping;

    @PreAuthorize("hasPermission(this.parjxbzglmxService.get(#parjxbzglmx_id),'ehr-PARJXBZGLMX-Update')")
    @ApiOperation(value = "Update", tags = {"PARJXBZGLMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxbzglmxes/{parjxbzglmx_id}")
    @Transactional
    public ResponseEntity<PARJXBZGLMXDTO> update(@PathVariable("parjxbzglmx_id") String parjxbzglmx_id, @RequestBody PARJXBZGLMXDTO parjxbzglmxdto) {
		PARJXBZGLMX domain  = parjxbzglmxMapping.toDomain(parjxbzglmxdto);
        domain .setParjxbzglmxid(parjxbzglmx_id);
		parjxbzglmxService.update(domain );
		PARJXBZGLMXDTO dto = parjxbzglmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxService.getParjxbzglmxByEntities(this.parjxbzglmxMapping.toDomain(#parjxbzglmxdtos)),'ehr-PARJXBZGLMX-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PARJXBZGLMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxbzglmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARJXBZGLMXDTO> parjxbzglmxdtos) {
        parjxbzglmxService.updateBatch(parjxbzglmxMapping.toDomain(parjxbzglmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxMapping.toDomain(#parjxbzglmxdto),'ehr-PARJXBZGLMX-Save')")
    @ApiOperation(value = "Save", tags = {"PARJXBZGLMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzglmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PARJXBZGLMXDTO parjxbzglmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parjxbzglmxService.save(parjxbzglmxMapping.toDomain(parjxbzglmxdto)));
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxMapping.toDomain(#parjxbzglmxdtos),'ehr-PARJXBZGLMX-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PARJXBZGLMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzglmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARJXBZGLMXDTO> parjxbzglmxdtos) {
        parjxbzglmxService.saveBatch(parjxbzglmxMapping.toDomain(parjxbzglmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parjxbzglmxMapping.toDomain(returnObject.body),'ehr-PARJXBZGLMX-Get')")
    @ApiOperation(value = "Get", tags = {"PARJXBZGLMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxbzglmxes/{parjxbzglmx_id}")
    public ResponseEntity<PARJXBZGLMXDTO> get(@PathVariable("parjxbzglmx_id") String parjxbzglmx_id) {
        PARJXBZGLMX domain = parjxbzglmxService.get(parjxbzglmx_id);
        PARJXBZGLMXDTO dto = parjxbzglmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxService.get(#parjxbzglmx_id),'ehr-PARJXBZGLMX-Remove')")
    @ApiOperation(value = "Remove", tags = {"PARJXBZGLMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxbzglmxes/{parjxbzglmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parjxbzglmx_id") String parjxbzglmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parjxbzglmxService.remove(parjxbzglmx_id));
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxService.getParjxbzglmxByIds(#ids),'ehr-PARJXBZGLMX-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PARJXBZGLMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxbzglmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parjxbzglmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxMapping.toDomain(#parjxbzglmxdto),'ehr-PARJXBZGLMX-Create')")
    @ApiOperation(value = "Create", tags = {"PARJXBZGLMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzglmxes")
    @Transactional
    public ResponseEntity<PARJXBZGLMXDTO> create(@RequestBody PARJXBZGLMXDTO parjxbzglmxdto) {
        PARJXBZGLMX domain = parjxbzglmxMapping.toDomain(parjxbzglmxdto);
		parjxbzglmxService.create(domain);
        PARJXBZGLMXDTO dto = parjxbzglmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxMapping.toDomain(#parjxbzglmxdtos),'ehr-PARJXBZGLMX-Create')")
    @ApiOperation(value = "createBatch", tags = {"PARJXBZGLMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzglmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARJXBZGLMXDTO> parjxbzglmxdtos) {
        parjxbzglmxService.createBatch(parjxbzglmxMapping.toDomain(parjxbzglmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"PARJXBZGLMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxbzglmxes/getdraft")
    public ResponseEntity<PARJXBZGLMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parjxbzglmxMapping.toDto(parjxbzglmxService.getDraft(new PARJXBZGLMX())));
    }

    @ApiOperation(value = "CheckKey", tags = {"PARJXBZGLMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzglmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARJXBZGLMXDTO parjxbzglmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parjxbzglmxService.checkKey(parjxbzglmxMapping.toDomain(parjxbzglmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXBZGLMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PARJXBZGLMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parjxbzglmxes/fetchdefault")
	public ResponseEntity<List<PARJXBZGLMXDTO>> fetchDefault(PARJXBZGLMXSearchContext context) {
        Page<PARJXBZGLMX> domains = parjxbzglmxService.searchDefault(context) ;
        List<PARJXBZGLMXDTO> list = parjxbzglmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXBZGLMX-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PARJXBZGLMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parjxbzglmxes/searchdefault")
	public ResponseEntity<Page<PARJXBZGLMXDTO>> searchDefault(@RequestBody PARJXBZGLMXSearchContext context) {
        Page<PARJXBZGLMX> domains = parjxbzglmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjxbzglmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.parjxbzglmxService.get(#parjxbzglmx_id),'ehr-PARJXBZGLMX-Update')")
    @ApiOperation(value = "UpdateByPARJXBZGL", tags = {"PARJXBZGLMX" },  notes = "UpdateByPARJXBZGL")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxbzgls/{parjxbzgl_id}/parjxbzglmxes/{parjxbzglmx_id}")
    @Transactional
    public ResponseEntity<PARJXBZGLMXDTO> updateByPARJXBZGL(@PathVariable("parjxbzgl_id") String parjxbzgl_id, @PathVariable("parjxbzglmx_id") String parjxbzglmx_id, @RequestBody PARJXBZGLMXDTO parjxbzglmxdto) {
        PARJXBZGLMX domain = parjxbzglmxMapping.toDomain(parjxbzglmxdto);
        domain.setParjxbzglid(parjxbzgl_id);
        domain.setParjxbzglmxid(parjxbzglmx_id);
		parjxbzglmxService.update(domain);
        PARJXBZGLMXDTO dto = parjxbzglmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxService.getParjxbzglmxByEntities(this.parjxbzglmxMapping.toDomain(#parjxbzglmxdtos)),'ehr-PARJXBZGLMX-Update')")
    @ApiOperation(value = "UpdateBatchByPARJXBZGL", tags = {"PARJXBZGLMX" },  notes = "UpdateBatchByPARJXBZGL")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxbzgls/{parjxbzgl_id}/parjxbzglmxes/batch")
    public ResponseEntity<Boolean> updateBatchByPARJXBZGL(@PathVariable("parjxbzgl_id") String parjxbzgl_id, @RequestBody List<PARJXBZGLMXDTO> parjxbzglmxdtos) {
        List<PARJXBZGLMX> domainlist=parjxbzglmxMapping.toDomain(parjxbzglmxdtos);
        for(PARJXBZGLMX domain:domainlist){
            domain.setParjxbzglid(parjxbzgl_id);
        }
        parjxbzglmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxMapping.toDomain(#parjxbzglmxdto),'ehr-PARJXBZGLMX-Save')")
    @ApiOperation(value = "SaveByPARJXBZGL", tags = {"PARJXBZGLMX" },  notes = "SaveByPARJXBZGL")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzgls/{parjxbzgl_id}/parjxbzglmxes/save")
    public ResponseEntity<Boolean> saveByPARJXBZGL(@PathVariable("parjxbzgl_id") String parjxbzgl_id, @RequestBody PARJXBZGLMXDTO parjxbzglmxdto) {
        PARJXBZGLMX domain = parjxbzglmxMapping.toDomain(parjxbzglmxdto);
        domain.setParjxbzglid(parjxbzgl_id);
        return ResponseEntity.status(HttpStatus.OK).body(parjxbzglmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxMapping.toDomain(#parjxbzglmxdtos),'ehr-PARJXBZGLMX-Save')")
    @ApiOperation(value = "SaveBatchByPARJXBZGL", tags = {"PARJXBZGLMX" },  notes = "SaveBatchByPARJXBZGL")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzgls/{parjxbzgl_id}/parjxbzglmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPARJXBZGL(@PathVariable("parjxbzgl_id") String parjxbzgl_id, @RequestBody List<PARJXBZGLMXDTO> parjxbzglmxdtos) {
        List<PARJXBZGLMX> domainlist=parjxbzglmxMapping.toDomain(parjxbzglmxdtos);
        for(PARJXBZGLMX domain:domainlist){
             domain.setParjxbzglid(parjxbzgl_id);
        }
        parjxbzglmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parjxbzglmxMapping.toDomain(returnObject.body),'ehr-PARJXBZGLMX-Get')")
    @ApiOperation(value = "GetByPARJXBZGL", tags = {"PARJXBZGLMX" },  notes = "GetByPARJXBZGL")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxbzgls/{parjxbzgl_id}/parjxbzglmxes/{parjxbzglmx_id}")
    public ResponseEntity<PARJXBZGLMXDTO> getByPARJXBZGL(@PathVariable("parjxbzgl_id") String parjxbzgl_id, @PathVariable("parjxbzglmx_id") String parjxbzglmx_id) {
        PARJXBZGLMX domain = parjxbzglmxService.get(parjxbzglmx_id);
        PARJXBZGLMXDTO dto = parjxbzglmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxService.get(#parjxbzglmx_id),'ehr-PARJXBZGLMX-Remove')")
    @ApiOperation(value = "RemoveByPARJXBZGL", tags = {"PARJXBZGLMX" },  notes = "RemoveByPARJXBZGL")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxbzgls/{parjxbzgl_id}/parjxbzglmxes/{parjxbzglmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPARJXBZGL(@PathVariable("parjxbzgl_id") String parjxbzgl_id, @PathVariable("parjxbzglmx_id") String parjxbzglmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(parjxbzglmxService.remove(parjxbzglmx_id));
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxService.getParjxbzglmxByIds(#ids),'ehr-PARJXBZGLMX-Remove')")
    @ApiOperation(value = "RemoveBatchByPARJXBZGL", tags = {"PARJXBZGLMX" },  notes = "RemoveBatchByPARJXBZGL")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxbzgls/{parjxbzgl_id}/parjxbzglmxes/batch")
    public ResponseEntity<Boolean> removeBatchByPARJXBZGL(@RequestBody List<String> ids) {
        parjxbzglmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxMapping.toDomain(#parjxbzglmxdto),'ehr-PARJXBZGLMX-Create')")
    @ApiOperation(value = "CreateByPARJXBZGL", tags = {"PARJXBZGLMX" },  notes = "CreateByPARJXBZGL")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzgls/{parjxbzgl_id}/parjxbzglmxes")
    @Transactional
    public ResponseEntity<PARJXBZGLMXDTO> createByPARJXBZGL(@PathVariable("parjxbzgl_id") String parjxbzgl_id, @RequestBody PARJXBZGLMXDTO parjxbzglmxdto) {
        PARJXBZGLMX domain = parjxbzglmxMapping.toDomain(parjxbzglmxdto);
        domain.setParjxbzglid(parjxbzgl_id);
		parjxbzglmxService.create(domain);
        PARJXBZGLMXDTO dto = parjxbzglmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxMapping.toDomain(#parjxbzglmxdtos),'ehr-PARJXBZGLMX-Create')")
    @ApiOperation(value = "createBatchByPARJXBZGL", tags = {"PARJXBZGLMX" },  notes = "createBatchByPARJXBZGL")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzgls/{parjxbzgl_id}/parjxbzglmxes/batch")
    public ResponseEntity<Boolean> createBatchByPARJXBZGL(@PathVariable("parjxbzgl_id") String parjxbzgl_id, @RequestBody List<PARJXBZGLMXDTO> parjxbzglmxdtos) {
        List<PARJXBZGLMX> domainlist=parjxbzglmxMapping.toDomain(parjxbzglmxdtos);
        for(PARJXBZGLMX domain:domainlist){
            domain.setParjxbzglid(parjxbzgl_id);
        }
        parjxbzglmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPARJXBZGL", tags = {"PARJXBZGLMX" },  notes = "GetDraftByPARJXBZGL")
    @RequestMapping(method = RequestMethod.GET, value = "/parjxbzgls/{parjxbzgl_id}/parjxbzglmxes/getdraft")
    public ResponseEntity<PARJXBZGLMXDTO> getDraftByPARJXBZGL(@PathVariable("parjxbzgl_id") String parjxbzgl_id) {
        PARJXBZGLMX domain = new PARJXBZGLMX();
        domain.setParjxbzglid(parjxbzgl_id);
        return ResponseEntity.status(HttpStatus.OK).body(parjxbzglmxMapping.toDto(parjxbzglmxService.getDraft(domain)));
    }

    @ApiOperation(value = "CheckKeyByPARJXBZGL", tags = {"PARJXBZGLMX" },  notes = "CheckKeyByPARJXBZGL")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzgls/{parjxbzgl_id}/parjxbzglmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPARJXBZGL(@PathVariable("parjxbzgl_id") String parjxbzgl_id, @RequestBody PARJXBZGLMXDTO parjxbzglmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parjxbzglmxService.checkKey(parjxbzglmxMapping.toDomain(parjxbzglmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXBZGLMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPARJXBZGL", tags = {"PARJXBZGLMX" } ,notes = "fetchDEFAULTByPARJXBZGL")
    @RequestMapping(method= RequestMethod.GET , value="/parjxbzgls/{parjxbzgl_id}/parjxbzglmxes/fetchdefault")
	public ResponseEntity<List<PARJXBZGLMXDTO>> fetchPARJXBZGLMXDefaultByPARJXBZGL(@PathVariable("parjxbzgl_id") String parjxbzgl_id,PARJXBZGLMXSearchContext context) {
        context.setN_parjxbzglid_eq(parjxbzgl_id);
        Page<PARJXBZGLMX> domains = parjxbzglmxService.searchDefault(context) ;
        List<PARJXBZGLMXDTO> list = parjxbzglmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXBZGLMX-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPARJXBZGL", tags = {"PARJXBZGLMX" } ,notes = "searchDEFAULTByPARJXBZGL")
    @RequestMapping(method= RequestMethod.POST , value="/parjxbzgls/{parjxbzgl_id}/parjxbzglmxes/searchdefault")
	public ResponseEntity<Page<PARJXBZGLMXDTO>> searchPARJXBZGLMXDefaultByPARJXBZGL(@PathVariable("parjxbzgl_id") String parjxbzgl_id, @RequestBody PARJXBZGLMXSearchContext context) {
        context.setN_parjxbzglid_eq(parjxbzgl_id);
        Page<PARJXBZGLMX> domains = parjxbzglmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjxbzglmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.parjxbzglmxService.get(#parjxbzglmx_id),'ehr-PARJXBZGLMX-Update')")
    @ApiOperation(value = "UpdateByPIMPERSON", tags = {"PARJXBZGLMX" },  notes = "UpdateByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/parjxbzglmxes/{parjxbzglmx_id}")
    @Transactional
    public ResponseEntity<PARJXBZGLMXDTO> updateByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("parjxbzglmx_id") String parjxbzglmx_id, @RequestBody PARJXBZGLMXDTO parjxbzglmxdto) {
        PARJXBZGLMX domain = parjxbzglmxMapping.toDomain(parjxbzglmxdto);
        domain.setPimpersonid(pimperson_id);
        domain.setParjxbzglmxid(parjxbzglmx_id);
		parjxbzglmxService.update(domain);
        PARJXBZGLMXDTO dto = parjxbzglmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxService.getParjxbzglmxByEntities(this.parjxbzglmxMapping.toDomain(#parjxbzglmxdtos)),'ehr-PARJXBZGLMX-Update')")
    @ApiOperation(value = "UpdateBatchByPIMPERSON", tags = {"PARJXBZGLMX" },  notes = "UpdateBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/parjxbzglmxes/batch")
    public ResponseEntity<Boolean> updateBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PARJXBZGLMXDTO> parjxbzglmxdtos) {
        List<PARJXBZGLMX> domainlist=parjxbzglmxMapping.toDomain(parjxbzglmxdtos);
        for(PARJXBZGLMX domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        parjxbzglmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxMapping.toDomain(#parjxbzglmxdto),'ehr-PARJXBZGLMX-Save')")
    @ApiOperation(value = "SaveByPIMPERSON", tags = {"PARJXBZGLMX" },  notes = "SaveByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/parjxbzglmxes/save")
    public ResponseEntity<Boolean> saveByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PARJXBZGLMXDTO parjxbzglmxdto) {
        PARJXBZGLMX domain = parjxbzglmxMapping.toDomain(parjxbzglmxdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(parjxbzglmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxMapping.toDomain(#parjxbzglmxdtos),'ehr-PARJXBZGLMX-Save')")
    @ApiOperation(value = "SaveBatchByPIMPERSON", tags = {"PARJXBZGLMX" },  notes = "SaveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/parjxbzglmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PARJXBZGLMXDTO> parjxbzglmxdtos) {
        List<PARJXBZGLMX> domainlist=parjxbzglmxMapping.toDomain(parjxbzglmxdtos);
        for(PARJXBZGLMX domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        parjxbzglmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parjxbzglmxMapping.toDomain(returnObject.body),'ehr-PARJXBZGLMX-Get')")
    @ApiOperation(value = "GetByPIMPERSON", tags = {"PARJXBZGLMX" },  notes = "GetByPIMPERSON")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/parjxbzglmxes/{parjxbzglmx_id}")
    public ResponseEntity<PARJXBZGLMXDTO> getByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("parjxbzglmx_id") String parjxbzglmx_id) {
        PARJXBZGLMX domain = parjxbzglmxService.get(parjxbzglmx_id);
        PARJXBZGLMXDTO dto = parjxbzglmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxService.get(#parjxbzglmx_id),'ehr-PARJXBZGLMX-Remove')")
    @ApiOperation(value = "RemoveByPIMPERSON", tags = {"PARJXBZGLMX" },  notes = "RemoveByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/parjxbzglmxes/{parjxbzglmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("parjxbzglmx_id") String parjxbzglmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(parjxbzglmxService.remove(parjxbzglmx_id));
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxService.getParjxbzglmxByIds(#ids),'ehr-PARJXBZGLMX-Remove')")
    @ApiOperation(value = "RemoveBatchByPIMPERSON", tags = {"PARJXBZGLMX" },  notes = "RemoveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/parjxbzglmxes/batch")
    public ResponseEntity<Boolean> removeBatchByPIMPERSON(@RequestBody List<String> ids) {
        parjxbzglmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxMapping.toDomain(#parjxbzglmxdto),'ehr-PARJXBZGLMX-Create')")
    @ApiOperation(value = "CreateByPIMPERSON", tags = {"PARJXBZGLMX" },  notes = "CreateByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/parjxbzglmxes")
    @Transactional
    public ResponseEntity<PARJXBZGLMXDTO> createByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PARJXBZGLMXDTO parjxbzglmxdto) {
        PARJXBZGLMX domain = parjxbzglmxMapping.toDomain(parjxbzglmxdto);
        domain.setPimpersonid(pimperson_id);
		parjxbzglmxService.create(domain);
        PARJXBZGLMXDTO dto = parjxbzglmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxMapping.toDomain(#parjxbzglmxdtos),'ehr-PARJXBZGLMX-Create')")
    @ApiOperation(value = "createBatchByPIMPERSON", tags = {"PARJXBZGLMX" },  notes = "createBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/parjxbzglmxes/batch")
    public ResponseEntity<Boolean> createBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PARJXBZGLMXDTO> parjxbzglmxdtos) {
        List<PARJXBZGLMX> domainlist=parjxbzglmxMapping.toDomain(parjxbzglmxdtos);
        for(PARJXBZGLMX domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        parjxbzglmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPIMPERSON", tags = {"PARJXBZGLMX" },  notes = "GetDraftByPIMPERSON")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/parjxbzglmxes/getdraft")
    public ResponseEntity<PARJXBZGLMXDTO> getDraftByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id) {
        PARJXBZGLMX domain = new PARJXBZGLMX();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(parjxbzglmxMapping.toDto(parjxbzglmxService.getDraft(domain)));
    }

    @ApiOperation(value = "CheckKeyByPIMPERSON", tags = {"PARJXBZGLMX" },  notes = "CheckKeyByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/parjxbzglmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PARJXBZGLMXDTO parjxbzglmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parjxbzglmxService.checkKey(parjxbzglmxMapping.toDomain(parjxbzglmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXBZGLMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPIMPERSON", tags = {"PARJXBZGLMX" } ,notes = "fetchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/parjxbzglmxes/fetchdefault")
	public ResponseEntity<List<PARJXBZGLMXDTO>> fetchPARJXBZGLMXDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PARJXBZGLMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PARJXBZGLMX> domains = parjxbzglmxService.searchDefault(context) ;
        List<PARJXBZGLMXDTO> list = parjxbzglmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXBZGLMX-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPIMPERSON", tags = {"PARJXBZGLMX" } ,notes = "searchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/parjxbzglmxes/searchdefault")
	public ResponseEntity<Page<PARJXBZGLMXDTO>> searchPARJXBZGLMXDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PARJXBZGLMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PARJXBZGLMX> domains = parjxbzglmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjxbzglmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

