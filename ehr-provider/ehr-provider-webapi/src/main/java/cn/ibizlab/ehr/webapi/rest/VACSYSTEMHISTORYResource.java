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
import cn.ibizlab.ehr.core.vac.domain.VACSYSTEMHISTORY;
import cn.ibizlab.ehr.core.vac.service.IVACSYSTEMHISTORYService;
import cn.ibizlab.ehr.core.vac.filter.VACSYSTEMHISTORYSearchContext;

@Slf4j
@Api(tags = {"VACSYSTEMHISTORY" })
@RestController("WebApi-vacsystemhistory")
@RequestMapping("")
public class VACSYSTEMHISTORYResource {

    @Autowired
    public IVACSYSTEMHISTORYService vacsystemhistoryService;

    @Autowired
    @Lazy
    public VACSYSTEMHISTORYMapping vacsystemhistoryMapping;

    @PreAuthorize("hasPermission(this.vacsystemhistoryService.get(#vacsystemhistory_id),'ehr-VACSYSTEMHISTORY-Update')")
    @ApiOperation(value = "Update", tags = {"VACSYSTEMHISTORY" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacsystemhistories/{vacsystemhistory_id}")
    @Transactional
    public ResponseEntity<VACSYSTEMHISTORYDTO> update(@PathVariable("vacsystemhistory_id") String vacsystemhistory_id, @RequestBody VACSYSTEMHISTORYDTO vacsystemhistorydto) {
		VACSYSTEMHISTORY domain  = vacsystemhistoryMapping.toDomain(vacsystemhistorydto);
        domain .setVacsystemhistoryid(vacsystemhistory_id);
		vacsystemhistoryService.update(domain );
		VACSYSTEMHISTORYDTO dto = vacsystemhistoryMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacsystemhistoryService.getVacsystemhistoryByEntities(this.vacsystemhistoryMapping.toDomain(#vacsystemhistorydtos)),'ehr-VACSYSTEMHISTORY-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"VACSYSTEMHISTORY" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacsystemhistories/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VACSYSTEMHISTORYDTO> vacsystemhistorydtos) {
        vacsystemhistoryService.updateBatch(vacsystemhistoryMapping.toDomain(vacsystemhistorydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacsystemhistoryService.get(#vacsystemhistory_id),'ehr-VACSYSTEMHISTORY-Remove')")
    @ApiOperation(value = "Remove", tags = {"VACSYSTEMHISTORY" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacsystemhistories/{vacsystemhistory_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacsystemhistory_id") String vacsystemhistory_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacsystemhistoryService.remove(vacsystemhistory_id));
    }

    @PreAuthorize("hasPermission(this.vacsystemhistoryService.getVacsystemhistoryByIds(#ids),'ehr-VACSYSTEMHISTORY-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"VACSYSTEMHISTORY" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacsystemhistories/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacsystemhistoryService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacsystemhistoryMapping.toDomain(#vacsystemhistorydto),'ehr-VACSYSTEMHISTORY-Save')")
    @ApiOperation(value = "Save", tags = {"VACSYSTEMHISTORY" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsystemhistories/save")
    public ResponseEntity<Boolean> save(@RequestBody VACSYSTEMHISTORYDTO vacsystemhistorydto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacsystemhistoryService.save(vacsystemhistoryMapping.toDomain(vacsystemhistorydto)));
    }

    @PreAuthorize("hasPermission(this.vacsystemhistoryMapping.toDomain(#vacsystemhistorydtos),'ehr-VACSYSTEMHISTORY-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"VACSYSTEMHISTORY" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsystemhistories/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VACSYSTEMHISTORYDTO> vacsystemhistorydtos) {
        vacsystemhistoryService.saveBatch(vacsystemhistoryMapping.toDomain(vacsystemhistorydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.vacsystemhistoryMapping.toDomain(returnObject.body),'ehr-VACSYSTEMHISTORY-Get')")
    @ApiOperation(value = "Get", tags = {"VACSYSTEMHISTORY" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/vacsystemhistories/{vacsystemhistory_id}")
    public ResponseEntity<VACSYSTEMHISTORYDTO> get(@PathVariable("vacsystemhistory_id") String vacsystemhistory_id) {
        VACSYSTEMHISTORY domain = vacsystemhistoryService.get(vacsystemhistory_id);
        VACSYSTEMHISTORYDTO dto = vacsystemhistoryMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKey", tags = {"VACSYSTEMHISTORY" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsystemhistories/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VACSYSTEMHISTORYDTO vacsystemhistorydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacsystemhistoryService.checkKey(vacsystemhistoryMapping.toDomain(vacsystemhistorydto)));
    }

    @PreAuthorize("hasPermission(this.vacsystemhistoryMapping.toDomain(#vacsystemhistorydto),'ehr-VACSYSTEMHISTORY-Create')")
    @ApiOperation(value = "Create", tags = {"VACSYSTEMHISTORY" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsystemhistories")
    @Transactional
    public ResponseEntity<VACSYSTEMHISTORYDTO> create(@RequestBody VACSYSTEMHISTORYDTO vacsystemhistorydto) {
        VACSYSTEMHISTORY domain = vacsystemhistoryMapping.toDomain(vacsystemhistorydto);
		vacsystemhistoryService.create(domain);
        VACSYSTEMHISTORYDTO dto = vacsystemhistoryMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacsystemhistoryMapping.toDomain(#vacsystemhistorydtos),'ehr-VACSYSTEMHISTORY-Create')")
    @ApiOperation(value = "createBatch", tags = {"VACSYSTEMHISTORY" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsystemhistories/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VACSYSTEMHISTORYDTO> vacsystemhistorydtos) {
        vacsystemhistoryService.createBatch(vacsystemhistoryMapping.toDomain(vacsystemhistorydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"VACSYSTEMHISTORY" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/vacsystemhistories/getdraft")
    public ResponseEntity<VACSYSTEMHISTORYDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacsystemhistoryMapping.toDto(vacsystemhistoryService.getDraft(new VACSYSTEMHISTORY())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACSYSTEMHISTORY-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"VACSYSTEMHISTORY" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacsystemhistories/fetchdefault")
	public ResponseEntity<List<VACSYSTEMHISTORYDTO>> fetchDefault(VACSYSTEMHISTORYSearchContext context) {
        Page<VACSYSTEMHISTORY> domains = vacsystemhistoryService.searchDefault(context) ;
        List<VACSYSTEMHISTORYDTO> list = vacsystemhistoryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACSYSTEMHISTORY-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"VACSYSTEMHISTORY" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacsystemhistories/searchdefault")
	public ResponseEntity<Page<VACSYSTEMHISTORYDTO>> searchDefault(@RequestBody VACSYSTEMHISTORYSearchContext context) {
        Page<VACSYSTEMHISTORY> domains = vacsystemhistoryService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacsystemhistoryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

