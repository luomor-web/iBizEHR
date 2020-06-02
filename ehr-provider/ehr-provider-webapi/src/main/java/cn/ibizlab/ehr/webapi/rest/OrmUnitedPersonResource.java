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
import cn.ibizlab.ehr.core.orm.domain.OrmUnitedPerson;
import cn.ibizlab.ehr.core.orm.service.IOrmUnitedPersonService;
import cn.ibizlab.ehr.core.orm.filter.OrmUnitedPersonSearchContext;

@Slf4j
@Api(tags = {"统一身份库" })
@RestController("WebApi-ormunitedperson")
@RequestMapping("")
public class OrmUnitedPersonResource {

    @Autowired
    public IOrmUnitedPersonService ormunitedpersonService;

    @Autowired
    @Lazy
    public OrmUnitedPersonMapping ormunitedpersonMapping;

    @PreAuthorize("hasPermission(this.ormunitedpersonService.get(#ormunitedperson_id),'ehr-OrmUnitedPerson-Remove')")
    @ApiOperation(value = "删除统一身份库", tags = {"统一身份库" },  notes = "删除统一身份库")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormunitedpeople/{ormunitedperson_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormunitedperson_id") String ormunitedperson_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormunitedpersonService.remove(ormunitedperson_id));
    }

    @PreAuthorize("hasPermission(this.ormunitedpersonService.getOrmunitedpersonByIds(#ids),'ehr-OrmUnitedPerson-Remove')")
    @ApiOperation(value = "批量删除统一身份库", tags = {"统一身份库" },  notes = "批量删除统一身份库")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormunitedpeople/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormunitedpersonService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormunitedpersonMapping.toDomain(#ormunitedpersondto),'ehr-OrmUnitedPerson-Save')")
    @ApiOperation(value = "保存统一身份库", tags = {"统一身份库" },  notes = "保存统一身份库")
	@RequestMapping(method = RequestMethod.POST, value = "/ormunitedpeople/save")
    public ResponseEntity<Boolean> save(@RequestBody OrmUnitedPersonDTO ormunitedpersondto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormunitedpersonService.save(ormunitedpersonMapping.toDomain(ormunitedpersondto)));
    }

    @PreAuthorize("hasPermission(this.ormunitedpersonMapping.toDomain(#ormunitedpersondtos),'ehr-OrmUnitedPerson-Save')")
    @ApiOperation(value = "批量保存统一身份库", tags = {"统一身份库" },  notes = "批量保存统一身份库")
	@RequestMapping(method = RequestMethod.POST, value = "/ormunitedpeople/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrmUnitedPersonDTO> ormunitedpersondtos) {
        ormunitedpersonService.saveBatch(ormunitedpersonMapping.toDomain(ormunitedpersondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmUnitedPerson-GetUnitedUser-all')")
    @ApiOperation(value = "同步人员", tags = {"统一身份库" },  notes = "同步人员")
	@RequestMapping(method = RequestMethod.GET, value = "/ormunitedpeople/{ormunitedperson_id}/getuniteduser")
    @Transactional
    public ResponseEntity<OrmUnitedPersonDTO> getUnitedUser(@PathVariable("ormunitedperson_id") String ormunitedperson_id, @RequestBody OrmUnitedPersonDTO ormunitedpersondto) {
        OrmUnitedPerson ormunitedperson = ormunitedpersonMapping.toDomain(ormunitedpersondto);
        ormunitedperson.setUnitedpersonid(ormunitedperson_id);
        ormunitedperson = ormunitedpersonService.getUnitedUser(ormunitedperson);
        ormunitedpersondto = ormunitedpersonMapping.toDto(ormunitedperson);
        return ResponseEntity.status(HttpStatus.OK).body(ormunitedpersondto);
    }

    @ApiOperation(value = "获取统一身份库草稿", tags = {"统一身份库" },  notes = "获取统一身份库草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/ormunitedpeople/getdraft")
    public ResponseEntity<OrmUnitedPersonDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormunitedpersonMapping.toDto(ormunitedpersonService.getDraft(new OrmUnitedPerson())));
    }

    @PreAuthorize("hasPermission(this.ormunitedpersonMapping.toDomain(#ormunitedpersondto),'ehr-OrmUnitedPerson-Create')")
    @ApiOperation(value = "新建统一身份库", tags = {"统一身份库" },  notes = "新建统一身份库")
	@RequestMapping(method = RequestMethod.POST, value = "/ormunitedpeople")
    @Transactional
    public ResponseEntity<OrmUnitedPersonDTO> create(@RequestBody OrmUnitedPersonDTO ormunitedpersondto) {
        OrmUnitedPerson domain = ormunitedpersonMapping.toDomain(ormunitedpersondto);
		ormunitedpersonService.create(domain);
        OrmUnitedPersonDTO dto = ormunitedpersonMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormunitedpersonMapping.toDomain(#ormunitedpersondtos),'ehr-OrmUnitedPerson-Create')")
    @ApiOperation(value = "批量新建统一身份库", tags = {"统一身份库" },  notes = "批量新建统一身份库")
	@RequestMapping(method = RequestMethod.POST, value = "/ormunitedpeople/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrmUnitedPersonDTO> ormunitedpersondtos) {
        ormunitedpersonService.createBatch(ormunitedpersonMapping.toDomain(ormunitedpersondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查统一身份库", tags = {"统一身份库" },  notes = "检查统一身份库")
	@RequestMapping(method = RequestMethod.POST, value = "/ormunitedpeople/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrmUnitedPersonDTO ormunitedpersondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormunitedpersonService.checkKey(ormunitedpersonMapping.toDomain(ormunitedpersondto)));
    }

    @PostAuthorize("hasPermission(this.ormunitedpersonMapping.toDomain(returnObject.body),'ehr-OrmUnitedPerson-Get')")
    @ApiOperation(value = "获取统一身份库", tags = {"统一身份库" },  notes = "获取统一身份库")
	@RequestMapping(method = RequestMethod.GET, value = "/ormunitedpeople/{ormunitedperson_id}")
    public ResponseEntity<OrmUnitedPersonDTO> get(@PathVariable("ormunitedperson_id") String ormunitedperson_id) {
        OrmUnitedPerson domain = ormunitedpersonService.get(ormunitedperson_id);
        OrmUnitedPersonDTO dto = ormunitedpersonMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormunitedpersonService.get(#ormunitedperson_id),'ehr-OrmUnitedPerson-Update')")
    @ApiOperation(value = "更新统一身份库", tags = {"统一身份库" },  notes = "更新统一身份库")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormunitedpeople/{ormunitedperson_id}")
    @Transactional
    public ResponseEntity<OrmUnitedPersonDTO> update(@PathVariable("ormunitedperson_id") String ormunitedperson_id, @RequestBody OrmUnitedPersonDTO ormunitedpersondto) {
		OrmUnitedPerson domain  = ormunitedpersonMapping.toDomain(ormunitedpersondto);
        domain .setUnitedpersonid(ormunitedperson_id);
		ormunitedpersonService.update(domain );
		OrmUnitedPersonDTO dto = ormunitedpersonMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormunitedpersonService.getOrmunitedpersonByEntities(this.ormunitedpersonMapping.toDomain(#ormunitedpersondtos)),'ehr-OrmUnitedPerson-Update')")
    @ApiOperation(value = "批量更新统一身份库", tags = {"统一身份库" },  notes = "批量更新统一身份库")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormunitedpeople/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrmUnitedPersonDTO> ormunitedpersondtos) {
        ormunitedpersonService.updateBatch(ormunitedpersonMapping.toDomain(ormunitedpersondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmUnitedPerson-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"统一身份库" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormunitedpeople/fetchdefault")
	public ResponseEntity<List<OrmUnitedPersonDTO>> fetchDefault(OrmUnitedPersonSearchContext context) {
        Page<OrmUnitedPerson> domains = ormunitedpersonService.searchDefault(context) ;
        List<OrmUnitedPersonDTO> list = ormunitedpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmUnitedPerson-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"统一身份库" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormunitedpeople/searchdefault")
	public ResponseEntity<Page<OrmUnitedPersonDTO>> searchDefault(@RequestBody OrmUnitedPersonSearchContext context) {
        Page<OrmUnitedPerson> domains = ormunitedpersonService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormunitedpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmUnitedPerson-CXYH-all')")
	@ApiOperation(value = "获取查询可用的OID用户", tags = {"统一身份库" } ,notes = "获取查询可用的OID用户")
    @RequestMapping(method= RequestMethod.GET , value="/ormunitedpeople/fetchcxyh")
	public ResponseEntity<List<OrmUnitedPersonDTO>> fetchCXYH(OrmUnitedPersonSearchContext context) {
        Page<OrmUnitedPerson> domains = ormunitedpersonService.searchCXYH(context) ;
        List<OrmUnitedPersonDTO> list = ormunitedpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmUnitedPerson-CXYH-all')")
	@ApiOperation(value = "查询查询可用的OID用户", tags = {"统一身份库" } ,notes = "查询查询可用的OID用户")
    @RequestMapping(method= RequestMethod.POST , value="/ormunitedpeople/searchcxyh")
	public ResponseEntity<Page<OrmUnitedPersonDTO>> searchCXYH(@RequestBody OrmUnitedPersonSearchContext context) {
        Page<OrmUnitedPerson> domains = ormunitedpersonService.searchCXYH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormunitedpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmUnitedPerson-CurFQXJYH-all')")
	@ApiOperation(value = "获取新建用户", tags = {"统一身份库" } ,notes = "获取新建用户")
    @RequestMapping(method= RequestMethod.GET , value="/ormunitedpeople/fetchcurfqxjyh")
	public ResponseEntity<List<OrmUnitedPersonDTO>> fetchCurFQXJYH(OrmUnitedPersonSearchContext context) {
        Page<OrmUnitedPerson> domains = ormunitedpersonService.searchCurFQXJYH(context) ;
        List<OrmUnitedPersonDTO> list = ormunitedpersonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmUnitedPerson-CurFQXJYH-all')")
	@ApiOperation(value = "查询新建用户", tags = {"统一身份库" } ,notes = "查询新建用户")
    @RequestMapping(method= RequestMethod.POST , value="/ormunitedpeople/searchcurfqxjyh")
	public ResponseEntity<Page<OrmUnitedPersonDTO>> searchCurFQXJYH(@RequestBody OrmUnitedPersonSearchContext context) {
        Page<OrmUnitedPerson> domains = ormunitedpersonService.searchCurFQXJYH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormunitedpersonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

