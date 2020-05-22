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
import cn.ibizlab.ehr.core.vac.domain.VACDAYOFF;
import cn.ibizlab.ehr.core.vac.service.IVACDAYOFFService;
import cn.ibizlab.ehr.core.vac.filter.VACDAYOFFSearchContext;




@Slf4j
@Api(tags = {"VACDAYOFF" })
@RestController("WebApi-vacdayoff")
@RequestMapping("")
public class VACDAYOFFResource {

    @Autowired
    private IVACDAYOFFService vacdayoffService;

    @Autowired
    @Lazy
    public VACDAYOFFMapping vacdayoffMapping;

    public VACDAYOFFDTO permissionDTO=new VACDAYOFFDTO();

    @PreAuthorize("hasPermission(#vacdayoff_id,'Get',{'Sql',this.vacdayoffMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"VACDAYOFF" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/vacdayoffs/{vacdayoff_id}")
    public ResponseEntity<VACDAYOFFDTO> get(@PathVariable("vacdayoff_id") String vacdayoff_id) {
        VACDAYOFF domain = vacdayoffService.get(vacdayoff_id);
        VACDAYOFFDTO dto = vacdayoffMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACDAYOFF-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"VACDAYOFF" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/vacdayoffs/getdraft")
    public ResponseEntity<VACDAYOFFDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacdayoffMapping.toDto(vacdayoffService.getDraft(new VACDAYOFF())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACDAYOFF-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"VACDAYOFF" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/vacdayoffs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VACDAYOFFDTO vacdayoffdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacdayoffService.checkKey(vacdayoffMapping.toDomain(vacdayoffdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACDAYOFF-Save-all')")
    @ApiOperation(value = "Save", tags = {"VACDAYOFF" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/vacdayoffs/save")
    public ResponseEntity<Boolean> save(@RequestBody VACDAYOFFDTO vacdayoffdto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacdayoffService.save(vacdayoffMapping.toDomain(vacdayoffdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"VACDAYOFF" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacdayoffs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VACDAYOFFDTO> vacdayoffdtos) {
        vacdayoffService.saveBatch(vacdayoffMapping.toDomain(vacdayoffdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.vacdayoffMapping,#vacdayoffdto})")
    @ApiOperation(value = "Create", tags = {"VACDAYOFF" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/vacdayoffs")
    @Transactional
    public ResponseEntity<VACDAYOFFDTO> create(@RequestBody VACDAYOFFDTO vacdayoffdto) {
        VACDAYOFF domain = vacdayoffMapping.toDomain(vacdayoffdto);
		vacdayoffService.create(domain);
        VACDAYOFFDTO dto = vacdayoffMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"VACDAYOFF" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacdayoffs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VACDAYOFFDTO> vacdayoffdtos) {
        vacdayoffService.createBatch(vacdayoffMapping.toDomain(vacdayoffdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#vacdayoff_id,'Update',{'Sql',this.vacdayoffMapping,#vacdayoffdto})")
    @ApiOperation(value = "Update", tags = {"VACDAYOFF" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacdayoffs/{vacdayoff_id}")
    @Transactional
    public ResponseEntity<VACDAYOFFDTO> update(@PathVariable("vacdayoff_id") String vacdayoff_id, @RequestBody VACDAYOFFDTO vacdayoffdto) {
		VACDAYOFF domain = vacdayoffMapping.toDomain(vacdayoffdto);
        domain.setVacdayoffid(vacdayoff_id);
		vacdayoffService.update(domain);
		VACDAYOFFDTO dto = vacdayoffMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"VACDAYOFF" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacdayoffs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VACDAYOFFDTO> vacdayoffdtos) {
        vacdayoffService.updateBatch(vacdayoffMapping.toDomain(vacdayoffdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#vacdayoff_id,'Remove',{'Sql',this.vacdayoffMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"VACDAYOFF" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacdayoffs/{vacdayoff_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacdayoff_id") String vacdayoff_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacdayoffService.remove(vacdayoff_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"VACDAYOFF" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacdayoffs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacdayoffService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACDAYOFF-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"VACDAYOFF" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacdayoffs/fetchdefault")
	public ResponseEntity<List<VACDAYOFFDTO>> fetchDefault(VACDAYOFFSearchContext context) {
        Page<VACDAYOFF> domains = vacdayoffService.searchDefault(context) ;
        List<VACDAYOFFDTO> list = vacdayoffMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACDAYOFF-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"VACDAYOFF" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacdayoffs/searchdefault")
	public ResponseEntity<Page<VACDAYOFFDTO>> searchDefault(@RequestBody VACDAYOFFSearchContext context) {
        Page<VACDAYOFF> domains = vacdayoffService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacdayoffMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
