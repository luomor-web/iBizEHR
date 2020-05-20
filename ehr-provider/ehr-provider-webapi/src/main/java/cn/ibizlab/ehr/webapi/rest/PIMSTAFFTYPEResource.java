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
import cn.ibizlab.ehr.core.pim.domain.PIMSTAFFTYPE;
import cn.ibizlab.ehr.core.pim.service.IPIMSTAFFTYPEService;
import cn.ibizlab.ehr.core.pim.filter.PIMSTAFFTYPESearchContext;




@Slf4j
@Api(tags = {"PIMSTAFFTYPE" })
@RestController("WebApi-pimstafftype")
@RequestMapping("")
public class PIMSTAFFTYPEResource {

    @Autowired
    private IPIMSTAFFTYPEService pimstafftypeService;

    @Autowired
    @Lazy
    private PIMSTAFFTYPEMapping pimstafftypeMapping;




    @ApiOperation(value = "CheckKey", tags = {"PIMSTAFFTYPE" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimstafftypes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMSTAFFTYPEDTO pimstafftypedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimstafftypeService.checkKey(pimstafftypeMapping.toDomain(pimstafftypedto)));
    }




    @PreAuthorize("hasPermission(#pimstafftype_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PIMSTAFFTYPE" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimstafftypes/{pimstafftype_id}")
    public ResponseEntity<PIMSTAFFTYPEDTO> get(@PathVariable("pimstafftype_id") String pimstafftype_id) {
        PIMSTAFFTYPE domain = pimstafftypeService.get(pimstafftype_id);
        PIMSTAFFTYPEDTO dto = pimstafftypeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "GetDraft", tags = {"PIMSTAFFTYPE" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimstafftypes/getdraft")
    public ResponseEntity<PIMSTAFFTYPEDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimstafftypeMapping.toDto(pimstafftypeService.getDraft(new PIMSTAFFTYPE())));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PIMSTAFFTYPE" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimstafftypes")
    @Transactional
    public ResponseEntity<PIMSTAFFTYPEDTO> create(@RequestBody PIMSTAFFTYPEDTO pimstafftypedto) {
        PIMSTAFFTYPE domain = pimstafftypeMapping.toDomain(pimstafftypedto);
		pimstafftypeService.create(domain);
        PIMSTAFFTYPEDTO dto = pimstafftypeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PIMSTAFFTYPE" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimstafftypes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMSTAFFTYPEDTO> pimstafftypedtos) {
        pimstafftypeService.createBatch(pimstafftypeMapping.toDomain(pimstafftypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pimstafftype_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"PIMSTAFFTYPE" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimstafftypes/{pimstafftype_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimstafftype_id") String pimstafftype_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimstafftypeService.remove(pimstafftype_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PIMSTAFFTYPE" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimstafftypes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimstafftypeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"PIMSTAFFTYPE" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimstafftypes/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMSTAFFTYPEDTO pimstafftypedto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimstafftypeService.save(pimstafftypeMapping.toDomain(pimstafftypedto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PIMSTAFFTYPE" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimstafftypes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMSTAFFTYPEDTO> pimstafftypedtos) {
        pimstafftypeService.saveBatch(pimstafftypeMapping.toDomain(pimstafftypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pimstafftype_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PIMSTAFFTYPE" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimstafftypes/{pimstafftype_id}")
    @Transactional
    public ResponseEntity<PIMSTAFFTYPEDTO> update(@PathVariable("pimstafftype_id") String pimstafftype_id, @RequestBody PIMSTAFFTYPEDTO pimstafftypedto) {
		PIMSTAFFTYPE domain = pimstafftypeMapping.toDomain(pimstafftypedto);
        domain.setPimstafftypeid(pimstafftype_id);
		pimstafftypeService.update(domain);
		PIMSTAFFTYPEDTO dto = pimstafftypeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pimstafftype_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMSTAFFTYPE" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimstafftypes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMSTAFFTYPEDTO> pimstafftypedtos) {
        pimstafftypeService.updateBatch(pimstafftypeMapping.toDomain(pimstafftypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMSTAFFTYPE-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMSTAFFTYPE" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimstafftypes/fetchdefault")
	public ResponseEntity<List<PIMSTAFFTYPEDTO>> fetchDefault(PIMSTAFFTYPESearchContext context) {
        Page<PIMSTAFFTYPE> domains = pimstafftypeService.searchDefault(context) ;
        List<PIMSTAFFTYPEDTO> list = pimstafftypeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMSTAFFTYPE-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMSTAFFTYPE" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimstafftypes/searchdefault")
	public ResponseEntity<Page<PIMSTAFFTYPEDTO>> searchDefault(@RequestBody PIMSTAFFTYPESearchContext context) {
        Page<PIMSTAFFTYPE> domains = pimstafftypeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimstafftypeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMSTAFFTYPE-YPZ-all')")
	@ApiOperation(value = "fetch应聘者专用", tags = {"PIMSTAFFTYPE" } ,notes = "fetch应聘者专用")
    @RequestMapping(method= RequestMethod.GET , value="/pimstafftypes/fetchypz")
	public ResponseEntity<List<PIMSTAFFTYPEDTO>> fetchYPZ(PIMSTAFFTYPESearchContext context) {
        Page<PIMSTAFFTYPE> domains = pimstafftypeService.searchYPZ(context) ;
        List<PIMSTAFFTYPEDTO> list = pimstafftypeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMSTAFFTYPE-YPZ-all')")
	@ApiOperation(value = "search应聘者专用", tags = {"PIMSTAFFTYPE" } ,notes = "search应聘者专用")
    @RequestMapping(method= RequestMethod.POST , value="/pimstafftypes/searchypz")
	public ResponseEntity<Page<PIMSTAFFTYPEDTO>> searchYPZ(@RequestBody PIMSTAFFTYPESearchContext context) {
        Page<PIMSTAFFTYPE> domains = pimstafftypeService.searchYPZ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimstafftypeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PIMSTAFFTYPE getEntity(){
        return new PIMSTAFFTYPE();
    }

}
