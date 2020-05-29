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
import cn.ibizlab.ehr.core.trm.domain.TrmStaffnodes;
import cn.ibizlab.ehr.core.trm.service.ITrmStaffnodesService;
import cn.ibizlab.ehr.core.trm.filter.TrmStaffnodesSearchContext;

@Slf4j
@Api(tags = {"TrmStaffnodes" })
@RestController("WebApi-trmstaffnodes")
@RequestMapping("")
public class TrmStaffnodesResource {

    @Autowired
    public ITrmStaffnodesService trmstaffnodesService;

    @Autowired
    @Lazy
    public TrmStaffnodesMapping trmstaffnodesMapping;

    @PreAuthorize("hasPermission(this.trmstaffnodesService.get(#trmstaffnodes_id),'ehr-TrmStaffnodes-Remove')")
    @ApiOperation(value = "Remove", tags = {"TrmStaffnodes" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmstaffnodes/{trmstaffnodes_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmstaffnodes_id") String trmstaffnodes_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmstaffnodesService.remove(trmstaffnodes_id));
    }

    @PreAuthorize("hasPermission(this.trmstaffnodesService.getTrmstaffnodesByIds(#ids),'ehr-TrmStaffnodes-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"TrmStaffnodes" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmstaffnodes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmstaffnodesService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmstaffnodesMapping.toDomain(returnObject.body),'ehr-TrmStaffnodes-Get')")
    @ApiOperation(value = "Get", tags = {"TrmStaffnodes" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmstaffnodes/{trmstaffnodes_id}")
    public ResponseEntity<TrmStaffnodesDTO> get(@PathVariable("trmstaffnodes_id") String trmstaffnodes_id) {
        TrmStaffnodes domain = trmstaffnodesService.get(trmstaffnodes_id);
        TrmStaffnodesDTO dto = trmstaffnodesMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKey", tags = {"TrmStaffnodes" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmstaffnodes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmStaffnodesDTO trmstaffnodesdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmstaffnodesService.checkKey(trmstaffnodesMapping.toDomain(trmstaffnodesdto)));
    }

    @PreAuthorize("hasPermission(this.trmstaffnodesService.get(#trmstaffnodes_id),'ehr-TrmStaffnodes-Update')")
    @ApiOperation(value = "Update", tags = {"TrmStaffnodes" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmstaffnodes/{trmstaffnodes_id}")
    @Transactional
    public ResponseEntity<TrmStaffnodesDTO> update(@PathVariable("trmstaffnodes_id") String trmstaffnodes_id, @RequestBody TrmStaffnodesDTO trmstaffnodesdto) {
		TrmStaffnodes domain  = trmstaffnodesMapping.toDomain(trmstaffnodesdto);
        domain .setTrmstaffnodesid(trmstaffnodes_id);
		trmstaffnodesService.update(domain );
		TrmStaffnodesDTO dto = trmstaffnodesMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmstaffnodesService.getTrmstaffnodesByEntities(this.trmstaffnodesMapping.toDomain(#trmstaffnodesdtos)),'ehr-TrmStaffnodes-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"TrmStaffnodes" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmstaffnodes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmStaffnodesDTO> trmstaffnodesdtos) {
        trmstaffnodesService.updateBatch(trmstaffnodesMapping.toDomain(trmstaffnodesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmstaffnodesMapping.toDomain(#trmstaffnodesdto),'ehr-TrmStaffnodes-Save')")
    @ApiOperation(value = "Save", tags = {"TrmStaffnodes" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmstaffnodes/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmStaffnodesDTO trmstaffnodesdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmstaffnodesService.save(trmstaffnodesMapping.toDomain(trmstaffnodesdto)));
    }

    @PreAuthorize("hasPermission(this.trmstaffnodesMapping.toDomain(#trmstaffnodesdtos),'ehr-TrmStaffnodes-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"TrmStaffnodes" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmstaffnodes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmStaffnodesDTO> trmstaffnodesdtos) {
        trmstaffnodesService.saveBatch(trmstaffnodesMapping.toDomain(trmstaffnodesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"TrmStaffnodes" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmstaffnodes/getdraft")
    public ResponseEntity<TrmStaffnodesDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmstaffnodesMapping.toDto(trmstaffnodesService.getDraft(new TrmStaffnodes())));
    }

    @PreAuthorize("hasPermission(this.trmstaffnodesMapping.toDomain(#trmstaffnodesdto),'ehr-TrmStaffnodes-Create')")
    @ApiOperation(value = "Create", tags = {"TrmStaffnodes" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmstaffnodes")
    @Transactional
    public ResponseEntity<TrmStaffnodesDTO> create(@RequestBody TrmStaffnodesDTO trmstaffnodesdto) {
        TrmStaffnodes domain = trmstaffnodesMapping.toDomain(trmstaffnodesdto);
		trmstaffnodesService.create(domain);
        TrmStaffnodesDTO dto = trmstaffnodesMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmstaffnodesMapping.toDomain(#trmstaffnodesdtos),'ehr-TrmStaffnodes-Create')")
    @ApiOperation(value = "createBatch", tags = {"TrmStaffnodes" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmstaffnodes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmStaffnodesDTO> trmstaffnodesdtos) {
        trmstaffnodesService.createBatch(trmstaffnodesMapping.toDomain(trmstaffnodesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmStaffnodes-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TrmStaffnodes" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmstaffnodes/fetchdefault")
	public ResponseEntity<List<TrmStaffnodesDTO>> fetchDefault(TrmStaffnodesSearchContext context) {
        Page<TrmStaffnodes> domains = trmstaffnodesService.searchDefault(context) ;
        List<TrmStaffnodesDTO> list = trmstaffnodesMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmStaffnodes-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TrmStaffnodes" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmstaffnodes/searchdefault")
	public ResponseEntity<Page<TrmStaffnodesDTO>> searchDefault(@RequestBody TrmStaffnodesSearchContext context) {
        Page<TrmStaffnodes> domains = trmstaffnodesService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmstaffnodesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

