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
import cn.ibizlab.ehr.core.att.domain.AttEndanceRecordTemp;
import cn.ibizlab.ehr.core.att.service.IAttEndanceRecordTempService;
import cn.ibizlab.ehr.core.att.filter.AttEndanceRecordTempSearchContext;

@Slf4j
@Api(tags = {"AttEndanceRecordTemp" })
@RestController("WebApi-attendancerecordtemp")
@RequestMapping("")
public class AttEndanceRecordTempResource {

    @Autowired
    public IAttEndanceRecordTempService attendancerecordtempService;

    @Autowired
    @Lazy
    public AttEndanceRecordTempMapping attendancerecordtempMapping;

    @PreAuthorize("hasPermission(this.attendancerecordtempService.get(#attendancerecordtemp_id),'ehr-AttEndanceRecordTemp-Update')")
    @ApiOperation(value = "Update", tags = {"AttEndanceRecordTemp" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendancerecordtemps/{attendancerecordtemp_id}")
    @Transactional
    public ResponseEntity<AttEndanceRecordTempDTO> update(@PathVariable("attendancerecordtemp_id") String attendancerecordtemp_id, @RequestBody AttEndanceRecordTempDTO attendancerecordtempdto) {
		AttEndanceRecordTemp domain  = attendancerecordtempMapping.toDomain(attendancerecordtempdto);
        domain .setAttendancerecordtempid(attendancerecordtemp_id);
		attendancerecordtempService.update(domain );
		AttEndanceRecordTempDTO dto = attendancerecordtempMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancerecordtempService.getAttendancerecordtempByEntities(this.attendancerecordtempMapping.toDomain(#attendancerecordtempdtos)),'ehr-AttEndanceRecordTemp-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"AttEndanceRecordTemp" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendancerecordtemps/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<AttEndanceRecordTempDTO> attendancerecordtempdtos) {
        attendancerecordtempService.updateBatch(attendancerecordtempMapping.toDomain(attendancerecordtempdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendancerecordtempService.get(#attendancerecordtemp_id),'ehr-AttEndanceRecordTemp-Remove')")
    @ApiOperation(value = "Remove", tags = {"AttEndanceRecordTemp" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendancerecordtemps/{attendancerecordtemp_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("attendancerecordtemp_id") String attendancerecordtemp_id) {
         return ResponseEntity.status(HttpStatus.OK).body(attendancerecordtempService.remove(attendancerecordtemp_id));
    }

    @PreAuthorize("hasPermission(this.attendancerecordtempService.getAttendancerecordtempByIds(#ids),'ehr-AttEndanceRecordTemp-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"AttEndanceRecordTemp" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendancerecordtemps/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        attendancerecordtempService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendancerecordtempMapping.toDomain(#attendancerecordtempdto),'ehr-AttEndanceRecordTemp-Save')")
    @ApiOperation(value = "Save", tags = {"AttEndanceRecordTemp" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancerecordtemps/save")
    public ResponseEntity<Boolean> save(@RequestBody AttEndanceRecordTempDTO attendancerecordtempdto) {
        return ResponseEntity.status(HttpStatus.OK).body(attendancerecordtempService.save(attendancerecordtempMapping.toDomain(attendancerecordtempdto)));
    }

    @PreAuthorize("hasPermission(this.attendancerecordtempMapping.toDomain(#attendancerecordtempdtos),'ehr-AttEndanceRecordTemp-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"AttEndanceRecordTemp" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancerecordtemps/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<AttEndanceRecordTempDTO> attendancerecordtempdtos) {
        attendancerecordtempService.saveBatch(attendancerecordtempMapping.toDomain(attendancerecordtempdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"AttEndanceRecordTemp" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/attendancerecordtemps/getdraft")
    public ResponseEntity<AttEndanceRecordTempDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(attendancerecordtempMapping.toDto(attendancerecordtempService.getDraft(new AttEndanceRecordTemp())));
    }

    @PostAuthorize("hasPermission(this.attendancerecordtempMapping.toDomain(returnObject.body),'ehr-AttEndanceRecordTemp-Get')")
    @ApiOperation(value = "Get", tags = {"AttEndanceRecordTemp" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/attendancerecordtemps/{attendancerecordtemp_id}")
    public ResponseEntity<AttEndanceRecordTempDTO> get(@PathVariable("attendancerecordtemp_id") String attendancerecordtemp_id) {
        AttEndanceRecordTemp domain = attendancerecordtempService.get(attendancerecordtemp_id);
        AttEndanceRecordTempDTO dto = attendancerecordtempMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancerecordtempMapping.toDomain(#attendancerecordtempdto),'ehr-AttEndanceRecordTemp-Create')")
    @ApiOperation(value = "Create", tags = {"AttEndanceRecordTemp" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancerecordtemps")
    @Transactional
    public ResponseEntity<AttEndanceRecordTempDTO> create(@RequestBody AttEndanceRecordTempDTO attendancerecordtempdto) {
        AttEndanceRecordTemp domain = attendancerecordtempMapping.toDomain(attendancerecordtempdto);
		attendancerecordtempService.create(domain);
        AttEndanceRecordTempDTO dto = attendancerecordtempMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancerecordtempMapping.toDomain(#attendancerecordtempdtos),'ehr-AttEndanceRecordTemp-Create')")
    @ApiOperation(value = "createBatch", tags = {"AttEndanceRecordTemp" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancerecordtemps/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<AttEndanceRecordTempDTO> attendancerecordtempdtos) {
        attendancerecordtempService.createBatch(attendancerecordtempMapping.toDomain(attendancerecordtempdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"AttEndanceRecordTemp" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancerecordtemps/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody AttEndanceRecordTempDTO attendancerecordtempdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(attendancerecordtempService.checkKey(attendancerecordtempMapping.toDomain(attendancerecordtempdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceRecordTemp-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"AttEndanceRecordTemp" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/attendancerecordtemps/fetchdefault")
	public ResponseEntity<List<AttEndanceRecordTempDTO>> fetchDefault(AttEndanceRecordTempSearchContext context) {
        Page<AttEndanceRecordTemp> domains = attendancerecordtempService.searchDefault(context) ;
        List<AttEndanceRecordTempDTO> list = attendancerecordtempMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceRecordTemp-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"AttEndanceRecordTemp" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/attendancerecordtemps/searchdefault")
	public ResponseEntity<Page<AttEndanceRecordTempDTO>> searchDefault(@RequestBody AttEndanceRecordTempSearchContext context) {
        Page<AttEndanceRecordTemp> domains = attendancerecordtempService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancerecordtempMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

