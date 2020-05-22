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
import cn.ibizlab.ehr.core.wx.domain.WXMedia;
import cn.ibizlab.ehr.core.wx.service.IWXMediaService;
import cn.ibizlab.ehr.core.wx.filter.WXMediaSearchContext;




@Slf4j
@Api(tags = {"WXMedia" })
@RestController("WebApi-wxmedia")
@RequestMapping("")
public class WXMediaResource {

    @Autowired
    private IWXMediaService wxmediaService;

    @Autowired
    @Lazy
    public WXMediaMapping wxmediaMapping;

    public WXMediaDTO permissionDTO=new WXMediaDTO();

    @PreAuthorize("hasPermission('','Create',{'Sql',this.wxmediaMapping,#wxmediadto})")
    @ApiOperation(value = "Create", tags = {"WXMedia" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/wxmedia")
    @Transactional
    public ResponseEntity<WXMediaDTO> create(@RequestBody WXMediaDTO wxmediadto) {
        WXMedia domain = wxmediaMapping.toDomain(wxmediadto);
		wxmediaService.create(domain);
        WXMediaDTO dto = wxmediaMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"WXMedia" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wxmedia/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WXMediaDTO> wxmediadtos) {
        wxmediaService.createBatch(wxmediaMapping.toDomain(wxmediadtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WXMedia-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"WXMedia" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/wxmedia/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WXMediaDTO wxmediadto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wxmediaService.checkKey(wxmediaMapping.toDomain(wxmediadto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WXMedia-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"WXMedia" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/wxmedia/getdraft")
    public ResponseEntity<WXMediaDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wxmediaMapping.toDto(wxmediaService.getDraft(new WXMedia())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WXMedia-Save-all')")
    @ApiOperation(value = "Save", tags = {"WXMedia" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/wxmedia/save")
    public ResponseEntity<Boolean> save(@RequestBody WXMediaDTO wxmediadto) {
        return ResponseEntity.status(HttpStatus.OK).body(wxmediaService.save(wxmediaMapping.toDomain(wxmediadto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"WXMedia" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wxmedia/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WXMediaDTO> wxmediadtos) {
        wxmediaService.saveBatch(wxmediaMapping.toDomain(wxmediadtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#wxmedia_id,'Update',{'Sql',this.wxmediaMapping,#wxmediadto})")
    @ApiOperation(value = "Update", tags = {"WXMedia" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/wxmedia/{wxmedia_id}")
    @Transactional
    public ResponseEntity<WXMediaDTO> update(@PathVariable("wxmedia_id") String wxmedia_id, @RequestBody WXMediaDTO wxmediadto) {
		WXMedia domain = wxmediaMapping.toDomain(wxmediadto);
        domain.setWxmediaid(wxmedia_id);
		wxmediaService.update(domain);
		WXMediaDTO dto = wxmediaMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"WXMedia" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/wxmedia/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WXMediaDTO> wxmediadtos) {
        wxmediaService.updateBatch(wxmediaMapping.toDomain(wxmediadtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#wxmedia_id,'Get',{'Sql',this.wxmediaMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"WXMedia" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/wxmedia/{wxmedia_id}")
    public ResponseEntity<WXMediaDTO> get(@PathVariable("wxmedia_id") String wxmedia_id) {
        WXMedia domain = wxmediaService.get(wxmedia_id);
        WXMediaDTO dto = wxmediaMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#wxmedia_id,'Remove',{'Sql',this.wxmediaMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"WXMedia" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wxmedia/{wxmedia_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("wxmedia_id") String wxmedia_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wxmediaService.remove(wxmedia_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"WXMedia" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wxmedia/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wxmediaService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WXMedia-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"WXMedia" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wxmedia/fetchdefault")
	public ResponseEntity<List<WXMediaDTO>> fetchDefault(WXMediaSearchContext context) {
        Page<WXMedia> domains = wxmediaService.searchDefault(context) ;
        List<WXMediaDTO> list = wxmediaMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WXMedia-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"WXMedia" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/wxmedia/searchdefault")
	public ResponseEntity<Page<WXMediaDTO>> searchDefault(@RequestBody WXMediaSearchContext context) {
        Page<WXMedia> domains = wxmediaService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wxmediaMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
