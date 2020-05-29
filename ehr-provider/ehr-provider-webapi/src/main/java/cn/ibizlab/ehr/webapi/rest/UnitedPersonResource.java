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
import cn.ibizlab.ehr.core.orm.domain.UnitedPerson;
import cn.ibizlab.ehr.core.orm.service.IUnitedPersonService;
import cn.ibizlab.ehr.core.orm.filter.UnitedPersonSearchContext;

@Slf4j
@Api(tags = {"统一身份库" })
@RestController("WebApi-unitedperson")
@RequestMapping("")
public class UnitedPersonResource {

    @Autowired
    public IUnitedPersonService unitedpersonService;

    @Autowired
    @Lazy
    public UnitedPersonMapping unitedpersonMapping;

    @PreAuthorize("hasPermission(this.unitedpersonService.get(#unitedperson_id),'ehr-UnitedPerson-Remove')")
    @ApiOperation(value = "删除统一身份库", tags = {"统一身份库" },  notes = "删除统一身份库")
	@RequestMapping(method = RequestMethod.DELETE, value = "/unitedpeople/{unitedperson_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("unitedperson_id") String unitedperson_id) {
         return ResponseEntity.status(HttpStatus.OK).body(unitedpersonService.remove(unitedperson_id));
    }

    @PreAuthorize("hasPermission(this.unitedpersonService.getUnitedpersonByIds(#ids),'ehr-UnitedPerson-Remove')")
    @ApiOperation(value = "批量删除统一身份库", tags = {"统一身份库" },  notes = "批量删除统一身份库")
	@RequestMapping(method = RequestMethod.DELETE, value = "/unitedpeople/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        unitedpersonService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.unitedpersonMapping.toDomain(#unitedpersondto),'ehr-UnitedPerson-Save')")
    @ApiOperation(value = "保存统一身份库", tags = {"统一身份库" },  notes = "保存统一身份库")
	@RequestMapping(method = RequestMethod.POST, value = "/unitedpeople/save")
    public ResponseEntity<Boolean> save(@RequestBody UnitedPersonDTO unitedpersondto) {
        return ResponseEntity.status(HttpStatus.OK).body(unitedpersonService.save(unitedpersonMapping.toDomain(unitedpersondto)));
    }

    @PreAuthorize("hasPermission(this.unitedpersonMapping.toDomain(#unitedpersondtos),'ehr-UnitedPerson-Save')")
    @ApiOperation(value = "批量保存统一身份库", tags = {"统一身份库" },  notes = "批量保存统一身份库")
	@RequestMapping(method = RequestMethod.POST, value = "/unitedpeople/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<UnitedPersonDTO> unitedpersondtos) {
        unitedpersonService.saveBatch(unitedpersonMapping.toDomain(unitedpersondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UnitedPerson-GetUnitedUser-all')")
    @ApiOperation(value = "同步人员", tags = {"统一身份库" },  notes = "同步人员")
	@RequestMapping(method = RequestMethod.GET, value = "/unitedpeople/{unitedperson_id}/getuniteduser")
    @Transactional
    public ResponseEntity<UnitedPersonDTO> getUnitedUser(@PathVariable("unitedperson_id") String unitedperson_id, @RequestBody UnitedPersonDTO unitedpersondto) {
        UnitedPerson unitedperson = unitedpersonMapping.toDomain(unitedpersondto);
        unitedperson.setUnitedpersonid(unitedperson_id);
        unitedperson = unitedpersonService.getUnitedUser(unitedperson);
        unitedpersondto = unitedpersonMapping.toDto(unitedperson);
        return ResponseEntity.status(HttpStatus.OK).body(unitedpersondto);
    }

    @ApiOperation(value = "获取统一身份库草稿", tags = {"统一身份库" },  notes = "获取统一身份库草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/unitedpeople/getdraft")
    public ResponseEntity<UnitedPersonDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(unitedpersonMapping.toDto(unitedpersonService.getDraft(new UnitedPerson())));
    }

    @PreAuthorize("hasPermission(this.unitedpersonMapping.toDomain(#unitedpersondto),'ehr-UnitedPerson-Create')")
    @ApiOperation(value = "新建统一身份库", tags = {"统一身份库" },  notes = "新建统一身份库")
	@RequestMapping(method = RequestMethod.POST, value = "/unitedpeople")
    @Transactional
    public ResponseEntity<UnitedPersonDTO> create(@RequestBody UnitedPersonDTO unitedpersondto) {
        UnitedPerson domain = unitedpersonMapping.toDomain(unitedpersondto);
		unitedpersonService.create(domain);
        UnitedPersonDTO dto = unitedpersonMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.unitedpersonMapping.toDomain(#unitedpersondtos),'ehr-UnitedPerson-Create')")
    @ApiOperation(value = "批量新建统一身份库", tags = {"统一身份库" },  notes = "批量新建统一身份库")
	@RequestMapping(method = RequestMethod.POST, value = "/unitedpeople/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<UnitedPersonDTO> unitedpersondtos) {
        unitedpersonService.createBatch(unitedpersonMapping.toDomain(unitedpersondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查统一身份库", tags = {"统一身份库" },  notes = "检查统一身份库")
	@RequestMapping(method = RequestMethod.POST, value = "/unitedpeople/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody UnitedPersonDTO unitedpersondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(unitedpersonService.checkKey(unitedpersonMapping.toDomain(unitedpersondto)));
    }

    @PostAuthorize("hasPermission(this.unitedpersonMapping.toDomain(returnObject.body),'ehr-UnitedPerson-Get')")
    @ApiOperation(value = "获取统一身份库", tags = {"统一身份库" },  notes = "获取统一身份库")
	@RequestMapping(method = RequestMethod.GET, value = "/unitedpeople/{unitedperson_id}")
    public ResponseEntity<UnitedPersonDTO> get(@PathVariable("unitedperson_id") String unitedperson_id) {
        UnitedPerson domain = unitedpersonService.get(unitedperson_id);
        UnitedPersonDTO dto = unitedpersonMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.unitedpersonService.get(#unitedperson_id),'ehr-UnitedPerson-Update')")
    @ApiOperation(value = "更新统一身份库", tags = {"统一身份库" },  notes = "更新统一身份库")
	@RequestMapping(method = RequestMethod.PUT, value = "/unitedpeople/{unitedperson_id}")
    @Transactional
    public ResponseEntity<UnitedPersonDTO> update(@PathVariable("unitedperson_id") String unitedperson_id, @RequestBody UnitedPersonDTO unitedpersondto) {
		UnitedPerson domain  = unitedpersonMapping.toDomain(unitedpersondto);
        domain .setUnitedpersonid(unitedperson_id);
		unitedpersonService.update(domain );
		UnitedPersonDTO dto = unitedpersonMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.unitedpersonService.getUnitedpersonByEntities(this.unitedpersonMapping.toDomain(#unitedpersondtos)),'ehr-UnitedPerson-Update')")
    @ApiOperation(value = "批量更新统一身份库", tags = {"统一身份库" },  notes = "批量更新统一身份库")
	@RequestMapping(method = RequestMethod.PUT, value = "/unitedpeople/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<UnitedPersonDTO> unitedpersondtos) {
        unitedpersonService.updateBatch(unitedpersonMapping.toDomain(unitedpersondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UnitedPerson-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"统一身份库" } ,notes = "获取DEFAULT")
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
	@ApiOperation(value = "查询DEFAULT", tags = {"统一身份库" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/unitedpeople/searchdefault")
	public ResponseEntity<Page<UnitedPersonDTO>> searchDefault(@RequestBody UnitedPersonSearchContext context) {
        Page<UnitedPerson> domains = unitedpersonService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(unitedpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UnitedPerson-CXYH-all')")
	@ApiOperation(value = "获取查询可用的OID用户", tags = {"统一身份库" } ,notes = "获取查询可用的OID用户")
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
	@ApiOperation(value = "查询查询可用的OID用户", tags = {"统一身份库" } ,notes = "查询查询可用的OID用户")
    @RequestMapping(method= RequestMethod.POST , value="/unitedpeople/searchcxyh")
	public ResponseEntity<Page<UnitedPersonDTO>> searchCXYH(@RequestBody UnitedPersonSearchContext context) {
        Page<UnitedPerson> domains = unitedpersonService.searchCXYH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(unitedpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UnitedPerson-CurFQXJYH-all')")
	@ApiOperation(value = "获取新建用户", tags = {"统一身份库" } ,notes = "获取新建用户")
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
	@ApiOperation(value = "查询新建用户", tags = {"统一身份库" } ,notes = "查询新建用户")
    @RequestMapping(method= RequestMethod.POST , value="/unitedpeople/searchcurfqxjyh")
	public ResponseEntity<Page<UnitedPersonDTO>> searchCurFQXJYH(@RequestBody UnitedPersonSearchContext context) {
        Page<UnitedPerson> domains = unitedpersonService.searchCurFQXJYH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(unitedpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

