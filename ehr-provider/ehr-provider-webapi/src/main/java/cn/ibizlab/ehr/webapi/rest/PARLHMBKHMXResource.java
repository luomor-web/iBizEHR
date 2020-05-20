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
import cn.ibizlab.ehr.core.par.domain.PARLHMBKHMX;
import cn.ibizlab.ehr.core.par.service.IPARLHMBKHMXService;
import cn.ibizlab.ehr.core.par.filter.PARLHMBKHMXSearchContext;




@Slf4j
@Api(tags = {"PARLHMBKHMX" })
@RestController("WebApi-parlhmbkhmx")
@RequestMapping("")
public class PARLHMBKHMXResource {

    @Autowired
    private IPARLHMBKHMXService parlhmbkhmxService;

    @Autowired
    @Lazy
    private PARLHMBKHMXMapping parlhmbkhmxMapping;




    @PreAuthorize("hasPermission(#parlhmbkhmx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PARLHMBKHMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parlhmbkhmxes/{parlhmbkhmx_id}")
    @Transactional
    public ResponseEntity<PARLHMBKHMXDTO> update(@PathVariable("parlhmbkhmx_id") String parlhmbkhmx_id, @RequestBody PARLHMBKHMXDTO parlhmbkhmxdto) {
		PARLHMBKHMX domain = parlhmbkhmxMapping.toDomain(parlhmbkhmxdto);
        domain.setParlhmbkhmxid(parlhmbkhmx_id);
		parlhmbkhmxService.update(domain);
		PARLHMBKHMXDTO dto = parlhmbkhmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#parlhmbkhmx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PARLHMBKHMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parlhmbkhmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARLHMBKHMXDTO> parlhmbkhmxdtos) {
        parlhmbkhmxService.updateBatch(parlhmbkhmxMapping.toDomain(parlhmbkhmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PARLHMBKHMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parlhmbkhmxes/getdraft")
    public ResponseEntity<PARLHMBKHMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parlhmbkhmxMapping.toDto(parlhmbkhmxService.getDraft(new PARLHMBKHMX())));
    }




    @PreAuthorize("hasPermission('Remove',{#parlhmbkhmx_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PARLHMBKHMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parlhmbkhmxes/{parlhmbkhmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parlhmbkhmx_id") String parlhmbkhmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parlhmbkhmxService.remove(parlhmbkhmx_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PARLHMBKHMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parlhmbkhmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parlhmbkhmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"PARLHMBKHMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parlhmbkhmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PARLHMBKHMXDTO parlhmbkhmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parlhmbkhmxService.save(parlhmbkhmxMapping.toDomain(parlhmbkhmxdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PARLHMBKHMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parlhmbkhmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARLHMBKHMXDTO> parlhmbkhmxdtos) {
        parlhmbkhmxService.saveBatch(parlhmbkhmxMapping.toDomain(parlhmbkhmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"PARLHMBKHMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parlhmbkhmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARLHMBKHMXDTO parlhmbkhmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parlhmbkhmxService.checkKey(parlhmbkhmxMapping.toDomain(parlhmbkhmxdto)));
    }




    @PreAuthorize("hasPermission(#parlhmbkhmx_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PARLHMBKHMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parlhmbkhmxes/{parlhmbkhmx_id}")
    public ResponseEntity<PARLHMBKHMXDTO> get(@PathVariable("parlhmbkhmx_id") String parlhmbkhmx_id) {
        PARLHMBKHMX domain = parlhmbkhmxService.get(parlhmbkhmx_id);
        PARLHMBKHMXDTO dto = parlhmbkhmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PARLHMBKHMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parlhmbkhmxes")
    @Transactional
    public ResponseEntity<PARLHMBKHMXDTO> create(@RequestBody PARLHMBKHMXDTO parlhmbkhmxdto) {
        PARLHMBKHMX domain = parlhmbkhmxMapping.toDomain(parlhmbkhmxdto);
		parlhmbkhmxService.create(domain);
        PARLHMBKHMXDTO dto = parlhmbkhmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PARLHMBKHMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parlhmbkhmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARLHMBKHMXDTO> parlhmbkhmxdtos) {
        parlhmbkhmxService.createBatch(parlhmbkhmxMapping.toDomain(parlhmbkhmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"PARLHMBKHMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parlhmbkhmxes/fetchdefault")
	public ResponseEntity<List<PARLHMBKHMXDTO>> fetchDefault(PARLHMBKHMXSearchContext context) {
        Page<PARLHMBKHMX> domains = parlhmbkhmxService.searchDefault(context) ;
        List<PARLHMBKHMXDTO> list = parlhmbkhmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"PARLHMBKHMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parlhmbkhmxes/searchdefault")
	public ResponseEntity<Page<PARLHMBKHMXDTO>> searchDefault(@RequestBody PARLHMBKHMXSearchContext context) {
        Page<PARLHMBKHMX> domains = parlhmbkhmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parlhmbkhmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PARLHMBKHMX getEntity(){
        return new PARLHMBKHMX();
    }

}
