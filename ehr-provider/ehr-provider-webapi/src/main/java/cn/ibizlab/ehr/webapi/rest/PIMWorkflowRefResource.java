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
import cn.ibizlab.ehr.core.pim.domain.PIMWorkflowRef;
import cn.ibizlab.ehr.core.pim.service.IPIMWorkflowRefService;
import cn.ibizlab.ehr.core.pim.filter.PIMWorkflowRefSearchContext;




@Slf4j
@Api(tags = {"PIMWorkflowRef" })
@RestController("WebApi-pimworkflowref")
@RequestMapping("")
public class PIMWorkflowRefResource {

    @Autowired
    private IPIMWorkflowRefService pimworkflowrefService;

    @Autowired
    @Lazy
    public PIMWorkflowRefMapping pimworkflowrefMapping;

    public PIMWorkflowRefDTO permissionDTO=new PIMWorkflowRefDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMWorkflowRef-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PIMWorkflowRef" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimworkflowrefs/getdraft")
    public ResponseEntity<PIMWorkflowRefDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimworkflowrefMapping.toDto(pimworkflowrefService.getDraft(new PIMWorkflowRef())));
    }

    @PreAuthorize("hasPermission(#pimworkflowref_id,'Update',{'Sql',this.pimworkflowrefMapping,#pimworkflowrefdto})")
    @ApiOperation(value = "Update", tags = {"PIMWorkflowRef" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimworkflowrefs/{pimworkflowref_id}")
    @Transactional
    public ResponseEntity<PIMWorkflowRefDTO> update(@PathVariable("pimworkflowref_id") String pimworkflowref_id, @RequestBody PIMWorkflowRefDTO pimworkflowrefdto) {
		PIMWorkflowRef domain = pimworkflowrefMapping.toDomain(pimworkflowrefdto);
        domain.setPimworkflowrefid(pimworkflowref_id);
		pimworkflowrefService.update(domain);
		PIMWorkflowRefDTO dto = pimworkflowrefMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMWorkflowRef" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimworkflowrefs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMWorkflowRefDTO> pimworkflowrefdtos) {
        pimworkflowrefService.updateBatch(pimworkflowrefMapping.toDomain(pimworkflowrefdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pimworkflowref_id,'Get',{'Sql',this.pimworkflowrefMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PIMWorkflowRef" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimworkflowrefs/{pimworkflowref_id}")
    public ResponseEntity<PIMWorkflowRefDTO> get(@PathVariable("pimworkflowref_id") String pimworkflowref_id) {
        PIMWorkflowRef domain = pimworkflowrefService.get(pimworkflowref_id);
        PIMWorkflowRefDTO dto = pimworkflowrefMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMWorkflowRef-Save-all')")
    @ApiOperation(value = "Save", tags = {"PIMWorkflowRef" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimworkflowrefs/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMWorkflowRefDTO pimworkflowrefdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimworkflowrefService.save(pimworkflowrefMapping.toDomain(pimworkflowrefdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PIMWorkflowRef" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimworkflowrefs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMWorkflowRefDTO> pimworkflowrefdtos) {
        pimworkflowrefService.saveBatch(pimworkflowrefMapping.toDomain(pimworkflowrefdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pimworkflowref_id,'Remove',{'Sql',this.pimworkflowrefMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PIMWorkflowRef" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimworkflowrefs/{pimworkflowref_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimworkflowref_id") String pimworkflowref_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimworkflowrefService.remove(pimworkflowref_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PIMWorkflowRef" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimworkflowrefs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimworkflowrefService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pimworkflowrefMapping,#pimworkflowrefdto})")
    @ApiOperation(value = "Create", tags = {"PIMWorkflowRef" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimworkflowrefs")
    @Transactional
    public ResponseEntity<PIMWorkflowRefDTO> create(@RequestBody PIMWorkflowRefDTO pimworkflowrefdto) {
        PIMWorkflowRef domain = pimworkflowrefMapping.toDomain(pimworkflowrefdto);
		pimworkflowrefService.create(domain);
        PIMWorkflowRefDTO dto = pimworkflowrefMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"PIMWorkflowRef" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimworkflowrefs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMWorkflowRefDTO> pimworkflowrefdtos) {
        pimworkflowrefService.createBatch(pimworkflowrefMapping.toDomain(pimworkflowrefdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMWorkflowRef-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PIMWorkflowRef" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimworkflowrefs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMWorkflowRefDTO pimworkflowrefdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimworkflowrefService.checkKey(pimworkflowrefMapping.toDomain(pimworkflowrefdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMWorkflowRef-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMWorkflowRef" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimworkflowrefs/fetchdefault")
	public ResponseEntity<List<PIMWorkflowRefDTO>> fetchDefault(PIMWorkflowRefSearchContext context) {
        Page<PIMWorkflowRef> domains = pimworkflowrefService.searchDefault(context) ;
        List<PIMWorkflowRefDTO> list = pimworkflowrefMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMWorkflowRef-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMWorkflowRef" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimworkflowrefs/searchdefault")
	public ResponseEntity<Page<PIMWorkflowRefDTO>> searchDefault(@RequestBody PIMWorkflowRefSearchContext context) {
        Page<PIMWorkflowRef> domains = pimworkflowrefService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimworkflowrefMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
