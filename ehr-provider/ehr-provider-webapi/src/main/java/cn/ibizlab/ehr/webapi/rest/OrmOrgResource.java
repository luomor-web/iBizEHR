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
import cn.ibizlab.ehr.core.orm.domain.OrmOrg;
import cn.ibizlab.ehr.core.orm.service.IOrmOrgService;
import cn.ibizlab.ehr.core.orm.filter.OrmOrgSearchContext;

@Slf4j
@Api(tags = {"OrmOrg" })
@RestController("WebApi-ormorg")
@RequestMapping("")
public class OrmOrgResource {

    @Autowired
    public IOrmOrgService ormorgService;

    @Autowired
    @Lazy
    public OrmOrgMapping ormorgMapping;

    @PreAuthorize("hasPermission(this.ormorgService.get(#ormorg_id),'ehr-OrmOrg-Update')")
    @ApiOperation(value = "Update", tags = {"OrmOrg" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}")
    @Transactional
    public ResponseEntity<OrmOrgDTO> update(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmOrgDTO ormorgdto) {
		OrmOrg domain  = ormorgMapping.toDomain(ormorgdto);
        domain .setOrgid(ormorg_id);
		ormorgService.update(domain );
		OrmOrgDTO dto = ormorgMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormorgService.getOrmorgByEntities(this.ormorgMapping.toDomain(#ormorgdtos)),'ehr-OrmOrg-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"OrmOrg" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrmOrgDTO> ormorgdtos) {
        ormorgService.updateBatch(ormorgMapping.toDomain(ormorgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-SynOrg-all')")
    @ApiOperation(value = "设置默认排序信息", tags = {"OrmOrg" },  notes = "设置默认排序信息")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/synorg")
    @Transactional
    public ResponseEntity<OrmOrgDTO> synOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmOrgDTO ormorgdto) {
        OrmOrg ormorg = ormorgMapping.toDomain(ormorgdto);
        ormorg.setOrgid(ormorg_id);
        ormorg = ormorgService.synOrg(ormorg);
        ormorgdto = ormorgMapping.toDto(ormorg);
        return ResponseEntity.status(HttpStatus.OK).body(ormorgdto);
    }

    @PreAuthorize("hasPermission(this.ormorgService.get(#ormorg_id),'ehr-OrmOrg-Remove')")
    @ApiOperation(value = "Remove", tags = {"OrmOrg" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormorg_id") String ormorg_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormorgService.remove(ormorg_id));
    }

    @PreAuthorize("hasPermission(this.ormorgService.getOrmorgByIds(#ids),'ehr-OrmOrg-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"OrmOrg" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormorgService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"OrmOrg" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/getdraft")
    public ResponseEntity<OrmOrgDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormorgMapping.toDto(ormorgService.getDraft(new OrmOrg())));
    }

    @PostAuthorize("hasPermission(this.ormorgMapping.toDomain(returnObject.body),'ehr-OrmOrg-Get')")
    @ApiOperation(value = "Get", tags = {"OrmOrg" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}")
    public ResponseEntity<OrmOrgDTO> get(@PathVariable("ormorg_id") String ormorg_id) {
        OrmOrg domain = ormorgService.get(ormorg_id);
        OrmOrgDTO dto = ormorgMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "CheckKey", tags = {"OrmOrg" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrmOrgDTO ormorgdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormorgService.checkKey(ormorgMapping.toDomain(ormorgdto)));
    }

    @PreAuthorize("hasPermission(this.ormorgMapping.toDomain(#ormorgdto),'ehr-OrmOrg-Create')")
    @ApiOperation(value = "Create", tags = {"OrmOrg" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs")
    @Transactional
    public ResponseEntity<OrmOrgDTO> create(@RequestBody OrmOrgDTO ormorgdto) {
        OrmOrg domain = ormorgMapping.toDomain(ormorgdto);
		ormorgService.create(domain);
        OrmOrgDTO dto = ormorgMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormorgMapping.toDomain(#ormorgdtos),'ehr-OrmOrg-Create')")
    @ApiOperation(value = "createBatch", tags = {"OrmOrg" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrmOrgDTO> ormorgdtos) {
        ormorgService.createBatch(ormorgMapping.toDomain(ormorgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormorgMapping.toDomain(#ormorgdto),'ehr-OrmOrg-Save')")
    @ApiOperation(value = "Save", tags = {"OrmOrg" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/save")
    public ResponseEntity<Boolean> save(@RequestBody OrmOrgDTO ormorgdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormorgService.save(ormorgMapping.toDomain(ormorgdto)));
    }

    @PreAuthorize("hasPermission(this.ormorgMapping.toDomain(#ormorgdtos),'ehr-OrmOrg-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"OrmOrg" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrmOrgDTO> ormorgdtos) {
        ormorgService.saveBatch(ormorgMapping.toDomain(ormorgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-ALLSIGNORG-all')")
	@ApiOperation(value = "fetch全部法人主体", tags = {"OrmOrg" } ,notes = "fetch全部法人主体")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchallsignorg")
	public ResponseEntity<List<OrmOrgDTO>> fetchALLSIGNORG(OrmOrgSearchContext context) {
        Page<OrmOrg> domains = ormorgService.searchALLSIGNORG(context) ;
        List<OrmOrgDTO> list = ormorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-ALLSIGNORG-all')")
	@ApiOperation(value = "search全部法人主体", tags = {"OrmOrg" } ,notes = "search全部法人主体")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchallsignorg")
	public ResponseEntity<Page<OrmOrgDTO>> searchALLSIGNORG(@RequestBody OrmOrgSearchContext context) {
        Page<OrmOrg> domains = ormorgService.searchALLSIGNORG(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-AllLevelTwoOrg2-all')")
	@ApiOperation(value = "fetch全部二级单位（无权限）", tags = {"OrmOrg" } ,notes = "fetch全部二级单位（无权限）")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchallleveltwoorg2")
	public ResponseEntity<List<OrmOrgDTO>> fetchAllLevelTwoOrg2(OrmOrgSearchContext context) {
        Page<OrmOrg> domains = ormorgService.searchAllLevelTwoOrg2(context) ;
        List<OrmOrgDTO> list = ormorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-AllLevelTwoOrg2-all')")
	@ApiOperation(value = "search全部二级单位（无权限）", tags = {"OrmOrg" } ,notes = "search全部二级单位（无权限）")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchallleveltwoorg2")
	public ResponseEntity<Page<OrmOrgDTO>> searchAllLevelTwoOrg2(@RequestBody OrmOrgSearchContext context) {
        Page<OrmOrg> domains = ormorgService.searchAllLevelTwoOrg2(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-Orglist_Profile-all')")
	@ApiOperation(value = "fetch当前可选择组织列表（应聘者信息使用）", tags = {"OrmOrg" } ,notes = "fetch当前可选择组织列表（应聘者信息使用）")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchorglist_profile")
	public ResponseEntity<List<OrmOrgDTO>> fetchOrglist_Profile(OrmOrgSearchContext context) {
        Page<OrmOrg> domains = ormorgService.searchOrglist_Profile(context) ;
        List<OrmOrgDTO> list = ormorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-Orglist_Profile-all')")
	@ApiOperation(value = "search当前可选择组织列表（应聘者信息使用）", tags = {"OrmOrg" } ,notes = "search当前可选择组织列表（应聘者信息使用）")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchorglist_profile")
	public ResponseEntity<Page<OrmOrgDTO>> searchOrglist_Profile(@RequestBody OrmOrgSearchContext context) {
        Page<OrmOrg> domains = ormorgService.searchOrglist_Profile(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-REP_ORG-all')")
	@ApiOperation(value = "fetch组织分布", tags = {"OrmOrg" } ,notes = "fetch组织分布")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchrep_org")
	public ResponseEntity<List<HashMap>> fetchREP_ORG(OrmOrgSearchContext context) {
        Page<HashMap> domains = ormorgService.searchREP_ORG(context) ;
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(domains.getContent());
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-REP_ORG-all')")
	@ApiOperation(value = "search组织分布", tags = {"OrmOrg" } ,notes = "search组织分布")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchrep_org")
	public ResponseEntity<Page<HashMap>> searchREP_ORG(@RequestBody OrmOrgSearchContext context) {
        Page<HashMap> domains = ormorgService.searchREP_ORG(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(domains.getContent(), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-AuthOrg-all')")
	@ApiOperation(value = "fetch显示组织(权限控制)", tags = {"OrmOrg" } ,notes = "fetch显示组织(权限控制)")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchauthorg")
	public ResponseEntity<List<OrmOrgDTO>> fetchAuthOrg(OrmOrgSearchContext context) {
        Page<OrmOrg> domains = ormorgService.searchAuthOrg(context) ;
        List<OrmOrgDTO> list = ormorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-AuthOrg-all')")
	@ApiOperation(value = "search显示组织(权限控制)", tags = {"OrmOrg" } ,notes = "search显示组织(权限控制)")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchauthorg")
	public ResponseEntity<Page<OrmOrgDTO>> searchAuthOrg(@RequestBody OrmOrgSearchContext context) {
        Page<OrmOrg> domains = ormorgService.searchAuthOrg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-GSGWZY-all')")
	@ApiOperation(value = "fetch用于控制当前用户选择视图下拉显示（公司级岗位专用）", tags = {"OrmOrg" } ,notes = "fetch用于控制当前用户选择视图下拉显示（公司级岗位专用）")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchgsgwzy")
	public ResponseEntity<List<OrmOrgDTO>> fetchGSGWZY(OrmOrgSearchContext context) {
        Page<OrmOrg> domains = ormorgService.searchGSGWZY(context) ;
        List<OrmOrgDTO> list = ormorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-GSGWZY-all')")
	@ApiOperation(value = "search用于控制当前用户选择视图下拉显示（公司级岗位专用）", tags = {"OrmOrg" } ,notes = "search用于控制当前用户选择视图下拉显示（公司级岗位专用）")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchgsgwzy")
	public ResponseEntity<Page<OrmOrgDTO>> searchGSGWZY(@RequestBody OrmOrgSearchContext context) {
        Page<OrmOrg> domains = ormorgService.searchGSGWZY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-SubSubOrg-all')")
	@ApiOperation(value = "fetch显示当前组织下组织", tags = {"OrmOrg" } ,notes = "fetch显示当前组织下组织")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchsubsuborg")
	public ResponseEntity<List<OrmOrgDTO>> fetchSubSubOrg(OrmOrgSearchContext context) {
        Page<OrmOrg> domains = ormorgService.searchSubSubOrg(context) ;
        List<OrmOrgDTO> list = ormorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-SubSubOrg-all')")
	@ApiOperation(value = "search显示当前组织下组织", tags = {"OrmOrg" } ,notes = "search显示当前组织下组织")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchsubsuborg")
	public ResponseEntity<Page<OrmOrgDTO>> searchSubSubOrg(@RequestBody OrmOrgSearchContext context) {
        Page<OrmOrg> domains = ormorgService.searchSubSubOrg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"OrmOrg" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchdefault")
	public ResponseEntity<List<OrmOrgDTO>> fetchDefault(OrmOrgSearchContext context) {
        Page<OrmOrg> domains = ormorgService.searchDefault(context) ;
        List<OrmOrgDTO> list = ormorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"OrmOrg" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchdefault")
	public ResponseEntity<Page<OrmOrgDTO>> searchDefault(@RequestBody OrmOrgSearchContext context) {
        Page<OrmOrg> domains = ormorgService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-CurChild-all')")
	@ApiOperation(value = "fetch子组织查询", tags = {"OrmOrg" } ,notes = "fetch子组织查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchcurchild")
	public ResponseEntity<List<OrmOrgDTO>> fetchCurChild(OrmOrgSearchContext context) {
        Page<OrmOrg> domains = ormorgService.searchCurChild(context) ;
        List<OrmOrgDTO> list = ormorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-CurChild-all')")
	@ApiOperation(value = "search子组织查询", tags = {"OrmOrg" } ,notes = "search子组织查询")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchcurchild")
	public ResponseEntity<Page<OrmOrgDTO>> searchCurChild(@RequestBody OrmOrgSearchContext context) {
        Page<OrmOrg> domains = ormorgService.searchCurChild(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-SJYXZZ-all')")
	@ApiOperation(value = "fetch三级组织及以下组织", tags = {"OrmOrg" } ,notes = "fetch三级组织及以下组织")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchsjyxzz")
	public ResponseEntity<List<OrmOrgDTO>> fetchSJYXZZ(OrmOrgSearchContext context) {
        Page<OrmOrg> domains = ormorgService.searchSJYXZZ(context) ;
        List<OrmOrgDTO> list = ormorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-SJYXZZ-all')")
	@ApiOperation(value = "search三级组织及以下组织", tags = {"OrmOrg" } ,notes = "search三级组织及以下组织")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchsjyxzz")
	public ResponseEntity<Page<OrmOrgDTO>> searchSJYXZZ(@RequestBody OrmOrgSearchContext context) {
        Page<OrmOrg> domains = ormorgService.searchSJYXZZ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-REP_ORGPNUM-all')")
	@ApiOperation(value = "fetch组织人员总数", tags = {"OrmOrg" } ,notes = "fetch组织人员总数")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchrep_orgpnum")
	public ResponseEntity<List<HashMap>> fetchREP_ORGPNUM(OrmOrgSearchContext context) {
        Page<HashMap> domains = ormorgService.searchREP_ORGPNUM(context) ;
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(domains.getContent());
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-REP_ORGPNUM-all')")
	@ApiOperation(value = "search组织人员总数", tags = {"OrmOrg" } ,notes = "search组织人员总数")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchrep_orgpnum")
	public ResponseEntity<Page<HashMap>> searchREP_ORGPNUM(@RequestBody OrmOrgSearchContext context) {
        Page<HashMap> domains = ormorgService.searchREP_ORGPNUM(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(domains.getContent(), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-KZSJZZXZ-all')")
	@ApiOperation(value = "fetch用于控制当前用户选择视图下拉显示（上级组织）", tags = {"OrmOrg" } ,notes = "fetch用于控制当前用户选择视图下拉显示（上级组织）")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchkzsjzzxz")
	public ResponseEntity<List<OrmOrgDTO>> fetchKZSJZZXZ(OrmOrgSearchContext context) {
        Page<OrmOrg> domains = ormorgService.searchKZSJZZXZ(context) ;
        List<OrmOrgDTO> list = ormorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-KZSJZZXZ-all')")
	@ApiOperation(value = "search用于控制当前用户选择视图下拉显示（上级组织）", tags = {"OrmOrg" } ,notes = "search用于控制当前用户选择视图下拉显示（上级组织）")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchkzsjzzxz")
	public ResponseEntity<Page<OrmOrgDTO>> searchKZSJZZXZ(@RequestBody OrmOrgSearchContext context) {
        Page<OrmOrg> domains = ormorgService.searchKZSJZZXZ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-DanQian-all')")
	@ApiOperation(value = "fetch查询当前登录人组织下的组织（包含当前组织）", tags = {"OrmOrg" } ,notes = "fetch查询当前登录人组织下的组织（包含当前组织）")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchdanqian")
	public ResponseEntity<List<OrmOrgDTO>> fetchDanQian(OrmOrgSearchContext context) {
        Page<OrmOrg> domains = ormorgService.searchDanQian(context) ;
        List<OrmOrgDTO> list = ormorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-DanQian-all')")
	@ApiOperation(value = "search查询当前登录人组织下的组织（包含当前组织）", tags = {"OrmOrg" } ,notes = "search查询当前登录人组织下的组织（包含当前组织）")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchdanqian")
	public ResponseEntity<Page<OrmOrgDTO>> searchDanQian(@RequestBody OrmOrgSearchContext context) {
        Page<OrmOrg> domains = ormorgService.searchDanQian(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-AllLevelTwoOrg-all')")
	@ApiOperation(value = "fetch全部二级单位", tags = {"OrmOrg" } ,notes = "fetch全部二级单位")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchallleveltwoorg")
	public ResponseEntity<List<OrmOrgDTO>> fetchAllLevelTwoOrg(OrmOrgSearchContext context) {
        Page<OrmOrg> domains = ormorgService.searchAllLevelTwoOrg(context) ;
        List<OrmOrgDTO> list = ormorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-AllLevelTwoOrg-all')")
	@ApiOperation(value = "search全部二级单位", tags = {"OrmOrg" } ,notes = "search全部二级单位")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchallleveltwoorg")
	public ResponseEntity<Page<OrmOrgDTO>> searchAllLevelTwoOrg(@RequestBody OrmOrgSearchContext context) {
        Page<OrmOrg> domains = ormorgService.searchAllLevelTwoOrg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-SubOrg-all')")
	@ApiOperation(value = "fetch显示当前组织包含所有组织", tags = {"OrmOrg" } ,notes = "fetch显示当前组织包含所有组织")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchsuborg")
	public ResponseEntity<List<OrmOrgDTO>> fetchSubOrg(OrmOrgSearchContext context) {
        Page<OrmOrg> domains = ormorgService.searchSubOrg(context) ;
        List<OrmOrgDTO> list = ormorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-SubOrg-all')")
	@ApiOperation(value = "search显示当前组织包含所有组织", tags = {"OrmOrg" } ,notes = "search显示当前组织包含所有组织")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchsuborg")
	public ResponseEntity<Page<OrmOrgDTO>> searchSubOrg(@RequestBody OrmOrgSearchContext context) {
        Page<OrmOrg> domains = ormorgService.searchSubOrg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-HTGLDW-all')")
	@ApiOperation(value = "fetch合同管理单位", tags = {"OrmOrg" } ,notes = "fetch合同管理单位")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchhtgldw")
	public ResponseEntity<List<OrmOrgDTO>> fetchHTGLDW(OrmOrgSearchContext context) {
        Page<OrmOrg> domains = ormorgService.searchHTGLDW(context) ;
        List<OrmOrgDTO> list = ormorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-HTGLDW-all')")
	@ApiOperation(value = "search合同管理单位", tags = {"OrmOrg" } ,notes = "search合同管理单位")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchhtgldw")
	public ResponseEntity<Page<OrmOrgDTO>> searchHTGLDW(@RequestBody OrmOrgSearchContext context) {
        Page<OrmOrg> domains = ormorgService.searchHTGLDW(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-KZXLXZ-all')")
	@ApiOperation(value = "fetch用于控制当前用户选择视图下拉显示（当前组织）", tags = {"OrmOrg" } ,notes = "fetch用于控制当前用户选择视图下拉显示（当前组织）")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchkzxlxz")
	public ResponseEntity<List<OrmOrgDTO>> fetchKZXLXZ(OrmOrgSearchContext context) {
        Page<OrmOrg> domains = ormorgService.searchKZXLXZ(context) ;
        List<OrmOrgDTO> list = ormorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-KZXLXZ-all')")
	@ApiOperation(value = "search用于控制当前用户选择视图下拉显示（当前组织）", tags = {"OrmOrg" } ,notes = "search用于控制当前用户选择视图下拉显示（当前组织）")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchkzxlxz")
	public ResponseEntity<Page<OrmOrgDTO>> searchKZXLXZ(@RequestBody OrmOrgSearchContext context) {
        Page<OrmOrg> domains = ormorgService.searchKZXLXZ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-AuthSJYXZZ-all')")
	@ApiOperation(value = "fetch三级组织及以下组织（权限控制）", tags = {"OrmOrg" } ,notes = "fetch三级组织及以下组织（权限控制）")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchauthsjyxzz")
	public ResponseEntity<List<OrmOrgDTO>> fetchAuthSJYXZZ(OrmOrgSearchContext context) {
        Page<OrmOrg> domains = ormorgService.searchAuthSJYXZZ(context) ;
        List<OrmOrgDTO> list = ormorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-AuthSJYXZZ-all')")
	@ApiOperation(value = "search三级组织及以下组织（权限控制）", tags = {"OrmOrg" } ,notes = "search三级组织及以下组织（权限控制）")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchauthsjyxzz")
	public ResponseEntity<Page<OrmOrgDTO>> searchAuthSJYXZZ(@RequestBody OrmOrgSearchContext context) {
        Page<OrmOrg> domains = ormorgService.searchAuthSJYXZZ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-UseByFP-all')")
	@ApiOperation(value = "fetch分配信息专用（组织过滤）", tags = {"OrmOrg" } ,notes = "fetch分配信息专用（组织过滤）")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchusebyfp")
	public ResponseEntity<List<OrmOrgDTO>> fetchUseByFP(OrmOrgSearchContext context) {
        Page<OrmOrg> domains = ormorgService.searchUseByFP(context) ;
        List<OrmOrgDTO> list = ormorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-UseByFP-all')")
	@ApiOperation(value = "search分配信息专用（组织过滤）", tags = {"OrmOrg" } ,notes = "search分配信息专用（组织过滤）")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchusebyfp")
	public ResponseEntity<Page<OrmOrgDTO>> searchUseByFP(@RequestBody OrmOrgSearchContext context) {
        Page<OrmOrg> domains = ormorgService.searchUseByFP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-CurPorg-all')")
	@ApiOperation(value = "fetch根组织查询", tags = {"OrmOrg" } ,notes = "fetch根组织查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchcurporg")
	public ResponseEntity<List<OrmOrgDTO>> fetchCurPorg(OrmOrgSearchContext context) {
        Page<OrmOrg> domains = ormorgService.searchCurPorg(context) ;
        List<OrmOrgDTO> list = ormorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmOrg-CurPorg-all')")
	@ApiOperation(value = "search根组织查询", tags = {"OrmOrg" } ,notes = "search根组织查询")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchcurporg")
	public ResponseEntity<Page<OrmOrgDTO>> searchCurPorg(@RequestBody OrmOrgSearchContext context) {
        Page<OrmOrg> domains = ormorgService.searchCurPorg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

