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
import cn.ibizlab.ehr.core.att.domain.AttendRecordDetail;
import cn.ibizlab.ehr.core.att.service.IAttendRecordDetailService;
import cn.ibizlab.ehr.core.att.filter.AttendRecordDetailSearchContext;

@Slf4j
@Api(tags = {"考勤记录明细" })
@RestController("WebApi-attendrecorddetail")
@RequestMapping("")
public class AttendRecordDetailResource {

    @Autowired
    public IAttendRecordDetailService attendrecorddetailService;

    @Autowired
    @Lazy
    public AttendRecordDetailMapping attendrecorddetailMapping;

    @PreAuthorize("hasPermission(this.attendrecorddetailMapping.toDomain(#attendrecorddetaildto),'ehr-AttendRecordDetail-Create')")
    @ApiOperation(value = "新建考勤记录明细", tags = {"考勤记录明细" },  notes = "新建考勤记录明细")
	@RequestMapping(method = RequestMethod.POST, value = "/attendrecorddetails")
    @Transactional
    public ResponseEntity<AttendRecordDetailDTO> create(@RequestBody AttendRecordDetailDTO attendrecorddetaildto) {
        AttendRecordDetail domain = attendrecorddetailMapping.toDomain(attendrecorddetaildto);
		attendrecorddetailService.create(domain);
        AttendRecordDetailDTO dto = attendrecorddetailMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendrecorddetailMapping.toDomain(#attendrecorddetaildtos),'ehr-AttendRecordDetail-Create')")
    @ApiOperation(value = "批量新建考勤记录明细", tags = {"考勤记录明细" },  notes = "批量新建考勤记录明细")
	@RequestMapping(method = RequestMethod.POST, value = "/attendrecorddetails/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<AttendRecordDetailDTO> attendrecorddetaildtos) {
        attendrecorddetailService.createBatch(attendrecorddetailMapping.toDomain(attendrecorddetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取考勤记录明细草稿", tags = {"考勤记录明细" },  notes = "获取考勤记录明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/attendrecorddetails/getdraft")
    public ResponseEntity<AttendRecordDetailDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(attendrecorddetailMapping.toDto(attendrecorddetailService.getDraft(new AttendRecordDetail())));
    }

    @PostAuthorize("hasPermission(this.attendrecorddetailMapping.toDomain(returnObject.body),'ehr-AttendRecordDetail-Get')")
    @ApiOperation(value = "获取考勤记录明细", tags = {"考勤记录明细" },  notes = "获取考勤记录明细")
	@RequestMapping(method = RequestMethod.GET, value = "/attendrecorddetails/{attendrecorddetail_id}")
    public ResponseEntity<AttendRecordDetailDTO> get(@PathVariable("attendrecorddetail_id") String attendrecorddetail_id) {
        AttendRecordDetail domain = attendrecorddetailService.get(attendrecorddetail_id);
        AttendRecordDetailDTO dto = attendrecorddetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "检查考勤记录明细", tags = {"考勤记录明细" },  notes = "检查考勤记录明细")
	@RequestMapping(method = RequestMethod.POST, value = "/attendrecorddetails/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody AttendRecordDetailDTO attendrecorddetaildto) {
        return  ResponseEntity.status(HttpStatus.OK).body(attendrecorddetailService.checkKey(attendrecorddetailMapping.toDomain(attendrecorddetaildto)));
    }

    @PreAuthorize("hasPermission(this.attendrecorddetailMapping.toDomain(#attendrecorddetaildto),'ehr-AttendRecordDetail-Save')")
    @ApiOperation(value = "保存考勤记录明细", tags = {"考勤记录明细" },  notes = "保存考勤记录明细")
	@RequestMapping(method = RequestMethod.POST, value = "/attendrecorddetails/save")
    public ResponseEntity<Boolean> save(@RequestBody AttendRecordDetailDTO attendrecorddetaildto) {
        return ResponseEntity.status(HttpStatus.OK).body(attendrecorddetailService.save(attendrecorddetailMapping.toDomain(attendrecorddetaildto)));
    }

    @PreAuthorize("hasPermission(this.attendrecorddetailMapping.toDomain(#attendrecorddetaildtos),'ehr-AttendRecordDetail-Save')")
    @ApiOperation(value = "批量保存考勤记录明细", tags = {"考勤记录明细" },  notes = "批量保存考勤记录明细")
	@RequestMapping(method = RequestMethod.POST, value = "/attendrecorddetails/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<AttendRecordDetailDTO> attendrecorddetaildtos) {
        attendrecorddetailService.saveBatch(attendrecorddetailMapping.toDomain(attendrecorddetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendrecorddetailService.get(#attendrecorddetail_id),'ehr-AttendRecordDetail-Update')")
    @ApiOperation(value = "更新考勤记录明细", tags = {"考勤记录明细" },  notes = "更新考勤记录明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendrecorddetails/{attendrecorddetail_id}")
    @Transactional
    public ResponseEntity<AttendRecordDetailDTO> update(@PathVariable("attendrecorddetail_id") String attendrecorddetail_id, @RequestBody AttendRecordDetailDTO attendrecorddetaildto) {
		AttendRecordDetail domain  = attendrecorddetailMapping.toDomain(attendrecorddetaildto);
        domain .setAttendrecorddetailid(attendrecorddetail_id);
		attendrecorddetailService.update(domain );
		AttendRecordDetailDTO dto = attendrecorddetailMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendrecorddetailService.getAttendrecorddetailByEntities(this.attendrecorddetailMapping.toDomain(#attendrecorddetaildtos)),'ehr-AttendRecordDetail-Update')")
    @ApiOperation(value = "批量更新考勤记录明细", tags = {"考勤记录明细" },  notes = "批量更新考勤记录明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendrecorddetails/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<AttendRecordDetailDTO> attendrecorddetaildtos) {
        attendrecorddetailService.updateBatch(attendrecorddetailMapping.toDomain(attendrecorddetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendrecorddetailService.get(#attendrecorddetail_id),'ehr-AttendRecordDetail-Remove')")
    @ApiOperation(value = "删除考勤记录明细", tags = {"考勤记录明细" },  notes = "删除考勤记录明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendrecorddetails/{attendrecorddetail_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("attendrecorddetail_id") String attendrecorddetail_id) {
         return ResponseEntity.status(HttpStatus.OK).body(attendrecorddetailService.remove(attendrecorddetail_id));
    }

    @PreAuthorize("hasPermission(this.attendrecorddetailService.getAttendrecorddetailByIds(#ids),'ehr-AttendRecordDetail-Remove')")
    @ApiOperation(value = "批量删除考勤记录明细", tags = {"考勤记录明细" },  notes = "批量删除考勤记录明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendrecorddetails/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        attendrecorddetailService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttendRecordDetail-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"考勤记录明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/attendrecorddetails/fetchdefault")
	public ResponseEntity<List<AttendRecordDetailDTO>> fetchDefault(AttendRecordDetailSearchContext context) {
        Page<AttendRecordDetail> domains = attendrecorddetailService.searchDefault(context) ;
        List<AttendRecordDetailDTO> list = attendrecorddetailMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttendRecordDetail-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"考勤记录明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/attendrecorddetails/searchdefault")
	public ResponseEntity<Page<AttendRecordDetailDTO>> searchDefault(@RequestBody AttendRecordDetailSearchContext context) {
        Page<AttendRecordDetail> domains = attendrecorddetailService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendrecorddetailMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

