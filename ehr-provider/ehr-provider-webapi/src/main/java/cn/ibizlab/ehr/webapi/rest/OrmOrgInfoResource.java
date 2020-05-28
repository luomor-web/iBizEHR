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
import cn.ibizlab.ehr.core.orm.domain.OrmOrgInfo;
import cn.ibizlab.ehr.core.orm.service.IOrmOrgInfoService;
import cn.ibizlab.ehr.core.orm.filter.OrmOrgInfoSearchContext;

@Slf4j
@Api(tags = {"OrmOrgInfo" })
@RestController("WebApi-ormorginfo")
@RequestMapping("")
public class OrmOrgInfoResource {

    @Autowired
    public IOrmOrgInfoService ormorginfoService;

    @Autowired
    @Lazy
    public OrmOrgInfoMapping ormorginfoMapping;

    @ApiOperation(value = "CheckKey", tags = {"OrmOrgInfo" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorginfos/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrmOrgInfoDTO ormorginfodto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormorginfoService.checkKey(ormorginfoMapping.toDomain(ormorginfodto)));
    }

    @PreAuthorize("hasPermission(this.ormorginfoMapping.toDomain(#ormorginfodto),'ehr-OrmOrgInfo-Save')")
    @ApiOperation(value = "Save", tags = {"OrmOrgInfo" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorginfos/save")
    public ResponseEntity<Boolean> save(@RequestBody OrmOrgInfoDTO ormorginfodto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormorginfoService.save(ormorginfoMapping.toDomain(ormorginfodto)));
    }

    @PreAuthorize("hasPermission(this.ormorginfoMapping.toDomain(#ormorginfodtos),'ehr-OrmOrgInfo-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"OrmOrgInfo" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorginfos/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrmOrgInfoDTO> ormorginfodtos) {
        ormorginfoService.saveBatch(ormorginfoMapping.toDomain(ormorginfodtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"OrmOrgInfo" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorginfos/getdraft")
    public ResponseEntity<OrmOrgInfoDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormorginfoMapping.toDto(ormorginfoService.getDraft(new OrmOrgInfo())));
    }

    @PreAuthorize("hasPermission(this.ormorginfoService.get(#ormorginfo_id),'ehr-OrmOrgInfo-Remove')")
    @ApiOperation(value = "Remove", tags = {"OrmOrgInfo" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorginfos/{ormorginfo_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormorginfo_id") String ormorginfo_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormorginfoService.remove(ormorginfo_id));
    }

    @PreAuthorize("hasPermission(this.ormorginfoService.getOrmorginfoByIds(#ids),'ehr-OrmOrgInfo-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"OrmOrgInfo" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorginfos/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormorginfoService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormorginfoMapping.toDomain(returnObject.body),'ehr-OrmOrgInfo-Get')")
    @ApiOperation(value = "Get", tags = {"OrmOrgInfo" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorginfos/{ormorginfo_id}")
    public ResponseEntity<OrmOrgInfoDTO> get(@PathVariable("ormorginfo_id") String ormorginfo_id) {
        OrmOrgInfo domain = ormorginfoService.get(ormorginfo_id);
        OrmOrgInfoDTO dto = ormorginfoMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormorginfoMapping.toDomain(#ormorginfodto),'ehr-OrmOrgInfo-Create')")
    @ApiOperation(value = "Create", tags = {"OrmOrgInfo" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorginfos")
    @Transactional
    public ResponseEntity<OrmOrgInfoDTO> create(@RequestBody OrmOrgInfoDTO ormorginfodto) {
        OrmOrgInfo domain = ormorginfoMapping.toDomain(ormorginfodto);
		ormorginfoService.create(domain);
        OrmOrgInfoDTO dto = ormorginfoMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormorginfoMapping.toDomain(#ormorginfodtos),'ehr-OrmOrgInfo-Create')")
    @ApiOperation(value = "createBatch", tags = {"OrmOrgInfo" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorginfos/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrmOrgInfoDTO> ormorginfodtos) {
        ormorginfoService.createBatch(ormorginfoMapping.toDomain(ormorginfodtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormorginfoService.get(#ormorginfo_id),'ehr-OrmOrgInfo-Update')")
    @ApiOperation(value = "Update", tags = {"OrmOrgInfo" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorginfos/{ormorginfo_id}")
    @Transactional
    public ResponseEntity<OrmOrgInfoDTO> update(@PathVariable("ormorginfo_id") String ormorginfo_id, @RequestBody OrmOrgInfoDTO ormorginfodto) {
		OrmOrgInfo domain  = ormorginfoMapping.toDomain(ormorginfodto);
        domain .setOrmorginfoid(ormorginfo_id);
		ormorginfoService.update(domain );
		OrmOrgInfoDTO dto = ormorginfoMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormorginfoService.getOrmorginfoByEntities(this.ormorginfoMapping.toDomain(#ormorginfodtos)),'ehr-OrmOrgInfo-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"OrmOrgInfo" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorginfos/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrmOrgInfoDTO> ormorginfodtos) {
        ormorginfoService.updateBatch(ormorginfoMapping.toDomain(ormorginfodtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgInfo-SubOrgsector-all')")
	@ApiOperation(value = "fetch子部门查询", tags = {"OrmOrgInfo" } ,notes = "fetch子部门查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormorginfos/fetchsuborgsector")
	public ResponseEntity<List<OrmOrgInfoDTO>> fetchSubOrgsector(OrmOrgInfoSearchContext context) {
        Page<OrmOrgInfo> domains = ormorginfoService.searchSubOrgsector(context) ;
        List<OrmOrgInfoDTO> list = ormorginfoMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgInfo-SubOrgsector-all')")
	@ApiOperation(value = "search子部门查询", tags = {"OrmOrgInfo" } ,notes = "search子部门查询")
    @RequestMapping(method= RequestMethod.POST , value="/ormorginfos/searchsuborgsector")
	public ResponseEntity<Page<OrmOrgInfoDTO>> searchSubOrgsector(@RequestBody OrmOrgInfoSearchContext context) {
        Page<OrmOrgInfo> domains = ormorginfoService.searchSubOrgsector(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorginfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgInfo-CX-all')")
	@ApiOperation(value = "fetch自定义查询", tags = {"OrmOrgInfo" } ,notes = "fetch自定义查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormorginfos/fetchcx")
	public ResponseEntity<List<OrmOrgInfoDTO>> fetchCX(OrmOrgInfoSearchContext context) {
        Page<OrmOrgInfo> domains = ormorginfoService.searchCX(context) ;
        List<OrmOrgInfoDTO> list = ormorginfoMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgInfo-CX-all')")
	@ApiOperation(value = "search自定义查询", tags = {"OrmOrgInfo" } ,notes = "search自定义查询")
    @RequestMapping(method= RequestMethod.POST , value="/ormorginfos/searchcx")
	public ResponseEntity<Page<OrmOrgInfoDTO>> searchCX(@RequestBody OrmOrgInfoSearchContext context) {
        Page<OrmOrgInfo> domains = ormorginfoService.searchCX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorginfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgInfo-CurOrgsector-all')")
	@ApiOperation(value = "fetch部门/项目部查询", tags = {"OrmOrgInfo" } ,notes = "fetch部门/项目部查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormorginfos/fetchcurorgsector")
	public ResponseEntity<List<OrmOrgInfoDTO>> fetchCurOrgsector(OrmOrgInfoSearchContext context) {
        Page<OrmOrgInfo> domains = ormorginfoService.searchCurOrgsector(context) ;
        List<OrmOrgInfoDTO> list = ormorginfoMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgInfo-CurOrgsector-all')")
	@ApiOperation(value = "search部门/项目部查询", tags = {"OrmOrgInfo" } ,notes = "search部门/项目部查询")
    @RequestMapping(method= RequestMethod.POST , value="/ormorginfos/searchcurorgsector")
	public ResponseEntity<Page<OrmOrgInfoDTO>> searchCurOrgsector(@RequestBody OrmOrgInfoSearchContext context) {
        Page<OrmOrgInfo> domains = ormorginfoService.searchCurOrgsector(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorginfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgInfo-CurChild-all')")
	@ApiOperation(value = "fetch子组织查询", tags = {"OrmOrgInfo" } ,notes = "fetch子组织查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormorginfos/fetchcurchild")
	public ResponseEntity<List<OrmOrgInfoDTO>> fetchCurChild(OrmOrgInfoSearchContext context) {
        Page<OrmOrgInfo> domains = ormorginfoService.searchCurChild(context) ;
        List<OrmOrgInfoDTO> list = ormorginfoMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgInfo-CurChild-all')")
	@ApiOperation(value = "search子组织查询", tags = {"OrmOrgInfo" } ,notes = "search子组织查询")
    @RequestMapping(method= RequestMethod.POST , value="/ormorginfos/searchcurchild")
	public ResponseEntity<Page<OrmOrgInfoDTO>> searchCurChild(@RequestBody OrmOrgInfoSearchContext context) {
        Page<OrmOrgInfo> domains = ormorginfoService.searchCurChild(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorginfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgInfo-CurPorg-all')")
	@ApiOperation(value = "fetch根组织查询", tags = {"OrmOrgInfo" } ,notes = "fetch根组织查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormorginfos/fetchcurporg")
	public ResponseEntity<List<OrmOrgInfoDTO>> fetchCurPorg(OrmOrgInfoSearchContext context) {
        Page<OrmOrgInfo> domains = ormorginfoService.searchCurPorg(context) ;
        List<OrmOrgInfoDTO> list = ormorginfoMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgInfo-CurPorg-all')")
	@ApiOperation(value = "search根组织查询", tags = {"OrmOrgInfo" } ,notes = "search根组织查询")
    @RequestMapping(method= RequestMethod.POST , value="/ormorginfos/searchcurporg")
	public ResponseEntity<Page<OrmOrgInfoDTO>> searchCurPorg(@RequestBody OrmOrgInfoSearchContext context) {
        Page<OrmOrgInfo> domains = ormorginfoService.searchCurPorg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorginfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgInfo-SubPerson-all')")
	@ApiOperation(value = "fetch当前部门/项目部人员清单", tags = {"OrmOrgInfo" } ,notes = "fetch当前部门/项目部人员清单")
    @RequestMapping(method= RequestMethod.GET , value="/ormorginfos/fetchsubperson")
	public ResponseEntity<List<OrmOrgInfoDTO>> fetchSubPerson(OrmOrgInfoSearchContext context) {
        Page<OrmOrgInfo> domains = ormorginfoService.searchSubPerson(context) ;
        List<OrmOrgInfoDTO> list = ormorginfoMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgInfo-SubPerson-all')")
	@ApiOperation(value = "search当前部门/项目部人员清单", tags = {"OrmOrgInfo" } ,notes = "search当前部门/项目部人员清单")
    @RequestMapping(method= RequestMethod.POST , value="/ormorginfos/searchsubperson")
	public ResponseEntity<Page<OrmOrgInfoDTO>> searchSubPerson(@RequestBody OrmOrgInfoSearchContext context) {
        Page<OrmOrgInfo> domains = ormorginfoService.searchSubPerson(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorginfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgInfo-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"OrmOrgInfo" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormorginfos/fetchdefault")
	public ResponseEntity<List<OrmOrgInfoDTO>> fetchDefault(OrmOrgInfoSearchContext context) {
        Page<OrmOrgInfo> domains = ormorginfoService.searchDefault(context) ;
        List<OrmOrgInfoDTO> list = ormorginfoMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgInfo-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"OrmOrgInfo" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormorginfos/searchdefault")
	public ResponseEntity<Page<OrmOrgInfoDTO>> searchDefault(@RequestBody OrmOrgInfoSearchContext context) {
        Page<OrmOrgInfo> domains = ormorginfoService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorginfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgInfo-Suborg-all')")
	@ApiOperation(value = "fetch当前组织所包含的直接下级组织查询", tags = {"OrmOrgInfo" } ,notes = "fetch当前组织所包含的直接下级组织查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormorginfos/fetchsuborg")
	public ResponseEntity<List<OrmOrgInfoDTO>> fetchSuborg(OrmOrgInfoSearchContext context) {
        Page<OrmOrgInfo> domains = ormorginfoService.searchSuborg(context) ;
        List<OrmOrgInfoDTO> list = ormorginfoMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrgInfo-Suborg-all')")
	@ApiOperation(value = "search当前组织所包含的直接下级组织查询", tags = {"OrmOrgInfo" } ,notes = "search当前组织所包含的直接下级组织查询")
    @RequestMapping(method= RequestMethod.POST , value="/ormorginfos/searchsuborg")
	public ResponseEntity<Page<OrmOrgInfoDTO>> searchSuborg(@RequestBody OrmOrgInfoSearchContext context) {
        Page<OrmOrgInfo> domains = ormorginfoService.searchSuborg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorginfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

