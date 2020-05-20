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
import cn.ibizlab.ehr.core.par.domain.PARJXKHMBMX;
import cn.ibizlab.ehr.core.par.service.IPARJXKHMBMXService;
import cn.ibizlab.ehr.core.par.filter.PARJXKHMBMXSearchContext;




@Slf4j
@Api(tags = {"PARJXKHMBMX" })
@RestController("WebApi-parjxkhmbmx")
@RequestMapping("")
public class PARJXKHMBMXResource {

    @Autowired
    private IPARJXKHMBMXService parjxkhmbmxService;

    @Autowired
    @Lazy
    private PARJXKHMBMXMapping parjxkhmbmxMapping;




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PARJXKHMBMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhmbmxes")
    @Transactional
    public ResponseEntity<PARJXKHMBMXDTO> create(@RequestBody PARJXKHMBMXDTO parjxkhmbmxdto) {
        PARJXKHMBMX domain = parjxkhmbmxMapping.toDomain(parjxkhmbmxdto);
		parjxkhmbmxService.create(domain);
        PARJXKHMBMXDTO dto = parjxkhmbmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PARJXKHMBMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhmbmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARJXKHMBMXDTO> parjxkhmbmxdtos) {
        parjxkhmbmxService.createBatch(parjxkhmbmxMapping.toDomain(parjxkhmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"PARJXKHMBMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhmbmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARJXKHMBMXDTO parjxkhmbmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parjxkhmbmxService.checkKey(parjxkhmbmxMapping.toDomain(parjxkhmbmxdto)));
    }




    @ApiOperation(value = "GetDraft", tags = {"PARJXKHMBMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxkhmbmxes/getdraft")
    public ResponseEntity<PARJXKHMBMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parjxkhmbmxMapping.toDto(parjxkhmbmxService.getDraft(new PARJXKHMBMX())));
    }




    @PreAuthorize("hasPermission(#parjxkhmbmx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PARJXKHMBMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxkhmbmxes/{parjxkhmbmx_id}")
    @Transactional
    public ResponseEntity<PARJXKHMBMXDTO> update(@PathVariable("parjxkhmbmx_id") String parjxkhmbmx_id, @RequestBody PARJXKHMBMXDTO parjxkhmbmxdto) {
		PARJXKHMBMX domain = parjxkhmbmxMapping.toDomain(parjxkhmbmxdto);
        domain.setParjxkhmbmxid(parjxkhmbmx_id);
		parjxkhmbmxService.update(domain);
		PARJXKHMBMXDTO dto = parjxkhmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#parjxkhmbmx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PARJXKHMBMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxkhmbmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARJXKHMBMXDTO> parjxkhmbmxdtos) {
        parjxkhmbmxService.updateBatch(parjxkhmbmxMapping.toDomain(parjxkhmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#parjxkhmbmx_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PARJXKHMBMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxkhmbmxes/{parjxkhmbmx_id}")
    public ResponseEntity<PARJXKHMBMXDTO> get(@PathVariable("parjxkhmbmx_id") String parjxkhmbmx_id) {
        PARJXKHMBMX domain = parjxkhmbmxService.get(parjxkhmbmx_id);
        PARJXKHMBMXDTO dto = parjxkhmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "Save", tags = {"PARJXKHMBMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhmbmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PARJXKHMBMXDTO parjxkhmbmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parjxkhmbmxService.save(parjxkhmbmxMapping.toDomain(parjxkhmbmxdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PARJXKHMBMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhmbmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARJXKHMBMXDTO> parjxkhmbmxdtos) {
        parjxkhmbmxService.saveBatch(parjxkhmbmxMapping.toDomain(parjxkhmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#parjxkhmbmx_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"PARJXKHMBMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxkhmbmxes/{parjxkhmbmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parjxkhmbmx_id") String parjxkhmbmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parjxkhmbmxService.remove(parjxkhmbmx_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PARJXKHMBMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxkhmbmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parjxkhmbmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXKHMBMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PARJXKHMBMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parjxkhmbmxes/fetchdefault")
	public ResponseEntity<List<PARJXKHMBMXDTO>> fetchDefault(PARJXKHMBMXSearchContext context) {
        Page<PARJXKHMBMX> domains = parjxkhmbmxService.searchDefault(context) ;
        List<PARJXKHMBMXDTO> list = parjxkhmbmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXKHMBMX-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PARJXKHMBMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parjxkhmbmxes/searchdefault")
	public ResponseEntity<Page<PARJXKHMBMXDTO>> searchDefault(@RequestBody PARJXKHMBMXSearchContext context) {
        Page<PARJXKHMBMX> domains = parjxkhmbmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjxkhmbmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PARJXKHMBMX getEntity(){
        return new PARJXKHMBMX();
    }

}
