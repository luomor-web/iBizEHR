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
import cn.ibizlab.ehr.core.par.domain.ParJxzgpc;
import cn.ibizlab.ehr.core.par.service.IParJxzgpcService;
import cn.ibizlab.ehr.core.par.filter.ParJxzgpcSearchContext;

@Slf4j
@Api(tags = {"ParJxzgpc" })
@RestController("WebApi-parjxzgpc")
@RequestMapping("")
public class ParJxzgpcResource {

    @Autowired
    public IParJxzgpcService parjxzgpcService;

    @Autowired
    @Lazy
    public ParJxzgpcMapping parjxzgpcMapping;

    @PreAuthorize("hasPermission(this.parjxzgpcMapping.toDomain(#parjxzgpcdto),'ehr-ParJxzgpc-Create')")
    @ApiOperation(value = "Create", tags = {"ParJxzgpc" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxzgpcs")
    @Transactional
    public ResponseEntity<ParJxzgpcDTO> create(@RequestBody ParJxzgpcDTO parjxzgpcdto) {
        ParJxzgpc domain = parjxzgpcMapping.toDomain(parjxzgpcdto);
		parjxzgpcService.create(domain);
        ParJxzgpcDTO dto = parjxzgpcMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxzgpcMapping.toDomain(#parjxzgpcdtos),'ehr-ParJxzgpc-Create')")
    @ApiOperation(value = "createBatch", tags = {"ParJxzgpc" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxzgpcs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParJxzgpcDTO> parjxzgpcdtos) {
        parjxzgpcService.createBatch(parjxzgpcMapping.toDomain(parjxzgpcdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxzgpcMapping.toDomain(#parjxzgpcdto),'ehr-ParJxzgpc-Save')")
    @ApiOperation(value = "Save", tags = {"ParJxzgpc" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxzgpcs/save")
    public ResponseEntity<Boolean> save(@RequestBody ParJxzgpcDTO parjxzgpcdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parjxzgpcService.save(parjxzgpcMapping.toDomain(parjxzgpcdto)));
    }

    @PreAuthorize("hasPermission(this.parjxzgpcMapping.toDomain(#parjxzgpcdtos),'ehr-ParJxzgpc-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"ParJxzgpc" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxzgpcs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParJxzgpcDTO> parjxzgpcdtos) {
        parjxzgpcService.saveBatch(parjxzgpcMapping.toDomain(parjxzgpcdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"ParJxzgpc" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxzgpcs/getdraft")
    public ResponseEntity<ParJxzgpcDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parjxzgpcMapping.toDto(parjxzgpcService.getDraft(new ParJxzgpc())));
    }

    @PostAuthorize("hasPermission(this.parjxzgpcMapping.toDomain(returnObject.body),'ehr-ParJxzgpc-Get')")
    @ApiOperation(value = "Get", tags = {"ParJxzgpc" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxzgpcs/{parjxzgpc_id}")
    public ResponseEntity<ParJxzgpcDTO> get(@PathVariable("parjxzgpc_id") String parjxzgpc_id) {
        ParJxzgpc domain = parjxzgpcService.get(parjxzgpc_id);
        ParJxzgpcDTO dto = parjxzgpcMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKey", tags = {"ParJxzgpc" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxzgpcs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParJxzgpcDTO parjxzgpcdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parjxzgpcService.checkKey(parjxzgpcMapping.toDomain(parjxzgpcdto)));
    }

    @PreAuthorize("hasPermission(this.parjxzgpcService.get(#parjxzgpc_id),'ehr-ParJxzgpc-Update')")
    @ApiOperation(value = "Update", tags = {"ParJxzgpc" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxzgpcs/{parjxzgpc_id}")
    @Transactional
    public ResponseEntity<ParJxzgpcDTO> update(@PathVariable("parjxzgpc_id") String parjxzgpc_id, @RequestBody ParJxzgpcDTO parjxzgpcdto) {
		ParJxzgpc domain  = parjxzgpcMapping.toDomain(parjxzgpcdto);
        domain .setParjxzgpcid(parjxzgpc_id);
		parjxzgpcService.update(domain );
		ParJxzgpcDTO dto = parjxzgpcMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxzgpcService.getParjxzgpcByEntities(this.parjxzgpcMapping.toDomain(#parjxzgpcdtos)),'ehr-ParJxzgpc-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"ParJxzgpc" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxzgpcs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParJxzgpcDTO> parjxzgpcdtos) {
        parjxzgpcService.updateBatch(parjxzgpcMapping.toDomain(parjxzgpcdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxzgpcService.get(#parjxzgpc_id),'ehr-ParJxzgpc-Remove')")
    @ApiOperation(value = "Remove", tags = {"ParJxzgpc" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxzgpcs/{parjxzgpc_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parjxzgpc_id") String parjxzgpc_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parjxzgpcService.remove(parjxzgpc_id));
    }

    @PreAuthorize("hasPermission(this.parjxzgpcService.getParjxzgpcByIds(#ids),'ehr-ParJxzgpc-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"ParJxzgpc" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxzgpcs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parjxzgpcService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJxzgpc-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ParJxzgpc" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parjxzgpcs/fetchdefault")
	public ResponseEntity<List<ParJxzgpcDTO>> fetchDefault(ParJxzgpcSearchContext context) {
        Page<ParJxzgpc> domains = parjxzgpcService.searchDefault(context) ;
        List<ParJxzgpcDTO> list = parjxzgpcMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJxzgpc-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ParJxzgpc" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parjxzgpcs/searchdefault")
	public ResponseEntity<Page<ParJxzgpcDTO>> searchDefault(@RequestBody ParJxzgpcSearchContext context) {
        Page<ParJxzgpc> domains = parjxzgpcService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjxzgpcMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

