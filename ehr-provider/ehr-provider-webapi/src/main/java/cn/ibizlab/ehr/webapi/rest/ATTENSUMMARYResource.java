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
import cn.ibizlab.ehr.core.att.domain.ATTENSUMMARY;
import cn.ibizlab.ehr.core.att.service.IATTENSUMMARYService;
import cn.ibizlab.ehr.core.att.filter.ATTENSUMMARYSearchContext;




@Slf4j
@Api(tags = {"ATTENSUMMARY" })
@RestController("WebApi-attensummary")
@RequestMapping("")
public class ATTENSUMMARYResource {

    @Autowired
    private IATTENSUMMARYService attensummaryService;

    @Autowired
    @Lazy
    private ATTENSUMMARYMapping attensummaryMapping;




    @ApiOperation(value = "GetDraft", tags = {"ATTENSUMMARY" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/attensummaries/getdraft")
    public ResponseEntity<ATTENSUMMARYDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(attensummaryMapping.toDto(attensummaryService.getDraft(new ATTENSUMMARY())));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"ATTENSUMMARY" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/attensummaries")
    @Transactional
    public ResponseEntity<ATTENSUMMARYDTO> create(@RequestBody ATTENSUMMARYDTO attensummarydto) {
        ATTENSUMMARY domain = attensummaryMapping.toDomain(attensummarydto);
		attensummaryService.create(domain);
        ATTENSUMMARYDTO dto = attensummaryMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"ATTENSUMMARY" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/attensummaries/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ATTENSUMMARYDTO> attensummarydtos) {
        attensummaryService.createBatch(attensummaryMapping.toDomain(attensummarydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#attensummary_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"ATTENSUMMARY" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attensummaries/{attensummary_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("attensummary_id") String attensummary_id) {
         return ResponseEntity.status(HttpStatus.OK).body(attensummaryService.remove(attensummary_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"ATTENSUMMARY" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attensummaries/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        attensummaryService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#attensummary_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"ATTENSUMMARY" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/attensummaries/{attensummary_id}")
    @Transactional
    public ResponseEntity<ATTENSUMMARYDTO> update(@PathVariable("attensummary_id") String attensummary_id, @RequestBody ATTENSUMMARYDTO attensummarydto) {
		ATTENSUMMARY domain = attensummaryMapping.toDomain(attensummarydto);
        domain.setAttensummaryid(attensummary_id);
		attensummaryService.update(domain);
		ATTENSUMMARYDTO dto = attensummaryMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#attensummary_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"ATTENSUMMARY" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/attensummaries/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ATTENSUMMARYDTO> attensummarydtos) {
        attensummaryService.updateBatch(attensummaryMapping.toDomain(attensummarydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#attensummary_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"ATTENSUMMARY" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/attensummaries/{attensummary_id}")
    public ResponseEntity<ATTENSUMMARYDTO> get(@PathVariable("attensummary_id") String attensummary_id) {
        ATTENSUMMARY domain = attensummaryService.get(attensummary_id);
        ATTENSUMMARYDTO dto = attensummaryMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "Save", tags = {"ATTENSUMMARY" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/attensummaries/save")
    public ResponseEntity<Boolean> save(@RequestBody ATTENSUMMARYDTO attensummarydto) {
        return ResponseEntity.status(HttpStatus.OK).body(attensummaryService.save(attensummaryMapping.toDomain(attensummarydto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"ATTENSUMMARY" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/attensummaries/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ATTENSUMMARYDTO> attensummarydtos) {
        attensummaryService.saveBatch(attensummaryMapping.toDomain(attensummarydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"ATTENSUMMARY" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/attensummaries/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ATTENSUMMARYDTO attensummarydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(attensummaryService.checkKey(attensummaryMapping.toDomain(attensummarydto)));
    }




    @ApiOperation(value = "导出考勤汇总", tags = {"ATTENSUMMARY" },  notes = "导出考勤汇总")
	@RequestMapping(method = RequestMethod.POST, value = "/attensummaries/{attensummary_id}/exportkqhz")
    @Transactional
    public ResponseEntity<ATTENSUMMARYDTO> exportKQHZ(@PathVariable("attensummary_id") String attensummary_id, @RequestBody ATTENSUMMARYDTO attensummarydto) {
        ATTENSUMMARY attensummary = attensummaryMapping.toDomain(attensummarydto);
        attensummary = attensummaryService.exportKQHZ(attensummary);
        attensummarydto = attensummaryMapping.toDto(attensummary);
        return ResponseEntity.status(HttpStatus.OK).body(attensummarydto);
    }

	@ApiOperation(value = "fetch当前组织考勤汇总", tags = {"ATTENSUMMARY" } ,notes = "fetch当前组织考勤汇总")
    @RequestMapping(method= RequestMethod.GET , value="/attensummaries/fetchcurzzkqhz")
	public ResponseEntity<List<ATTENSUMMARYDTO>> fetchCurZZKQHZ(ATTENSUMMARYSearchContext context) {
        Page<ATTENSUMMARY> domains = attensummaryService.searchCurZZKQHZ(context) ;
        List<ATTENSUMMARYDTO> list = attensummaryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search当前组织考勤汇总", tags = {"ATTENSUMMARY" } ,notes = "search当前组织考勤汇总")
    @RequestMapping(method= RequestMethod.POST , value="/attensummaries/searchcurzzkqhz")
	public ResponseEntity<Page<ATTENSUMMARYDTO>> searchCurZZKQHZ(@RequestBody ATTENSUMMARYSearchContext context) {
        Page<ATTENSUMMARY> domains = attensummaryService.searchCurZZKQHZ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attensummaryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetchDEFAULT", tags = {"ATTENSUMMARY" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/attensummaries/fetchdefault")
	public ResponseEntity<List<ATTENSUMMARYDTO>> fetchDefault(ATTENSUMMARYSearchContext context) {
        Page<ATTENSUMMARY> domains = attensummaryService.searchDefault(context) ;
        List<ATTENSUMMARYDTO> list = attensummaryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"ATTENSUMMARY" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/attensummaries/searchdefault")
	public ResponseEntity<Page<ATTENSUMMARYDTO>> searchDefault(@RequestBody ATTENSUMMARYSearchContext context) {
        Page<ATTENSUMMARY> domains = attensummaryService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attensummaryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public ATTENSUMMARY getEntity(){
        return new ATTENSUMMARY();
    }

}
