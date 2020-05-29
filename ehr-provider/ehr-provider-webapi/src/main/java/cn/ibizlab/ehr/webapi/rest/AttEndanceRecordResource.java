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
import cn.ibizlab.ehr.core.att.domain.AttEndanceRecord;
import cn.ibizlab.ehr.core.att.service.IAttEndanceRecordService;
import cn.ibizlab.ehr.core.att.filter.AttEndanceRecordSearchContext;

@Slf4j
@Api(tags = {"AttEndanceRecord" })
@RestController("WebApi-attendancerecord")
@RequestMapping("")
public class AttEndanceRecordResource {

    @Autowired
    public IAttEndanceRecordService attendancerecordService;

    @Autowired
    @Lazy
    public AttEndanceRecordMapping attendancerecordMapping;

    @ApiOperation(value = "GetDraft", tags = {"AttEndanceRecord" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/attendancerecords/getdraft")
    public ResponseEntity<AttEndanceRecordDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(attendancerecordMapping.toDto(attendancerecordService.getDraft(new AttEndanceRecord())));
    }

    @PreAuthorize("hasPermission(this.attendancerecordMapping.toDomain(#attendancerecorddto),'ehr-AttEndanceRecord-Create')")
    @ApiOperation(value = "Create", tags = {"AttEndanceRecord" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancerecords")
    @Transactional
    public ResponseEntity<AttEndanceRecordDTO> create(@RequestBody AttEndanceRecordDTO attendancerecorddto) {
        AttEndanceRecord domain = attendancerecordMapping.toDomain(attendancerecorddto);
		attendancerecordService.create(domain);
        AttEndanceRecordDTO dto = attendancerecordMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancerecordMapping.toDomain(#attendancerecorddtos),'ehr-AttEndanceRecord-Create')")
    @ApiOperation(value = "createBatch", tags = {"AttEndanceRecord" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancerecords/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<AttEndanceRecordDTO> attendancerecorddtos) {
        attendancerecordService.createBatch(attendancerecordMapping.toDomain(attendancerecorddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendancerecordService.get(#attendancerecord_id),'ehr-AttEndanceRecord-Update')")
    @ApiOperation(value = "Update", tags = {"AttEndanceRecord" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendancerecords/{attendancerecord_id}")
    @Transactional
    public ResponseEntity<AttEndanceRecordDTO> update(@PathVariable("attendancerecord_id") String attendancerecord_id, @RequestBody AttEndanceRecordDTO attendancerecorddto) {
		AttEndanceRecord domain  = attendancerecordMapping.toDomain(attendancerecorddto);
        domain .setAttendancerecordid(attendancerecord_id);
		attendancerecordService.update(domain );
		AttEndanceRecordDTO dto = attendancerecordMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancerecordService.getAttendancerecordByEntities(this.attendancerecordMapping.toDomain(#attendancerecorddtos)),'ehr-AttEndanceRecord-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"AttEndanceRecord" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendancerecords/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<AttEndanceRecordDTO> attendancerecorddtos) {
        attendancerecordService.updateBatch(attendancerecordMapping.toDomain(attendancerecorddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendancerecordService.get(#attendancerecord_id),'ehr-AttEndanceRecord-Remove')")
    @ApiOperation(value = "Remove", tags = {"AttEndanceRecord" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendancerecords/{attendancerecord_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("attendancerecord_id") String attendancerecord_id) {
         return ResponseEntity.status(HttpStatus.OK).body(attendancerecordService.remove(attendancerecord_id));
    }

    @PreAuthorize("hasPermission(this.attendancerecordService.getAttendancerecordByIds(#ids),'ehr-AttEndanceRecord-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"AttEndanceRecord" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendancerecords/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        attendancerecordService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendancerecordMapping.toDomain(#attendancerecorddto),'ehr-AttEndanceRecord-Save')")
    @ApiOperation(value = "Save", tags = {"AttEndanceRecord" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancerecords/save")
    public ResponseEntity<Boolean> save(@RequestBody AttEndanceRecordDTO attendancerecorddto) {
        return ResponseEntity.status(HttpStatus.OK).body(attendancerecordService.save(attendancerecordMapping.toDomain(attendancerecorddto)));
    }

    @PreAuthorize("hasPermission(this.attendancerecordMapping.toDomain(#attendancerecorddtos),'ehr-AttEndanceRecord-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"AttEndanceRecord" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancerecords/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<AttEndanceRecordDTO> attendancerecorddtos) {
        attendancerecordService.saveBatch(attendancerecordMapping.toDomain(attendancerecorddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.attendancerecordMapping.toDomain(returnObject.body),'ehr-AttEndanceRecord-Get')")
    @ApiOperation(value = "Get", tags = {"AttEndanceRecord" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/attendancerecords/{attendancerecord_id}")
    public ResponseEntity<AttEndanceRecordDTO> get(@PathVariable("attendancerecord_id") String attendancerecord_id) {
        AttEndanceRecord domain = attendancerecordService.get(attendancerecord_id);
        AttEndanceRecordDTO dto = attendancerecordMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceRecord-ReflushPersonInfo-all')")
    @ApiOperation(value = "刷新表单上的员工信息", tags = {"AttEndanceRecord" },  notes = "刷新表单上的员工信息")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancerecords/{attendancerecord_id}/reflushpersoninfo")
    @Transactional
    public ResponseEntity<AttEndanceRecordDTO> reflushPersonInfo(@PathVariable("attendancerecord_id") String attendancerecord_id, @RequestBody AttEndanceRecordDTO attendancerecorddto) {
        AttEndanceRecord attendancerecord = attendancerecordMapping.toDomain(attendancerecorddto);
        attendancerecord.setAttendancerecordid(attendancerecord_id);
        attendancerecord = attendancerecordService.reflushPersonInfo(attendancerecord);
        attendancerecorddto = attendancerecordMapping.toDto(attendancerecord);
        return ResponseEntity.status(HttpStatus.OK).body(attendancerecorddto);
    }

    @ApiOperation(value = "CheckKey", tags = {"AttEndanceRecord" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancerecords/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody AttEndanceRecordDTO attendancerecorddto) {
        return  ResponseEntity.status(HttpStatus.OK).body(attendancerecordService.checkKey(attendancerecordMapping.toDomain(attendancerecorddto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceRecord-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"AttEndanceRecord" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/attendancerecords/fetchdefault")
	public ResponseEntity<List<AttEndanceRecordDTO>> fetchDefault(AttEndanceRecordSearchContext context) {
        Page<AttEndanceRecord> domains = attendancerecordService.searchDefault(context) ;
        List<AttEndanceRecordDTO> list = attendancerecordMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceRecord-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"AttEndanceRecord" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/attendancerecords/searchdefault")
	public ResponseEntity<Page<AttEndanceRecordDTO>> searchDefault(@RequestBody AttEndanceRecordSearchContext context) {
        Page<AttEndanceRecord> domains = attendancerecordService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancerecordMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "GetDraftByPIMPERSON", tags = {"AttEndanceRecord" },  notes = "GetDraftByPIMPERSON")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/attendancerecords/getdraft")
    public ResponseEntity<AttEndanceRecordDTO> getDraftByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id) {
        AttEndanceRecord domain = new AttEndanceRecord();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(attendancerecordMapping.toDto(attendancerecordService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.attendancerecordMapping.toDomain(#attendancerecorddto),'ehr-AttEndanceRecord-Create')")
    @ApiOperation(value = "CreateByPIMPERSON", tags = {"AttEndanceRecord" },  notes = "CreateByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/attendancerecords")
    @Transactional
    public ResponseEntity<AttEndanceRecordDTO> createByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody AttEndanceRecordDTO attendancerecorddto) {
        AttEndanceRecord domain = attendancerecordMapping.toDomain(attendancerecorddto);
        domain.setPimpersonid(pimperson_id);
		attendancerecordService.create(domain);
        AttEndanceRecordDTO dto = attendancerecordMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancerecordMapping.toDomain(#attendancerecorddtos),'ehr-AttEndanceRecord-Create')")
    @ApiOperation(value = "createBatchByPIMPERSON", tags = {"AttEndanceRecord" },  notes = "createBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/attendancerecords/batch")
    public ResponseEntity<Boolean> createBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<AttEndanceRecordDTO> attendancerecorddtos) {
        List<AttEndanceRecord> domainlist=attendancerecordMapping.toDomain(attendancerecorddtos);
        for(AttEndanceRecord domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        attendancerecordService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendancerecordService.get(#attendancerecord_id),'ehr-AttEndanceRecord-Update')")
    @ApiOperation(value = "UpdateByPIMPERSON", tags = {"AttEndanceRecord" },  notes = "UpdateByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/attendancerecords/{attendancerecord_id}")
    @Transactional
    public ResponseEntity<AttEndanceRecordDTO> updateByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("attendancerecord_id") String attendancerecord_id, @RequestBody AttEndanceRecordDTO attendancerecorddto) {
        AttEndanceRecord domain = attendancerecordMapping.toDomain(attendancerecorddto);
        domain.setPimpersonid(pimperson_id);
        domain.setAttendancerecordid(attendancerecord_id);
		attendancerecordService.update(domain);
        AttEndanceRecordDTO dto = attendancerecordMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendancerecordService.getAttendancerecordByEntities(this.attendancerecordMapping.toDomain(#attendancerecorddtos)),'ehr-AttEndanceRecord-Update')")
    @ApiOperation(value = "UpdateBatchByPIMPERSON", tags = {"AttEndanceRecord" },  notes = "UpdateBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/attendancerecords/batch")
    public ResponseEntity<Boolean> updateBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<AttEndanceRecordDTO> attendancerecorddtos) {
        List<AttEndanceRecord> domainlist=attendancerecordMapping.toDomain(attendancerecorddtos);
        for(AttEndanceRecord domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        attendancerecordService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendancerecordService.get(#attendancerecord_id),'ehr-AttEndanceRecord-Remove')")
    @ApiOperation(value = "RemoveByPIMPERSON", tags = {"AttEndanceRecord" },  notes = "RemoveByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/attendancerecords/{attendancerecord_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("attendancerecord_id") String attendancerecord_id) {
		return ResponseEntity.status(HttpStatus.OK).body(attendancerecordService.remove(attendancerecord_id));
    }

    @PreAuthorize("hasPermission(this.attendancerecordService.getAttendancerecordByIds(#ids),'ehr-AttEndanceRecord-Remove')")
    @ApiOperation(value = "RemoveBatchByPIMPERSON", tags = {"AttEndanceRecord" },  notes = "RemoveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/attendancerecords/batch")
    public ResponseEntity<Boolean> removeBatchByPIMPERSON(@RequestBody List<String> ids) {
        attendancerecordService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendancerecordMapping.toDomain(#attendancerecorddto),'ehr-AttEndanceRecord-Save')")
    @ApiOperation(value = "SaveByPIMPERSON", tags = {"AttEndanceRecord" },  notes = "SaveByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/attendancerecords/save")
    public ResponseEntity<Boolean> saveByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody AttEndanceRecordDTO attendancerecorddto) {
        AttEndanceRecord domain = attendancerecordMapping.toDomain(attendancerecorddto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(attendancerecordService.save(domain));
    }

    @PreAuthorize("hasPermission(this.attendancerecordMapping.toDomain(#attendancerecorddtos),'ehr-AttEndanceRecord-Save')")
    @ApiOperation(value = "SaveBatchByPIMPERSON", tags = {"AttEndanceRecord" },  notes = "SaveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/attendancerecords/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<AttEndanceRecordDTO> attendancerecorddtos) {
        List<AttEndanceRecord> domainlist=attendancerecordMapping.toDomain(attendancerecorddtos);
        for(AttEndanceRecord domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        attendancerecordService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.attendancerecordMapping.toDomain(returnObject.body),'ehr-AttEndanceRecord-Get')")
    @ApiOperation(value = "GetByPIMPERSON", tags = {"AttEndanceRecord" },  notes = "GetByPIMPERSON")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/attendancerecords/{attendancerecord_id}")
    public ResponseEntity<AttEndanceRecordDTO> getByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("attendancerecord_id") String attendancerecord_id) {
        AttEndanceRecord domain = attendancerecordService.get(attendancerecord_id);
        AttEndanceRecordDTO dto = attendancerecordMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceRecord-ReflushPersonInfo-all')")
    @ApiOperation(value = "刷新表单上的员工信息ByPIMPERSON", tags = {"AttEndanceRecord" },  notes = "刷新表单上的员工信息ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/attendancerecords/{attendancerecord_id}/reflushpersoninfo")
    @Transactional
    public ResponseEntity<AttEndanceRecordDTO> reflushPersonInfoByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("attendancerecord_id") String attendancerecord_id, @RequestBody AttEndanceRecordDTO attendancerecorddto) {
        AttEndanceRecord domain = attendancerecordMapping.toDomain(attendancerecorddto);
        domain.setPimpersonid(pimperson_id);
        domain = attendancerecordService.reflushPersonInfo(domain) ;
        attendancerecorddto = attendancerecordMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(attendancerecorddto);
    }

    @ApiOperation(value = "CheckKeyByPIMPERSON", tags = {"AttEndanceRecord" },  notes = "CheckKeyByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/attendancerecords/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody AttEndanceRecordDTO attendancerecorddto) {
        return  ResponseEntity.status(HttpStatus.OK).body(attendancerecordService.checkKey(attendancerecordMapping.toDomain(attendancerecorddto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceRecord-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPIMPERSON", tags = {"AttEndanceRecord" } ,notes = "fetchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/attendancerecords/fetchdefault")
	public ResponseEntity<List<AttEndanceRecordDTO>> fetchAttEndanceRecordDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,AttEndanceRecordSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<AttEndanceRecord> domains = attendancerecordService.searchDefault(context) ;
        List<AttEndanceRecordDTO> list = attendancerecordMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndanceRecord-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPIMPERSON", tags = {"AttEndanceRecord" } ,notes = "searchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/attendancerecords/searchdefault")
	public ResponseEntity<Page<AttEndanceRecordDTO>> searchAttEndanceRecordDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody AttEndanceRecordSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<AttEndanceRecord> domains = attendancerecordService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancerecordMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

