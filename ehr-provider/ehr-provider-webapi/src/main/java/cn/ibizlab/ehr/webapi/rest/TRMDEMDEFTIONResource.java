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
import cn.ibizlab.ehr.core.trm.domain.TRMDEMDEFTION;
import cn.ibizlab.ehr.core.trm.service.ITRMDEMDEFTIONService;
import cn.ibizlab.ehr.core.trm.filter.TRMDEMDEFTIONSearchContext;

@Slf4j
@Api(tags = {"TRMDEMDEFTION" })
@RestController("WebApi-trmdemdeftion")
@RequestMapping("")
public class TRMDEMDEFTIONResource {

    @Autowired
    private ITRMDEMDEFTIONService trmdemdeftionService;

    @Autowired
    @Lazy
    public TRMDEMDEFTIONMapping trmdemdeftionMapping;

    public TRMDEMDEFTIONDTO permissionDTO=new TRMDEMDEFTIONDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMDEMDEFTION-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"TRMDEMDEFTION" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmdemdeftions/getdraft")
    public ResponseEntity<TRMDEMDEFTIONDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmdemdeftionMapping.toDto(trmdemdeftionService.getDraft(new TRMDEMDEFTION())));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.trmdemdeftionMapping,#trmdemdeftiondto})")
    @ApiOperation(value = "Create", tags = {"TRMDEMDEFTION" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdemdeftions")
    @Transactional
    public ResponseEntity<TRMDEMDEFTIONDTO> create(@RequestBody TRMDEMDEFTIONDTO trmdemdeftiondto) {
        TRMDEMDEFTION domain = trmdemdeftionMapping.toDomain(trmdemdeftiondto);
		trmdemdeftionService.create(domain);
        TRMDEMDEFTIONDTO dto = trmdemdeftionMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.trmdemdeftionMapping,#trmdemdeftiondtos})")
    @ApiOperation(value = "createBatch", tags = {"TRMDEMDEFTION" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdemdeftions/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMDEMDEFTIONDTO> trmdemdeftiondtos) {
        trmdemdeftionService.createBatch(trmdemdeftionMapping.toDomain(trmdemdeftiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#trmdemdeftion_id,'Update',{'Sql',this.trmdemdeftionMapping,#trmdemdeftiondto})")
    @ApiOperation(value = "Update", tags = {"TRMDEMDEFTION" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmdemdeftions/{trmdemdeftion_id}")
    @Transactional
    public ResponseEntity<TRMDEMDEFTIONDTO> update(@PathVariable("trmdemdeftion_id") String trmdemdeftion_id, @RequestBody TRMDEMDEFTIONDTO trmdemdeftiondto) {
		TRMDEMDEFTION domain  = trmdemdeftionMapping.toDomain(trmdemdeftiondto);
        domain .setTrmdemdeftionid(trmdemdeftion_id);
		trmdemdeftionService.update(domain );
		TRMDEMDEFTIONDTO dto = trmdemdeftionMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.trmdemdeftionMapping,#trmdemdeftiondtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"TRMDEMDEFTION" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmdemdeftions/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMDEMDEFTIONDTO> trmdemdeftiondtos) {
        trmdemdeftionService.updateBatch(trmdemdeftionMapping.toDomain(trmdemdeftiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#trmdemdeftion_id,'Remove',{'Sql',this.trmdemdeftionMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"TRMDEMDEFTION" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmdemdeftions/{trmdemdeftion_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmdemdeftion_id") String trmdemdeftion_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmdemdeftionService.remove(trmdemdeftion_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.trmdemdeftionMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"TRMDEMDEFTION" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmdemdeftions/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmdemdeftionService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.trmdemdeftionMapping,#trmdemdeftiondto})")
    @ApiOperation(value = "Save", tags = {"TRMDEMDEFTION" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdemdeftions/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMDEMDEFTIONDTO trmdemdeftiondto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmdemdeftionService.save(trmdemdeftionMapping.toDomain(trmdemdeftiondto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.trmdemdeftionMapping,#trmdemdeftiondtos})")
    @ApiOperation(value = "SaveBatch", tags = {"TRMDEMDEFTION" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdemdeftions/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMDEMDEFTIONDTO> trmdemdeftiondtos) {
        trmdemdeftionService.saveBatch(trmdemdeftionMapping.toDomain(trmdemdeftiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMDEMDEFTION-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"TRMDEMDEFTION" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmdemdeftions/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMDEMDEFTIONDTO trmdemdeftiondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmdemdeftionService.checkKey(trmdemdeftionMapping.toDomain(trmdemdeftiondto)));
    }

    @PreAuthorize("hasPermission(#trmdemdeftion_id,'Get',{'Sql',this.trmdemdeftionMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"TRMDEMDEFTION" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmdemdeftions/{trmdemdeftion_id}")
    public ResponseEntity<TRMDEMDEFTIONDTO> get(@PathVariable("trmdemdeftion_id") String trmdemdeftion_id) {
        TRMDEMDEFTION domain = trmdemdeftionService.get(trmdemdeftion_id);
        TRMDEMDEFTIONDTO dto = trmdemdeftionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMDEMDEFTION-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TRMDEMDEFTION" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmdemdeftions/fetchdefault")
	public ResponseEntity<List<TRMDEMDEFTIONDTO>> fetchDefault(TRMDEMDEFTIONSearchContext context) {
        Page<TRMDEMDEFTION> domains = trmdemdeftionService.searchDefault(context) ;
        List<TRMDEMDEFTIONDTO> list = trmdemdeftionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMDEMDEFTION-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TRMDEMDEFTION" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmdemdeftions/searchdefault")
	public ResponseEntity<Page<TRMDEMDEFTIONDTO>> searchDefault(@RequestBody TRMDEMDEFTIONSearchContext context) {
        Page<TRMDEMDEFTION> domains = trmdemdeftionService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmdemdeftionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
