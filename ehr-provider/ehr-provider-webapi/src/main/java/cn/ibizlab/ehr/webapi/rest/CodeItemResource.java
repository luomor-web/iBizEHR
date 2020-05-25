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
import cn.ibizlab.ehr.core.common.domain.CodeItem;
import cn.ibizlab.ehr.core.common.service.ICodeItemService;
import cn.ibizlab.ehr.core.common.filter.CodeItemSearchContext;

@Slf4j
@Api(tags = {"CodeItem" })
@RestController("WebApi-codeitem")
@RequestMapping("")
public class CodeItemResource {

    @Autowired
    private ICodeItemService codeitemService;

    @Autowired
    @Lazy
    public CodeItemMapping codeitemMapping;

    public CodeItemDTO permissionDTO=new CodeItemDTO();

    @PreAuthorize("hasPermission('','Save',{'Sql',this.codeitemMapping,#codeitemdto})")
    @ApiOperation(value = "Save", tags = {"CodeItem" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/codeitems/save")
    public ResponseEntity<Boolean> save(@RequestBody CodeItemDTO codeitemdto) {
        return ResponseEntity.status(HttpStatus.OK).body(codeitemService.save(codeitemMapping.toDomain(codeitemdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"CodeItem" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/codeitems/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<CodeItemDTO> codeitemdtos) {
        codeitemService.saveBatch(codeitemMapping.toDomain(codeitemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-CodeItem-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"CodeItem" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/codeitems/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody CodeItemDTO codeitemdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(codeitemService.checkKey(codeitemMapping.toDomain(codeitemdto)));
    }

    @PreAuthorize("hasPermission(#codeitem_id,'Remove',{'Sql',this.codeitemMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"CodeItem" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/codeitems/{codeitem_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("codeitem_id") String codeitem_id) {
         return ResponseEntity.status(HttpStatus.OK).body(codeitemService.remove(codeitem_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"CodeItem" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/codeitems/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        codeitemService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#codeitem_id,'Update',{'Sql',this.codeitemMapping,#codeitemdto})")
    @ApiOperation(value = "Update", tags = {"CodeItem" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/codeitems/{codeitem_id}")
    @Transactional
    public ResponseEntity<CodeItemDTO> update(@PathVariable("codeitem_id") String codeitem_id, @RequestBody CodeItemDTO codeitemdto) {
		CodeItem domain = codeitemMapping.toDomain(codeitemdto);
        domain.setCodeitemid(codeitem_id);
		codeitemService.update(domain);
		CodeItemDTO dto = codeitemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"CodeItem" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/codeitems/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<CodeItemDTO> codeitemdtos) {
        codeitemService.updateBatch(codeitemMapping.toDomain(codeitemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.codeitemMapping,#codeitemdto})")
    @ApiOperation(value = "Create", tags = {"CodeItem" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/codeitems")
    @Transactional
    public ResponseEntity<CodeItemDTO> create(@RequestBody CodeItemDTO codeitemdto) {
        CodeItem domain = codeitemMapping.toDomain(codeitemdto);
		codeitemService.create(domain);
        CodeItemDTO dto = codeitemMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"CodeItem" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/codeitems/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<CodeItemDTO> codeitemdtos) {
        codeitemService.createBatch(codeitemMapping.toDomain(codeitemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-CodeItem-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"CodeItem" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/codeitems/getdraft")
    public ResponseEntity<CodeItemDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(codeitemMapping.toDto(codeitemService.getDraft(new CodeItem())));
    }

    @PreAuthorize("hasPermission(#codeitem_id,'Get',{'Sql',this.codeitemMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"CodeItem" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/codeitems/{codeitem_id}")
    public ResponseEntity<CodeItemDTO> get(@PathVariable("codeitem_id") String codeitem_id) {
        CodeItem domain = codeitemService.get(codeitem_id);
        CodeItemDTO dto = codeitemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-CodeItem-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"CodeItem" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/codeitems/fetchdefault")
	public ResponseEntity<List<CodeItemDTO>> fetchDefault(CodeItemSearchContext context) {
        Page<CodeItem> domains = codeitemService.searchDefault(context) ;
        List<CodeItemDTO> list = codeitemMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-CodeItem-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"CodeItem" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/codeitems/searchdefault")
	public ResponseEntity<Page<CodeItemDTO>> searchDefault(@RequestBody CodeItemSearchContext context) {
        Page<CodeItem> domains = codeitemService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(codeitemMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-CodeItem-CurCL-all')")
	@ApiOperation(value = "fetch当前代码表", tags = {"CodeItem" } ,notes = "fetch当前代码表")
    @RequestMapping(method= RequestMethod.GET , value="/codeitems/fetchcurcl")
	public ResponseEntity<List<CodeItemDTO>> fetchCurCL(CodeItemSearchContext context) {
        Page<CodeItem> domains = codeitemService.searchCurCL(context) ;
        List<CodeItemDTO> list = codeitemMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-CodeItem-CurCL-all')")
	@ApiOperation(value = "search当前代码表", tags = {"CodeItem" } ,notes = "search当前代码表")
    @RequestMapping(method= RequestMethod.POST , value="/codeitems/searchcurcl")
	public ResponseEntity<Page<CodeItemDTO>> searchCurCL(@RequestBody CodeItemSearchContext context) {
        Page<CodeItem> domains = codeitemService.searchCurCL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(codeitemMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
