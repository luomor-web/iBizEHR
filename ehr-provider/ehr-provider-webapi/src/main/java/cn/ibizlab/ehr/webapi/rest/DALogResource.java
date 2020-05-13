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
import cn.ibizlab.ehr.core.common.domain.DALog;
import cn.ibizlab.ehr.core.common.service.IDALogService;
import cn.ibizlab.ehr.core.common.filter.DALogSearchContext;




@Slf4j
@Api(tags = {"DALog" })
@RestController("WebApi-dalog")
@RequestMapping("")
public class DALogResource {

    @Autowired
    private IDALogService dalogService;

    @Autowired
    @Lazy
    private DALogMapping dalogMapping;




    @ApiOperation(value = "Save", tags = {"DALog" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/dalogs/save")
    public ResponseEntity<Boolean> save(@RequestBody DALogDTO dalogdto) {
        return ResponseEntity.status(HttpStatus.OK).body(dalogService.save(dalogMapping.toDomain(dalogdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"DALog" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/dalogs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<DALogDTO> dalogdtos) {
        dalogService.saveBatch(dalogMapping.toDomain(dalogdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#dalog_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"DALog" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/dalogs/{dalog_id}")
    @Transactional
    public ResponseEntity<DALogDTO> update(@PathVariable("dalog_id") String dalog_id, @RequestBody DALogDTO dalogdto) {
		DALog domain = dalogMapping.toDomain(dalogdto);
        domain.setDalogId(dalog_id);
		dalogService.update(domain);
		DALogDTO dto = dalogMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#dalog_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"DALog" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/dalogs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<DALogDTO> dalogdtos) {
        dalogService.updateBatch(dalogMapping.toDomain(dalogdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"DALog" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/dalogs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody DALogDTO dalogdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(dalogService.checkKey(dalogMapping.toDomain(dalogdto)));
    }




    @PreAuthorize("hasPermission('Remove',{#dalog_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"DALog" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/dalogs/{dalog_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("dalog_id") String dalog_id) {
         return ResponseEntity.status(HttpStatus.OK).body(dalogService.remove(dalog_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"DALog" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/dalogs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        dalogService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"DALog" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/dalogs/getdraft")
    public ResponseEntity<DALogDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(dalogMapping.toDto(dalogService.getDraft(new DALog())));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"DALog" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/dalogs")
    @Transactional
    public ResponseEntity<DALogDTO> create(@RequestBody DALogDTO dalogdto) {
        DALog domain = dalogMapping.toDomain(dalogdto);
		dalogService.create(domain);
        DALogDTO dto = dalogMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"DALog" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/dalogs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<DALogDTO> dalogdtos) {
        dalogService.createBatch(dalogMapping.toDomain(dalogdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#dalog_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"DALog" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/dalogs/{dalog_id}")
    public ResponseEntity<DALogDTO> get(@PathVariable("dalog_id") String dalog_id) {
        DALog domain = dalogService.get(dalog_id);
        DALogDTO dto = dalogMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"DALog" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/dalogs/fetchdefault")
	public ResponseEntity<List<DALogDTO>> fetchDefault(DALogSearchContext context) {
        Page<DALog> domains = dalogService.searchDefault(context) ;
        List<DALogDTO> list = dalogMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"DALog" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/dalogs/searchdefault")
	public ResponseEntity<Page<DALogDTO>> searchDefault(DALogSearchContext context) {
        Page<DALog> domains = dalogService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(dalogMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public DALog getEntity(){
        return new DALog();
    }

}
