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
import cn.ibizlab.ehr.core.common.domain.DataSyncOut2;
import cn.ibizlab.ehr.core.common.service.IDataSyncOut2Service;
import cn.ibizlab.ehr.core.common.filter.DataSyncOut2SearchContext;




@Slf4j
@Api(tags = {"DataSyncOut2" })
@RestController("WebApi-datasyncout2")
@RequestMapping("")
public class DataSyncOut2Resource {

    @Autowired
    private IDataSyncOut2Service datasyncout2Service;

    @Autowired
    @Lazy
    private DataSyncOut2Mapping datasyncout2Mapping;




    @PreAuthorize("hasPermission(#datasyncout2_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"DataSyncOut2" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/datasyncout2s/{datasyncout2_id}")
    @Transactional
    public ResponseEntity<DataSyncOut2DTO> update(@PathVariable("datasyncout2_id") String datasyncout2_id, @RequestBody DataSyncOut2DTO datasyncout2dto) {
		DataSyncOut2 domain = datasyncout2Mapping.toDomain(datasyncout2dto);
        domain.setDatasyncout2id(datasyncout2_id);
		datasyncout2Service.update(domain);
		DataSyncOut2DTO dto = datasyncout2Mapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#datasyncout2_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"DataSyncOut2" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/datasyncout2s/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<DataSyncOut2DTO> datasyncout2dtos) {
        datasyncout2Service.updateBatch(datasyncout2Mapping.toDomain(datasyncout2dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"DataSyncOut2" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/datasyncout2s/getdraft")
    public ResponseEntity<DataSyncOut2DTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(datasyncout2Mapping.toDto(datasyncout2Service.getDraft(new DataSyncOut2())));
    }




    @ApiOperation(value = "Save", tags = {"DataSyncOut2" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/datasyncout2s/save")
    public ResponseEntity<Boolean> save(@RequestBody DataSyncOut2DTO datasyncout2dto) {
        return ResponseEntity.status(HttpStatus.OK).body(datasyncout2Service.save(datasyncout2Mapping.toDomain(datasyncout2dto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"DataSyncOut2" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/datasyncout2s/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<DataSyncOut2DTO> datasyncout2dtos) {
        datasyncout2Service.saveBatch(datasyncout2Mapping.toDomain(datasyncout2dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"DataSyncOut2" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/datasyncout2s")
    @Transactional
    public ResponseEntity<DataSyncOut2DTO> create(@RequestBody DataSyncOut2DTO datasyncout2dto) {
        DataSyncOut2 domain = datasyncout2Mapping.toDomain(datasyncout2dto);
		datasyncout2Service.create(domain);
        DataSyncOut2DTO dto = datasyncout2Mapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"DataSyncOut2" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/datasyncout2s/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<DataSyncOut2DTO> datasyncout2dtos) {
        datasyncout2Service.createBatch(datasyncout2Mapping.toDomain(datasyncout2dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"DataSyncOut2" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/datasyncout2s/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody DataSyncOut2DTO datasyncout2dto) {
        return  ResponseEntity.status(HttpStatus.OK).body(datasyncout2Service.checkKey(datasyncout2Mapping.toDomain(datasyncout2dto)));
    }




    @PreAuthorize("hasPermission('Remove',{#datasyncout2_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"DataSyncOut2" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/datasyncout2s/{datasyncout2_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("datasyncout2_id") String datasyncout2_id) {
         return ResponseEntity.status(HttpStatus.OK).body(datasyncout2Service.remove(datasyncout2_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"DataSyncOut2" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/datasyncout2s/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        datasyncout2Service.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#datasyncout2_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"DataSyncOut2" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/datasyncout2s/{datasyncout2_id}")
    public ResponseEntity<DataSyncOut2DTO> get(@PathVariable("datasyncout2_id") String datasyncout2_id) {
        DataSyncOut2 domain = datasyncout2Service.get(datasyncout2_id);
        DataSyncOut2DTO dto = datasyncout2Mapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"DataSyncOut2" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/datasyncout2s/fetchdefault")
	public ResponseEntity<List<DataSyncOut2DTO>> fetchDefault(DataSyncOut2SearchContext context) {
        Page<DataSyncOut2> domains = datasyncout2Service.searchDefault(context) ;
        List<DataSyncOut2DTO> list = datasyncout2Mapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"DataSyncOut2" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/datasyncout2s/searchdefault")
	public ResponseEntity<Page<DataSyncOut2DTO>> searchDefault(@RequestBody DataSyncOut2SearchContext context) {
        Page<DataSyncOut2> domains = datasyncout2Service.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(datasyncout2Mapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public DataSyncOut2 getEntity(){
        return new DataSyncOut2();
    }

}
