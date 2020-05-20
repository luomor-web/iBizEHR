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
import cn.ibizlab.ehr.core.par.domain.PARYDGZJH;
import cn.ibizlab.ehr.core.par.service.IPARYDGZJHService;
import cn.ibizlab.ehr.core.par.filter.PARYDGZJHSearchContext;




@Slf4j
@Api(tags = {"PARYDGZJH" })
@RestController("WebApi-parydgzjh")
@RequestMapping("")
public class PARYDGZJHResource {

    @Autowired
    private IPARYDGZJHService parydgzjhService;

    @Autowired
    @Lazy
    private PARYDGZJHMapping parydgzjhMapping;




    @ApiOperation(value = "GetDraft", tags = {"PARYDGZJH" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parydgzjhs/getdraft")
    public ResponseEntity<PARYDGZJHDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parydgzjhMapping.toDto(parydgzjhService.getDraft(new PARYDGZJH())));
    }




    @PreAuthorize("hasPermission(#parydgzjh_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PARYDGZJH" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parydgzjhs/{parydgzjh_id}")
    @Transactional
    public ResponseEntity<PARYDGZJHDTO> update(@PathVariable("parydgzjh_id") String parydgzjh_id, @RequestBody PARYDGZJHDTO parydgzjhdto) {
		PARYDGZJH domain = parydgzjhMapping.toDomain(parydgzjhdto);
        domain.setParydgzjhid(parydgzjh_id);
		parydgzjhService.update(domain);
		PARYDGZJHDTO dto = parydgzjhMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#parydgzjh_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PARYDGZJH" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parydgzjhs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARYDGZJHDTO> parydgzjhdtos) {
        parydgzjhService.updateBatch(parydgzjhMapping.toDomain(parydgzjhdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"PARYDGZJH" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parydgzjhs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARYDGZJHDTO parydgzjhdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parydgzjhService.checkKey(parydgzjhMapping.toDomain(parydgzjhdto)));
    }




    @ApiOperation(value = "Save", tags = {"PARYDGZJH" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parydgzjhs/save")
    public ResponseEntity<Boolean> save(@RequestBody PARYDGZJHDTO parydgzjhdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parydgzjhService.save(parydgzjhMapping.toDomain(parydgzjhdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PARYDGZJH" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parydgzjhs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARYDGZJHDTO> parydgzjhdtos) {
        parydgzjhService.saveBatch(parydgzjhMapping.toDomain(parydgzjhdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#parydgzjh_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PARYDGZJH" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parydgzjhs/{parydgzjh_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parydgzjh_id") String parydgzjh_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parydgzjhService.remove(parydgzjh_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PARYDGZJH" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parydgzjhs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parydgzjhService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#parydgzjh_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PARYDGZJH" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parydgzjhs/{parydgzjh_id}")
    public ResponseEntity<PARYDGZJHDTO> get(@PathVariable("parydgzjh_id") String parydgzjh_id) {
        PARYDGZJH domain = parydgzjhService.get(parydgzjh_id);
        PARYDGZJHDTO dto = parydgzjhMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PARYDGZJH" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parydgzjhs")
    @Transactional
    public ResponseEntity<PARYDGZJHDTO> create(@RequestBody PARYDGZJHDTO parydgzjhdto) {
        PARYDGZJH domain = parydgzjhMapping.toDomain(parydgzjhdto);
		parydgzjhService.create(domain);
        PARYDGZJHDTO dto = parydgzjhMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PARYDGZJH" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parydgzjhs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARYDGZJHDTO> parydgzjhdtos) {
        parydgzjhService.createBatch(parydgzjhMapping.toDomain(parydgzjhdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"PARYDGZJH" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parydgzjhs/fetchdefault")
	public ResponseEntity<List<PARYDGZJHDTO>> fetchDefault(PARYDGZJHSearchContext context) {
        Page<PARYDGZJH> domains = parydgzjhService.searchDefault(context) ;
        List<PARYDGZJHDTO> list = parydgzjhMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"PARYDGZJH" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parydgzjhs/searchdefault")
	public ResponseEntity<Page<PARYDGZJHDTO>> searchDefault(@RequestBody PARYDGZJHSearchContext context) {
        Page<PARYDGZJH> domains = parydgzjhService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parydgzjhMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PARYDGZJH getEntity(){
        return new PARYDGZJH();
    }

}
