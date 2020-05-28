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
import cn.ibizlab.ehr.core.par.domain.PARJXZGPC;
import cn.ibizlab.ehr.core.par.service.IPARJXZGPCService;
import cn.ibizlab.ehr.core.par.filter.PARJXZGPCSearchContext;

@Slf4j
@Api(tags = {"PARJXZGPC" })
@RestController("WebApi-parjxzgpc")
@RequestMapping("")
public class PARJXZGPCResource {

    @Autowired
    public IPARJXZGPCService parjxzgpcService;

    @Autowired
    @Lazy
    public PARJXZGPCMapping parjxzgpcMapping;

    @PreAuthorize("hasPermission(this.parjxzgpcMapping.toDomain(#parjxzgpcdto),'ehr-PARJXZGPC-Create')")
    @ApiOperation(value = "Create", tags = {"PARJXZGPC" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxzgpcs")
    @Transactional
    public ResponseEntity<PARJXZGPCDTO> create(@RequestBody PARJXZGPCDTO parjxzgpcdto) {
        PARJXZGPC domain = parjxzgpcMapping.toDomain(parjxzgpcdto);
		parjxzgpcService.create(domain);
        PARJXZGPCDTO dto = parjxzgpcMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxzgpcMapping.toDomain(#parjxzgpcdtos),'ehr-PARJXZGPC-Create')")
    @ApiOperation(value = "createBatch", tags = {"PARJXZGPC" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxzgpcs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARJXZGPCDTO> parjxzgpcdtos) {
        parjxzgpcService.createBatch(parjxzgpcMapping.toDomain(parjxzgpcdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxzgpcMapping.toDomain(#parjxzgpcdto),'ehr-PARJXZGPC-Save')")
    @ApiOperation(value = "Save", tags = {"PARJXZGPC" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxzgpcs/save")
    public ResponseEntity<Boolean> save(@RequestBody PARJXZGPCDTO parjxzgpcdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parjxzgpcService.save(parjxzgpcMapping.toDomain(parjxzgpcdto)));
    }

    @PreAuthorize("hasPermission(this.parjxzgpcMapping.toDomain(#parjxzgpcdtos),'ehr-PARJXZGPC-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PARJXZGPC" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxzgpcs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARJXZGPCDTO> parjxzgpcdtos) {
        parjxzgpcService.saveBatch(parjxzgpcMapping.toDomain(parjxzgpcdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"PARJXZGPC" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxzgpcs/getdraft")
    public ResponseEntity<PARJXZGPCDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parjxzgpcMapping.toDto(parjxzgpcService.getDraft(new PARJXZGPC())));
    }

    @PostAuthorize("hasPermission(this.parjxzgpcMapping.toDomain(returnObject.body),'ehr-PARJXZGPC-Get')")
    @ApiOperation(value = "Get", tags = {"PARJXZGPC" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxzgpcs/{parjxzgpc_id}")
    public ResponseEntity<PARJXZGPCDTO> get(@PathVariable("parjxzgpc_id") String parjxzgpc_id) {
        PARJXZGPC domain = parjxzgpcService.get(parjxzgpc_id);
        PARJXZGPCDTO dto = parjxzgpcMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKey", tags = {"PARJXZGPC" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxzgpcs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARJXZGPCDTO parjxzgpcdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parjxzgpcService.checkKey(parjxzgpcMapping.toDomain(parjxzgpcdto)));
    }

    @PreAuthorize("hasPermission(this.parjxzgpcService.get(#parjxzgpc_id),'ehr-PARJXZGPC-Update')")
    @ApiOperation(value = "Update", tags = {"PARJXZGPC" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxzgpcs/{parjxzgpc_id}")
    @Transactional
    public ResponseEntity<PARJXZGPCDTO> update(@PathVariable("parjxzgpc_id") String parjxzgpc_id, @RequestBody PARJXZGPCDTO parjxzgpcdto) {
		PARJXZGPC domain  = parjxzgpcMapping.toDomain(parjxzgpcdto);
        domain .setParjxzgpcid(parjxzgpc_id);
		parjxzgpcService.update(domain );
		PARJXZGPCDTO dto = parjxzgpcMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxzgpcService.getParjxzgpcByEntities(this.parjxzgpcMapping.toDomain(#parjxzgpcdtos)),'ehr-PARJXZGPC-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PARJXZGPC" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxzgpcs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARJXZGPCDTO> parjxzgpcdtos) {
        parjxzgpcService.updateBatch(parjxzgpcMapping.toDomain(parjxzgpcdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxzgpcService.get(#parjxzgpc_id),'ehr-PARJXZGPC-Remove')")
    @ApiOperation(value = "Remove", tags = {"PARJXZGPC" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxzgpcs/{parjxzgpc_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parjxzgpc_id") String parjxzgpc_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parjxzgpcService.remove(parjxzgpc_id));
    }

    @PreAuthorize("hasPermission(this.parjxzgpcService.getParjxzgpcByIds(#ids),'ehr-PARJXZGPC-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PARJXZGPC" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxzgpcs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parjxzgpcService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXZGPC-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PARJXZGPC" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parjxzgpcs/fetchdefault")
	public ResponseEntity<List<PARJXZGPCDTO>> fetchDefault(PARJXZGPCSearchContext context) {
        Page<PARJXZGPC> domains = parjxzgpcService.searchDefault(context) ;
        List<PARJXZGPCDTO> list = parjxzgpcMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXZGPC-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PARJXZGPC" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parjxzgpcs/searchdefault")
	public ResponseEntity<Page<PARJXZGPCDTO>> searchDefault(@RequestBody PARJXZGPCSearchContext context) {
        Page<PARJXZGPC> domains = parjxzgpcService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjxzgpcMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

