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
import cn.ibizlab.ehr.core.trm.domain.TRMTRAINCOURSE;
import cn.ibizlab.ehr.core.trm.service.ITRMTRAINCOURSEService;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINCOURSESearchContext;

@Slf4j
@Api(tags = {"TRMTRAINCOURSE" })
@RestController("WebApi-trmtraincourse")
@RequestMapping("")
public class TRMTRAINCOURSEResource {

    @Autowired
    public ITRMTRAINCOURSEService trmtraincourseService;

    @Autowired
    @Lazy
    public TRMTRAINCOURSEMapping trmtraincourseMapping;

    @PostAuthorize("hasPermission(this.trmtraincourseMapping.toDomain(returnObject.body),'ehr-TRMTRAINCOURSE-Get')")
    @ApiOperation(value = "Get", tags = {"TRMTRAINCOURSE" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtraincourses/{trmtraincourse_id}")
    public ResponseEntity<TRMTRAINCOURSEDTO> get(@PathVariable("trmtraincourse_id") String trmtraincourse_id) {
        TRMTRAINCOURSE domain = trmtraincourseService.get(trmtraincourse_id);
        TRMTRAINCOURSEDTO dto = trmtraincourseMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKey", tags = {"TRMTRAINCOURSE" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraincourses/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMTRAINCOURSEDTO trmtraincoursedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtraincourseService.checkKey(trmtraincourseMapping.toDomain(trmtraincoursedto)));
    }

    @PreAuthorize("hasPermission(this.trmtraincourseService.get(#trmtraincourse_id),'ehr-TRMTRAINCOURSE-Remove')")
    @ApiOperation(value = "Remove", tags = {"TRMTRAINCOURSE" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtraincourses/{trmtraincourse_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtraincourse_id") String trmtraincourse_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtraincourseService.remove(trmtraincourse_id));
    }

    @PreAuthorize("hasPermission(this.trmtraincourseService.getTrmtraincourseByIds(#ids),'ehr-TRMTRAINCOURSE-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"TRMTRAINCOURSE" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtraincourses/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtraincourseService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"TRMTRAINCOURSE" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtraincourses/getdraft")
    public ResponseEntity<TRMTRAINCOURSEDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtraincourseMapping.toDto(trmtraincourseService.getDraft(new TRMTRAINCOURSE())));
    }

    @PreAuthorize("hasPermission(this.trmtraincourseMapping.toDomain(#trmtraincoursedto),'ehr-TRMTRAINCOURSE-Create')")
    @ApiOperation(value = "Create", tags = {"TRMTRAINCOURSE" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraincourses")
    @Transactional
    public ResponseEntity<TRMTRAINCOURSEDTO> create(@RequestBody TRMTRAINCOURSEDTO trmtraincoursedto) {
        TRMTRAINCOURSE domain = trmtraincourseMapping.toDomain(trmtraincoursedto);
		trmtraincourseService.create(domain);
        TRMTRAINCOURSEDTO dto = trmtraincourseMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtraincourseMapping.toDomain(#trmtraincoursedtos),'ehr-TRMTRAINCOURSE-Create')")
    @ApiOperation(value = "createBatch", tags = {"TRMTRAINCOURSE" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraincourses/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMTRAINCOURSEDTO> trmtraincoursedtos) {
        trmtraincourseService.createBatch(trmtraincourseMapping.toDomain(trmtraincoursedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtraincourseService.get(#trmtraincourse_id),'ehr-TRMTRAINCOURSE-Update')")
    @ApiOperation(value = "Update", tags = {"TRMTRAINCOURSE" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtraincourses/{trmtraincourse_id}")
    @Transactional
    public ResponseEntity<TRMTRAINCOURSEDTO> update(@PathVariable("trmtraincourse_id") String trmtraincourse_id, @RequestBody TRMTRAINCOURSEDTO trmtraincoursedto) {
		TRMTRAINCOURSE domain  = trmtraincourseMapping.toDomain(trmtraincoursedto);
        domain .setTrmtraincourseid(trmtraincourse_id);
		trmtraincourseService.update(domain );
		TRMTRAINCOURSEDTO dto = trmtraincourseMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtraincourseService.getTrmtraincourseByEntities(this.trmtraincourseMapping.toDomain(#trmtraincoursedtos)),'ehr-TRMTRAINCOURSE-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"TRMTRAINCOURSE" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtraincourses/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMTRAINCOURSEDTO> trmtraincoursedtos) {
        trmtraincourseService.updateBatch(trmtraincourseMapping.toDomain(trmtraincoursedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtraincourseMapping.toDomain(#trmtraincoursedto),'ehr-TRMTRAINCOURSE-Save')")
    @ApiOperation(value = "Save", tags = {"TRMTRAINCOURSE" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraincourses/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMTRAINCOURSEDTO trmtraincoursedto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtraincourseService.save(trmtraincourseMapping.toDomain(trmtraincoursedto)));
    }

    @PreAuthorize("hasPermission(this.trmtraincourseMapping.toDomain(#trmtraincoursedtos),'ehr-TRMTRAINCOURSE-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"TRMTRAINCOURSE" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraincourses/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMTRAINCOURSEDTO> trmtraincoursedtos) {
        trmtraincourseService.saveBatch(trmtraincourseMapping.toDomain(trmtraincoursedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINCOURSE-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TRMTRAINCOURSE" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtraincourses/fetchdefault")
	public ResponseEntity<List<TRMTRAINCOURSEDTO>> fetchDefault(TRMTRAINCOURSESearchContext context) {
        Page<TRMTRAINCOURSE> domains = trmtraincourseService.searchDefault(context) ;
        List<TRMTRAINCOURSEDTO> list = trmtraincourseMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TRMTRAINCOURSE-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TRMTRAINCOURSE" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtraincourses/searchdefault")
	public ResponseEntity<Page<TRMTRAINCOURSEDTO>> searchDefault(@RequestBody TRMTRAINCOURSESearchContext context) {
        Page<TRMTRAINCOURSE> domains = trmtraincourseService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtraincourseMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

