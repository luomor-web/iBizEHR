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
import cn.ibizlab.ehr.core.pim.domain.PIMOUTPUT;
import cn.ibizlab.ehr.core.pim.service.IPIMOUTPUTService;
import cn.ibizlab.ehr.core.pim.filter.PIMOUTPUTSearchContext;

@Slf4j
@Api(tags = {"PIMOUTPUT" })
@RestController("WebApi-pimoutput")
@RequestMapping("")
public class PIMOUTPUTResource {

    @Autowired
    private IPIMOUTPUTService pimoutputService;

    @Autowired
    @Lazy
    public PIMOUTPUTMapping pimoutputMapping;

    public PIMOUTPUTDTO permissionDTO=new PIMOUTPUTDTO();

    @PreAuthorize("hasPermission(#pimoutput_id,'Update',{'Sql',this.pimoutputMapping,#pimoutputdto})")
    @ApiOperation(value = "Update", tags = {"PIMOUTPUT" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimoutputs/{pimoutput_id}")
    @Transactional
    public ResponseEntity<PIMOUTPUTDTO> update(@PathVariable("pimoutput_id") String pimoutput_id, @RequestBody PIMOUTPUTDTO pimoutputdto) {
		PIMOUTPUT domain  = pimoutputMapping.toDomain(pimoutputdto);
        domain .setPimoutputid(pimoutput_id);
		pimoutputService.update(domain );
		PIMOUTPUTDTO dto = pimoutputMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.pimoutputMapping,#pimoutputdtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMOUTPUT" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimoutputs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMOUTPUTDTO> pimoutputdtos) {
        pimoutputService.updateBatch(pimoutputMapping.toDomain(pimoutputdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pimoutput_id,'Get',{'Sql',this.pimoutputMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PIMOUTPUT" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimoutputs/{pimoutput_id}")
    public ResponseEntity<PIMOUTPUTDTO> get(@PathVariable("pimoutput_id") String pimoutput_id) {
        PIMOUTPUT domain = pimoutputService.get(pimoutput_id);
        PIMOUTPUTDTO dto = pimoutputMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pimoutputMapping,#pimoutputdto})")
    @ApiOperation(value = "Create", tags = {"PIMOUTPUT" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimoutputs")
    @Transactional
    public ResponseEntity<PIMOUTPUTDTO> create(@RequestBody PIMOUTPUTDTO pimoutputdto) {
        PIMOUTPUT domain = pimoutputMapping.toDomain(pimoutputdto);
		pimoutputService.create(domain);
        PIMOUTPUTDTO dto = pimoutputMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.pimoutputMapping,#pimoutputdtos})")
    @ApiOperation(value = "createBatch", tags = {"PIMOUTPUT" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimoutputs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMOUTPUTDTO> pimoutputdtos) {
        pimoutputService.createBatch(pimoutputMapping.toDomain(pimoutputdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMOUTPUT-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PIMOUTPUT" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimoutputs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMOUTPUTDTO pimoutputdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimoutputService.checkKey(pimoutputMapping.toDomain(pimoutputdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMOUTPUT-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PIMOUTPUT" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimoutputs/getdraft")
    public ResponseEntity<PIMOUTPUTDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimoutputMapping.toDto(pimoutputService.getDraft(new PIMOUTPUT())));
    }

    @PreAuthorize("hasPermission(#pimoutput_id,'Remove',{'Sql',this.pimoutputMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PIMOUTPUT" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimoutputs/{pimoutput_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimoutput_id") String pimoutput_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimoutputService.remove(pimoutput_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.pimoutputMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PIMOUTPUT" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimoutputs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimoutputService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.pimoutputMapping,#pimoutputdto})")
    @ApiOperation(value = "Save", tags = {"PIMOUTPUT" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimoutputs/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMOUTPUTDTO pimoutputdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimoutputService.save(pimoutputMapping.toDomain(pimoutputdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.pimoutputMapping,#pimoutputdtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PIMOUTPUT" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimoutputs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMOUTPUTDTO> pimoutputdtos) {
        pimoutputService.saveBatch(pimoutputMapping.toDomain(pimoutputdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMOUTPUT-CurOrg-all')")
	@ApiOperation(value = "fetch当前组织范围", tags = {"PIMOUTPUT" } ,notes = "fetch当前组织范围")
    @RequestMapping(method= RequestMethod.GET , value="/pimoutputs/fetchcurorg")
	public ResponseEntity<List<PIMOUTPUTDTO>> fetchCurOrg(PIMOUTPUTSearchContext context) {
        Page<PIMOUTPUT> domains = pimoutputService.searchCurOrg(context) ;
        List<PIMOUTPUTDTO> list = pimoutputMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMOUTPUT-CurOrg-all')")
	@ApiOperation(value = "search当前组织范围", tags = {"PIMOUTPUT" } ,notes = "search当前组织范围")
    @RequestMapping(method= RequestMethod.POST , value="/pimoutputs/searchcurorg")
	public ResponseEntity<Page<PIMOUTPUTDTO>> searchCurOrg(@RequestBody PIMOUTPUTSearchContext context) {
        Page<PIMOUTPUT> domains = pimoutputService.searchCurOrg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimoutputMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMOUTPUT-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMOUTPUT" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimoutputs/fetchdefault")
	public ResponseEntity<List<PIMOUTPUTDTO>> fetchDefault(PIMOUTPUTSearchContext context) {
        Page<PIMOUTPUT> domains = pimoutputService.searchDefault(context) ;
        List<PIMOUTPUTDTO> list = pimoutputMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMOUTPUT-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PIMOUTPUT" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimoutputs/searchdefault")
	public ResponseEntity<Page<PIMOUTPUTDTO>> searchDefault(@RequestBody PIMOUTPUTSearchContext context) {
        Page<PIMOUTPUT> domains = pimoutputService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimoutputMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMOUTPUT-REP_OUTPUT-all')")
	@ApiOperation(value = "fetch人均产值", tags = {"PIMOUTPUT" } ,notes = "fetch人均产值")
    @RequestMapping(method= RequestMethod.GET , value="/pimoutputs/fetchrep_output")
	public ResponseEntity<List<HashMap>> fetchREP_OUTPUT(PIMOUTPUTSearchContext context) {
        Page<HashMap> domains = pimoutputService.searchREP_OUTPUT(context) ;
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(domains.getContent());
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMOUTPUT-REP_OUTPUT-all')")
	@ApiOperation(value = "search人均产值", tags = {"PIMOUTPUT" } ,notes = "search人均产值")
    @RequestMapping(method= RequestMethod.POST , value="/pimoutputs/searchrep_output")
	public ResponseEntity<Page<HashMap>> searchREP_OUTPUT(@RequestBody PIMOUTPUTSearchContext context) {
        Page<HashMap> domains = pimoutputService.searchREP_OUTPUT(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(domains.getContent(), context.getPageable(), domains.getTotalElements()));
	}
}
