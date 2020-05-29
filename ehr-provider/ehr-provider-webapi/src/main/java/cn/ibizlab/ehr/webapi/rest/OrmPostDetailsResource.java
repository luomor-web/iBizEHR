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
import cn.ibizlab.ehr.core.orm.domain.OrmPostDetails;
import cn.ibizlab.ehr.core.orm.service.IOrmPostDetailsService;
import cn.ibizlab.ehr.core.orm.filter.OrmPostDetailsSearchContext;

@Slf4j
@Api(tags = {"OrmPostDetails" })
@RestController("WebApi-ormpostdetails")
@RequestMapping("")
public class OrmPostDetailsResource {

    @Autowired
    public IOrmPostDetailsService ormpostdetailsService;

    @Autowired
    @Lazy
    public OrmPostDetailsMapping ormpostdetailsMapping;

    @PreAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdto),'ehr-OrmPostDetails-Create')")
    @ApiOperation(value = "Create", tags = {"OrmPostDetails" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostdetails")
    @Transactional
    public ResponseEntity<OrmPostDetailsDTO> create(@RequestBody OrmPostDetailsDTO ormpostdetailsdto) {
        OrmPostDetails domain = ormpostdetailsMapping.toDomain(ormpostdetailsdto);
		ormpostdetailsService.create(domain);
        OrmPostDetailsDTO dto = ormpostdetailsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdtos),'ehr-OrmPostDetails-Create')")
    @ApiOperation(value = "createBatch", tags = {"OrmPostDetails" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostdetails/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrmPostDetailsDTO> ormpostdetailsdtos) {
        ormpostdetailsService.createBatch(ormpostdetailsMapping.toDomain(ormpostdetailsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(returnObject.body),'ehr-OrmPostDetails-Get')")
    @ApiOperation(value = "Get", tags = {"OrmPostDetails" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormpostdetails/{ormpostdetails_id}")
    public ResponseEntity<OrmPostDetailsDTO> get(@PathVariable("ormpostdetails_id") String ormpostdetails_id) {
        OrmPostDetails domain = ormpostdetailsService.get(ormpostdetails_id);
        OrmPostDetailsDTO dto = ormpostdetailsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKey", tags = {"OrmPostDetails" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostdetails/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrmPostDetailsDTO ormpostdetailsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsService.checkKey(ormpostdetailsMapping.toDomain(ormpostdetailsdto)));
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsService.get(#ormpostdetails_id),'ehr-OrmPostDetails-Update')")
    @ApiOperation(value = "Update", tags = {"OrmPostDetails" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormpostdetails/{ormpostdetails_id}")
    @Transactional
    public ResponseEntity<OrmPostDetailsDTO> update(@PathVariable("ormpostdetails_id") String ormpostdetails_id, @RequestBody OrmPostDetailsDTO ormpostdetailsdto) {
		OrmPostDetails domain  = ormpostdetailsMapping.toDomain(ormpostdetailsdto);
        domain .setOrmpostdetailsid(ormpostdetails_id);
		ormpostdetailsService.update(domain );
		OrmPostDetailsDTO dto = ormpostdetailsMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsService.getOrmpostdetailsByEntities(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdtos)),'ehr-OrmPostDetails-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"OrmPostDetails" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormpostdetails/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrmPostDetailsDTO> ormpostdetailsdtos) {
        ormpostdetailsService.updateBatch(ormpostdetailsMapping.toDomain(ormpostdetailsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"OrmPostDetails" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormpostdetails/getdraft")
    public ResponseEntity<OrmPostDetailsDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsMapping.toDto(ormpostdetailsService.getDraft(new OrmPostDetails())));
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdto),'ehr-OrmPostDetails-Save')")
    @ApiOperation(value = "Save", tags = {"OrmPostDetails" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostdetails/save")
    public ResponseEntity<Boolean> save(@RequestBody OrmPostDetailsDTO ormpostdetailsdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsService.save(ormpostdetailsMapping.toDomain(ormpostdetailsdto)));
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdtos),'ehr-OrmPostDetails-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"OrmPostDetails" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostdetails/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrmPostDetailsDTO> ormpostdetailsdtos) {
        ormpostdetailsService.saveBatch(ormpostdetailsMapping.toDomain(ormpostdetailsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsService.get(#ormpostdetails_id),'ehr-OrmPostDetails-Remove')")
    @ApiOperation(value = "Remove", tags = {"OrmPostDetails" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormpostdetails/{ormpostdetails_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormpostdetails_id") String ormpostdetails_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsService.remove(ormpostdetails_id));
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsService.getOrmpostdetailsByIds(#ids),'ehr-OrmPostDetails-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"OrmPostDetails" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormpostdetails/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormpostdetailsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPostDetails-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"OrmPostDetails" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormpostdetails/fetchdefault")
	public ResponseEntity<List<OrmPostDetailsDTO>> fetchDefault(OrmPostDetailsSearchContext context) {
        Page<OrmPostDetails> domains = ormpostdetailsService.searchDefault(context) ;
        List<OrmPostDetailsDTO> list = ormpostdetailsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPostDetails-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"OrmPostDetails" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormpostdetails/searchdefault")
	public ResponseEntity<Page<OrmPostDetailsDTO>> searchDefault(@RequestBody OrmPostDetailsSearchContext context) {
        Page<OrmPostDetails> domains = ormpostdetailsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostdetailsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdto),'ehr-OrmPostDetails-Create')")
    @ApiOperation(value = "CreateByOrmPostLib", tags = {"OrmPostDetails" },  notes = "CreateByOrmPostLib")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostlibs/{ormpostlib_id}/ormpostdetails")
    @Transactional
    public ResponseEntity<OrmPostDetailsDTO> createByOrmPostLib(@PathVariable("ormpostlib_id") String ormpostlib_id, @RequestBody OrmPostDetailsDTO ormpostdetailsdto) {
        OrmPostDetails domain = ormpostdetailsMapping.toDomain(ormpostdetailsdto);
        domain.setOrmpostlibid(ormpostlib_id);
		ormpostdetailsService.create(domain);
        OrmPostDetailsDTO dto = ormpostdetailsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdtos),'ehr-OrmPostDetails-Create')")
    @ApiOperation(value = "createBatchByOrmPostLib", tags = {"OrmPostDetails" },  notes = "createBatchByOrmPostLib")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostlibs/{ormpostlib_id}/ormpostdetails/batch")
    public ResponseEntity<Boolean> createBatchByOrmPostLib(@PathVariable("ormpostlib_id") String ormpostlib_id, @RequestBody List<OrmPostDetailsDTO> ormpostdetailsdtos) {
        List<OrmPostDetails> domainlist=ormpostdetailsMapping.toDomain(ormpostdetailsdtos);
        for(OrmPostDetails domain:domainlist){
            domain.setOrmpostlibid(ormpostlib_id);
        }
        ormpostdetailsService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(returnObject.body),'ehr-OrmPostDetails-Get')")
    @ApiOperation(value = "GetByOrmPostLib", tags = {"OrmPostDetails" },  notes = "GetByOrmPostLib")
	@RequestMapping(method = RequestMethod.GET, value = "/ormpostlibs/{ormpostlib_id}/ormpostdetails/{ormpostdetails_id}")
    public ResponseEntity<OrmPostDetailsDTO> getByOrmPostLib(@PathVariable("ormpostlib_id") String ormpostlib_id, @PathVariable("ormpostdetails_id") String ormpostdetails_id) {
        OrmPostDetails domain = ormpostdetailsService.get(ormpostdetails_id);
        OrmPostDetailsDTO dto = ormpostdetailsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKeyByOrmPostLib", tags = {"OrmPostDetails" },  notes = "CheckKeyByOrmPostLib")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostlibs/{ormpostlib_id}/ormpostdetails/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmPostLib(@PathVariable("ormpostlib_id") String ormpostlib_id, @RequestBody OrmPostDetailsDTO ormpostdetailsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsService.checkKey(ormpostdetailsMapping.toDomain(ormpostdetailsdto)));
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsService.get(#ormpostdetails_id),'ehr-OrmPostDetails-Update')")
    @ApiOperation(value = "UpdateByOrmPostLib", tags = {"OrmPostDetails" },  notes = "UpdateByOrmPostLib")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormpostlibs/{ormpostlib_id}/ormpostdetails/{ormpostdetails_id}")
    @Transactional
    public ResponseEntity<OrmPostDetailsDTO> updateByOrmPostLib(@PathVariable("ormpostlib_id") String ormpostlib_id, @PathVariable("ormpostdetails_id") String ormpostdetails_id, @RequestBody OrmPostDetailsDTO ormpostdetailsdto) {
        OrmPostDetails domain = ormpostdetailsMapping.toDomain(ormpostdetailsdto);
        domain.setOrmpostlibid(ormpostlib_id);
        domain.setOrmpostdetailsid(ormpostdetails_id);
		ormpostdetailsService.update(domain);
        OrmPostDetailsDTO dto = ormpostdetailsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsService.getOrmpostdetailsByEntities(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdtos)),'ehr-OrmPostDetails-Update')")
    @ApiOperation(value = "UpdateBatchByOrmPostLib", tags = {"OrmPostDetails" },  notes = "UpdateBatchByOrmPostLib")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormpostlibs/{ormpostlib_id}/ormpostdetails/batch")
    public ResponseEntity<Boolean> updateBatchByOrmPostLib(@PathVariable("ormpostlib_id") String ormpostlib_id, @RequestBody List<OrmPostDetailsDTO> ormpostdetailsdtos) {
        List<OrmPostDetails> domainlist=ormpostdetailsMapping.toDomain(ormpostdetailsdtos);
        for(OrmPostDetails domain:domainlist){
            domain.setOrmpostlibid(ormpostlib_id);
        }
        ormpostdetailsService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByOrmPostLib", tags = {"OrmPostDetails" },  notes = "GetDraftByOrmPostLib")
    @RequestMapping(method = RequestMethod.GET, value = "/ormpostlibs/{ormpostlib_id}/ormpostdetails/getdraft")
    public ResponseEntity<OrmPostDetailsDTO> getDraftByOrmPostLib(@PathVariable("ormpostlib_id") String ormpostlib_id) {
        OrmPostDetails domain = new OrmPostDetails();
        domain.setOrmpostlibid(ormpostlib_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsMapping.toDto(ormpostdetailsService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdto),'ehr-OrmPostDetails-Save')")
    @ApiOperation(value = "SaveByOrmPostLib", tags = {"OrmPostDetails" },  notes = "SaveByOrmPostLib")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostlibs/{ormpostlib_id}/ormpostdetails/save")
    public ResponseEntity<Boolean> saveByOrmPostLib(@PathVariable("ormpostlib_id") String ormpostlib_id, @RequestBody OrmPostDetailsDTO ormpostdetailsdto) {
        OrmPostDetails domain = ormpostdetailsMapping.toDomain(ormpostdetailsdto);
        domain.setOrmpostlibid(ormpostlib_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdtos),'ehr-OrmPostDetails-Save')")
    @ApiOperation(value = "SaveBatchByOrmPostLib", tags = {"OrmPostDetails" },  notes = "SaveBatchByOrmPostLib")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostlibs/{ormpostlib_id}/ormpostdetails/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmPostLib(@PathVariable("ormpostlib_id") String ormpostlib_id, @RequestBody List<OrmPostDetailsDTO> ormpostdetailsdtos) {
        List<OrmPostDetails> domainlist=ormpostdetailsMapping.toDomain(ormpostdetailsdtos);
        for(OrmPostDetails domain:domainlist){
             domain.setOrmpostlibid(ormpostlib_id);
        }
        ormpostdetailsService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsService.get(#ormpostdetails_id),'ehr-OrmPostDetails-Remove')")
    @ApiOperation(value = "RemoveByOrmPostLib", tags = {"OrmPostDetails" },  notes = "RemoveByOrmPostLib")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormpostlibs/{ormpostlib_id}/ormpostdetails/{ormpostdetails_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmPostLib(@PathVariable("ormpostlib_id") String ormpostlib_id, @PathVariable("ormpostdetails_id") String ormpostdetails_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsService.remove(ormpostdetails_id));
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsService.getOrmpostdetailsByIds(#ids),'ehr-OrmPostDetails-Remove')")
    @ApiOperation(value = "RemoveBatchByOrmPostLib", tags = {"OrmPostDetails" },  notes = "RemoveBatchByOrmPostLib")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormpostlibs/{ormpostlib_id}/ormpostdetails/batch")
    public ResponseEntity<Boolean> removeBatchByOrmPostLib(@RequestBody List<String> ids) {
        ormpostdetailsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPostDetails-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByOrmPostLib", tags = {"OrmPostDetails" } ,notes = "fetchDEFAULTByOrmPostLib")
    @RequestMapping(method= RequestMethod.GET , value="/ormpostlibs/{ormpostlib_id}/ormpostdetails/fetchdefault")
	public ResponseEntity<List<OrmPostDetailsDTO>> fetchOrmPostDetailsDefaultByOrmPostLib(@PathVariable("ormpostlib_id") String ormpostlib_id,OrmPostDetailsSearchContext context) {
        context.setN_ormpostlibid_eq(ormpostlib_id);
        Page<OrmPostDetails> domains = ormpostdetailsService.searchDefault(context) ;
        List<OrmPostDetailsDTO> list = ormpostdetailsMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPostDetails-Default-all')")
	@ApiOperation(value = "searchDEFAULTByOrmPostLib", tags = {"OrmPostDetails" } ,notes = "searchDEFAULTByOrmPostLib")
    @RequestMapping(method= RequestMethod.POST , value="/ormpostlibs/{ormpostlib_id}/ormpostdetails/searchdefault")
	public ResponseEntity<Page<OrmPostDetailsDTO>> searchOrmPostDetailsDefaultByOrmPostLib(@PathVariable("ormpostlib_id") String ormpostlib_id, @RequestBody OrmPostDetailsSearchContext context) {
        context.setN_ormpostlibid_eq(ormpostlib_id);
        Page<OrmPostDetails> domains = ormpostdetailsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostdetailsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdto),'ehr-OrmPostDetails-Create')")
    @ApiOperation(value = "CreateByOrmPost", tags = {"OrmPostDetails" },  notes = "CreateByOrmPost")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/ormpostdetails")
    @Transactional
    public ResponseEntity<OrmPostDetailsDTO> createByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @RequestBody OrmPostDetailsDTO ormpostdetailsdto) {
        OrmPostDetails domain = ormpostdetailsMapping.toDomain(ormpostdetailsdto);
        domain.setOrmpostid(ormpost_id);
		ormpostdetailsService.create(domain);
        OrmPostDetailsDTO dto = ormpostdetailsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdtos),'ehr-OrmPostDetails-Create')")
    @ApiOperation(value = "createBatchByOrmPost", tags = {"OrmPostDetails" },  notes = "createBatchByOrmPost")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/ormpostdetails/batch")
    public ResponseEntity<Boolean> createBatchByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @RequestBody List<OrmPostDetailsDTO> ormpostdetailsdtos) {
        List<OrmPostDetails> domainlist=ormpostdetailsMapping.toDomain(ormpostdetailsdtos);
        for(OrmPostDetails domain:domainlist){
            domain.setOrmpostid(ormpost_id);
        }
        ormpostdetailsService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(returnObject.body),'ehr-OrmPostDetails-Get')")
    @ApiOperation(value = "GetByOrmPost", tags = {"OrmPostDetails" },  notes = "GetByOrmPost")
	@RequestMapping(method = RequestMethod.GET, value = "/ormposts/{ormpost_id}/ormpostdetails/{ormpostdetails_id}")
    public ResponseEntity<OrmPostDetailsDTO> getByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @PathVariable("ormpostdetails_id") String ormpostdetails_id) {
        OrmPostDetails domain = ormpostdetailsService.get(ormpostdetails_id);
        OrmPostDetailsDTO dto = ormpostdetailsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKeyByOrmPost", tags = {"OrmPostDetails" },  notes = "CheckKeyByOrmPost")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/ormpostdetails/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @RequestBody OrmPostDetailsDTO ormpostdetailsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsService.checkKey(ormpostdetailsMapping.toDomain(ormpostdetailsdto)));
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsService.get(#ormpostdetails_id),'ehr-OrmPostDetails-Update')")
    @ApiOperation(value = "UpdateByOrmPost", tags = {"OrmPostDetails" },  notes = "UpdateByOrmPost")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormposts/{ormpost_id}/ormpostdetails/{ormpostdetails_id}")
    @Transactional
    public ResponseEntity<OrmPostDetailsDTO> updateByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @PathVariable("ormpostdetails_id") String ormpostdetails_id, @RequestBody OrmPostDetailsDTO ormpostdetailsdto) {
        OrmPostDetails domain = ormpostdetailsMapping.toDomain(ormpostdetailsdto);
        domain.setOrmpostid(ormpost_id);
        domain.setOrmpostdetailsid(ormpostdetails_id);
		ormpostdetailsService.update(domain);
        OrmPostDetailsDTO dto = ormpostdetailsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsService.getOrmpostdetailsByEntities(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdtos)),'ehr-OrmPostDetails-Update')")
    @ApiOperation(value = "UpdateBatchByOrmPost", tags = {"OrmPostDetails" },  notes = "UpdateBatchByOrmPost")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormposts/{ormpost_id}/ormpostdetails/batch")
    public ResponseEntity<Boolean> updateBatchByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @RequestBody List<OrmPostDetailsDTO> ormpostdetailsdtos) {
        List<OrmPostDetails> domainlist=ormpostdetailsMapping.toDomain(ormpostdetailsdtos);
        for(OrmPostDetails domain:domainlist){
            domain.setOrmpostid(ormpost_id);
        }
        ormpostdetailsService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByOrmPost", tags = {"OrmPostDetails" },  notes = "GetDraftByOrmPost")
    @RequestMapping(method = RequestMethod.GET, value = "/ormposts/{ormpost_id}/ormpostdetails/getdraft")
    public ResponseEntity<OrmPostDetailsDTO> getDraftByOrmPost(@PathVariable("ormpost_id") String ormpost_id) {
        OrmPostDetails domain = new OrmPostDetails();
        domain.setOrmpostid(ormpost_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsMapping.toDto(ormpostdetailsService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdto),'ehr-OrmPostDetails-Save')")
    @ApiOperation(value = "SaveByOrmPost", tags = {"OrmPostDetails" },  notes = "SaveByOrmPost")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/ormpostdetails/save")
    public ResponseEntity<Boolean> saveByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @RequestBody OrmPostDetailsDTO ormpostdetailsdto) {
        OrmPostDetails domain = ormpostdetailsMapping.toDomain(ormpostdetailsdto);
        domain.setOrmpostid(ormpost_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdtos),'ehr-OrmPostDetails-Save')")
    @ApiOperation(value = "SaveBatchByOrmPost", tags = {"OrmPostDetails" },  notes = "SaveBatchByOrmPost")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/ormpostdetails/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @RequestBody List<OrmPostDetailsDTO> ormpostdetailsdtos) {
        List<OrmPostDetails> domainlist=ormpostdetailsMapping.toDomain(ormpostdetailsdtos);
        for(OrmPostDetails domain:domainlist){
             domain.setOrmpostid(ormpost_id);
        }
        ormpostdetailsService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsService.get(#ormpostdetails_id),'ehr-OrmPostDetails-Remove')")
    @ApiOperation(value = "RemoveByOrmPost", tags = {"OrmPostDetails" },  notes = "RemoveByOrmPost")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormposts/{ormpost_id}/ormpostdetails/{ormpostdetails_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @PathVariable("ormpostdetails_id") String ormpostdetails_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsService.remove(ormpostdetails_id));
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsService.getOrmpostdetailsByIds(#ids),'ehr-OrmPostDetails-Remove')")
    @ApiOperation(value = "RemoveBatchByOrmPost", tags = {"OrmPostDetails" },  notes = "RemoveBatchByOrmPost")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormposts/{ormpost_id}/ormpostdetails/batch")
    public ResponseEntity<Boolean> removeBatchByOrmPost(@RequestBody List<String> ids) {
        ormpostdetailsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPostDetails-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByOrmPost", tags = {"OrmPostDetails" } ,notes = "fetchDEFAULTByOrmPost")
    @RequestMapping(method= RequestMethod.GET , value="/ormposts/{ormpost_id}/ormpostdetails/fetchdefault")
	public ResponseEntity<List<OrmPostDetailsDTO>> fetchOrmPostDetailsDefaultByOrmPost(@PathVariable("ormpost_id") String ormpost_id,OrmPostDetailsSearchContext context) {
        context.setN_ormpostid_eq(ormpost_id);
        Page<OrmPostDetails> domains = ormpostdetailsService.searchDefault(context) ;
        List<OrmPostDetailsDTO> list = ormpostdetailsMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPostDetails-Default-all')")
	@ApiOperation(value = "searchDEFAULTByOrmPost", tags = {"OrmPostDetails" } ,notes = "searchDEFAULTByOrmPost")
    @RequestMapping(method= RequestMethod.POST , value="/ormposts/{ormpost_id}/ormpostdetails/searchdefault")
	public ResponseEntity<Page<OrmPostDetailsDTO>> searchOrmPostDetailsDefaultByOrmPost(@PathVariable("ormpost_id") String ormpost_id, @RequestBody OrmPostDetailsSearchContext context) {
        context.setN_ormpostid_eq(ormpost_id);
        Page<OrmPostDetails> domains = ormpostdetailsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostdetailsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdto),'ehr-OrmPostDetails-Create')")
    @ApiOperation(value = "CreateByOrmOrgOrmPost", tags = {"OrmPostDetails" },  notes = "CreateByOrmOrgOrmPost")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormpostdetails")
    @Transactional
    public ResponseEntity<OrmPostDetailsDTO> createByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody OrmPostDetailsDTO ormpostdetailsdto) {
        OrmPostDetails domain = ormpostdetailsMapping.toDomain(ormpostdetailsdto);
        domain.setOrmpostid(ormpost_id);
		ormpostdetailsService.create(domain);
        OrmPostDetailsDTO dto = ormpostdetailsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdtos),'ehr-OrmPostDetails-Create')")
    @ApiOperation(value = "createBatchByOrmOrgOrmPost", tags = {"OrmPostDetails" },  notes = "createBatchByOrmOrgOrmPost")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormpostdetails/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody List<OrmPostDetailsDTO> ormpostdetailsdtos) {
        List<OrmPostDetails> domainlist=ormpostdetailsMapping.toDomain(ormpostdetailsdtos);
        for(OrmPostDetails domain:domainlist){
            domain.setOrmpostid(ormpost_id);
        }
        ormpostdetailsService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(returnObject.body),'ehr-OrmPostDetails-Get')")
    @ApiOperation(value = "GetByOrmOrgOrmPost", tags = {"OrmPostDetails" },  notes = "GetByOrmOrgOrmPost")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormpostdetails/{ormpostdetails_id}")
    public ResponseEntity<OrmPostDetailsDTO> getByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @PathVariable("ormpostdetails_id") String ormpostdetails_id) {
        OrmPostDetails domain = ormpostdetailsService.get(ormpostdetails_id);
        OrmPostDetailsDTO dto = ormpostdetailsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKeyByOrmOrgOrmPost", tags = {"OrmPostDetails" },  notes = "CheckKeyByOrmOrgOrmPost")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormpostdetails/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody OrmPostDetailsDTO ormpostdetailsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsService.checkKey(ormpostdetailsMapping.toDomain(ormpostdetailsdto)));
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsService.get(#ormpostdetails_id),'ehr-OrmPostDetails-Update')")
    @ApiOperation(value = "UpdateByOrmOrgOrmPost", tags = {"OrmPostDetails" },  notes = "UpdateByOrmOrgOrmPost")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormpostdetails/{ormpostdetails_id}")
    @Transactional
    public ResponseEntity<OrmPostDetailsDTO> updateByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @PathVariable("ormpostdetails_id") String ormpostdetails_id, @RequestBody OrmPostDetailsDTO ormpostdetailsdto) {
        OrmPostDetails domain = ormpostdetailsMapping.toDomain(ormpostdetailsdto);
        domain.setOrmpostid(ormpost_id);
        domain.setOrmpostdetailsid(ormpostdetails_id);
		ormpostdetailsService.update(domain);
        OrmPostDetailsDTO dto = ormpostdetailsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsService.getOrmpostdetailsByEntities(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdtos)),'ehr-OrmPostDetails-Update')")
    @ApiOperation(value = "UpdateBatchByOrmOrgOrmPost", tags = {"OrmPostDetails" },  notes = "UpdateBatchByOrmOrgOrmPost")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormpostdetails/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody List<OrmPostDetailsDTO> ormpostdetailsdtos) {
        List<OrmPostDetails> domainlist=ormpostdetailsMapping.toDomain(ormpostdetailsdtos);
        for(OrmPostDetails domain:domainlist){
            domain.setOrmpostid(ormpost_id);
        }
        ormpostdetailsService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByOrmOrgOrmPost", tags = {"OrmPostDetails" },  notes = "GetDraftByOrmOrgOrmPost")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormpostdetails/getdraft")
    public ResponseEntity<OrmPostDetailsDTO> getDraftByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id) {
        OrmPostDetails domain = new OrmPostDetails();
        domain.setOrmpostid(ormpost_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsMapping.toDto(ormpostdetailsService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdto),'ehr-OrmPostDetails-Save')")
    @ApiOperation(value = "SaveByOrmOrgOrmPost", tags = {"OrmPostDetails" },  notes = "SaveByOrmOrgOrmPost")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormpostdetails/save")
    public ResponseEntity<Boolean> saveByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody OrmPostDetailsDTO ormpostdetailsdto) {
        OrmPostDetails domain = ormpostdetailsMapping.toDomain(ormpostdetailsdto);
        domain.setOrmpostid(ormpost_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsMapping.toDomain(#ormpostdetailsdtos),'ehr-OrmPostDetails-Save')")
    @ApiOperation(value = "SaveBatchByOrmOrgOrmPost", tags = {"OrmPostDetails" },  notes = "SaveBatchByOrmOrgOrmPost")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormpostdetails/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody List<OrmPostDetailsDTO> ormpostdetailsdtos) {
        List<OrmPostDetails> domainlist=ormpostdetailsMapping.toDomain(ormpostdetailsdtos);
        for(OrmPostDetails domain:domainlist){
             domain.setOrmpostid(ormpost_id);
        }
        ormpostdetailsService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsService.get(#ormpostdetails_id),'ehr-OrmPostDetails-Remove')")
    @ApiOperation(value = "RemoveByOrmOrgOrmPost", tags = {"OrmPostDetails" },  notes = "RemoveByOrmOrgOrmPost")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormpostdetails/{ormpostdetails_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @PathVariable("ormpostdetails_id") String ormpostdetails_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsService.remove(ormpostdetails_id));
    }

    @PreAuthorize("hasPermission(this.ormpostdetailsService.getOrmpostdetailsByIds(#ids),'ehr-OrmPostDetails-Remove')")
    @ApiOperation(value = "RemoveBatchByOrmOrgOrmPost", tags = {"OrmPostDetails" },  notes = "RemoveBatchByOrmOrgOrmPost")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormpostdetails/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgOrmPost(@RequestBody List<String> ids) {
        ormpostdetailsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPostDetails-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByOrmOrgOrmPost", tags = {"OrmPostDetails" } ,notes = "fetchDEFAULTByOrmOrgOrmPost")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormpostdetails/fetchdefault")
	public ResponseEntity<List<OrmPostDetailsDTO>> fetchOrmPostDetailsDefaultByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id,OrmPostDetailsSearchContext context) {
        context.setN_ormpostid_eq(ormpost_id);
        Page<OrmPostDetails> domains = ormpostdetailsService.searchDefault(context) ;
        List<OrmPostDetailsDTO> list = ormpostdetailsMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPostDetails-Default-all')")
	@ApiOperation(value = "searchDEFAULTByOrmOrgOrmPost", tags = {"OrmPostDetails" } ,notes = "searchDEFAULTByOrmOrgOrmPost")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/ormpostdetails/searchdefault")
	public ResponseEntity<Page<OrmPostDetailsDTO>> searchOrmPostDetailsDefaultByOrmOrgOrmPost(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody OrmPostDetailsSearchContext context) {
        context.setN_ormpostid_eq(ormpost_id);
        Page<OrmPostDetails> domains = ormpostdetailsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostdetailsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

