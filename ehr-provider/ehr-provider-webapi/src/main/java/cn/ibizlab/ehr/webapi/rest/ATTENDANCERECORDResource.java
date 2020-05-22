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
import cn.ibizlab.ehr.core.att.domain.ATTENDANCERECORD;
import cn.ibizlab.ehr.core.att.service.IATTENDANCERECORDService;
import cn.ibizlab.ehr.core.att.filter.ATTENDANCERECORDSearchContext;




@Slf4j
@Api(tags = {"ATTENDANCERECORD" })
@RestController("WebApi-attendancerecord")
@RequestMapping("")
public class ATTENDANCERECORDResource {

    @Autowired
    private IATTENDANCERECORDService attendancerecordService;

    @Autowired
    @Lazy
    public ATTENDANCERECORDMapping attendancerecordMapping;

    public ATTENDANCERECORDDTO permissionDTO=new ATTENDANCERECORDDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCERECORD-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"ATTENDANCERECORD" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/attendancerecords/getdraft")
    public ResponseEntity<ATTENDANCERECORDDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(attendancerecordMapping.toDto(attendancerecordService.getDraft(new ATTENDANCERECORD())));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.attendancerecordMapping,#attendancerecorddto})")
    @ApiOperation(value = "Create", tags = {"ATTENDANCERECORD" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancerecords")
    @Transactional
    public ResponseEntity<ATTENDANCERECORDDTO> create(@RequestBody ATTENDANCERECORDDTO attendancerecorddto) {
        ATTENDANCERECORD domain = attendancerecordMapping.toDomain(attendancerecorddto);
		attendancerecordService.create(domain);
        ATTENDANCERECORDDTO dto = attendancerecordMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"ATTENDANCERECORD" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancerecords/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ATTENDANCERECORDDTO> attendancerecorddtos) {
        attendancerecordService.createBatch(attendancerecordMapping.toDomain(attendancerecorddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#attendancerecord_id,'Update',{'Sql',this.attendancerecordMapping,#attendancerecorddto})")
    @ApiOperation(value = "Update", tags = {"ATTENDANCERECORD" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendancerecords/{attendancerecord_id}")
    @Transactional
    public ResponseEntity<ATTENDANCERECORDDTO> update(@PathVariable("attendancerecord_id") String attendancerecord_id, @RequestBody ATTENDANCERECORDDTO attendancerecorddto) {
		ATTENDANCERECORD domain = attendancerecordMapping.toDomain(attendancerecorddto);
        domain.setAttendancerecordid(attendancerecord_id);
		attendancerecordService.update(domain);
		ATTENDANCERECORDDTO dto = attendancerecordMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"ATTENDANCERECORD" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendancerecords/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ATTENDANCERECORDDTO> attendancerecorddtos) {
        attendancerecordService.updateBatch(attendancerecordMapping.toDomain(attendancerecorddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#attendancerecord_id,'Remove',{'Sql',this.attendancerecordMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"ATTENDANCERECORD" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendancerecords/{attendancerecord_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("attendancerecord_id") String attendancerecord_id) {
         return ResponseEntity.status(HttpStatus.OK).body(attendancerecordService.remove(attendancerecord_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"ATTENDANCERECORD" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendancerecords/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        attendancerecordService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCERECORD-Save-all')")
    @ApiOperation(value = "Save", tags = {"ATTENDANCERECORD" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancerecords/save")
    public ResponseEntity<Boolean> save(@RequestBody ATTENDANCERECORDDTO attendancerecorddto) {
        return ResponseEntity.status(HttpStatus.OK).body(attendancerecordService.save(attendancerecordMapping.toDomain(attendancerecorddto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"ATTENDANCERECORD" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancerecords/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ATTENDANCERECORDDTO> attendancerecorddtos) {
        attendancerecordService.saveBatch(attendancerecordMapping.toDomain(attendancerecorddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#attendancerecord_id,'Get',{'Sql',this.attendancerecordMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"ATTENDANCERECORD" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/attendancerecords/{attendancerecord_id}")
    public ResponseEntity<ATTENDANCERECORDDTO> get(@PathVariable("attendancerecord_id") String attendancerecord_id) {
        ATTENDANCERECORD domain = attendancerecordService.get(attendancerecord_id);
        ATTENDANCERECORDDTO dto = attendancerecordMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCERECORD-ReflushPersonInfo-all')")
    @ApiOperation(value = "刷新表单上的员工信息", tags = {"ATTENDANCERECORD" },  notes = "刷新表单上的员工信息")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancerecords/{attendancerecord_id}/reflushpersoninfo")
    @Transactional
    public ResponseEntity<ATTENDANCERECORDDTO> reflushPersonInfo(@PathVariable("attendancerecord_id") String attendancerecord_id, @RequestBody ATTENDANCERECORDDTO attendancerecorddto) {
        ATTENDANCERECORD attendancerecord = attendancerecordMapping.toDomain(attendancerecorddto);
        attendancerecord = attendancerecordService.reflushPersonInfo(attendancerecord);
        attendancerecorddto = attendancerecordMapping.toDto(attendancerecord);
        return ResponseEntity.status(HttpStatus.OK).body(attendancerecorddto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCERECORD-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"ATTENDANCERECORD" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/attendancerecords/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ATTENDANCERECORDDTO attendancerecorddto) {
        return  ResponseEntity.status(HttpStatus.OK).body(attendancerecordService.checkKey(attendancerecordMapping.toDomain(attendancerecorddto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCERECORD-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ATTENDANCERECORD" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/attendancerecords/fetchdefault")
	public ResponseEntity<List<ATTENDANCERECORDDTO>> fetchDefault(ATTENDANCERECORDSearchContext context) {
        Page<ATTENDANCERECORD> domains = attendancerecordService.searchDefault(context) ;
        List<ATTENDANCERECORDDTO> list = attendancerecordMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCERECORD-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ATTENDANCERECORD" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/attendancerecords/searchdefault")
	public ResponseEntity<Page<ATTENDANCERECORDDTO>> searchDefault(@RequestBody ATTENDANCERECORDSearchContext context) {
        Page<ATTENDANCERECORD> domains = attendancerecordService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancerecordMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCERECORD-GetDraft-all')")
    @ApiOperation(value = "GetDraftByPIMPERSON", tags = {"ATTENDANCERECORD" },  notes = "GetDraftByPIMPERSON")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/attendancerecords/getdraft")
    public ResponseEntity<ATTENDANCERECORDDTO> getDraftByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id) {
        ATTENDANCERECORD domain = new ATTENDANCERECORD();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(attendancerecordMapping.toDto(attendancerecordService.getDraft(domain)));
    }

    //@PreAuthorize("hasPermission('','Create',{'Sql',this.attendancerecordMapping,#attendancerecorddto})")
    @ApiOperation(value = "CreateByPIMPERSON", tags = {"ATTENDANCERECORD" },  notes = "CreateByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/attendancerecords")
    @Transactional
    public ResponseEntity<ATTENDANCERECORDDTO> createByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ATTENDANCERECORDDTO attendancerecorddto) {
        ATTENDANCERECORD domain = attendancerecordMapping.toDomain(attendancerecorddto);
        domain.setPimpersonid(pimperson_id);
		attendancerecordService.create(domain);
        ATTENDANCERECORDDTO dto = attendancerecordMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatchByPIMPERSON", tags = {"ATTENDANCERECORD" },  notes = "createBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/attendancerecords/batch")
    public ResponseEntity<Boolean> createBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<ATTENDANCERECORDDTO> attendancerecorddtos) {
        List<ATTENDANCERECORD> domainlist=attendancerecordMapping.toDomain(attendancerecorddtos);
        for(ATTENDANCERECORD domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        attendancerecordService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasPermission(#attendancerecord_id,'Update',{'Sql',this.attendancerecordMapping,#attendancerecorddto})")
    @ApiOperation(value = "UpdateByPIMPERSON", tags = {"ATTENDANCERECORD" },  notes = "UpdateByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/attendancerecords/{attendancerecord_id}")
    @Transactional
    public ResponseEntity<ATTENDANCERECORDDTO> updateByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("attendancerecord_id") String attendancerecord_id, @RequestBody ATTENDANCERECORDDTO attendancerecorddto) {
        ATTENDANCERECORD domain = attendancerecordMapping.toDomain(attendancerecorddto);
        domain.setPimpersonid(pimperson_id);
        domain.setAttendancerecordid(attendancerecord_id);
		attendancerecordService.update(domain);
        ATTENDANCERECORDDTO dto = attendancerecordMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatchByPIMPERSON", tags = {"ATTENDANCERECORD" },  notes = "UpdateBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/attendancerecords/batch")
    public ResponseEntity<Boolean> updateBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<ATTENDANCERECORDDTO> attendancerecorddtos) {
        List<ATTENDANCERECORD> domainlist=attendancerecordMapping.toDomain(attendancerecorddtos);
        for(ATTENDANCERECORD domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        attendancerecordService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasPermission(#attendancerecord_id,'Remove',{'Sql',this.attendancerecordMapping,this.permissionDTO})")
    @ApiOperation(value = "RemoveByPIMPERSON", tags = {"ATTENDANCERECORD" },  notes = "RemoveByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/attendancerecords/{attendancerecord_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("attendancerecord_id") String attendancerecord_id) {
		return ResponseEntity.status(HttpStatus.OK).body(attendancerecordService.remove(attendancerecord_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatchByPIMPERSON", tags = {"ATTENDANCERECORD" },  notes = "RemoveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/attendancerecords/batch")
    public ResponseEntity<Boolean> removeBatchByPIMPERSON(@RequestBody List<String> ids) {
        attendancerecordService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCERECORD-Save-all')")
    @ApiOperation(value = "SaveByPIMPERSON", tags = {"ATTENDANCERECORD" },  notes = "SaveByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/attendancerecords/save")
    public ResponseEntity<Boolean> saveByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ATTENDANCERECORDDTO attendancerecorddto) {
        ATTENDANCERECORD domain = attendancerecordMapping.toDomain(attendancerecorddto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(attendancerecordService.save(domain));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatchByPIMPERSON", tags = {"ATTENDANCERECORD" },  notes = "SaveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/attendancerecords/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<ATTENDANCERECORDDTO> attendancerecorddtos) {
        List<ATTENDANCERECORD> domainlist=attendancerecordMapping.toDomain(attendancerecorddtos);
        for(ATTENDANCERECORD domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        attendancerecordService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasPermission(#attendancerecord_id,'Get',{'Sql',this.attendancerecordMapping,this.permissionDTO})")
    @ApiOperation(value = "GetByPIMPERSON", tags = {"ATTENDANCERECORD" },  notes = "GetByPIMPERSON")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/attendancerecords/{attendancerecord_id}")
    public ResponseEntity<ATTENDANCERECORDDTO> getByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("attendancerecord_id") String attendancerecord_id) {
        ATTENDANCERECORD domain = attendancerecordService.get(attendancerecord_id);
        ATTENDANCERECORDDTO dto = attendancerecordMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCERECORD-ReflushPersonInfo-all')")
    @ApiOperation(value = "刷新表单上的员工信息ByPIMPERSON", tags = {"ATTENDANCERECORD" },  notes = "刷新表单上的员工信息ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/attendancerecords/{attendancerecordattendancerecordid}/reflushpersoninfo")
    @Transactional
    public ResponseEntity<ATTENDANCERECORDDTO> reflushPersonInfoByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("attendancerecord_id") String attendancerecord_id, @RequestBody ATTENDANCERECORDDTO attendancerecorddto) {
        ATTENDANCERECORD domain = attendancerecordMapping.toDomain(attendancerecorddto);
        domain.setPimpersonid(pimperson_id);
        domain = attendancerecordService.reflushPersonInfo(domain) ;
        attendancerecorddto = attendancerecordMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(attendancerecorddto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCERECORD-CheckKey-all')")
    @ApiOperation(value = "CheckKeyByPIMPERSON", tags = {"ATTENDANCERECORD" },  notes = "CheckKeyByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/attendancerecords/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ATTENDANCERECORDDTO attendancerecorddto) {
        return  ResponseEntity.status(HttpStatus.OK).body(attendancerecordService.checkKey(attendancerecordMapping.toDomain(attendancerecorddto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCERECORD-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPIMPERSON", tags = {"ATTENDANCERECORD" } ,notes = "fetchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/attendancerecords/fetchdefault")
	public ResponseEntity<List<ATTENDANCERECORDDTO>> fetchATTENDANCERECORDDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,ATTENDANCERECORDSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<ATTENDANCERECORD> domains = attendancerecordService.searchDefault(context) ;
        List<ATTENDANCERECORDDTO> list = attendancerecordMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ATTENDANCERECORD-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPIMPERSON", tags = {"ATTENDANCERECORD" } ,notes = "searchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/attendancerecords/searchdefault")
	public ResponseEntity<Page<ATTENDANCERECORDDTO>> searchATTENDANCERECORDDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ATTENDANCERECORDSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<ATTENDANCERECORD> domains = attendancerecordService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendancerecordMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
