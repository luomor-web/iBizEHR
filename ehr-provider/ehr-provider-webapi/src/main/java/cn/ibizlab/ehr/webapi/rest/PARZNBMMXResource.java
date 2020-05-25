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
import cn.ibizlab.ehr.core.par.domain.PARZNBMMX;
import cn.ibizlab.ehr.core.par.service.IPARZNBMMXService;
import cn.ibizlab.ehr.core.par.filter.PARZNBMMXSearchContext;

@Slf4j
@Api(tags = {"PARZNBMMX" })
@RestController("WebApi-parznbmmx")
@RequestMapping("")
public class PARZNBMMXResource {

    @Autowired
    private IPARZNBMMXService parznbmmxService;

    @Autowired
    @Lazy
    public PARZNBMMXMapping parznbmmxMapping;

    public PARZNBMMXDTO permissionDTO=new PARZNBMMXDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARZNBMMX-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PARZNBMMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARZNBMMXDTO parznbmmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parznbmmxService.checkKey(parznbmmxMapping.toDomain(parznbmmxdto)));
    }

    @PreAuthorize("hasPermission(#parznbmmx_id,'Update',{'Sql',this.parznbmmxMapping,#parznbmmxdto})")
    @ApiOperation(value = "Update", tags = {"PARZNBMMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parznbmmxes/{parznbmmx_id}")
    @Transactional
    public ResponseEntity<PARZNBMMXDTO> update(@PathVariable("parznbmmx_id") String parznbmmx_id, @RequestBody PARZNBMMXDTO parznbmmxdto) {
		PARZNBMMX domain = parznbmmxMapping.toDomain(parznbmmxdto);
        domain.setParznbmmxid(parznbmmx_id);
		parznbmmxService.update(domain);
		PARZNBMMXDTO dto = parznbmmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PARZNBMMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parznbmmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARZNBMMXDTO> parznbmmxdtos) {
        parznbmmxService.updateBatch(parznbmmxMapping.toDomain(parznbmmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARZNBMMX-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PARZNBMMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parznbmmxes/getdraft")
    public ResponseEntity<PARZNBMMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parznbmmxMapping.toDto(parznbmmxService.getDraft(new PARZNBMMX())));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.parznbmmxMapping,#parznbmmxdto})")
    @ApiOperation(value = "Create", tags = {"PARZNBMMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmmxes")
    @Transactional
    public ResponseEntity<PARZNBMMXDTO> create(@RequestBody PARZNBMMXDTO parznbmmxdto) {
        PARZNBMMX domain = parznbmmxMapping.toDomain(parznbmmxdto);
		parznbmmxService.create(domain);
        PARZNBMMXDTO dto = parznbmmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"PARZNBMMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARZNBMMXDTO> parznbmmxdtos) {
        parznbmmxService.createBatch(parznbmmxMapping.toDomain(parznbmmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#parznbmmx_id,'Remove',{'Sql',this.parznbmmxMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PARZNBMMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parznbmmxes/{parznbmmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parznbmmx_id") String parznbmmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parznbmmxService.remove(parznbmmx_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PARZNBMMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parznbmmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parznbmmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.parznbmmxMapping,#parznbmmxdto})")
    @ApiOperation(value = "Save", tags = {"PARZNBMMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PARZNBMMXDTO parznbmmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parznbmmxService.save(parznbmmxMapping.toDomain(parznbmmxdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PARZNBMMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARZNBMMXDTO> parznbmmxdtos) {
        parznbmmxService.saveBatch(parznbmmxMapping.toDomain(parznbmmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#parznbmmx_id,'Get',{'Sql',this.parznbmmxMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PARZNBMMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parznbmmxes/{parznbmmx_id}")
    public ResponseEntity<PARZNBMMXDTO> get(@PathVariable("parznbmmx_id") String parznbmmx_id) {
        PARZNBMMX domain = parznbmmxService.get(parznbmmx_id);
        PARZNBMMXDTO dto = parznbmmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARZNBMMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PARZNBMMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parznbmmxes/fetchdefault")
	public ResponseEntity<List<PARZNBMMXDTO>> fetchDefault(PARZNBMMXSearchContext context) {
        Page<PARZNBMMX> domains = parznbmmxService.searchDefault(context) ;
        List<PARZNBMMXDTO> list = parznbmmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARZNBMMX-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PARZNBMMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parznbmmxes/searchdefault")
	public ResponseEntity<Page<PARZNBMMXDTO>> searchDefault(@RequestBody PARZNBMMXSearchContext context) {
        Page<PARZNBMMX> domains = parznbmmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parznbmmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
