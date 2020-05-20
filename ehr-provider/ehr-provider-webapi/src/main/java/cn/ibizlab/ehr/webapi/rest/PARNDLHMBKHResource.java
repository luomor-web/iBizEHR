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
import cn.ibizlab.ehr.core.par.domain.PARNDLHMBKH;
import cn.ibizlab.ehr.core.par.service.IPARNDLHMBKHService;
import cn.ibizlab.ehr.core.par.filter.PARNDLHMBKHSearchContext;




@Slf4j
@Api(tags = {"PARNDLHMBKH" })
@RestController("WebApi-parndlhmbkh")
@RequestMapping("")
public class PARNDLHMBKHResource {

    @Autowired
    private IPARNDLHMBKHService parndlhmbkhService;

    @Autowired
    @Lazy
    private PARNDLHMBKHMapping parndlhmbkhMapping;




    @PreAuthorize("hasPermission(#parndlhmbkh_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PARNDLHMBKH" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parndlhmbkhs/{parndlhmbkh_id}")
    @Transactional
    public ResponseEntity<PARNDLHMBKHDTO> update(@PathVariable("parndlhmbkh_id") String parndlhmbkh_id, @RequestBody PARNDLHMBKHDTO parndlhmbkhdto) {
		PARNDLHMBKH domain = parndlhmbkhMapping.toDomain(parndlhmbkhdto);
        domain.setParndlhmbkhid(parndlhmbkh_id);
		parndlhmbkhService.update(domain);
		PARNDLHMBKHDTO dto = parndlhmbkhMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#parndlhmbkh_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PARNDLHMBKH" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parndlhmbkhs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARNDLHMBKHDTO> parndlhmbkhdtos) {
        parndlhmbkhService.updateBatch(parndlhmbkhMapping.toDomain(parndlhmbkhdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PARNDLHMBKH" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parndlhmbkhs/getdraft")
    public ResponseEntity<PARNDLHMBKHDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parndlhmbkhMapping.toDto(parndlhmbkhService.getDraft(new PARNDLHMBKH())));
    }




    @ApiOperation(value = "CheckKey", tags = {"PARNDLHMBKH" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parndlhmbkhs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARNDLHMBKHDTO parndlhmbkhdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parndlhmbkhService.checkKey(parndlhmbkhMapping.toDomain(parndlhmbkhdto)));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PARNDLHMBKH" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parndlhmbkhs")
    @Transactional
    public ResponseEntity<PARNDLHMBKHDTO> create(@RequestBody PARNDLHMBKHDTO parndlhmbkhdto) {
        PARNDLHMBKH domain = parndlhmbkhMapping.toDomain(parndlhmbkhdto);
		parndlhmbkhService.create(domain);
        PARNDLHMBKHDTO dto = parndlhmbkhMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PARNDLHMBKH" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parndlhmbkhs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARNDLHMBKHDTO> parndlhmbkhdtos) {
        parndlhmbkhService.createBatch(parndlhmbkhMapping.toDomain(parndlhmbkhdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#parndlhmbkh_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"PARNDLHMBKH" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parndlhmbkhs/{parndlhmbkh_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parndlhmbkh_id") String parndlhmbkh_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parndlhmbkhService.remove(parndlhmbkh_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PARNDLHMBKH" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parndlhmbkhs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parndlhmbkhService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"PARNDLHMBKH" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parndlhmbkhs/save")
    public ResponseEntity<Boolean> save(@RequestBody PARNDLHMBKHDTO parndlhmbkhdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parndlhmbkhService.save(parndlhmbkhMapping.toDomain(parndlhmbkhdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PARNDLHMBKH" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parndlhmbkhs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARNDLHMBKHDTO> parndlhmbkhdtos) {
        parndlhmbkhService.saveBatch(parndlhmbkhMapping.toDomain(parndlhmbkhdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#parndlhmbkh_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PARNDLHMBKH" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parndlhmbkhs/{parndlhmbkh_id}")
    public ResponseEntity<PARNDLHMBKHDTO> get(@PathVariable("parndlhmbkh_id") String parndlhmbkh_id) {
        PARNDLHMBKH domain = parndlhmbkhService.get(parndlhmbkh_id);
        PARNDLHMBKHDTO dto = parndlhmbkhMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARNDLHMBKH-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PARNDLHMBKH" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parndlhmbkhs/fetchdefault")
	public ResponseEntity<List<PARNDLHMBKHDTO>> fetchDefault(PARNDLHMBKHSearchContext context) {
        Page<PARNDLHMBKH> domains = parndlhmbkhService.searchDefault(context) ;
        List<PARNDLHMBKHDTO> list = parndlhmbkhMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARNDLHMBKH-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PARNDLHMBKH" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parndlhmbkhs/searchdefault")
	public ResponseEntity<Page<PARNDLHMBKHDTO>> searchDefault(@RequestBody PARNDLHMBKHSearchContext context) {
        Page<PARNDLHMBKH> domains = parndlhmbkhService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parndlhmbkhMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PARNDLHMBKH getEntity(){
        return new PARNDLHMBKH();
    }

}
