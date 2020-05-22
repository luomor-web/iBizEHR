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
import cn.ibizlab.ehr.core.orm.domain.ORMXMBMX;
import cn.ibizlab.ehr.core.orm.service.IORMXMBMXService;
import cn.ibizlab.ehr.core.orm.filter.ORMXMBMXSearchContext;




@Slf4j
@Api(tags = {"ORMXMBMX" })
@RestController("WebApi-ormxmbmx")
@RequestMapping("")
public class ORMXMBMXResource {

    @Autowired
    private IORMXMBMXService ormxmbmxService;

    @Autowired
    @Lazy
    public ORMXMBMXMapping ormxmbmxMapping;

    public ORMXMBMXDTO permissionDTO=new ORMXMBMXDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBMX-Save-all')")
    @ApiOperation(value = "Save", tags = {"ORMXMBMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody ORMXMBMXDTO ormxmbmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.save(ormxmbmxMapping.toDomain(ormxmbmxdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"ORMXMBMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        ormxmbmxService.saveBatch(ormxmbmxMapping.toDomain(ormxmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBMX-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"ORMXMBMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormxmbmxes/getdraft")
    public ResponseEntity<ORMXMBMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxMapping.toDto(ormxmbmxService.getDraft(new ORMXMBMX())));
    }

    @PreAuthorize("hasPermission(#ormxmbmx_id,'Update',{'Sql',this.ormxmbmxMapping,#ormxmbmxdto})")
    @ApiOperation(value = "Update", tags = {"ORMXMBMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormxmbmxes/{ormxmbmx_id}")
    @Transactional
    public ResponseEntity<ORMXMBMXDTO> update(@PathVariable("ormxmbmx_id") String ormxmbmx_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
		ORMXMBMX domain = ormxmbmxMapping.toDomain(ormxmbmxdto);
        domain.setOrmxmbmxid(ormxmbmx_id);
		ormxmbmxService.update(domain);
		ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"ORMXMBMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormxmbmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        ormxmbmxService.updateBatch(ormxmbmxMapping.toDomain(ormxmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#ormxmbmx_id,'Get',{'Sql',this.ormxmbmxMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"ORMXMBMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormxmbmxes/{ormxmbmx_id}")
    public ResponseEntity<ORMXMBMXDTO> get(@PathVariable("ormxmbmx_id") String ormxmbmx_id) {
        ORMXMBMX domain = ormxmbmxService.get(ormxmbmx_id);
        ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBMX-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"ORMXMBMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ORMXMBMXDTO ormxmbmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.checkKey(ormxmbmxMapping.toDomain(ormxmbmxdto)));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.ormxmbmxMapping,#ormxmbmxdto})")
    @ApiOperation(value = "Create", tags = {"ORMXMBMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbmxes")
    @Transactional
    public ResponseEntity<ORMXMBMXDTO> create(@RequestBody ORMXMBMXDTO ormxmbmxdto) {
        ORMXMBMX domain = ormxmbmxMapping.toDomain(ormxmbmxdto);
		ormxmbmxService.create(domain);
        ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"ORMXMBMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        ormxmbmxService.createBatch(ormxmbmxMapping.toDomain(ormxmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#ormxmbmx_id,'Remove',{'Sql',this.ormxmbmxMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"ORMXMBMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormxmbmxes/{ormxmbmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormxmbmx_id") String ormxmbmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.remove(ormxmbmx_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"ORMXMBMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormxmbmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormxmbmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ORMXMBMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmbmxes/fetchdefault")
	public ResponseEntity<List<ORMXMBMXDTO>> fetchDefault(ORMXMBMXSearchContext context) {
        Page<ORMXMBMX> domains = ormxmbmxService.searchDefault(context) ;
        List<ORMXMBMXDTO> list = ormxmbmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBMX-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ORMXMBMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmbmxes/searchdefault")
	public ResponseEntity<Page<ORMXMBMXDTO>> searchDefault(@RequestBody ORMXMBMXSearchContext context) {
        Page<ORMXMBMX> domains = ormxmbmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmbmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
