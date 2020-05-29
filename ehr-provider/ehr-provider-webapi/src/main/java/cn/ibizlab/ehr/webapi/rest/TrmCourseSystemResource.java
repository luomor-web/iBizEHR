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
import cn.ibizlab.ehr.core.trm.domain.TrmCourseSystem;
import cn.ibizlab.ehr.core.trm.service.ITrmCourseSystemService;
import cn.ibizlab.ehr.core.trm.filter.TrmCourseSystemSearchContext;

@Slf4j
@Api(tags = {"TrmCourseSystem" })
@RestController("WebApi-trmcoursesystem")
@RequestMapping("")
public class TrmCourseSystemResource {

    @Autowired
    public ITrmCourseSystemService trmcoursesystemService;

    @Autowired
    @Lazy
    public TrmCourseSystemMapping trmcoursesystemMapping;

    @PreAuthorize("hasPermission(this.trmcoursesystemService.get(#trmcoursesystem_id),'ehr-TrmCourseSystem-Update')")
    @ApiOperation(value = "Update", tags = {"TrmCourseSystem" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmcoursesystems/{trmcoursesystem_id}")
    @Transactional
    public ResponseEntity<TrmCourseSystemDTO> update(@PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @RequestBody TrmCourseSystemDTO trmcoursesystemdto) {
		TrmCourseSystem domain  = trmcoursesystemMapping.toDomain(trmcoursesystemdto);
        domain .setTrmcoursesystemid(trmcoursesystem_id);
		trmcoursesystemService.update(domain );
		TrmCourseSystemDTO dto = trmcoursesystemMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmcoursesystemService.getTrmcoursesystemByEntities(this.trmcoursesystemMapping.toDomain(#trmcoursesystemdtos)),'ehr-TrmCourseSystem-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"TrmCourseSystem" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmcoursesystems/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmCourseSystemDTO> trmcoursesystemdtos) {
        trmcoursesystemService.updateBatch(trmcoursesystemMapping.toDomain(trmcoursesystemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmcoursesystemMapping.toDomain(#trmcoursesystemdto),'ehr-TrmCourseSystem-Save')")
    @ApiOperation(value = "Save", tags = {"TrmCourseSystem" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcoursesystems/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmCourseSystemDTO trmcoursesystemdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmcoursesystemService.save(trmcoursesystemMapping.toDomain(trmcoursesystemdto)));
    }

    @PreAuthorize("hasPermission(this.trmcoursesystemMapping.toDomain(#trmcoursesystemdtos),'ehr-TrmCourseSystem-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"TrmCourseSystem" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcoursesystems/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmCourseSystemDTO> trmcoursesystemdtos) {
        trmcoursesystemService.saveBatch(trmcoursesystemMapping.toDomain(trmcoursesystemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"TrmCourseSystem" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcoursesystems/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmCourseSystemDTO trmcoursesystemdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmcoursesystemService.checkKey(trmcoursesystemMapping.toDomain(trmcoursesystemdto)));
    }

    @ApiOperation(value = "GetDraft", tags = {"TrmCourseSystem" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmcoursesystems/getdraft")
    public ResponseEntity<TrmCourseSystemDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmcoursesystemMapping.toDto(trmcoursesystemService.getDraft(new TrmCourseSystem())));
    }

    @PostAuthorize("hasPermission(this.trmcoursesystemMapping.toDomain(returnObject.body),'ehr-TrmCourseSystem-Get')")
    @ApiOperation(value = "Get", tags = {"TrmCourseSystem" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmcoursesystems/{trmcoursesystem_id}")
    public ResponseEntity<TrmCourseSystemDTO> get(@PathVariable("trmcoursesystem_id") String trmcoursesystem_id) {
        TrmCourseSystem domain = trmcoursesystemService.get(trmcoursesystem_id);
        TrmCourseSystemDTO dto = trmcoursesystemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmcoursesystemService.get(#trmcoursesystem_id),'ehr-TrmCourseSystem-Remove')")
    @ApiOperation(value = "Remove", tags = {"TrmCourseSystem" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmcoursesystems/{trmcoursesystem_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmcoursesystem_id") String trmcoursesystem_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmcoursesystemService.remove(trmcoursesystem_id));
    }

    @PreAuthorize("hasPermission(this.trmcoursesystemService.getTrmcoursesystemByIds(#ids),'ehr-TrmCourseSystem-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"TrmCourseSystem" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmcoursesystems/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmcoursesystemService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmcoursesystemMapping.toDomain(#trmcoursesystemdto),'ehr-TrmCourseSystem-Create')")
    @ApiOperation(value = "Create", tags = {"TrmCourseSystem" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcoursesystems")
    @Transactional
    public ResponseEntity<TrmCourseSystemDTO> create(@RequestBody TrmCourseSystemDTO trmcoursesystemdto) {
        TrmCourseSystem domain = trmcoursesystemMapping.toDomain(trmcoursesystemdto);
		trmcoursesystemService.create(domain);
        TrmCourseSystemDTO dto = trmcoursesystemMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmcoursesystemMapping.toDomain(#trmcoursesystemdtos),'ehr-TrmCourseSystem-Create')")
    @ApiOperation(value = "createBatch", tags = {"TrmCourseSystem" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcoursesystems/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmCourseSystemDTO> trmcoursesystemdtos) {
        trmcoursesystemService.createBatch(trmcoursesystemMapping.toDomain(trmcoursesystemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmCourseSystem-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TrmCourseSystem" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmcoursesystems/fetchdefault")
	public ResponseEntity<List<TrmCourseSystemDTO>> fetchDefault(TrmCourseSystemSearchContext context) {
        Page<TrmCourseSystem> domains = trmcoursesystemService.searchDefault(context) ;
        List<TrmCourseSystemDTO> list = trmcoursesystemMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmCourseSystem-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TrmCourseSystem" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmcoursesystems/searchdefault")
	public ResponseEntity<Page<TrmCourseSystemDTO>> searchDefault(@RequestBody TrmCourseSystemSearchContext context) {
        Page<TrmCourseSystem> domains = trmcoursesystemService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmcoursesystemMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

