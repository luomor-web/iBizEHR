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
import cn.ibizlab.ehr.core.pim.domain.ARCHIVESCENTER;
import cn.ibizlab.ehr.core.pim.service.IARCHIVESCENTERService;
import cn.ibizlab.ehr.core.pim.filter.ARCHIVESCENTERSearchContext;

@Slf4j
@Api(tags = {"ARCHIVESCENTER" })
@RestController("WebApi-archivescenter")
@RequestMapping("")
public class ARCHIVESCENTERResource {

    @Autowired
    private IARCHIVESCENTERService archivescenterService;

    @Autowired
    @Lazy
    public ARCHIVESCENTERMapping archivescenterMapping;

    public ARCHIVESCENTERDTO permissionDTO=new ARCHIVESCENTERDTO();

    @PreAuthorize("hasPermission('','Save',{'Sql',this.archivescenterMapping,#archivescenterdto})")
    @ApiOperation(value = "Save", tags = {"ARCHIVESCENTER" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/archivescenters/save")
    public ResponseEntity<Boolean> save(@RequestBody ARCHIVESCENTERDTO archivescenterdto) {
        return ResponseEntity.status(HttpStatus.OK).body(archivescenterService.save(archivescenterMapping.toDomain(archivescenterdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"ARCHIVESCENTER" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/archivescenters/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ARCHIVESCENTERDTO> archivescenterdtos) {
        archivescenterService.saveBatch(archivescenterMapping.toDomain(archivescenterdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#archivescenter_id,'Remove',{'Sql',this.archivescenterMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"ARCHIVESCENTER" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/archivescenters/{archivescenter_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("archivescenter_id") String archivescenter_id) {
         return ResponseEntity.status(HttpStatus.OK).body(archivescenterService.remove(archivescenter_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"ARCHIVESCENTER" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/archivescenters/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        archivescenterService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.archivescenterMapping,#archivescenterdto})")
    @ApiOperation(value = "Create", tags = {"ARCHIVESCENTER" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/archivescenters")
    @Transactional
    public ResponseEntity<ARCHIVESCENTERDTO> create(@RequestBody ARCHIVESCENTERDTO archivescenterdto) {
        ARCHIVESCENTER domain = archivescenterMapping.toDomain(archivescenterdto);
		archivescenterService.create(domain);
        ARCHIVESCENTERDTO dto = archivescenterMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"ARCHIVESCENTER" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/archivescenters/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ARCHIVESCENTERDTO> archivescenterdtos) {
        archivescenterService.createBatch(archivescenterMapping.toDomain(archivescenterdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ARCHIVESCENTER-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"ARCHIVESCENTER" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/archivescenters/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ARCHIVESCENTERDTO archivescenterdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(archivescenterService.checkKey(archivescenterMapping.toDomain(archivescenterdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ARCHIVESCENTER-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"ARCHIVESCENTER" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/archivescenters/getdraft")
    public ResponseEntity<ARCHIVESCENTERDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(archivescenterMapping.toDto(archivescenterService.getDraft(new ARCHIVESCENTER())));
    }

    @PreAuthorize("hasPermission(#archivescenter_id,'Update',{'Sql',this.archivescenterMapping,#archivescenterdto})")
    @ApiOperation(value = "Update", tags = {"ARCHIVESCENTER" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/archivescenters/{archivescenter_id}")
    @Transactional
    public ResponseEntity<ARCHIVESCENTERDTO> update(@PathVariable("archivescenter_id") String archivescenter_id, @RequestBody ARCHIVESCENTERDTO archivescenterdto) {
		ARCHIVESCENTER domain = archivescenterMapping.toDomain(archivescenterdto);
        domain.setArchivescenterid(archivescenter_id);
		archivescenterService.update(domain);
		ARCHIVESCENTERDTO dto = archivescenterMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"ARCHIVESCENTER" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/archivescenters/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ARCHIVESCENTERDTO> archivescenterdtos) {
        archivescenterService.updateBatch(archivescenterMapping.toDomain(archivescenterdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#archivescenter_id,'Get',{'Sql',this.archivescenterMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"ARCHIVESCENTER" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/archivescenters/{archivescenter_id}")
    public ResponseEntity<ARCHIVESCENTERDTO> get(@PathVariable("archivescenter_id") String archivescenter_id) {
        ARCHIVESCENTER domain = archivescenterService.get(archivescenter_id);
        ARCHIVESCENTERDTO dto = archivescenterMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ARCHIVESCENTER-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ARCHIVESCENTER" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/archivescenters/fetchdefault")
	public ResponseEntity<List<ARCHIVESCENTERDTO>> fetchDefault(ARCHIVESCENTERSearchContext context) {
        Page<ARCHIVESCENTER> domains = archivescenterService.searchDefault(context) ;
        List<ARCHIVESCENTERDTO> list = archivescenterMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ARCHIVESCENTER-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ARCHIVESCENTER" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/archivescenters/searchdefault")
	public ResponseEntity<Page<ARCHIVESCENTERDTO>> searchDefault(@RequestBody ARCHIVESCENTERSearchContext context) {
        Page<ARCHIVESCENTER> domains = archivescenterService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(archivescenterMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
