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
import cn.ibizlab.ehr.core.orm.domain.OrmUser;
import cn.ibizlab.ehr.core.orm.service.IOrmUserService;
import cn.ibizlab.ehr.core.orm.filter.OrmUserSearchContext;

@Slf4j
@Api(tags = {"用户管理" })
@RestController("WebApi-ormuser")
@RequestMapping("")
public class OrmUserResource {

    @Autowired
    public IOrmUserService ormuserService;

    @Autowired
    @Lazy
    public OrmUserMapping ormuserMapping;

    @PostAuthorize("hasPermission(this.ormuserMapping.toDomain(returnObject.body),'ehr-OrmUser-Get')")
    @ApiOperation(value = "获取用户管理", tags = {"用户管理" },  notes = "获取用户管理")
	@RequestMapping(method = RequestMethod.GET, value = "/ormusers/{ormuser_id}")
    public ResponseEntity<OrmUserDTO> get(@PathVariable("ormuser_id") String ormuser_id) {
        OrmUser domain = ormuserService.get(ormuser_id);
        OrmUserDTO dto = ormuserMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormuserMapping.toDomain(#ormuserdto),'ehr-OrmUser-Create')")
    @ApiOperation(value = "新建用户管理", tags = {"用户管理" },  notes = "新建用户管理")
	@RequestMapping(method = RequestMethod.POST, value = "/ormusers")
    @Transactional
    public ResponseEntity<OrmUserDTO> create(@RequestBody OrmUserDTO ormuserdto) {
        OrmUser domain = ormuserMapping.toDomain(ormuserdto);
		ormuserService.create(domain);
        OrmUserDTO dto = ormuserMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormuserMapping.toDomain(#ormuserdtos),'ehr-OrmUser-Create')")
    @ApiOperation(value = "批量新建用户管理", tags = {"用户管理" },  notes = "批量新建用户管理")
	@RequestMapping(method = RequestMethod.POST, value = "/ormusers/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrmUserDTO> ormuserdtos) {
        ormuserService.createBatch(ormuserMapping.toDomain(ormuserdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormuserService.get(#ormuser_id),'ehr-OrmUser-Remove')")
    @ApiOperation(value = "删除用户管理", tags = {"用户管理" },  notes = "删除用户管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormusers/{ormuser_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormuser_id") String ormuser_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormuserService.remove(ormuser_id));
    }

    @PreAuthorize("hasPermission(this.ormuserService.getOrmuserByIds(#ids),'ehr-OrmUser-Remove')")
    @ApiOperation(value = "批量删除用户管理", tags = {"用户管理" },  notes = "批量删除用户管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormusers/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormuserService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormuserService.get(#ormuser_id),'ehr-OrmUser-Update')")
    @ApiOperation(value = "更新用户管理", tags = {"用户管理" },  notes = "更新用户管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormusers/{ormuser_id}")
    @Transactional
    public ResponseEntity<OrmUserDTO> update(@PathVariable("ormuser_id") String ormuser_id, @RequestBody OrmUserDTO ormuserdto) {
		OrmUser domain  = ormuserMapping.toDomain(ormuserdto);
        domain .setOrguserid(ormuser_id);
		ormuserService.update(domain );
		OrmUserDTO dto = ormuserMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormuserService.getOrmuserByEntities(this.ormuserMapping.toDomain(#ormuserdtos)),'ehr-OrmUser-Update')")
    @ApiOperation(value = "批量更新用户管理", tags = {"用户管理" },  notes = "批量更新用户管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormusers/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrmUserDTO> ormuserdtos) {
        ormuserService.updateBatch(ormuserMapping.toDomain(ormuserdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查用户管理", tags = {"用户管理" },  notes = "检查用户管理")
	@RequestMapping(method = RequestMethod.POST, value = "/ormusers/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrmUserDTO ormuserdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormuserService.checkKey(ormuserMapping.toDomain(ormuserdto)));
    }

    @PreAuthorize("hasPermission(this.ormuserMapping.toDomain(#ormuserdto),'ehr-OrmUser-Save')")
    @ApiOperation(value = "保存用户管理", tags = {"用户管理" },  notes = "保存用户管理")
	@RequestMapping(method = RequestMethod.POST, value = "/ormusers/save")
    public ResponseEntity<Boolean> save(@RequestBody OrmUserDTO ormuserdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormuserService.save(ormuserMapping.toDomain(ormuserdto)));
    }

    @PreAuthorize("hasPermission(this.ormuserMapping.toDomain(#ormuserdtos),'ehr-OrmUser-Save')")
    @ApiOperation(value = "批量保存用户管理", tags = {"用户管理" },  notes = "批量保存用户管理")
	@RequestMapping(method = RequestMethod.POST, value = "/ormusers/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrmUserDTO> ormuserdtos) {
        ormuserService.saveBatch(ormuserMapping.toDomain(ormuserdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取用户管理草稿", tags = {"用户管理" },  notes = "获取用户管理草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/ormusers/getdraft")
    public ResponseEntity<OrmUserDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormuserMapping.toDto(ormuserService.getDraft(new OrmUser())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmUser-DQZZJXJZZ-all')")
	@ApiOperation(value = "获取当前组织及下级组织", tags = {"用户管理" } ,notes = "获取当前组织及下级组织")
    @RequestMapping(method= RequestMethod.GET , value="/ormusers/fetchdqzzjxjzz")
	public ResponseEntity<List<OrmUserDTO>> fetchDQZZJXJZZ(OrmUserSearchContext context) {
        Page<OrmUser> domains = ormuserService.searchDQZZJXJZZ(context) ;
        List<OrmUserDTO> list = ormuserMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmUser-DQZZJXJZZ-all')")
	@ApiOperation(value = "查询当前组织及下级组织", tags = {"用户管理" } ,notes = "查询当前组织及下级组织")
    @RequestMapping(method= RequestMethod.POST , value="/ormusers/searchdqzzjxjzz")
	public ResponseEntity<Page<OrmUserDTO>> searchDQZZJXJZZ(@RequestBody OrmUserSearchContext context) {
        Page<OrmUser> domains = ormuserService.searchDQZZJXJZZ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormuserMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmUser-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"用户管理" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormusers/fetchdefault")
	public ResponseEntity<List<OrmUserDTO>> fetchDefault(OrmUserSearchContext context) {
        Page<OrmUser> domains = ormuserService.searchDefault(context) ;
        List<OrmUserDTO> list = ormuserMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmUser-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"用户管理" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormusers/searchdefault")
	public ResponseEntity<Page<OrmUserDTO>> searchDefault(@RequestBody OrmUserSearchContext context) {
        Page<OrmUser> domains = ormuserService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormuserMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

