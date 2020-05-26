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
import cn.ibizlab.ehr.core.vac.domain.VACOVERALLTION;
import cn.ibizlab.ehr.core.vac.service.IVACOVERALLTIONService;
import cn.ibizlab.ehr.core.vac.filter.VACOVERALLTIONSearchContext;

@Slf4j
@Api(tags = {"VACOVERALLTION" })
@RestController("WebApi-vacoveralltion")
@RequestMapping("")
public class VACOVERALLTIONResource {

    @Autowired
    private IVACOVERALLTIONService vacoveralltionService;

    @Autowired
    @Lazy
    public VACOVERALLTIONMapping vacoveralltionMapping;

    public VACOVERALLTIONDTO permissionDTO=new VACOVERALLTIONDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACOVERALLTION-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"VACOVERALLTION" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/vacoveralltions/getdraft")
    public ResponseEntity<VACOVERALLTIONDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacoveralltionMapping.toDto(vacoveralltionService.getDraft(new VACOVERALLTION())));
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.vacoveralltionMapping,#vacoveralltiondto})")
    @ApiOperation(value = "Save", tags = {"VACOVERALLTION" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/vacoveralltions/save")
    public ResponseEntity<Boolean> save(@RequestBody VACOVERALLTIONDTO vacoveralltiondto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacoveralltionService.save(vacoveralltionMapping.toDomain(vacoveralltiondto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.vacoveralltionMapping,#vacoveralltiondtos})")
    @ApiOperation(value = "SaveBatch", tags = {"VACOVERALLTION" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacoveralltions/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VACOVERALLTIONDTO> vacoveralltiondtos) {
        vacoveralltionService.saveBatch(vacoveralltionMapping.toDomain(vacoveralltiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACOVERALLTION-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"VACOVERALLTION" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/vacoveralltions/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VACOVERALLTIONDTO vacoveralltiondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacoveralltionService.checkKey(vacoveralltionMapping.toDomain(vacoveralltiondto)));
    }

    @PreAuthorize("hasPermission(#vacoveralltion_id,'Update',{'Sql',this.vacoveralltionMapping,#vacoveralltiondto})")
    @ApiOperation(value = "Update", tags = {"VACOVERALLTION" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacoveralltions/{vacoveralltion_id}")
    @Transactional
    public ResponseEntity<VACOVERALLTIONDTO> update(@PathVariable("vacoveralltion_id") String vacoveralltion_id, @RequestBody VACOVERALLTIONDTO vacoveralltiondto) {
		VACOVERALLTION domain  = vacoveralltionMapping.toDomain(vacoveralltiondto);
        domain .setVacoveralltionid(vacoveralltion_id);
		vacoveralltionService.update(domain );
		VACOVERALLTIONDTO dto = vacoveralltionMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.vacoveralltionMapping,#vacoveralltiondtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"VACOVERALLTION" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacoveralltions/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VACOVERALLTIONDTO> vacoveralltiondtos) {
        vacoveralltionService.updateBatch(vacoveralltionMapping.toDomain(vacoveralltiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#vacoveralltion_id,'Remove',{'Sql',this.vacoveralltionMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"VACOVERALLTION" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacoveralltions/{vacoveralltion_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacoveralltion_id") String vacoveralltion_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacoveralltionService.remove(vacoveralltion_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.vacoveralltionMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"VACOVERALLTION" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacoveralltions/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacoveralltionService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.vacoveralltionMapping,#vacoveralltiondto})")
    @ApiOperation(value = "Create", tags = {"VACOVERALLTION" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/vacoveralltions")
    @Transactional
    public ResponseEntity<VACOVERALLTIONDTO> create(@RequestBody VACOVERALLTIONDTO vacoveralltiondto) {
        VACOVERALLTION domain = vacoveralltionMapping.toDomain(vacoveralltiondto);
		vacoveralltionService.create(domain);
        VACOVERALLTIONDTO dto = vacoveralltionMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.vacoveralltionMapping,#vacoveralltiondtos})")
    @ApiOperation(value = "createBatch", tags = {"VACOVERALLTION" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/vacoveralltions/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VACOVERALLTIONDTO> vacoveralltiondtos) {
        vacoveralltionService.createBatch(vacoveralltionMapping.toDomain(vacoveralltiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#vacoveralltion_id,'Get',{'Sql',this.vacoveralltionMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"VACOVERALLTION" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/vacoveralltions/{vacoveralltion_id}")
    public ResponseEntity<VACOVERALLTIONDTO> get(@PathVariable("vacoveralltion_id") String vacoveralltion_id) {
        VACOVERALLTION domain = vacoveralltionService.get(vacoveralltion_id);
        VACOVERALLTIONDTO dto = vacoveralltionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACOVERALLTION-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"VACOVERALLTION" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/vacoveralltions/fetchdefault")
	public ResponseEntity<List<VACOVERALLTIONDTO>> fetchDefault(VACOVERALLTIONSearchContext context) {
        Page<VACOVERALLTION> domains = vacoveralltionService.searchDefault(context) ;
        List<VACOVERALLTIONDTO> list = vacoveralltionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACOVERALLTION-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"VACOVERALLTION" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/vacoveralltions/searchdefault")
	public ResponseEntity<Page<VACOVERALLTIONDTO>> searchDefault(@RequestBody VACOVERALLTIONSearchContext context) {
        Page<VACOVERALLTION> domains = vacoveralltionService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacoveralltionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
