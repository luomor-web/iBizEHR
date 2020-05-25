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
import cn.ibizlab.ehr.core.par.domain.PARJXBZGL;
import cn.ibizlab.ehr.core.par.service.IPARJXBZGLService;
import cn.ibizlab.ehr.core.par.filter.PARJXBZGLSearchContext;

@Slf4j
@Api(tags = {"PARJXBZGL" })
@RestController("WebApi-parjxbzgl")
@RequestMapping("")
public class PARJXBZGLResource {

    @Autowired
    private IPARJXBZGLService parjxbzglService;

    @Autowired
    @Lazy
    public PARJXBZGLMapping parjxbzglMapping;

    public PARJXBZGLDTO permissionDTO=new PARJXBZGLDTO();

    @PreAuthorize("hasPermission(#parjxbzgl_id,'Get',{'Sql',this.parjxbzglMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PARJXBZGL" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxbzgls/{parjxbzgl_id}")
    public ResponseEntity<PARJXBZGLDTO> get(@PathVariable("parjxbzgl_id") String parjxbzgl_id) {
        PARJXBZGL domain = parjxbzglService.get(parjxbzgl_id);
        PARJXBZGLDTO dto = parjxbzglMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXBZGL-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PARJXBZGL" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxbzgls/getdraft")
    public ResponseEntity<PARJXBZGLDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parjxbzglMapping.toDto(parjxbzglService.getDraft(new PARJXBZGL())));
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.parjxbzglMapping,#parjxbzgldto})")
    @ApiOperation(value = "Save", tags = {"PARJXBZGL" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzgls/save")
    public ResponseEntity<Boolean> save(@RequestBody PARJXBZGLDTO parjxbzgldto) {
        return ResponseEntity.status(HttpStatus.OK).body(parjxbzglService.save(parjxbzglMapping.toDomain(parjxbzgldto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PARJXBZGL" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzgls/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARJXBZGLDTO> parjxbzgldtos) {
        parjxbzglService.saveBatch(parjxbzglMapping.toDomain(parjxbzgldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.parjxbzglMapping,#parjxbzgldto})")
    @ApiOperation(value = "Create", tags = {"PARJXBZGL" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzgls")
    @Transactional
    public ResponseEntity<PARJXBZGLDTO> create(@RequestBody PARJXBZGLDTO parjxbzgldto) {
        PARJXBZGL domain = parjxbzglMapping.toDomain(parjxbzgldto);
		parjxbzglService.create(domain);
        PARJXBZGLDTO dto = parjxbzglMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"PARJXBZGL" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzgls/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARJXBZGLDTO> parjxbzgldtos) {
        parjxbzglService.createBatch(parjxbzglMapping.toDomain(parjxbzgldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#parjxbzgl_id,'Update',{'Sql',this.parjxbzglMapping,#parjxbzgldto})")
    @ApiOperation(value = "Update", tags = {"PARJXBZGL" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxbzgls/{parjxbzgl_id}")
    @Transactional
    public ResponseEntity<PARJXBZGLDTO> update(@PathVariable("parjxbzgl_id") String parjxbzgl_id, @RequestBody PARJXBZGLDTO parjxbzgldto) {
		PARJXBZGL domain = parjxbzglMapping.toDomain(parjxbzgldto);
        domain.setParjxbzglid(parjxbzgl_id);
		parjxbzglService.update(domain);
		PARJXBZGLDTO dto = parjxbzglMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PARJXBZGL" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxbzgls/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARJXBZGLDTO> parjxbzgldtos) {
        parjxbzglService.updateBatch(parjxbzglMapping.toDomain(parjxbzgldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#parjxbzgl_id,'Remove',{'Sql',this.parjxbzglMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PARJXBZGL" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxbzgls/{parjxbzgl_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parjxbzgl_id") String parjxbzgl_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parjxbzglService.remove(parjxbzgl_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PARJXBZGL" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxbzgls/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parjxbzglService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXBZGL-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PARJXBZGL" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzgls/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARJXBZGLDTO parjxbzgldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parjxbzglService.checkKey(parjxbzglMapping.toDomain(parjxbzgldto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXBZGL-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PARJXBZGL" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parjxbzgls/fetchdefault")
	public ResponseEntity<List<PARJXBZGLDTO>> fetchDefault(PARJXBZGLSearchContext context) {
        Page<PARJXBZGL> domains = parjxbzglService.searchDefault(context) ;
        List<PARJXBZGLDTO> list = parjxbzglMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXBZGL-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PARJXBZGL" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parjxbzgls/searchdefault")
	public ResponseEntity<Page<PARJXBZGLDTO>> searchDefault(@RequestBody PARJXBZGLSearchContext context) {
        Page<PARJXBZGL> domains = parjxbzglService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjxbzglMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
