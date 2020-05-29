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
import org.springframework.security.access.prepost.PostAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import cn.ibizlab.ehr.webapi.dto.*;
import cn.ibizlab.ehr.webapi.mapping.*;
import cn.ibizlab.ehr.core.sal.domain.SalItem;
import cn.ibizlab.ehr.core.sal.service.ISalItemService;
import cn.ibizlab.ehr.core.sal.filter.SalItemSearchContext;

@Slf4j
@Api(tags = {"SalItem" })
@RestController("WebApi-salitem")
@RequestMapping("")
public class SalItemResource {

    @Autowired
    public ISalItemService salitemService;

    @Autowired
    @Lazy
    public SalItemMapping salitemMapping;

    @PostAuthorize("hasPermission(this.salitemMapping.toDomain(returnObject.body),'ehr-SalItem-Get')")
    @ApiOperation(value = "Get", tags = {"SalItem" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/salitems/{salitem_id}")
    public ResponseEntity<SalItemDTO> get(@PathVariable("salitem_id") String salitem_id) {
        SalItem domain = salitemService.get(salitem_id);
        SalItemDTO dto = salitemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salitemService.get(#salitem_id),'ehr-SalItem-Remove')")
    @ApiOperation(value = "Remove", tags = {"SalItem" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salitems/{salitem_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salitem_id") String salitem_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salitemService.remove(salitem_id));
    }

    @PreAuthorize("hasPermission(this.salitemService.getSalitemByIds(#ids),'ehr-SalItem-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"SalItem" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salitems/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salitemService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salitemMapping.toDomain(#salitemdto),'ehr-SalItem-Save')")
    @ApiOperation(value = "Save", tags = {"SalItem" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/salitems/save")
    public ResponseEntity<Boolean> save(@RequestBody SalItemDTO salitemdto) {
        return ResponseEntity.status(HttpStatus.OK).body(salitemService.save(salitemMapping.toDomain(salitemdto)));
    }

    @PreAuthorize("hasPermission(this.salitemMapping.toDomain(#salitemdtos),'ehr-SalItem-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"SalItem" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salitems/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SalItemDTO> salitemdtos) {
        salitemService.saveBatch(salitemMapping.toDomain(salitemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"SalItem" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/salitems/getdraft")
    public ResponseEntity<SalItemDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salitemMapping.toDto(salitemService.getDraft(new SalItem())));
    }

    @ApiOperation(value = "CheckKey", tags = {"SalItem" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/salitems/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SalItemDTO salitemdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salitemService.checkKey(salitemMapping.toDomain(salitemdto)));
    }

    @PreAuthorize("hasPermission(this.salitemService.get(#salitem_id),'ehr-SalItem-Update')")
    @ApiOperation(value = "Update", tags = {"SalItem" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/salitems/{salitem_id}")
    @Transactional
    public ResponseEntity<SalItemDTO> update(@PathVariable("salitem_id") String salitem_id, @RequestBody SalItemDTO salitemdto) {
		SalItem domain  = salitemMapping.toDomain(salitemdto);
        domain .setSalitemid(salitem_id);
		salitemService.update(domain );
		SalItemDTO dto = salitemMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salitemService.getSalitemByEntities(this.salitemMapping.toDomain(#salitemdtos)),'ehr-SalItem-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"SalItem" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/salitems/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SalItemDTO> salitemdtos) {
        salitemService.updateBatch(salitemMapping.toDomain(salitemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salitemMapping.toDomain(#salitemdto),'ehr-SalItem-Create')")
    @ApiOperation(value = "Create", tags = {"SalItem" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/salitems")
    @Transactional
    public ResponseEntity<SalItemDTO> create(@RequestBody SalItemDTO salitemdto) {
        SalItem domain = salitemMapping.toDomain(salitemdto);
		salitemService.create(domain);
        SalItemDTO dto = salitemMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salitemMapping.toDomain(#salitemdtos),'ehr-SalItem-Create')")
    @ApiOperation(value = "createBatch", tags = {"SalItem" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/salitems/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SalItemDTO> salitemdtos) {
        salitemService.createBatch(salitemMapping.toDomain(salitemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalItem-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"SalItem" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salitems/fetchdefault")
	public ResponseEntity<List<SalItemDTO>> fetchDefault(SalItemSearchContext context) {
        Page<SalItem> domains = salitemService.searchDefault(context) ;
        List<SalItemDTO> list = salitemMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalItem-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"SalItem" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salitems/searchdefault")
	public ResponseEntity<Page<SalItemDTO>> searchDefault(@RequestBody SalItemSearchContext context) {
        Page<SalItem> domains = salitemService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salitemMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

