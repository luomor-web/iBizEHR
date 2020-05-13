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
import cn.ibizlab.ehr.core.wx.domain.WXAccessToken;
import cn.ibizlab.ehr.core.wx.service.IWXAccessTokenService;
import cn.ibizlab.ehr.core.wx.filter.WXAccessTokenSearchContext;




@Slf4j
@Api(tags = {"WXAccessToken" })
@RestController("WebApi-wxaccesstoken")
@RequestMapping("")
public class WXAccessTokenResource {

    @Autowired
    private IWXAccessTokenService wxaccesstokenService;

    @Autowired
    @Lazy
    private WXAccessTokenMapping wxaccesstokenMapping;




    @PreAuthorize("hasPermission(#wxaccesstoken_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"WXAccessToken" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/wxaccesstokens/{wxaccesstoken_id}")
    @Transactional
    public ResponseEntity<WXAccessTokenDTO> update(@PathVariable("wxaccesstoken_id") String wxaccesstoken_id, @RequestBody WXAccessTokenDTO wxaccesstokendto) {
		WXAccessToken domain = wxaccesstokenMapping.toDomain(wxaccesstokendto);
        domain.setWxaccesstokenid(wxaccesstoken_id);
		wxaccesstokenService.update(domain);
		WXAccessTokenDTO dto = wxaccesstokenMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#wxaccesstoken_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"WXAccessToken" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/wxaccesstokens/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WXAccessTokenDTO> wxaccesstokendtos) {
        wxaccesstokenService.updateBatch(wxaccesstokenMapping.toDomain(wxaccesstokendtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#wxaccesstoken_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"WXAccessToken" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/wxaccesstokens/{wxaccesstoken_id}")
    public ResponseEntity<WXAccessTokenDTO> get(@PathVariable("wxaccesstoken_id") String wxaccesstoken_id) {
        WXAccessToken domain = wxaccesstokenService.get(wxaccesstoken_id);
        WXAccessTokenDTO dto = wxaccesstokenMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "CheckKey", tags = {"WXAccessToken" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/wxaccesstokens/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WXAccessTokenDTO wxaccesstokendto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wxaccesstokenService.checkKey(wxaccesstokenMapping.toDomain(wxaccesstokendto)));
    }




    @ApiOperation(value = "Save", tags = {"WXAccessToken" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/wxaccesstokens/save")
    public ResponseEntity<Boolean> save(@RequestBody WXAccessTokenDTO wxaccesstokendto) {
        return ResponseEntity.status(HttpStatus.OK).body(wxaccesstokenService.save(wxaccesstokenMapping.toDomain(wxaccesstokendto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"WXAccessToken" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wxaccesstokens/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WXAccessTokenDTO> wxaccesstokendtos) {
        wxaccesstokenService.saveBatch(wxaccesstokenMapping.toDomain(wxaccesstokendtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"WXAccessToken" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/wxaccesstokens")
    @Transactional
    public ResponseEntity<WXAccessTokenDTO> create(@RequestBody WXAccessTokenDTO wxaccesstokendto) {
        WXAccessToken domain = wxaccesstokenMapping.toDomain(wxaccesstokendto);
		wxaccesstokenService.create(domain);
        WXAccessTokenDTO dto = wxaccesstokenMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"WXAccessToken" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wxaccesstokens/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WXAccessTokenDTO> wxaccesstokendtos) {
        wxaccesstokenService.createBatch(wxaccesstokenMapping.toDomain(wxaccesstokendtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#wxaccesstoken_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"WXAccessToken" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wxaccesstokens/{wxaccesstoken_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("wxaccesstoken_id") String wxaccesstoken_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wxaccesstokenService.remove(wxaccesstoken_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"WXAccessToken" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wxaccesstokens/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wxaccesstokenService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"WXAccessToken" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/wxaccesstokens/getdraft")
    public ResponseEntity<WXAccessTokenDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wxaccesstokenMapping.toDto(wxaccesstokenService.getDraft(new WXAccessToken())));
    }

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"WXAccessToken" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wxaccesstokens/fetchdefault")
	public ResponseEntity<List<WXAccessTokenDTO>> fetchDefault(WXAccessTokenSearchContext context) {
        Page<WXAccessToken> domains = wxaccesstokenService.searchDefault(context) ;
        List<WXAccessTokenDTO> list = wxaccesstokenMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"WXAccessToken" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wxaccesstokens/searchdefault")
	public ResponseEntity<Page<WXAccessTokenDTO>> searchDefault(WXAccessTokenSearchContext context) {
        Page<WXAccessToken> domains = wxaccesstokenService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wxaccesstokenMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public WXAccessToken getEntity(){
        return new WXAccessToken();
    }

}
