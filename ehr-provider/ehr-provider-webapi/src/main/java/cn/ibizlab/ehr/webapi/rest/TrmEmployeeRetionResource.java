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
import cn.ibizlab.ehr.core.trm.domain.TrmEmployeeRetion;
import cn.ibizlab.ehr.core.trm.service.ITrmEmployeeRetionService;
import cn.ibizlab.ehr.core.trm.filter.TrmEmployeeRetionSearchContext;

@Slf4j
@Api(tags = {"TrmEmployeeRetion" })
@RestController("WebApi-trmemployeeretion")
@RequestMapping("")
public class TrmEmployeeRetionResource {

    @Autowired
    public ITrmEmployeeRetionService trmemployeeretionService;

    @Autowired
    @Lazy
    public TrmEmployeeRetionMapping trmemployeeretionMapping;

    @PreAuthorize("hasPermission(this.trmemployeeretionService.get(#trmemployeeretion_id),'ehr-TrmEmployeeRetion-Remove')")
    @ApiOperation(value = "Remove", tags = {"TrmEmployeeRetion" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmemployeeretions/{trmemployeeretion_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmemployeeretion_id") String trmemployeeretion_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmemployeeretionService.remove(trmemployeeretion_id));
    }

    @PreAuthorize("hasPermission(this.trmemployeeretionService.getTrmemployeeretionByIds(#ids),'ehr-TrmEmployeeRetion-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"TrmEmployeeRetion" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmemployeeretions/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmemployeeretionService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"TrmEmployeeRetion" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmemployeeretions/getdraft")
    public ResponseEntity<TrmEmployeeRetionDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmemployeeretionMapping.toDto(trmemployeeretionService.getDraft(new TrmEmployeeRetion())));
    }

    @PreAuthorize("hasPermission(this.trmemployeeretionService.get(#trmemployeeretion_id),'ehr-TrmEmployeeRetion-Update')")
    @ApiOperation(value = "Update", tags = {"TrmEmployeeRetion" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmemployeeretions/{trmemployeeretion_id}")
    @Transactional
    public ResponseEntity<TrmEmployeeRetionDTO> update(@PathVariable("trmemployeeretion_id") String trmemployeeretion_id, @RequestBody TrmEmployeeRetionDTO trmemployeeretiondto) {
		TrmEmployeeRetion domain  = trmemployeeretionMapping.toDomain(trmemployeeretiondto);
        domain .setTrmemployretionid(trmemployeeretion_id);
		trmemployeeretionService.update(domain );
		TrmEmployeeRetionDTO dto = trmemployeeretionMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmemployeeretionService.getTrmemployeeretionByEntities(this.trmemployeeretionMapping.toDomain(#trmemployeeretiondtos)),'ehr-TrmEmployeeRetion-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"TrmEmployeeRetion" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmemployeeretions/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmEmployeeRetionDTO> trmemployeeretiondtos) {
        trmemployeeretionService.updateBatch(trmemployeeretionMapping.toDomain(trmemployeeretiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmemployeeretionMapping.toDomain(#trmemployeeretiondto),'ehr-TrmEmployeeRetion-Save')")
    @ApiOperation(value = "Save", tags = {"TrmEmployeeRetion" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmemployeeretions/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmEmployeeRetionDTO trmemployeeretiondto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmemployeeretionService.save(trmemployeeretionMapping.toDomain(trmemployeeretiondto)));
    }

    @PreAuthorize("hasPermission(this.trmemployeeretionMapping.toDomain(#trmemployeeretiondtos),'ehr-TrmEmployeeRetion-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"TrmEmployeeRetion" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmemployeeretions/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmEmployeeRetionDTO> trmemployeeretiondtos) {
        trmemployeeretionService.saveBatch(trmemployeeretionMapping.toDomain(trmemployeeretiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmemployeeretionMapping.toDomain(#trmemployeeretiondto),'ehr-TrmEmployeeRetion-Create')")
    @ApiOperation(value = "Create", tags = {"TrmEmployeeRetion" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmemployeeretions")
    @Transactional
    public ResponseEntity<TrmEmployeeRetionDTO> create(@RequestBody TrmEmployeeRetionDTO trmemployeeretiondto) {
        TrmEmployeeRetion domain = trmemployeeretionMapping.toDomain(trmemployeeretiondto);
		trmemployeeretionService.create(domain);
        TrmEmployeeRetionDTO dto = trmemployeeretionMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmemployeeretionMapping.toDomain(#trmemployeeretiondtos),'ehr-TrmEmployeeRetion-Create')")
    @ApiOperation(value = "createBatch", tags = {"TrmEmployeeRetion" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmemployeeretions/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmEmployeeRetionDTO> trmemployeeretiondtos) {
        trmemployeeretionService.createBatch(trmemployeeretionMapping.toDomain(trmemployeeretiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"TrmEmployeeRetion" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmemployeeretions/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmEmployeeRetionDTO trmemployeeretiondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmemployeeretionService.checkKey(trmemployeeretionMapping.toDomain(trmemployeeretiondto)));
    }

    @PostAuthorize("hasPermission(this.trmemployeeretionMapping.toDomain(returnObject.body),'ehr-TrmEmployeeRetion-Get')")
    @ApiOperation(value = "Get", tags = {"TrmEmployeeRetion" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmemployeeretions/{trmemployeeretion_id}")
    public ResponseEntity<TrmEmployeeRetionDTO> get(@PathVariable("trmemployeeretion_id") String trmemployeeretion_id) {
        TrmEmployeeRetion domain = trmemployeeretionService.get(trmemployeeretion_id);
        TrmEmployeeRetionDTO dto = trmemployeeretionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmEmployeeRetion-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TrmEmployeeRetion" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmemployeeretions/fetchdefault")
	public ResponseEntity<List<TrmEmployeeRetionDTO>> fetchDefault(TrmEmployeeRetionSearchContext context) {
        Page<TrmEmployeeRetion> domains = trmemployeeretionService.searchDefault(context) ;
        List<TrmEmployeeRetionDTO> list = trmemployeeretionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmEmployeeRetion-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TrmEmployeeRetion" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmemployeeretions/searchdefault")
	public ResponseEntity<Page<TrmEmployeeRetionDTO>> searchDefault(@RequestBody TrmEmployeeRetionSearchContext context) {
        Page<TrmEmployeeRetion> domains = trmemployeeretionService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmemployeeretionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

