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
import cn.ibizlab.ehr.core.trm.domain.TRMTRAINFILLIN;
import cn.ibizlab.ehr.core.trm.service.ITRMTRAINFILLINService;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINFILLINSearchContext;

@Slf4j
@Api(tags = {"TRMTRAINFILLIN" })
@RestController("WebApi-trmtrainfillin")
@RequestMapping("")
public class TRMTRAINFILLINResource {

    @Autowired
    private ITRMTRAINFILLINService trmtrainfillinService;

    @Autowired
    @Lazy
    public TRMTRAINFILLINMapping trmtrainfillinMapping;

    public TRMTRAINFILLINDTO permissionDTO=new TRMTRAINFILLINDTO();

    @PreAuthorize("hasPermission(#trmtrainfillin_id,'Get',{'Sql',this.trmtrainfillinMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"TRMTRAINFILLIN" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainfillins/{trmtrainfillin_id}")
    public ResponseEntity<TRMTRAINFILLINDTO> get(@PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
        TRMTRAINFILLIN domain = trmtrainfillinService.get(trmtrainfillin_id);
        TRMTRAINFILLINDTO dto = trmtrainfillinMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#trmtrainfillin_id,'Update',{'Sql',this.trmtrainfillinMapping,#trmtrainfillindto})")
    @ApiOperation(value = "Update", tags = {"TRMTRAINFILLIN" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainfillins/{trmtrainfillin_id}")
    @Transactional
    public ResponseEntity<TRMTRAINFILLINDTO> update(@PathVariable("trmtrainfillin_id") String trmtrainfillin_id, @RequestBody TRMTRAINFILLINDTO trmtrainfillindto) {
		TRMTRAINFILLIN domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
        domain.setTrmtrainfillinid(trmtrainfillin_id);
		trmtrainfillinService.update(domain);
		TRMTRAINFILLINDTO dto = trmtrainfillinMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"TRMTRAINFILLIN" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainfillins/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMTRAINFILLINDTO> trmtrainfillindtos) {
        trmtrainfillinService.updateBatch(trmtrainfillinMapping.toDomain(trmtrainfillindtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINFILLIN-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"TRMTRAINFILLIN" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfillins/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMTRAINFILLINDTO trmtrainfillindto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.checkKey(trmtrainfillinMapping.toDomain(trmtrainfillindto)));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.trmtrainfillinMapping,#trmtrainfillindto})")
    @ApiOperation(value = "Create", tags = {"TRMTRAINFILLIN" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfillins")
    @Transactional
    public ResponseEntity<TRMTRAINFILLINDTO> create(@RequestBody TRMTRAINFILLINDTO trmtrainfillindto) {
        TRMTRAINFILLIN domain = trmtrainfillinMapping.toDomain(trmtrainfillindto);
		trmtrainfillinService.create(domain);
        TRMTRAINFILLINDTO dto = trmtrainfillinMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"TRMTRAINFILLIN" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfillins/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMTRAINFILLINDTO> trmtrainfillindtos) {
        trmtrainfillinService.createBatch(trmtrainfillinMapping.toDomain(trmtrainfillindtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.trmtrainfillinMapping,#trmtrainfillindto})")
    @ApiOperation(value = "Save", tags = {"TRMTRAINFILLIN" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfillins/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMTRAINFILLINDTO trmtrainfillindto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.save(trmtrainfillinMapping.toDomain(trmtrainfillindto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"TRMTRAINFILLIN" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainfillins/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMTRAINFILLINDTO> trmtrainfillindtos) {
        trmtrainfillinService.saveBatch(trmtrainfillinMapping.toDomain(trmtrainfillindtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINFILLIN-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"TRMTRAINFILLIN" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainfillins/getdraft")
    public ResponseEntity<TRMTRAINFILLINDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinMapping.toDto(trmtrainfillinService.getDraft(new TRMTRAINFILLIN())));
    }

    @PreAuthorize("hasPermission(#trmtrainfillin_id,'Remove',{'Sql',this.trmtrainfillinMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"TRMTRAINFILLIN" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainfillins/{trmtrainfillin_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtrainfillin_id") String trmtrainfillin_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtrainfillinService.remove(trmtrainfillin_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"TRMTRAINFILLIN" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainfillins/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtrainfillinService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINFILLIN-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TRMTRAINFILLIN" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainfillins/fetchdefault")
	public ResponseEntity<List<TRMTRAINFILLINDTO>> fetchDefault(TRMTRAINFILLINSearchContext context) {
        Page<TRMTRAINFILLIN> domains = trmtrainfillinService.searchDefault(context) ;
        List<TRMTRAINFILLINDTO> list = trmtrainfillinMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINFILLIN-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TRMTRAINFILLIN" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainfillins/searchdefault")
	public ResponseEntity<Page<TRMTRAINFILLINDTO>> searchDefault(@RequestBody TRMTRAINFILLINSearchContext context) {
        Page<TRMTRAINFILLIN> domains = trmtrainfillinService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainfillinMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
