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
import cn.ibizlab.ehr.core.att.domain.AttEndenceType;
import cn.ibizlab.ehr.core.att.service.IAttEndenceTypeService;
import cn.ibizlab.ehr.core.att.filter.AttEndenceTypeSearchContext;

@Slf4j
@Api(tags = {"AttEndenceType" })
@RestController("WebApi-attendencetype")
@RequestMapping("")
public class AttEndenceTypeResource {

    @Autowired
    public IAttEndenceTypeService attendencetypeService;

    @Autowired
    @Lazy
    public AttEndenceTypeMapping attendencetypeMapping;

    @PreAuthorize("hasPermission(this.attendencetypeMapping.toDomain(#attendencetypedto),'ehr-AttEndenceType-Save')")
    @ApiOperation(value = "Save", tags = {"AttEndenceType" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencetypes/save")
    public ResponseEntity<Boolean> save(@RequestBody AttEndenceTypeDTO attendencetypedto) {
        return ResponseEntity.status(HttpStatus.OK).body(attendencetypeService.save(attendencetypeMapping.toDomain(attendencetypedto)));
    }

    @PreAuthorize("hasPermission(this.attendencetypeMapping.toDomain(#attendencetypedtos),'ehr-AttEndenceType-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"AttEndenceType" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencetypes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<AttEndenceTypeDTO> attendencetypedtos) {
        attendencetypeService.saveBatch(attendencetypeMapping.toDomain(attendencetypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendencetypeMapping.toDomain(#attendencetypedto),'ehr-AttEndenceType-Create')")
    @ApiOperation(value = "Create", tags = {"AttEndenceType" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencetypes")
    @Transactional
    public ResponseEntity<AttEndenceTypeDTO> create(@RequestBody AttEndenceTypeDTO attendencetypedto) {
        AttEndenceType domain = attendencetypeMapping.toDomain(attendencetypedto);
		attendencetypeService.create(domain);
        AttEndenceTypeDTO dto = attendencetypeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendencetypeMapping.toDomain(#attendencetypedtos),'ehr-AttEndenceType-Create')")
    @ApiOperation(value = "createBatch", tags = {"AttEndenceType" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencetypes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<AttEndenceTypeDTO> attendencetypedtos) {
        attendencetypeService.createBatch(attendencetypeMapping.toDomain(attendencetypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"AttEndenceType" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencetypes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody AttEndenceTypeDTO attendencetypedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(attendencetypeService.checkKey(attendencetypeMapping.toDomain(attendencetypedto)));
    }

    @PreAuthorize("hasPermission(this.attendencetypeService.get(#attendencetype_id),'ehr-AttEndenceType-Remove')")
    @ApiOperation(value = "Remove", tags = {"AttEndenceType" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendencetypes/{attendencetype_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("attendencetype_id") String attendencetype_id) {
         return ResponseEntity.status(HttpStatus.OK).body(attendencetypeService.remove(attendencetype_id));
    }

    @PreAuthorize("hasPermission(this.attendencetypeService.getAttendencetypeByIds(#ids),'ehr-AttEndenceType-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"AttEndenceType" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendencetypes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        attendencetypeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.attendencetypeMapping.toDomain(returnObject.body),'ehr-AttEndenceType-Get')")
    @ApiOperation(value = "Get", tags = {"AttEndenceType" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/attendencetypes/{attendencetype_id}")
    public ResponseEntity<AttEndenceTypeDTO> get(@PathVariable("attendencetype_id") String attendencetype_id) {
        AttEndenceType domain = attendencetypeService.get(attendencetype_id);
        AttEndenceTypeDTO dto = attendencetypeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "GetDraft", tags = {"AttEndenceType" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/attendencetypes/getdraft")
    public ResponseEntity<AttEndenceTypeDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(attendencetypeMapping.toDto(attendencetypeService.getDraft(new AttEndenceType())));
    }

    @PreAuthorize("hasPermission(this.attendencetypeService.get(#attendencetype_id),'ehr-AttEndenceType-Update')")
    @ApiOperation(value = "Update", tags = {"AttEndenceType" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendencetypes/{attendencetype_id}")
    @Transactional
    public ResponseEntity<AttEndenceTypeDTO> update(@PathVariable("attendencetype_id") String attendencetype_id, @RequestBody AttEndenceTypeDTO attendencetypedto) {
		AttEndenceType domain  = attendencetypeMapping.toDomain(attendencetypedto);
        domain .setAttendencetypeid(attendencetype_id);
		attendencetypeService.update(domain );
		AttEndenceTypeDTO dto = attendencetypeMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendencetypeService.getAttendencetypeByEntities(this.attendencetypeMapping.toDomain(#attendencetypedtos)),'ehr-AttEndenceType-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"AttEndenceType" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendencetypes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<AttEndenceTypeDTO> attendencetypedtos) {
        attendencetypeService.updateBatch(attendencetypeMapping.toDomain(attendencetypedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndenceType-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"AttEndenceType" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/attendencetypes/fetchdefault")
	public ResponseEntity<List<AttEndenceTypeDTO>> fetchDefault(AttEndenceTypeSearchContext context) {
        Page<AttEndenceType> domains = attendencetypeService.searchDefault(context) ;
        List<AttEndenceTypeDTO> list = attendencetypeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndenceType-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"AttEndenceType" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/attendencetypes/searchdefault")
	public ResponseEntity<Page<AttEndenceTypeDTO>> searchDefault(@RequestBody AttEndenceTypeSearchContext context) {
        Page<AttEndenceType> domains = attendencetypeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendencetypeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

