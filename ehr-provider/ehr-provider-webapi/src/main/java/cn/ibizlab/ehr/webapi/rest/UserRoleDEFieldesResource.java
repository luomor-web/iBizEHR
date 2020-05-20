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
import cn.ibizlab.ehr.core.common.domain.UserRoleDEFieldes;
import cn.ibizlab.ehr.core.common.service.IUserRoleDEFieldesService;
import cn.ibizlab.ehr.core.common.filter.UserRoleDEFieldesSearchContext;




@Slf4j
@Api(tags = {"UserRoleDEFieldes" })
@RestController("WebApi-userroledefieldes")
@RequestMapping("")
public class UserRoleDEFieldesResource {

    @Autowired
    private IUserRoleDEFieldesService userroledefieldesService;

    @Autowired
    @Lazy
    private UserRoleDEFieldesMapping userroledefieldesMapping;




    @PreAuthorize("hasPermission(#userroledefieldes_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"UserRoleDEFieldes" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/userroledefieldes/{userroledefieldes_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("userroledefieldes_id") String userroledefieldes_id) {
         return ResponseEntity.status(HttpStatus.OK).body(userroledefieldesService.remove(userroledefieldes_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"UserRoleDEFieldes" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/userroledefieldes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        userroledefieldesService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#userroledefieldes_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"UserRoleDEFieldes" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/userroledefieldes/{userroledefieldes_id}")
    @Transactional
    public ResponseEntity<UserRoleDEFieldesDTO> update(@PathVariable("userroledefieldes_id") String userroledefieldes_id, @RequestBody UserRoleDEFieldesDTO userroledefieldesdto) {
		UserRoleDEFieldes domain = userroledefieldesMapping.toDomain(userroledefieldesdto);
        domain.setUserroledefieldsid(userroledefieldes_id);
		userroledefieldesService.update(domain);
		UserRoleDEFieldesDTO dto = userroledefieldesMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#userroledefieldes_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"UserRoleDEFieldes" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/userroledefieldes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<UserRoleDEFieldesDTO> userroledefieldesdtos) {
        userroledefieldesService.updateBatch(userroledefieldesMapping.toDomain(userroledefieldesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"UserRoleDEFieldes" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/userroledefieldes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody UserRoleDEFieldesDTO userroledefieldesdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(userroledefieldesService.checkKey(userroledefieldesMapping.toDomain(userroledefieldesdto)));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"UserRoleDEFieldes" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/userroledefieldes")
    @Transactional
    public ResponseEntity<UserRoleDEFieldesDTO> create(@RequestBody UserRoleDEFieldesDTO userroledefieldesdto) {
        UserRoleDEFieldes domain = userroledefieldesMapping.toDomain(userroledefieldesdto);
		userroledefieldesService.create(domain);
        UserRoleDEFieldesDTO dto = userroledefieldesMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"UserRoleDEFieldes" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/userroledefieldes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<UserRoleDEFieldesDTO> userroledefieldesdtos) {
        userroledefieldesService.createBatch(userroledefieldesMapping.toDomain(userroledefieldesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#userroledefieldes_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"UserRoleDEFieldes" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/userroledefieldes/{userroledefieldes_id}")
    public ResponseEntity<UserRoleDEFieldesDTO> get(@PathVariable("userroledefieldes_id") String userroledefieldes_id) {
        UserRoleDEFieldes domain = userroledefieldesService.get(userroledefieldes_id);
        UserRoleDEFieldesDTO dto = userroledefieldesMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "Save", tags = {"UserRoleDEFieldes" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/userroledefieldes/save")
    public ResponseEntity<Boolean> save(@RequestBody UserRoleDEFieldesDTO userroledefieldesdto) {
        return ResponseEntity.status(HttpStatus.OK).body(userroledefieldesService.save(userroledefieldesMapping.toDomain(userroledefieldesdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"UserRoleDEFieldes" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/userroledefieldes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<UserRoleDEFieldesDTO> userroledefieldesdtos) {
        userroledefieldesService.saveBatch(userroledefieldesMapping.toDomain(userroledefieldesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"UserRoleDEFieldes" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/userroledefieldes/getdraft")
    public ResponseEntity<UserRoleDEFieldesDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(userroledefieldesMapping.toDto(userroledefieldesService.getDraft(new UserRoleDEFieldes())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserRoleDEFieldes-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"UserRoleDEFieldes" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/userroledefieldes/fetchdefault")
	public ResponseEntity<List<UserRoleDEFieldesDTO>> fetchDefault(UserRoleDEFieldesSearchContext context) {
        Page<UserRoleDEFieldes> domains = userroledefieldesService.searchDefault(context) ;
        List<UserRoleDEFieldesDTO> list = userroledefieldesMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserRoleDEFieldes-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"UserRoleDEFieldes" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/userroledefieldes/searchdefault")
	public ResponseEntity<Page<UserRoleDEFieldesDTO>> searchDefault(@RequestBody UserRoleDEFieldesSearchContext context) {
        Page<UserRoleDEFieldes> domains = userroledefieldesService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(userroledefieldesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public UserRoleDEFieldes getEntity(){
        return new UserRoleDEFieldes();
    }

}
