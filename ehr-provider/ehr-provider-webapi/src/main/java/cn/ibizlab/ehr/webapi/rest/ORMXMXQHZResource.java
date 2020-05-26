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
import cn.ibizlab.ehr.core.orm.domain.ORMXMXQHZ;
import cn.ibizlab.ehr.core.orm.service.IORMXMXQHZService;
import cn.ibizlab.ehr.core.orm.filter.ORMXMXQHZSearchContext;

@Slf4j
@Api(tags = {"ORMXMXQHZ" })
@RestController("WebApi-ormxmxqhz")
@RequestMapping("")
public class ORMXMXQHZResource {

    @Autowired
    private IORMXMXQHZService ormxmxqhzService;

    @Autowired
    @Lazy
    public ORMXMXQHZMapping ormxmxqhzMapping;

    public ORMXMXQHZDTO permissionDTO=new ORMXMXQHZDTO();

    @PreAuthorize("hasPermission(#ormxmxqhz_id,'Update',{'Sql',this.ormxmxqhzMapping,#ormxmxqhzdto})")
    @ApiOperation(value = "Update", tags = {"ORMXMXQHZ" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormxmxqhzs/{ormxmxqhz_id}")
    @Transactional
    public ResponseEntity<ORMXMXQHZDTO> update(@PathVariable("ormxmxqhz_id") String ormxmxqhz_id, @RequestBody ORMXMXQHZDTO ormxmxqhzdto) {
		ORMXMXQHZ domain  = ormxmxqhzMapping.toDomain(ormxmxqhzdto);
        domain .setOrmxmxqhzid(ormxmxqhz_id);
		ormxmxqhzService.update(domain );
		ORMXMXQHZDTO dto = ormxmxqhzMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.ormxmxqhzMapping,#ormxmxqhzdtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"ORMXMXQHZ" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormxmxqhzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ORMXMXQHZDTO> ormxmxqhzdtos) {
        ormxmxqhzService.updateBatch(ormxmxqhzMapping.toDomain(ormxmxqhzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.ormxmxqhzMapping,#ormxmxqhzdto})")
    @ApiOperation(value = "Save", tags = {"ORMXMXQHZ" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmxqhzs/save")
    public ResponseEntity<Boolean> save(@RequestBody ORMXMXQHZDTO ormxmxqhzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormxmxqhzService.save(ormxmxqhzMapping.toDomain(ormxmxqhzdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.ormxmxqhzMapping,#ormxmxqhzdtos})")
    @ApiOperation(value = "SaveBatch", tags = {"ORMXMXQHZ" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmxqhzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ORMXMXQHZDTO> ormxmxqhzdtos) {
        ormxmxqhzService.saveBatch(ormxmxqhzMapping.toDomain(ormxmxqhzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMXQHZ-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"ORMXMXQHZ" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormxmxqhzs/getdraft")
    public ResponseEntity<ORMXMXQHZDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormxmxqhzMapping.toDto(ormxmxqhzService.getDraft(new ORMXMXQHZ())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMXQHZ-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"ORMXMXQHZ" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmxqhzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ORMXMXQHZDTO ormxmxqhzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormxmxqhzService.checkKey(ormxmxqhzMapping.toDomain(ormxmxqhzdto)));
    }

    @PreAuthorize("hasPermission(#ormxmxqhz_id,'Remove',{'Sql',this.ormxmxqhzMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"ORMXMXQHZ" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormxmxqhzs/{ormxmxqhz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormxmxqhz_id") String ormxmxqhz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormxmxqhzService.remove(ormxmxqhz_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.ormxmxqhzMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"ORMXMXQHZ" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormxmxqhzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormxmxqhzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#ormxmxqhz_id,'Get',{'Sql',this.ormxmxqhzMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"ORMXMXQHZ" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormxmxqhzs/{ormxmxqhz_id}")
    public ResponseEntity<ORMXMXQHZDTO> get(@PathVariable("ormxmxqhz_id") String ormxmxqhz_id) {
        ORMXMXQHZ domain = ormxmxqhzService.get(ormxmxqhz_id);
        ORMXMXQHZDTO dto = ormxmxqhzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.ormxmxqhzMapping,#ormxmxqhzdto})")
    @ApiOperation(value = "Create", tags = {"ORMXMXQHZ" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmxqhzs")
    @Transactional
    public ResponseEntity<ORMXMXQHZDTO> create(@RequestBody ORMXMXQHZDTO ormxmxqhzdto) {
        ORMXMXQHZ domain = ormxmxqhzMapping.toDomain(ormxmxqhzdto);
		ormxmxqhzService.create(domain);
        ORMXMXQHZDTO dto = ormxmxqhzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.ormxmxqhzMapping,#ormxmxqhzdtos})")
    @ApiOperation(value = "createBatch", tags = {"ORMXMXQHZ" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmxqhzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ORMXMXQHZDTO> ormxmxqhzdtos) {
        ormxmxqhzService.createBatch(ormxmxqhzMapping.toDomain(ormxmxqhzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMXQHZ-XMRYQKMX-all')")
	@ApiOperation(value = "fetch项目人员缺口明细", tags = {"ORMXMXQHZ" } ,notes = "fetch项目人员缺口明细")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmxqhzs/fetchxmryqkmx")
	public ResponseEntity<List<ORMXMXQHZDTO>> fetchXMRYQKMX(ORMXMXQHZSearchContext context) {
        Page<ORMXMXQHZ> domains = ormxmxqhzService.searchXMRYQKMX(context) ;
        List<ORMXMXQHZDTO> list = ormxmxqhzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMXQHZ-XMRYQKMX-all')")
	@ApiOperation(value = "search项目人员缺口明细", tags = {"ORMXMXQHZ" } ,notes = "search项目人员缺口明细")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmxqhzs/searchxmryqkmx")
	public ResponseEntity<Page<ORMXMXQHZDTO>> searchXMRYQKMX(@RequestBody ORMXMXQHZSearchContext context) {
        Page<ORMXMXQHZ> domains = ormxmxqhzService.searchXMRYQKMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmxqhzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMXQHZ-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ORMXMXQHZ" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmxqhzs/fetchdefault")
	public ResponseEntity<List<ORMXMXQHZDTO>> fetchDefault(ORMXMXQHZSearchContext context) {
        Page<ORMXMXQHZ> domains = ormxmxqhzService.searchDefault(context) ;
        List<ORMXMXQHZDTO> list = ormxmxqhzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMXQHZ-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ORMXMXQHZ" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmxqhzs/searchdefault")
	public ResponseEntity<Page<ORMXMXQHZDTO>> searchDefault(@RequestBody ORMXMXQHZSearchContext context) {
        Page<ORMXMXQHZ> domains = ormxmxqhzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmxqhzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
