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
import cn.ibizlab.ehr.core.trm.domain.TRMHMATSER;
import cn.ibizlab.ehr.core.trm.service.ITRMHMATSERService;
import cn.ibizlab.ehr.core.trm.filter.TRMHMATSERSearchContext;

@Slf4j
@Api(tags = {"TRMHMATSER" })
@RestController("WebApi-trmhmatser")
@RequestMapping("")
public class TRMHMATSERResource {

    @Autowired
    public ITRMHMATSERService trmhmatserService;

    @Autowired
    @Lazy
    public TRMHMATSERMapping trmhmatserMapping;

    @PreAuthorize("hasPermission(this.trmhmatserService.get(#trmhmatser_id),'ehr-TRMHMATSER-Remove')")
    @ApiOperation(value = "Remove", tags = {"TRMHMATSER" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmhmatsers/{trmhmatser_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmhmatser_id") String trmhmatser_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmhmatserService.remove(trmhmatser_id));
    }

    @PreAuthorize("hasPermission(this.trmhmatserService.getTrmhmatserByIds(#ids),'ehr-TRMHMATSER-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"TRMHMATSER" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmhmatsers/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmhmatserService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmhmatserMapping.toDomain(#trmhmatserdto),'ehr-TRMHMATSER-Save')")
    @ApiOperation(value = "Save", tags = {"TRMHMATSER" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmhmatsers/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMHMATSERDTO trmhmatserdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmhmatserService.save(trmhmatserMapping.toDomain(trmhmatserdto)));
    }

    @PreAuthorize("hasPermission(this.trmhmatserMapping.toDomain(#trmhmatserdtos),'ehr-TRMHMATSER-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"TRMHMATSER" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmhmatsers/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMHMATSERDTO> trmhmatserdtos) {
        trmhmatserService.saveBatch(trmhmatserMapping.toDomain(trmhmatserdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmhmatserService.get(#trmhmatser_id),'ehr-TRMHMATSER-Update')")
    @ApiOperation(value = "Update", tags = {"TRMHMATSER" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmhmatsers/{trmhmatser_id}")
    @Transactional
    public ResponseEntity<TRMHMATSERDTO> update(@PathVariable("trmhmatser_id") String trmhmatser_id, @RequestBody TRMHMATSERDTO trmhmatserdto) {
		TRMHMATSER domain  = trmhmatserMapping.toDomain(trmhmatserdto);
        domain .setTrmhmatserid(trmhmatser_id);
		trmhmatserService.update(domain );
		TRMHMATSERDTO dto = trmhmatserMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmhmatserService.getTrmhmatserByEntities(this.trmhmatserMapping.toDomain(#trmhmatserdtos)),'ehr-TRMHMATSER-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"TRMHMATSER" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmhmatsers/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMHMATSERDTO> trmhmatserdtos) {
        trmhmatserService.updateBatch(trmhmatserMapping.toDomain(trmhmatserdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmhmatserMapping.toDomain(#trmhmatserdto),'ehr-TRMHMATSER-Create')")
    @ApiOperation(value = "Create", tags = {"TRMHMATSER" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmhmatsers")
    @Transactional
    public ResponseEntity<TRMHMATSERDTO> create(@RequestBody TRMHMATSERDTO trmhmatserdto) {
        TRMHMATSER domain = trmhmatserMapping.toDomain(trmhmatserdto);
		trmhmatserService.create(domain);
        TRMHMATSERDTO dto = trmhmatserMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmhmatserMapping.toDomain(#trmhmatserdtos),'ehr-TRMHMATSER-Create')")
    @ApiOperation(value = "createBatch", tags = {"TRMHMATSER" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmhmatsers/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMHMATSERDTO> trmhmatserdtos) {
        trmhmatserService.createBatch(trmhmatserMapping.toDomain(trmhmatserdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"TRMHMATSER" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmhmatsers/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMHMATSERDTO trmhmatserdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmhmatserService.checkKey(trmhmatserMapping.toDomain(trmhmatserdto)));
    }

    @ApiOperation(value = "GetDraft", tags = {"TRMHMATSER" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmhmatsers/getdraft")
    public ResponseEntity<TRMHMATSERDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmhmatserMapping.toDto(trmhmatserService.getDraft(new TRMHMATSER())));
    }

    @PostAuthorize("hasPermission(this.trmhmatserMapping.toDomain(returnObject.body),'ehr-TRMHMATSER-Get')")
    @ApiOperation(value = "Get", tags = {"TRMHMATSER" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmhmatsers/{trmhmatser_id}")
    public ResponseEntity<TRMHMATSERDTO> get(@PathVariable("trmhmatser_id") String trmhmatser_id) {
        TRMHMATSER domain = trmhmatserService.get(trmhmatser_id);
        TRMHMATSERDTO dto = trmhmatserMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMHMATSER-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TRMHMATSER" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmhmatsers/fetchdefault")
	public ResponseEntity<List<TRMHMATSERDTO>> fetchDefault(TRMHMATSERSearchContext context) {
        Page<TRMHMATSER> domains = trmhmatserService.searchDefault(context) ;
        List<TRMHMATSERDTO> list = trmhmatserMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMHMATSER-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TRMHMATSER" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmhmatsers/searchdefault")
	public ResponseEntity<Page<TRMHMATSERDTO>> searchDefault(@RequestBody TRMHMATSERSearchContext context) {
        Page<TRMHMATSER> domains = trmhmatserService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmhmatserMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

