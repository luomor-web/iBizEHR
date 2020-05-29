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
import cn.ibizlab.ehr.core.orm.domain.OrmXmgl;
import cn.ibizlab.ehr.core.orm.service.IOrmXmglService;
import cn.ibizlab.ehr.core.orm.filter.OrmXmglSearchContext;

@Slf4j
@Api(tags = {"项目管理" })
@RestController("WebApi-ormxmgl")
@RequestMapping("")
public class OrmXmglResource {

    @Autowired
    public IOrmXmglService ormxmglService;

    @Autowired
    @Lazy
    public OrmXmglMapping ormxmglMapping;

    @PostAuthorize("hasPermission(this.ormxmglMapping.toDomain(returnObject.body),'ehr-OrmXmgl-Get')")
    @ApiOperation(value = "获取项目管理", tags = {"项目管理" },  notes = "获取项目管理")
	@RequestMapping(method = RequestMethod.GET, value = "/ormxmgls/{ormxmgl_id}")
    public ResponseEntity<OrmXmglDTO> get(@PathVariable("ormxmgl_id") String ormxmgl_id) {
        OrmXmgl domain = ormxmglService.get(ormxmgl_id);
        OrmXmglDTO dto = ormxmglMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "检查项目管理", tags = {"项目管理" },  notes = "检查项目管理")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmgls/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrmXmglDTO ormxmgldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormxmglService.checkKey(ormxmglMapping.toDomain(ormxmgldto)));
    }

    @ApiOperation(value = "获取项目管理草稿", tags = {"项目管理" },  notes = "获取项目管理草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/ormxmgls/getdraft")
    public ResponseEntity<OrmXmglDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormxmglMapping.toDto(ormxmglService.getDraft(new OrmXmgl())));
    }

    @PreAuthorize("hasPermission(this.ormxmglService.get(#ormxmgl_id),'ehr-OrmXmgl-Update')")
    @ApiOperation(value = "更新项目管理", tags = {"项目管理" },  notes = "更新项目管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormxmgls/{ormxmgl_id}")
    @Transactional
    public ResponseEntity<OrmXmglDTO> update(@PathVariable("ormxmgl_id") String ormxmgl_id, @RequestBody OrmXmglDTO ormxmgldto) {
		OrmXmgl domain  = ormxmglMapping.toDomain(ormxmgldto);
        domain .setOrmxmglid(ormxmgl_id);
		ormxmglService.update(domain );
		OrmXmglDTO dto = ormxmglMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmglService.getOrmxmglByEntities(this.ormxmglMapping.toDomain(#ormxmgldtos)),'ehr-OrmXmgl-Update')")
    @ApiOperation(value = "批量更新项目管理", tags = {"项目管理" },  notes = "批量更新项目管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormxmgls/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrmXmglDTO> ormxmgldtos) {
        ormxmglService.updateBatch(ormxmglMapping.toDomain(ormxmgldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormxmglMapping.toDomain(#ormxmgldto),'ehr-OrmXmgl-Create')")
    @ApiOperation(value = "新建项目管理", tags = {"项目管理" },  notes = "新建项目管理")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmgls")
    @Transactional
    public ResponseEntity<OrmXmglDTO> create(@RequestBody OrmXmglDTO ormxmgldto) {
        OrmXmgl domain = ormxmglMapping.toDomain(ormxmgldto);
		ormxmglService.create(domain);
        OrmXmglDTO dto = ormxmglMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmglMapping.toDomain(#ormxmgldtos),'ehr-OrmXmgl-Create')")
    @ApiOperation(value = "批量新建项目管理", tags = {"项目管理" },  notes = "批量新建项目管理")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmgls/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrmXmglDTO> ormxmgldtos) {
        ormxmglService.createBatch(ormxmglMapping.toDomain(ormxmgldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormxmglService.get(#ormxmgl_id),'ehr-OrmXmgl-Remove')")
    @ApiOperation(value = "删除项目管理", tags = {"项目管理" },  notes = "删除项目管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormxmgls/{ormxmgl_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormxmgl_id") String ormxmgl_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormxmglService.remove(ormxmgl_id));
    }

    @PreAuthorize("hasPermission(this.ormxmglService.getOrmxmglByIds(#ids),'ehr-OrmXmgl-Remove')")
    @ApiOperation(value = "批量删除项目管理", tags = {"项目管理" },  notes = "批量删除项目管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormxmgls/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormxmglService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmgl-Synchro-all')")
    @ApiOperation(value = "同步项目信息", tags = {"项目管理" },  notes = "同步项目信息")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmgls/{ormxmgl_id}/synchro")
    @Transactional
    public ResponseEntity<OrmXmglDTO> synchro(@PathVariable("ormxmgl_id") String ormxmgl_id, @RequestBody OrmXmglDTO ormxmgldto) {
        OrmXmgl ormxmgl = ormxmglMapping.toDomain(ormxmgldto);
        ormxmgl.setOrmxmglid(ormxmgl_id);
        ormxmgl = ormxmglService.synchro(ormxmgl);
        ormxmgldto = ormxmglMapping.toDto(ormxmgl);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmgldto);
    }

    @PreAuthorize("hasPermission(this.ormxmglMapping.toDomain(#ormxmgldto),'ehr-OrmXmgl-Save')")
    @ApiOperation(value = "保存项目管理", tags = {"项目管理" },  notes = "保存项目管理")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmgls/save")
    public ResponseEntity<Boolean> save(@RequestBody OrmXmglDTO ormxmgldto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormxmglService.save(ormxmglMapping.toDomain(ormxmgldto)));
    }

    @PreAuthorize("hasPermission(this.ormxmglMapping.toDomain(#ormxmgldtos),'ehr-OrmXmgl-Save')")
    @ApiOperation(value = "批量保存项目管理", tags = {"项目管理" },  notes = "批量保存项目管理")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmgls/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrmXmglDTO> ormxmgldtos) {
        ormxmglService.saveBatch(ormxmglMapping.toDomain(ormxmgldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmgl-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"项目管理" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmgls/fetchdefault")
	public ResponseEntity<List<OrmXmglDTO>> fetchDefault(OrmXmglSearchContext context) {
        Page<OrmXmgl> domains = ormxmglService.searchDefault(context) ;
        List<OrmXmglDTO> list = ormxmglMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmgl-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"项目管理" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmgls/searchdefault")
	public ResponseEntity<Page<OrmXmglDTO>> searchDefault(@RequestBody OrmXmglSearchContext context) {
        Page<OrmXmgl> domains = ormxmglService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmglMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmgl-ValidPro-all')")
	@ApiOperation(value = "获取有效项目", tags = {"项目管理" } ,notes = "获取有效项目")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmgls/fetchvalidpro")
	public ResponseEntity<List<OrmXmglDTO>> fetchValidPro(OrmXmglSearchContext context) {
        Page<OrmXmgl> domains = ormxmglService.searchValidPro(context) ;
        List<OrmXmglDTO> list = ormxmglMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmgl-ValidPro-all')")
	@ApiOperation(value = "查询有效项目", tags = {"项目管理" } ,notes = "查询有效项目")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmgls/searchvalidpro")
	public ResponseEntity<Page<OrmXmglDTO>> searchValidPro(@RequestBody OrmXmglSearchContext context) {
        Page<OrmXmgl> domains = ormxmglService.searchValidPro(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmglMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

