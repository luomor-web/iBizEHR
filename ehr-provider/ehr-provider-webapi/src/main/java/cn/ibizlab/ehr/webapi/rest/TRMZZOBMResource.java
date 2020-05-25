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
import cn.ibizlab.ehr.core.trm.domain.TRMZZOBM;
import cn.ibizlab.ehr.core.trm.service.ITRMZZOBMService;
import cn.ibizlab.ehr.core.trm.filter.TRMZZOBMSearchContext;

@Slf4j
@Api(tags = {"TRMZZOBM" })
@RestController("WebApi-trmzzobm")
@RequestMapping("")
public class TRMZZOBMResource {

    @Autowired
    private ITRMZZOBMService trmzzobmService;

    @Autowired
    @Lazy
    public TRMZZOBMMapping trmzzobmMapping;

    public TRMZZOBMDTO permissionDTO=new TRMZZOBMDTO();

    @PreAuthorize("hasPermission('','Create',{'Sql',this.trmzzobmMapping,#trmzzobmdto})")
    @ApiOperation(value = "Create", tags = {"TRMZZOBM" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmzzobms")
    @Transactional
    public ResponseEntity<TRMZZOBMDTO> create(@RequestBody TRMZZOBMDTO trmzzobmdto) {
        TRMZZOBM domain = trmzzobmMapping.toDomain(trmzzobmdto);
		trmzzobmService.create(domain);
        TRMZZOBMDTO dto = trmzzobmMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"TRMZZOBM" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmzzobms/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMZZOBMDTO> trmzzobmdtos) {
        trmzzobmService.createBatch(trmzzobmMapping.toDomain(trmzzobmdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#trmzzobm_id,'Update',{'Sql',this.trmzzobmMapping,#trmzzobmdto})")
    @ApiOperation(value = "Update", tags = {"TRMZZOBM" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmzzobms/{trmzzobm_id}")
    @Transactional
    public ResponseEntity<TRMZZOBMDTO> update(@PathVariable("trmzzobm_id") String trmzzobm_id, @RequestBody TRMZZOBMDTO trmzzobmdto) {
		TRMZZOBM domain = trmzzobmMapping.toDomain(trmzzobmdto);
        domain.setTrmzzobmid(trmzzobm_id);
		trmzzobmService.update(domain);
		TRMZZOBMDTO dto = trmzzobmMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"TRMZZOBM" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmzzobms/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMZZOBMDTO> trmzzobmdtos) {
        trmzzobmService.updateBatch(trmzzobmMapping.toDomain(trmzzobmdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMZZOBM-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"TRMZZOBM" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmzzobms/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMZZOBMDTO trmzzobmdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmzzobmService.checkKey(trmzzobmMapping.toDomain(trmzzobmdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMZZOBM-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"TRMZZOBM" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmzzobms/getdraft")
    public ResponseEntity<TRMZZOBMDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmzzobmMapping.toDto(trmzzobmService.getDraft(new TRMZZOBM())));
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.trmzzobmMapping,#trmzzobmdto})")
    @ApiOperation(value = "Save", tags = {"TRMZZOBM" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmzzobms/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMZZOBMDTO trmzzobmdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmzzobmService.save(trmzzobmMapping.toDomain(trmzzobmdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"TRMZZOBM" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmzzobms/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMZZOBMDTO> trmzzobmdtos) {
        trmzzobmService.saveBatch(trmzzobmMapping.toDomain(trmzzobmdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#trmzzobm_id,'Get',{'Sql',this.trmzzobmMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"TRMZZOBM" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmzzobms/{trmzzobm_id}")
    public ResponseEntity<TRMZZOBMDTO> get(@PathVariable("trmzzobm_id") String trmzzobm_id) {
        TRMZZOBM domain = trmzzobmService.get(trmzzobm_id);
        TRMZZOBMDTO dto = trmzzobmMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#trmzzobm_id,'Remove',{'Sql',this.trmzzobmMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"TRMZZOBM" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmzzobms/{trmzzobm_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmzzobm_id") String trmzzobm_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmzzobmService.remove(trmzzobm_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"TRMZZOBM" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmzzobms/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmzzobmService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMZZOBM-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TRMZZOBM" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmzzobms/fetchdefault")
	public ResponseEntity<List<TRMZZOBMDTO>> fetchDefault(TRMZZOBMSearchContext context) {
        Page<TRMZZOBM> domains = trmzzobmService.searchDefault(context) ;
        List<TRMZZOBMDTO> list = trmzzobmMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMZZOBM-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TRMZZOBM" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmzzobms/searchdefault")
	public ResponseEntity<Page<TRMZZOBMDTO>> searchDefault(@RequestBody TRMZZOBMSearchContext context) {
        Page<TRMZZOBM> domains = trmzzobmService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmzzobmMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
