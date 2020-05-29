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
import cn.ibizlab.ehr.core.par.domain.ParJgbmpjbz;
import cn.ibizlab.ehr.core.par.service.IParJgbmpjbzService;
import cn.ibizlab.ehr.core.par.filter.ParJgbmpjbzSearchContext;

@Slf4j
@Api(tags = {"ParJgbmpjbz" })
@RestController("WebApi-parjgbmpjbz")
@RequestMapping("")
public class ParJgbmpjbzResource {

    @Autowired
    public IParJgbmpjbzService parjgbmpjbzService;

    @Autowired
    @Lazy
    public ParJgbmpjbzMapping parjgbmpjbzMapping;

    @ApiOperation(value = "CheckKey", tags = {"ParJgbmpjbz" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parjgbmpjbzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParJgbmpjbzDTO parjgbmpjbzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parjgbmpjbzService.checkKey(parjgbmpjbzMapping.toDomain(parjgbmpjbzdto)));
    }

    @PostAuthorize("hasPermission(this.parjgbmpjbzMapping.toDomain(returnObject.body),'ehr-ParJgbmpjbz-Get')")
    @ApiOperation(value = "Get", tags = {"ParJgbmpjbz" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parjgbmpjbzs/{parjgbmpjbz_id}")
    public ResponseEntity<ParJgbmpjbzDTO> get(@PathVariable("parjgbmpjbz_id") String parjgbmpjbz_id) {
        ParJgbmpjbz domain = parjgbmpjbzService.get(parjgbmpjbz_id);
        ParJgbmpjbzDTO dto = parjgbmpjbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjgbmpjbzService.get(#parjgbmpjbz_id),'ehr-ParJgbmpjbz-Remove')")
    @ApiOperation(value = "Remove", tags = {"ParJgbmpjbz" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjgbmpjbzs/{parjgbmpjbz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parjgbmpjbz_id") String parjgbmpjbz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parjgbmpjbzService.remove(parjgbmpjbz_id));
    }

    @PreAuthorize("hasPermission(this.parjgbmpjbzService.getParjgbmpjbzByIds(#ids),'ehr-ParJgbmpjbz-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"ParJgbmpjbz" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjgbmpjbzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parjgbmpjbzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjgbmpjbzMapping.toDomain(#parjgbmpjbzdto),'ehr-ParJgbmpjbz-Create')")
    @ApiOperation(value = "Create", tags = {"ParJgbmpjbz" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parjgbmpjbzs")
    @Transactional
    public ResponseEntity<ParJgbmpjbzDTO> create(@RequestBody ParJgbmpjbzDTO parjgbmpjbzdto) {
        ParJgbmpjbz domain = parjgbmpjbzMapping.toDomain(parjgbmpjbzdto);
		parjgbmpjbzService.create(domain);
        ParJgbmpjbzDTO dto = parjgbmpjbzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjgbmpjbzMapping.toDomain(#parjgbmpjbzdtos),'ehr-ParJgbmpjbz-Create')")
    @ApiOperation(value = "createBatch", tags = {"ParJgbmpjbz" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjgbmpjbzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParJgbmpjbzDTO> parjgbmpjbzdtos) {
        parjgbmpjbzService.createBatch(parjgbmpjbzMapping.toDomain(parjgbmpjbzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjgbmpjbzService.get(#parjgbmpjbz_id),'ehr-ParJgbmpjbz-Update')")
    @ApiOperation(value = "Update", tags = {"ParJgbmpjbz" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjgbmpjbzs/{parjgbmpjbz_id}")
    @Transactional
    public ResponseEntity<ParJgbmpjbzDTO> update(@PathVariable("parjgbmpjbz_id") String parjgbmpjbz_id, @RequestBody ParJgbmpjbzDTO parjgbmpjbzdto) {
		ParJgbmpjbz domain  = parjgbmpjbzMapping.toDomain(parjgbmpjbzdto);
        domain .setParjgbmpjbzid(parjgbmpjbz_id);
		parjgbmpjbzService.update(domain );
		ParJgbmpjbzDTO dto = parjgbmpjbzMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjgbmpjbzService.getParjgbmpjbzByEntities(this.parjgbmpjbzMapping.toDomain(#parjgbmpjbzdtos)),'ehr-ParJgbmpjbz-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"ParJgbmpjbz" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjgbmpjbzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParJgbmpjbzDTO> parjgbmpjbzdtos) {
        parjgbmpjbzService.updateBatch(parjgbmpjbzMapping.toDomain(parjgbmpjbzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjgbmpjbzMapping.toDomain(#parjgbmpjbzdto),'ehr-ParJgbmpjbz-Save')")
    @ApiOperation(value = "Save", tags = {"ParJgbmpjbz" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parjgbmpjbzs/save")
    public ResponseEntity<Boolean> save(@RequestBody ParJgbmpjbzDTO parjgbmpjbzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parjgbmpjbzService.save(parjgbmpjbzMapping.toDomain(parjgbmpjbzdto)));
    }

    @PreAuthorize("hasPermission(this.parjgbmpjbzMapping.toDomain(#parjgbmpjbzdtos),'ehr-ParJgbmpjbz-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"ParJgbmpjbz" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjgbmpjbzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParJgbmpjbzDTO> parjgbmpjbzdtos) {
        parjgbmpjbzService.saveBatch(parjgbmpjbzMapping.toDomain(parjgbmpjbzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"ParJgbmpjbz" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parjgbmpjbzs/getdraft")
    public ResponseEntity<ParJgbmpjbzDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parjgbmpjbzMapping.toDto(parjgbmpjbzService.getDraft(new ParJgbmpjbz())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJgbmpjbz-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ParJgbmpjbz" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parjgbmpjbzs/fetchdefault")
	public ResponseEntity<List<ParJgbmpjbzDTO>> fetchDefault(ParJgbmpjbzSearchContext context) {
        Page<ParJgbmpjbz> domains = parjgbmpjbzService.searchDefault(context) ;
        List<ParJgbmpjbzDTO> list = parjgbmpjbzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJgbmpjbz-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ParJgbmpjbz" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parjgbmpjbzs/searchdefault")
	public ResponseEntity<Page<ParJgbmpjbzDTO>> searchDefault(@RequestBody ParJgbmpjbzSearchContext context) {
        Page<ParJgbmpjbz> domains = parjgbmpjbzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjgbmpjbzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

