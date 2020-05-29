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
import cn.ibizlab.ehr.core.orm.domain.ORMXMXQJH;
import cn.ibizlab.ehr.core.orm.service.IORMXMXQJHService;
import cn.ibizlab.ehr.core.orm.filter.ORMXMXQJHSearchContext;

@Slf4j
@Api(tags = {"项目需求计划" })
@RestController("WebApi-ormxmxqjh")
@RequestMapping("")
public class ORMXMXQJHResource {

    @Autowired
    public IORMXMXQJHService ormxmxqjhService;

    @Autowired
    @Lazy
    public ORMXMXQJHMapping ormxmxqjhMapping;

    @PostAuthorize("hasPermission(this.ormxmxqjhMapping.toDomain(returnObject.body),'ehr-ORMXMXQJH-Get')")
    @ApiOperation(value = "获取项目需求计划", tags = {"项目需求计划" },  notes = "获取项目需求计划")
	@RequestMapping(method = RequestMethod.GET, value = "/ormxmxqjhs/{ormxmxqjh_id}")
    public ResponseEntity<ORMXMXQJHDTO> get(@PathVariable("ormxmxqjh_id") String ormxmxqjh_id) {
        ORMXMXQJH domain = ormxmxqjhService.get(ormxmxqjh_id);
        ORMXMXQJHDTO dto = ormxmxqjhMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取项目需求计划草稿", tags = {"项目需求计划" },  notes = "获取项目需求计划草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/ormxmxqjhs/getdraft")
    public ResponseEntity<ORMXMXQJHDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormxmxqjhMapping.toDto(ormxmxqjhService.getDraft(new ORMXMXQJH())));
    }

    @PreAuthorize("hasPermission(this.ormxmxqjhMapping.toDomain(#ormxmxqjhdto),'ehr-ORMXMXQJH-Save')")
    @ApiOperation(value = "保存项目需求计划", tags = {"项目需求计划" },  notes = "保存项目需求计划")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmxqjhs/save")
    public ResponseEntity<Boolean> save(@RequestBody ORMXMXQJHDTO ormxmxqjhdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormxmxqjhService.save(ormxmxqjhMapping.toDomain(ormxmxqjhdto)));
    }

    @PreAuthorize("hasPermission(this.ormxmxqjhMapping.toDomain(#ormxmxqjhdtos),'ehr-ORMXMXQJH-Save')")
    @ApiOperation(value = "批量保存项目需求计划", tags = {"项目需求计划" },  notes = "批量保存项目需求计划")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmxqjhs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ORMXMXQJHDTO> ormxmxqjhdtos) {
        ormxmxqjhService.saveBatch(ormxmxqjhMapping.toDomain(ormxmxqjhdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMXQJH-TJ-all')")
    @ApiOperation(value = "提交需求计划", tags = {"项目需求计划" },  notes = "提交需求计划")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmxqjhs/{ormxmxqjh_id}/tj")
    @Transactional
    public ResponseEntity<ORMXMXQJHDTO> tJ(@PathVariable("ormxmxqjh_id") String ormxmxqjh_id, @RequestBody ORMXMXQJHDTO ormxmxqjhdto) {
        ORMXMXQJH ormxmxqjh = ormxmxqjhMapping.toDomain(ormxmxqjhdto);
        ormxmxqjh.setOrmxmxqjhid(ormxmxqjh_id);
        ormxmxqjh = ormxmxqjhService.tJ(ormxmxqjh);
        ormxmxqjhdto = ormxmxqjhMapping.toDto(ormxmxqjh);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmxqjhdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMXQJH-CLWC-all')")
    @ApiOperation(value = "审批通过", tags = {"项目需求计划" },  notes = "审批通过")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmxqjhs/{ormxmxqjh_id}/clwc")
    @Transactional
    public ResponseEntity<ORMXMXQJHDTO> cLWC(@PathVariable("ormxmxqjh_id") String ormxmxqjh_id, @RequestBody ORMXMXQJHDTO ormxmxqjhdto) {
        ORMXMXQJH ormxmxqjh = ormxmxqjhMapping.toDomain(ormxmxqjhdto);
        ormxmxqjh.setOrmxmxqjhid(ormxmxqjh_id);
        ormxmxqjh = ormxmxqjhService.cLWC(ormxmxqjh);
        ormxmxqjhdto = ormxmxqjhMapping.toDto(ormxmxqjh);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmxqjhdto);
    }

    @PreAuthorize("hasPermission(this.ormxmxqjhService.get(#ormxmxqjh_id),'ehr-ORMXMXQJH-Update')")
    @ApiOperation(value = "更新项目需求计划", tags = {"项目需求计划" },  notes = "更新项目需求计划")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormxmxqjhs/{ormxmxqjh_id}")
    @Transactional
    public ResponseEntity<ORMXMXQJHDTO> update(@PathVariable("ormxmxqjh_id") String ormxmxqjh_id, @RequestBody ORMXMXQJHDTO ormxmxqjhdto) {
		ORMXMXQJH domain  = ormxmxqjhMapping.toDomain(ormxmxqjhdto);
        domain .setOrmxmxqjhid(ormxmxqjh_id);
		ormxmxqjhService.update(domain );
		ORMXMXQJHDTO dto = ormxmxqjhMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmxqjhService.getOrmxmxqjhByEntities(this.ormxmxqjhMapping.toDomain(#ormxmxqjhdtos)),'ehr-ORMXMXQJH-Update')")
    @ApiOperation(value = "批量更新项目需求计划", tags = {"项目需求计划" },  notes = "批量更新项目需求计划")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormxmxqjhs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ORMXMXQJHDTO> ormxmxqjhdtos) {
        ormxmxqjhService.updateBatch(ormxmxqjhMapping.toDomain(ormxmxqjhdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormxmxqjhMapping.toDomain(#ormxmxqjhdto),'ehr-ORMXMXQJH-Create')")
    @ApiOperation(value = "新建项目需求计划", tags = {"项目需求计划" },  notes = "新建项目需求计划")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmxqjhs")
    @Transactional
    public ResponseEntity<ORMXMXQJHDTO> create(@RequestBody ORMXMXQJHDTO ormxmxqjhdto) {
        ORMXMXQJH domain = ormxmxqjhMapping.toDomain(ormxmxqjhdto);
		ormxmxqjhService.create(domain);
        ORMXMXQJHDTO dto = ormxmxqjhMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmxqjhMapping.toDomain(#ormxmxqjhdtos),'ehr-ORMXMXQJH-Create')")
    @ApiOperation(value = "批量新建项目需求计划", tags = {"项目需求计划" },  notes = "批量新建项目需求计划")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmxqjhs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ORMXMXQJHDTO> ormxmxqjhdtos) {
        ormxmxqjhService.createBatch(ormxmxqjhMapping.toDomain(ormxmxqjhdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMXQJH-SHBTG-all')")
    @ApiOperation(value = "审批不通过", tags = {"项目需求计划" },  notes = "审批不通过")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmxqjhs/{ormxmxqjh_id}/shbtg")
    @Transactional
    public ResponseEntity<ORMXMXQJHDTO> sHBTG(@PathVariable("ormxmxqjh_id") String ormxmxqjh_id, @RequestBody ORMXMXQJHDTO ormxmxqjhdto) {
        ORMXMXQJH ormxmxqjh = ormxmxqjhMapping.toDomain(ormxmxqjhdto);
        ormxmxqjh.setOrmxmxqjhid(ormxmxqjh_id);
        ormxmxqjh = ormxmxqjhService.sHBTG(ormxmxqjh);
        ormxmxqjhdto = ormxmxqjhMapping.toDto(ormxmxqjh);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmxqjhdto);
    }

    @ApiOperation(value = "检查项目需求计划", tags = {"项目需求计划" },  notes = "检查项目需求计划")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmxqjhs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ORMXMXQJHDTO ormxmxqjhdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormxmxqjhService.checkKey(ormxmxqjhMapping.toDomain(ormxmxqjhdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMXQJH-Ensure-all')")
    @ApiOperation(value = "确认", tags = {"项目需求计划" },  notes = "确认")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmxqjhs/{ormxmxqjh_id}/ensure")
    @Transactional
    public ResponseEntity<ORMXMXQJHDTO> ensure(@PathVariable("ormxmxqjh_id") String ormxmxqjh_id, @RequestBody ORMXMXQJHDTO ormxmxqjhdto) {
        ORMXMXQJH ormxmxqjh = ormxmxqjhMapping.toDomain(ormxmxqjhdto);
        ormxmxqjh.setOrmxmxqjhid(ormxmxqjh_id);
        ormxmxqjh = ormxmxqjhService.ensure(ormxmxqjh);
        ormxmxqjhdto = ormxmxqjhMapping.toDto(ormxmxqjh);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmxqjhdto);
    }

    @PreAuthorize("hasPermission(this.ormxmxqjhService.get(#ormxmxqjh_id),'ehr-ORMXMXQJH-Remove')")
    @ApiOperation(value = "删除项目需求计划", tags = {"项目需求计划" },  notes = "删除项目需求计划")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormxmxqjhs/{ormxmxqjh_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormxmxqjh_id") String ormxmxqjh_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormxmxqjhService.remove(ormxmxqjh_id));
    }

    @PreAuthorize("hasPermission(this.ormxmxqjhService.getOrmxmxqjhByIds(#ids),'ehr-ORMXMXQJH-Remove')")
    @ApiOperation(value = "批量删除项目需求计划", tags = {"项目需求计划" },  notes = "批量删除项目需求计划")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormxmxqjhs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormxmxqjhService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMXQJH-BaseInfo-all')")
	@ApiOperation(value = "获取项目人力需求（项目负责人）", tags = {"项目需求计划" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmxqjhs/fetchbaseinfo")
	public ResponseEntity<List<ORMXMXQJHDTO>> fetchBaseInfo(ORMXMXQJHSearchContext context) {
        Page<ORMXMXQJH> domains = ormxmxqjhService.searchBaseInfo(context) ;
        List<ORMXMXQJHDTO> list = ormxmxqjhMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMXQJH-BaseInfo-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"项目需求计划" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmxqjhs/searchbaseinfo")
	public ResponseEntity<Page<ORMXMXQJHDTO>> searchBaseInfo(@RequestBody ORMXMXQJHSearchContext context) {
        Page<ORMXMXQJH> domains = ormxmxqjhService.searchBaseInfo(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmxqjhMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMXQJH-XMTJQX-all')")
	@ApiOperation(value = "获取项目人力需求（保存、提交权限）", tags = {"项目需求计划" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmxqjhs/fetchxmtjqx")
	public ResponseEntity<List<ORMXMXQJHDTO>> fetchXMTJQX(ORMXMXQJHSearchContext context) {
        Page<ORMXMXQJH> domains = ormxmxqjhService.searchXMTJQX(context) ;
        List<ORMXMXQJHDTO> list = ormxmxqjhMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMXQJH-XMTJQX-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"项目需求计划" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmxqjhs/searchxmtjqx")
	public ResponseEntity<Page<ORMXMXQJHDTO>> searchXMTJQX(@RequestBody ORMXMXQJHSearchContext context) {
        Page<ORMXMXQJH> domains = ormxmxqjhService.searchXMTJQX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmxqjhMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMXQJH-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"项目需求计划" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmxqjhs/fetchdefault")
	public ResponseEntity<List<ORMXMXQJHDTO>> fetchDefault(ORMXMXQJHSearchContext context) {
        Page<ORMXMXQJH> domains = ormxmxqjhService.searchDefault(context) ;
        List<ORMXMXQJHDTO> list = ormxmxqjhMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMXQJH-Default-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"项目需求计划" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmxqjhs/searchdefault")
	public ResponseEntity<Page<ORMXMXQJHDTO>> searchDefault(@RequestBody ORMXMXQJHSearchContext context) {
        Page<ORMXMXQJH> domains = ormxmxqjhService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmxqjhMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMXQJH-RsshInfo-all')")
	@ApiOperation(value = "获取项目人力需求（人力审核）", tags = {"项目需求计划" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmxqjhs/fetchrsshinfo")
	public ResponseEntity<List<ORMXMXQJHDTO>> fetchRsshInfo(ORMXMXQJHSearchContext context) {
        Page<ORMXMXQJH> domains = ormxmxqjhService.searchRsshInfo(context) ;
        List<ORMXMXQJHDTO> list = ormxmxqjhMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMXQJH-RsshInfo-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"项目需求计划" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmxqjhs/searchrsshinfo")
	public ResponseEntity<Page<ORMXMXQJHDTO>> searchRsshInfo(@RequestBody ORMXMXQJHSearchContext context) {
        Page<ORMXMXQJH> domains = ormxmxqjhService.searchRsshInfo(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmxqjhMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

