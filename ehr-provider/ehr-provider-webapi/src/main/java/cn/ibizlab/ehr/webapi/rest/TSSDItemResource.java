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
import cn.ibizlab.ehr.core.common.domain.TSSDItem;
import cn.ibizlab.ehr.core.common.service.ITSSDItemService;
import cn.ibizlab.ehr.core.common.filter.TSSDItemSearchContext;




@Slf4j
@Api(tags = {"TSSDItem" })
@RestController("WebApi-tssditem")
@RequestMapping("")
public class TSSDItemResource {

    @Autowired
    private ITSSDItemService tssditemService;

    @Autowired
    @Lazy
    public TSSDItemMapping tssditemMapping;

    public TSSDItemDTO permissionDTO=new TSSDItemDTO();

    @PreAuthorize("hasPermission('','Create',{'Sql',this.tssditemMapping,#tssditemdto})")
    @ApiOperation(value = "Create", tags = {"TSSDItem" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/tssditems")
    @Transactional
    public ResponseEntity<TSSDItemDTO> create(@RequestBody TSSDItemDTO tssditemdto) {
        TSSDItem domain = tssditemMapping.toDomain(tssditemdto);
		tssditemService.create(domain);
        TSSDItemDTO dto = tssditemMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"TSSDItem" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/tssditems/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TSSDItemDTO> tssditemdtos) {
        tssditemService.createBatch(tssditemMapping.toDomain(tssditemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#tssditem_id,'Remove',{'Sql',this.tssditemMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"TSSDItem" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/tssditems/{tssditem_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("tssditem_id") String tssditem_id) {
         return ResponseEntity.status(HttpStatus.OK).body(tssditemService.remove(tssditem_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"TSSDItem" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/tssditems/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        tssditemService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TSSDItem-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"TSSDItem" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/tssditems/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TSSDItemDTO tssditemdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(tssditemService.checkKey(tssditemMapping.toDomain(tssditemdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TSSDItem-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"TSSDItem" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/tssditems/getdraft")
    public ResponseEntity<TSSDItemDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(tssditemMapping.toDto(tssditemService.getDraft(new TSSDItem())));
    }

    @PreAuthorize("hasPermission(#tssditem_id,'Get',{'Sql',this.tssditemMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"TSSDItem" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/tssditems/{tssditem_id}")
    public ResponseEntity<TSSDItemDTO> get(@PathVariable("tssditem_id") String tssditem_id) {
        TSSDItem domain = tssditemService.get(tssditem_id);
        TSSDItemDTO dto = tssditemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#tssditem_id,'Update',{'Sql',this.tssditemMapping,#tssditemdto})")
    @ApiOperation(value = "Update", tags = {"TSSDItem" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/tssditems/{tssditem_id}")
    @Transactional
    public ResponseEntity<TSSDItemDTO> update(@PathVariable("tssditem_id") String tssditem_id, @RequestBody TSSDItemDTO tssditemdto) {
		TSSDItem domain = tssditemMapping.toDomain(tssditemdto);
        domain.setTssditemid(tssditem_id);
		tssditemService.update(domain);
		TSSDItemDTO dto = tssditemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"TSSDItem" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/tssditems/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TSSDItemDTO> tssditemdtos) {
        tssditemService.updateBatch(tssditemMapping.toDomain(tssditemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TSSDItem-Save-all')")
    @ApiOperation(value = "Save", tags = {"TSSDItem" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/tssditems/save")
    public ResponseEntity<Boolean> save(@RequestBody TSSDItemDTO tssditemdto) {
        return ResponseEntity.status(HttpStatus.OK).body(tssditemService.save(tssditemMapping.toDomain(tssditemdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"TSSDItem" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/tssditems/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TSSDItemDTO> tssditemdtos) {
        tssditemService.saveBatch(tssditemMapping.toDomain(tssditemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TSSDItem-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"TSSDItem" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/tssditems/fetchdefault")
	public ResponseEntity<List<TSSDItemDTO>> fetchDefault(TSSDItemSearchContext context) {
        Page<TSSDItem> domains = tssditemService.searchDefault(context) ;
        List<TSSDItemDTO> list = tssditemMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TSSDItem-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"TSSDItem" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/tssditems/searchdefault")
	public ResponseEntity<Page<TSSDItemDTO>> searchDefault(@RequestBody TSSDItemSearchContext context) {
        Page<TSSDItem> domains = tssditemService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(tssditemMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
