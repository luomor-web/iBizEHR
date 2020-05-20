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
import cn.ibizlab.ehr.core.par.domain.PARJZSZPSJG;
import cn.ibizlab.ehr.core.par.service.IPARJZSZPSJGService;
import cn.ibizlab.ehr.core.par.filter.PARJZSZPSJGSearchContext;




@Slf4j
@Api(tags = {"PARJZSZPSJG" })
@RestController("WebApi-parjzszpsjg")
@RequestMapping("")
public class PARJZSZPSJGResource {

    @Autowired
    private IPARJZSZPSJGService parjzszpsjgService;

    @Autowired
    @Lazy
    private PARJZSZPSJGMapping parjzszpsjgMapping;




    @PreAuthorize("hasPermission(#parjzszpsjg_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PARJZSZPSJG" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parjzszpsjgs/{parjzszpsjg_id}")
    public ResponseEntity<PARJZSZPSJGDTO> get(@PathVariable("parjzszpsjg_id") String parjzszpsjg_id) {
        PARJZSZPSJG domain = parjzszpsjgService.get(parjzszpsjg_id);
        PARJZSZPSJGDTO dto = parjzszpsjgMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#parjzszpsjg_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PARJZSZPSJG" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjzszpsjgs/{parjzszpsjg_id}")
    @Transactional
    public ResponseEntity<PARJZSZPSJGDTO> update(@PathVariable("parjzszpsjg_id") String parjzszpsjg_id, @RequestBody PARJZSZPSJGDTO parjzszpsjgdto) {
		PARJZSZPSJG domain = parjzszpsjgMapping.toDomain(parjzszpsjgdto);
        domain.setParjzszpsjgid(parjzszpsjg_id);
		parjzszpsjgService.update(domain);
		PARJZSZPSJGDTO dto = parjzszpsjgMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#parjzszpsjg_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PARJZSZPSJG" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjzszpsjgs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARJZSZPSJGDTO> parjzszpsjgdtos) {
        parjzszpsjgService.updateBatch(parjzszpsjgMapping.toDomain(parjzszpsjgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"PARJZSZPSJG" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parjzszpsjgs/save")
    public ResponseEntity<Boolean> save(@RequestBody PARJZSZPSJGDTO parjzszpsjgdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parjzszpsjgService.save(parjzszpsjgMapping.toDomain(parjzszpsjgdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PARJZSZPSJG" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjzszpsjgs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARJZSZPSJGDTO> parjzszpsjgdtos) {
        parjzszpsjgService.saveBatch(parjzszpsjgMapping.toDomain(parjzszpsjgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"PARJZSZPSJG" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parjzszpsjgs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARJZSZPSJGDTO parjzszpsjgdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parjzszpsjgService.checkKey(parjzszpsjgMapping.toDomain(parjzszpsjgdto)));
    }




    @PreAuthorize("hasPermission(#parjzszpsjg_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"PARJZSZPSJG" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjzszpsjgs/{parjzszpsjg_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parjzszpsjg_id") String parjzszpsjg_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parjzszpsjgService.remove(parjzszpsjg_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PARJZSZPSJG" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjzszpsjgs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parjzszpsjgService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PARJZSZPSJG" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parjzszpsjgs/getdraft")
    public ResponseEntity<PARJZSZPSJGDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parjzszpsjgMapping.toDto(parjzszpsjgService.getDraft(new PARJZSZPSJG())));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PARJZSZPSJG" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parjzszpsjgs")
    @Transactional
    public ResponseEntity<PARJZSZPSJGDTO> create(@RequestBody PARJZSZPSJGDTO parjzszpsjgdto) {
        PARJZSZPSJG domain = parjzszpsjgMapping.toDomain(parjzszpsjgdto);
		parjzszpsjgService.create(domain);
        PARJZSZPSJGDTO dto = parjzszpsjgMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PARJZSZPSJG" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjzszpsjgs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARJZSZPSJGDTO> parjzszpsjgdtos) {
        parjzszpsjgService.createBatch(parjzszpsjgMapping.toDomain(parjzszpsjgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJZSZPSJG-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PARJZSZPSJG" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parjzszpsjgs/fetchdefault")
	public ResponseEntity<List<PARJZSZPSJGDTO>> fetchDefault(PARJZSZPSJGSearchContext context) {
        Page<PARJZSZPSJG> domains = parjzszpsjgService.searchDefault(context) ;
        List<PARJZSZPSJGDTO> list = parjzszpsjgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJZSZPSJG-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PARJZSZPSJG" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parjzszpsjgs/searchdefault")
	public ResponseEntity<Page<PARJZSZPSJGDTO>> searchDefault(@RequestBody PARJZSZPSJGSearchContext context) {
        Page<PARJZSZPSJG> domains = parjzszpsjgService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjzszpsjgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PARJZSZPSJG getEntity(){
        return new PARJZSZPSJG();
    }

}
