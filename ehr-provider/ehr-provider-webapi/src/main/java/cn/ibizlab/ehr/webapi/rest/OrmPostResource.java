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
import cn.ibizlab.ehr.core.orm.domain.OrmPost;
import cn.ibizlab.ehr.core.orm.service.IOrmPostService;
import cn.ibizlab.ehr.core.orm.filter.OrmPostSearchContext;

@Slf4j
@Api(tags = {"岗位" })
@RestController("WebApi-ormpost")
@RequestMapping("")
public class OrmPostResource {

    @Autowired
    public IOrmPostService ormpostService;

    @Autowired
    @Lazy
    public OrmPostMapping ormpostMapping;

    @PreAuthorize("hasPermission(this.ormpostMapping.toDomain(#ormpostdto),'ehr-OrmPost-Save')")
    @ApiOperation(value = "保存岗位", tags = {"岗位" },  notes = "保存岗位")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/save")
    public ResponseEntity<Boolean> save(@RequestBody OrmPostDTO ormpostdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormpostService.save(ormpostMapping.toDomain(ormpostdto)));
    }

    @PreAuthorize("hasPermission(this.ormpostMapping.toDomain(#ormpostdtos),'ehr-OrmPost-Save')")
    @ApiOperation(value = "批量保存岗位", tags = {"岗位" },  notes = "批量保存岗位")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrmPostDTO> ormpostdtos) {
        ormpostService.saveBatch(ormpostMapping.toDomain(ormpostdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查岗位", tags = {"岗位" },  notes = "检查岗位")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrmPostDTO ormpostdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormpostService.checkKey(ormpostMapping.toDomain(ormpostdto)));
    }

    @PreAuthorize("hasPermission(this.ormpostMapping.toDomain(#ormpostdto),'ehr-OrmPost-Create')")
    @ApiOperation(value = "新建岗位", tags = {"岗位" },  notes = "新建岗位")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts")
    @Transactional
    public ResponseEntity<OrmPostDTO> create(@RequestBody OrmPostDTO ormpostdto) {
        OrmPost domain = ormpostMapping.toDomain(ormpostdto);
		ormpostService.create(domain);
        OrmPostDTO dto = ormpostMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormpostMapping.toDomain(#ormpostdtos),'ehr-OrmPost-Create')")
    @ApiOperation(value = "批量新建岗位", tags = {"岗位" },  notes = "批量新建岗位")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrmPostDTO> ormpostdtos) {
        ormpostService.createBatch(ormpostMapping.toDomain(ormpostdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormpostMapping.toDomain(returnObject.body),'ehr-OrmPost-Get')")
    @ApiOperation(value = "获取岗位", tags = {"岗位" },  notes = "获取岗位")
	@RequestMapping(method = RequestMethod.GET, value = "/ormposts/{ormpost_id}")
    public ResponseEntity<OrmPostDTO> get(@PathVariable("ormpost_id") String ormpost_id) {
        OrmPost domain = ormpostService.get(ormpost_id);
        OrmPostDTO dto = ormpostMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-SetGwJb-all')")
    @ApiOperation(value = "计算岗位分类级别", tags = {"岗位" },  notes = "计算岗位分类级别")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/setgwjb")
    @Transactional
    public ResponseEntity<OrmPostDTO> setGwJb(@PathVariable("ormpost_id") String ormpost_id, @RequestBody OrmPostDTO ormpostdto) {
        OrmPost ormpost = ormpostMapping.toDomain(ormpostdto);
        ormpost.setOrmpostid(ormpost_id);
        ormpost = ormpostService.setGwJb(ormpost);
        ormpostdto = ormpostMapping.toDto(ormpost);
        return ResponseEntity.status(HttpStatus.OK).body(ormpostdto);
    }

    @PreAuthorize("hasPermission(this.ormpostService.get(#ormpost_id),'ehr-OrmPost-Update')")
    @ApiOperation(value = "更新岗位", tags = {"岗位" },  notes = "更新岗位")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormposts/{ormpost_id}")
    @Transactional
    public ResponseEntity<OrmPostDTO> update(@PathVariable("ormpost_id") String ormpost_id, @RequestBody OrmPostDTO ormpostdto) {
		OrmPost domain  = ormpostMapping.toDomain(ormpostdto);
        domain .setOrmpostid(ormpost_id);
		ormpostService.update(domain );
		OrmPostDTO dto = ormpostMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormpostService.getOrmpostByEntities(this.ormpostMapping.toDomain(#ormpostdtos)),'ehr-OrmPost-Update')")
    @ApiOperation(value = "批量更新岗位", tags = {"岗位" },  notes = "批量更新岗位")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormposts/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrmPostDTO> ormpostdtos) {
        ormpostService.updateBatch(ormpostMapping.toDomain(ormpostdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormpostService.get(#ormpost_id),'ehr-OrmPost-Remove')")
    @ApiOperation(value = "删除岗位", tags = {"岗位" },  notes = "删除岗位")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormposts/{ormpost_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormpost_id") String ormpost_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormpostService.remove(ormpost_id));
    }

    @PreAuthorize("hasPermission(this.ormpostService.getOrmpostByIds(#ids),'ehr-OrmPost-Remove')")
    @ApiOperation(value = "批量删除岗位", tags = {"岗位" },  notes = "批量删除岗位")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormposts/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormpostService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取岗位草稿", tags = {"岗位" },  notes = "获取岗位草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/ormposts/getdraft")
    public ResponseEntity<OrmPostDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormpostMapping.toDto(ormpostService.getDraft(new OrmPost())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-EJZZGW-all')")
	@ApiOperation(value = "获取根据选择的组织所属的二级组织来获取岗位(ormorgid)", tags = {"岗位" } ,notes = "获取根据选择的组织所属的二级组织来获取岗位(ormorgid)")
    @RequestMapping(method= RequestMethod.GET , value="/ormposts/fetchejzzgw")
	public ResponseEntity<List<OrmPostDTO>> fetchEJZZGW(OrmPostSearchContext context) {
        Page<OrmPost> domains = ormpostService.searchEJZZGW(context) ;
        List<OrmPostDTO> list = ormpostMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-EJZZGW-all')")
	@ApiOperation(value = "查询根据选择的组织所属的二级组织来获取岗位(ormorgid)", tags = {"岗位" } ,notes = "查询根据选择的组织所属的二级组织来获取岗位(ormorgid)")
    @RequestMapping(method= RequestMethod.POST , value="/ormposts/searchejzzgw")
	public ResponseEntity<Page<OrmPostDTO>> searchEJZZGW(@RequestBody OrmPostSearchContext context) {
        Page<OrmPost> domains = ormpostService.searchEJZZGW(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-AuthPost-all')")
	@ApiOperation(value = "获取AuthPost", tags = {"岗位" } ,notes = "获取AuthPost")
    @RequestMapping(method= RequestMethod.GET , value="/ormposts/fetchauthpost")
	public ResponseEntity<List<OrmPostDTO>> fetchAuthPost(OrmPostSearchContext context) {
        Page<OrmPost> domains = ormpostService.searchAuthPost(context) ;
        List<OrmPostDTO> list = ormpostMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-AuthPost-all')")
	@ApiOperation(value = "查询AuthPost", tags = {"岗位" } ,notes = "查询AuthPost")
    @RequestMapping(method= RequestMethod.POST , value="/ormposts/searchauthpost")
	public ResponseEntity<Page<OrmPostDTO>> searchAuthPost(@RequestBody OrmPostSearchContext context) {
        Page<OrmPost> domains = ormpostService.searchAuthPost(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-CurOrg-all')")
	@ApiOperation(value = "获取根据当前操作人的身份选择岗位", tags = {"岗位" } ,notes = "获取根据当前操作人的身份选择岗位")
    @RequestMapping(method= RequestMethod.GET , value="/ormposts/fetchcurorg")
	public ResponseEntity<List<OrmPostDTO>> fetchCurOrg(OrmPostSearchContext context) {
        Page<OrmPost> domains = ormpostService.searchCurOrg(context) ;
        List<OrmPostDTO> list = ormpostMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-CurOrg-all')")
	@ApiOperation(value = "查询根据当前操作人的身份选择岗位", tags = {"岗位" } ,notes = "查询根据当前操作人的身份选择岗位")
    @RequestMapping(method= RequestMethod.POST , value="/ormposts/searchcurorg")
	public ResponseEntity<Page<OrmPostDTO>> searchCurOrg(@RequestBody OrmPostSearchContext context) {
        Page<OrmPost> domains = ormpostService.searchCurOrg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-DQGW-all')")
	@ApiOperation(value = "获取根据当前组织过滤岗位", tags = {"岗位" } ,notes = "获取根据当前组织过滤岗位")
    @RequestMapping(method= RequestMethod.GET , value="/ormposts/fetchdqgw")
	public ResponseEntity<List<OrmPostDTO>> fetchDQGW(OrmPostSearchContext context) {
        Page<OrmPost> domains = ormpostService.searchDQGW(context) ;
        List<OrmPostDTO> list = ormpostMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-DQGW-all')")
	@ApiOperation(value = "查询根据当前组织过滤岗位", tags = {"岗位" } ,notes = "查询根据当前组织过滤岗位")
    @RequestMapping(method= RequestMethod.POST , value="/ormposts/searchdqgw")
	public ResponseEntity<Page<OrmPostDTO>> searchDQGW(@RequestBody OrmPostSearchContext context) {
        Page<OrmPost> domains = ormpostService.searchDQGW(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-DQORGGW-all')")
	@ApiOperation(value = "获取根据当前组织过滤岗位(orgid)", tags = {"岗位" } ,notes = "获取根据当前组织过滤岗位(orgid)")
    @RequestMapping(method= RequestMethod.GET , value="/ormposts/fetchdqorggw")
	public ResponseEntity<List<OrmPostDTO>> fetchDQORGGW(OrmPostSearchContext context) {
        Page<OrmPost> domains = ormpostService.searchDQORGGW(context) ;
        List<OrmPostDTO> list = ormpostMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-DQORGGW-all')")
	@ApiOperation(value = "查询根据当前组织过滤岗位(orgid)", tags = {"岗位" } ,notes = "查询根据当前组织过滤岗位(orgid)")
    @RequestMapping(method= RequestMethod.POST , value="/ormposts/searchdqorggw")
	public ResponseEntity<Page<OrmPostDTO>> searchDQORGGW(@RequestBody OrmPostSearchContext context) {
        Page<OrmPost> domains = ormpostService.searchDQORGGW(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-GWXH-all')")
	@ApiOperation(value = "获取岗位查询", tags = {"岗位" } ,notes = "获取岗位查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormposts/fetchgwxh")
	public ResponseEntity<List<OrmPostDTO>> fetchGWXH(OrmPostSearchContext context) {
        Page<OrmPost> domains = ormpostService.searchGWXH(context) ;
        List<OrmPostDTO> list = ormpostMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-GWXH-all')")
	@ApiOperation(value = "查询岗位查询", tags = {"岗位" } ,notes = "查询岗位查询")
    @RequestMapping(method= RequestMethod.POST , value="/ormposts/searchgwxh")
	public ResponseEntity<Page<OrmPostDTO>> searchGWXH(@RequestBody OrmPostSearchContext context) {
        Page<OrmPost> domains = ormpostService.searchGWXH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"岗位" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormposts/fetchdefault")
	public ResponseEntity<List<OrmPostDTO>> fetchDefault(OrmPostSearchContext context) {
        Page<OrmPost> domains = ormpostService.searchDefault(context) ;
        List<OrmPostDTO> list = ormpostMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"岗位" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormposts/searchdefault")
	public ResponseEntity<Page<OrmPostDTO>> searchDefault(@RequestBody OrmPostSearchContext context) {
        Page<OrmPost> domains = ormpostService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-JZBGWCX-all')")
	@ApiOperation(value = "获取局总部岗位查询", tags = {"岗位" } ,notes = "获取局总部岗位查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormposts/fetchjzbgwcx")
	public ResponseEntity<List<OrmPostDTO>> fetchJZBGWCX(OrmPostSearchContext context) {
        Page<OrmPost> domains = ormpostService.searchJZBGWCX(context) ;
        List<OrmPostDTO> list = ormpostMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-JZBGWCX-all')")
	@ApiOperation(value = "查询局总部岗位查询", tags = {"岗位" } ,notes = "查询局总部岗位查询")
    @RequestMapping(method= RequestMethod.POST , value="/ormposts/searchjzbgwcx")
	public ResponseEntity<Page<OrmPostDTO>> searchJZBGWCX(@RequestBody OrmPostSearchContext context) {
        Page<OrmPost> domains = ormpostService.searchJZBGWCX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-CXGW-all')")
	@ApiOperation(value = "获取查询当前组织所属的二级单位岗位", tags = {"岗位" } ,notes = "获取查询当前组织所属的二级单位岗位")
    @RequestMapping(method= RequestMethod.GET , value="/ormposts/fetchcxgw")
	public ResponseEntity<List<OrmPostDTO>> fetchCXGW(OrmPostSearchContext context) {
        Page<OrmPost> domains = ormpostService.searchCXGW(context) ;
        List<OrmPostDTO> list = ormpostMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-CXGW-all')")
	@ApiOperation(value = "查询查询当前组织所属的二级单位岗位", tags = {"岗位" } ,notes = "查询查询当前组织所属的二级单位岗位")
    @RequestMapping(method= RequestMethod.POST , value="/ormposts/searchcxgw")
	public ResponseEntity<Page<OrmPostDTO>> searchCXGW(@RequestBody OrmPostSearchContext context) {
        Page<OrmPost> domains = ormpostService.searchCXGW(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.ormpostMapping.toDomain(#ormpostdto),'ehr-OrmPost-Save')")
    @ApiOperation(value = "根据组织管理保存岗位", tags = {"岗位" },  notes = "根据组织管理保存岗位")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormposts/save")
    public ResponseEntity<Boolean> saveByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmPostDTO ormpostdto) {
        OrmPost domain = ormpostMapping.toDomain(ormpostdto);
        domain.setOrmorgid(ormorg_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormpostService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormpostMapping.toDomain(#ormpostdtos),'ehr-OrmPost-Save')")
    @ApiOperation(value = "根据组织管理批量保存岗位", tags = {"岗位" },  notes = "根据组织管理批量保存岗位")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormposts/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody List<OrmPostDTO> ormpostdtos) {
        List<OrmPost> domainlist=ormpostMapping.toDomain(ormpostdtos);
        for(OrmPost domain:domainlist){
             domain.setOrmorgid(ormorg_id);
        }
        ormpostService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据组织管理检查岗位", tags = {"岗位" },  notes = "根据组织管理检查岗位")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormposts/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmPostDTO ormpostdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormpostService.checkKey(ormpostMapping.toDomain(ormpostdto)));
    }

    @PreAuthorize("hasPermission(this.ormpostMapping.toDomain(#ormpostdto),'ehr-OrmPost-Create')")
    @ApiOperation(value = "根据组织管理建立岗位", tags = {"岗位" },  notes = "根据组织管理建立岗位")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormposts")
    @Transactional
    public ResponseEntity<OrmPostDTO> createByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmPostDTO ormpostdto) {
        OrmPost domain = ormpostMapping.toDomain(ormpostdto);
        domain.setOrmorgid(ormorg_id);
		ormpostService.create(domain);
        OrmPostDTO dto = ormpostMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormpostMapping.toDomain(#ormpostdtos),'ehr-OrmPost-Create')")
    @ApiOperation(value = "根据组织管理批量建立岗位", tags = {"岗位" },  notes = "根据组织管理批量建立岗位")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormposts/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody List<OrmPostDTO> ormpostdtos) {
        List<OrmPost> domainlist=ormpostMapping.toDomain(ormpostdtos);
        for(OrmPost domain:domainlist){
            domain.setOrmorgid(ormorg_id);
        }
        ormpostService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormpostMapping.toDomain(returnObject.body),'ehr-OrmPost-Get')")
    @ApiOperation(value = "根据组织管理获取岗位", tags = {"岗位" },  notes = "根据组织管理获取岗位")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}")
    public ResponseEntity<OrmPostDTO> getByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id) {
        OrmPost domain = ormpostService.get(ormpost_id);
        OrmPostDTO dto = ormpostMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-SetGwJb-all')")
    @ApiOperation(value = "根据组织管理岗位", tags = {"岗位" },  notes = "根据组织管理岗位")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}/setgwjb")
    @Transactional
    public ResponseEntity<OrmPostDTO> setGwJbByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody OrmPostDTO ormpostdto) {
        OrmPost domain = ormpostMapping.toDomain(ormpostdto);
        domain.setOrmorgid(ormorg_id);
        domain = ormpostService.setGwJb(domain) ;
        ormpostdto = ormpostMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(ormpostdto);
    }

    @PreAuthorize("hasPermission(this.ormpostService.get(#ormpost_id),'ehr-OrmPost-Update')")
    @ApiOperation(value = "根据组织管理更新岗位", tags = {"岗位" },  notes = "根据组织管理更新岗位")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}")
    @Transactional
    public ResponseEntity<OrmPostDTO> updateByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id, @RequestBody OrmPostDTO ormpostdto) {
        OrmPost domain = ormpostMapping.toDomain(ormpostdto);
        domain.setOrmorgid(ormorg_id);
        domain.setOrmpostid(ormpost_id);
		ormpostService.update(domain);
        OrmPostDTO dto = ormpostMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormpostService.getOrmpostByEntities(this.ormpostMapping.toDomain(#ormpostdtos)),'ehr-OrmPost-Update')")
    @ApiOperation(value = "根据组织管理批量更新岗位", tags = {"岗位" },  notes = "根据组织管理批量更新岗位")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormposts/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody List<OrmPostDTO> ormpostdtos) {
        List<OrmPost> domainlist=ormpostMapping.toDomain(ormpostdtos);
        for(OrmPost domain:domainlist){
            domain.setOrmorgid(ormorg_id);
        }
        ormpostService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormpostService.get(#ormpost_id),'ehr-OrmPost-Remove')")
    @ApiOperation(value = "根据组织管理删除岗位", tags = {"岗位" },  notes = "根据组织管理删除岗位")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormposts/{ormpost_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormpost_id") String ormpost_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormpostService.remove(ormpost_id));
    }

    @PreAuthorize("hasPermission(this.ormpostService.getOrmpostByIds(#ids),'ehr-OrmPost-Remove')")
    @ApiOperation(value = "根据组织管理批量删除岗位", tags = {"岗位" },  notes = "根据组织管理批量删除岗位")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormposts/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrg(@RequestBody List<String> ids) {
        ormpostService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据组织管理获取岗位草稿", tags = {"岗位" },  notes = "根据组织管理获取岗位草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormposts/getdraft")
    public ResponseEntity<OrmPostDTO> getDraftByOrmOrg(@PathVariable("ormorg_id") String ormorg_id) {
        OrmPost domain = new OrmPost();
        domain.setOrmorgid(ormorg_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormpostMapping.toDto(ormpostService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-EJZZGW-all')")
	@ApiOperation(value = "根据组织管理获取根据选择的组织所属的二级组织来获取岗位(ormorgid)", tags = {"岗位" } ,notes = "根据组织管理获取根据选择的组织所属的二级组织来获取岗位(ormorgid)")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormposts/fetchejzzgw")
	public ResponseEntity<List<OrmPostDTO>> fetchOrmPostEJZZGWByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,OrmPostSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<OrmPost> domains = ormpostService.searchEJZZGW(context) ;
        List<OrmPostDTO> list = ormpostMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-EJZZGW-all')")
	@ApiOperation(value = "根据组织管理查询根据选择的组织所属的二级组织来获取岗位(ormorgid)", tags = {"岗位" } ,notes = "根据组织管理查询根据选择的组织所属的二级组织来获取岗位(ormorgid)")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormposts/searchejzzgw")
	public ResponseEntity<Page<OrmPostDTO>> searchOrmPostEJZZGWByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmPostSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<OrmPost> domains = ormpostService.searchEJZZGW(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-AuthPost-all')")
	@ApiOperation(value = "根据组织管理获取AuthPost", tags = {"岗位" } ,notes = "根据组织管理获取AuthPost")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormposts/fetchauthpost")
	public ResponseEntity<List<OrmPostDTO>> fetchOrmPostAuthPostByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,OrmPostSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<OrmPost> domains = ormpostService.searchAuthPost(context) ;
        List<OrmPostDTO> list = ormpostMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-AuthPost-all')")
	@ApiOperation(value = "根据组织管理查询AuthPost", tags = {"岗位" } ,notes = "根据组织管理查询AuthPost")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormposts/searchauthpost")
	public ResponseEntity<Page<OrmPostDTO>> searchOrmPostAuthPostByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmPostSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<OrmPost> domains = ormpostService.searchAuthPost(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-CurOrg-all')")
	@ApiOperation(value = "根据组织管理获取根据当前操作人的身份选择岗位", tags = {"岗位" } ,notes = "根据组织管理获取根据当前操作人的身份选择岗位")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormposts/fetchcurorg")
	public ResponseEntity<List<OrmPostDTO>> fetchOrmPostCurOrgByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,OrmPostSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<OrmPost> domains = ormpostService.searchCurOrg(context) ;
        List<OrmPostDTO> list = ormpostMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-CurOrg-all')")
	@ApiOperation(value = "根据组织管理查询根据当前操作人的身份选择岗位", tags = {"岗位" } ,notes = "根据组织管理查询根据当前操作人的身份选择岗位")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormposts/searchcurorg")
	public ResponseEntity<Page<OrmPostDTO>> searchOrmPostCurOrgByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmPostSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<OrmPost> domains = ormpostService.searchCurOrg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-DQGW-all')")
	@ApiOperation(value = "根据组织管理获取根据当前组织过滤岗位", tags = {"岗位" } ,notes = "根据组织管理获取根据当前组织过滤岗位")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormposts/fetchdqgw")
	public ResponseEntity<List<OrmPostDTO>> fetchOrmPostDQGWByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,OrmPostSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<OrmPost> domains = ormpostService.searchDQGW(context) ;
        List<OrmPostDTO> list = ormpostMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-DQGW-all')")
	@ApiOperation(value = "根据组织管理查询根据当前组织过滤岗位", tags = {"岗位" } ,notes = "根据组织管理查询根据当前组织过滤岗位")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormposts/searchdqgw")
	public ResponseEntity<Page<OrmPostDTO>> searchOrmPostDQGWByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmPostSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<OrmPost> domains = ormpostService.searchDQGW(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-DQORGGW-all')")
	@ApiOperation(value = "根据组织管理获取根据当前组织过滤岗位(orgid)", tags = {"岗位" } ,notes = "根据组织管理获取根据当前组织过滤岗位(orgid)")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormposts/fetchdqorggw")
	public ResponseEntity<List<OrmPostDTO>> fetchOrmPostDQORGGWByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,OrmPostSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<OrmPost> domains = ormpostService.searchDQORGGW(context) ;
        List<OrmPostDTO> list = ormpostMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-DQORGGW-all')")
	@ApiOperation(value = "根据组织管理查询根据当前组织过滤岗位(orgid)", tags = {"岗位" } ,notes = "根据组织管理查询根据当前组织过滤岗位(orgid)")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormposts/searchdqorggw")
	public ResponseEntity<Page<OrmPostDTO>> searchOrmPostDQORGGWByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmPostSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<OrmPost> domains = ormpostService.searchDQORGGW(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-GWXH-all')")
	@ApiOperation(value = "根据组织管理获取岗位查询", tags = {"岗位" } ,notes = "根据组织管理获取岗位查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormposts/fetchgwxh")
	public ResponseEntity<List<OrmPostDTO>> fetchOrmPostGWXHByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,OrmPostSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<OrmPost> domains = ormpostService.searchGWXH(context) ;
        List<OrmPostDTO> list = ormpostMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-GWXH-all')")
	@ApiOperation(value = "根据组织管理查询岗位查询", tags = {"岗位" } ,notes = "根据组织管理查询岗位查询")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormposts/searchgwxh")
	public ResponseEntity<Page<OrmPostDTO>> searchOrmPostGWXHByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmPostSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<OrmPost> domains = ormpostService.searchGWXH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-Default-all')")
	@ApiOperation(value = "根据组织管理获取DEFAULT", tags = {"岗位" } ,notes = "根据组织管理获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormposts/fetchdefault")
	public ResponseEntity<List<OrmPostDTO>> fetchOrmPostDefaultByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,OrmPostSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<OrmPost> domains = ormpostService.searchDefault(context) ;
        List<OrmPostDTO> list = ormpostMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-Default-all')")
	@ApiOperation(value = "根据组织管理查询DEFAULT", tags = {"岗位" } ,notes = "根据组织管理查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormposts/searchdefault")
	public ResponseEntity<Page<OrmPostDTO>> searchOrmPostDefaultByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmPostSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<OrmPost> domains = ormpostService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-JZBGWCX-all')")
	@ApiOperation(value = "根据组织管理获取局总部岗位查询", tags = {"岗位" } ,notes = "根据组织管理获取局总部岗位查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormposts/fetchjzbgwcx")
	public ResponseEntity<List<OrmPostDTO>> fetchOrmPostJZBGWCXByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,OrmPostSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<OrmPost> domains = ormpostService.searchJZBGWCX(context) ;
        List<OrmPostDTO> list = ormpostMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-JZBGWCX-all')")
	@ApiOperation(value = "根据组织管理查询局总部岗位查询", tags = {"岗位" } ,notes = "根据组织管理查询局总部岗位查询")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormposts/searchjzbgwcx")
	public ResponseEntity<Page<OrmPostDTO>> searchOrmPostJZBGWCXByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmPostSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<OrmPost> domains = ormpostService.searchJZBGWCX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-CXGW-all')")
	@ApiOperation(value = "根据组织管理获取查询当前组织所属的二级单位岗位", tags = {"岗位" } ,notes = "根据组织管理获取查询当前组织所属的二级单位岗位")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormposts/fetchcxgw")
	public ResponseEntity<List<OrmPostDTO>> fetchOrmPostCXGWByOrmOrg(@PathVariable("ormorg_id") String ormorg_id,OrmPostSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<OrmPost> domains = ormpostService.searchCXGW(context) ;
        List<OrmPostDTO> list = ormpostMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmPost-CXGW-all')")
	@ApiOperation(value = "根据组织管理查询查询当前组织所属的二级单位岗位", tags = {"岗位" } ,notes = "根据组织管理查询查询当前组织所属的二级单位岗位")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormposts/searchcxgw")
	public ResponseEntity<Page<OrmPostDTO>> searchOrmPostCXGWByOrmOrg(@PathVariable("ormorg_id") String ormorg_id, @RequestBody OrmPostSearchContext context) {
        context.setN_ormorgid_eq(ormorg_id);
        Page<OrmPost> domains = ormpostService.searchCXGW(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

