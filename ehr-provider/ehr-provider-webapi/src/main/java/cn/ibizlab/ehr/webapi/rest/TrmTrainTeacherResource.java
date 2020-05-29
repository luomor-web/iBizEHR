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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainTeacher;
import cn.ibizlab.ehr.core.trm.service.ITrmTrainTeacherService;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainTeacherSearchContext;

@Slf4j
@Api(tags = {"培训讲师" })
@RestController("WebApi-trmtrainteacher")
@RequestMapping("")
public class TrmTrainTeacherResource {

    @Autowired
    public ITrmTrainTeacherService trmtrainteacherService;

    @Autowired
    @Lazy
    public TrmTrainTeacherMapping trmtrainteacherMapping;

    @PreAuthorize("hasPermission(this.trmtrainteacherService.get(#trmtrainteacher_id),'ehr-TrmTrainTeacher-Remove')")
    @ApiOperation(value = "删除培训讲师", tags = {"培训讲师" },  notes = "删除培训讲师")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainteachers/{trmtrainteacher_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtrainteacherService.remove(trmtrainteacher_id));
    }

    @PreAuthorize("hasPermission(this.trmtrainteacherService.getTrmtrainteacherByIds(#ids),'ehr-TrmTrainTeacher-Remove')")
    @ApiOperation(value = "批量删除培训讲师", tags = {"培训讲师" },  notes = "批量删除培训讲师")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainteachers/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtrainteacherService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainteacherService.get(#trmtrainteacher_id),'ehr-TrmTrainTeacher-Update')")
    @ApiOperation(value = "更新培训讲师", tags = {"培训讲师" },  notes = "更新培训讲师")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainteachers/{trmtrainteacher_id}")
    @Transactional
    public ResponseEntity<TrmTrainTeacherDTO> update(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id, @RequestBody TrmTrainTeacherDTO trmtrainteacherdto) {
		TrmTrainTeacher domain  = trmtrainteacherMapping.toDomain(trmtrainteacherdto);
        domain .setTrmtrainteacherid(trmtrainteacher_id);
		trmtrainteacherService.update(domain );
		TrmTrainTeacherDTO dto = trmtrainteacherMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainteacherService.getTrmtrainteacherByEntities(this.trmtrainteacherMapping.toDomain(#trmtrainteacherdtos)),'ehr-TrmTrainTeacher-Update')")
    @ApiOperation(value = "批量更新培训讲师", tags = {"培训讲师" },  notes = "批量更新培训讲师")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainteachers/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmTrainTeacherDTO> trmtrainteacherdtos) {
        trmtrainteacherService.updateBatch(trmtrainteacherMapping.toDomain(trmtrainteacherdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取培训讲师草稿", tags = {"培训讲师" },  notes = "获取培训讲师草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainteachers/getdraft")
    public ResponseEntity<TrmTrainTeacherDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainteacherMapping.toDto(trmtrainteacherService.getDraft(new TrmTrainTeacher())));
    }

    @PostAuthorize("hasPermission(this.trmtrainteacherMapping.toDomain(returnObject.body),'ehr-TrmTrainTeacher-Get')")
    @ApiOperation(value = "获取培训讲师", tags = {"培训讲师" },  notes = "获取培训讲师")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainteachers/{trmtrainteacher_id}")
    public ResponseEntity<TrmTrainTeacherDTO> get(@PathVariable("trmtrainteacher_id") String trmtrainteacher_id) {
        TrmTrainTeacher domain = trmtrainteacherService.get(trmtrainteacher_id);
        TrmTrainTeacherDTO dto = trmtrainteacherMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "检查培训讲师", tags = {"培训讲师" },  notes = "检查培训讲师")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmTrainTeacherDTO trmtrainteacherdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtrainteacherService.checkKey(trmtrainteacherMapping.toDomain(trmtrainteacherdto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainteacherMapping.toDomain(#trmtrainteacherdto),'ehr-TrmTrainTeacher-Save')")
    @ApiOperation(value = "保存培训讲师", tags = {"培训讲师" },  notes = "保存培训讲师")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmTrainTeacherDTO trmtrainteacherdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtrainteacherService.save(trmtrainteacherMapping.toDomain(trmtrainteacherdto)));
    }

    @PreAuthorize("hasPermission(this.trmtrainteacherMapping.toDomain(#trmtrainteacherdtos),'ehr-TrmTrainTeacher-Save')")
    @ApiOperation(value = "批量保存培训讲师", tags = {"培训讲师" },  notes = "批量保存培训讲师")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmTrainTeacherDTO> trmtrainteacherdtos) {
        trmtrainteacherService.saveBatch(trmtrainteacherMapping.toDomain(trmtrainteacherdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtrainteacherMapping.toDomain(#trmtrainteacherdto),'ehr-TrmTrainTeacher-Create')")
    @ApiOperation(value = "新建培训讲师", tags = {"培训讲师" },  notes = "新建培训讲师")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers")
    @Transactional
    public ResponseEntity<TrmTrainTeacherDTO> create(@RequestBody TrmTrainTeacherDTO trmtrainteacherdto) {
        TrmTrainTeacher domain = trmtrainteacherMapping.toDomain(trmtrainteacherdto);
		trmtrainteacherService.create(domain);
        TrmTrainTeacherDTO dto = trmtrainteacherMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtrainteacherMapping.toDomain(#trmtrainteacherdtos),'ehr-TrmTrainTeacher-Create')")
    @ApiOperation(value = "批量新建培训讲师", tags = {"培训讲师" },  notes = "批量新建培训讲师")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainteachers/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmTrainTeacherDTO> trmtrainteacherdtos) {
        trmtrainteacherService.createBatch(trmtrainteacherMapping.toDomain(trmtrainteacherdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainTeacher-NBJS-all')")
	@ApiOperation(value = "获取内部讲师", tags = {"培训讲师" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainteachers/fetchnbjs")
	public ResponseEntity<List<TrmTrainTeacherDTO>> fetchNBJS(TrmTrainTeacherSearchContext context) {
        Page<TrmTrainTeacher> domains = trmtrainteacherService.searchNBJS(context) ;
        List<TrmTrainTeacherDTO> list = trmtrainteacherMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainTeacher-NBJS-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"培训讲师" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainteachers/searchnbjs")
	public ResponseEntity<Page<TrmTrainTeacherDTO>> searchNBJS(@RequestBody TrmTrainTeacherSearchContext context) {
        Page<TrmTrainTeacher> domains = trmtrainteacherService.searchNBJS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainteacherMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainTeacher-WBJS-all')")
	@ApiOperation(value = "获取外部讲师", tags = {"培训讲师" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainteachers/fetchwbjs")
	public ResponseEntity<List<TrmTrainTeacherDTO>> fetchWBJS(TrmTrainTeacherSearchContext context) {
        Page<TrmTrainTeacher> domains = trmtrainteacherService.searchWBJS(context) ;
        List<TrmTrainTeacherDTO> list = trmtrainteacherMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainTeacher-WBJS-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"培训讲师" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainteachers/searchwbjs")
	public ResponseEntity<Page<TrmTrainTeacherDTO>> searchWBJS(@RequestBody TrmTrainTeacherSearchContext context) {
        Page<TrmTrainTeacher> domains = trmtrainteacherService.searchWBJS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainteacherMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainTeacher-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"培训讲师" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainteachers/fetchdefault")
	public ResponseEntity<List<TrmTrainTeacherDTO>> fetchDefault(TrmTrainTeacherSearchContext context) {
        Page<TrmTrainTeacher> domains = trmtrainteacherService.searchDefault(context) ;
        List<TrmTrainTeacherDTO> list = trmtrainteacherMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainTeacher-Default-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"培训讲师" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainteachers/searchdefault")
	public ResponseEntity<Page<TrmTrainTeacherDTO>> searchDefault(@RequestBody TrmTrainTeacherSearchContext context) {
        Page<TrmTrainTeacher> domains = trmtrainteacherService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtrainteacherMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

