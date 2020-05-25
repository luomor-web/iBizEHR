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
import cn.ibizlab.ehr.core.soc.domain.SOCWELFAREINFOMX;
import cn.ibizlab.ehr.core.soc.service.ISOCWELFAREINFOMXService;
import cn.ibizlab.ehr.core.soc.filter.SOCWELFAREINFOMXSearchContext;

@Slf4j
@Api(tags = {"SOCWELFAREINFOMX" })
@RestController("WebApi-socwelfareinfomx")
@RequestMapping("")
public class SOCWELFAREINFOMXResource {

    @Autowired
    private ISOCWELFAREINFOMXService socwelfareinfomxService;

    @Autowired
    @Lazy
    public SOCWELFAREINFOMXMapping socwelfareinfomxMapping;

    public SOCWELFAREINFOMXDTO permissionDTO=new SOCWELFAREINFOMXDTO();

    @PreAuthorize("hasPermission(#socwelfareinfomx_id,'Remove',{'Sql',this.socwelfareinfomxMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"SOCWELFAREINFOMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/socwelfareinfomxes/{socwelfareinfomx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("socwelfareinfomx_id") String socwelfareinfomx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(socwelfareinfomxService.remove(socwelfareinfomx_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"SOCWELFAREINFOMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/socwelfareinfomxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        socwelfareinfomxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.socwelfareinfomxMapping,#socwelfareinfomxdto})")
    @ApiOperation(value = "Save", tags = {"SOCWELFAREINFOMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/socwelfareinfomxes/save")
    public ResponseEntity<Boolean> save(@RequestBody SOCWELFAREINFOMXDTO socwelfareinfomxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(socwelfareinfomxService.save(socwelfareinfomxMapping.toDomain(socwelfareinfomxdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"SOCWELFAREINFOMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/socwelfareinfomxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SOCWELFAREINFOMXDTO> socwelfareinfomxdtos) {
        socwelfareinfomxService.saveBatch(socwelfareinfomxMapping.toDomain(socwelfareinfomxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SOCWELFAREINFOMX-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"SOCWELFAREINFOMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/socwelfareinfomxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SOCWELFAREINFOMXDTO socwelfareinfomxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(socwelfareinfomxService.checkKey(socwelfareinfomxMapping.toDomain(socwelfareinfomxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SOCWELFAREINFOMX-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"SOCWELFAREINFOMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/socwelfareinfomxes/getdraft")
    public ResponseEntity<SOCWELFAREINFOMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(socwelfareinfomxMapping.toDto(socwelfareinfomxService.getDraft(new SOCWELFAREINFOMX())));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.socwelfareinfomxMapping,#socwelfareinfomxdto})")
    @ApiOperation(value = "Create", tags = {"SOCWELFAREINFOMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/socwelfareinfomxes")
    @Transactional
    public ResponseEntity<SOCWELFAREINFOMXDTO> create(@RequestBody SOCWELFAREINFOMXDTO socwelfareinfomxdto) {
        SOCWELFAREINFOMX domain = socwelfareinfomxMapping.toDomain(socwelfareinfomxdto);
		socwelfareinfomxService.create(domain);
        SOCWELFAREINFOMXDTO dto = socwelfareinfomxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"SOCWELFAREINFOMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/socwelfareinfomxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SOCWELFAREINFOMXDTO> socwelfareinfomxdtos) {
        socwelfareinfomxService.createBatch(socwelfareinfomxMapping.toDomain(socwelfareinfomxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#socwelfareinfomx_id,'Get',{'Sql',this.socwelfareinfomxMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"SOCWELFAREINFOMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/socwelfareinfomxes/{socwelfareinfomx_id}")
    public ResponseEntity<SOCWELFAREINFOMXDTO> get(@PathVariable("socwelfareinfomx_id") String socwelfareinfomx_id) {
        SOCWELFAREINFOMX domain = socwelfareinfomxService.get(socwelfareinfomx_id);
        SOCWELFAREINFOMXDTO dto = socwelfareinfomxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#socwelfareinfomx_id,'Update',{'Sql',this.socwelfareinfomxMapping,#socwelfareinfomxdto})")
    @ApiOperation(value = "Update", tags = {"SOCWELFAREINFOMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/socwelfareinfomxes/{socwelfareinfomx_id}")
    @Transactional
    public ResponseEntity<SOCWELFAREINFOMXDTO> update(@PathVariable("socwelfareinfomx_id") String socwelfareinfomx_id, @RequestBody SOCWELFAREINFOMXDTO socwelfareinfomxdto) {
		SOCWELFAREINFOMX domain = socwelfareinfomxMapping.toDomain(socwelfareinfomxdto);
        domain.setSocwelfareinfomxid(socwelfareinfomx_id);
		socwelfareinfomxService.update(domain);
		SOCWELFAREINFOMXDTO dto = socwelfareinfomxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"SOCWELFAREINFOMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/socwelfareinfomxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SOCWELFAREINFOMXDTO> socwelfareinfomxdtos) {
        socwelfareinfomxService.updateBatch(socwelfareinfomxMapping.toDomain(socwelfareinfomxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SOCWELFAREINFOMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SOCWELFAREINFOMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/socwelfareinfomxes/fetchdefault")
	public ResponseEntity<List<SOCWELFAREINFOMXDTO>> fetchDefault(SOCWELFAREINFOMXSearchContext context) {
        Page<SOCWELFAREINFOMX> domains = socwelfareinfomxService.searchDefault(context) ;
        List<SOCWELFAREINFOMXDTO> list = socwelfareinfomxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SOCWELFAREINFOMX-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SOCWELFAREINFOMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/socwelfareinfomxes/searchdefault")
	public ResponseEntity<Page<SOCWELFAREINFOMXDTO>> searchDefault(@RequestBody SOCWELFAREINFOMXSearchContext context) {
        Page<SOCWELFAREINFOMX> domains = socwelfareinfomxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(socwelfareinfomxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
