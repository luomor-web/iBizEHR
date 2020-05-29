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
import org.springframework.security.access.prepost.PostAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import cn.ibizlab.ehr.webapi.dto.*;
import cn.ibizlab.ehr.webapi.mapping.*;
import cn.ibizlab.ehr.core.orm.domain.OrmXmsfhz;
import cn.ibizlab.ehr.core.orm.service.IOrmXmsfhzService;
import cn.ibizlab.ehr.core.orm.filter.OrmXmsfhzSearchContext;

@Slf4j
@Api(tags = {"OrmXmsfhz" })
@RestController("WebApi-ormxmsfhz")
@RequestMapping("")
public class OrmXmsfhzResource {

    @Autowired
    public IOrmXmsfhzService ormxmsfhzService;

    @Autowired
    @Lazy
    public OrmXmsfhzMapping ormxmsfhzMapping;

    @PreAuthorize("hasPermission(this.ormxmsfhzService.get(#ormxmsfhz_id),'ehr-OrmXmsfhz-Remove')")
    @ApiOperation(value = "Remove", tags = {"OrmXmsfhz" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormxmsfhzs/{ormxmsfhz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormxmsfhz_id") String ormxmsfhz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormxmsfhzService.remove(ormxmsfhz_id));
    }

    @PreAuthorize("hasPermission(this.ormxmsfhzService.getOrmxmsfhzByIds(#ids),'ehr-OrmXmsfhz-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"OrmXmsfhz" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormxmsfhzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormxmsfhzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormxmsfhzMapping.toDomain(#ormxmsfhzdto),'ehr-OrmXmsfhz-Create')")
    @ApiOperation(value = "Create", tags = {"OrmXmsfhz" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmsfhzs")
    @Transactional
    public ResponseEntity<OrmXmsfhzDTO> create(@RequestBody OrmXmsfhzDTO ormxmsfhzdto) {
        OrmXmsfhz domain = ormxmsfhzMapping.toDomain(ormxmsfhzdto);
		ormxmsfhzService.create(domain);
        OrmXmsfhzDTO dto = ormxmsfhzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmsfhzMapping.toDomain(#ormxmsfhzdtos),'ehr-OrmXmsfhz-Create')")
    @ApiOperation(value = "createBatch", tags = {"OrmXmsfhz" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmsfhzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrmXmsfhzDTO> ormxmsfhzdtos) {
        ormxmsfhzService.createBatch(ormxmsfhzMapping.toDomain(ormxmsfhzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormxmsfhzService.get(#ormxmsfhz_id),'ehr-OrmXmsfhz-Update')")
    @ApiOperation(value = "Update", tags = {"OrmXmsfhz" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormxmsfhzs/{ormxmsfhz_id}")
    @Transactional
    public ResponseEntity<OrmXmsfhzDTO> update(@PathVariable("ormxmsfhz_id") String ormxmsfhz_id, @RequestBody OrmXmsfhzDTO ormxmsfhzdto) {
		OrmXmsfhz domain  = ormxmsfhzMapping.toDomain(ormxmsfhzdto);
        domain .setOrmxmsfhzid(ormxmsfhz_id);
		ormxmsfhzService.update(domain );
		OrmXmsfhzDTO dto = ormxmsfhzMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmsfhzService.getOrmxmsfhzByEntities(this.ormxmsfhzMapping.toDomain(#ormxmsfhzdtos)),'ehr-OrmXmsfhz-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"OrmXmsfhz" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormxmsfhzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrmXmsfhzDTO> ormxmsfhzdtos) {
        ormxmsfhzService.updateBatch(ormxmsfhzMapping.toDomain(ormxmsfhzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"OrmXmsfhz" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormxmsfhzs/getdraft")
    public ResponseEntity<OrmXmsfhzDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormxmsfhzMapping.toDto(ormxmsfhzService.getDraft(new OrmXmsfhz())));
    }

    @ApiOperation(value = "CheckKey", tags = {"OrmXmsfhz" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmsfhzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrmXmsfhzDTO ormxmsfhzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormxmsfhzService.checkKey(ormxmsfhzMapping.toDomain(ormxmsfhzdto)));
    }

    @PostAuthorize("hasPermission(this.ormxmsfhzMapping.toDomain(returnObject.body),'ehr-OrmXmsfhz-Get')")
    @ApiOperation(value = "Get", tags = {"OrmXmsfhz" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormxmsfhzs/{ormxmsfhz_id}")
    public ResponseEntity<OrmXmsfhzDTO> get(@PathVariable("ormxmsfhz_id") String ormxmsfhz_id) {
        OrmXmsfhz domain = ormxmsfhzService.get(ormxmsfhz_id);
        OrmXmsfhzDTO dto = ormxmsfhzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmsfhzMapping.toDomain(#ormxmsfhzdto),'ehr-OrmXmsfhz-Save')")
    @ApiOperation(value = "Save", tags = {"OrmXmsfhz" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmsfhzs/save")
    public ResponseEntity<Boolean> save(@RequestBody OrmXmsfhzDTO ormxmsfhzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormxmsfhzService.save(ormxmsfhzMapping.toDomain(ormxmsfhzdto)));
    }

    @PreAuthorize("hasPermission(this.ormxmsfhzMapping.toDomain(#ormxmsfhzdtos),'ehr-OrmXmsfhz-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"OrmXmsfhz" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmsfhzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrmXmsfhzDTO> ormxmsfhzdtos) {
        ormxmsfhzService.saveBatch(ormxmsfhzMapping.toDomain(ormxmsfhzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmsfhz-AccOrg-all')")
	@ApiOperation(value = "fetch根据组织定位查询", tags = {"OrmXmsfhz" } ,notes = "fetch根据组织定位查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmsfhzs/fetchaccorg")
	public ResponseEntity<List<OrmXmsfhzDTO>> fetchAccOrg(OrmXmsfhzSearchContext context) {
        Page<OrmXmsfhz> domains = ormxmsfhzService.searchAccOrg(context) ;
        List<OrmXmsfhzDTO> list = ormxmsfhzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmsfhz-AccOrg-all')")
	@ApiOperation(value = "search根据组织定位查询", tags = {"OrmXmsfhz" } ,notes = "search根据组织定位查询")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmsfhzs/searchaccorg")
	public ResponseEntity<Page<OrmXmsfhzDTO>> searchAccOrg(@RequestBody OrmXmsfhzSearchContext context) {
        Page<OrmXmsfhz> domains = ormxmsfhzService.searchAccOrg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmsfhzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmsfhz-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"OrmXmsfhz" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmsfhzs/fetchdefault")
	public ResponseEntity<List<OrmXmsfhzDTO>> fetchDefault(OrmXmsfhzSearchContext context) {
        Page<OrmXmsfhz> domains = ormxmsfhzService.searchDefault(context) ;
        List<OrmXmsfhzDTO> list = ormxmsfhzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmsfhz-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"OrmXmsfhz" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmsfhzs/searchdefault")
	public ResponseEntity<Page<OrmXmsfhzDTO>> searchDefault(@RequestBody OrmXmsfhzSearchContext context) {
        Page<OrmXmsfhz> domains = ormxmsfhzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmsfhzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

