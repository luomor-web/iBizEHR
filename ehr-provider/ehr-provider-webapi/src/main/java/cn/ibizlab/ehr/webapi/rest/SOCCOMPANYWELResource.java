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
import cn.ibizlab.ehr.core.soc.domain.SOCCOMPANYWEL;
import cn.ibizlab.ehr.core.soc.service.ISOCCOMPANYWELService;
import cn.ibizlab.ehr.core.soc.filter.SOCCOMPANYWELSearchContext;

@Slf4j
@Api(tags = {"SOCCOMPANYWEL" })
@RestController("WebApi-soccompanywel")
@RequestMapping("")
public class SOCCOMPANYWELResource {

    @Autowired
    public ISOCCOMPANYWELService soccompanywelService;

    @Autowired
    @Lazy
    public SOCCOMPANYWELMapping soccompanywelMapping;

    @PreAuthorize("hasPermission(this.soccompanywelMapping.toDomain(#soccompanyweldto),'ehr-SOCCOMPANYWEL-Create')")
    @ApiOperation(value = "Create", tags = {"SOCCOMPANYWEL" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/soccompanywels")
    @Transactional
    public ResponseEntity<SOCCOMPANYWELDTO> create(@RequestBody SOCCOMPANYWELDTO soccompanyweldto) {
        SOCCOMPANYWEL domain = soccompanywelMapping.toDomain(soccompanyweldto);
		soccompanywelService.create(domain);
        SOCCOMPANYWELDTO dto = soccompanywelMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.soccompanywelMapping.toDomain(#soccompanyweldtos),'ehr-SOCCOMPANYWEL-Create')")
    @ApiOperation(value = "createBatch", tags = {"SOCCOMPANYWEL" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/soccompanywels/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SOCCOMPANYWELDTO> soccompanyweldtos) {
        soccompanywelService.createBatch(soccompanywelMapping.toDomain(soccompanyweldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"SOCCOMPANYWEL" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/soccompanywels/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SOCCOMPANYWELDTO soccompanyweldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(soccompanywelService.checkKey(soccompanywelMapping.toDomain(soccompanyweldto)));
    }

    @PreAuthorize("hasPermission(this.soccompanywelMapping.toDomain(#soccompanyweldto),'ehr-SOCCOMPANYWEL-Save')")
    @ApiOperation(value = "Save", tags = {"SOCCOMPANYWEL" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/soccompanywels/save")
    public ResponseEntity<Boolean> save(@RequestBody SOCCOMPANYWELDTO soccompanyweldto) {
        return ResponseEntity.status(HttpStatus.OK).body(soccompanywelService.save(soccompanywelMapping.toDomain(soccompanyweldto)));
    }

    @PreAuthorize("hasPermission(this.soccompanywelMapping.toDomain(#soccompanyweldtos),'ehr-SOCCOMPANYWEL-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"SOCCOMPANYWEL" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/soccompanywels/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SOCCOMPANYWELDTO> soccompanyweldtos) {
        soccompanywelService.saveBatch(soccompanywelMapping.toDomain(soccompanyweldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.soccompanywelService.get(#soccompanywel_id),'ehr-SOCCOMPANYWEL-Update')")
    @ApiOperation(value = "Update", tags = {"SOCCOMPANYWEL" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/soccompanywels/{soccompanywel_id}")
    @Transactional
    public ResponseEntity<SOCCOMPANYWELDTO> update(@PathVariable("soccompanywel_id") String soccompanywel_id, @RequestBody SOCCOMPANYWELDTO soccompanyweldto) {
		SOCCOMPANYWEL domain  = soccompanywelMapping.toDomain(soccompanyweldto);
        domain .setSoccompanywelid(soccompanywel_id);
		soccompanywelService.update(domain );
		SOCCOMPANYWELDTO dto = soccompanywelMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.soccompanywelService.getSoccompanywelByEntities(this.soccompanywelMapping.toDomain(#soccompanyweldtos)),'ehr-SOCCOMPANYWEL-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"SOCCOMPANYWEL" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/soccompanywels/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SOCCOMPANYWELDTO> soccompanyweldtos) {
        soccompanywelService.updateBatch(soccompanywelMapping.toDomain(soccompanyweldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.soccompanywelMapping.toDomain(returnObject.body),'ehr-SOCCOMPANYWEL-Get')")
    @ApiOperation(value = "Get", tags = {"SOCCOMPANYWEL" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/soccompanywels/{soccompanywel_id}")
    public ResponseEntity<SOCCOMPANYWELDTO> get(@PathVariable("soccompanywel_id") String soccompanywel_id) {
        SOCCOMPANYWEL domain = soccompanywelService.get(soccompanywel_id);
        SOCCOMPANYWELDTO dto = soccompanywelMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.soccompanywelService.get(#soccompanywel_id),'ehr-SOCCOMPANYWEL-Remove')")
    @ApiOperation(value = "Remove", tags = {"SOCCOMPANYWEL" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/soccompanywels/{soccompanywel_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("soccompanywel_id") String soccompanywel_id) {
         return ResponseEntity.status(HttpStatus.OK).body(soccompanywelService.remove(soccompanywel_id));
    }

    @PreAuthorize("hasPermission(this.soccompanywelService.getSoccompanywelByIds(#ids),'ehr-SOCCOMPANYWEL-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"SOCCOMPANYWEL" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/soccompanywels/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        soccompanywelService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"SOCCOMPANYWEL" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/soccompanywels/getdraft")
    public ResponseEntity<SOCCOMPANYWELDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(soccompanywelMapping.toDto(soccompanywelService.getDraft(new SOCCOMPANYWEL())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SOCCOMPANYWEL-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SOCCOMPANYWEL" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/soccompanywels/fetchdefault")
	public ResponseEntity<List<SOCCOMPANYWELDTO>> fetchDefault(SOCCOMPANYWELSearchContext context) {
        Page<SOCCOMPANYWEL> domains = soccompanywelService.searchDefault(context) ;
        List<SOCCOMPANYWELDTO> list = soccompanywelMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SOCCOMPANYWEL-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SOCCOMPANYWEL" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/soccompanywels/searchdefault")
	public ResponseEntity<Page<SOCCOMPANYWELDTO>> searchDefault(@RequestBody SOCCOMPANYWELSearchContext context) {
        Page<SOCCOMPANYWEL> domains = soccompanywelService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(soccompanywelMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

