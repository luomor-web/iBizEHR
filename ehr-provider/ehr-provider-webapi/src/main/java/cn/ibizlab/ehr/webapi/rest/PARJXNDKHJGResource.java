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
import cn.ibizlab.ehr.core.par.domain.PARJXNDKHJG;
import cn.ibizlab.ehr.core.par.service.IPARJXNDKHJGService;
import cn.ibizlab.ehr.core.par.filter.PARJXNDKHJGSearchContext;




@Slf4j
@Api(tags = {"PARJXNDKHJG" })
@RestController("WebApi-parjxndkhjg")
@RequestMapping("")
public class PARJXNDKHJGResource {

    @Autowired
    private IPARJXNDKHJGService parjxndkhjgService;

    @Autowired
    @Lazy
    private PARJXNDKHJGMapping parjxndkhjgMapping;




    @ApiOperation(value = "Save", tags = {"PARJXNDKHJG" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxndkhjgs/save")
    public ResponseEntity<Boolean> save(@RequestBody PARJXNDKHJGDTO parjxndkhjgdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parjxndkhjgService.save(parjxndkhjgMapping.toDomain(parjxndkhjgdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PARJXNDKHJG" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxndkhjgs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARJXNDKHJGDTO> parjxndkhjgdtos) {
        parjxndkhjgService.saveBatch(parjxndkhjgMapping.toDomain(parjxndkhjgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#parjxndkhjg_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PARJXNDKHJG" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxndkhjgs/{parjxndkhjg_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parjxndkhjg_id") String parjxndkhjg_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parjxndkhjgService.remove(parjxndkhjg_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PARJXNDKHJG" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxndkhjgs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parjxndkhjgService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PARJXNDKHJG" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxndkhjgs/getdraft")
    public ResponseEntity<PARJXNDKHJGDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parjxndkhjgMapping.toDto(parjxndkhjgService.getDraft(new PARJXNDKHJG())));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PARJXNDKHJG" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxndkhjgs")
    @Transactional
    public ResponseEntity<PARJXNDKHJGDTO> create(@RequestBody PARJXNDKHJGDTO parjxndkhjgdto) {
        PARJXNDKHJG domain = parjxndkhjgMapping.toDomain(parjxndkhjgdto);
		parjxndkhjgService.create(domain);
        PARJXNDKHJGDTO dto = parjxndkhjgMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PARJXNDKHJG" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxndkhjgs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARJXNDKHJGDTO> parjxndkhjgdtos) {
        parjxndkhjgService.createBatch(parjxndkhjgMapping.toDomain(parjxndkhjgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#parjxndkhjg_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PARJXNDKHJG" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxndkhjgs/{parjxndkhjg_id}")
    @Transactional
    public ResponseEntity<PARJXNDKHJGDTO> update(@PathVariable("parjxndkhjg_id") String parjxndkhjg_id, @RequestBody PARJXNDKHJGDTO parjxndkhjgdto) {
		PARJXNDKHJG domain = parjxndkhjgMapping.toDomain(parjxndkhjgdto);
        domain.setParjxndkhjgid(parjxndkhjg_id);
		parjxndkhjgService.update(domain);
		PARJXNDKHJGDTO dto = parjxndkhjgMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#parjxndkhjg_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PARJXNDKHJG" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxndkhjgs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARJXNDKHJGDTO> parjxndkhjgdtos) {
        parjxndkhjgService.updateBatch(parjxndkhjgMapping.toDomain(parjxndkhjgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#parjxndkhjg_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PARJXNDKHJG" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxndkhjgs/{parjxndkhjg_id}")
    public ResponseEntity<PARJXNDKHJGDTO> get(@PathVariable("parjxndkhjg_id") String parjxndkhjg_id) {
        PARJXNDKHJG domain = parjxndkhjgService.get(parjxndkhjg_id);
        PARJXNDKHJGDTO dto = parjxndkhjgMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "CheckKey", tags = {"PARJXNDKHJG" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxndkhjgs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARJXNDKHJGDTO parjxndkhjgdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parjxndkhjgService.checkKey(parjxndkhjgMapping.toDomain(parjxndkhjgdto)));
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PARJXNDKHJG" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parjxndkhjgs/fetchdefault")
	public ResponseEntity<List<PARJXNDKHJGDTO>> fetchDefault(PARJXNDKHJGSearchContext context) {
        Page<PARJXNDKHJG> domains = parjxndkhjgService.searchDefault(context) ;
        List<PARJXNDKHJGDTO> list = parjxndkhjgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"PARJXNDKHJG" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parjxndkhjgs/searchdefault")
	public ResponseEntity<Page<PARJXNDKHJGDTO>> searchDefault(PARJXNDKHJGSearchContext context) {
        Page<PARJXNDKHJG> domains = parjxndkhjgService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjxndkhjgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'LastTwoYear',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch最近2年下半年考核成绩", tags = {"PARJXNDKHJG" } ,notes = "fetch最近2年下半年考核成绩")
    @RequestMapping(method= RequestMethod.GET , value="/parjxndkhjgs/fetchlasttwoyear")
	public ResponseEntity<List<PARJXNDKHJGDTO>> fetchLastTwoYear(PARJXNDKHJGSearchContext context) {
        Page<PARJXNDKHJG> domains = parjxndkhjgService.searchLastTwoYear(context) ;
        List<PARJXNDKHJGDTO> list = parjxndkhjgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'LastTwoYear',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search最近2年下半年考核成绩", tags = {"PARJXNDKHJG" } ,notes = "search最近2年下半年考核成绩")
    @RequestMapping(method= RequestMethod.GET , value="/parjxndkhjgs/searchlasttwoyear")
	public ResponseEntity<Page<PARJXNDKHJGDTO>> searchLastTwoYear(PARJXNDKHJGSearchContext context) {
        Page<PARJXNDKHJG> domains = parjxndkhjgService.searchLastTwoYear(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjxndkhjgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PARJXNDKHJG getEntity(){
        return new PARJXNDKHJG();
    }

}
