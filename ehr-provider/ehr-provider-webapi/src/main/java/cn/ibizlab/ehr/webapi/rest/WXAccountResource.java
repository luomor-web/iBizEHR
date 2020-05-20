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
import cn.ibizlab.ehr.core.wx.domain.WXAccount;
import cn.ibizlab.ehr.core.wx.service.IWXAccountService;
import cn.ibizlab.ehr.core.wx.filter.WXAccountSearchContext;




@Slf4j
@Api(tags = {"WXAccount" })
@RestController("WebApi-wxaccount")
@RequestMapping("")
public class WXAccountResource {

    @Autowired
    private IWXAccountService wxaccountService;

    @Autowired
    @Lazy
    private WXAccountMapping wxaccountMapping;




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"WXAccount" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/wxaccounts")
    @Transactional
    public ResponseEntity<WXAccountDTO> create(@RequestBody WXAccountDTO wxaccountdto) {
        WXAccount domain = wxaccountMapping.toDomain(wxaccountdto);
		wxaccountService.create(domain);
        WXAccountDTO dto = wxaccountMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"WXAccount" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wxaccounts/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WXAccountDTO> wxaccountdtos) {
        wxaccountService.createBatch(wxaccountMapping.toDomain(wxaccountdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"WXAccount" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/wxaccounts/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WXAccountDTO wxaccountdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wxaccountService.checkKey(wxaccountMapping.toDomain(wxaccountdto)));
    }




    @PreAuthorize("hasPermission(#wxaccount_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"WXAccount" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/wxaccounts/{wxaccount_id}")
    @Transactional
    public ResponseEntity<WXAccountDTO> update(@PathVariable("wxaccount_id") String wxaccount_id, @RequestBody WXAccountDTO wxaccountdto) {
		WXAccount domain = wxaccountMapping.toDomain(wxaccountdto);
        domain.setWxaccountid(wxaccount_id);
		wxaccountService.update(domain);
		WXAccountDTO dto = wxaccountMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#wxaccount_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"WXAccount" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/wxaccounts/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WXAccountDTO> wxaccountdtos) {
        wxaccountService.updateBatch(wxaccountMapping.toDomain(wxaccountdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "同步组织部门", tags = {"WXAccount" },  notes = "同步组织部门")
	@RequestMapping(method = RequestMethod.POST, value = "/wxaccounts/{wxaccount_id}/syncorgsector")
    @Transactional
    public ResponseEntity<WXAccountDTO> syncOrgSector(@PathVariable("wxaccount_id") String wxaccount_id, @RequestBody WXAccountDTO wxaccountdto) {
        WXAccount wxaccount = wxaccountMapping.toDomain(wxaccountdto);
        wxaccount = wxaccountService.syncOrgSector(wxaccount);
        wxaccountdto = wxaccountMapping.toDto(wxaccount);
        return ResponseEntity.status(HttpStatus.OK).body(wxaccountdto);
    }




    @ApiOperation(value = "发布菜单", tags = {"WXAccount" },  notes = "发布菜单")
	@RequestMapping(method = RequestMethod.POST, value = "/wxaccounts/{wxaccount_id}/pubmenu")
    @Transactional
    public ResponseEntity<WXAccountDTO> pubMenu(@PathVariable("wxaccount_id") String wxaccount_id, @RequestBody WXAccountDTO wxaccountdto) {
        WXAccount wxaccount = wxaccountMapping.toDomain(wxaccountdto);
        wxaccount = wxaccountService.pubMenu(wxaccount);
        wxaccountdto = wxaccountMapping.toDto(wxaccount);
        return ResponseEntity.status(HttpStatus.OK).body(wxaccountdto);
    }




    @PreAuthorize("hasPermission(#wxaccount_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"WXAccount" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wxaccounts/{wxaccount_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("wxaccount_id") String wxaccount_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wxaccountService.remove(wxaccount_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"WXAccount" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wxaccounts/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wxaccountService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "同步组织人员", tags = {"WXAccount" },  notes = "同步组织人员")
	@RequestMapping(method = RequestMethod.POST, value = "/wxaccounts/{wxaccount_id}/syncorguser")
    @Transactional
    public ResponseEntity<WXAccountDTO> syncOrgUser(@PathVariable("wxaccount_id") String wxaccount_id, @RequestBody WXAccountDTO wxaccountdto) {
        WXAccount wxaccount = wxaccountMapping.toDomain(wxaccountdto);
        wxaccount = wxaccountService.syncOrgUser(wxaccount);
        wxaccountdto = wxaccountMapping.toDto(wxaccount);
        return ResponseEntity.status(HttpStatus.OK).body(wxaccountdto);
    }




    @PreAuthorize("hasPermission(#wxaccount_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"WXAccount" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/wxaccounts/{wxaccount_id}")
    public ResponseEntity<WXAccountDTO> get(@PathVariable("wxaccount_id") String wxaccount_id) {
        WXAccount domain = wxaccountService.get(wxaccount_id);
        WXAccountDTO dto = wxaccountMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "Save", tags = {"WXAccount" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/wxaccounts/save")
    public ResponseEntity<Boolean> save(@RequestBody WXAccountDTO wxaccountdto) {
        return ResponseEntity.status(HttpStatus.OK).body(wxaccountService.save(wxaccountMapping.toDomain(wxaccountdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"WXAccount" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wxaccounts/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WXAccountDTO> wxaccountdtos) {
        wxaccountService.saveBatch(wxaccountMapping.toDomain(wxaccountdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"WXAccount" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/wxaccounts/getdraft")
    public ResponseEntity<WXAccountDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wxaccountMapping.toDto(wxaccountService.getDraft(new WXAccount())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WXAccount-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"WXAccount" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wxaccounts/fetchdefault")
	public ResponseEntity<List<WXAccountDTO>> fetchDefault(WXAccountSearchContext context) {
        Page<WXAccount> domains = wxaccountService.searchDefault(context) ;
        List<WXAccountDTO> list = wxaccountMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WXAccount-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"WXAccount" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/wxaccounts/searchdefault")
	public ResponseEntity<Page<WXAccountDTO>> searchDefault(@RequestBody WXAccountSearchContext context) {
        Page<WXAccount> domains = wxaccountService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wxaccountMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public WXAccount getEntity(){
        return new WXAccount();
    }

}
