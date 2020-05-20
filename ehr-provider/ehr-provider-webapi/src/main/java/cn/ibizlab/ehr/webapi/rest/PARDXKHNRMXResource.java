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
import cn.ibizlab.ehr.core.par.domain.PARDXKHNRMX;
import cn.ibizlab.ehr.core.par.service.IPARDXKHNRMXService;
import cn.ibizlab.ehr.core.par.filter.PARDXKHNRMXSearchContext;




@Slf4j
@Api(tags = {"PARDXKHNRMX" })
@RestController("WebApi-pardxkhnrmx")
@RequestMapping("")
public class PARDXKHNRMXResource {

    @Autowired
    private IPARDXKHNRMXService pardxkhnrmxService;

    @Autowired
    @Lazy
    private PARDXKHNRMXMapping pardxkhnrmxMapping;




    @PreAuthorize("hasPermission(#pardxkhnrmx_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"PARDXKHNRMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pardxkhnrmxes/{pardxkhnrmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pardxkhnrmx_id") String pardxkhnrmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pardxkhnrmxService.remove(pardxkhnrmx_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PARDXKHNRMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pardxkhnrmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pardxkhnrmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"PARDXKHNRMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pardxkhnrmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PARDXKHNRMXDTO pardxkhnrmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pardxkhnrmxService.save(pardxkhnrmxMapping.toDomain(pardxkhnrmxdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PARDXKHNRMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pardxkhnrmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARDXKHNRMXDTO> pardxkhnrmxdtos) {
        pardxkhnrmxService.saveBatch(pardxkhnrmxMapping.toDomain(pardxkhnrmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"PARDXKHNRMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pardxkhnrmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARDXKHNRMXDTO pardxkhnrmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pardxkhnrmxService.checkKey(pardxkhnrmxMapping.toDomain(pardxkhnrmxdto)));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PARDXKHNRMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pardxkhnrmxes")
    @Transactional
    public ResponseEntity<PARDXKHNRMXDTO> create(@RequestBody PARDXKHNRMXDTO pardxkhnrmxdto) {
        PARDXKHNRMX domain = pardxkhnrmxMapping.toDomain(pardxkhnrmxdto);
		pardxkhnrmxService.create(domain);
        PARDXKHNRMXDTO dto = pardxkhnrmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PARDXKHNRMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pardxkhnrmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARDXKHNRMXDTO> pardxkhnrmxdtos) {
        pardxkhnrmxService.createBatch(pardxkhnrmxMapping.toDomain(pardxkhnrmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"PARDXKHNRMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pardxkhnrmxes/getdraft")
    public ResponseEntity<PARDXKHNRMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pardxkhnrmxMapping.toDto(pardxkhnrmxService.getDraft(new PARDXKHNRMX())));
    }




    @PreAuthorize("hasPermission(#pardxkhnrmx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PARDXKHNRMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pardxkhnrmxes/{pardxkhnrmx_id}")
    @Transactional
    public ResponseEntity<PARDXKHNRMXDTO> update(@PathVariable("pardxkhnrmx_id") String pardxkhnrmx_id, @RequestBody PARDXKHNRMXDTO pardxkhnrmxdto) {
		PARDXKHNRMX domain = pardxkhnrmxMapping.toDomain(pardxkhnrmxdto);
        domain.setPardxkhnrmxid(pardxkhnrmx_id);
		pardxkhnrmxService.update(domain);
		PARDXKHNRMXDTO dto = pardxkhnrmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pardxkhnrmx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PARDXKHNRMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pardxkhnrmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARDXKHNRMXDTO> pardxkhnrmxdtos) {
        pardxkhnrmxService.updateBatch(pardxkhnrmxMapping.toDomain(pardxkhnrmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pardxkhnrmx_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PARDXKHNRMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pardxkhnrmxes/{pardxkhnrmx_id}")
    public ResponseEntity<PARDXKHNRMXDTO> get(@PathVariable("pardxkhnrmx_id") String pardxkhnrmx_id) {
        PARDXKHNRMX domain = pardxkhnrmxService.get(pardxkhnrmx_id);
        PARDXKHNRMXDTO dto = pardxkhnrmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARDXKHNRMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PARDXKHNRMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pardxkhnrmxes/fetchdefault")
	public ResponseEntity<List<PARDXKHNRMXDTO>> fetchDefault(PARDXKHNRMXSearchContext context) {
        Page<PARDXKHNRMX> domains = pardxkhnrmxService.searchDefault(context) ;
        List<PARDXKHNRMXDTO> list = pardxkhnrmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARDXKHNRMX-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PARDXKHNRMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pardxkhnrmxes/searchdefault")
	public ResponseEntity<Page<PARDXKHNRMXDTO>> searchDefault(@RequestBody PARDXKHNRMXSearchContext context) {
        Page<PARDXKHNRMX> domains = pardxkhnrmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pardxkhnrmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PARDXKHNRMX getEntity(){
        return new PARDXKHNRMX();
    }

}
