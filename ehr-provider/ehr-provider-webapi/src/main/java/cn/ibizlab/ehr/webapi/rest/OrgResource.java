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
import cn.ibizlab.ehr.core.common.domain.Org;
import cn.ibizlab.ehr.core.common.service.IOrgService;
import cn.ibizlab.ehr.core.common.filter.OrgSearchContext;




@Slf4j
@Api(tags = {"Org" })
@RestController("WebApi-org")
@RequestMapping("")
public class OrgResource {

    @Autowired
    private IOrgService orgService;

    @Autowired
    @Lazy
    private OrgMapping orgMapping;




    @ApiOperation(value = "初始化", tags = {"Org" },  notes = "初始化")
	@RequestMapping(method = RequestMethod.POST, value = "/orgs/{org_id}/initall")
    @Transactional
    public ResponseEntity<OrgDTO> initAll(@PathVariable("org_id") String org_id, @RequestBody OrgDTO orgdto) {
        Org org = orgMapping.toDomain(orgdto);
        org = orgService.initAll(org);
        orgdto = orgMapping.toDto(org);
        return ResponseEntity.status(HttpStatus.OK).body(orgdto);
    }




    @ApiOperation(value = "CheckKey", tags = {"Org" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/orgs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrgDTO orgdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(orgService.checkKey(orgMapping.toDomain(orgdto)));
    }




    @PreAuthorize("hasPermission('Remove',{#org_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"Org" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/orgs/{org_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("org_id") String org_id) {
         return ResponseEntity.status(HttpStatus.OK).body(orgService.remove(org_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"Org" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/orgs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        orgService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"Org" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/orgs")
    @Transactional
    public ResponseEntity<OrgDTO> create(@RequestBody OrgDTO orgdto) {
        Org domain = orgMapping.toDomain(orgdto);
		orgService.create(domain);
        OrgDTO dto = orgMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"Org" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/orgs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrgDTO> orgdtos) {
        orgService.createBatch(orgMapping.toDomain(orgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#org_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"Org" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/orgs/{org_id}")
    public ResponseEntity<OrgDTO> get(@PathVariable("org_id") String org_id) {
        Org domain = orgService.get(org_id);
        OrgDTO dto = orgMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "GetDraft", tags = {"Org" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/orgs/getdraft")
    public ResponseEntity<OrgDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(orgMapping.toDto(orgService.getDraft(new Org())));
    }




    @ApiOperation(value = "初始化用户对象", tags = {"Org" },  notes = "初始化用户对象")
	@RequestMapping(method = RequestMethod.POST, value = "/orgs/{org_id}/inituserobject")
    @Transactional
    public ResponseEntity<OrgDTO> initUserObject(@PathVariable("org_id") String org_id, @RequestBody OrgDTO orgdto) {
        Org org = orgMapping.toDomain(orgdto);
        org = orgService.initUserObject(org);
        orgdto = orgMapping.toDto(org);
        return ResponseEntity.status(HttpStatus.OK).body(orgdto);
    }




    @ApiOperation(value = "Save", tags = {"Org" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/orgs/save")
    public ResponseEntity<Boolean> save(@RequestBody OrgDTO orgdto) {
        return ResponseEntity.status(HttpStatus.OK).body(orgService.save(orgMapping.toDomain(orgdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"Org" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/orgs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrgDTO> orgdtos) {
        orgService.saveBatch(orgMapping.toDomain(orgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#org_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"Org" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/orgs/{org_id}")
    @Transactional
    public ResponseEntity<OrgDTO> update(@PathVariable("org_id") String org_id, @RequestBody OrgDTO orgdto) {
		Org domain = orgMapping.toDomain(orgdto);
        domain.setOrgid(org_id);
		orgService.update(domain);
		OrgDTO dto = orgMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#org_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"Org" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/orgs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrgDTO> orgdtos) {
        orgService.updateBatch(orgMapping.toDomain(orgdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"Org" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/orgs/fetchdefault")
	public ResponseEntity<List<OrgDTO>> fetchDefault(OrgSearchContext context) {
        Page<Org> domains = orgService.searchDefault(context) ;
        List<OrgDTO> list = orgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"Org" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/orgs/searchdefault")
	public ResponseEntity<Page<OrgDTO>> searchDefault(OrgSearchContext context) {
        Page<Org> domains = orgService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(orgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'CurCat',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch当前组织分类", tags = {"Org" } ,notes = "fetch当前组织分类")
    @RequestMapping(method= RequestMethod.GET , value="/orgs/fetchcurcat")
	public ResponseEntity<List<OrgDTO>> fetchCurCat(OrgSearchContext context) {
        Page<Org> domains = orgService.searchCurCat(context) ;
        List<OrgDTO> list = orgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'CurCat',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search当前组织分类", tags = {"Org" } ,notes = "search当前组织分类")
    @RequestMapping(method= RequestMethod.GET , value="/orgs/searchcurcat")
	public ResponseEntity<Page<OrgDTO>> searchCurCat(OrgSearchContext context) {
        Page<Org> domains = orgService.searchCurCat(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(orgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'AllRoot',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch全部根组织", tags = {"Org" } ,notes = "fetch全部根组织")
    @RequestMapping(method= RequestMethod.GET , value="/orgs/fetchallroot")
	public ResponseEntity<List<OrgDTO>> fetchAllRoot(OrgSearchContext context) {
        Page<Org> domains = orgService.searchAllRoot(context) ;
        List<OrgDTO> list = orgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'AllRoot',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search全部根组织", tags = {"Org" } ,notes = "search全部根组织")
    @RequestMapping(method= RequestMethod.GET , value="/orgs/searchallroot")
	public ResponseEntity<Page<OrgDTO>> searchAllRoot(OrgSearchContext context) {
        Page<Org> domains = orgService.searchAllRoot(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(orgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'CurChild',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch当前子组织", tags = {"Org" } ,notes = "fetch当前子组织")
    @RequestMapping(method= RequestMethod.GET , value="/orgs/fetchcurchild")
	public ResponseEntity<List<OrgDTO>> fetchCurChild(OrgSearchContext context) {
        Page<Org> domains = orgService.searchCurChild(context) ;
        List<OrgDTO> list = orgMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'CurChild',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search当前子组织", tags = {"Org" } ,notes = "search当前子组织")
    @RequestMapping(method= RequestMethod.GET , value="/orgs/searchcurchild")
	public ResponseEntity<Page<OrgDTO>> searchCurChild(OrgSearchContext context) {
        Page<Org> domains = orgService.searchCurChild(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(orgMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public Org getEntity(){
        return new Org();
    }

}
