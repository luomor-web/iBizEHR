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
import cn.ibizlab.ehr.core.att.domain.AttEndenceOrmorgscetor;
import cn.ibizlab.ehr.core.att.service.IAttEndenceOrmorgscetorService;
import cn.ibizlab.ehr.core.att.filter.AttEndenceOrmorgscetorSearchContext;

@Slf4j
@Api(tags = {"考勤部门" })
@RestController("WebApi-attendenceormorgscetor")
@RequestMapping("")
public class AttEndenceOrmorgscetorResource {

    @Autowired
    public IAttEndenceOrmorgscetorService attendenceormorgscetorService;

    @Autowired
    @Lazy
    public AttEndenceOrmorgscetorMapping attendenceormorgscetorMapping;

    @PostAuthorize("hasPermission(this.attendenceormorgscetorMapping.toDomain(returnObject.body),'ehr-AttEndenceOrmorgscetor-Get')")
    @ApiOperation(value = "获取考勤部门", tags = {"考勤部门" },  notes = "获取考勤部门")
	@RequestMapping(method = RequestMethod.GET, value = "/attendenceormorgscetors/{attendenceormorgscetor_id}")
    public ResponseEntity<AttEndenceOrmorgscetorDTO> get(@PathVariable("attendenceormorgscetor_id") String attendenceormorgscetor_id) {
        AttEndenceOrmorgscetor domain = attendenceormorgscetorService.get(attendenceormorgscetor_id);
        AttEndenceOrmorgscetorDTO dto = attendenceormorgscetorMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendenceormorgscetorMapping.toDomain(#attendenceormorgscetordto),'ehr-AttEndenceOrmorgscetor-Create')")
    @ApiOperation(value = "新建考勤部门", tags = {"考勤部门" },  notes = "新建考勤部门")
	@RequestMapping(method = RequestMethod.POST, value = "/attendenceormorgscetors")
    @Transactional
    public ResponseEntity<AttEndenceOrmorgscetorDTO> create(@RequestBody AttEndenceOrmorgscetorDTO attendenceormorgscetordto) {
        AttEndenceOrmorgscetor domain = attendenceormorgscetorMapping.toDomain(attendenceormorgscetordto);
		attendenceormorgscetorService.create(domain);
        AttEndenceOrmorgscetorDTO dto = attendenceormorgscetorMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendenceormorgscetorMapping.toDomain(#attendenceormorgscetordtos),'ehr-AttEndenceOrmorgscetor-Create')")
    @ApiOperation(value = "批量新建考勤部门", tags = {"考勤部门" },  notes = "批量新建考勤部门")
	@RequestMapping(method = RequestMethod.POST, value = "/attendenceormorgscetors/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<AttEndenceOrmorgscetorDTO> attendenceormorgscetordtos) {
        attendenceormorgscetorService.createBatch(attendenceormorgscetorMapping.toDomain(attendenceormorgscetordtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendenceormorgscetorService.get(#attendenceormorgscetor_id),'ehr-AttEndenceOrmorgscetor-Update')")
    @ApiOperation(value = "更新考勤部门", tags = {"考勤部门" },  notes = "更新考勤部门")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendenceormorgscetors/{attendenceormorgscetor_id}")
    @Transactional
    public ResponseEntity<AttEndenceOrmorgscetorDTO> update(@PathVariable("attendenceormorgscetor_id") String attendenceormorgscetor_id, @RequestBody AttEndenceOrmorgscetorDTO attendenceormorgscetordto) {
		AttEndenceOrmorgscetor domain  = attendenceormorgscetorMapping.toDomain(attendenceormorgscetordto);
        domain .setAttendenceormorgsectorid(attendenceormorgscetor_id);
		attendenceormorgscetorService.update(domain );
		AttEndenceOrmorgscetorDTO dto = attendenceormorgscetorMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendenceormorgscetorService.getAttendenceormorgscetorByEntities(this.attendenceormorgscetorMapping.toDomain(#attendenceormorgscetordtos)),'ehr-AttEndenceOrmorgscetor-Update')")
    @ApiOperation(value = "批量更新考勤部门", tags = {"考勤部门" },  notes = "批量更新考勤部门")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendenceormorgscetors/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<AttEndenceOrmorgscetorDTO> attendenceormorgscetordtos) {
        attendenceormorgscetorService.updateBatch(attendenceormorgscetorMapping.toDomain(attendenceormorgscetordtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查考勤部门", tags = {"考勤部门" },  notes = "检查考勤部门")
	@RequestMapping(method = RequestMethod.POST, value = "/attendenceormorgscetors/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody AttEndenceOrmorgscetorDTO attendenceormorgscetordto) {
        return  ResponseEntity.status(HttpStatus.OK).body(attendenceormorgscetorService.checkKey(attendenceormorgscetorMapping.toDomain(attendenceormorgscetordto)));
    }

    @PreAuthorize("hasPermission(this.attendenceormorgscetorService.get(#attendenceormorgscetor_id),'ehr-AttEndenceOrmorgscetor-Remove')")
    @ApiOperation(value = "删除考勤部门", tags = {"考勤部门" },  notes = "删除考勤部门")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendenceormorgscetors/{attendenceormorgscetor_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("attendenceormorgscetor_id") String attendenceormorgscetor_id) {
         return ResponseEntity.status(HttpStatus.OK).body(attendenceormorgscetorService.remove(attendenceormorgscetor_id));
    }

    @PreAuthorize("hasPermission(this.attendenceormorgscetorService.getAttendenceormorgscetorByIds(#ids),'ehr-AttEndenceOrmorgscetor-Remove')")
    @ApiOperation(value = "批量删除考勤部门", tags = {"考勤部门" },  notes = "批量删除考勤部门")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendenceormorgscetors/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        attendenceormorgscetorService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取考勤部门草稿", tags = {"考勤部门" },  notes = "获取考勤部门草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/attendenceormorgscetors/getdraft")
    public ResponseEntity<AttEndenceOrmorgscetorDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(attendenceormorgscetorMapping.toDto(attendenceormorgscetorService.getDraft(new AttEndenceOrmorgscetor())));
    }

    @PreAuthorize("hasPermission(this.attendenceormorgscetorMapping.toDomain(#attendenceormorgscetordto),'ehr-AttEndenceOrmorgscetor-Save')")
    @ApiOperation(value = "保存考勤部门", tags = {"考勤部门" },  notes = "保存考勤部门")
	@RequestMapping(method = RequestMethod.POST, value = "/attendenceormorgscetors/save")
    public ResponseEntity<Boolean> save(@RequestBody AttEndenceOrmorgscetorDTO attendenceormorgscetordto) {
        return ResponseEntity.status(HttpStatus.OK).body(attendenceormorgscetorService.save(attendenceormorgscetorMapping.toDomain(attendenceormorgscetordto)));
    }

    @PreAuthorize("hasPermission(this.attendenceormorgscetorMapping.toDomain(#attendenceormorgscetordtos),'ehr-AttEndenceOrmorgscetor-Save')")
    @ApiOperation(value = "批量保存考勤部门", tags = {"考勤部门" },  notes = "批量保存考勤部门")
	@RequestMapping(method = RequestMethod.POST, value = "/attendenceormorgscetors/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<AttEndenceOrmorgscetorDTO> attendenceormorgscetordtos) {
        attendenceormorgscetorService.saveBatch(attendenceormorgscetorMapping.toDomain(attendenceormorgscetordtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndenceOrmorgscetor-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"考勤部门" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/attendenceormorgscetors/fetchdefault")
	public ResponseEntity<List<AttEndenceOrmorgscetorDTO>> fetchDefault(AttEndenceOrmorgscetorSearchContext context) {
        Page<AttEndenceOrmorgscetor> domains = attendenceormorgscetorService.searchDefault(context) ;
        List<AttEndenceOrmorgscetorDTO> list = attendenceormorgscetorMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndenceOrmorgscetor-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"考勤部门" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/attendenceormorgscetors/searchdefault")
	public ResponseEntity<Page<AttEndenceOrmorgscetorDTO>> searchDefault(@RequestBody AttEndenceOrmorgscetorSearchContext context) {
        Page<AttEndenceOrmorgscetor> domains = attendenceormorgscetorService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendenceormorgscetorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.attendenceormorgscetorMapping.toDomain(returnObject.body),'ehr-AttEndenceOrmorgscetor-Get')")
    @ApiOperation(value = "根据考勤设置获取考勤部门", tags = {"考勤部门" },  notes = "根据考勤设置获取考勤部门")
	@RequestMapping(method = RequestMethod.GET, value = "/attendencesetups/{attendencesetup_id}/attendenceormorgscetors/{attendenceormorgscetor_id}")
    public ResponseEntity<AttEndenceOrmorgscetorDTO> getByAttEndenceSetup(@PathVariable("attendencesetup_id") String attendencesetup_id, @PathVariable("attendenceormorgscetor_id") String attendenceormorgscetor_id) {
        AttEndenceOrmorgscetor domain = attendenceormorgscetorService.get(attendenceormorgscetor_id);
        AttEndenceOrmorgscetorDTO dto = attendenceormorgscetorMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendenceormorgscetorMapping.toDomain(#attendenceormorgscetordto),'ehr-AttEndenceOrmorgscetor-Create')")
    @ApiOperation(value = "根据考勤设置建立考勤部门", tags = {"考勤部门" },  notes = "根据考勤设置建立考勤部门")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencesetups/{attendencesetup_id}/attendenceormorgscetors")
    @Transactional
    public ResponseEntity<AttEndenceOrmorgscetorDTO> createByAttEndenceSetup(@PathVariable("attendencesetup_id") String attendencesetup_id, @RequestBody AttEndenceOrmorgscetorDTO attendenceormorgscetordto) {
        AttEndenceOrmorgscetor domain = attendenceormorgscetorMapping.toDomain(attendenceormorgscetordto);
        domain.setAttendencesetupid(attendencesetup_id);
		attendenceormorgscetorService.create(domain);
        AttEndenceOrmorgscetorDTO dto = attendenceormorgscetorMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendenceormorgscetorMapping.toDomain(#attendenceormorgscetordtos),'ehr-AttEndenceOrmorgscetor-Create')")
    @ApiOperation(value = "根据考勤设置批量建立考勤部门", tags = {"考勤部门" },  notes = "根据考勤设置批量建立考勤部门")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencesetups/{attendencesetup_id}/attendenceormorgscetors/batch")
    public ResponseEntity<Boolean> createBatchByAttEndenceSetup(@PathVariable("attendencesetup_id") String attendencesetup_id, @RequestBody List<AttEndenceOrmorgscetorDTO> attendenceormorgscetordtos) {
        List<AttEndenceOrmorgscetor> domainlist=attendenceormorgscetorMapping.toDomain(attendenceormorgscetordtos);
        for(AttEndenceOrmorgscetor domain:domainlist){
            domain.setAttendencesetupid(attendencesetup_id);
        }
        attendenceormorgscetorService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attendenceormorgscetorService.get(#attendenceormorgscetor_id),'ehr-AttEndenceOrmorgscetor-Update')")
    @ApiOperation(value = "根据考勤设置更新考勤部门", tags = {"考勤部门" },  notes = "根据考勤设置更新考勤部门")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendencesetups/{attendencesetup_id}/attendenceormorgscetors/{attendenceormorgscetor_id}")
    @Transactional
    public ResponseEntity<AttEndenceOrmorgscetorDTO> updateByAttEndenceSetup(@PathVariable("attendencesetup_id") String attendencesetup_id, @PathVariable("attendenceormorgscetor_id") String attendenceormorgscetor_id, @RequestBody AttEndenceOrmorgscetorDTO attendenceormorgscetordto) {
        AttEndenceOrmorgscetor domain = attendenceormorgscetorMapping.toDomain(attendenceormorgscetordto);
        domain.setAttendencesetupid(attendencesetup_id);
        domain.setAttendenceormorgsectorid(attendenceormorgscetor_id);
		attendenceormorgscetorService.update(domain);
        AttEndenceOrmorgscetorDTO dto = attendenceormorgscetorMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attendenceormorgscetorService.getAttendenceormorgscetorByEntities(this.attendenceormorgscetorMapping.toDomain(#attendenceormorgscetordtos)),'ehr-AttEndenceOrmorgscetor-Update')")
    @ApiOperation(value = "根据考勤设置批量更新考勤部门", tags = {"考勤部门" },  notes = "根据考勤设置批量更新考勤部门")
	@RequestMapping(method = RequestMethod.PUT, value = "/attendencesetups/{attendencesetup_id}/attendenceormorgscetors/batch")
    public ResponseEntity<Boolean> updateBatchByAttEndenceSetup(@PathVariable("attendencesetup_id") String attendencesetup_id, @RequestBody List<AttEndenceOrmorgscetorDTO> attendenceormorgscetordtos) {
        List<AttEndenceOrmorgscetor> domainlist=attendenceormorgscetorMapping.toDomain(attendenceormorgscetordtos);
        for(AttEndenceOrmorgscetor domain:domainlist){
            domain.setAttendencesetupid(attendencesetup_id);
        }
        attendenceormorgscetorService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据考勤设置检查考勤部门", tags = {"考勤部门" },  notes = "根据考勤设置检查考勤部门")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencesetups/{attendencesetup_id}/attendenceormorgscetors/checkkey")
    public ResponseEntity<Boolean> checkKeyByAttEndenceSetup(@PathVariable("attendencesetup_id") String attendencesetup_id, @RequestBody AttEndenceOrmorgscetorDTO attendenceormorgscetordto) {
        return  ResponseEntity.status(HttpStatus.OK).body(attendenceormorgscetorService.checkKey(attendenceormorgscetorMapping.toDomain(attendenceormorgscetordto)));
    }

    @PreAuthorize("hasPermission(this.attendenceormorgscetorService.get(#attendenceormorgscetor_id),'ehr-AttEndenceOrmorgscetor-Remove')")
    @ApiOperation(value = "根据考勤设置删除考勤部门", tags = {"考勤部门" },  notes = "根据考勤设置删除考勤部门")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendencesetups/{attendencesetup_id}/attendenceormorgscetors/{attendenceormorgscetor_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByAttEndenceSetup(@PathVariable("attendencesetup_id") String attendencesetup_id, @PathVariable("attendenceormorgscetor_id") String attendenceormorgscetor_id) {
		return ResponseEntity.status(HttpStatus.OK).body(attendenceormorgscetorService.remove(attendenceormorgscetor_id));
    }

    @PreAuthorize("hasPermission(this.attendenceormorgscetorService.getAttendenceormorgscetorByIds(#ids),'ehr-AttEndenceOrmorgscetor-Remove')")
    @ApiOperation(value = "根据考勤设置批量删除考勤部门", tags = {"考勤部门" },  notes = "根据考勤设置批量删除考勤部门")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attendencesetups/{attendencesetup_id}/attendenceormorgscetors/batch")
    public ResponseEntity<Boolean> removeBatchByAttEndenceSetup(@RequestBody List<String> ids) {
        attendenceormorgscetorService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据考勤设置获取考勤部门草稿", tags = {"考勤部门" },  notes = "根据考勤设置获取考勤部门草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/attendencesetups/{attendencesetup_id}/attendenceormorgscetors/getdraft")
    public ResponseEntity<AttEndenceOrmorgscetorDTO> getDraftByAttEndenceSetup(@PathVariable("attendencesetup_id") String attendencesetup_id) {
        AttEndenceOrmorgscetor domain = new AttEndenceOrmorgscetor();
        domain.setAttendencesetupid(attendencesetup_id);
        return ResponseEntity.status(HttpStatus.OK).body(attendenceormorgscetorMapping.toDto(attendenceormorgscetorService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.attendenceormorgscetorMapping.toDomain(#attendenceormorgscetordto),'ehr-AttEndenceOrmorgscetor-Save')")
    @ApiOperation(value = "根据考勤设置保存考勤部门", tags = {"考勤部门" },  notes = "根据考勤设置保存考勤部门")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencesetups/{attendencesetup_id}/attendenceormorgscetors/save")
    public ResponseEntity<Boolean> saveByAttEndenceSetup(@PathVariable("attendencesetup_id") String attendencesetup_id, @RequestBody AttEndenceOrmorgscetorDTO attendenceormorgscetordto) {
        AttEndenceOrmorgscetor domain = attendenceormorgscetorMapping.toDomain(attendenceormorgscetordto);
        domain.setAttendencesetupid(attendencesetup_id);
        return ResponseEntity.status(HttpStatus.OK).body(attendenceormorgscetorService.save(domain));
    }

    @PreAuthorize("hasPermission(this.attendenceormorgscetorMapping.toDomain(#attendenceormorgscetordtos),'ehr-AttEndenceOrmorgscetor-Save')")
    @ApiOperation(value = "根据考勤设置批量保存考勤部门", tags = {"考勤部门" },  notes = "根据考勤设置批量保存考勤部门")
	@RequestMapping(method = RequestMethod.POST, value = "/attendencesetups/{attendencesetup_id}/attendenceormorgscetors/savebatch")
    public ResponseEntity<Boolean> saveBatchByAttEndenceSetup(@PathVariable("attendencesetup_id") String attendencesetup_id, @RequestBody List<AttEndenceOrmorgscetorDTO> attendenceormorgscetordtos) {
        List<AttEndenceOrmorgscetor> domainlist=attendenceormorgscetorMapping.toDomain(attendenceormorgscetordtos);
        for(AttEndenceOrmorgscetor domain:domainlist){
             domain.setAttendencesetupid(attendencesetup_id);
        }
        attendenceormorgscetorService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndenceOrmorgscetor-Default-all')")
	@ApiOperation(value = "根据考勤设置获取DEFAULT", tags = {"考勤部门" } ,notes = "根据考勤设置获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/attendencesetups/{attendencesetup_id}/attendenceormorgscetors/fetchdefault")
	public ResponseEntity<List<AttEndenceOrmorgscetorDTO>> fetchAttEndenceOrmorgscetorDefaultByAttEndenceSetup(@PathVariable("attendencesetup_id") String attendencesetup_id,AttEndenceOrmorgscetorSearchContext context) {
        context.setN_attendencesetupid_eq(attendencesetup_id);
        Page<AttEndenceOrmorgscetor> domains = attendenceormorgscetorService.searchDefault(context) ;
        List<AttEndenceOrmorgscetorDTO> list = attendenceormorgscetorMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEndenceOrmorgscetor-Default-all')")
	@ApiOperation(value = "根据考勤设置查询DEFAULT", tags = {"考勤部门" } ,notes = "根据考勤设置查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/attendencesetups/{attendencesetup_id}/attendenceormorgscetors/searchdefault")
	public ResponseEntity<Page<AttEndenceOrmorgscetorDTO>> searchAttEndenceOrmorgscetorDefaultByAttEndenceSetup(@PathVariable("attendencesetup_id") String attendencesetup_id, @RequestBody AttEndenceOrmorgscetorSearchContext context) {
        context.setN_attendencesetupid_eq(attendencesetup_id);
        Page<AttEndenceOrmorgscetor> domains = attendenceormorgscetorService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attendenceormorgscetorMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

