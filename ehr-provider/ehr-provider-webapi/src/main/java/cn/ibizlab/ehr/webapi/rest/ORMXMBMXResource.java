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
import cn.ibizlab.ehr.core.orm.domain.ORMXMBMX;
import cn.ibizlab.ehr.core.orm.service.IORMXMBMXService;
import cn.ibizlab.ehr.core.orm.filter.ORMXMBMXSearchContext;

@Slf4j
@Api(tags = {"项目部明细" })
@RestController("WebApi-ormxmbmx")
@RequestMapping("")
public class ORMXMBMXResource {

    @Autowired
    public IORMXMBMXService ormxmbmxService;

    @Autowired
    @Lazy
    public ORMXMBMXMapping ormxmbmxMapping;

    @PreAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(#ormxmbmxdto),'ehr-ORMXMBMX-Save')")
    @ApiOperation(value = "保存项目部明细", tags = {"项目部明细" },  notes = "保存项目部明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody ORMXMBMXDTO ormxmbmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.save(ormxmbmxMapping.toDomain(ormxmbmxdto)));
    }

    @PreAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(#ormxmbmxdtos),'ehr-ORMXMBMX-Save')")
    @ApiOperation(value = "批量保存项目部明细", tags = {"项目部明细" },  notes = "批量保存项目部明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        ormxmbmxService.saveBatch(ormxmbmxMapping.toDomain(ormxmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取项目部明细草稿", tags = {"项目部明细" },  notes = "获取项目部明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/ormxmbmxes/getdraft")
    public ResponseEntity<ORMXMBMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxMapping.toDto(ormxmbmxService.getDraft(new ORMXMBMX())));
    }

    @PreAuthorize("hasPermission(this.ormxmbmxService.get(#ormxmbmx_id),'ehr-ORMXMBMX-Update')")
    @ApiOperation(value = "更新项目部明细", tags = {"项目部明细" },  notes = "更新项目部明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormxmbmxes/{ormxmbmx_id}")
    @Transactional
    public ResponseEntity<ORMXMBMXDTO> update(@PathVariable("ormxmbmx_id") String ormxmbmx_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
		ORMXMBMX domain  = ormxmbmxMapping.toDomain(ormxmbmxdto);
        domain .setOrmxmbmxid(ormxmbmx_id);
		ormxmbmxService.update(domain );
		ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmbmxService.getOrmxmbmxByEntities(this.ormxmbmxMapping.toDomain(#ormxmbmxdtos)),'ehr-ORMXMBMX-Update')")
    @ApiOperation(value = "批量更新项目部明细", tags = {"项目部明细" },  notes = "批量更新项目部明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormxmbmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        ormxmbmxService.updateBatch(ormxmbmxMapping.toDomain(ormxmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(returnObject.body),'ehr-ORMXMBMX-Get')")
    @ApiOperation(value = "获取项目部明细", tags = {"项目部明细" },  notes = "获取项目部明细")
	@RequestMapping(method = RequestMethod.GET, value = "/ormxmbmxes/{ormxmbmx_id}")
    public ResponseEntity<ORMXMBMXDTO> get(@PathVariable("ormxmbmx_id") String ormxmbmx_id) {
        ORMXMBMX domain = ormxmbmxService.get(ormxmbmx_id);
        ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "检查项目部明细", tags = {"项目部明细" },  notes = "检查项目部明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ORMXMBMXDTO ormxmbmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.checkKey(ormxmbmxMapping.toDomain(ormxmbmxdto)));
    }

    @PreAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(#ormxmbmxdto),'ehr-ORMXMBMX-Create')")
    @ApiOperation(value = "新建项目部明细", tags = {"项目部明细" },  notes = "新建项目部明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbmxes")
    @Transactional
    public ResponseEntity<ORMXMBMXDTO> create(@RequestBody ORMXMBMXDTO ormxmbmxdto) {
        ORMXMBMX domain = ormxmbmxMapping.toDomain(ormxmbmxdto);
		ormxmbmxService.create(domain);
        ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(#ormxmbmxdtos),'ehr-ORMXMBMX-Create')")
    @ApiOperation(value = "批量新建项目部明细", tags = {"项目部明细" },  notes = "批量新建项目部明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmbmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        ormxmbmxService.createBatch(ormxmbmxMapping.toDomain(ormxmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormxmbmxService.get(#ormxmbmx_id),'ehr-ORMXMBMX-Remove')")
    @ApiOperation(value = "删除项目部明细", tags = {"项目部明细" },  notes = "删除项目部明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormxmbmxes/{ormxmbmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormxmbmx_id") String ormxmbmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.remove(ormxmbmx_id));
    }

    @PreAuthorize("hasPermission(this.ormxmbmxService.getOrmxmbmxByIds(#ids),'ehr-ORMXMBMX-Remove')")
    @ApiOperation(value = "批量删除项目部明细", tags = {"项目部明细" },  notes = "批量删除项目部明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormxmbmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormxmbmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBMX-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"项目部明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmbmxes/fetchdefault")
	public ResponseEntity<List<ORMXMBMXDTO>> fetchDefault(ORMXMBMXSearchContext context) {
        Page<ORMXMBMX> domains = ormxmbmxService.searchDefault(context) ;
        List<ORMXMBMXDTO> list = ormxmbmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBMX-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"项目部明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmbmxes/searchdefault")
	public ResponseEntity<Page<ORMXMBMXDTO>> searchDefault(@RequestBody ORMXMBMXSearchContext context) {
        Page<ORMXMBMX> domains = ormxmbmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmbmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(#ormxmbmxdto),'ehr-ORMXMBMX-Save')")
    @ApiOperation(value = "根据部门管理保存项目部明细", tags = {"项目部明细" },  notes = "根据部门管理保存项目部明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormxmbmxes/save")
    public ResponseEntity<Boolean> saveByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
        ORMXMBMX domain = ormxmbmxMapping.toDomain(ormxmbmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(#ormxmbmxdtos),'ehr-ORMXMBMX-Save')")
    @ApiOperation(value = "根据部门管理批量保存项目部明细", tags = {"项目部明细" },  notes = "根据部门管理批量保存项目部明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormxmbmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        List<ORMXMBMX> domainlist=ormxmbmxMapping.toDomain(ormxmbmxdtos);
        for(ORMXMBMX domain:domainlist){
             domain.setOrmorgsectorid(ormorgsector_id);
        }
        ormxmbmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据部门管理获取项目部明细草稿", tags = {"项目部明细" },  notes = "根据部门管理获取项目部明细草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/ormxmbmxes/getdraft")
    public ResponseEntity<ORMXMBMXDTO> getDraftByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id) {
        ORMXMBMX domain = new ORMXMBMX();
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxMapping.toDto(ormxmbmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.ormxmbmxService.get(#ormxmbmx_id),'ehr-ORMXMBMX-Update')")
    @ApiOperation(value = "根据部门管理更新项目部明细", tags = {"项目部明细" },  notes = "根据部门管理更新项目部明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/ormxmbmxes/{ormxmbmx_id}")
    @Transactional
    public ResponseEntity<ORMXMBMXDTO> updateByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormxmbmx_id") String ormxmbmx_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
        ORMXMBMX domain = ormxmbmxMapping.toDomain(ormxmbmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        domain.setOrmxmbmxid(ormxmbmx_id);
		ormxmbmxService.update(domain);
        ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmbmxService.getOrmxmbmxByEntities(this.ormxmbmxMapping.toDomain(#ormxmbmxdtos)),'ehr-ORMXMBMX-Update')")
    @ApiOperation(value = "根据部门管理批量更新项目部明细", tags = {"项目部明细" },  notes = "根据部门管理批量更新项目部明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/ormxmbmxes/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        List<ORMXMBMX> domainlist=ormxmbmxMapping.toDomain(ormxmbmxdtos);
        for(ORMXMBMX domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        ormxmbmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(returnObject.body),'ehr-ORMXMBMX-Get')")
    @ApiOperation(value = "根据部门管理获取项目部明细", tags = {"项目部明细" },  notes = "根据部门管理获取项目部明细")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/ormxmbmxes/{ormxmbmx_id}")
    public ResponseEntity<ORMXMBMXDTO> getByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormxmbmx_id") String ormxmbmx_id) {
        ORMXMBMX domain = ormxmbmxService.get(ormxmbmx_id);
        ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据部门管理检查项目部明细", tags = {"项目部明细" },  notes = "根据部门管理检查项目部明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormxmbmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.checkKey(ormxmbmxMapping.toDomain(ormxmbmxdto)));
    }

    @PreAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(#ormxmbmxdto),'ehr-ORMXMBMX-Create')")
    @ApiOperation(value = "根据部门管理建立项目部明细", tags = {"项目部明细" },  notes = "根据部门管理建立项目部明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormxmbmxes")
    @Transactional
    public ResponseEntity<ORMXMBMXDTO> createByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
        ORMXMBMX domain = ormxmbmxMapping.toDomain(ormxmbmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
		ormxmbmxService.create(domain);
        ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(#ormxmbmxdtos),'ehr-ORMXMBMX-Create')")
    @ApiOperation(value = "根据部门管理批量建立项目部明细", tags = {"项目部明细" },  notes = "根据部门管理批量建立项目部明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/ormxmbmxes/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        List<ORMXMBMX> domainlist=ormxmbmxMapping.toDomain(ormxmbmxdtos);
        for(ORMXMBMX domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        ormxmbmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormxmbmxService.get(#ormxmbmx_id),'ehr-ORMXMBMX-Remove')")
    @ApiOperation(value = "根据部门管理删除项目部明细", tags = {"项目部明细" },  notes = "根据部门管理删除项目部明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/ormxmbmxes/{ormxmbmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormxmbmx_id") String ormxmbmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.remove(ormxmbmx_id));
    }

    @PreAuthorize("hasPermission(this.ormxmbmxService.getOrmxmbmxByIds(#ids),'ehr-ORMXMBMX-Remove')")
    @ApiOperation(value = "根据部门管理批量删除项目部明细", tags = {"项目部明细" },  notes = "根据部门管理批量删除项目部明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/ormxmbmxes/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgsector(@RequestBody List<String> ids) {
        ormxmbmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBMX-Default-all')")
	@ApiOperation(value = "根据部门管理获取DEFAULT", tags = {"项目部明细" } ,notes = "根据部门管理获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/{ormorgsector_id}/ormxmbmxes/fetchdefault")
	public ResponseEntity<List<ORMXMBMXDTO>> fetchORMXMBMXDefaultByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id,ORMXMBMXSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<ORMXMBMX> domains = ormxmbmxService.searchDefault(context) ;
        List<ORMXMBMXDTO> list = ormxmbmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBMX-Default-all')")
	@ApiOperation(value = "根据部门管理查询DEFAULT", tags = {"项目部明细" } ,notes = "根据部门管理查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/{ormorgsector_id}/ormxmbmxes/searchdefault")
	public ResponseEntity<Page<ORMXMBMXDTO>> searchORMXMBMXDefaultByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMXMBMXSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<ORMXMBMX> domains = ormxmbmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmbmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(#ormxmbmxdto),'ehr-ORMXMBMX-Save')")
    @ApiOperation(value = "根据人员信息保存项目部明细", tags = {"项目部明细" },  notes = "根据人员信息保存项目部明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/ormxmbmxes/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
        ORMXMBMX domain = ormxmbmxMapping.toDomain(ormxmbmxdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(#ormxmbmxdtos),'ehr-ORMXMBMX-Save')")
    @ApiOperation(value = "根据人员信息批量保存项目部明细", tags = {"项目部明细" },  notes = "根据人员信息批量保存项目部明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/ormxmbmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        List<ORMXMBMX> domainlist=ormxmbmxMapping.toDomain(ormxmbmxdtos);
        for(ORMXMBMX domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        ormxmbmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息获取项目部明细草稿", tags = {"项目部明细" },  notes = "根据人员信息获取项目部明细草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/ormxmbmxes/getdraft")
    public ResponseEntity<ORMXMBMXDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        ORMXMBMX domain = new ORMXMBMX();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxMapping.toDto(ormxmbmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.ormxmbmxService.get(#ormxmbmx_id),'ehr-ORMXMBMX-Update')")
    @ApiOperation(value = "根据人员信息更新项目部明细", tags = {"项目部明细" },  notes = "根据人员信息更新项目部明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/ormxmbmxes/{ormxmbmx_id}")
    @Transactional
    public ResponseEntity<ORMXMBMXDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("ormxmbmx_id") String ormxmbmx_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
        ORMXMBMX domain = ormxmbmxMapping.toDomain(ormxmbmxdto);
        domain.setPimpersonid(pimperson_id);
        domain.setOrmxmbmxid(ormxmbmx_id);
		ormxmbmxService.update(domain);
        ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmbmxService.getOrmxmbmxByEntities(this.ormxmbmxMapping.toDomain(#ormxmbmxdtos)),'ehr-ORMXMBMX-Update')")
    @ApiOperation(value = "根据人员信息批量更新项目部明细", tags = {"项目部明细" },  notes = "根据人员信息批量更新项目部明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/ormxmbmxes/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        List<ORMXMBMX> domainlist=ormxmbmxMapping.toDomain(ormxmbmxdtos);
        for(ORMXMBMX domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        ormxmbmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(returnObject.body),'ehr-ORMXMBMX-Get')")
    @ApiOperation(value = "根据人员信息获取项目部明细", tags = {"项目部明细" },  notes = "根据人员信息获取项目部明细")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/ormxmbmxes/{ormxmbmx_id}")
    public ResponseEntity<ORMXMBMXDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("ormxmbmx_id") String ormxmbmx_id) {
        ORMXMBMX domain = ormxmbmxService.get(ormxmbmx_id);
        ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据人员信息检查项目部明细", tags = {"项目部明细" },  notes = "根据人员信息检查项目部明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/ormxmbmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.checkKey(ormxmbmxMapping.toDomain(ormxmbmxdto)));
    }

    @PreAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(#ormxmbmxdto),'ehr-ORMXMBMX-Create')")
    @ApiOperation(value = "根据人员信息建立项目部明细", tags = {"项目部明细" },  notes = "根据人员信息建立项目部明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/ormxmbmxes")
    @Transactional
    public ResponseEntity<ORMXMBMXDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
        ORMXMBMX domain = ormxmbmxMapping.toDomain(ormxmbmxdto);
        domain.setPimpersonid(pimperson_id);
		ormxmbmxService.create(domain);
        ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(#ormxmbmxdtos),'ehr-ORMXMBMX-Create')")
    @ApiOperation(value = "根据人员信息批量建立项目部明细", tags = {"项目部明细" },  notes = "根据人员信息批量建立项目部明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/ormxmbmxes/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        List<ORMXMBMX> domainlist=ormxmbmxMapping.toDomain(ormxmbmxdtos);
        for(ORMXMBMX domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        ormxmbmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormxmbmxService.get(#ormxmbmx_id),'ehr-ORMXMBMX-Remove')")
    @ApiOperation(value = "根据人员信息删除项目部明细", tags = {"项目部明细" },  notes = "根据人员信息删除项目部明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/ormxmbmxes/{ormxmbmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("ormxmbmx_id") String ormxmbmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.remove(ormxmbmx_id));
    }

    @PreAuthorize("hasPermission(this.ormxmbmxService.getOrmxmbmxByIds(#ids),'ehr-ORMXMBMX-Remove')")
    @ApiOperation(value = "根据人员信息批量删除项目部明细", tags = {"项目部明细" },  notes = "根据人员信息批量删除项目部明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/ormxmbmxes/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        ormxmbmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBMX-Default-all')")
	@ApiOperation(value = "根据人员信息获取DEFAULT", tags = {"项目部明细" } ,notes = "根据人员信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/ormxmbmxes/fetchdefault")
	public ResponseEntity<List<ORMXMBMXDTO>> fetchORMXMBMXDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,ORMXMBMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<ORMXMBMX> domains = ormxmbmxService.searchDefault(context) ;
        List<ORMXMBMXDTO> list = ormxmbmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBMX-Default-all')")
	@ApiOperation(value = "根据人员信息查询DEFAULT", tags = {"项目部明细" } ,notes = "根据人员信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/ormxmbmxes/searchdefault")
	public ResponseEntity<Page<ORMXMBMXDTO>> searchORMXMBMXDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ORMXMBMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<ORMXMBMX> domains = ormxmbmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmbmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(#ormxmbmxdto),'ehr-ORMXMBMX-Save')")
    @ApiOperation(value = "根据组织管理部门管理保存项目部明细", tags = {"项目部明细" },  notes = "根据组织管理部门管理保存项目部明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes/save")
    public ResponseEntity<Boolean> saveByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
        ORMXMBMX domain = ormxmbmxMapping.toDomain(ormxmbmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(#ormxmbmxdtos),'ehr-ORMXMBMX-Save')")
    @ApiOperation(value = "根据组织管理部门管理批量保存项目部明细", tags = {"项目部明细" },  notes = "根据组织管理部门管理批量保存项目部明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        List<ORMXMBMX> domainlist=ormxmbmxMapping.toDomain(ormxmbmxdtos);
        for(ORMXMBMX domain:domainlist){
             domain.setOrmorgsectorid(ormorgsector_id);
        }
        ormxmbmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据组织管理部门管理获取项目部明细草稿", tags = {"项目部明细" },  notes = "根据组织管理部门管理获取项目部明细草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes/getdraft")
    public ResponseEntity<ORMXMBMXDTO> getDraftByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id) {
        ORMXMBMX domain = new ORMXMBMX();
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxMapping.toDto(ormxmbmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.ormxmbmxService.get(#ormxmbmx_id),'ehr-ORMXMBMX-Update')")
    @ApiOperation(value = "根据组织管理部门管理更新项目部明细", tags = {"项目部明细" },  notes = "根据组织管理部门管理更新项目部明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes/{ormxmbmx_id}")
    @Transactional
    public ResponseEntity<ORMXMBMXDTO> updateByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormxmbmx_id") String ormxmbmx_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
        ORMXMBMX domain = ormxmbmxMapping.toDomain(ormxmbmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        domain.setOrmxmbmxid(ormxmbmx_id);
		ormxmbmxService.update(domain);
        ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmbmxService.getOrmxmbmxByEntities(this.ormxmbmxMapping.toDomain(#ormxmbmxdtos)),'ehr-ORMXMBMX-Update')")
    @ApiOperation(value = "根据组织管理部门管理批量更新项目部明细", tags = {"项目部明细" },  notes = "根据组织管理部门管理批量更新项目部明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        List<ORMXMBMX> domainlist=ormxmbmxMapping.toDomain(ormxmbmxdtos);
        for(ORMXMBMX domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        ormxmbmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(returnObject.body),'ehr-ORMXMBMX-Get')")
    @ApiOperation(value = "根据组织管理部门管理获取项目部明细", tags = {"项目部明细" },  notes = "根据组织管理部门管理获取项目部明细")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes/{ormxmbmx_id}")
    public ResponseEntity<ORMXMBMXDTO> getByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormxmbmx_id") String ormxmbmx_id) {
        ORMXMBMX domain = ormxmbmxService.get(ormxmbmx_id);
        ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据组织管理部门管理检查项目部明细", tags = {"项目部明细" },  notes = "根据组织管理部门管理检查项目部明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.checkKey(ormxmbmxMapping.toDomain(ormxmbmxdto)));
    }

    @PreAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(#ormxmbmxdto),'ehr-ORMXMBMX-Create')")
    @ApiOperation(value = "根据组织管理部门管理建立项目部明细", tags = {"项目部明细" },  notes = "根据组织管理部门管理建立项目部明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes")
    @Transactional
    public ResponseEntity<ORMXMBMXDTO> createByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMXMBMXDTO ormxmbmxdto) {
        ORMXMBMX domain = ormxmbmxMapping.toDomain(ormxmbmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
		ormxmbmxService.create(domain);
        ORMXMBMXDTO dto = ormxmbmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmbmxMapping.toDomain(#ormxmbmxdtos),'ehr-ORMXMBMX-Create')")
    @ApiOperation(value = "根据组织管理部门管理批量建立项目部明细", tags = {"项目部明细" },  notes = "根据组织管理部门管理批量建立项目部明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ORMXMBMXDTO> ormxmbmxdtos) {
        List<ORMXMBMX> domainlist=ormxmbmxMapping.toDomain(ormxmbmxdtos);
        for(ORMXMBMX domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        ormxmbmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormxmbmxService.get(#ormxmbmx_id),'ehr-ORMXMBMX-Remove')")
    @ApiOperation(value = "根据组织管理部门管理删除项目部明细", tags = {"项目部明细" },  notes = "根据组织管理部门管理删除项目部明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes/{ormxmbmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("ormxmbmx_id") String ormxmbmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ormxmbmxService.remove(ormxmbmx_id));
    }

    @PreAuthorize("hasPermission(this.ormxmbmxService.getOrmxmbmxByIds(#ids),'ehr-ORMXMBMX-Remove')")
    @ApiOperation(value = "根据组织管理部门管理批量删除项目部明细", tags = {"项目部明细" },  notes = "根据组织管理部门管理批量删除项目部明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgOrmOrgsector(@RequestBody List<String> ids) {
        ormxmbmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBMX-Default-all')")
	@ApiOperation(value = "根据组织管理部门管理获取DEFAULT", tags = {"项目部明细" } ,notes = "根据组织管理部门管理获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes/fetchdefault")
	public ResponseEntity<List<ORMXMBMXDTO>> fetchORMXMBMXDefaultByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id,ORMXMBMXSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<ORMXMBMX> domains = ormxmbmxService.searchDefault(context) ;
        List<ORMXMBMXDTO> list = ormxmbmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMBMX-Default-all')")
	@ApiOperation(value = "根据组织管理部门管理查询DEFAULT", tags = {"项目部明细" } ,notes = "根据组织管理部门管理查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/ormxmbmxes/searchdefault")
	public ResponseEntity<Page<ORMXMBMXDTO>> searchORMXMBMXDefaultByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ORMXMBMXSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<ORMXMBMX> domains = ormxmbmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmbmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

