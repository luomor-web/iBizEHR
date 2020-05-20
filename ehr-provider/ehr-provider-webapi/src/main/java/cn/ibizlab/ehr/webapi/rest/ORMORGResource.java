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
import cn.ibizlab.ehr.core.orm.domain.ORMORG;
import cn.ibizlab.ehr.core.orm.service.IORMORGService;
import cn.ibizlab.ehr.core.orm.filter.ORMORGSearchContext;




@Slf4j
@Api(tags = {"ORMORG" })
@RestController("WebApi-ormorg")
@RequestMapping("")
public class ORMORGResource {

    @Autowired
    private IORMORGService ormorgService;

    @Autowired
    @Lazy
    private ORMORGMapping ormorgMapping;




    @PreAuthorize("hasPermission(#ormorg_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"ORMORG" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}")
    @Transactional
    public ResponseEntity<ORMORGDTO> update(@PathVariable("ormorg_id") String ormorg_id, @RequestBody ORMORGDTO ormorgdto) {
		ORMORG domain = ormorgMapping.toDomain(ormorgdto);
        domain.setOrgid(ormorg_id);
		ormorgService.update(domain);
		ORMORGDTO dto = ormorgMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#ormorg_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"ORMORG" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ORMORGDTO> ormorgdtos) {
        ormorgService.updateBatch(ormorgMapping.toDomain(ormorgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "设置默认排序信息", tags = {"ORMORG" },  notes = "设置默认排序信息")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/synorg")
    @Transactional
    public ResponseEntity<ORMORGDTO> synOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody ORMORGDTO ormorgdto) {
        ORMORG ormorg = ormorgMapping.toDomain(ormorgdto);
        ormorg = ormorgService.synOrg(ormorg);
        ormorgdto = ormorgMapping.toDto(ormorg);
        return ResponseEntity.status(HttpStatus.OK).body(ormorgdto);
    }




    @PreAuthorize("hasPermission('Remove',{#ormorg_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"ORMORG" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormorg_id") String ormorg_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormorgService.remove(ormorg_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"ORMORG" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormorgService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"ORMORG" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/getdraft")
    public ResponseEntity<ORMORGDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormorgMapping.toDto(ormorgService.getDraft(new ORMORG())));
    }




    @PreAuthorize("hasPermission(#ormorg_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"ORMORG" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}")
    public ResponseEntity<ORMORGDTO> get(@PathVariable("ormorg_id") String ormorg_id) {
        ORMORG domain = ormorgService.get(ormorg_id);
        ORMORGDTO dto = ormorgMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "CheckKey", tags = {"ORMORG" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ORMORGDTO ormorgdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormorgService.checkKey(ormorgMapping.toDomain(ormorgdto)));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"ORMORG" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs")
    @Transactional
    public ResponseEntity<ORMORGDTO> create(@RequestBody ORMORGDTO ormorgdto) {
        ORMORG domain = ormorgMapping.toDomain(ormorgdto);
		ormorgService.create(domain);
        ORMORGDTO dto = ormorgMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"ORMORG" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ORMORGDTO> ormorgdtos) {
        ormorgService.createBatch(ormorgMapping.toDomain(ormorgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"ORMORG" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/save")
    public ResponseEntity<Boolean> save(@RequestBody ORMORGDTO ormorgdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormorgService.save(ormorgMapping.toDomain(ormorgdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"ORMORG" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ORMORGDTO> ormorgdtos) {
        ormorgService.saveBatch(ormorgMapping.toDomain(ormorgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetch全部法人主体", tags = {"ORMORG" } ,notes = "fetch全部法人主体")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchallsignorg")
	public ResponseEntity<List<ORMORGDTO>> fetchALLSIGNORG(ORMORGSearchContext context) {
        Page<ORMORG> domains = ormorgService.searchALLSIGNORG(context) ;
        List<ORMORGDTO> list = ormorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search全部法人主体", tags = {"ORMORG" } ,notes = "search全部法人主体")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchallsignorg")
	public ResponseEntity<Page<ORMORGDTO>> searchALLSIGNORG(@RequestBody ORMORGSearchContext context) {
        Page<ORMORG> domains = ormorgService.searchALLSIGNORG(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch全部二级单位（无权限）", tags = {"ORMORG" } ,notes = "fetch全部二级单位（无权限）")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchallleveltwoorg2")
	public ResponseEntity<List<ORMORGDTO>> fetchAllLevelTwoOrg2(ORMORGSearchContext context) {
        Page<ORMORG> domains = ormorgService.searchAllLevelTwoOrg2(context) ;
        List<ORMORGDTO> list = ormorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search全部二级单位（无权限）", tags = {"ORMORG" } ,notes = "search全部二级单位（无权限）")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchallleveltwoorg2")
	public ResponseEntity<Page<ORMORGDTO>> searchAllLevelTwoOrg2(@RequestBody ORMORGSearchContext context) {
        Page<ORMORG> domains = ormorgService.searchAllLevelTwoOrg2(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch当前可选择组织列表（应聘者信息使用）", tags = {"ORMORG" } ,notes = "fetch当前可选择组织列表（应聘者信息使用）")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchorglist_profile")
	public ResponseEntity<List<ORMORGDTO>> fetchOrglist_Profile(ORMORGSearchContext context) {
        Page<ORMORG> domains = ormorgService.searchOrglist_Profile(context) ;
        List<ORMORGDTO> list = ormorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search当前可选择组织列表（应聘者信息使用）", tags = {"ORMORG" } ,notes = "search当前可选择组织列表（应聘者信息使用）")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchorglist_profile")
	public ResponseEntity<Page<ORMORGDTO>> searchOrglist_Profile(@RequestBody ORMORGSearchContext context) {
        Page<ORMORG> domains = ormorgService.searchOrglist_Profile(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch组织分布", tags = {"ORMORG" } ,notes = "fetch组织分布")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchrep_org")
	public ResponseEntity<List<HashMap>> fetchREP_ORG(ORMORGSearchContext context) {
        Page<HashMap> domains = ormorgService.searchREP_ORG(context) ;
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(domains.getContent());
	}

	@ApiOperation(value = "search组织分布", tags = {"ORMORG" } ,notes = "search组织分布")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchrep_org")
	public ResponseEntity<Page<HashMap>> searchREP_ORG(@RequestBody ORMORGSearchContext context) {
        Page<HashMap> domains = ormorgService.searchREP_ORG(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(domains.getContent(), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch显示组织(权限控制)", tags = {"ORMORG" } ,notes = "fetch显示组织(权限控制)")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchauthorg")
	public ResponseEntity<List<ORMORGDTO>> fetchAuthOrg(ORMORGSearchContext context) {
        Page<ORMORG> domains = ormorgService.searchAuthOrg(context) ;
        List<ORMORGDTO> list = ormorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search显示组织(权限控制)", tags = {"ORMORG" } ,notes = "search显示组织(权限控制)")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchauthorg")
	public ResponseEntity<Page<ORMORGDTO>> searchAuthOrg(@RequestBody ORMORGSearchContext context) {
        Page<ORMORG> domains = ormorgService.searchAuthOrg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch用于控制当前用户选择视图下拉显示（公司级岗位专用）", tags = {"ORMORG" } ,notes = "fetch用于控制当前用户选择视图下拉显示（公司级岗位专用）")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchgsgwzy")
	public ResponseEntity<List<ORMORGDTO>> fetchGSGWZY(ORMORGSearchContext context) {
        Page<ORMORG> domains = ormorgService.searchGSGWZY(context) ;
        List<ORMORGDTO> list = ormorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search用于控制当前用户选择视图下拉显示（公司级岗位专用）", tags = {"ORMORG" } ,notes = "search用于控制当前用户选择视图下拉显示（公司级岗位专用）")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchgsgwzy")
	public ResponseEntity<Page<ORMORGDTO>> searchGSGWZY(@RequestBody ORMORGSearchContext context) {
        Page<ORMORG> domains = ormorgService.searchGSGWZY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch显示当前组织下组织", tags = {"ORMORG" } ,notes = "fetch显示当前组织下组织")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchsubsuborg")
	public ResponseEntity<List<ORMORGDTO>> fetchSubSubOrg(ORMORGSearchContext context) {
        Page<ORMORG> domains = ormorgService.searchSubSubOrg(context) ;
        List<ORMORGDTO> list = ormorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search显示当前组织下组织", tags = {"ORMORG" } ,notes = "search显示当前组织下组织")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchsubsuborg")
	public ResponseEntity<Page<ORMORGDTO>> searchSubSubOrg(@RequestBody ORMORGSearchContext context) {
        Page<ORMORG> domains = ormorgService.searchSubSubOrg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetchDEFAULT", tags = {"ORMORG" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchdefault")
	public ResponseEntity<List<ORMORGDTO>> fetchDefault(ORMORGSearchContext context) {
        Page<ORMORG> domains = ormorgService.searchDefault(context) ;
        List<ORMORGDTO> list = ormorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"ORMORG" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchdefault")
	public ResponseEntity<Page<ORMORGDTO>> searchDefault(@RequestBody ORMORGSearchContext context) {
        Page<ORMORG> domains = ormorgService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch子组织查询", tags = {"ORMORG" } ,notes = "fetch子组织查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchcurchild")
	public ResponseEntity<List<ORMORGDTO>> fetchCurChild(ORMORGSearchContext context) {
        Page<ORMORG> domains = ormorgService.searchCurChild(context) ;
        List<ORMORGDTO> list = ormorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search子组织查询", tags = {"ORMORG" } ,notes = "search子组织查询")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchcurchild")
	public ResponseEntity<Page<ORMORGDTO>> searchCurChild(@RequestBody ORMORGSearchContext context) {
        Page<ORMORG> domains = ormorgService.searchCurChild(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch三级组织及以下组织", tags = {"ORMORG" } ,notes = "fetch三级组织及以下组织")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchsjyxzz")
	public ResponseEntity<List<ORMORGDTO>> fetchSJYXZZ(ORMORGSearchContext context) {
        Page<ORMORG> domains = ormorgService.searchSJYXZZ(context) ;
        List<ORMORGDTO> list = ormorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search三级组织及以下组织", tags = {"ORMORG" } ,notes = "search三级组织及以下组织")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchsjyxzz")
	public ResponseEntity<Page<ORMORGDTO>> searchSJYXZZ(@RequestBody ORMORGSearchContext context) {
        Page<ORMORG> domains = ormorgService.searchSJYXZZ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch组织人员总数", tags = {"ORMORG" } ,notes = "fetch组织人员总数")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchrep_orgpnum")
	public ResponseEntity<List<HashMap>> fetchREP_ORGPNUM(ORMORGSearchContext context) {
        Page<HashMap> domains = ormorgService.searchREP_ORGPNUM(context) ;
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(domains.getContent());
	}

	@ApiOperation(value = "search组织人员总数", tags = {"ORMORG" } ,notes = "search组织人员总数")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchrep_orgpnum")
	public ResponseEntity<Page<HashMap>> searchREP_ORGPNUM(@RequestBody ORMORGSearchContext context) {
        Page<HashMap> domains = ormorgService.searchREP_ORGPNUM(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(domains.getContent(), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch用于控制当前用户选择视图下拉显示（上级组织）", tags = {"ORMORG" } ,notes = "fetch用于控制当前用户选择视图下拉显示（上级组织）")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchkzsjzzxz")
	public ResponseEntity<List<ORMORGDTO>> fetchKZSJZZXZ(ORMORGSearchContext context) {
        Page<ORMORG> domains = ormorgService.searchKZSJZZXZ(context) ;
        List<ORMORGDTO> list = ormorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search用于控制当前用户选择视图下拉显示（上级组织）", tags = {"ORMORG" } ,notes = "search用于控制当前用户选择视图下拉显示（上级组织）")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchkzsjzzxz")
	public ResponseEntity<Page<ORMORGDTO>> searchKZSJZZXZ(@RequestBody ORMORGSearchContext context) {
        Page<ORMORG> domains = ormorgService.searchKZSJZZXZ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch查询当前登录人组织下的组织（包含当前组织）", tags = {"ORMORG" } ,notes = "fetch查询当前登录人组织下的组织（包含当前组织）")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchdanqian")
	public ResponseEntity<List<ORMORGDTO>> fetchDanQian(ORMORGSearchContext context) {
        Page<ORMORG> domains = ormorgService.searchDanQian(context) ;
        List<ORMORGDTO> list = ormorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search查询当前登录人组织下的组织（包含当前组织）", tags = {"ORMORG" } ,notes = "search查询当前登录人组织下的组织（包含当前组织）")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchdanqian")
	public ResponseEntity<Page<ORMORGDTO>> searchDanQian(@RequestBody ORMORGSearchContext context) {
        Page<ORMORG> domains = ormorgService.searchDanQian(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch全部二级单位", tags = {"ORMORG" } ,notes = "fetch全部二级单位")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchallleveltwoorg")
	public ResponseEntity<List<ORMORGDTO>> fetchAllLevelTwoOrg(ORMORGSearchContext context) {
        Page<ORMORG> domains = ormorgService.searchAllLevelTwoOrg(context) ;
        List<ORMORGDTO> list = ormorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search全部二级单位", tags = {"ORMORG" } ,notes = "search全部二级单位")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchallleveltwoorg")
	public ResponseEntity<Page<ORMORGDTO>> searchAllLevelTwoOrg(@RequestBody ORMORGSearchContext context) {
        Page<ORMORG> domains = ormorgService.searchAllLevelTwoOrg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch显示当前组织包含所有组织", tags = {"ORMORG" } ,notes = "fetch显示当前组织包含所有组织")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchsuborg")
	public ResponseEntity<List<ORMORGDTO>> fetchSubOrg(ORMORGSearchContext context) {
        Page<ORMORG> domains = ormorgService.searchSubOrg(context) ;
        List<ORMORGDTO> list = ormorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search显示当前组织包含所有组织", tags = {"ORMORG" } ,notes = "search显示当前组织包含所有组织")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchsuborg")
	public ResponseEntity<Page<ORMORGDTO>> searchSubOrg(@RequestBody ORMORGSearchContext context) {
        Page<ORMORG> domains = ormorgService.searchSubOrg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch合同管理单位", tags = {"ORMORG" } ,notes = "fetch合同管理单位")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchhtgldw")
	public ResponseEntity<List<ORMORGDTO>> fetchHTGLDW(ORMORGSearchContext context) {
        Page<ORMORG> domains = ormorgService.searchHTGLDW(context) ;
        List<ORMORGDTO> list = ormorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search合同管理单位", tags = {"ORMORG" } ,notes = "search合同管理单位")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchhtgldw")
	public ResponseEntity<Page<ORMORGDTO>> searchHTGLDW(@RequestBody ORMORGSearchContext context) {
        Page<ORMORG> domains = ormorgService.searchHTGLDW(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch用于控制当前用户选择视图下拉显示（当前组织）", tags = {"ORMORG" } ,notes = "fetch用于控制当前用户选择视图下拉显示（当前组织）")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchkzxlxz")
	public ResponseEntity<List<ORMORGDTO>> fetchKZXLXZ(ORMORGSearchContext context) {
        Page<ORMORG> domains = ormorgService.searchKZXLXZ(context) ;
        List<ORMORGDTO> list = ormorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search用于控制当前用户选择视图下拉显示（当前组织）", tags = {"ORMORG" } ,notes = "search用于控制当前用户选择视图下拉显示（当前组织）")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchkzxlxz")
	public ResponseEntity<Page<ORMORGDTO>> searchKZXLXZ(@RequestBody ORMORGSearchContext context) {
        Page<ORMORG> domains = ormorgService.searchKZXLXZ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch三级组织及以下组织（权限控制）", tags = {"ORMORG" } ,notes = "fetch三级组织及以下组织（权限控制）")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchauthsjyxzz")
	public ResponseEntity<List<ORMORGDTO>> fetchAuthSJYXZZ(ORMORGSearchContext context) {
        Page<ORMORG> domains = ormorgService.searchAuthSJYXZZ(context) ;
        List<ORMORGDTO> list = ormorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search三级组织及以下组织（权限控制）", tags = {"ORMORG" } ,notes = "search三级组织及以下组织（权限控制）")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchauthsjyxzz")
	public ResponseEntity<Page<ORMORGDTO>> searchAuthSJYXZZ(@RequestBody ORMORGSearchContext context) {
        Page<ORMORG> domains = ormorgService.searchAuthSJYXZZ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch分配信息专用（组织过滤）", tags = {"ORMORG" } ,notes = "fetch分配信息专用（组织过滤）")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchusebyfp")
	public ResponseEntity<List<ORMORGDTO>> fetchUseByFP(ORMORGSearchContext context) {
        Page<ORMORG> domains = ormorgService.searchUseByFP(context) ;
        List<ORMORGDTO> list = ormorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search分配信息专用（组织过滤）", tags = {"ORMORG" } ,notes = "search分配信息专用（组织过滤）")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchusebyfp")
	public ResponseEntity<Page<ORMORGDTO>> searchUseByFP(@RequestBody ORMORGSearchContext context) {
        Page<ORMORG> domains = ormorgService.searchUseByFP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch根组织查询", tags = {"ORMORG" } ,notes = "fetch根组织查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/fetchcurporg")
	public ResponseEntity<List<ORMORGDTO>> fetchCurPorg(ORMORGSearchContext context) {
        Page<ORMORG> domains = ormorgService.searchCurPorg(context) ;
        List<ORMORGDTO> list = ormorgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "search根组织查询", tags = {"ORMORG" } ,notes = "search根组织查询")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/searchcurporg")
	public ResponseEntity<Page<ORMORGDTO>> searchCurPorg(@RequestBody ORMORGSearchContext context) {
        Page<ORMORG> domains = ormorgService.searchCurPorg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormorgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public ORMORG getEntity(){
        return new ORMORG();
    }

}
