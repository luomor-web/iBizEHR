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
import cn.ibizlab.ehr.core.pim.domain.PIMEXAMINATIONRESULTS;
import cn.ibizlab.ehr.core.pim.service.IPIMEXAMINATIONRESULTSService;
import cn.ibizlab.ehr.core.pim.filter.PIMEXAMINATIONRESULTSSearchContext;

@Slf4j
@Api(tags = {"PIMEXAMINATIONRESULTS" })
@RestController("WebApi-pimexaminationresults")
@RequestMapping("")
public class PIMEXAMINATIONRESULTSResource {

    @Autowired
    private IPIMEXAMINATIONRESULTSService pimexaminationresultsService;

    @Autowired
    @Lazy
    public PIMEXAMINATIONRESULTSMapping pimexaminationresultsMapping;

    public PIMEXAMINATIONRESULTSDTO permissionDTO=new PIMEXAMINATIONRESULTSDTO();

    @PreAuthorize("hasPermission(#pimexaminationresults_id,'Update',{'Sql',this.pimexaminationresultsMapping,#pimexaminationresultsdto})")
    @ApiOperation(value = "Update", tags = {"PIMEXAMINATIONRESULTS" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimexaminationresults/{pimexaminationresults_id}")
    @Transactional
    public ResponseEntity<PIMEXAMINATIONRESULTSDTO> update(@PathVariable("pimexaminationresults_id") String pimexaminationresults_id, @RequestBody PIMEXAMINATIONRESULTSDTO pimexaminationresultsdto) {
		PIMEXAMINATIONRESULTS domain  = pimexaminationresultsMapping.toDomain(pimexaminationresultsdto);
        domain .setPimexaminationresultsid(pimexaminationresults_id);
		pimexaminationresultsService.update(domain );
		PIMEXAMINATIONRESULTSDTO dto = pimexaminationresultsMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.pimexaminationresultsMapping,#pimexaminationresultsdtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMEXAMINATIONRESULTS" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimexaminationresults/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMEXAMINATIONRESULTSDTO> pimexaminationresultsdtos) {
        pimexaminationresultsService.updateBatch(pimexaminationresultsMapping.toDomain(pimexaminationresultsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.pimexaminationresultsMapping,#pimexaminationresultsdto})")
    @ApiOperation(value = "Save", tags = {"PIMEXAMINATIONRESULTS" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexaminationresults/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMEXAMINATIONRESULTSDTO pimexaminationresultsdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimexaminationresultsService.save(pimexaminationresultsMapping.toDomain(pimexaminationresultsdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.pimexaminationresultsMapping,#pimexaminationresultsdtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PIMEXAMINATIONRESULTS" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexaminationresults/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMEXAMINATIONRESULTSDTO> pimexaminationresultsdtos) {
        pimexaminationresultsService.saveBatch(pimexaminationresultsMapping.toDomain(pimexaminationresultsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEXAMINATIONRESULTS-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PIMEXAMINATIONRESULTS" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexaminationresults/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMEXAMINATIONRESULTSDTO pimexaminationresultsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimexaminationresultsService.checkKey(pimexaminationresultsMapping.toDomain(pimexaminationresultsdto)));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pimexaminationresultsMapping,#pimexaminationresultsdto})")
    @ApiOperation(value = "Create", tags = {"PIMEXAMINATIONRESULTS" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexaminationresults")
    @Transactional
    public ResponseEntity<PIMEXAMINATIONRESULTSDTO> create(@RequestBody PIMEXAMINATIONRESULTSDTO pimexaminationresultsdto) {
        PIMEXAMINATIONRESULTS domain = pimexaminationresultsMapping.toDomain(pimexaminationresultsdto);
		pimexaminationresultsService.create(domain);
        PIMEXAMINATIONRESULTSDTO dto = pimexaminationresultsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.pimexaminationresultsMapping,#pimexaminationresultsdtos})")
    @ApiOperation(value = "createBatch", tags = {"PIMEXAMINATIONRESULTS" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexaminationresults/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMEXAMINATIONRESULTSDTO> pimexaminationresultsdtos) {
        pimexaminationresultsService.createBatch(pimexaminationresultsMapping.toDomain(pimexaminationresultsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pimexaminationresults_id,'Remove',{'Sql',this.pimexaminationresultsMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PIMEXAMINATIONRESULTS" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimexaminationresults/{pimexaminationresults_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimexaminationresults_id") String pimexaminationresults_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimexaminationresultsService.remove(pimexaminationresults_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.pimexaminationresultsMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PIMEXAMINATIONRESULTS" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimexaminationresults/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimexaminationresultsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEXAMINATIONRESULTS-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PIMEXAMINATIONRESULTS" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimexaminationresults/getdraft")
    public ResponseEntity<PIMEXAMINATIONRESULTSDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimexaminationresultsMapping.toDto(pimexaminationresultsService.getDraft(new PIMEXAMINATIONRESULTS())));
    }

    @PreAuthorize("hasPermission(#pimexaminationresults_id,'Get',{'Sql',this.pimexaminationresultsMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PIMEXAMINATIONRESULTS" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimexaminationresults/{pimexaminationresults_id}")
    public ResponseEntity<PIMEXAMINATIONRESULTSDTO> get(@PathVariable("pimexaminationresults_id") String pimexaminationresults_id) {
        PIMEXAMINATIONRESULTS domain = pimexaminationresultsService.get(pimexaminationresults_id);
        PIMEXAMINATIONRESULTSDTO dto = pimexaminationresultsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEXAMINATIONRESULTS-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMEXAMINATIONRESULTS" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimexaminationresults/fetchdefault")
	public ResponseEntity<List<PIMEXAMINATIONRESULTSDTO>> fetchDefault(PIMEXAMINATIONRESULTSSearchContext context) {
        Page<PIMEXAMINATIONRESULTS> domains = pimexaminationresultsService.searchDefault(context) ;
        List<PIMEXAMINATIONRESULTSDTO> list = pimexaminationresultsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMEXAMINATIONRESULTS-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMEXAMINATIONRESULTS" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimexaminationresults/searchdefault")
	public ResponseEntity<Page<PIMEXAMINATIONRESULTSDTO>> searchDefault(@RequestBody PIMEXAMINATIONRESULTSSearchContext context) {
        Page<PIMEXAMINATIONRESULTS> domains = pimexaminationresultsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimexaminationresultsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
