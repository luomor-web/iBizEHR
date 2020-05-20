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
import cn.ibizlab.ehr.core.soc.domain.SOCSELFAREBASEMX;
import cn.ibizlab.ehr.core.soc.service.ISOCSELFAREBASEMXService;
import cn.ibizlab.ehr.core.soc.filter.SOCSELFAREBASEMXSearchContext;




@Slf4j
@Api(tags = {"SOCSELFAREBASEMX" })
@RestController("WebApi-socselfarebasemx")
@RequestMapping("")
public class SOCSELFAREBASEMXResource {

    @Autowired
    private ISOCSELFAREBASEMXService socselfarebasemxService;

    @Autowired
    @Lazy
    private SOCSELFAREBASEMXMapping socselfarebasemxMapping;




    @ApiOperation(value = "CheckKey", tags = {"SOCSELFAREBASEMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/socselfarebasemxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SOCSELFAREBASEMXDTO socselfarebasemxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(socselfarebasemxService.checkKey(socselfarebasemxMapping.toDomain(socselfarebasemxdto)));
    }




    @PreAuthorize("hasPermission('Remove',{#socselfarebasemx_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"SOCSELFAREBASEMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/socselfarebasemxes/{socselfarebasemx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("socselfarebasemx_id") String socselfarebasemx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(socselfarebasemxService.remove(socselfarebasemx_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"SOCSELFAREBASEMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/socselfarebasemxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        socselfarebasemxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#socselfarebasemx_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"SOCSELFAREBASEMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/socselfarebasemxes/{socselfarebasemx_id}")
    public ResponseEntity<SOCSELFAREBASEMXDTO> get(@PathVariable("socselfarebasemx_id") String socselfarebasemx_id) {
        SOCSELFAREBASEMX domain = socselfarebasemxService.get(socselfarebasemx_id);
        SOCSELFAREBASEMXDTO dto = socselfarebasemxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "GetDraft", tags = {"SOCSELFAREBASEMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/socselfarebasemxes/getdraft")
    public ResponseEntity<SOCSELFAREBASEMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(socselfarebasemxMapping.toDto(socselfarebasemxService.getDraft(new SOCSELFAREBASEMX())));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"SOCSELFAREBASEMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/socselfarebasemxes")
    @Transactional
    public ResponseEntity<SOCSELFAREBASEMXDTO> create(@RequestBody SOCSELFAREBASEMXDTO socselfarebasemxdto) {
        SOCSELFAREBASEMX domain = socselfarebasemxMapping.toDomain(socselfarebasemxdto);
		socselfarebasemxService.create(domain);
        SOCSELFAREBASEMXDTO dto = socselfarebasemxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"SOCSELFAREBASEMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/socselfarebasemxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SOCSELFAREBASEMXDTO> socselfarebasemxdtos) {
        socselfarebasemxService.createBatch(socselfarebasemxMapping.toDomain(socselfarebasemxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"SOCSELFAREBASEMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/socselfarebasemxes/save")
    public ResponseEntity<Boolean> save(@RequestBody SOCSELFAREBASEMXDTO socselfarebasemxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(socselfarebasemxService.save(socselfarebasemxMapping.toDomain(socselfarebasemxdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"SOCSELFAREBASEMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/socselfarebasemxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SOCSELFAREBASEMXDTO> socselfarebasemxdtos) {
        socselfarebasemxService.saveBatch(socselfarebasemxMapping.toDomain(socselfarebasemxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#socselfarebasemx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"SOCSELFAREBASEMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/socselfarebasemxes/{socselfarebasemx_id}")
    @Transactional
    public ResponseEntity<SOCSELFAREBASEMXDTO> update(@PathVariable("socselfarebasemx_id") String socselfarebasemx_id, @RequestBody SOCSELFAREBASEMXDTO socselfarebasemxdto) {
		SOCSELFAREBASEMX domain = socselfarebasemxMapping.toDomain(socselfarebasemxdto);
        domain.setSocselfarebasemxid(socselfarebasemx_id);
		socselfarebasemxService.update(domain);
		SOCSELFAREBASEMXDTO dto = socselfarebasemxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#socselfarebasemx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"SOCSELFAREBASEMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/socselfarebasemxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SOCSELFAREBASEMXDTO> socselfarebasemxdtos) {
        socselfarebasemxService.updateBatch(socselfarebasemxMapping.toDomain(socselfarebasemxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"SOCSELFAREBASEMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/socselfarebasemxes/fetchdefault")
	public ResponseEntity<List<SOCSELFAREBASEMXDTO>> fetchDefault(SOCSELFAREBASEMXSearchContext context) {
        Page<SOCSELFAREBASEMX> domains = socselfarebasemxService.searchDefault(context) ;
        List<SOCSELFAREBASEMXDTO> list = socselfarebasemxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"SOCSELFAREBASEMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/socselfarebasemxes/searchdefault")
	public ResponseEntity<Page<SOCSELFAREBASEMXDTO>> searchDefault(@RequestBody SOCSELFAREBASEMXSearchContext context) {
        Page<SOCSELFAREBASEMX> domains = socselfarebasemxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(socselfarebasemxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public SOCSELFAREBASEMX getEntity(){
        return new SOCSELFAREBASEMX();
    }

}
