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
import cn.ibizlab.ehr.core.orm.domain.OrmXmxqhz;
import cn.ibizlab.ehr.core.orm.service.IOrmXmxqhzService;
import cn.ibizlab.ehr.core.orm.filter.OrmXmxqhzSearchContext;

@Slf4j
@Api(tags = {"OrmXmxqhz" })
@RestController("WebApi-ormxmxqhz")
@RequestMapping("")
public class OrmXmxqhzResource {

    @Autowired
    public IOrmXmxqhzService ormxmxqhzService;

    @Autowired
    @Lazy
    public OrmXmxqhzMapping ormxmxqhzMapping;

    @PreAuthorize("hasPermission(this.ormxmxqhzService.get(#ormxmxqhz_id),'ehr-OrmXmxqhz-Update')")
    @ApiOperation(value = "Update", tags = {"OrmXmxqhz" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormxmxqhzs/{ormxmxqhz_id}")
    @Transactional
    public ResponseEntity<OrmXmxqhzDTO> update(@PathVariable("ormxmxqhz_id") String ormxmxqhz_id, @RequestBody OrmXmxqhzDTO ormxmxqhzdto) {
		OrmXmxqhz domain  = ormxmxqhzMapping.toDomain(ormxmxqhzdto);
        domain .setOrmxmxqhzid(ormxmxqhz_id);
		ormxmxqhzService.update(domain );
		OrmXmxqhzDTO dto = ormxmxqhzMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmxqhzService.getOrmxmxqhzByEntities(this.ormxmxqhzMapping.toDomain(#ormxmxqhzdtos)),'ehr-OrmXmxqhz-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"OrmXmxqhz" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormxmxqhzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrmXmxqhzDTO> ormxmxqhzdtos) {
        ormxmxqhzService.updateBatch(ormxmxqhzMapping.toDomain(ormxmxqhzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormxmxqhzMapping.toDomain(#ormxmxqhzdto),'ehr-OrmXmxqhz-Save')")
    @ApiOperation(value = "Save", tags = {"OrmXmxqhz" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmxqhzs/save")
    public ResponseEntity<Boolean> save(@RequestBody OrmXmxqhzDTO ormxmxqhzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormxmxqhzService.save(ormxmxqhzMapping.toDomain(ormxmxqhzdto)));
    }

    @PreAuthorize("hasPermission(this.ormxmxqhzMapping.toDomain(#ormxmxqhzdtos),'ehr-OrmXmxqhz-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"OrmXmxqhz" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmxqhzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrmXmxqhzDTO> ormxmxqhzdtos) {
        ormxmxqhzService.saveBatch(ormxmxqhzMapping.toDomain(ormxmxqhzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"OrmXmxqhz" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormxmxqhzs/getdraft")
    public ResponseEntity<OrmXmxqhzDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormxmxqhzMapping.toDto(ormxmxqhzService.getDraft(new OrmXmxqhz())));
    }

    @ApiOperation(value = "CheckKey", tags = {"OrmXmxqhz" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmxqhzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrmXmxqhzDTO ormxmxqhzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormxmxqhzService.checkKey(ormxmxqhzMapping.toDomain(ormxmxqhzdto)));
    }

    @PreAuthorize("hasPermission(this.ormxmxqhzService.get(#ormxmxqhz_id),'ehr-OrmXmxqhz-Remove')")
    @ApiOperation(value = "Remove", tags = {"OrmXmxqhz" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormxmxqhzs/{ormxmxqhz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormxmxqhz_id") String ormxmxqhz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormxmxqhzService.remove(ormxmxqhz_id));
    }

    @PreAuthorize("hasPermission(this.ormxmxqhzService.getOrmxmxqhzByIds(#ids),'ehr-OrmXmxqhz-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"OrmXmxqhz" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormxmxqhzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormxmxqhzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormxmxqhzMapping.toDomain(returnObject.body),'ehr-OrmXmxqhz-Get')")
    @ApiOperation(value = "Get", tags = {"OrmXmxqhz" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormxmxqhzs/{ormxmxqhz_id}")
    public ResponseEntity<OrmXmxqhzDTO> get(@PathVariable("ormxmxqhz_id") String ormxmxqhz_id) {
        OrmXmxqhz domain = ormxmxqhzService.get(ormxmxqhz_id);
        OrmXmxqhzDTO dto = ormxmxqhzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmxqhzMapping.toDomain(#ormxmxqhzdto),'ehr-OrmXmxqhz-Create')")
    @ApiOperation(value = "Create", tags = {"OrmXmxqhz" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmxqhzs")
    @Transactional
    public ResponseEntity<OrmXmxqhzDTO> create(@RequestBody OrmXmxqhzDTO ormxmxqhzdto) {
        OrmXmxqhz domain = ormxmxqhzMapping.toDomain(ormxmxqhzdto);
		ormxmxqhzService.create(domain);
        OrmXmxqhzDTO dto = ormxmxqhzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmxqhzMapping.toDomain(#ormxmxqhzdtos),'ehr-OrmXmxqhz-Create')")
    @ApiOperation(value = "createBatch", tags = {"OrmXmxqhz" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmxqhzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrmXmxqhzDTO> ormxmxqhzdtos) {
        ormxmxqhzService.createBatch(ormxmxqhzMapping.toDomain(ormxmxqhzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmxqhz-XMRYQKMX-all')")
	@ApiOperation(value = "fetch项目人员缺口明细", tags = {"OrmXmxqhz" } ,notes = "fetch项目人员缺口明细")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmxqhzs/fetchxmryqkmx")
	public ResponseEntity<List<OrmXmxqhzDTO>> fetchXMRYQKMX(OrmXmxqhzSearchContext context) {
        Page<OrmXmxqhz> domains = ormxmxqhzService.searchXMRYQKMX(context) ;
        List<OrmXmxqhzDTO> list = ormxmxqhzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmxqhz-XMRYQKMX-all')")
	@ApiOperation(value = "search项目人员缺口明细", tags = {"OrmXmxqhz" } ,notes = "search项目人员缺口明细")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmxqhzs/searchxmryqkmx")
	public ResponseEntity<Page<OrmXmxqhzDTO>> searchXMRYQKMX(@RequestBody OrmXmxqhzSearchContext context) {
        Page<OrmXmxqhz> domains = ormxmxqhzService.searchXMRYQKMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmxqhzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmxqhz-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"OrmXmxqhz" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmxqhzs/fetchdefault")
	public ResponseEntity<List<OrmXmxqhzDTO>> fetchDefault(OrmXmxqhzSearchContext context) {
        Page<OrmXmxqhz> domains = ormxmxqhzService.searchDefault(context) ;
        List<OrmXmxqhzDTO> list = ormxmxqhzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmxqhz-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"OrmXmxqhz" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmxqhzs/searchdefault")
	public ResponseEntity<Page<OrmXmxqhzDTO>> searchDefault(@RequestBody OrmXmxqhzSearchContext context) {
        Page<OrmXmxqhz> domains = ormxmxqhzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmxqhzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

