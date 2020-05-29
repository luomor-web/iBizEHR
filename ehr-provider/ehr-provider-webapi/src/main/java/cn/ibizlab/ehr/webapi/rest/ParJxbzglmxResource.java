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
import cn.ibizlab.ehr.core.par.domain.ParJxbzglmx;
import cn.ibizlab.ehr.core.par.service.IParJxbzglmxService;
import cn.ibizlab.ehr.core.par.filter.ParJxbzglmxSearchContext;

@Slf4j
@Api(tags = {"绩效标准管理明细" })
@RestController("WebApi-parjxbzglmx")
@RequestMapping("")
public class ParJxbzglmxResource {

    @Autowired
    public IParJxbzglmxService parjxbzglmxService;

    @Autowired
    @Lazy
    public ParJxbzglmxMapping parjxbzglmxMapping;

    @PreAuthorize("hasPermission(this.parjxbzglmxService.get(#parjxbzglmx_id),'ehr-ParJxbzglmx-Update')")
    @ApiOperation(value = "更新绩效标准管理明细", tags = {"绩效标准管理明细" },  notes = "更新绩效标准管理明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxbzglmxes/{parjxbzglmx_id}")
    @Transactional
    public ResponseEntity<ParJxbzglmxDTO> update(@PathVariable("parjxbzglmx_id") String parjxbzglmx_id, @RequestBody ParJxbzglmxDTO parjxbzglmxdto) {
		ParJxbzglmx domain  = parjxbzglmxMapping.toDomain(parjxbzglmxdto);
        domain .setParjxbzglmxid(parjxbzglmx_id);
		parjxbzglmxService.update(domain );
		ParJxbzglmxDTO dto = parjxbzglmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxService.getParjxbzglmxByEntities(this.parjxbzglmxMapping.toDomain(#parjxbzglmxdtos)),'ehr-ParJxbzglmx-Update')")
    @ApiOperation(value = "批量更新绩效标准管理明细", tags = {"绩效标准管理明细" },  notes = "批量更新绩效标准管理明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxbzglmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParJxbzglmxDTO> parjxbzglmxdtos) {
        parjxbzglmxService.updateBatch(parjxbzglmxMapping.toDomain(parjxbzglmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxMapping.toDomain(#parjxbzglmxdto),'ehr-ParJxbzglmx-Save')")
    @ApiOperation(value = "保存绩效标准管理明细", tags = {"绩效标准管理明细" },  notes = "保存绩效标准管理明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzglmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody ParJxbzglmxDTO parjxbzglmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parjxbzglmxService.save(parjxbzglmxMapping.toDomain(parjxbzglmxdto)));
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxMapping.toDomain(#parjxbzglmxdtos),'ehr-ParJxbzglmx-Save')")
    @ApiOperation(value = "批量保存绩效标准管理明细", tags = {"绩效标准管理明细" },  notes = "批量保存绩效标准管理明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzglmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParJxbzglmxDTO> parjxbzglmxdtos) {
        parjxbzglmxService.saveBatch(parjxbzglmxMapping.toDomain(parjxbzglmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parjxbzglmxMapping.toDomain(returnObject.body),'ehr-ParJxbzglmx-Get')")
    @ApiOperation(value = "获取绩效标准管理明细", tags = {"绩效标准管理明细" },  notes = "获取绩效标准管理明细")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxbzglmxes/{parjxbzglmx_id}")
    public ResponseEntity<ParJxbzglmxDTO> get(@PathVariable("parjxbzglmx_id") String parjxbzglmx_id) {
        ParJxbzglmx domain = parjxbzglmxService.get(parjxbzglmx_id);
        ParJxbzglmxDTO dto = parjxbzglmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxService.get(#parjxbzglmx_id),'ehr-ParJxbzglmx-Remove')")
    @ApiOperation(value = "删除绩效标准管理明细", tags = {"绩效标准管理明细" },  notes = "删除绩效标准管理明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxbzglmxes/{parjxbzglmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parjxbzglmx_id") String parjxbzglmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parjxbzglmxService.remove(parjxbzglmx_id));
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxService.getParjxbzglmxByIds(#ids),'ehr-ParJxbzglmx-Remove')")
    @ApiOperation(value = "批量删除绩效标准管理明细", tags = {"绩效标准管理明细" },  notes = "批量删除绩效标准管理明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxbzglmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parjxbzglmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxMapping.toDomain(#parjxbzglmxdto),'ehr-ParJxbzglmx-Create')")
    @ApiOperation(value = "新建绩效标准管理明细", tags = {"绩效标准管理明细" },  notes = "新建绩效标准管理明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzglmxes")
    @Transactional
    public ResponseEntity<ParJxbzglmxDTO> create(@RequestBody ParJxbzglmxDTO parjxbzglmxdto) {
        ParJxbzglmx domain = parjxbzglmxMapping.toDomain(parjxbzglmxdto);
		parjxbzglmxService.create(domain);
        ParJxbzglmxDTO dto = parjxbzglmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxMapping.toDomain(#parjxbzglmxdtos),'ehr-ParJxbzglmx-Create')")
    @ApiOperation(value = "批量新建绩效标准管理明细", tags = {"绩效标准管理明细" },  notes = "批量新建绩效标准管理明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzglmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParJxbzglmxDTO> parjxbzglmxdtos) {
        parjxbzglmxService.createBatch(parjxbzglmxMapping.toDomain(parjxbzglmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取绩效标准管理明细草稿", tags = {"绩效标准管理明细" },  notes = "获取绩效标准管理明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxbzglmxes/getdraft")
    public ResponseEntity<ParJxbzglmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parjxbzglmxMapping.toDto(parjxbzglmxService.getDraft(new ParJxbzglmx())));
    }

    @ApiOperation(value = "检查绩效标准管理明细", tags = {"绩效标准管理明细" },  notes = "检查绩效标准管理明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzglmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParJxbzglmxDTO parjxbzglmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parjxbzglmxService.checkKey(parjxbzglmxMapping.toDomain(parjxbzglmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJxbzglmx-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"绩效标准管理明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parjxbzglmxes/fetchdefault")
	public ResponseEntity<List<ParJxbzglmxDTO>> fetchDefault(ParJxbzglmxSearchContext context) {
        Page<ParJxbzglmx> domains = parjxbzglmxService.searchDefault(context) ;
        List<ParJxbzglmxDTO> list = parjxbzglmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJxbzglmx-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"绩效标准管理明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parjxbzglmxes/searchdefault")
	public ResponseEntity<Page<ParJxbzglmxDTO>> searchDefault(@RequestBody ParJxbzglmxSearchContext context) {
        Page<ParJxbzglmx> domains = parjxbzglmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjxbzglmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.parjxbzglmxService.get(#parjxbzglmx_id),'ehr-ParJxbzglmx-Update')")
    @ApiOperation(value = "根据绩效标准管理更新绩效标准管理明细", tags = {"绩效标准管理明细" },  notes = "根据绩效标准管理更新绩效标准管理明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxbzgls/{parjxbzgl_id}/parjxbzglmxes/{parjxbzglmx_id}")
    @Transactional
    public ResponseEntity<ParJxbzglmxDTO> updateByParJxbzgl(@PathVariable("parjxbzgl_id") String parjxbzgl_id, @PathVariable("parjxbzglmx_id") String parjxbzglmx_id, @RequestBody ParJxbzglmxDTO parjxbzglmxdto) {
        ParJxbzglmx domain = parjxbzglmxMapping.toDomain(parjxbzglmxdto);
        domain.setParjxbzglid(parjxbzgl_id);
        domain.setParjxbzglmxid(parjxbzglmx_id);
		parjxbzglmxService.update(domain);
        ParJxbzglmxDTO dto = parjxbzglmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxService.getParjxbzglmxByEntities(this.parjxbzglmxMapping.toDomain(#parjxbzglmxdtos)),'ehr-ParJxbzglmx-Update')")
    @ApiOperation(value = "根据绩效标准管理批量更新绩效标准管理明细", tags = {"绩效标准管理明细" },  notes = "根据绩效标准管理批量更新绩效标准管理明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxbzgls/{parjxbzgl_id}/parjxbzglmxes/batch")
    public ResponseEntity<Boolean> updateBatchByParJxbzgl(@PathVariable("parjxbzgl_id") String parjxbzgl_id, @RequestBody List<ParJxbzglmxDTO> parjxbzglmxdtos) {
        List<ParJxbzglmx> domainlist=parjxbzglmxMapping.toDomain(parjxbzglmxdtos);
        for(ParJxbzglmx domain:domainlist){
            domain.setParjxbzglid(parjxbzgl_id);
        }
        parjxbzglmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxMapping.toDomain(#parjxbzglmxdto),'ehr-ParJxbzglmx-Save')")
    @ApiOperation(value = "根据绩效标准管理保存绩效标准管理明细", tags = {"绩效标准管理明细" },  notes = "根据绩效标准管理保存绩效标准管理明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzgls/{parjxbzgl_id}/parjxbzglmxes/save")
    public ResponseEntity<Boolean> saveByParJxbzgl(@PathVariable("parjxbzgl_id") String parjxbzgl_id, @RequestBody ParJxbzglmxDTO parjxbzglmxdto) {
        ParJxbzglmx domain = parjxbzglmxMapping.toDomain(parjxbzglmxdto);
        domain.setParjxbzglid(parjxbzgl_id);
        return ResponseEntity.status(HttpStatus.OK).body(parjxbzglmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxMapping.toDomain(#parjxbzglmxdtos),'ehr-ParJxbzglmx-Save')")
    @ApiOperation(value = "根据绩效标准管理批量保存绩效标准管理明细", tags = {"绩效标准管理明细" },  notes = "根据绩效标准管理批量保存绩效标准管理明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzgls/{parjxbzgl_id}/parjxbzglmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByParJxbzgl(@PathVariable("parjxbzgl_id") String parjxbzgl_id, @RequestBody List<ParJxbzglmxDTO> parjxbzglmxdtos) {
        List<ParJxbzglmx> domainlist=parjxbzglmxMapping.toDomain(parjxbzglmxdtos);
        for(ParJxbzglmx domain:domainlist){
             domain.setParjxbzglid(parjxbzgl_id);
        }
        parjxbzglmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parjxbzglmxMapping.toDomain(returnObject.body),'ehr-ParJxbzglmx-Get')")
    @ApiOperation(value = "根据绩效标准管理获取绩效标准管理明细", tags = {"绩效标准管理明细" },  notes = "根据绩效标准管理获取绩效标准管理明细")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxbzgls/{parjxbzgl_id}/parjxbzglmxes/{parjxbzglmx_id}")
    public ResponseEntity<ParJxbzglmxDTO> getByParJxbzgl(@PathVariable("parjxbzgl_id") String parjxbzgl_id, @PathVariable("parjxbzglmx_id") String parjxbzglmx_id) {
        ParJxbzglmx domain = parjxbzglmxService.get(parjxbzglmx_id);
        ParJxbzglmxDTO dto = parjxbzglmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxService.get(#parjxbzglmx_id),'ehr-ParJxbzglmx-Remove')")
    @ApiOperation(value = "根据绩效标准管理删除绩效标准管理明细", tags = {"绩效标准管理明细" },  notes = "根据绩效标准管理删除绩效标准管理明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxbzgls/{parjxbzgl_id}/parjxbzglmxes/{parjxbzglmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByParJxbzgl(@PathVariable("parjxbzgl_id") String parjxbzgl_id, @PathVariable("parjxbzglmx_id") String parjxbzglmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(parjxbzglmxService.remove(parjxbzglmx_id));
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxService.getParjxbzglmxByIds(#ids),'ehr-ParJxbzglmx-Remove')")
    @ApiOperation(value = "根据绩效标准管理批量删除绩效标准管理明细", tags = {"绩效标准管理明细" },  notes = "根据绩效标准管理批量删除绩效标准管理明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxbzgls/{parjxbzgl_id}/parjxbzglmxes/batch")
    public ResponseEntity<Boolean> removeBatchByParJxbzgl(@RequestBody List<String> ids) {
        parjxbzglmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxMapping.toDomain(#parjxbzglmxdto),'ehr-ParJxbzglmx-Create')")
    @ApiOperation(value = "根据绩效标准管理建立绩效标准管理明细", tags = {"绩效标准管理明细" },  notes = "根据绩效标准管理建立绩效标准管理明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzgls/{parjxbzgl_id}/parjxbzglmxes")
    @Transactional
    public ResponseEntity<ParJxbzglmxDTO> createByParJxbzgl(@PathVariable("parjxbzgl_id") String parjxbzgl_id, @RequestBody ParJxbzglmxDTO parjxbzglmxdto) {
        ParJxbzglmx domain = parjxbzglmxMapping.toDomain(parjxbzglmxdto);
        domain.setParjxbzglid(parjxbzgl_id);
		parjxbzglmxService.create(domain);
        ParJxbzglmxDTO dto = parjxbzglmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxMapping.toDomain(#parjxbzglmxdtos),'ehr-ParJxbzglmx-Create')")
    @ApiOperation(value = "根据绩效标准管理批量建立绩效标准管理明细", tags = {"绩效标准管理明细" },  notes = "根据绩效标准管理批量建立绩效标准管理明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzgls/{parjxbzgl_id}/parjxbzglmxes/batch")
    public ResponseEntity<Boolean> createBatchByParJxbzgl(@PathVariable("parjxbzgl_id") String parjxbzgl_id, @RequestBody List<ParJxbzglmxDTO> parjxbzglmxdtos) {
        List<ParJxbzglmx> domainlist=parjxbzglmxMapping.toDomain(parjxbzglmxdtos);
        for(ParJxbzglmx domain:domainlist){
            domain.setParjxbzglid(parjxbzgl_id);
        }
        parjxbzglmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据绩效标准管理获取绩效标准管理明细草稿", tags = {"绩效标准管理明细" },  notes = "根据绩效标准管理获取绩效标准管理明细草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/parjxbzgls/{parjxbzgl_id}/parjxbzglmxes/getdraft")
    public ResponseEntity<ParJxbzglmxDTO> getDraftByParJxbzgl(@PathVariable("parjxbzgl_id") String parjxbzgl_id) {
        ParJxbzglmx domain = new ParJxbzglmx();
        domain.setParjxbzglid(parjxbzgl_id);
        return ResponseEntity.status(HttpStatus.OK).body(parjxbzglmxMapping.toDto(parjxbzglmxService.getDraft(domain)));
    }

    @ApiOperation(value = "根据绩效标准管理检查绩效标准管理明细", tags = {"绩效标准管理明细" },  notes = "根据绩效标准管理检查绩效标准管理明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxbzgls/{parjxbzgl_id}/parjxbzglmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByParJxbzgl(@PathVariable("parjxbzgl_id") String parjxbzgl_id, @RequestBody ParJxbzglmxDTO parjxbzglmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parjxbzglmxService.checkKey(parjxbzglmxMapping.toDomain(parjxbzglmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJxbzglmx-Default-all')")
	@ApiOperation(value = "根据绩效标准管理获取DEFAULT", tags = {"绩效标准管理明细" } ,notes = "根据绩效标准管理获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parjxbzgls/{parjxbzgl_id}/parjxbzglmxes/fetchdefault")
	public ResponseEntity<List<ParJxbzglmxDTO>> fetchParJxbzglmxDefaultByParJxbzgl(@PathVariable("parjxbzgl_id") String parjxbzgl_id,ParJxbzglmxSearchContext context) {
        context.setN_parjxbzglid_eq(parjxbzgl_id);
        Page<ParJxbzglmx> domains = parjxbzglmxService.searchDefault(context) ;
        List<ParJxbzglmxDTO> list = parjxbzglmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJxbzglmx-Default-all')")
	@ApiOperation(value = "根据绩效标准管理查询DEFAULT", tags = {"绩效标准管理明细" } ,notes = "根据绩效标准管理查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parjxbzgls/{parjxbzgl_id}/parjxbzglmxes/searchdefault")
	public ResponseEntity<Page<ParJxbzglmxDTO>> searchParJxbzglmxDefaultByParJxbzgl(@PathVariable("parjxbzgl_id") String parjxbzgl_id, @RequestBody ParJxbzglmxSearchContext context) {
        context.setN_parjxbzglid_eq(parjxbzgl_id);
        Page<ParJxbzglmx> domains = parjxbzglmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjxbzglmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.parjxbzglmxService.get(#parjxbzglmx_id),'ehr-ParJxbzglmx-Update')")
    @ApiOperation(value = "根据人员信息更新绩效标准管理明细", tags = {"绩效标准管理明细" },  notes = "根据人员信息更新绩效标准管理明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/parjxbzglmxes/{parjxbzglmx_id}")
    @Transactional
    public ResponseEntity<ParJxbzglmxDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("parjxbzglmx_id") String parjxbzglmx_id, @RequestBody ParJxbzglmxDTO parjxbzglmxdto) {
        ParJxbzglmx domain = parjxbzglmxMapping.toDomain(parjxbzglmxdto);
        domain.setPimpersonid(pimperson_id);
        domain.setParjxbzglmxid(parjxbzglmx_id);
		parjxbzglmxService.update(domain);
        ParJxbzglmxDTO dto = parjxbzglmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxService.getParjxbzglmxByEntities(this.parjxbzglmxMapping.toDomain(#parjxbzglmxdtos)),'ehr-ParJxbzglmx-Update')")
    @ApiOperation(value = "根据人员信息批量更新绩效标准管理明细", tags = {"绩效标准管理明细" },  notes = "根据人员信息批量更新绩效标准管理明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/parjxbzglmxes/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<ParJxbzglmxDTO> parjxbzglmxdtos) {
        List<ParJxbzglmx> domainlist=parjxbzglmxMapping.toDomain(parjxbzglmxdtos);
        for(ParJxbzglmx domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        parjxbzglmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxMapping.toDomain(#parjxbzglmxdto),'ehr-ParJxbzglmx-Save')")
    @ApiOperation(value = "根据人员信息保存绩效标准管理明细", tags = {"绩效标准管理明细" },  notes = "根据人员信息保存绩效标准管理明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/parjxbzglmxes/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ParJxbzglmxDTO parjxbzglmxdto) {
        ParJxbzglmx domain = parjxbzglmxMapping.toDomain(parjxbzglmxdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(parjxbzglmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxMapping.toDomain(#parjxbzglmxdtos),'ehr-ParJxbzglmx-Save')")
    @ApiOperation(value = "根据人员信息批量保存绩效标准管理明细", tags = {"绩效标准管理明细" },  notes = "根据人员信息批量保存绩效标准管理明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/parjxbzglmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<ParJxbzglmxDTO> parjxbzglmxdtos) {
        List<ParJxbzglmx> domainlist=parjxbzglmxMapping.toDomain(parjxbzglmxdtos);
        for(ParJxbzglmx domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        parjxbzglmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parjxbzglmxMapping.toDomain(returnObject.body),'ehr-ParJxbzglmx-Get')")
    @ApiOperation(value = "根据人员信息获取绩效标准管理明细", tags = {"绩效标准管理明细" },  notes = "根据人员信息获取绩效标准管理明细")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/parjxbzglmxes/{parjxbzglmx_id}")
    public ResponseEntity<ParJxbzglmxDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("parjxbzglmx_id") String parjxbzglmx_id) {
        ParJxbzglmx domain = parjxbzglmxService.get(parjxbzglmx_id);
        ParJxbzglmxDTO dto = parjxbzglmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxService.get(#parjxbzglmx_id),'ehr-ParJxbzglmx-Remove')")
    @ApiOperation(value = "根据人员信息删除绩效标准管理明细", tags = {"绩效标准管理明细" },  notes = "根据人员信息删除绩效标准管理明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/parjxbzglmxes/{parjxbzglmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("parjxbzglmx_id") String parjxbzglmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(parjxbzglmxService.remove(parjxbzglmx_id));
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxService.getParjxbzglmxByIds(#ids),'ehr-ParJxbzglmx-Remove')")
    @ApiOperation(value = "根据人员信息批量删除绩效标准管理明细", tags = {"绩效标准管理明细" },  notes = "根据人员信息批量删除绩效标准管理明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/parjxbzglmxes/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        parjxbzglmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxMapping.toDomain(#parjxbzglmxdto),'ehr-ParJxbzglmx-Create')")
    @ApiOperation(value = "根据人员信息建立绩效标准管理明细", tags = {"绩效标准管理明细" },  notes = "根据人员信息建立绩效标准管理明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/parjxbzglmxes")
    @Transactional
    public ResponseEntity<ParJxbzglmxDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ParJxbzglmxDTO parjxbzglmxdto) {
        ParJxbzglmx domain = parjxbzglmxMapping.toDomain(parjxbzglmxdto);
        domain.setPimpersonid(pimperson_id);
		parjxbzglmxService.create(domain);
        ParJxbzglmxDTO dto = parjxbzglmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxbzglmxMapping.toDomain(#parjxbzglmxdtos),'ehr-ParJxbzglmx-Create')")
    @ApiOperation(value = "根据人员信息批量建立绩效标准管理明细", tags = {"绩效标准管理明细" },  notes = "根据人员信息批量建立绩效标准管理明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/parjxbzglmxes/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<ParJxbzglmxDTO> parjxbzglmxdtos) {
        List<ParJxbzglmx> domainlist=parjxbzglmxMapping.toDomain(parjxbzglmxdtos);
        for(ParJxbzglmx domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        parjxbzglmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息获取绩效标准管理明细草稿", tags = {"绩效标准管理明细" },  notes = "根据人员信息获取绩效标准管理明细草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/parjxbzglmxes/getdraft")
    public ResponseEntity<ParJxbzglmxDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        ParJxbzglmx domain = new ParJxbzglmx();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(parjxbzglmxMapping.toDto(parjxbzglmxService.getDraft(domain)));
    }

    @ApiOperation(value = "根据人员信息检查绩效标准管理明细", tags = {"绩效标准管理明细" },  notes = "根据人员信息检查绩效标准管理明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/parjxbzglmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ParJxbzglmxDTO parjxbzglmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parjxbzglmxService.checkKey(parjxbzglmxMapping.toDomain(parjxbzglmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJxbzglmx-Default-all')")
	@ApiOperation(value = "根据人员信息获取DEFAULT", tags = {"绩效标准管理明细" } ,notes = "根据人员信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/parjxbzglmxes/fetchdefault")
	public ResponseEntity<List<ParJxbzglmxDTO>> fetchParJxbzglmxDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,ParJxbzglmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<ParJxbzglmx> domains = parjxbzglmxService.searchDefault(context) ;
        List<ParJxbzglmxDTO> list = parjxbzglmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJxbzglmx-Default-all')")
	@ApiOperation(value = "根据人员信息查询DEFAULT", tags = {"绩效标准管理明细" } ,notes = "根据人员信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/parjxbzglmxes/searchdefault")
	public ResponseEntity<Page<ParJxbzglmxDTO>> searchParJxbzglmxDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody ParJxbzglmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<ParJxbzglmx> domains = parjxbzglmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjxbzglmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

