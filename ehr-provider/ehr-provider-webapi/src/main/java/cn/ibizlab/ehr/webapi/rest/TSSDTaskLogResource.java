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
import cn.ibizlab.ehr.core.common.domain.TSSDTaskLog;
import cn.ibizlab.ehr.core.common.service.ITSSDTaskLogService;
import cn.ibizlab.ehr.core.common.filter.TSSDTaskLogSearchContext;




@Slf4j
@Api(tags = {"TSSDTaskLog" })
@RestController("WebApi-tssdtasklog")
@RequestMapping("")
public class TSSDTaskLogResource {

    @Autowired
    private ITSSDTaskLogService tssdtasklogService;

    @Autowired
    @Lazy
    private TSSDTaskLogMapping tssdtasklogMapping;




    @PreAuthorize("hasPermission(#tssdtasklog_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"TSSDTaskLog" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/tssdtasklogs/{tssdtasklog_id}")
    public ResponseEntity<TSSDTaskLogDTO> get(@PathVariable("tssdtasklog_id") String tssdtasklog_id) {
        TSSDTaskLog domain = tssdtasklogService.get(tssdtasklog_id);
        TSSDTaskLogDTO dto = tssdtasklogMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#tssdtasklog_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"TSSDTaskLog" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/tssdtasklogs/{tssdtasklog_id}")
    @Transactional
    public ResponseEntity<TSSDTaskLogDTO> update(@PathVariable("tssdtasklog_id") String tssdtasklog_id, @RequestBody TSSDTaskLogDTO tssdtasklogdto) {
		TSSDTaskLog domain = tssdtasklogMapping.toDomain(tssdtasklogdto);
        domain.setTssdtasklogid(tssdtasklog_id);
		tssdtasklogService.update(domain);
		TSSDTaskLogDTO dto = tssdtasklogMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#tssdtasklog_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"TSSDTaskLog" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/tssdtasklogs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TSSDTaskLogDTO> tssdtasklogdtos) {
        tssdtasklogService.updateBatch(tssdtasklogMapping.toDomain(tssdtasklogdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"TSSDTaskLog" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/tssdtasklogs/getdraft")
    public ResponseEntity<TSSDTaskLogDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(tssdtasklogMapping.toDto(tssdtasklogService.getDraft(new TSSDTaskLog())));
    }




    @ApiOperation(value = "CheckKey", tags = {"TSSDTaskLog" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdtasklogs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TSSDTaskLogDTO tssdtasklogdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(tssdtasklogService.checkKey(tssdtasklogMapping.toDomain(tssdtasklogdto)));
    }




    @PreAuthorize("hasPermission('Remove',{#tssdtasklog_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"TSSDTaskLog" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/tssdtasklogs/{tssdtasklog_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("tssdtasklog_id") String tssdtasklog_id) {
         return ResponseEntity.status(HttpStatus.OK).body(tssdtasklogService.remove(tssdtasklog_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"TSSDTaskLog" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/tssdtasklogs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        tssdtasklogService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"TSSDTaskLog" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdtasklogs/save")
    public ResponseEntity<Boolean> save(@RequestBody TSSDTaskLogDTO tssdtasklogdto) {
        return ResponseEntity.status(HttpStatus.OK).body(tssdtasklogService.save(tssdtasklogMapping.toDomain(tssdtasklogdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"TSSDTaskLog" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdtasklogs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TSSDTaskLogDTO> tssdtasklogdtos) {
        tssdtasklogService.saveBatch(tssdtasklogMapping.toDomain(tssdtasklogdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"TSSDTaskLog" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdtasklogs")
    @Transactional
    public ResponseEntity<TSSDTaskLogDTO> create(@RequestBody TSSDTaskLogDTO tssdtasklogdto) {
        TSSDTaskLog domain = tssdtasklogMapping.toDomain(tssdtasklogdto);
		tssdtasklogService.create(domain);
        TSSDTaskLogDTO dto = tssdtasklogMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"TSSDTaskLog" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdtasklogs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TSSDTaskLogDTO> tssdtasklogdtos) {
        tssdtasklogService.createBatch(tssdtasklogMapping.toDomain(tssdtasklogdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"TSSDTaskLog" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/tssdtasklogs/fetchdefault")
	public ResponseEntity<List<TSSDTaskLogDTO>> fetchDefault(TSSDTaskLogSearchContext context) {
        Page<TSSDTaskLog> domains = tssdtasklogService.searchDefault(context) ;
        List<TSSDTaskLogDTO> list = tssdtasklogMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"TSSDTaskLog" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/tssdtasklogs/searchdefault")
	public ResponseEntity<Page<TSSDTaskLogDTO>> searchDefault(@RequestBody TSSDTaskLogSearchContext context) {
        Page<TSSDTaskLog> domains = tssdtasklogService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(tssdtasklogMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public TSSDTaskLog getEntity(){
        return new TSSDTaskLog();
    }

}
