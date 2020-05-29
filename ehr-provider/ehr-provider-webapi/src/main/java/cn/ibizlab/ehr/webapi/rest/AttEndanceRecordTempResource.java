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
@Api(tags = {"考勤记录(中间表)" })
@RestController("WebApi-attendancerecordtemp")
@RequestMapping("")
public class AttEndanceRecordTempResource {

    @Autowired
    public IAttEndanceRecordTempService attendancerecordtempService;

    @Autowired
    @Lazy
    public AttEndanceRecordTempMapping attendancerecordtempMapping;

    @PreAuthorize("hasPermission(this.attendancerecordtempService.get(#attendancerecordtemp_id),'ehr-AttEndanceRecordTemp-Update')")
    @ApiOperation(value = "更新考勤记录(中间表)", tags = {"考勤记录(中间表)" },  notes = "更新考勤记录(中间表)")
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
    @ApiOperation(value = "批量更新考勤记录(中间表)", tags = {"考勤记录(中间表)" },  notes = "批量更新考勤记录(中间表)")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendancerecordtemps/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<AttEndanceRecordTempDTO> attendancerecordtempdtos) {
        attendancerecordtempService.updateBatch(attendancerecordtempMapping.toDomain(attendancerecordtempdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendancerecordtempService.get(#attendancerecordtemp_id),'ehr-AttEndanceRecordTemp-Remove')")
    @ApiOperation(value = "删除考勤记录(中间表)", tags = {"考勤记录(中间表)" },  notes = "删除考勤记录(中间表)")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendancerecordtemps/{attendancerecordtemp_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("attendancerecordtemp_id") String attendancerecordtemp_id) {
         return ResponseEntity.status(HttpStatus.OK).body(attendancerecordtempService.remove(attendancerecordtemp_id));
    }

    @PreAuthorize("hasPermission(this.attendancerecordtempService.getAttendancerecordtempByIds(#ids),'ehr-AttEndanceRecordTemp-Remove')")
    @ApiOperation(value = "批量删除考勤记录(中间表)", tags = {"考勤记录(中间表)" },  notes = "批量删除考勤记录(中间表)")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendancerecordtemps/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        attendancerecordtempService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendancerecordtempMapping.toDomain(#attendancerecordtempdto),'ehr-AttEndanceRecordTemp-Save')")
    @ApiOperation(value = "保存考勤记录(中间表)", tags = {"考勤记录(中间表)" },  notes = "保存考勤记录(中间表)")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancerecordtemps/save")
    public ResponseEntity<Boolean> save(@RequestBody AttEndanceRecordTempDTO attendancerecordtempdto) {
        return ResponseEntity.status(HttpStatus.OK).body(attendancerecordtempService.save(attendancerecordtempMapping.toDomain(attendancerecordtempdto)));
    }

    @PreAuthorize("hasPermission(this.attendancerecordtempMapping.toDomain(#attendancerecordtempdtos),'ehr-AttEndanceRecordTemp-Save')")
    @ApiOperation(value = "批量保存考勤记录(中间表)", tags = {"考勤记录(中间表)" },  notes = "批量保存考勤记录(中间表)")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancerecordtemps/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<AttEndanceRecordTempDTO> attendancerecordtempdtos) {
        attendancerecordtempService.saveBatch(attendancerecordtempMapping.toDomain(attendancerecordtempdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取考勤记录(中间表)草稿", tags = {"考勤记录(中间表)" },  notes = "获取考勤记录(中间表)草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/attendancerecordtemps/getdraft")
    public ResponseEntity<AttEndanceRecordTempDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(attendancerecordtempMapping.toDto(attendancerecordtempService.getDraft(new AttEndanceRecordTemp())));
    }

    @PostAuthorize("hasPermission(this.attendancerecordtempMapping.toDomain(returnObject.body),'ehr-AttEndanceRecordTemp-Get')")
    @ApiOperation(value = "获取考勤记录(中间表)", tags = {"考勤记录(中间表)" },  notes = "获取考勤记录(中间表)")
	@RequestMapping(method = RequestMethod.GET, value = "/attendancerecordtemps/{attendancerecordtemp_id}")
    public ResponseEntity<AttEndanceRecordTempDTO> get(@PathVariable("attendancerecordtemp_id") String attendancerecordtemp_id) {
        AttEndanceRecordTemp domain = attendancerecordtempService.get(attendancerecordtemp_id);
        AttEndanceRecordTempDTO dto = attendancerecordtempMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancerecordtempMapping.toDomain(#attendancerecordtempdto),'ehr-AttEndanceRecordTemp-Create')")
    @ApiOperation(value = "新建考勤记录(中间表)", tags = {"考勤记录(中间表)" },  notes = "新建考勤记录(中间表)")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancerecordtemps")
    @Transactional
    public ResponseEntity<AttEndanceRecordTempDTO> create(@RequestBody AttEndanceRecordTempDTO attendancerecordtempdto) {
        AttEndanceRecordTemp domain = attendancerecordtempMapping.toDomain(attendancerecordtempdto);
		attendancerecordtempService.create(domain);
        AttEndanceRecordTempDTO dto = attendancerecordtempMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancerecordtempMapping.toDomain(#attendancerecordtempdtos),'ehr-AttEndanceRecordTemp-Create')")
    @ApiOperation(value = "批量新建考勤记录(中间表)", tags = {"考勤记录(中间表)" },  notes = "批量新建考勤记录(中间表)")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancerecordtemps/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<AttEndanceRecordTempDTO> attendancerecordtempdtos) {
        attendancerecordtempService.createBatch(attendancerecordtempMapping.toDomain(attendancerecordtempdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查考勤记录(中间表)", tags = {"考勤记录(中间表)" },  notes = "检查考勤记录(中间表)")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancerecordtemps/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody AttEndanceRecordTempDTO attendancerecordtempdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(attendancerecordtempService.checkKey(attendancerecordtempMapping.toDomain(attendancerecordtempdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceRecordTemp-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"考勤记录(中间表)" } ,notes = "获取DEFAULT")
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
	@ApiOperation(value = "查询DEFAULT", tags = {"考勤记录(中间表)" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/attendancerecordtemps/searchdefault")
	public ResponseEntity<Page<AttEndanceRecordTempDTO>> searchDefault(@RequestBody AttEndanceRecordTempSearchContext context) {
        Page<AttEndanceRecordTemp> domains = attendancerecordtempService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancerecordtempMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

