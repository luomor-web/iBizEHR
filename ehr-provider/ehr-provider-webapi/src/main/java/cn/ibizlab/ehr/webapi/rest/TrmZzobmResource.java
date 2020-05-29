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
import cn.ibizlab.ehr.core.trm.domain.TrmZzobm;
import cn.ibizlab.ehr.core.trm.service.ITrmZzobmService;
import cn.ibizlab.ehr.core.trm.filter.TrmZzobmSearchContext;

@Slf4j
@Api(tags = {"TrmZzobm" })
@RestController("WebApi-trmzzobm")
@RequestMapping("")
public class TrmZzobmResource {

    @Autowired
    public ITrmZzobmService trmzzobmService;

    @Autowired
    @Lazy
    public TrmZzobmMapping trmzzobmMapping;

    @PreAuthorize("hasPermission(this.trmzzobmMapping.toDomain(#trmzzobmdto),'ehr-TrmZzobm-Create')")
    @ApiOperation(value = "Create", tags = {"TrmZzobm" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmzzobms")
    @Transactional
    public ResponseEntity<TrmZzobmDTO> create(@RequestBody TrmZzobmDTO trmzzobmdto) {
        TrmZzobm domain = trmzzobmMapping.toDomain(trmzzobmdto);
		trmzzobmService.create(domain);
        TrmZzobmDTO dto = trmzzobmMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmzzobmMapping.toDomain(#trmzzobmdtos),'ehr-TrmZzobm-Create')")
    @ApiOperation(value = "createBatch", tags = {"TrmZzobm" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmzzobms/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmZzobmDTO> trmzzobmdtos) {
        trmzzobmService.createBatch(trmzzobmMapping.toDomain(trmzzobmdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmzzobmService.get(#trmzzobm_id),'ehr-TrmZzobm-Update')")
    @ApiOperation(value = "Update", tags = {"TrmZzobm" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmzzobms/{trmzzobm_id}")
    @Transactional
    public ResponseEntity<TrmZzobmDTO> update(@PathVariable("trmzzobm_id") String trmzzobm_id, @RequestBody TrmZzobmDTO trmzzobmdto) {
		TrmZzobm domain  = trmzzobmMapping.toDomain(trmzzobmdto);
        domain .setTrmzzobmid(trmzzobm_id);
		trmzzobmService.update(domain );
		TrmZzobmDTO dto = trmzzobmMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmzzobmService.getTrmzzobmByEntities(this.trmzzobmMapping.toDomain(#trmzzobmdtos)),'ehr-TrmZzobm-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"TrmZzobm" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmzzobms/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmZzobmDTO> trmzzobmdtos) {
        trmzzobmService.updateBatch(trmzzobmMapping.toDomain(trmzzobmdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"TrmZzobm" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmzzobms/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmZzobmDTO trmzzobmdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmzzobmService.checkKey(trmzzobmMapping.toDomain(trmzzobmdto)));
    }

    @ApiOperation(value = "GetDraft", tags = {"TrmZzobm" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmzzobms/getdraft")
    public ResponseEntity<TrmZzobmDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmzzobmMapping.toDto(trmzzobmService.getDraft(new TrmZzobm())));
    }

    @PreAuthorize("hasPermission(this.trmzzobmMapping.toDomain(#trmzzobmdto),'ehr-TrmZzobm-Save')")
    @ApiOperation(value = "Save", tags = {"TrmZzobm" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmzzobms/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmZzobmDTO trmzzobmdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmzzobmService.save(trmzzobmMapping.toDomain(trmzzobmdto)));
    }

    @PreAuthorize("hasPermission(this.trmzzobmMapping.toDomain(#trmzzobmdtos),'ehr-TrmZzobm-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"TrmZzobm" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmzzobms/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmZzobmDTO> trmzzobmdtos) {
        trmzzobmService.saveBatch(trmzzobmMapping.toDomain(trmzzobmdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmzzobmMapping.toDomain(returnObject.body),'ehr-TrmZzobm-Get')")
    @ApiOperation(value = "Get", tags = {"TrmZzobm" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmzzobms/{trmzzobm_id}")
    public ResponseEntity<TrmZzobmDTO> get(@PathVariable("trmzzobm_id") String trmzzobm_id) {
        TrmZzobm domain = trmzzobmService.get(trmzzobm_id);
        TrmZzobmDTO dto = trmzzobmMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmzzobmService.get(#trmzzobm_id),'ehr-TrmZzobm-Remove')")
    @ApiOperation(value = "Remove", tags = {"TrmZzobm" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmzzobms/{trmzzobm_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmzzobm_id") String trmzzobm_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmzzobmService.remove(trmzzobm_id));
    }

    @PreAuthorize("hasPermission(this.trmzzobmService.getTrmzzobmByIds(#ids),'ehr-TrmZzobm-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"TrmZzobm" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmzzobms/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmzzobmService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmZzobm-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TrmZzobm" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmzzobms/fetchdefault")
	public ResponseEntity<List<TrmZzobmDTO>> fetchDefault(TrmZzobmSearchContext context) {
        Page<TrmZzobm> domains = trmzzobmService.searchDefault(context) ;
        List<TrmZzobmDTO> list = trmzzobmMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmZzobm-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TrmZzobm" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmzzobms/searchdefault")
	public ResponseEntity<Page<TrmZzobmDTO>> searchDefault(@RequestBody TrmZzobmSearchContext context) {
        Page<TrmZzobm> domains = trmzzobmService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmzzobmMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

