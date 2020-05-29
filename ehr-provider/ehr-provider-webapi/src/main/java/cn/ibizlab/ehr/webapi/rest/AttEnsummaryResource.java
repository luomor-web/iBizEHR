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
import cn.ibizlab.ehr.core.att.domain.AttEnsummary;
import cn.ibizlab.ehr.core.att.service.IAttEnsummaryService;
import cn.ibizlab.ehr.core.att.filter.AttEnsummarySearchContext;

@Slf4j
@Api(tags = {"AttEnsummary" })
@RestController("WebApi-attensummary")
@RequestMapping("")
public class AttEnsummaryResource {

    @Autowired
    public IAttEnsummaryService attensummaryService;

    @Autowired
    @Lazy
    public AttEnsummaryMapping attensummaryMapping;

    @ApiOperation(value = "GetDraft", tags = {"AttEnsummary" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/attensummaries/getdraft")
    public ResponseEntity<AttEnsummaryDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(attensummaryMapping.toDto(attensummaryService.getDraft(new AttEnsummary())));
    }

    @PreAuthorize("hasPermission(this.attensummaryMapping.toDomain(#attensummarydto),'ehr-AttEnsummary-Create')")
    @ApiOperation(value = "Create", tags = {"AttEnsummary" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/attensummaries")
    @Transactional
    public ResponseEntity<AttEnsummaryDTO> create(@RequestBody AttEnsummaryDTO attensummarydto) {
        AttEnsummary domain = attensummaryMapping.toDomain(attensummarydto);
		attensummaryService.create(domain);
        AttEnsummaryDTO dto = attensummaryMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attensummaryMapping.toDomain(#attensummarydtos),'ehr-AttEnsummary-Create')")
    @ApiOperation(value = "createBatch", tags = {"AttEnsummary" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/attensummaries/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<AttEnsummaryDTO> attensummarydtos) {
        attensummaryService.createBatch(attensummaryMapping.toDomain(attensummarydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attensummaryService.get(#attensummary_id),'ehr-AttEnsummary-Remove')")
    @ApiOperation(value = "Remove", tags = {"AttEnsummary" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attensummaries/{attensummary_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("attensummary_id") String attensummary_id) {
         return ResponseEntity.status(HttpStatus.OK).body(attensummaryService.remove(attensummary_id));
    }

    @PreAuthorize("hasPermission(this.attensummaryService.getAttensummaryByIds(#ids),'ehr-AttEnsummary-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"AttEnsummary" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attensummaries/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        attensummaryService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attensummaryService.get(#attensummary_id),'ehr-AttEnsummary-Update')")
    @ApiOperation(value = "Update", tags = {"AttEnsummary" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/attensummaries/{attensummary_id}")
    @Transactional
    public ResponseEntity<AttEnsummaryDTO> update(@PathVariable("attensummary_id") String attensummary_id, @RequestBody AttEnsummaryDTO attensummarydto) {
		AttEnsummary domain  = attensummaryMapping.toDomain(attensummarydto);
        domain .setAttensummaryid(attensummary_id);
		attensummaryService.update(domain );
		AttEnsummaryDTO dto = attensummaryMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attensummaryService.getAttensummaryByEntities(this.attensummaryMapping.toDomain(#attensummarydtos)),'ehr-AttEnsummary-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"AttEnsummary" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/attensummaries/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<AttEnsummaryDTO> attensummarydtos) {
        attensummaryService.updateBatch(attensummaryMapping.toDomain(attensummarydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.attensummaryMapping.toDomain(returnObject.body),'ehr-AttEnsummary-Get')")
    @ApiOperation(value = "Get", tags = {"AttEnsummary" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/attensummaries/{attensummary_id}")
    public ResponseEntity<AttEnsummaryDTO> get(@PathVariable("attensummary_id") String attensummary_id) {
        AttEnsummary domain = attensummaryService.get(attensummary_id);
        AttEnsummaryDTO dto = attensummaryMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attensummaryMapping.toDomain(#attensummarydto),'ehr-AttEnsummary-Save')")
    @ApiOperation(value = "Save", tags = {"AttEnsummary" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/attensummaries/save")
    public ResponseEntity<Boolean> save(@RequestBody AttEnsummaryDTO attensummarydto) {
        return ResponseEntity.status(HttpStatus.OK).body(attensummaryService.save(attensummaryMapping.toDomain(attensummarydto)));
    }

    @PreAuthorize("hasPermission(this.attensummaryMapping.toDomain(#attensummarydtos),'ehr-AttEnsummary-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"AttEnsummary" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/attensummaries/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<AttEnsummaryDTO> attensummarydtos) {
        attensummaryService.saveBatch(attensummaryMapping.toDomain(attensummarydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"AttEnsummary" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/attensummaries/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody AttEnsummaryDTO attensummarydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(attensummaryService.checkKey(attensummaryMapping.toDomain(attensummarydto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEnsummary-ExportKQHZ-all')")
    @ApiOperation(value = "导出考勤汇总", tags = {"AttEnsummary" },  notes = "导出考勤汇总")
	@RequestMapping(method = RequestMethod.POST, value = "/attensummaries/{attensummary_id}/exportkqhz")
    @Transactional
    public ResponseEntity<AttEnsummaryDTO> exportKQHZ(@PathVariable("attensummary_id") String attensummary_id, @RequestBody AttEnsummaryDTO attensummarydto) {
        AttEnsummary attensummary = attensummaryMapping.toDomain(attensummarydto);
        attensummary.setAttensummaryid(attensummary_id);
        attensummary = attensummaryService.exportKQHZ(attensummary);
        attensummarydto = attensummaryMapping.toDto(attensummary);
        return ResponseEntity.status(HttpStatus.OK).body(attensummarydto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEnsummary-CurZZKQHZ-all')")
	@ApiOperation(value = "fetch当前组织考勤汇总", tags = {"AttEnsummary" } ,notes = "fetch当前组织考勤汇总")
    @RequestMapping(method= RequestMethod.GET , value="/attensummaries/fetchcurzzkqhz")
	public ResponseEntity<List<AttEnsummaryDTO>> fetchCurZZKQHZ(AttEnsummarySearchContext context) {
        Page<AttEnsummary> domains = attensummaryService.searchCurZZKQHZ(context) ;
        List<AttEnsummaryDTO> list = attensummaryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEnsummary-CurZZKQHZ-all')")
	@ApiOperation(value = "search当前组织考勤汇总", tags = {"AttEnsummary" } ,notes = "search当前组织考勤汇总")
    @RequestMapping(method= RequestMethod.POST , value="/attensummaries/searchcurzzkqhz")
	public ResponseEntity<Page<AttEnsummaryDTO>> searchCurZZKQHZ(@RequestBody AttEnsummarySearchContext context) {
        Page<AttEnsummary> domains = attensummaryService.searchCurZZKQHZ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attensummaryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEnsummary-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"AttEnsummary" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/attensummaries/fetchdefault")
	public ResponseEntity<List<AttEnsummaryDTO>> fetchDefault(AttEnsummarySearchContext context) {
        Page<AttEnsummary> domains = attensummaryService.searchDefault(context) ;
        List<AttEnsummaryDTO> list = attensummaryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEnsummary-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"AttEnsummary" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/attensummaries/searchdefault")
	public ResponseEntity<Page<AttEnsummaryDTO>> searchDefault(@RequestBody AttEnsummarySearchContext context) {
        Page<AttEnsummary> domains = attensummaryService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attensummaryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

