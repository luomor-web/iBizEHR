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
import cn.ibizlab.ehr.core.common.domain.TSSDTaskType;
import cn.ibizlab.ehr.core.common.service.ITSSDTaskTypeService;
import cn.ibizlab.ehr.core.common.filter.TSSDTaskTypeSearchContext;




@Slf4j
@Api(tags = {"TSSDTaskType" })
@RestController("WebApi-tssdtasktype")
@RequestMapping("")
public class TSSDTaskTypeResource {

    @Autowired
    private ITSSDTaskTypeService tssdtasktypeService;

    @Autowired
    @Lazy
    private TSSDTaskTypeMapping tssdtasktypeMapping;




    @PreAuthorize("hasPermission('Remove',{#tssdtasktype_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"TSSDTaskType" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/tssdtasktypes/{tssdtasktype_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("tssdtasktype_id") String tssdtasktype_id) {
         return ResponseEntity.status(HttpStatus.OK).body(tssdtasktypeService.remove(tssdtasktype_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"TSSDTaskType" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/tssdtasktypes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        tssdtasktypeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#tssdtasktype_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"TSSDTaskType" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/tssdtasktypes/{tssdtasktype_id}")
    public ResponseEntity<TSSDTaskTypeDTO> get(@PathVariable("tssdtasktype_id") String tssdtasktype_id) {
        TSSDTaskType domain = tssdtasktypeService.get(tssdtasktype_id);
        TSSDTaskTypeDTO dto = tssdtasktypeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "CheckKey", tags = {"TSSDTaskType" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdtasktypes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TSSDTaskTypeDTO tssdtasktypedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(tssdtasktypeService.checkKey(tssdtasktypeMapping.toDomain(tssdtasktypedto)));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"TSSDTaskType" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdtasktypes")
    @Transactional
    public ResponseEntity<TSSDTaskTypeDTO> create(@RequestBody TSSDTaskTypeDTO tssdtasktypedto) {
        TSSDTaskType domain = tssdtasktypeMapping.toDomain(tssdtasktypedto);
		tssdtasktypeService.create(domain);
        TSSDTaskTypeDTO dto = tssdtasktypeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"TSSDTaskType" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdtasktypes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TSSDTaskTypeDTO> tssdtasktypedtos) {
        tssdtasktypeService.createBatch(tssdtasktypeMapping.toDomain(tssdtasktypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"TSSDTaskType" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/tssdtasktypes/getdraft")
    public ResponseEntity<TSSDTaskTypeDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(tssdtasktypeMapping.toDto(tssdtasktypeService.getDraft(new TSSDTaskType())));
    }




    @ApiOperation(value = "Save", tags = {"TSSDTaskType" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdtasktypes/save")
    public ResponseEntity<Boolean> save(@RequestBody TSSDTaskTypeDTO tssdtasktypedto) {
        return ResponseEntity.status(HttpStatus.OK).body(tssdtasktypeService.save(tssdtasktypeMapping.toDomain(tssdtasktypedto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"TSSDTaskType" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdtasktypes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TSSDTaskTypeDTO> tssdtasktypedtos) {
        tssdtasktypeService.saveBatch(tssdtasktypeMapping.toDomain(tssdtasktypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#tssdtasktype_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"TSSDTaskType" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/tssdtasktypes/{tssdtasktype_id}")
    @Transactional
    public ResponseEntity<TSSDTaskTypeDTO> update(@PathVariable("tssdtasktype_id") String tssdtasktype_id, @RequestBody TSSDTaskTypeDTO tssdtasktypedto) {
		TSSDTaskType domain = tssdtasktypeMapping.toDomain(tssdtasktypedto);
        domain.setTssdtasktypeid(tssdtasktype_id);
		tssdtasktypeService.update(domain);
		TSSDTaskTypeDTO dto = tssdtasktypeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#tssdtasktype_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"TSSDTaskType" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/tssdtasktypes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TSSDTaskTypeDTO> tssdtasktypedtos) {
        tssdtasktypeService.updateBatch(tssdtasktypeMapping.toDomain(tssdtasktypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"TSSDTaskType" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/tssdtasktypes/fetchdefault")
	public ResponseEntity<List<TSSDTaskTypeDTO>> fetchDefault(TSSDTaskTypeSearchContext context) {
        Page<TSSDTaskType> domains = tssdtasktypeService.searchDefault(context) ;
        List<TSSDTaskTypeDTO> list = tssdtasktypeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"TSSDTaskType" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/tssdtasktypes/searchdefault")
	public ResponseEntity<Page<TSSDTaskTypeDTO>> searchDefault(@RequestBody TSSDTaskTypeSearchContext context) {
        Page<TSSDTaskType> domains = tssdtasktypeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(tssdtasktypeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public TSSDTaskType getEntity(){
        return new TSSDTaskType();
    }

}
