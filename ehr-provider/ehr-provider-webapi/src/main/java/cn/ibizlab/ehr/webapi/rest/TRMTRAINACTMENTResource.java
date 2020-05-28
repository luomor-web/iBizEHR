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
import cn.ibizlab.ehr.core.trm.domain.TRMTRAINACTMENT;
import cn.ibizlab.ehr.core.trm.service.ITRMTRAINACTMENTService;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINACTMENTSearchContext;

@Slf4j
@Api(tags = {"TRMTRAINACTMENT" })
@RestController("WebApi-trmtrainactment")
@RequestMapping("")
public class TRMTRAINACTMENTResource {

    @Autowired
    public ITRMTRAINACTMENTService trmtrainactmentService;

    @Autowired
    @Lazy
    public TRMTRAINACTMENTMapping trmtrainactmentMapping;

    @PreAuthorize("hasPermission(this.trmtrainactmentService.get(#trmtrainactment_id),'ehr-TRMTRAINACTMENT-Remove')")
    @ApiOperation(value = "Remove", tags = {"TRMTRAINACTMENT" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainactments/{trmtrainactment_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtrainactment_id") String trmtrainactment_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtrainactmentService.remove(trmtrainactment_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainactmentService.getTrmtrainactmentByIds(#ids),'ehr-TRMTRAINACTMENT-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"TRMTRAINACTMENT" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainactments/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtrainactmentService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"TRMTRAINACTMENT" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainactments/getdraft")
    public ResponseEntity<TRMTRAINACTMENTDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainactmentMapping.toDto(trmtrainactmentService.getDraft(new TRMTRAINACTMENT())));
    }

    @ApiOperation(value = "CheckKey", tags = {"TRMTRAINACTMENT" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainactments/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMTRAINACTMENTDTO trmtrainactmentdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainactmentService.checkKey(trmtrainactmentMapping.toDomain(trmtrainactmentdto)));
    }

    @PostAuthorize("hasPermission(this.trmtrainactmentMapping.toDomain(returnObject.body),'ehr-TRMTRAINACTMENT-Get')")
    @ApiOperation(value = "Get", tags = {"TRMTRAINACTMENT" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainactments/{trmtrainactment_id}")
    public ResponseEntity<TRMTRAINACTMENTDTO> get(@PathVariable("trmtrainactment_id") String trmtrainactment_id) {
        TRMTRAINACTMENT domain = trmtrainactmentService.get(trmtrainactment_id);
        TRMTRAINACTMENTDTO dto = trmtrainactmentMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainactmentMapping.toDomain(#trmtrainactmentdto),'ehr-TRMTRAINACTMENT-Save')")
    @ApiOperation(value = "Save", tags = {"TRMTRAINACTMENT" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainactments/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMTRAINACTMENTDTO trmtrainactmentdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainactmentService.save(trmtrainactmentMapping.toDomain(trmtrainactmentdto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainactmentMapping.toDomain(#trmtrainactmentdtos),'ehr-TRMTRAINACTMENT-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"TRMTRAINACTMENT" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainactments/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMTRAINACTMENTDTO> trmtrainactmentdtos) {
        trmtrainactmentService.saveBatch(trmtrainactmentMapping.toDomain(trmtrainactmentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainactmentMapping.toDomain(#trmtrainactmentdto),'ehr-TRMTRAINACTMENT-Create')")
    @ApiOperation(value = "Create", tags = {"TRMTRAINACTMENT" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainactments")
    @Transactional
    public ResponseEntity<TRMTRAINACTMENTDTO> create(@RequestBody TRMTRAINACTMENTDTO trmtrainactmentdto) {
        TRMTRAINACTMENT domain = trmtrainactmentMapping.toDomain(trmtrainactmentdto);
		trmtrainactmentService.create(domain);
        TRMTRAINACTMENTDTO dto = trmtrainactmentMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainactmentMapping.toDomain(#trmtrainactmentdtos),'ehr-TRMTRAINACTMENT-Create')")
    @ApiOperation(value = "createBatch", tags = {"TRMTRAINACTMENT" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainactments/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMTRAINACTMENTDTO> trmtrainactmentdtos) {
        trmtrainactmentService.createBatch(trmtrainactmentMapping.toDomain(trmtrainactmentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainactmentService.get(#trmtrainactment_id),'ehr-TRMTRAINACTMENT-Update')")
    @ApiOperation(value = "Update", tags = {"TRMTRAINACTMENT" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainactments/{trmtrainactment_id}")
    @Transactional
    public ResponseEntity<TRMTRAINACTMENTDTO> update(@PathVariable("trmtrainactment_id") String trmtrainactment_id, @RequestBody TRMTRAINACTMENTDTO trmtrainactmentdto) {
		TRMTRAINACTMENT domain  = trmtrainactmentMapping.toDomain(trmtrainactmentdto);
        domain .setTrmtrainactmentid(trmtrainactment_id);
		trmtrainactmentService.update(domain );
		TRMTRAINACTMENTDTO dto = trmtrainactmentMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainactmentService.getTrmtrainactmentByEntities(this.trmtrainactmentMapping.toDomain(#trmtrainactmentdtos)),'ehr-TRMTRAINACTMENT-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"TRMTRAINACTMENT" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainactments/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMTRAINACTMENTDTO> trmtrainactmentdtos) {
        trmtrainactmentService.updateBatch(trmtrainactmentMapping.toDomain(trmtrainactmentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINACTMENT-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TRMTRAINACTMENT" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainactments/fetchdefault")
	public ResponseEntity<List<TRMTRAINACTMENTDTO>> fetchDefault(TRMTRAINACTMENTSearchContext context) {
        Page<TRMTRAINACTMENT> domains = trmtrainactmentService.searchDefault(context) ;
        List<TRMTRAINACTMENTDTO> list = trmtrainactmentMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINACTMENT-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TRMTRAINACTMENT" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainactments/searchdefault")
	public ResponseEntity<Page<TRMTRAINACTMENTDTO>> searchDefault(@RequestBody TRMTRAINACTMENTSearchContext context) {
        Page<TRMTRAINACTMENT> domains = trmtrainactmentService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainactmentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

