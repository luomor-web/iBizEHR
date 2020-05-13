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
import cn.ibizlab.ehr.core.common.domain.UserRoleDetail;
import cn.ibizlab.ehr.core.common.service.IUserRoleDetailService;
import cn.ibizlab.ehr.core.common.filter.UserRoleDetailSearchContext;




@Slf4j
@Api(tags = {"UserRoleDetail" })
@RestController("WebApi-userroledetail")
@RequestMapping("")
public class UserRoleDetailResource {

    @Autowired
    private IUserRoleDetailService userroledetailService;

    @Autowired
    @Lazy
    private UserRoleDetailMapping userroledetailMapping;




    @PreAuthorize("hasPermission(#userroledetail_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"UserRoleDetail" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/userroledetails/{userroledetail_id}")
    @Transactional
    public ResponseEntity<UserRoleDetailDTO> update(@PathVariable("userroledetail_id") String userroledetail_id, @RequestBody UserRoleDetailDTO userroledetaildto) {
		UserRoleDetail domain = userroledetailMapping.toDomain(userroledetaildto);
        domain.setUserroledetailid(userroledetail_id);
		userroledetailService.update(domain);
		UserRoleDetailDTO dto = userroledetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#userroledetail_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"UserRoleDetail" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/userroledetails/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<UserRoleDetailDTO> userroledetaildtos) {
        userroledetailService.updateBatch(userroledetailMapping.toDomain(userroledetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"UserRoleDetail" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/userroledetails/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody UserRoleDetailDTO userroledetaildto) {
        return  ResponseEntity.status(HttpStatus.OK).body(userroledetailService.checkKey(userroledetailMapping.toDomain(userroledetaildto)));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"UserRoleDetail" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/userroledetails")
    @Transactional
    public ResponseEntity<UserRoleDetailDTO> create(@RequestBody UserRoleDetailDTO userroledetaildto) {
        UserRoleDetail domain = userroledetailMapping.toDomain(userroledetaildto);
		userroledetailService.create(domain);
        UserRoleDetailDTO dto = userroledetailMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"UserRoleDetail" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/userroledetails/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<UserRoleDetailDTO> userroledetaildtos) {
        userroledetailService.createBatch(userroledetailMapping.toDomain(userroledetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"UserRoleDetail" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/userroledetails/save")
    public ResponseEntity<Boolean> save(@RequestBody UserRoleDetailDTO userroledetaildto) {
        return ResponseEntity.status(HttpStatus.OK).body(userroledetailService.save(userroledetailMapping.toDomain(userroledetaildto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"UserRoleDetail" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/userroledetails/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<UserRoleDetailDTO> userroledetaildtos) {
        userroledetailService.saveBatch(userroledetailMapping.toDomain(userroledetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"UserRoleDetail" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/userroledetails/getdraft")
    public ResponseEntity<UserRoleDetailDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(userroledetailMapping.toDto(userroledetailService.getDraft(new UserRoleDetail())));
    }




    @PreAuthorize("hasPermission('Remove',{#userroledetail_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"UserRoleDetail" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/userroledetails/{userroledetail_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("userroledetail_id") String userroledetail_id) {
         return ResponseEntity.status(HttpStatus.OK).body(userroledetailService.remove(userroledetail_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"UserRoleDetail" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/userroledetails/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        userroledetailService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#userroledetail_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"UserRoleDetail" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/userroledetails/{userroledetail_id}")
    public ResponseEntity<UserRoleDetailDTO> get(@PathVariable("userroledetail_id") String userroledetail_id) {
        UserRoleDetail domain = userroledetailService.get(userroledetail_id);
        UserRoleDetailDTO dto = userroledetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Get',{#context,'CurrentCompany',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch当前公司角色成员", tags = {"UserRoleDetail" } ,notes = "fetch当前公司角色成员")
    @RequestMapping(method= RequestMethod.GET , value="/userroledetails/fetchcurrentcompany")
	public ResponseEntity<List<UserRoleDetailDTO>> fetchCurrentCompany(UserRoleDetailSearchContext context) {
        Page<UserRoleDetail> domains = userroledetailService.searchCurrentCompany(context) ;
        List<UserRoleDetailDTO> list = userroledetailMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'CurrentCompany',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search当前公司角色成员", tags = {"UserRoleDetail" } ,notes = "search当前公司角色成员")
    @RequestMapping(method= RequestMethod.GET , value="/userroledetails/searchcurrentcompany")
	public ResponseEntity<Page<UserRoleDetailDTO>> searchCurrentCompany(UserRoleDetailSearchContext context) {
        Page<UserRoleDetail> domains = userroledetailService.searchCurrentCompany(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(userroledetailMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'OrderByUserCX',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch根据用户查询角色", tags = {"UserRoleDetail" } ,notes = "fetch根据用户查询角色")
    @RequestMapping(method= RequestMethod.GET , value="/userroledetails/fetchorderbyusercx")
	public ResponseEntity<List<UserRoleDetailDTO>> fetchOrderByUserCX(UserRoleDetailSearchContext context) {
        Page<UserRoleDetail> domains = userroledetailService.searchOrderByUserCX(context) ;
        List<UserRoleDetailDTO> list = userroledetailMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'OrderByUserCX',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search根据用户查询角色", tags = {"UserRoleDetail" } ,notes = "search根据用户查询角色")
    @RequestMapping(method= RequestMethod.GET , value="/userroledetails/searchorderbyusercx")
	public ResponseEntity<Page<UserRoleDetailDTO>> searchOrderByUserCX(UserRoleDetailSearchContext context) {
        Page<UserRoleDetail> domains = userroledetailService.searchOrderByUserCX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(userroledetailMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"UserRoleDetail" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/userroledetails/fetchdefault")
	public ResponseEntity<List<UserRoleDetailDTO>> fetchDefault(UserRoleDetailSearchContext context) {
        Page<UserRoleDetail> domains = userroledetailService.searchDefault(context) ;
        List<UserRoleDetailDTO> list = userroledetailMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"UserRoleDetail" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/userroledetails/searchdefault")
	public ResponseEntity<Page<UserRoleDetailDTO>> searchDefault(UserRoleDetailSearchContext context) {
        Page<UserRoleDetail> domains = userroledetailService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(userroledetailMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'SysManager',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch系统管理员", tags = {"UserRoleDetail" } ,notes = "fetch系统管理员")
    @RequestMapping(method= RequestMethod.GET , value="/userroledetails/fetchsysmanager")
	public ResponseEntity<List<UserRoleDetailDTO>> fetchSysManager(UserRoleDetailSearchContext context) {
        Page<UserRoleDetail> domains = userroledetailService.searchSysManager(context) ;
        List<UserRoleDetailDTO> list = userroledetailMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'SysManager',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search系统管理员", tags = {"UserRoleDetail" } ,notes = "search系统管理员")
    @RequestMapping(method= RequestMethod.GET , value="/userroledetails/searchsysmanager")
	public ResponseEntity<Page<UserRoleDetailDTO>> searchSysManager(UserRoleDetailSearchContext context) {
        Page<UserRoleDetail> domains = userroledetailService.searchSysManager(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(userroledetailMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public UserRoleDetail getEntity(){
        return new UserRoleDetail();
    }

}
