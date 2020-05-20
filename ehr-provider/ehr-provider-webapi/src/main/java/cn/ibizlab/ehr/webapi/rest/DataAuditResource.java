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
import cn.ibizlab.ehr.core.common.domain.DataAudit;
import cn.ibizlab.ehr.core.common.service.IDataAuditService;
import cn.ibizlab.ehr.core.common.filter.DataAuditSearchContext;




@Slf4j
@Api(tags = {"DataAudit" })
@RestController("WebApi-dataaudit")
@RequestMapping("")
public class DataAuditResource {

    @Autowired
    private IDataAuditService dataauditService;

    @Autowired
    @Lazy
    private DataAuditMapping dataauditMapping;




    @ApiOperation(value = "CheckKey", tags = {"DataAudit" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/dataaudits/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody DataAuditDTO dataauditdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(dataauditService.checkKey(dataauditMapping.toDomain(dataauditdto)));
    }




    @ApiOperation(value = "GetDraft", tags = {"DataAudit" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/dataaudits/getdraft")
    public ResponseEntity<DataAuditDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(dataauditMapping.toDto(dataauditService.getDraft(new DataAudit())));
    }




    @PreAuthorize("hasPermission(#dataaudit_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"DataAudit" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/dataaudits/{dataaudit_id}")
    public ResponseEntity<DataAuditDTO> get(@PathVariable("dataaudit_id") String dataaudit_id) {
        DataAudit domain = dataauditService.get(dataaudit_id);
        DataAuditDTO dto = dataauditMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"DataAudit" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/dataaudits")
    @Transactional
    public ResponseEntity<DataAuditDTO> create(@RequestBody DataAuditDTO dataauditdto) {
        DataAudit domain = dataauditMapping.toDomain(dataauditdto);
		dataauditService.create(domain);
        DataAuditDTO dto = dataauditMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"DataAudit" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/dataaudits/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<DataAuditDTO> dataauditdtos) {
        dataauditService.createBatch(dataauditMapping.toDomain(dataauditdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#dataaudit_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"DataAudit" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/dataaudits/{dataaudit_id}")
    @Transactional
    public ResponseEntity<DataAuditDTO> update(@PathVariable("dataaudit_id") String dataaudit_id, @RequestBody DataAuditDTO dataauditdto) {
		DataAudit domain = dataauditMapping.toDomain(dataauditdto);
        domain.setDataauditid(dataaudit_id);
		dataauditService.update(domain);
		DataAuditDTO dto = dataauditMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#dataaudit_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"DataAudit" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/dataaudits/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<DataAuditDTO> dataauditdtos) {
        dataauditService.updateBatch(dataauditMapping.toDomain(dataauditdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#dataaudit_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"DataAudit" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/dataaudits/{dataaudit_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("dataaudit_id") String dataaudit_id) {
         return ResponseEntity.status(HttpStatus.OK).body(dataauditService.remove(dataaudit_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"DataAudit" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/dataaudits/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        dataauditService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"DataAudit" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/dataaudits/save")
    public ResponseEntity<Boolean> save(@RequestBody DataAuditDTO dataauditdto) {
        return ResponseEntity.status(HttpStatus.OK).body(dataauditService.save(dataauditMapping.toDomain(dataauditdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"DataAudit" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/dataaudits/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<DataAuditDTO> dataauditdtos) {
        dataauditService.saveBatch(dataauditMapping.toDomain(dataauditdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"DataAudit" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/dataaudits/fetchdefault")
	public ResponseEntity<List<DataAuditDTO>> fetchDefault(DataAuditSearchContext context) {
        Page<DataAudit> domains = dataauditService.searchDefault(context) ;
        List<DataAuditDTO> list = dataauditMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"DataAudit" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/dataaudits/searchdefault")
	public ResponseEntity<Page<DataAuditDTO>> searchDefault(@RequestBody DataAuditSearchContext context) {
        Page<DataAudit> domains = dataauditService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(dataauditMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public DataAudit getEntity(){
        return new DataAudit();
    }

}
