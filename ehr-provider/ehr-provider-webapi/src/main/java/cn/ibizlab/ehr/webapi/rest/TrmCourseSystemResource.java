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
import cn.ibizlab.ehr.core.trm.domain.TrmCourseSystem;
import cn.ibizlab.ehr.core.trm.service.ITrmCourseSystemService;
import cn.ibizlab.ehr.core.trm.filter.TrmCourseSystemSearchContext;

@Slf4j
@Api(tags = {"培训模块" })
@RestController("WebApi-trmcoursesystem")
@RequestMapping("")
public class TrmCourseSystemResource {

    @Autowired
    public ITrmCourseSystemService trmcoursesystemService;

    @Autowired
    @Lazy
    public TrmCourseSystemMapping trmcoursesystemMapping;

    @PreAuthorize("hasPermission(this.trmcoursesystemService.get(#trmcoursesystem_id),'ehr-TrmCourseSystem-Update')")
    @ApiOperation(value = "更新培训模块", tags = {"培训模块" },  notes = "更新培训模块")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmcoursesystems/{trmcoursesystem_id}")
    @Transactional
    public ResponseEntity<TrmCourseSystemDTO> update(@PathVariable("trmcoursesystem_id") String trmcoursesystem_id, @RequestBody TrmCourseSystemDTO trmcoursesystemdto) {
		TrmCourseSystem domain  = trmcoursesystemMapping.toDomain(trmcoursesystemdto);
        domain .setTrmcoursesystemid(trmcoursesystem_id);
		trmcoursesystemService.update(domain );
		TrmCourseSystemDTO dto = trmcoursesystemMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmcoursesystemService.getTrmcoursesystemByEntities(this.trmcoursesystemMapping.toDomain(#trmcoursesystemdtos)),'ehr-TrmCourseSystem-Update')")
    @ApiOperation(value = "批量更新培训模块", tags = {"培训模块" },  notes = "批量更新培训模块")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmcoursesystems/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmCourseSystemDTO> trmcoursesystemdtos) {
        trmcoursesystemService.updateBatch(trmcoursesystemMapping.toDomain(trmcoursesystemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmcoursesystemMapping.toDomain(#trmcoursesystemdto),'ehr-TrmCourseSystem-Save')")
    @ApiOperation(value = "保存培训模块", tags = {"培训模块" },  notes = "保存培训模块")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcoursesystems/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmCourseSystemDTO trmcoursesystemdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmcoursesystemService.save(trmcoursesystemMapping.toDomain(trmcoursesystemdto)));
    }

    @PreAuthorize("hasPermission(this.trmcoursesystemMapping.toDomain(#trmcoursesystemdtos),'ehr-TrmCourseSystem-Save')")
    @ApiOperation(value = "批量保存培训模块", tags = {"培训模块" },  notes = "批量保存培训模块")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcoursesystems/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmCourseSystemDTO> trmcoursesystemdtos) {
        trmcoursesystemService.saveBatch(trmcoursesystemMapping.toDomain(trmcoursesystemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查培训模块", tags = {"培训模块" },  notes = "检查培训模块")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcoursesystems/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmCourseSystemDTO trmcoursesystemdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmcoursesystemService.checkKey(trmcoursesystemMapping.toDomain(trmcoursesystemdto)));
    }

    @ApiOperation(value = "获取培训模块草稿", tags = {"培训模块" },  notes = "获取培训模块草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmcoursesystems/getdraft")
    public ResponseEntity<TrmCourseSystemDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmcoursesystemMapping.toDto(trmcoursesystemService.getDraft(new TrmCourseSystem())));
    }

    @PostAuthorize("hasPermission(this.trmcoursesystemMapping.toDomain(returnObject.body),'ehr-TrmCourseSystem-Get')")
    @ApiOperation(value = "获取培训模块", tags = {"培训模块" },  notes = "获取培训模块")
	@RequestMapping(method = RequestMethod.GET, value = "/trmcoursesystems/{trmcoursesystem_id}")
    public ResponseEntity<TrmCourseSystemDTO> get(@PathVariable("trmcoursesystem_id") String trmcoursesystem_id) {
        TrmCourseSystem domain = trmcoursesystemService.get(trmcoursesystem_id);
        TrmCourseSystemDTO dto = trmcoursesystemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmcoursesystemService.get(#trmcoursesystem_id),'ehr-TrmCourseSystem-Remove')")
    @ApiOperation(value = "删除培训模块", tags = {"培训模块" },  notes = "删除培训模块")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmcoursesystems/{trmcoursesystem_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmcoursesystem_id") String trmcoursesystem_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmcoursesystemService.remove(trmcoursesystem_id));
    }

    @PreAuthorize("hasPermission(this.trmcoursesystemService.getTrmcoursesystemByIds(#ids),'ehr-TrmCourseSystem-Remove')")
    @ApiOperation(value = "批量删除培训模块", tags = {"培训模块" },  notes = "批量删除培训模块")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmcoursesystems/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmcoursesystemService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmcoursesystemMapping.toDomain(#trmcoursesystemdto),'ehr-TrmCourseSystem-Create')")
    @ApiOperation(value = "新建培训模块", tags = {"培训模块" },  notes = "新建培训模块")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcoursesystems")
    @Transactional
    public ResponseEntity<TrmCourseSystemDTO> create(@RequestBody TrmCourseSystemDTO trmcoursesystemdto) {
        TrmCourseSystem domain = trmcoursesystemMapping.toDomain(trmcoursesystemdto);
		trmcoursesystemService.create(domain);
        TrmCourseSystemDTO dto = trmcoursesystemMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmcoursesystemMapping.toDomain(#trmcoursesystemdtos),'ehr-TrmCourseSystem-Create')")
    @ApiOperation(value = "批量新建培训模块", tags = {"培训模块" },  notes = "批量新建培训模块")
	@RequestMapping(method = RequestMethod.POST, value = "/trmcoursesystems/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmCourseSystemDTO> trmcoursesystemdtos) {
        trmcoursesystemService.createBatch(trmcoursesystemMapping.toDomain(trmcoursesystemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmCourseSystem-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"培训模块" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/trmcoursesystems/fetchdefault")
	public ResponseEntity<List<TrmCourseSystemDTO>> fetchDefault(TrmCourseSystemSearchContext context) {
        Page<TrmCourseSystem> domains = trmcoursesystemService.searchDefault(context) ;
        List<TrmCourseSystemDTO> list = trmcoursesystemMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmCourseSystem-Default-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"培训模块" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/trmcoursesystems/searchdefault")
	public ResponseEntity<Page<TrmCourseSystemDTO>> searchDefault(@RequestBody TrmCourseSystemSearchContext context) {
        Page<TrmCourseSystem> domains = trmcoursesystemService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmcoursesystemMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

