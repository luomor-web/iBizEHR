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
import cn.ibizlab.ehr.core.att.domain.ATTENMEMBWES;
import cn.ibizlab.ehr.core.att.service.IATTENMEMBWESService;
import cn.ibizlab.ehr.core.att.filter.ATTENMEMBWESSearchContext;

@Slf4j
@Api(tags = {"ATTENMEMBWES" })
@RestController("WebApi-attenmembwes")
@RequestMapping("")
public class ATTENMEMBWESResource {

    @Autowired
    private IATTENMEMBWESService attenmembwesService;

    @Autowired
    @Lazy
    public ATTENMEMBWESMapping attenmembwesMapping;

    public ATTENMEMBWESDTO permissionDTO=new ATTENMEMBWESDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENMEMBWES-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"ATTENMEMBWES" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/attenmembwes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ATTENMEMBWESDTO attenmembwesdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(attenmembwesService.checkKey(attenmembwesMapping.toDomain(attenmembwesdto)));
    }

    @PreAuthorize("hasPermission(#attenmembwes_id,'Get',{'Sql',this.attenmembwesMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"ATTENMEMBWES" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/attenmembwes/{attenmembwes_id}")
    public ResponseEntity<ATTENMEMBWESDTO> get(@PathVariable("attenmembwes_id") String attenmembwes_id) {
        ATTENMEMBWES domain = attenmembwesService.get(attenmembwes_id);
        ATTENMEMBWESDTO dto = attenmembwesMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#attenmembwes_id,'Remove',{'Sql',this.attenmembwesMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"ATTENMEMBWES" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attenmembwes/{attenmembwes_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("attenmembwes_id") String attenmembwes_id) {
         return ResponseEntity.status(HttpStatus.OK).body(attenmembwesService.remove(attenmembwes_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.attenmembwesMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"ATTENMEMBWES" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attenmembwes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        attenmembwesService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.attenmembwesMapping,#attenmembwesdto})")
    @ApiOperation(value = "Save", tags = {"ATTENMEMBWES" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/attenmembwes/save")
    public ResponseEntity<Boolean> save(@RequestBody ATTENMEMBWESDTO attenmembwesdto) {
        return ResponseEntity.status(HttpStatus.OK).body(attenmembwesService.save(attenmembwesMapping.toDomain(attenmembwesdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.attenmembwesMapping,#attenmembwesdtos})")
    @ApiOperation(value = "SaveBatch", tags = {"ATTENMEMBWES" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/attenmembwes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ATTENMEMBWESDTO> attenmembwesdtos) {
        attenmembwesService.saveBatch(attenmembwesMapping.toDomain(attenmembwesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENMEMBWES-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"ATTENMEMBWES" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/attenmembwes/getdraft")
    public ResponseEntity<ATTENMEMBWESDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(attenmembwesMapping.toDto(attenmembwesService.getDraft(new ATTENMEMBWES())));
    }

    @PreAuthorize("hasPermission(#attenmembwes_id,'Update',{'Sql',this.attenmembwesMapping,#attenmembwesdto})")
    @ApiOperation(value = "Update", tags = {"ATTENMEMBWES" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/attenmembwes/{attenmembwes_id}")
    @Transactional
    public ResponseEntity<ATTENMEMBWESDTO> update(@PathVariable("attenmembwes_id") String attenmembwes_id, @RequestBody ATTENMEMBWESDTO attenmembwesdto) {
		ATTENMEMBWES domain  = attenmembwesMapping.toDomain(attenmembwesdto);
        domain .setAttenmembwesid(attenmembwes_id);
		attenmembwesService.update(domain );
		ATTENMEMBWESDTO dto = attenmembwesMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.attenmembwesMapping,#attenmembwesdtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"ATTENMEMBWES" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/attenmembwes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ATTENMEMBWESDTO> attenmembwesdtos) {
        attenmembwesService.updateBatch(attenmembwesMapping.toDomain(attenmembwesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.attenmembwesMapping,#attenmembwesdto})")
    @ApiOperation(value = "Create", tags = {"ATTENMEMBWES" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/attenmembwes")
    @Transactional
    public ResponseEntity<ATTENMEMBWESDTO> create(@RequestBody ATTENMEMBWESDTO attenmembwesdto) {
        ATTENMEMBWES domain = attenmembwesMapping.toDomain(attenmembwesdto);
		attenmembwesService.create(domain);
        ATTENMEMBWESDTO dto = attenmembwesMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.attenmembwesMapping,#attenmembwesdtos})")
    @ApiOperation(value = "createBatch", tags = {"ATTENMEMBWES" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/attenmembwes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ATTENMEMBWESDTO> attenmembwesdtos) {
        attenmembwesService.createBatch(attenmembwesMapping.toDomain(attenmembwesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENMEMBWES-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ATTENMEMBWES" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/attenmembwes/fetchdefault")
	public ResponseEntity<List<ATTENMEMBWESDTO>> fetchDefault(ATTENMEMBWESSearchContext context) {
        Page<ATTENMEMBWES> domains = attenmembwesService.searchDefault(context) ;
        List<ATTENMEMBWESDTO> list = attenmembwesMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENMEMBWES-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ATTENMEMBWES" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/attenmembwes/searchdefault")
	public ResponseEntity<Page<ATTENMEMBWESDTO>> searchDefault(@RequestBody ATTENMEMBWESSearchContext context) {
        Page<ATTENMEMBWES> domains = attenmembwesService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attenmembwesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
