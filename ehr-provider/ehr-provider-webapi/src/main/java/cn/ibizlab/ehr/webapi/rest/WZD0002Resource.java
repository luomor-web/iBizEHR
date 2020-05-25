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
import cn.ibizlab.ehr.core.trm.domain.WZD0002;
import cn.ibizlab.ehr.core.trm.service.IWZD0002Service;
import cn.ibizlab.ehr.core.trm.filter.WZD0002SearchContext;

@Slf4j
@Api(tags = {"WZD0002" })
@RestController("WebApi-wzd0002")
@RequestMapping("")
public class WZD0002Resource {

    @Autowired
    private IWZD0002Service wzd0002Service;

    @Autowired
    @Lazy
    public WZD0002Mapping wzd0002Mapping;

    public WZD0002DTO permissionDTO=new WZD0002DTO();

    @PreAuthorize("hasPermission(#wzd0002_id,'Remove',{'Sql',this.wzd0002Mapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"WZD0002" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wzd0002s/{wzd0002_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("wzd0002_id") String wzd0002_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wzd0002Service.remove(wzd0002_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"WZD0002" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wzd0002s/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wzd0002Service.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.wzd0002Mapping,#wzd0002dto})")
    @ApiOperation(value = "Save", tags = {"WZD0002" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/wzd0002s/save")
    public ResponseEntity<Boolean> save(@RequestBody WZD0002DTO wzd0002dto) {
        return ResponseEntity.status(HttpStatus.OK).body(wzd0002Service.save(wzd0002Mapping.toDomain(wzd0002dto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"WZD0002" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wzd0002s/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WZD0002DTO> wzd0002dtos) {
        wzd0002Service.saveBatch(wzd0002Mapping.toDomain(wzd0002dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WZD0002-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"WZD0002" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/wzd0002s/getdraft")
    public ResponseEntity<WZD0002DTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wzd0002Mapping.toDto(wzd0002Service.getDraft(new WZD0002())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WZD0002-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"WZD0002" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/wzd0002s/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WZD0002DTO wzd0002dto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wzd0002Service.checkKey(wzd0002Mapping.toDomain(wzd0002dto)));
    }

    @PreAuthorize("hasPermission(#wzd0002_id,'Get',{'Sql',this.wzd0002Mapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"WZD0002" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/wzd0002s/{wzd0002_id}")
    public ResponseEntity<WZD0002DTO> get(@PathVariable("wzd0002_id") String wzd0002_id) {
        WZD0002 domain = wzd0002Service.get(wzd0002_id);
        WZD0002DTO dto = wzd0002Mapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.wzd0002Mapping,#wzd0002dto})")
    @ApiOperation(value = "Create", tags = {"WZD0002" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/wzd0002s")
    @Transactional
    public ResponseEntity<WZD0002DTO> create(@RequestBody WZD0002DTO wzd0002dto) {
        WZD0002 domain = wzd0002Mapping.toDomain(wzd0002dto);
		wzd0002Service.create(domain);
        WZD0002DTO dto = wzd0002Mapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"WZD0002" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/wzd0002s/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WZD0002DTO> wzd0002dtos) {
        wzd0002Service.createBatch(wzd0002Mapping.toDomain(wzd0002dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#wzd0002_id,'Update',{'Sql',this.wzd0002Mapping,#wzd0002dto})")
    @ApiOperation(value = "Update", tags = {"WZD0002" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/wzd0002s/{wzd0002_id}")
    @Transactional
    public ResponseEntity<WZD0002DTO> update(@PathVariable("wzd0002_id") String wzd0002_id, @RequestBody WZD0002DTO wzd0002dto) {
		WZD0002 domain = wzd0002Mapping.toDomain(wzd0002dto);
        domain.setWzd0002id(wzd0002_id);
		wzd0002Service.update(domain);
		WZD0002DTO dto = wzd0002Mapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"WZD0002" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/wzd0002s/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WZD0002DTO> wzd0002dtos) {
        wzd0002Service.updateBatch(wzd0002Mapping.toDomain(wzd0002dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WZD0002-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"WZD0002" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wzd0002s/fetchdefault")
	public ResponseEntity<List<WZD0002DTO>> fetchDefault(WZD0002SearchContext context) {
        Page<WZD0002> domains = wzd0002Service.searchDefault(context) ;
        List<WZD0002DTO> list = wzd0002Mapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WZD0002-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"WZD0002" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/wzd0002s/searchdefault")
	public ResponseEntity<Page<WZD0002DTO>> searchDefault(@RequestBody WZD0002SearchContext context) {
        Page<WZD0002> domains = wzd0002Service.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wzd0002Mapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
