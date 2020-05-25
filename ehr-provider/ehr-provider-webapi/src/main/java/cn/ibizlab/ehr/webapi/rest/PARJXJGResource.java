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
import cn.ibizlab.ehr.core.par.domain.PARJXJG;
import cn.ibizlab.ehr.core.par.service.IPARJXJGService;
import cn.ibizlab.ehr.core.par.filter.PARJXJGSearchContext;

@Slf4j
@Api(tags = {"PARJXJG" })
@RestController("WebApi-parjxjg")
@RequestMapping("")
public class PARJXJGResource {

    @Autowired
    private IPARJXJGService parjxjgService;

    @Autowired
    @Lazy
    public PARJXJGMapping parjxjgMapping;

    public PARJXJGDTO permissionDTO=new PARJXJGDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXJG-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PARJXJG" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxjgs/getdraft")
    public ResponseEntity<PARJXJGDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parjxjgMapping.toDto(parjxjgService.getDraft(new PARJXJG())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXJG-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PARJXJG" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxjgs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARJXJGDTO parjxjgdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parjxjgService.checkKey(parjxjgMapping.toDomain(parjxjgdto)));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.parjxjgMapping,#parjxjgdto})")
    @ApiOperation(value = "Create", tags = {"PARJXJG" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxjgs")
    @Transactional
    public ResponseEntity<PARJXJGDTO> create(@RequestBody PARJXJGDTO parjxjgdto) {
        PARJXJG domain = parjxjgMapping.toDomain(parjxjgdto);
		parjxjgService.create(domain);
        PARJXJGDTO dto = parjxjgMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"PARJXJG" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxjgs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARJXJGDTO> parjxjgdtos) {
        parjxjgService.createBatch(parjxjgMapping.toDomain(parjxjgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.parjxjgMapping,#parjxjgdto})")
    @ApiOperation(value = "Save", tags = {"PARJXJG" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxjgs/save")
    public ResponseEntity<Boolean> save(@RequestBody PARJXJGDTO parjxjgdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parjxjgService.save(parjxjgMapping.toDomain(parjxjgdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PARJXJG" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxjgs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARJXJGDTO> parjxjgdtos) {
        parjxjgService.saveBatch(parjxjgMapping.toDomain(parjxjgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#parjxjg_id,'Get',{'Sql',this.parjxjgMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PARJXJG" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxjgs/{parjxjg_id}")
    public ResponseEntity<PARJXJGDTO> get(@PathVariable("parjxjg_id") String parjxjg_id) {
        PARJXJG domain = parjxjgService.get(parjxjg_id);
        PARJXJGDTO dto = parjxjgMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#parjxjg_id,'Remove',{'Sql',this.parjxjgMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PARJXJG" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxjgs/{parjxjg_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parjxjg_id") String parjxjg_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parjxjgService.remove(parjxjg_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PARJXJG" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxjgs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parjxjgService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#parjxjg_id,'Update',{'Sql',this.parjxjgMapping,#parjxjgdto})")
    @ApiOperation(value = "Update", tags = {"PARJXJG" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxjgs/{parjxjg_id}")
    @Transactional
    public ResponseEntity<PARJXJGDTO> update(@PathVariable("parjxjg_id") String parjxjg_id, @RequestBody PARJXJGDTO parjxjgdto) {
		PARJXJG domain = parjxjgMapping.toDomain(parjxjgdto);
        domain.setParjxjgid(parjxjg_id);
		parjxjgService.update(domain);
		PARJXJGDTO dto = parjxjgMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PARJXJG" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxjgs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARJXJGDTO> parjxjgdtos) {
        parjxjgService.updateBatch(parjxjgMapping.toDomain(parjxjgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXJG-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PARJXJG" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parjxjgs/fetchdefault")
	public ResponseEntity<List<PARJXJGDTO>> fetchDefault(PARJXJGSearchContext context) {
        Page<PARJXJG> domains = parjxjgService.searchDefault(context) ;
        List<PARJXJGDTO> list = parjxjgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXJG-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PARJXJG" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parjxjgs/searchdefault")
	public ResponseEntity<Page<PARJXJGDTO>> searchDefault(@RequestBody PARJXJGSearchContext context) {
        Page<PARJXJG> domains = parjxjgService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjxjgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
