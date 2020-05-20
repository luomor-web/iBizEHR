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
import cn.ibizlab.ehr.core.common.domain.DataAuditDetail;
import cn.ibizlab.ehr.core.common.service.IDataAuditDetailService;
import cn.ibizlab.ehr.core.common.filter.DataAuditDetailSearchContext;




@Slf4j
@Api(tags = {"DataAuditDetail" })
@RestController("WebApi-dataauditdetail")
@RequestMapping("")
public class DataAuditDetailResource {

    @Autowired
    private IDataAuditDetailService dataauditdetailService;

    @Autowired
    @Lazy
    private DataAuditDetailMapping dataauditdetailMapping;




    @ApiOperation(value = "Save", tags = {"DataAuditDetail" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/dataauditdetails/save")
    public ResponseEntity<Boolean> save(@RequestBody DataAuditDetailDTO dataauditdetaildto) {
        return ResponseEntity.status(HttpStatus.OK).body(dataauditdetailService.save(dataauditdetailMapping.toDomain(dataauditdetaildto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"DataAuditDetail" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/dataauditdetails/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<DataAuditDetailDTO> dataauditdetaildtos) {
        dataauditdetailService.saveBatch(dataauditdetailMapping.toDomain(dataauditdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"DataAuditDetail" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/dataauditdetails/getdraft")
    public ResponseEntity<DataAuditDetailDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(dataauditdetailMapping.toDto(dataauditdetailService.getDraft(new DataAuditDetail())));
    }




    @PreAuthorize("hasPermission(#dataauditdetail_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"DataAuditDetail" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/dataauditdetails/{dataauditdetail_id}")
    public ResponseEntity<DataAuditDetailDTO> get(@PathVariable("dataauditdetail_id") String dataauditdetail_id) {
        DataAuditDetail domain = dataauditdetailService.get(dataauditdetail_id);
        DataAuditDetailDTO dto = dataauditdetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"DataAuditDetail" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/dataauditdetails")
    @Transactional
    public ResponseEntity<DataAuditDetailDTO> create(@RequestBody DataAuditDetailDTO dataauditdetaildto) {
        DataAuditDetail domain = dataauditdetailMapping.toDomain(dataauditdetaildto);
		dataauditdetailService.create(domain);
        DataAuditDetailDTO dto = dataauditdetailMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"DataAuditDetail" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/dataauditdetails/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<DataAuditDetailDTO> dataauditdetaildtos) {
        dataauditdetailService.createBatch(dataauditdetailMapping.toDomain(dataauditdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#dataauditdetail_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"DataAuditDetail" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/dataauditdetails/{dataauditdetail_id}")
    @Transactional
    public ResponseEntity<DataAuditDetailDTO> update(@PathVariable("dataauditdetail_id") String dataauditdetail_id, @RequestBody DataAuditDetailDTO dataauditdetaildto) {
		DataAuditDetail domain = dataauditdetailMapping.toDomain(dataauditdetaildto);
        domain.setDataauditdetailid(dataauditdetail_id);
		dataauditdetailService.update(domain);
		DataAuditDetailDTO dto = dataauditdetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#dataauditdetail_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"DataAuditDetail" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/dataauditdetails/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<DataAuditDetailDTO> dataauditdetaildtos) {
        dataauditdetailService.updateBatch(dataauditdetailMapping.toDomain(dataauditdetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"DataAuditDetail" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/dataauditdetails/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody DataAuditDetailDTO dataauditdetaildto) {
        return  ResponseEntity.status(HttpStatus.OK).body(dataauditdetailService.checkKey(dataauditdetailMapping.toDomain(dataauditdetaildto)));
    }




    @PreAuthorize("hasPermission('Remove',{#dataauditdetail_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"DataAuditDetail" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/dataauditdetails/{dataauditdetail_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("dataauditdetail_id") String dataauditdetail_id) {
         return ResponseEntity.status(HttpStatus.OK).body(dataauditdetailService.remove(dataauditdetail_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"DataAuditDetail" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/dataauditdetails/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        dataauditdetailService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"DataAuditDetail" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/dataauditdetails/fetchdefault")
	public ResponseEntity<List<DataAuditDetailDTO>> fetchDefault(DataAuditDetailSearchContext context) {
        Page<DataAuditDetail> domains = dataauditdetailService.searchDefault(context) ;
        List<DataAuditDetailDTO> list = dataauditdetailMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"DataAuditDetail" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/dataauditdetails/searchdefault")
	public ResponseEntity<Page<DataAuditDetailDTO>> searchDefault(@RequestBody DataAuditDetailSearchContext context) {
        Page<DataAuditDetail> domains = dataauditdetailService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(dataauditdetailMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public DataAuditDetail getEntity(){
        return new DataAuditDetail();
    }

}
