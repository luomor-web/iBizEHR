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
import cn.ibizlab.ehr.core.common.domain.PortalPage;
import cn.ibizlab.ehr.core.common.service.IPortalPageService;
import cn.ibizlab.ehr.core.common.filter.PortalPageSearchContext;




@Slf4j
@Api(tags = {"PortalPage" })
@RestController("WebApi-portalpage")
@RequestMapping("")
public class PortalPageResource {

    @Autowired
    private IPortalPageService portalpageService;

    @Autowired
    @Lazy
    public PortalPageMapping portalpageMapping;

    public PortalPageDTO permissionDTO=new PortalPageDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PortalPage-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PortalPage" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/portalpages/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PortalPageDTO portalpagedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(portalpageService.checkKey(portalpageMapping.toDomain(portalpagedto)));
    }

    @PreAuthorize("hasPermission(#portalpage_id,'Get',{'Sql',this.portalpageMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PortalPage" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/portalpages/{portalpage_id}")
    public ResponseEntity<PortalPageDTO> get(@PathVariable("portalpage_id") String portalpage_id) {
        PortalPage domain = portalpageService.get(portalpage_id);
        PortalPageDTO dto = portalpageMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#portalpage_id,'Remove',{'Sql',this.portalpageMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PortalPage" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/portalpages/{portalpage_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("portalpage_id") String portalpage_id) {
         return ResponseEntity.status(HttpStatus.OK).body(portalpageService.remove(portalpage_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PortalPage" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/portalpages/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        portalpageService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#portalpage_id,'Update',{'Sql',this.portalpageMapping,#portalpagedto})")
    @ApiOperation(value = "Update", tags = {"PortalPage" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/portalpages/{portalpage_id}")
    @Transactional
    public ResponseEntity<PortalPageDTO> update(@PathVariable("portalpage_id") String portalpage_id, @RequestBody PortalPageDTO portalpagedto) {
		PortalPage domain = portalpageMapping.toDomain(portalpagedto);
        domain.setPortalpageid(portalpage_id);
		portalpageService.update(domain);
		PortalPageDTO dto = portalpageMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PortalPage" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/portalpages/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PortalPageDTO> portalpagedtos) {
        portalpageService.updateBatch(portalpageMapping.toDomain(portalpagedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.portalpageMapping,#portalpagedto})")
    @ApiOperation(value = "Create", tags = {"PortalPage" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/portalpages")
    @Transactional
    public ResponseEntity<PortalPageDTO> create(@RequestBody PortalPageDTO portalpagedto) {
        PortalPage domain = portalpageMapping.toDomain(portalpagedto);
		portalpageService.create(domain);
        PortalPageDTO dto = portalpageMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"PortalPage" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/portalpages/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PortalPageDTO> portalpagedtos) {
        portalpageService.createBatch(portalpageMapping.toDomain(portalpagedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PortalPage-Save-all')")
    @ApiOperation(value = "Save", tags = {"PortalPage" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/portalpages/save")
    public ResponseEntity<Boolean> save(@RequestBody PortalPageDTO portalpagedto) {
        return ResponseEntity.status(HttpStatus.OK).body(portalpageService.save(portalpageMapping.toDomain(portalpagedto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PortalPage" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/portalpages/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PortalPageDTO> portalpagedtos) {
        portalpageService.saveBatch(portalpageMapping.toDomain(portalpagedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PortalPage-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PortalPage" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/portalpages/getdraft")
    public ResponseEntity<PortalPageDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(portalpageMapping.toDto(portalpageService.getDraft(new PortalPage())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PortalPage-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PortalPage" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/portalpages/fetchdefault")
	public ResponseEntity<List<PortalPageDTO>> fetchDefault(PortalPageSearchContext context) {
        Page<PortalPage> domains = portalpageService.searchDefault(context) ;
        List<PortalPageDTO> list = portalpageMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PortalPage-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PortalPage" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/portalpages/searchdefault")
	public ResponseEntity<Page<PortalPageDTO>> searchDefault(@RequestBody PortalPageSearchContext context) {
        Page<PortalPage> domains = portalpageService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(portalpageMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
