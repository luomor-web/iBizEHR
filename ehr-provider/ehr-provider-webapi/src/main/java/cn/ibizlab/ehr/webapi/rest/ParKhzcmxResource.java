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
import cn.ibizlab.ehr.core.par.domain.ParKhzcmx;
import cn.ibizlab.ehr.core.par.service.IParKhzcmxService;
import cn.ibizlab.ehr.core.par.filter.ParKhzcmxSearchContext;

@Slf4j
@Api(tags = {"ParKhzcmx" })
@RestController("WebApi-parkhzcmx")
@RequestMapping("")
public class ParKhzcmxResource {

    @Autowired
    public IParKhzcmxService parkhzcmxService;

    @Autowired
    @Lazy
    public ParKhzcmxMapping parkhzcmxMapping;

    @PreAuthorize("hasPermission(this.parkhzcmxMapping.toDomain(#parkhzcmxdto),'ehr-ParKhzcmx-Create')")
    @ApiOperation(value = "Create", tags = {"ParKhzcmx" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parkhzcmxes")
    @Transactional
    public ResponseEntity<ParKhzcmxDTO> create(@RequestBody ParKhzcmxDTO parkhzcmxdto) {
        ParKhzcmx domain = parkhzcmxMapping.toDomain(parkhzcmxdto);
		parkhzcmxService.create(domain);
        ParKhzcmxDTO dto = parkhzcmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parkhzcmxMapping.toDomain(#parkhzcmxdtos),'ehr-ParKhzcmx-Create')")
    @ApiOperation(value = "createBatch", tags = {"ParKhzcmx" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parkhzcmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParKhzcmxDTO> parkhzcmxdtos) {
        parkhzcmxService.createBatch(parkhzcmxMapping.toDomain(parkhzcmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parkhzcmxMapping.toDomain(#parkhzcmxdto),'ehr-ParKhzcmx-Save')")
    @ApiOperation(value = "Save", tags = {"ParKhzcmx" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parkhzcmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody ParKhzcmxDTO parkhzcmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parkhzcmxService.save(parkhzcmxMapping.toDomain(parkhzcmxdto)));
    }

    @PreAuthorize("hasPermission(this.parkhzcmxMapping.toDomain(#parkhzcmxdtos),'ehr-ParKhzcmx-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"ParKhzcmx" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parkhzcmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParKhzcmxDTO> parkhzcmxdtos) {
        parkhzcmxService.saveBatch(parkhzcmxMapping.toDomain(parkhzcmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parkhzcmxMapping.toDomain(returnObject.body),'ehr-ParKhzcmx-Get')")
    @ApiOperation(value = "Get", tags = {"ParKhzcmx" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parkhzcmxes/{parkhzcmx_id}")
    public ResponseEntity<ParKhzcmxDTO> get(@PathVariable("parkhzcmx_id") String parkhzcmx_id) {
        ParKhzcmx domain = parkhzcmxService.get(parkhzcmx_id);
        ParKhzcmxDTO dto = parkhzcmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "GetDraft", tags = {"ParKhzcmx" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parkhzcmxes/getdraft")
    public ResponseEntity<ParKhzcmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parkhzcmxMapping.toDto(parkhzcmxService.getDraft(new ParKhzcmx())));
    }

    @PreAuthorize("hasPermission(this.parkhzcmxService.get(#parkhzcmx_id),'ehr-ParKhzcmx-Remove')")
    @ApiOperation(value = "Remove", tags = {"ParKhzcmx" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parkhzcmxes/{parkhzcmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parkhzcmx_id") String parkhzcmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parkhzcmxService.remove(parkhzcmx_id));
    }

    @PreAuthorize("hasPermission(this.parkhzcmxService.getParkhzcmxByIds(#ids),'ehr-ParKhzcmx-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"ParKhzcmx" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parkhzcmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parkhzcmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"ParKhzcmx" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parkhzcmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParKhzcmxDTO parkhzcmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parkhzcmxService.checkKey(parkhzcmxMapping.toDomain(parkhzcmxdto)));
    }

    @PreAuthorize("hasPermission(this.parkhzcmxService.get(#parkhzcmx_id),'ehr-ParKhzcmx-Update')")
    @ApiOperation(value = "Update", tags = {"ParKhzcmx" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parkhzcmxes/{parkhzcmx_id}")
    @Transactional
    public ResponseEntity<ParKhzcmxDTO> update(@PathVariable("parkhzcmx_id") String parkhzcmx_id, @RequestBody ParKhzcmxDTO parkhzcmxdto) {
		ParKhzcmx domain  = parkhzcmxMapping.toDomain(parkhzcmxdto);
        domain .setParkhzcmxid(parkhzcmx_id);
		parkhzcmxService.update(domain );
		ParKhzcmxDTO dto = parkhzcmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parkhzcmxService.getParkhzcmxByEntities(this.parkhzcmxMapping.toDomain(#parkhzcmxdtos)),'ehr-ParKhzcmx-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"ParKhzcmx" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parkhzcmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParKhzcmxDTO> parkhzcmxdtos) {
        parkhzcmxService.updateBatch(parkhzcmxMapping.toDomain(parkhzcmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParKhzcmx-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ParKhzcmx" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parkhzcmxes/fetchdefault")
	public ResponseEntity<List<ParKhzcmxDTO>> fetchDefault(ParKhzcmxSearchContext context) {
        Page<ParKhzcmx> domains = parkhzcmxService.searchDefault(context) ;
        List<ParKhzcmxDTO> list = parkhzcmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParKhzcmx-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ParKhzcmx" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parkhzcmxes/searchdefault")
	public ResponseEntity<Page<ParKhzcmxDTO>> searchDefault(@RequestBody ParKhzcmxSearchContext context) {
        Page<ParKhzcmx> domains = parkhzcmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parkhzcmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.parkhzcmxMapping.toDomain(#parkhzcmxdto),'ehr-ParKhzcmx-Create')")
    @ApiOperation(value = "CreateByPARJXKHJCSZ", tags = {"ParKhzcmx" },  notes = "CreateByPARJXKHJCSZ")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhjcszs/{parjxkhjcsz_id}/parkhzcmxes")
    @Transactional
    public ResponseEntity<ParKhzcmxDTO> createByPARJXKHJCSZ(@PathVariable("parjxkhjcsz_id") String parjxkhjcsz_id, @RequestBody ParKhzcmxDTO parkhzcmxdto) {
        ParKhzcmx domain = parkhzcmxMapping.toDomain(parkhzcmxdto);
        domain.setParjxkhjcszid(parjxkhjcsz_id);
		parkhzcmxService.create(domain);
        ParKhzcmxDTO dto = parkhzcmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parkhzcmxMapping.toDomain(#parkhzcmxdtos),'ehr-ParKhzcmx-Create')")
    @ApiOperation(value = "createBatchByPARJXKHJCSZ", tags = {"ParKhzcmx" },  notes = "createBatchByPARJXKHJCSZ")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhjcszs/{parjxkhjcsz_id}/parkhzcmxes/batch")
    public ResponseEntity<Boolean> createBatchByPARJXKHJCSZ(@PathVariable("parjxkhjcsz_id") String parjxkhjcsz_id, @RequestBody List<ParKhzcmxDTO> parkhzcmxdtos) {
        List<ParKhzcmx> domainlist=parkhzcmxMapping.toDomain(parkhzcmxdtos);
        for(ParKhzcmx domain:domainlist){
            domain.setParjxkhjcszid(parjxkhjcsz_id);
        }
        parkhzcmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parkhzcmxMapping.toDomain(#parkhzcmxdto),'ehr-ParKhzcmx-Save')")
    @ApiOperation(value = "SaveByPARJXKHJCSZ", tags = {"ParKhzcmx" },  notes = "SaveByPARJXKHJCSZ")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhjcszs/{parjxkhjcsz_id}/parkhzcmxes/save")
    public ResponseEntity<Boolean> saveByPARJXKHJCSZ(@PathVariable("parjxkhjcsz_id") String parjxkhjcsz_id, @RequestBody ParKhzcmxDTO parkhzcmxdto) {
        ParKhzcmx domain = parkhzcmxMapping.toDomain(parkhzcmxdto);
        domain.setParjxkhjcszid(parjxkhjcsz_id);
        return ResponseEntity.status(HttpStatus.OK).body(parkhzcmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.parkhzcmxMapping.toDomain(#parkhzcmxdtos),'ehr-ParKhzcmx-Save')")
    @ApiOperation(value = "SaveBatchByPARJXKHJCSZ", tags = {"ParKhzcmx" },  notes = "SaveBatchByPARJXKHJCSZ")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhjcszs/{parjxkhjcsz_id}/parkhzcmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPARJXKHJCSZ(@PathVariable("parjxkhjcsz_id") String parjxkhjcsz_id, @RequestBody List<ParKhzcmxDTO> parkhzcmxdtos) {
        List<ParKhzcmx> domainlist=parkhzcmxMapping.toDomain(parkhzcmxdtos);
        for(ParKhzcmx domain:domainlist){
             domain.setParjxkhjcszid(parjxkhjcsz_id);
        }
        parkhzcmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parkhzcmxMapping.toDomain(returnObject.body),'ehr-ParKhzcmx-Get')")
    @ApiOperation(value = "GetByPARJXKHJCSZ", tags = {"ParKhzcmx" },  notes = "GetByPARJXKHJCSZ")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxkhjcszs/{parjxkhjcsz_id}/parkhzcmxes/{parkhzcmx_id}")
    public ResponseEntity<ParKhzcmxDTO> getByPARJXKHJCSZ(@PathVariable("parjxkhjcsz_id") String parjxkhjcsz_id, @PathVariable("parkhzcmx_id") String parkhzcmx_id) {
        ParKhzcmx domain = parkhzcmxService.get(parkhzcmx_id);
        ParKhzcmxDTO dto = parkhzcmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "GetDraftByPARJXKHJCSZ", tags = {"ParKhzcmx" },  notes = "GetDraftByPARJXKHJCSZ")
    @RequestMapping(method = RequestMethod.GET, value = "/parjxkhjcszs/{parjxkhjcsz_id}/parkhzcmxes/getdraft")
    public ResponseEntity<ParKhzcmxDTO> getDraftByPARJXKHJCSZ(@PathVariable("parjxkhjcsz_id") String parjxkhjcsz_id) {
        ParKhzcmx domain = new ParKhzcmx();
        domain.setParjxkhjcszid(parjxkhjcsz_id);
        return ResponseEntity.status(HttpStatus.OK).body(parkhzcmxMapping.toDto(parkhzcmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.parkhzcmxService.get(#parkhzcmx_id),'ehr-ParKhzcmx-Remove')")
    @ApiOperation(value = "RemoveByPARJXKHJCSZ", tags = {"ParKhzcmx" },  notes = "RemoveByPARJXKHJCSZ")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxkhjcszs/{parjxkhjcsz_id}/parkhzcmxes/{parkhzcmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPARJXKHJCSZ(@PathVariable("parjxkhjcsz_id") String parjxkhjcsz_id, @PathVariable("parkhzcmx_id") String parkhzcmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(parkhzcmxService.remove(parkhzcmx_id));
    }

    @PreAuthorize("hasPermission(this.parkhzcmxService.getParkhzcmxByIds(#ids),'ehr-ParKhzcmx-Remove')")
    @ApiOperation(value = "RemoveBatchByPARJXKHJCSZ", tags = {"ParKhzcmx" },  notes = "RemoveBatchByPARJXKHJCSZ")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxkhjcszs/{parjxkhjcsz_id}/parkhzcmxes/batch")
    public ResponseEntity<Boolean> removeBatchByPARJXKHJCSZ(@RequestBody List<String> ids) {
        parkhzcmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByPARJXKHJCSZ", tags = {"ParKhzcmx" },  notes = "CheckKeyByPARJXKHJCSZ")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhjcszs/{parjxkhjcsz_id}/parkhzcmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPARJXKHJCSZ(@PathVariable("parjxkhjcsz_id") String parjxkhjcsz_id, @RequestBody ParKhzcmxDTO parkhzcmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parkhzcmxService.checkKey(parkhzcmxMapping.toDomain(parkhzcmxdto)));
    }

    @PreAuthorize("hasPermission(this.parkhzcmxService.get(#parkhzcmx_id),'ehr-ParKhzcmx-Update')")
    @ApiOperation(value = "UpdateByPARJXKHJCSZ", tags = {"ParKhzcmx" },  notes = "UpdateByPARJXKHJCSZ")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxkhjcszs/{parjxkhjcsz_id}/parkhzcmxes/{parkhzcmx_id}")
    @Transactional
    public ResponseEntity<ParKhzcmxDTO> updateByPARJXKHJCSZ(@PathVariable("parjxkhjcsz_id") String parjxkhjcsz_id, @PathVariable("parkhzcmx_id") String parkhzcmx_id, @RequestBody ParKhzcmxDTO parkhzcmxdto) {
        ParKhzcmx domain = parkhzcmxMapping.toDomain(parkhzcmxdto);
        domain.setParjxkhjcszid(parjxkhjcsz_id);
        domain.setParkhzcmxid(parkhzcmx_id);
		parkhzcmxService.update(domain);
        ParKhzcmxDTO dto = parkhzcmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parkhzcmxService.getParkhzcmxByEntities(this.parkhzcmxMapping.toDomain(#parkhzcmxdtos)),'ehr-ParKhzcmx-Update')")
    @ApiOperation(value = "UpdateBatchByPARJXKHJCSZ", tags = {"ParKhzcmx" },  notes = "UpdateBatchByPARJXKHJCSZ")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxkhjcszs/{parjxkhjcsz_id}/parkhzcmxes/batch")
    public ResponseEntity<Boolean> updateBatchByPARJXKHJCSZ(@PathVariable("parjxkhjcsz_id") String parjxkhjcsz_id, @RequestBody List<ParKhzcmxDTO> parkhzcmxdtos) {
        List<ParKhzcmx> domainlist=parkhzcmxMapping.toDomain(parkhzcmxdtos);
        for(ParKhzcmx domain:domainlist){
            domain.setParjxkhjcszid(parjxkhjcsz_id);
        }
        parkhzcmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParKhzcmx-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPARJXKHJCSZ", tags = {"ParKhzcmx" } ,notes = "fetchDEFAULTByPARJXKHJCSZ")
    @RequestMapping(method= RequestMethod.GET , value="/parjxkhjcszs/{parjxkhjcsz_id}/parkhzcmxes/fetchdefault")
	public ResponseEntity<List<ParKhzcmxDTO>> fetchParKhzcmxDefaultByPARJXKHJCSZ(@PathVariable("parjxkhjcsz_id") String parjxkhjcsz_id,ParKhzcmxSearchContext context) {
        context.setN_parjxkhjcszid_eq(parjxkhjcsz_id);
        Page<ParKhzcmx> domains = parkhzcmxService.searchDefault(context) ;
        List<ParKhzcmxDTO> list = parkhzcmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParKhzcmx-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPARJXKHJCSZ", tags = {"ParKhzcmx" } ,notes = "searchDEFAULTByPARJXKHJCSZ")
    @RequestMapping(method= RequestMethod.POST , value="/parjxkhjcszs/{parjxkhjcsz_id}/parkhzcmxes/searchdefault")
	public ResponseEntity<Page<ParKhzcmxDTO>> searchParKhzcmxDefaultByPARJXKHJCSZ(@PathVariable("parjxkhjcsz_id") String parjxkhjcsz_id, @RequestBody ParKhzcmxSearchContext context) {
        context.setN_parjxkhjcszid_eq(parjxkhjcsz_id);
        Page<ParKhzcmx> domains = parkhzcmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parkhzcmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

