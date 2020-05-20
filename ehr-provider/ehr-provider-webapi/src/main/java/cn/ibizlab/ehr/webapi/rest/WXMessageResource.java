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
import cn.ibizlab.ehr.core.wx.domain.WXMessage;
import cn.ibizlab.ehr.core.wx.service.IWXMessageService;
import cn.ibizlab.ehr.core.wx.filter.WXMessageSearchContext;




@Slf4j
@Api(tags = {"WXMessage" })
@RestController("WebApi-wxmessage")
@RequestMapping("")
public class WXMessageResource {

    @Autowired
    private IWXMessageService wxmessageService;

    @Autowired
    @Lazy
    private WXMessageMapping wxmessageMapping;




    @PreAuthorize("hasPermission(#wxmessage_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"WXMessage" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/wxmessages/{wxmessage_id}")
    @Transactional
    public ResponseEntity<WXMessageDTO> update(@PathVariable("wxmessage_id") String wxmessage_id, @RequestBody WXMessageDTO wxmessagedto) {
		WXMessage domain = wxmessageMapping.toDomain(wxmessagedto);
        domain.setWxmessageid(wxmessage_id);
		wxmessageService.update(domain);
		WXMessageDTO dto = wxmessageMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#wxmessage_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"WXMessage" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/wxmessages/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WXMessageDTO> wxmessagedtos) {
        wxmessageService.updateBatch(wxmessageMapping.toDomain(wxmessagedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"WXMessage" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/wxmessages/getdraft")
    public ResponseEntity<WXMessageDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wxmessageMapping.toDto(wxmessageService.getDraft(new WXMessage())));
    }




    @ApiOperation(value = "CheckKey", tags = {"WXMessage" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/wxmessages/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WXMessageDTO wxmessagedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wxmessageService.checkKey(wxmessageMapping.toDomain(wxmessagedto)));
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"WXMessage" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/wxmessages")
    @Transactional
    public ResponseEntity<WXMessageDTO> create(@RequestBody WXMessageDTO wxmessagedto) {
        WXMessage domain = wxmessageMapping.toDomain(wxmessagedto);
		wxmessageService.create(domain);
        WXMessageDTO dto = wxmessageMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"WXMessage" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wxmessages/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WXMessageDTO> wxmessagedtos) {
        wxmessageService.createBatch(wxmessageMapping.toDomain(wxmessagedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"WXMessage" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/wxmessages/save")
    public ResponseEntity<Boolean> save(@RequestBody WXMessageDTO wxmessagedto) {
        return ResponseEntity.status(HttpStatus.OK).body(wxmessageService.save(wxmessageMapping.toDomain(wxmessagedto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"WXMessage" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wxmessages/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WXMessageDTO> wxmessagedtos) {
        wxmessageService.saveBatch(wxmessageMapping.toDomain(wxmessagedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#wxmessage_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"WXMessage" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/wxmessages/{wxmessage_id}")
    public ResponseEntity<WXMessageDTO> get(@PathVariable("wxmessage_id") String wxmessage_id) {
        WXMessage domain = wxmessageService.get(wxmessage_id);
        WXMessageDTO dto = wxmessageMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#wxmessage_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"WXMessage" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wxmessages/{wxmessage_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("wxmessage_id") String wxmessage_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wxmessageService.remove(wxmessage_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"WXMessage" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wxmessages/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wxmessageService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WXMessage-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"WXMessage" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wxmessages/fetchdefault")
	public ResponseEntity<List<WXMessageDTO>> fetchDefault(WXMessageSearchContext context) {
        Page<WXMessage> domains = wxmessageService.searchDefault(context) ;
        List<WXMessageDTO> list = wxmessageMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WXMessage-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"WXMessage" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/wxmessages/searchdefault")
	public ResponseEntity<Page<WXMessageDTO>> searchDefault(@RequestBody WXMessageSearchContext context) {
        Page<WXMessage> domains = wxmessageService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wxmessageMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public WXMessage getEntity(){
        return new WXMessage();
    }

}
