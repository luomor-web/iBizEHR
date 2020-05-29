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
import cn.ibizlab.ehr.core.trm.domain.TrmHmatser;
import cn.ibizlab.ehr.core.trm.service.ITrmHmatserService;
import cn.ibizlab.ehr.core.trm.filter.TrmHmatserSearchContext;

@Slf4j
@Api(tags = {"TrmHmatser" })
@RestController("WebApi-trmhmatser")
@RequestMapping("")
public class TrmHmatserResource {

    @Autowired
    public ITrmHmatserService trmhmatserService;

    @Autowired
    @Lazy
    public TrmHmatserMapping trmhmatserMapping;

    @PreAuthorize("hasPermission(this.trmhmatserService.get(#trmhmatser_id),'ehr-TrmHmatser-Remove')")
    @ApiOperation(value = "Remove", tags = {"TrmHmatser" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmhmatsers/{trmhmatser_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmhmatser_id") String trmhmatser_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmhmatserService.remove(trmhmatser_id));
    }

    @PreAuthorize("hasPermission(this.trmhmatserService.getTrmhmatserByIds(#ids),'ehr-TrmHmatser-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"TrmHmatser" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmhmatsers/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmhmatserService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmhmatserMapping.toDomain(#trmhmatserdto),'ehr-TrmHmatser-Save')")
    @ApiOperation(value = "Save", tags = {"TrmHmatser" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmhmatsers/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmHmatserDTO trmhmatserdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmhmatserService.save(trmhmatserMapping.toDomain(trmhmatserdto)));
    }

    @PreAuthorize("hasPermission(this.trmhmatserMapping.toDomain(#trmhmatserdtos),'ehr-TrmHmatser-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"TrmHmatser" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmhmatsers/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmHmatserDTO> trmhmatserdtos) {
        trmhmatserService.saveBatch(trmhmatserMapping.toDomain(trmhmatserdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmhmatserService.get(#trmhmatser_id),'ehr-TrmHmatser-Update')")
    @ApiOperation(value = "Update", tags = {"TrmHmatser" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmhmatsers/{trmhmatser_id}")
    @Transactional
    public ResponseEntity<TrmHmatserDTO> update(@PathVariable("trmhmatser_id") String trmhmatser_id, @RequestBody TrmHmatserDTO trmhmatserdto) {
		TrmHmatser domain  = trmhmatserMapping.toDomain(trmhmatserdto);
        domain .setTrmhmatserid(trmhmatser_id);
		trmhmatserService.update(domain );
		TrmHmatserDTO dto = trmhmatserMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmhmatserService.getTrmhmatserByEntities(this.trmhmatserMapping.toDomain(#trmhmatserdtos)),'ehr-TrmHmatser-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"TrmHmatser" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmhmatsers/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmHmatserDTO> trmhmatserdtos) {
        trmhmatserService.updateBatch(trmhmatserMapping.toDomain(trmhmatserdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmhmatserMapping.toDomain(#trmhmatserdto),'ehr-TrmHmatser-Create')")
    @ApiOperation(value = "Create", tags = {"TrmHmatser" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmhmatsers")
    @Transactional
    public ResponseEntity<TrmHmatserDTO> create(@RequestBody TrmHmatserDTO trmhmatserdto) {
        TrmHmatser domain = trmhmatserMapping.toDomain(trmhmatserdto);
		trmhmatserService.create(domain);
        TrmHmatserDTO dto = trmhmatserMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmhmatserMapping.toDomain(#trmhmatserdtos),'ehr-TrmHmatser-Create')")
    @ApiOperation(value = "createBatch", tags = {"TrmHmatser" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmhmatsers/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmHmatserDTO> trmhmatserdtos) {
        trmhmatserService.createBatch(trmhmatserMapping.toDomain(trmhmatserdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"TrmHmatser" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmhmatsers/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmHmatserDTO trmhmatserdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmhmatserService.checkKey(trmhmatserMapping.toDomain(trmhmatserdto)));
    }

    @ApiOperation(value = "GetDraft", tags = {"TrmHmatser" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmhmatsers/getdraft")
    public ResponseEntity<TrmHmatserDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmhmatserMapping.toDto(trmhmatserService.getDraft(new TrmHmatser())));
    }

    @PostAuthorize("hasPermission(this.trmhmatserMapping.toDomain(returnObject.body),'ehr-TrmHmatser-Get')")
    @ApiOperation(value = "Get", tags = {"TrmHmatser" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmhmatsers/{trmhmatser_id}")
    public ResponseEntity<TrmHmatserDTO> get(@PathVariable("trmhmatser_id") String trmhmatser_id) {
        TrmHmatser domain = trmhmatserService.get(trmhmatser_id);
        TrmHmatserDTO dto = trmhmatserMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmHmatser-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TrmHmatser" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmhmatsers/fetchdefault")
	public ResponseEntity<List<TrmHmatserDTO>> fetchDefault(TrmHmatserSearchContext context) {
        Page<TrmHmatser> domains = trmhmatserService.searchDefault(context) ;
        List<TrmHmatserDTO> list = trmhmatserMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmHmatser-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TrmHmatser" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmhmatsers/searchdefault")
	public ResponseEntity<Page<TrmHmatserDTO>> searchDefault(@RequestBody TrmHmatserSearchContext context) {
        Page<TrmHmatser> domains = trmhmatserService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmhmatserMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

