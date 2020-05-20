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
import cn.ibizlab.ehr.core.common.domain.UserRoleDatas;
import cn.ibizlab.ehr.core.common.service.IUserRoleDatasService;
import cn.ibizlab.ehr.core.common.filter.UserRoleDatasSearchContext;




@Slf4j
@Api(tags = {"UserRoleDatas" })
@RestController("WebApi-userroledatas")
@RequestMapping("")
public class UserRoleDatasResource {

    @Autowired
    private IUserRoleDatasService userroledatasService;

    @Autowired
    @Lazy
    private UserRoleDatasMapping userroledatasMapping;




    @PreAuthorize("hasPermission(#userroledatas_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"UserRoleDatas" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/userroledatas/{userroledatas_id}")
    public ResponseEntity<UserRoleDatasDTO> get(@PathVariable("userroledatas_id") String userroledatas_id) {
        UserRoleDatas domain = userroledatasService.get(userroledatas_id);
        UserRoleDatasDTO dto = userroledatasMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"UserRoleDatas" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/userroledatas")
    @Transactional
    public ResponseEntity<UserRoleDatasDTO> create(@RequestBody UserRoleDatasDTO userroledatasdto) {
        UserRoleDatas domain = userroledatasMapping.toDomain(userroledatasdto);
		userroledatasService.create(domain);
        UserRoleDatasDTO dto = userroledatasMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"UserRoleDatas" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/userroledatas/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<UserRoleDatasDTO> userroledatasdtos) {
        userroledatasService.createBatch(userroledatasMapping.toDomain(userroledatasdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#userroledatas_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"UserRoleDatas" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/userroledatas/{userroledatas_id}")
    @Transactional
    public ResponseEntity<UserRoleDatasDTO> update(@PathVariable("userroledatas_id") String userroledatas_id, @RequestBody UserRoleDatasDTO userroledatasdto) {
		UserRoleDatas domain = userroledatasMapping.toDomain(userroledatasdto);
        domain.setUserroledatasid(userroledatas_id);
		userroledatasService.update(domain);
		UserRoleDatasDTO dto = userroledatasMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#userroledatas_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"UserRoleDatas" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/userroledatas/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<UserRoleDatasDTO> userroledatasdtos) {
        userroledatasService.updateBatch(userroledatasMapping.toDomain(userroledatasdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"UserRoleDatas" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/userroledatas/save")
    public ResponseEntity<Boolean> save(@RequestBody UserRoleDatasDTO userroledatasdto) {
        return ResponseEntity.status(HttpStatus.OK).body(userroledatasService.save(userroledatasMapping.toDomain(userroledatasdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"UserRoleDatas" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/userroledatas/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<UserRoleDatasDTO> userroledatasdtos) {
        userroledatasService.saveBatch(userroledatasMapping.toDomain(userroledatasdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"UserRoleDatas" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/userroledatas/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody UserRoleDatasDTO userroledatasdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(userroledatasService.checkKey(userroledatasMapping.toDomain(userroledatasdto)));
    }




    @ApiOperation(value = "GetDraft", tags = {"UserRoleDatas" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/userroledatas/getdraft")
    public ResponseEntity<UserRoleDatasDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(userroledatasMapping.toDto(userroledatasService.getDraft(new UserRoleDatas())));
    }




    @PreAuthorize("hasPermission(#userroledatas_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"UserRoleDatas" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/userroledatas/{userroledatas_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("userroledatas_id") String userroledatas_id) {
         return ResponseEntity.status(HttpStatus.OK).body(userroledatasService.remove(userroledatas_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"UserRoleDatas" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/userroledatas/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        userroledatasService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserRoleDatas-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"UserRoleDatas" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/userroledatas/fetchdefault")
	public ResponseEntity<List<UserRoleDatasDTO>> fetchDefault(UserRoleDatasSearchContext context) {
        Page<UserRoleDatas> domains = userroledatasService.searchDefault(context) ;
        List<UserRoleDatasDTO> list = userroledatasMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserRoleDatas-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"UserRoleDatas" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/userroledatas/searchdefault")
	public ResponseEntity<Page<UserRoleDatasDTO>> searchDefault(@RequestBody UserRoleDatasSearchContext context) {
        Page<UserRoleDatas> domains = userroledatasService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(userroledatasMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public UserRoleDatas getEntity(){
        return new UserRoleDatas();
    }

}
