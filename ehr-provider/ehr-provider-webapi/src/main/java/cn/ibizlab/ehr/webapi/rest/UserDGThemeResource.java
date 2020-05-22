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
import cn.ibizlab.ehr.core.common.domain.UserDGTheme;
import cn.ibizlab.ehr.core.common.service.IUserDGThemeService;
import cn.ibizlab.ehr.core.common.filter.UserDGThemeSearchContext;




@Slf4j
@Api(tags = {"UserDGTheme" })
@RestController("WebApi-userdgtheme")
@RequestMapping("")
public class UserDGThemeResource {

    @Autowired
    private IUserDGThemeService userdgthemeService;

    @Autowired
    @Lazy
    public UserDGThemeMapping userdgthemeMapping;

    public UserDGThemeDTO permissionDTO=new UserDGThemeDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserDGTheme-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"UserDGTheme" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/userdgthemes/getdraft")
    public ResponseEntity<UserDGThemeDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(userdgthemeMapping.toDto(userdgthemeService.getDraft(new UserDGTheme())));
    }

    @PreAuthorize("hasPermission(#userdgtheme_id,'Get',{'Sql',this.userdgthemeMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"UserDGTheme" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/userdgthemes/{userdgtheme_id}")
    public ResponseEntity<UserDGThemeDTO> get(@PathVariable("userdgtheme_id") String userdgtheme_id) {
        UserDGTheme domain = userdgthemeService.get(userdgtheme_id);
        UserDGThemeDTO dto = userdgthemeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserDGTheme-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"UserDGTheme" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/userdgthemes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody UserDGThemeDTO userdgthemedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(userdgthemeService.checkKey(userdgthemeMapping.toDomain(userdgthemedto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserDGTheme-Save-all')")
    @ApiOperation(value = "Save", tags = {"UserDGTheme" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/userdgthemes/save")
    public ResponseEntity<Boolean> save(@RequestBody UserDGThemeDTO userdgthemedto) {
        return ResponseEntity.status(HttpStatus.OK).body(userdgthemeService.save(userdgthemeMapping.toDomain(userdgthemedto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"UserDGTheme" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/userdgthemes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<UserDGThemeDTO> userdgthemedtos) {
        userdgthemeService.saveBatch(userdgthemeMapping.toDomain(userdgthemedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.userdgthemeMapping,#userdgthemedto})")
    @ApiOperation(value = "Create", tags = {"UserDGTheme" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/userdgthemes")
    @Transactional
    public ResponseEntity<UserDGThemeDTO> create(@RequestBody UserDGThemeDTO userdgthemedto) {
        UserDGTheme domain = userdgthemeMapping.toDomain(userdgthemedto);
		userdgthemeService.create(domain);
        UserDGThemeDTO dto = userdgthemeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"UserDGTheme" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/userdgthemes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<UserDGThemeDTO> userdgthemedtos) {
        userdgthemeService.createBatch(userdgthemeMapping.toDomain(userdgthemedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#userdgtheme_id,'Update',{'Sql',this.userdgthemeMapping,#userdgthemedto})")
    @ApiOperation(value = "Update", tags = {"UserDGTheme" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/userdgthemes/{userdgtheme_id}")
    @Transactional
    public ResponseEntity<UserDGThemeDTO> update(@PathVariable("userdgtheme_id") String userdgtheme_id, @RequestBody UserDGThemeDTO userdgthemedto) {
		UserDGTheme domain = userdgthemeMapping.toDomain(userdgthemedto);
        domain.setUserdgthemeid(userdgtheme_id);
		userdgthemeService.update(domain);
		UserDGThemeDTO dto = userdgthemeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"UserDGTheme" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/userdgthemes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<UserDGThemeDTO> userdgthemedtos) {
        userdgthemeService.updateBatch(userdgthemeMapping.toDomain(userdgthemedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#userdgtheme_id,'Remove',{'Sql',this.userdgthemeMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"UserDGTheme" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/userdgthemes/{userdgtheme_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("userdgtheme_id") String userdgtheme_id) {
         return ResponseEntity.status(HttpStatus.OK).body(userdgthemeService.remove(userdgtheme_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"UserDGTheme" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/userdgthemes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        userdgthemeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserDGTheme-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"UserDGTheme" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/userdgthemes/fetchdefault")
	public ResponseEntity<List<UserDGThemeDTO>> fetchDefault(UserDGThemeSearchContext context) {
        Page<UserDGTheme> domains = userdgthemeService.searchDefault(context) ;
        List<UserDGThemeDTO> list = userdgthemeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-UserDGTheme-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"UserDGTheme" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/userdgthemes/searchdefault")
	public ResponseEntity<Page<UserDGThemeDTO>> searchDefault(@RequestBody UserDGThemeSearchContext context) {
        Page<UserDGTheme> domains = userdgthemeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(userdgthemeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
