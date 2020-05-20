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
import cn.ibizlab.ehr.core.par.domain.PARPTRYNDLHMBMX;
import cn.ibizlab.ehr.core.par.service.IPARPTRYNDLHMBMXService;
import cn.ibizlab.ehr.core.par.filter.PARPTRYNDLHMBMXSearchContext;




@Slf4j
@Api(tags = {"PARPTRYNDLHMBMX" })
@RestController("WebApi-parptryndlhmbmx")
@RequestMapping("")
public class PARPTRYNDLHMBMXResource {

    @Autowired
    private IPARPTRYNDLHMBMXService parptryndlhmbmxService;

    @Autowired
    @Lazy
    private PARPTRYNDLHMBMXMapping parptryndlhmbmxMapping;




    @ApiOperation(value = "GetDraft", tags = {"PARPTRYNDLHMBMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parptryndlhmbmxes/getdraft")
    public ResponseEntity<PARPTRYNDLHMBMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parptryndlhmbmxMapping.toDto(parptryndlhmbmxService.getDraft(new PARPTRYNDLHMBMX())));
    }




    @PreAuthorize("hasPermission('Remove',{#parptryndlhmbmx_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PARPTRYNDLHMBMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parptryndlhmbmxes/{parptryndlhmbmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parptryndlhmbmx_id") String parptryndlhmbmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parptryndlhmbmxService.remove(parptryndlhmbmx_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PARPTRYNDLHMBMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parptryndlhmbmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parptryndlhmbmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"PARPTRYNDLHMBMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parptryndlhmbmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARPTRYNDLHMBMXDTO parptryndlhmbmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parptryndlhmbmxService.checkKey(parptryndlhmbmxMapping.toDomain(parptryndlhmbmxdto)));
    }




    @PreAuthorize("hasPermission(#parptryndlhmbmx_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PARPTRYNDLHMBMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parptryndlhmbmxes/{parptryndlhmbmx_id}")
    public ResponseEntity<PARPTRYNDLHMBMXDTO> get(@PathVariable("parptryndlhmbmx_id") String parptryndlhmbmx_id) {
        PARPTRYNDLHMBMX domain = parptryndlhmbmxService.get(parptryndlhmbmx_id);
        PARPTRYNDLHMBMXDTO dto = parptryndlhmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "Save", tags = {"PARPTRYNDLHMBMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parptryndlhmbmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PARPTRYNDLHMBMXDTO parptryndlhmbmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parptryndlhmbmxService.save(parptryndlhmbmxMapping.toDomain(parptryndlhmbmxdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PARPTRYNDLHMBMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parptryndlhmbmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARPTRYNDLHMBMXDTO> parptryndlhmbmxdtos) {
        parptryndlhmbmxService.saveBatch(parptryndlhmbmxMapping.toDomain(parptryndlhmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#parptryndlhmbmx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PARPTRYNDLHMBMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parptryndlhmbmxes/{parptryndlhmbmx_id}")
    @Transactional
    public ResponseEntity<PARPTRYNDLHMBMXDTO> update(@PathVariable("parptryndlhmbmx_id") String parptryndlhmbmx_id, @RequestBody PARPTRYNDLHMBMXDTO parptryndlhmbmxdto) {
		PARPTRYNDLHMBMX domain = parptryndlhmbmxMapping.toDomain(parptryndlhmbmxdto);
        domain.setParptryndlhmbmxid(parptryndlhmbmx_id);
		parptryndlhmbmxService.update(domain);
		PARPTRYNDLHMBMXDTO dto = parptryndlhmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#parptryndlhmbmx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PARPTRYNDLHMBMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parptryndlhmbmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARPTRYNDLHMBMXDTO> parptryndlhmbmxdtos) {
        parptryndlhmbmxService.updateBatch(parptryndlhmbmxMapping.toDomain(parptryndlhmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PARPTRYNDLHMBMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parptryndlhmbmxes")
    @Transactional
    public ResponseEntity<PARPTRYNDLHMBMXDTO> create(@RequestBody PARPTRYNDLHMBMXDTO parptryndlhmbmxdto) {
        PARPTRYNDLHMBMX domain = parptryndlhmbmxMapping.toDomain(parptryndlhmbmxdto);
		parptryndlhmbmxService.create(domain);
        PARPTRYNDLHMBMXDTO dto = parptryndlhmbmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PARPTRYNDLHMBMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parptryndlhmbmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARPTRYNDLHMBMXDTO> parptryndlhmbmxdtos) {
        parptryndlhmbmxService.createBatch(parptryndlhmbmxMapping.toDomain(parptryndlhmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"PARPTRYNDLHMBMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parptryndlhmbmxes/fetchdefault")
	public ResponseEntity<List<PARPTRYNDLHMBMXDTO>> fetchDefault(PARPTRYNDLHMBMXSearchContext context) {
        Page<PARPTRYNDLHMBMX> domains = parptryndlhmbmxService.searchDefault(context) ;
        List<PARPTRYNDLHMBMXDTO> list = parptryndlhmbmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"PARPTRYNDLHMBMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parptryndlhmbmxes/searchdefault")
	public ResponseEntity<Page<PARPTRYNDLHMBMXDTO>> searchDefault(@RequestBody PARPTRYNDLHMBMXSearchContext context) {
        Page<PARPTRYNDLHMBMX> domains = parptryndlhmbmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parptryndlhmbmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PARPTRYNDLHMBMX getEntity(){
        return new PARPTRYNDLHMBMX();
    }

}
