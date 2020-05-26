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
import cn.ibizlab.ehr.core.orm.domain.UnitedPerson;
import cn.ibizlab.ehr.core.orm.service.IUnitedPersonService;
import cn.ibizlab.ehr.core.orm.filter.UnitedPersonSearchContext;

@Slf4j
@Api(tags = {"UnitedPerson" })
@RestController("WebApi-unitedperson")
@RequestMapping("")
public class UnitedPersonResource {

    @Autowired
    private IUnitedPersonService unitedpersonService;

    @Autowired
    @Lazy
    public UnitedPersonMapping unitedpersonMapping;

    public UnitedPersonDTO permissionDTO=new UnitedPersonDTO();

    @PreAuthorize("hasPermission(#unitedperson_id,'Remove',{'Sql',this.unitedpersonMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"UnitedPerson" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/unitedpeople/{unitedperson_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("unitedperson_id") String unitedperson_id) {
         return ResponseEntity.status(HttpStatus.OK).body(unitedpersonService.remove(unitedperson_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.unitedpersonMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"UnitedPerson" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/unitedpeople/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        unitedpersonService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.unitedpersonMapping,#unitedpersondto})")
    @ApiOperation(value = "Save", tags = {"UnitedPerson" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/unitedpeople/save")
    public ResponseEntity<Boolean> save(@RequestBody UnitedPersonDTO unitedpersondto) {
        return ResponseEntity.status(HttpStatus.OK).body(unitedpersonService.save(unitedpersonMapping.toDomain(unitedpersondto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.unitedpersonMapping,#unitedpersondtos})")
    @ApiOperation(value = "SaveBatch", tags = {"UnitedPerson" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/unitedpeople/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<UnitedPersonDTO> unitedpersondtos) {
        unitedpersonService.saveBatch(unitedpersonMapping.toDomain(unitedpersondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UnitedPerson-GetUnitedUser-all')")
    @ApiOperation(value = "同步人员", tags = {"UnitedPerson" },  notes = "同步人员")
	@RequestMapping(method = RequestMethod.GET, value = "/unitedpeople/{unitedperson_id}/getuniteduser")
    @Transactional
    public ResponseEntity<UnitedPersonDTO> getUnitedUser(@PathVariable("unitedperson_id") String unitedperson_id, @RequestBody UnitedPersonDTO unitedpersondto) {
        UnitedPerson unitedperson = unitedpersonMapping.toDomain(unitedpersondto);
        unitedperson.setUnitedpersonid(unitedperson_id);
        unitedperson = unitedpersonService.getUnitedUser(unitedperson);
        unitedpersondto = unitedpersonMapping.toDto(unitedperson);
        return ResponseEntity.status(HttpStatus.OK).body(unitedpersondto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UnitedPerson-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"UnitedPerson" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/unitedpeople/getdraft")
    public ResponseEntity<UnitedPersonDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(unitedpersonMapping.toDto(unitedpersonService.getDraft(new UnitedPerson())));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.unitedpersonMapping,#unitedpersondto})")
    @ApiOperation(value = "Create", tags = {"UnitedPerson" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/unitedpeople")
    @Transactional
    public ResponseEntity<UnitedPersonDTO> create(@RequestBody UnitedPersonDTO unitedpersondto) {
        UnitedPerson domain = unitedpersonMapping.toDomain(unitedpersondto);
		unitedpersonService.create(domain);
        UnitedPersonDTO dto = unitedpersonMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.unitedpersonMapping,#unitedpersondtos})")
    @ApiOperation(value = "createBatch", tags = {"UnitedPerson" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/unitedpeople/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<UnitedPersonDTO> unitedpersondtos) {
        unitedpersonService.createBatch(unitedpersonMapping.toDomain(unitedpersondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UnitedPerson-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"UnitedPerson" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/unitedpeople/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody UnitedPersonDTO unitedpersondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(unitedpersonService.checkKey(unitedpersonMapping.toDomain(unitedpersondto)));
    }

    @PreAuthorize("hasPermission(#unitedperson_id,'Get',{'Sql',this.unitedpersonMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"UnitedPerson" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/unitedpeople/{unitedperson_id}")
    public ResponseEntity<UnitedPersonDTO> get(@PathVariable("unitedperson_id") String unitedperson_id) {
        UnitedPerson domain = unitedpersonService.get(unitedperson_id);
        UnitedPersonDTO dto = unitedpersonMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#unitedperson_id,'Update',{'Sql',this.unitedpersonMapping,#unitedpersondto})")
    @ApiOperation(value = "Update", tags = {"UnitedPerson" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/unitedpeople/{unitedperson_id}")
    @Transactional
    public ResponseEntity<UnitedPersonDTO> update(@PathVariable("unitedperson_id") String unitedperson_id, @RequestBody UnitedPersonDTO unitedpersondto) {
		UnitedPerson domain  = unitedpersonMapping.toDomain(unitedpersondto);
        domain .setUnitedpersonid(unitedperson_id);
		unitedpersonService.update(domain );
		UnitedPersonDTO dto = unitedpersonMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.unitedpersonMapping,#unitedpersondtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"UnitedPerson" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/unitedpeople/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<UnitedPersonDTO> unitedpersondtos) {
        unitedpersonService.updateBatch(unitedpersonMapping.toDomain(unitedpersondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UnitedPerson-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"UnitedPerson" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/unitedpeople/fetchdefault")
	public ResponseEntity<List<UnitedPersonDTO>> fetchDefault(UnitedPersonSearchContext context) {
        Page<UnitedPerson> domains = unitedpersonService.searchDefault(context) ;
        List<UnitedPersonDTO> list = unitedpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UnitedPerson-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"UnitedPerson" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/unitedpeople/searchdefault")
	public ResponseEntity<Page<UnitedPersonDTO>> searchDefault(@RequestBody UnitedPersonSearchContext context) {
        Page<UnitedPerson> domains = unitedpersonService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(unitedpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UnitedPerson-CXYH-all')")
	@ApiOperation(value = "fetch查询可用的OID用户", tags = {"UnitedPerson" } ,notes = "fetch查询可用的OID用户")
    @RequestMapping(method= RequestMethod.GET , value="/unitedpeople/fetchcxyh")
	public ResponseEntity<List<UnitedPersonDTO>> fetchCXYH(UnitedPersonSearchContext context) {
        Page<UnitedPerson> domains = unitedpersonService.searchCXYH(context) ;
        List<UnitedPersonDTO> list = unitedpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UnitedPerson-CXYH-all')")
	@ApiOperation(value = "search查询可用的OID用户", tags = {"UnitedPerson" } ,notes = "search查询可用的OID用户")
    @RequestMapping(method= RequestMethod.POST , value="/unitedpeople/searchcxyh")
	public ResponseEntity<Page<UnitedPersonDTO>> searchCXYH(@RequestBody UnitedPersonSearchContext context) {
        Page<UnitedPerson> domains = unitedpersonService.searchCXYH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(unitedpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UnitedPerson-CurFQXJYH-all')")
	@ApiOperation(value = "fetch新建用户", tags = {"UnitedPerson" } ,notes = "fetch新建用户")
    @RequestMapping(method= RequestMethod.GET , value="/unitedpeople/fetchcurfqxjyh")
	public ResponseEntity<List<UnitedPersonDTO>> fetchCurFQXJYH(UnitedPersonSearchContext context) {
        Page<UnitedPerson> domains = unitedpersonService.searchCurFQXJYH(context) ;
        List<UnitedPersonDTO> list = unitedpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UnitedPerson-CurFQXJYH-all')")
	@ApiOperation(value = "search新建用户", tags = {"UnitedPerson" } ,notes = "search新建用户")
    @RequestMapping(method= RequestMethod.POST , value="/unitedpeople/searchcurfqxjyh")
	public ResponseEntity<Page<UnitedPersonDTO>> searchCurFQXJYH(@RequestBody UnitedPersonSearchContext context) {
        Page<UnitedPerson> domains = unitedpersonService.searchCurFQXJYH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(unitedpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
