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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import cn.ibizlab.ehr.webapi.dto.*;
import cn.ibizlab.ehr.webapi.mapping.*;
import cn.ibizlab.ehr.core.trm.domain.TRMTRAINAGENCY;
import cn.ibizlab.ehr.core.trm.service.ITRMTRAINAGENCYService;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINAGENCYSearchContext;

@Slf4j
@Api(tags = {"TRMTRAINAGENCY" })
@RestController("WebApi-trmtrainagency")
@RequestMapping("")
public class TRMTRAINAGENCYResource {

    @Autowired
    private ITRMTRAINAGENCYService trmtrainagencyService;

    @Autowired
    @Lazy
    public TRMTRAINAGENCYMapping trmtrainagencyMapping;

    public TRMTRAINAGENCYDTO permissionDTO=new TRMTRAINAGENCYDTO();

    @PreAuthorize("hasPermission('','Save',{'Sql',this.trmtrainagencyMapping,#trmtrainagencydto})")
    @ApiOperation(value = "Save", tags = {"TRMTRAINAGENCY" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMTRAINAGENCYDTO trmtrainagencydto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainagencyService.save(trmtrainagencyMapping.toDomain(trmtrainagencydto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"TRMTRAINAGENCY" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMTRAINAGENCYDTO> trmtrainagencydtos) {
        trmtrainagencyService.saveBatch(trmtrainagencyMapping.toDomain(trmtrainagencydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINAGENCY-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"TRMTRAINAGENCY" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMTRAINAGENCYDTO trmtrainagencydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainagencyService.checkKey(trmtrainagencyMapping.toDomain(trmtrainagencydto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINAGENCY-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"TRMTRAINAGENCY" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainagencies/getdraft")
    public ResponseEntity<TRMTRAINAGENCYDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainagencyMapping.toDto(trmtrainagencyService.getDraft(new TRMTRAINAGENCY())));
    }

    @PreAuthorize("hasPermission(#trmtrainagency_id,'Get',{'Sql',this.trmtrainagencyMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"TRMTRAINAGENCY" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainagencies/{trmtrainagency_id}")
    public ResponseEntity<TRMTRAINAGENCYDTO> get(@PathVariable("trmtrainagency_id") String trmtrainagency_id) {
        TRMTRAINAGENCY domain = trmtrainagencyService.get(trmtrainagency_id);
        TRMTRAINAGENCYDTO dto = trmtrainagencyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#trmtrainagency_id,'Update',{'Sql',this.trmtrainagencyMapping,#trmtrainagencydto})")
    @ApiOperation(value = "Update", tags = {"TRMTRAINAGENCY" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainagencies/{trmtrainagency_id}")
    @Transactional
    public ResponseEntity<TRMTRAINAGENCYDTO> update(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @RequestBody TRMTRAINAGENCYDTO trmtrainagencydto) {
		TRMTRAINAGENCY domain = trmtrainagencyMapping.toDomain(trmtrainagencydto);
        domain.setTrmtrainagencyid(trmtrainagency_id);
		trmtrainagencyService.update(domain);
		TRMTRAINAGENCYDTO dto = trmtrainagencyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"TRMTRAINAGENCY" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainagencies/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMTRAINAGENCYDTO> trmtrainagencydtos) {
        trmtrainagencyService.updateBatch(trmtrainagencyMapping.toDomain(trmtrainagencydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.trmtrainagencyMapping,#trmtrainagencydto})")
    @ApiOperation(value = "Create", tags = {"TRMTRAINAGENCY" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies")
    @Transactional
    public ResponseEntity<TRMTRAINAGENCYDTO> create(@RequestBody TRMTRAINAGENCYDTO trmtrainagencydto) {
        TRMTRAINAGENCY domain = trmtrainagencyMapping.toDomain(trmtrainagencydto);
		trmtrainagencyService.create(domain);
        TRMTRAINAGENCYDTO dto = trmtrainagencyMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"TRMTRAINAGENCY" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMTRAINAGENCYDTO> trmtrainagencydtos) {
        trmtrainagencyService.createBatch(trmtrainagencyMapping.toDomain(trmtrainagencydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#trmtrainagency_id,'Remove',{'Sql',this.trmtrainagencyMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"TRMTRAINAGENCY" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainagencies/{trmtrainagency_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtrainagency_id") String trmtrainagency_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtrainagencyService.remove(trmtrainagency_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"TRMTRAINAGENCY" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainagencies/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtrainagencyService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINAGENCY-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TRMTRAINAGENCY" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainagencies/fetchdefault")
	public ResponseEntity<List<TRMTRAINAGENCYDTO>> fetchDefault(TRMTRAINAGENCYSearchContext context) {
        Page<TRMTRAINAGENCY> domains = trmtrainagencyService.searchDefault(context) ;
        List<TRMTRAINAGENCYDTO> list = trmtrainagencyMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINAGENCY-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TRMTRAINAGENCY" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainagencies/searchdefault")
	public ResponseEntity<Page<TRMTRAINAGENCYDTO>> searchDefault(@RequestBody TRMTRAINAGENCYSearchContext context) {
        Page<TRMTRAINAGENCY> domains = trmtrainagencyService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainagencyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
