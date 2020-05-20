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
import cn.ibizlab.ehr.core.par.domain.PARKHZCMX;
import cn.ibizlab.ehr.core.par.service.IPARKHZCMXService;
import cn.ibizlab.ehr.core.par.filter.PARKHZCMXSearchContext;




@Slf4j
@Api(tags = {"PARKHZCMX" })
@RestController("WebApi-parkhzcmx")
@RequestMapping("")
public class PARKHZCMXResource {

    @Autowired
    private IPARKHZCMXService parkhzcmxService;

    @Autowired
    @Lazy
    private PARKHZCMXMapping parkhzcmxMapping;




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PARKHZCMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parkhzcmxes")
    @Transactional
    public ResponseEntity<PARKHZCMXDTO> create(@RequestBody PARKHZCMXDTO parkhzcmxdto) {
        PARKHZCMX domain = parkhzcmxMapping.toDomain(parkhzcmxdto);
		parkhzcmxService.create(domain);
        PARKHZCMXDTO dto = parkhzcmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PARKHZCMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parkhzcmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARKHZCMXDTO> parkhzcmxdtos) {
        parkhzcmxService.createBatch(parkhzcmxMapping.toDomain(parkhzcmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"PARKHZCMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parkhzcmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PARKHZCMXDTO parkhzcmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parkhzcmxService.save(parkhzcmxMapping.toDomain(parkhzcmxdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PARKHZCMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parkhzcmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARKHZCMXDTO> parkhzcmxdtos) {
        parkhzcmxService.saveBatch(parkhzcmxMapping.toDomain(parkhzcmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#parkhzcmx_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PARKHZCMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parkhzcmxes/{parkhzcmx_id}")
    public ResponseEntity<PARKHZCMXDTO> get(@PathVariable("parkhzcmx_id") String parkhzcmx_id) {
        PARKHZCMX domain = parkhzcmxService.get(parkhzcmx_id);
        PARKHZCMXDTO dto = parkhzcmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "GetDraft", tags = {"PARKHZCMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parkhzcmxes/getdraft")
    public ResponseEntity<PARKHZCMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parkhzcmxMapping.toDto(parkhzcmxService.getDraft(new PARKHZCMX())));
    }




    @PreAuthorize("hasPermission(#parkhzcmx_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"PARKHZCMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parkhzcmxes/{parkhzcmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parkhzcmx_id") String parkhzcmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parkhzcmxService.remove(parkhzcmx_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PARKHZCMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parkhzcmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parkhzcmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"PARKHZCMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parkhzcmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARKHZCMXDTO parkhzcmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parkhzcmxService.checkKey(parkhzcmxMapping.toDomain(parkhzcmxdto)));
    }




    @PreAuthorize("hasPermission(#parkhzcmx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PARKHZCMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parkhzcmxes/{parkhzcmx_id}")
    @Transactional
    public ResponseEntity<PARKHZCMXDTO> update(@PathVariable("parkhzcmx_id") String parkhzcmx_id, @RequestBody PARKHZCMXDTO parkhzcmxdto) {
		PARKHZCMX domain = parkhzcmxMapping.toDomain(parkhzcmxdto);
        domain.setParkhzcmxid(parkhzcmx_id);
		parkhzcmxService.update(domain);
		PARKHZCMXDTO dto = parkhzcmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#parkhzcmx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PARKHZCMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parkhzcmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARKHZCMXDTO> parkhzcmxdtos) {
        parkhzcmxService.updateBatch(parkhzcmxMapping.toDomain(parkhzcmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARKHZCMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PARKHZCMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parkhzcmxes/fetchdefault")
	public ResponseEntity<List<PARKHZCMXDTO>> fetchDefault(PARKHZCMXSearchContext context) {
        Page<PARKHZCMX> domains = parkhzcmxService.searchDefault(context) ;
        List<PARKHZCMXDTO> list = parkhzcmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARKHZCMX-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PARKHZCMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parkhzcmxes/searchdefault")
	public ResponseEntity<Page<PARKHZCMXDTO>> searchDefault(@RequestBody PARKHZCMXSearchContext context) {
        Page<PARKHZCMX> domains = parkhzcmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parkhzcmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PARKHZCMX getEntity(){
        return new PARKHZCMX();
    }

}
