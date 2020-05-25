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
import cn.ibizlab.ehr.core.par.domain.PARXMBPJBZ;
import cn.ibizlab.ehr.core.par.service.IPARXMBPJBZService;
import cn.ibizlab.ehr.core.par.filter.PARXMBPJBZSearchContext;

@Slf4j
@Api(tags = {"PARXMBPJBZ" })
@RestController("WebApi-parxmbpjbz")
@RequestMapping("")
public class PARXMBPJBZResource {

    @Autowired
    private IPARXMBPJBZService parxmbpjbzService;

    @Autowired
    @Lazy
    public PARXMBPJBZMapping parxmbpjbzMapping;

    public PARXMBPJBZDTO permissionDTO=new PARXMBPJBZDTO();

    @PreAuthorize("hasPermission(#parxmbpjbz_id,'Get',{'Sql',this.parxmbpjbzMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PARXMBPJBZ" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/parxmbpjbzs/{parxmbpjbz_id}")
    public ResponseEntity<PARXMBPJBZDTO> get(@PathVariable("parxmbpjbz_id") String parxmbpjbz_id) {
        PARXMBPJBZ domain = parxmbpjbzService.get(parxmbpjbz_id);
        PARXMBPJBZDTO dto = parxmbpjbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#parxmbpjbz_id,'Remove',{'Sql',this.parxmbpjbzMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PARXMBPJBZ" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parxmbpjbzs/{parxmbpjbz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parxmbpjbz_id") String parxmbpjbz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parxmbpjbzService.remove(parxmbpjbz_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PARXMBPJBZ" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parxmbpjbzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parxmbpjbzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARXMBPJBZ-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PARXMBPJBZ" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/parxmbpjbzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PARXMBPJBZDTO parxmbpjbzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parxmbpjbzService.checkKey(parxmbpjbzMapping.toDomain(parxmbpjbzdto)));
    }

    @PreAuthorize("hasPermission(#parxmbpjbz_id,'Update',{'Sql',this.parxmbpjbzMapping,#parxmbpjbzdto})")
    @ApiOperation(value = "Update", tags = {"PARXMBPJBZ" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/parxmbpjbzs/{parxmbpjbz_id}")
    @Transactional
    public ResponseEntity<PARXMBPJBZDTO> update(@PathVariable("parxmbpjbz_id") String parxmbpjbz_id, @RequestBody PARXMBPJBZDTO parxmbpjbzdto) {
		PARXMBPJBZ domain = parxmbpjbzMapping.toDomain(parxmbpjbzdto);
        domain.setParxmbpjbzid(parxmbpjbz_id);
		parxmbpjbzService.update(domain);
		PARXMBPJBZDTO dto = parxmbpjbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PARXMBPJBZ" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/parxmbpjbzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PARXMBPJBZDTO> parxmbpjbzdtos) {
        parxmbpjbzService.updateBatch(parxmbpjbzMapping.toDomain(parxmbpjbzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.parxmbpjbzMapping,#parxmbpjbzdto})")
    @ApiOperation(value = "Create", tags = {"PARXMBPJBZ" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/parxmbpjbzs")
    @Transactional
    public ResponseEntity<PARXMBPJBZDTO> create(@RequestBody PARXMBPJBZDTO parxmbpjbzdto) {
        PARXMBPJBZ domain = parxmbpjbzMapping.toDomain(parxmbpjbzdto);
		parxmbpjbzService.create(domain);
        PARXMBPJBZDTO dto = parxmbpjbzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"PARXMBPJBZ" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parxmbpjbzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PARXMBPJBZDTO> parxmbpjbzdtos) {
        parxmbpjbzService.createBatch(parxmbpjbzMapping.toDomain(parxmbpjbzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.parxmbpjbzMapping,#parxmbpjbzdto})")
    @ApiOperation(value = "Save", tags = {"PARXMBPJBZ" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/parxmbpjbzs/save")
    public ResponseEntity<Boolean> save(@RequestBody PARXMBPJBZDTO parxmbpjbzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parxmbpjbzService.save(parxmbpjbzMapping.toDomain(parxmbpjbzdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PARXMBPJBZ" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/parxmbpjbzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PARXMBPJBZDTO> parxmbpjbzdtos) {
        parxmbpjbzService.saveBatch(parxmbpjbzMapping.toDomain(parxmbpjbzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARXMBPJBZ-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PARXMBPJBZ" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/parxmbpjbzs/getdraft")
    public ResponseEntity<PARXMBPJBZDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parxmbpjbzMapping.toDto(parxmbpjbzService.getDraft(new PARXMBPJBZ())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARXMBPJBZ-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PARXMBPJBZ" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parxmbpjbzs/fetchdefault")
	public ResponseEntity<List<PARXMBPJBZDTO>> fetchDefault(PARXMBPJBZSearchContext context) {
        Page<PARXMBPJBZ> domains = parxmbpjbzService.searchDefault(context) ;
        List<PARXMBPJBZDTO> list = parxmbpjbzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PARXMBPJBZ-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PARXMBPJBZ" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parxmbpjbzs/searchdefault")
	public ResponseEntity<Page<PARXMBPJBZDTO>> searchDefault(@RequestBody PARXMBPJBZSearchContext context) {
        Page<PARXMBPJBZ> domains = parxmbpjbzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parxmbpjbzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
