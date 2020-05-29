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
import cn.ibizlab.ehr.core.sal.domain.SalPersonStd;
import cn.ibizlab.ehr.core.sal.service.ISalPersonStdService;
import cn.ibizlab.ehr.core.sal.filter.SalPersonStdSearchContext;

@Slf4j
@Api(tags = {"SalPersonStd" })
@RestController("WebApi-salpersonstd")
@RequestMapping("")
public class SalPersonStdResource {

    @Autowired
    public ISalPersonStdService salpersonstdService;

    @Autowired
    @Lazy
    public SalPersonStdMapping salpersonstdMapping;

    @PreAuthorize("hasPermission(this.salpersonstdMapping.toDomain(#salpersonstddto),'ehr-SalPersonStd-Save')")
    @ApiOperation(value = "Save", tags = {"SalPersonStd" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/salpersonstds/save")
    public ResponseEntity<Boolean> save(@RequestBody SalPersonStdDTO salpersonstddto) {
        return ResponseEntity.status(HttpStatus.OK).body(salpersonstdService.save(salpersonstdMapping.toDomain(salpersonstddto)));
    }

    @PreAuthorize("hasPermission(this.salpersonstdMapping.toDomain(#salpersonstddtos),'ehr-SalPersonStd-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"SalPersonStd" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salpersonstds/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SalPersonStdDTO> salpersonstddtos) {
        salpersonstdService.saveBatch(salpersonstdMapping.toDomain(salpersonstddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"SalPersonStd" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/salpersonstds/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SalPersonStdDTO salpersonstddto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salpersonstdService.checkKey(salpersonstdMapping.toDomain(salpersonstddto)));
    }

    @PreAuthorize("hasPermission(this.salpersonstdMapping.toDomain(#salpersonstddto),'ehr-SalPersonStd-Create')")
    @ApiOperation(value = "Create", tags = {"SalPersonStd" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/salpersonstds")
    @Transactional
    public ResponseEntity<SalPersonStdDTO> create(@RequestBody SalPersonStdDTO salpersonstddto) {
        SalPersonStd domain = salpersonstdMapping.toDomain(salpersonstddto);
		salpersonstdService.create(domain);
        SalPersonStdDTO dto = salpersonstdMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salpersonstdMapping.toDomain(#salpersonstddtos),'ehr-SalPersonStd-Create')")
    @ApiOperation(value = "createBatch", tags = {"SalPersonStd" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salpersonstds/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SalPersonStdDTO> salpersonstddtos) {
        salpersonstdService.createBatch(salpersonstdMapping.toDomain(salpersonstddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salpersonstdService.get(#salpersonstd_id),'ehr-SalPersonStd-Remove')")
    @ApiOperation(value = "Remove", tags = {"SalPersonStd" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salpersonstds/{salpersonstd_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salpersonstd_id") String salpersonstd_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salpersonstdService.remove(salpersonstd_id));
    }

    @PreAuthorize("hasPermission(this.salpersonstdService.getSalpersonstdByIds(#ids),'ehr-SalPersonStd-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"SalPersonStd" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salpersonstds/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salpersonstdService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"SalPersonStd" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/salpersonstds/getdraft")
    public ResponseEntity<SalPersonStdDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salpersonstdMapping.toDto(salpersonstdService.getDraft(new SalPersonStd())));
    }

    @PreAuthorize("hasPermission(this.salpersonstdService.get(#salpersonstd_id),'ehr-SalPersonStd-Update')")
    @ApiOperation(value = "Update", tags = {"SalPersonStd" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/salpersonstds/{salpersonstd_id}")
    @Transactional
    public ResponseEntity<SalPersonStdDTO> update(@PathVariable("salpersonstd_id") String salpersonstd_id, @RequestBody SalPersonStdDTO salpersonstddto) {
		SalPersonStd domain  = salpersonstdMapping.toDomain(salpersonstddto);
        domain .setSalpersonstdid(salpersonstd_id);
		salpersonstdService.update(domain );
		SalPersonStdDTO dto = salpersonstdMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salpersonstdService.getSalpersonstdByEntities(this.salpersonstdMapping.toDomain(#salpersonstddtos)),'ehr-SalPersonStd-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"SalPersonStd" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/salpersonstds/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SalPersonStdDTO> salpersonstddtos) {
        salpersonstdService.updateBatch(salpersonstdMapping.toDomain(salpersonstddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.salpersonstdMapping.toDomain(returnObject.body),'ehr-SalPersonStd-Get')")
    @ApiOperation(value = "Get", tags = {"SalPersonStd" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/salpersonstds/{salpersonstd_id}")
    public ResponseEntity<SalPersonStdDTO> get(@PathVariable("salpersonstd_id") String salpersonstd_id) {
        SalPersonStd domain = salpersonstdService.get(salpersonstd_id);
        SalPersonStdDTO dto = salpersonstdMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalPersonStd-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SalPersonStd" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salpersonstds/fetchdefault")
	public ResponseEntity<List<SalPersonStdDTO>> fetchDefault(SalPersonStdSearchContext context) {
        Page<SalPersonStd> domains = salpersonstdService.searchDefault(context) ;
        List<SalPersonStdDTO> list = salpersonstdMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalPersonStd-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SalPersonStd" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salpersonstds/searchdefault")
	public ResponseEntity<Page<SalPersonStdDTO>> searchDefault(@RequestBody SalPersonStdSearchContext context) {
        Page<SalPersonStd> domains = salpersonstdService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salpersonstdMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

