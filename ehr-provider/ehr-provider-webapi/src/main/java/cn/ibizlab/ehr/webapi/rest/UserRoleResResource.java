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
import cn.ibizlab.ehr.core.common.domain.UserRoleRes;
import cn.ibizlab.ehr.core.common.service.IUserRoleResService;
import cn.ibizlab.ehr.core.common.filter.UserRoleResSearchContext;




@Slf4j
@Api(tags = {"UserRoleRes" })
@RestController("WebApi-userroleres")
@RequestMapping("")
public class UserRoleResResource {

    @Autowired
    private IUserRoleResService userroleresService;

    @Autowired
    @Lazy
    private UserRoleResMapping userroleresMapping;




    @ApiOperation(value = "GetDraft", tags = {"UserRoleRes" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/userroleres/getdraft")
    public ResponseEntity<UserRoleResDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(userroleresMapping.toDto(userroleresService.getDraft(new UserRoleRes())));
    }




    @PreAuthorize("hasPermission('Remove',{#userroleres_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"UserRoleRes" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/userroleres/{userroleres_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("userroleres_id") String userroleres_id) {
         return ResponseEntity.status(HttpStatus.OK).body(userroleresService.remove(userroleres_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"UserRoleRes" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/userroleres/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        userroleresService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"UserRoleRes" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/userroleres/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody UserRoleResDTO userroleresdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(userroleresService.checkKey(userroleresMapping.toDomain(userroleresdto)));
    }




    @PreAuthorize("hasPermission(#userroleres_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"UserRoleRes" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/userroleres/{userroleres_id}")
    public ResponseEntity<UserRoleResDTO> get(@PathVariable("userroleres_id") String userroleres_id) {
        UserRoleRes domain = userroleresService.get(userroleres_id);
        UserRoleResDTO dto = userroleresMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#userroleres_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"UserRoleRes" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/userroleres/{userroleres_id}")
    @Transactional
    public ResponseEntity<UserRoleResDTO> update(@PathVariable("userroleres_id") String userroleres_id, @RequestBody UserRoleResDTO userroleresdto) {
		UserRoleRes domain = userroleresMapping.toDomain(userroleresdto);
        domain.setUserroleresid(userroleres_id);
		userroleresService.update(domain);
		UserRoleResDTO dto = userroleresMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#userroleres_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"UserRoleRes" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/userroleres/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<UserRoleResDTO> userroleresdtos) {
        userroleresService.updateBatch(userroleresMapping.toDomain(userroleresdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"UserRoleRes" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/userroleres/save")
    public ResponseEntity<Boolean> save(@RequestBody UserRoleResDTO userroleresdto) {
        return ResponseEntity.status(HttpStatus.OK).body(userroleresService.save(userroleresMapping.toDomain(userroleresdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"UserRoleRes" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/userroleres/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<UserRoleResDTO> userroleresdtos) {
        userroleresService.saveBatch(userroleresMapping.toDomain(userroleresdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"UserRoleRes" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/userroleres")
    @Transactional
    public ResponseEntity<UserRoleResDTO> create(@RequestBody UserRoleResDTO userroleresdto) {
        UserRoleRes domain = userroleresMapping.toDomain(userroleresdto);
		userroleresService.create(domain);
        UserRoleResDTO dto = userroleresMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"UserRoleRes" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/userroleres/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<UserRoleResDTO> userroleresdtos) {
        userroleresService.createBatch(userroleresMapping.toDomain(userroleresdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"UserRoleRes" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/userroleres/fetchdefault")
	public ResponseEntity<List<UserRoleResDTO>> fetchDefault(UserRoleResSearchContext context) {
        Page<UserRoleRes> domains = userroleresService.searchDefault(context) ;
        List<UserRoleResDTO> list = userroleresMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"UserRoleRes" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/userroleres/searchdefault")
	public ResponseEntity<Page<UserRoleResDTO>> searchDefault(@RequestBody UserRoleResSearchContext context) {
        Page<UserRoleRes> domains = userroleresService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(userroleresMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public UserRoleRes getEntity(){
        return new UserRoleRes();
    }

}
