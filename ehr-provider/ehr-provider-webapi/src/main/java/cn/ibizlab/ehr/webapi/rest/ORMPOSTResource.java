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
import cn.ibizlab.ehr.core.orm.domain.ORMPOST;
import cn.ibizlab.ehr.core.orm.service.IORMPOSTService;
import cn.ibizlab.ehr.core.orm.filter.ORMPOSTSearchContext;




@Slf4j
@Api(tags = {"ORMPOST" })
@RestController("WebApi-ormpost")
@RequestMapping("")
public class ORMPOSTResource {

    @Autowired
    private IORMPOSTService ormpostService;

    @Autowired
    @Lazy
    private ORMPOSTMapping ormpostMapping;




    @ApiOperation(value = "Save", tags = {"ORMPOST" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/save")
    public ResponseEntity<Boolean> save(@RequestBody ORMPOSTDTO ormpostdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormpostService.save(ormpostMapping.toDomain(ormpostdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"ORMPOST" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ORMPOSTDTO> ormpostdtos) {
        ormpostService.saveBatch(ormpostMapping.toDomain(ormpostdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"ORMPOST" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ORMPOSTDTO ormpostdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormpostService.checkKey(ormpostMapping.toDomain(ormpostdto)));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"ORMPOST" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts")
    @Transactional
    public ResponseEntity<ORMPOSTDTO> create(@RequestBody ORMPOSTDTO ormpostdto) {
        ORMPOST domain = ormpostMapping.toDomain(ormpostdto);
		ormpostService.create(domain);
        ORMPOSTDTO dto = ormpostMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"ORMPOST" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ORMPOSTDTO> ormpostdtos) {
        ormpostService.createBatch(ormpostMapping.toDomain(ormpostdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#ormpost_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"ORMPOST" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormposts/{ormpost_id}")
    public ResponseEntity<ORMPOSTDTO> get(@PathVariable("ormpost_id") String ormpost_id) {
        ORMPOST domain = ormpostService.get(ormpost_id);
        ORMPOSTDTO dto = ormpostMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "计算岗位分类级别", tags = {"ORMPOST" },  notes = "计算岗位分类级别")
	@RequestMapping(method = RequestMethod.POST, value = "/ormposts/{ormpost_id}/setgwjb")
    @Transactional
    public ResponseEntity<ORMPOSTDTO> setGwJb(@PathVariable("ormpost_id") String ormpost_id, @RequestBody ORMPOSTDTO ormpostdto) {
        ORMPOST ormpost = ormpostMapping.toDomain(ormpostdto);
        ormpost = ormpostService.setGwJb(ormpost);
        ormpostdto = ormpostMapping.toDto(ormpost);
        return ResponseEntity.status(HttpStatus.OK).body(ormpostdto);
    }




    @PreAuthorize("hasPermission(#ormpost_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"ORMPOST" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormposts/{ormpost_id}")
    @Transactional
    public ResponseEntity<ORMPOSTDTO> update(@PathVariable("ormpost_id") String ormpost_id, @RequestBody ORMPOSTDTO ormpostdto) {
		ORMPOST domain = ormpostMapping.toDomain(ormpostdto);
        domain.setOrmpostid(ormpost_id);
		ormpostService.update(domain);
		ORMPOSTDTO dto = ormpostMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#ormpost_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"ORMPOST" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormposts/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ORMPOSTDTO> ormpostdtos) {
        ormpostService.updateBatch(ormpostMapping.toDomain(ormpostdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#ormpost_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"ORMPOST" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormposts/{ormpost_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormpost_id") String ormpost_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormpostService.remove(ormpost_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"ORMPOST" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormposts/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormpostService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"ORMPOST" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormposts/getdraft")
    public ResponseEntity<ORMPOSTDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormpostMapping.toDto(ormpostService.getDraft(new ORMPOST())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPOST-EJZZGW-all')")
	@ApiOperation(value = "fetch根据选择的组织所属的二级组织来获取岗位(ormorgid)", tags = {"ORMPOST" } ,notes = "fetch根据选择的组织所属的二级组织来获取岗位(ormorgid)")
    @RequestMapping(method= RequestMethod.GET , value="/ormposts/fetchejzzgw")
	public ResponseEntity<List<ORMPOSTDTO>> fetchEJZZGW(ORMPOSTSearchContext context) {
        Page<ORMPOST> domains = ormpostService.searchEJZZGW(context) ;
        List<ORMPOSTDTO> list = ormpostMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPOST-EJZZGW-all')")
	@ApiOperation(value = "search根据选择的组织所属的二级组织来获取岗位(ormorgid)", tags = {"ORMPOST" } ,notes = "search根据选择的组织所属的二级组织来获取岗位(ormorgid)")
    @RequestMapping(method= RequestMethod.POST , value="/ormposts/searchejzzgw")
	public ResponseEntity<Page<ORMPOSTDTO>> searchEJZZGW(@RequestBody ORMPOSTSearchContext context) {
        Page<ORMPOST> domains = ormpostService.searchEJZZGW(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPOST-AuthPost-all')")
	@ApiOperation(value = "fetchAuthPost", tags = {"ORMPOST" } ,notes = "fetchAuthPost")
    @RequestMapping(method= RequestMethod.GET , value="/ormposts/fetchauthpost")
	public ResponseEntity<List<ORMPOSTDTO>> fetchAuthPost(ORMPOSTSearchContext context) {
        Page<ORMPOST> domains = ormpostService.searchAuthPost(context) ;
        List<ORMPOSTDTO> list = ormpostMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPOST-AuthPost-all')")
	@ApiOperation(value = "searchAuthPost", tags = {"ORMPOST" } ,notes = "searchAuthPost")
    @RequestMapping(method= RequestMethod.POST , value="/ormposts/searchauthpost")
	public ResponseEntity<Page<ORMPOSTDTO>> searchAuthPost(@RequestBody ORMPOSTSearchContext context) {
        Page<ORMPOST> domains = ormpostService.searchAuthPost(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPOST-CurOrg-all')")
	@ApiOperation(value = "fetch根据当前操作人的身份选择岗位", tags = {"ORMPOST" } ,notes = "fetch根据当前操作人的身份选择岗位")
    @RequestMapping(method= RequestMethod.GET , value="/ormposts/fetchcurorg")
	public ResponseEntity<List<ORMPOSTDTO>> fetchCurOrg(ORMPOSTSearchContext context) {
        Page<ORMPOST> domains = ormpostService.searchCurOrg(context) ;
        List<ORMPOSTDTO> list = ormpostMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPOST-CurOrg-all')")
	@ApiOperation(value = "search根据当前操作人的身份选择岗位", tags = {"ORMPOST" } ,notes = "search根据当前操作人的身份选择岗位")
    @RequestMapping(method= RequestMethod.POST , value="/ormposts/searchcurorg")
	public ResponseEntity<Page<ORMPOSTDTO>> searchCurOrg(@RequestBody ORMPOSTSearchContext context) {
        Page<ORMPOST> domains = ormpostService.searchCurOrg(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPOST-DQGW-all')")
	@ApiOperation(value = "fetch根据当前组织过滤岗位", tags = {"ORMPOST" } ,notes = "fetch根据当前组织过滤岗位")
    @RequestMapping(method= RequestMethod.GET , value="/ormposts/fetchdqgw")
	public ResponseEntity<List<ORMPOSTDTO>> fetchDQGW(ORMPOSTSearchContext context) {
        Page<ORMPOST> domains = ormpostService.searchDQGW(context) ;
        List<ORMPOSTDTO> list = ormpostMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPOST-DQGW-all')")
	@ApiOperation(value = "search根据当前组织过滤岗位", tags = {"ORMPOST" } ,notes = "search根据当前组织过滤岗位")
    @RequestMapping(method= RequestMethod.POST , value="/ormposts/searchdqgw")
	public ResponseEntity<Page<ORMPOSTDTO>> searchDQGW(@RequestBody ORMPOSTSearchContext context) {
        Page<ORMPOST> domains = ormpostService.searchDQGW(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPOST-DQORGGW-all')")
	@ApiOperation(value = "fetch根据当前组织过滤岗位(orgid)", tags = {"ORMPOST" } ,notes = "fetch根据当前组织过滤岗位(orgid)")
    @RequestMapping(method= RequestMethod.GET , value="/ormposts/fetchdqorggw")
	public ResponseEntity<List<ORMPOSTDTO>> fetchDQORGGW(ORMPOSTSearchContext context) {
        Page<ORMPOST> domains = ormpostService.searchDQORGGW(context) ;
        List<ORMPOSTDTO> list = ormpostMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPOST-DQORGGW-all')")
	@ApiOperation(value = "search根据当前组织过滤岗位(orgid)", tags = {"ORMPOST" } ,notes = "search根据当前组织过滤岗位(orgid)")
    @RequestMapping(method= RequestMethod.POST , value="/ormposts/searchdqorggw")
	public ResponseEntity<Page<ORMPOSTDTO>> searchDQORGGW(@RequestBody ORMPOSTSearchContext context) {
        Page<ORMPOST> domains = ormpostService.searchDQORGGW(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPOST-GWXH-all')")
	@ApiOperation(value = "fetch岗位查询", tags = {"ORMPOST" } ,notes = "fetch岗位查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormposts/fetchgwxh")
	public ResponseEntity<List<ORMPOSTDTO>> fetchGWXH(ORMPOSTSearchContext context) {
        Page<ORMPOST> domains = ormpostService.searchGWXH(context) ;
        List<ORMPOSTDTO> list = ormpostMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPOST-GWXH-all')")
	@ApiOperation(value = "search岗位查询", tags = {"ORMPOST" } ,notes = "search岗位查询")
    @RequestMapping(method= RequestMethod.POST , value="/ormposts/searchgwxh")
	public ResponseEntity<Page<ORMPOSTDTO>> searchGWXH(@RequestBody ORMPOSTSearchContext context) {
        Page<ORMPOST> domains = ormpostService.searchGWXH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPOST-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ORMPOST" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormposts/fetchdefault")
	public ResponseEntity<List<ORMPOSTDTO>> fetchDefault(ORMPOSTSearchContext context) {
        Page<ORMPOST> domains = ormpostService.searchDefault(context) ;
        List<ORMPOSTDTO> list = ormpostMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPOST-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ORMPOST" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormposts/searchdefault")
	public ResponseEntity<Page<ORMPOSTDTO>> searchDefault(@RequestBody ORMPOSTSearchContext context) {
        Page<ORMPOST> domains = ormpostService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPOST-JZBGWCX-all')")
	@ApiOperation(value = "fetch局总部岗位查询", tags = {"ORMPOST" } ,notes = "fetch局总部岗位查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormposts/fetchjzbgwcx")
	public ResponseEntity<List<ORMPOSTDTO>> fetchJZBGWCX(ORMPOSTSearchContext context) {
        Page<ORMPOST> domains = ormpostService.searchJZBGWCX(context) ;
        List<ORMPOSTDTO> list = ormpostMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPOST-JZBGWCX-all')")
	@ApiOperation(value = "search局总部岗位查询", tags = {"ORMPOST" } ,notes = "search局总部岗位查询")
    @RequestMapping(method= RequestMethod.POST , value="/ormposts/searchjzbgwcx")
	public ResponseEntity<Page<ORMPOSTDTO>> searchJZBGWCX(@RequestBody ORMPOSTSearchContext context) {
        Page<ORMPOST> domains = ormpostService.searchJZBGWCX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPOST-CXGW-all')")
	@ApiOperation(value = "fetch查询当前组织所属的二级单位岗位", tags = {"ORMPOST" } ,notes = "fetch查询当前组织所属的二级单位岗位")
    @RequestMapping(method= RequestMethod.GET , value="/ormposts/fetchcxgw")
	public ResponseEntity<List<ORMPOSTDTO>> fetchCXGW(ORMPOSTSearchContext context) {
        Page<ORMPOST> domains = ormpostService.searchCXGW(context) ;
        List<ORMPOSTDTO> list = ormpostMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMPOST-CXGW-all')")
	@ApiOperation(value = "search查询当前组织所属的二级单位岗位", tags = {"ORMPOST" } ,notes = "search查询当前组织所属的二级单位岗位")
    @RequestMapping(method= RequestMethod.POST , value="/ormposts/searchcxgw")
	public ResponseEntity<Page<ORMPOSTDTO>> searchCXGW(@RequestBody ORMPOSTSearchContext context) {
        Page<ORMPOST> domains = ormpostService.searchCXGW(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormpostMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public ORMPOST getEntity(){
        return new ORMPOST();
    }

}
