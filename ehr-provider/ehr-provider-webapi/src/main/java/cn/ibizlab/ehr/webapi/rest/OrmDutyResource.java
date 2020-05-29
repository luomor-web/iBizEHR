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
import cn.ibizlab.ehr.core.orm.domain.OrmDuty;
import cn.ibizlab.ehr.core.orm.service.IOrmDutyService;
import cn.ibizlab.ehr.core.orm.filter.OrmDutySearchContext;

@Slf4j
@Api(tags = {"职务管理" })
@RestController("WebApi-ormduty")
@RequestMapping("")
public class OrmDutyResource {

    @Autowired
    public IOrmDutyService ormdutyService;

    @Autowired
    @Lazy
    public OrmDutyMapping ormdutyMapping;

    @PreAuthorize("hasPermission(this.ormdutyMapping.toDomain(#ormdutydto),'ehr-OrmDuty-Create')")
    @ApiOperation(value = "新建职务管理", tags = {"职务管理" },  notes = "新建职务管理")
	@RequestMapping(method = RequestMethod.POST, value = "/ormduties")
    @Transactional
    public ResponseEntity<OrmDutyDTO> create(@RequestBody OrmDutyDTO ormdutydto) {
        OrmDuty domain = ormdutyMapping.toDomain(ormdutydto);
		ormdutyService.create(domain);
        OrmDutyDTO dto = ormdutyMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdutyMapping.toDomain(#ormdutydtos),'ehr-OrmDuty-Create')")
    @ApiOperation(value = "批量新建职务管理", tags = {"职务管理" },  notes = "批量新建职务管理")
	@RequestMapping(method = RequestMethod.POST, value = "/ormduties/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrmDutyDTO> ormdutydtos) {
        ormdutyService.createBatch(ormdutyMapping.toDomain(ormdutydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmDuty-SynOrderNum-all')")
    @ApiOperation(value = "设置默认排序信息", tags = {"职务管理" },  notes = "设置默认排序信息")
	@RequestMapping(method = RequestMethod.POST, value = "/ormduties/{ormduty_id}/synordernum")
    @Transactional
    public ResponseEntity<OrmDutyDTO> synOrderNum(@PathVariable("ormduty_id") String ormduty_id, @RequestBody OrmDutyDTO ormdutydto) {
        OrmDuty ormduty = ormdutyMapping.toDomain(ormdutydto);
        ormduty.setOrmdutyid(ormduty_id);
        ormduty = ormdutyService.synOrderNum(ormduty);
        ormdutydto = ormdutyMapping.toDto(ormduty);
        return ResponseEntity.status(HttpStatus.OK).body(ormdutydto);
    }

    @PreAuthorize("hasPermission(this.ormdutyService.get(#ormduty_id),'ehr-OrmDuty-Update')")
    @ApiOperation(value = "更新职务管理", tags = {"职务管理" },  notes = "更新职务管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormduties/{ormduty_id}")
    @Transactional
    public ResponseEntity<OrmDutyDTO> update(@PathVariable("ormduty_id") String ormduty_id, @RequestBody OrmDutyDTO ormdutydto) {
		OrmDuty domain  = ormdutyMapping.toDomain(ormdutydto);
        domain .setOrmdutyid(ormduty_id);
		ormdutyService.update(domain );
		OrmDutyDTO dto = ormdutyMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdutyService.getOrmdutyByEntities(this.ormdutyMapping.toDomain(#ormdutydtos)),'ehr-OrmDuty-Update')")
    @ApiOperation(value = "批量更新职务管理", tags = {"职务管理" },  notes = "批量更新职务管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormduties/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrmDutyDTO> ormdutydtos) {
        ormdutyService.updateBatch(ormdutyMapping.toDomain(ormdutydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取职务管理草稿", tags = {"职务管理" },  notes = "获取职务管理草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/ormduties/getdraft")
    public ResponseEntity<OrmDutyDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormdutyMapping.toDto(ormdutyService.getDraft(new OrmDuty())));
    }

    @PreAuthorize("hasPermission(this.ormdutyService.get(#ormduty_id),'ehr-OrmDuty-Remove')")
    @ApiOperation(value = "删除职务管理", tags = {"职务管理" },  notes = "删除职务管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormduties/{ormduty_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormduty_id") String ormduty_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormdutyService.remove(ormduty_id));
    }

    @PreAuthorize("hasPermission(this.ormdutyService.getOrmdutyByIds(#ids),'ehr-OrmDuty-Remove')")
    @ApiOperation(value = "批量删除职务管理", tags = {"职务管理" },  notes = "批量删除职务管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormduties/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormdutyService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查职务管理", tags = {"职务管理" },  notes = "检查职务管理")
	@RequestMapping(method = RequestMethod.POST, value = "/ormduties/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrmDutyDTO ormdutydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormdutyService.checkKey(ormdutyMapping.toDomain(ormdutydto)));
    }

    @PostAuthorize("hasPermission(this.ormdutyMapping.toDomain(returnObject.body),'ehr-OrmDuty-Get')")
    @ApiOperation(value = "获取职务管理", tags = {"职务管理" },  notes = "获取职务管理")
	@RequestMapping(method = RequestMethod.GET, value = "/ormduties/{ormduty_id}")
    public ResponseEntity<OrmDutyDTO> get(@PathVariable("ormduty_id") String ormduty_id) {
        OrmDuty domain = ormdutyService.get(ormduty_id);
        OrmDutyDTO dto = ormdutyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormdutyMapping.toDomain(#ormdutydto),'ehr-OrmDuty-Save')")
    @ApiOperation(value = "保存职务管理", tags = {"职务管理" },  notes = "保存职务管理")
	@RequestMapping(method = RequestMethod.POST, value = "/ormduties/save")
    public ResponseEntity<Boolean> save(@RequestBody OrmDutyDTO ormdutydto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormdutyService.save(ormdutyMapping.toDomain(ormdutydto)));
    }

    @PreAuthorize("hasPermission(this.ormdutyMapping.toDomain(#ormdutydtos),'ehr-OrmDuty-Save')")
    @ApiOperation(value = "批量保存职务管理", tags = {"职务管理" },  notes = "批量保存职务管理")
	@RequestMapping(method = RequestMethod.POST, value = "/ormduties/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrmDutyDTO> ormdutydtos) {
        ormdutyService.saveBatch(ormdutyMapping.toDomain(ormdutydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmDuty-BasDuty-all')")
	@ApiOperation(value = "获取根据当前部门所属组织层次过滤数据", tags = {"职务管理" } ,notes = "获取根据当前部门所属组织层次过滤数据")
    @RequestMapping(method= RequestMethod.GET , value="/ormduties/fetchbasduty")
	public ResponseEntity<List<OrmDutyDTO>> fetchBasDuty(OrmDutySearchContext context) {
        Page<OrmDuty> domains = ormdutyService.searchBasDuty(context) ;
        List<OrmDutyDTO> list = ormdutyMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmDuty-BasDuty-all')")
	@ApiOperation(value = "查询根据当前部门所属组织层次过滤数据", tags = {"职务管理" } ,notes = "查询根据当前部门所属组织层次过滤数据")
    @RequestMapping(method= RequestMethod.POST , value="/ormduties/searchbasduty")
	public ResponseEntity<Page<OrmDutyDTO>> searchBasDuty(@RequestBody OrmDutySearchContext context) {
        Page<OrmDuty> domains = ormdutyService.searchBasDuty(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormdutyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmDuty-CurOrgsector-all')")
	@ApiOperation(value = "获取CurOrgsector", tags = {"职务管理" } ,notes = "获取CurOrgsector")
    @RequestMapping(method= RequestMethod.GET , value="/ormduties/fetchcurorgsector")
	public ResponseEntity<List<OrmDutyDTO>> fetchCurOrgsector(OrmDutySearchContext context) {
        Page<OrmDuty> domains = ormdutyService.searchCurOrgsector(context) ;
        List<OrmDutyDTO> list = ormdutyMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmDuty-CurOrgsector-all')")
	@ApiOperation(value = "查询CurOrgsector", tags = {"职务管理" } ,notes = "查询CurOrgsector")
    @RequestMapping(method= RequestMethod.POST , value="/ormduties/searchcurorgsector")
	public ResponseEntity<Page<OrmDutyDTO>> searchCurOrgsector(@RequestBody OrmDutySearchContext context) {
        Page<OrmDuty> domains = ormdutyService.searchCurOrgsector(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormdutyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmDuty-SrfOrgData-all')")
	@ApiOperation(value = "获取根据当前人员身份判定职务范围", tags = {"职务管理" } ,notes = "获取根据当前人员身份判定职务范围")
    @RequestMapping(method= RequestMethod.GET , value="/ormduties/fetchsrforgdata")
	public ResponseEntity<List<OrmDutyDTO>> fetchSrfOrgData(OrmDutySearchContext context) {
        Page<OrmDuty> domains = ormdutyService.searchSrfOrgData(context) ;
        List<OrmDutyDTO> list = ormdutyMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmDuty-SrfOrgData-all')")
	@ApiOperation(value = "查询根据当前人员身份判定职务范围", tags = {"职务管理" } ,notes = "查询根据当前人员身份判定职务范围")
    @RequestMapping(method= RequestMethod.POST , value="/ormduties/searchsrforgdata")
	public ResponseEntity<Page<OrmDutyDTO>> searchSrfOrgData(@RequestBody OrmDutySearchContext context) {
        Page<OrmDuty> domains = ormdutyService.searchSrfOrgData(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormdutyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmDuty-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"职务管理" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormduties/fetchdefault")
	public ResponseEntity<List<OrmDutyDTO>> fetchDefault(OrmDutySearchContext context) {
        Page<OrmDuty> domains = ormdutyService.searchDefault(context) ;
        List<OrmDutyDTO> list = ormdutyMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmDuty-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"职务管理" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormduties/searchdefault")
	public ResponseEntity<Page<OrmDutyDTO>> searchDefault(@RequestBody OrmDutySearchContext context) {
        Page<OrmDuty> domains = ormdutyService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormdutyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmDuty-CurOrg-all')")
	@ApiOperation(value = "获取根据当前人员身份判定职务范围", tags = {"职务管理" } ,notes = "获取根据当前人员身份判定职务范围")
    @RequestMapping(method= RequestMethod.GET , value="/ormduties/fetchcurorg")
	public ResponseEntity<List<OrmDutyDTO>> fetchCurOrg(OrmDutySearchContext context) {
        Page<OrmDuty> domains = ormdutyService.searchCurOrg(context) ;
        List<OrmDutyDTO> list = ormdutyMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmDuty-CurOrg-all')")
	@ApiOperation(value = "查询根据当前人员身份判定职务范围", tags = {"职务管理" } ,notes = "查询根据当前人员身份判定职务范围")
    @RequestMapping(method= RequestMethod.POST , value="/ormduties/searchcurorg")
	public ResponseEntity<Page<OrmDutyDTO>> searchCurOrg(@RequestBody OrmDutySearchContext context) {
        Page<OrmDuty> domains = ormdutyService.searchCurOrg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormdutyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmDuty-CurOrmorgsector-all')")
	@ApiOperation(value = "获取CurOrmorgsector", tags = {"职务管理" } ,notes = "获取CurOrmorgsector")
    @RequestMapping(method= RequestMethod.GET , value="/ormduties/fetchcurormorgsector")
	public ResponseEntity<List<OrmDutyDTO>> fetchCurOrmorgsector(OrmDutySearchContext context) {
        Page<OrmDuty> domains = ormdutyService.searchCurOrmorgsector(context) ;
        List<OrmDutyDTO> list = ormdutyMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmDuty-CurOrmorgsector-all')")
	@ApiOperation(value = "查询CurOrmorgsector", tags = {"职务管理" } ,notes = "查询CurOrmorgsector")
    @RequestMapping(method= RequestMethod.POST , value="/ormduties/searchcurormorgsector")
	public ResponseEntity<Page<OrmDutyDTO>> searchCurOrmorgsector(@RequestBody OrmDutySearchContext context) {
        Page<OrmDuty> domains = ormdutyService.searchCurOrmorgsector(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormdutyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

