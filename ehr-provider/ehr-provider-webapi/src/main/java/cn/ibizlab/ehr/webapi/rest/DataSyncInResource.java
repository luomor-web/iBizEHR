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
import cn.ibizlab.ehr.core.common.domain.DataSyncIn;
import cn.ibizlab.ehr.core.common.service.IDataSyncInService;
import cn.ibizlab.ehr.core.common.filter.DataSyncInSearchContext;




@Slf4j
@Api(tags = {"DataSyncIn" })
@RestController("WebApi-datasyncin")
@RequestMapping("")
public class DataSyncInResource {

    @Autowired
    private IDataSyncInService datasyncinService;

    @Autowired
    @Lazy
    public DataSyncInMapping datasyncinMapping;

    public DataSyncInDTO permissionDTO=new DataSyncInDTO();




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-DataSyncIn-Save-all')")
    @ApiOperation(value = "Save", tags = {"DataSyncIn" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/datasyncins/save")
    public ResponseEntity<Boolean> save(@RequestBody DataSyncInDTO datasyncindto) {
        return ResponseEntity.status(HttpStatus.OK).body(datasyncinService.save(datasyncinMapping.toDomain(datasyncindto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"DataSyncIn" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/datasyncins/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<DataSyncInDTO> datasyncindtos) {
        datasyncinService.saveBatch(datasyncinMapping.toDomain(datasyncindtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-DataSyncIn-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"DataSyncIn" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/datasyncins/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody DataSyncInDTO datasyncindto) {
        return  ResponseEntity.status(HttpStatus.OK).body(datasyncinService.checkKey(datasyncinMapping.toDomain(datasyncindto)));
    }




    @PreAuthorize("hasPermission(#datasyncin_id,'Update',{'Sql',this.datasyncinMapping,#datasyncindto})")
    @ApiOperation(value = "Update", tags = {"DataSyncIn" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/datasyncins/{datasyncin_id}")
    @Transactional
    public ResponseEntity<DataSyncInDTO> update(@PathVariable("datasyncin_id") String datasyncin_id, @RequestBody DataSyncInDTO datasyncindto) {
		DataSyncIn domain = datasyncinMapping.toDomain(datasyncindto);
        domain.setDatasyncinid(datasyncin_id);
		datasyncinService.update(domain);
		DataSyncInDTO dto = datasyncinMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"DataSyncIn" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/datasyncins/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<DataSyncInDTO> datasyncindtos) {
        datasyncinService.updateBatch(datasyncinMapping.toDomain(datasyncindtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#datasyncin_id,'Get',{'Sql',this.datasyncinMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"DataSyncIn" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/datasyncins/{datasyncin_id}")
    public ResponseEntity<DataSyncInDTO> get(@PathVariable("datasyncin_id") String datasyncin_id) {
        DataSyncIn domain = datasyncinService.get(datasyncin_id);
        DataSyncInDTO dto = datasyncinMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-DataSyncIn-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"DataSyncIn" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/datasyncins/getdraft")
    public ResponseEntity<DataSyncInDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(datasyncinMapping.toDto(datasyncinService.getDraft(new DataSyncIn())));
    }




    @PreAuthorize("hasPermission(#datasyncin_id,'Remove',{'Sql',this.datasyncinMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"DataSyncIn" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/datasyncins/{datasyncin_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("datasyncin_id") String datasyncin_id) {
         return ResponseEntity.status(HttpStatus.OK).body(datasyncinService.remove(datasyncin_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"DataSyncIn" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/datasyncins/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        datasyncinService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.datasyncinMapping,#datasyncindto})")
    @ApiOperation(value = "Create", tags = {"DataSyncIn" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/datasyncins")
    @Transactional
    public ResponseEntity<DataSyncInDTO> create(@RequestBody DataSyncInDTO datasyncindto) {
        DataSyncIn domain = datasyncinMapping.toDomain(datasyncindto);
		datasyncinService.create(domain);
        DataSyncInDTO dto = datasyncinMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"DataSyncIn" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/datasyncins/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<DataSyncInDTO> datasyncindtos) {
        datasyncinService.createBatch(datasyncinMapping.toDomain(datasyncindtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-DataSyncIn-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"DataSyncIn" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/datasyncins/fetchdefault")
	public ResponseEntity<List<DataSyncInDTO>> fetchDefault(DataSyncInSearchContext context) {
        Page<DataSyncIn> domains = datasyncinService.searchDefault(context) ;
        List<DataSyncInDTO> list = datasyncinMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-DataSyncIn-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"DataSyncIn" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/datasyncins/searchdefault")
	public ResponseEntity<Page<DataSyncInDTO>> searchDefault(@RequestBody DataSyncInSearchContext context) {
        Page<DataSyncIn> domains = datasyncinService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(datasyncinMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


