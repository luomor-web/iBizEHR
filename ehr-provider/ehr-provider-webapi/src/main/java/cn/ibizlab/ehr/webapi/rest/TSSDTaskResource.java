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
import cn.ibizlab.ehr.core.common.domain.TSSDTask;
import cn.ibizlab.ehr.core.common.service.ITSSDTaskService;
import cn.ibizlab.ehr.core.common.filter.TSSDTaskSearchContext;




@Slf4j
@Api(tags = {"TSSDTask" })
@RestController("WebApi-tssdtask")
@RequestMapping("")
public class TSSDTaskResource {

    @Autowired
    private ITSSDTaskService tssdtaskService;

    @Autowired
    @Lazy
    private TSSDTaskMapping tssdtaskMapping;




    @PreAuthorize("hasPermission('Remove',{#tssdtask_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"TSSDTask" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/tssdtasks/{tssdtask_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("tssdtask_id") String tssdtask_id) {
         return ResponseEntity.status(HttpStatus.OK).body(tssdtaskService.remove(tssdtask_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"TSSDTask" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/tssdtasks/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        tssdtaskService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"TSSDTask" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdtasks")
    @Transactional
    public ResponseEntity<TSSDTaskDTO> create(@RequestBody TSSDTaskDTO tssdtaskdto) {
        TSSDTask domain = tssdtaskMapping.toDomain(tssdtaskdto);
		tssdtaskService.create(domain);
        TSSDTaskDTO dto = tssdtaskMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"TSSDTask" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdtasks/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TSSDTaskDTO> tssdtaskdtos) {
        tssdtaskService.createBatch(tssdtaskMapping.toDomain(tssdtaskdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#tssdtask_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"TSSDTask" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/tssdtasks/{tssdtask_id}")
    @Transactional
    public ResponseEntity<TSSDTaskDTO> update(@PathVariable("tssdtask_id") String tssdtask_id, @RequestBody TSSDTaskDTO tssdtaskdto) {
		TSSDTask domain = tssdtaskMapping.toDomain(tssdtaskdto);
        domain.setTssdtaskid(tssdtask_id);
		tssdtaskService.update(domain);
		TSSDTaskDTO dto = tssdtaskMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#tssdtask_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"TSSDTask" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/tssdtasks/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TSSDTaskDTO> tssdtaskdtos) {
        tssdtaskService.updateBatch(tssdtaskMapping.toDomain(tssdtaskdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"TSSDTask" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdtasks/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TSSDTaskDTO tssdtaskdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(tssdtaskService.checkKey(tssdtaskMapping.toDomain(tssdtaskdto)));
    }




    @ApiOperation(value = "GetDraft", tags = {"TSSDTask" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/tssdtasks/getdraft")
    public ResponseEntity<TSSDTaskDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(tssdtaskMapping.toDto(tssdtaskService.getDraft(new TSSDTask())));
    }




    @ApiOperation(value = "Save", tags = {"TSSDTask" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdtasks/save")
    public ResponseEntity<Boolean> save(@RequestBody TSSDTaskDTO tssdtaskdto) {
        return ResponseEntity.status(HttpStatus.OK).body(tssdtaskService.save(tssdtaskMapping.toDomain(tssdtaskdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"TSSDTask" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/tssdtasks/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TSSDTaskDTO> tssdtaskdtos) {
        tssdtaskService.saveBatch(tssdtaskMapping.toDomain(tssdtaskdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#tssdtask_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"TSSDTask" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/tssdtasks/{tssdtask_id}")
    public ResponseEntity<TSSDTaskDTO> get(@PathVariable("tssdtask_id") String tssdtask_id) {
        TSSDTask domain = tssdtaskService.get(tssdtask_id);
        TSSDTaskDTO dto = tssdtaskMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"TSSDTask" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/tssdtasks/fetchdefault")
	public ResponseEntity<List<TSSDTaskDTO>> fetchDefault(TSSDTaskSearchContext context) {
        Page<TSSDTask> domains = tssdtaskService.searchDefault(context) ;
        List<TSSDTaskDTO> list = tssdtaskMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"TSSDTask" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/tssdtasks/searchdefault")
	public ResponseEntity<Page<TSSDTaskDTO>> searchDefault(@RequestBody TSSDTaskSearchContext context) {
        Page<TSSDTask> domains = tssdtaskService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(tssdtaskMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public TSSDTask getEntity(){
        return new TSSDTask();
    }

}
