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
import cn.ibizlab.ehr.core.par.domain.ParTzgg;
import cn.ibizlab.ehr.core.par.service.IParTzggService;
import cn.ibizlab.ehr.core.par.filter.ParTzggSearchContext;

@Slf4j
@Api(tags = {"ParTzgg" })
@RestController("WebApi-partzgg")
@RequestMapping("")
public class ParTzggResource {

    @Autowired
    public IParTzggService partzggService;

    @Autowired
    @Lazy
    public ParTzggMapping partzggMapping;

    @ApiOperation(value = "GetDraft", tags = {"ParTzgg" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/partzggs/getdraft")
    public ResponseEntity<ParTzggDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(partzggMapping.toDto(partzggService.getDraft(new ParTzgg())));
    }

    @PreAuthorize("hasPermission(this.partzggService.get(#partzgg_id),'ehr-ParTzgg-Remove')")
    @ApiOperation(value = "Remove", tags = {"ParTzgg" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/partzggs/{partzgg_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("partzgg_id") String partzgg_id) {
         return ResponseEntity.status(HttpStatus.OK).body(partzggService.remove(partzgg_id));
    }

    @PreAuthorize("hasPermission(this.partzggService.getPartzggByIds(#ids),'ehr-ParTzgg-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"ParTzgg" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/partzggs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        partzggService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.partzggMapping.toDomain(#partzggdto),'ehr-ParTzgg-Save')")
    @ApiOperation(value = "Save", tags = {"ParTzgg" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/save")
    public ResponseEntity<Boolean> save(@RequestBody ParTzggDTO partzggdto) {
        return ResponseEntity.status(HttpStatus.OK).body(partzggService.save(partzggMapping.toDomain(partzggdto)));
    }

    @PreAuthorize("hasPermission(this.partzggMapping.toDomain(#partzggdtos),'ehr-ParTzgg-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"ParTzgg" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParTzggDTO> partzggdtos) {
        partzggService.saveBatch(partzggMapping.toDomain(partzggdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.partzggMapping.toDomain(#partzggdto),'ehr-ParTzgg-Create')")
    @ApiOperation(value = "Create", tags = {"ParTzgg" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs")
    @Transactional
    public ResponseEntity<ParTzggDTO> create(@RequestBody ParTzggDTO partzggdto) {
        ParTzgg domain = partzggMapping.toDomain(partzggdto);
		partzggService.create(domain);
        ParTzggDTO dto = partzggMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.partzggMapping.toDomain(#partzggdtos),'ehr-ParTzgg-Create')")
    @ApiOperation(value = "createBatch", tags = {"ParTzgg" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParTzggDTO> partzggdtos) {
        partzggService.createBatch(partzggMapping.toDomain(partzggdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.partzggMapping.toDomain(returnObject.body),'ehr-ParTzgg-Get')")
    @ApiOperation(value = "Get", tags = {"ParTzgg" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/partzggs/{partzgg_id}")
    public ResponseEntity<ParTzggDTO> get(@PathVariable("partzgg_id") String partzgg_id) {
        ParTzgg domain = partzggService.get(partzgg_id);
        ParTzggDTO dto = partzggMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKey", tags = {"ParTzgg" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParTzggDTO partzggdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(partzggService.checkKey(partzggMapping.toDomain(partzggdto)));
    }

    @PreAuthorize("hasPermission(this.partzggService.get(#partzgg_id),'ehr-ParTzgg-Update')")
    @ApiOperation(value = "Update", tags = {"ParTzgg" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/partzggs/{partzgg_id}")
    @Transactional
    public ResponseEntity<ParTzggDTO> update(@PathVariable("partzgg_id") String partzgg_id, @RequestBody ParTzggDTO partzggdto) {
		ParTzgg domain  = partzggMapping.toDomain(partzggdto);
        domain .setPartzggid(partzgg_id);
		partzggService.update(domain );
		ParTzggDTO dto = partzggMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.partzggService.getPartzggByEntities(this.partzggMapping.toDomain(#partzggdtos)),'ehr-ParTzgg-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"ParTzgg" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/partzggs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParTzggDTO> partzggdtos) {
        partzggService.updateBatch(partzggMapping.toDomain(partzggdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParTzgg-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ParTzgg" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/partzggs/fetchdefault")
	public ResponseEntity<List<ParTzggDTO>> fetchDefault(ParTzggSearchContext context) {
        Page<ParTzgg> domains = partzggService.searchDefault(context) ;
        List<ParTzggDTO> list = partzggMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParTzgg-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ParTzgg" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/partzggs/searchdefault")
	public ResponseEntity<Page<ParTzggDTO>> searchDefault(@RequestBody ParTzggSearchContext context) {
        Page<ParTzgg> domains = partzggService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(partzggMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

