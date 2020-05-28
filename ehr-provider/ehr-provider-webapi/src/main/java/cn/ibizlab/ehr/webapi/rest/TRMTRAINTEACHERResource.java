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
import cn.ibizlab.ehr.core.trm.domain.TRMTRAINTEACHER;
import cn.ibizlab.ehr.core.trm.service.ITRMTRAINTEACHERService;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINTEACHERSearchContext;

@Slf4j
@Api(tags = {"TRMTRAINTEACHER" })
@RestController("WebApi-trmtrainteacher")
@RequestMapping("")
public class TRMTRAINTEACHERResource {

    @Autowired
    public ITRMTRAINTEACHERService trmtrainteacherService;

    @Autowired
    @Lazy
    public TRMTRAINTEACHERMapping trmtrainteacherMapping;

    @PreAuthorize("hasPermission(this.trmtrainteacherService.get(#trmtrainteacher_id),'ehr-TRMTRAINTEACHER-Remove')")
    @ApiOperation(value = "Remove", tags = {"TRMTRAINTEACHER" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainteachers/{trmtrainteacher_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtrainteacherService.remove(trmtrainteacher_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainteacherService.getTrmtrainteacherByIds(#ids),'ehr-TRMTRAINTEACHER-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"TRMTRAINTEACHER" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainteachers/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtrainteacherService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainteacherService.get(#trmtrainteacher_id),'ehr-TRMTRAINTEACHER-Update')")
    @ApiOperation(value = "Update", tags = {"TRMTRAINTEACHER" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainteachers/{trmtrainteacher_id}")
    @Transactional
    public ResponseEntity<TRMTRAINTEACHERDTO> update(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody TRMTRAINTEACHERDTO trmtrainteacherdto) {
		TRMTRAINTEACHER domain  = trmtrainteacherMapping.toDomain(trmtrainteacherdto);
        domain .setTrmtrainteacherid(trmtrainteacher_id);
		trmtrainteacherService.update(domain );
		TRMTRAINTEACHERDTO dto = trmtrainteacherMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainteacherService.getTrmtrainteacherByEntities(this.trmtrainteacherMapping.toDomain(#trmtrainteacherdtos)),'ehr-TRMTRAINTEACHER-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"TRMTRAINTEACHER" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainteachers/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMTRAINTEACHERDTO> trmtrainteacherdtos) {
        trmtrainteacherService.updateBatch(trmtrainteacherMapping.toDomain(trmtrainteacherdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"TRMTRAINTEACHER" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainteachers/getdraft")
    public ResponseEntity<TRMTRAINTEACHERDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainteacherMapping.toDto(trmtrainteacherService.getDraft(new TRMTRAINTEACHER())));
    }

    @PostAuthorize("hasPermission(this.trmtrainteacherMapping.toDomain(returnObject.body),'ehr-TRMTRAINTEACHER-Get')")
    @ApiOperation(value = "Get", tags = {"TRMTRAINTEACHER" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainteachers/{trmtrainteacher_id}")
    public ResponseEntity<TRMTRAINTEACHERDTO> get(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id) {
        TRMTRAINTEACHER domain = trmtrainteacherService.get(trmtrainteacher_id);
        TRMTRAINTEACHERDTO dto = trmtrainteacherMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKey", tags = {"TRMTRAINTEACHER" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMTRAINTEACHERDTO trmtrainteacherdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainteacherService.checkKey(trmtrainteacherMapping.toDomain(trmtrainteacherdto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainteacherMapping.toDomain(#trmtrainteacherdto),'ehr-TRMTRAINTEACHER-Save')")
    @ApiOperation(value = "Save", tags = {"TRMTRAINTEACHER" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMTRAINTEACHERDTO trmtrainteacherdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainteacherService.save(trmtrainteacherMapping.toDomain(trmtrainteacherdto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainteacherMapping.toDomain(#trmtrainteacherdtos),'ehr-TRMTRAINTEACHER-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"TRMTRAINTEACHER" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMTRAINTEACHERDTO> trmtrainteacherdtos) {
        trmtrainteacherService.saveBatch(trmtrainteacherMapping.toDomain(trmtrainteacherdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainteacherMapping.toDomain(#trmtrainteacherdto),'ehr-TRMTRAINTEACHER-Create')")
    @ApiOperation(value = "Create", tags = {"TRMTRAINTEACHER" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers")
    @Transactional
    public ResponseEntity<TRMTRAINTEACHERDTO> create(@RequestBody TRMTRAINTEACHERDTO trmtrainteacherdto) {
        TRMTRAINTEACHER domain = trmtrainteacherMapping.toDomain(trmtrainteacherdto);
		trmtrainteacherService.create(domain);
        TRMTRAINTEACHERDTO dto = trmtrainteacherMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainteacherMapping.toDomain(#trmtrainteacherdtos),'ehr-TRMTRAINTEACHER-Create')")
    @ApiOperation(value = "createBatch", tags = {"TRMTRAINTEACHER" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMTRAINTEACHERDTO> trmtrainteacherdtos) {
        trmtrainteacherService.createBatch(trmtrainteacherMapping.toDomain(trmtrainteacherdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINTEACHER-NBJS-all')")
	@ApiOperation(value = "fetch内部讲师", tags = {"TRMTRAINTEACHER" } ,notes = "fetch内部讲师")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainteachers/fetchnbjs")
	public ResponseEntity<List<TRMTRAINTEACHERDTO>> fetchNBJS(TRMTRAINTEACHERSearchContext context) {
        Page<TRMTRAINTEACHER> domains = trmtrainteacherService.searchNBJS(context) ;
        List<TRMTRAINTEACHERDTO> list = trmtrainteacherMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINTEACHER-NBJS-all')")
	@ApiOperation(value = "search内部讲师", tags = {"TRMTRAINTEACHER" } ,notes = "search内部讲师")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainteachers/searchnbjs")
	public ResponseEntity<Page<TRMTRAINTEACHERDTO>> searchNBJS(@RequestBody TRMTRAINTEACHERSearchContext context) {
        Page<TRMTRAINTEACHER> domains = trmtrainteacherService.searchNBJS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainteacherMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINTEACHER-WBJS-all')")
	@ApiOperation(value = "fetch外部讲师", tags = {"TRMTRAINTEACHER" } ,notes = "fetch外部讲师")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainteachers/fetchwbjs")
	public ResponseEntity<List<TRMTRAINTEACHERDTO>> fetchWBJS(TRMTRAINTEACHERSearchContext context) {
        Page<TRMTRAINTEACHER> domains = trmtrainteacherService.searchWBJS(context) ;
        List<TRMTRAINTEACHERDTO> list = trmtrainteacherMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINTEACHER-WBJS-all')")
	@ApiOperation(value = "search外部讲师", tags = {"TRMTRAINTEACHER" } ,notes = "search外部讲师")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainteachers/searchwbjs")
	public ResponseEntity<Page<TRMTRAINTEACHERDTO>> searchWBJS(@RequestBody TRMTRAINTEACHERSearchContext context) {
        Page<TRMTRAINTEACHER> domains = trmtrainteacherService.searchWBJS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainteacherMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINTEACHER-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TRMTRAINTEACHER" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainteachers/fetchdefault")
	public ResponseEntity<List<TRMTRAINTEACHERDTO>> fetchDefault(TRMTRAINTEACHERSearchContext context) {
        Page<TRMTRAINTEACHER> domains = trmtrainteacherService.searchDefault(context) ;
        List<TRMTRAINTEACHERDTO> list = trmtrainteacherMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINTEACHER-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TRMTRAINTEACHER" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainteachers/searchdefault")
	public ResponseEntity<Page<TRMTRAINTEACHERDTO>> searchDefault(@RequestBody TRMTRAINTEACHERSearchContext context) {
        Page<TRMTRAINTEACHER> domains = trmtrainteacherService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainteacherMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

