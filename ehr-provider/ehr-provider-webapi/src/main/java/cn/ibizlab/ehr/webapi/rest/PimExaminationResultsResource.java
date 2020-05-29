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
import org.springframework.security.access.prepost.PostAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import cn.ibizlab.ehr.webapi.dto.*;
import cn.ibizlab.ehr.webapi.mapping.*;
import cn.ibizlab.ehr.core.pim.domain.PimExaminationResults;
import cn.ibizlab.ehr.core.pim.service.IPimExaminationResultsService;
import cn.ibizlab.ehr.core.pim.filter.PimExaminationResultsSearchContext;

@Slf4j
@Api(tags = {"PimExaminationResults" })
@RestController("WebApi-pimexaminationresults")
@RequestMapping("")
public class PimExaminationResultsResource {

    @Autowired
    public IPimExaminationResultsService pimexaminationresultsService;

    @Autowired
    @Lazy
    public PimExaminationResultsMapping pimexaminationresultsMapping;

    @PreAuthorize("hasPermission(this.pimexaminationresultsService.get(#pimexaminationresults_id),'ehr-PimExaminationResults-Update')")
    @ApiOperation(value = "Update", tags = {"PimExaminationResults" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimexaminationresults/{pimexaminationresults_id}")
    @Transactional
    public ResponseEntity<PimExaminationResultsDTO> update(@PathVariable("pimexaminationresults_id") String pimexaminationresults_id, @RequestBody PimExaminationResultsDTO pimexaminationresultsdto) {
		PimExaminationResults domain  = pimexaminationresultsMapping.toDomain(pimexaminationresultsdto);
        domain .setPimexaminationresultsid(pimexaminationresults_id);
		pimexaminationresultsService.update(domain );
		PimExaminationResultsDTO dto = pimexaminationresultsMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimexaminationresultsService.getPimexaminationresultsByEntities(this.pimexaminationresultsMapping.toDomain(#pimexaminationresultsdtos)),'ehr-PimExaminationResults-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PimExaminationResults" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimexaminationresults/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimExaminationResultsDTO> pimexaminationresultsdtos) {
        pimexaminationresultsService.updateBatch(pimexaminationresultsMapping.toDomain(pimexaminationresultsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimexaminationresultsMapping.toDomain(#pimexaminationresultsdto),'ehr-PimExaminationResults-Save')")
    @ApiOperation(value = "Save", tags = {"PimExaminationResults" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexaminationresults/save")
    public ResponseEntity<Boolean> save(@RequestBody PimExaminationResultsDTO pimexaminationresultsdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimexaminationresultsService.save(pimexaminationresultsMapping.toDomain(pimexaminationresultsdto)));
    }

    @PreAuthorize("hasPermission(this.pimexaminationresultsMapping.toDomain(#pimexaminationresultsdtos),'ehr-PimExaminationResults-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PimExaminationResults" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexaminationresults/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimExaminationResultsDTO> pimexaminationresultsdtos) {
        pimexaminationresultsService.saveBatch(pimexaminationresultsMapping.toDomain(pimexaminationresultsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"PimExaminationResults" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexaminationresults/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimExaminationResultsDTO pimexaminationresultsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimexaminationresultsService.checkKey(pimexaminationresultsMapping.toDomain(pimexaminationresultsdto)));
    }

    @PreAuthorize("hasPermission(this.pimexaminationresultsMapping.toDomain(#pimexaminationresultsdto),'ehr-PimExaminationResults-Create')")
    @ApiOperation(value = "Create", tags = {"PimExaminationResults" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexaminationresults")
    @Transactional
    public ResponseEntity<PimExaminationResultsDTO> create(@RequestBody PimExaminationResultsDTO pimexaminationresultsdto) {
        PimExaminationResults domain = pimexaminationresultsMapping.toDomain(pimexaminationresultsdto);
		pimexaminationresultsService.create(domain);
        PimExaminationResultsDTO dto = pimexaminationresultsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimexaminationresultsMapping.toDomain(#pimexaminationresultsdtos),'ehr-PimExaminationResults-Create')")
    @ApiOperation(value = "createBatch", tags = {"PimExaminationResults" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexaminationresults/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimExaminationResultsDTO> pimexaminationresultsdtos) {
        pimexaminationresultsService.createBatch(pimexaminationresultsMapping.toDomain(pimexaminationresultsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimexaminationresultsService.get(#pimexaminationresults_id),'ehr-PimExaminationResults-Remove')")
    @ApiOperation(value = "Remove", tags = {"PimExaminationResults" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimexaminationresults/{pimexaminationresults_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimexaminationresults_id") String pimexaminationresults_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimexaminationresultsService.remove(pimexaminationresults_id));
    }

    @PreAuthorize("hasPermission(this.pimexaminationresultsService.getPimexaminationresultsByIds(#ids),'ehr-PimExaminationResults-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PimExaminationResults" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimexaminationresults/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimexaminationresultsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"PimExaminationResults" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimexaminationresults/getdraft")
    public ResponseEntity<PimExaminationResultsDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimexaminationresultsMapping.toDto(pimexaminationresultsService.getDraft(new PimExaminationResults())));
    }

    @PostAuthorize("hasPermission(this.pimexaminationresultsMapping.toDomain(returnObject.body),'ehr-PimExaminationResults-Get')")
    @ApiOperation(value = "Get", tags = {"PimExaminationResults" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimexaminationresults/{pimexaminationresults_id}")
    public ResponseEntity<PimExaminationResultsDTO> get(@PathVariable("pimexaminationresults_id") String pimexaminationresults_id) {
        PimExaminationResults domain = pimexaminationresultsService.get(pimexaminationresults_id);
        PimExaminationResultsDTO dto = pimexaminationresultsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExaminationResults-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PimExaminationResults" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimexaminationresults/fetchdefault")
	public ResponseEntity<List<PimExaminationResultsDTO>> fetchDefault(PimExaminationResultsSearchContext context) {
        Page<PimExaminationResults> domains = pimexaminationresultsService.searchDefault(context) ;
        List<PimExaminationResultsDTO> list = pimexaminationresultsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExaminationResults-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PimExaminationResults" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimexaminationresults/searchdefault")
	public ResponseEntity<Page<PimExaminationResultsDTO>> searchDefault(@RequestBody PimExaminationResultsSearchContext context) {
        Page<PimExaminationResults> domains = pimexaminationresultsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimexaminationresultsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

