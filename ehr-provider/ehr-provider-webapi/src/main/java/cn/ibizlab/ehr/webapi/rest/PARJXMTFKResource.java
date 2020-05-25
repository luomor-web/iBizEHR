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
import cn.ibizlab.ehr.core.par.domain.PARJXMTFK;
import cn.ibizlab.ehr.core.par.service.IPARJXMTFKService;
import cn.ibizlab.ehr.core.par.filter.PARJXMTFKSearchContext;

@Slf4j
@Api(tags = {"PARJXMTFK" })
@RestController("WebApi-parjxmtfk")
@RequestMapping("")
public class PARJXMTFKResource {

    @Autowired
    private IPARJXMTFKService parjxmtfkService;

    @Autowired
    @Lazy
    public PARJXMTFKMapping parjxmtfkMapping;

    public PARJXMTFKDTO permissionDTO=new PARJXMTFKDTO();

    @PreAuthorize("hasPermission('','Create',{'Sql',this.parjxmtfkMapping,#parjxmtfkdto})")
    @ApiOperation(value = "Create", tags = {"PARJXMTFK" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxmtfks")
    @Transactional
    public ResponseEntity<PARJXMTFKDTO> create(@RequestBody PARJXMTFKDTO parjxmtfkdto) {
        PARJXMTFK domain = parjxmtfkMapping.toDomain(parjxmtfkdto);
		parjxmtfkService.create(domain);
        PARJXMTFKDTO dto = parjxmtfkMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"PARJXMTFK" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxmtfks/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARJXMTFKDTO> parjxmtfkdtos) {
        parjxmtfkService.createBatch(parjxmtfkMapping.toDomain(parjxmtfkdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#parjxmtfk_id,'Update',{'Sql',this.parjxmtfkMapping,#parjxmtfkdto})")
    @ApiOperation(value = "Update", tags = {"PARJXMTFK" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxmtfks/{parjxmtfk_id}")
    @Transactional
    public ResponseEntity<PARJXMTFKDTO> update(@PathVariable("parjxmtfk_id") String parjxmtfk_id, @RequestBody PARJXMTFKDTO parjxmtfkdto) {
		PARJXMTFK domain = parjxmtfkMapping.toDomain(parjxmtfkdto);
        domain.setParjxmtfkid(parjxmtfk_id);
		parjxmtfkService.update(domain);
		PARJXMTFKDTO dto = parjxmtfkMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PARJXMTFK" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxmtfks/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARJXMTFKDTO> parjxmtfkdtos) {
        parjxmtfkService.updateBatch(parjxmtfkMapping.toDomain(parjxmtfkdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXMTFK-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PARJXMTFK" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxmtfks/getdraft")
    public ResponseEntity<PARJXMTFKDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parjxmtfkMapping.toDto(parjxmtfkService.getDraft(new PARJXMTFK())));
    }

    @PreAuthorize("hasPermission(#parjxmtfk_id,'Get',{'Sql',this.parjxmtfkMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PARJXMTFK" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxmtfks/{parjxmtfk_id}")
    public ResponseEntity<PARJXMTFKDTO> get(@PathVariable("parjxmtfk_id") String parjxmtfk_id) {
        PARJXMTFK domain = parjxmtfkService.get(parjxmtfk_id);
        PARJXMTFKDTO dto = parjxmtfkMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#parjxmtfk_id,'Remove',{'Sql',this.parjxmtfkMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PARJXMTFK" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxmtfks/{parjxmtfk_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parjxmtfk_id") String parjxmtfk_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parjxmtfkService.remove(parjxmtfk_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PARJXMTFK" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxmtfks/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parjxmtfkService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXMTFK-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PARJXMTFK" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxmtfks/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARJXMTFKDTO parjxmtfkdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parjxmtfkService.checkKey(parjxmtfkMapping.toDomain(parjxmtfkdto)));
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.parjxmtfkMapping,#parjxmtfkdto})")
    @ApiOperation(value = "Save", tags = {"PARJXMTFK" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxmtfks/save")
    public ResponseEntity<Boolean> save(@RequestBody PARJXMTFKDTO parjxmtfkdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parjxmtfkService.save(parjxmtfkMapping.toDomain(parjxmtfkdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PARJXMTFK" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxmtfks/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARJXMTFKDTO> parjxmtfkdtos) {
        parjxmtfkService.saveBatch(parjxmtfkMapping.toDomain(parjxmtfkdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXMTFK-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PARJXMTFK" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parjxmtfks/fetchdefault")
	public ResponseEntity<List<PARJXMTFKDTO>> fetchDefault(PARJXMTFKSearchContext context) {
        Page<PARJXMTFK> domains = parjxmtfkService.searchDefault(context) ;
        List<PARJXMTFKDTO> list = parjxmtfkMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARJXMTFK-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PARJXMTFK" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parjxmtfks/searchdefault")
	public ResponseEntity<Page<PARJXMTFKDTO>> searchDefault(@RequestBody PARJXMTFKSearchContext context) {
        Page<PARJXMTFK> domains = parjxmtfkService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjxmtfkMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
