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
import cn.ibizlab.ehr.core.common.domain.LoginLog;
import cn.ibizlab.ehr.core.common.service.ILoginLogService;
import cn.ibizlab.ehr.core.common.filter.LoginLogSearchContext;




@Slf4j
@Api(tags = {"LoginLog" })
@RestController("WebApi-loginlog")
@RequestMapping("")
public class LoginLogResource {

    @Autowired
    private ILoginLogService loginlogService;

    @Autowired
    @Lazy
    private LoginLogMapping loginlogMapping;




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"LoginLog" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/loginlogs")
    @Transactional
    public ResponseEntity<LoginLogDTO> create(@RequestBody LoginLogDTO loginlogdto) {
        LoginLog domain = loginlogMapping.toDomain(loginlogdto);
		loginlogService.create(domain);
        LoginLogDTO dto = loginlogMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"LoginLog" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/loginlogs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<LoginLogDTO> loginlogdtos) {
        loginlogService.createBatch(loginlogMapping.toDomain(loginlogdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"LoginLog" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/loginlogs/save")
    public ResponseEntity<Boolean> save(@RequestBody LoginLogDTO loginlogdto) {
        return ResponseEntity.status(HttpStatus.OK).body(loginlogService.save(loginlogMapping.toDomain(loginlogdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"LoginLog" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/loginlogs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<LoginLogDTO> loginlogdtos) {
        loginlogService.saveBatch(loginlogMapping.toDomain(loginlogdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"LoginLog" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/loginlogs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody LoginLogDTO loginlogdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(loginlogService.checkKey(loginlogMapping.toDomain(loginlogdto)));
    }




    @ApiOperation(value = "GetDraft", tags = {"LoginLog" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/loginlogs/getdraft")
    public ResponseEntity<LoginLogDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(loginlogMapping.toDto(loginlogService.getDraft(new LoginLog())));
    }




    @PreAuthorize("hasPermission(#loginlog_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"LoginLog" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/loginlogs/{loginlog_id}")
    public ResponseEntity<LoginLogDTO> get(@PathVariable("loginlog_id") String loginlog_id) {
        LoginLog domain = loginlogService.get(loginlog_id);
        LoginLogDTO dto = loginlogMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('Remove',{#loginlog_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"LoginLog" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/loginlogs/{loginlog_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("loginlog_id") String loginlog_id) {
         return ResponseEntity.status(HttpStatus.OK).body(loginlogService.remove(loginlog_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"LoginLog" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/loginlogs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        loginlogService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#loginlog_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"LoginLog" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/loginlogs/{loginlog_id}")
    @Transactional
    public ResponseEntity<LoginLogDTO> update(@PathVariable("loginlog_id") String loginlog_id, @RequestBody LoginLogDTO loginlogdto) {
		LoginLog domain = loginlogMapping.toDomain(loginlogdto);
        domain.setLoginlogid(loginlog_id);
		loginlogService.update(domain);
		LoginLogDTO dto = loginlogMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#loginlog_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"LoginLog" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/loginlogs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<LoginLogDTO> loginlogdtos) {
        loginlogService.updateBatch(loginlogMapping.toDomain(loginlogdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"LoginLog" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/loginlogs/fetchdefault")
	public ResponseEntity<List<LoginLogDTO>> fetchDefault(LoginLogSearchContext context) {
        Page<LoginLog> domains = loginlogService.searchDefault(context) ;
        List<LoginLogDTO> list = loginlogMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"LoginLog" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/loginlogs/searchdefault")
	public ResponseEntity<Page<LoginLogDTO>> searchDefault(LoginLogSearchContext context) {
        Page<LoginLog> domains = loginlogService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(loginlogMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public LoginLog getEntity(){
        return new LoginLog();
    }

}
