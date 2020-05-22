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
import cn.ibizlab.ehr.core.orm.domain.ORMZWDQGZ;
import cn.ibizlab.ehr.core.orm.service.IORMZWDQGZService;
import cn.ibizlab.ehr.core.orm.filter.ORMZWDQGZSearchContext;




@Slf4j
@Api(tags = {"ORMZWDQGZ" })
@RestController("WebApi-ormzwdqgz")
@RequestMapping("")
public class ORMZWDQGZResource {

    @Autowired
    private IORMZWDQGZService ormzwdqgzService;

    @Autowired
    @Lazy
    public ORMZWDQGZMapping ormzwdqgzMapping;

    public ORMZWDQGZDTO permissionDTO=new ORMZWDQGZDTO();

    @PreAuthorize("hasPermission(#ormzwdqgz_id,'Get',{'Sql',this.ormzwdqgzMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"ORMZWDQGZ" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormzwdqgzs/{ormzwdqgz_id}")
    public ResponseEntity<ORMZWDQGZDTO> get(@PathVariable("ormzwdqgz_id") String ormzwdqgz_id) {
        ORMZWDQGZ domain = ormzwdqgzService.get(ormzwdqgz_id);
        ORMZWDQGZDTO dto = ormzwdqgzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMZWDQGZ-Save-all')")
    @ApiOperation(value = "Save", tags = {"ORMZWDQGZ" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormzwdqgzs/save")
    public ResponseEntity<Boolean> save(@RequestBody ORMZWDQGZDTO ormzwdqgzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormzwdqgzService.save(ormzwdqgzMapping.toDomain(ormzwdqgzdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"ORMZWDQGZ" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormzwdqgzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ORMZWDQGZDTO> ormzwdqgzdtos) {
        ormzwdqgzService.saveBatch(ormzwdqgzMapping.toDomain(ormzwdqgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMZWDQGZ-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"ORMZWDQGZ" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormzwdqgzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ORMZWDQGZDTO ormzwdqgzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormzwdqgzService.checkKey(ormzwdqgzMapping.toDomain(ormzwdqgzdto)));
    }

    @PreAuthorize("hasPermission(#ormzwdqgz_id,'Update',{'Sql',this.ormzwdqgzMapping,#ormzwdqgzdto})")
    @ApiOperation(value = "Update", tags = {"ORMZWDQGZ" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormzwdqgzs/{ormzwdqgz_id}")
    @Transactional
    public ResponseEntity<ORMZWDQGZDTO> update(@PathVariable("ormzwdqgz_id") String ormzwdqgz_id, @RequestBody ORMZWDQGZDTO ormzwdqgzdto) {
		ORMZWDQGZ domain = ormzwdqgzMapping.toDomain(ormzwdqgzdto);
        domain.setOrmzwdqgzid(ormzwdqgz_id);
		ormzwdqgzService.update(domain);
		ORMZWDQGZDTO dto = ormzwdqgzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"ORMZWDQGZ" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormzwdqgzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ORMZWDQGZDTO> ormzwdqgzdtos) {
        ormzwdqgzService.updateBatch(ormzwdqgzMapping.toDomain(ormzwdqgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMZWDQGZ-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"ORMZWDQGZ" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormzwdqgzs/getdraft")
    public ResponseEntity<ORMZWDQGZDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormzwdqgzMapping.toDto(ormzwdqgzService.getDraft(new ORMZWDQGZ())));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.ormzwdqgzMapping,#ormzwdqgzdto})")
    @ApiOperation(value = "Create", tags = {"ORMZWDQGZ" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormzwdqgzs")
    @Transactional
    public ResponseEntity<ORMZWDQGZDTO> create(@RequestBody ORMZWDQGZDTO ormzwdqgzdto) {
        ORMZWDQGZ domain = ormzwdqgzMapping.toDomain(ormzwdqgzdto);
		ormzwdqgzService.create(domain);
        ORMZWDQGZDTO dto = ormzwdqgzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"ORMZWDQGZ" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormzwdqgzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ORMZWDQGZDTO> ormzwdqgzdtos) {
        ormzwdqgzService.createBatch(ormzwdqgzMapping.toDomain(ormzwdqgzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#ormzwdqgz_id,'Remove',{'Sql',this.ormzwdqgzMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"ORMZWDQGZ" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormzwdqgzs/{ormzwdqgz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormzwdqgz_id") String ormzwdqgz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormzwdqgzService.remove(ormzwdqgz_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"ORMZWDQGZ" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormzwdqgzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormzwdqgzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMZWDQGZ-DQYHZZ-all')")
	@ApiOperation(value = "fetch查看当前单位的职级到期规则", tags = {"ORMZWDQGZ" } ,notes = "fetch查看当前单位的职级到期规则")
    @RequestMapping(method= RequestMethod.GET , value="/ormzwdqgzs/fetchdqyhzz")
	public ResponseEntity<List<ORMZWDQGZDTO>> fetchDQYHZZ(ORMZWDQGZSearchContext context) {
        Page<ORMZWDQGZ> domains = ormzwdqgzService.searchDQYHZZ(context) ;
        List<ORMZWDQGZDTO> list = ormzwdqgzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMZWDQGZ-DQYHZZ-all')")
	@ApiOperation(value = "search查看当前单位的职级到期规则", tags = {"ORMZWDQGZ" } ,notes = "search查看当前单位的职级到期规则")
    @RequestMapping(method= RequestMethod.POST , value="/ormzwdqgzs/searchdqyhzz")
	public ResponseEntity<Page<ORMZWDQGZDTO>> searchDQYHZZ(@RequestBody ORMZWDQGZSearchContext context) {
        Page<ORMZWDQGZ> domains = ormzwdqgzService.searchDQYHZZ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormzwdqgzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMZWDQGZ-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ORMZWDQGZ" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormzwdqgzs/fetchdefault")
	public ResponseEntity<List<ORMZWDQGZDTO>> fetchDefault(ORMZWDQGZSearchContext context) {
        Page<ORMZWDQGZ> domains = ormzwdqgzService.searchDefault(context) ;
        List<ORMZWDQGZDTO> list = ormzwdqgzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMZWDQGZ-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ORMZWDQGZ" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormzwdqgzs/searchdefault")
	public ResponseEntity<Page<ORMZWDQGZDTO>> searchDefault(@RequestBody ORMZWDQGZSearchContext context) {
        Page<ORMZWDQGZ> domains = ormzwdqgzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormzwdqgzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
