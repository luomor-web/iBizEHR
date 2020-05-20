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
import cn.ibizlab.ehr.core.wx.domain.WXEntApp;
import cn.ibizlab.ehr.core.wx.service.IWXEntAppService;
import cn.ibizlab.ehr.core.wx.filter.WXEntAppSearchContext;




@Slf4j
@Api(tags = {"WXEntApp" })
@RestController("WebApi-wxentapp")
@RequestMapping("")
public class WXEntAppResource {

    @Autowired
    private IWXEntAppService wxentappService;

    @Autowired
    @Lazy
    private WXEntAppMapping wxentappMapping;




    @ApiOperation(value = "GetDraft", tags = {"WXEntApp" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/wxentapps/getdraft")
    public ResponseEntity<WXEntAppDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wxentappMapping.toDto(wxentappService.getDraft(new WXEntApp())));
    }




    @PreAuthorize("hasPermission('Remove',{#wxentapp_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"WXEntApp" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wxentapps/{wxentapp_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("wxentapp_id") String wxentapp_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wxentappService.remove(wxentapp_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"WXEntApp" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wxentapps/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wxentappService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#wxentapp_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"WXEntApp" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/wxentapps/{wxentapp_id}")
    public ResponseEntity<WXEntAppDTO> get(@PathVariable("wxentapp_id") String wxentapp_id) {
        WXEntApp domain = wxentappService.get(wxentapp_id);
        WXEntAppDTO dto = wxentappMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "Save", tags = {"WXEntApp" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/wxentapps/save")
    public ResponseEntity<Boolean> save(@RequestBody WXEntAppDTO wxentappdto) {
        return ResponseEntity.status(HttpStatus.OK).body(wxentappService.save(wxentappMapping.toDomain(wxentappdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"WXEntApp" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wxentapps/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WXEntAppDTO> wxentappdtos) {
        wxentappService.saveBatch(wxentappMapping.toDomain(wxentappdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "发布菜单", tags = {"WXEntApp" },  notes = "发布菜单")
	@RequestMapping(method = RequestMethod.POST, value = "/wxentapps/{wxentapp_id}/pubmenu")
    @Transactional
    public ResponseEntity<WXEntAppDTO> pubMenu(@PathVariable("wxentapp_id") String wxentapp_id, @RequestBody WXEntAppDTO wxentappdto) {
        WXEntApp wxentapp = wxentappMapping.toDomain(wxentappdto);
        wxentapp = wxentappService.pubMenu(wxentapp);
        wxentappdto = wxentappMapping.toDto(wxentapp);
        return ResponseEntity.status(HttpStatus.OK).body(wxentappdto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"WXEntApp" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/wxentapps")
    @Transactional
    public ResponseEntity<WXEntAppDTO> create(@RequestBody WXEntAppDTO wxentappdto) {
        WXEntApp domain = wxentappMapping.toDomain(wxentappdto);
		wxentappService.create(domain);
        WXEntAppDTO dto = wxentappMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"WXEntApp" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wxentapps/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WXEntAppDTO> wxentappdtos) {
        wxentappService.createBatch(wxentappMapping.toDomain(wxentappdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#wxentapp_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"WXEntApp" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/wxentapps/{wxentapp_id}")
    @Transactional
    public ResponseEntity<WXEntAppDTO> update(@PathVariable("wxentapp_id") String wxentapp_id, @RequestBody WXEntAppDTO wxentappdto) {
		WXEntApp domain = wxentappMapping.toDomain(wxentappdto);
        domain.setWxentappid(wxentapp_id);
		wxentappService.update(domain);
		WXEntAppDTO dto = wxentappMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#wxentapp_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"WXEntApp" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/wxentapps/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WXEntAppDTO> wxentappdtos) {
        wxentappService.updateBatch(wxentappMapping.toDomain(wxentappdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"WXEntApp" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/wxentapps/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WXEntAppDTO wxentappdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wxentappService.checkKey(wxentappMapping.toDomain(wxentappdto)));
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"WXEntApp" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wxentapps/fetchdefault")
	public ResponseEntity<List<WXEntAppDTO>> fetchDefault(WXEntAppSearchContext context) {
        Page<WXEntApp> domains = wxentappService.searchDefault(context) ;
        List<WXEntAppDTO> list = wxentappMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"WXEntApp" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/wxentapps/searchdefault")
	public ResponseEntity<Page<WXEntAppDTO>> searchDefault(@RequestBody WXEntAppSearchContext context) {
        Page<WXEntApp> domains = wxentappService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wxentappMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public WXEntApp getEntity(){
        return new WXEntApp();
    }

}
