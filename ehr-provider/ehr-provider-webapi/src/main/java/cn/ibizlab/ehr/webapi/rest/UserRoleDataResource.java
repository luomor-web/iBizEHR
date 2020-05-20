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
import cn.ibizlab.ehr.core.common.domain.UserRoleData;
import cn.ibizlab.ehr.core.common.service.IUserRoleDataService;
import cn.ibizlab.ehr.core.common.filter.UserRoleDataSearchContext;




@Slf4j
@Api(tags = {"UserRoleData" })
@RestController("WebApi-userroledata")
@RequestMapping("")
public class UserRoleDataResource {

    @Autowired
    private IUserRoleDataService userroledataService;

    @Autowired
    @Lazy
    private UserRoleDataMapping userroledataMapping;




    @ApiOperation(value = "CheckKey", tags = {"UserRoleData" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/userroledata/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody UserRoleDataDTO userroledatadto) {
        return  ResponseEntity.status(HttpStatus.OK).body(userroledataService.checkKey(userroledataMapping.toDomain(userroledatadto)));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"UserRoleData" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/userroledata")
    @Transactional
    public ResponseEntity<UserRoleDataDTO> create(@RequestBody UserRoleDataDTO userroledatadto) {
        UserRoleData domain = userroledataMapping.toDomain(userroledatadto);
		userroledataService.create(domain);
        UserRoleDataDTO dto = userroledataMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"UserRoleData" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/userroledata/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<UserRoleDataDTO> userroledatadtos) {
        userroledataService.createBatch(userroledataMapping.toDomain(userroledatadtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#userroledata_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"UserRoleData" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/userroledata/{userroledata_id}")
    @Transactional
    public ResponseEntity<UserRoleDataDTO> update(@PathVariable("userroledata_id") String userroledata_id, @RequestBody UserRoleDataDTO userroledatadto) {
		UserRoleData domain = userroledataMapping.toDomain(userroledatadto);
        domain.setUserroledataid(userroledata_id);
		userroledataService.update(domain);
		UserRoleDataDTO dto = userroledataMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#userroledata_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"UserRoleData" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/userroledata/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<UserRoleDataDTO> userroledatadtos) {
        userroledataService.updateBatch(userroledataMapping.toDomain(userroledatadtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#userroledata_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"UserRoleData" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/userroledata/{userroledata_id}")
    public ResponseEntity<UserRoleDataDTO> get(@PathVariable("userroledata_id") String userroledata_id) {
        UserRoleData domain = userroledataService.get(userroledata_id);
        UserRoleDataDTO dto = userroledataMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#userroledata_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"UserRoleData" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/userroledata/{userroledata_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("userroledata_id") String userroledata_id) {
         return ResponseEntity.status(HttpStatus.OK).body(userroledataService.remove(userroledata_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"UserRoleData" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/userroledata/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        userroledataService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"UserRoleData" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/userroledata/save")
    public ResponseEntity<Boolean> save(@RequestBody UserRoleDataDTO userroledatadto) {
        return ResponseEntity.status(HttpStatus.OK).body(userroledataService.save(userroledataMapping.toDomain(userroledatadto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"UserRoleData" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/userroledata/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<UserRoleDataDTO> userroledatadtos) {
        userroledataService.saveBatch(userroledataMapping.toDomain(userroledatadtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"UserRoleData" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/userroledata/getdraft")
    public ResponseEntity<UserRoleDataDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(userroledataMapping.toDto(userroledataService.getDraft(new UserRoleData())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserRoleData-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"UserRoleData" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/userroledata/fetchdefault")
	public ResponseEntity<List<UserRoleDataDTO>> fetchDefault(UserRoleDataSearchContext context) {
        Page<UserRoleData> domains = userroledataService.searchDefault(context) ;
        List<UserRoleDataDTO> list = userroledataMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserRoleData-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"UserRoleData" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/userroledata/searchdefault")
	public ResponseEntity<Page<UserRoleDataDTO>> searchDefault(@RequestBody UserRoleDataSearchContext context) {
        Page<UserRoleData> domains = userroledataService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(userroledataMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public UserRoleData getEntity(){
        return new UserRoleData();
    }

}
