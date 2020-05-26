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
import cn.ibizlab.ehr.core.orm.domain.ORMORGDZ;
import cn.ibizlab.ehr.core.orm.service.IORMORGDZService;
import cn.ibizlab.ehr.core.orm.filter.ORMORGDZSearchContext;

@Slf4j
@Api(tags = {"ORMORGDZ" })
@RestController("WebApi-ormorgdz")
@RequestMapping("")
public class ORMORGDZResource {

    @Autowired
    private IORMORGDZService ormorgdzService;

    @Autowired
    @Lazy
    public ORMORGDZMapping ormorgdzMapping;

    public ORMORGDZDTO permissionDTO=new ORMORGDZDTO();

    @PreAuthorize("hasPermission(#ormorgdz_id,'Get',{'Sql',this.ormorgdzMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"ORMORGDZ" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgdzs/{ormorgdz_id}")
    public ResponseEntity<ORMORGDZDTO> get(@PathVariable("ormorgdz_id") String ormorgdz_id) {
        ORMORGDZ domain = ormorgdzService.get(ormorgdz_id);
        ORMORGDZDTO dto = ormorgdzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGDZ-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"ORMORGDZ" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgdzs/getdraft")
    public ResponseEntity<ORMORGDZDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormorgdzMapping.toDto(ormorgdzService.getDraft(new ORMORGDZ())));
    }

    @PreAuthorize("hasPermission(#ormorgdz_id,'Remove',{'Sql',this.ormorgdzMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"ORMORGDZ" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgdzs/{ormorgdz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormorgdz_id") String ormorgdz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormorgdzService.remove(ormorgdz_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.ormorgdzMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"ORMORGDZ" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgdzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormorgdzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.ormorgdzMapping,#ormorgdzdto})")
    @ApiOperation(value = "Save", tags = {"ORMORGDZ" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgdzs/save")
    public ResponseEntity<Boolean> save(@RequestBody ORMORGDZDTO ormorgdzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormorgdzService.save(ormorgdzMapping.toDomain(ormorgdzdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.ormorgdzMapping,#ormorgdzdtos})")
    @ApiOperation(value = "SaveBatch", tags = {"ORMORGDZ" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgdzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ORMORGDZDTO> ormorgdzdtos) {
        ormorgdzService.saveBatch(ormorgdzMapping.toDomain(ormorgdzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.ormorgdzMapping,#ormorgdzdto})")
    @ApiOperation(value = "Create", tags = {"ORMORGDZ" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgdzs")
    @Transactional
    public ResponseEntity<ORMORGDZDTO> create(@RequestBody ORMORGDZDTO ormorgdzdto) {
        ORMORGDZ domain = ormorgdzMapping.toDomain(ormorgdzdto);
		ormorgdzService.create(domain);
        ORMORGDZDTO dto = ormorgdzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.ormorgdzMapping,#ormorgdzdtos})")
    @ApiOperation(value = "createBatch", tags = {"ORMORGDZ" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgdzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ORMORGDZDTO> ormorgdzdtos) {
        ormorgdzService.createBatch(ormorgdzMapping.toDomain(ormorgdzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#ormorgdz_id,'Update',{'Sql',this.ormorgdzMapping,#ormorgdzdto})")
    @ApiOperation(value = "Update", tags = {"ORMORGDZ" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgdzs/{ormorgdz_id}")
    @Transactional
    public ResponseEntity<ORMORGDZDTO> update(@PathVariable("ormorgdz_id") String ormorgdz_id, @RequestBody ORMORGDZDTO ormorgdzdto) {
		ORMORGDZ domain  = ormorgdzMapping.toDomain(ormorgdzdto);
        domain .setOrmorgdzid(ormorgdz_id);
		ormorgdzService.update(domain );
		ORMORGDZDTO dto = ormorgdzMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.ormorgdzMapping,#ormorgdzdtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"ORMORGDZ" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgdzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ORMORGDZDTO> ormorgdzdtos) {
        ormorgdzService.updateBatch(ormorgdzMapping.toDomain(ormorgdzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGDZ-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"ORMORGDZ" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgdzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ORMORGDZDTO ormorgdzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormorgdzService.checkKey(ormorgdzMapping.toDomain(ormorgdzdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGDZ-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ORMORGDZ" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgdzs/fetchdefault")
	public ResponseEntity<List<ORMORGDZDTO>> fetchDefault(ORMORGDZSearchContext context) {
        Page<ORMORGDZ> domains = ormorgdzService.searchDefault(context) ;
        List<ORMORGDZDTO> list = ormorgdzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMORGDZ-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ORMORGDZ" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgdzs/searchdefault")
	public ResponseEntity<Page<ORMORGDZDTO>> searchDefault(@RequestBody ORMORGDZSearchContext context) {
        Page<ORMORGDZ> domains = ormorgdzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgdzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
