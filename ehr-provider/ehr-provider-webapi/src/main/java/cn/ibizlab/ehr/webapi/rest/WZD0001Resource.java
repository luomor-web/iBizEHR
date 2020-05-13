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
import cn.ibizlab.ehr.core.pcm.domain.WZD0001;
import cn.ibizlab.ehr.core.pcm.service.IWZD0001Service;
import cn.ibizlab.ehr.core.pcm.filter.WZD0001SearchContext;




@Slf4j
@Api(tags = {"WZD0001" })
@RestController("WebApi-wzd0001")
@RequestMapping("")
public class WZD0001Resource {

    @Autowired
    private IWZD0001Service wzd0001Service;

    @Autowired
    @Lazy
    private WZD0001Mapping wzd0001Mapping;




    @PreAuthorize("hasPermission('Remove',{#wzd0001_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"WZD0001" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wzd0001s/{wzd0001_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("wzd0001_id") String wzd0001_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wzd0001Service.remove(wzd0001_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"WZD0001" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wzd0001s/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wzd0001Service.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"WZD0001" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/wzd0001s/getdraft")
    public ResponseEntity<WZD0001DTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wzd0001Mapping.toDto(wzd0001Service.getDraft(new WZD0001())));
    }




    @ApiOperation(value = "Save", tags = {"WZD0001" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/wzd0001s/save")
    public ResponseEntity<Boolean> save(@RequestBody WZD0001DTO wzd0001dto) {
        return ResponseEntity.status(HttpStatus.OK).body(wzd0001Service.save(wzd0001Mapping.toDomain(wzd0001dto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"WZD0001" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wzd0001s/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WZD0001DTO> wzd0001dtos) {
        wzd0001Service.saveBatch(wzd0001Mapping.toDomain(wzd0001dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#wzd0001_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"WZD0001" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/wzd0001s/{wzd0001_id}")
    public ResponseEntity<WZD0001DTO> get(@PathVariable("wzd0001_id") String wzd0001_id) {
        WZD0001 domain = wzd0001Service.get(wzd0001_id);
        WZD0001DTO dto = wzd0001Mapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#wzd0001_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"WZD0001" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/wzd0001s/{wzd0001_id}")
    @Transactional
    public ResponseEntity<WZD0001DTO> update(@PathVariable("wzd0001_id") String wzd0001_id, @RequestBody WZD0001DTO wzd0001dto) {
		WZD0001 domain = wzd0001Mapping.toDomain(wzd0001dto);
        domain.setWzd0001id(wzd0001_id);
		wzd0001Service.update(domain);
		WZD0001DTO dto = wzd0001Mapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#wzd0001_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"WZD0001" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/wzd0001s/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WZD0001DTO> wzd0001dtos) {
        wzd0001Service.updateBatch(wzd0001Mapping.toDomain(wzd0001dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"WZD0001" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/wzd0001s/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WZD0001DTO wzd0001dto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wzd0001Service.checkKey(wzd0001Mapping.toDomain(wzd0001dto)));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"WZD0001" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/wzd0001s")
    @Transactional
    public ResponseEntity<WZD0001DTO> create(@RequestBody WZD0001DTO wzd0001dto) {
        WZD0001 domain = wzd0001Mapping.toDomain(wzd0001dto);
		wzd0001Service.create(domain);
        WZD0001DTO dto = wzd0001Mapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"WZD0001" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wzd0001s/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WZD0001DTO> wzd0001dtos) {
        wzd0001Service.createBatch(wzd0001Mapping.toDomain(wzd0001dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "刷新人数", tags = {"WZD0001" },  notes = "刷新人数")
	@RequestMapping(method = RequestMethod.PUT, value = "/wzd0001s/{wzd0001_id}/updatepeoplenum")
    @Transactional
    public ResponseEntity<WZD0001DTO> updatePeopleNum(@PathVariable("wzd0001_id") String wzd0001_id, @RequestBody WZD0001DTO wzd0001dto) {
        WZD0001 wzd0001 = wzd0001Mapping.toDomain(wzd0001dto);
        wzd0001 = wzd0001Service.updatePeopleNum(wzd0001);
        wzd0001dto = wzd0001Mapping.toDto(wzd0001);
        return ResponseEntity.status(HttpStatus.OK).body(wzd0001dto);
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"WZD0001" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wzd0001s/fetchdefault")
	public ResponseEntity<List<WZD0001DTO>> fetchDefault(WZD0001SearchContext context) {
        Page<WZD0001> domains = wzd0001Service.searchDefault(context) ;
        List<WZD0001DTO> list = wzd0001Mapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"WZD0001" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wzd0001s/searchdefault")
	public ResponseEntity<Page<WZD0001DTO>> searchDefault(WZD0001SearchContext context) {
        Page<WZD0001> domains = wzd0001Service.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wzd0001Mapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public WZD0001 getEntity(){
        return new WZD0001();
    }

}