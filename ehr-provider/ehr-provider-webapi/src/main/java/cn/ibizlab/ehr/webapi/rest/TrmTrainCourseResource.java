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
import cn.ibizlab.ehr.core.trm.domain.TrmTrainCourse;
import cn.ibizlab.ehr.core.trm.service.ITrmTrainCourseService;
import cn.ibizlab.ehr.core.trm.filter.TrmTrainCourseSearchContext;

@Slf4j
@Api(tags = {"培训课程" })
@RestController("WebApi-trmtraincourse")
@RequestMapping("")
public class TrmTrainCourseResource {

    @Autowired
    public ITrmTrainCourseService trmtraincourseService;

    @Autowired
    @Lazy
    public TrmTrainCourseMapping trmtraincourseMapping;

    @PostAuthorize("hasPermission(this.trmtraincourseMapping.toDomain(returnObject.body),'ehr-TrmTrainCourse-Get')")
    @ApiOperation(value = "获取培训课程", tags = {"培训课程" },  notes = "获取培训课程")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtraincourses/{trmtraincourse_id}")
    public ResponseEntity<TrmTrainCourseDTO> get(@PathVariable("trmtraincourse_id") String trmtraincourse_id) {
        TrmTrainCourse domain = trmtraincourseService.get(trmtraincourse_id);
        TrmTrainCourseDTO dto = trmtraincourseMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "检查培训课程", tags = {"培训课程" },  notes = "检查培训课程")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraincourses/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmTrainCourseDTO trmtraincoursedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtraincourseService.checkKey(trmtraincourseMapping.toDomain(trmtraincoursedto)));
    }

    @PreAuthorize("hasPermission(this.trmtraincourseService.get(#trmtraincourse_id),'ehr-TrmTrainCourse-Remove')")
    @ApiOperation(value = "删除培训课程", tags = {"培训课程" },  notes = "删除培训课程")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtraincourses/{trmtraincourse_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmtraincourse_id") String trmtraincourse_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmtraincourseService.remove(trmtraincourse_id));
    }

    @PreAuthorize("hasPermission(this.trmtraincourseService.getTrmtraincourseByIds(#ids),'ehr-TrmTrainCourse-Remove')")
    @ApiOperation(value = "批量删除培训课程", tags = {"培训课程" },  notes = "批量删除培训课程")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtraincourses/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmtraincourseService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取培训课程草稿", tags = {"培训课程" },  notes = "获取培训课程草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtraincourses/getdraft")
    public ResponseEntity<TrmTrainCourseDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmtraincourseMapping.toDto(trmtraincourseService.getDraft(new TrmTrainCourse())));
    }

    @PreAuthorize("hasPermission(this.trmtraincourseMapping.toDomain(#trmtraincoursedto),'ehr-TrmTrainCourse-Create')")
    @ApiOperation(value = "新建培训课程", tags = {"培训课程" },  notes = "新建培训课程")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraincourses")
    @Transactional
    public ResponseEntity<TrmTrainCourseDTO> create(@RequestBody TrmTrainCourseDTO trmtraincoursedto) {
        TrmTrainCourse domain = trmtraincourseMapping.toDomain(trmtraincoursedto);
		trmtraincourseService.create(domain);
        TrmTrainCourseDTO dto = trmtraincourseMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtraincourseMapping.toDomain(#trmtraincoursedtos),'ehr-TrmTrainCourse-Create')")
    @ApiOperation(value = "批量新建培训课程", tags = {"培训课程" },  notes = "批量新建培训课程")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraincourses/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmTrainCourseDTO> trmtraincoursedtos) {
        trmtraincourseService.createBatch(trmtraincourseMapping.toDomain(trmtraincoursedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtraincourseService.get(#trmtraincourse_id),'ehr-TrmTrainCourse-Update')")
    @ApiOperation(value = "更新培训课程", tags = {"培训课程" },  notes = "更新培训课程")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtraincourses/{trmtraincourse_id}")
    @Transactional
    public ResponseEntity<TrmTrainCourseDTO> update(@PathVariable("trmtraincourse_id") String trmtraincourse_id, @RequestBody TrmTrainCourseDTO trmtraincoursedto) {
		TrmTrainCourse domain  = trmtraincourseMapping.toDomain(trmtraincoursedto);
        domain .setTrmtraincourseid(trmtraincourse_id);
		trmtraincourseService.update(domain );
		TrmTrainCourseDTO dto = trmtraincourseMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtraincourseService.getTrmtraincourseByEntities(this.trmtraincourseMapping.toDomain(#trmtraincoursedtos)),'ehr-TrmTrainCourse-Update')")
    @ApiOperation(value = "批量更新培训课程", tags = {"培训课程" },  notes = "批量更新培训课程")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtraincourses/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmTrainCourseDTO> trmtraincoursedtos) {
        trmtraincourseService.updateBatch(trmtraincourseMapping.toDomain(trmtraincoursedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtraincourseMapping.toDomain(#trmtraincoursedto),'ehr-TrmTrainCourse-Save')")
    @ApiOperation(value = "保存培训课程", tags = {"培训课程" },  notes = "保存培训课程")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraincourses/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmTrainCourseDTO trmtraincoursedto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmtraincourseService.save(trmtraincourseMapping.toDomain(trmtraincoursedto)));
    }

    @PreAuthorize("hasPermission(this.trmtraincourseMapping.toDomain(#trmtraincoursedtos),'ehr-TrmTrainCourse-Save')")
    @ApiOperation(value = "批量保存培训课程", tags = {"培训课程" },  notes = "批量保存培训课程")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtraincourses/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmTrainCourseDTO> trmtraincoursedtos) {
        trmtraincourseService.saveBatch(trmtraincourseMapping.toDomain(trmtraincoursedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainCourse-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"培训课程" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtraincourses/fetchdefault")
	public ResponseEntity<List<TrmTrainCourseDTO>> fetchDefault(TrmTrainCourseSearchContext context) {
        Page<TrmTrainCourse> domains = trmtraincourseService.searchDefault(context) ;
        List<TrmTrainCourseDTO> list = trmtraincourseMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainCourse-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"培训课程" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtraincourses/searchdefault")
	public ResponseEntity<Page<TrmTrainCourseDTO>> searchDefault(@RequestBody TrmTrainCourseSearchContext context) {
        Page<TrmTrainCourse> domains = trmtraincourseService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtraincourseMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.trmtraincourseMapping.toDomain(returnObject.body),'ehr-TrmTrainCourse-Get')")
    @ApiOperation(value = "根据培训模块获取培训课程", tags = {"培训课程" },  notes = "根据培训模块获取培训课程")
	@RequestMapping(method = RequestMethod.GET, value = "/trmcoursesystems/{trmcoursesystem_id}/trmtraincourses/{trmtraincourse_id}")
    public ResponseEntity<TrmTrainCourseDTO> getByTrmCourseSystem(@PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @PathVariable("trmtraincourse_id") String trmtraincourse_id) {
        TrmTrainCourse domain = trmtraincourseService.get(trmtraincourse_id);
        TrmTrainCourseDTO dto = trmtraincourseMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据培训模块检查培训课程", tags = {"培训课程" },  notes = "根据培训模块检查培训课程")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcoursesystems/{trmcoursesystem_id}/trmtraincourses/checkkey")
    public ResponseEntity<Boolean> checkKeyByTrmCourseSystem(@PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @RequestBody TrmTrainCourseDTO trmtraincoursedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtraincourseService.checkKey(trmtraincourseMapping.toDomain(trmtraincoursedto)));
    }

    @PreAuthorize("hasPermission(this.trmtraincourseService.get(#trmtraincourse_id),'ehr-TrmTrainCourse-Remove')")
    @ApiOperation(value = "根据培训模块删除培训课程", tags = {"培训课程" },  notes = "根据培训模块删除培训课程")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmcoursesystems/{trmcoursesystem_id}/trmtraincourses/{trmtraincourse_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByTrmCourseSystem(@PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @PathVariable("trmtraincourse_id") String trmtraincourse_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmtraincourseService.remove(trmtraincourse_id));
    }

    @PreAuthorize("hasPermission(this.trmtraincourseService.getTrmtraincourseByIds(#ids),'ehr-TrmTrainCourse-Remove')")
    @ApiOperation(value = "根据培训模块批量删除培训课程", tags = {"培训课程" },  notes = "根据培训模块批量删除培训课程")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmcoursesystems/{trmcoursesystem_id}/trmtraincourses/batch")
    public ResponseEntity<Boolean> removeBatchByTrmCourseSystem(@RequestBody List<String> ids) {
        trmtraincourseService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据培训模块获取培训课程草稿", tags = {"培训课程" },  notes = "根据培训模块获取培训课程草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/trmcoursesystems/{trmcoursesystem_id}/trmtraincourses/getdraft")
    public ResponseEntity<TrmTrainCourseDTO> getDraftByTrmCourseSystem(@PathVariable("trmcoursesystem_id") String trmcoursesystem_id) {
        TrmTrainCourse domain = new TrmTrainCourse();
        domain.setTrmcoursesystemid(trmcoursesystem_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtraincourseMapping.toDto(trmtraincourseService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.trmtraincourseMapping.toDomain(#trmtraincoursedto),'ehr-TrmTrainCourse-Create')")
    @ApiOperation(value = "根据培训模块建立培训课程", tags = {"培训课程" },  notes = "根据培训模块建立培训课程")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcoursesystems/{trmcoursesystem_id}/trmtraincourses")
    @Transactional
    public ResponseEntity<TrmTrainCourseDTO> createByTrmCourseSystem(@PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @RequestBody TrmTrainCourseDTO trmtraincoursedto) {
        TrmTrainCourse domain = trmtraincourseMapping.toDomain(trmtraincoursedto);
        domain.setTrmcoursesystemid(trmcoursesystem_id);
		trmtraincourseService.create(domain);
        TrmTrainCourseDTO dto = trmtraincourseMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtraincourseMapping.toDomain(#trmtraincoursedtos),'ehr-TrmTrainCourse-Create')")
    @ApiOperation(value = "根据培训模块批量建立培训课程", tags = {"培训课程" },  notes = "根据培训模块批量建立培训课程")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcoursesystems/{trmcoursesystem_id}/trmtraincourses/batch")
    public ResponseEntity<Boolean> createBatchByTrmCourseSystem(@PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @RequestBody List<TrmTrainCourseDTO> trmtraincoursedtos) {
        List<TrmTrainCourse> domainlist=trmtraincourseMapping.toDomain(trmtraincoursedtos);
        for(TrmTrainCourse domain:domainlist){
            domain.setTrmcoursesystemid(trmcoursesystem_id);
        }
        trmtraincourseService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtraincourseService.get(#trmtraincourse_id),'ehr-TrmTrainCourse-Update')")
    @ApiOperation(value = "根据培训模块更新培训课程", tags = {"培训课程" },  notes = "根据培训模块更新培训课程")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmcoursesystems/{trmcoursesystem_id}/trmtraincourses/{trmtraincourse_id}")
    @Transactional
    public ResponseEntity<TrmTrainCourseDTO> updateByTrmCourseSystem(@PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @PathVariable("trmtraincourse_id") String trmtraincourse_id, @RequestBody TrmTrainCourseDTO trmtraincoursedto) {
        TrmTrainCourse domain = trmtraincourseMapping.toDomain(trmtraincoursedto);
        domain.setTrmcoursesystemid(trmcoursesystem_id);
        domain.setTrmtraincourseid(trmtraincourse_id);
		trmtraincourseService.update(domain);
        TrmTrainCourseDTO dto = trmtraincourseMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtraincourseService.getTrmtraincourseByEntities(this.trmtraincourseMapping.toDomain(#trmtraincoursedtos)),'ehr-TrmTrainCourse-Update')")
    @ApiOperation(value = "根据培训模块批量更新培训课程", tags = {"培训课程" },  notes = "根据培训模块批量更新培训课程")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmcoursesystems/{trmcoursesystem_id}/trmtraincourses/batch")
    public ResponseEntity<Boolean> updateBatchByTrmCourseSystem(@PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @RequestBody List<TrmTrainCourseDTO> trmtraincoursedtos) {
        List<TrmTrainCourse> domainlist=trmtraincourseMapping.toDomain(trmtraincoursedtos);
        for(TrmTrainCourse domain:domainlist){
            domain.setTrmcoursesystemid(trmcoursesystem_id);
        }
        trmtraincourseService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtraincourseMapping.toDomain(#trmtraincoursedto),'ehr-TrmTrainCourse-Save')")
    @ApiOperation(value = "根据培训模块保存培训课程", tags = {"培训课程" },  notes = "根据培训模块保存培训课程")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcoursesystems/{trmcoursesystem_id}/trmtraincourses/save")
    public ResponseEntity<Boolean> saveByTrmCourseSystem(@PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @RequestBody TrmTrainCourseDTO trmtraincoursedto) {
        TrmTrainCourse domain = trmtraincourseMapping.toDomain(trmtraincoursedto);
        domain.setTrmcoursesystemid(trmcoursesystem_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtraincourseService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmtraincourseMapping.toDomain(#trmtraincoursedtos),'ehr-TrmTrainCourse-Save')")
    @ApiOperation(value = "根据培训模块批量保存培训课程", tags = {"培训课程" },  notes = "根据培训模块批量保存培训课程")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcoursesystems/{trmcoursesystem_id}/trmtraincourses/savebatch")
    public ResponseEntity<Boolean> saveBatchByTrmCourseSystem(@PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @RequestBody List<TrmTrainCourseDTO> trmtraincoursedtos) {
        List<TrmTrainCourse> domainlist=trmtraincourseMapping.toDomain(trmtraincoursedtos);
        for(TrmTrainCourse domain:domainlist){
             domain.setTrmcoursesystemid(trmcoursesystem_id);
        }
        trmtraincourseService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainCourse-Default-all')")
	@ApiOperation(value = "根据培训模块获取DEFAULT", tags = {"培训课程" } ,notes = "根据培训模块获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmcoursesystems/{trmcoursesystem_id}/trmtraincourses/fetchdefault")
	public ResponseEntity<List<TrmTrainCourseDTO>> fetchTrmTrainCourseDefaultByTrmCourseSystem(@PathVariable("trmcoursesystem_id") String trmcoursesystem_id,TrmTrainCourseSearchContext context) {
        context.setN_trmcoursesystemid_eq(trmcoursesystem_id);
        Page<TrmTrainCourse> domains = trmtraincourseService.searchDefault(context) ;
        List<TrmTrainCourseDTO> list = trmtraincourseMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainCourse-Default-all')")
	@ApiOperation(value = "根据培训模块查询DEFAULT", tags = {"培训课程" } ,notes = "根据培训模块查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmcoursesystems/{trmcoursesystem_id}/trmtraincourses/searchdefault")
	public ResponseEntity<Page<TrmTrainCourseDTO>> searchTrmTrainCourseDefaultByTrmCourseSystem(@PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @RequestBody TrmTrainCourseSearchContext context) {
        context.setN_trmcoursesystemid_eq(trmcoursesystem_id);
        Page<TrmTrainCourse> domains = trmtraincourseService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtraincourseMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.trmtraincourseMapping.toDomain(returnObject.body),'ehr-TrmTrainCourse-Get')")
    @ApiOperation(value = "根据培训机构培训模块获取培训课程", tags = {"培训课程" },  notes = "根据培训机构培训模块获取培训课程")
	@RequestMapping(method = RequestMethod.GET, value = "/trmtrainagencies/{trmtrainagency_id}/trmcoursesystems/{trmcoursesystem_id}/trmtraincourses/{trmtraincourse_id}")
    public ResponseEntity<TrmTrainCourseDTO> getByTrmTrainAgencyTrmCourseSystem(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @PathVariable("trmtraincourse_id") String trmtraincourse_id) {
        TrmTrainCourse domain = trmtraincourseService.get(trmtraincourse_id);
        TrmTrainCourseDTO dto = trmtraincourseMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据培训机构培训模块检查培训课程", tags = {"培训课程" },  notes = "根据培训机构培训模块检查培训课程")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmcoursesystems/{trmcoursesystem_id}/trmtraincourses/checkkey")
    public ResponseEntity<Boolean> checkKeyByTrmTrainAgencyTrmCourseSystem(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @RequestBody TrmTrainCourseDTO trmtraincoursedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmtraincourseService.checkKey(trmtraincourseMapping.toDomain(trmtraincoursedto)));
    }

    @PreAuthorize("hasPermission(this.trmtraincourseService.get(#trmtraincourse_id),'ehr-TrmTrainCourse-Remove')")
    @ApiOperation(value = "根据培训机构培训模块删除培训课程", tags = {"培训课程" },  notes = "根据培训机构培训模块删除培训课程")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainagencies/{trmtrainagency_id}/trmcoursesystems/{trmcoursesystem_id}/trmtraincourses/{trmtraincourse_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByTrmTrainAgencyTrmCourseSystem(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @PathVariable("trmtraincourse_id") String trmtraincourse_id) {
		return ResponseEntity.status(HttpStatus.OK).body(trmtraincourseService.remove(trmtraincourse_id));
    }

    @PreAuthorize("hasPermission(this.trmtraincourseService.getTrmtraincourseByIds(#ids),'ehr-TrmTrainCourse-Remove')")
    @ApiOperation(value = "根据培训机构培训模块批量删除培训课程", tags = {"培训课程" },  notes = "根据培训机构培训模块批量删除培训课程")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmtrainagencies/{trmtrainagency_id}/trmcoursesystems/{trmcoursesystem_id}/trmtraincourses/batch")
    public ResponseEntity<Boolean> removeBatchByTrmTrainAgencyTrmCourseSystem(@RequestBody List<String> ids) {
        trmtraincourseService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据培训机构培训模块获取培训课程草稿", tags = {"培训课程" },  notes = "根据培训机构培训模块获取培训课程草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/trmtrainagencies/{trmtrainagency_id}/trmcoursesystems/{trmcoursesystem_id}/trmtraincourses/getdraft")
    public ResponseEntity<TrmTrainCourseDTO> getDraftByTrmTrainAgencyTrmCourseSystem(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmcoursesystem_id") String trmcoursesystem_id) {
        TrmTrainCourse domain = new TrmTrainCourse();
        domain.setTrmcoursesystemid(trmcoursesystem_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtraincourseMapping.toDto(trmtraincourseService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.trmtraincourseMapping.toDomain(#trmtraincoursedto),'ehr-TrmTrainCourse-Create')")
    @ApiOperation(value = "根据培训机构培训模块建立培训课程", tags = {"培训课程" },  notes = "根据培训机构培训模块建立培训课程")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmcoursesystems/{trmcoursesystem_id}/trmtraincourses")
    @Transactional
    public ResponseEntity<TrmTrainCourseDTO> createByTrmTrainAgencyTrmCourseSystem(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @RequestBody TrmTrainCourseDTO trmtraincoursedto) {
        TrmTrainCourse domain = trmtraincourseMapping.toDomain(trmtraincoursedto);
        domain.setTrmcoursesystemid(trmcoursesystem_id);
		trmtraincourseService.create(domain);
        TrmTrainCourseDTO dto = trmtraincourseMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtraincourseMapping.toDomain(#trmtraincoursedtos),'ehr-TrmTrainCourse-Create')")
    @ApiOperation(value = "根据培训机构培训模块批量建立培训课程", tags = {"培训课程" },  notes = "根据培训机构培训模块批量建立培训课程")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmcoursesystems/{trmcoursesystem_id}/trmtraincourses/batch")
    public ResponseEntity<Boolean> createBatchByTrmTrainAgencyTrmCourseSystem(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @RequestBody List<TrmTrainCourseDTO> trmtraincoursedtos) {
        List<TrmTrainCourse> domainlist=trmtraincourseMapping.toDomain(trmtraincoursedtos);
        for(TrmTrainCourse domain:domainlist){
            domain.setTrmcoursesystemid(trmcoursesystem_id);
        }
        trmtraincourseService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtraincourseService.get(#trmtraincourse_id),'ehr-TrmTrainCourse-Update')")
    @ApiOperation(value = "根据培训机构培训模块更新培训课程", tags = {"培训课程" },  notes = "根据培训机构培训模块更新培训课程")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainagencies/{trmtrainagency_id}/trmcoursesystems/{trmcoursesystem_id}/trmtraincourses/{trmtraincourse_id}")
    @Transactional
    public ResponseEntity<TrmTrainCourseDTO> updateByTrmTrainAgencyTrmCourseSystem(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @PathVariable("trmtraincourse_id") String trmtraincourse_id, @RequestBody TrmTrainCourseDTO trmtraincoursedto) {
        TrmTrainCourse domain = trmtraincourseMapping.toDomain(trmtraincoursedto);
        domain.setTrmcoursesystemid(trmcoursesystem_id);
        domain.setTrmtraincourseid(trmtraincourse_id);
		trmtraincourseService.update(domain);
        TrmTrainCourseDTO dto = trmtraincourseMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmtraincourseService.getTrmtraincourseByEntities(this.trmtraincourseMapping.toDomain(#trmtraincoursedtos)),'ehr-TrmTrainCourse-Update')")
    @ApiOperation(value = "根据培训机构培训模块批量更新培训课程", tags = {"培训课程" },  notes = "根据培训机构培训模块批量更新培训课程")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmtrainagencies/{trmtrainagency_id}/trmcoursesystems/{trmcoursesystem_id}/trmtraincourses/batch")
    public ResponseEntity<Boolean> updateBatchByTrmTrainAgencyTrmCourseSystem(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @RequestBody List<TrmTrainCourseDTO> trmtraincoursedtos) {
        List<TrmTrainCourse> domainlist=trmtraincourseMapping.toDomain(trmtraincoursedtos);
        for(TrmTrainCourse domain:domainlist){
            domain.setTrmcoursesystemid(trmcoursesystem_id);
        }
        trmtraincourseService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmtraincourseMapping.toDomain(#trmtraincoursedto),'ehr-TrmTrainCourse-Save')")
    @ApiOperation(value = "根据培训机构培训模块保存培训课程", tags = {"培训课程" },  notes = "根据培训机构培训模块保存培训课程")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmcoursesystems/{trmcoursesystem_id}/trmtraincourses/save")
    public ResponseEntity<Boolean> saveByTrmTrainAgencyTrmCourseSystem(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @RequestBody TrmTrainCourseDTO trmtraincoursedto) {
        TrmTrainCourse domain = trmtraincourseMapping.toDomain(trmtraincoursedto);
        domain.setTrmcoursesystemid(trmcoursesystem_id);
        return ResponseEntity.status(HttpStatus.OK).body(trmtraincourseService.save(domain));
    }

    @PreAuthorize("hasPermission(this.trmtraincourseMapping.toDomain(#trmtraincoursedtos),'ehr-TrmTrainCourse-Save')")
    @ApiOperation(value = "根据培训机构培训模块批量保存培训课程", tags = {"培训课程" },  notes = "根据培训机构培训模块批量保存培训课程")
	@RequestMapping(method = RequestMethod.POST, value = "/trmtrainagencies/{trmtrainagency_id}/trmcoursesystems/{trmcoursesystem_id}/trmtraincourses/savebatch")
    public ResponseEntity<Boolean> saveBatchByTrmTrainAgencyTrmCourseSystem(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @RequestBody List<TrmTrainCourseDTO> trmtraincoursedtos) {
        List<TrmTrainCourse> domainlist=trmtraincourseMapping.toDomain(trmtraincoursedtos);
        for(TrmTrainCourse domain:domainlist){
             domain.setTrmcoursesystemid(trmcoursesystem_id);
        }
        trmtraincourseService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainCourse-Default-all')")
	@ApiOperation(value = "根据培训机构培训模块获取DEFAULT", tags = {"培训课程" } ,notes = "根据培训机构培训模块获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmtrainagencies/{trmtrainagency_id}/trmcoursesystems/{trmcoursesystem_id}/trmtraincourses/fetchdefault")
	public ResponseEntity<List<TrmTrainCourseDTO>> fetchTrmTrainCourseDefaultByTrmTrainAgencyTrmCourseSystem(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmcoursesystem_id") String trmcoursesystem_id,TrmTrainCourseSearchContext context) {
        context.setN_trmcoursesystemid_eq(trmcoursesystem_id);
        Page<TrmTrainCourse> domains = trmtraincourseService.searchDefault(context) ;
        List<TrmTrainCourseDTO> list = trmtraincourseMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTrainCourse-Default-all')")
	@ApiOperation(value = "根据培训机构培训模块查询DEFAULT", tags = {"培训课程" } ,notes = "根据培训机构培训模块查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmtrainagencies/{trmtrainagency_id}/trmcoursesystems/{trmcoursesystem_id}/trmtraincourses/searchdefault")
	public ResponseEntity<Page<TrmTrainCourseDTO>> searchTrmTrainCourseDefaultByTrmTrainAgencyTrmCourseSystem(@PathVariable("trmtrainagency_id") String trmtrainagency_id, @PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @RequestBody TrmTrainCourseSearchContext context) {
        context.setN_trmcoursesystemid_eq(trmcoursesystem_id);
        Page<TrmTrainCourse> domains = trmtraincourseService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmtraincourseMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

