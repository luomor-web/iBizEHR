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
import cn.ibizlab.ehr.core.trm.domain.TRMTRAINDATA;
import cn.ibizlab.ehr.core.trm.service.ITRMTRAINDATAService;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINDATASearchContext;

@Slf4j
@Api(tags = {"TRMTRAINDATA" })
@RestController("WebApi-trmtraindata")
@RequestMapping("")
public class TRMTRAINDATAResource {

    @Autowired
    public ITRMTRAINDATAService trmtraindataService;

    @Autowired
    @Lazy
    public TRMTRAINDATAMapping trmtraindataMapping;

    @PreAuthorize("hasPermission(this.trmtraindataMapping.toDomain(#trmtraindatadto),'ehr-TRMTRAINDATA-Save')")
    @ApiOperation(value = "Save", tags = {"TRMTRAINDATA" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraindata/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMTRAINDATADTO trmtraindatadto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtraindataService.save(trmtraindataMapping.toDomain(trmtraindatadto)));
    }

    @PreAuthorize("hasPermission(this.trmtraindataMapping.toDomain(#trmtraindatadtos),'ehr-TRMTRAINDATA-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"TRMTRAINDATA" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraindata/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMTRAINDATADTO> trmtraindatadtos) {
        trmtraindataService.saveBatch(trmtraindataMapping.toDomain(trmtraindatadtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtraindataService.get(#trmtraindata_id),'ehr-TRMTRAINDATA-Remove')")
    @ApiOperation(value = "Remove", tags = {"TRMTRAINDATA" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtraindata/{trmtraindata_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtraindata_id") String trmtraindata_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtraindataService.remove(trmtraindata_id));
    }

    @PreAuthorize("hasPermission(this.trmtraindataService.getTrmtraindataByIds(#ids),'ehr-TRMTRAINDATA-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"TRMTRAINDATA" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtraindata/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtraindataService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmtraindataMapping.toDomain(returnObject.body),'ehr-TRMTRAINDATA-Get')")
    @ApiOperation(value = "Get", tags = {"TRMTRAINDATA" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtraindata/{trmtraindata_id}")
    public ResponseEntity<TRMTRAINDATADTO> get(@PathVariable("trmtraindata_id") String trmtraindata_id) {
        TRMTRAINDATA domain = trmtraindataService.get(trmtraindata_id);
        TRMTRAINDATADTO dto = trmtraindataMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "GetDraft", tags = {"TRMTRAINDATA" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtraindata/getdraft")
    public ResponseEntity<TRMTRAINDATADTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtraindataMapping.toDto(trmtraindataService.getDraft(new TRMTRAINDATA())));
    }

    @PreAuthorize("hasPermission(this.trmtraindataService.get(#trmtraindata_id),'ehr-TRMTRAINDATA-Update')")
    @ApiOperation(value = "Update", tags = {"TRMTRAINDATA" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtraindata/{trmtraindata_id}")
    @Transactional
    public ResponseEntity<TRMTRAINDATADTO> update(@PathVariable("trmtraindata_id") String trmtraindata_id, @RequestBody TRMTRAINDATADTO trmtraindatadto) {
		TRMTRAINDATA domain  = trmtraindataMapping.toDomain(trmtraindatadto);
        domain .setTrmtraindataid(trmtraindata_id);
		trmtraindataService.update(domain );
		TRMTRAINDATADTO dto = trmtraindataMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtraindataService.getTrmtraindataByEntities(this.trmtraindataMapping.toDomain(#trmtraindatadtos)),'ehr-TRMTRAINDATA-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"TRMTRAINDATA" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtraindata/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMTRAINDATADTO> trmtraindatadtos) {
        trmtraindataService.updateBatch(trmtraindataMapping.toDomain(trmtraindatadtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"TRMTRAINDATA" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraindata/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMTRAINDATADTO trmtraindatadto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtraindataService.checkKey(trmtraindataMapping.toDomain(trmtraindatadto)));
    }

    @PreAuthorize("hasPermission(this.trmtraindataMapping.toDomain(#trmtraindatadto),'ehr-TRMTRAINDATA-Create')")
    @ApiOperation(value = "Create", tags = {"TRMTRAINDATA" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraindata")
    @Transactional
    public ResponseEntity<TRMTRAINDATADTO> create(@RequestBody TRMTRAINDATADTO trmtraindatadto) {
        TRMTRAINDATA domain = trmtraindataMapping.toDomain(trmtraindatadto);
		trmtraindataService.create(domain);
        TRMTRAINDATADTO dto = trmtraindataMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtraindataMapping.toDomain(#trmtraindatadtos),'ehr-TRMTRAINDATA-Create')")
    @ApiOperation(value = "createBatch", tags = {"TRMTRAINDATA" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraindata/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMTRAINDATADTO> trmtraindatadtos) {
        trmtraindataService.createBatch(trmtraindataMapping.toDomain(trmtraindatadtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINDATA-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TRMTRAINDATA" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtraindata/fetchdefault")
	public ResponseEntity<List<TRMTRAINDATADTO>> fetchDefault(TRMTRAINDATASearchContext context) {
        Page<TRMTRAINDATA> domains = trmtraindataService.searchDefault(context) ;
        List<TRMTRAINDATADTO> list = trmtraindataMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINDATA-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TRMTRAINDATA" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtraindata/searchdefault")
	public ResponseEntity<Page<TRMTRAINDATADTO>> searchDefault(@RequestBody TRMTRAINDATASearchContext context) {
        Page<TRMTRAINDATA> domains = trmtraindataService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtraindataMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

