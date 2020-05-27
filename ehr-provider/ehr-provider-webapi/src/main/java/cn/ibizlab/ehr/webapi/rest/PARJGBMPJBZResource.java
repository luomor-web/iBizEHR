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
import cn.ibizlab.ehr.core.par.domain.PARJGBMPJBZ;
import cn.ibizlab.ehr.core.par.service.IPARJGBMPJBZService;
import cn.ibizlab.ehr.core.par.filter.PARJGBMPJBZSearchContext;

@Slf4j
@Api(tags = {"PARJGBMPJBZ" })
@RestController("WebApi-parjgbmpjbz")
@RequestMapping("")
public class PARJGBMPJBZResource {

    @Autowired
    public IPARJGBMPJBZService parjgbmpjbzService;

    @Autowired
    @Lazy
    public PARJGBMPJBZMapping parjgbmpjbzMapping;

    @ApiOperation(value = "CheckKey", tags = {"PARJGBMPJBZ" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parjgbmpjbzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARJGBMPJBZDTO parjgbmpjbzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parjgbmpjbzService.checkKey(parjgbmpjbzMapping.toDomain(parjgbmpjbzdto)));
    }

    @PostAuthorize("hasPermission(this.parjgbmpjbzMapping.toDomain(returnObject.body),'ehr-PARJGBMPJBZ-Get')")
    @ApiOperation(value = "Get", tags = {"PARJGBMPJBZ" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parjgbmpjbzs/{parjgbmpjbz_id}")
    public ResponseEntity<PARJGBMPJBZDTO> get(@PathVariable("parjgbmpjbz_id") String parjgbmpjbz_id) {
        PARJGBMPJBZ domain = parjgbmpjbzService.get(parjgbmpjbz_id);
        PARJGBMPJBZDTO dto = parjgbmpjbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjgbmpjbzService.get(#parjgbmpjbz_id),'ehr-PARJGBMPJBZ-Remove')")
    @ApiOperation(value = "Remove", tags = {"PARJGBMPJBZ" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjgbmpjbzs/{parjgbmpjbz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parjgbmpjbz_id") String parjgbmpjbz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parjgbmpjbzService.remove(parjgbmpjbz_id));
    }

    @PreAuthorize("hasPermission(this.parjgbmpjbzService.getParjgbmpjbzByIds(#ids),'ehr-PARJGBMPJBZ-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PARJGBMPJBZ" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjgbmpjbzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parjgbmpjbzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjgbmpjbzMapping.toDomain(#parjgbmpjbzdto),'ehr-PARJGBMPJBZ-Create')")
    @ApiOperation(value = "Create", tags = {"PARJGBMPJBZ" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parjgbmpjbzs")
    @Transactional
    public ResponseEntity<PARJGBMPJBZDTO> create(@RequestBody PARJGBMPJBZDTO parjgbmpjbzdto) {
        PARJGBMPJBZ domain = parjgbmpjbzMapping.toDomain(parjgbmpjbzdto);
		parjgbmpjbzService.create(domain);
        PARJGBMPJBZDTO dto = parjgbmpjbzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjgbmpjbzMapping.toDomain(#parjgbmpjbzdtos),'ehr-PARJGBMPJBZ-Create')")
    @ApiOperation(value = "createBatch", tags = {"PARJGBMPJBZ" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjgbmpjbzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARJGBMPJBZDTO> parjgbmpjbzdtos) {
        parjgbmpjbzService.createBatch(parjgbmpjbzMapping.toDomain(parjgbmpjbzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjgbmpjbzService.get(#parjgbmpjbz_id),'ehr-PARJGBMPJBZ-Update')")
    @ApiOperation(value = "Update", tags = {"PARJGBMPJBZ" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjgbmpjbzs/{parjgbmpjbz_id}")
    @Transactional
    public ResponseEntity<PARJGBMPJBZDTO> update(@PathVariable("parjgbmpjbz_id") String parjgbmpjbz_id, @RequestBody PARJGBMPJBZDTO parjgbmpjbzdto) {
		PARJGBMPJBZ domain  = parjgbmpjbzMapping.toDomain(parjgbmpjbzdto);
        domain .setParjgbmpjbzid(parjgbmpjbz_id);
		parjgbmpjbzService.update(domain );
		PARJGBMPJBZDTO dto = parjgbmpjbzMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjgbmpjbzService.getParjgbmpjbzByEntities(this.parjgbmpjbzMapping.toDomain(#parjgbmpjbzdtos)),'ehr-PARJGBMPJBZ-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PARJGBMPJBZ" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjgbmpjbzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARJGBMPJBZDTO> parjgbmpjbzdtos) {
        parjgbmpjbzService.updateBatch(parjgbmpjbzMapping.toDomain(parjgbmpjbzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjgbmpjbzMapping.toDomain(#parjgbmpjbzdto),'ehr-PARJGBMPJBZ-Save')")
    @ApiOperation(value = "Save", tags = {"PARJGBMPJBZ" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parjgbmpjbzs/save")
    public ResponseEntity<Boolean> save(@RequestBody PARJGBMPJBZDTO parjgbmpjbzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parjgbmpjbzService.save(parjgbmpjbzMapping.toDomain(parjgbmpjbzdto)));
    }

    @PreAuthorize("hasPermission(this.parjgbmpjbzMapping.toDomain(#parjgbmpjbzdtos),'ehr-PARJGBMPJBZ-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PARJGBMPJBZ" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjgbmpjbzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARJGBMPJBZDTO> parjgbmpjbzdtos) {
        parjgbmpjbzService.saveBatch(parjgbmpjbzMapping.toDomain(parjgbmpjbzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"PARJGBMPJBZ" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parjgbmpjbzs/getdraft")
    public ResponseEntity<PARJGBMPJBZDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parjgbmpjbzMapping.toDto(parjgbmpjbzService.getDraft(new PARJGBMPJBZ())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJGBMPJBZ-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PARJGBMPJBZ" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parjgbmpjbzs/fetchdefault")
	public ResponseEntity<List<PARJGBMPJBZDTO>> fetchDefault(PARJGBMPJBZSearchContext context) {
        Page<PARJGBMPJBZ> domains = parjgbmpjbzService.searchDefault(context) ;
        List<PARJGBMPJBZDTO> list = parjgbmpjbzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJGBMPJBZ-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PARJGBMPJBZ" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parjgbmpjbzs/searchdefault")
	public ResponseEntity<Page<PARJGBMPJBZDTO>> searchDefault(@RequestBody PARJGBMPJBZSearchContext context) {
        Page<PARJGBMPJBZ> domains = parjgbmpjbzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjgbmpjbzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

