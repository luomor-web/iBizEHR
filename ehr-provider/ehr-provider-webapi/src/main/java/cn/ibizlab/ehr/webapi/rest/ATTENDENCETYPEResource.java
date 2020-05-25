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
import cn.ibizlab.ehr.core.att.domain.ATTENDENCETYPE;
import cn.ibizlab.ehr.core.att.service.IATTENDENCETYPEService;
import cn.ibizlab.ehr.core.att.filter.ATTENDENCETYPESearchContext;

@Slf4j
@Api(tags = {"ATTENDENCETYPE" })
@RestController("WebApi-attendencetype")
@RequestMapping("")
public class ATTENDENCETYPEResource {

    @Autowired
    private IATTENDENCETYPEService attendencetypeService;

    @Autowired
    @Lazy
    public ATTENDENCETYPEMapping attendencetypeMapping;

    public ATTENDENCETYPEDTO permissionDTO=new ATTENDENCETYPEDTO();

    @PreAuthorize("hasPermission('','Save',{'Sql',this.attendencetypeMapping,#attendencetypedto})")
    @ApiOperation(value = "Save", tags = {"ATTENDENCETYPE" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencetypes/save")
    public ResponseEntity<Boolean> save(@RequestBody ATTENDENCETYPEDTO attendencetypedto) {
        return ResponseEntity.status(HttpStatus.OK).body(attendencetypeService.save(attendencetypeMapping.toDomain(attendencetypedto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"ATTENDENCETYPE" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencetypes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ATTENDENCETYPEDTO> attendencetypedtos) {
        attendencetypeService.saveBatch(attendencetypeMapping.toDomain(attendencetypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.attendencetypeMapping,#attendencetypedto})")
    @ApiOperation(value = "Create", tags = {"ATTENDENCETYPE" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencetypes")
    @Transactional
    public ResponseEntity<ATTENDENCETYPEDTO> create(@RequestBody ATTENDENCETYPEDTO attendencetypedto) {
        ATTENDENCETYPE domain = attendencetypeMapping.toDomain(attendencetypedto);
		attendencetypeService.create(domain);
        ATTENDENCETYPEDTO dto = attendencetypeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"ATTENDENCETYPE" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencetypes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ATTENDENCETYPEDTO> attendencetypedtos) {
        attendencetypeService.createBatch(attendencetypeMapping.toDomain(attendencetypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDENCETYPE-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"ATTENDENCETYPE" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencetypes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ATTENDENCETYPEDTO attendencetypedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(attendencetypeService.checkKey(attendencetypeMapping.toDomain(attendencetypedto)));
    }

    @PreAuthorize("hasPermission(#attendencetype_id,'Remove',{'Sql',this.attendencetypeMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"ATTENDENCETYPE" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendencetypes/{attendencetype_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("attendencetype_id") String attendencetype_id) {
         return ResponseEntity.status(HttpStatus.OK).body(attendencetypeService.remove(attendencetype_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"ATTENDENCETYPE" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendencetypes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        attendencetypeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#attendencetype_id,'Get',{'Sql',this.attendencetypeMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"ATTENDENCETYPE" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/attendencetypes/{attendencetype_id}")
    public ResponseEntity<ATTENDENCETYPEDTO> get(@PathVariable("attendencetype_id") String attendencetype_id) {
        ATTENDENCETYPE domain = attendencetypeService.get(attendencetype_id);
        ATTENDENCETYPEDTO dto = attendencetypeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDENCETYPE-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"ATTENDENCETYPE" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/attendencetypes/getdraft")
    public ResponseEntity<ATTENDENCETYPEDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(attendencetypeMapping.toDto(attendencetypeService.getDraft(new ATTENDENCETYPE())));
    }

    @PreAuthorize("hasPermission(#attendencetype_id,'Update',{'Sql',this.attendencetypeMapping,#attendencetypedto})")
    @ApiOperation(value = "Update", tags = {"ATTENDENCETYPE" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendencetypes/{attendencetype_id}")
    @Transactional
    public ResponseEntity<ATTENDENCETYPEDTO> update(@PathVariable("attendencetype_id") String attendencetype_id, @RequestBody ATTENDENCETYPEDTO attendencetypedto) {
		ATTENDENCETYPE domain = attendencetypeMapping.toDomain(attendencetypedto);
        domain.setAttendencetypeid(attendencetype_id);
		attendencetypeService.update(domain);
		ATTENDENCETYPEDTO dto = attendencetypeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"ATTENDENCETYPE" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendencetypes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ATTENDENCETYPEDTO> attendencetypedtos) {
        attendencetypeService.updateBatch(attendencetypeMapping.toDomain(attendencetypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDENCETYPE-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ATTENDENCETYPE" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/attendencetypes/fetchdefault")
	public ResponseEntity<List<ATTENDENCETYPEDTO>> fetchDefault(ATTENDENCETYPESearchContext context) {
        Page<ATTENDENCETYPE> domains = attendencetypeService.searchDefault(context) ;
        List<ATTENDENCETYPEDTO> list = attendencetypeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDENCETYPE-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ATTENDENCETYPE" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/attendencetypes/searchdefault")
	public ResponseEntity<Page<ATTENDENCETYPEDTO>> searchDefault(@RequestBody ATTENDENCETYPESearchContext context) {
        Page<ATTENDENCETYPE> domains = attendencetypeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendencetypeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
