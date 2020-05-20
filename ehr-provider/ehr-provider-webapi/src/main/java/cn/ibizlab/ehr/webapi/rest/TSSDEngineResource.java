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
import cn.ibizlab.ehr.core.common.domain.TSSDEngine;
import cn.ibizlab.ehr.core.common.service.ITSSDEngineService;
import cn.ibizlab.ehr.core.common.filter.TSSDEngineSearchContext;




@Slf4j
@Api(tags = {"TSSDEngine" })
@RestController("WebApi-tssdengine")
@RequestMapping("")
public class TSSDEngineResource {

    @Autowired
    private ITSSDEngineService tssdengineService;

    @Autowired
    @Lazy
    private TSSDEngineMapping tssdengineMapping;




    @ApiOperation(value = "GetDraft", tags = {"TSSDEngine" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/tssdengines/getdraft")
    public ResponseEntity<TSSDEngineDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(tssdengineMapping.toDto(tssdengineService.getDraft(new TSSDEngine())));
    }




    @PreAuthorize("hasPermission(#tssdengine_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"TSSDEngine" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/tssdengines/{tssdengine_id}")
    public ResponseEntity<TSSDEngineDTO> get(@PathVariable("tssdengine_id") String tssdengine_id) {
        TSSDEngine domain = tssdengineService.get(tssdengine_id);
        TSSDEngineDTO dto = tssdengineMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "Save", tags = {"TSSDEngine" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdengines/save")
    public ResponseEntity<Boolean> save(@RequestBody TSSDEngineDTO tssdenginedto) {
        return ResponseEntity.status(HttpStatus.OK).body(tssdengineService.save(tssdengineMapping.toDomain(tssdenginedto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"TSSDEngine" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdengines/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TSSDEngineDTO> tssdenginedtos) {
        tssdengineService.saveBatch(tssdengineMapping.toDomain(tssdenginedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"TSSDEngine" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdengines")
    @Transactional
    public ResponseEntity<TSSDEngineDTO> create(@RequestBody TSSDEngineDTO tssdenginedto) {
        TSSDEngine domain = tssdengineMapping.toDomain(tssdenginedto);
		tssdengineService.create(domain);
        TSSDEngineDTO dto = tssdengineMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"TSSDEngine" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdengines/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TSSDEngineDTO> tssdenginedtos) {
        tssdengineService.createBatch(tssdengineMapping.toDomain(tssdenginedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#tssdengine_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"TSSDEngine" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/tssdengines/{tssdengine_id}")
    @Transactional
    public ResponseEntity<TSSDEngineDTO> update(@PathVariable("tssdengine_id") String tssdengine_id, @RequestBody TSSDEngineDTO tssdenginedto) {
		TSSDEngine domain = tssdengineMapping.toDomain(tssdenginedto);
        domain.setTssdengineid(tssdengine_id);
		tssdengineService.update(domain);
		TSSDEngineDTO dto = tssdengineMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#tssdengine_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"TSSDEngine" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/tssdengines/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TSSDEngineDTO> tssdenginedtos) {
        tssdengineService.updateBatch(tssdengineMapping.toDomain(tssdenginedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"TSSDEngine" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdengines/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TSSDEngineDTO tssdenginedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(tssdengineService.checkKey(tssdengineMapping.toDomain(tssdenginedto)));
    }




    @PreAuthorize("hasPermission('Remove',{#tssdengine_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"TSSDEngine" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/tssdengines/{tssdengine_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("tssdengine_id") String tssdengine_id) {
         return ResponseEntity.status(HttpStatus.OK).body(tssdengineService.remove(tssdengine_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"TSSDEngine" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/tssdengines/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        tssdengineService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"TSSDEngine" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/tssdengines/fetchdefault")
	public ResponseEntity<List<TSSDEngineDTO>> fetchDefault(TSSDEngineSearchContext context) {
        Page<TSSDEngine> domains = tssdengineService.searchDefault(context) ;
        List<TSSDEngineDTO> list = tssdengineMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"TSSDEngine" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/tssdengines/searchdefault")
	public ResponseEntity<Page<TSSDEngineDTO>> searchDefault(@RequestBody TSSDEngineSearchContext context) {
        Page<TSSDEngine> domains = tssdengineService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(tssdengineMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public TSSDEngine getEntity(){
        return new TSSDEngine();
    }

}
