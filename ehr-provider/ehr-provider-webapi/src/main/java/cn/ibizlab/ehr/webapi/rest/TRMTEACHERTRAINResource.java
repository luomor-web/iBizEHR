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
import cn.ibizlab.ehr.core.trm.domain.TRMTEACHERTRAIN;
import cn.ibizlab.ehr.core.trm.service.ITRMTEACHERTRAINService;
import cn.ibizlab.ehr.core.trm.filter.TRMTEACHERTRAINSearchContext;




@Slf4j
@Api(tags = {"TRMTEACHERTRAIN" })
@RestController("WebApi-trmteachertrain")
@RequestMapping("")
public class TRMTEACHERTRAINResource {

    @Autowired
    private ITRMTEACHERTRAINService trmteachertrainService;

    @Autowired
    @Lazy
    public TRMTEACHERTRAINMapping trmteachertrainMapping;

    public TRMTEACHERTRAINDTO permissionDTO=new TRMTEACHERTRAINDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTEACHERTRAIN-Save-all')")
    @ApiOperation(value = "Save", tags = {"TRMTEACHERTRAIN" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmteachertrains/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMTEACHERTRAINDTO trmteachertraindto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmteachertrainService.save(trmteachertrainMapping.toDomain(trmteachertraindto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"TRMTEACHERTRAIN" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmteachertrains/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMTEACHERTRAINDTO> trmteachertraindtos) {
        trmteachertrainService.saveBatch(trmteachertrainMapping.toDomain(trmteachertraindtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTEACHERTRAIN-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"TRMTEACHERTRAIN" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmteachertrains/getdraft")
    public ResponseEntity<TRMTEACHERTRAINDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmteachertrainMapping.toDto(trmteachertrainService.getDraft(new TRMTEACHERTRAIN())));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.trmteachertrainMapping,#trmteachertraindto})")
    @ApiOperation(value = "Create", tags = {"TRMTEACHERTRAIN" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmteachertrains")
    @Transactional
    public ResponseEntity<TRMTEACHERTRAINDTO> create(@RequestBody TRMTEACHERTRAINDTO trmteachertraindto) {
        TRMTEACHERTRAIN domain = trmteachertrainMapping.toDomain(trmteachertraindto);
		trmteachertrainService.create(domain);
        TRMTEACHERTRAINDTO dto = trmteachertrainMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"TRMTEACHERTRAIN" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmteachertrains/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMTEACHERTRAINDTO> trmteachertraindtos) {
        trmteachertrainService.createBatch(trmteachertrainMapping.toDomain(trmteachertraindtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#trmteachertrain_id,'Remove',{'Sql',this.trmteachertrainMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"TRMTEACHERTRAIN" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmteachertrains/{trmteachertrain_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmteachertrain_id") String trmteachertrain_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmteachertrainService.remove(trmteachertrain_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"TRMTEACHERTRAIN" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmteachertrains/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmteachertrainService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#trmteachertrain_id,'Get',{'Sql',this.trmteachertrainMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"TRMTEACHERTRAIN" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmteachertrains/{trmteachertrain_id}")
    public ResponseEntity<TRMTEACHERTRAINDTO> get(@PathVariable("trmteachertrain_id") String trmteachertrain_id) {
        TRMTEACHERTRAIN domain = trmteachertrainService.get(trmteachertrain_id);
        TRMTEACHERTRAINDTO dto = trmteachertrainMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#trmteachertrain_id,'Update',{'Sql',this.trmteachertrainMapping,#trmteachertraindto})")
    @ApiOperation(value = "Update", tags = {"TRMTEACHERTRAIN" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmteachertrains/{trmteachertrain_id}")
    @Transactional
    public ResponseEntity<TRMTEACHERTRAINDTO> update(@PathVariable("trmteachertrain_id") String trmteachertrain_id, @RequestBody TRMTEACHERTRAINDTO trmteachertraindto) {
		TRMTEACHERTRAIN domain = trmteachertrainMapping.toDomain(trmteachertraindto);
        domain.setTrmteachertrainid(trmteachertrain_id);
		trmteachertrainService.update(domain);
		TRMTEACHERTRAINDTO dto = trmteachertrainMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"TRMTEACHERTRAIN" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmteachertrains/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMTEACHERTRAINDTO> trmteachertraindtos) {
        trmteachertrainService.updateBatch(trmteachertrainMapping.toDomain(trmteachertraindtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTEACHERTRAIN-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"TRMTEACHERTRAIN" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmteachertrains/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMTEACHERTRAINDTO trmteachertraindto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmteachertrainService.checkKey(trmteachertrainMapping.toDomain(trmteachertraindto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTEACHERTRAIN-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TRMTEACHERTRAIN" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmteachertrains/fetchdefault")
	public ResponseEntity<List<TRMTEACHERTRAINDTO>> fetchDefault(TRMTEACHERTRAINSearchContext context) {
        Page<TRMTEACHERTRAIN> domains = trmteachertrainService.searchDefault(context) ;
        List<TRMTEACHERTRAINDTO> list = trmteachertrainMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTEACHERTRAIN-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TRMTEACHERTRAIN" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmteachertrains/searchdefault")
	public ResponseEntity<Page<TRMTEACHERTRAINDTO>> searchDefault(@RequestBody TRMTEACHERTRAINSearchContext context) {
        Page<TRMTEACHERTRAIN> domains = trmteachertrainService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmteachertrainMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
