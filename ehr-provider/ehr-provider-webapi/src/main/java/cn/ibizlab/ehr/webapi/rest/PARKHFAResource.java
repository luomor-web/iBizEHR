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
import cn.ibizlab.ehr.core.par.domain.PARKHFA;
import cn.ibizlab.ehr.core.par.service.IPARKHFAService;
import cn.ibizlab.ehr.core.par.filter.PARKHFASearchContext;




@Slf4j
@Api(tags = {"PARKHFA" })
@RestController("WebApi-parkhfa")
@RequestMapping("")
public class PARKHFAResource {

    @Autowired
    private IPARKHFAService parkhfaService;

    @Autowired
    @Lazy
    private PARKHFAMapping parkhfaMapping;




    @PreAuthorize("hasPermission(#parkhfa_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"PARKHFA" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parkhfas/{parkhfa_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parkhfa_id") String parkhfa_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parkhfaService.remove(parkhfa_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PARKHFA" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parkhfas/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parkhfaService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"PARKHFA" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parkhfas/save")
    public ResponseEntity<Boolean> save(@RequestBody PARKHFADTO parkhfadto) {
        return ResponseEntity.status(HttpStatus.OK).body(parkhfaService.save(parkhfaMapping.toDomain(parkhfadto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PARKHFA" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parkhfas/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARKHFADTO> parkhfadtos) {
        parkhfaService.saveBatch(parkhfaMapping.toDomain(parkhfadtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PARKHFA" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parkhfas")
    @Transactional
    public ResponseEntity<PARKHFADTO> create(@RequestBody PARKHFADTO parkhfadto) {
        PARKHFA domain = parkhfaMapping.toDomain(parkhfadto);
		parkhfaService.create(domain);
        PARKHFADTO dto = parkhfaMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PARKHFA" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parkhfas/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARKHFADTO> parkhfadtos) {
        parkhfaService.createBatch(parkhfaMapping.toDomain(parkhfadtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"PARKHFA" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parkhfas/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARKHFADTO parkhfadto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parkhfaService.checkKey(parkhfaMapping.toDomain(parkhfadto)));
    }




    @ApiOperation(value = "GetDraft", tags = {"PARKHFA" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parkhfas/getdraft")
    public ResponseEntity<PARKHFADTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parkhfaMapping.toDto(parkhfaService.getDraft(new PARKHFA())));
    }




    @PreAuthorize("hasPermission(#parkhfa_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PARKHFA" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parkhfas/{parkhfa_id}")
    public ResponseEntity<PARKHFADTO> get(@PathVariable("parkhfa_id") String parkhfa_id) {
        PARKHFA domain = parkhfaService.get(parkhfa_id);
        PARKHFADTO dto = parkhfaMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#parkhfa_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PARKHFA" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parkhfas/{parkhfa_id}")
    @Transactional
    public ResponseEntity<PARKHFADTO> update(@PathVariable("parkhfa_id") String parkhfa_id, @RequestBody PARKHFADTO parkhfadto) {
		PARKHFA domain = parkhfaMapping.toDomain(parkhfadto);
        domain.setParkhfaid(parkhfa_id);
		parkhfaService.update(domain);
		PARKHFADTO dto = parkhfaMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#parkhfa_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PARKHFA" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parkhfas/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARKHFADTO> parkhfadtos) {
        parkhfaService.updateBatch(parkhfaMapping.toDomain(parkhfadtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARKHFA-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PARKHFA" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parkhfas/fetchdefault")
	public ResponseEntity<List<PARKHFADTO>> fetchDefault(PARKHFASearchContext context) {
        Page<PARKHFA> domains = parkhfaService.searchDefault(context) ;
        List<PARKHFADTO> list = parkhfaMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARKHFA-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PARKHFA" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parkhfas/searchdefault")
	public ResponseEntity<Page<PARKHFADTO>> searchDefault(@RequestBody PARKHFASearchContext context) {
        Page<PARKHFA> domains = parkhfaService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parkhfaMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PARKHFA getEntity(){
        return new PARKHFA();
    }

}
