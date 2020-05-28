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
import cn.ibizlab.ehr.core.par.domain.PARJXKHMB;
import cn.ibizlab.ehr.core.par.service.IPARJXKHMBService;
import cn.ibizlab.ehr.core.par.filter.PARJXKHMBSearchContext;

@Slf4j
@Api(tags = {"PARJXKHMB" })
@RestController("WebApi-parjxkhmb")
@RequestMapping("")
public class PARJXKHMBResource {

    @Autowired
    public IPARJXKHMBService parjxkhmbService;

    @Autowired
    @Lazy
    public PARJXKHMBMapping parjxkhmbMapping;

    @ApiOperation(value = "CheckKey", tags = {"PARJXKHMB" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhmbs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARJXKHMBDTO parjxkhmbdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parjxkhmbService.checkKey(parjxkhmbMapping.toDomain(parjxkhmbdto)));
    }

    @PreAuthorize("hasPermission(this.parjxkhmbService.get(#parjxkhmb_id),'ehr-PARJXKHMB-Remove')")
    @ApiOperation(value = "Remove", tags = {"PARJXKHMB" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxkhmbs/{parjxkhmb_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parjxkhmb_id") String parjxkhmb_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parjxkhmbService.remove(parjxkhmb_id));
    }

    @PreAuthorize("hasPermission(this.parjxkhmbService.getParjxkhmbByIds(#ids),'ehr-PARJXKHMB-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PARJXKHMB" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxkhmbs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parjxkhmbService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parjxkhmbMapping.toDomain(returnObject.body),'ehr-PARJXKHMB-Get')")
    @ApiOperation(value = "Get", tags = {"PARJXKHMB" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxkhmbs/{parjxkhmb_id}")
    public ResponseEntity<PARJXKHMBDTO> get(@PathVariable("parjxkhmb_id") String parjxkhmb_id) {
        PARJXKHMB domain = parjxkhmbService.get(parjxkhmb_id);
        PARJXKHMBDTO dto = parjxkhmbMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxkhmbMapping.toDomain(#parjxkhmbdto),'ehr-PARJXKHMB-Create')")
    @ApiOperation(value = "Create", tags = {"PARJXKHMB" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhmbs")
    @Transactional
    public ResponseEntity<PARJXKHMBDTO> create(@RequestBody PARJXKHMBDTO parjxkhmbdto) {
        PARJXKHMB domain = parjxkhmbMapping.toDomain(parjxkhmbdto);
		parjxkhmbService.create(domain);
        PARJXKHMBDTO dto = parjxkhmbMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxkhmbMapping.toDomain(#parjxkhmbdtos),'ehr-PARJXKHMB-Create')")
    @ApiOperation(value = "createBatch", tags = {"PARJXKHMB" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhmbs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARJXKHMBDTO> parjxkhmbdtos) {
        parjxkhmbService.createBatch(parjxkhmbMapping.toDomain(parjxkhmbdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"PARJXKHMB" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxkhmbs/getdraft")
    public ResponseEntity<PARJXKHMBDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parjxkhmbMapping.toDto(parjxkhmbService.getDraft(new PARJXKHMB())));
    }

    @PreAuthorize("hasPermission(this.parjxkhmbMapping.toDomain(#parjxkhmbdto),'ehr-PARJXKHMB-Save')")
    @ApiOperation(value = "Save", tags = {"PARJXKHMB" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhmbs/save")
    public ResponseEntity<Boolean> save(@RequestBody PARJXKHMBDTO parjxkhmbdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parjxkhmbService.save(parjxkhmbMapping.toDomain(parjxkhmbdto)));
    }

    @PreAuthorize("hasPermission(this.parjxkhmbMapping.toDomain(#parjxkhmbdtos),'ehr-PARJXKHMB-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PARJXKHMB" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhmbs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARJXKHMBDTO> parjxkhmbdtos) {
        parjxkhmbService.saveBatch(parjxkhmbMapping.toDomain(parjxkhmbdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxkhmbService.get(#parjxkhmb_id),'ehr-PARJXKHMB-Update')")
    @ApiOperation(value = "Update", tags = {"PARJXKHMB" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxkhmbs/{parjxkhmb_id}")
    @Transactional
    public ResponseEntity<PARJXKHMBDTO> update(@PathVariable("parjxkhmb_id") String parjxkhmb_id, @RequestBody PARJXKHMBDTO parjxkhmbdto) {
		PARJXKHMB domain  = parjxkhmbMapping.toDomain(parjxkhmbdto);
        domain .setParjxkhmbid(parjxkhmb_id);
		parjxkhmbService.update(domain );
		PARJXKHMBDTO dto = parjxkhmbMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxkhmbService.getParjxkhmbByEntities(this.parjxkhmbMapping.toDomain(#parjxkhmbdtos)),'ehr-PARJXKHMB-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PARJXKHMB" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxkhmbs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARJXKHMBDTO> parjxkhmbdtos) {
        parjxkhmbService.updateBatch(parjxkhmbMapping.toDomain(parjxkhmbdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXKHMB-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PARJXKHMB" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parjxkhmbs/fetchdefault")
	public ResponseEntity<List<PARJXKHMBDTO>> fetchDefault(PARJXKHMBSearchContext context) {
        Page<PARJXKHMB> domains = parjxkhmbService.searchDefault(context) ;
        List<PARJXKHMBDTO> list = parjxkhmbMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXKHMB-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PARJXKHMB" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parjxkhmbs/searchdefault")
	public ResponseEntity<Page<PARJXKHMBDTO>> searchDefault(@RequestBody PARJXKHMBSearchContext context) {
        Page<PARJXKHMB> domains = parjxkhmbService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjxkhmbMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

