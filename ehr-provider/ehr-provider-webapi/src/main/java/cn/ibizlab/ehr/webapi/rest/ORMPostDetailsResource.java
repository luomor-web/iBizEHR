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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import cn.ibizlab.ehr.webapi.dto.*;
import cn.ibizlab.ehr.webapi.mapping.*;
import cn.ibizlab.ehr.core.orm.domain.ORMPostDetails;
import cn.ibizlab.ehr.core.orm.service.IORMPostDetailsService;
import cn.ibizlab.ehr.core.orm.filter.ORMPostDetailsSearchContext;

@Slf4j
@Api(tags = {"ORMPostDetails" })
@RestController("WebApi-ormpostdetails")
@RequestMapping("")
public class ORMPostDetailsResource {

    @Autowired
    private IORMPostDetailsService ormpostdetailsService;

    @Autowired
    @Lazy
    public ORMPostDetailsMapping ormpostdetailsMapping;

    public ORMPostDetailsDTO permissionDTO=new ORMPostDetailsDTO();

    @PreAuthorize("hasPermission('','Create',{'Sql',this.ormpostdetailsMapping,#ormpostdetailsdto})")
    @ApiOperation(value = "Create", tags = {"ORMPostDetails" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostdetails")
    @Transactional
    public ResponseEntity<ORMPostDetailsDTO> create(@RequestBody ORMPostDetailsDTO ormpostdetailsdto) {
        ORMPostDetails domain = ormpostdetailsMapping.toDomain(ormpostdetailsdto);
		ormpostdetailsService.create(domain);
        ORMPostDetailsDTO dto = ormpostdetailsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.ormpostdetailsMapping,#ormpostdetailsdtos})")
    @ApiOperation(value = "createBatch", tags = {"ORMPostDetails" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostdetails/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ORMPostDetailsDTO> ormpostdetailsdtos) {
        ormpostdetailsService.createBatch(ormpostdetailsMapping.toDomain(ormpostdetailsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#ormpostdetails_id,'Get',{'Sql',this.ormpostdetailsMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"ORMPostDetails" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormpostdetails/{ormpostdetails_id}")
    public ResponseEntity<ORMPostDetailsDTO> get(@PathVariable("ormpostdetails_id") String ormpostdetails_id) {
        ORMPostDetails domain = ormpostdetailsService.get(ormpostdetails_id);
        ORMPostDetailsDTO dto = ormpostdetailsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPostDetails-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"ORMPostDetails" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostdetails/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ORMPostDetailsDTO ormpostdetailsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsService.checkKey(ormpostdetailsMapping.toDomain(ormpostdetailsdto)));
    }

    @PreAuthorize("hasPermission(#ormpostdetails_id,'Update',{'Sql',this.ormpostdetailsMapping,#ormpostdetailsdto})")
    @ApiOperation(value = "Update", tags = {"ORMPostDetails" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormpostdetails/{ormpostdetails_id}")
    @Transactional
    public ResponseEntity<ORMPostDetailsDTO> update(@PathVariable("ormpostdetails_id") String ormpostdetails_id, @RequestBody ORMPostDetailsDTO ormpostdetailsdto) {
		ORMPostDetails domain  = ormpostdetailsMapping.toDomain(ormpostdetailsdto);
        domain .setOrmpostdetailsid(ormpostdetails_id);
		ormpostdetailsService.update(domain );
		ORMPostDetailsDTO dto = ormpostdetailsMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.ormpostdetailsMapping,#ormpostdetailsdtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"ORMPostDetails" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormpostdetails/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ORMPostDetailsDTO> ormpostdetailsdtos) {
        ormpostdetailsService.updateBatch(ormpostdetailsMapping.toDomain(ormpostdetailsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPostDetails-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"ORMPostDetails" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormpostdetails/getdraft")
    public ResponseEntity<ORMPostDetailsDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsMapping.toDto(ormpostdetailsService.getDraft(new ORMPostDetails())));
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.ormpostdetailsMapping,#ormpostdetailsdto})")
    @ApiOperation(value = "Save", tags = {"ORMPostDetails" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostdetails/save")
    public ResponseEntity<Boolean> save(@RequestBody ORMPostDetailsDTO ormpostdetailsdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsService.save(ormpostdetailsMapping.toDomain(ormpostdetailsdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.ormpostdetailsMapping,#ormpostdetailsdtos})")
    @ApiOperation(value = "SaveBatch", tags = {"ORMPostDetails" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostdetails/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ORMPostDetailsDTO> ormpostdetailsdtos) {
        ormpostdetailsService.saveBatch(ormpostdetailsMapping.toDomain(ormpostdetailsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#ormpostdetails_id,'Remove',{'Sql',this.ormpostdetailsMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"ORMPostDetails" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormpostdetails/{ormpostdetails_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormpostdetails_id") String ormpostdetails_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsService.remove(ormpostdetails_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.ormpostdetailsMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"ORMPostDetails" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormpostdetails/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormpostdetailsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPostDetails-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ORMPostDetails" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormpostdetails/fetchdefault")
	public ResponseEntity<List<ORMPostDetailsDTO>> fetchDefault(ORMPostDetailsSearchContext context) {
        Page<ORMPostDetails> domains = ormpostdetailsService.searchDefault(context) ;
        List<ORMPostDetailsDTO> list = ormpostdetailsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPostDetails-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ORMPostDetails" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormpostdetails/searchdefault")
	public ResponseEntity<Page<ORMPostDetailsDTO>> searchDefault(@RequestBody ORMPostDetailsSearchContext context) {
        Page<ORMPostDetails> domains = ormpostdetailsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostdetailsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission('','Create',{'Sql',this.ormpostdetailsMapping,#ormpostdetailsdto})")
    @ApiOperation(value = "CreateByORMPostLib", tags = {"ORMPostDetails" },  notes = "CreateByORMPostLib")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostlibs/{ormpostlib_id}/ormpostdetails")
    @Transactional
    public ResponseEntity<ORMPostDetailsDTO> createByORMPostLib(@PathVariable("ormpostlib_id") String ormpostlib_id, @RequestBody ORMPostDetailsDTO ormpostdetailsdto) {
        ORMPostDetails domain = ormpostdetailsMapping.toDomain(ormpostdetailsdto);
        domain.setOrmpostlibid(ormpostlib_id);
		ormpostdetailsService.create(domain);
        ORMPostDetailsDTO dto = ormpostdetailsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.ormpostdetailsMapping,#ormpostdetailsdtos})")
    @ApiOperation(value = "createBatchByORMPostLib", tags = {"ORMPostDetails" },  notes = "createBatchByORMPostLib")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostlibs/{ormpostlib_id}/ormpostdetails/batch")
    public ResponseEntity<Boolean> createBatchByORMPostLib(@PathVariable("ormpostlib_id") String ormpostlib_id, @RequestBody List<ORMPostDetailsDTO> ormpostdetailsdtos) {
        List<ORMPostDetails> domainlist=ormpostdetailsMapping.toDomain(ormpostdetailsdtos);
        for(ORMPostDetails domain:domainlist){
            domain.setOrmpostlibid(ormpostlib_id);
        }
        ormpostdetailsService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#ormpostdetails_id,'Get',{'Sql',this.ormpostdetailsMapping,this.permissionDTO})")
    @ApiOperation(value = "GetByORMPostLib", tags = {"ORMPostDetails" },  notes = "GetByORMPostLib")
	@RequestMapping(method = RequestMethod.GET, value = "/ormpostlibs/{ormpostlib_id}/ormpostdetails/{ormpostdetails_id}")
    public ResponseEntity<ORMPostDetailsDTO> getByORMPostLib(@PathVariable("ormpostlib_id") String ormpostlib_id, @PathVariable("ormpostdetails_id") String ormpostdetails_id) {
        ORMPostDetails domain = ormpostdetailsService.get(ormpostdetails_id);
        ORMPostDetailsDTO dto = ormpostdetailsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPostDetails-CheckKey-all')")
    @ApiOperation(value = "CheckKeyByORMPostLib", tags = {"ORMPostDetails" },  notes = "CheckKeyByORMPostLib")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostlibs/{ormpostlib_id}/ormpostdetails/checkkey")
    public ResponseEntity<Boolean> checkKeyByORMPostLib(@PathVariable("ormpostlib_id") String ormpostlib_id, @RequestBody ORMPostDetailsDTO ormpostdetailsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsService.checkKey(ormpostdetailsMapping.toDomain(ormpostdetailsdto)));
    }

    @PreAuthorize("hasPermission(#ormpostdetails_id,'Update',{'Sql',this.ormpostdetailsMapping,#ormpostdetailsdto})")
    @ApiOperation(value = "UpdateByORMPostLib", tags = {"ORMPostDetails" },  notes = "UpdateByORMPostLib")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormpostlibs/{ormpostlib_id}/ormpostdetails/{ormpostdetails_id}")
    @Transactional
    public ResponseEntity<ORMPostDetailsDTO> updateByORMPostLib(@PathVariable("ormpostlib_id") String ormpostlib_id, @PathVariable("ormpostdetails_id") String ormpostdetails_id, @RequestBody ORMPostDetailsDTO ormpostdetailsdto) {
        ORMPostDetails domain = ormpostdetailsMapping.toDomain(ormpostdetailsdto);
        domain.setOrmpostlibid(ormpostlib_id);
        domain.setOrmpostdetailsid(ormpostdetails_id);
		ormpostdetailsService.update(domain);
        ORMPostDetailsDTO dto = ormpostdetailsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.ormpostdetailsMapping,#ormpostdetailsdtos})")
    @ApiOperation(value = "UpdateBatchByORMPostLib", tags = {"ORMPostDetails" },  notes = "UpdateBatchByORMPostLib")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormpostlibs/{ormpostlib_id}/ormpostdetails/batch")
    public ResponseEntity<Boolean> updateBatchByORMPostLib(@PathVariable("ormpostlib_id") String ormpostlib_id, @RequestBody List<ORMPostDetailsDTO> ormpostdetailsdtos) {
        List<ORMPostDetails> domainlist=ormpostdetailsMapping.toDomain(ormpostdetailsdtos);
        for(ORMPostDetails domain:domainlist){
            domain.setOrmpostlibid(ormpostlib_id);
        }
        ormpostdetailsService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPostDetails-GetDraft-all')")
    @ApiOperation(value = "GetDraftByORMPostLib", tags = {"ORMPostDetails" },  notes = "GetDraftByORMPostLib")
    @RequestMapping(method = RequestMethod.GET, value = "/ormpostlibs/{ormpostlib_id}/ormpostdetails/getdraft")
    public ResponseEntity<ORMPostDetailsDTO> getDraftByORMPostLib(@PathVariable("ormpostlib_id") String ormpostlib_id) {
        ORMPostDetails domain = new ORMPostDetails();
        domain.setOrmpostlibid(ormpostlib_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsMapping.toDto(ormpostdetailsService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.ormpostdetailsMapping,#ormpostdetailsdto})")
    @ApiOperation(value = "SaveByORMPostLib", tags = {"ORMPostDetails" },  notes = "SaveByORMPostLib")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostlibs/{ormpostlib_id}/ormpostdetails/save")
    public ResponseEntity<Boolean> saveByORMPostLib(@PathVariable("ormpostlib_id") String ormpostlib_id, @RequestBody ORMPostDetailsDTO ormpostdetailsdto) {
        ORMPostDetails domain = ormpostdetailsMapping.toDomain(ormpostdetailsdto);
        domain.setOrmpostlibid(ormpostlib_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsService.save(domain));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.ormpostdetailsMapping,#ormpostdetailsdtos})")
    @ApiOperation(value = "SaveBatchByORMPostLib", tags = {"ORMPostDetails" },  notes = "SaveBatchByORMPostLib")
	@RequestMapping(method = RequestMethod.POST, value = "/ormpostlibs/{ormpostlib_id}/ormpostdetails/savebatch")
    public ResponseEntity<Boolean> saveBatchByORMPostLib(@PathVariable("ormpostlib_id") String ormpostlib_id, @RequestBody List<ORMPostDetailsDTO> ormpostdetailsdtos) {
        List<ORMPostDetails> domainlist=ormpostdetailsMapping.toDomain(ormpostdetailsdtos);
        for(ORMPostDetails domain:domainlist){
             domain.setOrmpostlibid(ormpostlib_id);
        }
        ormpostdetailsService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#ormpostdetails_id,'Remove',{'Sql',this.ormpostdetailsMapping,this.permissionDTO})")
    @ApiOperation(value = "RemoveByORMPostLib", tags = {"ORMPostDetails" },  notes = "RemoveByORMPostLib")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormpostlibs/{ormpostlib_id}/ormpostdetails/{ormpostdetails_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByORMPostLib(@PathVariable("ormpostlib_id") String ormpostlib_id, @PathVariable("ormpostdetails_id") String ormpostdetails_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsService.remove(ormpostdetails_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.ormpostdetailsMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatchByORMPostLib", tags = {"ORMPostDetails" },  notes = "RemoveBatchByORMPostLib")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormpostlibs/{ormpostlib_id}/ormpostdetails/batch")
    public ResponseEntity<Boolean> removeBatchByORMPostLib(@RequestBody List<String> ids) {
        ormpostdetailsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPostDetails-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByORMPostLib", tags = {"ORMPostDetails" } ,notes = "fetchDEFAULTByORMPostLib")
    @RequestMapping(method= RequestMethod.GET , value="/ormpostlibs/{ormpostlib_id}/ormpostdetails/fetchdefault")
	public ResponseEntity<List<ORMPostDetailsDTO>> fetchORMPostDetailsDefaultByORMPostLib(@PathVariable("ormpostlib_id") String ormpostlib_id,ORMPostDetailsSearchContext context) {
        context.setN_ormpostlibid_eq(ormpostlib_id);
        Page<ORMPostDetails> domains = ormpostdetailsService.searchDefault(context) ;
        List<ORMPostDetailsDTO> list = ormpostdetailsMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPostDetails-Default-all')")
	@ApiOperation(value = "searchDEFAULTByORMPostLib", tags = {"ORMPostDetails" } ,notes = "searchDEFAULTByORMPostLib")
    @RequestMapping(method= RequestMethod.POST , value="/ormpostlibs/{ormpostlib_id}/ormpostdetails/searchdefault")
	public ResponseEntity<Page<ORMPostDetailsDTO>> searchORMPostDetailsDefaultByORMPostLib(@PathVariable("ormpostlib_id") String ormpostlib_id, @RequestBody ORMPostDetailsSearchContext context) {
        context.setN_ormpostlibid_eq(ormpostlib_id);
        Page<ORMPostDetails> domains = ormpostdetailsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostdetailsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission('','Create',{'Sql',this.ormpostdetailsMapping,#ormpostdetailsdto})")
    @ApiOperation(value = "CreateByORMPOST", tags = {"ORMPostDetails" },  notes = "CreateByORMPOST")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/ormpostdetails")
    @Transactional
    public ResponseEntity<ORMPostDetailsDTO> createByORMPOST(@PathVariable("ormpost_id") String ormpost_id, @RequestBody ORMPostDetailsDTO ormpostdetailsdto) {
        ORMPostDetails domain = ormpostdetailsMapping.toDomain(ormpostdetailsdto);
        domain.setOrmpostid(ormpost_id);
		ormpostdetailsService.create(domain);
        ORMPostDetailsDTO dto = ormpostdetailsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.ormpostdetailsMapping,#ormpostdetailsdtos})")
    @ApiOperation(value = "createBatchByORMPOST", tags = {"ORMPostDetails" },  notes = "createBatchByORMPOST")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/ormpostdetails/batch")
    public ResponseEntity<Boolean> createBatchByORMPOST(@PathVariable("ormpost_id") String ormpost_id, @RequestBody List<ORMPostDetailsDTO> ormpostdetailsdtos) {
        List<ORMPostDetails> domainlist=ormpostdetailsMapping.toDomain(ormpostdetailsdtos);
        for(ORMPostDetails domain:domainlist){
            domain.setOrmpostid(ormpost_id);
        }
        ormpostdetailsService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#ormpostdetails_id,'Get',{'Sql',this.ormpostdetailsMapping,this.permissionDTO})")
    @ApiOperation(value = "GetByORMPOST", tags = {"ORMPostDetails" },  notes = "GetByORMPOST")
	@RequestMapping(method = RequestMethod.GET, value = "/ormposts/{ormpost_id}/ormpostdetails/{ormpostdetails_id}")
    public ResponseEntity<ORMPostDetailsDTO> getByORMPOST(@PathVariable("ormpost_id") String ormpost_id, @PathVariable("ormpostdetails_id") String ormpostdetails_id) {
        ORMPostDetails domain = ormpostdetailsService.get(ormpostdetails_id);
        ORMPostDetailsDTO dto = ormpostdetailsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPostDetails-CheckKey-all')")
    @ApiOperation(value = "CheckKeyByORMPOST", tags = {"ORMPostDetails" },  notes = "CheckKeyByORMPOST")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/ormpostdetails/checkkey")
    public ResponseEntity<Boolean> checkKeyByORMPOST(@PathVariable("ormpost_id") String ormpost_id, @RequestBody ORMPostDetailsDTO ormpostdetailsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsService.checkKey(ormpostdetailsMapping.toDomain(ormpostdetailsdto)));
    }

    @PreAuthorize("hasPermission(#ormpostdetails_id,'Update',{'Sql',this.ormpostdetailsMapping,#ormpostdetailsdto})")
    @ApiOperation(value = "UpdateByORMPOST", tags = {"ORMPostDetails" },  notes = "UpdateByORMPOST")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormposts/{ormpost_id}/ormpostdetails/{ormpostdetails_id}")
    @Transactional
    public ResponseEntity<ORMPostDetailsDTO> updateByORMPOST(@PathVariable("ormpost_id") String ormpost_id, @PathVariable("ormpostdetails_id") String ormpostdetails_id, @RequestBody ORMPostDetailsDTO ormpostdetailsdto) {
        ORMPostDetails domain = ormpostdetailsMapping.toDomain(ormpostdetailsdto);
        domain.setOrmpostid(ormpost_id);
        domain.setOrmpostdetailsid(ormpostdetails_id);
		ormpostdetailsService.update(domain);
        ORMPostDetailsDTO dto = ormpostdetailsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.ormpostdetailsMapping,#ormpostdetailsdtos})")
    @ApiOperation(value = "UpdateBatchByORMPOST", tags = {"ORMPostDetails" },  notes = "UpdateBatchByORMPOST")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormposts/{ormpost_id}/ormpostdetails/batch")
    public ResponseEntity<Boolean> updateBatchByORMPOST(@PathVariable("ormpost_id") String ormpost_id, @RequestBody List<ORMPostDetailsDTO> ormpostdetailsdtos) {
        List<ORMPostDetails> domainlist=ormpostdetailsMapping.toDomain(ormpostdetailsdtos);
        for(ORMPostDetails domain:domainlist){
            domain.setOrmpostid(ormpost_id);
        }
        ormpostdetailsService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPostDetails-GetDraft-all')")
    @ApiOperation(value = "GetDraftByORMPOST", tags = {"ORMPostDetails" },  notes = "GetDraftByORMPOST")
    @RequestMapping(method = RequestMethod.GET, value = "/ormposts/{ormpost_id}/ormpostdetails/getdraft")
    public ResponseEntity<ORMPostDetailsDTO> getDraftByORMPOST(@PathVariable("ormpost_id") String ormpost_id) {
        ORMPostDetails domain = new ORMPostDetails();
        domain.setOrmpostid(ormpost_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsMapping.toDto(ormpostdetailsService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.ormpostdetailsMapping,#ormpostdetailsdto})")
    @ApiOperation(value = "SaveByORMPOST", tags = {"ORMPostDetails" },  notes = "SaveByORMPOST")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/ormpostdetails/save")
    public ResponseEntity<Boolean> saveByORMPOST(@PathVariable("ormpost_id") String ormpost_id, @RequestBody ORMPostDetailsDTO ormpostdetailsdto) {
        ORMPostDetails domain = ormpostdetailsMapping.toDomain(ormpostdetailsdto);
        domain.setOrmpostid(ormpost_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsService.save(domain));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.ormpostdetailsMapping,#ormpostdetailsdtos})")
    @ApiOperation(value = "SaveBatchByORMPOST", tags = {"ORMPostDetails" },  notes = "SaveBatchByORMPOST")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/ormpostdetails/savebatch")
    public ResponseEntity<Boolean> saveBatchByORMPOST(@PathVariable("ormpost_id") String ormpost_id, @RequestBody List<ORMPostDetailsDTO> ormpostdetailsdtos) {
        List<ORMPostDetails> domainlist=ormpostdetailsMapping.toDomain(ormpostdetailsdtos);
        for(ORMPostDetails domain:domainlist){
             domain.setOrmpostid(ormpost_id);
        }
        ormpostdetailsService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#ormpostdetails_id,'Remove',{'Sql',this.ormpostdetailsMapping,this.permissionDTO})")
    @ApiOperation(value = "RemoveByORMPOST", tags = {"ORMPostDetails" },  notes = "RemoveByORMPOST")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormposts/{ormpost_id}/ormpostdetails/{ormpostdetails_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByORMPOST(@PathVariable("ormpost_id") String ormpost_id, @PathVariable("ormpostdetails_id") String ormpostdetails_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormpostdetailsService.remove(ormpostdetails_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.ormpostdetailsMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatchByORMPOST", tags = {"ORMPostDetails" },  notes = "RemoveBatchByORMPOST")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormposts/{ormpost_id}/ormpostdetails/batch")
    public ResponseEntity<Boolean> removeBatchByORMPOST(@RequestBody List<String> ids) {
        ormpostdetailsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPostDetails-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByORMPOST", tags = {"ORMPostDetails" } ,notes = "fetchDEFAULTByORMPOST")
    @RequestMapping(method= RequestMethod.GET , value="/ormposts/{ormpost_id}/ormpostdetails/fetchdefault")
	public ResponseEntity<List<ORMPostDetailsDTO>> fetchORMPostDetailsDefaultByORMPOST(@PathVariable("ormpost_id") String ormpost_id,ORMPostDetailsSearchContext context) {
        context.setN_ormpostid_eq(ormpost_id);
        Page<ORMPostDetails> domains = ormpostdetailsService.searchDefault(context) ;
        List<ORMPostDetailsDTO> list = ormpostdetailsMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPostDetails-Default-all')")
	@ApiOperation(value = "searchDEFAULTByORMPOST", tags = {"ORMPostDetails" } ,notes = "searchDEFAULTByORMPOST")
    @RequestMapping(method= RequestMethod.POST , value="/ormposts/{ormpost_id}/ormpostdetails/searchdefault")
	public ResponseEntity<Page<ORMPostDetailsDTO>> searchORMPostDetailsDefaultByORMPOST(@PathVariable("ormpost_id") String ormpost_id, @RequestBody ORMPostDetailsSearchContext context) {
        context.setN_ormpostid_eq(ormpost_id);
        Page<ORMPostDetails> domains = ormpostdetailsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostdetailsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
