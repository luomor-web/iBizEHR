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
import cn.ibizlab.ehr.core.trm.domain.TRMTRAINADDRESS;
import cn.ibizlab.ehr.core.trm.service.ITRMTRAINADDRESSService;
import cn.ibizlab.ehr.core.trm.filter.TRMTRAINADDRESSSearchContext;




@Slf4j
@Api(tags = {"TRMTRAINADDRESS" })
@RestController("WebApi-trmtrainaddress")
@RequestMapping("")
public class TRMTRAINADDRESSResource {

    @Autowired
    private ITRMTRAINADDRESSService trmtrainaddressService;

    @Autowired
    @Lazy
    private TRMTRAINADDRESSMapping trmtrainaddressMapping;




    @ApiOperation(value = "Save", tags = {"TRMTRAINADDRESS" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainaddresses/save")
    public ResponseEntity<Boolean> save(@RequestBody TRMTRAINADDRESSDTO trmtrainaddressdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainaddressService.save(trmtrainaddressMapping.toDomain(trmtrainaddressdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"TRMTRAINADDRESS" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainaddresses/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TRMTRAINADDRESSDTO> trmtrainaddressdtos) {
        trmtrainaddressService.saveBatch(trmtrainaddressMapping.toDomain(trmtrainaddressdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#trmtrainaddress_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"TRMTRAINADDRESS" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainaddresses/{trmtrainaddress_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtrainaddressService.remove(trmtrainaddress_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"TRMTRAINADDRESS" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainaddresses/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtrainaddressService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"TRMTRAINADDRESS" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainaddresses/getdraft")
    public ResponseEntity<TRMTRAINADDRESSDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainaddressMapping.toDto(trmtrainaddressService.getDraft(new TRMTRAINADDRESS())));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"TRMTRAINADDRESS" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainaddresses")
    @Transactional
    public ResponseEntity<TRMTRAINADDRESSDTO> create(@RequestBody TRMTRAINADDRESSDTO trmtrainaddressdto) {
        TRMTRAINADDRESS domain = trmtrainaddressMapping.toDomain(trmtrainaddressdto);
		trmtrainaddressService.create(domain);
        TRMTRAINADDRESSDTO dto = trmtrainaddressMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"TRMTRAINADDRESS" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainaddresses/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TRMTRAINADDRESSDTO> trmtrainaddressdtos) {
        trmtrainaddressService.createBatch(trmtrainaddressMapping.toDomain(trmtrainaddressdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#trmtrainaddress_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"TRMTRAINADDRESS" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainaddresses/{trmtrainaddress_id}")
    @Transactional
    public ResponseEntity<TRMTRAINADDRESSDTO> update(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id, @RequestBody TRMTRAINADDRESSDTO trmtrainaddressdto) {
		TRMTRAINADDRESS domain = trmtrainaddressMapping.toDomain(trmtrainaddressdto);
        domain.setTrmtrainaddressid(trmtrainaddress_id);
		trmtrainaddressService.update(domain);
		TRMTRAINADDRESSDTO dto = trmtrainaddressMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#trmtrainaddress_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"TRMTRAINADDRESS" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainaddresses/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TRMTRAINADDRESSDTO> trmtrainaddressdtos) {
        trmtrainaddressService.updateBatch(trmtrainaddressMapping.toDomain(trmtrainaddressdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#trmtrainaddress_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"TRMTRAINADDRESS" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainaddresses/{trmtrainaddress_id}")
    public ResponseEntity<TRMTRAINADDRESSDTO> get(@PathVariable("trmtrainaddress_id") String trmtrainaddress_id) {
        TRMTRAINADDRESS domain = trmtrainaddressService.get(trmtrainaddress_id);
        TRMTRAINADDRESSDTO dto = trmtrainaddressMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "CheckKey", tags = {"TRMTRAINADDRESS" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainaddresses/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TRMTRAINADDRESSDTO trmtrainaddressdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainaddressService.checkKey(trmtrainaddressMapping.toDomain(trmtrainaddressdto)));
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TRMTRAINADDRESS" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainaddresses/fetchdefault")
	public ResponseEntity<List<TRMTRAINADDRESSDTO>> fetchDefault(TRMTRAINADDRESSSearchContext context) {
        Page<TRMTRAINADDRESS> domains = trmtrainaddressService.searchDefault(context) ;
        List<TRMTRAINADDRESSDTO> list = trmtrainaddressMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"TRMTRAINADDRESS" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainaddresses/searchdefault")
	public ResponseEntity<Page<TRMTRAINADDRESSDTO>> searchDefault(TRMTRAINADDRESSSearchContext context) {
        Page<TRMTRAINADDRESS> domains = trmtrainaddressService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainaddressMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public TRMTRAINADDRESS getEntity(){
        return new TRMTRAINADDRESS();
    }

}
