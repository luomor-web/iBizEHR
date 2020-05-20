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
import cn.ibizlab.ehr.core.pim.domain.PIMENCLOSURE;
import cn.ibizlab.ehr.core.pim.service.IPIMENCLOSUREService;
import cn.ibizlab.ehr.core.pim.filter.PIMENCLOSURESearchContext;




@Slf4j
@Api(tags = {"PIMENCLOSURE" })
@RestController("WebApi-pimenclosure")
@RequestMapping("")
public class PIMENCLOSUREResource {

    @Autowired
    private IPIMENCLOSUREService pimenclosureService;

    @Autowired
    @Lazy
    private PIMENCLOSUREMapping pimenclosureMapping;




    @ApiOperation(value = "GetDraft", tags = {"PIMENCLOSURE" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimenclosures/getdraft")
    public ResponseEntity<PIMENCLOSUREDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimenclosureMapping.toDto(pimenclosureService.getDraft(new PIMENCLOSURE())));
    }




    @ApiOperation(value = "CheckKey", tags = {"PIMENCLOSURE" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimenclosures/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMENCLOSUREDTO pimenclosuredto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimenclosureService.checkKey(pimenclosureMapping.toDomain(pimenclosuredto)));
    }




    @ApiOperation(value = "Save", tags = {"PIMENCLOSURE" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimenclosures/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMENCLOSUREDTO pimenclosuredto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimenclosureService.save(pimenclosureMapping.toDomain(pimenclosuredto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PIMENCLOSURE" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimenclosures/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMENCLOSUREDTO> pimenclosuredtos) {
        pimenclosureService.saveBatch(pimenclosureMapping.toDomain(pimenclosuredtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pimenclosure_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PIMENCLOSURE" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimenclosures/{pimenclosure_id}")
    @Transactional
    public ResponseEntity<PIMENCLOSUREDTO> update(@PathVariable("pimenclosure_id") String pimenclosure_id, @RequestBody PIMENCLOSUREDTO pimenclosuredto) {
		PIMENCLOSURE domain = pimenclosureMapping.toDomain(pimenclosuredto);
        domain.setPimenclosureid(pimenclosure_id);
		pimenclosureService.update(domain);
		PIMENCLOSUREDTO dto = pimenclosureMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pimenclosure_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMENCLOSURE" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimenclosures/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMENCLOSUREDTO> pimenclosuredtos) {
        pimenclosureService.updateBatch(pimenclosureMapping.toDomain(pimenclosuredtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#pimenclosure_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PIMENCLOSURE" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimenclosures/{pimenclosure_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimenclosure_id") String pimenclosure_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimenclosureService.remove(pimenclosure_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PIMENCLOSURE" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimenclosures/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimenclosureService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PIMENCLOSURE" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimenclosures")
    @Transactional
    public ResponseEntity<PIMENCLOSUREDTO> create(@RequestBody PIMENCLOSUREDTO pimenclosuredto) {
        PIMENCLOSURE domain = pimenclosureMapping.toDomain(pimenclosuredto);
		pimenclosureService.create(domain);
        PIMENCLOSUREDTO dto = pimenclosureMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PIMENCLOSURE" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimenclosures/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMENCLOSUREDTO> pimenclosuredtos) {
        pimenclosureService.createBatch(pimenclosureMapping.toDomain(pimenclosuredtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pimenclosure_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PIMENCLOSURE" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimenclosures/{pimenclosure_id}")
    public ResponseEntity<PIMENCLOSUREDTO> get(@PathVariable("pimenclosure_id") String pimenclosure_id) {
        PIMENCLOSURE domain = pimenclosureService.get(pimenclosure_id);
        PIMENCLOSUREDTO dto = pimenclosureMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

	@ApiOperation(value = "fetch应聘者附件预览", tags = {"PIMENCLOSURE" } ,notes = "fetch应聘者附件预览")
    @RequestMapping(method= RequestMethod.GET , value="/pimenclosures/fetchpcmprofile_fj")
	public ResponseEntity<List<PIMENCLOSUREDTO>> fetchPCMPROFILE_FJ(PIMENCLOSURESearchContext context) {
        Page<PIMENCLOSURE> domains = pimenclosureService.searchPCMPROFILE_FJ(context) ;
        List<PIMENCLOSUREDTO> list = pimenclosureMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search应聘者附件预览", tags = {"PIMENCLOSURE" } ,notes = "search应聘者附件预览")
    @RequestMapping(method= RequestMethod.POST , value="/pimenclosures/searchpcmprofile_fj")
	public ResponseEntity<Page<PIMENCLOSUREDTO>> searchPCMPROFILE_FJ(@RequestBody PIMENCLOSURESearchContext context) {
        Page<PIMENCLOSURE> domains = pimenclosureService.searchPCMPROFILE_FJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimenclosureMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMENCLOSURE" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimenclosures/fetchdefault")
	public ResponseEntity<List<PIMENCLOSUREDTO>> fetchDefault(PIMENCLOSURESearchContext context) {
        Page<PIMENCLOSURE> domains = pimenclosureService.searchDefault(context) ;
        List<PIMENCLOSUREDTO> list = pimenclosureMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"PIMENCLOSURE" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimenclosures/searchdefault")
	public ResponseEntity<Page<PIMENCLOSUREDTO>> searchDefault(@RequestBody PIMENCLOSURESearchContext context) {
        Page<PIMENCLOSURE> domains = pimenclosureService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimenclosureMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PIMENCLOSURE getEntity(){
        return new PIMENCLOSURE();
    }

}
