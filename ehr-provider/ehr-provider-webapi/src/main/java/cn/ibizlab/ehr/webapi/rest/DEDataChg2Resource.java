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
import cn.ibizlab.ehr.core.common.domain.DEDataChg2;
import cn.ibizlab.ehr.core.common.service.IDEDataChg2Service;
import cn.ibizlab.ehr.core.common.filter.DEDataChg2SearchContext;




@Slf4j
@Api(tags = {"DEDataChg2" })
@RestController("WebApi-dedatachg2")
@RequestMapping("")
public class DEDataChg2Resource {

    @Autowired
    private IDEDataChg2Service dedatachg2Service;

    @Autowired
    @Lazy
    private DEDataChg2Mapping dedatachg2Mapping;




    @PreAuthorize("hasPermission('Remove',{#dedatachg2_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"DEDataChg2" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/dedatachg2s/{dedatachg2_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("dedatachg2_id") String dedatachg2_id) {
         return ResponseEntity.status(HttpStatus.OK).body(dedatachg2Service.remove(dedatachg2_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"DEDataChg2" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/dedatachg2s/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        dedatachg2Service.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#dedatachg2_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"DEDataChg2" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/dedatachg2s/{dedatachg2_id}")
    public ResponseEntity<DEDataChg2DTO> get(@PathVariable("dedatachg2_id") String dedatachg2_id) {
        DEDataChg2 domain = dedatachg2Service.get(dedatachg2_id);
        DEDataChg2DTO dto = dedatachg2Mapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#dedatachg2_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"DEDataChg2" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/dedatachg2s/{dedatachg2_id}")
    @Transactional
    public ResponseEntity<DEDataChg2DTO> update(@PathVariable("dedatachg2_id") String dedatachg2_id, @RequestBody DEDataChg2DTO dedatachg2dto) {
		DEDataChg2 domain = dedatachg2Mapping.toDomain(dedatachg2dto);
        domain.setDedatachg2id(dedatachg2_id);
		dedatachg2Service.update(domain);
		DEDataChg2DTO dto = dedatachg2Mapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#dedatachg2_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"DEDataChg2" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/dedatachg2s/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<DEDataChg2DTO> dedatachg2dtos) {
        dedatachg2Service.updateBatch(dedatachg2Mapping.toDomain(dedatachg2dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"DEDataChg2" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/dedatachg2s/getdraft")
    public ResponseEntity<DEDataChg2DTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(dedatachg2Mapping.toDto(dedatachg2Service.getDraft(new DEDataChg2())));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"DEDataChg2" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/dedatachg2s")
    @Transactional
    public ResponseEntity<DEDataChg2DTO> create(@RequestBody DEDataChg2DTO dedatachg2dto) {
        DEDataChg2 domain = dedatachg2Mapping.toDomain(dedatachg2dto);
		dedatachg2Service.create(domain);
        DEDataChg2DTO dto = dedatachg2Mapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"DEDataChg2" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/dedatachg2s/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<DEDataChg2DTO> dedatachg2dtos) {
        dedatachg2Service.createBatch(dedatachg2Mapping.toDomain(dedatachg2dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"DEDataChg2" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/dedatachg2s/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody DEDataChg2DTO dedatachg2dto) {
        return  ResponseEntity.status(HttpStatus.OK).body(dedatachg2Service.checkKey(dedatachg2Mapping.toDomain(dedatachg2dto)));
    }




    @ApiOperation(value = "Save", tags = {"DEDataChg2" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/dedatachg2s/save")
    public ResponseEntity<Boolean> save(@RequestBody DEDataChg2DTO dedatachg2dto) {
        return ResponseEntity.status(HttpStatus.OK).body(dedatachg2Service.save(dedatachg2Mapping.toDomain(dedatachg2dto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"DEDataChg2" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/dedatachg2s/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<DEDataChg2DTO> dedatachg2dtos) {
        dedatachg2Service.saveBatch(dedatachg2Mapping.toDomain(dedatachg2dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"DEDataChg2" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/dedatachg2s/fetchdefault")
	public ResponseEntity<List<DEDataChg2DTO>> fetchDefault(DEDataChg2SearchContext context) {
        Page<DEDataChg2> domains = dedatachg2Service.searchDefault(context) ;
        List<DEDataChg2DTO> list = dedatachg2Mapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"DEDataChg2" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/dedatachg2s/searchdefault")
	public ResponseEntity<Page<DEDataChg2DTO>> searchDefault(DEDataChg2SearchContext context) {
        Page<DEDataChg2> domains = dedatachg2Service.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(dedatachg2Mapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public DEDataChg2 getEntity(){
        return new DEDataChg2();
    }

}
