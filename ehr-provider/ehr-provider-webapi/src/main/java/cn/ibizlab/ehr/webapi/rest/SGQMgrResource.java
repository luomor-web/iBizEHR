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
import cn.ibizlab.ehr.core.pcm.domain.SGQMgr;
import cn.ibizlab.ehr.core.pcm.service.ISGQMgrService;
import cn.ibizlab.ehr.core.pcm.filter.SGQMgrSearchContext;




@Slf4j
@Api(tags = {"SGQMgr" })
@RestController("WebApi-sgqmgr")
@RequestMapping("")
public class SGQMgrResource {

    @Autowired
    private ISGQMgrService sgqmgrService;

    @Autowired
    @Lazy
    private SGQMgrMapping sgqmgrMapping;




    @PreAuthorize("hasPermission(#sgqmgr_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"SGQMgr" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/sgqmgrs/{sgqmgr_id}")
    public ResponseEntity<SGQMgrDTO> get(@PathVariable("sgqmgr_id") String sgqmgr_id) {
        SGQMgr domain = sgqmgrService.get(sgqmgr_id);
        SGQMgrDTO dto = sgqmgrMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "GetDraft", tags = {"SGQMgr" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/sgqmgrs/getdraft")
    public ResponseEntity<SGQMgrDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(sgqmgrMapping.toDto(sgqmgrService.getDraft(new SGQMgr())));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"SGQMgr" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/sgqmgrs")
    @Transactional
    public ResponseEntity<SGQMgrDTO> create(@RequestBody SGQMgrDTO sgqmgrdto) {
        SGQMgr domain = sgqmgrMapping.toDomain(sgqmgrdto);
		sgqmgrService.create(domain);
        SGQMgrDTO dto = sgqmgrMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"SGQMgr" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/sgqmgrs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SGQMgrDTO> sgqmgrdtos) {
        sgqmgrService.createBatch(sgqmgrMapping.toDomain(sgqmgrdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#sgqmgr_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"SGQMgr" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/sgqmgrs/{sgqmgr_id}")
    @Transactional
    public ResponseEntity<SGQMgrDTO> update(@PathVariable("sgqmgr_id") String sgqmgr_id, @RequestBody SGQMgrDTO sgqmgrdto) {
		SGQMgr domain = sgqmgrMapping.toDomain(sgqmgrdto);
        domain.setSgqmgrid(sgqmgr_id);
		sgqmgrService.update(domain);
		SGQMgrDTO dto = sgqmgrMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#sgqmgr_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"SGQMgr" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/sgqmgrs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SGQMgrDTO> sgqmgrdtos) {
        sgqmgrService.updateBatch(sgqmgrMapping.toDomain(sgqmgrdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#sgqmgr_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"SGQMgr" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sgqmgrs/{sgqmgr_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("sgqmgr_id") String sgqmgr_id) {
         return ResponseEntity.status(HttpStatus.OK).body(sgqmgrService.remove(sgqmgr_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"SGQMgr" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sgqmgrs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        sgqmgrService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"SGQMgr" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/sgqmgrs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SGQMgrDTO sgqmgrdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(sgqmgrService.checkKey(sgqmgrMapping.toDomain(sgqmgrdto)));
    }




    @ApiOperation(value = "Save", tags = {"SGQMgr" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/sgqmgrs/save")
    public ResponseEntity<Boolean> save(@RequestBody SGQMgrDTO sgqmgrdto) {
        return ResponseEntity.status(HttpStatus.OK).body(sgqmgrService.save(sgqmgrMapping.toDomain(sgqmgrdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"SGQMgr" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/sgqmgrs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SGQMgrDTO> sgqmgrdtos) {
        sgqmgrService.saveBatch(sgqmgrMapping.toDomain(sgqmgrdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SGQMgr" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/sgqmgrs/fetchdefault")
	public ResponseEntity<List<SGQMgrDTO>> fetchDefault(SGQMgrSearchContext context) {
        Page<SGQMgr> domains = sgqmgrService.searchDefault(context) ;
        List<SGQMgrDTO> list = sgqmgrMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"SGQMgr" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/sgqmgrs/searchdefault")
	public ResponseEntity<Page<SGQMgrDTO>> searchDefault(SGQMgrSearchContext context) {
        Page<SGQMgr> domains = sgqmgrService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(sgqmgrMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public SGQMgr getEntity(){
        return new SGQMgr();
    }

}