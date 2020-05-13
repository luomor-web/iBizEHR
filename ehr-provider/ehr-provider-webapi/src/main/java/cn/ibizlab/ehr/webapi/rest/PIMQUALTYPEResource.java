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
import cn.ibizlab.ehr.core.pim.domain.PIMQUALTYPE;
import cn.ibizlab.ehr.core.pim.service.IPIMQUALTYPEService;
import cn.ibizlab.ehr.core.pim.filter.PIMQUALTYPESearchContext;




@Slf4j
@Api(tags = {"PIMQUALTYPE" })
@RestController("WebApi-pimqualtype")
@RequestMapping("")
public class PIMQUALTYPEResource {

    @Autowired
    private IPIMQUALTYPEService pimqualtypeService;

    @Autowired
    @Lazy
    private PIMQUALTYPEMapping pimqualtypeMapping;




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PIMQUALTYPE" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimqualtypes")
    @Transactional
    public ResponseEntity<PIMQUALTYPEDTO> create(@RequestBody PIMQUALTYPEDTO pimqualtypedto) {
        PIMQUALTYPE domain = pimqualtypeMapping.toDomain(pimqualtypedto);
		pimqualtypeService.create(domain);
        PIMQUALTYPEDTO dto = pimqualtypeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PIMQUALTYPE" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimqualtypes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMQUALTYPEDTO> pimqualtypedtos) {
        pimqualtypeService.createBatch(pimqualtypeMapping.toDomain(pimqualtypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"PIMQUALTYPE" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimqualtypes/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMQUALTYPEDTO pimqualtypedto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimqualtypeService.save(pimqualtypeMapping.toDomain(pimqualtypedto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PIMQUALTYPE" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimqualtypes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMQUALTYPEDTO> pimqualtypedtos) {
        pimqualtypeService.saveBatch(pimqualtypeMapping.toDomain(pimqualtypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"PIMQUALTYPE" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimqualtypes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMQUALTYPEDTO pimqualtypedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimqualtypeService.checkKey(pimqualtypeMapping.toDomain(pimqualtypedto)));
    }




    @PreAuthorize("hasPermission(#pimqualtype_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PIMQUALTYPE" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimqualtypes/{pimqualtype_id}")
    @Transactional
    public ResponseEntity<PIMQUALTYPEDTO> update(@PathVariable("pimqualtype_id") String pimqualtype_id, @RequestBody PIMQUALTYPEDTO pimqualtypedto) {
		PIMQUALTYPE domain = pimqualtypeMapping.toDomain(pimqualtypedto);
        domain.setPimqualtypeid(pimqualtype_id);
		pimqualtypeService.update(domain);
		PIMQUALTYPEDTO dto = pimqualtypeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pimqualtype_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMQUALTYPE" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimqualtypes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMQUALTYPEDTO> pimqualtypedtos) {
        pimqualtypeService.updateBatch(pimqualtypeMapping.toDomain(pimqualtypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#pimqualtype_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PIMQUALTYPE" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimqualtypes/{pimqualtype_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimqualtype_id") String pimqualtype_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimqualtypeService.remove(pimqualtype_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PIMQUALTYPE" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimqualtypes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimqualtypeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pimqualtype_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PIMQUALTYPE" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimqualtypes/{pimqualtype_id}")
    public ResponseEntity<PIMQUALTYPEDTO> get(@PathVariable("pimqualtype_id") String pimqualtype_id) {
        PIMQUALTYPE domain = pimqualtypeService.get(pimqualtype_id);
        PIMQUALTYPEDTO dto = pimqualtypeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "GetDraft", tags = {"PIMQUALTYPE" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimqualtypes/getdraft")
    public ResponseEntity<PIMQUALTYPEDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimqualtypeMapping.toDto(pimqualtypeService.getDraft(new PIMQUALTYPE())));
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMQUALTYPE" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimqualtypes/fetchdefault")
	public ResponseEntity<List<PIMQUALTYPEDTO>> fetchDefault(PIMQUALTYPESearchContext context) {
        Page<PIMQUALTYPE> domains = pimqualtypeService.searchDefault(context) ;
        List<PIMQUALTYPEDTO> list = pimqualtypeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMQUALTYPE" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimqualtypes/searchdefault")
	public ResponseEntity<Page<PIMQUALTYPEDTO>> searchDefault(PIMQUALTYPESearchContext context) {
        Page<PIMQUALTYPE> domains = pimqualtypeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimqualtypeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PIMQUALTYPE getEntity(){
        return new PIMQUALTYPE();
    }

}
