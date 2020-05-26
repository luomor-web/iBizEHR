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
import cn.ibizlab.ehr.core.trm.domain.TRMTRAINACTAPPLY;
import cn.ibizlab.ehr.core.trm.service.ITRMTRAINACTAPPLYService;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINACTAPPLYSearchContext;

@Slf4j
@Api(tags = {"TRMTRAINACTAPPLY" })
@RestController("WebApi-trmtrainactapply")
@RequestMapping("")
public class TRMTRAINACTAPPLYResource {

    @Autowired
    private ITRMTRAINACTAPPLYService trmtrainactapplyService;

    @Autowired
    @Lazy
    public TRMTRAINACTAPPLYMapping trmtrainactapplyMapping;

    public TRMTRAINACTAPPLYDTO permissionDTO=new TRMTRAINACTAPPLYDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINACTAPPLY-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"TRMTRAINACTAPPLY" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainactapplies/getdraft")
    public ResponseEntity<TRMTRAINACTAPPLYDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainactapplyMapping.toDto(trmtrainactapplyService.getDraft(new TRMTRAINACTAPPLY())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINACTAPPLY-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"TRMTRAINACTAPPLY" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainactapplies/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMTRAINACTAPPLYDTO trmtrainactapplydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainactapplyService.checkKey(trmtrainactapplyMapping.toDomain(trmtrainactapplydto)));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.trmtrainactapplyMapping,#trmtrainactapplydto})")
    @ApiOperation(value = "Create", tags = {"TRMTRAINACTAPPLY" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainactapplies")
    @Transactional
    public ResponseEntity<TRMTRAINACTAPPLYDTO> create(@RequestBody TRMTRAINACTAPPLYDTO trmtrainactapplydto) {
        TRMTRAINACTAPPLY domain = trmtrainactapplyMapping.toDomain(trmtrainactapplydto);
		trmtrainactapplyService.create(domain);
        TRMTRAINACTAPPLYDTO dto = trmtrainactapplyMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.trmtrainactapplyMapping,#trmtrainactapplydtos})")
    @ApiOperation(value = "createBatch", tags = {"TRMTRAINACTAPPLY" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainactapplies/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMTRAINACTAPPLYDTO> trmtrainactapplydtos) {
        trmtrainactapplyService.createBatch(trmtrainactapplyMapping.toDomain(trmtrainactapplydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#trmtrainactapply_id,'Get',{'Sql',this.trmtrainactapplyMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"TRMTRAINACTAPPLY" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainactapplies/{trmtrainactapply_id}")
    public ResponseEntity<TRMTRAINACTAPPLYDTO> get(@PathVariable("trmtrainactapply_id") String trmtrainactapply_id) {
        TRMTRAINACTAPPLY domain = trmtrainactapplyService.get(trmtrainactapply_id);
        TRMTRAINACTAPPLYDTO dto = trmtrainactapplyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.trmtrainactapplyMapping,#trmtrainactapplydto})")
    @ApiOperation(value = "Save", tags = {"TRMTRAINACTAPPLY" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainactapplies/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMTRAINACTAPPLYDTO trmtrainactapplydto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainactapplyService.save(trmtrainactapplyMapping.toDomain(trmtrainactapplydto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.trmtrainactapplyMapping,#trmtrainactapplydtos})")
    @ApiOperation(value = "SaveBatch", tags = {"TRMTRAINACTAPPLY" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainactapplies/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMTRAINACTAPPLYDTO> trmtrainactapplydtos) {
        trmtrainactapplyService.saveBatch(trmtrainactapplyMapping.toDomain(trmtrainactapplydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#trmtrainactapply_id,'Update',{'Sql',this.trmtrainactapplyMapping,#trmtrainactapplydto})")
    @ApiOperation(value = "Update", tags = {"TRMTRAINACTAPPLY" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainactapplies/{trmtrainactapply_id}")
    @Transactional
    public ResponseEntity<TRMTRAINACTAPPLYDTO> update(@PathVariable("trmtrainactapply_id") String trmtrainactapply_id, @RequestBody TRMTRAINACTAPPLYDTO trmtrainactapplydto) {
		TRMTRAINACTAPPLY domain  = trmtrainactapplyMapping.toDomain(trmtrainactapplydto);
        domain .setTrmtrainactapplyid(trmtrainactapply_id);
		trmtrainactapplyService.update(domain );
		TRMTRAINACTAPPLYDTO dto = trmtrainactapplyMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.trmtrainactapplyMapping,#trmtrainactapplydtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"TRMTRAINACTAPPLY" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainactapplies/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMTRAINACTAPPLYDTO> trmtrainactapplydtos) {
        trmtrainactapplyService.updateBatch(trmtrainactapplyMapping.toDomain(trmtrainactapplydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#trmtrainactapply_id,'Remove',{'Sql',this.trmtrainactapplyMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"TRMTRAINACTAPPLY" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainactapplies/{trmtrainactapply_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtrainactapply_id") String trmtrainactapply_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtrainactapplyService.remove(trmtrainactapply_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.trmtrainactapplyMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"TRMTRAINACTAPPLY" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainactapplies/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtrainactapplyService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINACTAPPLY-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TRMTRAINACTAPPLY" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainactapplies/fetchdefault")
	public ResponseEntity<List<TRMTRAINACTAPPLYDTO>> fetchDefault(TRMTRAINACTAPPLYSearchContext context) {
        Page<TRMTRAINACTAPPLY> domains = trmtrainactapplyService.searchDefault(context) ;
        List<TRMTRAINACTAPPLYDTO> list = trmtrainactapplyMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINACTAPPLY-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TRMTRAINACTAPPLY" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainactapplies/searchdefault")
	public ResponseEntity<Page<TRMTRAINACTAPPLYDTO>> searchDefault(@RequestBody TRMTRAINACTAPPLYSearchContext context) {
        Page<TRMTRAINACTAPPLY> domains = trmtrainactapplyService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainactapplyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
