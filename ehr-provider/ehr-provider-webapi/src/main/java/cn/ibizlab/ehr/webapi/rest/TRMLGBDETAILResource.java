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
import cn.ibizlab.ehr.core.trm.domain.TRMLGBDETAIL;
import cn.ibizlab.ehr.core.trm.service.ITRMLGBDETAILService;
import cn.ibizlab.ehr.core.trm.filter.TRMLGBDETAILSearchContext;




@Slf4j
@Api(tags = {"TRMLGBDETAIL" })
@RestController("WebApi-trmlgbdetail")
@RequestMapping("")
public class TRMLGBDETAILResource {

    @Autowired
    private ITRMLGBDETAILService trmlgbdetailService;

    @Autowired
    @Lazy
    public TRMLGBDETAILMapping trmlgbdetailMapping;

    public TRMLGBDETAILDTO permissionDTO=new TRMLGBDETAILDTO();

    @PreAuthorize("hasPermission(#trmlgbdetail_id,'Update',{'Sql',this.trmlgbdetailMapping,#trmlgbdetaildto})")
    @ApiOperation(value = "Update", tags = {"TRMLGBDETAIL" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmlgbdetails/{trmlgbdetail_id}")
    @Transactional
    public ResponseEntity<TRMLGBDETAILDTO> update(@PathVariable("trmlgbdetail_id") String trmlgbdetail_id, @RequestBody TRMLGBDETAILDTO trmlgbdetaildto) {
		TRMLGBDETAIL domain = trmlgbdetailMapping.toDomain(trmlgbdetaildto);
        domain.setTrmlgbdetailid(trmlgbdetail_id);
		trmlgbdetailService.update(domain);
		TRMLGBDETAILDTO dto = trmlgbdetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"TRMLGBDETAIL" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmlgbdetails/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMLGBDETAILDTO> trmlgbdetaildtos) {
        trmlgbdetailService.updateBatch(trmlgbdetailMapping.toDomain(trmlgbdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#trmlgbdetail_id,'Get',{'Sql',this.trmlgbdetailMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"TRMLGBDETAIL" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmlgbdetails/{trmlgbdetail_id}")
    public ResponseEntity<TRMLGBDETAILDTO> get(@PathVariable("trmlgbdetail_id") String trmlgbdetail_id) {
        TRMLGBDETAIL domain = trmlgbdetailService.get(trmlgbdetail_id);
        TRMLGBDETAILDTO dto = trmlgbdetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMLGBDETAIL-Save-all')")
    @ApiOperation(value = "Save", tags = {"TRMLGBDETAIL" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmlgbdetails/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMLGBDETAILDTO trmlgbdetaildto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmlgbdetailService.save(trmlgbdetailMapping.toDomain(trmlgbdetaildto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"TRMLGBDETAIL" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmlgbdetails/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMLGBDETAILDTO> trmlgbdetaildtos) {
        trmlgbdetailService.saveBatch(trmlgbdetailMapping.toDomain(trmlgbdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMLGBDETAIL-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"TRMLGBDETAIL" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmlgbdetails/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMLGBDETAILDTO trmlgbdetaildto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmlgbdetailService.checkKey(trmlgbdetailMapping.toDomain(trmlgbdetaildto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMLGBDETAIL-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"TRMLGBDETAIL" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmlgbdetails/getdraft")
    public ResponseEntity<TRMLGBDETAILDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmlgbdetailMapping.toDto(trmlgbdetailService.getDraft(new TRMLGBDETAIL())));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.trmlgbdetailMapping,#trmlgbdetaildto})")
    @ApiOperation(value = "Create", tags = {"TRMLGBDETAIL" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmlgbdetails")
    @Transactional
    public ResponseEntity<TRMLGBDETAILDTO> create(@RequestBody TRMLGBDETAILDTO trmlgbdetaildto) {
        TRMLGBDETAIL domain = trmlgbdetailMapping.toDomain(trmlgbdetaildto);
		trmlgbdetailService.create(domain);
        TRMLGBDETAILDTO dto = trmlgbdetailMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"TRMLGBDETAIL" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmlgbdetails/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMLGBDETAILDTO> trmlgbdetaildtos) {
        trmlgbdetailService.createBatch(trmlgbdetailMapping.toDomain(trmlgbdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#trmlgbdetail_id,'Remove',{'Sql',this.trmlgbdetailMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"TRMLGBDETAIL" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmlgbdetails/{trmlgbdetail_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmlgbdetail_id") String trmlgbdetail_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmlgbdetailService.remove(trmlgbdetail_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"TRMLGBDETAIL" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmlgbdetails/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmlgbdetailService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMLGBDETAIL-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TRMLGBDETAIL" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmlgbdetails/fetchdefault")
	public ResponseEntity<List<TRMLGBDETAILDTO>> fetchDefault(TRMLGBDETAILSearchContext context) {
        Page<TRMLGBDETAIL> domains = trmlgbdetailService.searchDefault(context) ;
        List<TRMLGBDETAILDTO> list = trmlgbdetailMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMLGBDETAIL-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TRMLGBDETAIL" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmlgbdetails/searchdefault")
	public ResponseEntity<Page<TRMLGBDETAILDTO>> searchDefault(@RequestBody TRMLGBDETAILSearchContext context) {
        Page<TRMLGBDETAIL> domains = trmlgbdetailService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmlgbdetailMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
