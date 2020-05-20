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
import cn.ibizlab.ehr.core.orm.domain.ORMXMSFHZ;
import cn.ibizlab.ehr.core.orm.service.IORMXMSFHZService;
import cn.ibizlab.ehr.core.orm.filter.ORMXMSFHZSearchContext;




@Slf4j
@Api(tags = {"ORMXMSFHZ" })
@RestController("WebApi-ormxmsfhz")
@RequestMapping("")
public class ORMXMSFHZResource {

    @Autowired
    private IORMXMSFHZService ormxmsfhzService;

    @Autowired
    @Lazy
    private ORMXMSFHZMapping ormxmsfhzMapping;




    @PreAuthorize("hasPermission(#ormxmsfhz_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"ORMXMSFHZ" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormxmsfhzs/{ormxmsfhz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormxmsfhz_id") String ormxmsfhz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormxmsfhzService.remove(ormxmsfhz_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"ORMXMSFHZ" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormxmsfhzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormxmsfhzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"ORMXMSFHZ" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmsfhzs")
    @Transactional
    public ResponseEntity<ORMXMSFHZDTO> create(@RequestBody ORMXMSFHZDTO ormxmsfhzdto) {
        ORMXMSFHZ domain = ormxmsfhzMapping.toDomain(ormxmsfhzdto);
		ormxmsfhzService.create(domain);
        ORMXMSFHZDTO dto = ormxmsfhzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"ORMXMSFHZ" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmsfhzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ORMXMSFHZDTO> ormxmsfhzdtos) {
        ormxmsfhzService.createBatch(ormxmsfhzMapping.toDomain(ormxmsfhzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#ormxmsfhz_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"ORMXMSFHZ" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormxmsfhzs/{ormxmsfhz_id}")
    @Transactional
    public ResponseEntity<ORMXMSFHZDTO> update(@PathVariable("ormxmsfhz_id") String ormxmsfhz_id, @RequestBody ORMXMSFHZDTO ormxmsfhzdto) {
		ORMXMSFHZ domain = ormxmsfhzMapping.toDomain(ormxmsfhzdto);
        domain.setOrmxmsfhzid(ormxmsfhz_id);
		ormxmsfhzService.update(domain);
		ORMXMSFHZDTO dto = ormxmsfhzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#ormxmsfhz_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"ORMXMSFHZ" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormxmsfhzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ORMXMSFHZDTO> ormxmsfhzdtos) {
        ormxmsfhzService.updateBatch(ormxmsfhzMapping.toDomain(ormxmsfhzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"ORMXMSFHZ" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormxmsfhzs/getdraft")
    public ResponseEntity<ORMXMSFHZDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormxmsfhzMapping.toDto(ormxmsfhzService.getDraft(new ORMXMSFHZ())));
    }




    @ApiOperation(value = "CheckKey", tags = {"ORMXMSFHZ" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmsfhzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ORMXMSFHZDTO ormxmsfhzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormxmsfhzService.checkKey(ormxmsfhzMapping.toDomain(ormxmsfhzdto)));
    }




    @PreAuthorize("hasPermission(#ormxmsfhz_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"ORMXMSFHZ" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormxmsfhzs/{ormxmsfhz_id}")
    public ResponseEntity<ORMXMSFHZDTO> get(@PathVariable("ormxmsfhz_id") String ormxmsfhz_id) {
        ORMXMSFHZ domain = ormxmsfhzService.get(ormxmsfhz_id);
        ORMXMSFHZDTO dto = ormxmsfhzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "Save", tags = {"ORMXMSFHZ" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmsfhzs/save")
    public ResponseEntity<Boolean> save(@RequestBody ORMXMSFHZDTO ormxmsfhzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormxmsfhzService.save(ormxmsfhzMapping.toDomain(ormxmsfhzdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"ORMXMSFHZ" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmsfhzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ORMXMSFHZDTO> ormxmsfhzdtos) {
        ormxmsfhzService.saveBatch(ormxmsfhzMapping.toDomain(ormxmsfhzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMSFHZ-AccOrg-all')")
	@ApiOperation(value = "fetch根据组织定位查询", tags = {"ORMXMSFHZ" } ,notes = "fetch根据组织定位查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmsfhzs/fetchaccorg")
	public ResponseEntity<List<ORMXMSFHZDTO>> fetchAccOrg(ORMXMSFHZSearchContext context) {
        Page<ORMXMSFHZ> domains = ormxmsfhzService.searchAccOrg(context) ;
        List<ORMXMSFHZDTO> list = ormxmsfhzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMSFHZ-AccOrg-all')")
	@ApiOperation(value = "search根据组织定位查询", tags = {"ORMXMSFHZ" } ,notes = "search根据组织定位查询")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmsfhzs/searchaccorg")
	public ResponseEntity<Page<ORMXMSFHZDTO>> searchAccOrg(@RequestBody ORMXMSFHZSearchContext context) {
        Page<ORMXMSFHZ> domains = ormxmsfhzService.searchAccOrg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmsfhzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMSFHZ-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ORMXMSFHZ" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmsfhzs/fetchdefault")
	public ResponseEntity<List<ORMXMSFHZDTO>> fetchDefault(ORMXMSFHZSearchContext context) {
        Page<ORMXMSFHZ> domains = ormxmsfhzService.searchDefault(context) ;
        List<ORMXMSFHZDTO> list = ormxmsfhzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMSFHZ-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ORMXMSFHZ" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmsfhzs/searchdefault")
	public ResponseEntity<Page<ORMXMSFHZDTO>> searchDefault(@RequestBody ORMXMSFHZSearchContext context) {
        Page<ORMXMSFHZ> domains = ormxmsfhzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmsfhzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public ORMXMSFHZ getEntity(){
        return new ORMXMSFHZ();
    }

}
