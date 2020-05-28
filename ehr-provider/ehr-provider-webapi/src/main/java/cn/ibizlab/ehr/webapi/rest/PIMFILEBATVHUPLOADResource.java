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
import cn.ibizlab.ehr.core.pim.domain.PIMFILEBATVHUPLOAD;
import cn.ibizlab.ehr.core.pim.service.IPIMFILEBATVHUPLOADService;
import cn.ibizlab.ehr.core.pim.filter.PIMFILEBATVHUPLOADSearchContext;

@Slf4j
@Api(tags = {"PIMFILEBATVHUPLOAD" })
@RestController("WebApi-pimfilebatvhupload")
@RequestMapping("")
public class PIMFILEBATVHUPLOADResource {

    @Autowired
    public IPIMFILEBATVHUPLOADService pimfilebatvhuploadService;

    @Autowired
    @Lazy
    public PIMFILEBATVHUPLOADMapping pimfilebatvhuploadMapping;

    @PreAuthorize("hasPermission(this.pimfilebatvhuploadMapping.toDomain(#pimfilebatvhuploaddto),'ehr-PIMFILEBATVHUPLOAD-Save')")
    @ApiOperation(value = "Save", tags = {"PIMFILEBATVHUPLOAD" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimfilebatvhuploads/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMFILEBATVHUPLOADDTO pimfilebatvhuploaddto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimfilebatvhuploadService.save(pimfilebatvhuploadMapping.toDomain(pimfilebatvhuploaddto)));
    }

    @PreAuthorize("hasPermission(this.pimfilebatvhuploadMapping.toDomain(#pimfilebatvhuploaddtos),'ehr-PIMFILEBATVHUPLOAD-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PIMFILEBATVHUPLOAD" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimfilebatvhuploads/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMFILEBATVHUPLOADDTO> pimfilebatvhuploaddtos) {
        pimfilebatvhuploadService.saveBatch(pimfilebatvhuploadMapping.toDomain(pimfilebatvhuploaddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimfilebatvhuploadMapping.toDomain(returnObject.body),'ehr-PIMFILEBATVHUPLOAD-Get')")
    @ApiOperation(value = "Get", tags = {"PIMFILEBATVHUPLOAD" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimfilebatvhuploads/{pimfilebatvhupload_id}")
    public ResponseEntity<PIMFILEBATVHUPLOADDTO> get(@PathVariable("pimfilebatvhupload_id") String pimfilebatvhupload_id) {
        PIMFILEBATVHUPLOAD domain = pimfilebatvhuploadService.get(pimfilebatvhupload_id);
        PIMFILEBATVHUPLOADDTO dto = pimfilebatvhuploadMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKey", tags = {"PIMFILEBATVHUPLOAD" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimfilebatvhuploads/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMFILEBATVHUPLOADDTO pimfilebatvhuploaddto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimfilebatvhuploadService.checkKey(pimfilebatvhuploadMapping.toDomain(pimfilebatvhuploaddto)));
    }

    @PreAuthorize("hasPermission(this.pimfilebatvhuploadService.get(#pimfilebatvhupload_id),'ehr-PIMFILEBATVHUPLOAD-Update')")
    @ApiOperation(value = "Update", tags = {"PIMFILEBATVHUPLOAD" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimfilebatvhuploads/{pimfilebatvhupload_id}")
    @Transactional
    public ResponseEntity<PIMFILEBATVHUPLOADDTO> update(@PathVariable("pimfilebatvhupload_id") String pimfilebatvhupload_id, @RequestBody PIMFILEBATVHUPLOADDTO pimfilebatvhuploaddto) {
		PIMFILEBATVHUPLOAD domain  = pimfilebatvhuploadMapping.toDomain(pimfilebatvhuploaddto);
        domain .setPimfilebatvhuploadid(pimfilebatvhupload_id);
		pimfilebatvhuploadService.update(domain );
		PIMFILEBATVHUPLOADDTO dto = pimfilebatvhuploadMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimfilebatvhuploadService.getPimfilebatvhuploadByEntities(this.pimfilebatvhuploadMapping.toDomain(#pimfilebatvhuploaddtos)),'ehr-PIMFILEBATVHUPLOAD-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMFILEBATVHUPLOAD" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimfilebatvhuploads/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMFILEBATVHUPLOADDTO> pimfilebatvhuploaddtos) {
        pimfilebatvhuploadService.updateBatch(pimfilebatvhuploadMapping.toDomain(pimfilebatvhuploaddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimfilebatvhuploadMapping.toDomain(#pimfilebatvhuploaddto),'ehr-PIMFILEBATVHUPLOAD-Create')")
    @ApiOperation(value = "Create", tags = {"PIMFILEBATVHUPLOAD" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimfilebatvhuploads")
    @Transactional
    public ResponseEntity<PIMFILEBATVHUPLOADDTO> create(@RequestBody PIMFILEBATVHUPLOADDTO pimfilebatvhuploaddto) {
        PIMFILEBATVHUPLOAD domain = pimfilebatvhuploadMapping.toDomain(pimfilebatvhuploaddto);
		pimfilebatvhuploadService.create(domain);
        PIMFILEBATVHUPLOADDTO dto = pimfilebatvhuploadMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimfilebatvhuploadMapping.toDomain(#pimfilebatvhuploaddtos),'ehr-PIMFILEBATVHUPLOAD-Create')")
    @ApiOperation(value = "createBatch", tags = {"PIMFILEBATVHUPLOAD" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimfilebatvhuploads/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMFILEBATVHUPLOADDTO> pimfilebatvhuploaddtos) {
        pimfilebatvhuploadService.createBatch(pimfilebatvhuploadMapping.toDomain(pimfilebatvhuploaddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"PIMFILEBATVHUPLOAD" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimfilebatvhuploads/getdraft")
    public ResponseEntity<PIMFILEBATVHUPLOADDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimfilebatvhuploadMapping.toDto(pimfilebatvhuploadService.getDraft(new PIMFILEBATVHUPLOAD())));
    }

    @PreAuthorize("hasPermission(this.pimfilebatvhuploadService.get(#pimfilebatvhupload_id),'ehr-PIMFILEBATVHUPLOAD-Remove')")
    @ApiOperation(value = "Remove", tags = {"PIMFILEBATVHUPLOAD" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimfilebatvhuploads/{pimfilebatvhupload_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimfilebatvhupload_id") String pimfilebatvhupload_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimfilebatvhuploadService.remove(pimfilebatvhupload_id));
    }

    @PreAuthorize("hasPermission(this.pimfilebatvhuploadService.getPimfilebatvhuploadByIds(#ids),'ehr-PIMFILEBATVHUPLOAD-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PIMFILEBATVHUPLOAD" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimfilebatvhuploads/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimfilebatvhuploadService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMFILEBATVHUPLOAD-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMFILEBATVHUPLOAD" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimfilebatvhuploads/fetchdefault")
	public ResponseEntity<List<PIMFILEBATVHUPLOADDTO>> fetchDefault(PIMFILEBATVHUPLOADSearchContext context) {
        Page<PIMFILEBATVHUPLOAD> domains = pimfilebatvhuploadService.searchDefault(context) ;
        List<PIMFILEBATVHUPLOADDTO> list = pimfilebatvhuploadMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMFILEBATVHUPLOAD-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMFILEBATVHUPLOAD" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimfilebatvhuploads/searchdefault")
	public ResponseEntity<Page<PIMFILEBATVHUPLOADDTO>> searchDefault(@RequestBody PIMFILEBATVHUPLOADSearchContext context) {
        Page<PIMFILEBATVHUPLOAD> domains = pimfilebatvhuploadService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimfilebatvhuploadMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

