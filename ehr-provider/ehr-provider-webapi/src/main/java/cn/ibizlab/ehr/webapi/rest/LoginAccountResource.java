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
import cn.ibizlab.ehr.core.common.domain.LoginAccount;
import cn.ibizlab.ehr.core.common.service.ILoginAccountService;
import cn.ibizlab.ehr.core.common.filter.LoginAccountSearchContext;




@Slf4j
@Api(tags = {"LoginAccount" })
@RestController("WebApi-loginaccount")
@RequestMapping("")
public class LoginAccountResource {

    @Autowired
    private ILoginAccountService loginaccountService;

    @Autowired
    @Lazy
    private LoginAccountMapping loginaccountMapping;




    @ApiOperation(value = "Save", tags = {"LoginAccount" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/loginaccounts/save")
    public ResponseEntity<Boolean> save(@RequestBody LoginAccountDTO loginaccountdto) {
        return ResponseEntity.status(HttpStatus.OK).body(loginaccountService.save(loginaccountMapping.toDomain(loginaccountdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"LoginAccount" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/loginaccounts/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<LoginAccountDTO> loginaccountdtos) {
        loginaccountService.saveBatch(loginaccountMapping.toDomain(loginaccountdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"LoginAccount" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/loginaccounts/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody LoginAccountDTO loginaccountdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(loginaccountService.checkKey(loginaccountMapping.toDomain(loginaccountdto)));
    }




    @ApiOperation(value = "保存（密码Hash）", tags = {"LoginAccount" },  notes = "保存（密码Hash）")
	@RequestMapping(method = RequestMethod.POST, value = "/loginaccounts/{loginaccount_id}/savehashmode")
    @Transactional
    public ResponseEntity<LoginAccountDTO> saveHashMode(@PathVariable("loginaccount_id") String loginaccount_id, @RequestBody LoginAccountDTO loginaccountdto) {
        LoginAccount loginaccount = loginaccountMapping.toDomain(loginaccountdto);
        loginaccount = loginaccountService.saveHashMode(loginaccount);
        loginaccountdto = loginaccountMapping.toDto(loginaccount);
        return ResponseEntity.status(HttpStatus.OK).body(loginaccountdto);
    }




    @PreAuthorize("hasPermission(#loginaccount_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"LoginAccount" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/loginaccounts/{loginaccount_id}")
    @Transactional
    public ResponseEntity<LoginAccountDTO> update(@PathVariable("loginaccount_id") String loginaccount_id, @RequestBody LoginAccountDTO loginaccountdto) {
		LoginAccount domain = loginaccountMapping.toDomain(loginaccountdto);
        domain.setLoginaccountid(loginaccount_id);
		loginaccountService.update(domain);
		LoginAccountDTO dto = loginaccountMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#loginaccount_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"LoginAccount" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/loginaccounts/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<LoginAccountDTO> loginaccountdtos) {
        loginaccountService.updateBatch(loginaccountMapping.toDomain(loginaccountdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#loginaccount_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"LoginAccount" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/loginaccounts/{loginaccount_id}")
    public ResponseEntity<LoginAccountDTO> get(@PathVariable("loginaccount_id") String loginaccount_id) {
        LoginAccount domain = loginaccountService.get(loginaccount_id);
        LoginAccountDTO dto = loginaccountMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "获取（密码Hash）", tags = {"LoginAccount" },  notes = "获取（密码Hash）")
	@RequestMapping(method = RequestMethod.GET, value = "/loginaccounts/{loginaccount_id}/gethashmode")
    @Transactional
    public ResponseEntity<LoginAccountDTO> getHashMode(@PathVariable("loginaccount_id") String loginaccount_id, @RequestBody LoginAccountDTO loginaccountdto) {
        LoginAccount loginaccount = loginaccountMapping.toDomain(loginaccountdto);
        loginaccount = loginaccountService.getHashMode(loginaccount);
        loginaccountdto = loginaccountMapping.toDto(loginaccount);
        return ResponseEntity.status(HttpStatus.OK).body(loginaccountdto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"LoginAccount" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/loginaccounts")
    @Transactional
    public ResponseEntity<LoginAccountDTO> create(@RequestBody LoginAccountDTO loginaccountdto) {
        LoginAccount domain = loginaccountMapping.toDomain(loginaccountdto);
		loginaccountService.create(domain);
        LoginAccountDTO dto = loginaccountMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"LoginAccount" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/loginaccounts/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<LoginAccountDTO> loginaccountdtos) {
        loginaccountService.createBatch(loginaccountMapping.toDomain(loginaccountdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"LoginAccount" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/loginaccounts/getdraft")
    public ResponseEntity<LoginAccountDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(loginaccountMapping.toDto(loginaccountService.getDraft(new LoginAccount())));
    }




    @PreAuthorize("hasPermission(#loginaccount_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"LoginAccount" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/loginaccounts/{loginaccount_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("loginaccount_id") String loginaccount_id) {
         return ResponseEntity.status(HttpStatus.OK).body(loginaccountService.remove(loginaccount_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"LoginAccount" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/loginaccounts/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        loginaccountService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-LoginAccount-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"LoginAccount" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/loginaccounts/fetchdefault")
	public ResponseEntity<List<LoginAccountDTO>> fetchDefault(LoginAccountSearchContext context) {
        Page<LoginAccount> domains = loginaccountService.searchDefault(context) ;
        List<LoginAccountDTO> list = loginaccountMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-LoginAccount-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"LoginAccount" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/loginaccounts/searchdefault")
	public ResponseEntity<Page<LoginAccountDTO>> searchDefault(@RequestBody LoginAccountSearchContext context) {
        Page<LoginAccount> domains = loginaccountService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(loginaccountMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public LoginAccount getEntity(){
        return new LoginAccount();
    }

}
